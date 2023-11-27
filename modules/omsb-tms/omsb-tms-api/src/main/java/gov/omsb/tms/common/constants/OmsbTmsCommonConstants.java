package gov.omsb.tms.common.constants;

public class OmsbTmsCommonConstants {

	private OmsbTmsCommonConstants() {
	}
	
	public static final String USER_ID = "userId";
	public static final String NOTIFICATION_TEXT = "notificationText";
	public static final String EMAIL_TITLE = "emailTitle";
	public static final String SENDER_NAME = "senderName";
	public static final String USER_NAME = "userName";
	public static final String PROGRAM_NAME = "ProgramName";
	public static final String PROGRAM_CODE = "ProgramCode";
	public static final String PROGRAM_VISION = "ProgramVision";
	public static final String PROGRAM_MISSION = "ProgramMission";
	public static final String PROGRAM_DESCRIPTION = "ProgramDescription";
	public static final String PROGRAM_OBJECTIVES = "ProgramObjectives";
	public static final String PROGRAM_ADMISSION_REQUIREMENTS = "ProgramAdmissionRequirements";
	public static final String PROGRAM_TYPE = "ProgramTypeName";
	public static final String ELIGIBILITY_DEGREE = "EligibilityDegree";
	public static final String TRAINEE_SITE_CODE="TrainingSiteCode";
	public static final String GET_DUTY_LOG_VIOLATION_LIST_BY_USER_ID="getDutyLogViolationListByUserId";
	public static final String GET_DUTY_LOG_VIOLATION_LIST="getDutyLogViolationList";
	public static final String GET_DUTY_LOG_HOURS_LIST="getDutyLogHoursList";
	public static final String GET_FACULTY_SITE_COMPENSATION_REPORT_DETAILS_OF_EC_MEMBER="getFacultySiteCompensationReportDetailsOfEcMember";
	public static final String GET_TRAINING_SITE_NAME_WITH_ROTATION ="getTrainingSiteNameWithRotation";
	public static final String GET_TRAINING_SITE_BY_ROTATION ="getTrainingSiteByRotation";
	public static final String GET_TRAINEE_NO_OF_BLOCKS ="getTraineeNoofBlocks";
	public static final String GET_DUTY_LOG ="getDutyLog";
	public static final String CHECK_ACGME_CALL_RULE_8HOURS ="checkAcgmeCallRule8Hour";
	public static final String CHECK_ACGME_CALL_RULE_48HOURS ="checkAcgmeCallRule48Hour";
	public static final String GET_DUTY_LOGS ="getDutyLogs";
	public static final String GET_ALL_PROGRAMS = "getAllPrograms";
	public static final String GET_ROTATION_STRUCTURE = "getRotationStructure";
	public static final String GET_PROGRAM_DETAILS = "getProgramDetails";
	public static final String GET_TRAINING_SITE_STRUCTURE = "getTrainingSiteStructure";
	public static final String GET_PROGRAM_STRUCTURE = "getProgramStructure";
	public static final String GET_PROCEDURE_GROUP = "getProcedureGroups";
	public static final String GET_CPT_CODES = "getCptCodes";
	public static final String GET_SETUP_PROCEDURE_DETAILS = "getSetUpProcedureDetails";
	public static final String GET_TRAINEE_LEVEL_BY_PD_ID = "getTraineeLevelsByProgDurationId";
	public static final String GET_ROTATIONS_BY_TL_ID = "getRotationsByTraineeLevelId";
	public static final String GET_ROTATIONS_BY_TL_ID_AND_PROGRAM_DURATION_ID = "getRotationsByTraineeLevelIdAndProgramDurationId";
	public static final String GET_SHARED_ROTATIONS_ID_FOR_APPROVER = "getSharedRotationIdForApprover";
	public static final String GET_TRAINING_SITES_BY_PD = "getTrainingSiteDetailsByProgramDuration";
	public static final String GET_SITE_CAPACITY_DETAILS = "getSiteCapacityDetails";
	public static final String GET_TRAINING_SITES_CAPACITY_DETAILS = "getProgramTrainingSitesCapacityDetails";
	public static final String GET_PROGRAM_COHORTS = "getProgramCohorts";
	public static final String GET_PROGRAM_AND_COHORTS_FROM_PROGRAM_DURATION = "getProgramAndCohortsFromProgramDuration";
	public static final String GET_ROTATIONS_BY_TS_ID = "getRotationsByTrainingSiteId";
	public static final String GET_TRAINING_SITES_BY_COHORT = "getTrainingSitesByCohort";
	public static final String GET_NOT_SHARED_ROTATION_BY_TS_ID = "getNotSharedRotationsByTrainingSiteId";
	public static final String GET_VISIT_TYPE_BY_PROGRAM_DURATION_ID = "getVisitTypeByProgramDurationId";
	public static final String GET_ROLE_TYPE_BY_PROGRAM_DURATION_ID= "getRoleTypeByProgramDurationId";
	public static final String GET_PATIENT_TYPE_BY_PROGRAM_DURATION_ID= "getPatientTypeByProgramDurationId";
	public static final String GET_ROTATIONS_BY_TRAINING_SITE_AND_COHORT = "getRotationsByTrainingSiteAndCohort";
	public static final String GET_TRAINING_SITES_BY_DATE_PERFORMED = "getTrainingSiteByDatePerformed";
	public static final String GET_ROTATION_ID_BY_DATE_PERFORMED = "getRotationIdByDatePerformed";
	public static final String GET_TRAINEE_BY_PROGDURATION_AND_TRAINEE_LEVEL = "getTraineeByProgramCohortAndTraineeLevel";
	public static final String GET_RESIDENTS_IN_EACH_SITE_PER_BLOCK = "getResidentsPerRotationPerTrainingSite";
	
