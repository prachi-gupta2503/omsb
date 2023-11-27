package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTRegularFees {

	private long id;
	private int noOfAttempt;
	private float regularFees;
	@JsonProperty("ocExamDefinitionId")
	private long octExamDefinitionId;

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


	public int getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(int noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	public float getRegularFees() {
		return regularFees;
	}

	public void setRegularFees(float regularFees) {
		this.regularFees = regularFees;
	}

}
