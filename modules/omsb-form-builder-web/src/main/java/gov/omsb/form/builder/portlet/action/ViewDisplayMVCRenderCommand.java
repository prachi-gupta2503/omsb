package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.ACCEPT;
import static gov.omsb.form.builder.constants.FormBuilderConstants.CONTENT_TYPE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.ENABLED;
import static gov.omsb.form.builder.constants.FormBuilderConstants.HEADERS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.KEY;
import static gov.omsb.form.builder.constants.FormBuilderConstants.PARAMS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.POPULATE_DATA;
import static gov.omsb.form.builder.constants.FormBuilderConstants.SETTINGS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.model.EmailTemplateMaster;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalServiceUtil;
import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.model.FormDefinition;
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.model.RangeOptionMaster;
import gov.omsb.form.builder.portlet.util.FormConfigurationUtil;
import gov.omsb.form.builder.portlet.util.FormDataUtil;
import gov.omsb.form.builder.portlet.util.FormRendererUtil;
import gov.omsb.form.builder.portlet.util.FormUtil;
import gov.omsb.form.builder.portlet.util.WebServiceUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil;
import gov.omsb.form.builder.service.FormRecordEntryLocalService;
import gov.omsb.form.builder.service.RangeOptionMasterLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=/"
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewDisplayMVCRenderCommand implements MVCRenderCommand{
	
	private static Log log = LogFactoryUtil.getLog(ViewDisplayMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = renderRequest.getPreferences();
		String formMode = preferences.getValue(FormBuilderConstants.FORM_MODE, StringPool.BLANK);
		String formName = preferences.getValue(FormBuilderConstants.FORM_NAME, StringPool.BLANK);
		String formVersion = preferences.getValue(FormBuilderConstants.FORM_VERSION, StringPool.BLANK);
		String workflowDefinition = preferences.getValue(FormBuilderConstants.WORKFLOW_DEFINITION, StringPool.BLANK);
		JSONArray workflowDefinitionArr = FormUtil.getWorkflowDefinitions(renderRequest, themeDisplay);
		
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String formDefinitionId = originalRequest.getParameter("formDefinitionId");
		String recordId = originalRequest.getParameter("recordId");
		String formRecordEntrymode = originalRequest.getParameter("formRecordEntryMode");
		
		JSONObject rolesJson = _formConfigurationUtil.getFormBuilderRoles(themeDisplay);
		renderRequest.setAttribute("rolesJson", rolesJson);
		
		List<Long> userRoles = new ArrayList<>();
		boolean isAdmin = false;
		for(Role role : themeDisplay.getUser().getRoles()) {
			userRoles.add(role.getRoleId());
			if("Administrator".equalsIgnoreCase(role.getName()) || "Admin".equalsIgnoreCase(role.getName())) {
				isAdmin = true;
			}
		}
		
		renderRequest.setAttribute("isAdmin", isAdmin);
		renderRequest.setAttribute("curUserRoles", userRoles);
		
		if(Validator.isNotNull(formDefinitionId) && Validator.isNotNull(recordId) && Validator.isNull(formMode)) {
			formMode = FormBuilderConstants.VIEW;
		}
		log.info("Selected Mode : " + formMode + ", Selected Form Name : " + formName + ", Version : " + formVersion + ", Workflow Definition: " +workflowDefinition);
		FormDefinition formDefinition = null;
		String previewFormMode = ParamUtil.getString(renderRequest, FormBuilderConstants.PREVIEW_FORM_MODE);
		if(Validator.isNotNull(previewFormMode) && (previewFormMode.equalsIgnoreCase(FormBuilderConstants.PREVIEW) || previewFormMode.equalsIgnoreCase(FormBuilderConstants.BACK_PREVIEW))) {
		    try {
				String ddmFormDfinition = StringPool.BLANK;
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				JSONArray jsonFieldsArray = JSONFactoryUtil.createJSONArray();
		    	if(previewFormMode.equalsIgnoreCase(FormBuilderConstants.PREVIEW)) {
		    		formDefinitionId = ParamUtil.getString(renderRequest, "selectedFormDefinitionId");
		    		if(Validator.isNotNull(formDefinitionId) || formDefinitionId.equals("0")) {
		    			formDefinition = FormDefinitionLocalServiceUtil.getFormDefinition(Long.valueOf(formDefinitionId));
				    	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest);
						prefs.setValue(FormBuilderConstants.FORM_DEFINITION_ID, String.valueOf(formDefinition.getFormDefinitionId()));
						prefs.setValue(FormBuilderConstants.FORM_NAME, formDefinition.getFormName());
						prefs.setValue(FormBuilderConstants.FORM_VERSION, formDefinition.getFormVersion());
						prefs.setValue(FormBuilderConstants.FORM_MODE, FormBuilderConstants.CONFIG);
						prefs.store();
						
						if (Validator.isNotNull(formDefinition)) {
							ddmFormDfinition = formDefinition.getFormConfig();
							jsonObject = FormRendererUtil.getFormConfigJSONObject(ddmFormDfinition);
							jsonFieldsArray = FormRendererUtil.getFormFieldsJSONArray(jsonObject);
						}
						
						log.info("formDefinitionId : " + formDefinitionId);
						log.info("formName : " + formDefinition.getFormName());
					    log.info("formVersion : " + formDefinition.getFormVersion());
						renderRequest.setAttribute("formDefinitionId", formDefinitionId);
						renderRequest.setAttribute(FormBuilderConstants.WORKFLOW_DEFINITION, workflowDefinitionArr);
						renderRequest.setAttribute(FormBuilderConstants.SECRET_PHRASE, FormBuilderConstants.SECRET_PASS_PHRASE);
						renderRequest.setAttribute(FormBuilderConstants.DDM_FORM_DEFINITION, jsonObject);
						renderRequest.setAttribute(FormBuilderConstants.JSON_FIELDS_ARRAY, jsonFieldsArray);
						renderRequest.setAttribute("redirectUrl", PortalUtil.getCurrentURL(renderRequest));
						return "/html/display/previewForm.jsp"; 
		    		}
		    	} 
			} catch (IOException | PortalException e) {
				log.error("error while storing preferences");
			}
		} 
		
		if(formMode.equalsIgnoreCase(FormBuilderConstants.CONFIG)) {		
			JSONObject formObj = _formConfigurationUtil.getFormLists(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
			if(Validator.isNotNull(formObj)) {
				renderRequest.setAttribute(FormBuilderConstants.FORMS_DATA_JSON, formObj);
			}
			List<RangeOptionMaster> rangeOptionsMasters = rangeOptionMasterLocalService.getRangeOptionMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<String> rangeOptionNames = new ArrayList<>();
			if(Validator.isNotNull(rangeOptionsMasters) && rangeOptionsMasters.size() > 0)
			for(RangeOptionMaster rangeOptionMaster : rangeOptionsMasters){
				String rangeOptionName = rangeOptionMaster.getRangeOptionName();
				rangeOptionNames.add(rangeOptionName);
			}
			if(Validator.isNotNull(rangeOptionNames) && rangeOptionNames.size() > 0) {
				renderRequest.setAttribute(FormBuilderConstants.RANGE_OPTION_NAMES, rangeOptionNames);
			}
			renderRequest.setAttribute(FormBuilderConstants.SECRET_PHRASE, FormBuilderConstants.SECRET_PASS_PHRASE);
			renderRequest.setAttribute("redirectUrl", PortalUtil.getCurrentURL(renderRequest));
			return FormBuilderConstants.FORM_ACTIONS_JSP;
		} else if(formMode.equalsIgnoreCase(FormBuilderConstants.VIEW)) {
		    FormRecordEntry formRecordEntry = null;
			long formRecordEntryId = 0l;
			log.info("formDefinitionId : " + formDefinitionId);
			log.info("recordId : " + recordId);
		
			if(Validator.isNotNull(formDefinitionId) && Validator.isNotNull(recordId)) {
				
				try {
					formDefinition = FormDefinitionLocalServiceUtil.getFormDefinition(Long.valueOf(formDefinitionId));
					long parsedFormDefinitionId = Long.parseLong(formDefinitionId);
					long parsedRecordId = Long.parseLong(recordId);
					formRecordEntry = formRecordEntryLocalService.findFormRecordEntryByFormDefinitionIdAndRecordId(parsedFormDefinitionId, parsedRecordId);
					formRecordEntryId = formRecordEntry.getFormRecordEntryId();
					
				} catch (NumberFormatException | PortalException e) {
					log.error("Error while fetching form definition");
				}
				
				log.info("formDefinitionId : " + formDefinitionId);
				log.info("recordId : " + recordId);
				log.info("formRecordEntryId : " + formRecordEntryId);
				if(Validator.isNotNull(formDefinition)) {
					log.info("in setting portlet preferences");
					preferences.setValue(FormBuilderConstants.FORM_DEFINITION_ID, String.valueOf(formDefinition.getFormDefinitionId()));
                    preferences.setValue(FormBuilderConstants.FORM_NAME, formDefinition.getFormName());
                    preferences.setValue(FormBuilderConstants.FORM_VERSION, formDefinition.getFormVersion());
                    preferences.setValue(FormBuilderConstants.FORM_MODE, FormBuilderConstants.VIEW);
					
					JSONObject configJson = JSONFactoryUtil.createJSONObject();
					JSONArray jsonFieldsArray = JSONFactoryUtil.createJSONArray();
					String ddmFormDfinition = formDefinition.getFormConfig();
					
					configJson = FormRendererUtil.getFormConfigJSONObject(ddmFormDfinition);
					jsonFieldsArray = FormRendererUtil.getFormFieldsJSONArray(configJson);
					String mainTableName = FormDataUtil.formatFormName(configJson.getString("name"));
					if(FormConfigurationUtil.isTableExists(mainTableName)) {
						String columnNames = StringPool.BLANK;
						if(jsonFieldsArray.length()>0) {
							columnNames = columnNames + "id";
                            ArrayList<String> fileKeyList = new ArrayList<>();
							for(int i=0; i<jsonFieldsArray.length(); i++) {
								JSONObject field = (JSONObject) jsonFieldsArray.get(i);
								String key = field.getString(KEY);
                                String fieldType = field.getJSONObject(SETTINGS).getString(FormBuilderConstants.TYPE);
                                if(fieldType.equalsIgnoreCase("file")) {
                                    fileKeyList.add(key);
                                }
								if(isColumnNameExists(mainTableName, key)) {
									columnNames = columnNames + StringPool.COMMA + key; 
								}
							}
							String whereCondition = "where id="+Long.valueOf(recordId);
							JSONArray resultData = FormDefinitionLocalServiceUtil.getDataSelectQuery(mainTableName, columnNames, whereCondition);
							log.info("resultData :: "+resultData);
							
							JSONArray formattedDataJSON = JSONFactoryUtil.createJSONArray();
							for(int i = 0; i< resultData.length(); i++) {
								JSONObject singleJSONDataObj = resultData.getJSONObject(i);
								Iterator<String> keys = singleJSONDataObj.keys();
								while(keys.hasNext()) {
								    String key = keys.next();
								    if(singleJSONDataObj.getString(key).contains("xml")) {
									    JSONArray jsonArray = parseXML(singleJSONDataObj.getString(key), StringPool.BLANK, true);
								    	singleJSONDataObj.put(key, jsonArray);
								    } else {
								    	singleJSONDataObj.put(key, singleJSONDataObj.getString(key));
								    }
								}
								formattedDataJSON.put(singleJSONDataObj);
							}
							
							if(resultData.length()>0) {
                                JSONObject fileJson = JSONFactoryUtil.createJSONObject();
                                String fileEntryId = StringPool.BLANK;
                                JSONObject keyJson = null;
                                JSONObject keyObject = null;
                                if(fileKeyList.size() > 0) {
                                    for(int i = 0;i < resultData.length(); i++) {
                                        JSONObject json = resultData.getJSONObject(0);
                                        for (String fieldKey : fileKeyList) {
                                            keyObject = JSONFactoryUtil.createJSONObject();
                                            String fileEntryIds = json.getString(fieldKey);
                                            if(!fileEntryIds.equals("{}")){
                                                String[] entryId = fileEntryIds.split(",");
                                                for (int j = 0; j < entryId.length; j++) {
                                                    keyJson = JSONFactoryUtil.createJSONObject();
                                                    fileEntryId = entryId[j];
                                                    try {
                                                        if(Validator.isNotNull(fileEntryId)) {
                                                        	DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileEntryId));
                                                            String fileName = dlFileEntry.getFileName();
                                                            FileEntry fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
                                                            String dlURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, null, true, true);
                                                            keyJson.put("fileName", fileName);
                                                            keyJson.put("url", dlURL);
                                                            keyObject.put(fileEntryId, keyJson);
                                                        }
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                                fileJson.put(fieldKey,keyObject);
                                            }
                                        }
                                        
                                    }
                                }
                                
								JSONObject resultJson = resultData.getJSONObject(0);
								log.info("resultJson :: "+resultJson);
								renderRequest.setAttribute("editDataJson", resultJson);
								renderRequest.setAttribute("formDefinitionId", formDefinitionId);
								renderRequest.setAttribute("recordId", recordId);
								renderRequest.setAttribute(FormBuilderConstants.FORM_RECORD_ENTRY_MODE, formRecordEntrymode);
                                renderRequest.setAttribute("fileJson", fileJson);
							}
						}
					}
				}
			} else {
				formDefinition = FormRendererUtil.getFormDefinitionByFormNameAndFormVersion(formName,
						formVersion);
			}
			
			String ddmFormDfinitionString = StringPool.BLANK;
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray jsonFieldsArray = JSONFactoryUtil.createJSONArray();

			if (Validator.isNotNull(formDefinition)) {
				ddmFormDfinitionString = formDefinition.getFormConfig();
				jsonObject = FormRendererUtil.getFormConfigJSONObject(ddmFormDfinitionString);
				if(Validator.isNotNull(jsonObject) && jsonObject.has(POPULATE_DATA)) {
					Map<String,Object> populateDataHeadersMap = new HashMap<>();
					Map<String,Object> populateDataParamsMap = new HashMap<>();
					ObjectMapper headersObjectMapper = new ObjectMapper();
					ObjectMapper paramsObjectMapper = new ObjectMapper();
					JSONObject populateDataObj = jsonObject.getJSONObject(POPULATE_DATA);
					Boolean isEnabledPopulateData = populateDataObj.getBoolean(ENABLED);
					JSONObject populateDataSettings = populateDataObj.getJSONObject(SETTINGS);
					if(Validator.isNotNull(populateDataSettings) && isEnabledPopulateData) {
						JSONObject populateDataHeadersObj = null;
						JSONObject populateDataParamsObj = null;
						String populateDataUrl = populateDataSettings.getString(URL);
						String populateDataContentType = populateDataSettings.getString(CONTENT_TYPE);
						populateDataHeadersMap.put(HttpHeaders.CONTENT_TYPE, populateDataContentType);
						String postDataAccept = populateDataSettings.getString(ACCEPT);
						populateDataHeadersMap.put(HttpHeaders.ACCEPT, postDataAccept);
						JSONArray populateDataHeaders = populateDataSettings.getJSONArray(HEADERS);
						for (int i = 0; i < populateDataHeaders.length(); i++) {
							populateDataHeadersObj = populateDataHeaders.getJSONObject(i);
							try {
								populateDataHeadersMap.putAll(headersObjectMapper.readValue(populateDataHeadersObj.toString(), new TypeReference<Map<String, Object>>() {}));
							}catch (JsonProcessingException e) {
								log.error("Error occured while converting json to map: "+e.getMessage());
							}
						}
						JSONArray populateDataParams = populateDataSettings.getJSONArray(PARAMS);
						JSONObject requestBodyObj = JSONFactoryUtil.createJSONObject();
						for (int i = 0; i < populateDataParams.length(); i++) {
							populateDataParamsObj = populateDataParams.getJSONObject(i);
							if(populateDataContentType.equals(ContentTypes.APPLICATION_JSON)) {
								Iterator<String> it = populateDataParamsObj.keys();
							    while(it.hasNext()) {
							      String key = it.next();
							      Object value = populateDataParamsObj.get(key);
							      String tempValue = String.valueOf(value);
							      if(tempValue.contains(StringPool.OPEN_BRACKET)) {
							    	  tempValue = tempValue.replace(StringPool.OPEN_BRACKET, StringPool.BLANK).replace(StringPool.CLOSE_BRACKET, StringPool.BLANK);
							    	  value = tempValue.split(StringPool.COMMA);
							      }
							      log.info("populateDataParamsObj: "+populateDataParamsObj.get(key));
							      requestBodyObj.put(key, value);
							      log.info("requestBodyObj: "+requestBodyObj);
							    }
							}else if(populateDataContentType.equals(ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED)) {
								try {
									populateDataParamsMap.putAll(paramsObjectMapper.readValue(populateDataParamsObj.toJSONString(), new TypeReference<Map<String, Object>>() {}));
								}catch (JsonProcessingException e ) {
									log.error("Error occured while converting json to map: "+e.getMessage());
								}
							}
						}
						
						if(Validator.isNotNull(populateDataUrl)) {
							try {
								String prepopulateJsonData = WebServiceUtil.post(populateDataUrl, requestBodyObj.toJSONString(), populateDataHeadersMap, populateDataParamsMap);
								String encoded = new String(Base64.getEncoder().encode(prepopulateJsonData.getBytes()));
								renderRequest.setAttribute("prepopulateJsonData", encoded);
							} catch (Exception e) {
								log.error("Error occured while converting string to json: "+e.getMessage());
							}

						}
					}
				}
				jsonFieldsArray = FormRendererUtil.getFormFieldsJSONArray(jsonObject);
			}
			
			List<EmailTemplateMaster> emailTemplateMasters = EmailTemplateMasterLocalServiceUtil.getEmailTemplateMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(Validator.isNotNull(emailTemplateMasters)) {
				renderRequest.setAttribute(FormBuilderConstants.EMAIL_TEMPLATE_MASTERS, emailTemplateMasters);
			}
			
			renderRequest.setAttribute(FormBuilderConstants.FORM_RECORD_ENTRY_ID, formRecordEntryId);
			renderRequest.setAttribute(FormBuilderConstants.WORKFLOW_DEFINITION, workflowDefinition);
			renderRequest.setAttribute(FormBuilderConstants.WORKFLOW_DEFINITIONS, workflowDefinitionArr);
			renderRequest.setAttribute(FormBuilderConstants.SECRET_PHRASE, FormBuilderConstants.SECRET_PASS_PHRASE);
			renderRequest.setAttribute(FormBuilderConstants.DDM_FORM_DEFINITION, jsonObject);
			renderRequest.setAttribute(FormBuilderConstants.JSON_FIELDS_ARRAY, jsonFieldsArray);
			renderRequest.setAttribute("redirectUrl", PortalUtil.getCurrentURL(renderRequest));
			return FormBuilderConstants.VIEW_DISPLAY_JSP;
		}
		renderRequest.setAttribute("redirectUrl", PortalUtil.getCurrentURL(renderRequest));
		return FormBuilderConstants.MODE_SELECTION_JSP;

	}
	
	private boolean isColumnNameExists(String tableName, String key) {
		List<String> columnNames = FormDefinitionLocalServiceUtil.getColumnNames("'"+tableName+"'");
		return (Validator.isNotNull(columnNames) && !columnNames.isEmpty() && columnNames.contains(key.toLowerCase()));
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
			if(languageId.equals("en_US")) {
				singleLocaleJSONObject.put("en_US", content);
				singleLocaleJSONObject.put("ar_SA", StringPool.BLANK);
			} else if(languageId.equals("ar_SA")) {
				singleLocaleJSONObject.put("en_US", StringPool.BLANK);
				singleLocaleJSONObject.put("ar_SA", content);
			}
		}
		
		jsonArray.put(singleLocaleJSONObject);
        
        return jsonArray;
    }

	@Reference
	private FormConfigurationUtil _formConfigurationUtil;

	@Reference
	private FormRecordEntryLocalService formRecordEntryLocalService;
	
	@Reference
	private RangeOptionMasterLocalService rangeOptionMasterLocalService;
}
