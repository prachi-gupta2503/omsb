package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamItems {

	private List<OCTExam> items;

	public List<OCTExam> getItems() {
		return items;
	}

	public void setItems(List<OCTExam> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExamItems [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

}
