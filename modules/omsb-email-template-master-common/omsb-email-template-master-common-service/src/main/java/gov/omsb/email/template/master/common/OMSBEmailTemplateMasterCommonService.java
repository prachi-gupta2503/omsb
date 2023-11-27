package gov.omsb.email.template.master.common;

import com.liferay.asset.kernel.exception.NoSuchVocabularyException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.petra.string.StringPool;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.constants.OMSBEmailTemplateMasterCommonConstants;
import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;
import gov.omsb.email.template.master.exception.NoSuchEmailTemplateMasterException;
import gov.omsb.email.template.master.model.EmailTemplateMaster;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalService;

/**
 * @author Niddhi Thacker
 */
@Component(immediate = true, service = OMSBEmailTemplateMasterCommonApi.class)

public class OMSBEmailTemplateMasterCommonService implements OMSBEmailTemplateMasterCommonApi {

	private static final Log log = LogFactoryUtil.getLog(OMSBEmailTemplateMasterCommonService.class);
	
	public EmailTemplateMasterDTO getEmailTemplateMasterDTOByName(String templateName) {
		try {
			EmailTemplateMaster emailTemplateMaster = emailTemplateMasterLocalService.findByTemplateName(templateName);
			if(Validator.isNotNull(emailTemplateMaster)) {
				String dynamicBody = emailTemplateMaster.getDynamicBody();
				String staticBody = emailTemplateMaster.getStaticBody();
				String signature = emailTemplateMaster.getSignature();
				String subject = emailTemplateMaster.getSubject();
				String userNotification = emailTemplateMaster.getUserNotification();
				JSONObject dynamicBodyJSON;
				JSONObject staticBodyJSON;
				JSONObject signatureJSON;
				JSONObject userNotificationJSON;
				JSONObject subjectJSON;
				String dynamicbodyEnUS;
				String dynamicbodyArSA;
				String staticbodyEnUS;
				String staticbodyArSA;
				String signatureEnUS;
				String signatureArSA;
				String userNotificationEnUS;
				String userNotificationArSA;
				String subjectEnUS;
				String subjectArSA;
				
				dynamicBodyJSON = JSONFactoryUtil.createJSONObject(dynamicBody);
				staticBodyJSON = JSONFactoryUtil.createJSONObject(staticBody);
				signatureJSON = JSONFactoryUtil.createJSONObject(signature);
				userNotificationJSON = JSONFactoryUtil.createJSONObject(userNotification);
				subjectJSON = JSONFactoryUtil.createJSONObject(subject);
				
				subjectEnUS = new String(java.util.Base64.getDecoder().decode(subjectJSON.getString(OMSBEmailTemplateMasterCommonConstants.EN_US)));
				subjectArSA = new String(java.util.Base64.getDecoder().decode(subjectJSON.getString(OMSBEmailTemplateMasterCommonConstants.AR_SA)));
				
				dynamicbodyEnUS = new String(java.util.Base64.getDecoder().decode(dynamicBodyJSON.getString(OMSBEmailTemplateMasterCommonConstants.EN_US)));
				dynamicbodyArSA = new String(java.util.Base64.getDecoder().decode(dynamicBodyJSON.getString(OMSBEmailTemplateMasterCommonConstants.AR_SA)));
				
				staticbodyEnUS = new String(java.util.Base64.getDecoder().decode(staticBodyJSON.getString(OMSBEmailTemplateMasterCommonConstants.EN_US)));
				staticbodyArSA = new String(java.util.Base64.getDecoder().decode(staticBodyJSON.getString(OMSBEmailTemplateMasterCommonConstants.AR_SA)));
				
				signatureEnUS = new String(java.util.Base64.getDecoder().decode(signatureJSON.getString(OMSBEmailTemplateMasterCommonConstants.EN_US)));
				signatureArSA = new String(java.util.Base64.getDecoder().decode(signatureJSON.getString(OMSBEmailTemplateMasterCommonConstants.AR_SA)));
				
				userNotificationEnUS = new String(java.util.Base64.getDecoder().decode(userNotificationJSON.getString(OMSBEmailTemplateMasterCommonConstants.EN_US)));
				userNotificationArSA = new String(java.util.Base64.getDecoder().decode(userNotificationJSON.getString(OMSBEmailTemplateMasterCommonConstants.AR_SA)));
				
				EmailTemplateMasterDTO emailTemplateMasterDTO = new EmailTemplateMasterDTO();
				emailTemplateMasterDTO.setCreatedBy(emailTemplateMaster.getCreatedBy());
				emailTemplateMasterDTO.setCreatedDate(emailTemplateMaster.getCreatedDate());
				emailTemplateMasterDTO.setCompanyId(emailTemplateMaster.getCompanyId());
				emailTemplateMasterDTO.setModifiedBy(emailTemplateMaster.getModifiedBy());
				emailTemplateMasterDTO.setModifiedDate(emailTemplateMaster.getModifiedDate());
				emailTemplateMasterDTO.setGroupId(emailTemplateMaster.getGroupId());
				emailTemplateMasterDTO.setTemplateId(emailTemplateMaster.getTemplateId());
				emailTemplateMasterDTO.setTemplateName(templateName);
				emailTemplateMasterDTO.setTemplateDescription(emailTemplateMaster.getTemplateDescription());
				emailTemplateMasterDTO.setSenderType(emailTemplateMaster.getSenderType());
				emailTemplateMasterDTO.setSenderEmailId(emailTemplateMaster.getSenderEmailId());
				emailTemplateMasterDTO.setDefaultCC(emailTemplateMaster.getDefaultCC());
				emailTemplateMasterDTO.setDefaultBCC(emailTemplateMaster.getDefaultBCC());
				emailTemplateMasterDTO.setDynamicBodyEnUS(dynamicbodyEnUS);
				emailTemplateMasterDTO.setDynamicBodyArSA(dynamicbodyArSA);
				emailTemplateMasterDTO.setStaticBodyEnUS(staticbodyEnUS);
				emailTemplateMasterDTO.setStaticBodyArSA(staticbodyArSA);
				emailTemplateMasterDTO.setSignatureEnUS(signatureEnUS);
				emailTemplateMasterDTO.setSignatureArSA(signatureArSA);
				emailTemplateMasterDTO.setUserNotificationEnUS(userNotificationEnUS);
				emailTemplateMasterDTO.setUserNotificationArSA(userNotificationArSA);
				emailTemplateMasterDTO.setSubjectEnUS(subjectEnUS);
				emailTemplateMasterDTO.setSubjectArSA(subjectArSA);
				log.info("::::: Details saved in emailTemplateMasterDTO ::::");
				return emailTemplateMasterDTO;
			} 
		} catch(NoSuchEmailTemplateMasterException e) {
			log.error("NoSuchEmailTemplateMaster Found :::: "+e.getMessage());
		} catch (JSONException e) {
			log.error("JSONExeception Found :::: "+e.getMessage());
		}
		return null;
	}
	
