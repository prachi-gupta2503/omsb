package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.FileUploadDetail;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.service.util.CaseDetailUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.EquivalencyDocumentType;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Mahaboob
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.EQUIVALENCY_ADD_REQUEST+"This"
	    }, 
	    service = MVCActionCommand.class
)
public class EquivalencyEditRequestMVCActionCommand extends BaseMVCActionCommand{
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("EquivalencyAddRequestMVCActionCommand >>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fullName = ParamUtil.getString(uploadPortletRequest, "fullName");
		String nationality = ParamUtil.getString(uploadPortletRequest, "nationality");
		String passportNumber = ParamUtil.getString(uploadPortletRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(uploadPortletRequest, "dateOfBirth");
		String email = ParamUtil.getString(uploadPortletRequest, "email");
		String cellphoneNumber = ParamUtil.getString(uploadPortletRequest, "cellphoneNumber");
		String profession = ParamUtil.getString(uploadPortletRequest, "profession");
		String comments = ParamUtil.getString(uploadPortletRequest, "comments");
		int personId = ParamUtil.getInteger(uploadPortletRequest, "personId");
		String officialDocType = ParamUtil.getString(uploadPortletRequest, "officialDocType");
		String officialRequestLetter = "officialRequestLetter";
		long otherDocumentCount = ParamUtil.getLong(uploadPortletRequest, "otherDocumentCount");
		long certificateToBeEvaluatedCount = ParamUtil.getLong(uploadPortletRequest, "certificateToBeEvaluatedCount");
		long siteId = themeDisplay.getLayout().getGroupId();
		
		/**
		 * Basic Auth and Header Infomation 
		 */
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		
		/**
		 * Object Mapper Initialization
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		/**
		 * Create Equivalency request 
		 */
		EquivalencyRequest equivalencyRequest = new EquivalencyRequest();
		equivalencyRequest.setPersonId(personId);
		equivalencyRequest.setEmployerUserID((int) themeDisplay.getUserId());
		equivalencyRequest.setEquivalencyStatusId(0l);
		
		//convert Equivalency Pojo to String 
		String payload = objectMapper.writeValueAsString(equivalencyRequest);
		
		//Adding data to Equivalency table
		String equivalencyRquestsURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_REQUESTS_URL,siteId);
		String equivalencyRequestResponse = oMSBHttpConnector.executePost(equivalencyRquestsURL, payload, headersInfo);
		
		JSONObject jsonResponseObject = JSONFactoryUtil.createJSONObject(equivalencyRequestResponse);
		long resEqRequestId = jsonResponseObject.getLong("id");
		long resPersonId = jsonResponseObject.getLong("personId");
		String eqDocTypeOtherDocuments = "Other Documents";
		String eqDocTypeCertificateToEvaluate = "Certificate To Evaluate";
		String eqDocTypeOfficialRequestLeter = "Official Request Letter";
		String equivalencyDocTypeURL = generateScopeListURL(LRObjectURL.EQUIVALENCY_DOC_TYPE_URL,siteId);
		
		/**
		 * Add Other Documents to Document Info Table
		 */
		EquivalencyDocumentType otherDocumentEqDocType = new EquivalencyDocumentType();
		otherDocumentEqDocType.setEquivalencyDocType(eqDocTypeOtherDocuments);
		otherDocumentEqDocType.setEquivalencyRequestId(resEqRequestId);
		
		String eqDocTypeOtherDocumentPayload = objectMapper.writeValueAsString(otherDocumentEqDocType);
		
		//Create Equivalency Document Type 
		String otherDocumentDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL, eqDocTypeOtherDocumentPayload, headersInfo);
		
		JSONObject otherDocumentDocTypeResponseJson = JSONFactoryUtil.createJSONObject(otherDocumentDocTypeResponse);
		int otherDocumenteqDocTypeId =  otherDocumentDocTypeResponseJson.getInt("id");
		FileUploadDetail otherDocumentFileUploadDetails = new FileUploadDetail();
		otherDocumentFileUploadDetails.setEquivalencyDocTypeId(otherDocumenteqDocTypeId);
		otherDocumentFileUploadDetails.setPersonId(personId);
		
		addOtherDocuments(otherDocumentCount, uploadPortletRequest, themeDisplay, siteId, objectMapper, headersInfo, otherDocumentFileUploadDetails);
		
		/**
		 * Add Certificate to Evaluate documents  to Document Info Table
		 */
		EquivalencyDocumentType certificatesToEvaEqDocType = new EquivalencyDocumentType();
		certificatesToEvaEqDocType.setEquivalencyDocType(eqDocTypeCertificateToEvaluate);
		certificatesToEvaEqDocType.setEquivalencyRequestId(resEqRequestId);
		
