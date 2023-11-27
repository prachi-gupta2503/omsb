package gov.omsb.master.rotation.schedule.web.portlet.dto;

import java.util.List;

import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveTypes;

public class TrainingSiteByTraineeDeatilsDTO {

	
	private List<TrainingSiteByRotationsDTO> siteByRotationsDTOs;
	
	private List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs;
	
	List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels;
	
	List<TraineeRotationTsBlockDetailsRelByTraineeDTO> detailsRelByTraineeDTOs;
	
	List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs;
	
	List<TraineeLeaveDetailsWithBlocksDTO> leaveDetailsWithBlocksDTOs;
	
	List<LeaveTypes> leaveType;
	
	List<TraineeElectiveRotationDTO> traineeElectiveRotationDTOs;

	public List<TraineeElectiveRotationDTO> getTraineeElectiveRotationDTOs() {
		return traineeElectiveRotationDTOs;
	}

	public void setTraineeElectiveRotationDTOs(List<TraineeElectiveRotationDTO> traineeElectiveRotationDTOs) {
		this.traineeElectiveRotationDTOs = traineeElectiveRotationDTOs;
	}

	public List<LeaveTypes> getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(List<LeaveTypes> leaveType) {
		this.leaveType = leaveType;
	}

	public List<TraineeLeaveDetailsWithBlocksDTO> getLeaveDetailsWithBlocksDTOs() {
		return leaveDetailsWithBlocksDTOs;
	}

	public void setLeaveDetailsWithBlocksDTOs(List<TraineeLeaveDetailsWithBlocksDTO> leaveDetailsWithBlocksDTOs) {
		this.leaveDetailsWithBlocksDTOs = leaveDetailsWithBlocksDTOs;
	}

	public List<RotationTraineeBlockRelationDTO> getRotationTraineeBlockRelationDTOs() {
		return rotationTraineeBlockRelationDTOs;
	}

	public void setRotationTraineeBlockRelationDTOs(
			List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs) {
		this.rotationTraineeBlockRelationDTOs = rotationTraineeBlockRelationDTOs;
	}

	public List<TrainingSiteByRotationsDTO> getSiteByRotationsDTOs() {
		return siteByRotationsDTOs;
	}

	public void setSiteByRotationsDTOs(List<TrainingSiteByRotationsDTO> siteByRotationsDTOs) {
		this.siteByRotationsDTOs = siteByRotationsDTOs;
	}

	public List<TraineeDetailsWithBlocksDTO> getTraineeDetailsWithBlocksDTOs() {
		return traineeDetailsWithBlocksDTOs;
	}

	public void setTraineeDetailsWithBlocksDTOs(List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs) {
		this.traineeDetailsWithBlocksDTOs = traineeDetailsWithBlocksDTOs;
	}

	public List<BlocksMetadataDetailsRel> getBlocksMetadataDetailsRels() {
		return blocksMetadataDetailsRels;
	}

	public void setBlocksMetadataDetailsRels(List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) {
		this.blocksMetadataDetailsRels = blocksMetadataDetailsRels;
	}

	public List<TraineeRotationTsBlockDetailsRelByTraineeDTO> getDetailsRelByTraineeDTOs() {
		return detailsRelByTraineeDTOs;
	}

	public void setDetailsRelByTraineeDTOs(List<TraineeRotationTsBlockDetailsRelByTraineeDTO> detailsRelByTraineeDTOs) {
		this.detailsRelByTraineeDTOs = detailsRelByTraineeDTOs;
	}

	@Override
	public String toString() {
		return "TrainingSiteByTraineeDeatilsDTO [siteByRotationsDTOs=" + siteByRotationsDTOs
				+ ", traineeDetailsWithBlocksDTOs=" + traineeDetailsWithBlocksDTOs + ", blocksMetadataDetailsRels="
				+ blocksMetadataDetailsRels + ", detailsRelByTraineeDTOs=" + detailsRelByTraineeDTOs
				+ ", rotationTraineeBlockRelationDTOs=" + rotationTraineeBlockRelationDTOs
				+ ", leaveDetailsWithBlocksDTOs=" + leaveDetailsWithBlocksDTOs + ", leaveType=" + leaveType
				+ ", traineeElectiveRotationDTOs=" + traineeElectiveRotationDTOs + "]";
	}
	
}