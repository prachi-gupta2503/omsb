package gov.omsb.programs.web.constants;

/**
 * @author Aditya Meghnathi
 */

public class OmsbProgramConstants {

	private OmsbProgramConstants() {
	}

	public static final String MVC_COMMAND_NAME = "mvcCommandName";
	
	public static final String ADD_PROGRAM_MVC_COMMAND_NAME = "addProgramMaster";
	public static final String DELETE_PROGRAM_MVC_COMMAND_NAME = "deleteProgramMaster";
	public static final String UPDATE_PROGRAM_MVC_COMMAND_NAME = "updateProgramMaster";

	public static final String RENDER_PROGRAM_TYPE_LIST = "programTypes";
	public static final String RENDER_ELIGIBILITY_DEGREE_LIST = "eligibilityDegrees";
	public static final String RENDER_ALL_PROGRAM_LIST = "allProgramList";

	public static final String ADD_PROGRAM_JSP = "/add-program.jsp";
	public static final String UPDATE_PROGRAM_JSP = "/update-program.jsp";
	public static final String VIEW_JSP_NAME = "/view.jsp";
	
	public static final String SAVE_PROGRAM_MVC_ACTION_COMMAND = "/save/program";
	public static final String PROGRAM_DETAILS_MVC_RENDER_COMMAND = "/program-details";
	public static final String SAVE_OBJECTIVES_MVC_ACTION_COMMAND = "/save/objectives";
	public static final String EDIT_PROGRAM_MVC_RENDER_COMMAND = "/edit/program-form";

	public static final String ADD_PROGRAM_MVC_RENDER_COMMAND = "/add-program-form";
	public static final String SAVE_ASSIGNED_TRAINING_SITES_TO_PROGRAM_COHORT_MVC_RESOURCE_COMMAND = "/save/assigned-training-sites-to-program-cohort";
	public static final String DELETE_ROTATION_FROM_TRAINING_SITE_MVC_RESOURCE_COMMAND = "/delete/rotation-from-training-site";
	public static final String GET_PROGRAM_OBJECTIVE_MVC_RESOURCE_COMMAND = "/get/programobjective";
	
	public static final String ADD_TRAINEE_ELECTIVE_ROTATIONS_MVC_RENDER_COMMAND = "/add/traineeelectiverotations";
	public static final String EDIT_TRAINEE_ELECTIVE_ROTATIONS_MVC_RENDER_COMMAND = "/edit/traineeelectiverotations";
	public static final String SAVE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND = "/save/traineeelectiverotations";
	public static final String DELETE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND = "/delete/traineeelectiverotations";
	public static final String GET_ELECTIVE_ROTATIONS_MVC_RESOURCE_COMMAND = "/get/electiverotations";
	public static final String ADD_TRAINEE_ELECTIVE_ROTATIONS_JSP = "/add-trainee-elective-rotations.jsp";
	public static final String EDIT_TRAINEE_ELECTIVE_ROTATIONS_JSP = "/edit-trainee-elective-rotations.jsp";

	public static final String PROGRAM_ID = "programId";
	public static final String PROGRAM_MASTER_ID = "programMasterId";
	public static final String PROGRAM_TYPE_MASTER_ID = "programTypeMasterId";
	public static final String ELIGIBILITY_DEGREE_MASTER_ID = "eligibilityDegreeMasterId";
	public static final String PROGRAM_NAME = "programName";
	public static final String PROGRAM_CODE = "programCode";
	public static final String PROGRAM_OBJECTIVES = "programObjectives";
	public static final String PROGRAM_DESCRIPTION = "programDescription";
	public static final String PROGRAM_ADMISSION_REQUIREMENTS = "programAdmissionRequirements";
	public static final String PROGRAM_VISION = "programVision";
	public static final String PROGRAM_MISSION = "programMission";
	public static final String PROGRAM_TYPE = "programType";
	public static final String ELIGIBILITY_DEGREE = "eligibilityDegree";
	public static final String PROGRAM_TYPE_NAME_VALUE = "programTypeNameValue";
	public static final String ELIGIBILITY_DEGREE_NAME = "eligibilityDegreeName";
	public static final String ESTABLISHMENT_DATE = "establishmentDate";
	public static final String PROGRAM_STATUS = "programStatus";
	public static final String PROGRAM_ESTABLISHMENT_DATE = "programEstablishmentDateValue";
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String RENDER_ESTABLISHMENT_DATE = "estDate";
	public static final String IS_TRAINEE = "isTrainee";
	public static final String IS_FACULTY = "isFaculty";
	
