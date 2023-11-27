package gov.omsb.visit.types.web.portlet.mvccommands;

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
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.visit.types.web.constants.OmsbVisitTypesWebPortletKeys;
import gov.omsb.visit.types.web.portlet.util.OmsbVisitTypeUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVisitTypesWebPortletKeys.OMSBVISITTYPESWEB,
		"mvc.command.name="
				+ OmsbVisitTypesWebPortletKeys.SAVE_VISIT_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveVisitTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long visitTypeMasterId = ParamUtil.getLong(actionRequest, OmsbVisitTypesWebPortletKeys.VISIT_TYPE_MASTER_ID, 0);

		try {
			if (visitTypeMasterId != 0) {
				// Update Visit Type Master
				isSuccess = updateVisitTypeMaster(actionRequest, visitTypeMasterId, themeDisplay);
			} else {
				// Create Visit Type Master
				isSuccess = createVisitTypeMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	/**
	 * @param actionRequest
	 * @param visitTypeMasterId
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	private boolean updateVisitTypeMaster(ActionRequest actionRequest, long visitTypeMasterId,
			ThemeDisplay themeDisplay) throws PortalException {
		VisitTypeMaster visitTypesMaster = visitTypeMasterLocalService.getVisitTypeMaster(visitTypeMasterId);
		if (Validator.isNotNull(visitTypesMaster)) {
			if (!validateVisitType(actionRequest, visitTypesMaster)) {
				return false;
			}
			visitTypeMasterLocalService.updateVisitTypeMaster(OmsbVisitTypeUtil
					.createVisitTypeMasterObject(actionRequest, visitTypesMaster, Boolean.FALSE, themeDisplay));
			_logger.debug("updateVisitTypeMaster ::: Visit Type Master Record Updated");
		} else {
			_logger.debug("updateVisitTypeMaster ::: Visit Type Master Record Not Found " + visitTypeMasterId);
			return false;
		}
		return true;

	}

	/**
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private boolean createVisitTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		long visitTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			if (!validateVisitType(actionRequest, null)) {
				return false;
			}
			VisitTypeMaster visitTypeMaster = visitTypeMasterLocalService.createVisitTypeMaster(visitTypeMasterId);
			visitTypeMasterLocalService.addVisitTypeMaster(OmsbVisitTypeUtil.createVisitTypeMasterObject(actionRequest,
					visitTypeMaster, Boolean.TRUE, themeDisplay));
			_logger.debug("createVisitTypeMaster ::: Visit Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean validateVisitType(ActionRequest actionRequest, VisitTypeMaster visitTypeMaster) {
		List<String> visitTypeNames = new ArrayList<>();

		Map<Locale, String> visitTypeNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbVisitTypesWebPortletKeys.VISIT_TYPE_NAME);

		addLocalizedValue(visitTypeNameMap, visitTypeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(visitTypeNameMap, visitTypeNames, CommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkVisitTypeNames(visitTypeNames, actionRequest, visitTypeMaster)) {
			return false;
		}

		return true;
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	private boolean checkVisitTypeNames(List<String> visitTypeNames, ActionRequest actionRequest,
			VisitTypeMaster visitTypeMaster) {
		List<VisitTypeMaster> visitTypeMasters;
		for (String visitTypeName : visitTypeNames) {
			String likeVisitTypeName = StringPool.PERCENT + StringPool.GREATER_THAN + visitTypeName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			visitTypeMasters = new ArrayList<>(
					visitTypeMasterLocalService.findByVisitTypeNameByLike(likeVisitTypeName));
			if (Validator.isNotNull(visitTypeMaster) && visitTypeMasters.contains(visitTypeMaster)) {
				visitTypeMasters.remove(visitTypeMaster);
			}
			if (!visitTypeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbVisitTypesWebPortletKeys.VISIT_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveVisitTypeMVCActionCommand.class.getName());

}
