package gov.omsb.registration.web.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.CaseRequestItem;
import gov.omsb.common.dto.Country;
import gov.omsb.common.dto.CountryItem;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.DocumentInfoItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.FunctionSectionCommitteeItems;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.dto.RoleMapping;
import gov.omsb.registration.web.dto.RoleMappingItems;
import gov.omsb.registration.web.dto.SectionDepartmentItems;
import gov.omsb.registration.web.dto.ServicesItem;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.dto.UserVerification;
import gov.omsb.registration.web.dto.UserVerificationItems;
import gov.omsb.registration.web.dto.WorkSector;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.GenderMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(immediate = true, service = RegistrationUtil.class)
public class RegistrationUtil {

	public JSONObject sendEmailOTP(String portalURL, long groupId, long companyId, long personId, String emailAddress,long currentUserId) {
		LOGGER.info("personId :::"+personId);
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
		boolean isValid = Boolean.FALSE;
		if (Validator.isNotNull(emailAddress)) {
			User user = userService.fetchUserByEmailAddress(companyId, emailAddress);
			LOGGER.info("user :::"+user);
			if (Validator.isNotNull(user) && user.getUserId() > 0 && user.getUserId()!=currentUserId) {
			} else {
				String otp = String.format("%06d", new Random().nextInt(999999));
				commonApi.sendEmailNotification(CommonConstants.SENDER_EMAIL, emailAddress, "Verification Mail", "Your OMSB registration email OTP : " + otp);
				UserVerificationItems userVerificationItems=null;
				try {
					userVerificationItems = getUserVerificationItems(portalURL, groupId, personId,
							null, null);
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				}
				//if (Validator.isNotNull(userVerificationItems) && userVerificationItems.getItems().size() > 0) {
				if (Validator.isNotNull(userVerificationItems) &&  Validator.isNotNull(userVerificationItems.getItems()) && userVerificationItems.getItems().size()>0) {
					UserVerification userVerification = userVerificationItems.getItems().get(0);
					userVerification.setEmailAddress(emailAddress);
					userVerification.setEmailAddressOTP(otp);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePut(
							portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + userVerification.getId(),
							userVerificationMapper, headers);
				} else {
					UserVerification userVerification = new UserVerification();
					userVerification.setEmailAddress(emailAddress);
					userVerification.setEmailAddressOTP(otp);
					userVerification.setPersonId(personId);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePost(portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId, userVerificationMapper, headers);
					LOGGER.info("Verification Created :::::");
				}
				isValid = Boolean.TRUE;
			}
		}
		responseJSON.put("isValid", isValid);
		return responseJSON;
	}

