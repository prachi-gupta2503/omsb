package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamMultiDates {
	private long id;
	private String examSlot;
	private long examCenter;
	private String daysOfWeek;
	private int noOfSeats;
	private long oCExamScheduleAdminId;
	private String examCenterName;
	private String daysOfWeekList;
	private String examSlotList;
	
	public String getDaysOfWeekList() {
		return daysOfWeekList;
	}
	public void setDaysOfWeekList(String daysOfWeekList) {
		this.daysOfWeekList = daysOfWeekList;
	}
	public String getExamSlotList() {
		return examSlotList;
	}
	public void setExamSlotList(String examSlotList) {
		this.examSlotList = examSlotList;
	}
	public String getExamCenterName() {
		return examCenterName;
	}
	public void setExamCenterName(String examCenterName) {
		this.examCenterName = examCenterName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExamSlot() {
		return examSlot;
	}
	public void setExamSlot(String examSlot) {
		this.examSlot = examSlot;
	}
	public long getExamCenter() {
		return examCenter;
	}
	public void setExamCenter(long examCenter) {
		this.examCenter = examCenter;
	}
	public String getDaysOfWeek() {
		return daysOfWeek;
	}
	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public long getoCExamScheduleAdminId() {
		return oCExamScheduleAdminId;
	}
	public void setoCExamScheduleAdminId(long oCExamScheduleAdminId) {
		this.oCExamScheduleAdminId = oCExamScheduleAdminId;
	}
	@Override
	public String toString() {
		return "OCTExamMultiDates [id=" + id + ", examSlot=" + examSlot + ", examCenter=" + examCenter + ", daysOfWeek="
				+ daysOfWeek + ", noOfSeats=" + noOfSeats + ", oCExamScheduleAdminId=" + oCExamScheduleAdminId
				+ ", examCenterName=" + examCenterName + ", daysOfWeekList=" + daysOfWeekList + ", examSlotList="
				+ examSlotList + "]";
	}
	
	
	
}