	public long getTemplateIdByName(String templateName) {
		EmailTemplateMaster emailTemplateMaster = null;
		try {
			emailTemplateMaster = emailTemplateMasterLocalService.findByTemplateName(templateName);
			if(Validator.isNotNull(emailTemplateMaster)) {
				return emailTemplateMaster.getTemplateId();
			} 
		} catch (NoSuchEmailTemplateMasterException e) {
			log.error("NoSuchEmailTemplateMaster Found :::: "+e.getMessage());
		}
		return 0l;
	}
	
	public String getCombinedBodyById(long templateId, String languageId, Map<String, String> keyValueMap) {
		EmailTemplateMaster emailTemplateMaster = emailTemplateMasterLocalService.fetchEmailTemplateMaster(templateId);
		if(Validator.isNotNull(emailTemplateMaster)) {
			String dynamicBody = emailTemplateMaster.getDynamicBody();
			String staticBody = emailTemplateMaster.getStaticBody();
			String signature = emailTemplateMaster.getSignature();
			
			JSONObject signatureJSON;
			JSONObject staticBodyJSON;
			JSONObject dynamicBodyJSON;
			String dynamicBodyVal = StringPool.BLANK;
			String staticBodyVal = StringPool.BLANK;
			String signatureVal = StringPool.BLANK;
			String updatedEmailBody = StringPool.BLANK;
			try {
				signatureJSON = JSONFactoryUtil.createJSONObject(signature);
				dynamicBodyJSON = JSONFactoryUtil.createJSONObject(dynamicBody);
				staticBodyJSON = JSONFactoryUtil.createJSONObject(staticBody);
				if(languageId.equals("en_US") || languageId.equals("ar_SA")){
					dynamicBodyVal = new String(java.util.Base64.getDecoder().decode(dynamicBodyJSON.getString(languageId)));
					staticBodyVal = new String(java.util.Base64.getDecoder().decode(staticBodyJSON.getString(languageId)));
					signatureVal = new String(java.util.Base64.getDecoder().decode(signatureJSON.getString(languageId)));
				} 
				updatedEmailBody = replaceEmailTemplate(dynamicBodyVal + staticBodyVal + signatureVal, keyValueMap);
				log.info("updatedEmailBody from common ::::: " + updatedEmailBody);
				return updatedEmailBody;
			} catch (JSONException e) {
				log.error("Exception Occurred ::::: "+e.getMessage());
			}
		}
		return null;
	}
	
