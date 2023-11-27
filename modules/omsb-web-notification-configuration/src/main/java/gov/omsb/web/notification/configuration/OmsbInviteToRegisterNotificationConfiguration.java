package gov.omsb.web.notification.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-web-notification-configuration", 
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.web.notification.configuration.OmsbInviteToRegisterNotificationConfiguration", 
localization = "content/Language",name="web-invite-to-register-notification-configuration")
public interface OmsbInviteToRegisterNotificationConfiguration {

	@AD(required = false, deflt="")
	public String emailSubject();
	
	@AD(required = false, deflt="")
	public String emailBody();
}
