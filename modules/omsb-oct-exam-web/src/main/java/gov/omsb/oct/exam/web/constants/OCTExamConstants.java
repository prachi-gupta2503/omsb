package gov.omsb.oct.exam.web.constants;

public class OCTExamConstants {

	public static final String OC_EXAM_TITLE_ID_FILTER = "filter=oCExamTitleId+eq+";
	public static final String SORT_BY_ID_DESC = "sort=id:desc&pageSize=0";
	public static final String SORT_BY_EXAM_DATE_DESC = "sort=examDate:desc&pageSize=0";

	public static final String OC_EXAM_ID_FILTER = "filter=id+eq+";
	public static final String EXAM_JSON = "examJson";
	public static final String STATUS = "status";
	public static final String MODIFIED = "modified";
	public static final String OC_EXAM_TITLE_ID = "oCExamTitleId";
	public static final String FIELD_OC_EXAM_LR_USER_ID = "lrUserId";
	public static final String FIELD_OC_EXAM_SCHEDULE_ID = "oCExamScheduleId";
	public static final String FIELD_OC_EXAM_CANCEL_WF_STATUS_ID = "cancellationStatusId";
	public static final String FIELD_OC_EXAM_CANCEL_ID = "ocExamCancellationId";
	public static final String FIELD_OC_EXAM_REASON = "reason";
	public static final String FIELD_OC_EXAM_CANCELLATION_STATUS_ID = "oCExamCancellationStatusId";
	public static final String FIELD_OC_EXAM_CANCELLATION_DOCUMENT_TITLE = "docTitle";
	public static final String FIELD_OC_EXAM_CANCELLATION_DOCUMENT_FILE_ENTRY_ID = "fileEntryId";
	public static final String OB_OC_EXAM_ERC = "OB_OC_EXAM_ERC";
	public static final String FIELD_OC_EXAM_PICK_LIST_ID = "picklistId";
	public static final String EXAM_TITLE_OBJECT_ERC = "OB_OC_EXAM_TITLE_ERC";
	public static final String ADD_EXAM = "addExam";
	public static final String EDIT_EXAM = "editExam";
	public static final String FIELD_OC_EXAM_TITLE_ID = "oCExamTitleId";

	public static final String FIELD_OC_EXAM_RESCHEDULE_STATUS_ID = "oCExamRescheduleStatusId";
	public static final String FIELD_OC_EXAM_RESCHEDULE_DOCUMENT_TITLE = "docTitle";
	public static final String FIELD_OC_EXAM_RESCHEDULE_ID = "oCExamRescheduleId";
	public static final String FIELD_OC_EXAM_RESCHEDULE_WF_STATUS_ID = "rescheduleStatus";
	public static final String FIELD_OC_EXAM_DEFINITION_ID = "oCExamDefinitionId";
	public static final String FIELD_OC_EXAM_RESCHEDULE_DOCUMENT_FILE_ENTRY_ID = "fileEntryId";

	public static final String PDF_HEADING = "OMAN MEDICAL SPECIALITY BOARD";
	public static final String PDF_SUBHEADING = "Trainee Exam Result ";
	public static final String EXAM_TITLE = "Exam Title";
	public static final String EXAM_REF_ID = "Exam Reference Id";
	public static final String OMSB_ID = "OMSB ID";
	public static final String FINAL_RESULT = "Result";
	public static final String PERCENTAGE = "Percentage";
	public static final String DOWNLOAD_TRAINEE_RESULT = "downloadTraineeResult";
	public static final String CMD = "cmd";

	public static final String TRAINEE_EXAM_TITLE = "examTitle";
	public static final String TRAINEE_REF_NUMBER = "referenceNumber";
	public static final String TRAINEE_OMSB_ID = "omsbId";
	public static final String TRAINEE_FINAL_RESULT = "finalResult";
	public static final String TRAINEE_PERCENTAGE = "percentage";

	public static final String CONTENTE_TYPE = "application/pdf";
	public static final String CONTENT = "Content-Disposition";
	public static final String FILE_NAME = "attachment; filename=trainee-exam-result.pdf";

	public static final String EXAM_NAME = "$[examName]";
	public static final String REGISTRATION_START_DATE = "$[registrationStartDate]";
	public static final String REGISTRATION_END_DATE = "$[registrationEndDate]";

	public static final String FIELD_OC_NEW_EXAM_SCHEDULE_ID = "newOCExamScheduleId";
	public static final String FIELD_OC_EXAM_RESCHEDULE_ADMIN = "admin";

	public static final String REGISTERED = "registered";
	public static final String REJECTED = "rejected";
	public static final String PENDING = "pending";

	public static final String OCT_EXAM_ID = "octExamId";
	public static final String EXAM_TITLE_CAMELCASE = "examTitle";
	public static final String EXIST_EXAM = "existExam";

	public static final String OC_EXAM_REGISTRATION_WC = "oc_exam_registration";
	public static final String TRAINING_SITE_ID = "trainingSiteId";
	public static final String NUMBER_OF_SLOTS = "numberOfSlots";
	public static final String START_TIME = "start";
	public static final String END_TIME = "end";
	public static final String TIME_SLOT = "timeSlot";
	public static final String OC_Exam_Training_Site_Slot_Master_ERC = "OC_Exam_Training_Site_Slot_Master_ERC";
	public static final String OMSB_EXAM_APPEAL = "omsb_exam_appeal";
	public static final String EXAM_SCHEDULAR = "exam-schedular";
	public static final String OCT_EXAM_ANNOUNCEMENT = "exam-announcement-notification";
	
	public static final String DOWNLOAD_RESULT = "download_result";
	public static final String OCT_EXAM_REGISTRATION_SUCCESS = "oct-exam-registration-success";
	public static final String OCT_EXAM_REGISTRATION_FAIL = "oct-exam-registration-fail";
	public static final String OCT_RESCHEDULE_EXAM_FAIL_TEMPLATE = "oct-reschedule_exam-fail";
	public static final String OCT_RESCHEDULE_EXAM_SUCCESS_TEMPLATE = "oct-reschedule_exam_success";
	public static final String OB_OC_EXAM_SCHEDULE_ADMIN_ERC = "OB_OC_EXAM_SCHEDULE_ADMIN_ERC";
	public static final String ID_KEY = "id";
	public static final String TITLE_KEY = "title";
	public static final String START_KEY = "start";
	public static final String END_KEY = "end";
	public static final String COLOR_KEY = "color";
	public static final String OVERLAP_KEY = "overlap";
	public static final String SCHEDULE_EVENTS = "scheduleEvents";
	public static final String REGISTERED_STATUS_KEY = "registered";
	public static final String COMPLETED_STATUS_KEY = "Completed";
	public static final String REJECTED_STATUS_KEY = "Rejected";
	public static final String PENDING_STATUS_KEY = "Pending";
	public static final String EXAMTITLE = "examTitle";
	public static final String OCT_PAYMENT_RECEIPT_TEMPLATE = "oct_payment_receipt";
	public static final String OCT_PAYMENT_RECIEPT_PATH = "//data//liferay//extra//tmp-documents//";
	public static final String OCT_PAYMENT_RECIEPT_NAME = "oct_Payment_Receipt";
	public static final String OCT_PAYMENT_RECIEPT_URL = "oct-payment-receipt";
	

}
