package gov.omsb.registration.web.dto;

import java.util.List;

public class ServiceVerificationItems {

	private List<ServiceVerification> items;

	public List<ServiceVerification> getItems() {
		return items;
	}
	
	public void setItems(List<ServiceVerification> items) {
		this.items = items;
	}
}