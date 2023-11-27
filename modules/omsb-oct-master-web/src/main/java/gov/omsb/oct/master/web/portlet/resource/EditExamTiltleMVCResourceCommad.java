package gov.omsb.oct.master.web.portlet.resource;

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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OCTMasterConstants;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.EDIT_NEW_EXAM_TITLE }, service = MVCResourceCommand.class)
public class EditExamTiltleMVCResourceCommad extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		logger.info("EditExamTiltleMVCResourceCommad started");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long pickListId = ParamUtil.getLong(resourceRequest, "picklistID");
		long examTitlePrimaryID = ParamUtil.getLong(resourceRequest, "examTitlePrimaryID");
		String newValueTitleValue = ParamUtil.getString(resourceRequest, "newValueTitleValue");
		String newValueExamCode = ParamUtil.getString(resourceRequest, "newValueExamCode");
	
	
		Map<Locale, String> nameMap = new HashMap<>();
		Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
		Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
		String key = newValueTitleValue.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
		key = key.replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK);
		key = key.replace(StringPool.APOSTROPHE, StringPool.BLANK).replace(StringPool.COMMA, StringPool.BLANK).replace(StringPool.FORWARD_SLASH, StringPool.BLANK);
		nameMap.put(enLanguageLocale, newValueTitleValue);
		ListTypeDefinition listTypeDefinition;
		
		if (Validator.isNotNull(pickListId)) {
			listTypeDefinition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(MVCCommandNames.PL_OC_EXAM_TITLE_ERC,
							themeDisplay.getCompanyId());
			if (Validator.isNotNull(listTypeDefinition)) {
				ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(pickListId);
				if (Validator.isNotNull(listEntry)) {
					listEntry.setNameMap(nameMap);
					listEntry.setKey(key);
					listEntry.setName(newValueTitleValue);
					ListTypeEntryLocalServiceUtil.updateListTypeEntry(listEntry);
				}
			}
		}
		
		if (Validator.isNotNull(examTitlePrimaryID)) {
			Map<String, Serializable> values = new HashMap<>();
			values.put("code", newValueExamCode);
			commonApi.updateObjectEntryByERC(OCTMasterConstants.OC_Exam_TITLE_ERC, values,
					resourceRequest, themeDisplay, examTitlePrimaryID);
		}
		
		JSONObject object = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		object.put("success", "edit  successfully");
		resourceResponse.getWriter().write(jsonArray.toString());

		
	}

	private static final Log logger = LogFactoryUtil.getLog(EditExamTiltleMVCResourceCommad.class);
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
}
