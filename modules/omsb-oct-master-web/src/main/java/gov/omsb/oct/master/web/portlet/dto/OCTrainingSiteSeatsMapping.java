package gov.omsb.oct.master.web.portlet.dto;

public class OCTrainingSiteSeatsMapping {

	private long id;
	private int seats;
	private long picklistId;
	private String statusId;
	private long trainingSite;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public long getPicklistId() {
		return picklistId;
	}

	public void setPicklistId(long picklistId) {
		this.picklistId = picklistId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public long getTrainingSite() {
		return trainingSite;
	}

	public void setTrainingSite(long trainingSite) {
		this.trainingSite = trainingSite;
	}

	
}
