package gov.omsb.master.web.portlet.dto;

public class OmsbProfessionSpeciality {
	
	private long id;
	private long profession;
	private long speciality;
	private String professionName;
	private String specialityName;
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
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getSpecialityName() {
		return specialityName;
	}
	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}
	
	

}
