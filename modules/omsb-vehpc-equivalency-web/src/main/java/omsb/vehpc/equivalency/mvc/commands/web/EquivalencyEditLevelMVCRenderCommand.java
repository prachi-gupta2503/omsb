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
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
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
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.WorkSector;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.CustomCountryItemResponse;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EmploymentDetail;
import omsb.vehpc.equivalency.dto.web.EmploymentDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificate;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificateItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyDtoItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatusComments;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatusResponse;
import omsb.vehpc.equivalency.dto.web.FocalPoint;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.EQUIVALENCY_EDIT_LEVEL }, service = MVCRenderCommand.class)
public class EquivalencyEditLevelMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");
		String transitionNames = ParamUtil.getString(renderRequest, "transitionNames");
		long siteId = themeDisplay.getLayout().getGroupId();
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

		LOGGER.info("equivalencyRequestId " + equivalencyRequestId);
		LOGGER.info("Site id.............." + siteId + ">>>>" + transitionNames);

		/* Personal details */
		String eqRequestResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
				StringPool.BLANK, headersInfo);
		String personId = null;
		String dob = null;
		String passportNumber = null;
		try {
			JSONObject jsoneqRequestResponseObj = JSONFactoryUtil.createJSONObject(eqRequestResponse);
			try {
				boolean isVEHPCAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(), RoleNameConstants.VEHPC_ADMIN, Boolean.FALSE);
				boolean isVEHPCCommittee = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(), RoleNameConstants.VEHPC_COMMITTEE, Boolean.FALSE);
				boolean isVEHPCRapporteur = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(), RoleNameConstants.VEHPC_RAPPORTEUR, Boolean.FALSE);
				long employerUserID = jsoneqRequestResponseObj.getLong("employerUserID");
				if (isVEHPCAdmin || isVEHPCCommittee) {
					FocalPoint focalPoint = new FocalPoint();
					User user = UserLocalServiceUtil.getUser(employerUserID);

					focalPoint.setEmail(user.getEmailAddress());
					focalPoint.setName(user.getFullName());

					String personDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_PERSONAL_DETAILS_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=lrUserId"
							+ URLEncoder.encode(" eq " + employerUserID, DataflowConstants.UTF_8);
					PersonalDetailItem personalDetailItem = CustomObjectMapperUtil
							.readValue(omsbCommonApi.getData(personDetailsUrl), PersonalDetailItem.class);
					if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
							&& personalDetailItem.getItems().size() > 0) {
						focalPoint.setMobileNumber(personalDetailItem.getItems().get(0).getMobileNumber());

						EmploymentDetailItem workDetails = equivalencyUtil.getEmploymentDetailItemByPersonId(
								themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
								personalDetailItem.getItems().get(0).getPersonId());
						if (Validator.isNotNull(personalDetailItem) && personalDetailItem.getItems().size() > 0) {
							for (EmploymentDetail workDetail : workDetails.getItems()) {
								if (Validator.isNotNull(workDetail.getPrimaryWorkDetail())
										&& workDetail.getPrimaryWorkDetail().equalsIgnoreCase("1")) {
									if (workDetail.getWorkSectorId() != 0) {
										WorkSector workSector = equivalencyUtil.getItems(themeDisplay.getPortalURL()
												+ LRObjectURL.REG_GET_WORK_SECTOR_URL + workDetail.getWorkSectorId(),
												WorkSector.class);
										if (Validator.isNotNull(workSector) && workSector.getId() > 0) {
											focalPoint.setInstitutionName(workSector.getWorkSector());
										}
									} else {
										focalPoint.setInstitutionName(workDetail.getWorkSectorOther());
									}
								}
							}
						}
					}
					renderRequest.setAttribute("focalPoint", focalPoint);
				}
				renderRequest.setAttribute("isVEHPCAdmin", isVEHPCAdmin);
				renderRequest.setAttribute("isVEHPCCommittee", isVEHPCCommittee);
				renderRequest.setAttribute("isVEHPCRapporteur", isVEHPCRapporteur);
				
			} catch (UnsupportedEncodingException | PortalException e) {
				LOGGER.error(e.getMessage());
			}

			personId = jsoneqRequestResponseObj.getString("personId");

			try {
				String getPersonURL = generateScopeListURL(LRObjectURL.PERSON_URL, themeDisplay.getScopeGroupId());
				String finderQueryPerson = StringPool.QUESTION + "filter=id" + URLEncoder.encode(
						" eq '" + personId + "'", OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
				String personResponse = omsbHttpConnector.executeGet(getPersonURL + finderQueryPerson, "", headersInfo);
				JSONObject personJsonObject = JSONFactoryUtil.createJSONObject(personResponse);
				JSONArray getPersonJsonArrayResponse = personJsonObject
						.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);

				if (Validator.isNotNull(getPersonJsonArrayResponse.getJSONObject(0).getString("dateOfBirth"))) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);
						Date dateOB = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
								.parse(getPersonJsonArrayResponse.getJSONObject(0).getString("dateOfBirth"));
						dob = sdf.format(dateOB);
					} catch (ParseException e) {
						LOGGER.error(e.getMessage());
					}
				}
				passportNumber = getPersonJsonArrayResponse.getJSONObject(0).getString("passportNumber");
			} catch (JSONException | UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
		} catch (JSONException e) {
			LOGGER.error(e.getMessage());
		}

		String personalDetailResponse = omsbHttpConnector.executeGet(omsbCommonApi.getBaseURL()
				+ LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 + siteId + "?filter=personId%20eq%20" + personId,
				StringPool.BLANK, headersInfo);
		PersonalDetailItem personalDetailsItems = CustomObjectMapperUtil.readValue(personalDetailResponse,
				PersonalDetailItem.class);
		renderRequest.setAttribute("profession", personalDetailsItems.getItems().get(0).getProfession());
		if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
			LOGGER.info("Profession::::::" + personalDetailsItems.getItems().get(0).getProfession());
			ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
					OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC,
					personalDetailsItems.getItems().get(0).getProfession().trim(), themeDisplay.getCompanyId());
			String proffesion = entry.getName(themeDisplay.getLocale());
			personalDetailsItems.getItems().get(0).setProfession(proffesion);
			
			/* Custom country */
			long natinalityCountryId = personalDetailsItems.getItems().get(0).getNationalityCountryId();
			Country country = null;
			String countryName = "";
			if (natinalityCountryId > 0) {
				try {
					country = countryLocalService.getCountry(natinalityCountryId);
				} catch (PortalException e) {
					LOGGER.error("Exception while getting the country ", e);
				}
			}
			if (Validator.isNotNull(country)) {
				countryName =country.getName(themeDisplay.getLocale());
			}
			renderRequest.setAttribute("personNatinality", countryName);

		}
		
		/*Primary Specialty*/
		long primarySpecialtyId = Long.parseLong(personalDetailsItems.getItems().get(0).getPrimarySpeciality());
		if(Validator.isNotNull(primarySpecialtyId)) {
			ListTypeEntry primarySpecialtyListTypeEntry =omsbCommonApi.getListTypeEntryBylistTypeEntryId(primarySpecialtyId);
			if(Validator.isNotNull(primarySpecialtyListTypeEntry)) {
				renderRequest.setAttribute("primarySpecialty", primarySpecialtyListTypeEntry.getName(themeDisplay.getLocale()));
			}
		}
		
