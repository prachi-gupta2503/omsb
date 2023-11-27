package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EXAMS_SCHEDULE_LIST, }, service = MVCRenderCommand.class)
/**
 * 
 * @author RahulkumarP
 *
 */
public class EditExamScheduleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ExamSchedule> schedules = scheduleUtil.getExamScheduleList(themeDisplay);
		schedules=schedules.stream().filter(n->!n.getExamStatus().equalsIgnoreCase("Pending")).collect(Collectors.toList());
		logger.info("ExamSchedule ... "+schedules.size());
		logger.info("exam type name:"+schedules.get(0).getExamTypeName());
		renderRequest.setAttribute("examSchedule", schedules);
		renderRequest.setAttribute("programs", examUtil.getProgram(themeDisplay));
		renderRequest.setAttribute("examTypes", examUtil.getExamTypes(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay));
		renderRequest.setAttribute("examStatus", omsbCommonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS, themeDisplay.getCompanyId()));
		return OMSBExamWebPortletKeys.VIEW_SCHEDULE_EXAM_JSP;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	private Log logger = LogFactoryUtil.getLog(EditExamScheduleMVCRenderCommand.class);
}
