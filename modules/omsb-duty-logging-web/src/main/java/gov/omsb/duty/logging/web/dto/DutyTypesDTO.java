package gov.omsb.duty.logging.web.dto;

public class DutyTypesDTO {

	private long dutyTypeId;
	private String createdBy;
	private String dutyType;
	public long getDutyTypeId() {
		return dutyTypeId;
	}
	public void setDutyTypeId(long dutyTypeId) {
		this.dutyTypeId = dutyTypeId;
	}
	public String getDutyType() {
		return dutyType;
	}
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
}
