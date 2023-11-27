package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTRescheduleFees {
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

	public long getOctExamDefinitionId() {
		return octExamDefinitionId;
	}

	public void setOctExamDefinitionId(long octExamDefinitionId) {
		this.octExamDefinitionId = octExamDefinitionId;
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

}
