package gov.omsb.registration.web.resource;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.VIEW_CAPTCHA
	    }, 
	    service = MVCResourceCommand.class
)
public class CaptchaMVCResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("inside serveResource Command:: ");
	//	HttpServletRequest httpRequest =   PortalUtil.getHttpServletRequest(resourceRequest);
	//	HttpServletResponse httpResponse=	PortalUtil.getHttpServletResponse(resourceResponse);
			try {
	            CaptchaUtil.getCaptcha().serveImage(resourceRequest,resourceResponse);
	         //   CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	            
	            LOGGER.info("inside serveResource Command::  after call");  
		 }catch(Exception exception) {
	        	LOGGER.error(exception.getMessage(), exception);
	        }
		return true;
	}
	private static final Log LOGGER = LogFactoryUtil.getLog(CaptchaMVCResourceCommand.class);

}
