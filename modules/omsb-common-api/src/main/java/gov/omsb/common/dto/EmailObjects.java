package gov.omsb.common.dto;


import java.io.File;

public class EmailObjects {
	private String fromAddress;
	private String toAddress;
	private String ccAddress;
	private String bccAddress;
	private String subject;
	private String body;
	private String fullName;
	private String otpValue;
	private File file;
	private String[] oldSubstitute;
	private String[] newSubstitute;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getValue() {
		return otpValue;
	}
	public void setValue(String otpValue) {
		this.otpValue = otpValue;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getBccAddress() {
		return bccAddress;
	}
	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String[] getOldSubstitute() {
		return oldSubstitute;
	}
	public void setOldSubstitute(String[] oldSubstitute) {
		this.oldSubstitute = oldSubstitute;
	}
	public String[] getNewSubstitute() {
		return newSubstitute;
	}
	public void setNewSubstitute(String[] newSubstitute) {
		this.newSubstitute = newSubstitute;
	}
	
}
