package gov.omsb.tms.custom.dto;

public class FacultySiteCompensationDTO {

	private String firstName;
	private String middleName;
	private String lastName;
	private long amountInOmr;
	private String nameEn;
	private String nameAr;
	private String rotationName;
	private String trainingSiteName;
	private String trainingSiteCode;
	private long userId;
	private String roleName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getRotationName() {
		return rotationName;
	}
	public void setRotationName(String rotationName) {
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
		return "FacultySiteCompensationDTO [firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", amountInOmr=" + amountInOmr + ", nameEn=" + nameEn + ", nameAr=" + nameAr
				+ ", rotationName=" + rotationName + ", trainingSiteName=" + trainingSiteName + ", trainingSiteCode="
				+ trainingSiteCode + ", userId=" + userId + ", roleName=" + roleName + "]";
	}
	
	
	
}
