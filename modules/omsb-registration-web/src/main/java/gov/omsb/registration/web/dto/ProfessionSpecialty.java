package gov.omsb.registration.web.dto;

public class ProfessionSpecialty {
	private long id;
	private long profession;
	private long speciality;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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

}
