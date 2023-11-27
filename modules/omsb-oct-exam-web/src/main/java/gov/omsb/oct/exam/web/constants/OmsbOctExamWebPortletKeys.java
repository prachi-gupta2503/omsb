package gov.omsb.oct.exam.web.constants;

import java.io.Serializable;

/**
 * @author AftabA
 */
public class OmsbOctExamWebPortletKeys {

	public static final String OMSBOCTEXAMWEB = "gov_omsb_oct_exam_web_OmsbOctExamWebPortlet";
	public static final String VIEW_OCT_EXAMS_JSP = "/jsps/exam/view-oct-exams.jsp";
	public static final String ADMIN_SEARCHED_OCT_EXAMS_LIST_JSP = "/jsps/exam/searched-oct-exam-list.jsp";
	public static final String EDIT_OCT_EXAM_JSP = "/jsps/exam/edit-oct-exam.jsp";
	public static final String OCT_EXAM_SETUP_JSP = "/jsps/exam/oct-exam-setup.jsp";
	public static final String OCT_EXAM_TITLE_JSP = "/jsps/exam/oct-exam-title.jsp";
	public static final String OCT_TRAINING_SITE_JSP = "/jsps/exam/oct-training-site.jsp";
	public static final String OCT_TRAINING_SITE_SLOT_MAPPING_JSP = "/jsps/exam/training-site-slot-mapping.jsp";

	public static final String APPLICANT_REQUESTS_JSP = "/jsps/applicant-requests.jsp";

	//	OCT Exam Schedule
	public static final String ADD_OCT_EXAM_SCHEDULE_JSP = "/jsps/schedule/add-oct-exam-schedule.jsp";
	public static final String VIEW_OCT_EXAM_SCHEDULE_JSP = "/jsps/schedule/view-oct-exam-schedule.jsp";
	public static final String EDIT_OCT_EXAM_SCHEDULE_JSP = "/jsps/schedule/edit-oct-exam-schedule.jsp";
	public static final String VIEW_OCT_EXAM_SCHEDULE_LIST_JSP = "/jsps/schedule/view-oct-exam-schedule-list.jsp";
	public static final String SEARCHED_OCT_EXAM_SCHEDULE_LIST_JSP = "/jsps/schedule/searched-oct-exam-schedule-list.jsp";

	public static final String APPLICANT_EXAM_LIST_JSP = "/jsps/applicant/applicant-exam-list.jsp";
	public static final String APPLICANT_RESCHEDULE_EXAM_LIST_JSP = "/jsps/applicant/applicant-exam-reschedule-list.jsp";
	public static final String APPLICANT_CANCELLATION_JSP = "/jsps/cancellation/applicant-form.jsp";
	public static final String ADMIN_CANCELLATION_JSP = "/jsps/cancellation/admin-form.jsp";
	public static final String VIEW_ALL_CANCELLATION_JSP = "/jsps/cancellation/cancellation-list.jsp";
	public static final String CANCELLATION_OBJECT_ERC = "OB_OC_EXAM_CANCELLATION_ERC";
	public static final String CANCELLATION_STATUS_OBJECT_ERC = "OB_OC_EXAM_CANCELLATION_STATUS_ERC";
	public static final String CANCELLATION_DOCS_OBJECT_ERC = "OB_OC_EXAM_CANCELLATION_DOCS_ERC";
	public static final String PL_EXAM_STATUS_KEY_REGISTERED = "registered";
	public static final String PL_EXAM_STATUS_KEY_PENDING = "pending";
	public static final String PL_EXAM_STATUS_KEY_ACCEPTED = "accepted";
	public static final String PL_EXAM_STATUS_KEY_REJECTED = "rejected";
	
	public static final String PL_APPEAL_STATUS_KEY_PENDING = "appeal pending";
	public static final String PL_APPEAL_STATUS_KEY_ACCEPTED = "appeal accepted";
	public static final String PL_APPEAL_STATUS_KEY_REJECTED = "appeal rejected";
	
	public static final String PL_REAPPEAL_STATUS_KEY_PENDING = "reappeal pending";
	public static final String PL_REAPPEAL_STATUS_KEY_ACCEPTED = "reappeal accepted";
	public static final String PL_REAPPEAL_STATUS_KEY_REJECTED = "reappeal rejected";
	
	public static final String VIEW_EXAM_SETUP_JSP = "/jsps/exam/view-exam-setup.jsp";


	public static final String CMD = "cmd";
	public static final String DOWNLOAD_OCT_TRAINEES = "downloadTraineeList";
	public static final String SELECTED_OCT_TRAINEES = "selectedRows";
	public static final String RESULT = "Result";
	public static final String CALIBRI = "Calibri";
	public static final String OCT_TRAINEE_LIST = "Selected OCT Trainee List";

