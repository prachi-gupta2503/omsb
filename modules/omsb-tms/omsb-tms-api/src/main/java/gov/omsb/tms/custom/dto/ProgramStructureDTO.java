package gov.omsb.tms.custom.dto;

public class ProgramStructureDTO {
	private long progDurationRotationTlBlocksRelId;
	private long rotationId;
	private long noOfBlocks;
	private long traineeLevelMasterId;
	private long rotationType;
	private String rotationName;
	private String traineeLevelName;
	private String programName;

	public long getProgDurationRotationTlBlocksRelId() {
		return progDurationRotationTlBlocksRelId;
	}

	public void setProgDurationRotationTlBlocksRelId(long progDurationRotationTlBlocksRelId) {
		this.progDurationRotationTlBlocksRelId = progDurationRotationTlBlocksRelId;
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public long getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(long noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	public long getTraineeLevelMasterId() {
		return traineeLevelMasterId;
	}

	public void setTraineeLevelMasterId(long traineeLevelMasterId) {
		this.traineeLevelMasterId = traineeLevelMasterId;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public String getTraineeLevelName() {
		return traineeLevelName;
	}

	public void setTraineeLevelName(String traineeLevelName) {
		this.traineeLevelName = traineeLevelName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public long getRotationType() {
		return rotationType;
	}

	public void setRotationType(long rotationType) {
		this.rotationType = rotationType;
	}

	@Override
	public String toString() {
		return "ProgramStructureDTO [progDurationRotationTlBlocksRelId=" + progDurationRotationTlBlocksRelId
				+ ", rotationId=" + rotationId + ", noOfBlocks=" + noOfBlocks + ", traineeLevelMasterId="
				+ traineeLevelMasterId + ", rotationType=" + rotationType + ", rotationName=" + rotationName
				+ ", traineeLevelName=" + traineeLevelName + ", programName=" + programName + "]";
	}

}
