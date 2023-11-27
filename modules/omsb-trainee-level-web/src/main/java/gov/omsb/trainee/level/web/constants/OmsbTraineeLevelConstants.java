package gov.omsb.trainee.level.web.constants;

/**
 * @author Aditya Meghnathi
 */
public class OmsbTraineeLevelConstants {

	private OmsbTraineeLevelConstants() {
	}

	public static final String SAVE_TRAINEE_LEVEL_COMMAND_NAME = "saveTraineeLevelMaster";
	public static final String DELETE_TRAINEE_LEVEL_MVC_COMMAND_NAME = "deleteTraineeLevelMaster";
	public static final String EDIT_TRAINEE_LEVEL_MVC_COMMAND_NAME = "editTraineeLevelMaster";
	
	public static final String TRAINEE_LEVEL_MASTER_ID = "traineeLevelMasterId";
	public static final String TRAINEE_LEVEL_NAME = "traineeLevelName";
	public static final String TRAINEE_LEVEL = "traineeLevel";
	public static final String TRAINEE_LEVEL_LIST = "traineeLevelMasterList";
	public static final String DATE_FORMAT_VARIABLE = "sdf";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	
	
	public static final String VIEW_JSP_NAME = "/view.jsp";
	public static final String EDIT_JSP_PAGE = "/edit-trainee-level.jsp";
	public static final String ADD_JSP_PAGE = "/add-trainee-level.jsp";
	
	public static final String TRAINEE_LEVEL_NAME_ERROR = "traineeLevelError";
}
