package gov.omsb.tms.common.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalServiceUtil;
import gov.omsb.tms.service.LeaveMasterLocalServiceUtil;
import gov.omsb.tms.service.LeaveProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.LeaveTraineeMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;

public class OmsbTmsCommonUtil {

	private OmsbTmsCommonUtil() {
	}

	public static String getValueByLanguage(String xmlString, String attibuteName, String languageCode) {
		String value = StringPool.BLANK;
		try {
			Document programName = SAXReaderUtil.read(xmlString);
			Node node = programName.selectSingleNode("/root/" + attibuteName + "[@language-id='" + languageCode + "']");
			value = node.getText();
		} catch (Exception e) {
			value = xmlString;
			_logger.error(e.getMessage() + xmlString);
		}
		return value;
	}

	public static boolean isAllTraineeTakenLeaveForCurrentYear(long programDurationId, long traineeLevelId) {
		_logger.info("isAllTraineeTakenLeaveForCurrentYear Invoked ::: ");
		long currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String cohortYear = currentYear + StringPool.DASH + (currentYear + 1);

		try {
			// GET Trainee Details base on prodgram duration
			List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRels = TraineeAdmissionDetailsRelLocalServiceUtil
					.findByProgramDurationId(programDurationId);
			List<TraineeCohortDetails> traineeCohortDetails = new ArrayList<>();
			for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel : traineeAdmissionDetailsRels) {
				try {
					traineeCohortDetails.addAll(TraineeCohortDetailsLocalServiceUtil
							.findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
									traineeAdmissionDetailsRel.getTraineeAdmissionDetailsRelId(), cohortYear,
									traineeLevelId));
				} catch (Exception e) {
					_logger.error(e.getMessage());
				}
			}

			List<Long> traineeAdmissionDetailsRelIds = traineeCohortDetails.stream()
					.map(TraineeCohortDetails::getTraineeAdmissionDetailsRelId).collect(Collectors.toList());
			List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRelsForTraineeIds = TraineeAdmissionDetailsRelLocalServiceUtil
					.findByTraineeAdmissionDetailsRelIds(traineeAdmissionDetailsRelIds);

			List<Long> traineeIds = traineeAdmissionDetailsRelsForTraineeIds.stream()
					.map(TraineeAdmissionDetailsRel::getTraineeId).collect(Collectors.toList());

			Calendar startDate = Calendar.getInstance();
			startDate.set((int) currentYear, 8, 1);
			Calendar endDate = (Calendar) startDate.clone();
			endDate.add(Calendar.YEAR, 1);
			List<LeaveMaster> leaveMasters = LeaveMasterLocalServiceUtil.findLeaveDetailsByTraineeIds(traineeIds,
					startDate.getTime(), endDate.getTime());

			List<Long> leaveTraineeIds = leaveMasters.stream().map(LeaveMaster::getTraineeId)
					.collect(Collectors.toList());