	public JSONObject verifyOTP(String portalURL, long groupId, long companyId, long personId, String fieldName,
			String otp) {

		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(fieldName) && Validator.isNotNull(otp)) {
			UserVerificationItems userVerificationItems = getUserVerificationItems(portalURL, groupId, personId,
					fieldName, otp);
			if (Validator.isNotNull(userVerificationItems) && userVerificationItems.getItems().size() > 0) {
				responseJSON.put("isValid", Boolean.TRUE);
			} else {
				responseJSON.put("isValid", Boolean.FALSE);
			}
		}
		return responseJSON;
	}

	public JSONObject sendMobileOTP(String portalURL, long groupId, long companyId, long personId,
			String mobileNumber) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();
		boolean isValid = Boolean.FALSE;
		if (Validator.isNotNull(mobileNumber)) {
			PersonalDetailItem personalDetailItem = getPersonalDetailsItems(portalURL, groupId, 0, mobileNumber); 
			if(Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0  && personalDetailItem.getItems().get(0).isMobileNumberVerified() ) {
			} else {
				String otp = String.format("%06d", new Random().nextInt(999999));
				UserVerificationItems userVerificationItems = getUserVerificationItems(portalURL, groupId, personId,
						null, null);
				if (Validator.isNotNull(userVerificationItems) && userVerificationItems.getItems().size() > 0) {
					UserVerification userVerification = userVerificationItems.getItems().get(0);
					userVerification.setMobileNumber(mobileNumber);
					userVerification.setMobileNumberOTP(otp);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePut(
							portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + userVerification.getId(),
							userVerificationMapper, headers);
				} else {
					UserVerification userVerification = new UserVerification();
					userVerification.setMobileNumber(mobileNumber);
					userVerification.setMobileNumberOTP(otp);
					userVerification.setPersonId(personId);
					String userVerificationMapper = CustomObjectMapperUtil.writeValueAsString(userVerification, null);
					httpConnector.executePost(portalURL + LRObjectURL.REG_USER_VERIFICATION_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId, userVerificationMapper, headers);
				}
				commonApi.sendMobileNotification(mobileNumber, "Your OMSB registration mobile OTP :" + otp);
				isValid = Boolean.TRUE;
			}
		}
		responseJSON.put("isValid", isValid);
		return responseJSON;
	}

	public Person setPersonData(String portalURL, long groupId, String civilId, String passportNumber, String dob) {

		Person person = null;
		PersonItem personItems = getPersonItems(portalURL, groupId, civilId, passportNumber,
				(Validator.isNotNull(dob) ? commonApi.convertNewDDMMYYYYStringToYYYYDDMMString(dob) : null));
		if (Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems())
				&& personItems.getItems().size() > 0) {
			person = personItems.getItems().get(0);
		} else {
			person = new Person();
			person.setCivilId(civilId);
			person.setDateOfBirth((Validator.isNotNull(dob) ? commonApi.convertNewDDMMYYYYDateToObjectDate(dob) : null));
			person.setPassportNumber(passportNumber);
			person = savePersonData(portalURL, groupId, person);
		}
		return person;
	}

	public Person savePersonData(String portalURL, long groupId, Person person) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String personMapper = CustomObjectMapperUtil.writeValueAsString(person, null);
		LOGGER.debug("personMapper ::::" +personMapper);
		String response=null;
		if (person.getId() == 0) {
			try {
				response = httpConnector.executePost(
						portalURL + LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId,
						personMapper, headers);
			} catch (Exception e) {
				LOGGER.error("Error :::" +e.getMessage());
			}
			LOGGER.debug("Person POST URL ::::" +portalURL + LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		} else {
			try {
				response = httpConnector.executePut(portalURL + LRObjectURL.REG_PERSON_URL + person.getId(), personMapper,
						headers);
			} catch (Exception e) {
				LOGGER.error("Error :::" +e.getMessage());
			}
			LOGGER.debug("Person PUT URL ::::" +portalURL + LRObjectURL.REG_PERSON_URL + person.getId());
		}
		LOGGER.debug("Person Response::::" +response);
		if(Validator.isNotNull(response)) {	
			return CustomObjectMapperUtil.readValue(response, Person.class);
		} else {
			return null;
		}
	}

	public PersonalDetail savePersonalDetailData(String portalURL, long groupId, PersonalDetail personalDetail) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();

		//	LOGGER.info("inside the personal details "+ personalDetail.getProfessionOther());
		String personalDetailMapper = CustomObjectMapperUtil.writeValueAsString(personalDetail, null);

		//LOGGER.info("personalDetailMapper"+personalDetailMapper);

		String response;
		if (personalDetail.getId() == 0) {
			response = httpConnector.executePost(portalURL + LRObjectURL.REG_PERSONAL_DETAILS_URL +CommonConstants.SCOPES + StringPool.SLASH +groupId, personalDetailMapper, headers);
		} else {
			response = httpConnector.executePut(
					portalURL + LRObjectURL.REG_PERSONAL_DETAILS_URL + personalDetail.getId(), personalDetailMapper, headers);
		}
		return CustomObjectMapperUtil.readValue(response, PersonalDetail.class);
	}

	public List<ListTypeEntry> getPickListEntries(String pickListName, long companyId) {
		try {
			return ListTypeEntryLocalServiceUtil.getListTypeEntries(ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId).getListTypeDefinitionId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public UserVerificationItems getUserVerificationItems(String portalURL, long groupId, long personId,
			String fieldName, String fieldValue) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_VERIFICATION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + groupId);
		try{
			if (Validator.isNotNull(personId) && Validator.isNotNull(fieldName) && Validator.isNotNull(fieldValue)) {
				sbURL.append(StringPool.QUESTION + "filter=personId" + URLEncoder.encode(
						" eq " + personId + " and " + fieldName + " eq '" + fieldValue + "'", DataflowConstants.UTF_8));

			} else if (Validator.isNotNull(personId)) {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		return getItems(sbURL.toString(), UserVerificationItems.class);
	}

	public PersonalDetailItem getPersonalDetailsItems(String portalURL, long groupId, long personId, String mobileNumber) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSONAL_DETAILS_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (Validator.isNotNull(mobileNumber)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=mobileNumber" + URLEncoder.encode(" eq " + "'"+mobileNumber+"'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		} else if(personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("getPersonalDetailsItems :"+sbURL.toString());
		return getItems(sbURL.toString(), PersonalDetailItem.class);
	}

	public CountryItem getCustomCountryItems(String portalURL, long groupId) {
		return getItems(portalURL + LRObjectURL.REG_CUSTOM_COUNTRY_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId, CountryItem.class);
	}

	public Country getCustomCountryById(String portalURL, long customCountryId) {
		return getItems(portalURL + LRObjectURL.REG_CUSTOM_COUNTRY_URL + customCountryId, Country.class);
	}

	public Person getPersonById(String portalURL, long groupId, long personId) {
		return getItems(portalURL + LRObjectURL.REG_PERSON_URL + personId, Person.class);
	}

	public PersonItem getPersonItems(String portalURL, long groupId, String civilId, String passportNumber,
			String dob) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		try {
			if (Validator.isNotNull(civilId) && Validator.isNotNull(dob)) {
				sbURL.append(StringPool.QUESTION + "filter=civilId" + URLEncoder
						.encode(" eq " + "'" + civilId + "' and dateOfBirth eq " + dob, DataflowConstants.UTF_8));
			} else if (Validator.isNotNull(passportNumber) && Validator.isNotNull(dob)) {
				sbURL.append(StringPool.QUESTION + "filter=passportNumber" + URLEncoder.
						encode(" eq " + "'" + passportNumber + "' and dateOfBirth eq " + dob, DataflowConstants.UTF_8));
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("sbURL.toString() ::::" +sbURL.toString());
		return getItems(sbURL.toString(), PersonItem.class);
	}

	public <T> T getItems(String url, Class<T> clazz) {
		String response = commonApi.getData(url);
		if (Validator.isNotNull(response)) {
			return CustomObjectMapperUtil.readValue(response, clazz);
		}
		return null;
	}

	public Registration saveRegistration(ActionRequest actionRequest, Registration registration) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			LocalDate localDate = commonApi.convertObjectStringDateToDate(registration.getDateOfBirth()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LOGGER.debug("DateOfBirth Year : "+localDate.getYear()+" Month : "+localDate.getMonthValue()+" Day : "+localDate.getDayOfMonth());

			Role adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
			User user = null;
			if(Validator.isNotNull(registration.getCivilId()) && Validator.isNull(registration.getFirstName()) && Validator.isNull(registration.getLastName()) && Validator.isNotNull(registration.getFullName())) {
				String[] fullName = registration.getFullName().split("\\s",2);  
				if(fullName.length==2) {
					registration.setFirstName(fullName[0]);
					registration.setLastName(fullName[1]);
				} else if(fullName.length<2) {
					registration.setFirstName(fullName[0]);
					registration.setLastName(fullName[0]);
				}
			}
			if (Validator.isNull(registration.getLrUserId())) {
				try {
					user = _userService.addUserWithWorkflow(themeDisplay.getCompanyId(), Boolean.FALSE,
							registration.getPassword(), registration.getPassword(), Boolean.FALSE,
							registration.getUserName(), registration.getEmailAddress(), themeDisplay.getLocale(),
							registration.getFirstName(), StringPool.BLANK, registration.getLastName(), 0, 0,
							((registration.getGenderId() == 1) ? Boolean.TRUE : Boolean.FALSE), localDate.getMonthValue(),
							localDate.getDayOfMonth(), localDate.getYear(), StringPool.BLANK, null, null, null, null,
							Boolean.FALSE, serviceContext);
					user.setStatus(WorkflowConstants.STATUS_INACTIVE);
					user.setPasswordReset(false);
				} catch(Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			} else {
				user = _userService.getUserById(registration.getLrUserId());
				user.setScreenName(registration.getUserName());
				user.setFirstName(registration.getFirstName());
				user.setLastName(registration.getLastName());
				if(!user.getEmailAddress().equalsIgnoreCase(registration.getEmailAddress())) {
					user.setEmailAddress(registration.getEmailAddress());
				}
			}
			user.setEmailAddressVerified(registration.isEmailAddressVerified());
			if (registration.getPhotoId() != 0) {
				if(user.getPortraitId()!=0) {
					DLAppServiceUtil.deleteFileEntry(user.getPortraitId());
				}
				user.setPortraitId(registration.getPhotoId());
			}
			user = UserLocalServiceUtil.updateUser(user);
			registration.setLrUserId(user.getUserId());
			Person person = getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getPersonId());
			person.setLrUserId(user.getUserId());
			if(Validator.isNull(person.getPassportNumber())) {
				person.setPassportNumber(registration.getPassportNo());
			}
			if(Validator.isNull(person.getCivilId())) {
				person.setCivilId(registration.getCivilId());
			}
			savePersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person);

			addUpdatePersonalDetails(themeDisplay, registration);

		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return registration;
	}

	public void addUpdatePersonalDetails(ThemeDisplay themeDisplay, Registration registration) {
		LOGGER.info(registration.getProfessionOther());
		PersonalDetailItem personalDetailItem = getPersonalDetailsItems(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), registration.getPersonId(), null);
		PersonalDetail personalDetail = null;
		if (personalDetailItem.getItems().size() > 0) {
			personalDetail = personalDetailItem.getItems().get(0);
			LOGGER.info("regescv :  "+registration.getCvDocumentId());
			// personalDetail.setGivenNameAsPassport(registration.get);

			if (registration.getCivilCardFrontPhotoId() != 0) {
				if(personalDetail.getCivilCardFrontPhotoId() != 0) {
					try {
						DLAppServiceUtil.deleteFileEntry(personalDetail.getCivilCardFrontPhotoId());
					} catch (PortalException e) {
						LOGGER.error("Error while deleing CivilCardFrontPhoto : "+personalDetail.getCivilCardFrontPhotoId()+" "+e.getMessage());
					}
				}
				personalDetail.setCivilCardFrontPhotoId(registration.getCivilCardFrontPhotoId());
			}

			if (registration.getCivilCardBackPhotoId() != 0) {
				if(personalDetail.getCivilCardBackPhotoId() != 0) {
					try {
						DLAppServiceUtil.deleteFileEntry(personalDetail.getCivilCardBackPhotoId());
					} catch (PortalException e) {
						LOGGER.error("Error while deleing CivilCardBackPhoto : "+personalDetail.getCivilCardBackPhotoId()+" "+e.getMessage());
					}
				}
				personalDetail.setCivilCardBackPhotoId(registration.getCivilCardBackPhotoId());
			}

			if (registration.getCvDocumentId() != 0) {
				if(personalDetail.getCvDocumentId() != 0) {
					try {
						DLAppServiceUtil.deleteFileEntry(personalDetail.getCvDocumentId());
					} catch (PortalException e) {
						LOGGER.error("Error while deleing CvDocument : "+personalDetail.getCvDocumentId()+" "+e.getMessage());
					}
				}
				personalDetail.setCvDocumentId(registration.getCvDocumentId());
			}

			if (registration.getPassportPhotoId() != 0) {
				if(personalDetail.getPassportPhotoId() != 0) {
					try {
						DLAppServiceUtil.deleteFileEntry(personalDetail.getPassportPhotoId());
					} catch (PortalException e) {
						LOGGER.error("Error while deleing PassportPhoto : "+personalDetail.getPassportPhotoId()+" "+e.getMessage());
					}
				}
				personalDetail.setPassportPhotoId(registration.getPassportPhotoId());
			}

			if(Validator.isNotNull(registration.getCivilId())) {
				personalDetail.setGivenNameAsPassport(registration.getFullName());
			} else {
				personalDetail.setGivenNameAsPassport(registration.getFirstName()+ "" +registration.getLastName());
			}
			personalDetail.setApplicantSurname(registration.getLastName());
			personalDetail.setFullNameAr(registration.getFullNameAr());
			personalDetail.setEmail(registration.getEmailAddress());
			personalDetail.setCountryId(registration.getNationalityId());
			personalDetail.setMobileNumber(registration.getMobileNumber());
			personalDetail.setMobileNumberVerified(registration.isMobileNumberVerified());
			personalDetail.setPassportIssuingCountryId(registration.getCountryIdOfIssue());
			personalDetail.setPassportExpiryDate(registration.getPassportExpiryDate());
			personalDetail.setNationalityCountryId(registration.getNationalityId());
			// personalDetail.setComponentId(registration.get);
			// personalDetail.setCaseRequestId(registration.get);
			personalDetail.setProfession(registration.getProfession());
			personalDetail.setPrimarySpeciality(registration.getPrimarySpeciality());
			personalDetail.setSecondarySpeciality(registration.getSecondarySpeciality());
			personalDetail.setLrUserId(registration.getLrUserId());
			personalDetail.setPersonId(registration.getPersonId());
			personalDetail.setGenderId(registration.getGenderId());
			personalDetail.setProfessionOther(registration.getProfessionOther());
			personalDetail.setPrimarySpecialityOther(registration.getPrimarySpecialityOther());
			personalDetail.setSecondarySpecialityOther(registration.getSecondarySpecialityOther());
			personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.PERSONAL_DETAILS);

			personalDetail.setCountryCode(registration.getCountryCode());
			personalDetail.setCountryIsoCode(registration.getCountryIsoCode());
			// personalDetail.setRegistrationSource(registration.get);
			// personalDetail.setRegistrationStatus(registration.get);
			// personalDetail.setPkiVerified(registration.get);
			// personalDetail.setOmsbAssociated(registration.get);
		} else {
			personalDetail = new PersonalDetail();

			if(Validator.isNotNull(registration.getCivilId())) {
				personalDetail.setGivenNameAsPassport(registration.getFullName());
			} else {
				personalDetail.setGivenNameAsPassport(registration.getFirstName()+ "" +registration.getLastName());
			}
			personalDetail.setCivilCardFrontPhotoId(registration.getCivilCardFrontPhotoId());
			personalDetail.setCivilCardBackPhotoId(registration.getCivilCardBackPhotoId());
			personalDetail.setCvDocumentId(registration.getCvDocumentId());
			personalDetail.setPassportPhotoId(registration.getPassportPhotoId());
			personalDetail.setApplicantSurname(registration.getLastName());
			personalDetail.setFullNameAr(registration.getFullNameAr());
			personalDetail.setDateOfBirth(registration.getDateOfBirth());
			personalDetail.setEmail(registration.getEmailAddress());
			personalDetail.setCountryId(registration.getNationalityId());
			personalDetail.setMobileNumber(registration.getMobileNumber());
			personalDetail.setMobileNumberVerified(registration.isMobileNumberVerified());
			personalDetail.setPassportIssuingCountryId(registration.getCountryIdOfIssue());
			personalDetail.setPassportExpiryDate(registration.getPassportExpiryDate());
			personalDetail.setNationalityCountryId(registration.getNationalityId());
			// personalDetail.setComponentId(registration.get);
			// personalDetail.setCaseRequestId(registration.get);
			personalDetail.setProfession(registration.getProfession());
			personalDetail.setPrimarySpeciality(registration.getPrimarySpeciality());
			personalDetail.setSecondarySpeciality(registration.getSecondarySpeciality());
			personalDetail.setLrUserId(registration.getLrUserId());
			personalDetail.setPersonId(registration.getPersonId());
			personalDetail.setGenderId(registration.getGenderId());
			personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.PERSONAL_DETAILS);
			personalDetail.setProfessionOther(registration.getProfessionOther());
			personalDetail.setPrimarySpecialityOther(registration.getPrimarySpecialityOther());
			personalDetail.setSecondarySpecialityOther(registration.getSecondarySpecialityOther());
			personalDetail.setCountryCode(registration.getCountryCode());
			personalDetail.setCountryIsoCode(registration.getCountryIsoCode());
			//	personalDetail.setProfessionOther(registration.getProfessionOther());
			//	personalDetail.setPrimarySpecialityOther(registration.getPrimarySpecialityOther());
			//	personalDetail.setSecondarySpecialityOther(registration.getSecondarySpecialityOther());
			//	personalDetail.setCountryCode(registration.getCountryCode());
			//	personalDetail.setCountryIsoCode(registration.getCountryIsoCode());
			//  personalDetail.setRegistrationSource(registration.get);
			//  personalDetail.setPkiVerified(registration.get);
			//  personalDetail.setOmsbAssociated(registration.get);
		}
		savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);		
	}

	public Registration getRegistrationDTO(ActionRequest actionRequest, ThemeDisplay themeDisplay) {

		Registration registration = new Registration();
		long personId=ParamUtil.getLong(actionRequest, "personId");
		if(Validator.isNull(personId)) {
			Person newPerson = addPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getCivilId(), registration.getPassportNo(), ParamUtil.getString(actionRequest, "dateOfBirth").trim());
			personId=newPerson.getId();
		}
		registration.setPersonId(personId);
		registration.setCivilId(ParamUtil.getString(actionRequest, "civilId").trim());
		registration.setDateOfBirth(commonApi.convertNewDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "dateOfBirth").trim()));
		registration.setPassportNo(ParamUtil.getString(actionRequest, "passportNumber").trim());
		registration.setCountryIdOfIssue(ParamUtil.getLong(actionRequest, "countryOfIssue"));

		registration.setPassportExpiryDate(Validator.isNotNull(ParamUtil.getString(actionRequest, "passportExpiryDate"))?commonApi.convertNewDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "passportExpiryDate").trim()):null);
		registration.setFirstName(ParamUtil.getString(actionRequest, "firstName").trim());
		registration.setLastName(ParamUtil.getString(actionRequest, "lastName").trim());
		registration.setFullName(ParamUtil.getString(actionRequest, "fullName").trim());
		registration.setFullNameAr(ParamUtil.getString(actionRequest, "fullNameAr").trim());
		String givenNameAsPassport=StringPool.BLANK;
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "firstName").trim())) {
			givenNameAsPassport=ParamUtil.getString(actionRequest, "firstName").trim();
		} else {
			givenNameAsPassport=ParamUtil.getString(actionRequest, "fullName").trim();
		}
		registration.setGivenNameAsPassport(givenNameAsPassport);
		registration.setEmailAddress(ParamUtil.getString(actionRequest, "emailAddress").trim());
		registration.setMobileNumber(ParamUtil.getString(actionRequest, "mobileNumber").trim());
		registration.setGenderId(ParamUtil.getLong(actionRequest, "gender"));
		registration.setNationalityId(ParamUtil.getLong(actionRequest, "nationality"));
		//	registration.setProfession(ParamUtil.getString(actionRequest, "profession").trim());
		registration.setProfessionOther(ParamUtil.getString(actionRequest, "professionOther").trim());
		registration.setPrimarySpecialityOther(ParamUtil.getString(actionRequest, "PrimarySpecialityOther").trim());
		registration.setSecondarySpecialityOther(ParamUtil.getString(actionRequest, "secondarySpecialityOther").trim());

		try {
			ListTypeEntry profession = commonApi.getListTypeEntryBylistTypeEntryId(ParamUtil.getLong(actionRequest, "profession"));
			registration.setProfession(profession.getKey());		
			ListTypeEntry primaryEntry = commonApi.getListTypeEntryBylistTypeEntryId(ParamUtil.getLong(actionRequest, "primarySpeciality"));
			registration.setPrimarySpeciality(primaryEntry.getKey());		
			ListTypeEntry secondaryEntry = commonApi.getListTypeEntryBylistTypeEntryId(ParamUtil.getLong(actionRequest, "secondarySpeciality"));
			registration.setSecondarySpeciality(secondaryEntry.getKey());
		} catch(Exception e) {
			LOGGER.info("unable to get the ListTypeEntry : "+e.getMessage());
		}
		registration.setPrimarySpeciality(ParamUtil.getString(actionRequest, "primarySpeciality").trim());
		registration.setSecondarySpeciality(ParamUtil.getString(actionRequest, "secondarySpeciality").trim());
		registration.setUserName(ParamUtil.getString(actionRequest, "userName").trim());
		//		registration.setPassword(ParamUtil.getString(actionRequest, "password").trim());
		//		registration.setReTypePassword(ParamUtil.getString(actionRequest, "reTypePassword").trim());
		registration.setEmailAddressVerified(ParamUtil.getBoolean(actionRequest, "emailAddressOTPVerified"));
		registration.setMobileNumberVerified(ParamUtil.getBoolean(actionRequest, "mobileNumberOTPVerified"));

		registration.setCountryCode(ParamUtil.getString(actionRequest, "countryCode").trim());
		registration.setCountryIsoCode(ParamUtil.getString(actionRequest, "countryIsoCode").trim());

		registration.setLrUserId(ParamUtil.getLong(actionRequest, "userId"));

		if(themeDisplay.isSignedIn()) {
			registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.REGISTRATION_SOURCE_ADMIN);
		} else {
			registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.REGISTRATION_SOURCE_USER);
		}
		boolean isMyProfile=ParamUtil.getBoolean(actionRequest, "isMyProfile");
		if(!isMyProfile) {
			FileEntry photoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.PHOTO_FOLDERNAME, "photo");
			if (Validator.isNotNull(photoFileEntry)) {
				registration.setPhotoId(photoFileEntry.getFileEntryId());
			}
		}
		FileEntry civilCardFrontPhotoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CIVIL_CARD_PHOTO_FOLDERNAME, "civilCardFrontPhoto");
		if (Validator.isNotNull(civilCardFrontPhotoFileEntry)) {
			registration.setCivilCardFrontPhotoId(civilCardFrontPhotoFileEntry.getFileEntryId());
		}

		FileEntry civilCardBackPhotoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CIVIL_CARD_PHOTO_FOLDERNAME, "civilCardBackPhoto");
		if (Validator.isNotNull(civilCardBackPhotoFileEntry)) {
			registration.setCivilCardBackPhotoId(civilCardBackPhotoFileEntry.getFileEntryId());
		}

		FileEntry passportPhotoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.PASSPORT_PHOTO_FOLDERNAME, "passportPhoto");
		if (Validator.isNotNull(passportPhotoFileEntry)) {
			registration.setPassportPhotoId(passportPhotoFileEntry.getFileEntryId());
		}
		FileEntry cvDocumentFileEntry=fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.PHOTO_FOLDERNAME, "cvDocument");
		LOGGER.debug("fileEntryyy id : "+cvDocumentFileEntry);
		if (Validator.isNotNull(cvDocumentFileEntry)) {
			registration.setCvDocumentId(cvDocumentFileEntry.getFileEntryId());
		}
		//}
	boolean isProfileApprover=false;
	boolean isRoleApprover=false;
	//	boolean isServiceApprover=false;
	try {
		isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
	} catch (PortalException e1) {
		LOGGER.error("Exception ::" +e1.getMessage());
	}

	try {
		isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
	} catch (PortalException e2) {
		LOGGER.error("Exception ::" +e2.getMessage());
	}
	//		try {
	//			 isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
	//		} catch (PortalException e1) {
	//			LOGGER.error("Exception ::" +e1.getMessage());
	//		}

	boolean isAdmin =getAdmin(themeDisplay.getCompanyId()).getUserId()==themeDisplay.getUserId()?true :false;
	if(themeDisplay.isSignedIn() && (isAdmin ||isRoleApprover || isProfileApprover)) {
		String generatedPassword=generateRandomPassword(8);
		LOGGER.info("generatedPassword : : : :"+generatedPassword);
		registration.setPassword(generatedPassword);
		registration.setReTypePassword(generatedPassword);
	} else {
		registration.setPassword(ParamUtil.getString(actionRequest, "password").trim());
		registration.setReTypePassword(ParamUtil.getString(actionRequest, "reTypePassword").trim());
	}
	return registration;
	}

	public FileEntry fileUpload(ActionRequest actionRequest, ThemeDisplay themeDisplay, String foldeName, String fileName) {

		try {
			Role adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(PortalUtil.getDefaultCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			LOGGER.info("inside ---fileName :"+fileName);
			File file = uploadPortletRequest.getFile(fileName);
			LOGGER.info("inside 1 file---"+file);
			if(Validator.isNotNull(file)) {
				Folder folder = null;
				try {
					folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, foldeName);
				} catch (Exception e) {
					folder = DLAppServiceUtil.addFolder(null, themeDisplay.getScopeGroupId(),
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, foldeName,
							foldeName, serviceContext);
				}
				return DLAppServiceUtil.addFileEntry(null, themeDisplay.getScopeGroupId(), folder.getFolderId(),
						StringUtil.randomString()+uploadPortletRequest.getFileName(fileName) ,
						uploadPortletRequest.getContentType(fileName),
						StringUtil.randomString() + fileName ,
						StringUtil.randomString() +uploadPortletRequest.getFileName(fileName),
						uploadPortletRequest.getFileName(fileName), "", new FileInputStream(file), file.length(), null, null,
						serviceContext);
			}
		} catch (PortalException | FileNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public List<GenderMaster> getGenderMasterList(ThemeDisplay themeDisplay) {
		LOGGER.info("getGenderMaster() started");
		List<GenderMaster> genderMasterList = GenderMasterLocalServiceUtil.getGenderMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		for (GenderMaster genderMaster : genderMasterList) {
			genderMaster.setGenderName(commonApi.getValueByLanguage(genderMaster.getGenderName(),
					OmsbRegistrationWebPortletKeys.GENDER_NAME, themeDisplay.getLocale().toString()));
		}
		LOGGER.info("getGenderMaster() ended");
		return genderMasterList;
	}

	public GenderMaster getGenderMaster(ThemeDisplay themeDisplay, long genderId) {
		LOGGER.info("getGenderMaster() started");
		try {
			GenderMaster genderMaster = GenderMasterLocalServiceUtil.getGenderMaster(genderId);
			genderMaster.setGenderName(commonApi.getValueByLanguage(genderMaster.getGenderName(),
					OmsbRegistrationWebPortletKeys.GENDER_NAME, themeDisplay.getLocale().toString()));
			return genderMaster;
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("getGenderMaster() ended");
		return null;
	}

	public Registration setRegistrationDetailsList(long personId, String personName, String personStatus,
			String personStatusColor, String personCivilId, String personPassportNumber, String personCreatedDate) {
		Registration registrationDetail = new Registration();
		registrationDetail.setPersonId(personId);
		registrationDetail.setPersonName(personName);
		registrationDetail.setRegistrationStatus(personStatus);
		registrationDetail.setRegistrationStatusColor(personStatusColor);
		registrationDetail.setCivilId(personCivilId);
		registrationDetail.setPassportNo(personPassportNumber);
		registrationDetail.setDateCreated(commonApi.convertObjectDateToNewDDMMYYYYDate(personCreatedDate));
		return registrationDetail;
	}

	public String convertDateOfBirth(String date) throws ParseException {
		DateFormat oldDF = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat newDF = new SimpleDateFormat("yyyy-MM-dd");
		Date oldDate = oldDF.parse(date);
		return newDF.format(oldDate);
	}

	public String convertCreatedDate(String date) throws ParseException {
		DateFormat oldDF = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat newDF = new SimpleDateFormat("dd-MM-yyyy");
		Date oldDate = oldDF.parse(date);
		return newDF.format(oldDate);
	}

	public String getRegistrationStatusColor(String color) {
		Map<String, String> registerationMAP = new HashMap<>();
		registerationMAP.put(OmsbRegistrationWebPortletKeys.NOT_STARTED, "omsb-notstarted-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.PERSONAL_DETAILS, "omsb-reappeal-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.EDUCATION_DETAILS, "omsb-reappeal-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.WORK_DETAILS, "omsb-reappeal-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.ROLE_TYPE_1, "omsb-reappeal-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2, "omsb-reappeal-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.SERVICE_TYPE, "omsb-reappeal-bg");
		registerationMAP.put(OmsbRegistrationWebPortletKeys.COMPLETED, "omsb-completed-bg");
		return registerationMAP.get(color);
	}

	public void getRegistrationListFromPesonalItems(Person person, ThemeDisplay themeDisplay) {

		PersonalDetailItem personalDetailItem = getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
		if (Validator.isNotNull(personalDetailItem)  && personalDetailItem.getItems().size()>0) {
			setRegistrationDetailsList(person.getId(), 
					personalDetailItem.getItems().get(0).getGivenNameAsPassport(), 
					personalDetailItem.getItems().get(0).getRegistrationStatus(), 
					getRegistrationStatusColor(personalDetailItem.getItems().get(0).getRegistrationStatus()),
					person.getCivilId(), person.getPassportNumber(), person.getDateCreated());
		}
	}

	public EducationDetailItem getEducationDetailItems(String portalURL, long scopeGroupId, long personId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_EDUCATION_DETAIL_URL 
				+ CommonConstants.SCOPES + StringPool.SLASH + scopeGroupId);
		if (personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return getItems(sbURL.toString(), EducationDetailItem.class);
	}

	public EmploymentDetailItem getEmploymentDetailItems(String portalURL, long scopeGroupId, long personId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + scopeGroupId);
		if (personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return getItems(sbURL.toString(), EmploymentDetailItem.class);
	}

	public PersonItem fetchPersonByPassportAndDob(ThemeDisplay themeDisplay, String passport, String dob)
			throws UnsupportedEncodingException {
		String personUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + "filter=passportNumber"
				+ URLEncoder.encode(" eq '" + passport + "' and dateOfBirth eq " + dob, DataflowConstants.UTF_8);
		String personResponse = commonApi.getData(personUrl);
		LOGGER.debug("fetchPersonByPassport:::::::::::>>>>>>>>>" + personUrl + ":::::::personResponse::::::::::"
				+ personResponse);
		return CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
	}

	public CaseRequestItem fetchCaseRequestByCRN(ThemeDisplay themeDisplay, String crn, String dob)
			throws UnsupportedEncodingException {
		String caseRequestUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_CASE_REQUEST_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + "filter=crn"
				+ URLEncoder.encode(" eq " + "'" + crn + "'", DataflowConstants.UTF_8);
		String caseRequestResponse = commonApi.getData(caseRequestUrl);
		LOGGER.debug("fetchPersonByDFRN:::::::::::>>>>>>>>>" + caseRequestUrl + ":::::::personDetailResponse::::::::::"
				+ caseRequestResponse);
		return CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequestItem.class);
	}

	public Person fetchPersonByPersonId(ThemeDisplay themeDisplay, long personId) throws UnsupportedEncodingException {
		String personUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_PERSON_URL + personId;
		String personResponse = commonApi.getData(personUrl);
		LOGGER.debug("personUrl:::" + personUrl + " , , personResponse::::::::" + personResponse);
		return CustomObjectMapperUtil.readValue(personResponse, Person.class);
	}

	public PersonalDetailItem fetchPersonalDetailsByPersonId(long personId, ThemeDisplay themeDisplay) {
		String personDetailsUrl = null;
		try {
			personDetailsUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.REG_PERSONAL_DETAILS_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
					+ StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage(), e);
		}
		String personDetailsResponse = commonApi.getData(personDetailsUrl);
		LOGGER.debug(personDetailsUrl + " ::fetchPersonalDetailsByPersonId :::personDetailsResponse:::::"
				+ personDetailsResponse);
		return CustomObjectMapperUtil.readValue(personDetailsResponse, PersonalDetailItem.class);
	}

	public EducationDetailItem fetchEducationDetailByPersonId(ThemeDisplay themeDisplay, long personId) throws UnsupportedEncodingException  {
		String educationDetailUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_EDUCATION_DETAIL_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8);
		String educationDetailResponse = commonApi.getData(educationDetailUrl);
		LOGGER.info("fetchPersonalDetailsByPersonId Request URL:"+educationDetailUrl);
		if(Validator.isNotNull(educationDetailResponse)) {
			EducationDetailItem educationalDetailItem=CustomObjectMapperUtil.readValue(educationDetailResponse, EducationDetailItem.class);
			if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
				LOGGER.debug("fetchPersonalDetailsByPersonId Response Size:::" + educationalDetailItem.getItems().size());
				fetchDocumentInfobyPersonId(themeDisplay, educationalDetailItem, personId);
			}
			return educationalDetailItem;
		}
		return null;
	}

	public void fetchDocumentInfobyPersonId(ThemeDisplay themeDisplay, EducationDetailItem educationDetailItem, long personId) throws UnsupportedEncodingException {

		if(Validator.isNotNull(educationDetailItem) && educationDetailItem.getItems().size()>0) {
			for(EducationDetail educationalDetail : educationDetailItem.getItems()) {
				long componentClassRefId =educationalDetail.getId();
				LOGGER.info("componentClassRefId :::"+componentClassRefId);
				String documentInfoUrl = themeDisplay.getPortalURL()
						+ LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
						+ StringPool.QUESTION + "filter=componentClassRefId"
						+ URLEncoder.encode(" eq " + componentClassRefId, DataflowConstants.UTF_8);
				String documentInfoUrlResponse = commonApi.getData(documentInfoUrl);
				DocumentInfoItem documentInfoItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfoItem.class);
				LOGGER.debug("documentInfos.getItems().size() ::::"+documentInfoItems.getItems().size());
				if(Validator.isNotNull(documentInfoItems) && documentInfoItems.getItems().size()>0) {
					DocumentInfo documentInfo = documentInfoItems.getItems().get(0);
					if(Validator.isNotNull(documentInfo.getFileEntryID()) && documentInfo.getFileEntryID()>0) {
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(documentInfo.getFileEntryID());
							String documentURL =DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK);
							documentInfo.setDocumentURL(documentURL);
						} catch (PortalException e) {
							LOGGER.error("Error in  code :::" + e.getMessage());
						}
					}
					LOGGER.debug("File NAme :::"+documentInfo.getdFFileName()  + " :::" +documentInfo.getFileEntryID());
					educationalDetail.setDocumentInfo(documentInfo);
				}
			}
		}
	}

	public EducationDetail setEducationDetailsData(ActionRequest actionRequest,ThemeDisplay themeDisplay, long groupId, String title, String institute,
			long countryId, String gpa, Integer yearOfGraduation,String index) {
		LOGGER.info("Entry into setEducationalDetailsData :::");
		EducationDetail educationDetail = null;
		try {
			long personId=ParamUtil.getLong(actionRequest, "personId");
			long userId=ParamUtil.getLong(actionRequest, "userId");
			//long personId=themeDisplay.getUserId(); //Temp
			//long userId=themeDisplay.getUserId();  //Temp

			educationDetail = new EducationDetail();
			educationDetail.setQualificationAttained(title);
			educationDetail.setIssuingAuthorityName(institute);
			educationDetail.setIssuingAuthorityCountryId((int) countryId);
			educationDetail.setYearOfGraduation(yearOfGraduation);
			educationDetail.setGpa(gpa);
			educationDetail.setPersonId(personId);
			educationDetail.setlRUserId(userId);
			educationDetail = saveEducationDetail(actionRequest,themeDisplay, groupId, educationDetail,index);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("Exit setEducationalDetailsData :::::");
		return educationDetail;
	}

	public void saveEducation(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String counter = ParamUtil.getString(actionRequest, "counter");
		List<String> rowIndexesArray = com.liferay.petra.string.StringUtil.split(counter, ',');
		long personId = ParamUtil.getLong(actionRequest, "personId");


		LOGGER.debug("personId ::::saveEducation :::"+personId);


		/** ===== Delete Existing Record === **/
		if (Validator.isNotNull(personId)) {

			LOGGER.info("inside if saveEducation");
			try {
				EducationDetailItem educationDetailItem = fetchEducationDetailByPersonId(themeDisplay, personId);
				if (Validator.isNotNull(educationDetailItem) && educationDetailItem.getItems().size() > 0) {
					List<EducationDetail> educationDetailList = educationDetailItem.getItems();

					LOGGER.debug("educationalDetailItemList ::::" + educationDetailList.size());
					LOGGER.debug("educationalDetailItemList DocumentInfoItem ::::"
							+ educationDetailList.get(0).getDocumentInfo());
					for (EducationDetail educationDetail : educationDetailList) {
						DocumentInfo documentInfo = educationDetail.getDocumentInfo();

						LOGGER.info("educationalDetailItem  ::::" + educationDetail.getId());
						//LOGGER.info("DocumentInfoItem ::::" + documentInfo.getId());

						try {
							if (educationDetail.getId() > 0) {
								LOGGER.info("Inside delete  :::::");
								deleteEducationalDetail(themeDisplay, educationDetail.getId());
								deleteDocumentInfo(themeDisplay, documentInfo);
								LOGGER.info("Deleted :::::");
							}
						} catch (Exception e) {
							LOGGER.error(e.getMessage());
						}
					}
				}
			} catch (Exception e) {
				LOGGER.error("Error in code ::" + e.getMessage());
			}
		}
		/** ===== Add New Record === **/
		for (String str : rowIndexesArray) {
			LOGGER.info("str ::::::" + str);
			LOGGER.info("inside else saveEducation");
			String qualification = ParamUtil.getString(actionRequest, "qualification_" + str);
			String institution = ParamUtil.getString(actionRequest, "institution_" + str);
			long countryId = ParamUtil.getLong(actionRequest, "country_" + str);
			String gpa = ParamUtil.getString(actionRequest, "gpa_" + str);
			Integer yearOfGraduation = ParamUtil.getInteger(actionRequest, "year_" + str);

			long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId_" + str);

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String mimeType = uploadPortletRequest.getContentType("qualificationdoc_"+str);
			LOGGER.debug("fileEntryId ::::::::::::::::" + fileEntryId);
			LOGGER.debug("Qualification ::::::::::::::::" + qualification);
			LOGGER.debug("institution ::::::::::::::::" + institution);
			LOGGER.debug("countryId ::::::::::::::::" + countryId);
			LOGGER.debug("gpa ::::::::::::::::" + gpa);
			LOGGER.debug("yearOfGraduation ::::::::::::::::" + yearOfGraduation);
			LOGGER.debug("file NAme mimeType ::::::::::::::::" + mimeType);

			EducationDetail educationDetail = setEducationDetailsData(actionRequest, themeDisplay,
					themeDisplay.getScopeGroupId(), qualification, institution, countryId, gpa, yearOfGraduation, str);
			LOGGER.debug("educationDetail ::::" + educationDetail.getGpa());
		}

		//Update User status
		if(Validator.isNotNull(personId) && personId>0) {
			PersonalDetailItem personDetailItem=fetchPersonalDetailsByPersonId(personId, themeDisplay);
			if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
				try {
					PersonalDetail personalDetail=personDetailItem.getItems().get(0);
					personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.EDUCATION_DETAILS);
					savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				}
			}	
		}

	}

	public EducationDetail saveEducationDetail(ActionRequest actionRequest,ThemeDisplay themeDisplay, long groupId, EducationDetail educationDetail,String index) {
		LOGGER.info("inside saveEducationDetail :::::");
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String educationDetailMapper = CustomObjectMapperUtil.writeValueAsString(educationDetail, null);
		String response = httpConnector.executePost(themeDisplay.getPortalURL() + LRObjectURL.REG_EDUCATION_DETAIL_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId, educationDetailMapper, headers);
		educationDetail=CustomObjectMapperUtil.readValue(response, EducationDetail.class);
		LOGGER.debug("EDUCATIONAL DETAILS  ADDED SUCCESSFULLY::::::::::::::::::::::::::::::::::::::::::" +educationDetail.getId() + ":: "+educationDetail.getQualificationAttained());
		if(Validator.isNotNull(educationDetail)) {
			uploadDocument(actionRequest, themeDisplay,educationDetail.getPersonId(), DataflowConstants.EDUCATION_COMPONENT_KEY, educationDetail.getId(), 0,index,educationDetail.getlRUserId());
		}
		return educationDetail;
	}

	public void deleteEducationalDetail(ThemeDisplay themeDisplay,long educationDetailId) {
		try {
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			LOGGER.info("inside delete educational detail :::");
			String url=themeDisplay.getPortalURL() + LRObjectURL.REG_EDUCATION_DETAIL_URL +educationDetailId;
			LOGGER.info("Document educationDetailID url ::::::"+url);
			httpConnector.executeDelete(url,headers);
			LOGGER.info("Document educationDetailID Deleted ::::::"+educationDetailId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}	


	public void deleteUserMetaData(ThemeDisplay themeDisplay,long userMetadataId) {
		try {
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			LOGGER.info("inside delete user metadata detail :::");
			String url=themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL +userMetadataId;
			LOGGER.debug("Document user metadata url ::::::"+url);
			httpConnector.executeDelete(url,headers);
			LOGGER.debug("Document user metadata Deleted ::::::"+userMetadataId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}




	public void deleteDocumentInfo(ThemeDisplay themeDisplay, DocumentInfo documentInfo) {
		long fileEntryId = documentInfo.getFileEntryID();
		if (Validator.isNotNull(fileEntryId)) {
			try {
				//DLAppServiceUtil.deleteFileEntry(fileEntryId);
				Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
				String url = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + documentInfo.getId();
				LOGGER.info("Document documentInfoId url ::::::" + url);
				httpConnector.executeDelete(url, headers);
				LOGGER.debug("Document documentInfoId Deleted ::::::" + documentInfo.getId());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	private void uploadDocument(ActionRequest actionRequest, ThemeDisplay themeDisplay, long personId,
			String componentKey, long pk, long caseRequestId,String index,long lRUserId) {
		LOGGER.info("inside uploadDocument ");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		LOGGER.info("files:::::" + files + "::::" + files.size());
		long groupId = 0;
		Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			groupId = group.getGroupId();
		}
		Role adminRole= null;
		try {
			adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(themeDisplay.getCompanyId()).getUserId();
			if(adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);

			DLFolder folder = createDFFolderStructure(groupId, personId, componentKey);
			FileEntry entry = null;


			long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId_" + index);
			String contentType = uploadPortletRequest.getContentType("qualificationdoc_"+index);


			LOGGER.info("fileEntryId :::::" +fileEntryId);

			if (Validator.isNotNull(folder)) {
				String fileName=uploadPortletRequest.getFileName("qualificationdoc_"+index);		 			
				File file = uploadPortletRequest.getFile("qualificationdoc_"+index);
				String mimeType = uploadPortletRequest.getContentType("qualificationdoc_"+index);
				if(Validator.isNotNull(mimeType)) {
					String title = fileName;
					String description = fileName;
					long repositoryId = themeDisplay.getScopeGroupId();
					try {
						InputStream is = new FileInputStream( file );
						byte[] fileBytes = is.readAllBytes();
						entry = FileUploadUtil.createFileEntry(groupId, folder.getFolderId(), fileName,
								mimeType, "", fileBytes);
						LOGGER.debug("file entry added successfully::" +entry);
					} catch (FileNotFoundException e1) {
						LOGGER.error(e1.getMessage());
					} catch (IOException e) {
						LOGGER.error(e.getMessage());
					}
				}else {
					LOGGER.info("file entry inside else");
					entry =DLAppServiceUtil.getFileEntry(fileEntryId);
					LOGGER.info("file entry already axist::" +entry);
				}
				if (Validator.isNotNull(entry)) {
					LOGGER.info("Iside entry not null");
					saveDocumentInfo(themeDisplay, entry.getFileEntryId(), 0, pk, personId, caseRequestId, 0, 0,StringPool.BLANK, entry.getFileName(),lRUserId);
					LOGGER.info("Document info added successfully ::");
				}
			}

		} catch (PortalException e3) {
			LOGGER.info("Error ::" +e3.getMessage());
		}
	}


	public static User getAdmin(long companyId) {
		LOGGER.debug("comapnyId >>>>>>>>>>." + companyId);
		try {
			Role role = getRoleById(companyId, RoleConstants.ADMINISTRATOR);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("role >>>>>>>>>>" + role.getName());
			}
			for (User admin : UserLocalServiceUtil.getRoleUsers(role.getRoleId())) {
				return admin;
			}
		} catch (final Exception e) {
			LOGGER.error("Utils::getAdmin Exception", e);
		}
		return null;
	}


	public static Role getRoleById(long companyId, String roleStrId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, roleStrId);
		} catch (final Exception e) {
			LOGGER.error("Utils::getRoleById Exception", e);
		}
		return null;
	}


	private void saveDocumentInfo(ThemeDisplay themeDisplay, long fileEntryId, long documentTypeId, long pk,
			long personId, long caseRequestId, long componentId,long dFDocumentId,String dFFileKey, String fileName,long lRUserId) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("fileEntryID", fileEntryId);
		jsonObject.put("documentType", documentTypeId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		jsonObject.put("componentClassRefId", pk);
		jsonObject.put("componentId", componentId);
		jsonObject.put("dFDocumentId", dFDocumentId);
		jsonObject.put("dFFileKey", dFFileKey);
		jsonObject.put("dFFileName", fileName);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put("lRUserId",lRUserId);
		LOGGER.debug("Json Object ::::::"+jsonObject);
		String url =themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		String response=httpConnector.executePost(url,jsonObject.toString(), headers);
		LOGGER.info("Response ::::"+response + "URL ::::" +url);

	}

	public DLFolder createDFFolderStructure(long groupId, long personId, String componentName) {
		LOGGER.info("createDFFolderStructure method invoking ::::::" );
		DLFolder personFolder = null;
		DLFolder ePortalFolder = null;
		DLFolder componentFolder = null;
		long userId = 0;
		User user = userService.fetchUserByEmailAddress(PortalUtil.getDefaultCompanyId(), DataflowConstants.DATAFLOW_EMAIL_ADDRESS);
		if (Validator.isNotNull(user)) {
			LOGGER.info("user Id is ??" + user.getUserId());
			userId = user.getUserId();
		}
		DLFolder parentFolder = FileUploadUtil.getDLFolder(groupId, 0, CommonConstants.PARENT_FOLDER_NAME);
		if (Validator.isNull(parentFolder)) {
			parentFolder = FileUploadUtil.createDLFolder(groupId, CommonConstants.PARENT_FOLDER_NAME, 0, userId, "");
		} 
		if (Validator.isNotNull(parentFolder)) {
			ePortalFolder = FileUploadUtil.getDLFolder(groupId, parentFolder.getFolderId(), CommonConstants.LEVEL_1_FOLDER_NAME);
			LOGGER.debug("ePortalFolder ?? " + ePortalFolder );
			if (Validator.isNull(ePortalFolder)) {
				ePortalFolder = FileUploadUtil.createDLFolder(groupId, CommonConstants.LEVEL_1_FOLDER_NAME , parentFolder.getFolderId(), userId, "");
			}
		}

		if (Validator.isNotNull(ePortalFolder)) {
			personFolder = FileUploadUtil.getDLFolder(groupId, ePortalFolder.getFolderId(), String.valueOf(personId));
			if (Validator.isNull(personFolder)) {
				personFolder = FileUploadUtil.createDLFolder(groupId, String.valueOf(personId) , ePortalFolder.getFolderId(), userId, "");
			}
		}
		if (Validator.isNotNull(personFolder)) {
			componentFolder = FileUploadUtil.getDLFolder(groupId, personFolder.getFolderId(), componentName);
			if (Validator.isNull(componentFolder)) {
				componentFolder = FileUploadUtil.createDLFolder(groupId, componentName , personFolder.getFolderId(), userId, "");
			}
		}
		LOGGER.debug("createDFFolderStructure method invoking ::::::" +componentFolder);
		return componentFolder;
	}

	public RoleMappingItems fetchRoleMapping(ThemeDisplay themeDisplay, String roleType) {
		LOGGER.info("INSIDE ::::::::::::::::fetchRoleMapping ");
		StringBuilder sbURL = new StringBuilder(themeDisplay.getPortalURL()
				+ LRObjectURL.REG_ROLE_MAPPING_URL+"scopes/"+themeDisplay.getScopeGroupId());
		if(Validator.isNotNull(roleType)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=roleType" + URLEncoder.encode(" eq '" + roleType+"'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("fetchRoleMappingURL :: "+sbURL.toString());
		String roleMappingItemsResponse =commonApi.getData(sbURL.toString());
		return CustomObjectMapperUtil.readValue(roleMappingItemsResponse, RoleMappingItems.class);
	}

	public List<Role> getOMSBRoles(RoleMappingItems roleMappingItems) {
		JSONArray omsbRoleJsonArray = JSONFactoryUtil.createJSONArray();
		List<Role> omsbRoleList=new ArrayList<>();
		if (Validator.isNotNull(roleMappingItems)) {
			List<RoleMapping> roleMappingList = roleMappingItems.getItems();
			if (Validator.isNotNull(roleMappingList) && roleMappingList.size() > 0) {
				for (RoleMapping roleMapping : roleMappingList) {
					try {
						Role omsbRole = roleLocalService.getRole(roleMapping.getRoleId());
						if (Validator.isNotNull(omsbRole)) {
							JSONObject omsbJsonObject = JSONFactoryUtil.createJSONObject();
							omsbJsonObject.put("name", omsbRole.getName());
							omsbJsonObject.put("roleId", omsbRole.getRoleId());
							omsbRoleJsonArray.put(omsbJsonObject);
							omsbRoleList.add(omsbRole);
						}
					} catch (PortalException e) {
						LOGGER.error(e.getMessage());
					}
				}
			}
		}
		LOGGER.debug("omsbRoleJsonArray getOMSBRoles::"+omsbRoleJsonArray);
		return omsbRoleList.stream().sorted((o1, o2)->o1.getName().
				compareTo(o2.getName())).collect(Collectors.toList());
	}

	public List<ProgramTypeMaster> getProgramType(ThemeDisplay themeDisplay) {
		LOGGER.info("getProgramType() started");
		List<ProgramTypeMaster> programTypeMasters = new ArrayList<>();
		try {
			programTypeMasters = ProgramTypeMasterLocalServiceUtil.getProgramTypeMasters(-1, -1);
			for(ProgramTypeMaster programTypeMaster: programTypeMasters) {
				programTypeMaster.setProgramTypeName(CommonUtil.getValueByLanguage(programTypeMaster.getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME, themeDisplay.getLocale().toString()));
			}
		} catch (Exception e) {
			LOGGER.error("error while fetching program type:" + e.getMessage(), e);
		}
		LOGGER.info("getProgramType() ended");
		return programTypeMasters;
	}

	public List<ProgramMaster> getProgram(ThemeDisplay themeDisplay) {
		LOGGER.info("getProgramType() started");
		List<ProgramMaster> programMasters = new ArrayList();
		try {
			programMasters = ProgramMasterLocalServiceUtil.getProgramMasters(-1, -1);
			for (ProgramMaster program : programMasters) {
				program.setProgramName(CommonUtil.getValueByLanguage(program.getProgramName(), "ProgramName",
						themeDisplay.getLocale().toString()));
			}
		} catch (Exception e) {
			LOGGER.error("error while fetching program type:" + e.getMessage(), e);
		}
		LOGGER.info("getProgramType() ended");
		return programMasters;
	}


	public SectionDepartmentItems getSectionByDepartmentKey(ThemeDisplay themeDisplay, String departmentId)
			throws UnsupportedEncodingException {
		String sectionDepartmentUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_SECTION_DEPARTMENT_URL +"scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=departmentId"
				+ URLEncoder.encode(" eq " + "'" + departmentId + "'", DataflowConstants.UTF_8);
		String sectionDepartmentResponse = commonApi.getData(sectionDepartmentUrl);
		LOGGER.info("getSectionByDepartmentKey::" + sectionDepartmentUrl
				+ ":::::::sectionDepartmentResponse::::::::::" + sectionDepartmentResponse);
		return CustomObjectMapperUtil.readValue(sectionDepartmentResponse, SectionDepartmentItems.class);
	}

	public FunctionSectionCommitteeItems getFunctionAndCommiteeBySectionKey(ThemeDisplay themeDisplay, String sectionId)
			throws UnsupportedEncodingException {
		String functionCommiteeSectiontUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_FUNCTION_SECTION_COMMITTEE_URL + "scopes/" + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=sectionId" + URLEncoder.encode(" eq " + "'" + sectionId + "'", DataflowConstants.UTF_8);
		LOGGER.info("functionCommiteeSectiontUrl ::" + functionCommiteeSectiontUrl);
		String functionCommiteeSectiontResponse = commonApi.getData(functionCommiteeSectiontUrl);
		LOGGER.debug("getSectionByDepartmentKey::" + functionCommiteeSectiontUrl
				+ ":::::::sectionDepartmentResponse::" + functionCommiteeSectiontResponse);
		return CustomObjectMapperUtil.readValue(functionCommiteeSectiontResponse, FunctionSectionCommitteeItems.class);
	}

	public ListTypeEntry getPickListEntriesByMappingId(String pickListName, long companyId, String key) {
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId);
			return ListTypeEntryLocalServiceUtil
					.getListTypeEntry(definition.getListTypeDefinitionId(), key);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public UserMetadata saveUserMetadata(ThemeDisplay themeDisplay, String roleId, String departmentId,
			String sectionId, String commiteeId, String functionId, long programId, String programPositionId,
			String programPositionOther, String purposeId, String purposeOther, boolean roleVerifiedStatisId,
			boolean profileVerifiedStatisId, String omsbServiceId, boolean registringForRole, boolean omsbAssociated,
			long lRUserId, boolean isRequestedByAdmin, String roleOther, String departmentOther, String sectionOther,
			String functionOther, String programOther, String commiteeOther, String omsbServiceOther) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("roleId", roleId);
		jsonObject.put("departmentId", departmentId);
		jsonObject.put("sectionId", sectionId);
		jsonObject.put("committeeId", commiteeId);
		jsonObject.put("functionId", functionId);
		jsonObject.put("programId", programId);
		jsonObject.put("programPositionId", programPositionId);
		jsonObject.put("programPositionOther", programPositionOther);
		jsonObject.put("purposeId", purposeId);
		jsonObject.put("purposeOther", purposeOther);
		jsonObject.put("roleVerifiedStatisId", roleVerifiedStatisId);
		jsonObject.put("profileVerifiedStatisId", profileVerifiedStatisId);
		jsonObject.put("service", omsbServiceId);
		jsonObject.put("lrUserId",lRUserId);
		jsonObject.put("roleOther",roleOther);
		jsonObject.put("departmentOther",departmentOther);
		jsonObject.put("sectionOther",sectionOther);
		jsonObject.put("functionOther",functionOther);
		jsonObject.put("programOther",programOther);
		jsonObject.put("commiteeOther",commiteeOther);
		jsonObject.put("omsbServiceOther",omsbServiceOther);
		//jsonObject.put("omsbAssociated",omsbAssociated);
		jsonObject.put("associated",omsbAssociated);
		jsonObject.put("roleRequestedByAdmin",isRequestedByAdmin);
		jsonObject.put("registeringForRole",registringForRole);
		LOGGER.debug("Json Object :::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.:"+jsonObject);
		String response=StringPool.BLANK;
		String url =themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + "scopes" +StringPool.FORWARD_SLASH + themeDisplay.getScopeGroupId();
		response=httpConnector.executePost(url,
				jsonObject.toString(), headers);
		LOGGER.debug("Response ::::"+response + " url :: " +url);

		return CustomObjectMapperUtil.readValue(response, UserMetadata.class);
	}

	public UserMetatdataItems getUserMetadataItems(String portalURL, long groupId, long userId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_METADATA_URL + "scopes" +StringPool.FORWARD_SLASH + groupId);
		if (userId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=lrUserId"+ URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e);
			}
		}
		String response = commonApi.getData(sbURL.toString());
		LOGGER.debug(" URL ::::" +sbURL);
		return CustomObjectMapperUtil.readValue(response, UserMetatdataItems.class);
	}


	public void saveRoleServiceInfo(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LOGGER.info("inside processAction ::::::::::::::::");
		boolean associated=ParamUtil.getBoolean(actionRequest, "associated");
		boolean registringForRole=ParamUtil.getBoolean(actionRequest, "registering");
		String index=ParamUtil.getString(actionRequest, "index");

		String roleId=	ParamUtil.getString(actionRequest, "role_"+index);
		String departmentId=ParamUtil.getString(actionRequest, "department_"+index);
		String sectionId=ParamUtil.getString(actionRequest, "section_"+index);
		String functionId=ParamUtil.getString(actionRequest, "function_"+index);
		String programtypeId=ParamUtil.getString(actionRequest, "programtype_"+index);
		long programId=ParamUtil.getLong(actionRequest, "program_"+index);
		String programPositionId = ParamUtil.getString(actionRequest, "programPosition_"+index);
		String purposeId = ParamUtil.getString(actionRequest, "purpose_"+index);
		String commiteeId=ParamUtil.getString(actionRequest, "committe_"+index);
		String omsbServiceId=ParamUtil.getString(actionRequest, "service");
		long lrUserId=ParamUtil.getLong(actionRequest, "lrUserId");
		long id=ParamUtil.getLong(actionRequest, "id");
		boolean roleVerifiedStatisId=false;
		boolean profileVerifiedStatisId=false;
		//boolean registringForRole=true;
		String roleOther=	ParamUtil.getString(actionRequest, "roleOther_"+index);
		String departmentOther=ParamUtil.getString(actionRequest, "departmentOther_"+index);
		String sectionOther=ParamUtil.getString(actionRequest, "sectionOther_"+index);
		String functionOther=ParamUtil.getString(actionRequest, "functionOther_"+index);
		String programtypeOther=ParamUtil.getString(actionRequest, "programtypeOther_"+index);
		String programOther=ParamUtil.getString(actionRequest, "programOther_"+index);
		String programPositionOther = ParamUtil.getString(actionRequest, "programPositionOther_"+index);
		String purposeOther = ParamUtil.getString(actionRequest, "purposeOther_"+index);
		String commiteeOther=ParamUtil.getString(actionRequest, "commiteeOther");
		String omsbServiceOther=ParamUtil.getString(actionRequest, "serviceOther");
		LOGGER.debug("registringForRole :::::::::::::"+registringForRole);
		LOGGER.debug("index :::::::::::::"+index);
		LOGGER.debug("associated :::::::::::::"+associated);
		LOGGER.debug("roleId :::::::::::::"+roleId);
		LOGGER.debug("departmentId :::::::::::::"+departmentId);
		LOGGER.debug("sectionId :::::::::::::"+sectionId);
		LOGGER.debug("functionId :::::::::::::"+functionId);
		LOGGER.debug("programtypeId :::::::::::::"+programtypeId);
		LOGGER.debug("programId :::::::::::::"+programId);
		LOGGER.debug("commiteeId :::::::::::::"+commiteeId);
		LOGGER.debug("omsbServiceId :::::::::::::"+omsbServiceId);

		if(Validator.isNotNull(lrUserId) && lrUserId >0) {
			UserMetatdataItems  userMetadataItem =getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), lrUserId);
			//null check

			if(Validator.isNotNull(userMetadataItem.getItems()) && userMetadataItem.getItems().size()>0) {
				UserMetadata userMetadata=userMetadataItem.getItems().get(0);
				LOGGER.debug("lrUserId :::::::::::::"+userMetadataItem.getItems().get(0).getId());
				deleteUserMetaData(themeDisplay, userMetadata.getId());		
			}
			LOGGER.info("Deleted::::User infO");
		}

		if(Validator.isNotNull(omsbServiceId) && !registringForRole) {
			saveUserMetadata(themeDisplay, null, null, null, null, null, 0, 
					null, null, null, null, roleVerifiedStatisId, profileVerifiedStatisId, omsbServiceId, registringForRole, associated,
					lrUserId,false,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
		}else {
			saveUserMetadata(themeDisplay, roleId, departmentId, sectionId, commiteeId, functionId,
					programId, programPositionId, programPositionOther, purposeId, purposeOther, roleVerifiedStatisId, profileVerifiedStatisId, omsbServiceId, registringForRole, associated,
					lrUserId,false,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);

		}
	}
	/*
	 * this method returns PersonItem by civil id and date of birth
	 */
	public PersonItem getPersonsByCivilIdAndDob(String portalURL,long groupId, String civilId, String dob) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSON_URL + "scopes" +StringPool.FORWARD_SLASH + groupId);
		if (!civilId.isEmpty()) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=civilId"
						+ URLEncoder.encode(" eq " + "'" + civilId + "'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}


		LOGGER.info("url::getPerson:::::" + sbURL);
		return getItems(sbURL.toString(), PersonItem.class);
	}

	/*
	 * Returns work detailsItems by Person id
	 */
	public EmploymentDetailItem getWorkDetailsByPersonId(String portalURL,long groupId,long personId) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + groupId);
		if(Validator.isNotNull(personId)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.debug("url::get Work Details:::::" + sbURL);		
		return getItems(sbURL.toString(), EmploymentDetailItem.class);
	}
	/*
	 * save work Detail of Person
	 */
	public EmploymentDetail saveWorkDetailData(String portalURL, long groupId, EmploymentDetail workDetail){
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String workDetailMapper = CustomObjectMapperUtil.writeValueAsString(workDetail, null);
		String response = httpConnector.executePost(portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + groupId, workDetailMapper, headers);
		return CustomObjectMapperUtil.readValue(response, EmploymentDetail.class);
	}
	/*
	 * delete work detail 
	 */
	public void deleteWorkDetailData(String portalURL, long groupId,long employmentDetailId) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String sbURL=portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_DELETE_URL + employmentDetailId;
		LOGGER.info("sbURL : "+sbURL);
		httpConnector.executeDelete(sbURL, headers);
	}

	private void uploadDocument(ActionRequest actionRequest, ThemeDisplay themeDisplay, long personId) {
		LOGGER.info("inside uploadDocument ");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();

		LOGGER.info("files:::::" + files + "::::" + files.size());
		long groupId = 0;

		Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);

		if (Validator.isNotNull(group)) {

			groupId = group.getGroupId();

		}
		createDFFolderStructure(groupId, personId, DataflowConstants.EMPLOYMENT_COMPONENT_KEY);


	}

	public WorkSectorItems getWorkSectorByParentId(String portalURL,long groupId, long parentId) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_WORK_SECTOR_URL + groupId);
		try {
			sbURL.append(StringPool.QUESTION + "filter=workSectorParentId"
					+ URLEncoder.encode(" eq " + parentId, DataflowConstants.UTF_8));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("url::get Work Sector:::::" + sbURL);		
		return getItems(sbURL.toString()+ "&sort=workSector:asc&pageSize=0", WorkSectorItems.class);
	}


	public JSONArray getJsonArray(String portalURL,long groupId, long parentId) {		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		WorkSectorItems workSectorItems = getWorkSectorByParentId(portalURL, groupId, parentId);
		try {
			if (!workSectorItems.getItems().isEmpty()) {

				int length=workSectorItems.getItems().size();
				/*
				 * if(length>10) { for(int i=0;i<=10;i++) { WorkSector
				 * workSector=workSectorItems.getItems().get(i); JSONObject jsonObject =
				 * JSONFactoryUtil.createJSONObject(); jsonObject.put("id",
				 * workSector.getWorkSectorId()); jsonObject.put("title",
				 * workSector.getWorkSector()); //jsonObject.put("subs",
				 * JSONFactoryUtil.createJSONArray()); //jsonObject.put("subs",
				 * getChild(portalURL, groupId, workSector.getWorkSectorId()));
				 * jsonArray.put(jsonObject); } }else { for(int i=0;i<length;i++) { WorkSector
				 * workSector=workSectorItems.getItems().get(i); JSONObject jsonObject =
				 * JSONFactoryUtil.createJSONObject(); jsonObject.put("id",
				 * workSector.getWorkSectorId()); jsonObject.put("title",
				 * workSector.getWorkSector()); jsonObject.put("subs",
				 * JSONFactoryUtil.createJSONArray()); //jsonObject.put("subs",
				 * getChild(portalURL, groupId, workSector.getWorkSectorId()));
				 * jsonArray.put(jsonObject); }
				 * 
				 * }
				 */

				for (WorkSector workSector : workSectorItems.getItems()) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("id", workSector.getId());
					//jsonObject.put("id", workSector.getWorkSectorId());
					jsonObject.put("title", workSector.getWorkSector());
					jsonObject.put("subs",JSONFactoryUtil.createJSONArray());
					//jsonObject.put("subs", getChild(portalURL, groupId, workSector.getWorkSectorId()));

					jsonArray.put(jsonObject);
				}
				JSONObject otherJson = JSONFactoryUtil.createJSONObject();
				otherJson.put("id", "Other");
				otherJson.put("title", "Other");
				//otherJson.put("subs",JSONFactoryUtil.createJSONArray());

				jsonArray.put(otherJson);

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return jsonArray;	
	}

	public JSONArray getChild(String portalURL, long groupId, long parentId) {

		WorkSectorItems workSectorItems = getWorkSectorByParentId(portalURL, groupId, parentId);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		if (workSectorItems.getItems().isEmpty()) {
			return jsonArray;
		}
		try {
			if (!workSectorItems.getItems().isEmpty()) {


				int length=workSectorItems.getItems().size();
				if(length>10) {
					for(int i=0;i<=10;i++) {
						WorkSector workSector=workSectorItems.getItems().get(i);
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("id", workSector.getWorkSectorId());
						jsonObject.put("title", workSector.getWorkSector());
						jsonObject.put("subs", getChild(portalURL, groupId, workSector.getWorkSectorId()));
						jsonArray.put(jsonObject);
					}
				}else {
					for(int i=0;i<length;i++) {
						WorkSector workSector=workSectorItems.getItems().get(i);
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("id", workSector.getWorkSectorId());
						jsonObject.put("title", workSector.getWorkSector());
						jsonObject.put("subs", getChild(portalURL, groupId, workSector.getWorkSectorId()));
						jsonArray.put(jsonObject);
					}

				}

				/*
				 * for (WorkSector workSector : workSectorItems.getItems()) { JSONObject
				 * jsonObject = JSONFactoryUtil.createJSONObject(); jsonObject.put("id",
				 * workSector.getWorkSectorId()); jsonObject.put("title",
				 * workSector.getWorkSector()); jsonObject.put("subs", getChild(portalURL,
				 * groupId, workSector.getWorkSectorId()));
				 * 
				 * jsonArray.put(jsonObject); }
				 */
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return jsonArray;
	}


	/*  public void saveWorkDetail(ActionRequest actionRequest) {
		  ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		  Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);
			long groupId = group.getGroupId();
			String counter = ParamUtil.getString(actionRequest, "workDetailList");
			long personId = ParamUtil.getLong(actionRequest, "personId");

			long lrUserId= ParamUtil.getLong(actionRequest,"lrUserId");

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	        JSONArray jsonArray=null;

	        try {
				jsonArray = JSONFactoryUtil.createJSONArray(counter);
				LOGGER.info(jsonArray+" ===");
			} catch (JSONException e) {
				LOGGER.error("unable to create the jsonArray of "+counter+ " cause : "+e.getCause()+"  message : "+e.getMessage());
			}
	        if (Validator.isNotNull(personId)) {
	        	EmploymentDetailItem workDetailItems = getWorkDetailsByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId);
	           if(Validator.isNotNull(workDetailItems) && workDetailItems.getItems().size()>0) {
				 for(EmploymentDetail workDetail : workDetailItems.getItems()) {
					deleteWorkDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getId());
				}
	           }
	        }

	        long employed=ParamUtil.getLong(actionRequest, "employed");
	        if(Validator.isNotNull(jsonArray) &&  employed == 1) {

	        	for(int i=0;i<jsonArray.length();i++) {
	        		File file = null;
	        		FileEntry fileEntry = null;
	    	        String fileEntryId=StringPool.BLANK;
	    	        String mimeType=StringPool.BLANK;
	    			String fileName = StringPool.BLANK;
	    			DLFolder dlFolder = null;
	        		LOGGER.info("jsonArray : "+jsonArray.getInt(i));
	        		String workSectorType=ParamUtil.getString(actionRequest,"workSectorType_"+jsonArray.getInt(i));
	        		String existingUploadedFile=ParamUtil.getString(actionRequest,"uploadFile_"+jsonArray.getInt(i));
	        		String workSector=ParamUtil.getString(actionRequest,"worksector_"+jsonArray.getInt(i));
	        		String workSectorOther=ParamUtil.getString(actionRequest,"worksectorother_"+jsonArray.getInt(i));
	        		String wilayat=ParamUtil.getString(actionRequest,"wilayats_"+jsonArray.getInt(i));
	        		String designation=ParamUtil.getString(actionRequest,"designations_"+jsonArray.getInt(i));
	        		String designationother=ParamUtil.getString(actionRequest,"designationother_"+jsonArray.getInt(i));
	        		//String uploadFile=ParamUtil.getString(actionRequest,"uploadFile_"+jsonArray.getInt(i));
	        		file = uploadPortletRequest.getFile("staffIdCard_" +jsonArray.getInt(i));
	        		 fileName=uploadPortletRequest.getFileName("staffIdCard_" +jsonArray.getInt(i));
	        		LOGGER.info("existingUploadedFile : "+existingUploadedFile);
	        		long workSectorId=0;




	        		LOGGER.info("workSector ::::::"+workSector);
	        		LOGGER.info("workSectorOther ::::::"+workSectorOther);
	        		LOGGER.info("workSectorOther is Null::::::"+Validator.isNull(workSectorOther));

		        		if(Validator.isNotNull(workSector)  && Validator.isNotNull(workSectorOther)) {

		        			//NO api call to get id

		        		}else if(Validator.isNotNull(workSector)  && Validator.isNull(workSectorOther)) {

		        			//Api call to get work sector id

		        			try {
								WorkSectorItems workSectorItem=	getWorkSectorDetailByWorkSector(themeDisplay, workSector);
								LOGGER.info("workSectorItem size ::::"+workSectorItem.getItems().size());
								WorkSector workSectorObj=workSectorItem.getItems().get(0);
								workSectorId=workSectorObj.getId();
								LOGGER.info("workSectorObj.getId() ::"+workSectorObj.getId());
								LOGGER.info("workSectorObj.getWilayatId() ::"+workSectorObj.getWilayatId());
								LOGGER.info("workSectorObj.getWorkSector() :::"+workSectorObj.getWorkSector());
							} catch (Exception e) {
								LOGGER.error(e.getMessage());
							}

		        		}


	        		Role adminRole= null;
	    			try {
						adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
						List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
		    			long userId = getAdmin(themeDisplay.getCompanyId()).getUserId();
		    			if(adminUsers != null && !adminUsers.isEmpty()) {
		    				userId = adminUsers.get(0).getUserId();
		    			}
		    			User user = UserLocalServiceUtil.getUser(userId);
		    			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
		    			PermissionThreadLocal.setPermissionChecker(checker);
		        		dlFolder = createDFFolderStructure(groupId, personId,
								DataflowConstants.EMPLOYMENT_COMPONENT_KEY);
		        		if ( file!=null && file.exists() && existingUploadedFile.equals("")) {
							mimeType = MimeTypesUtil.getContentType(file);
							fileEntry = FileUploadUtil.addDocument(fileName, file, mimeType, groupId,
									dlFolder.getFolderId());
							fileEntryId=String.valueOf(fileEntry.getFileEntryId());
							LOGGER.info("file entry added successfully in document and media::::::::::::::::::::::::::::::::::::::::");
						}
						else if(file!=null && file.exists() && !existingUploadedFile.equals("")) {
							DLFileEntry deletedFileEntry=null;
							mimeType = MimeTypesUtil.getContentType(file);
							LOGGER.info(":::file name od video::" + fileName);
							try {
								deletedFileEntry=DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.valueOf(existingUploadedFile));						
							}
							catch(PortalException e) {
								fileEntryId=existingUploadedFile;
								LOGGER.info("unable to delete the file : "+e.getMessage()+"  ::: cause : "+e.getCause());
							}
							if(Validator.isNotNull(deletedFileEntry)) {
								fileEntry = FileUploadUtil.addDocument(fileName, file, mimeType, groupId,
										dlFolder.getFolderId());
								fileEntryId=String.valueOf(fileEntry.getFileEntryId());
							}
							}
						else if(file!=null && !file.exists() && !existingUploadedFile.equals("")) {
							fileEntryId=existingUploadedFile;
						}
						else {
							LOGGER.debug("inside else :: ");
						}
		        		LOGGER.info("staffIdCard_ : "+fileEntryId);
		        		//setWorkDetail(actionRequest, themeDisplay, workSectorType, workSectorId, workSectorOther, wilayat, designation, designationother, fileEntryId, personId);



		        		setWorkDetail(lrUserId, themeDisplay, workSectorType, workSectorId, workSectorOther, wilayat, designation, designationother, fileEntryId, personId,false);
	    			} catch (PortalException e1) {
						LOGGER.error(e1.getMessage());
					}
	        	}
	        }

	        //Update Regis
	      //Update User status
			if(Validator.isNotNull(personId) && personId>0) {
				PersonalDetailItem personDetailItem=fetchPersonalDetailsByPersonId(personId, themeDisplay);
				if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
					try {
						PersonalDetail personalDetail=personDetailItem.getItems().get(0);
						personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.WORK_DETAILS);
						savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
				}	
			}
	  }*/


	public WorkSectorItems getWorkSectorDetailByWorkSector(ThemeDisplay themeDisplay,String workSector) {
		StringBuilder sbURL = new StringBuilder(
				themeDisplay.getPortalURL() + LRObjectURL.REG_WORK_SECTOR_URL + themeDisplay.getScopeGroupId());
		try {
			sbURL.append(StringPool.QUESTION + "filter=workSector"
					+ URLEncoder.encode(" eq '" + workSector +"'", DataflowConstants.UTF_8));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("url::get Work Sector:::::" + sbURL);
		String response = commonApi.getData(sbURL.toString());

		LOGGER.debug("get Work Sector response:::::" + response);

		if (Validator.isNotNull(response)) {
			return CustomObjectMapperUtil.readValue(response, WorkSectorItems.class);
		}
		return null;

	}


	public EmploymentDetail setWorkDetail(long lrUserId,ThemeDisplay themeDisplay,String workSectorType,long workSector,String workSectorOther,String wilayat,String designation,String designationother,String staffCardId,long personId,String isPrimary) {
		EmploymentDetail workDetail =  new EmploymentDetail();
		try {            
			workDetail.setWorkSectorId(workSector);

			workDetail.setWorkSectorOther(workSectorOther);
			workDetail.setWorkSectorType(workSectorType);
			workDetail.setWorkSectorLocation(wilayat);
			workDetail.setPersonId(personId);
			workDetail.setDesignationId(designation);
			workDetail.setDesignationOther(designationother);
			workDetail.setStaffIdCard(staffCardId);
			workDetail.setlRUserId(lrUserId);
			workDetail.setPrimaryWorkDetail(isPrimary);
			LOGGER.debug("workDetail :: "+workDetail);
			return saveWorkDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail);
		}
		catch(Exception e) {

		}
		return workDetail;
	}

	public WorkSector getWorkSectorById(String portalURL, long workSectorId) {
		String url=portalURL + LRObjectURL.REG_GET_WORK_SECTOR_URL + workSectorId;
		LOGGER.info("url ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+url);

		return getItems(url, WorkSector.class);
	}

	public <T> T getRegistrationWorkflowStatus(String portalURL, long groupId, String apiURL, long userId, long personId, long workFlowStatus, Class<T> clazz) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + apiURL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		try {
			if (Validator.isNotNull(userId) && Validator.isNotNull(personId)) {
				sbURL.append(StringPool.QUESTION + "filter=lrUserId" + URLEncoder
						.encode(" eq " + userId + " and personId eq " + personId, DataflowConstants.UTF_8));
			} else if (Validator.isNotNull(userId)) {
				sbURL.append(StringPool.QUESTION + "filter=lrUserId" + URLEncoder
						.encode(" eq " + userId, DataflowConstants.UTF_8));

			} else if (Validator.isNotNull(personId)) {
				sbURL.append(StringPool.QUESTION + "filter=personId" + URLEncoder
						.encode(" eq " + personId, DataflowConstants.UTF_8));
			}
			if(personId==0 && userId==0) {
				sbURL.append("?sort=id:desc&pageSize=0");
			} else {
				sbURL.append("&sort=id:desc&pageSize=0");
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("getUserStatus Request URL :"+sbURL.toString());
		return getItems(sbURL.toString(), clazz);
	}

	public Registration getWorkflowData(ThemeDisplay themeDisplay, Registration registration,String objectERC) {

		try {
			Role adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
			String className = commonApi.getObjectClassName(objectERC, themeDisplay.getCompanyId());
			
			WorkflowInstance instance = CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay, registration.getWorkflowId());
			
			if (Validator.isNotNull(instance)) {
				registration.setWorkflowInstanceId(instance.getWorkflowInstanceId());;
				List<WorkflowLog> logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
				if (!logs.isEmpty()) {
					registration.setAssignedToMe(CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay, CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs)));
					registration.setWorkflowTaskId(CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs));
					registration.setTransitionNames(CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, registration.getWorkflowTaskId()));
				}
			}


			LOGGER.debug("registration isAssignedToMe ::::" +registration.isAssignedToMe());


		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		return registration;
	}

	public UserRegistrationStatus updateRegistrationStatus(String portalURL, long groupId, String objectURL, UserRegistrationStatus userRegistrationStatus) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		if (Validator.isNotNull(userRegistrationStatus) && userRegistrationStatus.getId() > 0) {
			String userRegistrationStatusMapper = CustomObjectMapperUtil.writeValueAsString(userRegistrationStatus, null);
			String response = httpConnector.executePut(portalURL + objectURL + userRegistrationStatus.getId(), userRegistrationStatusMapper, headers);
			return CustomObjectMapperUtil.readValue(response, UserRegistrationStatus.class);
		}
		return null;
	}

	public UserRegistrationStatus addRegistrationStatus(String portalURL, long groupId, String objectURL, UserRegistrationStatus userRegistrationStatus) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		if (Validator.isNotNull(userRegistrationStatus)) {
			String userRegistrationStatusMapper = CustomObjectMapperUtil.writeValueAsString(userRegistrationStatus, null);
			String response = httpConnector.executePost(portalURL + objectURL + CommonConstants.SCOPES
					+ StringPool.SLASH + groupId, userRegistrationStatusMapper, headers);
			return CustomObjectMapperUtil.readValue(response, UserRegistrationStatus.class);
		}
		return null;
	}


	public PersonItem fetchPersonByLrUserId(ThemeDisplay themeDisplay,long lrUserId)
			throws UnsupportedEncodingException {
		String personUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_PERSON_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lrUserId, DataflowConstants.UTF_8);
		String personResponse = commonApi.getData(personUrl);
		LOGGER.info("fetchPersonByPassport:::::::::::>>>>>>>>>" + personUrl);
		return CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
	}

	public void setEducationDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long personId=ParamUtil.getLong(resourceRequest, "personId");
		LOGGER.info("pp : "+personId);
		LOGGER.info("ppp-- ");
		EducationDetailItem educationalDetailItem=null;
		if(Validator.isNotNull(personId)) {
			try {
				LOGGER.info("PPID : "+personId);
				educationalDetailItem = fetchEducationDetailByPersonId(themeDisplay,personId);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		else {
			LOGGER.info("lruserIDDD : "+ParamUtil.getLong(resourceRequest, "lrUserId"));
			educationalDetailItem=fetchEducationDetailByLrUserId(themeDisplay, ParamUtil.getLong(resourceRequest, "lrUserId"));
		}
		if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
			LOGGER.debug("educationalDetail ::::::::::::::::::"+educationalDetailItem.getItems().get(0).getPersonId());
			List<EducationDetail>  educationalDetailItemList =educationalDetailItem.getItems();
			for(EducationDetail detail : educationalDetailItemList) {
				if(Validator.isNotNull( detail.getQualificationAttained())) {
					try {
						detail.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
				}
				if(Validator.isNotNull(detail.getIssuingAuthorityName())) {
					try {
						ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
								.fetchListTypeEntry(Long.parseLong(detail.getIssuingAuthorityName()));
						//detail.setIssuingAuthorityName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION, detail.getIssuingAuthorityName(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
						detail.setIssuingAuthorityName(listEntry.getName(Locale.getDefault()));
					} catch (NumberFormatException e) {
						LOGGER.error(e.getMessage());
					}
				}
				if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) {
					//Country country = getCustomCountryById(themeDisplay.getPortalURL(), detail.getIssuingAuthorityCountryId());
					//CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId())
					//if(Validator.isNotNull(country)) {
					//detail.setIssuingAuthorityCountry(country.getNationality());
					//}
					com.liferay.portal.kernel.model.Country country=null;
					try {
						country = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());
						detail.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));
					} catch (PortalException e) {
						LOGGER.error("unable to get the country having id :: "+detail.getIssuingAuthorityCountryId()+ " :::: "+e.getMessage());
					}
				}
			}
			resourceRequest.setAttribute("educationalDetailItemList", educationalDetailItemList);
		}
		/*
		 * } catch (UnsupportedEncodingException e) { LOGGER.error(e.getMessage()); }
		 */

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/jsps/registration/education-details-list.jsp");
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public EducationDetail setEducationDetailsData(ResourceRequest resourceRequest,ThemeDisplay themeDisplay, long groupId, String title, String institute,
			long countryId, String gpa, int yearOfGraduation, long id,String qualificationOther) {
		LOGGER.info("Entry into setEducationalDetailsData :::");
		EducationDetail educationDetail = null;
		try {
			educationDetail = new EducationDetail();
			educationDetail.setId(id);
			educationDetail.setQualificationAttained(title);
			educationDetail.setIssuingAuthorityName(institute);
			educationDetail.setIssuingAuthorityCountryId((int) countryId);
			educationDetail.setYearOfGraduation(yearOfGraduation);
			educationDetail.setGpa(gpa);
			educationDetail.setPersonId(ParamUtil.getLong(resourceRequest, "personId"));
			educationDetail.setlRUserId(ParamUtil.getLong(resourceRequest, "lrUserId"));
			educationDetail.setQualificationOther(qualificationOther);

			educationDetail = saveEducationDetail(resourceRequest, themeDisplay, groupId, educationDetail);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("Exit setEducationalDetailsData :::::");
		return educationDetail;
	}

	public EducationDetail saveEducationDetail(ResourceRequest resourceRequest,ThemeDisplay themeDisplay, long groupId, EducationDetail educationDetail) {
		LOGGER.info("inside saveEducationDetail :::::");
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String educationDetailMapper = CustomObjectMapperUtil.writeValueAsString(educationDetail, null);
		String response = null;
		if(educationDetail.getId()>0) {
			response = httpConnector.executePut(themeDisplay.getPortalURL() + LRObjectURL.REG_EDUCATION_DETAIL_URL + educationDetail.getId(), educationDetailMapper, headers);
			//Delete Document Info 
			deleteDocumentInfo(themeDisplay, educationDetail);
		} else {
			response = httpConnector.executePost(themeDisplay.getPortalURL() + LRObjectURL.REG_EDUCATION_DETAIL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + groupId, educationDetailMapper, headers);

		}
		educationDetail=CustomObjectMapperUtil.readValue(response, EducationDetail.class);
		LOGGER.debug("EDUCATIONAL DETAILS  ADDED SUCCESSFULLY::::::::::::::::::::::::::::::::::::::::::" +educationDetail.getId() + ":: "+educationDetail.getQualificationAttained());
		if(Validator.isNotNull(educationDetail)) {
			uploadDocument(resourceRequest, themeDisplay,educationDetail.getPersonId(), DataflowConstants.EDUCATION_COMPONENT_KEY, educationDetail.getId(), 0, educationDetail.getlRUserId());
		}
		return educationDetail;
	}

	private void deleteDocumentInfo(ThemeDisplay themeDisplay, EducationDetail educationDetail) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		try {
			String documentInfoUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
					+ StringPool.QUESTION + "filter=componentClassRefId"
					+ URLEncoder.encode(" eq " + educationDetail.getId(), DataflowConstants.UTF_8);
			String documentInfoUrlResponse = commonApi.getData(documentInfoUrl);
			DocumentInfoItem documentInfoItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfoItem.class);


			if(Validator.isNotNull(documentInfoItems) && documentInfoItems.getItems().size()>0) {
				DocumentInfo documentInfo= documentInfoItems.getItems().get(0);

				long fileEntryId = documentInfo.getFileEntryID();
				if (Validator.isNotNull(fileEntryId)) {
					try {
						//DLAppServiceUtil.deleteFileEntry(fileEntryId);
						//Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
						String url = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + documentInfo.getId();
						LOGGER.info("Document documentInfoId url ::::::" + url);
						httpConnector.executeDelete(url, headers);
						LOGGER.debug("Document documentInfoId Deleted ::::::" + documentInfo.getId());
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
				}
			}

		} catch (Exception e) {
			LOGGER.error("error :::" +e.getMessage());
		}
	}

	private void uploadDocument(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, long personId,
			String componentKey, long pk, long caseRequestId, long lRUserId) {
		LOGGER.info("inside uploadDocument ");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		LOGGER.info("files:::::" + files + "::::" + files.size());
		long groupId = 0;
		Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			groupId = group.getGroupId();
		}
		Role adminRole= null;
		try {
			adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = RegistrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId();
			if(adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);

			DLFolder folder = createDFFolderStructure(groupId, personId, componentKey);
			FileEntry entry = null;

			long fileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
			uploadPortletRequest.getContentType("qualificationDoc");

			if (Validator.isNotNull(folder)) {
				String fileName=uploadPortletRequest.getFileName("qualificationDoc");		 			
				File file = uploadPortletRequest.getFile("qualificationDoc");
				String mimeType = uploadPortletRequest.getContentType("qualificationDoc");

				LOGGER.debug("mimeType ::::"+mimeType);


				if(Validator.isNotNull(mimeType)) {
					try {
						byte[] fileBytes = new FileInputStream(file).readAllBytes();
						entry = FileUploadUtil.createFileEntry(groupId, folder.getFolderId(), fileName,
								mimeType, "", fileBytes);
					} catch (FileNotFoundException e1) {
						LOGGER.error(e1.getMessage());
					} catch (IOException e) {
						LOGGER.error(e.getMessage());
					}
				}else {
					entry =DLAppServiceUtil.getFileEntry(fileEntryId);
				}
				if (Validator.isNotNull(entry)) {
					LOGGER.debug("Entry ::::::" +entry);
					saveDocumentInfo(themeDisplay, entry.getFileEntryId(), 0, pk, personId, caseRequestId, 0, 0,StringPool.BLANK, entry.getFileName(),lRUserId);
				}
			}			
		} catch (PortalException e3) {
			LOGGER.debug("Error ::" +e3.getMessage());
		}
	}
	public void setEmploymentDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		EmploymentDetailItem workDetailItems = getWorkDetailsByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), ParamUtil.getLong(resourceRequest, "personId"));

		if(Validator.isNotNull(workDetailItems) && workDetailItems.getItems().size()>0) {
			LOGGER.debug("educationalDetail ::::::::::::::::::"+workDetailItems.getItems().get(0).getPersonId());
			for(EmploymentDetail workDetail : workDetailItems.getItems()) {
				try {

					if(Validator.isNotNull(workDetail.getStaffIdCard())) {
						workDetail.setUploadFileName(DLFileEntryLocalServiceUtil
								.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getFileName());
					}
					if(Validator.isNotNull( workDetail.getWorkSectorType())) {
						workDetail.setWorkSectorType(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.WORK_SECTOR_TYPE, workDetail.getWorkSectorType(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					}
					if(Validator.isNotNull( workDetail.getWorkSectorLocation())) {
						workDetail.setWorkSectorLocation(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.WILAYAT, workDetail.getWorkSectorLocation(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					}
					if(Validator.isNotNull( workDetail.getDesignationId())) {
						workDetail.setDesignationId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, workDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					}
					LOGGER.debug("workDetail :: " + workDetail);
				} catch (Exception e) {
					LOGGER.error("Error :::::"+e.getMessage());
				}
			}

			LOGGER.debug("workDetailList ::::" + workDetailItems.getItems().size());
			// LOGGER.info("educationalDetailItemList ::::" +workDetailList.get(0));
			resourceRequest.setAttribute("workDetailItems", workDetailItems);
		}

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/jsps/registration/work-details-list.jsp");
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}


	public EmploymentDetail saveEmploymentDetail(ActionRequest actionRequest, EmploymentDetail employmentDetail,
			UploadPortletRequest uploadPortletRequest, long groupId, ThemeDisplay themeDisplay, long personId,
			long lrUserId, long employed) {
		File file;

		LOGGER.info("employed ::::"+employed);


		if (employed == 1) {
			for (int i = 1; i <= 2; i++) {

				String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
				String worksectortypeother = ParamUtil.getString(actionRequest, "worksectortypeother_" + i);
				long workSector = ParamUtil.getLong(actionRequest, "worksector_" + i);
				String worksectorother = ParamUtil.getString(actionRequest, "worksectorother_" + i);
				long firstsubworksector = ParamUtil.getLong(actionRequest, "first-sub-worksector_" + i);
				String worksubsectorother = ParamUtil.getString(actionRequest, "work_sub_sectorother_" + i);


				//Third Level
				long secondSubWorksector = ParamUtil.getLong(actionRequest, "second-sub-worksector_" + i);
				String worksecondsectorother = ParamUtil.getString(actionRequest, "work_second_sub_sectorother_" + i);


				LOGGER.debug("secondSubWorksector ::: "+i+" :::"+secondSubWorksector);
				LOGGER.debug("worksecondsectorother ::: "+i+" :::"+worksecondsectorother);
				LOGGER.debug("workSectorType ::: "+i+" :::"+workSectorType);
				LOGGER.debug("workSector ::: "+i+" :::"+workSector);
				LOGGER.debug("worksectorother ::: "+i+" :::"+worksectorother);
				LOGGER.debug("firstsubworksector ::: "+i+" :::"+firstsubworksector);
				LOGGER.debug("worksubsectorother ::: "+i+" :::"+worksubsectorother);


				ListTypeEntry listTypeEntry =null;
				if(Validator.isNotNull(workSectorType)) {
					long workSectorTypeID=Long.parseLong(workSectorType);
					try {
						listTypeEntry	 =ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
					} catch (PortalException e) {
						LOGGER.error("Exception ::"+e.getMessage());
					}
					LOGGER.debug("listTypeEntry ::: " +listTypeEntry);
					LOGGER.debug("listTypeEntry key ::: " +listTypeEntry.getKey());
					LOGGER.debug("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
				}


				if(Validator.isNotNull(firstsubworksector) && firstsubworksector>0) {
					worksubsectorother=StringPool.BLANK;

				}

				LOGGER.debug("workSectorType :::"+workSectorType);
				LOGGER.debug("worksectortypeother :::"+worksectortypeother);
				LOGGER.debug("workSector :::"+workSector);
				LOGGER.debug("worksectorother :::"+worksectorother);
				LOGGER.debug("firstsubworksector :::"+firstsubworksector);
				LOGGER.debug("worksubsectorother :::"+worksubsectorother);

				//String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
				//String workSector = ParamUtil.getString(actionRequest, "worksector_" + i);
				//String workSectorOther = ParamUtil.getString(actionRequest, "worksectorother_" + i);

				if(Validator.isNotNull(listTypeEntry)) {
					if(!listTypeEntry.getKey().equalsIgnoreCase("others")) {
						worksectortypeother=StringPool.BLANK;
					}else {
						workSector=0;
						firstsubworksector=0;
						worksectorother=StringPool.BLANK;
						worksubsectorother=StringPool.BLANK;


						secondSubWorksector=0;
						worksecondsectorother=StringPool.BLANK;
					}
				}
				if(workSector==0 && Validator.isNotNull(worksectorother)) {
					firstsubworksector=0;
					worksubsectorother=StringPool.BLANK;

					secondSubWorksector=0;
					worksecondsectorother=StringPool.BLANK;
				}


				if(firstsubworksector==0 && Validator.isNotNull(worksubsectorother)) {
					secondSubWorksector=0;
					worksecondsectorother=StringPool.BLANK;
				}

				String wilayat = ParamUtil.getString(actionRequest, "wilayats_" + i);
				String designation = ParamUtil.getString(actionRequest, "designations_" + i);
				String designationother = ParamUtil.getString(actionRequest, "designationother_" + i);
				Boolean isPrimaryWorkDetail = ParamUtil.getBoolean(actionRequest, "isPrimary_" + i);

				long id = ParamUtil.getLong(actionRequest, "id_" + i);
				file = uploadPortletRequest.getFile("staffIdCard_" + i);
				String fileName = uploadPortletRequest.getFileName("staffIdCard_" + i);

				String mimeType = uploadPortletRequest.getContentType("staffIdCard_" + i);
				long uploadFileId = ParamUtil.getLong(actionRequest, "uploadFile_" + i);
				String fileEntryId = Validator.isNotNull(uploadFileId) ? String.valueOf(uploadFileId): StringPool.BLANK;

				String primaryWorkDetail="1";

				LOGGER.info("id ::::"+id);	
				LOGGER.debug("isPrimaryWorkDetail ::: " + isPrimaryWorkDetail + " id :: " +
						id + " personId : " + personId + " lrUserId : " + lrUserId + " employed " +
						employed + " workSectorType : " + workSectorType + " workSector : " +
						workSector + " workSectorOther : " + worksectorother + " wilayat :: " +
						wilayat + "  designation  : " + designationother + " fileName :: " + fileName
						+ " designation :: " + designation); 

				if(isPrimaryWorkDetail) {
					primaryWorkDetail="1";
				}else {
					primaryWorkDetail="2";
				}



				if (Validator.isNotNull(id)) {
					LOGGER.info("inside if condition"); 
					Map<String, String> headers =commonApi.getHttpHeaderInfoAndBasicAuth();
					String url =themeDisplay.getPortalURL() + LRObjectURL.REG_EMPLOYMENT_DETAIL_URL + id;
					LOGGER.info("url : " + url); 
					httpConnector.executeDelete(url, headers);
					//LOGGER.info("Document documentInfoId Deleted ::::::" + data); 
				}

				//Adding New Record 
				if (Validator.isNotNull(workSectorType) || Validator.isNotNull(workSector) || Validator.isNotNull(designation)) {

					if(Validator.isNotNull(fileName)) {
						fileEntryId =uploadFileByGuest(themeDisplay, groupId, personId,DataflowConstants.EMPLOYMENT_COMPONENT_KEY, file, fileName);
						LOGGER.info("fileEntryId : " + fileEntryId); 
					} 

					employmentDetail = setWorkDetailNew(lrUserId, themeDisplay, workSectorType,workSector, worksectorother, wilayat, designation, designationother,
							fileEntryId, personId,primaryWorkDetail,worksectortypeother,firstsubworksector,worksubsectorother,secondSubWorksector,worksecondsectorother); 
					LOGGER.debug("employmentDetail :::::::::::::::::::::"+employmentDetail); 
				}
			}




		}

		if (employed == 0) {
			EmploymentDetailItem employmentDetailItem = getWorkDetailsByPersonId(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId(), personId);
			if (Validator.isNotNull(employmentDetailItem) && employmentDetailItem.getItems().size() > 0) {
				for (EmploymentDetail detail : employmentDetailItem.getItems()) {
					deleteWorkDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), detail.getId());
				}
			}
		}

		return employmentDetail;
	}

	public String uploadFileByGuest(ThemeDisplay themeDisplay, long groupId, long personId, String folderName,
			File file, String fileName) {
		Role adminRole = null;
		DLFolder dlFolder = null;
		String mimeType = StringPool.BLANK;
		FileEntry fileEntry = null;
		String fileEntryId = StringPool.BLANK;
		try {
			adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);
			dlFolder = createDFFolderStructure(groupId, personId, folderName);
			if (file != null && file.exists()) {
				
				LOGGER.info("file NAME ::::"+file.getName());
				
				mimeType = MimeTypesUtil.getContentType(file);
				//fileEntry = FileUploadUtil.addFileEntry(fileName, file, mimeType, groupId, dlFolder.getFolderId());
				//fileEntry = FileUploadUtil.addFileEntry(fileName, file, mimeType, groupId, dlFolder.getFolderId());
				String title = Calendar.getInstance().getTimeInMillis()+fileName  ;
				try {
					ServiceContext serviceContext = new ServiceContext();
					serviceContext.setScopeGroupId(groupId);
					serviceContext.setAddGroupPermissions(true);
					fileEntry= DLAppServiceUtil.addFileEntry(groupId, dlFolder.getFolderId(), title, mimeType, title, fileName, "", file, serviceContext);
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
				
				
				
				fileEntryId = String.valueOf(fileEntry.getFileEntryId());
				LOGGER.info("file entry added successfully in document and media");
			}
			LOGGER.info("staffIdCard_ : " + fileEntryId);
			return fileEntryId;
		} catch (Exception e) {
			LOGGER.error("unable to upload the file ");
			return null;
		}
	}

	public void addRole(ThemeDisplay themeDisplay, String roleId, long userId, User regUSer,ActionRequest actionRequest) throws PortalException {
		String index=ParamUtil.getString(actionRequest, "index");
		String departmentId=ParamUtil.getString(actionRequest, "department_"+index);
		String sectionId=ParamUtil.getString(actionRequest, "section_"+index);
		String functionId=ParamUtil.getString(actionRequest, "function_"+index);

		boolean associated = ParamUtil.getBoolean(actionRequest, "associated");
		boolean registringForRole = ParamUtil.getBoolean(actionRequest, "registering");
		boolean requestForService = ParamUtil.getBoolean(actionRequest, "requestForService");
		LOGGER.info("departmentId :::" +departmentId );
		LOGGER.info("sectionId :::" +sectionId );
		LOGGER.info("functionId :::" +functionId );
		LOGGER.info("associated :::" +associated );
		LOGGER.info("registringForRole :::" +registringForRole );
		LOGGER.info("requestForService :::" +requestForService );

		try {
			List<Role> roleList =new ArrayList<>();
			Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.POWER_USER);
			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			if(requestForService) {
				Role healthCareProf = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.HEALTH_CARE_PROFESSIONAL);
				Role octApplicant = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EXAM_APPLICANT);

				if(Validator.isNotNull(healthCareProf)) {
					roleList.add(healthCareProf);
				}

				if(Validator.isNotNull(octApplicant)) {
					roleList.add(octApplicant);
				}


			}

			//	Role employeeRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EMPLOYEE);
			//UserLocalServiceUtil.addRoleUser(role.getRoleId(), regUSer.getUserId());

			roleList.add(powerUserRole);
			roleList.add(guestRole);
			//	roleList.add(employeeRole);

			//Section 
			//verificationAndEquivalencyOfHealthProfessionalsCertificatesSection
			//verificationEquivalencyOfHealthSection


			//Function 
			//verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist
			//verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist
			/*if(Validator.isNotNull(roleId)) {
				  long employerRoleId=Long.parseLong(roleId);
				  Role requestedRole=RoleLocalServiceUtil.getRole(employerRoleId);
				  if(departmentId.equalsIgnoreCase("professionalCompetenceDepartment") && 
						  sectionId.equalsIgnoreCase("verificationEquivalencyOfHealthSection") &&
						  functionId.equalsIgnoreCase("verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist")) {
					  Role toRequestedRole=null;

					  if(requestedRole.getName().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.ROLE_AUTHORIZED_USER_FROM_MEDICAL_INSTITUTIONS)) {
						  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), OmsbRegistrationWebPortletKeys.ROLE_EMPLOYER);
					  }else if(requestedRole.getName().equalsIgnoreCase("Staff")) {
						  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.VEHPC_ADMIN);
					  }else if(requestedRole.getName().equalsIgnoreCase("Committee member")) {
						  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.VEHPC_COMMITTEE);
					  }else {
						  toRequestedRole=requestedRole;
					  }
					  roleList.add(toRequestedRole);
				  }
			}else {
				LOGGER.info("Another role:::");
			}*/


			LOGGER.debug("roleList ::::" +roleList);
			RoleLocalServiceUtil.addUserRoles(regUSer.getUserId(), roleList);
			UserLocalServiceUtil.updateUser(regUSer);
			LOGGER.info("Role Added: ");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void getSubChild(JSONObject parentObj, List<WorkSector> workSectorList, WorkSector workSector,String portalURL,long groupId) {
		JSONArray sub = JSONFactoryUtil.createJSONArray();
		//for (int j = 0; j <workSectorList.size(); j++) {
		for (WorkSector sector : workSectorList) {
			//WorkSector sector = workSectorList.get(j);
			if (sector.getWorkSectorParentId() > 0 && workSector.getId() == sector.getWorkSectorParentId()) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("id", sector.getId());
				obj.put("title", sector.getWorkSector());

				//WorkSectorItems items=getWorkSectorByParentIdTest(portalURL, groupId, sector.getId());
				boolean isChildPresent=getWorkSectorByParentIdTest(portalURL, groupId, sector.getId());
				//if(Validator.isNotNull(items) && items.getItems().size()>0) {
				if(isChildPresent) {
					getSubChild(obj, workSectorList, sector,portalURL,groupId);
				}
				sub.put(obj);
			}
		}
		parentObj.put("subs", sub);
		//		LOGGER.info("Parent Json :::" + parentObj);
	}

	/*public void getSubChild2(JSONObject parentObj, List<WorkSector> workSectorList, WorkSector workSector) {
		LOGGER.info("Entry into :::::inside getSubChild2 :::::::");
		JSONArray sub = JSONFactoryUtil.createJSONArray();

		for (int k = 0; k < workSectorList.size(); k++) {
			WorkSector sector2 = workSectorList.get(k);
			if (sector2.getWorkSectorParentId() > 0 && workSector.getId() == sector2.getWorkSectorParentId()) {
				LOGGER.info("inside sub child 2 json object ::::k " + k);
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("id", sector2.getId());
				obj.put("title", sector2.getWorkSector());
				sub.put(obj);
			}
		}
		parentObj.put("subs", sub);
	}*/


	public JSONArray getJsonArrayTest(String portalURL,long groupId) {		
		JSONArray finalJsonArray = JSONFactoryUtil.createJSONArray();

		WorkSectorItems workSectorItems = getWorkAllSector(portalURL, groupId);
		LOGGER.info("workSectorItems :::::"+workSectorItems.getItems().size());
		LOGGER.debug("workSectorItems :::::"+workSectorItems.getItems());

		/**
		 * APPROACH 1
		 * 
		 **/
		if(Validator.isNotNull(workSectorItems) && workSectorItems.getItems().size()>0) {
			for(WorkSector workSector:workSectorItems.getItems()) {
				JSONObject obj=JSONFactoryUtil.createJSONObject();

				if(workSector.getWorkSectorParentId() == 0) {
					obj.put("id", workSector.getId());
					obj.put("title",workSector.getWorkSector());
					getSubChildForParent(workSectorItems, workSector,obj);
					finalJsonArray.put(obj);
				}

			}

		}
		JSONObject otherJson = JSONFactoryUtil.createJSONObject();
		otherJson.put("id", "Other");
		otherJson.put("title", "Other");
		finalJsonArray.put(otherJson);


		/**
		 * APPROACH 2
		 * 
		 **/

		/*	if(Validator.isNotNull(workSectorItems) && workSectorItems.getItems().size()>0) {
				List<WorkSector> workSectorList=workSectorItems.getItems();
				//for(int i=0;i<workSectorList.size();i++) {
					for(WorkSector workSector:workSectorList) {
					JSONObject obj=JSONFactoryUtil.createJSONObject();
					//WorkSector workSector=workSectorList.get(i);

					long pId=workSector.getWorkSectorParentId();
					if(pId == 0) {
						obj.put("id", workSector.getId());
						obj.put("title",workSector.getWorkSector());
					//WorkSectorItems items=getWorkSectorByParentIdTest(portalURL, groupId, workSector.getId());


					boolean isChildPresent=getWorkSectorByParentIdTest(portalURL, groupId, workSector.getId());

					LOGGER.info("WorkSectorItems :::items ::::" +isChildPresent);
					//LOGGER.info("WorkSectorItems :::items getItems ::::" +items.getItems());


					//if(Validator.isNotNull(items) && Validator.isNotNull(items.getItems()) && items.getItems().size()>0) {
						if(isChildPresent) {
							getSubChild(obj,workSectorList,workSector,portalURL,groupId);
						}
						finalJsonArray.put(obj);
					}
				}

			}*/

		LOGGER.debug("finalJsonArray :::::" +finalJsonArray);
		LOGGER.debug("finalJsonArray :::::" +finalJsonArray.length());
		return finalJsonArray;	
	}

	private void getSubChildForParent(WorkSectorItems workSectorItems, WorkSector workSector, JSONObject obj) {
		List<WorkSector> sectorList=workSectorItems.getItems().stream().filter(sector -> sector.getWorkSectorParentId()== workSector.getId()).collect(Collectors.toList());
		JSONArray arr=JSONFactoryUtil.createJSONArray();

		for(WorkSector s:sectorList) {
			JSONObject subObj =JSONFactoryUtil.createJSONObject();
			subObj.put("id", s.getId());
			subObj.put("title",s.getWorkSector());
			List<WorkSector> sectorSubList=workSectorItems.getItems().stream().filter(subSector -> subSector.getWorkSectorParentId()== s.getId()).collect(Collectors.toList());

			if(Validator.isNotNull(sectorSubList) && sectorSubList.size()>0 && !sectorSubList.isEmpty()) {
				getSubChildForParent(workSectorItems, s, subObj);
			}
			arr.put(subObj);
		}
		obj.put("subs", arr);
	}


	public WorkSectorItems getWorkAllSector(String portalURL,long groupId) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_WORK_SECTOR_URL + groupId);
		LOGGER.info("url::get Work Sector:::::" + sbURL);		
		return getItems(sbURL.toString()+ "?sort=id:desc&pageSize=0", WorkSectorItems.class);
	}


	public boolean getWorkSectorByParentIdTest(String portalURL,long groupId, long parentId) {
		boolean isChildPresent=false;
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_WORK_SECTOR_URL + groupId);
		try {
			sbURL.append(StringPool.QUESTION + "filter=workSectorParentId"
					+ URLEncoder.encode(" eq " + parentId, DataflowConstants.UTF_8));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		//LOGGER.info("url::get Work Sector:::::" + sbURL);	

		String response = commonApi.getData(sbURL.toString());
		if (Validator.isNotNull(response)) {
			JSONObject responseJson=null;
			try {
				responseJson = JSONFactoryUtil.createJSONObject(response);
				if(Validator.isNotNull(responseJson)) {
					//LOGGER.info("Response json ::::" +responseJson);
					int resultCount=responseJson.getInt("totalCount");
					if(responseJson.getInt("totalCount")>0) {
						isChildPresent=true;
					}
					//LOGGER.info("resultCount ::::" +resultCount);
				}
			} catch (JSONException e) {
				LOGGER.error(e.getMessage());
			}

		}
		//return getItems(sbURL.toString()+ "&sort=id:desc&pageSize=0", WorkSectorItems.class);
		return isChildPresent;
	}



	public PersonalDetailItem getPersonalDetailsItemsBasedOnStatus(String portalURL, long groupId, long personId, String registrationStatus) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_PERSONAL_DETAILS_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (Validator.isNotNull(registrationStatus)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=registrationStatus" + URLEncoder.encode(" eq '" + registrationStatus +"'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		} else if(personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("getPersonalDetailsItems :"+sbURL.toString());
		return getItems(sbURL.toString(), PersonalDetailItem.class);
	}



	public WorkSectorItems getWorkSectorsByWorkSectorType(String portalURL,long groupId,String workSectorType) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_WORK_SECTOR_URL + groupId);
		if(Validator.isNotNull(workSectorType)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=workSectorType"
						+ URLEncoder.encode(" eq '"+workSectorType+"' and workSectorParentId eq 0", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}

		LOGGER.info("url::get Work sector:::::" + sbURL);		
		return getItems(sbURL.toString()+"&sort=workSector:asc&pageSize=0", WorkSectorItems.class);
	} 



	public EmploymentDetail setWorkDetailNew(long lrUserId,ThemeDisplay themeDisplay,String workSectorType,long workSector,String workSectorOther,String wilayat,
			String designation,String designationother,String staffCardId,long personId,String isPrimary, String workSectorTypeOther, long workSubSectorId
			, String workSubSectorOther,long secondSubWorksector,String workSecondSectorOther) {
		EmploymentDetail workDetail =  new EmploymentDetail();
		try { 
			workDetail.setWorkSectorType(workSectorType);
			workDetail.setWorkSectorTypeOther(workSectorTypeOther);

			workDetail.setWorkSectorId(workSector);
			workDetail.setWorkSectorOther(workSectorOther);

			workDetail.setWorkSectorId2(workSubSectorId);
			workDetail.setWorkSectorOther2(workSubSectorOther);

			workDetail.setWorkSectorLocation(wilayat);
			workDetail.setPersonId(personId);
			workDetail.setDesignationId(designation);
			workDetail.setDesignationOther(designationother);
			workDetail.setStaffIdCard(staffCardId);
			workDetail.setlRUserId(lrUserId);
			workDetail.setPrimaryWorkDetail(isPrimary);

			workDetail.setWorkSectorId3(secondSubWorksector);
			workDetail.setWorkSectorOther3(workSecondSectorOther);

			LOGGER.debug("workDetail getWorkSectorId2:: "+workDetail.getWorkSectorId2());
			LOGGER.debug("workDetail getWorkSectorOther3:: "+workDetail.getWorkSectorOther3());
			return saveWorkDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail);
		}
		catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		return workDetail;
	}


	public EmploymentDetailItem getWorkDetailsByPersonIdAndWorkDetailType(String portalURL,long groupId,long personId,String isPrimaryWorkDetail) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + groupId);
		if(Validator.isNotNull(personId)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId + " and primaryWorkDetail eq '"+isPrimaryWorkDetail+"'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.debug("url::get Work Details:::::" + sbURL);		
		return getItems(sbURL.toString(), EmploymentDetailItem.class);
	} 

	public String readXMLData(String content, String Key) {
		String fieldValue = StringPool.BLANK;
		try {

			Document document = SAXReaderUtil.read(content);

			Node node = document
					.selectSingleNode("/root/dynamic-element[@field-reference='" + Key + "']/dynamic-content");

			if (Validator.isNotNull(node)) {
				return fieldValue = node.getText();
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return fieldValue;

	}

	public void setWorkDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long personId =ParamUtil.getLong(resourceRequest, "personId");
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			LOGGER.info("inside view get work details ");
			EmploymentDetailItem employmentDetailItem=null;
			if(Validator.isNotNull(personId)) {
				try {
					employmentDetailItem=getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
							themeDisplay.getScopeGroupId(), personId,"0");
				} catch (Exception e) {
					LOGGER.error("Exception in code :::"+e.getMessage());
				}
			}
			else {        
				employmentDetailItem=getWorkDetailsByLrUserIdAndWorkDetailType(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), lrUserId, "0");
			}
			if(Validator.isNotNull(employmentDetailItem) && Validator.isNotNull(employmentDetailItem.getItems()) && employmentDetailItem.getItems().size()>0) {

				List<EmploymentDetail> 	employmentDetailList=employmentDetailItem.getItems();	


				if(Validator.isNotNull(employmentDetailList) && employmentDetailList.size()>0) {

					for(EmploymentDetail employmentDetail :employmentDetailList) {

						LOGGER.debug("employmentDetail 1::: " +employmentDetail.getWorkSectorType());
						ListTypeEntry listTypeEntry = null;
						long workSectorTypeID = Long.parseLong(employmentDetail.getWorkSectorType());
						try {
							listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
						} catch (PortalException e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}

						if(Validator.isNotNull(employmentDetail.getWorkSectorTypeOther())) {
							employmentDetail.setWorkSectorType(employmentDetail.getWorkSectorTypeOther());
						}else {
							employmentDetail.setWorkSectorType(Validator.isNotNull(listTypeEntry)?listTypeEntry.getName(themeDisplay.getLocale()):StringPool.BLANK);
						}

						//	employmentDetail.setWorkSectorType(Validator.isNotNull(listTypeEntry)?listTypeEntry.getName(themeDisplay.getLocale()):StringPool.BLANK);




						WorkSector workSector=null;
						try {
							workSector=getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId());
						} catch (Exception e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}

						if(Validator.isNotNull(employmentDetail.getWorkSectorOther())) {
							employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther());
						}else {
							employmentDetail.setWorkSector(Validator.isNotNull(workSector)?workSector.getWorkSector():StringPool.BLANK );
						}
						//employmentDetail.setWorkSector(Validator.isNotNull(workSector)?workSector.getWorkSector():StringPool.BLANK );
						WorkSector workSector2=null;
						if(Validator.isNotNull(employmentDetail.getWorkSectorId2())) {
							try {
								workSector2=getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId2());
							} catch (Exception e) {
								LOGGER.error("Exception in code :::" + e.getMessage());
							}
						}

						if(Validator.isNotNull(employmentDetail.getWorkSectorOther2())) {
							employmentDetail.setWorkSector2(employmentDetail.getWorkSectorOther2());
						}else {
							employmentDetail.setWorkSector2(Validator.isNotNull(workSector2)?workSector2.getWorkSector():StringPool.BLANK );
						}

						if(Validator.isNotNull(employmentDetail.getDesignationOther())) {
							employmentDetail.setDesignationId(employmentDetail.getDesignationOther());
						}else {
							try {
								employmentDetail.setDesignationId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
							} catch (Exception e) {
								LOGGER.error("Exception ::"+e.getMessage());
							}
						}
						try {
							employmentDetail.setWorkSectorLocation(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.GOVERNORATE, employmentDetail.getWorkSectorLocation(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
						} catch (Exception e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}


						//employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));

					}

				}
				resourceRequest.setAttribute("pastWorkDetails", employmentDetailList);
			}
			/*
			 * EducationDetailItem educationalDetailItem =
			 * fetchEducationDetailByPersonId(themeDisplay,
			 * ParamUtil.getLong(resourceRequest, "personId"));
			 * if(Validator.isNotNull(employmentDetailItem) &&
			 * employmentDetailItem.getItems().size()>0) {
			 * LOGGER.info("educationalDetail ::::::::::::::::::"+educationalDetailItem.
			 * getItems().get(0).getPersonId()); List<EducationDetail>
			 * educationalDetailItemList =educationalDetailItem.getItems();
			 * for(EducationDetail detail : educationalDetailItemList) {
			 * if(Validator.isNotNull( detail.getQualificationAttained())) {
			 * detail.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(
			 * LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(),
			 * themeDisplay.getCompanyId()).getName(themeDisplay.getLocale())); }
			 * if(Validator.isNotNull( detail.getIssuingAuthorityName())) {
			 * detail.setIssuingAuthorityName(commonApi.getListTypeEntryByListTypeItemKey(
			 * LRPicklistConstants.INSTITUTION, detail.getIssuingAuthorityName(),
			 * themeDisplay.getCompanyId()).getName(themeDisplay.getLocale())); }
			 * if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) { Country
			 * country = getCustomCountryById(themeDisplay.getPortalURL(),
			 * detail.getIssuingAuthorityCountryId()); if(Validator.isNotNull(country)) {
			 * detail.setIssuingAuthorityCountry(country.getNationality()); } } }
			 * 
			 * LOGGER.info("educationalDetailItemList ::::"
			 * +educationalDetailItemList.size());
			 * LOGGER.info("educationalDetailItemList ::::"
			 * +educationalDetailItemList.get(0).getIssuingAuthorityCountryId());
			 * resourceRequest.setAttribute("educationalDetailItemList",
			 * educationalDetailItemList); }
			 */
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/jsps/registration/work-details-list.jsp");
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	} 

	public void setRoleService(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long lrUserId=ParamUtil.getLong(resourceRequest, "lrUserId");
			List<UserMetadata>  userMetadataList1 =new ArrayList<>();
			UserMetatdataItems userMetatdataItems = getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), lrUserId);
			if(Validator.isNotNull(userMetatdataItems) && userMetatdataItems.getItems().size()>0) {
				LOGGER.info("educationalDetail ::::::::::::::::::"+userMetatdataItems.getItems().get(0).getLrUserId());
				List<UserMetadata>  userMetadataList =userMetatdataItems.getItems();
				for(UserMetadata userMetadata : userMetadataList) {
					try {
						userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
					} catch (PortalException e) {
						LOGGER.error(e.getMessage());
					}

					long programTypeId=0;	
					LOGGER.debug("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
					if(Validator.isNotNull(userMetadata.getProgramId())) {
						try {
							ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
							programTypeId= ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId();
							userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
									themeDisplay.getLocale().toString())      );
						} catch (Exception e) {
							LOGGER.error(e.getMessage());
						}
						userMetadata.setProgramTypeId(programTypeId);
						if(programTypeId>0) {
							try {
								LOGGER.debug("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName());
								userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
										themeDisplay.getLocale().toString()));
							} catch (PortalException e) {
								LOGGER.error(e.getMessage());
							}
						}
					}
					
					if(Validator.isNotNull(userMetadata.getDepartmentId())){
						userMetadata.setDepartmentId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT, userMetadata.getDepartmentId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					}
					if(Validator.isNotNull(userMetadata.getSectionId())){
						userMetadata.setSectionId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION, userMetadata.getSectionId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					}
					
					if(Validator.isNotNull(userMetadata) && userMetadata.getId()>0){
						LOGGER.info("inside getting roleVerifiedStatus ::::");
						//roleVerifiedStatus
						try {
							LOGGER.debug("userMetadata.getId() ::::" +userMetadata.getId());
							UserRegistrationStatusItems userRoleStatusItems = getRoleStatusByUserMetadataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadata.getId());
							LOGGER.info("userRoleStatusItems ::::" +userRoleStatusItems.getItems().size());
							LOGGER.info("userRoleStatusItems ::::" +userRoleStatusItems.getItems().size());
							if (Validator.isNotNull(userRoleStatusItems)&& Validator.isNotNull(userRoleStatusItems.getItems())&& userRoleStatusItems.getItems().size() > 0) {
								UserRegistrationStatus userRegistrationStatus = userRoleStatusItems.getItems().get(0);
								LOGGER.info("userRegistrationStatus.userRegistrationStatus()e:::"+ userRegistrationStatus.getUserStatus());
								LOGGER.debug("userRegistrationStatus.getComment()e:::"+ userRegistrationStatus.getComment());
								userMetadata.setRoleVerifiedStatus(Validator.isNotNull(userRegistrationStatus.getUserStatus())? userRegistrationStatus.getUserStatus():"NA");
								userMetadata.setRoleVerifiedComments(Validator.isNotNull(userRegistrationStatus.getComment())? userRegistrationStatus.getComment():"NA");
							}
						} catch (Exception e) {
							LOGGER.error("Exception ::"+e.getMessage());
						}
					}
					
					
					if(Validator.isNotNull(userMetadata) && Validator.isNotNull(userMetadata) && userMetadata.getRoleId()>0) {
						userMetadataList1.add(userMetadata);
					}
				}
				
				LOGGER.info("educationalDetailItemList ::::" +userMetadataList.size());
				LOGGER.debug("educationalDetailItemList ::::" +userMetadataList.get(0).getRoleName());
				userMetatdataItems.setItems(userMetadataList1);
				resourceRequest.setAttribute("userMetadataItem", userMetatdataItems);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/jsps/registration/role-service-list.jsp");
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}



	public void deleteRoleStatus(ThemeDisplay themeDisplay,long roleStatusID) {
		try {
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			LOGGER.info("inside delete role status:::");
			String url=themeDisplay.getPortalURL() + LRObjectURL.REG_USER_ROLE_STATUS +roleStatusID;
			LOGGER.info(" role status url  ::::::"+url);
			httpConnector.executeDelete(url,headers);
			LOGGER.debug("role status  Deleted ::::::"+roleStatusID);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}  

	public UserRegistrationStatusItems getRoleStatusByUserMetaDataId(String portalURL, long groupId, long userMetaDataId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_ROLE_STATUS + "scopes" +StringPool.FORWARD_SLASH + groupId);
		if (userMetaDataId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=userMetaDataId"+ URLEncoder.encode(" eq " + userMetaDataId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e);
			}
		}
		String response = commonApi.getData(sbURL.toString());
		LOGGER.info("response :::::" + response +" ::  URL ::::" +sbURL);
		return CustomObjectMapperUtil.readValue(response, UserRegistrationStatusItems.class);
	}



	public UserMetadata getUserMetadataById(String portalURL, long userMetaDataId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_METADATA_URL+"/"+userMetaDataId );//+ "scopes" +StringPool.FORWARD_SLASH + groupId);

		String response = commonApi.getData(sbURL.toString());
		LOGGER.debug("response :::::" + response +" ::  URL ::::" +sbURL);
		return CustomObjectMapperUtil.readValue(response, UserMetadata.class);
	}
	public String generateRandomPassword(int len){
		// ASCII range – alphanumeric (0-9, a-z, A-Z)
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();

		// each iteration of the loop randomly chooses a character from the given
		// ASCII range and appends it to the `StringBuilder` instance
		return IntStream.range(0, len)
				.map(i -> random.nextInt(chars.length()))
				.mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
				.collect(Collectors.joining());
	}
	public UserMetadataItem fetchUserMetaDataByLrUserId(ThemeDisplay themeDisplay,long lrUserId)
			throws UnsupportedEncodingException {
		String userMetaDataUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
				+ StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lrUserId, DataflowConstants.UTF_8);
		String userMetaDataResponse = commonApi.getData(userMetaDataUrl);
		LOGGER.debug("fetchUserMetaData Url:::::::::::>>>>>>>>>" + userMetaDataUrl + ":::::::Response::::::::::"
				+ userMetaDataResponse);
		return CustomObjectMapperUtil.readValue(userMetaDataResponse, UserMetadataItem.class);
	}

	public List<EducationDetail> getEducationDetailList(ThemeDisplay themeDisplay, long personId) {
		try {
			EducationDetailItem educationalDetailItem = fetchEducationDetailByPersonId(themeDisplay, personId);
			if (Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size() > 0) {
				LOGGER.debug("educationalDetail ::::::::::::::::::" + educationalDetailItem.getItems().get(0).getPersonId());

				List<EducationDetail> educationalDetailItemList = educationalDetailItem.getItems();

				for (EducationDetail detail : educationalDetailItemList) {

					if (Validator.isNotNull(detail.getQualificationAttained())) {

						try {

							detail.setQualificationAttained(commonApi
									.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION,
											detail.getQualificationAttained(), themeDisplay.getCompanyId())
									.getName(themeDisplay.getLocale()));

						}

						catch (Exception e) {

							LOGGER.error("unable to get the List type entry " + e.getMessage());

						}

					}

					if (Validator.isNotNull(detail.getIssuingAuthorityName())) {

						try {

							detail.setIssuingAuthorityName(commonApi
									.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION,
											detail.getIssuingAuthorityName(), themeDisplay.getCompanyId())
									.getName(themeDisplay.getLocale()));

						} catch (Exception e) {

							LOGGER.error("unable to get the List type entry " + e.getMessage());

						}

					}

					if (Validator.isNotNull(detail.getIssuingAuthorityCountryId())) {

						com.liferay.portal.kernel.model.Country issuingCountry = null;

						try {

							issuingCountry = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());

							detail.setIssuingAuthorityCountry(issuingCountry.getName(themeDisplay.getLocale()));

						} catch (PortalException e1) {

							LOGGER.debug(
									"unable to get the country by country id :" + detail.getIssuingAuthorityCountry());

						}

						// Country country =
						// registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(),
						// detail.getIssuingAuthorityCountryId());

						//                    	if(Validator.isNotNull(country)) {

						//                        	detail.setIssuingAuthorityCountry(country.getNationality());

						//                    	}

					}

				}

				LOGGER.debug("educationalDetailItemList ::::" + educationalDetailItemList.size());

				LOGGER.debug("educationalDetailItemList ::::"
						+ educationalDetailItemList.get(0).getIssuingAuthorityCountryId());

				return educationalDetailItemList;

			}

		} catch (UnsupportedEncodingException e) {

			LOGGER.error(e.getMessage());

		}

		return null;

	}

	public EducationDetail getEducationDetailbyId(String portalURL, long id) {

		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_EDUCATION_DETAIL_URL

				+ id);

		return getItems(sbURL.toString(), EducationDetail.class);

	}

	public void setVerificationEducationDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			EducationDetailItem educationalDetailItem = fetchEducationDetailByPersonId(themeDisplay,
					ParamUtil.getLong(resourceRequest, "personId"));

			if (Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size() > 0) {

				//	LOGGER.info("educationalDetail ::::::::::::::::::" + educationalDetailItem.getItems().get(0).getPersonId());

				List<EducationDetail> educationalDetailItemList = educationalDetailItem.getItems();

				for (EducationDetail detail : educationalDetailItemList) {

					if (Validator.isNotNull(detail.getQualificationAttained())) {
						try {
							detail.setQualificationAttained(commonApi
									.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION,
											detail.getQualificationAttained(), themeDisplay.getCompanyId())
									.getName(themeDisplay.getLocale()));
						}
						catch(Exception e) {
							LOGGER.error(e.getMessage());
						} 
					}

					if (Validator.isNotNull(detail.getIssuingAuthorityName())) {
						try {
							detail.setIssuingAuthorityName(commonApi
									.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION,
											detail.getIssuingAuthorityName(), themeDisplay.getCompanyId())
									.getName(themeDisplay.getLocale()));
						}
						catch(Exception e) {
							LOGGER.error(e.getMessage());
						}

					}

					if (Validator.isNotNull(detail.getIssuingAuthorityCountryId())) {

						// Country country = getCustomCountryById(themeDisplay.getPortalURL(),
						// detail.getIssuingAuthorityCountryId());

						//                    	CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId())

						//                    	if(Validator.isNotNull(country)) {

						//                        	detail.setIssuingAuthorityCountry(country.getNationality());

						//                    	}

						com.liferay.portal.kernel.model.Country country = null;

						try {

							country = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());

							detail.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));

						} catch (PortalException e) {

							LOGGER.error("unable to get the country having id :: "
									+ detail.getIssuingAuthorityCountryId() + " :::: " + e.getMessage());

						}

					}

				}

				LOGGER.info("educationalDetailItemList ::::" + educationalDetailItemList.size());

				LOGGER.info("educationalDetailItemList ::::"
						+ educationalDetailItemList.get(0).getIssuingAuthorityCountryId());

				resourceRequest.setAttribute("educationalDetailItemList", educationalDetailItemList);

			}

		} catch (UnsupportedEncodingException e) {

			LOGGER.error(e.getMessage());

		}

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()

				.getRequestDispatcher("/jsps/admin/education-verification-details-list.jsp");

		try {

			dispatcher.include(resourceRequest, resourceResponse);

		} catch (PortletException | IOException e) {

			LOGGER.error(e.getMessage(), e);

		}

	}

	public EmploymentDetail getEmploymentDetailById(String portalURL, long id) {

		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_EMPLOYMENT_DETAIL_URL + id);

		return getItems(sbURL.toString(), EmploymentDetail.class);

	}

	public void setVerificationSWorkDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long personId = ParamUtil.getLong(resourceRequest, "personId");

			LOGGER.info("inside view get work details ");

			EmploymentDetailItem employmentDetailItem = null;

			try {
				employmentDetailItem = getWorkDetailsByPersonId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), personId);
				//employmentDetailItem = getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), personId, "0");

			} catch (Exception e) {

				LOGGER.error("Exception in code :::" + e.getMessage());

			}

			if (Validator.isNotNull(employmentDetailItem) && Validator.isNotNull(employmentDetailItem.getItems())
					&& employmentDetailItem.getItems().size() > 0) {

				List<EmploymentDetail> employmentDetailList = employmentDetailItem.getItems();

				if (Validator.isNotNull(employmentDetailList) && employmentDetailList.size() > 0) {

					for (EmploymentDetail employmentDetail : employmentDetailList) {

						LOGGER.info("employmentDetail 1::: " + employmentDetail.getWorkSectorType());

						ListTypeEntry listTypeEntry = null;

						long workSectorTypeID = Long.parseLong(employmentDetail.getWorkSectorType());

						try {

							listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);

						} catch (PortalException e) {

							LOGGER.error("Exception in code :::" + e.getMessage());

						}

						// Get Work Sector Type

						if (Validator.isNotNull(employmentDetail.getWorkSectorTypeOther())) {

							employmentDetail.setWorkSectorType(employmentDetail.getWorkSectorTypeOther());

						} else {

							employmentDetail.setWorkSectorType(
									Validator.isNotNull(listTypeEntry) ? listTypeEntry.getName(themeDisplay.getLocale())
											: StringPool.BLANK);

						}

						WorkSector workSector = null;

						// Getting Work Sector

						if (Validator.isNotNull(employmentDetail.getWorkSectorOther3())) {

							employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther3());

						} else if (Validator.isNotNull(employmentDetail.getWorkSectorId3())
								&& employmentDetail.getWorkSectorId3() > 0) {

							try {

								workSector = getWorkSectorById(themeDisplay.getPortalURL(),
										employmentDetail.getWorkSectorId3());

							} catch (Exception e) {

								LOGGER.error("Exception in code :::" + e.getMessage());

							}

							if (Validator.isNotNull(workSector)) {

								employmentDetail.setWorkSector(workSector.getWorkSector());

							}

						} else if (Validator.isNotNull(employmentDetail.getWorkSectorOther2())) {

							employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther2());

						} else if (Validator.isNotNull(employmentDetail.getWorkSectorId2())
								&& employmentDetail.getWorkSectorId2() > 0) {

							try {

								workSector = getWorkSectorById(themeDisplay.getPortalURL(),
										employmentDetail.getWorkSectorId2());

							} catch (Exception e) {

								LOGGER.error("Exception in code :::" + e.getMessage());

							}

							if (Validator.isNotNull(workSector)) {

								employmentDetail.setWorkSector(workSector.getWorkSector());

							}

						} else if (Validator.isNotNull(employmentDetail.getWorkSectorOther())) {

							employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther());

						} else if (Validator.isNotNull(employmentDetail.getWorkSectorId())
								&& employmentDetail.getWorkSectorId() > 0) {

							try {

								workSector = getWorkSectorById(themeDisplay.getPortalURL(),
										employmentDetail.getWorkSectorId());

							} catch (Exception e) {

								LOGGER.error("Exception in code :::" + e.getMessage());

							}

							if (Validator.isNotNull(workSector)) {

								employmentDetail.setWorkSector(workSector.getWorkSector());

							}

						}

						if (Validator.isNotNull(employmentDetail.getDesignationOther())) {

							employmentDetail.setDesignationId(employmentDetail.getDesignationOther());

						} else {

							try {

								employmentDetail.setDesignationId(commonApi
										.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION,
												employmentDetail.getDesignationId(), themeDisplay.getCompanyId())
										.getName(themeDisplay.getLocale()));

							} catch (Exception e) {

								LOGGER.error("Exception ::" + e.getMessage());

							}

						}

						try {

							employmentDetail.setWorkSectorLocation(commonApi
									.getListTypeEntryByListTypeItemKey(LRPicklistConstants.GOVERNORATE,
											employmentDetail.getWorkSectorLocation(), themeDisplay.getCompanyId())
									.getName(themeDisplay.getLocale()));

						} catch (Exception e) {

							LOGGER.error("Exception ::" + e.getMessage());

						}

						// employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION,
						// employmentDetail.getDesignationId(),
						// themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));

					}

				}

				resourceRequest.setAttribute("workDetailItems", employmentDetailItem);

			}

		} catch (Exception e) {

			LOGGER.error(e.getMessage());

		}

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()

				.getRequestDispatcher("/jsps/admin/work-verification-details-list.jsp");

		try {

			dispatcher.include(resourceRequest, resourceResponse);

		} catch (PortletException | IOException e) {

			LOGGER.error(e.getMessage(), e);

		}

	}

	public UserRegistrationStatusItems getRegistrationStatusByPersonId(String portalURL, long scopeGroupId, long personId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_PROFILE_STATUS 
				+ CommonConstants.SCOPES + StringPool.SLASH + scopeGroupId);
		if (personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		sbURL.append("&sort=dateModified:desc&pageSize=0");

		LOGGER.info("sbURL :::" +sbURL);

		return getItems(sbURL.toString(), UserRegistrationStatusItems.class);
	}

	public ServicesItem getServices(String portalURL,long groupId) {
		StringBuilder sbURL = new StringBuilder(
				portalURL +MVCCommands.SERVICE_URL + groupId);
		LOGGER.info("url::get Work Sector:::::" + sbURL);                
		return getItems(sbURL.toString()+ "?sort=id:desc&pageSize=0", ServicesItem.class);
	}  

	//	Tab functionality

	public Registration getRegistrationDTO(ResourceRequest actionRequest, ThemeDisplay themeDisplay) {

		Registration registration = new Registration();
		registration.setPersonId(ParamUtil.getLong(actionRequest, "personId"));
		registration.setCivilId(ParamUtil.getString(actionRequest, "civilId").trim());
		LOGGER.info("Date of Birth ::: "+ParamUtil.getString(actionRequest, "dateOfBirth"));
		LOGGER.info("passport ::: "+ParamUtil.getString(actionRequest, "passportExpiryDate").trim());
		registration.setDateOfBirth(commonApi.convertNewDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "dateOfBirth").trim()));
		registration.setPassportNo(ParamUtil.getString(actionRequest, "passportNumber").trim());
		registration.setCountryIdOfIssue(ParamUtil.getLong(actionRequest, "countryOfIssue"));

		registration.setPassportExpiryDate(Validator.isNotNull(ParamUtil.getString(actionRequest, "passportExpiryDate"))?commonApi.convertNewDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "passportExpiryDate").trim()):null);
		registration.setFirstName(ParamUtil.getString(actionRequest, "firstName").trim());
		registration.setLastName(ParamUtil.getString(actionRequest, "lastName").trim());
		registration.setFullName(ParamUtil.getString(actionRequest, "fullName").trim());
		registration.setFullNameAr(ParamUtil.getString(actionRequest, "fullNameAr").trim());
		String givenNameAsPassport=StringPool.BLANK;
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "firstName").trim())) {
			givenNameAsPassport=ParamUtil.getString(actionRequest, "firstName").trim();
		} else {
			givenNameAsPassport=ParamUtil.getString(actionRequest, "fullName").trim();
		}
		registration.setGivenNameAsPassport(givenNameAsPassport);
		registration.setEmailAddress(ParamUtil.getString(actionRequest, "emailAddress").trim());
		registration.setMobileNumber(ParamUtil.getString(actionRequest, "mobileNumber").trim());
		registration.setGenderId(ParamUtil.getLong(actionRequest, "gender"));
		registration.setNationalityId(ParamUtil.getLong(actionRequest, "nationality"));
		// registration.setProfession(ParamUtil.getString(actionRequest, "profession").trim());
		registration.setProfessionOther(ParamUtil.getString(actionRequest, "professionOther").trim());
		registration.setPrimarySpecialityOther(ParamUtil.getString(actionRequest, "PrimarySpecialityOther").trim());
		registration.setSecondarySpecialityOther(ParamUtil.getString(actionRequest, "secondarySpecialityOther").trim());

		try {
			ListTypeEntry profession = commonApi.getListTypeEntryBylistTypeEntryId(ParamUtil.getLong(actionRequest, "profession"));
			registration.setProfession(profession.getKey());
			ListTypeEntry primaryEntry = commonApi.getListTypeEntryBylistTypeEntryId(ParamUtil.getLong(actionRequest, "primarySpeciality"));
			registration.setPrimarySpeciality(primaryEntry.getKey());
			ListTypeEntry secondaryEntry = commonApi.getListTypeEntryBylistTypeEntryId(ParamUtil.getLong(actionRequest, "secondarySpeciality"));
			registration.setSecondarySpeciality(secondaryEntry.getKey());
		} catch(Exception e) {
			LOGGER.info("unable to get the ListTypeEntry : "+e.getMessage());
		}
		registration.setPrimarySpeciality(ParamUtil.getString(actionRequest, "primarySpeciality").trim());
		registration.setSecondarySpeciality(ParamUtil.getString(actionRequest, "secondarySpeciality").trim());
		registration.setUserName(ParamUtil.getString(actionRequest, "userName").trim());
		// registration.setPassword(ParamUtil.getString(actionRequest, "password").trim());
		// registration.setReTypePassword(ParamUtil.getString(actionRequest, "reTypePassword").trim());
		registration.setEmailAddressVerified(ParamUtil.getBoolean(actionRequest, "emailAddressOTPVerified"));
		registration.setMobileNumberVerified(ParamUtil.getBoolean(actionRequest, "mobileNumberOTPVerified"));

		registration.setCountryCode(ParamUtil.getString(actionRequest, "countryCode").trim());
		registration.setCountryIsoCode(ParamUtil.getString(actionRequest, "countryIsoCode").trim());

		registration.setLrUserId(ParamUtil.getLong(actionRequest, "lrUserId"));

		if(themeDisplay.isSignedIn()) {
			registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.REGISTRATION_SOURCE_ADMIN);
		} else {
			registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.REGISTRATION_SOURCE_USER);
		}
		boolean isMyProfile=ParamUtil.getBoolean(actionRequest, "isMyProfile");
		LOGGER.info("isMyProfile " +isMyProfile);
		if(!isMyProfile) {
			FileEntry photoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.PHOTO_FOLDERNAME, "photo");
			if (Validator.isNotNull(photoFileEntry)) {
				registration.setPhotoId(photoFileEntry.getFileEntryId());
			}
		}
		FileEntry civilCardFrontPhotoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CIVIL_CARD_PHOTO_FOLDERNAME, "civilCardFrontPhoto");
		if (Validator.isNotNull(civilCardFrontPhotoFileEntry)) {
			registration.setCivilCardFrontPhotoId(civilCardFrontPhotoFileEntry.getFileEntryId());
		}

		FileEntry civilCardBackPhotoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CIVIL_CARD_PHOTO_FOLDERNAME, "civilCardBackPhoto");
		if (Validator.isNotNull(civilCardBackPhotoFileEntry)) {
			registration.setCivilCardBackPhotoId(civilCardBackPhotoFileEntry.getFileEntryId());
		}

		FileEntry passportPhotoFileEntry = fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.PASSPORT_PHOTO_FOLDERNAME, "passportPhoto");
		if (Validator.isNotNull(passportPhotoFileEntry)) {
			registration.setPassportPhotoId(passportPhotoFileEntry.getFileEntryId());
		}
		FileEntry cvDocumentFileEntry=fileUpload(actionRequest, themeDisplay, OmsbRegistrationWebPortletKeys.PHOTO_FOLDERNAME, "cvDocument");
		LOGGER.info("fileEntryyy id : "+cvDocumentFileEntry);
		if (Validator.isNotNull(cvDocumentFileEntry)) {
			registration.setCvDocumentId(cvDocumentFileEntry.getFileEntryId());
		}
		//}
		boolean isProfileApprover=false;
		boolean isRoleApprover=false;
		// boolean isServiceApprover=false;
		try {
			isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
		} catch (PortalException e1) {
			LOGGER.error("Exception ::" +e1.getMessage());
		}

		try {
			isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
		} catch (PortalException e2) {
			LOGGER.error("Exception ::" +e2.getMessage());
		}
		// try {
		// isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
		// } catch (PortalException e1) {
		// LOGGER.error("Exception ::" +e1.getMessage());
		// }

		boolean isAdmin =getAdmin(themeDisplay.getCompanyId()).getUserId()==themeDisplay.getUserId()?true :false;
		if(themeDisplay.isSignedIn() && (isAdmin ||isRoleApprover || isProfileApprover)) {
			String generatedPassword=generateRandomPassword(8);
			LOGGER.info("generatedPassword : : : :"+generatedPassword);
			registration.setPassword(generatedPassword);
			registration.setReTypePassword(generatedPassword);
		} else {
			registration.setPassword(ParamUtil.getString(actionRequest, "password").trim());
			registration.setReTypePassword(ParamUtil.getString(actionRequest, "reTypePassword").trim());
		}
		return registration;
	}

	public Registration saveRegistration(ResourceRequest  actionRequest, Registration registration) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			LocalDate localDate = commonApi.convertObjectStringDateToDate(registration.getDateOfBirth()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LOGGER.debug("DateOfBirth Year : "+localDate.getYear()+" Month : "+localDate.getMonthValue()+" Day : "+localDate.getDayOfMonth());

			Role adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
			User user = null;
			if(Validator.isNotNull(registration.getCivilId()) && Validator.isNull(registration.getFirstName()) && Validator.isNull(registration.getLastName()) && Validator.isNotNull(registration.getFullName())) {
				String[] fullName = registration.getFullName().split("\\s",2);  
				if(fullName.length==2) {
					registration.setFirstName(fullName[0]);
					registration.setLastName(fullName[1]);
				} else if(fullName.length<2) {
					registration.setFirstName(fullName[0]);
					registration.setLastName(fullName[0]);
				}
			}
			if (Validator.isNull(registration.getLrUserId())) {
				try {
					user = _userService.addUserWithWorkflow(themeDisplay.getCompanyId(), Boolean.FALSE,
							registration.getPassword(), registration.getPassword(), Boolean.FALSE,
							registration.getUserName(), registration.getEmailAddress(), themeDisplay.getLocale(),
							registration.getFirstName(), StringPool.BLANK, registration.getLastName(), 0, 0,
							((registration.getGenderId() == 1) ? Boolean.TRUE : Boolean.FALSE), localDate.getMonthValue(),
							localDate.getDayOfMonth(), localDate.getYear(), StringPool.BLANK, null, null, null, null,
							Boolean.FALSE, serviceContext);
					user.setStatus(WorkflowConstants.STATUS_INACTIVE);
					user.setPasswordReset(false);
				} catch(Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			} else {
				user = _userService.getUserById(registration.getLrUserId());
				user.setScreenName(registration.getUserName());
				user.setFirstName(registration.getFirstName());
				user.setLastName(registration.getLastName());
				if(!user.getEmailAddress().equalsIgnoreCase(registration.getEmailAddress())) {
					user.setEmailAddress(registration.getEmailAddress());
				}
			}
			user.setEmailAddressVerified(registration.isEmailAddressVerified());
			if (registration.getPhotoId() != 0) {
				if(user.getPortraitId()!=0) {
					DLAppServiceUtil.deleteFileEntry(user.getPortraitId());
				}
				user.setPortraitId(registration.getPhotoId());
			}
			user = UserLocalServiceUtil.updateUser(user);
			registration.setLrUserId(user.getUserId());
			Person person = getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getPersonId());
			person.setLrUserId(user.getUserId());
			if(Validator.isNull(person.getPassportNumber())) {
				person.setPassportNumber(registration.getPassportNo());
			}
			if(Validator.isNull(person.getCivilId())) {
				person.setCivilId(registration.getCivilId());
			}
			savePersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person);

			addUpdatePersonalDetails(themeDisplay, registration);

		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return registration;
	}

	public FileEntry fileUpload(ResourceRequest actionRequest, ThemeDisplay themeDisplay, String foldeName, String fileName) {

		try {
			Role adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = getAdmin(PortalUtil.getDefaultCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			LOGGER.info("inside ---fileName :"+fileName);
			File file = uploadPortletRequest.getFile(fileName);
			LOGGER.info("inside 1 file---"+file);
			if(Validator.isNotNull(file)) {
				Folder folder = null;
				try {
					folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, foldeName);
				} catch (Exception e) {
					folder = DLAppServiceUtil.addFolder(null, themeDisplay.getScopeGroupId(),
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, foldeName,
							foldeName, serviceContext);
				}
				return DLAppServiceUtil.addFileEntry(null, themeDisplay.getScopeGroupId(), folder.getFolderId(),
						StringUtil.randomString()+uploadPortletRequest.getFileName(fileName) ,
						uploadPortletRequest.getContentType(fileName),
						StringUtil.randomString() + fileName ,
						StringUtil.randomString() +uploadPortletRequest.getFileName(fileName),
						uploadPortletRequest.getFileName(fileName), "", new FileInputStream(file), file.length(), null, null,
						serviceContext);
			}
		} catch (PortalException | FileNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	public EmploymentDetail saveEmploymentDetail(ResourceRequest actionRequest, EmploymentDetail employmentDetail,
			UploadPortletRequest uploadPortletRequest, long groupId, ThemeDisplay themeDisplay, long personId,
			long lrUserId, long employed) {
		File file;

		LOGGER.info("employed ::::"+employed);


		if (employed == 1) {
			for (int i = 1; i <= 2; i++) {

				String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
				String worksectortypeother = ParamUtil.getString(actionRequest, "worksectortypeother_" + i);
				long workSector = ParamUtil.getLong(actionRequest, "worksector_" + i);
				String worksectorother = ParamUtil.getString(actionRequest, "worksectorother_" + i);
				long firstsubworksector = ParamUtil.getLong(actionRequest, "first-sub-worksector_" + i);
				String worksubsectorother = ParamUtil.getString(actionRequest, "work_sub_sectorother_" + i);


				//Third Level
				long secondSubWorksector = ParamUtil.getLong(actionRequest, "second-sub-worksector_" + i);
				String worksecondsectorother = ParamUtil.getString(actionRequest, "work_second_sub_sectorother_" + i);


				LOGGER.info("secondSubWorksector ::: "+i+" :::"+secondSubWorksector);
				LOGGER.info("worksecondsectorother ::: "+i+" :::"+worksecondsectorother);
				LOGGER.info("workSectorType ::: "+i+" :::"+workSectorType);
				LOGGER.info("workSector ::: "+i+" :::"+workSector);
				LOGGER.info("worksectorother ::: "+i+" :::"+worksectorother);
				LOGGER.info("firstsubworksector ::: "+i+" :::"+firstsubworksector);
				LOGGER.info("worksubsectorother ::: "+i+" :::"+worksubsectorother);


				ListTypeEntry listTypeEntry =null;
				if(Validator.isNotNull(workSectorType)) {
					long workSectorTypeID=Long.parseLong(workSectorType);
					try {
						listTypeEntry =ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
					} catch (PortalException e) {
						LOGGER.error("Exception ::"+e.getMessage());
					}
					LOGGER.info("listTypeEntry ::: " +listTypeEntry);
					LOGGER.info("listTypeEntry key ::: " +listTypeEntry.getKey());
					LOGGER.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
				}


				if(Validator.isNotNull(firstsubworksector) && firstsubworksector>0) {
					worksubsectorother=StringPool.BLANK;

				}

				LOGGER.info("workSectorType :::"+workSectorType);
				LOGGER.info("worksectortypeother :::"+worksectortypeother);
				LOGGER.info("workSector :::"+workSector);
				LOGGER.info("worksectorother :::"+worksectorother);
				LOGGER.info("firstsubworksector :::"+firstsubworksector);
				LOGGER.info("worksubsectorother :::"+worksubsectorother);

				//String workSectorType = ParamUtil.getString(actionRequest, "workSectorType_" + i);
				//String workSector = ParamUtil.getString(actionRequest, "worksector_" + i);
				//String workSectorOther = ParamUtil.getString(actionRequest, "worksectorother_" + i);

				if(Validator.isNotNull(listTypeEntry)) {
					if(!listTypeEntry.getKey().equalsIgnoreCase("others")) {
						worksectortypeother=StringPool.BLANK;
					}else {
						workSector=0;
						firstsubworksector=0;
						worksectorother=StringPool.BLANK;
						worksubsectorother=StringPool.BLANK;


						secondSubWorksector=0;
						worksecondsectorother=StringPool.BLANK;
					}
				}
				if(workSector==0 && Validator.isNotNull(worksectorother)) {
					firstsubworksector=0;
					worksubsectorother=StringPool.BLANK;

					secondSubWorksector=0;
					worksecondsectorother=StringPool.BLANK;
				}


				if(firstsubworksector==0 && Validator.isNotNull(worksubsectorother)) {
					secondSubWorksector=0;
					worksecondsectorother=StringPool.BLANK;
				}

				String wilayat = ParamUtil.getString(actionRequest, "wilayats_" + i);
				String designation = ParamUtil.getString(actionRequest, "designations_" + i);
				String designationother = ParamUtil.getString(actionRequest, "designationother_" + i);
				Boolean isPrimaryWorkDetail = ParamUtil.getBoolean(actionRequest, "isPrimary_" + i);

				long id = ParamUtil.getLong(actionRequest, "id_" + i);
				file = uploadPortletRequest.getFile("staffIdCard_" + i);
				String fileName = uploadPortletRequest.getFileName("staffIdCard_" + i);

				String mimeType = uploadPortletRequest.getContentType("staffIdCard_" + i);
				long uploadFileId = ParamUtil.getLong(actionRequest, "uploadFile_" + i);
				String fileEntryId = Validator.isNotNull(uploadFileId) ? String.valueOf(uploadFileId): StringPool.BLANK;

				String primaryWorkDetail="1";

				LOGGER.info("id ::::"+id);
				LOGGER.info("isPrimaryWorkDetail ::: " + isPrimaryWorkDetail + " id :: " +
						id + " personId : " + personId + " lrUserId : " + lrUserId + " employed " +
						employed + " workSectorType : " + workSectorType + " workSector : " +
						workSector + " workSectorOther : " + worksectorother + " wilayat :: " +
						wilayat + "  designation  : " + designationother + " fileName :: " + fileName
						+ " designation :: " + designation);

				if(isPrimaryWorkDetail) {
					primaryWorkDetail="1";
				}else {
					primaryWorkDetail="2";
				}



				if (Validator.isNotNull(id)) {
					LOGGER.info("inside if condition");
					Map<String, String> headers =commonApi.getHttpHeaderInfoAndBasicAuth();
					String url =themeDisplay.getPortalURL() + LRObjectURL.REG_EMPLOYMENT_DETAIL_URL + id;
					LOGGER.info("url : " + url);
					httpConnector.executeDelete(url, headers);
					//LOGGER.info("Document documentInfoId Deleted ::::::" + data);
				}

				//Adding New Record
				if (Validator.isNotNull(workSectorType) || Validator.isNotNull(workSector) || Validator.isNotNull(designation)) {

					if(Validator.isNotNull(fileName)) {
						fileEntryId =uploadFileByGuest(themeDisplay, groupId, personId,DataflowConstants.EMPLOYMENT_COMPONENT_KEY, file, fileName);
						LOGGER.info("fileEntryId : " + fileEntryId);
					}

					employmentDetail = setWorkDetailNew(lrUserId, themeDisplay, workSectorType,workSector, worksectorother, wilayat, designation, designationother,
							fileEntryId, personId,primaryWorkDetail,worksectortypeother,firstsubworksector,worksubsectorother,secondSubWorksector,worksecondsectorother);
					LOGGER.debug("employmentDetail :::::::::::::::::::::"+employmentDetail);
				}
			}




		}

		if (employed == 0) {
			EmploymentDetailItem employmentDetailItem = getWorkDetailsByPersonId(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId(), personId);
			if (Validator.isNotNull(employmentDetailItem) && employmentDetailItem.getItems().size() > 0) {
				for (EmploymentDetail detail : employmentDetailItem.getItems()) {
					deleteWorkDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), detail.getId());
				}
			}
		}

		return employmentDetail;
	}
	public void addRole(ThemeDisplay themeDisplay, String roleId, long userId, User regUSer,ResourceRequest actionRequest) throws PortalException {
		String index=ParamUtil.getString(actionRequest, "index");
		String departmentId=ParamUtil.getString(actionRequest, "department_"+index);
		String sectionId=ParamUtil.getString(actionRequest, "section_"+index);
		String functionId=ParamUtil.getString(actionRequest, "function_"+index);

		boolean associated = ParamUtil.getBoolean(actionRequest, "associated");
		boolean registringForRole = ParamUtil.getBoolean(actionRequest, "registering");
		boolean requestForService = ParamUtil.getBoolean(actionRequest, "requestForService");
		LOGGER.info("departmentId :::" +departmentId );
		LOGGER.info("sectionId :::" +sectionId );
		LOGGER.info("functionId :::" +functionId );
		LOGGER.info("associated :::" +associated );
		LOGGER.info("registringForRole :::" +registringForRole );
		LOGGER.info("requestForService :::" +requestForService );

		try {
			List<Role> roleList =new ArrayList<>();
			Role powerUserRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.POWER_USER);
			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			if(requestForService) {
				Role healthCareProf = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.HEALTH_CARE_PROFESSIONAL);
				Role octApplicant = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EXAM_APPLICANT);

				if(Validator.isNotNull(healthCareProf)) {
					roleList.add(healthCareProf);
				}

				if(Validator.isNotNull(octApplicant)) {
					roleList.add(octApplicant);
				}


			}

			//	Role employeeRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EMPLOYEE);
			//UserLocalServiceUtil.addRoleUser(role.getRoleId(), regUSer.getUserId());

			roleList.add(powerUserRole);
			roleList.add(guestRole);
			//	roleList.add(employeeRole);

			//Section 
			//verificationAndEquivalencyOfHealthProfessionalsCertificatesSection
			//verificationEquivalencyOfHealthSection


			//Function 
			//verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist
			//verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist
			/*if(Validator.isNotNull(roleId)) {
				  long employerRoleId=Long.parseLong(roleId);
				  Role requestedRole=RoleLocalServiceUtil.getRole(employerRoleId);
				  if(departmentId.equalsIgnoreCase("professionalCompetenceDepartment") && 
						  sectionId.equalsIgnoreCase("verificationEquivalencyOfHealthSection") &&
						  functionId.equalsIgnoreCase("verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist")) {
					  Role toRequestedRole=null;

					  if(requestedRole.getName().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.ROLE_AUTHORIZED_USER_FROM_MEDICAL_INSTITUTIONS)) {
						  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), OmsbRegistrationWebPortletKeys.ROLE_EMPLOYER);
					  }else if(requestedRole.getName().equalsIgnoreCase("Staff")) {
						  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.VEHPC_ADMIN);
					  }else if(requestedRole.getName().equalsIgnoreCase("Committee member")) {
						  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.VEHPC_COMMITTEE);
					  }else {
						  toRequestedRole=requestedRole;
					  }
					  roleList.add(toRequestedRole);
				  }
			}else {
				LOGGER.info("Another role:::");
			}*/


			LOGGER.info("roleList ::::" +roleList);
			RoleLocalServiceUtil.addUserRoles(regUSer.getUserId(), roleList);
			UserLocalServiceUtil.updateUser(regUSer);
			LOGGER.info("Role Added: ");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}
	public EducationDetailItem fetchEducationDetailByLrUserId(ThemeDisplay themeDisplay, long lrUserId) {
		try {
			String educationDetailUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.REG_EDUCATION_DETAIL_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
					+ StringPool.QUESTION + "filter=lRUserId" + URLEncoder.encode(" eq " + lrUserId, DataflowConstants.UTF_8);
			String educationDetailResponse = commonApi.getData(educationDetailUrl);
			LOGGER.debug(educationDetailUrl + " ::fetchPersonalDetailsByLrUserID :::personDetailsResponse:::::"
					+ educationDetailResponse);
			if(Validator.isNotNull(educationDetailResponse)) {
				EducationDetailItem educationalDetailItem=CustomObjectMapperUtil.readValue(educationDetailResponse, EducationDetailItem.class);
				if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {

					fetchDocumentInfobyPersonId(themeDisplay, educationalDetailItem, educationalDetailItem.getItems().get(0).getPersonId());

				}			
				return educationalDetailItem;
			}
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		}
		return null;
	}
	public EmploymentDetailItem getWorkDetailsByLrUserIdAndWorkDetailType(String portalURL,long groupId,long lrUserId,String isPrimaryWorkDetail) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + groupId);
		if(Validator.isNotNull(lrUserId)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=lRUserId"
						+ URLEncoder.encode(" eq " + lrUserId + " and primaryWorkDetail eq '"+isPrimaryWorkDetail+"'", DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("url::get Work Details:::::" + sbURL);		
		return getItems(sbURL.toString(), EmploymentDetailItem.class);
	} 
	public Person addPersonData(String portalURL, long groupId, String civilId, String passportNumber, String dob) {

		Person	person = new Person();
		person.setCivilId(civilId);
		person.setDateOfBirth((Validator.isNotNull(dob) ? commonApi.convertNewDDMMYYYYDateToObjectDate(dob) : null));
		person.setPassportNumber(passportNumber);
		person = savePersonData(portalURL, groupId, person);
		LOGGER.info("inside eellse:"+person.getId());

		return person;
	}
	
	public UserRegistrationStatusItems getRoleStatusByUserMetadataId(String portalURL, long scopeGroupId, long userMetaDataId) {
		LOGGER.info("entry into getRoleStatusByUserMetadataId ::");
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_ROLE_STATUS 
				+ CommonConstants.SCOPES + StringPool.SLASH + scopeGroupId);
		if (userMetaDataId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=userMetaDataId"
						+ URLEncoder.encode(" eq " + userMetaDataId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		sbURL.append("&sort=dateModified:desc&pageSize=0");

		LOGGER.info("getRoleStatusByUserMetadataId :::" +sbURL);

		return getItems(sbURL.toString(), UserRegistrationStatusItems.class);
	}	
	
	
	public UserRegistrationStatusItems getRoleStatusByUserId(String portalURL, long groupId, long personId) {
		LOGGER.info("entry into getRoleStatusByUserId ::");
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_USER_ROLE_STATUS 
				+ CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (personId != 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		sbURL.append("&sort=dateModified:desc&pageSize=0");
		LOGGER.info("getRoleStatusByUserId :::" +sbURL);
		return getItems(sbURL.toString(), UserRegistrationStatusItems.class);
	}	
	
	
	
	
	

	@Reference(unbind = "_")
	private UserLocalService userService;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	@Reference
	private DLAppLocalService _dlAppLocalService;

	@Reference
	private UserService _userService;

	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;

	@Reference(unbind = "_")
	private RoleLocalService roleLocalService;


	private static final Log LOGGER = LogFactoryUtil.getLog(RegistrationUtil.class);
}