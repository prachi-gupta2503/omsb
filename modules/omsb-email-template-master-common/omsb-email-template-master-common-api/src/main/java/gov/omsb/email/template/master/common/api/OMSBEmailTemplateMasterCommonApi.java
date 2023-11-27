package gov.omsb.email.template.master.common.api;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;

/**
 * @author Niddhi Thacker
 */
public interface OMSBEmailTemplateMasterCommonApi {
	
	HashMap<String, String> getDataTableParams(PortletRequest portletRequest);
	
	public long getTemplateIdByName(String templateName);
	
	public String getCombinedBodyById(long templateId, String languageId, Map<String, String> keyValueMap);
	
	public void sendEmailWithAttachments(String senderEmail, String recieverEmail, String subject, String body, List<File> attachments, String[] ccAddress, String[] bccAddress);
	
	public void sendEmail(String fromAddress, String toAddress, String subject, String body, String[] ccAddress, String[] bccAddress);
	
	public String replaceEmailTemplate(String emailTemplate, Map<String, String> keyValueMap);
	
	String getUserName(long userId);
	
	String getFormatedDateTime(Date date);
	
	String getEmailTemplateAttachmentUploadLimit(long groupId, long companyId);
	
	List<Map<String, Object>> getEmailTemplateAttachmentFiles(PortletRequest portletRequest, ThemeDisplay themeDisplay, long groupId, long emailTemplateId);
	
	Folder getDLFolder(long groupId, long userId, PortletRequest portletRequest, String folderName, Long parentFolderId) throws PortalException, SystemException;
	
	AssetVocabulary getAssetVocabulary(PortletRequest portletRequest, ThemeDisplay themeDisplay, String title) throws PortalException;
	
	AssetCategory getAssetCategory(PortletRequest portletRequest, ThemeDisplay themeDisplay, String name, long vocabularyId, long parentCategoryId) throws PortalException;
	
	List<File> fetchEmailTemplateAttachments(long emailTemplateMasterId, long groupId);
	
	public boolean sendEmailByTemplateId(long templateId, String toAddress, String languageId, Map<String, String> paramValueMap);
	
	public EmailTemplateMasterDTO getEmailTemplateMasterDTOByName(String templateName);
	
	public JSONObject getNotificationPayloadWithLink(User senderUser, User reciverUser, String notificationEN, String notificationAR, String renderLink, Map<String, String> notificationParamsEN, Map<String, String> notificationParamsAR);
}