package gov.omsb.login.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.PasswordTrackerLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.login.web.constants.OmsbLoginConstant;
import gov.omsb.login.web.constants.OmsbLoginWebPortletKeys;

/**
 * @author himanshu.nimavat
 * 
 * The Class OmsbLoginMVCActionCommand.
 * 
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLoginWebPortletKeys.OMSBLOGINWEB,
		"mvc.command.name=/login-user", }, service = MVCActionCommand.class)
public class OmsbLoginMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		
		String loginType = ParamUtil.getString(actionRequest, OmsbLoginConstant.LOGIN_TYPE);
		
		actionResponse.setRenderParameter(OmsbLoginConstant.LOGIN_TYPE, loginType);

		if (loginType.equals(OmsbLoginConstant.LOGIN_TYPE_USERNAME)) {
			String username = ParamUtil.getString(actionRequest, OmsbLoginConstant.USER_SCREEN_NAME);
			log.debug("Logged in username :" + username);
			String password = ParamUtil.getString(actionRequest, OmsbLoginConstant.PASSWORD);
			String rememberMe = ParamUtil.getString(actionRequest, OmsbLoginConstant.REMEMBER_ME);
			boolean booleanRememberMe = Validator.isBlank(rememberMe) || Validator.isNull(rememberMe) ? Boolean.FALSE : Boolean.TRUE;
			
			if(Validator.isNull(username) || Validator.isBlank(username)) {
				setErrorMessage(actionRequest, OmsbLoginConstant.USERNAME_REQUIRED_MESSAGE_KEY);
				return;
			}
			
			if(Validator.isNull(password) || Validator.isBlank(password)) {
				setErrorMessage(actionRequest, OmsbLoginConstant.PASSWORD_REQUIRED_MESSAGE_KEY);
				return;
			}
			
			User user = userLocalService.fetchUserByScreenName(companyId, username);
			
			if(!verifyUser(user, actionRequest, themeDisplay, username)) {
				return;
			}
			
			try {
				boolean passwordMatched = passwordTrackerLocalService.isSameAsCurrentPassword(user.getUserId(),
						password);
				if (!passwordMatched) {
					setErrorMessage(actionRequest, OmsbLoginConstant.INCORRECT_CREDENTIALS_MESSAGE_KEY);
					return;
				} else {
					HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
					HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
					
					AuthenticatedSessionManagerUtil.login(request, response, username, password, booleanRememberMe,
							CompanyConstants.AUTH_TYPE_SN);
					log.info("OmsbLoginConstant.REDIRECT_URL"+ OmsbLoginConstant.MY_PROFILE_REDIRECT_URL);
					try {
						List<Role> userRoles = user.getRoles();
						log.info("userRoles Size :"+userRoles.size());
						if(Validator.isNotNull(userRoles) && userRoles.size()==4) {						
							boolean isHCP = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.HEALTH_CARE_PROFESSIONAL, Boolean.FALSE);
							boolean isUser = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleNameConstants.USER, Boolean.FALSE);
							log.info("isHCP :"+isHCP+ " isUser :"+isUser);	
							if (isHCP && isUser) {
								log.info("Before landing to the profiling page ");
									response.sendRedirect(OmsbLoginConstant.MY_PROFILE_REDIRECT_URL);
							}
						}else {
								actionResponse.sendRedirect(OmsbLoginConstant.REDIRECT_URL);
						}
					} catch (Exception e) {
						log.error("An error occurred while login with username  ::: " + e.getMessage());
						setErrorMessage(actionRequest, OmsbLoginConstant.SOMTHING_WENT_WRONG);
						return;
					}
				}
			} catch (Exception e) {
				log.error("Error while validating the user ::: " + e);
				setErrorMessage(actionRequest, OmsbLoginConstant.SOMTHING_WENT_WRONG);
				return;
			}
			
			actionResponse.setRenderParameter(OmsbLoginConstant.USER_SCREEN_NAME, username);
			
			hideDefaultErrorMessage(actionRequest);
			hideDefaultSuccessMessage(actionRequest);
		
		} else if (loginType.equals(OmsbLoginConstant.LOGIN_TYPE_PKI_CARD)) {
			String redirectUrl = OmsbLoginConstant.LOGIN_TYPE_PKI_CARD_SERVICE_URL;
			actionResponse.sendRedirect(redirectUrl);
		} else if (loginType.equals(OmsbLoginConstant.LOGIN_TYPE_PKI_MOBILE)) {
			String mobileNumber = ParamUtil.getString(actionRequest, OmsbLoginConstant.MOBILE_NUMBER);
			String countryCode = ParamUtil.getString(actionRequest, OmsbLoginConstant.COUNTRY_CODE);
			log.debug("Logged in mobileNumber :" + mobileNumber);

			if(Validator.isNull(mobileNumber) || Validator.isBlank(mobileNumber)) {
				setErrorMessage(actionRequest, OmsbLoginConstant.MOBILE_REQUIRED_MESSAGE_KEY);
				return;
			}else if(!mobileNumber.matches("^[0-9]+$")) {
				setErrorMessage(actionRequest, OmsbLoginConstant.ENTER_VALID_MOBILE_MESSAGE_KEY);
				return;
			}else if(mobileNumber.length() != 8) {
				setErrorMessage(actionRequest, OmsbLoginConstant.ENTER_VALID_MOBILE_MESSAGE_KEY);
				return;
			}else if(!mobileNumber.startsWith("9") && !mobileNumber.startsWith("7")) {
				setErrorMessage(actionRequest, OmsbLoginConstant.ENTER_VALID_MOBILE_MESSAGE_KEY);
				return;
			}
			
			String url = OmsbLoginConstant.LOGIN_TYPE_MOBILE_SERVICE_URL + mobileNumber;
			
			String response = httpConnector.executeGetWithTimeout(url, StringPool.BLANK, 120000, new HashMap<String, String>());

			try {
				JSONObject jsonObject = new JSONFactoryUtil().createJSONObject(response);
				int statusCode = jsonObject.getInt("statusCode");
				
				if(statusCode == 200) {
					int status = jsonObject.getInt("status");
					
					if(status == 502) {
						long civilId = Long.valueOf(jsonObject.getString(OmsbLoginConstant.CIVIL_ID));
						String personWithScopeURL = generateScopeListURL(LRObjectURL.PERSON_URL,themeDisplay.getScopeGroupId());
						
						if(Validator.isNotNull(civilId)) {
							String personUrl = personWithScopeURL + StringPool.QUESTION + OmsbLoginConstant.FILTER + OmsbLoginConstant.CIVIL_ID + URLEncoder.encode(OmsbLoginConstant.EQ + StringPool.APOSTROPHE + civilId + StringPool.APOSTROPHE, StringPool.UTF8);
							String personResponse = omsbCommonApi.getData(personUrl);
							
							PersonItem personItems = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
							if(Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems()) && personItems.getItems().size() > 0) {
								long userId = personItems.getItems().get(0).getLrUserId();
								User user = userLocalService.fetchUserById(userId);
								
								if(!verifyUser(user, actionRequest, themeDisplay, StringPool.BLANK)) {
									return;
								}
								
								//Redirect for autologin with userId
								String redirect = themeDisplay.getCDNBaseURL() + OmsbLoginConstant.AUTO_LOGIN_PATH + OmsbLoginConstant.PKI_USER_ID + StringPool.EQUAL + user.getUserId();
								actionResponse.sendRedirect(redirect);
							}else {
								setErrorMessage(actionRequest, OmsbLoginConstant.USER_NOT_EXIST);
								return;
							}					
						}
					}else if(status == 501) {
						setErrorMessage(actionRequest, OmsbLoginConstant.FALILED_TO_AUTHENTICATE);
						return;
					}else {
						setErrorMessage(actionRequest, OmsbLoginConstant.SOMTHING_WENT_WRONG);
						return;
					}
				}else {
					setErrorMessage(actionRequest, OmsbLoginConstant.SOMTHING_WENT_WRONG);
					return;
				}
			}catch(JSONException je) {
				log.error("An error occurred while parsing data ::: "+ je.getMessage());
				setErrorMessage(actionRequest, OmsbLoginConstant.SOMTHING_WENT_WRONG);
				return;
			}catch(Exception e) {
				log.error("An error occurred while login with mobile  ::: "+ e.getMessage());
				setErrorMessage(actionRequest, OmsbLoginConstant.SOMTHING_WENT_WRONG);
				return;
			}
		}
	}
	
	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	private boolean verifyUser(User user, ActionRequest actionRequest, ThemeDisplay themeDisplay, String argument) {
		if (Validator.isNull(user)) {
			String messageKey = "";
			if(argument.isBlank()) {
				messageKey = OmsbLoginConstant.USER_NOT_EXIST;
			}else {
				messageKey = OmsbLoginConstant.USER_NOT_EXIST_MESSAGE_KEY;
			}
			setErrorMessage(actionRequest, messageKey);
			return false;
		} else if (!user.isActive()) {
			setErrorMessage(actionRequest, OmsbLoginConstant.USER_IN_ACTIVE_MESSAGE_KEY);
			return false;
		}
		return true;
	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
		hideDefaultErrorMessage(actionRequest);
		hideDefaultSuccessMessage(actionRequest);
	}

	/** The user local service. */
	@Reference
	private UserLocalService userLocalService;

	/** The password tracker local service. */
	@Reference
	private PasswordTrackerLocalService passwordTrackerLocalService;

	@Reference
	private OMSBHttpConnector httpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	/** The logger for log. */
	private static final Log log = LogFactoryUtil.getLog(OmsbLoginMVCActionCommand.class);

}
