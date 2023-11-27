package gov.omsb.common.dto;

import java.util.ArrayList;
import java.util.List;

public class DataflowCaseDetail {
	
	private Payload payload;
    
	public Payload getPayload() {
        return payload;
    }
    public void setPayload(Payload payload) {
        this.payload = payload;
    }
	public class Payload {
		public Payload() {
			super();
		}
	    private List<EducationDetail> educationDetail = new ArrayList<>();
	    private List<Database> database = new ArrayList<>();
	    private PersonalDetail personalDetail;
	    private List<EmploymentDetail> employmentDetail = new ArrayList<>();
	    private List<HealthLicenceDetail> healthLicenceDetail = new ArrayList<>();
	    private ReferencialDetail referencialDetail;
	    private CaseStage caseStage;
	    private CaseStatus caseStatus;
	    private String isReportAvailable;
	    private PaymentDetail paymentDetail;
	    private SubmittedDetails submittedDetails;
	    
	    
		public List<Database> getDatabase() {
			return database;
		}

		public void setDatabase(List<Database> database) {
			this.database = database;
		}

		public List<EducationDetail> getEducationDetail() {
			return educationDetail;
		}

		public void setEducationDetail(List<EducationDetail> educationDetail) {
			this.educationDetail = educationDetail;
		}

		public PersonalDetail getPersonalDetail() {
			return personalDetail;
		}

		public void setPersonalDetail(PersonalDetail personalDetail) {
			this.personalDetail = personalDetail;
		}

		public List<EmploymentDetail> getEmploymentDetail() {
			return employmentDetail;
		}

		public void setEmploymentDetail(List<EmploymentDetail> employmentDetail) {
			this.employmentDetail = employmentDetail;
		}

		public List<HealthLicenceDetail> getHealthLicenceDetail() {
			return healthLicenceDetail;
		}

		public void setHealthLicenceDetail(List<HealthLicenceDetail> healthLicenceDetail) {
			this.healthLicenceDetail = healthLicenceDetail;
		}

		public ReferencialDetail getReferencialDetail() {
			return referencialDetail;
		}

		public void setReferencialDetail(ReferencialDetail referencialDetail) {
			this.referencialDetail = referencialDetail;
		}

		
		 public CaseStage getCaseStage() { 
			 return caseStage; 
		 }
		  
		 public void setCaseStage(CaseStage caseStage) { this.caseStage = caseStage; }
		  
		 public CaseStatus getCaseStatus() { 
			 return caseStatus;
		 }
		 public void setCaseStatus(CaseStatus caseStatus) {
			 this.caseStatus = caseStatus; 
	     }
		 

		public String getIsReportAvailable() {
			return isReportAvailable;
		}

		public void setIsReportAvailable(String isReportAvailable) {
			this.isReportAvailable = isReportAvailable;
		}

		
		public PaymentDetail getPaymentDetail() {
			return paymentDetail;
		}

		public void setPaymentDetail(PaymentDetail paymentDetail) {
			this.paymentDetail = paymentDetail;
		}

		public SubmittedDetails getSubmittedDetails() {
			return submittedDetails;
		}

		public void setSubmittedDetails(SubmittedDetails submittedDetails) {
			this.submittedDetails = submittedDetails;
		}
		
	}
}
