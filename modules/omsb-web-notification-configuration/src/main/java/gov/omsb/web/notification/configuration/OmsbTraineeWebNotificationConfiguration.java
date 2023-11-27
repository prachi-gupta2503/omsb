package gov.omsb.web.notification.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-web-notification-configuration", 
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.web.notification.configuration.OmsbTraineeWebNotificationConfiguration", 
localization = "content/Language",name="web-notification-trainee")
public interface OmsbTraineeWebNotificationConfiguration {

	@AD(required = false, deflt="")
	public String notificationTemplate();
	
}
