package gov.omsb.oct.web.portlet.portlet.resource;

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
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=/confirm", }, service = MVCResourceCommand.class)

public class OCTRegistrationConfirmationMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		logger.info("Resource Command Started");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long oCExamScheduleId = ParamUtil.getLong(resourceRequest, "oCExamScheduleId");

		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(oCExamScheduleId,
				themeDisplay.getPortalURL());
		if (lrUserId <= 0) {
			lrUserId = themeDisplay.getUserId();
		}
		List<Person> person = octExamUtil.getPersonDetail(themeDisplay, lrUserId);
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		try {

			User user = UserLocalServiceUtil.getUser(lrUserId);
			responseJson.put("firstName", user.getFirstName());
			responseJson.put("familyName", user.getLastName());
			responseJson.put("emailAddress", user.getEmailAddress());
			responseJson.put("lrUserId", lrUserId);
			if (Validator.isNotNull(person) && !person.isEmpty()) {
				List<PersonalDetail> personalDetailItem = octExamUtil.getPersonalDetail(themeDisplay,
						person.get(0).getId());
				if (Validator.isNotNull(personalDetailItem) && !personalDetailItem.isEmpty()) {
					responseJson.put("mobileNumber", personalDetailItem.get(0).getMobileNumber());
				}
			}

			if (Validator.isNotNull(octExamSchedule)) {
				responseJson.put("examDate", octExamSchedule.getExamDate());
				responseJson.put("examTime", octExamSchedule.getExamSlot());
				// octRegistration.setExamEndTime(octExamSchedule.getExamEndTime());

				OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(
						octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
				responseJson.put("locationOnGoogleMap", octExamDefinition.getLocationOnGoogleMap());
				responseJson.put("venue", octExamDefinition.getVenue());
				long getoCExamTitleId = octExamDefinition.getoCExamTitleId();

				int examDuration = octExamDefinition.getExamDuration();
				logger.info("octExamDefinition" + octExamDefinition);
				responseJson.put("examDuration", examDuration);
				String Examtitle = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(getoCExamTitleId,
						themeDisplay.getLocale());
				responseJson.put("oCExamTitle", Examtitle);
				logger.info("Examtitle" + Examtitle);

				OCTRegistrationItem octRestrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
						lrUserId, oCExamScheduleId);
				if (!octRestrationItem.getItems().isEmpty()) {

					OCTRegistration octRegistration = octRestrationItem.getItems().get(0);
					responseJson.put("feesPaid", octRegistration.getFeesPaid());
				}
			}
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);

		} catch (Exception e) {
			logger.error("error occured while fetching user :" + e.getMessage(), e);
		}

		return true;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTRegistrationConfirmationMVCResourceCommand.class);

}
