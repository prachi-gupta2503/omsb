package gov.omsb.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamPaymentItems {
	
	List<ExamPayment> items;

	public List<ExamPayment> getItems() {
		return items;
	}

	public void setItems(List<ExamPayment> items) {
		this.items = items;
	}
}
