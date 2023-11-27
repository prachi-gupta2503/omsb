package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_EXAM_SCHEDULE, }, service = MVCRenderCommand.class)
/**
 * 
 * @author RahulkumarP
 *
 */
public class ViewExamScheduleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("render() started::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String scheduleExamId = ParamUtil.getString(renderRequest, "scheduleExamId");
		String examType = ParamUtil.getString(renderRequest, "examType");
		long programId = ParamUtil.getLong(renderRequest, "programId");
		String scheduleExamUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + scheduleExamId;
		String examScheduleResponse = omsbCommonApi.getData(scheduleExamUrl);
		ExamSchedule examSchedule = CustomObjectMapperUtil.readValue(examScheduleResponse, ExamSchedule.class);
		String applicationStartDate = examSchedule.getApplicationStartDate();
		String applicationEndDate = examSchedule.getApplicationEndDate();
		String examDate = examSchedule.getExamDate();
		
		if (Validator.isNotNull(applicationStartDate)) {
			applicationStartDate = omsbCommonApi.convertDateFormatToDDMMYYYY(applicationStartDate);
		}
		if (Validator.isNotNull(applicationEndDate)) {
			applicationEndDate = omsbCommonApi.convertDateFormatToDDMMYYYY(applicationEndDate);
		}
		if (Validator.isNotNull(examDate)) {
			examDate = omsbCommonApi.convertDateFormatToDDMMYYYY(examDate);
		}
		examSchedule.setApplicationStartDate(applicationStartDate);
		examSchedule.setApplicationEndDate(applicationEndDate);
		examSchedule.setExamDate(examDate);
		examSchedule.setExamTypeName(examType);
		examSchedule.setProgram(programId);
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		if (cmd.equals(OMSBExamWebPortletKeys.VIEW_SCHEDULE_EXAM_CMD)) {
			renderRequest.setAttribute("examSchedule", examSchedule);
			renderRequest.setAttribute("readonly", "readonly");
		}
		logger.info("render() ended::::");
		return OMSBExamWebPortletKeys.EXAM_SCHEDULE_JSP;
	}

	private static final Log logger = LogFactoryUtil.getLog(ViewExamScheduleMVCRenderCommand.class);
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
}
