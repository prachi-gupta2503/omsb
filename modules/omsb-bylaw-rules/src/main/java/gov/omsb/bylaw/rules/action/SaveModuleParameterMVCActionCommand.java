package gov.omsb.bylaw.rules.action;

import com.liferay.object.model.ObjectEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
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
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name=" + MVCCommands.SAVE_MODULE_PARAMETER, }, service = MVCActionCommand.class)
public class SaveModuleParameterMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		try {
		logger.info("save method Started ()");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String moduleValue = ParamUtil.getString(actionRequest, "moduleValue");
		String parameter = ParamUtil.getString(actionRequest, "paramter");
		Map<String, Serializable> values = new HashMap<>();
		values.put("moduleName", moduleValue);
		values.put("parameterName", parameter);
		ObjectEntry objectEntry = commonApi.addObjectEntryByERC(
				MVCCommands.RULE_ENGINE_MODULE_PARAMETER_OBJ_ERC, values, actionRequest, themeDisplay);
			actionResponse.sendRedirect(OmsbBylawRulesPortletKeys.REDIRECT_URL);
		} catch (IOException e) {
			logger.error("error while saving"+ e.getMessage(),e);
		}
		logger.info("save method Ended ()");
		return false;
	}
	
	private static final Log logger = LogFactoryUtil.getLog(SaveModuleParameterMVCActionCommand.class);

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
}
