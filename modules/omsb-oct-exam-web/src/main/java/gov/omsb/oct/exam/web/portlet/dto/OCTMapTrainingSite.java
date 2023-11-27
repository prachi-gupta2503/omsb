package gov.omsb.oct.exam.web.portlet.dto;

public class OCTMapTrainingSite {
	
	private long id;
	private String examDuration;
	private long octTrainingSiteId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExamDuration() {
		return examDuration;
	}
	public void setExamDuration(String examDuration) {
		this.examDuration = examDuration;
	}
	public long getOctTrainingSiteId() {
		return octTrainingSiteId;
	}
	public void setOctTrainingSiteId(long octTrainingSiteId) {
		this.octTrainingSiteId = octTrainingSiteId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTMapTrainingSite [id=");
		builder.append(id);
		builder.append(", examDuration=");
		builder.append(examDuration);
		builder.append(", octTrainingSiteId=");
		builder.append(octTrainingSiteId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
