package gov.omsb.tms.custom.dto;

public class ConfigureRotationDetailsDTO {
	
	private long progdurationRotationTlBlocksRelId;
	private String programName;
	private String programDuration;
	private String traineeLevelName;
	private String rotationName;
	private String rotationTypeName;
	private int noOfBlocks;
	
	public ConfigureRotationDetailsDTO() {
		super();
	}

	public long getProgdurationRotationTlBlocksRelId() {
		return progdurationRotationTlBlocksRelId;
	}

	public void setProgdurationRotationTlBlocksRelId(long progdurationRotationTlBlocksRelId) {
		this.progdurationRotationTlBlocksRelId = progdurationRotationTlBlocksRelId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}

	public String getTraineeLevelName() {
		return traineeLevelName;
	}

	public void setTraineeLevelName(String traineeLevelName) {
		this.traineeLevelName = traineeLevelName;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public String getRotationTypeName() {
		return rotationTypeName;
	}

	public void setRotationTypeName(String rotationTypeName) {
		this.rotationTypeName = rotationTypeName;
	}

	public int getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(int noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	@Override
	public String toString() {
		return "ConfigureRotationDetailsDTO [progdurationRotationTlBlocksRelId=" + progdurationRotationTlBlocksRelId
				+ ", programName=" + programName + ", programDuration=" + programDuration + ", traineeLevelName="
				+ traineeLevelName + ", rotationName=" + rotationName + ", rotationTypeName=" + rotationTypeName
				+ ", noOfBlocks=" + noOfBlocks + "]";
	}	
}
