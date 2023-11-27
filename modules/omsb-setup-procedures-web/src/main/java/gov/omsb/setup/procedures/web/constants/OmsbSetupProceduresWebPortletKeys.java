package gov.omsb.setup.procedures.web.constants;

/**
 * @author Aditya Meghnathi
 */
public class OmsbSetupProceduresWebPortletKeys {

	private OmsbSetupProceduresWebPortletKeys() {
	}

	public static final String OMSBSETUPPROCEDURESWEB = "gov_omsb_setup_procedures_web_OmsbSetupProceduresWebPortlet";

	public static final String RENDER_ALL_PROGRAM_LIST = "allProgramList";
	public static final String RENDER_ALL_PROCEDURE_GROUPS = "allProcedureGroups";
	public static final String RENDER_ALL_PARTICIPATION_TYPE = "allParticipationType";
	public static final String RENDER_ALL_TRAINEE_LEVEL_LIST = "allTraineeLevels";
	public static final String RENDER_ALL_ROTATIONS = "allRotations";
	public static final String RENDER_ALL_CPT_CODES = "allCptCodes";
	public static final String RENDER_ALL_PROGRAM_DURATIONS = "allProgramDurations";
	public static final String RENDER_ALL_PROCEDURES = "allProcedures";
	public static final String DATE_FORMAT_DD_MM_YYYY = "dd-MM-yyyy";

	public static final String GET_VISIT_TYPE_MVC_RESOURCE_COMMAND_NAME = "/getVisitType";
	public static final String GET_ROLE_TYPE_MVC_RESOURCE_COMMAND_NAME = "/getRoleType";
	public static final String GET_PATIENT_TYPE_MVC_RESOURCE_COMMAND_NAME = "/getPatientType";
	public static final String GET_PROCEDURE_MASTER_MVC_RESOURCE_COMMAND_NAME = "/getProcedureMaster";
	public static final String SAVE_PROCEDURE_MVC_RESOURCE_COMMAND_NAME = "/save/procedure";
	public static final String SAVE_PROCEDURE_GROUP_MVC_RESOURCE_COMMAND_NAME = "/save/procedure/group";

	public static final String GET_PROCEDURE_GROUP_MASTER_MVC_RESOURCE_COMMAND_NAME = "/getProcedureGroupMaster";

	public static final String VIEW_JSP = "/view.jsp";
	public static final String ADD_SETUP_PROCEDURE_JSP = "/add-setup-procedure.jsp";
	public static final String EDIT_SETUP_PROCEDURE_JSP = "/edit-setup-procedure.jsp";
	public static final String EDIT_PROCEDURE_JSP = "/edit-procedures.jsp";

	public static final String EDIT_VISIT_TYPE_PROG_DURATION_MVC_COMMAND_NAME = "/editVisitTypeProgDuration";
	public static final String EDIT_ROLE_TYPE_PROG_DURATION_MVC_COMMAND_NAME = "/editRoleTypeProgDuration";
	public static final String EDIT_PATIENT_TYPE_PROG_DURATION_MVC_COMMAND_NAME = "/editPatientTypeProgDuration";
	public static final String EDIT_PROCEDURE_NAME = "editProcedureName";
	public static final String DELETE_PROCEDURE_LOGGING_PARAMETERS_MVC_COMMAND_NAME = "/deleteProcedureLoggingParameters";

	public static final String SAVE_SETUP_PROCEDURE_MVC_COMMAND_NAME = "saveSetupProcedure";
	public static final String DELETE_SETUP_PROCEDURE_MVC_COMMAND_NAME = "deleteSetupProcedure";
	public static final String RENDER_EDIT_SETUP_PROCEDURE_MVC_COMMAND_NAME = "renderEditSetupProcedure";
	public static final String PROGDURATION_TS_ROTATION_TL_PG_PROCEDURE_PT_REL_ID = "progdurationRotationTlPgProcedurePtRelId";
	public static final String RENDER_SETUP_PROCEDURE_LIST = "setUpProceduresList";
	public static final String RENDER_EDIT_SETUP_PROCEDURE_DETAILS = "editSetupProcedureDetails";
	public static final String SAVE_PROCEDURE_LOGGING_PARAMETER_MVC_ACTION_COMMAND = "/save/procedure/logging/parameter";

