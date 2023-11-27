package gov.omsb.exam.web.portlet.constants;

public class MVCCommands {
	private MVCCommands() {
	}
	public static final String SAVE_REGISTRATION_DATA = "/exam/save-registration-data";
	public static final String EXAM_SCHEDULE_ACTIONS = "/schedule/exam-schedule-actions";
	public static final String SAVE_EXAM_SCHEDULE = "/schedule/save-exam-schedule";
	public static final String SAVE_EXAM_MD_SCHEDULE = "/schedule/save-exam-md-schedule";
	public static final String ANNOUNCE_EXAM = "/schedule/announce-exam";
	public static final String SEND_NOTIFICATION = "/schedule/send-notification";
	public static final String SENDER_EMAIL = "sender@mail.com";
	public static final String SAVE_REGISTRATION = "save/registration";
	
	public static final String VIEW_SCHEDULE_EXAM = "/schedule/view-schedule-exam";
	public static final String VIEW_EXAMS_SCHEDULE = "/schedule/view-exams-schedule";
	public static final String GET_EXAMS_SCHEDULE = "/schedule/get-exams-schedule";
	
	public static final String VIEW_EXAM_SCHEDULE = "/schedule/view-exam-schedule";
	public static final String VIEW_EXAM_DEFINITION = "/schedule/view-exam-definition";
	public static final String EDIT_EXAM_SCHEDULE = "/schedule/edit-exam-schedule";
	
	
	public static final String SAVE_DATA = "/schedule/save-data";
	public static final String EMAIL = "email";
	public static final String SELECTED_ROWS = "traineeData";
	public static final String SUBJECT = "subject";
	public static final String EDITOR = "editorBody";
	public static final String BODY = "editor";
	
	public static final String TRAINEE_LIST = "/schedule/view-exam-trainee-list";
	public static final String EDIT_SCHEDULE_EXAM = "view-schedule-exam";
	public static final String VIEW_EXAM_RESULT = "view-exam-result";
	public static final String UPLOAD_EXAM_RESULT = "upload-exam-result";
	
	public static final String EXAM_SCHEDULE = "announce-exam-schedule";
	public static final String VIEW_TRAINEE_EXAM_LIST = "view-trainee-exam-list";
	public static final String VIEW_EXAMS = "view-exams";
	public static final String NEW_EXAM_SETUP = "new-exam-setup";
	public static final String SAVE_EXAM_SETUP = "save-exam-setup";
	public static final String NEW_EXAM_SETUP_RESOURCE = "new-exam-setup_resource";
	public static final String GET_EXAM_LIST = "get-exam-list";
	
	public static final String EMAIL_NOTIFICATION = "email-notification";
	public static final String SEND_EMAIL_NOTIFICATION = "/schedule/send-email-notification";
	public static final String SCHEDULE_EXAM = "/schedule/schedule-exam";
	public static final String VIEW_EXAM_SETUP = "view/exam/setup";
	
	public static final String EXAM_SCHEDULE_EDIT_ACTIONS = "/schedule/exam-schedule-edit-actions";
	
	public static final String VIEW_WITHDRAW_LIST = "/schedule/withdraw-list";
	public static final String EXAMS_SCHEDULE_LIST = "/schedule/exams-schedule-list";
	public static final String VIEW_SCHEDULE_EXAMS = "/schedule/view-schedule-exams";
	
	public static final String EXAM_ADMIN_APPEAL_VIEW = "/exam/admin-appeal-view";
	public static final String EXAM_RESULT_LIST = "exam/result/list";
	public static final String SAVE_EXAM_RESULT = "save/exam/result";
	public static final String ADMIN_TRAINEE_LIST = "admin/trainee/list";
	public static final String GET_ADMIN_TRAINEE_LIST = "get/admin/trainee/list";
	public static final String OMSB_ID = "omsbId";
	public static final String DOWNLOAD_RESULT = "view-dounload-result";
	public static final String VIEW_RESULTS_LIST = "admin/results/list";
	public static final String VIEW_PARTICULAR_EXAM_RESULT = "/result/view-particular-exam-result";
	
