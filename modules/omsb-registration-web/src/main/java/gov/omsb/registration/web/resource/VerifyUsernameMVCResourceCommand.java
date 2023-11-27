package gov.omsb.registration.web.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.ScreenNameValidatorFactory;

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
	        "mvc.command.name="+MVCCommands.VERIFY_USERNAME
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class VerifyUsernameMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			LOGGER.info("SendEmailAndMobileOTPMVCResourceCommand Invoked");
			JSONObject json = JSONFactoryUtil.createJSONObject();		
			String userName = ParamUtil.getString(resourceRequest, "inputVal");
			long userId = ParamUtil.getLong(resourceRequest, "lrUserID");
			User user = null;
			try {
				user = UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), userName);
			} catch (PortalException e) {	
				LOGGER.debug("Error while getting user details by username, "+e.getMessage());
			}
			
			if(Validator.isNotNull(user) && user.getUserId()>0) {
				if(user.getUserId()==userId) {
					json.put("isValid", Boolean.TRUE);
				} else {
					json.put("isValid", Boolean.FALSE);
					json.put("message", "username-already-taken");				
				}
			} else if(ScreenNameValidatorFactory.getInstance().validate(PortalUtil.getDefaultCompanyId(), userName)) {
				json.put("isValid", Boolean.TRUE);
			} else {
				json.put("isValid", Boolean.FALSE);
				json.put("message", "invalid-username");
			}
			resourceResponse.getWriter().print(json);
			return Boolean.FALSE;
		} catch (IOException e) {	
			LOGGER.error("Error while checking username, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(OmsbRegistrationWebPortlet.class);
}
