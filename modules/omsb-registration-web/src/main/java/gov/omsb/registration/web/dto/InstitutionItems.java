package gov.omsb.registration.web.dto;

import java.util.List;

public class InstitutionItems {

	private List<OMSBInstitutionMapping> items;

	public List<OMSBInstitutionMapping> getItems() {
		return items;
	}

	public void setItems(List<OMSBInstitutionMapping> items) {
		this.items = items;
	}
}
