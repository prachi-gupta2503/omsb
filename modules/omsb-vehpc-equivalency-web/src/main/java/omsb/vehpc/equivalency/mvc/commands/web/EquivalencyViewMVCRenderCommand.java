package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.EquivalencyRequestStatusEnum;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.WorkSector;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.appeal.preferences.AppealConfiguration;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EmploymentDetail;
import omsb.vehpc.equivalency.dto.web.EmploymentDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyAllRequests;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificate;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificateItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatusResponse;
import omsb.vehpc.equivalency.dto.web.FocalPoint;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;
import omsb.vehpc.equivalency.workflow.web.JspTransitionWorkflowHandler;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.EQUIVALENCY_VIEW }, service = MVCRenderCommand.class)
public class EquivalencyViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("Equivalency View Render()>>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		List<EquivalencyRequestStatusResponse> statusResponseList = new ArrayList<>();

		boolean isAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN,
				themeDisplay.getUserId());
		boolean isEmployer = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYER,
				themeDisplay.getUserId());
		boolean isCommittee = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_COMMITTEE,
				themeDisplay.getUserId());
		boolean isRapporteur = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_RAPPORTEUR,
				themeDisplay.getUserId());

		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");

		LOGGER.info("equivalencyRequestId is ?? " + equivalencyRequestId);

		/* Personal details */
		String eqRequestResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
				StringPool.BLANK, headersInfo);
		LOGGER.info("EquivalencyViewMVCRenderCommand eqRequestResponse:::::::" + eqRequestResponse);
		String personId = null;
		String dob = null;
		String passportNumber = null;
		EquivalencyAllRequests equivalencyAllRequests = new EquivalencyAllRequests();
		try {
			JSONObject jsoneqRequestResponseObj = JSONFactoryUtil.createJSONObject(eqRequestResponse);

			/*
			 * Prepare equivalency Java object
			 */

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			try {
				EquivalencyRequest equivalencyRequest = objectMapper.readValue(jsoneqRequestResponseObj.toString(),
						new TypeReference<EquivalencyRequest>() {
						});

				if (equivalencyRequest.getEquivalencyStatusId() > 0) {
					ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil
							.fetchListTypeEntry(equivalencyRequest.getEquivalencyStatusId());
					String statusKey = "";
					if (Validator.isNotNull(listTypeEntry)) {
						statusKey = listTypeEntry.getKey();

						String equivalencyStatusToDisplay = equivalencyUtil.getFinalStatus(isEmployer, isCommittee,
								isAdmin, isRapporteur, statusKey);
						equivalencyAllRequests.setStatus(equivalencyUtil.getFinalStatusValue(isAdmin, isEmployer,
								equivalencyStatusToDisplay, themeDisplay, statusKey));
						equivalencyAllRequests.setStatusKey(statusKey);

						equivalencyStatusToDisplay = equivalencyStatusToDisplay.toLowerCase();
						if (Validator.isNotNull(equivalencyStatusToDisplay) && Validator
								.isNotNull(EquivalencyRequestStatusEnum.getStatusByLabel(equivalencyStatusToDisplay))) {
							equivalencyAllRequests.setStatusColorClass(EquivalencyRequestStatusEnum
									.getStatusByLabel(equivalencyStatusToDisplay).getColor());
						}
					}

					try {
						if (!isEmployer) {
							FocalPoint focalPoint = new FocalPoint();
							User user = UserLocalServiceUtil
									.getUser(Long.valueOf(equivalencyRequest.getEmployerUserID()));

							focalPoint.setEmail(user.getEmailAddress());
							focalPoint.setName(user.getFullName());

							String personDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_PERSONAL_DETAILS_URL
									+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
									+ StringPool.QUESTION + "filter=lrUserId" + URLEncoder.encode(
											" eq " + equivalencyRequest.getEmployerUserID(), DataflowConstants.UTF_8);
							PersonalDetailItem personalDetailItem = CustomObjectMapperUtil
									.readValue(omsbCommonApi.getData(personDetailsUrl), PersonalDetailItem.class);
							if (Validator.isNotNull(personalDetailItem)
									&& Validator.isNotNull(personalDetailItem.getItems())
									&& personalDetailItem.getItems().size() > 0) {
								focalPoint.setMobileNumber(personalDetailItem.getItems().get(0).getMobileNumber());

								EmploymentDetailItem workDetails = equivalencyUtil.getEmploymentDetailItemByPersonId(
										themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										personalDetailItem.getItems().get(0).getPersonId());
								if (Validator.isNotNull(personalDetailItem)
										&& personalDetailItem.getItems().size() > 0) {
									for (EmploymentDetail workDetail : workDetails.getItems()) {
										if (Validator.isNotNull(workDetail.getPrimaryWorkDetail())
												&& workDetail.getPrimaryWorkDetail().equalsIgnoreCase("1")) {
											if (workDetail.getWorkSectorId() != 0) {
												WorkSector workSector = equivalencyUtil
														.getItems(
																themeDisplay.getPortalURL()
																		+ LRObjectURL.REG_GET_WORK_SECTOR_URL
																		+ workDetail.getWorkSectorId(),
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
						renderRequest.setAttribute("isVEHPCAdmin", isAdmin);
						renderRequest.setAttribute("isVEHPCCommittee", isCommittee);
						renderRequest.setAttribute("isVEHPCRapporteur", isRapporteur);
					} catch (UnsupportedEncodingException | PortalException e) {
						LOGGER.error(e.getMessage());
					}
				}
				equivalencyAllRequests.setEquivalencyRequestId(equivalencyRequest.getId());
				equivalencyAllRequests.setTransitions(JspTransitionWorkflowHandler.getNextTransitionNames(themeDisplay,
						getObjectClassName(themeDisplay.getCompanyId()), equivalencyRequest.getId()));
			} catch (JsonProcessingException e) {
				LOGGER.error(e.getMessage());
			}

			personId = jsoneqRequestResponseObj.getString("personId");
			equivalencyAllRequests.setPersonId(Long.parseLong(personId));
			try {
				String getPersonURL = generateScopeListURL(LRObjectURL.PERSON_URL, themeDisplay.getScopeGroupId());
				String finderQueryPerson = StringPool.QUESTION + "filter=id" + URLEncoder.encode(
						" eq '" + personId + "'", OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
				String personResponse = omsbHttpConnector.executeGet(getPersonURL + finderQueryPerson, "", headersInfo);
				JSONObject personJsonObj = JSONFactoryUtil.createJSONObject(personResponse);
				JSONArray getPersonJsonArrayResponse = personJsonObj
						.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
				try {
					SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);
					Date dateOB = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
							.parse(getPersonJsonArrayResponse.getJSONObject(0).getString("dateOfBirth"));
					dob = sdf.format(dateOB);
				} catch (ParseException e) {
					LOGGER.error(e.getMessage());
				}

				passportNumber = getPersonJsonArrayResponse.getJSONObject(0).getString("passportNumber");
			} catch (UnsupportedEncodingException | JSONException e) {
				LOGGER.error(e.getMessage());
			}
		} catch (JSONException e) {
			LOGGER.error(e.getMessage());
		}

		String getPersonDetailsURL = generateScopeListURL(
				LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL + "?filter=personId%20eq%20" + personId,
				themeDisplay.getScopeGroupId());
		String personDetailRes = omsbHttpConnector.executeGet(getPersonDetailsURL, "", headersInfo);

		PersonalDetailItems personalDetailsItems = CustomObjectMapperUtil.readValue(personDetailRes,
				PersonalDetailItems.class);

		if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
			LOGGER.info("Profession::::::" + personalDetailsItems.getItems().get(0).getProfession());
			
			if (Validator.isNotNull(personalDetailsItems.getItems().get(0).getProfession()) && 
					personalDetailsItems.getItems().get(0).getProfession().equalsIgnoreCase("other")) {
				LOGGER.info("Profession is other and setting other value::::::" + personalDetailsItems.getItems().get(0).getProfessionOther());
				personalDetailsItems.getItems().get(0).setProfession(personalDetailsItems.getItems().get(0).getProfessionOther());
			} else {
				LOGGER.info("Profession is not other and setting profession value::::::" + personalDetailsItems.getItems().get(0).getProfession());
				ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC,
						personalDetailsItems.getItems().get(0).getProfession(), themeDisplay.getCompanyId());
				if (Validator.isNotNull(entry)) {
					String proffesion = entry.getName(themeDisplay.getLocale());
					personalDetailsItems.getItems().get(0).setProfession(proffesion);
				}
			}

			long natinalityCountryId = personalDetailsItems.getItems().get(0).getNationalityCountryId();
			/* Custom country */
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
			
			/*Primary Specialty*/
			long primarySpecialtyId = personalDetailsItems.getItems().get(0).getPrimarySpeciality();
			if(Validator.isNotNull(primarySpecialtyId)) {
				ListTypeEntry primarySpecialtyListTypeEntry =omsbCommonApi.getListTypeEntryBylistTypeEntryId(primarySpecialtyId);
				if(Validator.isNotNull(primarySpecialtyListTypeEntry)) {
					renderRequest.setAttribute("primarySpecialty", primarySpecialtyListTypeEntry.getName(themeDisplay.getLocale()));
				}
			}
			
			renderRequest.setAttribute("personNatinality", countryName);
			renderRequest.setAttribute("personalDetail", personalDetailsItems.getItems().get(0));
		}

		/* Comments Part */

		String eqReqStatusURL = themeDisplay.getPortalURL() + LRObjectURL.GET_EQ_REQ_STATUS_BY_EqReqId_URL
				+ themeDisplay.getScopeGroupId() + "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId
				+ "&sort=dateCreated:desc" + StringPool.AMPERSAND + OmsbVehpcEquivalencyWebPortletKeys.URL_PAGE_SIZE;
		String eqReqStatusResponse = omsbHttpConnector.executeGet(eqReqStatusURL, StringPool.BLANK, headersInfo);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<EquivalencyRequestStatusResponse> eqReqStatusList = null;
		try {
			JSONObject eqReqStatusJsonObj = JSONFactoryUtil.createJSONObject(eqReqStatusResponse);
			Object eqReqStatusListJson = eqReqStatusJsonObj.get(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);
			eqReqStatusList = objectMapper.readValue(eqReqStatusListJson.toString(),
					new TypeReference<List<EquivalencyRequestStatusResponse>>() {
					});
		} catch (JSONException | JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		}

		EquivalencyCertificate certificate = getEquivalencyCertificateByEqRequest(themeDisplay, equivalencyRequestId);
		if (Validator.isNotNull(certificate)) {
			renderRequest.setAttribute("certificateName", certificate.getFileName());
			renderRequest.setAttribute("certificateURL", getFileURL(Long.valueOf(certificate.getFileEntryId())));
			LOGGER.info("certificate.getFileName()::" + certificate.getFileName() + "URL"
					+ getFileURL(Long.valueOf(certificate.getFileEntryId())));
		}

		/**
		 * Fetching equivalency documents by equivalencyRequestId
		 */
		String documentInfoResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + themeDisplay.getScopeGroupId()
						+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId + StringPool.AMPERSAND
						+ OmsbVehpcEquivalencyWebPortletKeys.URL_PAGE_SIZE,
				StringPool.BLANK, headersInfo);
		LOGGER.debug("documentInfoResponse :" + documentInfoResponse);
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
			List<DocumentInfo> caseReportList = new ArrayList<>();
			List<DocumentInfo> additionalDocumentList = new ArrayList<>();
			for (int i = 0; i < documentInfoItemsList.size(); i++) {
				LOGGER.debug("documentInfoItemsList :at " + i + " and the item is ?? "
						+ documentInfoItemsList.get(i).getDocumentType());
				DocumentInfo info = new DocumentInfo();
				info.setId(documentInfoItemsList.get(i).getId());
				String key = getEqDocumentQualificationTypeById(themeDisplay,
						documentInfoItemsList.get(i).getEquivalencyDocTypeId());
				LOGGER.debug("key  :at " + i + " is ?? " + key);
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
					info.setEvaluateDocTypeKey(key);
					// Add education s
					EducationalDetailItem item = equivalencyUtil.getEducationDetailById(
							documentInfoItemsList.get(i).getComponentClassRefId(), themeDisplay);
					if (Validator.isNotNull(item)) {
						ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, item.getQualificationAttained(), themeDisplay.getCompanyId());
						if (Validator.isNotNull(entry)) {
							info.setDocumentType(entry.getName(themeDisplay.getLocale()));
						} else {
							info.setDocumentType(item.getQualificationAttained());
						}
						info.setSuggestedEquivalencyLevel(item.getSuggestedEquivalencyLevel());
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
				} else if (documentInfoItemsList.get(i).getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.CASE_REPORT)) {
					String docType = getEqDocumentTypeById(themeDisplay,
							documentInfoItemsList.get(i).getEquivalencyDocTypeId());
					LOGGER.info("doc type::" + docType);
					info.setDocumentType(docType);
					caseReportList.add(info);

				} else if (documentInfoItemsList.get(i).getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE)) {
					String docType = getEqDocumentTypeById(themeDisplay,
							documentInfoItemsList.get(i).getEquivalencyDocTypeId());
					LOGGER.info("doc type::" + docType + " ?? documentInfoItemsList.get(i).getdFFileName() ?? "
							+ documentInfoItemsList.get(i).getdFFileName());
					info.setDocumentType(docType);
					info.setdFFileName(documentInfoItemsList.get(i).getdFFileName());
					additionalDocumentList.add(info);

				}
			}
			if (Validator.isNotNull(paymentDocumentList) && paymentDocumentList.size()>0) {
				renderRequest.setAttribute("paymentDocumentList", paymentDocumentList);
			}else {
				List<DocumentInfo> caseReportDocumentList = equivalencyUtil.getCaseReportListByPersonId(personId,themeDisplay);
				if (Validator.isNotNull(caseReportDocumentList) && caseReportDocumentList.size()>0) {
					renderRequest.setAttribute("caseReportDocumentList", caseReportDocumentList);
				}
			}
			LOGGER.info("case report list size::" + caseReportList.size());

			// EquivalencyRequestStatusComments statusComments = new
			// EquivalencyRequestStatusComments();

			boolean hasCommentAdded = Boolean.FALSE;
			for (int i = 0; i < eqReqStatusList.size(); i++) {
				if (themeDisplay.getUserId() == eqReqStatusList.get(i).getCommenterUserId() && isCommittee) {
					hasCommentAdded = Boolean.TRUE;
				}
				try {
					EquivalencyRequestStatusResponse statusResponse = new EquivalencyRequestStatusResponse();
					List<Role> rolesList = roleLocalService.getUserRoles(eqReqStatusList.get(i).getCommenterUserId());
					List<String> roleNames = rolesList.stream().map(Role::getName).collect(Collectors.toList());
					if (roleNames.contains(RoleNameConstants.EMPLOYER)) {
						continue;
					}
					statusResponse.setName(
							userLocalService.getUser(eqReqStatusList.get(i).getCommenterUserId()).getFullName());
					statusResponse.setComments(eqReqStatusList.get(i).getComments());
					statusResponse.setDateCreated(omsbCommonApi.convertDate(eqReqStatusList.get(i).getDateCreated()));

					List<String> nameList = rolesList.stream().map(Role::getName).collect(Collectors.toList());
					if (nameList.contains(RoleNameConstants.VEHPC_ADMIN)) {
						statusResponse.setRole(RoleNameConstants.VEHPC_ADMIN);
					} else if (nameList.contains(RoleNameConstants.VEHPC_COMMITTEE)) {
						statusResponse.setRole(RoleNameConstants.VEHPC_COMMITTEE);
					} else if (nameList.contains(RoleNameConstants.EMPLOYER)) {
						statusResponse.setRole(RoleNameConstants.EMPLOYER);
					} else if (nameList.contains(RoleNameConstants.VEHPC_RAPPORTEUR)) {
						statusResponse.setRole(RoleNameConstants.VEHPC_RAPPORTEUR);
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
					statusResponse.setDocumentList(
							equivalencyUtil.getCommentDocuments(eqReqStatusList.get(i).getId(), documentInfoItemsList));
					statusResponseList.add(statusResponse);
				} catch (PortalException e) {
					LOGGER.error(e.getMessage());
				}
			}
			renderRequest.setAttribute("hasCommentAdded", hasCommentAdded);

			DocumentInfo officialDocument = new DocumentInfo();
			if (Validator.isNotNull(officialReqeustDocumentList) && !officialReqeustDocumentList.isEmpty()) {
				officialDocument = officialReqeustDocumentList.get(0);
			}
			LOGGER.info("documentInfoItemsList" + documentInfoItemsList.size());
			renderRequest.setAttribute("documentInfoList", documentInfoItemsList);
			renderRequest.setAttribute("otherDocumentList", otherDocumentList);
			renderRequest.setAttribute("officialReqeustDocument", officialDocument);
			renderRequest.setAttribute("evaluatedDocumentList", evaluatedDocumentList);
			renderRequest.setAttribute("caseReportList", caseReportList);
			renderRequest.setAttribute("additionalDocumentList", additionalDocumentList);
			renderRequest.setAttribute("documentInfoItemsPojo", documentInfoItemsPojo.getItems());
		} catch (JsonProcessingException | NumberFormatException | PortalException e) {
			LOGGER.error(e.getMessage());
		}
		String equivalencyDesionResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.EQUIVALENCY_DECISION_BY_EQ_REQ_ID
						+ themeDisplay.getScopeGroupId() + "?filter=equivalencyRequestId+eq+" + equivalencyRequestId,
				StringPool.BLANK, headersInfo);
		LOGGER.info("equivalencyDesionResponse :" + equivalencyDesionResponse);
		EquivalencyDecisionItems decisionItems = CustomObjectMapperUtil.readValue(equivalencyDesionResponse,
				EquivalencyDecisionItems.class);

		for (int i = 0; i < decisionItems.getItems().size(); i++) {
			List<Role> rolesList = roleLocalService.getUserRoles(decisionItems.getItems().get(i).getDecisionBy());
			List<String> roleNames = rolesList.stream().map(Role::getName).collect(Collectors.toList());
			String documentInfoResp = omsbHttpConnector
					.executeGet(
							omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID
									+ themeDisplay.getScopeGroupId() + "?filter=equivalencyRequestId+eq+"
									+ decisionItems.getItems().get(i).getEquivalencyRequestId(),
							StringPool.BLANK, headersInfo);
			List<DocumentInfo> documentInfoItemsList = null;
			try {
				JSONObject documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResp);
				JSONArray itemsArray = documentInfoJsonObj.getJSONArray("items");
				documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
						new TypeReference<List<DocumentInfo>>() {
						});
			} catch (JSONException | JsonProcessingException e) {
				LOGGER.error(e.getMessage());
			}

			if (roleNames.contains(RoleNameConstants.VEHPC_COMMITTEE)) {
				renderRequest.setAttribute("vehpcDesion", decisionItems.getItems().get(i));
				renderRequest.setAttribute("certificateVehpcCommittee", documentInfoItemsList.get(i).getDocumentType());
				renderRequest.setAttribute("viewCertificateVehpc",
						equivalencyUtil.getFileURL(documentInfoItemsList.get(i).getFileEntryID()));
			} else if (roleNames.contains(RoleNameConstants.ADMIN)) {
				renderRequest.setAttribute("adminDesion", decisionItems.getItems().get(i));
				renderRequest.setAttribute("certificateAdmin", documentInfoItemsList.get(i).getDocumentType());
				renderRequest.setAttribute("viewCertificateAdmin",
						equivalencyUtil.getFileURL(documentInfoItemsList.get(i).getFileEntryID()));
			}
		}
		ObjectMapper objectMapper2 = new ObjectMapper();
		objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<EquivalencyDecision> equivelencyDecisionByEqIdResItemPojoList = null;
		HashMap<Long, EquivalencyDecision> commiteeDecision = new HashMap<Long, EquivalencyDecision>();
		HashMap<Long, EquivalencyDecision> adminDecision = new HashMap<Long, EquivalencyDecision>();
		try {
			String findEquivelencyDecisionByEqId = "?filter=equivalencyRequestId+eq+" + equivalencyRequestId;
			String findEquivelencyDecisionByEqIdURL = generateScopeListURL(
					LRObjectURL.EQUIVALENCY_DECISION_URL + findEquivelencyDecisionByEqId,
					themeDisplay.getScopeGroupId());
			String findEquivelencyDecisionByEqIdRes = omsbHttpConnector.executeGet(findEquivelencyDecisionByEqIdURL, "",
					headersInfo);
			LOGGER.info("findEquivelencyDecisionByEqIdRes:::::::1111111111:::::" + findEquivelencyDecisionByEqIdRes);
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

			if (Validator.isNotNull(equivelencyDecisionByEqIdResItemPojoList)
					&& equivelencyDecisionByEqIdResItemPojoList.size() > 0) {
				for (EquivalencyDecision equivalencyDecision : equivelencyDecisionByEqIdResItemPojoList) {
					equivalencyDecision.setQualification(
							getCertificateNameFromDocInfoId(equivalencyDecision.getDocumentInfoId(), themeDisplay));
					if (isAdmin && themeDisplay.getUserId() == equivalencyDecision.getDecisionBy()) {
						adminDecision.put(equivalencyDecision.getDocumentInfoId(), equivalencyDecision);
					} else {
						commiteeDecision.put(equivalencyDecision.getDocumentInfoId(), equivalencyDecision);
					}

				}
			}

			List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
					.collect(Collectors.toList());
			boolean isShowEquivalencyCertificate = true;
			boolean isShowEquivalencyLevel = true;

			if (isEmployer) {
				AppealConfiguration messageDisplayConfiguration = (AppealConfiguration) renderRequest
						.getAttribute(AppealConfiguration.class.getName());
				PortletPreferences portletPreserence = renderRequest.getPreferences();

				if (messageDisplayConfiguration != null) {

					String showEquivalencyCertificate = portletPreserence.getValue("showEquivalencyCertificate",
							"false");
					isShowEquivalencyCertificate = Boolean.parseBoolean(showEquivalencyCertificate);
					renderRequest.setAttribute("isShowEquivalencyCertificate", isShowEquivalencyCertificate);

					String showEquivalencyLevel = portletPreserence.getValue("showEquivalencyLevel", "false");
					isShowEquivalencyLevel = Boolean.parseBoolean(showEquivalencyLevel);
					renderRequest.setAttribute("isShowEquivalencyLevel", isShowEquivalencyLevel);
				}
			}
			renderRequest.setAttribute("isShowEquivalencyCertificate", isShowEquivalencyCertificate);
			renderRequest.setAttribute("isShowEquivalencyLevel", isShowEquivalencyLevel);
			renderRequest.setAttribute("isVEHPCEmployer", isEmployer);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		List<ListTypeEntry> eqLevelList = new ArrayList<>();
		List<ListTypeEntry> eqLevelReasonList = new ArrayList<>();
		if (isCommittee) {
			eqLevelList = omsbCommonApi.getListTypeEntriesByERC(
					OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC, themeDisplay.getCompanyId());
			eqLevelReasonList = omsbCommonApi.getListTypeEntriesByERC(
					OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC, themeDisplay.getCompanyId());
		}
		LOGGER.info("equivelencyDecisionByEqIdResItemPojoList::::::2222222::::::"
				+ equivelencyDecisionByEqIdResItemPojoList);
		renderRequest.setAttribute("eqLevelList", eqLevelList);
		renderRequest.setAttribute("eqLevelReasonList", eqLevelReasonList);
		renderRequest.setAttribute("adminDecisions", adminDecision);
		renderRequest.setAttribute("commiteeDecisions", commiteeDecision);
		renderRequest.setAttribute("equivelencyDecisionByEqIdResItemPojoList",
				equivelencyDecisionByEqIdResItemPojoList);
		renderRequest.setAttribute("equivalencyRequest", equivalencyAllRequests);
		renderRequest.setAttribute("dateOfBirth", dob);
		renderRequest.setAttribute("passportNumber", passportNumber);
		renderRequest.setAttribute("eqReqStatusList", eqReqStatusList);
		// renderRequest.setAttribute("commenterName", statusComments);
		renderRequest.setAttribute("statusResponseList", statusResponseList);

		LOGGER.info(" End Equivalency View Render()>>>");
		return EquivalencyJSPPathConstants.EQUIVALENCY_VIEW_JSP;
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

	private String getObjectClassName(long companyId) {
		try {
			ObjectDefinition definition = objectDefinitionService
					.getObjectDefinitionByExternalReferenceCode("OB_EUIVALENCY_REQUEST_ERC", companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

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

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyViewMVCRenderCommand.class);

}
