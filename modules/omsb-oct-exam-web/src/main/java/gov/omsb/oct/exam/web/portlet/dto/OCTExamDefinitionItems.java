package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamDefinitionItems {

	List<OCTExamDefinition> items;

	public List<OCTExamDefinition> getItems() {
		return items;
	}

	public void setItems(List<OCTExamDefinition> items) {
		this.items = items;
	}

}
