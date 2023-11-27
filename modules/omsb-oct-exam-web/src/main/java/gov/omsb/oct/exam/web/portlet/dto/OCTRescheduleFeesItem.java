package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTRescheduleFeesItem {

	private List<OCTRescheduleFees> items;

	public List<OCTRescheduleFees> getItems() {
		return items;
	}

	public void setItems(List<OCTRescheduleFees> items) {
		this.items = items;
	}

}
