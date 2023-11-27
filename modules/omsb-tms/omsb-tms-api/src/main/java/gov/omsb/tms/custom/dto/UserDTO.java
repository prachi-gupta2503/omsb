package gov.omsb.tms.custom.dto;

public class UserDTO {
	
	private long userId;
	private String userFullName;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	

}
