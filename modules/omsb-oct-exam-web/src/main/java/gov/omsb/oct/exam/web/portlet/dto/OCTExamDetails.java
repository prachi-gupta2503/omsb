package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamDetails {

	private long id;
	private String OCTExamTitle;
	private long oCExamTitleId;
	private OCTExamJsonFields examJson;
	private boolean modified;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OCTExamJsonFields getExamJson() {
		return examJson;
	}

	public void setExamJson(OCTExamJsonFields examJson) {
		this.examJson = examJson;
	}

	public String getOCTExamTitle() {
		return OCTExamTitle;
	}

	public void setOCTExamTitle(String oCTExamTitle) {
		OCTExamTitle = oCTExamTitle;
	}

	public long getoCExamTitleId() {
		return oCExamTitleId;
	}

	public void setoCExamTitleId(long oCExamTitleId) {
		this.oCExamTitleId = oCExamTitleId;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExamDetails [id=");
		builder.append(id);
		builder.append(", OCTExamTitle=");
		builder.append(OCTExamTitle);
		builder.append(", oCExamTitleId=");
		builder.append(oCExamTitleId);
		builder.append(", examJson=");
		builder.append(examJson);
		builder.append(", modified=");
		builder.append(modified);
		builder.append("]");
		return builder.toString();
	}

}
