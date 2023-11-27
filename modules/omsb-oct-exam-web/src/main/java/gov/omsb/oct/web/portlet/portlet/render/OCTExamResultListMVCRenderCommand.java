package gov.omsb.oct.web.portlet.portlet.render;

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
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" +OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_RESULT_LIST, }, service = MVCRenderCommand.class)
/**
 * 
 * @author TanusreeD
 *
 */
public class OCTExamResultListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("exam result render () started");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long examScheduleId = ParamUtil.getLong(renderRequest, "examScheduleId");
			long examDefinitionId = ParamUtil.getLong(renderRequest, "examDefinitionId");
			String examStartDate = ParamUtil.getString(renderRequest, "examStartDate");
			String examEndDate = ParamUtil.getString(renderRequest, "examEndDate");
			String examDate = ParamUtil.getString(renderRequest, "examDate");
			String examTitle = ParamUtil.getString(renderRequest, "examTitle");
			
			logger.info("exam strat date:" + examStartDate + "exam end date:" + examEndDate);
			logger.info("exam  date:" + examDate);
			
			List<OCTRegistration> examreRegistrations = examUtil.getOCTRegistrationByScheduleIdAndStatus(themeDisplay, examScheduleId,OCTExamConstants.REGISTERED_STATUS_KEY);
			
			logger.info("SIZE OF THE LIST Exam Registration ...."+examreRegistrations.size());
			renderRequest.setAttribute("registrationItems", examreRegistrations);
			renderRequest.setAttribute("examTitle", examTitle);
//			List<OCTExamResultItem> examResults = new ArrayList<>();
//			for (OCTRegistration registration : examreRegistrations) {
//				OCTExamResultItem examResultItem = examUtil.getExamResultByUserId(registration.getLrUserId(), themeDisplay, examScheduleId).getItems().get(0);
//				if (Validator.isNotNull(examResultItem)) {
//					System.out.println(examResultItem.getPercentage());
//					examResults.add(examResultItem);
//				}
//			}
//			renderRequest.setAttribute("examResults", examResults);
			return OmsbOctExamWebPortletKeys.ADMIN_OCT_EXAM_RESULT_LIST_JSP;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("exam result render () ended");
		return null;
	}

	
	
	
	
	
	@Reference
	private OCTExamUtil examUtil;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log logger = LogFactoryUtil.getLog(OCTExamResultListMVCRenderCommand.class);
}
