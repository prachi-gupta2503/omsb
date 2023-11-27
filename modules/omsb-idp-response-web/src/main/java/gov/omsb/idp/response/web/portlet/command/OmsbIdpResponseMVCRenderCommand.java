package gov.omsb.idp.response.web.portlet.command;


import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.idp.response.web.constants.OmsbIdpResponseWebPortletKeys;


/**
 * @author himanshu.nimavat
 * 
 * The Class OmsbIdpResponseMVCRenderCommand.
 * 
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" +  OmsbIdpResponseWebPortletKeys.OMSBIDPRESPONSEWEB,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class OmsbIdpResponseMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String status = httpReq.getParameter("status");
		if(Validator.isNotNull(status) && status.equals("200")) {
			
			String omanIDCivilNumber = httpReq.getParameter("omanIDCivilNumber");
			if(Validator.isNotNull(omanIDCivilNumber)) {
				long civilId = Long.valueOf(omanIDCivilNumber);
				//Redirect for autologin with userId
				String loginUrl = themeDisplay.getCDNBaseURL() + "/login?" + "omanIDCivilNumber" + StringPool.EQUAL + civilId;
				renderRequest.setAttribute("loginUrl", loginUrl);
			}
		}
		//Rediret for registration with current url params
		renderRequest.setAttribute("registrationUrl", themeDisplay.getCDNBaseURL() + "/registration" + StringPool.QUESTION + extractQueryString(PortalUtil.getCurrentURL(httpReq)));
		
		return "/view.jsp";
	}

	private String extractQueryString(String url) {
	    int questionMarkIndex = url.indexOf('?');
	    if (questionMarkIndex >= 0 && questionMarkIndex < url.length() - 1) {
	        return url.substring(questionMarkIndex + 1);
	    }
	    return "";
	}
}
