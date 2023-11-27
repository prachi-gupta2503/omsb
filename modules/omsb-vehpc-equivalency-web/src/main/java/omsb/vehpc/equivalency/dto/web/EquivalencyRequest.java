package omsb.vehpc.equivalency.dto.web;

public class EquivalencyRequest {
	private long id;
	private long personId;
	private long equivalencyStatusId;
	private long employerUserID;
	private String dateCreated;
	private EquivalencyWFStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public long getEquivalencyStatusId() {
		return equivalencyStatusId;
	}

	public void setEquivalencyStatusId(long equivalencyStatusId) {
		this.equivalencyStatusId = equivalencyStatusId;
	}

	public long getEmployerUserID() {
		return employerUserID;
	}

	public void setEmployerUserID(long employerUserID) {
		this.employerUserID = employerUserID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public EquivalencyWFStatus getStatus() {
		return status;
	}

	public void setStatus(EquivalencyWFStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyRequest [id=");
		builder.append(id);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", equivalencyStatusId=");
		builder.append(equivalencyStatusId);
		builder.append(", employerUserID=");
		builder.append(employerUserID);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