	public static final String TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND = "/training-site-details";
	
	
	public static final String ROTATION_DETAILS_MVC_RENDER_COMMAND = "/rotation-details";
	
	public static final String TRAINING_SITES_PORTLET_NAME = "omsb_training_sites_web_OmsbTrainingSitesWebPortlet";
	public static final String ROTATIONS_PORTLET_NAME  = "gov_omsb_rotations_web_OmsbRotationsWebPortlet";
	public static final String VIEW_PROCEDURE_PORTLET_NAME  = "gov_omsb_view_procedures_supervisor_web_OmsbViewProceduresSupervisorWebPortlet";
	public static final String SCHEDULE_MASTER_ROTATION_PORTLET_NAME = "gov_omsb_master_rotation_schedule_web_OmsbMasterRotationScheduleWebPortlet";
	public static final String CONFIGURE_SITE_CAPACITY_PORTLET_NAME = "gov_omsb_configure_site_capacity_web_OmsbConfigureSiteCapacityWebPortlet";
	public static final String VIEW_LOG_PROCEDURES_PORTLET_NAME ="gov_omsb_log_procedures_web_OmsbLogProceduresWebPortlet";
	public static final String VIEW_PROGRAM_COHORT_PORTLET_NAME = "gov_omsb_view_program_cohort_web_OmsbViewProgramCohortWebPortlet";
	public static final String ADD_PROGRAM_COHORT_PORTLET_NAME = "gov_omsb_program_cohort_web_OmsbProgramCohortWebPortlet";
	public static final String ROTATION_PORTLET_NAME = "gov_omsb_rotations_web_OmsbRotationsWebPortlet";
	public static final String VIEW_PROCEDURES_SUPERVISOR_PORTLET_NAME = "gov_omsb_view_procedures_supervisor_web_OmsbViewProceduresSupervisorWebPortlet";

	public static final String TRAINING_SITES_PORTLET_FRAINDLY_URL = "/training-sites";
	public static final String SCHEDULE_MASTER_ROTATION_FRAINDLY_URL = "/schedule-master-rotation";
	public static final String ROTATIONS_PORTLET_FRAINDLY_URL = "/rotations";
	public static final String  VIEW_PROGRAM_COHORT_PORTLET_FRAINDLY_URL = "/view-program-cohort";
	public static final String  ADD_PROGRAM_COHORT_PORTLET_FRAINDLY_URL = "/add-program-cohort";
	public static final String  ROTATION_PORTLET_FRAINDLY_URL = "/rotations";
	public static final String  VIEW_PROCEDURES_SUPERVISOR_PORTLET_FRAINDLY_URL = "/view-procedure";

	
	
	public static final String LOG_PROCEDURE_PORTLET_NAME  = "gov_omsb_log_procedures_web_OmsbLogProceduresWebPortlet";
	public static final String EDIT_LOG_PROCEDURES_JSP = "/edit-log-procedures.jsp";
	
