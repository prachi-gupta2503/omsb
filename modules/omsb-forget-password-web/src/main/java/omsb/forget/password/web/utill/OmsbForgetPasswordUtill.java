package omsb.forget.password.web.utill;

import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Random;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.forget.password.web.dto.PersonItem;
import omsb.forget.password.web.dto.UserVerification;
import omsb.forget.password.web.dto.UserVerificationItems;

@Component(immediate = true, service = OmsbForgetPasswordUtill.class)
public class OmsbForgetPasswordUtill {
	public JSONObject sendEmailOTP(String portalURL, long groupId, long companyId, long personId, String emailAddress) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
		boolean isValid = Boolean.FALSE;
		if (Validator.isNotNull(emailAddress)) {
			User user = userService.fetchUserByEmailAddress(companyId, emailAddress);
			
				String otp = String.format("%06d", new Random().nextInt(999999));
				commonApi.sendEmailNotification("admin@imtac.com", emailAddress, "Verification Mail", "Your OMSB registration email OTP : " + otp);
				LOGGER.info("otp----------------"+otp);
				UserVerificationItems userVerificationItems=null;
				try {
					userVerificationItems = getUserVerificationItems(portalURL, groupId, personId,
							null, null);
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				}
				//if (Validator.isNotNull(userVerificationItems) && userVerificationItems.getItems().size() > 0) {
					if (Validator.isNotNull(userVerificationItems) &&  Validator.isNotNull(userVerificationItems.getItems()) && userVerificationItems.getItems().size()>0) {
					UserVerification userVerification = userVerificationItems.getItems().get(0);
					userVerification.setEmailAddress(emailAddress);
					userVerification.setEmailAddressOTP(otp);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePut(
							portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + userVerification.getId(),
							userVerificationMapper, headers);
				} else {
					UserVerification userVerification = new UserVerification();
					userVerification.setEmailAddress(emailAddress);
					userVerification.setEmailAddressOTP(otp);
					userVerification.setPersonId(personId);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePost(portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId, userVerificationMapper, headers);
					LOGGER.info("Verification Created :::::");
				}
				isValid = Boolean.TRUE;
			}
		
		responseJSON.put("isValid", isValid);
		return responseJSON;
	}

	public JSONObject verifyOTP(String portalURL, long groupId, long companyId, long personId, String fieldName,
			String otp) {

		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(fieldName) && Validator.isNotNull(otp)) {
			UserVerificationItems userVerificationItems = getUserVerificationItems(portalURL, groupId, personId,
					fieldName, otp);
			if (Validator.isNotNull(userVerificationItems) && userVerificationItems.getItems().size() > 0) {
				responseJSON.put("isValid", Boolean.TRUE);
			} else {
				responseJSON.put("isValid", Boolean.FALSE);
			}
		}
		return responseJSON;
	}

	public JSONObject sendMobileOTP(String portalURL, long groupId, long companyId, long personId,
			String mobileNumber) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
		boolean isValid = Boolean.FALSE;
		if (Validator.isNotNull(mobileNumber)) {
			PersonalDetailItem personalDetailItem = getPersonalDetailsItems(portalURL, groupId, 0, mobileNumber); 
			if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0) {
		
				String otp = String.format("%06d", new Random().nextInt(999999));
				LOGGER.info("otp-------"+otp);
				UserVerificationItems userVerificationItems = getUserVerificationItems(portalURL, groupId, personId,
						null, null);
				if (Validator.isNotNull(userVerificationItems) && userVerificationItems.getItems().size() > 0) {
					UserVerification userVerification = userVerificationItems.getItems().get(0);
					userVerification.setMobileNumber(mobileNumber);
					userVerification.setMobileNumberOTP(otp);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePut(
							portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + userVerification.getId(),
							userVerificationMapper, headers);
				} else {
					UserVerification userVerification = new UserVerification();
					userVerification.setMobileNumber(mobileNumber);
					userVerification.setMobileNumberOTP(otp);
					userVerification.setPersonId(personId);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePost(portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId, userVerificationMapper, headers);
				}
				try {
				commonApi.sendMobileNotification(mobileNumber, "Your OMSB registration mobile OTP :" + otp);
				}catch (Exception e) {
					// TODO: handle exception
				}
				isValid = Boolean.TRUE;
			}
		}
		responseJSON.put("isValid", isValid);
		return responseJSON;
	}
	public UserVerificationItems getUserVerificationItems(String portalURL, long groupId, long personId,
			String fieldName, String fieldValue) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_VERIFICATION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + groupId);
		try{
			if (Validator.isNotNull(personId) && Validator.isNotNull(fieldName) && Validator.isNotNull(fieldValue)) {
				sbURL.append(StringPool.QUESTION + "filter=personId" + URLEncoder.encode(
							" eq " + personId + " and " + fieldName + " eq '" + fieldValue + "'", DataflowConstants.UTF_8));
				
			} else if (Validator.isNotNull(personId)) {
				sbURL.append(StringPool.QUESTION + "filter=personId"
							+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		return getItems(sbURL.toString(), UserVerificationItems.class);
	}
	public PersonalDetailItem getPersonalDetailsItems(String portalURL, long groupId, long personId, String mobileNumber) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSONAL_DETAILS_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (Validator.isNotNull(mobileNumber)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=mobileNumber" + URLEncoder.encode(" eq " + "'"+mobileNumber+"'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		} else if(personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("getPersonalDetailsItems :"+sbURL.toString());
		return getItems(sbURL.toString(), PersonalDetailItem.class);
	}
	public <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		if (Validator.isNotNull(response)) {
			return CustomObjectMapperUtil.readValue(response, clazz);
		}
		return null;
	}
	
	public PersonItem fetchPersonByLrUserId(ThemeDisplay themeDisplay, long lrUserId) throws UnsupportedEncodingException {
		String personUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lrUserId, StandardCharsets.UTF_8);
		
		String personResponse = commonApi.getData(personUrl);
		LOGGER.debug("personUrl:::" + personUrl + " , , personResponse::::::::" + personResponse);
		return CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
	}
	
	@Reference(unbind = "_")
	private UserLocalService userService;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	@Reference
	private DLAppLocalService _dlAppLocalService;

	@Reference
	private UserService _userService;
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;
    
    @Reference(unbind = "_")
	private RoleLocalService roleLocalService;


	private static final Log LOGGER = LogFactoryUtil.getLog(OmsbForgetPasswordUtill.class);
}
