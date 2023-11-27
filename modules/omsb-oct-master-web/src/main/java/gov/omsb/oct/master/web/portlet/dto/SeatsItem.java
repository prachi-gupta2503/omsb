package gov.omsb.oct.master.web.portlet.dto;

import java.util.List;

public class SeatsItem {
	private List<OCTrainingSiteSeatsMapping> items;

	public List<OCTrainingSiteSeatsMapping> getItems() {
		return items;
	}
	public void setItems(List<OCTrainingSiteSeatsMapping> items) {
		this.items = items;
	}

}
