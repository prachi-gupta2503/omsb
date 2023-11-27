package gov.omsb.registration.web.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
			property = {
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_NEW_PASSWORD
			},
service = MVCRenderCommand.class)
public class ViewNewPasswordMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		byte[] valueDecoded = Base64.decode(httpReq.getParameter("user"));
		String[] userValue = new String(valueDecoded).split(StringPool.COLON);
		if(userValue.length==2) {
			renderRequest.setAttribute("userId", userValue[0]);
			return OmsbRegistrationWebPortletKeys.REGISTRATION_NEW_PASSWORD_JSP;
		} else {
			return OmsbRegistrationWebPortletKeys.IDENTIFICATION_CONFIRMATION_JSP;
		}
	}
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
}