package gov.omsb.email.config.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.email.config.configuration.OmsbFromEmailConfiguration;

@Component(configurationPid = "gov.omsb.email.config.configuration.OmsbFromEmailConfiguration",enabled = true, immediate = true)
public class OmsbFromEmailConfigurationAction {
	
	public static String fromAdminEmail() {
		return fromAdminEmail;
	}
	
	protected void activate(Map<String,Object> properties) {
		omsbFromEmailConfiguration = ConfigurableUtil.createConfigurable(OmsbFromEmailConfiguration.class, properties);
		fromAdminEmail = omsbFromEmailConfiguration.fromAdminEmail();
	} 
	
	private volatile OmsbFromEmailConfiguration omsbFromEmailConfiguration;
	
	private static String fromAdminEmail;
}
