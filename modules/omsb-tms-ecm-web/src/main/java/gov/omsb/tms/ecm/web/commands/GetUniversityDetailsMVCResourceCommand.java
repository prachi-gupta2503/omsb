package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.dto.InstitutionItems;
import gov.omsb.tms.ecm.web.dto.OMSBInstitutionMapping;


@Component(immediate = true, property = { "javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.GET_UNIVERSITY_DETAILS }, service = MVCResourceCommand.class)

public class GetUniversityDetailsMVCResourceCommand extends BaseMVCResourceCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(GetUniversityDetailsMVCResourceCommand.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		LOGGER.info("GetUniversityDetailMVCResourceCommand invoked---------");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long countryId = ParamUtil.getLong(resourceRequest, "issuingAuthorityCountryName");
		JSONArray universityList= getUniversityListByCountryId(themeDisplay, countryId);
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		ObjectMapper obj = new ObjectMapper();
		obj.enable(SerializationFeature.INDENT_OUTPUT);
		String jsonList = obj.writeValueAsString(universityList);
		LOGGER.info(countryId);
		LOGGER.info(universityList);
		jsonObj.put("university", universityList);
		PrintWriter printWriter = resourceResponse.getWriter();
		printWriter.print(universityList);

	}

	private JSONArray getUniversityListByCountryId(ThemeDisplay themeDisplay, long countryId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.INSTITUTION_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=country"
				+ URLEncoder.encode(" eq " + countryId, StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		InstitutionItems institutionItems = CustomObjectMapperUtil.readValue(response, InstitutionItems.class);
		LOGGER.info(institutionItems.getItems().size());
		JSONArray array=JSONFactoryUtil.createJSONArray();
		try {
			if (Validator.isNotNull(institutionItems) && Validator.isNotNull(institutionItems.getItems())
					&& !institutionItems.getItems().isEmpty()) {

				for (OMSBInstitutionMapping  institution: institutionItems.getItems()) {
					OMSBInstitutionMapping university = institution;

					if (Validator.isNotNull(university) && Validator.isNotNull(university.getUniversity())) {
						List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil
								.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

						if (Validator.isNotNull(countries)) {
							ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
									.fetchListTypeEntry(university.getUniversity());
							if (Validator.isNotNull(listEntry)) {
								Map<Locale, String> nameMap = listEntry.getNameMap();
								
								String en_Name = StringPool.BLANK, ar_Name = StringPool.BLANK;

								Locale en_LanguageLocale = LocaleUtil
										.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
								en_Name = nameMap.get(en_LanguageLocale);

								Locale ar_LanguageLocale = LocaleUtil
										.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
								ar_Name = nameMap.get(ar_LanguageLocale);

								JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
								jsonObject.put("arabicName",ar_Name);
								jsonObject.put("englishName",en_Name);
								jsonObject.put("externalReferenceCode",listEntry.getExternalReferenceCode());
								jsonObject.put("id",listEntry.getListTypeEntryId());
								LOGGER.info("Jsonobject -->>"+jsonObject);
								array.put(jsonObject);
							}

						}
					}

				}
				return array;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
		
		
	}


