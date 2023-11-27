package gov.omsb.master.rotation.schedule.web.portlet.dto;

public class TraineeElectiveRotationDTO {
	
	private String traineeName;
	private long traineeId;
	private long rotationId;
	
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}
	public long getRotationId() {
		return rotationId;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	
	@Override
	public String toString() {
		return "TraineeElectiveRotationDTO [traineeName=" + traineeName + ", traineeId=" + traineeId + ", RotationId="
				+ rotationId + "]";
	}
}
