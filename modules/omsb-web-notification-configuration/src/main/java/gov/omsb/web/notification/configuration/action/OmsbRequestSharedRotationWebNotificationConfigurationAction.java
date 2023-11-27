package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbRequestSharedRotationWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbRequestSharedRotationWebNotificationConfiguration", enabled = true, immediate = true)
public class OmsbRequestSharedRotationWebNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}

	protected void activate(Map<String, Object> properties) {
		omsbRequestSharedRotationWebNotificationConfiguration = ConfigurableUtil
				.createConfigurable(OmsbRequestSharedRotationWebNotificationConfiguration.class, properties);
		notificationTemplate = omsbRequestSharedRotationWebNotificationConfiguration.notificationTemplate();
	}

	private volatile OmsbRequestSharedRotationWebNotificationConfiguration omsbRequestSharedRotationWebNotificationConfiguration;

	private static String notificationTemplate;
}