//		/* Custom country */
//		CustomCountryItemResponse countryItemResponse = equivalencyUtil.getCountryByCountryId(
//				themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), nationalityCountryId);
//		try {
//			if (countryItemResponse.getItems().size() > 0) {
//				renderRequest.setAttribute("personNatinality", countryItemResponse.getItems().get(0).getNationality());
//			}
//		} catch (Exception e) {
//			LOGGER.error(e.getMessage());
//		}
		
		
		/* Comments Part */
		String eqReqStatusResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQ_REQ_STATUS_BY_EqReqId_URL + siteId
						+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId + "&sort=dateCreated:desc"
						+ StringPool.AMPERSAND + OmsbVehpcEquivalencyWebPortletKeys.URL_PAGE_SIZE,
				StringPool.BLANK, headersInfo);
		JSONObject eqReqStatusJsonObj;
		ObjectMapper objectMapper = new ObjectMapper();
		Object eqReqStatusListJson = null;
		List<EquivalencyRequestStatusResponse> eqReqStatusList = null;
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			eqReqStatusJsonObj = JSONFactoryUtil.createJSONObject(eqReqStatusResponse);
			eqReqStatusListJson = eqReqStatusJsonObj.get(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			eqReqStatusList = objectMapper.readValue(eqReqStatusListJson.toString(),
					new TypeReference<List<EquivalencyRequestStatusResponse>>() {
					});
		} catch (JSONException | JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		}

		/**
		 * Fetching equivalency documents by equivalencyRequestId
		 */
		List<EquivalencyRequestStatusResponse> statusResponseList = new ArrayList<>();
		String documentInfoResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + themeDisplay.getScopeGroupId()
						+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId + StringPool.AMPERSAND
						+ OmsbVehpcEquivalencyWebPortletKeys.URL_PAGE_SIZE,
				StringPool.BLANK, headersInfo);
		try {
			JSONObject documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResponse);
			JSONArray itemsArray = documentInfoJsonObj.getJSONArray("items");
			DocumentInfoItems documentInfoItemsPojo = CustomObjectMapperUtil.readValue(documentInfoResponse,
					DocumentInfoItems.class);
			List<DocumentInfo> documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
					new TypeReference<List<DocumentInfo>>() {
					});
			LOGGER.info("documentInfoItemsList :" + documentInfoItemsList.size());
			String finderQueryPersonDetails = themeDisplay.getScopeGroupId() + "?filter=personId%20eq%20" + personId;
			String caseRequestRes = omsbHttpConnector.executeGet(
					omsbCommonApi.getBaseURL() + LRObjectURL.GET_CASE_REQUEST_URL + finderQueryPersonDetails, "",
					headersInfo);
			JSONObject caseRequestResJsonString = JSONFactoryUtil.createJSONObject(caseRequestRes);
			LOGGER.info("caseRequestRes :" + caseRequestRes);

			JSONArray caseRequestResArray = caseRequestResJsonString
					.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			LOGGER.info("caseRequestResArray :" + caseRequestResArray + " length " + caseRequestResArray.length());
			List<DocumentInfo> otherDocumentList = new ArrayList<>();
			List<DocumentInfo> officialReqeustDocumentList = new ArrayList<>();
			List<DocumentInfo> evaluatedDocumentList = new ArrayList<>();
			List<DocumentInfo> paymentDocumentList = new ArrayList<>();
			for (int i = 0; i < documentInfoItemsList.size(); i++) {
				LOGGER.info("documentInfoItemsList :at " + i + " and the item is ?? "
						+ documentInfoItemsList.get(i).getDocumentType());
				DocumentInfo info = new DocumentInfo();
				String key = getEqDocumentQualificationTypeById(themeDisplay,
						documentInfoItemsList.get(i).getEquivalencyDocTypeId());
				LOGGER.info("key  :at " + i + " is ?? " + key);
				String caseRequestFileUrl = equivalencyUtil.getFileURL(documentInfoItemsList.get(i).getFileEntryID());
				info.setDocumentUrl(caseRequestFileUrl);
				if (documentInfoItemsList.get(i).getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.OTHER_DOCUMENTS_TYPE)) {
					info.setDocumentType(getEqDocumentTypeNameByKey(
							OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, key, themeDisplay));
					// info.setDfFileName(dfFileName);
					otherDocumentList.add(info);
				} else if (documentInfoItemsList.get(i).getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.OFFICIAL_REQUEST_DOCUMENT_TYPE)) {
					officialReqeustDocumentList.add(info);
				} else if (documentInfoItemsList.get(i).getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ETBA_DOCUMENTS_TYPE)) {
					info.setDocumentType(getEqDocumentTypeNameByKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC, key, themeDisplay));
					// Add education s
					EducationalDetailItem item = getEducationDetailById(
							documentInfoItemsList.get(i).getComponentClassRefId(), themeDisplay);
					if (Validator.isNotNull(item)) {
						if(Validator.isNotNull(item.getQualificationConferredDate())){
							long yearOfGraduation = getYearFromStringDate(item.getQualificationConferredDate());
							info.setYearOfGraduation(yearOfGraduation);
						}
						info.setSuggestedEquivalencyLevel(item.getSuggestedEquivalencyLevel());
						ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, item.getQualificationAttained(), themeDisplay.getCompanyId());
						if (Validator.isNotNull(entry)) {
							info.setDocumentType(entry.getName(themeDisplay.getLocale()));
						} else {
							info.setDocumentType(item.getQualificationAttained());
						}
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
					paymentDocumentList.add(info);
				}
			}
			
			if (Validator.isNotNull(paymentDocumentList) && paymentDocumentList.size()>0) {
				renderRequest.setAttribute("paymentDocumentList", paymentDocumentList);
			}else {
				List<DocumentInfo> caseReportDocumentList = equivalencyUtil.getCaseReportListByPersonId(personId,themeDisplay);
				if (Validator.isNotNull(caseReportDocumentList) && caseReportDocumentList.size()>0) {
					renderRequest.setAttribute("paymentDocumentList", caseReportDocumentList);
				}
			}
			DocumentInfo officialDocument = new DocumentInfo();
			if (Validator.isNotNull(officialReqeustDocumentList) && !officialReqeustDocumentList.isEmpty()) {
				officialDocument = officialReqeustDocumentList.get(0);
			}
			LOGGER.info("documentInfoItemsList" + documentInfoItemsList.size());
			renderRequest.setAttribute("documentInfoList", documentInfoItemsList);
			renderRequest.setAttribute("otherDocumentList", otherDocumentList);
			renderRequest.setAttribute("officialReqeustDocument", officialDocument);
			renderRequest.setAttribute("evaluatedDocumentList", evaluatedDocumentList);
			renderRequest.setAttribute("documentInfoItemsPojo", documentInfoItemsPojo.getItems());
			renderRequest.setAttribute("documentInfoList", documentInfoItemsList);

			EquivalencyRequestStatusComments statusComments = new EquivalencyRequestStatusComments();

			User userDetails = null;
			long userId;
			if (Validator.isNotNull(statusResponseList)) {
				for (int i = 0; i < eqReqStatusList.size(); i++) {
					userId = eqReqStatusList.get(i).getCommenterUserId();
					try {
						EquivalencyRequestStatusResponse statusResponse = new EquivalencyRequestStatusResponse();
						List<Role> rolesList = roleLocalService.getUserRoles(userId);
						List<String> nameList = rolesList.stream().map(Role::getName).collect(Collectors.toList());
						userDetails = userLocalService.getUser(userId);
						String commenterName = userDetails.getFullName();

						statusResponse.setName(commenterName);
						statusResponse.setComments(eqReqStatusList.get(i).getComments());
						String date = omsbCommonApi.convertDate(eqReqStatusList.get(i).getDateCreated());
						statusResponse.setDateCreated(date);
						if (nameList.contains(RoleNameConstants.VEHPC_ADMIN)) {
							statusResponse.setRole(RoleNameConstants.VEHPC_ADMIN);
						} else if (nameList.contains(RoleNameConstants.VEHPC_COMMITTEE)) {
							statusResponse.setRole(RoleNameConstants.VEHPC_COMMITTEE);
						} else if (nameList.contains(RoleNameConstants.EMPLOYER)) {
							statusResponse.setRole(RoleNameConstants.EMPLOYER);
						}
						statusResponse.setEquivalencyLevel(equivalencyUtil.getListTypeEntryNamebyKey(
								OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC,
								eqReqStatusList.get(i).getEquivalencyLevel(), themeDisplay));
						statusResponse.setEquivalencyCertificate(equivalencyUtil.getListTypeEntryNamebyKey(
								OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC,
								eqReqStatusList.get(i).getEquivalencyCertificate(), themeDisplay));
						statusResponse.setEquivalencyLevelReason(equivalencyUtil.getListTypeEntryNamebyKey(
								OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC,
								eqReqStatusList.get(i).getEquivalencyLevelReason(), themeDisplay));
						statusResponse.setDocumentList(equivalencyUtil
								.getCommentDocuments(eqReqStatusList.get(i).getId(), documentInfoItemsList));
						/*
						 * String role = rolesList.get(i % rolesList.size()).getName();
						 * 
						 * LOGGER.info(" roles.getName(); " + role); statusResponse.setRole(role);
						 */
						statusResponseList.add(statusResponse);
					} catch (PortalException e) {
						LOGGER.error(e.getMessage());
					}
					statusComments.getCommentedBy();
				}
			}
		} catch (JsonProcessingException | RuntimeException | PortalException e) {
			LOGGER.error(e.getMessage());
		}

		String equivalencyDesionResponse = omsbHttpConnector
				.executeGet(
						omsbCommonApi.getBaseURL() + LRObjectURL.EQUIVALENCY_DECISION_BY_EQ_REQ_ID + siteId
								+ "?filter=equivalencyRequestId+eq+" + equivalencyRequestId,
						StringPool.BLANK, headersInfo);
		LOGGER.info("equivalencyDesionResponse :: " + equivalencyDesionResponse);
		EquivalencyDecisionItems decisionItems = CustomObjectMapperUtil.readValue(equivalencyDesionResponse,
				EquivalencyDecisionItems.class);
		LOGGER.info("decisionItems :: " + decisionItems);
		LOGGER.info("decisionItemsList :: " + decisionItems);

		for (int i = 0; i < decisionItems.getItems().size(); i++) {
			LOGGER.info("comments " + decisionItems.getItems().get(i).getComments());
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
		}

		/**
		 * Fetch Certificate EValuated
		 */
		String certificateToEvaluate = "Certificate To Evaluate";
		ObjectMapper objectMapper2 = new ObjectMapper();
		objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		String findEqDocTypeListURL = null;
		try {
			findEqDocTypeListURL = themeDisplay.getPortalURL()
					+ LRObjectURL.EQUIVALENCY_DOC_TYPE_URL.replace("{scope-id}",
							String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=" + StringPool.OPEN_PARENTHESIS + "equivalencyDocType"
					+ URLEncoder.encode(" eq " + "'" + certificateToEvaluate + "'" + StringPool.CLOSE_PARENTHESIS
							+ " and " + StringPool.OPEN_PARENTHESIS + "equivalencyRequestId eq " + equivalencyRequestId
							+ StringPool.CLOSE_PARENTHESIS, DataflowConstants.UTF_8);
		} catch (UnsupportedEncodingException e1) {
			LOGGER.error(e1.getMessage(), e1);
		}
		String findEqDocTypeListRes = omsbHttpConnector.executeGet(findEqDocTypeListURL, "", headersInfo);
		LOGGER.info(findEqDocTypeListURL + " : findEqDocTypeListRes : " + findEqDocTypeListRes);

		List<EquivalencyDocumentType> findEqDocTypeListResItemsPojo = null;
		List<DocumentInfoItems> evaluateDocumentInfos = null;
		List<EquivalencyDtoItem> equivalencyDtoItems = new ArrayList<>();
		long noOfEvaluateDocumentInfos = 0;
		try {
			JSONObject jsonResponseObject = JSONFactoryUtil.createJSONObject(findEqDocTypeListRes);
			Object findEqDocTypeListResItems = jsonResponseObject.get(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			findEqDocTypeListResItemsPojo = objectMapper2.readValue(findEqDocTypeListResItems.toString(),
					new TypeReference<List<EquivalencyDocumentType>>() {
					});
			if (findEqDocTypeListResItemsPojo.size() > 0) {
				for (EquivalencyDocumentType docType : findEqDocTypeListResItemsPojo) {
					if (Validator.isNotNull(docType.getQualification())) {
						long doTypeClassPk = docType.getId();

						LOGGER.info("doTypeClassPk : " + doTypeClassPk);
						String findDocuInfoByEqDoctypeIdURL = themeDisplay.getPortalURL()
								+ LRObjectURL.DOCUMENT_INFO_URL.replace("{scope-id}",
										String.valueOf(themeDisplay.getScopeGroupId()))
								+ StringPool.QUESTION + "filter=" + StringPool.OPEN_PARENTHESIS + "equivalencyDocTypeId"
								+ URLEncoder.encode(" eq " + doTypeClassPk + StringPool.CLOSE_PARENTHESIS + " and "
										+ StringPool.OPEN_PARENTHESIS + "componentId eq " + 2
										+ StringPool.CLOSE_PARENTHESIS, DataflowConstants.UTF_8);

						LOGGER.info(" :: findDocuInfoByEqDoctypeIdURL : " + findDocuInfoByEqDoctypeIdURL);
						String findDocuInfoByEqDoctypeIdRes = omsbHttpConnector.executeGet(findDocuInfoByEqDoctypeIdURL,
								"", headersInfo);
						LOGGER.info("findDocuInfoByEqDoctypeIdRes  : " + findDocuInfoByEqDoctypeIdRes);

						DocumentInfoItems documentInfo = CustomObjectMapperUtil.readValue(findDocuInfoByEqDoctypeIdRes,
								DocumentInfoItems.class);

						EquivalencyDtoItem equivalencyDtoItem = new EquivalencyDtoItem();

						equivalencyDtoItem.setQualification(docType.getQualification());

						if (Validator.isNotNull(documentInfo) && documentInfo.getItems().size() > 0) {
							equivalencyDtoItem.setDocumentUrl(
									equivalencyUtil.getFileURL(documentInfo.getItems().get(0).getFileEntryID()));
							equivalencyDtoItem.setDocumentInfoId(documentInfo.getItems().get(0).getId());
						}
						equivalencyDtoItems.add(equivalencyDtoItem);

					}
				}
			}
			LOGGER.info("equivalencyDtoItems::::::::" + equivalencyDtoItems);
			noOfEvaluateDocumentInfos = equivalencyDtoItems.size();
		} catch (NullPointerException | JSONException | JsonProcessingException | IndexOutOfBoundsException e) {
			LOGGER.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {

		}

		List<EquivalencyDecision> equivelencyDecisionByEqIdResItemPojoList = null;
		try {
			String findEquivelencyDecisionByEqId = "?filter=equivalencyRequestId+eq+" + equivalencyRequestId;
			String findEquivelencyDecisionByEqIdURL = generateScopeListURL(
					LRObjectURL.EQUIVALENCY_DECISION_URL + findEquivelencyDecisionByEqId, siteId);
			String findEquivelencyDecisionByEqIdRes = omsbHttpConnector.executeGet(findEquivelencyDecisionByEqIdURL, "",
					headersInfo);

			if (Validator.isNotNull(findEquivelencyDecisionByEqIdRes)) {
				JSONObject findEquivelencyDecisionByEqIdResJson = JSONFactoryUtil
						.createJSONObject(findEquivelencyDecisionByEqIdRes);
				Object findEquivelencyDecisionByEqIdResJsonItem = findEquivelencyDecisionByEqIdResJson
						.get(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);

				equivelencyDecisionByEqIdResItemPojoList = objectMapper2.readValue(
						findEquivelencyDecisionByEqIdResJsonItem.toString(),
						new TypeReference<List<EquivalencyDecision>>() {
						});

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		/* Equivalency Level pickList dropdown */
		ListTypeDefinition definition = null;
		List<ListTypeEntry> equivalencyLevelList = new ArrayList<>();
		List<ListTypeEntry> eqLevelReasonList = new ArrayList<>();
		try {
			definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode("PL_Equivalency_Level", themeDisplay.getCompanyId());
			equivalencyLevelList = ListTypeEntryLocalServiceUtil
					.getListTypeEntries(definition.getListTypeDefinitionId());
			eqLevelReasonList = omsbCommonApi.getListTypeEntriesByERC(
					OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC, themeDisplay.getCompanyId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
        String dateStringArray[] = getTodaysDateInStringArray(); 
		renderRequest.setAttribute("currentDay",dateStringArray[0]);
		renderRequest.setAttribute("currentMonth",dateStringArray[1].toLowerCase());
		renderRequest.setAttribute("currentYear",dateStringArray[2]);
		renderRequest.setAttribute("equivelencyDecisionByEqIdResItemPojoList",
				equivelencyDecisionByEqIdResItemPojoList);
		renderRequest.setAttribute("evaluateDocumentInfos", equivalencyDtoItems);
		renderRequest.setAttribute("noOfEvaluateDocumentInfos", noOfEvaluateDocumentInfos);
		renderRequest.setAttribute("dateOfBirth", dob);
		renderRequest.setAttribute("passportNumber", passportNumber);
		renderRequest.setAttribute("personalDetail", personalDetailsItems.getItems().get(0));

		renderRequest.setAttribute("eqReqStatusList", eqReqStatusList);
		// renderRequest.setAttribute("statusComments", statusComments);
		renderRequest.setAttribute("statusResponseList", statusResponseList);
		renderRequest.setAttribute("transitionNames", transitionNames.replaceAll("\\[", "").replaceAll("\\]", ""));
		renderRequest.setAttribute("equivalencyLevelList", equivalencyLevelList);
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
		renderRequest.setAttribute("eqLevelReasonList", eqLevelReasonList);

		LOGGER.info(" End Equivalency Edit LEVEL Render()>>>");
		return EquivalencyJSPPathConstants.EQUIVALENCY_EDIT_LEVEL_JSP;
	}

	private String[] getTodaysDateInStringArray() {
		LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        String dateString = dtf.format(localDate);
        return dateString.split(" ");
	}

	private long getYearFromStringDate(String dateOfGraduation) {
		String convertedDateOfGraduation =omsbCommonApi.convertObjectDateToDDMMYYYYDate(dateOfGraduation);
		String[] inputs = convertedDateOfGraduation.split("/");
		return Long.parseLong(inputs[inputs.length-1]);
	}

	private EducationalDetailItem getEducationDetailById(long educationId, ThemeDisplay themeDisplay) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + educationId;
		LOGGER.info("url for education is ?? " + url);
		String response = omsbCommonApi.getData(url);
		LOGGER.info("response for education is ?? " + response);
		EducationalDetailItem educationRes = CustomObjectMapperUtil.readValue(response, EducationalDetailItem.class);
		return educationRes;
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

	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL()
				+ equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}

//	private String getObjectClassName(long companyId) {
//		try {
//			ObjectDefinition definition = objectDefinitionService
//					.getObjectDefinitionByExternalReferenceCode("OB_EUIVALENCY_REQUEST_ERC", companyId);
//			if (Validator.isNotNull(definition)) {
//				return definition.getClassName();
//			}
//		} catch (PortalException e) {
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}

	public EquivalencyCertificate getEquivalencyCertificateByEqRequest(ThemeDisplay themeDisplay, long eqRequest) {
		String certificateURL = omsbCommonApi.getBaseURL() + LRObjectURL.EQUIVALENCY_CERTIFICATE_URL
				.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()));
		certificateURL = certificateURL + StringPool.QUESTION + "filter=equivalencyRequestId"
				+ URLEncoder.encode(" eq " + eqRequest, StandardCharsets.UTF_8);
		LOGGER.info("certificateURL is ?? " + certificateURL);
		// String response = omsbHttpConnector.executeGet(certificateURL, "",
		// headerUtil.getHeaders()); // omsbCommonApi.getData(certificateURL);
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
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;
	
	@Reference
	private CountryLocalService countryLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyEditLevelMVCRenderCommand.class);

}
