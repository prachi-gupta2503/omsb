package gov.omsb.form.builder.portlet.util;

import static gov.omsb.form.builder.constants.FormBuilderConstants.ATTACHMENT_ID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.COMPANYID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CREATEDBY;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CREATEDDATE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.D;
import static gov.omsb.form.builder.constants.FormBuilderConstants.DATE_CONFIG;
import static gov.omsb.form.builder.constants.FormBuilderConstants.D_;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FORMAT;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FORM_DEFINITION_ID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FORM_DEFINITION_ID_COLUMN;
import static gov.omsb.form.builder.constants.FormBuilderConstants.GROUPID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.H;
import static gov.omsb.form.builder.constants.FormBuilderConstants.H_;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MAPPING;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MAPPINGS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MODIFIEDBY;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MODIFIEDDATE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.NAME;
import static gov.omsb.form.builder.constants.FormBuilderConstants.RECORD_ID_COLUMN;
import static gov.omsb.form.builder.constants.FormBuilderConstants.SETTINGS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.TEMP_ATTACHMENTS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.Y;
import static gov.omsb.form.builder.constants.FormBuilderConstants.Y_;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.TempFileEntryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.service.FormDefinitionLocalService;
import gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil;
import gov.omsb.form.builder.service.FormRecordEntryLocalService;

public class FormDataUtil {
	
	
	public static final Log log = LogFactoryUtil.getLog(FormDataUtil.class);
	
	private static FormRecordEntryLocalService _formRecordEntryLocalService;
	
	private static UserLocalService _userLocalService;
	
	private static AssetEntryLocalService _assetEntryLocalService;
	
	private static WorkflowInstanceLinkLocalService _workflowInstanceLinkLocalService;
	
	private static WorkflowLogManager _workflowLogManager;
	
	private static WorkflowTaskManager _workflowTaskManager;	
	
	private static WorkflowDefinitionLinkLocalService _workflowDefinitionLinkLocalService;
	
	public FormDataUtil(FormRecordEntryLocalService formRecordEntryLocalService, UserLocalService userLocalService,
			AssetEntryLocalService assetEntryLocalService, 
			WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService, WorkflowLogManager workflowLogManager,
			WorkflowTaskManager workflowTaskManager,
			WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService) {
		_formRecordEntryLocalService = formRecordEntryLocalService;
		_userLocalService = userLocalService;
		_assetEntryLocalService = assetEntryLocalService;
		_workflowInstanceLinkLocalService = workflowInstanceLinkLocalService;
		_workflowLogManager = workflowLogManager;
		_workflowTaskManager = workflowTaskManager;
		_workflowDefinitionLinkLocalService = workflowDefinitionLinkLocalService;
	}
	
	public static void saveMasterTableData(String formDefinitionId, ThemeDisplay themeDisplay, Date currentDate,
			String tableName, Map<String, Long> masterValues, Map<String, Long> masterMap, long latestRecordId) {
		String columnNames;
		String columnValues;
		String mappingAuditColumnNames = FORM_DEFINITION_ID_COLUMN + StringPool.COMMA + RECORD_ID_COLUMN + StringPool.COMMA + CREATEDBY + 
				StringPool.COMMA + CREATEDDATE + StringPool.COMMA + MODIFIEDBY + StringPool.COMMA + MODIFIEDDATE + StringPool.COMMA + 
				GROUPID + StringPool.COMMA + COMPANYID;
		String mappingAuditColumnValues = formDefinitionId + StringPool.COMMA + latestRecordId + StringPool.COMMA + themeDisplay.getUserId() + 
				StringPool.COMMA + "'" + DateUtil.getLongFormatDate(currentDate) + "'" + StringPool.COMMA + 
				themeDisplay.getUserId() + StringPool.COMMA + "'" + DateUtil.getLongFormatDate(currentDate) + "'" + StringPool.COMMA +
				themeDisplay.getScopeGroupId() + StringPool.COMMA + themeDisplay.getCompanyId();
			 for(Entry<String, Long> valueEntry : masterValues.entrySet()){
				String masterTableMapping = StringPool.BLANK;
				if(valueEntry.getKey().endsWith("_")) {
					masterTableMapping = (tableName+"_"+valueEntry.getKey()+MAPPING);
				} else {
					masterTableMapping = (tableName+"_"+valueEntry.getKey()+"_"+MAPPING);
				}
				String formMappingsTable = (tableName+"_"+MAPPINGS);
				long valueId = valueEntry.getValue();
				
				List<String> masterTableMappingColumns = FormDefinitionLocalServiceUtil.getColumnNames("'"+FormDataUtil.formatFormName(masterTableMapping)+"'");
				List<String> formMappingsTableColumns = FormDefinitionLocalServiceUtil.getColumnNames("'"+FormDataUtil.formatFormName(formMappingsTable)+"'");
				
				String formMappingsTableName = FormDataUtil.formatFormName(formMappingsTable);
				
				for(Entry<String, Long> entry : masterMap.entrySet()) {
					long value = entry.getValue();
					String columnValue = String.valueOf(value);
					String latestRecordIdStr = String.valueOf(latestRecordId);
					if(valueId == value) {
						columnNames = mappingAuditColumnNames + StringPool.COMMA + entry.getKey();
						columnValues = mappingAuditColumnValues + StringPool.COMMA + value;
						long lastMasterRecordId = FormDefinitionLocalServiceUtil.getSelectLatestMasterRecord(formMappingsTableName);
						if(isTableNameExists(masterTableMapping) && masterTableMappingColumns.contains(entry.getKey())) {
							FormDefinitionLocalServiceUtil.insertIntoTable(FormDataUtil.formatFormName(masterTableMapping), columnNames, columnValues);
						} else if(isTableNameExists(formMappingsTable) && formMappingsTableColumns.contains(entry.getKey())) {
							if(latestRecordId == lastMasterRecordId) {
								FormDefinitionLocalServiceUtil.updateMasterRecord(formMappingsTableName, entry.getKey(), "'"+columnValue+"'", 
										"'"+latestRecordIdStr+"'");
							} else {
								FormDefinitionLocalServiceUtil.insertIntoTable(formMappingsTableName, columnNames, columnValues);
							}
						}
					}	
				}
			}
	}
	
