package gov.omsb.registration.web.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;

@Component(immediate = true, 
			property = {
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_THANK_YOU
			},
			service = MVCRenderCommand.class)
public class ThankYouScreenMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		boolean userAlreadyExist = ParamUtil.getBoolean(renderRequest, "isAlreadyExist");
		renderRequest.setAttribute("userAlreadyExist", userAlreadyExist);
		return OmsbRegistrationWebPortletKeys.REGISTRATION_THANK_YOU_JSP;
	}
}