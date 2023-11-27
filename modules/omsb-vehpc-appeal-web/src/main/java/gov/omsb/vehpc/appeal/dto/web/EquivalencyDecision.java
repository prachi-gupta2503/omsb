package gov.omsb.vehpc.appeal.dto.web;

public class EquivalencyDecision {

	
	private String comments;
	private String otherEquivalency;
	private EquivalencyLevel equivalencyLevelId;
	private String id;
	private long equivalencyRequestId;
	private String dateCreated;
	private long documentInfoId;
	private String employerName;
	private String dFFileName;
	private boolean appealExist;
	

	
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
	public long getDocumentInfoId() {
		return documentInfoId;
	}
	public void setDocumentInfoId(long documentInfoId) {
		this.documentInfoId = documentInfoId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getOtherEquivalency() {
		return otherEquivalency;
	}
	public void setOtherEquivalency(String otherEquivalency) {
		this.otherEquivalency = otherEquivalency;
	}
	public EquivalencyLevel getEquivalencyLevelId() {
		return equivalencyLevelId;
	}
	public void setEquivalencyLevelId(EquivalencyLevel equivalencyLevelId) {
		this.equivalencyLevelId = equivalencyLevelId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}
	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
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
	
	public boolean isAppealExist() {
		return appealExist;
	}
	public void setAppealExist(boolean appealExist) {
		this.appealExist = appealExist;
	}
	
	
	
	
	
	
	
	
}
