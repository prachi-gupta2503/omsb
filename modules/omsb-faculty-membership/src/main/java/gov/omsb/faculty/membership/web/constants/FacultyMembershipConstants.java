package gov.omsb.faculty.membership.web.constants;

public class FacultyMembershipConstants {
	
	private FacultyMembershipConstants() {}
	
	public static final String DL_FOLDER_NAME = "Qualification_Documents";
	
	public static final String FACULTY_MEMBERSHIP_DETAILS_KEY = "facultyMembershipDetails";
	
	public static final String EDUCATION_DETAILS_KEY = "educationDetails";
	
	public static final String PERSONAL_DETAILS_KEY = "personalDetails";
	
	public static final String EXISTING_AFFILIATION_DETAILS_KEY = "existingAffliationsDetails";
	
	public static final String COMMENT_DETAILS_KEY = "commentDetails";
	
	public static final String STATUS_KEY = "status";
	
	public static final String MESSAGE_KEY = "message";
	
	public static final String SUCCESS = "success";
	
	public static final String FAIL = "fail";
	
	public static final String POTENTIAL_FACULTY_ID_COLUMN_NAME = "potentialFacultyId";
	
	public static final String FACULTY_REQUEST_ID_COLUMN_NAME = "facultyRequestId";
	
	public static final String PERSON_ID_KEY = "personId";
	
	public static final String INSTITUTIONS_KEY = "institutions";
	
	public static final String COUNTRIES_KEY = "countries";
	
	public static final String YEARS_KEY = "years";
	
	public static final String CREATED_DATE_COLUMN_NAME = "createDate";
	
	public static final String ENGLISH_LANGUAGE_CODE = "en_US";
	
	public static final String ARABIC_LANGUAGE_CODE = "ar_SA";
	
	public static final String NOT_AVAILABLE = "NA";
	
	public static final String OBJECT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	public static final String COMMENTS_DATE_FORMAT = "yyyy-MM-dd HH:mm";
	
	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	
	public static final int START_YEAR = 1970;
	
	// MVC Command Names....
	public static final String VIEW_FACULTY_REQUEST_DETAILS_RENDER_COMMAND = "/view/faculty-request-details";
	
	public static final String ADD_EDIT_FACULTY_REQUEST_DETAILS_RENDER_COMMAND = "/view/add-edit-faculty-request-details";
	
	public static final String UPDATE_FACULTY_REQUEST_DETAILS_ACTION_COMMAND = "/update/faculty-request-details";
	
	public static final String DELETE_EDUCATION_DETAILS_RESOURCE_COMMAND = "/delete/education-details";
	
	public static final String ADD_EDUCATION_DETAILS_RESOURCE_COMMAND = "/add/education-details";
	
	// JSP Page Path....
	public static final String VIEW_FACULTY_REQUEST_DETAILS_JSP_PAGE = "/jsp/faculty/view-faculty-request-details.jsp";
	
	public static final String ADD_EDIT_FACULTY_REQUEST_DETAILS_JSP_PAGE = "/jsp/faculty/add-edit-member-details.jsp";

}
