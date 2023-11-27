package gov.omsb.programs.web.dto;

/**
 * @author Jayesh Goswami
 */
public class TraineeLevelDTO {

	long progDurationRotationTlBlocksRelId;
	long traineeLevelMasterId;
	long noOfBlocks;
	String traineeLevelName;
	boolean isElective;
	long rotationType;

	public long getProgDurationRotationTlBlocksRelId() {
		return progDurationRotationTlBlocksRelId;
	}

	public void setProgDurationRotationTlBlocksRelId(long progDurationRotationTlBlocksRelId) {
		this.progDurationRotationTlBlocksRelId = progDurationRotationTlBlocksRelId;
	}

	public long getTraineeLevelMasterId() {
		return traineeLevelMasterId;
	}

	public void setTraineeLevelMasterId(long traineeLevelMasterId) {
		this.traineeLevelMasterId = traineeLevelMasterId;
	}

	public long getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(long noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	public String getTraineeLevelName() {
		return traineeLevelName;
	}
	
	public boolean isElective() {
		return isElective;
	}

	public void setElective(boolean isElective) {
		this.isElective = isElective;
	}

	public void setTraineeLevelName(String traineeLevelName) {
		this.traineeLevelName = traineeLevelName;
	}
	
	public long getRotationType() {
		return rotationType;
	}

	public void setRotationType(long rotationType) {
		this.rotationType = rotationType;
	}

	@Override
	public String toString() {
		return "TraineeLevelDTO [progDurationRotationTlBlocksRelId=" + progDurationRotationTlBlocksRelId
				+ ", traineeLevelMasterId=" + traineeLevelMasterId + ", noOfBlocks=" + noOfBlocks
				+ ", traineeLevelName=" + traineeLevelName + ", isElective=" + isElective + ", rotationType="
				+ rotationType + "]";
	}

}
