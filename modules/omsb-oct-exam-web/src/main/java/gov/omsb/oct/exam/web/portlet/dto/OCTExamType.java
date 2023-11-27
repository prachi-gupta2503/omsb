package gov.omsb.oct.exam.web.portlet.dto;


public class OCTExamType {

	private long id;
	private long programId;
	private OCTExamTypeList examType;
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
	public OCTExamTypeList getExamType() {
		return examType;
	}
	public void setExamType(OCTExamTypeList examType) {
		this.examType = examType;
	}
	
	
	
	
}
