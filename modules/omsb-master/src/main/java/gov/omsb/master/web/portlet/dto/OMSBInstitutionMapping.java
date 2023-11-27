package gov.omsb.master.web.portlet.dto;

public class OMSBInstitutionMapping {

	private long id;
	private long country;
	private long university;
	private String countryName;
	private String universityName;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
	}
	public long getUniversity() {
		return university;
	}
	public void setUniversity(long university) {
		this.university = university;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
}
