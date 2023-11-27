
package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbExamWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbExamWebNotificationConfiguration",enabled = true, immediate = true)
public class OmsbExamWenNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}
	
	protected void activate(Map<String,Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbExamWebNotificationConfiguration.class, properties);
		notificationTemplate = configuration.notificationTemplate();
	} 
	
	private volatile OmsbExamWebNotificationConfiguration configuration;
	
	private static String notificationTemplate;
	
}
