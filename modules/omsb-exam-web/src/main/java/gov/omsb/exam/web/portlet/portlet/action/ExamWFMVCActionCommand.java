package gov.omsb.exam.web.portlet.portlet.action;

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
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
"mvc.command.name=/exam/workflow_action" }, service = MVCActionCommand.class)
public class ExamWFMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.debug("inside the  processAction:::::::::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
		String comments = ParamUtil.getString(actionRequest, "comments");
		long eqAppealId = ParamUtil.getLong(actionRequest, "eqAppealId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String tName = ParamUtil.getString(actionRequest, "transitionName");
		logger.debug("eqAppeal Id ?? " + eqAppealId);
		logger.debug("comments ?? " + comments);
		logger.debug("cmd  ?? " + cmd);
		logger.debug("transition Name  ?? " + tName);
		WorkflowInstance workflowInstance = null;
		try {
			workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			if (Validator.isNotNull(workflowInstance)) {
				logger.debug("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
						+ " :: assignedToMe :: " + assignedToMe);
				examAppealUtil.assignOrCompleteWorkflow(tName, cmd, themeDisplay, workflowInstance, workflowTaskId);
				
			}

		} catch (PortalException e) {
			logger.error("Exception in the AssignWorkflowTaskMVCRenderCommand ", e);
		}
	}
	
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private ExamAppealUtil examAppealUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(ExamWFMVCActionCommand.class);
	
}
