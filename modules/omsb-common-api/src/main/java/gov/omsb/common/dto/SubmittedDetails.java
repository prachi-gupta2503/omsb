package gov.omsb.common.dto;

import java.util.ArrayList;
import java.util.List;

public class SubmittedDetails {
	
	private List<EducationDetail> educationDetail = new ArrayList<>();
    private List<EmploymentDetail> employmentDetail = new ArrayList<>();
    private List<HealthLicenceDetail> healthLicenceDetail = new ArrayList<>();
    private ReferencialDetail referencialDetail;
    private List<Database> database = new ArrayList<>();
    
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
    
}
