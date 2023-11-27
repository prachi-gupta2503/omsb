package gov.omsb.bylaw.rules.resource;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.common.api.OMSBCommonApi;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name="
				+ MVCCommands.DELETE_BYLAW_RULE }, service = MVCResourceCommand.class)

public class DeleteByLawRule extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		//ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long ByLawRuleId = ParamUtil.getLong(resourceRequest, "ByLawRuleId");
		commonApi.deleteObjectEntryEntryId(ByLawRuleId);
		
	}

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
}
