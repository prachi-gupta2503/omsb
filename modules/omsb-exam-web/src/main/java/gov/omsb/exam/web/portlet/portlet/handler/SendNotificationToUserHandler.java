package gov.omsb.exam.web.portlet.portlet.handler;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;

@Component(service = UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler {

	public SendNotificationToUserHandler() {
		
		setPortletId(OMSBExamWebPortletKeys.OMSBEXAMWEB);
	}

	@Override
	public String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		if(jsonObject.has(OMSBExamWebPortletKeys.NOTIFICATION_TEXT)) {
			return jsonObject.getString(OMSBExamWebPortletKeys.NOTIFICATION_TEXT);
		}else if(jsonObject.has(OMSBExamWebPortletKeys.EMAIL_TITLE)){
			return jsonObject.getString(OMSBExamWebPortletKeys.EMAIL_TITLE);
		}else {
			return jsonObject.getString(OMSBExamWebPortletKeys.NOTIFICATION_MESSAGE);
		}
	}
		


}



