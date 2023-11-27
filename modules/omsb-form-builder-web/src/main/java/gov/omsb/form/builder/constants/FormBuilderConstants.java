package gov.omsb.form.builder.constants;

import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;

public class FormBuilderConstants {
	
	private FormBuilderConstants() {
		
	}
	

	public static final String ATTACHMENT = "attachment[";
	
	public static final String ADD_FORM_CONFIGURATION_JSP = "/html/configuration/add.jsp";
	
	public static final String FORM_ACTIONS_JSP = "/html/configuration/formActions.jsp";
	
	public static final String VIEW_DISPLAY_JSP = "/html/display/view.jsp";
	
	public static final String EMAIL_TEMPLATE_MASTERS = "emailTemplateMasters";
	
    public static final String LANGUAGE_ID = "languageId";
    
    public static final String LANGUAGE_ID_COLUMN = "languageid";
	
	public static final String MODE_SELECTION_JSP = "/html/display/modeSelection.jsp";
	
	public static final String FORM_MODE = "formMode";
	
	public static final String PREVIEW_FORM_MODE = "previewFormMode";
	
	public static final String PREVIEW = "preview";
	
	public static final String BACK_PREVIEW = "backPreview";
	
	public static final String FORM_NAME = "formName";
	
	public static final String FORM_TITLE = "formTitle";
	
	public static final String FORM_LAYOUT = "formLayout";
	
	public static final String FORM_DESCRIPTION = "formDescription";
	
	public static final String FORM_VERSION = "formVersion";
	
	public static final String STATUS="status";
	
	public static final String MESSAGE="message";

	public static final String SECRET_PHRASE_KEY = "SecretPassphrase";
	
	public static final String SECRET_PHRASE = "secretPassphrase";
	
	public static final String ENCRYPTED_FORM_DATA = "encryptedFormData";
	
	public static final String ALGORITHM = "AES/CBC/PKCS5Padding";
	
	public static final String SECRET_PASS_PHRASE = "BVIDXPEncryptKey";
	
	public static final String DATA = "data";
	
	public static final String RECORDS ="Records";
	
	public static final String TOTAL_RECORDS ="TotalRecords";
	
	public static final String RECORDS_TOTAL ="recordsTotal";
	
	public static final String RECORDS_FILTERED ="recordsFiltered";
	
	public static final String SUCCESS = "success";
	
	public static final String ERROR = "error";
	
	public static final String START = "start";

	public static final String LENGTH = "length";

	public static final String DRAW = "draw";

	public static final String ORDER_COLUMN = "order[0][column]";

	public static final String ORDER_DIR = "order[0][dir]";
	
	public static final String LONG = "long";
	
	public static final String DATE_TIME = "datetime";
	
	public static final String ENGLISH_LANGUAGE_CODE = "en_US";
	
	public static final String ARABIC_LANGUGAE_CODE = "ar_SA";
	
	public static final String IS_REQUIRED_PAGE_RELOAD = "isRequiredPageReload";
	
	public static final String FORMS_DATA_JSON = "formsDataJson";
	
	public static final String JSP_PAGE = "jspPage";
	
	public static final String CMD = "cmd";
	
	public static final String TABLE_NAME = "tableName";
	
	public static final String TEXT_COLUMN = "textColumn";
	
	public static final String VALUE_COLUMN = "valueColumn";
	
	public static final String MVC_PATH = "mvcPath";
	
	public static final String DDM_FORM_DEFINITION = "ddmFormDefinition";
	
	public static final String JSON_FIELDS_ARRAY = "jsonFieldsArray";
	
	public static final String COMPANYID = "companyid";

	public static final String GROUPID = "groupid";

	public static final String MODIFIEDDATE = "modifieddate";

	public static final String MODIFIEDBY = "modifiedby";

	public static final String CREATEDDATE = "createddate";

	public static final String CREATEDBY = "createdby";

	public static final String FORM_DEFINITION_ID = "formDefinitionId";

	public static final String FORMAT = "format";

	public static final String DATE_CONFIG = "dateConfig";

	public static final String NAME = "name";
	
	public static final String HTML = "html";
	
	public static final String TEXT_AREA = "textarea";

