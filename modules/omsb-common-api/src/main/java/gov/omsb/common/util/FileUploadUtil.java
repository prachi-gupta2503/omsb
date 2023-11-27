package gov.omsb.common.util;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import gov.omsb.common.constants.CommonConstants;

public class FileUploadUtil {
	private FileUploadUtil() {}
	
	/**
	 * 
	 * @param groupId
	 * @param folderName
	 * @param parentFolderId
	 * @param userId
	 * @param folderDescription
	 * @return This is used to create a folder by folder name and parent folder Id in documents and media
	 */
	public static DLFolder createDLFolder(long groupId, String folderName, long parentFolderId, long userId, String folderDescription) {
		try {
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setUserId(userId);
			serviceContext.setScopeGroupId(groupId);
			logger.info("Creating folder name with this name- - - >" + folderName);
			return DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, userId, groupId,
					groupId, Boolean.FALSE, parentFolderId, folderName, folderDescription, Boolean.FALSE, serviceContext);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param parentFolderId
	 * @param folderName
	 * @return Get DL Folder by folder name and parent folderId from documents and media
	 */
	public static DLFolder getDLFolder(long groupId, long parentFolderId, String folderName) {
		try {
			return DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param folderId
	 * @param fileName
	 * @param mimeType
	 * @param fileDescription
	 * @param file
	 * @return it will help to create a FileEntry in the Documents and Media
	 */
	public static FileEntry createFileEntry(long groupId, long folderId, String fileName, String mimeType, String fileDescription, byte[] file) {
		try {
			Date date = new Date();
			long time = date.getTime();
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setScopeGroupId(groupId);
			logger.info("fileName:::::::"+fileName);
			fileName= System.currentTimeMillis() + fileName;
			logger.info("fileName::::TIMESTAMP:::"+fileName);
			return DLAppServiceUtil.addFileEntry(fileName+ time + StringPool.UNDERLINE + CommonConstants.ERC ,groupId, folderId, fileName, mimeType, fileName, fileName, fileDescription , "", file, null, null, serviceContext);
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param fileName
	 * @param file
	 * @param mimeType
	 * @param groupId
	 * @param folderId
	 * @return FileEntry
	 * this method will return the fileEntry using the File
	 */
	public static FileEntry addDocument(String fileName, File file, String mimeType, long groupId, long folderId) {
		String title = fileName + Calendar.getInstance().getTimeInMillis();
		String description = "This file is added via programatically.";
		try {
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setAddGroupPermissions(true);
			return DLAppServiceUtil.addFileEntry(groupId, folderId, fileName, mimeType, title, description, "", file, serviceContext);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param fileName
	 * @param file
	 * @param mimeType
	 * @param groupId
	 * @param folderId
	 * @return FileEntry
	 * this method will return the fileEntry using the File
	 */
	public static FileEntry addFileEntry(String fileName, File file, String mimeType, long groupId, long folderId) {
		String title = Calendar.getInstance().getTimeInMillis() + fileName;
		try {
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setAddGroupPermissions(true);
			return DLAppServiceUtil.addFileEntry(groupId, folderId, title, mimeType, title, fileName, "", file, serviceContext);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	private static final Log logger = LogFactoryUtil.getLog(FileUploadUtil.class);
}
