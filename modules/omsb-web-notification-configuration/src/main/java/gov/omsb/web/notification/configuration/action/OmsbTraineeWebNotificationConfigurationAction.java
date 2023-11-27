package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbTraineeWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbTraineeWebNotificationConfiguration",enabled = true, immediate = true)
public class OmsbTraineeWebNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}
	
	protected void activate(Map<String,Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbTraineeWebNotificationConfiguration.class, properties);
		notificationTemplate = configuration.notificationTemplate();
	} 
	
	private volatile OmsbTraineeWebNotificationConfiguration configuration;
	
	private static String notificationTemplate;
}
