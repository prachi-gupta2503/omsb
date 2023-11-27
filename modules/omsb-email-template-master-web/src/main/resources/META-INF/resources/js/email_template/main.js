(function(_, $, omsbPortlet) {
	var subjectSelectedLocale = "en_US";
	function viewEmailTemplateFc(config) {
		var namespace = config.namespace,
			contextPath = config.contextPath,
			viewEmailTemplateURL = config.viewEmailTemplateURL,
			editEmailTemplateURL = config.editEmailTemplateURL,
			emailTemplateDataTableJEl = config.emailTemplateDataTableJEl,
			deleteConformationModalJEl = config.deleteConformationModalJEl,
			templateIdJEl = config.templateIdJEl,
			emailTemplateTable, themeImagesPath;
			
		
		var currentAvailableLocales = [
			{'label':'en-US', 'value':'en_US'},
			{'label':'ar-SA', 'value':'ar_SA'}
		];
		
		initDataTable = function(){
			var emailTemplate, table, processingMsg, emptyMsg, dataParams, dataColumns,
				dataTableConfig;
			
			dataParams = {
			};
			
			dataColumns = [
				{ "data": "id", "name": "id", "orderable": "false"},
				{ 
		    		"data": "templateName", 
		    		"name": "templateName", 
		    		"orderable": "false",
		    		"className": "name",
	    			"render": function(data, type, row, meta){
						data = '<td>'
							+		'<a href="javascript:void(0);" onclick="omsbPortlet.viewEmailTemplateFc.editEmailTemplate('+row.id+')">'+ data +'</a>'
							+	'</td>';
						return data;
			        } 	
		    	},
				{ "data": "createdBy",  "name": "createdBy", "orderable": "false"},
				{ "data": "createdDateTime",  "name": "createdDateTime", "orderable": "false"},
				{ "data": "modifiedBy",  "name": "modifiedBy", "orderable": "false"},
				{ "data": "modifiedDateTime",  "name": "modifiedDateTime", "orderable": "false"},
				{
					"data": 'action',
					"name": "action",
					"className": "action-icon",
					"render": function(data, type, row, meta){
						data = '<td>' 
							+		'<a href="javascript:void(0)" data-id="'+row.id+'" data-toggle="tooltip"' 
							+		'data-trigger="hover" data-placement="top" data-title="Delete" data-original-title="Delete"' 
							+		'onclick="omsbPortlet.viewEmailTemplateFc.deleteEmailTemplate(this, event);">' 
							+		'<i class="fa fa-trash" aria-hidden="true"></i></a>'
							+	'</td>';
						return data;
			         }
					}
			];
		    
			dataTableConfig = new Object({});
			dataTableConfig.dataTableJEl = emailTemplateDataTableJEl;
			dataTableConfig.ajaxURL = viewEmailTemplateURL;
			dataTableConfig.dataParams = dataParams;
			dataTableConfig.processingMsg = Liferay.Language.get("datatable-processing");
			dataTableConfig.emptyMsg = Liferay.Language.get("no-email-templates-found-msg");
			dataTableConfig.dataColumns = dataColumns;
			
			emailTemplateTable = initJqueryDT(dataTableConfig);
			
		};
		
		function initJqueryDT(config){
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
				"dom": '<"oveflow"rt><"bottom"ipl><"clear">',
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
		
		editEmailTemplate = function(id) {
			var url = editEmailTemplateURL;
			url = url.replace('TEMPLATE_ID', id);
			window.location.href = url;
		};

		deleteEmailTemplate = function(obj,e) {
			e.preventDefault();
			var id = $(obj).attr('data-id');
			$(templateIdJEl).val(id);
			$(deleteConformationModalJEl).modal('show'); 
		};
		
		init = function(){
			// Remove Modal Backdrop if opened
			if(!$('.modal').is(':visible') && $('.modal-backdrop').length > 0){
				$('.modal-backdrop').remove();
			}
			initDataTable();
//			initEvents();
		};
		
		init();
		
		viewEmailTemplateFc.editEmailTemplate = editEmailTemplate;
		viewEmailTemplateFc.deleteEmailTemplate = deleteEmailTemplate;
	};
	
	function addEditEmailTemplateFc(config) {
		var namespace = config.namespace,
			contextPath = config.contextPath,
			getCategoryTagsURL = config.getCategoryTagsURL,
			emailTemplateFormJEl = config.emailTemplateFormJEl,
			saveButtonJEl = config.saveButtonJEl,
			backButtonJEl = config.backButtonJEl,
			templateIdJEl = config.templateIdJEl,
			senderTypeJEl = config.senderTypeJEl,
			subjectEN_USJEl = config.subjectEN_USJEl,
			subjectAR_SAJEl = config.subjectAR_SAJEl,
			customSenderEmailSectionJEl = config.customSenderEmailSectionJEl,
			senderEmailIdJEl = config.senderEmailIdJEl,
			defaultCCJEl = config.defaultCCJEl,
			defaultBCCJEl = config.defaultBCCJEl,
			bodyType1JEl = config.bodyType1JEl,
			bodyType2JEl = config.bodyType2JEl,
			body1JEl = config.body1JEl,
			body2JEl = config.body2JEl,
			body1HiddenJEl = config.body1HiddenJEl,
			body1MsgJEl = config.body1MsgJEl,
			body1FormGroupJEl = config.body1FormGroupJEl,
			body2FormGroupJEl = config.body2FormGroupJEl,
			signatureMsgJEl = config.signatureMsgJEl,
			signatureFormGroupJEl = config.signatureFormGroupJEl,
			signatureHiddenJEl = config.signatureHiddenJEl,
			attachmentFileUploadLimit = config.attachmentFileUploadLimit,
			attachmentSectionJEl = config.attachmentSectionJEl,
			attachmentFormGroup1JEl = config.attachmentFormGroup1JEl,
			attachmentBtnSectionJEl = config.attachmentBtnSectionJEl,
			attachmentActionBtn1JEl = config.attachmentActionBtn1JEl,
			addMoreAttachmentBtn1JEl = config.addMoreAttachmentBtn1JEl,
			clearMoreAttachmentBtn1JEl = config.clearMoreAttachmentBtn1JEl,
			addMoreAttachmentErrorDialogJEl = config.addMoreAttachmentErrorDialogJEl,
			deleteAttachmentFileConformationModalJEl = config.deleteAttachmentFileConformationModalJEl,
			deletingFileAttachmentIdJEl = config.deletingFileAttachmentIdJEl,
			deletingFileAttachmentIndJEl = config.deletingFileAttachmentIndJEl,
			deleteFileAttachmentButtonJEl = config.deleteFileAttachmentButtonJEl,
			deletedFileEntryIdsJEl = config.deletedFileEntryIdsJEl,
			bodyTag1JEl = config.bodyTag1JEl,
			bodyTag2JEl = config.bodyTag2JEl,
			subjectTagJEl = config.subjectTagJEl,
			signatureTagJEl = config.signatureTagJEl,
			addBodyTag1JEl = config.addBodyTag1JEl,
			addBodyTag2JEl = config.addBodyTag2JEl,
			subjectJEl = config.subjectJEl,
			addSubjectTagJEl = config.addSubjectTagJEl,
			addSignatureTagJEl = config.addSignatureTagJEl,
			allowedFileExtensions = decodeURI(config.allowedFileExtensions),
			attachmentFileEntriesMapLen = config.attachmentFileEntriesMapLen,
			templateNameVaildator = config.templateNameVaildator,
			senderTypeValidator = config.senderTypeValidator,
			bodyType1Vaildator = config.bodyType1Vaildator,
			body1Vaildator = config.body1Vaildator,
			subjectVaildator = config.subjectVaildator,
			defaultCCVaildator = config.defaultCCVaildator,
			defaultBCCVaildator = config.defaultBCCVaildator,
			emailTemplateMasterCCVal = decodeURI(config.emailTemplateMasterCCVal),
			emailTemplateMasterBCCVal = decodeURI(config.emailTemplateMasterBCCVal),
			userNotificationJEl = config.userNotificationJEl,
			userNotificationRadioRowJEl = config.userNotificationRadioRowJEl,
			userNotificationEditorRadioJEl = config.userNotificationEditorRadioJEl,
			userNotificationTextareaRadioJEl = config.userNotificationTextareaRadioJEl,
			userNotificationElJEl = config.userNotificationElJEl,
			userNotificationEditorRowJEl = config.userNotificationEditorRowJEl,
			userNotificationEditorJEl = config.userNotificationEditorJEl,
			userNotificationTextareaRowJEl = config.userNotificationTextareaRowJEl,
			userNotificationTextareaJEl = config.userNotificationTextareaJEl,
			userNotificationTextareaValidator = config.userNotificationTextareaValidator,
			userNotificationEditorHiddenJEl = config.userNotificationEditorHiddenJEl,
			userNotificationEditorMsgJEl = config.userNotificationEditorMsgJEl,
			isCustomSenderRuleApplied = false, attachmentFileUploadCounter = 1,
			emailSubjectSelectedLocaleJEl = config.emailSubjectSelectedLocaleJEl,
			emailDynamicBodySelectedLocaleJEl = config.emailDynamicBodySelectedLocaleJEl,
			emailStaticBodySelectedLocaleJEl = config.emailStaticBodySelectedLocaleJEl,
			emailSignatureSelectedLocaleJEl = config.emailSignatureSelectedLocaleJEl,
			deletedFileEntryIdArray = [],
			themeImagesPath = config.themeImagesPath,
			dynamicBodyEnUSJEl = config.dynamicBodyEnUSJEl,
			dynamicBodyArSAJEl = config.dynamicBodyArSAJEl,
			dynamicBodyEnUSContainerJEl = config.dynamicBodyEnUSContainerJEl,
			dynamicBodyArSAContainerJEl = config.dynamicBodyArSAContainerJEl,
			dynamicBodyEnUSHiddenJEl = config.dynamicBodyEnUSHiddenJEl,
			dynamicBodyArSAHiddenJEl = config.dynamicBodyArSAHiddenJEl,
			staticBodyEnUSJEl= config.staticBodyEnUSJEl,
			staticBodyArSAJEl = config.staticBodyArSAJEl,
			staticBodyArSAHiddenJEl = config.staticBodyArSAHiddenJEl,
			staticBodyEnUSHiddenJEl = config.staticBodyEnUSHiddenJEl,
			staticBodyArSAContainerJEl = config.staticBodyArSAContainerJEl,
			staticBodyEnUSContainerJEl = config.staticBodyEnUSContainerJEl,
			signatureEnUSJEl = config.signatureEnUSJEl,
			signatureArSAJEl = config.signatureArSAJEl,
			signatureArSAHiddenJEl = config.signatureArSAHiddenJEl,
			signatureEnUSHiddenJEl = config.signatureEnUSHiddenJEl,
			signatureArSAContainerJEl = config.signatureArSAContainerJEl,
			signatureEnUSContainerJEl = config.signatureEnUSContainerJEl,
			isEdit = config.isEdit,
			userNotificationHTMLSelectedLocaleJEl = config.userNotificationHTMLSelectedLocaleJEl,
			userNotificationTextareaSelectedLocaleJEl = config.userNotificationTextareaSelectedLocaleJEl, 
			enUSUserNotificationEditorBodyJEl = config.enUSUserNotificationEditorBodyJEl,
			arSAUserNotificationEditorBodyJEl = config.arSAUserNotificationEditorBodyJEl,
			enUSUserNotificationTextareaJEl = config.enUSUserNotificationTextareaJEl,
			arSAUserNotificationTextareaJEl = config.arSAUserNotificationTextareaJEl,
			arSAUserNotificationEditorBodyContainerJEl = config.arSAUserNotificationEditorBodyContainerJEl,
			enUSUserNotificationEditorBodyContainerJEl = config.enUSUserNotificationEditorBodyContainerJEl,
			emailTemplateSubject;
			if(isEdit){
				emailTemplateSubject = config.emailTemplateSubject;
			}
		
		$(subjectAR_SAJEl).hide();
		$(dynamicBodyArSAContainerJEl).hide();
		$(staticBodyArSAContainerJEl).hide();
		$(signatureArSAContainerJEl).hide();
		$(arSAUserNotificationEditorBodyContainerJEl).hide();
		$(arSAUserNotificationTextareaJEl).hide();
		
		b64DecodeUnicode = function(str){
		    return decodeURIComponent(atob(str).split('').map(function(c) {
		        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
		    }).join(''));
		};
		
		if(isEdit){
			var subjectJSON = JSON.parse(emailTemplateSubject);
			console.log('subjectJSON :::::', subjectJSON);
			$(subjectEN_USJEl).val(b64DecodeUnicode(subjectJSON.en_US));
			$(subjectAR_SAJEl).val(b64DecodeUnicode(subjectJSON.ar_SA));
		}
		
		getEN_USLocaleHtmlText = function () {
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
		
		getSubjectSelectedLocale = function(subjectTagVal){
			var curLocaleValue, updatedSubjectVal;
			console.log('subjectSelectedLocale :: ', subjectSelectedLocale);
			if(subjectSelectedLocale == 'en_US'){
				curLocaleValue = $(subjectEN_USJEl).val();
				updatedSubjectVal = curLocaleValue + " " + subjectTagVal;
				curLocaleValue = $(subjectEN_USJEl).val(updatedSubjectVal);
			} else if(subjectSelectedLocale == 'ar_SA'){
				curLocaleValue = $(subjectAR_SAJEl).val();
				updatedSubjectVal = curLocaleValue + " " + subjectTagVal;
				curLocaleValue = $(subjectAR_SAJEl).val(updatedSubjectVal);
			}
		};

		getSignatureCurSelectedLocale = function(signatureTagVal){
			var curLocaleValue, updatedSignatureVal;
			console.log('subjectSelectedLocale :: ', subjectSelectedLocale);
			if(subjectSelectedLocale == 'en_US'){
				var frameObj = $(signatureFormGroupJEl).find('iframe')[0];
				curLocaleValue = $(signatureEnUSHiddenJEl).val();
				updatedSignatureVal = curLocaleValue + " " + signatureTagVal;
				curLocaleValue = $(signatureEnUSHiddenJEl).val(updatedSignatureVal);
				frameObj.contentWindow.document.body.innerHTML = updatedSignatureVal;
			} else if(subjectSelectedLocale == 'ar_SA'){
				var frameObj = $(signatureFormGroupJEl).find('iframe')[1];
				curLocaleValue = $(signatureArSAHiddenJEl).val();
				updatedSignatureVal = curLocaleValue + " " + signatureTagVal;
				curLocaleValue = $(signatureArSAHiddenJEl).val(updatedSignatureVal);
				frameObj.contentWindow.document.body.innerHTML = updatedSignatureVal;
			}
		};
		
		getDynamicBodyCurSelectedLocale = function(bodyTag1Val){
			var curLocaleValue, updatedDynamicBodyVal;
			console.log('subjectSelectedLocale :: ', subjectSelectedLocale);
			if(subjectSelectedLocale == 'en_US'){
				var frameObj = $(body1FormGroupJEl).find('iframe')[0];
				curLocaleValue = $(dynamicBodyEnUSHiddenJEl).val();
				updatedDynamicBodyVal = curLocaleValue + " " + bodyTag1Val;
				curLocaleValue = $(dynamicBodyEnUSHiddenJEl).val(updatedDynamicBodyVal);
				frameObj.contentWindow.document.body.innerHTML = updatedDynamicBodyVal;
			} else if(subjectSelectedLocale == 'ar_SA'){
				var frameObj = $(body1FormGroupJEl).find('iframe')[1];
				curLocaleValue = $(dynamicBodyArSAHiddenJEl).val();
				updatedDynamicBodyVal = curLocaleValue + " " + bodyTag1Val;
				curLocaleValue = $(dynamicBodyArSAHiddenJEl).val(updatedDynamicBodyVal);
				frameObj.contentWindow.document.body.innerHTML = updatedDynamicBodyVal;
			}
		};
		
		function addValidatorMethods(){
			$.validator.addMethod(
					"multiemails",
					 function(value, element) {
						if (this.optional(element)){ // return true on optional element
							 return true;
						}
						return validateMultipleEmails(value); 
					 },
					 $.validator.messages.multiemails
				);

				$.validator.addMethod("blankSpace", function(value) {
					return value.replace(/\s/g, '').length;
				});
				
				validateMultipleEmails = function(multipleEmails){
					var emailPattern = /^\w+([-+.'][^\s]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					var regExPattern = new RegExp(emailPattern);
					var isValidMultipleEmail = true;
					for(var i=0; i<multipleEmails.length; i++){
						if(!regExPattern.test(multipleEmails[i])){
							isValidMultipleEmail = false;
							break;
						}	
					}
					return isValidMultipleEmail;
				
				};
		}
		
		initForm = function(){
			var ruleFields = new Object({}),
			messagesFields = new Object({});
			
			addValidatorMethods();
			
			ruleFields.name = "required";
			ruleFields[senderTypeValidator] = {required:true};
			ruleFields[bodyType1Vaildator] = {required:true};
			
			ruleFields[templateNameVaildator] = {required:true, blankSpace: true};
			ruleFields[subjectVaildator] = {required:true, blankSpace: true};
			ruleFields[defaultCCVaildator] = {multiemails:true};
			ruleFields[defaultBCCVaildator] = {multiemails:true};
			   
			messagesFields[senderTypeValidator] = {required : Liferay.Language.get("select-sender-type")};
			messagesFields[bodyType1Vaildator] = {required : Liferay.Language.get("select-body-type")};
			
		
			messagesFields[templateNameVaildator] = {required : Liferay.Language.get("enter-template-name"),blankSpace : Liferay.Language.get("white-space-is-not-allowed")};
			messagesFields[subjectVaildator] = {required : Liferay.Language.get("provide-subject-line") ,blankSpace : Liferay.Language.get("white-space-is-not-allowed")};
			messagesFields[defaultCCVaildator] = { 
				multiemails : Liferay.Language.get("multiple-emails-validation-msg")
			};
			messagesFields[defaultBCCVaildator] = {multiemails : Liferay.Language.get("multiple-emails-validation-msg")};
			
			var formConfig = new Object({});
			formConfig.formJEl = emailTemplateFormJEl;
			formConfig.ruleFields = ruleFields;
			formConfig.messagesFields = messagesFields;
			
			$(emailTemplateFormJEl).validate({
				ignore: [],
			    errorElement: 'span',
			    errorClass:'help-block',
				rules : ruleFields,
				messages : messagesFields,
				errorPlacement: function (error, element) {
					if(element.hasClass('omsb-radio-field')){
						var parent = element.parent();
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(radioGroupSection).find('.input-group-error').append(error);
					}else{
						error.insertAfter(element);
					 }
				},
				highlight: function (element, errorClass) {
					if($(element).hasClass('omsb-radio-field')){
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(element).parent().addClass('has-error');
						$(radioGroupSection).find('.input-group-error').addClass('has-error');
					}else{
						$(element).parent().addClass('has-error');
						$(element).addClass('error-field');
					}
				},
				unhighlight: function(element, errorClass, validClass) {
					
				},
				success: function (error, element) {
					error.remove();
					$(element).removeAttr('aria-describedby');
					$(element).parent().removeClass('has-error');
					if($(element).hasClass('omsb-radio-field')){
						var parent = $(element).parent();
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(parent).removeClass('has-error');
						$(radioGroupSection).find('.input-group-error').empty();
						$(radioGroupSection).find('.input-group-error').removeClass('has-error');
					}else{
						$(element).removeClass('error-field');
					}
				},
				submitHandler: function (form) {
					form.submit();
				}
			});
			
			initSelect2Els = function(){
				
				var defaultCC = emailTemplateMasterCCVal.split(',');
				var defaultBCC = emailTemplateMasterBCCVal.split(',');
				
				$(defaultCCJEl).select2({
					tags: true
				});
				$(defaultBCCJEl).select2({
					tags: true
				});
				
				$(defaultCCJEl).val(defaultCC).trigger("change");
				$(defaultBCCJEl).val(defaultBCC).trigger("change");
				
				$(bodyTag1JEl).select2({
					allowClear : true,
					placeholder: Liferay.Language.get('please-select'),
					debug : true
				}).on("change", function (e) {
				      var bodyTag1Val = $(bodyTag1JEl).val();
				      var selectedCatData = $(bodyTag1JEl).select2('data');
				      var selectedCat = selectedCatData[0].text;
				});
				
				$(bodyTag2JEl).select2({
					allowClear : true,
					placeholder: Liferay.Language.get('please-select')
				}).on("change", function (e) {
				      var bodyTag2Val = $(bodyTag2JEl).val();
				      var selectedCatData = $(bodyTag2JEl).select2('data');
				      var selectedCat = selectedCatData[0].text;
				});
				
				$(subjectTagJEl).select2({
					allowClear : true,
					placeholder: Liferay.Language.get('please-select')
				}).on("change", function (e) {
				      var subjectTagVal = $(subjectTagJEl).val();
				      var selectedCatData = $(subjectTagJEl).select2('data');
				      var selectedCat = selectedCatData[0].text;
				});
				
				$(signatureTagJEl).select2({
					allowClear : true,
					placeholder: Liferay.Language.get('please-select')
				}).on("change", function (e) {
				      var signatureTagVal = $(signatureTagJEl).val();
				      var selectedCatData = $(signatureTagJEl).select2('data');
				      var selectedCat = selectedCatData[0].text;
				});
				
			};
			
			validateFileExtension = function(){
				var attachmentFileEntriesMapLenInt;
				attachmentFileEntriesMapLenInt = parseInt(attachmentFileEntriesMapLen);
				
				if(attachmentFileEntriesMapLenInt > 0){
					for(var i=1; i<=attachmentFileEntriesMapLenInt;i++){
						$('#' + namespace + 'attachmentFormGroup' + i).find('.attachment-input').rules("add", {
							extension: allowedFileExtensions,
			                messages: {
			                	extension: Liferay.Language.get("upload-valid-file-with-extension")
			                  }
			            });
					}
				}else{
					$(attachmentFormGroup1JEl).find('.attachment-input').rules("add", {
						extension: allowedFileExtensions,
		                messages: {
		                	extension: Liferay.Language.get("upload-valid-file-with-extension")
		                  }
		            });
				}
			};
			
			changeEmailTemplateLocale = function(curEl, isEmailTemplate) {
				console.log('changing email template locale...');
				var previousSelectedLocale = '';
				var selectedLocaleText = $(curEl).text();
				var selectedLocaleHtml = '';
				if(selectedLocaleText == 'en-US'){
					selectedLocaleHtml = getEN_USLocaleHtmlText();
				}else if(selectedLocaleText == 'ar-SA'){
					selectedLocaleHtml = getAR_SALocaleHtmlText();
				}
				var selectedLanguageId = $(curEl).attr('language-id');
				var reflectOnFieldId = $(curEl).attr('reflect-on-field-id');

				if(isEmailTemplate) {
					if(reflectOnFieldId == 'emailSubjectSelectedLocale') {
						previousSelectedLocale = $(emailSubjectSelectedLocaleJEl).attr('language-id');
						$(emailSubjectSelectedLocaleJEl).html(selectedLocaleHtml);
						$(emailSubjectSelectedLocaleJEl).attr('language-id', selectedLanguageId);

						var previousLocaleValue, curLocaleValue;
						if(selectedLanguageId == 'en_US'){
							$(subjectEN_USJEl).show();
							$(subjectAR_SAJEl).hide();
							curLocaleValue = $(subjectEN_USJEl).val();
							subjectSelectedLocale = 'en_US';
						} else if(selectedLanguageId == 'ar_SA'){
							$(subjectAR_SAJEl).show();
							$(subjectEN_USJEl).hide();
							curLocaleValue = $(subjectAR_SAJEl).val();
							subjectSelectedLocale = 'ar_SA';
						}
					} else if(reflectOnFieldId == 'emailDynamicBodySelectedLocale') {
						previousSelectedLocale = $(emailDynamicBodySelectedLocaleJEl).attr('language-id');
						$(emailDynamicBodySelectedLocaleJEl).html(selectedLocaleHtml);
						$(emailDynamicBodySelectedLocaleJEl).attr('language-id', selectedLanguageId);

						var previousLocaleValue, curLocaleValue;
						if(selectedLanguageId == 'en_US'){
							$(dynamicBodyEnUSContainerJEl).show();
							$(dynamicBodyArSAContainerJEl).hide();
							curLocaleValue = CKEDITOR.instances[dynamicBodyEnUSJEl].getData();
							subjectSelectedLocale = 'en_US';
						} else if(selectedLanguageId == 'ar_SA'){
							$(dynamicBodyEnUSContainerJEl).hide();
							$(dynamicBodyArSAContainerJEl).show();
							curLocaleValue = CKEDITOR.instances[dynamicBodyArSAJEl].getData();
							subjectSelectedLocale = 'ar_SA';
						}
					} else if(reflectOnFieldId == 'emailStaticBodySelectedLocale') {
						previousSelectedLocale = $(emailStaticBodySelectedLocaleJEl).attr('language-id');
						$(emailStaticBodySelectedLocaleJEl).html(selectedLocaleHtml);
						$(emailStaticBodySelectedLocaleJEl).attr('language-id', selectedLanguageId);

						var previousLocaleValue, curLocaleValue;
						if(selectedLanguageId == 'en_US'){
							$(staticBodyEnUSContainerJEl).show();
							$(staticBodyArSAContainerJEl).hide();
							curLocaleValue = CKEDITOR.instances[staticBodyEnUSJEl].getData();
						} else if(selectedLanguageId == 'ar_SA'){
							$(staticBodyEnUSContainerJEl).hide();
							$(staticBodyArSAContainerJEl).show();
							curLocaleValue = CKEDITOR.instances[staticBodyArSAJEl].getData();
						}
					} else if(reflectOnFieldId == 'emailSignatureSelectedLocale') {
						previousSelectedLocale = $(emailSignatureSelectedLocaleJEl).attr('language-id');
						$(emailSignatureSelectedLocaleJEl).html(selectedLocaleHtml);
						$(emailSignatureSelectedLocaleJEl).attr('language-id', selectedLanguageId);

						var previousLocaleValue, curLocaleValue;
						if(selectedLanguageId == 'en_US'){
							$(signatureEnUSContainerJEl).show();
							$(signatureArSAContainerJEl).hide();
							curLocaleValue = CKEDITOR.instances[signatureEnUSJEl].getData();
							subjectSelectedLocale = 'en_US';
						} else if(selectedLanguageId == 'ar_SA'){
							$(signatureEnUSContainerJEl).hide();
							$(signatureArSAContainerJEl).show();
							curLocaleValue = CKEDITOR.instances[signatureArSAJEl].getData();
							subjectSelectedLocale = 'ar_SA';
						}
					} else if(reflectOnFieldId == 'userNotificationHTMLSelectedLocale') {
						previousSelectedLocale = $(userNotificationHTMLSelectedLocaleJEl).attr('language-id');
						$(userNotificationHTMLSelectedLocaleJEl).html(selectedLocaleHtml);
						$(userNotificationHTMLSelectedLocaleJEl).attr('language-id', selectedLanguageId);

						var previousLocaleValue, curLocaleValue;
						if(selectedLanguageId == 'en_US'){
							$(enUSUserNotificationEditorBodyContainerJEl).show();
							$(arSAUserNotificationEditorBodyContainerJEl).hide();
							curLocaleValue = CKEDITOR.instances[enUSUserNotificationEditorBodyJEl].getData();
						} else if(selectedLanguageId == 'ar_SA'){
							$(enUSUserNotificationEditorBodyContainerJEl).hide();
							$(arSAUserNotificationEditorBodyContainerJEl).show();
							curLocaleValue = CKEDITOR.instances[arSAUserNotificationEditorBodyJEl].getData();
						}
					} else if(reflectOnFieldId == 'userNotificationTextareaSelectedLocale') {
						previousSelectedLocale = $(userNotificationTextareaSelectedLocaleJEl).attr('language-id');
						$(userNotificationTextareaSelectedLocaleJEl).html(selectedLocaleHtml);
						$(userNotificationTextareaSelectedLocaleJEl).attr('language-id', selectedLanguageId);

						var previousLocaleValue, curLocaleValue;
						if(selectedLanguageId == 'en_US'){
							$(enUSUserNotificationTextareaJEl).show();
							$(arSAUserNotificationTextareaJEl).hide();
							curLocaleValue = $(enUSUserNotificationTextareaJEl).val();
						} else if(selectedLanguageId == 'ar_SA'){
							$(arSAUserNotificationTextareaJEl).show();
							$(enUSUserNotificationTextareaJEl).hide();
							curLocaleValue = $(arSAUserNotificationTextareaJEl).val();
						}
					}
				} 
			};
			
			$(saveButtonJEl).click(function(){
				
				var isValid = false;
				
				isValid = $(emailTemplateFormJEl).valid();
				
				if($(body1HiddenJEl).val() != ''){
					if($(body1FormGroupJEl).hasClass('has-body-error')){
						$(body1FormGroupJEl).removeClass('has-body-error');
					}
					$(body1MsgJEl).hide();
				}else{
					$(body1FormGroupJEl).addClass('has-body-error');
					$(body1MsgJEl).show();
					isValid = false;
				}
				
				if($(signatureHiddenJEl).val() != ''){
					if($(signatureFormGroupJEl).hasClass('has-body-error')){
						$(signatureFormGroupJEl).removeClass('has-body-error');
					}
					$(signatureMsgJEl).hide();
				}else{
					$(signatureFormGroupJEl).addClass('has-body-error');
					$(signatureMsgJEl).show();
					isValid = false;
				}
				
				var value = $('input[type=radio][name="'+userNotificationElJEl+'"]:checked').val();
				var isUserNotificationChecked = $(userNotificationJEl).is(":checked");
				if($(userNotificationEditorHiddenJEl).val() != '' || value =='userNotificationTextarea' || !isUserNotificationChecked){
					if($(userNotificationEditorJEl).hasClass('has-body-error')){
						$(userNotificationEditorJEl).removeClass('has-body-error');
					}
					$(userNotificationEditorMsgJEl).hide();
				}else{
					$(userNotificationEditorJEl).addClass('has-body-error');
					$(userNotificationEditorMsgJEl).show();
					isValid = false;
				}
				
				if(isValid){
					
					var deletedFileEntryIds = deletedFileEntryIdArray.join();
					$(deletedFileEntryIdsJEl).val(deletedFileEntryIds);
//					commonFc.disableButton(saveButtonJEl);
//					commonFc.disableButton(backButtonJEl);
					$(emailTemplateFormJEl).submit();
				}
				
			});
			
			$(backButtonJEl).click(function(){
//				commonFc.disableButton(saveButtonJEl);
//				commonFc.disableButton(backButtonJEl);
				window.history.back();
			});
			
		};
		
		addFileAttachmentInput = function(isEdit){
			
			if(attachmentFileUploadCounter >= parseInt(attachmentFileUploadLimit)){
				$(addMoreAttachmentErrorDialogJEl).modal('show');
				return;
			}
			
			var attachmentFormGroupCloneEl, attachmentActionBtnCloneEl;
			
			attachmentFormGroupCloneEl = $(attachmentFormGroup1JEl).clone();
			attachmentActionBtnCloneEl = $(attachmentActionBtn1JEl).clone();
		
			$(attachmentSectionJEl).append(attachmentFormGroupCloneEl);
			$(attachmentBtnSectionJEl).append(attachmentActionBtnCloneEl);
			
			$(attachmentFormGroupCloneEl).find('.attachment-input').val('');
			
			updateMoreAttachmentIds();
			
			$(attachmentFormGroupCloneEl).find('.attachment-input').rules("add", {
				extension: allowedFileExtensions,
                messages: {
                	extension: Liferay.Language.get("upload-valid-file-with-extension")
                  }
            });
			
			var fileVal = $(attachmentFormGroupCloneEl).find('.attachment-input').val();
			
			if(!fileVal && $(attachmentFormGroupCloneEl).find('.help-block').length > 0){
				$(elObj).find('.help-block').remove();
			}
			
			if(!fileVal && $(attachmentFormGroupCloneEl).hasClass('has-error')){
				$(elObj).removeClass('has-error');
			}
			
			if(isEdit){
				$(attachmentFormGroupCloneEl).find('.attachment-view').hide();
				$(attachmentFormGroupCloneEl).find('.attachment-input').show();
				$(attachmentActionBtnCloneEl).find('.delete-btn').hide();
				$(attachmentActionBtnCloneEl).find('.clear-btn').show();
			}
			
		};
		
		clearFileAttachmentInput = function(ind){
			$('#' + namespace + 'attachmentFormGroup' + ind).remove();
			$('#' + namespace + 'attachmentActionBtn' + ind).remove();
			updateMoreAttachmentIds();
		};
		
		deleteFileAttachmentInput = function(ind, fileEntryId){
			
			$(deleteAttachmentFileConformationModalJEl).modal('show');
			$(deletingFileAttachmentIndJEl).val('');
			$(deletingFileAttachmentIdJEl).val('');
			$(deletingFileAttachmentIndJEl).val(ind);
			$(deletingFileAttachmentIdJEl).val(fileEntryId);
			
		};
		
		updateMoreAttachmentIds = function(){
			
			var attachmentFormGroup1CloneEl, attachmentActionBtn1CloneEl;
			
			$(attachmentSectionJEl).find('.form-group').each(function(ind, elObj){
				
				$(elObj).attr('id', namespace + 'attachmentFormGroup' + (ind + 1));
				if($(elObj).find('.attachment-view')){
					$(elObj).find('.attachment-view').attr('id', namespace + 'attachmentView' + (ind + 1));
				}
				$(elObj).find('.attachment-input').attr('id', namespace + 'attachment' + (ind + 1));
				$(elObj).find('.attachment-input').attr('name', namespace + 'attachment' + (ind + 1));
				
			});
			
			$(attachmentBtnSectionJEl).find('.form-group').each(function(ind, elObj){
				$(elObj).attr('id', namespace + 'attachmentActionBtn' + (ind + 1));
				
				$(elObj).find('.add-btn').attr('id', namespace + 'addMoreAttachmentBtn' + (ind + 1));
				$(elObj).find('.add-btn').attr('name', namespace + 'addMoreAttachmentBtn' + (ind + 1));
				
				$(elObj).find('.clear-btn').attr('id', namespace + 'clearMoreAttachmentBtn' + (ind + 1));
				$(elObj).find('.clear-btn').attr('name', namespace + 'clearMoreAttachmentBtn' + (ind + 1));
				$(elObj).find('.clear-btn').attr('onclick', 'omsbPortlet.addEditEmailTemplateFc.clearFileAttachmentInput(' + (ind + 1) + ')');
				
				if($(elObj).find('.delete-btn')){
					$(elObj).find('.delete-btn').attr('id', namespace + 'deleteMoreAttachmentBtn' + (ind + 1));
				}
				
				if(ind + 1 > 1){
					
					$(elObj).find('.add-btn').hide();
					
					if($(elObj).find('.delete-btn') && $('#' + namespace + 'attachmentView' + (ind + 1)).is(':visible')){
						$(elObj).find('.delete-btn').show();	
					}
					
					if($(elObj).find('.clear-btn') && $('#' + namespace + 'attachment' + (ind + 1)).is(':visible')){
						$(elObj).find('.clear-btn').show();	
					}
					
				}else{
					
					$(elObj).find('.add-btn').show();
					$(elObj).find('.clear-btn').hide();
					
					if($(elObj).find('.delete-btn') && $('#' + namespace + 'attachmentView' + (ind + 1)).is(':visible')){
						$(elObj).find('.delete-btn').show();	
					}
					
				}
				
				attachmentFileUploadCounter = ind + 1;
			});
			
		};
		
		initEvents = function(){
			$(addBodyTag1JEl).click(function(){
				var bodyTag1Val = $(bodyTag1JEl).val();
				$(bodyTag1JEl).val("").trigger('change');
				getDynamicBodyCurSelectedLocale(bodyTag1Val);
			});
			
			$(addBodyTag2JEl).click(function(){
				var bodyTag2Val = $(bodyTag2JEl).val();
				$(bodyTag2JEl).val("").trigger('change');
				var frameObj = $(body2FormGroupJEl).find('iframe')[0];
				var frameContent = frameObj.contentWindow.document.body.innerHTML;
				frameObj.contentWindow.document.body.innerHTML = frameContent + bodyTag2Val;
			});
			
			$(addSubjectTagJEl).click(function(){
				var subjectTagVal = $(subjectTagJEl).val();
				$(subjectTagJEl).val("").trigger('change');
				getSubjectSelectedLocale(subjectTagVal);
			});
			
			$(addSignatureTagJEl).click(function(){
				var signatureTagVal = $(signatureTagJEl).val();
				$(signatureTagJEl).val("").trigger('change');
				getSignatureCurSelectedLocale(signatureTagVal);
			});
			
			$(deleteFileAttachmentButtonJEl).click(function(){
				var deletingFileAttachmentId = $(deletingFileAttachmentIdJEl).val();
				var deletingFileAttachmentInd = $(deletingFileAttachmentIndJEl).val();
				
				$(deleteAttachmentFileConformationModalJEl).modal('hide');
				$(deletingFileAttachmentIdJEl).val('');
				
				$('#' + namespace + 'attachmentView' + deletingFileAttachmentInd).hide();
				$('#' + namespace + 'attachment' + deletingFileAttachmentInd).show();
				$('#' + namespace + 'deleteMoreAttachmentBtn' + deletingFileAttachmentInd).hide();
				if(parseInt(deletingFileAttachmentInd) > 1){
					$('#' + namespace + 'clearMoreAttachmentBtn' + deletingFileAttachmentInd).show();
				}
				updateMoreAttachmentIds();
				
				deletedFileEntryIdArray.push(deletingFileAttachmentId);
			});
			
			$(userNotificationJEl).on('change', function() {
				console.log("changing user notification checkbox..")
				var isUserNotificationChecked = $(userNotificationJEl).is(":checked");
				if(isUserNotificationChecked){
					validateUserNotificationRadio();
					$(userNotificationRadioRowJEl).show();
				}else{
					unValidateUserNotificationRadio();
					$('input[type=radio][name="'+userNotificationElJEl+'"]').prop('checked', false);
					$(userNotificationRadioRowJEl).hide();
					$(userNotificationEditorRowJEl).hide();
					$(userNotificationTextareaRowJEl).hide();
				}
			});
			
			$('input[type=radio][name="'+userNotificationElJEl+'"]').change(function() {
				console.log("changing user notification radio..");
				var value = $('input[type=radio][name="'+userNotificationElJEl+'"]:checked').val();
				$(userNotificationEditorRowJEl).hide();
				$(userNotificationTextareaRowJEl).hide();
				unValidateUserNotificationTextarea();
				if(value){
					if(value =='userNotificationTextarea'){
						validateUserNotificationTextarea();
						$(userNotificationTextareaRowJEl).show();
					}else{
						$(userNotificationEditorRowJEl).show();
					}
				}
			});
		};
		
		validateUserNotificationRadio = function(){
			$('input[name=' + userNotificationElJEl + ']').rules("add", {
                required: true,
                messages: {
                	required: Liferay.Language.get("this-field-is-required")
              	}
            });
		};
		
		unValidateUserNotificationRadio = function(){
			$('input[name=' + userNotificationElJEl + ']').rules('remove', 'required');
			if($('input[name=' + userNotificationElJEl + ']').parent().hasClass('has-error')){
				removeRequiredInputHighlighter('input[name=' + userNotificationElJEl + ']');
			}
		};
		
		validateUserNotificationTextarea = function(){
			$(userNotificationTextareaJEl).rules("add", {
                required: true,
                messages: {
                	required: Liferay.Language.get("add-user-notification")
              	}
            });
		};
		
		unValidateUserNotificationTextarea = function(){
			$(userNotificationTextareaJEl).rules('remove');
		};
		
		function removeRequiredInputHighlighter(elJEl){
			$(elJEl).removeAttr('aria-describedby');
			$(elJEl).removeAttr('aria-invalid');
			$(elJEl).parent().removeClass('has-error');
			$(elJEl).removeClass('error-field');
			if($(elJEl).parent().find('.help-block') && $(elJEl).parent().find('.help-block').length > 0){
				$(elJEl).parent().find('.help-block').remove();
			}
		};
		
		populateUserNotification = function(){
			var templateId = $(templateIdJEl).val();
			if(templateId && templateId > 0){
				console.log("Template id: ", templateId);
				$(userNotificationJEl).trigger('change');
				$('input[type=radio][name="'+userNotificationElJEl+'"]').trigger('change');
			}
		};
		
		init = function(){
			
			initForm();
			initSelect2Els();
			initEvents();
			validateFileExtension();
			populateUserNotification();
//			if($(templateIdJEl).val() && Number($(templateIdJEl).val()) > 0){
//				setEditModeEls();
//			}
		};
		
		init();
		
		addEditEmailTemplateFc.addFileAttachmentInput = addFileAttachmentInput;
		addEditEmailTemplateFc.clearFileAttachmentInput = clearFileAttachmentInput;
		addEditEmailTemplateFc.deleteFileAttachmentInput = deleteFileAttachmentInput;
		
	};
	
	omsbPortlet.viewEmailTemplateFc = viewEmailTemplateFc;
	omsbPortlet.addEditEmailTemplateFc = addEditEmailTemplateFc;
	
})(_, $, (window.omsbPortlet = window.omsbPortlet || {}));