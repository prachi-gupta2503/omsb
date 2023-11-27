package gov.omsb.rotation.type.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.rotation.type.web.constants.OmsbRotationTypeWebPortletKeys;
import gov.omsb.rotation.type.web.portlet.util.OmsbRotationTypeUtil;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.service.RotationTypeMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationTypeWebPortletKeys.OMSBROTATIONTYPEWEB,
"mvc.command.name=" + OmsbRotationTypeWebPortletKeys.SAVE_ROTATION_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveRotationTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long rotationTypeMasterId = ParamUtil.getLong(actionRequest, OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_MASTER_ID, 0);
		
		try {
			if(rotationTypeMasterId != 0) {
				// Update Rotation Type Master
				isSuccess =  updateRotationTypeMaster(actionRequest, rotationTypeMasterId, themeDisplay);
			} else {
				// Create Rotation Type Master
				isSuccess = createRotationTypeMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param rotationTypeMasterId
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	private boolean updateRotationTypeMaster(ActionRequest actionRequest, long rotationTypeMasterId, ThemeDisplay themeDisplay)
			throws PortalException {
		RotationTypeMaster rotationTypeMaster = rotationTypeMasterLocalService.getRotationTypeMaster(rotationTypeMasterId);
		if(Validator.isNotNull(rotationTypeMaster)) {
			
			// check for duplicate rotation type name
			if (!validateProgram(actionRequest, rotationTypeMaster)) {
				return false;
			}
			
			// update rotation type
			rotationTypeMasterLocalService.updateRotationTypeMaster(OmsbRotationTypeUtil.createRotationTypeMasterObject(actionRequest, rotationTypeMaster, Boolean.FALSE, themeDisplay));
			_logger.debug("updateRotationTypeMaster ::: Rotation Type Master Record Updated");
		} else {
			_logger.debug("updateRotationTypeMaster ::: Rotation Type Master Record Not Found " + rotationTypeMasterId);
			return false;
		}
		return true;
		
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private boolean createRotationTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		
		// check for duplicate rotation type name
		if (!validateProgram(actionRequest, null)) {
			return false;
		}
		
		// create rotation type
		long rotationTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			RotationTypeMaster rotationTypeMaster = rotationTypeMasterLocalService.createRotationTypeMaster(rotationTypeMasterId);
			rotationTypeMasterLocalService.addRotationTypeMaster(OmsbRotationTypeUtil.createRotationTypeMasterObject(actionRequest, rotationTypeMaster, Boolean.TRUE, themeDisplay));
			_logger.debug("createRotationTypeMaster ::: Rotation Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}
	
	private boolean validateProgram(ActionRequest actionRequest, RotationTypeMaster rotationTypeMaster) {
		List<String> rotationTypeNames = new ArrayList<>();
		boolean isValid = true;

		//getting value with multiple language
		Map<Locale, String> rotationTypeNameMap = LocalizationUtil.getLocalizationMap(actionRequest,OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_NAME);
		addLocalizedValue(rotationTypeNameMap, rotationTypeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(rotationTypeNameMap, rotationTypeNames, CommonConstants.LANGUAGE_CODE_ARABIC);
		
		//check for duplicate name with diffrent language
		if (checkRotationTypeNames(rotationTypeNames, actionRequest, rotationTypeMaster)) {
			isValid = false;
		}

		return isValid;
	}
	
	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		//Adding values by language
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}
	
	private boolean checkRotationTypeNames(List<String> rotationTypeNames, ActionRequest actionRequest,
			RotationTypeMaster rotationTypeMaster) {
		List<RotationTypeMaster> rotationMasters;
		for (String rotationTypeName : rotationTypeNames) {
			String likerotationTypeName = StringPool.PERCENT + StringPool.GREATER_THAN + rotationTypeName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			//Finding the value
			rotationMasters = new ArrayList<>(rotationTypeMasterLocalService.findByRotationNameByLike(likerotationTypeName));
			if (Validator.isNotNull(rotationTypeMaster) && rotationMasters.contains(rotationTypeMaster)) {
				rotationMasters.remove(rotationTypeMaster);
			}
			if (!rotationMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbRotationTypeWebPortletKeys.ROTATION_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveRotationTypeMVCActionCommand.class.getName());

}
