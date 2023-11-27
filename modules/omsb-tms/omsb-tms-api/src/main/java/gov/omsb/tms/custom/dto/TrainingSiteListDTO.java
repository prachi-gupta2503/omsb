package gov.omsb.tms.custom.dto;

public class TrainingSiteListDTO {

	private long trainingSiteMasterId;
	private String trainingSiteName;

	public long getTrainingSiteMasterId() {
		return trainingSiteMasterId;
	}

	public void setTrainingSiteMasterId(long trainingSiteMasterId) {
		this.trainingSiteMasterId = trainingSiteMasterId;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	@Override
	public String toString() {
		return "TrainingSiteListDTO [trainingSiteMasterId=" + trainingSiteMasterId + ", trainingSiteName="
				+ trainingSiteName + "]";
	}

}
