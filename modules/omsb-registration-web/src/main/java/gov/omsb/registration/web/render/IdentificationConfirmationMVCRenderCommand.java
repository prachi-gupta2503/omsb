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
					"mvc.command.name="+ MVCCommands.VIEW_IDENTIFICATION_CONFIRMATION
			},
			service = MVCRenderCommand.class)
public class IdentificationConfirmationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		renderRequest.setAttribute("fullNameAr", ParamUtil.getString(renderRequest, "fullNameAr"));
		renderRequest.setAttribute("fullName", ParamUtil.getString(renderRequest, "fullName"));
		renderRequest.setAttribute("civilId", ParamUtil.getString(renderRequest, "civilId"));
		renderRequest.setAttribute("dateOfBirth", ParamUtil.getString(renderRequest,"dateOfBirth"));
		renderRequest.setAttribute("caseRequestId", ParamUtil.getString(renderRequest,"caseRequestId"));
		renderRequest.setAttribute("passportNumber", ParamUtil.getString(renderRequest,"passportNumber"));
		renderRequest.setAttribute("mobileNo", ParamUtil.getString(renderRequest,"mobileNo"));
		renderRequest.setAttribute("isPkiIdentified", ParamUtil.getString(renderRequest,"isPkiIdentified"));
		renderRequest.setAttribute("omaniCountryId", ParamUtil.getString(renderRequest,"omaniCountryId"));
		
		return OmsbRegistrationWebPortletKeys.IDENTIFICATION_CONFIRMATION_JSP;
	}	
}