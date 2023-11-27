package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
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
import gov.omsb.exam.web.portlet.dto.TraineeItem;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * 
 * @author TanusreeD
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.ADMIN_TRAINEE_LIST, }, service = MVCRenderCommand.class)

public class AdminTraineeListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("admin trainee list render() started");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programId = ParamUtil.getLong(renderRequest, "programId");
		long examTypeId = ParamUtil.getLong(renderRequest, "examTypeId");
		long examDefinitionId = ParamUtil.getLong(renderRequest, "examDefinitionId");
		long examScheduleId = ParamUtil.getLong(renderRequest, "examScheduleId");
		String examType = ParamUtil.getString(renderRequest, "examType");
		String programName = ParamUtil.getString(renderRequest, "programName");
		logger.info("exam schedule id"+examScheduleId);
		logger.info("programId id"+programId);
		ExamSchedule examSchedule = scheduleUtil.getScheduleById(examScheduleId, themeDisplay);
		List<TraineeItem> traineeItems = examUtil.getTraineeByRoleAndProgram(themeDisplay, programId, examTypeId, examDefinitionId, examSchedule);
		logger.info("trainee size:"+traineeItems.size());
		renderRequest.setAttribute("examType", examType);
		renderRequest.setAttribute("programName", programName);
		renderRequest.setAttribute("trainees", traineeItems);
		logger.info("admin trainee list render() ended");
		return OMSBExamWebPortletKeys.ADMIN_TRAINEE_LIST_JSP;
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
	private static final Log logger = LogFactoryUtil.getLog(AdminTraineeListMVCRenderCommand.class);
}
