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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.ByLawCondition;
import gov.omsb.bylaw.rules.dto.ByLawRule;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamters;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamtersItems;
import gov.omsb.bylaw.rules.util.ByLawUtil;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name=/"  }, service = MVCRenderCommand.class)
public class ByLawHomeMVCRenderCommand implements MVCRenderCommand {

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
		
		
		CopyOnWriteArrayList<ByLawRule> byLawRules= new CopyOnWriteArrayList(byLawUtil.getByLawRules(themeDisplay));
		
		for( ByLawRule byLawRule: byLawRules) {
			String byLawConditionIds = byLawRule.getByLawConditionIds();
			boolean isMatchAll = byLawRule.isMatchAll();
			if(Validator.isNotNull(byLawConditionIds)) {
				
				String[] byLawConditionIdstr=byLawConditionIds.split(",");
				String conditionValue = getConditionValue(themeDisplay, isMatchAll, byLawConditionIdstr);
				byLawRule.setByLawCondition(conditionValue);
			}
			
		}
		
		
		renderRequest.setAttribute("ruleEngineModuleParamters", uniqueObjectsList);
		renderRequest.setAttribute("byLawRules", byLawRules);
		byLawRules.stream().forEach(e-> System.out.println(e.getByLawCondition()));
		return MVCCommands.BYLAW_RULES_JSP;
	}
	
	private String getConditionValue(ThemeDisplay themeDisplay,boolean isMatchAll, String[] byLawConditionIdstr) {
		List<String> conditionList=new ArrayList<String>();
		
		if(Validator.isNotNull(conditionList)) {
		for(String byLawConditionId: byLawConditionIdstr) {
			
			ByLawCondition byLawCondition = byLawUtil.getByLawConditionById(themeDisplay,Long.parseUnsignedLong(byLawConditionId));
			if(Validator.isNotNull(byLawCondition)) {
			conditionList.add(byLawCondition.getConditionValue());
			}
		}
		if(isMatchAll) {
			return String.join(" And ", conditionList);
		}
			return String.join(" Or ", conditionList);
		}
		return null;
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference
	private ByLawUtil byLawUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(ByLawHomeMVCRenderCommand.class);


}
