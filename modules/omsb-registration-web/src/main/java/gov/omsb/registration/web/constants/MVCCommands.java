package gov.omsb.registration.web.constants;

public class MVCCommands {
	private MVCCommands() {
	}
	
	public static final String VIEW_ADMIN_EDIT_ROLE_SERVICE = "/admin/edit-role-service";
	public static final String SAVE_ADMIN_DECISION = "/admin/save-admin-decision";
	public static final String SAVE_ADMIN_ASSIGN_DECISION = "/admin/save-admin-assign-decision";
	public static final String ADMIN_SEARCH_REGISTRATION = "/admin/search-registration";
	public static final String SAVE_REGISTRATION_PERSONAL_DETAIL = "/save/registration/personal/details";
	public static final String SAVE_REGISTRATION_WORK_DETAIL = "/save/registration/work/detail";

	public static final String VIEW_IDENTIFICATION_CONFIRMATION = "/identification/view-identification-confirmation";
	public static final String GET_CIVILID_BY_MOBILENUMBER = "/identification/get-civilid-by-mobilenumber";
	public static final String VIEW_IDENTIFICATION_PERSONAL_ID = "/identification/view-personal-id";
	public static final String VIEW_IDENTIFICATION_PKI = "/identification/view-pki";
		
	public static final String VIEW_REGISTRATION_PERSONAL_DETAILS = "/registration/view-personal-details";
	public static final String SAVE_REGISTRATION_PERSONAL_DETAILS = "/registration/save-personal-details";
	
	public static final String VIEW_REGISTRATION_EDUCATION_DETAILS = "/registration/view-education-details";
	public static final String SAVE_REGISTRATION_EDUCATION_DETAILS = "/registration/save-education-details";
	public static final String SAVE_REGISTRATION_EDUCATION_DETAILS_SR = "/registration/save-education-details-sr";
	public static final String GET_REGISTRATION_EDUCATION_DETAILS_SR = "/registration/get-education-details-sr";
	public static final String DELETE_REGISTRATION_EDUCATION_DETAILS_SR = "/registration/delete-education-details-sr";
	public static final String DELETE_REGISTRATION_WORK_DETAILS_SR = "/registration/delete-work-details-sr";
	
	public static final String GET_REGISTRATION_WORK_DETAILS_SR = "/registration/get-work-details-sr";
	public static final String SAVE_REGISTRATION_WORK_DETAILS_SR = "/registration/save-work-details-sr";
	
	
	public static final String SAVE_REGISTRATION_ROLE_SERVICE_SR = "/registration/save-role-service-sr";
	public static final String DELETE_REGISTRATION_ROLE_SERVICE_SR = "/registration/delete-role-service-sr";
	public static final String GET_REGISTRATION_ROLE_SERVICE_SR = "/registration/role-service-details-sr";
	
	public static final String VIEW_REGISTRATION_NEW_PASSWORD = "/registration/view-new-password";
	public static final String SAVE_REGISTRATION_NEW_PASSWORD = "/registration/save-new-password";

	public static final String VIEW_REGISTRATION_WORK_DETAILS = "/registration/view-work-details";
	public static final String SAVE_REGISTRATION_WORK_DETAILS = "/registration/save-work-details";
	
	public static final String VIEW_REGISTRATION_ROLE_SERVICE = "/registration/view-role-service";
	public static final String SAVE_REGISTRATION_ROLE_SERVICE = "/registration/save-role-service";
	
	public static final String VIEW_REGISTRATION_THANK_YOU = "/registration/view-thank-you";
	
	public static final String VIEW_RA_ROLE_REQUEST_LIST = "/role-approver/view-role-request-list";
	public static final String VIEW_SA_SERVICE_REQUEST_LIST = "/service-approver/view-service-request-list";
	public static final String VIEW_USER_EDIT_MY_PROFILE = "/user/edit-my-profile";
	
