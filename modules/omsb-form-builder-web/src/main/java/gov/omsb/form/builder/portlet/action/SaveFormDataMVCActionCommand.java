package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.ACCEPT;
import static gov.omsb.form.builder.constants.FormBuilderConstants.ARABIC_LANGUGAE_CODE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CHECKBOX;
import static gov.omsb.form.builder.constants.FormBuilderConstants.COMPANYID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CONTENT_TYPE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CREATEDBY;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CREATEDDATE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CUSTOM_RANGE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.DATA_TYPE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.DATE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.DATETIME;
import static gov.omsb.form.builder.constants.FormBuilderConstants.DROP_DOWN;
import static gov.omsb.form.builder.constants.FormBuilderConstants.ENABLED;
import static gov.omsb.form.builder.constants.FormBuilderConstants.ENGLISH_LANGUAGE_CODE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FIELDS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FIELD_NAME;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FILE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FORM_DEFINITION_ID_COLUMN;
import static gov.omsb.form.builder.constants.FormBuilderConstants.FORM_VERSION_COLUMN;
import static gov.omsb.form.builder.constants.FormBuilderConstants.GROUPID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.HEADERS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.HTML;
import static gov.omsb.form.builder.constants.FormBuilderConstants.HTML_DATA;
import static gov.omsb.form.builder.constants.FormBuilderConstants.INTEGER;
import static gov.omsb.form.builder.constants.FormBuilderConstants.KEY;
import static gov.omsb.form.builder.constants.FormBuilderConstants.LANGUAGE_ID;
import static gov.omsb.form.builder.constants.FormBuilderConstants.LONGTEXT;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MASTER;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MASTER_TABLE_NAME;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MODIFIEDBY;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MODIFIEDDATE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MULTIPLE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MULTI_SELECT;
import static gov.omsb.form.builder.constants.FormBuilderConstants.NAME;
import static gov.omsb.form.builder.constants.FormBuilderConstants.NUMBER;
import static gov.omsb.form.builder.constants.FormBuilderConstants.PARAMS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.POST_DATA;
import static gov.omsb.form.builder.constants.FormBuilderConstants.RADIO;
import static gov.omsb.form.builder.constants.FormBuilderConstants.RANGE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.SETTINGS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.STRING;
import static gov.omsb.form.builder.constants.FormBuilderConstants.TEXT_AREA;
import static gov.omsb.form.builder.constants.FormBuilderConstants.TIME;
import static gov.omsb.form.builder.constants.FormBuilderConstants.TYPE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.URL;
import static gov.omsb.form.builder.constants.FormBuilderConstants.VALUE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.VALUE_COLUMN;
import static gov.omsb.form.builder.constants.FormBuilderConstants.XML_DATA_TEMPLATE;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowLogManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.portlet.util.DateUtil;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.portlet.util.FormDataUtil;
import gov.omsb.form.builder.portlet.util.WebServiceUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;
import gov.omsb.form.builder.service.FormRecordEntryLocalService;


