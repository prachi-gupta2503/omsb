package gov.omsb.exam.web.portlet.portlet.render;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EmergencyContact;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamScheduleItem;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.service.GenderMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=save/registration" }, service = MVCRenderCommand.class)
/**
 * 
 * @author TanusreeD
 *
 */
public class RegistrationMVCRenderCommand implements MVCRenderCommand {

	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		String role = ParamUtil.getString(renderRequest, "role");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programId = ParamUtil.getLong(renderRequest, "programId");
		long examScheduleId = ParamUtil.getLong(renderRequest, "examScheduleId");
		String jspPage = "";
		try {
			if (OMSBExamWebPortletKeys.TRAINEE_REGISTRATION_CMD.equalsIgnoreCase(cmd)) {
				long userId = themeDisplay.getUserId();
				String regCmd = ParamUtil.getString(renderRequest, "regCmd");
				if (regCmd.equalsIgnoreCase(OMSBExamWebPortletKeys.REG_CMD)) {
					userId = ParamUtil.getLong(renderRequest, "lrUserId");
				}
				List<Person> person = examUtil.getPersonDetail(themeDisplay, userId);

				Registration registration = new Registration();

				registration.setExamTypeName(
						examUtil.getExamType(ParamUtil.getLong(renderRequest, "examTypeId"), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));

				registration.setFeeType(OMSBExamWebPortletKeys.FEES_TYPE_EXAM_REGISTRATION);

				registration.setExamTypeId(ParamUtil.getLong(renderRequest, "examTypeId"));
				registration.setProgramId(programId);
				registration.setExamScheduleId(examScheduleId);
				registration.setProgramName(examUtil.getProgramByProgramId(programId, themeDisplay));
				registration = setPersonData(themeDisplay, person, registration);
				User user = UserLocalServiceUtil.getUser(userId);
				registration.setFirstName(user.getFirstName());
				registration.setFamilyName(user.getLastName());
				registration.setEmailAddress(user.getEmailAddress());
				registration.setLrUserId(userId);
				registration.setNoOfAttempt(examUtil.getNoOfAttempts(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), examScheduleId,userId));
				EmergencyContact emergancyContact = examUtil.getEmergancyContactDetailByLrUserId(themeDisplay, userId);
				if (Validator.isNotNull(emergancyContact)) {
					renderRequest.setAttribute("emergencyContact", emergancyContact);
				} else {
					renderRequest.setAttribute("emergencyContact", new EmergencyContact());
				}
				renderRequest.setAttribute("registration", registration);
				renderRequest.setAttribute("role", role);
				if (Validator.isNotNull(person) && !person.isEmpty() && Validator.isNotNull(person.get(0)) && person.get(0).getId() >0 ) {
					List<EducationDetail> educationDetail = examUtil.getEducationDetail(themeDisplay,
							person.get(0).getId());
					if (Validator.isNotNull(person) && (Validator.isNotNull(educationDetail))) {
						for (EducationDetail education : educationDetail) {
							List<DocumentInfo> educationCertificates = examUtil.getEducationCentificate(themeDisplay,
									education.getId());
							if (Validator.isNotNull(educationCertificates) && !educationCertificates.isEmpty()) {
								String educationCertificate = educationCertificates.get(0).getdFFileName();
								education.setEducationCertificate(educationCertificate);
								DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
										.getFileEntry(educationCertificates.get(0).getFileEntryID());
								education.setDocumentUrl(documentAndMediaFile(fileEntry, themeDisplay));
							}
						}
					}
					renderRequest.setAttribute("educationDetails", educationDetail);
				}
				
				jspPage = OMSBExamWebPortletKeys.REGISTRATION_FORM_JSP;
			} else if (OMSBExamWebPortletKeys.TRAINEE_WITHDRAWAL_CMD.equalsIgnoreCase(cmd)) {
				long examDefinitionId = getExamDefinitionIdByScheduleId(themeDisplay, examScheduleId);
				renderRequest.setAttribute("examDefinitionId", examDefinitionId);
				renderRequest.setAttribute("examScheduleId", examScheduleId);
				jspPage = OMSBExamWebPortletKeys.TRAINEE_WITHDRAWAL_JSP;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return jspPage;
	}

