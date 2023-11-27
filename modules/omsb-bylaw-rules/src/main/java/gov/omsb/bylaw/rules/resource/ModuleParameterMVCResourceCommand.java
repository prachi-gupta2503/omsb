package gov.omsb.bylaw.rules.resource;

import com.liferay.petra.string.StringPool;
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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamters;
import gov.omsb.bylaw.rules.dto.RuleEngineModuleParamtersItems;
import gov.omsb.bylaw.rules.util.ByLawUtil;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name="
				+ MVCCommands.MODULE_AND_PARAMETER_MAPPING }, service = MVCResourceCommand.class)
public class ModuleParameterMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		logger.info("calling ajax for mapping");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long ruleEngineModuleParameterId = ParamUtil.getLong(resourceRequest, "ruleEngineModuleParameterId");
		logger.info("ruleEngineModuleParameterId "+ruleEngineModuleParameterId);
		RuleEngineModuleParamters ruleEngineModuleParamters = byLawUtil.getRuleEngineModuleParamtersById(themeDisplay,ruleEngineModuleParameterId);
		if(Validator.isNotNull(ruleEngineModuleParamters)) {
			logger.info("ruleEngineModuleParamters "+ruleEngineModuleParamters);
			RuleEngineModuleParamtersItems engineModuleParamtersItems = getParameterName(themeDisplay, ruleEngineModuleParamters.getModuleName());
			logger.info("convertValue  "+ruleEngineModuleParamters);
			if (Validator.isNotNull(engineModuleParamtersItems) && Validator.isNotNull(engineModuleParamtersItems.getItems())
					&& !engineModuleParamtersItems.getItems().isEmpty()) {
				for (RuleEngineModuleParamters items : engineModuleParamtersItems.getItems()) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("parameterName", items.getParameterName());
					object.put("parameterType", items.getParameterType());
					jsonArray.put(object);
				}
				logger.info("jsonArray   "+jsonArray.toJSONString());
			}
		}
		
		resourceResponse.getWriter().write(jsonArray.toString());
	}
	
	public RuleEngineModuleParamtersItems getParameterName(ThemeDisplay themeDisplay, String moduleValue)
			throws UnsupportedEncodingException {
		String ruleEngineUrl =  themeDisplay.getPortalURL() + MVCCommands.RULE_ENGINE_BY_LAW_OBJECT_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=moduleName" 
				+URLEncoder.encode(" eq " + "'"+ moduleValue+ "'" , StandardCharsets.UTF_8);
		String ruleEngineUrlResponse = commonApi.getData(ruleEngineUrl);
		logger.info("ruleEngineUrl::" + ruleEngineUrl);
		logger.info("ruleEngineUrlResponse==============="+ruleEngineUrlResponse);
		return CustomObjectMapperUtil.readValue(ruleEngineUrlResponse, RuleEngineModuleParamtersItems.class);
	}
	
	private static final Log logger = LogFactoryUtil.getLog(ModuleParameterMVCResourceCommand.class);

	
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "-")
	private ByLawUtil byLawUtil;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
}
