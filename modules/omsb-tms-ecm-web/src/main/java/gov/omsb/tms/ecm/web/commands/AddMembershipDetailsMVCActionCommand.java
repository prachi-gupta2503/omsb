package gov.omsb.tms.ecm.web.commands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
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
		"mvc.command.name=" + MVCCommandNames.ADD_MEMBERSHIP_DETAILS_ACTIONS }, service = MVCActionCommand.class)
public class AddMembershipDetailsMVCActionCommand extends BaseMVCActionCommand {
	private Log log = LogFactoryUtil.getLog(AddMembershipDetailsMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("action service");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		String bankName = ParamUtil.getString(actionRequest, "bankName");
		String bankBranch = ParamUtil.getString(actionRequest, "bankBranch");
		String accountNumber = ParamUtil.getString(actionRequest, "accountNumber");
		long ecMemberRequestId = ParamUtil.getLong(actionRequest, "ecMemberRequestId");
		if(ecMemberRequestId<=0) {
			ecMemberRequestId = ParamUtil.getLong(actionRequest, "ecMembershipRequestId");
		}
		log.info("ecMemberRequestId >"+ecMemberRequestId);

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File passportFile = uploadPortletRequest.getFile("passportId");
		String passportFileName = uploadPortletRequest.getFileName("passportId");
		String contentType = uploadPortletRequest.getContentType();
		 File nationalIdFile = uploadPortletRequest.getFile("nationalId");
		String nationalIdfileName = uploadPortletRequest.getFileName("nationalId");
		
		EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		log.info("bankName-----"+bankName);
		if (Validator.isNotNull(ecMemberRequest)) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			serviceContext.setAddGuestPermissions(true);
			log.info("ecMemberRequest not null");
			
			bankDetailsLocalService.addBankDetails(bankName, bankBranch, accountNumber, ecMemberRequestId);
			
			DocumentInfoItem addPassportCopy = addPassportCopy( themeDisplay, groupId, passportFileName, ecMemberRequest.getPotentialEcMemberLruserid(),
					passportFile,  passportFileName,  contentType,  "passportCopy",  ecMemberRequest);
			
			ecMemberRequest.setPassportCopyId(addPassportCopy.getId());
			
			DocumentInfoItem addNationaIdCopyId = addNationaIdCopyId(themeDisplay, groupId, nationalIdfileName, ecMemberRequest.getPotentialEcMemberLruserid(),
					nationalIdFile, nationalIdfileName, contentType, "nationalId", ecMemberRequest);
			
			ecMemberRequest.setNationalIdCopyId(addNationaIdCopyId.getId());
			
			ecMemberRequestLocalService.updateRequest(ecMemberRequest);
			
			//Submit workflow task
			String  workDetailsStr = ParamUtil.getString(actionRequest, "workflowTaskDetails");
			if(Validator.isNotNull(workDetailsStr)) {
				log.info("workDetails > "+workDetailsStr);
				
				JSONObject workflowDetails  = JSONFactoryUtil.createJSONObject(workDetailsStr);

				long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
				long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
				String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
				log.info("nextTransitionName >>>>> ###"+nextTransitionName);
				try {
					log.info("ecMemberRequestId > "+ecMemberRequestId);
					
					membershipUtil.submitTask(themeDisplay,workflowInstanceId, taskId, nextTransitionName, "" );
					SessionMessages.add(actionRequest, "ec-add-member-details");
				} catch (PortalException ex) {
					log.debug(ex);;
				}
			}
						
		}
		
	}
	
			private DocumentInfoItem addPassportCopy(ThemeDisplay themeDisplay, long groupId, String title, long userId,
					File file, String fileName, String contentType, String description, EcMemberRequest ecMemberRequest) {
	
				FileEntry fileEntry = AddEditMemberDetailsUtil.uploadSingleFile(groupId, title, membershipUtil.generateFileName(fileName), description,userId, contentType, file);
				DocumentInfoItem saveDocumentInfo = new DocumentInfoItem();
				saveDocumentInfo.setId(saveDocumentInfo.getId());
				saveDocumentInfo.setdFFileName(fileName);
				saveDocumentInfo.setDocumentType(description);
				saveDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
				saveDocumentInfo.setPersonId(ecMemberRequest.getPotentialEcMemberId());
				DocumentInfoItem documentInfo= saveDocumentInfo(saveDocumentInfo,groupId);
					return documentInfo;
			}
			private DocumentInfoItem addNationaIdCopyId(ThemeDisplay themeDisplay, long groupId, String title, long userId,
					File file, String fileName, String contentType, String description, EcMemberRequest ecMemberRequest) {
				
				FileEntry fileEntry = AddEditMemberDetailsUtil.uploadSingleFile(groupId, title, membershipUtil.generateFileName(fileName), description,userId, contentType, file);
				DocumentInfoItem saveDocumentInfo = new DocumentInfoItem();
				saveDocumentInfo.setId(saveDocumentInfo.getId());
				saveDocumentInfo.setdFFileName(fileName);
				saveDocumentInfo.setDocumentType(description);
				saveDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
				saveDocumentInfo.setPersonId(ecMemberRequest.getPotentialEcMemberId());
				DocumentInfoItem documentInfo= saveDocumentInfo(saveDocumentInfo,groupId);
					return documentInfo;
			}
			private DocumentInfoItem saveDocumentInfo(DocumentInfoItem documentInfoItem, long groupId) {
				String documentInfoUrl = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, groupId);
				log.info("documentInfoUrl"+documentInfoUrl);
				Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
				log.info("headers"+headers);
				String documentDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
				log.info("documentDetailMapper"+documentDetailMapper);
				String response = httpConnector.executePost(documentInfoUrl, documentDetailMapper, headers);
				log.info("response"+response);
				return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
			}
			private String generateScopeListURL(String requestsUrl, long siteId) {
				return omsbCommonApi.getBaseURL() + requestsUrl.replace("{scope-id}", String.valueOf(siteId));
			}
				
	@Reference
	private CounterLocalService counterLocalService;
	@Reference
	private GroupLocalService groupLocalService;
	@Reference
	private UserLocalService userLocalService;
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
