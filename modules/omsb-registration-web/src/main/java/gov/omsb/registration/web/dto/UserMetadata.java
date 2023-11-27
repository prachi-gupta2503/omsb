package gov.omsb.registration.web.dto;

public class UserMetadata {

	private long id;
	private String committeeId;
	private String departmentId;
	private String functionId;
	private String programPositionId;
	private String purposeId;
	private long lrUserId;
	private long roleId;
	private long programId;
	private String sectionId;
	private boolean roleVerifiedStatusId;
	private boolean profileVerifiedStatusId;
	private boolean associated;
	private boolean registeringForRole;
	
	private String roleName;
	private String programName;
	private String service;
	private long programTypeId;
	private String programTypeName;
	private boolean roleRequestedByAdmin;
	
	private String roleVerifiedStatus;
	private String roleVerifiedComments;
	
	private long userRoleStatusId;
	
	public String getProgramTypeName() {
		return programTypeName;
	}
	public void setProgramTypeName(String programTypeName) {
		this.programTypeName = programTypeName;
	}
	public long getProgramTypeId() {
		return programTypeId;
	}
	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public boolean isRegisteringForRole() {
		return registeringForRole;
	}
	public void setRegisteringForRole(boolean registeringForRole) {
		this.registeringForRole = registeringForRole;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommitteeId() {
		return committeeId;
	}
	public void setCommitteeId(String committeeId) {
		this.committeeId = committeeId;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getProgramId() {
		return programId;
	}
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public boolean isRoleVerifiedStatusId() {
		return roleVerifiedStatusId;
	}
	public void setRoleVerifiedStatusId(boolean roleVerifiedStatusId) {
		this.roleVerifiedStatusId = roleVerifiedStatusId;
	}
	public boolean isProfileVerifiedStatusId() {
		return profileVerifiedStatusId;
	}
	public void setProfileVerifiedStatusId(boolean profileVerifiedStatusId) {
		this.profileVerifiedStatusId = profileVerifiedStatusId;
	}
	public boolean isAssociated() {
		return associated;
	}
	public void setAssociated(boolean associated) {
		this.associated = associated;
	}
	public boolean isRoleRequestedByAdmin() {
		return roleRequestedByAdmin;
	}
	public void setRoleRequestedByAdmin(boolean roleRequestedByAdmin) {
		this.roleRequestedByAdmin = roleRequestedByAdmin;
	}
	public String getProgramPositionId() {
		return programPositionId;
	}
	public void setProgramPositionId(String programPositionId) {
		this.programPositionId = programPositionId;
	}
	public String getPurposeId() {
		return purposeId;
	}
	public void setPurposeId(String purposeId) {
		this.purposeId = purposeId;
	}
	public String getRoleVerifiedStatus() {
		return roleVerifiedStatus;
	}
	public void setRoleVerifiedStatus(String roleVerifiedStatus) {
		this.roleVerifiedStatus = roleVerifiedStatus;
	}
	public String getRoleVerifiedComments() {
		return roleVerifiedComments;
	}
	public void setRoleVerifiedComments(String roleVerifiedComments) {
		this.roleVerifiedComments = roleVerifiedComments;
	}
	public long getUserRoleStatusId() {
		return userRoleStatusId;
	}
	public void setUserRoleStatusId(long userRoleStatusId) {
		this.userRoleStatusId = userRoleStatusId;
	}
	
	
	
}