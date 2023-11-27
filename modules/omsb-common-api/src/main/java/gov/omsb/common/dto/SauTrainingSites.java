package gov.omsb.common.dto;

public class SauTrainingSites {

	private long id;
	private long sauUserId;
	private long trainingSitesId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSauUserId() {
		return sauUserId;
	}

	public void setSauUserId(long sauUserId) {
		this.sauUserId = sauUserId;
	}

	public long getTrainingSitesId() {
		return trainingSitesId;
	}

	public void setTrainingSitesId(long trainingSitesId) {
		this.trainingSitesId = trainingSitesId;
	}

	@Override
	public String toString() {
		return "SauTrainingSites [id=" + id + ", sauUserId=" + sauUserId + ", trainingSitesId=" + trainingSitesId + "]";
	}
}
