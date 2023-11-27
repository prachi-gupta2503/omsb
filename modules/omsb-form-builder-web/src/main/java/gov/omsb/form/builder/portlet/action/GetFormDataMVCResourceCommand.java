package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.*;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + MVCCommandNames.GET_FORM_DATA
	    }, 
	    service = MVCResourceCommand.class
)

public class GetFormDataMVCResourceCommand extends BaseMVCResourceCommand {
	public static final String SELECTED_TABLE_NAME = "selectedTableName";
	public static final String BIGINT = "bigint";
	public static final String FETCH_COLUMN_NAMES = "fetchColumnNames";
	private static final Log log = LogFactoryUtil.getLog(GetFormDataMVCResourceCommand.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("### Getting Form Basic Section ###");
		long formDefinitionId = ParamUtil.getLong(resourceRequest, FORM_DEFINITION_ID);
		String cmd = ParamUtil.getString(resourceRequest, CMD);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		
		if(Validator.isNotNull(cmd) && !cmd.isBlank() && cmd.equalsIgnoreCase(POPULATE_MASTER_DROPDOWN)) {
			PrintWriter writer = null;
			String masterTableName = ParamUtil.getString(resourceRequest, TABLE_NAME);
			String textColumn = ParamUtil.getString(resourceRequest, TEXT_COLUMN);
			String valueColumn = ParamUtil.getString(resourceRequest, VALUE_COLUMN);
			String columnName = textColumn + StringPool.COMMA + valueColumn;
			JSONArray masterTableData = formDefinitionLocalService.getDataSelectQuery(masterTableName, columnName, StringPool.BLANK);
			JSONArray formattedDataJSON = JSONFactoryUtil.createJSONArray();
			for(int i = 0; i< masterTableData.length(); i++) {
				JSONObject singleJSONDataObj = masterTableData.getJSONObject(i);
				Iterator<String> keys = singleJSONDataObj.keys();
				while(keys.hasNext()) {
				    String key = keys.next();
				    if(key.equals(textColumn) && singleJSONDataObj.getString(key).contains("xml")) {
					    JSONArray jsonArray = parseXML(singleJSONDataObj.getString(key), StringPool.BLANK, true);
				    	singleJSONDataObj.put(key, jsonArray);
				    } else {
				    	singleJSONDataObj.put(key, singleJSONDataObj.getString(key));
				    }
				}
				formattedDataJSON.put(singleJSONDataObj);
			}
			responseObj.put(MASTER_TABLE_DROPDOWN_ARR, formattedDataJSON);
			responseObj.put(TEXT_COLUMN, textColumn);
			responseObj.put(VALUE_COLUMN, valueColumn);
			responseObj.put(STATUS, SUCCESS);
			try {
				writer = resourceResponse.getWriter();
			} catch (IOException io) {
				log.info("Error while getting writer");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
			}
		} else if(Validator.isNotNull(cmd) && !cmd.isBlank() && cmd.equalsIgnoreCase(FETCH_COLUMN_NAMES)) {
			PrintWriter writer = null;
			String selectedTableName = ParamUtil.getString(resourceRequest, SELECTED_TABLE_NAME);
			JSONObject columnNamesWithDT = formDefinitionLocalService.getColumnNamesWithDatatype(selectedTableName);
			JSONArray textColumnsArr = JSONFactoryUtil.createJSONArray();
			JSONArray valueColumnsArr = JSONFactoryUtil.createJSONArray();
			JSONArray key = columnNamesWithDT.names();
			for (int i = 0; i < key.length(); ++i) {
			   String keys = key.getString(i); 
			   String value = columnNamesWithDT.getString(keys);
			   if((value.equalsIgnoreCase(BIGINT) || value.equalsIgnoreCase(INTEGER)) && !(keys.contains(GROUPID) || keys.contains(RECORD_ID_COLUMN) || keys.contains(FORM_DEFINITION_ID_COLUMN) || keys.contains(COMPANYID) || keys.contains(CREATEDBY) || keys.contains(MODIFIEDBY))) {
				   valueColumnsArr.put(keys);
			   }
			   textColumnsArr.put(keys); 
			}
			responseObj.put(TEXT_COLUMNS, textColumnsArr);
			responseObj.put(VALUE_COLUMNS, valueColumnsArr);
			responseObj.put(STATUS, SUCCESS);
			try {
				writer = resourceResponse.getWriter();
			} catch (IOException io) {
				log.info("Error while getting writer");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
			}
		} else if(Validator.isNotNull(cmd) && !cmd.isBlank() && cmd.equalsIgnoreCase(FETCH_EDIT_COLUMN_NAMES)) {
			PrintWriter writer = null;
			String selectedTableName = ParamUtil.getString(resourceRequest, SELECTED_TABLE_NAME);
			JSONObject columnNamesWithDT = formDefinitionLocalService.getColumnNamesWithDatatype(selectedTableName);
			JSONArray textColumnsArr = JSONFactoryUtil.createJSONArray();
			JSONArray key = columnNamesWithDT.names();
			for (int i = 0; i < key.length(); ++i) {
			   String keys = key.getString(i); 
			   textColumnsArr.put(keys); 
			}
			responseObj.put(TEXT_COLUMNS, textColumnsArr);
			responseObj.put(STATUS, SUCCESS);
			try {
				writer = resourceResponse.getWriter();
			} catch (IOException io) {
				log.info("Error while getting writer");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
			}
		} else {
			PrintWriter writer = null;
			List<String> formNames = new ArrayList<>();
			JSONArray formDataArray = JSONFactoryUtil.createJSONArray();
			List<String> columnNames = new ArrayList<>();
			JSONArray tableNamesArray = FormConfigurationUtil.getAllTables();
			try {
				writer = resourceResponse.getWriter();
				HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
				
				String activeLangKey =  LanguageUtil.get(request, ACTIVE);
				String inActiveLangKey =  LanguageUtil.get(request, INACTIVE);
				String yesLangKey =  LanguageUtil.get(request, YES);
				String noLangKey =  LanguageUtil.get(request, NO);
				
				List<FormDefinition> formDefinitions = formDefinitionLocalService.getFormDefinitions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				if(Validator.isNotNull(formDefinitions)) {
					for(FormDefinition formDefinition :formDefinitions) {
						String formName = formDefinition.getFormName();
						formNames.add(formName);
					}
				}
				
				FormDefinition formDefinition = null;
				if(formDefinitionId > 0) {
					formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
					String formName = formDefinition.getFormName();
					String formattedFormName = formName.replaceAll("\\s+", "_");
					String tableName = "df_"+formattedFormName.toLowerCase();
					List<String> columns = formDefinitionLocalService.getColumnNames("'"+tableName+"'");
					for(String column: columns) {
						columnNames.add(column);
					}
				}
				
				if(Validator.isNotNull(formDefinition)) {
					formDefinitionId = formDefinition.getFormDefinitionId();
					String formConfig = formDefinition.getFormConfig();
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(formConfig);
					JSONArray fieldsArray = jsonObject.getJSONArray(FIELDS);
					JSONObject formFieldObj = null;
					JSONObject resultFieldObj = null;
					for (int i = 0; i < fieldsArray.length(); i++) {
						formFieldObj = fieldsArray.getJSONObject(i);
						JSONObject settingObj = formFieldObj.getJSONObject(SETTINGS);
						JSONObject labelObj = formFieldObj.getJSONObject(LABEL);
						resultFieldObj = JSONFactoryUtil.createJSONObject();
						resultFieldObj.put(SR_NO, formFieldObj.get(SR_NO));
						resultFieldObj.put(FIELD_LABEL, labelObj.get(ENGLISH_LANGUAGE_CODE));
						resultFieldObj.put(FIELD_KEY, formFieldObj.get(KEY));
						resultFieldObj.put(FIELD_TYPE, settingObj.get(TYPE));
						resultFieldObj.put(FIELD_DATA_TYPE, settingObj.get(DATA_TYPE));
						String status = StringPool.BLANK;
						if(Validator.isNotNull(settingObj.get(STATUS))) {
							status = settingObj.get(STATUS).equals(ACTIVE) ? activeLangKey : inActiveLangKey;
						}
						resultFieldObj.put(FIELD_STATUS, status);
						String disabled = StringPool.BLANK, required = StringPool.BLANK, readonly = StringPool.BLANK;
						if(Validator.isNotNull(settingObj.get(DISABLED))) {
							disabled = settingObj.getBoolean(DISABLED) ? yesLangKey : noLangKey;
						}
						if(Validator.isNotNull(settingObj.get(REQUIRED))) {
							required = settingObj.getBoolean(REQUIRED) ? yesLangKey : noLangKey;
						}
						if(Validator.isNotNull(settingObj.get(READONLY))) {
							readonly = settingObj.getBoolean(READONLY) ? yesLangKey : noLangKey;
						}
						resultFieldObj.put(FIELD_DISABLED, disabled);
						resultFieldObj.put(FIELD_REQUIRED, required);
						resultFieldObj.put(FIELD_READONLY, readonly);
						resultFieldObj.put(FIELD_JSON_OBJ, formFieldObj);
						formDataArray.put(resultFieldObj);
					}
					responseObj.put(WORKFLOW_STATUS, formDefinition.getStatus());
					responseObj.put(FORM_CONFIG, formConfig);
				}
				responseObj.put(FORM_NAMES, formNames);
				responseObj.put(COLUMN_NAMES, columnNames);
				responseObj.put(DATA, formDataArray.toJSONString());
				responseObj.put(TABLE_NAMES, tableNamesArray);
				responseObj.put(STATUS, SUCCESS);
			} catch (Exception e) {
				log.error("GetFormDataMVCResourceCommand >>> doServeResource >>>  Error occured while fetching Data -> " + e.getMessage());
				responseObj.put(FORM_NAMES, formNames);
				responseObj.put(COLUMN_NAMES, columnNames);
				responseObj.put(STATUS, ERROR);
				responseObj.put(MESSAGE, "Error occured while fetching Data.");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
				log.info("GetFormDataMVCResourceCommand >>> doServeResource >>>  Data retrieved successfully");
			}
		}
	}
	
