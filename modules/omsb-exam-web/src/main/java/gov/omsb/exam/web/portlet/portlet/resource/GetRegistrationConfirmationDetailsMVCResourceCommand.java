package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamMultiDates;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.ExamScheduleItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.GET_CONFIRM_REGISTRATION_DETAILS, }, service = MVCResourceCommand.class)
public class GetRegistrationConfirmationDetailsMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.info("Resource Command Started");
		try {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		String portalURL = themeDisplay.getPortalURL();

		long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
		
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		logger.info("lrUserId "+ lrUserId);
		if (lrUserId <= 0) {
			lrUserId = themeDisplay.getUserId();
		}
		logger.info("lrUserId "+ lrUserId);
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		ExamScheduleItem examScheduleItem = examUtil.getExamScheduleByScheduleId(portalURL, groupId, examScheduleId);

		if (Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())
				&& !examScheduleItem.getItems().isEmpty()) {
			ExamSchedule examSchedule = examScheduleItem.getItems().get(0);
			if(examSchedule.isMultiDates()) {
				ExamMultiDatesItem examMultiDatesItem = scheduleUtil.getExamMultiByDesc(themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL(),
						examSchedule.getExamScheduleAdminId());
				if (Validator.isNotNull(examMultiDatesItem) && Validator.isNotNull(examMultiDatesItem.getItems())
						&& !examMultiDatesItem.getItems().isEmpty()) {
					ExamMultiDates examMultiDates = examMultiDatesItem.getItems().get(0);

					responseJson.put("examstartTime", examMultiDates.getStartTime());
					responseJson.put("examEndTime", examMultiDates.getEndTime());
					if(Validator.isNotNull(examMultiDates.getExamDate())) {
						responseJson.put("examDate",omsbCommonApi.convertDateFormatToDDMMYYYY(examMultiDates.getExamDate()));
					}
					responseJson.put("locationOnGoogleMap", examMultiDates.getLocationOnGoogleMap());
					responseJson.put("venue", examMultiDates.getVenue());

				}
			}else {
				if(Validator.isNotNull(examSchedule.getExamDate())) {
					responseJson.put("examDate",omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getExamDate()));
				}
				responseJson.put("examstartTime", examSchedule.getStartTime());
				responseJson.put("examEndTime", examSchedule.getEndTime());
				responseJson.put("locationOnGoogleMap", examSchedule.getLocationOnGoogleMap());
				responseJson.put("venue", examSchedule.getVenue());
			}
				
				 long examTypeId = examSchedule.getExamType(); 
				 logger.info("examTypeId"+  examTypeId);
				 String examType =  examUtil.getExamType(examTypeId, themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale());
				 logger.info("examType"+  examType);
				 
				 responseJson.put("feesPaid", examUtil.calculateExamFee(themeDisplay, examSchedule));
				 responseJson.put("examType", examType);

				 List<Person> person = examUtil.getPersonDetail(themeDisplay, lrUserId);
			

				// User Details
				User user = UserLocalServiceUtil.getUser(lrUserId);
				responseJson.put("lrUserId", lrUserId);
				responseJson.put("firstName", user.getFirstName());
				responseJson.put("familyName", user.getLastName());
				responseJson.put("emailAddress", user.getEmailAddress());

				if (Validator.isNotNull(person) && !person.isEmpty()) {
					List<PersonalDetail> personalDetailItem = examUtil.getPersonalDetail(themeDisplay,
							person.get(0).getId());
					if (Validator.isNotNull(personalDetailItem) && !personalDetailItem.isEmpty()) {
						responseJson.put("mobileNumber", personalDetailItem.get(0).getMobileNumber());
					}
				}
				PrintWriter out = resourceResponse.getWriter();
				out.println(responseJson);

			
		}
		} catch (Exception e) {
			logger.error("error occured while fetching user :" + e.getMessage(), e);
		}
		return true;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ExamUtil examUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	private static final Log logger = LogFactoryUtil.getLog(GetRegistrationConfirmationDetailsMVCResourceCommand.class);

}
