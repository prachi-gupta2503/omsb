package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EMAIL_NOTIFICATION, }, service = MVCRenderCommand.class)

public class EmailNotificationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("render Method Started");
		List<User> users = userLocalService.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<User> traineeUsers = new ArrayList<>();
		for (User user : users) {
			try {
				Role role = RoleLocalServiceUtil.getRole(user.getCompanyId(), "Trainee");
				if (UserLocalServiceUtil.hasRoleUser(role.getRoleId(), user.getUserId())) {
					traineeUsers.add(user);
				}
			} catch (PortalException e) {
				logger.error(e.getMessage());
			}
		}
		renderRequest.setAttribute("users", traineeUsers);
		logger.info("render Method Ended");
		return OMSBExamWebPortletKeys.LIST_OF_TRAINEES_JSP;
	}

	@Reference(unbind = "_")
	OMSBCommonApi commonAPI;

	@Reference(unbind = "_")
	private UserLocalService userLocalService;

	private static final Log logger = LogFactoryUtil.getLog(EmailNotificationMVCRenderCommand.class);

}
