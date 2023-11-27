package gov.omsb.duty.logging.web.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import gov.omsb.duty.logging.web.constants.DutyLoggingConstants;
import gov.omsb.tms.custom.dto.DutyLogDTO;
import gov.omsb.tms.custom.dto.DutyTypeDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.model.DutyRule;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.model.ViolationUpdateStatus;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.DutyLogLocalServiceUtil;
import gov.omsb.tms.service.DutyLogViolationLocalServiceUtil;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalServiceUtil;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.ProgramDutyRuleLocalServiceUtil;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalServiceUtil;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.ViolationUpdateStatusLocalServiceUtil;
import gov.omsb.tms.service.base.TraineeRotationTsBlockDetailsRelLocalServiceBaseImpl;

public class LogViolationManager {

	public static void updateBlockViolation() throws PortalException, ParseException {

		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRelList = BlocksMetadataDetailsRelLocalServiceUtil
				.getBlocksMetadataDetailsRels(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		LOGGER.info("blocksMetadataDetailsRelList Size :: " + blocksMetadataDetailsRelList.size());

		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRelList) {
			Date todayDate = formatedDate(new Date());
			Date blockEndDate = formatedDate(blocksMetadataDetailsRel.getBlockEndDate());
			LOGGER.info("todayDate  :: " + todayDate);
			LOGGER.info("blockEndDate  :: " + blockEndDate);
			if (blockEndDate.compareTo(todayDate) > 0) {
				continue;
			}

			ViolationUpdateStatus violationUpdateStatus = addviolationUpdateStatus(blocksMetadataDetailsRel,
					blockEndDate, todayDate);

			if (!violationUpdateStatus.getStatus()) {
				long blocksMetadataDetailsRelId = blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId();
				LOGGER.info("blocksMetadataDetailsRelId :: " + blocksMetadataDetailsRelId);

				List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRelList = TraineeRotationTsBlockDetailsRelLocalServiceUtil
						.findByBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
				LOGGER.info("traineeRotationTsBlockDetailsRelList :: " + traineeRotationTsBlockDetailsRelList);
				for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel : traineeRotationTsBlockDetailsRelList) {
					updateDutyLogBlockLevelViolation(traineeRotationTsBlockDetailsRel);
				}

				violationUpdateStatus.setStatus(true);
				ViolationUpdateStatusLocalServiceUtil.updateViolationUpdateStatus(violationUpdateStatus);
			}

		}
	}

	public static void updateDutyLogBlockLevelViolation(
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {
		LOGGER.info("updateDutyLogBlockLevelViolation Called :: ");
		try {
			ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = ProgdurationRotationTrainingsitesRelLocalServiceUtil
					.getProgdurationRotationTrainingsitesRel(
							traineeRotationTsBlockDetailsRel.getProgDurationRotationTsRelId());
			ProgramDurationDetails programDurationDetails = ProgramDurationDetailsLocalServiceUtil
					.getProgramDurationDetails(progdurationRotationTrainingsitesRel.getProgramDurationId());

			long programId = programDurationDetails.getProgramId();
			long traineeId = traineeRotationTsBlockDetailsRel.getTraineeId();
			long cohortId = traineeRotationTsBlockDetailsRel.getTraineeCohortDetailsId();
			long blocksMetadataDetailsRelId = traineeRotationTsBlockDetailsRel.getBlocksMetadataDetailsRelId();

			DutyLogViolation dutyLogViolation = DutyLogViolationLocalServiceUtil
					.findByTraineeAndBlockAndProgramAndDutyLogId(traineeId, blocksMetadataDetailsRelId, programId, 0);

			LOGGER.info("#### dutyLogViolation ===>  " + dutyLogViolation);
			if (Validator.isNull(dutyLogViolation)) {
				dutyLogViolation = getDutyLogViolation(traineeRotationTsBlockDetailsRel,
						traineeRotationTsBlockDetailsRel.getBlocksMetadataDetailsRelId(), 0, 0, 0);
				DutyLogViolationLocalServiceUtil.addDutyLogViolation(dutyLogViolation);

			} else {
				dutyLogViolation.setAcgmeDayOffRule(0);
				dutyLogViolation.setAcgme80HoursRule(0);
				dutyLogViolation.setAcgmeCallRuleOption2(0);
				DutyLogViolationLocalServiceUtil.updateDutyLogViolation(dutyLogViolation);
			}
			LOGGER.info("##### dutyLogViolation ===>  " + dutyLogViolation);
			LOGGER.info("blocksMetadataDetailsRelId  :: " + blocksMetadataDetailsRelId);
			LOGGER.info("programId  :: " + programId);
			LOGGER.info("cohortId  :: " + cohortId);
			List<DutyRule> dutyRules = ProgramDutyRuleLocalServiceUtil.getDutyRulesListByProgramAndCohort(programId,
					cohortId);

			LOGGER.info(" dutyRules :::: " + dutyRules);
			for (DutyRule dutyRule : dutyRules) {

				if (DutyLoggingConstants.ACGME_DAY_OFF_RULE_NAME.equalsIgnoreCase(dutyRule.getRule())) {

					boolean isacgmeDayOffRuleViolated = false;
					try {
						isacgmeDayOffRuleViolated = isAcgmeDayOffRuleViolated(traineeId, blocksMetadataDetailsRelId);
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
					LOGGER.info("isacgmeDayOffRuleViolated :: " + isacgmeDayOffRuleViolated);

					if (isacgmeDayOffRuleViolated) {
						dutyLogViolation.setAcgmeDayOffRule(1);
						DutyLogViolationLocalServiceUtil.updateDutyLogViolation(dutyLogViolation);
					}
				}

				if (DutyLoggingConstants.ACGME_EIGHTY_HOUR_RULE_NAME.equalsIgnoreCase(dutyRule.getRule())) {

					boolean isacgme80RuleViolated = isAcgme80RuleViolated(traineeId, blocksMetadataDetailsRelId);
					LOGGER.info("isacgme80RuleViolated :: " + isacgme80RuleViolated);

					if (isacgme80RuleViolated) {
						dutyLogViolation.setAcgme80HoursRule(1);
						DutyLogViolationLocalServiceUtil.updateDutyLogViolation(dutyLogViolation);
					}
				}

				if (DutyLoggingConstants.ACGME_CALL_RULE_OPTION_TWO_RULE_NAME.equalsIgnoreCase(dutyRule.getRule())) {

					boolean isacgmeCallRuleViolated8HourViolated = isAcgmeCallRuleViolated8Hour(traineeId,
							blocksMetadataDetailsRelId);
					LOGGER.info("isacgmeCallRuleViolated8HourViolated :: " + isacgmeCallRuleViolated8HourViolated);

					if (isacgmeCallRuleViolated8HourViolated) {
						dutyLogViolation.setAcgmeCallRuleOption2(1);
						DutyLogViolationLocalServiceUtil.updateDutyLogViolation(dutyLogViolation);
					}
				}

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

	private static ViolationUpdateStatus addviolationUpdateStatus(BlocksMetadataDetailsRel blocksMetadataDetailsRel,
			Date blockEndDate, Date todayDate) {

		ViolationUpdateStatus violationUpdateStatus = null;
		long violationUpdateStatusId;
		LOGGER.info("=============================Add Violation Update Status Called ============================");
		try {
			violationUpdateStatus = ViolationUpdateStatusLocalServiceUtil
					.getByBlocksMetadataDetailRelId(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());

		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		if (!Validator.isNotNull(violationUpdateStatus)) {

			violationUpdateStatusId = CounterLocalServiceUtil.increment(ViolationUpdateStatus.class.getName());
			violationUpdateStatus = ViolationUpdateStatusLocalServiceUtil
					.createViolationUpdateStatus(violationUpdateStatusId);

			violationUpdateStatus.setCompanyId(blocksMetadataDetailsRel.getCompanyId());
			violationUpdateStatus.setGroupId(blocksMetadataDetailsRel.getGroupId());
			violationUpdateStatus.setCreatedDate(new Date());
			violationUpdateStatus.setModifiedDate(new Date());
			violationUpdateStatus
					.setBlocksMetadataDetailRelId(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
			violationUpdateStatus.setStatus(false);

			violationUpdateStatus = ViolationUpdateStatusLocalServiceUtil
					.addViolationUpdateStatus(violationUpdateStatus);
			LOGGER.info(" ViolationUpdateStatus Add Successfully");

		}

		return violationUpdateStatus;

	}

	public static DutyLogViolation getDutyLogViolation(
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel, long blocksMetadataDetailsRelId,
			int acgmeDayOffRule, int acgme80Rule, int acgmeCallRuleOption2) {
		LOGGER.info("===============================getDutyLogViolation Called ::================================");
		DutyLogViolation dutyLogViolation = null;
		long violationId = CounterLocalServiceUtil.increment(DutyLogViolation.class.getName());
		LOGGER.info("violationId :: " + violationId);

		try {

			ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = ProgdurationRotationTrainingsitesRelLocalServiceUtil
					.getProgdurationRotationTrainingsitesRel(
							traineeRotationTsBlockDetailsRel.getProgDurationRotationTsRelId());
			long programDurationId = progdurationRotationTrainingsitesRel.getProgramDurationId();
			ProgramDurationDetails programDurationDetails = ProgramDurationDetailsLocalServiceUtil
					.getProgramDurationDetails(progdurationRotationTrainingsitesRel.getProgramDurationId());
			long programId = programDurationDetails.getProgramId();
			dutyLogViolation = DutyLogViolationLocalServiceUtil.createDutyLogViolation(violationId);
			LOGGER.debug("dutyLogViolation :: " + dutyLogViolation);
			dutyLogViolation.setBlockId(blocksMetadataDetailsRelId);
			LOGGER.info("blocksMetadataDetailsRelId :: " + blocksMetadataDetailsRelId);
			LOGGER.debug("programDutyAssignment.getProgramId() :: " + programId);
			List<TraineeProgdurationTraineelevelDetails> findByTraineeId = TraineeProgdurationTraineelevelDetailsLocalServiceUtil
					.findByTraineeId(traineeRotationTsBlockDetailsRel.getTraineeId());
			dutyLogViolation.setResidencyLevel(findByTraineeId.get(0).getTraineeLevelId());
			LOGGER.debug("dutyLog.getTraineeId :: " + traineeRotationTsBlockDetailsRel.getTraineeId());
			LOGGER.info("programDurationId :: " + programDurationId);
			List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRelList = ProgdurationRotationTrainingsitesRelLocalServiceUtil
					.findByProgramDurationId(programDurationId);
			LOGGER.debug("progdurationRotationTrainingsitesRelList :: " + progdurationRotationTrainingsitesRelList);
			long rotationId = progdurationRotationTrainingsitesRelList.get(0).getRotationId();
			LOGGER.info("rotationId :: " + rotationId);
			long trainingSiteId = progdurationRotationTrainingsitesRelList.get(0).getTrainingSitesId();
			LOGGER.info("trainingSiteId :: " + trainingSiteId);
			dutyLogViolation.setCreateDate(new Date());
			dutyLogViolation.setModifiedDate(new Date());
			dutyLogViolation.setCompanyId(traineeRotationTsBlockDetailsRel.getCompanyId());
			dutyLogViolation.setGroupId(traineeRotationTsBlockDetailsRel.getGroupId());
			dutyLogViolation.setAcgmeDayOffRule(1);
			dutyLogViolation.setTraineeId(traineeRotationTsBlockDetailsRel.getTraineeId());
			dutyLogViolation.setProgramMasterId(programId);
			dutyLogViolation.setRotationId(rotationId);
			dutyLogViolation.setTrainingSiteId(trainingSiteId);
			dutyLogViolation.setAcgmeDayOffRule(acgmeDayOffRule);
			dutyLogViolation.setAcgme80HoursRule(acgme80Rule);
			dutyLogViolation.setAcgmeCallRuleOption2(acgmeCallRuleOption2);

		} catch (PortalException e) {
			e.getMessage();
		}
		return dutyLogViolation;

	}

	public static Date formatedDate(Date date) {
		Date parseDate = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT' yyyy", Locale.ENGLISH);
			dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
			SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = outputDateFormat.format(dateFormat.parse(date.toString()));
			parseDate = outputDateFormat.parse(formattedDate);
		} catch (Exception e) {
			e.getMessage();
		}
		return parseDate;
	}

	// ACGME DAY OFF RULE
	public static boolean isAcgmeDayOffRuleViolated(long traineeId, long blocksMetadataDetailRelId) {
		BlocksMetadataDetailsRel blocksMetadataDetailsRel = null;
		boolean isViolated = false;
		try {
			blocksMetadataDetailsRel = BlocksMetadataDetailsRelLocalServiceUtil
					.getBlocksMetadataDetailsRel(blocksMetadataDetailRelId);
			LOGGER.info("BlocksMetadataDetailsRel :: " + blocksMetadataDetailsRel);
			Date blockStartDate = formateDate(blocksMetadataDetailsRel.getBlockStartDate());
			Date blockEndDate = formateDate(blocksMetadataDetailsRel.getBlockEndDate());
			Date firstDate = blockStartDate;
			double totalDays = 0;
			LOGGER.info("blockStartDate :: " + blockStartDate);
			LOGGER.info("blockEndDate :: " + blockEndDate);
			List<DutyLog> dutyLogList = DutyLogLocalServiceUtil.getDutyLogListByTraineeIdAndBlockId(traineeId,
					blocksMetadataDetailRelId);

			for (DutyLog dutyLog : dutyLogList) {
				double daysDiff = (dutyLog.getStartDate().getTime() - firstDate.getTime())
						/ DutyLoggingConstants.CONVERT_TO_DAYS;
				if (daysDiff >= 1) {
					totalDays = totalDays + daysDiff;
				}
				LOGGER.debug("daysDiff :: " + daysDiff);
				LOGGER.debug("totalDays :: " + totalDays);
				firstDate = dutyLog.getEndDate();
			}
			if (firstDate != blockEndDate) {
				double daysDiff = (blockEndDate.getTime() - firstDate.getTime()) / DutyLoggingConstants.CONVERT_TO_DAYS;

				if (daysDiff >= 1) {
					totalDays = totalDays + daysDiff;
				}
				LOGGER.debug("daysDiff :: " + daysDiff);
				LOGGER.debug("totalDays :: " + totalDays);
			}
			if (!((totalDays / 4.0) <= 1)) {
				isViolated = true;
			}

			LOGGER.info("totalDays :: " + totalDays);
			LOGGER.info("isViolated :: " + isViolated);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return isViolated;

	}

	public static Date formateDate(Date date) {
		Date parseDate = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT' yyyy", Locale.ENGLISH);
			dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
			SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String formattedDate = outputDateFormat.format(dateFormat.parse(date.toString()));
			LOGGER.info("Formatted date: " + formattedDate);
			parseDate = outputDateFormat.parse(formattedDate);
			LOGGER.info("Parsed Date: " + parseDate);
		} catch (Exception e) {
			e.getMessage();
		}
		return parseDate;
	}

//======================================================================================
	public static boolean isAcgme80RuleViolated(long traineeId, long blocksMetadataDetailRelId) {
		List<DutyLog> dutyLogList = DutyLogLocalServiceUtil.getDutyLogListByTraineeIdAndBlockId(traineeId,
				blocksMetadataDetailRelId);
		float totalMinutesCount = getTotalMinutesCount(dutyLogList);
		LOGGER.info("totalMinutesCount  ::: " + totalMinutesCount);
		float avarageMinutes = totalMinutesCount / 4;
		if (avarageMinutes <= DutyLoggingConstants.NO_OF_MINUTES_IN_EIGHTY_HOURS) {
			LOGGER.debug("No Violation-->");
			return false; // No Violation
		} else {
			LOGGER.debug("Violation-->");
			return true; // Violation
		}
	}

	// For getting totalHours count
	public static float getTotalMinutesCount(List<DutyLog> dutyLogList) {
		Date startDate = null;
		Date endDate = null;
		float totalMinutesCount = 0;
		for (DutyLog dutyLog : dutyLogList) {
			startDate = dutyLog.getStartDate();
			endDate = dutyLog.getEndDate();
			long minutes = (endDate.getTime() - startDate.getTime()) / 60000;
			totalMinutesCount = minutes + totalMinutesCount;
		}
		return totalMinutesCount;
	}
//==========================================================================================

	public static boolean isAcgme24PlusRuleViolated(long dutyLogId) throws PortalException {
		DutyLog dutyLog;
		DutyLog prevDutyLog;
		DutyTypes prevDutyType;
		DutyTypes dutyType;
		try {
			// get the current duty log
			dutyLog = DutyLogLocalServiceUtil.getDutyLog(dutyLogId);
			LOGGER.info("-------------------------for duty logs --------------------------" + dutyLog);
			// get the previous duty log
			prevDutyLog = DutyLogLocalServiceUtil.getPreviousDutyLog(dutyLog.getDutyLogId(), dutyLog.getTraineeId(),
					dutyLog.getBlocksMetadataDetailRelId(), dutyLog.getStartDate());
			if (prevDutyLog != null) {
				prevDutyType = getDutyTypeByDutyLog(prevDutyLog.getProgramDutyAssignmentId());
				LOGGER.info("prevDutyType " + prevDutyType);
				dutyType = getDutyTypeByDutyLog(dutyLog.getProgramDutyAssignmentId());
				LOGGER.info("  dutyType " + dutyType);
				if ((dutyType != null) && prevDutyType.getDutyType().equalsIgnoreCase("On Call")) {
					long curLogDuration = logDuration(dutyLog.getStartDate(), dutyLog.getEndDate());
//					long onCallDuration = logDuration(prevDutyLog.getStartDate(), prevDutyLog.getEndDate());
					long onCallDuration = getTotalDurationPreviousDutyLogs(prevDutyLog);
					if (onCallDuration >= (24 * 60)) {
						if (dutyType.getDutyType().equalsIgnoreCase("Post Call")) {
							if (curLogDuration > (6 * 60)) {
								return true; // Violation
							}
						} else {
							return true; // Violation
						}
					} else {
						long totalHours = onCallDuration + curLogDuration;
						if (dutyType.getDutyType().equalsIgnoreCase("Post Call")) {
							if (totalHours > (30 * 60)) {
								return true;// Violation
							}
						} else if (totalHours > (24 * 60)) {
							return true;// Violation
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	private static long logDuration(Date startDate, Date endDate) {
		return ((endDate.getTime() - startDate.getTime()) / (60 * 1000));
	}

	public static DutyTypes getDutyTypeByDutyLog(long programDutyAssignmentId) {
		ProgramDutyAssignment programDutyAssignment;
		DutyAssignment dutyAssignment;
		DutyTypes dutyTypes = null;
		try {
			programDutyAssignment = ProgramDutyAssignmentLocalServiceUtil
					.getProgramDutyAssignment(programDutyAssignmentId);
			dutyAssignment = DutyAssignmentLocalServiceUtil
					.getDutyAssignment(programDutyAssignment.getDutyAssignmentId());
			dutyTypes = DutyTypesLocalServiceUtil.getDutyTypes(dutyAssignment.getDutyTypeId());
			return dutyTypes;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public static boolean isAcgmeShortBreakRuleViolated(long dutyLogId) throws PortalException {
		DutyLog dutyLog;
		DutyLog prevDutyLog;
		try {
			dutyLog = DutyLogLocalServiceUtil.getDutyLog(dutyLogId);
			prevDutyLog = DutyLogLocalServiceUtil.getPreviousDutyLog(dutyLog.getDutyLogId(), dutyLog.getTraineeId(),
					dutyLog.getBlocksMetadataDetailRelId(), dutyLog.getStartDate());
			LOGGER.info("prevDutyLog- " + prevDutyLog);
			LOGGER.info("dutyLog- " + dutyLog);
			if (prevDutyLog != null) {
				DutyTypes prevDutyType = getDutyTypeByDutyLog(prevDutyLog.getProgramDutyAssignmentId());
				if (prevDutyType.getDutyType().equalsIgnoreCase("On Call")) {
					long breakDuration = logDuration(prevDutyLog.getEndDate(), dutyLog.getStartDate());
					DutyTypes dutyType = getDutyTypeByDutyLog(dutyLog.getProgramDutyAssignmentId());
					if (dutyType.getDutyType().equalsIgnoreCase("Post Call")) {
						long logDuration = logDuration(dutyLog.getStartDate(), dutyLog.getEndDate());
//						long prevLogDuration = logDuration(prevDutyLog.getStartDate(), prevDutyLog.getEndDate());
						long prevLogDuration = getTotalDurationPreviousDutyLogs(prevDutyLog);
						if ((prevLogDuration >= (24 * 60)) && (logDuration >= (6 * 60))) {
							if (breakDuration < (14 * 60)) {
								return true;// violation
							}
						}
					} else if (breakDuration < (8 * 60)) {
						return true;// violation
					}

				}

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return false;
	}

//================================================================================
	public static boolean isAcgmeCallRuleViolated8Hour(long traineeId, long blocksMetadataDetailRelId) {
		LOGGER.info("====================isAcgmeCallRuleViolated8Hour Called==================");
		long hours = 0;
		boolean isViolated = false;
		DutyTypes dutyTypes = DutyTypesLocalServiceUtil.findByDutyTypeAndStatus(DutyLoggingConstants.DUTY_TYPE_ON_CALL,
				DutyLoggingConstants.DUTY_TYPE_ACTIVE);
		List<DutyTypeDTO> dutyTypeDTOList = DutyTypesLocalServiceUtil.getAcgmeCallRule8Hour(dutyTypes.getDutyTypeId(),
				traineeId, blocksMetadataDetailRelId);
		for (DutyTypeDTO dutyTypeDTO : dutyTypeDTOList) {
			hours = hours + ((dutyTypeDTO.getEndDate().getTime() - dutyTypeDTO.getStartDate().getTime()) / 3600000);
		}
		if (!(hours <= 8)) {
			isViolated = true;
		}
		LOGGER.info("hours ::: " + hours);
		return isViolated;
	}

	public static boolean isAcgmeCallRuleViolated48Hour(long programDutyAssignmentId, long traineeId, long blockId,
			long dutyLogId) throws PortalException {
		Date dutyLogStartDate = null;
		Date dutyLogEndDate = null;
		DutyTypes dutyTypes = getDutyTypeByDutyLog(programDutyAssignmentId);
		if (dutyTypes != null) {
			DutyLogDTO dutyLogDTO = DutyLogLocalServiceUtil.getAcgmeCallRule48Hour(dutyTypes.getDutyTypeId(), traineeId,
					blockId, dutyLogId);
			if (dutyLogDTO != null) {
				DutyLog dutyLog = DutyLogLocalServiceUtil.getDutyLog(dutyLogId);
				dutyLogStartDate = dutyLog.getStartDate();
				dutyLogEndDate = dutyLogDTO.getEndDate();
				long hours = (dutyLog.getStartDate().getTime() - dutyLogEndDate.getTime()) / 3600000;
				LOGGER.info("hours-->" + hours);
				long gap = 48;
				if (hours > gap) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;

	}

	public static long getTotalDurationPreviousDutyLogs(DutyLog dutyLog) {

		DutyLog currentDutyLog = dutyLog;
		DutyLog previousDutyLog = null;

		DutyTypes currentDutyType = getDutyTypeByDutyLog(currentDutyLog.getProgramDutyAssignmentId());
		DutyTypes previousDutyType = null;

		long duration = logDuration(currentDutyLog.getStartDate(), currentDutyLog.getEndDate());
		boolean isPreviousDutyLogExist = true;

		while (isPreviousDutyLogExist) {
			previousDutyLog = DutyLogLocalServiceUtil.getPreviousDutyLog(currentDutyLog.getDutyLogId(),
					currentDutyLog.getTraineeId(), currentDutyLog.getBlocksMetadataDetailRelId(),
					currentDutyLog.getStartDate());
			previousDutyType = getDutyTypeByDutyLog(previousDutyLog.getProgramDutyAssignmentId());

			if (Validator.isNotNull(previousDutyLog)
					&& (previousDutyType.getDutyType().equalsIgnoreCase(currentDutyType.getDutyType()))) {
				if (previousDutyLog.getEndDate().compareTo(currentDutyLog.getStartDate()) == 0) {
					long previousDuration = logDuration(previousDutyLog.getStartDate(), previousDutyLog.getEndDate());
					duration += previousDuration;
					currentDutyLog = previousDutyLog;
					previousDutyLog = null;
				} else {
					isPreviousDutyLogExist = false;
				}
			} else {
				isPreviousDutyLogExist = false;
			}
		}

		LOGGER.info("  ###  Total Duration Of All Previous Duty Logs -> " + duration);

		return duration;

	}

	private static final Log LOGGER = LogFactoryUtil.getLog(LogViolationManager.class);

}
