package gov.omsb.raise.share.rotation.request.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.email.config.configuration.action.OmsbRequestSharedRotationEmailConfigurationAction;
import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;
import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.RotationMasterLocalServiceUtil;

@Component(immediate = true, service = OmsbRaiseShareRotationRequestUtil.class)
public class OmsbRaiseShareRotationRequestUtil {

	public OmsbRaiseShareRotationRequestUtil() {
		super();
	}

	/**
	 * 
	 * @param actionRequest
	 * @param sharedRotationRequestDetails
	 * @param isCreate
	 * @param themeDisplay
	 * @return
	 */
	public SharedRotationRequestDetails createSharedRotationRequestDetailsObject(ActionRequest actionRequest,
			SharedRotationRequestDetails sharedRotationRequestDetails, boolean isCreate, ThemeDisplay themeDisplay) {
		_logger.debug("createSharedRotationRequestDetailsObject Invoked ::: ");

		long programDurationId = ParamUtil.get(actionRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_DURATION_ID, 0);
		long rotationId = ParamUtil.get(actionRequest, OmsbRaiseShareRotationRequestWebPortletKeys.ROTAION_ID, 0);
		long noOfTraineesRequested = ParamUtil.get(actionRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.NO_OF_TRAINEES_REQUESTED, 0);

		String[] requestRaisedToArray = ParamUtil.getStringValues(actionRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.REQUEST_RAISED_TO);

		String requestRaisedTo = String.join(",", requestRaisedToArray);

		_logger.debug("RequestRaisedToArray :::: " + Arrays.toString(requestRaisedToArray));
		_logger.debug("RequestRaisedTo :::: " + requestRaisedTo);

		Map<Locale, String> requesterCommentMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.COMMENT);
		// Common variable addition
		sharedRotationRequestDetails.setRequesterCommentMap(requesterCommentMap);
		sharedRotationRequestDetails.setModifiedBy(themeDisplay.getUserId());
		sharedRotationRequestDetails.setProgramDurationId(programDurationId);
		sharedRotationRequestDetails.setRotationId(rotationId);
		sharedRotationRequestDetails.setNoOfTraineesRequested(noOfTraineesRequested);
		sharedRotationRequestDetails.setStatus(CommonConstants.PENDING);
		sharedRotationRequestDetails.setRequestRaisedTo(requestRaisedTo);
		if (isCreate) {
			sharedRotationRequestDetails.setCreatedBy(themeDisplay.getUserId());
			sharedRotationRequestDetails.setGroupId(themeDisplay.getScopeGroupId());
			sharedRotationRequestDetails.setRequestRaisedBy(String.valueOf(themeDisplay.getUserId()));
		}
		_logger.debug("createSharedRotationRequestDetailsObject Exit ::: ");
		return sharedRotationRequestDetails;
	}

	public void prepareMailMessage(SharedRotationRequestDetails sharedRotationRequestDetails, User requesterUser,
			String renderURL, Locale currentLocale) {
		try {
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.REQUEST_SHARED_ROTATION_EMAIL_NOTIFICATION);
			_logger.info("tempplate id is :"+templateId);
			String rawSubject = OmsbRequestSharedRotationEmailConfigurationAction.subject();
//			String rawBody = OmsbRequestSharedRotationEmailConfigurationAction.body();

			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
//			Template bodyTemplate = CommonUtil.getTemplate(rawBody);
			Map<String,String> bodyTemplate = new HashMap<>();
			if (Validator.isNotNull(subjectTemplate) && Validator.isNotNull(bodyTemplate)) {

				subjectTemplate.put(OmsbTmsCommonConstants.STATUS, sharedRotationRequestDetails.getStatus());

				StringWriter out = new StringWriter();
				subjectTemplate.processTemplate(out);

//				String subject = out.toString();

				ProgramDurationDetails programDurationDetails = ProgramDurationDetailsLocalServiceUtil
						.getProgramDurationDetails(sharedRotationRequestDetails.getProgramDurationId());
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil
						.getProgramMaster(programDurationDetails.getProgramId());
				RotationMaster rotationMaster = RotationMasterLocalServiceUtil
						.getRotationMaster(sharedRotationRequestDetails.getRotationId());

				bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME, requesterUser.getFullName());
				bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTED_TRAINEES,
						String.valueOf(sharedRotationRequestDetails.getNoOfTraineesRequested()));
				bodyTemplate.put(OmsbTmsCommonConstants.LINK, renderURL);
				bodyTemplate.put(OmsbTmsCommonConstants.ROLE, StringPool.BLANK);
				
				for (Role role : requesterUser.getRoles()) {
					if (role.getName().equalsIgnoreCase(CommonConstants.ROLE_PROGRAM_ADMINISTRATOR)
							|| role.getName().equalsIgnoreCase(CommonConstants.ROLE_PROGRAM_DIRECTOR)
							|| role.getName().equalsIgnoreCase(CommonConstants.ROLE_CHAIRMAN)) {
						bodyTemplate.put(OmsbTmsCommonConstants.ROLE, role.getName());
						break;
					}
				}

				String[] userIds = sharedRotationRequestDetails.getRequestRaisedTo().split(StringPool.COMMA);
