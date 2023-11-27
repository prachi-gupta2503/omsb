package gov.omsb.notify.sau.web.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

@Component(service = UserNotificationHandler.class)
public class SendNotificationToUser extends BaseUserNotificationHandler {

	public SendNotificationToUser() {
		setPortletId(OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB);
	}

	@Override
	public String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		return jsonObject.getString(OmsbTmsCommonConstants.NOTIFICATION_TEXT);
	}

}
