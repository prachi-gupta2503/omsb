/**
 * 
 */
package gov.omsb.superset.dashboard.configuration.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;

import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.superset.dashboard.configuration.api.OmsbDomainSupersetDashboardConfiguration;
import gov.omsb.superset.dashboard.configuration.constants.OmsbSupersetDashboardConfigurationConstants;

/**
 * @author Niddhi Thacker
 *
 */
public class DashboardWebServiceUtil {

	private static final Log log = LogFactoryUtil.getLog(DashboardWebServiceUtil.class);
	private static OMSBHttpConnector omsbHttpConnector;
	private static ConfigurationProvider configurationProvider;
	
	private DashboardWebServiceUtil() {}
	
	public static void setDashboardWebServiceParams(OMSBHttpConnector omsbHttpConnector, ConfigurationProvider configurationProvider) {
		DashboardWebServiceUtil.omsbHttpConnector = omsbHttpConnector;
		DashboardWebServiceUtil.configurationProvider = configurationProvider;
	}
	
	public static JSONArray getDashboardIds() {
		log.info("::: DashboardWebServiceUtil >>> getDashboardIds ::: ");
		JSONArray dashboardArr = null;
		
		try {
			OmsbDomainSupersetDashboardConfiguration domainConfiguration = null;
			domainConfiguration = configurationProvider.getSystemConfiguration(OmsbDomainSupersetDashboardConfiguration.class);
			// Step 1 : Fetching ids
			String response = omsbHttpConnector.executeGet(domainConfiguration.getApiBaseURL() + domainConfiguration.getDashboardContextPath(), StringPool.BLANK, new HashMap<>());
			if (Validator.isNotNull(response)) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response);
				JSONArray jsonArray = jsonObject.getJSONArray(OmsbSupersetDashboardConfigurationConstants.RESULT);
				dashboardArr = JSONFactoryUtil.createJSONArray();
				JSONObject dashboardObj = null;
				
				for (int i = 0; i < jsonArray.length(); i++) {
					// Step 1 : Fetching UUID
					dashboardObj = JSONFactoryUtil.createJSONObject();
					JSONObject resultObj = jsonArray.getJSONObject(i);
					String dashboardTitle = resultObj.getString(OmsbSupersetDashboardConfigurationConstants.DASHBOARD_TITLE);
					String dashboardId = String.valueOf(resultObj.getInt(OmsbSupersetDashboardConfigurationConstants.ID));
					String url = domainConfiguration.getApiBaseURL() + domainConfiguration.getEmbeddedDashboardContextPath().replace(OmsbSupersetDashboardConfigurationConstants.ID_PLACEHOLDER, dashboardId);
					response = omsbHttpConnector.executeGet(url, StringPool.BLANK, new HashMap<>());
					jsonObject = JSONFactoryUtil.createJSONObject(response);
					if (Validator.isNotNull(jsonObject.get(OmsbSupersetDashboardConfigurationConstants.RESULT))) {
						jsonObject = jsonObject.getJSONObject(OmsbSupersetDashboardConfigurationConstants.RESULT);
						dashboardObj.put(OmsbSupersetDashboardConfigurationConstants.VALUE,jsonObject.getString(OmsbSupersetDashboardConfigurationConstants.UUID));
						dashboardObj.put(OmsbSupersetDashboardConfigurationConstants.LABEL,dashboardTitle);
						dashboardArr.put(dashboardObj);
					}
				}

			}
		} catch (JSONException | ConfigurationException e) {
			log.error("::: DashboardWebServiceUtil >>> getDashboardIds >>> Error while fetching dashboard ids ::: " + e.getMessage(), e);
		}
		return dashboardArr;
	}
}
