package gov.omsb.verification.dto;

import java.util.List;

public class CaseRequest {
	private List<CaseRequestItem> items;
		public List<CaseRequestItem> getItems() {
			return items;
		}
		public void setItems(List<CaseRequestItem> items) {
			this.items = items;
		}
}
