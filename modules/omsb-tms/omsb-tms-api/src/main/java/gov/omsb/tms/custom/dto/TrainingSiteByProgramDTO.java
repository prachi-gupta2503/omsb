package gov.omsb.tms.custom.dto;

public class TrainingSiteByProgramDTO {
	
	private long trainingSiteId;
	private String trainingSiteName;
	private String programName;
	
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
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	@Override
	public String toString() {
		return "TrainingSiteByProgramDTO [trainingSiteId=" + trainingSiteId + ", trainingSiteName=" + trainingSiteName
				+ ", programName=" + programName + "]";
	}

}
