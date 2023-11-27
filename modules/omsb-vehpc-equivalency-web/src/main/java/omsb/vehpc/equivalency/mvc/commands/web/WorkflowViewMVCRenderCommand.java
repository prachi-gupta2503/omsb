package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;
import omsb.vehpc.equivalency.workflow.web.JspTransitionWorkflowHandler;

/**
 * @author TayyabaM
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.WORKFLOW_VIEW
	    }, 
	    service = MVCRenderCommand.class
)

public class WorkflowViewMVCRenderCommand implements MVCRenderCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyMVCRenderCommand.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long classPk = 47748;
		String className = "com.liferay.object.model.ObjectDefinition#45750";
		
		
		List<String> transitionNames = null;
		if (Validator.isNotNull(classPk)) {

			transitionNames = JspTransitionWorkflowHandler.equivalencyRequestJspTransitionHandler(themeDisplay, className, classPk);

		}
		
		
		LOGGER.info("Transition Names>>>>>>>>>>>>>>"+transitionNames);
		renderRequest.setAttribute("transitionNames", transitionNames);
		return EquivalencyJSPPathConstants.WORKFLOW_VIEW_JSP;
	}

}
