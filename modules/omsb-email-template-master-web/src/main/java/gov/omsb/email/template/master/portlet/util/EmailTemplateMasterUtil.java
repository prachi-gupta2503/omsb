package gov.omsb.email.template.master.portlet.util;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.constants.OMSBEmailTemplateMasterCommonConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterConstants;
import gov.omsb.email.template.master.model.EmailTemplateMaster;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalService;

/**
 * @author Niddhi Thacker
 *
 */
public class EmailTemplateMasterUtil {
	
	private static final Log log = LogFactoryUtil.getLog(EmailTemplateMasterUtil.class);

	private static EmailTemplateMasterLocalService _emailTemplateMasterLocalService;
	
	private static OMSBEmailTemplateMasterCommonApi _omsbEmailTemplateMasterCommonApi;
	
	public EmailTemplateMasterUtil(EmailTemplateMasterLocalService emailTemplateMasterLocalService) {
		_emailTemplateMasterLocalService = emailTemplateMasterLocalService;
	}
	
	public EmailTemplateMasterUtil(EmailTemplateMasterLocalService emailTemplateMasterLocalService, OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi) {
		_emailTemplateMasterLocalService = emailTemplateMasterLocalService;
		_omsbEmailTemplateMasterCommonApi = omsbEmailTemplateMasterCommonApi;
	}
	
	public static boolean deleteEmailTemplate(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long templateId = ParamUtil.getLong(actionRequest, EmailTemplateMasterConstants.TEMPLATE_IDX, 0);
		boolean isEmailTemplateDeleted = false;
		
		if(templateId > 0) {
			_emailTemplateMasterLocalService.deleteEmailTemplateMaster(templateId);
			isEmailTemplateDeleted = true;
		}
		return isEmailTemplateDeleted;
	}
	
	public static EmailTemplateMaster getEmailTemplate(long templateId) {
		EmailTemplateMaster emailTemplateMaster = null;
		try {
			emailTemplateMaster = _emailTemplateMasterLocalService.getEmailTemplateMaster(templateId);
		} catch (PortalException | SystemException e) {
			log.error("Error while fetching emailTemplate master from template id :" + e.getMessage());
		}
		return emailTemplateMaster;
	}
	
	public static boolean saveEmailTemplate(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		List<EmailTemplateMaster> emailTemplateMasters = _emailTemplateMasterLocalService.getEmailTemplateMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		boolean isRichText = Boolean.FALSE;
		String enUSuserNotification = StringPool.BLANK;
		String arSAuserNotification = StringPool.BLANK;
		boolean isEmailTemplateSaved = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long templateId = ParamUtil.getLong(actionRequest,EmailTemplateMasterConstants.TEMPLATE_IDX, 0);
		String templateName = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.TEMPLATE_NAME, StringPool.BLANK);
		
