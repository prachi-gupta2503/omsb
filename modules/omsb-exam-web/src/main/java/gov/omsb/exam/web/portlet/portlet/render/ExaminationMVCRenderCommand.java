package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.util.ExamNotificationUtil;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=/", }, service = MVCRenderCommand.class)
/**
 * 
 * @author TanusreeD
 *
 */
public class ExaminationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		logger.info("ExaminationMVCRenderCommand render() started");
		try {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());
		logger.info("roleNames::"+roleNames+"roleNames to string ::"+roleNames.toString());
		logger.info("role name exist? "+roleNames.contains(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN));
		long programId = ParamUtil.getLong(renderRequest, "searchProgramId");
		long examTypeId = ParamUtil.getLong(renderRequest, "searchExamTypeId");
		if (roleNames.contains(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN)) {
			logger.info("Program Id ....  "+programId +"examTypeId::"+examTypeId);
			try {
				List<Exam> viewExams = new ArrayList<>();
				if (programId > 0 && examTypeId > 0) {
					viewExams = examSetupUtil.viewExamListByprogramAndExamType(themeDisplay, programId, examTypeId);
				} else if (programId > 0 && examTypeId <= 0) {
					viewExams = examSetupUtil.viewExamListByprogram(themeDisplay, programId);
				} else if (programId <= 0 && examTypeId > 0) {
					viewExams = examSetupUtil.viewExamListByExamTypeId(themeDisplay, examTypeId);
				} else {
					viewExams = examSetupUtil.viewExamList(themeDisplay);
				}
				renderRequest.setAttribute("programId", programId);
				renderRequest.setAttribute("examTypeId", examTypeId);
				renderRequest.setAttribute("exams", viewExams);
				renderRequest.setAttribute("programs", examUtil.getProgram(themeDisplay));
				renderRequest.setAttribute("examTypes", examUtil.getExamTypes(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay));
			} catch (Exception e) {
				logger.error(e);
			}
			return OMSBExamWebPortletKeys.EXAM_ADMIN_JSP;
		} else if (roleNames.contains(RoleNameConstants.TRAINEE)) {
			
			
			List<ExamSchedule> examSchedulesList = scheduleUtil.getTraineeExamList(themeDisplay);
			

			long traineeLevelId = examUtil.getTraineeLevelId(themeDisplay.getUserId());
			for (ExamSchedule examSchedule : examSchedulesList) {
				scheduleUtil.deleteEntryFromList(examSchedulesList, examSchedule, themeDisplay, traineeLevelId);
			}
			 
				
			renderRequest.setAttribute("examSchedules", examSchedulesList);
			return OMSBExamWebPortletKeys.VIEW_TRAINEE_EXAM_LIST_JSP;

		}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return OMSBExamWebPortletKeys.VIEW_TRAINEE_EXAM_LIST_JSP;
	}

	@Reference
	private ExamNotificationUtil examNotificationUtil;
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
	private static final Log logger = LogFactoryUtil.getLog(ExaminationMVCRenderCommand.class);
}
