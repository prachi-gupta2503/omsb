(function($, dfPortlet) {

	function viewDFConfig(config){
		
		var namespace = config.namespace,
			contextPath = config.contextPath,
			formContainerJEL = config.formContainerJEL,
			formCardHeaderJEL = config.formCardHeaderJEL,
			formCardBodyJEL = config.formCardBodyJEL,
			formCardBodyLoadingRowJEL = config.formCardBodyLoadingRowJEL,
			formCardBodyLoadingJEL = config.formCardBodyLoadingJEL,
			formNameJEl = config.formNameJEl,
			formTitleJEl = config.formTitleJEl,
			formDescriptionJEl = config.formDescriptionJEl,
			fieldLabelJEl=config.fieldLabelJEl,
			fieldKeyJEl = config.fieldKeyJEl,
			fieldTypeJEl = config.fieldTypeJEl,
			fieldPlaceholderJEl = config.fieldPlaceholderJEl,
			fieldHTMLEditorPlaceholderJEl = config.fieldHTMLEditorPlaceholderJEl,
			fieldFormatPlaceholderJEl = config.fieldFormatPlaceholderJEl,
			fieldMinNumberPlaceholderJEl = config.fieldMinNumberPlaceholderJEl,
			fieldMaxNumberPlaceholderJEl = config.fieldMaxNumberPlaceholderJEl,
			fieldMultipleFileUploadJEl = config.fieldMultipleFileUploadJEl,
			fieldFileExtensionsInputTagJEl = config.fieldFileExtensionsInputTagJEl,
			fieldGroupOrderJEl = config.fieldGroupOrderJEl,
			fieldGroupJEl = config.fieldGroupJEl,
			fieldGroupAverageJEl = config.fieldGroupAverageJEl,
			fieldOverAllAverageJEl = config.fieldOverAllAverageJEl,
			fieldMinBoundaryJEl = config.fieldMinBoundaryJEl,
			fieldMaxBoundaryJEl = config.fieldMaxBoundaryJEl,
			fieldRangeOptionsJEl = config.fieldRangeOptionsJEl,
			fieldRangeOptionsConfigTableJEL = config.fieldRangeOptionsConfigTableJEL,
			fieldRangeOptionsConfigTbodyJEL = config.fieldRangeOptionsConfigTbodyJEL,
			fieldValuesInputTagJEl = config.fieldValuesInputTagJEl, 
			fieldDefaultSelectedJEl = config.fieldDefaultSelectedJEl,
			fieldMultiselectDropdownCheckboxJEl = config.fieldMultiselectDropdownCheckboxJEl, 
			fieldSearchableDropdownCheckboxJEl = config.fieldSearchableDropdownCheckboxJEl,
			fieldWhereToPopulateDropdownJEl = config.fieldWhereToPopulateDropdownJEl,
			fieldStaticValuesInputTagJEl = config.fieldStaticValuesInputTagJEl, 
			fieldDependentFieldsNameJEl = config.fieldDependentFieldsNameJEl,
			fieldWhereToPopulateDependentFieldsJEL = config.fieldWhereToPopulateDependentFieldsJEL,
			fieldDataProviderURLJEl = config.fieldDataProviderURLJEl,
			fieldMethodTypesJEl = config.fieldMethodTypesJEl,
			fieldContentTypesJEl = config.fieldContentTypesJEl,
			fieldDataPropsJEl = config.fieldDataPropsJEl,
			fieldSourcePropsJEl = config.fieldSourcePropsJEl,
			fieldDataProviderURLPropertyJEl = config.fieldDataProviderURLPropertyJEl,
			fieldDataTypeJEl = config.fieldDataTypeJEl,
			fieldStatusJEl = config.fieldStatusJEl,
			fieldReadonlyJEl = config.fieldReadonlyJEl,
			fieldDisableJEl = config.fieldDisableJEl,
			fieldRequiredJEl = config.fieldRequiredJEl,
			fieldPostDataJEL =  config.fieldPostDataJEL,
			fieldPostDataFieldJEL = config.fieldPostDataFieldJEL,
			fieldPopulateDataJEL = config.fieldPopulateDataJEL,
			fieldPopulateDataNameJEL = config.fieldPopulateDataNameJEL,
			fieldReadFromReqParamJEL = config.fieldReadFromReqParamJEL,
			fieldReadFromReqParamNameJEL = config.fieldReadFromReqParamNameJEL,
			addFormFieldRowButtonJEL = config.addFormFieldRowButtonJEL,
			deleteFormFieldRowButtonJEL = config.deleteFormFieldRowButtonJEL,
			formPostDataURLJEL = config.formPostDataURLJEL,
			formPostDataContentTypeJEL = config.formPostDataContentTypeJEL,
			formPrepopulateDataURLJEL = config.formPrepopulateDataURLJEL,
			formPrepopulateDataContentTypeJEL = config.formPrepopulateDataContentTypeJEL,
			dfConfigurationFormJEl = config.dfConfigurationFormJEl,
			formFieldsAccordianCardBodyJEl;
			
			settingTypes =  [
				{'label':'Textbox', 'value':'text'},
				{'label':'Textarea', 'value':'textarea'},
				{'label':'HTML Editor', 'value':'html'},
				{'label':'Number', 'value':'number'},
				{'label':'Image/File', 'value':'file'},
				{'label':'Label', 'value':'readonly'},
				{'label':'Range', 'value':'range'},
				{'label':'Radio', 'value':'radio'},
				{'label':'Checkbox', 'value':'checkbox'},
				{'label':'Date', 'value':'date'},
				{'label':'Time', 'value':'time'},
				{'label':'DateTime', 'value':'datetime'},
				{'label':'Dropdown', 'value':'dropdown'}
			];
			settingDataTypes =[
				{'label':'string', 'value':'string'},
				{'label':'longtext', 'value':'longtext'},
				{'label':'integer', 'value':'number'},
				{'label':'double', 'value':'number'},
				{'label':'long', 'value':'number'},
				{'label':'boolean', 'value':'boolean'},
				{'label':'datetime', 'value':'datetime'}
			]
			settingStatus = [
				{'label':'Active', 'value':'active'},
				{'label':'Inactive', 'value':'inactive'},
			];
			dateFormats = [
				{'label':'MM/dd/yyyy', 'value':'MM/dd/yyyy'},
				{'label':'MM-dd-yyyy', 'value':'MM-dd-yyyy'},
				{'label':'MMM/dd/yyyy', 'value':'MMM/dd/yyyy'},
				{'label':'MMM-dd-yyyy', 'value':'MMM-dd-yyyy'},
				{'label':'dd/MM/yyyy', 'value':'dd/MM/yyyy'},
				{'label':'dd-MM-yyyy', 'value':'dd-MM-yyyy'},
				{'label':'dd/MMM/yyyy', 'value':'dd/MMM/yyyy'},
				{'label':'dd-MMM-yyyy', 'value':'dd-MMM-yyyy'},
				{'label':'yyyy/MM/dd', 'value':'yyyy/MM/dd'},
				{'label':'yyyy-MM-dd', 'value':'yyyy-MM-dd'},
				{'label':'yyyy/MMM/dd', 'value':'yyyy/MMM/dd'},
				{'label':'yyyy-MMM-dd', 'value':'yyyy-MMM-dd'}
			];
			timeFormats = [
				{'label':'HH:MM:SS', 'value':'HH:MM:SS'},
				{'label':'HH:MM:SS a', 'value':'HH:MM:SS a'},
				{'label':'HH:MM', 'value':'HH:MM'},
				{'label':'HH:MM a', 'value':'HH:MM a'}
			];
			dateTimeFormats = [
				{'label':'MM/dd/yyyy HH:MM:SS', 'value':'MM/dd/yyyy HH:MM:SS'},
				{'label':'MM/dd/yyyy HH:MM:SS a', 'value':'MM/dd/yyyy HH:MM:SS a'},
				{'label':'MM/dd/yyyy HH:MM', 'value':'MM/dd/yyyy HH:MM'},
				{'label':'MM/dd/yyyy HH:MM a', 'value':'MM/dd/yyyy HH:MM a'},
				{'label':'MM-dd-yyyy HH:MM:SS', 'value':'MM-dd-yyyy HH:MM:SS'},
				{'label':'MM-dd-yyyy HH:MM:SS a', 'value':'MM-dd-yyyy HH:MM:SS a'},
				{'label':'MM-dd-yyyy HH:MM', 'value':'MM-dd-yyyy HH:MM'},
				{'label':'MM-dd-yyyy HH:MM a', 'value':'MM-dd-yyyy HH:MM a'},
				{'label':'MMM/dd/yyyy HH:MM:SS', 'value':'MMM/dd/yyyy HH:MM:SS'},
				{'label':'MMM/dd/yyyy HH:MM:SS a', 'value':'MMM/dd/yyyy HH:MM:SS a'},
				{'label':'MMM/dd/yyyy HH:MM', 'value':'MMM/dd/yyyy HH:MM'},
				{'label':'MMM/dd/yyyy HH:MM a', 'value':'MMM/dd/yyyy HH:MM a'},
				{'label':'MMM-dd-yyyy HH:MM:SS', 'value':'MMM-dd-yyyy HH:MM:SS'},
				{'label':'MMM-dd-yyyy HH:MM:SS a', 'value':'MMM-dd-yyyy HH:MM:SS a'},
				{'label':'MMM-dd-yyyy HH:MM', 'value':'MMM-dd-yyyy HH:MM'},
				{'label':'MMM-dd-yyyy HH:MM a', 'value':'MMM-dd-yyyy HH:MM a'},
				{'label':'dd/MM/yyyy HH:MM:SS', 'value':'dd/MM/yyyy HH:MM:SS'},
				{'label':'dd/MM/yyyy HH:MM:SS a', 'value':'dd/MM/yyyy HH:MM:SS a'},
				{'label':'dd/MM/yyyy HH:MM', 'value':'dd/MM/yyyy HH:MM'},
				{'label':'dd/MM/yyyy HH:MM a', 'value':'dd/MM/yyyy HH:MM a'},
				{'label':'dd-MM-yyyy HH:MM:SS', 'value':'dd-MM-yyyy HH:MM:SS'},
				{'label':'dd-MM-yyyy HH:MM:SS a', 'value':'dd-MM-yyyy HH:MM:SS a'},
				{'label':'dd-MM-yyyy HH:MM', 'value':'dd-MM-yyyy HH:MM'},
				{'label':'dd-MM-yyyy HH:MM a', 'value':'dd-MM-yyyy HH:MM a'},
				{'label':'dd/MMM/yyyy HH:MM:SS', 'value':'dd/MMM/yyyy HH:MM:SS'},
				{'label':'dd/MMM/yyyy HH:MM:SS a', 'value':'dd/MMM/yyyy HH:MM:SS a'},
				{'label':'dd/MMM/yyyy HH:MM', 'value':'dd/MMM/yyyy HH:MM'},
				{'label':'dd/MMM/yyyy HH:MM a', 'value':'dd/MMM/yyyy HH:MM a'},
				{'label':'dd-MMM-yyyy HH:MM:SS', 'value':'dd-MMM-yyyy HH:MM:SS'},
				{'label':'dd-MMM-yyyy HH:MM:SS a', 'value':'dd-MMM-yyyy HH:MM:SS a'},
				{'label':'dd-MMM-yyyy HH:MM', 'value':'dd-MMM-yyyy HH:MM'},
				{'label':'dd-MMM-yyyy HH:MM a', 'value':'dd-MMM-yyyy HH:MM a'},
				{'label':'yyyy/MM/dd HH:MM:SS', 'value':'yyyy/MM/dd HH:MM:SS'},
				{'label':'yyyy/MM/dd HH:MM:SS a', 'value':'yyyy/MM/dd HH:MM:SS a'},
				{'label':'yyyy/MM/dd HH:MM', 'value':'yyyy/MM/dd HH:MM'},
				{'label':'yyyy/MM/dd HH:MM a', 'value':'yyyy/MM/dd HH:MM a'},
				{'label':'yyyy-MM-dd HH:MM:SS', 'value':'yyyy-MM-dd HH:MM:SS'},
				{'label':'yyyy-MM-dd HH:MM:SS a', 'value':'yyyy-MM-dd HH:MM:SS a'},
				{'label':'yyyy-MM-dd HH:MM', 'value':'yyyy-MM-dd HH:MM'},
				{'label':'yyyy-MM-dd HH:MM a', 'value':'yyyy-MM-dd HH:MM a'},
				{'label':'yyyy/MMM/dd HH:MM:SS', 'value':'yyyy/MMM/dd HH:MM:SS'},
				{'label':'yyyy/MMM/dd HH:MM:SS a', 'value':'yyyy/MMM/dd HH:MM:SS a'},
				{'label':'yyyy/MMM/dd HH:MM', 'value':'yyyy/MMM/dd HH:MM'},
				{'label':'yyyy/MMM/dd HH:MM a', 'value':'yyyy/MMM/dd HH:MM a'},
				{'label':'yyyy-MMM-dd HH:MM:SS', 'value':'yyyy-MMM-dd HH:MM:SS'},
				{'label':'yyyy-MMM-dd HH:MM:SS a', 'value':'yyyy-MMM-dd HH:MM:SS a'},
				{'label':'yyyy-MMM-dd HH:MM', 'value':'yyyy-MMM-dd HH:MM'},
				{'label':'yyyy-MMM-dd HH:MM a', 'value':'yyyy-MMM-dd HH:MM a'}
			];
			whereToPopulateDropdownValues = [
				{'label':'Static Values', 'value':'staticValues'},
				{'label':'Dependent Fields', 'value':'dependentFields'},
				{'label':'Data Provider', 'value':'dataProvider'}
			];
			contentTypes = [
				{'label':'application/x-www-form-urlencoded', 'value':'application/x-www-form-urlencoded'},
				{'label':'application/json', 'value':'application/json'},
				{'label':'application/xml', 'value':'application/xml'}
			];
			whereToPopulateDF = [
				{'label':'Static Values', 'value':'staticValues'},
				{'label':'Data Provider', 'value':'dataProvider'}
			];
			methodTypes = [
				{'label':'GET', 'value':'get'},
				{'label':'POST', 'value':'post'}
			];
		createFormConfiguration = function(){
			var formCardEl;
			formCardEl = commonFc.createCardEl();
			$(formCardEl).append();
			createFormBasicSection();
			createFormFieldConfigRows();
			createFormFieldFooterSectionRow();
			createFormButtonSectionRow();
		};
		initFormConfig = function(){
			createFormConfiguration();
		};
		
		selectedFieldSettingType = function(curSelectedField, ind){
			var selectedField;
			selectedField = $(curSelectedField).find('option:selected').val();
			$('#' + namespace + 'fieldReadonly_' + ind).prop('checked', false);
			if(selectedField=='text') {
				toggleTextField(ind);
			}else if(selectedField=='textarea') {
				toggleTextAreaField(ind);
			}else if(selectedField=='number') {
				toggleNumberField(ind);
			}else if(selectedField=='date' || selectedField=='time' ||  selectedField=='datetime'){
				toggleFormatField(ind, selectedField);
			}else if(selectedField=='radio'){
				toggleRadioField(ind);
			}else if(selectedField=='checkbox'){
				toggleCheckboxField(ind);
			}else if(selectedField=='dropdown'){
				toggleDropdownField(ind);
			}else if(selectedField=='html'){
				toggleHTMLEditorField(ind);
			}else if(selectedField=='file'){
				toggleFileField(ind);
			}else if(selectedField == 'readonly'){
				$('#' + namespace + 'fieldReadonly_' + ind).prop('checked', true);
				toggleReadOnlyField(ind);
			}else if(selectedField == 'range'){
				toggleRangeField(ind);
			}
			
			
			populateFieldDataTypesDropdown(selectedField, ind);
		};
		
		
		populateFieldDataTypesDropdown = function(selectedField, ind){
			var data = [], dataTypes = settingDataTypes;
			if(selectedField == 'text' || selectedField == 'radio' || selectedField =='checkbox' || selectedField == 'time' || selectedField == 'dropdown' ||
			   selectedField =='label'){
				data = dataTypes.filter(dataType => dataType.label == 'string');
			}else if(selectedField == 'textarea'){
				data = dataTypes.filter(dataType => dataType.label == 'string' || dataType.label == 'longtext');
			}else if(selectedField == 'html'){
				data = dataTypes.filter(dataType => dataType.label == 'longtext');
			}else if(selectedField == 'number'){
				data = dataTypes.filter(dataType => dataType.label == 'integer' || dataType.label == 'double' ||  dataType.label == 'long');
			}else if(selectedField == 'file'){
				data = dataTypes.filter(dataType => dataType.label == 'long');
			}else if(selectedField == 'datetime' || selectedField == 'date'){
	 			data = dataTypes.filter(dataType => dataType.label == 'datetime');
			}else if(selectedField == 'range'){
	 			data = dataTypes.filter(dataType => dataType.label == 'integer' || dataType.label == 'string');
			}
			
			var fieldDataTypesDropdownEl = $('#' + namespace + 'fieldDataType_' + ind);
			commonFc.populateDropdown(data, fieldDataTypesDropdownEl);
		};
		
		toggleTextField = function(ind){
			displayPlaceholder(ind);
		};
		
		toggleTextAreaField = function(ind){
			displayPlaceholder(ind);
		};
		
		displayPlaceholder = function(ind){
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleHTMLEditorField = function(ind) {
			commonFc.initTextEditor('#' + namespace + 'htmlEditor_' + ind);
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleNumberField = function(ind){
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
		
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleFormatField = function(ind, format){
			var data = [];
			if(format=='date'){
				data = dateFormats;
			}else if(format=='time'){
				data = timeFormats;
			}else if(format=='datetime'){
				data = dateTimeFormats;
			}
			
			var formatPlaceholderDropdownEl = $('#' + namespace + 'formatPlaceholder_' + ind);
			commonFc.populateDropdown(data, formatPlaceholderDropdownEl);
			
			displayFormat(ind);
		};
		
		displayFormat = function(ind){
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleRadioField = function(ind){
			initRadioAndCheckboxInputTags(ind);
			var select2ExtraConfig = {
				maximumSelectionLength : 1,
				closeOnSelect : true	
			};
			initDefaultSelectedDropdown(ind, select2ExtraConfig);
			
			displayRadioAndCheckboxField(ind);
			
		};
		toggleCheckboxField = function(ind){
			initRadioAndCheckboxInputTags(ind);
			var select2ExtraConfig = {
					closeOnSelect : false	
				};
			initDefaultSelectedDropdown(ind, select2ExtraConfig);
			displayRadioAndCheckboxField(ind);
		};
		
		displayRadioAndCheckboxField = function(ind) {
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleDropdownField = function(ind){
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-block');
			
			$('#' + namespace + 'whereToPopulateDropdown_' + ind).val("");
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		whereToPopulateSelectedDropdownValue = function(curSelectedValue, ind) {
			var selectedValue;
			selectedValue = $(curSelectedValue).find('option:selected').val();
			
			if(selectedValue == 'staticValues'){
				toggleStaticValues(curSelectedValue, ind);
			}else if(selectedValue == 'dataProvider') {
				toggleDataProvider(curSelectedValue, ind);
			}else if(selectedValue == 'dependentFields') {
				toggleDependentFields(curSelectedValue, ind);
			}
		};
		
		toggleStaticValues = function(curSelectedValue, ind){
			var inputTagDivId, inputTagId, staticValuesFieldSettingSection;
			
			/*staticValuesFieldSettingSection = createStaticValuesFieldSettingSection(ind);
			$(curSelectedValue).closest(".card-body-settings-div-el").append(staticValuesFieldSettingSection);*/
			
			inputTagDivId = '#' + namespace + 'displayStaticValuesInputTag_' + ind;
			inputTagId = '#' + namespace + 'staticValuesInputTag_' + ind;
			initInputTags(ind, inputTagDivId, inputTagId);
			displayStaticValues(ind);
	
		};
		
		displayStaticValues = function(ind){
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('hide');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('show');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		whereToPopulateDependentFields = function(curSelectedDF, ind){
			var selectedDF, tagValues;
			selectedDF = $(curSelectedDF).find('option:selected').val();
			if(selectedDF == 'staticValues'){
				console.log('Static values with dependent field');
				//tagValues = getDFValues(ind);
				//displayDFStaticValues(curSelectedDF,ind, tagValues);
				//toggleDFStaticValues(ind);
			}else if(selectedDF == 'dataProvider') {
				toggleDFDataProvider(curSelectedDF, ind);
			}
		};
		
		/*getDFValues = function(ind){
			var dependentFieldName,  dependentFieldNameId, curField, inputTagsId, index;
			dependentFieldName = $('#' + namespace + 'dependentFieldsName_' + ind).val();
			curField = $('.field-key-input-el').filter((index, curFieldKey) => $(curFieldKey).val() == dependentFieldName);
			inputTagsId = $(curField).closest('.form-field-row-div-el').find('div.values-input-tag-el');
			console.log('inputTagsId', inputTagsId);
			inputTagsValue = $(inputTagsId).val();
			console.log('inputTagsValue', inputTagsValue);
			return inputTagsValue;
		};
		
		displayDFStaticValues = function(curSelectedDF, ind, tagValues){
			var dfStaticValues, curIndex, index = 1;
			console.log('tagValues length',tagValues);
			
			tagValues = JSON.parse(tagValues);
			for (var tagValue of tagValues) {
				console.log('value', tagValue.value);
				curIndex= ind + '_' + index;
				dfStaticValues = createDFStaticValues(curIndex);
				$(curSelectedDF).closest(".card-body-settings-div-el").append(dfStaticValues);
				$('#' + namespace + 'displayDFFieldValue_' + curIndex).val(tagValue.value);
				toggleDFStaticValues(curIndex);
				index++;
			}
			
		};
		
		toggleDFStaticValues = function(ind){
			console.log('toggling DF Static Value',);
			$('#' + namespace + 'dfStaticValuesRow_' + ind).removeClass('hide');
			$('#' + namespace + 'dfStaticValuesRow_' + ind).addClass('show');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('hide');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('show');
		};*/
		
		toggleDFDataProvider = function(curSelectedDF, ind){
			var dataProviderFieldSettingSection, fieldSettingSection;
			$('#' + namespace + 'dataProviderRow_' + ind).remove();
			//if($('#' + namespace + 'dataProviderRow_' + ind).length <= 1){
				dataProviderFieldSettingSection = createDataProviderFieldSettingSection(ind);
				$(curSelectedDF).closest(".card-body-settings-div-el").append(dataProviderFieldSettingSection);
				displaySourceProps(ind);
				initDataProps(ind);
				initSourceProps(ind);
				displayDFDataProvider(ind);
			//}
		};
		
		displaySourceProps = function(ind){
			$('#' + namespace + 'displaySourceProps_' + ind).removeClass('d-none');
			$('#' + namespace + 'displaySourceProps_' + ind).addClass('d-block');
		}
		
		displayDFDataProvider = function(ind){
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('hide');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('show');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('hide');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('show');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleDependentFields = function(curSelectedValue, ind){
			var dependentFieldSettingSection;
			
			/*dependentFieldSettingSection = createDependentFieldSettingSection(ind);
			$(curSelectedValue).closest(".card-body-settings-div-el").append(dependentFieldSettingSection);*/
			
			displayDependentFields(ind);
			populateDependentFieldsName(ind);
		};
		
		displayDependentFields = function(ind){
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('hide');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('show');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
			
		};
		
		populateDependentFieldsName = function(ind){
			var data = [];
			
			var curRow, curSelectedFieldLabel, curSelectedFieldKey, curSelectedFieldType, curSelectedOption;
			var fieldKey = $('.form-field-row').each(function(index) { 
				var dataObj = new Object({});
				if(index+1 == ind){
					return;
				}else{
					curSelectedFieldType = $(this).find('.field-type-dropdown-el');
					curSelectedOption = $(curSelectedFieldType).find('option:selected').val();
					console.log('curSelectedOption', curSelectedOption);
					if(curSelectedOption == 'radio' || curSelectedOption == 'checkbox' || curSelectedOption == 'dropdown'){
						curSelectedFieldLabel = $(this).find('.field-label-input-el').val();
						curSelectedFieldKey = $(this).find('.field-key-input-el').val();
						dataObj.label = curSelectedFieldLabel;
						dataObj.value = curSelectedFieldKey;
						data.push(dataObj);
					}
				}
			});
			commonFc.populateDropdown(data, '#' + namespace + 'dependentFieldsName_' + ind);
			
		};
		
		
		toggleDataProvider = function(curSelectedValue, ind){
			var inputTagDivId, inputTagId, dataProviderFieldSettingSection;
			$('#' + namespace + 'dataProviderRow_' + ind).remove();
			dataProviderFieldSettingSection = createDataProviderFieldSettingSection(ind);
			$(curSelectedValue).closest(".card-body-settings-div-el").append(dataProviderFieldSettingSection);
			initDataProps(ind);
			displayDataProvider(ind);
			
		};
		initDataProps = function(ind){
			inputTagDivId = '#' + namespace + 'displayDataProps_' + ind;
			inputTagId = '#' + namespace + 'dataProps_' + ind;
			initInputTags(ind, inputTagDivId, inputTagId);
		};
		
		initSourceProps = function(ind){
			inputTagDivId = '#' + namespace + 'displaySourceProps_' + ind;
			inputTagId = '#' + namespace + 'sourceProps_' + ind;
			initInputTags(ind, inputTagDivId, inputTagId);
		};
		displayDataProvider = function(ind){
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('hide');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('show');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		populateContentTypes =  function(curMethodType, ind){
			var selectedMethodType;
			selectedMethodType = $(curMethodType).find('option:selected').val();
			if(selectedMethodType == 'post'){
				//togglePostMethodContentType(ind);
				$('#' + namespace + 'displayContentTypes_' + ind).removeClass('d-none');
				$('#' + namespace + 'displayContentTypes_' + ind).addClass('d-block');
				commonFc.populateDropdown(contentTypes, '#' + namespace + 'contentTypes_' + ind);
			}else{
				//toggleContentType(ind);
				$('#' + namespace + 'displayContentTypes_' + ind).removeClass('d-block');
				$('#' + namespace + 'displayContentTypes_' + ind).addClass('d-none');
			}
		};
		
		toggleFileField = function(ind) {
			inputTagDivId = '#' + namespace + 'displayFileExtensionsInputTag_' + ind;
			inputTagId = '#' + namespace + 'fileExtensionsInputTag_' + ind;
			initInputTags(ind, inputTagDivId, inputTagId);
			displayFileField(ind);
		};
		
		displayFileField = function(ind){
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleReadOnlyField = function(ind){
			//$('#' + namespace + 'fieldReadonly_' + ind).prop('checked', true);
			displayReadOnlyField(ind);
		};
		
		displayReadOnlyField = function(ind){
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-none');
			
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).removeClass('show');
			$('#' + namespace + 'rangeOptionsConfigRow_' + ind).addClass('hide');
		};
		
		toggleRangeField = function(ind){
			initRangeInputTags(ind);
			displayRangeField(ind);
		};
		
		populateRangeOptionsConfig = function(curEl, ind){
			var closestFormFieldRow, tagValues, rangeOptionsConfigTbodyEl;
			
			closestFormFieldRow = $(curEl).closest('.form-field-row-div-el');
			tagValues = $(closestFormFieldRow).find('div.range-options-el').val();
			
			if(tagValues){
				populateRangeOptionsConfigTable(closestFormFieldRow, tagValues);
			}
		};
		
		initRangeInputTags = function(ind) {
			if($('#' + namespace + 'displayRangeOptions_' + ind).find("tags").length <= 0) {
				var inputTags, tagValues, rangeOptionsConfigTbodyEl, closestFormFieldRow;
				inputTags = $('#' + namespace + 'rangeOptions_' + ind).tagify({
					hooks: {
					    beforeRemoveTag: function(tags) {
					        return new Promise((resolve, reject) => {
					            confirm("Are you sure you want to remove " + tags[0].data.value + " tag ?") ?
					                resolve() :
					                reject()
					        })
					    }
					}
				});
				inputTags.on('change',function(e){
					console.log('index4', ind);
					tagValues = e.currentTarget.tagifyValue;
					closestFormFieldRow = $(e.currentTarget).closest('.form-field-row-div-el');
					populateRangeOptionsConfigTable(closestFormFieldRow, tagValues);
				});
			}
		};
		
		populateRangeOptionsConfigTable = function(closestFormFieldRow, tagValues, ind){
			var rangeOptionsConfigTbodyEl, minBoundaryValue, maxBoundaryValue, rangeOptionsConfigRow, tagsLength, rangeLength, boundaryValue, optionValue, rowEl, nameDataEl,
				valueDataEl;
			
			rangeOptionsConfigTbodyEl = $(closestFormFieldRow).find('.range-options-config-tbody').attr('id');
			$('#' + rangeOptionsConfigTbodyEl).empty();
			minBoundaryValue = $(closestFormFieldRow).find('.min-boundary-el').val();
			maxBoundaryValue = $(closestFormFieldRow).find('.max-boundary-el').val();
			rangeOptionsConfigRow = $(closestFormFieldRow).find('.range-options-config-row');

			if(tagValues){
				tagValues = JSON.parse(tagValues);
				tagsLength = tagValues.length;
				rangeLength = tagsLength - 1;
			
				boundaryValue = maxBoundaryValue - minBoundaryValue;
				optionValue = boundaryValue/rangeLength;
	
				for (var i=0; i<tagsLength; i++) {
					rowEl = commonFc.createTREl();
					if(i == 0){
						nameDataEl = commonFc.createTDEl(tagValues[i].value);
						valueDataEl = commonFc.createTDEl(minBoundaryValue);
					}else if(i == rangeLength){
						nameDataEl = commonFc.createTDEl(tagValues[i].value);
						valueDataEl = commonFc.createTDEl(maxBoundaryValue);
					}else{
						minBoundaryValue = (parseFloat(minBoundaryValue) + parseFloat(optionValue)).toFixed(1);
						nameDataEl = commonFc.createTDEl(tagValues[i].value);
						valueDataEl = commonFc.createTDEl(minBoundaryValue);
					}
					
					$(rowEl).append(nameDataEl);
					$(rowEl).append(valueDataEl);
					$('#' + rangeOptionsConfigTbodyEl).append(rowEl);
				}
				$(rangeOptionsConfigRow).removeClass('hide');
				$(rangeOptionsConfigRow).addClass('show');
			}else{
				$(rangeOptionsConfigRow).removeClass('show');
				$(rangeOptionsConfigRow).addClass('hide');
			}
		};
		
		displayRangeField = function(ind){
			$('#' + namespace + 'displayGroupOrder_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayGroupOrder_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayGroup_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayGroup_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayAverage_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayAverage_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayMinBoundary_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayMinBoundary_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayMaxBoundary_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayMaxBoundary_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayRangeOptions_' + ind).removeClass('d-none');
			$('#' + namespace + 'displayRangeOptions_' + ind).addClass('d-block');
			
			$('#' + namespace + 'displayPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFormatPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMinNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMaxNumberPlaceholder_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayMultipleFileUpload_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayFileExtensionsInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayValuesInputTag_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayValuesInputTag_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDefaultSelected_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDefaultSelected_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayDropdownConfigCheckbox_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayWhereToPopulateDropdown_' + ind).addClass('d-none');
			
			$('#' + namespace + 'displayHTMLEditor_' + ind).removeClass('d-block');
			$('#' + namespace + 'displayHTMLEditor_' + ind).addClass('d-none');
			
			$('#' + namespace + 'dataProviderRow_' + ind).removeClass('show');
			$('#' + namespace + 'dataProviderRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'staticValuesRow_' + ind).removeClass('show');
			$('#' + namespace + 'staticValuesRow_' + ind).addClass('hide');
			
			$('#' + namespace + 'dependentFieldsRow_' + ind).removeClass('show');
			$('#' + namespace + 'dependentFieldsRow_' + ind).addClass('hide');
		};
		
		updateFormFieldRowAttrs = function(){
			 $('.form-field-row').each(function(index, obj){
				 var counter;
					counter = index + 1;
					if(counter > 1){
						initRangeInputTags(counter);
						$(this).attr('id', 'formFieldConfigRow_' + counter);
						$(this).find('.field-label').attr('for', namespace + 'fieldLabel_' + counter);
						$(this).find('.field-label').attr('for', namespace + 'fieldLabel_' + counter);
						$(this).find('.field-label-input-el').attr('id', namespace + 'fieldLabel_' + counter);
						$(this).find('.field-label-input-el').attr('name', namespace + 'fieldLabel_' + counter);
						
						$(this).find('.field-key-label').attr('for', namespace + 'fieldKey_' + counter);
						$(this).find('.field-key-input-el').attr('id', namespace + 'fieldKey_' + counter);
						$(this).find('.field-key-input-el').attr('name', namespace + 'fieldKey_' + counter);
						
						$(this).find('.add-row-btn-el').attr('id', namespace + 'addFormFieldRow_' + counter);
						$(this).find('.delete-row-btn-el').attr('id', namespace + 'deleteFormFieldRow_' + counter);
						
						$(this).find('.field-type-label').attr('for', namespace + 'fieldType_' + counter);
						$(this).find('.field-type-dropdown-el').attr('id', namespace + 'fieldType_' + counter);
						$(this).find('.field-type-dropdown-el').attr('name', namespace + 'fieldType_' + counter);		
						
						$(this).find('.placeholder-div-el').attr('id', namespace + 'displayPlaceholder_' + counter);
						$(this).find('.placeholder-label').attr('for', namespace + 'placeholder_' + counter);
						$(this).find('.placeholder-textarea-el').attr('id', namespace + 'placeholder_' + counter);
						$(this).find('.placeholder-textarea-el').attr('name', namespace + 'placeholder_' + counter);
						
						$(this).find('.format-placeholder-div-el').attr('id', namespace + 'displayFormatPlaceholder_' + counter);
						$(this).find('.format-placeholder-label').attr('for', namespace + 'formatPlaceholder_' + counter);
						$(this).find('.format-placeholder-dropdown-el').attr('id', namespace + 'formatPlaceholder_' + counter);
						$(this).find('.format-placeholder-dropdown-el').attr('name', namespace + 'formatPlaceholder_' + counter);
						
						$(this).find('.html-editor-placeholder-div-el').attr('id', namespace + 'displayHTMLEditor_' + counter);
						$(this).find('.html-editor-label').attr('for', namespace + 'htmlEditor_' + counter);
						$(this).find('.html-editor-el').attr('id', namespace + 'htmlEditor_' + counter);
						$(this).find('.html-editor-el').attr('name', namespace + 'htmlEditor_' + counter);
						
						$(this).find('.min-number-placeholder-div-el').attr('id', namespace + 'displayMinNumberPlaceholder_' + counter);
						$(this).find('.min-number-placholder-label').attr('for', namespace + 'minNumberPlaceholder_' + counter);
						$(this).find('.min-number-placholder-input-el').attr('id', namespace + 'minNumberPlaceholder_' + counter);
						$(this).find('.min-number-placholder-input-el').attr('name', namespace + 'minNumberPlaceholder_' + counter);
						
						$(this).find('.max-number-placeholder-div-el').attr('id', namespace + 'displayMaxNumberPlaceholder_' + counter);
						$(this).find('.max-number-placholder-label').attr('for', namespace + 'maxNumberPlaceholder_' + counter);
						$(this).find('.max-number-placholder-input-el').attr('id', namespace + 'maxNumberPlaceholder_' + counter);
						$(this).find('.max-number-placholder-input-el').attr('name', namespace + 'maxNumberPlaceholder_' + counter);
						
						$(this).find('.multiple-file-upload-div-el').attr('id', namespace + 'displayMultipleFileUpload_' + counter);
						$(this).find('.multiple-file-upload-label').attr('for', namespace + 'multipleFileUpload_' + counter);
						$(this).find('.multiple-file-upload-checkbox-el').attr('id', namespace + 'multipleFileUpload_' + counter);
						$(this).find('.multiple-file-upload-checkbox-el').attr('name', namespace + 'multipleFileUpload_' + counter);
						
						$(this).find('.file-extensions-input-tag-div-el').attr('id', namespace + 'displayFileExtensionsInputTag_' + counter);
						$(this).find('.file-extensions-input-tag-label').attr('for', namespace + 'fileExtensionsInputTag_' + counter);
						$(this).find('.file-extensions-input-tag-el').attr('id', namespace + 'fileExtensionsInputTag_' + counter);
						$(this).find('.file-extensions-input-tag-el').attr('name', namespace + 'fileExtensionsInputTag_' + counter);
						
						$(this).find('.group-order-div-el').attr('id', namespace + 'displayGroupOrder_' + counter);
						$(this).find('.group-order-label').attr('for', namespace + 'groupOrder_' + counter);
						$(this).find('.group-order-el').attr('id', namespace + 'groupOrder_' + counter);
						$(this).find('.group-order-el').attr('name', namespace + 'groupOrder_' + counter);
						
						$(this).find('.group-div-el').attr('id', namespace + 'displayGroup_' + counter);
						$(this).find('.group-label').attr('for', namespace + 'group_' + counter);
						$(this).find('.group-el').attr('id', namespace + 'group_' + counter);
						$(this).find('.group-el').attr('name', namespace + 'group_' + counter);
						
						$(this).find('.average-div-el').attr('id', namespace + 'displayAverage_' + counter);
						$(this).find('.group-average-label').attr('for', namespace + 'groupAverage_' + counter);
						$(this).find('.group-average-checkbox-el').attr('id', namespace + 'groupAverage_' + counter);
						$(this).find('.group-average-checkbox-el').attr('name', namespace + 'groupAverage_' + counter);
						
						$(this).find('.over-all-average-label').attr('for', namespace + 'overAllAverage_' + counter);
						$(this).find('.over-all-average-checkbox-el').attr('id', namespace + 'overAllAverage_' + counter);
						$(this).find('.over-all-average-checkbox-el').attr('name', namespace + 'overAllAverage_' + counter);
						
						$(this).find('.min-boundary-div-el').attr('id', namespace + 'displayMinBoundary_' + counter);
						$(this).find('.min-boundary-label').attr('for', namespace + 'minBoundary_' + counter);
						$(this).find('.min-boundary-el').attr('id', namespace + 'minBoundary_' + counter);
						$(this).find('.min-boundary-el').attr('name', namespace + 'minBoundary_' + counter);
						
						$(this).find('.max-boundary-div-el').attr('id', namespace + 'displayMaxBoundary_' + counter);
						$(this).find('.max-boundary-label').attr('for', namespace + 'maxBoundary_' + counter);
						$(this).find('.max-boundary-el').attr('id', namespace + 'maxBoundary_' + counter);
						$(this).find('.max-boundary-el').attr('name', namespace + 'maxBoundary_' + counter);
						
						$(this).find('.range-options-div-el').attr('id', namespace + 'displayRangeOptions_' + counter);
						$(this).find('.range-options-label').attr('for', namespace + 'rangeOptions_' + counter);
						$(this).find('.range-options-el').attr('id', namespace + 'rangeOptions_' + counter);
						$(this).find('.range-options-el').attr('name', namespace + 'rangeOptions_' + counter);
						
						$(this).find('.range-options-config-row').attr('id', namespace + 'rangeOptionsConfigRow_' + counter);
						$(this).find('.range-options-config-div-el').attr('id', namespace + 'displayRangeOptionsConfig_' + counter);
						$(this).find('.range-options-config-table').attr('id', namespace + 'rangOptionsConfigTable_' + counter);
						$(this).find('.range-options-config-tbody').attr('id', namespace + 'rangeOptionsConfigTbody_' + counter);
						
						$(this).find('.values-input-tag-div-el').attr('id', namespace + 'displayValuesInputTag_' + counter);
						$(this).find('.values-input-tag-label').attr('for', namespace + 'valuesInputTag_' + counter);
						$(this).find('.values-input-tag-el').attr('id', namespace + 'valuesInputTag_' + counter);
						$(this).find('.values-input-tag-el').attr('name', namespace + 'valuesInputTag_' + counter);
						
						$(this).find('.default-selected-div-el').attr('id', namespace + 'displayDefaultSelected_' + counter);
						$(this).find('.default-selected-label').attr('for', namespace + 'defaultSelected_' + counter);
						$(this).find('.default-selected-dropdown-el').attr('id', namespace + 'defaultSelected_' + counter);
						$(this).find('.default-selected-dropdown-el').attr('name', namespace + 'defaultSelected_' + counter);
						$(this).find('.default-selected-dropdown-el').attr('data-select2-id', namespace + 'defaultSelected_' + counter);
						
						$(this).find('.dropdown-config-checkbox-div-el').attr('id', namespace + 'displayDropdownConfigCheckbox_' + counter);
						$(this).find('.multiselect-dropdown-checkbox-label').attr('for', namespace + 'multiselectDropdownCheckbox_' + counter);
						$(this).find('.multiselect-dropdown-checkbox-el').attr('id', namespace + 'multiselectDropdownCheckbox_' + counter);
						$(this).find('.multiselect-dropdown-checkbox-el').attr('name', namespace + 'multiselectDropdownCheckbox_' + counter);
						
						$(this).find('.searchable-dropdown-checkbox-label').attr('for', namespace + 'searchableDropdownCheckbox_' + counter);
						$(this).find('.searchable-dropdown-checkbox-el').attr('id', namespace + 'searchableDropdownCheckbox_' + counter);
						$(this).find('.searchable-dropdown-checkbox-el').attr('name', namespace + 'searchableDropdownCheckbox_' + counter);
						
						$(this).find('.where-to-populate-dropdown-div-el').attr('id', namespace + 'displayWhereToPopulateDropdown_' + counter);
						$(this).find('.where-to-populate-dropdown-label').attr('for', namespace + 'whereToPopulateDropdown_' + counter);
						$(this).find('.where-to-populate-dropdown-el').attr('id', namespace + 'whereToPopulateDropdown_' + counter);
						$(this).find('.where-to-populate-dropdown-el').attr('name', namespace + 'whereToPopulateDropdown_' + counter);
						
						$(this).find('.static-values-row').attr('id', namespace + 'staticValuesRow_' + counter);
						$(this).find('.static-values-input-tag-div-el').attr('id', namespace + 'displayStaticValuesInputTag_' + counter);
						$(this).find('.static-values-input-tag-label').attr('for', namespace + 'staticValuesInputTag_' + counter);
						$(this).find('.static-values-input-tag-el').attr('id', namespace + 'staticValuesInputTag_' + counter);
						$(this).find('.static-values-input-tag-el').attr('name', namespace + 'staticValuesInputTag_' + counter);
						
						$(this).find('.dependent-fields-row').attr('id', namespace + 'dependentFieldsRow_' + counter);
						$(this).find('.dependent-fields-name-dropdown-div-el').attr('id', namespace + 'displayDependentFieldsNameDropdown_' + counter);
						$(this).find('.dependent-fields-name-label').attr('for', namespace + 'dependentFieldsName_' + counter);
						$(this).find('.dependent-fields-name-dropdown-el').attr('id', namespace + 'dependentFieldsName_' + counter);
						$(this).find('.dependent-fields-name-dropdown-el').attr('name', namespace + 'dependentFieldsName_' + counter);
						
						$(this).find('.where-to-populate-dependent-fields-div-el').attr('id', namespace + 'displayWhereToPopulateDependentFields_' + counter);
						$(this).find('.where-to-populate-dependent-fields-label').attr('for', namespace + 'whereToPopulateDependentFields_' + counter);
						$(this).find('.where-to-populate-dependent-fields-el').attr('id', namespace + 'whereToPopulateDependentFields_' + counter);
						$(this).find('.where-to-populate-dependent-fields-el').attr('name', namespace + 'whereToPopulateDependentFields_' + counter);
						
						$(this).find('.data-provider-row').attr('id', namespace + 'dataProviderRow_' + counter);
						$(this).find('.data-provider-url-div-el').attr('id', namespace + 'displayDataProviderURL_' + counter);
						$(this).find('.data-provider-url-label').attr('for', namespace + 'dataProviderURL_' + counter);
						$(this).find('.data-provider-url-el').attr('id', namespace + 'dataProviderURL_' + counter);
						$(this).find('.data-provider-url-el').attr('name', namespace + 'dataProviderURL_' + counter);
						
						$(this).find('.method-types-div-el').attr('id', namespace + 'displayMethodTypes_' + counter);
						$(this).find('.method-types-label').attr('for', namespace + 'methodTypes_' + counter);
						$(this).find('.method-types-dropdown-el').attr('id', namespace + 'methodTypes_' + counter);
						$(this).find('.method-types-dropdown-el').attr('name', namespace + 'methodTypes_' + counter);
						
						$(this).find('.content-types-div-el').attr('id', namespace + 'displayContentTypes_' + counter);
						$(this).find('.content-types-label').attr('for', namespace + 'contentTypes_' + counter);
						$(this).find('.content-types-dropdown-el').attr('id', namespace + 'contentTypes_' + counter);
						$(this).find('.content-types-dropdown-el').attr('name', namespace + 'contentTypes_' + counter);
						
						$(this).find('.data-provider-url-property-div-el').attr('id', namespace + 'displayDataProviderURLProperty_' + counter);
						$(this).find('.data-provider-url-property-label').attr('for', namespace + 'dataProviderURLProperty_' + counter);
						$(this).find('.data-provider-url-property-el').attr('id', namespace + 'dataProviderURLProperty_' + counter);
						$(this).find('.data-provider-url-property-el').attr('name', namespace + 'dataProviderURLProperty_' + counter);
						
						$(this).find('.data-props-div-el').attr('id', namespace + 'displayDataProps_' + counter);
						$(this).find('.data-props-label').attr('for', namespace + 'dataProps_' + counter);
						$(this).find('.data-props-el').attr('id', namespace + 'dataProps_' + counter);
						$(this).find('.data-props-el').attr('name', namespace + 'dataProps_' + counter);
						
						$(this).find('.field-data-type-label').attr('for', namespace + 'fieldDataType_' + counter);
						$(this).find('.field-data-type-dropdown-el').attr('id', namespace + 'fieldDataType_' + counter);
						$(this).find('.field-data-type-dropdown-el').attr('name', namespace + 'fieldDataType_' + counter);
						
						$(this).find('.field-status-label').attr('for', namespace + 'fieldStatus_' + counter);
						$(this).find('.field-status-dropdown-el').attr('id', namespace + 'fieldStatus_' + counter);
						$(this).find('.field-status-dropdown-el').attr('name', namespace + 'fieldStatus_' + counter);
						
						$(this).find('.field-read-only-label').attr('for', namespace + 'fieldReadonly_' + counter);
						$(this).find('.field-read-only-checkbox-el').attr('id', namespace + 'fieldReadonly_' + counter);
						$(this).find('.field-read-only-checkbox-el').attr('name', namespace + 'fieldReadonly_' + counter);
						
						$(this).find('.field-disable-label').attr('for', namespace + 'fieldDisable_' + counter);
						$(this).find('.field-disable-checkbox-el').attr('id', namespace + 'fieldDisable_' + counter);
						$(this).find('.field-disable-checkbox-el').attr('name', namespace + 'fieldDisable_' + counter);
						
						$(this).find('.field-required-label').attr('for', namespace + 'fieldRequired_' + counter);
						$(this).find('.field-required-checkbox-el').attr('id', namespace + 'fieldRequired_' + counter);
						$(this).find('.field-required-checkbox-el').attr('name', namespace + 'fieldRequired_' + counter);
						
						$(this).find('.post-data-div-el').attr('id', namespace + 'togglePostDataField_' + counter);
						$(this).find('.populate-data-div-el').attr('id', namespace + 'togglePopulateDataField_' + counter);
						$(this).find('.read-from-req-param-field-div-el').attr('id', namespace + 'toggleReadFromReqParamField_' + counter);
						
						$(this).find('.post-data-label').attr('for', namespace + 'postData_' + counter);
						$(this).find('.post-data-checkbox-el').attr('id', namespace + 'postData_' + counter);
						$(this).find('.post-data-checkbox-el').attr('name', namespace + 'postData_' + counter);
						$(this).find('.post-data-checkbox-el').attr('data-sub-field-wrraper', namespace + 'togglePostDataField_' + counter);
						
						$(this).find('.post-data-field-label').attr('for', namespace + 'postDataName_' + counter);
						$(this).find('.post-data-field-input-el').attr('id', namespace + 'postDataName_' + counter);
						$(this).find('.post-data-field-input-el').attr('name', namespace + 'postDataName_' + counter);
						
						$(this).find('.populate-data-label').attr('for', namespace + 'populateData_' + counter);
						$(this).find('.populate-data-checkbox-el').attr('id', namespace + 'populateData_' + counter);
						$(this).find('.populate-data-checkbox-el').attr('name', namespace + 'populateData_' + counter);
						$(this).find('.populate-data-checkbox-el').attr('data-sub-field-wrraper', namespace + 'togglePopulateDataField_' + counter);
						
						$(this).find('.populate-data-field-label').attr('for', namespace + 'populateDataName_' + counter);
						$(this).find('.populate-data-field-input-el').attr('id', namespace + 'populateDataName_' + counter);
						$(this).find('.populate-data-field-input-el').attr('name', namespace + 'populateDataName_' + counter);
						
						$(this).find('.read-from-req-param-label').attr('for', namespace + 'readFromReqParam_' + counter);
						$(this).find('.read-from-req-param-checkbox-el').attr('id', namespace + 'readFromReqParam_' + counter);
						$(this).find('.read-from-req-param-checkbox-el').attr('name', namespace + 'readFromReqParam_' + counter);
						$(this).find('.read-from-req-param-checkbox-el').attr('data-sub-field-wrraper', namespace + 'toggleReadFromReqParamField_' + counter);
						
						$(this).find('.read-from-req-param-name-label').attr('for', namespace + 'readFromReqParamName_' + counter);
						$(this).find('.read-from-req-param-name-input-el').attr('id', namespace + 'readFromReqParamName_' + counter);
						$(this).find('.read-from-req-param-name-input-el').attr('name', namespace + 'readFromReqParamName_' + counter);
						
						$(this).find('.accordion').attr('id', namespace + 'formFieldConfigRowSettingsAccordian_' + counter);
						
						$(this).find('.card-header').attr('id', namespace + 'formFieldConfigRowSettingsAccordian_' + counter + 'Header');
						
						$(this).find('.anchor-settings-accordian').attr('data-target','#' + namespace + 'formFieldConfigRowSettingsAccordian_' + counter + 'Body');
						$(this).find('.anchor-settings-accordian').attr('aria-controls', namespace + 'formFieldConfigRowSettingsAccordian_' + counter + 'Body');
						
						$(this).find('.card-body-accordian-settings').attr('id', namespace + 'formFieldConfigRowSettingsAccordian_' + counter + 'Body');
						$(this).find('.card-body-accordian-settings').attr('aria-labelledby', namespace + 'formFieldConfigRowSettingsAccordian_' + counter + 'Header');
						$(this).find('.card-body-accordian-settings').attr('data-parent','#' + namespace + 'formFieldConfigRowSettingsAccordian_' + counter);
						
						$(this).find('.card-body-settings-div-el').attr('id', namespace + 'formFieldConfigRowSettingsAccordian_' + counter + 'CardBody');
						
						$(this).find('.add-row-btn-el').attr('onclick', 'addFormFieldRow(this, '+ counter +');');
						$(this).find('.delete-row-btn-el').attr('onclick', 'deleteFormFieldRow(this, '+ counter +');');
						$(this).find('.field-type-dropdown-el').attr('onchange', 'selectedFieldSettingType(this,'+ counter +');');
						$(this).find('.post-data-checkbox-el').attr('onchange', 'showDataField(this, '+ counter +');');
						$(this).find('.populate-data-checkbox-el').attr('onchange', 'showDataField(this, '+ counter +');');
						$(this).find('.read-from-req-param-checkbox-el').attr('onchange', 'showDataField(this, '+ counter +');');
						$(this).find('.where-to-populate-dropdown-el').attr('onchange', 'whereToPopulateSelectedDropdownValue(this,'+ counter +');');
						$(this).find('.field-label-input-el').attr('onchange', 'addFieldKey(this,'+ counter +');');
						$(this).find('.where-to-populate-dependent-fields-el').attr('onchange', 'whereToPopulateDependentFields(this,'+ counter +');');
						$(this).find('.min-boundary-el').attr('onchange', 'populateRangeOptionsConfig(this,'+ counter +');');
						$(this).find('.max-boundary-el').attr('onchange', 'populateRangeOptionsConfig(this,'+ counter +');');
					} 
			 });
		};
		initRadioAndCheckboxInputTags = function(ind) {
			if($('#' + namespace + 'displayValuesInputTag_' + ind).find("tags").length <= 0) {
				var inputTags, eventTarget;
				inputTags = $('#' + namespace + 'valuesInputTag_' + ind).tagify({
					hooks: {
					    beforeRemoveTag: function(tags) {
					        return new Promise((resolve, reject) => {
					            confirm("Are you sure you want to remove " + tags[0].data.value + " tag ?") ?
					                resolve() :
					                reject()
					        })
					    }
					}
				});
				inputTags.on('change',function(e){
					//console.log(e);
					populateDefaultSelectedDropdown(e);
					eventTarget = e;
				});
			}
		};
		
		populateDefaultSelectedDropdown = function(e){
			var defaultSelectedDropdownEl, tagValues, inputTagsArr;
			defaultSelectedDropdownEl ='#' + $(e.currentTarget).closest('.form-field-row-div-el').find('.default-selected-dropdown-el').attr('id');
			var defaultSelectedVal = $(defaultSelectedDropdownEl).val();
			$(defaultSelectedDropdownEl).find('.default-selected-option').remove();
			tagValues = e.currentTarget.tagifyValue;
			if(tagValues) {
				tagValues = JSON.parse(tagValues);
				for (const key of tagValues) {
				    $(defaultSelectedDropdownEl).append($('<option>', {
				        value: key.value,
				        text: key.value,
				        class : 'default-selected-option',
				    }));
				}
				$(defaultSelectedDropdownEl).val(defaultSelectedVal).trigger('change');
			}
		};
		
		initDefaultSelectedDropdown = function(ind, select2ExtraConfig) {
			var select2DefaultConfig, select2Config, selectedOption;
				select2DefaultConfig = {
					placeholder : "--Select--",
					templateResult: templateResult,
				    templateSelection: templateSelection
				};
				select2Config = $.extend({}, select2DefaultConfig, select2ExtraConfig);
				multiselectDropdown = $('#' + namespace + 'defaultSelected_' + ind).select2(select2Config);
		};
		
		templateSelection = function(state) {
		    return state.text;   
		};
		
		templateResult = function(state) {
		    console.log('state:', state);
		    if (!state.id) return state.text; // optgroup
		    var id = 'state' + state.id.toLowerCase();
		    var label = $('<label>', { for: id });
		    var labelSpan = $('<span>', {text : state.text});
		    var checkbox = $('<input>', {'type' : 'checkbox', 'id' : id});
		    $(label).append(checkbox);
		    $(label).append(labelSpan);
		    return label;   
		};
		
		initInputTags = function(ind, inputTagDivId, inputTagId) {
			var inputTags;
			if($(inputTagDivId).find("tags").length <= 0) {
				inputTags = $(inputTagId).tagify({
					duplicates : false,
					hooks: {
					    beforeRemoveTag: function(tags) {
					        return new Promise((resolve, reject) => {
					            confirm("Are you sure you want to remove " + tags[0].data.value + " tag ?") ?
					                resolve() :
					                reject()
					        })
					    }
					}
				});
			}
			return inputTags;
		};
		
		addFieldKey = function(curFieldLabel, ind){
			var fieldLable, fieldKey, labelFirstChar, labelSubString;
			fieldLable = $(curFieldLabel).val();
			fieldLabel = fieldLable.toLowerCase();
			fieldKey=fieldLabel.replace(" ","_");
			populateFieldKey(fieldKey, ind);
			//populateDependentFieldsName(fieldLable, fieldKey, ind)
		};
		
		
		
		populateFieldKey = function(fieldKey, ind){
			$('#' + namespace +'fieldKey_' + ind).val(fieldKey);
		};
		
		addFormFieldRow = function(curRow,ind){
			var formFieldsRowLen, nextCounter, formFieldSectionRow;
			formFieldsRowLen = $('.form-field-row').length;
			nextCounter = formFieldsRowLen + 1;
			formFieldSectionRow = createFormFieldSectionRow(nextCounter);
			$(formFieldsAccordianCardBodyJEl).append(formFieldSectionRow);
			updateFormFieldRowAttrs();
		};
		
		deleteFormFieldRow = function(curRow,ind){
			if(ind > 1){
				$('#formFieldConfigRow_'+ind).remove();
				updateFormFieldRowAttrs();
				
			}
		};
		
		showDataField = function(curDataField, ind){
			var isChecked, checkBoxSubFieldEl;
			isChecked = $(curDataField).is(':checked');
			checkBoxSubFieldEl = $(curDataField).data('sub-field-wrraper');

			if(isChecked){
				$('#' + checkBoxSubFieldEl).removeClass('d-none');
				$('#' + checkBoxSubFieldEl).addClass('d-block');
			}else{
				$('#' + checkBoxSubFieldEl).removeClass('d-block');
				$('#' + checkBoxSubFieldEl).addClass('d-none');
			}
			//showFooterRow();
			showPostDataField();
			showPrepopulateDataField();
		};
		
		showFooterRow = function(){
			isCheckedPostData = $('.post-data-checkbox-el').is(':checked');
			isCheckedPrepopulateData = $('.populate-data-checkbox-el').is(':checked');
			if(isCheckedPostData || isCheckedPrepopulateData){
				$('.footer-row').addClass('show');
				$('.footer-row').removeClass('hide');
			}else{
				$('.footer-row').addClass('hide');
				$('.footer-row').removeClass('show');
			}
		}; 
		
		showPostDataField = function() {
			isChecked = $('.post-data-checkbox-el').is(':checked');
			console.log("showPostDataField",isChecked)
			showFooterRow();
			if(isChecked){
				$('.post-data-url-div').removeClass('d-none');
				$('.post-data-url-div').addClass('d-block');
				
				$('.post-data-content-type-div').removeClass('d-none');
				$('.post-data-content-type-div').addClass('d-block');
			}else{
				$('.post-data-url-div').removeClass('d-block');
				$('.post-data-url-div').addClass('d-none');
				
				$('.post-data-content-type-div').removeClass('d-block');
				$('.post-data-content-type-div').addClass('d-none');
			}
		};
		
		showPrepopulateDataField = function() {
			isChecked = $('.populate-data-checkbox-el').is(':checked');
			console.log("showPrepopulateDataField", isChecked);
			showFooterRow();
			if(isChecked){
				//showFooterRow();
				$('.prepopulate-data-url-div').removeClass('d-none');
				$('.prepopulate-data-url-div').addClass('d-block');
				
				$('.prepopulate-data-content-type-div').removeClass('d-none');
				$('.prepopulate-data-content-type-div').addClass('d-block');
			}else{
				$('.prepopulate-data-url-div').removeClass('d-block');
				$('.prepopulate-data-url-div').addClass('d-none');
				
				$('.prepopulate-data-content-type-div').removeClass('d-block');
				$('.prepopulate-data-content-type-div').addClass('d-none');
				//hideFooterRow();
			}
		};
		
		createFormBasicSection = function(){
			var mainFormRowEl, mainFormColEl, formNameAndTitleRowEl, formNameColEl, formNameFieldSectionEl, 
				formTitleColEl, formTitleFieldSectionEl, formLayoutEl, formDescriptionRowEl, formDescriptionColEl,
				formDescriptionFieldSectionEl;
			
			mainFormRowEl = commonFc.createDivEl('row');
			mainFormColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			
			formNameAndTitleRowEl = commonFc.createDivEl('row');
			formNameColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formNameFieldSectionEl = createFormNameField();
			formTitleColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formTitleFieldSectionEl = createFormTitleField();
			
			formLayoutEl = createFormLayoutField();
			
			formDescriptionRowEl = commonFc.createDivEl('row');
			formDescriptionColEl = commonFc.createDivEl('col-lg-8 col-md-8 col-sm-12 col-xs-12');
			formDescriptionFieldSectionEl = createFormDescriptionField();
			
			$(formNameColEl).append(formNameFieldSectionEl);
			$(formNameAndTitleRowEl).append(formNameColEl);
			$(formTitleColEl).append(formTitleFieldSectionEl);
			$(formNameAndTitleRowEl).append(formTitleColEl);
			$(mainFormColEl).append(formNameAndTitleRowEl);
			
			$(mainFormColEl).append(formLayoutEl);
			
			$(formDescriptionColEl).append(formDescriptionFieldSectionEl);
			$(formDescriptionRowEl).append(formDescriptionColEl);
			$(mainFormColEl).append(formDescriptionRowEl);
			
			$(mainFormRowEl).append(mainFormColEl);
			$(formCardBodyJEL).append(mainFormRowEl);
			
		};
		
		createFormNameField = function(){ 
			 var formNameLabelEl, formNameInputEl, formGroupDivEl
			 formNameLabelEl = commonFc.createLabel('formName','Form Name');
			 formNameInputEl = commonFc.createInputTextEl('form-control', 'formName');
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(formGroupDivEl).append(formNameLabelEl);
			 $(formGroupDivEl).append(formNameInputEl);
					 
			 return formGroupDivEl; 
		}
		
		createFormTitleField = function(){
			 var formTitleLabelEl, formTitleInputEl, formGroupDivEl;
			 formTitleLabelEl = commonFc.createLabel('formTitle', 'Form Title');
			 formTitleInputEl = commonFc.createInputTextEl('form-control', 'formTitle');
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(formGroupDivEl).append(formTitleLabelEl);
			 $(formGroupDivEl).append(formTitleInputEl);
			 
			 return formGroupDivEl;
		}
		
		createFormLayoutField = function(){
			var formLayoutRowEl, col1FormLayoutEl, col1FormLayoutSectionEl, col2FormLayoutEl, col2FormLayoutSectionEl, col3FormLayoutEl, col3FormLayoutSectionEl,
			col4FormLayoutEl, col4FormLayoutSectionEl;
			
			formLayoutRowEl = commonFc.createDivEl('row form-layout-row');
			
			col1FormLayoutEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			col1FormLayoutSectionEl = createCol1FormLayoutField();
			
			col2FormLayoutEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			col2FormLayoutSectionEl = createCol2FormLayoutField();
			
			col3FormLayoutEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			col3FormLayoutSectionEl = createCol3FormLayoutField();
			
			col4FormLayoutEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			col4FormLayoutSectionEl = createCol4FormLayoutField();
			
			$(col1FormLayoutEl).append(col1FormLayoutSectionEl);
			$(formLayoutRowEl).append(col1FormLayoutEl);
			
			$(col2FormLayoutEl).append(col2FormLayoutSectionEl);
			$(formLayoutRowEl).append(col2FormLayoutEl);
			
			$(col3FormLayoutEl).append(col3FormLayoutSectionEl);
			$(formLayoutRowEl).append(col3FormLayoutEl);
			
			$(col4FormLayoutEl).append(col4FormLayoutSectionEl);
			$(formLayoutRowEl).append(col4FormLayoutEl);
			
			return formLayoutRowEl;
		};
		
		createCol1FormLayoutField = function(){
			var col1FormLayoutRadioEl;
			col1FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col1FormLayout', 'form-check-input', 'col1FormLayout', 'formLayout', '1 Columns');
			return col1FormLayoutRadioEl;
		};
		
		createCol2FormLayoutField = function(){
			var col2FormLayoutRadioEl;
			col2FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col2FormLayout', 'form-check-input', 'col2FormLayout', 'formLayout', '2 Columns');
			return col2FormLayoutRadioEl;
		};
		
		createCol3FormLayoutField = function(){
			var col3FormLayoutRadioEl;
			col3FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col3FormLayout', 'form-check-input', 'col3FormLayout', 'formLayout', '3 Columns');
			return col3FormLayoutRadioEl;
		};
		
		createCol4FormLayoutField = function(){
			var col4FormLayoutRadioEl;
			col4FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col4FormLayout', 'form-check-input', 'col4FormLayout', 'formLayout', '4 Columns');
			return col4FormLayoutRadioEl;
		};
		
		createFormDescriptionField = function(){
			var formDescriptionLabelEl, formDescriptionTextEditorEl, formGroupDivEl;
			formDescriptionLabelEl = commonFc.createLabel('formDescription','Form Description');
			formDescriptionTextEditorEl = commonFc.createTextEditorEl('formTextEditor','formDescription');
			formGroupDivEl = commonFc.createDivEl('form-group');
			 
			$(formGroupDivEl).append(formDescriptionLabelEl);
			$(formGroupDivEl).append(formDescriptionTextEditorEl);
			commonFc.initTextEditor(formDescriptionTextEditorEl);
			return formGroupDivEl;
		}
		createFormFieldConfigRows = function(){
			createFormFieldsSection();
		};
		createFormFieldsSection = function(){
			var formFieldSectionRowEl, formFieldsAccordianId, formFieldsAccordianCardBodyId; 
			
			formFieldsAccordianId = 'dfFormFieldsAccordian';
			formFieldsAccordianCardBodyId = formFieldsAccordianId + 'CardBody';
			formFieldsRowEl = commonFc.createAccordianCardEl('dfFormFieldsAccordian', 'Fields Configuration');
			formFieldsAccordianCardBodyJEl = '#' + namespace + formFieldsAccordianCardBodyId;
			formFieldSectionRowEl = createFormFieldSectionRow(1);
			$(formCardBodyJEL).append(formFieldsRowEl);
			$(formFieldsAccordianCardBodyJEl).append(formFieldSectionRowEl);
		};
		createFormFieldSectionRow = function(ind){
			var formFieldRowEl, formFieldColEl, formFieldSettingsRowEl, formFieldLabelColEl, formFieldKeyColEl, formFieldLabelSectionEl, formFieldKeySectionEl,
				formFieldButtonColEl, formFieldButtonSectionEl; 
			
			formFieldRowEl = commonFc.createDivEl('row form-field-row pt-1 mb-3 form-field-row-div-el border-bottom','formFieldConfigRow_' + ind);
			formFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			
			formFieldSubRowEl = commonFc.createDivEl('row');
			formFieldLabelColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formFieldLabelSectionEl = createFormFieldLabel(ind);
			
			formFieldKeyColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formFieldKeySectionEl = createFormFieldKey(ind);
			
			formFieldButtonColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formFieldButtonSectionEl = createCloneButtons(ind);
			
			$(formFieldLabelColEl).append(formFieldLabelSectionEl);
			$(formFieldSubRowEl).append(formFieldLabelColEl);
			
			$(formFieldKeyColEl).append(formFieldKeySectionEl);
			$(formFieldSubRowEl).append(formFieldKeyColEl);
			
			$(formFieldButtonColEl).append(formFieldButtonSectionEl);
			$(formFieldSubRowEl).append(formFieldButtonColEl);
			
			formFieldSettingsRowEl = createFieldSettingSection(ind);
			
			$(formFieldColEl).append(formFieldSubRowEl);
			$(formFieldColEl).append(formFieldSettingsRowEl);
			
			$(formFieldRowEl).append(formFieldColEl);
			
			return formFieldRowEl;
		};
		
		createFormFieldLabel = function(ind){
			var formFieldLabelEl, formFieldLabelInputEl, formGroupDivEl, isReadOnly = false, changeEventObj = new Object({});
			formFieldLabelEl = commonFc.createLabel('fieldLabel_' + ind, 'Field Label', 'field-label field-setting-label');
			changeEventObj.fnName = 'addFieldKey(this,'+ind+');';
			formFieldLabelInputEl = commonFc.createInputTextEl('form-control field-label-input-el', 'fieldLabel_' + ind, isReadOnly, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(formFieldLabelEl);
			$(formGroupDivEl).append(formFieldLabelInputEl);
			
			return formGroupDivEl;
		};
		
		createFormFieldKey = function(ind){
			var formFieldKeyLabelEl, formFieldKeyInputEl, formGroupDivEl, isReadOnly = true;
			formFieldKeyLabelEl = commonFc.createLabel('fieldKey_' + ind, 'Field Key', 'field-key-label field-setting-label');
			formFieldKeyInputEl = commonFc.createInputTextEl('form-control field-key-input-el', 'fieldKey_' + ind, isReadOnly);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(formFieldKeyLabelEl);
			$(formGroupDivEl).append(formFieldKeyInputEl);
			
			return formGroupDivEl;
		};
		
		createCloneButtons = function(ind){
			var addButton, deleteButton, formGroupDivEl;
			
			addButton = createAddButton(ind);
			deleteButton = createDeleteButton(ind);
			formGroupDivEl = commonFc.createDivEl('form-group float-right');
			
			$(formGroupDivEl).append(addButton);
			$(formGroupDivEl).append(deleteButton);
			
			return formGroupDivEl;
		};
		
		createAddButton = function(ind){
			var addButton, addButtonIcon, changeEventObj = new Object({});
	
			changeEventObj.fnName = 'addFormFieldRow(this,'+ind+');';
			addButton = commonFc.createButtonEl('btn btn-icon btn-xs btn-primary add-row-btn-el', 'addFormFieldRow_'+ind, changeEventObj);
			addButtonIcon = commonFc.createIcon('fa fa-plus');
			
			$(addButton).append(addButtonIcon);
			
			return addButton;
		};
		
		createDeleteButton = function(ind){
			var deleteButton, deleteButtonIcon, changeEventObj = new Object({});
			changeEventObj.fnName = 'deleteFormFieldRow(this, '+ind+');';
			 
			if(ind > 1){
				deleteButton = commonFc.createButtonEl('btn btn-icon btn-xs btn-danger delete-row-btn-el ml-1', 'deleteFormFieldRow_'+ind, changeEventObj);
			}
			
			deleteButtonIcon = commonFc.createIcon('fa fa-minus');
			
			$(deleteButton).append(deleteButtonIcon);
			
			return deleteButton;
		};
		
		createFieldSettingSection = function(ind){
			var fieldSettingSectionRow, fieldSettingSubSection, fieldSettingSubSection2, staticValueFieldSettingSection, dependentFieldSettingSection, 
				dataProviderFieldSettingSection, rangeOptionsConfigSection; 
			
			fieldSettingSectionRow = commonFc.createAccordianCardEl('formFieldConfigRowSettingsAccordian_' + ind, 'Settings');
			
			fieldSettingSubSection = createFieldSettingSubSection(ind);
			fieldSettingSubSection2 = createFieldSettingSubSection2(ind);
			staticValueFieldSettingSection = createStaticValuesFieldSettingSection(ind);
			dependentFieldSettingSection = createDependentFieldSettingSection(ind);
			//dataProviderFieldSettingSection = createDataProviderFieldSettingSection(ind);
			rangeOptionsConfigSection = createRangeOptionsConfigSection(ind);
			
			$(fieldSettingSectionRow).find('.card-body').append(fieldSettingSubSection);
			$(fieldSettingSectionRow).find('.card-body').append(fieldSettingSubSection2);
			$(fieldSettingSectionRow).find('.card-body').append(staticValueFieldSettingSection);
			$(fieldSettingSectionRow).find('.card-body').append(dependentFieldSettingSection);
			//$(fieldSettingSectionRow).find('.card-body').append(dataProviderFieldSettingSection);
			$(fieldSettingSectionRow).find('.card-body').append(rangeOptionsConfigSection);
			return fieldSettingSectionRow;
		};
		
		createFieldSettingHeadSection = function(ind){
			var headRowEl, headColEl, headEl;
			
			headRowEl = commonFc.createDivEl('row');
			headColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			headEl = commonFc.createHead('h3','Settings');
			
			$(headColEl).append(headEl);
			$(headRowEl).append(headColEl);
			
			return headRowEl;
		};
		
		createFieldSettingSubSection = function(ind){
			var mainSettingRowEl, settingTypeColEl, fieldSettingTypeEl, settingDataTypeColEl, fieldSettingDataTypeEl, settingStatusColEl, fieldSettingStatusEl,
				settingReadonlyAndDisableColEl, fieldSettingReadonlyEl, fieldSettingDisableEl, settingPostDataAndRequiredPostDataColEl,
				fieldSettingRequiredEl, fieldsettingPostDataPostEl, settingPopulateDataAndReadFromReqColEl, fieldSettingPopulateDataEl,
				fieldSettingReadFromReqEl;
			
			
			mainSettingRowEl = commonFc.createDivEl('row');
			
			settingTypeColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			fieldSettingTypeEl = createFieldSettingType(ind);
			
			settingDataTypeColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			fieldSettingDataTypeEl = createFieldSettingDataType(ind);
			
			settingStatusColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			fieldSettingStatusEl = createFieldSettingStatus(ind);
			
			settingReadonlyAndDisableColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingReadonlyEl = createFieldSettingReadonly(ind);
			fieldSettingDisableEl = createFieldSettingDisable(ind);
			
			settingPostDataAndRequiredPostDataColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingRequiredEl = createFieldSettingRequired(ind);
			fieldsettingPostDataEl = createCheckboxFieldSettingPostData(ind);
			
			settingPopulateDataAndReadFromReqColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingPopulateDataEl = createCheckboxFieldSettingPopulateData(ind);
			fieldSettingReadFromReqEl = createCheckboxFieldSettingReadFromReq(ind);
			
			$(settingTypeColEl).append(fieldSettingTypeEl);
			$(mainSettingRowEl).append(settingTypeColEl);
			
			$(settingDataTypeColEl).append(fieldSettingDataTypeEl);
			$(mainSettingRowEl).append(settingDataTypeColEl);
			
			$(settingStatusColEl).append(fieldSettingStatusEl);
			$(mainSettingRowEl).append(settingStatusColEl);
			
			$(settingReadonlyAndDisableColEl).append(fieldSettingDisableEl);
			$(settingReadonlyAndDisableColEl).append(fieldSettingReadonlyEl);
			$(mainSettingRowEl).append(settingReadonlyAndDisableColEl);
			
			$(settingPostDataAndRequiredPostDataColEl).append(fieldSettingRequiredEl);
			$(settingPostDataAndRequiredPostDataColEl).append(fieldsettingPostDataEl);
			$(mainSettingRowEl).append(settingPostDataAndRequiredPostDataColEl);
			
			$(settingPopulateDataAndReadFromReqColEl).append(fieldSettingPopulateDataEl);
			$(settingPopulateDataAndReadFromReqColEl).append(fieldSettingReadFromReqEl);
			$(mainSettingRowEl).append(settingPopulateDataAndReadFromReqColEl);
	
			return mainSettingRowEl;
		};
		
		createFieldSettingType = function(ind){
			var fieldSettingTypeLabelEl, fieldSettingTypeDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			fieldSettingTypeLabelEl = commonFc.createLabel('fieldType_' + ind, 'Field Type', 'field-type-label field-setting-label');
			changeEventObj.fnName = 'selectedFieldSettingType(this,'+ind+');';
			fieldSettingTypeDropdownEl = commonFc.createDropdown('form-control field-type-dropdown-el', 'fieldType_' + ind, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingTypeLabelEl);
			$(formGroupDivEl).append(fieldSettingTypeDropdownEl);
			commonFc.populateDropdown(settingTypes, fieldSettingTypeDropdownEl);
			return formGroupDivEl;
		};
		
		createFieldSettingDataType = function(ind){
			var fieldSettingDataTypeLabelEl, fieldSettingDataTypeDropdownEl, formGroupDivEl;
			fieldSettingDataTypeLabelEl = commonFc.createLabel('fieldDataType_'+ind, 'Field Data Type', 'field-data-type-label field-setting-label');
			fieldSettingDataTypeDropdownEl = commonFc.createDropdown('form-control field-data-type-dropdown-el', 'fieldDataType_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingDataTypeLabelEl);
			$(formGroupDivEl).append(fieldSettingDataTypeDropdownEl);
			
			return formGroupDivEl;
		};
		
		createFieldSettingPlaceholder = function(ind){
			var fieldSettingPlaceholderLabelEl, fieldSettingPlaceholderInputEl, formGroupDivEl;
			fieldSettingPlaceholderLabelEl = commonFc.createLabel('placeholder_' + ind,'Placeholder', 'placeholder-label field-setting-label');
			fieldSettingPlaceholderInputEl = commonFc.createTextAreaEl('form-control placeholder-textarea-el', 'placeholder_' + ind, 2);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(fieldSettingPlaceholderInputEl);

			return formGroupDivEl;
		};
		
		createHTMLEditorPlaceholder = function(ind){
			var htmlEditorLabelEl, htmlEditorEl, formGroupDivEl;
			formDescriptionLabelEl = commonFc.createLabel('htmlEditor_'+ind,'HTML Placeholder', 'html-editor-label field-setting-label');
			formDescriptionTextEditorEl = commonFc.createTextEditorEl('html-editor-el','htmlEditor_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			 
			$(formGroupDivEl).append(formDescriptionLabelEl);
			$(formGroupDivEl).append(formDescriptionTextEditorEl);
			 
			return formGroupDivEl;
		};
		
		createFormatFieldSettingPlaceholder = function(ind){
			var formatFieldSettingPlaceholderLabelEl, formatFieldSettingPlaceholderDropdownEl, formGroupDivEl;
			formatFieldSettingPlaceholderLabelEl = commonFc.createLabel('formatPlaceholder_'+ind, 'Format', 'format-placeholder-label field-setting-label');
			formatFieldSettingPlaceholderDropdownEl = commonFc.createDropdown('form-control format-placeholder-dropdown-el', 'formatPlaceholder_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(formatFieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(formatFieldSettingPlaceholderDropdownEl);
			
			return formGroupDivEl;
		};
		
		createMinNumberFieldSettingPlaceholder = function(ind){
			var minNumberFieldSettingPlaceholderLabelEl, minNumberFieldSettingPlaceholderEl, formGroupDivEl;
			minNumberFieldSettingPlaceholderLabelEl = commonFc.createLabel('minNumberPlaceholder_'+ind, 'Min Number', 'min-number-placholder-label field-setting-label');
			minNumberFieldSettingPlaceholderEl = commonFc.createInputNumberEl('form-control min-number-placholder-input-el', 'minNumberPlaceholder_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(minNumberFieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(minNumberFieldSettingPlaceholderEl);
			return formGroupDivEl
		};
		
		createMaxNumberFieldSettingPlaceholder = function(ind){
			var maxNumberFieldSettingPlaceholderLabelEl, maxNumberFieldSettingPlaceholderEl, formGroupDivEl;
			maxNumberFieldSettingPlaceholderLabelEl = commonFc.createLabel('maxNumberPlaceholder_'+ind, 'Max Number', 'max-number-placholder-label field-setting-label');
			maxNumberFieldSettingPlaceholderEl = commonFc.createInputNumberEl('form-control max-number-placholder-input-el', 'maxNumberPlaceholder_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(maxNumberFieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(maxNumberFieldSettingPlaceholderEl);
			return formGroupDivEl
		};
		
		createFileExtensionsInputTag = function(ind){
			var fileExtensionsInputTagLabel, fileExtensionsInputTag, formGroupDivEl;
			fileExtensionsInputTagLabel = commonFc.createLabel('fileExtensionsInputTag_'+ind, 'File Extensions', 'file-extensions-input-tag-label field-setting-label');
			fileExtensionsInputTag = commonFc.createDivEl('file-extensions-input-tag-el contenteditable d-block', 'fileExtensionsInputTag_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(fileExtensionsInputTagLabel);
			$(formGroupDivEl).append(fileExtensionsInputTag);
			return formGroupDivEl;
		};
		
		createMultipleFileUploadCheckbox = function(ind){
			var multipleFileUploadCheckboxEl;
			multipleFileUploadCheckboxEl = commonFc.createInputCheckboxEl('form-check-label multiple-file-upload-label field-setting-label', 'multipleFileUpload_'+ ind, 'form-check-input multiple-file-upload-checkbox-el', 'multipleFileUpload_'+ind, 'Multiple Upload');
			return multipleFileUploadCheckboxEl;
		};
		
		createGroupOrder = function(ind){
			var groupOrderLabel, groupOrderEl, formGroupDivEl;
			groupOrderLabel = commonFc.createLabel('groupOrder_'+ind, 'Group Order', 'group-order-label field-setting-label');
			groupOrderEl = commonFc.createInputNumberEl('form-control group-order-el', 'groupOrder_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(groupOrderLabel);
			$(formGroupDivEl).append(groupOrderEl);
			return formGroupDivEl
		};
		
		createGroup = function(ind){
			var groupLabel, groupEl, formGroupDivEl;
			groupLabel = commonFc.createLabel('group_' + ind, 'Group', 'group-label field-setting-label');
			groupEl = commonFc.createTextAreaEl('form-control group-el', 'group_' + ind, 2);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(groupLabel);
			$(formGroupDivEl).append(groupEl);

			return formGroupDivEl;
		};
		
		CreateGroupAverage = function(ind){
			var groupAverageCheckboxEl;
			groupAverageCheckboxEl = commonFc.createInputCheckboxEl('form-check-label group-average-label field-setting-label', 'groupAverage_'+ ind, 'form-check-input group-average-checkbox-el', 'groupAverage_'+ind, 'Group Average');
			return groupAverageCheckboxEl;
		};
		
		createOverAllAverage = function(ind){
			var overAllAverageCheckboxEl;
			overAllAverageCheckboxEl = commonFc.createInputCheckboxEl('form-check-label over-all-average-label field-setting-label', 'overAllAverage_'+ ind, 'form-check-input over-all-average-checkbox-el', 'overAllAverage_'+ind, 'OverAll Average');
			return overAllAverageCheckboxEl;
		};
		
		createMinBoundary = function(ind){
			var minBoundaryLabel, minBoundaryEl, formGroupDivEl, changeEventObj = new Object({});
			minBoundaryLabel = commonFc.createLabel('minBoundary_'+ind, 'Min', 'min-boundary-label field-setting-label');
			changeEventObj.fnName = 'populateRangeOptionsConfig(this, '+ind+');';
			minBoundaryEl = commonFc.createInputNumberEl('form-control min-boundary-el boundary-el', 'minBoundary_'+ind, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(minBoundaryLabel);
			$(formGroupDivEl).append(minBoundaryEl);
			return formGroupDivEl
		};
		
		createMaxBoundary = function(ind){
			var maxBoundaryLabel, maxBoundaryEl, formGroupDivEl, changeEventObj = new Object({});
			maxBoundaryLabel = commonFc.createLabel('maxBoundary_'+ind, 'Max', 'max-boundary-label field-setting-label');
			changeEventObj.fnName = 'populateRangeOptionsConfig(this, '+ind+');';
			maxBoundaryEl = commonFc.createInputNumberEl('form-control max-boundary-el boundary-el', 'maxBoundary_'+ind, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(maxBoundaryLabel);
			$(formGroupDivEl).append(maxBoundaryEl);
			return formGroupDivEl
		};
		
		createRangeOptions = function(ind){
			var rangeOptionsLabel, rangeOptionsEl, formGroupDivEl;
			rangeOptionsLabel = commonFc.createLabel('rangeOptions_'+ind, 'Range Options', 'range-options-label field-setting-label');
			rangeOptionsEl = commonFc.createDivEl('range-options-el contenteditable d-block', 'rangeOptions_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(rangeOptionsLabel);
			$(formGroupDivEl).append(rangeOptionsEl);
			return formGroupDivEl;
		};
		
		createRangeOptionsConfig = function(ind){
			var tableEl, rowEl, theadEl, nameHeadEl, valueHeadEl, tbodyEl;
			tableEl = commonFc.createTableEl('table border range-options-config-table', 'rangOptionsConfigTable_'+ind);
			rowEl = commonFc.createTREl();
			theadEl = commonFc.createTheadEl('thead-dark');
			nameHeadEl = commonFc.createTHEl(false, false, 'col', 'Name');
			valueHeadEl = commonFc.createTHEl(false, false, 'col', 'Value');
			tbodyEl = commonFc.createTbodyEl('range-options-config-tbody', 'rangeOptionsConfigTbody_'+ind);
			
			$(rowEl).append(nameHeadEl);
			$(rowEl).append(valueHeadEl);
			$(theadEl).append(rowEl);
			$(tableEl).append(theadEl);
			
			$(tableEl).append(tbodyEl);
			
			return tableEl;
		} 
		
		createRangeOptionsConfigSection = function(ind){
			var rangeOptionsConfigRowEl, rangeOptionsConfigColEl, rangeOptionsConfigEl;
			
			rangeOptionsConfigRowEl = commonFc.createDivEl('row range-options-config-row hide', 'rangeOptionsConfigRow_'+ind);
			
			rangeOptionsConfigColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 range-options-config-div-el', 'displayRangeOptionsConfig_' + ind);
			rangeOptionsConfigEl = createRangeOptionsConfig(ind);
			
			$(rangeOptionsConfigColEl).append(rangeOptionsConfigEl);
			$(rangeOptionsConfigRowEl).append(rangeOptionsConfigColEl);
			
			return rangeOptionsConfigRowEl;
		};
		
		createValuesInputTag = function(ind){
			var valuesInputTagLabel, valuesInputTag, formGroupDivEl;
			valuesInputTagLabel = commonFc.createLabel('valuesInputTag_'+ind, 'Values', 'values-input-tag-label field-setting-label');
			valuesInputTag = commonFc.createDivEl('values-input-tag-el contenteditable d-block', 'valuesInputTag_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(valuesInputTagLabel);
			$(formGroupDivEl).append(valuesInputTag);
			return formGroupDivEl;
		};
		
		createDefaultSelected = function(ind){ 
			var defaultSelectedLabel, defaultSelectedDropdownEl, formGroupDivEl, changeEvent = false, isMultiselect = true;
			defaultSelectedLabel = commonFc.createLabel('defaultSelected_'+ind, 'Default Selected', 'default-selected-label d-block field-setting-label');
			defaultSelectedDropdownEl = commonFc.createDropdown('form-control default-selected-dropdown-el', 'defaultSelected_'+ind, changeEvent, isMultiselect);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(defaultSelectedLabel);
			$(formGroupDivEl).append(defaultSelectedDropdownEl);
			return formGroupDivEl;
		};
		
		createMultiselectDropdownCheckbox = function(ind){
			var multiselectDropdownCheckboxEl, formGroupDivEl;
			multiselectDropdownCheckboxEl = commonFc.createInputCheckboxEl('form-check-label multiselect-dropdown-checkbox-label field-setting-label', 'multiselectDropdownCheckbox_'+ ind ,'form-check-input multiselect-dropdown-checkbox-el', 'multiselectDropdownCheckbox_'+ ind, 'Multiselect');
			return multiselectDropdownCheckboxEl;
		};
		
		createSearchableDropdownCheckbox = function(ind){
			var searchableDropdownCheckboxEl, formGroupDivEl;
			searchableDropdownCheckboxEl = commonFc.createInputCheckboxEl('form-check-label searchable-dropdown-checkbox-label field-setting-label', 'searchableDropdownCheckbox_'+ ind ,'form-check-input searchable-dropdown-checkbox-el', 'searchableDropdownCheckbox_'+ ind, 'Searchable');
			return searchableDropdownCheckboxEl;
		};
		
		createWhereToPopulateDropdownValues = function(ind){
			var whereToPopulateDropdownLabelEl, whereToPopulateDropdownEl, formGroupDivEl,  changeEventObj = new Object({});
			whereToPopulateDropdownLabelEl = commonFc.createLabel('whereToPopulateDropdown_'+ind, 'Populate Values?', 'where-to-populate-dropdown-label field-setting-label');
			changeEventObj.fnName = 'whereToPopulateSelectedDropdownValue(this,'+ind+');';
			whereToPopulateDropdownEl = commonFc.createDropdown('form-control where-to-populate-dropdown-el', 'whereToPopulateDropdown_'+ind, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(whereToPopulateDropdownLabelEl);
			$(formGroupDivEl).append(whereToPopulateDropdownEl);
			commonFc.populateDropdown(whereToPopulateDropdownValues, whereToPopulateDropdownEl);
			return formGroupDivEl;
		};
		
		createStaticValuesInputTag = function(ind){
			var staticValuesInputTagLabel, staticValuesInputTag, formGroupDivEl;
			staticValuesInputTagLabel = commonFc.createLabel('staticValuesInputTag_'+ind, 'Static Values', 'static-values-input-tag-label field-setting-label');
			staticValuesInputTag = commonFc.createDivEl('static-values-input-tag-el contenteditable d-block', 'staticValuesInputTag_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(staticValuesInputTagLabel);
			$(formGroupDivEl).append(staticValuesInputTag);
			return formGroupDivEl;
		};
		
		createDependentFieldsName = function(ind) {
			var dependentFieldsNameLabelEl, dependentFieldsNameDropdownEl, formGroupDivEl;
			dependentFieldsNameLabelEl = commonFc.createLabel('dependentFieldsName_'+ind, 'Dependent Fields Name', 'dependent-fields-name-label field-setting-label');
			dependentFieldsNameDropdownEl = commonFc.createDropdown('form-control dependent-fields-name-dropdown-el', 'dependentFieldsName_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(dependentFieldsNameLabelEl);
			$(formGroupDivEl).append(dependentFieldsNameDropdownEl);
			
			return formGroupDivEl;
		};
		
		createWhereToPopulateDependentFields = function(ind){
			var whereToPopulateDependentFieldsLabelEl, whereToPopulateDependentFieldsDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			whereToPopulateDependentFieldsLabelEl = commonFc.createLabel('whereToPopulateDependentFields_'+ind, 'Populate Values?', 'where-to-populate-dependent-fields-label field-setting-label');
			changeEventObj.fnName = 'whereToPopulateDependentFields(this,'+ind+');';
			whereToPopulateDependentFieldsDropdownEl = commonFc.createDropdown('form-control where-to-populate-dependent-fields-el', 'whereToPopulateDependentFields_'+ind, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(whereToPopulateDependentFieldsLabelEl);
			$(formGroupDivEl).append(whereToPopulateDependentFieldsDropdownEl);
			commonFc.populateDropdown(whereToPopulateDF, whereToPopulateDependentFieldsDropdownEl);
			return formGroupDivEl;
		};
		
		createDFStaticValues = function(ind){
			var dfStaticValuesRowEl;
			
			dfStaticValuesRowEl = commonFc.createDivEl('row df-static-values-row hide', 'dfStaticValuesRow_'+ind);
			
			dfFieldValueColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 df-field-value-div-el', 'displayDFFieldValue_' + ind);
			dfFieldValueEl = createDFFieldValue(ind);
		
			dfDisplayValuesColEl =  commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 df-display-values-div-el', 'displayDFValues_' + ind);
			dfDisplayValuesEl = createDFDisplayValues(ind);
			
			$(dfFieldValueColEl).append(dfFieldValueEl);
			$(dfStaticValuesRowEl).append(dfFieldValueColEl);
			
			$(dfDisplayValuesColEl).append(dfDisplayValuesEl);
			$(dfStaticValuesRowEl).append(dfDisplayValuesColEl);
			
			return dfStaticValuesRowEl;
		};
		
		createDFFieldValue = function(ind){
			var dfFieldValueLabel , dfFieldValueInputEl, formGroupDivEl, isReadOnly = true;
			dfFieldValueLabel = commonFc.createLabel('dfFieldValue_' + ind, 'Field Value', 'df-field-value field-setting-label');
			dfFieldValueInputEl = commonFc.createInputTextEl('form-control df-field-value-input-el', 'dfFieldValue_' + ind, isReadOnly);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(dfFieldValueLabel);
			$(formGroupDivEl).append(dfFieldValueInputEl);
			
			return formGroupDivEl;
		};
		
		createDFDisplayValues = function(ind){
			var dfDisplayValuesLabel, dfDisplayValuesInputTag, formGroupDivEl;
			dfDisplayValuesLabel = commonFc.createLabel('dfDisplayValues_'+ind, 'Display Values', 'df-display-values-label field-setting-label');
			dfDisplayValuesInputTag = commonFc.createDivEl('df-display-values-input-tag contenteditable d-block', 'dfDisplayValues_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dfDisplayValuesLabel);
			$(formGroupDivEl).append(dfDisplayValuesInputTag);
			return formGroupDivEl;
		};
		
		createFieldSettingSubSection4 = function(ind) {
			var mainSettingRow4El; 
			
			mainSettingRow4El = commonFc.createDivEl('row', 'dfDataProviderRow_'+ind);
			
			return mainSettingRow4El;
		};
		
		createDataProviderURL = function(ind){
			var dataProviderURLLabelEl, dataProviderURLInputEl, formGroupDivEl;
			dataProviderURLLabelEl = commonFc.createLabel('dataProviderURL_'+ind, 'URL', 'data-provider-url-label field-setting-label');
			dataProviderURLInputEl = commonFc.createInputTextEl('form-control data-provider-url-el', 'dataProviderURL_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dataProviderURLLabelEl);
			$(formGroupDivEl).append(dataProviderURLInputEl);
			return formGroupDivEl;
		};
		
		createDataProviderURLProperty = function(ind){
			var dataProviderURLPropertyLabelEl, dataProviderURLPropertyInputEl, formGroupDivEl;
			dataProviderURLPropertyLabelEl = commonFc.createLabel('dataProviderURLProperty_'+ind, 'Property', 'data-provider-url-property-label field-setting-label');
			dataProviderURLPropertyInputEl = commonFc.createInputTextEl('form-control data-provider-url-property-el', 'dataProviderURLProperty_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dataProviderURLPropertyLabelEl);
			$(formGroupDivEl).append(dataProviderURLPropertyInputEl);
			return formGroupDivEl;
		};
		
		createMethodTypes = function(ind){
			var methodTypesLabelEl, methodTypesDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			methodTypesLabelEl = commonFc.createLabel('methodTypes_'+ind, 'Method Types', 'method-types-label field-setting-label');
			changeEventObj.fnName = 'populateContentTypes(this,'+ind+');';
			methodTypesDropdownEl = commonFc.createDropdown('form-control method-types-dropdown-el', 'methodTypes_'+ind, changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(methodTypesLabelEl);
			$(formGroupDivEl).append(methodTypesDropdownEl);
			commonFc.populateDropdown(methodTypes, methodTypesDropdownEl);
			return formGroupDivEl;
		};
		
		createContentType = function(ind){
			var contentTypesLabelEl, contentTypesDropdownEl, formGroupDivEl
			contentTypesLabelEl = commonFc.createLabel('contentTypes_'+ind, 'Content Types', 'content-types-label field-setting-label');
			contentTypesDropdownEl = commonFc.createDropdown('form-control content-types-dropdown-el', 'contentTypes_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(contentTypesLabelEl);
			$(formGroupDivEl).append(contentTypesDropdownEl);
			return formGroupDivEl;
		};
		
		createDataProps = function(ind){
			var dataPropsInputTagLabel, dataPropsInputTag, formGroupDivEl;
			dataPropsInputTagLabel = commonFc.createLabel('dataProps_'+ind, 'Data Props', 'data-props-label field-setting-label');
			dataPropsInputTag = commonFc.createDivEl('data-props-el contenteditable d-block', 'dataProps_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dataPropsInputTagLabel);
			$(formGroupDivEl).append(dataPropsInputTag);
			return formGroupDivEl;
		};
		
		createSourceProps = function(ind){
			var sourcePropsInputTagLabel, sourcePropsInputTag, formGroupDivEl;
			sourcePropsInputTagLabel = commonFc.createLabel('sourceProps_'+ind, 'Source Props', 'source-props-label field-setting-label');
			sourcePropsInputTag = commonFc.createDivEl('source-props-el contenteditable d-block', 'sourceProps_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(sourcePropsInputTagLabel);
			$(formGroupDivEl).append(sourcePropsInputTag);
			return formGroupDivEl;
		};
		
		createFieldSettingStatus = function(ind){
			var fieldSettingStatusLabelEl, fieldSettingStatusDropdownEl, formGroupDivEl;
			fieldSettingStatusLabelEl = commonFc.createLabel('fieldStatus_'+ind, 'Field Satus', 'field-status-label field-setting-label');
			fieldSettingStatusDropdownEl = commonFc.createDropdown('form-control field-status-dropdown-el', 'fieldStatus_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingStatusLabelEl);
			$(formGroupDivEl).append(fieldSettingStatusDropdownEl);
			commonFc.populateDropdown(settingStatus, fieldSettingStatusDropdownEl);
			return formGroupDivEl;
		};
		
		createFieldSettingReadonly = function(ind){
			var fieldSettingReadonlyEl;
			fieldSettingReadonlyEl = commonFc.createInputCheckboxEl('form-check-label field-read-only-label field-setting-label', 'fieldReadonly_'+ ind +'' ,'form-check-input field-read-only-checkbox-el', 'fieldReadonly_'+ind, 'Readonly' );
			return fieldSettingReadonlyEl;
		};
		
		createFieldSettingDisable = function(ind){
			var fieldSettingDisableEl;
			fieldSettingDisableEl = commonFc.createInputCheckboxEl('form-check-label field-disable-label field-setting-label', 'fieldDisable_'+ ind +'','form-check-input field-disable-checkbox-el', 'fieldDisable_'+ind, 'Disabled');
			return fieldSettingDisableEl;
		};
		
		createFieldSettingRequired = function(ind){
			var fieldSettingRequiredEl;
			fieldSettingRequiredEl = commonFc.createInputCheckboxEl('form-check-label field-required-label field-setting-label', 'fieldRequired_'+ ind +'', 'form-check-input field-required-checkbox-el', 'fieldRequired_'+ind, 'Required');
			return fieldSettingRequiredEl;
		};
		
		createFieldSettingSubSection2 = function(ind){
			var mainSettingRow2El, settingPlaceholderColEl, fieldSettingPlaceholderEl, htmlEditorPlaceholderColEl, htmlEditorPlaceholderEl, minNumberPlaceholderColEl, 
				minNumberPlaceholderEl, maxNumberPlaceholderColEl, maxNumberPlaceholderEl, multipleFileUploadColEl, multipleFileUploadEl, fileExtensionsInputTagColEl,
				fileExtensionsInputTagEl, groupOrderColEl, groupOrderEl, groupColEl, groupEl, averageColEl, groupAverageEl, overAllAverageEl, minBoundaryColEl, minBoundaryEl, 
				maxBoundaryColEl, maxBoundaryEl, rangeOptionsColEl, rangeOptionsEl, formatPlaceholderColEl, formatFieldPlaceholderEl, valuesInputTagColEl, valuesInputTagEl, defaultSelectedColEl, 
				defaultSelectedEl, dropdownConfigCheckboxColEl, multiselectDropdownCheckboxEl, searchableDropdownCheckboxEl, WhereToPopulateDropdownValuesColEl, 
				WhereToPopulateDropdownValuesEl, settingPostDataColEl, settingPostDataEl, settingPopulateDataColEl, settingPopulateDataEl, settingReadFromReqColEl, 
				settingReadFromReqEl;
			
			mainSettingRow2El = commonFc.createDivEl('row');
			
			settingPlaceholderColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none placeholder-div-el', 'displayPlaceholder_' + ind);
			fieldSettingPlaceholderEl = createFieldSettingPlaceholder(ind);
			
			htmlEditorPlaceholderColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 d-none html-editor-placeholder-div-el', 'displayHTMLEditor_' + ind);
			htmlEditorPlaceholderEl = createHTMLEditorPlaceholder(ind);
			
			formatPlaceholderColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none format-placeholder-div-el', 'displayFormatPlaceholder_' + ind);
			formatFieldPlaceholderEl = createFormatFieldSettingPlaceholder(ind);
			
			minNumberPlaceholderColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none min-number-placeholder-div-el', 'displayMinNumberPlaceholder_' + ind);
			minNumberPlaceholderEl = createMinNumberFieldSettingPlaceholder(ind);
			
			maxNumberPlaceholderColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none max-number-placeholder-div-el', 'displayMaxNumberPlaceholder_' + ind);
			maxNumberPlaceholderEl = createMaxNumberFieldSettingPlaceholder(ind);
			
			multipleFileUploadColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none multiple-file-upload-div-el', 'displayMultipleFileUpload_' + ind);
			multipleFileUploadEl = createMultipleFileUploadCheckbox(ind);
			
			fileExtensionsInputTagColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none file-extensions-input-tag-div-el', 'displayFileExtensionsInputTag_' + ind);
			fileExtensionsInputTagEl = createFileExtensionsInputTag(ind);
			
			minBoundaryColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none min-boundary-div-el', 'displayMinBoundary_' + ind);
			minBoundaryEl = createMinBoundary(ind);
			
			maxBoundaryColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none max-boundary-div-el', 'displayMaxBoundary_' + ind);
			maxBoundaryEl = createMaxBoundary(ind);
			
			rangeOptionsColEl = commonFc.createDivEl('col-lg-4 col-md-2 col-sm-12 col-xs-12 d-none range-options-div-el', 'displayRangeOptions_' + ind);
			rangeOptionsEl = createRangeOptions(ind);
			
			groupOrderColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none group-order-div-el', 'displayGroupOrder_' + ind);
			groupOrderEl = createGroupOrder(ind);
			
			groupColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none group-div-el', 'displayGroup_' + ind);
			groupEl = createGroup(ind);
			
			averageColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none average-div-el setting-checkbox-div-el', 'displayAverage_' + ind);
			groupAverageEl = CreateGroupAverage(ind);
			overAllAverageEl = createOverAllAverage(ind);
			
			groupColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none group-div-el', 'displayGroup_' + ind);
			groupEl = createGroup(ind);
			
			valuesInputTagColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none values-input-tag-div-el', 'displayValuesInputTag_' + ind);
			valuesInputTagEl = createValuesInputTag(ind);
			
			defaultSelectedColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none default-selected-div-el', 'displayDefaultSelected_' + ind);
			defaultSelectedEl = createDefaultSelected(ind);
			
			dropdownConfigCheckboxColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 d-none dropdown-config-checkbox-div-el', 'displayDropdownConfigCheckbox_' + ind);
			multiselectDropdownCheckboxEl = createMultiselectDropdownCheckbox(ind);
			searchableDropdownCheckboxEl = createSearchableDropdownCheckbox(ind);
			
			WhereToPopulateDropdownValuesColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none where-to-populate-dropdown-div-el', 'displayWhereToPopulateDropdown_' + ind);
			WhereToPopulateDropdownValuesEl = createWhereToPopulateDropdownValues(ind);
			
			settingPostDataColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none post-data-div-el', 'togglePostDataField_' + ind);
			settingPostDataEl = createFieldSettingPostData(ind);
			
			settingPopulateDataColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none populate-data-div-el', 'togglePopulateDataField_' + ind);
			settingPopulateDataEl = createFieldSettingPopulateData(ind);
			
			settingReadFromReqColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none read-from-req-param-field-div-el', 'toggleReadFromReqParamField_' + ind);
			settingReadFromReqEl = createFieldSettingReadFromReq(ind);
			
			$(settingPlaceholderColEl).append(fieldSettingPlaceholderEl);
			$(mainSettingRow2El).append(settingPlaceholderColEl);
			
			$(htmlEditorPlaceholderColEl).append(htmlEditorPlaceholderEl);
			$(mainSettingRow2El).append(htmlEditorPlaceholderColEl);
			
			$(formatPlaceholderColEl).append(formatFieldPlaceholderEl);
			$(mainSettingRow2El).append(formatPlaceholderColEl);
			
			$(minNumberPlaceholderColEl).append(minNumberPlaceholderEl);
			$(mainSettingRow2El).append(minNumberPlaceholderColEl);
			
			$(maxNumberPlaceholderColEl).append(maxNumberPlaceholderEl);
			$(mainSettingRow2El).append(maxNumberPlaceholderColEl);
			
			$(multipleFileUploadColEl).append(multipleFileUploadEl);
			$(mainSettingRow2El).append(multipleFileUploadColEl);
			
			$(fileExtensionsInputTagColEl).append(fileExtensionsInputTagEl);
			$(mainSettingRow2El).append(fileExtensionsInputTagColEl);
			
			$(minBoundaryColEl).append(minBoundaryEl);
			$(mainSettingRow2El).append(minBoundaryColEl);
			
			$(maxBoundaryColEl).append(maxBoundaryEl);
			$(mainSettingRow2El).append(maxBoundaryColEl);
			
			$(rangeOptionsColEl).append(rangeOptionsEl);
			$(mainSettingRow2El).append(rangeOptionsColEl);
			
			$(groupOrderColEl).append(groupOrderEl);
			$(mainSettingRow2El).append(groupOrderColEl);
			
			$(groupColEl).append(groupEl);
			$(mainSettingRow2El).append(groupColEl);
			
			$(averageColEl).append(groupAverageEl);
			$(averageColEl).append(overAllAverageEl);
			$(mainSettingRow2El).append(averageColEl);
			
			$(valuesInputTagColEl).append(valuesInputTagEl);
			$(mainSettingRow2El).append(valuesInputTagColEl);
			
			$(defaultSelectedColEl).append(defaultSelectedEl);
			$(mainSettingRow2El).append(defaultSelectedColEl);
			
			$(dropdownConfigCheckboxColEl).append(multiselectDropdownCheckboxEl);
			$(dropdownConfigCheckboxColEl).append(searchableDropdownCheckboxEl);
			$(mainSettingRow2El).append(dropdownConfigCheckboxColEl);
			
			$(WhereToPopulateDropdownValuesColEl).append(WhereToPopulateDropdownValuesEl);
			$(mainSettingRow2El).append(WhereToPopulateDropdownValuesColEl);
			
			$(settingPostDataColEl).append(settingPostDataEl);
			$(mainSettingRow2El).append(settingPostDataColEl);
			
			$(settingPopulateDataColEl).append(settingPopulateDataEl);
			$(mainSettingRow2El).append(settingPopulateDataColEl);
			
			$(settingReadFromReqColEl).append(settingReadFromReqEl);
			$(mainSettingRow2El).append(settingReadFromReqColEl);
			
			return mainSettingRow2El;
		};
		
		createDataProviderFieldSettingSection = function(ind){
			var dataProviderRowEl , dataProviderURLColEl, dataProviderURLEl, methodTypesColEl, methodTypesEl, contentTypesColEl, contentTypesEl, dataProviderURLPropertyColEl, dataProviderURLPropertyEl,
				dataPropsColEl, dataPropsEl;
			
			dataProviderRowEl = commonFc.createDivEl('row data-provider-row hide', 'dataProviderRow_'+ind);
			
			dataProviderURLColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 data-provider-url-div-el', 'displayDataProviderURL_' + ind);
			dataProviderURLEl = createDataProviderURL(ind);
			
			methodTypesColEl =  commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 method-types-div-el', 'displayMethodTypes_' + ind);
			methodTypesEl = createMethodTypes(ind);
			
			contentTypesColEl =  commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none content-types-div-el', 'displayContentTypes_' + ind);
			contentTypesEl = createContentType(ind);
			
			dataProviderURLPropertyColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 data-provider-url-property-div-el', 'displayDataProviderURLProperty_' + ind);
			dataProviderURLPropertyEl = createDataProviderURLProperty(ind);
			
			dataPropsColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 data-props-div-el', 'displayDataProps_' + ind);
			dataPropsEl = createDataProps(ind);
			
			sourcePropsColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 source-props-div-el d-none', 'displaySourceProps_' + ind);
			sourcePropsEl = createSourceProps(ind);
			
			$(dataProviderURLColEl).append(dataProviderURLEl);
			$(dataProviderRowEl).append(dataProviderURLColEl);
			
			$(methodTypesColEl).append(methodTypesEl);
			$(dataProviderRowEl).append(methodTypesColEl);
			
			$(contentTypesColEl).append(contentTypesEl);
			$(dataProviderRowEl).append(contentTypesColEl);
			
			$(dataProviderURLPropertyColEl).append(dataProviderURLPropertyEl);
			$(dataProviderRowEl).append(dataProviderURLPropertyColEl);
			
			$(dataPropsColEl).append(dataPropsEl);
			$(dataProviderRowEl).append(dataPropsColEl);
			
			$(sourcePropsColEl).append(sourcePropsEl);
			$(dataProviderRowEl).append(sourcePropsColEl);
			
			return dataProviderRowEl;
		};
		
		createStaticValuesFieldSettingSection = function(ind, appendTo){
			var staticValuesRowEl, staticValuesInputTagColEl, staticValuesInputTagEl;
			
			staticValuesRowEl = commonFc.createDivEl('row static-values-row hide', 'staticValuesRow_'+ind);
			
			staticValuesInputTagColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 static-values-input-tag-div-el', 'displayStaticValuesInputTag_' + ind);
			staticValuesInputTagEl = createStaticValuesInputTag(ind);
			
			$(staticValuesInputTagColEl).append(staticValuesInputTagEl);
			$(staticValuesRowEl).append(staticValuesInputTagColEl);
			
			return staticValuesRowEl;
		};
		
		createDependentFieldSettingSection = function(ind, appendTo){
			var dependentFieldsRowEl, dependentFieldsNameDropdownColEl, dependentFieldsNameDropdownEl, whereToPopulateDependentFieldsColEl, whereToPopulateDependentFieldsEl;
			
			dependentFieldsRowEl = commonFc.createDivEl('row dependent-fields-row hide', 'dependentFieldsRow_'+ind);
			
			dependentFieldsNameDropdownColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 dependent-fields-name-dropdown-div-el', 'displayDependentFieldsNameDropdown_' + ind);
			dependentFieldsNameDropdownEl = createDependentFieldsName(ind);
			
			whereToPopulateDependentFieldsColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 where-to-populate-dependent-fields-div-el', 'displayWhereToPopulateDependentFields_' + ind);
			whereToPopulateDependentFieldsEl = createWhereToPopulateDependentFields(ind);
			
			$(dependentFieldsNameDropdownColEl).append(dependentFieldsNameDropdownEl);
			$(dependentFieldsRowEl).append(dependentFieldsNameDropdownColEl);
			
			$(whereToPopulateDependentFieldsColEl).append(whereToPopulateDependentFieldsEl);
			$(dependentFieldsRowEl).append(whereToPopulateDependentFieldsColEl);
			
			return dependentFieldsRowEl;
		};
		
		createCheckboxFieldSettingPostData = function(ind){
			var checkboxFieldSettingPostDataEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'showDataField(this, '+ ind +');';
			checkboxFieldSettingPostDataEl = commonFc.createInputCheckboxEl('form-check-label post-data-label field-setting-label', 'postData_'+ ind +'', 'form-check-input post-data-checkbox-el', 'postData_'+ind, 'Post Data', changeEventObj, 'togglePostDataField_'+ind);
			
			return checkboxFieldSettingPostDataEl;
		};
		
		createFieldSettingPostData = function(ind){
			var fieldSettingPostDataLabelEl, fieldSettingPostDataInputEl, formGroupDivEl;
			fieldSettingPostDataLabelEl = commonFc.createLabel('postDataName_'+ind, 'Post Data -> Field Name', 'post-data-field-label field-setting-label');
			fieldSettingPostDataInputEl = commonFc.createInputTextEl('form-control post-data-field-input-el', 'postDataName_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingPostDataLabelEl);
			$(formGroupDivEl).append(fieldSettingPostDataInputEl);
			
			return formGroupDivEl;
		};
		
		createCheckboxFieldSettingPopulateData = function(ind){
			var checkboxFieldSettingPopulateDataEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'showDataField(this, '+ ind +');';
			checkboxFieldSettingPopulateDataEl = commonFc.createInputCheckboxEl('form-check-label populate-data-label field-setting-label', 'populateData_'+ ind +'', 'form-check-input populate-data-checkbox-el', 'populateData_'+ind, 'Prepopulate Data', changeEventObj, 'togglePopulateDataField_'+ind);
			
			return checkboxFieldSettingPopulateDataEl;
		};
		
		createFieldSettingPopulateData = function(ind){
			var fieldSettingPopulateDataLabelEl, fieldSettingPopulateDataInputEl, formGroupDivEl;
			fieldSettingPopulateDataLabelEl = commonFc.createLabel('populateDataName_'+ind, 'Prepopulate Data -> Field Name', 'populate-data-field-label field-setting-label');
			fieldSettingPopulateDataInputEl = commonFc.createInputTextEl('form-control populate-data-field-input-el', 'populateDataName_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingPopulateDataLabelEl);
			$(formGroupDivEl).append(fieldSettingPopulateDataInputEl);
			
			return formGroupDivEl;
		};
		
		createCheckboxFieldSettingReadFromReq = function(ind){
			var checkboxFieldSettingReadFromReqEl,changeEventObj = new Object({});
			changeEventObj.fnName = 'showDataField(this, '+ ind +');';
			checkboxFieldSettingReadFromReqEl = commonFc.createInputCheckboxEl('form-check-label read-from-req-param-label field-setting-label', 'readFromReqParam_'+ ind +'','form-check-input read-from-req-param-checkbox-el', 'readFromReqParam_'+ind, 'Read From Req Param', changeEventObj, 'toggleReadFromReqParamField_'+ind);
			
			return checkboxFieldSettingReadFromReqEl;
		};
		
		createFieldSettingReadFromReq = function(ind){
			var fieldSettingReadFromReqLabelEl, fieldSettingReadFromReqInputEl, formGroupDivEl;
			fieldSettingReadFromReqLabelEl = commonFc.createLabel('readFromReqParamName_'+ind, 'Read From Req Param -> Name', 'read-from-req-param-name-label field-setting-label');
			fieldSettingReadFromReqInputEl = commonFc.createInputTextEl('form-control read-from-req-param-name-input-el', 'readFromReqParamName_'+ind);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingReadFromReqLabelEl);
			$(formGroupDivEl).append(fieldSettingReadFromReqInputEl);
			
			return formGroupDivEl;
		};
		
		createFormFieldFooterSectionRow = function(){
			var mainFormFooterRowEl, mainFormFooterColEl, postDataFooterSection, prepopulateDataFooterSection, formFooterAccordian;
			
			mainFormFooterRowEl = commonFc.createDivEl('row footer-row hide');
			mainFormFooterColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			
			formFooterAccordian = commonFc.createAccordianCardEl('formFooterAccordian', 'Post/Prepopulate Configuration');
			
			postDataFooterSection = createPostDataFooterSection();
			prepopulateDataFooterSection = createPrepopulateDataFooterSection();
			
			$(formFooterAccordian).find('.card-body').append(postDataFooterSection);
			$(formFooterAccordian).find('.card-body').append(prepopulateDataFooterSection);
			$(mainFormFooterColEl).append(formFooterAccordian);
			$(mainFormFooterRowEl).append(mainFormFooterColEl);
			$(formCardBodyJEL).append(mainFormFooterRowEl);
		};
		
		createPostDataFooterSection = function(){
			var formPostDataRowEl, postDataURLColEl, postDataURLEl, postDataContentTypeColEl, postDataContentTypeEl;
			
			postDataRowEl = commonFc.createDivEl('row');
			postDataURLColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 d-none post-data-url-div');
			postDataURLEl = createPostDataURL();
			
			postDataContentTypeColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 d-none post-data-content-type-div');
			postDataContentTypeEl = createPostDataContentType();
			
			$(postDataURLColEl).append(postDataURLEl);
			$(postDataRowEl).append(postDataURLColEl);
			
			$(postDataContentTypeColEl).append(postDataContentTypeEl);
			$(postDataRowEl).append(postDataContentTypeColEl);
			
			return postDataRowEl;
		};
		
		createPrepopulateDataFooterSection = function(){
			var prepopulateDataRowEl, prepopulateDataURLColEl, prepopulateDataURLEl, prepopulateDataContentTypeColEl, prepopulateDataContentTypeEl;
			
			prepopulateDataRowEl = commonFc.createDivEl('row');
			prepopulateDataURLColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 d-none prepopulate-data-url-div');
			prepopulateDataURLEl = createPrepopulateDataURL();
			
			prepopulateDataContentTypeColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 d-none prepopulate-data-content-type-div');
			prepopulateDataContentTypeEl = createPrepopulateDataContentType();
			
			$(prepopulateDataURLColEl).append(prepopulateDataURLEl);
			$(prepopulateDataRowEl).append(prepopulateDataURLColEl);
			
			$(prepopulateDataContentTypeColEl).append(prepopulateDataContentTypeEl);
			$(prepopulateDataRowEl).append(prepopulateDataContentTypeColEl);
			
			return prepopulateDataRowEl;
		};
		
		createPostDataURL = function(){
			 var postDataURLLabelEl, postDataURLInputEl, formGroupDivEl;
			 postDataURLLabelEl = commonFc.createLabel('postDataURL','Post Data URL');
			 postDataURLInputEl = commonFc.createInputTextEl('form-control', 'postDataURL');
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(formGroupDivEl).append(postDataURLLabelEl);
			 $(formGroupDivEl).append(postDataURLInputEl);
					 
			 return formGroupDivEl; 
		};
		
		createPostDataContentType = function(ind){
			var postDataContentTypeLabelEl, postDataContentTypeDropdownEl, formGroupDivEl;
			postDataContentTypeLabelEl = commonFc.createLabel('postDataContentType', 'Post Data Content Type');
			postDataContentTypeDropdownEl = commonFc.createDropdown('form-control', 'postDataContentType');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(postDataContentTypeLabelEl);
			$(formGroupDivEl).append(postDataContentTypeDropdownEl);
			commonFc.populateDropdown(contentTypes, postDataContentTypeDropdownEl);
			
			return formGroupDivEl;
		};
		
		createPrepopulateDataURL = function(){
			 var prepopulateDataURLLabelEl, prepopulateDataURLInputEl, formGroupDivEl
			 prepopulateDataURLLabelEl = commonFc.createLabel('prepopulateDataURL','Prepopulate data URL');
			 prepopulateDataURLInputEl = commonFc.createInputTextEl('form-control', 'prepopulateDataURL');
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(formGroupDivEl).append(prepopulateDataURLLabelEl);
			 $(formGroupDivEl).append(prepopulateDataURLInputEl);
					 
			 return formGroupDivEl; 
		};
		
		createPrepopulateDataContentType = function(ind){
			var prepopulateDataContentTypeLabelEl, prepopulateDataContentTypeDropdownEl, formGroupDivEl;
			prepopulateDataContentTypeLabelEl = commonFc.createLabel('prepopulateDataContentType', 'Prepopulate Data Content Type');
			prepopulateDataContentTypeDropdownEl = commonFc.createDropdown('form-control', 'prepopulateDataContentType');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(prepopulateDataContentTypeLabelEl);
			$(formGroupDivEl).append(prepopulateDataContentTypeDropdownEl);
			commonFc.populateDropdown(contentTypes, prepopulateDataContentTypeDropdownEl);
			
			return formGroupDivEl;
		};
		
	
		createFormButtonSectionRow = function(){
			var mainFormButtonRowEl, mainFormButtonSaveColEl, mainFormButtonResetColEl, saveButtonEl, resetButtonEl;
			
			mainFormButtonRowEl = commonFc.createDivEl('row');
			mainFormButtonSaveColEl = commonFc.createDivEl('col-lg-1 col-md-1 col-sm-2 col-xs-2');
			mainFormButtonResetColEl = commonFc.createDivEl('col-lg-1 col-md-1 col-sm-2 col-xs-2');
			saveButtonEl = createSaveButton();
			resetButtonEl = createResetButton();
			
			$(mainFormButtonSaveColEl).append(saveButtonEl);
			$(mainFormButtonRowEl).append(mainFormButtonSaveColEl);
			
			$(mainFormButtonResetColEl).append(resetButtonEl);
			$(mainFormButtonRowEl).append(mainFormButtonResetColEl);
			
			$(formCardBodyJEL).append(mainFormButtonRowEl);
		};
		
		createSaveButton = function(){
			var saveButton, changeEventObj = new Object({});
			changeEventObj.fnName = 'submitDFForm(this);';
			saveButton = commonFc.createButtonEl('btn btn-md btn-primary', 'saveButton', changeEventObj, "Save");
			
			return saveButton;
		}; 
		
		createResetButton = function(){
			var resetButton, changeEventObj = new Object({});
			changeEventObj.fnName = 'resetDFForm(this);';
			saveButton = commonFc.createButtonEl('btn btn-md btn-secondary', 'resetButton', changeEventObj, "Reset");
			
			return saveButton;
		}; 
		submitDFForm = function(el){
			$(dfConfigurationFormJEl).submit();
		};
		resetDFForm = function(el){
			
		};
	    init = function() {
	    	commonFc.initConfigVars(new Object({namespace : config.namespace}));
	    	initFormConfig();
	    	$(formCardBodyLoadingRowJEL).hide();
        };
       
        
       init();
       
       viewDFConfig.selectedFieldSettingType = selectedFieldSettingType;
       viewDFConfig.showDataField = showDataField;
       viewDFConfig.addFormFieldRow = addFormFieldRow;
       viewDFConfig.deleteFormFieldRow = deleteFormFieldRow;
       viewDFConfig.whereToPopulateSelectedDropdownValue = whereToPopulateSelectedDropdownValue;
       viewDFConfig.whereToPopulateDependentFields = whereToPopulateDependentFields;
       viewDFConfig.addFieldKey = addFieldKey;
       viewDFConfig.populateContentTypes = populateContentTypes;
       viewDFConfig.populateRangeOptionsConfig = populateRangeOptionsConfig;
	};
	dfPortlet.viewDFConfig = viewDFConfig;	
})($, (window.dfPortlet = window.dfPortlet || {}));