	public static final String TEMP_ATTACHMENTS = "tempAttachments";

	public static final String H_ = "h";

	public static final String H = "H";

	public static final String Y_ = "y";

	public static final String Y = "Y";

	public static final String D_ = "d";

	public static final String D = "D";

	public static final String DATETIME = "datetime";

	public static final String INTEGER = "integer";

	public static final String NUMBER = "number";

	public static final String ATTACHMENT_ID = "attachmentId";

	public static final String FILE = "file";

	public static final String LONGTEXT = "longtext";

	public static final String STRING = "string";

	public static final String MULTIPLE = "multiple";

	public static final String TYPE = "type";

	public static final String DATA_TYPE = "dataType";

	public static final String SETTINGS = "settings";

	public static final String KEY = "key";
	
	public static final String LABEL = "label";
	
	public static final String VALUE = "value";

	public static final String FIELDS = "fields";
	
	public static final String DISABLED = "disabled";
	
	public static final String REQUIRED = "required";
	
	public static final String READONLY = "readonly";
	
	public static final String TITLE = "title";
	
	public static final String DROP_DOWN = "dropdown";
	
	public static final String RANGE = "range";
	
	public static final String CUSTOM_RANGE = "customRange";
	
	public static final String DATE = "date";
	
	public static final String TIME = "time";
	
	public static final String RADIO = "radio";
	
	public static final String CHECKBOX = "checkbox";
	
	public static final String MULTI_SELECT = "multiselect";
	
	public static final String RANGE_CONFIG = "rangeConfig";
	
	public static final String OPTIONS = "options";
	
	public static final String OPTIONS_NAME = "name";
	
	public static final String OPTIONS_VALUE = "value";
	
	public static final String MASTER = "master";
	
	public static final String POPULATE_MASTER_DROPDOWN = "populateMasterDropdown";
	
	public static final String IS_MASTER_FORM = "isMasterForm";
	
	public static final String TEXT_COLUMNS = "textColumns";
	
	public static final String VALUE_COLUMNS = "valueColumns";
	
	public static final String MASTER_TABLE_DROPDOWN_ARR = "masterTableDropdownArr";
	
	public static final String FETCH_EDIT_COLUMN_NAMES = "fetchEditColumnNames";
	
	public static final String CREATE_NEW_MAPPING_TABLE = "createNewMappingTable";
	
	public static final String CREATE_FORM_MAPPINGS_TABLE = "createFormMappingsTable";
	
	public static final String MAPPING = "mapping";
	
	public static final String MAPPINGS = "mappings";
	
	public static final String VALUE_ID = "valueId";
	
	public static final String MASTER_TABLE_NAME = "masterTable";
	
	public static final String DESCRIPTION = "description";
	
	public static final String LAYOUT = "layout";
	
	public static final String FORM_DEFINITION_ID_COLUMN = "formdefinitionid";
	
	public static final String RECORD_ID_COLUMN = "recordid";
	
	public static final String VALUE_ID_COLUMN = "valueid";
	
	public static final String FORM_VERSION_COLUMN = "formversion";
	
	public static final String HTML_DATA = "htmlData";
	
	public static final String SR_NO = "srNo";
	
	public static final String ACTIVE = "active";
	
	public static final String INACTIVE = "inactive";
	
	public static final String YES = "yes";
	
	public static final String NO = "no";
	
	public static final String FIELD_LABEL = "fieldLabel";
	
	public static final String FIELD_KEY = "fieldKey";
	
	public static final String FIELD_TYPE = "fieldType";
	
	public static final String FIELD_DATA_TYPE = "fieldDataType";
	
	public static final String FIELD_STATUS = "fieldStatus";
	
	public static final String FIELD_DISABLED = "fieldDisabled";
	
	public static final String FIELD_REQUIRED = "fieldRequired";
	
	public static final String FIELD_READONLY = "fieldReadonly";
	
	public static final String FIELD_JSON_OBJ = "fieldJSONObj";

	public static final String FORM_CONFIG = "formConfig";
	
	public static final String FORM_NAMES = "formNames";
	
	public static final String TABLE_NAMES = "tableNames";
	
