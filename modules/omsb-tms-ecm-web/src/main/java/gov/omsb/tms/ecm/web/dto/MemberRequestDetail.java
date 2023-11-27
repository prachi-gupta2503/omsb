package gov.omsb.tms.ecm.web.dto;

import java.util.List;

import gov.omsb.tms.custom.dto.ECMembershipRequestListDTO;

/**
 * @author Jitendra
 *
 */
public class MemberRequestDetail {

	private String program;
	private String potentialECMember;
	private String role;
	private String status;
	private long ecMemberRequestId;
	private long bankDetailsId;
	private long passportCopyId;
	private long nationalIdCopyId;
	private String statusCode;
	private long stateId;
	private List<ActionDetail> actionList;
	private long workflowTaskId;
	private List<String> transitionNames;
	private List<String> transitionLevels;
	private long workflowInstanceId;

	public MemberRequestDetail() {	
	}
	
	public MemberRequestDetail(ECMembershipRequestListDTO requestListDTO){
		program = requestListDTO.getProgram();
		potentialECMember = requestListDTO.getPotentialECMember();
		role = requestListDTO.getRole();
		status = requestListDTO.getStatus();
		ecMemberRequestId = requestListDTO.getEcMemberRequestId();
		bankDetailsId = requestListDTO.getBankDetailsId();
		passportCopyId = requestListDTO.getPassportCopyId();
		nationalIdCopyId = requestListDTO.getPassportCopyId();
		statusCode = requestListDTO.getStatusCode();
		stateId = requestListDTO.getStateId();
	}
	
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getPotentialECMember() {
		return potentialECMember;
	}
	public void setPotentialECMember(String potentialECMember) {
		this.potentialECMember = potentialECMember;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getEcMemberRequestId() {
		return ecMemberRequestId;
	}
	public void setEcMemberRequestId(long ecMemberRequestId) {
		this.ecMemberRequestId = ecMemberRequestId;
	}
	
	public long getBankDetailsId() {
		return bankDetailsId;
	}

	public void setBankDetailsId(long bankDetailsId) {
		this.bankDetailsId = bankDetailsId;
	}

	public long getPassportCopyId() {
		return passportCopyId;
	}

	public void setPassportCopyId(long passportCopyId) {
		this.passportCopyId = passportCopyId;
	}

	public long getNationalIdCopyId() {
		return nationalIdCopyId;
	}

	public void setNationalIdCopyId(long nationalIdCopyId) {
		this.nationalIdCopyId = nationalIdCopyId;
	}
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public List<ActionDetail> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionDetail> actionList) {
		this.actionList = actionList;
	}
	
	public long getWorkflowTaskId() {
		return workflowTaskId;
	}

	public void setWorkflowTaskId(long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}

	public List<String> getTransitionNames() {
		return transitionNames;
	}

	public void setTransitionNames(List<String> transitionNames) {
		this.transitionNames = transitionNames;
	}

	

	public List<String> getTransitionLevels() {
		return transitionLevels;
	}

	public void setTransitionLevels(List<String> transitionLevels) {
		this.transitionLevels = transitionLevels;
	}

	public long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public void setWorkflowInstanceId(long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	
	
	public String getTransitionList() {
		if(transitionNames != null && transitionNames.size()>0) {
			return String.join(",", transitionNames); 
		}
		return "";
	}
	
	public String getTransitionLevelsList() {
		if(transitionLevels != null && transitionLevels.size()>0) {
			return String.join(",", transitionLevels); 
		}
		return "";
	}

	@Override
	public String toString() {
		return "MemberRequestDetail [program=" + program + ", potentialECMember=" + potentialECMember + ", role=" + role
				+ ", status=" + status + ", ecMemberRequestId=" + ecMemberRequestId + ", bankDetailsId=" + bankDetailsId
				+ ", passportCopyId=" + passportCopyId + ", nationalIdCopyId=" + nationalIdCopyId + ", statusCode="
				+ statusCode + ", stateId=" + stateId + ", actionList=" + actionList + ", workflowTaskId="
				+ workflowTaskId + ", transitionNames=" + transitionNames + ", transitionLevels=" + transitionLevels
				+ ", workflowInstanceId=" + workflowInstanceId + "]";
	}

}
