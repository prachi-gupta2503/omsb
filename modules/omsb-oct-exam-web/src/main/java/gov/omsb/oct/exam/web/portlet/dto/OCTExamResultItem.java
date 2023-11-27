package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamResultItem {
	private long id;
	private long oCExamDefinitionId;
	private long oCExamScheduleId;
	private long lrUserId;
	private double percentage;
	private boolean appeared;
	private String result;
	private String isAppealAllowed;
	private String isReAppealAllowed;
	private String adminComments;
	private int appealCount;
	private String appealStatus;
	private String announcedDate;
	private String examtitle;
	private String statusColor;
	
	private double appealFees;
	private double reAppealFees;

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

	public long getoCExamDefinitionId() {
		return oCExamDefinitionId;
	}

	public void setoCExamDefinitionId(long oCExamDefinitionId) {
		this.oCExamDefinitionId = oCExamDefinitionId;
	}

	public long getoCExamScheduleId() {
		return oCExamScheduleId;
	}

	public void setoCExamScheduleId(long oCExamScheduleId) {
		this.oCExamScheduleId = oCExamScheduleId;
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

	public String getIsAppealAllowed() {
		return isAppealAllowed;
	}

	public void setIsAppealAllowed(String isAppealAllowed) {
		this.isAppealAllowed = isAppealAllowed;
	}

	public String getAdminComments() {
		return adminComments;
	}

	public void setAdminComments(String adminComments) {
		this.adminComments = adminComments;
	}

	
	public String getAnnouncedDate() {
		return announcedDate;
	}

	public void setAnnouncedDate(String announcedDate) {
		this.announcedDate = announcedDate;
	}

	
	public String getIsReAppealAllowed() {
		return isReAppealAllowed;
	}

	public void setIsReAppealAllowed(String isReAppealAllowed) {
		this.isReAppealAllowed = isReAppealAllowed;
	}
	
	public String getExamtitle() {
		return examtitle;
	}

	public void setExamtitle(String examtitle) {
		this.examtitle = examtitle;
	}

	
	public String getStatusColor() {
		return statusColor;
	}

	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTExamResultItem [id=");
		builder.append(id);
		builder.append(", oCExamDefinitionId=");
		builder.append(oCExamDefinitionId);
		builder.append(", oCExamScheduleId=");
		builder.append(oCExamScheduleId);
		builder.append(", lrUserId=");
		builder.append(lrUserId);
		builder.append(", percentage=");
		builder.append(percentage);
		builder.append(", isAppeared=");
		builder.append(appeared);
		builder.append(", result=");
		builder.append(result);
		builder.append(", isAppealAllowed=");
		builder.append(isAppealAllowed);
		builder.append(", isReAppealAllowed=");
		builder.append(isReAppealAllowed);
		builder.append(", adminComments=");
		builder.append(adminComments);
		builder.append(", appealCount=");
		builder.append(appealCount);
		builder.append(", appealStatus=");
		builder.append(appealStatus);
		builder.append(", announcedDate=");
		builder.append(announcedDate);
		builder.append(", examtitle=");
		builder.append(examtitle);
		builder.append(", statusColor=");
		builder.append(statusColor);
		builder.append("]");
		return builder.toString();
	}
}
