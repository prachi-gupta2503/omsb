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
import omsb.vehpc.equivalency.dto.web.ProfessionSpecialtyMapping;
import omsb.vehpc.equivalency.dto.web.ProfessionSpecialtyMappingItems;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.GET_SPECIALTY_LIST_RESOURCE }, service = MVCResourceCommand.class)
public class GetPrimarySpecialtyByProfessionMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("Inside GetInstituteListByCountryMVCResourceCommand Command");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String professionKey = ParamUtil.getString(resourceRequest, "profession");
			ListTypeEntry professionListTypeEntry = commonApi.getListTypeEntryByListTypeItemKey(OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC, professionKey, themeDisplay.getCompanyId());
			long professionId =0l;
			if(Validator.isNotNull(professionListTypeEntry)) {
				professionId = professionListTypeEntry.getListTypeEntryId();
			}
			List<ProfessionSpecialtyMapping> professionSpecialtyMappingList = equivalencyUtil.getProfessionSpecialtyMappingListByProfessionKey(professionId,themeDisplay);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			if (Validator.isNotNull(professionSpecialtyMappingList) && professionSpecialtyMappingList.size() > 0) {
				for (ProfessionSpecialtyMapping professionSpecialtyMapping : professionSpecialtyMappingList) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					ListTypeEntry specialtyListTypeEntry = commonApi.getListTypeEntryBylistTypeEntryId(professionSpecialtyMapping.getSpeciality());
					if(Validator.isNotNull(specialtyListTypeEntry)) {
						object.put("id", specialtyListTypeEntry.getListTypeEntryId());
						object.put("name", specialtyListTypeEntry.getName(themeDisplay.getLocale()));
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
	
	@Reference
	private EquivalencyUtil equivalencyUtil ;
	
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log LOGGER = LogFactoryUtil.getLog(GetPrimarySpecialtyByProfessionMVCResourceCommand.class);

}
