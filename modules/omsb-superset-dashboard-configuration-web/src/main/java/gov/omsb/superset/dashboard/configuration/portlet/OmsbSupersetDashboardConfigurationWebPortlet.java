package gov.omsb.superset.dashboard.configuration.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.superset.dashboard.configuration.constants.OmsbSupersetDashboardConfigurationWebPortletKeys;
import gov.omsb.superset.dashboard.configuration.portlet.util.RolesDashboardConfigUtil;
import gov.omsb.superset.dashboard.service.RoleDashboardConfigLocalService;

/**
 * @author Niddhi Thacker
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/rolesDashboardConfig.jsp",
		"javax.portlet.name=" + OmsbSupersetDashboardConfigurationWebPortletKeys.OMSB_SUPERSET_DASHBOARD_CONFIGURATION,
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbSupersetDashboardConfigurationWebPortlet extends MVCPortlet {
	
	private static final Log log = LogFactoryUtil.getLog(OmsbSupersetDashboardConfigurationWebPortlet.class);
	
	public void saveRolesDashboardConfig(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		log.info("::: OmsbSupersetDashboardWebPortlet >>> saveRolesDashboardConfig >>> saving role dashboard config :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		RolesDashboardConfigUtil.setRolesDashboardConfigParams(null, roleDashboardConfigLocalService);
		boolean isSavedSuccess = RolesDashboardConfigUtil.saveRolesDashboardConfig(actionRequest, themeDisplay);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		if(isSavedSuccess) {
			SessionMessages.add(httpServletRequest, "role-dashboard-config-save-success");
		}else {
			SessionErrors.add(httpServletRequest, "role-dashboard-config-save-error");
		}
		actionResponse.sendRedirect(redirectURL);
	}
	
	@Reference
	private RoleDashboardConfigLocalService roleDashboardConfigLocalService;
}