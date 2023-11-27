package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.service.util.CaseDetailUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.ByLawCondition;
import omsb.vehpc.equivalency.dto.web.ByLawRule;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationDetail;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentTypeItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.PersonalDetail;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyCertificateConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyStatusConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.EQUIVALENCY_ADD_REQUEST }, service = MVCActionCommand.class)
public class EquivalencyAddRequestMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("EquivalencyAddRequestMVCActionCommand >>>Invoked>>>");
		long stratTime = System.currentTimeMillis();
		LOGGER.info("strat time::" + stratTime);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fullName = ParamUtil.getString(uploadPortletRequest, "fullName");
		long nationality = ParamUtil.getLong(uploadPortletRequest, "nationality");
		String passportNumber = ParamUtil.getString(uploadPortletRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(uploadPortletRequest, "dateOfBirth");
		String email = ParamUtil.getString(uploadPortletRequest, "email");
		String mobileNumber = ParamUtil.getString(uploadPortletRequest, "cellphoneNumber");
		String profession = ParamUtil.getString(uploadPortletRequest, "profession");
		String otherProfession = ParamUtil.getString(uploadPortletRequest, "otherProfession");
		long personId = ParamUtil.getLong(uploadPortletRequest, "personId");
		long eQRequestId = ParamUtil.getLong(uploadPortletRequest, "equivalencyRequestId");
		String officialDocType = ParamUtil.getString(uploadPortletRequest, "officialDocType");
		long otherDocumentCount = ParamUtil.getLong(uploadPortletRequest, "otherDocumentCount");
		long certificateToBeEvaluatedCount = ParamUtil.getLong(uploadPortletRequest, "certificateToBeEvaluatedCount");
		long primarySpecialty = ParamUtil.getLong(uploadPortletRequest,"primarySpecialty");
		String dfrn = ParamUtil.getString(uploadPortletRequest, "dfrn");
		String verificationReportPaymentReceipt = ParamUtil.getString(uploadPortletRequest,
				"verificationReportPaymentReceipt");
		boolean isDraft = ParamUtil.getBoolean(actionRequest, "isDraft");
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		/**
		 * Create Update Person
		 */
		Person personPayload = new Person();
		personPayload.setLrUserId(themeDisplay.getUserId());
		personPayload.setPassportNumber(passportNumber);
		personPayload.setDateOfBirth(omsbCommonApi.convertDDMMYYYYDateToObjectDate(dateOfBirth));
		personPayload.setId(personId);

		PersonalDetail personalDetail = new PersonalDetail();
		personalDetail.setApplicantSurname(fullName);
		personalDetail.setEmail(email);
		personalDetail.setGivenNameAsPassport(fullName);
		personalDetail.setMobileNumber(mobileNumber);
		personalDetail.setNationalityCountryId(nationality);
		personalDetail.setProfession(profession);
		personalDetail.setPersonId(personId);
		personalDetail.setPrimarySpeciality(primarySpecialty);
		personalDetail.setProfessionOther(otherProfession); 

		personId = createUpdatePerson(themeDisplay.getScopeGroupId(), personPayload, headersInfo, objectMapper,
				personalDetail);

		ListTypeEntry entry = null;
		if (isDraft) {
			entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EQUIVALENCY_STATUS,
					EquivalencyStatusConstants.DRAFT_EMPLOYER_KEY, themeDisplay.getCompanyId());
		} else {
			entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EQUIVALENCY_STATUS,
					EquivalencyStatusConstants.CREATED_KEY, themeDisplay.getCompanyId());
			equivalencyUtil.sendEquivalencyNotification(themeDisplay, RoleNameConstants.VEHPC_ADMIN,
					OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_RAISE_NOTIFICATION);
		}

		long statusId = 0;
		if (Validator.isNotNull(entry)) {
			statusId = entry.getListTypeEntryId();
		}

		/**
		 * Create Equivalency request
		 */
		long equivalencyRequestId = 0;
		if (eQRequestId == 0) {
//			EquivalencyLevel equivalencyLevel = getSuggestedEquivalencyLevelByLawRules();
			equivalencyRequestId = processCreateEquivalencyRequest(actionRequest, themeDisplay, personId, statusId);

		} else {
			equivalencyRequestId = processUpdateEquivalencyRequest(actionRequest, themeDisplay, headersInfo, statusId,
					eQRequestId, uploadPortletRequest);

		}

		/**
		 * Add Payment Receipt Documents to Document Info Table
		 */
		DocumentInfo paymentReceiptFileUploadDetails = new DocumentInfo();
		paymentReceiptFileUploadDetails.setPersonId(personId);
		paymentReceiptFileUploadDetails.setEquivalencyRequestId(equivalencyRequestId);
		addPaymentReceiptDocuments(verificationReportPaymentReceipt, "paymentReceipt", uploadPortletRequest,
				themeDisplay.getScopeGroupId(), objectMapper, headersInfo, paymentReceiptFileUploadDetails,
				equivalencyRequestId);

		/**
		 * Add Other Documents to Document Info Table
		 */
		DocumentInfo otherDocumentFileUploadDetails = new DocumentInfo();
		otherDocumentFileUploadDetails.setPersonId(personId);
		otherDocumentFileUploadDetails.setEquivalencyRequestId(equivalencyRequestId);

		if (otherDocumentCount > 0) {
			addOtherDocuments(otherDocumentCount, uploadPortletRequest, themeDisplay, themeDisplay.getScopeGroupId(),
					objectMapper, headersInfo, otherDocumentFileUploadDetails, equivalencyRequestId);
		}

		/**
		 * Add Certificate to Evaluate documents to Document Info Table
		 */
		DocumentInfo certificateToEvaFileUploadDetails = new DocumentInfo();
		certificateToEvaFileUploadDetails.setPersonId(personId);
		certificateToEvaFileUploadDetails.setEquivalencyRequestId(equivalencyRequestId);
		if (certificateToBeEvaluatedCount > 0) {
			addCertificatesToEvaluatedDocuments(personId, certificateToBeEvaluatedCount, uploadPortletRequest,
					themeDisplay, objectMapper, headersInfo, certificateToEvaFileUploadDetails, equivalencyRequestId,isDraft,primarySpecialty);
		}

		/**
		 * Add Official request letter to Document Info Table
		 */
		DocumentInfo officialLetterFileUploadDetails = new DocumentInfo();
		officialLetterFileUploadDetails.setPersonId(personId);
		officialLetterFileUploadDetails.setDocumentType(officialDocType);
		officialLetterFileUploadDetails.setEquivalencyRequestId(equivalencyRequestId);
		addOfficialRequestLetterDocuments("officialRequestLetter", uploadPortletRequest, themeDisplay.getScopeGroupId(),
				objectMapper, headersInfo, officialLetterFileUploadDetails, equivalencyRequestId);

		/**
		 * Add Status created to Equivalency status table
		 */

		LOGGER.info("end time::" + (System.currentTimeMillis() - stratTime));
	}

	private long processUpdateEquivalencyRequest(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			Map<String, String> headersInfo, long statusId, long equivalencyRequestId,
			UploadPortletRequest uploadPortletRequest) {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			equivalencyRequestId = equivalencyUtil.updateEquivalencyRequest(equivalencyRequestId, statusId,
					actionRequest, themeDisplay);

			// Remove existing payment receipt documents
			FileItem[] items = uploadPortletRequest.getMultipartParameterMap().get("paymentReceipt");

			if (Validator.isNotNull(items) && items.length > 0 && !items[0].getFileName().isEmpty()) {

				String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
						themeDisplay.getScopeGroupId());

				equivalencyDocTypeURL = equivalencyDocTypeURL + StringPool.QUESTION + "filter=equivalencyRequestId"
						+ URLEncoder.encode(" eq " + equivalencyRequestId
								+ " and (equivalencyDocType eq 'Verification Report' or equivalencyDocType eq 'Payment Receipt')",
								OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);

				String equivalencyDocTypeResponse = oMSBHttpConnector.executeGet(equivalencyDocTypeURL, "",
						headersInfo);
				EquivalencyDocumentTypeItems equivalencyDocumentTypeItems = null;
				EquivalencyDocumentType equivalencyDocumentType = null;
				try {
					equivalencyDocumentTypeItems = objectMapper.readValue(equivalencyDocTypeResponse.toString(),
							new TypeReference<EquivalencyDocumentTypeItems>() {
							});
					if (Validator.isNotNull(equivalencyDocumentTypeItems)
							&& equivalencyDocumentTypeItems.getItems().size() > 0) {
						equivalencyDocumentType = equivalencyDocumentTypeItems.getItems().get(0);
					}
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

				// remove entry from "DOCUMENT_INFO_URL" by equivalencydocumenttypes id

				DocumentInfo documentInfo = null;
				if (Validator.isNotNull(equivalencyDocumentType)) {
					String documentInfoURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL,
							themeDisplay.getScopeGroupId());
					documentInfoURL = documentInfoURL + StringPool.QUESTION + "filter=equivalencyDocTypeId"
							+ URLEncoder.encode(" eq " + equivalencyDocumentType.getId(),
									OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
					String documentInfoResponse = oMSBHttpConnector.executeGet(documentInfoURL, "", headersInfo);

					DocumentInfoItems documentInfoItems = null;
					try {
						documentInfoItems = objectMapper.readValue(documentInfoResponse.toString(),
								new TypeReference<DocumentInfoItems>() {
								});
						if (Validator.isNotNull(documentInfoItems) && documentInfoItems.getItems().size() > 0) {
							documentInfo = documentInfoItems.getItems().get(0);
						}
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
				}

				// remove entry from document library by file entry id from document info
				// table.

				if (Validator.isNotNull(documentInfo)) {
					try {
						DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
								.deleteDLFileEntry(documentInfo.getFileEntryID());

						if (Validator.isNotNull(fileEntry)) {
							String deleteDocumentInfoURL = themeDisplay.getPortalURL() + LRObjectURL.DELETE_DOCINFO
									+ documentInfo.getId();
							oMSBHttpConnector.executeDelete(deleteDocumentInfoURL, headersInfo);

							String deleteEquivalencyDocTypeURL = themeDisplay.getPortalURL()
									+ LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
									+ documentInfo.getEquivalencyDocTypeId();
							oMSBHttpConnector.executeDelete(deleteEquivalencyDocTypeURL, headersInfo);
						}
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return equivalencyRequestId;
	}

	private long processCreateEquivalencyRequest(ActionRequest actionRequest, ThemeDisplay themeDisplay, long personId,
			long statusId) {
		long equivalencyRequestId = 0;
		equivalencyRequestId = equivalencyUtil.addEquivalencyRequest(personId, themeDisplay.getUserId(), statusId,
				actionRequest, themeDisplay);
		return equivalencyRequestId;
	}

	/**
	 * 
	 * @param siteId
	 * @param personPayload
	 * @param headersInfo
	 * @param objectMapper
	 * @param personalDetail
	 * @return
	 */
	private long createUpdatePerson(long groupId, Person personPayload, Map<String, String> headersInfo,
			ObjectMapper objectMapper, PersonalDetail newPersonalDetail) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		String personURL = StringPool.BLANK;
		String personPayloadString = StringPool.BLANK;
		String personRes = StringPool.BLANK;
		try {
			if (personPayload.getId() == 0) {
				personURL = generateScopeListURL(LRObjectURL.PERSON_URL, groupId);
				personPayloadString = objectMapper.writeValueAsString(personPayload);
				personRes = oMSBHttpConnector.executePost(personURL, personPayloadString, headersInfo);
			} else {
				personURL = omsbCommonApi.getBaseURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + personPayload.getId();
				personPayloadString = objectMapper.writeValueAsString(personPayload);
				personRes = oMSBHttpConnector.executePut(personURL, personPayloadString, headersInfo);
			}
			if (Validator.isNotNull(personRes)) {
				JSONObject personResJson = JSONFactoryUtil.createJSONObject(personRes);
				long personId = personResJson.getLong("id");
				newPersonalDetail.setPersonId(personId);
				String personDetailURL = StringPool.BLANK;
				String personalDetailResponse = StringPool.BLANK;
				try {
					personDetailURL = generateScopeListURL(LRObjectURL.PERSONAL_DETAIL_URL, groupId)
							+ "?filter=personId" + URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8);
					personalDetailResponse = oMSBHttpConnector.executeGet(personDetailURL, StringPool.BLANK,
							headersInfo);

					String personalDetailsUrl = StringPool.BLANK;
				
					if (Validator.isNotNull(personalDetailResponse)) {
						PersonalDetailItems personalDetailItems = CustomObjectMapperUtil
								.readValue(personalDetailResponse, PersonalDetailItems.class);
						if (Validator.isNotNull(personalDetailItems) && !personalDetailItems.getItems().isEmpty()
								&& personalDetailItems.getItems().size() > 0) {
							PersonalDetail personalDetails = personalDetailItems.getItems().get(0);
							personalDetails.setApplicantSurname(newPersonalDetail.getApplicantSurname());
							personalDetails.setEmail(newPersonalDetail.getEmail());
							personalDetails.setGivenNameAsPassport(newPersonalDetail.getGivenNameAsPassport());
							personalDetails.setMobileNumber(newPersonalDetail.getMobileNumber());
							personalDetails.setNationalityCountryId(newPersonalDetail.getNationalityCountryId());
							personalDetails.setProfession(newPersonalDetail.getProfession());
							personalDetails.setPersonId(newPersonalDetail.getPersonId());
							personalDetails.setPrimarySpeciality(newPersonalDetail.getPrimarySpeciality());
							personalDetails.setProfessionOther(newPersonalDetail.getProfessionOther());
							String personalDetailsPayloadString = objectMapper.writeValueAsString(personalDetails);
							personalDetailsUrl = omsbCommonApi.getBaseURL() + LRObjectURL.PERSONAL_DETAILS
									+ personalDetails.getId();
							personalDetailResponse = oMSBHttpConnector.executePut(personalDetailsUrl,
									personalDetailsPayloadString, headersInfo);
						
						
						
						} else {
							String personalDetailsPayloadString = objectMapper.writeValueAsString(newPersonalDetail);
							personalDetailsUrl = personDetailURL = generateScopeListURL(LRObjectURL.PERSONAL_DETAIL_URL,
									groupId);
							oMSBHttpConnector.executePost(personDetailURL, personalDetailsPayloadString, headersInfo);
						}
					}
				} catch (UnsupportedEncodingException e) {
					LOGGER.error(e.getMessage());
				}
				return personId;
			}
		} catch (JsonProcessingException | NullPointerException | JSONException e) {
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public static List<DLFileEntry> fileUpload(UploadPortletRequest uploadPortletRequest, String folderName,
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
		List<DLFileEntry> fileEntries = new ArrayList<>();
		FileItem[] items = uploadPortletRequest.getMultipartParameterMap().get(fileParamName);
		if(Validator.isNotNull(items)) {
			for (FileItem fileItem : items) {
				if (Validator.isNotNull(fileItem) && Validator.isNotNull(fileItem.getFileName())
						&& !fileItem.getFileName().isEmpty()) {
					try {
						String title = System.currentTimeMillis() + fileItem.getFileName();

						File file = fileItem.getStoreLocation();
						InputStream inputStream = new FileInputStream(file);
						DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK,
								themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
								folderId, title, fileItem.getContentType(), title, StringPool.BLANK, StringPool.BLANK,
								StringPool.BLANK, 0L, null, file, inputStream, file.length(), null, null, serviceContext);
						fileEntries.add(dlFileEntry);
					} catch (PortalException e) {
						LOGGER.error(e.getMessage());

					}
				}
			}
		}
		return fileEntries;
	}

	public static Folder getFolder(long groupId, String folderName) {
		try {
			return DLAppLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public static Folder createNewFolder(UploadPortletRequest uploadPortletRequest, String folderName) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					uploadPortletRequest);
			return DLAppLocalServiceUtil.addFolder(folderName, themeDisplay.getUserId(),
					serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName,
					ROOT_FOLDER_DESCRIPTION, serviceContext);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL()
				+ equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}

	private void addPaymentReceiptDocuments(String docType, String officialRequestLetter,
			UploadPortletRequest uploadPortletRequest, long groupId, ObjectMapper objectMapper,
			Map<String, String> headersInfo, DocumentInfo paymentReceiptFileUploaddetails, long equivalencyRequestId)
			throws IOException {
		try {
			for (DLFileEntry fileEntry : fileUpload(uploadPortletRequest, "Paymnet", officialRequestLetter)) {

				String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL, groupId);
				EquivalencyDocumentType officialRequestLetterEqDocType = new EquivalencyDocumentType();
				officialRequestLetterEqDocType.setEquivalencyDocType(docType);
				officialRequestLetterEqDocType.setEquivalencyRequestId(equivalencyRequestId);
				String eqDocTypeofficialRequestLetterEqDocTypePayload = objectMapper
						.writeValueAsString(officialRequestLetterEqDocType);
				String officialRequestLetterDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL,
						eqDocTypeofficialRequestLetterEqDocTypePayload, headersInfo);
				JSONObject officialRequestLetterDocTypeResponseJson = JSONFactoryUtil
						.createJSONObject(officialRequestLetterDocTypeResponse);
				paymentReceiptFileUploaddetails
						.setEquivalencyDocTypeId(officialRequestLetterDocTypeResponseJson.getInt("id"));
				paymentReceiptFileUploaddetails.setDocumentType("paymentReceipt");
				paymentReceiptFileUploaddetails.setFileEntryID(fileEntry.getFileEntryId());
				try {
					String certificateToEvafileUploadDetailPayload2 = objectMapper
							.writeValueAsString(paymentReceiptFileUploaddetails);
					String officialRequestfileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL,
							groupId);
					oMSBHttpConnector.executePost(officialRequestfileUploadDetailURL,
							certificateToEvafileUploadDetailPayload2, headersInfo);
					LOGGER.info("Official Request Letter File Uploaded>>>>>>>>>>>>>");
				} catch (JsonProcessingException e) {
					LOGGER.error(e.getMessage());
				}
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private void addOtherDocuments(long noOfDocument, UploadPortletRequest uploadPortletRequest,
			ThemeDisplay themeDisplay, long siteId, ObjectMapper objectMapper, Map<String, String> headersInfo,
			DocumentInfo OtherDocumentFileUploadDetails, long equivalencyRequestId)
			throws JsonProcessingException, JSONException {
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
				themeDisplay.getScopeGroupId());
		for (int i = 1; i <= (noOfDocument); i++) {
			String documentType = ParamUtil.getString(uploadPortletRequest, "documentType" + i);

			if (Validator.isNotNull(documentType) && !documentType.isEmpty()) {
				Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
				FileItem[] attachmentFileNos = files.get("attachmentFile" + i);
				if (attachmentFileNos.length > 0) {
					// long fileEntryId = addDocument(uploadPortletRequest, themeDisplay, fileName,
					// childfolderOtherDocument);
					long fileEntryId = 0;
					try {
						fileEntryId = fileUpload(uploadPortletRequest, "Other Document", "attachmentFile" + i).get(0)
								.getFileEntryId();
						OtherDocumentFileUploadDetails.setFileEntryID(fileEntryId);
					} catch (PortalException | IOException e) {
						LOGGER.error(e.getMessage());
					}
					try {

						if (fileEntryId > 0) {

							EquivalencyDocumentType otherDocumentEqDocType = new EquivalencyDocumentType();
							otherDocumentEqDocType.setEquivalencyDocType("Other Documents");
							otherDocumentEqDocType.setEquivalencyRequestId(equivalencyRequestId);
							otherDocumentEqDocType.setQualification(documentType);
							String eqDocTypeOtherDocumentPayload = objectMapper
									.writeValueAsString(otherDocumentEqDocType);
							String otherDocumentDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL,
									eqDocTypeOtherDocumentPayload, headersInfo);
//						Object otherDocTypeObject = supportingvalues.get("otherDocType");
//						String otherDocType = null;
//						if (Validator.isNotNull(otherDocTypeObject)) {
//							otherDocType = otherDocTypeObject.toString();
//						}
							JSONObject otherDocumentDocTypeResponseJson = JSONFactoryUtil
									.createJSONObject(otherDocumentDocTypeResponse);
							OtherDocumentFileUploadDetails
									.setEquivalencyDocTypeId(otherDocumentDocTypeResponseJson.getInt("id"));
							OtherDocumentFileUploadDetails.setDocumentType("otherDocuments");
							OtherDocumentFileUploadDetails.setComponentId(2);
//						if (optionValue.equalsIgnoreCase("others")) {
//							docsobject.put("otherDocType", otherDocType);
//						}

							String otherDocumentFileUploadDetailsPayload = objectMapper
									.writeValueAsString(OtherDocumentFileUploadDetails);
							String otherDocumentfileUploadDetailURL = generateScopeListURL(
									LRObjectURL.DOCUMENT_INFO_URL, siteId);
							LOGGER.info("otherDocumentfileUploadDetailURL :" + otherDocumentfileUploadDetailURL);
							oMSBHttpConnector.executePost(otherDocumentfileUploadDetailURL,
									otherDocumentFileUploadDetailsPayload, headersInfo);
						}
					} catch (JsonProcessingException e) {
						LOGGER.error(e.getMessage());
					}
				}
			}
		}
	}

	private void addCertificatesToEvaluatedDocuments(long personId, long noOfCertificatesDocument,
			UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay, ObjectMapper objectMapper,
			Map<String, String> headersInfo, DocumentInfo certificateToEvaFileUploadDetails, long equivalencyRequestId,boolean isDraft,long primarySpecialty)
			throws JsonProcessingException, JSONException {
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,
				themeDisplay.getScopeGroupId());
		
		for (int i = 1; i <= (noOfCertificatesDocument); i++) {

			String qualification = ParamUtil.getString(uploadPortletRequest, "qualification" + i);
			String documentInfoId = ParamUtil.getString(uploadPortletRequest, "documentInfoId" + i);
			long institution = ParamUtil.getLong(uploadPortletRequest, "institution"+i);
			long graduationDuration = ParamUtil.getLong(uploadPortletRequest, "graduationDuration"+i);
			boolean docCheckbox = ParamUtil.getBoolean(uploadPortletRequest, "docCheckbox" + i);
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
				String eqDocTypeCertificateToEvaPayload = objectMapper
						.writeValueAsString(certificatesToEvaEqDocType);
				String certificateToEvaDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL,
						eqDocTypeCertificateToEvaPayload, headersInfo);
				
				JSONObject certificateToEvaDocTypeResponseJson = JSONFactoryUtil.createJSONObject(certificateToEvaDocTypeResponse);
				certificateToEvaFileUploadDetails.setEquivalencyDocTypeId(certificateToEvaDocTypeResponseJson.getInt("id"));
				
				if (!(Validator.isNotNull(documentInfoId) && Long.valueOf(documentInfoId) > 0)) {
					String issuedFrom = ParamUtil.getString(uploadPortletRequest, "issuedFrom" + i);
					int issuedFromCountryId =  Integer.parseInt(issuedFrom);
					String issueDate = ParamUtil.getString(uploadPortletRequest, "issueDate" + i);
					try {
						EducationDetail educationDetail = new EducationDetail();
						educationDetail.setIssuingAuthorityCountryId(issuedFromCountryId);
						educationDetail.setQualificationAttained(qualification);
						/*
						 * if (Validator.isNotNull(qualification) && !qualification.isBlank()) {
						 * educationDetail.setQualificationAttained(
						 * getQualificationNameByKey(OmsbVehpcEquivalencyWebPortletKeys.
						 * PL_QUALIFICATION_ERC, qualification, themeDisplay)); } else {
						 * 
						 * }
						 */
						String suggestedEquivalencyLevel = getSuggestedEquivalencyLevelByLawRules(issuedFrom,qualification,graduationDuration,primarySpecialty,themeDisplay);
						String convertedIssueDate =omsbCommonApi.convertDDMMYYYYDateToObjectDate(issueDate);
						if(Validator.isNull(convertedIssueDate)) {
							convertedIssueDate =omsbCommonApi.convertNewDDMMYYYYDateToObjectDate(issueDate);
						}
						educationDetail.setQualificationConferredDate(convertedIssueDate);
						educationDetail.setEquivalencyRequestId(equivalencyRequestId);
						educationDetail.setDurationInYears(graduationDuration);
	
						ListTypeEntry institutionListTypeEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId(institution);
						if(Validator.isNotNull(institutionListTypeEntry)) {
							educationDetail.setIssuingAuthorityName(institutionListTypeEntry.getKey());
						}
						educationDetail.setSuggestedEquivalencyLevel(suggestedEquivalencyLevel);
						EducationDetail detail = equivalencyUtil.addEducationDetail(personId, 0, educationDetail, "",themeDisplay.getScopeGroupId());
						if (Validator.isNotNull(detail)) {
							classRefId = detail.getId();
						}
					} catch (Exception e) {
						LOGGER.info("Error while adding education details, " + e);
					}

					Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
					if (Validator.isNotNull(files.get("certificatetbl" + i))) {
						try {
							certificateToEvaFileUploadDetails.setFileEntryID(fileUpload(uploadPortletRequest,
									"Certificate to Be Evaluated", "certificatetbl" + i).get(0).getFileEntryId());
						} catch (PortalException | IOException e) {
							LOGGER.error(e.getMessage());
						}

						// Add entry to Equivalency doc type table
						certificateToEvaFileUploadDetails
								.setEquivalencyDocTypeId(certificateToEvaDocTypeResponseJson.getInt("id"));

						// Add entry to Document Info table
						certificateToEvaFileUploadDetails.setDocumentType("Qualification");
						certificateToEvaFileUploadDetails.setComponentId(2);
						certificateToEvaFileUploadDetails.setComponentClassRefId(classRefId);
						try {
							String certificateToEvafileUploadDetailPayload = objectMapper
									.writeValueAsString(certificateToEvaFileUploadDetails);
							oMSBHttpConnector.executePost(certificateToEvafileUploadDetailURL,
									certificateToEvafileUploadDetailPayload, headersInfo);
						} catch (JsonProcessingException e) {
							LOGGER.error(e.getMessage());
						}
						
						
					}
				} else {
					LOGGER.info("INSIDE CALLING else index is ? "+i+"  and documentInfoId is ?? "+documentInfoId );
					String documentUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + documentInfoId; 
					String documentResponse = omsbCommonApi.getData(documentUrl);
					DocumentInfo documentInfo =  CustomObjectMapperUtil.readValue(documentResponse, DocumentInfo.class);
					
					DocumentInfo documentInfoWrite = new DocumentInfo();
					documentInfoWrite.setEquivalencyRequestId(equivalencyRequestId);
					documentInfoWrite.setComponentClassRefId(documentInfo.getComponentClassRefId());
					documentInfoWrite.setEquivalencyDocTypeId(certificateToEvaDocTypeResponseJson.getInt("id"));
					documentInfoWrite.setdFFileName(documentInfo.getdFFileName());
					documentInfoWrite.setFileEntryID(documentInfo.getFileEntryID());
					documentInfoWrite.setComponentId(2);
					documentInfoWrite.setPersonId(documentInfo.getPersonId());
					documentInfoWrite.setDocumentType(OmsbVehpcEquivalencyWebPortletKeys.QUALIFICATION);
					
					String documentInfoMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoWrite, null);
					String documentInfoMapperUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
					oMSBHttpConnector.executePost(documentInfoMapperUrl, documentInfoMapper, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				}
			}
		}
	}

	private void addOfficialRequestLetterDocuments(String officialRequestLetter,
			UploadPortletRequest uploadPortletRequest, long groupId, ObjectMapper objectMapper,
			Map<String, String> headersInfo, DocumentInfo certificateToEvaFileUploadDetails, long equivalencyRequestId)
			throws IOException {
		try {

			for (DLFileEntry fileEntry : fileUpload(uploadPortletRequest, "Official Request Letter",
					officialRequestLetter)) {
				certificateToEvaFileUploadDetails.setDocumentType("officialRequestLetter");
				certificateToEvaFileUploadDetails.setFileEntryID(fileEntry.getFileEntryId());
				try {

					String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL, groupId);
					EquivalencyDocumentType officialRequestLetterEqDocType = new EquivalencyDocumentType();
					officialRequestLetterEqDocType.setEquivalencyDocType("Official Request Letter");
					officialRequestLetterEqDocType.setEquivalencyRequestId(equivalencyRequestId);
					String eqDocTypeofficialRequestLetterEqDocTypePayload = objectMapper
							.writeValueAsString(officialRequestLetterEqDocType);
					String officialRequestLetterDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL,
							eqDocTypeofficialRequestLetterEqDocTypePayload, headersInfo);
					JSONObject officialRequestLetterDocTypeResponseJson = JSONFactoryUtil
							.createJSONObject(officialRequestLetterDocTypeResponse);
					certificateToEvaFileUploadDetails
							.setEquivalencyDocTypeId(officialRequestLetterDocTypeResponseJson.getInt("id"));

					String certificateToEvafileUploadDetailPayload2 = objectMapper
							.writeValueAsString(certificateToEvaFileUploadDetails);
					String officialRequestfileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL,
							groupId);
					oMSBHttpConnector.executePost(officialRequestfileUploadDetailURL,
							certificateToEvafileUploadDetailPayload2, headersInfo);
					LOGGER.info("Official Request Letter File Uploaded>>>>>>>>>>>>>");
				} catch (JsonProcessingException e) {
					LOGGER.error(e.getMessage());
				}
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
	}
	private String getSuggestedEquivalencyLevelByLawRules(String issuedFrom, String qualification, long graduationDuration, long primarySpecialty,ThemeDisplay themeDisplay) {
		boolean ruleValue = false;
		List<ByLawRule> byLawRuleList =equivalencyUtil.fetchAllRulesByModuleName(EquivalencyCertificateConstants.EQUIVALENCY,themeDisplay);
		if(Validator.isNotNull(byLawRuleList)) {
			for( ByLawRule byLawRule: byLawRuleList) {
				String byLawConditionIds = byLawRule.getByLawConditionIds();
				boolean isMatchAll = byLawRule.isMatchAll();
				if(Validator.isNotNull(byLawConditionIds)) {
					String[] byLawConditionIdstr=byLawConditionIds.split(",");
					
					if(isMatchAll) {
						 ruleValue = checkAllRuleApplicable(byLawConditionIdstr,issuedFrom, qualification, graduationDuration, primarySpecialty, themeDisplay);
						 
					}else {
						 ruleValue = checkSomeRuleApplicable(byLawConditionIdstr,issuedFrom, qualification, graduationDuration, primarySpecialty, themeDisplay);
					}	
				}
				if(ruleValue){
					return byLawRule.getEquivalencyLevel();
				}
			}
			
		}
		return StringPool.BLANK;
	}

	private boolean checkSomeRuleApplicable(String[] byLawConditionIdstr, String issuedFrom, String qualification,
			long graduationDuration, long primarySpecialty, ThemeDisplay themeDisplay) {
		for(String byLawConditionId: byLawConditionIdstr) {
			ByLawCondition byLawCondition = equivalencyUtil.getByLawConditionById(byLawConditionId,themeDisplay);
			if(Validator.isNotNull(byLawCondition)) {
				if(byLawCondition.getParameterName().equals("Country")) {
					long countryId = Long.valueOf(issuedFrom);
					Country country = null;
					if (countryId > 0) {
						try {
							country = countryLocalService.getCountry(countryId);
						} catch (PortalException e) {
							LOGGER.error("Exception while getting the country ", e);
						}
					}
					if (Validator.isNotNull(country)) {
						if(byLawCondition.getConditionValue().toLowerCase().contains(country.getName().toLowerCase())) {
							return true;
						}
					}
					
				}else if(byLawCondition.getParameterName().equals("Qualification")) {
					if(byLawCondition.getConditionValue().contains(qualification)) {
						return true;
					}
				}else if(byLawCondition.getParameterName().equals("Speciality")) {
					ListTypeEntry specialityListTypeEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId(primarySpecialty);
					if(Validator.isNotNull(specialityListTypeEntry)) {
						if(byLawCondition.getConditionValue().contains(specialityListTypeEntry.getKey())) {
							return true;
						}
					}
				}else if(byLawCondition.getParameterName().equals("Duration")) {
					if(Validator.isNotNull(graduationDuration)) {
						if(byLawCondition.getConditionValue().contains(String.valueOf(graduationDuration))) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean checkAllRuleApplicable(String[] byLawConditionIdstr,String issuedFrom, String qualification, long graduationDuration, long primarySpecialty,ThemeDisplay themeDisplay) {
		for(String byLawConditionId: byLawConditionIdstr) {
			ByLawCondition byLawCondition = equivalencyUtil.getByLawConditionById(byLawConditionId,themeDisplay);
			if(Validator.isNotNull(byLawCondition)) {
				if(byLawCondition.getParameterName().equals("Country")) {
					long countryId = Long.valueOf(issuedFrom);
					Country country = null;
					if (countryId > 0) {
						try {
							country = countryLocalService.getCountry(countryId);
						} catch (PortalException e) {
							LOGGER.error("Exception while getting the country ", e);
						}
					}
					if (Validator.isNotNull(country)) {
						if(!byLawCondition.getConditionValue().toLowerCase().contains(country.getName().toLowerCase())) {
							return false;
						}
					}
					
				}else if(byLawCondition.getParameterName().equals("Qualification")) {
					if(!byLawCondition.getConditionValue().contains(qualification)) {
						return false;
					}
				}else if(byLawCondition.getParameterName().equals("Speciality")) {
					ListTypeEntry specialityListTypeEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId(primarySpecialty);
					if(Validator.isNull(specialityListTypeEntry)) {
						return false;
					}else if(!byLawCondition.getConditionValue().contains(specialityListTypeEntry.getKey())) {
						return false;
					}
				}else if(byLawCondition.getParameterName().equals("Duration")) {
					if(Validator.isNotNull(graduationDuration)) {
						if(!byLawCondition.getConditionValue().contains(String.valueOf(graduationDuration))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private String getQualificationNameByKey(String erc, String key, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(erc, key, themeDisplay.getCompanyId());
		String qualificationName = "";
		if (Validator.isNotNull(entry)) {
			qualificationName = entry.getName(themeDisplay.getLocale());
		}
		LOGGER.info("qualificationName in getQualificationNameByKey " + qualificationName);
		return qualificationName;
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;

	@Reference(unbind = "_")
	private CaseDetailUtil caseDetailUtil;

	@Reference(unbind = "_")
	private EquivalencyUtil equivalencyUtil;
	
	@Reference
	private CountryLocalService countryLocalService;

	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyAddRequestMVCActionCommand.class);
}
