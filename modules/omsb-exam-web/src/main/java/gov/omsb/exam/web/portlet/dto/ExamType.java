package gov.omsb.exam.web.portlet.dto;


public class ExamType {
	private long id;
	private long programId;
	private String examType;
	private String examTypeName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProgramId() {
		return programId;
	}
	public void setProgramId(long programId) { 
		this.programId = programId;
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
	@Override
	public String toString() {
		return "ExamType [id=" + id + ", programId=" + programId + ", examType=" + examType + "]";
	}
	
	
}
