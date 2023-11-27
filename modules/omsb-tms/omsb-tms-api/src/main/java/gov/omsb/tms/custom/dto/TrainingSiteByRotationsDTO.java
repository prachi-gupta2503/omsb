package gov.omsb.tms.custom.dto;

public class TrainingSiteByRotationsDTO {
	
	private long progDurationRotationTsRelId;
	
	private String progCodeRsnSiteCode;
	
	private boolean isSharedRotation;
	
	private long rotationOwningProgramId;
	
	private int noOfslots;
	
	private long trainingSiteMasterId;
	
	private boolean SharedRotationType;
	
	private long rotationId;
	
	private long owningProgramDurationId;

	public long getOwningProgramDurationId() {
		return owningProgramDurationId;
	}

	public void setOwningProgramDurationId(long owningProgramDurationId) {
		this.owningProgramDurationId = owningProgramDurationId;
	}

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	public long getProgDurationRotationTsRelId() {
		return progDurationRotationTsRelId;
	}

	public void setProgDurationRotationTsRelId(long progDurationRotationTsRelId) {
		this.progDurationRotationTsRelId = progDurationRotationTsRelId;
	}

	public String getProgCodeRsnSiteCode() {
		return progCodeRsnSiteCode;
	}

	public void setProgCodeRsnSiteCode(String progCodeRsnSiteCode) {
		this.progCodeRsnSiteCode = progCodeRsnSiteCode;
	}

	public boolean isSharedRotation() {
		return isSharedRotation;
	}

	public void setSharedRotation(boolean isSharedRotation) {
		this.isSharedRotation = isSharedRotation;
	}

	public long getRotationOwningProgramId() {
		return rotationOwningProgramId;
	}

	public void setRotationOwningProgramId(long rotationOwningProgramId) {
		this.rotationOwningProgramId = rotationOwningProgramId;
	}

	public int getNoOfslots() {
		return noOfslots;
	}

	public void setNoOfslots(int noOfslots) {
		this.noOfslots = noOfslots;
	}

	public long getTrainingSiteMasterId() {
		return trainingSiteMasterId;
	}

	public void setTrainingSiteMasterId(long trainingSiteMasterId) {
		this.trainingSiteMasterId = trainingSiteMasterId;
	}

	public boolean isSharedRotationType() {
		return SharedRotationType;
	}

	public void setSharedRotationType(boolean sharedRotationType) {
		SharedRotationType = sharedRotationType;
	}

	@Override
	public String toString() {
		return "TrainingSiteByRotationsDTO [progDurationRotationTsRelId=" + progDurationRotationTsRelId
				+ ", progCodeRsnSiteCode=" + progCodeRsnSiteCode + ", isSharedRotation=" + isSharedRotation
				+ ", rotationOwningProgramId=" + rotationOwningProgramId + ", noOfslots=" + noOfslots
				+ ", trainingSiteMasterId=" + trainingSiteMasterId + ", SharedRotationType=" + SharedRotationType
				+ ", rotationId=" + rotationId + ", owningProgramDurationId=" + owningProgramDurationId + "]";
	}

}