	public static final String COMPETENCY_MASTER_ID = "competencyMasterId";
	public static final String PROG_DURARION_ID = "progDurationId";
	public static final String REQUIREMENTS = "requirements";
	public static final String COMPETENCIES = "competencies";
	
	public static final String TRAINEE_LEVEL_MASTERS = "traineeLevelMasters";
	public static final String TRAINING_SITE_LIST = "trainingSiteList";
	public static final String PROGRAM_MASTER_LIST = "programMasterList";
	public static final String PROGRAM_STRUCTURE_LIST = "programStructureList";
		
	public static final String PROGRAM_NAME_ERROR = "programNameError";
	public static final String PROGRAM_CODE_ERROR = "programCodeError";
	public static final String PROGRAM_OBJECTIVES_ERROR = "programObjectivesError";
	public static final String PROGRAM_ADMIN_REQUIREMENTS_ERROR = "programAdminRequirementsError";
	public static final String PROGRAM_VISION_ERROR = "programVisionError";
	public static final String PROGRAM_MISSION_ERROR = "programMissionError";
	
	public static final String PROGRAM_COHORT_ID = "programCohortId"; 
	public static final String TRAINING_SITE_IDS_ARRAY = "trainingSiteIds[]"; 
	public static final String PROGDURATION_ROTATION_TS_REL_ID = "progDurationRotationTsRelId";
	public static final String TRAINING_SITE_NAME = "trainingSiteName";
	public static final String COMPETENCIESN_MASTER = "CompetenciesMaster";
	public static final String PROGDURARATION_COMPETENCIES_REQUIREMENTS_REL = "ProgdurationCompetenciesRequirementsRel";
	public static final String PROGDURATION_OBJECTIVE_REL = "ProgdurationObjectivesRel";
	public static final String IS_SELECTED = "isSelected";
	public static final String VIEW_TRAINING_SITE_DETAILS_URL = "viewTrainingSiteDetailsUrl";
	public static final String ROTATION_NAME = "rotationName";
	public static final String NO_OF_SLOTS = "noOfslots";
	public static final String ROTATION_MASTER_LIST = "rotationMasterList";
	
	public static final String AVAILABLE_TRAINEE_ROTATION_MAP = "availableTraineeRotationMap";
	public static final String ELECTIVE_ROTATIONS = "selectedElectiveRotations";
	public static final String SELECTED_TRAINEE_ROTATION_LIST = "selectedTraineeRotationList";
	public static final String TRAINEE_ELECTIVE_ROTATIONS_LIST = "traineeElectiveRotationsList";
	public static final String TRAINEE_LEVEL_ID = "traineeLevelId";
	public static final String SELECTED_TRAINEE_LEVEL_ID = "selectedTraineeLevelId";
	public static final String TRAINEE_LEVEL_MAP = "traineeLevelMap";
	public static final String TRAINEE_LEVEL_NAME = "traineeLevelName";
	public static final String TRAINEE_PD_TL_ER_ID = "traineePdTlErDetailsId";
	public static final String TRAINEE_LEVEL_ERROR = "error-trainee-level";
	public static final String ELECTIVE_ROTATION_COUNT_ERROR = "error-elective-rotation-count";
	public static final String ELECTIVE_ROTATION_SAVED = "elective-rotation-saved-successfully";
	public static final String ELECTIVE_ROTATION_DELETD = "elective-rotation-deleted-successfully";
	public static final String ELECTIVE_ROTATION_PRIORITY_DETAILS_ID = "electiverotationPriorityDetailsId";
	public static final String REDIRECT = "redirect";
	public static final String ROTATION_TYPE_ELECTIVE = "Elective";
	public static final String SOMETHING_WENT_WRONG = "something-went-wrong";
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String PROGRAM_CREATED_SUCCESS_MESSAGE = "program-succesfully-created";
	public static final String PROGRAM_UPDATED_SUCCESS_MESSAGE = "program-succesfully-updated";
	public static final String PROGRAM_DELETED_SUCCESS_MESSAGE = "program-succesfully-deleted";
	public static final String PROGRAM_OBJECTIVES_CREATED_SUCCESS_MESSAGE = "program-objectives-success-message";
	public static final String PROGRAM_OBJECTIVES_CREATED_ERROR_MESSAGE = "program-objectives-error-message";
	
	public static final String PROG_DURATION_OBJECTIVES_REL = "progdurationObjectivesRels";
	public static final String COMPETENCIES_REQUIRMENTS_REL = "competenciesRequirementsRels";
}