	public static void deleteFile(ActionRequest actionRequest, String formDefinitionId, JSONObject deleteFileJson,
			long recordId, ThemeDisplay themeDisplay, List<String> fileNames, int file_counter,
			Map<String, File> singleFileMap, Map<String, String> multipleFileMap, String tableName,
			UploadPortletRequest uploadPortletRequest) {
		if(Validator.isNotNull(deleteFileJson) && deleteFileJson.keySet().size() > 0) {
		    String updatedFileIDs = StringPool.BLANK;
		    try {
		    	for (String fieldKey : deleteFileJson.keySet()) {
		            JSONArray fileEntryArray = deleteFileJson.getJSONArray(fieldKey);
		            System.out.println("fieldKey :: "+fieldKey);
		            for (int i = 0; i < fileEntryArray.length(); i++) {
		                JSONObject fileEntry = fileEntryArray.getJSONObject(i);
		                long selectedfileEntryId = fileEntry.getLong("fileEntryId");
		                System.out.println("fileEntryId: " + selectedfileEntryId);
		                JSONArray fileEntryIdArray = FormDefinitionLocalServiceUtil.getDataSelectQuery(FormDataUtil.formatFormName(tableName), fieldKey+",id", "where id="+recordId);
		                for (int j = 0; j < fileEntryIdArray.length(); j++) {
		                    JSONObject formFieldObj = fileEntryIdArray.getJSONObject(j);
		                    String[] entryId = formFieldObj.getString(fieldKey).split(",");
		                    for(String fileEntryId : entryId) {
		                    	if(!fileEntryId.equalsIgnoreCase(String.valueOf(selectedfileEntryId))) {
		                            updatedFileIDs = updatedFileIDs  + fileEntryId + ",";
		                        }
		                    }
		                    if(Validator.isNotNull(updatedFileIDs) && !updatedFileIDs.isBlank()) {
		                        updatedFileIDs = updatedFileIDs.substring(0, updatedFileIDs.length() - 1);
		                        multipleFileMap.put(fieldKey, updatedFileIDs);
		                        FormDataUtil.addToMultipleFileMap(actionRequest, multipleFileMap, fieldKey);
		                    }
		                    boolean isUpdated = FormDefinitionLocalServiceUtil.updateTableRecord(FormDataUtil.formatFormName(tableName), fieldKey+"="+"'"+updatedFileIDs+"'", String.valueOf(recordId));
		                    boolean isDeletedFile = DLFileEntryLocalServiceUtil.deleteDLFileEntry(selectedfileEntryId) != null;
		                    if(isDeletedFile && isUpdated) {
		                        System.out.println("File Deleted with id :: "+selectedfileEntryId);
		                    } else {
		                        System.out.println("File not Deleted");
		                    }
		                }
		            }
		    	}
		    	saveFileEntry(actionRequest, formDefinitionId, themeDisplay, fileNames, file_counter, singleFileMap, 
		        		multipleFileMap, tableName, uploadPortletRequest, recordId);
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public static boolean isTableNameExists(String tableName) {
		return FormConfigurationUtil.isTableExists(FormDataUtil.formatFormName(tableName));
	}
	
	public static void saveFileEntry(ActionRequest actionRequest, String formDefinitionId, ThemeDisplay themeDisplay, List<String> fileNames, int file_counter, Map<String, File> singleFileMap,
			Map<String, String> multipleFileMap, String tableName, UploadPortletRequest uploadPortletRequest,
			long latestRecordId) throws JSONException, PortalException {
		Map<String, String> updateFileEntryMap = new HashMap<>();
		if(Validator.isNotNull(singleFileMap) && !singleFileMap.isEmpty() && singleFileMap.size()>0) {
			DLFolder recordFolder = FormDataUtil.createRecordFolder(actionRequest, themeDisplay, formDefinitionId,
					latestRecordId);
			for(Map.Entry<String, File> entry : singleFileMap.entrySet()) {
				DLFolder keyFolder = FormDataUtil.createDLFolder(actionRequest, themeDisplay, false, recordFolder.getFolderId(), entry.getKey(),
						StringPool.BLANK, false);
				file_counter = FormDataUtil.uploadFile(actionRequest, themeDisplay, fileNames, file_counter,
						updateFileEntryMap, entry, keyFolder, uploadPortletRequest);
			}
		}
		if(Validator.isNotNull(multipleFileMap) && !multipleFileMap.isEmpty() && multipleFileMap.size()>0) {
			DLFolder recordFolder = FormDataUtil.createRecordFolder(actionRequest, themeDisplay, formDefinitionId,
					latestRecordId);
			for(Map.Entry<String, String> entry : multipleFileMap.entrySet()) {
				DLFolder keyFolder = FormDataUtil.createDLFolder(actionRequest, themeDisplay, false, recordFolder.getFolderId(), entry.getKey(), 
						StringPool.BLANK, false);
				file_counter = FormDataUtil.uploadMultipleFile(actionRequest, themeDisplay, fileNames, file_counter,
						updateFileEntryMap, entry, keyFolder);
			}
		}
		if(Validator.isNotNull(updateFileEntryMap) && !updateFileEntryMap.isEmpty() && updateFileEntryMap.size()>0) {
			String updatedColumnValues = FormDataUtil.createColumnValuesForUpdate(updateFileEntryMap);
			FormDefinitionLocalServiceUtil.updateTableRecord(FormDataUtil.formatFormName(tableName), updatedColumnValues, String.valueOf(latestRecordId));
		}
	}
	
	public static void updateMasterTableData(String recordIdParam, String editModeColumns, String tableName,
			Map<String, Long> masterValues, Map<String, Long> masterMap) {
		FormDefinitionLocalServiceUtil.updateTableRecord(FormDataUtil.formatFormName(tableName), editModeColumns, recordIdParam);
		if(Validator.isNotNull(masterValues) && !masterValues.isEmpty() && masterValues.size()>0) {
			
			for(Entry<String, Long> valueEntry : masterValues.entrySet()){
				String masterTableMapping = StringPool.BLANK;
				if(valueEntry.getKey().endsWith("_")) {
					masterTableMapping = (tableName+"_"+valueEntry.getKey()+MAPPING);
				} else {
					masterTableMapping = (tableName+"_"+valueEntry.getKey()+"_"+MAPPING);
				}
				String formMappingsTable = (tableName+"_"+MAPPINGS);
				long valueId = valueEntry.getValue();
				
				List<String> masterTableMappingColumns = FormDefinitionLocalServiceUtil.getColumnNames("'"+FormDataUtil.formatFormName(masterTableMapping)+"'");
				List<String> formMappingsTableColumns = FormDefinitionLocalServiceUtil.getColumnNames("'"+FormDataUtil.formatFormName(formMappingsTable)+"'");
				
				for(Entry<String, Long> entry : masterMap.entrySet()) {
					long value = entry.getValue();
					String updateColumns = StringPool.BLANK;
					if(valueId == value) {
						updateColumns = updateColumns + entry.getKey() + StringPool.EQUAL + value;
						if(isTableNameExists(masterTableMapping) && masterTableMappingColumns.contains(entry.getKey())) {
							FormDefinitionLocalServiceUtil.updateMasterTableRecord(FormDataUtil.formatFormName(masterTableMapping), updateColumns, "'"+recordIdParam+"'");
						} else if(isTableNameExists(formMappingsTable) && formMappingsTableColumns.contains(entry.getKey())) {
							FormDefinitionLocalServiceUtil.updateMasterTableRecord(FormDataUtil.formatFormName(formMappingsTable), updateColumns, "'"+recordIdParam+"'");
						}
					}	
				}
			}
		}
	}
	
	public static void saveFileData(ActionRequest actionRequest, JSONObject deleteFileJson, long recordId, boolean isEditMode,
			Map<String, File> singleFileMap, Map<String, String> multipleFileMap, String tableName,
			UploadPortletRequest uploadPortletRequest, String key, boolean isMultiple) {
		if(!isEditMode) {
			if(isMultiple) {
				FormDataUtil.addToMultipleFileMap(actionRequest, multipleFileMap, key);
			} else {
				FormDataUtil.addToSingleFileMap(singleFileMap, uploadPortletRequest, key);
			}
		} else if(isMultiple && isEditMode && recordId > 0 && Validator.isNotNull(deleteFileJson) && deleteFileJson.keySet().size() == 0) {
			String fileEntryIdvalue = StringPool.BLANK;
			JSONArray fileEntryIdArray = FormDefinitionLocalServiceUtil.getDataSelectQuery(FormDataUtil.formatFormName(tableName), key+",id", "where id="+recordId);
			for (int j = 0; j < fileEntryIdArray.length(); j++) {
		        JSONObject formFieldObj = fileEntryIdArray.getJSONObject(j);
		        String[] entryId = formFieldObj.getString(key).split(",");
		        for(String fileEntryId : entryId) {
		        	if (Validator.isNotNull(multipleFileMap) && multipleFileMap.containsKey(key)) {
						fileEntryIdvalue = multipleFileMap.get(key);
						fileEntryIdvalue = fileEntryIdvalue + "," + fileEntryId;
					} else {
						fileEntryIdvalue = fileEntryId;
					}
		        	multipleFileMap.put(key, fileEntryIdvalue);
		        }
		    }
		    FormDataUtil.addToMultipleFileMap(actionRequest, multipleFileMap, key);
			log.info("new multipleFileMap :: "+multipleFileMap);
		} else if(!isMultiple && isEditMode && recordId > 0 && Validator.isNotNull(deleteFileJson) && deleteFileJson.keySet().size() == 0) {
			FormDataUtil.addToSingleFileMap(singleFileMap, uploadPortletRequest, key);
		}
	}
	
	public static void saveDataInFormRecordEntry(ServiceContext serviceContext, String formDefinitionId,
			String workflowDefinition, long formRecordEntryId, long recordId, ThemeDisplay themeDisplay,
			String tableName, long latestRecordId) {
		FormRecordEntry formRecordEntry = null;
		String tempTableName = tableName.replaceAll("\\s+", StringPool.UNDERLINE);
		String formattedTableName = FormBuilderConstants.DF + StringPool.UNDERLINE
				+ tempTableName.toLowerCase();
		long tempRecordId = 0l;
		if (Validator.isNotNull(latestRecordId) && latestRecordId > 0) {
			tempRecordId = latestRecordId;
		}else if(Validator.isNotNull(recordId) && recordId > 0) {
			tempRecordId = recordId;
		}
		if(tempRecordId > 0 && Validator.isNotNull(workflowDefinition)) {
			formRecordEntry = FormDataUtil.addEditFormRecordEntry(serviceContext, themeDisplay,
					formRecordEntryId, Long.parseLong(formDefinitionId), tempRecordId,
					formattedTableName, workflowDefinition);
		}
	}

	public static String decryptEncryptedData(String requestData) {
	
		String iv = StringPool.BLANK;
		String salt = StringPool.BLANK;
		String requestDataEnc = StringPool.BLANK, requestDataDec = StringPool.BLANK;
		String decryptedFormBasicSectionData = StringPool.BLANK;
		if (Validator.isNotNull(requestData)) {
			try {
				decryptedFormBasicSectionData = new String(java.util.Base64.getDecoder().decode(requestData));
				if (Validator.isNotNull(decryptedFormBasicSectionData)) {
					iv = decryptedFormBasicSectionData.split("::")[0];
					salt = decryptedFormBasicSectionData.split("::")[1];
					requestDataEnc = decryptedFormBasicSectionData.split("::")[2];
				}
				byte[] saltBytes = CryptoUtil.hexStringToByteArray(salt);
				byte[] ivBytes = CryptoUtil.hexStringToByteArray(iv);
				
				IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
				SecretKeySpec sKey = (SecretKeySpec) CryptoUtil.generateKeyFromPassword(FormBuilderConstants.SECRET_PASS_PHRASE, saltBytes);
				requestDataDec = CryptoUtil.decrypt(requestDataEnc, sKey, ivParameterSpec);
	
				log.info("### data decrypted successfully ###");
	
			} catch (GeneralSecurityException e) {
				log.error("### Error while decrypting data ###" + e.getMessage());
			}
		}
	
		return requestDataDec;
	}
	
	public static String formatFormName(String formName) {
		String formattedFormName = StringPool.BLANK;
		if(Validator.isNotNull(formName)) {
			formattedFormName = "df_"+formName.replaceAll("\\s+", "_").toLowerCase();
		}
		return formattedFormName ;
	}
	
	public static String formatFormNameId(String formName) {
		String formattedFormName = StringPool.BLANK;
		if(Validator.isNotNull(formName)) {
			formattedFormName = formName.replaceAll("\\s", StringPool.BLANK).toLowerCase()+"Id";
		}
		return formattedFormName ;
	}

	public static String createColumnValuesForUpdate(Map<String, String> updateFileEntryMap) {
		String updatedColumnValues = StringPool.BLANK;
		for(Map.Entry<String, String> entry : updateFileEntryMap.entrySet()) {
			updatedColumnValues = updatedColumnValues + entry.getKey() + StringPool.EQUAL + "'" + entry.getValue() + "'" + StringPool.COMMA;
		}
		updatedColumnValues = updatedColumnValues.substring(0, updatedColumnValues.length() - 1);
		return updatedColumnValues;
	}
	
	public static int uploadFile(ActionRequest actionRequest, ThemeDisplay themeDisplay, List<String> fileNames,
			int file_counter, Map<String, String> updateFileEntryMap, Map.Entry<String, File> entry, DLFolder keyFolder,
			UploadPortletRequest uploadPortletRequest) {
		try {
			File file = entry.getValue();
			String originalSelectedFileName = uploadPortletRequest.getFileName(entry.getKey());
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			serviceContext.setAddGuestPermissions(true);
			if (Validator.isNotNull(fileNames) && fileNames.contains(originalSelectedFileName)) {
				originalSelectedFileName = originalSelectedFileName + "_" + file_counter;
				file_counter++;
			}
			fileNames.add(originalSelectedFileName);
			@SuppressWarnings("deprecation")
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(), keyFolder.getFolderId(), originalSelectedFileName,
					MimeTypesUtil.getContentType(file), originalSelectedFileName, StringPool.BLANK, StringPool.BLANK, file,
					serviceContext);
			String fileEntryIdvalue;
			if (updateFileEntryMap.containsKey(entry.getKey())) {
				fileEntryIdvalue = updateFileEntryMap.get(entry.getKey());
				fileEntryIdvalue = fileEntryIdvalue + StringPool.COMMA + String.valueOf(fileEntry.getFileEntryId());
			} else {
				fileEntryIdvalue = String.valueOf(fileEntry.getFileEntryId());
			}
			updateFileEntryMap.put(entry.getKey(), fileEntryIdvalue);
		} catch (PortalException e) {
			log.error("error occured while uploading file: "+e.getMessage());
		}
		return file_counter;
	}
	
	public static int uploadMultipleFile(ActionRequest actionRequest, ThemeDisplay themeDisplay, List<String> fileNames,
			int file_counter, Map<String, String> updateFileEntryMap, Map.Entry<String, String> entry,
			DLFolder keyFolder) throws JSONException, PortalException {
		String decryptedResponse = new String(java.util.Base64.getDecoder().decode(entry.getValue()));
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(decryptedResponse);
		FileEntry tempFileEntry = null;
		JSONObject tempFileJsonObject = null;
		for (int i = 0; i < jsonArray.length(); i++) {
			tempFileJsonObject = jsonArray.getJSONObject(i);
			String fileEntryIdvalue = StringPool.BLANK;
			if(tempFileJsonObject.has("fileEntryId")) {
				if (Validator.isNotNull(updateFileEntryMap) && updateFileEntryMap.containsKey(entry.getKey())) {
					fileEntryIdvalue = updateFileEntryMap.get(entry.getKey());
					fileEntryIdvalue = fileEntryIdvalue + "," + tempFileJsonObject.getString("fileEntryId");
				} else {
					fileEntryIdvalue = tempFileJsonObject.getString("fileEntryId");
				}
				updateFileEntryMap.put(entry.getKey(), fileEntryIdvalue);
			} else {
				tempFileEntry = TempFileEntryUtil.getTempFileEntry(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
						TEMP_ATTACHMENTS, tempFileJsonObject.get(NAME).toString());
				String originalSelectedFileName = TempFileEntryUtil.getOriginalTempFileName(tempFileEntry.getFileName());
				if (Validator.isNotNull(fileNames) && fileNames.contains(originalSelectedFileName)) {
					originalSelectedFileName = originalSelectedFileName + StringPool.UNDERLINE + file_counter;
					file_counter++;
				}
				fileNames.add(originalSelectedFileName);
				String mimeType = tempFileEntry.getMimeType();
				InputStream inputStream = tempFileEntry.getContentStream();
				long size = tempFileEntry.getSize();
				if (Validator.isNotNull(originalSelectedFileName) && Validator.isNotNull(inputStream)) {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(FileEntry.class.getName(),
							actionRequest);
					serviceContext.setAddGroupPermissions(true);
					long guestGroupId = themeDisplay.getScopeGroupId();
					long userId = themeDisplay.getUserId();
					try {
						FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(StringPool.BLANK, userId, guestGroupId,
								keyFolder.getFolderId(), originalSelectedFileName, mimeType, originalSelectedFileName,
								originalSelectedFileName, StringPool.BLANK, StringPool.BLANK, inputStream, size, null, null,
								serviceContext);
						if (Validator.isNotNull(updateFileEntryMap) && updateFileEntryMap.containsKey(entry.getKey())) {
							fileEntryIdvalue = updateFileEntryMap.get(entry.getKey());
							fileEntryIdvalue = fileEntryIdvalue + "," + String.valueOf(fileEntry.getFileEntryId());
							log.info("fileEntryIdvalue inside if :: "+fileEntryIdvalue);
						} else {
							fileEntryIdvalue = String.valueOf(fileEntry.getFileEntryId());
							log.info("fileEntryIdvalue inside else :: "+fileEntryIdvalue);
						}
						updateFileEntryMap.put(entry.getKey(), fileEntryIdvalue);
					} catch (PortalException pe) {
						log.error("error while creating file entry");
					}
					log.info("File saved successfully with title : " + originalSelectedFileName + " fileName : "
							+ originalSelectedFileName + " in document & media.");
				}
			}
		}
		return file_counter;
	}
	
	public static DLFolder createRecordFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			String formDefinitionId, long latestRecordId) {
		DLFolder formDefinitionFolder = createFormDefinitionFolder(actionRequest, themeDisplay, formDefinitionId);
		DLFolder recordFolder = createDLFolder(actionRequest, themeDisplay, false, formDefinitionFolder.getFolderId(),
				String.valueOf(latestRecordId), StringPool.BLANK, false);
		return recordFolder;
	}

	public static DateFormat fetchDateFormatFromConfig(JSONObject field) {
		String format = field.getJSONObject(SETTINGS).getJSONObject(DATE_CONFIG).getString(FORMAT);
		format = format.replace(D, D_);
		format = format.replace(Y, Y_);
		format = format.replace(H, H_);
		DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(format);
		return dateFormat;
	}

	public static void addToSingleFileMap(Map<String, File> singleFileMap, UploadPortletRequest uploadPortletRequest,
			String key) {
		File file = uploadPortletRequest.getFile(key);
		if(Validator.isNotNull(file)) {
			singleFileMap.put(key, file);
		}
	}

	public static void addToMultipleFileMap(ActionRequest actionRequest, Map<String, String> multipleFileMap, String key) {
		String tempAttachments = ParamUtil.getString(actionRequest, ATTACHMENT_ID);
		if(Validator.isNotNull(tempAttachments)) {
			String decodedMap = new String(java.util.Base64.getDecoder().decode(tempAttachments));
			try {
				JSONArray decodeJsonArr = JSONFactoryUtil.createJSONArray(decodedMap);
				if(Validator.isNotNull(multipleFileMap) && multipleFileMap.containsKey(key)) {
					String value = multipleFileMap.get(key);
					JSONObject fileJsonObj = JSONFactoryUtil.createJSONObject();
					fileJsonObj.put("fileEntryId", value);
					decodeJsonArr.put(fileJsonObj);
				} 
				log.info("decodeJsonArr :: "+decodeJsonArr);
				String encodedMap = new String(java.util.Base64.getEncoder().encode(decodeJsonArr.toString().getBytes()));
				multipleFileMap.put(key, encodedMap);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}
		else if(Validator.isNotNull(multipleFileMap) && multipleFileMap.containsKey(key)) {
			JSONArray decodeJsonArr = JSONFactoryUtil.createJSONArray();
			String value = multipleFileMap.get(key);
			JSONObject fileJsonObj = JSONFactoryUtil.createJSONObject();
			fileJsonObj.put("fileEntryId", value);
			decodeJsonArr.put(fileJsonObj);
			String encodedMap = new String(java.util.Base64.getEncoder().encode(decodeJsonArr.toString().getBytes()));
			multipleFileMap.put(key, encodedMap);
		}
	} 

	public static FormDefinition fetchFormDefinition(String formDefinitionId,
			FormDefinitionLocalService formDefinitionLocalService) {
		FormDefinition formDefinition = null;
		try {
			formDefinition = formDefinitionLocalService.getFormDefinition(Long.parseLong(formDefinitionId));
		} catch (PortalException pe) {
			log.error("Error while fetching formDefinitionId");
		}
		return formDefinition;
	}
	
	

	public static String getFormDefinitionIdFromPref(ActionRequest actionRequest) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String formDefinitionId = preferences.getValue(FORM_DEFINITION_ID, StringPool.BLANK);
		return formDefinitionId;
	}
	
	public static DLFolder createFormDefinitionFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			String formDefinitionId) {
		DLFolder formsFolder = createDLFolder(actionRequest, themeDisplay, false,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "forms", StringPool.BLANK, false);
		DLFolder formDefinitionFolder = createDLFolder(actionRequest, themeDisplay, false, formsFolder.getFolderId(),
				formDefinitionId, StringPool.BLANK, false);
		return formDefinitionFolder;
	}
	
