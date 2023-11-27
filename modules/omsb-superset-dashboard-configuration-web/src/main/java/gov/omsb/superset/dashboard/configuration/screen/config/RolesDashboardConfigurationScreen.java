package gov.omsb.superset.dashboard.configuration.screen.config;

import com.liferay.configuration.admin.display.ConfigurationScreen;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.superset.dashboard.configuration.constants.OmsbSupersetDashboardConfigurationConstants;
import gov.omsb.superset.dashboard.configuration.portlet.util.DashboardWebServiceUtil;
import gov.omsb.superset.dashboard.configuration.portlet.util.RolesDashboardConfigUtil;
import gov.omsb.superset.dashboard.model.RoleDashboardConfig;
import gov.omsb.superset.dashboard.service.RoleDashboardConfigLocalService;

@Component(immediate = true, service = ConfigurationScreen.class) 

public class RolesDashboardConfigurationScreen implements ConfigurationScreen{

	private static final Log log = LogFactoryUtil.getLog(RolesDashboardConfigurationScreen.class);
	
	@Override
	public String getCategoryKey() {
		 return "omsb-superset-dashboard-configuration"; 
	}

	@Override
	public String getKey() {
	    return "roles-dashboard-configuration-screen"; 

	}

	@Override
	public String getName(Locale locale) {
		 return OmsbSupersetDashboardConfigurationConstants.ROLES_DASHBOARD_CONFIGURATION; 
	}

	@Override
	public String getScope() {
		return "system"; 
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		DashboardWebServiceUtil.setDashboardWebServiceParams(omsbHttpConnector, configurationProvider);
		log.info("::: RolesDashboardConfigurationScreen >>> render >>> rendering role dashboard configuration jsp :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cancelBtnURL = themeDisplay.getPortalURL() + OmsbSupersetDashboardConfigurationConstants.SYSTEM_SETTINGS_URL;
		RolesDashboardConfigUtil.setRolesDashboardConfigParams(roleLocalService, roleDashboardConfigLocalService);
		JSONArray roleArr = RolesDashboardConfigUtil.getRoles(themeDisplay);
		if (Validator.isNotNull(roleArr) && roleArr.length() > 0) {
			httpServletRequest.setAttribute(OmsbSupersetDashboardConfigurationConstants.ROLES, roleArr);
		}
		List<RoleDashboardConfig> roleDashboardConfigList = roleDashboardConfigLocalService
				.getRoleDashboardConfigByGroupIdAndCompanyId(themeDisplay.getScopeGroupId(),
						themeDisplay.getCompanyId());
		if(roleDashboardConfigList.isEmpty()) {
			roleDashboardConfigList = new ArrayList<>();
			RoleDashboardConfig roleDashboardConfig = roleDashboardConfigLocalService.createRoleDashboardConfig(-1);
			roleDashboardConfigList.add(roleDashboardConfig);
		}
		if(!roleDashboardConfigList.isEmpty()) {
			httpServletRequest.setAttribute(OmsbSupersetDashboardConfigurationConstants.ROLE_DASHBOARD_CONFIG_LIST, roleDashboardConfigList);
		}
		
		JSONArray dashboardIdArr = DashboardWebServiceUtil.getDashboardIds();
		httpServletRequest.setAttribute(OmsbSupersetDashboardConfigurationConstants.DASHBOARD_IDS, dashboardIdArr);
		httpServletRequest.setAttribute(OmsbSupersetDashboardConfigurationConstants.CANCEL_BTN_URL, cancelBtnURL);
		jspRenderer.renderJSP(servletContext, httpServletRequest, httpServletResponse,
				OmsbSupersetDashboardConfigurationConstants.ROLE_BASED_CONFIG_JSP);

	}
	
	@Reference private JSPRenderer jspRenderer;

	@Reference(
	    target ="(osgi.web.symbolicname=gov.omsb.superset.dashboard.configuration.web)", 
	    unbind = "-")
	private ServletContext servletContext;
	
	@Reference
	private RoleLocalService roleLocalService;
	
	@Reference
	private RoleDashboardConfigLocalService roleDashboardConfigLocalService;
	
	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	private ConfigurationProvider configurationProvider;
	
	@Reference(unbind = "-")
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}
	
}