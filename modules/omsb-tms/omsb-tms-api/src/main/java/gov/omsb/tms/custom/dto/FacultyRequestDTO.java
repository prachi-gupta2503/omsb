package gov.omsb.tms.custom.dto;

public class FacultyRequestDTO {
	private String programName;
	private String trainingSiteName;
	private String rotationName;
	private String potentialFacultyName;
	private String facultyTypeEn;
	private String facultyTypeAr;
	private String faultyRequestStatusEn;
	private String faultyRequestStatusAr;
	private long facultyRequestId;
	private String faultyRequestStatusCode;
	private long passportCopyId;
	private long nationalIdCopyId;
	public long getPassportCopyId() {
		return passportCopyId;
	}

	public void setPassportCopyId(long passportCopyId) {
		this.passportCopyId = passportCopyId;
	}

	public long getNationalIdCopyId() {
		return nationalIdCopyId;
	}

	public void setNationalIdCopyId(long nationalIdCopyId) {
		this.nationalIdCopyId = nationalIdCopyId;
	}

	public String getFaultyRequestStatusCode() {
		return faultyRequestStatusCode;
	}

	public void setFaultyRequestStatusCode(String faultyRequestStatusCode) {
		this.faultyRequestStatusCode = faultyRequestStatusCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public String getPotentialFacultyName() {
		return potentialFacultyName;
	}

	public void setPotentialFacultyName(String potentialFacultyName) {
		this.potentialFacultyName = potentialFacultyName;
	}

	public String getFacultyTypeEn() {
		return facultyTypeEn;
	}

	public void setFacultyTypeEn(String facultyTypeEn) {
		this.facultyTypeEn = facultyTypeEn;
	}

	public String getFacultyTypeAr() {
		return facultyTypeAr;
	}

	public void setFacultyTypeAr(String facultyTypeAr) {
		this.facultyTypeAr = facultyTypeAr;
	}

	public String getFaultyRequestStatusEn() {
		return faultyRequestStatusEn;
	}

	public void setFaultyRequestStatusEn(String faultyRequestStatusEn) {
		this.faultyRequestStatusEn = faultyRequestStatusEn;
	}

	public String getFaultyRequestStatusAr() {
		return faultyRequestStatusAr;
	}

	public void setFaultyRequestStatusAr(String faultyRequestStatusAr) {
		this.faultyRequestStatusAr = faultyRequestStatusAr;
	}

	public long getFacultyRequestId() {
		return facultyRequestId;
	}

	public void setFacultyRequestId(long facultyRequestId) {
		this.facultyRequestId = facultyRequestId;
	}

}