package gov.omsb.master.rotation.schedule.web.portlet.dto;

public class ProgdurationRotationTrainingsitesRelDTO {
	
	private long progdurationRotationTsRelId;
	
	private long rotationId;
	
	private long trainingSitesId;
	
	private boolean isSharedRotation;
	
	private long rotationOwningProgramId;
	
	private String progCodeRsnSiteCode;
	
	private long noOfSlots;

	public long getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(long noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	public long getProgdurationRotationTsRelId() {
		return progdurationRotationTsRelId;
	}

	public void setProgdurationRotationTsRelId(long progdurationRotationTsRelId) {
		this.progdurationRotationTsRelId = progdurationRotationTsRelId;
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public long getTrainingSitesId() {
		return trainingSitesId;
	}

	public void setTrainingSitesId(long trainingSitesId) {
		this.trainingSitesId = trainingSitesId;
	}

	public boolean getIsSharedRotation() {
		return isSharedRotation;
	}

	public void setIsSharedRotation(boolean isSharedRotation) {
		this.isSharedRotation = isSharedRotation;
	}

	public long getRotationOwningProgramId() {
		return rotationOwningProgramId;
	}

	public void setRotationOwningProgramId(long rotationOwningProgramId) {
		this.rotationOwningProgramId = rotationOwningProgramId;
	}

	public String getProgCodeRsnSiteCode() {
		return progCodeRsnSiteCode;
	}

	public void setProgCodeRsnSiteCode(String progCodeRsnSiteCode) {
		this.progCodeRsnSiteCode = progCodeRsnSiteCode;
	}

	@Override
	public String toString() {
		return "ProgdurationRotationTrainingsitesRelDTO [progdurationRotationTsRelId=" + progdurationRotationTsRelId
				+ ", rotationId=" + rotationId + ", trainingSitesId=" + trainingSitesId + ", isSharedRotation="
				+ isSharedRotation + ", rotationOwningProgramId=" + rotationOwningProgramId + ", progCodeRsnSiteCode="
				+ progCodeRsnSiteCode + ", noOfSlots=" + noOfSlots + "]";
	}

	public ProgdurationRotationTrainingsitesRelDTO(long progdurationRotationTsRelId, long rotationId,
			long trainingSitesId, boolean isSharedRotation, long rotationOwningProgramId, String progCodeRsnSiteCode,
			long noOfSlots) {
		super();
		this.progdurationRotationTsRelId = progdurationRotationTsRelId;
		this.rotationId = rotationId;
		this.trainingSitesId = trainingSitesId;
		this.isSharedRotation = isSharedRotation;
		this.rotationOwningProgramId = rotationOwningProgramId;
		this.progCodeRsnSiteCode = progCodeRsnSiteCode;
		this.noOfSlots = noOfSlots;
	}

}
