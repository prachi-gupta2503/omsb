package omsb.forget.password.web.resources;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import omsb.forget.password.web.constants.OmsbForgetPasswordWebPortletKeys;
import omsb.forget.password.web.constants.OmsbMVCCommandsKeys;
import omsb.forget.password.web.dto.PersonItem;
import omsb.forget.password.web.utill.OmsbForgetPasswordUtill;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbForgetPasswordWebPortletKeys.OMSBFORGETPASSWORDWEB,
	        "mvc.command.name="+OmsbMVCCommandsKeys.VERIFY_OTP
	    }, 
	    service = MVCResourceCommand.class
)
public class VerifyEmailAndMobileOTPMVCResourceCommand implements MVCResourceCommand {
	
	
	
	private static final Log LOGGER = LogFactoryUtil.getLog(VerifyEmailAndMobileOTPMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			LOGGER.info("VerifyEmailAndMobileOTPMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String verificationType = ParamUtil.getString(resourceRequest, "verificationType");
			String inputVal=ParamUtil.getString(resourceRequest, "inputVal");
			long personId = ParamUtil.getLong(resourceRequest, "personID");
			JSONObject json =JSONFactoryUtil.createJSONObject();
			
				 json = forgetPasswordUtill.verifyOTP(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personId, verificationType, inputVal);
			
			
			resourceResponse.getWriter().print(json);
			return Boolean.FALSE;
		} catch (IOException e) {	
			LOGGER.error("Error while verifying OTP, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
	@Reference(unbind = "_")
	private UserLocalService userService;
	@Reference(unbind = "_")
	private OmsbForgetPasswordUtill forgetPasswordUtill;
}