//				EmailObjects emailObjects = new EmailObjects();
//				emailObjects.setSubject(subject);
//				emailObjects.setFromAddress(OmsbFromEmailConfigurationAction.fromAdminEmail());
				User approverUser;
				for (int i = 0; i < userIds.length; i++) {

					approverUser = UserLocalServiceUtil.fetchUser(Long.parseLong(userIds[i]));
					if (Validator.isNotNull(approverUser)) {
						bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_APPROVER_NAME,
								approverUser.getFullName());
						bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_NAME,
								rotationMaster.getRotationName(approverUser.getLanguageId()));
						bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME,
								programMaster.getProgramName(approverUser.getLanguageId()));
//						StringWriter out2 = new StringWriter();
//						bodyTemplate.processTemplate(out2);
//						String body = out2.toString();

//						emailObjects.setBody(body);
//						emailObjects.setToAddress(approverUser.getEmailAddress());
//						EmailUtil.sendEmail(emailObjects);
						omsbEmailTemplateMasterCommonApi.sendEmailByTemplateId(templateId, approverUser.getEmailAddress(), approverUser.getLanguageId(),bodyTemplate);
					}
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
	}

	public void prepareNotificationMessage(SharedRotationRequestDetails sharedRotationRequestDetails,
            User requesterUser, String renderURL, Locale currentLocale) {

        try {
            /* Commented code due to email configuration modeule
            String rawNotification = OmsbRequestSharedRotationWebNotificationConfigurationAction.notificationTemplate();
            Template notificationTemplate = CommonUtil.getTemplate(rawNotification);

            if (Validator.isNotNull(notificationTemplate)) {*/
            EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi.getEmailTemplateMasterDTOByName(OmsbTmsCommonConstants.REQUEST_SHARED_ROTATION_EMAIL_NOTIFICATION);
            
            Map<String,String> notificationParamsEN = new HashMap<>();
            Map<String,String> notificationParamsAR = new HashMap<>();

                ProgramDurationDetails programDurationDetails = ProgramDurationDetailsLocalServiceUtil
                        .getProgramDurationDetails(sharedRotationRequestDetails.getProgramDurationId());
                ProgramMaster programMaster = ProgramMasterLocalServiceUtil
                        .getProgramMaster(programDurationDetails.getProgramId());
                RotationMaster rotationMaster = RotationMasterLocalServiceUtil
                        .getRotationMaster(sharedRotationRequestDetails.getRotationId());

                notificationParamsEN.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME,
                        programMaster.getProgramName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH));
                notificationParamsEN.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTED_TRAINEES,
                        String.valueOf(sharedRotationRequestDetails.getNoOfTraineesRequested()));
                notificationParamsEN.put(OmsbTmsCommonConstants.SHARED_ROTATION_NAME,
                        rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH));
                notificationParamsAR.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME,
                        programMaster.getProgramName(OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC));
                notificationParamsAR.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTED_TRAINEES,
                        String.valueOf(sharedRotationRequestDetails.getNoOfTraineesRequested()));
                notificationParamsAR.put(OmsbTmsCommonConstants.SHARED_ROTATION_NAME,
                        rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC));

                String[] userIds = sharedRotationRequestDetails.getRequestRaisedTo().split(StringPool.COMMA);
                User approverUser;
                for (int i = 0; i < userIds.length; i++) {
                    approverUser = UserLocalServiceUtil.fetchUser(Long.parseLong(userIds[i]));
                    if (Validator.isNotNull(approverUser)) {

                    	notificationParamsEN.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME,
                                requesterUser.getFullName());
                    	notificationParamsAR.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME,
                                requesterUser.getFullName());

                    /*  StringWriter out = new StringWriter();
                        notificationTemplate.processTemplate(out);*/

                        /*String notification = out.toString();*/
                        JSONObject payload = omsbEmailTemplateMasterCommonApi.getNotificationPayloadWithLink(approverUser, requesterUser, emailTemplateMasterDTO.getUserNotificationEnUS(),emailTemplateMasterDTO.getUserNotificationArSA(), renderURL, notificationParamsEN,notificationParamsAR);
                                
                        /*payload.put(OmsbTmsCommonConstants.USER_ID, approverUser.getUserId());
                        payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notification);
                        payload.put(OmsbTmsCommonConstants.SENDER_NAME, requesterUser.getFullName());
                        payload.put(OmsbTmsCommonConstants.VIEW_REDIRECT_LINK, renderURL);*/

                        PortalNotification.sendPortalNotification(approverUser.getUserId(),
                                OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB, payload);
                    }
                }
            //}
        } catch (PortalException e) {
            _logger.error(e);
        }
    }
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbRaiseShareRotationRequestUtil.class.getName());

}
