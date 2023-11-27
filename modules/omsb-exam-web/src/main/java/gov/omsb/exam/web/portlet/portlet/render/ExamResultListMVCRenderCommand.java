package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EXAM_RESULT_LIST, }, service = MVCRenderCommand.class)
/**
 * 
 * @author TanusreeD
 *
 */
public class ExamResultListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("exam result render () started");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long examTypeId = ParamUtil.getLong(renderRequest, "examTypeId");
			long programId = ParamUtil.getLong(renderRequest, "programId");
			long examScheduleId = ParamUtil.getLong(renderRequest, "examScheduleId");
			long examDefinitionId = ParamUtil.getLong(renderRequest, "examDefinitionId");
			String examStartDate = ParamUtil.getString(renderRequest, "examStartDate");
			String examEndDate = ParamUtil.getString(renderRequest, "examEndDate");
			String examDate = ParamUtil.getString(renderRequest, "examDate");
			logger.info("exam strat date:" + examStartDate + "exam end date:" + examEndDate);
			logger.info("exam  date:" + examDate);
			logger.info("examtypeid for result::" + examTypeId + "program id::" + programId);
			List<Registration> examreRegistrations = examUtil.getRegistrationByScheduleId(themeDisplay, examTypeId, programId, examScheduleId, examDefinitionId);
			renderRequest.setAttribute("registrationItems", examreRegistrations);
			ExamSchedule examSchedule = new ExamSchedule();
			examSchedule.setExamDate(examDate);
			examSchedule.setExamStartDate(examStartDate);
			examSchedule.setExamEndDate(examEndDate);
			if (Validator.isNotNull(examreRegistrations) && !examreRegistrations.isEmpty()) {
				renderRequest.setAttribute("examSchedule", examSchedule);
			}
			List<ExamResultItem> examResults = new ArrayList<>();
			for (Registration registration : examreRegistrations) {
				ExamResultItem examResultItem = examUtil.getExamResultByUserId(registration.getLrUserId(), themeDisplay,
						examScheduleId, examDefinitionId);
				if (Validator.isNotNull(examResultItem)) {
					examResults.add(examResultItem);
				}
			}
			renderRequest.setAttribute("examResults", examResults);
			return OMSBExamWebPortletKeys.ADMIN_EXAM_RESULT_LIST_JSP;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("exam result render () ended");
		return null;
	}

	@Reference
	private ExamUtil examUtil;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log logger = LogFactoryUtil.getLog(ExaminationMVCRenderCommand.class);
}
