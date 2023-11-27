package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealStatus;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_APPEAL_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SaveOCTExamAppealMVCResourceCommand implements MVCResourceCommand {

	private static final String EXAM_RESULT_ID = "examResultId";

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("Start Invoking save Exam Appeal doProcessAction method");
		String comments = ParamUtil.getString(resourceRequest, "appealComments");
		double examFees = ParamUtil.getDouble(resourceRequest, "appealFees");
		String jsonData = ParamUtil.getString(resourceRequest, "supportingDocJson");
		long appealId = ParamUtil.getLong(resourceRequest, "appealId");
		long examResultId = ParamUtil.getLong(resourceRequest, EXAM_RESULT_ID);
		long workflowTaskId = ParamUtil.getLong(resourceRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(resourceRequest, "instanceId");
		boolean assignedToMe = ParamUtil.getBoolean(resourceRequest, "assignedToMe");
		String transitionName = ParamUtil.getString(resourceRequest, "trName");
		double percentage = ParamUtil.getDouble(resourceRequest, "percentage");
		String result = ParamUtil.getString(resourceRequest, "result");
		logger.debug("comments?? " + comments);
		logger.debug("jsonData?? " + jsonData);
		logger.debug("trName?? " + transitionName);
		logger.debug("instanceId?? " + instanceId);
		logger.debug("wf task id?? " + workflowTaskId);
		logger.debug("percentage?? " + percentage);
		logger.debug("result?? " + result);
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());
		boolean isAdmin = Boolean.FALSE;
		//OCTExamAppeal examAppeal = null;
		long statusId = 0;

		// assign me logic starts
		if (instanceId > 0) {
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			try {
				WorkflowInstance workflowInstanceForAssignMe = WorkflowInstanceManagerUtil
						.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
				if (Validator.isNotNull(workflowInstanceForAssignMe)) {
					logger.info("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
							+ " :: assignedToMe :: " + assignedToMe);
					cmd = CommonConstants.CMD_ASSIGN_TO_ME;
					octExamAppealUtil.assignOrCompleteWorkflow("", cmd, themeDisplay, workflowInstanceForAssignMe,
							workflowTaskId);
					assignedToMe = false;
				}
			} catch (WorkflowException e) {
				logger.error("Error while saving assign to me workflow : "+e.getMessage());
				logger.error(e);
			}
		}
		// ends

		if (roleNames.contains(RoleNameConstants.OCT_APPEAL_BODY)) {
			isAdmin = Boolean.TRUE;
			if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
				statusId = examAppealUtil.setStatus(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_STATUS_OBJECT_ERC,
						OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_ACCEPTED, themeDisplay.getCompanyId());
			} else if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
				statusId = examAppealUtil.setStatus(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_STATUS_OBJECT_ERC,
						OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_REJECTED, themeDisplay.getCompanyId());
			}
		}
		logger.info("statusId while saving appeal object " + statusId);
		OCTExamAppealStatus octExamAppealStatus = null;
		JSONObject examPaymentObject = null;
		if (appealId > 0 && isAdmin) {
			// examAppeal = examAppealUtil.getExamAppealById(themeDisplay, appealId);
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("appealStatus", statusId);
			examAppealUtil.updateExamAppealById(themeDisplay, appealId, object.toString());
			updateExamResultData(themeDisplay, examResultId, result, percentage);
		} else {
			statusId = examAppealUtil.setStatus(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_STATUS_OBJECT_ERC,
					OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId());
			//examAppeal = saveAppealData(themeDisplay, examResultId, statusId);
			octExamAppealStatus = saveAppealStatusData(themeDisplay, 0, comments, statusId, isAdmin);
			examPaymentObject = octExamAppealUtil.createExamPayment(themeDisplay, examResultId, examFees, octExamAppealStatus.getId(), OmsbOctExamWebPortletKeys.FEES_TYPE_OCT_EXAM_APPEAL);
		}

		if (!assignedToMe && isAdmin) {
			try {
				WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
						.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
				examAppealUtil.assignOrCompleteWorkflow(transitionName, "", themeDisplay, workflowInstance, workflowTaskId);
			} catch (WorkflowException e) {
				logger.error("Error while complete workflow : "+e.getMessage());
				logger.error(e);
			}
		}
		
		if (Validator.isNotNull(octExamAppealStatus)) {
			try {
				JSONObject appealData = JSONFactoryUtil.createJSONObject(jsonData);
				JSONArray array = appealData.getJSONArray("items");
				for (int index = 0; index < array.length(); index++) {
					JSONObject supportingvalues = array.getJSONObject(index);
					String fileName = supportingvalues.getString("fileName");
					String docTitle = supportingvalues.getString("docTitle");
					String rowNumber = supportingvalues.getString("rowNumber");
					UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
					File file = uploadRequest.getFile("docInput_" + rowNumber);
					FileEntry entry = FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
							themeDisplay.getScopeGroupId(), 0);
					if (Validator.isNotNull(entry)) {
						logger.info("fileName ?? " + entry.getFileEntryId());
						saveAppealDocsData(themeDisplay, docTitle, octExamAppealStatus.getId(), entry.getFileEntryId());
					}
				} //check here
			} catch (JSONException e) {
				logger.error("Error while convert string to json : "+e.getMessage());
				logger.error(e);
			}
		}
		logger.info("Invoked save Exam Appeal doProcessAction method successful");
		
		try {
			PrintWriter out = resourceResponse.getWriter();
			out.println(examPaymentObject);
		} catch (IOException e) {
			logger.error("error while setting PrintWriter :" + e.getLocalizedMessage());
			logger.debug(e);
		}
		return false;
	}

	private OCTExamAppeal saveAppealData(ThemeDisplay themeDisplay, long examResultId, long statusId) {
		try {
		OCTExamAppeal appeal = examUtil.getExamAppealByExamResultId(themeDisplay, examResultId);
		logger.info("appeal object after getExamAppealByExamResultId " + appeal);
		/*
		 * String getUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL +
		 * CommonConstants.SCOPES+StringPool.SLASH + themeDisplay.getScopeGroupId() +
		 * StringPool.QUESTION + "filter=" + EXAM_RESULT_ID + URLEncoder.encode(" eq " +
		 * examResultId, StandardCharsets.UTF_8);
		 * 
		 * String appealResponse = omsbCommonApi.getData(getUrl); if
		 * (appealResponse.contains(EXAM_RESULT_ID)) { ExamAppealItem appealItem =
		 * CustomObjectMapperUtil.readValue(appealResponse, ExamAppealItem.class); if
		 * (Validator.isNotNull(appealItem) &&
		 * Validator.isNotNull(appealItem.getItems()) &&
		 * !appealItem.getItems().isEmpty()) { appeal = appealItem.getItems().get(0);
		 * int appealCount = appeal.getAppealCount() + 1; JSONObject object =
		 * JSONFactoryUtil.createJSONObject(); object.put("appealCount", appealCount);
		 * appeal = examAppealUtil.updateExamAppealById(themeDisplay, appeal.getId(),
		 * object.toString()); } } else {
		 */
		if (Validator.isNotNull(appeal)) {
			int appealCount = appeal.getAppealCount() + 1;
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("appealCount", appealCount);
			appeal = examAppealUtil.updateExamAppealById(themeDisplay, appeal.getId(), object.toString());
		} else {
			logger.info("creating new appeal ");
			String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId();
			logger.info("appeal url::"+url);
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put(EXAM_RESULT_ID, examResultId);
			object.put("lrUserId", themeDisplay.getUserId());
			object.put("appealCount", 1);
			object.put("appealStatus", statusId);
			logger.info("object::"+object.toString());
			String response = omsbHttpConnector.executePost(url, object.toString(),
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info("appeal response::"+response);
			if (Validator.isNotNull(response)) {
				appeal = CustomObjectMapperUtil.readValue(response, OCTExamAppeal.class);
			}
		}
		logger.info("appeal object after creating appeal data " + appeal);
		return appeal;
	}catch (Exception e) {
		logger.error(e);
	}
		return null;
	}

	private OCTExamAppealStatus saveAppealStatusData(ThemeDisplay themeDisplay, long appealId, String reason,
			long statusId, boolean isAdmin) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_STATUS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		logger.info("url ?? " + url);
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("oCExamAppealId", appealId);
		object.put("lrUserId", themeDisplay.getUserId());
		object.put("isAdmin", isAdmin);
		object.put("reason", reason);
		object.put("appealStatus", statusId);
		object.put("creator", themeDisplay.getUser().getFullName());
		String response = omsbHttpConnector.executePost(url, object.toString(),
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response ?? " + response);
		return CustomObjectMapperUtil.readValue(response, OCTExamAppealStatus.class);
	}

	private void saveAppealDocsData(ThemeDisplay themeDisplay, String docTitle, long appealId, long fileEntryId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_DOCUMENTS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("oCExamAppealStatusId", appealId);
		object.put("docTitle", docTitle);
		object.put("fileEntryId", fileEntryId);
		String response = omsbHttpConnector.executePost(url, object.toString(),
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response ?? " + response);
	}

	private void updateExamResultData(ThemeDisplay themeDisplay, long examResultId, String result, double percentage) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULT_URL + examResultId;
		JSONObject resultObject = JSONFactoryUtil.createJSONObject();
		resultObject.put("result", result);
		resultObject.put("percentage", percentage);
		omsbHttpConnector.executePut(url, resultObject.toString(), omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

	}

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OCTExamAppealUtil examAppealUtil;

	@Reference
	private OCTExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(SaveOCTExamAppealMVCResourceCommand.class);

	@Reference
	private OCTExamAppealUtil octExamAppealUtil;

}
