package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalServiceUtil;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTraineeMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMasterRotationScheduleWebPortletKeys.DELETE_TRAINEE_LEAVE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbDeleteTraineeLeaveMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");
		boolean isSucess = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programId = ParamUtil.getLong(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID);
		long leaveId = ParamUtil.getLong(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.LEAVE_MASTER_ID);
		_logger.debug("programId" + programId);
		_logger.debug("leaveId" + leaveId);

		LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveId);
		_logger.debug(leaveMaster.toString());
		long diff = Math.abs(leaveMaster.getLeaveFrom().getTime() - leaveMaster.getLeaveTo().getTime());
		float days = (diff / (1000 * 60 * 60 * 24));
		int day = (int) days + 1;
		_logger.debug("days" + day);
		LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService
				.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(programId, leaveMaster.getLeaveTypeId());
		_logger.debug(leaveProgramMaster.toString());

		DynamicQuery query = leaveTraineeMasterLocalService.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(PropertyFactoryUtil.forName("traineeId").eq(leaveMaster.getTraineeId()));
		conjunction.add(
				PropertyFactoryUtil.forName("leaveProgramMasterId").eq(leaveProgramMaster.getLeaveProgramMasterId()));
		query.add(conjunction);
		List<LeaveTraineeMaster> leavetraineeMasterList = leaveTraineeMasterLocalService.dynamicQuery(query);

		LeaveTypes leaveType = leaveTypesLocalService.getLeaveTypes(leaveMaster.getLeaveTypeId());

		if (!leaveType.getLeaveTypes().equalsIgnoreCase("Annual Leave")) {
			isSucess = updateLeaveTraineeMaster(themeDisplay, leaveId, day, leavetraineeMasterList);
		} else {
			DynamicQuery leaveAnnualRuleLocalServicequery = leaveAnnualRuleLocalService.dynamicQuery();
			leaveAnnualRuleLocalServicequery.add(PropertyFactoryUtil.forName("programMasterId").eq(programId));
			List<LeaveAnnualRule> traineeRotationTsBlockDetailsRels = leaveAnnualRuleLocalService
					.dynamicQuery(leaveAnnualRuleLocalServicequery);
			if (Validator.isNotNull(traineeRotationTsBlockDetailsRels)
					&& traineeRotationTsBlockDetailsRels.size() == 1) {
				isSucess = setAnnualLeaveRules(themeDisplay, leaveMaster, traineeRotationTsBlockDetailsRels);
			}
			for (LeaveTraineeMaster leaveTraineeMaster : leavetraineeMasterList) {
				int takenLeave = leaveTraineeMaster.getNoOfLeaveTaken();
				int remainingLeave = leaveTraineeMaster.getNoOfLeaveRemaining();
				leaveTraineeMaster.setNoOfLeaveTaken(takenLeave - day);
				leaveTraineeMaster.setNoOfLeaveRemaining(remainingLeave + day);
				leaveTraineeMaster.setModifiedDate(new Date());
				leaveTraineeMaster.setModifiedBy(themeDisplay.getUserId());
				leaveTraineeMasterLocalService.updateLeaveTraineeMaster(leaveTraineeMaster);
				_logger.debug(leaveTraineeMaster.toString());
			}
			leaveMasterLocalService.deleteLeaveMaster(leaveId);
		}
		_logger.info("ServeResource exit ::: ");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = mapper.writeValueAsString(isSucess);
		resourceResponse.getWriter().write(json);

	}

	/**
	 * @param themeDisplay
	 * @param leaveMaster
	 * @param traineeRotationTsBlockDetailsRels
	 * @return
	 */
	public boolean setAnnualLeaveRules(ThemeDisplay themeDisplay, LeaveMaster leaveMaster,
			List<LeaveAnnualRule> traineeRotationTsBlockDetailsRels) {
		boolean isSucess;
		LeaveAnnualRule leaveAnnualRule = traineeRotationTsBlockDetailsRels.get(0);

		int fromDateBlockNumber = getBlockNumberFromDate(leaveMaster.getLeaveFrom()) + 1;

		int toDateBlockNumber = getBlockNumberFromDate(leaveMaster.getLeaveTo()) + 1;

		LeaveAnnualMaxTrainee fromDateAnnualMaxTrainee = null;
		LeaveAnnualMaxTrainee toDateAnnualMaxTrainee = null;

		if (leaveAnnualRule.getAnnualLeaveAvailableAt().equals(OmsbTmsCommonConstants.BLOCK_NAME)) {
			fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
					leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, 0);
			toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
					leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, 0);
		} else {
			int fromDateBlockWeekNumber = getBlockWeekNumberFromDate(leaveMaster.getLeaveFrom()) + 1;
			int toDateBlockWeekNumber = getBlockWeekNumberFromDate(leaveMaster.getLeaveTo()) + 1;

			fromDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
					leaveAnnualRule.getLeaveAnnualRuleId(), fromDateBlockNumber, fromDateBlockWeekNumber);
			toDateAnnualMaxTrainee = getAnnualMaxTraineeByBlockWeekAnnualRuleId(
					leaveAnnualRule.getLeaveAnnualRuleId(), toDateBlockNumber, toDateBlockWeekNumber);
		}

		if (null != fromDateAnnualMaxTrainee) {
			int noOfTraineeTakenLeave = fromDateAnnualMaxTrainee.getNoOfTraineeTakenLeave();
			fromDateAnnualMaxTrainee.setNoOfTraineeTakenLeave(noOfTraineeTakenLeave + 1);
			fromDateAnnualMaxTrainee.setModifiedDate(new Date());
			fromDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(fromDateAnnualMaxTrainee);
		}
		if (null != toDateAnnualMaxTrainee) {
			int noOfTraineeTakenLeave = toDateAnnualMaxTrainee.getNoOfTraineeTakenLeave();
			toDateAnnualMaxTrainee.setNoOfTraineeTakenLeave(noOfTraineeTakenLeave + 1);
			toDateAnnualMaxTrainee.setModifiedDate(new Date());
			toDateAnnualMaxTrainee.setModifiedBy(themeDisplay.getUserId());
			leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(fromDateAnnualMaxTrainee);
		}
		isSucess = true;
		return isSucess;
	}

	/**
	 * @param themeDisplay
	 * @param leaveId
	 * @param day
	 * @param leavetraineeMasterList
	 * @return
	 * @throws PortalException
	 */
	public boolean updateLeaveTraineeMaster(ThemeDisplay themeDisplay, long leaveId, int day,
			List<LeaveTraineeMaster> leavetraineeMasterList) throws PortalException {
		boolean isSucess;
		for (LeaveTraineeMaster leaveTraineeMaster : leavetraineeMasterList) {
			int takenLeave = leaveTraineeMaster.getNoOfLeaveTaken();
			int remainingLeave = leaveTraineeMaster.getNoOfLeaveRemaining();
			leaveTraineeMaster.setNoOfLeaveTaken(takenLeave - day);
			leaveTraineeMaster.setNoOfLeaveRemaining(remainingLeave + day);
			leaveTraineeMaster.setModifiedDate(new Date());
			leaveTraineeMaster.setModifiedBy(themeDisplay.getUserId());
			leaveTraineeMasterLocalService.updateLeaveTraineeMaster(leaveTraineeMaster);
			_logger.debug(leaveTraineeMaster.toString());
		}
		leaveMasterLocalService.deleteLeaveMaster(leaveId);
		isSucess = true;
		return isSucess;
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

		if (Validator.isNotNull(leaveAnnualMaxTrainees) && !leaveAnnualMaxTrainees.isEmpty()) {
			leaveAnnualMaxTrainee = leaveAnnualMaxTrainees.get(0);
		}

		return leaveAnnualMaxTrainee;

	}

	public static int getBlockNumberFromDate(Date date) {
		long daysDiff = getDaysDiffByDateInCurrentAY(date);
		return (int) (daysDiff / 28);
	}

	public static int getBlockWeekNumberFromDate(Date date) {
		long daysDiff = getDaysDiffByDateInCurrentAY(date);
		int daysPassedInBlock = (int) (daysDiff % 28);
		daysPassedInBlock = daysPassedInBlock /7;
		return daysPassedInBlock;
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

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteTraineeLeaveMVCResourceCommand.class);

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	private LeaveTraineeMasterLocalService leaveTraineeMasterLocalService;

	@Reference
	private LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	private LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	private LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;

}