	public static final String GET_TRAINEE_LOGGED_PROCEDURE_DETAILS_LIST_BY_SUPPERVISOR = "getTraineeLoggedProcedureDetailsListBySupervisor";	
	public static final String GET_TRAINEE_LOGGED_PROCEDURE_DETAIL_BY_SUPPERVISOR_AND_TRAINEE_LOGGED_PROCEDURE_DETAIL_ID = "getTraineeLoggedProcedureDetailBySupervisorAndTraineeLoggedProcedureDetailId";	
	public static final String GET_TRAINEE_LOGGED_PROCEDURE_DETAILS_LIST_BY_PROGRAM = "getTraineeLoggedProcedureDetailsListByProgram";	
	public static final String GET_ALL_TRAINEE_LOGGED_PROCEDURE_DETAILS_LIST = "getAllTraineeLoggedProcedureDetailsList";	

	public static final String PROCEDURE_GROUP_NAME = "ProcedureGroupName";
	public static final String CPT_CODE_NAME = "CptCodeName";
	public static final String CPT_CODE = "CptCode";
	
	public static final String VISIT_TYPE_NAME = "VisitTypeName";
	public static final String PATIENT_TYPE_NAME = "PatientTypeName";
	public static final String ROLE_TYPE_NAME = "RoleTypeName";
	public static final String TRAINEE_LEVEL_NAME = "TraineeLevelName";
	public static final String RENDER_TRAINEE_LEVEL_NAME = "traineeLevelName";
	public static final String LEVEL_TYPE_NAME = "LevelTypeName";
	public static final String ROTATION_NAME = "RotationName";
	public static final String PROCEDURE_NAME = "ProcedureName";
	public static final String RENDER_PROCEDURE_NAME = "procedureName";
	public static final String RENDER_PROCEDURE_GROUP_NAME = "procedureGroupName";
	public static final String RENDER_PROGRAM_TYPE_NAME = "programTypeName";
	public static final String RENDER_PATIENT_TYPE_NAME = "patientTypeName";
	public static final String SUPERVISOR_COMMENTS = "SupervisorComments";
	public static final String TRAINING_SITE_NAME = "TrainingSiteName";
	public static final String PROG_CODE_RSN_SITE_CODE = "progCodeRsnSitecode";
	
	public static final String EMAIL_TEMPLATE_TRAINEE_NAME = "TRAINEE_NAME";
	public static final String EMAIL_TEMPLATE_PROCEDURE_NAME = "PROCEDURE_NAME";
	public static final String EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE = "PROCEDURE_PERFORMED_DATE";
	public static final String EMAIL_TEMPLATE_STATUS = "STATUS";
	public static final String EMAIL_TEMPLATE_SUPERVISOR_NAME = "SUPERVISOR_NAME";
	public static final String EMAIL_TEMPLATE_REDIRECT_LINK = "REDIRECT_LINK";
	public static final String GET_TRAINEE_LEVEL = "getTraineeLevel";
	
	public static final String PROGRAM_TYPE_NAME_ERROR = "programTypeNameError";
	public static final String PARTICIPATION_TYPE_NAME_ERROR = "participationTypeNameError";
    public static final String PROCEDURE_NAME_ERROR = "procedureNameError";
    public static final String TRAINEE_LEVEL_NAME_ERROR = "traineeLevelError";
    public static final String PROCEDURE_GROUP_NAME_ERROR = "procedureGroupNameError";
    public static final String PATIENT_ID_DUPLICATION_ERROR = "patientIdDuplicationError";
    public static final String PATIENT_TYPE_NAME_ERROR = "patientTypeNameError";
    public static final String LANGUAGE_CODE_ENGLISH = "en_US";
    public static final String LANGUAGE_CODE_ARABIC = "ar_SA";
    
    public static final String PROGRAM_MASTER_LIST = "programMasterList";
    public static final String YEAR_RANGE = "yearRange";
	public static final String TRAINEE_LEVEL_MASTERS = "traineeLevelMasters";
	public static final String LEVEL_TYPE_MASTERS = "levelTypeMasters";
	public static final String PROGRAM_COHORT_DTOS = "programCohortDTOs";
	public static final String GET_CONFIGURE_ROTATION_DETAILS = "getConfigureRotationDetails";
	public static final String ROTATION_TYPE = "rotationType";
	public static final long ROTATION_TYPE_ELECTIVE = 2;

