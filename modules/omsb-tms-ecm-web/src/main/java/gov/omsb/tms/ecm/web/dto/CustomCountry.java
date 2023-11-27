package gov.omsb.tms.ecm.web.dto;
import java.util.ArrayList;
import java.util.List;

public class CustomCountry {

	private List<CustomCountryItems> items;

	public List<CustomCountryItems> getItems() {
		return items;
	}

	public void setItems(List<CustomCountryItems> items) {
		this.items = items;
	}
}
