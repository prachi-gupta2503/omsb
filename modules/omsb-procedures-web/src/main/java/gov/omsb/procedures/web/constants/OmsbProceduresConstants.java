package gov.omsb.procedures.web.constants;

public class OmsbProceduresConstants {
	
	private OmsbProceduresConstants() {}

	public static final String PROCEDURE_NAME = "procedureName";
	
	public static final String IS_MANDATORY = "isMandatory";
	
	public static final String PROCEDURE_ID = "procedureMasterId";
	
	public static final String PROCEDURES = "procedures";
	
	public static final String LANGUAGE_ID = "languageId";
	
	public static final String DATE_FORMAT_VARIABLE = "sdf";
	
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	
	// MVC Command Names...
	public static final String ADD_PROCEDURE_MASTER_MVC_COMMAND_NAME = "addProcedureMaster";
	
	public static final String DELETE_PROCEDURE_MASTER_MVC_COMMAND_NAME = "deleteProcedureMaster";
	
	public static final String UPDATE_PROCEDURE_MASTER_MVC_COMMAND_NAME = "updateProcedureMaster";
	
	// JSP Names...
	public static final String ADD_PROCEDURE_MASTER_JSP_NAME = "/add-procedures.jsp";
	
	public static final String EDIT_PROCEDURE_MASTER_JSP_NAME = "/edit-procedure.jsp";
	
	public static final String VIEW_PROCEDURE_MASTERS_JSP_NAME = "/view.jsp";
	
}
