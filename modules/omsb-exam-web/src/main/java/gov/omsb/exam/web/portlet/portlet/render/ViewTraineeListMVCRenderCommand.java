package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_TRAINEE_EXAM_LIST }, service = MVCRenderCommand.class)

public class ViewTraineeListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<ExamSchedule> examSchedules = scheduleUtil.getTraineeExamList(themeDisplay);

		renderRequest.setAttribute("examSchedules", examSchedules);

		return OMSBExamWebPortletKeys.VIEW_TRAINEE_EXAM_LIST_JSP;
	}

	@Reference
	private ScheduleUtil scheduleUtil;
}
