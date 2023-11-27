package gov.omsb.verification.dto;
import java.util.ArrayList;
import java.util.List;

public class CustomCountry {

	private List<CustomCountryItems> items = new ArrayList<>();

	public List<CustomCountryItems> getItems() {
		return items;
	}

	public void setItems(List<CustomCountryItems> items) {
		this.items = items;
	}
}
