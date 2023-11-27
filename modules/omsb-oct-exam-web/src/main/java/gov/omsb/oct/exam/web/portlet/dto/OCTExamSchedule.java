package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamSchedule {

	private long id;
	private String registrationStartDate;
	private String registrationEndDate;
	private int noOfSeats;
	private String examDate;
	private String examSlot;
	private long examStatusId;
	private long oCExamScheduleId;
	@JsonProperty("oCExamDefinitionId")
	private long octExamDefinitionId;
	private String venue;
	private String locationOnGoogleMap;
	@JsonProperty("departmentId")
	private long departmentId;
	@JsonProperty("sectionId")
	private long sectionId;
	private String departmentName;
	private String sectionName;
	private String departmentKey;
	private String sectionKey;
	@JsonProperty("oCExamTitleId")
	private long octExamTitleId;
	@JsonProperty("oCExamTitleName")
	private String octExamTitleName;
	private String examStatusName;
	private String examStatusColor;
	private String regStatus;
	private boolean isRegistrationAllowed;
	private long examCenter;
	private float examFees;
	private String oCExamTitleKey;
	private String dateOfPayment;
	private boolean repeatedInstance;
	private String daysOfWeek;
	private String examStartDate;
	private String examEndDate;
	private long oCExamScheduleAdminId;
	private long examId;
	private String examTime;
	private String examEndTime;
	private String examCenterName;
	private long applicationStartFromNoOfDays;
	private long applicationEndAtNoOfDays;
	private String paymentReceiptUrl;

	public long getApplicationStartFromNoOfDays() {
		return applicationStartFromNoOfDays;
	}

	public void setApplicationStartFromNoOfDays(long applicationStartFromNoOfDays) {
		this.applicationStartFromNoOfDays = applicationStartFromNoOfDays;
	}

	public long getApplicationEndAtNoOfDays() {
		return applicationEndAtNoOfDays;
	}

	public void setApplicationEndAtNoOfDays(long applicationEndAtNoOfDays) {
		this.applicationEndAtNoOfDays = applicationEndAtNoOfDays;
	}


	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public long getoCExamScheduleAdminId() {
		return oCExamScheduleAdminId;
	}

	public void setoCExamScheduleAdminId(long oCExamScheduleAdminId) {
		this.oCExamScheduleAdminId = oCExamScheduleAdminId;
	}

	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	public String getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public boolean isRepeatedInstance() {
		return repeatedInstance;
	}

	public void setRepeatedInstance(boolean repeatedInstance) {
		this.repeatedInstance = repeatedInstance;
	}

	public String getDepartmentKey() {
		return departmentKey;
	}

	public void setDepartmentKey(String departmentKey) {
		this.departmentKey = departmentKey;
	}

	public String getSectionKey() {
		return sectionKey;
	}

	public void setSectionKey(String sectionKey) {
		this.sectionKey = sectionKey;
	}

	

	public long getExamCenter() {
		return examCenter;
	}

	public void setExamCenter(long examCenter) {
		this.examCenter = examCenter;
	}

	public boolean isRegistrationAllowed() {
		return isRegistrationAllowed;
	}

	public void setRegistrationAllowed(boolean isRegistrationAllowed) {
		this.isRegistrationAllowed = isRegistrationAllowed;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegistrationStartDate() {
		return registrationStartDate;
	}

	public void setRegistrationStartDate(String registrationStartDate) {
		this.registrationStartDate = registrationStartDate;
	}

	public String getRegistrationEndDate() {
		return registrationEndDate;
	}

	public void setRegistrationEndDate(String registrationEndDate) {
		this.registrationEndDate = registrationEndDate;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	

	public String getExamSlot() {
		return examSlot;
	}

	public void setExamSlot(String examSlot) {
		this.examSlot = examSlot;
	}

	

	public long getExamStatusId() {
		return examStatusId;
	}

	public void setExamStatusId(long examStatusId) {
		this.examStatusId = examStatusId;
	}

	public long getoCExamScheduleId() {
		return oCExamScheduleId;
	}

	public void setoCExamScheduleId(long oCExamScheduleId) {
		this.oCExamScheduleId = oCExamScheduleId;
	}

	public long getOctExamDefinitionId() {
		return octExamDefinitionId;
	}

	public void setOctExamDefinitionId(long octExamDefinitionId) {
		this.octExamDefinitionId = octExamDefinitionId;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}

	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public long getOctExamTitleId() {
		return octExamTitleId;
	}

	public void setOctExamTitleId(long octExamTitleId) {
		this.octExamTitleId = octExamTitleId;
	}

	public String getOctExamTitleName() {
		return octExamTitleName;
	}

	public void setOctExamTitleName(String octExamTitleName) {
		this.octExamTitleName = octExamTitleName;
	}

	public String getExamStatusName() {
		return examStatusName;
	}

	public void setExamStatusName(String examStatusName) {
		this.examStatusName = examStatusName;
	}

	public String getExamStatusColor() {
		return examStatusColor;
	}

	public void setExamStatusColor(String examStatusColor) {
		this.examStatusColor = examStatusColor;
	}

	public float getExamFees() {
		return examFees;
	}

	public void setExamFees(float examFees) {
		this.examFees = examFees;
	}

	public String getoCExamTitleKey() {
		return oCExamTitleKey;
	}

	public void setoCExamTitleKey(String oCExamTitleKey) {
		this.oCExamTitleKey = oCExamTitleKey;
	}
	


	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamEndTime() {
		return examEndTime;
	}

	public void setExamEndTime(String examEndTime) {
		this.examEndTime = examEndTime;
	}

	public String getExamCenterName() {
		return examCenterName;
	}

	public void setExamCenterName(String examCenterName) {
		this.examCenterName = examCenterName;
	}

	public String getPaymentReceiptUrl() {
		return paymentReceiptUrl;
	}

	public void setPaymentReceiptUrl(String paymentReceiptUrl) {
		this.paymentReceiptUrl = paymentReceiptUrl;
	}

	@Override
	public String toString() {
		return "OCTExamSchedule [id=" + id + ", registrationStartDate=" + registrationStartDate
				+ ", registrationEndDate=" + registrationEndDate + ", noOfSeats=" + noOfSeats + ", examDate=" + examDate
				+ ", examSlot=" + examSlot + ", examStatusId=" + examStatusId + ", oCExamScheduleId=" + oCExamScheduleId
				+ ", octExamDefinitionId=" + octExamDefinitionId + ", venue=" + venue + ", locationOnGoogleMap="
				+ locationOnGoogleMap + ", departmentId=" + departmentId + ", sectionId=" + sectionId
				+ ", departmentName=" + departmentName + ", sectionName=" + sectionName + ", departmentKey="
				+ departmentKey + ", sectionKey=" + sectionKey + ", octExamTitleId=" + octExamTitleId
				+ ", octExamTitleName=" + octExamTitleName + ", examStatusName=" + examStatusName + ", examStatusColor="
				+ examStatusColor + ", regStatus=" + regStatus + ", isRegistrationAllowed=" + isRegistrationAllowed
				+ ", examCenter=" + examCenter + ", examFees=" + examFees + ", oCExamTitleKey=" + oCExamTitleKey
				+ ", dateOfPayment=" + dateOfPayment + ", repeatedInstance=" + repeatedInstance + ", daysOfWeek="
				+ daysOfWeek + ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate
				+ ", oCExamScheduleAdminId=" + oCExamScheduleAdminId + ", examId=" + examId + ", examTime=" + examTime
				+ ", examEndTime=" + examEndTime + ", examCenterName=" + examCenterName
				+ ", applicationStartFromNoOfDays=" + applicationStartFromNoOfDays + ", applicationEndAtNoOfDays="
				+ applicationEndAtNoOfDays + "]";
	}
	

	
	
}
