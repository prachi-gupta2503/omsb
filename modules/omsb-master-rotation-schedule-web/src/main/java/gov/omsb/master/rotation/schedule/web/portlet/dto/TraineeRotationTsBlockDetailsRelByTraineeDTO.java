package gov.omsb.master.rotation.schedule.web.portlet.dto;

import java.util.List;

import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;

public class TraineeRotationTsBlockDetailsRelByTraineeDTO {

	private ProgdurationRotationTrainingsitesRelDTO progdurationRotationTrainingsitesRels;

	private List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTO;

	public ProgdurationRotationTrainingsitesRelDTO getProgdurationRotationTrainingsitesRels() {
		return progdurationRotationTrainingsitesRels;
	}

	public void setProgdurationRotationTrainingsitesRels(
			ProgdurationRotationTrainingsitesRelDTO progdurationRotationTrainingsitesRels) {
		this.progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRels;
	}

	public List<TraineeDetailsWithBlocksDTO> getTraineeDetailsWithBlocksDTO() {
		return traineeDetailsWithBlocksDTO;
	}

	public void setTraineeDetailsWithBlocksDTO(List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTO) {
		this.traineeDetailsWithBlocksDTO = traineeDetailsWithBlocksDTO;
	}

	@Override
	public String toString() {
		return "TraineeRotationTsBlockDetailsRelByTraineeDTO [progdurationRotationTrainingsitesRels="
				+ progdurationRotationTrainingsitesRels + ", traineeDetailsWithBlocksDTO=" + traineeDetailsWithBlocksDTO
				+ "]";
	}

}
