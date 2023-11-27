package gov.omsb.tms.ecm.web.dto;

import java.util.List;

import gov.omsb.tms.ecm.web.dto.OMSBInstitutionMapping;

public class InstitutionItems {
	private List<OMSBInstitutionMapping> items;

	public List<OMSBInstitutionMapping> getItems() {
		return items;
	}

	public void setItems(List<OMSBInstitutionMapping> items) {
		this.items = items;
	}

}
