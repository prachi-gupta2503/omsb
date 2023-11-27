package gov.omsb.duty.logging.web.dto;

public class ProgramDutyRuleDTO {
	private long programDutyRuleId;
	private String program;
	private String cohort;
	private String dutyRule;
	private String status;

	public long getProgramDutyRuleId() {
		return programDutyRuleId;
	}

	public void setProgramDutyRuleId(long programDutyRuleId) {
		this.programDutyRuleId = programDutyRuleId;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	public String getDutyRule() {
		return dutyRule;
	}

	public void setDutyRule(String dutyRule) {
		this.dutyRule = dutyRule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProgramDutyRuleDTO [programDutyRuleId=" + programDutyRuleId + ", program=" + program + ", cohort="
				+ cohort + ", dutyRule=" + dutyRule + ", status=" + status + "]";
	}

	public String getJson() {
		return "{'programDutyRuleId':'" + programDutyRuleId + "','program':'" + program + "', 'cohort':'"
				+ cohort + "','dutyRule':'" + dutyRule + "','status':'" + status + "'}";

	}

}
