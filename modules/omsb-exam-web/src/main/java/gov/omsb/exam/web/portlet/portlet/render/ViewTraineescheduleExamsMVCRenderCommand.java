package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_SCHEDULE_EXAMS, }, service = MVCRenderCommand.class)

public class ViewTraineescheduleExamsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ExamSchedule> examSchedules = scheduleUtil.getTraineeExamList(themeDisplay);
		for (ExamSchedule examSchedule : examSchedules) {
		}
		renderRequest.setAttribute("examSchedules", examSchedules);
		return OMSBExamWebPortletKeys.VIEW_TRAINEE_EXAM_LIST_JSP;
	}

	@Reference
	private ExamSetupUtil examSetupUtil;
	@Reference
	private ScheduleUtil scheduleUtil;
	@Reference
	private ExamUtil examUtil;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;
	private static final Log logger = LogFactoryUtil.getLog(ViewTraineescheduleExamsMVCRenderCommand.class);

}
