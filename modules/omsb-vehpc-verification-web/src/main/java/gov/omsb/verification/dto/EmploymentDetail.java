package gov.omsb.verification.dto;

import java.util.List;

public class EmploymentDetail {
	
	private List<EmploymentDetailItem> items;
	
	
	public List<EmploymentDetailItem> getItems() {
		return items;
	}
	public void setItems(List<EmploymentDetailItem> items) {
		this.items = items;
	}
}
