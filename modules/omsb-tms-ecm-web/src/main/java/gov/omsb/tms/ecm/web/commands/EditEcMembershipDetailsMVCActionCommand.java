package gov.omsb.tms.ecm.web.commands;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.util.AddEditMemberDetailsUtil;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.BankDetailsLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.EDIT_MEMBERSHIP_DETAILS_ACTION }, service = MVCActionCommand.class)

public class EditEcMembershipDetailsMVCActionCommand extends BaseMVCActionCommand {
	private Log log = LogFactoryUtil.getLog(EditEcMembershipDetailsMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info(" Edit member details action call");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long ecMemberRequestId = ParamUtil.getLong(actionRequest, "ecMemberRequestId");
		long bankDetailsId = ParamUtil.getLong(actionRequest, "bankDetailsId");
		String bankName = ParamUtil.getString(actionRequest, "bankName");
		String bankBranch = ParamUtil.getString(actionRequest, "bankBranch");
		String accountNumber = ParamUtil.getString(actionRequest, "accountNumber");
		log.info("ecMemberRequestId------" + ecMemberRequestId + "bankDetailsId------" + bankDetailsId + "bankName--"
				+ bankName + "bankBranch------" + bankBranch + "accountNumber--" + accountNumber);
		EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		//Edit Bank Details
		ServiceContext serviceContext =ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		serviceContext.setAddGuestPermissions(true);
		if(bankDetailsId>0) {
			
			bankDetailsLocalService.editBankDetails(bankDetailsId, bankName, bankBranch, accountNumber, ecMemberRequestId);
		}else {
			bankDetailsLocalService.addBankDetails(bankName, bankBranch, accountNumber, ecMemberRequestId);
		}
		/* Not Required---------------
		 UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		// Edit Passport Copy Id
		File passportFile = uploadPortletRequest.getFile("passportId");
		 log.info("passportFile"+passportFile.exists());
		String passportFileName = uploadPortletRequest.getFileName("passportId");
		String contentType = uploadPortletRequest.getContentType();
		if(passportFile.exists()) {
			log.info("passport file exist");
			editPassportCopy(ecMemberRequest.getPassportCopyId(), themeDisplay, passportFileName, ecMemberRequest.getPotentialEcMemberLruserid(),
				passportFile,  passportFileName,  contentType, "passportCopy", ecMemberRequest);
		}
		// Edit National Copy Id
		 File nationalIdFile = uploadPortletRequest.getFile("nationalId");
		 log.info("nationalIdFile"+nationalIdFile.exists());
		String nationalIdfileName = uploadPortletRequest.getFileName("nationalId");
		if(nationalIdFile.exists()) {
			log.info("passport file exist");
			editNationalCopyId(ecMemberRequest.getNationalIdCopyId(),  themeDisplay, nationalIdfileName,ecMemberRequest.getPotentialEcMemberLruserid() ,
				nationalIdFile, nationalIdfileName, contentType, "nationalId", ecMemberRequest);
		}*/

		String workDetailsStr = ParamUtil.getString(actionRequest, "workflowTaskDetails");
		log.info("workDetails > " + workDetailsStr);
		if (Validator.isNotNull(workDetailsStr)) {
			log.info("workDetails > " + workDetailsStr);

			JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);

			long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
			long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
			String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);

