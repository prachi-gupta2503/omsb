package gov.omsb.email.config.configuration.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.email.config.configuration.OmsbNotifySauEmailConfiguration;

@Component(configurationPid = "gov.omsb.email.config.configuration.OmsbNotifySauEmailConfiguration", enabled = true, immediate = true)
public class OmsbNotifySauEmailConfigurationAction {

	public static String subject() {
		Map<Locale, String> subjectMap = LocalizationUtil.getLocalizationMap(subject);
		return subjectMap.get(Locale.US);
	}
	
	public static String body() {
		Map<Locale, String> bodyMap = LocalizationUtil.getLocalizationMap(body);
		return bodyMap.get(Locale.US);
	}

	public static String subjectXML() {
		return subject;
	}
	
	public static String bodyXML() {
		return body;
	}
	
	protected void activate(Map<String, Object> properties) {
		omsbNotifySauEmailConfiguration = ConfigurableUtil.createConfigurable(OmsbNotifySauEmailConfiguration.class,
				properties);
		subject = omsbNotifySauEmailConfiguration.subject();
		body = omsbNotifySauEmailConfiguration.body();
	}

	private volatile OmsbNotifySauEmailConfiguration omsbNotifySauEmailConfiguration;

	private static String subject;

	private static String body;

}
