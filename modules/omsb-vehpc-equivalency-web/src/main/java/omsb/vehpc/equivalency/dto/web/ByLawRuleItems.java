package omsb.vehpc.equivalency.dto.web;

import java.util.List;
public class ByLawRuleItems {
	private List<ByLawRule> items;

	public List<ByLawRule> getItems() {
		return items;
	}

	public void setItems(List<ByLawRule> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ByLawRuleItems [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
}