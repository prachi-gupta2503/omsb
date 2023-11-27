package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExam {

	private long id;
	private String examJson;
	private boolean modified;

	@JsonProperty("oCExamTitleId")
	private long octExamTitleId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExamJson() {
		return examJson;
	}

	public void setExamJson(String examJson) {
		this.examJson = examJson;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public long getOctExamTitleId() {
		return octExamTitleId;
	}

	public void setOctExamTitleId(long octExamTitleId) {
		this.octExamTitleId = octExamTitleId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExam [id=");
		builder.append(id);
		builder.append(", examJson=");
		builder.append(examJson);
		builder.append(", modified=");
		builder.append(modified);
		builder.append(", octExamTitleId=");
		builder.append(octExamTitleId);
		builder.append("]");
		return builder.toString();
	}

}
