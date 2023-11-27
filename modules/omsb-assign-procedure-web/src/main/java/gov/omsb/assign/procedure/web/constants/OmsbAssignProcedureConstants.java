package gov.omsb.assign.procedure.web.constants;

public class OmsbAssignProcedureConstants {
	
	private OmsbAssignProcedureConstants() {}
	
	public static final String PROCEDURE_GROUP_NAMES = "procedureGroupName";
	
	public static final String PROCEDURE_NAMES = "procedureName";
	
	public static final String CPT_CODE_NAMES = "cptCodeName";
	
	public static final String PG_PROCEDURES_CPT_RELS = "pgProceduresCPTCodeRels";
	
	public static final String PG_PROCEDURES_CPT_REL_ID = "pgProceduresCPTCodeRelId";
	
	public static final String PROCEDURE_GROUP_MASTERS = "procedureGroupMasters";
	
	public static final String PROCEDURE_MASTERS = "procedureMasters";
	
	public static final String CPT_CODE_MASTERS = "cptCodeMasters";
	
	public static final String LANGUAGE_ID = "languageId";
	
	public static final String DATE_FORMAT_VARIABLE = "sdf";
	
	public static final String DATE_FORMAT = "MMM dd, yyyy";
	
	// MVC Command Names...
	public static final String ADD_ASSIGN_PROCEDURE_MVC_COMMAND_NAME = "addAssignProcedure";
	
	public static final String EDIT_ASSIGN_PROCEDURE_MVC_COMMAND_NAME = "editAssignProcedure";
	
	public static final String DELETE_ASSIGN_PROCEDURE_MVC_COMMAND_NAME = "deleteAssignProcedure";
	
	// JSP Names...
	public static final String ADD_ASSIGN_PROCEDURES_JSP_NAME = "/add-pg-procedures-rel.jsp";
	
	public static final String EDIT_ASSIGN_PROCEDURES_JSP_NAME = "/edit-pg-procedures-rel.jsp";
	
	public static final String VIEW_ASSIGN_PROCEDURES_JSP_NAME = "/view.jsp";

}
