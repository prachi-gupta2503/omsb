package omsb.vehpc.equivalency.dto.web;

public class InstitutionMasters {
	private long country;
	private long university;
	
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstitutionMasters [country=");
		builder.append(country);
		builder.append(", university=");
		builder.append(university);
		builder.append("]");
		return builder.toString();
	}
	
}
