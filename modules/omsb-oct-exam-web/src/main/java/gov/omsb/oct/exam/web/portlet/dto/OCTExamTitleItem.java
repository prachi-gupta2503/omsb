package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamTitleItem {
	
	private List<OCTExamTitle> items;

	public List<OCTExamTitle> getItems() {
		return items;
	}

	public void setItems(List<OCTExamTitle> items) {
		this.items = items;
	}
	
}