	public static final String SHARED_ROTATION_REQUESTER_NAME = "requesterName";
	public static final String SHARED_ROTATION_APPROVER_NAME = "approverName";
	public static final String SHARED_ROTATION_REQUESTED_TRAINEES = "requestedTrainee";
	public static final String SHARED_ROTATION_APPROVED_TRAINEES = "approvedTrainee";
	public static final String SHARED_ROTATION_NAME = "rotationName";
	public static final String SHARED_ROTATION_PROGRAM_NAME = "programName";
	public static final String SHARED_ROTATION_REQUEST_PORTLET = "gov_omsb_raise_share_rotation_request_web_OmsbRaiseShareRotationRequestWebPortlet";
	public static final String SHARED_ROTATION_APPROVE_PORTLET = "gov_omsb_approve_shared_rotation_web_OmsbApproveSharedRotationWebPortlet";
	public static final String STATUS = "status";
	public static final String ROLE = "role";
	public static final String LINK = "link";
	public static final String VIEW_REDIRECT_LINK = "viewDetailUrl";
	public static final String JSP_PAGE = "jspPage";
	
	public static final String PA_NAME = "paName";
	public static final String TRAINEE_LEVEL = "traineeLevel";
	public static final String TRAINEE_NAME = "traineeName";
	public static final String FACULTY_NAME = "FacultyName";
	
	public static final String TRAINING_SITES_TRAINING_SITE_NAME = "trainingSiteName";
	public static final String TRAINING_SITES_CURRENT_SLOTS = "currentSlots";
	public static final String TRAINING_SITES_DEMAND_SLOTS = "demandSlots";
	
	public static final String PROGRAM_DURATION_ID = "programDurationId";
	public static final String PROGDURATION_TLBLOCKS_LT_ID = "progdurationTlBlocksLtId";
	public static final String EDIT_RENDER_URL = "editRenderUrl";
	public static final String SCHEDULE_MASTER_ROTATION_RENDER_URL = "scheduleMasterRotationRenderUrl";

	public static final String GET_CONFIGURE_ROTATION_EDIT_DETAILS = "getConfigureRotationDetailsByProgramAndDuration";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String GET_PROGDURATION_ROTATION_BY_ROTATION_AND_DURATION = "getProgdurationRotationByRotationAndDuration";
	public static final String GET_CONFIGURE_ROTATION_DETAILS_BY_ROTATION_AND_DURATION = "getConfigureRotationDetailsByRotationAndDuration";

	public static final String ROTATION_MASER_LIST = "rotationMasterList";
	public static final String TRAINING_SITE_MASTER_LIST = "trainingSiteMasterList";
	public static final String PROGRAM_DURATION_DETAILS_LIST = "programDurationDetailsList";
	public static final String DEFINE_ROTATION_AND_SHARED_ROTATIONS_LIST = "defineRotationAndSharedRotationsList";
	public static final String PROGRAM = "program";
	public static final String PROGRAM_MASTER_ID = "programMasterId";
	public static final String GET_EC_MEMBERSHIP_REQUEST_DATA="getECMembershipRequestData";
	public static final String REQUESTER_ROLE = "Requestor";
	public static final String EC_SECTION_STAFF_ROLE = "EC Section Staff";
	public static final String EC_SECTION_HEAD_ROLE = "EC Section Head";
	public static final String GME_DIRECTOR_ROLE = "GME Director";
	public static final String VPAA_ROLE = "VPAA";
	public static final String EXECUTIVE_PRESIDENT_ROLE = "Executive President";	
	public static final String AUTHORIZED_INDIVIDUAL_ROLE = "Authorized Individual";
	public static final String POTENTIAL_EC_MEMBER_ROLE = "Potential EC Member";
	public static final String IS_ALL_TRAINEE_TAKEN_LEAVE_FOR_CURRENT_YEAR = "isAllTraineeTakenLeaveForCurrentYear";
	public static final String IS_CURRENT_YEAR_TRAINEE_LEVEL = "isCurrentYearTraineeLevel";
	public static final String VIEW_PROGRAM_COHORT_RENDER_URL_LABEL = "viewProgramCohortRenderUrl";
	public static final String ADD_PROGRAM_COHORT_RENDER_URL_LABEL = "addProgramCohortRenderUrl";
	public static final String LEAVE = "leave";

	
	/* LR Roles */
	public static final String FACULTY_ROLE = "Faculty";
	public static final String TRAINEE_ROLE = "Trainee";
	
