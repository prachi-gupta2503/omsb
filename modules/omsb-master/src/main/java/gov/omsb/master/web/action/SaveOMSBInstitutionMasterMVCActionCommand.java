package gov.omsb.master.web.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
import gov.omsb.master.web.constants.OmsbExamMasterConstants;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.SAVE_INSTITUTION_MASTER_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveOMSBInstitutionMasterMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long country = ParamUtil.getLong(actionRequest, "country");
			
			String value_ar_SA = ParamUtil.getString(actionRequest, "institutionValue_ar_SA","");
			String value_en_US = ParamUtil.getString(actionRequest, "institutionValue_en_US","");
			Map<Locale, String> nameMap = new HashMap<>();
			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");

			nameMap.put(arLanguageLocale, value_ar_SA);
			nameMap.put(enLanguageLocale, value_en_US);
			String key = value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
			key = key.replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK);
			key = key.replace(StringPool.APOSTROPHE, StringPool.BLANK).replace(StringPool.COMMA, StringPool.BLANK).replace(StringPool.FORWARD_SLASH, StringPool.BLANK);

			ListTypeDefinition listTypeDefinition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(
							OmsbMasterPortletKeys.PL_UNIVERSITY_ERC, themeDisplay.getCompanyId());
			ListTypeEntry listTypeEntry = null;
			if (Validator.isNotNull(listTypeDefinition)) {
				listTypeEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(listTypeDefinition.getListTypeDefinitionId(),key);
				if(Validator.isNull(listTypeEntry)) {
					listTypeEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null, themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
				}
			}
		
		
		Map<String, Serializable> values = new HashMap<>();
		values.put(OmsbExamMasterConstants.OMSB_INSTITUTION_MASTER_COUNTRY, country);
		values.put(OmsbExamMasterConstants.OMSB_INSTITUTION_MASTER_UNIVERSITY, listTypeEntry.getListTypeEntryId());

		ObjectEntry objectEntry = omsbCommonApi.addObjectEntryByERC(
				OmsbExamMasterConstants.OMSB_Exam_INSTITUTIONS_MASTER_ERC, values, actionRequest, themeDisplay);
		if (Validator.isNull(objectEntry)) {
			SessionErrors.add(actionRequest, OmsbMasterPortletKeys.SET_INSTITUTION_MASTER_FORM_ERROR);
		}
		}
		 catch (Exception e) {
			SessionErrors.add(actionRequest, OmsbMasterPortletKeys.SET_INSTITUTION_MASTER_FORM_ERROR);
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(SaveOMSBInstitutionMasterMVCActionCommand.class);
}
