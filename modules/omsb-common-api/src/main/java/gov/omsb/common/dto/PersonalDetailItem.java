package gov.omsb.common.dto;

import java.util.List;

public class PersonalDetailItem {
	private List<PersonalDetail> items;

	public List<PersonalDetail> getItems() {
		return items;
	}

	public void setItems(List<PersonalDetail> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonalDetailItem [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

}
