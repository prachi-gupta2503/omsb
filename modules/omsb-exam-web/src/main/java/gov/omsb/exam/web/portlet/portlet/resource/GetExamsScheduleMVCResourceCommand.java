package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.GET_EXAMS_SCHEDULE }, service = MVCResourceCommand.class)

public class GetExamsScheduleMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programId = ParamUtil.getLong(resourceRequest, "programId");
		long examTypeId = ParamUtil.getLong(resourceRequest, "examTypeId");
		String appStartDate = ParamUtil.getString(resourceRequest, "examStartDate");
		String appEndDate = ParamUtil.getString(resourceRequest, "examEndDate");
		String status = ParamUtil.getString(resourceRequest, "status");

		List<ExamSchedule> examScheduleItem = scheduleUtil .fetchScheduledExamItemList(themeDisplay, programId, examTypeId, appStartDate, appEndDate, status).getItems();
		for (int i = 0; i < examScheduleItem.size(); i++) {
			ExamSchedule es = examScheduleItem.get(i);
			es.setProgramName(examUtil.getProgramByProgramId(es.getProgramId(),
					themeDisplay));
		}
		//examScheduleItem=examScheduleItem.stream().filter(n->n.getExamDate().equalsIgnoreCase(anotherString)).collect(Collectors.toList()); //.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
		
		resourceRequest.setAttribute("examScheduleItem", examScheduleItem);
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext() .getRequestDispatcher(OMSBExamWebPortletKeys.SEARCH_EXAM_SCHEDULE_JSP);
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	@Reference(unbind = "_")
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "_")
	private ExamUtil examUtil;
	
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(GetExamsScheduleMVCResourceCommand.class);
}