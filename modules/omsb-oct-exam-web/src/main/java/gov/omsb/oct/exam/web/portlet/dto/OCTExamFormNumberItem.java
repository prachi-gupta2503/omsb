package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamFormNumberItem {
	private List<OCTExamFormNumber> items;

	public List<OCTExamFormNumber> getItems() {
		return items;
	}

	public void setItems(List<OCTExamFormNumber> items) {
		this.items = items;
	}

}
