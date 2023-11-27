package gov.omsb.vehpc.appeal.dto.web;

public class EquivalencyDecisionLevel {
	
	private EquivalencyLevel  equivalencyLevelId;
	private String comments;
	private long documentInfoId;
	private long  eqRequestId;
	private String dateCreated;
	private String dFFileName;
	private long id;
	private String employerName;
	private String employeeName;
	private boolean appealExist;
	
	
	public EquivalencyLevel getEquivalencyLevelId() {
		return equivalencyLevelId;
	}
	public void setEquivalencyLevelId(EquivalencyLevel equivalencyLevelId) {
		this.equivalencyLevelId = equivalencyLevelId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getDocumentInfoId() {
		return documentInfoId;
	}
	public void setDocumentInfoId(long documentInfoId) {
		this.documentInfoId = documentInfoId;
	}
	public long getEqRequestId() {
		return eqRequestId;
	}
	public void setEqRequestId(long eqRequestId) {
		this.eqRequestId = eqRequestId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getdFFileName() {
		return dFFileName;
	}
	public void setdFFileName(String dFFileName) {
		this.dFFileName = dFFileName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean isAppealExist() {
		return appealExist;
	}
	public void setAppealExist(boolean appealExist) {
		this.appealExist = appealExist;
	}
	
	

}
