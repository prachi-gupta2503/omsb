package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbApproveSharedRotationWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbApproveSharedRotationWebNotificationConfiguration",enabled = true, immediate = true)
public class OmsbApproveSharedRotationWebNotificationConfigurationAction {

	public static String notificationTemplate() {
		return notificationTemplate;
	}
	
	protected void activate(Map<String,Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbApproveSharedRotationWebNotificationConfiguration.class, properties);
		notificationTemplate = configuration.notificationTemplate();
	} 
	
	private volatile OmsbApproveSharedRotationWebNotificationConfiguration configuration;
	
	private static String notificationTemplate;

}
