package gov.omsb.tms.custom.dto;

public class RotationListDTO {
	private long progDurationRotationTsRelId;
	private long rotationMasterId;
	private long programDurationId;
	private long trainingSiteId;
	private String rotationName;
	private int noOfslots;

	public RotationListDTO() {
		super();
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public long getRotationMasterId() {
		return rotationMasterId;
	}

	public void setRotationMasterId(long rotationMasterId) {
		this.rotationMasterId = rotationMasterId;
	}

	public long getProgDurationRotationTsRelId() {
		return progDurationRotationTsRelId;
	}

	public void setProgDurationRotationTsRelId(long progDurationRotationTsRelId) {
		this.progDurationRotationTsRelId = progDurationRotationTsRelId;
	}

	public long getProgramDurationId() {
		return programDurationId;
	}

	public void setProgramDurationId(long programDurationId) {
		this.programDurationId = programDurationId;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	public int getNoOfslots() {
		return noOfslots;
	}

	public void setNoOfslots(int noOfslots) {
		this.noOfslots = noOfslots;
	}

	@Override
	public String toString() {
		return "RotationListDTO [progDurationRotationTsRelId=" + progDurationRotationTsRelId + ", rotationMasterId="
				+ rotationMasterId + ", programDurationId=" + programDurationId + ", trainingSiteId=" + trainingSiteId
				+ ", rotationName=" + rotationName + ", noOfslots=" + noOfslots + "]";
	}

}
