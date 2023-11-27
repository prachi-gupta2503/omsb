package gov.omsb.registration.web.dto;

import java.util.List;

public class UserVerificationItems {

	private List<UserVerification> items;

	public List<UserVerification> getItems() {
		return items;
	}
	public void setItems(List<UserVerification> items) {
		this.items = items;
	}
}