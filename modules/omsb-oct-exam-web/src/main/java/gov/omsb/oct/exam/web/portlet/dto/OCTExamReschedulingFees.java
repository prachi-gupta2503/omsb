package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OCTExamReschedulingFees {

	private long id;
	private String noOfDays;
	private String noOfDaysText;
	private float reschedulingFeesPercentage;
	@JsonProperty("ocExamDefinitionId")
	private long octExamDefinitionId;

	
	public String getNoOfDaysText() {
		return noOfDaysText;
	}

	public void setNoOfDaysText(String noOfDaysText) {
		this.noOfDaysText = noOfDaysText;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}


	public float getReschedulingFeesPercentage() {
		return reschedulingFeesPercentage;
	}

	public void setReschedulingFeesPercentage(float reschedulingFeesPercentage) {
		this.reschedulingFeesPercentage = reschedulingFeesPercentage;
	}

	public long getOctExamDefinitionId() {
		return octExamDefinitionId;
	}

	public void setOctExamDefinitionId(long octExamDefinitionId) {
		this.octExamDefinitionId = octExamDefinitionId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExamReschedulingFees [id=");
		builder.append(id);
		builder.append(", noOfDays=");
		builder.append(noOfDays);
		builder.append(", noOfDaysText=");
		builder.append(noOfDaysText);
		builder.append(", reschedulingFeesPercentage=");
		builder.append(reschedulingFeesPercentage);
		builder.append(", octExamDefinitionId=");
		builder.append(octExamDefinitionId);
		builder.append("]");
		return builder.toString();
	}
	
}
