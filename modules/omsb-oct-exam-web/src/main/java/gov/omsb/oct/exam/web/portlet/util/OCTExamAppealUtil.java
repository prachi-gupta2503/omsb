package gov.omsb.oct.exam.web.portlet.util;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealStatus;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealStatusItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDocuments;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDocumentsItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;

@Component(immediate = true, property = {}, service = OCTExamAppealUtil.class)
public class OCTExamAppealUtil {

	public long setStatus(String listName, String key, long companyId) {
		logger.info("calling set status method...........");
		ListTypeDefinition listTypeDefition;
		try {
			listTypeDefition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(listName, companyId);
			if (Validator.isNotNull(listTypeDefition)) {
				ListTypeEntry entry = ListTypeEntryLocalServiceUtil
						.getListTypeEntry(listTypeDefition.getListTypeDefinitionId(), key);
				logger.info("entry is ........" + entry);
				if (Validator.isNotNull(entry)) {
					return entry.getListTypeEntryId();
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		logger.info("calling set status method. ends..........");
		return 0;
	}

	public ObjectEntry saveObjectData(String objectERC, Map<String, Serializable> valuesMap,
			ThemeDisplay themeDisplay) {

		ObjectEntry objectEntry = null;

		try {
			ObjectDefinition objectDefinition = ObjectDefinitionLocalServiceUtil
					.getObjectDefinitionByExternalReferenceCode(objectERC, themeDisplay.getCompanyId());
			logger.info("objectDefinition  " + objectDefinition);

			if (Validator.isNotNull(objectDefinition)) {
				objectEntry = ObjectEntryLocalServiceUtil.addObjectEntry(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), objectDefinition.getObjectDefinitionId(), valuesMap,
						new ServiceContext());

			}
			logger.info("objectEntry ?? " + objectEntry);
		} catch (PortalException e) {
			logger.error(e);
		}
		return objectEntry;
	}


	public String getName(long lrUserId) {
		
		logger.info("-----getName method");
		User user = userLocalService.fetchUser(lrUserId);
		if (Validator.isNotNull(user)) {
			return user.getFullName();
		}
		return "NA";
	}
	
	public OCTExamAppeal updateExamAppealById(ThemeDisplay themeDisplay, long appealId, String payload) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + appealId;
		String response = omsbHttpConnector.executePut(url, payload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, OCTExamAppeal.class);
		}
		return null;
	}
	

