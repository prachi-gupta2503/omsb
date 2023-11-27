package gov.osmb.dashboard.notification.dto;

public class NotificationDto {
	
  private long id;
  private String notificationText;
  private String dateTime;
  private String image;
  private String emailContent;
  private String viewDetailUrl;
  
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

public String getNotificationText() {
	return notificationText;
}
public void setNotificationText(String notificationText) {
	this.notificationText = notificationText;
}
public String getEmailContent() {
	return emailContent;
}
public void setEmailContent(String emailContent) {
	this.emailContent = emailContent;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getViewDetailUrl() {
	return viewDetailUrl;
}
public void setViewDetailUrl(String viewDetailUrl) {
	this.viewDetailUrl = viewDetailUrl;
}
  
  
  
}
