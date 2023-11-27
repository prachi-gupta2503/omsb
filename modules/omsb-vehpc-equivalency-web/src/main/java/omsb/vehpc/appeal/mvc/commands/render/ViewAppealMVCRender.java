package omsb.vehpc.appeal.mvc.commands.render;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
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
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
import gov.omsb.common.constants.EquivalencyRequestStatusEnum;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.CertificatesDTO;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatusItems;
import gov.omsb.vehpc.appeal.dto.web.SearchDto;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyStatus;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.AppealWrokflowUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.VIEW_APPEAL_ALL }, service = MVCRenderCommand.class)
public class ViewAppealMVCRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("calling here ViewAppealMVCRender ?? ");
		// workFlow related task
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long equivalencyRequestId = ParamUtil.getLong(renderRequest, "equivalencyRequestId");

		// long decisionLevelId = ParamUtil.getLong(renderRequest,
		// "equivalencyDecisionLevelId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		long eqAppealId = ParamUtil.getLong(renderRequest, "eqAppealId");
		boolean assignedToMe = ParamUtil.getBoolean(renderRequest, "assignedToMe");

		// for appeal details starts

		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

		boolean hasVehpcCommitteeRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasRapporteur = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_RAPPORTEUR);
		boolean hasVehpcCAdminRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_ADMIN);
		boolean hasEmployerRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.EMPLOYER);
