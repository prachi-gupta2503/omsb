package gov.omsb.exam.web.portlet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamPayment {
	private long id;
	private long applicantId;
	private long scheduleId;
	private long registrationId;
	private String paymentStatus;
	private String orderId;
	private long tId;
	private String trackingId;
	private String feesType;
	private double fees;
	private String currency;

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getFeesType() {
		return feesType;
	}

	public void setFeesType(String feesType) {
		this.feesType = feesType;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExamPayment [id=");
		builder.append(id);
		builder.append(", applicantId=");
		builder.append(applicantId);
		builder.append(", scheduleId=");
		builder.append(scheduleId);
		builder.append(", registrationId=");
		builder.append(registrationId);
		builder.append(", paymentStatus=");
		builder.append(paymentStatus);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", tId=");
		builder.append(tId);
		builder.append(", trackingId=");
		builder.append(trackingId);
		builder.append(", feesType=");
		builder.append(feesType);
		builder.append(", fees=");
		builder.append(fees);
		builder.append(", currency=");
		builder.append(currency);
		builder.append("]");
		return builder.toString();
	}

}
