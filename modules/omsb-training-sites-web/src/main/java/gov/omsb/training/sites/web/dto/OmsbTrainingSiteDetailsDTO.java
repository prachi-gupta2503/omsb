package gov.omsb.training.sites.web.dto;

public class OmsbTrainingSiteDetailsDTO {

	private String requesterName;
	private String trainingSiteName;
	private String programName;
	private String rotationName;
	private long currentSlots;
	private long demandSlots;
	private String role;
	private String userIds;

	public OmsbTrainingSiteDetailsDTO() {
		super();
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public long getCurrentSlots() {
		return currentSlots;
	}

	public void setCurrentSlots(long currentSlots) {
		this.currentSlots = currentSlots;
	}

	public long getDemandSlots() {
		return demandSlots;
	}

	public void setDemandSlots(long demandSlots) {
		this.demandSlots = demandSlots;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

}
