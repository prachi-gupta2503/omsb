package omsb.vehpc.equivalency.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.font.FontProvider;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.EquivalencyRequestStatusEnum;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EquivalencyRequestCertificate;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppeal;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealItems;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.vehpc.appeal.dto.web.SearchDto;
import omsb.vehpc.equivalency.dto.web.DocumentInfo;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificate;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificateItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionLevelItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyCertificateConstants;

@Component(immediate = true, service = AppealUtil.class)
public class AppealUtil {

	public EquivalencyCertificate getEquivalencyCertificateByEqRequest(ThemeDisplay themeDisplay, EquivalencyRequest eqRequest) {
		String certificateURL = omsbCommonApi.getBaseURL() + 
				LRObjectURL.EQUIVALENCY_CERTIFICATE_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()));
		certificateURL = certificateURL + StringPool.QUESTION + "filter=equivalencyRequestId" + URLEncoder.encode(" eq " + eqRequest.getId(), StandardCharsets.UTF_8);
		logger.info("certificateURL is ?? " + certificateURL);
		String response = oMSBHttpConnector.executeGet(certificateURL, "", headerUtil.getHeaders()); // omsbCommonApi.getData(certificateURL);
		logger.debug("certificate response ?? " + response);
		if (Validator.isNotNull(response) && response.contains("equivalencyRequestId")) {
			EquivalencyCertificateItems items = CustomObjectMapperUtil.readValue(response, EquivalencyCertificateItems.class);
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
				logger.error(e.getMessage(),e);
			}
			logger.info("url ?? " + fileUrl);
		}
		
		return fileUrl;
	}
	
	
	
	public FileEntry getFileEntryById(long fileEntryId) {
		try {
			return DLAppServiceUtil.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	
	
	public String getStatus(long statusId, ThemeDisplay themeDisplay) {
		try {
			ListTypeEntry entry = ListTypeEntryLocalServiceUtil.getListTypeEntry(statusId);
			if (Validator.isNotNull(entry)) {
				logger.info("Status ::::::"+entry.getName(themeDisplay.getLocale()));
				return entry.getName(themeDisplay.getLocale());
			}
		} catch (PortalException | NumberFormatException e) {
			logger.error(e.getMessage());
		}
		return "Pending";
	}
	public String getFinalStatus(boolean isEmployer, boolean isCommittee, boolean isAdmin, String status,
			boolean isRapporteur) {
		StringBuilder finalStatus = new StringBuilder();

		if (isAdmin) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.CREATED.getText())
					|| status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EQUATED.getText())
					|| status.equalsIgnoreCase(EquivalencyRequestStatusEnum.ADMIN_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INSUFFICIENT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INSUFFICIENT.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
						finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		} else if (isCommittee) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
			}  else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		} else if (isEmployer) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INSUFFICIENT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INSUFFICIENT.getText());
			}else if(status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			}
			else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		} else if (isRapporteur) {
			if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.INITIATED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.RECEIVED.getText());
			} else if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText());
			} else if (!status.equalsIgnoreCase(EquivalencyRequestStatusEnum.COMPLETED.getText())) {
				finalStatus.append(EquivalencyRequestStatusEnum.INPROGRESS.getText());
			} else {
				finalStatus.append(EquivalencyRequestStatusEnum.getStatusByLabel(status).getText());
			}
		}
		return finalStatus.toString();
	}
	
	public String getFinalStatusValue(boolean isAdmin, boolean isEmployer ,String key, ThemeDisplay themeDisplay, String status) {
		ListTypeEntry statusListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
				LRPicklistConstants.PL_EQUIVALENCY_STATUS, key, themeDisplay.getCompanyId());
		if (Validator.isNotNull(statusListTypeEntry)) {
			if(isAdmin) {
				if (key.equalsIgnoreCase(EquivalencyRequestStatusEnum.INPROGRESS.getText())) {
					return "Submitted(To Committee)";
				}
				if (status.equalsIgnoreCase(EquivalencyRequestStatusEnum.EQUATED.getText())) {
					return "Receieved(From Rapporteur)";
				}
			}else if(isEmployer) {
				if (key.equalsIgnoreCase(EquivalencyRequestStatusEnum.INPROGRESS.getText())) {
					return "Submitted";
				}
				if (key.equalsIgnoreCase(EquivalencyRequestStatusEnum.EMPLOYER_DRAFT.getText())) {
					return "Draft";
				}
			}
			
			return statusListTypeEntry.getName(themeDisplay.getLocale());
		}
		return "";
	}
	
	
	
