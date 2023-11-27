package gov.omsb.vehpc.appeal.dto.web;

import java.util.List;

public class EquivalencyAppealItems {
	private List<EquivalencyAppeal> items;

	

	public List<EquivalencyAppeal> getItems() {
		return items;
	}

	public void setItems(List<EquivalencyAppeal> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyAppealItems [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
	
}
