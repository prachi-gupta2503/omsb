package gov.omsb.oct.exam.web.portlet.dto;

public class OCTTrainingSite {

	private long id;
	private String trainingSite;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrainingSite() {
		return trainingSite;
	}

	public void setTrainingSite(String trainingSite) {
		this.trainingSite = trainingSite;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTTrainingSite [id=");
		builder.append(id);
		builder.append(", trainingSite=");
		builder.append(trainingSite);
		builder.append("]");
		return builder.toString();
	}

}
