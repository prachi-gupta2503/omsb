package gov.omsb.oct.exam.web.portlet.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonProperty;

 

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRefundResponse {

 

    @JsonProperty("reason")
    private String reason;

 

    @JsonProperty("error_code")
    private String errorCode;

 

    @JsonProperty("refund_status")
    private String refundStatus;

 

    public String getReason() {

        return reason;

    }

 

    public void setReason(String reason) {

        this.reason = reason;

    }

 

    public String getErrorCode() {

        return errorCode;

    }

 

    public void setErrorCode(String errorCode) {

        this.errorCode = errorCode;

    }

 

    public String getRefundStatus() {

        return refundStatus;

    }

 

    public void setRefundStatus(String refundStatus) {

        this.refundStatus = refundStatus;

    }

 

}