			try {
				log.info("ecMemberRequestId > "+ecMemberRequestId);
				
				membershipUtil.submitTask(themeDisplay,workflowInstanceId, taskId, nextTransitionName, "" );
				SessionMessages.add(actionRequest, "ec-add-member-details");
			} catch (PortalException ex) {
				log.debug(ex);
			}
		}
		
	}
	private DocumentInfoItem editPassportCopy(long documentInfoId, ThemeDisplay themeDisplay,String title, long userId,
			File file, String fileName, String contentType, String description,EcMemberRequest ecMemberRequest) {
		DocumentInfoItem documentInfo=null;
		try {
			FileEntry fileEntry = AddEditMemberDetailsUtil.uploadSingleFile(themeDisplay.getScopeGroupId(), title, membershipUtil.generateFileName(fileName), description,userId, contentType, file);
			DocumentInfoItem fetchDocumentInfoByDocumentInfo = fetchDocumentInfoByDocumentInfoId(themeDisplay,documentInfoId);
			
			if (ecMemberRequest.getPassportCopyId() == 0 || fetchDocumentInfoByDocumentInfo.getdFFileName() == null
					|| fetchDocumentInfoByDocumentInfo.getdFFileName().isBlank()) {
				  documentInfo = saveDocument(fileEntry, themeDisplay.getScopeGroupId(),
						fileEntry.getFileName(), fileEntry.getFileName(), fileEntry.getDescription(),
						ecMemberRequest);
			}
			else{
				fetchDocumentInfoByDocumentInfo.setdFFileName(fileName);
				fetchDocumentInfoByDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
				documentInfo = editDocumentInfo(fetchDocumentInfoByDocumentInfo, fetchDocumentInfoByDocumentInfo.getId(), themeDisplay);	
				log.info("editPassportCopy ");
			}
			ecMemberRequest.setPassportCopyId(documentInfo.getId());
		
			}catch (UnsupportedEncodingException e) {
				log.error("Error in editPassportCopy:::");
				
			}
		ecMemberRequestLocalService.updateEcMemberRequest(ecMemberRequest);
		return documentInfo;
	}
	
	private DocumentInfoItem editNationalCopyId(long documentInfoId, ThemeDisplay themeDisplay, String title, long userId,
			File file, String fileName, String contentType,String description, EcMemberRequest ecMemberRequest) {
		DocumentInfoItem documentInfo=null;
		try {
			FileEntry fileEntry = AddEditMemberDetailsUtil.uploadSingleFile(themeDisplay.getScopeGroupId(), title, membershipUtil.generateFileName(fileName), description,userId, contentType, file);
			DocumentInfoItem fetchDocumentInfoByDocumentInfo = fetchDocumentInfoByDocumentInfoId(themeDisplay,documentInfoId);
			if (ecMemberRequest.getNationalIdCopyId() == 0 || fetchDocumentInfoByDocumentInfo.getdFFileName() == null
					|| fetchDocumentInfoByDocumentInfo.getdFFileName().isBlank()) {
				documentInfo = saveDocument(fileEntry, themeDisplay.getScopeGroupId(),
						fileEntry.getFileName(), fileEntry.getFileName(), fileEntry.getDescription(),
						ecMemberRequest);
			}
			else {
				fetchDocumentInfoByDocumentInfo.setdFFileName(fileName);
				fetchDocumentInfoByDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
				documentInfo = editDocumentInfo(fetchDocumentInfoByDocumentInfo, fetchDocumentInfoByDocumentInfo.getId(), themeDisplay);	
				log.info("editNationalCopy ");
			}
			}catch (UnsupportedEncodingException e) {
				log.error("Error in editNationalCopy:::");
				
			}
		
		return documentInfo;
	}
	private DocumentInfoItem fetchDocumentInfoByDocumentInfoId(ThemeDisplay themeDisplay, long documentId)
			throws UnsupportedEncodingException {
		String qualificationDocumentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DELETE_DOCINFO + documentId;
		log.info("qualificationDocumentInfoUrl---------" + qualificationDocumentInfoUrl);
		String qualificationDocumentInfoResponse = omsbCommonApi.getData(qualificationDocumentInfoUrl);
		log.info("qualificationDocumentInfoResponse" + qualificationDocumentInfoResponse);
		DocumentInfoItem qualificationDocumentInfos = CustomObjectMapperUtil
				.readValue(qualificationDocumentInfoResponse, DocumentInfoItem.class);
		return qualificationDocumentInfos;
	}

	private DocumentInfoItem saveDocumentInfo(DocumentInfoItem documentInfoItem, long groupId) {
		String documentInfoUrl = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, groupId);
		log.info("documentInfoUrl" + documentInfoUrl);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		log.info("headers" + headers);
		String documentDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
		log.info("documentDetailMapper" + documentDetailMapper);
		String response = httpConnector.executePost(documentInfoUrl, documentDetailMapper, headers);
		log.info("response" + response);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
	}

	public DocumentInfoItem editDocumentInfo(DocumentInfoItem documentInfoItem, long documentInfoId,
			ThemeDisplay themeDisplay) {
		String documentInfoUrl = omsbCommonApi.getBaseURL() + LRObjectURL.DELETE_DOCINFO + documentInfoId;
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String personalDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
		String response = httpConnector.executePut(documentInfoUrl, personalDetailMapper, headers);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
	}
	private DocumentInfoItem saveDocument(FileEntry fileEntry, long groupId, String title, String fileName,
			String description, EcMemberRequest ecMemberRequest) {
		DocumentInfoItem saveDocumentInfo = new DocumentInfoItem();
		saveDocumentInfo.setId(saveDocumentInfo.getId());
		saveDocumentInfo.setdFFileName(fileName);
		saveDocumentInfo.setDocumentType(description);
		saveDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
		saveDocumentInfo.setPersonId(ecMemberRequest.getPotentialEcMemberId());
		DocumentInfoItem documentInfo = saveDocumentInfo(saveDocumentInfo, groupId);
		return documentInfo;
	}

	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	@Reference
	private BankDetailsLocalService bankDetailsLocalService;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

}
