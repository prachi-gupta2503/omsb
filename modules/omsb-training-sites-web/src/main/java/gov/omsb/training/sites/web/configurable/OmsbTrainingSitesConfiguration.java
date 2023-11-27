package gov.omsb.training.sites.web.configurable;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-site-configuration", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.training.sites.web.configurable.OmsbTrainingSitesConfiguration", localization = "content/Language", name = "training-site-trainee-count")
public interface OmsbTrainingSitesConfiguration {
	@AD(required = false, deflt = "0")
	public long traineeCount();
}
