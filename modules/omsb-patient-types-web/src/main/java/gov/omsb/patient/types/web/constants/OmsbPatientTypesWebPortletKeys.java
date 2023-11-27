package gov.omsb.patient.types.web.constants;

/**
 * @author Jayesh Goswami
 */
public class OmsbPatientTypesWebPortletKeys {
	
	private OmsbPatientTypesWebPortletKeys() {}

	public static final String OMSBPATIENTTYPESWEB =
		"gov_omsb_patient_types_web_OmsbPatientTypesWebPortlet";
	
	public static final String ADD_PATIENT_TYPE_JSP = "/add-patient-type.jsp";
	public static final String EDIT_PATIENT_TYPE_JSP = "/edit-patient-type.jsp";
	
	public static final String ADD_PATIENT_TYPE_MVC_RENDER_COMMAND = "/add/patienttype";
	public static final String EDIT_PATIENT_TYPE_MVC_RENDER_COMMAND = "/edit/patienttype";
	public static final String SAVE_PATIENT_TYPE_MVC_ACTION_COMMAND = "/save/patienttype";
	public static final String DELETE_PATIENT_TYPE_MVC_ACTION_COMMAND = "/delete/patienttype";
	
	public static final String PATIENT_TYPE_NAME = "patientTypeName";
	public static final String PATIENT_TYPE = "patientType";
	public static final String PATIENT_TYPE_MASTER_ID = "patientTypeMasterId";
	public static final String PATIENT_TYPE_MASTER_LIST = "patientTypeMasterList";
	public static final String DATE_FORMAT_VARIABLE = "sdf";
	
    public static final String DATE_FORMAT_DD_MM_YYYY = "dd-MM-yyyy";
    public static final String PATIENT_TYPE_NAME_ERROR = "patientTypeNameError";
}