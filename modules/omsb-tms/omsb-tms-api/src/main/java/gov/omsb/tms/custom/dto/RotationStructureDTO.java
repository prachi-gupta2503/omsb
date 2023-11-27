package gov.omsb.tms.custom.dto;

public class RotationStructureDTO {

	private long progdurationRotationTlBlocksRelId;
	private long progDurationId;
	private long rotationId;
	private long programId;
	private long traineeLevelMasterId;
	private String traineeLevelName;
	private long noOfBlocks;
	private String programName;

	public long getProgdurationRotationTlBlocksRelId() {
		return progdurationRotationTlBlocksRelId;
	}

	public void setProgdurationRotationTlBlocksRelId(long progdurationRotationTlBlocksRelId) {
		this.progdurationRotationTlBlocksRelId = progdurationRotationTlBlocksRelId;
	}

	public long getProgDurationId() {
		return progDurationId;
	}

	public void setProgDurationId(long progDurationId) {
		this.progDurationId = progDurationId;
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public long getTraineeLevelMasterId() {
		return traineeLevelMasterId;
	}

	public void setTraineeLevelMasterId(long traineeLevelMasterId) {
		this.traineeLevelMasterId = traineeLevelMasterId;
	}

	public String getTraineeLevelName() {
		return traineeLevelName;
	}

	public void setTraineeLevelName(String traineeLevelName) {
		this.traineeLevelName = traineeLevelName;
	}

	public long getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(long noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public String toString() {
		return "RotationStructureDTO [progdurationRotationTlBlocksRelId=" + progdurationRotationTlBlocksRelId
				+ ", progDurationId=" + progDurationId + ", rotationId=" + rotationId + ", programId=" + programId
				+ ", traineeLevelMasterId=" + traineeLevelMasterId + ", traineeLevelName=" + traineeLevelName
				+ ", noOfBlocks=" + noOfBlocks + ", programName=" + programName + "]";
	}
}
