package gov.omsb.level.types.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
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
import gov.omsb.level.types.web.constants.OmsbLevelTypesWebPortletKeys;
import gov.omsb.level.types.web.portlet.util.OmsbLevelTypeUtil;
import gov.omsb.tms.model.LevelTypeMaster;
import gov.omsb.tms.service.LevelTypeMasterLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLevelTypesWebPortletKeys.OMSBLEVELTYPESWEB,
"mvc.command.name=" + OmsbLevelTypesWebPortletKeys.SAVE_LEVEL_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveLevelTypeMVCActionCommand implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long levelTypeMasterId = ParamUtil.getLong(actionRequest, OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_MASTER_ID, 0);
		if(levelTypeMasterId != 0) {
			// Update Level Type Master
			isSuccess =  updateLevelTypeMaster(actionRequest, levelTypeMasterId, themeDisplay);
		} else {
			// Create Level Type Master
			isSuccess = createLevelTypeMaster(actionRequest, themeDisplay);
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}


	/**
	 * 
	 * @param actionRequest
	 * @param levelTypeMasterId
	 * @param themeDisplay
	 * @return
	 */
	private boolean updateLevelTypeMaster(ActionRequest actionRequest, long levelTypeMasterId, ThemeDisplay themeDisplay) {
		LevelTypeMaster levelTypeMaster = levelTypeMasterLocalService.fetchLevelTypeMaster(levelTypeMasterId);
		if(Validator.isNotNull(levelTypeMaster)) {
			
			// validate LevelType
			if (!validateLevelType(actionRequest, levelTypeMaster)) {
				return Boolean.FALSE;
			}

			levelTypeMasterLocalService.updateLevelTypeMaster(OmsbLevelTypeUtil.createLevelTypeMasterObject(actionRequest, levelTypeMaster, Boolean.FALSE, themeDisplay));
			_logger.info("updateLevelTypeMaster ::: Level Type Master Record Updated");
		} else {
			_logger.info("updateLevelTypeMaster ::: Level Type Master Record Not Found " + levelTypeMasterId);
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
	private boolean createLevelTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		long levelTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			
			// validate LevelType
			if (!validateLevelType(actionRequest, null)) {
				return Boolean.FALSE;
			}
			
			LevelTypeMaster levelTypeMaster = levelTypeMasterLocalService.createLevelTypeMaster(levelTypeMasterId);
			levelTypeMasterLocalService.addLevelTypeMaster(OmsbLevelTypeUtil.createLevelTypeMasterObject(actionRequest, levelTypeMaster, Boolean.TRUE, themeDisplay));
			_logger.info("createLevelTypeMaster ::: Level Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;		
	}

	
	/**
	 * 
	 * @param actionRequest
	 * @param levelTypeMaster
	 * @return
	 */
	private boolean validateLevelType(ActionRequest actionRequest, LevelTypeMaster levelTypeMaster) {
		boolean isValid = Boolean.TRUE;
		List<String> levelTypeNames = new ArrayList<>();
		Map<Locale, String> levelTypeNameMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_NAME);
		addLocalizedValue(levelTypeNameMap, levelTypeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(levelTypeNameMap, levelTypeNames, CommonConstants.LANGUAGE_CODE_ARABIC);
		if(checkLevelTypeNames(levelTypeNames,actionRequest,levelTypeMaster)) {
			isValid = Boolean.FALSE;
		}
		return isValid;
	}

	
	/**
	 * 
	 * @param localizationMap
	 * @param values
	 * @param languageCode
	 */
	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	
	/**
	 * 
	 * @param levelTypeNames
	 * @param actionRequest
	 * @param levelTypeMaster
	 * @return
	 */
	private boolean checkLevelTypeNames(List<String> levelTypeNames, ActionRequest actionRequest,
			LevelTypeMaster levelTypeMaster) {
		List<LevelTypeMaster> levelTypeMasters;
		for (String levelTypeName : levelTypeNames) {
			String likeLevelTypeName = StringPool.PERCENT + StringPool.GREATER_THAN + levelTypeName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			levelTypeMasters = new ArrayList<>(levelTypeMasterLocalService.findByLevelTypeNameByLike(likeLevelTypeName));
			if (Validator.isNotNull(levelTypeMaster) && levelTypeMasters.contains(levelTypeMaster)) {
				levelTypeMasters.remove(levelTypeMaster);
			}
			if (!levelTypeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbLevelTypesWebPortletKeys.LEVEL_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	
	@Reference
	private LevelTypeMasterLocalService levelTypeMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveLevelTypeMVCActionCommand.class);

}