//		boolean hasEmployeeRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
//				RoleNameConstants.EMPLOYEE);

		if (hasVehpcCommitteeRole || hasRapporteur || hasVehpcCAdminRole) {

			Set<SearchDto> adminSearchDtos = appealUtil.getAllDataByEqId(themeDisplay, equivalencyRequestId);
			List<SearchDto> searchList = new ArrayList<>(adminSearchDtos);
			searchList.sort(Comparator.comparing(SearchDto::getId).reversed());
			assignedToMe = searchList.get(0).isAssignedToMe();
			workflowTaskId = searchList.get(0).getWorkflowTaskId();
			instanceId = searchList.get(0).getWorkflowInstanceId();
		}

		// ends

		/*
		 * boolean hasVehpcCommitteeRole =
		 * omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(),
		 * themeDisplay.getUserId(), RoleNameConstants.VEHPC_COMMITTEE); boolean
		 * hasExecutePresidentRole =
		 * omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(),
		 * themeDisplay.getUserId(), RoleNameConstants.EXECUTIVE_PRESIDENT); boolean
		 * hasVehpcCAdminRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(),
		 * themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		 */

		try {
			logger.info("equivalencyRequestId" + equivalencyRequestId);
			logger.info("instanceId" + instanceId);
			logger.info("eqAppealId" + eqAppealId);
			logger.info("WFWFWFWFFFFFFFFFFFFFFFFF " + workflowTaskId);
			List<String> transitionNames = appealWrokflowUtil.getTransitionNames(themeDisplay, workflowTaskId);
			logger.info("transitionNames transitionNames transitionNames v transitionNames" + transitionNames);
			renderRequest.setAttribute("transitionNames", transitionNames);
		} catch (WorkflowException e) {
			logger.error(e.getMessage(), e);
		}

		renderRequest.setAttribute("workflowInstanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute(Constants.CMD, cmd);
		renderRequest.setAttribute("assignedToMe", assignedToMe);
		// renderRequest.setAttribute("decisionLevelId", decisionLevelId);
		renderRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		renderRequest.setAttribute("hasRapporteur", hasRapporteur);
		renderRequest.setAttribute("hasVehpcCAdminRole", hasVehpcCAdminRole);
		renderRequest.setAttribute("hasVehpcEmployerRole", hasEmployerRole);
		renderRequest.setAttribute("appealStatusColur", appealUtil.getColorMap());

		// =========== get appeal id starts
		String appealUrl = themeDisplay.getPortalURL() + AppealConstants.OB_EQUIVALENCY_APPEAL_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		appealUrl = appealUrl + "filter=eQRequestedId"
				+ URLEncoder.encode(" eq " + equivalencyRequestId, StandardCharsets.UTF_8);

		String appealResponse = omsbHttpConnector.executeGet(appealUrl, "", headerUtil.getHeaders());

		EquivalencyAppealItems equivalencyAppeal = CustomObjectMapperUtil.readValue(appealResponse,
				EquivalencyAppealItems.class);
		if (Validator.isNotNull(equivalencyAppeal) && equivalencyAppeal.getItems().size() > 0) {
			renderRequest.setAttribute("equivalencyAppeal", equivalencyAppeal.getItems().get(0));
			eqAppealId = Long.valueOf(equivalencyAppeal.getItems().get(0).getId());
		}
		renderRequest.setAttribute("appealId", eqAppealId);

		// get decision starts
		String equivalencyAppealDocumentUrl = themeDisplay.getPortalURL() + AppealConstants.OB_EQUIVALENCY_APPEAL_DOCUMENT_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		equivalencyAppealDocumentUrl = equivalencyAppealDocumentUrl + "filter=eQAppealId"
				+ URLEncoder.encode(" eq " + eqAppealId, StandardCharsets.UTF_8);
		String equivalencyAppealDocumentResponse = omsbHttpConnector.executeGet(equivalencyAppealDocumentUrl, "", headerUtil.getHeaders());

		EquivalencyAppealItems equivalencyAppealItems = CustomObjectMapperUtil.readValue(equivalencyAppealDocumentResponse,
				EquivalencyAppealItems.class);

		List<CertificatesDTO> certificatesList = new ArrayList<>();
		for (EquivalencyAppeal equivalencyAppeals : equivalencyAppealItems.getItems()) {

			CertificatesDTO certificatesDTO = new CertificatesDTO();
//			String equivalencyLevelKey = StringPool.BLANK;
//			if(Validator.isNotNull( equivalencyAppeals.getEqLevel())) {
//				equivalencyLevelKey = equivalencyAppeals.getEqLevel();
//				ListTypeEntry equivalencyListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC,equivalencyLevelKey,themeDisplay.getCompanyId());
//				if(Validator.isNotNull(equivalencyListTypeEntry)) {
//					EquivalencyLevel equivalencyLevel = new EquivalencyLevel();
//					equivalencyLevel.setKey(equivalencyListTypeEntry.getKey());
//					equivalencyLevel.setName(equivalencyListTypeEntry.getName(themeDisplay.getLocale()));
//					certificatesDTO.setEquivalencyLevel(equivalencyLevel);
//				}
//			}
			
			long decisionLevelId = equivalencyAppeals.getEqDecisionLevelId();
			certificatesDTO.setDecisionLevelId(decisionLevelId);
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
			String comments = StringPool.BLANK;
			String appealComments = StringPool.BLANK;
			String equivalencyReasonKey=StringPool.BLANK;
			long decisiondocinfo = 0;
			if (Validator.isNotNull(decisionLevel)) {
				EquivalencyLevel appealLevel = decisionLevel.getEquivalencyLevelId();
				if (Validator.isNotNull(appealLevel)) {
					certificatesDTO.setAppealLevel(appealLevel);
				}
				if(Validator.isNotNull(appealLevel) && appealLevel.getKey().equals("none")) {
					ListTypeEntry appealReasonListTypeEntry =omsbCommonApi.getListTypeEntryByListTypeItemKey(OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC,decisionLevel.getEquivalencyLevelReason(), themeDisplay.getCompanyId());
					if(Validator.isNotNull(appealReasonListTypeEntry)) {
						EquivalencyLevel appealLevelReason = new EquivalencyLevel();
						appealLevelReason.setKey(appealReasonListTypeEntry.getKey());
						appealLevelReason.setName(appealReasonListTypeEntry.getName(themeDisplay.getLocale()));
						certificatesDTO.setEquivalencyLevelReason(appealLevelReason);
					}
				}

				appealComments = decisionLevel.getComments();
				certificatesDTO.setAppealComments(appealComments);
				
				decisiondocinfo = decisionLevel.getDocumentInfoId();
			}
			
			
			//Get EquivalencyDecision by docInfoId
			try {
				String equivalencyDecisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_DECISION_URL+CommonConstants.SCOPES+StringPool.SLASH
								+themeDisplay.getScopeGroupId() + "?filter=documentInfoId"+ 
								URLEncoder.encode(" eq " + decisiondocinfo, DataflowConstants.UTF_8) +AppealConstants.PAGE_SIZE;
				String equivalencyDecisionResponse = omsbHttpConnector.executeGet(equivalencyDecisionUrl, StringPool.BLANK, headersInfo);
				EquivalencyDecisionItems equivalencyDecisionItems = CustomObjectMapperUtil.readValue(equivalencyDecisionResponse, EquivalencyDecisionItems.class);
				if(Validator.isNotNull(equivalencyDecisionItems) && equivalencyDecisionItems.getItems().size()>0) {
					for(EquivalencyDecision equivalencyDecision : equivalencyDecisionItems.getItems()) {
						EquivalencyStatus equivalencyStatus = equivalencyDecision.getEquivalencyStatus();
						if(equivalencyStatus.getKey().equals(AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_COMPLETED)) {
							comments = equivalencyDecision.getComments();
							if(Validator.isNotNull(equivalencyDecision.getEquivalencyLevelId())) {
								EquivalencyLevel equivalencyLevel = equivalencyDecision.getEquivalencyLevelId();
								certificatesDTO.setEquivalencyLevel(equivalencyLevel);
								equivalencyReasonKey = equivalencyDecision.getOtherEquivalency();
								if(equivalencyDecision.getEquivalencyLevelId().getKey().equals("none")) {
									ListTypeEntry equivalencyReasonListTypeEntry =omsbCommonApi.getListTypeEntryByListTypeItemKey(OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC,equivalencyReasonKey, themeDisplay.getCompanyId());
									if(Validator.isNotNull(equivalencyReasonListTypeEntry)) {
										EquivalencyLevel equivalencyLevelReason = new EquivalencyLevel();
										equivalencyLevelReason.setKey(equivalencyReasonListTypeEntry.getKey());
										equivalencyLevelReason.setName(equivalencyReasonListTypeEntry.getName(themeDisplay.getLocale()));
										certificatesDTO.setEquivalencyLevelReason(equivalencyLevelReason);
									}
								}
							}
							break;
						}
					}
				}
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			};
			
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
			
			if (Validator.isNotNull(decisiondocumentInfo)
					&& Validator.isNotNull(decisiondocumentInfo.getDocumentType())) {
				if (decisiondocumentInfo.getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.OTHER_DOCUMENTS_TYPE)) {
					certificateFileName = (getEqDocumentTypeNameByKey(
							OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, key, themeDisplay));
				} else if (decisiondocumentInfo.getDocumentType()
						.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ETBA_DOCUMENTS_TYPE)) {
					certificateFileName = (getEqDocumentTypeNameByKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_QUALIFICATION_ERC, key, themeDisplay));
				}
			}

			logger.info("certificateFileName certificateFileName  certificateFileName  " + certificateFileName);
			///// document

			if (Validator.isNull(certificateFileName)) {
				FileEntry entry = appealUtil.getFileEntryById(decisonFileEntryId);

				if (Validator.isNotNull(entry)) {
					certificateFileName = entry.getFileName().replaceAll("^[0-9]+", ""); /// removing timeStamp from
																							/// File
																							/// Name
				}
			}
			certificatesDTO.setCertificatefileurl(certificatefileUrl);
			certificatesDTO.setComments(comments);
			certificatesDTO.setCertificateName(certificateFileName);
			certificatesList.add(certificatesDTO);
			renderRequest.setAttribute("certificatesList", certificatesList);
			renderRequest.setAttribute("decisionLevelId", decisionLevelId);
			boolean appeal = isAppealExist(decisionLevelId, themeDisplay);
			renderRequest.setAttribute("appeal", appeal);
		}

		// get decision level starts

		/*
		 * String decisionLevelUrl = themeDisplay.getPortalURL() +
		 * AppealConstants.OB_EQUIVALENCY_APPEAL_DOCUMENT_URL + StringPool.SLASH +
		 * decisionLevelId;
		 * 
		 * 
		 * logger.
		 * info("decisionLevelUrl decisionLevelUrl decisionLevelUrl decisionLevelUrl decisionLevelUrl "
		 * + decisionLevelUrl); String descisionLevelResponse =
		 * omsbHttpConnector.executeGet(decisionLevelUrl, "", headerUtil.getHeaders());
		 * logger.
		 * info("descisionLevelResponse descisionLevelResponse descisionLevelResponse descisionLevelResponse descisionLevelResponse "
		 * + descisionLevelResponse);
		 * 
		 * DocumentInfo docInfo = CustomObjectMapperUtil.readValue(descisionResponse,
		 * DocumentInfo.class);
		 * 
		 * long documentInfolId = docInfo.getDocumentInfoId();
		 */

		// get doc info id starts

		/*
		 * String docInfoUrl = themeDisplay.getPortalURL() +
		 * AppealConstants.OB_DOCUMENT_INFO_URL + StringPool.SLASH + documentInfolId;
		 * 
		 * String docInfoResponse = omsbHttpConnector.executeGet(docInfoUrl, "",
		 * headerUtil.getHeaders()); docInfo =
		 * CustomObjectMapperUtil.readValue(docInfoResponse, DocumentInfo.class);
		 * 
		 * logger.
		 * info("docInfoResponse docInfoResponse docInfoResponse docInfoResponse docInfoResponse "
		 * + docInfoResponse);
		 */

		// long decisionLevelId =
		// descisionEquivalencyAppeal.getItems().get(0).geteQDecisionId();

		// ends

		// ===========

