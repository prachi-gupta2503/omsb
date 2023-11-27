<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="gov.omsb.form.builder.constants.MVCCommandNames"%>
<%@ include file="../init.jsp" %>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String currentURL = PortalUtil.getCurrentURL(renderRequest);
%>

<%
	boolean isFormSelection = false, isRequiredPageReload = false;
List<FormDefinition> formDefinitions = FormDefinitionLocalServiceUtil.getFormDefinitions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

if(Validator.isNotNull(renderRequest.getAttribute(FormBuilderConstants.IS_REQUIRED_PAGE_RELOAD))) {
	isRequiredPageReload = (boolean) renderRequest.getAttribute(FormBuilderConstants.IS_REQUIRED_PAGE_RELOAD);
}

if(formName.isEmpty() && formVersion.isEmpty()) {
	isFormSelection = true;	
}

HttpServletRequest origrequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

JSONObject readFromReqParamObj = JSONFactoryUtil.createJSONObject();
for (Map.Entry<String,String[]> entry : origrequest.getParameterMap().entrySet()) {
	String key = entry.getKey();
	if(!entry.getKey().contains(renderResponse.getNamespace())){
		key = renderResponse.getNamespace() + entry.getKey();
	} 
	readFromReqParamObj.put(key, entry.getValue());
}
renderRequest.setAttribute("readFromReqParam", readFromReqParamObj.toJSONString());
%>

<portlet:resourceURL id="<%=MVCCommandNames.GET_FORM_DATA%>" var="getFormDataResourceURL" />
<portlet:resourceURL id="/get/master-data" var="getMasterDataResourceURL" />

<portlet:renderURL var="addConfigurationURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.FORM_CONFIGURATION_ADD %>"/>
		<portlet:param name="selectedFormDefinitionId" value="SELECTED_FORM_DEFINITION_ID"/>
</portlet:renderURL>

<portlet:renderURL var="backPreviewURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="previewFormMode" value="backPreview" />
	<portlet:param name="selectedFormDefinitionId" value="SELECTED_FORM_DEFINITION_ID"/>
</portlet:renderURL>

<portlet:resourceURL id="<%= MVCCommandNames.GET_FORM_VERSIONS %>" var="fetchFormVersionsUrl"></portlet:resourceURL>
<portlet:actionURL name="<%= MVCCommandNames.SAVE_SELECTED_FORM_ACTION %>" var="addFormSelectionUrl"></portlet:actionURL>
<portlet:actionURL name="<%= MVCCommandNames.SWITCH_FORM_ACTION %>" var="resetFormSelectionUrl"></portlet:actionURL>

	<%-- <button type="button" class="btn btn-primary float-right" id="<portlet:namespace />backPreviewURLBtn">
		<liferay-ui:message key="back-url-btn" />
	</button> --%>
	
	<h2 style="text-align: center;" id="<portlet:namespace />formTitle"></h2>

	<div class="mt-4 px-3 font-weight-bold font-italic" id="<portlet:namespace />formDescription"></div>

	<portlet:actionURL name="<%=MVCCommandNames.SAVE_FORM_FIELD%>" var="saveFormField">
	</portlet:actionURL>
	
	<portlet:actionURL var="saveFormDataActionURL"  name="/save/form-data" />
	
	<portlet:resourceURL id="/omsb/dropzone/createTempFile" var="uploadTempFileURL"></portlet:resourceURL>

	<form name="<portlet:namespace />dfrenderForm" id="<portlet:namespace />dfrenderForm" method="post" enctype="multipart/form-data" action="${saveFormDataActionURL}">
		<div class="container" id="<portlet:namespace />dfFormRender"></div>
		<input type="hidden" id="<portlet:namespace />redirectURL" name="<portlet:namespace />redirectURL" value="<%=currentURL%>" ></input>
		<input type="hidden" id="<portlet:namespace />attachmentId" name="<portlet:namespace />attachmentId" value="" ></input>
		<input type="hidden" id="<portlet:namespace />readFromReqParam" name="<portlet:namespace />readFromReqParam" value='${readFromReqParam}' ></input>
		<input type="hidden" id="<portlet:namespace />htmlData" name="<portlet:namespace />htmlData" value="" ></input>
		<input type="hidden" id="<portlet:namespace />formDefinitionId" name="<portlet:namespace />formDefinitionId" value="${formDefinitionId}" ></input>
		<input type="hidden" id="<portlet:namespace />recordId" name="<portlet:namespace />recordId" value="${recordId}" ></input>
		<%-- <button type="button" class="btn btn-primary" id="<portlet:namespace />formFieldSaveBtn"><liferay-ui:message key="save" /></button> --%>
	</form>
	
<script>

