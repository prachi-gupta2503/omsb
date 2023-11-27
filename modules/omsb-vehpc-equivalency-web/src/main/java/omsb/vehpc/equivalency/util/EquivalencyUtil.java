package omsb.vehpc.equivalency.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.EquivalencyRequestStatusEnum;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.service.util.CaseDetailUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyCertificate;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyCertificateItems;
import omsb.vehpc.equivalency.dto.web.ByLawCondition;
import omsb.vehpc.equivalency.dto.web.ByLawRule;
import omsb.vehpc.equivalency.dto.web.ByLawRuleItems;
import omsb.vehpc.equivalency.dto.web.CaseReport;
import omsb.vehpc.equivalency.dto.web.CaseReportItems;
import omsb.vehpc.equivalency.dto.web.CustomCountryItemResponse;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.DocumentTypesItem;
import omsb.vehpc.equivalency.dto.web.EducationDetail;
import omsb.vehpc.equivalency.dto.web.EducationalDetail;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EmploymentDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentTypeItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatus;
import omsb.vehpc.equivalency.dto.web.EquivalencyStatus;
import omsb.vehpc.equivalency.dto.web.FileUploadDetail;
import omsb.vehpc.equivalency.dto.web.ProfessionSpecialtyMapping;
import omsb.vehpc.equivalency.dto.web.ProfessionSpecialtyMappingItems;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, service = EquivalencyUtil.class)
public class EquivalencyUtil {

	public EducationDetail addEducationDetail(long personId, long caseRequestId, EducationDetail educationDetailDTO,
			String caseNumber, long groupId) throws JSONException {
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		DateFormat dateFormat = new SimpleDateFormat(DataflowConstants.DF_DATE_FORMAT);
		String educationJson = CustomObjectMapperUtil.writeValueAsString(educationDetailDTO, dateFormat);
		LOGGER.info("educationJson ?? " + educationJson);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(educationJson);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		//String mosId = jsonObject.getString("modeOfStudyId");
		//jsonObject.put("mosId", caseDetailUtil.getLiferayModeOfStudyId(mosId));
		String qualificationDate = jsonObject.getString("qualificationConferredDate");
		LOGGER.info("qualificationDate ?? " + qualificationDate);
	//	jsonObject.put("qualificationConferredDate", caseDetailUtil.convertDateToObjectFormat(qualificationDate));
		String response = omsbHttpConnector.executePost(omsbCommonApi.getBaseURL() + LRObjectURL.EDUCATION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + groupId, jsonObject.toString(), headers);
		EducationDetail education = CustomObjectMapperUtil.readValue(response, EducationDetail.class);
		if (Validator.isNotNull(education)) {
			for (FileUploadDetail fileUpload : educationDetailDTO.getFileUploadDetails()) {
				caseDetailUtil.saveFileUploadDetail(caseNumber, String.valueOf(fileUpload.getDocId()),
						DataflowConstants.EDUCATION_COMPONENT_KEY, personId, education.getId(), caseRequestId);
			}
		}
		return education;
	}

	public JSONArray getPersonalDetails(long personId, String dfrn, ThemeDisplay themeDisplay,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		LOGGER.info("getPersonalDetails >Invoked");
		SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);
		try {
			JSONArray getPersonDetailJsonArrayResponse = JSONFactoryUtil
					.createJSONObject(getPersonlDetailsByPersonId(personId, themeDisplay.getScopeGroupId()))
					.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			JSONArray getPersonJsonArrayResponse = JSONFactoryUtil
					.createJSONObject(getPersonById(personId, themeDisplay.getScopeGroupId()))
					.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			LOGGER.info("getPersonDetailJsonArrayResponse : " + getPersonDetailJsonArrayResponse
					+ " ::::::::getPersonJsonArrayResponse::::" + getPersonJsonArrayResponse);
			String caseRequestId = getPersonDetailJsonArrayResponse.getJSONObject(0).getString("caseRequestId");
			LOGGER.info("getPersonDetailJsonArrayResponse : " + getPersonDetailJsonArrayResponse
					+ " ::::::::getPersonJsonArrayResponse::::" + getPersonJsonArrayResponse);
			LOGGER.info("caseRequestId:::::::::::::" + caseRequestId);
			JSONArray jsonEducationCertificate = JSONFactoryUtil.createJSONArray();
			LOGGER.info("caseRequestId:::::::::::::" + caseRequestId);
			// JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			Date dob = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
					.parse(getPersonJsonArrayResponse.getJSONObject(0).getString("dateOfBirth"));
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("nationality",
					getPersonDetailJsonArrayResponse.getJSONObject(0).getString("nationalityCountryId"));
			jsonObject.put("passportNumber", getPersonJsonArrayResponse.getJSONObject(0).getString("passportNumber"));
			jsonObject.put("dateOfBirth", sdf.format(dob));
			jsonObject.put("email", getPersonDetailJsonArrayResponse.getJSONObject(0).getString("email"));
			jsonObject.put("mobileNumber", getPersonDetailJsonArrayResponse.getJSONObject(0).getString("mobileNumber"));
			jsonObject.put("profession", getPersonDetailJsonArrayResponse.getJSONObject(0).getString("profession"));
			jsonObject.put("professionOther", getPersonDetailJsonArrayResponse.getJSONObject(0).getString("professionOther"));
			jsonObject.put("primarySpeciality",
					getPersonDetailJsonArrayResponse.getJSONObject(0).getString("primarySpeciality"));
			jsonObject.put("personId", getPersonDetailJsonArrayResponse.getJSONObject(0).getString("personId"));
			jsonObject.put("dfrn", dfrn);
			jsonEducationCertificate.put(jsonObject);
			jsonEducationCertificate = getEducationCertificate(Long.valueOf(caseRequestId), themeDisplay,
					jsonEducationCertificate);
			LOGGER.info("jsonEducationCertificate:::::::::::::::" + jsonEducationCertificate);
			return jsonEducationCertificate;
		} catch (ParseException | JSONException | UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public JSONObject getCaseReportByPersonId(long personId, ThemeDisplay themeDisplay) {
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		JSONObject jsonCaseReportObject = JSONFactoryUtil.createJSONObject();
		try {
			String caseReportUrl = themeDisplay.getPortalURL() + AppealConstants.CASE_REPORT_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + "?filter=personId"
					+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8) + AppealConstants.PAGE_SIZE;
			String caseReportResponse = omsbHttpConnector.executeGet(caseReportUrl, StringPool.BLANK, headers);
			if (Validator.isNotNull(caseReportResponse)) {
				CaseReportItems caseReportItems = CustomObjectMapperUtil.readValue(caseReportResponse,
						CaseReportItems.class);
				if (Validator.isNotNull(caseReportItems) && caseReportItems.getItems().size() > 0) {
					CaseReport caseReport = caseReportItems.getItems().get(0);
					String fileEntryUrl = getFileURL(caseReport.getFileEntryId());

					jsonCaseReportObject.put("fileEntryId", caseReport.getFileEntryId());
					jsonCaseReportObject.put("fileEntryUrl", fileEntryUrl);
					jsonCaseReportObject.put("fileName", caseReport.getFileName());
					jsonCaseReportObject.put("verificationReport", "Verification Report");
				}
			}

		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Error in getting Case Report >>>" + e.getMessage());
		}
		return jsonCaseReportObject;
	}

