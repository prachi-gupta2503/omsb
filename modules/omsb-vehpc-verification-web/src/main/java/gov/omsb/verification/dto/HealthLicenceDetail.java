package gov.omsb.verification.dto;

import java.util.List;

public class HealthLicenceDetail {
	
	private List<HealthLicenceDetailItem> items;
	
	
	public List<HealthLicenceDetailItem> getItems() {
		return items;
	}
	public void setItems(List<HealthLicenceDetailItem> items) {
		this.items = items;
	}
}