	public OCTExamAppeal getWorkflowData(ThemeDisplay themeDisplay, OCTExamAppeal appeal) {
		String className = getObjectClassName(themeDisplay.getCompanyId());
		boolean assignedToRole = false;
		long workflowTaskId = 0;
		long workflowInstanceId = 0;
		try {
			WorkflowInstance instance = CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay,
					appeal.getId());
			if (Validator.isNotNull(instance)) {
				workflowInstanceId = instance.getWorkflowInstanceId();
			}
			List<WorkflowLog> logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
			if (!logs.isEmpty()) {
				long assigneeRoleId = CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs);
				assignedToRole = CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay, assigneeRoleId);
				workflowTaskId = CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs);
			}
			List<String> transitionNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
			appeal.setAssignedToMe(assignedToRole);
			appeal.setWorkflowInstanceId(workflowInstanceId);
			appeal.setWorkflowTaskId(workflowTaskId);
			appeal.setTransitionNames(transitionNames);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return appeal;
	}

	private String getObjectClassName(long companyId) {
		ObjectDefinition definition = null;
		try {
			definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_OBJECT_ERC,
					companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public String getStatusName(long appealStatus, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = null;
		String statusName = "NA";
		try {
			entry = listTypeService.getListTypeEntry(appealStatus);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(entry) && Validator.isNotNull(themeDisplay)) {
			statusName = entry.getName(themeDisplay.getLocale());
		} else if (Validator.isNotNull(entry) && Validator.isNull(themeDisplay)) {
			statusName = entry.getName();
		}

		return statusName;
	}

	public void assignOrCompleteWorkflow(String tName, String cmd, ThemeDisplay themeDisplay,
			WorkflowInstance workflowInstance, long workflowTaskId) {
		logger.info("transitionName ?? " + tName);
		logger.info("cmd ?? " + cmd);
		logger.info("workflowInstance ?? " + workflowInstance.getWorkflowInstanceId());
		logger.info("workflowTaskId ?? " + workflowTaskId);
		if (CommonConstants.CMD_ASSIGN_TO_ME.equalsIgnoreCase(cmd)) {
			CustomWorkflowTaskUtil.assignWorkflowToUser(themeDisplay, workflowInstance, workflowTaskId);
			logger.info("work flow taskId :::::::::: " + workflowTaskId + "   has assigned to user ::: :: "
					+ themeDisplay.getUserId());
		} else {
			logger.info("transition Name " + tName);
			CustomWorkflowTaskUtil.completeWorkflowTask(themeDisplay, workflowInstance, workflowTaskId, "", tName);
		}
	}
	
	
	public List<OCTExamAppealStatus> getExamAppealStatusByAppealId(ThemeDisplay themeDisplay, long appealId) {
		
		logger.info("------getExamAppealStatusByAppealId----");
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_STATUS_URL +  CommonConstants.SCOPES + 
				StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION +
				"filter=oCExamAppealId" +  URLEncoder.encode(" eq " + appealId, StandardCharsets.UTF_8)+ "&pageSize=0";
		logger.info("url == " + url);
		String response = omsbCommonApi.getData(url);
		logger.info("------getExamAppealStatusByAppealId----"+response);

		OCTExamAppealStatusItem statusItems = CustomObjectMapperUtil.readValue(response, OCTExamAppealStatusItem.class);
		if (Validator.isNotNull(statusItems) && Validator.isNotNull(statusItems.getItems()) && !statusItems.getItems().isEmpty()) {
			return statusItems.getItems();
		}
		return new ArrayList<>();
	}
	public List<OCTExamDocuments> getExamDocsByStatusId(String url) {
		logger.info("calling getExamAppealDocsByAppeaStatuslId method");
		List<OCTExamDocuments> documentList = new ArrayList<>();
		String response = omsbCommonApi.getData(url);
		logger.info("document response ??" + response);
		OCTExamDocumentsItem documents =  CustomObjectMapperUtil.readValue(response, OCTExamDocumentsItem.class);
		if (Validator.isNotNull(documents) && Validator.isNotNull(documents.getItems()) && !documents.getItems().isEmpty()) {
			for (OCTExamDocuments document : documents.getItems()) {
				FileEntry entry = getFileEntryById(document.getFileEntryId());
				if (Validator.isNotNull(entry)) {
					String fileName = getFileNameByFileEntry(entry);
					String fileURL = getFileURLByFileEntry(entry);
					document.setFileName(fileName);
					document.setFileURL(fileURL);
				}
				logger.info("title ?? " + document.getDocTitle());
				logger.info("fileEntryId ?? " + document.getFileEntryId());
				logger.info("fileName ?? " + document.getFileName());
				documentList.add(document);
			}
		}
		logger.info("calling getExamAppealDocsByAppeaStatuslId method ends"+documentList.size());
		return documentList;
	}
	
	private String getFileURLByFileEntry(FileEntry fileEntry) {
		String fileURL = "";
		if (Validator.isNotNull(fileEntry)) {
			try {
				fileURL = DLURLHelperUtil.getDownloadURL(fileEntry, fileEntry.getFileVersion(), null, "");
			} catch (PortalException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return fileURL;
	}

	private String getFileNameByFileEntry(FileEntry fileEntry) {
		String fileName = "";
		if (Validator.isNotNull(fileEntry)) {
			fileName = fileEntry.getFileName();
		}
		return fileName;
	}

	private FileEntry getFileEntryById(long fileEntryId) {
		try {
			return DLAppLocalServiceUtil.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public OCTExamAppeal getExamAppealById(ThemeDisplay themeDisplay, long appealId) {
		
		logger.info("-----getExamAppealById-----");
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + appealId;
		String response = omsbCommonApi.getData(url);
		
		logger.info("-----getExamAppealById response-----"+response);

		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, OCTExamAppeal.class);
		}
		return null;
	}
	
	public OCTExamAppealItem getAppealByResultlId(ThemeDisplay themeDisplay, long resultId) {
		OCTExamAppealItem appeals = new OCTExamAppealItem();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examResultId"
					+ URLEncoder.encode(" eq " + resultId, StandardCharsets.UTF_8);
			String response = omsbCommonApi.getData(url);
			 appeals = CustomObjectMapperUtil.readValue(response, OCTExamAppealItem.class);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return appeals;
	}
	
	public String getStatusKey(long appealStatus) {
		ListTypeEntry entry = null;
		String statusKey = "";
		logger.info("appealStatus  " + appealStatus);
		try {
			entry = listTypeService.getListTypeEntry(appealStatus);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("statusKey entry " + entry);
		if (Validator.isNotNull(entry)) {
			statusKey = entry.getKey();
		} 
		logger.info("statusKey   " + statusKey);
		return statusKey;
	}

	public List<OCTExamAppeal> getAllAppealList(ThemeDisplay themeDisplay) {
		List<OCTExamAppeal> examAppeals = new ArrayList<>();
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
		String response = omsbCommonApi.getData(url);

		logger.info("response of List ?? " + response);
		OCTExamAppealItem appeals = CustomObjectMapperUtil.readValue(response, OCTExamAppealItem.class);
		if (Validator.isNotNull(appeals) && Validator.isNotNull(appeals.getItems()) && !appeals.getItems().isEmpty()) {
			for (OCTExamAppeal appeal : appeals.getItems()) {
				appeal.setTraineeName(getName(appeal.getLrUserId()));
				appeal = getWorkflowData(themeDisplay, appeal);
				long appealStatus = appeal.getAppealStatus();
				
				appeal.setAppealStatusValue(getStatusName(appealStatus, themeDisplay));
				appeal = setAdditionalAppeal(appeal, themeDisplay);
				if(appeal.getAppealCount() > 0) {
					if(appeal.getAppealCount() == 1) {
						appeal.setStatusColor(octExamUtil.getAppealStatusColor(true,appealStatus));
					} else {
						appeal.setStatusColor(octExamUtil.getAppealStatusColor(false,appealStatus));
					}
				}
				
				logger.info("appeal  " + appeal.toString());
				examAppeals.add(appeal);
			}
		}
		return examAppeals;
	}
	
	private OCTExamAppeal setAdditionalAppeal(OCTExamAppeal appeal, ThemeDisplay themeDisplay) {
		OCTExamResultItem examResult = null;
		OCTExamDefinitionItem exam = null;
		if (Validator.isNotNull(appeal)) {
			examResult = octExamUtil.getExamResultById(appeal.getExamResultId(), themeDisplay);
		}
		if (Validator.isNotNull(examResult)) {
			appeal.setResult(examResult.getResult());
			appeal.setPercentage(examResult.getPercentage());
			exam = octScheduleUtil.getExamDefinitionById(themeDisplay, examResult.getoCExamDefinitionId());
		}
		if (Validator.isNotNull(exam)) {
			logger.info("exam.getProgram() ?? " + exam.getProgramId());
			appeal.setExamType(octExamUtil.getExamType(exam.getExamTypeId(), themeDisplay.getPortalURL()));
		}
		return appeal;
	}
	
	public JSONObject createExamPayment(ThemeDisplay themeDisplay, long examResultId, double fees, long examAppealStatusId, String feesType) {
		
		try {
			String orderId = generateOrderId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
			String paymentStatus = OmsbOctExamWebPortletKeys.PENDING;
			long transactionId = new Date().getTime();
			String currency = OmsbOctExamWebPortletKeys.OMR;
			
			OCTExamPayment examAppealPayment = prepareExamPayment(themeDisplay.getUserId(), examResultId, examAppealStatusId,
					paymentStatus, orderId, transactionId, fees, feesType);
			octExamUtil.saveOCTExamPayment(examAppealPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());

			JSONObject responseJson = JSONFactoryUtil.createJSONObject();

			responseJson.put("url", OmsbOctExamWebPortletKeys.PAYMENT_URL);
			responseJson.put("transactionId", transactionId);
			responseJson.put("lrUserId", themeDisplay.getUserId());
			responseJson.put("examScheduleId", examResultId);
			responseJson.put("registrationId", examAppealStatusId);
			responseJson.put("orderId", orderId);
			responseJson.put("paymentStatus", paymentStatus);
			responseJson.put("fees", fees);
			responseJson.put("currency", currency);
			responseJson.put("makePayement", Boolean.TRUE);
			return responseJson;
		} catch (Exception e) {
			logger.error("Error while creating Exam Payment :" + e.getMessage(), e);
		}
		return null;
	}
	
	private OCTExamPayment prepareExamPayment(long applicantId, long scheduleId, long registrationId, String paymentStatus,
			String orderId, long tId, double examFees, String feesType) {
		OCTExamPayment examPayment = new OCTExamPayment();
		examPayment.setApplicantId(applicantId);
		examPayment.setScheduleId(scheduleId);
		examPayment.setRegistrationId(registrationId);
		examPayment.setPaymentStatus(paymentStatus);
		examPayment.setOrderId(orderId);
		examPayment.settId(tId);
		examPayment.setPaymentStatus(OmsbOctExamWebPortletKeys.PENDING);
		examPayment.setCurrency(OmsbOctExamWebPortletKeys.OMR);
		examPayment.setFees(examFees);
		examPayment.setFeesType(feesType);
		return examPayment;
	}
	
	private String generateOrderId(String portalURL, long scopeGroupId) {

		long max = 1000000000l;
		long min = 9999999999l;
		long range = max - min + 1;
		long rand = (long) (Math.random() * range) + min;
		String orderId = String.valueOf(rand);
		OCTExamPayment octExamPayment = octExamUtil.getOCTExamPaymentByOrderId(orderId, portalURL, scopeGroupId);
		if (Validator.isNotNull(octExamPayment)) {
			orderId = generateOrderId(portalURL, scopeGroupId);
		}
		return orderId;
	}

	@Reference
	private OCTScheduleUtil octScheduleUtil;
	
	@Reference
	private ListTypeEntryLocalService listTypeService;

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private OCTExamUtil octExamUtil;
	
	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	private static final Log logger = LogFactoryUtil.getLog(OCTExamAppealUtil.class);
}
