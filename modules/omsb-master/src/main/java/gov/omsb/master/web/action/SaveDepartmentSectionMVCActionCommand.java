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
				+ MVCCommandNames.SAVE_DEPARTMENT_SECTION_MAPPING_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveDepartmentSectionMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		logger.info("SaveDepartmentSectionMVCActionCommand started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String department = ParamUtil.getString(actionRequest, "department");
		String sectionValue = ParamUtil.getString(actionRequest, "sectionValue");
		logger.info("sectionValue   "+sectionValue);
		logger.info("department   "+department);
		
		String value_ar_SA = ParamUtil.getString(actionRequest, "sectionValue_ar_SA");
		String value_en_US = ParamUtil.getString(actionRequest, "sectionValue_en_US");
		
		logger.info("value_en_US "+value_en_US);
		
		ListTypeDefinition listTypeDefinition;

			Map<Locale, String> nameMap = new HashMap<>();
			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
			String key=value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
			key = key.replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK);
			key = key.replace(StringPool.APOSTROPHE, StringPool.BLANK).replace(StringPool.COMMA, StringPool.BLANK).replace(StringPool.FORWARD_SLASH, StringPool.BLANK);
			nameMap.put(arLanguageLocale, value_ar_SA);
			nameMap.put(enLanguageLocale, value_en_US);
			ListTypeEntry sectionEntry=null;
			try {
				listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(MVCCommandNames.PL_SECTION, themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeDefinition)) {
					sectionEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(listTypeDefinition.getListTypeDefinitionId(),key);
					if(Validator.isNull(sectionEntry)) {
						sectionEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null, themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
					}
				}
					Map<String, Serializable> values = new HashMap<>();
					values.put("sectionId", sectionEntry.getKey());
					values.put("departmentId", department );
					omsbCommonApi.addObjectEntryByERC(MVCCommandNames.OBJ_DEPARTMENT_SECTION_MAPPING_ERC, values, actionRequest,
							themeDisplay);
					logger.info("Save Ended");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	}
	
	private static final Log logger = LogFactoryUtil.getLog(SaveDepartmentSectionMVCActionCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;


}
