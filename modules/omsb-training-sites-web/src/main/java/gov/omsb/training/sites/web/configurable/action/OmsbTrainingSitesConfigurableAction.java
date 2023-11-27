package gov.omsb.training.sites.web.configurable.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import gov.omsb.training.sites.web.configurable.OmsbTrainingSitesConfiguration;

@Component(configurationPid = "gov.omsb.training.sites.web.configurable.OmsbTrainingSitesConfiguration", enabled = true, immediate = true)
public class OmsbTrainingSitesConfigurableAction {

	public static long traineeCount() {
		return traineeCount;
	}

	protected void activate(Map<String, Object> properties) {
		omsbTrainingSitesConfiguration = ConfigurableUtil.createConfigurable(OmsbTrainingSitesConfiguration.class,
				properties);
		traineeCount = omsbTrainingSitesConfiguration.traineeCount();
	}

	private volatile OmsbTrainingSitesConfiguration omsbTrainingSitesConfiguration;

	private static long traineeCount;

}