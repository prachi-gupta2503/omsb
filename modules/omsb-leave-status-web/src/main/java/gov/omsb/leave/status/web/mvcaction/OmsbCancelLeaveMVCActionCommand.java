package gov.omsb.leave.status.web.mvcaction;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskAssignmentInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.leave.status.web.util.OmsbAddLeaveUtil;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTraineeMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"mvc.command.name=" + OmsbLeaveStatusConstants.CANCEL_LEAVE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbCancelLeaveMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long leaveMasterId = ParamUtil.getLong(actionRequest, OmsbLeaveStatusConstants.LEAVE_MASTER_ID);

		LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);

		String leaveTypeName = OmsbAddLeaveUtil.getLeaveTypeNameFromLeaveTypeId(leaveMaster.getLeaveTypeId(),
				themeDisplay);

		if (leaveMaster.getStatus() == 1) {

			// Workflow Needs To Be Stop First

			List<KaleoTaskInstanceToken> kaleoTaskInstanceTokens = OmsbAddLeaveUtil
					.getKaleoTaskInstanceTokenByClassPk(leaveMasterId, false);

			String transitionName = OmsbAddLeaveUtil.getTransitionName(OmsbLeaveStatusConstants.REJECT,
					kaleoTaskInstanceTokens.get(0).getKaleoTask());

			if (kaleoTaskInstanceTokens.size() == 1) {

				long workflowTaskId = kaleoTaskInstanceTokens.get(0).getKaleoTaskInstanceTokenId();

				List<KaleoTaskAssignmentInstance> kaleoTaskAssignmentInstances = kaleoTaskInstanceTokens.get(0)
						.getKaleoTaskAssignmentInstances();

				completeWorkflowTask(themeDisplay, workflowTaskId, transitionName, kaleoTaskAssignmentInstances);

			}

		} else if (leaveMaster.getStatus() == 0) {
			if (OmsbLeaveStatusConstants.ANNUAL_LEAVE_TYPE.equals(leaveTypeName)) {

				DynamicQuery leaveAnnualRuleDQ = leaveAnnualRuleLocalService.dynamicQuery();

				leaveAnnualRuleDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.PROGRAM_MASTER_ID_COLUMN,
						leaveMaster.getProgramId()));

				List<LeaveAnnualRule> leaveAnnualRules = leaveAnnualRuleLocalService.dynamicQuery(leaveAnnualRuleDQ);

				LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

				updateAnnualMaxTraineeDetails(themeDisplay, leaveMaster, leaveAnnualRule);

			}

			LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService
					.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(leaveMaster.getProgramId(),
							leaveMaster.getLeaveTypeId());

			updateLeaveTraineeMasterDetails(themeDisplay, leaveMaster, leaveProgramMaster);
		}

		leaveMaster.setModifiedDate(new Date());
		leaveMaster.setModifiedBy(themeDisplay.getUserId());
		leaveMaster.setStatus(WorkflowConstants.getLabelStatus(WorkflowConstants.LABEL_IN_TRASH));
		leaveMaster.setStatusByUserId(themeDisplay.getUserId());
		leaveMaster.setStatusByUserName(themeDisplay.getUser().getFullName());
		leaveMaster.setStatusDate(new Date());

		leaveMasterLocalService.updateLeaveMaster(leaveMaster);

		log.info("LEAVE CANCELED SUCCESSFULLY");

	}

	private void completeWorkflowTask(ThemeDisplay themeDisplay, long workflowTaskId, String transitionName,
			List<KaleoTaskAssignmentInstance> kaleoTaskAssignmentInstances) throws PortalException {

		for (KaleoTaskAssignmentInstance kaleoTaskAssignmentInstance : kaleoTaskAssignmentInstances) {

			if (Role.class.getName().equalsIgnoreCase(kaleoTaskAssignmentInstance.getAssigneeClassName())) {
				long roleId = kaleoTaskAssignmentInstance.getAssigneeClassPK();

				List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);

				Map<String, Serializable> workflowContext = OmsbAddLeaveUtil
						.getWorkflowContext(themeDisplay.getCompanyId(), workflowTaskId);

				workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(users.get(0).getUserId()));

				PrincipalThreadLocal.setName(users.get(0).getUserId());
				PermissionChecker permissionChecker = PermissionCheckerFactoryUtil
						.create(UserLocalServiceUtil.getUser(users.get(0).getUserId()));
				PermissionThreadLocal.setPermissionChecker(permissionChecker);

				WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), users.get(0).getUserId(),
						workflowTaskId, users.get(0).getUserId(), StringPool.BLANK, null, null);

				WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), users.get(0).getUserId(),
						workflowTaskId, transitionName, OmsbLeaveStatusConstants.TRAINEE_CANCELED_LEAVE_COMMENT,
						workflowContext);

			} else {
				Map<String, Serializable> workflowContext = OmsbAddLeaveUtil
						.getWorkflowContext(themeDisplay.getCompanyId(), workflowTaskId);

				workflowContext.put(WorkflowConstants.CONTEXT_USER_ID,
						String.valueOf(kaleoTaskAssignmentInstance.getAssigneeClassPK()));

				PrincipalThreadLocal.setName(kaleoTaskAssignmentInstance.getAssigneeClassPK());
				PermissionChecker permissionChecker = PermissionCheckerFactoryUtil
						.create(UserLocalServiceUtil.getUser(kaleoTaskAssignmentInstance.getAssigneeClassPK()));
				PermissionThreadLocal.setPermissionChecker(permissionChecker);

				WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(),
						kaleoTaskAssignmentInstance.getAssigneeClassPK(), workflowTaskId, transitionName,
						OmsbLeaveStatusConstants.TRAINEE_CANCELED_LEAVE_COMMENT, workflowContext);

			}
			log.info("Workflow Terminated Successfully");
		}

	}

	private void updateAnnualMaxTraineeDetails(ThemeDisplay themeDisplay, LeaveMaster leaveMaster,
			LeaveAnnualRule leaveAnnualRule) {

		int fromDateBlockNumber = OmsbAddLeaveUtil.getBlockNumberFromDate(leaveMaster.getLeaveFrom(),
				leaveMaster.getTraineeId());
		int toDateBlockNumber = OmsbAddLeaveUtil.getBlockNumberFromDate(leaveMaster.getLeaveTo(),
				leaveMaster.getTraineeId());

		int fromDateBlockWeekNumber = 0;
		int toDateBlockWeekNumber = 0;

		String leaveAvailableAt = leaveAnnualRule.getAnnualLeaveAvailableAt();

		if (OmsbLeaveStatusConstants.BLOCK_WEEK.equalsIgnoreCase(leaveAvailableAt)) {
			fromDateBlockWeekNumber = OmsbAddLeaveUtil.getBlockWeekNumberFromDate(leaveMaster.getLeaveFrom(),
					leaveMaster.getTraineeId());
			toDateBlockWeekNumber = OmsbAddLeaveUtil.getBlockWeekNumberFromDate(leaveMaster.getLeaveTo(),
					leaveMaster.getTraineeId());
		}

		LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = OmsbAddLeaveUtil.getAnnualMaxTraineeByBlockWeekAnnualRuleId(
				leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
		LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = OmsbAddLeaveUtil.getAnnualMaxTraineeByBlockWeekAnnualRuleId(
				leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);

		if (Validator.isNotNull(fromDateAnnualMaxTrainee)) {
			fromDateAnnualMaxTrainee.setNoOfTraineeTakenLeave(fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave() - 1);

			fromDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			fromDateAnnualMaxTrainee.setModifiedDate(new Date());
			leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(fromDateAnnualMaxTrainee);
		}

		if (fromDateBlockNumber != toDateBlockNumber && fromDateBlockWeekNumber != toDateBlockWeekNumber
				&& (Validator.isNotNull(toDateAnnualMaxTrainee))) {
			toDateAnnualMaxTrainee.setNoOfTraineeTakenLeave(toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave() - 1);

			toDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			toDateAnnualMaxTrainee.setModifiedDate(new Date());
			leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(toDateAnnualMaxTrainee);

		}

	}

	private void updateLeaveTraineeMasterDetails(ThemeDisplay themeDisplay, LeaveMaster leaveMaster,
			LeaveProgramMaster leaveProgramMaster) {

		if (Validator.isNotNull(leaveProgramMaster)) {

			DynamicQuery leaveTraineeMasterDQ = leaveTraineeMasterLocalService.dynamicQuery();

			leaveTraineeMasterDQ.add(
					RestrictionsFactoryUtil.eq("leaveProgramMasterId", leaveProgramMaster.getLeaveProgramMasterId()));
			leaveTraineeMasterDQ.add(RestrictionsFactoryUtil.eq("traineeId", leaveMaster.getTraineeId()));

			List<LeaveTraineeMaster> leaveTraineeMasters = leaveTraineeMasterLocalService
					.dynamicQuery(leaveTraineeMasterDQ);

			if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {
				LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

				int numberOfLeaveTaken = leaveTraineeMaster.getNoOfLeaveTaken();
				int numberOfLeaveRemaining = leaveTraineeMaster.getNoOfLeaveRemaining();
				int noOfDays = leaveMaster.getNoOfDays();

				int updatedNumberOfLeavesTaken = numberOfLeaveTaken - noOfDays;
				int updatedNumberOfLeavesRemaining = numberOfLeaveRemaining + noOfDays;

				leaveTraineeMaster.setNoOfLeaveTaken(updatedNumberOfLeavesTaken);
				leaveTraineeMaster.setNoOfLeaveRemaining(updatedNumberOfLeavesRemaining);
				leaveTraineeMaster.setModifiedBy(themeDisplay.getUserId());
				leaveTraineeMaster.setModifiedDate(new Date());

				leaveTraineeMasterLocalService.updateLeaveTraineeMaster(leaveTraineeMaster);

			}

		} else {
			log.info("LEAVE PROGRAM MASTER NOT FOUND");
		}

	}

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

	@Reference
	LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;

	@Reference
	LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	LeaveTraineeMasterLocalService leaveTraineeMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbCancelLeaveMVCActionCommand.class.getName());

}