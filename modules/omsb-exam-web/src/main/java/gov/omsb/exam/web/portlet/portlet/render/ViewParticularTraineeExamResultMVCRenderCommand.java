package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamResult;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_PARTICULAR_EXAM_RESULT, }, service = MVCRenderCommand.class)

public class ViewParticularTraineeExamResultMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String programName = ParamUtil.getString(renderRequest, "programName");
		String examType = ParamUtil.getString(renderRequest, "examType");
		long examResultId = ParamUtil.getLong(renderRequest, "examResultId");
		ExamResultItem examResult = examUtil.getExamResultById(themeDisplay, examResultId);
		if (Validator.isNotNull(examResult)) {
			examResult.setExamType(examType);
			examResult.setProgramName(programName);
		}
		String viewResultCmd = ParamUtil.getString(renderRequest, "viewResult");
		if (viewResultCmd.equalsIgnoreCase(OMSBExamWebPortletKeys.VIEW_RESULT)) {
			long examScheduleId = ParamUtil.getLong(renderRequest, "scheduleExamId");
			long examDefinitionId = ParamUtil.getLong(renderRequest, "examDefinitionId");
			examResult = examUtil.getExamResultByScheduleIdAndDefnId(themeDisplay, themeDisplay.getUserId(), examDefinitionId,
					examScheduleId);
			if (Validator.isNotNull(examResult)) {
				examResult.setExamType(ParamUtil.getString(renderRequest, "examType"));
				examResult.setProgramName(ParamUtil.getString(renderRequest, "programName"));
				renderRequest.setAttribute("examResult", examResult);
			}
		}
		renderRequest.setAttribute("examResult", examResult);
		return OMSBExamWebPortletKeys.VIEW_TRAINEE_RESULT_JSP;
	}

	@Reference
	private OMSBCommonApi commonApi;
	@Reference
	private ExamUtil examUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	private static final Log logger = LogFactoryUtil.getLog(ViewParticularTraineeExamResultMVCRenderCommand.class);
}
