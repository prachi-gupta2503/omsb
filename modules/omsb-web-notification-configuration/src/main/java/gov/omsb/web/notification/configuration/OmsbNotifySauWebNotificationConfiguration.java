package gov.omsb.web.notification.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-web-notification-configuration", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.web.notification.configuration.OmsbNotifySauWebNotificationConfiguration", localization = "content/Language", name = "notify-sau-web-notification")
public interface OmsbNotifySauWebNotificationConfiguration {
	@AD(required = false, deflt = "")
	public String notificationTemplate();
}
