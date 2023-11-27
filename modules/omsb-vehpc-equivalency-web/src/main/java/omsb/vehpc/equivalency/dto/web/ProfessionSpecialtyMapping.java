package omsb.vehpc.equivalency.dto.web;

public class ProfessionSpecialtyMapping {
	private long profession;
	private long speciality;
	
	public long getProfession() {
		return profession;
	}
	public void setProfession(long profession) {
		this.profession = profession;
	}
	public long getSpeciality() {
		return speciality;
	}
	public void setSpeciality(long speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfessionSpecialtyMapping [profession=");
		builder.append(profession);
		builder.append(", speciality=");
		builder.append(speciality);
		builder.append("]");
		return builder.toString();
	}
}
