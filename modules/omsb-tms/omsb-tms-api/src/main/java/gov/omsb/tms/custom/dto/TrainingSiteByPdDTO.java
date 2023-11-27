package gov.omsb.tms.custom.dto;

public class TrainingSiteByPdDTO {

	private long trainingSiteId;
	private String trainingSiteName;

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

	@Override
	public String toString() {
		return "TrainingSiteByPdDTO [trainingSiteId=" + trainingSiteId + ", trainingSiteName=" + trainingSiteName + "]";
	}

}
