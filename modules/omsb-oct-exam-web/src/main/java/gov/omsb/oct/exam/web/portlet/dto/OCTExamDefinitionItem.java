package gov.omsb.oct.exam.web.portlet.dto;

import java.util.Date;

public class OCTExamDefinitionItem {
	
	private long id;
	private long examId;
	private long programId;
	private long programTypeId;
	private long examTypeId;
	private String examType;
	private String resultSource;
	private String examEligibility;
	private int reAppealWindow;
	private double reAppealFees;
	private double appealFees;
	private int appealWindow;
	private double earlyBirdFees;
	private Date earlyBirdFeesDate;
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
	public long getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(long examTypeId) {
		this.examTypeId = examTypeId;
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
	public int getReAppealWindow() {
		return reAppealWindow;
	}
	public void setReAppealWindow(int reAppealWindow) {
		this.reAppealWindow = reAppealWindow;
	}
	public double getReAppealFees() {
		return reAppealFees;
	}
	public void setReAppealFees(double reAppealFees) {
		this.reAppealFees = reAppealFees;
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
	public Date getEarlyBirdFeesDate() {
		return earlyBirdFeesDate;
	}
	public void setEarlyBirdFeesDate(Date earlyBirdFeesDate) {
		this.earlyBirdFeesDate = earlyBirdFeesDate;
	}
	
	@Override
	public String toString() {
		return "OCTExamDefinitionItem [id=" + id + ", examId=" + examId + ", programId=" + programId
				+ ", programTypeId=" + programTypeId + ", examTypeId=" + examTypeId + ", examType=" + examType
				+ ", resultSource=" + resultSource + ", examEligibility=" + examEligibility + ", reAppealWindow="
				+ reAppealWindow + ", reAppealFees=" + reAppealFees + ", appealFees=" + appealFees + ", appealWindow="
				+ appealWindow + ", earlyBirdFees=" + earlyBirdFees + ", earlyBirdFeesDate=" + earlyBirdFeesDate + "]";
	}
}
