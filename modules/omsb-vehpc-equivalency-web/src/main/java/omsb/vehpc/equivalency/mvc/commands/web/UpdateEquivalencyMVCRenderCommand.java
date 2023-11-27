package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyAllRequests;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificate;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificateItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.PersonalDetail;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.dto.web.ProfessionSpecialtyMapping;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.UPDATE_EQUIVALENCY }, service = MVCRenderCommand.class)
public class UpdateEquivalencyMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

			long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");

			/* Get Equivalency Request details */
			String eqRequestResponse = omsbHttpConnector.executeGet(
					omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
					StringPool.BLANK, headersInfo);

			EquivalencyAllRequests equivalencyAllRequests = new EquivalencyAllRequests();

			/* Prepare equivalency Java object */
			JSONObject jsoneqRequestResponseObj = JSONFactoryUtil.createJSONObject(eqRequestResponse);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			String personId = null;
			try {
				EquivalencyRequest equivalencyRequest = objectMapper.readValue(jsoneqRequestResponseObj.toString(),
						new TypeReference<EquivalencyRequest>() {
						});
				personId = jsoneqRequestResponseObj.getString("personId");

				if (equivalencyRequest.getEquivalencyStatusId() > 0) {
					ListTypeEntry eqStatusListTypeEntry = ListTypeEntryLocalServiceUtil
							.fetchListTypeEntry(equivalencyRequest.getEquivalencyStatusId());
					if (Validator.isNotNull(eqStatusListTypeEntry)) {
						equivalencyAllRequests.setStatus(eqStatusListTypeEntry.getName(themeDisplay.getLocale()));
						equivalencyAllRequests.setStatusKey(eqStatusListTypeEntry.getKey());
					}
				}
				equivalencyAllRequests.setEquivalencyRequestId(equivalencyRequest.getId());
			} catch (JsonProcessingException e) {
				LOGGER.error(e.getMessage());
			}

			/* Get Person Data */
			String dob = null;
			String passportNumber = null;

			try {
				String getPersonURL = equivalencyUtil.generateScopeListURL(LRObjectURL.PERSON_URL,
						themeDisplay.getScopeGroupId());
				String finderQueryPerson = StringPool.QUESTION + "filter=id" + URLEncoder.encode(
						" eq '" + personId + "'", OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
				String personResponse = omsbHttpConnector.executeGet(getPersonURL + finderQueryPerson, "", headersInfo);
				JSONObject personJsonObj = JSONFactoryUtil.createJSONObject(personResponse);
				JSONArray getPersonJsonArrayResponse = personJsonObj
						.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
				SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);
				/*
				 * Date dateOB = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
				 * .parse(getPersonJsonArrayResponse.getJSONObject(0).getString("dateOfBirth"));
				 */
				dob = sdf.format(new Date());

				passportNumber = getPersonJsonArrayResponse.getJSONObject(0).getString("passportNumber");
			} catch (UnsupportedEncodingException | JSONException e) {
				LOGGER.error(e.getMessage());
			}

			/* Get Person Details Data */
			String getPersonDetailsURL = equivalencyUtil.generateScopeListURL(
					LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL + "?filter=personId%20eq%20" + personId,
					themeDisplay.getScopeGroupId());
			String personDetailRes = omsbHttpConnector.executeGet(getPersonDetailsURL, "", headersInfo);

			PersonalDetailItems personalDetailsItems = CustomObjectMapperUtil.readValue(personDetailRes,
					PersonalDetailItems.class);

			if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
				PersonalDetail personalDetails = personalDetailsItems.getItems().get(0);

				ListTypeEntry professionListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC, personalDetails.getProfession().trim(),
						themeDisplay.getCompanyId());
				if(Validator.isNotNull(professionListTypeEntry)) {
					List<ListTypeEntry> specialtyList = new ArrayList<>();
					String proffesion = professionListTypeEntry.getName(themeDisplay.getLocale());
					String professionKey = professionListTypeEntry.getKey();
					personalDetails.setProfession(proffesion);
					personalDetails.setProfessionKey(professionKey);
					
					List<ProfessionSpecialtyMapping> professionSpecialtyMappingList = equivalencyUtil.getProfessionSpecialtyMappingListByProfessionKey(professionListTypeEntry.getListTypeEntryId(),themeDisplay);
					if (Validator.isNotNull(professionSpecialtyMappingList) && professionSpecialtyMappingList.size() > 0) {
						for(ProfessionSpecialtyMapping professionalSpecialtyMapping : professionSpecialtyMappingList) {
							ListTypeEntry specialtyListTypeEntry = omsbCommonApi.getListTypeEntryBylistTypeEntryId( professionalSpecialtyMapping.getSpeciality());
							if(Validator.isNotNull(specialtyListTypeEntry)) {
								specialtyList.add(specialtyListTypeEntry);
							}
						}
					}
					renderRequest.setAttribute("specialtyList", specialtyList);
				}
				
				personalDetails.setDateOfBirth(dob);
				personalDetails.setPassportNumber(passportNumber);
				personalDetails.setPersonId(Long.parseLong(personId));
				renderRequest.setAttribute("personalDetail", personalDetails);
			}
			
			/* Get Qualification pickList */
			try {
				ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode("PL_Qualification_ERC",
								PortalUtil.getDefaultCompanyId());
				renderRequest.setAttribute("qualificationList",
						ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			}
			/* Get Document Type pickList */
			try {
				ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode(
								OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, PortalUtil.getDefaultCompanyId());
				renderRequest.setAttribute("documentTypeList",
						ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			}

			/* Get EQ Certificate Details */
			EquivalencyCertificate certificate = getEquivalencyCertificateByEqRequest(themeDisplay,
					equivalencyRequestId);
			if (Validator.isNotNull(certificate)) {
				renderRequest.setAttribute("certificateName", certificate.getFileName());
				renderRequest.setAttribute("certificateURL", getFileURL(Long.valueOf(certificate.getFileEntryId())));
			}

			/* Get EQ Documents Info by equivalencyRequestId */
			String documentInfoResponse = omsbHttpConnector.executeGet(omsbCommonApi.getBaseURL()
					+ LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + themeDisplay.getScopeGroupId()
					+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId, StringPool.BLANK, headersInfo);
			try {
				JSONObject documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResponse);
				JSONArray itemsArray = documentInfoJsonObj.getJSONArray("items");
//				DocumentInfoItems documentInfoItemsPojo = CustomObjectMapperUtil.readValue(documentInfoResponse,
//						DocumentInfoItems.class);
				List<DocumentInfo> documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
						new TypeReference<List<DocumentInfo>>() {
						});

				List<DocumentInfo> otherDocumentList = new ArrayList<>();
				List<DocumentInfo> officialReqeustDocumentList = new ArrayList<>();
				List<DocumentInfo> evaluatedDocumentList = new ArrayList<>();
				List<DocumentInfo> paymentDocumentList = new ArrayList<>();
				
				for (int i = 0; i < documentInfoItemsList.size(); i++) {
					DocumentInfo info = new DocumentInfo();
					info.setId(documentInfoItemsList.get(i).getId());
					info.setFileEntryID(documentInfoItemsList.get(i).getFileEntryID());
					String key = getEqDocumentQualificationTypeById(themeDisplay,
							documentInfoItemsList.get(i).getEquivalencyDocTypeId());
					String caseRequestFileUrl = equivalencyUtil
							.getFileURL(documentInfoItemsList.get(i).getFileEntryID());
					info.setDocumentUrl(caseRequestFileUrl);
					if (documentInfoItemsList.get(i).getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.OTHER_DOCUMENTS_TYPE)) {
						info.setDocumentType(getEqDocumentTypeNameByKey(
								OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, key, themeDisplay));
						otherDocumentList.add(info);
					} else if (documentInfoItemsList.get(i).getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.OFFICIAL_REQUEST_DOCUMENT_TYPE)) {
						officialReqeustDocumentList.add(info);
					} else if (documentInfoItemsList.get(i).getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ETBA_DOCUMENTS_TYPE)) {
						info.setDocumentType(getEqDocumentTypeNameByKey(
								OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC, key, themeDisplay));
						EducationalDetailItem item = equivalencyUtil.getEducationDetailById(
								documentInfoItemsList.get(i).getComponentClassRefId(), themeDisplay);
						if (Validator.isNotNull(item)) {
							info.setDocumentType(item.getQualificationAttained());
							info.setDocumentTypeId(key);
							if (Validator.isNotNull(item.getIssuingAuthorityCountryId())
									&& item.getIssuingAuthorityCountryId() > 0) {
								Country issuingAuthorityCountry = countryLocalService
										.getCountry(item.getIssuingAuthorityCountryId());
								if(Validator.isNotNull(issuingAuthorityCountry)) {
									info.setIssuingAuthorityCountryName(issuingAuthorityCountry.getName(themeDisplay.getLocale()));
								}
							}
						}
						evaluatedDocumentList.add(info);
					} else if (documentInfoItemsList.get(i).getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.PAYMENT_RECEIPT_DOCUMENTS_TYPE)) {
						String docType = getEqDocumentTypeById(themeDisplay,
								documentInfoItemsList.get(i).getEquivalencyDocTypeId());
						info.setDocumentType(docType);
						long fileEntryId = documentInfoItemsList.get(i).getFileEntryID();
						if (Validator.isNotNull(fileEntryId)) {
							info.setFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId).getFileName());
						}
						paymentDocumentList.add(info);
					}
				}
				DocumentInfo officialDocument = null;
				if (Validator.isNotNull(officialReqeustDocumentList) && !officialReqeustDocumentList.isEmpty()) {
					officialDocument = officialReqeustDocumentList.get(0);
				}
				DocumentInfo paymentDocument = null;
				if (Validator.isNotNull(paymentDocumentList) && paymentDocumentList.size()>0) {
					paymentDocument = paymentDocumentList.get(0);
					renderRequest.setAttribute("paymentDocumentList", paymentDocumentList);
					renderRequest.setAttribute("paymentDocument", paymentDocument);
				}else {
					List<DocumentInfo> caseReportDocumentList = equivalencyUtil.getCaseReportListByPersonId(personId,themeDisplay);
					DocumentInfo caseReportDocument = new DocumentInfo();
					if (Validator.isNotNull(caseReportDocumentList) && caseReportDocumentList.size()>0) {
						caseReportDocument = caseReportDocumentList.get(0);
						renderRequest.setAttribute("caseReportDocument", caseReportDocument);
						renderRequest.setAttribute("caseReportDocumentList", caseReportDocumentList);
					}
				}
				
				renderRequest.setAttribute("otherDocumentList", otherDocumentList);
				renderRequest.setAttribute("officialReqeustDocument", officialDocument);
				renderRequest.setAttribute("evaluatedDocumentList", evaluatedDocumentList);
				
			} catch (JsonProcessingException | PortalException e) {
				LOGGER.error(e.getMessage());
			}

