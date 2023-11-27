package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbVehpcEquivalencyWebNotificationConfiguration;


@Component(
		configurationPid = "gov.omsb.web.notification.configuration.OmsbVehpcEquivalencyWebNotificationConfiguration",
		enabled = true, 
		immediate = true
	)
public class OmsbVehpcEquivalencyWebNotificationConfigurationAction {
	public static String additionalCommentsTemplate() {
		return additionalCommentsTemplate;
	}
	
	protected void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbVehpcEquivalencyWebNotificationConfiguration.class, properties);
		additionalCommentsTemplate = configuration.additionalCommentsTemplate();
	}

	private volatile OmsbVehpcEquivalencyWebNotificationConfiguration configuration;

	private static String additionalCommentsTemplate;
}
