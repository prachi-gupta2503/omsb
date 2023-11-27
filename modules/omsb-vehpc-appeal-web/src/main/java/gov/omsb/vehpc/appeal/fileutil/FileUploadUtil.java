package gov.omsb.vehpc.appeal.fileutil;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Calendar;

import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;

public class FileUploadUtil {

	private static final Log logger = LogFactoryUtil.getLog(FileUploadUtil.class);
	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	/**
	 * 
	 * @param uploadPortletRequest
	 * @param folderName
	 * @return
	 */
	public static Folder createNewFolder(UploadPortletRequest uploadPortletRequest, String folderName, long parentFolderId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					uploadPortletRequest);
			serviceContext.setAddGroupPermissions(true);
			logger.info("Creating folder name with this name- - - >" + folderName);
			folder = DLAppLocalServiceUtil.addFolder("", themeDisplay.getUserId(), repositoryId,
					parentFolderId , folderName, ROOT_FOLDER_DESCRIPTION, serviceContext);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return folder;
	}

	/**
	 * 
	 * @param uploadPortletRequest
	 * @param folderName
	 * @return
	 */
	public static Folder getFolder(UploadPortletRequest uploadPortletRequest, String folderName, long parentFolderId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId , folderName);
			logger.info(folderName + " Exist >>>>>>>");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return folder;
	}

	/**
	 * 
	 * @param fileEntryId
	 * @param themeDisplay
	 * @return this method returns File Url
	 * @throws PortalException
	 */
	public static String getFileUrlByFileEntry(long fileEntryId, ThemeDisplay themeDisplay) throws PortalException {
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
		String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
				+ themeDisplay.getScopeGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle();
		return url;
	}

	/**
	 * 
	 * @param uploadRequest
	 * @param themeDisplay
	 * @param DocumentName
	 * @return
	 */
	public static long addDocument(UploadRequest uploadRequest, long groupId, String documentName, long folderId) {
		String uploadedFileName = uploadRequest.getFileName(documentName);
		FileEntry fileEntry = null;
		File file = uploadRequest.getFile(documentName);
		String mimeType = uploadRequest.getContentType(documentName);
		String title = uploadRequest.getFileName(documentName) + Calendar.getInstance().getTimeInMillis();
		String description = "This file is added via programatically.";
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),uploadRequest);
			serviceContext.setAddGroupPermissions(true);
			fileEntry = DLAppServiceUtil.addFileEntry(groupId, folderId, uploadedFileName, mimeType, title, description, "", file, serviceContext);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(fileEntry)) {
			return fileEntry.getFileEntryId();
		}
		return 0;
	}
	
	public Folder createFolderStructure(UploadPortletRequest uploadPortletRequest, long personId) {
		String folderName = CommonConstants.PARENT_FOLDER_NAME;
		long parentFolderId = 0;
		Folder personFolder = null;
		String vehpcDocName = AppealConstants.VEHPC_APPEAL_FOLDER_NAME; 
		Folder appealFolder = null;
		Folder parentFolder = FileUploadUtil.getFolder(uploadPortletRequest, folderName, parentFolderId);
		if (Validator.isNull(parentFolder)) {
			 parentFolder = FileUploadUtil.createNewFolder(uploadPortletRequest, folderName , parentFolderId);
		} 
		if (Validator.isNotNull(parentFolder)) {
			personFolder = FileUploadUtil.getFolder(uploadPortletRequest, String.valueOf(personId), parentFolder.getFolderId());
			if (Validator.isNull(personFolder)) {
				personFolder = FileUploadUtil.createNewFolder(uploadPortletRequest, String.valueOf(personId) , personFolder.getFolderId());
			}
		}
		if (Validator.isNotNull(personFolder)) {
			appealFolder = FileUploadUtil.getFolder(uploadPortletRequest, vehpcDocName, personFolder.getFolderId());
			if (Validator.isNull(appealFolder)) {
				appealFolder = FileUploadUtil.createNewFolder(uploadPortletRequest, vehpcDocName , personFolder.getFolderId());
			}
		}
		
		return appealFolder;
	}
	
	
	
	@Reference(unbind = "-")
	private AppealUtil appealUtil;
	
}
