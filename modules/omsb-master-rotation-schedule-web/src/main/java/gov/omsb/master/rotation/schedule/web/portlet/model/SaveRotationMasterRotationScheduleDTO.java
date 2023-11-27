package gov.omsb.master.rotation.schedule.web.portlet.model;

import java.util.List;

public class SaveRotationMasterRotationScheduleDTO {

	public static class RotationDetails {
		private long rotationId;
		private String rotationName;
		private long rotationMasterId;
		
		public long getRotationMasterId() {
			return rotationMasterId;
		}
		
		public void setRotationMasterId(long rotationMasterId) {
			this.rotationMasterId = rotationMasterId;
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

		@Override
		public String toString() {
			return "RotationDetails [rotationId=" + rotationId + ", rotationName=" + rotationName
					+ ", rotationMasterId=" + rotationMasterId + "]";
		}

	}
	private String rowId;
	private long blockId;
	private long traineeId;
	private List<RotationDetails> rotationDetails;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public List<RotationDetails> getRotationDetails() {
		return rotationDetails;
	}

	public void setRotationDetails(List<RotationDetails> rotationDetails) {
		this.rotationDetails = rotationDetails;
	}

	@Override
	public String toString() {
		return "SaveRotationMasterRotationScheduleDTO [rowId=" + rowId + ", blockId=" + blockId + ", traineeId="
				+ traineeId + ", rotationDetails=" + rotationDetails + "]";
	}

}
