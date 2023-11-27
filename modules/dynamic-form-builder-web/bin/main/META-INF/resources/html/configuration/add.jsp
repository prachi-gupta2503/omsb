<%@ include file="../init.jsp" %>
<div class="container" id="<portlet:namespace />dfFormContainer">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 pl-0 pr-0">
			<div class="accordion" id="<portlet:namespace />dfFormCardAccordian">
				<div class="card">
					<div class="card-header" id="<portlet:namespace />dfFormCardAccordianHeader">
						<a href="#" class="btn btn-header-link" data-toggle="collapse" data-target="#<portlet:namespace />dfFormCardAccordianBody" aria-expanded="true" 
							aria-controls="<portlet:namespace />dfFormCardAccordianBody">
							<liferay-ui:message key="form-builder-configuration" />
						</a>
					</div>
					<div id="<portlet:namespace />dfFormCardAccordianBody" class="collapse show" aria-labelledby="<portlet:namespace />dfFormCardAccordian" 
						data-parent="#<portlet:namespace />dfFormCardAccordian">
						<div class="card-body" id="<portlet:namespace />dfFormCardBody">
							<div class="row" id="<portlet:namespace />dfFormCardBodyLoadingRow">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="d-flex align-items-center" id="<portlet:namespace />dfFormCardBodyLoading">
									  <strong><liferay-ui:message key="loading" /></strong>
									  <div class="spinner-border ml-auto" role="status" aria-hidden="true"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<liferay-portlet:actionURL name="saveForm" var="saveForm" />

<aui:form action="${saveForm}" name="dfConfigurationForm" method="post">
	<aui:input name="obj" id="obj" type="hidden" />
</aui:form>
<!-- <form>
	<button type="submit" class="btn btn-primary">Save</button>
	<button type="reset" class="btn btn-primary">Reset</button>
