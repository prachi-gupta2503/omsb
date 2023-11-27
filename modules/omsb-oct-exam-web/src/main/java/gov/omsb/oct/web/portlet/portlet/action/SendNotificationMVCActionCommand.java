package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.SEND_NOTIFICATION_ACTION, }, service = MVCActionCommand.class)
public class SendNotificationMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

	try {
		String selectedTrainees = ParamUtil.getString(actionRequest, MVCCommandNames.TRAINEES);
		String subject = ParamUtil.getString(actionRequest, MVCCommandNames.SUBJECT);
		String textBody = ParamUtil.getString(actionRequest, MVCCommandNames.TEXT_BODY);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(selectedTrainees);

		JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

		notificationJSON.put("notificationText", subject);
		notificationJSON.put("emailTitle", subject);
		notificationJSON.put("emailContent", textBody);
		
		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);
			JSONObject object = JSONFactoryUtil.createJSONObject();
	
			User user = userLocalService.getUser(Long.parseLong(jsonObject.getString(MVCCommandNames.OMSB_ID)));
			object.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notificationJSON);
	
			userNotificationEventLocalService.sendUserNotificationEvents(user.getUserId(), OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
			commonAPI.sendEmailNotification(MVCCommandNames.SENDER_EMAIL, user.getEmailAddress(), subject, textBody);
		}
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
	} catch (PortalException e) {
		logger.error(e.getMessage());
	}
	return false;
}

	@Reference(unbind = "_")
	OMSBCommonApi commonAPI;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	private static final Log logger = LogFactoryUtil.getLog(SendNotificationMVCActionCommand.class);
}
