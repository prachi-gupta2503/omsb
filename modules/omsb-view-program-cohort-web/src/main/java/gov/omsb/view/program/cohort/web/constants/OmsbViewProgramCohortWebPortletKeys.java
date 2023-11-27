package gov.omsb.view.program.cohort.web.constants;

/**
 * @author Jayesh Goswami
 */
public class OmsbViewProgramCohortWebPortletKeys {
	
	private OmsbViewProgramCohortWebPortletKeys() {}

	public static final String OMSBVIEWPROGRAMCOHORTWEB =
		"gov_omsb_view_program_cohort_web_OmsbViewProgramCohortWebPortlet";
	
	public static final String OMSBPROGRAMSWEB =
			"gov_omsb_programs_web_OmsbProgramsWebPortlet";
	
	public static final String YEAR_FROM = "yearFrom";
	public static final String YEAR_TO = "yearTo";
	public static final String PROGRAM_ID = "programId";

	public static final String PROGRAM_DURATION_ID = "programDurationId";
	
	public static final String PROGRAM_COHORT_LIST_MVC_RESOURCE_COMMAND= "/programCohortList";
	public static final String PROGRAM_AND_COHORT_LIST_MVC_RESOURCE_COMMAND= "/programAndCohortList";
	public static final String GET_DISTINCT_COHORT_MVC_RESOURCE_COMMAND = "/getDistincCohort";
	public static final String PROGRAM_COHORT_TRAINEE_LEVEL_LIST_MVC_RESOURCE_COMMAND= "/programCohortTraineeLevelList";
	
	public static final String COHORT_ALREADY_EXIST_ERROR = "cohort-already-exist";
	public static final String NO_COHORT_EXIST_ERROR = "no-cohort-exist";
	
	public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";
}