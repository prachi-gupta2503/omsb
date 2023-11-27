package gov.omsb.exam.web.portlet.dto;

public class ExamScheduleAdmin {

	private long id;
	private long applicationStartFromNoOfDays;
	private long applicationEndAtNoOfDays;
	private long examDefinitionId;
	private boolean isMultiDates;
	private long noOfSeats;
	private String programIds;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getExamDefinitionId() {
		return examDefinitionId;
	}

	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}

	public boolean isMultiDates() {
		return isMultiDates;
	}

	public void setMultiDates(boolean isMultiDates) {
		this.isMultiDates = isMultiDates;
	}

	public long getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(long noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getProgramIds() {
		return programIds;
	}

	public void setProgramIds(String programIds) {
		this.programIds = programIds;
	}

	@Override
	public String toString() {
		return "ExamScheduleAdmin [id=" + id + ", applicantionStartFromNoOfDays=" + applicationStartFromNoOfDays
				+ ", applicationEndAtNoOfDays=" + applicationEndAtNoOfDays + ", examDefinitionId=" + examDefinitionId
				+ ", isMultiDates=" + isMultiDates + ", noOfSeats=" + noOfSeats + ", programIds=" + programIds + "]";
	}

}
