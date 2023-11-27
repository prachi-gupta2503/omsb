package gov.omsb.oct.web.portlet.portlet.render;

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
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealStatus;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDocuments;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_ADMIN_APPEAL_VIEW, }, service = MVCRenderCommand.class)
public class OCTViewAdminAppealMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long appealId = ParamUtil.getLong(renderRequest, "appealId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		boolean assignedToMe = ParamUtil.getBoolean(renderRequest, "assignedToMe");
		List<OCTExamAppealStatus> appealStatusList = new ArrayList<>();
		logger.info("--------OCTViewAdminAppealMVCRenderCommand");
		List<OCTExamAppealStatus> appealsStatus = octExamAppealUtil.getExamAppealStatusByAppealId(themeDisplay,
				appealId);
		logger.info("OCTViewAdminAppealMVCRenderCommand--------");
		logger.info("appealsStatus size  " + appealsStatus.size());
		for (OCTExamAppealStatus status : appealsStatus) {
			logger.info("inside the loop of appealstatus");
			String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_DOCUMENTS_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=oCExamAppealStatusId" + URLEncoder.encode(" eq " + status.getId(), StandardCharsets.UTF_8);
			logger.info("docs url  === " + url);
			List<OCTExamDocuments> documentList = octExamAppealUtil.getExamDocsByStatusId(url);
			status.setExamDocuments(documentList);
			status.setName(octExamAppealUtil.getName(status.getLrUserId()));
			// String escapedReason = Jsoup.parse(status.getReason()).text();
			// logger.info("escapedReason ?? " + escapedReason);
			// status.setReason(escapedReason);
			appealStatusList.add(status);
		}
		logger.info("appealstatuslist------->" + appealStatusList.size());
		OCTExamResultItem examResult = null;
		OCTExamDefinitionItem exam = null;
		String programName = "";
		String examType = "";
		OCTExamAppeal appeal = octExamAppealUtil.getExamAppealById(themeDisplay, appealId);
		if (Validator.isNotNull(appeal)) {
			examResult = octExamUtil.getExamResultById(appeal.getExamResultId(), themeDisplay);
		}
		if (Validator.isNotNull(examResult)) {
			exam = octScheduleUtil.getExamDefinitionById(themeDisplay, examResult.getoCExamDefinitionId());
		}
		if (Validator.isNotNull(exam)) {
			// programName = octExamUtil.getProgramByProgramId(exam.getProgramId(),
			// themeDisplay);
			examType = octExamUtil.getExamType(exam.getExamTypeId(), themeDisplay.getPortalURL());
		}
		List<String> trNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
		renderRequest.setAttribute("appealStatusList", appealStatusList);
		renderRequest.setAttribute("assignedToMe", assignedToMe);
		renderRequest.setAttribute("instanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("appealId", appealId);
		renderRequest.setAttribute("trNames", trNames);
		// renderRequest.setAttribute("programName", programName);
		renderRequest.setAttribute("examType", examType);
		renderRequest.setAttribute("examResult", examResult);
		// TODO Auto-generated method stub
		return OmsbOctExamWebPortletKeys.OCT_APPEAL_ADMIN_VIEW_JSP;
	}

	@Reference
	private OCTExamAppealUtil octExamAppealUtil;

	@Reference
	private OCTExamUtil octExamUtil;

	@Reference
	private OCTScheduleUtil octScheduleUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTViewAdminAppealMVCRenderCommand.class);

}
