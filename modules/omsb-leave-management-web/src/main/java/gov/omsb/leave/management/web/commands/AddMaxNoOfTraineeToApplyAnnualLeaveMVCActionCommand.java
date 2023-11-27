package gov.omsb.leave.management.web.commands;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
		"javax.portlet.init-param.add-process-action-success-action=false",
		"mvc.command.name=" + OmsbLeaveManagementWebConstants.ADD_NEW_ANNUAL_LEAVE_RULE_FOR_PROGRAM }, service = MVCActionCommand.class)
public class AddMaxNoOfTraineeToApplyAnnualLeaveMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
			
			log.info("AddMaxNoOfTraineeToApplyAnnualLeaveMVCActionCommand Called....");
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			long leaveAnnualRuleId = ParamUtil.getLong(actionRequest, OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID);
			log.info("leaveAnnualRuleId :::::" + leaveAnnualRuleId);
			long trainingLevelMasterId = ParamUtil.getLong(actionRequest, OmsbLeaveManagementWebConstants.TRAINING_LEVEL);
			log.info("trainingLevelMasterId :::::" + trainingLevelMasterId);
			TraineeLevelMaster trainingLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMaster(trainingLevelMasterId);
			log.info("trainingLevelMaster :::::" + trainingLevelMaster);
			int maxNoOfTraineeApplyLeave = ParamUtil.getInteger(actionRequest, OmsbLeaveManagementWebConstants.MAX_NO_TRAINEE_APPLY_LEAVE);
			log.info("maxNoOfTraineeApplyLeave :::::" + maxNoOfTraineeApplyLeave);
			
			String selectedBlock = ParamUtil.getString(actionRequest, "blocks");
			
			String[] blockWeekArr = selectedBlock.split(StringPool.SPACE);
			int block = Integer.parseInt(blockWeekArr[0].split("-")[1]);
			int week = 0;
			if(selectedBlock.toLowerCase().contains(OmsbLeaveManagementWebConstants.WEEK)) {
				week = Integer.parseInt(blockWeekArr[1].split("-")[1]);
			}
			
			LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = leaveAnnualMaxTraineeLocalService.createLeaveAnnualMaxTrainee(CounterLocalServiceUtil.increment(LeaveAnnualMaxTrainee.class.getName(),1)); 
			leaveAnnualMaxTrainee.setLeaveAnnualRuleId(leaveAnnualRuleId);
			leaveAnnualMaxTrainee.setTrainingLevel(trainingLevelMaster.getTraineeLevelName());
			leaveAnnualMaxTrainee.setBlock(block);
			if(week != 0)
				leaveAnnualMaxTrainee.setWeek(week);
			leaveAnnualMaxTrainee.setMaxTraineeApplyLeave(maxNoOfTraineeApplyLeave);
			leaveAnnualMaxTrainee.setNoOfTraineeTakenLeave(0);
			leaveAnnualMaxTrainee.setCreatedBy(themeDisplay.getUserId());
			leaveAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			leaveAnnualMaxTrainee.setCreateDate(new Date());
			leaveAnnualMaxTrainee.setModifiedDate(new Date());
			leaveAnnualMaxTrainee.setGroupId(themeDisplay.getScopeGroupId());
			leaveAnnualMaxTraineeLocalService.addLeaveAnnualMaxTrainee(leaveAnnualMaxTrainee);
	
			
			PortletURL renderURL = PortletURLFactoryUtil.create(
					actionRequest, OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderURL.getRenderParameters().setValue("mvcRenderCommandName", OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE);
			renderURL.getRenderParameters().setValue(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID,String.valueOf(leaveAnnualRuleId));
			renderURL.getRenderParameters().setValue(OmsbLeaveManagementWebConstants.IS_EDITCONFIGUREANNUALLEAVERULE, String.valueOf(true));
			
			SessionMessages.add(actionRequest, "annual-leave-success-msg");
			
			actionResponse.sendRedirect(renderURL.toString());

	}

	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;
	
	private Log log = LogFactoryUtil.getLog(AddMaxNoOfTraineeToApplyAnnualLeaveMVCActionCommand.class.getName());
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
}