	public static final String COLUMN_NAMES = "columnNames";
	
	public static final String ACTION_TYPE = "actionType";
	
	public static final String CONFIG = "config";
	
	public static final String VIEW = "view";
	
	public static final String POST_DATA = "postData";
	
	public static final String FIELD_NAME = "fieldName";
	
	public static final String ENABLED = "enabled";
	
	public static final String URL = "url";
	
	public static final String CONTENT_TYPE = "contentType";
	
	public static final String ACCEPT = "accept";
	
	public static final String HEADERS = "headers";
	
	public static final String PARAMS = "params";
	
	public static final String POPULATE_DATA = "populateData";
	
	public static final String REDIRECT_URL = "redirectURL";
	
	public static final String KALEO_DEFINITION = "kaleoDefinition";
	
	public static final String WORKFLOW_DEFINITIONS = "workflowDefinitions";
	
	public static final String WORKFLOW_DEFINITION = "workflowDefinition";
	
	public static final String EMAIL_TEMPLATE = "emailTemplate";
	
	public static final String SELECTED_EMAIL_TEMPLATE_ID = "selectedEmailTemplateId";
	
	public static final String FORM_DEFINITION_URL = "/-/formDefinitionId/";
	
	public static final String WORKFLOW_STATUS = "formDefinitionWorkflowStatus";
	
	public static final String FORM_RECORD_ENTRY_ID = "formRecordEntryId";
	
	public static final String RECORD_ID = "recordId";
	
	public static final String FORM_RECORD_ENTRY_URL = "formRecordEntryURL";
	
	public static final String PORTAL_URL = "portalURL";
	
	public static final String FORM_RECORD_ENTRY_MODE = "formRecordEntryMode";
	
	public static final String VERSION = "version";
	
	public static final String DF = "df";
	
	public static final String IS_PAGE_RELOAD = "isPageReload";
	
	public static final String RANGE_OPTION_NAME = "rangeOptionName";
	
	public static final String RANGE_OPTION_ID = "rangeOptionId";
	
	public static final String RANGE_OPTIONS = "rangeOptions";
	
	public static final String ENCRYPTED_RANGE_OPTIONS_DATA = "encryptedRangeOptionsData";
	
	public static final String RANGE_OPTION_DATA_ARR = "rangeOptionData";
	
	public static final String RANGE_OPTION_NAMES = "rangeOptionNames";
	
	public static final int BASIC_SECTION_SAVE = 1;
	
	public static final int FIELDS_SECTION_SAVE = 2;
	
	public static final int REORDER_SECTION_SAVE = 3;
	
	public static final int DELETE_SECTION_SAVE = 4;
	
	public static final int SUBMIT_FORM = 5;
	
	public static final String XML_DATA_TEMPLATE = "<?xml version=\"1.0\"?>\r\n" + 
    		"\r\n" + 
    		"<root available-locales=\"en_US\" default-locale=\"en_US\">\r\n" + 
    		"	<dynamic-content language-id=\"en_US\">\r\n" + 
    		"		[0]\r\n" + 
    		"	</dynamic-content>	\r\n" + 
    		"	<dynamic-content language-id=\"ar_SA\">\r\n" + 
    		"		[1]\r\n" + 
    		"	</dynamic-content>\r\n" +  
    		"</root>";
	
	public static final String FROM_EMAIL_ADDRESS = Validator.isNotNull(PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER)) 
			? PrefsPropsUtil.getString(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER) : "testportal@omsb.org";
	
	public static final String SAMPLE_EMAIL_TEMPLATE = "<p>Hi, [$first_name$] [$last_name$]</p><p><br></p><p>Please confirm your Data,</p><p><br></p><p>Address : [$address$]</p><p>COmments : [$comments$]</p><p>Age : [$age$]</p><p>Label Testing : [$label_testing$]</p><p>Range Testing : [$range_testing$]</p><p>Gender : [$gender$]</p><p>Hobbies : [$hobbies$]</p><p>Date Of Birth : [$dob$]</p><p>Country : [$country$]</p><p>Master Table Mapping Value : [$master_table_mapping$]</p><p><br></p><p>Thanks.</p>";
	
}
