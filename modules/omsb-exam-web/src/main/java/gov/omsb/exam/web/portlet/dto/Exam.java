package gov.omsb.exam.web.portlet.dto;

import java.util.List;

public class Exam {
	private long id;
	private String examJson;
//	private String program;
	private long programTypeId;
	private long examTypeId;
	private String resultSource;
	private long examEligibility;
	private List<Program> program;
	private float earlyBirdFees;
	private String earlyBirdFeesDate;
	private int appealWindow;
	private float appealFees;
	private int reAppealWindow;
	private float reAppealFees;
	private List<RegularFees> regularFees;
	private List<WithdrawalFees> withdrawalFees;
//	private List<ExamEligibility> examEligibility;
	private String examType;
	private String programTypeName;
	private String allowedNoOfAttempt;
	private boolean changed;
	private String examEligibilityName;
	private String ruleName;

	@Override
	public String toString() {
		return "Exam [id=" + id + ", examJson=" + examJson + ", program=" + program + ", programTypeId=" + programTypeId
				+ ", examTypeId=" + examTypeId + ", resultSource=" + resultSource + ", examEligibility="
				+ examEligibility + ", examEligibility2=" + program + ", earlyBirdFees=" + earlyBirdFees
				+ ", earlyBirdFeesDate=" + earlyBirdFeesDate + ", appealWindow=" + appealWindow + ", appealFees="
				+ appealFees + ", reAppealWindow=" + reAppealWindow + ", reAppealFees=" + reAppealFees
				+ ", regularFees=" + regularFees + ", withdrawalFees=" + withdrawalFees + ", examType=" + examType
				+ "]";
	}

	
	public String getExamEligibilityName() {
		return examEligibilityName;
	}


	public void setExamEligibilityName(String examEligibilityName) {
		this.examEligibilityName = examEligibilityName;
	}


	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExamJson() {
		return examJson;
	}

	public void setExamJson(String examJson) {
		this.examJson = examJson;
	}

	

	public List<Program> getProgram() {
		return program;
	}

	public void setProgram(List<Program> program) {
		this.program = program;
	}

	public long getProgramTypeId() {
		return programTypeId;
	}

	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}

	public long getExamTypeId() {
		return examTypeId;
	}

	public void setExamTypeId(long examTypeId) {
		this.examTypeId = examTypeId;
	}

	public String getResultSource() {
		return resultSource;
	}

	public void setResultSource(String resultSource) {
		this.resultSource = resultSource;
	}

	public long getExamEligibility() {
		return examEligibility;
	}

	public void setExamEligibility(long examEligibility) {
		this.examEligibility = examEligibility;
	}

	public float getEarlyBirdFees() {
		return earlyBirdFees;
	}

	public void setEarlyBirdFees(float earlyBirdFees) {
		this.earlyBirdFees = earlyBirdFees;
	}

	public String getEarlyBirdFeesDate() {
		return earlyBirdFeesDate;
	}

	public void setEarlyBirdFeesDate(String earlyBirdFeesDate) {
		this.earlyBirdFeesDate = earlyBirdFeesDate;
	}

	public int getAppealWindow() {
		return appealWindow;
	}

	public void setAppealWindow(int appealWindow) {
		this.appealWindow = appealWindow;
	}

	public float getAppealFees() {
		return appealFees;
	}

	public void setAppealFees(float appealFees) {
		this.appealFees = appealFees;
	}

	public int getReAppealWindow() {
		return reAppealWindow;
	}

	public void setReAppealWindow(int reAppealWindow) {
		this.reAppealWindow = reAppealWindow;
	}

	public float getReAppealFees() {
		return reAppealFees;
	}

	public void setReAppealFees(float reAppealFees) {
		this.reAppealFees = reAppealFees;
	}

	public List<RegularFees> getRegularFees() {
		return regularFees;
	}

	public void setRegularFees(List<RegularFees> regularFees) {
		this.regularFees = regularFees;
	}

	public List<WithdrawalFees> getWithdrawalFees() {
		return withdrawalFees;
	}

	public void setWithdrawalFees(List<WithdrawalFees> withdrawalFees) {
		this.withdrawalFees = withdrawalFees;
	}

	public String getProgramTypeName() {
		return programTypeName;
	}

	public void setProgramTypeName(String programTypeName) {
		this.programTypeName = programTypeName;
	}

	public boolean getChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public String getAllowedNoOfAttempt() {
		return allowedNoOfAttempt;
	}

	public void setAllowedNoOfAttempt(String allowedNoOfAttempt) {
		this.allowedNoOfAttempt = allowedNoOfAttempt;
	}


	public String getRuleName() {
		return ruleName;
	}


	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	

}
