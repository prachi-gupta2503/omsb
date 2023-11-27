package gov.omsb.master.rotation.schedule.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;
import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

@Component(immediate = true, service = OmsbMasterRotationScheduleUtil.class)
public class OmsbMasterRotationScheduleUtil {

	public OmsbMasterRotationScheduleUtil() {
		super();
	}

	public void prepareMailForFacultyMessage(String programName, String traineeLevel, User fromUser, User toUser,
			String renderURL) {
		try {
//			String rawSubject = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForFacultyMasterRotationSchedule();
//			String rawBody = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForFacultyMasterRotationSchedule();
//
//			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
//			Template bodyTemplate = CommonUtil.getTemplate(rawBody);
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.MASTER_ROTATION_FACULTY_EMAIL_NOTIFICATION);
			sendEmailToUser(templateId, programName, traineeLevel, fromUser, toUser, renderURL);
		} catch (Exception e) {
			_logger.error(e);
		}
	}

	public void prepareMailForPaUserMessage(String programName, String traineeLevel, User fromUser,
			User toUser, String renderURL) {
		try {
//			String rawSubject = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForPAUserMasterRotationSchedule();
//			String rawBody = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForPAUserMasterRotationSchedule();
//
//			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
//			Template bodyTemplate = CommonUtil.getTemplate(rawBody);
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.MASTER_ROTATION_PAUSER_EMAIL_NOTIFICATION);
			sendEmailToUser(templateId, programName, traineeLevel, fromUser, toUser, renderURL);
		} catch (Exception e) {
			_logger.error(e);
		}
	}
	
	public void prepareMailForEcMemberMessage(String programName, String traineeLevel, User fromUser,
			User toUser, String renderURL) {
		try {
//			String rawSubject = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForECMemberMasterRotationSchedule();
//			String rawBody = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForECMemberMasterRotationSchedule();
//
//			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
//			Template bodyTemplate = CommonUtil.getTemplate(rawBody);
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.MASTER_ROTATION_ECMEMBER_EMAIL_NOTIFICATION);

			sendEmailToUser(templateId, programName, traineeLevel, fromUser, toUser, renderURL);
		} catch (Exception e) {
			_logger.error(e);
		}
	}

	public void prepareMailForTraineeMessage(String programName, String traineeLevel, User fromUser, User toUser,
			String renderURL) {
		try {
//			String rawSubject = OmsbMasterRotationScheduleEmailConfigurationAction.subjectForTraineeMasterRotationSchedule();
//			String rawBody = OmsbMasterRotationScheduleEmailConfigurationAction.bodyForTraineeMasterRotationSchedule();
//
//			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
//			Template bodyTemplate = CommonUtil.getTemplate(rawBody);
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.MASTER_ROTATION_TRAINEE_EMAIL_NOTIFICATION);

			sendEmailToUser(templateId, programName, traineeLevel, fromUser, toUser, renderURL);
		} catch (Exception e) {
			_logger.error(e);
		}
	}

	public void prepareNotificationMessage(String programName, String traineeLevel, User fromUser, User toUser,
			String renderURL, EmailTemplateMasterDTO emailTemplateMasterDTO) {
//		try {
//			String rawNotification = OmsbMasterRotationScheduleWebNotificationConfigurationAction
//					.masterRotationScheduleNotificationTemplate();
//			Template notificationTemplate = CommonUtil.getTemplate(rawNotification);
//
//			_logger.debug("prepare notification");
//			if (Validator.isNotNull(notificationTemplate)) {
				Map<String, String> notificationTemplate = new HashMap<>();
				notificationTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME, programName);
				notificationTemplate.put(OmsbTmsCommonConstants.PA_NAME, fromUser.getFullName());
				notificationTemplate.put(OmsbTmsCommonConstants.TRAINEE_LEVEL, traineeLevel);
				notificationTemplate.put(OmsbTmsCommonConstants.TRAINEE_NAME, toUser.getFullName());
				notificationTemplate.put(OmsbTmsCommonConstants.FACULTY_NAME, toUser.getFullName());

//				StringWriter out = new StringWriter();
//
//				notificationTemplate.processTemplate(out);
//
//				String notification = out.toString();
				
				JSONObject payload = omsbEmailTemplateMasterCommonApi.getNotificationPayloadWithLink(fromUser,
						toUser, emailTemplateMasterDTO.getUserNotificationEnUS(),emailTemplateMasterDTO.getUserNotificationArSA(), renderURL,
						notificationTemplate,notificationTemplate);
				
//				JSONObject payload = JSONFactoryUtil.createJSONObject();
//				payload.put(OmsbTmsCommonConstants.USER_ID, toUser.getUserId());
//				payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notification);
//				payload.put(OmsbTmsCommonConstants.SENDER_NAME, toUser.getFullName());
//				if (null != renderURL) {
//					payload.put(OmsbTmsCommonConstants.VIEW_REDIRECT_LINK, renderURL);
//				}
				PortalNotification.sendPortalNotification(toUser.getUserId(),
						OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB, payload);
				_logger.debug("prepare notification sent");

