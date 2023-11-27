package gov.omsb.master.web.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.SAVE_SECTION_MAPPING_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveSectionFunctionMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		logger.info("SaveDepartmentSectionMVCActionCommand started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String section = ParamUtil.getString(actionRequest, "section");
		String functionValue = ParamUtil.getString(actionRequest, "functionValue");
		logger.info("functionValue   "+functionValue);
		logger.info("section   "+section);
		String value_ar_SA = ParamUtil.getString(actionRequest, "functionValue_ar_SA");
		String value_en_US = ParamUtil.getString(actionRequest, "functionValue_en_US");
		logger.info("value_en_US "+value_en_US);
		
		String function = ParamUtil.getString(actionRequest, "function");
		String committe = ParamUtil.getString(actionRequest, "committeValue");
		logger.info("functionValue   "+functionValue);
		logger.info("section   "+section);
		logger.info("committeValue   "+committe);
		logger.info("function   "+function);
		String committe_value_ar_SA = ParamUtil.getString(actionRequest, "committeValue_ar_SA");
		String committe_value_en_US = ParamUtil.getString(actionRequest, "committeValue_en_US");
		
		logger.info(" key value_en_US "+value_en_US);
		logger.info("committe_value_en_US "+committe_value_en_US);
		ListTypeDefinition listTypeDefinition;
		ListTypeDefinition listTypeDefinitionCommitte;

		Map<Locale, String> nameMap = new HashMap<>();
		Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
		Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");

		String key = value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
		key = key.replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK);
		key = key.replace(StringPool.APOSTROPHE, StringPool.BLANK).replace(StringPool.COMMA, StringPool.BLANK).replace(StringPool.FORWARD_SLASH, StringPool.BLANK);
		nameMap.put(arLanguageLocale, value_ar_SA);
		nameMap.put(enLanguageLocale, value_en_US);
		ListTypeEntry functionEntry=null;

		Map<Locale, String> nameMapCommitte = new HashMap<>();
		Locale arLanguageLocale1 = LocaleUtil.fromLanguageId("ar_SA");
		Locale enLanguageLocale1 = LocaleUtil.fromLanguageId("en_US");

		String keyCommittee=committe_value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
		logger.info("keyCommittee "+keyCommittee);
		nameMapCommitte.put(arLanguageLocale1, committe_value_ar_SA);
		nameMapCommitte.put(enLanguageLocale1, committe_value_en_US);
		ListTypeEntry committeeEntry=null;
		try {
			if(!key.isEmpty() && !key.isBlank() ) {
			listTypeDefinition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(MVCCommandNames.PL_FUNCTION,
							themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeDefinition)) {
					functionEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(listTypeDefinition.getListTypeDefinitionId(),key);
					if(Validator.isNull(functionEntry)) {
						functionEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null, themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
					}
				}
			}

			if(!keyCommittee.isEmpty() && !keyCommittee.isBlank() ) {
			listTypeDefinitionCommitte = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(MVCCommandNames.PL_COMMITTEE,
							themeDisplay.getCompanyId());

				if (Validator.isNotNull(listTypeDefinitionCommitte)) {
					committeeEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(listTypeDefinitionCommitte.getListTypeDefinitionId(),key);
					if(Validator.isNull(committeeEntry)) {
						committeeEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null, themeDisplay.getUserId(), listTypeDefinitionCommitte.getListTypeDefinitionId(), keyCommittee, nameMapCommitte);
					}
				}
			}
				Map<String, Serializable> values = new HashMap<>();

				if( Validator.isNotNull(functionEntry)) {
					values.put("functionId", functionEntry.getKey());
				}else {
					values.put("functionId", function);
				}
				values.put("sectionId", section);
				if(Validator.isNotNull(committeeEntry)) {
					values.put("committeeId", committeeEntry.getKey());
				}else {
					values.put("committeeId", "");
				}
				omsbCommonApi.addObjectEntryByERC(MVCCommandNames.OBJ_FUNCTION_SECTION_COMMITTE_ERC, values, actionRequest,
						themeDisplay);
				logger.info("Save Ended");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	}
	
	private static final Log logger = LogFactoryUtil.getLog(SaveSectionFunctionMVCActionCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;


}
