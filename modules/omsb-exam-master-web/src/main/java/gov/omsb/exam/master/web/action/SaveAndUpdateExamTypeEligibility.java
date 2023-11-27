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
		"mvc.command.name=" + MVCCommandNames.SAVE_EXAM_TYPE_MASTER_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveAndUpdateExamTypeEligibility implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		logger.info("SaveAndUpdateExamTypeEligibility started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String examTypeValue = ParamUtil.getString(actionRequest, "examTypeValue");
		logger.info("examTypeValue "+examTypeValue);
		String value_ar_SA = ParamUtil.getString(actionRequest, "ExamTypeEligibilityValue_ar_SA","");
		String value_en_US = ParamUtil.getString(actionRequest, "ExamTypeEligibilityValue_en_US","");
		
		logger.info("value_en_US "+value_en_US);
		
		ListTypeDefinition listTypeDefinition;
		
//		if (Validator.isNull(value_ar_SA) || Validator.isNull(value_en_US)) {
//			return false;
//		}else {
			
			Map<Locale, String> nameMap = new HashMap<>();
			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
			String key = value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK);
			nameMap.put(arLanguageLocale, value_ar_SA);
			nameMap.put(enLanguageLocale, value_en_US);
			ListTypeEntry examEligibilityEntry=null;
			try {
				listTypeDefinition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode(OmsbExamMasterWebPortletKeys.PL_EXAM_TYPE_ERC,
								themeDisplay.getCompanyId());
				if (Validator.isNotNull(listTypeDefinition)) {
					examEligibilityEntry =	ListTypeEntryLocalServiceUtil.addListTypeEntry(null,
							themeDisplay.getUserId(), listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
					
				}
				
				
//					Map<String, Serializable> values = new HashMap<>();
//					values.put("examEligibility", examEligibilityEntry.getKey());
//					values.put("examType", examTypeValue );
//					omsbCommonApi.addObjectEntryByERC("OMSB_Exam_Type_Eligibility_Mapping_ERC", values, actionRequest,
//							themeDisplay);
					logger.info("SaveAndUpdateExamTypeEligibility Ended");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
			
			
//		}	
		return false;
	}
	
	private static final Log logger = LogFactoryUtil.getLog(SaveAndUpdateExamTypeEligibility.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}
