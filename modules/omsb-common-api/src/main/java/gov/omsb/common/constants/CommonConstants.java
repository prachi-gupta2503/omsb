package gov.omsb.common.constants;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class CommonConstants {
	private CommonConstants() {
	}
	public static final String CASE_NUMBER = "{case-number}";
	public static final String BEARER = "Bearer";
	public static final String BASIC = "Basic";
	public static final String LF_BSIC_AUTH_USERNAME = GetterUtil.getString(PropsUtil.get("liferay.basic.auth.user.name")); 
	public static final String LF_BSIC_AUTH_PASSWORD = GetterUtil.getString(PropsUtil.get("liferay.basic.auth.password"));
	public static final String SCOPES = "scopes";
	public static final String PARENT_FOLDER_NAME = "OMSB";
	public static final String LEVEL_1_FOLDER_NAME = "EPortal";
	public static final String DOCUMENT_ID_VAR = "{doc-id}";
	public static final String GUEST_GROUP_KEY = "Guest";
	public static final String ERC = "ERC";
	public static final String LR_USERID = "lrUserId";
	
	public static final String PROGRAM_DETAILS_PAGE_URL = "/program-details.jsp";
	public static final String PROGRAM_LIST_PAGE_URL = "/program-list.jsp";
	public static final String PROGRAM_DETAILS_MVC_COMMAND = "/program-details";
	public static final String PROGRAM_LIST_MVC_COMMAND = "/program-list";
	
	public static final String PROGRAM = "program";
	public static final String OTHER_PROGRAM_LIST = "otherProgramList";
	public static final String PROGRAM_LIST = "programList";
	public static final String PROGRAM_NAME = "programName";
	public static final String PROGRAM_STATUS = "programStatus";
	public static final String PROGRAM_MASTER_ID = "programMasterId";
	public static final String PROGRAM_TYPE = "programType";
	public static final String RENDER_URL = "renderUrl";
	public static final String SUCCESS = "success";
	public static final String RESULT = "result";
	public static final String PENDING = "Pending";
	public static final String STATUS_ACCEPT = "Approved";
	public static final String STATUS_ACCEPT_PARTIALLY = "Approved & Partially Alloted";
	public static final String STATUS_REJECT = "Rejected";
	public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";
	public static final String ERROR = "error";
	
	public static final String ROTATION_ADD_PAGE_URL = "/add-rotation.jsp";
	public static final String ROTATION_EDIT_PAGE_URL = "/edit-rotation.jsp";
	public static final String ROTATION_LIST_PAGE_URL = "/rotation-list.jsp";
	public static final String ROTATION_DETAILS_PAGE_URL = "/rotation-details.jsp";
	public static final String ROTATION_ADD_MVC_RENDER_COMMAND = "/add-rotation-form";
	public static final String ROTATION_EDIT_MVC_RENDER_COMMAND = "/edit-rotation-form";
	public static final String ROTATION_SAVE_MVC_ACTION_COMMAND  = "/save/rotation";
	public static final String ROTATION_LIST_MVC_RESOURCE_COMMAND = "/rotation-list";
	public static final String ROTATION_DETAILS_MVC_RENDER_COMMAND = "/rotation-details";
	public static final String ROTATION_DELETE_MVC_ACTION_COMMAND  = "/delete/rotation";

	public static final String ROTATION_LIST_OTHER = "otherRotationList";
	public static final String ROTATION_MASTER_ID = "rotationMasterId";
	public static final String ROTATION_TYPE = "rotationType";
	public static final String ROTATION_CODE = "rotationCode";
	public static final String ROTATION_NAME = "rotationName";
	public static final String ROTATION_SHORT_NAME = "rotationShortName";
	public static final String ROTATION_OBJECTIVES = "rotationObjectives";
	public static final String ROTATION_IS_SHARED = "isSharedRotation";
	public static final String ROTATION_STATUS = "rotationStatus";
	public static final String ROTATION = "rotation";
	public static final String TRAINEE_LEVEL_LIST = "traineeLevelList";
	public static final String ROTATION_STRUCTURE_LIST = "rotationStructureList";
	public static final String REDIRECT_COMMAND_URL = "redirectCommand";
	
	public static final String ROLE_PROGRAM_ADMINISTRATOR = "Program Administrator";
	public static final String ROLE_PROGRAM_DIRECTOR = "Program Director";
	public static final String ROLE_SITE_AUTHORIZED_USER = "Site Authorized User";
	public static final String ROLE_CHAIRMAN = "Chairman";
	public static final String ROLE_TRAINEE = "Trainee";
	public static final String ROLE_FACULTY = "Faculty";
	public static final String IS_TRAINEE_USER = "isTraineeUser";
	public static final String IS_TRAINEE_USER_OR_IS_FACULTY_USER = "isTraineeUserORisFacultyUser";
	public static final String SCOPE_GROUP_NAME = "scopeGroupName";

	public static final String LANGUAGE_CODE_ENGLISH = "en_US";
	public static final String LANGUAGE_CODE_ARABIC = "ar_SA";
	public static final String CUSTOM_LANGUAGE_CODE_ENGLISH = "US";
	public static final String CUSTOM_LANGUAGE_CODE_ARABIC = "SA";

	public static final String EQUIVALENCY_CERT_TEMPLATE_KEY = "47613";
	
	public static final String CMD_ASSIGN_TO_ME = "assignToMe";
	public static final String CMD_COMPLETE_WORKFLOW = "completeWorkflow";
	
	public static final String MOBILE_NOTIFICATION_PARAM_PHONE_NO = "phoneno";
	public static final String MOBILE_NOTIFICATION_PARAM_MESSAGE = "message";
	public static final String MOBILE_NOTIFICATION_URL = "https://stage.omsb.gov.om/pki/sms-getway/SendSms?";
	
	public static final String CARD_READER_IDP_URL = "https://stage.omsb.gov.om/pki/card-reader/saml/sso";
	
	public static final String SENDER_EMAIL = "sender@mail.com";
}
