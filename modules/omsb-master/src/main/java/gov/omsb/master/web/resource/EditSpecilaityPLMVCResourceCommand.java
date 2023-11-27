package gov.omsb.master.web.resource;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
				+ MVCCommandNames.EDIT_OMSB_EXAM_SPECIALITY_MASTER_DETAILS}, service = MVCResourceCommand.class)
public class EditSpecilaityPLMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = ParamUtil.getLong(resourceRequest, "specialityPrimaryID");
		long listTypeEntryId = Long.valueOf(id);
		String value = ParamUtil.getString(resourceRequest, "newValue");
		logger.info("new value"+value);
		logger.info("id"+id);
		
		Map<Locale, String> nameMap = new HashMap<>();
		Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
		Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
		String key = value.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
		key = key.replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK);
		key = key.replace(StringPool.APOSTROPHE, StringPool.BLANK).replace(StringPool.COMMA, StringPool.BLANK).replace(StringPool.FORWARD_SLASH, StringPool.BLANK);
		nameMap.put(enLanguageLocale, value);
		nameMap.put(arLanguageLocale, value);
		ListTypeDefinition listTypeDefinition;
		
		if (Validator.isNotNull(id)) {
			listTypeDefinition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(MVCCommandNames.PL_SPECIALITY,
							themeDisplay.getCompanyId());
			if (Validator.isNotNull(listTypeDefinition)) {
				ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(id);
				if (Validator.isNotNull(listEntry)) {
					listEntry.setNameMap(nameMap);
					listEntry.setKey(key);
					listEntry.setName(value);
					ListTypeEntryLocalServiceUtil.updateListTypeEntry(listEntry);
				}
			}
		}

		JSONObject object = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		object.put("success", "edit  successfully");
		resourceResponse.getWriter().write(jsonArray.toString());

		
	}
	
	private static final Log logger = LogFactoryUtil.getLog(ProfessionSpecialityMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}
