package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.list.type.exception.DuplicateListTypeEntryException;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
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

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_OCT_EXAM_TITLE_DETAILS_SR }, service = MVCResourceCommand.class)
public class SaveExamTitleDetailsMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(SaveExamTitleDetailsMVCResourceCommand.class);

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		_log.info("Entry into SaveExamTitleDetailsMVCResourceCommand ::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean flag = false;

		String value_ar_SA = ParamUtil.getString(resourceRequest, "value_ar_SA");
		String value_en_US = ParamUtil.getString(resourceRequest, "value_en_US");

		if (Validator.isNull(value_ar_SA) || Validator.isNull(value_en_US)) {
			_log.info("Entry into if condition::");
		} else {
			String key = value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK);
			_log.info("Entry into else condition::");
			JSONArray response = JSONFactoryUtil.createJSONArray();
			JSONObject jsonData = JSONFactoryUtil.createJSONObject();
			Map<Locale, String> nameMap = new HashMap<>();
			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");

			nameMap.put(arLanguageLocale, value_ar_SA);
			nameMap.put(enLanguageLocale, value_en_US);
			try {
				ListTypeDefinition listTypeDefinition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode(OmsbOctExamWebPortletKeys.EXAM_TITLE_PL_ERC,
								themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeDefinition)) {
					ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null,
							themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
					if (Validator.isNotNull(listEntry)) {
						jsonData.put("status", "success");
						jsonData.put("key", key);
						jsonData.put("id", listEntry.getListTypeEntryId());
						jsonData.put("nameEnglish", value_en_US);
						jsonData.put("nameArabic", value_ar_SA);
						jsonData.put("externalReferenceCode", listEntry.getExternalReferenceCode());

					}
				}
			} catch (DuplicateListTypeEntryException e) {
				_log.error("DuplicateListTypeEntryException is generated");
				jsonData.put("status", "duplicate");
			} catch (PortalException e) {
				_log.error(e.getMessage());
				jsonData.put("status", "fail");
			}
			response.put(jsonData);
			resourceResponse.setContentType("application/json");
			PrintWriter writer = resourceResponse.getWriter();
			writer.println(jsonData.toString());
		}
	}

}