package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.*;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.portlet.util.FormDataUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + MVCCommandNames.SAVE_FORM_CONFIGURATION
	    }, 
	    service = MVCResourceCommand.class
)
public class SaveFormConfigurationMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(SaveFormConfigurationMVCResourceCommand.class);

	private static final String ID = "Id";
	private static final String VARCHAR = "VARCHAR(75) DEFAULT NULL";
	private static final String BIGINT = "BIGINT DEFAULT NULL";
	private static final String TIMESTAMP = "timestamp DEFAULT NULL";
	private static final String TEXT = "TEXT DEFAULT NULL";
	private static final String NUMERIC = "NUMERIC DEFAULT NULL";

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(FormDefinition.class.getName(), resourceRequest);
		int actionType = ParamUtil.getInteger(resourceRequest, ACTION_TYPE, 0);
		String encryptedData = ParamUtil.getString(resourceRequest, ENCRYPTED_FORM_DATA, StringPool.BLANK);
		long formDefinitionId = ParamUtil.getLong(resourceRequest, "formDefinitionId");
		log.info("Form definition Id: "+formDefinitionId);
		String formData = FormDataUtil.decryptEncryptedData(encryptedData);

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject myObject = JSONFactoryUtil.createJSONObject(formData);
		String formName = myObject.getString(NAME);
		String formTitle = myObject.getString(TITLE);
		boolean isMasterForm = myObject.getBoolean(IS_MASTER_FORM);
		String formConfig = myObject.toString();
		String formDescription = myObject.getString(DESCRIPTION);
		JSONArray fieldsArray = myObject.getJSONArray(FIELDS);
		String formattedFormName = formName.replaceAll("\\s+", StringPool.UNDERLINE);
		String formVersion = null;
		String columnName = StringPool.BLANK;
		String dataType = StringPool.BLANK;
		String key = StringPool.BLANK;
		Integer formDefinitionWorkflowStatus = null;
		String tableName = FormBuilderConstants.DF + StringPool.UNDERLINE + formattedFormName.toLowerCase();
		String workflowDefinition = myObject.getString(WORKFLOW_DEFINITION);
		FormDefinition formDefinition = null;
		List<String> columnNames = new ArrayList<>();
		boolean isPageReload = Boolean.FALSE;
		
		if (Validator.isNotNull(tableName)) {
			try {
				log.info("formattedFormName: "+tableName);
				if(formDefinitionId <= 0 && (actionType == SUBMIT_FORM || actionType == BASIC_SECTION_SAVE)) {
					log.info("### Creating New Table ###");
					if(actionType == SUBMIT_FORM) {
						formVersion = String.valueOf(1.0);
					}
					formConfigurationUtil.createTable(tableName);
					log.info("### Table Created ###");
				} else if(formDefinitionId > 0 && actionType == SUBMIT_FORM) {
					formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
					formVersion = formDefinition.getFormVersion();
				}
				
				//Adding Form Definition in df_form_definition
				formDefinition = formConfigurationUtil.addEditFormDefinition(serviceContext, formDefinitionId, themeDisplay, formName, formDescription, formTitle, formConfig, formVersion, actionType, workflowDefinition);
				formDefinitionId = formDefinition.getFormDefinitionId();
				formDefinitionWorkflowStatus = formDefinition.getStatus();
				formConfig = formDefinition.getFormConfig();
				if(Validator.isNotNull(formConfig) && actionType == SUBMIT_FORM && fieldsArray.length() > 0) {
					isPageReload = Boolean.TRUE;
				}
				//Adding New columns in table which is created
				// Add/Edit Form Config and columns
				if(Validator.isNotNull(formConfig) && actionType != DELETE_SECTION_SAVE && (Validator.isNotNull(fieldsArray))) {
					for (int i = 0; i < fieldsArray.length(); i++) {
						JSONObject fieldObject = fieldsArray.getJSONObject(i);
						key = fieldObject.getString(KEY);
						dataType = fieldObject.getJSONObject(SETTINGS).getString(DATA_TYPE);
						if(fieldObject.getJSONObject(SETTINGS).getString(TYPE).equalsIgnoreCase(DROP_DOWN) && 
							fieldObject.getJSONObject(SETTINGS).has(MASTER)) {
							String selectedMasterTableName = fieldObject.getJSONObject(SETTINGS).getJSONObject(MASTER).getString(MASTER_TABLE_NAME);
							String masterTableName = tableName + StringPool.UNDERLINE + selectedMasterTableName;
							boolean isCreateMasterTable = fieldObject.getJSONObject(SETTINGS).getJSONObject(MASTER).getBoolean(CREATE_NEW_MAPPING_TABLE);
							boolean isCreateMappingsTable = fieldObject.getJSONObject(SETTINGS).getJSONObject(MASTER).getBoolean(CREATE_FORM_MAPPINGS_TABLE);
							String createNewMappingTable = StringPool.BLANK;
							String mappingsTableName = tableName + StringPool.UNDERLINE + MAPPINGS;
							if(masterTableName.endsWith("_")) {
								masterTableName = masterTableName.substring(0, masterTableName.length() - 1);
								createNewMappingTable = masterTableName + StringPool.UNDERLINE + MAPPING;
							} else {
								createNewMappingTable = masterTableName + StringPool.UNDERLINE + MAPPING;
							}
							String paramValueColumn = fieldObject.getJSONObject(SETTINGS).getJSONObject(MASTER).getString(VALUE_COLUMN);
							String valueColumn = selectedMasterTableName + "_" + paramValueColumn;
							//If condition if Yes selected for mapping and else for no
							if(isCreateMasterTable && !FormConfigurationUtil.isTableExists(createNewMappingTable)) {
								formDefinitionLocalService.createMasterTableMapping(createNewMappingTable, valueColumn);
							} else if(isCreateMasterTable && FormConfigurationUtil.isTableExists(createNewMappingTable)) {
								dataType = BIGINT;
								formConfigurationUtil.addColumn(createNewMappingTable, valueColumn, dataType);
							} else if(isCreateMappingsTable && !isCreateMasterTable && !FormConfigurationUtil.isTableExists(mappingsTableName)) {
								formDefinitionLocalService.createMasterTable(mappingsTableName, valueColumn);
							} else {
								dataType = BIGINT;
								formConfigurationUtil.addColumn(mappingsTableName, valueColumn, dataType);
							}
							
						} else {
							if (isMasterForm && dataType.equals(STRING)) {
								dataType = TEXT;
							} else if(!isMasterForm && dataType.equals(STRING)) {
								dataType = VARCHAR;
							} else if (dataType.equals(LONG)) {
								dataType = BIGINT;
							} else if (dataType.equals(DATE_TIME)) {
								dataType = TIMESTAMP;
							}  else if (dataType.equals(LONGTEXT)) {
								dataType = TEXT;
							} else if (dataType.equals(NUMBER)) {
								dataType = NUMERIC;
							}
							columnName = key;
							formConfigurationUtil.addColumn(tableName, columnName, dataType);
						}
					}
				}
				
				if(formDefinitionId > 0) {
					List<String> columns = formDefinitionLocalService.getColumnNames("'"+tableName+"'");
					if(!isMasterForm && !columns.contains(LANGUAGE_ID_COLUMN)) {
						formConfigurationUtil.addColumn(tableName, LANGUAGE_ID, VARCHAR);
					}
					for(String column: columns) {
						columnNames.add(column);
					}
				}	
				
			}catch(Exception e) {
				log.error("Exception Occured while Adding" + e.getMessage());
			}
		}
	
		PrintWriter writer = null;
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		try {
			writer = resourceResponse.getWriter();
			responseObj.put(FORM_DEFINITION_ID, formDefinitionId);
			responseObj.put("encryptedData", encryptedData);
			responseObj.put(COLUMN_NAMES, columnNames);
			responseObj.put(STATUS, SUCCESS);
			responseObj.put(IS_PAGE_RELOAD, isPageReload);
			if(Validator.isNotNull(formDefinitionWorkflowStatus)) {
				responseObj.put(WORKFLOW_STATUS, formDefinitionWorkflowStatus);
			}
		} catch (SystemException | IOException e) {
			responseObj.put(COLUMN_NAMES, columnNames);
			responseObj.put(STATUS, ERROR);
			responseObj.put(MESSAGE, "Error occured while fetching team list.");
		} finally {
			writer.write(responseObj.toString());
			writer.close();
		}
	}
	
	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private FormConfigurationUtil formConfigurationUtil;
}