	public static final String EXAM_ADMIN_WITHDRAWAL_VIEW = "/exam/admin-withdrawal-view";
	public static final String DOWNLOAD_TRAINEE_LIST = "/download-trainee-list";
	
	public static final String EXAM_APPEAL_RESOURCE_COMMAND = "/exam/save_appeal";
	public static final String TRAINEE_APPEAL_RENDER_COMMAND = "/exam/view_appeal";
	public static final String ADMIN_VIEW_OCT_EXAMS_DETAILS ="/jsps/exams/view-oct-exam-details";
	public static final String ADMIN_SEARCH_OCT_EXAMS_DETAILS ="/jsps/exams/search-oct-exam-details";
	public static final String OCT_NEW__EXAM_SETUP ="/jsps/exams/new-oct-exam-setup";
	public static final String SAVE_OCT_NEW_EXAM_SETUP ="/jsps/exams/save-new-oct-exam-setup";
	public static final String GET_OCT_EXAM_FORM ="/jsps/exams/get-exam-form";
	
	public static final String SAVE_COMMITTEE_COMMENTS = "";
	public static final String EXAM_CONFIRM_WITHDRAWAL = "/exam/confirm/withdrawal";
	public static final String EXAM_WITHDRAWAL_ACTION= "/exam/withdrawal/action";
	public static final String EXAM_WITHDRAWAL_RENDER= "/exam/withdrawal";
	public static final String ANNOUNCE_EXAM_RESULT = "announce-exam-result";
	public static final String EXAM_WITHDRAW = "exam_withdraw";

	//public static final String EXAM_SCHEDULE_ANNOUNCEMENT_NOTFICATION = "exam-announcement-notification";
	public static final String EXAM_SCHEDULE_ANNOUNCEMENT_NOTFICATION = "exam_announcement";
	public static final String EXAM_WITHDRAW_ACCEPT = "exam-withdrawal-accept";
	public static final String EXAM_WITHDRAW_REJECT = "exam-withdrawal-reject";
	public static final String EXAM_WITHDRAW_RETURN = "exam-withdrawal-return";
	public static final String EXAM_WITHDRAW_NOTIFY_TO_ADMIN = "exam-withdrawal-admin";
 	
	public static final String GET_CONFIRM_REGISTRATION_DETAILS="getConfirmRegistrationDetails";
	
	public static final String SAVE_EXAM_REGISTRATION_PAYMENT_RESOURCE = "/save-exam-registration-payment-resource";
	public static final String REGISTRATION_CONFIRM_ACTION = "exam/registartion/confirmation";
	
	public static final String DOWNLOAD_TRAINEE_RESULT = "Download_Exam_Result";
	
	public static final String TRAINEE_EXAM_TYPE = "examType";
	public static final String TRAINEE_REF_NUMBER = "examReferenceId";
	public static final String TRAINEE_OMSB_ID = "omsbId";
	public static final String TRAINEE_FINAL_RESULT = "result";
	public static final String TRAINEE_PERCENTAGE = "percentage";
	public static final String SAVE_EXAM_REGISTRATION = "/save/exam/registartion";
	public static final String CANCEL_EXAM_REGISTRATION = "/cancel/exam/registartion";
	public static final String EXAM_REGISTRATION_FAIL_TEMPLATE = "exam-registration-fail";
	public static final String EXAM_REGISTRATION_SUCCESS_TEMPLATE = "exam-registration-success";
	public static final String EXAM_REMINDER_TEMPLATE = "exam-reminder";

	public static final String PROGRAM_NAME = "programName";

	public static final String EXAM_PAYMENT_RECEIPT_TEMPLATE = "payment_receipt";
	
	public static final String EXAM_PAYMENT_RECIEPT_PATH = "//data//liferay//extra//tmp-documents//";
	public static final String EXAM_PAYMENT_RECIEPT_NAME = "Payment_Receipt";
	public static final String EXAM_PAYMENT_RECIEPT_URL = "payment-receipt";
	

	
}
