package gov.omsb.tms.custom.dto;

import java.util.Date;

public class DutyTypeDTO {

	private long dutyTypeId;
	private String dutyType;
	private Date startDate;
	private Date endDate;
	
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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

	public DutyTypeDTO(long dutyTypeId, String dutyType) {
		super();
		this.dutyTypeId = dutyTypeId;
		this.dutyType = dutyType;
	}

	public DutyTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
