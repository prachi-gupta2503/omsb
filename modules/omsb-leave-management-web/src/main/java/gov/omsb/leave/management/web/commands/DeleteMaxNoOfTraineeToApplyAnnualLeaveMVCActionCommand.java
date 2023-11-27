package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
		"javax.portlet.init-param.add-process-action-success-action=false",
		"mvc.command.name=" + OmsbLeaveManagementWebConstants.DELETE_MAX_TRAINEE_TO_ANNUAL_LEAVE_RULE }, service = MVCActionCommand.class)
public class DeleteMaxNoOfTraineeToApplyAnnualLeaveMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long leaveAnnualMaxTraineeId = ParamUtil.getLong(actionRequest, OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_MAX_TRAINEE_ID);
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = leaveAnnualMaxTraineeLocalService.deleteLeaveAnnualMaxTrainee(leaveAnnualMaxTraineeId);
		
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderURL.getRenderParameters().setValue("mvcRenderCommandName", OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE);
		renderURL.getRenderParameters().setValue(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID,String.valueOf(leaveAnnualMaxTrainee.getLeaveAnnualRuleId()));
		renderURL.getRenderParameters().setValue(OmsbLeaveManagementWebConstants.IS_EDITCONFIGUREANNUALLEAVERULE, String.valueOf(true));

		SessionMessages.add(actionRequest, "annual-leave-configuration-delete-msg");
		
		
		actionResponse.sendRedirect(renderURL.toString());
	}
	
	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;
	

}
