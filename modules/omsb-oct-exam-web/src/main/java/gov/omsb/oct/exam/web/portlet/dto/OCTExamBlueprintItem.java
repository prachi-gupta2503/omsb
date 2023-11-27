package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamBlueprintItem {

	private List<OCTExamBlueprint> items;

	public List<OCTExamBlueprint> getItems() {
		return items;
	}

	public void setItems(List<OCTExamBlueprint> items) {
		this.items = items;
	}

}
