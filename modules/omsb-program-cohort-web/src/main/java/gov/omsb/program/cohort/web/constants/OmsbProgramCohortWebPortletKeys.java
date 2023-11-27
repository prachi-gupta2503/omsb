package gov.omsb.program.cohort.web.constants;

/**
 * @author Jayesh Goswami
 */
public class OmsbProgramCohortWebPortletKeys {
	
	private OmsbProgramCohortWebPortletKeys() {}

	public static final String OMSBPROGRAMCOHORTWEB =
		"gov_omsb_program_cohort_web_OmsbProgramCohortWebPortlet";
	
	public static final String OMSBPROGRAMSWEB =
			"gov_omsb_programs_web_OmsbProgramsWebPortlet";

	public static final String ADD_PROGRAM_COHORT_JSP = "/add-program-cohort.jsp";
	public static final String EDIT_PROGRAM_COHORT_JSP = "/edit-program-cohort.jsp";
	
	public static final String ADD_PROGRAM_COHORT_MVC_RENDER_COMMAND = "/add/programcohort";
	public static final String EDIT_PROGRAM_COHORT_MVC_RENDER_COMMAND = "/edit/programcohort";
	public static final String SAVE_PROGRAM_COHORT_MVC_ACTION_COMMAND = "/save/programcohort";
	public static final String DELETE_PROGRAM_COHORT_MVC_ACTION_COMMAND = "/delete/programcohort";
	
	public static final String PROGDURATION_TL_BLOCKS_TS_REL_ID = "progdurationTlBlocksLtId";
	public static final String PROGRAM_ID = "programId";
	public static final String PROGRAM_MASTER_ID = "programMasterId";
	public static final String PROGRAM_DURATION_ID = "programDurationId";
	public static final String PROGRAM = "program";
	public static final String COHORT = "cohort";
	public static final String COUNT = "count";
	
	public static final String DATE_FORMAT_VARIABLE = "sdf";
	public static final String PROGRAM_COHORT_LIST_MVC_RESOURCE_COMMAND = "/programCohortList";
	public static final String PROGRAM_COHORT_CREATED_SUCCESS_MESSAGE = "program-cohort-success-message";
	public static final String PROGRAM_COHORT_CREATED_ERROR_MESSAGE = "program-cohort-error-message";
	public static final String PROGRAM_COHORT_BLOCK_ERROR_MESSAGE = "program-cohort-block-error-message";

	public static final String PROGRAM_COHORT_DELETED_SUCCESS_MESSAGE = "program-cohort-delete-success-message";
	public static final String PROGRAM_COHORT_DELETED_ERROR_MESSAGE = "program-cohort-delete-error-message";

	public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";

	public static final String YEAR_FROM = "yearFrom";

	public static final String YEAR_TO = "yearTo";
}