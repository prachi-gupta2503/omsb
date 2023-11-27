package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class CaseReportItems {
	List<CaseReport> items;

	public List<CaseReport> getItems() {
		return items;
	}

	public void setItems(List<CaseReport> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CaseReportItems [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
}
