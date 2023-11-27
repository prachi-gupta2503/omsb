package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbTrainingSitesWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbTrainingSitesWebNotificationConfiguration", enabled = true, immediate = true)
public class OmsbTrainingSitesWebNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}

	protected void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbTrainingSitesWebNotificationConfiguration.class,
				properties);
		notificationTemplate = configuration.notificationTemplate();
	}

	private volatile OmsbTrainingSitesWebNotificationConfiguration configuration;

	private static String notificationTemplate;
}
