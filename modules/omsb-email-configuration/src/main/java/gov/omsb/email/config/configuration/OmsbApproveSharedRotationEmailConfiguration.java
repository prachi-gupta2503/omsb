package gov.omsb.email.config.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-email-configuration", 
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.email.config.configuration.OmsbApproveSharedRotationEmailConfiguration", 
localization = "content/Language",name="approve-shared-rotations-email-notification")
public interface OmsbApproveSharedRotationEmailConfiguration {

	@AD(required = false, deflt="" , name = "subject")
	public String subject();
	
	@AD(required = false, deflt="", name = "body")
	public String body();

}
