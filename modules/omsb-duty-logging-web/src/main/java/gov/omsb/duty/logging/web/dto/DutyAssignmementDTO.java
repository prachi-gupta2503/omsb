package gov.omsb.duty.logging.web.dto;

public class DutyAssignmementDTO {

	private long dutyAssignmentId;
	private String assignment;
	private String dutyType;
	private String colorCode;
	
	
	public DutyAssignmementDTO() {
		super();
	}
	
	public DutyAssignmementDTO(long dutyAssignmentId, String assignment, String dutyType) {
		super();
		this.dutyAssignmentId = dutyAssignmentId;
		this.assignment = assignment;
		this.dutyType = dutyType;
	}

	public long getDutyAssignmentId() {
		return dutyAssignmentId;
	}
	public void setDutyAssignmentId(long dutyAssignmentId) {
		this.dutyAssignmentId = dutyAssignmentId;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getDutyType() {
		return dutyType;
	}
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}
	
	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "DutyAssignmementDTO [dutyAssignmentId=" + dutyAssignmentId + ", assignment=" + assignment
				+ ", dutyType=" + dutyType + ", colorCode=" + colorCode + "]";
	}
}
