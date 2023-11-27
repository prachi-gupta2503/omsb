package gov.omsb.verification.dto;

public class CustomCountryItems {
	private long id;
	 private long countryID;
	 private long dFCountryID;
	 private String nationality;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCountryID() {
		return countryID;
	}
	public void setCountryID(long countryID) {
		this.countryID = countryID;
	}
	public long getdFCountryID() {
		return dFCountryID;
	}
	public void setdFCountryID(long dFCountryID) {
		this.dFCountryID = dFCountryID;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
