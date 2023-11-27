package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamCancellationFees {

	private long id;
	private String noOfDays;
	private String noOfDaysText;
	private float cancellationFeesPercentage;
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

	public float getCancellationFeesPercentage() {
		return cancellationFeesPercentage;
	}

	public void setCancellationFeesPercentage(float cancellationFeesPercentage) {
		this.cancellationFeesPercentage = cancellationFeesPercentage;
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
		builder.append("CancellationFees [id=");
		builder.append(id);
		builder.append(", noOfDays=");
		builder.append(noOfDays);
		builder.append(", cancellationFeesPercentage=");
		builder.append(cancellationFeesPercentage);
		builder.append(", octExamDefinitionId=");
		builder.append(octExamDefinitionId);
		builder.append("]");
		return builder.toString();
	}

}
