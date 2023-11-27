package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OCTRegistrationNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OCTRegistrationNotificationConfiguration", enabled = true, immediate = true)
public class OCTRegistrationNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}

	public static String notificationSubject() {
		return notificationSubject;
	}

	public static String getExamNotificationTemplate() {
		return examNotificationTemplate;
	}

	public static String getExamNotificationSubject() {
		return examNotificationSubject;
	}

	public static String getExamRescheduleNotificationTemplate() {
		return examRescheduleNotificationTemplate;
	}

	public static String getExamRescheduleNotificationSubject() {
		return examRescheduleNotificationTemplateSubject;
	}

	
	
	public static String getScheduleExamNotificationTemplate() {
		return ScheduleExamNotificationTemplate;
	}

	public static String getScheduleExamNotificationSubject() {
		return ScheduleExamNotificationSubject;
	}

	
	protected void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OCTRegistrationNotificationConfiguration.class, properties);
		notificationTemplate = configuration.notificationTemplate();
		examNotificationTemplate = configuration.getExamNotificationTemplate();
		examNotificationSubject = configuration.getExamNotificationSubject();
		examRescheduleNotificationTemplate = configuration.getExamRescheduleNotificationTemplate();
		examRescheduleNotificationTemplateSubject = configuration.getExamRescheduleNotificationSubject();
		
		ScheduleExamNotificationTemplate = configuration.getScheduleExamNotificationTemplate();
		ScheduleExamNotificationSubject = configuration.getScheduleExamNotificationSubject();

	}

	private volatile OCTRegistrationNotificationConfiguration configuration;

	private static String notificationTemplate;
	private static String notificationSubject;
	private static String examNotificationTemplate;
	private static String examNotificationSubject;
	private static String examRescheduleNotificationTemplate;
	private static String examRescheduleNotificationTemplateSubject;
	
	private static String ScheduleExamNotificationTemplate;
	private static String ScheduleExamNotificationSubject;
}
