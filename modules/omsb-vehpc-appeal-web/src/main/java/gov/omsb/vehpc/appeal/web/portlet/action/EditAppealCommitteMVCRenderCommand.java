package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.DocumentInfo;
import gov.omsb.vehpc.appeal.dto.web.DocumentInfoItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatusItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecision;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecisionLevel;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyLevel;
import gov.omsb.vehpc.appeal.dto.web.SearchDto;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, 
property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
				"mvc.command.name=" + AppealConstants.EDIT_APPEAL }, 
				service = MVCRenderCommand.class)
public class EditAppealCommitteMVCRenderCommand implements MVCRenderCommand {

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
		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + eqAppealId;
		logger.info("decisionUrl ?? " + decisionUrl);
		String response = omsbHttpConnector.executeGet(decisionUrl, "", headerUtil.getHeaders());
		logger.info("response for appeal using EQ Decision Id?? " + response);
		EquivalencyAppeal equivalencyAppeal = CustomObjectMapperUtil.readValue(response, EquivalencyAppeal.class);
		User appeallantUser = null;
		String appealComments = "";
		String createdDate = "";
		String level="";
		if (Validator.isNotNull(equivalencyAppeal)) {
			logger.info(" this is comments" + equivalencyAppeal.getComments());
			logger.info(" this is getAppellantUserId " + equivalencyAppeal.getAppellantUserId());
			logger.info(" this is eq appeal Id " + equivalencyAppeal.getId());
			appeallantUser = userLocalService.fetchUser(equivalencyAppeal.getAppellantUserId());
			appealComments = equivalencyAppeal.getComments();
			createdDate = equivalencyAppeal.getDateCreated();
			level = equivalencyAppeal.getEqLevelId();
			logger.info("Status Id :"+equivalencyAppeal.getStatusID());
			renderRequest.setAttribute("appeallantStatus", appealUtil.getStatus(equivalencyAppeal.getStatusID(), themeDisplay));
		}
		
		String equivalencyDecisionsUrl = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL
				+ decisionId;
		String equivalencyDecisionsResponse = omsbHttpConnector.executeGet(equivalencyDecisionsUrl, "",
				headerUtil.getHeaders());
		logger.info("decision URL response is ?? " + equivalencyDecisionsResponse);
		EquivalencyDecisionLevel decision = CustomObjectMapperUtil.readValue(equivalencyDecisionsResponse,
				EquivalencyDecisionLevel.class);
		String comments = "";
		long decisiondocinfo = 0;
		long equivalencyRequestId = 0;
		String equivalencylevelkey = "";
		if (Validator.isNotNull(decision)) {
			EquivalencyLevel equivalencyLevelId = decision.getEquivalencyLevelId();
			if (Validator.isNotNull(equivalencyLevelId)) {

				equivalencylevelkey = equivalencyLevelId.getName();
			}
			logger.info(equivalencylevelkey + "keeeeeeeeeeyyyyyyyyyyyyyyyyyyyyyyyyyyy this line ");
			comments = decision.getComments();
			decisiondocinfo = decision.getDocumentInfoId();
			equivalencyRequestId = decision.getEqRequestId();
			logger.info("equivalencyRequestId 11 is ?? " + equivalencyRequestId);
		}
		//// documentInfoId
		String decisonCertificateUrl = themeDisplay.getPortalURL() + AppealConstants.DECISION_CERTIFICATE_URL
				+ decisiondocinfo;
		logger.info("decisonCertificateUrl " + decisonCertificateUrl);
		String decisionInfoUrlResponse = omsbHttpConnector.executeGet(decisonCertificateUrl, "",
				headerUtil.getHeaders());
		DocumentInfo decisiondocumentInfo = CustomObjectMapperUtil.readValue(decisionInfoUrlResponse,
				DocumentInfo.class);
		long decisomFileEntryId = decisiondocumentInfo.getFileEntryID();
		String certificateFileName = "";
		
		
		FileEntry entry = appealUtil.getFileEntryById(decisiondocumentInfo.getFileEntryID());
		if (Validator.isNotNull(entry)) {
			certificateFileName = entry.getFileName().replaceAll("^[0-9]+", ""); /// removing timeStamp from File Name
		}
		String certificatefileUrl = getFileURL(decisomFileEntryId);
		///// document
		String documentInfoUrl = themeDisplay.getPortalURL() + AppealConstants.DOCUMENT_INFO_CERTIFICATE_URL
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		documentInfoUrl = documentInfoUrl + "filter=equivalencyAppealId"
				+ URLEncoder.encode(" eq " + eqAppealId, StandardCharsets.UTF_8);
		logger.info("documentInfoUrl " + documentInfoUrl);
		String documentInfoUrlResponse = omsbHttpConnector.executeGet(documentInfoUrl, "", headerUtil.getHeaders());

