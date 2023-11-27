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

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamReschedulingFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_CONFIRM_RESCHEDULE, }, service = MVCResourceCommand.class)
public class OCTExamRescheduleConfirmationMVCResourceCommand implements MVCResourceCommand {
	private static final Log logger = LogFactoryUtil.getLog(OCTRegistrationConfirmationMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long octExamDefinitionId = ParamUtil.getLong(resourceRequest, "octExamDefinitionId");
			long octExamScheduleId = ParamUtil.getLong(resourceRequest, "octExamScheduleId");
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			if (lrUserId <= 0) {
				lrUserId = themeDisplay.getUserId();
			}
			logger.info(octExamDefinitionId);

			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(octExamScheduleId,
					themeDisplay.getPortalURL());
			OCTRegistrationItem registrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, octExamScheduleId);
				
			float reschedulingFeesPercentage = 0;
			double reschedulingFees = 0;
			
			 String StatusName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(octExamSchedule.getExamStatusId(), themeDisplay.getLocale());
			
			if ("Reschedule".equalsIgnoreCase(StatusName)) {
				reschedulingFees = 0;
				reschedulingFeesPercentage = 0;
			} else {
				OCTExamReschedulingFees octExamREscheduleFee = octExamUtil.getOCTExamRescheduleFee(octExamSchedule, themeDisplay);
				if(Validator.isNotNull(octExamREscheduleFee)) {
					reschedulingFeesPercentage=octExamREscheduleFee.getReschedulingFeesPercentage();
				}
				if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems()) && !registrationItem.getItems().isEmpty()) {

					reschedulingFees = (reschedulingFeesPercentage / 100.0)* registrationItem.getItems().get(0).getFeesPaid();
				}

			}
			responseJson.put("reschedulingFeesPercentage", reschedulingFeesPercentage);
			responseJson.put("reschedulingFees", reschedulingFees);
			responseJson.put("feeType",OmsbOctExamWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE);

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
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}
