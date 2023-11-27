package omsb.tms.headless.service.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author AftabA
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false", "osgi.jaxrs.application.base=/eportal-service",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=OmsbTmsHeadlessService"
	},
	service = Application.class
)
@Generated("")
public class OmsbTmsHeadlessServiceApplication extends Application {
}