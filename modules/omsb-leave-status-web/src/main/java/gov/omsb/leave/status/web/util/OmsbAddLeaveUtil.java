package gov.omsb.leave.status.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalServiceUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.BlockWeekMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalServiceUtil;
import gov.omsb.tms.service.LeaveMasterLocalServiceUtil;
import gov.omsb.tms.service.LeaveProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.LeaveTraineeMasterLocalServiceUtil;
import gov.omsb.tms.service.LeaveTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramWorkflowDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;

public class OmsbAddLeaveUtil {

	private OmsbAddLeaveUtil() {
	}
	
	
	public static boolean checkIfLeaveAlreadyApplied(String leaveFrom,String leaveTo,long traineeId) {
		
		DynamicQuery dq = LeaveMasterLocalServiceUtil.dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq("traineeId", traineeId));
		List<LeaveMaster> leaveMasterlist = LeaveMasterLocalServiceUtil.dynamicQuery(dq);
		if(leaveMasterlist.isEmpty()) {
			return true;
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);
			try {
				Date fromDate = sdf.parse(leaveFrom);
				Date toDate = sdf.parse(leaveTo);
				
				for (LeaveMaster leaveMaster : leaveMasterlist) {
					Date leaveFromDate = leaveMaster.getLeaveFrom();
					Date leaveToDate = leaveMaster.getLeaveTo();
					
					if(((fromDate.after(leaveFromDate) || fromDate.compareTo(leaveFromDate)==0)  && (fromDate.before(leaveToDate) || fromDate.compareTo(leaveToDate)==0))
							||
						((toDate.after(leaveFromDate) || toDate.compareTo(leaveFromDate)==0)  && (toDate.before(leaveToDate) || toDate.compareTo(leaveToDate)==0))){
						return false;
					}
				}
				
			} catch (ParseException e) {
				log.debug(e.getLocalizedMessage());
			}
		}
		return true;
		
	}

	public static boolean checkIsAppliedLeaveValidForFirstCase(ActionRequest actionRequest,
			List<LeaveAnnualRule> leaveAnnualRules, String leaveFrom, String leaveTo, long traineeId)
			throws ParseException {

		boolean isAppliedLeaveValid = false;

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);

		if (Validator.isNotNull(leaveAnnualRules) && leaveAnnualRules.size() == 1) {
			LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

			int fromDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveFrom), traineeId);
			int toDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveTo), traineeId);

			LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = null;
			LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = null;

			if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbLeaveStatusConstants.BLOCK)) {
				fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, 0);
				toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, 0);
			} else {
				int fromDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveFrom), traineeId);
				int toDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveTo), traineeId);

				fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
				toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);
			}

			isAppliedLeaveValid = checkAnnualMaxTraineeCriteria(actionRequest, fromDateAnnualMaxTrainee,
					toDateAnnualMaxTrainee);
		}

		return isAppliedLeaveValid;

	}

	public static boolean checkIsAppliedLeaveValidForSecondCase(ActionRequest actionRequest,
			List<LeaveAnnualRule> leaveAnnualRules, String programName, String leaveFrom, String leaveTo, int noOfDays,
			long traineeId) throws ParseException {

		boolean isAppliedLeaveValid = false;

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);

		if (Validator.isNotNull(leaveAnnualRules) && leaveAnnualRules.size() == 1) {
			LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

			if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbLeaveStatusConstants.BLOCK)) {
				isAppliedLeaveValid = false;
				setLeavesAvailableAtBlockErrorMessage(actionRequest, programName);
			} else {
				int fromDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveFrom), traineeId);
				int toDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveTo), traineeId);

				int fromDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveFrom), traineeId);
				int toDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveTo), traineeId);

				LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
				LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);

				boolean isViolatingAttendance = isViolatingAttendanceCriteria(sdf, leaveFrom, leaveTo,
						fromDateBlockNumber, toDateBlockNumber, noOfDays);

				if (noOfDays > 7) {
					isAppliedLeaveValid = false;
					setLeavesAvailableAtBlockWeekErrorMessage(actionRequest, programName);
				} else {
					if (isViolatingAttendance) {
						isAppliedLeaveValid = false;
						setAttendanceViolationErrorMessage(actionRequest);
					} else {
						isAppliedLeaveValid = checkAnnualMaxTraineeCriteria(actionRequest, fromDateAnnualMaxTrainee,
								toDateAnnualMaxTrainee);
					}
				}

			}
		}

		return isAppliedLeaveValid;

	}

	public static boolean checkIsAppliedLeaveValidForThirdCase(ActionRequest actionRequest,
			List<LeaveAnnualRule> leaveAnnualRules, String programName, String leaveFrom, String leaveTo,
			long traineeId) throws ParseException {

		boolean isAppliedLeaveValid = false;

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);

		if (Validator.isNotNull(leaveAnnualRules) && leaveAnnualRules.size() == 1) {
			LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

			if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbLeaveStatusConstants.BLOCK_WEEK)) {
				isAppliedLeaveValid = false;
				setLeavesAvailableAtBlockWeekErrorMessage(actionRequest, programName);
			} else {
				int fromDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveFrom), traineeId);
				int toDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveTo), traineeId);

				LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, 0);
				LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, 0);

				int fdBlockLeaveTaken = getNoLeavesTakenInBlock(sdf.parse(leaveFrom), true);
				int tdBlockLeaveTaken = getNoLeavesTakenInBlock(sdf.parse(leaveTo), false);

				if (fdBlockLeaveTaken <= 7 || tdBlockLeaveTaken <= 7) {
					isAppliedLeaveValid = checkAnnualMaxTraineeCriteria(actionRequest, fromDateAnnualMaxTrainee,
							toDateAnnualMaxTrainee);
				} else {
					isAppliedLeaveValid = false;
					setAttendanceViolationErrorMessage(actionRequest);
				}
			}

		}

		return isAppliedLeaveValid;

	}

	private static boolean checkAnnualMaxTraineeCriteria(ActionRequest actionRequest,
			LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee, LeaveAnnualMaxTrainee toDateAnnualMaxTrainee) {

		boolean isAppliedLeaveValid = true;

		if (fromDateAnnualMaxTrainee != null && toDateAnnualMaxTrainee != null) {
			if (fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0
					|| toDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0) {
				isAppliedLeaveValid = false;
				setLeavesNotAllowedErrorMessage(actionRequest);
			} else {
				if ((fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
						- fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0
						&& (toDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
								- toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0) {
					isAppliedLeaveValid = true;
				} else {
					isAppliedLeaveValid = false;
					setMaximumTraineesAlreadyTakenErrorMessage(actionRequest);
				}
			}
		} else {
			isAppliedLeaveValid = true;
		}

		return isAppliedLeaveValid;

	}

	public static List<KaleoTaskInstanceToken> getKaleoTaskInstanceTokenByClassPk(long classPk, boolean isCompleted) {

		DynamicQuery dynamicQuery = KaleoTaskInstanceTokenLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.CLASS_NAME, LeaveMaster.class.getName()));
		dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.CLASS_PK, classPk));
		dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.COMPLETED, isCompleted));

		return KaleoTaskInstanceTokenLocalServiceUtil.dynamicQuery(dynamicQuery);

	}

	public static String getTransitionName(String clickedBtnVal, KaleoTask kaleoTask) throws PortalException {

		List<KaleoTransition> kaleoTransitions = kaleoTask.getKaleoNode().getKaleoTransitions();

		String approvedTransitionName = StringPool.BLANK;
		String rejectedTransitionName = StringPool.BLANK;

		for (KaleoTransition kaleoTransition : kaleoTransitions) {
			if (kaleoTransition.getName().contains("reviewed") || kaleoTransition.getName().contains("approved")) {
				approvedTransitionName = kaleoTransition.getName();
			} else if (kaleoTransition.getName().contains("rejected")) {
				rejectedTransitionName = kaleoTransition.getName();
			}
		}
		if (OmsbLeaveStatusConstants.APPROVE.equalsIgnoreCase(clickedBtnVal)) {
			return approvedTransitionName;
		} else {
			return rejectedTransitionName;
		}

	}

	public static boolean isWorkflowConfigured(long programId) {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = ProgramWorkflowDetailsRelLocalServiceUtil
				.findByProgramId(programId);

		boolean isWorkflowConfigured = false;

		if (Validator.isNotNull(programWorkflowDetailsRel)) {
			isWorkflowConfigured = true;
		}

		return isWorkflowConfigured;
	}

	public static String getLeaveTypeNameFromLeaveTypeId(long leaveTypeId, ThemeDisplay themeDisplay) {

		String leaveName = StringPool.BLANK;

		try {
			LeaveTypes leaveTypes = LeaveTypesLocalServiceUtil.getLeaveTypes(leaveTypeId);
			leaveName = leaveTypes.getLeaveTypes(themeDisplay.getLocale());
		} catch (PortalException e) {
			log.error("Error While Fetching Leave Type From Leave Type Id : " + e.getMessage());
		}

		return leaveName;

	}

	public static LeaveProgramMaster getLeaveProgramMasterFromProgramIdLeaveTypeId(long programId, long leaveTypeId)
			throws PortalException {

		ProgramMaster programMaster = ProgramMasterLocalServiceUtil.getProgramMaster(programId);

		LeaveProgramMaster leaveProgramMaster = null;

		if (Validator.isNotNull(programMaster)) {

			leaveProgramMaster = LeaveProgramMasterLocalServiceUtil.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(
					programMaster.getProgramMasterId(), leaveTypeId);
		}

		return leaveProgramMaster;

	}

	public static List<LeaveTraineeMaster> getTraineeLeaveRecordsFromLeaveProgramMasterId(long leaveProgramMasterId,
			long traineeId) {

		DynamicQuery dynamicQuery = LeaveTraineeMasterLocalServiceUtil.dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq("leaveProgramMasterId", leaveProgramMasterId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("traineeId", traineeId));

		return LeaveTraineeMasterLocalServiceUtil.dynamicQuery(dynamicQuery);

	}

	public static LeaveAnnualMaxTrainee getAnnualMaxTraineeByBlockWeekAnnualRuleId(long annualRuleId, int block,
			int week) {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = null;
		DynamicQuery annualMaxTraineeDQ = LeaveAnnualMaxTraineeLocalServiceUtil.dynamicQuery();

		annualMaxTraineeDQ
				.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.LEAVE_ANNUAL_RULE_ID_COLUMN, annualRuleId));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.BLOCK_COLUMN, block));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.WEEK_COLUMN, week));

		List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees = LeaveAnnualMaxTraineeLocalServiceUtil
				.dynamicQuery(annualMaxTraineeDQ);

		if (Validator.isNotNull(leaveAnnualMaxTrainees) && !leaveAnnualMaxTrainees.isEmpty()) {
			leaveAnnualMaxTrainee = leaveAnnualMaxTrainees.get(0);
		}

		return leaveAnnualMaxTrainee;

	}

	public static Map<String, String> getNodeWiseKaleoComments(List<WorkflowLog> kaleoLogs) {

		Map<String, String> nodeWisekaleoLogs = new HashMap<>();

		for (WorkflowLog workflowLog : kaleoLogs) {
			nodeWisekaleoLogs.put(workflowLog.getCurrentWorkflowNodeName(), workflowLog.getComment());
		}

		return nodeWisekaleoLogs;

	}

	public static Map<String, Serializable> getWorkflowContext(long companyId, long workflowTaskId)
			throws WorkflowException {

		WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(companyId, workflowTaskId);

		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
				workflowTask.getWorkflowInstanceId());

		return workflowInstance.getWorkflowContext();
	}

	public static int getBlockNumberFromDate(Date date, long traineeId) {

		int blockNumber = 0;

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = getBlocksMetadataDetailsRel(date, traineeId);

		if (blocksMetadataDetailsRel != null) {
			blockNumber = Integer.valueOf(blocksMetadataDetailsRel.getBlockNo().split(StringPool.DASH)[1]);
		}

		return blockNumber;
	}

	public static int getBlockWeekNumberFromDate(Date date, long traineeId) {

		int blockWeekNumber = 0;

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = getBlocksMetadataDetailsRel(date, traineeId);

		if (blocksMetadataDetailsRel != null) {
			DynamicQuery blockWeekMetadataDetailsDQ = BlockWeekMetadataDetailsRelLocalServiceUtil.dynamicQuery();

			blockWeekMetadataDetailsDQ
					.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.BLOCKS_METADATA_DETAILS_REL_ID_COLUMN_NAME,
							blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId()));
			blockWeekMetadataDetailsDQ
					.add(PropertyFactoryUtil.forName(OmsbLeaveStatusConstants.WEEK_START_DATE).le(date));
			blockWeekMetadataDetailsDQ
					.add(PropertyFactoryUtil.forName(OmsbLeaveStatusConstants.WEEK_END_DATE).ge(date));

			List<BlockWeekMetadataDetailsRel> blockWeekMetadataDetailsRels = BlockWeekMetadataDetailsRelLocalServiceUtil
					.dynamicQuery(blockWeekMetadataDetailsDQ);

			if (Validator.isNotNull(blockWeekMetadataDetailsRels) && !blockWeekMetadataDetailsRels.isEmpty()) {
				blockWeekNumber = Integer
						.valueOf(blockWeekMetadataDetailsRels.get(0).getWeekNo().split(StringPool.DASH)[1]);
			}
		} else {
			log.info("BLOCKS METADATA DETAILS NOT AVAILABLE");
		}

		return blockWeekNumber;
	}

	public static BlocksMetadataDetailsRel getBlocksMetadataDetailsRel(Date date, long traineeId) {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = null;

		TraineeCohortDetails traineeCohortDetails = getTraineeCohortDetailsByTraineeId(traineeId);

		if (traineeCohortDetails != null) {
			long traineeLevelId = traineeCohortDetails.getTraineeLevelId();
			long programDurationId = getProgramDurationIdFromTraineeId(traineeId);

			ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel = ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil
					.findByProgramDurationIdAndTraineeLevelId(programDurationId, traineeLevelId);

			if (Validator.isNotNull(progdurationTraineelevelBlocksLevelTypeRel)) {
				long progdurationTlBlocksLtId = progdurationTraineelevelBlocksLevelTypeRel
						.getProgdurationTlBlocksLtId();

				DynamicQuery blocksMetadataDetailsDQ = BlocksMetadataDetailsRelLocalServiceUtil.dynamicQuery();

				blocksMetadataDetailsDQ.add(RestrictionsFactoryUtil.eq(
						OmsbLeaveStatusConstants.PROG_DURATION_TRAINEE_LEVEL_BLOCKS_LEVEL_TYPE_ID_COLUMN_NAME,
						progdurationTlBlocksLtId));
				blocksMetadataDetailsDQ
						.add(PropertyFactoryUtil.forName(OmsbLeaveStatusConstants.BLOCK_START_DATE).le(date));
				blocksMetadataDetailsDQ
						.add(PropertyFactoryUtil.forName(OmsbLeaveStatusConstants.BLOCK_END_DATE).ge(date));

				List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = BlocksMetadataDetailsRelLocalServiceUtil
						.dynamicQuery(blocksMetadataDetailsDQ);

				if (Validator.isNotNull(blocksMetadataDetailsRels) && !blocksMetadataDetailsRels.isEmpty()) {
					blocksMetadataDetailsRel = blocksMetadataDetailsRels.get(0);
				} else {
					log.error("Blocks Metadata Details Not Available");
				}
			} else {
				log.info("ProgdurationTraineeLevelBlocksLevelTypeRel Data Not Available");
			}

		} else {
			log.info("UNABLE TO FETCH TRAINEE COHORT DETAILS");
		}

		return blocksMetadataDetailsRel;

	}

	public static TraineeCohortDetails getTraineeCohortDetailsByTraineeId(long traineeId) {

		TraineeCohortDetails traineeCohortDetail = null;

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = TraineeAdmissionDetailsRelLocalServiceUtil
				.findByTraineeId(traineeId);

		if (Validator.isNotNull(traineeAdmissionDetailsRel)) {
			DynamicQuery traineeCohortDetailsDQ = TraineeCohortDetailsLocalServiceUtil.dynamicQuery();

			traineeCohortDetailsDQ.add(
					RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.TRAINEE_ADDMISSION_DETAILS_REL_ID_COLUMN_NAME,
							traineeAdmissionDetailsRel.getTraineeAdmissionDetailsRelId()));
			traineeCohortDetailsDQ
					.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.IS_CURRENT_COHORT_COLUMN_NAME, true));

			List<TraineeCohortDetails> traineeCohortDetails = TraineeCohortDetailsLocalServiceUtil
					.dynamicQuery(traineeCohortDetailsDQ);

			if (Validator.isNotNull(traineeCohortDetails) && !traineeCohortDetails.isEmpty()) {
				traineeCohortDetail = traineeCohortDetails.get(0);
			}
		} else {
			log.info("Trainee Addmission Details Not Available");
		}

		return traineeCohortDetail;

	}

	public static long getProgramDurationIdFromTraineeId(long traineeId) {

		long programDurationId = 0;

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = TraineeAdmissionDetailsRelLocalServiceUtil
				.findByTraineeId(traineeId);

		if (Validator.isNotNull(traineeAdmissionDetailsRel)) {
			programDurationId = traineeAdmissionDetailsRel.getProgramDurationId();
		} else {
			log.info("UNABLE TO FETCH TRAINEEADMISSIONDETAILS BY TRAINEE ID");
		}

		return programDurationId;

	}

	public static int getNoLeavesTakenInBlock(Date date, boolean isFromDate) {
		long daysDiff = getDaysDiffByDateInCurrentAY(date);
		int daysPassedInBlock = (int) (daysDiff % 28);
		if (isFromDate) {
			return (28 - daysPassedInBlock);
		} else {
			return daysPassedInBlock;
		}
	}

	public static boolean isViolatingAttendanceCriteria(SimpleDateFormat sdf, String leaveFrom, String leaveTo,
			int fromDateBlockNumber, int toDateBlockNumber, int noOfDays) throws ParseException {
		boolean isViolatingAttendance = false;

		if (fromDateBlockNumber == toDateBlockNumber) {
			if (noOfDays <= 7) {
				isViolatingAttendance = false;
			} else {
				isViolatingAttendance = true;
			}
		} else {
			int fdBlockLeaveTaken = getNoLeavesTakenInBlock(sdf.parse(leaveFrom), true);
			int tdBlockLeaveTaken = getNoLeavesTakenInBlock(sdf.parse(leaveTo), false);
			if (fdBlockLeaveTaken <= 7 || tdBlockLeaveTaken <= 7) {
				isViolatingAttendance = false;
			} else {
				isViolatingAttendance = true;
			}
		}

		return isViolatingAttendance;
	}

	@SuppressWarnings("deprecation")
	public static long getDaysDiffByDateInCurrentAY(Date date) {

		Date startDate;

		if (date.getMonth() < Calendar.SEPTEMBER) {
			startDate = new Date(date.getYear() - 1, Calendar.SEPTEMBER, 1);
		} else {
			startDate = new Date(date.getYear(), Calendar.SEPTEMBER, 1);
		}

		long startDateInMs = startDate.getTime();
		long dateInMs = date.getTime();

		long timeDiff = Math.abs(dateInMs - startDateInMs);

		return TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

	}

	public static void setLeavesNotRemainingErrorMessage(ActionRequest actionRequest, int numberOfDays,
			int numberOfLeavesRemaining) {
		log.info("YOU ARE APPLYING FOR " + numberOfDays + " DAYS BUT THE LEAVES REMAINING IS "
				+ numberOfLeavesRemaining);

		SessionErrors.add(actionRequest, "leaves-not-remaining");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public static void setLeaveAlreadyAppliedForTheseDays(ActionRequest actionRequest) {
		
		SessionErrors.add(actionRequest, "leaves-already-applied-for-these-days");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void setLessDaysConfiguredErrorMessage(ActionRequest actionRequest) {
		log.info("LESS DAYS CONFIGURED FOR THIS LEAVE TYPE");

		SessionErrors.add(actionRequest, "less-days-configured");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void setAttendanceViolationErrorMessage(ActionRequest actionRequest) {
		log.info("VIOLATING 75% ATTENDANCE RULE");

		SessionErrors.add(actionRequest, "violating-attendance-criteria");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void setLeavesAvailableAtBlockWeekErrorMessage(ActionRequest actionRequest, String programName) {
		log.info("ANNUAL LEAVE CONFIGURED FOR " + programName + " PROGRAM IS AT BLOCK WEEK LEVEL");

		SessionErrors.add(actionRequest, "leaves-available-at-block-week-level");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void setLeavesAvailableAtBlockErrorMessage(ActionRequest actionRequest, String programName) {
		log.info("ANNUAL LEAVE CONFIGURED FOR " + programName + " PROGRAM IS AT BLOCK LEVEL");

		SessionErrors.add(actionRequest, "leaves-available-at-block-level");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void setMaximumTraineesAlreadyTakenErrorMessage(ActionRequest actionRequest) {
		log.info("MAXIMUM NUMBER OF TRAINEES APPLIED FOR LEAVE IN THIS BLOCK");

		SessionErrors.add(actionRequest, "maximum-trainees-already-applied");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	public static void setLeavesNotAllowedErrorMessage(ActionRequest actionRequest) {
		log.info("NOT A SINGLE TRAINEE ARE ALLOWED TO TAKE A LEAVE IN THIS BLOCK");

		SessionErrors.add(actionRequest, "not-allowed-to-take-leaves");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	private static Log log = LogFactoryUtil.getLog(OmsbAddLeaveUtil.class.getName());
	

}
