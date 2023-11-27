package gov.omsb.oct.master.web.portlet.dto;

public class OCTTrainingSlotMaster {

	private long id;
	private String timeSlot;
	private long trainingSiteId;
	private String trainingSiteIdName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public long getTrainingSiteId() {
		return trainingSiteId;
	}
	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}
	
	public String getTrainingSiteIdName() {
		return trainingSiteIdName;
	}
	public void setTrainingSiteIdName(String trainingSiteIdName) {
		this.trainingSiteIdName = trainingSiteIdName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTTrainingSlotMaster [id=");
		builder.append(id);
		builder.append(", timeSlot=");
		builder.append(timeSlot);
		builder.append(", trainingSiteId=");
		builder.append(trainingSiteId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
