package gov.omsb.duty.logging.web.dto;

public class DutyLogDTO {

	
private long dutyLogId;
	
	private String program;
	private String dutyType;
	private String assignment;
	private String startDate;
	private String endDate;
	private long duration;
	private String trainingCenter;
	
	public DutyLogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DutyLogDTO(long dutyLogId, String program, String dutyType, String assignment, String startDate,
			String endDate, long duration, String trainingCenter) {
		super();
		this.dutyLogId = dutyLogId;
		this.program = program;
		this.dutyType = dutyType;
		this.assignment = assignment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.trainingCenter = trainingCenter;
	}





	@Override
	public String toString() {
		return "LogDutyDTO [dutyLogId=" + dutyLogId + ", program=" + program + ", dutyType=" + dutyType
				+ ", assignment=" + assignment + ", startDate=" + startDate + ", endDate=" + endDate + ", duration="
				+ duration + ", trainingCenter=" + trainingCenter + "]";
	}





	public long getDutyLogId() {
		return dutyLogId;
	}
	public void setDutyLogId(long dutyLogId) {
		this.dutyLogId = dutyLogId;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getDutyType() {
		return dutyType;
	}
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long time_difference) {
		this.duration = time_difference;
	}
	public String getTrainingCenter() {
		return trainingCenter;
	}
	public void setTrainingCenter(String trainingCenter) {
		this.trainingCenter = trainingCenter;
	}
	
	

}
 
	
	

