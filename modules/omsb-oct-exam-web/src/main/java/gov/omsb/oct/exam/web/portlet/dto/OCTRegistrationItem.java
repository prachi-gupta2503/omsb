package gov.omsb.oct.exam.web.portlet.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OCTRegistrationItem {
	private List<OCTRegistration> items;

	public List<OCTRegistration> getItems() {
		return items;
	}

	public void setItems(List<OCTRegistration> items) {
		this.items = items;
	}
	public void sortByIdInReverseOrder() {
		Collections.sort(items, Comparator.comparingLong(OCTRegistration::getId).reversed());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTRegistrationItem [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
	
}