</form> -->
<script type="text/javascript">
 $(document).ready(function () {
	 var config = new Object({}),
		namespace = '<portlet:namespace />',
		contextPath = '<%= request.getContextPath()%>',
		formJEL = '#' + namespace + 'dfForm',
		formContainerJEL = '#' + namespace + 'dfFormContainer',
		formCardHeaderJEL = '#' + namespace + 'dfFormCardHeader',
		formCardBodyJEL = '#' + namespace + 'dfFormCardBody',
		formCardBodyLoadingRowJEL = '#' + namespace + 'dfFormCardBodyLoadingRow',
		formCardBodyLoadingJEL = '#' + namespace + 'dfFormCardBodyLoading',
		formNameJEl = '#' + namespace + 'formName',
		formTitleJEl = '#' + namespace + 'formTitle',
		formDescriptionJEl = '#' + namespace + 'formDescription',
		fieldLabelJEl = '#' + namespace + 'fieldLabel_',
		fieldKeyJEl = '#' + namespace + 'fieldKey_',
		fieldTypeJEl = '#' + namespace + 'fieldType_',
		fieldPlaceholderJEl = '#' + namespace + 'placeholder_',
		fieldHTMLEditorPlaceholderJEl = '#' + namespace + 'htmlEditor_',
		fieldFormatPlaceholderJEl = '#' + namespace + 'formatPlaceholder_',
		fieldMinNumberPlaceholderJEl = '#' + namespace + 'minNumberPlaceholder_',
		fieldMaxNumberPlaceholderJEl = '#' + namespace + 'maxNumberPlaceholder_',
		fieldMultipleFileUploadJEl = '#' + namespace + 'multipleFileUpload_',
		fieldFileExtensionsInputTagJEl = '#' + namespace + 'fileExtensionsInputTag_',
		fieldGroupOrderJEl = '#' + namespace + 'groupOrder_',
		fieldGroupJEl = '#' + namespace + 'group_',
		fieldGroupAverageJEl = '#' + namespace + 'groupAverage_',
		fieldOverAllAverageJEl = '#' + namespace + 'overAllAverage_',
		fieldMinBoundaryJEl =  '#' + namespace + 'minBoundary_',
		fieldMaxBoundaryJEl =  '#' + namespace + 'maxBoundary_',
		fieldRangeOptionsJEl =  '#' + namespace + 'rangeOptions_',
		fieldRangeOptionsConfigTableJEL = '#' + namespace + 'rangOptionsConfigTable_',
		fieldRangeOptionsConfigTbodyJEL = '#' + namespace + 'rangeOptionsConfigTbody_',
		fieldValuesInputTagJEl = '#' + namespace + 'valuesInputTag_',
		fieldDefaultSelectedJEl = '#' + namespace + 'defaultSelected_',
		fieldMultiselectDropdownCheckboxJEl = '#' + namespace + 'multiselectDropdownCheckbox_',
		fieldSearchableDropdownCheckboxJEl = '#' + namespace + 'searchableDropdownCheckbox_',
		fieldWhereToPopulateDropdownJEl = '#' + namespace + 'whereToPopulateDropdown_',
		fieldStaticValuesInputTagJEl = '#' + namespace + 'staticValuesInputTag_',
		fieldDependentFieldsNameJEl = '#' + namespace + 'dependentFieldsName_',
		fieldWhereToPopulateDependentFieldsJEL = 'whereToPopulateDependentFields_'
		fieldDataProviderURLJEl = '#' + namespace + 'dataProviderURL_',
		fieldMethodTypesJEl = '#' + namespace + 'methodTypes_',
		fieldContentTypesJEl = '#' + namespace + 'contentTypes_',
		fieldDataPropsJEl = '#' + namespace + 'dataProps_',
		fieldSourcePropsJEl = '#' + namespace + 'sourceProps_',
		fieldDataProviderURLPropertyJEl = '#' + namespace + 'dataProviderPropertyURL_',
		fieldDataTypeJEl = '#' + namespace + 'fieldDataType_',
		fieldStatusJEl = '#' + namespace + 'fieldStatus_',
		fieldReadonlyJEl = '#' + namespace + 'fieldReadonly_',
		fieldDisableJEl = '#' + namespace + 'fieldDisable_',
		fieldRequiredJEl = '#' + namespace + 'fieldRequired_',
		fieldPostDataJEL = '#' + namespace + 'postData_',
		fieldPostDataNameJEL = '#' + namespace + 'postDataName_',
		fieldPopulateDataJEL = '#' + namespace + 'populateData_',
		fieldPopulateDataNameJEL = '#' + namespace + 'populateDataName_',
		fieldReadFromReqParamJEL = '#' + namespace + 'readFromReqParam_',
		fieldReadFromReqParamNameJEL = '#' + namespace + 'readFromReqParamName_',
		addFormFieldRowButtonJEL = '#' + namespace + 'addFormFieldRow_',
		deleteFormFieldRowButtonJEL = '#' + namespace + 'deleteFormFieldRow_',
		formPostDataURLJEL = '#' + namespace + 'postDataURL',
		formPostDataContentTypeJEL = '#' + namespace + 'postDataContentType',
		formPrepopulateDataURLJEL = '#' + namespace + 'prepopulateDataURL',
		formPrepopulateDataContentTypeJEL = '#' + namespace + 'prepopulateDataContentType',
		dfConfigurationFormJEl = '#' + namespace + 'dfConfigurationForm';
		
	 config.namespace = namespace;
	 config.contextPath = contextPath;
	 config.formContainerJEL = formContainerJEL;
	 config.formCardHeaderJEL = formCardHeaderJEL;
	 config.formCardBodyJEL = formCardBodyJEL;
	 config.formCardBodyLoadingRowJEL = formCardBodyLoadingRowJEL;
	 config.formCardBodyLoadingJEL = formCardBodyLoadingJEL;
	 config.formNameJEl = formNameJEl;
	 config.formTitleJEl = formTitleJEl;
	 config.formDescriptionJEl = formDescriptionJEl;
	 config.fieldLabelJEl = fieldLabelJEl;
	 config.fieldKeyJEl = fieldKeyJEl;
	 config.fieldTypeJEl = fieldTypeJEl;
	 config.fieldPlaceholderJEl = fieldPlaceholderJEl;
	 config.fieldHTMLEditorPlaceholderJEl = fieldHTMLEditorPlaceholderJEl;
	 config.fieldFormatPlaceholderJEl = fieldFormatPlaceholderJEl;
	 config.fieldMinNumberPlaceholderJEl = fieldMinNumberPlaceholderJEl;
	 config.fieldMaxNumberPlaceholderJEl = fieldMaxNumberPlaceholderJEl;
	 config.fieldMultipleFileUploadJEl = fieldMultipleFileUploadJEl;
	 config.fieldFileExtensionsInputTagJEl = fieldFileExtensionsInputTagJEl;
	 config.fieldGroupOrderJEl = fieldGroupOrderJEl;
	 config.fieldGroupJEl = fieldGroupJEl;
	 config.fieldGroupAverageJEl = fieldGroupAverageJEl;
	 config.fieldOverAllAverageJEl = fieldOverAllAverageJEl;
	 config.fieldMinBoundaryJEl = fieldMinBoundaryJEl;
	 config.fieldMaxBoundaryJEl = fieldMaxBoundaryJEl;
	 config.fieldRangeOptionsJEl = fieldRangeOptionsJEl;
	 config.fieldRangeOptionsConfigTableJEL = fieldRangeOptionsConfigTableJEL;
	 config.fieldRangeOptionsConfigTbodyJEL = fieldRangeOptionsConfigTbodyJEL;
	 config.fieldValuesInputTagJEl = fieldValuesInputTagJEl, 
	 config.fieldDefaultSelectedJEl = fieldDefaultSelectedJEl,
	 config.fieldMultiselectDropdownCheckboxJEl = fieldMultiselectDropdownCheckboxJEl, 
	 config.fieldSearchableDropdownCheckboxJEl = fieldSearchableDropdownCheckboxJEl,
	 config.fieldWhereToPopulateDropdownJEl = fieldWhereToPopulateDropdownJEl,
	 config.fieldStaticValuesInputTagJEl = fieldStaticValuesInputTagJEl, 
	 config.fieldDependentFieldsNameJEl = fieldDependentFieldsNameJEl,
	 config.fieldWhereToPopulateDependentFieldsJEL = fieldWhereToPopulateDependentFieldsJEL,
	 config.fieldDataProviderURLJEl = fieldDataProviderURLJEl,
	 config.fieldMethodTypesJEl = fieldMethodTypesJEl,
	 config.fieldContentTypesJEl = fieldContentTypesJEl,
	 config.fieldDataPropsJEl = fieldDataPropsJEl,
	 config.fieldSourcePropsJEl = fieldSourcePropsJEl,
	 config.fieldDataProviderURLPropertyJEl = fieldDataProviderURLPropertyJEl,
	 config.fieldDataTypeJEl = fieldDataTypeJEl;
	 config.fieldStatusJEl = fieldStatusJEl;
	 config.fieldReadonlyJEl = fieldReadonlyJEl;
	 config.fieldDisableJEl = fieldDisableJEl;
	 config.fieldRequiredJEl = fieldRequiredJEl;
	 config.fieldPostDataJEL = fieldPostDataJEL;
	 config.fieldPostDataNameJEL = fieldPostDataNameJEL;
	 config.fieldPopulateDataJEL = fieldPopulateDataJEL;
	 config.fieldPopulateDataNameJEL = fieldPopulateDataNameJEL;
	 config.fieldReadFromReqParamJEL = fieldReadFromReqParamJEL;
	 config.fieldReadFromReqParamNameJEL = fieldReadFromReqParamNameJEL;
	 config.addFormFieldRowButtonJEL = addFormFieldRowButtonJEL;
	 config.deleteFormFieldRowButtonJEL = deleteFormFieldRowButtonJEL;
	 config.formPostDataURLJEL =  formPostDataURLJEL;
	 config.formPostDataContentTypeJEL = formPostDataContentTypeJEL;
	 config.formPrepopulateDataURLJEL = formPrepopulateDataURLJEL;
	 config.formPrepopulateDataContentTypeJEL = formPrepopulateDataContentTypeJEL;
	 config.dfConfigurationFormJEl = dfConfigurationFormJEl;
	 
	 dfPortlet.viewDFConfig(config);
	 
	 console.log( "ready!" );
	 var obj = '{"name": "Sample Form", "title": "Medical Specialty Board In-Training Assessment Report (Clinical) EDIT","description": "SW5zdHJ1Y3Rpb25zOgpTQ0FMRSAKMS4gVW5zYXRpc2ZhY3RvcnkgOiBQb29yIGNvbXBldGVuY3kganVkZ21lbnQuIFJlcXVpcmVzIGNvbnRpbnVvdXMgc3VwZXJ2aXNpb24uCjIuIEJlbG93IEV4cGVjdGF0aW9ucyA6IEluYWRlcXVhdGUgY29tcGV0ZW5jeSBqdWRnbWVudC4gUmVxdWlyZXMgZnJlcXVlbnQgc3VwZXJ2aXNpb24uCjMuIE1lZXRzIEV4cGVjdGF0aW9ucyA6IEVmZmVjdGl2ZSBjb21wZXRlbmN5IGp1ZGdtZW50LiBTdXBlcnZpc2lvbiBuZWVkZWQgZm9yIGNvbXBsZXgvZGlmZmljdWx0eSBzaXR1YXRpb25zLiAKNC4gRXhjZWVkcyBFeHBlY3RhdGlvbnMgOiBFeGVtcGxhcnkgY29tcGV0ZW5jeSBqdWRnbWVudCBpbmNsdWRpbmcgaW4gY29tcGxleC9kaWZmaWN1bHQgc2l0dWF0aW9ucy4gQ2FuIHByYWN0aWNlCmluZGVwZW5kZW50bHkuCk5vdCBBcHBsaWNhYmxlIDogTm90IHJlbGV2YW50IGluIHRoZSBzZXR0aW5nLCBub3Qgb2JzZXJ2ZWQgb3IgdW5hYmxlIHRvIGV2YWx1YXRl","fields": [{"key": "firstName","label": "First Name","settings": {"type": "text","dataType": "string","status": "active","readonly": false,"disable" : false,"required": true,"placeHolder" : "Enter your first name","postData": {"fieldName": "first_name"},"populateData": {"fieldName": "first_name"},"readFromRequestParam": {"paramName": "firstName"},}}],}';
	 /* var myJSON = JSON.stringify(obj); */
	 $("#<portlet:namespace />obj").val(obj);
	 
 });
 </script>