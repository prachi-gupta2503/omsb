package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

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
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatus;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamNotificationUtil;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=/exam/withdrawal_form" }, service = MVCActionCommand.class)
public class SaveExamWithdrawal extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.debug("coming to this class");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String reason = ParamUtil.getString(actionRequest, "comments");
		String jsonData = ParamUtil.getString(actionRequest, "supportingDocJson");
		long examDefinitionId = ParamUtil.getLong(actionRequest, "examDefinitionId");
		long examWithdrawalId = ParamUtil.getLong(actionRequest, "withdrawalId");
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "instanceId");
		//boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String transitionName = ParamUtil.getString(actionRequest, "trName");
		long examScheduleId = ParamUtil.getLong(actionRequest, "examScheduleId");
		long lrUserId = ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.LRUSER_ID);
		String programName = ParamUtil.getString(actionRequest, "programName");
		String examType = ParamUtil.getString(actionRequest, "examType");

		if (lrUserId <= 0) {
			lrUserId = themeDisplay.getUserId();
		}
		logger.debug("comments?? " + reason);
		logger.info("jsonData?? " + jsonData);

		logger.debug("transitionName..." + transitionName);

		Map<String, Serializable> registrationMap = new HashMap<>();
		RegistrationItem registrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(),lrUserId,
						examScheduleId);
		
		List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName)
				.collect(Collectors.toList());
		boolean isAdmin = Boolean.FALSE;
		ExamWithdrawal withdrawal = null;
		ExamWithdrawalStatus status = null;
		//JSONObject notificationPayload = JSONFactoryUtil.createJSONObject();
		long statusId = 0;
		
		if (roleNames.contains(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN)) {
			isAdmin = Boolean.TRUE;
			if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
				statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_ACCEPTED,
						themeDisplay.getCompanyId());
			} else if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
				statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_REJECTED,
						themeDisplay.getCompanyId());
			} else if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_RETURN)) {
				statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_RETURNED,
						themeDisplay.getCompanyId());
			}
		}
		if (examWithdrawalId > 0 && isAdmin) {
			// withdrawal = examSetupUtil.getExamWithdrawalById(themeDisplay,
			// examWithdrawalId);
			JSONObject payload = JSONFactoryUtil.createJSONObject();
			payload.put("withdrawalStatus", statusId);
			withdrawal = updateExamWithdrawalById(themeDisplay, examWithdrawalId, payload.toString());
			
		} else {
			logger.debug("inside save withdrawal data");
			
			statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING,
					themeDisplay.getCompanyId());
			if(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_RESUBMIT.equalsIgnoreCase(transitionName)) {
				 statusId = examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_RESUBMIT,
							themeDisplay.getCompanyId());
				 
			}
			withdrawal = saveWithdrawalData(themeDisplay, statusId, examScheduleId);
			if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())
						&& !registrationItem.getItems().isEmpty()) {
				if(!OMSBExamWebPortletKeys.WITHDRAWN.equalsIgnoreCase(registrationItem.getItems().get(0).getRegistrationStatus())) {
					registrationMap.put(OMSBExamWebPortletKeys.REGISTRATION_STATUS,OMSBExamWebPortletKeys.WITHDRAWN);
					int noOfAttempt=examUtil.getNoOfAttempts(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), examScheduleId, lrUserId);
					registrationMap.put(OMSBExamWebPortletKeys.NO_OF_ATTEMPT, --noOfAttempt);
					omsbCommonApi.updateObjectEntryByERC(OMSBExamWebPortletKeys.OB_EXAM_REGISTRATION_ERC, registrationMap,actionRequest, themeDisplay,registrationItem.getItems().get(0).getId());
					logger.debug("registration id  " + registrationItem.getItems().get(0).getId());
				}
				sendWithdrawNotificationToAdmin(themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());	
		}
		}

		logger.debug("statusId ?? " + statusId);
		if (Validator.isNotNull(withdrawal)) {
			status = saveWithdrawalStatusData(themeDisplay, withdrawal.getId(), reason, statusId, isAdmin);
		}
		if(Validator.isNotNull(jsonData)) {
			
			JSONObject data = JSONFactoryUtil.createJSONObject(jsonData);
			JSONArray array = data.getJSONArray("items");
			for (int index = 0; index < array.length(); index++) {
				JSONObject supportingvalues = array.getJSONObject(index);
				String fileName = supportingvalues.getString("fileName");
				String docTitle = supportingvalues.getString("docTitle");
				String rowNumber = supportingvalues.getString("rowNumber");
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				logger.debug("FILE NAME .... " + fileName);
				if (Validator.isNotNull(fileName)) {
					try {
						File file = uploadRequest.getFile("docInput_" + rowNumber);
						InputStream is = new FileInputStream( file );
						byte[] fileBytes = is.readAllBytes();
						FileEntry entry=	FileUploadUtil.createFileEntry(themeDisplay.getScopeGroupId(), 0, fileName, FileUtil.getExtension(fileName), fileName, fileBytes);
						//FileEntry entry = FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
							//	themeDisplay.getScopeGroupId(), 0);
						if (Validator.isNotNull(entry) && status != null) {
							logger.info("fileName ?? " + entry.getFileEntryId());
							saveWithdrawalDocsData(themeDisplay, docTitle, status.getId(), entry.getFileEntryId());
							logger.info("fileName ?? " + file.getName());
						}
					} catch (Exception exception) {
						logger.error(exception.getMessage(), exception);

					}
				}

				logger.debug("docTitle ?? " + docTitle);

			}
		}
		

		if (roleNames.contains(RoleNameConstants.EXAM_DEPARTNEMT_ADMIN)) {
			if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {

				omsbCommonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), withdrawal.getLrUserId(),
						MVCCommands.EXAM_WITHDRAW_ACCEPT, OMSBExamWebPortletKeys.OMSBEXAMWEB, Boolean.TRUE);
			} else if (transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
				omsbCommonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), withdrawal.getLrUserId(),
						MVCCommands.EXAM_WITHDRAW_REJECT, OMSBExamWebPortletKeys.OMSBEXAMWEB, Boolean.TRUE);
			}else if(transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_RETURN)) {
				omsbCommonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), withdrawal.getLrUserId(),
						MVCCommands.EXAM_WITHDRAW_RETURN, OMSBExamWebPortletKeys.OMSBEXAMWEB, Boolean.TRUE);
			}
		}

		if (isAdmin) {
			if(transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_ACCEPT) || transitionName.equalsIgnoreCase(OMSBExamWebPortletKeys.TRANSITION_NAME_REJECT )){
				
				WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
						.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
				examAppealUtil.completeWorkflow(transitionName, "", themeDisplay, workflowInstance, workflowTaskId);
			}

			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setParameter("mvcRenderCommandName", MVCCommands.VIEW_WITHDRAW_LIST);
			actionResponse.sendRedirect(renderUrl.toString());

		}

	}

	
	private ExamWithdrawal saveWithdrawalData(ThemeDisplay themeDisplay, long statusId, long examScheduleId) {
		ExamWithdrawal examWithdrawal = examUtil.getExamWithdrawalByScheduleIdAndLrUserId(examScheduleId, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),themeDisplay.getUserId());
		if(Validator.isNotNull(examWithdrawal)) {
			JSONObject payload = JSONFactoryUtil.createJSONObject();
			payload.put("withdrawalStatus", statusId);
			updateExamWithdrawalById(themeDisplay, examWithdrawal.getId(), payload.toString());
		}else {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId();
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("examScheduleId", examScheduleId);
			object.put("lrUserId", themeDisplay.getUserId());
			object.put("withdrawalStatus", statusId);
			// set scheduleId here
			String postResponse = omsbHttpConnector.executePost(url, object.toString(),
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			return CustomObjectMapperUtil.readValue(postResponse, ExamWithdrawal.class);
		}
		
		return examWithdrawal;
	}

	private ExamWithdrawalStatus saveWithdrawalStatusData(ThemeDisplay themeDisplay, long withdrawalId, String reason,
			long statusId, boolean isAdmin) {
		/*
		 * ExamWithdrawalStatus examWithdrawalStatus =
		 * examUtil.getExamWithdrawalStatusByWithdrawId(withdrawalId,
		 * themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
		 * if(Validator.isNotNull(examWithdrawalStatus)) {
		 * 
		 * JSONObject payload = JSONFactoryUtil.createJSONObject();
		 * payload.put("withdrawalStatus", statusId); payload.put("examWithdrawalId",
		 * withdrawalId); payload.put("lrUserId", themeDisplay.getUserId());
		 * payload.put("isAdmin", isAdmin); payload.put("reason", reason);
		 * payload.put("withdrawalStatus", statusId);
		 * updateExamWithdrawalStatusByExamWithdrawalId(themeDisplay,
		 * examWithdrawalStatus.getId(), payload.toString()); }else {
		 */
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_STATUS_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId();
			logger.info("url ?? " + url);
			JSONObject object = JSONFactoryUtil.createJSONObject();
			object.put("examWithdrawalId", withdrawalId);
			object.put("lrUserId", themeDisplay.getUserId());
			object.put("isAdmin", isAdmin);
			object.put("reason", reason);
			object.put("withdrawalStatus", statusId);
			String response = omsbHttpConnector.executePost(url, object.toString(),
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			logger.debug("response ?? " + response);
			return CustomObjectMapperUtil.readValue(response, ExamWithdrawalStatus.class);
		
		
		//return examWithdrawalStatus;
		
	}

	private void saveWithdrawalDocsData(ThemeDisplay themeDisplay, String docTitle, long withdrawalStatusId,
			long fileEntryId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_DOCUMENTS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("examWithdrawalStatusId", withdrawalStatusId);
		object.put("documentTitle", docTitle);
		object.put("fileEntryId", fileEntryId);
		String response = omsbHttpConnector.executePost(url, object.toString(),
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.debug("response ?? " + response);
	}

	public ExamWithdrawal updateExamWithdrawalById(ThemeDisplay themeDisplay, long withdrawalId, String payload) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_URL + withdrawalId;
		String response = omsbHttpConnector.executePut(url,payload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, ExamWithdrawal.class);
		}
		return null;
	}

	
	public ExamWithdrawal updateExamWithdrawalStatusByExamWithdrawalId(ThemeDisplay themeDisplay, long withdrawalStatusId, String payload) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_STATUS_URL + withdrawalStatusId;
		String response = omsbHttpConnector.executePut(url,payload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, ExamWithdrawal.class);
		}
		return null;
	}

	private void sendWithdrawNotificationToAdmin(long companyId,long groupId) {
		try {
		Role role = RoleLocalServiceUtil.getRole(companyId, RoleNameConstants.EXAM_DEPARTNEMT_ADMIN);
		if(Validator.isNotNull(role)) {
			long[] userIds = UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
			for(long userId: userIds) {
				omsbCommonApi.sendLRUserNotification(groupId, userId,
						MVCCommands.EXAM_WITHDRAW_NOTIFY_TO_ADMIN, OMSBExamWebPortletKeys.OMSBEXAMWEB, Boolean.TRUE);
			}
			
		}
		
		}catch(Exception e) {
			logger.info(e.getMessage(),e);
		}
		

		
	}

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference
	private ExamAppealUtil examAppealUtil;

	@Reference
	private ExamSetupUtil examSetupUtil;

	@Reference
	private ExamUtil examUtil;

	@Reference
	private ExamNotificationUtil notificationUtil;


	@Reference
	private UserLocalService userLocalService;
	private static final Log logger = LogFactoryUtil.getLog(SaveExamWithdrawal.class);

}
