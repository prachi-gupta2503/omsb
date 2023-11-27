package gov.omsb.tms.custom.dto;

public class TrainingSiteStructureDTO {
	private long rotationId;
	private long trainingSiteId;
	private long noOfSlots;
	private String trainingSiteName;
	private String rotationName;
	private String progarmName;

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	public long getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(long noOfSlots) {
		this.noOfSlots = noOfSlots;
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

	public String getProgarmName() {
		return progarmName;
	}

	public void setProgarmName(String progarmName) {
		this.progarmName = progarmName;
	}

	@Override
	public String toString() {
		return "TrainingSiteStructureDTO [rotationId=" + rotationId + ", trainingSiteId=" + trainingSiteId
				+ ", noOfSlots=" + noOfSlots + ", trainingSiteName=" + trainingSiteName + ", rotationName="
				+ rotationName + ", progarmName=" + progarmName + "]";
	}

}
