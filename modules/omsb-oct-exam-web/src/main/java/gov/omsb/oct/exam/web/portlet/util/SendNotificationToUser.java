package gov.omsb.oct.exam.web.portlet.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;


@Component(service = UserNotificationHandler.class)
public class SendNotificationToUser  extends BaseUserNotificationHandler {

	public SendNotificationToUser() {
		setPortletId(OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB);
	}

	@Override
	public String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		
		if(jsonObject.has(OmsbTmsCommonConstants.NOTIFICATION_TEXT)) {
			return jsonObject.getString(OmsbTmsCommonConstants.NOTIFICATION_TEXT);
		}else if(jsonObject.has(OmsbTmsCommonConstants.EMAIL_TITLE)){
			return jsonObject.getString(OmsbTmsCommonConstants.EMAIL_TITLE);
		}else {
			return jsonObject.getString(OmsbTmsCommonConstants.NOTIFICATION_MESSAGE);
		}
	}


}
