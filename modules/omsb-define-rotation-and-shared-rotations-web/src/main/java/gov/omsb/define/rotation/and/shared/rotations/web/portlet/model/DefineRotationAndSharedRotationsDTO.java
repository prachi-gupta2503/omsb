package gov.omsb.define.rotation.and.shared.rotations.web.portlet.model;

public class DefineRotationAndSharedRotationsDTO {
	private long progdurationRotationTsRelId;
	private String cohort;
	private String trainingSite;
	private String rotation;
	private String isSharedRotation;
	private String slotes;
	private String sharedRotationOwningProgram;
	
	public long getProgdurationRotationTsRelId() {
		return progdurationRotationTsRelId;
	}
	public void setProgdurationRotationTsRelId(long progdurationRotationTsRelId) {
		this.progdurationRotationTsRelId = progdurationRotationTsRelId;
	}
	public String getCohort() {
		return cohort;
	}
	public void setCohort(String cohort) {
		this.cohort = cohort;
	}
	public String getTrainingSite() {
		return trainingSite;
	}
	public void setTrainingSite(String trainingSite) {
		this.trainingSite = trainingSite;
	}
	public String getRotation() {
		return rotation;
	}
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}
	public String getIsSharedRotation() {
		return isSharedRotation;
	}
	public void setIsSharedRotation(String isSharedRotation) {
		this.isSharedRotation = isSharedRotation;
	}
	public String getSlotes() {
		return slotes;
	}
	public void setSlotes(String slotes) {
		this.slotes = slotes;
	}
	public String getSharedRotationOwningProgram() {
		return sharedRotationOwningProgram;
	}
	public void setSharedRotationOwningProgram(String sharedRotationOwningProgram) {
		this.sharedRotationOwningProgram = sharedRotationOwningProgram;
	}
	
	@Override
	public String toString() {
		return "DefineRotationAndSharedRotationsDTO [progdurationRotationTsRelId=" + progdurationRotationTsRelId
				+ ", cohort=" + cohort + ", trainingSite=" + trainingSite + ", rotation=" + rotation
				+ ", isSharedRotation=" + isSharedRotation + ", slotes=" + slotes + ", sharedRotationOwningProgram="
				+ sharedRotationOwningProgram + "]";
	}
	
}