		DocumentInfoItems docItems = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfoItems.class);
		List<DocumentInfo> documentInfos = new ArrayList<>();
		if (Validator.isNotNull(docItems.getItems()) && !docItems.getItems().isEmpty()) {
			for (DocumentInfo info : docItems.getItems()) {
				DocumentInfo documentInfo = new DocumentInfo();
				documentInfo.setFileEntryID(info.getFileEntryID());
				String docsfileurl = getFileURL(info.getFileEntryID());
				documentInfo.setdFFileName(info.getdFFileName());
				documentInfo.setDocsfileurl(docsfileurl);
				logger.info(docsfileurl + "========docsfileurldocsfileurldocsfileurldocsfileurlm");
				logger.info(info.getdFFileName()
						+ "viewAppeal====================file name ==============================");
				documentInfos.add(documentInfo);
			}
		}
		logger.info(" documentInfos size () ====" + documentInfos.size());
		String appealRequestStatusurl = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_STATUS_URL_VIEW
				+ "/scopes/" + themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		appealRequestStatusurl = appealRequestStatusurl + "filter=eQAppealId"
				+ URLEncoder.encode(" eq " + eqAppealId, StandardCharsets.UTF_8);
		logger.info("appealRequestStatusurl============================== " + appealRequestStatusurl);
		String appealRequestStatusurlresponse = omsbHttpConnector.executeGet(appealRequestStatusurl, "",
				headerUtil.getHeaders());
		EquivalencyAppealStatusItems equivalencyAppealStatusItems = CustomObjectMapperUtil
				.readValue(appealRequestStatusurlresponse, EquivalencyAppealStatusItems.class);
		logger.info("appealRequestStatusurlresponse============================== " + appealRequestStatusurlresponse);
		logger.info("appeal status size () ============================== "
				+ equivalencyAppealStatusItems.getItems().size());
		List<EquivalencyAppealStatus> list = new ArrayList<>();
		if (Validator.isNotNull(equivalencyAppealStatusItems.getItems())
				&& !equivalencyAppealStatusItems.getItems().isEmpty()) {
			for (EquivalencyAppealStatus appealStatus : equivalencyAppealStatusItems.getItems()) {
				EquivalencyAppealStatus status = new EquivalencyAppealStatus();
				status.setMessage(appealStatus.getMessage());
				String fullName = "";
				try {
					fullName = UserLocalServiceUtil.getUser(appealStatus.getLruserId()).getFullName();
				} catch (PortalException e) {
					logger.error(e.getMessage(),e);
				}
				status.setFullName(fullName);
				status.setDateCreated(omsbCommonApi.convertDate(appealStatus.getDateCreated()));
				status.setIscommitte(appealStatus.isIscommitte());
				status.setIsPresident(appealStatus.isIsPresident());
				String roleType = getRoleName(appealStatus.getLruserId());
				status.setRoleType(roleType);
				status.setIsAdmin(appealStatus.isIsAdmin());
				status.setEqLevelId(appealStatus.getEqLevelId());
				String statusEqLevelId = appealUtil.getListTypeEntryKeyById(appealStatus.getEqLevelId(), themeDisplay);
				status.setEqLevel(statusEqLevelId);
				logger.info(fullName + " comments ?? " + appealStatus.getMessage() + "appealStatus.isPresident() ?? "
						+ appealStatus.isIsPresident());
				logger.info(fullName + " comments ?? " + appealStatus.getMessage() + "appealStatus.iscommittee ?? "
						+ appealStatus.isIscommitte());
				logger.info(fullName + " comments ?? " + appealStatus.getMessage() + "appealStatus.isAdmin ?? "
						+ appealStatus.isIsAdmin());
				list.add(status);
			}
		}
		
		Set<SearchDto> 	adminSearchDtos = appealUtil.getAllData(themeDisplay);
		List<SearchDto> searchList = new ArrayList<>(adminSearchDtos);
		searchList.sort(Comparator.comparing(SearchDto::getId).reversed());
		renderRequest.setAttribute("adminSearchDtos", searchList);
		
		boolean hasVehpcCommitteeRole = hasUserRole(themeDisplay, themeDisplay.getUserId(),RoleNameConstants.VEHPC_COMMITTEE);
		boolean hasExecutePresidentRole = hasUserRole(themeDisplay, themeDisplay.getUserId(),RoleNameConstants.EXECUTIVE_PRESIDENT);
		boolean hasVehpcCAdminRole = hasUserRole(themeDisplay, themeDisplay.getUserId(), RoleNameConstants.VEHPC_ADMIN);
		renderRequest.setAttribute("hasVehpcCommitteeRole", hasVehpcCommitteeRole);
		renderRequest.setAttribute("hasExecutePresidentRole", hasExecutePresidentRole);
		renderRequest.setAttribute("hasVehpcCAdminRole", hasVehpcCAdminRole);
		
		
		
		
		List<ListTypeEntry> listTypeEntries = omsbCommonApi.getListTypeEntriesByERC(AppealConstants.PL_EQ_LEVEL,
				themeDisplay.getCompanyId());
		renderRequest.setAttribute("equivalencyLevelList", listTypeEntries);
		renderRequest.setAttribute("equivalencylevelkey", equivalencylevelkey);
		renderRequest.setAttribute("equivalencyDecisionId", decisionId);
		logger.info("equivalencyRequestId 22 is ?? " + equivalencyRequestId);
		renderRequest.setAttribute("equivalencyRequestId", equivalencyRequestId);
		renderRequest.setAttribute("decisiondocinfo", decisiondocinfo);
		renderRequest.setAttribute("statusList", list);
	    renderRequest.setAttribute("docsList", documentInfos); // this is for
		// supporting documents need to fix the issue.
		renderRequest.setAttribute("certificatefileurl",certificatefileUrl );
		renderRequest.setAttribute("comments", comments);
		renderRequest.setAttribute("appealId", eqAppealId);
		String appeallantUserRole = "";
		if (Validator.isNotNull(appeallantUser)) {
			appeallantUserRole = getRoleName(appeallantUser.getUserId());
			renderRequest.setAttribute("appeallantUserName", appeallantUser.getFullName());
		}
		renderRequest.setAttribute("appeallantUserRole", appeallantUserRole);
		renderRequest.setAttribute("createdDate", omsbCommonApi.convertDate(createdDate));
		renderRequest.setAttribute("certificateName", certificateFileName);
		renderRequest.setAttribute("appealComments", appealComments);
		renderRequest.setAttribute("level", level);
		renderRequest.setAttribute(Constants.CMD, cmd);
		renderRequest.setAttribute("transitionName", transitionName);
		renderRequest.setAttribute("workflowInstanceId", instanceId);
		renderRequest.setAttribute("workflowTaskId", workflowTaskId);
		renderRequest.setAttribute("appealStatusColur", appealUtil.getColorMap());
		
		logger.info("EditAppealCommitteMVCRenderCommand ended(");
		return AppealConstants.EDIT_APPEAL_ADMIN_JSP;
	}
	
	private String getFileURL(long fileEntryId) {
		try {

			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			String fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			logger.info("url ?? " + fileUrl);
			return fileUrl;
		} catch (PortalException e) {
			logger.error(e.getMessage(),e);
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
	
	private static final Log logger = LogFactoryUtil.getLog(EditAppealCommitteMVCRenderCommand.class);

}
