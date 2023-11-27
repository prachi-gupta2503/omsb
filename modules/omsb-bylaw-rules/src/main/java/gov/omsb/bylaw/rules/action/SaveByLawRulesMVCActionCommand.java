package gov.omsb.bylaw.rules.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.ByLawRuleItem;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name=" + MVCCommands.SAVE_BYLAW_RULE, }, service = MVCActionCommand.class)
public class SaveByLawRulesMVCActionCommand  implements MVCActionCommand {

	private static final Log logger = LogFactoryUtil.getLog(SaveByLawRulesMVCActionCommand.class);
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String ruleEngineModuleParameterId = ParamUtil.getString(actionRequest, "ruleEngineModuleParameterId");
		String[] byLawConditions = ParamUtil.getStringValues(actionRequest, "byLawCondition");
		String matchAll = ParamUtil.getString(actionRequest, "matchAll");
		String moduleName = ParamUtil.getString(actionRequest, "moduleName");
		String equivalencyLevel = ParamUtil.getString(actionRequest, "byLawLevel");
		logger.info("equivalencyLevel"+equivalencyLevel);
		
		String conditionValue = String.join(",", byLawConditions);
		boolean ismatchAll=false;
		if(MVCCommands.MATCH_ALL.equalsIgnoreCase(matchAll)) {
			ismatchAll=true;
			
		}
		Map<String,Serializable> ruleMap=new HashMap<>();
		ruleMap.put("ruleEngineModuleParameterId", ruleEngineModuleParameterId);
		ruleMap.put("matchAll", ismatchAll);
		ruleMap.put("byLawConditionIds", conditionValue);
		ruleMap.put("moduleName", moduleName);
		long ruleKey =getLatestRuleKey(themeDisplay);
		logger.info("ruleKey"+ruleKey);
		ruleMap.put("ruleKey", ruleKey+1);
		if(Validator.isNotNull(equivalencyLevel)) {
			ruleMap.put("equivalencyLevel", equivalencyLevel);
		}else {
			ruleMap.put("equivalencyLevel", "N/A");
		}
		commonApi.addObjectEntryByERC(MVCCommands.BYLAW_RULE_ERC, ruleMap, actionRequest, themeDisplay);
		return false;
	}
	
	public long getLatestRuleKey(ThemeDisplay themeDisplay) {
		String byLawUrl =  themeDisplay.getPortalURL() + MVCCommands.BY_LAW_RULE_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() +  StringPool.QUESTION  + MVCCommands.SORT_BY_ID_DESC;
		logger.info("byLawUrl"+byLawUrl);
		String response = commonApi.getData(byLawUrl);
		logger.info("response"+response);
		ByLawRuleItem byLawRuleItem = CustomObjectMapperUtil.readValue(response, ByLawRuleItem.class);
		long ruleKey = 0l;
		if(Validator.isNotNull(byLawRuleItem)) {
			ruleKey= byLawRuleItem.getItems().get(0).getRuleKey();
		}
		return ruleKey;
	}
	
	
	
		@Reference(unbind = "-")
		private OMSBCommonApi commonApi;
	
	


}
