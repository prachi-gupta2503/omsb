package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class InstitutionMasterItems {
	List<InstitutionMasters> items;

	public List<InstitutionMasters> getItems() {
		return items;
	}

	public void setItems(List<InstitutionMasters> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstitutionMasterItems [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
}
