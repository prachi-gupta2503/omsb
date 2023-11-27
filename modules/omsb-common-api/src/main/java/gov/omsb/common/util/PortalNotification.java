package gov.omsb.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

public class PortalNotification {
	private PortalNotification() {

	}

	public static void sendPortalNotification(long userId, String portletId, JSONObject payload) {
		_logger.info("sendPortalNotification Invoked :::");
		try {
			UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId, portletId,
					UserNotificationDeliveryConstants.TYPE_WEBSITE, payload);
		} catch (PortalException e) {
			_logger.error(e);
		}
		_logger.info("sendPortalNotification Exit :::");
	}

	private static final Log _logger = LogFactoryUtil.getLog(PortalNotification.class);
}
