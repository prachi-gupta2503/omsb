package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.SEND_NOTIFICATION, }, service = MVCActionCommand.class)
public class AnnounceExamNotificationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.debug("Do Process Action Method Started");
		List<User> users = userLocalService.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<String> emailList = new ArrayList<>();
		for (User user : users) {
			List<Role> roles = user.getRoles();
			List<String> rolesList = roles.stream().map(Role::getName).collect(Collectors.toList());
			if (rolesList.contains("Trainee")) {
				emailList.add(user.getEmailAddress());
			}
		}
		for (int i = 0; i < emailList.size(); i++) {
			commonAPI.sendEmailNotification(MVCCommands.SENDER_EMAIL, emailList.get(i), MVCCommands.SUBJECT, MVCCommands.BODY);
		}
		logger.debug("Do Process Action Method Ended");
	}

	@Reference(unbind = "_")
	OMSBCommonApi commonAPI;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	private static final Log logger = LogFactoryUtil.getLog(ScheduleUtil.class);
}
