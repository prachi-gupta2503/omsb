package gov.omsb.master.rotation.schedule.web.portlet.dto;

import java.util.List;

import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;

public class TraineeRotationTsBlockDetailsRelByRotationDTO {
	
	
	private List<TraineeDetailsWithBlocksDTO> detailsWithBlocksDTOs;
	
	private List<ProgdurationRotationTrainingsitesRelDTO> progdurationRotationTrainingsitesRels;

	public List<TraineeDetailsWithBlocksDTO> getDetailsWithBlocksDTOs() {
		return detailsWithBlocksDTOs;
	}

	public void setDetailsWithBlocksDTOs(List<TraineeDetailsWithBlocksDTO> detailsWithBlocksDTOs) {
		this.detailsWithBlocksDTOs = detailsWithBlocksDTOs;
	}

	public List<ProgdurationRotationTrainingsitesRelDTO> getProgdurationRotationTrainingsitesRels() {
		return progdurationRotationTrainingsitesRels;
	}

	public void setProgdurationRotationTrainingsitesRels(
			List<ProgdurationRotationTrainingsitesRelDTO> progdurationRotationTrainingsitesRels) {
		this.progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRels;
	}

	@Override
	public String toString() {
		return "TraineeRotationTsBlockDetailsRelByRotationDTO [detailsWithBlocksDTOs=" + detailsWithBlocksDTOs
				+ ", progdurationRotationTrainingsitesRels=" + progdurationRotationTrainingsitesRels + "]";
	}
}
