package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.DocumentInfo;
import gov.omsb.vehpc.appeal.dto.web.DocumentInfoItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatusItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecisionLevel;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyLevel;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.util.AppealWrokflowUtil;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=" + AppealConstants.VIEW_APPEAL_ALL }, service = MVCRenderCommand.class)
public class ViewAppealMVCRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("calling here ViewAppealMVCRender ?? ");
		// workFlow related task 
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long decisionLevelId = ParamUtil.getLong(renderRequest, "equivalencyDecisionLevelId");
		long workflowTaskId = ParamUtil.getLong(renderRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(renderRequest, "workflowInstanceId");
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		long eqAppealId = ParamUtil.getLong(renderRequest, "eqAppealId");
		boolean assignedToMe = ParamUtil.getBoolean(renderRequest, "assignedToMe");
		boolean hasVehpcCommitteeRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasExecutePresidentRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.EXECUTIVE_PRESIDENT);
		boolean hasVehpcCAdminRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		boolean hasEmployerRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(),RoleNameConstants.EMPLOYER);
		boolean hasEmployeeRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), themeDisplay.getUserId(), RoleNameConstants.EMPLOYEE);
		
		
		try {
			List<String> transitionNames = appealWrokflowUtil.getTransitionNames(themeDisplay, workflowTaskId);
			logger.info("transitionNames transitionNames transitionNames v transitionNames"+transitionNames);
			renderRequest.setAttribute("transitionNames", transitionNames);
		} catch (WorkflowException e) {
			logger.error(e.getMessage(),e);
		}
		
		
		renderRequest.setAttribute("workflowInstanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute(Constants.CMD, cmd);
		renderRequest.setAttribute("appealId", eqAppealId);
		renderRequest.setAttribute("assignedToMe", assignedToMe);
		renderRequest.setAttribute("decisionLevelId", decisionLevelId);
		renderRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		renderRequest.setAttribute("hasExecutePresidentRole", hasExecutePresidentRole);
		renderRequest.setAttribute("hasVehpcCAdminRole", hasVehpcCAdminRole);
		renderRequest.setAttribute("appealStatusColur", appealUtil.getColorMap());
		
		logger.info("decisionLevelId "+decisionLevelId);
		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + CommonConstants.SCOPES +StringPool.SLASH
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		decisionUrl = decisionUrl + "filter=eQDecisionId"
				+ URLEncoder.encode(" eq " + decisionLevelId, StandardCharsets.UTF_8);
		logger.info("decisionUrl ?? " + decisionUrl);
		String response = omsbHttpConnector.executeGet(decisionUrl, "", headerUtil.getHeaders());
		logger.info("response for appeal using EQ Decision Id?? " + response);
		EquivalencyAppealItems equivalencyAppeal = CustomObjectMapperUtil.readValue(response,
				EquivalencyAppealItems.class);
		 
		
		boolean appeal = isAppealExist(decisionLevelId, themeDisplay);
		renderRequest.setAttribute("appeal", appeal);
		String docAppealId = "";
		User appeallantUser = null;
		String appealComments = "";
		String createdDate = "";
		String level ="";
		
	
		if(Validator.isNotNull(equivalencyAppeal) && Validator.isNotNull(equivalencyAppeal.getItems())
				&& !equivalencyAppeal.getItems().isEmpty()) {
			logger.info(" this is comments" + equivalencyAppeal.getItems().get(0).getComments());
			logger.info(" this is comments" + equivalencyAppeal.getItems().get(0).getAppellantUserId());
			appeallantUser = userLocalService.fetchUser(equivalencyAppeal.getItems().get(0).getAppellantUserId());
			docAppealId = String.valueOf(equivalencyAppeal.getItems().get(0).getId());
			appealComments = equivalencyAppeal.getItems().get(0).getComments();
			createdDate = equivalencyAppeal.getItems().get(0).getDateCreated();
			level = equivalencyAppeal.getItems().get(0).getEqLevelId();
			 
			
			renderRequest.setAttribute("appealStatusId", equivalencyAppeal.getItems().get(0).getStatusID());
			renderRequest.setAttribute("appealStatus",  appealUtil.getStatus(equivalencyAppeal.getItems().get(0).getStatusID(), themeDisplay));
			long statusId = Long.parseLong(equivalencyAppeal.getItems().get(0).getStatusID());
			logger.info("status ID is ??" + statusId);
			renderRequest.setAttribute("appealStatusKey",  appealUtil.getListTypeEntryKeyById(statusId, themeDisplay));
			renderRequest.setAttribute("appeallantStatus", appealUtil.getStatus(equivalencyAppeal.getItems().get(0).getStatusID(), themeDisplay));
		}
		
		
		
		String decisionsLevelurl = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL
				+ decisionLevelId;
		String equivalencydecisionsurlresponse = omsbHttpConnector.executeGet(decisionsLevelurl, "", headerUtil.getHeaders());
		EquivalencyDecisionLevel decisionLevel = CustomObjectMapperUtil.readValue(equivalencydecisionsurlresponse, EquivalencyDecisionLevel.class);
		String comments = "";
		long decisiondocinfo = 0;
		String equivalencylevelkey = "";
		if (Validator.isNotNull(decisionLevel)) {
			EquivalencyLevel equivalencyLevelId = decisionLevel.getEquivalencyLevelId();
			if (Validator.isNotNull(equivalencyLevelId)) {
				equivalencylevelkey = equivalencyLevelId.getKey();
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
		///// document
	
		FileEntry entry = appealUtil.getFileEntryById(decisonFileEntryId);
		
		if (Validator.isNotNull(entry)) {
			certificateFileName = entry.getFileName().replaceAll("^[0-9]+", "");  /// removing timeStamp from File Name
		}
		
		String documentInfoUrl = themeDisplay.getPortalURL() + AppealConstants.DOCUMENT_INFO_CERTIFICATE_URL
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		String encodedDocAppealId = URLEncoder.encode(docAppealId, StandardCharsets.UTF_8);
		documentInfoUrl = documentInfoUrl + "filter=equivalencyAppealId"
				+ URLEncoder.encode(" eq " + encodedDocAppealId, StandardCharsets.UTF_8);
		logger.info("documentInfoUrl " + documentInfoUrl);
		String documentInfoUrlResponse = omsbHttpConnector.executeGet(documentInfoUrl, "", headerUtil.getHeaders());
		DocumentInfoItems docItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfoItems.class);
		List<DocumentInfo> documentInfos = new ArrayList<>();
		if (Validator.isNotNull(docItems.getItems()) && !docItems.getItems().isEmpty()) {
			for (DocumentInfo info : docItems.getItems()) {
				DocumentInfo documentInfo = new DocumentInfo();
				documentInfo.setFileEntryID(info.getFileEntryID());
				String docsfileurl = appealUtil.getFileURL(info.getFileEntryID());
				documentInfo.setdFFileName(info.getdFFileName());
				documentInfo.setDocsfileurl(docsfileurl);
				logger.info("docUrl============================================="+docsfileurl);
				logger.info("viewAppeal====================file name =============================="+info.getdFFileName());
				documentInfos.add(documentInfo);
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
				if(themeDisplay.getUserId()==appealStatus.getLruserId() && hasVehpcCommitteeRole) {
					hasCommentAdded = Boolean.TRUE;
				}
				EquivalencyAppealStatus status = new EquivalencyAppealStatus();
				status.setMessage(appealStatus.getMessage());
				String fullName =getFullName(appealStatus.getLruserId());
				String roleType = getRoleName(appealStatus.getLruserId());
				status.setRoleType(roleType);
				status.setFullName(fullName);
				status.setDateCreated(omsbCommonApi.convertDate(appealStatus.getDateCreated()));
				status.setIscommitte(appealStatus.isIscommitte());
				logger.info("appealStatus.isPresident() ?? " + appealStatus.isIsPresident());
				logger.info("appealStatus.iscommittee ?? " + appealStatus.isIscommitte());
				status.setIsPresident(appealStatus.isIsPresident());
				status.setIsAdmin(appealStatus.isIsAdmin());
				status.setEqLevelId(appealStatus.getEqLevelId());
				
				// String statusEqLevelId = appealUtil.getListTypeEntryKeyById(appealStatus.getEqLevelId(), themeDisplay);
				// status.setEqLevel(statusEqLevelId);
				status.setEqLevel(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(appealStatus.getEqLevelId(), themeDisplay.getLocale()));
				
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
			renderRequest.setAttribute("hasCommentAdded",  hasCommentAdded);
		}
		

		List<ListTypeEntry> listTypeEntries = omsbCommonApi.getListTypeEntriesByERC(AppealConstants.PL_EQ_LEVEL,
				themeDisplay.getCompanyId());
		renderRequest.setAttribute("equivalencylevelkey", equivalencylevelkey);
		renderRequest.setAttribute("statusList", list);
		renderRequest.setAttribute("docsList", documentInfos);
		renderRequest.setAttribute("certificatefileurl", certificatefileUrl);
		logger.info("certificatefileUrl in the view render commandd"+certificatefileUrl);
		renderRequest.setAttribute("comments", comments);
		String fullName = "";
		String appeallantUserRole = "";
		if (Validator.isNotNull(appeallantUser)) {
			fullName = appeallantUser.getFullName();
			appeallantUserRole = getRoleName(appeallantUser.getUserId());
		}
		
		renderRequest.setAttribute("appeallantUserName", fullName);
		renderRequest.setAttribute("createdDate", omsbCommonApi.convertDate(createdDate));
		renderRequest.setAttribute("certificateName", certificateFileName);
		renderRequest.setAttribute("appealComments", appealComments);
		renderRequest.setAttribute("level", level);
		renderRequest.setAttribute("appeallantUserRole", appeallantUserRole);
		return AppealConstants.VIEW_APPEAL_ALL_JSP;
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
	private static final Log logger = LogFactoryUtil.getLog(ViewAppealMVCRender.class);
}
