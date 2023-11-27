package omsb.vehpc.appeal.mvc.commands.render;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
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
import com.liferay.portal.kernel.util.Constants;
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
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
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
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.CertificatesDTO;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatusItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyRequest;
import gov.omsb.vehpc.appeal.dto.web.SearchDto;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.FocalPoint;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.ADD_APPEAL_DECISIONS_RENDER }, service = MVCRenderCommand.class)
public class AddAppealDecisionsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("EditAppealCommitteMVCRenderCommand invoked(");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long decisionId = ParamUtil.getLong(renderRequest, "equivalencyDecisionLevelId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		String transitionName = ParamUtil.getString(renderRequest, "transitionName");
		long eqAppealId = ParamUtil.getLong(renderRequest, "eqAppealId");
		String action = ParamUtil.getString(renderRequest, "action");
		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");
		String decisionUrlOld = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + eqAppealId;
		logger.info("decisionUrl ?? " + decisionUrlOld);
		String response = omsbHttpConnector.executeGet(decisionUrlOld, "", headerUtil.getHeaders());
		logger.info("response for appeal using EQ Decision Id?? " + response);
		EquivalencyAppeal equivalencyAppeal = CustomObjectMapperUtil.readValue(response, EquivalencyAppeal.class);
		Map<String,String> headersInfo= omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		User appeallantUser = null;
		String appealComments = "";
		String createdDate = "";
		String level = "";
		if (Validator.isNotNull(equivalencyAppeal)) {
			logger.info(" this is comments" + equivalencyAppeal.getComments());
			logger.info(" this is getAppellantUserId " + equivalencyAppeal.getAppellantUserId());
			logger.info(" this is eq appeal Id " + equivalencyAppeal.getId());
			appeallantUser = userLocalService.fetchUser(equivalencyAppeal.getAppellantUserId());
			appealComments = equivalencyAppeal.getComments();
			createdDate = equivalencyAppeal.getDateCreated();
			level = equivalencyAppeal.getEqLevelId();
			logger.info("Status Id :" + equivalencyAppeal.getStatusID());
			// renderRequest.setAttribute("appeallantStatus",
			// appealUtil.getStatus(equivalencyAppeal.getStatusID(), themeDisplay));
		}

		boolean hasRapporteurRole = hasUserRole(themeDisplay, themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_RAPPORTEUR);
		boolean hasVehpcCommitteeRole = hasUserRole(themeDisplay, themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasVehpcAdminRole = hasUserRole(themeDisplay, themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		boolean hasVehpcEmployerRole = hasUserRole(themeDisplay, themeDisplay.getUserId(), RoleNameConstants.EMPLOYER);
	
		renderRequest.setAttribute("hasRapporteurRole", hasRapporteurRole);
		renderRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		renderRequest.setAttribute("hasVehpcAdminRole", hasVehpcAdminRole);
		renderRequest.setAttribute("hasVehpcEmployerRole", hasVehpcEmployerRole);
		
		/////////////////////////////////////
		// get decision starts
		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.OB_EQUIVALENCY_APPEAL_DOCUMENT_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		decisionUrl = decisionUrl + "filter=eQAppealId"
				+ URLEncoder.encode(" eq " + eqAppealId, StandardCharsets.UTF_8);
		logger.info("decisionUrl decisionUrl decisionUrl decisionUrl decisionUrl " + decisionUrl);
		String descisionResponse = omsbHttpConnector.executeGet(decisionUrl, "", headerUtil.getHeaders());
		logger.info("descisionResponse descisionResponse descisionResponse descisionResponse descisionResponse "
				+ descisionResponse);

		EquivalencyAppealItems descisionEquivalencyAppeal = CustomObjectMapperUtil.readValue(descisionResponse,
				EquivalencyAppealItems.class);

		List<CertificatesDTO> certificatesList = new ArrayList<>();
		for (EquivalencyAppeal equivalencyAppealItems : descisionEquivalencyAppeal.getItems()) {

			CertificatesDTO certificatesDTO = new CertificatesDTO();
			long decisionLevelId = equivalencyAppealItems.getEqDecisionLevelId();

			String decisionsLevelurl = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL
					+ decisionLevelId;
			logger.info("decisionsLevelurl decisionsLevelurl decisionsLevelurl decisionsLevelurl decisionsLevelurl "
					+ decisionsLevelurl);
			String equivalencydecisionsurlresponse = omsbHttpConnector.executeGet(decisionsLevelurl, "",
					headerUtil.getHeaders());
			logger.info(
					"equivalencydecisionsurlresponse equivalencydecisionsurlresponse  equivalencydecisionsurlresponse  "
							+ equivalencydecisionsurlresponse);
			EquivalencyDecisionLevel decisionLevel = CustomObjectMapperUtil.readValue(equivalencydecisionsurlresponse,
					EquivalencyDecisionLevel.class);
			String comments = "";
			long decisiondocinfo = 0;
			String equivalencylevelkey = "";
			if (Validator.isNotNull(decisionLevel)) {
				EquivalencyLevel equivalencyLevel = decisionLevel.getEquivalencyLevelId();
				if (Validator.isNotNull(equivalencyLevel)) {
					certificatesDTO.setEquivalencyLevel(equivalencyLevel);
					equivalencylevelkey = equivalencyLevel.getKey();
				}
				logger.info(equivalencylevelkey + "keeeeeeeeeeyyyyyyyyyyyyyyyyyyyyyyyyyyy this line ");
				comments = decisionLevel.getComments();
				decisiondocinfo = decisionLevel.getDocumentInfoId();
			}

			//// documentInfoId
			String decisonCertificateUrl = themeDisplay.getPortalURL() + AppealConstants.DECISION_CERTIFICATE_URL
					+ decisiondocinfo;
			logger.info("decisonCertificateUrl              " + decisonCertificateUrl);
			String decisionInfoUrlResponse = omsbHttpConnector.executeGet(decisonCertificateUrl, "",
					headerUtil.getHeaders());
			logger.info("decisionInfoUrlResponse ?? " + decisionInfoUrlResponse);
			DocumentInfo decisiondocumentInfo = CustomObjectMapperUtil.readValue(decisionInfoUrlResponse,
					DocumentInfo.class);
			long decisonFileEntryId = decisiondocumentInfo.getFileEntryID();
			String certificateFileName = "";
			String certificatefileUrl = appealUtil.getFileURL(decisonFileEntryId);

			String key = getEqDocumentQualificationTypeById(themeDisplay,
					decisiondocumentInfo.getEquivalencyDocTypeId());

			if (decisiondocumentInfo.getDocumentType()
					.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.OTHER_DOCUMENTS_TYPE)) {
				certificateFileName = (getEqDocumentTypeNameByKey(OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC,
						key, themeDisplay));
			} else if (decisiondocumentInfo.getDocumentType()
					.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ETBA_DOCUMENTS_TYPE)) {
				certificateFileName = (getEqDocumentTypeNameByKey(
						OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC, key, themeDisplay));
			}

			logger.info("certificateFileName certificateFileName  certificateFileName  " + certificateFileName);

			///// document

			if (Validator.isNull(certificateFileName)) {
				FileEntry entry = appealUtil.getFileEntryById(decisonFileEntryId);

				if (Validator.isNotNull(entry)) {
					certificateFileName = entry.getFileName().replaceAll("^[0-9]+", "");
				}
			}

			certificatesDTO.setCertificatefileurl(certificatefileUrl);
			certificatesDTO.setEquivalencylevelkey(equivalencylevelkey);
			certificatesDTO.setComments(comments);
			certificatesDTO.setCertificateName(certificateFileName);
			certificatesDTO.setEquivalencyLevelId(decisionLevelId);
			certificatesList.add(certificatesDTO);
			renderRequest.setAttribute("certificatesList", certificatesList);
			renderRequest.setAttribute("size", certificatesList.size());
			/*
			 * renderRequest.setAttribute("equivalencylevelkey", equivalencylevelkey);
			 * renderRequest.setAttribute("certificatefileurl", certificatefileUrl);
			 * renderRequest.setAttribute("comments", comments);
			 * renderRequest.setAttribute("certificateName", certificateFileName);
			 */
		}

		/////////////////////////////////
		/*
		 * String equivalencyDecisionsUrl = themeDisplay.getPortalURL() +
		 * AppealConstants.DECISION_LEVEL_URL + decisionId; String
		 * equivalencyDecisionsResponse =
		 * omsbHttpConnector.executeGet(equivalencyDecisionsUrl, "",
		 * headerUtil.getHeaders()); logger.info("decision URL response is ?? " +
		 * equivalencyDecisionsResponse); EquivalencyDecisionLevel decision =
		 * CustomObjectMapperUtil.readValue(equivalencyDecisionsResponse,
		 * EquivalencyDecisionLevel.class); String comments = ""; long decisiondocinfo =
		 * 0; long equivalencyRequestId = 0; String equivalencylevelkey = ""; if
		 * (Validator.isNotNull(decision)) { EquivalencyLevel equivalencyLevelId =
		 * decision.getEquivalencyLevelId(); if
		 * (Validator.isNotNull(equivalencyLevelId)) {
		 * 
		 * equivalencylevelkey = equivalencyLevelId.getName(); }
		 * logger.info(equivalencylevelkey +
		 * "keeeeeeeeeeyyyyyyyyyyyyyyyyyyyyyyyyyyy this line "); comments =
		 * decision.getComments(); decisiondocinfo = decision.getDocumentInfoId();
		 * equivalencyRequestId = decision.getEqRequestId();
		 * logger.info("equivalencyRequestId 11 is ?? " + equivalencyRequestId); } ////
		 * documentInfoId String decisonCertificateUrl = themeDisplay.getPortalURL() +
		 * AppealConstants.DECISION_CERTIFICATE_URL + decisiondocinfo;
		 * logger.info("decisonCertificateUrl " + decisonCertificateUrl); String
		 * decisionInfoUrlResponse = omsbHttpConnector.executeGet(decisonCertificateUrl,
		 * "", headerUtil.getHeaders()); DocumentInfo decisiondocumentInfo =
		 * CustomObjectMapperUtil.readValue(decisionInfoUrlResponse,
		 * DocumentInfo.class); long decisomFileEntryId =
		 * decisiondocumentInfo.getFileEntryID(); String certificateFileName = "";
		 * 
		 * 
		 * FileEntry entry =
		 * appealUtil.getFileEntryById(decisiondocumentInfo.getFileEntryID()); if
		 * (Validator.isNotNull(entry)) { certificateFileName =
		 * entry.getFileName().replaceAll("^[0-9]+", ""); /// removing timeStamp from
		 * File Name } String certificatefileUrl = getFileURL(decisomFileEntryId); /////
		 * document String documentInfoUrl = themeDisplay.getPortalURL() +
		 * AppealConstants.DOCUMENT_INFO_CERTIFICATE_URL +
		 * themeDisplay.getScopeGroupId() + StringPool.QUESTION; documentInfoUrl =
		 * documentInfoUrl + "filter=equivalencyAppealId" + URLEncoder.encode(" eq " +
		 * eqAppealId, StandardCharsets.UTF_8); logger.info("documentInfoUrl " +
		 * documentInfoUrl); String documentInfoUrlResponse =
		 * omsbHttpConnector.executeGet(documentInfoUrl, "", headerUtil.getHeaders());
		 * 
		 * DocumentInfoItems docItems =
		 * CustomObjectMapperUtil.readValue(documentInfoUrlResponse,
		 * DocumentInfoItems.class); List<DocumentInfo> documentInfos = new
		 * ArrayList<>(); if (Validator.isNotNull(docItems.getItems()) &&
		 * !docItems.getItems().isEmpty()) { for (DocumentInfo info :
		 * docItems.getItems()) { DocumentInfo documentInfo = new DocumentInfo();
		 * documentInfo.setFileEntryID(info.getFileEntryID()); String docsfileurl =
		 * getFileURL(info.getFileEntryID());
		 * documentInfo.setdFFileName(info.getdFFileName());
		 * documentInfo.setDocsfileurl(docsfileurl); logger.info(docsfileurl +
		 * "========docsfileurldocsfileurldocsfileurldocsfileurlm");
		 * logger.info(info.getdFFileName() +
		 * "viewAppeal====================file name ==============================");
		 * documentInfos.add(documentInfo); } }
		 * 
		 * logger.info(" documentInfos size () ====" + documentInfos.size());
		 */

		long decisionLevelId = descisionEquivalencyAppeal.getItems().get(0).getEqDecisionLevelId();

		renderRequest.setAttribute("decisionLevelId", decisionLevelId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("workflowInstanceId", instanceId);
		String docAppealId = equivalencyAppeal.getId();

		String documentInfoUrl = themeDisplay.getPortalURL() + AppealConstants.DOCUMENT_INFO_CERTIFICATE_URL
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		String encodedDocAppealId = URLEncoder.encode(docAppealId, StandardCharsets.UTF_8);
		documentInfoUrl = documentInfoUrl + "filter=equivalencyAppealId"
				+ URLEncoder.encode(" eq " + encodedDocAppealId, StandardCharsets.UTF_8);
		logger.info("documentInfoUrl " + documentInfoUrl);
		String documentInfoUrlResponse = omsbHttpConnector.executeGet(documentInfoUrl, "", headerUtil.getHeaders());
		logger.info("documentInfoUrlResponse ============= " + documentInfoUrlResponse);
		DocumentInfoItems docItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfoItems.class);
		if(Validator.isNotNull(docItems) && docItems.getItems().size() >0) {
			for(DocumentInfo documentinfo : docItems.getItems()) {
				if(documentinfo.getPersonId() >0) {
					renderRequest.setAttribute("personId",documentinfo.getPersonId());
					break;
				}
			}
			
			
		}
		List<DocumentInfo> documentInfos = new ArrayList<>();
		List<DocumentInfo> additionalCommentDoc = new ArrayList<>();
		if (Validator.isNotNull(docItems.getItems()) && !docItems.getItems().isEmpty()) {
			for (DocumentInfo info : docItems.getItems()) {
				if (Validator.isNotNull(info.getDocumentType())) {

					ListTypeEntry documentTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							"PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC", info.getDocumentType(), themeDisplay.getCompanyId());
					if (Validator.isNotNull(documentTypeEntry)) {
						info.setDocumentTypeName(documentTypeEntry.getName(themeDisplay.getLocale()));
					}
					String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
					info.setDocsfileurl(docsfileurl);

					if (info.getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE) || info.getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE)) {
						additionalCommentDoc.add(info);
					} else {
						documentInfos.add(info);
					}
				}
			}
		}
		//get applicant details and focal point
				String eqRequestResponse = omsbHttpConnector.executeGet(
						omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
						StringPool.BLANK, headersInfo);
				EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(eqRequestResponse, EquivalencyRequest.class);
				if(Validator.isNotNull(equivalencyRequest)) {
					if (!hasVehpcEmployerRole) {
						FocalPoint focalPoint = new FocalPoint();
						User user;
						try {
							user = UserLocalServiceUtil
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
							}
							renderRequest.setAttribute("focalPoint", focalPoint);
						} catch (PortalException | UnsupportedEncodingException e) {
							logger.error("Error in getting focal point Details" + e.getMessage());
						}
					}
				}
				String personURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + equivalencyRequest.getPersonId();
				String personResponse = omsbHttpConnector.executeGet(personURL, StringPool.BLANK, headersInfo);
				Person person = CustomObjectMapperUtil.readValue(personResponse, Person.class);
				if(Validator.isNotNull(person)) {
					String passportNumber = person.getPassportNumber();
					String dateOfBirth = omsbCommonApi.convertDateFormatToDDMMYYYY(person.getDateOfBirth());
					renderRequest.setAttribute("passportNumber", passportNumber);
					renderRequest.setAttribute("dateOfBirth", dateOfBirth);
				}
				
				PersonalDetail personalDetail = appealUtil.getPersonalDetailByPersonId(equivalencyRequest.getPersonId(), themeDisplay);

				if (Validator.isNotNull(personalDetail)) {
					if (Validator.isNotNull(personalDetail.getProfession())) {
						ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
								OmsbVehpcEquivalencyWebPortletKeys.PROFESSION_ERC,
								personalDetail.getProfession(), themeDisplay.getCompanyId());
						if (Validator.isNotNull(entry)) {
							String proffesion = entry.getName(themeDisplay.getLocale());
							personalDetail.setProfession(proffesion);
						}
					}

					long natinalityCountryId = personalDetail.getNationalityCountryId();
					/* Custom country */
					Country country = null;
					String countryName = "";
					if (natinalityCountryId > 0) {
						try {
							country = countryLocalService.getCountry(natinalityCountryId);
						} catch (PortalException e) {
							logger.error("Exception while getting the country ", e);
						}
					}
					if (Validator.isNotNull(country)) {
						countryName =country.getName(themeDisplay.getLocale());
					}
					
					/*Primary Specialty*/
					long primarySpecialtyId = Long.parseLong(personalDetail.getPrimarySpeciality());
					if(Validator.isNotNull(primarySpecialtyId)) {
						ListTypeEntry primarySpecialtyListTypeEntry =omsbCommonApi.getListTypeEntryBylistTypeEntryId(primarySpecialtyId);
						if(Validator.isNotNull(primarySpecialtyListTypeEntry)) {
							renderRequest.setAttribute("primarySpecialty", primarySpecialtyListTypeEntry.getName(themeDisplay.getLocale()));
						}
					}
					
					renderRequest.setAttribute("personNatinality", countryName);
					renderRequest.setAttribute("personalDetail", personalDetail);
				}
				renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
				
				
		//setting evaluated document for certificate
		if(hasVehpcAdminRole) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String documentInfoResponse = omsbHttpConnector.executeGet(
					omsbCommonApi.getBaseURL() + LRObjectURL.DOCUMENT_INFO_BY_EQ_DOCTYPE_ID + themeDisplay.getScopeGroupId()
							+ "?filter=equivalencyRequestId%20eq%20" + equivalencyRequestId + StringPool.AMPERSAND
							+ OmsbVehpcEquivalencyWebPortletKeys.URL_PAGE_SIZE,
					StringPool.BLANK, headersInfo);
			JSONObject documentInfoJsonObj;
			try {
				documentInfoJsonObj = JSONFactoryUtil.createJSONObject(documentInfoResponse);
				JSONArray itemsArray = documentInfoJsonObj.getJSONArray("items");
				List<DocumentInfo> documentInfoItemsList = objectMapper.readValue(itemsArray.toString(),
						new TypeReference<List<DocumentInfo>>() {
						});
				List<DocumentInfo> evaluatedDocumentList = new ArrayList<>();
				for (int i = 0; i < documentInfoItemsList.size(); i++) {
					DocumentInfo info = new DocumentInfo();
					String key = getEqDocumentQualificationTypeById(themeDisplay,
							documentInfoItemsList.get(i).getEquivalencyDocTypeId());
					if(Validator.isNotNull(documentInfoItemsList.get(i).getDocumentType())) {
						if (documentInfoItemsList.get(i).getDocumentType()
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
								info.setDocumentType(item.getQualificationAttained());
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
						}
					}
					
				}
				renderRequest.setAttribute("evaluatedDocumentList", evaluatedDocumentList);
			} catch (JsonProcessingException | NumberFormatException | PortalException e) {
				logger.error("Error in getting Evaluated Certificate" + e.getMessage());
			}
		}

		String appealRequestStatusurl = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_STATUS_URL_VIEW
				+ "/scopes/" + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		appealRequestStatusurl = appealRequestStatusurl + "filter=eQAppealId"
				+ URLEncoder.encode(" eq " + eqAppealId, StandardCharsets.UTF_8) + AppealConstants.PAGE_SIZE;
		logger.info("appealRequestStatusurl============================== " + appealRequestStatusurl);
		String appealRequestStatusurlresponse = omsbHttpConnector.executeGet(appealRequestStatusurl, "",
				headerUtil.getHeaders());
		EquivalencyAppealStatusItems equivalencyAppealStatusItems = CustomObjectMapperUtil
				.readValue(appealRequestStatusurlresponse, EquivalencyAppealStatusItems.class);
		List<EquivalencyAppealStatus> list = new ArrayList<>();
		if (Validator.isNotNull(equivalencyAppealStatusItems.getItems())
				&& !equivalencyAppealStatusItems.getItems().isEmpty()) {
			for (EquivalencyAppealStatus appealStatus : equivalencyAppealStatusItems.getItems()) {
				EquivalencyAppealStatus status = new EquivalencyAppealStatus();
				status.setMessage(appealStatus.getMessage());
				String fullName = getFullName(appealStatus.getLruserId());
				String roleType = getRoleName(appealStatus.getLruserId());
				status.setRoleType(roleType);
				status.setFullName(fullName);
				status.setDateCreated(omsbCommonApi.convertDate(appealStatus.getDateCreated()));
				status.setIscommitte(appealStatus.isIscommitte());
				status.setIsPresident(appealStatus.isIsPresident());
				status.setIsAdmin(appealStatus.isIsAdmin());
				status.setEqLevelId(appealStatus.getEqLevelId());
				String eqAppealLevel = StringPool.BLANK;
				if (Validator.isNotNull(appealStatus.getEquivalencyLevelKey())) {
					ListTypeEntry levelListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC,
							appealStatus.getEquivalencyLevelKey(), themeDisplay.getCompanyId());
					;
					if (Validator.isNotNull(levelListTypeEntry)) {
						eqAppealLevel = levelListTypeEntry.getName(themeDisplay.getLocale());
					}
				}
				status.setEquivalencyLevelKey(appealStatus.getEquivalencyLevelKey());
				status.setEquivalencyLevelName(eqAppealLevel);
				status.setDocumentList(getCommentDocuments(appealStatus.getId(), additionalCommentDoc));
				list.add(status);
			}
		}

		if (list.size() > 0) {
			renderRequest.setAttribute("recentAppealStatus", list.get(0));
		}

		Set<SearchDto> adminSearchDtos = appealUtil.getAllData(themeDisplay);
		List<SearchDto> searchList = new ArrayList<>(adminSearchDtos);
		searchList.sort(Comparator.comparing(SearchDto::getId).reversed());
		renderRequest.setAttribute("adminSearchDtos", searchList);

		List<ListTypeEntry> listTypeEntries = omsbCommonApi.getListTypeEntriesByERC(AppealConstants.PL_EQ_LEVEL,
				themeDisplay.getCompanyId());
		renderRequest.setAttribute("equivalencyLevelList", listTypeEntries);
		renderRequest.setAttribute("equivalencyDecisionId", decisionId);
		renderRequest.setAttribute("statusList", list);
		renderRequest.setAttribute("docsList", documentInfos);
		renderRequest.setAttribute("appealId", eqAppealId);
		String appeallantUserRole = "";
		if (Validator.isNotNull(appeallantUser)) {
			appeallantUserRole = getRoleName(appeallantUser.getUserId());
			renderRequest.setAttribute("appeallantUserName", appeallantUser.getFullName());
		}
		List<ListTypeEntry> eqLevelReasonList = new ArrayList<>();
		if (hasRapporteurRole || hasVehpcAdminRole) {
			eqLevelReasonList = omsbCommonApi.getListTypeEntriesByERC(
					OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC, themeDisplay.getCompanyId());
		}
		String dateStringArray[] = getTodaysDateInStringArray(); 
		renderRequest.setAttribute("currentDay",dateStringArray[0]);
		renderRequest.setAttribute("currentMonth",dateStringArray[1].toLowerCase());
		renderRequest.setAttribute("currentYear",dateStringArray[2]);
		renderRequest.setAttribute("eqLevelReasonList", eqLevelReasonList);
		renderRequest.setAttribute("appeallantUserRole", appeallantUserRole);
		renderRequest.setAttribute("createdDate", omsbCommonApi.convertDate(createdDate));
		/* renderRequest.setAttribute("certificateName", certificateFileName); */
		renderRequest.setAttribute("appealComments", appealComments);
		renderRequest.setAttribute("level", level);
		renderRequest.setAttribute(Constants.CMD, cmd);
		renderRequest.setAttribute("transitionName", transitionName);
		renderRequest.setAttribute("workflowInstanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("appealStatusColur", appealUtil.getColorMap());
		renderRequest.setAttribute("personalDetail", personalDetail);
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
		

		logger.info("EditAppealCommitteMVCRenderCommand ended");
		return AppealConstants.ADD_APPEAL_DECISIONS_JSP;
	}

	private String getEqDocumentTypeNameByKey(String erc, String key, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(erc, key, themeDisplay.getCompanyId());
		String documentType = "";
		if (Validator.isNotNull(entry)) {
			documentType = entry.getName(themeDisplay.getLocale());
		}
		return documentType;
	}
	
	private String[] getTodaysDateInStringArray() {
		LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        String dateString = dtf.format(localDate);
        return dateString.split(" ");
	}

	private String getEqDocumentQualificationTypeById(ThemeDisplay themeDisplay, long eqDocTypeId) {
		String docType = "";
		String equivalencyDocTypeUrl = themeDisplay.getPortalURL() + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
				+ eqDocTypeId;
		String equivalencyDocTypeResponse = omsbCommonApi.getData(equivalencyDocTypeUrl);
		EquivalencyDocumentType equivalencyDocumentType = CustomObjectMapperUtil.readValue(equivalencyDocTypeResponse,
				EquivalencyDocumentType.class);
		if (Validator.isNotNull(equivalencyDocumentType)
				&& Validator.isNotNull(equivalencyDocumentType.getEquivalencyDocType())
				&& !equivalencyDocumentType.getEquivalencyDocType().isEmpty()) {
			docType = equivalencyDocumentType.getQualification();
		}
		return docType;
	}

	private String getFileURL(long fileEntryId) {
		try {

			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			String fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			logger.info("url ?? " + fileUrl);
			return fileUrl;
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	private boolean hasUserRole(ThemeDisplay themeDisplay, long userId, String roleName) {
		Role role = roleLocalService.fetchRole(themeDisplay.getCompanyId(), roleName);
		if (Validator.isNotNull(role)) {
			return roleLocalService.hasUserRole(userId, role.getRoleId());
		}
		return false;

	}

	private String getRoleName(long userId) {
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
		List<String> userRoleNames = userRoles.stream().map(Role::getName).collect(Collectors.toList());
		logger.info("roleNames are ??" + userRoleNames.toString());
		if (userRoleNames.contains(RoleNameConstants.EMPLOYER)) {
			return RoleNameConstants.EMPLOYER;
		} else if (userRoleNames.contains(RoleNameConstants.EXECUTIVE_PRESIDENT)) {
			return RoleNameConstants.EXECUTIVE_PRESIDENT;
		} else if (userRoleNames.contains(RoleNameConstants.VEHPC_ADMIN)) {
			return RoleNameConstants.VEHPC_ADMIN;
		} else if (userRoleNames.contains(RoleNameConstants.VEHPC_COMMITTEE)) {
			return RoleNameConstants.VEHPC_COMMITTEE;
		} else if (userRoleNames.contains(RoleNameConstants.EMPLOYEE)) {
			return RoleNameConstants.EMPLOYEE;
		}
		return "";
	}

	private String getFullName(long userId) {
		User user = userLocalService.fetchUser(userId);
		if (Validator.isNotNull(user)) {
			return user.getFullName();
		}
		return "";
	}

	public List<DocumentInfo> getCommentDocuments(long eqStatusId, List<DocumentInfo> documentInfoList) {
		List<DocumentInfo> documentInfos = new ArrayList<>();
		for (DocumentInfo info : documentInfoList) {
			if (info.getComponentClassRefId() == eqStatusId) {
				String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
				info.setDocumentType(info.getDocumentType());
				info.setDocsfileurl(docsfileurl);
				documentInfos.add(info);
			}
		}
		return documentInfos;
	}
	private EducationalDetailItem getEducationDetailById(long educationId, ThemeDisplay themeDisplay) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + educationId;
		String response = omsbCommonApi.getData(url);
		EducationalDetailItem educationRes = CustomObjectMapperUtil.readValue(response, EducationalDetailItem.class);
		return educationRes;
	}
	private long getYearFromStringDate(String dateOfGraduation) {
		String convertedDateOfGraduation =omsbCommonApi.convertObjectDateToDDMMYYYYDate(dateOfGraduation);
		String[] inputs = convertedDateOfGraduation.split("/");
		return Long.parseLong(inputs[inputs.length-1]);
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private HeaderUtil headerUtil;
	
	@Reference
	private CountryLocalService countryLocalService;

	private static final Log logger = LogFactoryUtil.getLog(AddAppealDecisionsMVCRenderCommand.class);

}
