package gov.omsb.exam.web.portlet.dto;

public class ExamSchedule {

	private long id;
	private long examDefinitionId;
	private String applicationStartDate;
	private String applicationEndDate;
	private String examDate;
	private String startTime;
	private String endTime;
	private String locationOnGoogleMap;
	private String locationPinOnGoogleMap;
	private String venue;
	private int noOfSeats;
	private boolean multiDates;
	private String examStatus;
	private long examType;
	private String examTypeName;
	private long program;
	private String programName;
	private boolean isRegistered;
	private boolean isResult;
	private String examStartDate;
	private String examEndDate;
	private String registrationStatus;
	private long examId;
	private float examFees;
	private int noOfAttempts;
	private boolean seatsFilled;
	private long examScheduleAdminId;
	private long programId;
	private String withdrawStatus;
	private ExamWithdrawal examWithdrawal;
	private String paymentReceiptUrl;
	

	public boolean isMultiDates() {
		return multiDates;
	}

	public void setMultiDates(boolean multiDates) {
		this.multiDates = multiDates;
	}

	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamDefinitionId() {
		return examDefinitionId;
	}

	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}

	public String getApplicationStartDate() {
		return applicationStartDate;
	}

	public void setApplicationStartDate(String applicationStartDate) {
		this.applicationStartDate = applicationStartDate;
	}

	public String getApplicationEndDate() {
		return applicationEndDate;
	}

	public void setApplicationEndDate(String applicationEndDate) {
		this.applicationEndDate = applicationEndDate;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}



	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public long getProgram() {
		return program;
	}

	public void setProgram(long program) {
		this.program = program;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}

	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}

	public long getExamType() {
		return examType;
	}

	public void setExamType(long examType) {
		this.examType = examType;
	}

	public String getExamTypeName() {
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public boolean isResult() {
		return isResult;
	}

	public void setResult(boolean isResult) {
		this.isResult = isResult;
	}

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public float getExamFees() {
		return examFees;
	}

	public void setExamFees(float examFees) {
		this.examFees = examFees;
	}

	public boolean isSeatsFilled() {
		return seatsFilled;
	}

	public void setSeatsFilled(boolean seatsFilled) {
		this.seatsFilled = seatsFilled;
	}

	public long getExamScheduleAdminId() {
		return examScheduleAdminId;
	}

	public void setExamScheduleAdminId(long examScheduleAdminId) {
		this.examScheduleAdminId = examScheduleAdminId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public ExamWithdrawal getExamWithdrawal() {
		return examWithdrawal;
	}

	public void setExamWithdrawal(ExamWithdrawal examWithdrawal) {
		this.examWithdrawal = examWithdrawal;
	}

	public String getPaymentReceiptUrl() {
		return paymentReceiptUrl;
	}

	public void setPaymentReceiptUrl(String paymentReceiptUrl) {
		this.paymentReceiptUrl = paymentReceiptUrl;
	}

	public String getLocationPinOnGoogleMap() {
		return locationPinOnGoogleMap;
	}

	public void setLocationPinOnGoogleMap(String locationPinOnGoogleMap) {
		this.locationPinOnGoogleMap = locationPinOnGoogleMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExamSchedule [id=");
		builder.append(id);
		builder.append(", examDefinitionId=");
		builder.append(examDefinitionId);
		builder.append(", applicationStartDate=");
		builder.append(applicationStartDate);
		builder.append(", applicationEndDate=");
		builder.append(applicationEndDate);
		builder.append(", examDate=");
		builder.append(examDate);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", locationOnGoogleMap=");
		builder.append(locationOnGoogleMap);
		builder.append(", locationPinOnGoogleMap=");
		builder.append(locationPinOnGoogleMap);
		builder.append(", venue=");
		builder.append(venue);
		builder.append(", noOfSeats=");
		builder.append(noOfSeats);
		builder.append(", multiDates=");
		builder.append(multiDates);
		builder.append(", examStatus=");
		builder.append(examStatus);
		builder.append(", examType=");
		builder.append(examType);
		builder.append(", examTypeName=");
		builder.append(examTypeName);
		builder.append(", program=");
		builder.append(program);
		builder.append(", programName=");
		builder.append(programName);
		builder.append(", isRegistered=");
		builder.append(isRegistered);
		builder.append(", isResult=");
		builder.append(isResult);
		builder.append(", examStartDate=");
		builder.append(examStartDate);
		builder.append(", examEndDate=");
		builder.append(examEndDate);
		builder.append(", registrationStatus=");
		builder.append(registrationStatus);
		builder.append(", examId=");
		builder.append(examId);
		builder.append(", examFees=");
		builder.append(examFees);
		builder.append(", noOfAttempts=");
		builder.append(noOfAttempts);
		builder.append(", seatsFilled=");
		builder.append(seatsFilled);
		builder.append(", examScheduleAdminId=");
		builder.append(examScheduleAdminId);
		builder.append(", programId=");
		builder.append(programId);
		builder.append(", withdrawStatus=");
		builder.append(withdrawStatus);
		builder.append(", examWithdrawal=");
		builder.append(examWithdrawal);
		builder.append(", paymentReceiptUrl=");
		builder.append(paymentReceiptUrl);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
