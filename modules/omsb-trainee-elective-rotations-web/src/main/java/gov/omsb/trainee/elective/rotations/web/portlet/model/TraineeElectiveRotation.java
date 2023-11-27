package gov.omsb.trainee.elective.rotations.web.portlet.model;

public class TraineeElectiveRotation {

	private long traineePdTlErDetailsId;
	private String programStructure;
	private String traineeLevel;
	private String electiveRotation;

	public long getTraineePdTlErDetailsId() {
		return traineePdTlErDetailsId;
	}

	public void setTraineePdTlErDetailsId(long traineePdTlErDetailsId) {
		this.traineePdTlErDetailsId = traineePdTlErDetailsId;
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
		return "TraineeElectiveRotation [traineePdTlErDetailsId=" + traineePdTlErDetailsId + ", programStructure="
				+ programStructure + ", traineeLevel=" + traineeLevel + ", electiveRotation=" + electiveRotation + "]";
	}

}
