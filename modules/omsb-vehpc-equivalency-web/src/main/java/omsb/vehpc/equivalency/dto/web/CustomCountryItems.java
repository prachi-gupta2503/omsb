package omsb.vehpc.equivalency.dto.web;

public class CustomCountryItems {
	private long id;
	private long countryId;
	private long dFCountryID;
	private String nationality;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
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
