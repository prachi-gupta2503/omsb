package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.SEND_EMAIL_NOTIFICATION, }, service = MVCActionCommand.class)

public class SendEmailNotificationActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String checkboxValues = ParamUtil.getString(actionRequest, MVCCommands.SELECTED_ROWS);
		String subject = ParamUtil.getString(actionRequest, MVCCommands.SUBJECT);
		String body = ParamUtil.getString(actionRequest, "editor");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(checkboxValues);

		JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

		notificationJSON.put("notificationText", subject);
		notificationJSON.put("emailTitle", subject);
		notificationJSON.put("emailContent", body);

		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);

			User user = userLocalService.getUser(Long.parseLong(jsonObject.getString(MVCCommands.OMSB_ID)));

			userNotificationEventLocalService.sendUserNotificationEvents(user.getUserId(),
					OMSBExamWebPortletKeys.OMSBEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

			commonAPI.sendEmailNotification(MVCCommands.SENDER_EMAIL, user.getEmailAddress(), subject, body);
			commonAPI.sendMobileNotification(examUtil.getUserMobileNumber(themeDisplay, user.getUserId()), body);

		}
	}



	@Reference(unbind = "_")
	OMSBCommonApi commonAPI;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;
	
	@Reference(unbind = "_")
	private ExamUtil examUtil;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	private static final Log logger = LogFactoryUtil.getLog(SendEmailNotificationActionCommand.class);
}