//			renderRequest.setAttribute("equivalencyRequest", equivalencyAllRequests);
			renderRequest.setAttribute("dateOfBirth", dob);
			renderRequest.setAttribute("passportNumber", passportNumber);
			renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);

			/* Get Coutry List */
			List<Country> countries = countryLocalService.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			renderRequest.setAttribute("allNationalities", countries);

			/* Get Profesion picklist */
			try {
				ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode("PL_Profession_ERC",
								PortalUtil.getDefaultCompanyId());
				renderRequest.setAttribute("professionList",
						ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId()));
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		} catch (JSONException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return EquivalencyJSPPathConstants.UPDATE_EQUIVALECY_JSP;
	}

	private String getEqDocumentQualificationTypeById(ThemeDisplay themeDisplay, long eqDocTypeId) {
		String docType = "";
		String equivalencyDocTypeUrl = themeDisplay.getPortalURL() + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
				+ eqDocTypeId;
		String equivalencyDocTypeResponse = omsbCommonApi.getData(equivalencyDocTypeUrl);
		LOGGER.info("equivalencyDocTypeResponse::::equivalencyDocTypeResponse::::" + equivalencyDocTypeResponse);
		EquivalencyDocumentType equivalencyDocumentType = CustomObjectMapperUtil.readValue(equivalencyDocTypeResponse,
				EquivalencyDocumentType.class);
		if (Validator.isNotNull(equivalencyDocumentType)
				&& Validator.isNotNull(equivalencyDocumentType.getEquivalencyDocType())
				&& !equivalencyDocumentType.getEquivalencyDocType().isEmpty()) {
			docType = equivalencyDocumentType.getQualification();
		}
		LOGGER.info("Doc Type :::::::" + docType);
		return docType;
	}

	private String getEqDocumentTypeById(ThemeDisplay themeDisplay, long eqDocTypeId) {
		String docType = "";
		String equivalencyDocTypeUrl = themeDisplay.getPortalURL() + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
				+ eqDocTypeId;
		String equivalencyDocTypeResponse = omsbCommonApi.getData(equivalencyDocTypeUrl);
		LOGGER.info("equivalencyDocTypeResponse::::equivalencyDocTypeResponse::::" + equivalencyDocTypeResponse);
		EquivalencyDocumentType equivalencyDocumentType = CustomObjectMapperUtil.readValue(equivalencyDocTypeResponse,
				EquivalencyDocumentType.class);
		if (Validator.isNotNull(equivalencyDocumentType)
				&& Validator.isNotNull(equivalencyDocumentType.getEquivalencyDocType())
				&& !equivalencyDocumentType.getEquivalencyDocType().isEmpty()) {
			docType = equivalencyDocumentType.getEquivalencyDocType();
		}
		LOGGER.info("Doc Type :::::::" + docType);
		return docType;
	}

	private String getEqDocumentTypeNameByKey(String erc, String key, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(erc, key, themeDisplay.getCompanyId());
		String documentType = "";
		if (Validator.isNotNull(entry)) {
			documentType = entry.getName(themeDisplay.getLocale());
		}
		return documentType;
	}

	public String getCertificateNameFromDocInfoId(long documenInfoId, ThemeDisplay themeDisplay) {
		String documentInfoUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.DELETE_DOCINFO.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.FORWARD_SLASH + documenInfoId;
		String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);
		LOGGER.info(documenInfoId + "  , documentInfoUrl  " + documentInfoUrl
				+ " : getCertificateNameFromDocInfoId ::::documentInfoResponse::::" + documentInfoResponse);
		DocumentInfo documentInfo = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
		documentInfo.getEquivalencyDocTypeId();
		if (documentInfo.getEquivalencyDocTypeId() > 0) {
			String eqdocumentTypeUrl = themeDisplay.getPortalURL()
					+ LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK.replace("{scope-id}",
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.FORWARD_SLASH + documentInfo.getEquivalencyDocTypeId();
			String eqdocumentTypeResponse = omsbCommonApi.getData(eqdocumentTypeUrl);
			LOGGER.info(eqdocumentTypeUrl + " : getCertificateNameFromDocInfoId ::::eqdocumentTypeResponse::::"
					+ eqdocumentTypeResponse);
			EquivalencyDocumentType eqDocumentType = CustomObjectMapperUtil.readValue(eqdocumentTypeResponse,
					EquivalencyDocumentType.class);
			LOGGER.info("eqDocumentType:::::::::::::::::::::::::::::::::::::::::::::::" + eqDocumentType);
			return eqDocumentType.getQualification();

		}
		return null;
	}

	public EquivalencyCertificate getEquivalencyCertificateByEqRequest(ThemeDisplay themeDisplay, long eqRequest) {
		String certificateURL = omsbCommonApi.getBaseURL() + LRObjectURL.EQUIVALENCY_CERTIFICATE_URL
				.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()));
		certificateURL = certificateURL + StringPool.QUESTION + "filter=equivalencyRequestId"
				+ URLEncoder.encode(" eq " + eqRequest, StandardCharsets.UTF_8);
		LOGGER.info("certificateURL is ?? " + certificateURL);
		String response = omsbCommonApi.getData(certificateURL);
		LOGGER.debug("certificate response ?? " + response);
		if (Validator.isNotNull(response) && response.contains("equivalencyRequestId")) {
			EquivalencyCertificateItems items = CustomObjectMapperUtil.readValue(response,
					EquivalencyCertificateItems.class);
			if (Validator.isNotNull(items) && Validator.isNotNull(items.getItems()) && !items.getItems().isEmpty()) {
				return items.getItems().get(0);
			}
		}
		return null;
	}

	public String getFileURL(long fileEntryId) {
		String fileUrl = "";
		FileEntry fileEntry = getFileEntryById(fileEntryId);
		if (Validator.isNotNull(fileEntry)) {
			try {
				fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			} catch (PortalException e) {
				LOGGER.error(e.getMessage(), e);
			}
			LOGGER.info("url ?? " + fileUrl);
		}

		return fileUrl;
	}

	public FileEntry getFileEntryById(long fileEntryId) {
		try {
			return DLAppServiceUtil.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;
	@Reference(unbind = "-")
	private UserLocalService userLocalService;
	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;
	@Reference
	private CountryLocalService countryLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(UpdateEquivalencyMVCRenderCommand.class);

}