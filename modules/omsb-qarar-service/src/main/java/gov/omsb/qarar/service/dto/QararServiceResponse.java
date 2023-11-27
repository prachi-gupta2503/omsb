package gov.omsb.qarar.service.dto;

import java.io.Serializable;

public class QararServiceResponse implements Serializable{
	private static final long serialVersionUID = 2329096820215271918L;
	
	private int statusCode;
	private long docTreeId;
	private String previewLink;
	private String statusMsg;
	
	public String getPreviewLink() {
		return previewLink;
	}
	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public long getDocTreeId() {
		return docTreeId;
	}
	public void setDocTreeId(long docTreeId) {
		this.docTreeId = docTreeId;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

}
