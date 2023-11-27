package gov.omsb.participation.type.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
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
import gov.omsb.participation.type.web.constants.OmsbParticipationTypeWebPortletKeys;
import gov.omsb.participation.type.web.portlet.util.OmsbParticipationTypeUtil;
import gov.omsb.tms.model.ParticipationTypeMaster;
import gov.omsb.tms.service.ParticipationTypeMasterLocalService;

/**
 * @author HP
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbParticipationTypeWebPortletKeys.OMSBPARTICIPATIONTYPEWEB, "mvc.command.name="
				+ OmsbParticipationTypeWebPortletKeys.SAVE_PARTICIPATION_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveParticipationTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long participationTypeMasterId = ParamUtil.getLong(actionRequest,
				OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_MASTER_ID, 0);

		List<String> participationTypeNames = new ArrayList<>();
		// getting value with multiple language
		Map<Locale, String> participationTypeNamesMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_NAME);
		addLocalizedValue(participationTypeNamesMap, participationTypeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(participationTypeNamesMap, participationTypeNames, CommonConstants.LANGUAGE_CODE_ARABIC);

		try {
			if (participationTypeMasterId != 0) {
				// Update Participation Type Master
				isSuccess = updateParticipationTypeMaster(actionRequest, participationTypeMasterId,
						participationTypeNames, themeDisplay);
			} else {
				// Create Participation Type Master
				isSuccess = createParticipationTypeMaster(actionRequest, participationTypeNames, themeDisplay);
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
	 * @param participationTypeMasterId
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	private boolean updateParticipationTypeMaster(ActionRequest actionRequest, long participationTypeMasterId,
			List<String> participationTypeNames, ThemeDisplay themeDisplay) throws PortalException {
		ParticipationTypeMaster participationTypeMaster = participationTypeMasterLocalService
				.getParticipationTypeMaster(participationTypeMasterId);
		// Checking for duplication
		if (Validator.isNotNull(participationTypeMaster)) {
			participationTypeMaster = participationTypeMasterLocalService.addUpdateParticipationTypeMaster(
					OmsbParticipationTypeUtil.createParticipationTypeMasterObject(actionRequest,
							participationTypeMaster, Boolean.TRUE, themeDisplay),
					participationTypeNames, Boolean.FALSE);
			if (Validator.isNull(participationTypeMaster)) {
				SessionErrors.add(actionRequest, OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return false;
			}
			_logger.debug("updateParticipationTypeMaster ::: Participation Type Master Record Updated");
		} else {
			_logger.debug("updateParticipationTypeMaster ::: Participation Type Master Record Not Found "
					+ participationTypeMasterId);

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
	private boolean createParticipationTypeMaster(ActionRequest actionRequest, List<String> participationTypeNames,
			ThemeDisplay themeDisplay) {

		// Create Participation
		long participationTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			ParticipationTypeMaster participationTypeMaster = participationTypeMasterLocalService
					.createParticipationTypeMaster(participationTypeMasterId);
			participationTypeMaster = participationTypeMasterLocalService
					.addUpdateParticipationTypeMaster(
							OmsbParticipationTypeUtil.createParticipationTypeMasterObject(actionRequest,
									participationTypeMaster, Boolean.TRUE, themeDisplay),
							participationTypeNames, Boolean.TRUE);
			if (Validator.isNull(participationTypeMaster)) {
				SessionErrors.add(actionRequest, OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return false;
			}
			_logger.debug("createParticipationTypeMaster ::: Participation Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		// Set values by language
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	@Reference
	private ParticipationTypeMasterLocalService participationTypeMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveParticipationTypeMVCActionCommand.class.getName());

}
