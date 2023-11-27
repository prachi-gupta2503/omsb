package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbInviteToRegisterNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbInviteToRegisterNotificationConfiguration",enabled = true, immediate = true)
public class OmsbInviteToRegisterNotificationConfigurationAction {

	public static String emailSubject() {
		return emailSubject;
	}
	
	public static String emailBody() {
		return emailBody;
	}
	
	protected void activate(Map<String,Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbInviteToRegisterNotificationConfiguration.class, properties);
		emailSubject = configuration.emailSubject();
		emailBody = configuration.emailBody();
	} 
	
	private volatile OmsbInviteToRegisterNotificationConfiguration configuration;
	
	private static String emailSubject;
	private static String emailBody;

}
