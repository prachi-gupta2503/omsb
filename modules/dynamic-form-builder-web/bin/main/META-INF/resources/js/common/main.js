(function($, commonFc) {
	
	var namespace;
	
	initConfigVars = function(config){
		namespace = config.namespace;
	};
	
	initTextEditor = function(elJEl){
		$(elJEl).summernote({
			  height: 150,   
			  codemirror: { 
			  theme: 'monokai'
			 }
		});
		hideNoteModalSummernote();
	};
	
	hideNoteModalSummernote = function() {
		$('.note-modal').css('display','none');
	};
	
	loadMultifileDropZone = function(elementName){
		Dropzone.autoDiscover = false;
	    var myDropzone = new Dropzone("#"+namespace+elementName, {
	    	url: "static/phpFiles/test.php",
	    	thumbnailWidth:"350",
	        addRemoveLinks: true,
	        accept: function(file) {
		        let fileReader = new FileReader();
	
		        fileReader.readAsDataURL(file);
		        fileReader.onloadend = function() {
	
		            let content = fileReader.result;
		            $('#file').val(content);
		            file.previewElement.classList.add("dz-success");
		        }
		        file.previewElement.classList.add("dz-complete");
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
	
	createLabel = function(forLabel, labelText, className){
		var labelEl, labelElAttrObj = new Object({});
		labelElAttrObj['for'] = namespace + forLabel;
		labelElAttrObj['text'] = labelText;
		if(className){
			labelElAttrObj['class'] = className;
		}
		labelEl = $('<label>', labelElAttrObj);
		return labelEl;
	};
	
	createTableEl = function(className){
		var tableEl, tableElAttrObj = new Object({});
		if(className){
			tableElAttrObj['class'] = className;
		}
		tableEl = $('<table>', tableElAttrObj);
	};
	
	createInputTextEl = function(className, id, isReadOnly, changeEventObj){
		var inputTextEl, inputTextElAttrObj = new Object({});
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
		inputTextEl = $('<input>', inputTextElAttrObj);
		return inputTextEl;
	};
	
	createInputFileEl = function(className, id, isReadOnly, changeEventObj){
		var inputFileEl, inputFileElAttrObj = new Object({});
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
		inputFileEl = $('<input>', inputFileElAttrObj);
		return inputFileEl;
	};
	
	createInputDateEl = function(className, id, isReadOnly){
		var inputDateEl, inputDateElAttrObj = new Object({});
		inputDateElAttrObj['type'] = 'text';
		inputDateElAttrObj['class'] = className;
		if(id){
			inputDateElAttrObj['id'] = namespace + id;
			inputDateElAttrObj['name'] = namespace + id;
		}
		if(isReadOnly){
			inputDateElAttrObj['readOnly'] = isReadOnly;
		}
		
		inputDateEl = $('<input>', inputDateElAttrObj);
		return inputDateEl;
	};
	
	dateRangePickerConfig = function(elementType,elementName,format){
		var isTimeEnabled = false;
		if(elementType === "datetime"){
			$('input[name="'+namespace+elementName+'"]').daterangepicker({
			    singleDatePicker: true,
			    showDropdowns: true,
			    timePicker: true,
			    timePicker24Hour: true,
			    locale: {
			            format: format
			        }
			  });
		}else if(elementType === "date"){
			$('input[name="'+namespace+elementName+'"]').daterangepicker({
			    singleDatePicker: true,
			    showDropdowns: true,
			    timePicker: false,
			    timePicker24Hour: true,
			    locale: {
			            format: format
			        }
			  });
		}else if(elementType === "time"){
			$('input[name="'+namespace+elementName+'"]').daterangepicker({
			    singleDatePicker: true,
			    timePicker: true,
			    timePicker24Hour: true,
			    timePickerIncrement : 1,
			    timePickerSeconds : true,
			    locale: {
			            format: format
			        }
			  }).on('show.daterangepicker', function(ev, picker) {
		            picker.container.find(".calendar-table").hide();
			   });
		}
		
	}
	
	createInputNumberEl = function(className, id, changeEventObj){
		var inputNumberEl, inputNumberElAttrObj = new Object({});
		inputNumberElAttrObj['type'] = 'number';
		inputNumberElAttrObj['class'] = className;
		if(id){
			inputNumberElAttrObj['id'] = namespace + id;
			inputNumberElAttrObj['name'] = namespace + id;
		}
		if(changeEventObj){
			inputNumberElAttrObj['onchange'] = changeEventObj.fnName;
		}
		inputNumberEl = $('<input>', inputNumberElAttrObj);
		return inputNumberEl;
	};
	
	createTextAreaEl = function(className, id, rows, cols){
		var inputTextAreaEl, inputTextAreaElAttrObj = new Object({});
		inputTextAreaElAttrObj['class'] = className;
		inputTextAreaElAttrObj['rows'] = rows;
		inputTextAreaElAttrObj['cols'] = cols;
		
		if(id){
			inputTextAreaElAttrObj['id'] = namespace + id;
			inputTextAreaElAttrObj['name'] = namespace + id;
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
	
	createIcon = function(className){
		var italicEl, italicElAttrObj = new Object({});
		italicElAttrObj['class'] = className;
		italicEl = $('<i>', italicElAttrObj);
		return italicEl;
	};
	
	createAnchor = function(attrs){
		return anchorEl = $('<a>', attrs);
	};
	
	createButtonEl = function(className, id, changeEventObj, buttonText){
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
		buttonEl = $('<button>', buttonElAttrObj);
		return buttonEl;
	};
	
	createDropdown = function(className, id, changeEventObj, isMultiselect){
		var dropdownEl, dropdownElAttrObj = new Object({});
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
		dropdownEl = $('<select>', dropdownElAttrObj);
		$(dropdownEl).append($('<option>', {
	        value: '',
	        text: '--Select--'
	    }));
		
		return dropdownEl;
	};
	createInputCheckboxEl = function(labelClass, forLabel, inputClass, id, inputText, changeEventObj, dataAttr){
		var formCheckDivEl, inputCheckboxEl, checkboxLabelEl, inputCheckboxElAttrObj = new Object({}), checkboxLabelElAttrObj = new Object({});
		
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

		inputCheckboxEl = $('<input>', inputCheckboxElAttrObj);
		
		$(formCheckDivEl).append(inputCheckboxEl);
		$(formCheckDivEl).append(checkboxLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputCheckboxDynamicEl = function(labelClass, forLabel, inputClass, id, inputText, changeEventObj, dataAttr){
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
	
	createInputRadioEl = function(labelClass, forLabel, inputClass, id, name, inputText){
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
		
		inputRadioEl = $('<input>', inputRadioElAttrObj);
		
		$(formCheckDivEl).append(inputRadioEl);
		$(formCheckDivEl).append(radioLabelEl);
		
		return formCheckDivEl;
	};
	
	createInputRadioDynamicEl = function(labelClass, forLabel, inputClass, id, name, inputText){
		var formCheckDivEl, inputRadioEl, radioLabelEl, inputRadioElAttrObj = new Object({}), radioLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl('form-check-inline');
		
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
		
		inputRadioEl = $('<input>', inputRadioElAttrObj);
		
		$(formCheckDivEl).append(inputRadioEl);
		$(formCheckDivEl).append(radioLabelEl);
		
		return formCheckDivEl;
	};
	
	populateDropdown = function(data, dropdownEl){
		$(dropdownEl).find('.dt-option').remove();
		for (const key of data) {
		    $(dropdownEl).append($('<option>', {
		        value: key.value,
		        text: key.label,
		        class : 'dt-option',
		        disabled: key.isDisabled
		    }));
		}
	};
	createCardEl = function(cardTitle, cardHeading){
		
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
	createAccordianCardEl = function(accordianId, cardTitle){
		
		var rowDivEl, colDivEl, accordianDivEl, cardDivEl, cardHeaderDivEl, cardHeaderAnchorEl, cardBodyAccordianDivEl, cardBodyDivEl, accordianHeaderId, accordianBodyId,
			accordianCardBodyId;
		
		accordianHeaderId = accordianId + 'Header';
		accordianBodyId = accordianId + 'Body';
		accordianCardBodyId = accordianId + 'CardBody';
		
		rowDivEl = createDivEl('row');
		colDivEl = createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
		accordianDivEl = createDivEl('accordion', accordianId);
		cardDivEl = createDivEl('card');
		cardHeaderDivEl = createDivEl('card-header', accordianHeaderId);
		var anchorAttrsObj = {
			'href' : '#',
			'class' : 'btn btn-header-link anchor-settings-accordian',
			'data-toggle' : 'collapse',
			'data-target' : '#' + namespace + accordianBodyId,
			'aria-expanded' : 'true',
			'aria-controls' : namespace + accordianBodyId
		};
		cardHeaderAnchorEl = createAnchor(anchorAttrsObj);
		$(cardHeaderAnchorEl).append(cardTitle);
		
		cardBodyAccordianDivEl = createDivEl('collapse show card-body-accordian-settings',accordianBodyId);
		$(cardBodyAccordianDivEl).attr('aria-labelledby', namespace + accordianHeaderId);
		$(cardBodyAccordianDivEl).attr('data-parent', '#' + namespace + accordianId);
		cardBodyDivEl = createDivEl('card-body card-body-settings-div-el', accordianCardBodyId);
		
		$(cardHeaderDivEl).append(cardHeaderAnchorEl);
		$(cardDivEl).append(cardHeaderDivEl);
		
		$(cardBodyAccordianDivEl).append(cardBodyDivEl);
		$(cardDivEl).append(cardBodyAccordianDivEl);
		
		$(accordianDivEl).append(cardDivEl);
		$(colDivEl).append(accordianDivEl);
		$(rowDivEl).append(colDivEl);
		
		return rowDivEl;
		
	};
	

	createMultifileUploadDynamicEl = function(labelClass, forLabel, inputClass, id, name, inputText){
		var formCheckDivEl, inputRadioEl, fileLabelEl,dropzoneFileAreaDivEl,dzMessageDivEl,h3tagElAttrObj,h3tagEl,inputTextElAttrObj = new Object({}), fileLabelElAttrObj = new Object({});
		
		formCheckDivEl = createDivEl('form-group');
		
		fileLabelElAttrObj['for'] = namespace + forLabel;
		if(labelClass){
			fileLabelElAttrObj['class'] = labelClass;
		}
		fileLabelEl = $('<label>', fileLabelElAttrObj);
		
		$(fileLabelEl).append(inputText);
		
		inputTextElAttrObj['type'] = 'hidden';
		inputTextElAttrObj['class'] = inputClass;
		
			inputTextElAttrObj['id'] = "file";
		
		if(name){
			inputTextElAttrObj['name'] = namespace + "file";
		}
		
		inputTextEl = $('<input>', inputTextElAttrObj);
		dropzoneFileAreaDivEl = createDivEl('dropzone dropzone-file-area',id);
		
		dzMessageDivEl = createDivEl('dz-default dz-message');
		
		h3tagElAttrObj = new Object({});
		
		 h3tagEl = $('<h3>', h3tagElAttrObj);
		$(h3tagEl).append("Drop files here to upload or You can also click to open file browser");
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
	
	commonFc.initConfigVars = initConfigVars;
	commonFc.initTextEditor = initTextEditor;
	commonFc.hideNoteModalSummernote = hideNoteModalSummernote;
	commonFc.loadMultifileDropZone = loadMultifileDropZone;
	commonFc.createDivEl = createDivEl;
	commonFc.createLabel = createLabel;
	commonFc.createInputTextEl = createInputTextEl;
	commonFc.createInputDateEl = createInputDateEl;
	commonFc.dateRangePickerConfig = dateRangePickerConfig;
	commonFc.createInputCheckboxDynamicEl = createInputCheckboxDynamicEl;
	commonFc.createInputRadioDynamicEl = createInputRadioDynamicEl;
	commonFc.createMultifileUploadDynamicEl = createMultifileUploadDynamicEl;
	commonFc.createInputFileEl = createInputFileEl;
	commonFc.createInputNumberEl = createInputNumberEl;
	commonFc.createTextAreaEl = createTextAreaEl;
	commonFc.createTextEditorEl = createTextEditorEl;
	commonFc.createHead = createHead;
	commonFc.createIcon = createIcon;
	commonFc.createAnchor = createAnchor;
	commonFc.createButtonEl = createButtonEl;
	commonFc.createDropdown = createDropdown;
	commonFc.createInputCheckboxEl = createInputCheckboxEl;
	commonFc.createInputRadioEl = createInputRadioEl;
	commonFc.populateDropdown = populateDropdown;
	commonFc.createCardEl = createCardEl;
	commonFc.createAccordianCardEl = createAccordianCardEl;
	commonFc.createTableEl = createTableEl;
	commonFc.createTREl = createTREl;
	commonFc.createTHEl = createTHEl;
	commonFc.createTDEl = createTDEl;
	commonFc.createTheadEl = createTheadEl;
	commonFc.createTbodyEl = createTbodyEl;
	
})($, (window.commonFc = window.commonFc || {}));