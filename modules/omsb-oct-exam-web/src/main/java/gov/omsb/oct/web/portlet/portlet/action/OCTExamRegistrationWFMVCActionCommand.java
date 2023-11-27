package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_REGISTRATION_WORKFLOW }, service = MVCActionCommand.class)
public class OCTExamRegistrationWFMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("action is called  ======================   ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "instanceId");
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String transitionName = ParamUtil.getString(actionRequest, "trName");
		long registrationId = ParamUtil.getLong(actionRequest, "registrationId");

		logger.info("trName?? " + transitionName);
		logger.info("instanceId?? " + instanceId);
		logger.info("wf task id?? " + workflowTaskId);
		logger.info("registrationId?? " + registrationId);

		boolean isAdmin = Boolean.FALSE;
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());

		if (roleNames.contains(RoleNameConstants.OCT_ADMIN)) {
			isAdmin = Boolean.TRUE;
		}

		if (!assignedToMe && isAdmin) {
			String status = "";

			if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
				logger.info("inside accept condition");
				status = OCTExamConstants.REGISTERED;
			} else if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
				logger.info("inside reject condition");

				status = OCTExamConstants.REJECTED;
			}

			OCTRegistration registration = examUtil.getExamRegistrationByRegistrationId(themeDisplay, registrationId);
			logger.info("registration object after getExamAppealByExamResultId " + registration);

			if (Validator.isNotNull(registration)) {

				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("regStatus", status);

				registration = examUtil.updateExamRegistrationById(themeDisplay, registration.getId(),
						object.toString());

			}

			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
					.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			examUtil.assignOrCompleteWorkflow(transitionName, "", themeDisplay, workflowInstance, workflowTaskId);
		}

	}

	@Reference
	private OCTExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTExamRegistrationWFMVCActionCommand.class);

}
