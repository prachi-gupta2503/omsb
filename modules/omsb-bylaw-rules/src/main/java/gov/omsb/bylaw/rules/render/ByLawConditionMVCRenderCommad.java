package gov.omsb.bylaw.rules.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.ByLawCondition;
import gov.omsb.bylaw.rules.dto.ByLawConditionItem;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamters;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamtersItems;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
"mvc.command.name="+ MVCCommands.BY_LAW_CONDITION  }, service = MVCRenderCommand.class)
public class ByLawConditionMVCRenderCommad implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String byLawurl = themeDisplay.getPortalURL() + MVCCommands.RULE_ENGINE_BY_LAW_OBJECT_URL 
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
		
		logger.info(" byLawurl"+byLawurl);
		String response = commonApi.getData(byLawurl);
		logger.info("response  "+response);
		RuleEngineModuleParamtersItems ruleEngineModuleParamtersItems = CustomObjectMapperUtil.readValue(response, RuleEngineModuleParamtersItems.class);
		Set<String> uniqueNames = new HashSet<>();
		List<RuleEngineModuleParamters> uniqueObjectsList = new ArrayList<>();
		if(Validator.isNotNull(ruleEngineModuleParamtersItems)) {
			List <RuleEngineModuleParamters> ruleEngineModuleParamters=new ArrayList<>();
			ruleEngineModuleParamters = ruleEngineModuleParamtersItems.getItems();
			for (RuleEngineModuleParamters ruleEngineModuleParamter : ruleEngineModuleParamters) {
	            if (uniqueNames.add(ruleEngineModuleParamter.getModuleName())) {
	                uniqueObjectsList.add(ruleEngineModuleParamter);
	            }
	        }
		}
		
		renderRequest.setAttribute("ruleEngineModuleParamters", uniqueObjectsList);
		
		String byLawConditionurl = themeDisplay.getPortalURL() + MVCCommands.BY_LAW_CONDITION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() +  StringPool.QUESTION  + MVCCommands.SORT_BY_ID_ASC;
		
		String byLawConditionRespone = commonApi.getData(byLawConditionurl);
		logger.info("url "+byLawConditionurl);
		logger.info("bylawConditionResponnse"+byLawConditionRespone);
		
		ByLawConditionItem byLawConditionItems = CustomObjectMapperUtil.readValue(byLawConditionRespone, ByLawConditionItem.class);
		
		if (Validator.isNotNull(byLawConditionItems)) {
			List<ByLawCondition> byLawConditions = new ArrayList<>();
			for (ByLawCondition byLawCondition : byLawConditionItems.getItems()) {
				ByLawCondition condition = new ByLawCondition();
				condition.setModuleName(byLawCondition.getModuleName());
				condition.setConditionValue(byLawCondition.getConditionValue());
				condition.setId(byLawCondition.getId());
				condition.setConditionKey(byLawCondition.getConditionKey());
				byLawConditions.add(condition);
			}
			renderRequest.setAttribute("byLawConditions", byLawConditions);
		}
		
		return MVCCommands.BY_LAW_CONDITION_JSP;
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	private static final Log logger = LogFactoryUtil.getLog(ByLawHomeMVCRenderCommand.class);


}
