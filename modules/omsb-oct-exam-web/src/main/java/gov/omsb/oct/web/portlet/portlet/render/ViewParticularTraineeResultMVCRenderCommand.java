package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_PARTICULAR_TRAINEE_RESULT, }, service = MVCRenderCommand.class)

public class ViewParticularTraineeResultMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("Download Result MVC Render Command Method Started.");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long examResultId = ParamUtil.getLong(renderRequest, "examResultId");

		OCTExamResultItem examResultItem = octExamUtil.getTraineeExamResult(themeDisplay, examResultId);
		renderRequest.setAttribute("examResult", examResultItem);

		return OmsbOctExamWebPortletKeys.VIEW_PARTICULAR_TRAINEE_RESULT_JSP;
	}

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(ViewParticularTraineeResultMVCRenderCommand.class);

}
