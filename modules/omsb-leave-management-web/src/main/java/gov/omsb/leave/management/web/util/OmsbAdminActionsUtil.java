package gov.omsb.leave.management.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.kaleo.model.KaleoTask;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;

import java.util.Date;
import java.util.List;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.BlockWeekMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalServiceUtil;
import gov.omsb.tms.service.LeaveAnnualRuleLocalServiceUtil;
import gov.omsb.tms.service.LeaveTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;

public class OmsbAdminActionsUtil {
	
	private OmsbAdminActionsUtil() {
		
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
		if (OmsbLeaveManagementWebConstants.APPROVE.equalsIgnoreCase(clickedBtnVal)) {
			return approvedTransitionName;
		} else {
			return rejectedTransitionName;
		}

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

	public static LeaveAnnualRule getLeaveAnnualRuleByProgramId(long programId) {

		LeaveAnnualRule leaveAnnualRule = null;

		DynamicQuery leaveAnnualRuleDQ = LeaveAnnualRuleLocalServiceUtil.dynamicQuery();

		leaveAnnualRuleDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID, programId));

		List<LeaveAnnualRule> leaveAnnualRules = LeaveAnnualRuleLocalServiceUtil.dynamicQuery(leaveAnnualRuleDQ);

		if (Validator.isNotNull(leaveAnnualRules) && !leaveAnnualRules.isEmpty()) {
			leaveAnnualRule = leaveAnnualRules.get(0);
		}

		return leaveAnnualRule;

	}

	public static LeaveAnnualMaxTrainee getAnnualMaxTraineeByBlockWeekAnnualRuleId(long annualRuleId, int block,
			int week) {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = null;
		DynamicQuery annualMaxTraineeDQ = LeaveAnnualMaxTraineeLocalServiceUtil.dynamicQuery();

		annualMaxTraineeDQ
				.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID, annualRuleId));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.BLOCK, block));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.WEEK, week));

		List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees = LeaveAnnualMaxTraineeLocalServiceUtil
				.dynamicQuery(annualMaxTraineeDQ);

		if (Validator.isNotNull(leaveAnnualMaxTrainees) && !leaveAnnualMaxTrainees.isEmpty()) {
			leaveAnnualMaxTrainee = leaveAnnualMaxTrainees.get(0);
		}

		return leaveAnnualMaxTrainee;

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

			blockWeekMetadataDetailsDQ.add(RestrictionsFactoryUtil.eq(
					OmsbLeaveManagementWebConstants.BLOCKS_METADATA_DETAILS_REL_ID_COLUMN_NAME,
					blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId()));
			blockWeekMetadataDetailsDQ
					.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.WEEK_START_DATE).le(date));
			blockWeekMetadataDetailsDQ
					.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.WEEK_END_DATE).ge(date));

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
						OmsbLeaveManagementWebConstants.PROG_DURATION_TRAINEE_LEVEL_BLOCKS_LEVEL_TYPE_ID_COLUMN_NAME,
						progdurationTlBlocksLtId));
				blocksMetadataDetailsDQ
						.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.BLOCK_START_DATE).le(date));
				blocksMetadataDetailsDQ
						.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.BLOCK_END_DATE).ge(date));

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

			traineeCohortDetailsDQ.add(RestrictionsFactoryUtil.eq(
					OmsbLeaveManagementWebConstants.TRAINEE_ADDMISSION_DETAILS_REL_ID_COLUMN_NAME,
					traineeAdmissionDetailsRel.getTraineeAdmissionDetailsRelId()));
			traineeCohortDetailsDQ.add(
					RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.IS_CURRENT_COHORT_COLUMN_NAME, true));

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

	private static Log log = LogFactoryUtil.getLog(OmsbAdminActionsUtil.class.getName());

}
