package gov.omsb.form.builder.headless.internal.resource.v1_0;

import gov.omsb.form.builder.headless.dto.v1_0.FormDataRequest;
import gov.omsb.form.builder.headless.dto.v1_0.FormDataResponse;
import gov.omsb.form.builder.headless.resource.v1_0.GetFormDataResource;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.service.FormDefinitionLocalService;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Jinal Patel
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/get-form-data.properties",
	scope = ServiceScope.PROTOTYPE, service = GetFormDataResource.class
)
public class GetFormDataResourceImpl
	extends BaseGetFormDataResourceImpl {
	
	@Override
	public FormDataResponse getFormData(FormDataRequest FormDataRequest) throws Exception {
		
		FormDataResponse formDataResponse = new FormDataResponse();
		Long[] formDefinitionIds = FormDataRequest.getFormDefinitionIds();
		Long[] recordIds = FormDataRequest.getRecordIds();
		ArrayList<String> rangeKeys = new ArrayList<>();
		JSONObject result = JSONFactoryUtil.createJSONObject();
		if(Validator.isNotNull(formDefinitionIds) && formDefinitionIds.length > 0) {
			for(long formDefinitionId : formDefinitionIds) {
				FormDefinition formDefinition = null; 
				try {
					formDefinition = formDefinitionLocalService.getFormDefinition(formDefinitionId);
				}catch(Exception e) {
					log.error(NO_FORM_DEFINITION_FOUND_MESSAGE);
				}
				if(Validator.isNotNull(formDefinition)) {
					String tableName = FormDataUtil.formatFormName(formDefinition.getFormName());
					JSONObject formDefJsonObject = JSONFactoryUtil.createJSONObject(formDefinition.getFormConfig());
					JSONArray formDefFieldsArray = JSONFactoryUtil.createJSONArray(formDefJsonObject.getString(FIELDS));
					String columnNames = StringPool.BLANK;
					for(int i=0; i<formDefFieldsArray.length(); i++) {
						JSONObject field = (JSONObject) formDefFieldsArray.get(i);
						if(field.getString(SETTINGS).contains(MASTER)) {
							continue;
						} else if(field.getJSONObject(SETTINGS).getString(TYPE).equalsIgnoreCase(RANGE)) {
							rangeKeys.add(field.getString(KEY));
							columnNames = columnNames + field.getString(KEY) + StringPool.COMMA;
						} else {
							columnNames = columnNames + field.getString(KEY) + StringPool.COMMA;
						}
					}
					if(formDefJsonObject.getBoolean(IS_MASTER_FORM)) {
						columnNames = columnNames + FORMDEFINITIONID_FORMVERSION_ID;						
					} else {
						columnNames = columnNames + FORMDEFINITIONID_FORMVERSION_ID + StringPool.COMMA + LANGUAGE_ID;
					}
					String whereCondition = StringPool.BLANK;
					if(Validator.isNotNull(recordIds) && recordIds.length>0) {
						String recordIdsStr = FormDataUtil.toCommaSeperatedRecordIds(FormDataUtil.removeDuplicates(recordIds));
						whereCondition = WHERE_ID_IN+ StringPool.OPEN_PARENTHESIS + recordIdsStr + StringPool.CLOSE_PARENTHESIS;
					}
					JSONArray dataJson = formDefinitionLocalService.getDataSelectQuery(tableName, columnNames, whereCondition);
					log.info("dataJson :: " + dataJson);
					JSONArray formattedDataJSON = JSONFactoryUtil.createJSONArray();
					for(int i = 0; i< dataJson.length(); i++) {
						JSONObject singleJSONDataObj = dataJson.getJSONObject(i);
						Iterator<String> keys = singleJSONDataObj.keys();

						while(keys.hasNext()) {
						    String key = keys.next();
						    if(!key.equals(FORM_VERSION) && !key.equals(FORM_DEFINITION_ID) && !key.equals(ID) && !key.equals(LANGUAGE_ID)) {
						    	if(formDefJsonObject.getBoolean(IS_MASTER_FORM)) {
						    		JSONArray jsonArray = parseXML(singleJSONDataObj.getString(key), StringPool.BLANK, true);
							    	singleJSONDataObj.put(key, jsonArray);
						    	} else if(Validator.isNotNull(rangeKeys) && rangeKeys.contains(key)) {
						    		for(String rangeKey : rangeKeys){
						    			if(rangeKey.equalsIgnoreCase(key)){
						    				String decryptedResponse = new String(java.util.Base64.getDecoder().decode(singleJSONDataObj.getString(rangeKey)));
						    				JSONObject updatedResponse = JSONFactoryUtil.createJSONObject(decryptedResponse);
							    			log.info("decryptedResponse :: "+updatedResponse);
							    			singleJSONDataObj.put(rangeKey, updatedResponse);
						    			}
						    		}
						    	} else {
						    		JSONArray jsonArray = parseXML(singleJSONDataObj.getString(key), singleJSONDataObj.getString(LANGUAGE_ID), false);
							    	singleJSONDataObj.put(key, jsonArray);
						    	}
						    } else {
						    	singleJSONDataObj.put(key, singleJSONDataObj.getString(key));
						    }
						}
						formattedDataJSON.put(singleJSONDataObj);
					}
					log.info("formattedDataJSON :: "+formattedDataJSON);
					if(Validator.isNotNull(dataJson) && dataJson.length()>0) {
						result.put(formDefinitionId+StringPool.BLANK, formattedDataJSON);
					}
					
                    
				}
			}
			if(Validator.isNull(result) || (result.length()==0)) {
				formDataResponse.setMessage(NO_RESULTS_FOUND_MESSAGE);
				formDataResponse.setStatus(FAILURE_STATUS);
			} else {
				formDataResponse.setMessage(SUCCESS);
				formDataResponse.setStatus(SUCCESS);
			}
		} else {
			formDataResponse.setMessage(NO_FORM_DEFINITION_IDS_MESSAGE);
			formDataResponse.setStatus(FAILURE_STATUS);
		}
		formDataResponse.setData(result);
		return formDataResponse;
	}

	public static final String NO_FORM_DEFINITION_IDS_MESSAGE = "There are no formDefinitionIds added in the request";
	public static final String SUCCESS_STATUS_CODE_200 = "200";
	public static final String SUCCESS = "success";
	public static final String FAILURE_STATUS_CODE_400 = "400";
	public static final String FAILURE_STATUS = "Failure";
	public static final String NO_RESULTS_FOUND_MESSAGE = "No results found";
	public static final String NO_FORM_DEFINITION_FOUND_MESSAGE = "No form definition found";
	public static final String FIELDS = "fields";
	public static final String WHERE_ID_IN = "where id in ";
	public static final String FORMDEFINITIONID_FORMVERSION_ID = "formdefinitionid,formversion,id";
	public static final String KEY = "key";
	public static final String TYPE = "type";
	public static final String RANGE = "range";
	public static final String SETTINGS = "settings";
	public static final String MASTER = "master";
	public static final String LANGUAGE_ID_ELEMENT_ATTRIBUTE = "language-id";
	public static final String LANGUAGE_ID = "languageId";
	public static final String ENGLISH_LANGUAGE_ID = "en_US";
	public static final String ARABIC_LANGUAGE_ID = "ar_SA";
	public static final String FORM_VERSION = "formversion";
	public static final String FORM_DEFINITION_ID = "formdefinitionid";
	public static final String ID = "id";
	public static final String IS_MASTER_FORM = "isMasterForm";
	public static final String CONTENT_XPATH = "//-content";

	
	private static final Log log = LogFactoryUtil.getLog(GetFormDataResourceImpl.class);
	
	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
	
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
	            	String elementLanguageId = element.attributeValue(LANGUAGE_ID);
	            	String elementValue = node.getText();
	            	
	            	singleLocaleJSONObject.put(elementLanguageId, elementValue.trim());	                
	            }
	        } catch (Exception e) {
	            log.error("Exception Occurred while Parsing XML :: " + e.getMessage());
	        }
		} else {
			if(languageId.equals(ENGLISH_LANGUAGE_ID)) {
				singleLocaleJSONObject.put(ENGLISH_LANGUAGE_ID, content);
				singleLocaleJSONObject.put(ARABIC_LANGUAGE_ID, StringPool.BLANK);
			} else if(languageId.equals(ARABIC_LANGUAGE_ID)) {
				singleLocaleJSONObject.put(ENGLISH_LANGUAGE_ID, StringPool.BLANK);
				singleLocaleJSONObject.put(ARABIC_LANGUAGE_ID, content);
			}
		}
		
		jsonArray.put(singleLocaleJSONObject);
        
        return jsonArray;
    }
}