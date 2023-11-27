package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbNotifySauWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbNotifySauWebNotificationConfiguration", enabled = true, immediate = true)
public class OmsbNotifySauWebNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}

	protected void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbNotifySauWebNotificationConfiguration.class,
				properties);
		notificationTemplate = configuration.notificationTemplate();
	}

	private volatile OmsbNotifySauWebNotificationConfiguration configuration;

	private static String notificationTemplate;
}
