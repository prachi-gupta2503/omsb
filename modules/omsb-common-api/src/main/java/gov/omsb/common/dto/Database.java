package gov.omsb.common.dto;

import java.util.List;

public class Database {
	private String givenNameAsPerPassport;
    private String passportNumber;
    private String dateOfBirth;
    private String nationality;
    private List<FileUploadDetail> fileUploadDetails;
	public String getGivenNameAsPerPassport() {
		return givenNameAsPerPassport;
	}
	public void setGivenNameAsPerPassport(String givenNameAsPerPassport) {
		this.givenNameAsPerPassport = givenNameAsPerPassport;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public List<FileUploadDetail> getFileUploadDetails() {
		return fileUploadDetails;
	}
	public void setFileUploadDetails(List<FileUploadDetail> fileUploadDetails) {
		this.fileUploadDetails = fileUploadDetails;
	}
    
    
}