	public boolean sendEmailByTemplateId(long templateId, String toAddress, String languageId, Map<String, String> keyValueMap) {
		EmailTemplateMaster emailTemplateMaster = emailTemplateMasterLocalService.fetchEmailTemplateMaster(templateId);
		if(Validator.isNotNull(emailTemplateMaster)) {
			String subject = emailTemplateMaster.getSubject();
			String[] cc = null;
			String[] bcc = null;
			if(Validator.isNotNull(emailTemplateMaster.getDefaultCC()) && !emailTemplateMaster.getDefaultCC().equalsIgnoreCase(StringPool.BLANK)) {
				 cc = emailTemplateMaster.getDefaultCC().split(",");
			} 
			if(Validator.isNotNull(emailTemplateMaster.getDefaultBCC()) && !emailTemplateMaster.getDefaultBCC().equalsIgnoreCase(StringPool.BLANK)) {
				 bcc = emailTemplateMaster.getDefaultBCC().split(",");
			}
			JSONObject subjectJSON;
			String subjectVal = StringPool.BLANK;
			String updatedEmailBody = StringPool.BLANK;
			try {
				subjectJSON = JSONFactoryUtil.createJSONObject(subject);
				
				if(languageId.equals("en_US") || languageId.equals("ar_SA")){
					subjectVal = new String(java.util.Base64.getDecoder().decode(subjectJSON.getString(languageId)));
				} 
				subjectVal = replaceEmailTemplate(subjectVal, keyValueMap);
				updatedEmailBody = getCombinedBodyById(templateId, languageId, keyValueMap);
				log.info("updatedEmailBody from common ::::: " + updatedEmailBody);
				List<File> templateAttachments = fetchEmailTemplateAttachments(templateId, emailTemplateMaster.getGroupId());
				sendEmailWithAttachments(PrefsPropsUtil.getString(emailTemplateMaster.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS), toAddress, subjectVal, updatedEmailBody, templateAttachments, cc, bcc);
				return true;
			} catch (JSONException e) {
				log.error("Exception Occurred ::::: "+e.getMessage());
			}
		}
		return false;
	}
	
	
	public void sendEmailWithAttachments(String senderEmail, String recieverEmail, String subject, String body, List<File> attachments, String[] ccAddress, String[] bccAddress) {
		try {
			log.info("Sending Email");
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(senderEmail));
			mailMessage.setTo(new InternetAddress(recieverEmail));
			setCCAddress(ccAddress, mailMessage);
			setBCCAddress(bccAddress, mailMessage);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			if(Validator.isNotNull(attachments) && !attachments.isEmpty()) {
				for(File file : attachments) {
					mailMessage.addFileAttachment(file);
				}
			}
			mailService.sendEmail(mailMessage);
			log.info("Email Sent successfully");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public void setBCCAddress(String[] bccAddress, MailMessage mailMessage) throws AddressException {
		if(Validator.isNotNull(bccAddress) && bccAddress.length>0) {				
			InternetAddress[] bcc = new InternetAddress[bccAddress.length];
			boolean isBCC = false;
			for(int i=0; i<bccAddress.length; i++) {
				if(Validator.isNotNull(bccAddress[i])) {
					InternetAddress bccInternetAddress = new InternetAddress(bccAddress[i]);
					bcc[i] = bccInternetAddress;
					isBCC = true;
				}
			}
			if(isBCC) {
				mailMessage.setBCC(bcc);
			}
		}
	}

	public void setCCAddress(String[] ccAddress, MailMessage mailMessage) throws AddressException {
		if(Validator.isNotNull(ccAddress) && ccAddress.length>0) {				
			InternetAddress[] cc = new InternetAddress[ccAddress.length];
			boolean isCC = false;
			for(int i=0; i<ccAddress.length; i++) {
				if(Validator.isNotNull(ccAddress[i])) {
					InternetAddress ccInternetAddress = new InternetAddress(ccAddress[i]);
					cc[i] = ccInternetAddress;
					isCC = true;
				}
			}
			if(isCC) {
				mailMessage.setCC(cc);
			}
		}
	}
	
	public void sendEmail(String fromAddress, String toAddress, String subject, String body, String[] ccAddress, String[] bccAddress) {
		try {
			log.info("Sending Email");
			MailMessage mailMessage = new MailMessage();
			InternetAddress from = new InternetAddress(fromAddress);
			InternetAddress to = new InternetAddress(toAddress);
			setCCAddress(ccAddress, mailMessage);
			setBCCAddress(bccAddress, mailMessage);
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			mailService.sendEmail(mailMessage);
			log.info("Email Sent Successfully");
		} catch (AddressException e) {
			log.error("Error While Sending EMail :: " + e.getMessage());
		}
	}
	
	
	public String replaceEmailTemplate(String emailTemplate, Map<String, String> keyValueMap) {
		for(Entry<String, String> entry: keyValueMap.entrySet()) {
			emailTemplate = StringUtil.replace(emailTemplate, "[$" + entry.getKey() + "$]", entry.getValue());
		}
		return emailTemplate;
	}
	
	
	public List<File> fetchEmailTemplateAttachments(long emailTemplateMasterId, long groupId) {
		String folderName = "Email Templates";
		List<DLFileEntry> dlFileEntries = null;
		List<File> attachments = new ArrayList<>();
		try {
			DLFolder dlFolder = dlFolderLocalService.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
			long dfFolderId = dlFolder.getFolderId();
			if(Validator.isNotNull(dlFolder)) {
				DLFolder templateFolder = dlFolderLocalService.getFolder(groupId, dfFolderId, String.valueOf(emailTemplateMasterId));
				long templateFolderId = templateFolder.getFolderId();
				dlFileEntries = dlFileEntryLocalService.getFileEntries(groupId, templateFolderId);
				for(DLFileEntry dlFileEntry : dlFileEntries) {
					InputStream iStream = dlFileEntryLocalService.getFileAsStream(dlFileEntry.getFileEntryId(), dlFileEntry.getVersion(),true);
					String dlFileName = dlFileEntry.getFileName();
			        String[] fileName = dlFileName.split("\\.");
					File outputFile = File.createTempFile(fileName[0], "."+dlFileEntry.getExtension());
					Files.copy(iStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					attachments.add(outputFile);
				}
				log.info("dlFileEntries ::: " +dlFileEntries);
			} 
		} catch (Exception e) {
			log.error("Error while fetching DL folder - " + folderName);
			e.printStackTrace();
		}
		return attachments;
	}
	
	public HashMap<String, String> getDataTableParams(PortletRequest portletRequest) {

		HashMap<String, String> dataTableParams = new HashMap<>();

		String start = ParamUtil.getString(portletRequest, OMSBEmailTemplateMasterCommonConstants.START);
		String draw = ParamUtil.getString(portletRequest, OMSBEmailTemplateMasterCommonConstants.DRAW);
		String length = ParamUtil.getString(portletRequest, OMSBEmailTemplateMasterCommonConstants.LENGTH);
		int orderColumnInd = ParamUtil.getInteger(portletRequest, OMSBEmailTemplateMasterCommonConstants.ORDER_COLUMN);
		String orderColumn = ParamUtil.getString(portletRequest, "columns[" + orderColumnInd + "][name]");
		String orderDir = ParamUtil.getString(portletRequest, OMSBEmailTemplateMasterCommonConstants.ORDER_DIR);

		log.debug("Datatable pagination start -> " + start + " : length -> " + length);

		dataTableParams.put(OMSBEmailTemplateMasterCommonConstants.START, start);
		dataTableParams.put(OMSBEmailTemplateMasterCommonConstants.DRAW, draw);
		dataTableParams.put(OMSBEmailTemplateMasterCommonConstants.LENGTH, length);
		dataTableParams.put(OMSBEmailTemplateMasterCommonConstants.ORDER_COLUMN, orderColumn);
		dataTableParams.put(OMSBEmailTemplateMasterCommonConstants.ORDER_DIR, orderDir);
		log.debug("Datatable Draw -> " + dataTableParams.get(draw));

		return dataTableParams;
	}

	public String getUserName(long userId) {
		User user = null;
		try {
			user = userLocalService.getUser(userId);
		} catch (PortalException e) {
			log.error("Error while fetching user name with user id :" + userId);
		}
		return Validator.isNotNull(user) ? user.getFullName() : StringPool.BLANK;
	}

	public String getFormatedDateTime(Date date) {
		if (Validator.isNotNull(date)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(OMSBEmailTemplateMasterCommonConstants.FROM_DATE_FORMAT);
			return simpleDateFormat.format(date);
		}
		return StringPool.BLANK;
	}

	public String getEmailTemplateAttachmentUploadLimit(long groupId, long companyId) {
		 return OMSBEmailTemplateMasterCommonConstants.DEFAULT_EMAIL_TEMPLATE_ATTACHMENT_UPLOAD_LIMIT;
	}
	
	public List<Map<String, Object>> getEmailTemplateAttachmentFiles(PortletRequest portletRequest, ThemeDisplay themeDisplay, long groupId, long emailTemplateId) {
		List<FileEntry> fileEntries = null;
		Folder emailTemplatesFolder = null;
		Folder emailTemplateIdFolder = null;
		List<Map<String, Object>> fileEntriesMapList = new ArrayList<>();

		try {

			Long rootFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			long guestGroupId = themeDisplay.getScopeGroupId();
			long userId = themeDisplay.getUserId();

			emailTemplatesFolder = getDLFolder(guestGroupId, userId, portletRequest, OMSBEmailTemplateMasterCommonConstants.EMAIL_TEMPLATES, rootFolderId);

			if (Validator.isNotNull(emailTemplatesFolder)) {
				emailTemplateIdFolder = getDLFolder(guestGroupId, userId, portletRequest, String.valueOf(emailTemplateId), emailTemplatesFolder.getFolderId());
			}

			if (Validator.isNotNull(emailTemplateIdFolder)) {
				fileEntries = dlAppService.getFileEntries(groupId, emailTemplateIdFolder.getFolderId());
			}

			if (Validator.isNotNull(fileEntries) && !fileEntries.isEmpty()) {

				for (FileEntry fileEntry : fileEntries) {
					log.info("File Entry Title + " +fileEntry.getTitle());
					Map<String, Object> fileEntryMap = new HashMap<>();
					String previewURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK);
					fileEntryMap.put("title", fileEntry.getTitle());
					fileEntryMap.put("fileEntryId", fileEntry.getFileEntryId());
					fileEntryMap.put("previewURL", previewURL);
					fileEntriesMapList.add(fileEntryMap);

				}
			}

			log.info("Email template attachment files fetched successfully");

		} catch (PortalException | SystemException e) {
			log.error("Error while fetching email template attachment files : " + e.getMessage());
		}

		return fileEntriesMapList;
	}

	public Folder getDLFolder(long groupId, long userId, PortletRequest portletRequest, String folderName, Long parentFolderId) throws PortalException, SystemException {

		Folder folder = null;
		try {
			folder = dlAppLocalService.getFolder(groupId, parentFolderId, folderName);
		} catch (PortalException | SystemException e) {
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), portletRequest);
				serviceContext.setAddGroupPermissions(true);
				serviceContext.setAddGuestPermissions(false);
				folder = dlAppLocalService.addFolder(StringPool.BLANK, userId, groupId, parentFolderId, folderName, StringPool.BLANK, serviceContext);
			} catch (PortalException | SystemException e1) {
				log.error("Error while creating DLFolder with name : " + folderName + " error message : " + e1.getMessage());
			} 
		}
		return folder;
	}

	public AssetVocabulary getAssetVocabulary(PortletRequest portletRequest, ThemeDisplay themeDisplay, String title) throws PortalException {

		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		AssetVocabulary assetVocabulary = null;

		try {
			assetVocabulary = assetVocabularyLocalService.getGroupVocabulary(groupId, title);
		} catch (NoSuchVocabularyException ne) {
			log.error("No Asset vocabulary found with groupId : " + groupId + " title : " + title + " error message : " + ne.getMessage());
		}

		if (Validator.isNull(assetVocabulary)) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(portletRequest);
			assetVocabulary = assetVocabularyLocalService.addVocabulary(userId, groupId, title, serviceContext);
		}

		return Validator.isNotNull(assetVocabulary) ? assetVocabulary : null;
	}

	
	public AssetCategory getAssetCategory(PortletRequest portletRequest, ThemeDisplay themeDisplay, String name, long vocabularyId, long parentCategoryId) throws PortalException {

		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		AssetCategory assetCategory = null;

		assetCategory = assetCategoryLocalService.fetchCategory(groupId, parentCategoryId, name, vocabularyId);

		if (Validator.isNull(assetCategory)) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(portletRequest);
			assetCategory = assetCategoryLocalService.addCategory(userId, groupId, name, vocabularyId, serviceContext);
		}
		return Validator.isNotNull(assetCategory) ? assetCategory : null;
	}
	
	public JSONObject getNotificationPayloadWithLink(User senderUser, User reciverUser, String notificationEN, String notificationAR, String renderURL, Map<String, String> notificationParamsEN, Map<String, String> notificationParamsAR) {
		
		notificationEN = replaceEmailTemplate(notificationEN, notificationParamsEN);
		notificationAR = replaceEmailTemplate(notificationAR, notificationParamsAR);
		
		JSONObject notificationTextJson = JSONFactoryUtil.createJSONObject();
		notificationTextJson.put(OMSBEmailTemplateMasterCommonConstants.EN_US, notificationEN);
		notificationTextJson.put(OMSBEmailTemplateMasterCommonConstants.AR_SA, notificationAR);
		
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		payload.put(OMSBEmailTemplateMasterCommonConstants.USER_ID, senderUser.getUserId());
		payload.put(OMSBEmailTemplateMasterCommonConstants.NOTIFICATION_TEXT, notificationTextJson.toString());
		payload.put(OMSBEmailTemplateMasterCommonConstants.SENDER_NAME, reciverUser.getFullName());
		if (null != renderURL) {
			payload.put(OMSBEmailTemplateMasterCommonConstants.VIEW_REDIRECT_LINK, renderURL);
		}

		return payload;
	}
	
	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;
	
	@Reference
	private DLFolderLocalService dlFolderLocalService;
	
	@Reference
	private DLFileEntryLocalService dlFileEntryLocalService;
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private DLAppService dlAppService;
	
	@Reference
	private MailService mailService;
	
	@Reference
	private DLAppLocalService dlAppLocalService;
	
	@Reference
	private EmailTemplateMasterLocalService emailTemplateMasterLocalService;

}