package gov.omsb.tms.custom.dto;

import java.util.List;

public class SauUserTrainingSiteCapacityDTO {

	private long progdurationRotationTsRelId;
	private long trainingSiteId;
	private String trainingSiteName;
	private String rotationName;
	private int noOfSlots;
	private String sauUsers;
	private List<SauUserTrainingSiteCapacityDTO> sauUserTrainingSiteCapacityDTOs;

	public long getProgdurationRotationTsRelId() {
		return progdurationRotationTsRelId;
	}

	public void setProgdurationRotationTsRelId(long progdurationRotationTsRelId) {
		this.progdurationRotationTsRelId = progdurationRotationTsRelId;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public int getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	public String getSauUsers() {
		return sauUsers;
	}

	public void setSauUsers(String sauUsers) {
		this.sauUsers = sauUsers;
	}

	public List<SauUserTrainingSiteCapacityDTO> getSauUserTrainingSiteCapacityDTOs() {
		return sauUserTrainingSiteCapacityDTOs;
	}

	public void setSauUserTrainingSiteCapacityDTOs(
			List<SauUserTrainingSiteCapacityDTO> sauUserTrainingSiteCapacityDTOs) {
		this.sauUserTrainingSiteCapacityDTOs = sauUserTrainingSiteCapacityDTOs;
	}

	@Override
	public String toString() {
		return "SauUserTrainingSiteCapacityDTO [progdurationRotationTsRelId=" + progdurationRotationTsRelId
				+ ", trainingSiteId=" + trainingSiteId + ", trainingSiteName=" + trainingSiteName + ", rotationName="
				+ rotationName + ", noOfSlots=" + noOfSlots + ", sauUsers=" + sauUsers
				+ ", sauUserTrainingSiteCapacityDTOs=" + sauUserTrainingSiteCapacityDTOs + "]";
	}

}
