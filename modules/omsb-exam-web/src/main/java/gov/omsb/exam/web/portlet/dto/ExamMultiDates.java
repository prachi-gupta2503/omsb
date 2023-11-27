package gov.omsb.exam.web.portlet.dto;

public class ExamMultiDates {

	private long id;
	private long examScheduleId;
	private String startTime;
	private String endTime;
	private String venue;
	private String locationOnGoogleMap;
	private String locationPinOnGoogleMap;
	private String examDate;
	private String daysOfWeek;
	private int noOfSeats;
	private long examScheduleAdminId;

	
	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamScheduleId() {
		return examScheduleId;
	}

	public void setExamScheduleId(long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}

	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}

	public String getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public long getExamScheduleAdminId() {
		return examScheduleAdminId;
	}

	public void setExamScheduleAdminId(long examScheduleAdminId) {
		this.examScheduleAdminId = examScheduleAdminId;
	}

	public String getLocationPinOnGoogleMap() {
		return locationPinOnGoogleMap;
	}

	public void setLocationPinOnGoogleMap(String locationPinOnGoogleMap) {
		this.locationPinOnGoogleMap = locationPinOnGoogleMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExamMultiDates [id=");
		builder.append(id);
		builder.append(", examScheduleId=");
		builder.append(examScheduleId);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", venue=");
		builder.append(venue);
		builder.append(", locationOnGoogleMap=");
		builder.append(locationOnGoogleMap);
		builder.append(", locationPinOnGoogleMap=");
		builder.append(locationPinOnGoogleMap);
		builder.append(", examDate=");
		builder.append(examDate);
		builder.append(", daysOfWeek=");
		builder.append(daysOfWeek);
		builder.append(", noOfSeats=");
		builder.append(noOfSeats);
		builder.append(", examScheduleAdminId=");
		builder.append(examScheduleAdminId);
		builder.append("]");
		return builder.toString();
	}
}
