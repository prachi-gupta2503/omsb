package gov.omsb.registration.web.dto;

public class RoleAndServiceDetails {

	private long roleId;
	private long departmentId;
	private long sectionId;
	private long comitteeId;
	private long functionId;
	private long programTypeId;
	private long programId;
	private boolean isAssociatedWithOMSB;
	private boolean isRegisteringForRole;
	private long serviceId;
	private String role;
	private String department;
	private String section;
	private String comittee;
	private String function;
	private String programType;
	private String program;
	private String service;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public long getComitteeId() {
		return comitteeId;
	}

	public void setComitteeId(long comitteeId) {
		this.comitteeId = comitteeId;
	}

	public long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(long functionId) {
		this.functionId = functionId;
	}

	public long getProgramTypeId() {
		return programTypeId;
	}

	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public boolean isAssociatedWithOMSB() {
		return isAssociatedWithOMSB;
	}

	public void setAssociatedWithOMSB(boolean isAssociatedWithOMSB) {
		this.isAssociatedWithOMSB = isAssociatedWithOMSB;
	}

	public boolean isRegisteringForRole() {
		return isRegisteringForRole;
	}

	public void setRegisteringForRole(boolean isRegisteringForRole) {
		this.isRegisteringForRole = isRegisteringForRole;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getComittee() {
		return comittee;
	}

	public void setComittee(String comittee) {
		this.comittee = comittee;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleAndServiceDetails [roleId=");
		builder.append(roleId);
		builder.append(", departmentId=");
		builder.append(departmentId);
		builder.append(", sectionId=");
		builder.append(sectionId);
		builder.append(", comitteeId=");
		builder.append(comitteeId);
		builder.append(", functionId=");
		builder.append(functionId);
		builder.append(", programTypeId=");
		builder.append(programTypeId);
		builder.append(", programId=");
		builder.append(programId);
		builder.append(", isAssociatedWithOMSB=");
		builder.append(isAssociatedWithOMSB);
		builder.append(", isRegisteringForRole=");
		builder.append(isRegisteringForRole);
		builder.append(", serviceId=");
		builder.append(serviceId);
		builder.append(", role=");
		builder.append(role);
		builder.append(", department=");
		builder.append(department);
		builder.append(", section=");
		builder.append(section);
		builder.append(", comittee=");
		builder.append(comittee);
		builder.append(", function=");
		builder.append(function);
		builder.append(", programType=");
		builder.append(programType);
		builder.append(", program=");
		builder.append(program);
		builder.append(", service=");
		builder.append(service);
		builder.append("]");
		return builder.toString();
	}
}