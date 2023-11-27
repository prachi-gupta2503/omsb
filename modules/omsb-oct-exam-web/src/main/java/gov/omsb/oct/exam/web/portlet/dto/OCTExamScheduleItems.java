package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamScheduleItems {

	List<OCTExamSchedule> items;

	@Override
	public String toString() {
		return "OCTExamScheduleItems [items=" + items + "]";
	}

	public List<OCTExamSchedule> getItems() {
		return items;
	}

	public void setItems(List<OCTExamSchedule> items) {
		this.items = items;
	}

}
