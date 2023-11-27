package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
"mvc.command.name="+MVCCommandNames.OCT_EXAM_WORKFLOW }, service = MVCActionCommand.class)
public class OCTExamWFMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("inside the  processAction::::::::::----------------------- ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
		String comments = ParamUtil.getString(actionRequest, "comments");
		long eqAppealId = ParamUtil.getLong(actionRequest, "eqAppealId");
		long eqExamRegistrationlId = ParamUtil.getLong(actionRequest, "eqExamRegistrationlId");

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String tName = ParamUtil.getString(actionRequest, "transitionName");
		logger.info("eqAppeal Id ?? " + eqAppealId);
		logger.info("workflowTaskId Id ?? " + workflowTaskId);
		logger.info("instanceId Id ?? " + instanceId);
		logger.info("eqExamRegistrationlId Id ?? " + eqExamRegistrationlId);

		logger.info("comments ?? " + comments);
		logger.info("cmd  ?? " + cmd);
		logger.info("transition Name  ?? " + tName);
		WorkflowInstance workflowInstance = null;
		try {
			workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			if (Validator.isNotNull(workflowInstance)) {
				logger.info("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
						+ " :: assignedToMe :: " + assignedToMe);
				octExamAppealUtil.assignOrCompleteWorkflow(tName, cmd, themeDisplay, workflowInstance, workflowTaskId);
				
			}

		} catch (PortalException e) {
			logger.error("Exception in the AssignWorkflowTaskMVCRenderCommand ", e);
		}
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private OCTExamAppealUtil octExamAppealUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTExamWFMVCActionCommand.class);

	

}
