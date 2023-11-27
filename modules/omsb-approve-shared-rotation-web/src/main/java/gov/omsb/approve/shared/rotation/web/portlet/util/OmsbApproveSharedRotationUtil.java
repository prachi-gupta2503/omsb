package gov.omsb.approve.shared.rotation.web.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.approve.shared.rotation.web.constants.OmsbApproveSharedRotationWebPortletKeys;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.RotationMasterLocalServiceUtil;

@Component(immediate = true, service = OmsbApproveSharedRotationUtil.class)
public class OmsbApproveSharedRotationUtil {

	public OmsbApproveSharedRotationUtil() {
		super();
	}

	public void prepareMailMessage(SharedRotationRequestDetails sharedRotationRequestDetails, User approverUser,
			String renderURL, Locale currentLocale) {
		try {
			/*Commented code due to email configuration modeule 
			String rawSubject = OmsbApproveSharedRotationEmailConfigurationAction.subject();
			String rawBody = OmsbApproveSharedRotationEmailConfigurationAction.body();

			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
			Template bodyTemplate = CommonUtil.getTemplate(rawBody);*/
			
			User requesterUser = UserLocalServiceUtil
					.fetchUser(Long.valueOf(sharedRotationRequestDetails.getRequestRaisedBy()));
			Map<String, String> emailParameters = new HashMap<>();
			
			/*if (Validator.isNotNull(subjectTemplate) && Validator.isNotNull(bodyTemplate)
					&& Validator.isNotNull(requesterUser)) {
				subjectTemplate.put(OmsbTmsCommonConstants.STATUS, sharedRotationRequestDetails.getStatus());
				bodyTemplate.put(OmsbTmsCommonConstants.ROLE, StringPool.BLANK);

				StringWriter out = new StringWriter();
				subjectTemplate.processTemplate(out);

				String subject = out.toString();*/
			
				for (Role role : approverUser.getRoles()) {
					if (role.getName().equalsIgnoreCase(CommonConstants.ROLE_PROGRAM_ADMINISTRATOR)
							|| role.getName().equalsIgnoreCase(CommonConstants.ROLE_PROGRAM_DIRECTOR)
							|| role.getName().equalsIgnoreCase(CommonConstants.ROLE_CHAIRMAN)) {
						emailParameters.put(OmsbTmsCommonConstants.ROLE, role.getName());
						break;
					}
				}

				ProgramDurationDetails programDurationDetails = ProgramDurationDetailsLocalServiceUtil
						.getProgramDurationDetails(sharedRotationRequestDetails.getProgramDurationId());
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil
						.getProgramMaster(programDurationDetails.getProgramId());
				RotationMaster rotationMaster = RotationMasterLocalServiceUtil
						.getRotationMaster(sharedRotationRequestDetails.getRotationId());

				emailParameters.put(OmsbApproveSharedRotationWebPortletKeys.SHOW_MODAL, Boolean.TRUE.toString());

				emailParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME, requesterUser.getFullName());
				emailParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_NAME,
						rotationMaster.getRotationName(requesterUser.getLanguageId()));
				emailParameters.put(OmsbTmsCommonConstants.STATUS, sharedRotationRequestDetails.getStatus());
				emailParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTED_TRAINEES,
						String.valueOf(sharedRotationRequestDetails.getNoOfTraineesRequested()));
				emailParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_APPROVED_TRAINEES,
						String.valueOf(sharedRotationRequestDetails.getApprovedCount()));
				emailParameters.put(OmsbTmsCommonConstants.LINK, renderURL);
				emailParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_APPROVER_NAME,
						approverUser.getFullName());
				emailParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME,
						programMaster.getProgramName(requesterUser.getLanguageId()));
				
				EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi.getEmailTemplateMasterDTOByName(OmsbTmsCommonConstants.APPROVE_SHARED_ROTAITONS_EMAIL_NOTIFICATION);
				
				_logger.info("emailTemplateMasterDTO.getDynamicBodyEnUS()" +  emailTemplateMasterDTO.getDynamicBodyEnUS());
				_logger.info("emailTemplateMasterDTO.getSignatureEnUS" + emailTemplateMasterDTO.getSignatureEnUS());
				_logger.info("emailTemplateMasterDTO.getSubjectEnUS" + emailTemplateMasterDTO.getSubjectEnUS());
				_logger.info("emailTemplateMasterDTO.getUserNotificationEnUS" + emailTemplateMasterDTO.getUserNotificationEnUS());
				
				long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.APPROVE_SHARED_ROTAITONS_EMAIL_NOTIFICATION);
				
				omsbEmailTemplateMasterCommonApi.sendEmailByTemplateId(templateId, requesterUser.getEmailAddress(),
						requesterUser.getLanguageId(), emailParameters);
				/*StringWriter out2 = new StringWriter();
				bodyTemplate.processTemplate(out2);

				String body = out2.toString();

				EmailObjects emailObjects = new EmailObjects();
				emailObjects.setSubject(subject);
				emailObjects.setBody(body);
				emailObjects.setToAddress(requesterUser.getEmailAddress());
				emailObjects.setFromAddress(OmsbFromEmailConfigurationAction.fromAdminEmail());
				EmailUtil.sendEmail(emailObjects);
			}*/
		} catch (PortalException e) {
			_logger.error(e);
		}

	}

	public void prepareNotificationMessage(SharedRotationRequestDetails sharedRotationRequestDetails,
			User approverUser, String renderURL) throws PortalException {
		/* Commented code due to email configuration modeule
		 * String rawNotification =
		 * OmsbApproveSharedRotationWebNotificationConfigurationAction.
		 * notificationTemplate(); Template notificationTemplate =
		 * CommonUtil.getTemplate(rawNotification);
		 */
		User requesterUser = UserLocalServiceUtil
				.fetchUser(Long.valueOf(sharedRotationRequestDetails.getRequestRaisedBy()));
		//if (Validator.isNotNull(notificationTemplate) && Validator.isNotNull(requesterUser)) {
			Map<String, String> notificationParameters = new HashMap<>();
			notificationParameters.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME,
					requesterUser.getFullName());
			notificationParameters.put(OmsbTmsCommonConstants.STATUS, sharedRotationRequestDetails.getStatus());

			EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi.getEmailTemplateMasterDTOByName(OmsbTmsCommonConstants.APPROVE_SHARED_ROTAITONS_EMAIL_NOTIFICATION);
			
			JSONObject payload = omsbEmailTemplateMasterCommonApi.getNotificationPayloadWithLink(requesterUser, approverUser, emailTemplateMasterDTO.getUserNotificationEnUS(),emailTemplateMasterDTO.getUserNotificationArSA(), renderURL, notificationParameters,notificationParameters);
					
				/*
				 * JSONFactoryUtil.createJSONObject();
				 * payload.put(OmsbTmsCommonConstants.USER_ID, requesterUser.getUserId());
				 * payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notification);
				 * payload.put(OmsbTmsCommonConstants.SENDER_NAME, approverUser.getFullName());
				 * payload.put(OmsbTmsCommonConstants.VIEW_REDIRECT_LINK, renderURL);
				 */

			PortalNotification.sendPortalNotification(requesterUser.getUserId(),
					OmsbApproveSharedRotationWebPortletKeys.OMSBAPPROVESHAREDROTATIONWEB, payload);
		//}
	}
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbApproveSharedRotationUtil.class);
}
