package gov.omsb.tms.custom.dto;

import java.util.Date;

public class DutyLogHoursDTO {

private long dutyLogId;
	
    private long dutyTypeId;
    private long traineeId;
	private long programDutyAssignmentId;
	private Date startDate;
	private Date endDate;
	
	
	
	public DutyLogHoursDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DutyLogHoursDTO(long dutyLogId, long traineeId,long dutyTypeId, long programDutyAssignmentId,
			Date startDate, Date endDate) {
		super();
		this.dutyLogId = dutyLogId;
		this.traineeId = traineeId;
		this.dutyTypeId = dutyTypeId;
		this.programDutyAssignmentId = programDutyAssignmentId;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public long getDutyLogId() {
		return dutyLogId;
	}



	public void setDutyLogId(long dutyLogId) {
		this.dutyLogId = dutyLogId;
	}



	public long getTraineeId() {
		return traineeId;
	}



	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}



	


	public long getDutyTypeId() {
		return dutyTypeId;
	}



	public void setDutyTypeId(long dutyTypeId) {
		this.dutyTypeId = dutyTypeId;
	}





	public long getProgramDutyAssignmentId() {
		return programDutyAssignmentId;
	}



	public void setProgramDutyAssignmentId(long programDutyAssignmentId) {
		this.programDutyAssignmentId = programDutyAssignmentId;
	}



	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	@Override
	public String toString() {
		return "DutyLogHoursDTO [dutyLogId=" + dutyLogId + ", dutyTypeId=" + dutyTypeId + ", traineeId=" + traineeId
				+ ", programDutyAssignmentId=" + programDutyAssignmentId + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

	
	
}
