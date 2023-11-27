package gov.omsb.oct.exam.web.portlet.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RegistrationItem {
	private List<Registration> items;

	public List<Registration> getItems() {
		return items;
	}

	public void setItems(List<Registration> items) {
		this.items = items;
	}
	public void sortByIdInReverseOrder() {
		Collections.sort(items, Comparator.comparingLong(Registration::getId).reversed());
	}


}