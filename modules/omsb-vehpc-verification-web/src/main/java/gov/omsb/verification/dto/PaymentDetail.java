package gov.omsb.verification.dto;

import java.util.List;

public class PaymentDetail {
	
	private List<PaymentDetailItem> items;
	
	
	public List<PaymentDetailItem> getItems() {
		return items;
	}
	public void setItems(List<PaymentDetailItem> items) {
		this.items = items;
	}
}
