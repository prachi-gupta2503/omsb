package gov.omsb.tms.custom.dto;

public class SauUserListDTO {

	private long sauUserId;
	private String sauUserName;

	public long getSauUserId() {
		return sauUserId;
	}

	public void setSauUserId(long sauUserId) {
		this.sauUserId = sauUserId;
	}

	public String getSauUserName() {
		return sauUserName;
	}

	public void setSauUserName(String sauUserName) {
		this.sauUserName = sauUserName;
	}

	@Override
	public String toString() {
		return "SauUserListDTO [sauUserId=" + sauUserId + ", sauUserName=" + sauUserName + "]";
	}

}
