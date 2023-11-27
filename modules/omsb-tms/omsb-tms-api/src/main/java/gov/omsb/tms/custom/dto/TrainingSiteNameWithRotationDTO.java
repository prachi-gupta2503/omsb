package gov.omsb.tms.custom.dto;

public class TrainingSiteNameWithRotationDTO {

	private String training_site_name;
	private String rotation_name;
	public TrainingSiteNameWithRotationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainingSiteNameWithRotationDTO(String training_site_name, String rotation_name) {
		super();
		this.training_site_name = training_site_name;
		this.rotation_name = rotation_name;
	}
	public String getTraining_site_name() {
		return training_site_name;
	}
	public void setTraining_site_name(String training_site_name) {
		this.training_site_name = training_site_name;
	}
	public String getRotation_name() {
		return rotation_name;
	}
	public void setRotation_name(String rotation_name) {
		this.rotation_name = rotation_name;
	}
	@Override
	public String toString() {
		return "TrainingSiteNameWithRotationDTO [training_site_name=" + training_site_name + ", rotation_name="
				+ rotation_name + "]";
	}
	
}
