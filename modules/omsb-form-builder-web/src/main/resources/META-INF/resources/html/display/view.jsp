<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="gov.omsb.form.builder.constants.MVCCommandNames"%>
<%@ include file="../init.jsp" %>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>



<%
	boolean isFormSelection = false, isRequiredPageReload = false;
List<FormDefinition> formDefinitions = FormDefinitionLocalServiceUtil.getLatestFormDefinition(themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId());

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

<c:set var="cssClass" value=""/>

<c:if test="${formRecordEntryMode == 'preview' }">
	<c:set var="cssClass" value="d-none"/>
</c:if>

<c:choose>
  <c:when test="<%=formDefinitions.size() == 0 %>">
  	<h1 class="display-4"><liferay-ui:message key="form-not-available-heading" /></h1>  	
  </c:when>
  <c:when test="<%=isFormSelection %>"> 

    <aui:form action="<%= addFormSelectionUrl.toString() %>" method="post">
    
		<div class="form-heading">
			<p><em><liferay-ui:message key="form-selection-heading" /></em></p>
		</div>
    	
	    <div class="row">
	    	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" id="form_names_section">
	    		<aui:select name="formName" label="form-name" id="form_names" required="true">
			    	<aui:option value=""><liferay-ui:message key="default-select-option" /></aui:option>
				    <c:forEach var="formDefinition" items="<%=formDefinitions%>">
						<aui:option value="${formDefinition.formName}" data-form-definition-id="${formDefinition.formDefinitionId}">${formDefinition.formName}</aui:option>
					</c:forEach>
				</aui:select>
	    	</div>
	    	
	    	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none" id="form_versions_section">
	    		<aui:select name="formVersion" label="form-version" id="form_versions" required="true">
			    	<aui:option value=""><liferay-ui:message key="default-select-option" /></aui:option>	    
				</aui:select>
	    	</div>	
	    	
	    	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none" id="kaleo_definitions_section">
	    		<aui:select name="kaleoDefinition" label="kaleo-workflows" id="kaleoDefinition">
			    	<aui:option value=""><liferay-ui:message key="default-select-option" /></aui:option>	    
				</aui:select>
	    	</div>	  
	    	<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none" id="email_template_section">
                <aui:select name="emailTemplate" label="email-template" id="emailTemplate">
                    <aui:option value=""><liferay-ui:message key="default-select-option" /></aui:option>    
                    <c:forEach var="emailTemplateMaster" items="${emailTemplateMasters}">
						<aui:option value="${emailTemplateMaster.templateId}">${emailTemplateMaster.templateName}</aui:option>
					</c:forEach>    
                </aui:select>
            </div>            	
	    </div>
	    
	    <aui:button-row>
			<aui:button type="submit" value="save" />
		</aui:button-row>
		
    </aui:form>   
  </c:when>
  <c:otherwise>

	<a href="${resetFormSelectionUrl}" class="btn btn-primary float-right ${cssClass}"><liferay-ui:message key="switch-form" /></a>
	
	<h2 style="text-align: center;" id="<portlet:namespace />formTitle"></h2>

	<div class="mt-4 px-3 font-weight-bold font-italic" id="<portlet:namespace />formDescription"></div>

	<portlet:actionURL name="<%=MVCCommandNames.SAVE_FORM_FIELD%>" var="saveFormField">
	</portlet:actionURL>
	
	<portlet:actionURL var="saveFormDataActionURL" name="/save/form-data" />
	
	<portlet:resourceURL id="/omsb/dropzone/createTempFile" var="uploadTempFileURL"></portlet:resourceURL>

	<form name="<portlet:namespace />dfrenderForm" id="<portlet:namespace />dfrenderForm" method="post" enctype="multipart/form-data" action="${saveFormDataActionURL}">
		<div class="container" id="<portlet:namespace />dfFormRender"></div>
		<input type="hidden" id="<portlet:namespace />redirectURL" name="<portlet:namespace />redirectURL" value="${redirectUrl}" ></input>
		<input type="hidden" id="<portlet:namespace />attachmentId" name="<portlet:namespace />attachmentId" value="" ></input>
		<input type="hidden" id="<portlet:namespace />readFromReqParam" name="<portlet:namespace />readFromReqParam" value='${readFromReqParam}' ></input>
		<input type="hidden" id="<portlet:namespace />htmlData" name="<portlet:namespace />htmlData" value="" ></input>
		<input type="hidden" id="<portlet:namespace />formDefinitionId" name="<portlet:namespace />formDefinitionId" value="${formDefinitionId}" ></input>
		<input type="hidden" id="<portlet:namespace />recordId" name="<portlet:namespace />recordId" value="${recordId}" ></input>
		<input type="hidden" id="<portlet:namespace />workflowDefinition" name="<portlet:namespace />workflowDefinition" value="${workflowDefinition}" ></input>
		<input type="hidden" id="<portlet:namespace />formRecordEntryId" name="<portlet:namespace />formRecordEntryId" value="${formRecordEntryId}" ></input>
		<input type="hidden" id="<portlet:namespace />deleteFileEntry" name="<portlet:namespace />deleteFileEntry" value="" ></input>
		<input type="hidden" id="<portlet:namespace />rolesJson" name="<portlet:namespace />rolesJson" value="${rolesJson}" ></input>
		<button type="button" class="btn btn-primary ${cssClass}" id="<portlet:namespace />formFieldSaveBtn"><liferay-ui:message key="save" /></button>
	</form>
		
  </c:otherwise>
