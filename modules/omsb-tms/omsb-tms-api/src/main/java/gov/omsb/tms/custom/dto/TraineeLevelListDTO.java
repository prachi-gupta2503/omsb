package gov.omsb.tms.custom.dto;

public class TraineeLevelListDTO {

	private long traineeLevelId;
	private String traineeLevelName;

	public TraineeLevelListDTO() {
		super();
	}

	public long getTraineeLevelId() {
		return traineeLevelId;
	}

	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}

	public String getTraineeLevelName() {
		return traineeLevelName;
	}

	public void setTraineeLevelName(String traineeLevelName) {
		this.traineeLevelName = traineeLevelName;
	}

	@Override
	public String toString() {
		return "TraineeLevelListDTO [traineeLevelId=" + traineeLevelId + ", traineeLevelName=" + traineeLevelName + "]";
	}

}
