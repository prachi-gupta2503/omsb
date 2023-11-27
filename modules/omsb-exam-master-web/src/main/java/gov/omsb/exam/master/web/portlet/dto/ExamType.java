package gov.omsb.exam.master.web.portlet.dto;


public class ExamType {
	private long id;
	private long programTypeId;
	private String examType;
	private String examTypeName;
	private String programTypeName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getProgramTypeId() {
		return programTypeId;
	}
	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}
	public String getProgramTypeName() {
		return programTypeName;
	}
	public void setProgramTypeName(String programTypeName) {
		this.programTypeName = programTypeName;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	
	
}