	public static final String PROG_DURATION_ID = "progDurationId";
	public static final String ROTATION_MASTER_ID = "rotationMasterId";
	public static final String IS_SHARED_ROTATION = "isSharedRotation";
	public static final String SHARED_PROGRAM_ID = "sharedProgramId";
	public static final String SHARED_PROGRAM_MASTER_ID = "sharedProgramMasterId";
	public static final String TRAINING_SITE_MASTER_ID = "trainingSiteMasterId";
	public static final String SHARED_PROGRAM_DURATION_ID = "sharedProgramDurationId";
	public static final String GET_TRAINING_SITE_DETAILS_BY_PROGRAM = "getTrainingSiteDetailsByProgram";
	public static final String GET_TRAINING_SITE_DETAILS_BY_PROGRAM_MASTER = "getTrainingSiteDetailsByProgramMaster";
	public static final String No_OF_SLOTS = "noOfSlots";
	public static final String GET_EC_MEMBERSHIP_REQUEST_State_DATA = "getECMembershipRequestStateData";
	public static final String COHORT = "cohort";
	public static final String BLOCK = "block";
	public static final String WEEK = "week";
	public static final String YEAR_START_DATE_FOR_BLOCK = "01-09-";
	
	public static final String IS_DRAFT= "isDraft";
	public static final String IS_FACULTY= "isFaculty";
	public static final String STATUS_DRAFT = "DRAFT";
	public static final String STATUS_COMPLETED = "COMPLETED";
	
	/* Date Formates*/
	public static final String DATE_TIME_FORMAT = "dd-MM-yyyy hh:mm:ss";
	public static final String DATE_FORMAT_DD_MM_YYYY = "dd-MM-yyyy";
	
	public static final String BLOCK_NAME = "Block";
	public static final String BLOCK_WEEK = "Block-Week";
	public static final String LEAVE_ANNUAL_RULE_ID_COLUMN = "leaveAnnualRuleId";
	public static final String BLOCK_COLUMN = "block";
	public static final String WEEK_COLUMN = "week";
	
    public static final String PA_ROLE = "Program Administrator";
    public static final String MY_SCHEDULE_WEB_PORTLET = "gov_omsb_my_schedule_web_OmsbMyScheduleWebPortlet";
    
    public static final String ASSIGNED_ROTATION = "assignedRotation";
    public static final String TRAINEE_LEVEL_AND_BLOCKS = "traineeLevelAndBlocks";
    public static final String TRAINEE_LEVEL_MASTER_ID = "traineeLevelMasterId";
    public static final String NO_OF_BLOCKS = "noOfBlocks";
    public static final String NOTIFICATION_MESSAGE = "notificationMessage";
    
    public static final String GET_FACULTY_REQUEST_DATA="getFacultyRequestData";
    
    //Email template name
    public static final String APPROVE_SHARED_ROTAITONS_EMAIL_NOTIFICATION = "Approve Shared Rotations Email Notification";
    public static final String MASTER_ROTATION_TRAINEE_EMAIL_NOTIFICATION = "Master Rotation Trainee Email Notification";
    public static final String MASTER_ROTATION_FACULTY_EMAIL_NOTIFICATION = "Master Rotation faculty Email Notification";
    public static final String MASTER_ROTATION_PAUSER_EMAIL_NOTIFICATION = "Master Rotation PA User Email Notification";
    public static final String MASTER_ROTATION_ECMEMBER_EMAIL_NOTIFICATION = "Master Rotation EC Member Email Notification";
    public static final String REQUEST_SHARED_ROTATION_EMAIL_NOTIFICATION = "Request Shared Rotation Email Notification";
    public static final String LOGGED_PROCEDURE_ACTION_STATUS_EMAIL_NOTIFICATION_FOR_SUPERVISOR = "Logged Procedure Action Status Email Notification For Supervisor";
    public static final String LOGGED_PROCEDURE_ACTION_STATUS_EMAIL_NOTIFICATION_FOR_TRAINEE = "Logged Procedure Action Status Email Notification For Trainee";
}
