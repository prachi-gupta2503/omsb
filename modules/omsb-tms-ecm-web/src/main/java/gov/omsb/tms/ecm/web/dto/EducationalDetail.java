package gov.omsb.tms.ecm.web.dto;

import java.util.List;

public class EducationalDetail {
	
	private List<EducationalDetailItem> items;
	
	
	public List<EducationalDetailItem> getItems() {
		return items;
	}
	public void setItems(List<EducationalDetailItem> items) {
		this.items = items;
	}
}
