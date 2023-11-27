package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.PKI_MOBILE_IDENTIFICATION }, service = MVCActionCommand.class)
public class PkiIdentificationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String civilId = ParamUtil.getString(actionRequest, "civil_id");
		String dateOfBirth = ParamUtil.getString(actionRequest, "dob");
		String mobileNo = ParamUtil.getString(actionRequest, "mobileno");
		LOGGER.info("mobile number : "+mobileNo);
		String isPkiIdentified = ParamUtil.getString(actionRequest, "isPkiIdentified");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String convertedDob = commonApi.convertDate(dateOfBirth, df, dateFormatter);
		boolean isActiveUser=false;
	//	String userEnteredCaptcha = ParamUtil.getString(actionRequest, "captchaText");
	//	LOGGER.info(userEnteredCaptcha);
	//	try {
		//	boolean captchaMatched = checkCaptcha(actionRequest, userEnteredCaptcha);
		//	LOGGER.info("captchaMatched." + captchaMatched);
		//	if (captchaMatched) {
				PersonItem personsByCivilIdAndDob = registrationUtil.getPersonsByCivilIdAndDob(
						themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilId, convertedDob);
				if (Validator.isNotNull(personsByCivilIdAndDob) && !personsByCivilIdAndDob.getItems().isEmpty()) {
					
					if(Validator.isNotNull(personsByCivilIdAndDob.getItems().get(0).getLrUserId()) && personsByCivilIdAndDob.getItems().get(0).getLrUserId()>0) {
						User user=UserLocalServiceUtil.getUser(personsByCivilIdAndDob.getItems().get(0).getLrUserId());
						isActiveUser=user.isActive();
					}
					if(isActiveUser) {
				    	actionResponse.getRenderParameters().setValue("isAlreadyExist", "true");
				    	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_THANK_YOU);
					} else {
						LOGGER.info("personsByCivilIdAndDob " + personsByCivilIdAndDob.getItems().get(0).getId());
						actionResponse.getRenderParameters().setValue("personId",String.valueOf(personsByCivilIdAndDob.getItems().get(0).getId()));
						actionResponse.getRenderParameters().setValue("mobileNo", mobileNo);
						actionResponse.getRenderParameters().setValue("isPkiIdentified", isPkiIdentified);
						actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
								MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS);	
					}
				} else {
						actionResponse.getRenderParameters().setValue("fullName", ParamUtil.getString(actionRequest, "fullName"));
			        	actionResponse.getRenderParameters().setValue("fullNameAr", ParamUtil.getString(actionRequest, "fullNameAr"));
						actionResponse.getRenderParameters().setValue("civilId", civilId);
						actionResponse.getRenderParameters().setValue("dateOfBirth", dateOfBirth);
						actionResponse.getRenderParameters().setValue("mobileNo", mobileNo);
						actionResponse.getRenderParameters().setValue("isPkiIdentified", isPkiIdentified);
						Country country=null;
						try {
							country=CountryLocalServiceUtil.getCountryByA2(themeDisplay.getCompanyId(), "OM");
						} catch (Exception e) {
							LOGGER.error(e.getMessage());
						}
						if(Validator.isNotNull(country)) {
							actionResponse.getRenderParameters().setValue("omaniCountryId",String.valueOf(country.getCountryId()));
						}
						actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
								MVCCommands.VIEW_IDENTIFICATION_CONFIRMATION);
					}
				//}
//			} else {
//				SessionErrors.add(actionRequest, "captchaError");
//				LOGGER.error("CAPTCHA verification failed.");
//				actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
//						MVCCommands.VIEW_IDENTIFICATION_PKI);
//
//			}
	//	} catch (Exception exception) {
		//	if (exception instanceof CaptchaTextException) {
		//		SessionErrors.add(actionRequest, exception.getClass(), exception);
		//		LOGGER.error("CAPTCHA verification failed.");
		//		actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
		//				MVCCommands.VIEW_IDENTIFICATION_PKI);
		//	}
	//	}
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		LOGGER.info("civil Id :" + civilId + " string dob : " + convertedDob);
	}

	/*
	 * code for matching userEntered captcha text with loaded captcha text, if
	 * matched return true else false
	*/
	private boolean checkCaptcha(PortletRequest request, String enteredCaptchaText) throws Exception {
		boolean captchaMatched = false;
		PortletSession session = request.getPortletSession();
		String captchaTextFromSession = getCaptchaValueFromSession(session);
		LOGGER.error("captchaTextFromSession :: "+captchaTextFromSession);
		if (Validator.isNotNull(captchaTextFromSession)) {
			if (enteredCaptchaText.equals(captchaTextFromSession)) {
				captchaMatched = true;
			}
		}
		return captchaMatched;
	}

	/* code for getting loaded captcha text from session */
	private String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			LOGGER.error("name :: "+name);
			if (name.contains("CAPTCHA_TEXT")) {
				String captchaValueFromSession = (String) session.getAttribute(name);
				return captchaValueFromSession;
			}
		}
		return null;
	}

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(PkiIdentificationMVCActionCommand.class);
}