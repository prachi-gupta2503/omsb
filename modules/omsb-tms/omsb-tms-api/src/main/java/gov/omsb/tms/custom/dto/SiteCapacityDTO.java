package gov.omsb.tms.custom.dto;

public class SiteCapacityDTO {
	private long progdurationRotationTsRelId;
	private String cohort;
	private long cohortId;
	private String trainingSite;
	private String rotation;
	private int noOfSlots;

	public long getCohortId() {
		return cohortId;
	}

	public void setCohortId(long cohortId) {
		this.cohortId = cohortId;
	}

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

	public int getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	@Override
	public String toString() {
		return "SiteCapacityDTO [progdurationRotationTsRelId=" + progdurationRotationTsRelId + ", cohort=" + cohort
				+ ", cohortId=" + cohortId + ", trainingSite=" + trainingSite + ", rotation=" + rotation
				+ ", noOfSlots=" + noOfSlots + "]";
	}

}
