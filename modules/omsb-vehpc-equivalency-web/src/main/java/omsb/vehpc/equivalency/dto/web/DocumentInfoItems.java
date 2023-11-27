package omsb.vehpc.equivalency.dto.web;

import java.util.ArrayList;
import java.util.List;

public class DocumentInfoItems {
	private List<DocumentInfo> items = new ArrayList<>();

	public List<DocumentInfo> getItems() {
		return items;
	}

	public void setItems(List<DocumentInfo> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentInfoItems [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
