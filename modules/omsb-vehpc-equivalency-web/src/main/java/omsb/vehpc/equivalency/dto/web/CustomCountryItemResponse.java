package omsb.vehpc.equivalency.dto.web;
import java.util.ArrayList;
import java.util.List;

public class CustomCountryItemResponse {

	private List<CustomCountryItems> items = new ArrayList<>();

	public List<CustomCountryItems> getItems() {
		return items;
	}

	public void setItems(List<CustomCountryItems> items) {
		this.items = items;
	}
}
