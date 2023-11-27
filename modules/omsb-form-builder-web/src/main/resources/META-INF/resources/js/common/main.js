(function($, commonFc) {
	
	var namespace, themeImagesPath, curLanguageId, defaultSummerNoteDescription = '<p><br></p>';

	var currentAvailableLocales = [
		{'label':'en-US', 'value':'en_US'},
		{'label':'ar-SA', 'value':'ar_SA'}
	];
	
	initConfigVars = function(config){
		namespace = config.namespace;
		themeImagesPath = config.themeImagesPath;
		curLanguageId = config.languageId;
	};
	
	initTextEditor = function(elJEl, changeEventFn, isMasterForm){
		$(elJEl).summernote({
			height: 150,
			codemirror: { 
				theme: 'monokai'
			},
			inheritPlaceholder: true,
			callbacks: {
				onChange: function(contents, $editable) {
					if(changeEventFn && changeEventFn.isViewMode) {
						dfrPortlet.htmlEditorChangeEvent(namespace + changeEventFn.elId, isMasterForm);
					} else {
						dfPortlet.htmlEditorChangeEvent(namespace + changeEventFn.elId);
					}
				}
			}
		});
		hideNoteModalSummernote();
	};
	
	initJsGrid = function(elJEl, fieldsArr, isJSGrid){
		if(isJSGrid){
			$(jsGridValidationJEl).jsGrid("destroy");
		}
		$(elJEl).jsGrid({
			width: "100%",
			inserting: true,
			editing: true,
			sorting: true,
			paging: true,
			height: "auto",
			invalidNotify: false,
			fields: fieldsArr
		});
		isJSGrid = true;
		$(elJEl).find(".jsgrid-grid-body").removeAttr("style");
		return isJSGrid;
	};
	
	destroyJSGrid = function(elJEl, isJSGrid){
		if(isJSGrid){
			$(elJEl).jsGrid("destroy");
		}
		isJSGrid = false;
	};
	
	hideNoteModalSummernote = function() {
		$('.note-modal').css('display','none');
	};
	
	function initDataTable(config){
		var table, dataTableJEl, ajaxURL, dataParams, processingMsg, emptyMsg, dataColumns,
			buttons, dataTableObj, length, aLengthMenu, defaultLength = 10, defaultALengthMenu = [ [10, 20, 30, 50, 100], [10, 20, 30, 50, 100] ];
		
		dataTableJEl = config.dataTableJEl;
		ajaxURL = config.ajaxURL;
		dataParams = config.dataParams;
		processingMsg = config.processingMsg;
		emptyMsg = config.emptyMsg;
		dataColumns = config.dataColumns;
		buttons = [];
		bSort = config.bSort ? true : false;
		length = config.length ? config.length : defaultLength;
		aLengthMenu = config.aLengthMenu ? config.aLengthMenu : defaultALengthMenu;
		defaultAjax = {
			"url": ajaxURL,
			"type": "POST",
			"data" : dataParams,
			"dataType" : 'json',
			"dataSrc": function(result){
				var list = JSON.parse(result.data);
				return list;
			}
		};
		ajax = config.ajax ? config.ajax : defaultAjax;
		dataTableObj = {
			"colReorder": true,
			"processing": true,
			"serverSide": true,
			"scrollX" : true,
			"searching": false,
			"buttons": buttons,
			"dom": '<"top"Bf><"oveflow"rt><"bottom"ipl><"clear">',
			"aLengthMenu": aLengthMenu,
			"iDisplayLength" : length,
			"bSort": bSort,
			"ajax": ajax,
			'language': {
				 "processing": processingMsg,
				 "emptyTable": emptyMsg
		    },
		    "columns": dataColumns 
		};
		
		if(config.columnDefs){
			dataTableObj.columnDefs = config.columnDefs;
		}
		if(config.order){
			dataTableObj.order = config.order;
		}
		if(config.drawCallback){
			dataTableObj.drawCallback = config.drawCallback;
		}
			
		table =  $(dataTableJEl).DataTable(dataTableObj);
		
		return table;
	};
	
	loadMultifileDropZone = function(dropZoneActionObj){
	  
		var elementName = dropZoneActionObj.elementName,
		url = dropZoneActionObj.url,
		paramName = dropZoneActionObj.paramName,
		maxFiles = dropZoneActionObj.maxFiles,
		maxFilesMessage = dropZoneActionObj.maxFilesMessage,
		extensions = dropZoneActionObj.extensions,
		extensionErrorMessage = dropZoneActionObj.extensionErrorMessage,
		encryptDataField = dropZoneActionObj.encryptDataField;
		Dropzone.autoDiscover = false;
		var dropZoneElement = "#"+namespace+elementName;
	    var myDropzone = new Dropzone(dropZoneElement, {
	    	url: url,
	    	paramName: paramName,
	    	thumbnailWidth:"350",
	    	maxFiles : maxFiles,
	    	acceptedFiles : extensions,
	    	addRemoveLinks: true,
			uploadMultiple : true,
			parallelUploads:10,
			init: function() {
	           console.log('init');
	           this.on("maxfilesexceeded", function(file){
	                console.log("No more files please!");
	                this.removeFile(file);
	                $(dropZoneElement).parent().addClass('has-error');
	                $(dropZoneElement).parent().append('<span id="'+paramName+'-error" class="help-block">'+maxFilesMessage+'</span>');
	           });
	           this.on("removedfile", function(file){
	                console.log("No more files please!");
	                //this.removeFile(file);
	                $(dropZoneElement).parent().removeClass('has-error');
					$(dropZoneElement).parent().find('.help-block').remove();
	           });
		    },
		    
		   /* removedfile: function(file) {
		    	if($(dropZoneElement).parent().hasClass('has-error')){
					$(dropZoneElement).parent().removeClass('has-error');
					$(dropZoneElement).parent().find('.help-block').remove();
				}
		    },*/
			success: function(file, responseJSON) {
				debugger;
				if($(dropZoneElement).parent().hasClass('has-error')){
					$(dropZoneElement).parent().removeClass('has-error');
					$(dropZoneElement).parent().find('.help-block').remove();
				}
				$(dropZoneElement+'-error').removeClass('has-error');
				$(dropZoneElement+'-error').find('.help-block').remove();
				console.log(responseJSON);
				var response;
				if(typeof responseJSON === 'string'){
					response = JSON.parse(responseJSON);
				}else{
					response = responseJSON;	
				}
				if(response.status === 'success'){
					var prefilledData = $(encryptDataField).val();
					var encryptedResponse ;
					if(prefilledData){
						var decryptedJson = JSON.parse(atob(prefilledData));
						decryptedJson.push(response.data[0]);
						encryptedResponse = btoa(JSON.stringify(decryptedJson));
					} else {
						encryptedResponse = btoa(JSON.stringify(response.data));
					}
					$(encryptDataField).val(encryptedResponse);
					
					console.log('response.data');
				}else if(response.status === 'error'){
				
				}
			},
			error: function(file, message) {
				console.log(message);
				
			}
	    });
	};
	
	createDivEl = function(className, id){
		var divEl, divElAttrObj = new Object({});
		divElAttrObj['class'] = className;
		if(id){
			divElAttrObj['id'] = namespace + id;
		}
		divEl = $('<div>', divElAttrObj);
		return divEl;
	};
	
	createLabel = function(forLabel, labelText, className, id, value){
		var labelEl, labelElAttrObj = new Object({});
		labelElAttrObj['for'] = namespace + forLabel;
		labelElAttrObj['text'] = labelText;
		if(className){
			labelElAttrObj['class'] = className;
		} if(id){
			labelElAttrObj['id'] = id;
		} if(value){
			labelElAttrObj['value'] = value;
		}
		labelEl = $('<label>', labelElAttrObj);
		return labelEl;
	};
	
	createEm = function(text){
		return emEl = $('<em>', {
			'text': text,
			'css':{
				color: 'red'
			}
		});
	}
	
	createTableEl = function(className){
		var tableEl, tableElAttrObj = new Object({});
		if(className){
			tableElAttrObj['class'] = className;
		}
		tableEl = $('<table>', tableElAttrObj);
	};
	
	createInputTextEl = function(className, id, isReadOnly, changeEventObj, placeholder, value, isDisabled, isRequired){
		var inputTextEl, inputTextElAttrObj = new Object({}), labelEl;
		inputTextElAttrObj['type'] = 'text';
		inputTextElAttrObj['class'] = className;
		if(id){
			inputTextElAttrObj['id'] = namespace + id;
			inputTextElAttrObj['name'] = namespace + id;
		}
		if(isReadOnly){
			inputTextElAttrObj['readOnly'] = isReadOnly;
		}
		if(changeEventObj){
			inputTextElAttrObj['onchange'] = changeEventObj.fnName;
		}
		if(placeholder){
			inputTextElAttrObj['placeholder'] = placeholder;
		}
		if(value){
			inputTextElAttrObj['value'] = value;
		}
		if(isDisabled){
			inputTextElAttrObj['disabled'] = isDisabled;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}

		inputTextEl = $('<input>', inputTextElAttrObj);
		return inputTextEl;
	};
	
	createInputPasswordEl = function(className, id, isReadOnly, changeEventObj,placeholder,isDisabled, value, isRequired){
		var inputPasswordEl, inputPasswordElAttrObj = new Object({}), labelEl;
		inputPasswordElAttrObj['type'] = 'password';
		inputPasswordElAttrObj['class'] = className;
		if(id){
			inputPasswordElAttrObj['id'] = namespace + id;
			inputPasswordElAttrObj['name'] = namespace + id;
		}
		if(isReadOnly){
			inputPasswordElAttrObj['readOnly'] = isReadOnly;
		}
		if(changeEventObj){
			inputPasswordElAttrObj['onchange'] = changeEventObj.fnName;
		}
		if(placeholder){
			inputPasswordElAttrObj['placeholder'] = placeholder;
		}
		if(isDisabled){
			inputPasswordElAttrObj['disabled'] = isDisabled;
		}
		if(value){
			inputPasswordElAttrObj['value'] = value;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}

		inputPasswordEl = $('<input>', inputPasswordElAttrObj);
		return inputPasswordEl;
	};
	
	createInputFileEl = function(className, id, isReadOnly, changeEventObj, isDisabled, isRequired){
		var inputFileEl, inputFileElAttrObj = new Object({}), labelEl;
		inputFileElAttrObj['type'] = 'file';
		inputFileElAttrObj['class'] = className;
		if(id){
			inputFileElAttrObj['id'] = namespace + id;
			inputFileElAttrObj['name'] = namespace + id;
		}
		if(isReadOnly){
			inputFileElAttrObj['readOnly'] = isReadOnly;
		}
		if(changeEventObj){
			inputFileElAttrObj['onchange'] = changeEventObj.fnName;
		}
		if(isDisabled){
			inputFileElAttrObj['disabled'] = isDisabled;
		}

		inputFileEl = $('<input>', inputFileElAttrObj);
		return inputFileEl;
	};
	
	createInputDateEl = function(className, id, isReadOnly, isDisabled, value, isRequired, placeholder){
		var inputDateEl, inputDateElAttrObj = new Object({}), labelEl;
		inputDateElAttrObj['type'] = 'text';
		inputDateElAttrObj['class'] = className;
		if(id){
			inputDateElAttrObj['id'] = namespace + id;
			inputDateElAttrObj['name'] = namespace + id;
		}
		if(isReadOnly){
			inputDateElAttrObj['readOnly'] = isReadOnly;
		}
		if(isDisabled){
			inputDateElAttrObj['disabled'] = isDisabled;
		}
		if(value){
			inputDateElAttrObj['val'] = value;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}
		if(placeholder){
			inputDateElAttrObj['placeholder'] = placeholder;
		}
		
		inputDateEl = $('<input>', inputDateElAttrObj);
		return inputDateEl;
	};
	
	dateRangePickerConfig = function(elementType,elementName,format, isAMPM){
		var isTimeEnabled = false;
		if(elementType === "datetime"){
			$('input[name="'+namespace+elementName+'"]').daterangepicker({
			    singleDatePicker: true,
			    showDropdowns: true,
			    timePicker: true,
			    timePicker24Hour: true,
			    autoUpdateInput: false,
				startDate: moment().startOf('minute'),
			    locale: {
			            format: format
			        }
			  });
			$('input[name="'+namespace+elementName+'"]').on('apply.daterangepicker', function(ev, picker) {
			      $(this).val(picker.startDate.format(format));
			});
	
		 	$('input[name="'+namespace+elementName+'"]').on('cancel.daterangepicker', function(ev, picker) {
		      $(this).val('');
		 	});
		}else if(elementType === "date"){
			$('input[name="'+namespace+elementName+'"]').daterangepicker({
			    singleDatePicker: true,
			    showDropdowns: true,
			    timePicker: false,
			    autoUpdateInput: false,
			    timePicker24Hour: true,
			    locale: {
			            format: format
			        }
			  });
			$('input[name="'+namespace+elementName+'"]').on('apply.daterangepicker', function(ev, picker) {
			      $(this).val(picker.startDate.format(format));
			});
	
		 	$('input[name="'+namespace+elementName+'"]').on('cancel.daterangepicker', function(ev, picker) {
		      $(this).val('');
		 	});
		}else if(elementType === "time"){
			var is12HoursFormat = isAMPM ? true : false;
			$('input[name="'+namespace+elementName+'"]').daterangepicker({
			    singleDatePicker: true,
			    timePicker: true,
			    timePicker24Hour: !is12HoursFormat,
			    timePickerIncrement : 1,
			    timePickerSeconds : true,
			    autoUpdateInput: false,
				startDate: moment().startOf('minute'),
			    locale: {
			            format: format
			        }
			  }).on('show.daterangepicker', function(ev, picker) {
		            picker.container.find(".calendar-table").hide();
			   });
			$('input[name="'+namespace+elementName+'"]').on('apply.daterangepicker', function(ev, picker) {
			      $(this).val(picker.startDate.format(format));
			});
	
		 	$('input[name="'+namespace+elementName+'"]').on('cancel.daterangepicker', function(ev, picker) {
		      $(this).val('');
		 	});
		}
	}
	
	createInputNumberEl = function(className, id, changeEventObj,isReadonly,placeholder,isDisabled, value, min, max, isRequired){
		var inputNumberEl, inputNumberElAttrObj = new Object({}), labelEl;
		inputNumberElAttrObj['type'] = 'number';
		inputNumberElAttrObj['class'] = className;
		if(id){
			inputNumberElAttrObj['id'] = namespace + id;
			inputNumberElAttrObj['name'] = namespace + id;
		}
		if(changeEventObj){
			inputNumberElAttrObj['onchange'] = changeEventObj.fnName;
		}
		if(isReadonly){
			inputNumberElAttrObj['readOnly'] = isReadonly;
		}
		if(placeholder){
			inputNumberElAttrObj['placeholder'] = placeholder;
		}
		if(isDisabled){
			inputNumberElAttrObj['disabled'] = isDisabled;
		}
		if(value){
			inputNumberElAttrObj['value'] = value;
		}
		if(min){
			inputNumberElAttrObj['min'] = min;
		}
		if(max){
			inputNumberElAttrObj['max'] = max;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}

		inputNumberEl = $('<input>', inputNumberElAttrObj);
		return inputNumberEl;
	};
	
	createInputRangePickerEl = function(className, id, changeEventObj,isReadonly,placeholder,isDisabled, value, min, max, isRequired){
		var inputNumberEl, inputRangePickerElAttrObj = new Object({}), labelEl;
		inputRangePickerElAttrObj['type'] = 'range';
		inputRangePickerElAttrObj['class'] = className;
		if(id){
			inputRangePickerElAttrObj['id'] = namespace + id;
			inputRangePickerElAttrObj['name'] = namespace + id;
		}
		if(changeEventObj){
			inputRangePickerElAttrObj['onchange'] = changeEventObj.fnName;
		}
		if(isReadonly){
			inputRangePickerElAttrObj['readOnly'] = isReadonly;
		}
		if(placeholder){
			inputRangePickerElAttrObj['placeholder'] = placeholder;
		}
		if(isDisabled){
			inputRangePickerElAttrObj['disabled'] = isDisabled;
		}
		if(value){
			inputRangePickerElAttrObj['value'] = value;
		}
		if(min){
			inputRangePickerElAttrObj['min'] = min;
		}
		if(max){
			inputRangePickerElAttrObj['max'] = max;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}

		inputNumberEl = $('<input>', inputRangePickerElAttrObj);
		return inputNumberEl;
	};
	
	createTextAreaEl = function(className, id, rows, cols,isReadOnly, isDisabled, placeholder, value, isRequired, maxLength){
		var inputTextAreaEl, inputTextAreaElAttrObj = new Object({}), labelEl;
		inputTextAreaElAttrObj['class'] = className;
		inputTextAreaElAttrObj['rows'] = rows;
		inputTextAreaElAttrObj['cols'] = cols;
		
		if(id){
			inputTextAreaElAttrObj['id'] = namespace + id;
			inputTextAreaElAttrObj['name'] = namespace + id;
		}
		if(isReadOnly){
			inputTextAreaElAttrObj['readOnly'] = isReadOnly;
		}
		if(isDisabled){
			inputTextAreaElAttrObj['disabled'] = isDisabled;
		}
		if(placeholder) {
			inputTextAreaElAttrObj['placeholder'] = placeholder;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}
		if(maxLength){
			inputTextAreaElAttrObj['maxlength'] = maxLength;
		}
		inputTextAreaEl = $('<textarea>', inputTextAreaElAttrObj);
		
		return inputTextAreaEl;
	};
	
	createTextEditorEl = function(className, id){
		var textEditorEl, textEditorElAttrObj = new Object({});
		textEditorElAttrObj['type'] = 'text';
		textEditorElAttrObj['class'] = className;
		if(id){
			textEditorElAttrObj['id'] = namespace + id;
			textEditorElAttrObj['name'] = namespace + id;
		}
		textEditorEl = $('<div>', textEditorElAttrObj);
		return textEditorEl;
	};
	
	createHead = function(head , text){
		return formHeadEl = $('<'+head+'>', {
			'text': text
		});
	};

	createPara = function(text) {
		return paraEl = $('<p>', {
			'text': text
		});
	};
	
	createIcon = function(className){
		var italicEl, italicElAttrObj = new Object({});
		italicElAttrObj['class'] = className;
		italicEl = $('<i>', italicElAttrObj);
		return italicEl;
	};
	
	createAnchor = function(attrs){
		return anchorEl = $('<a>', attrs);
	};
	
	createButtonEl = function(className, id, changeEventObj, buttonText, dataToggle, dataTarget){
		var buttonEl, buttonElAttrObj = new Object({});
		buttonElAttrObj['type'] = 'button';
		buttonElAttrObj['class'] = className;
		if(buttonText){
			buttonElAttrObj['text'] = buttonText;
		}
		if(id){
			buttonElAttrObj['id'] = namespace + id;
			buttonElAttrObj['name'] = namespace + id;
		}
		if(changeEventObj){
			buttonElAttrObj['onclick'] = changeEventObj.fnName;
		}
		if(dataToggle){
			buttonElAttrObj['data-toggle'] = dataToggle;
		}
		if(dataTarget){
			buttonElAttrObj['data-target'] = '#' + namespace + dataTarget;
		}
		buttonEl = $('<button>', buttonElAttrObj);
		return buttonEl;
	};
	
	createDropdown = function(className, id, changeEventObj, isMultiselect, isRequired){
		var dropdownEl, dropdownElAttrObj = new Object({}), labelEl;
		dropdownElAttrObj['class'] = className;
		if(id){
			dropdownElAttrObj['id'] = namespace + id;
			dropdownElAttrObj['name'] = namespace + id;
		}
		if(changeEventObj){
			dropdownElAttrObj['onchange'] = changeEventObj.fnName;
		}
		if(isMultiselect){
			dropdownElAttrObj['multiple'] = 'multiple';
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}
		dropdownEl = $('<select>', dropdownElAttrObj);
		$(dropdownEl).append($('<option>', {
	        value: '',
	        text: '--Select--'
	    }));
		
		return dropdownEl;
	};
	createInputCheckboxEl = function(labelClass, forLabel, inputClass, id, inputText, changeEventObj, dataAttr, isRequired){
		var formCheckDivEl, inputCheckboxEl, checkboxLabelEl, inputCheckboxElAttrObj = new Object({}), checkboxLabelElAttrObj = new Object({}), labelEl;
		
		formCheckDivEl = createDivEl('form-check');
		
		checkboxLabelElAttrObj['for'] = namespace + forLabel;
		if(labelClass){
			checkboxLabelElAttrObj['class'] = labelClass;
		}
		checkboxLabelEl = $('<label>', checkboxLabelElAttrObj);
		
		$(checkboxLabelEl).append(inputText);
		
		inputCheckboxElAttrObj['type'] = 'checkbox';
		inputCheckboxElAttrObj['class'] = inputClass;
		
		if(id){
			inputCheckboxElAttrObj['id'] = namespace + id;
			inputCheckboxElAttrObj['name'] = namespace + id;
		}
		
		if(changeEventObj){
			inputCheckboxElAttrObj['onchange'] = changeEventObj.fnName;
		}
		
		if(dataAttr){
			inputCheckboxElAttrObj['data-sub-field-wrraper'] = namespace + dataAttr;
		}
		if(isRequired) {
			requiredEl = createEm('*');
			$(labelEl).append(requiredEl);
		}

		inputCheckboxEl = $('<input>', inputCheckboxElAttrObj);
		
		$(formCheckDivEl).append(inputCheckboxEl);
		$(formCheckDivEl).append(checkboxLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputCheckboxWithIdEl = function(divClass, divId, labelClass, forLabel, inputClass, id, inputText, changeEventObj, dataAttr){
		var formCheckDivEl, inputCheckboxEl, checkboxLabelEl, inputCheckboxElAttrObj = new Object({}), checkboxLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl(divClass, divId);
		
		checkboxLabelElAttrObj['for'] = namespace + forLabel;
		if(labelClass){
			checkboxLabelElAttrObj['class'] = labelClass;
		}
		checkboxLabelEl = $('<label>', checkboxLabelElAttrObj);
		
		$(checkboxLabelEl).append(inputText);
		
		inputCheckboxElAttrObj['type'] = 'checkbox';
		inputCheckboxElAttrObj['class'] = inputClass;
		
		if(id){
			inputCheckboxElAttrObj['id'] = namespace + id;
			inputCheckboxElAttrObj['name'] = namespace + id;
		}
		
		if(changeEventObj){
			inputCheckboxElAttrObj['onchange'] = changeEventObj.fnName;
		}
		
		if(dataAttr){
			inputCheckboxElAttrObj['data-sub-field-wrraper'] = namespace + dataAttr;
		}

		inputCheckboxEl = $('<input>', inputCheckboxElAttrObj);
		
		$(formCheckDivEl).append(inputCheckboxEl);
		$(formCheckDivEl).append(checkboxLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputCheckboxDynamicEl = function(labelClass, forLabel, inputClass, id, inputText, changeEventObj, dataAttr, defaultSelected){
		var formCheckDivEl, inputCheckboxEl, checkboxLabelEl, inputCheckboxElAttrObj = new Object({}), checkboxLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl('form-check-inline');
		
		checkboxLabelElAttrObj['for'] = namespace + forLabel;
		if(labelClass){
			checkboxLabelElAttrObj['class'] = labelClass;
		}
		checkboxLabelEl = $('<label>', checkboxLabelElAttrObj);
		
		$(checkboxLabelEl).append(inputText);
		
		inputCheckboxElAttrObj['type'] = 'checkbox';
		inputCheckboxElAttrObj['class'] = inputClass;
		
		if(id){
			inputCheckboxElAttrObj['id'] = namespace + forLabel.replace(/ /g,"_") + '_' + id;
			inputCheckboxElAttrObj['name'] = namespace + id;
		}
		
		if(jQuery.inArray(forLabel,defaultSelected) >= 0) {
			inputCheckboxElAttrObj['checked'] = true;
		}
		
		if(forLabel) {
			inputCheckboxElAttrObj['value'] = forLabel;
		}
		
		if(changeEventObj){
			inputCheckboxElAttrObj['onchange'] = changeEventObj.fnName;
		}
		
		if(dataAttr){
			inputCheckboxElAttrObj['data-sub-field-wrraper'] = namespace + dataAttr;
		}

		inputCheckboxEl = $('<input>', inputCheckboxElAttrObj);
		
		$(formCheckDivEl).append(inputCheckboxEl);
		$(formCheckDivEl).append(checkboxLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputRadioEl = function(labelClass, forLabel, inputClass, id, name, inputText, value){
		var formCheckDivEl, inputRadioEl, radioLabelEl, inputRadioElAttrObj = new Object({}), radioLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl('form-check');
		
		radioLabelElAttrObj['for'] = namespace + forLabel;
		if(labelClass){
			radioLabelElAttrObj['class'] = labelClass;
		}
		radioLabelEl = $('<label>', radioLabelElAttrObj);
		
		$(radioLabelEl).append(inputText);
		
		inputRadioElAttrObj['type'] = 'radio';
		inputRadioElAttrObj['class'] = inputClass;
		
		if(id){
			inputRadioElAttrObj['id'] = namespace + id;
		}
		
		if(name){
			inputRadioElAttrObj['name'] = namespace + name;
		}
		
		if(value){
			inputRadioElAttrObj['value'] = value;
		}
		
		inputRadioEl = $('<input>', inputRadioElAttrObj);
		
		$(formCheckDivEl).append(inputRadioEl);
		$(formCheckDivEl).append(radioLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputRadioDynamicEl = function(labelClass, forLabel, inputClass, id, name, inputText, defaultSelected, changeEventObj){
		var formCheckDivEl, inputRadioEl, radioLabelEl, changeEventObj, inputRadioElAttrObj = new Object({}), radioLabelElAttrObj = new Object({});
		formCheckDivEl = createDivEl('form-check-inline');
		
		radioLabelElAttrObj['for'] = namespace + forLabel.replace(/ /g,"_") + '_' + name;
		if(labelClass){
			radioLabelElAttrObj['class'] = labelClass;
		}
		radioLabelEl = $('<label>', radioLabelElAttrObj);
		
		$(radioLabelEl).append(inputText);
		
		inputRadioElAttrObj['type'] = 'radio';
		inputRadioElAttrObj['class'] = inputClass;
		
		if(id){
			inputRadioElAttrObj['value'] = id;
			inputRadioElAttrObj['id'] = namespace + id.replace(/ /g,"_") + '_' + name;
		}
		
		if(name){
			inputRadioElAttrObj['name'] = namespace + name;
		}
		
		if(jQuery.inArray(id,defaultSelected) >= 0) {
			inputRadioElAttrObj['checked'] = true;
		}
		if(changeEventObj) {
			inputRadioElAttrObj['onchange'] = changeEventObj.fnName;
		}
		
		inputRadioEl = $('<input>', inputRadioElAttrObj);
		
		$(formCheckDivEl).append(inputRadioEl);
		$(formCheckDivEl).append(radioLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputRadioRangeEl = function(labelClass, forLabel, lableText, inputClass, inputValue, inputId, inputName,
			groupAverage, overallAverage, boundaries, singleRangeOptionsCount, changeEventObj, defaultSelected){
		var formCheckDivEl, inputRadioDivEl,  inputRadioEl, radioLabelDivEl, radioLabelEl, inputRadioElAttrObj = new Object({}), radioLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl('form-check-inline');
		
		radioLabelElAttrObj['for'] = namespace + forLabel.replace(/ /g,"_") + '_' + inputName;
		if(labelClass){
			radioLabelElAttrObj['class'] = labelClass;
		}
		radioLabelEl = $('<label>', radioLabelElAttrObj);
		
		$(radioLabelEl).append(lableText);
		
		inputRadioElAttrObj['type'] = 'radio';
		inputRadioElAttrObj['class'] = inputClass;
		inputRadioElAttrObj['data-group-average'] = groupAverage;
		inputRadioElAttrObj['data-overall-average'] = overallAverage;
		inputRadioElAttrObj['data-min'] = boundaries[0];
		inputRadioElAttrObj['data-max'] = boundaries[1];
		inputRadioElAttrObj['data-options-count'] = singleRangeOptionsCount;
		
		if(inputValue){
			inputRadioElAttrObj['value'] = inputValue;
		}

		if(inputId) {
			inputRadioElAttrObj['id'] = namespace + inputId.replace(/ /g,"_") + '_' + inputName;
		}
		
		if(inputName){			
			inputRadioElAttrObj['name'] = namespace + inputName;
		}
		
		if(changeEventObj || groupAverage || overallAverage) {
			inputRadioElAttrObj['onchange'] = changeEventObj.fnName;
		}
		
		if(jQuery.inArray(inputId,defaultSelected) >= 0) {
			inputRadioElAttrObj['checked'] = true;
		}
		
		inputRadioEl = $('<input>', inputRadioElAttrObj);
		
		$(formCheckDivEl).append(inputRadioEl);
		$(formCheckDivEl).append(radioLabelEl);		
		
		return formCheckDivEl;
	};
	
	populateDropdown = function(data, dropdownEl){
		$(dropdownEl).find('.dt-option').remove();
		if(data){
			for (const key of data) {
			    $(dropdownEl).append($('<option>', {
			        value: key.value,
			        text: key.label,
			        class : 'dt-option',
			        disabled: key.isDisabled
			    }));
			}
		}
	};
	
	
	populateStaticDropdown = function(data, dropdownEl, changeEventObj, defaultSelected) {
		var  dropdownElAttrObj = new Object({});
		$(dropdownEl).find('.dt-option').remove();
		for (const key of data) {
			$(dropdownEl).append($('<option>', {
		        value: key,
		        text: key,
		        class : 'dt-option'
		    }));
		}
		if(changeEventObj){
			dropdownElAttrObj['onchange'] = changeEventObj.fnName;
		}
	};
	
	populateDataProviderDropdown = function(url, method, headers, property, dataProps, dropdownEl, changeEventObj) {
		var  dropdownElAttrObj = new Object({});
		$(dropdownEl).find('.dt-option').remove();
		
		var apiCall = {
			"url": url,
			"method": method,
			"headers": headers,
		};
		
		var actualProperty = property;
		var propertyPath = "";
		
		if(property.indexOf("::") != -1) {
			var properties = actualProperty.split("::");
			actualProperty = properties[properties.length - 1];
			properties.pop();
			propertyPath = properties.join(".");
		}

		$.ajax(apiCall).done(function (response) {
			if(propertyPath != "") {
				$.each(response[propertyPath], function( key, value ) {
					addOptionValue(value, dropdownEl, actualProperty, dataProps);
				});
			} else {
				$.each(response, function( key, value ) {
					addOptionValue(value, dropdownEl, actualProperty, dataProps);
				});
			}
			
		});
		
		if(changeEventObj){
			dropdownElAttrObj['onchange'] = changeEventObj.fnName;
		}
	};
	
	addOptionValue = function(value, dropdownEl, actualProperty, dataProps){   
        var additionalData = new Object({});
        
        additionalData["value"] = value[actualProperty];
        additionalData["text"] = value[actualProperty];
        additionalData["class"] = 'dt-option';
        
        if(dataProps.length > 0) {
        	$.each(dataProps, function(index, val){
            	additionalData["data-"+val] = value[val];
    	    });
        }
        
        $(dropdownEl).append($('<option>', additionalData));
	};
	
	createCardEl = function(cardTitle, cardHeading, cardDescription){
		
		var rowDivEl, colDivEl, cardDivEl, cardHeaderDivEl, cardHeaderEl, cardBodyDivEl;
		
		rowDivEl = createDivEl('row');
		colDivEl = createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
		cardDivEl = createDivEl('card');
		cardHeaderDivEl = createDivEl('card-header');
		cardHeading = cardHeading ? cardHeading : 'h3';
		cardHeaderEl = createHead(cardHeading, cardTitle);
		cardBodyDivEl = createDivEl('card-body');
		
		$(cardHeaderDivEl).append(cardHeaderEl);
		$(cardDivEl).append(cardHeaderDivEl);
		$(cardDivEl).append(cardBodyDivEl);
		
		$(colDivEl).append(cardDivEl);
		$(rowDivEl).append(colDivEl);
		
		return rowDivEl;
		
	};
	createAccordianCardEl = function(accordianClass, accordianId, cardTitle, groupName, cardDescription){
		
		var rowDivEl, colDivEl, accordianDivEl, cardDivEl, cardHeaderDivEl, cardHeaderAnchorEl, cardParaEl, cardBodyAccordianDivEl, cardBodyDivEl, accordianHeaderId, accordianBodyId,
			accordianCardBodyId, groupName;
		
		accordianHeaderId = accordianId + 'Header';
		accordianBodyId = accordianId + 'Body';
		accordianCardBodyId = accordianId + 'CardBody';
		
		rowDivEl = createDivEl('row group-row', groupName);
		accordianDivEl = createDivEl(accordianClass, accordianId);
		
		var dataTargetId;
			
		if(groupName != null || groupName != '' || groupName != undefined){
			dataTargetId = '#' + namespace + accordianBodyId+'_'+groupName;
		} else{
			dataTargetId = '#' + namespace + accordianBodyId;
		}
		
		if(accordianId == 'postDataAccordian'){
			cardDivEl = createDivEl('card post-data-card dfb-card-group-description d-none');
		} else if(accordianId == 'populateDataAccordian'){
			cardDivEl = createDivEl('card populate-data-card dfb-card-group-description d-none');
		} else{
			cardDivEl = createDivEl('card dfb-card-group-description', 'card_' + groupName);
		}
		
		cardHeaderDivEl = createDivEl('card-header', accordianHeaderId);
		var anchorAttrsObj = {
			'href' : '#javascript:void(0)',
			'class' : 'btn btn-header-link anchor-settings-accordian',
			'data-toggle' : 'collapse',
			'data-target' : dataTargetId,
			'aria-expanded' : 'true',
			'aria-controls' : namespace + accordianBodyId
		};
		
		cardHeaderAnchorEl = createAnchor(anchorAttrsObj);
		$(cardHeaderAnchorEl).append(cardTitle);
		if(cardDescription != null && cardDescription != '' && cardDescription != undefined){
			cardParaEl = createPara(cardDescription);
			$(cardHeaderAnchorEl).append(cardParaEl);
		}
		

		if(groupName != null || groupName != '' || groupName != undefined){
			cardBodyAccordianDivEl = createDivEl('collapse show card-body-accordian-settings',accordianBodyId+'_'+groupName);
			$(cardBodyAccordianDivEl).attr('aria-labelledby', namespace + accordianHeaderId+'_'+groupName);
		} else{
			cardBodyAccordianDivEl = createDivEl('collapse show card-body-accordian-settings',accordianBodyId);	
			$(cardBodyAccordianDivEl).attr('aria-labelledby', namespace + accordianHeaderId);
		}
		
		$(cardBodyAccordianDivEl).attr('data-parent', '#' + namespace + 'groupAccordian');
		cardBodyDivEl = createDivEl('card-body card-body-settings-div-el', accordianCardBodyId);
		
		$(cardHeaderDivEl).append(cardHeaderAnchorEl);
		$(cardDivEl).append(cardHeaderDivEl);
		
		$(cardBodyAccordianDivEl).append(cardBodyDivEl);
		$(cardDivEl).append(cardBodyAccordianDivEl);
		
		$(accordianDivEl).append(cardDivEl);
		return cardDivEl;
		
	};
	

	createMultifileUploadDynamicEl = function(labelClass, forLabel, inputClass, id, name, inputText, isRequired){
		var formCheckDivEl, inputRadioEl, fileLabelEl, dropzoneFileAreaDivEl, dzMessageDivEl, h3tagElAttrObj,
			h3tagEl, inputTextElAttrObj = new Object({}), fileLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl('form-group');
		
		fileLabelElAttrObj['for'] = namespace + forLabel;
		if(labelClass){
			fileLabelElAttrObj['class'] = labelClass;
		}
		fileLabelEl = $('<label>', fileLabelElAttrObj);
		
		$(fileLabelEl).append(inputText);
		
		if(isRequired) {
			requiredEl = createEm('*');
			$(fileLabelEl).append(requiredEl);
		}
		
		inputTextElAttrObj['type'] = 'hidden';
		inputTextElAttrObj['class'] = inputClass;
		
		inputTextElAttrObj['id'] = namespace + id;
		
		if(name){
			inputTextElAttrObj['name'] = namespace + id;
		}
		
		inputTextEl = $('<input>', inputTextElAttrObj);
		dropzoneFileAreaDivEl = createDivEl('dropzone dropzone-file-area',id);
		
		dzMessageDivEl = createDivEl('dz-default dz-message');
		
		h3tagElAttrObj = new Object({});
		
		 h3tagEl = $('<h3>', h3tagElAttrObj);
		$(h3tagEl).append(Liferay.Language.get('multi-file-upload-placeholder'));
		$(formCheckDivEl).append(fileLabelEl);
		$(dzMessageDivEl).append(h3tagEl);
		$(dropzoneFileAreaDivEl).append(dzMessageDivEl);
		$(formCheckDivEl).append(dropzoneFileAreaDivEl);
		$(formCheckDivEl).append(inputTextEl);
		return formCheckDivEl;
	};
	
	createTableEl = function(className, id){
		var tableEl, tableElAttrObj = new Object({});
		if(className){
			tableElAttrObj['class'] = className;
		}
		if(id){
			tableElAttrObj['id'] = namespace + id;
		}
		tableEl = $('<table>', tableElAttrObj);
		
		return tableEl;
	};
	
	createTREl = function(className, id){
		var trEl, trElAttrObj = new Object({});
		if(className){
			trElAttrObj['class'] = className;
		}
		if(id){
			trElAttrObj['id'] = namespace + id;
		}
		trEl = $('<tr>', trElAttrObj);
		
		return trEl;
	};
	
	createTHEl = function(className, id, scope, text){
		var thEl, thElAttrObj = new Object({});
		if(className){
			thElAttrObj['class'] = className;
		}
		if(id){
			thElAttrObj['id'] = namespace + id;
		}
		if(scope){
			thElAttrObj['scope'] = scope;
		}
		if(text){
			thElAttrObj['text'] = text;
		}
		thEl = $('<th>', thElAttrObj);
		
		return thEl;
	};
	
	createTDEl = function(text, className, id){
		var tdEl, tdElAttrObj = new Object({});
		if(text){
			tdElAttrObj['text'] = text;
		}
		if(className){
			tdElAttrObj['class'] = className;
		}
		if(id){
			tdElAttrObj['id'] = namespace + id;
		}
		tdEl = $('<td>', tdElAttrObj);
		
		return tdEl;
	};
	
	createTheadEl = function(className, id){
		var theadEl, theadElAttrObj = new Object({});
		if(className){
			theadElAttrObj['class'] = className;
		}
		if(id){
			theadElAttrObj['id'] = namespace + id;
		}
		theadEl = $('<thead>', theadElAttrObj);
		
		return theadEl;
	};
	
	createTbodyEl = function(className, id){
		var tbodyEl, tbodyElAttrObj = new Object({});
		if(className){
			tbodyElAttrObj['class'] = className;
		}
		if(id){
			tbodyElAttrObj['id'] = namespace + id;
		}
		tbodyEl = $('<tbody>', tbodyElAttrObj);
		
		return tbodyEl;
	};
	encryptData = function(dataObj){
		 var secretPassphraseKey, textToEncrypt, encryptedText;
			
		secretPassphraseKey = dataObj.secretPassphrase;
		textToEncrypt = dataObj.text;
		var iv = CryptoJS.lib.WordArray.random(16);
		encryptedText = CryptoJS.AES.encrypt(textToEncrypt, secretPassphraseKey, {iv : iv}).toString();
		aesEncryptionData = iv + "::" + encryptedText;
		return aesEncryptionData;
	};
	decryptData = function(dataObj){
		 var secretPassphraseKey, iv, text, textToDecrypt, decryptText, decryptedText;
			
		secretPassphraseKey = dataObj.secretPassphrase;
		text = dataObj.text;
		iv = text.split("::")[0];
		textToDecrypt = text.split("::")[1];
		decryptedText = CryptoJS.AES.decrypt(textToDecrypt, secretPassphraseKey, {iv : iv}).toString(CryptoJS.enc.Utf8);
		return decryptedText;
	};
	encryptFormDataRequest = function(dataObj){
		var secretPassphraseKey, salt, iv, key128Bits, key128Bits100Iterations, requestJsonCipherData, 
    		aesEncryptionData = '', aesEncryptionBToaData;
	 	
	 	secretPassphraseKey = dataObj.secretPassphrase;
	 	textToEncrypt = dataObj.text;
	    
	    salt = CryptoJS.lib.WordArray.random(128/8);
	    iv = CryptoJS.lib.WordArray.random(128/8);
	    key128Bits = CryptoJS.PBKDF2(secretPassphraseKey, salt, { keySize: 128/32 }); 
	    key128Bits100Iterations = CryptoJS.PBKDF2(secretPassphraseKey, salt, { keySize: 128/32, iterations: 100 });
	    
	    requestDataCipherData = CryptoJS.AES.encrypt(textToEncrypt, key128Bits100Iterations, {iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7});

	    aesEncryptionData = (iv + "::" + salt + "::" + requestDataCipherData);
	    
	    aesEncryptionBToaData = btoa(aesEncryptionData);
		    
		return aesEncryptionBToaData;
	};
	isValidSummerNoteDescription = function(elJEl){
		var isValidDescription = true, description;
		
		description = $(elJEl).summernote('code');
		
		if(description == defaultSummerNoteDescription){
			isValidDescription = false;
		}
		    
		return isValidDescription;
	};
	getEN_USLocaleHtmlText = function() {
		var htmlText = '';
		htmlText += '<svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="'+ themeImagesPath +'/clay/icons.svg#en-us"></use></svg>';
		htmlText += '<span class="df-lang-text">en-US</span>';
		htmlText += '<span class="df-lang-btn"><i class="fa fa-caret-down"></i></span>';
		return htmlText;
	};
	getAR_SALocaleHtmlText = function() {
		var htmlText = '';
		htmlText += '<svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="'+ themeImagesPath +'/clay/icons.svg#ar-sa"></use></svg>';
		htmlText += '<span class="df-lang-text">ar-SA</span>';
		htmlText += '<span class="df-lang-btn"><i class="fa fa-caret-down"></i></span>';
		return htmlText;
	};
	createLocaleBtnEl = function(secondaryBtnId, changeEventFn, isBasicSection) {
		var inputGroupDivClassName = (curLanguageId == 'ar_SA') ? 'input-group-append btn-group dropstart d-block' : 'input-group-append'; 
		formInputGroupAppendDivEl = createDivEl(inputGroupDivClassName);	
		secondaryBtnEl = createButtonEl('btn btn-outline-secondary dropdown-toggle df-language-selector-btn', secondaryBtnId, false, 'English', 'dropdown');
		formDropdownMenuEL = createDivEl('dropdown-menu df-dropdown-menu');

		$(secondaryBtnEl).attr('language-id', 'en_US');
		
		var htmlText = getEN_USLocaleHtmlText();
		$(secondaryBtnEl).html(htmlText);

		$.each(currentAvailableLocales, function(index, val) {
			var dropdownBtn;				
			dropdownBtn = createButtonEl('dropdown-item', '', changeEventFn, val.label);

			$(dropdownBtn).attr('language-id', val.value);
			$(dropdownBtn).attr('reflect-on-field-id', secondaryBtnId);
			
			var htmlText = '';
			if(val.value == 'en_US'){
				htmlText += '<svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="'+ themeImagesPath +'/clay/icons.svg#en-us"></use></svg>';	
				htmlText += '<span class="df-lang-text">' + val.label + '</span>';
			}else if(val.value == 'ar_SA'){
				htmlText += '<svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="'+ themeImagesPath +'/clay/icons.svg#ar-sa"></use></svg>';
				htmlText += '<span class="df-lang-text">' + val.label + '</span>';
			}
			
			$(dropdownBtn).html(htmlText);
		
			$(formDropdownMenuEL).append(dropdownBtn);
		});

		$(formInputGroupAppendDivEl).append(secondaryBtnEl);
		$(formInputGroupAppendDivEl).append(formDropdownMenuEL);

		return formInputGroupAppendDivEl;
	};

	getCurrentLocaleGroupName = function(groupName, languageId, groups) {
		var curLocaleGroupName = '';
		$.each(groups, function(index, val) {
			if(groupName == val.id) {
				curLocaleGroupName = val.labels[languageId];
			}
		});
		return curLocaleGroupName;
	};
	
	getCurrentLocaleGroupDescription = function(groupName, languageId, groups) {
		var curLocaleGroupDescription = '';
		$.each(groups, function(index, val) {
			if(groupName == val.id) {
				curLocaleGroupDescription = val.description[languageId];
			}
		});
		return curLocaleGroupDescription;
	};
	
	createWorkflowSpanEl = function(spanclassName, strongClassName, text){
		var spanEl, spanElAttrObj = new Object({}), strongEl, strongElAttrObj = new Object({});
		if(strongClassName){
			strongElAttrObj['class'] = strongClassName;
		}
		if(text){
			strongElAttrObj['text'] = text;
		}
		strongEl = $('<strong>', strongElAttrObj);
		
		if(spanclassName){
			spanElAttrObj['class'] = spanclassName;
		}
		spanEl = $('<span>', spanElAttrObj);
		$(spanEl).append(strongEl);
		return spanEl;
	};
	
	getCustomRangeFieldsArr = function(){
		var customRangeFieldsArr = [], enFieldObj = new Object({}), arFieldObj = new Object({}), valueFieldObj = new Object({}), fieldsControlObj = new Object({});
		
		enFieldObj.name = 'en_US';
		enFieldObj.title = 'en_US';
		enFieldObj.type = 'text';
		enFieldObj.width = 25;
		//enFieldObj.validate = 'required';
		enFieldObj.validate = {
			validator: function(value, item) {
		        if(!value){
		        	displayCustomError("Please Enter Range Option Value In English.");
	                return false;
		        }
		        return true;
		    }
		};
		customRangeFieldsArr.push(enFieldObj);
		
		arFieldObj.name = 'ar_SA';
		arFieldObj.title = 'ar_SA';
		arFieldObj.type = 'text';
		arFieldObj.width = 25;
		customRangeFieldsArr.push(arFieldObj);
		
		valueFieldObj.name = 'value';
		valueFieldObj.title = 'Value';
		valueFieldObj.type = 'text';
		valueFieldObj.width = 10;
		valueFieldObj.validate = {
			validator: function(value, item) {
				var isValid = $.isNumeric(value) && value >= -1;
		        if(!value){
		        	displayCustomError("Please Enter Range Option Value.");
	                return false;
		        }if(!isValid){
		        	displayCustomError("Please Enter Range Option Value >= -1.");
	                return false;
		        }
		        return true;
		    }
		};
		customRangeFieldsArr.push(valueFieldObj);
		
		fieldsControlObj.type = 'control';
		fieldsControlObj.editButton = true;
		fieldsControlObj.modeSwitchButton = false;
		fieldsControlObj.width = 15;
		customRangeFieldsArr.push(fieldsControlObj);
		
		return customRangeFieldsArr;
	};
	
	function displayCustomError(errorMessage) {
	    alert(errorMessage);
	};
	
	b64DecodeUnicode = function(str){
	    return decodeURIComponent(atob(str).split('').map(function(c) {
	        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
	    }).join(''));
	};
	
	populateCustomRangeJSGrid = function(rangeOptions, elJEl){
		var gridData = [];
		for (var i = 0; i < rangeOptions.length; i++) {
			var arName, value;
			var enName = rangeOptions[i].name.en_US;
			if(rangeOptions[i].name.ar_SA){
				arName = rangeOptions[i].name.ar_SA;
			}
			value = rangeOptions[i].value;
			gridData.push({
				"en_US": enName,
				"ar_SA": arName,
				"value": value
			});
		}
		if(rangeOptions && rangeOptions.length > 0){
			$(elJEl).jsGrid({
				data : gridData
			});
		}
	};
	
	escape = function(label) {
		if(label){
			return label.replace(/'/g, "&#39;");  
		}
		return label;    
	}
	
	unEscape = function(label) {
		if(label){
			label = label.replace(/&#39;/g , "\'");
		}
	    return label;
	}
	
	commonFc.currentAvailableLocales = currentAvailableLocales;
	commonFc.initConfigVars = initConfigVars;
	commonFc.initTextEditor = initTextEditor;
	commonFc.initJsGrid = initJsGrid;
	commonFc.hideNoteModalSummernote = hideNoteModalSummernote;
	commonFc.initDataTable = initDataTable;
	commonFc.loadMultifileDropZone = loadMultifileDropZone;
	commonFc.createDivEl = createDivEl;
	commonFc.createLabel = createLabel;
	commonFc.createEm = createEm;
	commonFc.createInputTextEl = createInputTextEl;
	commonFc.createInputPasswordEl = createInputPasswordEl;
	commonFc.createInputDateEl = createInputDateEl;
	commonFc.dateRangePickerConfig = dateRangePickerConfig;
	commonFc.createInputCheckboxDynamicEl = createInputCheckboxDynamicEl;
	commonFc.createInputRadioDynamicEl = createInputRadioDynamicEl;	
	commonFc.createMultifileUploadDynamicEl = createMultifileUploadDynamicEl;
	commonFc.createInputFileEl = createInputFileEl;
	commonFc.createInputNumberEl = createInputNumberEl;
	commonFc.createInputRangePickerEl = createInputRangePickerEl;
	commonFc.createTextAreaEl = createTextAreaEl;
	commonFc.createTextEditorEl = createTextEditorEl;
	commonFc.createHead = createHead;
	commonFc.createPara = createPara;
	commonFc.createIcon = createIcon;
	commonFc.createAnchor = createAnchor;
	commonFc.createButtonEl = createButtonEl;
	commonFc.createDropdown = createDropdown;
	commonFc.createInputCheckboxEl = createInputCheckboxEl;
	commonFc.createInputRadioEl = createInputRadioEl;
	commonFc.createInputRadioRangeEl = createInputRadioRangeEl;
	commonFc.populateDropdown = populateDropdown;
	commonFc.populateStaticDropdown = populateStaticDropdown;
	commonFc.populateDataProviderDropdown = populateDataProviderDropdown;
	commonFc.addOptionValue = addOptionValue;
	commonFc.createCardEl = createCardEl;
	commonFc.createAccordianCardEl = createAccordianCardEl;
	commonFc.createTableEl = createTableEl;
	commonFc.createTREl = createTREl;
	commonFc.createTHEl = createTHEl;
	commonFc.createTDEl = createTDEl;
	commonFc.createTheadEl = createTheadEl;
	commonFc.createTbodyEl = createTbodyEl;
	commonFc.encryptData = encryptData;
	commonFc.decryptData = decryptData;
	commonFc.encryptFormDataRequest = encryptFormDataRequest;
	commonFc.isValidSummerNoteDescription = isValidSummerNoteDescription;
	commonFc.createInputCheckboxWithIdEl = createInputCheckboxWithIdEl;
	commonFc.destroyJSGrid = destroyJSGrid;
	commonFc.getEN_USLocaleHtmlText = getEN_USLocaleHtmlText;
	commonFc.getAR_SALocaleHtmlText = getAR_SALocaleHtmlText;
	commonFc.createLocaleBtnEl = createLocaleBtnEl;
	commonFc.getCurrentLocaleGroupName = getCurrentLocaleGroupName;
	commonFc.getCurrentLocaleGroupDescription = getCurrentLocaleGroupDescription;
	commonFc.createWorkflowSpanEl = createWorkflowSpanEl;
	commonFc.getCustomRangeFieldsArr = getCustomRangeFieldsArr;
	commonFc.b64DecodeUnicode = b64DecodeUnicode;
	commonFc.populateCustomRangeJSGrid = populateCustomRangeJSGrid;
	commonFc.escape = escape;
	commonFc.unEscape = unEscape;
})($, (window.commonFc = window.commonFc || {}));