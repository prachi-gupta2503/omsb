package gov.omsb.superset.dashboard.configuration.portlet.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;

import gov.omsb.superset.dashboard.configuration.constants.OmsbSupersetDashboardConfigurationConstants;
import gov.omsb.superset.dashboard.model.RoleDashboardConfig;
import gov.omsb.superset.dashboard.service.RoleDashboardConfigLocalService;


public class RolesDashboardConfigUtil {

	private static final Log log = LogFactoryUtil.getLog(RolesDashboardConfigUtil.class);
	private static RoleLocalService roleLocalService;
	private static RoleDashboardConfigLocalService roleDashboardConfigLocalService;
	
	private RolesDashboardConfigUtil() {}
	
	public static void setRolesDashboardConfigParams(RoleLocalService roleLocalService, RoleDashboardConfigLocalService roleDashboardConfigLocalService) {
		RolesDashboardConfigUtil.roleLocalService = roleLocalService;
		RolesDashboardConfigUtil.roleDashboardConfigLocalService = roleDashboardConfigLocalService;
	}
	
	public static JSONArray getRoles(ThemeDisplay themeDisplay){
		log.info("::: RolesDashboardConfigUtil >>> getRoles >>> getting liferay roles :::");
		JSONArray roleArr = JSONFactoryUtil.createJSONArray();
		JSONObject roleObj = null;
		List<Role> roles = roleLocalService.getRoles(themeDisplay.getCompanyId());
		if(!roles.isEmpty()) {
			for(Role role : roles) {
				roleObj = JSONFactoryUtil.createJSONObject();
				roleObj.put(OmsbSupersetDashboardConfigurationConstants.VALUE, role.getRoleId());
				roleObj.put(OmsbSupersetDashboardConfigurationConstants.LABEL, role.getName());
				
				roleArr.put(roleObj);
			}
		}
		return roleArr;
	}
	
	public static boolean saveRolesDashboardConfig(ActionRequest request, ThemeDisplay themeDisplay) {
		boolean isSavedSuccess = Boolean.TRUE;
		log.info("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> saving role dashboard config in db :::");
		
		deleteRoleDashboardConfigs(request);
		
		int rolesDashboardConfigRowLen = ParamUtil.getInteger(request, OmsbSupersetDashboardConfigurationConstants.ROLES_DASHBOARD_CONFIG_ROW_LENGTH);
		if (rolesDashboardConfigRowLen > 0) {
			for (int i = 1; i <= rolesDashboardConfigRowLen; i++) {
				long configId = ParamUtil.getLong(request, OmsbSupersetDashboardConfigurationConstants.CONFIG_ID + i);
				long roleId = ParamUtil.getLong(request, OmsbSupersetDashboardConfigurationConstants.ROLE + i);
				String dashboardId = ParamUtil.getString(request, OmsbSupersetDashboardConfigurationConstants.DASHBOARD_ID + i);
				
				log.info("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> ConfigId ::: " + configId);
				log.info("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> Role Name ::: " + roleId);
				log.info("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> Dashboard Id ::: " + dashboardId);

				try {
					RoleDashboardConfig roleDashboardConfig = null;
					if (configId > 0) {
						roleDashboardConfig = roleDashboardConfigLocalService.getRoleDashboardConfig(configId);
					} else {
						roleDashboardConfig = roleDashboardConfigLocalService.createRoleDashboardConfig(CounterLocalServiceUtil.increment());
						roleDashboardConfig.setCreatedDate(new Date());
						roleDashboardConfig.setCreatedBy(themeDisplay.getUserId());
					}
					roleDashboardConfig.setCompanyId(themeDisplay.getCompanyId());
					roleDashboardConfig.setGroupId(themeDisplay.getScopeGroupId());
					roleDashboardConfig.setUserId(themeDisplay.getUserId());
					roleDashboardConfig.setModifiedDate(new Date());
					roleDashboardConfig.setModifiedBy(themeDisplay.getUserId());
					roleDashboardConfig.setRoleId(roleId);
					roleDashboardConfig.setDashboardId(dashboardId);
					roleDashboardConfigLocalService.updateRoleDashboardConfig(roleDashboardConfig);
					log.info("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> Role dashboard config saved successfully in db :::");
				} catch (PortalException | SystemException e) {
					isSavedSuccess = Boolean.FALSE;
					log.error("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> Error occured while adding/editing role dashboard configuration ::: " + e.getMessage(), e);
				}
			}
		}
		return isSavedSuccess;
	}

	//deleting role based config rows
	private static void deleteRoleDashboardConfigs(ActionRequest request) {
		log.info("::: RolesDashboardConfigUtil >>> deleteRoleDashboardConfigs >>> deleting role dashboard config in db :::");
		String deletedConfigIds = ParamUtil.getString(request, OmsbSupersetDashboardConfigurationConstants.DELETED_CONFIG_IDS);
		if(Validator.isNotNull(deletedConfigIds)) {
			log.info("::: RolesDashboardConfigUtil >>> saveRolesDashboardConfig >>> deleting role dashboard config in db :::");
			List<Long> deletedIdList = Arrays.stream(deletedConfigIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
			for(long deletedId : deletedIdList) {
				try {
					roleDashboardConfigLocalService.deleteRoleDashboardConfig(deletedId);
				} catch (PortalException e) {
					log.error("::: RolesDashboardConfigUtil >>> deleteRoleDashboardConfigs >>> Error occured while deleting role dashboard configuration ::: " + e.getMessage(), e);
				}
			}
		}
	}
	
}
