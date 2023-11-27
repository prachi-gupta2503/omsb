package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.CustomCountryItemResponse;
import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.EQUIVALENCY_REQUEST }, service = MVCRenderCommand.class)
public class EquivalencyRequestMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("Equivalency Request Render()>>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ListTypeDefinition definition = null;

		/* Profesion picklist dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Profession_ERC", PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("professionList", ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		/* Document Type pickList dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("documentTypeList", ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		/* Qualification pickList dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Qualification_ERC", PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("qualificationList", ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}	
		
		/* University pickList dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_UNIVERSITY_ERC", PortalUtil.getDefaultCompanyId());
			renderRequest.setAttribute("universityList", ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}	
		/*try {
			Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
			String getAllCountryURL = generateScopeListURL(LRObjectURL.ALL_COUNTRIES_URL, themeDisplay.getScopeGroupId());
			LOGGER.info("getAllCountryURL >>>>>>>"+getAllCountryURL);
			String customCountriesResponse = omsbHttpConnector.executeGet(getAllCountryURL, StringPool.BLANK, headersInfo);
			CustomCountryItemResponse countryItemResponse = CustomObjectMapperUtil.readValue(customCountriesResponse, CustomCountryItemResponse.class);
			if(Validator.isNotNull(countryItemResponse) && countryItemResponse.getItems().size() >0) {
				renderRequest.setAttribute("allNationalities", countryItemResponse.getItems());
			}
			
		} catch (NullPointerException e) {
			LOGGER.error(e.getMessage(), e);
		}*/
		
		List<Country> countries = countryLocalService.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("allNationalities", countries);
		
		LOGGER.info(" End Equivalency Request Render() >>>");
		return EquivalencyJSPPathConstants.EQUIVALENCY_REQUEST_JSP;
	}
	
	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private CountryLocalService countryLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyRequestMVCRenderCommand.class);

}
