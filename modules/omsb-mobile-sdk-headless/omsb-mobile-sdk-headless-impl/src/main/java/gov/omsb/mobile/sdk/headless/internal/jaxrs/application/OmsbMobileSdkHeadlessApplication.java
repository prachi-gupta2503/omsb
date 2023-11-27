package gov.omsb.mobile.sdk.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Niddhi Thacker
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/omsb-mobile-sdk-headless",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=OmsbMobileSdkHeadless"
	},
	service = Application.class
)
@Generated("")
public class OmsbMobileSdkHeadlessApplication extends Application {
}