	private JSONArray getEducationCertificate(long caseRequestId, ThemeDisplay themeDisplay,
			JSONArray jsonEducationCertificate) throws UnsupportedEncodingException {

		String educationUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestId,
						OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		String educationResponse = omsbCommonApi.getData(educationUrl);
		LOGGER.info("caseRequestId  : " + caseRequestId + " , educationUrl : " + educationUrl
				+ "educationResponse:::22222222::::::::" + educationResponse);
		EducationalDetail educations = CustomObjectMapperUtil.readValue(educationResponse, EducationalDetail.class);
		if (Validator.isNotNull(educations) && educations.getItems().size() > 0) {
			LOGGER.info("educations.getItems().size()::::::::" + educations.getItems().size());
			for (EducationalDetailItem education : educations.getItems()) {
				LOGGER.info("education.getId() ::::::::::" + education.getId());
				String educationDocumentUrl = themeDisplay.getPortalURL()
						+ LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR,
								String.valueOf(themeDisplay.getScopeGroupId()))
						+ StringPool.QUESTION + "filter=equivalencyRequestId"
						+ URLEncoder.encode(" eq 0 and componentClassRefId eq " + education.getId(),
								OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
				LOGGER.info("educationDocumentUrl:::::" + educationDocumentUrl);
				String educationDocumentResponse = omsbCommonApi.getData(educationDocumentUrl);
				LOGGER.info("educationDocumentResponse:::" + educationDocumentResponse);
				DocumentInfoItems educationDocuments = CustomObjectMapperUtil.readValue(educationDocumentResponse,
						DocumentInfoItems.class);
				if (Validator.isNotNull(educationDocuments) && educationDocuments.getItems().size() > 0) {
					DocumentInfo educationDocument = educationDocuments.getItems().get(0);
					String educationCertificateUrl = Validator
							.isNotNull(getFileURL(educationDocument.getFileEntryID()))
									? getFileURL(educationDocument.getFileEntryID())
									: "";
									
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("educationCertificateUrl", educationCertificateUrl);
					jsonObject.put("educationCertificateFileEntryId", educationDocument.getFileEntryID());
					jsonObject.put("educationCertificateDocumentInfoId", educationDocument.getId());
					jsonObject.put("educationCertificateName", educationDocument.getDocumentType());
//						jsonObject.put("issuedFrom", education.getIssuingAuthorityName());
					String documentType = educationDocument.getDocumentType();
					jsonObject.put("documentType", documentType);
					ListTypeEntry qualificationListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC, education.getQualificationAttained(),
							themeDisplay.getCompanyId());
					
					if (Validator.isNotNull(qualificationListTypeEntry)) {
						jsonObject.put("qualification",
								qualificationListTypeEntry.getName(themeDisplay.getLocale()));
					}
					
					Country country = null;
					try {
						long countryId = Long.valueOf(education.getIssuingAuthorityCountryId());
						if (countryId > 0) {
							country = countryLocalService.getCountry(countryId);
						}
						if (Validator.isNotNull(country)) {
							jsonObject.put("issuedFrom", country.getName(themeDisplay.getLocale()));
						}else {
							jsonObject.put("issuedFrom", StringPool.MINUS);
						}
					} catch (PortalException | NumberFormatException e) {
						LOGGER.error("Exception while getting the country or its Id," + e.getMessage());
					}
					
					if (Validator.isNotNull(education.getQualificationConferredDate())) {
						String issueDate = omsbCommonApi
								.convertObjectDateToDDMMYYYYDate(education.getQualificationConferredDate());
						jsonObject.put("issueDate", issueDate);
					}
					if(Validator.isNotNull(education.getIssuingAuthorityName())){
						ListTypeEntry institutionListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
								OmsbVehpcEquivalencyWebPortletKeys.PL_UNIVERSITY_ERC,education.getIssuingAuthorityName(),
								themeDisplay.getCompanyId());
						if (Validator.isNotNull(institutionListTypeEntry)) {
							jsonObject.put("institution",
									institutionListTypeEntry.getName(themeDisplay.getLocale()));
						}else {
							jsonObject.put("institution",education.getIssuingAuthorityName());
						}
					}
					if(Validator.isNotNull(education.getDurationInYears())){
						jsonObject.put("graduationDuration",education.getDurationInYears());
					}
					
					jsonEducationCertificate.put(jsonObject);
					LOGGER.debug("ed cert url>>>>>>>>>>>>>>" + educationCertificateUrl);
				}
			}
		}
		LOGGER.info("certificate.jsonArray::::::::" + jsonEducationCertificate);
		return jsonEducationCertificate;
	}

	private String getPersonlDetailsByPersonId(long personId, long scopeId) throws UnsupportedEncodingException {
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String finderQueryPersonDetails = StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId,
				OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		String getPersonDetailsURL = generateScopeListURL(LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL, scopeId);
		LOGGER.info("getPersonDetailsURL:::::::::::::::::1111111:::" + getPersonDetailsURL + finderQueryPersonDetails);
		return omsbHttpConnector.executeGet(getPersonDetailsURL + finderQueryPersonDetails, "", headersInfo);
	}

	public String getPersonById(long personId, long scopeId) throws UnsupportedEncodingException {
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String getPersonURL = generateScopeListURL(LRObjectURL.PERSON_URL, scopeId);
		String finderQueryPerson = StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq '" + personId + "'",
				OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		return omsbHttpConnector.executeGet(getPersonURL + finderQueryPerson, "", headersInfo);
	}

	public String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL()
				+ equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}

	public String getFileURL(long fileEntryId) {
		try {
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			String fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			LOGGER.info("url ?? " + fileUrl);
			return fileUrl;
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDocumentTypeName(ThemeDisplay themeDisplay, long documentTypeId) {
		String documentTypeUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_TYPE_URL + documentTypeId;
		String documentTypeResponse = omsbCommonApi.getData(documentTypeUrl);
		LOGGER.info(documentTypeUrl + "documentTypeResponse::!!!!!!!!!!!!!!:" + documentTypeResponse);
		DocumentTypesItem documentType = CustomObjectMapperUtil.readValue(documentTypeResponse,
				DocumentTypesItem.class);
		return documentType.getType().getName();
	}

	private ListTypeEntry getListTypeNameByKey(String pickListErc, String plKey, long companyId) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(pickListErc, plKey, companyId);
		return entry;
	}

	public EmploymentDetailItem getEmploymentDetailItemByPersonId(String portalURL, long groupId, long personId) {
		StringBuilder sbURL = new StringBuilder(portalURL + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + groupId);
		if (Validator.isNotNull(personId)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("url::get Work Details:::::" + sbURL);
		return getItems(sbURL.toString(), EmploymentDetailItem.class);
	}

	public <T> T getItems(String url, Class<T> clazz) {
		String response = omsbCommonApi.getData(url);
		if (Validator.isNotNull(response)) {
			return CustomObjectMapperUtil.readValue(response, clazz);
		}
		return null;
	}

	public void getListTypeEntries(PortletRequest request, ThemeDisplay themeDisplay) {
		ListTypeDefinition definition = null;
		try {
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					"PL_Profession_ERC", PortalUtil.getDefaultCompanyId());
			request.setAttribute("professionList",
					ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		/* Document Type pickList dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, PortalUtil.getDefaultCompanyId());
			request.setAttribute("documentTypeList",
					ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		/* Qualification pickList dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					"PL_Qualification_ERC", PortalUtil.getDefaultCompanyId());
			request.setAttribute("qualificationList",
					ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		/* University pickList dropdown */
		try {
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					"PL_UNIVERSITY_ERC", PortalUtil.getDefaultCompanyId());
			request.setAttribute("universityList",
					ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void addCertificatesToEvaluatedDocuments(long personId, long noOfCertificatesDocument,
			UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay, ObjectMapper objectMapper,
			Map<String, String> headersInfo, DocumentInfo certificateToEvaFileUploadDetails, long equivalencyRequestId)
			throws JsonProcessingException, JSONException {
		LOGGER.info("addCertificatesToEvaluatedDocuments >>>>>>>>>>Start:::noOfCertificatesDocument::::::"
				+ noOfCertificatesDocument);
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
				themeDisplay.getScopeGroupId());
		LOGGER.info("equivalencyDocTypeURL :" + equivalencyDocTypeURL);
		for (int i = 1; i <= noOfCertificatesDocument; i++) {

			String qualification = ParamUtil.getString(uploadPortletRequest, "qualification" + i);
			String fileEntryId = ParamUtil.getString(uploadPortletRequest, "fileEntryId" + i);
			String documentInfoId = ParamUtil.getString(uploadPortletRequest, "documentInfoId" + i);
			long institution = ParamUtil.getLong(uploadPortletRequest, "institution" + i);
			long graduationDuration = ParamUtil.getLong(uploadPortletRequest, "graduationDuration" + i);
			LOGGER.info("fileEntryId:::" + fileEntryId + " , documentInfoId : " + documentInfoId);

			boolean docCheckbox = ParamUtil.getBoolean(uploadPortletRequest, "docCheckbox" + i);
			LOGGER.info("qualification::? at index " + i + " index " + qualification);
			LOGGER.info("checkbox is ::?" + docCheckbox);
			if (docCheckbox) {
				long classRefId = 0;
				String certificateToEvafileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL,
						themeDisplay.getScopeGroupId());

				String dfrn = ParamUtil.getString(uploadPortletRequest, "dfrn" + i);

				EquivalencyDocumentType certificatesToEvaEqDocType = new EquivalencyDocumentType();
				certificatesToEvaEqDocType.setEquivalencyDocType("Certificate To Evaluate");
				certificatesToEvaEqDocType.setEquivalencyRequestId(equivalencyRequestId);
				certificatesToEvaEqDocType.setQualification(qualification);
				certificatesToEvaEqDocType.setCaseRequestNumber(dfrn);
				String eqDocTypeCertificateToEvaPayload = objectMapper.writeValueAsString(certificatesToEvaEqDocType);
				String certificateToEvaDocTypeResponse = omsbHttpConnector.executePost(equivalencyDocTypeURL,
						eqDocTypeCertificateToEvaPayload, headersInfo);

				JSONObject certificateToEvaDocTypeResponseJson = JSONFactoryUtil
						.createJSONObject(certificateToEvaDocTypeResponse);
				certificateToEvaFileUploadDetails
						.setEquivalencyDocTypeId(certificateToEvaDocTypeResponseJson.getInt("id"));

				if (!(Validator.isNotNull(documentInfoId) && Long.valueOf(documentInfoId) > 0)) {
					LOGGER.info("INSIDE CALLING" + i + " documentInfoId " + documentInfoId + " : fileEntryId:::"
							+ fileEntryId);
					String issuedFrom = ParamUtil.getString(uploadPortletRequest, "issuedFrom" + i);
					int issuedFromCountryId =  Integer.parseInt(issuedFrom);
					String issueDate = ParamUtil.getString(uploadPortletRequest, "issueDate" + i);

					try {
						EducationDetail educationDetail = new EducationDetail();
						educationDetail.setIssuingAuthorityCountryId(issuedFromCountryId);
						educationDetail.setIssuingAuthorityName(issuedFrom);
						LOGGER.info("qualification above condition, " + qualification);
						if (Validator.isNotNull(qualification) && !qualification.isBlank()) {
							LOGGER.info("qualification is not empty, " + qualification);
							educationDetail.setQualificationAttained(
									getQualificationNameByKey(OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC,
											qualification, themeDisplay));
						} else {
							LOGGER.info("qualification is empty, " + qualification);
							educationDetail.setQualificationAttained(qualification);
						}
						String convertedIssueDate = omsbCommonApi.convertDDMMYYYYDateToObjectDate(issueDate);
						educationDetail.setQualificationConferredDate(convertedIssueDate);
						educationDetail.setEquivalencyRequestId(equivalencyRequestId);
						educationDetail.setDurationInYears(graduationDuration);
						
						ListTypeEntry institutionListTypeEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId(institution);
						if(Validator.isNotNull(institutionListTypeEntry)) {
							educationDetail.setIssuingAuthorityName(institutionListTypeEntry.getKey());
						}

						EducationDetail detail = addEducationDetail(personId, 0, educationDetail, "",
								themeDisplay.getScopeGroupId());
						if (Validator.isNotNull(detail)) {
							classRefId = detail.getId();
						}
					} catch (Exception e) {
						LOGGER.info("Error while adding education details, " + e);
					}
					LOGGER.info("Education Details Upload Complete>>>>>>>>>>>>>");

					Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
					if (Validator.isNotNull(files.get("certificatetbl" + i))) {
						// long certificateFileEtryId = addDocument(uploadPortletRequest, themeDisplay,
						// certificatefile, childfolderCertificateToBeEvaluated);

						try {
							certificateToEvaFileUploadDetails.setFileEntryID(fileUpload(uploadPortletRequest,
									"Certificate to Be Evaluated", "certificatetbl" + i).get(0).getFileEntryId());
						} catch (PortalException | IOException e) {
							LOGGER.error(e.getMessage());
						}
						// Certificate File upload
						certificateToEvaFileUploadDetails.setDocumentType("Qualification");
						certificateToEvaFileUploadDetails.setComponentId(2);
						certificateToEvaFileUploadDetails.setComponentClassRefId(classRefId);
						try {
							String certificateToEvafileUploadDetailPayload = objectMapper
									.writeValueAsString(certificateToEvaFileUploadDetails);
							omsbHttpConnector.executePost(certificateToEvafileUploadDetailURL,
									certificateToEvafileUploadDetailPayload, headersInfo);
						} catch (JsonProcessingException e) {
							LOGGER.error(e.getMessage());
						}

						if (Validator.isNotNull(files.get("verificationReportPaymentReceipt" + i))) {
							try {
								List<FileEntry> fileEntries2 = fileUpload(uploadPortletRequest,
										"Certificate to Be Evaluated", "verificationReportPaymentReceipt" + i);
								certificateToEvaFileUploadDetails.setFileEntryID(fileEntries2.get(0).getFileEntryId());
							} catch (PortalException | IOException e) {
								LOGGER.error(e.getMessage());
							}

							certificateToEvaFileUploadDetails.setDocumentType("Verification Report Payment Receipt");
							certificateToEvaFileUploadDetails.setComponentId(0);
							try {
								String certificateToEvafileUploadDetailPayload2 = objectMapper
										.writeValueAsString(certificateToEvaFileUploadDetails);
								omsbHttpConnector.executePost(certificateToEvafileUploadDetailURL,
										certificateToEvafileUploadDetailPayload2, headersInfo);
								LOGGER.info("Verification Report File Uploaded>>>>>>>>>>>>>");
							} catch (JsonProcessingException e) {
								LOGGER.error(e.getMessage());
							}
						}
					}
				} else {
					LOGGER.info("INSIDE CALLING else" + i + " documentInfoId " + documentInfoId + " : fileEntryId:::"
							+ fileEntryId);
					String documentUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL
							+ documentInfoId;
					String documentResponse = omsbCommonApi.getData(documentUrl);
					DocumentInfo documentInfo = CustomObjectMapperUtil.readValue(documentResponse, DocumentInfo.class);
					LOGGER.info("documentInfo documentResponse at " + i + " documentResponse " + documentResponse);
					DocumentInfo documentInfoWrite = new DocumentInfo();
					documentInfoWrite.setEquivalencyRequestId(equivalencyRequestId);
					documentInfoWrite.setEquivalencyDocTypeId(certificateToEvaDocTypeResponseJson.getInt("id"));
					documentInfoWrite.setdFFileName(documentInfo.getdFFileName());
					documentInfoWrite.setFileEntryID(documentInfo.getFileEntryID());
					documentInfoWrite.setComponentId(2);
					documentInfoWrite.setPersonId(documentInfo.getPersonId());
					documentInfoWrite.setDocumentType(OmsbVehpcEquivalencyWebPortletKeys.QUALIFICATION);
					documentInfoWrite.setComponentClassRefId(documentInfo.getComponentClassRefId());
					String documentInfoMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoWrite, null);
					String documentInfoMapperUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
					omsbHttpConnector.executePost(documentInfoMapperUrl, documentInfoMapper,
							omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				}
			}
		}
	}

	public String getQualificationNameByKey(String erc, String key, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(erc, key, themeDisplay.getCompanyId());
		String qualificationName = "";
		if (Validator.isNotNull(entry)) {
			qualificationName = entry.getName(themeDisplay.getLocale());
		}
		LOGGER.info("qualificationName in getQualificationNameByKey " + qualificationName);
		return qualificationName;
	}

	public List<EducationalDetailItem> getEducationByEquivalencyId(ThemeDisplay themeDisplay,
			long equivalencyRequestId) {
		List<EducationalDetailItem> educationList = new ArrayList<>();
		String educationUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=equivalencyRequestId"
				+ URLEncoder.encode(" eq " + equivalencyRequestId, StandardCharsets.UTF_8);
		String educationResponse = omsbCommonApi.getData(educationUrl);
		LOGGER.info("educationResponse is  ?? " + educationResponse);
		EducationalDetail details = CustomObjectMapperUtil.readValue(educationResponse, EducationalDetail.class);
		if (Validator.isNotNull(details) && Validator.isNotNull(details.getItems()) && !details.getItems().isEmpty()) {
			educationList = details.getItems();
		}
		return educationList;
	}

	public List<FileEntry> fileUpload(UploadPortletRequest uploadPortletRequest, String folderName,
			String fileParamName) throws PortalException, java.io.IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
				uploadPortletRequest);

		Folder folder = getFolder(themeDisplay.getScopeGroupId(), folderName);
		if (Validator.isNull(folder)) {
			folder = createNewFolder(uploadPortletRequest, folderName);
		}
		long folderId = 0;
		if (Validator.isNotNull(folder)) {
			folderId = folder.getFolderId();
		}
		FileItem[] items = uploadPortletRequest.getMultipartParameterMap().get(fileParamName);

		List<FileEntry> fileEntries = new ArrayList<>();
		for (FileItem fileItem : items) {
			try {
				String title = System.currentTimeMillis() + fileItem.getFileName();
				FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, title,
						fileItem.getContentType(), title, title, "", fileItem.getStoreLocation(), serviceContext);
				fileEntries.add(fileEntry);
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return fileEntries;
	}

	public Folder getFolder(long groupId, String folderName) {
		try {
			return DLAppLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Folder createNewFolder(UploadPortletRequest uploadPortletRequest, String folderName) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					uploadPortletRequest);
			return DLAppLocalServiceUtil.addFolder(folderName, themeDisplay.getUserId(),
					serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName,
					"New Folder Description", serviceContext);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public EquivalencyRequest getEquivalencyRequestById(long equivalencyRequestId) {
		String eqRequestResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
				StringPool.BLANK, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		LOGGER.info("EquivalencyViewMVCRenderCommand eqRequestResponse:::::::" + eqRequestResponse);
		EquivalencyRequest equivalency = null;
		if (eqRequestResponse.contains("personId")) {
			equivalency = CustomObjectMapperUtil.readValue(eqRequestResponse, EquivalencyRequest.class);
		}
		return equivalency;
	}

	public CustomCountryItemResponse getCountryByCountryId(String portalURL, long groupId, long countryId) {
		StringBuilder sbURL = new StringBuilder(
				portalURL + LRObjectURL.REG_CUSTOM_COUNTRY_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
		if (countryId > 0) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=countryID"
						+ URLEncoder.encode(" eq " + countryId, DataflowConstants.UTF_8));
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		}
		LOGGER.info("getCountryByCountryId:::::::::::::::::" + sbURL.toString());
		return getItems(sbURL.toString(), CustomCountryItemResponse.class);
	}

	public EducationalDetailItem getEducationDetailById(long educationId, ThemeDisplay themeDisplay) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + educationId;
		LOGGER.info("url for education is ?? " + url);
		String response = omsbCommonApi.getData(url);
		LOGGER.info("response for education is ?? " + response);
		return CustomObjectMapperUtil.readValue(response, EducationalDetailItem.class);
	}

	public List<DocumentInfo> getUploadedFileEntries(long equivalencyRequestId, ThemeDisplay themeDisplay,
			UploadPortletRequest uploadPortletRequest, String inputFileName) {
		LOGGER.info("invoking method updateEqStatusFiles :::::::");
		List<DocumentInfo> fileEntryList = new ArrayList<>();
		try {
			FileItem[] files = uploadPortletRequest.getMultipartParameterMap().get(inputFileName);
			DLFolder folder = FileUploadUtil.getDLFolder(themeDisplay.getScopeGroupId(), 0,
					String.valueOf(equivalencyRequestId));
			if (Validator.isNull(folder)) {
				folder = FileUploadUtil.createDLFolder(themeDisplay.getScopeGroupId(),
						String.valueOf(equivalencyRequestId), 0, themeDisplay.getUserId(), StringPool.BLANK);
			}
			if (Validator.isNotNull(files)) {
				for (FileItem file : files) {
					if (Validator.isNotNull(folder)) {
						DocumentInfo info = new DocumentInfo();
						LOGGER.info("folder Id is  :::::::" + folder.getFolderId());
						FileEntry entry = FileUploadUtil.createFileEntry(themeDisplay.getScopeGroupId(),
								folder.getFolderId(), file.getFileName(), file.getContentType(), StringPool.BLANK,
								file.getInputStream().readAllBytes());
						if (Validator.isNotNull(entry)) {
							LOGGER.info("fileName is :::: " + file.getFileName() + "  ::::::  fileEntry Id is  :::::::"
									+ entry.getFileEntryId());
							// String fileName = FileUtil.stripExtension(file.getFileName());
							info.setFileEntryID(entry.getFileEntryId());
							info.setdFFileName(file.getFileName());
							fileEntryList.add(info);
						}
					}
				}
			}

		} catch (IOException e) {
			LOGGER.error("Exception while uploading the file::::::", e);
		}
		LOGGER.info("invoking method updateEqStatusFiles successful:::::::");
		return fileEntryList;
	}

	public EquivalencyDocumentType addEquivalencyDocumentsType(long equivalencyRequestId, String equivalencyDocTypeURL,
			String fileName, String documentType) {
		LOGGER.info("invoking method updateEquivalencyDocuments :::::::");
		try {
			// fileName = FileUtil.stripExtension(fileName);
			LOGGER.info(" newfileName :::::::" + fileName);
			EquivalencyDocumentType documentEqDocType = new EquivalencyDocumentType();
			documentEqDocType.setEquivalencyDocType(documentType);
			documentEqDocType.setEquivalencyRequestId(equivalencyRequestId);
			documentEqDocType.setQualification("");
			String eqDocTypeOtherDocumentPayload = CustomObjectMapperUtil.writeValueAsString(documentEqDocType, null);
			String otherDocumentDocTypeResponse = omsbHttpConnector.executePost(equivalencyDocTypeURL,
					eqDocTypeOtherDocumentPayload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			LOGGER.info("EqDocType insert successful:::::::");
			return CustomObjectMapperUtil.readValue(otherDocumentDocTypeResponse, EquivalencyDocumentType.class);
		} catch (Exception e) {
			LOGGER.error("Exception while updating equivalencyDocument Type ::" + e);
		}
		LOGGER.info("invoking method updateEquivalencyDocuments successful:::::::");
		return null;
	}

	public void addDocumentInfo(long equivalencyRequestId, long appealId, long equivalencyDocTypeId, long fileEntryId,
			long personId, String fileName, String documentType, long classRefId, String docInfoURL) {
		LOGGER.info("docInfo insert starts:::::::");

		DocumentInfo docInfo = new DocumentInfo();
		docInfo.setEquivalencyDocTypeId(equivalencyDocTypeId);
		docInfo.setDocumentType(documentType);
		docInfo.setEquivalencyRequestId(equivalencyRequestId);
		docInfo.setEquivalencyAppealId(appealId);
		docInfo.setdFFileName(fileName);
		docInfo.setFileEntryID(fileEntryId);
		docInfo.setPersonId(personId);
		docInfo.setComponentClassRefId(classRefId);
		LOGGER.info("fileName ??" + fileName);
		String docInfoPayload = CustomObjectMapperUtil.writeValueAsString(docInfo, null);
		LOGGER.info("docInfoPayload in updateEquivalencyDocuments ??" + docInfoPayload);
		omsbHttpConnector.executePost(docInfoURL, docInfoPayload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		LOGGER.info("docInfo insert successful:::::::");
	}

	public void saveEquivalencyDecision(ThemeDisplay themeDisplay, String comments, long documentInfoId,
			long equivalencyRequestId, EquivalencyLevel equivalencyLevel, String otherEquivalencyReasonKey,
			EquivalencyStatus equivalencyStatus) {
		try {
			EquivalencyDecision equivalencyDecision = new EquivalencyDecision();
			equivalencyDecision.setComments(comments);
			equivalencyDecision.setDecisionBy(themeDisplay.getUserId());
			equivalencyDecision.setDocumentInfoId(documentInfoId);
			equivalencyDecision.setEquivalencyRequestId(equivalencyRequestId);
			equivalencyDecision.setEquivalencyLevelId(equivalencyLevel);
			equivalencyDecision.setOtherEquivalency(otherEquivalencyReasonKey);
			equivalencyDecision.setEquivalencyStatus(equivalencyStatus);
			ObjectMapper objectMapper = new ObjectMapper();

			String equivalencyDecisionPayload = "";
			try {
				equivalencyDecisionPayload = objectMapper.writeValueAsString(equivalencyDecision);
			} catch (JsonProcessingException e) {
				LOGGER.error(e.getMessage());
			}

			String equivalencyDecisionURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DECISION_URL,
					themeDisplay.getLayout().getGroupId());
			String res = omsbHttpConnector.executePost(equivalencyDecisionURL, equivalencyDecisionPayload,
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public EquivalencyRequestStatus updateEqStatusToEqRequestStatus(EquivalencyRequestStatus equivalencyRequestStatus,
			long siteId, Map<String, String> headersInfo) {

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String equivalencyRequestStatusPayload = objectMapper.writeValueAsString(equivalencyRequestStatus);
			String officialRequestFileUploadDetailURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_REQUEST_STATUS_URL,
					siteId);
			String statusResponse = omsbHttpConnector.executePost(officialRequestFileUploadDetailURL,
					equivalencyRequestStatusPayload, headersInfo);
			return CustomObjectMapperUtil.readValue(statusResponse, EquivalencyRequestStatus.class);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public void uploadDocuments(long classPK, long appealId, ThemeDisplay themeDisplay, PortletRequest portletRequest,
			long personId, long equivalencyRequestStatusId, String inputFileName, String documentType) {
		List<DocumentInfo> fileEntries = getUploadedFileEntries(classPK, themeDisplay,
				PortalUtil.getUploadPortletRequest(portletRequest), inputFileName);
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
				themeDisplay.getScopeGroupId());
		String docInfoURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, themeDisplay.getScopeGroupId());
		for (DocumentInfo info : fileEntries) {
			EquivalencyDocumentType eqDocType = addEquivalencyDocumentsType(classPK, equivalencyDocTypeURL,
					info.getdFFileName(), documentType);
			if (Validator.isNotNull(eqDocType)) {
				addDocumentInfo(classPK, appealId, eqDocType.getId(), info.getFileEntryID(), personId,
						info.getdFFileName(), documentType, equivalencyRequestStatusId, docInfoURL);
			}
		}
	}

	public String getListTypeEntryNamebyKey(String erc, String key, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(erc, key, themeDisplay.getCompanyId());
		if (Validator.isNotNull(entry)) {
			return entry.getName(themeDisplay.getLocale());
		}
		return StringPool.BLANK;
	}

	public List<DocumentInfo> getCommentDocuments(long eqStatusId, List<DocumentInfo> documentInfoList) {
		List<DocumentInfo> documentInfos = new ArrayList<>();
		for (DocumentInfo info : documentInfoList) {
			if (info.getComponentClassRefId() == eqStatusId) {
				info.setDocumentUrl(getFileURL(info.getFileEntryID()));
				documentInfos.add(info);
			}
		}
		return documentInfos;
	}

	public void sendEquivalencyNotification(ThemeDisplay themeDisplay, String roleName, String templateName) {
		Role role = null;
		List<User> roleUsers = new ArrayList<>();
		try {
			role = roleLocalService.getRole(themeDisplay.getCompanyId(), roleName);
			if (Validator.isNotNull(role)) {
				roleUsers = userLocalService.getRoleUsers(role.getRoleId());
			}
			for (User user : roleUsers) {
				sendEquivalencyNotificationToUser(themeDisplay, user.getUserId(), templateName);
			}
		} catch (PortalException e) {
			LOGGER.error("Exception while getting the role::::: ", e);
		}

	}

	public void sendEquivalencyNotificationToUser(ThemeDisplay themeDisplay, long userId, String templateName) {
		omsbCommonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userId, templateName,
				OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB, true);
	}

	public long updateEquivalencyRequest(long equivalencyRequestId, long statusId, ActionRequest actionRequest,
			ThemeDisplay themeDisplay) {
		Map<String, Serializable> values = new HashMap<>();
		values.put("equivalencyStatusId", statusId);
		ObjectEntry entry = omsbCommonApi.updateObjectEntryByERC("OB_EUIVALENCY_REQUEST_ERC", values, actionRequest,
				themeDisplay, equivalencyRequestId);
		if (Validator.isNotNull(entry)) {
			return entry.getObjectEntryId();
		}
		return 0;
	}

	public long addEquivalencyRequest(long personId, long employerUserId, long statusId, PortletRequest request,
			ThemeDisplay themeDisplay) {
		Map<String, Serializable> values = new HashMap<>();
		values.put("personId", personId);
		values.put("employerUserID", employerUserId);
		values.put("equivalencyStatusId", statusId);
		ObjectEntry entry = omsbCommonApi.addObjectEntryByERC("OB_EUIVALENCY_REQUEST_ERC", values, request,
				themeDisplay);
		if (Validator.isNotNull(entry)) {
			return entry.getObjectEntryId();
		}
		return 0;
	}

	public void deleteAllDocumentsByEquivalencyRequestId(long equivalencyRequestId, long scopeGroupId,
			String portalUrl) {
		try {
			Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
			String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL, scopeGroupId)
					+ "?filter=equivalencyRequestId"
					+ URLEncoder.encode(" eq " + equivalencyRequestId, DataflowConstants.UTF_8);
			String eqRequestResponse = omsbHttpConnector.executeGet(equivalencyDocTypeURL, StringPool.BLANK, headers);
			EquivalencyDocumentTypeItems equivalencyDocumentTypeItems = CustomObjectMapperUtil
					.readValue(eqRequestResponse, EquivalencyDocumentTypeItems.class);

			for (EquivalencyDocumentType equivalencyDocumentType : equivalencyDocumentTypeItems.getItems()) {
				String equivalencyDocTypeByIdURL = portalUrl + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
						+ equivalencyDocumentType.getId();
				String equivalencyDocTypeByIdResponse = omsbHttpConnector.executeDelete(equivalencyDocTypeByIdURL,
						headers);
				LOGGER.info("DELETED DOCS TYPE >>>>" + equivalencyDocTypeByIdResponse);
			}

			String docInfoUrl = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, scopeGroupId)
					+ "?filter=equivalencyRequestId"
					+ URLEncoder.encode(" eq " + equivalencyRequestId, DataflowConstants.UTF_8);
			String docInfoUrlResponse = omsbHttpConnector.executeGet(docInfoUrl, StringPool.BLANK, headers);
			DocumentInfoItems documentInfoItems = CustomObjectMapperUtil.readValue(docInfoUrlResponse,
					DocumentInfoItems.class);

			for (DocumentInfo documentInfo : documentInfoItems.getItems()) {
				String docInfoByIdURL = portalUrl + LRObjectURL.REG_DOCUMENT_INFO_URL + documentInfo.getId();
				String equivalencyDocInfoResponse = omsbHttpConnector.executeDelete(docInfoByIdURL, headers);
				LOGGER.info("DELETED DOCS INFO >>>>" + equivalencyDocInfoResponse);
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public List<EquivalencyAppeal> getAppealList(String getAppealUrl) {
		String appealResponse = omsbHttpConnector.executeGet(getAppealUrl, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (Validator.isNotNull(appealResponse)) {
			EquivalencyAppealItems equivalencyAppealItems = CustomObjectMapperUtil.readValue(appealResponse,
					EquivalencyAppealItems.class);
			if (Validator.isNotNull(equivalencyAppealItems)) {
				return equivalencyAppealItems.getItems();
			}
		}
		return null;
	}

	public List<EquivalencyRequest> getEquivalencyRequestList(String equivalencyRquestsURL) {
		List<EquivalencyRequest> equivalencyRequestList = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String equivalencyRequestsResponse = omsbHttpConnector.executeGet(equivalencyRquestsURL, StringPool.BLANK,
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			if (Validator.isNotNull(equivalencyRequestsResponse)) {
				JSONObject equivalencyRequestsResponseJson;
				equivalencyRequestsResponseJson = JSONFactoryUtil.createJSONObject(equivalencyRequestsResponse);
				Object equivalencyRequestListJson = equivalencyRequestsResponseJson
						.get(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
				equivalencyRequestList = objectMapper.readValue(equivalencyRequestListJson.toString(),
						new TypeReference<List<EquivalencyRequest>>() {
						});
			}
		} catch (JSONException | JsonProcessingException e) {
			e.printStackTrace();
		}
		return equivalencyRequestList;
	}

	public String getFinalStatusValue(boolean isAdmin, boolean isEmployer, String key, ThemeDisplay themeDisplay,
			String status) {
		ListTypeEntry statusListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
				LRPicklistConstants.PL_EQUIVALENCY_STATUS, key, themeDisplay.getCompanyId());
		LOGGER.info("status is ?" + status);
		LOGGER.info("key is ?" + key);
		if (Validator.isNotNull(statusListTypeEntry)) {
			if (isAdmin) {
				if (key.equalsIgnoreCase(EquivalencyRequestStatusEnum.INPROGRESS.getText())) {
					return LanguageUtil.get(themeDisplay.getLocale(), "submitted-to-committee");
				}
				if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EQUATED.getText())) {
					return LanguageUtil.get(themeDisplay.getLocale(), "received-from-rapporteur"); // "Receieved(From
																									// Rapporteur)"
				}
				if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.ADMIN_DRAFT.getText())) {
					return LanguageUtil.get(themeDisplay.getLocale(), "draft");
				}

			} else if (isEmployer) {
				if (key.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
					return LanguageUtil.get(themeDisplay.getLocale(), "draft");
				} else if (key.equalsIgnoreCase(EquivalencyRequestStatusEnum.INPROGRESS.getText())) {
					return LanguageUtil.get(themeDisplay.getLocale(), "submitted");
				}
			}

			return statusListTypeEntry.getName(themeDisplay.getLocale());
		}
		return "";
	}

	public String getFinalStatus(boolean isEmployer, boolean isCommittee, boolean isAdmin, boolean isRapporteur,
			String status) {
		StringBuilder finalStatus = new StringBuilder();
		LOGGER.info("status in getFinal Status is ?? " + status);
		if (isAdmin) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.CREATED.getText())
					|| status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EQUATED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INSUFFICIENT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INSUFFICIENT.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.ADMIN_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.ADMIN_DRAFT.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		} else if (isCommittee) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		} else if (isEmployer) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INSUFFICIENT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INSUFFICIENT.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		} else if (isRapporteur) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		}
		LOGGER.info("finalStatus ?? " + finalStatus);
		return finalStatus.toString();
	}

	public List<DocumentInfo> getCaseReportListByPersonId(String personId, ThemeDisplay themeDisplay) {
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		try {
			List<DocumentInfo> caseReportDocumentList = new ArrayList<>();
			String caseReportUrl = themeDisplay.getPortalURL() + AppealConstants.CASE_REPORT_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + "?filter=personId"
					+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8) + AppealConstants.PAGE_SIZE;
			String caseReportResponse = omsbHttpConnector.executeGet(caseReportUrl, StringPool.BLANK, headers);
			if (Validator.isNotNull(caseReportResponse)) {
				CaseReportItems caseReportItems = CustomObjectMapperUtil.readValue(caseReportResponse,
						CaseReportItems.class);
				if (Validator.isNotNull(caseReportItems) && caseReportItems.getItems().size() > 0) {
					for (CaseReport caseReport : caseReportItems.getItems()) {
						DocumentInfo docInfo = new DocumentInfo();
						docInfo.setId(caseReport.getId());
						docInfo.setDocumentType(OmsbVehpcEquivalencyWebPortletKeys.VERIFICATION_REPORT);
						docInfo.setdFFileName(caseReport.getFileName());
						docInfo.setDocumentUrl(getFileURL(caseReport.getFileEntryId()));
						caseReportDocumentList.add(docInfo);
					}
					return caseReportDocumentList;
				}
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Error while getting Case Report >>>" + e.getMessage());
		}

		return null;
	}

	public List<ProfessionSpecialtyMapping> getProfessionSpecialtyMappingListByProfessionKey(long professionId,
			ThemeDisplay themeDisplay) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.PROFESSION_SPECIALITY_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=profession"
				+ URLEncoder.encode(" eq " + professionId, StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		ProfessionSpecialtyMappingItems professionSpecialtyMappingItems = CustomObjectMapperUtil.readValue(response,
				ProfessionSpecialtyMappingItems.class);
		if (Validator.isNotNull(professionSpecialtyMappingItems)
				&& professionSpecialtyMappingItems.getItems().size() > 0) {
			List<ProfessionSpecialtyMapping> professionSpecialtyMappingList = professionSpecialtyMappingItems
					.getItems();
			return professionSpecialtyMappingList;
		}
		return null;
	}

	public String getEquivalencyCertificateByEquivalencyRequestId(long equivalencyRequestId, long scopeGroupId) {
		String equivalencyCertificateURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_CERTIFICATE_URL, scopeGroupId)
				+ "?filter=equivalencyRequestId"
				+ URLEncoder.encode(" eq " + equivalencyRequestId, StandardCharsets.UTF_8);
		String equivalencyResponse = omsbHttpConnector.executeGet(equivalencyCertificateURL, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		EquivalencyCertificateItems equivalencyCertificateItems = CustomObjectMapperUtil.readValue(equivalencyResponse,
				EquivalencyCertificateItems.class);
		if (Validator.isNotNull(equivalencyCertificateItems) && equivalencyCertificateItems.getItems().size() > 0) {
			EquivalencyCertificate equivalencyCertificate = equivalencyCertificateItems.getItems().get(0);
			if (Validator.isNotNull(equivalencyCertificate)) {
				return getFileURL(equivalencyCertificate.getFileEntryId());
			}

		}
		return null;
	}

	public String getEquivalencyCertificateByEquivalencyAppealId(long equivalencyAppealId, long scopeGroupId) {
		String equivalencyCertificateURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_CERTIFICATE_URL, scopeGroupId)
				+ "?filter=equivalencyAppealId"
				+ URLEncoder.encode(" eq " + equivalencyAppealId, StandardCharsets.UTF_8);
		String equivalencyResponse = omsbHttpConnector.executeGet(equivalencyCertificateURL, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		EquivalencyCertificateItems equivalencyCertificateItems = CustomObjectMapperUtil.readValue(equivalencyResponse,
				EquivalencyCertificateItems.class);
		if (Validator.isNotNull(equivalencyCertificateItems) && equivalencyCertificateItems.getItems().size() > 0) {
			EquivalencyCertificate equivalencyCertificate = equivalencyCertificateItems.getItems().get(0);
			if (Validator.isNotNull(equivalencyCertificate)) {
				return getFileURL(equivalencyCertificate.getFileEntryId());
			}

		}
		return null;
	}

	public List<ByLawRule> fetchAllRulesByModuleName(String moduleName, ThemeDisplay themeDisplay) {
		try {
			String byLawRulesUrl = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "?filter=moduleName" + URLEncoder.encode(" eq " + moduleName, DataflowConstants.UTF_8)
					+ AppealConstants.PAGE_SIZE;
			String byLawRulesResponse = omsbCommonApi.getData(byLawRulesUrl);
			ByLawRuleItems byLawRuleItems = CustomObjectMapperUtil.readValue(byLawRulesResponse, ByLawRuleItems.class);
			if (Validator.isNotNull(byLawRuleItems) && byLawRuleItems.getItems().size() > 0) {
				List<ByLawRule> byLawRuleList = byLawRuleItems.getItems();
				return byLawRuleList;
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public ByLawCondition getByLawConditionById(String byLawConditionId, ThemeDisplay themeDisplay) {
		String byLawConditionUrl = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_CONDITION_OBJECT_URL
				+ byLawConditionId;
		String byLawConditionResponse = omsbCommonApi.getData(byLawConditionUrl);
		ByLawCondition byLawCondition = CustomObjectMapperUtil.readValue(byLawConditionResponse, ByLawCondition.class);
		if (Validator.isNotNull(byLawCondition)) {
			return byLawCondition;
		}
		return null;
	}

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private CaseDetailUtil caseDetailUtil;

	@Reference
	private CountryLocalService countryLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyUtil.class);

}
