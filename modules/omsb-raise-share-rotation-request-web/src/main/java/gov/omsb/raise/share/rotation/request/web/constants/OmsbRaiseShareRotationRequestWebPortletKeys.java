package gov.omsb.raise.share.rotation.request.web.constants;

/**
 * @author HP
 */
public class OmsbRaiseShareRotationRequestWebPortletKeys {
	
	private OmsbRaiseShareRotationRequestWebPortletKeys() {}

	public static final String OMSBRAISESHAREROTATIONREQUESTWEB =
		"gov_omsb_raise_share_rotation_request_web_OmsbRaiseShareRotationRequestWebPortlet";
	
	public static final String ADD_RAISE_SHARE_ROTATION_REQUEST_JSP = "/add-share-rotation-request.jsp";
	public static final String EDIT_RAISE_SHARE_ROTATION_REQUEST_JSP = "/edit-share-rotation-request.jsp";
	
	public static final String ADD_RAISE_SHARE_ROTATION_REQUEST_MVC_RENDER_COMMAND = "/";
	public static final String EDIT_RAISE_SHARE_ROTATION_REQUEST_MVC_RENDER_COMMAND = "/edit/shareRotationRequest";
	
	public static final String SAVE_RAISE_SHARE_ROTATION_REQUEST_MVC_ACTION_COMMAND = "/save/shareRotationRequest";
	public static final String DELETE_RAISE_SHARE_ROTATION_REQUEST_MVC_ACTION_COMMAND = "/delete/shareRotationRequest";
	
	public static final String GET_RAISE_SHARE_ROTATION_REQUEST_PROGRAM_DURATION_MVC_RESOURCE_COMMAND = "/get/shareRotationRequestProgramDuration";
	public static final String GET_RAISE_SHARE_ROTATION_REQUEST_PROGRAM_MVC_RESOURCE_COMMAND = "/get/shareRotationRequestProgram";
	public static final String GET_SHARE_ROTATION_PROGRAM_USER_DETAIL_MVC_RESOURCE_COMMAND = "/get/shareRotationProgramUserDetail";

	public static final String PROGRAM_MASTER = "programMaster";
	public static final String PROGRAM_DURATION_DETAILS = "programDurationDetails";
	public static final String SHARED_ROTATION_REQUEST_DETAILS = "sharedRotationRequestDetails";

	public static final String PROGRAM_ID = "programId";
	public static final String ROTAION_ID = "rotationId"; 
	public static final String PROGRAM_DURATION_ID = "programDurationId";
	public static final String SHARE_ROTATION_REQUEST_ID = "sharedRotationRequestId";
	public static final String RE_SHARE_ROTATION_REQUEST_ID = "reSharedRotationRequestId";
	
	public static final String AY_APPLICABLE_FORM = "ayApplicableForm";
	public static final String NO_OF_TRAINEES_REQUESTED = "noOfTraineesRequested";
	public static final String SHARED_ROTATION_REQUEST_DETAIL = "sharedRotationRequestDetail";
	public static final String REQUESTER_COMMENT = "requesterComment";
	public static final String COMMENT = "comment";
	public static final String REQUEST_RAISED_TO = "requestRaisedTo";
	public static final String REQUEST_RAISED_TO_USER_DETAIL = "requestRaisedToUserDetail";
	public static final String REQUEST_RAISED_TO_USER_IMAGE = "requestRaisedToUserImage";
	public static final String IS_RAISED_AGAIN ="isRaisedAgain";
	public static final String RE_NO_OF_TRAINEES_REQUESTED = "reNoOfTraineesRequested";
	public static final String SHOW_MODAL = "showModal";
	
	public static final String COHORT_MAP = "cohortMap";
	public static final String RAISED_REQUEST_TO_USER_MAP = "raisedRequestToUserMap";

	public static final String ROTATION_MAP = "rotationMap";
	public static final String PROGRAM_MAP = "programMap";
	public static final String PROGRAM_USER_DETAILS_MAP = "programUserDetailsMap";
	public static final String PROGRAM_USER_IMAGE_MAP = "programUserImageMap";
	public static final String REQUEST_RAISED_TO_USER_MAP = "requestRaisedToUserMap";
	public static final String PROGRAM_AND_PROGRAM_DURATION_MAP = "programAndProgramDurationMap";
	
	public static final String ROTATION_MASTER_LIST = "rotationMasterList";
	public static final String REQUEST_RAISED_TO_USER_LIST = "requestRaisedToUserList";
	public static final String REQUESTED_SHARE_ROTATION_LIST = "requestedShareRotationList";
	public static final String PROG_DURATION_ROTATION_TRAINING_SITES_REL_LIST = "progdurationRotationTrainingsitesRelList";

}