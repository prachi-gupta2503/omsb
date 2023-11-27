package gov.omsb.verification.dto;

public class DocumentTypesItem {
	
    private long lrComponentId;
    private long dFDocTypeId;
    private long dFComponentId;
    
    private DocumentTypesPicList type;

	public long getLrComponentId() {
		return lrComponentId;
	}

	public void setLrComponentId(long lrComponentId) {
		this.lrComponentId = lrComponentId;
	}

	public long getdFDocTypeId() {
		return dFDocTypeId;
	}

	public void setdFDocTypeId(long dFDocTypeId) {
		this.dFDocTypeId = dFDocTypeId;
	}

	public long getdFComponentId() {
		return dFComponentId;
	}

	public void setdFComponentId(long dFComponentId) {
		this.dFComponentId = dFComponentId;
	}

	public DocumentTypesPicList getType() {
		return type;
	}

	public void setType(DocumentTypesPicList type) {
		this.type = type;
	}
    
	
	
	
}
