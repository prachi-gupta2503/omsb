package omsb.vehpc.equivalency.notificaion.handler;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, service = 	UserNotificationHandler.class	)
public class VEHPCNotificationHandler extends BaseUserNotificationHandler{
	
	public VEHPCNotificationHandler() {
		setPortletId(OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
		JSONObject object = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		return object.getString("notificationText");
	}
}
