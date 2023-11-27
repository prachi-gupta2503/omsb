package gov.omsb.registration.web.handler;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import gov.omsb.registration.web.action.SaveAdminDecisionMVCActionCommand;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;


@Component(service = UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler {
public SendNotificationToUserHandler() {
		
		setPortletId(OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB);
	}

	@Override
	public String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		LOGGER.info("jsonObject:: "+jsonObject.getString("emailTitle"));
		LOGGER.info("jsonObject:: "+jsonObject.getString("emailContent"));
		return jsonObject.getString("emailTitle");
	}
	private static final Log LOGGER = LogFactoryUtil.getLog(SendNotificationToUserHandler.class);

}
