package gov.omsb.registration.web.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.InstitutionItems;
import gov.omsb.registration.web.dto.OMSBInstitutionMapping;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.GET_UNIVERSITY_DETAILS }, service = MVCResourceCommand.class)

public class GetUniversityDetailMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info("GetUniversityDetailMVCResourceCommand invoked---------");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long countryId = ParamUtil.getLong(resourceRequest, "country");
		JSONArray viewExams= getListSubSpecialityBySpecialityId(themeDisplay, countryId);

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		ObjectMapper obj = new ObjectMapper();
		obj.enable(SerializationFeature.INDENT_OUTPUT);
		String jsonList = obj.writeValueAsString(viewExams);
		logger.info(viewExams);
		jsonObj.put("university", viewExams);
		PrintWriter printWriter = resourceResponse.getWriter();
		printWriter.print(viewExams);

	}

	private JSONArray getListSubSpecialityBySpecialityId(ThemeDisplay themeDisplay, long countryId) {

		String url = themeDisplay.getPortalURL() + LRObjectURL.INSTITUTION_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=country"
				+ URLEncoder.encode(" eq " + countryId, StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		InstitutionItems examList = CustomObjectMapperUtil.readValue(response, InstitutionItems.class);
		logger.info(examList.getItems().size());
		JSONArray array=JSONFactoryUtil.createJSONArray();
		try {
			if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
					&& !examList.getItems().isEmpty()) {

				for (OMSBInstitutionMapping exam : examList.getItems()) {
					OMSBInstitutionMapping exam1 = exam;

					if (Validator.isNotNull(exam1) && Validator.isNotNull(exam1.getUniversity())) {
						List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil
								.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

						if (Validator.isNotNull(countries)) {
							ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
									.fetchListTypeEntry(exam1.getUniversity());
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
								logger.info("Jsonobject -->>"+jsonObject);
								array.put(jsonObject);
							}

						}
					}

				}
				return array;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	private long getGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			return group.getGroupId();
		}
		return 0;
	}

	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(GetUniversityDetailMVCResourceCommand.class);
}