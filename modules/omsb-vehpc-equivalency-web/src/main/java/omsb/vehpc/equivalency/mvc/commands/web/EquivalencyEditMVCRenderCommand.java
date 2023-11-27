package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
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
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.CustomCountryItemResponse;
import omsb.vehpc.equivalency.dto.web.CustomCountryItems;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentTypeItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatusComments;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatusResponse;
import omsb.vehpc.equivalency.dto.web.PersonalDetail;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.EQUIVALENCY_EDIT }, service = MVCRenderCommand.class)
public class EquivalencyEditMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("Equivalency Edit Render()>>>Invoked>>>");

		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");
		LOGGER.info("equivalencyRequestId " + equivalencyRequestId);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long siteId = themeDisplay.getLayout().getGroupId();
		LOGGER.info("Site id..............2" + siteId);
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

		/* Personal details */
		String equivalencyRequestUrl = omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL
				+ equivalencyRequestId;
		String eqRequestResponse = omsbHttpConnector.executeGet(equivalencyRequestUrl, StringPool.BLANK, headersInfo);
		String personId = null;
		String dob = null;
		String passportNumber = null;
		String professionId = null;
		try {
			JSONObject jsoneqRequestResponseObj = JSONFactoryUtil.createJSONObject(eqRequestResponse);
			personId = jsoneqRequestResponseObj.getString("personId");
			professionId = jsoneqRequestResponseObj.getString("professionId");
			LOGGER.info("personId: " + personId + " and professionId : " + professionId);
			String personRequest = omsbCommonApi.getBaseURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + personId;
			String personResponse = omsbHttpConnector.executeGet(personRequest, StringPool.BLANK, headersInfo);
			JSONObject personJsonObj;
			try {
				personJsonObj = JSONFactoryUtil.createJSONObject(personResponse);

				LOGGER.info("personJsonObj " + personJsonObj);
				// dob = omsbCommonApi.convertDate(personJsonObj.getString("dateOfBirth"));
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				DateFormat newDate = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date oldDate = df.parse(personJsonObj.getString("dateOfBirth"));
					dob = newDate.format(oldDate);
				} catch (ParseException e) {
					LOGGER.info(e.getMessage());
				}
				passportNumber = personJsonObj.getString("passportNumber");
				LOGGER.info("dob : " + dob + " passportNumber : " + passportNumber);

			} catch (JSONException e) {
				LOGGER.error(e.getMessage());
			}

		} catch (JSONException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("personId " + personId);
		long natinalityCountryId = 0;
		PersonalDetail personalDetails = new PersonalDetail();
		if (Validator.isNotNull(personId)) {
			String personalDetailRequestUrl = omsbCommonApi.getBaseURL()
					+ LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 + siteId + "?filter=personId%20eq%20"
					+ personId;
			String personalDetailResponse = omsbHttpConnector.executeGet(personalDetailRequestUrl, StringPool.BLANK,
					headersInfo);
			LOGGER.info("personalDetailResponse " + personalDetailResponse);
			PersonalDetailItems personalDetailsItems = CustomObjectMapperUtil.readValue(personalDetailResponse,
					PersonalDetailItems.class);

			if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
//				String json = CustomObjectMapperUtil.writeValueAsString(personalDetailsItems, null);
//				String name = personalDetailsItems.getItems().get(0).getGivenNameAsPassport();
//				String fullName = personalDetailsItems.getItems().get(0).getGivenNameAsPassport();
//				natinalityCountryId = personalDetailsItems.getItems().get(0).getNationalityCountryId();
//				String mobileNumber = personalDetailsItems.getItems().get(0).getMobileNumber();
//				String email = personalDetailsItems.getItems().get(0).getEmail();
				personalDetails = personalDetailsItems.getItems().get(0);

			}

		}

		/* Custom country */
		String personNationality = StringPool.BLANK;
		if (natinalityCountryId != 0) {
			String customCountryUrl = omsbCommonApi.getBaseURL()
					+ LRObjectURL.GET_CUSTOM_COUNTRY_BY_NATIONALITYCOUNTRYID_URL + siteId + "?filter=countryID%20eq%20"
					+ natinalityCountryId;
			String customCountryResponse = omsbHttpConnector.executeGet(customCountryUrl, StringPool.BLANK,
					headersInfo);
			LOGGER.info("customCountryResponse " + customCountryResponse);
			CustomCountryItemResponse countryItemResponse = CustomObjectMapperUtil.readValue(customCountryResponse,
					CustomCountryItemResponse.class);
			if (Validator.isNotNull(countryItemResponse) && countryItemResponse.getItems().size() > 0) {
				personNationality = countryItemResponse.getItems().get(0).getNationality();
			}
		}

		/* Comments Part */
		String commenterName = null;
		String eqReqStatusUrl = omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQ_REQ_STATUS_BY_EqReqId_URL + siteId
				+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId;
		String eqReqStatusResponse = omsbHttpConnector.executeGet(eqReqStatusUrl, StringPool.BLANK, headersInfo);
		LOGGER.info("eqReqStatusResponse " + eqReqStatusResponse);
		JSONObject eqReqStatusJsonObj;
		ObjectMapper objectMapper = new ObjectMapper();
		Object eqReqStatusListJson = null;
		List<EquivalencyRequestStatusResponse> eqReqStatusList = null;
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			eqReqStatusJsonObj = JSONFactoryUtil.createJSONObject(eqReqStatusResponse);
			LOGGER.info("eqReqStatusJsonObj" + eqReqStatusJsonObj);
			eqReqStatusListJson = eqReqStatusJsonObj.get(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			eqReqStatusList = objectMapper.readValue(eqReqStatusListJson.toString(),
					new TypeReference<List<EquivalencyRequestStatusResponse>>() {
					});
		} catch (JSONException | JsonProcessingException e1) {
			LOGGER.error(e1.getMessage());
		}

		EquivalencyRequestStatusComments statusComments = new EquivalencyRequestStatusComments();
		List<EquivalencyRequestStatusResponse> statusResponseList = new ArrayList<>();

		User userDetails = null;
		long userId;
		for (int i = 0; i < eqReqStatusList.size(); i++) {
			userId = eqReqStatusList.get(i).getCommenterUserId();
			try {
				EquivalencyRequestStatusResponse statusResponse = new EquivalencyRequestStatusResponse();
				userDetails = userLocalService.getUser(userId);
				commenterName = userDetails.getFullName();
				statusResponse.setName(commenterName);
				statusResponse.setComments(eqReqStatusList.get(i).getComments());
				String date = omsbCommonApi.convertDate(eqReqStatusList.get(i).getDateCreated());
				List<Role> rolesList = roleLocalService.getUserRoles(userId);
				String role = rolesList.get(i % rolesList.size()).getName();
				statusResponse.setRole(role);
				statusResponse.setDateCreated(date);
				statusResponseList.add(statusResponse);
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			}
			statusComments.getCommentedBy();
		}
		/* Profesion picklist dropdown */
		ListTypeDefinition definition = null;
		List<ListTypeEntry> professionList = new ArrayList<>();
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Profession_ERC", 20096);
			professionList = ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		/* Document Type pickList dropdown */
		List<ListTypeEntry> documentTypeList = new ArrayList<>();
		try {
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, themeDisplay.getCompanyId());
			documentTypeList = ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		/* Qualification pickList dropdown */
		List<ListTypeEntry> qualificationList = new ArrayList<>();
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Qualification_ERC", 20096);
			qualificationList = ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		/* Equivalency Level pickList dropdown */
		List<ListTypeEntry> equivalencyLevelList = new ArrayList<>();
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Equivalency_Level", 20096);
			equivalencyLevelList = ListTypeEntryLocalServiceUtil
					.getListTypeEntries(definition.getListTypeDefinitionId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}

		/* Custom Country (for Nationality) dropdown from Object */
		List<Country> countries = countryLocalService.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("allNationalities", countries);

		/**
		 * Fetching equivalency documents by equivalencyRequestId
		 */
		String documentInfoResponse = omsbHttpConnector
				.executeGet(
						omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + siteId
								+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId,
						StringPool.BLANK, headersInfo);
		try {
			JSONObject documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResponse);
			JSONArray itemsArray = documentInfoJsonObj.getJSONArray("items");

			List<DocumentInfo> documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
					new TypeReference<List<DocumentInfo>>() {
					});
			LOGGER.info("documentInfoItemsList size: " + documentInfoItemsList.size());

			String finderQueryPersonDetails = siteId + "?filter=personId%20eq%20" + personId;
			String caseRequestRes = omsbHttpConnector.executeGet(
					omsbCommonApi.getBaseURL() + LRObjectURL.GET_CASE_REQUEST_URL + finderQueryPersonDetails,
					StringPool.BLANK, headersInfo);
			JSONObject caseRequestResJsonString = JSONFactoryUtil.createJSONObject(caseRequestRes);

			JSONArray caseRequestResArray = caseRequestResJsonString
					.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			for (int i = 0; i < caseRequestResArray.length(); i++) {
				String caseNumber = caseRequestResArray.getJSONObject(i).getString("caseNumber");
				documentInfoItemsList.get(i).setCaseNumber(caseNumber);
				LOGGER.info("case number (DFRN): " + caseNumber);
				long fileEntryId = documentInfoItemsList.get(i).getFileEntryID();
				String caseRequestFileUrl = getFileURL(fileEntryId);
				renderRequest.setAttribute("caseRequestFileUrl", caseRequestFileUrl);
			}

			renderRequest.setAttribute("documentInfoList", documentInfoItemsList);
		} catch (JSONException | JsonProcessingException e1) {
			LOGGER.error(e1.getMessage());
		}

		/**
		 * Final decision >> Request Details
		 */

		String equivalencyDesionResponse = omsbHttpConnector
				.executeGet(
						omsbCommonApi.getBaseURL() + LRObjectURL.EQUIVALENCY_DECISION_BY_EQ_REQ_ID + siteId
								+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId,
						StringPool.BLANK, headersInfo);
		LOGGER.info("equivalencyDesionResponse :: " + equivalencyDesionResponse);
		EquivalencyDecisionItems decisionItems = CustomObjectMapperUtil.readValue(equivalencyDesionResponse,
				EquivalencyDecisionItems.class);
		LOGGER.info("decisionItems :: " + decisionItems);
		LOGGER.info("decisionItemsList :: " + decisionItems);

		for (int i = 0; i < decisionItems.getItems().size(); i++) {
			LOGGER.info("comments " + decisionItems.getItems().get(i).getComments());
			LOGGER.info("decision level " + decisionItems.getItems().get(i).getEquivalencyLevelId().getName());
			long decisionBy = decisionItems.getItems().get(i).getDecisionBy();
			LOGGER.info(" role : " + roleLocalService.getUserRoles(decisionBy));
			LOGGER.info("user Id :: " + decisionBy);
			List<Role> rolesList = roleLocalService.getUserRoles(decisionBy);
			List<String> roleNames = rolesList.stream().map(Role::getName).collect(Collectors.toList());
			LOGGER.info("roles................" + roleNames.toString());

			String documentInfoResp = omsbHttpConnector.executeGet(omsbCommonApi.getBaseURL()
					+ LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + siteId + "?filter=equivalencyRequestId%20eq%20"
					+ decisionItems.getItems().get(i).getEquivalencyRequestId(), StringPool.BLANK, headersInfo);
			JSONObject documentInfoJsonObj;
			List<DocumentInfo> documentInfoItemsList = null;
			JSONArray itemsArray;
			try {
				documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResp);
				itemsArray = documentInfoJsonObj.getJSONArray("items");
				documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
						new TypeReference<List<DocumentInfo>>() {
						});
				LOGGER.info("documentInfoItemsList size: " + documentInfoItemsList.size());

			} catch (JSONException | JsonProcessingException e) {
				LOGGER.error(e.getMessage());
			}

			if (roleNames.contains(RoleNameConstants.VEHPC_COMMITTEE)) {
				LOGGER.info("vehpc committee" + decisionItems.getItems().get(i).getComments());
				renderRequest.setAttribute("vehpcDesion", decisionItems.getItems().get(i));
				LOGGER.info("certificateVehpcCommittee   " + documentInfoItemsList.get(i).getDocumentTypeId());
				renderRequest.setAttribute("certificateVehpcCommittee",
						documentInfoItemsList.get(i).getDocumentTypeId());
				String certificateUrl = getFileURL(documentInfoItemsList.get(i).getFileEntryID());
				renderRequest.setAttribute("viewCertificateVehpc", certificateUrl);
			} else if (roleNames.contains(RoleNameConstants.VEHPC_ADMIN)) {
				LOGGER.info("admin committee" + decisionItems.getItems().get(i).getComments());
				renderRequest.setAttribute("adminDesion", decisionItems.getItems().get(i));
				LOGGER.info("certificateAdmin  :: " + documentInfoItemsList.get(i).getDocumentTypeId());
				renderRequest.setAttribute("certificateAdmin", documentInfoItemsList.get(i).getDocumentTypeId());
				String certificateUrl = getFileURL(documentInfoItemsList.get(i).getFileEntryID());
				renderRequest.setAttribute("viewCertificateAdmin", certificateUrl);
			}
		}

		/**
		 * fetching certificates to be evaluated part
		 */
		String equivalencyDocTypeUrl = StringPool.BLANK;
		String equivalencyDocTypeResponse = StringPool.BLANK;
		try {
			equivalencyDocTypeUrl = equivalencyUtil.generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL, siteId)
					+ "?filter=equivalencyRequestId"
					+ URLEncoder.encode(" eq " + equivalencyRequestId, DataflowConstants.UTF_8);
			equivalencyDocTypeResponse = omsbHttpConnector.executeGet(equivalencyDocTypeUrl, StringPool.BLANK,
					headersInfo);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		// String equivalencyDocTypeUrl =
		// equivalencyUtil.generateScopeListURL(LRObjectURL.GET_EQ_DOCTYPE_BY_EQ_REQ_ID_URL,
		// siteId) + "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId;

		EquivalencyDocumentTypeItems equivalencyDocumentTypeItems = CustomObjectMapperUtil
				.readValue(equivalencyDocTypeResponse, EquivalencyDocumentTypeItems.class);
		List<EquivalencyDocumentType> equivalencyDocumentTypeItemsList = equivalencyDocumentTypeItems.getItems();

		for (int i = 0; i < equivalencyDocumentTypeItemsList.size(); i++) {
			String docType = equivalencyDocumentTypeItemsList.get(i).getEquivalencyDocType();
			String officialLetter = "Official Request Letter";
			String certificatesToBeEval = "Certificate To Evaluate";
			String otherDocument = "Other Documents";
			LOGGER.info("equivalencyDocumentTypeItems: " + docType);
			long docTypeId = equivalencyDocumentTypeItemsList.get(i).getId();

			if (docType.equals(certificatesToBeEval)) {
				String deocInfoByEqDocType = omsbHttpConnector
						.executeGet(
								omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + siteId
										+ "?filter=equivalencyDocTypeId%20eq%20" + docTypeId,
								StringPool.BLANK, headersInfo);
				DocumentInfoItems documentInfoItems = CustomObjectMapperUtil.readValue(deocInfoByEqDocType,
						DocumentInfoItems.class);
				for (int j = 0; j < documentInfoItems.getItems().size(); j++) {
					LOGGER.info("certificatesToBeEval :: " + documentInfoItems.getItems().get(j).getDocumentTypeId());

					String finderQueryPersonDetails = siteId + "?filter=personId%20eq%20" + personId;
					String caseRequestRes = omsbHttpConnector.executeGet(
							omsbCommonApi.getBaseURL() + LRObjectURL.GET_CASE_REQUEST_URL + finderQueryPersonDetails,
							"", headersInfo);

//					String eqDocumentTypesRes = omsbHttpConnector.executeGet(equivalencyUtil.generateScopeListURL(LRObjectURL.GET_EQ_DOCTYPE_BY_EQ_REQ_ID_URL,siteId)+"?filter=equivalencyRequestId%20eq%20"+equivalencyRequestId, "", headersInfo);
//					EquivalencyDocumentTypeItems equivalencyDocumentTypeItems = CustomObjectMapperUtil.readValue(eqRequestResponse, EquivalencyDocumentTypeItems.class);
					try {
						JSONObject caseRequestResJsonString = JSONFactoryUtil.createJSONObject(caseRequestRes);
						JSONArray caseRequestResArray = caseRequestResJsonString
								.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
						documentInfoItems.getItems().get(j)
								.setCaseNumber(caseRequestResArray.getJSONObject(j).getString("caseNumber"));
						// LOGGER.info("dfrn for evaluated
						// certificates"+documentInfoItems.getItems().get(j).setCaseNumber(caseRequestResArray.getJSONObject(i).getString("caseNumber")));
						//
						String customCountryUrl = StringPool.BLANK;
						customCountryUrl = omsbCommonApi.getBaseURL() + LRObjectURL.REG_CUSTOM_COUNTRY_URL
								+ equivalencyDocumentTypeItemsList.get(i).getCountryId();
						String customCountryResponse = omsbHttpConnector.executeGet(customCountryUrl, StringPool.BLANK,
								headersInfo);
						CustomCountryItems customCountryItems = CustomObjectMapperUtil.readValue(customCountryResponse,
								CustomCountryItems.class);
						if (Validator.isNotNull(customCountryItems)) {
							documentInfoItems.getItems().get(j).setCountryName(customCountryItems.getNationality());
						}
						documentInfoItems.getItems().get(j)
								.setDocumentType(equivalencyDocumentTypeItemsList.get(i).getQualification());
					} catch (JSONException e) {
						LOGGER.error(e.getMessage());
					}

					renderRequest.setAttribute("certificatesToBeEval", documentInfoItems.getItems().get(j));
				}
			} else if (docType.equals(otherDocument)) {
				String deocInfoByEqDocType = omsbHttpConnector
						.executeGet(
								omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + siteId
										+ "?filter=equivalencyDocTypeId%20eq%20" + docTypeId,
								StringPool.BLANK, headersInfo);
				DocumentInfoItems documentInfoItems = CustomObjectMapperUtil.readValue(deocInfoByEqDocType,
						DocumentInfoItems.class);
				for (int j = 0; j < documentInfoItems.getItems().size(); j++) {
					documentInfoItems.getItems().get(j)
							.setDocumentType(equivalencyDocumentTypeItemsList.get(i).getQualification());
					LOGGER.info("otherDocument :: " + documentInfoItems.getItems().get(j).getDocumentTypeId());
					renderRequest.setAttribute("otherDocument", documentInfoItems.getItems().get(j));
				}
			} else if (docType.equals(officialLetter)) {
				LOGGER.info("docTypeId: " + docTypeId);
				String deocInfoByEqDocType = omsbHttpConnector
						.executeGet(
								omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + siteId
										+ "?filter=equivalencyDocTypeId%20eq%20" + docTypeId,
								StringPool.BLANK, headersInfo);
				DocumentInfoItems documentInfoItems = CustomObjectMapperUtil.readValue(deocInfoByEqDocType,
						DocumentInfoItems.class);
				for (int j = 0; j < documentInfoItems.getItems().size(); j++) {
					LOGGER.info("documentInfoItems file entry id  :: "
							+ documentInfoItems.getItems().get(j).getFileEntryID());
					LOGGER.info("document type ::: " + documentInfoItems.getItems().get(j).getDocumentTypeId());
					String officialFileId = getFileURL(documentInfoItems.getItems().get(j).getFileEntryID());

					renderRequest.setAttribute("officiallettersLetter", officialFileId);
					renderRequest.setAttribute("officialletters", documentInfoItems.getItems().get(j));
				}
			}
		}

		renderRequest.setAttribute("professionList", professionList);
		renderRequest.setAttribute("documentTypeList", documentTypeList);
		renderRequest.setAttribute("qualificationList", qualificationList);
		renderRequest.setAttribute("equivalencyLevelList", equivalencyLevelList);
		LOGGER.info("profession" + professionId);
		renderRequest.setAttribute("personalDetail", personalDetails);
		renderRequest.setAttribute("personID", personId);
		renderRequest.setAttribute("dateOfBirth", dob);
		renderRequest.setAttribute("passportNumber", passportNumber);
		renderRequest.setAttribute("personNatinality", personNationality);
		renderRequest.setAttribute("eqReqStatusList", eqReqStatusList);
		renderRequest.setAttribute("commenterName", statusComments);
		renderRequest.setAttribute("statusResponseList", statusResponseList);

		LOGGER.info(" End Equivalency Edit Render()>>>");
		return EquivalencyJSPPathConstants.EQUIVALENCY_EDIT_JSP;
	}

	private String getFileURL(long fileEntryId) {
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

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	@Reference(unbind = "-")
	private UserLocalService userLocalService;
	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;
	@Reference
	private CountryLocalService countryLocalService;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyEditMVCRenderCommand.class);

}
