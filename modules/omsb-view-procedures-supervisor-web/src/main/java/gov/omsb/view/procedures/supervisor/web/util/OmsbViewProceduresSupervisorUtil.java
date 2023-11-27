package gov.omsb.view.procedures.supervisor.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;

@Component(immediate = true, service = OmsbViewProceduresSupervisorUtil.class)
public class OmsbViewProceduresSupervisorUtil {

	public OmsbViewProceduresSupervisorUtil() {
		super();
	}

	public boolean sendStatusChangedEmailNotification(TraineeLoggedProcedureDetails details,
			ProcedureMaster procedureMaster, ThemeDisplay themeDisplay, String renderUrl) {
		try {
			//Commented code due to email configuration modeule
//			EmailObjects emailObjects = new EmailObjects();
//			emailObjects.setToAddress(traninee.getEmailAddress());
//			emailObjects.setBody(OmsbTraineeEmailConfigurationAction.body());
//			emailObjects.setSubject(OmsbTraineeEmailConfigurationAction.subject());

			User traninee = UserLocalServiceUtil.getUser(details.getTraineeId());
			
			Map<String,String> emailParameters = new HashMap<>();
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME, traninee.getFullName());
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME, procedureMaster.getProcedureName(traninee.getLanguageId()));
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE, details.getProcedurePerformedDate().toString());
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, getStatus(details.getProcedureStatus()));
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_REDIRECT_LINK, renderUrl);
			
//			String[] oldString = new String[] { OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_REDIRECT_LINK};
//			String[] newString = new String[] { traninee.getFullName(),
//					procedureMaster.getProcedureName(themeDisplay.getLocale()),
//					details.getProcedurePerformedDate().toString(), getStatus(details.getProcedureStatus()),renderUrl};
//
//			emailObjects.setOldSubstitute(oldString);
//			emailObjects.setNewSubstitute(newString);
//
//			EmailUtil.sendEmailNotification(emailObjects);
			
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.LOGGED_PROCEDURE_ACTION_STATUS_EMAIL_NOTIFICATION_FOR_TRAINEE);
			omsbEmailTemplateMasterCommonApi.sendEmailByTemplateId(templateId, traninee.getEmailAddress(),
					traninee.getLanguageId(), emailParameters);

		} catch (PortalException e) {
			_logger.error("Error While Sending Emails" + e);
			return false;
		}
		return true;
	}

	public JSONObject prepareStatusChangedWebNotificationPayload(TraineeLoggedProcedureDetails details,
			ProcedureMaster procedureMaster, ThemeDisplay themeDisplay, String renderLink) {
		_logger.info("prepareStatusChangedWebNotificationPayload Invoked ::: " + details.getFacultyId());
		//Commented code due to email configuration modeule
		
		Map<String, String> notificationParamsEN = new HashMap<>();
		notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,
				procedureMaster.getProcedureName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH));
		notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,
				details.getProcedurePerformedDate().toString());
		notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, getStatus(details.getProcedureStatus()));
		notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_SUPERVISOR_NAME,
				themeDisplay.getUser().getFullName());
		
		Map<String, String> notificationParamsAR = new HashMap<>();
		notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,
				procedureMaster.getProcedureName(OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC));
		notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,
				details.getProcedurePerformedDate().toString());
		notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, getStatus(details.getProcedureStatus()));
		notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_SUPERVISOR_NAME,
				themeDisplay.getUser().getFullName());
		
		/*
		 * String[] oldString = new String[] {
		 * OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,
		 * OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,
		 * OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS,
		 * OmsbTmsCommonConstants.EMAIL_TEMPLATE_SUPERVISOR_NAME }; String[] newString =
		 * new String[] { procedureMaster.getProcedureName(themeDisplay.getLocale()),
		 * details.getProcedurePerformedDate().toString(),
		 * getStatus(details.getProcedureStatus()), themeDisplay.getUser().getFullName()
		 * };
		 * 
		 * String notificationText = StringUtil
		 * .replace(OmsbTraineeWebNotificationConfigurationAction.notificationTemplate()
		 * , oldString, newString);
		 */

		EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi
				.getEmailTemplateMasterDTOByName(
						OmsbTmsCommonConstants.LOGGED_PROCEDURE_ACTION_STATUS_EMAIL_NOTIFICATION_FOR_TRAINEE);

		JSONObject payload = omsbEmailTemplateMasterCommonApi.getNotificationPayloadWithLink(themeDisplay.getUser(),
				themeDisplay.getUser(), emailTemplateMasterDTO.getUserNotificationEnUS(),emailTemplateMasterDTO.getUserNotificationArSA(), renderLink,
				notificationParamsEN,notificationParamsAR);
		/*payload.put(OmsbTmsCommonConstants.USER_ID, themeDisplay.getUserId());
		payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notificationText);
		payload.put(OmsbTmsCommonConstants.SENDER_NAME, themeDisplay.getUser().getFullName());
		payload.put(OmsbTmsCommonConstants.VIEW_REDIRECT_LINK, renderLink);*/

		_logger.info("prepareStatusChangedWebNotificationPayload Exit ::: ");
		return payload;
	}
	
	private static String getStatus(String status) {
		switch (status) {
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_PASS:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_PASSED;
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_NOT_PASS:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_NOT_PASSED;
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_REFUSE:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_REFUSED;
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED;
		default:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED;
		}
	}
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewProceduresSupervisorUtil.class.getName());
}
