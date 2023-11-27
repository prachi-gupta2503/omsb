package gov.omsb.rotations.web.dto;

import java.util.HashMap;
import java.util.Map;

public class ProgramRotationDTO {
	String programName;
	long programId;
	Map<String, Long> rotationTrainingLevel = new HashMap<>();

	public ProgramRotationDTO(String programName, long programId, Map<String, Long> rotationTrainingLevel) {
		super();
		this.programName = programName;
		this.programId = programId;
		this.rotationTrainingLevel = rotationTrainingLevel;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {	
		this.programId = programId;
	}

	public Map<String, Long> getRotationTrainingLevel() {
		return rotationTrainingLevel;
	}

	public void setRotationTrainingLevel(Map<String, Long> rotationTrainingLevel) {
		this.rotationTrainingLevel = rotationTrainingLevel;
	}

	@Override
	public String toString() {
		return "ProgramRotationDTO [programName=" + programName + ", programId=" + programId
				+ ", rotationTrainingLevel=" + rotationTrainingLevel + "]";
	}

}
