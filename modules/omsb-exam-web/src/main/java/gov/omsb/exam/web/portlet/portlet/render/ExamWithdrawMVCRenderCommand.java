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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamDocuments;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatus;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EXAM_WITHDRAWAL_RENDER, }, service = MVCRenderCommand.class)

public class ExamWithdrawMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long examScheduleId = ParamUtil.getLong(renderRequest, "examScheduleId");
		long examDefinitionId = ParamUtil.getLong(renderRequest, "examDefinitionId");
		String programName = ParamUtil.getString(renderRequest, "programName");
		String examType = ParamUtil.getString(renderRequest, "examType");
		
		List<ExamWithdrawalStatus> withdrawalStatusList = new ArrayList<>();
		ExamWithdrawal examWithdrawal = examUtil.getExamWithdrawalByScheduleIdAndLrUserId(examScheduleId, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),themeDisplay.getUserId());
		if(Validator.isNotNull(examWithdrawal)) {
			examWithdrawal = examSetupUtil.getWorkflowData(themeDisplay, examWithdrawal);
			
			
			List<ExamWithdrawalStatus> statusList = examSetupUtil.getExamWithdrawalStatusByWithdrawalId(themeDisplay, examWithdrawal.getId());
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
			
			
			renderRequest.setAttribute("transitionName", OMSBExamWebPortletKeys.TRANSITION_NAME_RESUBMIT);
		}else {
			renderRequest.setAttribute("transitionName", "submit");
		}
		renderRequest.setAttribute("examDefinitionId", examDefinitionId);
		renderRequest.setAttribute("examScheduleId", examScheduleId);
		renderRequest.setAttribute("programName", programName);
		renderRequest.setAttribute("examType", examType);
		renderRequest.setAttribute("withdrawalStatusList", withdrawalStatusList);
		
		return OMSBExamWebPortletKeys.TRAINEE_WITHDRAWAL_JSP;
	}

	
	@Reference
	private ExamSetupUtil examSetupUtil;

	@Reference
	private ExamUtil examUtil;
	
	
	
	@Reference
	private ExamAppealUtil examAppealUtil;
	private static final Log logger = LogFactoryUtil.getLog(ExamWithdrawMVCRenderCommand.class);

}
