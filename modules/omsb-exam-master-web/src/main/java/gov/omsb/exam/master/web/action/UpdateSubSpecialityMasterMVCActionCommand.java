package gov.omsb.exam.master.web.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;


@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.UPDATE_EXAM_SUB_SPECIALITY_MASTER_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class UpdateSubSpecialityMasterMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long titleId = ParamUtil.getLong(actionRequest, "titleId");
		logger.info("titleID::"+titleId);
		String value_ar_SA = ParamUtil.getString(actionRequest, "value_ar_SA");
		String value_en_US = ParamUtil.getString(actionRequest, "value_en_US");
//		if (Validator.isNull(value_ar_SA) || Validator.isNull(value_en_US)) {
//			return false;
//		} else {
		Map<Locale, String> nameMap = new HashMap<>();
		Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
		Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
		String key = value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK);
		nameMap.put(arLanguageLocale, value_ar_SA);
		nameMap.put(enLanguageLocale, value_en_US);

		ListTypeDefinition listTypeDefinition;
		try {

			if (Validator.isNotNull(titleId)) {
				listTypeDefinition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode(OmsbExamMasterWebPortletKeys.SUB_SPECIALITY_MASTER_PL_ERC,
								themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeDefinition)) {
					ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(titleId);
					if (Validator.isNotNull(listEntry)) {
						listEntry.setNameMap(nameMap);
						ListTypeEntryLocalServiceUtil.updateListTypeEntry(listEntry);
					}
				}
			} else {
				listTypeDefinition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode(OmsbExamMasterWebPortletKeys.SUB_SPECIALITY_MASTER_PL_ERC,
								themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeDefinition)) {
					ListTypeEntryLocalServiceUtil.addListTypeEntry(null,
							themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
				}
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		//}
		actionRequest.setAttribute("titleId", 0);
		actionResponse.getRenderParameters().setValue("titleId", "0");
		return true;
	}

	private static final Log logger = LogFactoryUtil.getLog(UpdateSubSpecialityMasterMVCActionCommand.class);
}