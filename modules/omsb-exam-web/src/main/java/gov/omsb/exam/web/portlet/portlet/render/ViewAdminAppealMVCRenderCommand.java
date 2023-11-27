package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.jsoup.Jsoup;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealStatus;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamDocuments;
import gov.omsb.exam.web.portlet.dto.ExamResult;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name="+MVCCommands.EXAM_ADMIN_APPEAL_VIEW, }, service = MVCRenderCommand.class)
public class ViewAdminAppealMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("admin appeal>>>>>>>>>>>>>>>");
		long appealId = ParamUtil.getLong(renderRequest, "appealId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		boolean assignedToMe = ParamUtil.getBoolean(renderRequest, "assignedToMe");
		List<ExamAppealStatus> appealStatusList = new ArrayList<>();
		List<ExamAppealStatus> appealsStatus = examAppealUtil.getExamAppealStatusByAppealId(themeDisplay,appealId);
		for (ExamAppealStatus status: appealsStatus) {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_DOCUMENTS_URL +  CommonConstants.SCOPES + 
					StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION +
					"filter=examAppealStatusId" +  URLEncoder.encode(" eq " + status.getId(), StandardCharsets.UTF_8);
			List<ExamDocuments> documentList =  examAppealUtil.getExamDocsByStatusId(url);
			status.setExamDocuments(documentList);
			status.setName(examAppealUtil.getName(status.getLrUserId()));
		
			appealStatusList.add(status);
		}
		ExamResultItem examResult = null;
		ExamDefinition exam = null;
		String programName = "";
		String examType = "";
		ExamAppeal appeal = examAppealUtil.getExamAppealById(themeDisplay, appealId);
		if (Validator.isNotNull(appeal)) {
			examResult = examUtil.getExamResultById(appeal.getExamResultId(), themeDisplay);
		}
		if (Validator.isNotNull(examResult)) {
			exam = scheduleUtil.getExamDefinitionById(themeDisplay, examResult.getExamDefinitionId());
		}
		if (Validator.isNotNull(exam)) {
			programName = examUtil.getProgramByProgramId(exam.getProgramId(), themeDisplay);
			examType = examUtil.getExamType(exam.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale());
		}
		WorkflowInstance workflowInstance = null;
		List<String> trNames= new ArrayList<String>();
		boolean isValid=false;
		long appealStatus = appeal.getAppealStatus();
		appeal.setAppealStatusValue(examAppealUtil.getStatusName(appealStatus, themeDisplay));
		
		if(workflowTaskId >0 &&  instanceId >0) {
			try {
				boolean assignedToRole=false;
				workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
				
				List<WorkflowLog> logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), workflowInstance);
				if (!logs.isEmpty()) {
					long assigneeRoleId = CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs);
					 assignedToRole = CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay, assigneeRoleId);
				}
				
				if (Validator.isNotNull(workflowInstance) && appeal.getAppealStatusValue().equalsIgnoreCase("Pending")) {
					logger.debug("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
							+ " :: assignedToMe :: " + assignedToMe);
					examAppealUtil.assignOrCompleteWorkflow("", CommonConstants.CMD_ASSIGN_TO_ME, themeDisplay, workflowInstance, workflowTaskId);
					 trNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
					
				}

			} catch (PortalException e) {
				logger.error("Exception in the AssignWorkflowTaskMVCRenderCommand ", e);
			}
			
		}
		
		renderRequest.setAttribute("appealStatusList", appealStatusList);
		renderRequest.setAttribute("assignedToMe", false);
		renderRequest.setAttribute("instanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("appealId", appealId);
		renderRequest.setAttribute("trNames", trNames);
		renderRequest.setAttribute("programName", programName);
		renderRequest.setAttribute("examType", examType);
		renderRequest.setAttribute("examResult", examResult);
		renderRequest.setAttribute("examAppealStatusValue", appeal.getAppealStatusValue());
		return OMSBExamWebPortletKeys.APPEAL_ADMIN_VIEW_JSP;
	}
	
	@Reference
	private ExamAppealUtil examAppealUtil;

	@Reference
	private ExamUtil examUtil;
	
	@Reference
	private ScheduleUtil scheduleUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(ViewAdminAppealMVCRenderCommand.class);
}