		String eqDocTypeCertificateToEvaPayload = objectMapper.writeValueAsString(certificatesToEvaEqDocType);
		
		//Create Equivalency Document Type 
		String certificateToEvaDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL, eqDocTypeCertificateToEvaPayload, headersInfo);
		
		JSONObject certificateToEvaDocTypeResponseJson = JSONFactoryUtil.createJSONObject(certificateToEvaDocTypeResponse);
		int eqDocTypeId =  certificateToEvaDocTypeResponseJson.getInt("id");
		FileUploadDetail certificateToEvaFileUploadDetails = new FileUploadDetail();
		certificateToEvaFileUploadDetails.setEquivalencyDocTypeId(eqDocTypeId);
		certificateToEvaFileUploadDetails.setPersonId(personId);		
		
		addCertificatesToEvaluatedDocuments(resEqRequestId, resPersonId, certificateToBeEvaluatedCount, uploadPortletRequest, themeDisplay, siteId, objectMapper,headersInfo,certificateToEvaFileUploadDetails);
		
		/**
		 * Add Official request letter to Document Info Table
		 */
		EquivalencyDocumentType officialRequestLetterEqDocType = new EquivalencyDocumentType();
		officialRequestLetterEqDocType.setEquivalencyDocType(eqDocTypeOfficialRequestLeter);
		officialRequestLetterEqDocType.setEquivalencyRequestId(resEqRequestId);
		
		String eqDocTypeofficialRequestLetterEqDocTypePayload = objectMapper.writeValueAsString(officialRequestLetterEqDocType);
		
		//Create Equivalency Document Type 
		String officialRequestLetterDocTypeResponse = oMSBHttpConnector.executePost(equivalencyDocTypeURL, eqDocTypeofficialRequestLetterEqDocTypePayload, headersInfo);
		
		JSONObject officialRequestLetterDocTypeResponseJson = JSONFactoryUtil.createJSONObject(officialRequestLetterDocTypeResponse);
		int officialRequestLettereqDocTypeId =  officialRequestLetterDocTypeResponseJson.getInt("id");
		FileUploadDetail officialLetterFileUploadDetails = new FileUploadDetail();
		officialLetterFileUploadDetails.setEquivalencyDocTypeId(officialRequestLettereqDocTypeId);
		officialLetterFileUploadDetails.setPersonId(personId);
		officialLetterFileUploadDetails.setDocType(officialDocType);
		
		addOfficialRequestLetterDocuments(officialRequestLetter, uploadPortletRequest, themeDisplay, siteId, objectMapper,headersInfo,officialLetterFileUploadDetails);
	}
	
	public static List<FileEntry> fileUpload(UploadPortletRequest uploadPortletRequest,String folderName, String fileParamName) throws PortalException, java.io.IOException {
		List<FileEntry> fileEntries = new ArrayList<>();
		long fileEntryId = 0;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), uploadPortletRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long repositoryId = themeDisplay.getScopeGroupId();
		Folder folder = getFolder(uploadPortletRequest, folderName);
		if (Validator.isNull(folder)) {
			folder = createNewFolder(uploadPortletRequest, folderName);
		}
		LOGGER.info(" folder ID is - --  >" +folder.getFolderId());		
		Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
		LOGGER.info("files..."+files.size());
		FileItem[] items = files.get(fileParamName);
	//	for (Entry<String, FileItem[]> file2 : files.entrySet()) {
		//	FileItem item[] =file2.getValue();
			try {
				for (FileItem fileItem : items) {
					FileEntry fileEntry = null;
					InputStream is;
					File file;
					String title,description,mimeType;
					mimeType = fileItem.getContentType();	
					file = fileItem.getStoreLocation();
					is = fileItem.getInputStream();
					title=System.currentTimeMillis()+fileItem.getFileName();
					description = title;
					FileEntry existingfileEntry = null;
					try {
					 existingfileEntry = DLAppLocalServiceUtil.getFileEntry(repositoryId,folder.getFolderId(), title);
						LOGGER.info("existingfileEntry : "+existingfileEntry);
					}catch (PortalException e) {
						LOGGER.error(e.getMessage(),e);
					}
				try {
						if(Validator.isNotNull(existingfileEntry)) {
						 fileEntry = DLAppServiceUtil.updateFileEntry(existingfileEntry.getFileEntryId(), existingfileEntry.getFileName(), mimeType, title, title, description, "", DLVersionNumberIncrease.MAJOR, is, existingfileEntry.getSize(),null,null, serviceContext);
						}else {
						fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title,mimeType, title, description, "", file, serviceContext);
						fileEntryId = fileEntry.getFileEntryId();
						LOGGER.info("Multiple file entries are - - - > " +fileEntryId);
					}
						fileEntries.add(fileEntry);
				} catch (PortalException e) {
					LOGGER.error(e.getMessage(),e);
				}		 
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		}
	//}
		return fileEntries;
	}
	
	public static Folder getFolder(UploadPortletRequest uploadPortletRequest, String folderName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, folderName);
			LOGGER.info(folderName + " Exist >>>>>>>");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return folder;
	}
	
	public static Folder createNewFolder(UploadPortletRequest uploadPortletRequest, String folderName){
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = null;
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						uploadPortletRequest);
				LOGGER.info("Creating folder name with this name- - - >" +folderName);
				folder = DLAppLocalServiceUtil.addFolder(folderName, themeDisplay.getUserId(), repositoryId, PARENT_FOLDER_ID,
						folderName, ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		return folder;
	}
	
	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	private void addOtherDocuments(long noOfDocument,UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay,
			long siteId,ObjectMapper objectMapper, Map<String, String> headersInfo,FileUploadDetail OtherDocumentFileUploadDetails) {
		
		String childfolderOtherDocument = "Other Document";
		for (int i = 2; i <= noOfDocument; i++) {
			String documentType = ParamUtil.getString(uploadPortletRequest, "documentType" + i);
			String fileName = "attachmentFile" + i;
			
			Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
			LOGGER.info("files..."+files.size());
			FileItem[] attachmentFileNos = files.get(fileName);
			
			if (Validator.isNotNull(attachmentFileNos)) {
				LOGGER.info("Data :>>>>>>>>>>>>>" + "DocumentType :" + documentType + "File Name :" + fileName);
				//long fileEntryId = addDocument(uploadPortletRequest, themeDisplay, fileName, childfolderOtherDocument);
				List<FileEntry> fileEntries = null;
				long fileEntryd = 0;
				try {
					fileEntries = fileUpload(uploadPortletRequest, childfolderOtherDocument,fileName);
					fileEntryd = fileEntries.get(0).getFileEntryId();
					LOGGER.info("fileEntrydnnnnnnn>>>>>>..."+fileEntryd);
				} catch (PortalException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				OtherDocumentFileUploadDetails.setFileEntryId(fileEntryd);
				String otherDocumentFileUploadDetailsPayload = "";
				try {
					otherDocumentFileUploadDetailsPayload = objectMapper
							.writeValueAsString(OtherDocumentFileUploadDetails);
				} catch (JsonProcessingException e) {
					LOGGER.error(e.getMessage());
				}

				String otherDocumentfileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, siteId);
				String OtherDocumentfileUploadDetailResponse = oMSBHttpConnector.executePost(
						otherDocumentfileUploadDetailURL, otherDocumentFileUploadDetailsPayload, headersInfo);
			}
			LOGGER.info("Other Document Upload End>>>>>>>>>>>>>");
		}
	}
	
	private void addCertificatesToEvaluatedDocuments(long equivalencyRequestId, long personId, long noOfCertificatesDocument, UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay,
		
		long siteId,ObjectMapper objectMapper,Map<String, String> headersInfo,FileUploadDetail certificateToEvaFileUploadDetails) {
		String childfolderCertificateToBeEvaluated = "Certificate to Be Evaluated";
		for (int i = 2; i <= noOfCertificatesDocument; i++) {
				
			String qualification = ParamUtil.getString(uploadPortletRequest, "qualification" + i);
			if(qualification.equals("1")) {
				qualification = ParamUtil.getString(uploadPortletRequest, "otherQualification" + i);
			}
			
			String issuedFrom = ParamUtil.getString(uploadPortletRequest, "issuedFrom" + i);
			if(qualification.equals("1")) {				
				issuedFrom = ParamUtil.getString(uploadPortletRequest, "issuedFromOther" + i);
			}
			
			String issueDate = ParamUtil.getString(uploadPortletRequest, "issueDate" + i);
			try {
				EducationDetail educationDetail = new EducationDetail();
				educationDetail.setIssuingAuthorityName(issuedFrom);
				educationDetail.setQualificationAttained(qualification);
				educationDetail.setQualificationConferredDate(issueDate);
				educationDetail.setEquivalencyRequestId((int)equivalencyRequestId);
				
				caseDetailUtil.addEducationDetail(personId, 0, educationDetail,"");
			} catch (JSONException  e2) {
				LOGGER.info("Error while adding education details");
			}
			
			String certificatefile ="certificatetbl"+i;
			String verificationReportPaymentReceipt = "verificationReportPaymentReceipt"+i;
			String dfrn = ParamUtil.getString(uploadPortletRequest,"dfrn" + i);
			Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
			LOGGER.info("files..."+files.size());
			FileItem[] certificatefileNos = files.get(certificatefile);
			FileItem[] verificationReportFileNos = files.get(verificationReportPaymentReceipt);
			
			if (Validator.isNotNull(certificatefileNos)) {
				//long certificateFileEtryId =  addDocument(uploadPortletRequest, themeDisplay, certificatefile, childfolderCertificateToBeEvaluated);
				
				List<FileEntry> fileEntries = null;
				long fileEntryd = 0;
				try {
					fileEntries = fileUpload(uploadPortletRequest, childfolderCertificateToBeEvaluated,certificatefile);
					fileEntryd = fileEntries.get(0).getFileEntryId();
					LOGGER.info("fileEntrydnnnnnnn>>>>>>..."+fileEntryd);
				} catch (PortalException e1) {
					e1.printStackTrace();
				} catch (java.io.IOException e1) {
					e1.printStackTrace();
				}
				 
				//Certificate File upload
				certificateToEvaFileUploadDetails.setFileEntryId(fileEntryd);
				certificateToEvaFileUploadDetails.setDocType(qualification);
				String certificateToEvafileUploadDetailPayload = null;
				try {
					certificateToEvafileUploadDetailPayload = objectMapper.writeValueAsString(certificateToEvaFileUploadDetails);
				} catch (JsonProcessingException e) {
					LOGGER.error(e.getMessage());
				}

				String certificateToEvafileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, siteId);
				oMSBHttpConnector.executePost(certificateToEvafileUploadDetailURL, certificateToEvafileUploadDetailPayload, headersInfo);
				LOGGER.info("Certification File Uploaded>>>>>>>>>>>>>");	
				
				if (Validator.isNotNull(verificationReportFileNos)) {
				List<FileEntry> fileEntries2 = null;
				long fileEntryd2 = 0;
				try {
					fileEntries2 = fileUpload(uploadPortletRequest, childfolderCertificateToBeEvaluated,verificationReportPaymentReceipt);
					fileEntryd2 = fileEntries2.get(0).getFileEntryId();
					LOGGER.info("fileEntry2>>>>>>..."+fileEntryd2);
				} catch (PortalException e1) {
					e1.printStackTrace();
				} catch (java.io.IOException e1) {
					e1.printStackTrace();
				}
				
				certificateToEvaFileUploadDetails.setFileEntryId(fileEntryd2);
				certificateToEvaFileUploadDetails.setDocType(dfrn);
				String certificateToEvafileUploadDetailPayload2 = null;
				try {
					certificateToEvafileUploadDetailPayload2 = objectMapper
							.writeValueAsString(certificateToEvaFileUploadDetails);
				} catch (JsonProcessingException e) {
					LOGGER.error(e.getMessage());
				}
				oMSBHttpConnector.executePost(certificateToEvafileUploadDetailURL, certificateToEvafileUploadDetailPayload2, headersInfo);
				LOGGER.info("Verification Report File Uploaded>>>>>>>>>>>>>");
				} 
			}
		}
	}
	
	private void addOfficialRequestLetterDocuments(String officialRequestLetter,UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay,
			long siteId,ObjectMapper objectMapper,Map<String, String> headersInfo,FileUploadDetail certificateToEvaFileUploadDetails) throws IOException {
		String officialRequestLetterFolder = "Official Request Letter";
		List<FileEntry> fileEntries = null;
		try {
			fileEntries = fileUpload(uploadPortletRequest, officialRequestLetterFolder, officialRequestLetter);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		for (FileEntry fileEntry : fileEntries) {
			LOGGER.info("File Names >>>> " + fileEntry.getFileName() + "  :File Entry Id >>>> "
					+ fileEntry.getFileEntryId());

			certificateToEvaFileUploadDetails.setFileEntryId(fileEntry.getFileEntryId());
			String certificateToEvafileUploadDetailPayload2 = null;
			try {
				certificateToEvafileUploadDetailPayload2 = objectMapper
						.writeValueAsString(certificateToEvaFileUploadDetails);
			} catch (JsonProcessingException e) {
				LOGGER.error(e.getMessage());
			}
			String officialRequestfileUploadDetailURL = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, siteId);
			oMSBHttpConnector.executePost(officialRequestfileUploadDetailURL, certificateToEvafileUploadDetailPayload2, headersInfo);
			LOGGER.info("Official Request Letter File Uploaded>>>>>>>>>>>>>");

		}
	}
	
	private String getObjectClassName(long companyId) {
		ObjectDefinition definition = null;
		try {
			definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode("OB_EUIVALENCY_REQUEST_ERC", companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionService;
	
	@Reference(unbind = "_")
	private CaseDetailUtil caseDetailUtil;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyEditRequestMVCActionCommand.class);
	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
}