/**
 * @author jinal.patel
 *
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + MVCCommandNames.SAVE_FORM_DATA_ACTION
	    }, 
	    service = MVCActionCommand.class
)
public class SaveFormDataMVCActionCommand extends BaseMVCActionCommand {
	
	private static final Log log = LogFactoryUtil.getLog(SaveFormDataMVCActionCommand.class);
	
	@Reference
	private FormConfigurationUtil formConfigurationUtil;
	
	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
	
	@Reference
	private FormRecordEntryLocalService formRecordEntryLocalService;
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private AssetEntryLocalService assetEntryLocalService;
	
	@Reference
	private WorkflowTaskManager workflowTaskManager;
	
	@Reference
	private WorkflowLogManager workflowLogManager;
	
	@Reference
	private WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	
	@Reference
	private WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService;

	@SuppressWarnings("unchecked")
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new FormDataUtil(formRecordEntryLocalService, userLocalService, assetEntryLocalService, workflowInstanceLinkLocalService, workflowLogManager, workflowTaskManager, workflowDefinitionLinkLocalService);
		
        PortletPreferences preferences = actionRequest.getPreferences();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(FormRecordEntry.class.getName(), actionRequest);
		String formDefinitionId = ParamUtil.getString(actionRequest, "formDefinitionId");
		String recordIdParam = ParamUtil.getString(actionRequest, "recordId");
		String workflowDefinition = ParamUtil.getString(actionRequest, FormBuilderConstants.WORKFLOW_DEFINITION); 
		long formRecordEntryId = ParamUtil.getLong(actionRequest, FormBuilderConstants.FORM_RECORD_ENTRY_ID, 0);
        String deleteFile = ParamUtil.getString(actionRequest, "deleteFileEntry");
        JSONObject deleteFileJson = JSONFactoryUtil.createJSONObject(deleteFile);
        
        
        String selectedEmailTemplateId = preferences.getValue(FormBuilderConstants.SELECTED_EMAIL_TEMPLATE_ID, StringPool.BLANK);
        
		long recordId = 0l;
		boolean isEditMode = false;
		String editModeColumns = StringPool.BLANK;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, FormBuilderConstants.REDIRECT_URL);
		Date currentDate = new Date();
		if(Validator.isNotNull(recordIdParam) && Validator.isNotNull(formDefinitionId)) {
			try {
				recordId = Long.parseLong(recordIdParam);
				isEditMode = true;
			} catch(Exception e) {
				log.error("error while parsing recordIdParam");
			}
		}
		if(Validator.isNull(formDefinitionId)) {
			formDefinitionId = FormDataUtil.getFormDefinitionIdFromPref(actionRequest);
		}
		
			
		List<String> fileNames = new ArrayList<>();
		int fileCounter = 1;
		
		Map<String, File> singleFileMap = new HashMap<>();
		Map<String, String> multipleFileMap = new HashMap<>();
		
		FormDefinition formDefinition = FormDataUtil.fetchFormDefinition(formDefinitionId, formDefinitionLocalService);
		
		if(Validator.isNotNull(formDefinition)) {
			JSONObject formDefJsonObject = null;
			String tableName = StringPool.BLANK;
			String postDataUrl = StringPool.BLANK;
			Map<String,Object> postDataHeadersMap = new HashMap<>();
			Map<String,Object> postDataParamsMap = new HashMap<>();
			ObjectMapper headersObjectMapper = new ObjectMapper();
			ObjectMapper paramsObjectMapper = new ObjectMapper();
			String postDataContentType = StringPool.BLANK;
			try {
				formDefJsonObject = JSONFactoryUtil.createJSONObject(formDefinition.getFormConfig());
				if(Validator.isNotNull(formDefJsonObject) && formDefJsonObject.has(NAME)) {
					tableName = formDefJsonObject.getString(NAME);
				}
				if(Validator.isNotNull(formDefJsonObject) && formDefJsonObject.has(POST_DATA)) {
					JSONObject postDataObj = formDefJsonObject.getJSONObject(POST_DATA);
					boolean isEnabledPostData = postDataObj.getBoolean(ENABLED);
					if(isEnabledPostData) {
						JSONObject postDataSettings = postDataObj.getJSONObject(SETTINGS);
						if(Validator.isNotNull(postDataSettings)) {
							JSONObject postDataHeadersObj = null;
							JSONObject postDataParamsObj = null;
							postDataContentType = postDataSettings.getString(CONTENT_TYPE);
							postDataHeadersMap.put(HttpHeaders.CONTENT_TYPE, postDataContentType);
							String postDataAccept = postDataSettings.getString(ACCEPT);
							postDataHeadersMap.put(HttpHeaders.ACCEPT, postDataAccept);
							postDataUrl = postDataSettings.getString(URL);
							JSONArray postDataHeaders = postDataSettings.getJSONArray(HEADERS);
							for (int i = 0; i < postDataHeaders.length(); i++) {
								postDataHeadersObj = postDataHeaders.getJSONObject(i);
								postDataHeadersMap.putAll(headersObjectMapper.readValue(postDataHeadersObj.toString(), new TypeReference<Map<String, Object>>() {}));
							}
							JSONArray postDataParams = postDataSettings.getJSONArray(PARAMS);
							for (int i = 0; i < postDataParams.length(); i++) {
								postDataParamsObj = postDataParams.getJSONObject(i);
								postDataParamsMap.putAll(paramsObjectMapper.readValue(postDataParamsObj.toString(), new TypeReference<Map<String, Object>>() {}));
							}
						}
					}
				}
			} catch (JSONException e) {
				log.error(e.getMessage());
			}
			
			if(FormDataUtil.isTableNameExists(tableName)) {
				JSONArray formDefFieldsArray = null;
				Map<String, Long> masterValues = new HashMap<>();
				Map<String, Long> masterMap = new HashMap<>();
				String masterTableName = StringPool.BLANK;
				String valueColumn = StringPool.BLANK;
				String selectedValueColumn = StringPool.BLANK;
				JSONObject postDataObj = JSONFactoryUtil.createJSONObject();
				JSONObject masterJson = JSONFactoryUtil.createJSONObject();
				JSONObject rangeCommentJson = JSONFactoryUtil.createJSONObject();
				JSONObject customRangeCommentJson = JSONFactoryUtil.createJSONObject();
				Map<String, String> htmlKeyFieldNameMap = new HashMap<>();
				
				Object keyObj = null;
				try {
					formDefFieldsArray = JSONFactoryUtil.createJSONArray(formDefJsonObject.getString(FIELDS));
					boolean isMasterForm = formDefJsonObject.getBoolean("isMasterForm");
					log.info("Is Master Form ---> " + isMasterForm);
					String columnNames = StringPool.BLANK;
					String columnValues = StringPool.BLANK;
					if(Validator.isNotNull(formDefFieldsArray) && formDefFieldsArray.length()>0) {
						UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
						String postDataFieldName = null;
						for(int i=0; i<formDefFieldsArray.length(); i++) {
							postDataFieldName = StringPool.BLANK;
							keyObj = null;
							JSONObject field = (JSONObject) formDefFieldsArray.get(i);
							String key = field.getString(KEY);
					    	if(field.getJSONObject(SETTINGS).has(MASTER) || isColumnNameExists(tableName, key)) {
					    		String dataType = field.getJSONObject(SETTINGS).getString(DATA_TYPE);
					    		String type = field.getJSONObject(SETTINGS).getString(TYPE);
					    		boolean isMultiSelected = field.getJSONObject(SETTINGS).getBoolean(MULTI_SELECT);
					    		JSONObject postDataKey = field.getJSONObject(SETTINGS).getJSONObject(POST_DATA);
					    		if(Validator.isNotNull(postDataKey)) {
					    			postDataFieldName = postDataKey.getString(FIELD_NAME);
					    		}
					    		masterJson = field.getJSONObject(SETTINGS).getJSONObject(MASTER);
					    		boolean isMultiple = field.getJSONObject(SETTINGS).getBoolean(MULTIPLE);
						    	if(Validator.isNotNull(dataType)) {
						    		if(dataType.equalsIgnoreCase(STRING) && Validator.isNotNull(type) && type.equalsIgnoreCase(FILE)) {
						    			FormDataUtil.saveFileData(actionRequest, deleteFileJson, recordId, isEditMode, singleFileMap,
												multipleFileMap, tableName, uploadPortletRequest, key, isMultiple);
						    		} else if(dataType.equalsIgnoreCase(STRING) && Validator.isNotNull(type) && type.equalsIgnoreCase(DROP_DOWN) && Validator.isNotNull(masterJson)) {
						    			masterTableName = masterJson.getString(MASTER_TABLE_NAME);
						    			selectedValueColumn = masterJson.getString(VALUE_COLUMN);
						    			long masterValueForDB = 0;
						    			String masterValueForEmail = StringPool.BLANK;
						    			if(Validator.isNotNull(ParamUtil.getString(actionRequest, key))) {
						    				masterValueForDB = Long.valueOf(ParamUtil.getString(actionRequest, key).split("##")[0]);
						    				masterValueForEmail = ParamUtil.getString(actionRequest, key).split("##")[1];
						    			}
						    			valueColumn = masterTableName + "_" + selectedValueColumn;
						    			masterMap.put(valueColumn, masterValueForDB);
						    			masterValues.put(masterTableName, masterValueForDB);
						    		} else if((dataType.equalsIgnoreCase(STRING) || dataType.equalsIgnoreCase(INTEGER)) && Validator.isNotNull(type) &&
						    				(type.equalsIgnoreCase(RANGE) || type.equalsIgnoreCase(CUSTOM_RANGE))){
						    			String rangeData = StringPool.BLANK;
						    			if(isMasterForm) {
						    				rangeData = getTextboxTextareaInputValues(actionRequest, key, type, isMasterForm, null);
						    			} else {
					    					String rangeValue = ParamUtil.getString(actionRequest, key);
							    			String[] rangeValueSplit = rangeValue.split("_");
							    			String value = StringPool.BLANK, text = StringPool.BLANK, comment = StringPool.BLANK;
							    			if(Validator.isNotNull(ParamUtil.getString(actionRequest, key))) {
								    	        value = rangeValueSplit[0];
								    	        if(rangeValueSplit.length>1) {
								    	        	text = rangeValueSplit[1];
								    	        } else {
								    	        	text = StringPool.BLANK;
								    	        }
							    			}
							    			rangeCommentJson = field.getJSONObject(SETTINGS).getJSONObject("rangeConfig");
							    			customRangeCommentJson = field.getJSONObject(SETTINGS).getJSONObject("customRangeConfig");
							    			if(Validator.isNotNull(rangeCommentJson)) {
							    				boolean isComment = rangeCommentJson.getBoolean("isRangeComment");
								    			if(Validator.isNotNull(isComment) && isComment) {
								    				comment = ParamUtil.getString(actionRequest, "rangeComment_"+key);
								    			}
							    			}
							    			
							    			if(Validator.isNotNull(customRangeCommentJson)) {
							    				boolean isComment = customRangeCommentJson.getBoolean("isRangeComment");
								    			if(Validator.isNotNull(isComment) && isComment) {
								    				comment = ParamUtil.getString(actionRequest, "rangeComment_"+key);
								    			}
							    			}
							    			
							    	        JSONObject rangeJSON = JSONFactoryUtil.createJSONObject();
							    	        rangeJSON.put("text", text);
							    	        rangeJSON.put("value", value);
							    	        rangeJSON.put("comment", comment);
							    	        rangeData = rangeJSON.toString();
						    			}
						    			if(!isEditMode) {
							    	        columnNames = columnNames + key + StringPool.COMMA;
						    				columnValues = columnValues + "'" + rangeData + "'"+StringPool.COMMA;
						    			} else {
						    				editModeColumns = editModeColumns + key + StringPool.EQUAL + "'" + rangeData + "'"+StringPool.COMMA;
						    			}
						    		} else if(dataType.equalsIgnoreCase(STRING) && Validator.isNotNull(type) && type.equalsIgnoreCase(DROP_DOWN) && isMultiSelected) {
						    			String dropdownValues = StringPool.BLANK;
						    			if(isMasterForm) {
						    				dropdownValues = getTextboxTextareaInputValues(actionRequest, key, type, isMasterForm, null);
						    			} else {
						    				String[] values = ParamUtil.getStringValues(actionRequest, key);
							    			columnNames = columnNames + key + StringPool.COMMA;
							    			dropdownValues = String.join(",", values);
						    			}
						    			columnValues = columnValues + "'" + dropdownValues + "'"+StringPool.COMMA;
						    		} else if(dataType.equalsIgnoreCase(STRING) && Validator.isNotNull(type) && type.equalsIgnoreCase(CHECKBOX)) {
						    			String checkboxValues = StringPool.BLANK;
						    			if(isMasterForm) {
						    				checkboxValues = getTextboxTextareaInputValues(actionRequest, key, type, isMasterForm, null);
						    			} else {
						    				String[] values = ParamUtil.getStringValues(actionRequest, key);
							    			columnNames = columnNames + key + StringPool.COMMA;
							    			checkboxValues = String.join(",", values);
						    			}
						    			columnValues = columnValues + "'" + checkboxValues + "'"+StringPool.COMMA;
						    		} else if(dataType.equalsIgnoreCase(LONGTEXT) && Validator.isNotNull(type) && type.equalsIgnoreCase(HTML)) {
										if(!isEditMode) {
											htmlKeyFieldNameMap.put(key, postDataFieldName);
						    			}
						    		} else if(dataType.equalsIgnoreCase(LONGTEXT) && Validator.isNotNull(type) && type.equalsIgnoreCase(TEXT_AREA)) {
						    			String keyValue = getTextboxTextareaInputValues(actionRequest, key, type, isMasterForm, null);
						    			keyObj = keyValue;
										if(!isEditMode) {
											columnNames = columnNames + key + StringPool.COMMA;
						    				columnValues = columnValues + "'" + keyValue + "'"+StringPool.COMMA;
						    			} else {
						    				editModeColumns = editModeColumns + key + StringPool.EQUAL + "'" + keyValue + "'"+StringPool.COMMA;
						    			}
						    		} else if(dataType.equalsIgnoreCase(NUMBER)) {
						    			Number keyValue = ParamUtil.getNumber(actionRequest, key);
						    			keyObj = keyValue;
						    			if(!isEditMode) {
						    				columnNames = columnNames + key + ",";
						    				columnValues = columnValues + keyValue + ",";
						    			} else {
						    				editModeColumns = editModeColumns + key + StringPool.EQUAL + keyValue + StringPool.COMMA;
						    			}
						    		} else if(dataType.equalsIgnoreCase(DATETIME)) {
						    			String keyValue = null;
						    			if(isMasterForm) {
						    				keyValue = getTextboxTextareaInputValues(actionRequest, key, type, isMasterForm, field);
						    			} else {
						    				DateFormat dateFormat = FormDataUtil.fetchDateFormatFromConfig(field);
							    			Date dateValue = ParamUtil.getDate(actionRequest, key, dateFormat);
							    			keyValue = "'" + dateValue + "'";
						    			}
						    			if(!isEditMode) {
						    				columnNames = columnNames + key + StringPool.COMMA;
							    			columnValues = columnValues + keyValue + StringPool.COMMA;
						    			} else {
						    				editModeColumns = editModeColumns + key + StringPool.EQUAL + keyValue + StringPool.COMMA;
						    			}
						    		} else {
						    			String keyValue = getTextboxTextareaInputValues(actionRequest, key, type, isMasterForm, null);
						    			keyObj = keyValue;
						    			if(!isEditMode) {
						    				columnNames = columnNames + key + StringPool.COMMA;
						    				columnValues = columnValues + "'" + keyValue + "'" +StringPool.COMMA;
						    			} else {
						    				editModeColumns = editModeColumns + key + StringPool.EQUAL + "'" + keyValue + "'"+StringPool.COMMA;
						    			}
						    		}
						    		
						    		if(Validator.isNotNull(postDataFieldName) && Validator.isNotNull(keyObj) && !isEditMode) {
						    			if(postDataContentType.equals(ContentTypes.APPLICATION_JSON)) {
						    				postDataObj.put(postDataFieldName, keyObj);
						    			}
						    			else if(postDataContentType.equals(ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED)){
						    				postDataParamsMap.put(postDataFieldName, keyObj);
						    			}
						    		}
						    	}
					    	} else {
					    		log.error("column doesn't exists");
					    	}
						}
						String htmlData = ParamUtil.getString(actionRequest, HTML_DATA);
   						if(Validator.isNotNull(htmlData)) {
							JSONArray htmlArray = JSONFactoryUtil.createJSONArray(htmlData);
							for(int i=0; i<htmlArray.length(); i++) {
								keyObj = null;
								JSONObject htmlJson = (JSONObject) htmlArray.get(i);
								String key = htmlJson.getString(KEY);
								String enUSKeyValue = ParamUtil.getString(actionRequest, 
										key + StringPool.UNDERLINE + ENGLISH_LANGUAGE_CODE);
								log.info("Original HTML Data :: " + enUSKeyValue);
								if(isColumnNameExists(tableName, key)) {
									String decryptedResponse = StringPool.BLANK;
									if(isMasterForm) {
										String decryptedEnUSResponse = htmlJson.getJSONObject(VALUE).getString(ENGLISH_LANGUAGE_CODE);
										String decryptedArSAResponse = htmlJson.getJSONObject(VALUE).getString(ARABIC_LANGUGAE_CODE);
										decryptedResponse = XML_DATA_TEMPLATE.replace("[0]", decryptedEnUSResponse).
					    						replace("[1]", decryptedArSAResponse);
									} else {
										decryptedResponse = htmlJson.getString(VALUE);
									}
									keyObj = decryptedResponse;
									if(!isEditMode) {
										columnNames = columnNames + key + StringPool.COMMA;
						    			columnValues = columnValues + StringPool.APOSTROPHE + decryptedResponse + StringPool.APOSTROPHE + 
						    					StringPool.COMMA;
					    			} else {
					    				editModeColumns = editModeColumns + key + StringPool.EQUAL + "'" + decryptedResponse + "'"+StringPool.COMMA;
					    			}
								}
								if(Validator.isNotNull(htmlKeyFieldNameMap.get(key)) && Validator.isNotNull(keyObj)) {
									if(postDataContentType.equals(ContentTypes.APPLICATION_JSON)) {
										postDataObj.put(htmlKeyFieldNameMap.get(key), keyObj);
					    			}
					    			else if(postDataContentType.equals(ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED)){
					    				postDataParamsMap.put(htmlKeyFieldNameMap.get(key), keyObj);
					    			}
								}
							}
						}
   						
   						
						if(isColumnNameExists(tableName, FORM_DEFINITION_ID_COLUMN) && !isEditMode) {
							columnNames = columnNames + FORM_DEFINITION_ID_COLUMN + StringPool.COMMA;
							columnValues = columnValues + formDefinitionId + StringPool.COMMA;
						}
						if(isColumnNameExists(tableName, FORM_VERSION_COLUMN) && !isEditMode) {
							columnNames = columnNames + FORM_VERSION_COLUMN + StringPool.COMMA;
							columnValues = columnValues + "'" + formDefinition.getFormVersion()+ "'" + StringPool.COMMA;
						}
						if(isColumnNameExists(tableName, CREATEDBY) && !isEditMode) {
							columnNames = columnNames + CREATEDBY + StringPool.COMMA;
							columnValues = columnValues + themeDisplay.getUserId() + StringPool.COMMA;
						}
						if(isColumnNameExists(tableName, CREATEDDATE) && !isEditMode) {
							columnNames = columnNames + CREATEDDATE + StringPool.COMMA;
							columnValues = columnValues + "'" + DateUtil.getLongFormatDate(currentDate) + "'" + StringPool.COMMA;
						}
						if(isColumnNameExists(tableName, MODIFIEDBY)) {
							if(!isEditMode) {
								columnNames = columnNames + MODIFIEDBY + StringPool.COMMA;
								columnValues = columnValues + themeDisplay.getUserId() + StringPool.COMMA;
			    			}else {
			    				editModeColumns = editModeColumns + MODIFIEDBY + StringPool.EQUAL + themeDisplay.getUserId() + StringPool.COMMA;
			    			}
						}
						if(isColumnNameExists(tableName, MODIFIEDDATE)) {
							if(!isEditMode) {
								columnNames = columnNames + MODIFIEDDATE + StringPool.COMMA;
								columnValues = columnValues + "'" + DateUtil.getLongFormatDate(currentDate) + "'" + StringPool.COMMA;
			    			}else {
			    				editModeColumns = editModeColumns + MODIFIEDDATE + StringPool.EQUAL + "'" + DateUtil.getLongFormatDate(currentDate) + "'";
			    			}
						}
						if(isColumnNameExists(tableName, GROUPID) && !isEditMode) {
							columnNames = columnNames + GROUPID + StringPool.COMMA;
							columnValues = columnValues + themeDisplay.getScopeGroupId() + StringPool.COMMA;
						}
						if(isColumnNameExists(tableName, COMPANYID) && !isEditMode) {
							columnNames = columnNames + COMPANYID;
							columnValues = columnValues + themeDisplay.getCompanyId();
						}
                        if(!isMasterForm && isColumnNameExists(tableName, LANGUAGE_ID) && !isEditMode) {
                            columnNames =  columnNames + StringPool.COMMA + LANGUAGE_ID;
                            columnValues = columnValues + StringPool.COMMA + "'" + themeDisplay.getLanguageId() + "'";
                        }
                        
						long latestRecordId = 0l;
						boolean success = false;
						if(!isEditMode) {
							success = insertIntoTable(tableName, columnNames, columnValues);
							if(success) {
								latestRecordId = formDefinitionLocalService.getSelectLatestRecord(FormDataUtil.formatFormName(tableName));
							}
		    			} else {
		    				FormDataUtil.updateMasterTableData(recordIdParam, editModeColumns, tableName, masterValues, masterMap);
		    			}
   						
						//for deleting file
						FormDataUtil.deleteFile(actionRequest, formDefinitionId, deleteFileJson, recordId, themeDisplay, fileNames,
								fileCounter, singleFileMap, multipleFileMap, tableName, uploadPortletRequest);
   						
   						if(recordId > 0) {
   							FormDataUtil.saveFileEntry(actionRequest, formDefinitionId, themeDisplay, fileNames, fileCounter, singleFileMap, multipleFileMap, tableName, 
									uploadPortletRequest, recordId);
   							log.info("In save file");
   							log.info("formDefinitionId :: "+formDefinitionId);
   							log.info("multipleFileMap :: "+multipleFileMap);
   							log.info("fileNames :: "+fileNames);
   							log.info("tableName :: "+tableName);
   							log.info("recordId :: "+recordId);
   						}
   						
						log.info("latestRecordId -- " + latestRecordId);
						if(latestRecordId>0) {
							FormDataUtil.saveFileEntry(actionRequest, formDefinitionId, themeDisplay, fileNames, fileCounter, singleFileMap, multipleFileMap, tableName, 
									uploadPortletRequest, latestRecordId);
							
							//save master table data
							if(Validator.isNotNull(masterValues) && !masterValues.isEmpty() && masterValues.size()>0) {
								FormDataUtil.saveMasterTableData(formDefinitionId, themeDisplay, currentDate, tableName,
										masterValues, masterMap, latestRecordId);
							}
							
							//Post Data
							if(Validator.isNotNull(postDataUrl)) {
								String postDataResponse = WebServiceUtil.post(postDataUrl, postDataObj.toJSONString(), postDataHeadersMap, postDataParamsMap);
								log.info("postDataResponse: " + postDataResponse);
							}
						} else {
							log.error("Error while inserting new record");
						}
						
						FormDataUtil.saveDataInFormRecordEntry(serviceContext, formDefinitionId, workflowDefinition,
								formRecordEntryId, recordId, themeDisplay, tableName, latestRecordId);
						 
					} else {
						log.error("no fields found");
					}
					
					// Email Will Be Sent
					long companyId = PortalUtil.getDefaultCompanyId();
					String emailFrom = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
					log.info("emailFrom :: "+emailFrom);
					serviceContext.setAttribute("emailFrom", emailFrom);
					serviceContext.setAttribute("selectedEmailTemplateId", selectedEmailTemplateId);
					serviceContext.setAttribute("groupId", themeDisplay.getScopeGroupId());
				} catch (JSONException e) {
					log.info(e.getMessage());
				}
			}
		} else {
			log.error("FormDefinition not found");
		}
		preferences.setValue(FormBuilderConstants.FORM_DEFINITION_ID, StringPool.BLANK);
        preferences.setValue(FormBuilderConstants.FORM_NAME, StringPool.BLANK);
        preferences.setValue(FormBuilderConstants.FORM_VERSION, StringPool.BLANK);
        //preferences.setValue(FormBuilderConstants.FORM_MODE, FormBuilderConstants.VIEW);
        preferences.store();
		actionResponse.sendRedirect(redirectURL);
	}

	private String getTextboxTextareaInputValues(ActionRequest actionRequest, String key, String type, boolean isMasterForm, JSONObject field) {
		String keyValue = StringPool.BLANK;
		if(isMasterForm ) {
			if(type.equals(DROP_DOWN) || type.equals(CHECKBOX)) {
				String[] values = ParamUtil.getStringValues(actionRequest, key);
				String checkboxValues = String.join(",", values);
				keyValue = XML_DATA_TEMPLATE.replace("[0]", checkboxValues).
						replace("[1]", checkboxValues);
			} else if(type.equals(RANGE) || type.equals(CUSTOM_RANGE)) {
				String rangeValue = ParamUtil.getString(actionRequest, key);
    			String[] rangeValueSplit = rangeValue.split("_");
    	        String value = rangeValueSplit[0];
    	        String text = rangeValueSplit[1];
    	        JSONObject rangeJSON = JSONFactoryUtil.createJSONObject();
    	        rangeJSON.put("text", text);
    	        rangeJSON.put("value", value);
    	        String rangeData = rangeJSON.toString();
    	        keyValue = XML_DATA_TEMPLATE.replace("[0]", rangeData).
						replace("[1]", rangeData);
			} else if(type.equals(DATETIME)) {
				DateFormat dateFormat = FormDataUtil.fetchDateFormatFromConfig(field);
    			Date value = ParamUtil.getDate(actionRequest, key, dateFormat);
    			keyValue = XML_DATA_TEMPLATE.replace("[0]", "'" + value + "'").
 						replace("[1]", "'" + value + "'");
			} else if(type.equals(RADIO) || type.equals(DATE) || type.equals(TIME)) {
				String values = ParamUtil.getString(actionRequest, key);
				keyValue = XML_DATA_TEMPLATE.replace("[0]", values).
						replace("[1]", values);
			} else {
				String enUSKeyValue = HtmlUtil.escape(ParamUtil.getString(actionRequest, 
						key + StringPool.UNDERLINE + ENGLISH_LANGUAGE_CODE));
				String arSAKeyValue = HtmlUtil.escape(ParamUtil.getString(actionRequest, key + 
						StringPool.UNDERLINE + ARABIC_LANGUGAE_CODE));
				keyValue = XML_DATA_TEMPLATE.replace("[0]", enUSKeyValue).
						replace("[1]", arSAKeyValue);
			}
			
			
		} else {
			keyValue = ParamUtil.getString(actionRequest, key);					    				
		}
		
		return keyValue;
		
	}
	
	private boolean insertIntoTable(String tableName, String columnNames, String columnValues) {
		return formDefinitionLocalService.insertIntoTable(FormDataUtil.formatFormName(tableName), columnNames, columnValues);
	}
	
	private boolean isColumnNameExists(String tableName, String key) {
		List<String> columnNames = formDefinitionLocalService.getColumnNames("'"+FormDataUtil.formatFormName(tableName)+"'");
		return (Validator.isNotNull(columnNames) && !columnNames.isEmpty() && columnNames.contains(key.toLowerCase()));
	}

}