	public static DLFolder createDLFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay, boolean mountPoint,
			long parentFolderId, String folderName, String description, boolean hidden) {
		DLFolder dlFolder = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			serviceContext.setAddGuestPermissions(true);
			dlFolder = fetchFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			if (Validator.isNull(dlFolder)) {
				dlFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), mountPoint, parentFolderId,
						folderName, description, hidden, serviceContext);
			}
		} catch (Exception e1) {
			log.error("Error while creating folder");
		}
		return dlFolder;
	}
	
	public static DLFolder fetchFolder(long groupId, long parentFolderId, String name) {
		DLFolder dlFolder = null;
		try {
			dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, name);
		} catch (Exception e) {
			log.error("Error while fetching DL folder - " + name);
		}
		return dlFolder;
	}
	
	//Add entry in df_form_records_entry table
	public static FormRecordEntry addEditFormRecordEntry(ServiceContext serviceContext, ThemeDisplay themeDisplay,
			long formRecordEntryId, long formDefinitionId, long recordId, String dfTableName,
			String workflowDefinition) {
		log.info("### Adding/Editing form record entry ###");
		FormRecordEntry formRecordEntry = null;
		FormRecordEntry updatedFormRecordEntry = null;
		Date date = new Date();
		try {

			if (Validator.isNotNull(formRecordEntryId) && formRecordEntryId > 0) {
				formRecordEntry = _formRecordEntryLocalService.getFormRecordEntry(formRecordEntryId);
				formRecordEntry.setModifiedBy(themeDisplay.getUserId());
				formRecordEntry.setModifiedDate(date);
			} else {
				formRecordEntry = _formRecordEntryLocalService
						.createFormRecordEntry(CounterLocalServiceUtil.increment());
				formRecordEntry.setStatus(WorkflowConstants.STATUS_ANY);
				formRecordEntry.setCreatedBy(themeDisplay.getUserId());
				formRecordEntry.setCreatedDate(date);
			}
			User user = _userLocalService.getUser(themeDisplay.getUserId());

			formRecordEntry.setFormDefinitionId(formDefinitionId);
			formRecordEntry.setRecordId(recordId);
			formRecordEntry.setDfTableName(dfTableName);
			formRecordEntry.setGroupId(themeDisplay.getScopeGroupId());
			formRecordEntry.setCompanyId(themeDisplay.getCompanyId());
			formRecordEntry.setStatusByUserId(user.getUserId());
			formRecordEntry.setStatusDate(date);
			formRecordEntry.setStatusByUserName(user.getFullName());
			updatedFormRecordEntry = _formRecordEntryLocalService.updateFormRecordEntry(formRecordEntry);
			int formRecordEntryWorkflowStatus = updatedFormRecordEntry.getStatus();
			if (Validator.isNull(formRecordEntryId) && formRecordEntryId <= 0) {
				formRecordEntryId = updatedFormRecordEntry.getFormRecordEntryId();
			}
			if (Validator.isNotNull(formRecordEntryId) && formRecordEntryId > 0 && Validator.isNotNull(workflowDefinition) 
					&& (formRecordEntryWorkflowStatus == WorkflowConstants.STATUS_ANY
							|| formRecordEntryWorkflowStatus == WorkflowConstants.STATUS_INCOMPLETE)) {
				new FormUtil(_workflowDefinitionLinkLocalService);
				FormUtil.addUpdatedWorkflowDefinitionLink(themeDisplay, themeDisplay.getScopeGroupId(),
						FormRecordEntry.class.getName(), workflowDefinition);
				if (formRecordEntryWorkflowStatus == WorkflowConstants.STATUS_INCOMPLETE) {
					log.info("### Workflow Completing while adding/updating ###");
					completeWorkflowTask(themeDisplay, formRecordEntry);
				} else {
					log.info("### Initializing Workflow ###");
					serviceContext.setAttribute(FormBuilderConstants.PORTAL_URL, themeDisplay.getPortalURL());
					serviceContext.setAttribute(FormBuilderConstants.FORM_DEFINITION_ID, formDefinitionId);
					serviceContext.setAttribute(FormBuilderConstants.RECORD_ID, recordId);
					initWokflow(user, serviceContext, formRecordEntry);
				}
				formRecordEntry.setStatus(WorkflowConstants.STATUS_DRAFT);
				updatedFormRecordEntry = _formRecordEntryLocalService.updateFormRecordEntry(formRecordEntry);
			}
			log.info("### Form Definition Updated ###");
		} catch (PortalException e) {
			log.error("error occured while adding/updating form record entry: " + e.getMessage());
		}
		return updatedFormRecordEntry;
	}
	
	private static void initWokflow(User user, ServiceContext serviceContext, FormRecordEntry formRecordEntry) {
		log.info("### Init Workflow while saving Form Record Entry ###");
		try {
			AssetEntry assetEntry = _assetEntryLocalService.updateEntry(user.getUserId(),
					serviceContext.getScopeGroupId(), new Date(), new Date(), FormRecordEntry.class.getName(),
					formRecordEntry.getFormRecordEntryId(), formRecordEntry.getUuid(), 0, null, null, true, false,
					new Date(), null, new Date(), null, ContentTypes.TEXT_HTML, formRecordEntry.getDfTableName(),
					formRecordEntry.getDfTableName(), null, null, null, 0, 0, null);
			Indexer<FormRecordEntry> indexer = IndexerRegistryUtil.nullSafeGetIndexer(FormRecordEntry.class);
			indexer.reindex(formRecordEntry);
			log.info("### Starting Workflow for Form Record Entry ###");
			WorkflowHandlerRegistryUtil.startWorkflowInstance(formRecordEntry.getCompanyId(),
					formRecordEntry.getGroupId(), user.getUserId(), FormRecordEntry.class.getName(),
					formRecordEntry.getPrimaryKey(), formRecordEntry, serviceContext);
			log.info("### Workflow Started for Form Record Entry ###");
		} catch (PortalException e) {
			log.error("error occured while initializing workflow: " + e.getMessage());
		}
	}
	
	/*public static String getFormRecordEntryURL(ThemeDisplay themeDisplay, long formDefinitionId, long recordId) {
		String configurationRenderURL = themeDisplay.getPortalURL()
				+ themeDisplay.getLayoutFriendlyURL(themeDisplay.getLayout()) + StringPool.QUESTION
				+ DynamicFormBuilderConstants.FORM_DEFINITION_ID + StringPool.EQUAL + formDefinitionId
				+ StringPool.AMPERSAND + DynamicFormBuilderConstants.RECORD_ID + StringPool.EQUAL + recordId;
		return configurationRenderURL;
	}*/
	
	public static FormRecordEntry updateStatus(long userId, long formRecordEntryId, int status,
			ServiceContext serviceContext) {
		FormRecordEntry formRecordEntry = null;
		User user = null;
		try {
			formRecordEntry = _formRecordEntryLocalService.getFormRecordEntry(formRecordEntryId);
			formRecordEntry.setStatus(status);
			formRecordEntry.setStatusByUserId(userId);
			formRecordEntry.setStatusDate(new Date());
			user = _userLocalService.getUser(userId);
			formRecordEntry.setStatusByUserName(user.getFullName());
			formRecordEntry.setStatusByUserUuid(user.getUserUuid());
			if (status == WorkflowConstants.STATUS_APPROVED) {
				// update the asset status to visibile
				_assetEntryLocalService.updateEntry(FormRecordEntry.class.getName(), formRecordEntryId, new Date(),
						null, true, true);
			} else {
				// set formDefinition entity status to false
				_assetEntryLocalService.updateVisible(FormRecordEntry.class.getName(), formRecordEntryId, false);
			}
		} catch (PortalException e) {
			log.error("error occured while updating status of form definition: " + e.getMessage());
		}
		formRecordEntry = _formRecordEntryLocalService.updateFormRecordEntry(formRecordEntry);
		return formRecordEntry;
	}
	
	private static void completeWorkflowTask(ThemeDisplay themeDisplay, FormRecordEntry formRecordEntry) {
		log.info("### completeWorkflowTask ###");
		long companyId = themeDisplay.getCompanyId();
		WorkflowInstanceLink wil;
		try {
			Map<String, Serializable> workflowContext = getWorkflowContext(themeDisplay, formRecordEntry);
			wil = _workflowInstanceLinkLocalService.getWorkflowInstanceLink(companyId, formRecordEntry.getGroupId(),
					FormRecordEntry.class.getName(), formRecordEntry.getFormRecordEntryId());
			List<Integer> logTypes_assign = new ArrayList<Integer>();
			logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
			List<WorkflowLog> workflowLogs_assign = _workflowLogManager.getWorkflowLogsByWorkflowInstance(companyId,
					wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
			if (workflowLogs_assign.size() > 0) {
				long workflowTaskId = workflowLogs_assign.get(workflowLogs_assign.size() - 1).getWorkflowTaskId();
				log.info("Workflow Task Id: " + workflowTaskId);
				_workflowTaskManager.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
						workflowTaskId, "resubmit", StringPool.BLANK, workflowContext);
			}
		} catch (Exception e) {
			log.error("error occured while getting workflow task id :" + e.getMessage());
		}
	}

	private static Map<String, Serializable> getWorkflowContext(ThemeDisplay themeDisplay,
			FormRecordEntry formRecordEntry) throws Exception {
		long companyId = themeDisplay.getCompanyId();
		WorkflowInstanceLink wil = _workflowInstanceLinkLocalService.getWorkflowInstanceLink(companyId,
				formRecordEntry.getGroupId(), FormRecordEntry.class.getName(), formRecordEntry.getFormRecordEntryId());
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
				wil.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		return workflowContext;
	}
}
