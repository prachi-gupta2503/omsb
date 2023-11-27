package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.InstitutionMasterItems;
import omsb.vehpc.equivalency.dto.web.InstitutionMasters;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.GET_UNIVERSITY_LIST_RESOURCE }, service = MVCResourceCommand.class)
public class GetInstituteListByCountryMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("Inside GetInstituteListByCountryMVCResourceCommand Command");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long countryId = ParamUtil.getLong(resourceRequest, "issuedFrom");
			List<InstitutionMasters> institutionMastersList = getInstitutionMasterListByCountryId(themeDisplay, countryId);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			if (Validator.isNotNull(institutionMastersList) && institutionMastersList.size() > 0) {
				for (InstitutionMasters institutionMasters : institutionMastersList) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					ListTypeEntry universityListTypeEntry = commonApi.getListTypeEntryBylistTypeEntryId(institutionMasters.getUniversity());
					if(Validator.isNotNull(universityListTypeEntry)) {
						object.put("id", universityListTypeEntry.getListTypeEntryId());
						object.put("name", universityListTypeEntry.getName(themeDisplay.getLocale()));
						jsonArray.put(object);
					}
				}
			}
		
			resourceResponse.getWriter().print(jsonArray.toJSONString());
			return Boolean.FALSE;
		} catch (IOException e) {
			LOGGER.error("Error in getting University List" + e.getMessage());
			return Boolean.TRUE;
		}
		
	}
	
	private List<InstitutionMasters> getInstitutionMasterListByCountryId(ThemeDisplay themeDisplay, long countryId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.INSTITUTION_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=country"
				+ URLEncoder.encode(" eq " + countryId, StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url,StringPool.BLANK, commonApi.getHttpHeaderInfoAndBasicAuth());
		InstitutionMasterItems institutionMasterItems = CustomObjectMapperUtil.readValue(response, InstitutionMasterItems.class);
		if (Validator.isNotNull(institutionMasterItems) && institutionMasterItems.getItems().size() >0) {
			List<InstitutionMasters> institutionMastersList = institutionMasterItems.getItems();
			return institutionMastersList;
		}	
		return null;
	}


	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log LOGGER = LogFactoryUtil.getLog(GetInstituteListByCountryMVCResourceCommand.class);

}
