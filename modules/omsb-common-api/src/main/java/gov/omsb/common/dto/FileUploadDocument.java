package gov.omsb.common.dto;

public class FileUploadDocument {
	
	private Payload payload;
    
	public Payload getPayload() {
        return payload;
    }
    public void setPayload(Payload payload) {
        this.payload = payload;
    }
    
    public class Payload {
		public Payload() {
			super();
		}
		private String caseNumber;
	    private long docId;
	    private FileUploadDetail fileUploadDetail;
	    private String fileName;
	    private String file;
	    private String fileType;
	    
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getFile() {
			return file;
		}
		public void setFile(String file) {
			this.file = file;
		}
		public String getCaseNumber() {
			return caseNumber;
		}
		public void setCaseNumber(String caseNumber) {
			this.caseNumber = caseNumber;
		}
		public long getDocId() {
			return docId;
		}
		public void setDocId(long docId) {
			this.docId = docId;
		}
		public FileUploadDetail getFileUploadDetail() {
			return fileUploadDetail;
		}
		public void setFileUploadDetail(FileUploadDetail fileUploadDetail) {
			this.fileUploadDetail = fileUploadDetail;
		}
	    @Override
	    public String toString() {
	    	return caseNumber + docId;
	    }
    }
}
