package gov.omsb.registration.web.dto;

public class RoleMapping {
	
	private	long roleId;
	private String roleType;
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}	
}