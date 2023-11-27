package gov.omsb.master.web.portlet.dto;

import java.util.List;

public class Worksectors {
	
	private long id;
	private String workSector;
	private String workSectorType;
	private String wilayatId;
	private long workSectorParentId;
	private String workSectorParentName;
	
	private List<String> workSectorList;

	
	public String getWorkSectorParentName() {
		return workSectorParentName;
	}
	public void setWorkSectorParentName(String workSectorParentName) {
		this.workSectorParentName = workSectorParentName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWorkSector() {
		return workSector;
	}
	public void setWorkSector(String workSector) {
		this.workSector = workSector;
	}
	
	public String getWorkSectorType() {
		return workSectorType;
	}
	public void setWorkSectorType(String workSectorType) {
		this.workSectorType = workSectorType;
	}
	public String getWilayatId() {
		return wilayatId;
	}
	public void setWilayatId(String wilayatId) {
		this.wilayatId = wilayatId;
	}
	public long getWorkSectorParentId() {
		return workSectorParentId;
	}
	public void setWorkSectorParentId(long workSectorParentId) {
		this.workSectorParentId = workSectorParentId;
	}
	public List<String> getWorkSectorList() {
		return workSectorList;
	}
	public void setWorkSectorList(List<String> workSectorList) {
		this.workSectorList = workSectorList;
	}
	
	

}
