package omsb.vehpc.appeal.mvc.commands.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
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
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Person;
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
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.FocalPoint;
import omsb.vehpc.equivalency.dto.web.PersonalDetailItems;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.AppealWrokflowUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.VIEW_EDIT_APPEAL }, service = MVCRenderCommand.class)
public class EditAppealMVCRender implements MVCRenderCommand {

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
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		// for appeal details starts

		boolean hasVehpcCommitteeRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasRapporteur = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_RAPPORTEUR);
		boolean hasVehpcCAdminRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.VEHPC_ADMIN);
		boolean hasVehpcEmployerRole = commonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				RoleNameConstants.EMPLOYER);

		if (hasVehpcCommitteeRole || hasRapporteur || hasVehpcCAdminRole || hasVehpcEmployerRole) {

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
		/*
		 * boolean hasEmployerRole =
		 * omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(),
		 * themeDisplay.getUserId(), RoleNameConstants.EMPLOYER); boolean
		 * hasEmployeeRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(),
		 * themeDisplay.getUserId(), RoleNameConstants.EMPLOYEE);
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
		renderRequest.setAttribute("hasVehpcEmployerRole", hasVehpcEmployerRole);
		renderRequest.setAttribute("appealStatusColur", appealUtil.getColorMap());

		// get appeal id starts
		logger.info("equivalencyRequestId " + equivalencyRequestId);
		String appealUrl = themeDisplay.getPortalURL() + AppealConstants.OB_EQUIVALENCY_APPEAL_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		appealUrl = appealUrl + "filter=eQRequestedId"
				+ URLEncoder.encode(" eq " + equivalencyRequestId, StandardCharsets.UTF_8);

		logger.info("appealUrl appealUrl appealUrl appealUrl appealUrl " + appealUrl);
		String appealResponse = omsbHttpConnector.executeGet(appealUrl, "", headerUtil.getHeaders());

		logger.info("appealResponse appealResponse appealResponse appealResponse appealResponse " + appealResponse);

		EquivalencyAppealItems equivalencyAppeal = CustomObjectMapperUtil.readValue(appealResponse,
				EquivalencyAppealItems.class);

		eqAppealId = Long.valueOf(equivalencyAppeal.getItems().get(0).getId());

		renderRequest.setAttribute("appealId", eqAppealId);
		logger.info("decisionUrl decisionUrl decisionUrl decisionUrl decisionUrl " + eqAppealId);
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
		if(Validator.isNotNull(descisionEquivalencyAppeal) && descisionEquivalencyAppeal.getItems().size()>0) {
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
						certificateFileName = entry.getFileName().replaceAll("^[0-9]+", ""); /// removing timeStamp from																						/// Name
					}
				}
				certificatesDTO.setCertificatefileurl(certificatefileUrl);
				certificatesDTO.setEquivalencylevelkey(equivalencylevelkey);
				certificatesDTO.setComments(comments);
				certificatesDTO.setCertificateName(certificateFileName);
				certificatesList.add(certificatesDTO);
				renderRequest.setAttribute("certificatesList", certificatesList);
				/*
				 * renderRequest.setAttribute("equivalencylevelkey", equivalencylevelkey);
				 * renderRequest.setAttribute("certificatefileurl", certificatefileUrl);
				 * renderRequest.setAttribute("comments", comments);
				 * renderRequest.setAttribute("certificateName", certificateFileName);
				 */
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

			/*
			 * String apealUrl = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL
			 * + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
			 * + StringPool.QUESTION;
			 * 
			 * apealUrl = apealUrl + "filter=id" + URLEncoder.encode(" eq " + eqAppealId,
			 * StandardCharsets.UTF_8);
			 * 
			 * String response = omsbHttpConnector.executeGet(apealUrl, "",
			 * headerUtil.getHeaders());
			 * 
			 * logger.info("response for appeal using EQ Decision Id?? " + response);
			 * EquivalencyAppealItems equivalencyAppeal =
			 * CustomObjectMapperUtil.readValue(response, EquivalencyAppealItems.class);
			 */

			long decisionLevelId = descisionEquivalencyAppeal.getItems().get(0).getEqDecisionLevelId();
			renderRequest.setAttribute("decisionLevelId", decisionLevelId);
			boolean appeal = isAppealExist(decisionLevelId, themeDisplay);
			renderRequest.setAttribute("appeal", appeal);
		}


		
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
			level = equivalencyAppeal.getItems().get(0).getEqLevelId();

			renderRequest.setAttribute("appealStatusId", equivalencyAppeal.getItems().get(0).getStatusID());
			renderRequest.setAttribute("appealStatus",
					appealUtil.getStatus(equivalencyAppeal.getItems().get(0).getStatusID(), themeDisplay));
			long statusId = equivalencyAppeal.getItems().get(0).getStatusID();
			logger.info("status ID is ??" + statusId);
			renderRequest.setAttribute("appealStatusKey", appealUtil.getListTypeEntryKeyById(statusId, themeDisplay));
			logger.info(
					"FINAL :::::::::::: appealStatusKey " + appealUtil.getListTypeEntryKeyById(statusId, themeDisplay));
			renderRequest.setAttribute("appeallantStatus",
					appealUtil.getStatus(equivalencyAppeal.getItems().get(0).getStatusID(), themeDisplay));
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
				if (Validator.isNotNull(info.getDocumentType())) {
					logger.info("docType=============================================" + info.getDocumentType());
					if (info.getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE) ||
							info.getDocumentType()
							.equalsIgnoreCase(OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE)) {
						DocumentInfo documentInfo = new DocumentInfo();
						String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
						documentInfo.setDocumentType(info.getDocumentType());
						documentInfo.setDocsfileurl(docsfileurl);
						additionalCommentDoc.add(info);
					} else {
						DocumentInfo documentInfo = new DocumentInfo();
						documentInfo.setFileEntryID(info.getFileEntryID());
						String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
						documentInfo.setdFFileName(info.getdFFileName());
						documentInfo.setDocsfileurl(docsfileurl);
						documentInfo.setDocumentType(info.getDocumentType());
						ListTypeEntry documentTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
								OmsbVehpcEquivalencyWebPortletKeys.DOCUMENT_TYPE_ERC, info.getDocumentType(),
								themeDisplay.getCompanyId());

						if (Validator.isNotNull(documentTypeEntry)) {
							documentInfo.setDocumentTypeName(documentTypeEntry.getName(themeDisplay.getLocale()));
						}

						documentInfos.add(documentInfo);
					}
				}
			}
		}
		String appealRequestStatusurl = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_STATUS_URL_VIEW
				+ "/scopes/" + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		appealRequestStatusurl = appealRequestStatusurl + "filter=eQAppealId"
				+ URLEncoder.encode(" eq " + String.valueOf(docAppealId), StandardCharsets.UTF_8);
		logger.info("appealRequestStatusurl============================== " + appealRequestStatusurl);
		String appealRequestStatusurlresponse = omsbHttpConnector.executeGet(appealRequestStatusurl, "",
				headerUtil.getHeaders());
		EquivalencyAppealStatusItems equivalencyAppealStatusItems = CustomObjectMapperUtil
				.readValue(appealRequestStatusurlresponse, EquivalencyAppealStatusItems.class);
		List<EquivalencyAppealStatus> list = new ArrayList<>();
		boolean hasCommentAdded = Boolean.FALSE;
		if (Validator.isNotNull(equivalencyAppealStatusItems.getItems())
				&& !equivalencyAppealStatusItems.getItems().isEmpty()) {
			for (EquivalencyAppealStatus appealStatus : equivalencyAppealStatusItems.getItems()) {
				if (themeDisplay.getUserId() == appealStatus.getLruserId() && hasVehpcCommitteeRole) {
					hasCommentAdded = Boolean.TRUE;
				}
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
				;
				status.setEqLevel(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(appealStatus.getEqLevelId(),
						themeDisplay.getLocale()));

				logger.info("COMMENTS ARE :::::::::::::::::::::::::: " + appealStatus.getMessage());
				status.setDocumentList(getCommentDocuments(appealStatus.getId(), additionalCommentDoc));
				/*
				 * if(hasEmployeeRole || hasEmployerRole) { boolean hasLREmployerRole =
				 * omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), status.getLruserId(),
				 * RoleNameConstants.EMPLOYER); boolean hasLREmployeeRole =
				 * omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), status.getLruserId(),
				 * RoleNameConstants.EMPLOYEE); if(hasLREmployeeRole || hasLREmployerRole) {
				 * list.add(status); } } else { list.add(status); }
				 */
				list.add(status);
			}
			renderRequest.setAttribute("hasCommentAdded", hasCommentAdded);
		}

		renderRequest.setAttribute("statusList", list);
		renderRequest.setAttribute("docsList", documentInfos);
		renderRequest.setAttribute("additionalCommentDoc", additionalCommentDoc);
		String fullName = "";
		String appeallantUserRole = "";
		if (Validator.isNotNull(appeallantUser)) {
			fullName = appeallantUser.getFullName();
			appeallantUserRole = getRoleName(appeallantUser.getUserId());
		}

		ListTypeDefinition definition = null;
		try {
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					AppealConstants.PL_EQUIVALENCY_DOCUMENTS_TYPE_ERC, themeDisplay.getCompanyId());
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		List<ListTypeEntry> documentTypelist = ListTypeEntryLocalServiceUtil
				.getListTypeEntries(definition.getListTypeDefinitionId());
		renderRequest.setAttribute("documentTypelist", documentTypelist);

		renderRequest.setAttribute("appeallantUserName", fullName);
		renderRequest.setAttribute("createdDate", omsbCommonApi.convertDate(createdDate));

		renderRequest.setAttribute("appealComments", appealComments);
		renderRequest.setAttribute("level", level);
		renderRequest.setAttribute("appeallantUserRole", appeallantUserRole);

		logger.info("FINAL :::::::::::: hasVehpcCAdminRole " + documentTypelist.toString());
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
		
		String getPersonalDetailsURL = themeDisplay.getPortalURL()+
				LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 +themeDisplay.getScopeGroupId() + "?filter=personId%20eq%20" + equivalencyRequest.getPersonId();
		String personalDetailRes = omsbHttpConnector.executeGet(getPersonalDetailsURL, StringPool.BLANK, headersInfo);

		PersonalDetailItems personalDetailsItems = CustomObjectMapperUtil.readValue(personalDetailRes,
				PersonalDetailItems.class);

		if (Validator.isNotNull(personalDetailsItems) && personalDetailsItems.getItems().size() > 0) {
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
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);


		return AppealConstants.EDIT_APPEAL_JSP;
	}

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
	
	@Reference
	private CountryLocalService countryLocalService;


	@Reference(unbind = "-")
	private AppealUtil appealUtil;
	private static final Log logger = LogFactoryUtil.getLog(EditAppealMVCRender.class);
}
