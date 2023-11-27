package gov.omsb.registration.web.resource;

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
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SEND_OTP
	    }, 
	    service = MVCResourceCommand.class
)
public class SendEmailAndMobileOTPMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		
		try {
			LOGGER.info("SendEmailAndMobileOTPMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String verificationType = ParamUtil.getString(resourceRequest, "verificationType");
			long personId = ParamUtil.getLong(resourceRequest, "personID");
			/*
			 * String civilId = ParamUtil.getString(resourceRequest, "civilId"); String
			 * dateOfBirth = ParamUtil.getString(resourceRequest, "dateOfBirth"); String
			 * passportNumber = ParamUtil.getString(resourceRequest, "passportNumber");
			 * LOGGER.info("civilId : "+civilId+" dateOfBirth : "
			 * +dateOfBirth+" passportNumber : "+passportNumber); Person person = null;
			 */
			/*
			 * DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); DateFormat df
			 * = new SimpleDateFormat("dd-MM-yyyy"); String convertedDob =
			 * omsbCommonApi.convertDate(dateOfBirth, df, dateFormatter);
			 */
			/*
			 * if(Validator.isNull(personId)) { if((Validator.isNotNull(civilId) ||
			 * Validator.isNotNull(passportNumber)) && Validator.isNotNull(dateOfBirth)) {
			 * PersonItem personItems =
			 * registrationUtil.getPersonItems(themeDisplay.getPortalURL(),
			 * themeDisplay.getScopeGroupId(), civilId, passportNumber, convertedDob);
			 * if(Validator.isNotNull(personItems.getItems()) &&
			 * !personItems.getItems().isEmpty() ) { LOGGER.info("person :: "+person);
			 * personId=personItems.getItems().get(0).getId(); } else {
			 * LOGGER.info("ELSE---- "); person=new Person(); person.setCivilId(civilId);
			 * person.setPassportNumber(passportNumber);
			 * person.setDateOfBirth(convertedDob);
			 * person=registrationUtil.savePersonData(themeDisplay.getPortalURL(),
			 * themeDisplay.getScopeGroupId(), person); personId=person.getId();
			 * LOGGER.info("person else :: "+person);
			 * 
			 * 
			 * } } }
			 */
			
	//		JSONObject json = null;
	//		if(themeDisplay.isSignedIn()) {
				JSONObject	json = JSONFactoryUtil.createJSONObject();;
		//	}
			if(verificationType.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.MOBILE_NUMBER)) {
				if(!themeDisplay.isSignedIn()) {
				json = registrationUtil.sendMobileOTP(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personId, ParamUtil.getString(resourceRequest, "inputVal"));
				}
				else {
					PersonalDetailItem personalDetailItem =registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), 0, ParamUtil.getString(resourceRequest, "inputVal")); 
					LOGGER.info("inside else :"+personalDetailItem.getItems().size());
					//LOGGER.info("inside else :"+personalDetailItem.getItems().getisMobileNumberVerified());
					if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0 &&  !personalDetailItem.getItems().get(0).isMobileNumberVerified() ) {
						LOGGER.info("inside else :"+personalDetailItem.getItems().get(0).isMobileNumberVerified());
						json = registrationUtil.sendMobileOTP(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personId, ParamUtil.getString(resourceRequest, "inputVal"));
						json.put("isValid", Boolean.TRUE);
					}
					else if(personalDetailItem.getItems().size()<=0) {
						LOGGER.info("inside else IF");
						if(personId>0) {
							json = registrationUtil.sendMobileOTP(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personId, ParamUtil.getString(resourceRequest, "inputVal"));
						}
						json.put("isValid", Boolean.TRUE);
					}
					else {
						json.put("isValid", Boolean.FALSE);
					}
				}
				
			} else if(verificationType.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.EMAIL_ADDRESS)) {
				String inputValue=ParamUtil.getString(resourceRequest, "inputVal");
				LOGGER.info("inputValue : "+inputValue);
				LOGGER.info("inputValue : "+themeDisplay.getUser().getEmailAddress().equals(inputValue));
				if(!themeDisplay.isSignedIn() || (themeDisplay.isSignedIn() && themeDisplay.getUser().getEmailAddress().equals(inputValue))) {
					LOGGER.info("inside if condition ");
					json = registrationUtil.sendEmailOTP(themeDisplay.getPortalURL() , themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), personId, inputValue,themeDisplay.getUserId());
					//json.put("personId", personId);
				} else {
					User user = userService.fetchUserByEmailAddress(themeDisplay.getCompanyId(), ParamUtil.getString(resourceRequest, "inputVal"));
					if (Validator.isNotNull(user) && user.getUserId() > 0) {
						json.put("isValid", Boolean.FALSE);
					} else {
						json.put("isValid", Boolean.TRUE);
					}
					LOGGER.info("flag-----");
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
	
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;

	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "_")
	private UserLocalService userService;
	
	
	private static final Log LOGGER = LogFactoryUtil.getLog(SendEmailAndMobileOTPMVCResourceCommand.class);
}
