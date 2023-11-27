package gov.omsb.dashboard.web.portlet.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.comparator.RoleNameComparator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.dashboard.web.constants.OmsbDashboardWebPortletKeys;
import gov.omsb.dashboard.web.portlet.OmsbDashboardWebPortlet;
import gov.omsb.superset.dashboard.configuration.api.OmsbAccessTokenSupersetDashboardConfiguration;
import gov.omsb.superset.dashboard.configuration.api.OmsbDomainSupersetDashboardConfiguration;
import gov.omsb.superset.dashboard.model.RoleDashboardConfig;
import gov.omsb.superset.dashboard.service.RoleDashboardConfigLocalService;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;

/**
 * @author himanshu.nimavat
 * 
 * The Class OmsbDashboardMVCRenderCommand.
 * 
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbDashboardWebPortletKeys.OMSBDASHBOARDWEB,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class OmsbDashboardMVCRenderCommand implements MVCRenderCommand {
	
	private ConfigurationProvider configurationProvider;
	
	@Reference
	private RoleDashboardConfigLocalService roleDashboardConfigLocalService;
	
	@Reference
	private TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;
	
	@Reference
	private RoleLocalService roleLocalSerice;
	
	@Reference
	private OMSBCommonApi oMSBCommonApi;
	
	@Reference(unbind = "-")
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}
	
	private static final Log log = LogFactoryUtil.getLog(OmsbDashboardWebPortlet.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long[] roleIds = themeDisplay.getUser().getRoleIds();
		long userId = themeDisplay.getUserId();
		
		OmsbDomainSupersetDashboardConfiguration domainConfiguration = null;
		OmsbAccessTokenSupersetDashboardConfiguration loginConfiguration = null;
		String dashboardId = "";
		long programDurationId = 0;
		long workSectorId = 0;
		boolean isError = false;
		boolean isVehpcUser = false;
		
		try {
			domainConfiguration = configurationProvider.getSystemConfiguration(OmsbDomainSupersetDashboardConfiguration.class);
			log.debug("API BASE URL----------->" + domainConfiguration.getApiBaseURL());
			log.debug("API LOGIN URL----------->" + domainConfiguration.getApiLogin());
			log.debug("API TOKEN URL----------->" + domainConfiguration.getApiGuestToken());
			
			loginConfiguration = configurationProvider.getSystemConfiguration(OmsbAccessTokenSupersetDashboardConfiguration.class);
			log.debug("Username----------->" + loginConfiguration.getUserName());
			log.debug("Password----------->" + loginConfiguration.getPassword());
			log.debug("Provider----------->" + loginConfiguration.getProvider());
			
			List<RoleDashboardConfig> roleConfigs =  roleDashboardConfigLocalService.getRoleDashboardConfigs(-1, -1);
			
			for(RoleDashboardConfig roleConfig : roleConfigs) {
				if(containsRoleId(roleConfig.getRoleId(), roleIds)) {
					dashboardId = roleConfig.getDashboardId();
					break;
				}
			}
			log.debug("DashboardId----------->" + dashboardId);
			
			for(long roleId : roleIds) {
				if(roleLocalSerice.getRole(roleId).getName().equalsIgnoreCase(RoleNameConstants.EMPLOYER)) {
					workSectorId = oMSBCommonApi.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay, themeDisplay.getUserId(), "1");
					log.debug("workSectorId ----------->" +workSectorId);
				}
				
				if(roleLocalSerice.getRole(roleId).getName().equalsIgnoreCase(RoleNameConstants.VEHPC_ADMIN) 
					|| roleLocalSerice.getRole(roleId).getName().equalsIgnoreCase(RoleNameConstants.VEHPC_COMMITTEE)
					|| roleLocalSerice.getRole(roleId).getName().equalsIgnoreCase(RoleNameConstants.VEHPC_RAPPORTEUR)) {
					isVehpcUser = true;
				}
			}
			
			
			
			List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRels =  getTraineeAdmissionDetailsRelByTraineeId(userId);
			if(Validator.isNotNull(traineeAdmissionDetailsRels) && !traineeAdmissionDetailsRels.isEmpty()) {
				 programDurationId = traineeAdmissionDetailsRels.get(0).getProgramDurationId();
			}
			log.debug("ProgramDurationId----------->" + programDurationId);
			
			log.debug("UserID----------->" + userId);
			
		} catch (PortalException e) {
			log.error("Error " + e);
			renderRequest.setAttribute("errorMessage", "something-went-wrong");
			isError = true;
		} 
		
		if(dashboardId.isEmpty() || dashboardId.isBlank()) {
			renderRequest.setAttribute("errorMessage", "dashboard-not-exist");
			isError = true;
		}
		
		if(domainConfiguration != null && loginConfiguration != null) {
			renderRequest.setAttribute(OmsbDashboardWebPortletKeys.API_BASE_URL, domainConfiguration.getApiBaseURL());
			renderRequest.setAttribute(OmsbDashboardWebPortletKeys.API_LOGIN_URL, domainConfiguration.getApiLogin());
			renderRequest.setAttribute(OmsbDashboardWebPortletKeys.API_GUEST_TOKEN_URL, domainConfiguration.getApiGuestToken());
			
			renderRequest.setAttribute(OmsbDashboardWebPortletKeys.ADMIN_USERNAME, loginConfiguration.getUserName());
			renderRequest.setAttribute(OmsbDashboardWebPortletKeys.ADMIN_PASSWORD, loginConfiguration.getPassword());
			renderRequest.setAttribute(OmsbDashboardWebPortletKeys.PROVIDER, loginConfiguration.getProvider());
		}
		
		
		renderRequest.setAttribute(OmsbDashboardWebPortletKeys.ISREFRESHTOKEN, Boolean.FALSE);
		
		renderRequest.setAttribute(OmsbDashboardWebPortletKeys.DASHBOARD_ID, dashboardId);
		
		renderRequest.setAttribute(OmsbDashboardWebPortletKeys.USER_ID, themeDisplay.getUserId());
		renderRequest.setAttribute(OmsbDashboardWebPortletKeys.PROGRAM_DURATION_ID, programDurationId);
		renderRequest.setAttribute(OmsbDashboardWebPortletKeys.WORK_SECTOR_ID, workSectorId);
		
		renderRequest.setAttribute("isVehpcUser", isVehpcUser);
		
		renderRequest.setAttribute(OmsbDashboardWebPortletKeys.IS_ERROR, isError);
		
		return "/view.jsp";
	}
	
	private boolean containsRoleId(long roleId, long[] roleIdsToMatch) {
        for (long id : roleIdsToMatch) {
            if (id == roleId) {
                return true;
            }
        }
        return false;
    }

	private List<TraineeAdmissionDetailsRel> getTraineeAdmissionDetailsRelByTraineeId(long userId) {
		DynamicQuery dynamicQuery = traineeAdmissionDetailsRelLocalService.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("traineeId").eq(userId));
	    return traineeAdmissionDetailsRelLocalService.dynamicQuery(dynamicQuery);
	}

}
