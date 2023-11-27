package gov.omsb.tms.custom.dto;

public class ConfigureRotationBlockDetailsDTO {
	
	private long noOfBlocks;

	public ConfigureRotationBlockDetailsDTO() {
		super();
	}

	public long getNoOfBlocks() {
		return noOfBlocks;
	}

	public void setNoOfBlocks(long noOfBlocks) {
		this.noOfBlocks = noOfBlocks;
	}

	@Override
	public String toString() {
		return "ConfigureRotationBlockDetailsDTO [noOfBlocks=" + noOfBlocks + "]";
	}
	
	

}
