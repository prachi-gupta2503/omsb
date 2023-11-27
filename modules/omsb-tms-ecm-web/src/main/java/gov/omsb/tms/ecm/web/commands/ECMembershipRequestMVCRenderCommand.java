package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.JSP_ADD_EC_MEMBERSHIP_REQUEST_JSP;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PROGRAM_LIST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ROLE_LIST;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.ecm.web.util.MembershipUtil;

/**
 * @author Jinal Patel
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=/add/new-ec-member-request" }, service = MVCRenderCommand.class)
public class ECMembershipRequestMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("inside render");
		renderRequest.setAttribute("redirectURL", PortalUtil.getCurrentURL(renderRequest));
	
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
		renderRequest.setAttribute(PROGRAM_LIST, membershipUtil.getUserPrograms(themeDisplay));
		
		renderRequest.setAttribute(ROLE_LIST, membershipUtil.getECMemberRoles(themeDisplay.getScopeGroupId()));
		
		return JSP_ADD_EC_MEMBERSHIP_REQUEST_JSP;
	}

	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

	
	private static final Log log = LogFactoryUtil.getLog(ECMembershipRequestMVCRenderCommand.class);
}