$(document).ready(function() {
	var isRequiredPageReload =  '<%=isRequiredPageReload %>';
	if(isRequiredPageReload) {
		//location.reload();
	}

	var selectedConfiguredFormName = '<%=formName%>';

	var renderDDf = new Object({}),
		namespace = '<portlet:namespace />',
		contextPath = '<%= request.getContextPath()%>',
		themeImagesPath = '<%= themeDisplay.getPathThemeImages()%>',
		languageId = Liferay.ThemeDisplay.getLanguageId(),
		jsonFieldsArray = '${jsonFieldsArray}',
		formName = '${ddmFormDefinition.getString("name")}',
		isMasterForm = '${ddmFormDefinition.getBoolean("isMasterForm")}' == 'true' ? true : false,
		formLayoutColomn = '${ddmFormDefinition.getString("layout")}',
		encryptedFormDescription = '${ddmFormDefinition.get("description")}',
		formTitle = '${ddmFormDefinition.get("title")}',
		groups = '${ddmFormDefinition.get("groups")}',
		attachmentId = '#' + namespace + 'attachmentId',
		htmlData = '#' + namespace + 'htmlData',
		readFromReqParam = '#' + namespace + 'readFromReqParam',
		dfrenderFormJEL = '#' + namespace + 'dfrenderForm',
		formContainerJEL = '#' + namespace + 'dfFormRender',
		formDescriptionJEL = '#' + namespace + 'formDescription',
		groupRowAccordianJEl = '#' + namespace + 'groupRowAccordian',
		formTitleJEl = '#' + namespace + 'formTitle',
		secretPassphrase = '${secretPassphrase}',
		prepopulateJsonData = '${prepopulateJsonData}',
		//backPreviewURLBtnJEl = '#' + namespace + 'backPreviewURLBtn',
		backPreviewURL = '${backPreviewURL}';

	renderDDf.formName = formName;
	renderDDf.isMasterForm = isMasterForm;
	renderDDf.namespace = namespace;
	renderDDf.contextPath = contextPath;
	renderDDf.themeImagesPath = themeImagesPath;
	renderDDf.formLayoutColomn = formLayoutColomn;
	renderDDf.jsonFieldsArray = jsonFieldsArray;
	renderDDf.formContainerJEL = formContainerJEL;	
	renderDDf.attachmentId = attachmentId;
	renderDDf.htmlData = htmlData;
	renderDDf.formDescriptionJEL = formDescriptionJEL;
	renderDDf.groupRowAccordianJEl = groupRowAccordianJEl;
	renderDDf.formTitleJEl = formTitleJEl;
	renderDDf.secretPassphrase = secretPassphrase;
	renderDDf.languageId = languageId;
	renderDDf.encryptedFormDescription = encryptedFormDescription;
	renderDDf.formTitle = formTitle;
	renderDDf.groups = groups;
	renderDDf.readFromReqParam = readFromReqParam;
	renderDDf.dropzoneActionURL = '${uploadTempFileURL}';
	renderDDf.getFormDataResourceURL = '${getFormDataResourceURL}';
	renderDDf.selectedFormDefinitionId = '<%=formDefinitionId%>';
	renderDDf.editDataJson = '${editDataJson}';
	renderDDf.prepopulateJsonData = prepopulateJsonData; 
	//renderDDf.backPreviewURLBtnJEl = backPreviewURLBtnJEl;
	renderDDf.backPreviewURL = backPreviewURL;
	dfrPortlet.renderDDf(renderDDf);
		
	
	var renderFormDDf = new Object({}),
	formFieldSaveBtn = '#' + namespace + 'formFieldSaveBtn',
	firstNameValidator = namespace + 'firstName',
	createNewConfigBtnJEL = '#createNewConfigBtn',
	editConfigBtnJEL = '#addEditConfigBtn',
	formVersionsDivJEL = '#form_versions_section',
	formVersionJEL = '#' + namespace + 'form_versions',
	formNamesJEL = '#' + namespace + 'form_names',
	isMasterForm = '${ddmFormDefinition.getBoolean("isMasterForm")}' == 'true' ? true : false,
	jsonFieldsArray = '${jsonFieldsArray}',
	kaleoDefinitionsSectionJEL = "#kaleo_definitions_section",
	kaleoDefinitionsJEL = "#" + namespace + "kaleoDefinitions",
	workflowDefinitionArr = encodeURI('${workflowDefinition}');
	formNamesJEL = '#' + namespace + 'form_names';
	
	renderFormDDf.namespace = namespace;
	renderFormDDf.contextPath = contextPath;
	renderFormDDf.themeImagesPath = themeImagesPath;
	renderFormDDf.isMasterForm = isMasterForm;
	renderFormDDf.firstNameValidator = firstNameValidator;
	renderFormDDf.formFieldSaveBtn = formFieldSaveBtn;
	renderFormDDf.jsonFieldsArray = jsonFieldsArray;
	renderFormDDf.dfrenderFormJEL= dfrenderFormJEL;
	renderFormDDf.createNewConfigBtnJEL = createNewConfigBtnJEL;
	renderFormDDf.editConfigBtnJEL = editConfigBtnJEL;
	renderFormDDf.formVersionsDivJEL = formVersionsDivJEL;
	renderFormDDf.formVersionJEL = formVersionJEL;
	renderFormDDf.formNamesJEL = formNamesJEL;
	renderFormDDf.languageId = languageId;
	renderFormDDf.addConfigurationRenderURL = '${addConfigurationURL}';
	renderFormDDf.fetchFormVersionsResourceURL = '${fetchFormVersionsUrl}';
	renderFormDDf.selectedFormDefinitionId = '${formDefinitionId}';
	renderFormDDf.secretPassphrase = secretPassphrase;
	renderFormDDf.kaleoDefinitionsSectionJEL = kaleoDefinitionsSectionJEL;
	renderFormDDf.kaleoDefinitionsJEL = kaleoDefinitionsJEL;
	renderFormDDf.workflowDefinitionArr = workflowDefinitionArr;
	//renderFormDDf.contextPath = contextPath;
	dfrPortlet.formRenderDDf(renderFormDDf);
	
	
	
});

</script>