package gov.omsb.tms.ecm.web.dto;

import java.util.ArrayList;
import java.util.List;

import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.model.RotationMaster;

public class ViewEcMemberRequestDTO {

	private long emMemberRequestId;
	private long programId;
	private String programName;
	private long trainingSiteId;
	private String trainingSiteName;
	private long rotationId;
	private String rotationName;
	private String givenNameAsPassport;
	private String personName;
	private long personId;
	private long membershipRoleId;
	private String membershipRoleName;
	private String passportNumber;
	private String civilId;
	private String dateOfBirth;
	private String comment;
	private String cvName;
	private String cvUrl;
	private String nationalIdName;
	private String nationalIdUrl;
	private String passportName;
	private String passportUrl;
	private String qarar;
	private String coveringLetterName;
	private String coveringLetterUrl;
	private String noObjectionLetterName;
	private String noObjectionLetterUrl;
	private String bankName;
	private String accountNo;
	private String bankBranch;
	private String nationalId;
	private String title;
	private String institution;
	private String countryOfInstitution;
	private String gpa;
	private String yearOfGraduation;
	private String qualificationDocumentName;
	private String qualificationDocumentUrl;
	private String latestStatus;
	private List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTOs;
	private List<CommentsSection> commentsSections;
	private CommentsSection latestCommentSection;
	private List<TrainingSiteByPdDTO> trainingSites;
	private List<RotationMaster> rotationMasters;
	private List<Long> selectedRotationMasters;
	private List<EducationalDetailsView> educationalDetailsViewList = new ArrayList<EducationalDetailsView>();
	private String latestStatusCode;
	private String civilCardFrontPhotoUrl;
	private String civilCardBackPhotoUrl;
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getEmMemberRequestId() {
		return emMemberRequestId;
	}
	public void setEmMemberRequestId(long emMemberRequestId) {
		this.emMemberRequestId = emMemberRequestId;
	}
	public long getProgramId() {
		return programId;
	}
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public long getTrainingSiteId() {
		return trainingSiteId;
	}
	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}
	public String getTrainingSiteName() {
		return trainingSiteName;
	}
	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}
	public long getRotationId() {
		return rotationId;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	public String getRotationName() {
		return rotationName;
	}
	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}
	public String getGivenNameAsPassport() {
		return givenNameAsPassport;
	}
	public void setGivenNameAsPassport(String givenNameAsPassport) {
		this.givenNameAsPassport = givenNameAsPassport;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getMembershipRoleId() {
		return membershipRoleId;
	}
	public void setMembershipRoleId(long membershipRoleId) {
		this.membershipRoleId = membershipRoleId;
	}
	public String getMembershipRoleName() {
		return membershipRoleName;
	}
	public void setMembershipRoleName(String membershipRoleName) {
		this.membershipRoleName = membershipRoleName;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getCivilId() {
		return civilId;
	}
	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCvName() {
		return cvName;
	}
	public void setCvName(String cvName) {
		this.cvName = cvName;
	}
	public String getCvUrl() {
		return cvUrl;
	}
	public void setCvUrl(String cvUrl) {
		this.cvUrl = cvUrl;
	}
	public String getQarar() {
		return qarar;
	}
	public void setQarar(String qarar) {
		this.qarar = qarar;
	}
	public String getCoveringLetterName() {
		return coveringLetterName;
	}
	public void setCoveringLetterName(String coveringLetterName) {
		this.coveringLetterName = coveringLetterName;
	}
	public String getCoveringLetterUrl() {
		return coveringLetterUrl;
	}
	public void setCoveringLetterUrl(String coveringLetterUrl) {
		this.coveringLetterUrl = coveringLetterUrl;
	}
	public String getNoObjectionLetterName() {
		return noObjectionLetterName;
	}
	public void setNoObjectionLetterName(String noObjectionLetterName) {
		this.noObjectionLetterName = noObjectionLetterName;
	}
	public String getNoObjectionLetterUrl() {
		return noObjectionLetterUrl;
	}
	public void setNoObjectionLetterUrl(String noObjectionLetterUrl) {
		this.noObjectionLetterUrl = noObjectionLetterUrl;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getCountryOfInstitution() {
		return countryOfInstitution;
	}
	public void setCountryOfInstitution(String countryOfInstitution) {
		this.countryOfInstitution = countryOfInstitution;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getYearOfGraduation() {
		return yearOfGraduation;
	}
	public void setYearOfGraduation(String yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	public String getQualificationDocumentName() {
		return qualificationDocumentName;
	}
	public void setQualificationDocumentName(String qualificationDocumentName) {
		this.qualificationDocumentName = qualificationDocumentName;
	}
	public String getQualificationDocumentUrl() {
		return qualificationDocumentUrl;
	}
	public void setQualificationDocumentUrl(String qualificationDocumentUrl) {
		this.qualificationDocumentUrl = qualificationDocumentUrl;
	}
	public List<PotentialMemberAffiliationDTO> getPotentialMemberAffiliationDTOs() {
		return potentialMemberAffiliationDTOs;
	}
	public void setPotentialMemberAffiliationDTOs(List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTOs) {
		this.potentialMemberAffiliationDTOs = potentialMemberAffiliationDTOs;
	}
	public String getPassportName() {
		return passportName;
	}
	public void setPassportName(String passportName) {
		this.passportName = passportName;
	}
	public String getPassportUrl() {
		return passportUrl;
	}
	public void setPassportUrl(String passportUrl) {
		this.passportUrl = passportUrl;
	}
	public String getNationalIdName() {
		return nationalIdName;
	}
	public void setNationalIdName(String nationalIdName) {
		this.nationalIdName = nationalIdName;
	}
	public String getNationalIdUrl() {
		return nationalIdUrl;
	}
	public void setNationalIdUrl(String nationalIdUrl) {
		this.nationalIdUrl = nationalIdUrl;
	}
	public List<CommentsSection> getCommentsSections() {
		return commentsSections;
	}
	public void setCommentsSections(List<CommentsSection> commentsSections) {
		this.commentsSections = commentsSections;
	}
	public CommentsSection getLatestCommentSection() {
		return latestCommentSection;
	}
	public void setLatestCommentSection(CommentsSection latestCommentSection) {
		this.latestCommentSection = latestCommentSection;
	}
	public List<TrainingSiteByPdDTO> getTrainingSites() {
		return trainingSites;
	}
	public void setTrainingSites(List<TrainingSiteByPdDTO> trainingSites) {
		this.trainingSites = trainingSites;
	}
	public List<RotationMaster> getRotationMasters() {
		return rotationMasters;
	}
	public void setRotationMasters(List<RotationMaster> rotationMasters) {
		this.rotationMasters = rotationMasters;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLatestStatus() {
		return latestStatus;
	}
	public void setLatestStatus(String latestStatus) {
		this.latestStatus = latestStatus;
	}
	public List<Long> getSelectedRotationMasters() {
		return selectedRotationMasters;
	}
	public void setSelectedRotationMasters(List<Long> selectedRotationMasters) {
		this.selectedRotationMasters = selectedRotationMasters;
	}
	public List<EducationalDetailsView> getEducationalDetailsViewList() {
		return educationalDetailsViewList;
	}
	public void setEducationalDetailsViewList(List<EducationalDetailsView> educationalDetailsViewList) {
		this.educationalDetailsViewList = educationalDetailsViewList;
	}
	public String getLatestStatusCode() {
		return latestStatusCode;
	}
	public void setLatestStatusCode(String latestStatusCode) {
		this.latestStatusCode = latestStatusCode;
	}
	public void addEducationDetailsView(EducationalDetailsView educationalDetailsView){
		educationalDetailsViewList.add(educationalDetailsView);
	}
	
	public String getCivilCardFrontPhotoUrl() {
		return civilCardFrontPhotoUrl;
	}
	public void setCivilCardFrontPhotoUrl(String civilCardFrontPhotoUrl) {
		this.civilCardFrontPhotoUrl = civilCardFrontPhotoUrl;
	}
	public String getCivilCardBackPhotoUrl() {
		return civilCardBackPhotoUrl;
	}
	public void setCivilCardBackPhotoUrl(String civilCardBackPhotoUrl) {
		this.civilCardBackPhotoUrl = civilCardBackPhotoUrl;
	}
	@Override
	public String toString() {
		return "ViewEcMemberRequestDTO [emMemberRequestId=" + emMemberRequestId + ", programId=" + programId
				+ ", programName=" + programName + ", trainingSiteId=" + trainingSiteId + ", trainingSiteName="
				+ trainingSiteName + ", rotationId=" + rotationId + ", rotationName=" + rotationName
				+ ", givenNameAsPassport=" + givenNameAsPassport + ", personName=" + personName + ", personId="
				+ personId + ", membershipRoleId=" + membershipRoleId + ", membershipRoleName=" + membershipRoleName
				+ ", passportNumber=" + passportNumber + ", civilId=" + civilId + ", dateOfBirth=" + dateOfBirth
				+ ", comment=" + comment + ", cvName=" + cvName + ", cvUrl=" + cvUrl + ", nationalIdName="
				+ nationalIdName + ", nationalIdUrl=" + nationalIdUrl + ", passportName=" + passportName
				+ ", passportUrl=" + passportUrl + ", qarar=" + qarar + ", coveringLetterName=" + coveringLetterName
				+ ", coveringLetterUrl=" + coveringLetterUrl + ", noObjectionLetterName=" + noObjectionLetterName
				+ ", noObjectionLetterUrl=" + noObjectionLetterUrl + ", bankName=" + bankName + ", accountNo="
				+ accountNo + ", bankBranch=" + bankBranch + ", nationalId=" + nationalId + ", title=" + title
				+ ", institution=" + institution + ", countryOfInstitution=" + countryOfInstitution + ", gpa=" + gpa
				+ ", yearOfGraduation=" + yearOfGraduation + ", qualificationDocumentName=" + qualificationDocumentName
				+ ", qualificationDocumentUrl=" + qualificationDocumentUrl + ", latestStatus=" + latestStatus
				+ ", potentialMemberAffiliationDTOs=" + potentialMemberAffiliationDTOs + ", commentsSections="
				+ commentsSections + ", latestCommentSection=" + latestCommentSection + ", trainingSites="
				+ trainingSites + ", rotationMasters=" + rotationMasters + ", selectedRotationMasters="
				+ selectedRotationMasters + ", educationalDetailsViewList=" + educationalDetailsViewList
				+ ", latestStatusCode=" + latestStatusCode + ", getPersonName()=" + getPersonName()
				+ ", getEmMemberRequestId()=" + getEmMemberRequestId() + ", getProgramId()=" + getProgramId()
				+ ", getProgramName()=" + getProgramName() + ", getTrainingSiteId()=" + getTrainingSiteId()
				+ ", getTrainingSiteName()=" + getTrainingSiteName() + ", getRotationId()=" + getRotationId()
				+ ", getRotationName()=" + getRotationName() + ", getGivenNameAsPassport()=" + getGivenNameAsPassport()
				+ ", getPersonId()=" + getPersonId() + ", getMembershipRoleId()=" + getMembershipRoleId()
				+ ", getMembershipRoleName()=" + getMembershipRoleName() + ", getPassportNumber()="
				+ getPassportNumber() + ", getCivilId()=" + getCivilId() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getCvName()=" + getCvName() + ", getCvUrl()=" + getCvUrl() + ", getQarar()=" + getQarar()
				+ ", getCoveringLetterName()=" + getCoveringLetterName() + ", getCoveringLetterUrl()="
				+ getCoveringLetterUrl() + ", getNoObjectionLetterName()=" + getNoObjectionLetterName()
				+ ", getNoObjectionLetterUrl()=" + getNoObjectionLetterUrl() + ", getBankName()=" + getBankName()
				+ ", getAccountNo()=" + getAccountNo() + ", getBankBranch()=" + getBankBranch() + ", getNationalId()="
				+ getNationalId() + ", getTitle()=" + getTitle() + ", getInstitution()=" + getInstitution()
				+ ", getCountryOfInstitution()=" + getCountryOfInstitution() + ", getGpa()=" + getGpa()
				+ ", getYearOfGraduation()=" + getYearOfGraduation() + ", getQualificationDocumentName()="
				+ getQualificationDocumentName() + ", getQualificationDocumentUrl()=" + getQualificationDocumentUrl()
				+ ", getPotentialMemberAffiliationDTOs()=" + getPotentialMemberAffiliationDTOs()
				+ ", getPassportName()=" + getPassportName() + ", getPassportUrl()=" + getPassportUrl()
				+ ", getNationalIdName()=" + getNationalIdName() + ", getNationalIdUrl()=" + getNationalIdUrl()
				+ ", getCommentsSections()=" + getCommentsSections() + ", getLatestCommentSection()="
				+ getLatestCommentSection() + ", getTrainingSites()=" + getTrainingSites() + ", getRotationMasters()="
				+ getRotationMasters() + ", getComment()=" + getComment() + ", getLatestStatus()=" + getLatestStatus()
				+ ", getSelectedRotationMasters()=" + getSelectedRotationMasters()
				+ ", getEducationalDetailsViewList()=" + getEducationalDetailsViewList() + ", getLatestStatusCode()="
				+ getLatestStatusCode() + "]";
	}
	
	
	
}
