package gov.omsb.form.builder.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jinal Patel
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false", "osgi.jaxrs.application.base=/omsb-form-api",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=FormBuilderHeadless"
	},
	service = Application.class
)
@Generated("")
public class FormBuilderHeadlessApplication extends Application {
}