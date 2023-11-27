package gov.omsb.bylaw.rules.util;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.dto.ByLawCondition;
import gov.omsb.bylaw.rules.dto.ByLawConditionItem;
import gov.omsb.bylaw.rules.dto.ByLawRule;
import gov.omsb.bylaw.rules.dto.ByLawRuleItem;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamters;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamtersItems;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, service = ByLawUtil.class)
public class ByLawUtil {

	
	public RuleEngineModuleParamters getRuleEngineModuleParamtersById(ThemeDisplay themeDisplay,long id) {
		String ruleEngineUrl =  themeDisplay.getPortalURL() + MVCCommands.RULE_ENGINE_BY_LAW_OBJECT_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id" 
				+URLEncoder.encode(" eq " + "'"+ id+ "'" , StandardCharsets.UTF_8);
		String ruleEngineUrlResponse = commonApi.getData(ruleEngineUrl);
		logger.info("ruleEngineUrl::" + ruleEngineUrl);
		logger.info("ruleEngineUrlResponse==============="+ruleEngineUrlResponse);
		RuleEngineModuleParamtersItems ruleEngineModuleParamtersItems = CustomObjectMapperUtil.readValue(ruleEngineUrlResponse, RuleEngineModuleParamtersItems.class);
		if(Validator.isNotNull(ruleEngineModuleParamtersItems) && Validator.isNotNull(ruleEngineModuleParamtersItems.getItems())  && !ruleEngineModuleParamtersItems.getItems().isEmpty()) {
			return  ruleEngineModuleParamtersItems.getItems().get(0);
		}
		return null;
	}
	
	public List<ByLawCondition> getByLawConditionByModuleName(ThemeDisplay themeDisplay, String moduleName) {
		
		
		String byRuleConditionUrl =  themeDisplay.getPortalURL() + LRObjectURL.BYLAW_CONDITION_OBJECT_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
			themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=moduleName" 
				+URLEncoder.encode(" eq " + "'"+ moduleName+ "'" , StandardCharsets.UTF_8);
		String byRuleConditionResponse = commonApi.getData(byRuleConditionUrl);
		logger.info("byRuleConditionUrl::" + byRuleConditionUrl);
		logger.info("byRuleConditionResponse==============="+byRuleConditionResponse);
		ByLawConditionItem byLawConditionItem = CustomObjectMapperUtil.readValue(byRuleConditionResponse, ByLawConditionItem.class);
		if(Validator.isNotNull(byLawConditionItem) && Validator.isNotNull(byLawConditionItem.getItems())) {
			return  byLawConditionItem.getItems();
		}
		return new ArrayList<>();
	}
	
	public ByLawCondition getByLawConditionById(ThemeDisplay themeDisplay, long id) {
		
		
		String byRuleConditionUrl =  themeDisplay.getPortalURL() + LRObjectURL.BYLAW_CONDITION_OBJECT_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
			themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id" 
				+URLEncoder.encode(" eq " + "'"+ id+ "'" , StandardCharsets.UTF_8);
		String byRuleConditionResponse = commonApi.getData(byRuleConditionUrl);
		logger.info("byRuleConditionUrl::" + byRuleConditionUrl);
		logger.info("byRuleConditionResponse==============="+byRuleConditionResponse);
		ByLawConditionItem byLawConditionItem = CustomObjectMapperUtil.readValue(byRuleConditionResponse, ByLawConditionItem.class);
		if(Validator.isNotNull(byLawConditionItem) && Validator.isNotNull(byLawConditionItem.getItems()) && !byLawConditionItem.getItems().isEmpty()) {
			return  byLawConditionItem.getItems().get(0);
		}
		return null;
	}
	
	
	public List<ByLawRule> getByLawRules(ThemeDisplay themeDisplay) {
		String byLawRulesUrl =themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + MVCCommands.SORT_BY_ID_DESC;
		
		String byLawRulesResponse = commonApi.getData(byLawRulesUrl);
		logger.info("byLawRulesUrl::" + byLawRulesUrl);
		logger.info("byLawRulesResponse==============="+byLawRulesResponse);
		ByLawRuleItem byLawRuleItem = CustomObjectMapperUtil.readValue(byLawRulesResponse, ByLawRuleItem.class);
		if(Validator.isNotNull(byLawRuleItem) && Validator.isNotNull(byLawRuleItem.getItems())) {
			return  byLawRuleItem.getItems();
		}
		return new ArrayList<>();
	}
	
	public String getListTypeEntryByListTypeItemKey(String listTypItemeKey, ThemeDisplay themeDisplay) {
        try {
            List<ListTypeDefinition> definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitions(-1, -1);
            if (Validator.isNotNull(definition)) {
                for(ListTypeDefinition listTypeDefinition : definition) {
             ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(listTypeDefinition.getListTypeDefinitionId(),
                        listTypItemeKey);
					if (listTypeEntry.getKey().contains("ListTypeEntryKey")) {
						return listTypeEntry.getName(themeDisplay.getLocale());
					}
				}
			}
		} catch (PortalException e) {
			logger.error("error " + e.getMessage());
		}
		return "";
    }
	
	
	private static final Log logger = LogFactoryUtil.getLog(ByLawUtil.class);

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
}
