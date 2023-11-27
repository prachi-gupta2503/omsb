package gov.omsb.bylaw.rules.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.ByLawCondition;
import gov.omsb.bylaw.rules.util.ByLawUtil;


@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name="
				+ MVCCommands.GET_BYLAW_CONDITION }, service = MVCResourceCommand.class)

public class GetByRuleConditionMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay =(ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("GetByRuleConditionMVCResourceCommand started...........");
		String ruleEngineModuleParameterId = ParamUtil.getString(resourceRequest, "ruleEngineModuleParameterId");
		String moduleName = ParamUtil.getString(resourceRequest, "moduleName");
		log.info("ruleEngineModuleParameterId  "+ruleEngineModuleParameterId);
		log.info("moduleName  "+moduleName);
		List<ByLawCondition> byRuleConditions = byLawUtil.getByLawConditionByModuleName(themeDisplay, moduleName);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		if(Validator.isNotNull(byRuleConditions)) {
			for(ByLawCondition byLawCondition:byRuleConditions) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("conditionValue", byLawCondition.getConditionValue());
				object.put("conditionId", byLawCondition.getId());
				jsonArray.put(object);
			}
		}
		resourceResponse.getWriter().write(jsonArray.toString());

		
	}

	
	private static final Log log= LogFactoryUtil.getLog(ModuleParameterMVCResourceCommand.class);
	
	@Reference
	private ByLawUtil byLawUtil;

}
