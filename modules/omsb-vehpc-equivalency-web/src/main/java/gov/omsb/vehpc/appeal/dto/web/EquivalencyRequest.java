package gov.omsb.vehpc.appeal.dto.web;

public class EquivalencyRequest {
	 private long id;
	 private long personId ;
	 private long prfessionId;
	 private long eqStatusId;
	 private long employerUserID;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getPrfessionId() {
		return prfessionId;
	}
	public void setPrfessionId(long prfessionId) {
		this.prfessionId = prfessionId;
	}
	public long getEqStatusId() {
		return eqStatusId;
	}
	public void setEqStatusId(long eqStatusId) {
		this.eqStatusId = eqStatusId;
	}
	public long getEmployerUserID() {
		return employerUserID;
	}
	public void setEmployerUserID(long employerUserID) {
		this.employerUserID = employerUserID;
	}
	
	 
}
