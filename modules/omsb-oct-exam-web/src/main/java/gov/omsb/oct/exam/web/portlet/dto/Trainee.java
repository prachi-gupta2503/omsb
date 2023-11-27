package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trainee {

	private long lrUserId;
	private long programId;
	private long roleId;
	private long functionId;
	private long sectionId;
	private boolean profileVerifiedStatusId;
	private boolean roleVerifiedStatusId;
	private long departmentId;
	private long committeeId;
	private String name;
	private String registrationStatus;
	private long examDefinitionId;
	private long examTypeId;
	private String examTypeName;
	private String programName;
	private OCTExamSchedule octExamSchedule;
	private long registrationId;
	private long scheduleId;

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getFunctionId() {
		return functionId;
	}

	public void setFunctionId(long functionId) {
		this.functionId = functionId;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public boolean getProfileVerifiedStatusId() {
		return profileVerifiedStatusId;
	}

	public void setProfileVerifiedStatusId(boolean profileVerifiedStatusId) {
		this.profileVerifiedStatusId = profileVerifiedStatusId;
	}

	public boolean getRoleVerifiedStatusId() {
		return roleVerifiedStatusId;
	}

	public void setRoleVerifiedStatusId(boolean roleVerifiedStatusId) {
		this.roleVerifiedStatusId = roleVerifiedStatusId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getCommitteeId() {
		return committeeId;
	}

	public void setCommitteeId(long committeeId) {
		this.committeeId = committeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public long getExamDefinitionId() {
		return examDefinitionId;
	}

	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}

	public long getExamTypeId() {
		return examTypeId;
	}

	public void setExamTypeId(long examTypeId) {
		this.examTypeId = examTypeId;
	}

	public String getExamTypeName() {
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public OCTExamSchedule getOctExamSchedule() {
		return octExamSchedule;
	}

	public void setOctExamSchedule(OCTExamSchedule octExamSchedule) {
		this.octExamSchedule = octExamSchedule;
	}

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trainee [lrUserId=");
		builder.append(lrUserId);
		builder.append(", programId=");
		builder.append(programId);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", functionId=");
		builder.append(functionId);
		builder.append(", sectionId=");
		builder.append(sectionId);
		builder.append(", profileVerifiedStatusId=");
		builder.append(profileVerifiedStatusId);
		builder.append(", roleVerifiedStatusId=");
		builder.append(roleVerifiedStatusId);
		builder.append(", departmentId=");
		builder.append(departmentId);
		builder.append(", committeeId=");
		builder.append(committeeId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", registrationStatus=");
		builder.append(registrationStatus);
		builder.append(", examDefinitionId=");
		builder.append(examDefinitionId);
		builder.append(", examTypeId=");
		builder.append(examTypeId);
		builder.append(", examTypeName=");
		builder.append(examTypeName);
		builder.append(", programName=");
		builder.append(programName);
		builder.append(", octExamSchedule=");
		builder.append(octExamSchedule);
		builder.append("]");
		return builder.toString();
	}

}
