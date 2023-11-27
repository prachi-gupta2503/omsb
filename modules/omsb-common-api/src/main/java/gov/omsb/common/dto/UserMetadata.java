package gov.omsb.common.dto;

public class UserMetadata {

	private long id;
	private long lrUserId;
	private long programId;
	private long roleId;
	private String departmentId;
	private String sectionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLrUserId() {
		return lrUserId;
	}

	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
