package gov.omsb.tms.custom.dto;

import java.util.Date;

public class ProgramCohortDTO {

	private long progdurationTlBlocksLtId;
	private String programName;
	private String ayApplicableForm;
	private long noOfBlocks;
	private String traineeLevelName;
	private String levelTypeName;
	private long programMasterId;
	private long programDurationId;
	private Date modifiedDate;
	private String actions;
	private long traineeLevelId;

	public long getProgdurationTlBlocksLtId() {
		return progdurationTlBlocksLtId;
	}

	public void setProgdurationTlBlocksLtId(long progdurationTlBlocksLtId) {
		this.progdurationTlBlocksLtId = progdurationTlBlocksLtId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getAyApplicableForm() {
		return ayApplicableForm;
	}

	public void setAyApplicableForm(String ayApplicableForm) {
		this.ayApplicableForm = ayApplicableForm;
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

	public void setTraineeLevelName(String traineeLevelName) {
		this.traineeLevelName = traineeLevelName;
	}

	public String getLevelTypeName() {
		return levelTypeName;
	}

	public void setLevelTypeName(String levelTypeName) {
		this.levelTypeName = levelTypeName;
	}
	
	public long getProgramMasterId() {
		return programMasterId;
	}

	public void setProgramMasterId(long programMasterId) {
		this.programMasterId = programMasterId;
	}
	
	public long getProgramDurationId() {
		return programDurationId;
	}

	public void setProgramDurationId(long programDurationId) {
		this.programDurationId = programDurationId;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}
	
	public long getTraineeLevelId() {
		return traineeLevelId;
	}

	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}

	@Override
	public String toString() {
		return "ProgramCohortDTO [progdurationTlBlocksLtId=" + progdurationTlBlocksLtId + ", programName=" + programName
				+ ", ayApplicableForm=" + ayApplicableForm + ", noOfBlocks=" + noOfBlocks + ", traineeLevelName="
				+ traineeLevelName + ", levelTypeName=" + levelTypeName + ", programMasterId=" + programMasterId
				+ ", programDurationId=" + programDurationId + ", modifiedDate=" + modifiedDate + ", actions=" + actions
				+ ", traineeLevelId=" + traineeLevelId + "]";
	}
}
