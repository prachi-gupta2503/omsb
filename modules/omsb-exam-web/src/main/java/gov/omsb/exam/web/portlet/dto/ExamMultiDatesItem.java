package gov.omsb.exam.web.portlet.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExamMultiDatesItem {

	@Override
	public String toString() {
		return "ExamMultiDatesItem [items=" + items + "]";
	}

	private List<ExamMultiDates> items;

	public List<ExamMultiDates> getItems() {
		return items;
	}
	public void setItems(List<ExamMultiDates> items) {
		this.items = items;
	}
	
	public void sortByIdInReverseOrder() {
		Collections.sort(items, Comparator.comparingLong(ExamMultiDates::getId).reversed());
	}
}