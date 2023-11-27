package gov.omsb.oct.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OCTExamTitle {

	private long picklistId;
	private String code;

	public long getPicklistId() {
		return picklistId;
	}

	public void setPicklistId(long picklistId) {
		this.picklistId = picklistId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
