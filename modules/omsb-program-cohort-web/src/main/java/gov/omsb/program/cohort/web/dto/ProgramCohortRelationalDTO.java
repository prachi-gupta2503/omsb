package gov.omsb.program.cohort.web.dto;

public class ProgramCohortRelationalDTO {

	private long progdurationTlBlocksLtId;
	private long traineeLevelId;
	private int noOfBlocks;
	private long levelTypeId;
	
	public long getProgdurationTlBlocksLtId() {
		return progdurationTlBlocksLtId;
	}

	public void setProgdurationTlBlocksLtId(long progdurationTlBlocksLtId) {
		this.progdurationTlBlocksLtId = progdurationTlBlocksLtId;
	}

	public long getTraineeLevelId() {
		return traineeLevelId;
	}

	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}

	public int getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(int noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	public long getLevelTypeId() {
		return levelTypeId;
	}

	public void setLevelTypeId(long levelTypeId) {
		this.levelTypeId = levelTypeId;
	}

	@Override
	public String toString() {
		return "ProgramCohortRelationalDTO [progdurationTlBlocksLtId=" + progdurationTlBlocksLtId + ", traineeLevelId="
				+ traineeLevelId + ", noOfBlocks=" + noOfBlocks + ", levelTypeId=" + levelTypeId + "]";
	}

}
