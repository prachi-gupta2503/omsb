package gov.omsb.tms.custom.dto;

import java.util.Date;

public class TraineeDetailsWithBlocksDTO {

	private String traineeName;
	private long traineeId;
	private long totalBlocks;
	private long allocatedBlocks;
	private long leaveBlocks;
	private long leaveMasterId;
	private long leaveTypeId;
	private String leaveType;
	private String leaveBlockName;
	private int leaveBlockNo;
	private long availableBlocks;
	private String leaveTypeName;
	private Date fromDate;
	private Date toDate;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public int getLeaveBlockNo() {
		return leaveBlockNo;
	}

	public void setLeaveBlockNo(int leaveBlockNo) {
		this.leaveBlockNo = leaveBlockNo;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public long getTotalBlocks() {
		return totalBlocks;
	}

	public void setTotalBlocks(long totalBlocks) {
		this.totalBlocks = totalBlocks;
	}

	public long getAllocatedBlocks() {
		return allocatedBlocks;
	}

	public void setAllocatedBlocks(long allocatedBlocks) {
		this.allocatedBlocks = allocatedBlocks;
	}

	public long getLeaveBlocks() {
		return leaveBlocks;
	}

	public void setLeaveBlocks(long leaveBlocks) {
		this.leaveBlocks = leaveBlocks;
	}

	public long getLeaveMasterId() {
		return leaveMasterId;
	}

	public void setLeaveMasterId(long leaveMasterId) {
		this.leaveMasterId = leaveMasterId;
	}

	public long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveBlockName() {
		return leaveBlockName;
	}

	public void setLeaveBlockName(String leaveBlockName) {
		this.leaveBlockName = leaveBlockName;
	}

	public long getAvailableBlocks() {
		return availableBlocks;
	}

	public void setAvailableBlocks(long availableBlocks) {
		this.availableBlocks = availableBlocks;
	}

	@Override
	public String toString() {
		return "TraineeDetailsWithBlocksDTO [traineeName=" + traineeName + ", traineeId=" + traineeId + ", totalBlocks="
				+ totalBlocks + ", allocatedBlocks=" + allocatedBlocks + ", leaveBlocks=" + leaveBlocks
				+ ", leaveMasterId=" + leaveMasterId + ", leaveTypeId=" + leaveTypeId + ", leaveType=" + leaveType
				+ ", leaveBlockName=" + leaveBlockName + ", leaveBlockNo=" + leaveBlockNo + ", availableBlocks="
				+ availableBlocks + ", leaveTypeName=" + leaveTypeName + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}

}
