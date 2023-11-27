package gov.omsb.faculty.site.compensation.report.web.dto;

import java.util.List;

public class FacultySiteCompensationListDTO {

	private String fullName;
	private long amountInOmr;
	private String nameEn;
	private String nameAr;
	private List<String> rotationName;
	private String trainingSiteName;
	private String trainingSiteCode;
	private long userId;
	private String roleName;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public long getAmountInOmr() {
		return amountInOmr;
	}
	public void setAmountInOmr(long amountInOmr) {
		this.amountInOmr = amountInOmr;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameAr() {
		return nameAr;
	}
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}
	public List<String> getRotationName() {
		return rotationName;
	}
	public void setRotationName(List<String> rotationName) {
		this.rotationName = rotationName;
	}
	public String getTrainingSiteName() {
		return trainingSiteName;
	}
	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}
	public String getTrainingSiteCode() {
		return trainingSiteCode;
	}
	public void setTrainingSiteCode(String trainingSiteCode) {
		this.trainingSiteCode = trainingSiteCode;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "FacultySiteCompensationListDTO [fullName=" + fullName + ", amountInOmr=" + amountInOmr + ", nameEn="
				+ nameEn + ", nameAr=" + nameAr + ", rotationName=" + rotationName + ", trainingSiteName="
				+ trainingSiteName + ", trainingSiteCode=" + trainingSiteCode + ", userId=" + userId + ", roleName="
				+ roleName + "]";
	}

	
	
	
}
