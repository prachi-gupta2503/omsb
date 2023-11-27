package gov.omsb.endpoint.configuration.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
/*
 * @author SanjayR
 */
@ExtendedObjectClassDefinition(
		category = "omsb-configuration",
		scope = Scope.COMPANY
		)

@OCD(
		id = "gov.omsb.endpoint.configuration.api.PkiConfiguration",
		localization = "content/language",
		name = "Pki"
		)
public interface PkiConfiguration {
	/*
	 * This method return the pki avaibility
	 */
	@AD(deflt = "false", name = "Is Pki Available", description = "This is for Pki avaibility", required = false)
	public Boolean isPkiAvailable();

	/*
	 * This method return the pki mandatory
	 */
	@AD(deflt = "false", name = "Is Pki Mandatory", description = "This is for Pki Mandatory", required = false)
	public Boolean isPkiMandatory();
}
