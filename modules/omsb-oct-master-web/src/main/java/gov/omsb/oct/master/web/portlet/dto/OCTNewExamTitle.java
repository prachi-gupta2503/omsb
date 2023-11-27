package gov.omsb.oct.master.web.portlet.dto;

public class OCTNewExamTitle {
	
	private long id;
	private String key;
	private String nameEnglish;
	private String nameArabic;
	private String externalReferenceCode;
	private String examCode;
	private long octNewExamTitleId;
	
	public long getOctNewExamTitleId() {
		return octNewExamTitleId;
	}
	public void setOctNewExamTitleId(long octNewExamTitleId) {
		this.octNewExamTitleId = octNewExamTitleId;
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
}