</c:choose>

<script>

$(document).ready(function() {
	console.log("Workflow Definitions while rendering: ",'${workflowDefinitions}');
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
		rolesJson = '${rolesJson}',
		curUserRoles = '${curUserRoles}',
		isAdmin = '${isAdmin}',
		prepopulateJsonData = '${prepopulateJsonData}';

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
    renderDDf.fileJson = '${fileJson}';
    renderDDf.rolesJson = rolesJson;
    renderDDf.isAdmin = isAdmin;
    renderDDf.curUserRoles = curUserRoles;
	if(selectedConfiguredFormName !== '') {
		dfrPortlet.renderDDf(renderDDf);
	}	
	
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
	kaleoDefinitionsJEL = "#" + namespace + "kaleoDefinition",
    emailTemplateSectionJEL = "#email_template_section",
    emailTemplateJEL = "#" + namespace + "emailTemplate",
	workflowDefinitionArr = encodeURI('${workflowDefinitions}');
	formNamesJEL = '#' + namespace + 'form_names';
    deleteFileEntryJEl = '#' + namespace + 'deleteFileEntry';
	
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
	renderFormDDf.backPreviewURL = '${backPreviewURL}';
	renderFormDDf.fetchFormVersionsResourceURL = '${fetchFormVersionsUrl}';
	renderFormDDf.selectedFormDefinitionId = '<%=formDefinitionId%>';
	renderFormDDf.secretPassphrase = secretPassphrase;
	renderFormDDf.kaleoDefinitionsSectionJEL = kaleoDefinitionsSectionJEL;
	renderFormDDf.kaleoDefinitionsJEL = kaleoDefinitionsJEL;
    renderFormDDf.emailTemplateSectionJEL = emailTemplateSectionJEL;
    renderFormDDf.emailTemplateJEL = emailTemplateJEL;
	renderFormDDf.workflowDefinitionArr = workflowDefinitionArr;
    renderFormDDf.deleteFileEntryJEl = deleteFileEntryJEl;
    renderFormDDf.curUserRoles = curUserRoles;
	//renderFormDDf.contextPath = contextPath;
	dfrPortlet.formRenderDDf(renderFormDDf);
	
	var editDDf = new Object({}),
	editDataJson = '${editDataJson}';
    fileJson = '${fileJson}';
	
	editDDf.namespace = namespace;
	editDDf.contextPath = contextPath;
	editDDf.themeImagesPath = themeImagesPath;
	editDDf.languageId = languageId;
	editDDf.jsonFieldsArray = jsonFieldsArray;
	editDDf.formName = formName;
	editDDf.isMasterForm = isMasterForm;
	editDDf.attachmentId = attachmentId;
	editDDf.htmlData = htmlData;
	editDDf.secretPassphrase = secretPassphrase;
	editDDf.editDataJson = editDataJson;
	editDDf.selectedFormDefinitionId = '<%=formDefinitionId%>';
	editDDf.getMasterDataResourceURL = '${getMasterDataResourceURL}';
    editDDf.fileJson = fileJson;
    editDDf.selectedRecordId = '${recordId}';
    editDDf.curUserRoles = curUserRoles;
    editDDf.isAdmin = '${isAdmin}';
	
    if(editDataJson != null && editDataJson != undefined && editDataJson != '' || (fileJson != null && fileJson != undefined && fileJson != '')) {
		dfrPortlet.editDDf(editDDf);
	}
	
});

</script>