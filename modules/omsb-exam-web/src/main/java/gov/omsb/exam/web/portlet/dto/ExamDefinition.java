package gov.omsb.exam.web.portlet.dto;

public class ExamDefinition {
	private long id;
	private long examId;
	private long programId;
	private long programTypeId;
	private long examTypeId;
	private String examType;
	private String resultSource;
	private String examEligibility;
	private int reappealWindow;
	private double reappealFees;
	private double appealFees;
	private int appealWindow;
	private double earlyBirdFees;
	private int earlyBirdFeesDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public long getProgramTypeId() {
		return programTypeId;
	}

	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getResultSource() {
		return resultSource;
	}

	public void setResultSource(String resultSource) {
		this.resultSource = resultSource;
	}

	public String getExamEligibility() {
		return examEligibility;
	}

	public void setExamEligibility(String examEligibility) {
		this.examEligibility = examEligibility;
	}

	
	public int getReappealWindow() {
		return reappealWindow;
	}

	public void setReappealWindow(int reappealWindow) {
		this.reappealWindow = reappealWindow;
	}

	public double getReappealFees() {
		return reappealFees;
	}

	public void setReappealFees(double reappealFees) {
		this.reappealFees = reappealFees;
	}

	public double getAppealFees() {
		return appealFees;
	}

	public void setAppealFees(double appealFees) {
		this.appealFees = appealFees;
	}

	public int getAppealWindow() {
		return appealWindow;
	}

	public void setAppealWindow(int appealWindow) {
		this.appealWindow = appealWindow;
	}

	public double getEarlyBirdFees() {
		return earlyBirdFees;
	}

	public void setEarlyBirdFees(double earlyBirdFees) {
		this.earlyBirdFees = earlyBirdFees;
	}

	public int getEarlyBirdFeesDate() {
		return earlyBirdFeesDate;
	}

	public void setEarlyBirdFeesDate(int earlyBirdFeesDate) {
		this.earlyBirdFeesDate = earlyBirdFeesDate;
	}

	public long getExamTypeId() {
		return examTypeId;
	}

	public void setExamTypeId(long examTypeId) {
		this.examTypeId = examTypeId;
	}
}
