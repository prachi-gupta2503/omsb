package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgramDutyRule;
import gov.omsb.tms.service.ProgramDutyRuleLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.ADD_PROGRAM_DUTY_RULE }, service = MVCResourceCommand.class)
public class AddProgramDutyRuleMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("serveResource CALLED SUCCESSFULLY");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long createdBy = themeDisplay.getUserId();
		ServiceContext serviceContext;
		long programId = ParamUtil.getLong(resourceRequest, "programMasterId");
		long cohortId = ParamUtil.getLong(resourceRequest, "cohortId");
		String status = ParamUtil.getString(resourceRequest, "status");
		long[] dutyRulesId = ParamUtil.getLongValues(resourceRequest, "programDutyRules");
		try {
			serviceContext = ServiceContextFactory.getInstance(ProgramDutyRule.class.getName(), resourceRequest);
			programDutyRuleLocalService.addProgramDutyRules(programId, cohortId, dutyRulesId, serviceContext);
		} catch (PortalException e) {
			LOGGER.info("Error in addProgramDutyRule");
		}
		return false;
	}

	@Reference
	private ProgramDutyRuleLocalService programDutyRuleLocalService;
	private static final Log LOGGER = LogFactoryUtil.getLog(AddDutyAssignmentMVCResourceCommand.class);

}
