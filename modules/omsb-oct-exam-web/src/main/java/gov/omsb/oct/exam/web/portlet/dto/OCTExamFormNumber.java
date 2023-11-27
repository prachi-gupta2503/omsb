package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamFormNumber {
	
	private long id;
	@JsonProperty("oCExamDefinitionId")
	private long octExamDefinitionId;
	private String examForm;
	private long examFormStatus;
	private String examFormStatusName;
	
	public String getExamFormStatusName() {
		return examFormStatusName;
	}
	public void setExamFormStatusName(String examFormStatusName) {
		this.examFormStatusName = examFormStatusName;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOctExamDefinitionId() {
		return octExamDefinitionId;
	}

	public void setOctExamDefinitionId(long octExamDefinitionId) {
		this.octExamDefinitionId = octExamDefinitionId;
	}

	public String getExamForm() {
		return examForm;
	}

	public void setExamForm(String examForm) {
		this.examForm = examForm;
	}

	public long getExamFormStatus() {
		return examFormStatus;
	}

	public void setExamFormStatus(long examFormStatus) {
		this.examFormStatus = examFormStatus;
	}

}