//		long decisionLevelId = 0l;
//		if (Validator.isNotNull(equivalencyAppealItems) && equivalencyAppealItems.getItems().size() > 0) {
//			decisionLevelId = equivalencyAppealItems.getItems().get(0).getEqDecisionLevelId();
//		}

		
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("workflowInstanceId", instanceId);
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
		String docAppealId = "";
		User appeallantUser = null;
		String appealComments = "";
		String createdDate = "";
		String level = "";

		if (Validator.isNotNull(equivalencyAppeal) && Validator.isNotNull(equivalencyAppeal.getItems())
				&& !equivalencyAppeal.getItems().isEmpty()) {
			logger.info(" this is comments" + equivalencyAppeal.getItems().get(0).getComments());
			logger.info(" this is comments" + equivalencyAppeal.getItems().get(0).getAppellantUserId());
			appeallantUser = userLocalService.fetchUser(equivalencyAppeal.getItems().get(0).getAppellantUserId());
			docAppealId = String.valueOf(equivalencyAppeal.getItems().get(0).getId());
			appealComments = equivalencyAppeal.getItems().get(0).getComments();
			createdDate = equivalencyAppeal.getItems().get(0).getDateCreated();
			if(Validator.isNotNull(equivalencyAppeal.getItems().get(0).getEqLevelId()) && !equivalencyAppeal.getItems().get(0).getEqLevelId().equals(StringPool.BLANK)) {
				level = omsbCommonApi.getListTypeEntryByListTypeItemKey(OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC, equivalencyAppeal.getItems().get(0).getEqLevelId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale());
			}
			long statusId = equivalencyAppeal.getItems().get(0).getStatusID();
			ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(statusId);
			if (Validator.isNotNull(listTypeEntry)) {
				renderRequest.setAttribute("appealStatusId", statusId);
				String appealStatusKey = listTypeEntry.getKey();

				String label = appealUtil.getFinalStatus(hasEmployerRole, hasVehpcCommitteeRole, hasVehpcCAdminRole,
						listTypeEntry.getKey(), hasRapporteur);

				String appealStatus = appealUtil.getFinalStatusValue(hasVehpcCAdminRole, hasEmployerRole, label,
						themeDisplay, appealStatusKey);
				label = label.toLowerCase();
				if (Validator.isNotNull(label)
						&& Validator.isNotNull(EquivalencyRequestStatusEnum.getStatusByLabel(label))) {
					renderRequest.setAttribute("appealStatusColor",
							EquivalencyRequestStatusEnum.getStatusByLabel(label).getColor());
				}
				renderRequest.setAttribute("appealStatusKey", appealStatusKey);
				renderRequest.setAttribute("appealStatus", appealStatus);
			}

			renderRequest.setAttribute("appeallantStatus", appealUtil.getStatus(statusId, themeDisplay));
		}

		String documentInfoUrl = themeDisplay.getPortalURL() + AppealConstants.DOCUMENT_INFO_CERTIFICATE_URL
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		String encodedDocAppealId = URLEncoder.encode(docAppealId, StandardCharsets.UTF_8);
		documentInfoUrl = documentInfoUrl + "filter=equivalencyAppealId"
				+ URLEncoder.encode(" eq " + encodedDocAppealId, StandardCharsets.UTF_8);
		logger.info("documentInfoUrl " + documentInfoUrl);
		String documentInfoUrlResponse = omsbHttpConnector.executeGet(documentInfoUrl, "", headerUtil.getHeaders());
		logger.info("documentInfoUrlResponse ============= " + documentInfoUrlResponse);
		DocumentInfoItems docItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfoItems.class);
		List<DocumentInfo> documentInfos = new ArrayList<>();
		List<DocumentInfo> additionalCommentDoc = new ArrayList<>();
		if (Validator.isNotNull(docItems.getItems()) && !docItems.getItems().isEmpty()) {
			for (DocumentInfo info : docItems.getItems()) {
				String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
				info.setDocsfileurl(docsfileurl);
				if (Validator.isNotNull(info.getDocumentType())) {
					logger.info("docType=============================================" + info.getDocumentType());
					if (info.getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE)
							||info.getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE)) {
						
						additionalCommentDoc.add(info);
//						info.setDocumentType("comment");
					}
//					else if(info.getDocumentType()
//							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE)) {
//						String eqAppealStatusUrl = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_STATUS_URL_VIEW + info.getComponentClassRefId();
//						String eqAppealStatusResponse = omsbHttpConnector.executeGet(eqAppealStatusUrl, StringPool.BLANK, headerUtil.getHeaders());
//						EquivalencyAppealStatus eqAppealStatus = CustomObjectMapperUtil.readValue(eqAppealStatusResponse, EquivalencyAppealStatus.class);
//						if(Validator.isNotNull(eqAppealStatus)) {
//							info.setEquivalencyCertificate(eqAppealStatus.getEquivalencyCertificate());
//						}
//						additionalCommentDoc.add(info);
//					}
					else {
						info.setdFFileName(info.getDocumentType());
						info.setDocumentType(info.getDocumentType());
						info.setEvaluateDocTypeKey(info.getDocumentType());
						ListTypeEntry documentTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
								"PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC", info.getDocumentType(),
								themeDisplay.getCompanyId());
						if (Validator.isNotNull(documentTypeEntry)) {
							info.setEvaluateDocTypeName(documentTypeEntry.getName(themeDisplay.getLocale()));
						}

						documentInfos.add(info);
					}
				}
			}
		}

		long appealId = eqAppealId;

		String appealRequestStatusurl = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_STATUS_URL_VIEW
				+ "/scopes/" + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		appealRequestStatusurl = appealRequestStatusurl + "filter=eQAppealId"
				+ URLEncoder.encode(" eq " + String.valueOf(appealId), StandardCharsets.UTF_8) + AppealConstants.PAGE_SIZE;
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
				if(Validator.isNotNull(appealStatus.getEquivalencyCertificate())) {
					ListTypeEntry documentTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC, appealStatus.getEquivalencyCertificate(), themeDisplay.getCompanyId());
					if(Validator.isNotNull(documentTypeEntry)) {
						status.setEquivalencyCertificate(documentTypeEntry.getName(themeDisplay.getLocale()));
					}
				}
				
				/*
				 * status.setEqLevel(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
				 * appealStatus.getEqLevelId(), themeDisplay.getLocale()));
				 */
				String eqAppealLevel = StringPool.BLANK;
				String eqAppealLevelReason = StringPool.BLANK;
				if (Validator.isNotNull(appealStatus.getEquivalencyLevelKey())) {
					ListTypeEntry levelListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC,
							appealStatus.getEquivalencyLevelKey(), themeDisplay.getCompanyId());
					if (Validator.isNotNull(levelListTypeEntry)) {
						eqAppealLevel = levelListTypeEntry.getName(themeDisplay.getLocale());
					}
				}
				
				if (Validator.isNotNull(appealStatus.getEquivalencyLevelReasonKey())) {
					ListTypeEntry appealLevelReasonListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC,
							appealStatus.getEquivalencyLevelReasonKey(), themeDisplay.getCompanyId());
					if (Validator.isNotNull(appealLevelReasonListTypeEntry)) {
						eqAppealLevelReason = appealLevelReasonListTypeEntry.getName(themeDisplay.getLocale());
					}
				}
				status.setEquivalencyLevelKey(appealStatus.getEquivalencyLevelKey());
				status.setEquivalencyLevelName(eqAppealLevel);
				status.setEquivalencyLevelReasonKey(appealStatus.getEquivalencyLevelReasonKey());
				status.setEquivalencyLevelReasonName(eqAppealLevelReason);
				status.setDocumentList(getCommentDocuments(appealStatus.getId(), additionalCommentDoc));
				list.add(status);
			}
		}
		if (list.size() > 0) {
			renderRequest.setAttribute("recentAppealStatus", list.get(0));
		}
