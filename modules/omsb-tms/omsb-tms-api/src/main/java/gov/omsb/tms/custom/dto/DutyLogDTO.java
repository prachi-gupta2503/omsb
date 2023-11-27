package gov.omsb.tms.custom.dto;

import java.util.Date;

public class DutyLogDTO {

	private long dutyLogId;
	private Date startDate;
	private Date endDate;
	private long traineeId;
	private long programDutyAssignmentId;
	private long blocksMetadataDetailRelId;
	private long residencyLevelId;
	private boolean multiDays;
	private long programMasterId;
	private long rotationId;
	private long trainingSiteId;
	
	
	

	public long getProgramMasterId() {
		return programMasterId;
	}

	public void setProgramMasterId(long programMasterId) {
		this.programMasterId = programMasterId;
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	public DutyLogDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public long getProgramDutyAssignmentId() {
		return programDutyAssignmentId;
	}

	public void setProgramDutyAssignmentId(long programDutyAssignmentId) {
		this.programDutyAssignmentId = programDutyAssignmentId;
	}

	public long getBlocksMetadataDetailRelId() {
		return blocksMetadataDetailRelId;
	}

	public void setBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		this.blocksMetadataDetailRelId = blocksMetadataDetailRelId;
	}

	public long getResidencyLevelId() {
		return residencyLevelId;
	}

	public void setResidencyLevelId(long residencyLevelId) {
		this.residencyLevelId = residencyLevelId;
	}

	public boolean isMultiDays() {
		return multiDays;
	}

	public void setMultiDays(boolean multiDays) {
		this.multiDays = multiDays;
	}

	@Override
	public String toString() {
		return "DutyLogDTO [dutyLogId=" + dutyLogId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", traineeId=" + traineeId + ", programDutyAssignmentId=" + programDutyAssignmentId
				+ ", blocksMetadataDetailRelId=" + blocksMetadataDetailRelId + ", residencyLevelId=" + residencyLevelId
				+ ", multiDays=" + multiDays + "]";
	}

}
