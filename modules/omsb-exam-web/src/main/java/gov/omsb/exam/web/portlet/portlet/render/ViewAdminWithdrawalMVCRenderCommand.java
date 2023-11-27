package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamDocuments;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatus;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name="+MVCCommands.EXAM_ADMIN_WITHDRAWAL_VIEW, }, service = MVCRenderCommand.class)
public class ViewAdminWithdrawalMVCRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("RenderRequest of ViewAdminWithdrawalMVCRenderCommand invoking ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long withdrawalId = ParamUtil.getLong(renderRequest, "withdrawalId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		boolean assignedToMe = ParamUtil.getBoolean(renderRequest, "assignedToMe");
		boolean isAdmin = commonApi.checkLoggedInUserByRoleName(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN, themeDisplay.getUserId());
		
		logger.info("Role Is Admin ... "+isAdmin);
		
		List<ExamWithdrawalStatus> withdrawalStatusList = new ArrayList<>();
		List<ExamWithdrawalStatus> statusList = examSetupUtil.getExamWithdrawalStatusByWithdrawalId(themeDisplay, withdrawalId);
		for (ExamWithdrawalStatus status: statusList) {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_DOCUMENTS_URL +  CommonConstants.SCOPES + 
					StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION +
					"filter=examWithdrawalStatusId" +  URLEncoder.encode(" eq " + status.getId(), StandardCharsets.UTF_8);
			List<ExamDocuments> documentList =  examAppealUtil.getExamDocsByStatusId(url);
			status.setExamDocuments(documentList);
			status.setName(examAppealUtil.getName(status.getLrUserId()));
			String resson=status.getReason();
			logger.info("resson" + resson);
			if(Validator.isNotNull(resson)) {
				
				String cleanedReason = resson.replaceAll("<[^>]*>", "");
				logger.info("cleanedReason" + cleanedReason);
				status.setReason(cleanedReason);
			}
			logger.info("resson" + status.getReason());
			withdrawalStatusList.add(status);
		}
		
		String programName="";
		String examType = "";
		ExamWithdrawal examWithdrawal = examSetupUtil.getExamWithdrawalById(themeDisplay, withdrawalId);
		if (Validator.isNotNull(examWithdrawal)) {
		
			ExamSchedule examSchedule = examUtil.getExamScheduleById(examWithdrawal.getExamScheduleId(), themeDisplay.getPortalURL());
			if (Validator.isNotNull(examSchedule)){
					 programName = examUtil.getProgramByProgramId(examSchedule.getProgramId(),
							themeDisplay);
					examType=examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale());
					//examWithdrawal.setProgramName(programName);
					//examWithdrawal.setExamType(examType);
			}
		}
		
		
		List<String> trNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
		renderRequest.setAttribute("withdrawalStatusList", withdrawalStatusList);
		renderRequest.setAttribute("withdrawalId", withdrawalId);
		renderRequest.setAttribute("assignedToMe", assignedToMe);
		renderRequest.setAttribute("instanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("trNames", trNames);
		renderRequest.setAttribute("programName", programName);
		renderRequest.setAttribute("examType", examType);
		renderRequest.setAttribute("isAdmin", isAdmin);
		logger.info("RenderRequest of ViewAdminWithdrawalMVCRenderCommand invoked successful ");
		return OMSBExamWebPortletKeys.ADMIN_WITHDRAWAL_JSP;
		
			
		
	}
	
	
	@Reference
	private ExamSetupUtil examSetupUtil;
	
	@Reference
	private ExamAppealUtil examAppealUtil;
	
	@Reference
	private OMSBCommonApi commonApi;
	
	@Reference
	private ScheduleUtil scheduleUtil;
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private ExamUtil examUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(ViewAdminWithdrawalMVCRenderCommand.class);
}
