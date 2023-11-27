package gov.omsb.tms.custom.dto;

public class TrainingSitesCapacityDTO {

	private long progdurationRotationTsRelId;
	private long trainingSiteId;
	private String trainingSiteName;
	private String rotationName;
	private int noOfSlots;

	public long getProgdurationRotationTsRelId() {
		return progdurationRotationTsRelId;
	}

	public void setProgdurationRotationTsRelId(long progdurationRotationTsRelId) {
		this.progdurationRotationTsRelId = progdurationRotationTsRelId;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public int getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	@Override
	public String toString() {
		return "TrainingSitesCapacityDTO [progdurationRotationTsRelId=" + progdurationRotationTsRelId
				+ ", trainingSiteId=" + trainingSiteId + ", trainingSiteName=" + trainingSiteName + ", rotationName="
				+ rotationName + ", noOfSlots=" + noOfSlots + "]";
	}

}