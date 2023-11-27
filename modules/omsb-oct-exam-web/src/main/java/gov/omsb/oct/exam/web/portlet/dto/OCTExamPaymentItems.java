package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamPaymentItems {
	
	List<OCTExamPayment> items;

	public List<OCTExamPayment> getItems() {
		return items;
	}

	public void setItems(List<OCTExamPayment> items) {
		this.items = items;
	}
}
