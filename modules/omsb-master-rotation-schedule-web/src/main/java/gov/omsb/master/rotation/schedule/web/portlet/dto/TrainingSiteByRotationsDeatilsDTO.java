package gov.omsb.master.rotation.schedule.web.portlet.dto;

import java.util.List;

import gov.omsb.master.rotation.schedule.web.portlet.model.SaveFacultyMasterRotationScheduleDTO;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveTypes;

public class TrainingSiteByRotationsDeatilsDTO {
	
	List<TrainingSiteByRotationsDTO> trainingSiteByRotationsDTOs;
	
	List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels;
	
	List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs;
	
	List<TraineeRotationTsBlockDetailsRelByRotationDTO> traineeRotationTsBlockDetailsRelByRotationDTOs;
	
	List<SaveFacultyMasterRotationScheduleDTO> saveFacultyMasterRotationScheduleDTOs;
	
	List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs;
	
	List<TraineeLeaveDetailsWithBlocksDTO> leaveDetailsWithBlocksDTOs;
	
	List<TraineeElectiveRotationDTO> traineeElectiveRotationDTOs;
	
	List<LeaveTypes> leaveTypes;
	
	public List<TraineeElectiveRotationDTO> getTraineeElectiveRotationDTOs() {
		return traineeElectiveRotationDTOs;
	}

	public void setTraineeElectiveRotationDTOs(List<TraineeElectiveRotationDTO> traineeElectiveRotationDTOs) {
		this.traineeElectiveRotationDTOs = traineeElectiveRotationDTOs;
	}

	public List<LeaveTypes> getLeaveTypes() {
		return leaveTypes;
	}

	public void setLeaveTypes(List<LeaveTypes> leaveTypes) {
		this.leaveTypes = leaveTypes;
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

	public List<TraineeRotationTsBlockDetailsRelByRotationDTO> getTraineeRotationTsBlockDetailsRelByRotationDTOs() {
		return traineeRotationTsBlockDetailsRelByRotationDTOs;
	}

	public void setTraineeRotationTsBlockDetailsRelByRotationDTOs(
			List<TraineeRotationTsBlockDetailsRelByRotationDTO> traineeRotationTsBlockDetailsRelByRotationDTOs) {
		this.traineeRotationTsBlockDetailsRelByRotationDTOs = traineeRotationTsBlockDetailsRelByRotationDTOs;
	}

	public List<TraineeDetailsWithBlocksDTO> getTraineeDetailsWithBlocksDTOs() {
		return traineeDetailsWithBlocksDTOs;
	}

	public void setTraineeDetailsWithBlocksDTOs(List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs) {
		this.traineeDetailsWithBlocksDTOs = traineeDetailsWithBlocksDTOs;
	}

	public List<TrainingSiteByRotationsDTO> getTrainingSiteByRotationsDTOs() {
		return trainingSiteByRotationsDTOs;
	}

	public void setTrainingSiteByRotationsDTOs(List<TrainingSiteByRotationsDTO> trainingSiteByRotationsDTOs) {
		this.trainingSiteByRotationsDTOs = trainingSiteByRotationsDTOs;
	}

	public List<BlocksMetadataDetailsRel> getBlocksMetadataDetailsRels() {
		return blocksMetadataDetailsRels;
	}

	public void setBlocksMetadataDetailsRels(List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) {
		this.blocksMetadataDetailsRels = blocksMetadataDetailsRels;
	}

	public List<SaveFacultyMasterRotationScheduleDTO> getSaveFacultyMasterRotationScheduleDTOs() {
		return saveFacultyMasterRotationScheduleDTOs;
	}

	public void setSaveFacultyMasterRotationScheduleDTOs(
			List<SaveFacultyMasterRotationScheduleDTO> saveFacultyMasterRotationScheduleDTOs) {
		this.saveFacultyMasterRotationScheduleDTOs = saveFacultyMasterRotationScheduleDTOs;
	}

	@Override
	public String toString() {
		return "TrainingSiteByRotationsDeatilsDTO [trainingSiteByRotationsDTOs=" + trainingSiteByRotationsDTOs
				+ ", blocksMetadataDetailsRels=" + blocksMetadataDetailsRels + ", traineeDetailsWithBlocksDTOs="
				+ traineeDetailsWithBlocksDTOs + ", traineeRotationTsBlockDetailsRelByRotationDTOs="
				+ traineeRotationTsBlockDetailsRelByRotationDTOs + ", saveFacultyMasterRotationScheduleDTOs="
				+ saveFacultyMasterRotationScheduleDTOs + ", rotationTraineeBlockRelationDTOs="
				+ rotationTraineeBlockRelationDTOs + ", leaveDetailsWithBlocksDTOs=" + leaveDetailsWithBlocksDTOs
				+ ", traineeElectiveRotationDTOs=" + traineeElectiveRotationDTOs + ", leaveTypes=" + leaveTypes + "]";
	}

}
