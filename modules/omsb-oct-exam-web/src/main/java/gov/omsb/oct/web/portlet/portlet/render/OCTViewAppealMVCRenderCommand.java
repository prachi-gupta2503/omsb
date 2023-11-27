package gov.omsb.oct.web.portlet.portlet.render;

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

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="+MVCCommandNames.OCT_TRAINEE_APPEAL_RENDER_COMMAND, }, service = MVCRenderCommand.class)

public class OCTViewAppealMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("invoking RenderRequest command :: ");
		long octExamResultId = ParamUtil.getLong(renderRequest, "examResultId");
		if(octExamResultId != 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			OCTExamResultItem octExamResult = octExamUtil.getOCTExamResultById(themeDisplay, octExamResultId);
			if(Validator.isNotNull(octExamResult)) {
				OCTExamDefinitionItem octExamDefinition = octScheduleUtil.getExamDefinitionById(themeDisplay, octExamResult.getoCExamDefinitionId()); 
				if(octExamResult.getAppealCount()==0 && Validator.isNull(octExamResult.getAppealStatus())) {
					renderRequest.setAttribute("appealFees", octExamDefinition.getAppealFees());
					renderRequest.setAttribute("isReappeal", Boolean.FALSE);
				} else if(octExamResult.getAppealCount()==1 && (octExamResult.getAppealStatus().equalsIgnoreCase("accepted") || octExamResult.getAppealStatus().equalsIgnoreCase("rejected"))) {
					renderRequest.setAttribute("appealFees", octExamDefinition.getReAppealFees());
					renderRequest.setAttribute("isReappeal", Boolean.TRUE);
				}
			}
		}
		renderRequest.setAttribute("examResultId", octExamResultId);
		logger.info("invoked successful RenderRequest command :: ");		
		return OmsbOctExamWebPortletKeys.OCT_APPEAL_TRAINEE_VIEW_JSP;
	}
	
	@Reference(unbind = "-")
	OCTExamUtil octExamUtil;
	
	@Reference(unbind = "-")
	OCTScheduleUtil octScheduleUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTViewAppealMVCRenderCommand.class);

}