	public JSONArray parseXML(String content, String languageId, boolean isMasterForm) {
	
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject singleLocaleJSONObject = JSONFactoryUtil.createJSONObject();
		
		if(isMasterForm) {
			try {
	            Document document = SAXReaderUtil.read(content);
	            Element rootElement = document.getRootElement();
	            XPath xPath = SAXReaderUtil.createXPath("//dynamic-content");
	            
	            List<Node> exampleElements = xPath.selectNodes(rootElement);

	            for (Node node : exampleElements) {
	            	Element element = (Element)node;
	            	String elementLanguageId = element.attributeValue("language-id");
	            	String elementValue = node.getText();
	            	
	            	singleLocaleJSONObject.put(elementLanguageId, elementValue.trim());	                
	            }
	        } catch (Exception e) {
	            log.error("Exception Occurred while Parsing XML :: " + e.getMessage());
	        }
		} else {
			if(languageId.equals(FormBuilderConstants.ENGLISH_LANGUAGE_CODE)) {
				singleLocaleJSONObject.put(FormBuilderConstants.ENGLISH_LANGUAGE_CODE, content);
				singleLocaleJSONObject.put(FormBuilderConstants.ARABIC_LANGUGAE_CODE, StringPool.BLANK);
			} else if(languageId.equals(FormBuilderConstants.ARABIC_LANGUGAE_CODE)) {
				singleLocaleJSONObject.put(FormBuilderConstants.ENGLISH_LANGUAGE_CODE, StringPool.BLANK);
				singleLocaleJSONObject.put(FormBuilderConstants.ARABIC_LANGUGAE_CODE, content);
			}
		}
		
		jsonArray.put(singleLocaleJSONObject);
        
        return jsonArray;
    }

	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
}