//		===========

		List<ListTypeEntry> eqLevelList = new ArrayList<>();
		List<ListTypeEntry> eqLevelReasonList = new ArrayList<>();
		if (hasVehpcCommitteeRole || hasVehpcCAdminRole) {
			eqLevelList = omsbCommonApi.getListTypeEntriesByERC(
					OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC, themeDisplay.getCompanyId());
			eqLevelReasonList = omsbCommonApi.getListTypeEntriesByERC(
					OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC, themeDisplay.getCompanyId());
		}
		renderRequest.setAttribute("eqLevelList", eqLevelList);
		renderRequest.setAttribute("eqLevelReasonList", eqLevelReasonList);
		renderRequest.setAttribute("statusList", list);
		renderRequest.setAttribute("docsList", documentInfos);
		renderRequest.setAttribute("additionalCommentDoc", additionalCommentDoc);
		String fullName = "";
		String appeallantUserRole = "";
		if (Validator.isNotNull(appeallantUser)) {
			fullName = appeallantUser.getFullName();
			appeallantUserRole = getRoleName(appeallantUser.getUserId());
		}

		renderRequest.setAttribute("appeallantUserName", fullName);
		renderRequest.setAttribute("createdDate", omsbCommonApi.convertDate(createdDate));

		renderRequest.setAttribute("appealComments", appealComments);
		renderRequest.setAttribute("level", level);
		renderRequest.setAttribute("appeallantUserRole", appeallantUserRole);

		logger.info("FINAL :::::::::::: hasVehpcCAdminRole " + hasVehpcCAdminRole);

		// for person details starts
		String eqRequestResponse = omsbHttpConnector.executeGet(
				omsbCommonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + equivalencyRequestId,
				StringPool.BLANK, headersInfo);
		logger.info("EquivalencyViewMVCRenderCommand eqRequestResponse:::::::" + eqRequestResponse);
		String personId = null;
		String dob = null;
		String passportNumber = null;

		JSONObject jsoneqRequestResponseObj;
		try {
			jsoneqRequestResponseObj = JSONFactoryUtil.createJSONObject(eqRequestResponse);

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//			EquivalencyRequest equivalencyRequest = objectMapper.readValue(jsoneqRequestResponseObj.toString(),
//					new TypeReference<EquivalencyRequest>() {
//					});

			personId = jsoneqRequestResponseObj.getString("personId");
		} catch (JSONException e) {
			logger.error(e.getMessage());
		}

		String getPersonDetailsURL = generateScopeListURL(
				LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL + "?filter=personId%20eq%20" + personId,
				themeDisplay.getScopeGroupId());
		String personDetailRes = omsbHttpConnector.executeGet(getPersonDetailsURL, "", headersInfo);

		PersonalDetailItems personalDetailsItems = CustomObjectMapperUtil.readValue(personDetailRes,
				PersonalDetailItems.class);

		if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
			logger.info("Profession::::::" + personalDetailsItems.getItems().get(0).getProfession());

			if (Validator.isNotNull(personalDetailsItems.getItems().get(0).getProfession())) {
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

			try {
				if (natinalityCountryId > 0) {
					try {
						Country country = countryLocalService.getCountry(natinalityCountryId);
						renderRequest.setAttribute("personNatinality", country.getName(themeDisplay.getLocale()));
					} catch (PortalException e) {
						logger.error("Country Error" + e.getMessage());
					}

				}

				String getPersonURL = generateScopeListURL(LRObjectURL.PERSON_URL, themeDisplay.getScopeGroupId());
				String finderQueryPerson = StringPool.QUESTION + "filter=id" + URLEncoder.encode(
						" eq '" + personId + "'", OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
				String personResponse = omsbHttpConnector.executeGet(getPersonURL + finderQueryPerson, "", headersInfo);
				JSONObject personJsonObj = JSONFactoryUtil.createJSONObject(personResponse);
				JSONArray getPersonJsonArrayResponse = personJsonObj
						.getJSONArray(OmsbVehpcEquivalencyWebPortletKeys.ITEMS);

				SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);
				Date dateOB = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
						.parse(getPersonJsonArrayResponse.getJSONObject(0).getString("dateOfBirth"));
				dob = sdf.format(dateOB);
				passportNumber = getPersonJsonArrayResponse.getJSONObject(0).getString("passportNumber");
				renderRequest.setAttribute("personId",personId );
				renderRequest.setAttribute("dateOfBirth", dob);
				renderRequest.setAttribute("passportNumber", passportNumber);
				renderRequest.setAttribute("personalDetail", personalDetailsItems.getItems().get(0));

			} catch (NullPointerException | IndexOutOfBoundsException | UnsupportedEncodingException | JSONException
					| ParseException e) {
				logger.info(e.getMessage());
			}

		}
		// for person details ends

		return AppealConstants.VIEW_APPEAL_ALL_JSP;
	}

	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL()
				+ equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}

