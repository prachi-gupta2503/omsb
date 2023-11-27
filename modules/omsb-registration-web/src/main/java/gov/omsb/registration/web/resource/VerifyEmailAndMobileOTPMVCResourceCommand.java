package gov.omsb.registration.web.resource;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.portlet.OmsbRegistrationWebPortlet;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.VERIFY_OTP
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class VerifyEmailAndMobileOTPMVCResourceCommand implements MVCResourceCommand {
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			LOGGER.info("VerifyEmailAndMobileOTPMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String verificationType = ParamUtil.getString(resourceRequest, "verificationType");
			long personId = ParamUtil.getLong(resourceRequest, "personID");
			
			JSONObject json = registrationUtil.verifyOTP(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personId, verificationType, ParamUtil.getString(resourceRequest, "inputVal"));
			resourceResponse.getWriter().print(json);
			return Boolean.FALSE;
		} catch (IOException e) {	
			LOGGER.error("Error while verifying OTP, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(OmsbRegistrationWebPortlet.class);
}
