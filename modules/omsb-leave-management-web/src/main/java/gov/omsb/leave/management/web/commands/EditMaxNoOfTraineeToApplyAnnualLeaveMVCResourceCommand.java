package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
	        "mvc.command.name="+ OmsbLeaveManagementWebConstants.EDIT_MAX_TRAINEE_TO_ANNUAL_LEAVE_RULE
	    }, 
	    service = MVCResourceCommand.class
)
public class EditMaxNoOfTraineeToApplyAnnualLeaveMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		long leaveAnnualMaxTraineeId = ParamUtil.getLong(resourceRequest, OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_MAX_TRAINEE_ID);
		int maxNoOfTraineeApplyLeave = ParamUtil.getInteger(resourceRequest, OmsbLeaveManagementWebConstants.MAX_NO_TRAINEE_APPLY_LEAVE);
		
		
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = leaveAnnualMaxTraineeLocalService.getLeaveAnnualMaxTrainee(leaveAnnualMaxTraineeId);
		leaveAnnualMaxTrainee.setMaxTraineeApplyLeave(maxNoOfTraineeApplyLeave);
		leaveAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
		leaveAnnualMaxTrainee.setModifiedDate(new Date());
		leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(leaveAnnualMaxTrainee);
	}
	
	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;

}
