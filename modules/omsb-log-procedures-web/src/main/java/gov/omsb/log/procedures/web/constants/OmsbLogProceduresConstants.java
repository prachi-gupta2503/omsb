package gov.omsb.log.procedures.web.constants;

public class OmsbLogProceduresConstants {
	
	private OmsbLogProceduresConstants() {}

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String LOG_PROCEDURES_COUNT = "proceduresCount";

	public static final String LOGGED_PROCEDURE_ID = "loggedProcedureId";

	public static final String REMOVED_LOG_PROCEDURE_IDS = "removedProceduresId";

	public static final String PATIENT_ID = "patientId";

	public static final String PATIENT_GENDER = "patientGender";

	public static final String PATIENT_TYPE = "patientType";

	public static final String VISIT_TYPE = "visitType";

	public static final String PATIENT_DOB = "dateOfBirth";

	public static final String PROCEDURE_PERFORMED_DATE = "datePerformed";

	public static final String STORE_DATE_FORMAT = "dd-MM-yyyy";
	
	public static final String GET_DATE_FORMAT = "yyyy-MM-dd";

	public static final String VIEW_DATE_FORMAT = "MMM dd, yyyy";

	public static final String CPT_CODE = "cptCode";

	public static final String PROCEDURE_GROUP = "procedureGroup";

	public static final String PROCEDURE = "procedure";
	
	public static final String CASE_LOCATION = "caseLocation";

	public static final String DIAGNOSIS = "diagnosis";

	public static final String DIAGNOSIS_US = "diagnosisUS";

	public static final String DIAGNOSIS_SA = "diagnosisSA";

	public static final String ROLE_TYPE = "roleType";

	public static final String SUPERVISOR = "supervisor";

	public static final String COMMENTS = "comments";

	public static final String COMMENTS_US = "commentsUS";

	public static final String COMMENTS_SA = "commentsSA";


	public static final String FACULTY_ROLE_NAME = "Faculty";

	public static final String GENDER_MASTER_LIST = "genderMasters";

	public static final String PATIENT_TYPE_MASTER_LIST = "patientTypeMasters";

	public static final String VISIT_TYPE_MASTER_LIST = "visitTypeMasters";

	public static final String CPT_CODE_MASTER_LIST = "cptCodeMasters";

	public static final String PROCEDURE_GROUP_MASTER_LIST = "procedureGroupMasters";

	public static final String PROCEDURE_MASTER_LIST = "procedureMasters";
	
	public static final String TRAINING_SITE_MASTER_LIST = "trainingSiteMasters";

	public static final String ROLE_TYPE_MASTER_LIST = "roleTypeMasters";

	public static final String LOGGED_PROCEDURES = "loggedProcedures";

	public static final String UNCONFIRMED_PROCEDURES_LIST = "unconfirmedLoggedProcedures";
	
	public static final String REFUSED_LOGGED_PROCEDURES_LIST = "refusedLoggedProcedures";
	
	public static final String NOT_PASS_LOGGED_PROCEDURES_LIST = "notPassLoggedProcedures";
	
	public static final String PASS_LOGGED_PROCEDURES_LIST = "passLoggedProcedures";

	public static final String SUPERVISORS_LIST = "supervisors";

	public static final String SDF = "sdf";

	public static final String IS_CPT_ID = "isCptId";

	public static final String IS_PG_ID = "isPgId";

	public static final String IS_PROCEDURE_ID = "isProcedureId";
	
	public static final String UNCONFIRMED_STATUS = "UNCONFIRMED";
	
	public static final String START_DATE = "startDate";
	
	public static final String END_DATE = "endDate";
	
	public static final String PROCEDURE_PERFORMED_DATE_DB_COLUMN_NAME = "procedurePerformedDate";

	public static final String IS_FACULTY = "isFaculty";

	// MVC Command Names...
	public static final String ADD_LOG_PROCEDURE_ACTION_COMMAND = "addLogProcedure";

	public static final String EDIT_LOG_PROCEDURE_ACTION_COMMAND = "editLogProcedure";

	public static final String DELETE_LOG_PROCEDURE_ACTION_COMMAND = "deleteProcedureLog";

	public static final String FETCH_PG_CPT_CODE_PROCEDURE_RESOURCE_COMMAND = "fetchPgCptCodesProcedures";
	
	public static final String FILTER_LOGGED_PROCEDURE_RENDER_COMMAND = "filterLoggedProcedures";

	public static final String FETCH_TRAINING_SITE_RESOURCE_COMMAND = "fetchTrainingSite";

	// JSP Page Names...
	public static final String ADD_LOG_PROCEDURES_JSP = "/add-log-procedures.jsp";

	public static final String EDIT_LOG_PROCEDURES_JSP = "/edit-log-procedures.jsp";

	public static final String VIEW_PROCEDURES_JSP = "/view.jsp";

	
	public static final String PASS_PRODCEDURE = "/pass/procedure";
	
	public static final String REFUSE_PRODCEDURE = "/refuse/procedure";
	
	public static final String NOT_PASS_PRODCEDURE = "/notpass/procedure";
	
	public static final String TRAINEE_LOGGED_PROCEDURE_DETAILS_ID = "traineeLoggedProcedureDetailsId";
	
	public static final String TRAINEE_LOGGED_PROCEDURE_DETAILS_IDS_FOR_REFUSE = "traineeLoggedProcedureDetailsIdsForRefuse";
	
	public static final String TRAINEE_LOGGED_PROCEDURE_DETAILS_IDS_FOR_PASS = "traineeLoggedProcedureDetailsIdsForPass";
	
	public static final String TRAINEE_LOGGED_PROCEDURE_DETAILS_IDS_FOR_NOT_PASS = "traineeLoggedProcedureDetailsIdsForNotPass";
	
	public static final String PASS_COMMENT = "passComment";
	
	public static final String NOT_PASS_COMMENT = "notPassComment";
	
	public static final String REFUSE_COMMENT = "refuseComment";
	
	public static final String STATUS_ALL = "ALL";
	
	public static final String STATUS_PASS = "PASS";
	
	public static final String STATUS_NOT_PASS = "NOT PASS";
	
	public static final String STATUS_REFUSE = "REFUSE";
	
	public static final String STATUS_PASSED = "PASSED";
	
	public static final String STATUS_NOT_PASSED = "NOT PASSED";
	
	public static final String STATUS_REFUSED = "REFUSED";
		
	public static final String STATUS_UNCONFIRMED = "UNCONFIRMED";
	
	public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";
	
	public static final String REDIRECT = "redirect";
	
	public static final String SHOW_MODAL = "showModal";

	public static final String TAB_NAME = "tab";

	public static final String STATUS = "status";
}
