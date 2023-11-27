package gov.omsb.email.config.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-email-configuration", 
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.email.config.configuration.OmsbFromEmailConfiguration", 
localization = "content/Language",name="from-email-configuration")
public interface OmsbFromEmailConfiguration {

	@AD(required = false, deflt="")
	public String fromAdminEmail();
	
}
