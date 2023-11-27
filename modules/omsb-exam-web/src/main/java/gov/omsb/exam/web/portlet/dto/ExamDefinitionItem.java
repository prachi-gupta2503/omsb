package gov.omsb.exam.web.portlet.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExamDefinitionItem {
	private List<ExamDefinition> items;

	public List<ExamDefinition> getItems() {
		return items;
	}

	public void setItems(List<ExamDefinition> items) {
		this.items = items;
	}

	public void sortByIdInReverseOrder() {
		Collections.sort(items, Comparator.comparingLong(ExamDefinition::getId).reversed());
	}

}
