package gov.omsb.exam.master.web.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
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
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_PROGRAM_TYPE_MASTER_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveProgramExamTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		logger.info("SaveAndUpdateExamTypeProgram started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String examTypeValue = ParamUtil.getString(actionRequest, "examType");
		String examTypePL = ParamUtil.getString(actionRequest, "examTypePL");
		logger.info("examTypeValue   "+examTypeValue);
		logger.info("examTypePL   "+examTypePL);
		
		long programType = ParamUtil.getLong(actionRequest, "programType");
		logger.info("programType "+programType);
		
		String value_ar_SA = ParamUtil.getString(actionRequest, "examType_ar_SA");
		String value_en_US = ParamUtil.getString(actionRequest, "examType_en_US");
		
		logger.info("value_en_US "+value_en_US);
		
		ListTypeDefinition listTypeDefinition;
		
//		if (Validator.isNull(value_ar_SA) || Validator.isNull(value_en_US)) {
//			return false;
//		}else {
			
//			Map<Locale, String> nameMap = new HashMap<>();
//			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
//			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
//			String key=value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK);
//			
//			nameMap.put(arLanguageLocale, value_ar_SA);
//			nameMap.put(enLanguageLocale, value_en_US);
//			ListTypeEntry examTypeEntry=null;
	
//				listTypeDefinition = ListTypeDefinitionLocalServiceUtil
//						.getListTypeDefinitionByExternalReferenceCode(OmsbExamMasterWebPortletKeys.PL_EXAM_TYPE_ERC,
//								themeDisplay.getCompanyId());
//				if (Validator.isNotNull(listTypeDefinition)) {
//					examTypeEntry =	ListTypeEntryLocalServiceUtil.addListTypeEntry(null,
//							themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
//				}
			try {
					Map<String, Serializable> values = new HashMap<>();
					values.put("examType", examTypePL);
					values.put("programTypeId", programType );
					omsbCommonApi.addObjectEntryByERC("Exam_Type_Master_ERC", values, actionRequest,
							themeDisplay);
					logger.info("SaveAndUpdateExamType Ended");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		return false;
	}
	
	private String replaceInputKey(String key) {
		
		key = key.replace(StringPool.DASH, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK)
				.replace(StringPool.COMMA, StringPool.BLANK).replace(StringPool.AMPERSAND, StringPool.BLANK);
		return key;
		
	}
	
	private static final Log logger = LogFactoryUtil.getLog(SaveProgramExamTypeMVCActionCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;


}
