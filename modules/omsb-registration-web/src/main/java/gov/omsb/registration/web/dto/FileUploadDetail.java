package gov.omsb.registration.web.dto;

public class FileUploadDetail {
	private Integer componentId;
    private String componentName;
    private Integer docTypeId;
    private String docType;
    private Integer docId;
    private String fileAttachmentType;
    private String fileName;
    private String fileKey;
    private Integer equivalencyDocTypeId;
    private Integer personId;
    private long fileEntryId;
    private long equivalencyRequestId;
    private String file;
    private String fileType;
    
    public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}
	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}
	public long getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Integer getEquivalencyDocTypeId() {
		return equivalencyDocTypeId;
	}
	public void setEquivalencyDocTypeId(Integer equivalencyDocTypeId) {
		this.equivalencyDocTypeId = equivalencyDocTypeId;
	}
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Integer getDocTypeId() {
		return docTypeId;
	}
	public void setDocTypeId(Integer docTypeId) {
		this.docTypeId = docTypeId;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public String getFileAttachmentType() {
		return fileAttachmentType;
	}
	public void setFileAttachmentType(String fileAttachmentType) {
		this.fileAttachmentType = fileAttachmentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
}
