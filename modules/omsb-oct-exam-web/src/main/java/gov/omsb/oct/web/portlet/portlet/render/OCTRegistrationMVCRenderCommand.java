package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Country;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EmergencyContact;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.service.GenderMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.REGISTRATION_FORM, }, service = MVCRenderCommand.class)
public class OCTRegistrationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("Registration Form ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long oCExamScheduleId = ParamUtil.getLong(renderRequest, "oCExamScheduleId");
			long oldOcExamScheduleId = ParamUtil.getLong(renderRequest, "oldOcExamScheduleId");
			float reschedulingFeesPercentage = ParamUtil.getFloat(renderRequest, "reschedulingFeesPercentage");
			
			long lrUserId = ParamUtil.getLong(renderRequest, "lrUserId");
			// String role = ParamUtil.getString(renderRequest, "role");
			if (lrUserId <= 0) {
				lrUserId = themeDisplay.getUserId();
			}
			List<Person> person = octExamUtil.getPersonDetail(themeDisplay, lrUserId);
			boolean hasUserRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), lrUserId, RoleNameConstants.EXAM_APPLICANT);
			OCTRegistration octRegistration = new OCTRegistration();
			octRegistration.setoCExamScheduleId(oCExamScheduleId);
			logger.info("exam sech id::" + oCExamScheduleId);

			octRegistration = setPersonData(themeDisplay, person, octRegistration);
			User user = UserLocalServiceUtil.getUser(lrUserId);
			octRegistration.setFirstName(user.getFirstName());
			octRegistration.setFamilyName(user.getLastName());
			octRegistration.setFamilyName(user.getMiddleName());
			octRegistration.setEmailAddress(user.getEmailAddress());
			octRegistration.setLrUserId(lrUserId);
			// octRegistration.setReschedulingFeesPercentage(reschedulingFeesPercentage);
			OCTExamSchedule octExamSchedule = octExamUtil.getOCTExamScheduleById(oCExamScheduleId,
					themeDisplay.getPortalURL());
			if (Validator.isNotNull(octExamSchedule)) {

				OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(
						octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
				if (Validator.isNotNull(octExamSchedule)) {

					long getoCExamTitleId = octExamDefinition.getoCExamTitleId();
					if (getoCExamTitleId > 0) {
						ListTypeEntry listTypeEntry = getListTypeEntryByEntryId(getoCExamTitleId);
						if (Validator.isNotNull(listTypeEntry)) {

							octRegistration.setoCExamTitle(omsbCommonApi.getValueByLanguage(listTypeEntry.getName(),
									OmsbOctExamWebPortletKeys.EXAM_TITLE_NAME, themeDisplay.getLocale().toString()));
						}
					}
				}
			}
			octRegistration.setFeeType(OmsbOctExamWebPortletKeys.FEES_TYPE_OCT_EXAM_REGISTRATION);
			OCTRegistrationItem registrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, oldOcExamScheduleId);
			if (Validator.isNotNull(registrationItem) && !registrationItem.getItems().isEmpty()) {

				OCTRegistration octRegistration2 = registrationItem.getItems().get(0);
				
				if (Validator.isNotNull(octRegistration2.getInternshipFromDate())) {

					octRegistration.setInternshipFromDate(
							omsbCommonApi.convertDateFormatToDDMMYYYY(octRegistration2.getInternshipFromDate()));
				}
				if (Validator.isNotNull(octRegistration2.getInternshipToDate())) {
					octRegistration.setInternshipToDate(
							omsbCommonApi.convertDateFormatToDDMMYYYY(octRegistration2.getInternshipToDate()));
				}

				octRegistration.setLangUsedOther(octRegistration2.isLangUsedOther());
				octRegistration.setInternshipStatus(octRegistration2.getInternshipStatus());
				octRegistration.setLangUsedCollege(octRegistration2.getLangUsedCollege());
				octRegistration.setFeeType(OmsbOctExamWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE);
				octRegistration.setId(octRegistration2.getId());
				// octRegistration.setInternshipStatus(octRegistration2.getInternshipStatus());
				octRegistration.setInternshipFileEntryId(octRegistration2.getInternshipFileEntryId());
				if (octRegistration2.getInternshipFileEntryId() > 0) {
					DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
							.getFileEntry(octRegistration2.getInternshipFileEntryId());
					if (Validator.isNotNull(fileEntry)) {
						octRegistration.setInternshipFileName(fileEntry.getFileName());
					}
				}

			}
			EmergencyContact emergancyContact = octExamUtil.getEmergancyContactDetailByLrUserId(themeDisplay, lrUserId);
			if(Validator.isNotNull(emergancyContact)) {
				renderRequest.setAttribute("emergencyContact", emergancyContact);
			}else {
				renderRequest.setAttribute("emergencyContact", new EmergencyContact());
			}
			renderRequest.setAttribute("registration", octRegistration);
			renderRequest.setAttribute("isApplicant", hasUserRole);
			

		} catch (Exception e) {
			logger.error("error occured while fetching user :" + e.getMessage(), e);
		}
	
		return OmsbOctExamWebPortletKeys.REGISTRATION_FORM_JSP;
	}

	private OCTRegistration setPersonData(ThemeDisplay themeDisplay, List<Person> person,
			OCTRegistration registration) {
		try {
			if (Validator.isNotNull(person) && !person.isEmpty()) {
				registration.setCivilId(person.get(0).getCivilId());
				registration.setPassportNumber(person.get(0).getPassportNumber());
				long personId = person.get(0).getId();
				String dateOfBirth = person.get(0).getDateOfBirth();
				dateOfBirth = omsbCommonApi.convertDateFormatToDDMMYYYY(dateOfBirth);
				registration.setDateOfBirth(dateOfBirth);

				List<PersonalDetail> personalDetailItem = octExamUtil.getPersonalDetail(themeDisplay, personId);
				if (Validator.isNotNull(personalDetailItem) && !personalDetailItem.isEmpty()) {
					registration.setMobileNumber(personalDetailItem.get(0).getMobileNumber());
					logger.info("GenderId" + personalDetailItem.get(0).getGenderId());
					if (personalDetailItem.get(0).getGenderId() > 0) {
						registration.setGenderId(personalDetailItem.get(0).getGenderId());

						registration.setGender(getGenderName(personalDetailItem));
					}
					logger.info("getPassportExpiryDate " + personalDetailItem.get(0).getPassportExpiryDate());
					String passportExpiryDate = personalDetailItem.get(0).getPassportExpiryDate();
					if (Validator.isNotNull(passportExpiryDate)) {
						passportExpiryDate = omsbCommonApi.convertDateFormatToDDMMYYYY(passportExpiryDate);
					}
					registration.setPassportExpiryDate(passportExpiryDate);
					long countryId = personalDetailItem.get(0).getCountryId();

					List<Country> countryItem = octExamUtil.getCountryDetails(themeDisplay, countryId);
					if (Validator.isNotNull(countryItem) && !countryItem.isEmpty()) {
						String nationality = countryItem.get(0).getNationality();
						registration.setNationality(nationality);

					}
					List<EducationDetail> educationDetail = octExamUtil.getEducationDetail(themeDisplay, personId);

					if (Validator.isNotNull(educationDetail) && !educationDetail.isEmpty()) {
						List<DocumentInfo> educationCertificates = octExamUtil.getEducationCentificate(themeDisplay,
								educationDetail.get(0).getId());
						logger.info("educationCertificates" + educationCertificates);
						String issuingAuthorityName = educationDetail.get(0).getIssuingAuthorityName();
						registration.setIssuingAuthorityName(issuingAuthorityName);
						// List<DocumentInfo> educationCertificates =
						// octExamUtil.getEducationCentificate(themeDisplay,
						// educationDetail.get(0).getId());
						logger.info("educationCertificates" + educationCertificates);
						if (Validator.isNotNull(educationCertificates) && !educationCertificates.isEmpty()) {
							String educationCertificate = educationCertificates.get(0).getdFFileName();
							logger.info("educationCertificates" + educationCertificate);
							registration.setEducationCertificate(educationCertificate);
							DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
									.getFileEntry(educationCertificates.get(0).getFileEntryID());
							registration.setDocumentUrl(documentAndMediaFile(fileEntry, themeDisplay));
							logger.info(" documentAndMediaFile :: " + documentAndMediaFile(fileEntry, themeDisplay));
							logger.info("educationCertificates" + educationCertificates.get(0).getDocumentURL());
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return registration;
	}

	private String getGenderName(List<PersonalDetail> personalDetailItem) {
		GenderMaster genderMaster = null;
		try {
			logger.info("genderMaster" + personalDetailItem.get(0).getGenderId());
			genderMaster = GenderMasterLocalServiceUtil.getGenderMaster(personalDetailItem.get(0).getGenderId());

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(genderMaster)) {
			return genderMaster.getGenderName();
		}
		return "";
	}

	private ListTypeEntry getListTypeEntryByEntryId(long ocExamTitleId) {
		try {

			return ListTypeEntryLocalServiceUtil.getListTypeEntry(ocExamTitleId);

		} catch (PortalException e) {
			logger.info("exception while getting the list type item", e);

		}
		return null;
	}

	private String documentAndMediaFile(DLFileEntry fileEntry, ThemeDisplay themeDisplay)
			throws PortalException, IOException {
		StringBundler stringBundle = new StringBundler();
		try {
			stringBundle.append(themeDisplay.getPortalURL());
			stringBundle.append("/documents/");
			stringBundle.append(fileEntry.getGroupId());
			stringBundle.append("/");
			stringBundle.append(fileEntry.getFolderId());
			stringBundle.append("/");
			stringBundle.append(URLCodec.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()), true));
			stringBundle.append("?version=");
			stringBundle.append(fileEntry.getFileVersion().getVersion());
			stringBundle.append("&amp;t=");
			Date modifiedDate = fileEntry.getFileVersion().getModifiedDate();
			stringBundle.append(modifiedDate.getTime());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		logger.info(stringBundle.toString() + " Download URL====");
		return stringBundle.toString();
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTRegistrationMVCRenderCommand.class);

}
