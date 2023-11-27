package gov.omsb.superset.dashboard.configuration.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

/**
 * @author Niddhi Thacker
 */

@ExtendedObjectClassDefinition(category = "omsb-superset-dashboard-configuration", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.superset.dashboard.configuration.api.OmsbAccessTokenSupersetDashboardConfiguration", name = "access-token-configuration", localization = "content/Language")
public interface OmsbAccessTokenSupersetDashboardConfiguration{
	@AD(required = false, deflt = "", name = "user-name")
	public String getUserName();

	@AD(required = false, deflt = "", name = "provider")
	public String getProvider();
	
	@AD(required = false, deflt = "", name = "password")
	public String getPassword();
}