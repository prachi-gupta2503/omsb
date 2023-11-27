package gov.omsb.approve.shared.rotation.web.portlet.model;

import java.util.Date;

public class SharedRotationRequestDTO {
	private long sharedRotationRequestId;
	private String programStructure;
	private String rotation;
	private long noOfTraineesRequested;
	private String requestRaisedBy;
	private long approvedTrainee;
	private long rejectedTrainee;
	private String status;
	private Date modifiedDate;

	public long getSharedRotationRequestId() {
		return sharedRotationRequestId;
	}
	public void setSharedRotationRequestId(long sharedRotationRequestId) {
		this.sharedRotationRequestId = sharedRotationRequestId;
	}
	public String getProgramStructure() {
		return programStructure;
	}
	public void setProgramStructure(String programStructure) {
		this.programStructure = programStructure;
	}
	public String getRotation() {
		return rotation;
	}
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}
	public long getNoOfTraineesRequested() {
		return noOfTraineesRequested;
	}
	public void setNoOfTraineesRequested(long noOfTraineesRequested) {
		this.noOfTraineesRequested = noOfTraineesRequested;
	}
	public String getRequestRaisedBy() {
		return requestRaisedBy;
	}
	public void setRequestRaisedBy(String requestRaisedBy) {
		this.requestRaisedBy = requestRaisedBy;
	}
	public long getApprovedTrainee() {
		return approvedTrainee;
	}
	public void setApprovedTrainee(long approvedTrainee) {
		this.approvedTrainee = approvedTrainee;
	}
	public long getRejectedTrainee() {
		return rejectedTrainee;
	}
	public void setRejectedTrainee(long rejectedTrainee) {
		this.rejectedTrainee = rejectedTrainee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@Override
	public String toString() {
		return "SharedRotationRequestDTO [sharedRotationRequestId=" + sharedRotationRequestId + ", programStructure="
				+ programStructure + ", rotation=" + rotation + ", noOfTraineesRequested=" + noOfTraineesRequested
				+ ", requestRaisedBy=" + requestRaisedBy + ", approvedTrainee=" + approvedTrainee + ", rejectedTrainee="
				+ rejectedTrainee + ", status=" + status + ", modifiedDate=" + modifiedDate + "]";
	}

}
