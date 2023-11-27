package gov.omsb.programs.web.dto;

public class TraineeElectiveRotationDTO {

	private long traineePdTlErDetailsId;
	private long traineeLevelId;
	private long electiverotationPriorityDetailsId;
	private String programStructure;
	private String traineeLevel;
	private String electiveRotation;
	
	public long getTraineePdTlErDetailsId() {
		return traineePdTlErDetailsId;
	}
	public void setTraineePdTlErDetailsId(long traineePdTlErDetailsId) {
		this.traineePdTlErDetailsId = traineePdTlErDetailsId;
	}
	public long getTraineeLevelId() {
		return traineeLevelId;
	}
	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}
	public long getElectiverotationPriorityDetailsId() {
		return electiverotationPriorityDetailsId;
	}
	public void setElectiverotationPriorityDetailsId(long electiverotationPriorityDetailsId) {
		this.electiverotationPriorityDetailsId = electiverotationPriorityDetailsId;
	}
	public String getProgramStructure() {
		return programStructure;
	}
	public void setProgramStructure(String programStructure) {
		this.programStructure = programStructure;
	}
	public String getTraineeLevel() {
		return traineeLevel;
	}
	public void setTraineeLevel(String traineeLevel) {
		this.traineeLevel = traineeLevel;
	}
	public String getElectiveRotation() {
		return electiveRotation;
	}
	public void setElectiveRotation(String electiveRotation) {
		this.electiveRotation = electiveRotation;
	}
	
	@Override
	public String toString() {
		return "TraineeElectiveRotationDTO [traineePdTlErDetailsId=" + traineePdTlErDetailsId + ", traineeLevelId="
				+ traineeLevelId + ", electiverotationPriorityDetailsId=" + electiverotationPriorityDetailsId
				+ ", programStructure=" + programStructure + ", traineeLevel=" + traineeLevel + ", electiveRotation="
				+ electiveRotation + "]";
	}

}
