package gov.omsb.master.web.portlet.dto;

public class OMSBSpecialityMapping {

	private long id;
	private long speciality;
	private long subSpeciality;
	private String specialityName;
	private String subSpecialityName;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSpeciality() {
		return speciality;
	}

	public void setSpeciality(long speciality) {
		this.speciality = speciality;
	}

	public long getSubSpeciality() {
		return subSpeciality;
	}

	public void setSubSpeciality(long subSpeciality) {
		this.subSpeciality = subSpeciality;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	public String getSubSpecialityName() {
		return subSpecialityName;
	}

	public void setSubSpecialityName(String subSpecialityName) {
		this.subSpecialityName = subSpecialityName;
	}
	
}
