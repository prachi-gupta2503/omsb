package gov.omsb.endpoint.configuration.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-configuration", scope = Scope.COMPANY)

@OCD(id = "gov.omsb.endpoint.configuration.api.QararAPIConfiguration", name = "Qarar API")

public interface QararAPIConfiguration {
	@AD(deflt = "https://stage.omsb.gov.om/pki/qarar-api/create-qarar", name = "Qarar API URL", 
			description = "Qarar API URL", required = false)
	public String qararApiURL();

}
