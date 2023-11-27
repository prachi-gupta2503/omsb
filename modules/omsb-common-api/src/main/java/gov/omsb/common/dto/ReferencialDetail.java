package gov.omsb.common.dto;

public class ReferencialDetail {
	private String clientReferenceNumber;
    private String caseNumber;
    private Object parentCaseNumber;
    private String category;
    private String category2;
    private String category3;
    private String category4;
    private Integer caseTypeId;
    private String submittedDate;
    private String dateFormat;
    private String customerName;
    
    public String getClientReferenceNumber() {
		return clientReferenceNumber;
	}
	public void setClientReferenceNumber(String clientReferenceNumber) {
		this.clientReferenceNumber = clientReferenceNumber;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public Object getParentCaseNumber() {
		return parentCaseNumber;
	}
	public void setParentCaseNumber(Object parentCaseNumber) {
		this.parentCaseNumber = parentCaseNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public String getCategory3() {
		return category3;
	}
	public void setCategory3(String category3) {
		this.category3 = category3;
	}
	public String getCategory4() {
		return category4;
	}
	public void setCategory4(String category4) {
		this.category4 = category4;
	}
	public Integer getCaseTypeId() {
		return caseTypeId;
	}
	public void setCaseTypeId(Integer caseTypeId) {
		this.caseTypeId = caseTypeId;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
