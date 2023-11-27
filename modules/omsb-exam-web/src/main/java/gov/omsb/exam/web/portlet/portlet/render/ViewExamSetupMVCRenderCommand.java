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
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.VIEW_EXAM_SETUP, }, service = MVCRenderCommand.class)
/**
 * 
 * @author TanusreeD
 *
 */
public class ViewExamSetupMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String cmd = ParamUtil.getString(renderRequest, OMSBExamWebPortletKeys.VIEW_EXAM);
			Exam exam = examSetupUtil.getExamById(renderRequest, themeDisplay, cmd);
			String viewExamSchedule = ParamUtil.getString(renderRequest, "viewExamSchedule");
			logger.info("Program id "+ParamUtil.getLong(renderRequest, "searchProgramId") );
			logger.info("Exam Type  id "+ParamUtil.getLong(renderRequest, "searchExamTypeId") );
			renderRequest.setAttribute("viewExamSchedule", viewExamSchedule);
			renderRequest.setAttribute("searchProgramId", ParamUtil.getLong(renderRequest, "searchProgramId"));
			renderRequest.setAttribute("searchExamTypeId", ParamUtil.getLong(renderRequest, "searchExamTypeId"));
			if (exam.getProgramTypeId() != 0) {
				exam.setProgramTypeName(examUtil.getProgramTypeByProgramTypeId(themeDisplay, exam.getProgramTypeId()));
			}
//			if (exam.getProgram() != 0) {
//				ProgramMaster programMasters = programMasterLocalService.getProgramMaster(exam.getProgram());
//				exam.setProgramName(Validator.isNotNull(programMasters) ? programMasters.getProgramName() : "");
//			}
//			if (exam.getExamEligibility() != 0) {
//				TraineeLevelMaster traineeLevelMaster = TraineeLevelMasterLocalServiceUtil
//						.getTraineeLevelMaster(exam.getExamEligibility());
//				exam.setExamEligibilityName(
//						Validator.isNotNull(traineeLevelMaster) ? traineeLevelMaster.getTraineeLevelName() : "");
//			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return OMSBExamWebPortletKeys.VIEW_EXAM_SETUP_JSP;
	}

	@Reference
	private ExamSetupUtil examSetupUtil;
	@Reference(unbind = "-")
	private ProgramTypeMasterLocalService programMasterTypeLocalService;
	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private ExamUtil examUtil;
	private static final Log logger = LogFactoryUtil.getLog(NewExamSetupMVCRenderCommand.class);
}
