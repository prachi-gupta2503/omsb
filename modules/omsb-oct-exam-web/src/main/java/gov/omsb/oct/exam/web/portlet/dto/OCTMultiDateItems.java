package gov.omsb.oct.exam.web.portlet.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OCTMultiDateItems {
	
	@Override
	public String toString() {
		return "OCTMultiDateItems [items=" + items + "]";
	}

	private List<OCTExamMultiDates> items;

	public List<OCTExamMultiDates> getItems() {
		return items;
	}

	public void setItems(List<OCTExamMultiDates> items) {
		this.items = items;
	}
	public void sortByIdInReverseOrder() {
		Collections.sort(items, Comparator.comparingLong(OCTExamMultiDates::getId).reversed());
	}
	
}
