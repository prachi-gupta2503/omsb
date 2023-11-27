package omsb.vehpc.appeal.mvc.commands.action;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.EDIT_APPEAL_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class EditAppealMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("ACtion MVC Commnad is Started=======");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		long appealId = ParamUtil.getLong(actionRequest, "appealId");
		String supportingDocs = ParamUtil.getString(actionRequest, "supportingDocsAndType");

		logger.info("equivalencyRequestId -------------------------" + equivalencyRequestId);

		long personId = 0;
		try {
			String equivalencyUrl = themeDisplay.getPortalURL() + AppealConstants.REQUEST_URL + equivalencyRequestId;
			String equivalencyResponse = omsbHttpConnector.executeGet(equivalencyUrl, "", headerUtil.getHeaders());
			EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(equivalencyResponse,
					EquivalencyRequest.class);
			if (Validator.isNotNull(equivalencyRequest)) {
				personId = equivalencyRequest.getPersonId();
			}

			DLFolder folder = appealUtil.createFolderStructure(themeDisplay.getScopeGroupId(), personId, themeDisplay);

			JSONObject appealDocsData = null;
			JSONArray appealSupportingDocuments = null;
			if (Validator.isNotNull(supportingDocs)) {
				appealDocsData = JSONFactoryUtil.createJSONObject(supportingDocs);
				appealSupportingDocuments = appealDocsData.getJSONArray("appealSupportingDocuments");

				for (int index = 0; index < appealSupportingDocuments.length(); index++) {
					JSONObject supportingvalues = appealSupportingDocuments.getJSONObject(index);
					Object optionValues = supportingvalues.get("optionvalue");
					Object documentValues = supportingvalues.get("documentInputValue");
					String optionValue = optionValues.toString();
					logger.info("this is the option value whihc is type  name " + optionValue);
					String documentName = documentValues.toString();
					logger.info("this is the doucment name " + documentName);

					String fileName = uploadPortletRequest.getFileName(documentName);

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

					// Get the current timestamp
					String timestamp = dateFormat.format(new Date());

					// Prepend the timestamp to the filename
					String newFileName = timestamp + String.valueOf(index) + "_" + fileName;

					logger.info("fileName of the uploaded document" + newFileName);
					File file = uploadPortletRequest.getFile(documentName);
					logger.info("file " + file);
					String mimeType = uploadPortletRequest.getContentType(documentName);
					logger.info("mimeType " + mimeType);

					logger.info("folder  folder.getFolderId() -------  " + folder.getFolderId());
					long fileEntryId = 0;
					FileEntry fileEntry = FileUploadUtil.addDocument(newFileName, file, mimeType,
							themeDisplay.getScopeGroupId(), folder.getFolderId());
					logger.info("fileEntry  " + fileEntry);
					if (Validator.isNotNull(fileEntry)) {
						fileEntryId = fileEntry.getFileEntryId();
					}
					logger.info(
							"=this is the file entry id watch it ==================================================== "
									+ fileEntryId);
					JSONObject docsobject = JSONFactoryUtil.createJSONObject();
					docsobject.put("fileEntryID", fileEntryId);
					docsobject.put("documentType", optionValue);
					docsobject.put("caseRequestId", "0"); ///
					docsobject.put("componentClassRefId", appealId);
					docsobject.put("componentId", "0"); ///
					docsobject.put("dFDocumentId", "0"); //
					docsobject.put("dFFileKey", "0"); ///
					docsobject.put("dFFileName", fileName);
					docsobject.put("personId", personId); /// store personId here
					docsobject.put("equivalencyRequestId", equivalencyRequestId);
					docsobject.put("equivalencyAppealId", appealId);
					logger.info("this is the json String ?? " + docsobject.toString());
					String documenturl = themeDisplay.getPortalURL()
							+ AppealConstants.DOCUMENT_INFO_APPEAL_REQUEST_SAVE_URL
							+ themeDisplay.getLayout().getGroupId();
					omsbHttpConnector.executePost(documenturl, docsobject.toString(), headerUtil.getHeaders());

				}
			}

			// wf
			long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
			logger.info("workflowTaskId    " + workflowTaskId);
			long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
			String comments = ParamUtil.getString(actionRequest, "comments");
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
			boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
			String tName = ParamUtil.getString(actionRequest, "transitionName");
			String roleName = appealUtil.getAppealRoleName(themeDisplay.getUser().getRoles());
			logger.info("comments ?? " + comments);
			logger.info("cmd  ?? " + cmd);
			logger.info("roleName  ?? " + roleName);
			logger.info("transition Name  ?? " + tName);

			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
					.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			if (Validator.isNotNull(workflowInstance)) {
				logger.info("taskId :::::::::: " + workflowTaskId + "   ::: instance :: " + instanceId
						+ " :: assignedToMe :: " + assignedToMe);
				logger.info("tName  is ?? " + tName);
				String statusKey = getStatusItemKey(tName);
				logger.info("statusKey  statusKey" + statusKey);
				long statusIdWf = getStatusId(statusKey, themeDisplay.getCompanyId());
				logger.info("statusId                   statusId      1111111111111111111 statusIdWf " + statusIdWf);
				appealUtil.updateEquivalencyAppeal(themeDisplay, appealId, statusIdWf);
				appealUtil.assignOrCompleteWorkflow(tName, cmd, themeDisplay, workflowInstance, workflowTaskId);
			}
		} catch (JSONException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private String getStatusItemKey(String tName) {
		logger.info("tName" + tName);
		String key = "";
		if (AppealConstants.CREATED_KEY.equalsIgnoreCase(tName)) {
			key = AppealConstants.CREATED_KEY;
		} else if (AppealConstants.INSUFFICIENT_KEY.equalsIgnoreCase(tName)) {
			key = AppealConstants.INSUFFICIENT_KEY; // Changed the status to rejected on request of business.
		} else if (AppealConstants.INITIATED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.INITIATED_KEY;
		} else if (AppealConstants.EQUATED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.EQUATED_KEY;
		} else if (AppealConstants.COMPLETED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.COMPLETED_KEY;
		} else if (AppealConstants.RESUBMIT_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.CREATED_KEY;
		} else {
			key = AppealConstants.COMPLETED_KEY;
		}
		logger.info("Key  " + key);
		return key;
	}

	private long getStatusId(String statusKey, long companyId) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_Equivalency_Status,
				statusKey, companyId);
		if (Validator.isNotNull(entry)) {
			return entry.getListTypeEntryId();
		}
		return 0;
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private HeaderUtil headerUtil;
	private static final Log logger = LogFactoryUtil.getLog(EditAppealMVCActionCommand.class);

}
