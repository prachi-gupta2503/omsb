package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
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
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
        "mvc.command.name="+ MVCCommandNames.SAVE_CANCELLATION_ACTION, }, service = MVCActionCommand.class)
public class SaveCancellationMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        logger.info("Invoking do process action method ::::::::::");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String reason =  ParamUtil.getString(actionRequest, "comments");
        long scheduleId =  ParamUtil.getLong(actionRequest, "scheduleId",0);
        String supportingDocJson =  ParamUtil.getString(actionRequest, "supportingDocJson");
        long cancellationId =  ParamUtil.getLong(actionRequest, "cancellationId",0);
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "instanceId");
		boolean assignedToMe = ParamUtil.getBoolean(actionRequest, "assignedToMe");
		String transitionName = ParamUtil.getString(actionRequest, "trName");
		long examTitleId = ParamUtil.getLong(actionRequest, "examTitleId");
        ObjectEntry cancelEntry = null;
        boolean isAdmin = Boolean.FALSE;
       	logger.info("reason ::::::::::" + reason);
       	logger.info("scheduleId ::::::::::" + scheduleId);
       	logger.info("supportingDocJson ::::::::::" + supportingDocJson);
       	logger.info("cancellationId ::::::::::" + cancellationId);
    	logger.info("transitionName ::::::::::" + transitionName);
       	long statusId = 0;
      	List<String > roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName).collect(Collectors.toList());
      	if (roleNames.contains(RoleNameConstants.OCT_ADMIN)) {
      		isAdmin = Boolean.TRUE;
      		if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_ACCEPT)) {
      			logger.info("in accept condition ::::::::::" + transitionName);
				statusId = octExamUtil.getExamStatusIdByListTypeKey(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_ACCEPTED, themeDisplay.getCompanyId());	
			} else if (transitionName.equalsIgnoreCase(OmsbOctExamWebPortletKeys.TRANSITION_NAME_REJECT)) {
				logger.info("in reject condition ::::::::::" + transitionName);
				statusId = octExamUtil.getExamStatusIdByListTypeKey(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_REJECTED, themeDisplay.getCompanyId());
			}
      	} else {
      		 statusId = octExamUtil.getExamStatusIdByListTypeKey(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId());
      	}
       	logger.info("statusId ::::::::::" + statusId);
		if (cancellationId > 0 && isAdmin) {
			//update the cancellation with status.
			logger.info("inside update ::::::::::" );
			ObjectDefinition objectDefinition = octExamUtil.getObjectDefinition(themeDisplay, OmsbOctExamWebPortletKeys.CANCELLATION_OBJECT_ERC);
			logger.info("objectDefinition ::::::::::" + objectDefinition);
			if (Validator.isNotNull(objectDefinition)) {
				cancelEntry = updateCancellationById(actionRequest, themeDisplay, objectDefinition, cancellationId, statusId);
			}
		} else {
			logger.info("inside add ::::::::::" );
			 cancelEntry = addCancellation(themeDisplay, scheduleId, actionRequest, statusId, examTitleId);
		}
		
		logger.info("cancelEntry ::::::::::" + cancelEntry);
		ObjectEntry cancelStatusEntry = null;
		if (Validator.isNotNull(cancelEntry)) {
			cancellationId = cancelEntry.getObjectEntryId();
			logger.info("cancellationId ::::::::::" + cancellationId);
			cancelStatusEntry = addCancellationStatus(themeDisplay, reason, cancellationId, actionRequest, statusId);
			logger.info("cancelStatusEntry ::::::::::" + cancelStatusEntry);
		}
		JSONObject jsonData = JSONFactoryUtil.createJSONObject(supportingDocJson);
       	JSONArray  array = jsonData.getJSONArray("items");
		if (Validator.isNotNull(cancelStatusEntry)) {
			for (int i = 0; i < array.length(); i++) {
				JSONObject supportingValues = array.getJSONObject(i);
				String fileName = supportingValues.getString("fileName");
				String docTitle = supportingValues.getString("docTitle");
				String rowNumber = supportingValues.getString("rowNumber");
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				File file = uploadRequest.getFile("docInput_"+rowNumber);
				FileEntry entry = FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
						themeDisplay.getScopeGroupId(), 0);
				if (Validator.isNotNull(entry) && cancelStatusEntry != null) {
					logger.info("fileName ?? " + entry.getFileEntryId());
					addCancellationDocs(themeDisplay, docTitle, entry.getFileEntryId(),
							cancelStatusEntry.getObjectEntryId(), actionRequest);
				}
			}
		}
		if (!assignedToMe && isAdmin && Validator.isNotNull(cancelStatusEntry)) {
			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			octExamAppealUtil.assignOrCompleteWorkflow(transitionName, "", themeDisplay, workflowInstance, workflowTaskId);
		}
		 
        logger.info("Invoking do process action method successful::::::::::");
    }

    private ObjectEntry addCancellation(ThemeDisplay themeDisplay, long scheduleId, PortletRequest request, long statusId, long examTitleId){
    	
        return omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.CANCELLATION_OBJECT_ERC, putData(scheduleId, statusId, "", themeDisplay, examTitleId, "", 0), request, themeDisplay);
    }

    private ObjectEntry addCancellationStatus(ThemeDisplay themeDisplay, String reason, long cancellationId, PortletRequest request, long statusId){
        return omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.CANCELLATION_STATUS_OBJECT_ERC, putData(0, statusId, reason, themeDisplay, cancellationId, "", 0), request, themeDisplay);
    }

    private ObjectEntry addCancellationDocs(ThemeDisplay themeDisplay, String docTitle, long fileEntryId, long cancellationStatusId, PortletRequest request){
        long statusId  = 0;
        return omsbCommonApi.addObjectEntryByERC(OmsbOctExamWebPortletKeys.CANCELLATION_DOCS_OBJECT_ERC, putData(0, statusId, "", themeDisplay, cancellationStatusId,docTitle, fileEntryId), request, themeDisplay);
    }

    private Map<String, Serializable> putData(long scheduleId, long statusId, String reason, ThemeDisplay themeDisplay, long id, String docTitle, long fileEntryId){
        Map<String, Serializable> values = new HashMap<>();
        values.put(OCTExamConstants.FIELD_OC_EXAM_SCHEDULE_ID,scheduleId);
        values.put(OCTExamConstants.FIELD_OC_EXAM_LR_USER_ID,themeDisplay.getUserId());
        values.put(OCTExamConstants.FIELD_OC_EXAM_CANCEL_WF_STATUS_ID,statusId);
        values.put(OCTExamConstants.FIELD_OC_EXAM_REASON,reason);
        values.put(OCTExamConstants.FIELD_OC_EXAM_TITLE_ID, id);
        if (docTitle.isEmpty()) {
            values.put(OCTExamConstants.FIELD_OC_EXAM_CANCEL_ID,id); // for cancellationStatus table
        } else {
            values.put(OCTExamConstants.FIELD_OC_EXAM_CANCELLATION_STATUS_ID, id); // for cancellationDocuments table
            values.put(OCTExamConstants.FIELD_OC_EXAM_CANCELLATION_DOCUMENT_TITLE,docTitle);
            values.put(OCTExamConstants.FIELD_OC_EXAM_CANCELLATION_DOCUMENT_FILE_ENTRY_ID,fileEntryId);
        }	
       
        return values;
    }
    
    private ObjectEntry updateCancellationById(PortletRequest request, ThemeDisplay themeDisplay, ObjectDefinition objectDefinition, long pk, long statusId) {
    	Map<String, Serializable> values = new HashMap<>();
    	  values.put(OCTExamConstants.FIELD_OC_EXAM_CANCEL_WF_STATUS_ID,statusId);
    	  ServiceContext serviceContext;
		try {
			ObjectEntry entry =  objectEntryLocalService.getObjectEntry(pk);
			serviceContext = ServiceContextFactory.getInstance(request);
			entry = ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry
			(entry.getExternalReferenceCode(), themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 
					objectDefinition.getObjectDefinitionId(), values, serviceContext);
			//(themeDisplay.getUserId(), objectDefinition, pk, values, serviceContext);
			return entry;
		} catch (PortalException e) {
			logger.error("exception while calling the updateCancellationById ::::: " + e);
		}
		return null;
    	
    }

    private static final Log logger = LogFactoryUtil.getLog(SaveCancellationMVCActionCommand.class);

    @Reference(unbind = "-")
	private OCTExamAppealUtil octExamAppealUtil;
    
    @Reference(unbind = "-")
    private OMSBCommonApi omsbCommonApi;
    
    @Reference(unbind = "-")
    private OCTExamUtil octExamUtil;
	
    @Reference(unbind = "-")
    private OMSBHttpConnector omsbHttpConnector;
    
    @Reference 
    private ObjectEntryLocalService objectEntryLocalService;
	
	
}