//	private String getFinalStatus(ThemeDisplay themeDisplay, String status) {
//        
//		boolean isAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN, themeDisplay.getUserId());
//		boolean isEmployer = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYER, themeDisplay.getUserId());
//		boolean isEmployee = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EMPLOYEE, themeDisplay.getUserId());
//		boolean isCommittee = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_COMMITTEE, themeDisplay.getUserId());
//		boolean isPresident = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.EXECUTIVE_PRESIDENT, themeDisplay.getUserId());
//		logger.info("isEmployer ?? " + isEmployer + "  isCommittee  ?? " + isCommittee + "  is Admin ?? " + isAdmin + " status ?? " + status);
//		
//        StringBuilder finalStatus = new StringBuilder();
//        if ((isAdmin || isCommittee) && status.equalsIgnoreCase("Created")) {
//            finalStatus.append("Received");
//        } else if ((isAdmin || isCommittee || isPresident) && !status.equalsIgnoreCase("Completed")) {
//            finalStatus.append("In Progress");
//        } else if (isPresident && status.equalsIgnoreCase("Raised")) {
//            finalStatus.append("Received");
//        } else if (isPresident && !status.equalsIgnoreCase("Raised") && !status.equalsIgnoreCase("Completed")) {
//            finalStatus.append("In Progress");
//        } else if ((isEmployee || isEmployer) && !status.equalsIgnoreCase("Completed")) {
//        	 finalStatus.append("In Progress");
//        } else {
//        	finalStatus.append(status);
//        }
//        logger.info("finalStatus ?? " + finalStatus);
//        return finalStatus.toString();
//    }
	public String getEqLevelByDecisionId(long decisionLevelId, ThemeDisplay themeDisplay) {
		String response = oMSBHttpConnector.executeGet(
				themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL + decisionLevelId, "",
				headerUtil.getHeaders());
		EquivalencyDecisionLevel decisionLevel = CustomObjectMapperUtil.readValue(response, EquivalencyDecisionLevel.class);
		String equivalencylevelkey = "";
		if (Validator.isNotNull(decisionLevel)) {
			EquivalencyLevel equivalencyLevelId = decisionLevel.getEquivalencyLevelId();
			if (Validator.isNotNull(equivalencyLevelId)) {
				equivalencylevelkey = equivalencyLevelId.getKey();
			}
		return  equivalencylevelkey;
		}
		return null;
	}
	
	public EquivalencyDecisionLevel getEqDecisionLevelByDecisionId(long decisionLevelId, ThemeDisplay themeDisplay) {
		String response = oMSBHttpConnector.executeGet(
				themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL + decisionLevelId, "",
				headerUtil.getHeaders());
		return CustomObjectMapperUtil.readValue(response, EquivalencyDecisionLevel.class);
	}
	
	

	/**
	 * 
	 * @param themeDisplay
	 * @param classPK
	 * @param equivalencyappeal
	 */
	
	public void getWorkflowTransitionNames(ThemeDisplay themeDisplay, long classPK,
			EquivalencyAppeal equivalencyappeal) {
		String className = getObjectClassName(themeDisplay.getCompanyId());
		try {
			WorkflowInstance instance = appealWrokflowUtil.getWorkflowInstace(className, themeDisplay, classPK);
			List<WorkflowLog> logs = appealWrokflowUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
			if (!logs.isEmpty()) {
				long taskId = appealWrokflowUtil.getWorkflowTaskIdByLogs(logs);
				logger.info("workflowTaskId    "+taskId);
				WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
				long assigneeRoleId = appealWrokflowUtil.getWorkflowAssigneeRoleIdByLogs(logs);
				boolean assignedToRole = appealWrokflowUtil.isWorkFlowTaskAssignedToRole(themeDisplay, assigneeRoleId);
				boolean isTaskCompleted = WorkflowTaskManagerUtil.fetchWorkflowTask(taskId).isCompleted();
				logger.info("is assignedToRole ?? " + assignedToRole + "  ::  isTaskCompleted ?? " + isTaskCompleted);
				List<String> transitionNames = appealWrokflowUtil.getTransitionNames(themeDisplay, taskId);
				logger.info("transitionNames ?? " + transitionNames.toString());
				equivalencyappeal.setAssignedToMe(assignedToRole);
				equivalencyappeal.setWorkflowInstanceId(instance.getWorkflowInstanceId());
				equivalencyappeal.setWorkflowTaskId(taskId);
				equivalencyappeal.setTransitionNames(transitionNames);
			}
		} catch (PortalException e) {
			logger.error("exception while calling workflow", e);
		}
	}
	
	/**
	 * 
	 * @param companyId
	 * @return
	 */
	private String getObjectClassName(long companyId) {
		ObjectDefinition definition = null;
		try {
			definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(AppealConstants.OBJECT_ERC,
					companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param roleName
	 * @param comments
	 * @param eqAppealId
	 * @param statusId
	 * @param levelId
	 * @author AftabA
	 * @param userId
	 * @param eqStatusName
	 * @param eqStatusKey
	 * @param appealCertificate
	 * @param appealLevelReason
	 * @return this method is used to save the Appeal Status data
	 */
	public EquivalencyAppealStatus saveAppealStatus(ThemeDisplay themeDisplay, String roleName, String comments,
			long eqAppealId, long statusId, String equivalencyLevel, String equivalencyLevelReason,
			String equivalencyCertificate, long userId) {
		try {
			JSONObject object = JSONFactoryUtil.createJSONObject();
			
			if (roleName.equalsIgnoreCase(RoleNameConstants.VEHPC_COMMITTEE)) {
				object.put("iscommitte", true);
			} else if (roleName.equalsIgnoreCase(RoleNameConstants.VEHPC_ADMIN)) {
				object.put("isAdmin", true);
			} else if (roleName.equalsIgnoreCase(RoleNameConstants.VEHPC_RAPPORTEUR)) {
				object.put("israpporteur", true);
			}

			object.put("eQAppealId", eqAppealId);
			object.put("lruserId", userId);
			object.put("message", comments);
			object.put("statusId", statusId);
			object.put("equivalencyLevel", equivalencyLevel);
			object.put("equivalencyLevelReason", equivalencyLevelReason);
			object.put("equivalencyCertificate", equivalencyCertificate);

			String url = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_STATUS_URL_VIEW
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
			String response = oMSBHttpConnector.executePost(url, object.toString(), headerUtil.getHeaders());
			return CustomObjectMapperUtil.readValue(response, EquivalencyAppealStatus.class);
		} catch (Exception e) {
			logger.error("Exception while saving the appeal status  :: ", e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param appealId
	 * @param statusId
	 */
	public void updateEquivalencyAppeal(ThemeDisplay themeDisplay, long appealId, long statusId) {
		String url = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + appealId;
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("statusID", statusId);
		logger.info("Appeal put url is ?? " + url);
		logger.info("object ?? " + object.toString());
		String response = oMSBHttpConnector.executePut(url, object.toString(), headerUtil.getHeaders());
		logger.info("response ?? " + response);
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param decisionLevelId
	 * @param level
	 * @return
	 */
	public EquivalencyDecisionLevel updateEquivalencyDecisionLevel(ThemeDisplay themeDisplay, long decisionLevelId, String level) {
		String url = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL + decisionLevelId;
		JSONObject object = JSONFactoryUtil.createJSONObject();
		JSONObject levelObject = JSONFactoryUtil.createJSONObject();
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_LEVEL, level, themeDisplay.getCompanyId());
		if (Validator.isNotNull(entry)) {
			levelObject.put("key", entry.getKey());
			levelObject.put("name", entry.getName());
		}
		object.put("equivalencyLevelId", levelObject.toString());
		logger.info("Appeal put url is ?? " + url);
		logger.info("object ?? " + object.toString());
		String response = oMSBHttpConnector.executePut(url, object.toString(), headerUtil.getHeaders());
		logger.info("response ?? " + response);
		return CustomObjectMapperUtil.readValue(response, EquivalencyDecisionLevel.class);
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param equivalencyLevel
	 * @param equivalencyRequestId
	 * @param comments
	 * @param decisiondocinfoId
	 * @return this method is used to save the equivalency decision
	 */
	public String saveEquivalencyDecision(ThemeDisplay themeDisplay, long equivalencyLevel,String equivalencyLevelReasonKey, long equivalencyRequestId,
			String comments, long decisiondocinfoId) {
		String eqDecisionResponse = null;
		try {
			JSONObject levelObject = JSONFactoryUtil.createJSONObject();
			ListTypeEntry entry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(equivalencyLevel);
			if (Validator.isNotNull(entry)) {
				levelObject.put("name", entry.getName(themeDisplay.getLocale()));
				levelObject.put("key", entry.getKey());
			}

			JSONObject payload = JSONFactoryUtil.createJSONObject();
			payload.put("equivalencyRequestId", equivalencyRequestId);
			payload.put("decisionBy", themeDisplay.getUserId());
			payload.put("documentInfoId", decisiondocinfoId);
			payload.put("comments", comments);
			payload.put("equivalencyLevelId", levelObject);
			payload.put("otherEquivalency", equivalencyLevelReasonKey);
			String url = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_DECISION_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId();
			logger.info("Equivalency Decision URL is ?? " + url);
			logger.info(" payload is ?? " + payload.toString());
			eqDecisionResponse = oMSBHttpConnector.executePost(url, payload.toString(), headerUtil.getHeaders());
		} catch (Exception e) {
			logger.error("Exception while saving the equivalency decision :: ", e);
		}
		return eqDecisionResponse;
	}

	/**
	 * 
	 * @param transitionName
	 * @param cmd
	 * @param themeDisplay
	 * @param workflowInstance
	 * @param workflowTaskId
	 * @throws PortalException
	 * @return It will assign or complete the workflow based on given condition
	 */
	/*public void assignOrCompleteWorkflow(String transitionName, String cmd, ThemeDisplay themeDisplay,
			WorkflowInstance workflowInstance, long workflowTaskId) throws PortalException {
		logger.info("transitionName ?? " + transitionName);
		logger.info("cmd ?? " + cmd);
		logger.info("workflowInstance ?? " + workflowInstance.getWorkflowInstanceId());
		logger.info("workflowTaskId ?? " + workflowTaskId);
		if (AppealConstants.CMD_ASSIGN_TO_ME.equalsIgnoreCase(cmd)) {
			appealWrokflowUtil.assignWorkflowToUser(themeDisplay, workflowInstance, workflowTaskId);
			logger.info("work flow taskId :::::::::: " + workflowTaskId + "   has assigned to user ::: :: "
					+ themeDisplay.getUserId());
		} else if (AppealConstants.CMD_COMPLETE_WORKFLOW.equalsIgnoreCase(cmd)) {
			logger.info("transition Name " + transitionName);
			appealWrokflowUtil.completeWorkflowTask(themeDisplay, workflowInstance, workflowTaskId, "", transitionName);
		}
	}*/

	/**
	 * 
	 * @param roles
	 * @return This method returns appeal role name
	 */
	public String getAppealRoleName(List<Role> roles) {
		List<String> roleNames = roles.stream().map(Role::getName).collect(Collectors.toList());
		if (roleNames.contains(RoleNameConstants.EXECUTIVE_PRESIDENT)) {
			return RoleNameConstants.EXECUTIVE_PRESIDENT;
		} else if (roleNames.contains(RoleNameConstants.VEHPC_ADMIN)) {
			return RoleNameConstants.VEHPC_ADMIN;
		} else if (roleNames.contains(RoleNameConstants.VEHPC_COMMITTEE)) {
			return RoleNameConstants.VEHPC_COMMITTEE;
		}
		return "";
	}

	/**
	 * 
	 * @param listTypeEntryId
	 * @param themeDisplay
	 * @return
	 */
	public String getListTypeEntryKeyById(long listTypeEntryId, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = listTypeEntryLocalService.fetchListTypeEntry(listTypeEntryId);
		if (Validator.isNotNull(entry)) {
			return entry.getKey();
		}
		return "";
	}

	
	/**
	 * 
	 * @param decisionId
	 * @param themeDisplay
	 * @return
	 */
	public boolean isAppealExist(long decisionId, ThemeDisplay themeDisplay) {
		boolean isExist = false;
		EquivalencyAppeal appeal = getAppealByEqDecisionLevelId(themeDisplay, decisionId);
		if (Validator.isNotNull(appeal)) {
			isExist = true;
		}
		return isExist;
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param decisionId
	 * @return
	 */
	public EquivalencyAppeal getAppealByEqDecisionLevelId(ThemeDisplay themeDisplay, long decisionId) {
		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		decisionUrl = decisionUrl + "filter=eQDecisionId"
				+ URLEncoder.encode(" eq " + decisionId, StandardCharsets.UTF_8);
		logger.info("decisionUrl ?? " + decisionUrl);
		String response = oMSBHttpConnector.executeGet(decisionUrl, "", headerUtil.getHeaders());
		EquivalencyAppealItems items = CustomObjectMapperUtil.readValue(response, EquivalencyAppealItems.class);
		if (Validator.isNotNull(items) && Validator.isNotNull(items.getItems()) && !items.getItems().isEmpty()) {
			return items.getItems().get(0);
		}
		return null;
	}
	
	
	public List<EquivalencyDecisionLevel> getDecisionLevelsByEqRequestId(ThemeDisplay themeDisplay, long eqRequestId) {
		String decisionUrl = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION;
		decisionUrl = decisionUrl + "filter=eqRequestId"
				+ URLEncoder.encode(" eq " + eqRequestId, StandardCharsets.UTF_8);
		logger.info("decisionUrl ?? " + decisionUrl);
		String response = oMSBHttpConnector.executeGet(decisionUrl, "", headerUtil.getHeaders());
		EquivalencyDecisionLevelItems items = CustomObjectMapperUtil.readValue(response, EquivalencyDecisionLevelItems.class);
		if (Validator.isNotNull(items) && Validator.isNotNull(items.getItems()) && !items.getItems().isEmpty()) {
			return items.getItems();
		}
		return null;
	}

	/**
	 * 
	 * @param groupId
	 * @param personId
	 * @param themeDisplay
	 * @return
	 */
	public DLFolder createFolderStructure(long groupId, long personId, ThemeDisplay themeDisplay) {
		logger.info("personId ?? ......." + personId);
		long parentFolderId = 0;
		DLFolder personFolder = null;
		DLFolder appealFolder = null;
		DLFolder ePortalFolder = null;
		DLFolder parentFolder = FileUploadUtil.getDLFolder(themeDisplay.getScopeGroupId(), parentFolderId,
				CommonConstants.PARENT_FOLDER_NAME);
		if (Validator.isNull(parentFolder)) {
			parentFolder = FileUploadUtil.createDLFolder(themeDisplay.getScopeGroupId(),
					CommonConstants.PARENT_FOLDER_NAME, parentFolderId, themeDisplay.getUserId(), StringPool.BLANK);
		}
		if (Validator.isNotNull(parentFolder)) {
			ePortalFolder = FileUploadUtil.getDLFolder(themeDisplay.getScopeGroupId(), parentFolder.getFolderId(),
					CommonConstants.LEVEL_1_FOLDER_NAME);
			if (Validator.isNull(ePortalFolder)) {
				logger.info("creating new folder .......");
				ePortalFolder = FileUploadUtil.createDLFolder(themeDisplay.getScopeGroupId(),
						CommonConstants.LEVEL_1_FOLDER_NAME, parentFolder.getFolderId(), themeDisplay.getUserId(), "");
				logger.info(" new folder created.......");
			}
		}

		if (Validator.isNotNull(ePortalFolder)) {
			logger.info(" ePortalFolder is not null.......");
			personFolder = FileUploadUtil.getDLFolder(themeDisplay.getScopeGroupId(), ePortalFolder.getFolderId(),
					String.valueOf(personId));
			logger.info(" personFolder getting ......." + personFolder);
			if (Validator.isNull(personFolder)) {
				logger.info(" personFolder getting  null .......");
				personFolder = FileUploadUtil.createDLFolder(themeDisplay.getScopeGroupId(), String.valueOf(personId),
						ePortalFolder.getFolderId(), themeDisplay.getUserId(), "");
				logger.info(" personFolder getting  created .......");
			}
		}

		if (Validator.isNotNull(personFolder)) {
			appealFolder = FileUploadUtil.getDLFolder(themeDisplay.getScopeGroupId(), personFolder.getFolderId(),
					AppealConstants.VEHPC_APPEAL_FOLDER_NAME);
			if (Validator.isNull(appealFolder)) {
				appealFolder = FileUploadUtil.createDLFolder(themeDisplay.getScopeGroupId(),
						AppealConstants.VEHPC_APPEAL_FOLDER_NAME, personFolder.getFolderId(), themeDisplay.getUserId(),
						null);
			}
		}
		return appealFolder;
	}
	  
	/**
	 * 
	 * @param renderRequest
	 * @param eqRequestId
	 * @return
	 */
	public DLFileEntry createDecisionLevelCertificate(PortletRequest renderRequest, long eqRequestId, String html) {
		DLFileEntry fileEntry = null;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
			serviceContext.setAddGroupPermissions(true);
			DLFolder userFolder = null, equivalencyFolder = null, equivalencyCertificateFolder = null;
			DynamicQuery folderQuery;

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name")
					.eq(String.valueOf(String.valueOf(themeDisplay.getUserId()) + " documents")));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery
					.add(PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
			List<DLFolder> folderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> folderNameList = folderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!folderNameList.contains(String.valueOf(themeDisplay.getUserId()) + " documents")) {
				userFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						String.valueOf(themeDisplay.getUserId()) + " documents",
						EquivalencyCertificateConstants.USER + " documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name")
						.eq(String.valueOf(themeDisplay.getUserId()) + " documents"));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(
						PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
				userFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name")
					.eq(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY)));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(userFolder.getFolderId()));
			List<DLFolder> equivalencyFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyFolderNameList = equivalencyFolderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!equivalencyFolderNameList.contains(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY))) {
				equivalencyFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						userFolder.getFolderId(), EquivalencyCertificateConstants.EQUIVALENCY,
						EquivalencyCertificateConstants.EQUIVALENCY + " documents", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name")
						.eq(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY)));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(userFolder.getFolderId()));
				equivalencyFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(
					PropertyFactoryUtil.forName("name").eq(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(equivalencyFolder.getFolderId()));
			List<DLFolder> equivalencyCertificateFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyCertificateFolderNameList = equivalencyCertificateFolderList.parallelStream()
					.map(DLFolder::getName).collect(Collectors.toList());
			if (!equivalencyCertificateFolderNameList
					.contains(String.valueOf(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE))) {
				equivalencyCertificateFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK,
						themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
						Boolean.FALSE, equivalencyFolder.getFolderId(),
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + " documents", Boolean.FALSE,
						serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name")
						.eq(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(equivalencyFolder.getFolderId()));
				equivalencyCertificateFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			File file = generatePdfDocument(html, themeDisplay);
			if (Validator.isNotNull(file)) {
				InputStream inputStream = new FileInputStream(file);
				long timeStamp = new Date().getTime();
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(),
						equivalencyCertificateFolder.getFolderId(),
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp + ".pdf",
						ContentTypes.APPLICATION_PDF,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp,
						EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL,
						EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null, file, inputStream,
						file.length(), null, null, serviceContext);
				String download = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ fileEntry.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH
						+ URLEncoder.encode(HtmlUtil.unescape(fileEntry.getTitle()), DataflowConstants.UTF_8)
						+ StringPool.SLASH + fileEntry.getUuid() + "?version=" + fileEntry.getVersion();
				logger.info("Download >>>>>" + download);
			}

		} catch (IOException | PortalException e) {
			logger.error("Error while generting PDF file, " + e.getMessage());
		} finally {
			try {
				Files.walk(Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH))
						.filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
			} catch (IOException e) {
				logger.error("Error while deleting all files from directory, " + e.getMessage());
			}

		}
		return fileEntry;

	}
	 /**
	   * 
	   * @param themeDisplay
	   * @param html
	   * @return
	   */
	private File generatePdfDocument(String certHTML, ThemeDisplay themeDisplay) {
		try {
			Path dirPath = Paths.get(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH);
			if (!Files.exists(dirPath)) {

				Files.createDirectory(dirPath);

				Path filePath = dirPath.resolve(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
				if (!Files.exists(filePath)) {
					Files.createFile(filePath);
				}
			}
			File file = new File(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_PATH
					+ EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_FILE_NAME);
			PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
			ConverterProperties properties = new ConverterProperties();
			Rectangle rect = new Rectangle(1200, 1600);
			pdfDocument.setDefaultPageSize(new PageSize(rect));
			properties.setBaseUri(EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_IMAGE_FILE_PATH);
			FontProvider fontProvider = new DefaultFontProvider(false, false, false);
			FontProgram fontProgram = FontProgramFactory
					.createFont(themeDisplay.getPathThemeCss() + "/fonts/Lateef/Lateef-Regular.ttf");
			fontProvider.addFont(fontProgram);
			FontProgram fontProgram2 = FontProgramFactory
					.createFont(themeDisplay.getPathThemeCss() + "/certificate-fonts/FontEnglish.ttf");
			fontProvider.addFont(fontProgram2);

			properties.setFontProvider(fontProvider);

			Document document = HtmlConverter.convertToDocument(certHTML, pdfDocument, properties);
			document.setMargins(0, 0, 0, 0);
			document.close();
			pdfDocument.close();

			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	  /**
	   * 
	   * @param eqRequestId
	   * @param themeDisplay
	   * @param html
	   * @return
	   */
	  public String getCertificateDetailByDDMTemplate(long eqRequestId, ThemeDisplay themeDisplay, String html) {
		  html = html.replace("$[date]", getDate());
		  logger.info("getCertificateDetailByDDMTemplate calling ");
		  EquivalencyRequest eqRequest = getEquivalencyRequestById(eqRequestId, themeDisplay);
		  if (Validator.isNotNull(eqRequest)) {
			  logger.info("person Id is ?? " + eqRequest.getPersonId());
			  Person person = getPersonDetailById(eqRequest.getPersonId(), themeDisplay);
			  PersonalDetail personal = getPersonalDetailByPersonId(eqRequest.getPersonId(), themeDisplay); 
			  if (Validator.isNotNull(person) && Validator.isNotNull(personal)) {
				  List<EquivalencyRequestCertificate> list = getDecisionLevelByEqRequestId(themeDisplay, eqRequestId, personal, person);
				  if (Validator.isNotNull(list) && !list.isEmpty()) {
					  logger.info("list size ?? " + list.size());
					  html = html.replace("$[name]", Validator.isNotNull(list.get(0).getName())?list.get(0).getName():"");
					  html = html.replace("$[passportNumber]", Validator.isNotNull(list.get(0).getPassportNumber())?list.get(0).getPassportNumber():"");
					  html = html.replace("$[dob]", Validator.isNotNull(list.get(0).getDob())?list.get(0).getDob():"");
					  html = html.replace("$[certificateName]", Validator.isNotNull(list.get(0).getCertificateName())?list.get(0).getCertificateName():"");
					  html = html.replace("$[issueCountry]", String.valueOf(list.get(0).getIssueCountry()));
					  html = html.replace("$[graduationYear]", Validator.isNotNull(list.get(0).getGraduationYear())?list.get(0).getGraduationYear():"");
					  html = html.replace("$[eqLevel]", Validator.isNotNull(list.get(0).getEqLevel())?list.get(0).getEqLevel():"");
					  html = html.replace("$[remarks]", Validator.isNotNull(list.get(0).getRemarks())?list.get(0).getRemarks():"");
				  }
			  }
		  }
		  logger.info("getCertificateDetailByDDMTemplate calling ends here");
		  return html;
	  }
	  
	  private String getDate() {
		  Date date = new Date();
		  DateFormat format = new SimpleDateFormat("dd MMM YYYY");
		  return format.format(date);
	  }
	  
	  public SearchDto addDetails(String fileName, String employer, EquivalencyDecisionLevel level, String employee, boolean isAppealExist, EquivalencyCertificate certificate, String status, long eqRequestId) {
			SearchDto searchDto = new SearchDto();
			try {
				logger.info("addDetails starts");
				logger.info("is appeal exist " + isAppealExist);
				searchDto.seteQRequestedId(eqRequestId);
				searchDto.setFileName(fileName);
				searchDto.setEmployer(employer);
				searchDto.setEmployee(employee);
				if (Validator.isNotNull(level)) {
					if (Validator.isNotNull(level.getEquivalencyLevelId())) {
						searchDto.setEquivalencyLevel(level.getEquivalencyLevelId().getName());
					}
				/*
				 * String newDecisionDate = omsbCommonApi.convertDate(level.getDateCreated(),new
				 * SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT), new
				 * SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD));
				 */
					searchDto.setDob("");
					searchDto.setEquivalencyDecisionId(level.getId());
				}
				searchDto.setAppealExist(isAppealExist);
				searchDto.setStatus(status);
				if (Validator.isNotNull(certificate)) {
					searchDto.setCertificateName(certificate.getFileName());
				//	searchDto.setCertificateURL(getFileURL(certificate.getFileEntryId()));
				} 
				logger.info("addDetails ends");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			return searchDto;
		}
	  
	  /**
	   * 
	   * @param themeDisplay
	   * @param eqRequestId
	   * @param personal
	   * @param person
	   * @return
	   */
	  private List<EquivalencyRequestCertificate> getDecisionLevelByEqRequestId(ThemeDisplay themeDisplay, long eqRequestId, PersonalDetail personal, Person person) {
		  List<EquivalencyRequestCertificate> certificateList = new ArrayList<>();
		  String equivalencyDecisionLevellURL = themeDisplay.getPortalURL()
					+ AppealConstants.DECISION_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=eqRequestId"
							+ URLEncoder.encode(" eq " + eqRequestId, StandardCharsets.UTF_8); 
			String dLResponse = omsbCommonApi.getData(equivalencyDecisionLevellURL);
			logger.info("decisionLevelResponse ?? " + dLResponse);
			EquivalencyDecisionLevelItems decisionLevelItems = CustomObjectMapperUtil.readValue(dLResponse, EquivalencyDecisionLevelItems.class);
			if (Validator.isNotNull(decisionLevelItems) && Validator.isNotNull(decisionLevelItems.getItems()) && !decisionLevelItems.getItems().isEmpty()) {
				logger.info("level size is  ?? " + decisionLevelItems.getItems().size());
				for (EquivalencyDecisionLevel level : decisionLevelItems.getItems()) {
					logger.info("level is ?? " + level);
					if (Validator.isNotNull(level)) {
						DocumentInfo document = getDocumentInfoById(level.getDocumentInfoId(), themeDisplay);
						EducationDetail education = getEducationDetailById(themeDisplay, document.getComponentClassRefId());
						certificateList.add(setCertificateDetail(personal, person, education, level));
					}
				}
			}
			return certificateList;
	  }
	  
	  /**
	   * 
	   * @param personal
	   * @param person
	   * @param education
	   * @param level
	   * @return
	   */
	  private EquivalencyRequestCertificate setCertificateDetail(PersonalDetail personal, Person person, EducationDetail education, EquivalencyDecisionLevel level) {
		  EquivalencyRequestCertificate certificate = new EquivalencyRequestCertificate();
		  String giveName = "";
		  String dob = "";
		  String passportNumber = "";
		  String qualification = "";
		  String conferredDate = "";
		  String issueCountry = "";
		  String levelName = "";
		  String comments = "";
		  if (Validator.isNotNull(personal)) {
			  giveName = personal.getGivenNameAsPassport();
		  }
		  if (Validator.isNotNull(person)) {
			  dob = omsbCommonApi.convertDateFormatToDDMMYYYY(Validator.isNotNull(person.getDateOfBirth())?person.getDateOfBirth():"");
			  passportNumber = person.getPassportNumber();
		  }
		  if (Validator.isNotNull(education)) {
			 qualification = education.getQualificationAttained();
			 conferredDate = omsbCommonApi.convertDateFormatToDDMMYYYY(Validator.isNotNull(education.getQualificationConferredDate())?education.getQualificationConferredDate():"");
		     issueCountry = String.valueOf(education.getIssuingAuthorityName());
		  } 
		  if (Validator.isNotNull(level) && Validator.isNotNull(level.getEquivalencyLevelId())) {
			  levelName = level.getEquivalencyLevelId().getName();
			  comments = level.getComments();
		  }
		  certificate.setName(giveName);
		  certificate.setDob(dob);
		  certificate.setPassportNumber(passportNumber);
		  certificate.setCertificateName(qualification);
		  certificate.setGraduationYear(conferredDate);
		  certificate.setIssueCountry(issueCountry);
		  certificate.setEqLevel(levelName);
		  certificate.setRemarks(comments);
		return certificate;
	  }
	  
	  /**
	   * 
	   * @param themeDisplay
	   * @param id
	   * @return
	   */
	  private EducationDetail getEducationDetailById(ThemeDisplay themeDisplay, long id) {
		  String educationDetailURL = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + id;
		  String educationResponse = omsbCommonApi.getData(educationDetailURL);
		  logger.info("educationResponse ??? " + educationResponse);
		  if (educationResponse.contains("personId")) {
			  return CustomObjectMapperUtil.readValue(educationResponse, EducationDetail.class);
		  }
		  return null;
	  }
	  
	  /**
	   * 
	   * @param themeDisplay
	   * @param equivalencyCertificate
	   */
	  public String addCertificateToEquivalencyCetrificateTable(long siteId,
				omsb.vehpc.equivalency.dto.web.EquivalencyCertificate equivalencyCertificate,
				Map<String, String> headersInfo, ObjectMapper objectMapper) {

			String equivalencyCertificatePayload = "";
			try {
				equivalencyCertificatePayload = objectMapper.writeValueAsString(equivalencyCertificate);
			} catch (JsonProcessingException e) {
				logger.error(e.getMessage());
			}

			String officialRequestfileUploadDetailURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_CERTIFICATE_URL,
					siteId);
			return omsbHttpConnector.executePost(officialRequestfileUploadDetailURL, equivalencyCertificatePayload,
					headersInfo);
		}
	  
	  /**
	   * @param equivalencyDecisionLevelId
	   * @param themeDisplay
	   * @param comments
	   * @param equivalencyLevelId
	   * @param equivalencyLevelReasonKey
	   */
	  public void updatedecisionLevel(long equivalencyDecisionLevelId, ThemeDisplay themeDisplay, String comments,
				long equivalencyLevelId, String equivalencyLevelReasonKey) {
			String url = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL + equivalencyDecisionLevelId;
			JSONObject levelObject = JSONFactoryUtil.createJSONObject();
			ListTypeEntry entry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(equivalencyLevelId);
			if (Validator.isNotNull(entry)) {
				levelObject.put("name", entry.getName(themeDisplay.getLocale()));
				levelObject.put("key", entry.getKey());
			}
			JSONObject decisionLevelobject = JSONFactoryUtil.createJSONObject();
			decisionLevelobject.put("comments", comments);
			decisionLevelobject.put("equivalencyLevelId", levelObject);
			decisionLevelobject.put("equivalencyLevelReason", equivalencyLevelReasonKey);

			omsbHttpConnector.executePut(url, decisionLevelobject.toString(), headerUtil.getHeaders());
		}
	 
	  /**
	   * 
	   * @param eqRequest
	   * @param themeDisplay
	   * @return
	   */
	  public String getEmployerNameByEqRequest(EquivalencyRequest eqRequest , ThemeDisplay themeDisplay) {
			User user = null;
			if (Validator.isNotNull(eqRequest)) {
				user = userLocalService.fetchUser(eqRequest.getEmployerUserID());
			}
			if (Validator.isNotNull(user)) {
				return user.getFullName();
			}
			return AppealConstants.NO_DATA;
		}
			
		public String getEmployeeNameByEqRequest(EquivalencyRequest eqRequest , ThemeDisplay themeDisplay) {
			if (Validator.isNotNull(eqRequest)) {
				PersonalDetail details = getPersonalDetailByPersonId(eqRequest.getPersonId(), themeDisplay);
				if (Validator.isNotNull(details)) {
					return details.getGivenNameAsPassport();
				}
			}
			return AppealConstants.NO_DATA;
		}
			
		public PersonalDetail getPersonalDetailByPersonId(long personId, ThemeDisplay themeDisplay) {
			String personalURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL2 + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "search="+ personId;
		//	String personalResponse = omsbCommonApi.getData(personalURL);
			String personalResponse = oMSBHttpConnector.executeGet(personalURL, "", headerUtil.getHeaders());
			logger.debug("personalResponse ?? " + personalResponse);
			PersonalDetailItem personalItems = CustomObjectMapperUtil.readValue(personalResponse, PersonalDetailItem.class);
			if (Validator.isNotNull(personalItems) && Validator.isNotNull(personalItems.getItems()) && !personalItems.getItems().isEmpty()) {
				return personalItems.getItems().get(0);
			}
			return null;
		}
		
		public Person getPersonDetailById(long personId, ThemeDisplay themeDisplay) {
			String personURL = themeDisplay.getPortalURL() + LRObjectURL.GET_PERSON_BY_ID_URL2 + personId;
			String personResponse = omsbCommonApi.getData(personURL);
			logger.info("personalResponse ?? " + personResponse);
			if (personResponse.contains("dateOfBirth")) {
				return CustomObjectMapperUtil.readValue(personResponse, Person.class);
			}
			return null;
		}
			
		public EquivalencyRequest getEquivalencyRequestById(long eqRequestId, ThemeDisplay themeDisplay) {
			// find the role of logged in user Id 
			// if employer then emplyerId = themeDisplay.UserId
			// if employee then find the personId for logged in userId and in Url personId == personId 
			String eqRequestUrl = themeDisplay.getPortalURL() + AppealConstants.REQUEST_URL + eqRequestId;
			String response = omsbCommonApi.getData(eqRequestUrl);
			logger.debug("EquivalencyRequest API response is ?? " + response);
			EquivalencyRequest request = CustomObjectMapperUtil.readValue(response, EquivalencyRequest.class);
			return CustomObjectMapperUtil.readValue(response, EquivalencyRequest.class);
		}
		
	
		
		
		public String getDocumentfileName(ThemeDisplay themeDisplay, long documentInfoId) {
		    String documentInfoURL = themeDisplay.getPortalURL() + AppealConstants.DECISION_CERTIFICATE_URL + documentInfoId;
		 //   String documentInfoResponse = omsbCommonApi.getData(documentInfoURL);
		    String documentInfoResponse = oMSBHttpConnector.executeGet(documentInfoURL, "", headerUtil.getHeaders());
		    logger.debug("documentInfoResponse ?? " + documentInfoResponse);

		    if (Validator.isNotNull(documentInfoResponse) && !documentInfoResponse.isEmpty()) {
		        try {
		            DocumentInfo docInfo = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
		            if (Validator.isNotNull(docInfo)) {
		                FileEntry entry = getFileEntryById(docInfo.getFileEntryID());
		                if (Validator.isNotNull(entry)) {
		                	 String documentname = entry.getFileName();
		                	 logger.info("documentname ========= "+documentname);
		                	return documentname.replaceAll("^[0-9]+", "");
		                }
		            }
		        } catch (Exception e) {
		            logger.error("Error while processing documentInfoResponse: " + e.getMessage());
		        }
		    }

		    return AppealConstants.NO_DATA;
		}
		
		

		public DocumentInfo getDocumentInfoById(long documentInfoId, ThemeDisplay themeDisplay) {
			String documentInfoURL = themeDisplay.getPortalURL() + AppealConstants.DECISION_CERTIFICATE_URL + documentInfoId;
			String documentInfoResponse = omsbCommonApi.getData(documentInfoURL);
			logger.info("documentInfoResponse ?? "  + documentInfoResponse);
			return CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
		}
		public List<User> getUserByDynamicQuery(String name){
			DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
			Criterion criterion =  RestrictionsFactoryUtil.ilike("firstName", "%" + name + "%");
			criterion =RestrictionsFactoryUtil.or(criterion , RestrictionsFactoryUtil.ilike("lastName", "%" + name + "%"));
			dynamicQuery.add(criterion);
			List<User> userData = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
			logger.info("user data is ??" + userData.size());
			return userData;
		}
		
		/**
		 * 
		 * @param themeDisplay
		 * @return
		 */
		public Set<SearchDto> getAllData(ThemeDisplay themeDisplay) {
			
			String response = omsbCommonApi.getData(themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL
					+ "scopes/" + themeDisplay.getScopeGroupId()+ AppealConstants.PAGE_SIZE_WITH_QUESTION);
			EquivalencyAppealItems appealItems = CustomObjectMapperUtil.readValue(response, EquivalencyAppealItems.class);
			
			Set<SearchDto> searchDTO = new HashSet<>();
			if (Validator.isNotNull(appealItems) && Validator.isNotNull(appealItems.getItems()) && !appealItems.getItems().isEmpty()) {
				logger.info("descisionItem size ??" + appealItems.getItems().size());
				for (EquivalencyAppeal appeal : appealItems.getItems()) {
					EquivalencyRequest eqRequest = getEquivalencyRequestById(appeal.geteQRequestedId(), themeDisplay);
					if (Validator.isNotNull(eqRequest)) {
						String employeeName = getEmployeeNameByEqRequest(eqRequest, themeDisplay);
						String employerName = getEmployerNameByEqRequest(eqRequest, themeDisplay);
						EquivalencyDecisionLevel level = getEqDecisionLevelByDecisionId(appeal.geteQDecisionId(), themeDisplay);
						String fileName = getDocumentfileName(themeDisplay, level.getDocumentInfoId());
						logger.info("return fileName"+fileName);
						EquivalencyCertificate certificate = getEquivalencyCertificateByEqRequest(themeDisplay, eqRequest);
						String status = "";
						if (Validator.isNotNull(appeal)) {
							status = getStatus(appeal.getStatusID(), themeDisplay);
							getWorkflowTransitionNames(themeDisplay, Long.parseLong(appeal.getId()), appeal);
						}
						SearchDto dto = addDetails(fileName, employerName, level, employeeName, true, certificate, status, eqRequest.getId());
						dto = setAdditionalSearchData(dto, appeal);
						logger.info("dto              "+dto);
						searchDTO.add(dto);
					}
					
				}
			}
			return searchDTO;
		}
		
		public Set<SearchDto> getAllDataByEqId(ThemeDisplay themeDisplay, long eQRequestedId) {
			
			String url = themeDisplay.getPortalURL() + AppealConstants.EQ_APPEAL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=eQRequestedId"
					+ URLEncoder.encode(" eq " + eQRequestedId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";
			
			String response = omsbCommonApi.getData(url);
			EquivalencyAppealItems appealItems = CustomObjectMapperUtil.readValue(response, EquivalencyAppealItems.class);
			Set<SearchDto> searchDTO = new HashSet<>();
			if (Validator.isNotNull(appealItems) && Validator.isNotNull(appealItems.getItems()) && !appealItems.getItems().isEmpty()) {
				logger.info("descisionItem size ??" + appealItems.getItems().size());
				for (EquivalencyAppeal appeal : appealItems.getItems()) {
					EquivalencyRequest eqRequest = getEquivalencyRequestById(appeal.geteQRequestedId(), themeDisplay);
					if (Validator.isNotNull(eqRequest)) {
						String employeeName = getEmployeeNameByEqRequest(eqRequest, themeDisplay);
						String employerName = getEmployerNameByEqRequest(eqRequest, themeDisplay);
						EquivalencyDecisionLevel level = getEqDecisionLevelByDecisionId(appeal.geteQDecisionId(), themeDisplay);
						String fileName = getDocumentfileName(themeDisplay, level.getDocumentInfoId());
						logger.info("return fileName"+fileName);
						EquivalencyCertificate certificate = getEquivalencyCertificateByEqRequest(themeDisplay, eqRequest);
						String status = "";
						if (Validator.isNotNull(appeal)) {
							status = getStatus(appeal.getStatusID(), themeDisplay);
							getWorkflowTransitionNames(themeDisplay, Long.parseLong(appeal.getId()), appeal);
						}
						SearchDto dto = addDetails(fileName, employerName, level, employeeName, true, certificate, status, eqRequest.getId());
						dto = setAdditionalSearchData(dto, appeal);
						logger.info("dto              "+dto);
						searchDTO.add(dto);
					}
					
				}
			}
			return searchDTO;
		}
		
		/**
		 * 
		 * @param searchDTO
		 * @param appeal
		 * @return
		 */
		public SearchDto setAdditionalSearchData(SearchDto searchDTO, EquivalencyAppeal appeal) {
			logger.info("date ::::::::::: " + appeal.getDateCreated());
			searchDTO.setCreatedDate(omsbCommonApi.convertDate(appeal.getDateCreated(),new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT),
					new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD)));
			searchDTO.setWorkflowInstanceId(appeal.getWorkflowInstanceId());
			logger.info("appeal.getWorkflowInstanceId()"+appeal.getWorkflowInstanceId());
			searchDTO.setWorkflowTaskId(appeal.getWorkflowTaskId());
			searchDTO.setTransitionNames(appeal.getTransitionNames());
			searchDTO.setAssignedToMe(appeal.isAssignedToMe());
			searchDTO.setId(Long.parseLong(appeal.getId()));
			logger.info("Long.parseLong(appeal.getId())"+Long.parseLong(appeal.getId()));
			return searchDTO;
		}
		
		
		public SearchDto setDecisionLevelData(ThemeDisplay themeDisplay, EquivalencyRequest eqRequest, EquivalencyDecisionLevel decision, boolean hasEmployerRole) {
			long startTime = System.currentTimeMillis();
			String employeeName = "";
			String employerName = "";
			if (hasEmployerRole) {
				employeeName = getEmployeeNameByEqRequest(eqRequest, themeDisplay);
			} else {
				employerName = getEmployerNameByEqRequest(eqRequest, themeDisplay);
			}
			String documentName = getDocumentfileName(themeDisplay, decision.getDocumentInfoId());
			logger.info("documentName      "+ documentName);
			boolean isAppealExist = isAppealExist(decision.getId(), themeDisplay);
			EquivalencyCertificate certificate = getEquivalencyCertificateByEqRequest(themeDisplay, eqRequest);
			EquivalencyAppeal appeal = getAppealByEqDecisionLevelId(themeDisplay, decision.getId());
			String status = "";
			if (Validator.isNotNull(appeal)) {
				status = getStatus(appeal.getStatusID(), themeDisplay);
			}
			logger.info("total time taken setDecisionLevelData ?? " + (System.currentTimeMillis() - startTime));
			return addDetails(documentName, employerName, decision , employeeName, isAppealExist, certificate, status, eqRequest.getId());
		}
		
		public PersonItem getPersonDetailByLrUserId( ThemeDisplay themeDisplay) {
			String personURL =  themeDisplay.getPortalURL() + LRObjectURL.GET_PERSON_BY_ID_URL2  + CommonConstants.SCOPES + StringPool.SLASH + 
					themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId" 
					+URLEncoder.encode(" eq " + themeDisplay.getUserId() , StandardCharsets.UTF_8)+ AppealConstants.PAGE_SIZE ;
		//	String personResponse = omsbCommonApi.getData(personURL);
			String personResponse = oMSBHttpConnector.executeGet(personURL, "", headerUtil.getHeaders());
			PersonItem person = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
			if(Validator.isNotNull(person)&& Validator.isNotNull(person.getItems()) && !person.getItems().isEmpty()) {
			return  CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);
			}
			return null;
			
		}
	  
	public Map<String, String> getColorMap() {
		Map<String, String> statusColorMap =  new HashMap<>();
		statusColorMap.put("Created", "omsb-created-bg");
		statusColorMap.put("Insufficient", "omsb-insufficient-bg"); 
		statusColorMap.put("Raised", "omsb-created-bg"); 
		statusColorMap.put("Initiated", "omsb-initiated-bg");
		statusColorMap.put("Evaluated", "omsb-initiated-bg");    
		statusColorMap.put("Completed", "omsb-completed-bg");
		statusColorMap.put("NA", "omsb-notpass-bg");
		statusColorMap.put("Pending", "omsb-pending-bg");
		statusColorMap.put("Rejected", "omsb-stop-bg");
		statusColorMap.put("In Progress", "omsb-pending-bg");
		statusColorMap.put("Received", "omsb-initiated-bg");
		return statusColorMap;
	}
	
	/**
	 * 
	 * @param transitionName
	 * @param cmd
	 * @param themeDisplay
	 * @param workflowInstance
	 * @param workflowTaskId
	 * @throws PortalException
	 * @return It will assign or complete the workflow based on given condition
	 */
	public void assignOrCompleteWorkflow(String transitionName, String cmd, ThemeDisplay themeDisplay,
			WorkflowInstance workflowInstance, long workflowTaskId) throws PortalException {
		logger.info("transitionName ?? " + transitionName);
		logger.info("cmd ?? " + cmd);
		logger.info("workflowInstance ?? " + workflowInstance.getWorkflowInstanceId());
		logger.info("workflowTaskId ?? " + workflowTaskId);
		/*if (AppealConstants.CMD_ASSIGN_TO_ME.equalsIgnoreCase(cmd)) {*/
		if(!transitionName.equalsIgnoreCase("resubmit")) {
			appealWrokflowUtil.assignWorkflowToUser(themeDisplay, workflowInstance, workflowTaskId);
			logger.info("work flow taskId :::::::::: " + workflowTaskId + "   has assigned to user ::: :: "
					+ themeDisplay.getUserId());
		}
		/* } else if (AppealConstants.CMD_COMPLETE_WORKFLOW.equalsIgnoreCase(cmd)) { */
			logger.info("transition Name " + transitionName);
			appealWrokflowUtil.completeWorkflowTask(themeDisplay, workflowInstance, workflowTaskId, "", transitionName);
		/* } */
	}
	
	public void uploadDocuments(long classPK, ThemeDisplay themeDisplay, PortletRequest portletRequest, long personId,long equivalencyAppealId,long equivalencyAppealStatusId, String inputFileName, String documentType){
		List<DocumentInfo> fileEntries = getUploadedFileEntries(classPK, themeDisplay,
				PortalUtil.getUploadPortletRequest(portletRequest), inputFileName);
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL, themeDisplay.getScopeGroupId());
		String docInfoURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, themeDisplay.getScopeGroupId());
		for (DocumentInfo info: fileEntries) {
			EquivalencyDocumentType eqDocType = addEquivalencyDocumentsType(classPK,equivalencyDocTypeURL, info.getdFFileName(),documentType);
			if (Validator.isNotNull(eqDocType)) {
				addDocumentInfo(classPK, eqDocType.getId(), info.getFileEntryID(),personId, info.getdFFileName(),
						documentType, equivalencyAppealId,equivalencyAppealStatusId, docInfoURL);
			}
		}
	}
	
	public void addDocumentInfo(long equivalencyRequestId, long equivalencyDocTypeId, long fileEntryId,
			long personId, String fileName, String documentType, long equivalencyAppealId,long componentRefId, String docInfoURL){
	logger.info("docInfo insert starts:::::::");

	DocumentInfo docInfo = new DocumentInfo();
	docInfo.setEquivalencyDocTypeId(equivalencyDocTypeId);
	docInfo.setDocumentType(documentType);
	docInfo.setEquivalencyRequestId(equivalencyRequestId);
	docInfo.setdFFileName(fileName);
	docInfo.setFileEntryID(fileEntryId);
	docInfo.setPersonId(personId);
	docInfo.setComponentClassRefId(componentRefId);
	docInfo.setEquivalencyAppealId(equivalencyAppealId);
	logger.info("fileName ??" + fileName);
	String docInfoPayload = CustomObjectMapperUtil.writeValueAsString(docInfo, null);
	logger.info("docInfoPayload in updateEquivalencyDocuments ??" + docInfoPayload);
	omsbHttpConnector.executePost(docInfoURL, docInfoPayload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

	logger.info("docInfo insert successful:::::::");
}
	
	public EquivalencyDocumentType addEquivalencyDocumentsType(long equivalencyRequestId, String equivalencyDocTypeURL, String fileName, String documentType) {
		logger.info("invoking method updateEquivalencyDocuments :::::::");
		try {
			//fileName = FileUtil.stripExtension(fileName);
			logger.info(" newfileName :::::::" + fileName);
			EquivalencyDocumentType documentEqDocType = new EquivalencyDocumentType();
			documentEqDocType.setEquivalencyDocType(documentType);
			documentEqDocType.setEquivalencyRequestId(equivalencyRequestId);
			documentEqDocType.setQualification("");
			String eqDocTypeOtherDocumentPayload = CustomObjectMapperUtil.writeValueAsString(documentEqDocType, null);
			String otherDocumentDocTypeResponse = omsbHttpConnector.executePost(equivalencyDocTypeURL,
					eqDocTypeOtherDocumentPayload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info("EqDocType insert successful:::::::");
			return CustomObjectMapperUtil.readValue(otherDocumentDocTypeResponse, EquivalencyDocumentType.class);
		} catch (Exception e) {
			logger.error("Exception while updating equivalencyDocument Type ::" + e);
		}
		logger.info("invoking method updateEquivalencyDocuments successful:::::::");
		return  null;
	}
	
	public String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	public List<DocumentInfo> getUploadedFileEntries(long equivalencyRequestId, ThemeDisplay themeDisplay, UploadPortletRequest uploadPortletRequest,
			 String inputFileName) {
			List<DocumentInfo> fileEntryList = new ArrayList<>();
			try {
				FileItem[] files = uploadPortletRequest.getMultipartParameterMap().get(inputFileName);
				DLFolder folder =  FileUploadUtil.getDLFolder(themeDisplay.getScopeGroupId(), 0, String.valueOf(equivalencyRequestId));
				if (Validator.isNull(folder)) {
					folder =  FileUploadUtil.createDLFolder(themeDisplay.getScopeGroupId(), String.valueOf(equivalencyRequestId), 0, themeDisplay.getUserId(), StringPool.BLANK);
				}
				if(Validator.isNotNull(files)) {
					for (FileItem file: files) {
						if (Validator.isNotNull(folder)) {
							DocumentInfo info = new DocumentInfo();
							logger.info("folder Id is  :::::::" + folder.getFolderId());
								FileEntry entry = FileUploadUtil.createFileEntry(themeDisplay.getScopeGroupId(), folder.getFolderId(), file.getFileName(), 
										file.getContentType(), StringPool.BLANK, file.getInputStream().readAllBytes());
								if (Validator.isNotNull(entry)) {
									logger.info("fileName is :::: " + file.getFileName() + "  ::::::  fileEntry Id is  :::::::" + entry.getFileEntryId());
								//	String fileName = FileUtil.stripExtension(file.getFileName());
									info.setFileEntryID(entry.getFileEntryId());
									info.setdFFileName(file.getFileName());
									fileEntryList.add(info);
								}
						}
					}
				}
				
			} catch (IOException e) {
				logger.error("Exception while uploading the file::::::" , e);
			}
			logger.info("invoking method updateEqStatusFiles successful:::::::");
			return fileEntryList;
		}
		
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind = "-")
	private AppealWrokflowUtil appealWrokflowUtil;
	
	@Reference(unbind = "-")
	private ListTypeEntryLocalService listTypeEntryLocalService;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private HeaderUtil headerUtil;

	private final Log logger = LogFactoryUtil.getLog(AppealUtil.class);
}
