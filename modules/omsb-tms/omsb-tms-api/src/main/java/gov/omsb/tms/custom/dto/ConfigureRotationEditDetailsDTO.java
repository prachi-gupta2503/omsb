package gov.omsb.tms.custom.dto;

public class ConfigureRotationEditDetailsDTO {
	
	private long progdurationRotationTlBlocksRelId;
	private long rotationId;
	private long programDurationId;
	private long traineeLevelId;
	private long rotationTypeId;
	private Integer noOfBlocks;
	
	public ConfigureRotationEditDetailsDTO() {
		super();
	}
	
	public long getProgdurationRotationTlBlocksRelId() {
		return progdurationRotationTlBlocksRelId;
	}
	public void setProgdurationRotationTlBlocksRelId(long progdurationRotationTlBlocksRelId) {
		this.progdurationRotationTlBlocksRelId = progdurationRotationTlBlocksRelId;
	}
	public long getRotationId() {
		return rotationId;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	public long getProgramDurationId() {
		return programDurationId;
	}
	public void setProgramDurationId(long programDurationId) {
		this.programDurationId = programDurationId;
	}
	public long getTraineeLevelId() {
		return traineeLevelId;
	}
	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}
	public long getRotationTypeId() {
		return rotationTypeId;
	}
	public void setRotationTypeId(long rotationTypeId) {
		this.rotationTypeId = rotationTypeId;
	}
	public Integer getNoOfBlocks() {
		return noOfBlocks;
	}
	public void setNoOfBlocks(Integer noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}
	
	@Override
	public String toString() {
		return "ConfigureRotationEditDetailsDTO [progdurationRotationTlBlocksRelId=" + progdurationRotationTlBlocksRelId
				+ ", rotationId=" + rotationId + ", programDurationId=" + programDurationId + ", traineeLevelId="
				+ traineeLevelId + ", rotationTypeId=" + rotationTypeId + ", noOfBlocks=" + noOfBlocks + "]";
	}

}
