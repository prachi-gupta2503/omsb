package gov.omsb.faculty.membership.web.util;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Country;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.DocumentInfoItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.service.util.EducationDetailsUtil;
import gov.omsb.common.service.util.PersonUtil;
import gov.omsb.common.service.util.PersonalDetailUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.dto.CommentDetailsDTO;
import gov.omsb.faculty.membership.web.dto.EducationDetailsDTO;
import gov.omsb.faculty.membership.web.dto.ExistingAffiliationsDTO;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.model.FacultyType;
import gov.omsb.tms.service.FacultyTypeLocalServiceUtil;

@Component(immediate = true, service = FacultyMemebershipUtil.class)
public class FacultyMemebershipUtil {

	// get the object response using url and it's parameter like scoupid and filter
	public String generateObjectResponse(String requestsUrl, String requestParams) {
		String url = generateRequestURL(requestsUrl, requestParams);
		log.info("generated url -->  " + url);
		return omsbCommonApi.getData(url);
	}

	// generate url for requested object
	public String generateRequestURL(String requestsUrl, String requestParams) {
		return omsbCommonApi.getBaseURL() + requestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, requestParams);
	}

	// generate the file name
	public String generateFileName(String fileName) {
		if (Validator.isNotNull(fileName)) {
			Date d = new Date();
			String baseFileName = fileName.substring(0, fileName.lastIndexOf('.'));
			String extension = fileName.substring(fileName.lastIndexOf('.'));
			fileName = baseFileName + d.getTime() + extension;
		}
		return fileName;
	}

	// upload single file in document and media
	public FileEntry uploadSingleFile(long groupId, String fileName, String description, long userId,
			String contentType, File file) {
		DLFolder dLFolder1 = null;
		FileEntry fileEntry = null;
		ServiceContext serviceContext = new ServiceContext();
		try {
			DLFolder dLFolder = FileUploadUtil.getDLFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					FacultyMembershipConstants.DL_FOLDER_NAME);
			if (dLFolder == null) {
				dLFolder1 = FileUploadUtil.createDLFolder(groupId, FacultyMembershipConstants.DL_FOLDER_NAME, 0, userId,
						StringPool.BLANK);
				fileEntry = DLAppServiceUtil.addFileEntry(groupId, dLFolder1.getFolderId(), fileName, contentType,
						fileName, description, "", file, serviceContext);
			} else {
				fileEntry = DLAppServiceUtil.addFileEntry(groupId, dLFolder.getFolderId(), fileName, contentType,
						fileName, description, "", file, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileEntry;
	}

	public String getDobData(String dateOfBirth) {

		String formattedDateOfBirth = FacultyMembershipConstants.NOT_AVAILABLE;
		try {
			Date dob = new SimpleDateFormat(FacultyMembershipConstants.OBJECT_DATE_FORMAT).parse(dateOfBirth);
			SimpleDateFormat sdf = new SimpleDateFormat(FacultyMembershipConstants.DD_MM_YYYY);
			formattedDateOfBirth = sdf.format(dob);
		} catch (ParseException e) {
			log.error("Error while parsing dob string to date, " + e.getMessage());
		}
		return formattedDateOfBirth;

	}
	
	public EducationDetail addEducationDetails(ThemeDisplay themeDisplay, String title,
			String issuingAuthorityName, String gpa, long issuingAuthorityCountryId, long yearOfGraduation,
			long personId) {
		
		EducationDetail educationDetail = new EducationDetail();
		
		educationDetail.setIssuingAuthorityName(issuingAuthorityName);
		educationDetail.setGpa(gpa);
		educationDetail.setIssuingAuthorityCountryId((int)issuingAuthorityCountryId);
		educationDetail.setPersonId(personId);
		educationDetail.setQualificationAttained(title);
		educationDetail.setYearOfGraduation((int)yearOfGraduation);
		
		educationDetail = saveEducationDetails(educationDetail,themeDisplay.getScopeGroupId());
		
		return educationDetail;
		
	}
	
	public EducationDetail saveEducationDetails(EducationDetail educationDetail, long groupId) {
		
		String educationDetailUrl = generateScopeListURL(LRObjectURL.EDUCATION_DETAIL_URL, groupId);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String educationDetailMapper = CustomObjectMapperUtil.writeValueAsString(educationDetail, null);
		String response = httpConnector.executePost(educationDetailUrl, educationDetailMapper, headers);
		
		return CustomObjectMapperUtil.readValue(response, EducationDetail.class);
	}
	
	public DocumentInfo saveQalificationDocument(ThemeDisplay themeDisplay, String fileName, String documentType, long fileEntryId,
			long componentClassRefId) {
		
		DocumentInfo saveDocumentInfo = new DocumentInfo();
		saveDocumentInfo.setId(0);
		saveDocumentInfo.setdFFileName(fileName);
		saveDocumentInfo.setDocumentType(documentType);
		saveDocumentInfo.setFileEntryID(fileEntryId);
		saveDocumentInfo.setComponentClassRefId(componentClassRefId);
		
		DocumentInfo documentInfo= saveDocumentInfo(saveDocumentInfo, themeDisplay.getScopeGroupId());
		
		return documentInfo;
	}
	
	public DocumentInfo saveDocumentInfo(DocumentInfo documentInfoItem, long groupId) {
		
		String documentInfoUrl = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, groupId);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String documentDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
		String response = httpConnector.executePost(documentInfoUrl, documentDetailMapper, headers);
		
		return CustomObjectMapperUtil.readValue(response, DocumentInfo.class);
	}
	
	private String generateScopeListURL(String requestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + requestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}

	public Person getPersonByLrUserId(ThemeDisplay themeDisplay, long userId) {
		Person person = null;
		PersonItem personItem = personUtil.getPersonItemsByLrUserId(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), userId);
		if (Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems())) {
			List<Person> persons = personItem.getItems();
			log.info(" -> Person DTO List Size : " + persons.size());
			if (Validator.isNotNull(persons) && !persons.isEmpty()) {
				person = persons.get(0);
			}
		}
		return person;
	}

	public List<EducationDetail> getEducationDetailsByPersonId(ThemeDisplay themeDisplay, long personId) {

		List<EducationDetail> educationDetails = null;
		if (personId != 0) {
			EducationDetailItem educationDetailItem = educationDetailsUtil.getEducationDetailItemsByPersonId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId);
			if (Validator.isNotNull(educationDetailItem) && Validator.isNotNull(educationDetailItem.getItems())) {
				educationDetails = educationDetailItem.getItems();
			}
		}
		return educationDetails;

	}

	public PersonalDetail getPersonalDetailByPersonId(ThemeDisplay themeDisplay, long personId) {
		
		PersonalDetail personalDetail = null;		
		if(personId != 0) {
			PersonalDetailItem personalDetailItem = personalDetailUtil.getPersonalDetailItemsByPersonId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId);
			if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())) {
				List<PersonalDetail> personalDetails = personalDetailItem.getItems();
				log.info(" -> Personal Details List Size : " + personalDetails.size());
				if (Validator.isNotNull(personalDetails) && !personalDetails.isEmpty()) {
					personalDetail = personalDetails.get(0);
				}
			}
		}		
		return personalDetail;
		
	}

	public static String getFacultyRoleNameByFacultyTypeId(long facultyTypeId, ThemeDisplay themeDisplay) {

		String facultyRoleName = StringPool.BLANK;

		try {
			FacultyType facultyType = FacultyTypeLocalServiceUtil.getFacultyType(facultyTypeId);

			if (Validator.isNotNull(facultyType)) {
				if (FacultyMembershipConstants.ENGLISH_LANGUAGE_CODE.equalsIgnoreCase(themeDisplay.getLanguageId())) {
					facultyRoleName = facultyType.getNameEn();
				} else if (FacultyMembershipConstants.ARABIC_LANGUAGE_CODE
						.equalsIgnoreCase(themeDisplay.getLanguageId())) {
					facultyRoleName = facultyType.getNameAr();
				}
			}
		} catch (PortalException e) {
			log.error("Error while Fetching Faculty Role Name " + e.getMessage());
		}

		return facultyRoleName;

	}
	
	public List<ListTypeEntry> getInstitutions(ThemeDisplay themeDisplay) {
		List<ListTypeEntry> pickListEntries = null;
		try {
			pickListEntries = getPickListEntries(LRPicklistConstants.UNIVERSITY,
					themeDisplay.getCompanyId());			
		} catch (Exception e) {
			log.error("ERROR WHILE FETCHING INSTITUTIONS LIST");
		}
		return pickListEntries;
	}
	
	public List<Integer> getYears() {
		List<Integer> years = new ArrayList<Integer>();
		int endYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int year = FacultyMembershipConstants.START_YEAR; year <= endYear; year++){
		    years.add(year);
		}
		return years;
	}

	public String getQualificationTitle(String key, ThemeDisplay themeDisplay) {

		if (Validator.isNotNull(key)) {
			String qualificationAttained = null;
			try {
				qualificationAttained = omsbCommonApi
						.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, key,
								themeDisplay.getCompanyId())
						.getName(themeDisplay.getLocale());
			} catch (Exception e) {
				log.error(e.getMessage());
			}

			if (Validator.isNull(qualificationAttained)) {
				try {
					List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.QUALIFICATION,
							themeDisplay.getCompanyId());
					for (ListTypeEntry listTypeEntry : pickListEntries) {
						if (listTypeEntry.getKey().equals(key)) {
							return listTypeEntry.getName(themeDisplay.getLocale());
						}
					}
				} catch (Exception e) {
					// no need to handle..
				}
			} else {
				return qualificationAttained;
			}
		}

		return key;
	}

	public String getInstitutionName(String key, ThemeDisplay themeDisplay) {

		String authorityName = null;
		try {
			ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(Long.parseLong(key));
			authorityName = listTypeEntry.getName(themeDisplay.getLocale());
		} catch (Exception e) {
			log.error("unable to get the List type entry " + e.getMessage());
		}

		if (Validator.isNull(authorityName)) {
			try {
				List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.UNIVERSITY,
						themeDisplay.getCompanyId());
				for (ListTypeEntry listTypeEntry : pickListEntries) {
					if (listTypeEntry.getKey().equals(key)) {
						return listTypeEntry.getName(themeDisplay.getLocale());
					}
				}
			} catch (Exception e) {
				// no need to handle..
			}
		} else {
			return authorityName;
		}

		return key;
	}

	public String getCountryName(ThemeDisplay themeDisplay, long countryId) {

		String countryName = null;

		com.liferay.portal.kernel.model.Country country = null;
		try {
			country = CountryLocalServiceUtil.getCountry(countryId);
			countryName = country.getName(themeDisplay.getLocale());			
		} catch (PortalException e) {
			log.error("unable to get the country having id :: " + countryId + " :::: " + e.getMessage());
		}

		if (Validator.isNull(countryName)) {
			Country countryResponse = null;
			try {
				String url = themeDisplay.getPortalURL() + LRObjectURL.REG_CUSTOM_COUNTRY_URL + countryId;
				String customCuntryResponse = omsbCommonApi.getData(url);

				countryResponse = CustomObjectMapperUtil.readValue(customCuntryResponse, Country.class);
				if (Validator.isNotNull(countryResponse)) {
					countryName = countryResponse.getNationality();
				}
			} catch (NullPointerException e) {
				log.error(e.getMessage());
			}
		}

		return countryName;
	}

	public DocumentInfo getQualificationDocumentURL(ThemeDisplay themeDisplay, long educationDetailId) {

		String documentInfoUrl = null;
		DocumentInfo documentInfo = null;

		try {
			documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=componentClassRefId"
					+ URLEncoder.encode(" eq " + educationDetailId, DataflowConstants.UTF_8);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String documentInfoUrlResponse = omsbCommonApi.getData(documentInfoUrl);

		DocumentInfoItem documentInfoItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse,
				DocumentInfoItem.class);

		log.info("documentInfos.getItems().size() ::::" + documentInfoItems.getItems().size());

		if (Validator.isNotNull(documentInfoItems) && !documentInfoItems.getItems().isEmpty()) {
			documentInfo = documentInfoItems.getItems().get(0);
		}

		return documentInfo;
	}

	private static List<ListTypeEntry> getPickListEntries(String pickListName, long companyId) {
		try {
			return ListTypeEntryLocalServiceUtil.getListTypeEntries(ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId).getListTypeDefinitionId());
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	private static final Log log = LogFactoryUtil.getLog(FacultyMemebershipUtil.class);

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private PersonUtil personUtil;

	@Reference
	private EducationDetailsUtil educationDetailsUtil;

	@Reference
	private PersonalDetailUtil personalDetailUtil;
	
	@Reference
	private OMSBHttpConnector httpConnector;
	
}
