package gov.omsb.login.web.constants;

public class OmsbLoginConstant {
	
	private OmsbLoginConstant() {}
	
	/** The Constant ACTION. */
	public static final String ACTION = "action";
	
	/** The Constant VIEW_LOGIN_JSP. */
	public static final String VIEW_LOGIN_JSP = "/view.jsp";
	
	/** The Constant REGISTRATION_JSP. */
	public static final String REGISTRATION_JSP = "/registration";
	
	/** The Constant LOGIN_TYPE. */
	public static final String LOGIN_TYPE = "loginType";
	
	/** The Constant LOGIN_TYPE_USERNAME. */
	public static final String LOGIN_TYPE_USERNAME = "pkiUsername";
	
	/** The Constant LOGIN_TYPE_PKI_CARD. */
	public static final String LOGIN_TYPE_PKI_CARD = "pkiCard";
	
	/** The Constant LOGIN_TYPE_PKI_MOBILE. */
	public static final String LOGIN_TYPE_PKI_MOBILE = "pkiMobile";
	
	/** The Constant USER_SCREEN_NAME. */
	public static final String USER_SCREEN_NAME = "username";
	
	/** The Constant PASSWORD. */
	public static final String PASSWORD = "password";
	
	/** The Constant REMEMBER_ME. */
	public static final String REMEMBER_ME = "rememberMe";
	
	/** The Constant MOBILE_NUMBER. */
	public static final String MOBILE_NUMBER = "mobileNumber";
	
	/** The Constant COUNTRY_CODE. */
	public static final String COUNTRY_CODE = "countryCode";
	
	/** The Constant LOGIN_TYPE_PKI_MOBILE. */
	public static final String PKI_USER_ID = "pkiUserId";
	
	/** The Constant REDIRECT_URL. */
	public static final String REDIRECT_URL = "/group/guest/dashboard";

	/** The Constant My profile REDIRECT_URL. */
	public static final String MY_PROFILE_REDIRECT_URL = "/group/guest/my-profile";
	
	/** The Constant LOGIN_TYPE_PKI_MOBILE. */
	public static final String AUTO_LOGIN_PATH = "/c/portal/login?";
	
	/** The Constant HOME Path. */
	public static final String PATH_HOME = "/home";
	
	/** The Constant FORGOT_PASSWORD_ACTION. */
	public static final String FORGOT_PASSWORD_ACTION = "forgotPassword";
	
	/** The Constant USER_NOT_EXIST_MESSAGE_KEY. */
	public static final String USER_NOT_EXIST_MESSAGE_KEY = "user-not-exist-with-x";
	
	/** The Constant USER_NOT_EXIST. */
	public static final String USER_NOT_EXIST = "user-not-exist";
	
	/** The Constant USER_IN_ACTIVE_MESSAGE_KEY. */
	public static final String USER_IN_ACTIVE_MESSAGE_KEY = "user-in-active";
	
	/** The Constant INCORRECT_CREDENTIALS_MESSAGE_KEY. */
	public static final String INCORRECT_CREDENTIALS_MESSAGE_KEY = "incorrect-credentials";
	
	/** The Constant USERNAME_REQUIRED_MESSAGE_KEY. */
	public static final String USERNAME_REQUIRED_MESSAGE_KEY = "username-required";
	
	/** The Constant PASSWORD_REQUIRED_MESSAGE_KEY. */
	public static final String PASSWORD_REQUIRED_MESSAGE_KEY = "password-required";
	
	/** The Constant MOBILE_REQUIRED_MESSAGE_KEY. */
	public static final String MOBILE_REQUIRED_MESSAGE_KEY = "mobile-required";
	
	/** The Constant ENTER_VALID_MOBILE_MESSAGE_KEY. */
	public static final String ENTER_VALID_MOBILE_MESSAGE_KEY = "enter-valid-mobile";
	
	/** The Constant FALILED_TO_AUTHENTICATE. */
	public static final String FALILED_TO_AUTHENTICATE = "failed-to-authenticate";
	
	/** The Constant SOMTHING_WENT_WRONG. */
	public static final String SOMTHING_WENT_WRONG = "something-went-wrong";
	
	/** The Constant LOGIN_TYPE_MOBILE_SERVICE_URL. */
	public static final String LOGIN_TYPE_MOBILE_SERVICE_URL = "https://stage.omsb.gov.om/pki/mobile-pki/validate-mobile-pki?msisdn=";
	
	public static final String LOGIN_TYPE_PKI_CARD_SERVICE_URL = "https://stage.omsb.gov.om/pki/card-reader/saml/sso";
	
	public static final String FILTER = "filter=";
	
	public static final String EQ = " eq ";

	public static final String CIVIL_ID = "civilId";
	public static final String FULLNAME = "name";
	public static final String FULLNAME_AR = "nameAr";
}
