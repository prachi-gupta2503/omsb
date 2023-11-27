package gov.omsb.superset.dashboard.configuration.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "omsb-superset-dashboard-configuration", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "gov.omsb.superset.dashboard.configuration.api.OmsbDomainSupersetDashboardConfiguration", name = "domain-configuration", localization = "content/Language")
public interface OmsbDomainSupersetDashboardConfiguration {
	@AD(required = false, deflt = "", name = "api_base_url")
	public String getApiBaseURL();

	@AD(required = false, deflt = "", name = "api_login")
	public String getApiLogin();
	
	@AD(required = false, deflt = "", name = "api_guest_token")
	public String getApiGuestToken();
	
	@AD(required = false, deflt = "", name = "dashboard_context_path")
	public String getDashboardContextPath();
	
	@AD(required = false, deflt = "", name = "embedded_dashboard_context_path")
	public String getEmbeddedDashboardContextPath();
}
