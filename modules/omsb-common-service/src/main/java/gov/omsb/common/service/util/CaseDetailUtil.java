package gov.omsb.common.service.util;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.DataflowService;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.CaseRequest;
import gov.omsb.common.dto.CaseRequestItem;
import gov.omsb.common.dto.DataflowCaseDetail;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EmploymentDetail;
import gov.omsb.common.dto.FileUploadDetail;
import gov.omsb.common.dto.FileUploadDocument;
import gov.omsb.common.dto.HealthLicenceDetail;
import gov.omsb.common.dto.PaymentDetail;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItemsResponse;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.ReferencialDetail;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.endpoint.configuration.api.LiferayConfiguration;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(
		immediate = true,
		service = CaseDetailUtil.class
		)
public class CaseDetailUtil {
	
	
	/**
	 * 
	 * @return Base URL of the Portal.
	 */
	private String getBaseURL() {
		Company company;
		String url = "";
		try {
			company = CompanyLocalServiceUtil.getCompanyById(PortalUtil.getDefaultCompanyId());
			Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);
			url = company.getPortalURL(group.getGroupId());
			logger.info("home URL ?? " + company.getPortalURL(group.getGroupId()));
		} catch (PortalException e) {
			logger.error("Exception while getting the Base URL ::::: " + e);
		}
		return url;
	}
	
	/**
	 * 
	 * @return this is used to get the string value of groupId to replace with URL string
	 */
	private String getGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			logger.info("Guest Group Id is ?? " + group.getGroupId());
			return String.valueOf(group.getGroupId());
		}
		return "";
	}

	/**
	 *@author AftabA
	 *@param caseDetailResponse
	 *@return It will add the data into the Verification Objects table.
	 */
	public void addCaseDetail(String caseDetailResponse) {
	logger.info("addCaseDetail ::::::caseDetailResponse"+caseDetailResponse);
		DataflowCaseDetail caseDetailDTO = CustomObjectMapperUtil.readValue(caseDetailResponse, DataflowCaseDetail.class);	
		if (Validator.isNotNull(caseDetailDTO)) {
			String caseNumber = caseDetailDTO.getPayload().getReferencialDetail().getCaseNumber();
			try {
				Person personResponse = addOrUpdatePerson(caseDetailDTO);
				CaseRequest caseRequestResponse = addOrUpdateCaseRequestDetail(personResponse.getId(), caseDetailDTO);
				List<EducationDetail> educationDetailList = caseDetailDTO.getPayload().getEducationDetail();
				if(educationDetailList.isEmpty()) {
					educationDetailList = caseDetailDTO.getPayload().getSubmittedDetails().getEducationDetail();
				}
				List<EmploymentDetail> employmentDetailList = caseDetailDTO.getPayload().getEmploymentDetail();
				if(employmentDetailList.isEmpty()) {
					employmentDetailList = caseDetailDTO.getPayload().getSubmittedDetails().getEmploymentDetail();
				}
				List<HealthLicenceDetail> healthLicenceDetailList = caseDetailDTO.getPayload().getHealthLicenceDetail();
				if(healthLicenceDetailList.isEmpty()) {
					healthLicenceDetailList = caseDetailDTO.getPayload().getSubmittedDetails().getHealthLicenceDetail();
				}
				if (Validator.isNotNull(caseRequestResponse) && Validator.isNotNull(personResponse)) {
					addOrUpdatePersonalDetail(personResponse.getId(), caseDetailDTO.getPayload().getPersonalDetail(), caseRequestResponse.getId(), caseNumber, caseDetailDTO);
					addPaymentDetail(caseRequestResponse.getId(), caseDetailDTO.getPayload().getPaymentDetail());
					//List<EducationDetail> educationDetailList = caseDetailDTO.getPayload().getEducationDetail();
					for (EducationDetail educationDetail : educationDetailList) {
						addEducationDetail(personResponse.getId(), caseRequestResponse.getId(), educationDetail, caseNumber);
					}
					//List<EmploymentDetail> employmentDetailList = caseDetailDTO.getPayload().getEmploymentDetail();
					for (EmploymentDetail employmentDetail : employmentDetailList) {
						addEmploymentDetail(personResponse.getId(), caseRequestResponse.getId(), employmentDetail, caseNumber);
					}
					//List<HealthLicenceDetail> healthLicenceDetailList = caseDetailDTO.getPayload().getHealthLicenceDetail();
					for (HealthLicenceDetail healthLicenceDetail : healthLicenceDetailList) {
						addHealthLicenseDetail(personResponse.getId(), caseRequestResponse.getId(), healthLicenceDetail, caseNumber);
					}
					addReferentialDetail(personResponse.getId(), caseRequestResponse.getId(), caseDetailDTO.getPayload().getReferencialDetail());
					if (caseDetailDTO.getPayload().getIsReportAvailable().equalsIgnoreCase("Y")) {
						addCaseReport(caseNumber, dataflowService.getCaseReport(caseNumber));
					}
				}
			} catch ( JSONException e) {
				logger.error("Error while adding caseDetail, " ,e);
			}
		}
	}
	
	/**
	 * 
	 * @param caseDetailDTO
	 * @return It returns the Person Object response from the DB
	 */
	private Person addOrUpdatePerson(DataflowCaseDetail caseDetailDTO) {
		logger.info("Invoking addOrUpdatePerson method " );
		Person pRes = null;
		String passportNumner = caseDetailDTO.getPayload().getPersonalDetail().getPassportNumber();
		String dob = caseDetailDTO.getPayload().getPersonalDetail().getDateOfBirth();
		String dateOfBirth = null ;
		if (!Validator.isBlank(dob)) {
			dateOfBirth = convertDateToObjectFormat(dob);
		}
		String url = getBaseURL() + LRObjectURL.PERSON_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION; 
		if (!passportNumner.isEmpty()) {
			url = url + "filter=passportNumber" + URLEncoder.encode(" eq "+ "'" + passportNumner + "'" ,StandardCharsets.UTF_8);
		}
		logger.info("object ?? " + url);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		logger.info("response ?? " + response);
		PersonItemsResponse itemResponse = CustomObjectMapperUtil.readValue(response, PersonItemsResponse.class);
		if (!response.contains("civilId") || !response.contains("passportNumber")) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("passportNumber", passportNumner);
			jsonObject.put("civilId", "");
			jsonObject.put("dateOfBirth", dateOfBirth);
			logger.info("json object" + jsonObject.toString());
			String personResponse = omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.PERSON_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
			pRes = CustomObjectMapperUtil.readValue(personResponse, Person.class, new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
			logger.info("pRes ?? " + pRes.getId());
		} else {
			if (Validator.isNotNull(itemResponse) && Validator.isNotNull(itemResponse.getItems()) && !itemResponse.getItems().isEmpty() ) { 
				pRes = itemResponse.getItems().get(0);
			}
		}
		logger.info("addOrUpdatePerson method invoked successful" );
		return pRes;
	}
	/**
	 * 
	 * @param personId
	 * @param caseDetailDTO
	 * @throws JSONException
	 * @message This method should be written at notify-to-client webservice end and get all parameter from the incoming request.
	 */
	private CaseRequest addOrUpdateCaseRequestDetail(long personId,DataflowCaseDetail caseDetailDTO) throws  JSONException {
		logger.info("addOrUpdateCaseRequestDetail method invoking ::::::" );
		long caseRequestId = 0;
		String caseNumber = caseDetailDTO.getPayload().getReferencialDetail().getCaseNumber();
		CaseRequest caseRequest = new CaseRequest();
		String url = getBaseURL() + LRObjectURL.CASE_REQUEST_URL_2.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=caseNumber" + URLEncoder.encode(" eq "+ "'" + caseNumber + "'" ,StandardCharsets.UTF_8);
		String getCaseRequestResponse = omsbHttpConnector.executeGet(url, "", getHeaders());
		long caseStatusId = getLiferayCaseStatusId(String.valueOf(caseDetailDTO.getPayload().getCaseStatus().getStatusId()));
		long caseStageId = getLiferayCaseStageId(String.valueOf(caseDetailDTO.getPayload().getCaseStage().getStageId()));
		long caseTypeId = getLiferayCaseTypeId(String.valueOf(caseDetailDTO.getPayload().getReferencialDetail().getCaseTypeId()));
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put(DataflowConstants.CRN, caseDetailDTO.getPayload().getReferencialDetail().getClientReferenceNumber());
		jsonObject.put(DataflowConstants.CASE_TYPE_ID, caseTypeId);
		jsonObject.put(DataflowConstants.CASE_NUMBER, caseNumber);
		jsonObject.put(DataflowConstants.CASE_STAGE_ID, caseStageId);
		jsonObject.put(DataflowConstants.CASE_STATUS_ID, caseStatusId);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put(DataflowConstants.VERIFICATION_DATE, convertDateToObjectFormat(caseDetailDTO.getPayload().getReferencialDetail().getSubmittedDate()));
		if (!getCaseRequestResponse.contains(DataflowConstants.CASE_NUMBER)) {
			logger.info("jsonObject ::::::  " + jsonObject);
			String postResponse = omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.CASE_REQUEST_URL_2.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
			logger.info("jsonObject ::::::  " + postResponse);
			logger.info("addOrUpdateCaseRequestDetail method invoked successfull ::::::" );
			caseRequest =  CustomObjectMapperUtil.readValue(postResponse, CaseRequest.class);
			caseRequestId = caseRequest.getId();
		} else {
			CaseRequestItem requestItem = CustomObjectMapperUtil.readValue(getCaseRequestResponse, CaseRequestItem.class);
			if (Validator.isNotNull(requestItem) && Validator.isNotNull(requestItem.getItems()) && !requestItem.getItems().isEmpty()) {
				caseRequestId = requestItem.getItems().get(0).getId();
				omsbHttpConnector.executePut(getBaseURL() + LRObjectURL.REG_CASE_REQUEST_URL + caseRequestId,
						jsonObject.toString(), getHeaders());
				caseRequest = requestItem.getItems().get(0);
			}
		}
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		String caseStageURL = getBaseURL() + LRObjectURL.CASE_REQUEST_STAGE_URL + CommonConstants.SCOPES + StringPool.SLASH + getGroupId();
		omsbHttpConnector.executePost(caseStageURL, jsonObject.toString(), getHeaders());
		return caseRequest;
	}
	
	/**
	 * 
	 * @param personId
	 * @param dfPersonalDetailDTO
	 * @param caseRequestId
	 * @throws JSONException
	 * This method used to store the Personal Detail info into the Objects using headless API. 
	 */
	private void addOrUpdatePersonalDetail(long personId, PersonalDetail dfPersonalDetailDTO, long caseRequestId, String caseNumber, DataflowCaseDetail caseDetailDTO) throws  JSONException {
		logger.info("addOrUpdatePersonalDetail method invoking ::::::" );
		PersonalDetail personalDetail = new PersonalDetail();
		long pk = 0;
		String url = getBaseURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=personId" + URLEncoder.encode(" eq "+ personId ,StandardCharsets.UTF_8);
		String personalResponse = omsbHttpConnector.executeGet(url, "", getHeaders());
		PersonalDetailItem personalItems = CustomObjectMapperUtil.readValue(personalResponse, PersonalDetailItem.class);
		logger.info("personalResponse ?? " + personalResponse);
		/*
		 * if (Validator.isNotNull(personalItems) &&
		 * Validator.isNotNull(personalItems.getItems()) &&
		 * !personalItems.getItems().isEmpty()) { pk =
		 * personalItems.getItems().get(0).getId(); }
		 */
		if (!personalResponse.contains(DataflowConstants.PERSON_ID)) {
			String personalJson = CustomObjectMapperUtil.writeValueAsString(dfPersonalDetailDTO, null);
			logger.info("personalJson ::::::  " + personalJson);
			JSONObject object = setPersonalDetail(personalJson,  personId, caseRequestId, caseDetailDTO);
			String response = omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), object.toString(), getHeaders());
			personalDetail = CustomObjectMapperUtil.readValue(response, PersonalDetail.class);
			for(FileUploadDetail fileUpload : dfPersonalDetailDTO.getFileUploadDetails()) {
				saveFileUploadDetail(caseNumber, String.valueOf(fileUpload.getDocId()), DataflowConstants.PERSONAL_COMPONENT_KEY, personId, personalDetail.getId(), caseRequestId);
			}
		}
		/*
		 * if (Validator.isNotNull(personalDetail)) { pk = personalDetail.getId(); }
		 */
		logger.info("addOrUpdatePersonalDetail method invoked ::::::" );
	}
	
	
	
	/**
	 * 
	 * @param caseRequestId
	 * @param paymentDetailDTO
	 * @throws JSONException
	 * This method used to store the Payment Detail info into the Objects using headless API.
	 */
	private void addPaymentDetail(long caseRequestId, PaymentDetail paymentDetailDTO ) throws JSONException {
		logger.info("addPaymentDetail method invoking ::::::" );
		DateFormat dateFormat = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT_IN_MAPPER);
		String paymentJson = CustomObjectMapperUtil.writeValueAsString(paymentDetailDTO, dateFormat);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(paymentJson);
		jsonObject.put("totalAmount", jsonObject.getString("totalAmout"));
		jsonObject.put(DataflowConstants.TRANSACTION_NUMBER, jsonObject.getString(DataflowConstants.DF_TRANSACTION_NO));
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		logger.info("payment Json ?? "  + paymentJson );
		omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.PAYMENT_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
		logger.info("addPaymentDetail method invoked ::::::" );
	}
	
	/**
	 * 
	 * @param personId
	 * @param caseRequestId
	 * @param educationDetail
	 * @throws JSONException
	 * This method used to store the Education Detail into the Objects using headless API.
	 */
	public EducationDetail addEducationDetail(long personId, long caseRequestId, EducationDetail educationDetail, String caseNumber) throws JSONException  {
		logger.info("addEducationDetail method invoking ::::::" );
		DateFormat dateFormat = new SimpleDateFormat(DataflowConstants.DF_DATE_FORMAT);
		String educationJson = CustomObjectMapperUtil.writeValueAsString(educationDetail, dateFormat);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(educationJson);
		long countryId = getLiferayCountryId(jsonObject.getString("issuingAuthorityCountry"));
		ListTypeEntry entry = addPickListData(LRPicklistConstants.QUALIFICATION, jsonObject.getString("qualificationAttained"));
		if (Validator.isNotNull(entry)) {
			jsonObject.remove("qualificationAttained");
			jsonObject.put("qualificationAttained", entry.getKey());
		}
		
		ListTypeEntry issuingAuthEntry = addPickListData(LRPicklistConstants.UNIVERSITY, jsonObject.getString("issuingAuthorityName"));
		
		if (Validator.isNotNull(issuingAuthEntry)) {
			jsonObject.remove("issuingAuthorityName");
			jsonObject.put("issuingAuthorityName", issuingAuthEntry.getListTypeEntryId());
			updateInstituteMasterMapping(countryId, issuingAuthEntry.getListTypeEntryId());
		}
		
		jsonObject.remove("issuingAuthorityCountryId");
		jsonObject.put("issuingAuthorityCountryId", countryId);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		String mosId = jsonObject.getString("modeOfStudy"); 
		jsonObject.put("modeOfStudy",mosId);
		String qualificationDate = jsonObject.getString("qualificationConferredDate");
		jsonObject.put("qualificationConferredDate", convertDateToObjectFormat(qualificationDate));
		logger.info("education Json ?? "  + jsonObject );
		String response = omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
		EducationDetail education = CustomObjectMapperUtil.readValue(response, EducationDetail.class);
		if (Validator.isNotNull(education)) {
			for(FileUploadDetail fileUpload : educationDetail.getFileUploadDetails()) {
				saveFileUploadDetail(caseNumber, String.valueOf(fileUpload.getDocId()), DataflowConstants.EDUCATION_COMPONENT_KEY, personId, education.getId(), caseRequestId);
			}
		}
		logger.info("addEducationDetail method invoked ::::::" );
		return education;
	}
	
	/**
	 * 
	 * @param personId
	 * @param caseRequestId
	 * @param healthLicenceDetailDTO
	 * @throws JSONException
	 * This method used to store the Health Detail info into the Objects using headless API.
	 */
	private void addHealthLicenseDetail(long personId, long caseRequestId, HealthLicenceDetail healthLicenceDetailDTO, String caseNumber) throws JSONException  {
		logger.info("addHealthLicenseDetail method invoking ::::::" );
		DateFormat dateFormat = new SimpleDateFormat(DataflowConstants.DF_DATE_FORMAT);
		String healthJson = CustomObjectMapperUtil.writeValueAsString(healthLicenceDetailDTO, dateFormat);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(healthJson);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID_CAPITAL, caseRequestId);
		long issuingCountryId = getLiferayCountryId(jsonObject.getString("issuingAuthorityCountry"));
		jsonObject.put("issuingAuthorityCountryId", issuingCountryId);
		String licenseExpiryDate = jsonObject.getString("licenseExpiryDate");
		String licenseConferredDate = jsonObject.getString("licenseConferredDate");
		jsonObject.put("licenseExpiryDate", convertDateToObjectFormat(licenseExpiryDate));
		jsonObject.put("licenseConferredDate", convertDateToObjectFormat(licenseConferredDate));
		logger.info("health license Json ?? "  + jsonObject );
		String response = omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.HEALTH_LICENSE_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
		HealthLicenceDetail health = CustomObjectMapperUtil.readValue(response, HealthLicenceDetail.class);
		if (Validator.isNotNull(health)) {
			for(FileUploadDetail fileUpload : healthLicenceDetailDTO.getFileUploadDetails()) {
				saveFileUploadDetail(caseNumber, String.valueOf(fileUpload.getDocId()), DataflowConstants.HEALTH_COMPONENT_KEY, personId, health.getId(), caseRequestId);
			}
		}
		logger.info("addHealthLicenseDetail method invoked ::::::" );
	}
	
	/**
	 *
	 * @param personId
	 * @param caseRequestId
	 * @param employmentDetailDTO
	 * @throws JSONException
	 * @return This method used to store the Employment Detail info into the Objects using headless API.
	 */
	private void addEmploymentDetail(long personId, long caseRequestId, EmploymentDetail employmentDetailDTO, String caseNumber) throws JSONException  {
		logger.info("addEmploymentDetail method invoking ::::::" );
		String employmentJson = CustomObjectMapperUtil.writeValueAsString(employmentDetailDTO, null);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(employmentJson);
		jsonObject.remove("issuingAuthorityCountryId");
		long countryId = getLiferayCountryId(jsonObject.getString("issuingAuthorityCountry"));
		jsonObject.put("issuingAuthorityCountryId", countryId);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID_CAPITAL, caseRequestId);
		String employementPeriodFrom = jsonObject.getString("employementPeriodFrom");
		String employementPeriodTo = jsonObject.getString("employementPeriodTo");
		jsonObject.put("employmentPeriodFrom",convertDateToObjectFormat(employementPeriodFrom));
		jsonObject.put("employmentPeriodTo",convertDateToObjectFormat(employementPeriodTo));
		logger.info("employment Json ?? "  + jsonObject );
		String response = omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.EMPLOYMENT_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
		EmploymentDetail employment = CustomObjectMapperUtil.readValue(response, EmploymentDetail.class);
		if (Validator.isNotNull(employment)) {
			for(FileUploadDetail fileUpload : employmentDetailDTO.getFileUploadDetails()) {
				saveFileUploadDetail(caseNumber, String.valueOf(fileUpload.getDocId()), DataflowConstants.EMPLOYMENT_COMPONENT_KEY, personId, employment.getId(), caseRequestId);
			}
		}
		logger.info("addEmploymentDetail method invoked ::::::" );
	}
	
	/**
	 * 
	 * @param personId
	 * @param caseRequestId
	 * @param referencialDetail
	 * @throws JSONException
	 * This method used to store the Referential Detail info into the Objects using headless API.
	 */
	private void addReferentialDetail(long personId, long caseRequestId, ReferencialDetail referencialDetail) throws JSONException {
		logger.info("addReferentialDetail method invoking ::::::" );
		String referenceJson = CustomObjectMapperUtil.writeValueAsString(referencialDetail, null);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(referenceJson);
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		jsonObject.put(DataflowConstants.CATEGORY_2, jsonObject.getString(DataflowConstants.DF_CATEGORY_2));
		jsonObject.put(DataflowConstants.CATEGORY_3, jsonObject.getString(DataflowConstants.DF_CATEGORY_3));
		jsonObject.put(DataflowConstants.CATEGORY_4, jsonObject.getString(DataflowConstants.DF_CATEGORY_4));
		logger.info("Referential Json ?? "  + jsonObject );
		omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.REFERENCE_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
		logger.info("addReferentialDetail method invoked ::::::" );
	}
	
	/**
	 * 
	 * @param date
	 * @return Date
	 * It will convert String date into the java.util.date. 
	 */
	public String convertDateToObjectFormat(String date) {
		DateFormat oldDF = new SimpleDateFormat(DataflowConstants.DF_DATE_FORMAT);
		DateFormat newDF = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT);
		try {
			Date oldDate =  oldDF.parse(date);
			return newDF.format(oldDate);  // check again is this required to set with new date format or can be used with above date format in object mapper
		} catch (ParseException e) {
			logger.error("exception while parsing the date " + e);
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param response
	 * @param personId
	 * @param caseRequestId
	 * @return JSON OBJECT of Personal Detail Objects
	 * @throws JSONException
	 */
	private JSONObject setPersonalDetail(String response, long personId, long caseRequestId, DataflowCaseDetail caseDetailDTO) throws JSONException {
		JSONObject object = JSONFactoryUtil.createJSONObject(response);
		//long nationalityId = getLiferayCountryId(caseDetailDTO.getPayload().getSubmittedDetails().getDatabase().get(0).getNationality());
		long nationalityId = getNationality(caseDetailDTO);
		logger.info("object ?? " + object.toString());
		//long nationalityCntyId = object.getLong(DataflowConstants.DF_NATIONALITY_COUNTRY_ID);
		String passportIssuingCountryName = object.getString(DataflowConstants.PASSPORT_ISSUING_COUNTRY_NAME);
		//long countryId = object.getLong(DataflowConstants.COUNTRY_ID);
		//long id = 0;
		logger.info("nationality Id ?? " + passportIssuingCountryName);
		logger.info("passportIssuingCountryName ?? " + passportIssuingCountryName);
		object.remove(DataflowConstants.NATIONALITY_COUNTRY_ID);
		object.remove(DataflowConstants.PASSPORT_ISSUING_COUNTRY_ID);
		object.put(DataflowConstants.NATIONALITY_COUNTRY_ID, nationalityId);
		object.put(DataflowConstants.PASSPORT_ISSUING_COUNTRY_ID, getLiferayCountryId(passportIssuingCountryName));
		object.put(DataflowConstants.COUNTRY_ID, nationalityId);
		object.put(DataflowConstants.GIVEN_NAME_AS_PASSPORT, object.getString(DataflowConstants.DF_GIVEN_NAME_AS_PER_PASSPORT));
		object.put(DataflowConstants.EMAIL, object.getString(DataflowConstants.DF_PERSONAL_MAIL));
		//object.put(DataflowConstants.NATIONALITY_COUNTRY_ID, object.getLong(DataflowConstants.DF_NATIONALITY_COUNTRY_ID));
		object.put(DataflowConstants.PERSON_ID, personId);
		object.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		logger.info("final object ?? " + object.toString());
		return object;
	}
	
	private long getNationality(DataflowCaseDetail caseDetailDTO) {
		String nationality = "";
		if (!caseDetailDTO.getPayload().getSubmittedDetails().getDatabase().isEmpty() && Validator.isNotNull(caseDetailDTO.getPayload().getSubmittedDetails().getDatabase().get(0).getNationality())) {
			nationality = caseDetailDTO.getPayload().getSubmittedDetails().getDatabase().get(0).getNationality();
		} else if (!caseDetailDTO.getPayload().getDatabase().isEmpty() && Validator.isNotNull(caseDetailDTO.getPayload().getDatabase().get(0).getNationality())) {
			nationality = caseDetailDTO.getPayload().getDatabase().get(0).getNationality();
		} else if (Validator.isNotNull(caseDetailDTO.getPayload().getPersonalDetail().getNationalityCountryName())) {
			nationality = caseDetailDTO.getPayload().getPersonalDetail().getNationalityCountryName();
		}
		logger.info("nationality ?? " + nationality);
		return getLiferayCountryId(nationality);
	}
	
	/**
	 * 
	 * @param dataFlowCountryId
	 * @return Liferay Country ID using the DataFlow countryId.
	 * @throws JSONException
	 */
	private long getLiferayCountryId(String dataFlowCountryName) {
		Country country = null;
		try {
			String countryName = dataFlowCountryName.trim().replace(StringPool.SPACE, StringPool.DASH).toLowerCase();
			logger.info("countryName in getLiferayCountryId  ?? " + countryName);
			country = countryLocalService.getCountryByName(PortalUtil.getDefaultCompanyId(), countryName);
		} catch (PortalException e) {
			logger.error("exception while getting country by name:::", e);
		}
		if (Validator.isNotNull(country)) {
			return country.getCountryId();
		}
		/*
		String url = getBaseURL() + LRObjectURL.CUSTOM_COUNTRY_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=dFCountryID" + URLEncoder.encode(" eq "+ dataFlowCountryId  ,StandardCharsets.UTF_8);
		logger.info("custom country url ?? "  + url);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, "countryID");
		*/
		return 0;
	}
	
	
	private long getLiferayCaseStatusId(String dfStatusId) throws  JSONException {
		String url = getBaseURL() + LRObjectURL.CASE_STATUS_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=dFStatusID" + URLEncoder.encode(" eq "+ dfStatusId  ,StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, DataflowConstants.ID);
		
	}
	
	public long getLiferayModeOfStudyId(String mosId) throws  JSONException {
		String url = getBaseURL() + LRObjectURL.MODE_OF_STUDY_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=dFMOSID" + URLEncoder.encode(" eq "+ mosId  ,StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, DataflowConstants.ID);
		
	}
	
	private long getLiferayCaseStageId(String dfStageId) throws JSONException {
		String url = getBaseURL() + LRObjectURL.CASE_STAGE_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=dFStageID" + URLEncoder.encode(" eq "+ dfStageId  ,StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, DataflowConstants.ID);
	}
	
	private long getLiferayCaseTypeId(String dfCaseTypeId) throws JSONException {
		String url = getBaseURL() + LRObjectURL.CASE_TYPE_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId())+StringPool.QUESTION;
		url = url + "filter=dFCaseTypeId" + URLEncoder.encode(" eq "+ dfCaseTypeId  ,StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, DataflowConstants.ID);
	}
	
	private long getResponseProperty(String response, String property) throws JSONException {
		logger.info("response in getResponseProperty is ?? " + response );
		if (response.contains(DataflowConstants.RESPONSE_ITEMS)) {
			JSONObject object = JSONFactoryUtil.createJSONObject(response);
			JSONArray array = object.getJSONArray(DataflowConstants.RESPONSE_ITEMS);
			if (Validator.isNotNull(array) && array.length() > 0) {
				return array.getJSONObject(0).getLong(property);
			}
		}
		return 0;
	}
	
	public Map<String, Long> getCaseStatusCount(){
		String url = getBaseURL() + LRObjectURL.CASE_STATUS_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId());
		return getStatusMap(omsbHttpConnector.executeGet(url, StringPool.BLANK, getHeaders()));
	}
	
	private Map<String, Long> getStatusMap(String responseObject){
		
		logger.info("getStatusMap ResponseObject :"+responseObject);
		Map<String, Long> caseRequestStatusMap = new HashMap<>();
		try {
			if(Validator.isNotNull(responseObject)) {
				JSONObject json = JSONFactoryUtil.createJSONObject(responseObject);
				logger.info("Json :"+json);
				JSONArray itemArray = json.getJSONArray("items");
				logger.info("Item :"+itemArray);
				logger.info("ItemArray :"+itemArray.length());
				
				if(Validator.isNotNull(itemArray) && itemArray.length()>0) {
					for (int i = 0; i < itemArray.length(); i++) {  
						JSONObject itemJson = itemArray.getJSONObject(i);				 
						caseRequestStatusMap.put(itemJson.getJSONObject("caseStatus").getString("key"), getCaseRequestStatusMap(itemJson.getLong("id")));
					}
				}
			}
		} catch (JSONException | NullPointerException e) {
			logger.error("Error while getting  status map , "+e.getMessage());
		}
		return caseRequestStatusMap;
	}
	
	private long getCaseRequestStatusMap(long caseStatusId){
		logger.info("getCaseRequestStatusMap ResponseObject :"+caseStatusId);
		String url = getBaseURL() + LRObjectURL.CASE_REQUEST_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId());
		url += StringPool.QUESTION + "filter=caseStatusId" + URLEncoder.encode(" eq "+ caseStatusId ,StandardCharsets.UTF_8);
		
		return getCaseRequestStatusCount(omsbHttpConnector.executeGet(url, StringPool.BLANK, getHeaders()));
	}
	
	private long getCaseRequestStatusCount(String responseObject){

		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(responseObject);
			 return json.getLong("totalCount");			
		} catch (JSONException e) {
			logger.error("Error while converting personalDetails response, "+e.getMessage());
		}
		return 0;
	}
	
	/**
	 * @throws JSONException
	 * This method is used to get list of users in verification page person select dropdown
	 */
	public List<PersonalDetail> getPersonalDetail(String personName){
		String url = getBaseURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId());
		if(!personName.isEmpty()) {
			url += StringPool.QUESTION + "filter="+URLEncoder.encode("contains(givenNameAsPassport,'"+ personName +"') or contains(applicantSurname,'"+ personName +"')", StandardCharsets.UTF_8);
		}
		return getPersonalDetailsObject(omsbHttpConnector.executeGet(url, StringPool.BLANK, getHeaders()));
	}
	
	/**
	 * @param responseObject
	 * this method will return the list of Personal Detail Object
	 */
	private List<PersonalDetail> getPersonalDetailsObject(String responseObject) {
		List<PersonalDetail> personalDetailList = new ArrayList<>();
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(responseObject);
			JSONArray itemArray = json.getJSONArray("items");
			PersonalDetail personalDetail;
			for (int i = 0; i < itemArray.length(); i++) {  
				 personalDetail = new PersonalDetail();
				 JSONObject itemJson = itemArray.getJSONObject(i);
				 personalDetail.setApplicantSurname(itemJson.getString("applicantSurname"));
				 personalDetail.setGivenNameAsPassport(itemJson.getString("givenNameAsPassport"));
				 personalDetail.setPersonId(itemJson.getLong("personId"));
				 personalDetailList.add(personalDetail);
			 }
		} catch (JSONException | NullPointerException e) {
			logger.error("Error while converting personalDetails response, "+e.getMessage());
		}		
		return personalDetailList;
	}
	
	
	private long getComponentIdByKey(String key) throws  JSONException {
		String url = getBaseURL() + LRObjectURL.COMPONENT_URL + CommonConstants.SCOPES + StringPool.SLASH+ getGroupId() +StringPool.QUESTION;
		url = url + "filter=componentKey" + URLEncoder.encode(" eq "+ "'" + key + "'"  , StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, DataflowConstants.ID);
	}
	
	/**
	 * 
	 * @param docTypeId
	 * @return Return Liferay Primary key by using the dataflow DocType ID
	 * @throws JSONException
	 */
	private long getLrDocumentTypeIdByDFDocTypeId(long docTypeId) throws  JSONException {
		String url = getBaseURL() + LRObjectURL.DOCUMENT_TYPE_URL + CommonConstants.SCOPES + StringPool.SLASH+ getGroupId() +StringPool.QUESTION;
		url = url + "filter=dFDocTypeId" + URLEncoder.encode(" eq "+ docTypeId , StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		return getResponseProperty(response, DataflowConstants.ID);
	}
	
	/**
	 *
	 * @param caseNumber
	 * @param docId
	 * @param componentKey
	 * @param personId
	 * @param pk
	 * @param caseRequestId
	 * @throws JSONException
	 * @return It will use to save file upload detail
	 */
	public void saveFileUploadDetail(String caseNumber, String docId, String componentKey, long personId, long pk, long caseRequestId) throws JSONException{
		String response = dataflowService.getDocRespone(caseNumber, docId);
		FileUploadDocument document = CustomObjectMapperUtil.readValue(response, FileUploadDocument.class);
		if (Validator.isNotNull(document)) {
			uploadDocument(document.getPayload().getFileUploadDetail(), personId, componentKey, pk, caseRequestId );
		}
		
	}
	
	/**
	 *
	 * @param fileUploadDetail
	 * @param personId
	 * @param componentKey
	 * @param pk
	 * @param caseRequestId
	 * @throws JSONException
	 * @return This method will use to upload document in documents and media
	 */
	private void uploadDocument(FileUploadDetail fileUploadDetail, long personId, String componentKey, long pk, long caseRequestId) throws JSONException {
		byte[] fileBytes = Base64.getDecoder().decode(fileUploadDetail.getFile());
		long groupId = 0;
		Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(), CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			groupId = group.getGroupId();
		}
		long componentId = getComponentIdByKey(componentKey);
		//long docTypeId = getLrDocumentTypeIdByDFDocTypeId(fileUploadDetail.getDocTypeId());
		logger.info("Dataflow fileUploadDetail.getDocTypeId() ?? " + fileUploadDetail.getDocTypeId()+ " liferay doc type ?? " + fileUploadDetail.getDocType());
		DLFolder folder = createDFFolderStructure(groupId, personId, componentKey);
		FileEntry entry = null;
		if (Validator.isNotNull(folder)) {
			entry = FileUploadUtil.createFileEntry(groupId, folder.getFolderId(), fileUploadDetail.getFileName(), fileUploadDetail.getFileAttachmentType(), "", fileBytes);
		}
		if (Validator.isNotNull(entry)) {
			saveDocumentInfo(entry.getFileEntryId(), fileUploadDetail.getDocType(), pk, personId, caseRequestId, componentId, fileUploadDetail);
		}
	}
	
	/**
	 *
	 * @param fileEntryId
	 * @param documentTypeId
	 * @param pk
	 * @param personId
	 * @param caseRequestId
	 * @param componentId
	 * @param fileDetail
	 * @return this method is used to save the document info object values
	 */
	private void saveDocumentInfo(long fileEntryId, String documentTypeId, long pk, long personId, long caseRequestId, long componentId, FileUploadDetail fileDetail) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("fileEntryID", fileEntryId);
		jsonObject.put("documentType", documentTypeId);
		jsonObject.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId); 
		jsonObject.put("componentClassRefId", pk);
		jsonObject.put("componentId", componentId); 
		jsonObject.put("dFDocumentId", fileDetail.getDocId()); 
		jsonObject.put("dFFileKey", fileDetail.getFileKey()); 
		jsonObject.put("dFFileName", fileDetail.getFileName());
		jsonObject.put(DataflowConstants.PERSON_ID, personId);
		
		omsbHttpConnector.executePost(getBaseURL() + LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId()), jsonObject.toString(), getHeaders());
	}
	
	/**
	 * 
	 * @param groupId
	 * @param personId
	 * @param componentName
	 * @return this method will use to create folder structure based on the component name
	 */
	public DLFolder createDFFolderStructure(long groupId, long personId, String componentName) {
		logger.info("createDFFolderStructure method invoking ::::::" );
		DLFolder personFolder = null;
		DLFolder ePortalFolder = null;
		DLFolder componentFolder = null;
		long userId = 0;
		User user = userLocalService.fetchUserByEmailAddress(PortalUtil.getDefaultCompanyId(), DataflowConstants.DATAFLOW_EMAIL_ADDRESS);
		logger.info("user is ??" + user);
		if (Validator.isNotNull(user)) {
			logger.info("user Id is ??" + user.getUserId());
			userId = user.getUserId();
		}
        DLFolder parentFolder = FileUploadUtil.getDLFolder(groupId, 0, CommonConstants.PARENT_FOLDER_NAME);
        if (Validator.isNull(parentFolder)) {
             parentFolder = FileUploadUtil.createDLFolder(groupId, CommonConstants.PARENT_FOLDER_NAME, 0, userId, "");
        } 
        if (Validator.isNotNull(parentFolder)) {
        	ePortalFolder = FileUploadUtil.getDLFolder(groupId, parentFolder.getFolderId(), CommonConstants.LEVEL_1_FOLDER_NAME);
        	logger.info("ePortalFolder ?? " + ePortalFolder );
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
        logger.info("createDFFolderStructure method invoking ::::::" );
        return componentFolder;
    }
	
	private Map<String, String> getHeaders(){
		Map<String, String> headers = new HashMap<>();
		headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		try {
			JSONObject jsonResponse = null;
			LiferayConfiguration liferayConfiguration = provider.getSystemConfiguration(LiferayConfiguration.class);
			String tokenEndpoint = liferayConfiguration.getTokenEndPoint();
			String clientId = liferayConfiguration.getClientId();
			String clientSecret = liferayConfiguration.getClientSecret();
			String payload = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s", clientId, clientSecret);
			
			Map<String, String> tokenHeaders = new HashMap<>();
			tokenHeaders.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED);
			String tokenResponse = omsbHttpConnector.tokenExecutePost(tokenEndpoint, payload, tokenHeaders);
			jsonResponse = JSONFactoryUtil.createJSONObject(tokenResponse);
			logger.debug("jsonResponse>>>>>>>>>> " + jsonResponse);
			String accessToken = jsonResponse.getString("access_token");

			headers.put(HttpHeaders.AUTHORIZATION , "Bearer"+  StringPool.SPACE + accessToken);
			
			return headers;
		} catch (JSONException | ConfigurationException e) {
			e.printStackTrace();
		}
		
		return headers;
	}
	
	/**
	 * 
	 * @param caseNumber
	 * @param response
	 * this method will use to add the case report from dataflow to ePortal
	 */
	public void addCaseReport(String caseNumber, String response) {
		
		try {
			long groupId = Long.parseLong(getGroupId());
			FileUploadDocument fileUpload = CustomObjectMapperUtil.readValue(response, FileUploadDocument.class);
			logger.info("file name is ?? "+ fileUpload.getPayload().getFileName());
			String url = getBaseURL() + LRObjectURL.CASE_REQUEST_URL.replace(DataflowConstants.SCOPE_ID_VAR, getGroupId());
			url += StringPool.QUESTION + "filter=caseNumber" + URLEncoder.encode(" eq '"+ caseNumber + "'" ,StandardCharsets.UTF_8);
			String caseRequestResponse = omsbHttpConnector.executeGet(url, "", getHeaders());
			logger.info("url to get case request is ?? " + url);
			logger.info("caseRequestResponse is ?? " + caseRequestResponse);
			CaseRequestItem requestItems = CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequestItem.class);
			
			long personId = 0;
			long caseRequestId = 0;
			if (Validator.isNotNull(requestItems) && Validator.isNotNull(requestItems.getItems())
					&& !requestItems.getItems().isEmpty()) {
				personId = requestItems.getItems().get(0).getPersonId();
				caseRequestId = requestItems.getItems().get(0).getId();
			}
			DLFolder folder = createDFFolderStructure(groupId, personId, DataflowConstants.REPORT_COMPONENT_KEY);
			long fileEntryId = 0;
			FileEntry fileEntry = null;
			logger.info("fileUpload.getFile() ?? " + fileUpload.getPayload().getFileName());
			if (Validator.isNotNull(folder)) {
				fileEntry = FileUploadUtil.createFileEntry(groupId, folder.getFolderId(), fileUpload.getPayload().getFileName(),
						FileUtil.getExtension(fileUpload.getPayload().getFileName()), StringPool.BLANK, Base64.getDecoder().decode(fileUpload.getPayload().getFile()));
			}
			if (Validator.isNotNull(fileEntry)) {
				fileEntryId = fileEntry.getFileEntryId();
			}
			saveCaseReportToObject(caseRequestId, personId, fileUpload.getPayload().getFileName(), fileEntryId);
			 
		} catch (Exception e) {
			logger.error("exception while calling the addCaseReport Method ::: " , e);
		}
	}
	
	/**
	 * 
	 * @param caseRequestId
	 * @param personId
	 * @param fileName
	 * @param fileEntryId
	 * this method will save the report file to the CaseReports Object.
	 */
	private void saveCaseReportToObject(long caseRequestId, long personId, String fileName, long fileEntryId) {
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put(DataflowConstants.CASE_REQUEST_ID, caseRequestId);
		object.put(DataflowConstants.PERSON_ID, personId);
		object.put(DataflowConstants.FILE_ENTRY_ID, fileEntryId);
		object.put(DataflowConstants.FILE_NAME, fileName);
		String url = getBaseURL() + LRObjectURL.CASE_REPORTS_URL + CommonConstants.SCOPES +StringPool.SLASH + getGroupId();
		omsbHttpConnector.executePost(url, object.toString(), getHeaders());
	}
	
	private ListTypeEntry addPickListData(String erc, String value) {
		Map<Locale, String> nameMap = new HashMap<>();
		Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");
		nameMap.put(enLanguageLocale, value);
		logger.info("value in addPickListData is ?? " + value);
		ListTypeDefinition  definition = listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(erc, PortalUtil.getDefaultCompanyId());
		if (Validator.isNotNull(definition)) {
			try {
				ListTypeEntry entry = listTypeEntryLocalService.fetchListTypeEntry(definition.getListTypeDefinitionId(), generateListTypeKey(value));
				if (Validator.isNotNull(entry)) {
					return entry;
				} else {
					return listTypeEntryLocalService.addListTypeEntry("", definition.getUserId(), definition.getListTypeDefinitionId(), generateListTypeKey(value), nameMap);
				}
			} catch (PortalException e) {
				logger.error("Exception while adding list type entry :::: ", e);
			}
		}
		return null;
	}
	
	
	private String generateListTypeKey(String value) {
		logger.info("value in generate key is ?? " + value);
		logger.info("value in generate key after replace is ?? " + value.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK).replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK));
		return value.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK).replace(StringPool.DASH, StringPool.BLANK).replace(StringPool.AMPERSAND, StringPool.BLANK).replace(StringPool.CLOSE_PARENTHESIS, StringPool.BLANK).replace(StringPool.OPEN_PARENTHESIS, StringPool.BLANK);
	}
	
	private void updateInstituteMasterMapping(long countryId, long listTypeEntryId) {
		Map<String, Serializable> values = new HashMap<>();
		values.put("country", countryId);
		values.put("university", listTypeEntryId);
		try {
			ServiceContext serviceContext =  new ServiceContext();
			ObjectDefinition definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode("OMSB_Exam_INSTITUTIONS_MASTER_ERC",
					PortalUtil.getDefaultCompanyId());
			if (definition != null) {
				serviceContext.setUserId(definition.getUserId());
				serviceContext.setScopeGroupId(Long.parseLong(getGroupId()));
				
				boolean isExist = isInstituteMappingExist(listTypeEntryId);
				if (!isExist) {
					objectEntryLocalService.addObjectEntry(definition.getUserId(),
							Long.parseLong(getGroupId()), definition.getObjectDefinitionId(), values, serviceContext);
				}
				
			}
		} catch (PortalException e) {
			logger.error("Exception while mapping the institute master and university ::", e);
		}
	}
	
	
	private boolean isInstituteMappingExist(long universityId) {
		String url = getBaseURL() + LRObjectURL.INSTITUTION_MAPPING_URL + CommonConstants.SCOPES + StringPool.SLASH + getGroupId();
		url += StringPool.QUESTION + "filter=university" + URLEncoder.encode(" eq "+ universityId ,StandardCharsets.UTF_8);
		String response = omsbHttpConnector.executeGet(url, "", getHeaders());
		logger.info("url of instution mapping ?? " + url);
		logger.info("response of instution mapping ?? " + response);
		return response.contains("university");
	}
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind = "-")
	private DataflowService dataflowService;
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;
	
	@Reference(unbind = "-")
	private UserLocalService userLocalService;
	
	@Reference(unbind = "-")
	private ConfigurationProvider provider;
	
	@Reference
	private CountryLocalService countryLocalService;
	
	@Reference
	private ListTypeEntryLocalService listTypeEntryLocalService;
	
	@Reference
	private ListTypeDefinitionLocalService listTypeDefinitionLocalService;
	
	@Reference
	private ObjectDefinitionService objectDefinitionService;
	
	@Reference
	private ObjectEntryLocalService objectEntryLocalService;
	
	private static final Log logger = LogFactoryUtil.getLog(CaseDetailUtil.class);
}
