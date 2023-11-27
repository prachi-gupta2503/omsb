package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbSupervisorWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbSupervisorWebNotificationConfiguration",enabled = true, immediate = true)
public class OmsbSupervisorWebNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}
	
	protected void activate(Map<String,Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbSupervisorWebNotificationConfiguration.class, properties);
		notificationTemplate = configuration.notificationTemplate();
	} 
	
	private volatile OmsbSupervisorWebNotificationConfiguration configuration;
	
	private static String notificationTemplate;
}
