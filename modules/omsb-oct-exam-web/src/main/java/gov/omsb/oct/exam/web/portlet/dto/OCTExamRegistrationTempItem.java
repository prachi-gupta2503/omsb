package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamRegistrationTempItem {
	private List<OCTExamRegistrationTemp> items;

	public List<OCTExamRegistrationTemp> getItems() {
		return items;
	}

	public void setItems(List<OCTExamRegistrationTemp> items) {
		this.items = items;
	}
}
