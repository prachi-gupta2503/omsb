package gov.omsb.web.notification.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.web.notification.configuration.OmsbMasterRotationScheduleWebNotificationConfiguration;

@Component(configurationPid = "gov.omsb.web.notification.configuration.OmsbMasterRotationScheduleWebNotificationConfiguration",enabled = true, immediate = true)
public class OmsbMasterRotationScheduleWebNotificationConfigurationAction {

	public static String masterRotationScheduleNotificationTemplate() {
		return masterRotationScheduleNotificationTemplate;
	}

	protected void activate(Map<String,Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(OmsbMasterRotationScheduleWebNotificationConfiguration.class, properties);
		masterRotationScheduleNotificationTemplate = configuration.masterRotationScheduleNotificationTemplate();
	}

	private volatile OmsbMasterRotationScheduleWebNotificationConfiguration configuration;

	private static String masterRotationScheduleNotificationTemplate;
	
}
