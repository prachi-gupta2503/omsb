package gov.omsb.procedure.groups.web.constants;

/**
 * @author Aditya Meghnathi
 */
public class OmsbProcedureGroupsConstants {

	private OmsbProcedureGroupsConstants() {
	}

	public static final String SAVE_PROCEDURE_GROUPS_COMMAND_NAME = "saveProcedureGroupsMaster";
	public static final String DELETE_PROCEDURE_GROUPS_MVC_COMMAND_NAME = "deleteProcedureGroupsMaster";
	public static final String EDIT_PROCEDURE_GROUPS_MVC_COMMAND_NAME = "editProcedureGroupsMaster";
	
	public static final String PROCEDURE_GROUP_MASTER_ID = "procedureGroupMasterId";
	public static final String PROCEDURE_GROUP_NAME = "procedureGroupName";
	public static final String PROCEDURE_GROUP_LIST = "procedureGroupMasterList";
	public static final String PROCEDURE_GROUP = "procedureGroup";
	public static final String DATE_FORMAT_VARIABLE = "sdf";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	
	public static final String VIEW_JSP_NAME = "/view.jsp";
	public static final String EDIT_JSP_PAGE = "/edit-procedure-groups.jsp";
	public static final String ADD_JSP_PAGE = "/add-procedure-groups.jsp";
	
	public static final String PROCEDURE_GROUP_NAME_ERROR = "procedureGroupNameError";
}
