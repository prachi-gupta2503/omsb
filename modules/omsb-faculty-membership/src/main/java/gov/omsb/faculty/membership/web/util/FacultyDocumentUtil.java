package gov.omsb.faculty.membership.web.util;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.faculty.membership.web.dto.DocumentInfoDTO;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, service = FacultyDocumentUtil.class)
public class FacultyDocumentUtil {

	public DocumentInfoDTO addDocument(long groupId, long lrUSerId, File file, String fileName, String contentType,
			String description, long personId) {
		FileEntry fileEntry = facultyMemebershipUtil.uploadSingleFile(groupId,
				facultyMemebershipUtil.generateFileName(fileName), description, lrUSerId, contentType, file);
		log.info("fileEntry " + fileEntry);
		DocumentInfoDTO saveDocumentInfo = new DocumentInfoDTO();
		saveDocumentInfo.setId(saveDocumentInfo.getId());
		saveDocumentInfo.setdFFileName(fileName);
		saveDocumentInfo.setDocumentType(description);
		saveDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
		saveDocumentInfo.setPersonId(personId);
		DocumentInfoDTO documentInfo = saveDocumentInfo(saveDocumentInfo, groupId);
		log.info("documentIfo " + documentInfo);
		return documentInfo;
	}
	
	public String getFileNameByFileEntryId(long fileEntryId) {
		
		String fileName = StringPool.BLANK;
		try {
			FileEntry fileEntry = getFileEntryByFileEntryId(fileEntryId);			
			if(Validator.isNotNull(fileEntry)) {
				fileName = fileEntry.getFileName();
			}
		} catch (PortalException e) {
			log.error("ERROR While Fetching File of fileEntryId " + fileEntryId + " : " + e.getMessage());
		}
		
		return fileName;
		
	}
	
	public String getPreviewUrlByFileEntryId( ThemeDisplay themeDisplay, long fileEntryId) {
		
		String previewUrl = StringPool.BLANK;
		try {
			FileEntry fileEntry = getFileEntryByFileEntryId(fileEntryId);			
			if(Validator.isNotNull(fileEntry)) {
				previewUrl = DLURLHelperUtil.getPreviewURL(fileEntry,
						fileEntry.getLatestFileVersion(), themeDisplay, null);
			}
		} catch (PortalException e) {
			log.error("ERROR While Fetching File of fileEntryId " + fileEntryId + " : " + e.getMessage());
		}
		
		return previewUrl;
		
	}
	
	public FileEntry getFileEntryByFileEntryId(long fileEntryId) throws PortalException {
		return DLAppServiceUtil.getFileEntry(fileEntryId);
	}

	private DocumentInfoDTO saveDocumentInfo(DocumentInfoDTO documentInfo, long groupId) {
		String documentInfoUrl = facultyMemebershipUtil.generateRequestURL(LRObjectURL.DOCUMENT_INFO_URL,
				String.valueOf(groupId));
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		log.info("headers" + headers);
		String documentDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfo, null);
		log.info("documentDetailMapper" + documentDetailMapper);
		String response = omsbHttpConnector.executePost(documentInfoUrl, documentDetailMapper, headers);
		log.info("response" + response);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoDTO.class);
	}

	private final Log log = LogFactoryUtil.getLog(FacultyDocumentUtil.class);

	@Reference
	private FacultyMemebershipUtil facultyMemebershipUtil;

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
}
