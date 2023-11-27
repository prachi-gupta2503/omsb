package gov.omsb.web.notification.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-web-notification-configuration", 
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.web.notification.configuration.OCTRegistrationNotificationConfiguration", 
localization = "content/Language",name="web-notification-registration")

public interface OCTRegistrationNotificationConfiguration {

	@AD(required = false, deflt="")
	public String notificationTemplate();
	
	@AD(required = false, deflt="")
	public String notificationSubject();
	
	@AD(required = false, deflt="")
	public String getExamNotificationTemplate();

	@AD(required = false, deflt="")
	public String getExamNotificationSubject();
	
	@AD(required = false, deflt="")
	public String getExamRescheduleNotificationTemplate();

	@AD(required = false, deflt="")
	public String getExamRescheduleNotificationSubject();
	
	
	
	@AD(required = false, deflt="")
	public String getScheduleExamNotificationTemplate();

	@AD(required = false, deflt="")
	public String getScheduleExamNotificationSubject();
	
	
}
