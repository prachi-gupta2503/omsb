package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTCancellationFeesItem {

	private List<OCTExamCancellationFees> items;

	public List<OCTExamCancellationFees> getItems() {
		return items;
	}

	public void setItems(List<OCTExamCancellationFees> items) {
		this.items = items;
	}

}