	public static final String PROGRAM_DURATION = "programDuration";
	public static final String PROGRAM_DURATION_ID = "programDurationId";
	public static final String PROGRAM_DURATION_FOR_CONFIG = "programDurationForConfig";
	public static final String PROGRAM_DURATION_FOR_ROLE = "programDurationForRole";
	public static final String PROGRAM_DURATION_FOR_VISIT = "programDurationForVisit";
	public static final String PROGRAM_DURATION_FOR_PATIENT = "programDurationForPatient";
	public static final String ROTATION = "rotation";
	public static final String TRAINEE_LEVEL = "traineeLevel";
	public static final String PROCEDURE_GROUP = "procedureGroup";
	public static final String PROCEDURES = "procedures";
	public static final String PARTICIPATION_TYPE = "participationType";
	public static final String MINIMUM_PROCEDURES = "minimumProcedures";
	public static final String CPT_CODES = "cptCodes";
	public static final String PROGRAM = "program";
	public static final String PROGRAM_ID = "programId";
	public static final String ROLE_TYPE_ID = "roleTypeId";
	public static final String ROLE_TYPE_MASTER_ID = "roleTypeMasterId";
	public static final String ROLE_TYPE_NAME = "roleTypeName";
	public static final String ROLE_TYPE = "roleType";
	public static final String COHORT = "cohort";
	public static final String SDF = "sdf";
	public static final String CREATE_DATE = "createdDate";
	public static final String MODIFIED_DATE = "modifiedDate";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String PROGRAM_NAME_COHORT = "programNameCohortMap";
	public static final String PROCEDURE_ID = "procedureId";
	public static final String PROCEDURE_NAME = "procedureName";
	public static final String PROCEDURE_GROUP_ID = "procedureGroupId";
	public static final String PROCEDURE_GROUP_NAME = "procedureGroupName";
	public static final String PROCEDURE_LOGGING_PARAMETER_ID = "procedureLoggingParamterId";
	public static final String LEAVE = "LEAVE";

	public static final String MASTER_NAME = "masterName";
	public static final String MASTER_VALUE = "masterValue";
	public static final String VISIT_TYPE_ID = "visitTypeId";
	public static final String VISIT_TYPE_MASTER_ID = "visitTypeMasterId";
	public static final String VISIT_TYPE_NAME = "visitTypeName";
	public static final String VISIT_TYPE = "visitType";
	public static final String PATIENT_TYPE_ID = "patientTypeId";
	public static final String PATIENT_TYPE_NAME = "patientTypeName";
	public static final String PATIENT_TYPE = "patientType";
	public static final String TRAINEE_LEVEL_MINIMUM_PROCEDURES = "traineelevelMinimumProcedures";
	public static final String CONFIGURE_PROCEDURE_ROTATION_JSON = "configureProcedureRotationJson";

	public static final String PATIENT_TYPE_MASTER_ID = "patientTypeMasterId";
	public static final String PROCEDURE_PROG_DURATION_REL_ID = "procedureProgDurationRelId";
	public static final String PROCEDURE_TYPE_PROG_DURATION_REL_ID = "procedureTypeProgDurationRelId";
	public static final String PROCEDURE_TYPE_PROG_DURATION_REL_NAME = "procedureTypeProgDurationRelName";
	public static final String PATIENT_TYPE_PROG_DURATION_REL_ID = "patientTypeProgDurationRelId";
	public static final String ROLE_TYPE_PROG_DURATION_REL_ID = "roleTypeProgDurationRelId";
	public static final String VISIT_TYPE_PROG_DURATION_REL_ID = "visitTypeProgDurationRelId";
	public static final String PATIENT_TYPE_PROG_DURATION_REL_NAME = "patientTypeProgDurationRelName";
	public static final String ROLE_TYPE_PROG_DURATION_REL_NAME = "roleTypeProgDurationRelName";
	public static final String VISIT_TYPE_PROG_DURATION_REL_NAME = "visitTypeProgDurationRelName";

