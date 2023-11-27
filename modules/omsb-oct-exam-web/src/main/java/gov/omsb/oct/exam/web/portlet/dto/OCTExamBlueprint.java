package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamBlueprint {
	
	private long id;
	private String blueprintTitle;
	@JsonProperty("dlFileEntryId")
	private long dLFileEntry;
	@JsonProperty("oCExamDefinitionId")
	private long octExamDefinitionId;
	private String url;
	private String rowNumber;
	private String name;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
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

	public String getBlueprintTitle() {
		return blueprintTitle;
	}

	public void setBlueprintTitle(String blueprintTitle) {
		this.blueprintTitle = blueprintTitle;
	}

	public long getdLFileEntry() {
		return dLFileEntry;
	}

	public void setdLFileEntry(long dLFileEntry) {
		this.dLFileEntry = dLFileEntry;
	}



	@Override
	public String toString() {
		return "OCTExamBlueprint [id=" + id + ", blueprintTitle=" + blueprintTitle + ", dLFileEntry=" + dLFileEntry
				+ ", octExamDefinitionId=" + octExamDefinitionId + "]";
	}

}
