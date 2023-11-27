package gov.omsb.exam.web.portlet.util;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealItem;
import gov.omsb.exam.web.portlet.dto.ExamAppealStatus;
import gov.omsb.exam.web.portlet.dto.ExamAppealStatusItem;
import gov.omsb.exam.web.portlet.dto.ExamDocuments;
import gov.omsb.exam.web.portlet.dto.ExamDocumentsItem;
import gov.omsb.exam.web.portlet.dto.ExamPayment;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = {}, service = ExamAppealUtil.class)
public class ExamAppealUtil {
	public ExamAppeal getExamAppealById(ThemeDisplay themeDisplay, long appealId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + appealId;
		String response = omsbCommonApi.getData(url);
		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, ExamAppeal.class);
		}
		return null;
	}

	public ExamAppeal updateExamAppealById(ThemeDisplay themeDisplay, long appealId, String payload) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + appealId;
		String response = omsbHttpConnector.executePut(url, payload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, ExamAppeal.class);
		}
		return null;
	}

	public List<ExamDocuments> getExamDocsByStatusId(String url) {
		logger.info("calling getExamAppealDocsByAppeaStatuslId method");
		List<ExamDocuments> documentList = new ArrayList<>();
		String response = omsbCommonApi.getData(url);
		logger.info("document response ??" + response);
		ExamDocumentsItem documents = CustomObjectMapperUtil.readValue(response, ExamDocumentsItem.class);
		if (Validator.isNotNull(documents) && Validator.isNotNull(documents.getItems())
				&& !documents.getItems().isEmpty()) {
			for (ExamDocuments document : documents.getItems()) {
				FileEntry entry = getFileEntryById(document.getFileEntryId());
				if (Validator.isNotNull(entry)) {
					String fileName = getFileNameByFileEntry(entry);
					String fileURL = getFileURLByFileEntry(entry);
					document.setFileName(entry.getDescription());
					document.setFileURL(fileURL);
				}
				logger.info("title ?? " + document.getDocumentTitle());
				logger.info("fileEntryId ?? " + document.getFileEntryId());
				logger.info("fileName ?? " + document.getFileName());
				documentList.add(document);
			}
		}
		logger.info("calling getExamAppealDocsByAppeaStatuslId method ends");
		return documentList;
	}

	public List<ExamAppealStatus> getExamAppealStatusByAppealId(ThemeDisplay themeDisplay, long appealId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_STATUS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examAppealId"
				+ URLEncoder.encode(" eq " + appealId, StandardCharsets.UTF_8);
		String response = omsbCommonApi.getData(url);
		ExamAppealStatusItem statusItems = CustomObjectMapperUtil.readValue(response, ExamAppealStatusItem.class);
		if (Validator.isNotNull(statusItems) && Validator.isNotNull(statusItems.getItems())
				&& !statusItems.getItems().isEmpty()) {
			return statusItems.getItems();
		}
		return new ArrayList<>();
	}

	public FileEntry getFileEntryById(long fileEntryId) {
		try {
			return DLAppLocalServiceUtil.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public String getFileNameByFileEntry(FileEntry fileEntry) {
		String fileName = "";
		if (Validator.isNotNull(fileEntry)) {
			fileName = fileEntry.getFileName();
		}
		return fileName;
	}

	public String getFileURLByFileEntry(FileEntry fileEntry) {
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

	public ExamAppeal getWorkflowData(ThemeDisplay themeDisplay, ExamAppeal appeal) {
		String className = omsbCommonApi.getObjectClassName(OMSBExamWebPortletKeys.EXAM_APPEAL_OBJ_ERC,
				themeDisplay.getCompanyId());
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

	public String getName(long userId) {
		User user = userLocalService.fetchUser(userId);
		if (Validator.isNotNull(user)) {
			return user.getFullName();
		}
		return "NA";
	}

	public void assignOrCompleteWorkflow(String transitionName, String cmd, ThemeDisplay themeDisplay,
			WorkflowInstance workflowInstance, long workflowTaskId) throws PortalException {
		logger.info("transitionName ?? " + transitionName);
		logger.info("cmd ?? " + cmd);
		logger.info("workflowInstance ?? " + workflowInstance.getWorkflowInstanceId());
		logger.info("workflowTaskId ?? " + workflowTaskId);
		if (CommonConstants.CMD_ASSIGN_TO_ME.equalsIgnoreCase(cmd)) {
			CustomWorkflowTaskUtil.assignWorkflowToUser(themeDisplay, workflowInstance, workflowTaskId);
			logger.info("work flow taskId :::::::::: " + workflowTaskId + "   has assigned to user ::: :: "
					+ themeDisplay.getUserId());
		} else {
			logger.info("transition Name " + transitionName);
			CustomWorkflowTaskUtil.completeWorkflowTask(themeDisplay, workflowInstance, workflowTaskId, "",
					transitionName);
		}
	}

	public void completeWorkflow(String transitionName, String cmd, ThemeDisplay themeDisplay,
			WorkflowInstance workflowInstance, long workflowTaskId) throws PortalException {
		logger.info("transitionName ?? " + transitionName);
		logger.info("cmd ?? " + cmd);
		logger.info("workflowInstance ?? " + workflowInstance.getWorkflowInstanceId());
		logger.info("workflowTaskId ?? " + workflowTaskId);
		try {
			CustomWorkflowTaskUtil.assignWorkflowToUser(themeDisplay, workflowInstance, workflowTaskId);
			logger.info("work flow taskId :::::::::: " + workflowTaskId + "   has assigned to user ::: :: "
					+ themeDisplay.getUserId());
			logger.info("transition Name " + transitionName);
			CustomWorkflowTaskUtil.completeWorkflowTask(themeDisplay, workflowInstance, workflowTaskId, "",
					transitionName);

		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
	}

	public long setStatus(String key, long companyId) {
		logger.info("calling set status method...........");
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, key,
				companyId);
		logger.info("entry is ........" + entry);
		if (Validator.isNotNull(entry)) {
			return entry.getListTypeEntryId();
		}
		logger.info("calling set status method. ends..........");
		return 0;
	}

	public String getStatusName(long statusId, ThemeDisplay themeDisplay) {
		ListTypeEntry entry = null;
		String statusName = "NA";
		try {
			entry = listTypeService.getListTypeEntry(statusId);
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

	public String getStatusKey(long statusId) {
		ListTypeEntry entry = null;
		String statusKey = "";
		try {
			entry = listTypeService.getListTypeEntry(statusId);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(entry)) {
			statusKey = entry.getKey();
		}

		return statusKey;
	}

	public long getAppealByAppealId(ThemeDisplay themeDisplay, long appealId) {
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + appealId;
			String response = omsbCommonApi.getData(url);
			ExamAppeal appeal = CustomObjectMapperUtil.readValue(response, ExamAppeal.class);
			if (Validator.isNotNull(appeal) && (appeal.getAppealCount() > 0)) {
				return appeal.getId();

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	public ExamAppealItem getAppealByResultlId(ThemeDisplay themeDisplay, long resultId) {
		ExamAppealItem appeals = new ExamAppealItem();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examResultId"
					+ URLEncoder.encode(" eq " + resultId, StandardCharsets.UTF_8);
			String response = omsbCommonApi.getData(url);
			 appeals = CustomObjectMapperUtil.readValue(response, ExamAppealItem.class);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return appeals;
	}
	
	public ExamAppealStatus getExamAppealStatusByExamAppealId(ThemeDisplay themeDisplay, long appealId) {
		ExamAppealStatus status= new ExamAppealStatus();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_STATUS_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examAppealId"
					+ URLEncoder.encode(" eq " + appealId, StandardCharsets.UTF_8);
			String response = omsbCommonApi.getData(url);
			 status = CustomObjectMapperUtil.readValue(response, ExamAppealStatus.class);
		}catch (Exception e) {
			return null;
		}
		
		return status;
	}

	public JSONObject createExamPayment(ThemeDisplay themeDisplay, long examResultId, double fees, long examAppealStatusId, String feesType) {
		
		try {
			String orderId = generateOrderId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
			String paymentStatus = OMSBExamWebPortletKeys.PENDING;
			long transactionId = new Date().getTime();
			String currency = OMSBExamWebPortletKeys.OMR;
			
			ExamPayment examAppealPayment = prepareExamPayment(themeDisplay.getUserId(), examResultId, examAppealStatusId,
					paymentStatus, orderId, transactionId, fees, feesType);
			examUtil.saveExamPayment(examAppealPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());

			JSONObject responseJson = JSONFactoryUtil.createJSONObject();

			responseJson.put("url", OMSBExamWebPortletKeys.PAYMENT_URL);
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
	
	private String generateOrderId(String portalURL, long scopeGroupId) {

		long max = 1000000000l;
		long min = 9999999999l;
		long range = max - min + 1;
		long rand = (long) (Math.random() * range) + min;
		String orderId = String.valueOf(rand);
		ExamPayment octExamPayment = examUtil.getExamPaymentByOrderId(orderId, portalURL, scopeGroupId);
		if (Validator.isNotNull(octExamPayment)) {
			orderId = generateOrderId(portalURL, scopeGroupId);
		}
		return orderId;
	}
	
	private ExamPayment prepareExamPayment(long applicantId, long scheduleId, long registrationId, String paymentStatus,
			String orderId, long tId, double examFees, String feesType) {
		ExamPayment examPayment = new ExamPayment();
		examPayment.setApplicantId(applicantId);
		examPayment.setScheduleId(scheduleId);
		examPayment.setRegistrationId(registrationId);
		examPayment.setPaymentStatus(paymentStatus);
		examPayment.setOrderId(orderId);
		examPayment.settId(tId);
		examPayment.setPaymentStatus(OMSBExamWebPortletKeys.PENDING);
		examPayment.setCurrency(OMSBExamWebPortletKeys.OMR);
		examPayment.setFees(examFees);
		examPayment.setFeesType(feesType);
		return examPayment;
	}
	
	@Reference
	private UserLocalService userLocalService;

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference
	private ListTypeEntryLocalService listTypeService;
	
	@Reference
	private ExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(ExamAppealUtil.class);
}
