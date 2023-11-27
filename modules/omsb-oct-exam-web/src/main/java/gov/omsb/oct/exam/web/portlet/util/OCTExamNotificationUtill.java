package gov.omsb.oct.exam.web.portlet.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;

import org.osgi.service.component.annotations.Reference;

import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.web.portlet.portlet.action.SendNotificationMVCActionCommand;
import gov.omsb.oct.web.portlet.portlet.render.OCTRegistrationMVCRenderCommand;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.web.notification.configuration.action.OCTRegistrationNotificationConfigurationAction;

public class OCTExamNotificationUtill {
	private static final Log LOGGER = LogFactoryUtil.getLog(OCTRegistrationMVCRenderCommand.class);
	
	/**
	 * This method will send portal notification
	 * to selected user 
	 * 
	 */
	public void sendExamNotification() {
		try {
			String payload = OCTRegistrationNotificationConfigurationAction.getExamNotificationTemplate();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(
						"Payload from configuration in sendExamNotification :: OCTExamNotificationUtill :: " + payload);
			}
			payload = payload.replace(OCTExamConstants.EXAM_NAME, "ExamName");
			payload = payload.replace(OCTExamConstants.REGISTRATION_START_DATE, "18/02/1997");
			payload = payload.replace(OCTExamConstants.REGISTRATION_END_DATE, "19/02/1997");
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Payload after replacing value in sendExamNotification :: OCTExamNotificationUtill :: "
						+ payload);
			}
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, payload);

			/*
			 * userNotificationEventLocalService.sendUserNotificationEvents(themeDisplay.
			 * getUserId(), OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
			 * UserNotificationDeliveryConstants.TYPE_WEBSITE, object);
			 */
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;
}
