package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamMultiDates;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.dto.WithdrawalFees;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EXAM_CONFIRM_WITHDRAWAL, }, service = MVCResourceCommand.class)
public class ExamWithdrawalMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long examDefinitionId = ParamUtil.getLong(resourceRequest, OMSBExamWebPortletKeys.EXAM_DEFINITION_ID);
			long examScheduleId = ParamUtil.getLong(resourceRequest, OMSBExamWebPortletKeys.EXAM_SCHEDULE_ID);
			long lrUserId = ParamUtil.getLong(resourceRequest, OMSBExamWebPortletKeys.LRUSER_ID);
			if (lrUserId <= 0) {
				lrUserId = themeDisplay.getUserId();
			}
			logger.info(examDefinitionId);
			float withdrawalFeesPercentage = 0;
			double withdrawalFee = 0;

			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			ExamSchedule examSchedule = examUtil.getExamScheduleById(examScheduleId, themeDisplay.getPortalURL());
			RegistrationItem registrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(),lrUserId,
					examScheduleId);
			List<WithdrawalFees> withdrawalFeesList = examUtil.getExamWithdrawalFeesByDefinationId(examDefinitionId,
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
			
			if(logger.isDebugEnabled()) {
				logger.debug("check examSchedule :: "+Validator.isNotNull(examSchedule));
				logger.debug("withdrawalFeesList :: "+withdrawalFeesList);
			}
			
			logger.info("examSchedule.getId() >>>>>>>>>>>" + examSchedule.getId());
			if (Validator.isNotNull(examSchedule)) {
				ExamMultiDatesItem examMultiDateItem = scheduleUtil.getExamMultiDatesItemBasedOnScheduleAdminId(themeDisplay, examSchedule.getExamScheduleAdminId());
				if(Validator.isNotNull(examMultiDateItem) && Validator.isNotNull(examMultiDateItem.getItems()) && !examMultiDateItem.getItems().isEmpty() ) {
					ExamMultiDates examMultiDates = examMultiDateItem.getItems().get(0);
					examMultiDates.getExamDate();
				
				String examDateStr = examMultiDates.getExamDate();
				logger.info("examDateStr"+ examDateStr);
				if(Validator.isNotNull(examDateStr)) {
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",
							Locale.ENGLISH);
					LocalDate todatDate = LocalDate.now();
					LocalDate examDate = LocalDate.parse(examDateStr, formatter);
					long noOfDays = ChronoUnit.DAYS.between(todatDate, examDate);
					logger.info("noOfDays >>>>>>"+ noOfDays);
					int first=0;
					int second=0;
					for (WithdrawalFees withdrawalFees : withdrawalFeesList) {
						String noOfDaystr=withdrawalFees.getNoOfDays();
						noOfDaystr=noOfDaystr.trim();
						logger.info("noOfDaystr "+noOfDaystr);
						if(noOfDaystr.contains("-")) {
							String noOfDayArr[]=noOfDaystr.split("-");
							 first=Integer.parseInt(noOfDayArr[0].trim());
							 second=Integer.parseInt(noOfDayArr[1].trim());
							
							if(second >= noOfDays && first <= noOfDays ) {
								withdrawalFeesPercentage = withdrawalFees.getWithdrawalFeesPercentage();
							}
						}else if(noOfDaystr.contains(">=")) {
							String noOfDayArr[]=noOfDaystr.split(">=");
							 first=Integer.parseInt(noOfDayArr[0].trim());
							 second=Integer.parseInt(noOfDayArr[1].trim());
							
							if(second >= noOfDays && first < noOfDays ) {
								withdrawalFeesPercentage = withdrawalFees.getWithdrawalFeesPercentage();
							}
						}else if(noOfDaystr.contains("<=")) {
							String noOfDayArr[]=noOfDaystr.split("<=");
							 first=Integer.parseInt(noOfDayArr[0].trim());
							 second=Integer.parseInt(noOfDayArr[1].trim());
							
							if(second <= noOfDays && first > noOfDays ) {
								withdrawalFeesPercentage = withdrawalFees.getWithdrawalFeesPercentage();
							}
							
						}else if(noOfDaystr.contains("<")) {
							String noOfDayArr[]=noOfDaystr.split("<");
							// first=Integer.parseInt(noOfDayArr[0]);
							 second=Integer.parseInt(noOfDayArr[1].trim());
							
							if(second > noOfDays ) {
								withdrawalFeesPercentage = withdrawalFees.getWithdrawalFeesPercentage();
							}
							
						}else if(noOfDaystr.contains(">")) {
							String noOfDayArr[]=noOfDaystr.split(">");
							 //first=Integer.parseInt(noOfDayArr[0]);
							 second=Integer.parseInt(noOfDayArr[1].trim());
							
							if(second < noOfDays ) {
								withdrawalFeesPercentage = withdrawalFees.getWithdrawalFeesPercentage();
							}
						}
					}
					
					if (Validator.isNotNull(registrationItem)&& Validator.isNotNull(registrationItem.getItems())&&!registrationItem.getItems().isEmpty()) {
						withdrawalFee = (withdrawalFeesPercentage / 100.0)
								* registrationItem.getItems().get(0).getFeesPaid();
					}
				}
			 }	
			}
			logger.info("cancellationFeesPercentage >>>>>>>>>>>" + withdrawalFeesPercentage);
			logger.info("cancellationFees >>>>>>>>>>>" + withdrawalFee);
			responseJson.put(OMSBExamWebPortletKeys.WITHDRAWAL_FEES_PERCENTAGE, withdrawalFeesPercentage);
			responseJson.put(OMSBExamWebPortletKeys.WITHDRAWL_FEES, withdrawalFee);
			if(logger.isDebugEnabled()) {
				logger.debug("responseJson" + responseJson);
			}
			logger.info("responseJson >>>>>>>>>>>" + responseJson);
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
			return false;

		}
		return true;
	}

	@Reference
	ExamUtil examUtil;
	
	@Reference
	ScheduleUtil scheduleUtil;

	private static final Log logger = LogFactoryUtil.getLog(ExamWithdrawalMVCResourceCommand.class);

}
