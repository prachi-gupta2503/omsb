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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.ByLawConditionItem;
import gov.omsb.bylaw.rules.dto.ByLawRuleItem;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamtersItems;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name=" + MVCCommands.SAVE_BYLAW_RULES_CONDITION, }, service = MVCActionCommand.class)

public class SaveByLawRulesConditionMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.info("SaveByLawRulesConditionMVCActionCommand started........");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String ruleEngineModuleParameterId = ParamUtil.getString(actionRequest, "ruleEngineModuleParameterId"); // module Id 
		String moduleName="";
			try {
				 moduleName = getModuleNameById(themeDisplay, Long.valueOf(ruleEngineModuleParameterId));
			} catch (NumberFormatException | UnsupportedEncodingException e1) {
				logger.error("error in Module "+e1.getMessage());
			}
	
		String parameterType = ParamUtil.getString(actionRequest, "parameterName"); /// Module Name and selected Parameter Are Same 
		logger.info("parameterType "+parameterType);
		String enterValueInput = ParamUtil.getString(actionRequest, "enterValueInput"); 
		logger.info("enterValueInput "+enterValueInput);
		String parameterName = "";
		try {
			
			RuleEngineModuleParamtersItems  items = getParameterNameByParameterType(themeDisplay, parameterType);
			if (Validator.isNotNull(items) && Validator.isNotNull(items.getItems())
					&& !items.getItems().isEmpty()) {
				parameterName = items.getItems().get(0).getParameterName();
				logger.info("ParamterName  "+parameterName);
			}
		} catch (UnsupportedEncodingException | NumberFormatException e) {
			logger.error("Error While Fectching in parameter Type "+e.getMessage());
		}
		
		String conditionType = ParamUtil.getString(actionRequest, "conditionType");  // select In or Select In
		String[] conditionValues=null;
		String conditionValue=null;
		// based on condition Type We have Store
		if(MVCCommands.TYPE_IN.equalsIgnoreCase(conditionType)) {
			conditionValues = ParamUtil.getStringValues(actionRequest, "conditionValue");
		}else {
			conditionValue = ParamUtil.getString(actionRequest, "conditionValue");
		}
		
		logger.info("ruleEngineModuleParameterId :: " +  ruleEngineModuleParameterId);
		logger.info("parameterName :: " +  parameterName);
		logger.info("parameterType :: " +  conditionType);
		
		if(Validator.isNotNull(conditionValues)) {
			conditionValue = String.join(", ", conditionValues);
		}
		
		String conditionValueStr= parameterName+" "+ conditionType +" "+conditionValue+" "+enterValueInput;
		
		Map<String,Serializable> conditionMap=new HashMap<>();
		conditionMap.put("ruleEngineModuleParameterId", ruleEngineModuleParameterId);
		conditionMap.put("parameterName", parameterName);
		if(enterValueInput.isBlank() || enterValueInput.isEmpty() || enterValueInput == null || enterValueInput.trim().isEmpty() ) {
			conditionMap.put("conditionType", conditionType);
		}else {
			conditionMap.put("conditionType", enterValueInput);
		}
		conditionMap.put("value", conditionValue);
		conditionMap.put("conditionValue", conditionValueStr);
		conditionMap.put("moduleName", moduleName);
		long conditionKey =getLatestConditionKey(themeDisplay);
		logger.info("conditionKey"+conditionKey);
		conditionMap.put("conditionKey", conditionKey+1);
		conditionMap.put("moduleName", moduleName);
		
		commonApi.addObjectEntryByERC(MVCCommands.CONDITION_ERC, conditionMap, actionRequest, themeDisplay);
		actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.BY_LAW_CONDITION);
		return false;
	}
	
	public RuleEngineModuleParamtersItems getParameterNameByParameterType(ThemeDisplay themeDisplay, String parameterType)
			throws UnsupportedEncodingException {
		String ruleEngineUrl =  themeDisplay.getPortalURL() + MVCCommands.RULE_ENGINE_BY_LAW_OBJECT_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=parameterType" 
				+URLEncoder.encode(" eq " + "'"+ parameterType+ "'" , StandardCharsets.UTF_8);
		String ruleEngineUrlResponse = commonApi.getData(ruleEngineUrl);
		logger.info("ruleEngineUrl::" + ruleEngineUrl);
		logger.info("ruleEngineUrlResponse==============="+ruleEngineUrlResponse);
		return CustomObjectMapperUtil.readValue(ruleEngineUrlResponse, RuleEngineModuleParamtersItems.class);
	}
	
	public String getModuleNameById(ThemeDisplay themeDisplay, long ruleEngineModuleParameterId)
			throws UnsupportedEncodingException {
		String ruleEngineUrl =  themeDisplay.getPortalURL() + MVCCommands.RULE_ENGINE_BY_LAW_OBJECT_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id" 
				+URLEncoder.encode(" eq " + "'"+ ruleEngineModuleParameterId+ "'" , StandardCharsets.UTF_8);
		String ruleEngineUrlResponse = commonApi.getData(ruleEngineUrl);
		logger.info("ruleEngineUrl::" + ruleEngineUrl);
		logger.info("ruleEngineUrlResponse==============="+ruleEngineUrlResponse);
		RuleEngineModuleParamtersItems engineModuleParamtersItems = CustomObjectMapperUtil.readValue(ruleEngineUrlResponse, RuleEngineModuleParamtersItems.class);CustomObjectMapperUtil.readValue(ruleEngineUrlResponse, RuleEngineModuleParamtersItems.class);
		String moduleName = "";
		if(Validator.isNotNull(engineModuleParamtersItems)) {
			 moduleName= engineModuleParamtersItems.getItems().get(0).getModuleName();
		}
		return moduleName;
	}
	
	public long getLatestConditionKey(ThemeDisplay themeDisplay) {
		String byLawConditionUrl =  themeDisplay.getPortalURL() + MVCCommands.BY_LAW_CONDITION_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() +  StringPool.QUESTION  + MVCCommands.SORT_BY_ID_DESC;
		logger.info("byLawConditionUrl "+byLawConditionUrl);
		String response = commonApi.getData(byLawConditionUrl);
		logger.info("response"+response);
		ByLawConditionItem byLawConditionItem = CustomObjectMapperUtil.readValue(response, ByLawConditionItem.class);
		long conditionKey = 0l;
		if(Validator.isNotNull(byLawConditionItem)) {
			conditionKey= byLawConditionItem.getItems().get(0).getConditionKey();
		}
		return conditionKey;
	}

	
	private static final Log logger = LogFactoryUtil.getLog(SaveByLawRulesConditionMVCActionCommand.class);

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
}