	public static final String RENDER_EDIT_TRAINEE_LIST = "editTraineeLevelList";
	public static final String RENDER_EDIT_ROTATION_LIST = "editRotationList";
	public static final String RENDER_EDIT_PROGRAM_LIST = "editProgramList";
	public static final String RENDER_EDIT_PROGRAM_DURATION_LIST = "editProgramDurationList";
	public static final String RENDER_EDIT_PROCEDURE_MASTER_LIST = "editProcedureMasterList";
	public static final String VISIT_TYPE_PROG_DURATION_REL_LIST = "visitTypeProgDurationRelList";
	public static final String ROLE_TYPE_PROG_DURATION_REL_LIST = "roleTypeProgDurationRelList";
	public static final String PATIENT_TYPE_PROG_DURATION_REL_LIST = "patientTypeProgDurationRelList";
	public static final String PROGRAM_DURATION_DETAILS_LIST = "programDurationDetailsList";
	public static final String VISIT_TYPE_DROPDOWN_LIST = "visitTypeDropdownList";
	public static final String ROLE_TYPE_DROPDOWN_LIST = "roleTypeDropdownList";
	public static final String PATIENT_TYPE_DROPDOWN_LIST = "patientTypeDropdownList";
	public static final String VISIT_TYPE_TABLE_LIST = "visitTypeTableList";
	public static final String ROLE_TYPE_TABLE_LIST = "roleTypeTableList";
	public static final String PATIENT_TYPE_TABLE_LIST = "patientTypeTableList";
	public static final String PROGRAM_MASTER_DROPDOWN_LIST = "programMasterDropdownList";

	public static final String VISIT_TYPE_MAPPING = "visitTypeMapping";
	public static final String ROLE_TYPE_MAPPING = "roleTypeMapping";
	public static final String PATIENT_TYPE_MAPPING = "patientTypeMapping";

	public static final String PROGRAM_NAME_COHORT_MAP = "programNameCohotMapping";
	public static final String JSON_OBJ_KEY_PROCEDURE = "procedure";
	public static final String JSON_OBJ_KEY_ROTATIONS = "rotations";

	public static final String IS_CREATE = "isCreate";
	public static final String IS_EDIT = "isEdit";

	public static final String PATIENT_TYPE_NAME_ERROR = "patient-type-name-error";
	public static final String VISIT_TYPE_NAME_ERROR = "visit-type-name-error";
	public static final String ROLE_TYPE_NAME_ERROR = "role-type-name-error";
	public static final String PROCEDURE_GROUP_NAME_ERROR = "procedure-group-name-error";
	public static final String CONFIGURE_PROCEDURE_ERROR = "configure-procedure-error";

	public static final String PATIENT_TYPE_NAME_SUCCESS = "patient-type-name-add-success";
	public static final String VISIT_TYPE_NAME_SUCCESS = "visit-type-name-add-success";
	public static final String ROLE_TYPE_NAME_SUCCESS = "role-type-name-add-success";
	public static final String PROCEDURE_GROUP_NAME_SUCCESS = "procedure-group-name-add-success";
	public static final String CONFIGURE_PROCEDURE_SUCCESS = "configure-procedure-add-success";
	public static final String CONFIGURE_PROCEDURE_PARTIALLY_SUCCESS = "configure-procedure-data-partially-saved";

	public static final String PATIENT_TYPE_NAME_EDIT_SUCCESS = "patient-types-name-edit-success";
	public static final String VISIT_TYPE_NAME_EDIT_SUCCESS = "visit-type-name-edit-success";
	public static final String ROLE_TYPE_NAME_EDIT_SUCCESS = "role-type-name-edit-success";
	public static final String PROCEDURE_GROUP_NAME_EDIT_SUCCESS = "procedure-group-name-edit-success";
	public static final String CONFIGURE_PROCEDURE_EDIT_SUCCESS = "configure-procedure-edit-success";
	public static final String CONFIGURE_PROCEDURE_PARTIALLY_EDIT_SUCCESS = "configure-procedure-data-partially-edited";

	public static final String PATIENT_TYPE_DELETE_SUCCESS = "patient-type-name-delete-success";
	public static final String VISIT_TYPE_DELETE_SUCCESS = "visit-type-name-delete-success";
	public static final String ROLE_TYPE_DELETE_SUCCESS = "role-type-name-delete-success";
	public static final String PROCEDURE_GROUP_DELETE_SUCCESS = "procedure-group-name-delete-success";
	public static final String CONFIGURE_PROCEDURE_DELETE_SUCCESS = "configure-procedure-delete-success";

	public static final String SELECT_PROGRAM_FOR_PATIENT = "selectProgramForPatient";
	public static final String SELECT_PROGRAM_FOR_ROLE = "selectProgramForRole";
	public static final String SELECT_PROGRAM_FOR_VISIT = "selectProgramForVisit";
	public static final String SELECT_PROGRAM_FOR_CONFIG = "selectProgramForConfig";

	public static final String EDIT_URL = "editURL";
	public static final String HAS_NAME_ERROR = "hasNameError";
	public static final String HAS_DUPLICATE_DATA_ERROR = "hasDuplicateDataError";
	public static final String ERROR = "error";
	public static final String MVC_COMMAND_NAME = "mvcCommandName";
}