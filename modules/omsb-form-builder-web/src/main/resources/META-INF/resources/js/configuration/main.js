(function($, dfPortlet) {

	var namespace, contextPath, themeImagesPath, secretPassphrase, saveFormConfigurationResourceURL, getFormDataResourceURL, workflowDefinitionArr, formBasicSectionJEl, 
		formDescriptionJEl, formEnUsDescriptionJEl, formArSaDescriptionJEl, formNameJEl, formTitleJEl, formEnUsTitleJEl, formArSaTitleJEl, formLayoutJEl, formBasicSectionModalJEl, formEncryptedDataJEl, 
		isFieldEditJEl, fieldEditSrNoJEl, isFieldDeleteJEl, fieldDeleteSrNoJEl, dfLoaderContainerJEl, 
		deleteFormFieldModalJEl, deleteFormFieldModalLabelJEl, deleteFormFieldModalSaveBtnJEl, fieldRangeCommentSelectedLocaleJEl,
		deleteFormFieldModalCancelBtnJEl, formReorderSaveChangesBtnJEl, reOrderConfirmModalJEl, rolePermissionCloseBtnJEl, saveRolePermissionJEl, openPermissionModalJEl,
		reOrderConfirmModalLabelJEl, reOrderConfirmModalSaveBtnJEl, reOrderConfirmModalCancelBtnJEl, formFieldResetBtnJEl, rangeCommentJEl,
		formVersionSaveBtnJEl, formSubmitBtnJEl, formVersionDataJEl, formVersionJEl, formDefinitionIdJEl, formNamesDataJEl, fieldDisplayRangeCommentLocaleBtnJEl,
		deleteFormFieldJEl, groupsJEl, formFieldJEl, fieldLabelJEl, fieldEnUsLabelJEl, fieldArSaLabelJEl, formFieldLabelSelectedLocaleJEl, fieldKeyJEl, fieldPostDataJEl, 
		fieldPostDataNameJEl, fieldVisibleOnJEl, fieldVisibleOnDropdownJEl, fieldVisibleOnNameJEl, fieldDisplayRangeCommentJEl,
		fieldPopulateDataJEl, fieldPopulateDataNameJEl, fieldReadFromReqParamJEl, fieldReadFromReqParamNameJEl, fieldEnUsRangeCommentJEl, fieldArSaRangeCommentJEl,
		fieldTypeJEl, fieldPlaceholderJEl, fieldEnUsPlaceholderJEl, fieldArSaPlaceholderJEl, fieldPlaceholderSelectedLocaleJEl, displayPlaceholderLocaleBtnJEl, fieldHTMLEditorPlaceholderJEl, fieldEnUsHTMLEditorPlaceholderJEl,
		fieldArSaHTMLEditorPlaceholderJEl, fieldHTMLPlaceholderSelectedLocale, displayHTMLEditorLocaleBtnJEl, fieldFormatPlaceholderJEl, fieldMinNumberPlaceholderJEl, fieldMaxNumberPlaceholderJEl, fieldValuesInputTagJEl, 
		fieldDefaultSelectedJEl, fieldDataTypeJEl, fieldStatusJEl, fieldReadonlyJEl, fieldDisableJEl, fieldDisplayRangeTotalCharacterJEl,
		fieldRequiredJEl, fieldMultipleFileUploadJEl, formFieldModalJEl, deleteFormFieldModalJEl, groupJEl, 
		fieldGroupAverageJEl, fieldOverallAverageJEl, groupTotalJEl, isRangeCommentJEl, rangeTotalCharacterJEl, overallTotalJEl, fieldGroupOrderJEl, 
		fieldMinBoundaryJEl, fieldMaxBoundaryJEl, rangeOptionsDataJEl, fieldRangeOptionsConfigTbodyJEl, formJEl, 
		formContainerJEl, formDataTableJEl, formCardHeaderJEl, formCardBodyJEl, formCardBodyLoadingRowJEl, 
		formCardBodyLoadingJEl, formBasicSectionModalBodyJEl, formBasicSectionModalFooterJEl, formBasicSectionBtnJEl, 
		formFieldModalBodyJEl, formFieldModalFooterJEl, formFieldBtnJEl, formPostAndPrepopulateFieldsDataModalJEl, 
		formPostAndPrepopulateFieldsDataModalBodyJEl, formPostAndPrepopulateFieldsDataModalFooterJEl, prePostCardJEl,
		formPostAndPrepopulateFieldsDataBtnJEl, formLayoutName, dfStaticValuesRowJEl, fieldNewLineJEl,
		fieldDisplayPlaceholderJEl, fieldDisplayHTMLEditorJEl, fieldDisplayFormatPlaceholderJEl, 
		fieldDisplayMinNumberPlaceholderJEl, fieldDisplayMaxNumberPlaceholderJEl, fieldDisplayMultipleFileUploadJEl, 
		fieldDisplayFileExtensionsInputTagJEl, fieldDisplayMinBoundaryJEl, fieldDisplayMaxBoundaryJEl, 
		fieldDisplayRangeOptionsJEl, fieldDisplayAverageJEl, fieldDisplayTotalJEl, fieldDisplayValuesInputTagJEl, 
		fieldDisplayDefaultSelectedJEl, fieldDisplayDropdownConfigCheckboxJEl, fieldDisplayWhereToPopulateDropdownJEl, fieldDisplayMasterTableRadioJEl,
		fieldTogglePostDataFieldJEl, fieldDisplayVisibleOnSelectedDropdownJEl, fieldToggleVisibleOnFieldJEl, 
		fieldTogglePopulateDataFieldJEl, fieldToggleVisibleOnDropdownFieldJEl, fieldToggleReadFromReqParamFieldJEl, 
		fieldDataProviderRowJEl, fieldDisplayDataProviderURLJEl, fieldDisplayMethodTypesJEl, fieldDisplayContentTypesJEl, 
		fieldDisplayDataProviderURLPropertyJEl, fieldDisplayDataPropsJEl, fieldDisplaySourcePropsJEl, fieldStaticValuesRowJEl, 
		fieldDisplayStaticValuesInputTagJEl, fieldDependentFieldsRowJEl, fieldDisplayDependentFieldsNameDropdownJEl, 
		fieldDisplayWhereToPopulateDependentFieldsJEl, fieldDisplayVisibleOnJEl, fieldRangeOptionsConfigRowJEl, 
		fieldDisplayRangeOptionsConfigJEl, fieldFileExtensionsInputTagJEl, fieldRangeOptionsJEl, groupJSGridJEl,
		fieldRangeOptionsConfigTableJEl, fieldMultiselectDropdownCheckboxJEl, fieldSearchableDropdownCheckboxJEl, 
		fieldWhereToPopulateDropdownJEl, fieldStaticValuesInputTagJEl, fieldDependentFieldsNameJEl, 
		fieldDFStaticValuesJSGridJEl, fieldDisplayDFStaticValuesInputTagJEl, fieldWhereToPopulateDependentFieldsJEl, 
		fieldDataProviderURLJEl, fieldMethodTypesJEl, fieldContentTypesJEl, fieldDataPropsJEl, fieldSourcePropsJEl, 
		fieldDataProviderURLPropertyJEl, addFormFieldRowButtonJEl, deleteFormFieldRowButtonJEl, formPostDataURLJEl, 
		formPostDataContentTypeJEl, formPostDataAcceptJEl, formPostDataHeadersJEl, formPostDataParamsJEl, formPrepopulateDataURLJEl, formPrepopulateDataContentTypeJEl, 
		formPrepopulateDataAcceptJEl, formPrepopulateDataHeadersJEl, formPrepopulateDataParamsJEl, dfConfigurationFormJEl, 
		getFormConfigurationResourceURL, formVersionModalJEl, formVersionModalBodyJEl, editFormFieldJEl, getFormBasicSectionResourceURL, formFieldErrJEl, groupsDivJEl, 
		fieldDisplayVisibleOnSelectedDropdownJEl, fieldExtraValidationsJEl, formBasicSectionSaveBtnJEl, formNameValidator, 
		formTitleValidator, formLayoutValidator, formDescriptionValidator, formVersionModalJEl, formVersionValidator, 
        formFieldSaveBtnJEl, fieldLabelValidator, fieldKeyValidator, fieldTypeValidator, fieldDataTypeValidator, rangeMaxCharacterJEl,
		fieldStatusValidator, inputTagsErrJEl, formVersionDataName, currentVersionRadioJEl, dfStaticInputJEl,
		newVersionRadioJEl, jsGridValidationJEl, formDataTable, formBuilderConfigJsonObj, dtData = [], BASIC_SECTION_SAVE = 1, 
		FIELDS_SECTION_SAVE = 2, REORDER_SECTION_SAVE = 3, DELETE_SECTION_SAVE = 4, SUBMIT_FORM = 5, editedRowEl, deletedRowEl, 
		settingTypes, settingDataTypes, settingStatus, dateFormats, timeFormats, dateTimeFormats, fieldDisplayDropdownStaticJSGridJEl,
		whereToPopulateDropdownValues, contentTypesArr, whereToPopulateDF, methodTypesArr, textBoxValidations, 
		textAreaValidations, numberValidations, fileValidations, passwordValidations, isJSGrid, formFieldConfirmationModal, 
        formFieldConfirmationYesBtn, formFieldConfirmationNoBtn, formBasicSectionConfirmationModal, formBasicSectionConfirmationYesBtn, 
        formBasicSectionConfirmationNoBtn, formSubmitConfirmationModal, formSubmitConfirmationYesBtn, 
        formSubmitConfirmationNoBtn, formBasicSectionSuccessAlertJEl, formBasicSectionAlertCloseBtnJEl,
        formFieldErrorAlertJEl, formFieldErrorAlertCloseBtnJEl, formBasicSectionErrMsgJEl, formFieldConfigRowSettingsAccordianJEl,
        formBasicSectionErrAlertJEl, columnNamesDataJEl, displayGroupJEl, displayDFStaticValuesInputTextJEl, postDataBSJEl, populateDataBSJEl,
        readFromReqParamBSJEl, formMasterBSJEl, displayPostDataJEl, displayPopulateDataJEl, displayReadFromReqParamJEl,
        fieldMasterTableDropdownJEl, fieldMasterTableColumnDropdownJEl, fieldMasterTableRowJEl, fieldMasterTableJEl, fieldCreateMasterTableJEl,
        readFromReqParamBSJEl, displayPostDataJEl, displayPopulateDataJEl, displayReadFromReqParamJEl, postDataAccordianJEl, populateDataAccordianJEl,
        dataProviderAcceptJEl, dataProviderHeadersJEl, dataProviderParamsJEl, fieldMasterTableTextColumnJEl, fieldMasterTableValueColumnJEl,
		formTitleSelectedLocaleJEl, formDescriptionSelectedLocaleJEl, isValidationJSGrid, formBasicSectionResetBtnJEl, fieldDisplayCheckboxRadioJSGridJEl,
		fieldDisplayRangeJSGridJEl, workflowDefinitionJEl, formFieldResetBtnConfirmationYesBtn, formFieldResetBtnConfirmationNoBtn,
		formFieldResetBtnConfirmationModal, formBasicSectionSaveBtnSpanJEl, formPreviewURLBtnJEl, fieldDisplayCustomRangeJSGridJEl, fieldDisplayCustomRangeOptionsJEl,
		rolesJson, roleIds, permissionFieldIdJEL, permissionFormFieldObjJEL, rangeOptionDataArr, displayRangeOptionNameDrJEl, rangeOptionNameDrJEl;
	
	function initVars(config){
		namespace = config.namespace;
		contextPath = config.contextPath;
		themeImagesPath = config.themeImagesPath;
		secretPassphrase = config.secretPassphrase;
		saveFormConfigurationResourceURL = config.saveFormConfigurationResourceURL;
		getFormDataResourceURL = config.getFormDataResourceURL;
		workflowDefinitionJSONArr = config.workflowDefinitionArr ? decodeURI(config.workflowDefinitionArr) : "";
		workflowDefinitionArr = workflowDefinitionJSONArr ? $.parseJSON(workflowDefinitionJSONArr) : "";
		formBasicSectionJEl = config.formBasicSectionJEl;
		formDescriptionJEl = config.formDescriptionJEl;
		formEnUsDescriptionJEl = config.formEnUsDescriptionJEl;
		formArSaDescriptionJEl = config.formArSaDescriptionJEl;
		formNameJEl = config.formNameJEl;
		formTitleJEl = config.formTitleJEl;
		formEnUsTitleJEl = config.formEnUsTitleJEl;
		formArSaTitleJEl = config.formArSaTitleJEl;
		formLayoutJEl = config.formLayoutJEl;
		formBasicSectionModalJEl = config.formBasicSectionModalJEl
		formEncryptedDataJEl = config.formEncryptedDataJEl;
		isFieldEditJEl = config.isFieldEditJEl;
		fieldEditSrNoJEl = config.fieldEditSrNoJEl;
		isFieldDeleteJEl = config.isFieldDeleteJEl;
		fieldDeleteSrNoJEl = config.fieldDeleteSrNoJEl;
		dfLoaderContainerJEl = config.dfLoaderContainerJEl;
		deleteFormFieldModalJEl = config.deleteFormFieldModalJEl;
		deleteFormFieldModalLabelJEl = config.deleteFormFieldModalLabelJEl;
		deleteFormFieldModalSaveBtnJEl = config.deleteFormFieldModalSaveBtnJEl;
		deleteFormFieldModalCancelBtnJEl = config.deleteFormFieldModalCancelBtnJEl;
		formReorderSaveChangesBtnJEl = config.formReorderSaveChangesBtnJEl;
		reOrderConfirmModalJEl = config.reOrderConfirmModalJEl;
		reOrderConfirmModalLabelJEl = config.reOrderConfirmModalLabelJEl;
		reOrderConfirmModalSaveBtnJEl = config.reOrderConfirmModalSaveBtnJEl;
		reOrderConfirmModalCancelBtnJEl = config.reOrderConfirmModalCancelBtnJEl;
		formVersionSaveBtnJEl = config.formVersionSaveBtnJEl;
		formSubmitBtnJEl = config.formSubmitBtnJEl;
		formVersionDataJEl = config.formVersionDataJEl;
		formVersionJEl = config.formVersionJEl;
		formDefinitionIdJEl = config.formDefinitionIdJEl;
		formNamesDataJEl = config.formNamesDataJEl;
		deleteFormFieldJEl = config.deleteFormFieldJEl;
		groupsJEl = config.groupsJEl;
		formFieldJEl = config.formFieldJEl;
		fieldLabelJEl = config.fieldLabelJEl;
		fieldEnUsLabelJEl = config.fieldEnUsLabelJEl;
		fieldArSaLabelJEl = config.fieldArSaLabelJEl;
		formFieldLabelSelectedLocaleJEl = config.formFieldLabelSelectedLocaleJEl;
		fieldKeyJEl = config.fieldKeyJEl;
		fieldPostDataJEl = config.fieldPostDataJEl;
		fieldPostDataNameJEl = config.fieldPostDataNameJEl;
		fieldVisibleOnJEl = config.fieldVisibleOnJEl;
		fieldNewLineJEl = config.fieldNewLineJEl;
		fieldVisibleOnDropdownJEl = config.fieldVisibleOnDropdownJEl;
		fieldVisibleOnNameJEl = config.fieldVisibleOnNameJEl;
		fieldPopulateDataJEl = config.fieldPopulateDataJEl;
		fieldPopulateDataNameJEl = config.fieldPopulateDataNameJEl;
		fieldReadFromReqParamJEl = config.fieldReadFromReqParamJEl;
		fieldReadFromReqParamNameJEl = config.fieldReadFromReqParamNameJEl;
		fieldTypeJEl = config.fieldTypeJEl;
		fieldPlaceholderJEl = config.fieldPlaceholderJEl;
		fieldEnUsPlaceholderJEl = config.fieldEnUsPlaceholderJEl;
		fieldArSaPlaceholderJEl = config.fieldArSaPlaceholderJEl;
		fieldArSaRangeCommentJEl = config.fieldArSaRangeCommentJEl;
		fieldEnUsRangeCommentJEl = config.fieldEnUsRangeCommentJEl;
		fieldPlaceholderSelectedLocaleJEl = config.fieldPlaceholderSelectedLocaleJEl;
		displayPlaceholderLocaleBtnJEl = config.displayPlaceholderLocaleBtnJEl;
		fieldHTMLEditorPlaceholderJEl = config.fieldHTMLEditorPlaceholderJEl;
		fieldEnUsHTMLEditorPlaceholderJEl = config.fieldEnUsHTMLEditorPlaceholderJEl;
		fieldArSaHTMLEditorPlaceholderJEl = config.fieldArSaHTMLEditorPlaceholderJEl;
		fieldHTMLPlaceholderSelectedLocale = config.fieldHTMLPlaceholderSelectedLocale;
		displayHTMLEditorLocaleBtnJEl = config.displayHTMLEditorLocaleBtnJEl;
		fieldFormatPlaceholderJEl = config.fieldFormatPlaceholderJEl;
		fieldMinNumberPlaceholderJEl = config.fieldMinNumberPlaceholderJEl;
		fieldMaxNumberPlaceholderJEl = config.fieldMaxNumberPlaceholderJEl;
		fieldValuesInputTagJEl = config.fieldValuesInputTagJEl;
		fieldDefaultSelectedJEl = config.fieldDefaultSelectedJEl;
		fieldDataTypeJEl = config.fieldDataTypeJEl;
		fieldStatusJEl = config.fieldStatusJEl;
		fieldReadonlyJEl = config.fieldReadonlyJEl;
		fieldDisableJEl = config.fieldDisableJEl;
		fieldRequiredJEl = config.fieldRequiredJEl;	
		fieldMultipleFileUploadJEl = config.fieldMultipleFileUploadJEl;
		formFieldModalJEl = config.formFieldModalJEl;
		deleteFormFieldModalJEl = config.deleteFormFieldModalJEl;
		groupJEl = config.groupJEl;
		fieldGroupAverageJEl = config.fieldGroupAverageJEl;
		fieldOverallAverageJEl = config.fieldOverallAverageJEl;
		groupTotalJEl = config.groupTotalJEl;
		isRangeCommentJEl = config.isRangeCommentJEl;
		rangeTotalCharacterJEl = config.rangeTotalCharacterJEl;
		overallTotalJEl = config.overallTotalJEl;
		fieldGroupOrderJEl = config.fieldGroupOrderJEl;
		fieldMinBoundaryJEl = config.fieldMinBoundaryJEl;
		fieldMaxBoundaryJEl = config.fieldMaxBoundaryJEl;
		rangeOptionsDataJEl = config.rangeOptionsDataJEl;
		fieldRangeOptionsConfigTbodyJEl = config.fieldRangeOptionsConfigTbodyJEl;
		formJEl = config.formJEl;
		formContainerJEl = config.formContainerJEl;
		formDataTableJEl = config.formDataTableJEl;
		formCardHeaderJEl = config.formCardHeaderJEl;
		formCardBodyJEl = config.formCardBodyJEl;
		formCardBodyLoadingRowJEl = config.formCardBodyLoadingRowJEl;
		formCardBodyLoadingJEl = config.formCardBodyLoadingJEl;
		formBasicSectionModalBodyJEl = config.formBasicSectionModalBodyJEl;
		formBasicSectionModalFooterJEl = config.formBasicSectionModalFooterJEl;
		formBasicSectionBtnJEl = config.formBasicSectionBtnJEl;
		formFieldConfigRowSettingsAccordianJEl = config.formFieldConfigRowSettingsAccordianJEl;
		formFieldModalBodyJEl = config.formFieldModalBodyJEl;
		formFieldModalFooterJEl = config.formFieldModalFooterJEl;
		formFieldBtnJEl = config.formFieldBtnJEl;
		formPostAndPrepopulateFieldsDataModalJEl = config.formPostAndPrepopulateFieldsDataModalJEl;
		formPostAndPrepopulateFieldsDataModalBodyJEl = config.formPostAndPrepopulateFieldsDataModalBodyJEl;
		formPostAndPrepopulateFieldsDataModalFooterJEl = config.formPostAndPrepopulateFieldsDataModalFooterJEl;
		formPostAndPrepopulateFieldsDataBtnJEl = config.formPostAndPrepopulateFieldsDataBtnJEl;
		formLayoutName = config.formLayoutName;
		fieldDisplayPlaceholderJEl = config.fieldDisplayPlaceholderJEl;
		fieldDisplayHTMLEditorJEl = config.fieldDisplayHTMLEditorJEl;
		fieldDisplayFormatPlaceholderJEl = config.fieldDisplayFormatPlaceholderJEl;
		fieldDisplayMinNumberPlaceholderJEl = config.fieldDisplayMinNumberPlaceholderJEl;
		fieldDisplayMaxNumberPlaceholderJEl = config.fieldDisplayMaxNumberPlaceholderJEl;
		fieldDisplayMultipleFileUploadJEl = config.fieldDisplayMultipleFileUploadJEl;
		fieldDisplayFileExtensionsInputTagJEl = config.fieldDisplayFileExtensionsInputTagJEl;
		fieldDisplayMinBoundaryJEl = config.fieldDisplayMinBoundaryJEl;
		fieldDisplayMaxBoundaryJEl = config.fieldDisplayMaxBoundaryJEl;
		fieldDisplayRangeOptionsJEl = config.fieldDisplayRangeOptionsJEl;
		fieldDisplayAverageJEl = config.fieldDisplayAverageJEl;
		fieldDisplayTotalJEl = config.fieldDisplayTotalJEl;
		fieldDisplayValuesInputTagJEl = config.fieldDisplayValuesInputTagJEl;
		fieldDisplayDefaultSelectedJEl = config.fieldDisplayDefaultSelectedJEl;
		fieldDisplayDropdownConfigCheckboxJEl = config.fieldDisplayDropdownConfigCheckboxJEl;
		fieldDisplayWhereToPopulateDropdownJEl = config.fieldDisplayWhereToPopulateDropdownJEl;
		fieldDisplayMasterTableRadioJEl = config.fieldDisplayMasterTableRadioJEl;
		fieldTogglePostDataFieldJEl = config.fieldTogglePostDataFieldJEl;
		fieldDisplayVisibleOnSelectedDropdownJEl = config.fieldDisplayVisibleOnSelectedDropdownJEl;
		fieldToggleVisibleOnFieldJEl = config.fieldToggleVisibleOnFieldJEl;
		fieldTogglePopulateDataFieldJEl = config.fieldTogglePopulateDataFieldJEl;
		fieldToggleVisibleOnDropdownFieldJEl = config.fieldToggleVisibleOnDropdownFieldJEl;
		fieldToggleReadFromReqParamFieldJEl = config.fieldToggleReadFromReqParamFieldJEl;
		fieldDataProviderRowJEl = config.fieldDataProviderRowJEl;
		fieldDisplayDataProviderURLJEl = config.fieldDisplayDataProviderURLJEl;
		fieldDisplayMethodTypesJEl = config.fieldDisplayMethodTypesJEl;
		fieldDisplayContentTypesJEl = config.fieldDisplayContentTypesJEl;
		fieldDisplayDataProviderURLPropertyJEl = config.fieldDisplayDataProviderURLPropertyJEl;
		fieldDisplayDataPropsJEl = config.fieldDisplayDataPropsJEl;
		fieldDisplaySourcePropsJEl = config.fieldDisplaySourcePropsJEl;
		fieldStaticValuesRowJEl = config.fieldStaticValuesRowJEl;
		fieldDisplayStaticValuesInputTagJEl = config.fieldDisplayStaticValuesInputTagJEl;
		fieldDependentFieldsRowJEl = config.fieldDependentFieldsRowJEl;
		fieldDisplayDependentFieldsNameDropdownJEl = config.fieldDisplayDependentFieldsNameDropdownJEl;
		fieldDisplayWhereToPopulateDependentFieldsJEl = config.fieldDisplayWhereToPopulateDependentFieldsJEl;
		fieldDisplayVisibleOnJEl = config.fieldDisplayVisibleOnJEl;
		fieldRangeOptionsConfigRowJEl = config.fieldRangeOptionsConfigRowJEl;
		fieldDisplayRangeOptionsConfigJEl = config.fieldDisplayRangeOptionsConfigJEl;
		fieldFileExtensionsInputTagJEl = config.fieldFileExtensionsInputTagJEl;
		fieldRangeOptionsJEl = config.fieldRangeOptionsJEl;
		fieldRangeOptionsConfigTableJEl = config.fieldRangeOptionsConfigTableJEl;
		fieldMultiselectDropdownCheckboxJEl = config.fieldMultiselectDropdownCheckboxJEl;
		fieldSearchableDropdownCheckboxJEl = config.fieldSearchableDropdownCheckboxJEl;
		fieldWhereToPopulateDropdownJEl = config.fieldWhereToPopulateDropdownJEl;
		fieldStaticValuesInputTagJEl = config.fieldStaticValuesInputTagJEl;
		fieldDisplayDFStaticValuesInputTagJEl = config.fieldDisplayDFStaticValuesInputTagJEl;
		fieldDependentFieldsNameJEl = config.fieldDependentFieldsNameJEl;
		fieldWhereToPopulateDependentFieldsJEl = config.fieldWhereToPopulateDependentFieldsJEl;
		fieldDataProviderURLJEl = config.fieldDataProviderURLJEl;
		fieldMethodTypesJEl = config.fieldMethodTypesJEl;
		fieldContentTypesJEl = config.fieldContentTypesJEl;
		fieldDataPropsJEl = config.fieldDataPropsJEl;
		fieldSourcePropsJEl = config.fieldSourcePropsJEl;
		fieldDataProviderURLPropertyJEl = config.fieldDataProviderURLPropertyJEl;
		addFormFieldRowButtonJEl = config.addFormFieldRowButtonJEl;
		deleteFormFieldRowButtonJEl = config.deleteFormFieldRowButtonJEl;
		formPostDataURLJEl = config.formPostDataURLJEl;
		formPostDataContentTypeJEl = config.formPostDataContentTypeJEl;
		formPostDataAcceptJEl = config.formPostDataAcceptJEl;
		formPostDataHeadersJEl = config.formPostDataHeadersJEl;
		formPostDataParamsJEl = config.formPostDataParamsJEl;
		formPrepopulateDataURLJEl = config.formPrepopulateDataURLJEl;
		formPrepopulateDataContentTypeJEl = config.formPrepopulateDataContentTypeJEl;
		formPrepopulateDataAcceptJEl = config.formPrepopulateDataAcceptJEl;
		formPrepopulateDataHeadersJEl = config.formPrepopulateDataHeadersJEl;
		formPrepopulateDataParamsJEl = config.formPrepopulateDataParamsJEl;
		dfConfigurationFormJEl = config.dfConfigurationFormJEl;
		getFormConfigurationResourceURL = config.getFormConfigurationResourceURL;
		formVersionModalJEl = config.formVersionModalJEl;
		formVersionModalBodyJEl = config.formVersionModalBodyJEl;
		editFormFieldJEl = config.editFormFieldJEl;
		getFormBasicSectionResourceURL = config.getFormBasicSectionResourceURL;
		formFieldErrJEl = config.formFieldErrJEl;
		groupsDivJEl = config.groupsDivJEl;
		fieldDisplayVisibleOnSelectedDropdownJEl = config.fieldDisplayVisibleOnSelectedDropdownJEl;
		fieldExtraValidationsJEl = config.fieldExtraValidationsJEl;
		formBasicSectionSaveBtnJEl = config.formBasicSectionSaveBtnJEl;
		formNameValidator = config.formNameValidator;
		formTitleValidator = config.formTitleValidator;
		formLayoutValidator = config.formLayoutValidator;
		formDescriptionValidator = config.formDescriptionValidator;
		formVersionModalJEl = config.formVersionModalJEl;
		formVersionValidator = config.formVersionValidator;
		formFieldSaveBtnJEl = config.formFieldSaveBtnJEl;
		fieldLabelValidator = config.fieldLabelValidator;
		fieldTypeValidator = config.fieldTypeValidator;
        fieldKeyValidator = config.fieldKeyValidator;
		fieldDataTypeValidator = config.fieldDataTypeValidator;
		fieldStatusValidator = config.fieldStatusValidator;
		inputTagsErrJEl = config.inputTagsErrJEl; 
		formVersionDataName = config.formVersionDataName;
		currentVersionRadioJEl = config.currentVersionRadioJEl;
		newVersionRadioJEl = config.newVersionRadioJEl;
		jsGridValidationJEl = config.jsGridValidationJEl;
		formFieldConfirmationModal = config.formFieldConfirmationModal;
		formFieldConfirmationYesBtn = config.formFieldConfirmationYesBtn;
		formFieldConfirmationNoBtn = config.formFieldConfirmationNoBtn;
		formSubmitConfirmationModal = config.formSubmitConfirmationModal;
		formSubmitConfirmationYesBtn = config.formSubmitConfirmationYesBtn;
		formSubmitConfirmationNoBtn = config.formSubmitConfirmationNoBtn;
		formBasicSectionConfirmationModal = config.formBasicSectionConfirmationModal;
		formBasicSectionConfirmationYesBtn = config.formBasicSectionConfirmationYesBtn;
		formBasicSectionConfirmationNoBtn = config.formBasicSectionConfirmationNoBtn;
        formBasicSectionSuccessAlertJEl = config.formBasicSectionSuccessAlertJEl;
        formBasicSectionAlertCloseBtnJEl = config.formBasicSectionAlertCloseBtnJEl;
        formFieldErrorAlertJEl = config.formFieldErrorAlertJEl;
        formFieldErrorAlertCloseBtnJEl = config.formFieldErrorAlertCloseBtnJEl;
        formBasicSectionErrMsgJEl = config.formBasicSectionErrMsgJEl;
        formBasicSectionErrAlertJEl = config.formBasicSectionErrAlertJEl;
		columnNamesDataJEl = config.columnNamesDataJEl;
		displayGroupJEl = config.displayGroupJEl;
        dfStaticValuesRowJEl = config.dfStaticValuesRowJEl;
        fieldDFStaticValuesJSGridJEl = config.fieldDFStaticValuesJSGridJEl;
        displayDFStaticValuesInputTextJEl = config.displayDFStaticValuesInputTextJEl;
        dfStaticInputJEl = config.dfStaticInputJEl;
		formMasterBSJEl = config.formMasterBSJEl;
        postDataBSJEl = config.postDataBSJEl;
        populateDataBSJEl = config.populateDataBSJEl;
        readFromReqParamBSJEl = config.readFromReqParamBSJEl;
        displayPostDataJEl = config.displayPostDataJEl;
        displayPopulateDataJEl = config.displayPopulateDataJEl;
        displayReadFromReqParamJEl = config.displayReadFromReqParamJEl;
        fieldMasterTableDropdownJEl = config.fieldMasterTableDropdownJEl;
        fieldMasterTableColumnDropdownJEl = config.fieldMasterTableColumnDropdownJEl;
        fieldMasterTableRowJEl = config.fieldMasterTableRowJEl; 
        fieldMasterTableJEl = config.fieldMasterTableJEl;
        fieldMasterTableTextColumnJEl = config.fieldMasterTableTextColumnJEl;
        fieldMasterTableValueColumnJEl = config.fieldMasterTableValueColumnJEl;
        groupJSGridJEl = config.groupJSGridJEl;
        postDataAccordianJEl = config.postDataAccordianJEl;
        populateDataAccordianJEl = config.populateDataAccordianJEl;
        dataProviderAcceptJEl = config.dataProviderAcceptJEl;
        dataProviderHeadersJEl = config.dataProviderHeadersJEl;
        dataProviderParamsJEl = config.dataProviderParamsJEl;
		formTitleSelectedLocaleJEl = config.formTitleSelectedLocaleJEl;
		formDescriptionSelectedLocaleJEl = config.formDescriptionSelectedLocaleJEl;
		formBasicSectionResetBtnJEl = config.formBasicSectionResetBtnJEl;
		formFieldResetBtnJEl = config.formFieldResetBtnJEl;
		fieldCreateMasterTableJEl = config.fieldCreateMasterTableJEl;
		fieldDisplayCheckboxRadioJSGridJEl = config.fieldDisplayCheckboxRadioJSGridJEl;
		fieldDisplayRangeJSGridJEl = config.fieldDisplayRangeJSGridJEl;
		workflowDefinitionJEl = config.workflowDefinitionJEl;
		formFieldResetBtnConfirmationYesBtn = config.formFieldResetBtnConfirmationYesBtn;
		formFieldResetBtnConfirmationNoBtn = config.formFieldResetBtnConfirmationNoBtn;
		formFieldResetBtnConfirmationModal = config.formFieldResetBtnConfirmationModal;
		formBasicSectionSaveBtnSpanJEl = config.formBasicSectionSaveBtnSpanJEl;
		selectedFormDefinitionId = config.selectedFormDefinitionId;
		formPreviewURLBtnJEl = config.formPreviewURLBtnJEl;
		previewFormURL = config.previewFormURL;
		fieldDisplayDropdownStaticJSGridJEl = config.fieldDisplayDropdownStaticJSGridJEl;
		prePostCardJEl = config.prePostCardJEl;
		fieldDisplayCustomRangeJSGridJEl = config.fieldDisplayCustomRangeJSGridJEl;
		fieldDisplayCustomRangeOptionsJEl = config.fieldDisplayCustomRangeOptionsJEl;
		rolesJson = config.rolesJson;
		permissionFieldIdJEL = config.permissionFieldIdJEL;
		rolePermissionCloseBtnJEl = config.rolePermissionCloseBtnJEl;
		saveRolePermissionJEl = config.saveRolePermissionJEl;
		openPermissionModalJEl = config.openPermissionModalJEl;
		roleIds = [];
		permissionFieldIdJEL = '';
		rangeOptionDataArr = config.rangeOptionDataArr? JSON.parse(commonFc.b64DecodeUnicode(config.rangeOptionDataArr)) : "";
		displayRangeOptionNameDrJEl = config.displayRangeOptionNameDrJEl;
		rangeOptionNameDrJEl = config.rangeOptionNameDrJEl;
		rangeMaxCharacterJEl = config.rangeMaxCharacterJEl;
		fieldDisplayRangeTotalCharacterJEl = config.fieldDisplayRangeTotalCharacterJEl;
		fieldDisplayRangeCommentJEl = config.fieldDisplayRangeCommentJEl;
		fieldDisplayRangeCommentLocaleBtnJEl = config.fieldDisplayRangeCommentLocaleBtnJEl;
		fieldRangeCommentSelectedLocaleJEl = config.fieldRangeCommentSelectedLocaleJEl;
		rangeCommentJEl = config.rangeCommentJEl;
	};
	
	function viewDFConfig(){
		textBoxValidations = [
			{'id':'nowhitespace', 'name':'No White Space'},
			{'id':'lettersonly', 'name':'Letters Only'},
			{'id':'letterswithbasicpunc', 'name':'Letters With Basic Punctuation'},
			{'id':'notEqualTo', 'name':'Not Equal To'},
			{'id':'email', 'name':'Email'},
			{'id':'minlength', 'name':'Minimum Length'},
			{'id':'maxlength', 'name':'Maximum Length'},
			{'id':'passportNo', 'name':'Passport Number'},
			{'id':'url', 'name':'URL'},
			{'id':'digits', 'name':'Digits'},
			{'id':'range', 'name':'Range'},
			{'id':'number', 'name':'Number'},
			{'id':'digitsWithCommaSeparated', 'name':'Digits With Comma Separated'},
			{'id':'decimalWith2Digit', 'name':'Decimal With 2 Digit'},
			{'id':'decimalWith4Digit', 'name':'Decimal With 4 Digit'},
			{'id':'decimalWith6Digit', 'name':'Decimal With 6 Digit'},
			{'id':'ipv4', 'name':'ipv4'},
			{'id':'ipv6', 'name':'ipv6'},
			{'id':'currency', 'name':'Currency'}
		];
		textAreaValidations = [
			{'id':'rangelength', 'name':'Character Range Length'}
		];
		numberValidations = [
			{'id':'min', 'name':'Minimum Number'},
			{'id':'max', 'name':'Maximum Number'},
			{'id':'lessThan', 'name':'Less Than'},
			{'id':'greaterThan', 'name':'Greater Than'},
			{'id':'lessThanEqual', 'name':'Less Than Equal'},
			{'id':'greaterThanEqual', 'name':'Greater Than Equal'},
			{'id':'number', 'name':'Number'}
		];
		fileValidations = [
			{'id':'extension', 'name':'Extension'},
			{'id':'maxsize', 'name':'Maximum Size'},
			{'id':'maxfiles', 'name':'Maximum Files'}
		];
		passwordValidations = [
			{'id':'equalTo', 'name':'Equal To'}
		];
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
			{'label':'Dropdown', 'value':'dropdown'},
			{'label':'Password', 'value':'password'},
			{'label':'Range Picker', 'value':'rangePicker'},
			{'label':'Custom Range', 'value':'customRange'}
		];
		masterFormSettingTypes = [
			{'label':'Textbox', 'value':'text'},
			{'label':'Textarea', 'value':'textarea'},
			{'label':'HTML Editor', 'value':'html'}
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
			{'label':'MM/DD/YYYY', 'value':'MM/DD/YYYY'},
			{'label':'MM-DD-YYYY', 'value':'MM-DD-YYYY'},
			{'label':'MMM/DD/YYYY', 'value':'MMM/DD/YYYY'},
			{'label':'MMM-DD-YYYY', 'value':'MMM-DD-YYYY'},
			{'label':'DD/MM/YYYY', 'value':'DD/MM/YYYY'},
			{'label':'DD-MM-YYYY', 'value':'DD-MM-YYYY'},
			{'label':'DD/MMM/YYYY', 'value':'DD/MMM/YYYY'},
			{'label':'DD-MMM-YYYY', 'value':'DD-MMM-YYYY'},
			{'label':'YYYY/MM/DD', 'value':'YYYY/MM/DD'},
			{'label':'YYYY-MM-DD', 'value':'YYYY-MM-DD'},
			{'label':'YYYY/MMM/DD', 'value':'YYYY/MMM/DD'},
			{'label':'YYYY-MMM-DD', 'value':'YYYY-MMM-DD'}
		];
		timeFormats = [
			{'label':'HH:mm:ss', 'value':'HH:mm:ss'},
			{'label':'HH:mm:ss a', 'value':'HH:mm:ss a'},
			{'label':'HH:mm', 'value':'HH:mm'},
			{'label':'HH:mm a', 'value':'HH:mm a'}
		];
		dateTimeFormats = [
			{'label':'MM/DD/YYYY HH:mm:ss', 'value':'MM/DD/YYYY HH:mm:ss'},
			{'label':'MM/DD/YYYY HH:mm:ss a', 'value':'MM/DD/YYYY HH:mm:ss a'},
			{'label':'MM/DD/YYYY HH:mm', 'value':'MM/DD/YYYY HH:mm'},
			{'label':'MM/DD/YYYY HH:mm a', 'value':'MM/DD/YYYY HH:mm a'},
			{'label':'MM-DD-YYYY HH:mm:ss', 'value':'MM-DD-YYYY HH:mm:ss'},
			{'label':'MM-DD-YYYY HH:mm:ss a', 'value':'MM-DD-YYYY HH:mm:ss a'},
			{'label':'MM-DD-YYYY HH:mm', 'value':'MM-DD-YYYY HH:mm'},
			{'label':'MM-DD-YYYY HH:mm a', 'value':'MM-DD-YYYY HH:mm a'},
			{'label':'MMM/DD/YYYY HH:mm:ss', 'value':'MMM/DD/YYYY HH:mm:ss'},
			{'label':'MMM/DD/YYYY HH:mm:ss a', 'value':'MMM/DD/YYYY HH:mm:ss a'},
			{'label':'MMM/DD/YYYY HH:mm', 'value':'MMM/DD/YYYY HH:mm'},
			{'label':'MMM/DD/YYYY HH:mm a', 'value':'MMM/DD/YYYY HH:mm a'},
			{'label':'MMM-DD-YYYY HH:mm:ss', 'value':'MMM-DD-YYYY HH:mm:ss'},
			{'label':'MMM-DD-YYYY HH:mm:ss a', 'value':'MMM-DD-YYYY HH:mm:ss a'},
			{'label':'MMM-DD-YYYY HH:mm', 'value':'MMM-DD-YYYY HH:mm'},
			{'label':'MMM-DD-YYYY HH:mm a', 'value':'MMM-DD-YYYY HH:mm a'},
			{'label':'DD/MM/YYYY HH:mm:ss', 'value':'DD/MM/YYYY HH:mm:ss'},
			{'label':'DD/MM/YYYY HH:mm:ss a', 'value':'DD/MM/YYYY HH:mm:ss a'},
			{'label':'DD/MM/YYYY HH:mm', 'value':'DD/MM/YYYY HH:mm'},
			{'label':'DD/MM/YYYY HH:mm a', 'value':'DD/MM/YYYY HH:mm a'},
			{'label':'DD-MM-YYYY HH:mm:ss', 'value':'DD-MM-YYYY HH:mm:ss'},
			{'label':'DD-MM-YYYY HH:mm:ss a', 'value':'DD-MM-YYYY HH:mm:ss a'},
			{'label':'DD-MM-YYYY HH:mm', 'value':'DD-MM-YYYY HH:mm'},
			{'label':'DD-MM-YYYY HH:mm a', 'value':'DD-MM-YYYY HH:mm a'},
			{'label':'DD/MMM/YYYY HH:mm:ss', 'value':'DD/MMM/YYYY HH:mm:ss'},
			{'label':'DD/MMM/YYYY HH:mm:ss a', 'value':'DD/MMM/YYYY HH:mm:ss a'},
			{'label':'DD/MMM/YYYY HH:mm', 'value':'DD/MMM/YYYY HH:mm'},
			{'label':'DD/MMM/YYYY HH:mm a', 'value':'DD/MMM/YYYY HH:mm a'},
			{'label':'DD-MMM-YYYY HH:mm:ss', 'value':'DD-MMM-YYYY HH:mm:ss'},
			{'label':'DD-MMM-YYYY HH:mm:ss a', 'value':'DD-MMM-YYYY HH:mm:ss a'},
			{'label':'DD-MMM-YYYY HH:mm', 'value':'DD-MMM-YYYY HH:mm'},
			{'label':'DD-MMM-YYYY HH:mm a', 'value':'DD-MMM-YYYY HH:mm a'},
			{'label':'YYYY/MM/DD HH:mm:ss', 'value':'YYYY/MM/DD HH:mm:ss'},
			{'label':'YYYY/MM/DD HH:mm:ss a', 'value':'YYYY/MM/DD HH:mm:ss a'},
			{'label':'YYYY/MM/DD HH:mm', 'value':'YYYY/MM/DD HH:mm'},
			{'label':'YYYY/MM/DD HH:mm a', 'value':'YYYY/MM/DD HH:mm a'},
			{'label':'YYYY-MM-DD HH:mm:ss', 'value':'YYYY-MM-DD HH:mm:ss'},
			{'label':'YYYY-MM-DD HH:mm:ss a', 'value':'YYYY-MM-DD HH:mm:ss a'},
			{'label':'YYYY-MM-DD HH:mm', 'value':'YYYY-MM-DD HH:mm'},
			{'label':'YYYY-MM-DD HH:mm a', 'value':'YYYY-MM-DD HH:mm a'},
			{'label':'YYYY/MMM/DD HH:mm:ss', 'value':'YYYY/MMM/DD HH:mm:ss'},
			{'label':'YYYY/MMM/DD HH:mm:ss a', 'value':'YYYY/MMM/DD HH:mm:ss a'},
			{'label':'YYYY/MMM/DD HH:mm', 'value':'YYYY/MMM/DD HH:mm'},
			{'label':'YYYY/MMM/DD HH:mm a', 'value':'YYYY/MMM/DD HH:mm a'},
			{'label':'YYYY-MMM-DD HH:mm:ss', 'value':'YYYY-MMM-DD HH:mm:ss'},
			{'label':'YYYY-MMM-DD HH:mm:ss a', 'value':'YYYY-MMM-DD HH:mm:ss a'},
			{'label':'YYYY-MMM-DD HH:mm', 'value':'YYYY-MMM-DD HH:mm'},
			{'label':'YYYY-MMM-DD HH:mm a', 'value':'YYYY-MMM-DD HH:mm a'}
		];
		whereToPopulateDropdownValues = [
			{'label':'Static Values', 'value':'staticValues'},
			{'label':'Dependent Fields', 'value':'dependentFields'},
			{'label':'Data Provider', 'value':'dataProvider'},
			{'label':'Master Table', 'value':'masterTable'}
		];
		contentTypesArr = [
			{'label':'application/x-www-form-urlencoded', 'value':'application/x-www-form-urlencoded'},
			{'label':'application/json', 'value':'application/json'}
		];
		whereToPopulateDF = [
			{'label':'Static Values', 'value':'staticValues'},
			{'label':'Data Provider', 'value':'dataProvider'}
		];
		methodTypesArr = [
			{'label':'GET', 'value':'get'},
			{'label':'POST', 'value':'post'}
		];
		acceptArr = [
			{'label':'application/json', 'value':'application/json'},
			{'label':'*/*', 'value':'*/*'},
		];
		formName = Liferay.Language.get('form-name');
		formTitle = Liferay.Language.get('form-title');
		formLayout = Liferay.Language.get('form-layout');
		formDescription = Liferay.Language.get('form-description');
		column1Layout = Liferay.Language.get('column-1-layout');
		column2Layout = Liferay.Language.get('column-2-layout');
		column3Layout = Liferay.Language.get('column-3-layout');
		column4Layout = Liferay.Language.get('column-4-layout');
		fieldLabel = Liferay.Language.get('field-label');
		fieldKey = Liferay.Language.get('field-key');
		fieldType = Liferay.Language.get('field-type');
		fieldDataType = Liferay.Language.get('field-data-type');
		fieldStatus = Liferay.Language.get('field-status');
		disabled = Liferay.Language.get('disabled');
		readonly = Liferay.Language.get('readonly');
		required = Liferay.Language.get('required');
		isMaster = Liferay.Language.get('form-master');
		postData = Liferay.Language.get('post-data');
		prepoulateData = Liferay.Language.get('prepopulate-data');
		readFromReqParam = Liferay.Language.get('read-from-req-param');
		placeholder = Liferay.Language.get('placeholder');
		htmlPlaceholder = Liferay.Language.get('html-placeholder');
		minNumber = Liferay.Language.get('min-number');
		maxNumber = Liferay.Language.get('max-number');
		multipleUplaod = Liferay.Language.get('multiple-upload');
		fileExtensions = Liferay.Language.get('file-extensions');
		min = Liferay.Language.get('min');
		max = Liferay.Language.get('max');
		rangeOptions = Liferay.Language.get('range-options');
		groupOrder = Liferay.Language.get('group-order');
		group = Liferay.Language.get('group');
		groupAverage = Liferay.Language.get('group-average');
		overallAverage = Liferay.Language.get('overall-average');
		groupTotal = Liferay.Language.get('group-total');
		rangeTotalCharacter = Liferay.Language.get('range-total-character');
		overallTotal = Liferay.Language.get('overall-total');
		values = Liferay.Language.get('values');
		defaultSelected =Liferay.Language.get('default-selected');
		format = Liferay.Language.get('format');
		multiselect = Liferay.Language.get('multiselect');
		searchable = Liferay.Language.get('searchable');
		populateValues = Liferay.Language.get('populate-values');
		staticValues = Liferay.Language.get('static-values');
		dependentFieldsName = Liferay.Language.get('dependent-fields-name');
		masterTable = Liferay.Language.get('master-table-name');
		url = Liferay.Language.get('url');
		methodTypes = Liferay.Language.get('method-types');
		contentTypes = Liferay.Language.get('content-types');
		property = Liferay.Language.get('property');
		dataProps = Liferay.Language.get('data-props');
		sourceProps = Liferay.Language.get('source-props');
		postDataFieldName = Liferay.Language.get('post-data-field-name');
		prepopulateDataFieldName = Liferay.Language.get('prepopulate-data-field-name');
		readFromReqParamName = Liferay.Language.get('read-from-req-param-name');
		visibleOn = Liferay.Language.get('visible-on');
		visibleOnName = Liferay.Language.get('visible-on-field-value');
		formVersion = Liferay.Language.get('form-version');
		currentFormVersion = Liferay.Language.get('current-form-version');
		newFormVersion = Liferay.Language.get('new-form-version');
		group = Liferay.Language.get('group');
		visibleOnName = Liferay.Language.get('visible-on-field-value');
		extraValidations = Liferay.Language.get('extra-validations');
		fieldValue = Liferay.Language.get('field-value');
		displayValues = Liferay.Language.get('display-values');
		postDataURL = Liferay.Language.get('post-data-url');
		postDataContentType = Liferay.Language.get('post-data-content-type');
		prepopulateDataURL = Liferay.Language.get('prepopulate-data-url');
		prepopulateDataContentType = Liferay.Language.get('prepopulate-data-content-type');
		enterFormBasicConfiguration = Liferay.Language.get('please-enter-form-basic-configuration');
		confirmationMessage = Liferay.Language.get('are-you-sure-you-want-to-remove');
		deleteConfirmationMessage = Liferay.Language.get("delete-confirmation-complete-message");
		masterTableColumn = Liferay.Language.get("master-table-column-name");
		masterTableTextColumn = Liferay.Language.get("master-table-text-column-name");
		masterTableValueColumn = Liferay.Language.get("master-table-value-column-name");
		accept = Liferay.Language.get("accept");
		headers = Liferay.Language.get("headers");
		params = Liferay.Language.get("params");
		createMasterTable = Liferay.Language.get('want-to-create-new-master-table');
		Yes = Liferay.Language.get('yes-create-master-table');
		No = Liferay.Language.get('no-create-master-table');
		kaleoWorkflows = Liferay.Language.get('kaleo-workflows');
		newLine = Liferay.Language.get('new-line');
		rangeNames =  Liferay.Language.get('range-names');
		rangeMaxCharacter = Liferay.Language.get('range-max-character');
		rangeCommentTextarea = Liferay.Language.get('range-comment-textarea');
		isRangeComment = Liferay.Language.get('range-comment');
		
		initFormConfig = function(){
			createFormConfiguration();
			
		};
        $(formBasicSectionAlertCloseBtnJEl).click(function(){
            $(formBasicSectionSuccessAlertJEl).removeClass('d-block');
            $(formBasicSectionSuccessAlertJEl).addClass('d-none');
            
        });
        
        function toggleFormFieldAndSubmitBtn(){
        	if($(formDefinitionIdJEl).val() != ''){
        		if(formBuilderConfigJsonObj && formBuilderConfigJsonObj.hasOwnProperty('fields') && formBuilderConfigJsonObj.fields && formBuilderConfigJsonObj.fields.length > 0){
        			$(formSubmitBtnJEl).attr('disabled', false);
        			$(formFieldBtnJEl).attr('disabled', false);
        			
        			$(formFieldBtnJEl).addClass('active');
        			$(formBasicSectionBtnJEl).addClass('active');
        		}else {
        			$(formSubmitBtnJEl).attr('disabled', true);
        			$(formFieldBtnJEl).attr('disabled', false);
        			$(formFieldBtnJEl).removeClass('active');
        			$(formBasicSectionBtnJEl).addClass('active');
        		}
        	} else {
        		$(formFieldBtnJEl).attr('disabled', true);
        		$(formSubmitBtnJEl).attr('disabled', true);
        		$(formFieldBtnJEl).removeClass('active');
    			$(formBasicSectionBtnJEl).removeClass('active');
        	}
        }
        
        toggleFormFieldAndSubmitBtn();
        
        function displayCustomError(errorMessage) {
		    alert(errorMessage);
		};
		
        $(saveRolePermissionJEl).click(function(){
            var fieldSrNo = $(permissionFieldIdJEL).val();
            var oldFieldObj = permissionFormFieldObjJEL;
            var permissionObj = new Object({});
            $.each(roleIds, function(index, roleId){
            	var add = $('#'+namespace+roleId+"_add").is(':checked');
            	var edit = $('#'+namespace+roleId+"_edit").is(':checked');
            	var view = $('#'+namespace+roleId+"_view").is(':checked');
            	var rolesPermissionObj = new Object({});
            	rolesPermissionObj.add = add;
            	rolesPermissionObj.edit = edit;
            	rolesPermissionObj.view = view;
            	permissionObj[roleId] = rolesPermissionObj;
            });
            oldFieldObj.permissions = permissionObj;
            oldFieldObj = updatePermissionFieldObjInJSON(oldFieldObj);
			updateRowInDataTable(oldFieldObj);
            $(rolePermissionCloseBtnJEl).click();
        });
       
        $(formPreviewURLBtnJEl).click(function(){
        	var formDefinitionId = $(formDefinitionIdJEl).val();
        	openPreviewFormUrl(formDefinitionId);
        });
        
        openPreviewFormUrl = function(formDefinitionId){
        	console.log('formDefinitionId: ',formDefinitionId);
        	var formPreviewURL = previewFormURL;
			formPreviewURL = formPreviewURL.replace('SELECTED_FORM_DEFINITION_ID', formDefinitionId);
			console.log('formPreviewURL: ',formPreviewURL);
			//window.location.href = formPreviewURL;
			window.open(formPreviewURL, "_blank");
        }
        
        $(formFieldErrorAlertCloseBtnJEl).click(function(){
            $(formFieldErrJEl).removeClass('d-block');
            $(formFieldErrJEl).addClass('d-none');
        });
		createFormConfiguration = function(){
			var formCardEl;
			formCardEl = commonFc.createCardEl();
			$(formCardEl).append();
			createFormBasicSection();
			//createFormVersionSection();
			createFormFieldConfig();
			createDeleteFormFieldSection();
		};
		createFormBasicSection = function(){
			var mainFormRowEl, mainFormColEl, formRow1El, formNameColEl, formNameFieldSectionEl, formTitleColEl, formTitleFieldSectionEl, formLayoutEl, 
			formRow2El, formDescriptionColEl, formDescriptionFieldSectionEl, formDescriptionLocaleColEl, formDescriptionLocaleSectionEl, formRow3El, groupsColEl,
			groupsSectionEl, workFlowDefinitionsColEl, workFlowDefinitionsEl, formMasterDataFlagRowEl, masterDataColEl, masterDataSectionEl, formPostDataFlagRowEl, 
			postDataColEl, postDataSectionEl, postDataRowEl, formPopulateDataFlagRowEl, populateDataColEl, populateDataSectionEl, populateDataRowEl, 
			formReadFromRequestParamFlagEl, readFromReqParamColEl, readFromReqParamSectionEl;
			
			mainFormRowEl = commonFc.createDivEl('row');
			mainFormColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');

			formRow1El = commonFc.createDivEl('row');
			formNameColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12');
			formNameFieldSectionEl = createFormNameField();
			formTitleColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formTitleFieldSectionEl = createFormTitleField();
			
			formLayoutColEl = commonFc.createDivEl('col-lg-5 col-md-5 col-sm-12 col-xs-12');
			formLayoutEl = createFormLayoutField();
			
			formRow2El = commonFc.createDivEl('row');
			formDescriptionColEl = commonFc.createDivEl('col-lg-8 col-md-8 col-sm-12 col-xs-12 pr-0');
			formDescriptionFieldSectionEl = createFormDescriptionField();
			formDescriptionLocaleColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-4 col-xs-4 px-0 pt-1');
			formDescriptionLocaleSectionEl = createFormDescriptionLocale();
			
			formRow3El = commonFc.createDivEl('row');
			groupsColEl = commonFc.createDivEl('col-lg-8 col-md-8 col-sm-12 col-xs-12', 'groupsDiv');
			groupsSectionEl = createGroupsField();
			
			workFlowDefinitionsColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12', 'workflowDefinitionsDiv');
			workFlowDefinitionsEl = createWorkFlowDefinitionsField();
			
			formMasterDataFlagRowEl = commonFc.createDivEl('row');
			masterDataColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			masterDataSectionEl = createFormMasterFieldInBS();

			formPostDataFlagRowEl = commonFc.createDivEl('row');
			postDataColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			postDataSectionEl = createPostDataFieldInBS();
			postDataRowEl = createPostDataFooterSection();
			
			formPopulateDataFlagRowEl = commonFc.createDivEl('row');
			populateDataColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			populateDataSectionEl = createPopulateDataFieldInBS();
			populateDataRowEl = createPrepopulateDataFooterSection();
			
			formReadFromRequestParamFlagEl = commonFc.createDivEl('row');
			readFromReqParamColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			readFromReqParamSectionEl = createReadFromReqParamFieldInBS();
			
			$(formNameColEl).append(formNameFieldSectionEl);
			$(formRow1El).append(formNameColEl);
			$(formTitleColEl).append(formTitleFieldSectionEl);
			$(formRow1El).append(formTitleColEl);
			$(formTitleColEl).append(formTitleFieldSectionEl);
			$(formLayoutColEl).append(formLayoutEl);
			$(formRow1El).append(formLayoutColEl);
			$(mainFormColEl).append(formRow1El);
			
			$(formDescriptionColEl).append(formDescriptionFieldSectionEl);
			$(formDescriptionLocaleColEl).append(formDescriptionLocaleSectionEl);
			$(formRow2El).append(formDescriptionColEl);
			$(formRow2El).append(formDescriptionLocaleColEl);

			$(groupsColEl).append(groupsSectionEl);
			$(formRow3El).append(groupsColEl);
			
			$(workFlowDefinitionsColEl).append(workFlowDefinitionsEl);
			$(formRow3El).append(workFlowDefinitionsColEl);
			
			$(mainFormColEl).append(formRow1El);
			$(mainFormColEl).append(formRow2El);
			$(mainFormColEl).append(formRow3El);

			$(masterDataColEl).append(masterDataSectionEl);
			$(formMasterDataFlagRowEl).append(masterDataColEl);
			$(mainFormColEl).append(formMasterDataFlagRowEl);
			
			$(postDataColEl).append(postDataSectionEl);
			$(formPostDataFlagRowEl).append(postDataColEl);
			$(mainFormColEl).append(formPostDataFlagRowEl);
			$(mainFormColEl).append(postDataRowEl);
			
			$(populateDataColEl).append(populateDataSectionEl);
			$(formPopulateDataFlagRowEl).append(populateDataColEl);
			$(mainFormColEl).append(formPopulateDataFlagRowEl);
			$(mainFormColEl).append(populateDataRowEl);
			
			$(readFromReqParamColEl).append(readFromReqParamSectionEl);
			$(formReadFromRequestParamFlagEl).append(readFromReqParamColEl);
			$(mainFormColEl).append(formReadFromRequestParamFlagEl);
			
			$(mainFormRowEl).append(mainFormColEl);
			$(formBasicSectionJEl).append(mainFormRowEl);
		};
		
		showPostData = function(){
			var isCheckedPostData = $(postDataBSJEl).is(':checked');
			if(isCheckedPostData){
				$('.post-data-card').removeClass('d-none');
				$('.post-data-card').addClass('d-block');
			}else{
				$('.post-data-card').removeClass('d-block');
				$('.post-data-card').addClass('d-none');
			}
		};
		
		showPopulateData = function(){
			var isCheckedPopulateData = $(populateDataBSJEl).is(':checked');
			if(isCheckedPopulateData){
				$('.populate-data-card').removeClass('d-none');
				$('.populate-data-card').addClass('d-block');
			}else{
				$('.populate-data-card').removeClass('d-block');
				$('.populate-data-card').addClass('d-none');
			}
		};
		
		createFormNameField = function(){ 
			 var formNameLabelEl, requiredEl, formNameInputEl, formGroupDivEl
			 var isReadOnly = false;
			 formNameLabelEl = commonFc.createLabel('formName',formName);
			 requiredEl = commonFc.createEm('*');
			 var formDefinitionId = $(formDefinitionIdJEl).val();	
			 if(formDefinitionId > 0){
				 isReadOnly = true;
			 }
			 formNameInputEl = commonFc.createInputTextEl('form-control', 'formName', isReadOnly);
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(formNameLabelEl).append(requiredEl);
			 $(formGroupDivEl).append(formNameLabelEl);
			 $(formGroupDivEl).append(formNameInputEl);
					 
			 return formGroupDivEl; 
		};
		
		createDFStaticValuesInputText = function(index, selectedDropdownValues){ 
			 var dfStaticInputEl, formGroupDivEl
			 var isReadOnly = true;
			 dfStaticInputEl = commonFc.createInputTextEl('form-control', 'dfStaticInput_'+index, isReadOnly, "", selectedDropdownValues.en_US);
			 $(dfStaticInputEl).attr('ar_placeholder', selectedDropdownValues.ar_SA);
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 $(formGroupDivEl).append(dfStaticInputEl);
			 return formGroupDivEl; 
		};
		
		createDFStaticValuesJSGrid = function(index){
			var dropdownStaticFieldLabelEl, dropdownStaticFieldJSGridEl, formGroupDivEl, dropdownFieldValues;
			dropdownStaticFieldJSGridEl = commonFc.createDivEl('static-values-input-tag-el contenteditable d-block', 'dfStaticValuesJSGrid_'+index);
			formGroupDivEl = commonFc.createDivEl('form-group');
			dropdownFieldValues = getLanguageFieldsJSGridArr();
			$(formGroupDivEl).append(dropdownStaticFieldJSGridEl);
			commonFc.initJsGrid(dropdownStaticFieldJSGridEl, dropdownFieldValues, isJSGrid);
			return formGroupDivEl;
		};

		createFormTitleField = function(){
			var formTitleLabelEl, formTitleInputEl, formGroupDivEl, formInputGroupDivEl, formInputGroupErrorDivEl, formInputGroupAppendDivEl, changeEventFn = new Object({});
			formGroupDivEl = commonFc.createDivEl('form-group df-input-form-group');
			formTitleLabelEl = commonFc.createLabel('formTitle', formTitle);			 
			formInputGroupDivEl = commonFc.createDivEl('input-group df-input-group');
			formInputGroupErrorDivEl = commonFc.createDivEl('input-group-error df-input-group-error');
			formTitleInputEl = commonFc.createInputTextEl('form-control df-input-group-field', 'formTitle');
			
			changeEventFn.fnName = 'changeBasicSectionLocale(this, true);';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl('formTitleSelectedLocale', changeEventFn);

			$(formInputGroupDivEl).append(formTitleInputEl);
			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);

			$(formGroupDivEl).append(formTitleLabelEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			$(formGroupDivEl).append(formInputGroupErrorDivEl);

			$(formTitleInputEl).attr("onchange", "updateHiddenFieldValue(this);");

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var formTitleLocaleInputEl;
				formTitleLocaleInputEl = commonFc.createInputTextEl('form-control', 'formTitle_' + val.value);
				$(formTitleLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(formTitleLocaleInputEl);
			});
			 
			return formGroupDivEl;
		};
		createInputGroupError = function(){
			var inputGroupErrorDivEl;
			inputGroupErrorDivEl = commonFc.createDivEl('input-group-error');
			return inputGroupErrorDivEl;
		};
		createFormLayoutField = function(){
			var formLayoutLabelEl, requiredEl, formLayoutRowEl, col1FormLayoutEl, col1FormLayoutSectionEl, col2FormLayoutEl, col2FormLayoutSectionEl, col3FormLayoutEl, col3FormLayoutSectionEl,
			col4FormLayoutEl, col4FormLayoutSectionEl, formGroupDivEl, inputGroupError;
			
			formLayoutRowEl = commonFc.createDivEl('row form-layout-row mt-2');
			
			formLayoutLabelEl = commonFc.createLabel('formLayout', formLayout);
			requiredEl = commonFc.createEm('*');
			
			col1FormLayoutEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12');
			col1FormLayoutSectionEl = createCol1FormLayoutField();
			
			col2FormLayoutEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12');
			col2FormLayoutSectionEl = createCol2FormLayoutField();
			
			col3FormLayoutEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12');
			col3FormLayoutSectionEl = createCol3FormLayoutField();
			
			col4FormLayoutEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12');
			col4FormLayoutSectionEl = createCol4FormLayoutField();
			
			formGroupDivEl = commonFc.createDivEl('form-group radio-group-section');
			inputGroupError = createInputGroupError();
			
			$(col1FormLayoutEl).append(col1FormLayoutSectionEl);
			$(formLayoutRowEl).append(col1FormLayoutEl);
			
			$(col2FormLayoutEl).append(col2FormLayoutSectionEl);
			$(formLayoutRowEl).append(col2FormLayoutEl);
			
			$(col3FormLayoutEl).append(col3FormLayoutSectionEl);
			$(formLayoutRowEl).append(col3FormLayoutEl);
			
			$(col4FormLayoutEl).append(col4FormLayoutSectionEl);
			$(formLayoutRowEl).append(col4FormLayoutEl);
			
			$(formLayoutLabelEl).append(requiredEl);
			$(formGroupDivEl).append(formLayoutLabelEl);
			$(formGroupDivEl).append(formLayoutRowEl);
			
			$(formGroupDivEl).append(inputGroupError);
			return formGroupDivEl;
		};
		createCol1FormLayoutField = function(){
			var col1FormLayoutRadioEl;
			col1FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col1FormLayout', 'form-check-input df-radio-field', 'col1FormLayout', 'formLayout', column1Layout, 'col-1');
			return col1FormLayoutRadioEl;
		};
		createCol2FormLayoutField = function(){
			var col2FormLayoutRadioEl;
			col2FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col2FormLayout', 'form-check-input df-radio-field', 'col2FormLayout', 'formLayout', column2Layout, 'col-2');
			return col2FormLayoutRadioEl;
		};
		createCol3FormLayoutField = function(){
			var col3FormLayoutRadioEl;
			col3FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col3FormLayout', 'form-check-input df-radio-field', 'col3FormLayout', 'formLayout', column3Layout, 'col-3');
			return col3FormLayoutRadioEl;
		};
		createCol4FormLayoutField = function(){
			var col4FormLayoutRadioEl;
			col4FormLayoutRadioEl = commonFc.createInputRadioEl('form-check-label', 'col4FormLayout', 'form-check-input df-radio-field', 'col4FormLayout', 'formLayout', column4Layout, 'col-4');
			return col4FormLayoutRadioEl;
		};
		createFormDescriptionField = function(){
			var formDescriptionLabelEl, formDescriptionTextEditorEl, formGroupDivEl, changeEventFn = new Object({});
			formGroupDivEl = commonFc.createDivEl('form-group');
			formDescriptionLabelEl = commonFc.createLabel('formDescription', formDescription);
			formDescriptionTextEditorEl = commonFc.createTextEditorEl('formTextEditor','formDescription');
			 
			$(formGroupDivEl).append(formDescriptionLabelEl);
			$(formGroupDivEl).append(formDescriptionTextEditorEl);

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var formDescriptionLocaleInputEl;
				formDescriptionLocaleInputEl = commonFc.createInputTextEl('form-control', 'formDescription_' + val.value);
				$(formDescriptionLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(formDescriptionLocaleInputEl);
			});

			changeEventFn.elId = 'formDescription';
			changeEventFn.isViewMode = false;
			commonFc.initTextEditor(formDescriptionTextEditorEl, changeEventFn);
			return formGroupDivEl;
		};
		createFormDescriptionLocale = function() {
			var formEmptyLabelEl, formGroupDivEl, formInputGroupDivEl, formInputGroupAppendDivEl, changeEventFn = new Object({});
			formGroupDivEl = commonFc.createDivEl('form-group');
			formEmptyLabelEl = commonFc.createLabel('');
			formInputGroupDivEl = commonFc.createDivEl('input-group');

			changeEventFn.fnName = 'changeBasicSectionLocale(this, true);';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl('formDescriptionSelectedLocale', changeEventFn);

			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);
			 
			$(formGroupDivEl).append(formEmptyLabelEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			 
			 return formGroupDivEl;
		};
		createGroupsField = function(){
			var groupsLabel, groups, fieldSettingJSGridColEl, formGroupDivEl;
			groupsLabel = commonFc.createLabel('groups', group);
            fieldSettingJSGridColEl = commonFc.createDivEl('group-div-el', 'groupJSGrid');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(groupsLabel);
			$(formGroupDivEl).append(fieldSettingJSGridColEl);
			return formGroupDivEl;
		};

		createWorkFlowDefinitionsField = function(){
			var workflowDefinitionsLabelEl, workflowDefinitionsDropdownEl, formGroupDivEl;
			workflowDefinitionsLabelEl = commonFc.createLabel('workflowDefinitions', kaleoWorkflows);
			workflowDefinitionsDropdownEl = commonFc.createDropdown('form-control', 'workflowDefinitions');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(workflowDefinitionsLabelEl);
			$(formGroupDivEl).append(workflowDefinitionsDropdownEl);
			commonFc.populateDropdown(workflowDefinitionArr, workflowDefinitionsDropdownEl);
			
			return formGroupDivEl;
		};
		
		createFormMasterFieldInBS = function() {
			var formMasterCheckboxEl;
			formMasterCheckboxEl = commonFc.createInputCheckboxEl('form-check-label form-master-bs-label field-setting-label', 'formMasterBS', 'form-check-input form-master-bs-checkbox-el', 'formMasterBS', isMaster);
			
			return formMasterCheckboxEl;
		}
		
		createPostDataFieldInBS = function(){
			var postDataCheckboxEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'showPostData(this);';
			postDataCheckboxEl = commonFc.createInputCheckboxEl('form-check-label post-data-bs-label field-setting-label', 'postDataBS', 'form-check-input post-data-bs-checkbox-el', 'postDataBS', postData, changeEventObj);
			
			return postDataCheckboxEl;
		};
		
		createPopulateDataFieldInBS = function(){
			var populateDataCheckboxEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'showPopulateData(this);';
			populateDataCheckboxEl = commonFc.createInputCheckboxEl('form-check-label populate-data-bs-label field-setting-label', 'populateDataBS', 'form-check-input populate-data-bs-checkbox-el', 'populateDataBS', prepoulateData, changeEventObj);
			
			return populateDataCheckboxEl;
		};
		
		createReadFromReqParamFieldInBS = function(){
			var readFromReqParamCheckboxEl, changeEventObj = new Object({});
			//changeEventObj.fnName = 'showPopulateData(this);';
			readFromReqParamCheckboxEl = commonFc.createInputCheckboxEl('form-check-label read-from-req-param-bs-label field-setting-label', 'readFromReqParamBS','form-check-input read-from-req-param-bs-checkbox-el', 'readFromReqParamBS', readFromReqParam);
			
			return readFromReqParamCheckboxEl;
		};
		
		createPostDataFooterSection = function(){
			var postDataAccordian, postDataRowEl, postDataURLColEl, postDataURLEl, postDataContentTypeColEl, postDataContentTypeEl, postDataAcceptColEl, postDataAcceptEl,
			gridRowEl, postDataHeadersColEl, postDataHeadersEl, postDataParamsColEl, postDataParamsEl;
			
			postDataRowEl = commonFc.createDivEl('accordion', 'groupAccordian');
			postDataAccordian = commonFc.createAccordianCardEl('accordion d-none', 'postDataAccordian', 'Post Data Configuration');
			
			postDataRowEl = commonFc.createDivEl('row');
			postDataURLColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 post-data-url-div');
			postDataURLEl = createPostDataURL();
			
			postDataContentTypeColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 post-data-content-type-div');
			postDataContentTypeEl = createPostDataContentType();
			
			postDataAcceptColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 post-data-accept-div');
			postDataAcceptEl = createPostDataAccept();
			
			gridRowEl = commonFc.createDivEl('row');
			postDataHeadersColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 post-data-headers-div');
			postDataHeadersEl = createPostDataHeaders();
			
			postDataParamsColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 post-data-params-div');
			postDataParamsEl = createPostDataParams();
			
			$(postDataURLColEl).append(postDataURLEl);
			$(postDataRowEl).append(postDataURLColEl);
			
			$(postDataContentTypeColEl).append(postDataContentTypeEl);
			$(postDataRowEl).append(postDataContentTypeColEl);
			
			$(postDataAcceptColEl).append(postDataAcceptEl);
			$(postDataRowEl).append(postDataAcceptColEl);
			
			$(postDataHeadersColEl).append(postDataHeadersEl);
			$(gridRowEl).append(postDataHeadersColEl);
			
			$(postDataParamsColEl).append(postDataParamsEl);
			$(gridRowEl).append(postDataParamsColEl);
			
			$(postDataAccordian).find('.card-body').append(postDataRowEl);
			$(postDataAccordian).find('.card-body').append(gridRowEl);
			
			return postDataAccordian;
		};
		
		createPrepopulateDataFooterSection = function(){
			var prepopulateDataAccordian, prepopulateDataRowEl, prepopulateDataURLColEl, prepopulateDataURLEl, prepopulateDataContentTypeColEl, prepopulateDataContentTypeEl,
			gridRowEl, prepopulateDataHeadersColEl, prepopulateDataHeadersEl, prepopulateDataParamsColEl, prepopulateDataParamsEl;
			
			prepopulateDataRowEl = commonFc.createDivEl('accordion', 'groupAccordian');
			prepopulateDataAccordian = commonFc.createAccordianCardEl('accordion d-none', 'populateDataAccordian', 'Prepopulate Data Configuration');
			
			prepopulateDataRowEl = commonFc.createDivEl('row');
			prepopulateDataURLColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 prepopulate-data-url-div');
			prepopulateDataURLEl = createPrepopulateDataURL();
			
			prepopulateDataContentTypeColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 prepopulate-data-content-type-div');
			prepopulateDataContentTypeEl = createPrepopulateDataContentType();
			
			prepopulateDataAcceptColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 prepopulate-data-accept-div');
			prepopulateDataAcceptEl = createPrepopulateDataAccept();
			
			gridRowEl = commonFc.createDivEl('row');
			prepopulateDataHeadersColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 post-data-headers-div');
			prepopulateDataHeadersEl = createPrepopulateDataHeaders();
			
			prepopulateDataParamsColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 post-data-params-div');
			prepopulateDataParamsEl = createPrepopulateDataParams();
			
			$(prepopulateDataURLColEl).append(prepopulateDataURLEl);
			$(prepopulateDataRowEl).append(prepopulateDataURLColEl);
			
			$(prepopulateDataContentTypeColEl).append(prepopulateDataContentTypeEl);
			$(prepopulateDataRowEl).append(prepopulateDataContentTypeColEl);
			
			$(prepopulateDataAcceptColEl).append(prepopulateDataAcceptEl);
			$(prepopulateDataRowEl).append(prepopulateDataAcceptColEl);
			
			$(prepopulateDataHeadersColEl).append(prepopulateDataHeadersEl);
			$(gridRowEl).append(prepopulateDataHeadersColEl);
			
			$(prepopulateDataParamsColEl).append(prepopulateDataParamsEl);
			$(gridRowEl).append(prepopulateDataParamsColEl);
			
			$(prepopulateDataAccordian).find('.card-body').append(prepopulateDataRowEl);
			$(prepopulateDataAccordian).find('.card-body').append(gridRowEl);
			return prepopulateDataAccordian;
		};
		
		createPostDataURL = function(){
			 var postDataURLLabelEl, requiredEl, postDataURLInputEl, formGroupDivEl;
			 postDataURLLabelEl = commonFc.createLabel('postDataURL', postDataURL);
			 requiredEl = commonFc.createEm('*');
			 postDataURLInputEl = commonFc.createInputTextEl('form-control', 'postDataURL');
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(postDataURLLabelEl).append(requiredEl);
			 $(formGroupDivEl).append(postDataURLLabelEl);
			 $(formGroupDivEl).append(postDataURLInputEl);
					 
			 return formGroupDivEl; 
		};
		
		createPostDataContentType = function(){
			var postDataContentTypeLabelEl, requiredEl, postDataContentTypeDropdownEl, formGroupDivEl;
			postDataContentTypeLabelEl = commonFc.createLabel('postDataContentType', postDataContentType);
			requiredEl = commonFc.createEm('*');
			postDataContentTypeDropdownEl = commonFc.createDropdown('form-control', 'postDataContentType');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(postDataContentTypeLabelEl).append(requiredEl);
			$(formGroupDivEl).append(postDataContentTypeLabelEl);
			$(formGroupDivEl).append(postDataContentTypeDropdownEl);
			commonFc.populateDropdown(contentTypesArr, postDataContentTypeDropdownEl);
			
			return formGroupDivEl;
		};
		
		createPostDataAccept = function(){
			var postDataAcceptLabelEl, requiredEl, postDataAcceptDropdownEl, formGroupDivEl;
			postDataAcceptLabelEl = commonFc.createLabel('postDataAccept', accept);
			requiredEl = commonFc.createEm('*');
			postDataAcceptDropdownEl = commonFc.createDropdown('form-control', 'postDataAccept');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(postDataAcceptLabelEl).append(requiredEl);
			$(formGroupDivEl).append(postDataAcceptLabelEl);
			$(formGroupDivEl).append(postDataAcceptDropdownEl);
			commonFc.populateDropdown(acceptArr, postDataAcceptDropdownEl);
			
			return formGroupDivEl;
		};
		
		getKeyValueFieldsArr = function(){
			var keyValueFieldsArr = [], fieldsKeyObj = new Object({}), fieldsValueObj = new Object({}), fieldsControlObj = new Object({});
			fieldsKeyObj.name = 'key';
			fieldsKeyObj.title = 'Key';
			fieldsKeyObj.type = 'text';
			fieldsKeyObj.validate = {
				validator: function(value, item) {
			        if(!value){
			        	displayCustomError("Please Enter Key.");
		                return false;
			        }
			        return true;
			    }
			};
			keyValueFieldsArr.push(fieldsKeyObj);
			
			fieldsValueObj.name = 'value';
			fieldsValueObj.title = 'Value';
			fieldsValueObj.type = 'text';
			fieldsValueObj.validate = {
				validator: function(value, item) {
			        if(!value){
			        	displayCustomError("Please Enter Value.");
		                return false;
			        }
			        return true;
			    }
			};
			keyValueFieldsArr.push(fieldsValueObj);
			
			fieldsControlObj.type = 'control';
			fieldsControlObj.editButton = true;
			fieldsControlObj.modeSwitchButton = false;
			fieldsControlObj.width = 25;
			keyValueFieldsArr.push(fieldsControlObj);
			
			return keyValueFieldsArr;
		};
		
		getLanguageFieldsArr = function(){
			var languageFieldsArr = [], fieldDefaultSelected = new Object({}), fieldEn_USObj = new Object({}), fieldAR_SAObj = new Object({}), fieldControlObj = new Object({});
			fieldEn_USObj.name = 'en_US';
			fieldEn_USObj.title = 'en_US';
			fieldEn_USObj.type = 'text';
			fieldEn_USObj.validate = {
				validator: function(value, item) {
			        if(!value){
			        	displayCustomError("Please Enter English Value.");
		                return false;
			        }
			        return true;
			    }
			};
			languageFieldsArr.push(fieldEn_USObj);
			
			fieldAR_SAObj.name = 'ar_SA';
			fieldAR_SAObj.title = 'ar_SA';
			fieldAR_SAObj.type = 'text';
			languageFieldsArr.push(fieldAR_SAObj);
			
			fieldDefaultSelected.name = 'default_selected';
			fieldDefaultSelected.title = 'Default Selected';
			fieldDefaultSelected.type = 'checkbox';
			languageFieldsArr.push(fieldDefaultSelected);
			
			fieldControlObj.type = 'control';
			fieldControlObj.editButton = true;
			fieldControlObj.modeSwitchButton = false;
			fieldControlObj.width = 40;
			languageFieldsArr.push(fieldControlObj);
			
			return languageFieldsArr;
		};
		
		getLanguageFieldsJSGridArr = function(){
			var languageFieldsArr = [], fieldEn_USObj = new Object({}), fieldAR_SAObj = new Object({}), fieldControlObj = new Object({});
			fieldEn_USObj.name = 'en_US';
			fieldEn_USObj.title = 'en_US';
			fieldEn_USObj.type = 'text';
			fieldEn_USObj.validate = {
				validator: function(value, item) {
			        if(!value){
			        	displayCustomError("Please Enter English Value.");
		                return false;
			        }
			        return true;
			    }
			};
			languageFieldsArr.push(fieldEn_USObj);
			
			fieldAR_SAObj.name = 'ar_SA';
			fieldAR_SAObj.title = 'ar_SA';
			fieldAR_SAObj.type = 'text';
			languageFieldsArr.push(fieldAR_SAObj);
			
			fieldControlObj.type = 'control';
			fieldControlObj.editButton = true;
			fieldControlObj.modeSwitchButton = false;
			fieldControlObj.width = 40;
			languageFieldsArr.push(fieldControlObj);
			
			return languageFieldsArr;
		};
		
		createRangeJSGrid = function(rangeFieldJSGridEl, totalItemsInserted){
			$(rangeFieldJSGridEl).jsGrid({
				onItemInserted: function(args) {
					populateRangeOptions(rangeFieldJSGridEl);
			    },
			    onItemUpdated: function(args) {
			    	populateRangeOptions(rangeFieldJSGridEl);
			    },
			    onItemDeleted: function(args) {
			    	populateRangeOptions(rangeFieldJSGridEl);
			    },
		        width: "100%",
		        inserting: true,
		        editing: true,
		        sorting: true,
		        paging: true,
		        height: "auto",
		        invalidNotify: false,
		        fields: [
			        {
			        	name: "en_US", 
			        	title: "en_US",
			        	width: 20,
			        	type: "text",
			        	validate: {
		        			validator: "required",
		                    message: function(value, item) {
		                    	if(!value){
		        		        	displayCustomError("Please Enter English Value.");
		        	                return false;
		        		        }
		                    	return true;
		                    }
			        	}
			        },
			        { 
			        	name: "ar_SA", 
			        	title:"ar_SA",
			        	type: "text", 
			        	width: 20
			        },
			        { 
			            type: "control",
			            editButton: true, 
			            width: 5,
			            modeSwitchButton: false 
			        }
		        ]
		    });	
			isJSGrid = true;
			$(".jsgrid-grid-body").removeAttr("style");
		}
		
		getRangeLanguageFieldsArr = function(){
			var languageFieldsArr = [], fieldEn_USObj = new Object({}), fieldAR_SAObj = new Object({}), fieldControlObj = new Object({});
			fieldEn_USObj.name = 'en_US';
			fieldEn_USObj.title = 'en_US';
			fieldEn_USObj.type = 'text';
			fieldEn_USObj.validate = {
				validator: function(value, item) {
			        if(!value){
			        	displayCustomError("Please Enter Range Option Value In English.");
		                return false;
			        }
			        return true;
			    }
			};
			languageFieldsArr.push(fieldEn_USObj);
			
			fieldAR_SAObj.name = 'ar_SA';
			fieldAR_SAObj.title = 'ar_SA';
			fieldAR_SAObj.type = 'text';
			languageFieldsArr.push(fieldAR_SAObj);
			
			fieldControlObj.type = 'control';
			fieldControlObj.editButton = true;
			fieldControlObj.modeSwitchButton = false;
			fieldControlObj.width = 40;
			languageFieldsArr.push(fieldControlObj);
			
			return languageFieldsArr;
		};
		
	
		createPostDataHeaders = function(){
			var postDataHeadersLabelEl, postDataHeadersJSGridEl, formGroupDivEl, postDataFields;
			postDataHeadersLabelEl = commonFc.createLabel('postDataHeaders', headers);
			postDataHeadersJSGridEl = commonFc.createDivEl('post-data-headers-div-el', 'postDataHeaders');
			formGroupDivEl = commonFc.createDivEl('form-group');
			postDataFields = getKeyValueFieldsArr();
			$(formGroupDivEl).append(postDataHeadersLabelEl);
			$(formGroupDivEl).append(postDataHeadersJSGridEl);
			commonFc.initJsGrid(postDataHeadersJSGridEl, postDataFields, isJSGrid);
			return formGroupDivEl;
		};
		
		createPostDataParams = function(){
			var postDataParamsLabelEl, postDataParamsJSGridEl, formGroupDivEl, postDataFields;
			postDataParamsLabelEl = commonFc.createLabel('postDataParams', params);
			postDataParamsJSGridEl = commonFc.createDivEl('post-data-params-div-el', 'postDataParams');
			formGroupDivEl = commonFc.createDivEl('form-group');
			postDataFields = getKeyValueFieldsArr();
			$(formGroupDivEl).append(postDataParamsLabelEl);
			$(formGroupDivEl).append(postDataParamsJSGridEl);
			commonFc.initJsGrid(postDataParamsJSGridEl, postDataFields, isJSGrid);
			return formGroupDivEl;
		};
		
		createPrepopulateDataURL = function(){
			 var prepopulateDataURLLabelEl, requiredEl, prepopulateDataURLInputEl, formGroupDivEl
			 prepopulateDataURLLabelEl = commonFc.createLabel('prepopulateDataURL', prepopulateDataURL);
			 requiredEl = commonFc.createEm('*');
			 prepopulateDataURLInputEl = commonFc.createInputTextEl('form-control', 'prepopulateDataURL');
			 formGroupDivEl = commonFc.createDivEl('form-group');
			 
			 $(prepopulateDataURLLabelEl).append(requiredEl);
			 $(formGroupDivEl).append(prepopulateDataURLLabelEl);
			 $(formGroupDivEl).append(prepopulateDataURLInputEl);
					 
			 return formGroupDivEl; 
		};
		
		createPrepopulateDataContentType = function(ind){
			var prepopulateDataContentTypeLabelEl, requiredEl, prepopulateDataContentTypeDropdownEl, formGroupDivEl;
			prepopulateDataContentTypeLabelEl = commonFc.createLabel('prepopulateDataContentType', prepopulateDataContentType);
			requiredEl = commonFc.createEm('*');
			prepopulateDataContentTypeDropdownEl = commonFc.createDropdown('form-control', 'prepopulateDataContentType');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(prepopulateDataContentTypeLabelEl).append(requiredEl);
			$(formGroupDivEl).append(prepopulateDataContentTypeLabelEl);
			$(formGroupDivEl).append(prepopulateDataContentTypeDropdownEl);
			commonFc.populateDropdown(contentTypesArr, prepopulateDataContentTypeDropdownEl);
			
			return formGroupDivEl;
		};
		
		createPrepopulateDataAccept = function(){
			var prepopulateDataAcceptLabelEl, requiredEl, prepopulateDataAcceptDropdownEl, formGroupDivEl;
			prepopulateDataAcceptLabelEl = commonFc.createLabel('prepopulateDataAccept', accept);
			requiredEl = commonFc.createEm('*');
			prepopulateDataAcceptDropdownEl = commonFc.createDropdown('form-control', 'prepopulateDataAccept');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(prepopulateDataAcceptLabelEl).append(requiredEl);
			$(formGroupDivEl).append(prepopulateDataAcceptLabelEl);
			$(formGroupDivEl).append(prepopulateDataAcceptDropdownEl);
			commonFc.populateDropdown(acceptArr, prepopulateDataAcceptDropdownEl);
			
			return formGroupDivEl;
		};
		
		createPrepopulateDataHeaders = function(){
			var prepopulateDataHeadersLabelEl, prepopulateDataHeadersJSGridEl, formGroupDivEl, prepopulateDataFields;
			prepopulateDataHeadersLabelEl = commonFc.createLabel('prepopulateDataHeaders', headers);
			prepopulateDataHeadersJSGridEl = commonFc.createDivEl('prepopulate-data-headers-div-el', 'prepopulateDataHeaders');
			formGroupDivEl = commonFc.createDivEl('form-group');
			prepopulateDataFields = getKeyValueFieldsArr();
			$(formGroupDivEl).append(prepopulateDataHeadersLabelEl);
			$(formGroupDivEl).append(prepopulateDataHeadersJSGridEl);
			commonFc.initJsGrid(prepopulateDataHeadersJSGridEl, prepopulateDataFields, isJSGrid);
			return formGroupDivEl;
		};
		
		createPrepopulateDataParams = function(){
			var prepopulateDataParamsLabelEl, prepopulateDataParamsJSGridEl, formGroupDivEl, prepopulateDataFields;
			prepopulateDataParamsLabelEl = commonFc.createLabel('prepopulateDataParams', params);
			prepopulateDataParamsJSGridEl = commonFc.createDivEl('prepopulate-data-headers-div-el', 'prepopulateDataParams');
			formGroupDivEl = commonFc.createDivEl('form-group');
			prepopulateDataFields = getKeyValueFieldsArr();
			$(formGroupDivEl).append(prepopulateDataParamsLabelEl);
			$(formGroupDivEl).append(prepopulateDataParamsJSGridEl);
			commonFc.initJsGrid(prepopulateDataParamsJSGridEl, prepopulateDataFields, isJSGrid);
			return formGroupDivEl;
		};
		
		/** Delete Form Fields **/
		createDeleteFormFieldSection = function() {
			var deleteFormFieldRowEl, deleteFormFieldColEl, deleteFormFieldHeadingDivEl, deleteFormFieldEmphasizedEl,
			deleteFormFieldParaEl;

			deleteFormFieldRowEl = commonFc.createDivEl('row');
			deleteFormFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center', 'delete_confirmation_message');
			deleteFormFieldHeadingDivEl = commonFc.createDivEl('form-heading');
			deleteFormFieldParaEl = commonFc.createPara();
			deleteFormFieldEmphasizedEl = commonFc.createEm(deleteConfirmationMessage);

			$(deleteFormFieldEmphasizedEl).css('color', 'black');
			$(deleteFormFieldParaEl).html(deleteFormFieldEmphasizedEl);
			$(deleteFormFieldHeadingDivEl).append(deleteFormFieldParaEl);

			$(deleteFormFieldColEl).append(deleteFormFieldHeadingDivEl);
			$(deleteFormFieldRowEl).append(deleteFormFieldColEl);
			$(deleteFormFieldJEl).append(deleteFormFieldRowEl);

		};

		changeBasicSectionLocale = function(curEl, isBasicSection) {
			var previousSelectedLocale = '';
			var selectedLocaleText = $(curEl).text();
			var selectedLocaleHtml = '';
			if(selectedLocaleText == 'en-US'){
				selectedLocaleHtml = commonFc.getEN_USLocaleHtmlText();
			}else if(selectedLocaleText == 'ar-SA'){
				selectedLocaleHtml = commonFc.getAR_SALocaleHtmlText();
			}
			var selectedLanguageId = $(curEl).attr('language-id');
			var reflectOnFieldId = $(curEl).attr('reflect-on-field-id');

			if(isBasicSection) {
				if(reflectOnFieldId == 'formTitleSelectedLocale') {
					previousSelectedLocale = $(formTitleSelectedLocaleJEl).attr('language-id');
					$(formTitleSelectedLocaleJEl).html(selectedLocaleHtml);
					$(formTitleSelectedLocaleJEl).attr('language-id', selectedLanguageId);

					// Changing Form Title Content...
					var previousLocaleFormTitle = $(formTitleJEl).val();
					$(formTitleJEl + "_" + previousSelectedLocale).val(previousLocaleFormTitle);
					var currentLocaleFormTitle = $(formTitleJEl + "_" + $(curEl).attr('language-id')).val();
					$(formTitleJEl).val(currentLocaleFormTitle);
				} else if(reflectOnFieldId == 'formDescriptionSelectedLocale') {
					previousSelectedLocale = $(formDescriptionSelectedLocaleJEl).attr('language-id');
					$(formDescriptionSelectedLocaleJEl).html(selectedLocaleHtml);
					$(formDescriptionSelectedLocaleJEl).attr('language-id', selectedLanguageId);

					// Changing Form Description Content...
					var previousLocaleFormDescription = $(formDescriptionJEl).summernote('code');
					$(formDescriptionJEl + "_" + previousSelectedLocale).val(previousLocaleFormDescription);
					var currentLocaleFormDescription = $(formDescriptionJEl + "_" + $(curEl).attr('language-id')).val();
					$(formDescriptionJEl).summernote('code', currentLocaleFormDescription);
				}
			} else {
				if(reflectOnFieldId == 'fieldLabelSelectedLocale') {
					previousSelectedLocale = $(formFieldLabelSelectedLocaleJEl).attr('language-id');
					$(formFieldLabelSelectedLocaleJEl).html(selectedLocaleHtml);
					$(formFieldLabelSelectedLocaleJEl).attr('language-id', selectedLanguageId);

					// Changing Form Label Content...
					var previousLocaleFormLabel = $(fieldLabelJEl).val();
					$(fieldLabelJEl + "_" + previousSelectedLocale).val(previousLocaleFormLabel);
					var currentLocaleFormLabel = $(fieldLabelJEl + "_" + $(curEl).attr('language-id')).val();
					$(fieldLabelJEl).val(currentLocaleFormLabel);
				} else if(reflectOnFieldId == 'placeholderSelectedLocale') {
					previousSelectedLocale = $(fieldPlaceholderSelectedLocaleJEl).attr('language-id');
					$(fieldPlaceholderSelectedLocaleJEl).html(selectedLocaleHtml);
					$(fieldPlaceholderSelectedLocaleJEl).attr('language-id', selectedLanguageId);

					// Changing Form Placeholder Content...					
					var previousLocaleFormPlaceholder = $(fieldPlaceholderJEl).val();
					$(fieldPlaceholderJEl + "_" + previousSelectedLocale).val(previousLocaleFormPlaceholder);
					var currentLocaleFormPlaceholder = $(fieldPlaceholderJEl + "_" + $(curEl).attr('language-id')).val();
					$(fieldPlaceholderJEl).val(currentLocaleFormPlaceholder);
				} else if(reflectOnFieldId == 'htmlEditorSelectedLocale') {
					previousSelectedLocale = $(fieldHTMLPlaceholderSelectedLocale).attr('language-id');
					$(fieldHTMLPlaceholderSelectedLocale).html(selectedLocaleHtml);
					$(fieldHTMLPlaceholderSelectedLocale).attr('language-id', selectedLanguageId);

					// Changing Form HTML Placeholder Content...
					var previousLocaleFormHtmlPlaceholder = $(fieldHTMLEditorPlaceholderJEl).summernote('code');
					$(fieldHTMLEditorPlaceholderJEl + "_" + previousSelectedLocale).val(previousLocaleFormHtmlPlaceholder);
					var currentLocaleFormHtmlPlaceholder = $(fieldHTMLEditorPlaceholderJEl + "_" + $(curEl).attr('language-id')).val();
					$(fieldHTMLEditorPlaceholderJEl).summernote('code', currentLocaleFormHtmlPlaceholder);
				} else if(reflectOnFieldId == 'rangeCommentSelectedLocale'){
					previousSelectedLocale = $(fieldRangeCommentSelectedLocaleJEl).attr('language-id');
					$(fieldRangeCommentSelectedLocaleJEl).html(selectedLocaleHtml);
					$(fieldRangeCommentSelectedLocaleJEl).attr('language-id', selectedLanguageId);

					// Changing Form HTML Placeholder Content...
					var previousLocaleRangeComment = $(rangeCommentJEl).val();
					$(rangeCommentJEl + "_" + previousSelectedLocale).val(previousLocaleRangeComment);
					var currentLocaleRangeComment = $(rangeCommentJEl + "_" + $(curEl).attr('language-id')).val();
					$(rangeCommentJEl).val(currentLocaleRangeComment);
				}
			}

		}

		updateHiddenFieldValue = function(curEl) {
			var curElId = $(curEl).attr("id");
			var currentSelectedLocale = $("#" + curElId + "SelectedLocale").attr('language-id');
			$("#" + curElId + "_" + currentSelectedLocale).val($(curEl).val());
		};

		/** Form Fields**/
		initInputTags = function(inputTagDivId, inputTagId) {
			var inputTags;
			if($(inputTagDivId).find("tags").length <= 0) {
				inputTags = $(inputTagId).tagify({
					duplicates : false,
					hooks: {
					    beforeRemoveTag: function(tags) {
					        return new Promise((resolve, reject) => {
					            confirm(confirmationMessage + " " + tags[0].data.value + " tag ?") ?
					                resolve() :
					                reject()
					        })
					    }
					}
				});
			}
			return inputTags;
		};
		
		destroyJSGrid = function(){
			if(isValidationJSGrid){
				$(jsGridValidationJEl).jsGrid("destroy");
			}
			isValidationJSGrid = false;
		}
		
		selectedRangeOption = function(curSelectedField){
			var selectedFieldVal;
			selectedFieldVal = $(curSelectedField).find('option:selected').val();
			$.each(rangeOptionDataArr, function(key, val) {
		      if(selectedFieldVal == val.value){
		    	  if(val.rangeOptions){
		    		  var customRangeOtions = JSON.parse(val.rangeOptions);
		    		  console.log("Range Options : ", val.rangeOptions);
		    		  commonFc.populateCustomRangeJSGrid(customRangeOtions, fieldDisplayCustomRangeJSGridJEl);
		    	  }
		      }
		    });
		};
		
		selectedFieldSettingType = function(curSelectedField){
			var selectedField;
			selectedField = $(curSelectedField).find('option:selected').val();
			
			$(fieldReadonlyJEl).prop('checked', false);
			if(selectedField=='text') {
				toggleTextField();
			}else if(selectedField=='textarea') {
				toggleTextAreaField();
			}else if(selectedField=='number') {
				toggleNumberField();
			}else if(selectedField=='date' || selectedField=='time' ||  selectedField=='datetime'){
				toggleFormatField(selectedField);
			}else if(selectedField=='radio'){
				toggleRadioField();
			}else if(selectedField=='checkbox'){
				toggleCheckboxField();
			}else if(selectedField=='dropdown'){
				toggleDropdownField();
			}else if(selectedField=='html'){
				toggleHTMLEditorField();
			}else if(selectedField=='file'){
				toggleFileField();
			}else if(selectedField=='readonly'){
				$(fieldReadonlyJEl).prop('checked', true);
				toggleReadOnlyField();
			}else if(selectedField=='range'){
				toggleRangeField();
			}else if(selectedField=='password'){
				togglePasswordField();
			}else if(selectedField=='rangePicker'){
				toggleRangePickerField();
			}else if(selectedField=='customRange'){
				toggleCustomRangeField();
			}
			
			if(selectedField=='date' || selectedField=='time' ||  selectedField=='datetime' || selectedField=='radio' || selectedField=='checkbox' || selectedField=='dropdown'
				|| selectedField=='html' || selectedField=='readonly' || selectedField=='range' || selectedField=='number' || selectedField=='customRange'){
				$(fieldExtraValidationsJEl).prop('checked', false);
				$(fieldExtraValidationsJEl).prop('disabled', true);
			}else{
				$(fieldExtraValidationsJEl).prop('disabled', false);
			}
			displayExtraValidations();
			populateFieldDataTypesDropdown(selectedField);
		};
		
		
		populateFieldDataTypesDropdown = function(selectedField){
			var data = [], dataTypes = settingDataTypes;
			if(selectedField == 'text' || selectedField == 'radio' || selectedField =='checkbox' || selectedField == 'time' || selectedField == 'dropdown' ||
			   selectedField =='readonly' || selectedField == 'password' || selectedField == 'file'){
				data = dataTypes.filter(dataType => dataType.label == 'string');
			}else if(selectedField == 'textarea'){
				data = dataTypes.filter(dataType => dataType.label == 'string' || dataType.label == 'longtext');
			}else if(selectedField == 'html' || selectedField == 'range' || selectedField == 'customRange'){
				data = dataTypes.filter(dataType => dataType.label == 'longtext');
			}else if(selectedField == 'number' || selectedField == 'rangePicker'){
				data = dataTypes.filter(dataType => dataType.label == 'integer' || dataType.label == 'double' ||  dataType.label == 'long');
			}else if(selectedField == 'datetime' || selectedField == 'date'){
	 			data = dataTypes.filter(dataType => dataType.label == 'datetime');
			}
			var fieldDataTypesDropdownEl = $(fieldDataTypeJEl);
			commonFc.populateDropdown(data, fieldDataTypesDropdownEl);
		};
		toggleTextField = function(){
			displayPlaceholder();
		};
		toggleTextAreaField = function(){
			displayPlaceholder();
		};
		displayPlaceholder = function(){
			$(fieldDisplayPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayPlaceholderJEl).addClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-block');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
			
		};
		
		toggleHTMLEditorField = function() {
			var changeEventFn = new Object({});
			changeEventFn.elId = 'htmlEditor';
			changeEventFn.isViewMode = false;
			commonFc.initTextEditor(fieldHTMLEditorPlaceholderJEl, changeEventFn);
			$(fieldDisplayHTMLEditorJEl).removeClass('d-none');
			$(fieldDisplayHTMLEditorJEl).addClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-block');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleNumberField = function(){
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-block');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleRangePickerField = function(){
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-block');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleFormatField = function(format){
			var data = [];
			if(format=='date'){
				data = dateFormats;
			}else if(format=='time'){
				data = timeFormats;
			}else if(format=='datetime'){
				data = dateTimeFormats;
			}
			
			var formatPlaceholderDropdownEl = $(fieldFormatPlaceholderJEl);
			commonFc.populateDropdown(data, formatPlaceholderDropdownEl);
			
			displayFormat();
		};
		displayFormat = function(){
			/*$(fieldDisplayPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayPlaceholderJEl).addClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-block');*/
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-none');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-block');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleRadioField = function(){
			displayRadioAndCheckboxField();
		};
		createCheckboxRadioFieldJSGrid = function(){
			var checkboxRadioFieldLabelEl, checkboxRadioFieldJSGridEl, formGroupDivEl, checkboxRadioFieldValues;
			checkboxRadioFieldLabelEl = commonFc.createLabel('values', values);
			checkboxRadioFieldJSGridEl = commonFc.createDivEl('values-div-el d-none', 'displayCheckboxRadioJSGrid');
			formGroupDivEl = commonFc.createDivEl('form-group');
			checkboxRadioFieldValues = getLanguageFieldsArr();
			$(formGroupDivEl).append(checkboxRadioFieldLabelEl);
			$(formGroupDivEl).append(checkboxRadioFieldJSGridEl);
			commonFc.initJsGrid(checkboxRadioFieldJSGridEl, checkboxRadioFieldValues, isJSGrid);
			return formGroupDivEl;
		};
		
		createRangeFieldJSGrid = function(){
			var rangeFieldLabelEl, rangeFieldJSGridEl, formGroupDivEl, totalItemsInserted = 0;;
			rangeFieldLabelEl = commonFc.createLabel('values', values);
			rangeFieldJSGridEl = commonFc.createDivEl('range-values-div-el d-none', 'displayRangeJSGrid');
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(rangeFieldLabelEl);
			$(formGroupDivEl).append(rangeFieldJSGridEl);
			createRangeJSGrid(rangeFieldJSGridEl, totalItemsInserted);
			return formGroupDivEl;
		};
		
		toggleCheckboxField = function(){
			displayRadioAndCheckboxField();
		};
		displayRadioAndCheckboxField = function() {
			$(fieldDisplayValuesInputTagJEl).removeClass('d-none');
			$(fieldDisplayValuesInputTagJEl).addClass('d-block');
			
			$(fieldDisplayCheckboxRadioJSGridJEl).removeClass('d-none');
			$(fieldDisplayCheckboxRadioJSGridJEl).addClass('d-block');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-none');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-block');*/
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleDropdownField = function(){
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldWhereToPopulateDropdownJEl).val("");
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		whereToPopulateSelectedDropdownValue = function(curSelectedValue) {
			var selectedValue;
			selectedValue = $(curSelectedValue).find('option:selected').val();
			
			if(selectedValue == 'staticValues'){
				toggleStaticValues(curSelectedValue);
			}else if(selectedValue == 'dataProvider') {
				toggleDataProvider(curSelectedValue);
				validateDataProvider();
			}else if(selectedValue == 'dependentFields') {
				toggleDependentFields(curSelectedValue);
			}else if(selectedValue == 'masterTable') {
				toggleMasterTable(curSelectedValue);
				validateMasterTable();
			}
		};
		
		statusInactive = function(curSelectedValue){
			var selectedValue;
			selectedValue = $(curSelectedValue).find('option:selected').val();
			if(selectedValue == 'inactive'){
				$(fieldRequiredJEl).attr('disabled', true);
				$(fieldExtraValidationsJEl).attr('disabled', true);
			} else if(selectedValue == 'active'){
				$(fieldRequiredJEl).attr('disabled', false);
				$(fieldExtraValidationsJEl).attr('disabled', false);
			}
		};
		
		fetchEditColumnNames = function(tableName, textColumn) {
			$.ajax({
				url: getFormDataResourceURL,
				method : 'POST',
				data: {
					[namespace + 'cmd']: 'fetchColumnNames',
					[namespace + 'selectedTableName']: tableName
				},
				success:function(result){
					var resultObj;
					if(result){
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							var textColumns = resultObj.textColumns;
							var textColumnsArr = [];
							$(fieldMasterTableTextColumnJEl).empty();
							for (var i = 0; i < textColumns.length; i++) {
								var obj = textColumns[i];
								textColumnsArr.push({ 
		                			"label" : obj,
		    	                    "value" : obj
		    	                });
							}
							commonFc.populateDropdown(textColumnsArr, fieldMasterTableTextColumnJEl);
							$(fieldMasterTableTextColumnJEl).val(textColumn).attr('selected', true);
						}
					}
				}
			});
		};
		
		fetchColumnNames = function(curSelectedValue) {
			var selectedTableName = $(curSelectedValue).find('option:selected').val();
			console.log('selectedValue', selectedTableName);
			$.ajax({
				url: getFormDataResourceURL,
				method : 'POST',
				data: {
					[namespace + 'cmd']: 'fetchColumnNames',
					[namespace + 'selectedTableName']: selectedTableName
				},
				success:function(result){
					var resultObj;
					if(result){
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							var textColumns = resultObj.textColumns;
							var textColumnsArr = [];
							$(fieldMasterTableTextColumnJEl).empty();
							var option = $("<option>").val('').text('-- Select --');
							$(fieldMasterTableTextColumnJEl).append(option);
							for (var i = 0; i < textColumns.length; i++) {
								var obj = textColumns[i];
								textColumnsArr.push({ 
		                			"label" : obj,
		    	                    "value" : obj
		    	                });
							}
							commonFc.populateDropdown(textColumnsArr, fieldMasterTableTextColumnJEl);
							
							var valueColumns = resultObj.valueColumns;
							var valueColumnsArr = [];
							$(fieldMasterTableValueColumnJEl).empty();
							var option = $("<option>").val('').text('-- Select --');
							$(fieldMasterTableValueColumnJEl).append(option);
							for (var i = 0; i < valueColumns.length; i++) {
								var obj = valueColumns[i];
								valueColumnsArr.push({ 
		                			"label" : obj,
		    	                    "value" : obj
		    	                });
							}
							commonFc.populateDropdown(valueColumnsArr, fieldMasterTableValueColumnJEl);
							
						}else{
							console.log('Error while loading form configuration:');
						}
					}
				}
			});
		}; 
		
		toggleStaticValues = function(curSelectedValue){
			staticValuesFieldSettingSection = createStaticValuesFieldSettingSection();
			$(curSelectedValue).closest(".card-body-settings-div-el").append(staticValuesFieldSettingSection);
			displayStaticValues();
		};
		
		displayStaticValues = function(){
			$(fieldStaticValuesRowJEl).removeClass('hide');
			$(fieldStaticValuesRowJEl).addClass('show');
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		whereToPopulateDependentFields = function(curSelectedDF){
			var selectedDF, tagValues;
			selectedDF = $(curSelectedDF).find('option:selected').val();
			if(selectedDF == 'staticValues'){
				console.log('Static values with dependent field');
				toggleDFStaticValues(curSelectedDF);
			}else if(selectedDF == 'dataProvider') {
				toggleDFDataProvider(curSelectedDF);
			}
		};
		
        removeRow = function(dfClass){
            $(dfClass).remove();
            $(fieldWhereToPopulateDependentFieldsJEl).val('');
            var dependentSelectedDropdown = $(fieldDependentFieldsNameJEl).val();
            for (var i = 0; i < formBuilderConfigJsonObj.fields.length; i++){
                var obj = formBuilderConfigJsonObj.fields[i];
                var type = obj.settings.type;
                var key = obj.key;
                if(dependentSelectedDropdown && (key == dependentSelectedDropdown && type == 'dropdown' && obj.settings.hasOwnProperty('values'))){
                	$(fieldWhereToPopulateDependentFieldsJEl).find("option[value=dataProvider]").prop("disabled", true);
                } else if(dependentSelectedDropdown && (key == dependentSelectedDropdown && type == 'dropdown' && !obj.settings.hasOwnProperty('values'))){
                	$(fieldWhereToPopulateDependentFieldsJEl).find("option[value=staticValues]").prop("disabled", true);
                } else if(dependentSelectedDropdown && key == dependentSelectedDropdown && type != 'dropdown'){
                	$(fieldWhereToPopulateDependentFieldsJEl).find("option").prop("disabled", false);
                }
            }
        };
        
		toggleDFStaticValues = function(curSelectedDF){
			dependentSelectedFieldName = $(fieldDependentFieldsNameJEl).val();
            var dropdownArray = formFieldData();
            console.log('dropdownArray :: ', dropdownArray);
            var size = dropdownArray.length;
            var staticFieldSettingSection, fieldSettingSection;
            if(size > 0){
            	$(fieldStaticValuesRowJEl).remove();
            	for (var i = 0; i < size; i++){
	            	var obj = dropdownArray[i];
	            	var key = obj.value;
	            	var data = [];
	            	if(dependentSelectedFieldName == key){
	            		data = obj.data;
	            		console.log('data :: ', data)
	            		var ind = 1;
	            		for (value of data) {
	            			staticFieldSettingSection = createDFStaticValuesSection(ind, value);
	            			$('.card-body-accordian-settings').find('.card-body-settings-div-el').append(staticFieldSettingSection);
	            			displayDFStaticValues(ind);
	            			ind++;
	    				}
	            	} else {
	            		console.log('No Match');
	            	}
            	}
            } else {
            	console.log('Empty array. Size less then 0');
            }
		};
		
		displayDFStaticValues = function(ind){
			$(dfStaticValuesRowJEl+ind).removeClass('d-none');
			$(dfStaticValuesRowJEl+ind).addClass('d-block');
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
	
		toggleDFDataProvider = function(curSelectedDF){
			var dataProviderFieldSettingSection, fieldSettingSection;
			$(fieldDataProviderRowJEl ).remove();
			dataProviderFieldSettingSection = createDataProviderFieldSettingSection();
			$(curSelectedDF).closest(".card-body-settings-div-el").append(dataProviderFieldSettingSection);
			displaySourceProps();
			initDataProps();
			initSourceProps();
			displayDFDataProvider();
		};
		
		displaySourceProps = function(){
			$(fieldDisplaySourcePropsJEl).removeClass('d-none');
			$(fieldDisplaySourcePropsJEl).addClass('d-block');
		};
		
		displayDFDataProvider = function(){
			$(fieldDataProviderRowJEl).removeClass('hide');
			$(fieldDataProviderRowJEl).addClass('show');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
		};
		
		toggleDependentFields = function(curSelectedValue){
			var dependentFieldSettingSection;
			
			dependentFieldSettingSection = createDependentFieldSettingSection();
			$(curSelectedValue).closest(".card-body-settings-div-el").append(dependentFieldSettingSection);
			
			displayDependentFields();
			populateDependentFieldsName();
		};
		
		toggleMasterTable = function(curSelectedValue){
			var masterTableSettingSection;
			
			masterTableSettingSection = createMasterTableSettingSection();
			$(curSelectedValue).closest(".card-body-settings-div-el").append(masterTableSettingSection);
			
			displayMasterTable();
			getTableNames();
		};
		
		displayMasterTable = function(){
			$(fieldMasterTableRowJEl).removeClass('hide');
			$(fieldMasterTableRowJEl).addClass('show');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-none');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-block');
			
			$('.static-custom-input').remove();
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
			
		};
		displayDependentFields = function(){
			$(fieldDependentFieldsRowJEl).removeClass('hide');
			$(fieldDependentFieldsRowJEl).addClass('show');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
			
		};
		formFieldData = function(){
			var dropdownArray = [];
			if(formBuilderConfigJsonObj.fields.length > 0) {
				for (var i = 0; i < formBuilderConfigJsonObj.fields.length; i++) {
				    var field = formBuilderConfigJsonObj.fields[i];
				    var label = field.label.en_US;
			    	var value = field.key;
			    	var values = field.settings.values;
				    if (field.settings.type == 'radio' || field.settings.type == 'checkbox' || (field.settings.type == 'dropdown' && !field.settings.hasOwnProperty('master') && !field.settings.hasOwnProperty('dependency'))) {
				    	var valueArray = [];
					    for (var j = 0; j < values.length; j++) {
					    	valueArray.push(values[j]);
					    }
				    } else {
				    	continue;
				    }
				    dropdownArray.push({
				        "label": label,
				        "value": value,
				        "data": valueArray
				    });
				}
			}
			return dropdownArray;
		};
		
		populateDependentFieldsName = function(){
            var dropdownArray = formFieldData();
            commonFc.populateDropdown(dropdownArray, fieldDependentFieldsNameJEl);
		};
		
		toggleDataProvider = function(curSelectedValue){
			var inputTagDivId, inputTagId, dataProviderFieldSettingSection;
			$(fieldDataProviderRowJEl).remove();
			dataProviderFieldSettingSection = createDataProviderFieldSettingSection();
			$(curSelectedValue).closest(".card-body-settings-div-el").append(dataProviderFieldSettingSection);
			initDataProps();
			displayDataProvider();
			
		};
		initDataProps = function(){
			inputTagDivId = fieldDisplayDataPropsJEl;
			inputTagId = fieldDataPropsJEl;
			initInputTags(inputTagDivId, inputTagId);
		};
		
		initSourceProps = function(){
			inputTagDivId = fieldDisplaySourcePropsJEl;
			inputTagId = fieldSourcePropsJEl;
			initInputTags(inputTagDivId, inputTagId);
		};
		
		displayDataProvider = function(){
			$(fieldDataProviderRowJEl).removeClass('hide');
			$(fieldDataProviderRowJEl).addClass('show');
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-none');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-block');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-none');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			/*$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');*/
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		populateContentTypes =  function(curMethodType){
			var selectedMethodType;
			selectedMethodType = $(curMethodType).find('option:selected').val();
			if(selectedMethodType == 'post'){
				$(fieldDisplayContentTypesJEl).removeClass('d-none');
				$(fieldDisplayContentTypesJEl).addClass('d-block');
				commonFc.populateDropdown(contentTypesArr, fieldContentTypesJEl);
			}else{
				$(fieldDisplayContentTypesJEl).removeClass('d-block');
				$(fieldDisplayContentTypesJEl).addClass('d-none');
			}
		};
		
		toggleFileField = function() {
			inputTagDivId = fieldDisplayFileExtensionsInputTagJEl;
			inputTagId = fieldFileExtensionsInputTagJEl;
			initInputTags(inputTagDivId, inputTagId);
			displayFileField();
		};
		
		displayFileField = function(){
			$(fieldReadonlyJEl).attr("disabled", true);

			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-none');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-block');
			
			$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-none');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleReadOnlyField = function(){
			displayReadOnlyField();
		};
		
		displayReadOnlyField = function(ind){
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleRangeField = function(){
			//initRangeInputTags();
			displayRangeField();
		};
		
		populateRangeOptionsConfig = function(curEl){
			var closestFormFieldRow, tagValues, rangeOptionsConfigTbodyEl;
			
			closestFormFieldRow = $(curEl).closest('.form-field-row-div-el');
			tagValues = $(closestFormFieldRow).find('div.range-options-el').val();
		};
		
		populateRangeOptions = function(curEl){
			totalItemsInserted = getJSGridRowsCount(fieldDisplayRangeJSGridJEl);
			lastItemValue = getJSGridLastElement(fieldDisplayRangeJSGridJEl);
			populateRangeOptionsConfigTable(curEl, lastItemValue, totalItemsInserted);
		};
		
		populateRangeOptionsConfigTable = function(curEl, lastItemValue, totalItemsInserted){
			var rangeOptionsConfigTbodyEl, minBoundaryValue, maxBoundaryValue, rangeOptionsConfigRow, rangeLength, boundaryValue, optionValue, rowEl, nameDataEl,
				valueDataEl;
			console.log('Populating Range Options Config Table...');
			var closestFormFieldRow = $(curEl).closest('.form-field-row-div-el');
			//var closestFormFieldRow = $(closestFormFieldRow).closest('.form-field-row-div-el');
			rangeOptionsConfigTbodyEl = $(closestFormFieldRow).find('.range-options-config-tbody').attr('id');
			$('#' + rangeOptionsConfigTbodyEl).empty();
			minBoundaryValue = $(closestFormFieldRow).find('.min-boundary-el').val();
			maxBoundaryValue = $(closestFormFieldRow).find('.max-boundary-el').val();
			rangeOptionsConfigRow = $(closestFormFieldRow).find('.range-options-config-row');

			if(lastItemValue){
				rangeLength = totalItemsInserted - 1;
				boundaryValue = maxBoundaryValue - minBoundaryValue;
				optionValue = boundaryValue/rangeLength;
				var jsRangeDataArray = $(fieldDisplayRangeJSGridJEl).jsGrid('option','data');
				
				//jsRangeDataArray.slice().reverse().forEach(function(item, index) {
				jsRangeDataArray.slice().forEach(function(item, index) {
					var itemValue = item.en_US;
					rowEl = commonFc.createTREl();
		            if(index == 0){
						nameDataEl = commonFc.createTDEl(itemValue);
						valueDataEl = commonFc.createTDEl(minBoundaryValue);
					}else if(index == rangeLength){
						nameDataEl = commonFc.createTDEl(itemValue);
						valueDataEl = commonFc.createTDEl(maxBoundaryValue);
					}else{
						minBoundaryValue = (parseFloat(minBoundaryValue) + parseFloat(optionValue)).toFixed(1);
						nameDataEl = commonFc.createTDEl(itemValue);
						valueDataEl = commonFc.createTDEl(minBoundaryValue);
					}
		            
		            $(rowEl).append(nameDataEl);
					$(rowEl).append(valueDataEl);
					$('#' + rangeOptionsConfigTbodyEl).append(rowEl);
			    });
				$(rangeOptionsConfigRow).removeClass('hide');
				$(rangeOptionsConfigRow).addClass('show');
			}else{
				$(rangeOptionsConfigRow).removeClass('show');
				$(rangeOptionsConfigRow).addClass('hide');
			}
		};
		
		displayRangeField = function(){		
			$(fieldDisplayAverageJEl).removeClass('d-none');
			$(fieldDisplayAverageJEl).addClass('d-block');
			
			$(fieldDisplayRangeJSGridJEl).removeClass('d-none');
			$(fieldDisplayRangeJSGridJEl).addClass('d-block');
			
			$(fieldDisplayTotalJEl).removeClass('d-none');
			$(fieldDisplayTotalJEl).addClass('d-block');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-none');
			$(fieldDisplayMinBoundaryJEl).addClass('d-block');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-none');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-block');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-none');
			$(fieldDisplayRangeOptionsJEl).addClass('d-block');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-none');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
	
		togglePasswordField = function(){
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldDisplayAverageJEl).removeClass('d-block');
			$(fieldDisplayAverageJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-block');
			$(fieldDisplayTotalJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-block');
			$(displayRangeOptionNameDrJEl).addClass('d-none');
		};
		
		toggleCustomRangeField = function(){
			$(fieldDisplayCustomRangeOptionsJEl).removeClass('d-none');
			$(fieldDisplayCustomRangeOptionsJEl).addClass('d-block');
			
			$(displayRangeOptionNameDrJEl).removeClass('d-none');
			$(displayRangeOptionNameDrJEl).addClass('d-block');
			
			$(fieldDisplayAverageJEl).removeClass('d-none');
			$(fieldDisplayAverageJEl).addClass('d-block');
			
			$(fieldDisplayRangeJSGridJEl).removeClass('d-block');
			$(fieldDisplayRangeJSGridJEl).addClass('d-none');
			
			$(fieldDisplayTotalJEl).removeClass('d-none');
			$(fieldDisplayTotalJEl).addClass('d-block');
			
			$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayRangeCommentJEl).removeClass('d-block');
			$(fieldDisplayRangeCommentJEl).addClass('d-none');
			
			$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
			$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			
			$(fieldDisplayMinBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMinBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayMaxBoundaryJEl).removeClass('d-block');
			$(fieldDisplayMaxBoundaryJEl).addClass('d-none');
			
			$(fieldDisplayRangeOptionsJEl).removeClass('d-block');
			$(fieldDisplayRangeOptionsJEl).addClass('d-none');
			
			$(fieldDisplayPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayPlaceholderJEl).addClass('d-none');
			$(displayPlaceholderLocaleBtnJEl).removeClass('d-block');
			$(displayPlaceholderLocaleBtnJEl).addClass('d-none');
			
			$(fieldDisplayFormatPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayFormatPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMinNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMinNumberPlaceholderJEl).addClass('d-none');
			
			$('.static-custom-input').remove();
			
			$(fieldDisplayMaxNumberPlaceholderJEl).removeClass('d-block');
			$(fieldDisplayMaxNumberPlaceholderJEl).addClass('d-none');
			
			$(fieldDisplayMultipleFileUploadJEl).removeClass('d-block');
			$(fieldDisplayMultipleFileUploadJEl).addClass('d-none');
			
			$(fieldDisplayFileExtensionsInputTagJEl).removeClass('d-block');
			$(fieldDisplayFileExtensionsInputTagJEl).addClass('d-none');
			
			$(fieldDisplayValuesInputTagJEl).removeClass('d-block');
			$(fieldDisplayValuesInputTagJEl).addClass('d-none');
			
			/*$(fieldDisplayDefaultSelectedJEl).removeClass('d-block');
			$(fieldDisplayDefaultSelectedJEl).addClass('d-none');*/
			
			$(fieldDisplayDropdownConfigCheckboxJEl).removeClass('d-block');
			$(fieldDisplayDropdownConfigCheckboxJEl).addClass('d-none');
			
			$(fieldDisplayWhereToPopulateDropdownJEl).removeClass('d-block');
			$(fieldDisplayWhereToPopulateDropdownJEl).addClass('d-none');
			
			$(fieldDisplayHTMLEditorJEl).removeClass('d-block');
			$(fieldDisplayHTMLEditorJEl).addClass('d-none');
			$(displayHTMLEditorLocaleBtnJEl).removeClass('d-block');
			$(displayHTMLEditorLocaleBtnJEl).addClass('d-none');
			
			$(fieldDataProviderRowJEl).removeClass('show');
			$(fieldDataProviderRowJEl).addClass('hide');
			
			$(fieldStaticValuesRowJEl).removeClass('show');
			$(fieldStaticValuesRowJEl).addClass('hide');
			
			$(fieldDependentFieldsRowJEl).removeClass('show');
			$(fieldDependentFieldsRowJEl).addClass('hide');
			
			$(fieldMasterTableRowJEl).removeClass('show');
			$(fieldMasterTableRowJEl).addClass('hide');
			
			$(fieldDisplayMasterTableRadioJEl).removeClass('d-block');
			$(fieldDisplayMasterTableRadioJEl).addClass('d-none');
			
			$(fieldRangeOptionsConfigRowJEl).removeClass('show');
			$(fieldRangeOptionsConfigRowJEl).addClass('hide');
		};
		
		showDataField = function(curDataField){
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
		};
		
		toggleExtraValidations = function(extraValidations){
			var isChecked;
			isChecked = $(fieldExtraValidationsJEl).is(':checked');
			if(!isChecked){
				console.log('destroy js grid');
				destroyJSGrid();
			}
			displayExtraValidations();
		};
		
		displayExtraValidations = function(){
			var selectedFieldType = $(fieldTypeJEl).val();
			var isChecked = $(fieldExtraValidationsJEl).is(':checked');
			if(selectedFieldType && isChecked){
				if(selectedFieldType=='text') {
					createJSGrid(textBoxValidations);
				}else if(selectedFieldType=='textarea') {
					createJSGrid(textAreaValidations);
				}else if(selectedFieldType=='number') {
					createJSGrid(numberValidations);
				}else if(selectedFieldType=='file'){
					createJSGrid(fileValidations);
				}else if(selectedFieldType=='password'){
					createJSGrid(passwordValidations);
				}else{
					destroyJSGrid();
				}
			} else {
				destroyJSGrid();
			}
		};
		
		toggleVisibleOn = function(curDataField){
			var isChecked;
			isChecked = $(fieldVisibleOnJEl).is(':checked');

			if(isChecked){
				$(fieldDisplayVisibleOnJEl).removeClass('d-none');
				$(fieldDisplayVisibleOnJEl).addClass('d-block');
			}else{
				$(fieldDisplayVisibleOnJEl).removeClass('d-block');
				$(fieldDisplayVisibleOnJEl).addClass('d-none');
				
				$(fieldDisplayVisibleOnSelectedDropdownJEl).removeClass('d-block');
                $(fieldDisplayVisibleOnSelectedDropdownJEl).addClass('d-none');
			}
		};
		
		toggleRangeMaxCharacter = function(curDataField){
			var isChecked;
			isChecked = $(rangeTotalCharacterJEl).is(':checked');

			if(isChecked){
				$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-none');
				$(fieldDisplayRangeTotalCharacterJEl).addClass('d-block');
			}else{
				$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-block');
				$(fieldDisplayRangeTotalCharacterJEl).addClass('d-none');
			}
		};
		
		toggleIsRangeComment = function(curDataField){
			var isChecked;
			isChecked = $(isRangeCommentJEl).is(':checked');

			if(isChecked){
				$(fieldDisplayRangeCommentJEl).removeClass('d-none');
				$(fieldDisplayRangeCommentJEl).addClass('d-block');
				
				$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-none');
				$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-block');
				
				$(rangeTotalCharacterJEl).attr('disabled', false);
			}else{
				$(fieldDisplayRangeCommentJEl).removeClass('d-block');
				$(fieldDisplayRangeCommentJEl).addClass('d-none');
				
				$(fieldDisplayRangeCommentLocaleBtnJEl).removeClass('d-block');
				$(fieldDisplayRangeCommentLocaleBtnJEl).addClass('d-none');
				
				$(rangeTotalCharacterJEl).attr('disabled', true);
			}
		};
		
        toggleVisibleOnTextInput = function(curDataField){
            var selectedValue;
            selectedValue = $(fieldVisibleOnDropdownJEl).val();
            if(selectedValue != ''){
                $(fieldDisplayVisibleOnSelectedDropdownJEl).removeClass('d-none');
                $(fieldDisplayVisibleOnSelectedDropdownJEl).addClass('d-block');
            }else{
                $(fieldDisplayVisibleOnSelectedDropdownJEl).removeClass('d-block');
                $(fieldDisplayVisibleOnSelectedDropdownJEl).addClass('d-none');
            }
        };
		
		createFormFieldConfig = function(){
			var formFieldRowEl, formFieldColEl, fieldLabelErrDivEl, formFieldSubRowEl, formFieldLabelColEl, formFieldLabelSectionEl, formFieldKeyColEl, formFieldKeySectionEl;
			
			formFieldRowEl = commonFc.createDivEl('row form-field-row pt-1 mb-3 form-field-row-div-el border-bottom','formFieldConfigRow');
			formFieldColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12 accordion');
			
			fieldLabelErrDivEl = commonFc.createDivEl('d-none formLoadErr', 'fieldLableErr');
			formFieldSubRowEl = commonFc.createDivEl('row');
			formFieldLabelColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formFieldLabelSectionEl = createFormFieldLabel();
			
			formFieldKeyColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
			formFieldKeySectionEl = createFormFieldKey();
			
			$(formFieldColEl).append(fieldLabelErrDivEl);
			
			$(formFieldLabelColEl).append(formFieldLabelSectionEl);
			$(formFieldSubRowEl).append(formFieldLabelColEl);
			
			$(formFieldKeyColEl).append(formFieldKeySectionEl);
			$(formFieldSubRowEl).append(formFieldKeyColEl);
			
			
			formFieldSettingsRowEl = createFieldSettingSection();
			$(formFieldColEl).append(formFieldSubRowEl);
			
			$(formFieldColEl).append(formFieldSettingsRowEl);
			
			$(formFieldRowEl).append(formFieldColEl);
			$(formFieldJEl).append(formFieldRowEl);
		};
		
		createFormFieldLabel = function(){
			var formFieldLabelEl, requiredEl, formFieldLabelInputGroupDivEl, formFieldLabelInputGroupErrorDivEl, formFieldLabelInputEl, formFieldLabelInputGroupAppendDivEl,
			formGroupDivEl, isReadOnly = false, changeEventObj = new Object({}), localeChangeEventFn = new Object({});

			formGroupDivEl = commonFc.createDivEl('form-group df-input-form-group');
			formFieldLabelEl = commonFc.createLabel('fieldLabel', fieldLabel, 'field-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			formFieldLabelInputGroupDivEl = commonFc.createDivEl('input-group df-input-group');
			formFieldLabelInputGroupErrorDivEl = commonFc.createDivEl('input-group-error df-input-group-error');
			changeEventObj.fnName = 'addFieldKey(this);';
			formFieldLabelInputEl = commonFc.createInputTextEl('form-control field-label-input-el df-input-group-field', 'fieldLabel', isReadOnly, changeEventObj);
			
			localeChangeEventFn.fnName = 'changeBasicSectionLocale(this, false);';
			formFieldLabelInputGroupAppendDivEl = commonFc.createLocaleBtnEl('fieldLabelSelectedLocale', localeChangeEventFn);

			$(formFieldLabelInputGroupDivEl).append(formFieldLabelInputEl);
			$(formFieldLabelInputGroupDivEl).append(formFieldLabelInputGroupAppendDivEl);
			
			$(formFieldLabelEl).append(requiredEl);
			$(formGroupDivEl).append(formFieldLabelEl);
			$(formGroupDivEl).append(formFieldLabelInputGroupDivEl);
			$(formGroupDivEl).append(formFieldLabelInputGroupErrorDivEl);

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var formFieldLabelLocaleInputEl;
				formFieldLabelLocaleInputEl = commonFc.createInputTextEl('form-control', 'fieldLabel_' + val.value);
				$(formFieldLabelLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(formFieldLabelLocaleInputEl);
			});
			
			return formGroupDivEl;
		};
		
		addFieldKey = function(curFieldLabel){
			var fieldLabel, fieldKey, labelFirstChar, labelSubString;
			fieldLabel = $(curFieldLabel).val();
			fieldKey = fieldLabel.replace(/[^a-zA-Z0-9 ]/g, '');
			fieldKey = fieldKey.toLowerCase();
			fieldKey=fieldKey.replaceAll(" ","_");
			var selectedLocale = $(formFieldLabelSelectedLocaleJEl).attr("language-id");
			if(selectedLocale == "en_US") {
				populateFieldKey(fieldKey);
				$(fieldEnUsLabelJEl).val(fieldLabel);
			} else if(selectedLocale == "ar_SA") {
				$(fieldArSaLabelJEl).val(fieldLabel);
			}
			
			return fieldKey;
		};
		
		populateFieldKey = function(fieldKey){
			$(fieldKeyJEl).val(fieldKey);
		};
		
		createFormFieldKey = function(){
			var formFieldKeyLabelEl, formFieldKeyInputEl, formGroupDivEl, isReadOnly = false;
			formFieldKeyLabelEl = commonFc.createLabel('fieldKey', fieldKey, 'field-key-label field-setting-label');
			formFieldKeyInputEl = commonFc.createInputTextEl('form-control field-key-input-el', 'fieldKey', isReadOnly);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(formFieldKeyLabelEl);
			$(formGroupDivEl).append(formFieldKeyInputEl);
			
			return formGroupDivEl;
		};
		
		createFieldSettingSection = function(){
			var fieldSettingSectionRow, fieldSettingSubSection, fieldSettingSubSection2, staticValueFieldSettingSection, dependentFieldSettingSection, 
            	dataProviderFieldSettingSection, rangeOptionsConfigSection, fieldSettingSubSection3, fieldSettingSubSection5, masterTableSection6, formFieldSettingsRowEl; 
			
			formFieldSettingsRowEl = commonFc.createDivEl('accordion', 'groupAccordian');
			fieldSettingSectionRow = commonFc.createAccordianCardEl('accordion', 'formFieldConfigRowSettingsAccordian', 'Settings');
			$(fieldSettingSectionRow).append(formFieldSettingsRowEl);
			
			fieldSettingSubSection = createFieldSettingSubSection();
			fieldSettingSubSection2 = createFieldSettingSubSection2();
			staticValueFieldSettingSection = createStaticValuesFieldSettingSection();
			rangeOptionsConfigSection = createRangeOptionsConfigSection();
			fieldSettingSubSection3 = createFieldSettingSubSection3();
			fieldSettingSubSection5 = createFieldSettingSubSection5();
			
			$(fieldSettingSectionRow).find('.card-body').append(fieldSettingSubSection);
			$(fieldSettingSectionRow).find('.card-body').append(fieldSettingSubSection2);
			$(fieldSettingSectionRow).find('.card-body').append(staticValueFieldSettingSection);
			$(fieldSettingSectionRow).find('.card-body').append(rangeOptionsConfigSection);
			$(fieldSettingSectionRow).find('.card-body').append(fieldSettingSubSection3);
			$(fieldSettingSectionRow).find('.card-body').append(fieldSettingSubSection5);
			return fieldSettingSectionRow;
		};
		
		/** Form Field Type, DataType, Status, Disable, Required, ReadOnly, PostData, PrepoulateData, ReadFromReqParam **/
		createFieldSettingSubSection = function(){
			var mainSettingRowEl, settingTypeColEl, fieldSettingTypeEl, settingDataTypeColEl, fieldSettingDataTypeEl, settingStatusColEl, fieldSettingStatusEl,
				settingReadonlyAndDisableColEl, fieldSettingReadonlyEl, fieldSettingDisableEl, settingRequiredAndExtraValidationsColEl, settingPostDataColEl,
				fieldSettingRequiredEl, fieldsettingPostDataPostEl, settingPopulateDataAndReadFromReqColEl, fieldSettingPopulateDataEl, fieldSettingNewLineEl,
				fieldSettingReadFromReqEl,  settingVisibleOnAndNewLineColEl, fieldSettingVisibleOnEl, fieldSettingExtraValidationsEl;
			
			mainSettingRowEl = commonFc.createDivEl('row');
			
			settingTypeColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			fieldSettingTypeEl = createFieldSettingType();
			
			settingDataTypeColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			fieldSettingDataTypeEl = createFieldSettingDataType();
			
			settingStatusColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12');
			fieldSettingStatusEl = createFieldSettingStatus();
			
			settingReadonlyAndDisableColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingReadonlyEl = createFieldSettingReadonly();
			fieldSettingDisableEl = createFieldSettingDisable();
			
			settingRequiredAndExtraValidationsColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingRequiredEl = createFieldSettingRequired();
			fieldSettingExtraValidationsEl = createCheckboxFieldExtraValidations();
			
			settingVisibleOnAndNewLineColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingVisibleOnEl = createCheckboxFieldVisibleOn();
			fieldSettingNewLineEl = createCheckboxFieldSettingNewLine();
			
			settingPopulateDataAndReadFromReqColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldSettingPopulateDataEl = createCheckboxFieldSettingPopulateData();
			fieldSettingReadFromReqEl = createCheckboxFieldSettingReadFromReq();
			
			settingPostDataColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 setting-checkbox-div-el');
			fieldsettingPostDataEl = createCheckboxFieldSettingPostData();
			
			$(settingTypeColEl).append(fieldSettingTypeEl);
			$(mainSettingRowEl).append(settingTypeColEl);
			
			$(settingDataTypeColEl).append(fieldSettingDataTypeEl);
			$(mainSettingRowEl).append(settingDataTypeColEl);
			
			$(settingStatusColEl).append(fieldSettingStatusEl);
			$(mainSettingRowEl).append(settingStatusColEl);
			
			$(settingReadonlyAndDisableColEl).append(fieldSettingDisableEl);
			$(settingReadonlyAndDisableColEl).append(fieldSettingReadonlyEl);
			$(mainSettingRowEl).append(settingReadonlyAndDisableColEl);
			
			$(settingRequiredAndExtraValidationsColEl).append(fieldSettingRequiredEl);
			$(settingRequiredAndExtraValidationsColEl).append(fieldSettingExtraValidationsEl);
			$(mainSettingRowEl).append(settingRequiredAndExtraValidationsColEl);
			
			$(settingVisibleOnAndNewLineColEl).append(fieldSettingVisibleOnEl);
			$(settingVisibleOnAndNewLineColEl).append(fieldSettingNewLineEl);
			$(mainSettingRowEl).append(settingVisibleOnAndNewLineColEl);
			
			$(settingPopulateDataAndReadFromReqColEl).append(fieldSettingPopulateDataEl);
			$(settingPopulateDataAndReadFromReqColEl).append(fieldSettingReadFromReqEl);
			$(mainSettingRowEl).append(settingPopulateDataAndReadFromReqColEl);
			
			$(settingPostDataColEl).append(fieldsettingPostDataEl);
			$(mainSettingRowEl).append(settingPostDataColEl);
			
			return mainSettingRowEl;
		};
		
		createFieldSettingType = function(){
			var fieldSettingTypeLabelEl, requiredEl, fieldSettingTypeDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			fieldSettingTypeLabelEl = commonFc.createLabel('fieldType', fieldType, 'field-type-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			changeEventObj.fnName = 'selectedFieldSettingType(this);';
			fieldSettingTypeDropdownEl = commonFc.createDropdown('form-control field-type-dropdown-el', 'fieldType', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(fieldSettingTypeLabelEl).append(requiredEl);
			$(formGroupDivEl).append(fieldSettingTypeLabelEl);
			$(formGroupDivEl).append(fieldSettingTypeDropdownEl);
			setTimeout(function(){ 
				 var isMasterForm = formBuilderConfigJsonObj.isMasterForm;
				 if(formBuilderConfigJsonObj.hasOwnProperty('isMasterForm') && isMasterForm){
					 commonFc.populateDropdown(masterFormSettingTypes, fieldSettingTypeDropdownEl);
				 } else{
					 commonFc.populateDropdown(settingTypes, fieldSettingTypeDropdownEl);
				 }
			 }, 2000);
			
			return formGroupDivEl;
		};
		
		createFieldSettingDataType = function(){
			var fieldSettingDataTypeLabelEl, requiredEl, fieldSettingDataTypeDropdownEl, formGroupDivEl;
			fieldSettingDataTypeLabelEl = commonFc.createLabel('fieldDataType', fieldDataType, 'field-data-type-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			fieldSettingDataTypeDropdownEl = commonFc.createDropdown('form-control field-data-type-dropdown-el', 'fieldDataType');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			
			
			$(fieldSettingDataTypeLabelEl).append(requiredEl);
			$(formGroupDivEl).append(fieldSettingDataTypeLabelEl);
			$(formGroupDivEl).append(fieldSettingDataTypeDropdownEl);
			
			return formGroupDivEl;
		};
		
		createFieldSettingStatus = function(){
			var fieldSettingStatusLabelEl, requiredEl, fieldSettingStatusDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			fieldSettingStatusLabelEl = commonFc.createLabel('fieldStatus', fieldStatus, 'field-status-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			changeEventObj.fnName = 'statusInactive(this);';
			fieldSettingStatusDropdownEl = commonFc.createDropdown('form-control field-status-dropdown-el', 'fieldStatus', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(fieldSettingStatusLabelEl).append(requiredEl);
			$(formGroupDivEl).append(fieldSettingStatusLabelEl);
			$(formGroupDivEl).append(fieldSettingStatusDropdownEl);
			commonFc.populateDropdown(settingStatus, fieldSettingStatusDropdownEl);
			return formGroupDivEl;
		};
		
		createFieldSettingReadonly = function(){
			var fieldSettingReadonlyEl;
			fieldSettingReadonlyEl = commonFc.createInputCheckboxEl('form-check-label field-read-only-label field-setting-label', 'fieldReadonly' ,'form-check-input field-read-only-checkbox-el', 'fieldReadonly', readonly );
			return fieldSettingReadonlyEl;
		};
		
		createFieldSettingDisable = function(ind){
			var fieldSettingDisableEl;
			fieldSettingDisableEl = commonFc.createInputCheckboxEl('form-check-label field-disable-label field-setting-label', 'fieldDisable','form-check-input field-disable-checkbox-el', 'fieldDisable', disabled);
			return fieldSettingDisableEl;
		};
		
		createFieldSettingRequired = function(ind){
			var fieldSettingRequiredEl;
			fieldSettingRequiredEl = commonFc.createInputCheckboxEl('form-check-label field-required-label field-setting-label', 'fieldRequired', 'form-check-input field-required-checkbox-el', 'fieldRequired', required);
			return fieldSettingRequiredEl;
		};
		
		createCheckboxFieldSettingPostData = function(){
			var checkboxFieldSettingPostDataEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'showDataField(this);';
			checkboxFieldSettingPostDataEl = commonFc.createInputCheckboxWithIdEl('form-check d-none', 'displayPostData', 'form-check-label post-data-label field-setting-label', 'postData', 'form-check-input post-data-checkbox-el', 'postData', postData, changeEventObj, 'togglePostDataField');
			$(checkboxFieldSettingPostDataEl).addClass('d-none');
			return checkboxFieldSettingPostDataEl;
		};
		
		createCheckboxFieldSettingPopulateData = function(){
			var checkboxFieldSettingPopulateDataEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'showDataField(this);';
			checkboxFieldSettingPopulateDataEl = commonFc.createInputCheckboxWithIdEl('form-check d-none', 'displayPopulateData', 'form-check-label populate-data-label field-setting-label', 'populateData', 'form-check-input populate-data-checkbox-el', 'populateData', prepoulateData, changeEventObj, 'togglePopulateDataField');
			$(checkboxFieldSettingPopulateDataEl).addClass('d-none');
			return checkboxFieldSettingPopulateDataEl;
		};
		
		createCheckboxFieldSettingReadFromReq = function(){
			var checkboxFieldSettingReadFromReqEl,changeEventObj = new Object({});
			changeEventObj.fnName = 'showDataField(this);';
			checkboxFieldSettingReadFromReqEl = commonFc.createInputCheckboxWithIdEl('form-check d-none','displayReadFromReqParam', 'form-check-label read-from-req-param-label field-setting-label', 'readFromReqParam','form-check-input read-from-req-param-checkbox-el', 'readFromReqParam', readFromReqParam, changeEventObj, 'toggleReadFromReqParamField');
			$(checkboxFieldSettingReadFromReqEl).addClass('d-none');
			return checkboxFieldSettingReadFromReqEl;
		};
		
		createCheckboxFieldVisibleOn = function(){
			var checkboxFieldVisibleOnEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'toggleVisibleOn(this);';
			checkboxFieldVisibleOnEl = commonFc.createInputCheckboxEl('form-check-label visible-on-label field-setting-label', 'visibleOn', 'form-check-input visible-on-checkbox-el', 'visibleOn', visibleOn, changeEventObj);
			
			return checkboxFieldVisibleOnEl;
		};
		
		createCheckboxFieldSettingNewLine = function(){
			var checkboxFieldNewLineEl, changeEventObj = new Object({});
			checkboxFieldNewLineEl = commonFc.createInputCheckboxEl('form-check-label new-line-label field-setting-label', 'newLine', 'form-check-input new-line-checkbox-el', 'newLine', newLine);
			
			return checkboxFieldNewLineEl;
		};
		
		createCheckboxFieldExtraValidations = function(){
			var checkboxFieldExtraValidationsEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'toggleExtraValidations(this);';
			checkboxFieldExtraValidationsEl = commonFc.createInputCheckboxEl('form-check-label extra-validations-label field-setting-label', 'extraValidations', 'form-check-input extra-validations-checkbox-el', 'extraValidations', extraValidations, changeEventObj);
			return checkboxFieldExtraValidationsEl;
		};
		
		/** Selected Field Types Elements **/  
		createFieldSettingSubSection2 = function(){
			var mainSettingRow2El, settingPlaceholderColEl, fieldSettingPlaceholderEl, htmlEditorPlaceholderColEl, htmlEditorPlaceholderEl, minNumberPlaceholderColEl, 
				minNumberPlaceholderEl, rangeMaxCharacterPlaceholderEl, maxNumberPlaceholderColEl, maxNumberPlaceholderEl, multipleFileUploadColEl, multipleFileUploadEl, fileExtensionsInputTagColEl,
				fileExtensionsInputTagEl, groupOrderColEl, groupOrderEl, groupColEl, groupEl, averageColEl, groupAverageEl, overAllAverageEl, totalColEl, groupTotalEl,
				overallTotalEl, minBoundaryColEl, minBoundaryEl, maxBoundaryColEl, maxBoundaryEl, rangeOptionsColEl, rangeOptionsEl, formatPlaceholderColEl, 
				formatFieldPlaceholderEl, valuesInputTagColEl, valuesInputTagEl, defaultSelectedColEl, defaultSelectedEl, dropdownConfigCheckboxColEl, 
				multiselectDropdownCheckboxEl, searchableDropdownCheckboxEl, WhereToPopulateDropdownValuesColEl, WhereToPopulateDropdownValuesEl, settingPostDataColEl, 
				settingPostDataEl, settingPopulateDataColEl, settingPopulateDataEl, settingReadFromReqColEl, settingReadFromReqEl, settingCreateMasterColEl,
				settingCreateMasterEl, customRangeOptionsColEl, customRangeOptionsEl, rangeOptionNameDrColEl, rangeOptionNameDrEl, rangeTotalCharacterEl, rangeCommentEl,
				rangeTotalCharacterColEl, rangeCommentColEl, rangeCommentPlaceholderEl, rangeCommentLocaleColEl, rangeCommentLocaleEl;
			
			mainSettingRow2El = commonFc.createDivEl('row');
			
			settingPlaceholderColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none placeholder-div-el', 'displayPlaceholder');
			fieldSettingPlaceholderEl = createFieldSettingPlaceholder();
			placeholderLocaleColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-3 col-xs-3 px-0 d-none placeholder-locale-btn-div-el', 'displayPlaceholderLocaleBtn');
			placeholderLocaleEl = createPlaceholderLocaleBtn();

			htmlEditorPlaceholderColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 d-none html-editor-placeholder-div-el', 'displayHTMLEditor');
			htmlEditorPlaceholderEl = createHTMLEditorPlaceholder();
			htmlEditorPlaceholderLocaleColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-3 col-xs-3 px-0 d-none html-editor-placeholder-locale-btn-div-el', 'displayHTMLEditorLocaleBtn');
			htmlEditorPlaceholderLocaleEl = createHTMLPlaceholderLocaleBtn();

			formatPlaceholderColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none format-placeholder-div-el', 'displayFormatPlaceholder');
			formatFieldPlaceholderEl = createFormatFieldSettingPlaceholder();
			
			minNumberPlaceholderColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none min-number-placeholder-div-el', 'displayMinNumberPlaceholder');
			minNumberPlaceholderEl = createMinNumberFieldSettingPlaceholder();
			
			maxNumberPlaceholderColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none max-number-placeholder-div-el', 'displayMaxNumberPlaceholder');
			maxNumberPlaceholderEl = createMaxNumberFieldSettingPlaceholder();
			
			multipleFileUploadColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none multiple-file-upload-div-el', 'displayMultipleFileUpload');
			multipleFileUploadEl = createMultipleFileUploadCheckbox();
			
			minBoundaryColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none min-boundary-div-el', 'displayMinBoundary');
			minBoundaryEl = createMinBoundary();
			
			maxBoundaryColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none max-boundary-div-el', 'displayMaxBoundary');
			maxBoundaryEl = createMaxBoundary();
			
			rangeOptionsColEl = commonFc.createDivEl('col-lg-4 col-md-2 col-sm-12 col-xs-12 d-none range-options-div-el', 'displayRangeOptions');
			rangeOptionsEl = createRangeFieldJSGrid();
			
			rangeOptionNameDrColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none range-option-name-dr-div-el', 'displayRangeOptionNameDr');
			rangeOptionNameDrEl = createRangeOptionNameDropdown();
			
			customRangeOptionsColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 d-none custom-range-options-div-el', 'displayCustomRangeOptions');
			customRangeOptionsEl = createCustomRangeFieldJSGrid();
			
			averageColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none average-div-el setting-checkbox-div-el', 'displayAverage');
			groupAverageEl = CreateGroupAverage();
			overAllAverageEl = createOverallAverage();
			rangeCommentEl = createRangeComment();
			
			totalColEl = commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none total-div-el setting-checkbox-div-el', 'displayTotal');
			groupTotalEl = createGroupTotal();
			overallTotalEl = createOverallTotal();
			rangeTotalCharacterEl = createRangeTotalCharacter();
			
			rangeTotalCharacterColEl = commonFc.createDivEl('col-lg-1 col-md-2 col-sm-12 col-xs-12 d-none range-total-character-div-el', 'displayRangeTotalCharacter');
			rangeMaxCharacterPlaceholderEl = createRangeMaxCharacter();
			
			rangeCommentColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 d-none range-comment-textarea-div-el', 'displayRangeComment');
			rangeCommentPlaceholderEl = createCommentTextarea();
			rangeCommentLocaleColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-3 col-xs-3 px-0 d-none range-comment-locale-btn-div-el', 'displayRangeCommentLocaleBtn');
			rangeCommentLocaleEl = createRangeCommentLocaleBtn();
			
			valuesInputTagColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 d-none values-input-tag-div-el', 'displayValuesInputTag');
			valuesInputTagEl = createCheckboxRadioFieldJSGrid();
			
			dropdownConfigCheckboxColEl = commonFc.createDivEl('col-lg-1 col-md-4 col-sm-12 col-xs-12 d-none dropdown-config-checkbox-div-el', 'displayDropdownConfigCheckbox');
			multiselectDropdownCheckboxEl = createMultiselectDropdownCheckbox();
			searchableDropdownCheckboxEl = createSearchableDropdownCheckbox();
			
			WhereToPopulateDropdownValuesColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none where-to-populate-dropdown-div-el', 'displayWhereToPopulateDropdown');
			WhereToPopulateDropdownValuesEl = createWhereToPopulateDropdownValues();
			
			settingCreateMasterColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none create-master-table-radio-div-el', 'displayMasterTableRadio');
			settingCreateMasterEl = createFieldSettingMasterRadio();
			
			settingPostDataColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none post-data-div-el', 'togglePostDataField');
			settingPostDataEl = createFieldSettingPostData();
			
			settingPopulateDataColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none populate-data-div-el', 'togglePopulateDataField');
			settingPopulateDataEl = createFieldSettingPopulateData();
			
			settingReadFromReqColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none read-from-req-param-field-div-el', 'toggleReadFromReqParamField');
			settingReadFromReqEl = createFieldSettingReadFromReq();
			
			$(settingPlaceholderColEl).append(fieldSettingPlaceholderEl);
			$(placeholderLocaleColEl).append(placeholderLocaleEl);
			$(mainSettingRow2El).append(settingPlaceholderColEl);
			$(mainSettingRow2El).append(placeholderLocaleColEl);
			
			$(htmlEditorPlaceholderColEl).append(htmlEditorPlaceholderEl);
			$(htmlEditorPlaceholderLocaleColEl).append(htmlEditorPlaceholderLocaleEl);
			$(mainSettingRow2El).append(htmlEditorPlaceholderColEl);
			$(mainSettingRow2El).append(htmlEditorPlaceholderLocaleColEl);
			
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
			
			$(rangeOptionNameDrColEl).append(rangeOptionNameDrEl);
			$(mainSettingRow2El).append(rangeOptionNameDrColEl);
			
			$(customRangeOptionsColEl).append(customRangeOptionsEl);
			$(mainSettingRow2El).append(customRangeOptionsColEl);
			
			$(averageColEl).append(groupAverageEl);
			$(averageColEl).append(overAllAverageEl);
			$(averageColEl).append(rangeCommentEl);
			$(mainSettingRow2El).append(averageColEl);
			
			$(totalColEl).append(groupTotalEl);
			$(totalColEl).append(overallTotalEl);
			$(totalColEl).append(rangeTotalCharacterEl);
			$(mainSettingRow2El).append(totalColEl);
			
			$(valuesInputTagColEl).append(valuesInputTagEl);
			$(mainSettingRow2El).append(valuesInputTagColEl);
			
			$(rangeTotalCharacterColEl).append(rangeMaxCharacterPlaceholderEl);
			$(mainSettingRow2El).append(rangeTotalCharacterColEl);
			
			$(rangeCommentColEl).append(rangeCommentPlaceholderEl);
			$(rangeCommentLocaleColEl).append(rangeCommentLocaleEl);
			$(mainSettingRow2El).append(rangeCommentColEl);
			$(mainSettingRow2El).append(rangeCommentLocaleColEl);
			
			$(defaultSelectedColEl).append(defaultSelectedEl);
			$(mainSettingRow2El).append(defaultSelectedColEl);
			
			$(dropdownConfigCheckboxColEl).append(multiselectDropdownCheckboxEl);
			$(dropdownConfigCheckboxColEl).append(searchableDropdownCheckboxEl);
			$(mainSettingRow2El).append(dropdownConfigCheckboxColEl);
			
			$(WhereToPopulateDropdownValuesColEl).append(WhereToPopulateDropdownValuesEl);
			$(mainSettingRow2El).append(WhereToPopulateDropdownValuesColEl);
			
			$(settingCreateMasterColEl).append(settingCreateMasterEl);
			$(mainSettingRow2El).append(settingCreateMasterColEl);
			
			$(settingPostDataColEl).append(settingPostDataEl);
			$(mainSettingRow2El).append(settingPostDataColEl);
			
			$(settingPopulateDataColEl).append(settingPopulateDataEl);
			$(mainSettingRow2El).append(settingPopulateDataColEl);
			
			$(settingReadFromReqColEl).append(settingReadFromReqEl);
			$(mainSettingRow2El).append(settingReadFromReqColEl);
			
			return mainSettingRow2El;
		};
		
		createCommentTextarea = function(){
			var rangeCommentPlaceholderLabelEl, rangeCommentPlaceholderInputEl, formGroupDivEl;
			
			formGroupDivEl = commonFc.createDivEl('form-group');
			rangeCommentPlaceholderLabelEl = commonFc.createLabel('rangeComment', rangeCommentTextarea, 'range-comment-label field-setting-label');
			rangeCommentPlaceholderInputEl = commonFc.createTextAreaEl('form-control range-comment-textarea-el', 'rangeComment', 2);			
			
			$(formGroupDivEl).append(rangeCommentPlaceholderLabelEl);
			$(formGroupDivEl).append(rangeCommentPlaceholderInputEl);

			$(rangeCommentPlaceholderInputEl).attr("onchange", "updateHiddenFieldValue(this);");

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var rangeCommentPlaceholderLocaleInputEl;
				rangeCommentPlaceholderLocaleInputEl = commonFc.createInputTextEl('form-control', 'rangeComment_' + val.value);
				$(rangeCommentPlaceholderLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(rangeCommentPlaceholderLocaleInputEl);
			});

			return formGroupDivEl;
		};
		
		createRangeCommentLocaleBtn = function() {
			var formEmptyLabelEl, formGroupDivEl, formInputGroupDivEl, formInputGroupAppendDivEl, changeEventFn = new Object({});

			formGroupDivEl = commonFc.createDivEl('form-group');
			formEmptyLabelEl = commonFc.createLabel('');
			formInputGroupDivEl = commonFc.createDivEl('input-group');

			changeEventFn.fnName = 'changeBasicSectionLocale(this, false);';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl('rangeCommentSelectedLocale', changeEventFn);

			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);
			
			$(formGroupDivEl).append(formEmptyLabelEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			
			return formGroupDivEl;
		};
		
		createFieldSettingPlaceholder = function(){
			var fieldSettingPlaceholderLabelEl, fieldSettingPlaceholderInputEl, formGroupDivEl;
			
			formGroupDivEl = commonFc.createDivEl('form-group');
			fieldSettingPlaceholderLabelEl = commonFc.createLabel('placeholder', placeholder, 'placeholder-label field-setting-label');
			fieldSettingPlaceholderInputEl = commonFc.createTextAreaEl('form-control placeholder-textarea-el', 'placeholder', 2);			
			
			$(formGroupDivEl).append(fieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(fieldSettingPlaceholderInputEl);

			$(fieldSettingPlaceholderInputEl).attr("onchange", "updateHiddenFieldValue(this);");

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var formFieldPlaceholderLocaleInputEl;
				formFieldPlaceholderLocaleInputEl = commonFc.createInputTextEl('form-control', 'placeholder_' + val.value);
				$(formFieldPlaceholderLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(formFieldPlaceholderLocaleInputEl);
			});

			return formGroupDivEl;
		};

		createPlaceholderLocaleBtn = function() {
			var formEmptyLabelEl, formGroupDivEl, formInputGroupDivEl, formInputGroupAppendDivEl, changeEventFn = new Object({});

			formGroupDivEl = commonFc.createDivEl('form-group');
			formEmptyLabelEl = commonFc.createLabel('');
			formInputGroupDivEl = commonFc.createDivEl('input-group');

			changeEventFn.fnName = 'changeBasicSectionLocale(this, false);';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl('placeholderSelectedLocale', changeEventFn);

			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);
			
			$(formGroupDivEl).append(formEmptyLabelEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			
			return formGroupDivEl;
		};
		
		createHTMLEditorPlaceholder = function(){
			var htmlEditorLabelEl, htmlEditorEl, formGroupDivEl;

			formGroupDivEl = commonFc.createDivEl('form-group');
			formDescriptionLabelEl = commonFc.createLabel('htmlEditor', htmlPlaceholder, 'html-editor-label field-setting-label');
			formDescriptionTextEditorEl = commonFc.createTextEditorEl('html-editor-el','htmlEditor');			
			 
			$(formGroupDivEl).append(formDescriptionLabelEl);
			$(formGroupDivEl).append(formDescriptionTextEditorEl);

			$.each(commonFc.currentAvailableLocales, function(index, val) {
				var formFieldHTMLEditorLocaleInputEl;
				formFieldHTMLEditorLocaleInputEl = commonFc.createInputTextEl('form-control', 'htmlEditor_' + val.value);
				$(formFieldHTMLEditorLocaleInputEl).prop('type', 'hidden');
				$(formGroupDivEl).append(formFieldHTMLEditorLocaleInputEl);
			});
			 
			return formGroupDivEl;
		};

		createHTMLPlaceholderLocaleBtn = function() {
			var formEmptyLabelEl, formGroupDivEl, formInputGroupDivEl, formInputGroupAppendDivEl, secondaryBtnEl,
			formDropdownMenuEL, changeEventFn = new Object({});

			formGroupDivEl = commonFc.createDivEl('form-group');
			formEmptyLabelEl = commonFc.createLabel('');
			formInputGroupDivEl = commonFc.createDivEl('input-group');

			changeEventFn.fnName = 'changeBasicSectionLocale(this, false);';
			formInputGroupAppendDivEl = commonFc.createLocaleBtnEl('htmlEditorSelectedLocale', changeEventFn);
			
			$(formInputGroupDivEl).append(formInputGroupAppendDivEl);

			$(formGroupDivEl).append(formEmptyLabelEl);
			$(formGroupDivEl).append(formInputGroupDivEl);
			
			return formGroupDivEl;
		};
		
		createFormatFieldSettingPlaceholder = function(){
			var formatFieldSettingPlaceholderLabelEl, requiredEl, formatFieldSettingPlaceholderDropdownEl, formGroupDivEl;
			formatFieldSettingPlaceholderLabelEl = commonFc.createLabel('formatPlaceholder', format, 'format-placeholder-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			formatFieldSettingPlaceholderDropdownEl = commonFc.createDropdown('form-control format-placeholder-dropdown-el', 'formatPlaceholder');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formatFieldSettingPlaceholderLabelEl).append(requiredEl);
			$(formGroupDivEl).append(formatFieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(formatFieldSettingPlaceholderDropdownEl);
			
			return formGroupDivEl;
		};
		
		createMinNumberFieldSettingPlaceholder = function(){
			var minNumberFieldSettingPlaceholderLabelEl, requiredEl, minNumberFieldSettingPlaceholderEl, formGroupDivEl;
			minNumberFieldSettingPlaceholderLabelEl = commonFc.createLabel('minNumberPlaceholder', minNumber, 'min-number-placholder-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			minNumberFieldSettingPlaceholderEl = commonFc.createInputNumberEl('form-control min-number-placholder-input-el', 'minNumberPlaceholder');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(minNumberFieldSettingPlaceholderLabelEl).append(requiredEl);
			$(formGroupDivEl).append(minNumberFieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(minNumberFieldSettingPlaceholderEl);
			return formGroupDivEl
		};
		
		createMaxNumberFieldSettingPlaceholder = function(){
			var maxNumberFieldSettingPlaceholderLabelEl, requiredEl, maxNumberFieldSettingPlaceholderEl, formGroupDivEl;
			maxNumberFieldSettingPlaceholderLabelEl = commonFc.createLabel('maxNumberPlaceholder', maxNumber, 'max-number-placholder-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			maxNumberFieldSettingPlaceholderEl = commonFc.createInputNumberEl('form-control max-number-placholder-input-el', 'maxNumberPlaceholder');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(maxNumberFieldSettingPlaceholderLabelEl).append(requiredEl);
			$(formGroupDivEl).append(maxNumberFieldSettingPlaceholderLabelEl);
			$(formGroupDivEl).append(maxNumberFieldSettingPlaceholderEl);
			return formGroupDivEl
		};
		
		createRangeMaxCharacter = function(){
			var rangeMaxCharacterPlaceholderLabelEl, requiredEl, rangeMaxCharacterPlaceholderEl, formGroupDivEl;
			rangeMaxCharacterPlaceholderLabelEl = commonFc.createLabel('rangeTotalCharacter', rangeMaxCharacter, 'range-max-character-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			rangeMaxCharacterPlaceholderEl = commonFc.createInputNumberEl('form-control range-max-character-input-el', 'rangeMaxCharacter');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(rangeMaxCharacterPlaceholderLabelEl).append(requiredEl);
			$(formGroupDivEl).append(rangeMaxCharacterPlaceholderLabelEl);
			$(formGroupDivEl).append(rangeMaxCharacterPlaceholderEl);
			return formGroupDivEl;
		};
		
		createRangeTotalCharacter = function(){
			var rangeTotalCharacterCheckboxEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'toggleRangeMaxCharacter(this);';
			rangeTotalCharacterCheckboxEl = commonFc.createInputCheckboxEl('form-check-label range-total-character-label field-setting-label', 'rangeTotalCharacter', 'form-check-input range-total-character-checkbox-el', 'rangeTotalCharacter', rangeTotalCharacter, changeEventObj);
			return rangeTotalCharacterCheckboxEl;
		};
		
		createRangeComment = function(){
			var rangeCommentCheckboxEl, changeEventObj = new Object({});
			changeEventObj.fnName = 'toggleIsRangeComment(this);';
			rangeCommentCheckboxEl = commonFc.createInputCheckboxEl('form-check-label range-comment-label field-setting-label', 'isRangeComment', 'form-check-input range-comment-checkbox-el', 'isRangeComment', isRangeComment, changeEventObj);
			return rangeCommentCheckboxEl;
		};
		
		createMultipleFileUploadCheckbox = function(){
			var multipleFileUploadCheckboxEl;
			multipleFileUploadCheckboxEl = commonFc.createInputCheckboxEl('form-check-label multiple-file-upload-label field-setting-label', 'multipleFileUpload', 'form-check-input multiple-file-upload-checkbox-el', 'multipleFileUpload', multipleUplaod);
			return multipleFileUploadCheckboxEl;
		};
		
		CreateGroupAverage = function(){
			var groupAverageCheckboxEl;
			groupAverageCheckboxEl = commonFc.createInputCheckboxEl('form-check-label group-average-label field-setting-label', 'groupAverage', 'form-check-input group-average-checkbox-el', 'groupAverage', groupAverage);
			return groupAverageCheckboxEl;
		};
		
		createOverallAverage = function(){
			var overallAverageCheckboxEl;
			overallAverageCheckboxEl = commonFc.createInputCheckboxEl('form-check-label over-all-average-label field-setting-label', 'overallAverage', 'form-check-input over-all-average-checkbox-el', 'overallAverage', overallAverage);
			return overallAverageCheckboxEl;
		};
		
		createGroupTotal = function(){
			var groupTotalCheckboxEl;
			groupTotalCheckboxEl = commonFc.createInputCheckboxEl('form-check-label group-total-label field-setting-label', 'groupTotal', 'form-check-input group-total-checkbox-el', 'groupTotal', groupTotal);
			return groupTotalCheckboxEl;
		};
		
		createOverallTotal = function(){
			var overallTotalCheckboxEl;
			overallTotalCheckboxEl = commonFc.createInputCheckboxEl('form-check-label over-all-total-label field-setting-label', 'overallTotal', 'form-check-input over-all-total-checkbox-el', 'overallTotal', overallTotal);
			return overallTotalCheckboxEl;
		};
		
		getJSGridRowsCount = function(elJEl){
			var gridRowCount =  $(elJEl).jsGrid('option', 'data').length;
			console.log('gridRowCount: ',gridRowCount);
			return gridRowCount;
		};
		
		getJSGridLastElement = function(elJEl){
			var lastItemValue;
			var gridRow =  $(elJEl).jsGrid('option', 'data');
			for(var i=0; i < gridRow.length; i++) {
				if(i == (gridRow.length - 1)){
					lastItemValue = gridRow[i].en_US;
					console.log('lastItemValue: ',lastItemValue);
				}
			}
			return lastItemValue;
		};
		
		createMinBoundary = function(){
			var minBoundaryLabel, requiredEl, minBoundaryEl, formGroupDivEl, totalItemsInserted, lastItemValue, changeEventObj = new Object({});
			minBoundaryLabel = commonFc.createLabel('minBoundary', min, 'min-boundary-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			changeEventObj.fnName = 'populateRangeOptions(this);';
			minBoundaryEl = commonFc.createInputNumberEl('form-control min-boundary-el boundary-el', 'minBoundary', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(minBoundaryLabel).append(requiredEl);
			$(formGroupDivEl).append(minBoundaryLabel);
			$(formGroupDivEl).append(minBoundaryEl);
			return formGroupDivEl;
		};
		
		createMaxBoundary = function(){
			var maxBoundaryLabel, requiredEl, maxBoundaryEl, formGroupDivEl, changeEventObj = new Object({});
			maxBoundaryLabel = commonFc.createLabel('maxBoundary', max, 'max-boundary-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			changeEventObj.fnName = 'populateRangeOptions(this);';
			maxBoundaryEl = commonFc.createInputNumberEl('form-control max-boundary-el boundary-el', 'maxBoundary', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(maxBoundaryLabel).append(requiredEl);
			$(formGroupDivEl).append(maxBoundaryLabel);
			$(formGroupDivEl).append(maxBoundaryEl);
			return formGroupDivEl;
		};
		
		createRangeOptionsConfig = function(){
			var tableEl, rowEl, theadEl, nameHeadEl, valueHeadEl, tbodyEl;
			tableEl = commonFc.createTableEl('table border range-options-config-table', 'rangOptionsConfigTable');
			rowEl = commonFc.createTREl();
			theadEl = commonFc.createTheadEl('thead-dark');
			nameHeadEl = commonFc.createTHEl(false, false, 'col', 'Name');
			valueHeadEl = commonFc.createTHEl(false, false, 'col', 'Value');
			tbodyEl = commonFc.createTbodyEl('range-options-config-tbody', 'rangeOptionsConfigTbody');
			
			$(rowEl).append(nameHeadEl);
			$(rowEl).append(valueHeadEl);
			$(theadEl).append(rowEl);
			$(tableEl).append(theadEl);
			
			$(tableEl).append(tbodyEl);
			
			return tableEl;
		} 
		
		createRangeOptionsConfigSection = function(){
			var rangeOptionsConfigRowEl, rangeOptionsConfigColEl, rangeOptionsConfigEl;
			
			rangeOptionsConfigRowEl = commonFc.createDivEl('row range-options-config-row hide', 'rangeOptionsConfigRow');
			
			rangeOptionsConfigColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 range-options-config-div-el', 'displayRangeOptionsConfig');
			rangeOptionsConfigEl = createRangeOptionsConfig();
			
			$(rangeOptionsConfigColEl).append(rangeOptionsConfigEl);
			$(rangeOptionsConfigRowEl).append(rangeOptionsConfigColEl);
			
			return rangeOptionsConfigRowEl;
		};
		
		createCustomRangeFieldJSGrid = function(){
			var customRangeFieldLabelEl, customRangeFieldJSGridEl, formGroupDivEl, customRangeFields;
			customRangeFieldLabelEl = commonFc.createLabel('values', values);
			customRangeFieldJSGridEl = commonFc.createDivEl('custom-range-values-div-el', 'displayCustomRangeJSGrid');
			formGroupDivEl = commonFc.createDivEl('form-group');
			customRangeFields = commonFc.getCustomRangeFieldsArr();
			$(formGroupDivEl).append(customRangeFieldLabelEl);
			$(formGroupDivEl).append(customRangeFieldJSGridEl);
			commonFc.initJsGrid(customRangeFieldJSGridEl, customRangeFields, isJSGrid);
			return formGroupDivEl;
		};
		
		createRangeOptionNameDropdown = function(){
			var rangeOptionNameLabelEl, rangeOptionNameDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			rangeOptionNameLabelEl = commonFc.createLabel('rangeOptionNameDr', rangeNames);
			changeEventObj.fnName = 'selectedRangeOption(this);';
			rangeOptionNameDropdownEl = commonFc.createDropdown('form-control', 'rangeOptionNameDr', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(rangeOptionNameLabelEl);
			$(formGroupDivEl).append(rangeOptionNameDropdownEl);
			commonFc.populateDropdown(rangeOptionDataArr, rangeOptionNameDropdownEl);
			
			return formGroupDivEl;
		};
		
		createMultiselectDropdownCheckbox = function(){
			var multiselectDropdownCheckboxEl, formGroupDivEl;
			multiselectDropdownCheckboxEl = commonFc.createInputCheckboxEl('form-check-label multiselect-dropdown-checkbox-label field-setting-label', 'multiselectDropdownCheckbox','form-check-input multiselect-dropdown-checkbox-el', 'multiselectDropdownCheckbox', multiselect);
			return multiselectDropdownCheckboxEl;
		};
		
		createSearchableDropdownCheckbox = function(){
			var searchableDropdownCheckboxEl, formGroupDivEl;
			searchableDropdownCheckboxEl = commonFc.createInputCheckboxEl('form-check-label searchable-dropdown-checkbox-label field-setting-label', 'searchableDropdownCheckbox','form-check-input searchable-dropdown-checkbox-el', 'searchableDropdownCheckbox', searchable);
			return searchableDropdownCheckboxEl;
		};
		
		createWhereToPopulateDropdownValues = function(){
			var whereToPopulateDropdownLabelEl, whereToPopulateDropdownEl, formGroupDivEl,  changeEventObj = new Object({});
			whereToPopulateDropdownLabelEl = commonFc.createLabel('whereToPopulateDropdown', populateValues, 'where-to-populate-dropdown-label field-setting-label');
			changeEventObj.fnName = 'whereToPopulateSelectedDropdownValue(this);';
			whereToPopulateDropdownEl = commonFc.createDropdown('form-control where-to-populate-dropdown-el', 'whereToPopulateDropdown', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(whereToPopulateDropdownLabelEl);
			$(formGroupDivEl).append(whereToPopulateDropdownEl);
			commonFc.populateDropdown(whereToPopulateDropdownValues, whereToPopulateDropdownEl);
			return formGroupDivEl;
		};
		
		createVisibleOnDropdownValues = function(){
			var visibleOnDropdownLabelEl, visibleOnDropdownEl, formGroupDivEl,  changeEventObj = new Object({});
			visibleOnDropdownLabelEl = commonFc.createLabel('visibleOnDropdown', visibleOn, 'visible-on-dropdown-label field-setting-label');
            changeEventObj.fnName = 'toggleVisibleOnTextInput(this);';
			visibleOnDropdownEl = commonFc.createDropdown('form-control visible-on-dropdown-el', 'visibleOnDropdown', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			                            
			$(formGroupDivEl).append(visibleOnDropdownLabelEl);
			$(formGroupDivEl).append(visibleOnDropdownEl);
			return formGroupDivEl;
		};
		
        createVisibleOnInput = function(){
            var fieldVisibleOnInputLabelEl, fieldVisibleOnInputEl, formGroupDivEl;
            fieldVisibleOnInputLabelEl = commonFc.createLabel('visibleOnName', visibleOnName, 'visible-on-name-label field-setting-label');
            fieldVisibleOnInputEl = commonFc.createInputTextEl('form-control visible-on-name-input-el', 'visibleOnName');
            formGroupDivEl = commonFc.createDivEl('form-group');
            
            $(formGroupDivEl).append(fieldVisibleOnInputLabelEl);
            $(formGroupDivEl).append(fieldVisibleOnInputEl);
            
            return formGroupDivEl;
        };
     	
        createFieldSettingMasterRadio = function(){
        	var fieldSettingMasterTableLabelEl, masterTableRadioRowEl, fieldSettingMasterTableRadioEl, formGroupDivEl, yesCreateMasterTableEl, noCreateMasterTableEl, yesCreateMasterTableSectionEl, noCreateMasterTableSectionEl;
        	fieldSettingMasterTableLabelEl = commonFc.createLabel('createMasterTable', createMasterTable, 'create-master-table-label field-setting-label');
        	
        	masterTableRadioRowEl = commonFc.createDivEl('row create-master-table-row mt-2');

        	yesCreateMasterTableEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
        	yesCreateMasterTableSectionEl = createYesRadioField();
        	
        	noCreateMasterTableEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12');
        	noCreateMasterTableSectionEl = createNoRadioField();
        	formGroupDivEl = commonFc.createDivEl('form-group');
        	
			$(yesCreateMasterTableEl).append(yesCreateMasterTableSectionEl);
        	$(masterTableRadioRowEl).append(yesCreateMasterTableEl);
        	
        	$(noCreateMasterTableEl).append(noCreateMasterTableSectionEl);
        	$(masterTableRadioRowEl).append(noCreateMasterTableEl);
        	
			$(formGroupDivEl).append(fieldSettingMasterTableLabelEl);
			$(formGroupDivEl).append(masterTableRadioRowEl);
			
			return formGroupDivEl;
        };
        
        createYesRadioField = function(){
        	var colYesRadioEl;
        	colYesRadioEl = commonFc.createInputRadioEl('form-check-label', 'yes', 'form-check-input df-radio-field', 'yes', 'createMasterTable', Yes, 'yes');
        	return colYesRadioEl;
        };
        
        createNoRadioField = function(){
        	var colNoRadioEl;
        	colNoRadioEl = commonFc.createInputRadioEl('form-check-label', 'no', 'form-check-input df-radio-field', 'no', 'createMasterTable', No, 'no');
        	return colNoRadioEl;
        };
        
		createFieldSettingPostData = function(){
			var fieldSettingPostDataLabelEl, requiredEl, fieldSettingPostDataInputEl, formGroupDivEl;
			fieldSettingPostDataLabelEl = commonFc.createLabel('postDataName', postDataFieldName, 'post-data-field-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			fieldSettingPostDataInputEl = commonFc.createInputTextEl('form-control post-data-field-input-el', 'postDataName');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(fieldSettingPostDataLabelEl).append(requiredEl);
			$(formGroupDivEl).append(fieldSettingPostDataLabelEl);
			$(formGroupDivEl).append(fieldSettingPostDataInputEl);
			
			return formGroupDivEl;
		};
		
		createFieldSettingPopulateData = function(){
			var fieldSettingPopulateDataLabelEl, requiredEl, fieldSettingPopulateDataInputEl, formGroupDivEl;
			fieldSettingPopulateDataLabelEl = commonFc.createLabel('populateDataName', prepopulateDataFieldName, 'populate-data-field-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			fieldSettingPopulateDataInputEl = commonFc.createInputTextEl('form-control populate-data-field-input-el', 'populateDataName');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(fieldSettingPopulateDataLabelEl).append(requiredEl);
			$(formGroupDivEl).append(fieldSettingPopulateDataLabelEl);
			$(formGroupDivEl).append(fieldSettingPopulateDataInputEl);
			
			return formGroupDivEl;
		};
		
		createFieldSettingReadFromReq = function(){
			var fieldSettingReadFromReqLabelEl, requiredEl, fieldSettingReadFromReqInputEl, formGroupDivEl;
			fieldSettingReadFromReqLabelEl = commonFc.createLabel('readFromReqParamName', readFromReqParamName, 'read-from-req-param-name-label field-setting-label');
			requiredEl = commonFc.createEm('*');
			fieldSettingReadFromReqInputEl = commonFc.createInputTextEl('form-control read-from-req-param-name-input-el', 'readFromReqParamName');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(fieldSettingReadFromReqLabelEl).append(requiredEl);
			$(formGroupDivEl).append(fieldSettingReadFromReqLabelEl);
			$(formGroupDivEl).append(fieldSettingReadFromReqInputEl);
			
			return formGroupDivEl;
		};
		
		createStaticValuesJSGrid = function(){
			var dropdownStaticFieldLabelEl, dropdownStaticFieldJSGridEl, formGroupDivEl, dropdownFieldValues;
			dropdownStaticFieldLabelEl = commonFc.createLabel('staticValuesInputTag', staticValues, 'static-values-input-tag-label field-setting-label');
			dropdownStaticFieldJSGridEl = commonFc.createDivEl('static-values-input-tag-el contenteditable d-block', 'displayDropdownStaticJSGrid');
			formGroupDivEl = commonFc.createDivEl('form-group');
			dropdownFieldValues = getLanguageFieldsJSGridArr();
			$(formGroupDivEl).append(dropdownStaticFieldLabelEl);
			$(formGroupDivEl).append(dropdownStaticFieldJSGridEl);
			commonFc.initJsGrid(dropdownStaticFieldJSGridEl, dropdownFieldValues, isJSGrid);
			return formGroupDivEl;
		};
		
		createDependentFieldsName = function() {
            var dependentFieldsNameLabelEl, dependentFieldsNameDropdownEl, formGroupDivEl, changeEventObj = new Object({});
            var dfClass = '.dependent-fields';
            changeEventObj.fnName = 'removeRow("'+dfClass+'");';
			dependentFieldsNameLabelEl = commonFc.createLabel('dependentFieldsName', dependentFieldsName, 'dependent-fields-name-label field-setting-label');
            dependentFieldsNameDropdownEl = commonFc.createDropdown('form-control dependent-fields-name-dropdown-el', 'dependentFieldsName', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(dependentFieldsNameLabelEl);
			$(formGroupDivEl).append(dependentFieldsNameDropdownEl);
			
			return formGroupDivEl;
		};
		
		createMasterTableDropdown = function(){
			var masterTableLabelEl, masterTableDropdownEl, formGroupDivEl, changeEventObj = new Object({});
            changeEventObj.fnName = 'fetchColumnNames(this);';
            masterTableLabelEl = commonFc.createLabel('masterTable', masterTable, 'master-table-label field-setting-label');
            masterTableDropdownEl = commonFc.createDropdown('form-control master-table-dropdown-el', 'masterTable', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(masterTableLabelEl);
			$(formGroupDivEl).append(masterTableDropdownEl);
			
			return formGroupDivEl;
		}
		
		createMasterTableColumnDropdown = function(){
			var masterTableColumnLabelEl, masterTableColumnDropdownEl, formGroupDivEl, changeEventObj = new Object({});
            changeEventObj.fnName = 'removeRow(this);';
            masterTableColumnLabelEl = commonFc.createLabel('masterTableColumn', masterTableColumn, 'master-table-column-label field-setting-label');
            masterTableColumnDropdownEl = commonFc.createDropdown('form-control master-table-column-dropdown-el', 'masterTableColumn', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(masterTableColumnLabelEl);
			$(formGroupDivEl).append(masterTableColumnDropdownEl);
			
			return formGroupDivEl;
		}
		
		createMasterTableTextColumnDropdown = function(){
			var masterTableTextColumnLabelEl, masterTableTextColumnDropdownEl, formGroupDivEl;
            masterTableTextColumnLabelEl = commonFc.createLabel('masterTableTextColumn', masterTableTextColumn, 'master-table-text-column-label field-setting-label');
            masterTableTextColumnDropdownEl = commonFc.createDropdown('form-control master-table-text-column-dropdown-el', 'masterTableTextColumn');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(masterTableTextColumnLabelEl);
			$(formGroupDivEl).append(masterTableTextColumnDropdownEl);
			
			return formGroupDivEl;
		}
		
		createMasterTableValueColumnDropdown = function(){
			var masterTableValueColumnLabelEl, masterTableValueColumnDropdownEl, formGroupDivEl;
            masterTableValueColumnLabelEl = commonFc.createLabel('masterTableValueColumn', masterTableValueColumn, 'master-table-value-column-label field-setting-label');
            masterTableValueColumnDropdownEl = commonFc.createDropdown('form-control master-table-value-column-dropdown-el', 'masterTableValueColumn');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(masterTableValueColumnLabelEl);
			$(formGroupDivEl).append(masterTableValueColumnDropdownEl);
			
			return formGroupDivEl;
		}
		
		createWhereToPopulateDependentFields = function(){
			var whereToPopulateDependentFieldsLabelEl, whereToPopulateDependentFieldsDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			whereToPopulateDependentFieldsLabelEl = commonFc.createLabel('whereToPopulateDependentFields', populateValues, 'where-to-populate-dependent-fields-label field-setting-label');
			changeEventObj.fnName = 'whereToPopulateDependentFields(this);';
			whereToPopulateDependentFieldsDropdownEl = commonFc.createDropdown('form-control where-to-populate-dependent-fields-el', 'whereToPopulateDependentFields', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(whereToPopulateDependentFieldsLabelEl);
			$(formGroupDivEl).append(whereToPopulateDependentFieldsDropdownEl);
			commonFc.populateDropdown(whereToPopulateDF, whereToPopulateDependentFieldsDropdownEl);
			return formGroupDivEl;
		};
		
		createDFFieldValue = function(){
			var dfFieldValueLabel , dfFieldValueInputEl, formGroupDivEl, isReadOnly = true;
			dfFieldValueLabel = commonFc.createLabel('dfFieldValue', fieldValue, 'df-field-value field-setting-label');
			dfFieldValueInputEl = commonFc.createInputTextEl('form-control df-field-value-input-el', 'dfFieldValue', isReadOnly);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(dfFieldValueLabel);
			$(formGroupDivEl).append(dfFieldValueInputEl);
			
			return formGroupDivEl;
		};
		
		createDFDisplayValues = function(){
			var dfDisplayValuesLabel, dfDisplayValuesInputTag, formGroupDivEl;
			dfDisplayValuesLabel = commonFc.createLabel('dfDisplayValues', displayValues, 'df-display-values-label field-setting-label');
			dfDisplayValuesInputTag = commonFc.createDivEl('df-display-values-input-tag contenteditable d-block', 'dfDisplayValues');
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dfDisplayValuesLabel);
			$(formGroupDivEl).append(dfDisplayValuesInputTag);
			return formGroupDivEl;
		};
		
		createFieldSettingSubSection4 = function() {
			var mainSettingRow4El; 
			
			mainSettingRow4El = commonFc.createDivEl('row', 'dfDataProviderRow');
			
			return mainSettingRow4El;
		};
		
		createDataProviderURL = function(){
			var dataProviderURLLabelEl, dataProviderURLInputEl, formGroupDivEl;
			dataProviderURLLabelEl = commonFc.createLabel('dataProviderURL', url, 'data-provider-url-label field-setting-label');
			dataProviderURLInputEl = commonFc.createInputTextEl('form-control data-provider-url-el', 'dataProviderURL');
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dataProviderURLLabelEl);
			$(formGroupDivEl).append(dataProviderURLInputEl);
			return formGroupDivEl;
		};
		
		createDataProviderURLProperty = function(){
			var dataProviderURLPropertyLabelEl, dataProviderURLPropertyInputEl, formGroupDivEl;
			dataProviderURLPropertyLabelEl = commonFc.createLabel('dataProviderURLProperty', property, 'data-provider-url-property-label field-setting-label');
			dataProviderURLPropertyInputEl = commonFc.createInputTextEl('form-control data-provider-url-property-el', 'dataProviderURLProperty');
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dataProviderURLPropertyLabelEl);
			$(formGroupDivEl).append(dataProviderURLPropertyInputEl);
			return formGroupDivEl;
		};
		
		createMethodTypes = function(){
			var methodTypesLabelEl, methodTypesDropdownEl, formGroupDivEl, changeEventObj = new Object({});
			methodTypesLabelEl = commonFc.createLabel('methodTypes', methodTypes, 'method-types-label field-setting-label');
			changeEventObj.fnName = 'populateContentTypes(this);';
			methodTypesDropdownEl = commonFc.createDropdown('form-control method-types-dropdown-el', 'methodTypes', changeEventObj);
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(methodTypesLabelEl);
			$(formGroupDivEl).append(methodTypesDropdownEl);
			commonFc.populateDropdown(methodTypesArr, methodTypesDropdownEl);
			return formGroupDivEl;
		};
		
		createContentType = function(){
			var contentTypesLabelEl, contentTypesDropdownEl, formGroupDivEl
			contentTypesLabelEl = commonFc.createLabel('contentTypes', contentTypes, 'content-types-label field-setting-label');
			contentTypesDropdownEl = commonFc.createDropdown('form-control content-types-dropdown-el', 'contentTypes');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(contentTypesLabelEl);
			$(formGroupDivEl).append(contentTypesDropdownEl);
			return formGroupDivEl;
		};
		
		createDataProps = function(){
			var dataPropsInputTagLabel, dataPropsInputTag, formGroupDivEl;
			dataPropsInputTagLabel = commonFc.createLabel('dataProps', dataProps, 'data-props-label field-setting-label');
			dataPropsInputTag = commonFc.createDivEl('data-props-el contenteditable d-block', 'dataProps');
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(dataPropsInputTagLabel);
			$(formGroupDivEl).append(dataPropsInputTag);
			return formGroupDivEl;
		};
		
		createSourceProps = function(){
			var sourcePropsInputTagLabel, sourcePropsInputTag, formGroupDivEl;
			sourcePropsInputTagLabel = commonFc.createLabel('sourceProps', sourceProps, 'source-props-label field-setting-label');
			sourcePropsInputTag = commonFc.createDivEl('source-props-el contenteditable d-block', 'sourceProps');
			formGroupDivEl = commonFc.createDivEl('form-group');
			$(formGroupDivEl).append(sourcePropsInputTagLabel);
			$(formGroupDivEl).append(sourcePropsInputTag);
			return formGroupDivEl;
		};
		
		createDataProviderAccept = function(){
			var dataProviderAcceptLabelEl, dataProviderAcceptDropdownEl, formGroupDivEl;
			dataProviderAcceptLabelEl = commonFc.createLabel('dataProviderAccept', accept);
			dataProviderAcceptDropdownEl = commonFc.createDropdown('form-control', 'dataProviderAccept');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(dataProviderAcceptLabelEl);
			$(formGroupDivEl).append(dataProviderAcceptDropdownEl);
			commonFc.populateDropdown(acceptArr, dataProviderAcceptDropdownEl);
			
			return formGroupDivEl;
		};
		
		createDataProviderHeaders = function(){
			var dataProviderHeadersLabelEl, dataProviderHeadersJSGridEl, formGroupDivEl, dataProviderHeaders;
			dataProviderHeadersLabelEl = commonFc.createLabel('dataProviderHeaders', headers);
			dataProviderHeadersJSGridEl = commonFc.createDivEl('post-data-headers-div-el', 'dataProviderHeaders');
			formGroupDivEl = commonFc.createDivEl('form-group');
			dataProviderHeaders = getKeyValueFieldsArr();
			$(formGroupDivEl).append(dataProviderHeadersLabelEl);
			$(formGroupDivEl).append(dataProviderHeadersJSGridEl);
			commonFc.initJsGrid(dataProviderHeadersJSGridEl, dataProviderHeaders, isJSGrid);
			return formGroupDivEl;
		};
		
		createDataProviderParams = function(){
			var dataProviderParamsLabelEl, dataProviderParamsJSGridEl, formGroupDivEl, dataProviderParams;
			dataProviderParamsLabelEl = commonFc.createLabel('dataProviderParams', params);
			dataProviderParamsJSGridEl = commonFc.createDivEl('post-data-params-div-el', 'dataProviderParams');
			formGroupDivEl = commonFc.createDivEl('form-group');
			dataProviderParams = getKeyValueFieldsArr();
			$(formGroupDivEl).append(dataProviderParamsLabelEl);
			$(formGroupDivEl).append(dataProviderParamsJSGridEl);
			commonFc.initJsGrid(dataProviderParamsJSGridEl, dataProviderParams, isJSGrid);
			return formGroupDivEl;
		};
		
		createDataProviderFieldSettingSection = function(){
			var dataProviderRowEl , dataProviderColEl, dataProviderRow1El, dataProviderURLColEl, dataProviderURLEl, methodTypesColEl, methodTypesEl, contentTypesColEl,
			contentTypesEl, dataProviderURLPropertyColEl, dataProviderURLPropertyEl, dataProviderRow2El, dataPropsColEl, dataPropsEl, sourcePropsColEl, sourcePropsEl,
			dataProviderAcceptColEl, dataProviderAcceptEl, dataProviderRow3El, dataProviderHeadersColEl, dataProviderHeadersEl, dataProviderParamsColEl, 
			dataProviderParamsEl;
			
			dataProviderRowEl = commonFc.createDivEl('row data-provider-row dependent-fields hide', 'dataProviderRow');
			dataProviderColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			
			dataProviderRow1El = commonFc.createDivEl('row');
			dataProviderURLColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 data-provider-url-div-el', 'displayDataProviderURL');
			dataProviderURLEl = createDataProviderURL();
			
			methodTypesColEl =  commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 method-types-div-el', 'displayMethodTypes');
			methodTypesEl = createMethodTypes();
			
			contentTypesColEl =  commonFc.createDivEl('col-lg-2 col-md-2 col-sm-12 col-xs-12 d-none content-types-div-el', 'displayContentTypes');
			contentTypesEl = createContentType();
			
			dataProviderURLPropertyColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 data-provider-url-property-div-el', 'displayDataProviderURLProperty');
			dataProviderURLPropertyEl = createDataProviderURLProperty();
			
			dataProviderRow2El = commonFc.createDivEl('row');
			dataPropsColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 data-props-div-el', 'displayDataProps');
			dataPropsEl = createDataProps();
			
			sourcePropsColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 source-props-div-el d-none', 'displaySourceProps');
			sourcePropsEl = createSourceProps();
			
			dataProviderAcceptColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12 data-provider-accept-div-el', 'displayDataProviderAccept');
			dataProviderAcceptEl = createDataProviderAccept();
			
			dataProviderRow3El = commonFc.createDivEl('row');
			dataProviderHeadersColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 data-provider-headers-div-el', 'displayDataProviderHeaders');
			dataProviderHeadersEl = createDataProviderHeaders();
			
			dataProviderParamsColEl = commonFc.createDivEl('col-lg-6 col-md-6 col-sm-12 col-xs-12 data-provider-params-div-el', 'displayDataProviderParams');
			dataProviderParamsEl = createDataProviderParams();
			
			$(dataProviderURLColEl).append(dataProviderURLEl);
			$(dataProviderRow1El).append(dataProviderURLColEl);
			
			$(methodTypesColEl).append(methodTypesEl);
			$(dataProviderRow1El).append(methodTypesColEl);
			
			$(contentTypesColEl).append(contentTypesEl);
			$(dataProviderRow1El).append(contentTypesColEl);
			
			$(dataProviderURLPropertyColEl).append(dataProviderURLPropertyEl);
			$(dataProviderRow1El).append(dataProviderURLPropertyColEl);
			$(dataProviderColEl).append(dataProviderRow1El);
			
			$(dataPropsColEl).append(dataPropsEl);
			$(dataProviderRow2El).append(dataPropsColEl);
			
			$(sourcePropsColEl).append(sourcePropsEl);
			$(dataProviderRow2El).append(sourcePropsColEl);
			
			$(dataProviderAcceptColEl).append(dataProviderAcceptEl);
			$(dataProviderRow2El).append(dataProviderAcceptColEl);
			$(dataProviderColEl).append(dataProviderRow2El);
			
			$(dataProviderHeadersColEl).append(dataProviderHeadersEl);
			$(dataProviderRow3El).append(dataProviderHeadersColEl);
			
			$(dataProviderParamsColEl).append(dataProviderParamsEl);
			$(dataProviderRow3El).append(dataProviderParamsColEl);
			$(dataProviderColEl).append(dataProviderRow3El);
			
			$(dataProviderRowEl).append(dataProviderColEl);
			return dataProviderRowEl;
		};
		
		createStaticValuesFieldSettingSection = function(appendTo){
			var staticValuesRowEl, staticValuesJSGridColEl, staticValuesJSGridEl;
			
			staticValuesRowEl = commonFc.createDivEl('row static-values-row hide', 'staticValuesRow');
			
			staticValuesJSGridColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 static-values-input-tag-div-el', 'displayStaticValuesInputTag');
			staticValuesJSGridEl = createStaticValuesJSGrid();
			
			$(staticValuesJSGridColEl).append(staticValuesJSGridEl);
			$(staticValuesRowEl).append(staticValuesJSGridColEl);
			
			return staticValuesRowEl;
		};
		
		createDFStaticValuesSection = function(index, selectedDropdownValues){
			var dfStaticValuesRowEl, dfStaticValuesInputTagColEl, dfStaticValuesInputTagEl;
			
			dfStaticValuesRowEl = commonFc.createDivEl('row static-values-row static-custom-input dependent-fields', 'dfStaticValuesRow_' + index);
			
			dfStaticValuesInputTagColEl = commonFc.createDivEl('col-lg-4 col-md-4 col-sm-12 col-xs-12 static-values-input-tag-div-el', 'displayDFStaticValuesJSGrid_'+index);
			dfStaticValuesInputTagEl = createDFStaticValuesJSGrid(index);
			
			dfStaticValuesInputTextColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 static-values-input-tag-div-el', 'displayStaticValuesInputText_'+index);
			dfStaticValuesInputTextEl = createDFStaticValuesInputText(index, selectedDropdownValues);
			
			$(dfStaticValuesInputTextColEl).append(dfStaticValuesInputTextEl);
			$(dfStaticValuesRowEl).append(dfStaticValuesInputTextColEl);
			
			$(dfStaticValuesInputTagColEl).append(dfStaticValuesInputTagEl);
			$(dfStaticValuesRowEl).append(dfStaticValuesInputTagColEl);
			
			return dfStaticValuesRowEl;
		};
		
		createDependentFieldSettingSection = function(appendTo){
			var dependentFieldsRowEl, dependentFieldsNameDropdownColEl, dependentFieldsNameDropdownEl, whereToPopulateDependentFieldsColEl, whereToPopulateDependentFieldsEl;
			
			dependentFieldsRowEl = commonFc.createDivEl('row dependent-fields-row hide', 'dependentFieldsRow');
			
			dependentFieldsNameDropdownColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 dependent-fields-name-dropdown-div-el', 'displayDependentFieldsNameDropdown');
			dependentFieldsNameDropdownEl = createDependentFieldsName();
			
			whereToPopulateDependentFieldsColEl = commonFc.createDivEl('col-lg-3 col-md-4 col-sm-12 col-xs-12 where-to-populate-dependent-fields-div-el', 'displayWhereToPopulateDependentFields');
			whereToPopulateDependentFieldsEl = createWhereToPopulateDependentFields();
			
			$(dependentFieldsNameDropdownColEl).append(dependentFieldsNameDropdownEl);
			$(dependentFieldsRowEl).append(dependentFieldsNameDropdownColEl);
			
			$(whereToPopulateDependentFieldsColEl).append(whereToPopulateDependentFieldsEl);
			$(dependentFieldsRowEl).append(whereToPopulateDependentFieldsColEl);
			
			return dependentFieldsRowEl;
		};
		
		createMasterTableSettingSection = function(){
            var masterTableRow6El, masterTableColEl, masterTableEl, masterTableTextColumnColEl, masterTableColumnEl;
            
            masterTableRow6El = commonFc.createDivEl('row master-table-row hide', 'masterTableRow');
            
            masterTableColEl = commonFc.createDivEl('col-lg-4 col-md-2 col-sm-12 col-xs-12 master-table-dropdown-div-el', 'masterTableDropdown');
            masterTableEl = createMasterTableDropdown();
            
            masterTableTextColumnColEl = commonFc.createDivEl('col-lg-4 col-md-2 col-sm-12 col-xs-12 master-table-dropdown-div-el', 'masterTableTextColumnDropdown');
            masterTableTextColumnEl = createMasterTableTextColumnDropdown();
            
            masterTableValueColumnColEl = commonFc.createDivEl('col-lg-4 col-md-2 col-sm-12 col-xs-12 master-table-dropdown-div-el', 'masterTableValueColumnDropdown');
            masterTableValueColumnEl = createMasterTableValueColumnDropdown();
            
            $(masterTableColEl).append(masterTableEl);
            $(masterTableRow6El).append(masterTableColEl);
            
            $(masterTableTextColumnColEl).append(masterTableTextColumnEl);
            $(masterTableRow6El).append(masterTableTextColumnColEl);
            
            $(masterTableValueColumnColEl).append(masterTableValueColumnEl);
            $(masterTableRow6El).append(masterTableValueColumnColEl);
            
			return masterTableRow6El;
		};
		
		createFieldSettingSubSection3 = function(){
            var mainSettingRow3El, visibleOnDropdownValuesColEl, visibleOnDropdownValuesEl, groupDropdownColEl, groupDropdownEl;
            
            mainSettingRow3El = commonFc.createDivEl('row');
            
            fieldSettingGroupColEl = commonFc.createDivEl('col-lg-4 col-md-2 col-sm-12 col-xs-12 group-div-el d-none', 'displayGroup');
			fieldSettingGroupEl = createFieldSettingGroup();
			
            visibleOnDropdownValuesColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none visible-on-dropdown-div-el', 'displayVisibleOn');
            visibleOnDropdownValuesEl = createVisibleOnDropdownValues();
            
            visibleOnSelectedDropdownValuesColEl = commonFc.createDivEl('col-lg-2 col-md-4 col-sm-12 col-xs-12 d-none visible-on-dropdown-selected-div-el', 'displayVisibleOnSelectedDropdown');
            visibleOnSelectedDropdownValuesEl = createVisibleOnInput();
            
            $(fieldSettingGroupColEl).append(fieldSettingGroupEl);
			$(mainSettingRow3El).append(fieldSettingGroupColEl);
			
            $(visibleOnDropdownValuesColEl).append(visibleOnDropdownValuesEl);
            $(mainSettingRow3El).append(visibleOnDropdownValuesColEl);
            
            $(visibleOnSelectedDropdownValuesColEl).append(visibleOnSelectedDropdownValuesEl);
            $(mainSettingRow3El).append(visibleOnSelectedDropdownValuesColEl);
			
			return  mainSettingRow3El;
		};
		
		createFieldSettingSubSection5 = function(){
            var mainSettingRow5El, groupDropdownColEl, groupDropdownEl;
            mainSettingRow5El = commonFc.createDivEl('row');
            var fieldSettingJSGridColEl = commonFc.createDivEl('col-lg-8 col-md-2 col-sm-12 col-xs-12 group-div-el', 'jsGridValidation');
			$(mainSettingRow5El).append(fieldSettingJSGridColEl);
			return  mainSettingRow5El;
		};
		
		createGroupJSGrid = function(data){
			$(groupJSGridJEl).jsGrid({
		        width: "100%",
		        inserting: true,
		        editing: true,
		        sorting: true,
		        paging: true,
		        invalidNotify: false,
		        height: "auto",
		        fields: [
			        {
			        	name: "en_US", 
			        	title: "en_US",
			        	width: 65,
			        	type: "text",
			        	validate: {
		        			validator: "required",
		                    message: function(value, item) {
		                    	if(!value){
		        		        	displayCustomError("Please Enter English Value.");
		        	                return false;
		        		        }
		                    	return true;
		                    }
			        	}
			        },
			        { 
			        	name: "ar_SA", 
			        	title:"ar_SA",
			        	type: "text", 
			        	width: 65
			        },
			        {
			        	name: "description_en_US", 
			        	title: "Description (en_US)",
			        	width: 65,
			        	type: "text"
			        },
			        { 
			        	name: "description_ar_SA", 
			        	title:"Description (ar_SA)",
			        	type: "text", 
			        	width: 65
			        },
			        { 
			            type: "control",
			            editButton: true, 
			            width: 5,
			            modeSwitchButton: false 
			        }
		        ]
		    });	
			isJSGrid = true;
			$(".jsgrid-grid-body").removeAttr("style");
		}
		
		createJSGrid = function(data){
			if(isValidationJSGrid){
				$(jsGridValidationJEl).jsGrid("destroy");
			}
			
			$(jsGridValidationJEl).jsGrid({
		        width: "100%",
		        inserting: true,
		        editing: true,
		        sorting: true,
		        paging: true,
		        height: "auto",
		        invalidNotify: false,
		        fields: [
		            {
		            	name: "type",
		            	title: "Validations",
		            	type: "select", 
		            	items: data, 
		            	valueField: "id",
		            	width: 30,
		            	textField: "name",
			            align: "left",
			            visible: true
			        },
			        {
			        	name: "param", 
			        	title: "Parameter",
			        	width: 30,
			        	type: "text"
			        },
			        { 
			        	name: "en_US", 
			        	title:"Message(en_US)",
			        	type: "text", 
			        	width: 30,
			        	validate: {
		        			validator: "required",
		                    message: function(value, item) {
		                    	if(!value){
		        		        	displayCustomError("Please Enter English Value.");
		        	                return false;
		        		        }
		                    	return true;
		                    }
			        	}
			        },
			        { 
			        	name: "ar_SA", 
			        	title:"Message(ar_SA)",
			        	type: "text", 
			        	width: 30
			        },
			        { 
			            type: "control",
			            editButton: false, 
			            width: 5,
			            modeSwitchButton: false 
			        }
		        ]
		    });	
			isValidationJSGrid = true;
			$(".jsgrid-grid-body").removeAttr("style");
		};
		
		getExtraValidationJson = function(){
			var jsValidationsDataArray; 
			var validationsJson = {};
			if(isValidationJSGrid){
				jsValidationsDataArray = $(jsGridValidationJEl).jsGrid('option','data');
				console.log('jsValidationsDataArray >>> ',jsValidationsDataArray);
				var validations = [];

				$.each(jsValidationsDataArray, function(index, obj) {
					  var type = obj.type;
					  var param = obj.param;
					  var message = {
					    "en_US": obj.en_US,
					    "ar_SA": obj.ar_SA
					  };

					  var validation = {
					    "type": type,
					    "message": message,
					    "param": param
					  };

					  validations.push(validation);
					});
				console.log('validations >>> ',validations);

				if(jsValidationsDataArray.length > 0){
					validationsJson.isValidationExists = true;
					validationsJson.validations = validations; 
				} else {
					validationsJson.isValidationExists = false;
				}
			} else {
				validationsJson.isValidationExists = false;
			}
			console.log(validationsJson);
			return validationsJson;
		};
		
		createFieldSettingGroup = function(){
			var fieldSettingGroupLabelEl, fieldSettingGroupDropdownEl, formGroupDivEl;
			fieldSettingGroupLabelEl = commonFc.createLabel('group', group, 'group-label');
			fieldSettingGroupDropdownEl = commonFc.createDropdown('form-control group-dropdown-el', 'group');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(formGroupDivEl).append(fieldSettingGroupLabelEl);
			$(formGroupDivEl).append(fieldSettingGroupDropdownEl);
			
			return formGroupDivEl;
		};
		
		
		
		submitDFForm = function(el){
			$(dfConfigurationFormJEl).submit();
		};
		
		resetDFForm = function(el){
			
		};
		
		getTableNames = function(){
			var formDefinitionId = $(formDefinitionIdJEl).val();
			var tableNameDropdownArray = [];
			$.ajax({
				url: getFormDataResourceURL,
				method : 'POST',
				data: {
					[namespace + 'formDefinitionId']: formDefinitionId
				},
				success:function(result){
					var resultObj;
					if(result){
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							var tableNames = resultObj.tableNames;
							for (var i = 0; i < tableNames.length; i++) {
					          var tableName = tableNames[i];
					          var tableObj = {
					        	  "value" : tableName,
					        	  "label" : tableName
					          };
					          tableNameDropdownArray.push(tableObj);
					        }
							$.each(tableNameDropdownArray, function(index, item) {
						      console.log('in loop');
						        var option = $("<option>");
						        $(option).text(item.label);
						        $(option).val(item.value);
						        $(fieldMasterTableJEl).append(option);
						    });
						}else{
							console.log('Error while loading form configuration:');
						}
					}
				}
			});
		};
		
		initFormData = function(){
			$(dfLoaderContainerJEl).show();
			var formDefinitionId = $(formDefinitionIdJEl).val();
			$.ajax({
				url: getFormDataResourceURL,
				method : 'POST',
				data: {
					[namespace + 'formDefinitionId']: formDefinitionId
				},
				success:function(result){
					var resultObj;
					console.log('Result', result);
					if(result){
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							dtData = JSON.parse(resultObj.data);
							console.log('dtData:', dtData);
							initBasicDataTable();
							if(resultObj.formConfig){
								formBuilderConfigJsonObj = JSON.parse(resultObj.formConfig);
							}else{
								formBuilderConfigJsonObj = new Object({});
							}
							toggleFormFieldAndSubmitBtn();
							if(resultObj.columnNames){
								$(columnNamesDataJEl).val(resultObj.columnNames);
							}
							setBasicFormDataFields(resultObj.formNames);
							console.log('formBuilderConfigJsonObj:', formBuilderConfigJsonObj);
						}else{
							console.log('Error while loading form configuration:');
						}
					}
					$(dfLoaderContainerJEl).hide();
				}
			});
		};
		checkBoxVisibleOn = function(){
			var formDefinitionId = $(formDefinitionIdJEl).val();
			if(formDefinitionId==0 && !formBuilderConfigJsonObj.name){
				console.log('form basic section err mssg');
            	$(formFieldErrJEl).removeClass('d-none');
                $(formFieldErrJEl).addClass('d-block');
                $(formFieldErrorAlertJEl).html("<strong> Error : </strong>"+enterFormBasicConfiguration);
                $(fieldVisibleOnJEl).attr("disabled", true);
            } else {
                $(formFieldErrJEl).removeClass('d-block');
                $(formFieldErrJEl).addClass('d-none');
                if(formBuilderConfigJsonObj.name){
                    if (formBuilderConfigJsonObj.fields && formBuilderConfigJsonObj.fields.length == 0) {
                    	$(fieldVisibleOnJEl).attr("disabled", true);
                    } else {
                    	populateVisibleOn();
                    }
                }
            }
		};
		
		populateVisibleOn = function(){
			var visibleOnDropdownArray = [];
			for (var i = 0; i < formBuilderConfigJsonObj.fields.length; i++){
                var obj = formBuilderConfigJsonObj.fields[i];
                console.log('obj :: ', obj);
                var type = obj.settings.type;
                console.log('type :: ', type);
                if(type == 'radio' || type == 'dropdown' || type == 'checkbox'){
                	visibleOnDropdownArray.push({ 
	                    "label" : obj.label.en_US,
	                    "value"  : obj.key
	                });
                }
            }
			console.log('visibleOnDropdownArray :: ', visibleOnDropdownArray);
            if(visibleOnDropdownArray.length == 0){
            	$(fieldVisibleOnJEl).attr("disabled", true);
            } else {
            	$(fieldVisibleOnJEl).removeAttr("disabled");
            }
            commonFc.populateDropdown(visibleOnDropdownArray, fieldVisibleOnDropdownJEl);
		};
		
		toggleDataSetting = function(){
			if(formBuilderConfigJsonObj.postData && formBuilderConfigJsonObj.postData.enabled == true){
				$(displayPostDataJEl).removeClass('d-none');
				$(displayPostDataJEl).addClass('d-block');
			}
			
			if(formBuilderConfigJsonObj.populateData && formBuilderConfigJsonObj.populateData.enabled == true){
				$(displayPopulateDataJEl).removeClass('d-none');
				$(displayPopulateDataJEl).addClass('d-block');
			}
			
			if(formBuilderConfigJsonObj.readFromRequestParam && formBuilderConfigJsonObj.readFromRequestParam.enabled == true){
				$(displayReadFromReqParamJEl).removeClass('d-none');
				$(displayReadFromReqParamJEl).addClass('d-block');
			}
			
			if(formBuilderConfigJsonObj.isMasterForm && formBuilderConfigJsonObj.isMasterForm == false){
				console.log('formBuilderConfigJsonObj >>> ',formBuilderConfigJsonObj);
				$(fieldWhereToPopulateDropdownJEl).find("option[value=masterTable]").prop("disabled", true);
				$(fieldWhereToPopulateDropdownJEl).find("option[value=masterTable]").prop("disabled", true);
			} else {
				$(fieldWhereToPopulateDropdownJEl).find("option[value=masterTable]").prop("disabled", false);
				$(fieldWhereToPopulateDropdownJEl).find("option[value=masterTable]").prop("disabled", false);
			}
		};
		
		populateGroups = function(){
			if(formBuilderConfigJsonObj.name){
                var groupsArr = formBuilderConfigJsonObj.groups;
               // var groupLength = groupsArr.length;
                if(groupsArr.length > 0){
                	var groupDropdownArr = [];
                	/*for (var i = 0; i < groupLength; i++){
                		var obj = groupsArr[i].labels;
                		groupDropdownArr.push({ 
                			"label" : obj.en_US,
    	                    "value" : obj.en_US
    	                });
                	}*/
                	$.each(groupsArr,function( key, value ){
                		groupDropdownArr.push({ 
                			"label" : value.labels.en_US,
    	                    "value" : value.id
    	                });
            		});
                    commonFc.populateDropdown(groupDropdownArr, groupJEl); 
                }
			}
		};
		
		initEvent = function() {
			$(formBasicSectionBtnJEl).click(function() {
				var formName = $(formNameJEl).val();
				if(formName.length == 0){
					$(formBasicSectionResetBtnJEl).show();
				} else{
					$(formBasicSectionResetBtnJEl).hide();
				}
				$(formBasicSectionModalJEl).modal('show');
				
				var htmlText = getEN_USLocaleHtmlText();
				$(formTitleSelectedLocaleJEl).html(htmlText);
				$(formTitleSelectedLocaleJEl).attr('language-id', 'en_US');
				$(formTitleJEl).val($(formEnUsTitleJEl).val());

				$(formDescriptionSelectedLocaleJEl).html(htmlText);
				$(formDescriptionSelectedLocaleJEl).attr('language-id', 'en_US');
				$(formDescriptionJEl).summernote('code', $(formEnUsDescriptionJEl).val());
            });
			
			$(formBasicSectionModalJEl).on('shown.bs.modal', function (e) {
				validateFormBasicSection();
				getIsPostDataChecked();
				getIsPrepopulateDataChecked();
			});

			$(formFieldBtnJEl).click(function() {
				$(formFieldResetBtnJEl).show();
				$(formFieldJEl).empty();
				createFormFieldConfig();
				initFormFieldsValidation();
				toggleDataSetting();
				if(formBuilderConfigJsonObj.groups){
					if(formBuilderConfigJsonObj.groups.length > 0){
						$(displayGroupJEl).removeClass('d-none');
						$(displayGroupJEl).addClass('d-block');
						populateGroups();
					}
				}
				checkBoxVisibleOn();
				$(rangeTotalCharacterJEl).attr('disabled', true);
				$(formFieldModalJEl).modal('show');
            });
			
//			$(formFieldModalJEl).on('hidden.bs.modal', function (e) {
//				formBuilderConfigJsonObj = new Object({});
//			});
			
			$(formFieldModalJEl).on('shown.bs.modal', function (e) {
				validateFormField();
			});
			
			$(formPostAndPrepopulateFieldsDataBtnJEl).click(function() {
				$(formPostAndPrepopulateFieldsDataModalJEl).modal('show');
            });
			
			$('#editFormField').click(function(){
				console.log('Editing Field');
			});
		};
		
		initBasicDataTable = function() {
			var formDefinitionId = $(formDefinitionIdJEl).val();
			var orderTargetsDisabled = [5, 6, 7, 8];
			var centerAlignTargets = [0, 3, 4, 5, 6, 7, 8];
			formDataTable =  $(formDataTableJEl).DataTable({
				"destroy": true,
				"colReorder": true,
				"processing": true,
				"scrollX" : true,
				"searching": false,
				"rowReorder": {
					dataSrc: 'srNo'
				},
				"dom": '<"oveflow"rt><"bottom"ipl><"clear">',
				"aLengthMenu": [ [10, 20, 30, 50, 100], [10, 20, 30, 50, 100] ],
				"iDisplayLength" : 10,
				"bSort":true,
				'language': {
					 "processing": '',
					 "emptyTable": ''
			    },
			    "columnDefs": [{
	                orderable: false,
	                targets: orderTargetsDisabled
	            }, {
	                className: 'text-center',
	                targets: centerAlignTargets
	            }],
	            data: dtData,
			    "columns": [
			    	{
	                    "data": "srNo",
	                    "name": "srNo"
	                },
			    	{
	                    "data": "fieldLabel",
	                    "name": "fieldLabel"
	                },
			    	{
	                    "data": "fieldKey",
	                    "name": "fieldKey"
	                },
	                {
	                    "data": "fieldType",
	                    "name": "fieldType"
	                },
	                {
	                	"data": "fieldStatus",
	                	"name": "fieldStatus"
	                },
	                {
	                    "data": "fieldDisabled",
	                    "name": "fieldDisabled"
	                },
	                {
	                    "data": "fieldRequired",
	                    "name": "fieldRequired"
	                },
	                {
	                    "data": "fieldReadonly",
	                    "name": "fieldReadonly"
	                },
	                { 
			    		"data": "action", 
			    		"name": "action",
			    		"width": "160px",
			    		"render": function(data, type, row, meta){
			    			var fieldJSONObj = JSON.stringify(row.fieldJSONObj);
							var quoteReplacedFieldJSONObj = fieldJSONObj.replace(/'/g, "&#39;");
							console.debug("Field JSON Object :: " + fieldJSONObj);
							data = '<td>' +
				     					"<a class='ml-1 mr-3' data-senna-off='true' id='editFormField_"+row.srNo+"' href='javascript:void(0);' onclick='editModalPopup(this, "+quoteReplacedFieldJSONObj+");'><span><i class='fa fa-edit'></i></span></a>" +
				     					"<a class='ml-1 mr-3' id='deleteFormField_"+row.srNo+"' href='javascript:void(0);' onclick='deleteModalPopup(this, "+quoteReplacedFieldJSONObj+");'><span><i class='fa fa-trash'></i></span></a>" +
				     					"<a id='permissionFormField_"+row.srNo+"' href='javascript:void(0);' onclick='showPermissionModalPopup(this, "+quoteReplacedFieldJSONObj+");'><span><i class='fa fa-lock'></i></span></a>" +
				     			   '</td>';
							return data;
				        } 	
			    	}
		        ],
			});
			
			formDataTable.on( 'row-reorder', function ( e, diff, edit ) {
		        var result = 'Reorder started on row: '+edit.triggerRow.data()[1]+'<br>';
		 		console.log('e:', e);	
		        for (var i=0, ien=diff.length ; i<ien ; i++) {
		            var rowData = formDataTable.row( diff[i].node ).data();
		            result += rowData[1]+' updated to be in position '+ diff[i].newData+' (was '+diff[i].oldData+')<br>';
		        }
		 		$(formReorderSaveChangesBtnJEl).show();
		        console.log('Event result:<br>'+result );
		    });
			
        };
        getFieldRowObj = function(fieldObj){
        	var fieldRowObj = new Object({});
			fieldRowObj.srNo = fieldObj.srNo;
			fieldRowObj.fieldLabel = fieldObj.label.en_US;
			fieldRowObj.fieldKey = fieldObj.key;
			fieldRowObj.fieldType = fieldObj.settings.type;
			var statusLabel = fieldObj.settings.status && fieldObj.settings.status == 'active' ? Liferay.Language.get('active') : Liferay.Language.get('inactive');
			fieldRowObj.fieldStatus = statusLabel;
			var disabledLabel = fieldObj.settings.disabled ? Liferay.Language.get('yes') : Liferay.Language.get('no');
			fieldRowObj.fieldDisabled = disabledLabel;
			var requiredLabel = fieldObj.settings.required ? Liferay.Language.get('yes') : Liferay.Language.get('no');
			fieldRowObj.fieldRequired = requiredLabel;
			var readonlyLabel = fieldObj.settings.readonly ? Liferay.Language.get('yes') : Liferay.Language.get('no');
			fieldRowObj.fieldReadonly = readonlyLabel;
			fieldRowObj.fieldJSONObj = fieldObj;
			return fieldRowObj;
        };
		addRowInDataTable = function(fieldObj){
			var fieldRowObj = getFieldRowObj(fieldObj);
			console.log('fieldRowObj', fieldRowObj);
			if (!formDataTable) {
				initBasicDataTable();
            }
			$(formDataTableJEl).DataTable().row.add(fieldRowObj).draw();
		};
		updateRowInDataTable = function(fieldObj){
			var fieldRowObj = getFieldRowObj(fieldObj);
			console.log('fieldRowObj', fieldRowObj);
			$(formDataTableJEl).DataTable().row(editedRowEl).data(fieldRowObj).draw();
		};
		deleteRowInDataTable = function(){
			$(formDataTableJEl).DataTable().row(deletedRowEl).remove().draw();
		};
		addGroupObjInJSON = function(newGroupObj){
			formBuilderConfigJsonObj.groups.push(newGroupObj);
		    console.log('formBuilderConfigJsonObj.groups', formBuilderConfigJsonObj.groups);
		};
		addFieldObjInJSON = function(newFieldObj){
			formBuilderConfigJsonObj.fields.push(newFieldObj);
		    console.log('formBuilderConfigJsonObj.fields', formBuilderConfigJsonObj.fields);
		};
		updateFieldObjInJSON = function(newFieldObj){
			var isUpdated = false;
			for (var i in formBuilderConfigJsonObj.fields) {
		    	if (formBuilderConfigJsonObj.fields[i].key == newFieldObj.key) {
		        	formBuilderConfigJsonObj.fields[i] = newFieldObj;
		        	isUpdated = true;
		        	break;
		     	}
		    }
		    if(!isUpdated){
		    	addFieldObjInJSON(newFieldObj);
		    }
		    console.log('formBuilderConfigJsonObj.fields', formBuilderConfigJsonObj.fields);
		};
		function updatePermissionFieldObjInJSON(newFieldObj){
			var isUpdated = false;
			for (var i in formBuilderConfigJsonObj.fields) {
		    	if (formBuilderConfigJsonObj.fields[i].key == newFieldObj.key) {
		        	formBuilderConfigJsonObj.fields[i] = newFieldObj;
		        	isUpdated = true;
		        	break;
		     	}
		    }
		    console.log('formBuilderConfigJsonObj.fields', formBuilderConfigJsonObj.fields);
		    return newFieldObj;
		};
		deleteFieldObjInJSON = function(srNo){
			var deletedInd;
			for (var i in formBuilderConfigJsonObj.fields) {
		    	if (formBuilderConfigJsonObj.fields[i].srNo == srNo) {
		        	deletedInd = i;
		        	break;
		     	}
		    }
		    if(deletedInd > -1){
		    	formBuilderConfigJsonObj.fields.splice(deletedInd, 1);
		    }
		    console.log('formBuilderConfigJsonObj.fields', formBuilderConfigJsonObj.fields);
		};
		deleteModalPopup = function(deleteRowBtnEl, formFieldObj) {
			$(isFieldDeleteJEl).val(true);
			$(fieldDeleteSrNoJEl).val(formFieldObj.srNo);
			deletedRowEl = $(deleteRowBtnEl).parents('tr');
			$(deleteFormFieldModalJEl).modal('show');
			var label = formFieldObj.label;
			$("#" + namespace + "delete_confirmation_message").find("em")
				.html(Liferay.Language.get("delete-confirmation-complete-message").replace("{fieldName}", "<b>" + label.en_US + "</b>"));
		};
		
		showPermissionModalPopup = function(showModalRowBtnEl, formFieldObj) {
			editedRowEl = $(showModalRowBtnEl).parents('tr');
			permissionFormFieldObjJEL = formFieldObj;
			$(permissionFieldIdJEL).val(formFieldObj.srNo);
			var parsedRolesJson = JSON.parse(rolesJson); 
			var rolesArr = [];
			$.each(parsedRolesJson, function (i, obj) {
			    $.each(obj, function(index,jsonObject){
				    var roleStr = '';
				    var id = '';
				    var name = '';
			        $.each(jsonObject, function(key,val){
			            console.log(key+"_"+val);
			            if(key == 'id'){
			            	id = val;
			            	if(!(roleIds.indexOf(val) > -1)){
			            		roleIds.push(val);
			            	} 
			            } else if (key == 'name'){
			            	name = val;
			            }
			        });
			        roleStr = id + '_' + name;
			        rolesArr.push(roleStr);
			    });
			});
			createPermissionModalPopup(rolesArr, formFieldObj);
		};
		
		addPermissionClick = function(addEl){
			console.log('add permission clicked--', addEl);
			if($(addEl).is(':checked')){
				var viewId = $(addEl).prop('id').replace('_add', '_view');
				$('#'+ viewId).prop('checked', true);
			}
		}
		
		editPermissionClick = function(editEl){
			console.log('edit permission clicked--', editEl);
			if($(editEl).is(':checked')){
				var viewId = $(editEl).prop('id').replace('_edit', '_view');
				$('#'+ viewId).prop('checked', true);
			}
		}
		
		viewPermissionClick = function(viewEl){
			console.log('view permission clicked--', viewEl);
			if(!$(viewEl).is(':checked')){
				var addId = $(viewEl).prop('id').replace('_view', '_add');
				var editId = $(viewEl).prop('id').replace('_view', '_edit');
				$('#'+ addId).prop('checked', false);
				$('#'+ editId).prop('checked', false);
			}
		}
		
		createPermissionModalPopup = function(rolesArr, formFieldObj){
			$(permissionTableBodyJEL).html('');
			$.each(rolesArr, function(index, value) {
				var roleDetails = value.split('_');
				var id = roleDetails[0];
				var name = roleDetails[1];
				console.log('id -- ' + id + ' -- name -- ' + name);
				var rowEL = commonFc.createTREl();
				var tdRoleNameEL = commonFc.createTDEl(name);
				$(rowEL).append(tdRoleNameEL);
				var tdAddEL = commonFc.createTDEl();
				var addDivEL = commonFc.createDivEl('custom-control custom-checkbox');
				var addChangeEventObj = new Object({});
				addChangeEventObj.fnName = 'addPermissionClick(this);';
				var addCheckboxEL = commonFc.createInputCheckboxEl('custom-control-label', id+'_add', 
					'custom-control-input', id+'_add', '', addChangeEventObj);
				$(addDivEL).append(addCheckboxEL);
				$(tdAddEL).append(addDivEL);
				$(rowEL).append(tdAddEL);
				
				var tdEditEL = commonFc.createTDEl();
				var editDivEL = commonFc.createDivEl('custom-control custom-checkbox');
				var editChangeEventObj = new Object({});
				editChangeEventObj.fnName = 'editPermissionClick(this);';
				var editCheckboxEL = commonFc.createInputCheckboxEl('custom-control-label', id+'_edit', 
					'custom-control-input', id+'_edit', '', editChangeEventObj);
				$(editDivEL).append(editCheckboxEL);
				$(tdEditEL).append(editDivEL);
				$(rowEL).append(tdEditEL);
				
				var tdViewEL = commonFc.createTDEl();
				var viewDivEL = commonFc.createDivEl('custom-control custom-checkbox');
				var viewChangeEventObj = new Object({});
				viewChangeEventObj.fnName = 'viewPermissionClick(this);';
				var viewCheckboxEL = commonFc.createInputCheckboxEl('custom-control-label', id+'_view', 
					'custom-control-input', id+'_view', '', viewChangeEventObj);
				$(viewDivEL).append(viewCheckboxEL);
				$(tdViewEL).append(viewDivEL);
				$(rowEL).append(tdViewEL);
				$(permissionTableBodyJEL).append(rowEL);
				$('#'+namespace + id +"_view").prop('checked', true);
				
				if(formFieldObj.hasOwnProperty('permissions')){
					var value = formFieldObj.permissions[id];
					var add = value.add;
            		var edit = value.edit;
            		var view = value.view;
            		if(add){
            			$('#' + namespace + id + "_add" ).prop('checked', true);
            		} if(edit){
            			$('#' + namespace + id + "_edit" ).prop('checked', true);
            		} if(view){
            			$('#' + namespace + id + "_view" ).prop('checked', true);
            		} if(!view) {
            			$('#' + namespace + id + "_view" ).prop('checked', false);
            		}
				}
			});
			$(openPermissionModalJEl).trigger('click');
		}

		editModalPopup = function(editedRowBtnEl, formFieldObj) {
			
			$(formFieldResetBtnJEl).hide();
			
			var htmlText = getEN_USLocaleHtmlText();
			$(formFieldLabelSelectedLocaleJEl).html(htmlText);
			$(formFieldLabelSelectedLocaleJEl).attr('language-id', 'en_US');

			$(fieldPlaceholderSelectedLocaleJEl).html(htmlText);
			$(fieldPlaceholderSelectedLocaleJEl).attr('language-id', 'en_US');

			$(fieldHTMLPlaceholderSelectedLocale).html(htmlText);
			$(fieldHTMLPlaceholderSelectedLocale).attr('language-id', 'en_US');

			$(fieldLabelJEl).removeAttr('onchange');
			$(fieldLabelJEl).attr("onchange", "updateHiddenFieldValue(this);");
			$(fieldKeyJEl).prop("readonly", true);
			//Field Label Error message Hide
			
			$(formFieldErrJEl).removeClass('d-block');
			$(formFieldErrJEl).addClass('d-none');

			//Range Options Config Hide
			$(fieldRangeOptionsConfigRowJEl).addClass('d-none');
			
			if(formFieldObj.settings.type){
				$(fieldTypeJEl).attr("disabled", true);
			};
			
			if(formFieldObj.settings.dataType){
				$(fieldDataTypeJEl).attr("disabled", true);
			};
			
			$(isFieldEditJEl).val(true);
			$(fieldEditSrNoJEl).val(formFieldObj.srNo);
			editedRowEl = $(editedRowBtnEl).parents('tr');
			console.log("formFieldObj While Editing Fields: ",formFieldObj);
			$(formFieldModalJEl).modal('show');

			// Populating Groups Dropdown
			if(formBuilderConfigJsonObj.groups){
				if(formBuilderConfigJsonObj.groups.length > 0){
					$(displayGroupJEl).removeClass('d-none');
					$(displayGroupJEl).addClass('d-block');
					populateGroups();
					$(groupJEl + " option").removeAttr('selected');
					$(groupJEl + ' option[value="' + formFieldObj.settings.group + '"]').attr("selected", "selected");
				}
			}

			// Populating Data In Field Label 
			$(fieldLabelJEl).val(commonFc.unEscape(formFieldObj.label.en_US));
			$(fieldEnUsLabelJEl).val(commonFc.unEscape(formFieldObj.label.en_US));
			$(fieldArSaLabelJEl).val(commonFc.unEscape(formFieldObj.label.ar_SA));
			//addFieldKey($(fieldLabelJEl));
			$(fieldKeyJEl).val(formFieldObj.key);
			
			// Populating Data In Field Type 
			$(fieldTypeJEl + " option").removeAttr('selected');
			$(fieldTypeJEl + ' option[value="' + formFieldObj.settings.type + '"]').attr("selected", "selected");
			selectedFieldSettingType($(fieldTypeJEl));
			
			// Populating Data In Field Data Type 
			$(fieldDataTypeJEl + " option").removeAttr('selected');
			$(fieldDataTypeJEl + ' option[value="' + formFieldObj.settings.dataType + '"]').attr("selected", "selected");
			if(formFieldObj.settings.type == "number" || formFieldObj.settings.type == "range") {
				$(fieldDataTypeJEl + ' option').filter(function (){ 
					return $(this).html() == formFieldObj.settings.dataType; 
				}).attr("selected", "selected");
			}
			
			// Populating Data In Field Status
			$(fieldStatusJEl + " option").removeAttr('selected');
			$(fieldStatusJEl + ' option[value="' + formFieldObj.settings.status + '"]').attr("selected", "selected");

			// Populating Data In Placeholder
			if(formFieldObj.settings.hasOwnProperty('placeHolder')) {
				$(fieldPlaceholderJEl).val(formFieldObj.settings.placeHolder.en_US);
				$(fieldEnUsPlaceholderJEl).val(formFieldObj.settings.placeHolder.en_US);
				$(fieldArSaPlaceholderJEl).val(formFieldObj.settings.placeHolder.ar_SA);
			} else {
				$(fieldPlaceholderJEl).val('');
				$(fieldEnUsPlaceholderJEl).val('');
				$(fieldArSaPlaceholderJEl).val('');
			}
			
			// Populating Data In Range Comment
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('rangeComment')) {
				$(rangeCommentJEl).val(formFieldObj.settings.rangeConfig.rangeComment.en_US);
				$(fieldEnUsRangeCommentJEl).val(formFieldObj.settings.rangeConfig.rangeComment.en_US);
				$(fieldArSaRangeCommentJEl).val(formFieldObj.settings.rangeConfig.rangeComment.ar_SA);
			} else {
				$(rangeCommentJEl).val('');
				$(fieldEnUsRangeCommentJEl).val('');
				$(fieldArSaRangeCommentJEl).val('');
			}
			toggleIsRangeComment(rangeCommentJEl);

			// Populating Data In Disabled Checkbox
			if(formFieldObj.settings.hasOwnProperty('disabled') && formFieldObj.settings.disabled) {
				$(fieldDisableJEl).prop('checked', true);
			} else {
				$(fieldDisableJEl).prop('checked', false);
			}
			
			// Populating Data In New Line Checkbox
			if(formFieldObj.settings.hasOwnProperty('startNewLine') && formFieldObj.settings.startNewLine) {
				$(fieldNewLineJEl).prop('checked', true);
			} else {
				$(fieldNewLineJEl).prop('checked', false);
			}

			// Populating Data In Required Checkbox
			if(formFieldObj.settings.hasOwnProperty('required') && formFieldObj.settings.required) {				
				$(fieldRequiredJEl).prop('checked', true);				
			} else {
				$(fieldRequiredJEl).prop('checked', false);
			}

			// Populating Data In ReadOnly Checkbox
			if(formFieldObj.settings.hasOwnProperty('readonly') && formFieldObj.settings.readonly) {
				$(fieldReadonlyJEl).prop('checked', true);
			} else {
				$(fieldReadonlyJEl).prop('checked', false);
			}
			
			// Populating Data In PostData Checkbox
			if(formFieldObj.settings.hasOwnProperty('postData')) {
				$(fieldPostDataJEl).prop('checked', true);				
				$(fieldPostDataNameJEl).val(formFieldObj.settings.postData.fieldName);
			} else {
				$(fieldPostDataJEl).prop('checked', false);				
				$(fieldPostDataNameJEl).val('');
			}
			showDataField($(fieldPostDataJEl));

			// Populating Data In Validation Checkbox
			if(formFieldObj.settings.hasOwnProperty('validations')) {
                var fieldValidations = formFieldObj.settings.validations;
                var gridData = [];
                for (var i = 0; i < fieldValidations.length; i++) {
                    var type = fieldValidations[i].type;
                    var param = fieldValidations[i].param;
                    var arName;
                    var enName = fieldValidations[i].message.en_US;
                    if(fieldValidations[i].message.ar_SA){
                        arName = fieldValidations[i].message.ar_SA;
                    }
                    gridData.push({
                        "type": type,
                        "param": param,
                        "en_US": enName,
                        "ar_SA": arName
                    });
                }
                if(fieldValidations && fieldValidations.length > 0){
                    $(fieldExtraValidationsJEl).prop('checked', true);
                    toggleExtraValidations(fieldExtraValidationsJEl);
                    $(jsGridValidationJEl).jsGrid({
                        data : gridData
                    });
                } else {
                    $(fieldExtraValidationsJEl).prop('checked', false);
                    toggleExtraValidations(fieldExtraValidationsJEl);
                }
			}
			
			
			// Populating Data In PrePopulateData Checkbox
			if(formFieldObj.settings.hasOwnProperty('populateData')) {
				$(fieldPopulateDataJEl).prop('checked', true);	
				$(fieldPopulateDataJEl).parent().removeClass('d-none');
				$(fieldPopulateDataJEl).parent().addClass('d-block');
				$(fieldPopulateDataNameJEl).val(formFieldObj.settings.populateData.fieldName);
			} else {
				$(fieldPopulateDataJEl).prop('checked', false);				
				$(fieldPopulateDataNameJEl).val('');
			}
			showDataField($(fieldPopulateDataJEl));

			// Populating Data In Read From Request Parameter Checkbox
			if(formFieldObj.settings.hasOwnProperty('readFromRequestParam')) {
				$(fieldReadFromReqParamJEl).parent().removeClass('d-none');
				$(fieldReadFromReqParamJEl).parent().addClass('d-block');
				$(fieldReadFromReqParamJEl).prop('checked', true);
				$(fieldReadFromReqParamNameJEl).val(formFieldObj.settings.readFromRequestParam.paramName);
			} else {
				$(fieldReadFromReqParamJEl).prop('checked', false);
				$(fieldReadFromReqParamNameJEl).val('');
			}
			showDataField($(fieldReadFromReqParamJEl));

			// Populating Data In Visible On Checkbox
			if(formFieldObj.hasOwnProperty('visibleOn')) {
				$(fieldVisibleOnJEl).prop('checked', true);
				populateVisibleOn();
				$(fieldVisibleOnNameJEl).val(formFieldObj.visibleOn.fieldValue);
				$(fieldVisibleOnDropdownJEl).val(formFieldObj.visibleOn.fieldName);
			} else {
				$(fieldVisibleOnJEl).prop('checked', false);			
				$(fieldVisibleOnDropdownJEl).val('');
			}
			toggleVisibleOn($(fieldVisibleOnDropdownJEl));
			toggleVisibleOnTextInput($(fieldVisibleOnNameJEl));

			// Populating Data In Group Average Checkbox
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('groupAverage') && formFieldObj.settings.rangeConfig.groupAverage) {
				$(fieldGroupAverageJEl).prop('checked', true);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('groupAverage') && formFieldObj.settings.customRangeConfig.groupAverage){
				$(fieldGroupAverageJEl).prop('checked', true);
			} else {
				$(fieldGroupAverageJEl).prop('checked', false);				
			}

			// Populating Data In Overall Average Checkbox
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('overallAverage') && formFieldObj.settings.rangeConfig.overallAverage) {
				$(fieldOverallAverageJEl).prop('checked', true);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('overallAverage') && formFieldObj.settings.customRangeConfig.overallAverage) {
				$(fieldOverallAverageJEl).prop('checked', true);
			} else {
				$(fieldOverallAverageJEl).prop('checked', false);				
			}
			
			// Populating Data In Group Total Checkbox
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('groupTotal') && formFieldObj.settings.rangeConfig.groupTotal) {
				$(groupTotalJEl).prop('checked', true);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('groupTotal') && formFieldObj.settings.customRangeConfig.groupTotal) {
				$(groupTotalJEl).prop('checked', true);
			} else {
				$(groupTotalJEl).prop('checked', false);				
			}
			
			// Populating Data In Range Comment Checkbox
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('rangeComment') && formFieldObj.settings.rangeConfig.rangeComment) {
				$(isRangeCommentJEl).prop('checked', true);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('rangeComment') && formFieldObj.settings.customRangeConfig.rangeComment) {
				$(isRangeCommentJEl).prop('checked', true);
			} else {
				$(isRangeCommentJEl).prop('checked', false);				
			}
			
			// Populating Data In Range Total Character Checkbox
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('rangeTotalCharacter') && formFieldObj.settings.rangeConfig.rangeTotalCharacter) {
				$(rangeTotalCharacterJEl).prop('checked', true);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('rangeTotalCharacter') && formFieldObj.settings.customRangeConfig.rangeTotalCharacter) {
				$(rangeTotalCharacterJEl).prop('checked', true);
			} else {
				$(rangeTotalCharacterJEl).prop('checked', false);				
			}
			toggleRangeMaxCharacter(rangeTotalCharacterJEl);

			// Populating Data In Overall Total Checkbox
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('overallTotal') && formFieldObj.settings.rangeConfig.overallTotal) {
				$(overallTotalJEl).prop('checked', true);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('overallTotal') && formFieldObj.settings.customRangeConfig.overallTotal) {
				$(overallTotalJEl).prop('checked', true);
			} else {
				$(overallTotalJEl).prop('checked', false);				
			}
			toggleIsRangeComment(rangeCommentJEl);

			// Populating Data In MIN For Number Field
			if((formFieldObj.settings.type == "number" || formFieldObj.settings.type == "rangePicker") && formFieldObj.settings.hasOwnProperty('min')) {
				$(fieldMinNumberPlaceholderJEl).val(formFieldObj.settings.min);
			} else {
				$(fieldMinNumberPlaceholderJEl).val('');
			}

			// Populating Data In MAX For Number Field
			if((formFieldObj.settings.type == "number" || formFieldObj.settings.type == "rangePicker") && formFieldObj.settings.hasOwnProperty('max')) {
				$(fieldMaxNumberPlaceholderJEl).val(formFieldObj.settings.max);
			} else {
				$(fieldMaxNumberPlaceholderJEl).val('');
			}

			// Populating Data in Min Boundary For Range Field
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('boundaries')) {
				$(fieldMinBoundaryJEl).val(formFieldObj.settings.rangeConfig.boundaries[0]);
				$(fieldMaxBoundaryJEl).val(formFieldObj.settings.rangeConfig.boundaries[1]);
			} else {
				$(fieldMinBoundaryJEl).val('');
				$(fieldMaxBoundaryJEl).val('');
			}
			
			// Populating Data in Max Character For Range Field
			if(formFieldObj.settings.hasOwnProperty('rangeConfig')) {
				$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-none');
				$(rangeMaxCharacterJEl).val(formFieldObj.settings.rangeConfig.maxRangeCharacter);
			} else if(formFieldObj.settings.hasOwnProperty('customRangeConfig')) {
				$(fieldDisplayRangeTotalCharacterJEl).removeClass('d-none');
				$(rangeMaxCharacterJEl).val(formFieldObj.settings.customRangeConfig.maxRangeCharacter);		
			} else{
				$(rangeMaxCharacterJEl).val('');		
			}

			// Populating Data In Range Options
			if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.hasOwnProperty('options')) {
				if(formFieldObj.settings.hasOwnProperty('rangeConfig') && formFieldObj.settings.rangeConfig.options){
					var rangeOptions = formFieldObj.settings.rangeConfig.options;
					console.log('rangeOptions >> ', rangeOptions);
					var gridData = [];

					for (var i = 0; i < rangeOptions.length; i++) {
						var arName;
						var enName = rangeOptions[i].name.en_US;
						if(rangeOptions[i].name.ar_SA){
							arName = rangeOptions[i].name.ar_SA;
						}
						gridData.push({
							"en_US": enName,
							"ar_SA": arName
						});
					}
					console.log('gridData >> ', gridData);
					if(rangeOptions && rangeOptions.length > 0){
						$(fieldDisplayRangeJSGridJEl).jsGrid({
							data : gridData
						});
					}
					//populateRangeOptionsConfig(fieldDisplayRangeJSGridJEl);
					populateRangeOptions(fieldDisplayRangeJSGridJEl);
					$(fieldRangeOptionsConfigRowJEl).removeClass('d-none');
				}
			}
			
			//Populating Data In Range Names Dropdown
			if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('rangeOptionMaster') && formFieldObj.settings.customRangeConfig.rangeOptionMaster){
				$(rangeOptionNameDrJEl + " option").removeAttr('selected');
				$(rangeOptionNameDrJEl + ' option[value="' + formFieldObj.settings.customRangeConfig.rangeOptionMaster + '"]').attr("selected", "selected");
				selectedRangeOption($(rangeOptionNameDrJEl));
			}
			
			// Populating Data In Custom Range Options
			if(formFieldObj.settings.hasOwnProperty('customRangeConfig') && formFieldObj.settings.customRangeConfig.hasOwnProperty('options') && formFieldObj.settings.customRangeConfig.options) {
				var customRangeOtions = formFieldObj.settings.customRangeConfig.options;
				console.log('customRangeOtions >> ', customRangeOtions);
				commonFc.populateCustomRangeJSGrid(customRangeOtions, fieldDisplayCustomRangeJSGridJEl);
			}
			
			//Populating for single file upload
			if(formFieldObj.settings.hasOwnProperty('multiple')){
				var isMultipleChecked = formFieldObj.settings.multiple;
				if(isMultipleChecked){
					setTimeout(() => {
					  //$(fieldDataPropsJEl).val(String(dataPropsValues.toString()));
					  $(fieldMultipleFileUploadJEl).prop('checked', true);
					}, "100");
				} else{
					$(fieldMultipleFileUploadJEl).prop('checked', false);
				}
			}

			// Populating Data in Multiselect Checkbox
			if(formFieldObj.settings.hasOwnProperty('multiselect') && formFieldObj.settings.multiselect) {
				$(fieldMultiselectDropdownCheckboxJEl).prop('checked', true);
			} else {
				$(fieldMultiselectDropdownCheckboxJEl).prop('checked', false);
			}

			// Populating Data in Populate Values Field In Case Of Dropdown
			$(fieldWhereToPopulateDropdownJEl + " option").removeAttr('selected');
			if(formFieldObj.settings.type == "dropdown") {
				if(formFieldObj.settings.hasOwnProperty('values')) {
					$(fieldWhereToPopulateDropdownJEl).val("staticValues");
					whereToPopulateSelectedDropdownValue(fieldWhereToPopulateDropdownJEl);
					/*var staticValues = formFieldObj.settings.values;
					setTimeout(() => {
					  $(fieldStaticValuesInputTagJEl).val(String(staticValues.toString()));
					}, "100");*/
					var staticValues = formFieldObj.settings.values;
					if(staticValues && staticValues.length > 0){
						$(fieldDisplayDropdownStaticJSGridJEl).jsGrid({
							data : staticValues
						});
					}
				} else if(formFieldObj.settings.hasOwnProperty('master')){
					$(fieldWhereToPopulateDropdownJEl ).val("masterTable");
					$(fieldWhereToPopulateDropdownJEl).addClass('disable-populate-values');
					whereToPopulateSelectedDropdownValue(fieldWhereToPopulateDropdownJEl);
					var isMasterTable = formFieldObj.settings.master.createNewMappingTable;
					var tableName = formFieldObj.settings.master.masterTable;
					var textColumn = formFieldObj.settings.master.textColumn;
					var valueColumn = formFieldObj.settings.master.valueColumn;
					if(isMasterTable){
						$('input[name="'+fieldCreateMasterTableJEl+'"]').filter('[value="yes"]').attr('checked', true).prop('disabled',true);
					} else {
						$('input[name="'+fieldCreateMasterTableJEl+'"]').filter('[value="no"]').attr('checked', true).prop('disabled',true);
					}
					$(fieldMasterTableJEl).val(tableName).addClass('disable-populate-values');
					fetchEditColumnNames(tableName, textColumn);
					$(fieldMasterTableTextColumnJEl).val(textColumn).attr('selected', true);
					$(fieldMasterTableValueColumnJEl).empty().append($('<option>', {
					    value: valueColumn,
					    text: valueColumn
					})).val(valueColumn).addClass('disable-populate-values');
					
				} else if(formFieldObj.settings.hasOwnProperty('dependency')) {
					$(fieldWhereToPopulateDropdownJEl).val("dependentFields");
					whereToPopulateSelectedDropdownValue(fieldWhereToPopulateDropdownJEl);
					
					$(fieldWhereToPopulateDependentFieldsJEl + " option").removeAttr('selected');
					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider')) {
						$(fieldWhereToPopulateDependentFieldsJEl).val("dataProvider");
						whereToPopulateDependentFields(fieldWhereToPopulateDependentFieldsJEl);
					} else if(formFieldObj.settings.dependency.hasOwnProperty('fieldValues')) {
						var fieldName = formFieldObj.settings.dependency.fieldName;
						$(fieldDependentFieldsNameJEl).val(fieldName);
						$(fieldWhereToPopulateDependentFieldsJEl).val("staticValues");
						whereToPopulateDependentFields(fieldWhereToPopulateDependentFieldsJEl);
						var fieldValuesArr = formFieldObj.settings.dependency.fieldValues;
						var fieldDisplayValues;
						var index = 1;
						console.log('fieldValuesArr >>>',fieldValuesArr);
						for(var i = 0; i < fieldValuesArr.length; i++){
							var fieldStaticValues = fieldValuesArr[i];
							var fieldValue = fieldStaticValues.fieldValue["en_US"];
							console.log('fieldValue >>>',fieldValue);
							var fieldValueEl = $(dfStaticInputJEl+index).prop('placeholder');
							console.log('fieldValueEl >>> ',fieldValueEl);
							if(fieldValueEl == fieldValue){
								fieldDisplayValues = fieldStaticValues.displayValues;
								$.each(fieldDisplayValues, function(key, value){
									$(fieldDFStaticValuesJSGridJEl+index).jsGrid({
										data : fieldDisplayValues
									});
								});
							}
							index++;
						}
					}
					

					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('url')) {
						$(fieldDataProviderURLJEl).val(formFieldObj.settings.dependency.dataProvider.url);
					}

					$(fieldMethodTypesJEl + " option").removeAttr('selected');
					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('method')) {
						$(fieldMethodTypesJEl).val(formFieldObj.settings.dependency.dataProvider.method);
					}
					populateContentTypes(fieldMethodTypesJEl);

					$(fieldContentTypesJEl + " option").removeAttr('selected');
					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('contentType')) {
						$(fieldContentTypesJEl).val(formFieldObj.settings.dependency.dataProvider.contentType);
					}

					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('property')) {						
						$('#' + namespace + 'dataProviderURLProperty').val(formFieldObj.settings.dependency.dataProvider.property);
					} else {
						$('#' + namespace + 'dataProviderURLProperty').val('');
					}

					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('dataProps')) {
						var dataPropsValues = formFieldObj.settings.dependency.dataProvider.dataProps;
						setTimeout(() => {
						  $(fieldDataPropsJEl).val(String(dataPropsValues.toString()));
						}, "100");
					}

					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('sourceProps')) {
						$(fieldSourcePropsJEl).val(JSON.stringify(formFieldObj.settings.dependency.dataProvider.sourceProps));
					}
					
					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('accept')) {
						var dataProviderAcceptValue = formFieldObj.settings.dependency.dataProvider.accept;
						setTimeout(() => {
						  $(dataProviderAcceptJEl).val(dataProviderAcceptValue);
						}, "100");
					}
					
					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('headers')){
						var dataProviderHeaders = formFieldObj.settings.dependency.dataProvider.headers;
						if(dataProviderHeaders && dataProviderHeaders.length > 0){
							$(dataProviderHeadersJEl).jsGrid({
								data : getFormattedKeyValueArr(dataProviderHeaders)
							});
						}
					}
					
					if(formFieldObj.settings.dependency.hasOwnProperty('dataProvider') && formFieldObj.settings.dependency.dataProvider.hasOwnProperty('params')){
						var dataProviderParams = formFieldObj.settings.dependency.dataProvider.params;
						if(dataProviderParams && dataProviderParams.length > 0){
							$(dataProviderParamsJEl).jsGrid({
								data : getFormattedKeyValueArr(dataProviderParams)
							});
						}
					}
				} else if(formFieldObj.settings.hasOwnProperty('dataProvider')) {
					$(fieldWhereToPopulateDropdownJEl).val("dataProvider");
					whereToPopulateSelectedDropdownValue(fieldWhereToPopulateDropdownJEl);
					
					if(formFieldObj.settings.dataProvider.hasOwnProperty('url')) {
						$(fieldDataProviderURLJEl).val(formFieldObj.settings.dataProvider.url);
					}

					$(fieldMethodTypesJEl + " option").removeAttr('selected');
					if(formFieldObj.settings.dataProvider.hasOwnProperty('method')) {
						$(fieldMethodTypesJEl).val(formFieldObj.settings.dataProvider.method.toLowerCase());
					}
					populateContentTypes(fieldMethodTypesJEl);

					$(fieldContentTypesJEl + " option").removeAttr('selected');
					if(formFieldObj.settings.dataProvider.hasOwnProperty('contentType')) {
						$(fieldContentTypesJEl).val(formFieldObj.settings.dataProvider.contentType);
					}

					if(formFieldObj.settings.dataProvider.hasOwnProperty('property')) {
						$('#' + namespace + 'dataProviderURLProperty').val(formFieldObj.settings.dataProvider.property);
					} else {
						$('#' + namespace + 'dataProviderURLProperty').val('');
					}

					if(formFieldObj.settings.dataProvider.hasOwnProperty('dataProps')) {
						var dataPropsValues = formFieldObj.settings.dataProvider.dataProps;
						console.log('Edit DataProps >>> ', dataPropsValues);
						setTimeout(() => {
						  $(fieldDataPropsJEl).val(String(dataPropsValues.toString()));
						}, "100");
					}
					
					if(formFieldObj.settings.dataProvider.hasOwnProperty('accept')) {
						var dataProviderAcceptValue = formFieldObj.settings.dataProvider.accept;
						setTimeout(() => {
						  $(dataProviderAcceptJEl).val(dataProviderAcceptValue);
						}, "100");
					}
					
					if(formFieldObj.settings.dataProvider.hasOwnProperty('headers')){
						var dataProviderHeaders = formFieldObj.settings.dataProvider.headers;
						if(dataProviderHeaders && dataProviderHeaders.length > 0){
							$(dataProviderHeadersJEl).jsGrid({
								data : getFormattedKeyValueArr(dataProviderHeaders)
							});
						}
					}
					
					if(formFieldObj.settings.dataProvider.hasOwnProperty('params')){
						var dataProviderParams = formFieldObj.settings.dataProvider.params;
						if(dataProviderParams && dataProviderParams.length > 0){
							$(dataProviderParamsJEl).jsGrid({
								data : getFormattedKeyValueArr(dataProviderParams)
							});
						}
					}
				} else {
					$(fieldWhereToPopulateDropdownJEl).val("");
				}
			}

			// Populating Data In Date, Time & DateTime Format Dropdown
			$("#"+namespace+"formatPlaceholder option").removeAttr('selected');
			if(formFieldObj.settings.hasOwnProperty('dateConfig')) {
				$('#' + namespace + 'formatPlaceholder option[value="' + formFieldObj.settings.dateConfig.format + '"]').attr("selected", "selected");
			}

			// Populating Data In Values Field For Radio & Checkbox Type
			if(formFieldObj.settings.hasOwnProperty('values') && (formFieldObj.settings.type == "radio" || formFieldObj.settings.type == "checkbox")) {
				var chekboxRadio = formFieldObj.settings.values;
				if(chekboxRadio && chekboxRadio.length > 0){
					$(fieldDisplayCheckboxRadioJSGridJEl).jsGrid({
						data : chekboxRadio
					});
				}
			}

			// Populating Data in Placeholder Field for HTML Type
			if(formFieldObj.settings.type == "html" && formFieldObj.settings.hasOwnProperty('placeHolder')) {
				$.each(formFieldObj.settings.placeHolder, function(locale, encryptedVal) {	
					console.log("locale :: " + locale + ", Encrypted Value :: " + encryptedVal);
					var editorPlaceholder = '';
					if(encryptedVal != '') {
						var toDecryptDataObj = getEncryptDecryptDataObj(encryptedVal);
						editorPlaceholder = commonFc.decryptData(toDecryptDataObj);
						console.log("editorPlaceholder :: " + editorPlaceholder + ", locale : " + locale);
					}
					if(locale == "en_US") {
						$(fieldHTMLEditorPlaceholderJEl).summernote('code', editorPlaceholder);
						$(fieldEnUsHTMLEditorPlaceholderJEl).val(editorPlaceholder);
					} else if(locale == "ar_SA") {
						$(fieldArSaHTMLEditorPlaceholderJEl).val(editorPlaceholder);
					}
					
				});				
			}

		};
		
		setStaticInputTag = function(eleJEl, value){
			setTimeout(() => {
				  $(eleJEl).val(value);
				}, "100");
		};
		
		init = function() {
	    	commonFc.initConfigVars(new Object({namespace : namespace, themeImagesPath : themeImagesPath, languageId : Liferay.ThemeDisplay.getLanguageId()}));
	    	initFormConfig();
	    	//initModalFooter();
	    	initEvent();
	    	initFormData();
	    	$(formCardBodyLoadingRowJEl).hide();
        };
       
        
       init();
       
       viewDFConfig.addFieldKey = addFieldKey;
       viewDFConfig.selectedFieldSettingType = selectedFieldSettingType;
       viewDFConfig.showDataField = showDataField;
       viewDFConfig.toggleVisibleOn = toggleVisibleOn;
       viewDFConfig.toggleVisibleOnTextInput = toggleVisibleOnTextInput;
       viewDFConfig.whereToPopulateSelectedDropdownValue = whereToPopulateSelectedDropdownValue;
       viewDFConfig.whereToPopulateDependentFields = whereToPopulateDependentFields;
       viewDFConfig.populateContentTypes = populateContentTypes;
       viewDFConfig.removeRow = removeRow;
       viewDFConfig.populateRangeOptionsConfig = populateRangeOptionsConfig;
       viewDFConfig.populateRangeOptions = populateRangeOptions;
       viewDFConfig.toggleExtraValidations = toggleExtraValidations;
       viewDFConfig.showPostData = showPostData;
       viewDFConfig.showPopulateData = showPopulateData;
       viewDFConfig.fetchColumnNames = fetchColumnNames;
       viewDFConfig.statusInactive = statusInactive;
       viewDFConfig.toggleRangeMaxCharacter = toggleRangeMaxCharacter;
       viewDFConfig.toggleIsRangeComment = toggleIsRangeComment;
       viewDFConfig.getCustomRangeFieldsArr = getCustomRangeFieldsArr;
       viewDFConfig.selectedRangeOption = selectedRangeOption;
	}
	
	function addValidatorMethods(){
		$.validator.addMethod("blankSpace", function(value) {
			return value.replace(/\s/g, '').length;
		});
		
		dfPortlet.addValidatorMethods = addValidatorMethods;
	}
	
	function addFormBasicSectionConfig(){
		
		var changeFormName = Liferay.Language.get('change-form-name');
		createGroupJSGrid();
		getFormDescription = function(){			
			var description = new Object({}), defaultSummerNoteDescription = '<p><br></p>', en_US_Description = $(formEnUsDescriptionJEl).val(),
				ar_SA_Description = $(formArSaDescriptionJEl).val();
			
			if(en_US_Description == defaultSummerNoteDescription) {
				description["en_US"] = '';
			} else {
				var toEncryptDataObj = getEncryptDecryptDataObj(en_US_Description);
				var encryptedDescription = commonFc.encryptData(toEncryptDataObj);
				description["en_US"] = encryptedDescription;
			}

			if(ar_SA_Description == defaultSummerNoteDescription) {
				description["ar_SA"] = '';
			} else {
				var toEncryptDataObj = getEncryptDecryptDataObj(ar_SA_Description);
				var encryptedDescription = commonFc.encryptData(toEncryptDataObj);
				description["ar_SA"] = encryptedDescription;
			}

			return description;
		};
		setBasicFormDataFields =  function(formNames){
			$(formBasicSectionResetBtnJEl).hide();
			var currentFormDescriptionLocale = $(formDescriptionSelectedLocaleJEl).attr('language-id');

			$(formNamesDataJEl).val(formNames);
			if(formBuilderConfigJsonObj.hasOwnProperty('name')) {
				$(formNameJEl).val(formBuilderConfigJsonObj.name);
			}

			if(formBuilderConfigJsonObj.hasOwnProperty('title')) {
				$(formTitleJEl).val(formBuilderConfigJsonObj.title.en_US);
				console.log('title >>> ',formBuilderConfigJsonObj.title.en_US);
				$(formEnUsTitleJEl).val(formBuilderConfigJsonObj.title.en_US);
				$(formArSaTitleJEl).val(formBuilderConfigJsonObj.title.ar_SA);
			}
			
			if(formBuilderConfigJsonObj.hasOwnProperty('layout')) {
				$("input[name= " + formLayoutName + "][value=" + formBuilderConfigJsonObj.layout + "]"). prop('checked', true);
			}

			if(formBuilderConfigJsonObj.description && formBuilderConfigJsonObj.description.en_US != ''){
				var toDecryptDataObj = getEncryptDecryptDataObj(formBuilderConfigJsonObj.description["en_US"]);
				var decryptedDescription = commonFc.decryptData(toDecryptDataObj);
				$(formEnUsDescriptionJEl).val(decryptedDescription);
				console.log('description >>> ',decryptedDescription);
				if(currentFormDescriptionLocale == "en_US") {
					$(formDescriptionJEl).summernote('code', decryptedDescription);
				}
			}
			if(formBuilderConfigJsonObj.description && formBuilderConfigJsonObj.description.ar_SA != '') {				
				var toDecryptDataObj = getEncryptDecryptDataObj(formBuilderConfigJsonObj.description["ar_SA"]);
				var decryptedDescription = commonFc.decryptData(toDecryptDataObj);
				$(formArSaDescriptionJEl).val(decryptedDescription);				
				if(currentFormDescriptionLocale == "ar_SA") {
					$(formDescriptionJEl).summernote('code', decryptedDescription);
				}
			}

			var groupsArr = formBuilderConfigJsonObj.groups;
			if(groupsArr && groupsArr.length > 0){
				var groups = [];
				$.each(groupsArr, function(key, value){
					var labelsIntCon = value.labels;
					labelsIntCon.description_en_US = value.description.en_US;
					labelsIntCon.description_ar_SA = value.description.ar_SA;
					groups.push(labelsIntCon);
				});
				
				if(groups && groups.length > 0){
					$(groupJSGridJEl).jsGrid({
						data : groups,
					});
				}
			}

			if(formBuilderConfigJsonObj.hasOwnProperty('workflowDefinition')) {
				$(workflowDefinitionJEl).val(formBuilderConfigJsonObj.workflowDefinition);
			}
			
			if(formBuilderConfigJsonObj.hasOwnProperty('isMasterForm') && formBuilderConfigJsonObj.isMasterForm) {
				$(formMasterBSJEl).prop('checked', true);
			}
			
			if(formBuilderConfigJsonObj.postData && formBuilderConfigJsonObj.postData.hasOwnProperty('enabled') && formBuilderConfigJsonObj.postData.enabled) {
				$(postDataBSJEl).prop('checked', true);
				if(formBuilderConfigJsonObj.postData.hasOwnProperty('settings') && formBuilderConfigJsonObj.postData.settings){
					showPostData();
					$(formPostDataURLJEl).val(formBuilderConfigJsonObj.postData.settings.url);
					$(formPostDataContentTypeJEl).val(formBuilderConfigJsonObj.postData.settings.contentType);
					$(formPostDataAcceptJEl).val(formBuilderConfigJsonObj.postData.settings.accept);
					var postHeadersData = formBuilderConfigJsonObj.postData.settings.headers;
					if(postHeadersData && postHeadersData.length > 0){
						$(formPostDataHeadersJEl).jsGrid({
							data : getFormattedKeyValueArr(postHeadersData)
						});
					}
					var postParamsData = formBuilderConfigJsonObj.postData.settings.params;
					if(postParamsData && postParamsData.length > 0){
						$(formPostDataParamsJEl).jsGrid({
							data : getFormattedKeyValueArr(postParamsData)
						});
					}
				}
			} else {
				$(postDataBSJEl).prop('checked', false);
			}
			
			if(formBuilderConfigJsonObj.populateData && formBuilderConfigJsonObj.populateData.hasOwnProperty('enabled') && formBuilderConfigJsonObj.populateData.enabled) {
				$(populateDataBSJEl).prop('checked', true);
				if(formBuilderConfigJsonObj.populateData.settings){
					showPopulateData();
					$(formPrepopulateDataURLJEl).val(formBuilderConfigJsonObj.populateData.settings.url);
					$(formPrepopulateDataContentTypeJEl).val(formBuilderConfigJsonObj.populateData.settings.contentType);
					$(formPrepopulateDataAcceptJEl).val(formBuilderConfigJsonObj.populateData.settings.accept);
					var prepopulateHeadersData = formBuilderConfigJsonObj.populateData.settings.headers;
					if(prepopulateHeadersData && prepopulateHeadersData.length > 0){
						$(formPrepopulateDataHeadersJEl).jsGrid({
							data : getFormattedKeyValueArr(prepopulateHeadersData)
						});
					}
					var prepopulateParamsData = formBuilderConfigJsonObj.populateData.settings.params;
					if(prepopulateParamsData && prepopulateParamsData.length > 0){
						$(formPrepopulateDataParamsJEl).jsGrid({
							data : getFormattedKeyValueArr(prepopulateParamsData)
						});
					}
				}
			} else {
				$(populateDataBSJEl).prop('checked', false);
			}
			
			if(formBuilderConfigJsonObj.readFromRequestParam && formBuilderConfigJsonObj.readFromRequestParam.hasOwnProperty('enabled') && formBuilderConfigJsonObj.readFromRequestParam.enabled) {
				$(readFromReqParamBSJEl).prop('checked', true);
			} else {
				$(readFromReqParamBSJEl).prop('checked', false);
			}
			
		};

		getEncryptDecryptDataObj = function(data) {
			var toEncryptDataObj = new Object({});

			toEncryptDataObj.secretPassphrase = secretPassphrase;
			toEncryptDataObj.text = data;

			return toEncryptDataObj;
		}
		
		getFormattedKeyValueArr = function(data){
			var formattedArr = [];
			$.each(data, function( key, value ) {
			     for (var prop in value) {
			    	 var object = new Object({});
			    	 object.key = prop;
			    	 object.value = value[prop];
			    	 formattedArr.push(object);
			     }
			});
			return formattedArr;
		};
		
		setBasicFormAttrsInJson =  function(){
			var multilingualTitle = new Object({});

			multilingualTitle['en_US'] = $(formEnUsTitleJEl).val();
			multilingualTitle['ar_SA'] = $(formArSaTitleJEl).val();
			
			formBuilderConfigJsonObj.name = $(formNameJEl).val();
			formBuilderConfigJsonObj.title = multilingualTitle;
			formBuilderConfigJsonObj.layout = $("input:radio[name ="+ formLayoutValidator +"]:checked").val();
			formBuilderConfigJsonObj.description = getFormDescription();
			formBuilderConfigJsonObj.groups = getFormGroups();
			if(!formBuilderConfigJsonObj.groups){
				formBuilderConfigJsonObj.groups = [];
			}
			formBuilderConfigJsonObj.workflowDefinition = $(workflowDefinitionJEl).val();
			formBuilderConfigJsonObj.isMasterForm = $(formMasterBSJEl).prop("checked");
			var isPostDataChecked = $(postDataBSJEl).is(":checked");
			if(isPostDataChecked){
				formBuilderConfigJsonObj.postData = getPostData();
			}else{
				delete formBuilderConfigJsonObj['postData'];
			}
			var isPopulateDataChecked = $(populateDataBSJEl).is(":checked");
			if(isPopulateDataChecked){
				formBuilderConfigJsonObj.populateData = getPopulateData();
			}else{
				delete formBuilderConfigJsonObj['populateData'];
			}
			formBuilderConfigJsonObj.readFromRequestParam = getReadFromRequestParam();
		};
		
		getFormGroups = function() {
			var jsGroupsDataArray; 
			if(isJSGrid){			
				jsGroupsDataArray = $(groupJSGridJEl).jsGrid('option','data');
			}
			if(jsGroupsDataArray.length > 0){
				var groupsDataArray=[];
				var index = 1;
				$.each(jsGroupsDataArray, function(key, value) {
					var groupsDataObj = new Object({})
					groupsDataObj.id = getGroupId(value.en_US + "_" + index);
					console.log('index');
					console.log('value :::::: ', value);
					groupsDataObj.labels = {
						ar_SA: value.ar_SA,
						en_US: value.en_US
					};
					groupsDataObj.description = {
						en_US: value.description_en_US,
						ar_SA: value.description_ar_SA
					};
					groupsDataArray.push(groupsDataObj);
					index++;
				});
			}
			
			return groupsDataArray;
		};
		
		getGroupId = function(groupName){
			var groupNameId = groupName.toLowerCase();
			groupNameId = groupNameId.replace(/[^a-zA-Z0-9 ]/g, '');
			groupNameId = groupNameId.replace(/  +/g, '_');
			groupNameId = groupNameId.replaceAll(" ", "_");
			return groupNameId;
		};
		
		getPostData = function(){
			var postData = new Object({}), postDataSettingObj = new Object({});
			postData.enabled = $(postDataBSJEl).is(":checked");
			postDataSettingObj.url = $(formPostDataURLJEl).val();
			postDataSettingObj.contentType = $(formPostDataContentTypeJEl).val();
			postDataSettingObj.accept = $(formPostDataAcceptJEl).val();
			postDataSettingObj.headers = getKeyValueArr(formPostDataHeadersJEl);
			postDataSettingObj.params = getKeyValueArr(formPostDataParamsJEl);
			postData.settings = postDataSettingObj;
			
			return postData;
		};
		
		getKeyValueArr = function(elJEl){
			var keyValueData, keyValueDataArr = [], keyValueDataObj;
			keyValueData = $(elJEl).jsGrid('option','data');
			$.each(keyValueData, function( gridKey, gridValue ) {
			  var key = gridValue.key;
			  keyValueDataObj = {};
			  keyValueDataObj[key] = gridValue.value;
			  keyValueDataArr.push(keyValueDataObj);
			});
			return keyValueDataArr;
		};
		
		getPopulateData = function(){
			var populateData = new Object({}), populateDataSettingObj = new Object({});
			populateData.enabled = $(populateDataBSJEl).is(":checked");
			populateDataSettingObj.url = $(formPrepopulateDataURLJEl).val();
			populateDataSettingObj.contentType = $(formPrepopulateDataContentTypeJEl).val();
			populateDataSettingObj.accept = $(formPrepopulateDataAcceptJEl).val();
			populateDataSettingObj.headers = getKeyValueArr(formPrepopulateDataHeadersJEl);
			populateDataSettingObj.params = getKeyValueArr(formPrepopulateDataParamsJEl);
			populateData.settings = populateDataSettingObj;
			return populateData;
		};
		
		getReadFromRequestParam = function(){
			var readFromRequestParam = new Object({});
			readFromRequestParam.enabled = $(readFromReqParamBSJEl).is(":checked");
			return readFromRequestParam;
		};
		
		validateFormBasicSection = function(){
			var ruleFields = new Object({}),
				messagesFields = new Object({});
			
			//addValidatorMethods();
			
			$.validator.addMethod("alphaNumeric", function(value, element) {
			  return /^[\w]+([-_\s]{1}[a-z0-9]+)*$/i.test( value );
			});
			
			ruleFields[formNameValidator] = {required : true, maxlength:75, alphaNumeric: true};
			ruleFields[formTitleValidator] = {maxlength:75};
			ruleFields[formLayoutValidator] = {required : true};
			ruleFields[formDescriptionValidator] = {maxlength: 2000};
			
			messagesFields[formNameValidator] = {
				required : Liferay.Language.get('this-field-is-required'),
				maxlength : Liferay.Language.get('form-name-max-length-error-msg'),
				alphaNumeric: Liferay.Language.get('please-enter-only-alphanumeric-values')
			};
			
			messagesFields[formTitleValidator] = {
				maxlength : Liferay.Language.get('form-title-max-length-error-msg')
			};
			
			messagesFields[formLayoutValidator] = {
				required : Liferay.Language.get('this-field-is-required')
			};
			
			messagesFields[formDescriptionValidator] = {
                maxlength : Liferay.Language.get('form-description-number-max-length-error-msg')
			};
			
			$(formBasicSectionJEl).validate({
				ignore: [],
			    errorElement: 'span',
			    errorClass:'help-block',
				rules : ruleFields,
				messages : messagesFields,
				errorPlacement: function (error, element) {
					if(element.hasClass('df-radio-field')){
						var parent = element.parent();
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(radioGroupSection).find('.input-group-error').append(error);
					}else{
						error.insertAfter(element);
					 }
				},
				highlight: function (element, errorClass) {
					if($(element).hasClass('df-radio-field')){
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
					if($(element).hasClass('df-radio-field')){
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
			
		};
		
		validatePostDataInBS = function(){
			$(formPostDataURLJEl).rules('add', {
                required:true,
                url2:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required'),
                    url2:Liferay.Language.get('please-enter-correct-url')
                }
            });
			$(formPostDataContentTypeJEl).rules('add', {
                required:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required')
                }
            });
			$(formPostDataAcceptJEl).rules('add', {
                required:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required')
                }
            });
		};
		
		unValidatePostDataInBS = function(){
			$(formPostDataURLJEl).rules('remove');
			$(formPostDataContentTypeJEl).rules('remove');
			$(formPostDataAcceptJEl).rules('remove');
		};
		
		validatePrepopulateDataInBS = function(){
			$(formPrepopulateDataURLJEl).rules('add', {
                required:true,
                //url:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required'),
                    //url:Liferay.Language.get('please-enter-correct-url')
                }
            });
			$(formPrepopulateDataContentTypeJEl).rules('add', {
                required:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required')
                }
            });
			$(formPrepopulateDataAcceptJEl).rules('add', {
                required:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required')
                }
            });
		};
		
		unValidatePrepopulateDataInBS = function(){
			$(formPrepopulateDataURLJEl).rules('remove');
			$(formPrepopulateDataContentTypeJEl).rules('remove');
			$(formPrepopulateDataAcceptJEl).rules('remove');
		};
		
		getIsPostDataChecked = function(){
			var isPostDataChecked = $(postDataBSJEl).is(':checked');
			if(isPostDataChecked){
				validatePostDataInBS();
			}else{
				unValidatePostDataInBS();
			}
		};
		
		getIsPrepopulateDataChecked = function(){
			var isCheckedPrepopulateData = $(populateDataBSJEl).is(':checked');
			if(isCheckedPrepopulateData){
				validatePrepopulateDataInBS();
			}else{
				unValidatePrepopulateDataInBS();
			}
		};
		
		initFormBasicSectionValidation = function(){
			$(postDataBSJEl).change(function(){
				getIsPostDataChecked();
			});
			
			$(populateDataBSJEl).change(function(){
				getIsPrepopulateDataChecked();
			});
		};
		
		validateFormVersion = function(){
			var ruleFields = new Object({}),
			messagesFields = new Object({});
		
			ruleFields[formVersionValidator] = {required : true};
			
			messagesFields[formVersionValidator] = {
				required : Liferay.Language.get('this-field-is-required')
			};
			
			$(formVersionJEl).validate({
			    errorElement: 'span',
			    errorClass:'help-block',
				rules : ruleFields,
				messages : messagesFields,
				errorPlacement: function (error, element) {
					if(element.hasClass('df-radio-field')){
						var parent = element.parent();
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(radioGroupSection).find('.input-group-error').append(error);
					}else{
						error.insertAfter(element);
					 }
				},
				highlight: function (element, errorClass) {
					if($(element).hasClass('df-radio-field')){
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
					if($(element).hasClass('df-radio-field')){
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
		};
		
		initFormBasicSectionEvents = function(){
			$(formBasicSectionSaveBtnJEl).click(function(){
				var formDefinitionId = $(formDefinitionIdJEl).val();
				console.log('FormDefinitionIdwhileInitializing: ',formDefinitionId)
				var formName = $(formNameJEl).val();
				var formNames = $(formNamesDataJEl).val();
				var formNamesArr = formNames.split(',');
				var inValidFormName = false;
				if(formNamesArr && formNamesArr.length > 0 && Number(formDefinitionId) == 0){
					inValidFormName = formNamesArr.includes(formName);
					if(inValidFormName){
						$(formBasicSectionErrAlertJEl).removeClass('d-none');
						$(formBasicSectionErrAlertJEl).addClass('d-block');
						$(formBasicSectionErrMsgJEl).html("<strong> Error : </strong>"+Liferay.Language.get('change-form-name'));
						return;
					}else{
						$(formBasicSectionErrAlertJEl).removeClass('d-block');
						$(formBasicSectionErrAlertJEl).addClass('d-none');
					}
				}
				var isValid  = $(formBasicSectionJEl).valid();
				if(isValid && !inValidFormName){
					$(formBasicSectionConfirmationModal).modal('show');
				}
			});
			
	        $(formBasicSectionConfirmationYesBtn).click(function(){
				var isValid = false;
				isValid = $(formVersionJEl).valid();
				if(isValid){
					saveBasicFormSectionData();
				}
				$(formBasicSectionConfirmationModal).modal('hide');
				$(formBasicSectionBtnJEl).addClass('active');
			});
	        
	        $(formBasicSectionConfirmationNoBtn).click(function(){
	        	$(formBasicSectionConfirmationModal).modal('hide');
			});
			
			
			$(formVersionSaveBtnJEl).click(function(){
				var isValid = false;
				isValid = $(formVersionJEl).valid();
				if(isValid){
					saveBasicFormSectionData();
				}
			});
			
			$(formSubmitBtnJEl).click(function(){
				$(formSubmitConfirmationModal).modal('show');
			});
			
			$(formSubmitConfirmationYesBtn).click(function(){
				setBasicFormAttrsInJson();
				saveFormData(SUBMIT_FORM);
			});
			
			$(formSubmitConfirmationNoBtn).click(function(){
				$(formSubmitConfirmationModal).modal('hide');
			});
			
			$(formFieldResetBtnConfirmationNoBtn).click(function(){
				$(formFieldResetBtnConfirmationModal).modal('hide');
			});
			
			$(formFieldResetBtnConfirmationYesBtn).click(function(){
				$(formFieldResetBtnConfirmationModal).modal('hide');
				$(formBasicSectionJEl).empty();
				createFormBasicSection();
				initInputTags(groupsDivJEl, groupsJEl);
				createGroupJSGrid();
			});
			
			$(formBasicSectionResetBtnJEl).click(function() {
				$(formFieldResetBtnConfirmationModal).modal('show');
			});
			
			$(formFieldResetBtnConfirmationModal).on('hidden.bs.modal', function (e) {
				$('body').addClass('modal-open');
			});
			
		};
		
		saveBasicFormSectionData = function(){
			var formFieldData = '';
			setBasicFormAttrsInJson();
			saveFormData(BASIC_SECTION_SAVE);
		};
		
		init = function(){
			initFormBasicSectionEvents();
			initFormBasicSectionValidation();
		};
		
		init();
		
		addFormBasicSectionConfig.validateFormBasicSection = validateFormBasicSection;
		addFormBasicSectionConfig.getIsPostDataChecked = getIsPostDataChecked;
		addFormBasicSectionConfig.getIsPrepopulateDataChecked = getIsPrepopulateDataChecked;
		addFormBasicSectionConfig.getKeyValueArr = getKeyValueArr;
		addFormBasicSectionConfig.getEncryptDecryptDataObj = getEncryptDecryptDataObj; 
	}
	
	function addFormFieldConfig(){
		
		var changeFieldLabel = Liferay.Language.get('change-field-label');
		validateFormField = function(){
			var ruleFields = new Object({}),
				messagesFields = new Object({});
			
			//addValidatorMethods();
            $.validator.addMethod("alphaNumeric", function(value, element) {
	            return /^[\w]+([-_\s]{1}[a-z0-9]+)*$/i.test( value );
	        });
          
            /*$.validator.addMethod("singleQuote", function(value, element) {
            	return /^[^'"]*$/.test( value );
            });*/
            
            $.validator.addMethod('greaterThan', function (value, element, param) {
				return this.optional(element) || parseInt(value) >= parseInt($(param).val());
			});
			
			$.validator.addMethod('smallerThan', function (value, element, param) {
				var maxValue = $(param).val() && $(param).val() != '' ? parseInt($(param).val()) : 0;
				var isValid = true;
				if(maxValue > 0){
					isValid = parseInt(value) < maxValue;
				}
				return this.optional(element) || isValid;
			});
          
            ruleFields[fieldKeyValidator] = {required : true, alphaNumeric: true};
            //ruleFields[fieldLabelValidator] = {required : true, maxlength:500, singleQuote: true};
            ruleFields[fieldLabelValidator] = {required : true, maxlength:500};
			ruleFields[fieldTypeValidator] = {required : true};
			ruleFields[fieldDataTypeValidator] = {required: true};
			ruleFields[fieldStatusValidator] = {required: true};
			
            messagesFields[fieldKeyValidator] = {
                required : Liferay.Language.get('this-field-is-required'),
                alphaNumeric: Liferay.Language.get('please-enter-only-alphanumeric-values')
            };
			messagesFields[fieldLabelValidator] = {
			    required : Liferay.Language.get('this-field-is-required'),
				maxlength : Liferay.Language.get('field-label-max-length-error-msg'),
                //singleQuote : Liferay.Language.get('single-quote-not-allowed')
			};
				
			messagesFields[fieldTypeValidator] = {
				maxlength : Liferay.Language.get('this-field-is-required')
			};
				
			messagesFields[fieldDataTypeValidator] = {
				required : Liferay.Language.get('this-field-is-required')
			};
			
			messagesFields[fieldStatusValidator] = {
				required : Liferay.Language.get('this-field-is-required')
			};
			
			$(formFieldJEl).validate({
			    errorElement: 'span',
			    errorClass:'help-block',
				rules : ruleFields,
				messages : messagesFields,
				errorPlacement: function (error, element) {
					if(element.hasClass('df-input-group-field')){
						var dfInputFormGroupEl = $(element).closest('.df-input-form-group');
					    $(dfInputFormGroupEl).find('.input-group-error').append(error);			 
					}else{
						error.insertAfter(element);
					}
				},
				highlight: function (element, errorClass) {
					if($(element).hasClass('df-radio-field')){
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(element).parent().addClass('has-error');
						$(radioGroupSection).find('.input-group-error').addClass('has-error');
					}else if($(element).hasClass('df-input-group-field')){
						var dfInputFormGroupEl = $(element).closest('.df-input-form-group');
						$(dfInputFormGroupEl).addClass('has-error');
						$(dfInputFormGroupEl).find('.df-input-group').addClass('has-error');
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
					if($(element).hasClass('df-radio-field')){
						var parent = $(element).parent();
						var radioGroupSection = $(element).closest('.radio-group-section');
						$(parent).removeClass('has-error');
						$(radioGroupSection).find('.input-group-error').empty();
						$(radioGroupSection).find('.input-group-error').removeClass('has-error');
					}else if($(element).hasClass('df-input-group-field')){
						var dfInputFormGroupEl = $(element).closest('.df-input-form-group');
						$(dfInputFormGroupEl).removeClass('has-error');
						$(dfInputFormGroupEl).find('.df-input-group').removeClass('has-error');
						$(dfInputFormGroupEl).find('.input-group-error').empty();
					}else{
						$(element).removeClass('error-field');
					}
				},
				submitHandler: function (form) {
					form.submit();
				}
			});
		};
		
		validateFieldPostData = function(){
			$(fieldPostDataNameJEl).rules('add', {
                required:true,
                maxlength:75,
                messages:{
                    required:Liferay.Language.get('this-field-is-required'),
                    maxlength:Liferay.Language.get('field-name-max-length-error-msg')
                }
            });
		};
		
		unValidateFieldPostData = function(){
			$(fieldPostDataNameJEl).rules('remove');
		};
		
		validateFieldPopulateData = function(){
			$(fieldPopulateDataNameJEl).rules('add', {
                required:true,
                maxlength:75,
                messages: {
                    required:Liferay.Language.get('this-field-is-required'),
                    maxlength:Liferay.Language.get('field-name-max-length-error-msg')
                }
            });
		};
		
		unValidateFieldPopulateData = function(){
			$(fieldPopulateDataNameJEl).rules('remove');
		};
		
		validateFieldReadFromReqParam = function(){
			$(fieldReadFromReqParamNameJEl).rules('add', {
                required:true,
                maxlength:75,
                messages: {
                    required:Liferay.Language.get('this-field-is-required'),
                    maxlength:Liferay.Language.get('field-name-max-length-error-msg')
                }
            });
		};
		
		unValidateFieldReadFromReqParam = function(){
			$(fieldReadFromReqParamNameJEl).rules('remove');
		};
		
		validateTextPlaceholder = function(){
			$(fieldPlaceholderJEl).rules('add', {
                maxlength:75,
                messages: {
                    maxlength:Liferay.Language.get('text-placeholder-max-length-error-msg')
                }
			});
		};
		
		validateTextAreaPlaceholder = function(){
			$(fieldPlaceholderJEl).rules('add', {
                maxlength:200,
                messages:{
                    maxlength:Liferay.Language.get('text-area-placeholder-max-length-error-msg')
                }
			});
		};
		
		unValidatePlaceholder = function(){
			$(fieldPlaceholderJEl).rules('remove');
		};
		
		validateMinAndMax = function(minNumberJEl, maxNumberJEl){
			$(minNumberJEl).rules('add', {
				required:true,
				min: 0,
				max: 1000,
				smallerThan: maxNumberJEl,
                messages:{
                	required:Liferay.Language.get('this-field-is-required'),
					min:Liferay.Language.get('min-number-mssg'),
               	 	max:Liferay.Language.get('max-number-mssg'),
               	 	smallerThan:Liferay.Language.get('min-must-be-smaller')
                }
			});
			$(maxNumberJEl).rules('add', {
				required:true,
				min: 0,
				max: 1000,
				greaterThan: minNumberJEl,
                messages:{
                	required:Liferay.Language.get('this-field-is-required'),
                	min:Liferay.Language.get('min-number-mssg'),
               	 	max:Liferay.Language.get('max-number-mssg'),
               	 	greaterThan:Liferay.Language.get('max-must-be-greater')
                }
			});
		};
		
		validateNumber = function(){
			validateMinAndMax(fieldMinNumberPlaceholderJEl, fieldMaxNumberPlaceholderJEl);
		};
		
		unValidateNumber = function(){
			$(fieldMinNumberPlaceholderJEl).rules('remove');
			$(fieldMinNumberPlaceholderJEl).rules('remove');
		};
		
		validateRangeBoundary = function(){
			validateMinAndMax(fieldMinBoundaryJEl, fieldMaxBoundaryJEl);
		};
		
		unValidateRangeBoundary = function(){
			$(fieldMinBoundaryJEl).rules('remove');
			$(fieldMaxBoundaryJEl).rules('remove');
		};
		
		validateHTMLEditor = function(){
			$(fieldHTMLEditorPlaceholderJEl).rules('add', {
                maxlength:2000,
                messages:{
                    maxlength:Liferay.Language.get('html-editor-max-length-error-msg')
                }
			});
		}; 
		
		unValidateHTMLEditor = function(){
			$(fieldHTMLEditorPlaceholderJEl).rules('remove');
		};
		
		validateFormatPlaceholder = function(){
			validateTextPlaceholder();
			$(fieldFormatPlaceholderJEl).rules('add', {
				required:true,
                messages:{
                	required:Liferay.Language.get('this-field-is-required')
                }
			});
		}
		
		validateMasterTable = function(){
			$(fieldMasterTableTextColumnJEl).rules('add', {
				required:true,
                messages:{
                	required:Liferay.Language.get('this-field-is-required')
                }
			});
			
			$(fieldMasterTableValueColumnJEl).rules('add', {
				required:true,
                messages:{
                	required:Liferay.Language.get('this-field-is-required')
                }
			});
			
			$(fieldMasterTableJEl).rules('add', {
				required:true,
                messages:{
                	required:Liferay.Language.get('this-field-is-required')
                }
			});
			
			$('input[name="'+fieldCreateMasterTableJEl+'"]').rules('add', {
				required:true,
                messages:{
                	required:Liferay.Language.get('this-field-is-required')
                }
			});
		}
		
		unValidateMasterTable = function(){
			$(fieldMasterTableTextColumnJEl).rules('remove');
			$(fieldMasterTableValueColumnJEl).rules('remove');
			$(fieldMasterTableJEl).rules('remove');
			$('input[name="'+fieldCreateMasterTableJEl+'"]').rules('remove');
		};
		
		unValidateFormatPlaceholder = function(){
			$(fieldFormatPlaceholderJEl).rules('remove');
		};
		
		validateDataProvider = function(){
			$(fieldDataProviderURLJEl).rules('add', {
                required:true,
                url2:true,
                messages: {
                    required:Liferay.Language.get('this-field-is-required'),
                    url2:Liferay.Language.get('please-enter-correct-url')
                }
            });
			
			$(fieldMethodTypesJEl).rules('add', {
                required:true,
                messages: {
                    required:Liferay.Language.get('this-field-is-required')
                }
            });
			
			$(dataProviderAcceptJEl).rules('add', {
                required:true,
                messages:{
                    required:Liferay.Language.get('this-field-is-required')
                }
            });
		};
		
		unValidateDataProvider = function(){
			$(fieldDataProviderURLJEl).rules('remove');
			$(fieldMethodTypesJEl).rules('remove');
			$(dataProviderAcceptJEl).rules('remove');
		};
		
		unValidateAllFieldsType = function(){
			unValidatePlaceholder();
			unValidateNumber();
			unValidateRangeBoundary();
			unValidateHTMLEditor();
			unValidateFormatPlaceholder();
			unValidateDataProvider();
			unValidateMasterTable();
		};
		
		formFieldJsonData =  function(){
			var formFieldSectionData = new Object({}), formFieldLabelData = new Object({});
			if($(fieldEnUsLabelJEl).val() != '') {
				formFieldLabelData["en_US"] = commonFc.escape($(fieldEnUsLabelJEl).val());
			} else {
				formFieldLabelData["en_US"] = commonFc.escape($(fieldLabelJEl).val());
			}
			formFieldLabelData["ar_SA"] = commonFc.escape($(fieldArSaLabelJEl).val());
			console.log('formFieldLabelData', formFieldLabelData);
			formFieldSectionData.label = formFieldLabelData;
			formFieldSectionData.key = $(fieldKeyJEl).val();
			return formFieldSectionData;
		};
		
		formFieldSettingData = function(){
			var isReadFromReqParamChecked, formFieldSettingSectionData = new Object({});
			formFieldSettingSectionData.type = $(fieldTypeJEl).val();
			formFieldSettingSectionData.dataType = $(fieldDataTypeJEl).val();
			formFieldSettingSectionData.status = $(fieldStatusJEl).val();
			formFieldSettingSectionData.readonly = $(fieldReadonlyJEl).is(":checked");
			formFieldSettingSectionData.disabled = $(fieldDisableJEl).is(":checked");
			formFieldSettingSectionData.required = $(fieldRequiredJEl).is(":checked");
			formFieldSettingSectionData.postData = $(fieldPostDataJEl).is(":checked");
			formFieldSettingSectionData.populateData = $(fieldPopulateDataJEl).is(":checked");
			formFieldSettingSectionData.readFromReqParam = $(fieldReadFromReqParamJEl).is(":checked");
			formFieldSettingSectionData.group = $(groupJEl).val();
			return formFieldSettingSectionData;
		};
		
		createPostDataObj = function(){
			var postDataObj, fieldName;
			
			postDataObj = new Object({});
			postDataObj.fieldName = $(fieldPostDataNameJEl).val();
			
			return postDataObj;
		};
		
		createPopulateDataObj = function(){
			var populateDataObj, fieldName;
			
			populateDataObj = new Object({});
			populateDataObj.fieldName = $(fieldPopulateDataNameJEl).val();
			
			return populateDataObj;
		};
		
		createReadFromReqParamObj = function(){
			var readFromReqParamObj, fieldName;
			
			readFromReqParamObj = new Object({});
			readFromReqParamObj.fieldName = $(fieldReadFromReqParamNameJEl).val();
			
			return readFromReqParamObj;
		};

		isSameFieldKey = function(key){
			var isSameKey = false, filteredKeyArr = [];
			
			if(formBuilderConfigJsonObj.fields && formBuilderConfigJsonObj.fields.length > 0){
				filteredKeyArr = formBuilderConfigJsonObj.fields.filter(field => field.key == key);
			}
			isSameKey = filteredKeyArr.length > 0 ? true : false;
			return isSameKey;
		};
		getNewSrNo = function(){
			var srNo, fieldsLen;
			fieldsLen = formBuilderConfigJsonObj.fields.length;
			srNo = fieldsLen + 1;
			return srNo;
		};
		getFieldObj = function(srNo){
			var fieldObj, formField;
			
			fieldObj = new Object({});
			formField = formFieldJsonData();
			
			fieldObj.srNo = srNo;
			fieldObj.label = formField.label;
			fieldObj.key = formField.key;
			
			for (var i in formBuilderConfigJsonObj.fields) {
		    	if (formBuilderConfigJsonObj.fields[i].srNo == srNo) {
		    		fieldObj.permissions = formBuilderConfigJsonObj.fields[i].permissions;
		        	break;
		     	}
		    }
			
			var isCheckedVisibleOn = $(fieldVisibleOnJEl).is(':checked');
			
			if(isCheckedVisibleOn){
				fieldObj.visibleOn = getVisibleOnObj();
			}
			
			return fieldObj;
		};
		
		getVisibleOnObj = function(){
			var visibleOnObj, fieldName, fieldValue;
			
			visibleOnObj = new Object({});
			visibleOnObj.fieldName = $(fieldVisibleOnDropdownJEl).val();
			visibleOnObj.fieldValue = $(fieldVisibleOnNameJEl).val();
			
			return visibleOnObj;
		};
		
		getFieldSettingsObj = function(){
			var settingsObj = new Object({});
			settingsObj = getGeneralFieldSettingObj(settingsObj);
			var fieldType =  settingsObj.type;
			var validationsJson = getExtraValidationJson();
			if(validationsJson && validationsJson.isValidationExists){
				settingsObj.validations = validationsJson.validations;
			}
			var isCheckedNewLine = $(fieldNewLineJEl).is(':checked');
			if(isCheckedNewLine){
				settingsObj.startNewLine = true;
			} else{
				settingsObj.startNewLine = false;
			}
			if(fieldType=='text' || fieldType =='textarea') {
				settingsObj.placeHolder = getPlaceholderFieldSetting();
			}else if(fieldType=='number' || fieldType=='rangePicker') {
				settingsObj.min = getMinNumberFieldSetting();
				settingsObj.max = getMaxNumberFieldSetting();
			}else if(fieldType=='date' || fieldType=='time' || fieldType=='datetime'){
				var dateConfig = new Object({});
				dateConfig.format = getDateFormatFieldSetting();
				settingsObj.dateConfig = dateConfig;
			}else if(fieldType == 'radio' || fieldType == 'checkbox'){
				var valuesAndDefaultSelectedObj = getCheckboxRadioFieldSetting(settingsObj);
				settingsObj.values = valuesAndDefaultSelectedObj.values;
				settingsObj.default_selected = valuesAndDefaultSelectedObj.default_selected;
			}else if(fieldType=='dropdown'){
				var selectedValue = $(fieldWhereToPopulateDropdownJEl).val();
				var isCheckedMultiSelect, isCheckedSearchable;
				isCheckedMultiSelect = $(fieldMultiselectDropdownCheckboxJEl).is(':checked');
				isCheckedSearchable = $(fieldSearchableDropdownCheckboxJEl).is(':checked');
				if(isCheckedMultiSelect){
					settingsObj.multiselect = true;
				} else{
					settingsObj.multiselect = false;
				}
				if(isCheckedSearchable){
					settingsObj.searchable = true;
				} else{
					settingsObj.searchable = false;
				}
				if(selectedValue == 'staticValues'){
					console.log('staticValues in setting Obj');
					settingsObj.values = getStaticValuesFieldSetting(settingsObj);
				}else if(selectedValue == 'dependentFields'){
					console.log('dependentFields in setting Obj');
					var selectedDependentField = $(fieldWhereToPopulateDependentFieldsJEl).val();
					var isDfDataProvider = true;
					if(selectedDependentField == 'staticValues'){
						settingsObj.dependency = getDependentFieldStaticValuesSetting();
					}else if(selectedDependentField == 'dataProvider'){
						settingsObj.dependency = getDependentFieldDataProviderSetting(isDfDataProvider);
					}
				}else if(selectedValue == 'dataProvider'){
					console.log('dataProvider in setting Obj');
					settingsObj.dataProvider = getDataProviderFieldSetting();
				} else if (selectedValue == 'masterTable'){
					var createNewMappingTable, createFormMappingsTable, obj, isFormMappings;
					for(var i = 0;i < formBuilderConfigJsonObj.fields.length; i++){
						obj = formBuilderConfigJsonObj.fields[i];
						if(obj.settings.hasOwnProperty('master')){
							isFormMappings = obj.settings.master.createFormMappingsTable;
							console.log('JSON OBj >>> ',formBuilderConfigJsonObj.isFormMappings);
						}
					}
					createNewMappingTable = $('input[name="'+fieldCreateMasterTableJEl+'"]:checked').val();
					if(createNewMappingTable == 'yes'){
						createNewMappingTable = true;
						createFormMappingsTable = false;
					} else if(createNewMappingTable == 'no' && !isFormMappings) {
						createNewMappingTable = false;
						createFormMappingsTable = true;
					} else if(createNewMappingTable == 'no' && isFormMappings) {
						createNewMappingTable = false;
						createFormMappingsTable = false;
					}
					settingsObj.master = getMasterTableFieldSetting(createNewMappingTable, createFormMappingsTable);
				}
			}else if(fieldType=='html'){
				settingsObj.placeHolder = getHTMLPlaceholderFieldSetting();
			}else if(fieldType=='file'){
				settingsObj.multiple = getIsFileMultipleFieldSetting();
			}else if(fieldType == 'readonly'){
				console.log('ReadOnly');
			}else if(fieldType == 'range'){
				var rangeConfig = new Object({});
				settingsObj.rangeConfig = getRangeFieldSetting(fieldType);
			}else if(fieldType=='password'){
				console.log('Password');
			}else if(fieldType == 'customRange'){
				var customRangeConfig = new Object({});
				settingsObj.customRangeConfig = getRangeFieldSetting(fieldType);
			}
			return settingsObj;
		};
		
		getGeneralFieldSettingObj = function(settingsObj){
			var formFieldSetting = formFieldSettingData();
			settingsObj.type = formFieldSetting.type; 
			settingsObj.dataType = formFieldSetting.dataType;
			settingsObj.status = formFieldSetting.status;
			settingsObj.readonly = formFieldSetting.readonly;
			settingsObj.disabled = formFieldSetting.disabled;
			settingsObj.required = formFieldSetting.required;
			if(formFieldSetting.postData){
				settingsObj.postData = createPostDataObj();
			}
			if(formFieldSetting.populateData){
				settingsObj.populateData = createPopulateDataObj();
			}
			if(formFieldSetting.readFromReqParam){
				settingsObj.readFromReqParam = createReadFromReqParamObj();
			}
			settingsObj.group = formFieldSetting.group;
			return settingsObj;
		};
		
		getPlaceholderFieldSetting= function(){
			var placeholder = new Object({});
			if($(fieldEnUsPlaceholderJEl).val() != '') {
				placeholder["en_US"] = $(fieldEnUsPlaceholderJEl).val();
			} else {
				placeholder["en_US"] = $(fieldPlaceholderJEl).val();
			}
			placeholder["ar_SA"] =  $(fieldArSaPlaceholderJEl).val();
			return placeholder;
		};
		
		getIsFileMultipleFieldSetting = function(){
			var isFileMultiple;
			isFileMultiple = $(fieldMultipleFileUploadJEl).is(":checked");
			return isFileMultiple
		};
		
		getDateFormatFieldSetting = function(){
			var format;
			format = $(fieldFormatPlaceholderJEl).val();
			return format;
		};
		
		getCheckboxRadioFieldSetting = function(settingsObj){
			var jsCheckboxRadioDataArray; 
			var valuesAndDefaultObj = new Object({});
			if(isJSGrid){
				jsCheckboxRadioDataArray = $(fieldDisplayCheckboxRadioJSGridJEl).jsGrid('option','data');
				var checkboxRadioValues = [];
				$.each(jsCheckboxRadioDataArray, function(index, obj) {
				  var values = {
				    "en_US": obj.en_US,
				    "ar_SA": obj.ar_SA,
				    "default_selected": obj.default_selected
				  };

				  checkboxRadioValues.push(values);
				});
				valuesAndDefaultObj.values = checkboxRadioValues;
			}  
			return valuesAndDefaultObj;
		};
		
		getRangeFieldSetting = function(fieldType){
			var rangeData, rangeConfigObj = new Object({});
			rangeData = getRangeData(fieldType);
			return rangeData;
		};
		
		getRangeData = function(fieldType){
			var groupAverage, overallAverage, groupTotal, rangeComment, rangeTotalCharacter, overallTotal, boundaries, rangeData = new Object({}), rangeCommentData = new Object({});
			rangeData.groupAverage = $(fieldGroupAverageJEl).is(":checked");
			rangeData.overallAverage = $(fieldOverallAverageJEl).is(":checked");
			rangeData.groupTotal = $(groupTotalJEl).is(":checked");
			rangeData.overallTotal = $(overallTotalJEl).is(":checked");
			rangeData.isRangeComment = $(isRangeCommentJEl).is(":checked");
			rangeCommentData.en_US = $(fieldEnUsRangeCommentJEl).val();
			rangeCommentData.ar_SA = $(fieldArSaRangeCommentJEl).val();
			rangeData.rangeComment = rangeCommentData;
			rangeData.rangeTotalCharacter = $(rangeTotalCharacterJEl).is(":checked");
			rangeData.maxRangeCharacter = $(rangeMaxCharacterJEl).val();
			if(fieldType == 'range'){
				rangeData.boundaries = getRangeBoundaries();
				rangeData.options = getRangeOptions();
			}else if(fieldType == 'customRange'){
				selectedRangeOptionMaster = $(rangeOptionNameDrJEl).find('option:selected').val();
				if(selectedRangeOptionMaster){
					rangeData.rangeOptionMaster = $(rangeOptionNameDrJEl).val();
				}
				rangeData.boundaries = getCustomRangeBoundaries();
				rangeData.options = getCustomRangeOptions();
			}
			return rangeData;
		};
		
		getRangeBoundaries = function(){
			var minBoundary, maxBoundary,  boundariesArr = [];
			minBoundary = $(fieldMinBoundaryJEl).val();
			maxBoundary = $(fieldMaxBoundaryJEl).val();
			boundariesArr.push(minBoundary);
			boundariesArr.push(maxBoundary);
			return boundariesArr;
		};
		
		getRangeOptions = function(){
			var jsRangeDataArray; 
			var valuesAndDefaultObj = new Object({});
			if(isJSGrid){
				jsRangeDataArray = $(fieldDisplayRangeJSGridJEl).jsGrid('option','data');
				var rangeValues = [];
				$.each(jsRangeDataArray, function(index, obj) {
				  var rangeName = {
				    "en_US": obj.en_US,
				    "ar_SA": obj.ar_SA
				  };
				  var options = {
					 "name": rangeName,
					 "value": ""
				  };
				  rangeValues.push(options);
				});
				valuesAndDefaultObj.options = rangeValues;
				$(fieldRangeOptionsConfigTbodyJEl + ' tr').each(function(index){
					var optionsValue = $(this).find("td").eq(1).html();
					rangeValues[index].value = optionsValue;
				});
				
				console.log('rangeValues >>> ', rangeValues);
			}  
			return rangeValues;
		};
		
		getCustomRangeBoundaries = function(){
			var minBoundary, maxBoundary, boundariesArr=[];
			if(isJSGrid){
				jsCustomRangeDataArray = $(fieldDisplayCustomRangeJSGridJEl).jsGrid('option','data');
				var customRangeBoundariesArr = [];
				$.each(jsCustomRangeDataArray, function(index, obj) {
					if(obj.value > -1){
						customRangeBoundariesArr.push(obj.value);
					}
				});
				console.log("customRangeBoundariesArr: ",customRangeBoundariesArr);
				minBoundary = Math.min(...customRangeBoundariesArr);
				maxBoundary = Math.max(...customRangeBoundariesArr);
				if(jsCustomRangeDataArray){
					boundariesArr.push(minBoundary);
					boundariesArr.push(maxBoundary);
				}
			}
			return boundariesArr;
		};
		
		getCustomRangeOptions = function(){
			var jsCustomRangeDataArray; 
			var valuesAndDefaultObj = new Object({});
			if(isJSGrid){
				jsCustomRangeDataArray = $(fieldDisplayCustomRangeJSGridJEl).jsGrid('option','data');
				var customRangeValues = [];
				$.each(jsCustomRangeDataArray, function(index, obj) {
				  var rangeName = {
				    "en_US": obj.en_US,
				    "ar_SA": obj.ar_SA
				  };
				  var options = {
					 "name": rangeName,
					 "value": obj.value
				  };
				  customRangeValues.push(options);
				});
				valuesAndDefaultObj.options = customRangeValues;
				console.log('customRangeValues >>> ', customRangeValues);
			}  
			return customRangeValues;
		};
		
		getMinNumberFieldSetting = function(){
			var minNumber;
			minNumber = $(fieldMinNumberPlaceholderJEl).val();
			return minNumber;
		};
		
		getMaxNumberFieldSetting = function(){
			var maxNumber;
			maxNumber = $(fieldMaxNumberPlaceholderJEl).val();
			return maxNumber;
		};
		
		getHTMLPlaceholderFieldSetting = function(){
			var placeholder = new Object({});
			if($(fieldEnUsHTMLEditorPlaceholderJEl).val() != '') {
				var toEncryptDataObj = getEncryptDecryptDataObj($(fieldEnUsHTMLEditorPlaceholderJEl).val());
				var encryptedDescription = commonFc.encryptData(toEncryptDataObj);
				placeholder["en_US"] = encryptedDescription;
			} else if($(fieldHTMLEditorPlaceholderJEl).summernote('code') != '') {
				var toEncryptDataObj = getEncryptDecryptDataObj($(fieldHTMLEditorPlaceholderJEl).summernote('code'));
				var encryptedDescription = commonFc.encryptData(toEncryptDataObj);
				placeholder["en_US"] = encryptedDescription;
			} else {
				
				placeholder["en_US"] = '';
			}

			if($(fieldArSaHTMLEditorPlaceholderJEl).val() != '') {
				var toEncryptDataObj = getEncryptDecryptDataObj($(fieldArSaHTMLEditorPlaceholderJEl).val());
				var encryptedDescription = commonFc.encryptData(toEncryptDataObj);
				placeholder["ar_SA"] = encryptedDescription;
			} else {
				placeholder["ar_SA"] = '';
			}

			return placeholder;
		};
		
		getStaticValuesFieldSetting = function(){
			var jsStaticDropdownDataArray; 
			if(isJSGrid){
				jsStaticDropdownDataArray = $(fieldDisplayDropdownStaticJSGridJEl).jsGrid('option','data');
				var dropdownValues = [];
				$.each(jsStaticDropdownDataArray, function(index, obj) {
				  var values = {
					"en_US": obj.en_US,
					"ar_SA": obj.ar_SA
				  };
				  dropdownValues.push(values);
				});
			}  
			return dropdownValues;
		};
		
		getDependentFieldStaticValuesSetting = function(){
			var dependencyObj = new Object({});
			
			dependencyObj.fieldName = $(fieldDependentFieldsNameJEl).val();
			dependencyObj.fieldValues = getStaticDependentFieldValues();
			return dependencyObj;
		};
		
		getStaticDependentFieldValues = function(){
			var fieldValuesObj, fieldValues = [];
			$('.static-custom-input').each(function(i, obj) {
			   fieldValuesObj = new Object({});
			   fieldValuesObj.fieldValue = dependentStaticFieldValue(dfStaticInputJEl+ (i+1));
			   fieldValuesObj.displayValues = dependentStaticValues(fieldDFStaticValuesJSGridJEl+ (i+1));
			   fieldValues.push(fieldValuesObj);
			});
			return fieldValues;
		};
		
		dependentStaticFieldValue = function(elJEl){
			fieldValueObj = new Object({});
			fieldValueObj.en_US = $(elJEl).prop('placeholder');
			fieldValueObj.ar_SA = $(elJEl).attr('ar_placeholder');
			return fieldValueObj;
		};
		
		dependentStaticValues = function(elJEl){
			var jsStaticDFArray; 
			if(isJSGrid){
				jsStaticDFArray = $(elJEl).jsGrid('option','data');
				var staticDFValues = [];
				$.each(jsStaticDFArray, function(index, obj) {
				  var displayValues = {
					"en_US": obj.en_US,
					"ar_SA": obj.ar_SA
				  };
				  staticDFValues.push(displayValues);
				});
			}  
			return staticDFValues;
		};
		
		getDependentFieldDataProviderSetting = function(isDfDataProvider){
			var dependencyObj = new Object({});
			
			dependencyObj.fieldName = $(fieldDependentFieldsNameJEl).val();
			dependencyObj.dataProvider = getDataProviderFieldSetting(isDfDataProvider);
			
			return dependencyObj;
		};
		
		getMasterTableFieldSetting = function(createNewMappingTable, createFormMappingsTable){
			var masterTableDropdownObj = new Object({});
			masterTableDropdownObj.masterTable = $(fieldMasterTableJEl).val();
			masterTableDropdownObj.textColumn = $(fieldMasterTableTextColumnJEl).val();
			masterTableDropdownObj.valueColumn = $(fieldMasterTableValueColumnJEl).val();
			masterTableDropdownObj.createNewMappingTable = createNewMappingTable;
			masterTableDropdownObj.createFormMappingsTable = createFormMappingsTable;
			
			return masterTableDropdownObj;
		}
		
		getDataProviderFieldSetting = function(isDfDataProvider){
			console.log('isDfDataProvider: ',isDfDataProvider);
			var methodType, dataPropsValues, dataProviderObj = new Object({});
			dataProviderObj.url = $(fieldDataProviderURLJEl).val();
			methodType = $(fieldMethodTypesJEl).val();
			dataProviderObj.method = methodType;
			if(methodType == 'post'){
				dataProviderObj.contentType = $(fieldContentTypesJEl).val();
			}
			dataProviderObj.property = $(fieldDataProviderURLPropertyJEl).val();
			console.log('DataProperty: ',$(fieldDataProviderURLPropertyJEl).val());
			dataProviderObj.dataProps = getValuesArr(fieldDataPropsJEl); 
			if(isDfDataProvider){
				dataProviderObj.sourceProps = getValuesArr(fieldSourcePropsJEl);
			}
			dataProviderObj.accept = $(dataProviderAcceptJEl).val();
			dataProviderObj.headers = getKeyValueArr(dataProviderHeadersJEl);
			dataProviderObj.params = getKeyValueArr(dataProviderParamsJEl);
			
			return dataProviderObj;
		};
		
		getValuesArr = function(elJEl){
			var values, valuesArr = [];
			values= JSON.parse($(elJEl).val());
			for(const key of values) {
				valuesArr.push(key.value);
			}
			return valuesArr;
		};
		
		initFormFieldsEvents = function(){
			$(formFieldConfirmationYesBtn).click(function(){
				var isFieldEditable = $(isFieldEditJEl).val() == 'true' ? true : false;
				var editSrNo = $(fieldEditSrNoJEl).val();
				
				if(formBuilderConfigJsonObj.name){
					var srNo, isSameKey = false;
					if(isFieldEditable && editSrNo && parseInt(editSrNo) && (parseInt(editSrNo) > 0)){
						srNo = parseInt(editSrNo);
					}else{
						srNo = getNewSrNo();
					}
					var fieldObj = getFieldObj(srNo);
					var settingsObj = getFieldSettingsObj();
					
					fieldObj.settings = settingsObj;
	
					if(isFieldEditable){
						updateFieldObjInJSON(fieldObj);
						updateRowInDataTable(fieldObj);
					}else{
						addFieldObjInJSON(fieldObj);
						addRowInDataTable(fieldObj);
					}
					console.log("formBuilderConfigJsonObj: ", formBuilderConfigJsonObj);
					$(formFieldConfirmationModal).modal('hide');
					saveFormData(FIELDS_SECTION_SAVE, fieldObj);
					toggleFormFieldAndSubmitBtn();
					$(formFieldBtnJEl).addClass('active');
				}else{
					// error message
				}
				/*$(formFieldJEl).each(function(){
				    //this.reset();
				});*/ 
			});
			
			$(formFieldSaveBtnJEl).click(function(){
				var isValid = $(formFieldJEl).valid();
				var isValidInputTags = validateInputTags(fieldValuesInputTagJEl, '.values-input-tag-label');
				var isValidRangeInputTags = validateInputTags(fieldRangeOptionsJEl, '.range-options-el');
				var isValidDropdownStaticValuesInputTags = validateInputTags(fieldDisplayDropdownStaticJSGridJEl, '.static-values-input-tag-el');
				var isValidDataPropsInputTags = validateDataProps();
				var isValidFieldLabel = validateFieldLabel();
				
				if(isValid && isValidInputTags && isValidFieldLabel && isValidDataPropsInputTags){
					$(formFieldConfirmationModal).modal('show');
				}
			});
			
			validateDataProps = function(){
				var length = $('.data-props-label:visible').length;
				var formGroupDiv = $(fieldDataPropsJEl).parent('div');
				if(length && $("tag").length <= 0){
					var inputTagsErrDivEl = commonFc.createDivEl('d-none', 'inputTagsErr');
					$(formGroupDiv).addClass('has-error');
					$(formGroupDiv).append(inputTagsErrDivEl);
					$(inputTagsErrDivEl).addClass('help-block');
					$(inputTagsErrDivEl).removeClass('d-none');
					$(inputTagsErrDivEl).addClass('d-block');
					$(inputTagsErrDivEl).html(Liferay.Language.get('this-field-is-required'));
					return false;
				}
				return true;
			};
			
			validateInputTags = function(elJEl, elClass){
				var length = $(elClass+':visible').length;
				var formGroupDiv = $(elJEl).parent('div');
				if(length && $("tag").length <= 0){
					var inputTagsErrDivEl = commonFc.createDivEl('d-none', 'inputTagsErr');
					$(formGroupDiv).addClass('has-error');
					$(formGroupDiv).append(inputTagsErrDivEl);
					$(inputTagsErrDivEl).addClass('help-block');
					$(inputTagsErrDivEl).removeClass('d-none');
					$(inputTagsErrDivEl).addClass('d-block');
					$(inputTagsErrDivEl).html(Liferay.Language.get('this-field-is-required'));
					return false;
				}
				return true;
			};
			
			validateFieldLabel = function(){
				var isFieldAdded = false;
				var isFieldEditable = $(isFieldEditJEl).val() == 'true' ? true : false;
				var editSrNo = $(fieldEditSrNoJEl).val();
				
				//Column Already Exist in DB Error
				var columnNames = $(columnNamesDataJEl).val();
				var columnNamesArr;
				
				if(columnNames){
					columnNamesArr = columnNames.split(',');
				}
				var inValidFieldName = false;
				
				if(columnNamesArr && columnNamesArr.length > 0){
					var srNo, isSameKey = false;
					if(isFieldEditable && editSrNo && parseInt(editSrNo) && (parseInt(editSrNo) > 0)){
						srNo = parseInt(editSrNo);
					}else{
						isFieldAdded = true;
						srNo = getNewSrNo();
					}
					var fieldObj = getFieldObj(srNo);
					
					if(isFieldAdded){
						isSameKey = isSameFieldKey(fieldObj.key);
						inValidFieldName = columnNamesArr.includes(fieldObj.key);
					}
					
					if(isSameKey || inValidFieldName){
						console.log('same key');
						$(formFieldErrJEl).removeClass('d-none');
						$(formFieldErrJEl).addClass('d-block');
						$(formFieldErrorAlertJEl).html("<strong> Error : </strong>"+changeFieldLabel);
						return false;
					}
					$(formFieldErrJEl).removeClass('d-block');
					$(formFieldErrJEl).addClass('d-none');
				}
				return true;
			};
			
			$(formReorderSaveChangesBtnJEl).click(function(){
				$(reOrderConfirmModalJEl).modal('show');
			});
			
			$(reOrderConfirmModalSaveBtnJEl).click(function(){
				saveFormData(REORDER_SECTION_SAVE);
			});
			
			$(reOrderConfirmModalCancelBtnJEl).click(function(){
				$(reOrderConfirmModalJEl).modal('hide');
			});
			
			$(deleteFormFieldModalSaveBtnJEl).click(function(){
				var isFieldDeletable = $(isFieldDeleteJEl).val() == 'true' ? true : false;
				var deleteSrNo = $(fieldDeleteSrNoJEl).val();
				var srNo;
				if(isFieldDeletable && deleteSrNo && parseInt(deleteSrNo) && parseInt(deleteSrNo) > 0){
					srNo = parseInt(deleteSrNo);
				}
				if(srNo > 0){
					deleteFieldObjInJSON(srNo);
					deleteRowInDataTable();
					saveFormData(DELETE_SECTION_SAVE);
				}
			});
			
			$(deleteFormFieldModalCancelBtnJEl).click(function(){
				$(deleteFormFieldModalJEl).modal('hide');
			});
			
			$(formFieldConfirmationNoBtn).click(function(){
				$(formFieldConfirmationModal).modal('hide');
			});
			
			$(formFieldResetBtnConfirmationNoBtn).click(function(){
				$(formFieldResetBtnConfirmationModal).modal('hide');
			});
			
			$(formFieldResetBtnConfirmationYesBtn).click(function(){
				$(formFieldResetBtnConfirmationModal).modal('hide');
				$(formFieldJEl).empty();
				createFormFieldConfig();
				initFormFieldsValidation();
				if(formBuilderConfigJsonObj.groups){
					if(formBuilderConfigJsonObj.groups.length > 0){
						$(displayGroupJEl).removeClass('d-none');
						$(displayGroupJEl).addClass('d-block');
						populateGroups();
					}
				}
				checkBoxVisibleOn();
				$(rangeTotalCharacterJEl).attr('disabled', true);
			});
			
			$(formFieldResetBtnJEl).click(function() {
				$(formFieldResetBtnConfirmationModal).modal('show');
			});
			
			$(formFieldConfirmationModal).on('hidden.bs.modal', function (e) {
				$('body').addClass('modal-open');
			});
			
			$(formBasicSectionConfirmationModal).on('hidden.bs.modal', function (e) {
				$('body').addClass('modal-open');
			});
			
			$(formFieldResetBtnConfirmationModal).on('hidden.bs.modal', function (e) {
				$('body').addClass('modal-open');
			});
			
		};
		
		unValidateInputTags = function(elJEl){
			var formGroupDiv = $(elJEl).parent('div');
			$(formGroupDiv).removeClass('has-error');
			$(inputTagsErrJEl).removeClass('help-block');
			$(inputTagsErrJEl).removeClass('d-block');
			$(inputTagsErrJEl).addClass('d-none');
		};
		
		initFormFieldsValidation = function(){
			$(fieldValuesInputTagJEl).on('add', function(e){
				unValidateInputTags(fieldValuesInputTagJEl);
			});
			
			$(fieldRangeOptionsJEl).on('add', function(e){
				unValidateInputTags(fieldRangeOptionsJEl);
			});
			
			$(fieldDisplayDropdownStaticJSGridJEl).on('add', function(e){
				unValidateInputTags(fieldDisplayDropdownStaticJSGridJEl);
			});
			
			$(fieldPostDataJEl).change(function(){
				var isFieldPostDataChecked = $(fieldPostDataJEl).is(':checked')
				if(isFieldPostDataChecked){
					validateFieldPostData();
				}else{
					unValidateFieldPostData();
				}
	        });
			
			$(fieldPopulateDataJEl).change(function(){
				var isFieldPopulateData = $(fieldPopulateDataJEl).is(':checked')
				if(isFieldPopulateData){
					validateFieldPopulateData();
				}else{
					unValidateFieldPopulateData();
				}
	        });
			
			$(fieldReadFromReqParamJEl).change(function(){
				var isFieldReadFromReqParam = $(fieldReadFromReqParamJEl).is(':checked');
				if(isFieldReadFromReqParam){
					validateFieldReadFromReqParam();
				}else{
					unValidateFieldReadFromReqParam();
				}
	        });
			
			$(fieldTypeJEl).change(function(){
				var selectedField;
				unValidateAllFieldsType();
				$(inputTagsErrJEl).remove();
				selectedField = $(fieldTypeJEl).find('option:selected').val();
				console.log('selectedField', selectedField);
				
				if(selectedField=='text') {
					validateTextPlaceholder();
				}else if(selectedField=='textarea') {
					validateTextAreaPlaceholder();
				}else if(selectedField=='number' || selectedField == 'rangePicker') {
					validateNumber();
				}else if(selectedField=='date' || selectedField=='time' ||  selectedField=='datetime'){
					validateFormatPlaceholder();
				}else if(selectedField=='html'){
					validateHTMLEditor();
				}else if(selectedField == 'range'){
					validateRangeBoundary();
				}
	        });
		};
		
		init = function(){
			initFormFieldsValidation();
			initFormFieldsEvents();
		};
		
		init();
		
		dfPortlet.addFormFieldConfig.validateFormField = validateFormField;
	}
	
	function commonFormFc(){
		
		toggleFormFieldAndSubmitBtn = function(){
			console.log('id -- ', $(formDefinitionIdJEl).val());
        	if($(formDefinitionIdJEl).val() != ''){
        		if(formBuilderConfigJsonObj && formBuilderConfigJsonObj.hasOwnProperty('fields') && formBuilderConfigJsonObj.fields && formBuilderConfigJsonObj.fields.length > 0){
        			$(formSubmitBtnJEl).attr('disabled', false);
        			$(formFieldBtnJEl).attr('disabled', false);
        			
        			$(formFieldBtnJEl).addClass('active');
        			$(formBasicSectionBtnJEl).addClass('active');
        		}else {
        			$(formSubmitBtnJEl).attr('disabled', true);
        			$(formFieldBtnJEl).attr('disabled', false);
        			$(formFieldBtnJEl).removeClass('active');
        			$(formBasicSectionBtnJEl).addClass('active');
        		}
        	} else {
        		$(formFieldBtnJEl).attr('disabled', true);
        		$(formSubmitBtnJEl).attr('disabled', true);
        		$(formFieldBtnJEl).removeClass('active');
    			$(formBasicSectionBtnJEl).removeClass('active');
        	}
        }
		
		getUpdatedFormFields = function(){
			var dtData = $(formDataTableJEl).DataTable().rows().data();
			var fields = [];
			dtData.each(function (value, index) {
			  var rowValObj = value;
			  var fieldObj = rowValObj.fieldJSONObj;
			  fieldObj.srNo = rowValObj.srNo;
			  fields.push(fieldObj);
			});
			return fields;
		};
		saveFormData = function(actionType, fieldObj){
			var toEncryptDataObj = new Object({});
			toEncryptDataObj.secretPassphrase = secretPassphrase;
			formBuilderConfigJsonObj.fields = getUpdatedFormFields();
			toEncryptDataObj.text = JSON.stringify(formBuilderConfigJsonObj);
			var encrytedData = commonFc.encryptFormDataRequest(toEncryptDataObj);
			$(formEncryptedDataJEl).val(encrytedData);
			var formEncryptedData = $(formEncryptedDataJEl).val();
			var formVersionData = $("input:radio[name ="+ formVersionDataName +"]:checked").val();
			var formDefinitionId = $(formDefinitionIdJEl).val();
			console.log('formVersionData', formVersionData);
			console.log("saveFormConfigurationResourceURL:", saveFormConfigurationResourceURL);
			var reloadPage = !formDefinitionId && actionType == SUBMIT_FORM;
			$.ajax({
				url: saveFormConfigurationResourceURL,
				method : 'POST',
				data: {
					[namespace + 'encryptedFormData']: formEncryptedData,
					[namespace + 'formVersionData']: formVersionData,
					[namespace + 'formDefinitionId']: formDefinitionId,
					[namespace + 'actionType']: actionType
				},
				success:function(response){
					console.log('Success');
					if(actionType == BASIC_SECTION_SAVE){
						$(formBasicSectionModalJEl).modal('hide');
						$(formBasicSectionSuccessAlertJEl).removeClass('d-none');
						$(formBasicSectionSuccessAlertJEl).addClass('d-block');
                        setTimeout(function(){
                            $(formBasicSectionSuccessAlertJEl).removeClass('d-block').addClass('d-none');
                        },1000);
					}else if(actionType == FIELDS_SECTION_SAVE){
						$(formFieldModalJEl).modal('hide');
						$(formBasicSectionSuccessAlertJEl).removeClass('d-none');
						$(formBasicSectionSuccessAlertJEl).addClass('d-block');
						setTimeout(function(){
                            $(formBasicSectionSuccessAlertJEl).removeClass('d-block').addClass('d-none');
                        },1000);
					}else if(actionType == REORDER_SECTION_SAVE){
						$(reOrderConfirmModalJEl).modal('hide');
						$(formReorderSaveChangesBtnJEl).hide();
						$(formBasicSectionSuccessAlertJEl).removeClass('d-none');
						$(formBasicSectionSuccessAlertJEl).addClass('d-block');
						setTimeout(function(){
                            $(formBasicSectionSuccessAlertJEl).removeClass('d-block').addClass('d-none');
                        },1000);
					}else if(actionType == DELETE_SECTION_SAVE){
						$(deleteFormFieldModalJEl).modal('hide');
						$(formBasicSectionSuccessAlertJEl).removeClass('d-none');
						$(formBasicSectionSuccessAlertJEl).addClass('d-block');
						setTimeout(function(){
                            $(formBasicSectionSuccessAlertJEl).removeClass('d-block').addClass('d-none');
                        },1000);
					}
					var res = $.parseJSON(response);
					if(res.status == 'success'){
						formDefinitionId = res.formDefinitionId;
						formDefinitionWorkflowStatus = res.formDefinitionWorkflowStatus;
						console.log("formDefinitionWorkflowStatus in success", formDefinitionWorkflowStatus);
						console.log('formDefinitionId in success',formDefinitionId);
						if(formDefinitionWorkflowStatus == 6){
							$(formBasicSectionSaveBtnSpanJEl).html(Liferay.Language.get("resubmit"));
						}else{
							$(formBasicSectionSaveBtnSpanJEl).html(Liferay.Language.get("save"));
						}
						$(formDefinitionIdJEl).val(formDefinitionId);
						toggleFormFieldAndSubmitBtn();
						if(res.isPageReload){
							window.location.href = themeDisplay.getLayoutURL();
						}
					}
					if(res.columnNames){
						$(columnNamesDataJEl).val(res.columnNames);
					}
					$(isFieldEditJEl).val(false);
					$(fieldEditSrNoJEl).val('');
					editedRowEl = '';
					$(isFieldDeleteJEl).val(false);
					$(fieldDeleteSrNoJEl).val('');
					deletedRowEl = '';
				}
				
			});
		};
		
		dfPortlet.commonFormFc.saveFormData = saveFormData;
	};

	htmlEditorChangeEvent = function(curElId) {
		var currentSelectedLocale = $("#" + curElId + "SelectedLocale").attr('language-id');
		$("#" + curElId + "_" + currentSelectedLocale).val($("#" + curElId).summernote('code'));
	};
	
	function addRangeOption(config){
		var namespace = config.namespace,
			contextPath = config.contextPath,
			configRangeOptionBtnJEl = config.configRangeOptionBtnJEl,
			rangeOptionModalJEl = config.rangeOptionModalJEl,
			rangeOptionModalBodyJEL = config.rangeOptionModalBodyJEL,
			rangeOptionNameValidator = config.rangeOptionNameValidator,
			rangeOptionFormJEl = config.rangeOptionFormJEl,
			rangeOptionSaveBtnJEl = config.rangeOptionSaveBtnJEl,
			rangeOptionsJSGridJEl = config.rangeOptionsJSGridJEl,
			encryptedRangeOptionsDataJEl = config.encryptedRangeOptionsDataJEl,
			secretPassphrase = config.secretPassphrase,
			rangeOptionNames = config.rangeOptionNames ? config.rangeOptionNames : "",
			rangeOptionNamesDataJEl = config.rangeOptionNamesDataJEl,
			rangeOptionNameErrJEl = config.rangeOptionNameErrJEl,
			rangeOptionNameerrorBasicAlertJEl = config.rangeOptionNameerrorBasicAlertJEl,
			rangeOptionNameJEl = config.rangeOptionNameJEl,
			addRangeOptionBtnJEl = config.addRangeOptionBtnJEl,
			rangeOptionsDataTableJEl = config.rangeOptionsDataTableJEl,
			getRangeOptionsURL = config.getRangeOptionsURL,
			rangeOptionIdJEl = config.rangeOptionIdJEl,
			rangeOptionResetBtnJEl = config.rangeOptionResetBtnJEl;
			dataTable = '';
		
		createRangeOptionSection = function(){
			var mainFormRowEl, mainFormColEl, rangeOptionNameRowEl, rangeOptionNameColEl, rangeOptionNameSectionEl, rangeOptionsRowEl, rangeOptionsColEl, rangeOptionsSectionEl;
			
			mainFormRowEl = commonFc.createDivEl('row hide rangeOptionRow');
			mainFormColEl = commonFc.createDivEl('col-lg-12 col-md-12 col-sm-12 col-xs-12');
			
			rangeOptionNameRowEl = commonFc.createDivEl('row');
			rangeOptionNameColEl = commonFc.createDivEl('col-lg-3 col-md-3 col-sm-12 col-xs-12');
			rangeOptionNameSectionEl = createRangeOptionNameField();
			
			rangeOptionsRowEl = commonFc.createDivEl('row');
			rangeOptionsColEl = commonFc.createDivEl('col-lg-8 col-md-8 col-sm-12 col-xs-12');
			rangeOptionsSectionEl = createRangeOptionsJSGrid();
			
			$(rangeOptionNameColEl).append(rangeOptionNameSectionEl);
			$(rangeOptionNameRowEl).append(rangeOptionNameColEl);
			$(mainFormColEl).append(rangeOptionNameRowEl);
			
			$(rangeOptionsColEl).append(rangeOptionsSectionEl);
			$(rangeOptionsRowEl).append(rangeOptionsColEl);
			$(mainFormColEl).append(rangeOptionsRowEl);
			
			$(mainFormRowEl).append(mainFormColEl);
			$(rangeOptionFormJEl).append(mainFormRowEl);
		};
		
		createRangeOptionNameField = function(){
			var rangeOptionNameLabelEl, rangeOptionNameInputEl, formGroupDivEl;
			rangeOptionNameLabelEl = commonFc.createLabel('rangeOptionName', Liferay.Language.get('range-option-name'), 'range-option-name-label');
			requiredEl = commonFc.createEm('*');
			rangeOptionNameInputEl = commonFc.createInputTextEl('form-control range-option-name-input-el', 'rangeOptionName');
			formGroupDivEl = commonFc.createDivEl('form-group');
			
			$(rangeOptionNameLabelEl).append(requiredEl);
			$(formGroupDivEl).append(rangeOptionNameLabelEl);
			$(formGroupDivEl).append(rangeOptionNameInputEl);
			
			return formGroupDivEl;
		};
		
		createRangeOptionsJSGrid = function(){
			var rangeOptionsLabelEl, rangeOptionsJSGridEl, formGroupDivEl, rangeOptions;
			rangeOptionsLabelEl = commonFc.createLabel('rangeOptions', Liferay.Language.get('range-options'));
			rangeOptionsJSGridEl = commonFc.createDivEl('range-options-div-el', 'rangeOptionsJSGrid');
			formGroupDivEl = commonFc.createDivEl('form-group');
			rangeOptions = commonFc.getCustomRangeFieldsArr();
			$(formGroupDivEl).append(rangeOptionsLabelEl);
			$(formGroupDivEl).append(rangeOptionsJSGridEl);
			isJSGrid = commonFc.initJsGrid(rangeOptionsJSGridEl, rangeOptions, isJSGrid);
			return formGroupDivEl;
		};
		
		getRangeOptions = function(){
			var jsRangeOptionsDataArray; 
			var valuesAndDefaultObj = new Object({});
			if(isJSGrid){
				jsRangeOptionsDataArray = $(rangeOptionsJSGridJEl).jsGrid('option','data');
				var rangeOptionsValues = [];
				$.each(jsRangeOptionsDataArray, function(index, obj) {
				  var rangeName = {
					"en_US": obj.en_US,
					"ar_SA": obj.ar_SA
				  };
				  var options = {
					 "name": rangeName,
					 "value": obj.value
				  };
				  rangeOptionsValues.push(options);
				});
				valuesAndDefaultObj.options = rangeOptionsValues;
				console.log('rangeOptionsValues >>> ', rangeOptionsValues);
			}  
			return rangeOptionsValues;
		};
		
		getEncryptedRangeOptionsData = function(){
			var toEncryptDataObj = new Object({});
			toEncryptDataObj.secretPassphrase = secretPassphrase;
			toEncryptDataObj.text = JSON.stringify(getRangeOptions());
			var encrytedData = commonFc.encryptFormDataRequest(toEncryptDataObj);
			$(encryptedRangeOptionsDataJEl).val(encrytedData);
		};
		
		validateRangeOption = function(){
			var ruleFields = new Object({}),
				messagesFields = new Object({});
			
			ruleFields[rangeOptionNameValidator] = {required : true, maxlength:50};
			
			messagesFields[rangeOptionNameValidator] = {
				required : Liferay.Language.get('this-field-is-required'),
				maxlength : Liferay.Language.get('range-option-name-max-length-error-msg'),
			};
			
			$(rangeOptionFormJEl).validate({
				errorElement: 'span',
				errorClass:'help-block',
				rules : ruleFields,
				messages : messagesFields,
				errorPlacement: function (error, element) {
					error.insertAfter(element);
				},
				highlight: function (element, errorClass) {
					$(element).parent().addClass('has-error');
					$(element).addClass('error-field');
				},
				unhighlight: function(element, errorClass, validClass) {
				},
				success: function (error, element) {
					error.remove();
					$(element).removeAttr('aria-describedby');
					$(element).parent().removeClass('has-error');
					$(element).removeClass('error-field');
				},
				submitHandler: function (form) {
					form.submit();
				}
			});
		};
		
		populateRangeData = function(data){
			if(data){
				var rangeOptions = JSON.parse(data.rangeOptions);
				$(rangeOptionNameJEl).val(data.rangeOptionName);
				if(rangeOptions && rangeOptions.length > 0){
					commonFc.populateCustomRangeJSGrid(rangeOptions, rangeOptionsJSGridJEl);
				}
			}
		};
		
		onEditRangeOption = function(encryptedData){
			console.log("Editing Range Option");
			var decryptedData = decodeURIComponent(escape(window.atob(encryptedData)));
			var data = JSON.parse(decryptedData);
			if(data){
				$(rangeOptionIdJEl).val(data.rangeOptionId);
				$(rangeOptionNameJEl).data('existingRangeName', data.rangeOptionName);
				populateRangeData(data);
				$(rangeOptionFormJEl).valid();
				$('.rangeOptionRow').removeClass('hide');
				$('.rangeOptionRow').addClass('show');
			}
		};
		
		initRangeOptionsDataTable = function(){
			dataTable = null;
			var length = 5, aLengthMenu = [ [10], [10] ];
			dataTable = $(rangeOptionsDataTableJEl).DataTable( {
				"autoWidth": false,
				"destroy": true,
				"processing": true,
				"serverSide": false,
				"lengthChange": false,
				//"dom": 'rt<"bottom"lp><"clear">',
				"aLengthMenu": aLengthMenu,
				"ordering": false,
				"searching": true,
				"iDisplayLength" : length,
				"ajax": {
					"url": getRangeOptionsURL,
					"type": "POST",
					"dataType" : 'json',
					"dataSrc": function(result){
						var list = [];
						if(result && result.status == 'success'){
							list = JSON.parse(result.data);
							console.log("Range Options Data: ",result.data);
						}
						return list;
					}
				},
				'rowId': 'extn',
				"columns": [
					{ "data": "srNo" , "name": "srNo"},
					{ "data": "rangeOptionName" , "name": "rangeOptionName"},
					{ "data": "createdby" , "name": "createdby"},
					{ "data": "createddate" , "name": "createddate"},
					{ "data": "modifiedby" , "name": "modifiedby"},
					{ "data": "modifieddate" , "name": "modifieddate"},
					{ 
			    		"data": "action", 
			    		"name": "action",
			    		"render": function(data, type, row, meta){
			    			var encryptedData = window.btoa(unescape(encodeURIComponent((JSON.stringify(row)))));
							data = '<td>' +
				     					'<a class="ml-1 mr-3" onClick="onEditRangeOption(\'' + encryptedData + '\' )" href="javascript:void(0);"><span><i class="fa fa-pencil"></i></span></a>' +
				     			   '</td>';
							return data;
				        } 	
			    	}
				],
				'language': {
					 "processing": Liferay.Language.get('no-range-options-found-mssg'),
					 "emptyTable": Liferay.Language.get('datatable-processing')
			    },
			 });
		};
		resetRangeOption = function(){
			$(rangeOptionIdJEl).val('');
			$(rangeOptionNameJEl).val('');
			$(rangeOptionsJSGridJEl).jsGrid("option", "data", []);
		};
		
		initEvent = function(){
			$(configRangeOptionBtnJEl).click(function(){
				resetRangeOption();
				$('.rangeOptionRow').removeClass('show');
				$('.rangeOptionRow').addClass('hide');
				validateRangeOption();
				$(rangeOptionNamesDataJEl).val(rangeOptionNames);
				$(rangeOptionModalJEl).modal('show');
				console.log("Range Options Names: ", $(rangeOptionNamesDataJEl).val());
				initRangeOptionsDataTable();
			});
			
			$(addRangeOptionBtnJEl).click(function(){
				resetRangeOption();
				$('.rangeOptionRow').removeClass('hide');
				$('.rangeOptionRow').addClass('show');
			});
			
			$(rangeOptionResetBtnJEl).click(function(){
				resetRangeOption();
			});
			
			$(rangeOptionSaveBtnJEl).click(function(){
				var isValid = $(rangeOptionFormJEl).valid();
				var existingRangeName = $(rangeOptionNameJEl).data('existingRangeName');
				var newRangeName =  $(rangeOptionNameJEl).val();
				var rangeOptionId = $(rangeOptionIdJEl).val;
				var validRangeOptionName = true;
				$(rangeOptionNameErrJEl).removeClass('d-block');
				$(rangeOptionNameErrJEl).addClass('d-none');
				if(newRangeName && rangeOptionNames && rangeOptionNames.length > 0 && (existingRangeName != newRangeName)){
					var alreadyExist = rangeOptionNames.includes($(rangeOptionNameJEl).val());
					if(alreadyExist){
						$(rangeOptionNameErrJEl).removeClass('d-none');
						$(rangeOptionNameErrJEl).addClass('d-block');
						$(rangeOptionNameerrorBasicAlertJEl).html("<strong> Error : </strong>"+Liferay.Language.get('change-range-option-name'));
						validRangeOptionName = false;
					}
				}
				if(isValid && validRangeOptionName){
					var encryptedRangeOptionsData = getEncryptedRangeOptionsData();
					console.log('encryptedRangeOptionsData :: ',encryptedRangeOptionsData);
					/*if(encryptedRangeOptionsData != null && encryptedRangeOptionsData != undefined && encryptedRangeOptionsData != ''){
						$(rangeOptionFormJEl).submit();
					} else{
						alert("Data cannot be submitted due to empty Range Options JSGRid.");
					}*/
					$(rangeOptionFormJEl).submit();
				}
			});
		};
		
		init = function() {
			commonFc.initConfigVars(new Object({namespace : namespace, themeImagesPath : themeImagesPath, languageId : Liferay.ThemeDisplay.getLanguageId()}));
	    	initEvent();
	    	createRangeOptionSection();
        };
       
        init();
	};
	
	dfPortlet.initVars = initVars;
	dfPortlet.viewDFConfig = viewDFConfig;
	dfPortlet.addFormBasicSectionConfig = addFormBasicSectionConfig;
	dfPortlet.addFormFieldConfig = addFormFieldConfig;
	dfPortlet.commonFormFc = commonFormFc;
	dfPortlet.htmlEditorChangeEvent = htmlEditorChangeEvent;
	dfPortlet.addRangeOption = addRangeOption;
	
})($, (window.dfPortlet = window.dfPortlet || {}));