			traineeIds.removeAll(leaveTraineeIds);
			_logger.info("isAllTraineeTakenLeaveForCurrentYear Exit ::: ");
			return traineeIds.isEmpty();
		} catch (Exception e) {
			_logger.error(e);
		}
		_logger.info("isAllTraineeTakenLeaveForCurrentYear Exit ::: ");
		return false;
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

	public static List<LeaveTraineeMaster> getTraineeLeaveRecordsFromLeaveProgramMasterId(long leaveProgramMasterId)
			throws PortalException {

		DynamicQuery dynamicQuery = LeaveTraineeMasterLocalServiceUtil.dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq("leaveProgramMasterId", leaveProgramMasterId));

		return LeaveTraineeMasterLocalServiceUtil.dynamicQuery(dynamicQuery);

	}

	public static boolean checkIsAppliedLeaveValidForFirstCase(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, SimpleDateFormat sdf, List<LeaveAnnualRule> leaveAnnualRules,
			String programName, String leaveFrom, String leaveTo) throws Exception {

		boolean isAppliedLeaveValid = false;

		if (Validator.isNotNull(leaveAnnualRules) && leaveAnnualRules.size() == 1) {
			LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

			int fromDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveFrom)) + 1;
			int toDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveTo)) + 1;

			LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = null;
			LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = null;

			if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbTmsCommonConstants.BLOCK_NAME)) {
				fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, 0);
				toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, 0);
			} else {
				int fromDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveFrom)) + 1;
				int toDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveTo)) + 1;

				fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
				toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);
			}

			if (Validator.isNotNull(fromDateAnnualMaxTrainee) && Validator.isNotNull(toDateAnnualMaxTrainee)) {
				if (fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0
						|| toDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0) {
					isAppliedLeaveValid = false;
					setLeavesNotAllowedErrorMessage(resourceRequest, resourceResponse);
				} else {
					if ((fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
							- fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0
							|| (toDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
									- toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0) {
						isAppliedLeaveValid = true;
					} else {
						isAppliedLeaveValid = false;
						setMaximumTraineesAlreadyTakenErrorMessage(resourceRequest, resourceResponse);
					}
				}
			} else {
				isAppliedLeaveValid = true;
			}
		}

		return isAppliedLeaveValid;

	}

	public static boolean checkIsAppliedLeaveValidForSecondCase(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, SimpleDateFormat sdf, List<LeaveAnnualRule> leaveAnnualRules,
			String programName, String leaveFrom, String leaveTo, long noOfDays) throws Exception {

		boolean isAppliedLeaveValid = false;

		if (Validator.isNotNull(leaveAnnualRules) && leaveAnnualRules.size() == 1) {
			LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

			if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbTmsCommonConstants.BLOCK_NAME)) {
				isAppliedLeaveValid = false;
				setLeavesAvailableAtBlockErrorMessage(resourceRequest, resourceResponse, programName);
			} else {
				int fromDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveFrom)) + 1;
				int toDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveTo)) + 1;

				int fromDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveFrom)) + 1;
				int toDateBlockWeekNumber = getBlockWeekNumberFromDate(sdf.parse(leaveTo)) + 1;

				LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
				LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);

				boolean isViolatingAttendance = isViolatingAttendanceCriteria(sdf, leaveFrom, leaveTo,
						fromDateBlockNumber, toDateBlockNumber, noOfDays);

				if (noOfDays > 7) {
					isAppliedLeaveValid = false;
					setLeavesAvailableAtBlockWeekErrorMessage(resourceRequest, resourceResponse, programName);
				} else {
					if (isViolatingAttendance) {
						isAppliedLeaveValid = false;
						setAttendanceViolationErrorMessage(resourceRequest, resourceResponse);
					} else {
						if (Validator.isNotNull(fromDateAnnualMaxTrainee)
								&& Validator.isNotNull(toDateAnnualMaxTrainee)) {
							if (fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0
									|| toDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0) {
								isAppliedLeaveValid = false;
								setLeavesNotAllowedErrorMessage(resourceRequest, resourceResponse);
							} else {
								if ((fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
										- fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0
										&& (toDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
												- toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0) {
									isAppliedLeaveValid = true;
								} else {
									isAppliedLeaveValid = false;
									setMaximumTraineesAlreadyTakenErrorMessage(resourceRequest, resourceResponse);
								}
							}

						} else {
							isAppliedLeaveValid = true;
						}
					}
				}

			}
		}

		return isAppliedLeaveValid;

	}

	public static boolean checkIsAppliedLeaveValidForThirdCase(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, SimpleDateFormat sdf, List<LeaveAnnualRule> leaveAnnualRules,
			String programName, String leaveFrom, String leaveTo) throws Exception {

		boolean isAppliedLeaveValid = false;

		if (Validator.isNotNull(leaveAnnualRules) && leaveAnnualRules.size() == 1) {
			LeaveAnnualRule leaveAnnualRule = leaveAnnualRules.get(0);

			if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbTmsCommonConstants.BLOCK_WEEK)) {
				isAppliedLeaveValid = false;
				setLeavesAvailableAtBlockWeekErrorMessage(resourceRequest, resourceResponse, programName);
			} else {
				int fromDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveFrom)) + 1;
				int toDateBlockNumber = getBlockNumberFromDate(sdf.parse(leaveTo)) + 1;

				LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, 0);
				LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
						leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, 0);

				int fdBlockLeaveTaken = getNoLeavesTakenInBlock(sdf.parse(leaveFrom), true);
				int tdBlockLeaveTaken = getNoLeavesTakenInBlock(sdf.parse(leaveTo), false);

				if (fdBlockLeaveTaken <= 7 || tdBlockLeaveTaken <= 7) {
					if (Validator.isNotNull(fromDateAnnualMaxTrainee) && Validator.isNotNull(toDateAnnualMaxTrainee)) {
						if (fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0
								|| toDateAnnualMaxTrainee.getMaxTraineeApplyLeave() == 0) {
							isAppliedLeaveValid = false;
							setLeavesNotAllowedErrorMessage(resourceRequest, resourceResponse);
						} else {
							if ((fromDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
									- fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0
									&& (toDateAnnualMaxTrainee.getMaxTraineeApplyLeave()
											- toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave()) != 0) {
								isAppliedLeaveValid = true;
							} else {
								isAppliedLeaveValid = false;
								setMaximumTraineesAlreadyTakenErrorMessage(resourceRequest, resourceResponse);
							}
						}
					} else {
						isAppliedLeaveValid = true;
					}
				} else {
					isAppliedLeaveValid = false;
					setAttendanceViolationErrorMessage(resourceRequest, resourceResponse);
				}
			}

		}

		return isAppliedLeaveValid;

	}

	public static int getBlockNumberFromDate(Date date) {
		long daysDiff = getDaysDiffByDateInCurrentAY(date);
		return (int) (daysDiff / 28);
	}

	public static int getBlockWeekNumberFromDate(Date date) {
		long daysDiff = getDaysDiffByDateInCurrentAY(date);
		int daysPassedInBlock = (int) (daysDiff % 28);
		return (int) (daysPassedInBlock / 7);
	}

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

		long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

		return daysDiff;

	}

	public static LeaveAnnualMaxTrainee getAnnualMaxTraineeByBlockWeekAnnualRuleId(long annualRuleId, int block,
			int week) {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = null;
		DynamicQuery annualMaxTraineeDQ = LeaveAnnualMaxTraineeLocalServiceUtil.dynamicQuery();

		annualMaxTraineeDQ
				.add(RestrictionsFactoryUtil.eq(OmsbTmsCommonConstants.LEAVE_ANNUAL_RULE_ID_COLUMN, annualRuleId));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbTmsCommonConstants.BLOCK_COLUMN, block));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbTmsCommonConstants.WEEK_COLUMN, week));

		List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees = LeaveAnnualMaxTraineeLocalServiceUtil
				.dynamicQuery(annualMaxTraineeDQ);

		if (Validator.isNotNull(leaveAnnualMaxTrainees) && leaveAnnualMaxTrainees.size() > 0) {
			leaveAnnualMaxTrainee = leaveAnnualMaxTrainees.get(0);
		}

		return leaveAnnualMaxTrainee;

	}

	public static void setLeavesNotAllowedErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		_logger.info("NOT A SINGLE TRAINEE ARE ALLOWED TO TAKE A LEAVE IN THIS BLOCK");
		String errorMessage = "not-allowed-to-take-leaves";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static void setMaximumTraineesAlreadyTakenErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		_logger.info("MAXIMUM NUMBER OF TRAINEES APPLIED FOR LEAVE IN THIS BLOCK");

		String errorMessage = "maximum-trainees-already-applied";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static void setLeavesAvailableAtBlockErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String programName) throws Exception {
		_logger.info("ANNUAL LEAVE CONFIGURED FOR " + programName + " PROGRAM IS AT BLOCK LEVEL");

		String errorMessage = "leaves-available-at-block-level";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static void setLeavesAvailableAtBlockWeekErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String programName) throws Exception {
		_logger.info("ANNUAL LEAVE CONFIGURED FOR " + programName + " PROGRAM IS AT BLOCK WEEK LEVEL");

		String errorMessage = "leaves-available-at-block-week-level";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static void setAttendanceViolationErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		_logger.info("VIOLATING 75% ATTENDANCE RULE");

		String errorMessage = "violating-attendance-criteria";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static void setLessDaysConfiguredErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		_logger.info("LESS DAYS CONFIGURED FOR THIS LEAVE TYPE");

		String errorMessage = "less-days-configured";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static void setLeavesNotRemainingErrorMessage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, long numberOfDays, int numberOfLeavesRemaining) throws Exception {
		_logger.info("YOU ARE APPLYING FOR " + numberOfDays + " DAYS BUT THE LEAVES REMAINING IS "
				+ numberOfLeavesRemaining);

		String errorMessage = "leaves-not-remaining";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put("result", errorMessage);
		resultJson.put("success", "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	public static boolean isViolatingAttendanceCriteria(SimpleDateFormat sdf, String leaveFrom, String leaveTo,
			int fromDateBlockNumber, int toDateBlockNumber, long noOfDays) throws ParseException {
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

	public static int getNoLeavesTakenInBlock(Date date, boolean isFromDate) {
		long daysDiff = getDaysDiffByDateInCurrentAY(date);
		int daysPassedInBlock = (int) (daysDiff % 28);
		if (isFromDate) {
			return (int) (28 - daysPassedInBlock);
		} else {
			return daysPassedInBlock;
		}
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTmsCommonUtil.class.getName());
}
