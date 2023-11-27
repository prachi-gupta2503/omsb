package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.Country;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.tms.service.GenderMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_OCT_EXAM_REGISTRATION, }, service = MVCRenderCommand.class)
public class OCTViewExamRegistrationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long registrationId = ParamUtil.getLong(renderRequest, "registrationId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		boolean assignedToMe = ParamUtil.getBoolean(renderRequest, "assignedToMe");
		try {
			OCTRegistration registration = getExamRegistrationByRegistrationId(themeDisplay, registrationId);
			long lrUserId = registration.getLrUserId();
			List<Person> person = octExamUtil.getPersonDetail(themeDisplay, lrUserId);
			if (Validator.isNotNull(person) && !person.isEmpty()) {
				String dateOfBirth = person.get(0).getDateOfBirth();
				dateOfBirth = omsbCommonApi.convertDateFormatToDDMMYYYY(dateOfBirth);
				registration.setDateOfBirth(dateOfBirth);

				List<PersonalDetail> personalDetailItem = octExamUtil.getPersonalDetail(themeDisplay,
						person.get(0).getId());
				if (Validator.isNotNull(personalDetailItem) && !personalDetailItem.isEmpty()) {
					List<Country> countryItem = octExamUtil.getCountryDetails(themeDisplay,
							personalDetailItem.get(0).getCountryId());
					if (Validator.isNotNull(countryItem) && !countryItem.isEmpty()) {
						String nationality = countryItem.get(0).getNationality();
						registration.setNationality(nationality);
					}
					if (personalDetailItem.get(0).getGenderId() > 0) {
						registration.setGender(GenderMasterLocalServiceUtil
								.getGenderMaster(personalDetailItem.get(0).getGenderId()).getGenderName());
						registration.setMobileNumber(String.valueOf(personalDetailItem.get(0).getMobileNumber()));
					}
				}
			}

			User user = UserLocalServiceUtil.getUser(lrUserId);
			if (Validator.isNotNull(user)) {
				registration.setFirstName(user.getFirstName());
				registration.setFamilyName(user.getLastName());
				registration.setEmailAddress(user.getEmailAddress());
			}
			OCTExamSchedule octExamSchedule = getOctExamScheduleByRegistrationScheduleId(
					registration.getoCExamScheduleId(), themeDisplay.getPortalURL(), themeDisplay.getLocale());
			if (Validator.isNotNull(octExamSchedule)) {
				registration.setLocationOnGoogleMap(octExamSchedule.getLocationOnGoogleMap());
				registration.setVenue(octExamSchedule.getVenue());
				registration.setExamStartDate(octExamSchedule.getExamDate());
				registration.setExamTime(octExamSchedule.getExamSlot());
			}

			registration = octExamUtil.getExamRegistrationWorkflowData(themeDisplay, registration);
			List<String> trNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);

			renderRequest.setAttribute("assignedToMe", assignedToMe);
			renderRequest.setAttribute("instanceId", instanceId);
			renderRequest.setAttribute("workflowTaskId", workflowTaskId);
			renderRequest.setAttribute("registrationId", registrationId);
			renderRequest.setAttribute("trNames", trNames);
			renderRequest.setAttribute("registration", registration);

		} catch (PortalException e) {
			throw new RuntimeException(e);
		}
		return OmsbOctExamWebPortletKeys.OCT_EXAM_REGISTRATION_VIEW_JSP;
	}

	private OCTRegistration getExamRegistrationByRegistrationId(ThemeDisplay themeDisplay, long registrationId) {
		OCTRegistration registration = octExamUtil.getExamRegistrationByRegistrationId(themeDisplay, registrationId);
		String octExamTitleName = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(registration.getoCExamTitleId(),
				themeDisplay.getLocale());
		registration.setoCExamTitleName(octExamTitleName);
		return registration;
	}

	private OCTExamSchedule getOctExamScheduleByRegistrationScheduleId(long octExamScheduleId, String portalURL,
			Locale locale) {

		OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(octExamScheduleId, portalURL);
		octExamSchedule.setExamDate(omsbCommonApi.convertObjectDateToDDMMYYYYDate(octExamSchedule.getExamDate()));

		return octExamSchedule;
	}

	@Reference
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(OCTViewExamRegistrationMVCRenderCommand.class);
}
