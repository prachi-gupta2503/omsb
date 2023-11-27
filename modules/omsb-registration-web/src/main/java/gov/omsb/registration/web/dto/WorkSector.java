package gov.omsb.registration.web.dto;

public class WorkSector {

	private long id;
	private String workSectorType;
	private long workSectorParentId;
	private String wilayatId;
	private String workSector;
	private long workSectorId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWorkSectorType() {
		return workSectorType;
	}
	public void setWorkSectorType(String workSectorType) {
		this.workSectorType = workSectorType;
	}
	public long getWorkSectorParentId() {
		return workSectorParentId;
	}
	public void setWorkSectorParentId(long workSectorParentId) {
		this.workSectorParentId = workSectorParentId;
	}
	public String getWilayatId() {
		return wilayatId;
	}
	public void setWilayatId(String wilayatId) {
		this.wilayatId = wilayatId;
	}
	public String getWorkSector() {
		return workSector;
	}
	public void setWorkSector(String workSector) {
		this.workSector = workSector;
	}
	public long getWorkSectorId() {
		return workSectorId;
	}
	public void setWorkSectorId(long workSectorId) {
		this.workSectorId = workSectorId;
	}	
}