package gov.omsb.oct.master.web.portlet.dto;

public class OCTNewTrainingSite {
	
	private long id;
	private String key;
	private String nameEnglish;
	private String nameArabic;
	private String externalReferenceCode;
	private String examCode;
	private int seats;
	private String statusId;
	private long trainingSite;
	private long octNewTrainingSiteId;
	
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getNameEnglish() {
		return nameEnglish;
	}
	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}
	public String getNameArabic() {
		return nameArabic;
	}
	public void setNameArabic(String nameArabic) {
		this.nameArabic = nameArabic;
	}
	public String getExternalReferenceCode() {
		return externalReferenceCode;
	}
	public void setExternalReferenceCode(String externalReferenceCode) {
		this.externalReferenceCode = externalReferenceCode;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public long getOctNewTrainingSiteId() {
		return octNewTrainingSiteId;
	}
	public void setOctNewTrainingSiteId(long octNewTrainingSiteId) {
		this.octNewTrainingSiteId = octNewTrainingSiteId;
	}
	
}