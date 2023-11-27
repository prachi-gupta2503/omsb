package gov.omsb.oct.master.web.portlet.action;

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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OCTMasterConstants;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.UPDATE_EXAM_TITLE_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class UpdateExamTitleMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long titleId = ParamUtil.getLong(actionRequest, "titleId");
		long objectId = ParamUtil.getLong(actionRequest, "objectId");
		String valueAr = ParamUtil.getString(actionRequest, "titleValue_ar_SA", "");
		String valueEn = ParamUtil.getString(actionRequest, "titleValue_en_US");
		String examCode = ParamUtil.getString(actionRequest, "examCode");
		if (Validator.isNull(valueEn) || Validator.isNull(examCode)) {
			logger.info("Entry into if condition::");
			return false;
		} else {
			Map<Locale, String> nameMap = new HashMap<>();
			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
			String key = valueEn.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK);
			nameMap.put(arLanguageLocale, valueAr);
			nameMap.put(enLanguageLocale, valueEn);
			ListTypeDefinition listTypeDefinition;
			try {

				if (Validator.isNotNull(titleId)) {
					listTypeDefinition = ListTypeDefinitionLocalServiceUtil
							.getListTypeDefinitionByExternalReferenceCode(OmsbOctMasterWebPortletKeys.EXAM_TITLE_PL_ERC,
									themeDisplay.getCompanyId());
					if (Validator.isNotNull(listTypeDefinition)) {
						ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(titleId);
						if (Validator.isNotNull(listEntry)) {
							listEntry.setNameMap(nameMap);
							ListTypeEntryLocalServiceUtil.updateListTypeEntry(listEntry);
						}
					}

					// updating object
					if (Validator.isNotNull(examCode)) {
						Map<String, Serializable> values = new HashMap<>();
						values.put(OCTMasterConstants.EXAM_TITLE_KEY, titleId);
						values.put(OCTMasterConstants.EXAM_CODE, examCode);
						if (objectId == 0) {
							omsbCommonApi.addObjectEntryByERC(OCTMasterConstants.OC_Exam_TITLE_ERC, values,
									actionRequest, themeDisplay);
						} else {
							omsbCommonApi.updateObjectEntryByERC(OCTMasterConstants.OC_Exam_TITLE_ERC, values,
									actionRequest, themeDisplay, objectId);

						}
					}
				} else {
					listTypeDefinition = ListTypeDefinitionLocalServiceUtil
							.getListTypeDefinitionByExternalReferenceCode(OmsbOctMasterWebPortletKeys.EXAM_TITLE_PL_ERC,
									themeDisplay.getCompanyId());
					long examTitleKey = 0l;
					if (Validator.isNotNull(listTypeDefinition)) {
						ListTypeEntry examTitleEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null,
								themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
						examTitleKey = examTitleEntry.getListTypeEntryId();
						logger.info("Exam title id +++++++++ " + examTitleKey);
					}
					if (examTitleKey > 0) {
						Map<String, Serializable> values = new HashMap<>();
						values.put(OCTMasterConstants.EXAM_TITLE_KEY, examTitleKey);
						values.put(OCTMasterConstants.EXAM_CODE, examCode);
						omsbCommonApi.addObjectEntryByERC(OCTMasterConstants.OC_Exam_TITLE_ERC, values, actionRequest,
								themeDisplay);
					}
				}
			} catch (PortalException e) {
				logger.error(e.getMessage());
			}
		}
		actionRequest.setAttribute("titleId", 0);
		actionResponse.getRenderParameters().setValue("titleId", "0");
		return true;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log logger = LogFactoryUtil.getLog(UpdateExamTitleMVCActionCommand.class);
}