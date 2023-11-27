package gov.omsb.master.rotation.schedule.web.portlet.dto;

import java.util.List;

import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;

public class TraineeLeaveDetailsWithBlocksDTO {
	
	private long blockId;
	
	private String blockName;
	
	private List<TraineeDetailsWithBlocksDTO> detailsWithBlocksDTOs;

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public List<TraineeDetailsWithBlocksDTO> getDetailsWithBlocksDTOs() {
		return detailsWithBlocksDTOs;
	}

	public void setDetailsWithBlocksDTOs(List<TraineeDetailsWithBlocksDTO> detailsWithBlocksDTOs) {
		this.detailsWithBlocksDTOs = detailsWithBlocksDTOs;
	}

	@Override
	public String toString() {
		return "TraineeLeaveDetailsWithBlocksDTO [blockId=" + blockId + ", blockName=" + blockName
				+ ", detailsWithBlocksDTOs=" + detailsWithBlocksDTOs + "]";
	}
	
}
