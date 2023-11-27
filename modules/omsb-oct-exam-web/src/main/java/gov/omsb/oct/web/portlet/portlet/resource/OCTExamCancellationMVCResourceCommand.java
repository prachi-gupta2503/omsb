package gov.omsb.oct.web.portlet.portlet.resource;

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
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamCancellationFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_CONFIRM_CANCEL, }, service = MVCResourceCommand.class)
public class OCTExamCancellationMVCResourceCommand implements MVCResourceCommand {
	private static final Log logger = LogFactoryUtil.getLog(OCTRegistrationConfirmationMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String portalURL = themeDisplay.getPortalURL();

			long scopeGroupId = themeDisplay.getScopeGroupId();

			long octExamDefinitionId = ParamUtil.getLong(resourceRequest, "octExamDefinitionId");
			long octExamScheduleId = ParamUtil.getLong(resourceRequest, "octExamScheduleId");
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			if (lrUserId <= 0) {
				lrUserId = themeDisplay.getUserId();
			}
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(octExamScheduleId,
					themeDisplay.getPortalURL());
			OCTRegistrationItem registrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, octExamScheduleId);
			List<OCTExamCancellationFees> octExamCancellationFees = octExamUtil
					.getOCTExamCancellationFeesByDefinationId(octExamDefinitionId, themeDisplay.getPortalURL(),
							themeDisplay.getScopeGroupId());

			String examDateStr = octExamSchedule.getExamDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataflowConstants.OBJECT_DATE_FORMAT,
					Locale.ENGLISH);
			LocalDate examDate = LocalDate.parse(examDateStr, formatter);

			LocalDate todatDate = LocalDate.now();
			long noOfDays = ChronoUnit.DAYS.between(todatDate, examDate);

			float cancellationFeesPercentage = 0;
			double cancellationFees = 0;
			logger.info("noOfDays" + noOfDays);

			for (OCTExamCancellationFees octExamCancellationFee : octExamCancellationFees) {
				String noOfDaystr=octExamCancellationFee.getNoOfDays();
				int first=0;
				int second=0;
				noOfDaystr=noOfDaystr.trim();
				logger.info("noOfDaystr "+noOfDaystr);
				if(noOfDaystr.contains("-")) {
					String noOfDayArr[]=noOfDaystr.split("-");
					 first=Integer.parseInt(noOfDayArr[0].trim());
					 second=Integer.parseInt(noOfDayArr[1].trim());
					
					if(second >= noOfDays && first <= noOfDays ) {
						cancellationFeesPercentage = octExamCancellationFee.getCancellationFeesPercentage();
					}
				}else if(noOfDaystr.contains(">=")) {
					String noOfDayArr[]=noOfDaystr.split(">=");
					 first=Integer.parseInt(noOfDayArr[0].trim());
					 second=Integer.parseInt(noOfDayArr[1].trim());
					
					if(second >= noOfDays && first < noOfDays ) {
						cancellationFeesPercentage = octExamCancellationFee.getCancellationFeesPercentage();
					}
				}else if(noOfDaystr.contains("<=")) {
					String noOfDayArr[]=noOfDaystr.split("<=");
					 first=Integer.parseInt(noOfDayArr[0].trim());
					 second=Integer.parseInt(noOfDayArr[1].trim());
					
					if(second <= noOfDays && first > noOfDays ) {
						cancellationFeesPercentage = octExamCancellationFee.getCancellationFeesPercentage();
					}
					
				}else if(noOfDaystr.contains("<")) {
					String noOfDayArr[]=noOfDaystr.split("<");
					// first=Integer.parseInt(noOfDayArr[0]);
					 second=Integer.parseInt(noOfDayArr[1].trim());
					
					if(second > noOfDays ) {
						cancellationFeesPercentage = octExamCancellationFee.getCancellationFeesPercentage();
					}
					
				}else if(noOfDaystr.contains(">")) {
					String noOfDayArr[]=noOfDaystr.split(">");
					 //first=Integer.parseInt(noOfDayArr[0]);
					 second=Integer.parseInt(noOfDayArr[1].trim());
					
					if(second < noOfDays ) {
						cancellationFeesPercentage = octExamCancellationFee.getCancellationFeesPercentage();
					}
				}
			}
			if (!registrationItem.getItems().isEmpty()) {
				cancellationFees = (cancellationFeesPercentage / 100.0)
						* registrationItem.getItems().get(0).getFeesPaid();
			}

			responseJson.put("cancellationFeesPercentage", cancellationFeesPercentage);
			responseJson.put("cancellationFees", cancellationFees);

//			responseJson.put("cancellationFeesPercentage", 25);
//
//			responseJson.put("cancellationFees", 2);

			OCTExamPayment octExamPayment = octExamUtil.getRegistrationPaymentByScheduleIdAndUserId(octExamScheduleId,
					lrUserId, portalURL, scopeGroupId);

			if (Validator.isNotNull(octExamPayment)) {

				responseJson.put("trackingId", octExamPayment.getTrackingId());

			}

			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);

			logger.info("responseJson" + responseJson);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	@Reference
	OCTExamUtil octExamUtil;

}
