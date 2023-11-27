package gov.omsb.tms.custom.dto;

public class SetupProcedureDTO {

	private long progdurationRotationTlPgProcedurePtRelId;
	private long programDurationId;
	private String programDuration;
	private String traineeLevel;
	private String rotation;
	private String procedureGroup;
	private String procedures;
	private String participationType;
	private String cptCode;
	private int minimumProcedure;
	private int traineeLevelMinimumProcedure;

	public SetupProcedureDTO() {
		super();
	}

	public long getProgramDurationId() {
		return programDurationId;
	}

	public void setProgramDurationId(long programDurationId) {
		this.programDurationId = programDurationId;
	}

	public String getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}

	public String getTraineeLevel() {
		return traineeLevel;
	}

	public void setTraineeLevel(String traineeLevel) {
		this.traineeLevel = traineeLevel;
	}

	public String getRotation() {
		return rotation;
	}

	public void setRotation(String rotation) {
		this.rotation = rotation;
	}

	public String getProcedureGroup() {
		return procedureGroup;
	}

	public void setProcedureGroup(String procedureGroup) {
		this.procedureGroup = procedureGroup;
	}

	public String getProcedures() {
		return procedures;
	}

	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}

	public String getParticipationType() {
		return participationType;
	}

	public void setParticipationType(String participationType) {
		this.participationType = participationType;
	}

	public int getMinimumProcedure() {
		return minimumProcedure;
	}

	public void setMinimumProcedure(int minimumProcedure) {
		this.minimumProcedure = minimumProcedure;
	}

	public long getProgdurationRotationTlPgProcedurePtRelId() {
		return progdurationRotationTlPgProcedurePtRelId;
	}

	public void setProgdurationRotationTlPgProcedurePtRelId(long progdurationRotationTlPgProcedurePtRelId) {
		this.progdurationRotationTlPgProcedurePtRelId = progdurationRotationTlPgProcedurePtRelId;
	}

	public String getCptCode() {
		return cptCode;
	}

	public void setCptCode(String cptCode) {
		this.cptCode = cptCode;
	}

	public int getTraineeLevelMinimumProcedure() {
		return traineeLevelMinimumProcedure;
	}

	public void setTraineeLevelMinimumProcedure(int traineeLevelMinimumProcedure) {
		this.traineeLevelMinimumProcedure = traineeLevelMinimumProcedure;
	}

	@Override
	public String toString() {
		return "SetupProcedureDTO [progdurationRotationTlPgProcedurePtRelId=" + progdurationRotationTlPgProcedurePtRelId
				+ ", programDurationId=" + programDurationId + ", programDuration=" + programDuration
				+ ", traineeLevel=" + traineeLevel + ", rotation=" + rotation + ", procedureGroup=" + procedureGroup
				+ ", procedures=" + procedures + ", participationType=" + participationType + ", cptCode=" + cptCode
				+ ", minimumProcedure=" + minimumProcedure + ", traineeLevelMinimumProcedure="
				+ traineeLevelMinimumProcedure + "]";
	}

}
