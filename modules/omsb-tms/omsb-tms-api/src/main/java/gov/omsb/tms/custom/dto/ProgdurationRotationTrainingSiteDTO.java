package gov.omsb.tms.custom.dto;

public class ProgdurationRotationTrainingSiteDTO {
	
	private long rotationId;
	private int noOfSlots;
	private long trainingSiteId;
	private long progDurationId;
	
	public ProgdurationRotationTrainingSiteDTO() {
		super();
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public int getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	public long getProgDurationId() {
		return progDurationId;
	}

	public void setProgDurationId(long progDurationId) {
		this.progDurationId = progDurationId;
	}

	@Override
	public String toString() {
		return "ProgdurationRotationTrainingSiteDTO [rotationId=" + rotationId + ", noOfSlots=" + noOfSlots
				+ ", trainingSiteId=" + trainingSiteId + ", progDurationId=" + progDurationId + "]";
	}

	
}
