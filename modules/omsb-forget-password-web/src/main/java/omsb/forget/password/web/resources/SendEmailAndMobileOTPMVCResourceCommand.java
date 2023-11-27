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

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonalDetailItem;
import omsb.forget.password.web.constants.OmsbForgetPasswordWebPortletKeys;
import omsb.forget.password.web.constants.OmsbMVCCommandsKeys;
import omsb.forget.password.web.dto.PersonItem;
import omsb.forget.password.web.utill.OmsbForgetPasswordUtill;
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbForgetPasswordWebPortletKeys.OMSBFORGETPASSWORDWEB,
	        "mvc.command.name="+OmsbMVCCommandsKeys.SEND_OTP
	    }, 
	    service = MVCResourceCommand.class
)
public class SendEmailAndMobileOTPMVCResourceCommand  implements MVCResourceCommand {
	
	
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SendEmailAndMobileOTPMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		try {
			LOGGER.info("SendEmailAndMobileOTPMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String verificationType = ParamUtil.getString(resourceRequest, "verificationType");
			String inputVal=ParamUtil.getString(resourceRequest, "inputVal");
			boolean sendOtp = ParamUtil.getBoolean(resourceRequest, "sendOtp");
				JSONObject	json = JSONFactoryUtil.createJSONObject();
				long personId=0;
			if(verificationType.equalsIgnoreCase(OmsbMVCCommandsKeys.MOBILE_NUMBER)) {
				
				PersonalDetailItem personalDetailItem =forgetPasswordUtill.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), 0, ParamUtil.getString(resourceRequest, "inputVal")); 
					if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0) {
						if(sendOtp) {
							json = forgetPasswordUtill.sendMobileOTP(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personalDetailItem.getItems().get(0).getPersonId(), ParamUtil.getString(resourceRequest, "inputVal"));
						}
						json.put("isValid", Boolean.TRUE);
						json.put("isNumberValid", Boolean.TRUE);
						json.put("personId",personalDetailItem.getItems().get(0).getPersonId());
						json.put("lRUserId",personalDetailItem.getItems().get(0).getLrUserId());
					}
					else {
						json.put("isNumberValid", Boolean.FALSE);
						json.put("isValid", Boolean.FALSE);
					}
				
				
			} else if(verificationType.equalsIgnoreCase(OmsbMVCCommandsKeys.EMAIL_ADDRESS)) {
				
				
					LOGGER.info("inside elese condition====");
				
					User user = userService.fetchUserByEmailAddress(themeDisplay.getCompanyId(), inputVal);
				if (Validator.isNotNull(user) && user.getUserId() > 0) {
					
					if(sendOtp) {
						PersonItem person=	forgetPasswordUtill.fetchPersonByLrUserId(themeDisplay, user.getUserId());
						personId=person.getItems().get(0).getId();
						
						json = forgetPasswordUtill.sendEmailOTP(themeDisplay.getPortalURL() , themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), person.getItems().get(0).getId(), inputVal);
					}
					json.put("isValid", Boolean.TRUE);
					json.put("personId",personId);
					json.put("lRUserId",user.getUserId());
				}else {
					
					json.put("isValid", Boolean.FALSE);
					
				}
				
				}
			

			LOGGER.info("SendEmailAndMobileOTPJSON :::::"+json);
			resourceResponse.getWriter().print(json);
			return Boolean.FALSE;
			
		} catch (IOException e) {	
			LOGGER.error("Error while sending OTP, "+e.getMessage());
			return Boolean.TRUE;
		}
		
		
	}
	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "_")
	private UserLocalService userService;
	
	@Reference(unbind = "_")
	private OmsbForgetPasswordUtill forgetPasswordUtill;
}