		String templateDescription = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.TEMPLATE_DESCRIPTION, StringPool.BLANK);
		String senderType = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.SENDER_TYPE, StringPool.BLANK);
		String[] defaultCC = ParamUtil.getStringValues(actionRequest, EmailTemplateMasterConstants.DEFAULT_CC);
		String[] defaultBCC = ParamUtil.getStringValues(actionRequest, EmailTemplateMasterConstants.DEFAULT_BCC);
		
		String enUSSubject = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.SUBJECT_EN_US, StringPool.BLANK);
		String arSASubject = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.SUBJECT_AR_SA, StringPool.BLANK);
		JSONObject subjectJSON = createEncryptedValueJSON(enUSSubject, arSASubject);
		
		String enUSDynamicBody = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.DYNAMIC_BODY_EN_US, StringPool.BLANK);
		String arSADynamicBody = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.DYNAMIC_BODY_AR_SA, StringPool.BLANK);
		JSONObject dynamicBodyJSON = createEncryptedValueJSON(enUSDynamicBody, arSADynamicBody);
		
		String enUSStaticBody = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.STATIC_BODY_EN_US, StringPool.BLANK);
		String arSAStaticBody = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.STATIC_BODY_AR_SA, StringPool.BLANK);
		JSONObject staticBodyJSON = createEncryptedValueJSON(enUSStaticBody, arSAStaticBody);
		
		String enUSSignature = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.SIGNATURE_EN_US, StringPool.BLANK);
		String arSASignature = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.SIGNATURE_AR_SA, StringPool.BLANK);
		JSONObject signatureJSON = createEncryptedValueJSON(enUSSignature, arSASignature);
		
		boolean isUserNotification = ParamUtil.getBoolean(actionRequest, EmailTemplateMasterConstants.USER_NOTIFICATION, Boolean.FALSE);
		log.info("Is User Notification: " + isUserNotification);
		if(isUserNotification) {
			String userNotificationVal = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.USER_NOTIFICATION_RADIO, StringPool.BLANK);
			log.info("User Notification Value: " + userNotificationVal);
			if(Validator.isNotNull(userNotificationVal) && userNotificationVal.equals(EmailTemplateMasterConstants.USER_NOTIFICATION_EDITOR)) {
				enUSuserNotification = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.USER_NOTIFICATION_EDITOR_BODY_EN_US, StringPool.BLANK);
				arSAuserNotification = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.USER_NOTIFICATION_EDITOR_BODY_AR_SA, StringPool.BLANK);
				isRichText = Boolean.TRUE;
			}else if(Validator.isNotNull(userNotificationVal) && userNotificationVal.equals(EmailTemplateMasterConstants.USER_NOTIFICATION_TEXTAREA)) {
				enUSuserNotification = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.USER_NOTIFICATION_TEXTAREA_EN_US, StringPool.BLANK);
				arSAuserNotification = ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.USER_NOTIFICATION_TEXTAREA_AR_SA, StringPool.BLANK);
				isRichText = Boolean.FALSE;
			}
		}
		JSONObject userNotificationJSON = createEncryptedValueJSON(enUSuserNotification, arSAuserNotification);
		
		long[] deletedFileEntryIds = ParamUtil.getLongValues(actionRequest, EmailTemplateMasterConstants.DELETED_FILE_ENTRY_IDXS);
		
		EmailTemplateMaster emailTemplateMaster = null;
		
		log.info("TemplateId : " + templateId + ", TemplateName : " + templateName);
		
		boolean isUpdate = false;
		if(templateId > 0) {
			emailTemplateMaster = _emailTemplateMasterLocalService.getEmailTemplateMaster(templateId);
			isUpdate = true;
		}else{
			emailTemplateMaster = _emailTemplateMasterLocalService.createEmailTemplateMaster(CounterLocalServiceUtil.increment());
		}
		
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		if(Validator.isNotNull(emailTemplateMaster)) {
			
			emailTemplateMaster.setTemplateName(templateName);
			emailTemplateMaster.setTemplateDescription(templateDescription);
			emailTemplateMaster.setSenderType(senderType);
			emailTemplateMaster.setSenderEmailId(StringPool.BLANK);
			
			emailTemplateMaster.setDefaultCC(String.join(",", defaultCC));
			emailTemplateMaster.setDefaultBCC(String.join(",", defaultBCC));
			emailTemplateMaster.setSubject(subjectJSON.toJSONString());
			emailTemplateMaster.setDynamicBody(dynamicBodyJSON.toJSONString());
			emailTemplateMaster.setStaticBody(staticBodyJSON.toJSONString());
			emailTemplateMaster.setSignature(signatureJSON.toJSONString());
			emailTemplateMaster.setUserNotification(userNotificationJSON.toJSONString());
			emailTemplateMaster.setIsRichText(isRichText);
			
			if(isUpdate) {
				emailTemplateMaster.setModifiedBy(userId);
				emailTemplateMaster.setModifiedDate(new Date());
			}else {
				emailTemplateMaster.setCreatedBy(userId);
				emailTemplateMaster.setCreatedDate(new Date());
				emailTemplateMaster.setModifiedBy(userId);
				emailTemplateMaster.setModifiedDate(new Date());
			}
			
			emailTemplateMaster.setGroupId(groupId);
			emailTemplateMaster.setCompanyId(companyId);
			
			if(Validator.isNotNull(emailTemplateMaster) && emailTemplateMaster.getTemplateId() > 0) {
				List<String> duplicateFileTitleList = new ArrayList<>();
				List<String> errorFileTitleList = new ArrayList<>();
				String attachmentFileUploadLimit = _omsbEmailTemplateMasterCommonApi.getEmailTemplateAttachmentUploadLimit(groupId, companyId);
				try {
					for(int i = 1; i <= Integer.parseInt(attachmentFileUploadLimit); i++) {
						String title = StringPool.BLANK;
						try {
							Map<String, Object> fileParamsMap = getFileParams(uploadPortletRequest, String.valueOf(emailTemplateMaster.getTemplateId()), "attachment" + i);
							title = Validator.isNotNull(fileParamsMap.get(EmailTemplateMasterConstants.TITLE)) ? (String) fileParamsMap.get(EmailTemplateMasterConstants.TITLE) : StringPool.BLANK;
							uploadFilesInDocumentLibrary(fileParamsMap, uploadPortletRequest, actionRequest, themeDisplay);
							log.info("Uploaded Files In Document Library" + fileParamsMap.get(EmailTemplateMasterConstants.TITLE));
						}catch(DuplicateFileEntryException dfe) {
							log.error("Duplicate file entry found while uploading file in document & media with title : " + title + 
									" templateId : " + templateId + " error message : " + dfe.getMessage());
							SessionErrors.add(actionRequest, "file-is-already-exists-with-title-" + i, 
									LanguageUtil.format(request, "file-is-already-exists-with-title-x", title, false));
							duplicateFileTitleList.add(LanguageUtil.format(request, "file-is-already-exists-with-title-x", title, false));
						}catch(PortalException | SystemException e) {
							log.error("Error while uploading file in document & media with title : " + title + 
									" templateId : " + templateId + " error message : " + e.getMessage());
							SessionErrors.add(actionRequest, "file-upload-error-with-title-" + i, 
									LanguageUtil.format(request, "file-upload-error-with-title-x", title, false));
							errorFileTitleList.add(LanguageUtil.format(request, "file-upload-error-with-title-x", title, false));
						}
					}
					
					for(int i=0; i<deletedFileEntryIds.length; i++) {
						long deleteFileEntryId = deletedFileEntryIds[i];
						DLAppLocalServiceUtil.deleteFileEntry(deleteFileEntryId);
					}
					
				}catch(PortalException | SystemException e) {
					log.error("Error while adding/deleting files in document & media. Error message : " + e.getMessage());
				}finally {
					if(duplicateFileTitleList.size() > 0 || errorFileTitleList.size() > 0 || !duplicateFileTitleList.isEmpty() || !errorFileTitleList.isEmpty()) {
						actionResponse.setRenderParameter(OMSBEmailTemplateMasterCommonConstants.ACTION, OMSBEmailTemplateMasterCommonConstants.EDIT);
						actionResponse.setRenderParameter(EmailTemplateMasterConstants.TEMPLATE_IDX, String.valueOf(templateId));
					}
				}
				
			}
			boolean isTemplateExists = false;
			for(EmailTemplateMaster em : emailTemplateMasters) {
				String existTemplateName = em.getTemplateName();
				if(existTemplateName.equals(templateName) && emailTemplateMaster.getTemplateId() != em.getTemplateId()) {
					isTemplateExists = true;
					isEmailTemplateSaved = false;
					break;
				} 
			}
			
			if(!isTemplateExists) {
				emailTemplateMaster = _emailTemplateMasterLocalService.updateEmailTemplateMaster(emailTemplateMaster);
				isEmailTemplateSaved = true;
			} else {
				actionResponse.setRenderParameter(EmailTemplateMasterConstants.TEMPLATE_EXISTS, "true");
			}
			
		}
		return isEmailTemplateSaved;
	}
	
	private static long uploadFilesInDocumentLibrary(Map<String, Object> fileParamsMap, UploadPortletRequest uploadPortletRequest, 
			PortletRequest portletRequest, ThemeDisplay themeDisplay) throws DuplicateFileEntryException, PortalException, SystemException{
		
		String fileName, emailTemplateId;
		String description = StringPool.BLANK;
		String title = StringPool.BLANK;
		File uploadedFile;
		Folder emailTemplatesFolder = null;
		Folder emailTemplateIdFolder = null;
		
		uploadedFile = (File) fileParamsMap.get(EmailTemplateMasterConstants.UPLOADED_FILE);
		title = (String) fileParamsMap.get(EmailTemplateMasterConstants.TITLE);
		fileName = (String) fileParamsMap.get(EmailTemplateMasterConstants.FILE_NAME);
		emailTemplateId = (String) fileParamsMap.get(EmailTemplateMasterConstants.EMAIL_TEMPLATE_ID);
		ServiceContext serviceContext;
		
		if(Validator.isNotNull(title) && Validator.isNotNull(fileName) && Validator.isNotNull(uploadedFile) && Validator.isNotNull(emailTemplateId)) {
			
			serviceContext = ServiceContextFactory.getInstance(FileEntry.class.getName(), portletRequest);
			serviceContext.setAddGroupPermissions(true);
			Long rootFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			long guestGroupId = themeDisplay.getScopeGroupId();
			long userId = themeDisplay.getUserId();
			emailTemplatesFolder = _omsbEmailTemplateMasterCommonApi.getDLFolder(guestGroupId, userId, portletRequest, OMSBEmailTemplateMasterCommonConstants.EMAIL_TEMPLATES, rootFolderId);
			
			if(Validator.isNotNull(emailTemplatesFolder)) {
				emailTemplateIdFolder = _omsbEmailTemplateMasterCommonApi.getDLFolder(guestGroupId, userId, portletRequest, emailTemplateId, emailTemplatesFolder.getFolderId());
			}
			
			if(Validator.isNotNull(emailTemplateIdFolder)) {
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, guestGroupId, emailTemplateIdFolder.getFolderId(), 
						 fileName, MimeTypesUtil.getContentType(uploadedFile), title, description, StringPool.BLANK, uploadedFile, serviceContext);
				log.info("File saved successfully with title : " + title + " fileName : " + fileName + " emailTemplateId : " + emailTemplateId + 
						" in document & media.");
				return fileEntry.getFileEntryId();
			}
			
		}
		
		return 0;

	}
	
	private static Map<String, Object> getFileParams(UploadPortletRequest uploadPortletRequest, String emailTemplateId, 
			String requestParam) {
		
		Map<String, Object> fileParamsMap = new HashMap<>();
		String fileName, title;
		File uploadedFile;
		
		uploadedFile = uploadPortletRequest.getFile(requestParam);
		fileName = uploadPortletRequest.getFileName(requestParam);
		title = fileName;
		
		fileParamsMap.put(EmailTemplateMasterConstants.UPLOADED_FILE, uploadedFile);
		fileParamsMap.put(EmailTemplateMasterConstants.FILE_NAME, fileName);
		fileParamsMap.put(EmailTemplateMasterConstants.TITLE, title);
		fileParamsMap.put(EmailTemplateMasterConstants.EMAIL_TEMPLATE_ID, emailTemplateId);
		
		return fileParamsMap;
	}
	
	private static JSONObject createEncryptedValueJSON(String en_USKey, String ar_SAKey) {
		
		JSONObject valuesJSON = JSONFactoryUtil.createJSONObject();
		valuesJSON.put(EmailTemplateMasterConstants.EN_US_LANGUAGEID, new String(java.util.Base64.getEncoder().encode(en_USKey.getBytes())));
		valuesJSON.put(EmailTemplateMasterConstants.AR_SA_LANGUAGEID, new String(java.util.Base64.getEncoder().encode(ar_SAKey.getBytes())));

		return valuesJSON;
	}
	
}
