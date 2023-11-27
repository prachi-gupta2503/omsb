package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTRegularFeesItem {

	private List<OCTRegularFees> items;

	public List<OCTRegularFees> getItems() {
		return items;
	}

	public void setItems(List<OCTRegularFees> items) {
		this.items = items;
	}

}
