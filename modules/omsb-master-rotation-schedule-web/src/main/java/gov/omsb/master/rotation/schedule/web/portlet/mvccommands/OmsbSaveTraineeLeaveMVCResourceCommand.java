package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTraineeMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMasterRotationScheduleWebPortletKeys.SAVE_TRAINEE_LEAVE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbSaveTraineeLeaveMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		TraineeDetailsWithBlocksDTO traineeDetailsWithBlocksDTO = new TraineeDetailsWithBlocksDTO();

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbMasterRotationScheduleWebPortletKeys.VIEW_DATE_FORMAT);

		Date leaveFromDate = ParamUtil.getDate(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.LEAVE_FROM,
				new SimpleDateFormat(OmsbMasterRotationScheduleWebPortletKeys.DATE_FORMAT));
		String leaveFrom = sdf.format(leaveFromDate);
		_logger.debug("leavefrom ::::" + leaveFromDate);
		Date leaveToDate = ParamUtil.getDate(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TO,
				new SimpleDateFormat(OmsbMasterRotationScheduleWebPortletKeys.DATE_FORMAT));
		String leaveTo = sdf.format(leaveToDate);
		_logger.debug("leaveTo ::::" + leaveToDate);
		long traineeId = ParamUtil.getLong(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.TRINEE_ID);
		_logger.debug("traineeId ::::" + traineeId);
		long blockId = ParamUtil.getLong(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.BLOCK_ID);
		_logger.debug("blockId ::::" + blockId);
		long programId = ParamUtil.getLong(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID);
		ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programId);
		String programName = programMaster.getProgramName();
		long leaveTypeId = ParamUtil.getLong(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TYPE_ID);
		_logger.debug("leaveTypeId ::::" + leaveTypeId);
		LeaveTypes leaveType = leaveTypesLocalService.getLeaveTypes(leaveTypeId);
		String leaveTypeName = leaveType.getLeaveTypes();
		User user = userLocalService.getUser(traineeId);
		String contactName = ParamUtil.getString(resourceRequest, user.getFullName());
		String contactEmail = ParamUtil.getString(resourceRequest, user.getEmailAddress());
		long dateBeforeInMs = leaveFromDate.getTime();
		long dateAfterInMs = leaveToDate.getTime();

		long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

		long numberOfDays = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS) + 1;
		int noOfDays = (int) numberOfDays;

		boolean isAppliedLeaveValid = false;
		boolean isValidLeave = false;

		Map<String, Long> dataMap = new HashMap<>();
		dataMap.put(OmsbMasterRotationScheduleWebPortletKeys.TRINEE_ID, traineeId);
		dataMap.put(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_ID, programId);
		dataMap.put(OmsbMasterRotationScheduleWebPortletKeys.NUMBER_OF_DAYS,numberOfDays);
		dataMap.put(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TYPE_ID_VAL,leaveTypeId);
		if (leaveFromDate.compareTo(leaveToDate) > 0) {
			prepareErrorJsonResponse(resourceRequest, resourceResponse);
		} else if (OmsbMasterRotationScheduleWebPortletKeys.ANNUAL_LEAVE_TYPE.equals(leaveTypeName)) {
			Map<String, String> stringDataMap = new HashMap<>();
			stringDataMap.put(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_FROM_VAL, leaveFrom);
			stringDataMap.put(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TO_VAL, leaveTo);
			stringDataMap.put(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_NAME, programName);
			isAppliedLeaveValid = validateAnnualLeaveForProgram(resourceRequest, resourceResponse, dataMap, stringDataMap, isAppliedLeaveValid);
		} else {
			isAppliedLeaveValid = validateOtherLeaveTypes(resourceRequest, resourceResponse, dataMap, 
					programName, isAppliedLeaveValid);
		}
		if (isAppliedLeaveValid) {
			long leaveMasterId = counterLocalService.increment(LeaveMaster.class.getName());

			LeaveMaster leaveMaster = leaveMasterLocalService.createLeaveMaster(leaveMasterId);

			leaveMaster.setCreateDate(new Date());
			leaveMaster.setCreatedBy(themeDisplay.getUserId());
			leaveMaster.setModifiedDate(new Date());
			leaveMaster.setModifiedBy(themeDisplay.getUserId());
			leaveMaster.setGroupId(themeDisplay.getScopeGroupId());
			leaveMaster.setCompanyId(themeDisplay.getCompanyId());

			leaveMaster.setTraineeId(traineeId);
			leaveMaster.setLeaveTypeId(leaveTypeId);
			leaveMaster.setLeaveTraineeId(traineeId);
			leaveMaster.setBlockName(String.valueOf(blockId));
			leaveMaster.setLeaveFrom(leaveFromDate);
			leaveMaster.setLeaveTo(leaveToDate);
			leaveMaster.setNoOfDays(noOfDays);
			leaveMaster.setContactName(contactName);
			leaveMaster.setContactEmail(contactEmail);
			leaveMaster.setApplicationDate(new Date());
			leaveMaster.setProgramId(programId);
			leaveMaster.setStatus(WorkflowConstants.STATUS_APPROVED);
			leaveMaster.setStatusByUserId(themeDisplay.getUserId());
			leaveMaster.setStatusDate(new Date());
			leaveMaster.setStatusByUserName(themeDisplay.getUser().getFullName());

			leaveMasterLocalService.addLeaveMaster(leaveMaster);
			LeaveTypes leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveTypeId);
			
			traineeDetailsWithBlocksDTO.setTraineeId(traineeId);
			traineeDetailsWithBlocksDTO.setTraineeName(userLocalService.fetchUser(traineeId).getFullName());
			traineeDetailsWithBlocksDTO.setLeaveMasterId(leaveMasterId);
			traineeDetailsWithBlocksDTO.setLeaveTypeId(leaveTypeId);
			traineeDetailsWithBlocksDTO.setLeaveType(leaveTypes.getLeaveCode());
			traineeDetailsWithBlocksDTO.setLeaveTypeName(leaveTypes.getLeaveTypes());
			traineeDetailsWithBlocksDTO.setFromDate(leaveFromDate);
			traineeDetailsWithBlocksDTO.setToDate(leaveToDate);
			LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService
					.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(programId, leaveTypeId);

			if (Validator.isNotNull(leaveProgramMaster)) {
				isValidLeave = setLeaveTraineeMasterValue(resourceRequest, resourceResponse, themeDisplay, traineeId,
						noOfDays, leaveProgramMaster);
			}

			_logger.debug("Leave Created Successfully.....");
		}

		if (isValidLeave) {

			if (OmsbMasterRotationScheduleWebPortletKeys.ANNUAL_LEAVE_TYPE.equals(leaveTypeName)) {
				validateLeaveAnnualRule(themeDisplay, leaveFromDate, leaveToDate, programId);
			}
			JSONObject resultJson = JSONFactoryUtil.createJSONObject();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			String json = mapper.writeValueAsString(traineeDetailsWithBlocksDTO);
			resultJson.put(CommonConstants.RESULT, json);
			resultJson.put(CommonConstants.SUCCESS, "success");

			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);

		}
		_logger.info("ServeResource end ::: ");
	}

	/**
	 * @param themeDisplay
	 * @param leaveFromDate
	 * @param leaveToDate
	 * @param programId
	 */
	public void validateLeaveAnnualRule(ThemeDisplay themeDisplay, Date leaveFromDate, Date leaveToDate,
			long programId) {
		LeaveAnnualRule leaveAnnualRule = getLeaveAnnualRuleByProgramId(programId);

		int fromDateBlockNumber = getBlockNumberFromDate(leaveFromDate) + 1;
		int toDateBlockNumber = getBlockNumberFromDate(leaveToDate) + 1;

		_logger.debug("fromDateBlockNumber:::" + fromDateBlockNumber);
		_logger.debug("toDateBlockNumber:::" + toDateBlockNumber);

		int fromDateBlockWeekNumber = 0;
		int toDateBlockWeekNumber = 0;
		
		if(null != leaveAnnualRule) {
			String leaveAvailableAt = leaveAnnualRule.getAnnualLeaveAvailableAt();

			if (OmsbMasterRotationScheduleWebPortletKeys.BLOCK_WEEK.equalsIgnoreCase(leaveAvailableAt)) {
				fromDateBlockWeekNumber = getBlockWeekNumberFromDate(leaveFromDate) + 1;
				toDateBlockWeekNumber = getBlockWeekNumberFromDate(leaveToDate) + 1;
			}

			_logger.debug("fromDateBlockWeekNumber:::" + fromDateBlockWeekNumber);
			_logger.debug("toDateBlockWeekNumber:::" + toDateBlockWeekNumber);
			
			LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
					leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
			LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
					leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);

			if (null != fromDateAnnualMaxTrainee) {
				fromDateAnnualMaxTrainee
						.setNoOfTraineeTakenLeave(fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave() + 1);
				
				fromDateAnnualMaxTrainee.setModifiedDate(new Date());
				fromDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());

				leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(fromDateAnnualMaxTrainee);
			}

			if (fromDateBlockNumber != toDateBlockNumber && fromDateBlockWeekNumber != toDateBlockWeekNumber
					&& null != toDateAnnualMaxTrainee) {
				
				toDateAnnualMaxTrainee.setModifiedDate(new Date());
				toDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
				toDateAnnualMaxTrainee
						.setNoOfTraineeTakenLeave(toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave() + 1);

				leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(toDateAnnualMaxTrainee);
			}
		}
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param themeDisplay
	 * @param traineeId
	 * @param noOfDays
	 * @param leaveProgramMaster
	 * @return
	 * @throws IOException
	 */
	public boolean setLeaveTraineeMasterValue(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay, long traineeId, int noOfDays, LeaveProgramMaster leaveProgramMaster)
			throws IOException {
		boolean isValidLeave;
		DynamicQuery leaveTraineeMasterDQ = leaveTraineeMasterLocalService.dynamicQuery();

		leaveTraineeMasterDQ.add(RestrictionsFactoryUtil.eq("leaveProgramMasterId",
				leaveProgramMaster.getLeaveProgramMasterId()));
		leaveTraineeMasterDQ.add(RestrictionsFactoryUtil.eq("traineeId", traineeId));

		List<LeaveTraineeMaster> leaveTraineeMasters = leaveTraineeMasterLocalService
				.dynamicQuery(leaveTraineeMasterDQ);

		if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {
			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

			int numberOfLeaveTaken = leaveTraineeMaster.getNoOfLeaveTaken();

			if ((numberOfLeaveTaken + noOfDays) <= leaveProgramMaster.getNoOfLeaves()) {
				int updatedNumberOfLeavesTaken = numberOfLeaveTaken + noOfDays;
				int updatedNumberOfLeavesRemaining = leaveProgramMaster.getNoOfLeaves()
						- updatedNumberOfLeavesTaken;

				leaveTraineeMaster.setNoOfLeaveTaken(updatedNumberOfLeavesTaken);
				leaveTraineeMaster.setNoOfLeaveRemaining(updatedNumberOfLeavesRemaining);

				leaveTraineeMasterLocalService.updateLeaveTraineeMaster(leaveTraineeMaster);

				isValidLeave = true;
			} else {

				isValidLeave = false;
				
				String errorMessage = "leaves-not-remaining";
				JSONObject resultJson = JSONFactoryUtil.createJSONObject();
				resultJson.put(CommonConstants.RESULT, errorMessage);
				resultJson.put(CommonConstants.SUCCESS, "fail");
				JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);

			}
		} else {
			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasterLocalService.createLeaveTraineeMaster(
					counterLocalService.increment(LeaveTraineeMaster.class.getName(), 1));
			leaveTraineeMaster.setCreateDate(new Date());
			leaveTraineeMaster.setCreatedBy(themeDisplay.getUserId());
			leaveTraineeMaster.setModifiedDate(new Date());
			leaveTraineeMaster.setModifiedBy(themeDisplay.getUserId());
			leaveTraineeMaster.setGroupId(themeDisplay.getScopeGroupId());
			leaveTraineeMaster.setCompanyId(themeDisplay.getCompanyId());

			leaveTraineeMaster.setTraineeId(traineeId);
			leaveTraineeMaster.setNoOfLeaveTaken(noOfDays);
			leaveTraineeMaster.setLeaveProgramMasterId(leaveProgramMaster.getLeaveProgramMasterId());
			leaveTraineeMaster.setNoOfLeaveRemaining(leaveProgramMaster.getNoOfLeaves() - noOfDays);

			leaveTraineeMasterLocalService.addLeaveTraineeMaster(leaveTraineeMaster);

			isValidLeave = true;
		}
		return isValidLeave;
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param longValueMap
	 * @param programName
	 * @param isAppliedLeaveValid
	 * @return
	 * @throws Exception
	 */
	public boolean validateOtherLeaveTypes(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			Map<String, Long> longValueMap, String programName, 
			boolean isAppliedLeaveValid) throws Exception {
		long traineeId = longValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.TRINEE_ID);
		long programId = longValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_ID);
		long leaveTypeId = longValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TYPE_ID_VAL);
		long numberOfDays =  longValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.NUMBER_OF_DAYS);
		if (Validator.isNotNull(programName)) {

			LeaveProgramMaster leaveProgramMaster = OmsbTmsCommonUtil
					.getLeaveProgramMasterFromProgramIdLeaveTypeId(programId, leaveTypeId);

			if (Validator.isNotNull(leaveProgramMaster)) {
				isAppliedLeaveValid = validateLeaveTraineeMasterForOtherLeaves(resourceRequest, resourceResponse,
						traineeId, numberOfDays, leaveProgramMaster);
			} else {
				isAppliedLeaveValid = true;
			}
		}
		return isAppliedLeaveValid;
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param traineeId
	 * @param numberOfDays
	 * @param leaveProgramMaster
	 * @return
	 * @throws Exception
	 */
	public boolean validateLeaveTraineeMasterForOtherLeaves(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, long traineeId, long numberOfDays, LeaveProgramMaster leaveProgramMaster)
			throws Exception {
		boolean isAppliedLeaveValid;
		List<LeaveTraineeMaster> leaveTraineeMasters = OmsbTmsCommonUtil
				.getTraineeLeaveRecordsFromLeaveProgramMasterId(
						leaveProgramMaster.getLeaveProgramMasterId());
		leaveTraineeMasters = leaveTraineeMasters.stream().filter(obj -> obj.getTraineeId() == traineeId)
				.collect(Collectors.toList());
		if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {

			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

			int numberOfLeavesRemaining = leaveTraineeMaster.getNoOfLeaveRemaining();

			if (numberOfLeavesRemaining >= numberOfDays) {
				isAppliedLeaveValid = true;
			} else {
				isAppliedLeaveValid = false;
				OmsbTmsCommonUtil.setLeavesNotRemainingErrorMessage(resourceRequest, resourceResponse,
						numberOfDays, numberOfLeavesRemaining);
			}

		} else {

			if (leaveProgramMaster.getNoOfLeaves() >= numberOfDays) {
				isAppliedLeaveValid = true;
			} else {
				isAppliedLeaveValid = false;
				OmsbTmsCommonUtil.setLessDaysConfiguredErrorMessage(resourceRequest, resourceResponse);
			}

		}
		return isAppliedLeaveValid;
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param sdf
	 * @param dataMap
	 * @param stringDataMap
	 * @param isAppliedLeaveValid
	 * @return
	 * @throws Exception
	 */
	public boolean validateAnnualLeaveForProgram(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			Map<String, Long> dataMap, Map<String, String> stringDataMap, boolean isAppliedLeaveValid) throws Exception {
		long traineeId = dataMap.get(OmsbMasterRotationScheduleWebPortletKeys.TRINEE_ID);
		long programId = dataMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_ID);
		long leaveTypeId = dataMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TYPE_ID_VAL);
		long numberOfDays =  dataMap.get(OmsbMasterRotationScheduleWebPortletKeys.NUMBER_OF_DAYS);
		String programName = stringDataMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_NAME);
		String leaveFrom = stringDataMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_FROM_VAL);
		String leaveTo = stringDataMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TO_VAL);
		if (Validator.isNotNull(programName)) {

			DynamicQuery leaveAnnualRuleDQ = leaveAnnualRuleLocalService.dynamicQuery();

			leaveAnnualRuleDQ.add(RestrictionsFactoryUtil
					.eq(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID_COLUMN, programId));

			List<LeaveAnnualRule> leaveAnnualRules = leaveAnnualRuleLocalService.dynamicQuery(leaveAnnualRuleDQ);

			LeaveProgramMaster leaveProgramMaster = OmsbTmsCommonUtil
					.getLeaveProgramMasterFromProgramIdLeaveTypeId(programId, leaveTypeId);

			if (Validator.isNotNull(leaveProgramMaster)) {

				List<LeaveTraineeMaster> leaveTraineeMasters = OmsbTmsCommonUtil
						.getTraineeLeaveRecordsFromLeaveProgramMasterId(
								leaveProgramMaster.getLeaveProgramMasterId());

				leaveTraineeMasters = leaveTraineeMasters.stream().filter(obj -> obj.getTraineeId() == traineeId)
						.collect(Collectors.toList());

				Map<String, String> dataValueMap = new HashMap<>();
				dataValueMap.put(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_FROM_VAL, leaveFrom);
				dataValueMap.put(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TO_VAL, leaveTo);
				dataValueMap.put(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_NAME, programName);
				if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {

					isAppliedLeaveValid = validateLeaveTraineeMasterDetails(resourceRequest, resourceResponse,
							isAppliedLeaveValid, numberOfDays, dataValueMap, leaveAnnualRules,
							leaveTraineeMasters);

				} else {
					isAppliedLeaveValid = validateNumberOfLeaveDetails(resourceRequest, resourceResponse,
							isAppliedLeaveValid, numberOfDays, dataValueMap, leaveAnnualRules,
							leaveProgramMaster);

				}

			} else {
				isAppliedLeaveValid = true;
			}

		}
		return isAppliedLeaveValid;
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param isAppliedLeaveValid
	 * @param numberOfDays
	 * @param dataValueMap
	 * @param leaveAnnualRules
	 * @param leaveProgramMaster
	 * @return
	 * @throws Exception
	 */
	public boolean validateNumberOfLeaveDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			boolean isAppliedLeaveValid, long numberOfDays, Map<String, String> dataValueMap, List<LeaveAnnualRule> leaveAnnualRules, LeaveProgramMaster leaveProgramMaster)
			throws Exception {
		_logger.debug("numberOfDays::" + numberOfDays);
		String programName = dataValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_NAME);
		String leaveFrom = dataValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_FROM_VAL);
		String leaveTo = dataValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TO_VAL);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbMasterRotationScheduleWebPortletKeys.VIEW_DATE_FORMAT);
		if (leaveProgramMaster.getNoOfLeaves() >= numberOfDays) {
			if (numberOfDays <= 2) {
				isAppliedLeaveValid = OmsbTmsCommonUtil.checkIsAppliedLeaveValidForFirstCase(
						resourceRequest, resourceResponse, sdf, leaveAnnualRules, programName,
						leaveFrom, leaveTo);
			} else if (numberOfDays > 2 && numberOfDays < 28) {
				isAppliedLeaveValid = OmsbTmsCommonUtil.checkIsAppliedLeaveValidForSecondCase(
						resourceRequest, resourceResponse, sdf, leaveAnnualRules, programName,
						leaveFrom, leaveTo, numberOfDays);
			} else if (numberOfDays >= 28 && numberOfDays <= 30) {
				isAppliedLeaveValid = OmsbTmsCommonUtil.checkIsAppliedLeaveValidForThirdCase(
						resourceRequest, resourceResponse, sdf, leaveAnnualRules, programName,
						leaveFrom, leaveTo);
			}

		} else {
			isAppliedLeaveValid = false;
			OmsbTmsCommonUtil.setLessDaysConfiguredErrorMessage(resourceRequest, resourceResponse);
		}
		return isAppliedLeaveValid;
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param isAppliedLeaveValid
	 * @param numberOfDays
	 * @param dataValueMap
	 * @param leaveAnnualRules
	 * @param leaveTraineeMasters
	 * @return
	 * @throws Exception
	 */
	public boolean validateLeaveTraineeMasterDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			boolean isAppliedLeaveValid, long numberOfDays, Map<String, String> dataValueMap, List<LeaveAnnualRule> leaveAnnualRules, List<LeaveTraineeMaster> leaveTraineeMasters)
			throws Exception {
		String programName = dataValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_NAME);
		String leaveFrom = dataValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_FROM_VAL);
		String leaveTo = dataValueMap.get(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_TO_VAL);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbMasterRotationScheduleWebPortletKeys.VIEW_DATE_FORMAT);
		LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

		int numberOfLeavesRemaining = leaveTraineeMaster.getNoOfLeaveRemaining();
		_logger.debug("numberOfDays::" + numberOfDays);
		if (numberOfLeavesRemaining >= numberOfDays) {
			if (numberOfDays <= 2) {
				isAppliedLeaveValid = OmsbTmsCommonUtil.checkIsAppliedLeaveValidForFirstCase(
						resourceRequest, resourceResponse, sdf, leaveAnnualRules, programName,
						leaveFrom, leaveTo);
			} else if (numberOfDays > 2 && numberOfDays < 28) {

				isAppliedLeaveValid = OmsbTmsCommonUtil.checkIsAppliedLeaveValidForSecondCase(
						resourceRequest, resourceResponse, sdf, leaveAnnualRules, programName,
						leaveFrom, leaveTo, numberOfDays);

			} else if (numberOfDays >= 28 && numberOfDays <= 30) {

				isAppliedLeaveValid = OmsbTmsCommonUtil.checkIsAppliedLeaveValidForThirdCase(
						resourceRequest, resourceResponse, sdf, leaveAnnualRules, programName,
						leaveFrom, leaveTo);
			}
		} else {
			isAppliedLeaveValid = false;
			OmsbTmsCommonUtil.setLeavesNotRemainingErrorMessage(resourceRequest, resourceResponse,
					numberOfDays, numberOfLeavesRemaining);
		}
		return isAppliedLeaveValid;
	}

	/**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	public void prepareErrorJsonResponse(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException {
		String errorMessage = "please-select-appropriate-end-date";
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.RESULT, errorMessage);
		resultJson.put(CommonConstants.SUCCESS, "fail");
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	private LeaveAnnualRule getLeaveAnnualRuleByProgramId(long programId) {

		LeaveAnnualRule leaveAnnualRule = null;

		DynamicQuery leaveAnnualRuleDQ = leaveAnnualRuleLocalService.dynamicQuery();

		leaveAnnualRuleDQ
				.add(RestrictionsFactoryUtil.eq(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID, programId));

		List<LeaveAnnualRule> leaveAnnualRules = leaveAnnualRuleLocalService.dynamicQuery(leaveAnnualRuleDQ);

		if (Validator.isNotNull(leaveAnnualRules) && !leaveAnnualRules.isEmpty()) {
			leaveAnnualRule = leaveAnnualRules.get(0);
		}

		return leaveAnnualRule;

	}

	private int getBlockNumberFromDate(Date date) {
		long daysDiff = getDaysDiff(date);
		return (int) (daysDiff / 28);
	}

	private int getBlockWeekNumberFromDate(Date date) {
		long daysDiff = getDaysDiff(date);
		int daysPassedInBlock = (int) (daysDiff % 28);
		return (daysPassedInBlock / 7);
	}

	@SuppressWarnings("deprecation")
	private long getDaysDiff(Date date) {

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

	private LeaveAnnualMaxTrainee getAnnualMaxTraineeByBlockWeekAnnualRuleId(long annualRuleId, int block, int week) {

		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee = null;
		DynamicQuery annualMaxTraineeDQ = leaveAnnualMaxTraineeLocalService.dynamicQuery();

		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbMasterRotationScheduleWebPortletKeys.LEAVE_ANNUAL_RULE_ID,
				annualRuleId));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbMasterRotationScheduleWebPortletKeys.BLOCK, block));
		annualMaxTraineeDQ.add(RestrictionsFactoryUtil.eq(OmsbMasterRotationScheduleWebPortletKeys.WEEK, week));

		List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees = leaveAnnualMaxTraineeLocalService
				.dynamicQuery(annualMaxTraineeDQ);

		if (Validator.isNotNull(leaveAnnualMaxTrainees) && !leaveAnnualMaxTrainees.isEmpty()) {
			leaveAnnualMaxTrainee = leaveAnnualMaxTrainees.get(0);
		}

		return leaveAnnualMaxTrainee;

	}

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	LeaveTraineeMasterLocalService leaveTraineeMasterLocalService;

	@Reference
	LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

	@Reference
	LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;

	@Reference
	private LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private UserLocalService userLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveTraineeLeaveMVCResourceCommand.class);

}