//			}
//		} catch (TemplateException e) {
//			_logger.error(e);
//		}
	}

	private void sendEmailToUser(long templateId, String programName,
			String traineeLevel, User fromUser, User toUser, String renderURL) {

//		try {
//			if (Validator.isNotNull(subjectTemplate) && Validator.isNotNull(bodyTemplate)) {

//				StringWriter out = new StringWriter();
//				subjectTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME, programName);
//				subjectTemplate.put(OmsbTmsCommonConstants.PA_NAME, fromUser.getFullName());
//				subjectTemplate.put(OmsbTmsCommonConstants.TRAINEE_LEVEL, traineeLevel);
//				subjectTemplate.processTemplate(out);
//
//				String subject = out.toString();
				Map<String,String> bodyTemplate = new HashMap<>();
				bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME, programName);
				bodyTemplate.put(OmsbTmsCommonConstants.PA_NAME, fromUser.getFullName());
				bodyTemplate.put(OmsbTmsCommonConstants.TRAINEE_LEVEL, traineeLevel);
				if(null != renderURL) {
					bodyTemplate.put(OmsbTmsCommonConstants.LINK, renderURL);
				}
				bodyTemplate.put(OmsbTmsCommonConstants.USER_NAME, toUser.getFullName());
				
				omsbEmailTemplateMasterCommonApi.sendEmailByTemplateId(templateId, toUser.getEmailAddress(),
						toUser.getLanguageId(), bodyTemplate);
				
//				StringWriter out2 = new StringWriter();
//				bodyTemplate.processTemplate(out2);
//				String body = out2.toString();

//				EmailObjects emailObjects = new EmailObjects();
//
//				emailObjects.setFromAddress(OmsbFromEmailConfigurationAction.fromAdminEmail());
//				emailObjects.setSubject(subject);
//				emailObjects.setBody(body);
//				emailObjects.setToAddress(toUser.getEmailAddress());
//				EmailUtil.sendEmail(emailObjects);
//			}
//		} catch (PortalException e) {
//			_logger.error(e);
//		}

	}
	
	@SuppressWarnings("deprecation")
	public String createScheduleMasterRotationRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long programMasterId, long progdurationTlBlocksLtId) {
		_logger.info("createScheduleMasterRotationRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.SCHEDULE_MASTER_ROTATION_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;


		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.SCHEDULE_MASTER_ROTATION_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, "/");
			renderUrl.setParameter(CommonConstants.PROGRAM_MASTER_ID, String.valueOf(programMasterId));
			renderUrl.setParameter(OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, String.valueOf(progdurationTlBlocksLtId));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createScheduleMasterRotationRenderUrl Error ::: " + e);
		}
		_logger.info("createScheduleMasterRotationRenderUrl Exit ::: ");
		return renderUrlStr;
	}

	public void prepareNotificationForTraineeMessage(String programName, String traineeLevel, User fromUser,
			User toUser, String renderURL) {
		EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi
				.getEmailTemplateMasterDTOByName(
						OmsbTmsCommonConstants.MASTER_ROTATION_TRAINEE_EMAIL_NOTIFICATION);
		prepareNotificationMessage(programName, traineeLevel, fromUser, toUser, renderURL,emailTemplateMasterDTO);
	}

	public void prepareNotificationForPaUserMessage(String programName, String traineeLevel, User fromUser, User toUser,
			String renderURL) {
		EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi
				.getEmailTemplateMasterDTOByName(
						OmsbTmsCommonConstants.MASTER_ROTATION_PAUSER_EMAIL_NOTIFICATION);
		prepareNotificationMessage(programName, traineeLevel, fromUser, toUser, renderURL,emailTemplateMasterDTO);
		
	}

	public void prepareNotificationForEcMemberMessage(String programName, String traineeLevel, User fromUser,
			User toUser, String renderURL) {
		EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi
				.getEmailTemplateMasterDTOByName(
						OmsbTmsCommonConstants.MASTER_ROTATION_ECMEMBER_EMAIL_NOTIFICATION);
		prepareNotificationMessage(programName, traineeLevel, fromUser, toUser, renderURL,emailTemplateMasterDTO);
		
	}

	public void prepareNotificationForFacultyMessage(String programName, String traineeLevel, User fromUser, User toUser,
			String renderURL) {
		EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi
				.getEmailTemplateMasterDTOByName(
						OmsbTmsCommonConstants.MASTER_ROTATION_FACULTY_EMAIL_NOTIFICATION);
		prepareNotificationMessage(programName, traineeLevel, fromUser, toUser, renderURL,emailTemplateMasterDTO);
		
	}
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbMasterRotationScheduleUtil.class.getName());

}