//	private String getEqDocumentTypeById(ThemeDisplay themeDisplay, long eqDocTypeId) {
//		String docType = "";
//		String equivalencyDocTypeUrl = themeDisplay.getPortalURL() + LRObjectURL.EQUIVALENCY_DOCUMENT_TYPES_BY_PK
//				+ eqDocTypeId;
//		String equivalencyDocTypeResponse = omsbCommonApi.getData(equivalencyDocTypeUrl);
//		EquivalencyDocumentType equivalencyDocumentType = CustomObjectMapperUtil.readValue(equivalencyDocTypeResponse,
//				EquivalencyDocumentType.class);
//		if (Validator.isNotNull(equivalencyDocumentType)
//				&& Validator.isNotNull(equivalencyDocumentType.getEquivalencyDocType())
//				&& !equivalencyDocumentType.getEquivalencyDocType().isEmpty()) {
//			docType = equivalencyDocumentType.getEquivalencyDocType();
//		}
//		return docType;
//	}

	private String getEqDocumentTypeNameByKey(String erc, String key, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(erc, key, themeDisplay.getCompanyId());
		String documentType = "";
		if (Validator.isNotNull(entry)) {
			documentType = entry.getName(themeDisplay.getLocale());
		}
		return documentType;
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

	private boolean isAppealExist(long decisionId, ThemeDisplay themeDisplay) {
		boolean isExist = false;
		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		decisionUrl = decisionUrl + "filter=eQDecisionId"
				+ URLEncoder.encode(" eq " + decisionId, StandardCharsets.UTF_8);

		logger.info("decisionUrl ?? " + decisionUrl);

		Map<String, String> headers = headerUtil.getHeaders();
		String response = omsbHttpConnector.executeGet(decisionUrl, "", headers);

		logger.info("response for appeal using EQ Decision Id?? " + response);
		if (response.contains("eQDecisionId")) {
			isExist = Boolean.TRUE;
		}
		return isExist;
	}

	private String getRoleName(long userId) {
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
		List<String> userRoleNames = userRoles.stream().map(Role::getName).collect(Collectors.toList());
		logger.info("roleNames are ??" + userRoleNames.toString());
		if (userRoleNames.contains(RoleNameConstants.EMPLOYER)) {
			return RoleNameConstants.EMPLOYER;
		} else if (userRoleNames.contains(RoleNameConstants.VEHPC_RAPPORTEUR)) {
			return RoleNameConstants.VEHPC_RAPPORTEUR;
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
		logger.info("GETTING ATTACHMENTS :::::::::::::::::::::::: " + eqStatusId);
		List<DocumentInfo> documentInfos = new ArrayList<>();
		for (DocumentInfo info : documentInfoList) {
			if (info.getComponentClassRefId() == eqStatusId) {
				logger.info("GETTING ATTACHMENTS :::::::::::::::::::::::: " + info.getComponentClassRefId());
				String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
				info.setDocumentType(info.getDocumentType());
				logger.info("GETTING ATTACHMENTS :::::::::::::::::::::::: " + info.getDocumentType());
				info.setDocsfileurl(docsfileurl);
				documentInfos.add(info);
			}
		}
		return documentInfos;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private HeaderUtil headerUtil;

	@Reference(unbind = "-")
	private AppealWrokflowUtil appealWrokflowUtil;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference
	private CountryLocalService countryLocalService;

	private static final Log logger = LogFactoryUtil.getLog(ViewAppealMVCRender.class);
}
