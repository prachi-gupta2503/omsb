package gov.omsb.view.procedures.supervisor.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;

@Component(service = UserNotificationHandler.class)
public class SendNotificationToUser extends BaseUserNotificationHandler {
	
	public SendNotificationToUser() {
		setPortletId(OmsbViewProceduresSupervisorWebPortletKeys.OMSBVIEWPROCEDURESSUPERVISORWEB);
	}
	
	@Override
	public String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationMesaage = jsonObject.getString(OmsbTmsCommonConstants.NOTIFICATION_TEXT);
		String notification = StringPool.BLANK;
		String language = serviceContext.getLocale().toString();
		try {
			JSONObject notificationJson = JSONFactoryUtil.createJSONObject(notificationMesaage);
			if(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH.equalsIgnoreCase(language) && Validator.isNull(notificationJson.getString(language))) {
				language = OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC;
			}
			if(OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC.equalsIgnoreCase(language) && Validator.isNull(notificationJson.getString(language))) {
				language = OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH;
			}
			notification = notificationJson.getString(language);
		}catch (Exception e) {
			notification =  notificationMesaage;
		}
		return notification;
	}

}
