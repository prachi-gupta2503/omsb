package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
	    	"javax.portlet.init-param.add-process-action-success-action=false",
	    	"mvc.command.name="+ OmsbLeaveManagementWebConstants.UPDATE_LEAVE_RULE
	    }, 
	    service = MVCResourceCommand.class
)
public class EditLastDateOfSubmissionForAnnualLeaveMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.DD_MM_YYYY_FORMAT);
		Date lastDateOfSubmission = ParamUtil.getDate(resourceRequest, OmsbLeaveManagementWebConstants.LAST_DATE_OF_SUBMISSION, sdf);
		
		long leaveAnnualRuleId = ParamUtil.getLong(resourceRequest, OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID);
		
		LeaveAnnualRule leaveAnnualRule = leaveAnnualRuleLocalService.getLeaveAnnualRule(leaveAnnualRuleId);
		leaveAnnualRule.setLastDateForSubmission(lastDateOfSubmission);
		leaveAnnualRule.setModifiedBy(themeDisplay.getUserId());
		leaveAnnualRule.setModifiedDate(new Date());
		leaveAnnualRule = leaveAnnualRuleLocalService.updateLeaveAnnualRule(leaveAnnualRule);
		String lastDateOFSubmission = sdf.format(leaveAnnualRule.getLastDateForSubmission());
		
		SessionMessages.add(resourceRequest, "last-date-success-msg");
		
		
		resourceResponse.getWriter().write(lastDateOFSubmission);
		
	}
	
	
	
	@Reference
	private LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

}
