package gov.omsb.notify.sau.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.StringUtil;

import gov.omsb.common.dto.EmailObjects;
import gov.omsb.common.util.EmailUtil;
import gov.omsb.email.config.configuration.action.OmsbNotifySauEmailConfigurationAction;
import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.NotifySauDetailsDTO;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;
import gov.omsb.web.notification.configuration.action.OmsbNotifySauWebNotificationConfigurationAction;

public class OmsbNotifyToSauUtil {

	private OmsbNotifyToSauUtil() {
	}

	public static void prepareNotificationMessage(NotifySauDetailsDTO notifySauDetailsDTO) {
		_logger.debug("prepareNotificationMessage Invoked ::: ");
		long[] userIds = notifySauDetailsDTO.getSauUserIds();
		User sentToUser;
		try {
			TrainingSitesMaster trainingSite = TrainingSitesMasterLocalServiceUtil
					.getTrainingSitesMaster(notifySauDetailsDTO.getTrainingSiteId());
			User user = UserLocalServiceUtil.getUser(notifySauDetailsDTO.getFromUserId());
			for (int i = 0; i < userIds.length; i++) {
				sentToUser = UserLocalServiceUtil.fetchUser(userIds[i]);
				String[] oldString = new String[] { OmsbNotifySauWebPortletKeys.WEB_NOTIFICATION_SITE_NAME,
						OmsbNotifySauWebPortletKeys.WEB_NOTIFICATION_FULL_NAME };
				String[] newString = new String[] { trainingSite.getTrainingSiteName(), user.getFullName() };

				String notificationText = StringUtil.replace(
						OmsbNotifySauWebNotificationConfigurationAction.notificationTemplate(), oldString, newString);

				JSONObject payload = JSONFactoryUtil.createJSONObject();
				payload.put(OmsbTmsCommonConstants.USER_ID, sentToUser.getUserId());
				payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notificationText);
				payload.put(OmsbTmsCommonConstants.SENDER_NAME, user.getFullName());
				UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(sentToUser.getUserId(),
						OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
						payload);
			}
		} catch (Exception e) {
			_logger.error(e);
		}
		_logger.debug("prepareNotificationMessage Exit ::: ");
	}

	public static void prepareMailMessage(NotifySauDetailsDTO notifySauDetailsDTO) {
		_logger.info("prepareMailMessage Invoked ::: ");
		EmailObjects emailObjects = new EmailObjects();
		try {
			long[] userIds = notifySauDetailsDTO.getSauUserIds();
			User approverUser;
			TrainingSitesMaster trainingSite = TrainingSitesMasterLocalServiceUtil
					.getTrainingSitesMaster(notifySauDetailsDTO.getTrainingSiteId());
			User user = UserLocalServiceUtil.getUser(notifySauDetailsDTO.getFromUserId());
			for (int i = 0; i < userIds.length; i++) {
				approverUser = UserLocalServiceUtil.fetchUser(userIds[i]);
				emailObjects.setToAddress(approverUser.getEmailAddress());
				emailObjects.setBody(OmsbNotifySauEmailConfigurationAction.body());
				emailObjects.setSubject(OmsbNotifySauEmailConfigurationAction.subject());

				String[] oldString = new String[] { OmsbNotifySauWebPortletKeys.WEB_NOTIFICATION_FULL_NAME,
						OmsbNotifySauWebPortletKeys.WEB_NOTIFICATION_SITE_NAME,
						OmsbNotifySauWebPortletKeys.NOTIFY_MAIL_CURRENT_CAPACITY,
						OmsbNotifySauWebPortletKeys.NOTIFY_MAIL_REQUIRED_CAPACITY};
				String[] newString = new String[] { user.getFullName(), trainingSite.getTrainingSiteName(),
						String.valueOf(notifySauDetailsDTO.getCurrentCapacity()),
						String.valueOf(notifySauDetailsDTO.getRequiredCapacity()) };

				emailObjects.setOldSubstitute(oldString);
				emailObjects.setNewSubstitute(newString);

				EmailUtil.sendEmailNotification(emailObjects);
			}
		} catch (PortalException e) {
			_logger.error("Error While Sending Emails" + e);
		}
		_logger.info("prepareMailMessage Exit ::: ");
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbNotifyToSauUtil.class.getName());
}