	public static final String FULL_NAME = "Full Name";
	public static final String OMSB_ID = "OMSB Id";
	public static final String EMAIL_ADDRESS = "Email Address";
	public static final String PHONE_NUMBER = "Phone Number";
	public static final String PROGRAM = "Program";
	public static final String RESIDENCY_LEVEL = "Residency Level";
	public static final String NO_OF_ATTEMPTS = "No Of Attempts";
	public static final String STATUS_OF_PAYMENT = "Status Of Payment";
	public static final String LIST_OF_TRAINEES = "Trainee-List.xls";
	public static final String APPEARED = "appeared";
	public static final String PERCENTAGE = "percentage";
	public static final String STATUS_REGISTED = "Registed";
	public static final String VIEW_OCT_EXAM_RESULT_EXCEL = "viewOCTExamResultExcel";
	public static final String OCT_RESULT_TEMPLATE = "OCT-Result-Template.xls";
	public static final String PROGRAM_NAME = "ProgramName";
	public static final String OCT_RESULT_TEMPLATE_SHEET = "OCTResultTemplate";

	public static final String LR_USER_ID = "LR User Id";

	public static final String CHECK_OCT_RESULT = "checkOCTResult";
	public static final String UPLOAD_OCT_EXAM_RESULT = "uploadOCTExamResult";
	public static final String PASS = "pass";
	public static final String FAIL = "fail";
	public static final String RESULT_RECORDS = "resultRecords";
	public static final String EXAM_RESULTS = "examResults";
	public static final String RESULT_FILE = "resultFile";

	public static final String ADMIN_OCT_EXAM_RESULT_LIST_JSP = "/jsps/result/admin-upload-oct-result.jsp";

	public static final String TRANSITION_NAME_ACCEPT = "Accept";
	public static final String TRANSITION_NAME_REJECT = "Reject";

	public static final String VIEW_TRAINEE_EXAM_LIST_JSP="/jsps/registration/trainee-exam-list.jsp";
	public static final String OCT_EXAM_RESULTS_LIST_JSP = "/jsps/result/view-results.jsp";
	public static final String OCT_APPEAL_TRAINEE_VIEW_JSP = "/jsps/appeal/appeal-form.jsp";
	public static final String OCT_APPEAL_ADMIN_VIEW_JSP = "/jsps/appeal/admin-appeal-form.jsp";
	public static final String OCT_EXAM_REGISTRATION_VIEW_JSP = "/jsps/exam/admin-view-register-exam.jsp";


	public static final String OCT_PL_EXAM_STATUS_KEY_PENDING = "pending";

	public static final String VIEW_ELIGIBLE_TRAINEES_LIST_JSP="/jsps/result/view-eligible-traninees-list.jsp";
	public static final String VIEW_UPLOAD_RESULT_SCREEN_JSP = "/jsps/result/view-upload-result-screen.jsp";
	public static final String SET_EXAM_FORM_SUCCESS = "setExamFormSuccess";
	public static final String SET_EXAM_FORM_ERROR = "setExamFormError";
	public static final String GET_EXAM_FORM = "getExamForm";
	public static final String GET_EXIST_EXAM = "getExistExam";
	
	public static final String REGISTRATION_FORM_JSP = "/jsps/registration/registration-form.jsp";	
	public static final String TEST_JSP = "/jsps/registration/test.jsp";
	public static final String OB_OC_EXAM_REGISTRATION_ERC = "OB_OC_EXAM_REGISTRATION_ERC"; 
	public static final String OB_OC_EXAM_REGISTRATION_TEMP_ERC = "OB_OC_EXAM_REGISTRATION_TEMP_ERC"; 
	public static final String OB_EXAM_EMERGENCY_CONTACT_ERC = "OB_EXAM_EMERGENCY_CONTACT_ERC"; 

	public static final String OCT_RESCHEDULE_REQUEST_JSP = "/jsps/reschedule/trainee_rescheduling_request.jsp";
	public static final String RESCHEDULE_STATUS_OBJECT_ERC = "OB_OC_EXAM_RESCHEDULE_STATUS_ERC";
	public static final String RESCHEDULE_DOCS_OBJECT_ERC = "OB_OC_EXAM_RESCHEDULE_DOCS_ERC";
	public static final String RESCHEDULE_OBJECT_ERC = "OB_OC_EXAM_RESCHEDULE_ERC";
	public static final String TRAINING_SITE_PL_ERC = "PL_OC_TRAINING_SITE_ERC";
	public static final String EXAM_TITLE_PL_ERC = "PL_OC_EXAM_TITLE_ERC";
	
