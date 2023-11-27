package gov.omsb.tms.ecm.web.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import gov.omsb.common.util.FileUploadUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import org.osgi.service.component.annotations.Component;

import gov.omsb.common.util.FileUploadUtil;

@Component(immediate = true, service = AddEditMemberDetailsUtil.class)
public class AddEditMemberDetailsUtil {
	private static final Log log = LogFactoryUtil.getLog(AddEditMemberDetailsUtil.class);

	public static List<FileEntry> fileUpload(long groupId, ActionRequest actionRequest) throws PortalException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		log.info("file------" + files);
		List<FileEntry> fileEntryList = new ArrayList<>();
		;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		for (FileItem[] items : files.values()) {
			for (FileItem fileItem : items) {
				String title = fileItem.getFileName();
				String fileName = fileItem.getFileName() + Clock.systemDefaultZone().millis();
				String description = fileItem.getFieldName();
				if (description.contains("passportId")) {
					description = "passportCopy";
					log.info("field name" + description);
				} else if (description.contains("nationalId")) {
					description = "nationalId";
					log.info("field name" + description);
				}
				String mimeType = fileItem.getFileName();
				InputStream inputStream = null;
				try {
					inputStream = fileItem.getInputStream();
				} catch (IOException e) {
					log.error("Multiple File Upload inputstream ");
				}
				try {
					FileEntry addFileEntry = DLAppServiceUtil.addFileEntry("", groupId,
							DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, fileName, mimeType, fileName, "", description,
							"", inputStream, fileItem.getSize(), null, null, serviceContext);
					fileEntryList.add(addFileEntry);
				} catch (PortalException e) {
					log.error("Multiple file upload file entry error", e);
				}
			}
		}
		return fileEntryList;
	}

	public static List<String> getCustomCountry(ThemeDisplay themeDisplay, String objectTableName) {
		List<String> countries = new ArrayList<>();
		try {
			List<ObjectDefinition> objectDefinitionList = ObjectDefinitionLocalServiceUtil.getObjectDefinitions(-1, -1);
			for (ObjectDefinition objectDefinition : objectDefinitionList) {
				if (objectDefinition.getName().equalsIgnoreCase(objectTableName)) {
					long scopeGroupId = themeDisplay.getScopeGroupId();
					long objectDefinitionId = objectDefinition.getObjectDefinitionId();
					List<ObjectEntry> entries = ObjectEntryLocalServiceUtil.getObjectEntries(scopeGroupId,
							objectDefinitionId, -1, -1);
					for (ObjectEntry entry : entries) {
						Map<String, Serializable> values = ObjectEntryLocalServiceUtil.getValues(entry);
						String nationality = (String) values.get("nationality");
						if (nationality != null) {
							countries.add(nationality);
						}
					}
					break;
				}
			}
		} catch (PortalException e) {
			log.error("Error occurred while retrieving custom country data", e);
		}

		return countries;
	}

	public static ObjectEntry addDocumentsDetails(long groupId, long userId, long personId, Map<String, Serializable> values,
			String objectName) {
		ObjectEntry addObjectEntry = null;
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		List<ObjectDefinition> objectDefinitionList = ObjectDefinitionLocalServiceUtil.getObjectDefinitions(-1, -1);
		log.info("objectDefinitionList" + objectDefinitionList);
		for (ObjectDefinition objectDefinition : objectDefinitionList) {
			if (objectDefinition.getName().equalsIgnoreCase(objectName)) {
				try {
					addObjectEntry = ObjectEntryLocalServiceUtil.addObjectEntry(userId, groupId,
							objectDefinition.getObjectDefinitionId(), values, serviceContext);
					log.info("Add Documents");
				} catch (PortalException e) {
					log.error("Error occurred while adding data into document info", e);
					return null;
				}
				break;
			}
		}
		return addObjectEntry;
	}

	public static List<Map<String, Serializable>> getDocumentInfoDetails(ThemeDisplay themeDisplay, String objectName)
			throws PortalException {
		List<ObjectDefinition> objectDefinitionList = ObjectDefinitionLocalServiceUtil.getObjectDefinitions(-1, -1);
		List<Map<String, Serializable>> documentInfoValuesList = new ArrayList<>();
		Map<String, Serializable> documentInfoValues = new HashMap<String, Serializable>();
		for (ObjectDefinition objectDefinition : objectDefinitionList) {
			if (objectDefinition.getName().equalsIgnoreCase(objectName)) {
				List<ObjectEntry> objectEntries = ObjectEntryLocalServiceUtil.getObjectEntries(
						themeDisplay.getScopeGroupId(), objectDefinition.getObjectDefinitionId(), -1, -1);
				if (objectEntries.size() == 0) {
					return null;
				}
				for (ObjectEntry obj : objectEntries) {
					documentInfoValuesList.add(obj.getValues());
					log.info(" getDocumentInfoDetails Get Values ::");
				}
				break;
			}
		}
		return documentInfoValuesList;
	}

	public static FileEntry uploadSingleFile(long groupId, String title, String fileName, String description,
			long userId, String contentType, File file) {
		DLFolder dLFolder1 = null;
		FileEntry fileEntry = null;
		ServiceContext serviceContext = new ServiceContext();
		try {
			DLFolder dLFolder = FileUploadUtil.getDLFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"Qualification_Documents");
			if (dLFolder == null) {
				dLFolder1 = FileUploadUtil.createDLFolder(groupId, "Qualification_Documents", 0, userId,
						StringPool.BLANK);
				fileEntry = DLAppServiceUtil.addFileEntry(groupId, dLFolder1.getFolderId(), fileName, contentType,
						fileName, description, "", file, serviceContext);
			} else {
				fileEntry = DLAppServiceUtil.addFileEntry(groupId, dLFolder.getFolderId(), fileName, contentType,
						fileName, description, "", file, serviceContext);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileEntry;

	}

}
