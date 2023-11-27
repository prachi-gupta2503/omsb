package gov.omsb.tms.custom.dto;

public class ResidentReportDTO {	
	
	public ResidentReportDTO() {
		super();
	}
	
	private long trainingSiteId;
	private String trainingSiteName;
	private long rotationId;
	private String rotationName;
	private String blockNo;
	private int traineesInProgram;
	private int traineesNotInProgram;
	private long facultyId;
	private String firstName;
	private String lastName;
	public long getTrainingSiteId() {
		return trainingSiteId;
	}
	public String getTrainingSiteName() {
		return trainingSiteName;
	}
	public long getRotationId() {
		return rotationId;
	}
	public String getRotationName() {
		return rotationName;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public int getTraineesInProgram() {
		return traineesInProgram;
	}
	public int getTraineesNotInProgram() {
		return traineesNotInProgram;
	}
	public long getFacultyId() {
		return facultyId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}
	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}
	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}
	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public void setTraineesInProgram(int traineesInProgram) {
		this.traineesInProgram = traineesInProgram;
	}
	public void setTraineesNotInProgram(int traineesNotInProgram) {
		this.traineesNotInProgram = traineesNotInProgram;
	}
	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "ResidentReportDTO [trainingSiteId=" + trainingSiteId + ", trainingSiteName="
				+ trainingSiteName + ", rotationId=" + rotationId + ", rotationName=" + rotationName + ", blockNo="
				+ blockNo + ", traineesInProgram=" + traineesInProgram + ", traineesNotInProgram="
				+ traineesNotInProgram + ", facultyId=" + facultyId + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
}
