package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
		"mvc.command.name=" + MVCCommandNames.OCT_EXAM_APPEAL_FORM }, service = MVCActionCommand.class)
public class SaveOCTExamAppeal extends BaseMVCActionCommand {

	private static final String EXAM_RESULT_ID = "examResultId";

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("Start Invoking save Exam Appeal doProcessAction method");
		String comments = ParamUtil.getString(actionRequest, "appealComments");
		String jsonData = ParamUtil.getString(actionRequest, "supportingDocJson");
		long appealId = ParamUtil.getLong(actionRequest, "appealId");
		long examResultId = ParamUtil.getLong(actionRequest, EXAM_RESULT_ID);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "instanceId");
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String transitionName = ParamUtil.getString(actionRequest, "trName");
		double percentage = ParamUtil.getDouble(actionRequest, "percentage");
		String result = ParamUtil.getString(actionRequest, "result");
		logger.info("comments?? " + comments);
		logger.info("jsonData?? " + jsonData);
		logger.info("trName?? " + transitionName);
		logger.info("instanceId?? " + instanceId);
		logger.info("wf task id?? " + workflowTaskId);
		logger.info("percentage?? " + percentage);
		logger.info("result?? " + result);
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());
		boolean isAdmin = Boolean.FALSE;
		OCTExamAppeal examAppeal = null;
		long statusId = 0;

		// assign me logic starts
		if (instanceId > 0) {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
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
		}
		// ends

		if (roleNames.contains(RoleNameConstants.OCT_APPEAL_BODY)) {
			isAdmin = Boolean.TRUE;
			if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
				logger.info("inside accept condition");
				statusId = examAppealUtil.setStatus(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_STATUS_OBJECT_ERC,
						OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_ACCEPTED, themeDisplay.getCompanyId());
			} else if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
				logger.info("inside reject condition");

				statusId = examAppealUtil.setStatus(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_STATUS_OBJECT_ERC,
						OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_REJECTED, themeDisplay.getCompanyId());
			}
		}
		logger.info("statusId while saving appeal object " + statusId);
		if (appealId > 0 && isAdmin) {
			// examAppeal = examAppealUtil.getExamAppealById(themeDisplay, appealId);
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("appealStatus", statusId);
			examAppeal = examAppealUtil.updateExamAppealById(themeDisplay, appealId, object.toString());
			updateExamResultData(themeDisplay, examResultId, result, percentage);
		} else {
			statusId = examAppealUtil.setStatus(OmsbOctExamWebPortletKeys.OC_EXAM_APPEAL_STATUS_OBJECT_ERC,
					OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId());
			examAppeal = saveAppealData(themeDisplay, examResultId, statusId);
		}

		if (!assignedToMe && isAdmin) {
			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
					.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			examAppealUtil.assignOrCompleteWorkflow(transitionName, "", themeDisplay, workflowInstance, workflowTaskId);
		}
		OCTExamAppealStatus status = null;
		if (Validator.isNotNull(examAppeal)) {
			status = saveAppealStatusData(themeDisplay, examAppeal.getId(), comments, statusId, isAdmin);
		}

		if (Validator.isNotNull(status)) {
			JSONObject appealData = JSONFactoryUtil.createJSONObject(jsonData);
			JSONArray array = appealData.getJSONArray("items");
			for (int index = 0; index < array.length(); index++) {
				JSONObject supportingvalues = array.getJSONObject(index);
				String fileName = supportingvalues.getString("fileName");
				String docTitle = supportingvalues.getString("docTitle");
				String rowNumber = supportingvalues.getString("rowNumber");
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				File file = uploadRequest.getFile("docInput_" + rowNumber);
				FileEntry entry = FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
						themeDisplay.getScopeGroupId(), 0);
				if (Validator.isNotNull(entry) && status != null) {
					logger.info("fileName ?? " + entry.getFileEntryId());
					saveAppealDocsData(themeDisplay, docTitle, status.getId(), entry.getFileEntryId());
				}
			}
		}

		logger.info("Invoked save Exam Appeal doProcessAction method successful");
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

	private static final Log logger = LogFactoryUtil.getLog(SaveOCTExamAppeal.class);

	@Reference
	private OCTExamAppealUtil octExamAppealUtil;

}
