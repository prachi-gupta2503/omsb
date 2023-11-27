package gov.omsb.configure.rotations.web.dto;

public class ValidateRotationDTO {
	
	private Long rotationId;
	
	private Long rotationTypeId;
	
	private Integer noOfBlock;
	
	public ValidateRotationDTO() {
		super();
	}

	public Long getRotationId() {
		return rotationId;
	}

	public void setRotationId(Long rotationId) {
		this.rotationId = rotationId;
	}

	public Long getRotationTypeId() {
		return rotationTypeId;
	}

	public void setRotationTypeId(Long rotationTypeId) {
		this.rotationTypeId = rotationTypeId;
	}

	public Integer getNoOfBlock() {
		return noOfBlock;
	}

	public void setNoOfBlock(Integer noOfBlock) {
		this.noOfBlock = noOfBlock;
	}

	@Override
	public String toString() {
		return "ValidateRotationDTO [rotationId=" + rotationId + ", rotationTypeId=" + rotationTypeId + ", noOfBlock="
				+ noOfBlock + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noOfBlock == null) ? 0 : noOfBlock.hashCode());
		result = prime * result + ((rotationId == null) ? 0 : rotationId.hashCode());
		result = prime * result + ((rotationTypeId == null) ? 0 : rotationTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidateRotationDTO other = (ValidateRotationDTO) obj;
		if (noOfBlock == null) {
			if (other.noOfBlock != null)
				return false;
		} else if (!noOfBlock.equals(other.noOfBlock))
			return false;
		if (rotationId == null) {
			if (other.rotationId != null)
				return false;
		} else if (!rotationId.equals(other.rotationId))
			return false;
		if (rotationTypeId == null) {
			if (other.rotationTypeId != null)
				return false;
		} else if (!rotationTypeId.equals(other.rotationTypeId))
			return false;
		return true;
	}
	
}