	private long getExamDefinitionIdByScheduleId(ThemeDisplay themeDisplay, long examScheduleId) {
		ExamScheduleItem items = scheduleUtil.getExamScheduleItem(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), examScheduleId);
		if (Validator.isNotNull(items) && Validator.isNotNull(items.getItems()) && !items.getItems().isEmpty()) {
			return items.getItems().get(0).getExamDefinitionId();
		}
		return 0;
	}

	private Registration setPersonData(ThemeDisplay themeDisplay, List<Person> person, Registration registration) {
		try {
			if (Validator.isNotNull(person) && !person.isEmpty()) {
				try {
					User user=UserLocalServiceUtil.getUser(person.get(0).getLrUserId());
					if(Validator.isNotNull(user)) {
						
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
						if (Validator.isNotNull(entry)) {
							String imageUrl = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay,
									"");
							logger.debug("imageUrl" + imageUrl);
							registration.setProfileUrl(imageUrl);
					}
					}
				} catch (Exception e) {
					logger.error("profile image not found");
				}

				registration.setCivilId(person.get(0).getCivilId());
				registration.setPassportNumber(person.get(0).getPassportNumber());
				long personId = person.get(0).getId();
				String dateOfBirth = person.get(0).getDateOfBirth();
				dateOfBirth = omsbCommonApi.convertDateFormatToDDMMYYYY(dateOfBirth);
				registration.setDateOfBirth(dateOfBirth);

				List<PersonalDetail> personalDetailItem = examUtil.getPersonalDetail(themeDisplay, personId);
				if (Validator.isNotNull(personalDetailItem) && !personalDetailItem.isEmpty()) {
					registration.setMobileNumber(personalDetailItem.get(0).getMobileNumber());
					if (personalDetailItem.get(0).getGenderId() > 0) {
						registration.setGenderId(personalDetailItem.get(0).getGenderId());
						registration.setGender(getGenderName(personalDetailItem));
					}

					String passportExpiryDate = personalDetailItem.get(0).getPassportExpiryDate();
					if (Validator.isNotNull(passportExpiryDate)) {
						passportExpiryDate = omsbCommonApi.convertDateFormatToDDMMYYYY(passportExpiryDate);
					}
					registration.setPassportExpiryDate(passportExpiryDate);
					long countryId = personalDetailItem.get(0).getCountryId();
//				List<Country> countryItem = examUtil.getCountryDetails(themeDisplay, countryId);
//				if (Validator.isNotNull(countryItem) && !countryItem.isEmpty()) {
//					String nationality = countryItem.get(0).getNationality();
//					registration.setNationality(nationality);
//				}
					if (countryId > 0) {
						logger.info("nationality name::"
								+ countryLocalService.getCountry(countryId).getName(themeDisplay.getLocale()));
						registration.setNationality(
								countryLocalService.getCountry(countryId).getName(themeDisplay.getLocale()));
					}

//				List<EducationDetail> educationDetail = examUtil.getEducationDetail(themeDisplay, personId);

//				if (Validator.isNotNull(educationDetail) && !educationDetail.isEmpty()) {
//					List<DocumentInfo> educationCertificates = examUtil.getEducationCentificate(themeDisplay, educationDetail.get(0).getId());
//				
//					String issuingAuthorityName = educationDetail.get(0).getIssuingAuthorityName();
//					registration.setIssuingAuthorityName(issuingAuthorityName);
//					//List<DocumentInfo> educationCertificates = octExamUtil.getEducationCentificate(themeDisplay, educationDetail.get(0).getId());
//					
//					if (Validator.isNotNull(educationCertificates) && !educationCertificates.isEmpty()) {
//						String educationCertificate = educationCertificates.get(0).getdFFileName();
//						
//						registration.setEducationCertificate(educationCertificate);
//						DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(educationCertificates.get(0).getFileEntryID());
//						registration.setDocumentUrl(documentAndMediaFile(fileEntry,themeDisplay));
//						
//					}
//				}
				}
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug(e.getMessage());

			}
		}
		return registration;
	}

	private String getGenderName(List<PersonalDetail> personalDetailItem) {
		GenderMaster genderMaster = null;
		try {
			genderMaster = GenderMasterLocalServiceUtil.getGenderMaster(personalDetailItem.get(0).getGenderId());
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(genderMaster)) {
			return genderMaster.getGenderName();
		}
		return "";
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
			if (logger.isDebugEnabled()) {
				logger.debug(e.getMessage());
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug(stringBundle.toString() + " Download URL====");
		}
		return stringBundle.toString();
	}

	private Log logger = LogFactoryUtil.getLog(RegistrationMVCRenderCommand.class);
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private ExamUtil examUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private CountryLocalService countryLocalService;

}
