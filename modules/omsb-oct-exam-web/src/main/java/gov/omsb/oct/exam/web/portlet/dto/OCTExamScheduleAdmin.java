package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamScheduleAdmin {
	private long id;
	private String daysOfWeek;
	private String locationOnGoogleMap;
	private long departmentId;
	private long oCExamDefinitionId;
	private String examStartDate;
	private String examEndDate;
	private boolean repeatedInstance;
	private long sectionId;
	private String venue;
	private String registrationStartDate;
	private String registrationEndDate;
	private int noOfSeats;
	private long examCenter;
	private String examSlot;
	private String examDate;
	private long applicationStartFromNoOfDays;
	private long applicationEndAtNoOfDays;
	
	
	@Override
	public String toString() {
		return "OCTExamScheduleAdmin [id=" + id + ", daysOfWeek=" + daysOfWeek + ", locationOnGoogleMap="
				+ locationOnGoogleMap + ", departmentId=" + departmentId + ", oCExamDefinitionId=" + oCExamDefinitionId
				+ ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", repeatedInstance="
				+ repeatedInstance + ", sectionId=" + sectionId + ", venue=" + venue + ", registrationStartDate="
				+ registrationStartDate + ", registrationEndDate=" + registrationEndDate + ", noOfSeats=" + noOfSeats
				+ ", examCenter=" + examCenter + ", examSlot=" + examSlot + ", examDate=" + examDate
				+ ", applicationStartFromNoOfDays=" + applicationStartFromNoOfDays + ", applicationEndAtNoOfDays="
				+ applicationEndAtNoOfDays + "]";
	}

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

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDaysOfWeek() {
		return daysOfWeek;
	}
	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}
	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}
	
	public long getoCExamDefinitionId() {
		return oCExamDefinitionId;
	}
	public void setoCExamDefinitionId(long oCExamDefinitionId) {
		this.oCExamDefinitionId = oCExamDefinitionId;
	}
	
	public boolean isRepeatedInstance() {
		return repeatedInstance;
	}
	public void setRepeatedInstance(boolean repeatedInstance) {
		this.repeatedInstance = repeatedInstance;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
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
	public long getExamCenter() {
		return examCenter;
	}
	public void setExamCenter(long examCenter) {
		this.examCenter = examCenter;
	}
	public String getExamSlot() {
		return examSlot;
	}
	public void setExamSlot(String examSlot) {
		this.examSlot = examSlot;
	}
	
}
