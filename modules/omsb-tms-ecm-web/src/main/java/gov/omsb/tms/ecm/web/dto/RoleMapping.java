package gov.omsb.tms.ecm.web.dto;

public class RoleMapping {
	private String roleType;
	private long roleId;
	
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
}
