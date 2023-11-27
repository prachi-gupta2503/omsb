package gov.omsb.duty.logging.web.commands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.DutyLoggingConstants;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.util.DutyLoggingUtil;
import gov.omsb.duty.logging.web.util.LogViolationManager;
import gov.omsb.tms.custom.dto.DutyLogDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.model.DutyRule;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.DutyLogLocalService;
import gov.omsb.tms.service.DutyLogViolationLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalServiceUtil;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalService;
import gov.omsb.tms.service.ProgramDutyRuleLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGHOURS,
		"mvc.command.name=" + MVCCommandNames.ADD_DUTY_LOGS_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class AddDutyLogsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

		String jsonString = httpRequest.getParameter(DutyLoggingConstants.DUTY_LOGS_DATA_KEY);
		String removedAssignmentIds = httpRequest.getParameter(DutyLoggingConstants.REMOVED_ASSIGNMENT_IDS_KEY);
		String programId = httpRequest.getParameter(DutyLoggingConstants.PROGRAM_ID_COLUMN_NAME);
		String errorMessage = StringPool.BLANK;
		boolean isLogsAdded = true;

		TraineeCohortDetails traineeCohortDetails = DutyLoggingUtil
				.getTraineeCohortDetailsByTraineeId(themeDisplay.getUserId());
		// Removing Existing Duty Logs...
		deleteDutyLogsByTraineeId(removedAssignmentIds, programId);

		// Adding/Updating new Duty Logs...
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
		Date weekStartDate = null;
		Date weekEndDate = null;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			// Retrieve the two date values from JSONObject
			String startDate = jsonObject.getString(DutyLoggingConstants.START_KEY);
			String endDate = jsonObject.getString(DutyLoggingConstants.END_KEY);
			log.info("startDate-------" + startDate);
			log.info("endDate--------" + endDate);
			// Parse the date strings into LocalDate objects
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN);
			LocalDate localStartDate = LocalDate.parse(startDate, formatter);
			LocalDate localEndDate = LocalDate.parse(endDate, formatter);
			Date sDate = new SimpleDateFormat(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN).parse(startDate);
			Date eDate = new SimpleDateFormat(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN).parse(endDate);

			if (weekStartDate == null || sDate.before(weekStartDate)) {
				weekStartDate = sDate;
			}

			if (weekEndDate == null || eDate.after(weekEndDate)) {
				weekEndDate = eDate;
			}
			// Compare the two dates for equality
			boolean datesAreEqual = localStartDate.equals(localEndDate);

			DutyLog dutyLog = null;

			if (jsonObject.has(DutyLoggingConstants.ID_KEY)) {
				try {
					dutyLog = dutyLogLocalService.getDutyLog(jsonObject.getLong(DutyLoggingConstants.ID_KEY));

					dutyLog.setModifiedBy(themeDisplay.getUserId());
					dutyLog.setModifiedDate(new Date());
				} catch (PortalException e) {
					log.error("--------Error While Fetching DutyLog By dutyLogId : " + e.getMessage());
					isLogsAdded = false;
					errorMessage = DutyLoggingUtil.getDutyLoggedNotFoundErrorMessage(httpRequest,
							jsonObject.getString(DutyLoggingConstants.TITLE_KEY).trim());
				}
			} else {
				long dutyLogId = counterLocalService.increment(DutyLog.class.getName());
				dutyLog = dutyLogLocalService.createDutyLog(dutyLogId);

				dutyLog.setCreatedBy(themeDisplay.getUserId());
				dutyLog.setCreateDate(new Date());
			}

			if (Validator.isNotNull(dutyLog)) {
				dutyLog.setGroupId(themeDisplay.getScopeGroupId());
				dutyLog.setCompanyId(themeDisplay.getCompanyId());
				dutyLog.setTraineeId(themeDisplay.getUserId());
				dutyLog.setMultiDays(!datesAreEqual);
				dutyLog.setResidencyLevelId(traineeCohortDetails.getTraineeLevelId());

				if (!jsonObject.has(DutyLoggingConstants.ID_KEY)) {
					// Fetching programDutyAssignmentId from the Duty Log Title and programId...
					long programDutyAssignmentId = DutyLoggingUtil.getPgDutyAssignmentIdByAssignmentTitle(
							jsonObject.getString(DutyLoggingConstants.TITLE_KEY).trim(), Long.valueOf(programId),
							themeDisplay);

					dutyLog.setProgramDutyAssignmentId(programDutyAssignmentId);
				}

				try {
					dutyLog.setStartDate(new SimpleDateFormat(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN)
							.parse(jsonObject.getString(DutyLoggingConstants.START_KEY)));
					dutyLog.setEndDate(new SimpleDateFormat(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN)
							.parse(jsonObject.getString(DutyLoggingConstants.END_KEY)));

					BlocksMetadataDetailsRel startDtBlocksMetadataDetailsRel = DutyLoggingUtil
							.getBlockMetadataDetailsFromDate(
									new SimpleDateFormat(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN)
											.parse(jsonObject.getString(DutyLoggingConstants.START_KEY)),
									themeDisplay.getUserId());

					BlocksMetadataDetailsRel endDtBlocksMetadataDetailsRel = DutyLoggingUtil
							.getBlockMetadataDetailsFromDate(
									new SimpleDateFormat(DutyLoggingConstants.DATETIME_FORMATTER_PATTERN)
											.parse(jsonObject.getString(DutyLoggingConstants.END_KEY)),
									themeDisplay.getUserId());
					if (Validator.isNotNull(startDtBlocksMetadataDetailsRel)
							&& Validator.isNotNull(endDtBlocksMetadataDetailsRel)) {

						// Validation check for the duty log should be in a single block...
						if (startDtBlocksMetadataDetailsRel
								.getBlocksMetadataDetailsRelId() != endDtBlocksMetadataDetailsRel
										.getBlocksMetadataDetailsRelId()) {
							log.error("--------Start Date & End Date is Not in Same Block--------");
							isLogsAdded = false;

							errorMessage = DutyLoggingUtil.getBlockMismatchErrorMessage(httpRequest,
									jsonObject.getString(DutyLoggingConstants.TITLE_KEY).trim());

							break;
						}

						dutyLog.setBlocksMetadataDetailRelId(
								startDtBlocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());

						if (jsonObject.has(DutyLoggingConstants.ID_KEY)) {
							// Updating the existing DutyLog data....
							dutyLog = dutyLogLocalService.updateDutyLog(dutyLog);
							log.info("--------DUTY LOGGED UPDATED SUCCESSFULLY--------");
						} else {
							// Adding a new DutyLog....
							dutyLog = dutyLogLocalService.addDutyLog(dutyLog);
							log.info("--------DUTY LOGGED INSERTED SUCCESSFULLY--------");
						}
					} else {
						log.error("Error While Setting BlocksMetadataDetailsRelId");
						isLogsAdded = false;

						errorMessage = DutyLoggingUtil.getBlockDataNotFoundErrorMessage(httpRequest,
								jsonObject.getString(DutyLoggingConstants.TITLE_KEY).trim());
					}
				} catch (ParseException e) {
					log.error("--------Error While Parsing Date - " + e.getMessage());
					isLogsAdded = false;

					errorMessage = DutyLoggingUtil.getDutyLoggedErrorMessage(httpRequest,
							jsonObject.getString(DutyLoggingConstants.TITLE_KEY).trim());
				}
			}

		}
		if (weekStartDate != null && weekEndDate != null) {
			updateDutyLogViolation(weekStartDate, weekEndDate, themeDisplay.getUserId(), Long.valueOf(programId));
		}

		JSONObject responseJSONObj = JSONFactoryUtil.createJSONObject();

		if (isLogsAdded) {
			// Fetching Duty Logs Of The Current Trainee...
			DynamicQuery dutyLogsDQ = dutyLogLocalService.dynamicQuery();

			dutyLogsDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.TRAINEE_ID, themeDisplay.getUserId()));

			List<DutyLog> dutyLogs = dutyLogLocalService.dynamicQuery(dutyLogsDQ);

			JSONArray dutyLogsJSONArray = DutyLoggingUtil.getDutyLogsJSONArray(dutyLogs);

			String successMessage = DutyLoggingUtil.getSuccessMessage(httpRequest);

			responseJSONObj.put(DutyLoggingConstants.STATUS_KEY, DutyLoggingConstants.SUCCESS);
			responseJSONObj.put(DutyLoggingConstants.MESSAGE_KEY, successMessage);
			responseJSONObj.put(DutyLoggingConstants.DATA_KEY, dutyLogsJSONArray);

			resourceResponse.getWriter().write(responseJSONObj.toJSONString());
		} else {
			responseJSONObj.put(DutyLoggingConstants.STATUS_KEY, DutyLoggingConstants.FAIL);
			responseJSONObj.put(DutyLoggingConstants.MESSAGE_KEY, errorMessage);

			resourceResponse.getWriter().write(responseJSONObj.toJSONString());
		}

	}

	private void deleteDutyLogsByTraineeId(String dutyLogIds, String programIdStr) {

		long programId = 0;

		if (Validator.isNotNull(programId)) {
			programId = Long.valueOf(programIdStr);
		}

		if (Validator.isNotNull(dutyLogIds)) {
			String[] ids = dutyLogIds.split(StringPool.COMMA);

			for (String dutyLogId : ids) {
				try {
					DutyLog deleteDutyLog = dutyLogLocalService.deleteDutyLog(Long.valueOf(dutyLogId));

					DutyLogViolation dutyLogViolation = dutyLogViolationLocalService
							.findByDutyLogId(Long.valueOf(dutyLogId));
					if (Validator.isNotNull(dutyLogViolation)) {
						dutyLogViolationLocalService.deleteDutyLogViolation(dutyLogViolation.getViolationId());
					}

					updateDutyLogViolation(deleteDutyLog.getStartDate(), deleteDutyLog.getEndDate(),
							deleteDutyLog.getTraineeId(), programId);
				} catch (NumberFormatException e) {
					log.error("--------Number Format Exception While Converting dutyLogId From String to Long : "
							+ e.getMessage());
				} catch (PortalException e) {
					log.error("--------Error While Deleting DutyLog : " + e.getMessage());
				}
			}
		}

	}

	private void updateDutyLogViolation(Date startDate, Date endDate, long traineeId, long programId) {

		// Fetching programDurationId From The traineeId...
		long cohortId = DutyLoggingUtil.getProgramDurationIdFromTraineeId(traineeId);

		List<DutyRule> dutyRules = programDutyRuleLocalService.getDutyRulesListByProgramAndCohort(programId, cohortId);

		LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		log.info("updateDutyLogViolation----------");
		LocalDate incrementedDate = localEndDate.plusDays(2);
		Date endDateplus2 = Date.from(incrementedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		try {
			List<DutyLogDTO> dutyLogList = dutyLogLocalService.getDutyLogs(startDate, endDateplus2, traineeId);
			log.info("dutyLogList------------" + dutyLogList.size());
			for (DutyLogDTO dutyLogDTO : dutyLogList) {
				ProgramDutyAssignment programDutyAssignment = programDutyAssignmentLocalService
						.getProgramDutyAssignment(dutyLogDTO.getProgramDutyAssignmentId());
				DutyLogViolation dutyLogViolation = dutyLogViolationLocalService
						.findByDutyLogId(dutyLogDTO.getDutyLogId());
				if (dutyLogViolation != null) {
					log.info("if dutyLogViolation" + dutyLogViolation);
					DutyLogViolation violation = checkLogViolation(dutyLogDTO, dutyLogViolation, dutyRules);
					dutyLogViolation = dutyLogViolationLocalService.updateDutyLogViolation(violation);
				} else {
					log.info("else if getLogViolation");

					long dutyLogViolationId = counterLocalService.increment(DutyLogViolation.class.getName());

					DutyLogViolation logViolation = dutyLogViolationLocalService
							.createDutyLogViolation(dutyLogViolationId);

					long programDurationId = DutyLoggingUtil
							.getProgramDurationIdFromTraineeId(dutyLogDTO.getTraineeId());

					List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRelList = ProgdurationRotationTrainingsitesRelLocalServiceUtil
							.findByProgramDurationId(programDurationId);

					long rotationId = progdurationRotationTrainingsitesRelList.get(0).getRotationId();
					long trainingSiteId = progdurationRotationTrainingsitesRelList.get(0).getTrainingSitesId();

					logViolation.setTrainingSiteId(trainingSiteId);
					logViolation.setRotationId(rotationId);
					logViolation.setTraineeId(dutyLogDTO.getTraineeId());
					logViolation.setDutyLogId(dutyLogDTO.getDutyLogId());
					logViolation.setResidencyLevel(dutyLogDTO.getResidencyLevelId());
					logViolation.setBlockId(dutyLogDTO.getBlocksMetadataDetailRelId());
					logViolation.setProgramMasterId(programDutyAssignment.getProgramId());

					// set the value of acgme rules
					DutyLogViolation violation = checkLogViolation(dutyLogDTO, logViolation, dutyRules);
					log.info("else violation " + violation);
					dutyLogViolationLocalService.addDutyLogViolation(violation);
				}

				updateBlockViolation(dutyLogDTO.getBlocksMetadataDetailRelId(), traineeId);

			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private void updateBlockViolation(long blocksMetadataDetailRelId, long traineeId) {

		// Updating Block Level DutyLog Violations If Of Previous Block
		BlocksMetadataDetailsRel blocksMetadataDetailsRel;
		try {
			blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService
					.getBlocksMetadataDetailsRel(blocksMetadataDetailRelId);

			if (Validator.isNotNull(blocksMetadataDetailsRel)) {
				Date todayDate = LogViolationManager.formatedDate(new Date());
				Date blockEndDate = LogViolationManager.formatedDate(blocksMetadataDetailsRel.getBlockEndDate());
				if (todayDate.compareTo(blockEndDate) > 0) {
					TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetails = traineeRotationTsBlockDetailsRelLocalService
							.findByTraineeIdAndBlocksMetadataDetailsRelId(traineeId,
									blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
					LogViolationManager.updateDutyLogBlockLevelViolation(traineeRotationTsBlockDetails);
				} else {
					log.info("--------THIS DUTYLOG DOESN'T RESIDES IN PREVIOUS BLOCK--------");
				}
			} else {
				log.info("-------BLOCKSMETADATADETAILSREL NOT AVAILABLE-------");
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}

	private DutyLogViolation checkLogViolation(DutyLogDTO dutyLogDTO, DutyLogViolation dutyLogViolation,
			List<DutyRule> dutyRules) {
		boolean acgmeCallRuleViolated48Hour = false;
		boolean acgme24PlusRuleViolated = false;
		boolean acgmeShortBreakRuleViolated = false;

		for (DutyRule dutyRule : dutyRules) {
			try {
				// check the 48 option 1 violation boolean
				if (DutyLoggingConstants.ACGME_CALL_RULE_OPTION_ONE_RULE_NAME.equalsIgnoreCase(dutyRule.getRule())) {
					DutyTypes dutyType = LogViolationManager
							.getDutyTypeByDutyLog(dutyLogDTO.getProgramDutyAssignmentId());
					if (Validator.isNotNull(dutyType) && dutyType.getDutyType().equalsIgnoreCase("On Call")) {
						acgmeCallRuleViolated48Hour = LogViolationManager.isAcgmeCallRuleViolated48Hour(
								dutyLogDTO.getProgramDutyAssignmentId(), dutyLogDTO.getTraineeId(),
								dutyLogDTO.getBlocksMetadataDetailRelId(), dutyLogDTO.getDutyLogId());

						log.info("acgmeCallRuleViolated48Hour--" + acgmeCallRuleViolated48Hour);

						if (acgmeCallRuleViolated48Hour) {
							dutyLogViolation.setAcgmeCallRuleOption1(dutyLogViolation.getAcgmeCallRuleOption1() + 1);
						}
					}
				}

				// check the 24+ rule violation
				if (DutyLoggingConstants.ACGME_TWENTY_FOUR_PLUS_RULE_NAME.equalsIgnoreCase(dutyRule.getRule())) {
					acgme24PlusRuleViolated = LogViolationManager.isAcgme24PlusRuleViolated(dutyLogDTO.getDutyLogId());

					log.info("acgme24PlusRuleViolated  " + acgme24PlusRuleViolated);

					if (acgme24PlusRuleViolated) {
						dutyLogViolation.setAcgme24HoursRule(dutyLogViolation.getAcgme24HoursRule() + 1);
					}
				}

				// check the short break rule violation
				if (DutyLoggingConstants.ACGME_SHORT_BREAK_RULE_NAME.equalsIgnoreCase(dutyRule.getRule())) {
					acgmeShortBreakRuleViolated = LogViolationManager
							.isAcgmeShortBreakRuleViolated(dutyLogDTO.getDutyLogId());

					log.info("acgmeShortBreakRuleViolated  " + acgmeShortBreakRuleViolated);

					if (acgmeShortBreakRuleViolated) {
						dutyLogViolation.setAcgmeShortBreakRule(dutyLogViolation.getAcgmeShortBreakRule() + 1);
					}
				}

			} catch (PortalException e) {
				log.error(e.getMessage());
			}
		}

		return dutyLogViolation;

	}

	@Reference
	DutyLogLocalService dutyLogLocalService;

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	DutyLogViolationLocalService dutyLogViolationLocalService;

	@Reference
	ProgramDutyAssignmentLocalService programDutyAssignmentLocalService;

	@Reference
	ProgramDutyRuleLocalService programDutyRuleLocalService;

	@Reference
	BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;

	@Reference
	TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	private Log log = LogFactoryUtil.getLog(AddDutyLogsMVCResourceCommand.class.getName());

}