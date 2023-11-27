package gov.omsb.exam.web.portlet.dto;

public class ExamResultItem {
	private long id;
	private long examDefinitionId;
	private long examScheduleId;
	private long lrUserId;
	private double percentage;
	private boolean appeared;
	private String result;
	private String examType;
	private String programName;
	private String adminComments;
	private int appealCount;
	private String appealStatus;
	private String examAnnouncedDate;
	private long traineeLevelId;
	private String adminUploadedDocURL;
	private double appealFees;
	private double reAppealFees;
	
	@Override
	public String toString() {
		return "ExamResultItem [id=" + id + ", examDefinitionId=" + examDefinitionId + ", examScheduleId="
				+ examScheduleId + ", lrUserId=" + lrUserId + ", percentage=" + percentage + ", appeared=" + appeared
				+ ", result=" + result + ", examType=" + examType + ", programName=" + programName + ", adminComments="
				+ adminComments + ", appealCount=" + appealCount + ", appealStatus=" + appealStatus
				+ ", examAnnouncedDate=" + examAnnouncedDate + ", traineeLevelId=" + traineeLevelId
				+ ", adminUploadedDocURL=" + adminUploadedDocURL + "]";
	}

	public String getAdminUploadedDocURL() {
		return adminUploadedDocURL;
	}

	public void setAdminUploadedDocURL(String adminUploadedDocURL) {
		this.adminUploadedDocURL = adminUploadedDocURL;
	}

	public long getTraineeLevelId() {
		return traineeLevelId;
	}

	public void setTraineeLevelId(long traineeLevelId) {
		this.traineeLevelId = traineeLevelId;
	}

	public String getExamAnnouncedDate() {
		return examAnnouncedDate;
	}

	public void setExamAnnouncedDate(String examAnnouncedDate) {
		this.examAnnouncedDate = examAnnouncedDate;
	}

	public String getAppealStatus() {
		return appealStatus;
	}

	public void setAppealStatus(String appealStatus) {
		this.appealStatus = appealStatus;
	}

	public int getAppealCount() {
		return appealCount;
	}

	public void setAppealCount(int appealCount) {
		this.appealCount = appealCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamDefinitionId() {
		return examDefinitionId;
	}

	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}

	public long getExamScheduleId() {
		return examScheduleId;
	}

	public void setExamScheduleId(long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}

	public long getLrUserId() {
		return lrUserId;
	}

	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public boolean isAppeared() {
		return appeared;
	}

	public void setAppeared(boolean appeared) {
		this.appeared = appeared;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getAdminComments() {
		return adminComments;
	}

	public void setAdminComments(String adminComments) {
		this.adminComments = adminComments;
	}

	public double getAppealFees() {
		return appealFees;
	}

	public void setAppealFees(double appealFees) {
		this.appealFees = appealFees;
	}

	public double getReAppealFees() {
		return reAppealFees;
	}

	public void setReAppealFees(double reAppealFees) {
		this.reAppealFees = reAppealFees;
	}
}
