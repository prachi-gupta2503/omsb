package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.portlet.action.SaveExamMVCActionCommand;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.GET_EXAM_LIST }, service = MVCResourceCommand.class)
public class GetExamListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long programId = ParamUtil.getLong(resourceRequest, "program");
			long examTypeId = ParamUtil.getLong(resourceRequest, "examType");
			logger.info("program id:" + programId);
			logger.info("examTypeId:" + examTypeId);
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
//			List<Exam> examDetails = examSetupUtil.getListOfExam(viewExams, themeDisplay);
			logger.info("exam details size:"+viewExams.size());
//			logger.info(examDetails.get(0).getAppealFees());
			resourceRequest.setAttribute("exams", viewExams);
			resourceRequest.setAttribute("programId", programId);
			resourceRequest.setAttribute("examTypeId", examTypeId);
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher("/jsps/registration/exam-list.jsp");
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return false;
	}

	@Reference
	private ExamSetupUtil examSetupUtil;
	private static final Log logger = LogFactoryUtil.getLog(GetExamListMVCResourceCommand.class);

}
