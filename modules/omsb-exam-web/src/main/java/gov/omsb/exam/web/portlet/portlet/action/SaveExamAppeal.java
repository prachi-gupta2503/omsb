
package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.io.File;
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
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealStatus;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=/exam/appeal_form" }, service = MVCActionCommand.class)
public class SaveExamAppeal extends BaseMVCActionCommand {

	private static final String EXAM_RESULT_ID = "examResultId";

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			logger.debug("Start Invoking save Exam Appeal doProcessAction method");
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
			ExamAppeal examAppeal = null;
			long statusId = 0;

			if (roleNames.contains(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN)) {
				isAdmin = Boolean.TRUE;
				if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
					statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_ACCEPTED,
							themeDisplay.getCompanyId());
				} else if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
					statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_REJECTED,
							themeDisplay.getCompanyId());
				}
			}
			if (appealId > 0 && isAdmin) {
				// examAppeal = examAppealUtil.getExamAppealById(themeDisplay, appealId);
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("appealStatus", statusId);
				examAppeal = examAppealUtil.updateExamAppealById(themeDisplay, appealId, object.toString());
				if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
					updateExamResultData(themeDisplay, examResultId, result, percentage);
				}
			} else {
				statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING,
						themeDisplay.getCompanyId());
				examAppeal = saveAppealData(themeDisplay, examResultId, statusId);
			}

			if (!assignedToMe && isAdmin) {
				WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
						.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
				examAppealUtil.assignOrCompleteWorkflow(transitionName, "", themeDisplay, workflowInstance,
						workflowTaskId);
			}
			ExamAppealStatus status = null;
			if (Validator.isNotNull(examAppeal)) {
				status = saveAppealStatusData(themeDisplay, examAppeal.getId(), comments, statusId, isAdmin);
			}

			JSONObject appealData = JSONFactoryUtil.createJSONObject(jsonData);
			JSONArray array = appealData.getJSONArray("items");
			for (int index = 0; index < array.length(); index++) {
				JSONObject supportingvalues = array.getJSONObject(index);
				String fileName = supportingvalues.getString("fileName");
				String docTitle = supportingvalues.getString("docTitle");
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				File file = uploadRequest.getFile(fileName);
				FileEntry entry = FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
						themeDisplay.getScopeGroupId(), 0);
				if (Validator.isNotNull(entry) && status != null) {
					logger.debug("fileName ?? " + entry.getFileEntryId());
					saveAppealDocsData(themeDisplay, docTitle, status.getId(), entry.getFileEntryId());
				}
			}

			// Send Notidication to User
			if (roleNames.contains(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN)) {
				if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
					omsbCommonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), examAppeal.getLrUserId(),
							OMSBExamWebPortletKeys.APPEAL_REQUEST_APPROVE_USER_NOTIFICATION_TEMPLATE,
							OMSBExamWebPortletKeys.OMSBEXAMWEB, Boolean.TRUE);
				} else if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
					omsbCommonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), examAppeal.getLrUserId(),
							OMSBExamWebPortletKeys.APPEAL_REQUEST_REJECT_USER_NOTIFICATION_TEMPLATE,
							OMSBExamWebPortletKeys.OMSBEXAMWEB, Boolean.TRUE);
				}
			}
//			actionResponse.getRenderParameters().setValue("examResultId", String.valueOf(examResultId));
//			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_RESULTS_LIST);
			SessionMessages.add(actionRequest, OMSBExamWebPortletKeys.APPEAL_REQUEST_SUCCESS);

		} catch (Exception e) {
			SessionErrors.add(actionRequest, OMSBExamWebPortletKeys.APPEAL_REQUEST_FAILURE);
		}
		logger.debug("Invoked save Exam Appeal doProcessAction method successful");
	}

	private ExamAppeal saveAppealData(ThemeDisplay themeDisplay, long examResultId, long statusId) {
		ExamAppeal appeal = examUtil.getExamAppealByExamResultId(themeDisplay, examResultId);
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
			object.put("appealStatus", statusId);
			appeal = examAppealUtil.updateExamAppealById(themeDisplay, appeal.getId(), object.toString());
		} else {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId();
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put(EXAM_RESULT_ID, examResultId);
			object.put("lrUserId", themeDisplay.getUserId());
			object.put("appealCount", 1);
			object.put("appealStatus", statusId);
			String response = omsbHttpConnector.executePost(url, object.toString(),
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			appeal = CustomObjectMapperUtil.readValue(response, ExamAppeal.class);
		}
		return appeal;
	}

	private ExamAppealStatus saveAppealStatusData(ThemeDisplay themeDisplay, long appealId, String reason,
			long statusId, boolean admin) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_STATUS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		logger.debug("url ?? " + url);
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("examAppealId", appealId);
		object.put("lrUserId", themeDisplay.getUserId());
		object.put("admin", admin);
		object.put("reason", reason);
		object.put("appealStatus", statusId);
		object.put("creator", themeDisplay.getUser().getFullName());
		String response = omsbHttpConnector.executePost(url, object.toString(),
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.debug("response ?? " + response);
		return CustomObjectMapperUtil.readValue(response, ExamAppealStatus.class);
	}

	private void saveAppealDocsData(ThemeDisplay themeDisplay, String docTitle, long appealId, long fileEntryId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_DOCUMENTS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("examAppealStatusId", appealId);
		object.put("documentTitle", docTitle);
		object.put("fileEntryId", fileEntryId);
		String response = omsbHttpConnector.executePost(url, object.toString(),
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.debug("response ?? " + response);
	}

	private void updateExamResultData(ThemeDisplay themeDisplay, long examResultId, String result, double percentage) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + examResultId;
		JSONObject resultObject = JSONFactoryUtil.createJSONObject();
		resultObject.put("result", result);
		resultObject.put("percentage", percentage);
		omsbHttpConnector.executePut(url, resultObject.toString(), omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

	}

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference
	private ExamAppealUtil examAppealUtil;

	@Reference
	private ExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(SaveExamAppeal.class);
}
