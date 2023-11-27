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

import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name="+MVCCommands.TRAINEE_APPEAL_RENDER_COMMAND, }, service = MVCRenderCommand.class)
public class ViewAppealMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("invoking RenderRequest command :: ");
		long examResultId = ParamUtil.getLong(renderRequest, "examResultId");
		if(examResultId != 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ExamResultItem examResult = examUtil.getExamResultById(themeDisplay, examResultId);
			if(Validator.isNotNull(examResult)) {
				ExamDefinition examDefinition = scheduleUtil.getExamDefinitionById(themeDisplay, examResult.getExamDefinitionId()); 
				if(examResult.getAppealCount()==0 && Validator.isNull(examResult.getAppealStatus())) {
					renderRequest.setAttribute("appealFees", examDefinition.getAppealFees());
					renderRequest.setAttribute("isReappeal", Boolean.FALSE);
				} else if(examResult.getAppealCount()==1 && (examResult.getAppealStatus().equalsIgnoreCase("accepted") || examResult.getAppealStatus().equalsIgnoreCase("rejected"))) {
					renderRequest.setAttribute("appealFees", examDefinition.getReappealFees());
					renderRequest.setAttribute("isReappeal", Boolean.TRUE);
				}
			}
		}
		renderRequest.setAttribute("examResultId", examResultId);
		logger.info("invoked successful RenderRequest command :: ");
		return OMSBExamWebPortletKeys.APPEAL_TRAINEE_VIEW_JSP ;
	}
	
	@Reference
	private ExamUtil examUtil;
	
	@Reference
	private ScheduleUtil scheduleUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(ViewAppealMVCRenderCommand.class);
}
