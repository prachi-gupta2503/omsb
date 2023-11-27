package gov.omsb.common.dto;

public class Country {
	private long id;
	private String nationality;
	private long dFCountryID;
	private long countryID;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public long getdFCountryID() {
		return dFCountryID;
	}
	public void setdFCountryID(long dFCountryID) {
		this.dFCountryID = dFCountryID;
	}
	public long getCountryID() {
		return countryID;
	}
	public void setCountryID(long countryID) {
		this.countryID = countryID;
	}
	
}