	public static final String OC_EXAM_APPEAL_STATUS_OBJECT_ERC = "OC_EXAM_APPEAL_STATUS";
	public static final String OC_EXAM_APPEAL_OBJECT_ERC = "OB_OC_EXAM_APPEAL_ERC";
	public static final String OC_EXAM_REGISTRATION_TEMP_OBJECT_ERC = "OB_OC_EXAM_REGISTRATION_TEMP_ERC";

	
	public static final String VIEW_PARTICULAR_TRAINEE_RESULT_JSP = "/jsps/result/view-particular-trainee-result.jsp";
	
	public static final String REDIRECT_URL = "/group/guest/oct";

	public static final String ADMIN_RESCHEDULE_JSP = "/jsps/reschedule/admin-reschedule-request.jsp";
	public static final String VIEW_OCT_EXAMS_FLOW_JSP = "/jsps/exam/view-oct-exam-flow.jsp";
	public static final String VIEW_OCT_EXAMS_APPLICANT_CALENDAR_JSP = "/jsps/exam/calender-view.jsp";
	
	public static final String PERCENTAGE_EXCEL = "Percentage";
	public static final String APPEARED_EXCEL= "Appeared";
	public static final String CANDIDATE_ID = "Candidate ID";
	
	public static final String SET_TRAINING_SITE_FORM_ERROR = "setTrainingSiteFormError";
	public static final String PENDING = "pending";
	public static final String OMR = "OMR";
	public static final String FEES_TYPE_OCT_EXAM_REGISTRATION = "OCT Exam Registration";
	public static final String FEES_TYPE_OCT_EXAM_RESCHEDULE = "OCT Exam Reschedule";
	public static final String FEES_TYPE_OCT_EXAM_APPEAL = "OCT Exam Appeal";
	public static final String FEES_TYPE_OCT_EXAM_REAPPEAL = "OCT Exam Reappeal";
	
	//Payment URLS:
	public static final String PAYMENT_REDIRECT_URL = "http://localhost:8080/group/guest/oct";
	public static final String PAYMENT_URL = "https://stage.omsb.gov.om/pki/bank-muscat/bank-muscat-request";
	
	public static final String OB_EXAM_REGISTRATION_ERC = "OB_EXAM_REGISTRATION_ERC";
	
	public static final String EXAM_REGISTRATION_STATUS_KEY_RESCHEDULED = "rescheduled";
	public static final String EXAM_REGISTRATION_STATUS_KEY_REGISTERED = "registered";
	public static final String EXAM_RESCHEDULE_PAGE_URL = "/group/guest/oct?p_p_id=gov_omsb_oct_exam_web_OmsbOctExamWebPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_gov_omsb_oct_exam_web_OmsbOctExamWebPortlet_mvcPath=/jsps/exam/calender-view.jsp";
	
	public static final String SET_EXAM_SCHEDULE_SUCCESS = "setExamScheduleFormSuccess";
	public static final String SET_EXAM_SCHEDULE_ERROR = "setExamScheduleFormError";
	public static final String SET_EXAM_REGISTRATION_SUCCESS = "setExamRegistrationFormSuccess";
	public static final String SET_EXAM_REGISTRATION_ERROR = "setExamRegistrationFormError";
	public static final String SET_EXAM_RESULT_SUCCESS = "setExamResultFormSuccess";
	public static final String SET_EXAM_RESULT_ERROR = "setExamResultFormError";
	
	public static final String EXAM_TITLE_NAME = "Name";
	public static final String PAID = "paid";
	public static final Serializable RESCHEDULE = "Reschedule";
	public static final String SELECTED_TRAINEES = "selectedRows";
	public static final String EXAM_TITLE = "Exam Title";
	public static final String DATE_OF_PAYMENT = "Date Of Previous Attempts";
	public static final String TRAINING_LEVEL = "Training Level";
	public static final String GENDER = "Gender";
	public static final String TRAINEE_LIST = "Selected Trainee List";
	
	
	public static final String OCT_EXAM_IMAGE_FILE_PATH = "//data//liferay//extra/tmp-documents//";
	public static final String OCT_EXAM_FILE_PATH = "//data//liferay//extra//tmp-documents//";
	
//	public static final String OCT_EXAM_IMAGE_FILE_PATH = "C://Users//TusharT//Downloads//image//";
//	public static final String OCT_EXAM_FILE_PATH = "C://Users//TusharT//Downloads//pdf//";
	
	public static final String OCT_EXAM_FILE_NAME = "TraineeResult.pdf";
	public static final String REGISTRATION_STATUS = "registration_status";
	public static final String SUCCESS = "success";
	public static final String EXAM_TITLES = "examTitle";
}