package gov.omsb.verification.dto;

import java.util.Date;

public class PersonItem {
	private String dateCreated;
    private String dateModified;
    private long id;
    private String passportNumber;
    private String dateOfBirth;
    private int lrUserId;
    private String civilId;
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public int getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(int lrUserId) {
		this.lrUserId = lrUserId;
	}
	public String getCivilId() {
		return civilId;
	}
	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
    
}
