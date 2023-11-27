(function($, dfrPortlet) {

	function renderDDf(renderDDf){
		console.log("In Render DDM forms...");
		var namespace = renderDDf.namespace,
		contextPath = renderDDf.contextPath,
		formName = renderDDf.formName,
		formLayoutColomn = renderDDf.formLayoutColomn,
		jsonFieldsArray = JSON.parse(renderDDf.jsonFieldsArray);
		formContainerJEL = renderDDf.formContainerJEL;
		
		
		
		
		initFormRenderConfig = function(){
			createFormFieldHeadSectionRow();
			createFormFieldSectionRow();
			dateRangPickerForPage();
		};
		
		
		createFormFieldHeadSectionRow = function(){
			var mainFormFieldRowEl, mainFormFieldColEl, formFieldHeadSection, formFieldSubSection, fieldSettingSection; 
			
			mainFormFieldRowEl = commonFc.createDivEl('row');
			mainFormFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			formFieldHeadSection = createFormFieldHeadSection();
			
			$(mainFormFieldColEl).append(formFieldHeadSection);
			
			$(mainFormFieldRowEl).append(mainFormFieldColEl);
			$(formContainerJEL).append(mainFormFieldRowEl);
		};
		
		
		createFormFieldHeadSection = function(){
			var headRowEl, headColEl, headEl;
			headRowEl = commonFc.createDivEl('row');
			headColEl = commonFc.createDivEl('col-lg-4 col-md-6 col-sm-12 col-xs-12');
			headEl = createHead('h3','Form Fields');
			
			$(headColEl).append(headEl);
			$(headRowEl).append(headColEl);
			
			return headRowEl;
		};
		
		createHead = function(head , text){
			return formHeadEl = $('<'+head+'>', {
				'text': text
			});
		};
		
		
		createFormFieldSectionRow = function(){
			var mainFormFieldRowEl, mainFormFieldColEl, formFieldSubSection, fieldSettingSection; 
			
			mainFormFieldRowEl = commonFc.createDivEl('row');
			mainFormFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			formFieldSubSection = createFormFieldSubSection();
			
			$(mainFormFieldColEl).append(formFieldSubSection);
			
			$(mainFormFieldRowEl).append(mainFormFieldColEl);
			$(formContainerJEL).append(mainFormFieldRowEl);
		};
		
		
		createFormFieldSubSection = function(){
			var formFieldRowEl, formFieldColEl, formFieldLabelColEl, formFieldKeyColEl, formFieldLabelSectionEl, formFieldKeySectionEl,
				formFieldButtonColEl, formFieldButtonSectionEl,colEl,sectionEl,lableEl,radioButtonRow,colEl2; 
			
			formFieldRowEl = commonFc.createDivEl('row form-field-row border pt-1 mb-1 form-field-row-div-el','formFieldConfigRow_');
			formFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			formFieldSubRowEl = commonFc.createDivEl('row');
			
			jsonFieldsArray.forEach(function(jsonData) {
			   var elementType = jsonData.settings.type; 
			  var formLayNumber = getLayoutColomnSize();
			  var paramName =jsonData.key;
			   var label = jsonData.label;
			   var isMultiFile = jsonData.settings.multiple; 
			   var inputCheckboxes =jsonData.settings.values; 
			   if(elementType === "checkbox"){
				   colEl = commonFc.createDivEl('col-lg-'+formLayNumber+' col-md-'+formLayNumber+' col-sm-12 col-xs-12');
				   var checkBoxHeadingLableDivEl = createDivEl('');
				   lableEl = commonFc.createLabel(paramName, label, paramName);
				   $(checkBoxHeadingLableDivEl).append(lableEl);
				   $(colEl).append(checkBoxHeadingLableDivEl);
				  var checkBoxMainDivEl = createDivEl('');
				   for(var i = 0; i < inputCheckboxes.length; i++)
				   {
					   sectionEl = commonFc.createInputCheckboxDynamicEl('form-check-label multiselect-dropdown-checkbox-label field-setting-label', inputCheckboxes[i] ,
							   'form-check-input multiselect-dropdown-checkbox-el', inputCheckboxes[i], inputCheckboxes[i]);
					   $(checkBoxMainDivEl).append(sectionEl);
				   }
				   
				   $(colEl).append(checkBoxMainDivEl);
			   }else if(elementType === "html"){
				   colEl = commonFc.createDivEl('col-lg-8 col-md-8 col-sm-12 col-xs-12');
				   sectionEl = createhtmlField(label,paramName);
				   $(colEl).append(sectionEl);
			   }else if(elementType === "radio"){
				   colEl = commonFc.createDivEl('col-lg-'+formLayNumber+' col-md-'+formLayNumber+' col-sm-12 col-xs-12 ');
				   var checkBoxHeadingLableDivEl = createDivEl('');
				 var lableEl = commonFc.createLabel(paramName, label, paramName);
				 $(checkBoxHeadingLableDivEl).append(lableEl);
				   $(colEl).append(checkBoxHeadingLableDivEl);
				   radioButtonRow = commonFc.createDivEl('');
				   for(var i = 0; i < inputCheckboxes.length; i++)
				   {
					   sectionEl = createRadioButtonField(inputCheckboxes[i],label,paramName);
					   $(radioButtonRow).append(sectionEl);
				   }
				   $(colEl).append(radioButtonRow);
			   }else if(elementType === "file" && isMultiFile === true){
				   colEl = commonFc.createDivEl('col-lg-'+formLayNumber+' col-md-'+formLayNumber+' col-sm-12 col-xs-12');
				   sectionEl = commonFc.createMultifileUploadDynamicEl(paramName, paramName, paramName, paramName, paramName, label);
				   $(colEl).append(sectionEl);
				   console.log("DropZone HTML Created....");
			   }else{
				   colEl = commonFc.createDivEl('col-lg-'+formLayNumber+' col-md-'+formLayNumber+' col-sm-12 col-xs-12');
				   sectionEl = createFormFieldElGroup(jsonData);
				   $(colEl).append(sectionEl);
			   }
				$(formFieldSubRowEl).append(colEl);
			});
			
			$(formFieldColEl).append(formFieldSubRowEl);
			$(formFieldRowEl).append(formFieldColEl);
			
			return formFieldRowEl;
		};
		
		
		createFormFieldElGroup = function(jsonData){
			var formFieldLabelEl, formFieldLabelInputEl, formGroupDivEl,lableEl,inputEl,checkboxEl;
			 var lable = jsonData.label;
			   var paramName = jsonData.key;
			   var elementType = jsonData.settings.type; 
			   var isMultiFile = jsonData.settings.multiple; 
			var className = "form-control field-label-input-el";
			   
			   if(elementType === "text"){
				   lableEl = commonFc.createLabel(paramName, lable, paramName);
					inputEl = commonFc.createInputTextEl(className, paramName);
			   }else if(elementType === "textarea"){
				   lableEl = commonFc.createLabel(paramName, lable, paramName);
					inputEl = commonFc.createTextAreaEl(className,paramName, 2);
			   }else if(elementType === "number"){
				   lableEl = commonFc.createLabel(paramName, lable, paramName);
					inputEl = commonFc.createInputNumberEl(className, paramName);
			   }else if(elementType === "datetime" || elementType === "date"){
				   lableEl = commonFc.createLabel(paramName, lable, paramName);
					inputEl = commonFc.createInputDateEl(className, paramName);
			   }else if(elementType === "file" && isMultiFile === false){
				   	lableEl = commonFc.createLabel(paramName, lable, paramName);
					inputEl = commonFc.createInputFileEl(className, paramName);
			   }else if(elementType === "time"){
				   lableEl = commonFc.createLabel(paramName, lable, paramName);
					inputEl = commonFc.createInputDateEl(className, paramName);
			   }
			   formGroupDivEl = commonFc.createDivEl('form-group');
			
			   $(formGroupDivEl).append(lableEl);
			   $(formGroupDivEl).append(inputEl);
			
			return formGroupDivEl;
		};
		dateRangPickerForPage = function(){
			jsonFieldsArray.forEach(function(jsonData) {
			   var elementType = jsonData.settings.type;
			   var elementName = jsonData.key;
			   var isMultiFile = jsonData.settings.multiple; 
			  
			   if(elementType === "datetime" || elementType === "date"){
				   var format = jsonData.settings.dateConfig.format;
				   commonFc.dateRangePickerConfig(elementType,elementName,format);
			   }else if(elementType === "time"){
				   var format = jsonData.settings.dateConfig.format;
				   commonFc.dateRangePickerConfig(elementType,elementName,format);
			   }else if(elementType === "file" && isMultiFile === true){
				   commonFc.loadMultifileDropZone(elementName);
			   }
			  
			});
		};
		
		
		
		getLayoutColomnSize = function(){
			var layoutNumber = 3;
			 if(formLayoutColomn ==="col-6"){
				layoutNumber = 6;
			}else if(formLayoutColomn ==="col-9"){
				layoutNumber = 9;
			}else if(formLayoutColomn ==="col-12"){
				layoutNumber = 12;
			}
			return layoutNumber;
		}
		
		createhtmlField = function(label,paramName){
			var formHtmlFieldLabelEl, formHtmlFieldTextEditorEl, formGroupDivEl;
			formHtmlFieldLabelEl = commonFc.createLabel(paramName,label);
			formHtmlFieldTextEditorEl = commonFc.createTextEditorEl('formTextEditor',paramName);
			formGroupDivEl = commonFc.createDivEl('form-group');
			 
			$(formGroupDivEl).append(formHtmlFieldLabelEl);
			$(formGroupDivEl).append(formHtmlFieldTextEditorEl);
			commonFc.initTextEditor(formHtmlFieldTextEditorEl);
			return formGroupDivEl;
		}
		
		createRadioButtonField = function(value,label,paramName){
			var colRadioButtonSectionEl;
			colRadioButtonSectionEl = commonFc.createInputRadioDynamicEl('form-check-label', value, 'form-check-input', value, paramName, value);
			return colRadioButtonSectionEl;
		};
		
		
		  init = function() {
			  commonFc.initConfigVars(new Object({namespace : renderDDf.namespace}));
			  initFormRenderConfig();
	           
	        };
	       
	       init();
		
		
	};
	
	dfrPortlet.renderDDf = renderDDf;	
})($, (window.dfrPortlet = window.dfrPortlet || {}));