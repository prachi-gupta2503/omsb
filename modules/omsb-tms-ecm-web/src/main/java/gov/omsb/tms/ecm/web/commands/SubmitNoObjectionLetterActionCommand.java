package gov.omsb.tms.ecm.web.commands;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.time.Clock;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;

/**
 * 
 * @author Rohini Gaud
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.SUBMIT_NOC_ACTION }, service = MVCActionCommand.class)
public class SubmitNoObjectionLetterActionCommand extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(SubmitNoObjectionLetterActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("NOC Action Command");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String workDetailsStr = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.NO_TASK_DETAILS);
		LOGGER.info("workDetails > " + workDetailsStr);

		JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);

		long ecMemberRequestId = workflowDetails.getLong(OmsbEcMembershipConstants.REQUEST_ID);
		long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
		long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
		String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);

		String comment = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.NOC_COMMENT);

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile(OmsbEcMembershipConstants.NOC_DOCUMENT);
		String fileName = uploadPortletRequest.getFileName(OmsbEcMembershipConstants.NOC_DOCUMENT);
		
		
		String contentType = uploadPortletRequest.getContentType(OmsbEcMembershipConstants.NOC_DOCUMENT);

		
			 if(Validator.isNotNull(fileName)) {
				 try {
					DLFolder dLFolder = FileUploadUtil.getDLFolder(themeDisplay.getSiteGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, OmsbEcMembershipConstants.EC_MEMBER_NOC_DOCUMENT_FOLDER_NAME);
					ServiceContext serviceContext = new ServiceContext();
					if (dLFolder == null) {
						dLFolder = FileUploadUtil.createDLFolder(themeDisplay.getSiteGroupId(), OmsbEcMembershipConstants.EC_MEMBER_NOC_DOCUMENT_FOLDER_NAME, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
								themeDisplay.getUserId(), StringPool.BLANK);
					}
					
					String entryFileName = membershipUtil.generateFileName(fileName);
					
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getSiteGroupId(), dLFolder.getFolderId(),
							entryFileName, contentType, entryFileName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);
		
					DocumentInfo documentInfo = saveDocumentInfo(actionRequest, fileEntry.getFileEntryId(), fileName);
					EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		
					ecMemberRequest.setNoObjectionLetterId(documentInfo.getId());
					EcMemberRequestLocalServiceUtil.updateRequest(ecMemberRequest);
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
			 LOGGER.info("nextTransitionName ::: " + nextTransitionName);
			try {
				LOGGER.info("ecMemberRequestId > " + ecMemberRequestId);
				membershipUtil.submitTask(themeDisplay, workflowInstanceId, taskId,
						nextTransitionName, comment);
				if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.NOC_UPLOAD)
			|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.AU_NOC_UPLOAD)) {
					SessionMessages.add(actionRequest,  "ec-request-noc-upload");
				} else if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.SEND_TO_AU_FOR_NOC)) {
					SessionMessages.add(actionRequest,  "ec-request-send-to-au-for-noc");
				}	
			
				
			} catch (PortalException ex) {
				LOGGER.debug(ex);
			}

		
	}

	private DocumentInfo saveDocumentInfo(ActionRequest actionRequest, long fileEntryId, String fileName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String payload = "{\"fileEntryID\": \"" + fileEntryId + "\", \"dFFileName\": \""+fileName+"\"}";
		String url = getScopeURL(LRObjectURL.DOCUMENT_INFO_URL, themeDisplay.getScopeGroupId());
		String response = httpConnector.executePost(url, payload, headers);
		return CustomObjectMapperUtil.readValue(response, DocumentInfo.class);
	}

	private String getScopeURL(String url, long scopeId) {
		return omsbCommonApi.getBaseURL() + url.replace("{scope-id}", String.valueOf(scopeId));
	}

	@Reference
	private OMSBHttpConnector httpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

}
