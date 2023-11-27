package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.ProfessionSpecialtyMapping;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB, "mvc.command.name="
				+ MVCCommandNames.EQUIVALENCY_PERSON_POPPULATE_TO_FORM }, service = MVCResourceCommand.class)
public class EquivalencyPersonPopulateToFormMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		LOGGER.info("getPersonalDetails >Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		String dfrn = ParamUtil.getString(resourceRequest, "dfrn");
		JSONObject personDetails = JSONFactoryUtil.createJSONObject();
		JSONArray personAllDetails = equivalencyUtil.getPersonalDetails(personId, dfrn, themeDisplay, resourceRequest,
				resourceResponse);
		String professionKey = personAllDetails.getJSONObject(0).getString("profession");

		ListTypeEntry professionListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
				OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC, professionKey, themeDisplay.getCompanyId());
		long professionId = 0l;
		if (Validator.isNotNull(professionListTypeEntry)) {
			professionId = professionListTypeEntry.getListTypeEntryId();
		}
		List<ProfessionSpecialtyMapping> professionSpecialtyMappingList = equivalencyUtil
				.getProfessionSpecialtyMappingListByProfessionKey(professionId, themeDisplay);
		JSONArray specialtyListJsonArray = getspecialityListasJsonArray(professionSpecialtyMappingList, locale);

		JSONObject caseReport = equivalencyUtil.getCaseReportByPersonId(personId, themeDisplay);
		personDetails.put("personAllDetails", personAllDetails);
		if (Validator.isNotNull(specialtyListJsonArray)) {
			personDetails.put("specialtyListJsonArray", specialtyListJsonArray);
		}
		personDetails.put("caseReport", caseReport);
		resourceResponse.getWriter().write(personDetails.toJSONString());
	}

	private JSONArray getspecialityListasJsonArray(List<ProfessionSpecialtyMapping> professionSpecialtyMappingList,
			Locale locale) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		if (Validator.isNotNull(professionSpecialtyMappingList) && professionSpecialtyMappingList.size() > 0) {
			for (ProfessionSpecialtyMapping professionSpecialtyMapping : professionSpecialtyMappingList) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				ListTypeEntry specialtyListTypeEntry = omsbCommonApi
						.getListTypeEntryBylistTypeEntryId(professionSpecialtyMapping.getSpeciality());
				if (Validator.isNotNull(specialtyListTypeEntry)) {
					object.put("id", specialtyListTypeEntry.getListTypeEntryId());
					object.put("name", specialtyListTypeEntry.getName(locale));
					jsonArray.put(object);
				}
			}
			return jsonArray;
		}
		return null;
	}

	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private HeaderUtil headerUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyPersonPopulateToFormMVCResourceCommand.class);
}
