(function($, dfrPortlet) {

	var htmlKeys = [];
	var namespace;
	var htmlArray = [];
	var multipleFileEntryIds = [];
    var singleFileEntryIds = [];
    var deleteFileEntryJson = {};
	var getFormDataResourceURL;
	var curUserRoles;
	var isAdmin;
	function renderDDf(renderDDf){
		namespace = renderDDf.namespace;
		var contextPath = renderDDf.contextPath,
		themeImagesPath = renderDDf.themeImagesPath,
		formName = renderDDf.formName,
		isMasterForm = renderDDf.isMasterForm,
		getFormDataResourceURL = renderDDf.getFormDataResourceURL;
		readFromReqParam = renderDDf.readFromReqParam;
		formLayoutColomn = renderDDf.formLayoutColomn,
		jsonFieldsArray = JSON.parse(renderDDf.jsonFieldsArray);
		formContainerJEL = renderDDf.formContainerJEL;
		updateDependentFields = renderDDf.updateDependentFields;
		dropzoneActionURL = renderDDf.dropzoneActionURL;
		attachmentId = renderDDf.attachmentId;
		htmlData = renderDDf.htmlData;
		formDescriptionJEL = renderDDf.formDescriptionJEL;
		groupRowAccordianJEl = renderDDf.groupRowAccordianJEl;
		formTitleJEl = renderDDf.formTitleJEl;
		editDataJson = renderDDf.editDataJson;
		secretPassphrase = renderDDf.secretPassphrase;
		languageId = renderDDf.languageId;
		encryptedFormDescription = JSON.parse(renderDDf.encryptedFormDescription);
		formTitle = JSON.parse(renderDDf.formTitle);
		groups = JSON.parse(renderDDf.groups);
		prepopulateDataJSON = renderDDf.prepopulateJsonData;
		selectedFormDefinitionId = renderDDf.selectedFormDefinitionId;
		editDataJson = renderDDf.editDataJson;
		backPreviewURL = renderDDf.backPreviewURL;
		backPreviewURLBtnJEl = renderDDf.backPreviewURLBtnJEl;
        fileJson = renderDDf.fileJson;
        curUserRoles = renderDDf.curUserRoles;
        isAdmin = renderDDf.isAdmin;
		var groupNames = new Object([]);
		var groupRangeObj = new Object({});
		var overallRangeObj = new Object([]);
		//var groupTotalRangeObj = new Object([]);
		var groupTotalRangeObj = new Object({});
		var overallTotalRangeObj = new Object([]);
		var groupNameMap = new Map();
		var groupRowMap = new Map();
		var clickCount = 0;

		initFormRenderConfig = function(){
			addFormTitle();
			addFormDescription();
			//createFormFieldHeadSectionRow();
			createFormFieldSectionRow();
			reorderFields();
			checkPermissions();
			dateRangPickerForPage();
			getReqParam();
			prepopulateFieldData();
		};
		
		$(backPreviewURLBtnJEl).click(function(){
			var formBackPreviewURL = backPreviewURL;
        	formBackPreviewURL = formBackPreviewURL.replace(Liferay.Language.get('selected-form-definition-id-text'), selectedFormDefinitionId);
        	console.log('selectedFormDefinitionId: ',selectedFormDefinitionId);
			console.log('formBackPreviewURL: ',formBackPreviewURL);
			window.location.href = formBackPreviewURL;
			
		});
		
		getReqParam = function(){
			var value, type, parsedJson;
			if($(readFromReqParam).val().length > 0){
				parsedJson = JSON.parse($(readFromReqParam).val());
				for(var key in parsedJson){
				    value = parsedJson[key];
				    if($('#'+key).length > 0){
				    	type = $('#'+key)[0].type;
				    	if(type == "text" || type == "date" || type == "textarea" || type == "datetime" || type == "select" || type == "number"){
				    		$('#'+key).val(value[0]).prop('readonly',true);
				    	} else if(type == "select-one" || type == "dropdown"){
				    		$('#'+key).val(value[0]).trigger('change');
				    		$('#'+key).select2({'disabled':'readonly'});
				    	} else if(type == "checkbox"){
				    		$('#'+key+'[value='+value[0]+']').prop('checked', true);
				    		$('#'+key).prop('readonly',true);
				    	} 
				    } else if($('input[name="'+key+'"]').length > 0 && $('.df-radio-field')[0].type == 'radio') {
				    	$('input[name="'+key+ '"][value="'+value[0]+'"]').addClass('checked').prop('checked', true);
				    	$('input[name="'+key+'"]:radio:not(:checked)').attr('disabled', true);
				    }
				}
			}
		};
		
		prepopulateFieldData = function(){
			var value, type;
			if(prepopulateDataJSON){
				var prepopulateDataJSONObj = JSON.parse(atob(prepopulateDataJSON));
				console.log('prepopulateDataJSONObj: ',prepopulateDataJSONObj);
				jsonFieldsArray.forEach(function(jsonData){
					var elementType = jsonData.settings.type; 
					var fieldKey =jsonData.key;
					
					var isPrepopulateDataChecked = jsonData.settings.populateData;
					if(isPrepopulateDataChecked && prepopulateDataJSONObj){
						var tempValue = recursiveSearch(prepopulateDataJSONObj,fieldKey);
						if(tempValue && tempValue.length > 0){
							value = tempValue[0];
							console.log('value',value);
							console.log("Element Type: ", elementType);
							if(elementType == 'text' || elementType == "date" || elementType == "textarea" || elementType == "datetime" 
								|| elementType == "select" || elementType == "number"){
								$("#" + namespace + fieldKey).val(value).prop('readonly',true);
							}else if(elementType == "dropdown" || elementType == "select-one"){
					    		$('#'+ namespace + fieldKey).val(value).trigger('change');
					    		$('#'+ namespace + fieldKey).select2({'disabled':'readonly'});
					    	} else if(elementType == "checkbox"){
					    		$('#'+ namespace + fieldKey + '[value='+value+']').prop('checked', true);
					    		$('#'+ namespace + fieldKey).prop('readonly',true);
					    	}  else if($('input[name="'+namespace + fieldKey+'"]').length > 0 && $('.df-radio-field')[0].type == 'radio') {
						    	$('input[name="'+namespace + fieldKey+ '"][value="'+value+'"]').addClass('checked').prop('checked', true);
						    	$('input[name="'+namespace + fieldKey+'"]:radio:not(:checked)').attr('disabled', true);
						    }else if(elementType == 'html'){
						    	var toDecryptDataObj = new Object({});
								toDecryptDataObj.secretPassphrase = secretPassphrase;
								toDecryptDataObj.text = value;
						    	var decryptedValue = commonFc.decryptData(toDecryptDataObj);
						    	$('#'+ namespace + fieldKey).summernote('code',decryptedValue);
						    }
						}
					}
				});
			}
		};
		
		recursiveSearch = (prepopulateDataJSONObj, fieldKey, result = []) => {
		   var r = result;
		   console.log('fieldKey in recursiveSearch: ', fieldKey);
		   Object.keys(prepopulateDataJSONObj).forEach(key => {
			   if(key == 'data'){
				   var entries = Object.entries(prepopulateDataJSONObj.data);
				   for (var [key, value] of entries) {
					   for (var checkKey of value) {
						   if (fieldKey in checkKey) {
							   var value = checkKey[fieldKey][0][languageId];
							   if (value) {
								   console.log('Recursive Search Value:', value);
								   r.push(value);
							   }
						   }
					   }
				   }
				   if (typeof prepopulateDataJSONObj[key] === 'object') {
					   recursiveSearch(prepopulateDataJSONObj[key], fieldKey);
				   }
			   }
			});
		   return r;
		};
			
		addFormTitle = function() {
			if(formTitle[languageId] !== '') {
				$(formTitleJEl).html(formTitle[languageId]);
			}
		};

		addFormDescription = function() {
			if(encryptedFormDescription[languageId] !== '') {
				var toDecryptDataObj = new Object({});
				toDecryptDataObj.secretPassphrase = secretPassphrase;
				toDecryptDataObj.text = encryptedFormDescription[languageId];
				var decryptedFormDescription = commonFc.decryptData(toDecryptDataObj);
				$(formDescriptionJEL).html(decryptedFormDescription);
			}			
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
		
		createGroupSection = function(groupName, jsonData, isGroupNameExists){
			var curLocaleGroupName, cardTitle, curLocaleGroupDescription;
			console.log('groups ::: ', groups);
			curLocaleGroupName = commonFc.getCurrentLocaleGroupName(jsonData.settings.group, languageId, groups);
			curLocaleGroupDescription = commonFc.getCurrentLocaleGroupDescription(jsonData.settings.group, languageId, groups);
			groupDivSection = commonFc.createAccordianCardEl('accordion', 'form-group-section', curLocaleGroupName, groupName, curLocaleGroupDescription);
			groupNames.push(groupName.replace(/[^a-zA-Z0-9 ]/g, "_"));
			return groupDivSection;
		};
		
		getCheckboxEl = function(paramName, label, inputCheckboxes, defaultSelected, isRequired, editData){
			var checkBoxMainDivEl = createDivEl('form-group checkbox-group-section');
			lableEl = commonFc.createLabel(paramName, label, paramName);
			$(checkBoxMainDivEl).append(lableEl);
			if(editData){
				defaultSelected = [editData[paramName]];
			}
			for(var i = 0; i < inputCheckboxes.length; i++){
				sectionEl = createCheckboxButtonField(inputCheckboxes[i],paramName, defaultSelected, isRequired);
				$(checkBoxMainDivEl).append(sectionEl);
			}	
			addAsteriskOnLable(isRequired, lableEl);
			return checkBoxMainDivEl;
		};
		
		getRangeEl = function(paramName, label, rangeConfig, groupAverage, overallAverage, isRequired){
			var rangeMainDivEl = createDivEl('form-group range-group-section');
			rangeEl = createRangeEl(paramName, label, rangeConfig, groupAverage, overallAverage, isRequired);
			$(rangeMainDivEl).append(rangeEl);
			return rangeMainDivEl;
		};
		
		getTextboxEl = function(paramName, lable, className, isReadonly, placeHolder, isDisabled, isRequired, editData){
			var textDivEl = commonFc.createDivEl('form-group text-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createInputTextEl(className, paramName,isReadonly,"",placeHolder,(editData)?editData[paramName]:"",isDisabled, isRequired);
			$(textDivEl).append(inputEl);
			return textDivEl;
		};
		
		getTextAreaEl = function(paramName, lable, className, isReadonly, placeHolder, isDisabled, isRequired, editData){
			var textDivEl = commonFc.createDivEl('form-group textArea-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createTextAreaEl(className,paramName, 2,"",isReadonly,isDisabled,placeHolder, (editData)?editData[paramName]:"", isRequired);
			$(textDivEl).append(inputEl);
			return textDivEl;
		};
		
		getNumberEl = function(paramName, lable, className, isReadonly, placeHolder, isDisabled, isRequired, editData, min, max){
			var textDivEl = commonFc.createDivEl('form-group text-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName,isReadonly);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createInputNumberEl(className, paramName,"",isReadonly,placeHolder,isDisabled, (editData)?editData[paramName]:"", min, max, isRequired);
			$(textDivEl).append(inputEl);
			addAsteriskOnLable(isRequired, lableEl);
			return textDivEl;
		};
		
		getFileEl = function(paramName, lable, className, isReadonly, isDisabled, isRequired){
			var textDivEl = commonFc.createDivEl('form-group file-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createInputFileEl(className, paramName,isReadonly, "", isDisabled, isRequired);
			$(textDivEl).append(inputEl);
			addAsteriskOnLable(isRequired, lableEl);
			return textDivEl;
		};
		
		getReadOnlyEl = function(paramName, lable, className, isReadonly, isDisabled, isRequired){
			var textDivEl = commonFc.createDivEl('form-group file-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createInputDateEl(className, paramName,isReadonly,isDisabled, "", isRequired);
			$(textDivEl).append(inputEl);
			return textDivEl;
		};
		
		getPasswordEl = function(paramName, lable, className, isReadonly, isDisabled, placeHolder, isRequired, editData){
			var textDivEl = commonFc.createDivEl('form-group text-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createInputPasswordEl(className, paramName,isReadonly,"",placeHolder,isDisabled, (editData)?editData[paramName]:"", isRequired);
			$(textDivEl).append(inputEl);
			addAsteriskOnLable(isRequired, lableEl);
			return textDivEl;
		};
		
		getDateTimeEl = function(paramName, lable, className, isReadonly, isDisabled, isRequired, editData, dateFormat){
			var textDivEl = commonFc.createDivEl('form-group date-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			var editValue = "";
			if(editData){
				editValue = moment(editData[paramName]).format(dateFormat);
			}
			inputEl = commonFc.createInputDateEl(className, paramName,isReadonly,isDisabled, (editValue)?editValue:"", isRequired, dateFormat);
			$(textDivEl).append(inputEl);
			addAsteriskOnLable(isRequired, lableEl);
			return textDivEl;
		};
		
		getTimeEl = function(paramName, lable, className, isReadonly, isDisabled, isRequired, editData, dateFormat){
			var textDivEl = commonFc.createDivEl('form-group date-group-section');
			lableEl = commonFc.createLabel(paramName, lable, paramName);
			$(textDivEl).append(lableEl);
			inputEl = commonFc.createInputDateEl(className, paramName,isReadonly,isDisabled, (editData)?editData[paramName]:"", isRequired, dateFormat);
			$(textDivEl).append(inputEl);
			addAsteriskOnLable(isRequired, lableEl);
			return textDivEl;
		};
		
		getDropdownEl = function(paramName, label, changeEventObj, isMultiSelectDropdown, isRequired){
			var dropdownDivSection = createDivEl('form-group dropdown-group-section');
			lableEl = commonFc.createLabel(paramName, label, "");
			$(dropdownDivSection).append(lableEl);
			selectEl = commonFc.createDropdown('form-control df-dropdown-field', paramName, changeEventObj, isMultiSelectDropdown), isRequired;
			$(dropdownDivSection).append(selectEl);
			addAsteriskOnLable(isRequired, lableEl);
			return dropdownDivSection;
		};
		
		getMultipleFileEl = function(paramName, label, isRequired){
			var multipleFileMainDivEl = createDivEl('form-group multiple-file-group-section');
			sectionEl = commonFc.createMultifileUploadDynamicEl(paramName, paramName, paramName+' df-multiple-file-field', paramName, paramName, label, isRequired);
			$(multipleFileMainDivEl).append(sectionEl);	
			return multipleFileMainDivEl;
		};
		
		getRadioEl = function(paramName, label, inputCheckboxes, defaultSelected, isRequired, editData){
			radioButtonRow = commonFc.createDivEl('form-group radio-group-section');
			lableEl = commonFc.createLabel(paramName, label, paramName);
			$(radioButtonRow).append(lableEl);
			if(editData){
				defaultSelected = [editData[paramName]];
			}
			for(var i = 0; i < inputCheckboxes.length; i++){
			   sectionEl = createRadioButtonField(inputCheckboxes[i],label,paramName, defaultSelected, isRequired);
			   $(radioButtonRow).append(sectionEl);
			}
			addAsteriskOnLable(isRequired, lableEl);
			return radioButtonRow;
		};
		
		updateCharCount = function(inputEl, msgLableEl, maxRangeCharacter) {
			$(inputEl).keyup(function(){
				$(msgLableEl).text("Characters left: " + (maxRangeCharacter - $(inputEl).val().length));
			});
		};
		
		createFormFieldSubSection = function(){
			var formFieldRowEl, formFieldColEl, formFieldLabelColEl, formFieldKeyColEl, formFieldLabelSectionEl, formFieldKeySectionEl,
				formFieldButtonColEl, formFieldButtonSectionEl,colEl,sectionEl,lableEl,radioButtonRow,colEl2, htmlEditorLocaleBtnColEl,
				htmlEditorLocaleBtnSectionEl, formFieldSubRowAccordianEl;
			var counter = 0;
			
			formFieldRowEl = commonFc.createDivEl('row form-field-row border pt-1 mb-1 form-field-row-div-el','formFieldConfigRow_');
			formFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			formFieldSubRowEl = commonFc.createDivEl('row');
			//formFieldSubRowAccordianEl = commonFc.createDivEl('accordion', 'groupAccordian');
   
			var isPrevGroupSelected = false;
			var prevGroupName, getCardEl;
			jsonFieldsArray.forEach(function(jsonData) {
				var elementType = jsonData.settings.type; 
				var formLayNumber = getLayoutColomnSize();
				var paramName =jsonData.key;
				var label = commonFc.unEscape(jsonData.label[languageId]);
				var isMultiFile = jsonData.settings.multiple;
				var status = jsonData.settings.status; 
				var isNewLine = false; 
				if(jsonData.settings.hasOwnProperty('startNewLine')) {
					isNewLine = jsonData.settings.startNewLine;
				}
				console.log('paramName :: ', paramName);
				var isMultiSelectDropdown = false;
				if(jsonData.settings.multiselect) {
					isMultiSelectDropdown = jsonData.settings.multiselect;
				}
				var min, max;
				if(jsonData.settings.hasOwnProperty('min')){
					min = jsonData.settings.min;
				}
				if(jsonData.settings.hasOwnProperty('max')){
					max = jsonData.settings.max;
				}
                var editData = "";
                if(editDataJson){
                    editData = JSON.parse(editDataJson);
                }
                var isDisabled = jsonData.settings.disabled;
                
				var isRequired = false;
				if(jsonData.settings.hasOwnProperty('required')) {
					isRequired = jsonData.settings.required;
				}
                var groupName = "";
                if(jsonData.settings.hasOwnProperty('group')) {
					groupName = jsonData.settings.group;
                    var isGroupNameExists = jQuery.inArray(groupName, groupNames) >= 0;
                    if(isGroupNameExists){
                        groupDivSection = groupNameMap.get(groupName);
                    }else{
                        groupDivSection = createGroupSection(groupName, jsonData);
                        groupMainRowEl = commonFc.createDivEl('row');
                        groupRowMap.set(groupName, groupMainRowEl);
                        groupNameMap.set(groupName, groupDivSection);
                    }
				}
				var rangeConfig = new Object({});
				var rangeComment = '', maxRangeCharacter = '';
				if(jsonData.settings.hasOwnProperty('rangeConfig')) {
					rangeConfig = jsonData.settings.rangeConfig;
				} if(jsonData.settings.hasOwnProperty('customRangeConfig')){
					rangeConfig = jsonData.settings.customRangeConfig;
				}
				
				var isRangeComments = rangeConfig.isRangeComment;
				var isRangeTotalCharacter = rangeConfig.rangeTotalCharacter;
				var maxRangeCharacter = rangeConfig.maxRangeCharacter;
				if(jsonData.settings.hasOwnProperty('rangeConfig') && jsonData.settings.rangeConfig.hasOwnProperty('rangeComment')) {
					rangeComment = jsonData.settings.rangeConfig.rangeComment[languageId];
				}
				
				var placeHolder = '';
				if(jsonData.settings.hasOwnProperty('placeHolder') && jsonData.settings.placeHolder[languageId]) {
					placeHolder = jsonData.settings.placeHolder[languageId];
				}				
				var inputCheckboxesValues =jsonData.settings.values; 
				var inputCheckboxes = [];
				var defaultSelected = [];
				if(inputCheckboxesValues){
					inputCheckboxesValues.forEach(function(valueData){
						inputCheckboxes.push(valueData[languageId]);
						if(valueData.default_selected){
							defaultSelected.push(valueData[languageId]);
						}
					});
				}
                var isReadonly = jsonData.settings.readonly;
                var className = "form-control field-label-input-el";
                if(jsonData.settings.hasOwnProperty('dateConfig')){
                    var dateFormat = jsonData.settings.dateConfig.format;
                }
                
                colEl = commonFc.createDivEl('col-lg-'+formLayNumber+' col-md-'+formLayNumber+' col-sm-12 col-xs-12');
                var fieldGroupSubSectionColEl, groupRowEl;
                fieldGroupSubSectionColEl = commonFc.createDivEl('col-lg-'+formLayNumber+' col-md-'+formLayNumber+' col-sm-12 col-xs-12 group-layout-element');
                groupRowEl = groupRowMap.get(groupName);
                
                if(status == 'inactive'){
					$(fieldGroupSubSectionColEl).addClass('d-none');
				} else{
					if(elementType === "text"){
	                	var textDivEl = commonFc.createDivEl('form-group text-group-section');
	        			lableEl = commonFc.createLabel(paramName, label, paramName);
	        			$(textDivEl).append(lableEl);
	        			inputEl = commonFc.createInputTextEl(className, paramName,isReadonly,"",placeHolder,(editData)?editData[paramName]:"",isDisabled, isRequired);
	        			$(textDivEl).append(inputEl);
	        			if(groupName.replace(/&/g,'') != "") {
	                    	$(fieldGroupSubSectionColEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	        				if(isMasterForm){
	                        	colEl = createMasterForm(paramName, inputEl, lableEl, elementType);
	    					}
	        				if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else if(isMasterForm) {
	                    	masterForm = createMasterForm(paramName, inputEl, lableEl, elementType);
	                    	$(colEl).append(masterForm);
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else{
	                    	$(colEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    addAsteriskOnLable(isRequired, lableEl);
					} else if(elementType === "password"){
	                	var textDivEl = commonFc.createDivEl('form-group text-group-section');
	        			lableEl = commonFc.createLabel(paramName, label, paramName);
	        			$(textDivEl).append(lableEl);
	        			inputEl = commonFc.createInputPasswordEl(className, paramName,isReadonly,"",placeHolder,isDisabled, (editData)?editData[paramName]:"", isRequired);
	        			$(textDivEl).append(inputEl);
	        			if(groupName.replace(/&/g,'') != "") {
	                    	$(fieldGroupSubSectionColEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	        				if(isMasterForm){
	                        	colEl = createMasterForm(paramName, inputEl, lableEl, elementType);
	    					}
	        				if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else if(isMasterForm) {
	                    	masterForm = createMasterForm(paramName, inputEl, lableEl, elementType);
	                    	$(colEl).append(masterForm);
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else{
	                    	$(colEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    addAsteriskOnLable(isRequired, lableEl);
					} else if(elementType === "textarea"){
						var textDivEl = commonFc.createDivEl('form-group text-group-section');
						lableEl = commonFc.createLabel(paramName, label, paramName);
						$(textDivEl).append(lableEl);
						inputEl = commonFc.createTextAreaEl(className,paramName, 2,"",isReadonly,isDisabled,placeHolder, (editData)?editData[paramName]:"", isRequired);
						$(textDivEl).append(inputEl);
						if(groupName.replace(/&/g,'') != "") {
	                    	$(fieldGroupSubSectionColEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	        				if(isMasterForm){
	                        	colEl = createMasterForm(paramName, inputEl, lableEl, elementType);
	    					}
	        				if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else if(isMasterForm) {
	                    	masterForm = createMasterForm(paramName, inputEl, lableEl, elementType);
	                    	$(colEl).append(masterForm);
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else{
	                    	$(colEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    addAsteriskOnLable(isRequired, lableEl);
					} else if(elementType === "number"){
						var textDivEl = commonFc.createDivEl('form-group text-group-section');
						lableEl = commonFc.createLabel(paramName, label, paramName);
						$(textDivEl).append(lableEl);
						inputEl = commonFc.createInputNumberEl(className, paramName,"",isReadonly,placeHolder,isDisabled, (editData)?editData[paramName]:"", min, max, isRequired);
						$(textDivEl).append(inputEl);
						addAsteriskOnLable(isRequired, lableEl);
						if(groupName.replace(/&/g,'') != "") {
	                    	$(fieldGroupSubSectionColEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	        				if(isMasterForm){
	                        	colEl = createMasterForm(paramName, inputEl, lableEl, elementType);
	    					}
	        				if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else if(isMasterForm) {
	                    	masterForm = createMasterForm(paramName, inputEl, lableEl, elementType);
	                    	$(colEl).append(masterForm);
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else{
	                    	$(colEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
					} else if(elementType === "rangePicker"){
	                	var textDivEl = commonFc.createDivEl('form-group text-group-section');
	        			lableEl = commonFc.createLabel(paramName, label, paramName);
	        			$(textDivEl).append(lableEl);
	        			inputEl = commonFc.createInputRangePickerEl(className, paramName,isReadonly,"",placeHolder,isDisabled,(editData)?editData[paramName]:"", isRequired);
	        			$(textDivEl).append(inputEl);
	        			if(groupName.replace(/&/g,'') != "") {
	                    	$(fieldGroupSubSectionColEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	        				if(isMasterForm){
	                        	colEl = createMasterForm(paramName, inputEl, lableEl, elementType);
	    					}
	        				if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else if(isMasterForm) {
	                    	masterForm = createMasterForm(paramName, inputEl, lableEl, elementType);
	                    	$(colEl).append(masterForm);
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    } else{
	                    	$(colEl).append(textDivEl);
	                    	if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                    	if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    addAsteriskOnLable(isRequired, lableEl);
					} else if(elementType === "datetime" || elementType === "date"){
	                    var textDivEl;
	                    textDivEl = getDateTimeEl(paramName, label, className+' df-date-field', isReadonly, isDisabled, isRequired, editData, dateFormat);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    $('#' + namespace + paramName).val("");
					} else if(elementType === "file" && isMultiFile === false){
	                    var textDivEl = getFileEl(paramName, label, className+' df-single-file-field', isReadonly, isDisabled, isRequired);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    if(editDataJson == null && editDataJson == undefined && editDataJson == '' && fileJson == null && fileJson == undefined && fileJson == '' ){
	                    	$('#' + namespace + paramName).rules('remove', 'required');
	                    }
					} else if(elementType === "time"){
	                    var textDivEl;
	                    textDivEl = getTimeEl(paramName, label, className+' df-date-field', isReadonly, isDisabled, isRequired, editData, dateFormat);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
	                    $('#' + namespace + paramName).val("");
					} else if(elementType === "readonly"){
	                    var textDivEl;
	                    textDivEl = getReadOnlyEl(paramName, label, className, isReadonly, isDisabled, isRequired);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(textDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(textDivEl).append(inputGroupError);
					} else if(elementType === "checkbox"){
	                    var groupDivSection, checkBoxMainDivEl;
	                    checkBoxMainDivEl = getCheckboxEl(paramName, label, inputCheckboxes, defaultSelected, isRequired, editData);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(checkBoxMainDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(checkBoxMainDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
						$(checkBoxMainDivEl).append(inputGroupError);
					}else if(elementType === "html"){
						var htmlDivClassName = (isMasterForm) ? 'col-lg-10 col-md-10 col-sm-10 col-xs-10' : 'col-lg-12 col-md-12 col-sm-12 col-xs-12';
						var htmlDivEl = commonFc.createDivEl(htmlDivClassName);
						sectionEl = createhtmlField(label, paramName, isRequired, placeHolder);
						//$(colEl).append(sectionEl);
						$(htmlDivEl).append(sectionEl);
						htmlEditorLocaleBtnColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-2 col-xs-2 px-0 pt-1');
						htmlEditorLocaleBtnSectionEl = createHTMLEditorLocaleBtn(paramName);
						$(htmlEditorLocaleBtnColEl).append(htmlEditorLocaleBtnSectionEl);
						htmlKeys.push(paramName);
						console.log(htmlKeys);
						if(groupName.replace(/&/g,'') != "") {
							$(fieldGroupSubSectionColEl).append(htmlDivEl);
							if(jsonData.hasOwnProperty('visibleOn')){
								$(colEl).addClass('d-none');
							}
							if(status == 'inactive'){
								$(colEl).addClass('d-none');
							}
						} else{
							$(colEl).append(htmlDivEl);
							if(jsonData.hasOwnProperty('visibleOn')){
								$(colEl).addClass('d-none');
							}
							if(status == 'inactive'){
								$(colEl).addClass('d-none');
							}
						}
						inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
						$(htmlDivEl).append(inputGroupError);
						//my code for save goes here
					}else if(elementType === "radio"){
	                    var groupDivSection, radioButtonRow;
	                    radioButtonRow = getRadioEl(paramName, label, inputCheckboxes, defaultSelected, isRequired);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(radioButtonRow);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(radioButtonRow);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
						}
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
						$(radioButtonRow).append(inputGroupError);
					}else if(elementType === "file" && isMultiFile === true){
	                    var groupDivSection, multipleFileMainDivEl;
	                    multipleFileMainDivEl = getMultipleFileEl(paramName, label, isRequired);
	                    var colEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(multipleFileMainDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(multipleFileMainDivEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(multipleFileMainDivEl).append(inputGroupError);
	                    if(editDataJson == null && editDataJson == undefined && editDataJson == '' && fileJson == null && fileJson == undefined && fileJson == '' ){
	                    	$('input[name='+ namespace + paramName + ']').rules('remove', 'required');
	                    }
						//ajax dropzone
						console.log("DropZone HTML Created....");
					}else if(elementType == "dropdown"){
						var master = jsonData.settings.master;
	                    var groupDivSection, dropdownDivSection;
	                    var changeEventObj = new Object({});
	                    changeEventObj.fnName = 'getVisibleOn("' + paramName + '");';
	                    dropdownDivSection = getDropdownEl(paramName, label, changeEventObj, isMultiSelectDropdown, isRequired);
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(dropdownDivSection);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                    } else {
	                        $(colEl).append(dropdownDivSection);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
						$(dropdownDivSection).append(inputGroupError);
						if(master){
							var tableName = master.masterTable;
							var columnName = master.textColumn;
							var valueName = master.valueColumn;
							var createNewMappingTable = master.createNewMappingTable;
							var createFormMappingsTable = master.createFormMappingsTable;
							//Ajax Call	
							sendMasterTableData(tableName, columnName, valueName, paramName, createNewMappingTable, createFormMappingsTable, formName);
						} else {
							console.log("No master found");
						}
					}else if(elementType === "range" || elementType === "customRange") {
	                    var groupDivSection, rangeEl, groupAverage = false, overallAverage = false;
						console.log("Element Type In Range: ",elementType);
						if(rangeConfig.hasOwnProperty('groupAverage')) {
							console.log('Is Group Average: ',rangeConfig.hasOwnProperty('groupAverage'));
							groupAverage = rangeConfig.groupAverage;
						}
						if(rangeConfig.hasOwnProperty('overallAverage')) {
							overallAverage = rangeConfig.overallAverage;
						}
						
	                    rangeEl = getRangeEl(paramName, label, rangeConfig, groupAverage, overallAverage, isRequired);
	                    if(isRangeComments){
	                    	var textDivEl = commonFc.createDivEl('form-group text-group-section');
	    					lableEl = commonFc.createLabel(paramName, label, paramName);
	    					$(textDivEl).append(lableEl);
	    					inputEl = commonFc.createTextAreaEl(className + "range-comment-textarea","rangeComment_"+paramName, 2,"",isReadonly,isDisabled,placeHolder, (editData)?editData[paramName]:"", isRequired, maxRangeCharacter);
	    					var msgDivEl = commonFc.createDivEl("rangeTotalCharacter_"+className , "rangeTotalCharacter_"+paramName);
	    					var msgLableEl = commonFc.createLabel("rangeMaxLabel_"+paramName, "Remaning characters : "+maxRangeCharacter, namespace + "rangeMaxLabel_"+paramName, namespace + "rangeMaxLabel_"+paramName, maxRangeCharacter);
	    					$(msgDivEl).append(msgLableEl);
	    					$(textDivEl).append(inputEl);
	    					$(textDivEl).append(msgDivEl);
	    					if(isRangeTotalCharacter){
	    						$(inputEl).on('keyup', updateCharCount(inputEl, msgLableEl, maxRangeCharacter));
	    					}
	    					$(rangeEl).append(textDivEl);
	                    }
	                    if(status == 'inactive'){
	    					$(rangeEl).addClass('d-none');
	    				}
	                    if(groupName.replace(/&/g,'') != "") {
	                        $(fieldGroupSubSectionColEl).append(rangeEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(fieldGroupSubSectionColEl).addClass('d-none');
	        				}
						} else {
	                        $(colEl).append(rangeEl);
	                        if(jsonData.hasOwnProperty('visibleOn')){
	        					$(colEl).addClass('d-none');
	        				}
	                        if(status == 'inactive'){
	        					$(colEl).addClass('d-none');
	        				}
	                    }
	                    inputGroupError = createInputGroupError(paramName.replace(/[^\w\s]/gi, ''));
	                    $(rangeEl).append(inputGroupError);
					}
	                // Adding Language Selector Button...
					if(isMasterForm && elementType === "html") {
						$(formFieldSubRowEl).append(htmlEditorLocaleBtnColEl);
					}
					
					console.log('isPrevGroupSelected ::::: ',isPrevGroupSelected);
					console.log('prevGroupName ::::: ',prevGroupName);

					if(isPrevGroupSelected && prevGroupName != undefined && prevGroupName != null && prevGroupName != ''){
						if(groupName == ''){
							isNewLine = true;
						}
						console.log('Inside true prevSelected');
						console.log('groupName ::::: ',prevGroupName);
						getCardEl = $('#' + namespace + 'card_' + prevGroupName);
						console.log('getCardEl ::::: ',getCardEl);
					}

					if(isNewLine && groupName.replace(/&/g,'') != ""){
						groupRowEl = commonFc.createDivEl('row');
						$(groupRowEl).append(fieldGroupSubSectionColEl);
						$(groupDivSection).find('.card-body').append(groupRowEl);
						colEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
						$(colEl).append(groupDivSection);
						$(formFieldColEl).append(colEl);
						isPrevGroupSelected = true;
						prevGroupName = groupName;
					}else if(!isNewLine && groupName.replace(/&/g,'') != ""){
						$(groupRowEl).append(fieldGroupSubSectionColEl);
						$(groupDivSection).find('.card-body').append(groupRowEl);
						$(formFieldColEl).append(groupDivSection);
						isPrevGroupSelected = true;
						prevGroupName = groupName;
					}else if(isNewLine && groupName.replace(/&/g,'') == ""){
						formFieldSubRowEl = commonFc.createDivEl('row', prevGroupName + 'Id');
						$(formFieldSubRowEl).append(colEl);
						$(formFieldColEl).append(formFieldSubRowEl);
						isPrevGroupSelected = false;
					}else{
						$(formFieldSubRowEl).append(colEl);
						$(formFieldColEl).append(formFieldSubRowEl);
						isPrevGroupSelected = false;
					}
				}
			});
			
			$(formFieldRowEl).append(formFieldColEl);

			return formFieldRowEl;
		};
		
		reorderFields = function(){
			var isPrevGroupSelected = false;
			var getCardEl, prevGroupName;
			var formFieldSubRowAccordianEl = commonFc.createDivEl('accordion', 'groupAccordian');
			jsonFieldsArray.forEach(function(jsonData) {
				var elementType = jsonData.settings.type; 
				var paramName = jsonData.key;
				var isNewLine = false; 
				if(jsonData.settings.hasOwnProperty('startNewLine')) {
					isNewLine = jsonData.settings.startNewLine;
				}
				console.log('paramName :: ', paramName);
				
				var groupName = "";
				if(jsonData.settings.hasOwnProperty('group') && jsonData.settings.group != '') {
					groupName = jsonData.settings.group;
				} 
				
				console.log('isPrevGroupSelected ::::: ',isPrevGroupSelected);
				console.log('prevGroupName ::::: ',prevGroupName);
				
				if(isPrevGroupSelected && prevGroupName != undefined && prevGroupName != null && prevGroupName != ''){
					if(groupName == ''){
						isNewLine = true;
					}
					console.log('Inside true prevSelected');
					console.log('groupName ::::: ',prevGroupName);
					getCardEl = $('#' + namespace + 'card_' + prevGroupName); 
					console.log('getCardEl ::::: ',getCardEl);
				}
				
				if(isNewLine && groupName.replace(/&/g,'') != ""){
					isPrevGroupSelected = true;
					prevGroupName = groupName;
				}else if(!isNewLine && groupName.replace(/&/g,'') != ""){
					isPrevGroupSelected = true;
					prevGroupName = groupName;
				}else if(isNewLine && groupName.replace(/&/g,'') == ""){
					$(getCardEl).insertBefore('#' + namespace + (prevGroupName + 'Id'));
					isPrevGroupSelected = false;
				}else{
					isPrevGroupSelected = false;
				}
			});
		};
		
		checkPermissions = function(){
			console.log('curUserRoles :: ', curUserRoles);
			jsonFieldsArray.forEach(function(jsonData) {
				var elementType = jsonData.settings.type; 
				var paramName = jsonData.key;
				//permissions based on roles
                var add = false;
                var edit = false;
                var view = true;
                var permissions = jsonData.permissions;
                console.log('permissions :: ',permissions);
                console.log('isadmin :: ',isAdmin);
                if(isAdmin == "false"){
                	if(permissions == null || permissions == undefined || permissions == ''){
                    	if(elementType == "text" || elementType == "password" || elementType == "textarea" || elementType == "number" || elementType == "date" || elementType == "file") {
    				    	$('#' + namespace + paramName).attr('readonly',true);
    				    } else if(elementType == "select-one" || elementType == "dropdown"){
    			    		$('#' + namespace + paramName).select2().enable(false);
    			    	} else if(elementType == "html"){
    			    		$('#' + namespace + paramName).siblings().find('.note-editable').attr('readonly', true);
    			    	} else if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
    				    	$('input[name="'+ namespace + paramName +'"]').attr('readonly',true);
    				    	$('input[name="'+ namespace + paramName +'"]').each(function( index ){
    			    			$('label[for="'+this.id+'"]').attr('readonly',true);
    			    		});
    				    } 
                    } else{
                    	var roles = JSON.parse(curUserRoles);
                    	for (var i = 0; i < roles.length; i++){
        	            	var roleId = roles[i];
        	            	if(permissions.hasOwnProperty(roleId)){
        	            		var value = permissions[roleId];
        	            		add = value.add;
        	            		edit = value.edit;
        	            		view = value.view;
        	            		if(add){
        	            			if(elementType == "text" || elementType == "password" || elementType == "textarea" || elementType == "number" || elementType == "date" || elementType == "file") {
        	    				    	$('#' + namespace + paramName).attr('readonly',false);
        	    				    } else if(elementType == "select-one" || elementType == "dropdown"){
        	    			    		$('#' + namespace + paramName).select2().enable(true);
        	    			    	} else if(elementType == "html"){
        	    			    		$('#' + namespace + paramName).siblings().find('.note-editable').attr('readonly', false);
        	    			    	} else if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
        	    			    		$('input[name="'+ namespace + paramName +'"]').attr('readonly',false);
        	    				    }  
        	            			break;
        	            		} else {
        	            			if(elementType == "text" || elementType == "textarea" || elementType == "number" || elementType == "date" || elementType == "file") {
        	    				    	$('#' + namespace + paramName).attr('readonly',true);
        	    				    } else if(elementType == "select-one" || elementType == "dropdown"){
        	    			    		$('#' + namespace + paramName).select2().enable(false);
        	    			    	} else if(elementType == "html"){
        	    			    		$('#' + namespace + paramName).siblings().find('.note-editable').attr('readonly', true);
        	    			    	} else if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
        	    			    		$('input[name="'+ namespace + paramName +'"]').attr('readonly',true);
        	    			    		$('input[name="'+ namespace + paramName +'"]').each(function( index ){
        	    			    			$('label[for="'+this.id+'"]').attr('readonly',true);
        	    			    		});
        	    			    		
        	    				    }
        	            		}
        	            		
        	            		if(!view){
        	            			if(elementType == "text" || elementType == "password" || elementType == "textarea" || elementType == "number" || elementType == "date" 
        	            				|| elementType == "file") {
        	    				    	$('#' + namespace + paramName).parent().parent().addClass('d-none');
        	    				    } else if(elementType == "select-one" || elementType == "dropdown"){
        	    			    		$('#' + namespace + paramName).select2().parent().parent().addClass('d-none');
        	    			    	} else if(elementType == "html"){
        	    			    		$('#' + namespace + paramName).siblings().find('.note-editable').parent().parent().parent().parent().parent().addClass('d-none');
        	    			    	} else if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
        	    			    		$('input[name="'+ namespace + paramName +'"]').parent().parent().parent().parent().parent().addClass('d-none');
        	    				    } 
        	            		}
        	            	}
                    	}
                    }
                }
			});
		}
		
		createMasterForm = function(paramName, inputEl, lableEl, elementType){
			var formInputGroupDivEl, formInputGroupAppendDivEl, changeEventFn = new Object({});
			formGroupDivEl = commonFc.createDivEl('form-group df-input-form-group text-group-section');
			formInputGroupDivEl = commonFc.createDivEl('input-group df-input-group');
			formFieldLabelInputGroupErrorDivEl = commonFc.createDivEl('input-group-error', paramName+'-error');
			
			changeEventFn.fnName = 'changeElementLocale(this, false, "'+paramName+'", "'+elementType+'");';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl(paramName + 'SelectedLocale', changeEventFn);

			$(formInputGroupDivEl).append(inputEl);
			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);
			
			$(formGroupDivEl).append(lableEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			$(formGroupDivEl).append(formFieldLabelInputGroupErrorDivEl);
			
			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var formLocaleInputEl;
				formLocaleInputEl = commonFc.createInputTextEl('form-control', paramName + '_' + val.value);
				$(formLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(formLocaleInputEl);
			});

			$(inputEl).attr("onchange", "updateHiddenFieldValue(this);");
			
			return formGroupDivEl;
		};
		
		sendMasterTableData = function(tableName, columnName, valueName, paramName, createNewMappingTable, createFormMappingsTable){
			$.ajax({
			    url: getFormDataResourceURL,
			    type: "POST",
			    data:{
			    	[namespace + 'cmd']: 'populateMasterDropdown',
			    	[namespace + 'tableName']: tableName,
			    	[namespace + 'textColumn']: columnName,
			    	[namespace + 'valueColumn']: valueName
			    }, 
			    success:function(result){
					var resultObj;
					if(result){
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							var masterTableDropdownArr = resultObj.masterTableDropdownArr;
							var textColumn = resultObj.textColumn;
							var valueColumn = resultObj.valueColumn;
							$('#' + namespace + paramName).empty();
							var populateDropdownArr = [];
							$.each(masterTableDropdownArr, function(key, value){
							    var masterTable = value[textColumn];
							    if (typeof masterTable === 'object' && Object.keys(masterTable).some(key => masterTable[key] !== null)) {
							        var textValue;
							        $.each(masterTable, function(masterKey, masterValue){
							            textValue = masterValue[languageId];
							        });
							        populateDropdownArr.push({
							            "label": textValue,
							            "value": value[valueColumn] + "##" + textValue
							        });
							    } else {
							        populateDropdownArr.push({
							            "label": masterTable,
							            "value": value[valueColumn] + "##" + masterTable
							        });
							    }
							});
							populateDropdownArr.unshift({
							    "label": "-- Select --",
							    "value": ""
							});
							commonFc.populateDropdown(populateDropdownArr, $('#' + namespace + paramName));
						}else{
							console.log('Error while loading form configuration:');
						}
					}
					//to do ajax
					var editData = "";
					if(editDataJson){
						editData = JSON.parse(editDataJson);
						var recordId = editData['id'];
						ajaxToFetchMasterDataForEdit(recordId, selectedFormDefinitionId, formName, tableName, valueName, createNewMappingTable,
								createFormMappingsTable, paramName);
					}
					
			    }
			});
		};
		
		createInputGroupError = function(paramName){
			var inputGroupErrorDivEl;
			inputGroupErrorDivEl = commonFc.createDivEl('input-group-error', paramName + '-error');
			return inputGroupErrorDivEl;
		};
		
		
		createGroupHeaderEl = function(originalGroupName, modifiedGroupName) {
			var groupDivSection, groupCardDivSection, groupCardHeaderDivSection, groupHeadingSection;
			
			groupDivSection = commonFc.createDivEl('form-group group-section', modifiedGroupName.toLowerCase().replace(/ /gi, "_"));
			groupCardDivSection = commonFc.createDivEl('card mt-4');
			groupCardHeaderDivSection = commonFc.createDivEl('card-header pl-2');
			groupHeadingSection = commonFc.createHead('h3', originalGroupName);
			
			$(groupCardHeaderDivSection).append(groupHeadingSection);
			$(groupCardDivSection).append(groupCardHeaderDivSection);
			$(groupDivSection).append(groupCardDivSection);
			
			return groupDivSection;
		};
		
		createRangeEl = function(paramName, label, rangeConfig, groupAverage, overallAverage, isRequired) {
			var rangeEl, rangeHeadingLableEl, lableEl, radioButtonRow, radioButtonEl, optionsCount=0;			
			console.log('Creating Range Element...');
			rangeEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12 pt-3 pb-2');
			rangeHeadingLableEl = commonFc.createDivEl('');
			lableEl = commonFc.createLabel(paramName, label, paramName.replace(/[^\w\s]/gi, ''));
			radioButtonRow = commonFc.createDivEl('form-check-inline df-range-field');
			
			//Get the options count
			$.each(rangeConfig.options, function(key, val) {
				if(val.value > -1){
					optionsCount++;
				}
			});
			
			addAsteriskOnLable(isRequired, lableEl);
			$.each(rangeConfig.options, function(key, val) {
				console.log("Value: ", val);
//				radioButtonEl = createRadioButtonForRangeField((val.value+"_"+val.name[languageId]), val.name[languageId], paramName, groupAverage, overallAverage,
//						rangeConfig.boundaries, rangeConfig.options.length);
				radioButtonEl = createRadioButtonForRangeField((val.value+"_"+val.name[languageId]), val.name[languageId], paramName, groupAverage, overallAverage,
						rangeConfig.boundaries, optionsCount);
				$(radioButtonRow).append(radioButtonEl);
			});

			$(rangeHeadingLableEl).append(lableEl);
			$(rangeEl).append(rangeHeadingLableEl);
			$(rangeEl).append(radioButtonRow);
			
			return rangeEl;
		};
		
		dateRangPickerForPage = function(){
			jsonFieldsArray.forEach(function(jsonData) {
			   var elementType = jsonData.settings.type;
			   var elementName = jsonData.key;
			   var label = commonFc.unEscape(jsonData.label[languageId]);
			   var isMultiFile = jsonData.settings.multiple;
			   var validations = jsonData.settings.validations;
			   var status = jsonData.settings.status;
			   var isRequired = false;
			   if(jsonData.settings.hasOwnProperty('required')) {
				   isRequired = jsonData.settings.required;
			   }
			  
			   if(elementType === "datetime" || elementType === "date"){
				   var format = jsonData.settings.dateConfig.format;
				   commonFc.dateRangePickerConfig(elementType,elementName,format);
			   }else if(elementType === "time"){
				   var format = jsonData.settings.dateConfig.format;
				   var isAMPM = jsonData.settings.dateConfig.ampm ? jsonData.settings.dateConfig.ampm : false;
				   commonFc.dateRangePickerConfig(elementType,elementName,format, isAMPM);
			   }else if(elementType === "file" && isMultiFile === true){
				   var dropZoneActionObj = new Object({});
				   if(validations){
					   validations.forEach(function(jsonValidation) {
						   var validationType = jsonValidation.type;
						   var validationMessage = jsonValidation.message[languageId];
						   if(validationType === "maxfiles"){
							   var maxFiles = jsonValidation.param;
							   dropZoneActionObj.maxFiles = maxFiles;
							   dropZoneActionObj.maxFilesMessage = validationMessage;
						   } else if (validationType === "extension"){
							   var extensions = jsonValidation.param;
							   dropZoneActionObj.extensions = extensions;
							   dropZoneActionObj.extensionErrorMessage = validationMessage;
						   }
					   });
				   }
				   dropZoneActionObj.elementName = elementName;
				   dropZoneActionObj.url = dropzoneActionURL;
				   dropZoneActionObj.paramName = "attachment";
				   dropZoneActionObj.encryptDataField = attachmentId;
				   commonFc.loadMultifileDropZone(dropZoneActionObj);
			   }else if(elementType === "dropdown") {
					if(jsonData.settings.hasOwnProperty('values')) {
						var staticDropdownValuesArr = [];
						$.each(jsonData.settings.values, function(key, value){
							var staticValue = value[languageId];
							console.log('staticValue :: ',staticValue);
							staticDropdownValuesArr.push(staticValue);
						});
						commonFc.populateStaticDropdown(staticDropdownValuesArr, '#'+namespace+elementName);
					} else if(jsonData.settings.hasOwnProperty('dataProvider')) {
						var dataProviderObj = createDataProviderObj(jsonData, false);
						commonFc.populateDataProviderDropdown(dataProviderObj.url, dataProviderObj.method, dataProviderObj.headers,
								dataProviderObj.property, dataProviderObj.dataProps, '#'+namespace+elementName);
					} else if(jsonData.settings.hasOwnProperty('dependency')) {
						var dependentFieldName = jsonData.settings.dependency.fieldName;
						//applyOnChangeEvent(dependentFieldName);
						console.log('dependentFieldName >>',dependentFieldName);
						var dependentFieldType = $("[name=" + namespace + dependentFieldName + "]").prop('tagName');
						var dependentFieldValue = "";
						
						if(dependentFieldType == "SELECT") {
							dependentFieldValue =  $('#' + namespace + dependentFieldName).find(':selected').val();
							console.log('dependentFieldValue select >>',dependentFieldValue);
							applyOnChangeEvent(dependentFieldName);
						} else if(dependentFieldType == "INPUT") {
							var changeEventStr = 'getVisibleOn("' + dependentFieldName + '", true, this);';
							$("[name="+namespace+dependentFieldName+"]").attr('onchange', changeEventStr);

							dependentFieldValue = $('input[name="'+namespace+dependentFieldName+'"]').val();
							console.log('dependentFieldValue INPUT >>',dependentFieldValue);
						}
						
						if(!jQuery.isEmptyObject(dependentFieldValue) && jsonData.settings.dependency.hasOwnProperty('fieldValues')) {
							updateStaticDependentFields(dependentFieldValue, elementName, jsonData);
						} else if(!jQuery.isEmptyObject(dependentFieldValue) && jsonData.settings.dependency.hasOwnProperty('dataProvider')) {
							var dataProviderObj = createDataProviderObj(jsonData, true, $("[name="+namespace+dependentFieldName+"]"));
							commonFc.populateDataProviderDropdown(dataProviderObj.url, dataProviderObj.method, dataProviderObj.headers,
									dataProviderObj.property, dataProviderObj.dataProps, '#'+namespace+elementName);
						}
					}
					
					$('#'+namespace+elementName).select2({
						placeholder: Liferay.Language.get('dropdown-placeholder'),
						dropdownAutoWidth: true,
					});
					
			   } else if(elementType === "range" || elementType === "customRange") {
				   	var groupRangeDivSection, rangeEl, groupName = "", rangeConfig = new Object({}), groupAverage = false,
				   		overallAverage = false;
					if(jsonData.settings.hasOwnProperty('rangeConfig')) {
						rangeConfig = jsonData.settings.rangeConfig;
					}
					if(jsonData.settings.hasOwnProperty('customRangeConfig')) {
						rangeConfig = jsonData.settings.customRangeConfig;
					}		   	
					if(jsonData.settings.hasOwnProperty('group')) {
						groupName = jsonData.settings.group;
						groupName = groupName.replace(/[^a-zA-Z0-9 ]/g, "");
					}
					if(rangeConfig.hasOwnProperty('groupAverage')) {
						groupAverage = rangeConfig.groupAverage;
					}
					if(rangeConfig.hasOwnProperty('overallAverage')) {
						overallAverage = rangeConfig.overallAverage;
					}

					if($("[class=" + elementName.replace(/[^\w\s]/gi, '') + "]").length == 0 && groupName != "") {
						groupRangeDivSection = $("[id=" + namespace + groupName.toLowerCase().replace(/ /gi, "_") + "]");
						rangeEl = createRangeEl(elementName, label, rangeConfig, groupAverage, overallAverage, isRequired);
						inputGroupError = createInputGroupError(elementName.replace(/[^\w\s]/gi, ''));
						$(rangeEl).append(inputGroupError);
						if(status == 'active') {
							$(groupRangeDivSection).append(rangeEl);
						}
					}
     
					if(groupName != "" && groupAverage) {
						var localeGroupName = commonFc.getCurrentLocaleGroupName(jsonData.settings.group, languageId, groups);
						updateGroupRangeObj(localeGroupName, elementName);
					}
					
					if(overallAverage) {
						updateOverallRangeObj(elementName);
					}

					if(rangeConfig.hasOwnProperty('groupTotal') && groupName != "") {
						var localeGroupName = commonFc.getCurrentLocaleGroupName(jsonData.settings.group, languageId, groups);
						updateGroupTotalRangeObj(localeGroupName, elementName);
					}

					if(rangeConfig.hasOwnProperty('overallTotal') && rangeConfig.overallTotal) {
						updateOverallTotalRangeObj(elementName);
					}
					
			   } else if(elementType === 'html') {
					$('#' + namespace + elementName).summernote('code', '');
			   }
			  
			});
		};		
		
		applyOnChangeEvent = function(dependentFieldName) {
			var changeEventStr = 'updateDependentFields(this,"' + dependentFieldName + '");';
			$("#"+namespace+dependentFieldName).attr('onchange', changeEventStr);
		};
		
		updateDependentFields = function(curEl, paramName) {
			var dependentFieldValue = $(curEl).val();
			jsonFieldsArray.forEach(function(jsonData) {
				var elementName = jsonData.key;
				if(jsonData.settings.hasOwnProperty('dependency') && paramName == jsonData.settings.dependency.fieldName) {
					if(jsonData.settings.dependency.hasOwnProperty('fieldValues')) {
						updateStaticDependentFields(dependentFieldValue, elementName, jsonData);
					} else if(jsonData.settings.dependency.hasOwnProperty('dataProvider')) {
						var elementName = jsonData.key;
						var dataProviderObj = createDataProviderObj(jsonData, true, curEl);
						commonFc.populateDataProviderDropdown(dataProviderObj.url, dataProviderObj.method, dataProviderObj.headers,
								dataProviderObj.property, dataProviderObj.dataProps, '#'+namespace+elementName);
					}				
				}
			});
		};
		
		updateStaticDependentFields = function(dependentFieldValue, elementName, jsonData) {
			if(!jQuery.isEmptyObject(dependentFieldValue)) {
				var dependentDropdownValuesArr = [];
				$.each(jsonData.settings.dependency.fieldValues, function(key, value){
					var dependentValue = value.displayValues;
					var DFDropdownValuesArr = [];
					if(dependentFieldValue == value.fieldValue[languageId]) {
						$.each(dependentValue, function(dfKey, dfValue){
							var DFValue = dfValue[languageId];
							console.log('DFValue :: ',DFValue);
							DFDropdownValuesArr.push(DFValue);
						});
						commonFc.populateStaticDropdown(DFDropdownValuesArr, '#'+namespace+elementName);
					}
				});
			} else {
				commonFc.populateStaticDropdown(new Object([]), '#'+namespace+elementName);
			}
		};
		
		updateGroupRangeObj = function(groupName, elementName) {
			var rangeNames = new Object([]);
			if(groupRangeObj.hasOwnProperty(groupName)) {
				rangeNames = groupRangeObj[groupName];
				rangeNames.push(elementName.replace(/[^\w\s]/gi, ''));
				groupRangeObj[groupName] = rangeNames;
			} else {
				rangeNames.push(elementName.replace(/[^\w\s]/gi, ''));
				groupRangeObj[groupName] = rangeNames;
			}
		};
		
		updateOverallRangeObj = function(elementName) {
			overallRangeObj.push(elementName.replace(/[^\w\s]/gi, ''));
		};

		updateGroupTotalRangeObj = function(groupName, elementName) {
			var rangeNames = new Object([]);
			//groupTotalRangeObj.push(elementName.replace(/[^\w\s]/gi, ''));
			if(groupTotalRangeObj.hasOwnProperty(groupName)) {
				rangeNames = groupTotalRangeObj[groupName];
				rangeNames.push(elementName.replace(/[^\w\s]/gi, ''));
				groupTotalRangeObj[groupName] = rangeNames;
			} else {
				rangeNames.push(elementName.replace(/[^\w\s]/gi, ''));
				groupTotalRangeObj[groupName] = rangeNames;
			}
			console.log("groupTotalRangeObj: ", groupTotalRangeObj);
		};

		updateOverallTotalRangeObj = function(elementName) {
			overallTotalRangeObj.push(elementName.replace(/[^\w\s]/gi, ''));
		};
		
		getLayoutColomnSize = function(){
			var layoutNumber = 12;
			if(formLayoutColomn ==="col-2"){
				layoutNumber = 6;
			}else if(formLayoutColomn ==="col-3"){
				layoutNumber = 4;
			}else if(formLayoutColomn ==="col-4"){
				layoutNumber = 3;
			}
			return layoutNumber;
		};
		
		createDataProviderObj = function(jsonData, isDependentDataProvider, curEl) {
			var dataProviderObj = new Object({});
			var headerParams = new Object({});			
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('url')) {
				dataProviderObj['url'] = jsonData.settings.dependency.dataProvider.url;
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('url')) {
				dataProviderObj['url'] = jsonData.settings.dataProvider.url;
			} else {
				dataProviderObj['url'] = "";
			}
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('property')) {
				dataProviderObj['property'] = jsonData.settings.dependency.dataProvider.property;
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('property')) {
				dataProviderObj['property'] = jsonData.settings.dataProvider.property;
			} else {
				dataProviderObj['property'] = "";
			}
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('method')) {
				dataProviderObj['method'] = jsonData.settings.dependency.dataProvider.method;
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('method')) {
				dataProviderObj['method'] = jsonData.settings.dataProvider.method;
			} else {
				dataProviderObj['method'] = "";
			}
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('headers')) {
				headerParams = jsonData.settings.dependency.dataProvider.headers;
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('headers')) {
				headerParams = jsonData.settings.dataProvider.headers;
			}
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('contentType')) {
				headerParams['Content-Type'] = jsonData.settings.dependency.dataProvider.contentType;
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('contentType')) {
				headerParams['Content-Type'] = jsonData.settings.dataProvider.contentType;
			}
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('accept')) {
				headerParams['Accept'] = jsonData.settings.dependency.dataProvider.accept;
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('accept')) {
				headerParams['Accept'] = jsonData.settings.dataProvider.accept;
			}
			
			dataProviderObj['headers'] = headerParams;
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('data-props')) {
				dataProviderObj['dataProps'] = jsonData.settings.dependency.dataProvider['data-props'];
			} else if(!isDependentDataProvider && jsonData.settings.dataProvider.hasOwnProperty('data-props')) {
				dataProviderObj['dataProps'] = jsonData.settings.dataProvider['data-props'];
			} else {
				dataProviderObj['dataProps'] = [];
			}
			
			if(isDependentDataProvider && jsonData.settings.dependency.dataProvider.hasOwnProperty('source-props')) {
				var sourceProps = jsonData.settings.dependency.dataProvider['source-props'];
				var url = dataProviderObj.url;
				$.each(sourceProps, function(index, value) {
					var selectedParamVal = $(curEl).find(':selected').data(value);
					url = url.replace("{param"+(index+1)+"}", selectedParamVal);
				});
				dataProviderObj['url'] = url;
			}
			
			return dataProviderObj;
			
		};
		
		createhtmlField = function(label, paramName, isRequired, placeHolder){
			var formHtmlFieldLabelEl, formHtmlFieldTextEditorEl, formGroupDivEl, changeEventFn = new Object({});
			formHtmlFieldLabelEl = commonFc.createLabel(paramName,label);
			formHtmlFieldTextEditorEl = commonFc.createTextEditorEl('formTextEditor',paramName);
			formGroupDivEl = commonFc.createDivEl('form-group');
			if(placeHolder !== '') {
				var toDecryptDataObj = new Object({});
				toDecryptDataObj.secretPassphrase = secretPassphrase;
				toDecryptDataObj.text = placeHolder;
				var decryptedFormDescription = commonFc.decryptData(toDecryptDataObj);
				$(formHtmlFieldTextEditorEl).attr('placeholder', decryptedFormDescription); 
			}

			addAsteriskOnLable(isRequired, formHtmlFieldLabelEl);
			 
			$(formGroupDivEl).append(formHtmlFieldLabelEl);
			$(formGroupDivEl).append(formHtmlFieldTextEditorEl);

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				if(isMasterForm || val.value == "en_US") {
					var formLocaleInputEl;
					formLocaleInputEl = commonFc.createInputTextEl('form-control', paramName + '_' + val.value);
					$(formLocaleInputEl).prop('type', 'hidden');
					$(formGroupDivEl).append(formLocaleInputEl);
				}
			});

			changeEventFn.elId = paramName;
			changeEventFn.isViewMode = true;
			commonFc.initTextEditor(formHtmlFieldTextEditorEl, changeEventFn, isMasterForm);
			return formGroupDivEl;
		};

		createHTMLEditorLocaleBtn = function(paramName) {
			var formEmptyLabelEl, formGroupDivEl, formInputGroupDivEl, formInputGroupAppendDivEl, changeEventFn = new Object({});
			formGroupDivEl = commonFc.createDivEl('form-group');
			formEmptyLabelEl = commonFc.createLabel('');
			formInputGroupDivEl = commonFc.createDivEl('input-group');

			changeEventFn.fnName = 'changeElementLocale(this, true, "'+paramName+'");';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl(paramName + 'SelectedLocale', changeEventFn);

			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);
			 
			$(formGroupDivEl).append(formEmptyLabelEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			 
			return formGroupDivEl;
		};
		
		createRadioButtonField = function(value,label,paramName,defaultSelected){
            var colRadioButtonSectionEl, changeEventObj = new Object({});
            changeEventObj.fnName = 'getVisibleOn("' + paramName + '");';
            colRadioButtonSectionEl = commonFc.createInputRadioDynamicEl('form-check-label options-label', value, 'form-check-input df-radio-field', value, paramName, value, defaultSelected, changeEventObj);
            return colRadioButtonSectionEl;
		};
		
		createCheckboxButtonField = function(value,paramName,defaultSelected){
			var colCheckboxButtonSectionEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'getVisibleOn("' + paramName + '");';
			colCheckboxButtonSectionEl = commonFc.createInputCheckboxDynamicEl('form-check-label multiselect-dropdown-checkbox-label field-setting-label options-label', value, 'form-check-input multiselect-dropdown-checkbox-el', paramName, value,changeEventObj, null, defaultSelected);
			return colCheckboxButtonSectionEl;
		};

		createRadioButtonForRangeField = function(nameValCombination, name, paramName, groupAverage, overallAverage,
				boundaries, singleRangeOptionsCount) {
			var colRadioButtonSectionEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'updateRangeElAverages();';
			colRadioButtonSectionEl = commonFc.createInputRadioRangeEl('form-check-label options-label', nameValCombination, name, 'form-check-input df-range-field',
					nameValCombination, nameValCombination, paramName.replace(/[^\w\s]/gi, ''), groupAverage, overallAverage, boundaries, singleRangeOptionsCount, changeEventObj);
			return colRadioButtonSectionEl;
		};
		
        getVisibleOn = function(paramName, isUpdateDependentFields, curEl){
            var selectedValue, element;
            var visibleOnJSON = visibleOnFilteredJSON(paramName);
			if(!jQuery.isEmptyObject(visibleOnJSON)) {
				var type = visibleOnJSON[0].settings.type;
				var visibleFieldKey = visibleOnJSON[0].key;
				if(type == 'dropdown' || type == 'text' || type == 'date' || type == 'time' || type == 'datetime'){
					selectedValue = $("#" + namespace + paramName).val();
					element = $('#' + namespace + visibleFieldKey).parent().parent();
				} else if(type == 'checkbox' || type == 'dropdown' || type == 'radio' || type == 'text'){
					selectedValue = $('input[name="'+ namespace + paramName + '"]').val();
					element = $('input[name="'+ namespace + visibleFieldKey + '"]').parent().parent().parent();
				}
				console.log('element :: ', element);
				visibleOnFieldName(visibleFieldKey, visibleOnJSON, element);
			}

			if(isUpdateDependentFields) {
				updateDependentFields(curEl, paramName);
			}
        };
        
        visibleOnFilteredJSON = function(paramName){
            var filteredJSON = jsonFieldsArray.filter(function(curField) {
                if (curField.visibleOn && curField.visibleOn.fieldName) {
                    return curField.visibleOn.fieldName == paramName;
                } else {
                    return null;
                }
            });
            return filteredJSON;
        };
        
        visibleOnFieldName = function(filteredJSON, visibleOnJSON, element, selectedValue){
            if (filteredJSON && filteredJSON.length > 0) {
                var visibleOn = visibleOnJSON[0].visibleOn;
                if (visibleOn && !visibleOn.length > 0) {
                    var fieldName = visibleOn.fieldName;
                    var fieldValue = visibleOn.fieldValue;
                    if(fieldName) {
	                	if(fieldValue && fieldValue == selectedValue){
	                		element.removeClass('d-none');
	                        element.addClass('d-block');
	                	} else {
	                		element.removeClass('d-none');
	                        element.addClass('d-block');
	                	}
                    } else {
                    	element.removeClass('d-block');
                        element.addClass('d-none');
                    }
                }
            }
        };
        
		updateRangeElAverages = function() {
			$(".group-average").remove();
			
			var rowEl, groupAvgColEl, overallAvgColEl, groupTotalColEl, overallTotalColEl, groupRangeDivSection,
				groupRangeCardDivSection, groupRangeCardHeaderDivSection, groupHeadingSection, overallRangeDivSection, 
				overallRangeCardDivSection, overallRangeCardHeaderDivSection, overallHeadingSection, groupTotalDivSection, 
				groupTotalCardDivSection, groupTotalCardHeaderDivSection, groupTotalHeadingSection, overallTotalDivSection, 
				overallTotalCardDivSection, overallTotalCardHeaderDivSection, overallTotalHeadingSection, 
				overallAverageVal = 0, groupTotalObj = new Object({}), overallTotalObj = new Object({});
			
			rowEl = commonFc.createDivEl('row border form-field-row py-3 mb-2 group-average');
			
			groupAvgColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-6 col-xs-6');
			groupRangeDivSection = commonFc.createDivEl('card');
			groupRangeCardDivSection = commonFc.createDivEl('card-body');
			groupRangeCardHeaderDivSection = commonFc.createHead('h5', Liferay.Language.get('group-averages'));
			
			groupTotalColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-6 col-xs-6');
			groupTotalDivSection = commonFc.createDivEl('card');
			groupTotalCardDivSection = commonFc.createDivEl('card-body');
			groupTotalCardHeaderDivSection = commonFc.createHead('h5', Liferay.Language.get('group-total'));
			
			overallAvgColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-6 col-xs-6');
			overallRangeDivSection = commonFc.createDivEl('card');
			overallRangeCardDivSection = commonFc.createDivEl('card-body');
			overallRangeCardHeaderDivSection = commonFc.createHead('h5', Liferay.Language.get('overall-averages'));

			overallTotalColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-6 col-xs-6');
			overallTotalDivSection = commonFc.createDivEl('card');
			overallTotalCardDivSection = commonFc.createDivEl('card-body');
			overallTotalCardHeaderDivSection = commonFc.createHead('h5', Liferay.Language.get('overall-total'));
			
			$(groupRangeCardHeaderDivSection).addClass("card-title mb-1");
			$(groupTotalCardHeaderDivSection).addClass("card-title mb-1");
			$(overallRangeCardHeaderDivSection).addClass("card-title mb-1");
			$(overallTotalCardHeaderDivSection).addClass("card-title mb-1");
			
			$(groupRangeCardDivSection).append(groupRangeCardHeaderDivSection);
			$(groupTotalCardDivSection).append(groupTotalCardHeaderDivSection);
			$(overallRangeCardDivSection).append(overallRangeCardHeaderDivSection);
			$(overallTotalCardDivSection).append(overallTotalCardHeaderDivSection);
			
			//Group average Calculation
			$.each(groupRangeObj, function(key,val) {
				var groupAverageVal = 0;
				groupAverageVal = getRangeObjectAvg(val);
				if(!(/[^0-9.]/g).test(groupAverageVal)) {
					groupHeadingSection = commonFc.createHead('h6', key.toUpperCase() + ' : ' + groupAverageVal);
					$(groupHeadingSection).addClass("card-subtitle mb-2 text-muted");
					$(groupRangeCardDivSection).append(groupHeadingSection);
				}			
			});
			$(groupRangeDivSection).append(groupRangeCardDivSection);
			$(groupAvgColEl).append(groupRangeDivSection);	
			$(rowEl).append(groupAvgColEl);
			
			//GroupTotal Calculation
			$.each(groupTotalRangeObj, function(key,val) {
				var groupTotalVal = 0;
				
				groupTotalVal = getRangeElCummulativeTotal(val);
				console.log('Group Total Value: ', groupTotalVal);
				if(!(/[^0-9.]/g).test(groupTotalVal.selectedElSum)) {
					groupHeadingSection = commonFc.createHead('h6', key.toUpperCase() + ' : ' + groupTotalVal.selectedElSum);
					$(groupHeadingSection).addClass("card-subtitle mb-2 text-muted");
					
					$(groupTotalCardDivSection).append(groupHeadingSection);
				}			
			});
			$(groupTotalDivSection).append(groupTotalCardDivSection);
			$(groupTotalColEl).append(groupTotalDivSection);	
			$(rowEl).append(groupTotalColEl);
			
			//Overall Average Calculation
			overallAverageVal = getRangeObjectAvg(overallRangeObj);
			if(!(/[^0-9.]/g).test(overallAverageVal)) {
				overallHeadingSection = commonFc.createHead('h6', Liferay.Language.get('average-count') + overallAverageVal);
				$(overallHeadingSection).addClass("card-subtitle mb-2 text-muted");
				$(overallRangeCardDivSection).append(overallHeadingSection);
				$(overallRangeDivSection).append(overallRangeCardDivSection);
				$(overallAvgColEl).append(overallRangeDivSection);
				$(rowEl).append(overallAvgColEl);
			}			

			//Overall Total Calculation
			overallTotalObj = getRangeElCummulativeTotal(overallTotalRangeObj);
			var cummulativeTotalStr = Liferay.Language.get('average-cummulative-total');
			cummulativeTotalStr = cummulativeTotalStr.replace('{min_total}', overallTotalObj.minSum);
			cummulativeTotalStr = cummulativeTotalStr.replace('{max_total}', overallTotalObj.maxSum);
			/*overallTotalHeadingSection = commonFc.createHead('h6', 
				Liferay.Language.get('average-cummulative-total').replace('{average_total}', overallTotalObj.maxSum) + 
				overallTotalObj.selectedElSum);*/
			overallTotalHeadingSection = commonFc.createHead('h6', cummulativeTotalStr + overallTotalObj.selectedElSum);
			$(overallTotalHeadingSection).addClass("card-subtitle mb-2 text-muted");
			$(overallTotalCardDivSection).append(overallTotalHeadingSection);
			$(overallTotalDivSection).append(overallTotalCardDivSection);
			$(overallTotalColEl).append(overallTotalDivSection);
			$(rowEl).append(overallTotalColEl);

			$(formContainerJEL).append(rowEl);

		};
		
		getRangeObjectAvg = function(rangeObj) {
			
			var rangeObjPercentageVal = 0, selectedElCounts = 0, rangeObjAverageVal = 0;
			
			$.each(rangeObj, function(index, val) {
				if($('[name=' + namespace + val + ']:checked').length != 0) {
					var selectedElPercentage = getSingleRangeElAvg(val);
					if(selectedElPercentage){
						rangeObjPercentageVal = rangeObjPercentageVal + selectedElPercentage;
						selectedElCounts = selectedElCounts + 1;
					}
				}
			});
			if(selectedElCounts > 0){
				rangeObjAverageVal = (rangeObjPercentageVal/selectedElCounts).toFixed(2);
			}
			return rangeObjAverageVal;
			
		};
		
		getSingleRangeElAvg = function(value) {
			var selectedRadioEl = $('[name=' + namespace + value + ']:checked');
			var selectedElValue = selectedRadioEl.val().split("_")[0];
			if(selectedElValue > -1){
				var min = $(selectedRadioEl).data('min');
				var max = $(selectedRadioEl).data('max');
				var optionsCount = $(selectedRadioEl).data('options-count');
				var difference = (max-min)/(optionsCount-1);
				var selectedElPosition = (selectedElValue-min)/difference;
				var selectedElPercentage = (100/optionsCount)*(selectedElPosition+1);
				return selectedElPercentage;
			}else if(selectedElValue <= -1){
				return;
			}
		};

		getRangeElCummulativeTotal = function(rangeObj) {
			var maxSum = 0, selectedElSum = 0, cummulativeTotalObj = new Object({}), minSum = 0;
			$.each(rangeObj, function(index, val) {
				if($('[name=' + namespace + val + ']:checked').length != 0) {
					var selectedRadioEl = $('[name=' + namespace + val + ']:checked');
					var selectedElValue = selectedRadioEl.val().split("_")[0];
					if(selectedElValue > -1){
						var max = $(selectedRadioEl).data('max');
						var min = $(selectedRadioEl).data('min');
						selectedElSum = parseFloat(selectedElSum) + parseFloat(selectedElValue);
						maxSum = parseInt(maxSum) + parseInt(max);
						minSum = parseInt(minSum) + parseInt(min);
					}
				} else {
					var firstRadioEl = $('[name=' + namespace + val + ']');
					var max = $(firstRadioEl).data('max');
					var min = $(firstRadioEl).data('min');
					maxSum = parseInt(maxSum) + parseInt(max);
					minSum = parseInt(minSum) + parseInt(min);
				}
			});
			cummulativeTotalObj['minSum'] = minSum;
			cummulativeTotalObj['maxSum'] = maxSum;
			cummulativeTotalObj['selectedElSum'] = selectedElSum.toFixed(2);
			console.log("cummulativeTotalObj: ",cummulativeTotalObj);
			return cummulativeTotalObj;
		};

		changeElementLocale = function(curEl, isHTMLEl, paramName, elementType) {
			var previousSelectedLocale = '';
			var selectedLocaleText = $(curEl).text();
			var selectedLocaleHtml = '', selectedLanguage;
			if(selectedLocaleText == 'en-US'){
				selectedLocaleHtml = commonFc.getEN_USLocaleHtmlText();
				selectedLanguage = 'en_US';
			}else if(selectedLocaleText == 'ar-SA'){
				selectedLocaleHtml = commonFc.getAR_SALocaleHtmlText();
				selectedLanguage = 'ar_SA';
			}
			var selectedLanguageId = $(curEl).attr('language-id');
			var reflectOnFieldId = $(curEl).attr('reflect-on-field-id');
			var reflectOnInputFieldId = $(curEl).attr('reflect-on-field-id').replace('SelectedLocale','');
			
			var editData = "";
            if(editDataJson){
                editData = JSON.parse(editDataJson);
            }
            
			previousSelectedLocale = $("#" + namespace + reflectOnFieldId).attr('language-id');
			$("#" + namespace + reflectOnFieldId).html(selectedLocaleHtml);
			$("#" + namespace + reflectOnFieldId).attr('language-id', selectedLanguageId);

			if(isHTMLEl) {
				var previousLocaleInputVal = $("#" + namespace + reflectOnInputFieldId).summernote('code');
				$("#" + namespace + reflectOnInputFieldId + "_" + previousSelectedLocale).val(previousLocaleInputVal);
				var currentLocaleInputVal = $("#" + namespace + reflectOnInputFieldId + "_" + $(curEl).attr('language-id')).val();
				$("#" + namespace + reflectOnInputFieldId).summernote('code', currentLocaleInputVal);
			} else {
				var previousLocaleInputVal = $("#" + namespace + reflectOnInputFieldId).val();
				$("#" + namespace + reflectOnInputFieldId + "_" + previousSelectedLocale).val(previousLocaleInputVal);
				var currentLocaleInputVal = $("#" + namespace + reflectOnInputFieldId + "_" + $(curEl).attr('language-id')).val();
				$("#" + namespace + reflectOnInputFieldId).val(currentLocaleInputVal);
			}
			
			if(Object.keys(editData).length > 0 && (elementType == 'text' || elementType == "textarea")){
				var value = JSON.stringify(editData[paramName]);
				updateMasterValue(paramName, value, selectedLanguage);
			}

		};

		updateHiddenFieldValue = function(curEl) {
			var curElId = $(curEl).attr("id");
			var currentSelectedLocale = $("#" + curElId + "SelectedLocale").attr('language-id');
			$("#" + curElId + "_" + currentSelectedLocale).val($(curEl).val());
		};
		
		updateMasterValue = function(paramName, value, selectedLanguage) {
			var curEl = "#" + namespace + paramName;
			var curElId = $(curEl).attr("id");
			$("#" + curElId + "_" + selectedLanguage).val($(curEl).val());
			
			var parsedValue = JSON.parse(value);
			var masterValue = (parsedValue)[0][selectedLanguage];
			console.log('selectedLanguage in updateMasterValue :: ', selectedLanguage);
			console.log('masterValue in updateMasterValue :: ', masterValue);
			$("#" + namespace + paramName).val(masterValue);
		};

		addAsteriskOnLable = function(isRequired, lableEl) {
			if(isRequired) {
				requiredEl = commonFc.createEm('*');
				$(lableEl).append(requiredEl);
			}
		};
		
	  init = function() {
		  commonFc.initConfigVars(new Object({namespace : renderDDf.namespace, themeImagesPath : themeImagesPath, languageId : languageId}));
		  initFormRenderConfig();
        };
        
     init();
     
     renderDDf.updateRangeElAverages = updateRangeElAverages;
	}
	
	
	function formRenderDDf(config){
		console.log("In Render DDM forms...custom"+config);
		
		var namespace = config.namespace;
		contextPath = config.contextPath;
		themeImagesPath = config.themeImagesPath;
		firstNameValidator = config.firstNameValidator;
		formFieldSaveBtn = config.formFieldSaveBtn;
		jsonFieldsArray = JSON.parse(config.jsonFieldsArray);
		dfrenderFormJEL = config.dfrenderFormJEL;
		fieldDataTypeValidator = config.fieldDataTypeValidator;
		createNewConfigBtnJEL = config.createNewConfigBtnJEL;
		editConfigBtnJEL = config.editConfigBtnJEL;
		formVersionsDivJEL = config.formVersionsDivJEL;
		formVersionJEL = config.formVersionJEL;
		formNamesJEL = config.formNamesJEL;
		languageId = config.languageId;
		isMasterForm = config.isMasterForm;
		addConfigurationRenderURL = config.addConfigurationRenderURL;
		fetchFormVersionsResourceURL = config.fetchFormVersionsResourceURL;		
		selectedFormDefinitionId = config.selectedFormDefinitionId;
		kaleoDefinitionsSectionJEL = config.kaleoDefinitionsSectionJEL;
		kaleoDefinitionsJEL = config.kaleoDefinitionsJEL;
        emailTemplateSectionJEL = config.emailTemplateSectionJEL;
        emailTemplateJEL = config.emailTemplateJEL;
		workflowDefinitionJSONArr = decodeURI(config.workflowDefinitionArr);
		workflowDefinitionArr = $.parseJSON(workflowDefinitionJSONArr);
		curUserRoles = config.curUserRoles;
        deleteFileEntryJEl = config.deleteFileEntryJEl;
		
		var ruleFields = new Object({}),
		messagesFields = new Object({});
		var elementType = formLayNumber = paramName = label = isMultiFile = inputCheckboxes = isRequired = "";
		jsonFieldsArray.forEach(function(jsonData) {
			elementType = formLayNumber = paramName = label = isMultiFile = inputCheckboxes = isRequired = "";
			elementType = jsonData.settings.type; 
			formLayNumber = getLayoutColomnSize();
			paramName =jsonData.key;
			label = commonFc.unEscape(jsonData.label[languageId]);
		    isMultiFile = jsonData.settings.multiple; 
		    inputCheckboxes =jsonData.settings.values;
		    isRequired =jsonData.settings.required;
		    /*addValidatorMethods();*/
		    fieldLabelValidator =  namespace + paramName;
		    
		    var validationArr =jsonData.settings.validations;
	    	if(isRequired){
	    		ruleFields[fieldLabelValidator] = {required : isRequired};
	    		messagesFields[fieldLabelValidator] = {required : Liferay.Language.get('this-field-is-required')};
	    	}else{
	    		ruleFields[fieldLabelValidator] = {required : isRequired};
	    		messagesFields[fieldLabelValidator] = {required : ""};
	    	} 
		    
		    if(validationArr !== undefined && validationArr !== null){
	    		 validationArr.forEach(function(jsonValidation) {
				    	var validationType = jsonValidation.type;
				    	var validationMessage= jsonValidation.message[languageId];
				    	ruleFields[fieldLabelValidator][validationType]=true;
				    	if(jsonValidation.param !== undefined && jsonValidation.param !== null && jsonValidation.param !== ''){
				    		ruleFields[fieldLabelValidator][validationType]=jsonValidation.param;
				    		messagesFields[fieldLabelValidator][validationType]=validationMessage;
				    		if(validationType == "notEqualTo"){
				    			addValidatorNotEqualTo(validationMessage);
				    		}else if(validationType == "dateFormat"){
				    			addValidatorDateFormat(validationMessage);
				    		}else if(validationType == "time24"){
				    			addValidatorTime24(validationMessage);
				    		}else if(validationType == "time12"){
				    			addValidatorTime12(validationMessage);
				    		}else if(validationType == "equalTo"){
				    			addValidatorEqualTo(validationMessage);
				    		}else if(validationType == "lessThan"){
				    			addValidatorLessThan(validationMessage);
				    		}else if(validationType == "greaterThan"){
				    			addValidatorGreaterThan(validationMessage);
				    		}else if(validationType == "lessThanEqual"){
				    			addValidatorLessThanEqual(validationMessage);
				    		}else if(validationType == "greaterThanEqual"){
				    			addValidatorGreaterThanEqual(validationMessage);
				    		}else if(validationType == "min"){
				    			addValidatorMin(validationMessage);
				    		}else if(validationType == "max"){
				    			addValidatorMax(validationMessage);
				    		}else if(validationType == "minlength"){
				    			addValidatorMinLength(validationMessage);
				    		}else if(validationType == "maxlength"){
				    			addValidatorMaxLength(validationMessage);
				    		}else if(validationType == "extension"){
				    			addValidatorExtension(validationMessage);
				    		}else if(validationType == "maxsize"){
				    			addValidatorMaxSize(validationMessage);
				    		}else if(validationType == "currency"){
				    			addValidatorCurrency(validationMessage);
				    		}    
				    	}else{
				    		ruleFields[fieldLabelValidator][validationType]=true;
				    		messagesFields[fieldLabelValidator][validationType]=validationMessage;
				    		if(validationType == "nowhitespace"){
				    			addValidatorNoWhiteSpace(validationMessage);
				    		}else if(validationType == "passportNo"){
				    			addValidatorPassportNo(validationMessage);
				    		}else if(validationType == "decimalWith2Digit"){
				    			addValidatorDecimalWith2Digit(validationMessage);
				    		}else if(validationType == "decimalWith4Digit"){
				    			addValidatorDecimalWith4Digit(validationMessage);
				    		}else if(validationType == "decimalWith6Digit"){
				    			addValidatorDecimalWith6Digit(validationMessage);
				    		}else if(validationType == "url"){
				    			addValidatorURL(validationMessage);
				    		}else if(validationType == "digitsWithCommaSeparated"){
				    			addValidatorDigitsWithCommaSeparated(validationMessage);
				    		}else if(validationType == "lettersonly"){
				    			addValidatorLettersOnly(validationMessage);
				    		}else if(validationType == "email"){
				    			addValidatorEmail(validationMessage);
				    		}else if(validationType == "ipv4"){
				    			addValidatorIPV4(validationMessage);
				    		}else if(validationType == "ipv6"){
				    			addValidatorIPV6(validationMessage);
				    		}else if(validationType == "number"){
				    			addValidatorNumber(validationMessage);
				    		}else if(validationType == "digits"){
				    			addValidatorDigits(validationMessage);
				    		}else if(validationType == "letterswithbasicpunc"){
				    			addValidatorLettersWithBasicPunc(validationMessage);
				    		}else if(validationType == "currency"){
				    			addValidatorCurrency(validationMessage);
				    		}
				    		
				    	}
				 });
			  }
			
			messagesFields[fieldLabelValidator] = {required : Liferay.Language.get('this-field-is-required')};
			validateFormField = function(){
				$(dfrenderFormJEL).validate({
					ignore: [],
				    errorElement: 'span',
				    errorClass:'help-block',
					rules : ruleFields,
					messages : messagesFields,
					errorPlacement: function (error, element) {
						var curElNameAttr = $(element).attr("name");
						/*var delElement = document.querySelector('input[type="hidden"].df-multiple-file-field');
						if (delElement) {
						    // Remove the element from its parent node
							delElement.parentNode.removeChild(delElement);
						}*/
						
						if(element.hasClass('df-radio-field')){
							var parent = element.parent();
							var radioGroupSection = $(element).closest('.radio-group-section');
							$(radioGroupSection).find('#' + curElNameAttr + '-error').append(error);
						} else if(element.hasClass('multiselect-dropdown-checkbox-el')){
							var parent = element.parent();
							var checkBoxGroupSection = $(element).closest('.checkbox-group-section');
							$(checkBoxGroupSection).find('#' + curElNameAttr + '-error').append(error);
						} else if(element.hasClass('df-dropdown-field')){
                            var parent = element.parent();
                            var dropDownGroupSection = $(element).closest('.dropdown-group-section');
                            $(dropDownGroupSection).find('#' + curElNameAttr + '-error').append(error);
                        } else if(element.hasClass('df-range-field')){
                            var parent = element.parent();
                            var rangeGroupSection = $(element).closest('.range-group-section');
                            $(rangeGroupSection).find('#' + curElNameAttr + '-error').append(error);
                        } else if(element.hasClass('df-date-field')){
                            var parent = element.parent();
                            var dateGroupSection = $(element).closest('.date-group-section');
                            $(dateGroupSection).find('#' + curElNameAttr + '-error').append(error);
                        } else if(element.hasClass('df-single-file-field')){
                            var parent = element.parent();
                            var singleFileGroupSection = $(element).closest('.file-group-section');
                            $(singleFileGroupSection).find('#' + curElNameAttr + '-error').append(error);
                        } else if(element.hasClass('df-multiple-file-field')){
                            var parent = element.parent();
                            var multiFileGroupSection = $(element).closest('.multiple-file-group-section');
                            $(multiFileGroupSection).find('#' + curElNameAttr + '-error').append(error);
                        } else {
                        	var parent = element.parent();
                        	var textGroupSection = $(element).closest('.text-group-section');
                            $(textGroupSection).find('#' + curElNameAttr + '-error').append(error);
						}
					},
					highlight: function (element, errorClass) {
						if($(element).hasClass('df-radio-field')){
							var radioGroupSection = $(element).closest('.radio-group-section');
							$(radioGroupSection).find('.input-group-error').addClass('has-error');
						} else if($(element).hasClass('multiselect-dropdown-checkbox-el')){
                            var checkBoxGroupSection = $(element).closest('.checkbox-group-section');
                            $(checkBoxGroupSection).find('.input-group-error').addClass('has-error');
                        } else if($(element).hasClass('df-dropdown-field')){
                            var dropDownGroupSection = $(element).closest('.dropdown-group-section');
                            $(dropDownGroupSection).find('.input-group-error').addClass('has-error');
                        } else if($(element).hasClass('df-range-field')){
                            var dropDownGroupSection = $(element).closest('.range-group-section');
                            $(dropDownGroupSection).find('.input-group-error').addClass('has-error');
                        } else if($(element).hasClass('df-date-field')){
                            var dateGroupSection = $(element).closest('.date-group-section');
                            $(dateGroupSection).find('.input-group-error').addClass('has-error');
                        } else if($(element).hasClass('df-multiple-file-field')){
                            var multiFileGroupSection = $(element).closest('.multiple-file-group-section');
                            $(multiFileGroupSection).find('.input-group-error').addClass('has-error');
                        } else if($(element).hasClass('df-single-file-field')){
                            var singleFileGroupSection = $(element).closest('.file-group-section');
                            $(singleFileGroupSection).find('.input-group-error').addClass('has-error');
                        } else{
                        	var textGroupSection = $(element).closest('.text-group-section');
                        	$(textGroupSection).find('.input-group-error').addClass('has-error');
						}
					},
					unhighlight: function(element, errorClass, validClass) {
						
					},
					success: function (error, element) {
						error.remove();
						$(element).removeAttr('aria-describedby');
						$(element).parent().parent().removeClass('has-error');
						if($(element).hasClass('df-radio-field')){
							var parent = $(element).parent();
							var radioGroupSection = $(element).closest('.radio-group-section');
							$(parent).removeClass('has-error');
							$(radioGroupSection).find('.input-group-error').empty();
							$(radioGroupSection).find('.input-group-error').removeClass('has-error');
						}else if($(element).hasClass('df-date-field')){
							var parent = $(element).parent();
							var dateGroupSection = $(element).closest('.date-group-section');
							$(parent).removeClass('has-error');
							$(dateGroupSection).find('.input-group-error').empty();
							$(dateGroupSection).find('.input-group-error').removeClass('has-error');
						}else if($(element).hasClass('df-multiple-file-field')){
							$(element).removeAttr('aria-describedby');
							var parent = $(element).parent();
							var multipleFileGroupSection = $(element).closest('.multiple-file-group-section');
							$(parent).removeClass('has-error');
							$(multipleFileGroupSection).find('.input-group-error').removeClass('has-error');
							$(multipleFileGroupSection).find('.input-group-error').empty();
						} else if($(element).hasClass('df-single-file-field')){
							$(element).removeAttr('aria-describedby');
							var parent = $(element).parent();
							var singleFileGroupSection = $(element).closest('.file-group-section');
							$(parent).removeClass('has-error');
							$(singleFileGroupSection).find('.input-group-error').empty();
							$(singleFileGroupSection).find('.input-group-error').removeClass('has-error');
						}else if($(element).hasClass('df-dropdown-field')){
							$(element).removeAttr('aria-describedby');
							var parent = $(element).parent();
							var dropDownGroupSection = $(element).closest('.dropdown-group-section');
							$(parent).removeClass('has-error');
							$(dropDownGroupSection).find('.input-group-error').empty();
							$(dropDownGroupSection).find('.input-group-error').removeClass('has-error');
						}else{
							$(element).removeClass('error-field');
						}
					},
				});
			   };
			   initEvents = function(){
			
			   };
				init = function(){
					initEvents();
				};
				init();
				
		});
		
		validateNumberField = function(fieldKey, min, max){
			var element = $('#' + namespace + fieldKey);
			var value = $(element).val();
			$.validator.addMethod("smallerThan", function(value, element, min) {
		        return parseInt(value) <= parseInt(min);
		      }, "Please enter a value greater than '"+min+"'.");
			
			$.validator.addMethod("greaterThan", function(value, element, min) {
		        return parseInt(value) >= parseInt(min);
		      }, "Please enter a value less than '"+max+"'.");
		};
		
		$(formFieldSaveBtn).click(function(){
			var elementType, fieldKey, min, max;
			validateFormField();
			var deleteFileJson = JSON.stringify(deleteFileEntryJson);
            console.log("deleteFileJson :: ",deleteFileJson);
            $(deleteFileEntryJEl).val(deleteFileJson);
			jsonFieldsArray.forEach(function(jsonData) {
				elementType = jsonData.settings.type; 
				fieldKey = jsonData.key;
				multiple = jsonData.settings.multiple; 
				isRequired = jsonData.settings.required; 
				
				if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
					var attrCheck = $('input[name="'+ namespace + fieldKey +'"]').attr('readonly');
					var classCheck = $('input[name="'+ namespace + fieldKey +'"]').parent().parent().parent().parent().parent().hasClass('d-none');
					if (typeof attrCheck !== 'undefined' && attrCheck !== false) {
						$('input[name="'+ namespace + fieldKey +'"]').rules('remove');
					} if (typeof classCheck !== 'undefined' && classCheck !== false) {
						$('input[name="'+ namespace + fieldKey +'"]').rules('remove');
					} 
				} else {
					var attrCheck = $('#' + namespace + fieldKey).attr('readonly');
					var classCheck = false;
					if (typeof attrCheck !== 'undefined' && attrCheck !== false) {
						$('#' + namespace + fieldKey).rules('remove');
					} 
					
					if(elementType == "text" || elementType == "password" || elementType == "textarea" || elementType == "number" || elementType == "date" ||
							elementType == "file"){
						classCheck = $('#' + namespace + fieldKey).parent().parent().hasClass('d-none');
					} else if(elementType == "select-one" || elementType == "dropdown"){
						classCheck = $('#' + namespace + fieldKey).select2().parent().parent().hasClass('d-none');
					} else if(elementType == "html"){
						classCheck = $('#' + namespace + fieldKey).siblings().find('.note-editable').parent().parent().parent().parent().parent().hasClass('d-none');
			    	}
					
					if(typeof classCheck !== 'undefined' && classCheck !== false){
						$('#' + namespace + fieldKey).rules('remove');
					}
				}
				if(jsonData.settings.hasOwnProperty('min')){
					min = jsonData.settings.min;
				}
				if(jsonData.settings.hasOwnProperty('max')){
					max = jsonData.settings.max;
				}
				if(elementType == 'file' && !multiple && (deleteFileJson == '{}' || deleteFileJson != null || deleteFileJson != '' || deleteFileJson[fieldKey] == undefined) && isRequired){
					$('#' + namespace + fieldKey).rules('remove','required');
				} else if(elementType == 'file' && multiple && deleteFileJson == '{}' && deleteFileJson != null && deleteFileJson != '' && deleteFileJson[fieldKey] == undefined && isRequired){
					$('#' + namespace + fieldKey).rules('remove','required');
				} else if(elementType == 'file' && !multiple && deleteFileJson == '{}' && deleteFileJson == null && deleteFileJson[fieldKey] != undefined && isRequired){
					$('#' + namespace + fieldKey).rules('add','required');
				}
				var encryptVal = $(attachmentId).val();
				console.log('encryptVal :: ', encryptVal);
				if(elementType == 'file' && multiple && encryptVal){
					console.log('inside if encryptVal :: ');
					$('input[name="' + namespace + fieldKey+'"]').val('1');
					console.log('Id encryptVal :: ',$('input[id="'+namespace + fieldKey+'"]').val());
				}
			});
			if(elementType == 'number'){
				validateNumberField(fieldKey, min, max);
			}
			var isValid = false;
			isValid = $(dfrenderFormJEL).valid();
			if(isValid){
				console.log(htmlKeys);
				for (htmlField of htmlKeys) {
					var htmlJson = {};
					var htmlFieldMultiLingualDataObj = new Object({});
					$.each(commonFc.currentAvailableLocales, function(index, val) {						 
						var encryptedData = getEncryptedData($("#"+ namespace + htmlField + "_" + val.value).val());
						htmlFieldMultiLingualDataObj[val.value] = encryptedData;						
					});
					htmlJson.key = htmlField;
					if(isMasterForm) {
						htmlJson.value = htmlFieldMultiLingualDataObj;
					} else {
						htmlJson.value =  getEncryptedData($("#"+ namespace + htmlField).summernote('code'));
					}					
					htmlArray.push(htmlJson); 
				}
				$(htmlData).val(JSON.stringify(htmlArray));
				$(dfrenderFormJEL).submit();
			}
		});

		getDecryptedData = function(data) {
			var decryptedData = '';
			if(data != '') {
				var toDecryptDataObj = getEncryptDecryptDataObj(data);
				decryptedData = commonFc.decryptData(toDecryptDataObj);
			}
			return decryptedData;
		};
		
		getEncryptedData = function(data) {
			var encryptedData = '';
			if(data != '') {
				var toEncryptDataObj = getEncryptDecryptDataObj(data);
				encryptedData = commonFc.encryptData(toEncryptDataObj);
			}
			return encryptedData;
		};

		getEncryptDecryptDataObj = function(data) {
			var toEncryptDataObj = new Object({});

			toEncryptDataObj.secretPassphrase = secretPassphrase;
			toEncryptDataObj.text = data;

			return toEncryptDataObj;
		}

		function addValidatorNumber(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				number: validationMessage
			});
		}
		function addValidatorDigits(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				digits: validationMessage,
			});
		}
		function addValidatorLettersOnly(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				lettersonly: validationMessage,
			});
		}
		function addValidatorEmail(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				email: validationMessage,
			});
		}
		function addValidatorIPV4(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				ipv4: validationMessage,
				
			});
		}
		function addValidatorIPV6(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				ipv6: validationMessage,
				
			});
		}
		function addValidatorMaxLength(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				maxlength: validationMessage,
			});
		}
		function addValidatorMinLength(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				minlength: validationMessage,
			});
		}
		function addValidatorExtension(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				extension: validationMessage,
				
			});
		}
		function addValidatorMaxSize(validationMessage){
			jQuery.extend(jQuery.validator.messages, {
				maxsize: validationMessage,
			});
		}
		function addValidatorLettersWithBasicPunc(validationMessage){
			$.validator.addMethod('letterswithbasicpunc', function(value, element) {
				var pattern = /^[a-zA-Z](\-.,()'"\s)$/;
			    return this.optional(element) || pattern.test(value);
			  }, validationMessage);
		}
		function addValidatorCurrency(validationMessage){
			$.validator.addMethod('currency', function(value, element) {
				var pattern = /^\$?[1-9]\d?(?:,\d{3})*(?:\.\d{2})?$/;
			    return this.optional(element) || pattern.test(value);
			  }, validationMessage);
		}
		function addValidatorNoWhiteSpace(validationMessage){
			 $.validator.addMethod('nowhitespace', function(value, element) {
				    return this.optional(element) || /^\S+$/i.test(value);
				  }, validationMessage);
		}
		function addValidatorPassportNo(validationMessage){
			$.validator.addMethod ("passportNo", function (value, element) {
				 var pattern = /^(?!^0+$)[a-zA-Z0-9]{6,9}$/;
				    return this.optional(element) || pattern.test(value);
			 	}, validationMessage);
		}
		function addValidatorDateFormat(validationMessage){
			$.validator.addMethod("dateFormat", function(value, element,param) {
				 return this.optional(element) || moment(value,param).isValid();
			    }, validationMessage);
		}
		function addValidatorTime24(validationMessage){
			$.validator.addMethod("time24", function(value, element,param) {
				 return this.optional(element) || moment(value,param).isValid();
			    }, validationMessage);
		}
		function addValidatorTime12(validationMessage){
			 $.validator.addMethod("time12", function(value, element,param) {
				 return this.optional(element) || moment(value,param).isValid();
			    }, validationMessage);
		}
		function addValidatorDecimalWith2Digit(validationMessage){
			 $.validator.addMethod('decimalWith2Digit', function(value, element) {
				  return this.optional(element) || /^((\d+(\\.\d{0,2})?)|((\d*(\.\d{1,2}))))$/.test(value);
				}, validationMessage);
		}
		function addValidatorDecimalWith4Digit(validationMessage){
			 $.validator.addMethod('decimalWith4Digit', function(value, element) {
				 return this.optional(element) || /^\d{0,4}(\.\d{0,4})?$/i.test(value);
				}, validationMessage);
		}
		function addValidatorDecimalWith6Digit(validationMessage){
			 $.validator.addMethod('decimalWith6Digit', function(value, element) {
				 return this.optional(element) || /^\d{0,4}(\.\d{0,6})?$/i.test(value);
				}, validationMessage);
		}
		function addValidatorEqualTo(validationMessage){
			$.validator.addMethod("equalTo", function(value, element, param) {
				return value == $('#' + namespace + param.toLowerCase()).val();
				}, validationMessage);

		}
		function addValidatorNotEqualTo(validationMessage){
			$.validator.addMethod("notEqualTo", function(value, element, param) {
				return value != $('#' + namespace + param.toLowerCase()).val();
				}, validationMessage);
		}
		function addValidatorLessThan(validationMessage){
			$.validator.addMethod("lessThan", function(value, element, param) {
			    return value < param;
			  }, validationMessage);
		}
		function addValidatorGreaterThan(validationMessage){
			$.validator.addMethod("greaterThan", function(value, element, param) {
			    return value > param;
			  }, validationMessage);
		}
		function addValidatorLessThanEqual(validationMessage){
			$.validator.addMethod("lessThanEqual", function(value, element, param) {
			    return value <= param;
			  }, validationMessage);
		}
		function addValidatorGreaterThanEqual(validationMessage){
			$.validator.addMethod("greaterThanEqual", function(value, element, param) {
			    return value >= param;
			  }, validationMessage);
		}

		function addValidatorMin(validationMessage){
			$.validator.addMethod("min", function(value, element, param) {
			    return value >= param;
			  }, validationMessage);
		}
		function addValidatorMax(validationMessage){
			 $.validator.addMethod("max", function(value, element, param) {
				    return value <= param;
				  }, validationMessage);
		}
		
		function addValidatorURL(validationMessage){
			$.validator.addMethod("url", function(value, element, param) {
				var urlregex = new RegExp("^(http:\/\/www.|https:\/\/www.|ftp:\/\/www.|www.){1}([0-9A-Za-z]+\.)");
				return urlregex.test(value);
			  }, validationMessage);
		}
		function addValidatorDigitsWithCommaSeparated(validationMessage){
			$.validator.addMethod("digitsWithCommaSeparated", function (value, element) 
				{
				  return this.optional(element) || /^\d+(,\d+)*$/.test(value); 
				}, validationMessage); 
		}

		$(createNewConfigBtnJEL).on('click', function(){
			var formDefinitionId = 0;
			var addConfigurationURL = addConfigurationRenderURL;
			addConfigurationURL = addConfigurationURL.replace(Liferay.Language.get('selected-form-definition-id-text'), formDefinitionId);
			window.location.href = addConfigurationURL;
		});

		$(editConfigBtnJEL).on('click', function(){
			var formNameJEl = $(formVersionJEL).find(":selected");
			var formDefinitionId = 0;
			if(formNameJEl && $(formNameJEl).data(Liferay.Language.get('form-definition-id'))){
				formDefinitionId = $(formNameJEl).data(Liferay.Language.get('form-definition-id'));
			}
			var addConfigurationURL = addConfigurationRenderURL;
			var formDefinitionIdFromPreferences = selectedFormDefinitionId;
			addConfigurationURL = addConfigurationURL.replace(Liferay.Language.get('selected-form-definition-id-text'), formDefinitionIdFromPreferences);
			console.log('addConfigurationURL: ',addConfigurationURL);
			window.location.href = addConfigurationURL;
		});

		$(formNamesJEL).change(function(){
			console.log("workflowDefinition in js: ",workflowDefinitionArr);
			var formName = this.value;
			$.ajax({
				url: fetchFormVersionsResourceURL,
				type : Liferay.Language.get('post'),
				data : {
					"formName" : formName,
				},
				success : function(res) {
					console.log("Data: ",res);
					if(res.trim() != ''){
						var formData = JSON.parse(res);
						$(formVersionJEL).find('option').remove();
						var formVersionOptionsEl = "<option value=''>--Select--</option>";
						$(formVersionJEL).append(formVersionOptionsEl);
						if(formData.length != 0) {
							$.each(formData, function(key,value) {
								commonFc.addOptionValue(value, formVersionJEL, Liferay.Language.get('form-version-key'),
									[Liferay.Language.get('form-definition-id')]);
							}); 
							$(formVersionsDivJEL).removeClass("d-none");
						} else {
							$(formVersionsDivJEL).addClass("d-none");
						}
					}
					
				},
				error : function(e) {
					console.log('API Error: '+ e);
				}		
			});
			
			if(workflowDefinitionArr && workflowDefinitionArr.length > 0){
				$(kaleoDefinitionsSectionJEL).removeClass("d-none");
				$(kaleoDefinitionsSectionJEL).addClass("d-block");
				commonFc.populateDropdown(workflowDefinitionArr, kaleoDefinitionsJEL);
			}
			
		});
		
		$(kaleoDefinitionsJEL).change(function(){
			var selectedWorkflow = $(kaleoDefinitionsJEL).val();
			if(selectedWorkflow != null && selectedWorkflow != undefined && selectedWorkflow != ''){
				$(emailTemplateSectionJEL).removeClass("d-none");
				$(emailTemplateSectionJEL).addClass("d-block");
			} else {
				$(emailTemplateSectionJEL).removeClass("d-block");
				$(emailTemplateSectionJEL).addClass("d-none");
			}
		});
		
	}
	
	

	function formConfigActions(config) {
		var namespace = config.namespace;
		contextPath = config.contextPath;
		themeImagesPath = config.themeImagesPath;
		createNewConfigBtnJEL = config.createNewConfigBtnJEL;
		addConfigurationRenderURL = config.addConfigurationRenderURL;
		backPreviewURL = config.backPreviewURL;
		formDataJson = config.formDataJson;
		dataTableJEl = config.dataTableJEl;
		dataTableBodyJEL = config.dataTableBodyJEL;
		dfLoaderJEL = config.dfLoaderJEL;
		formsDataJson = config.formsDataJson;
		curUserRoles = config.curUserRoles;
		previewFormURL = config.previewFormURL;
		fetchFormVersionsResourceURL = config.fetchFormVersionsResourceURL;
		previewFormVersionJEl = config.previewFormVersionJEl;
		previewVersionSelectionModalJEL = config.previewVersionSelectionModalJEL;
		previewFormBtnJEl = config.previewFormBtnJEl;
		noVersionModalJEl = config.noVersionModalJEl;
		noVersionModalBtnJEl = config.noVersionModalBtnJEl;
		newVersionFormDefinitionURL = config.newVersionFormDefinitionURL;

		$(createNewConfigBtnJEL).on('click', function(){
			var formDefinitionId = 0;
			var addConfigurationURL = addConfigurationRenderURL;
			addConfigurationURL = addConfigurationURL.replace(Liferay.Language.get('selected-form-definition-id-text'), formDefinitionId);
			window.location.href = addConfigurationURL;
		});

		initializeDataTable = function() {
			console.log("Initializing Data Table...");
			var index = 1;
			if(formsDataJson){
				$.each(JSON.parse(formsDataJson), function(key, value) {
					var trEl, indexEl, formNameEL, formVersionEl, editEl, formStatus, formVersionTxt = '', formStatusTdEl,
					formStatusEl, formStatusSpanEl;
					trEl = commonFc.createTREl();

					$.each(value, function(key1, value1) {
						formVersionTxt = formVersionTxt + value1.version + ",";
						formStatus = value1.status;
						formDefinitionId = key1;
					});

					indexEl = commonFc.createTDEl(index);
					formNameEL = commonFc.createTDEl(key);
					formVersionEl = commonFc.createTDEl(formVersionTxt.substring(0,formVersionTxt.length - 1));
					formStatusEl = commonFc.createTDEl();
					formStatusSpanEl = getFormStatus(formStatus, formStatusEl);
					formStatusTdEl=(formStatusEl).append(formStatusSpanEl);
					console.log("formStatus::", formStatus);
					if(formStatus == "approved" || formStatus == "denied" || formStatus == "any"){
						editEl = "<td>" +
										"<a class='ml-1 mr-3' data-form-definition-id ='"+ formDefinitionId +"' href='javascript:void(0);' onClick='addNewFormVersion(this);'> <span><i class='fa fa-edit'></i></span> </a>" +
										'<a class="ml-1 mr-3" data-form-definition-id ="'+ formDefinitionId +'" href="javascript:void(0);" onClick="openPreviewFormUrl(\''+key+'\');"> <span><i class="fa fa-eye"></i></span> </a>' +
								"</td>";
					}else{
						editEl = "<td></td>"
					}
					$(trEl).append(indexEl);
					$(trEl).append(formNameEL);
					$(trEl).append(formVersionEl);
					$(trEl).append(formStatusTdEl);
					$(trEl).append(editEl);

					$(dataTableBodyJEL).append(trEl);
					index = index + 1;
				});
			}
			$(dataTableJEl).DataTable({
				"iDisplayLength" : 10,
				"bLengthChange" : false,
				"aoColumnDefs": [
					{ 
					  "bSortable": false, 
					  "aTargets": [ -1 ]
					} 
				]
			});	
			$(dfLoaderJEL).addClass("d-none");
		};

		getFormStatus = function(formStatus){
			var formStatusSpanEl;
			if(formStatus=="approved"){
				formStatusSpanEl = commonFc.createWorkflowSpanEl("workflow-status", "label status workflow-status-approved approved workflow-value", Liferay.Language.get('approved'));
			}else if(formStatus=="denied"){
				formStatusSpanEl = commonFc.createWorkflowSpanEl("workflow-status", "label status workflow-status-denied denied workflow-value", Liferay.Language.get('rejected'));
			}else if(formStatus=="draft"){
				formStatusSpanEl = commonFc.createWorkflowSpanEl("workflow-status", "label status workflow-status-pending pending workflow-value", Liferay.Language.get('draft'));
			}else if(formStatus=="incomplete"){
				formStatusSpanEl = commonFc.createWorkflowSpanEl("workflow-status", "label status workflow-status-incomplete incomplete workflow-value", Liferay.Language.get('incomplete'));
			} else if(formStatus=="any"){
				formStatusSpanEl = commonFc.createWorkflowSpanEl("workflow-status", "label status workflow-status-incomplete incomplete workflow-value", Liferay.Language.get('inprogress'));
			}
			return formStatusSpanEl;
		};
		
		$(noVersionModalBtnJEl).click(function(){
			$(noVersionModalJEl).modal('hide');
		});
		
		$(previewFormBtnJEl).click(function(){
			var formDefinitionId = $(previewFormVersionJEl).val();
			var formPreviewURL = previewFormURL;
			formPreviewURL = formPreviewURL.replace('SELECTED_FORM_DEFINITION_ID', formDefinitionId);
			$(previewVersionSelectionModalJEL).modal('hide');
			window.open(formPreviewURL, "_blank");
		});
		
		openPreviewFormUrl = function(formName){
        	console.log('formName: ',formName);
        	var formPreviewURL = previewFormURL;
        	$.ajax({
			    url: fetchFormVersionsResourceURL,
			    type: "POST",
			    data:{
			    	[namespace + 'formName'] : formName
				},
				success : function(res) {
					console.log("Data: ",res);
					if(res.trim() != ''){
						var formData = JSON.parse(res);
						if(formData.length != 0 && formData.length > 1) {
							$(previewVersionSelectionModalJEL).modal('show');
							$(previewFormVersionJEl).empty();
							$.each(formData, function(key,value) {
								console.log('key--'+ key + '-- value -- '+ value);
								var option = $("<option>");
						        $(option).text(value.formVersion);
						        $(option).val(value.formDefinitionId);
						        $(previewFormVersionJEl).append(option);
							}); 
						} else if (formData.length == 1){
							formPreviewURL = formPreviewURL.replace('SELECTED_FORM_DEFINITION_ID', formDefinitionId);
							window.open(formPreviewURL, "_blank");
						} else {
							$(noVersionModalJEl).modal('show');
						}
						
					}
				},
				error : function(e) {
					console.log('API Error: '+ e);
				}
			});
			//window.location.href = formPreviewURL;
			//window.open(formPreviewURL, "_blank");
        }
		
		addNewFormVersion = function(curEl){
			var formDefinitionId = $(curEl).data('form-definition-id');
			var addNewFormVersionURL = addConfigurationRenderURL;
			$(dfLoaderJEL).removeClass("d-none");
			$.ajax({
			    url: newVersionFormDefinitionURL,
			    type: "POST",
			    data:{
			    	[namespace + 'formDefinitionId']: formDefinitionId,
			    }, 
			    success:function(result){
			    	$(dfLoaderJEL).addClass("d-none");
					if(result){
						var resultObj = JSON.parse(result);
						if(resultObj && resultObj.status == 'success'){
							addNewFormVersionURL = addNewFormVersionURL.replace(Liferay.Language.get('selected-form-definition-id-text'), resultObj.formDefinitionId);
							window.location.href = addNewFormVersionURL;
						}
					}
			    }
			});
			
		};
		initializeDataTable();
	}
	
	function editDDf(editDDf){
		console.log('in edit ddf');
		var namespace = editDDf.namespace;
		contextPath = editDDf.contextPath,
		themeImagesPath = editDDf.themeImagesPath,
		formName = editDDf.formName,
		isMasterForm = editDDf.isMasterForm,
		jsonFieldsArray = JSON.parse(editDDf.jsonFieldsArray);
		attachmentId = editDDf.attachmentId;
		htmlData = editDDf.htmlData;
		secretPassphrase = editDDf.secretPassphrase;
		languageId = editDDf.languageId;
		editDataJson = editDDf.editDataJson;
		getMasterDataResourceURL = editDDf.getMasterDataResourceURL;
		selectedFormDefinitionId = editDDf.selectedFormDefinitionId;
        fileJson = editDDf.fileJson;
        curUserRoles = editDDf.curUserRoles;
        isAdmin = editDDf.isAdmin;
        selectedRecordId = editDDf.selectedRecordId;
		init = function() {
			commonFc.initConfigVars(new Object({namespace : editDDf.namespace, themeImagesPath : editDDf.themeImagesPath, languageId : editDDf.languageId}));
			console.log('after initConfigVars');
			var editData = "";
			if(editDataJson){
				editData = JSON.parse(editDataJson);
			}
			console.log('editData :: ',editData);
			console.log('curUserRoles :: ', curUserRoles);
			jsonFieldsArray.forEach(function(jsonData) {
				var elementType = jsonData.settings.type; 
				var fieldKey = jsonData.key;
				var permissionObj = jsonData.permissions;
				console.log('permissionObj--',permissionObj);
				var add = false;
				var edit = false;
				if(permissionObj){
					var curUserRolesArr = JSON.parse(curUserRoles);
					$.each(curUserRolesArr, function( index, value ) {
						if(permissionObj.hasOwnProperty(value)){
							if(!add && permissionObj[value].add == true){
								add = permissionObj[value].add;
							}
							if(!edit && permissionObj[value].edit == true){
								edit = permissionObj[value].edit;
							}
						}
					});
				} else {
					console.log('no permissions given');
				}
				
				var isPermission = false;
				if(editData[fieldKey] == '' || editData[fieldKey] == '{}'){
					if(add){
						isPermission = true;
					}
				} else {
					if(edit){
						isPermission = true;
					}
				}
				console.log('isPermission -- edit case -- ', isPermission);
				console.log('isadmin :: ',isAdmin);
	            if(isAdmin == "false"){
	            	if(isPermission){
	        			if(elementType == "text" || elementType == "password" || elementType == "textarea" || elementType == "number" || elementType == "date" || elementType == "file") {
					    	$('#' + namespace + fieldKey).attr('readonly',false);
					    } else if(elementType == "html"){
				    		$('#' + namespace + fieldKey).siblings().find('.note-editable').attr('readonly', false);
				    	} else if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
				    		$('input[name="'+ namespace + paramName +'"]').attr('readonly',false);
    			    		$('input[name="'+ namespace + paramName +'"]').each(function( index ){
    			    			$('label[for="'+this.id+'"]').attr('readonly',false);
    			    		});
					    } else if(elementType == "select-one" || elementType == "dropdown"){
					    	$('#' + namespace + paramName).select2().enable(true);
				    	} 
	        		} else {
	        			if(elementType == "text" || elementType == "textarea" || elementType == "number" || elementType == "date" || elementType == "file") {
					    	$('#' + namespace + fieldKey).attr('readonly',true);
					    } else if(elementType == "html"){
				    		$('#' + namespace + fieldKey).siblings().find('.note-editable').attr('readonly', true);
				    	} else if(elementType == 'radio' || elementType == 'range' || elementType == 'checkbox' || elementType == 'customRange') {
				    		$('input[name="'+ namespace + paramName +'"]').attr('readonly',true);
    			    		$('input[name="'+ namespace + paramName +'"]').each(function( index ){
    			    			$('label[for="'+this.id+'"]').attr('readonly',true);
    			    		});
					    } else if(elementType == "select-one" || elementType == "dropdown"){
					    	$('#' + namespace + paramName).select2().enable(false);
				    	}
	        		}
	            }
				if(Array.isArray(editData[fieldKey]) && (elementType == 'text' || elementType == "textarea")){
					var value = JSON.stringify(editData[fieldKey]);
					$("#" + namespace + fieldKey).attr("onchange", "updateMasterValue('"+fieldKey+"', '"+value+"', '"+languageId+"');").trigger('change');
				} else if(Array.isArray(editData[fieldKey]) && (elementType == 'html')){
					if(isMasterForm) {
						if(editData[fieldKey]){
							var parsedValue = JSON.parse(JSON.stringify(editData[fieldKey]));
							$.each(commonFc.currentAvailableLocales, function(index, val) {
								var data = (parsedValue)[0][val.value];
								if(data != '' && data != undefined) {
									var decryptedMasterValue = getDecryptedData(data);
									$("#" + namespace + fieldKey + "_" + val.value).val(decryptedMasterValue);

									if(val.value == "en_US") {
										$('#'+ namespace + fieldKey).summernote('code',decryptedMasterValue);
									}
								}
							});
						}
					} else {
						if(editData[fieldKey] && editData[fieldKey] != "{}") {
							var parsedValue = editData[fieldKey];
							var decryptedMasterValue = getDecryptedData(parsedValue);
							$('#'+ namespace + fieldKey).summernote('code',decryptedMasterValue);
						}
					}
				}
				
				if(elementType == 'text' || elementType == "textarea" || elementType == "number"|| elementType == "password" || elementType == "rangePicker"){
					$("#" + namespace + fieldKey).val(editData[fieldKey]).trigger('change');
				} else if(elementType == "dropdown" || elementType == "select-one"){
					var master = jsonData.settings.master;
					if(master){
						var tableName = master.masterTable;
						var columnName = master.textColumn;
						var valueName = master.valueColumn;
						var createNewMappingTable = master.createNewMappingTable;
						var createFormMappingsTable = master.createFormMappingsTable;
						var recordId = editData['id'];
						//Ajax call for fetching master data
						ajaxToFetchMasterDataForEdit(recordId, selectedFormDefinitionId, formName, tableName, valueName, createNewMappingTable,
								createFormMappingsTable, fieldKey);
					} else {
						console.log('value :: ',editData[fieldKey]);
						$('#'+ namespace + fieldKey).val(editData[fieldKey]).trigger('change');
					} 
		    		
		    	} else if(elementType == "radio") {
			    	$('input[name="'+namespace + fieldKey+ '"][value="'+editData[fieldKey]+'"]').addClass('checked').prop('checked', true);
			    	$('input[name="'+namespace + fieldKey+ '"][value="'+editData[fieldKey]+'"]').trigger('change');
			    } else if(elementType == "range" || elementType == "customRange") {
			    	var editRange = JSON.parse(atob(editData[fieldKey]));
			    	console.log('edit range Data ::', editRange);
			    	var maxRangeCharacter;
			    	if(elementType == "customRange" && jsonData.settings.hasOwnProperty('customRangeConfig')){
			    		maxRangeCharacter = jsonData.settings.customRangeConfig.maxRangeCharacter; 
			    	} else if(elementType == "range" && jsonData.settings.hasOwnProperty('rangeConfig')){
			    		maxRangeCharacter = jsonData.settings.rangeConfig.maxRangeCharacter; 
			    	}
			    	$('input[name="'+namespace + fieldKey+ '"][value="'+editRange.value + "_" + editRange.text +'"]').addClass('checked').prop('checked', true);
			    	$('input[name="'+namespace + fieldKey+ '"][value="'+editRange.value + "_" + editRange.text +'"]').trigger('change');
			    	if(editRange.comment != null && editRange.comment != '' && editRange.comment != undefined){
			    		$('#' + namespace + 'rangeComment_' + fieldKey).val(editRange.comment);
			    	}
			    	if(maxRangeCharacter != null && maxRangeCharacter != '' && maxRangeCharacter != undefined){
			    		var lengthMaxCharacter = $('#' + namespace + 'rangeComment_' + fieldKey).val().length;
			    		maxRangeCharacter = maxRangeCharacter - lengthMaxCharacter;
			    		console.log('maxRangeCharacter in editDDf ::::: ', maxRangeCharacter);
			    		$("#" + namespace + "rangeMaxLabel_"+ fieldKey).text('Remaning characters : ' +maxRangeCharacter);
			    		updateCharCount('#' + namespace + 'rangeComment_' + fieldKey, "#" + namespace + "rangeMaxLabel_"+ fieldKey ,maxRangeCharacter);
			    	}
			    } else if(elementType == "checkbox"){
					var checkboxArr = editData[fieldKey].split(',');
					for(var i = 0; i < checkboxArr.length; i++){
						$('#'+ namespace + checkboxArr[i] + '_' + fieldKey).prop('checked', true);
						$('#'+ namespace + checkboxArr[i] + '_' + fieldKey).trigger('change');
					}
		    	} else if(elementType == 'html'){
			    	if(editData[fieldKey]){
			    		var toDecryptDataObj = new Object({});
						toDecryptDataObj.secretPassphrase = secretPassphrase;
						toDecryptDataObj.text = editData[fieldKey];
				    	var decryptedValue = commonFc.decryptData(toDecryptDataObj);
				    	$('#'+ namespace + fieldKey).summernote('code',decryptedValue);
			    	}
                } else if(elementType == 'file'){
                    var fileData, elementKey, fileName, url, fileEntryId;
                    var multiple = jsonData.settings.multiple;
                    
                    if(fileJson){
                        fileData = JSON.parse(fileJson);
                    }
                    $.each(fileData, function(key, value) {
                        if(fieldKey == key){
                            $.each(value, function(fileEntryId, fileEntryData) {
                                var fileEntryJson = {}, value;
                                fileName = fileEntryData.fileName;
                                url = fileEntryData.url;
                                var id = fieldKey + '_' + fileEntryId;
                                var elementId = $('#' + namespace + fieldKey);
                                var fileEditDivEl = createDivEl('file-edit-div', id);
                                if(multiple && elementId.length > 0){
                                    $(fileEditDivEl).append('<a href="' + url + '">' + fileName + '</a>').append('<i class="fa fa-trash delete-btn-icon" style="padding-left:10px"></i>');
                                    multipleFileEntryIds.push(fileEntryId);
                                    console.log('multipleFileEntryIds: ', multipleFileEntryIds);
                                } 
                                if(!multiple && elementId.length > 0) {
                                    $(fileEditDivEl).append('<a href="' + url + '">' + fileName + '</a>').append('<i class="fa fa-trash delete-btn-icon" style="padding-left:10px"></i>');
                                    $(elementId).hide();
                                    singleFileEntryIds.push(fileEntryId);
                                    console.log('singleFileEntryIds: ', singleFileEntryIds);
                                }
                                $(elementId).parent().append(fileEditDivEl);
                                $(fileEditDivEl).on('click', '.delete-btn-icon', function() {
                                	deleteFileEntryJson[fieldKey] = [];
                                	console.log("fileEntryId >>> ", fileEntryId);
                                	if(confirm("Are you sure you want to delete file"+fileName+"?")){
                                		$(fileEditDivEl).remove();
                                		if(!multiple){
                                			$(elementId).show();
                                		}
                                		fileEntryJson = {
                                              "fileEntryId": fileEntryId
                                		};
                                		deleteFileEntryJson[fieldKey].push(fileEntryJson);
                                		console.log('deleteFileEntryJson :: ',deleteFileEntryJson);
                                		var fileEntryIdToRemove = fileEntryJson.fileEntryId;
                                		var indexMultiple = multipleFileEntryIds.indexOf(fileEntryIdToRemove);
                                		if (indexMultiple !== -1) {
                                		  multipleFileEntryIds.splice(indexMultiple, 1);
                                		}
                                		var indexSingle = singleFileEntryIds.indexOf(fileEntryIdToRemove);
                                		if (indexSingle !== -1) {
                                		  singleFileEntryIds.splice(indexSingle, 1);
                                		}
                                		console.log('multipleFileEntryIds after removal: ', multipleFileEntryIds);
                                		console.log('singleFileEntryIds after removal: ', singleFileEntryIds);
                                	}	
                                	else{
                                		return false;
                                	}
                                });
                                
                            });
                            if(multiple){
                            	$('input[name="' + namespace + fieldKey + '"]').val(multipleFileEntryIds);
                            } 
                        }
                    });
                } 
				
				
			});
		};
		
		ajaxToFetchMasterDataForEdit = function(recordId, selectedFormDefinitionId, formName, tableName, valueName, createNewMappingTable,
				createFormMappingsTable, fieldKey) {
			$.ajax({
				url: getMasterDataResourceURL,
				async: false,
				type : Liferay.Language.get('post'),
				data : {
					[namespace + 'recordId']: recordId,
					[namespace + 'formDefinitionId']: selectedFormDefinitionId,
					[namespace + 'formName']: formName,
					[namespace + 'tableName']: tableName,
			    	[namespace + 'valueName']: valueName,
			    	[namespace + 'createNewMappingTable']: createNewMappingTable,
			    	[namespace + 'createFormMappingsTable']: createFormMappingsTable,
			    	[namespace + 'cmd']: 'getMasterData'
				},
				success : function(result) {
					console.log('in success : ' + result);
					var resultObj;
					if(result){
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							var selectedValuesArr = resultObj.selectedValues;
							for (var i = 0; i < selectedValuesArr.length; i++) {
								var selectedValues = selectedValuesArr[i];
								$('#'+ namespace + fieldKey).val(selectedValues[tableName + "_" + valueName]).trigger('change');
					        }
						}
					}
				},
				error : function(e) {
					console.log('API Error: '+ e);
				}		
			});
		};
		init();
	}

	htmlEditorChangeEvent = function(curElId, isMasterForm) {
		var currentSelectedLocale = "en_US";
		if(isMasterForm) {
			currentSelectedLocale = $("#" + curElId + "SelectedLocale").attr('language-id');			
		}
		$("#" + curElId + "_" + currentSelectedLocale).val($("#" + curElId).summernote('code'));
	};
	
	dfrPortlet.formRenderDDf = formRenderDDf;
	
	dfrPortlet.renderDDf = renderDDf;	

	dfrPortlet.formConfigActions = formConfigActions;
	
	dfrPortlet.htmlEditorChangeEvent = htmlEditorChangeEvent;
	dfrPortlet.editDDf = editDDf;
})($, (window.dfrPortlet = window.dfrPortlet || {}));