package gov.omsb.leave.management.web.commands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.leave.management.web.util.OmsbAdminActionsUtil;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTraineeMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBVIEWTRAINEELEAVEWEB,
		"javax.portlet.init-param.add-process-action-success-action=false", "mvc.command.name="
				+ OmsbLeaveManagementWebConstants.ADMIN_ACTION_PERFORMED_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbAdminActionPerformedMVCActionCommand extends BaseMVCActionCommand {

	@Override
	@SuppressWarnings("deprecation")
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);

		long leaveMasterId = ParamUtil.getLong(actionRequest, OmsbLeaveManagementWebConstants.LEAVE_MASTER_ID);

		String clickedBtnVal = ParamUtil.getString(actionRequest, OmsbLeaveManagementWebConstants.CLICKED_BUTTON_VALUE);
		String comment = ParamUtil.getString(actionRequest, OmsbLeaveManagementWebConstants.REASON);

		List<KaleoTaskInstanceToken> kaleoTaskInstanceTokens = getKaleoTaskInstanceTokenByClassPk(leaveMasterId);

		String transitionName = OmsbAdminActionsUtil.getTransitionName(clickedBtnVal,
				kaleoTaskInstanceTokens.get(0).getKaleoTask());

		boolean isValidLeave = false;

		if (kaleoTaskInstanceTokens.size() == 1) {
			long workflowTaskId = kaleoTaskInstanceTokens.get(0).getKaleoTaskInstanceTokenId();
			String currentKaleoTaskName = kaleoTaskInstanceTokens.get(0).getKaleoTaskName();

			Map<String, Serializable> workflowContext = getWorkflowContext(themeDisplay.getCompanyId(), workflowTaskId);

			workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(themeDisplay.getUserId()));

			LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);

			LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService
					.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(leaveMaster.getProgramId(),
							leaveMaster.getLeaveTypeId());

			if (Validator.isNotNull(leaveMaster.getReturnFromLeave())) {
				// This Condition will be invoked if Admin performing action on Return From
				// Leave case.
				isValidLeave = true;
			} else if (Validator.isNotNull(leaveProgramMaster) && Validator.isNotNull(leaveMaster)
					&& OmsbLeaveManagementWebConstants.APPROVE.equalsIgnoreCase(clickedBtnVal)) {

				DynamicQuery leaveTraineeMasterDQ = leaveTraineeMasterLocalService.dynamicQuery();

				leaveTraineeMasterDQ.add(RestrictionsFactoryUtil.eq("leaveProgramMasterId",
						leaveProgramMaster.getLeaveProgramMasterId()));
				leaveTraineeMasterDQ.add(RestrictionsFactoryUtil.eq("traineeId", leaveMaster.getTraineeId()));

				List<LeaveTraineeMaster> leaveTraineeMasters = leaveTraineeMasterLocalService
						.dynamicQuery(leaveTraineeMasterDQ);

				isValidLeave = updateLeaveTraineeMasterIfValid(actionRequest, themeDisplay, leaveMaster,
						leaveTraineeMasters, leaveProgramMaster, currentKaleoTaskName);

			} else {
				// This Condition will be invoked when Admin clicks the Reject Button
				isValidLeave = true;
			}

			if (isValidLeave) {
				WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
						workflowTaskId, themeDisplay.getUserId(), StringPool.BLANK, null, null);

				workflowTaskManager.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
						workflowTaskId, transitionName, comment, workflowContext);

				log.info("Workflow Task Completed Successfully");

				String leaveTypeName = OmsbAdminActionsUtil
						.getLeaveTypeNameFromLeaveTypeId(leaveMaster.getLeaveTypeId(), themeDisplay);

				if (OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_TYPE.equals(leaveTypeName)
						&& OmsbLeaveManagementWebConstants.KALEO_TASK_NAME_PROGRAM_DIRECTOR
								.equalsIgnoreCase(currentKaleoTaskName)
						&& (OmsbLeaveManagementWebConstants.APPROVE.equalsIgnoreCase(clickedBtnVal))) {

					updateLeaveAnnualMaxTraineeDetails(themeDisplay, leaveMaster);

				}

				redirectURL.setParameter(OmsbLeaveManagementWebConstants.IS_SCHEDULE_TAB, StringPool.TRUE);
				actionResponse.sendRedirect(redirectURL.toString());

			} else {
				LeaveTypes leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveMaster.getLeaveTypeId());

				redirectURL.setParameter(OmsbLeaveManagementWebConstants.MVC_PATH,
						OmsbLeaveManagementWebConstants.ADMIN_APPROVAL_JSP);
				redirectURL.setParameter(OmsbLeaveManagementWebConstants.LEAVE_TYPE,
						leaveTypes.getLeaveCode(themeDisplay.getLocale()));
				redirectURL.setParameter(OmsbLeaveManagementWebConstants.LEAVE_MASTER_ID,
						String.valueOf(leaveMasterId));
				redirectURL.setParameter(OmsbLeaveManagementWebConstants.IS_VALID_LEAVE, String.valueOf(isValidLeave));
				actionResponse.sendRedirect(redirectURL.toString());
			}

			log.info("Workflow Completed Successfully");
		}

	}

	private void updateLeaveAnnualMaxTraineeDetails(ThemeDisplay themeDisplay, LeaveMaster leaveMaster) {

		LeaveAnnualRule leaveAnnualRule = OmsbAdminActionsUtil
				.getLeaveAnnualRuleByProgramId(leaveMaster.getProgramId());

		int fromDateBlockNumber = OmsbAdminActionsUtil.getBlockNumberFromDate(leaveMaster.getLeaveFrom(),
				leaveMaster.getTraineeId());
		int toDateBlockNumber = OmsbAdminActionsUtil.getBlockNumberFromDate(leaveMaster.getLeaveTo(),
				leaveMaster.getTraineeId());

		int fromDateBlockWeekNumber = 0;
		int toDateBlockWeekNumber = 0;

		String leaveAvailableAt = leaveAnnualRule.getAnnualLeaveAvailableAt();

		if (OmsbLeaveManagementWebConstants.BLOCK_WEEK.equalsIgnoreCase(leaveAvailableAt)) {
			fromDateBlockWeekNumber = OmsbAdminActionsUtil.getBlockWeekNumberFromDate(leaveMaster.getLeaveFrom(),
					leaveMaster.getTraineeId());
			toDateBlockWeekNumber = OmsbAdminActionsUtil.getBlockWeekNumberFromDate(leaveMaster.getLeaveTo(),
					leaveMaster.getTraineeId());
		}

		LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = OmsbAdminActionsUtil
				.getAnnualMaxTraineeByBlockWeekAnnualRuleId(leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber,
						fromDateBlockWeekNumber);
		LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = OmsbAdminActionsUtil.getAnnualMaxTraineeByBlockWeekAnnualRuleId(
				leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);

		if (Validator.isNotNull(fromDateAnnualMaxTrainee)) {
			fromDateAnnualMaxTrainee.setNoOfTraineeTakenLeave(fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave() + 1);
			fromDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			fromDateAnnualMaxTrainee.setModifiedDate(new Date());
			leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(fromDateAnnualMaxTrainee);
		}

		if (Validator.isNotNull(toDateAnnualMaxTrainee) && fromDateBlockNumber != toDateBlockNumber
				&& fromDateBlockWeekNumber != toDateBlockWeekNumber) {
			toDateAnnualMaxTrainee.setNoOfTraineeTakenLeave(toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave() + 1);

			toDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			toDateAnnualMaxTrainee.setModifiedDate(new Date());

			leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(toDateAnnualMaxTrainee);
		}

	}

	private boolean updateLeaveTraineeMasterIfValid(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			LeaveMaster leaveMaster, List<LeaveTraineeMaster> leaveTraineeMasters,
			LeaveProgramMaster leaveProgramMaster, String currentKaleoTaskName) {

		boolean isValidLeave = true;

		if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {
			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

			int numberOfLeaveTaken = leaveTraineeMaster.getNoOfLeaveTaken();
			if ((numberOfLeaveTaken + leaveMaster.getNoOfDays()) <= leaveProgramMaster.getNoOfLeaves()) {
				int updatedNumberOfLeavesTaken = numberOfLeaveTaken + leaveMaster.getNoOfDays();
				int updatedNumberOfLeavesRemaining = leaveProgramMaster.getNoOfLeaves() - updatedNumberOfLeavesTaken;

				leaveTraineeMaster.setNoOfLeaveTaken(updatedNumberOfLeavesTaken);
				leaveTraineeMaster.setNoOfLeaveRemaining(updatedNumberOfLeavesRemaining);
				leaveTraineeMaster.setModifiedBy(themeDisplay.getUserId());
				leaveTraineeMaster.setModifiedDate(new Date());

				if (OmsbLeaveManagementWebConstants.KALEO_TASK_NAME_PROGRAM_DIRECTOR
						.equalsIgnoreCase(currentKaleoTaskName)) {
					leaveTraineeMasterLocalService.updateLeaveTraineeMaster(leaveTraineeMaster);
				}

				isValidLeave = true;
			} else {
				SessionErrors.add(actionRequest, "leaves-not-remaining");

				isValidLeave = false;
			}
		} else {
			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasterLocalService
					.createLeaveTraineeMaster(counterLocalService.increment(LeaveTraineeMaster.class.getName(), 1));

			leaveTraineeMaster.setTraineeId(leaveMaster.getTraineeId());
			leaveTraineeMaster.setNoOfLeaveTaken(leaveMaster.getNoOfDays());
			leaveTraineeMaster.setLeaveProgramMasterId(leaveProgramMaster.getLeaveProgramMasterId());
			leaveTraineeMaster.setNoOfLeaveRemaining(leaveProgramMaster.getNoOfLeaves() - leaveMaster.getNoOfDays());
			leaveTraineeMaster.setCreateDate(new Date());
			leaveTraineeMaster.setModifiedBy(themeDisplay.getUserId());
			leaveTraineeMaster.setCreatedBy(themeDisplay.getUserId());
			leaveTraineeMaster.setGroupId(themeDisplay.getScopeGroupId());

			if (OmsbLeaveManagementWebConstants.KALEO_TASK_NAME_PROGRAM_DIRECTOR
					.equalsIgnoreCase(currentKaleoTaskName)) {
				leaveTraineeMasterLocalService.addLeaveTraineeMaster(leaveTraineeMaster);
			}

			isValidLeave = true;
		}

		return isValidLeave;

	}

	private List<KaleoTaskInstanceToken> getKaleoTaskInstanceTokenByClassPk(long classPk) {

		DynamicQuery dynamicQuery = kaleoTaskInstanceTokenLocalService.dynamicQuery();
		dynamicQuery.add(
				RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.CLASS_NAME, LeaveMaster.class.getName()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.CLASS_PK, classPk));
		dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.COMPLETED, false));

		return kaleoTaskInstanceTokenLocalService.dynamicQuery(dynamicQuery);

	}

	private Map<String, Serializable> getWorkflowContext(long companyId, long workflowTaskId) throws WorkflowException {

		WorkflowTask workflowTask = workflowTaskManager.getWorkflowTask(workflowTaskId);

		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
				workflowTask.getWorkflowInstanceId());

		return workflowInstance.getWorkflowContext();
	}

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	protected WorkflowTaskManager workflowTaskManager;

	@Reference
	KaleoTaskInstanceTokenLocalService kaleoTaskInstanceTokenLocalService;

	@Reference
	ProgramMasterLocalService programMasterLocalService;

	@Reference
	LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	LeaveTraineeMasterLocalService leaveTraineeMasterLocalService;

	@Reference
	LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	private Log log = LogFactoryUtil.getLog(OmsbAdminActionPerformedMVCActionCommand.class.getName());

}