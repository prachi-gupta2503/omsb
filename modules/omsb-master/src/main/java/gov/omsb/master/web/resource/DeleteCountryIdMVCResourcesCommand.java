package gov.omsb.master.web.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.COUNTRY_DELETE_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class DeleteCountryIdMVCResourcesCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("DeleteCountryIdMVCResourcesCommand started ( ");
		String id = ParamUtil.getString(resourceRequest, "primaryCountryId");
		logger.info("primaryCountryId "+id);
		try {
		long countryIdToDelete = Long.parseLong(id);
		Country countryToDelete = countryLocalService.getCountry(countryIdToDelete);
		countryLocalService.deleteCountry(countryToDelete);
		JSONObject object = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		object.put("success", "deleted successfully");
		resourceResponse.getWriter().write(jsonArray.toString());
		}catch (Exception e) {
			logger.error("error while Deleting the Country"+e.getMessage());
		}
		
		
	}
	

	
	
	private static final Log logger = LogFactoryUtil.getLog(DeleteCountryIdMVCResourcesCommand.class);
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private CountryLocalService countryLocalService;

}
