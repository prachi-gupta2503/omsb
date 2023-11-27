package gov.omsb.tms.custom.dto;

public class RotationTraineeBlockRelationDTO {

	private long rotationId;
	private String rotationName;
	private long rotationTypeId;
	private long traineeLevelId;
	private long programDurationId;
	private int noOfBlocks;

	public RotationTraineeBlockRelationDTO() {
		super();
	}

	public long getRotationTypeId() {
		return rotationTypeId;
	}


	public void setRotationTypeId(long rotationTypeId) {
		this.rotationTypeId = rotationTypeId;
	}


	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public long getTraineeLevelId() {
		return traineeLevelId;
	}

	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}

	public long getProgramDurationId() {
		return programDurationId;
	}

	public void setProgramDurationId(long programDurationId) {
		this.programDurationId = programDurationId;
	}

	public int getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(int noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	@Override
	public String toString() {
		return "RotationTraineeBlockRelationDTO [rotationId=" + rotationId + ", rotationName=" + rotationName
				+ ", rotationTypeId=" + rotationTypeId + ", traineeLevelId=" + traineeLevelId + ", programDurationId="
				+ programDurationId + ", noOfBlocks=" + noOfBlocks + "]";
	}

}
