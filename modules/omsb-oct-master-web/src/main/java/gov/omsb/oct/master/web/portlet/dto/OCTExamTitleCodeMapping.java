package gov.omsb.oct.master.web.portlet.dto;

public class OCTExamTitleCodeMapping {

	private long id;
	private String code;
	private long picklistId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getPicklistId() {
		return picklistId;
	}

	public void setPicklistId(long picklistId) {
		this.picklistId = picklistId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