	public static final String ADMIN_REGISTRATION_LIST = "/registration/view-admin-registration-list";
	public static final String VIEW_REGISTRATION_DETAILS = "/registration/view-registration-details";
	public static final String EDIT_REGISTRATION_DETAILS = "/registration/edit-registration-details";
	public static final String SAVE_REGISTRATION_DETAILS = "/registration/save-registration-details";
	
	public static final String SEND_OTP = "/registration/send-otp";
	public static final String VERIFY_OTP = "/registration/verify-otp";
	
	public static final String VERIFY_USERNAME = "/registration/verify-username";
	
	public static final String URL_SORT_DESCENDENDING ="sort=id:desc&pageSize=0";
	public static final String URL_SORT_DESCENDENDING_WITH_FILTER ="sort=id:desc&filter=";
	public static final String FILTER_BY_PERSON_ID ="filter=personId+eq+";
	
	
	public static final String IDENTIFICATION_PERSONAL_ID_MVCACTION = "/identification/personal-id/mvcaction";
	public static final String EDUCATION_DETAILS_MVCACTION = "/education-detail/mvcaction";
	public static final String ROLE_SERVICE_MVCACTION = "/role-service/mvcaction";
	
	public static final String SECTION_DEPARTMENT_MVC_RESOURCE = "/role-service/section-department";
	public static final String FUNCTION_SECTION_COMMITTEE_MVC_RESOURCE = "/role-service/function-section-committee";
	public static final String COMMITTEE_SECTION_MVC_RESOURCE = "/role-service/committe-section";
	public static final String PROGRAM_TYPE_MVC_RESOURCE = "/role-service/program-type";
	public static final String IS_EDUCATION_AND_EMPLOYMENT_DETAILS_SAVED_MVC_RESOURCE = "/role-service/is-education-and-employment-details-saved";
	public static final String SAVE_REGISTRATION_ROLE_AND_SERVICE="/save/registration/role/and/service";
	public static final String PKI_MOBILE_IDENTIFICATION = "/identification/mobile-edentification";
    public static final String ADD_WORK_DETAIL = "/workdetail/workdetail-addition";
    public static final String VIEW_CAPTCHA = "/registration/captcha";
    public static final String GET_WORKSECTOR_BY_WORKSECTOR_TYPE = "/workdetail/work-sector-type";
    public static final String GET_WORKSECTOR_BY_PARENT_WORK_SECTOR = "/workdetail/work-sector";
    public static final String SPECIALITY_AND_SUBSPECIALITY_MVC_RESOURCE = "/registration/speciality-and-subspeciality";
    public static final String SPECIALITY_MASTER_URL = "/o/c/omsbexamspecialtymappings/"; 
    public static final String VERIFY_CIVILID_PASSPORT = "/registration/verify/civilId-passport";  
    public static final String UPLOAD_USER_PHOTO = "/registration/upload-user-photo";  
    public static final String GET_UNIVERSITY_DETAILS = "/exam/get-university-details";
    public static final String VERIFY_REGISTRATION_PERSONAL_DETAILS = "/registration/verify-registration-personal-detail";
    public static final String VERIFY_REGISTRATION_EDUCATION_DETAILS = "/registration/verify-registration-education-detail";
    public static final String VERIFY_REGISTRATION_WORK_DETAILS = "/registration/verify-registration-employment-detail";
    public static final String FETCH_SPECIALITY_BY_PROFESSION = "/registration/fetch-specialty-list";
    
    public static final String PROFESSION_SPECIALITY_URL = "/o/c/omsbprofessionspecialtymappings/"; 
    public static final String SERVICE_URL = "/o/c/omsbserviceses/scopes/"; 
    
    public static final String EDUCATION_DETAIL_RESOURCE ="/resource/education-detail";
    public static final String WORK_DETAIL_RESOURCE ="/resource/work-detail";
    public static final String ROLE_SERVICE_RESOURCE ="/resource/role-service-detail";
    public static final String PERSONAL_DETAIL_RESOURCE ="/resource/personal-detail";
    
    
    public static final String VERIFY_CIVIL_ID ="/resource/validate-civil-id";
    
    
    
}