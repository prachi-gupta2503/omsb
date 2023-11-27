package gov.omsb.master.rotation.schedule.web.portlet.model;

import java.util.List;

public class SaveTraineeMasterRotationScheduleDTO {

	public static class TraineeDetails {
		private long traineeId;
		private String traineeName;

		public long getTraineeId() {
			return traineeId;
		}

		public void setTraineeId(long traineeId) {
			this.traineeId = traineeId;
		}

		public String getTraineeName() {
			return traineeName;
		}

		public void setTraineeName(String traineeName) {
			this.traineeName = traineeName;
		}

		@Override
		public String toString() {
			return "TraineeDetails [traineeId=" + traineeId + ", traineeName=" + traineeName + "]";
		}
	}

	private long blockId;
	private long rotationId;
	private long rotationMasterId;
	private String progCodeRsnSiteCode;
	private List<TraineeDetails> traineeDetails;

	public String getProgCodeRsnSiteCode() {
		return progCodeRsnSiteCode;
	}

	public void setProgCodeRsnSiteCode(String progCodeRsnSiteCode) {
		this.progCodeRsnSiteCode = progCodeRsnSiteCode;
	}

	public long getRotationMasterId() {
		return rotationMasterId;
	}

	public void setRotationMasterId(long rotationMasterId) {
		this.rotationMasterId = rotationMasterId;
	}

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public List<TraineeDetails> getTraineeDetails() {
		return traineeDetails;
	}

	public void setTraineeDetails(List<TraineeDetails> traineeDetails) {
		this.traineeDetails = traineeDetails;
	}

	@Override
	public String toString() {
		return "SaveTraineeMasterRotationScheduleDTO [blockId=" + blockId + ", rotationId=" + rotationId
				+ ", rotationMasterId=" + rotationMasterId + ", progCodeRsnSiteCode=" + progCodeRsnSiteCode
				+ ", traineeDetails=" + traineeDetails + "]";
	}

}
