<%@page import="java.util.Locale"%>
<%@ include file="init.jsp" %>

<style>
	h4 label {
		font-size: 20px !important;
		font-weight: 700 !important;
	}
</style>
<portlet:renderURL var="viewLogProceduresURL">
    <portlet:param name="jspPage" value="<%= OmsbLogProceduresConstants.VIEW_PROCEDURES_JSP %>"/>
</portlet:renderURL>

<portlet:resourceURL id="<%= OmsbLogProceduresConstants.FETCH_PG_CPT_CODE_PROCEDURE_RESOURCE_COMMAND %>" var="fetchPgCptCodesProcedures">
</portlet:resourceURL>

<portlet:resourceURL id="<%= OmsbLogProceduresConstants.FETCH_TRAINING_SITE_RESOURCE_COMMAND %>" var="fetchTrainingSite">
</portlet:resourceURL>

<portlet:actionURL name="<%= OmsbLogProceduresConstants.ADD_LOG_PROCEDURE_ACTION_COMMAND %>" var="addLogProcedureURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<liferay-ui:error key="log-procedure-required" message="please.add.log.procedure" />

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<aui:form action="${addLogProcedureURL}" name="fm">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					<div class="pagetitle">${program.getProgramName(locale)}</div>
					<div class="information">
						<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_LOG_PROCEDURE)}">
							<a href="${viewLogProceduresURL}"><aui:button type="button" value="view-my-procedures" cssClass="btn omsb-bc-red-button"></aui:button></a>
						</c:if>
					</div>
				</div>
			</div>
			
			<h4 class="form-title"><liferay-ui:message key="patient-info" /></h4>
			<div class="row m-0">
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label for="<portlet:namespace/>patientId">
							<liferay-ui:message key="patient-id" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<input class="form-control required-field" type="text" id="<portlet:namespace/>patientId" name="<portlet:namespace/>patientId" ignoreRequestValue="true" onkeyup="validateField($(this))"/>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control" label="patient-gender" id="patientGender" name="patientGender">
                        	<aui:option value=""><liferay-ui:message key="please-select-patient-gender" /></aui:option>
                        	<c:forEach items="${genderMasters}" var="genderMaster">
								<aui:option value="${genderMaster.genderMasterId}">
									${genderMaster.getGenderName(themeDisplay.getLanguageId())}
								</aui:option>
							</c:forEach>
						</aui:select>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control js-basic-single" label="patient-type" id="patientType" name="patientType">
                        	<aui:option value=""><liferay-ui:message key="please-select-patient-type" /></aui:option>
                        	<c:forEach items="${patientTypeMasters}" var="patientTypeMaster">
								<aui:option value="${patientTypeMaster.patientTypeMasterId}">
									${patientTypeMaster.getPatientTypeName(themeDisplay.getLanguageId())}
								</aui:option>
							</c:forEach>
						</aui:select>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control js-basic-single" label="visit-type" id="visitType" name="visitType">
                        	<aui:option value=""><liferay-ui:message key="please-select-visit-type" /></aui:option>
                        	<c:forEach items="${visitTypeMasters}" var="visitTypeMaster">
								<aui:option value="${visitTypeMaster.visitTypeMasterId}">
									${visitTypeMaster.getVisitTypeName(themeDisplay.getLanguageId())}
								</aui:option>
							</c:forEach>
						</aui:select>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label for="<portlet:namespace/>dateOfBirth">
							<liferay-ui:message key="date-of-birth" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<input class="form-control required-field" type="text" id="<portlet:namespace/>dateOfBirth" name="<portlet:namespace/>dateOfBirth" ignoreRequestValue="true" onchange="validateField($(this))"/>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label for="<portlet:namespace/>datePerformed">
							<liferay-ui:message key="date-performed" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<input class="form-control required-field" type="text" id="<portlet:namespace/>datePerformed" name="<portlet:namespace/>datePerformed" ignoreRequestValue="true" onchange="getTrainingSiteDetail(this); validateField($(this))" />
					</div>
				</div>
			</div>
			<h4 class="omsb-card-title"><liferay-ui:message key="log-procedures" />
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_LOG_PROCEDURE)}">
					<button class="btn omsb-bg-red-button" id="add-new-log-procedure-btn" data-toggle="modal" data-target="#addsupportingdocument" type="button">					
						<liferay-ui:message key="add-procedure" />
					</button>
				</c:if>
			</h4>
			
			<div class="d-none">
			
				<aui:select cssClass="custom-select form-control" label="cpt-code" id="defaultCptCode" name="defaultCptCode">
                	<aui:option value=""><liferay-ui:message key="please-select-cpt-code" /></aui:option>
                   	<c:forEach items="${cptCodeMasters}" var="cptCodeMaster">
						<aui:option value="${cptCodeMaster.key}">
							${cptCodeMaster.value}
						</aui:option>
					</c:forEach>
				</aui:select>
				
				<aui:select cssClass="custom-select form-control" label="procedure-group" id="defaultProcedureGroup" name="defaultProcedureGroup">
                      	<aui:option value=""><liferay-ui:message key="please-select-procedure-group" /></aui:option>
                      	<c:forEach items="${procedureGroupMasters}" var="procedureGroupMaster">
						<aui:option value="${procedureGroupMaster.procedureGroupMasterId}">
							${procedureGroupMaster.getProcedureGroupName(themeDisplay.getLanguageId())}
						</aui:option>									
					</c:forEach>
				</aui:select>
				
				<aui:select cssClass="custom-select form-control" label="procedure" id="defaultProcedure" name="defaultProcedure">
					<aui:option value=""><liferay-ui:message key="please-select-procedure" /></aui:option>
					<c:forEach items="${procedureMasters}" var="procedureMaster">
						<aui:option value="${procedureMaster.procedureMasterId}">
							${procedureMaster.getProcedureName(themeDisplay.getLanguageId())}
						</aui:option>									
					</c:forEach>
				</aui:select>
				
				<aui:select cssClass="custom-select form-control case-location-option" label="case-location" id="defaultCaseLocation" name="defaultCaseLocation">
                   	<aui:option value=""><liferay-ui:message key="please-select-case-location" /></aui:option>
				</aui:select>
				
				<aui:select cssClass="custom-select form-control js-basic-single" label="role-type" id="defaultRoleType" name="defaultRoleType">
                   	<aui:option value=""><liferay-ui:message key="please-select-role-type" /></aui:option>
                   	<c:forEach items="${roleTypeMasters}" var="roleTypeMaster">
						<aui:option value="${roleTypeMaster.roleTypeMasterId}">
							${roleTypeMaster.getRoleTypeName(themeDisplay.getLanguageId())}
						</aui:option>									
					</c:forEach>
				</aui:select>
				
				<aui:select cssClass="custom-select form-control" label="supervisor" id="defaultSupervisor" name="defaultSupervisor">
                    <aui:option value=""><liferay-ui:message key="please-select-supervisor" /></aui:option>
                    <c:forEach items="${supervisors}" var="supervisor">
						<aui:option value="${supervisor.userId}">
							${supervisor.getFullName()}
						</aui:option>									
					</c:forEach>
				</aui:select>
			
			</div>

			<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">				
				<h4 class="omsb-card-title"><liferay-ui:message key="procedure" />
					<button class="btn omsb-bg-red-button remove-procedure-btn d-none" id="removeProcedureBtn-1" data-index="1" data-toggle="modal" 
					 data-target="#addsupportingdocument" type="button" onclick="removeLogProcedure(this)">					
						<liferay-ui:message key="remove-procedure" />
					</button>
				</h4>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12">
						<aui:select cssClass="custom-select form-control js-basic-single" label="cpt-code" id="cptCode-1" name="cptCode-1"
						 onChange="updatePGProcedures(this)">
                        	<aui:option value=""><liferay-ui:message key="please-select-cpt-code" /></aui:option>
                        	<c:forEach items="${cptCodeMasters}" var="cptCodeMaster">
								<aui:option value="${cptCodeMaster.key}">
									${cptCodeMaster.value}
								</aui:option>
							</c:forEach>
						</aui:select>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control js-basic-single" label="procedure-group" id="procedureGroup-1" name="procedureGroup-1" onChange="updateCPTCodeProcedures(this)">
	                        	<aui:option value=""><liferay-ui:message key="please-select-procedure-group" /></aui:option>
	                        	<c:forEach items="${procedureGroupMasters}" var="procedureGroupMaster">
									<aui:option value="${procedureGroupMaster.procedureGroupMasterId}">
										${procedureGroupMaster.getProcedureGroupName(themeDisplay.getLanguageId())}
									</aui:option>									
								</c:forEach>
							</aui:select>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>procedure-1">
								<liferay-ui:message key="procedure" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<select class="custom-select form-control required-field js-basic-single" id="<portlet:namespace/>procedure-1"
								name="<portlet:namespace/>procedure-1" onchange="updateCPTCodePG(this)">
								<aui:option value=""><liferay-ui:message key="please-select-procedure" /></aui:option>
								<c:forEach items="${procedureMasters}" var="procedureMaster">
									<aui:option value="${procedureMaster.procedureMasterId}">
										${procedureMaster.getProcedureName(themeDisplay.getLanguageId())}
									</aui:option>									
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<h4 class="omsb-card-title mt-3 mb-0">
						<label for="<portlet:namespace/>diagnosis-1">
							<liferay-ui:message key="diagnosis" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
					</h4>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<div class="countryFlagWrap">
								<input class="cst-control required-optional" type="hidden" id="<portlet:namespace/>diagnosisUS-1" name="<portlet:namespace/>diagnosisUS-1" value="" data-name="diagnosis" data-index="1"></input>
					    		<input class="cst-control" type="hidden" id="<portlet:namespace/>diagnosisSA-1" name="<portlet:namespace/>diagnosisSA-1" value=""></input>
								<textarea id="<portlet:namespace/>diagnosis-1" name="<portlet:namespace/>diagnosis-1" class="form-control"></textarea>
								<div id="languageTagDiagnosis-1" class="cstFlag" data-input-name="country"
									data-selected-country="US" data-button-size="btn-lg"
									data-scrollable="true" data-scrollable-height="250px" data-name="diagnosis" data-index="1">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<h4 class="omsb-card-title mt-4 mb-0"><liferay-ui:message key="additional-info" /></h4>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control case-location-option" label="case-location" id="caseLocation-1" name="caseLocation-1">
	                        	<aui:option value=""><liferay-ui:message key="please-select-case-location" /></aui:option>
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>roleType-1">
								<liferay-ui:message key="role-type" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<select class="custom-select form-control js-basic-single required-field" id="<portlet:namespace/>roleType-1"
								name="<portlet:namespace/>roleType-1" onchange="validateField($(this))">
								<aui:option value=""><liferay-ui:message key="please-select-role-type" /></aui:option>
	                        	<c:forEach items="${roleTypeMasters}" var="roleTypeMaster">
									<aui:option value="${roleTypeMaster.roleTypeMasterId}">
										${roleTypeMaster.getRoleTypeName(themeDisplay.getLanguageId())}
									</aui:option>									
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label for="<portlet:namespace/>supervisor-1">
								<liferay-ui:message key="supervisor" />
								<span class="reference-mark text-warning">
									<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
										<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
									</svg>
								</span>
							</label>
							<select class="custom-select form-control required-field" id="<portlet:namespace/>supervisor-1"
								name="<portlet:namespace/>supervisor-1" onchange="validateField($(this))">
								<aui:option value=""><liferay-ui:message key="please-select-supervisor" /></aui:option>
	                        	<c:forEach items="${supervisors}" var="supervisor">
									<aui:option value="${supervisor.userId}">
										${supervisor.getFullName()}
									</aui:option>									
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<h4 class="omsb-card-title mt-4 mb-0"><label for="<portlet:namespace/>comments-1"><liferay-ui:message key="comments" /></h4>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<div class="countryFlagWrap">
								<input class="cst-control" type="hidden" id="<portlet:namespace/>commentsUS-1" name="<portlet:namespace/>commentsUS-1" value=""></input>
					    		<input class="cst-control" type="hidden" id="<portlet:namespace/>commentsSA-1" name="<portlet:namespace/>commentsSA-1" value=""></input>
								<textarea id="<portlet:namespace/>comments-1" name="<portlet:namespace/>comments-1" class="form-control"></textarea>
								<div id="languageTagComments-1" class="cstFlag" data-input-name="country"
									data-selected-country="US" data-button-size="btn-lg"
									data-scrollable="true" data-scrollable-height="250px" data-name="comments" data-index="1">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<input type="hidden" id="<portlet:namespace/>procedure-count" name="<portlet:namespace/>proceduresCount" value="1" />
		
			<div class="bottom-backbtn-wrap">
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_LOG_PROCEDURE)}">
					<button class="btn omsb-bc-red-button validate-form-button" type="button" title="Save" ><liferay-ui:message key="save" /></button>
				</c:if>
				<a href="${currentUrl}" class="btn omsb-bc-red-button reset-form" title="Cancel" ><liferay-ui:message key="reset" /></a>
				<button id="formSubmitButton" class="d-none" type="submit"/>
			</div>
			
			</aui:form>
		</div>
	</div>
</div>

<script>

function validateField(field) {
	if(field.val().trim()) {
		$('#'+field.attr('id')+'Helper').remove();
	}
}

function setCommentCKEditor(name) {
    setTimeout(function() {
    	CKEDITOR.replace(name);
    	CKEDITOR.config.width = '100%';
    	CKEDITOR.instances[name].config.toolbar = [
       	  	['Undo', 'Redo'],
            ['Format'],
            ['Bold', 'Italic', 'Underline'],
            ['NumberedList', 'BulletedList'],
            ['Link', 'Unlink'],
            ['Table','Image'],
            ['Source']
        ];
    	CKEDITOR.instances[name].on('change', function() {
	    	let parts = $(this).attr('name').split('-');
	    	let name = parts[0].split('_').pop();
	    	let index = parts[1];
    		$('#<portlet:namespace/>'+name+'US-'+index+'Helper').remove();
    	});
    }, 100);
}

$(document).ready(function () {
	
 	$(".js-basic-single").select2();

	$('.cstFlag').flagStrap({
		countries: {
		"US": "en-US",
		"SA": "ar-SA"
		},
	    onSelect: function (value, element) {
	    	if(element.dataset.pre != value) {
	    		selectChanged(element.parentNode.dataset.name, element.parentNode.dataset.index, value);
	    		element.setAttribute('data-pre', element.value);
	    	}
	    }
	});
	
	$('.reset-form').on('click', function() {
		$(".help-block").remove();

		let procedureCount = $("#<portlet:namespace/>procedure-count").val();
				
		for(var i = 1 ; i<=parseInt(procedureCount); i++) {
			$('#<portlet:namespace/>diagnosisUS-'+i).val('');
			$('#<portlet:namespace/>diagnosisSA-'+i).val('');
			$('#<portlet:namespace/>diagnosis-'+i).val('');
			CKEDITOR.instances['<portlet:namespace/>diagnosis-'+i].setData('');
			
			$('#<portlet:namespace/>commentsUS-'+i).val('');
			$('#<portlet:namespace/>commentsSA-'+i).val('');
			$('#<portlet:namespace/>comments-'+i).val('');
			CKEDITOR.instances['<portlet:namespace/>comments-'+i].setData('');
		}
	});

	$('.validate-form-button').on('click', function() {
		$(".help-block").remove();
		var isValidate = true;
	 	$("[name='country']").each(function() {
	 		let name = $(this).parent().data("name");
	 		let index = $(this).parent().data("index");
	 		let langValue = $(this).val();
	 		$('#<portlet:namespace/>'+name+langValue+'-'+index).val(CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].getData());
		});

	 	$('.required-field').each(function() {
	 		if(!$(this).val().trim()) {
	 			let fieldName = $("label[for='"+$(this).attr('name')+"']").text().trim();
	 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
	 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${fieldName} field is required." /></div>
	 			</div>`
	 			$(this).closest('.form-group').append(errorMsg);
	 			isValidate = false;
	 		}
	 	});
	 	
	 	$('.required-optional').each(function() {
	 	    var name = $(this).data('name');
	 	    var index = $(this).data('index');
			if((!$('#<portlet:namespace/>'+name+'US-'+index).val().trim()) && (!$('#<portlet:namespace/>'+name+'SA-'+index).val().trim())) {
	 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
	 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${name} field is required." /></div>
	 			</div>`;
	 			$(this).closest('.form-group').append(errorMsg);
	 			isValidate = false;
			}
	 	});

		if(isValidate) {
			$('#formSubmitButton').click();
		}
	});

	document.querySelectorAll('[name="country"]').forEach(element => {
	  	element.setAttribute('data-pre', element.value);
	});

	setCommentCKEditor('<portlet:namespace/>comments-1');
	setCommentCKEditor('<portlet:namespace/>diagnosis-1');
	
	
	function selectChanged(name, index, langValue) { 
		var editorData = CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].getData();
		if(langValue == 'US') {
			$('#<portlet:namespace/>'+name+'SA-'+index).val(editorData);
    		CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].config.contentsLangDirection = 'ltr';
			CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].setData($('#<portlet:namespace/>'+name+langValue+'-'+index).val());
		} else if (langValue == 'SA') {
			$('#<portlet:namespace/>'+name+'US-'+index).val(editorData);
    		CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].config.contentsLangDirection = 'rtl';
			CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].setData($('#<portlet:namespace/>'+name+langValue+'-'+index).val());
		}
	}

	let currentDate = new Date();
    $( "#<portlet:namespace/>dateOfBirth" ).datepicker({
        format: 'dd-mm-yyyy',
        startDate: new Date('1900-1-1'),
        autoclose: true,
        todayBtn: true,
        todayHighlight: true,
        endDate:currentDate,
        maxDate:currentDate
    });

    $( "#<portlet:namespace/>datePerformed" ).datepicker({
        format: 'dd-mm-yyyy',
        startDate: new Date('1900-1-1'),
        autoclose: true,
        todayBtn: true,
        todayHighlight: true,
        endDate:currentDate,
        maxDate:currentDate
    });
	
	$("#add-new-log-procedure-btn").click(function() {
		
		var procedureCount = $("#<portlet:namespace/>procedure-count").val();
		var updatedProcedureCount = parseInt(procedureCount)+1;
		$("#<portlet:namespace/>procedure-count").val(updatedProcedureCount);
		
		var html = '<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">' +
		'	<h4 class="omsb-card-title"><liferay-ui:message key="procedure" />' +
		'		<button class="btn omsb-bg-red-button remove-procedure-btn" id="removeProcedureBtn-' + updatedProcedureCount + '" data-index="' + updatedProcedureCount + '" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeLogProcedure(this)">' +
		'			<liferay-ui:message key="remove-procedure" />' +
		'		</button>' +
		'	</h4>' +
		'	<div class="row">' +
		'		<div class="col-lg-4 col-md-4 col-sm-12">' +
		'			<div class="form-group">' +
		'				<label for="<portlet:namespace/>cptCode-' + updatedProcedureCount + '"><liferay-ui:message key="cpt-code" /></label>' +
		'				<select name="<portlet:namespace/>cptCode-' + updatedProcedureCount + '" id="<portlet:namespace/>cptCode-' + updatedProcedureCount + '" onchange="updatePGProcedures(this)" class="custom-select form-control js-basic-single">' +
		'				</select>' +
		'			</div>' +
		'		</div>' +
		'		<div class="col-lg-4 col-md-4 col-sm-12">' +
		'			<div class="form-group">' +
		'				<label for="<portlet:namespace/>procedureGroup-' + updatedProcedureCount + '"><liferay-ui:message key="procedure-group" /></label>' +
		'				<select name="<portlet:namespace/>procedureGroup-' + updatedProcedureCount + '" id="<portlet:namespace/>procedureGroup-' + updatedProcedureCount + '" onchange="updateCPTCodeProcedures(this)" class="custom-select form-control js-basic-single">' +
		'				</select>' +
		'			</div>' +
		'		</div>' +
		'		<div class="col-lg-4 col-md-4 col-sm-12">' +
		'			<div class="form-group">' +
		'				<label for="<portlet:namespace/>procedure-' + updatedProcedureCount + '">' +
		'					<liferay-ui:message key="procedure" />' +
		'						<span class="reference-mark text-warning">' +
		'							<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">' +
		'								<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>' +
		'							</svg>' +
		'						</span>' +
		'				</label>' +
		'				<select name="<portlet:namespace/>procedure-' + updatedProcedureCount + '" id="<portlet:namespace/>procedure-' + updatedProcedureCount + '" onchange="updateCPTCodePG(this)" class="custom-select form-control required-field js-basic-single">' +
		'				</select>' +
		'			</div>' +
		'		</div>' +
		'	</div>' +
		'	<div class="form-group">' +
		'		<h4 class="omsb-card-title mt-3 mb-0">' +
		'			<label for="<portlet:namespace/>diagnosis-' + updatedProcedureCount + '">' +
		'				<liferay-ui:message key="diagnosis" />' +
		'				<span class="reference-mark text-warning">' +
		'					<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">' +
		'						<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>' +
		'					</svg>' +
		'				</span>' +
		'			</label>' +
		'		</h4>' +
		'	</div>' +
		'	<div class="row">' +
		'		<div class="col-md-12">' +
		'			<div class="form-group">' +
		'				<div class="countryFlagWrap">' +
		'					<input class="cst-control required-optional" type="hidden" id="<portlet:namespace/>diagnosisUS-' + updatedProcedureCount +'" name="<portlet:namespace/>diagnosisUS-' + updatedProcedureCount +'" value="" data-name="diagnosis" data-index="' + updatedProcedureCount + '"></input> ' +
		'	    			<input class="cst-control" type="hidden" id="<portlet:namespace/>diagnosisSA-' + updatedProcedureCount +'" name="<portlet:namespace/>diagnosisSA-' + updatedProcedureCount +'" value=""></input>' +
		'					<textarea id="<portlet:namespace/>diagnosis-' + updatedProcedureCount +'" name="<portlet:namespace/>diagnosis-' + updatedProcedureCount +'" class="form-control"></textarea>' +
		'					<div id="languageTagDiagnosis-' + updatedProcedureCount + '" class="cstFlag" data-input-name="country"' +
		'						data-selected-country="US" data-button-size="btn-lg"' +
		'						data-scrollable="true" data-scrollable-height="250px" data-name="diagnosis" data-index="' + updatedProcedureCount +'">' +
		'					</div>' +
		'				</div>' +
		'			</div>' +
		'		</div>' +
		'	</div>' +
		'	<div class="form-group">' +
		'		<h4 class="omsb-card-title mt-4 mb-0"><liferay-ui:message key="additional-info" /></h4>' +
		'	</div>' +
		'	<div class="row">' +
		'		<div class="col-lg-6 col-md-6 col-sm-12">' +
		'			<div class="form-group">' +
		'				<label for="<portlet:namespace/>caseLocation-' + updatedProcedureCount + '"><liferay-ui:message key="case-location" /></label>' +
		'				<select name="<portlet:namespace/>caseLocation-' + updatedProcedureCount + '" id="<portlet:namespace/>caseLocation-' + updatedProcedureCount + '" class="custom-select form-control case-location-option">' +
		'				</select>' +
		'			</div>' +
		'		</div>' +
		'		<div class="col-lg-6 col-md-6 col-sm-12">' +
		'			<div class="form-group">' +
		'				<label for="<portlet:namespace/>roleType-' + updatedProcedureCount + '">' +
		'					<liferay-ui:message key="role-type" />' +
		'						<span class="reference-mark text-warning">' +
		'							<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">' +
		'								<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>' +
		'							</svg>' +
		'						</span>' +
		'				</label>' +
		'				<select name="<portlet:namespace/>roleType-' + updatedProcedureCount + '" id="<portlet:namespace/>roleType-' + updatedProcedureCount + '" class="custom-select form-control js-basic-single required-field" onchange="validateField($(this))">' +
		'				</select>' +
		'			</div>' +
		'		</div>' +
		'		<div class="col-lg-6 col-md-6 col-sm-12">' +
		'			<div class="form-group">' +
		'				<label for="<portlet:namespace/>supervisor-' + updatedProcedureCount + '">' +
		'					<liferay-ui:message key="supervisor" />' +
		'						<span class="reference-mark text-warning">' +
		'							<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">' +
		'								<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>' +
		'							</svg>' +
		'						</span>' +
		'				</label>' +
		'				<select name="<portlet:namespace/>supervisor-' + updatedProcedureCount + '" id="<portlet:namespace/>supervisor-' + updatedProcedureCount + '" class="custom-select form-control required-field" onchange="validateField($(this))">' +
		'				</select>' +
		'			</div>' +
		'		</div>' +
		'	</div>' +
		'	<div class="form-group">' +
		'		<h4 class="omsb-card-title mt-4 mb-0"><label for="<portlet:namespace/>comments-' + updatedProcedureCount + '"><liferay-ui:message key="comments" /></label></h4>' +
		'	</div>' +
		'	<div class="row">' +
		'		<div class="col-md-12">' +
		'			<div class="form-group">' +
		'				<div class="countryFlagWrap">' +
		'					<input class="cst-control" type="hidden" id="<portlet:namespace/>commentsUS-' + updatedProcedureCount + '" name="<portlet:namespace/>commentsUS-' + updatedProcedureCount + '" value=""></input>' +
		'					<input class="cst-control" type="hidden" id="<portlet:namespace/>commentsSA-' + updatedProcedureCount + '" name="<portlet:namespace/>commentsSA-' + updatedProcedureCount + '" value=""></input>' +
		'					<textarea id="<portlet:namespace/>comments-' + updatedProcedureCount + '" name="<portlet:namespace/>comments-' + updatedProcedureCount + '" class="form-control"></textarea>' +
		'					<div id="languageTagComments-' + updatedProcedureCount + '" class="cstFlag" data-input-name="country"' +
		'						data-selected-country="US" data-button-size="btn-lg"' +
		'						data-scrollable="true" data-scrollable-height="250px" data-name="comments" data-index="' + updatedProcedureCount + '">' +
		'					</div>' +
		'				</div>' +
		'			</div>' +
		'		</div>' +
		'	</div>' +
		'</div>';
		
		$(html).insertBefore("#<portlet:namespace/>procedure-count");
				
		$('.cstFlag').flagStrap({
			countries: {
			"US": "en-US",
			"SA": "ar-SA"
			},
			onSelect: function (value, element) {
		    	if(element.dataset.pre != value) {
		    		selectChanged(element.parentNode.dataset.name, element.parentNode.dataset.index, value);
		    		element.setAttribute('data-pre', element.value);
		    	}
		    }
		});

		document.querySelectorAll('[name="country"]').forEach(element => {
		  	element.setAttribute('data-pre', element.value);
		});

		setCommentCKEditor('<portlet:namespace/>comments-'+updatedProcedureCount);
		setCommentCKEditor('<portlet:namespace/>diagnosis-'+updatedProcedureCount);

		$('#<portlet:namespace/>cptCode-'+updatedProcedureCount).html($('#<portlet:namespace/>defaultCptCode').html());
		$('#<portlet:namespace/>procedureGroup-'+updatedProcedureCount).html($('#<portlet:namespace/>defaultProcedureGroup').html());
		$('#<portlet:namespace/>procedure-'+updatedProcedureCount).html($('#<portlet:namespace/>defaultProcedure').html());
		$('#<portlet:namespace/>caseLocation-'+updatedProcedureCount).html($('#<portlet:namespace/>defaultCaseLocation').html());
		$('#<portlet:namespace/>roleType-'+updatedProcedureCount).html($('#<portlet:namespace/>defaultRoleType').html());
		$('#<portlet:namespace/>supervisor-'+updatedProcedureCount).html($('#<portlet:namespace/>defaultSupervisor').html());
		
		$('#<portlet:namespace/>cptCode-'+updatedProcedureCount).select2();
		$('#<portlet:namespace/>procedureGroup-'+updatedProcedureCount).select2();
		$('#<portlet:namespace/>procedure-'+updatedProcedureCount).select2();
		$('#<portlet:namespace/>roleType-'+updatedProcedureCount).select2();
		
		if(updatedProcedureCount > 1) {
			$('.remove-procedure-btn:first').removeClass('d-none');
		}
	});
	
});

function removeLogProcedure(curBtn) {
	var curBtnCountNumber = $(curBtn).attr("data-index");
	
	var procedureCount = $("#<portlet:namespace/>procedure-count").val();
	
	$(curBtn).parent().parent().remove();
	
	for(var i = parseInt(curBtnCountNumber)+1 ; i<=procedureCount; i++) {
		
		$("#removeProcedureBtn-"+i).removeData('index');
		$("#<portlet:namespace/>diagnosisUS-"+i).removeData('index');
		$("#languageTagDiagnosis-"+i).removeData('index');
		$("#languageTagComments-"+i).removeData('index');

		$("#removeProcedureBtn-"+i).attr({
			"id" : "removeProcedureBtn-"+(i-1),
			"data-index" : (i-1)
		});

		$("#<portlet:namespace/>cptCode-"+i).attr({
			"id" : "<portlet:namespace/>cptCode-"+(i-1),
			"name" : "<portlet:namespace/>cptCode-"+(i-1)
		});
		
		$("#<portlet:namespace/>procedureGroup-"+i).attr({
			"id" : "<portlet:namespace/>procedureGroup-"+(i-1),
			"name" : "<portlet:namespace/>procedureGroup-"+(i-1)
		});
		
		$("#<portlet:namespace/>procedure-"+i).attr({
			"id" : "<portlet:namespace/>procedure-"+(i-1),
			"name" : "<portlet:namespace/>procedure-"+(i-1)
		});
		
		$("#<portlet:namespace/>diagnosis-"+i).attr({
			"id" : "<portlet:namespace/>diagnosis-"+(i-1),
			"name" : "<portlet:namespace/>diagnosis-"+(i-1)
		});
		
		$("#<portlet:namespace/>diagnosisUS-"+i).attr({
			"id" : "<portlet:namespace/>diagnosisUS-"+(i-1),
			"name" : "<portlet:namespace/>diagnosisUS-"+(i-1),
			"data-index" : (i-1)
		});
		
		$("#<portlet:namespace/>diagnosisSA-"+i).attr({
			"id" : "<portlet:namespace/>diagnosisSA-"+(i-1),
			"name" : "<portlet:namespace/>diagnosisSA-"+(i-1)
		});
		
		$("#<portlet:namespace/>caseLocation-"+i).attr({
			"id" : "<portlet:namespace/>caseLocation-"+(i-1),
			"name" : "<portlet:namespace/>caseLocation-"+(i-1)
		});

		$("#<portlet:namespace/>roleType-"+i).attr({
			"id" : "<portlet:namespace/>roleType-"+(i-1),
			"name" : "<portlet:namespace/>roleType-"+(i-1)
		});
		
		$("#<portlet:namespace/>supervisor-"+i).attr({
			"id" : "<portlet:namespace/>supervisor-"+(i-1),
			"name" : "<portlet:namespace/>supervisor-"+(i-1)
		});
		
		$("#<portlet:namespace/>comments-"+i).attr({
			"id" : "<portlet:namespace/>comments-"+(i-1),
			"name" : "<portlet:namespace/>comments-"+(i-1)
		});
		
		$("#<portlet:namespace/>commentsUS-"+i).attr({
			"id" : "<portlet:namespace/>commentsUS-"+(i-1),
			"name" : "<portlet:namespace/>commentsUS-"+(i-1)
		});
		
		$("#<portlet:namespace/>commentsSA-"+i).attr({
			"id" : "<portlet:namespace/>commentsSA-"+(i-1),
			"name" : "<portlet:namespace/>commentsSA-"+(i-1)
		});
		
		$("#languageTagDiagnosis-"+i).attr({
			"id" : "languageTagDiagnosis-"+(i-1),
			"data-index" : (i-1)
		});
		
		$("#languageTagComments-"+i).attr({
			"id" : "languageTagComments-"+(i-1),
			"data-index" : (i-1)
		});
		
		$("label[for='<portlet:namespace/>procedure-"+i+"']").attr({
			"for" : "<portlet:namespace/>procedure-"+(i-1)
		});

		$("label[for='<portlet:namespace/>diagnosis-"+i+"']").attr({
			"for" : "<portlet:namespace/>diagnosis-"+(i-1)
		});
		
		$("label[for='<portlet:namespace/>roleType-"+i+"']").attr({
			"for" : "<portlet:namespace/>roleType-"+(i-1)
		});
		
		$("label[for='<portlet:namespace/>supervisor-"+i+"']").attr({
			"for" : "<portlet:namespace/>supervisor-"+(i-1)
		});
		
		$("label[for='<portlet:namespace/>comments-"+i+"']").attr({
			"for" : "<portlet:namespace/>comments-"+(i-1)
		});
		
		CKEDITOR.instances["<portlet:namespace/>diagnosis-"+i].destroy();
		CKEDITOR.instances["<portlet:namespace/>comments-"+i].destroy();

		setCommentCKEditor("<portlet:namespace/>diagnosis-"+(i-1));
		setCommentCKEditor("<portlet:namespace/>comments-"+(i-1));

	}

	var updatedProcedureCount = parseInt(procedureCount)-1;
	$("#<portlet:namespace/>procedure-count").val(updatedProcedureCount);
	if(updatedProcedureCount < 2) {
		$('.remove-procedure-btn:first').addClass('d-none');
	}
};

function updatePGProcedures(curEl) {
	var cptCodeId = $(curEl).val();
	var curElCountNumber = $(curEl).attr('id').split("-")[1];

	$("#<portlet:namespace/>procedureGroup-"+curElCountNumber).val('').select2();
 	$("#<portlet:namespace/>procedure-"+curElCountNumber).val('').select2();
 	$("#<portlet:namespace/>procedure-"+ curElCountNumber +"Helper").remove();
 	
	if(cptCodeId != '') {
		callAjax(cptCodeId, true, false, false, curElCountNumber);
	} else {
		unhideAllCptCodesOptions(curElCountNumber);
		unhideAllProceduresOptions(curElCountNumber);
	}
}

function updateCPTCodeProcedures(curEl) {
	var pgId = $(curEl).val();
	var curElCountNumber = $(curEl).attr('id').split("-")[1];

	$('#<portlet:namespace/>cptCode-' + curElCountNumber).val('').select2();
	$('#<portlet:namespace/>procedure-' + curElCountNumber).val('').select2();

	if(pgId != '') {		
		callAjax(pgId, false, true, false, curElCountNumber);
	} else {
		unhideAllCptCodesOptions(curElCountNumber);
		unhideAllProceduresOptions(curElCountNumber);
	}
}

function updateCPTCodePG(curEl) {
	var procedureId = $(curEl).val();
	var curElCountNumber = $(curEl).attr('id').split("-")[1];
	
	$('#<portlet:namespace/>cptCode-' + curElCountNumber).val('').select2();
	$('#<portlet:namespace/>procedureGroup-' + curElCountNumber).val('').select2();
	$("#<portlet:namespace/>procedure-"+ curElCountNumber +"Helper").remove();

	if(procedureId != '') {		
		callAjax(procedureId, false, false, true, curElCountNumber);
	} else {
		unhideAllCptCodesOptions(curElCountNumber);
		unhideAllProceduresOptions(curElCountNumber);
	}
} 

function getTrainingSiteDetail(curEl) {
	var performedDate = $(curEl).val();
	fetchTrainingSite(performedDate);
}

function fetchTrainingSite(datePerformed) {
	let caseLocation = $(".case-location-option");
	caseLocation.val('');
	caseLocation.empty();
	caseLocation.append(`<aui:option value="0"><liferay-ui:message key="please-select-case-location" /></aui:option>`);
	$.ajax({
        url: "${fetchTrainingSite}",
        type : 'POST',
        dataType : 'json',
        data : {
        	"<portlet:namespace />datePerformed" : datePerformed
        },
        success : function(data) {
        	
        	if(data.id != null) {
        		caseLocation.append(`<option value='\${data.id}' selected="selected"> \${data.name}</option>`);
        	}
        },
        error : function(jqXHR, exception) {
			console.log("api Error", jqXHR);
		}
    });
}


function callAjax(id, isCptId, isPgId, isProcedureId, curElCountNumber) {
	$.ajax({
        url: "${fetchPgCptCodesProcedures}",
        type : 'POST',
        dataType : 'json',
        data : {
        	"<portlet:namespace />id" : id,
        	"<portlet:namespace />isCptId" : isCptId,
        	"<portlet:namespace />isPgId" : isPgId,
        	"<portlet:namespace />isProcedureId" : isProcedureId,
        },
        success : function(data) {
      		
			if(isCptId) {
				updatePgDropdown(id, data, curElCountNumber, false, false);
      		}
      		
      		if(isPgId) {
      			updateCptCodeDropdown(data, curElCountNumber, true);
      			updateProcedureDropdown(data, curElCountNumber, true);
      		}
      		
      		if(isProcedureId) {
      			updatePgDropdown(id, data, curElCountNumber, false, true);
      		}
      		
        },
        error : function(jqXHR, exception) {
			console.log("api Error", jqXHR);
		}
    });
}

function updateCptCodeDropdown(data, curElCountNumber, updationDueToPg) {
	$('#<portlet:namespace/>cptCode-' + curElCountNumber + ' option').each(function() {
		if($(this).val() != '') {
			$(this).addClass("d-none");	
		}
	});
	if(data.cptCodeMasters.length > 0) {
		$.each(data.cptCodeMasters, function(index, val) {
  			$('#<portlet:namespace/>cptCode-' + curElCountNumber + ' option[value="' + val.id + '"]').removeClass("d-none"); 
  		});
	}

	$('#<portlet:namespace/>cptCode-' + curElCountNumber).select2({
		templateResult: function (option) {
			if ($(option.element).hasClass('d-none')) {
				return null;
			} else {
				return option.text;
		    }
		}
	});
}

function updatePgDropdown(id, data, curElCountNumber, updationDueToPg, isProcedure) {
	if(data.id != null) {
		if ($("#<portlet:namespace/>procedureGroup-"+curElCountNumber+" option[value='"+data.id+"']").length > 0) {
			$("#<portlet:namespace/>procedureGroup-"+curElCountNumber).val(data.id).select2();
		}
	}
	if(isProcedure) {
		if ($("#<portlet:namespace/>cptCode-"+curElCountNumber+" option[value='"+id+"']").length > 0) {
			  $("#<portlet:namespace/>cptCode-"+curElCountNumber).val(id).select2();
		}
	} else {
		 $("#<portlet:namespace/>procedure-"+curElCountNumber).val(id).select2();
	}
}

function updateProcedureDropdown(data, curElCountNumber, updationDueToPg) {
	$('#<portlet:namespace/>procedure-' + curElCountNumber + ' option').each(function() {
		if($(this).val() != '') {
			$(this).addClass("d-none");	
		}
	});

	if(data.procedureMasters.length > 0) {
		$.each(data.procedureMasters, function(index, val) {
 			$('#<portlet:namespace/>procedure-' + curElCountNumber + ' option[value="' + val.id + '"]').removeClass("d-none"); 
 		});
	}
	$('#<portlet:namespace/>procedure-' + curElCountNumber).select2({
		templateResult: function (option) {
			if ($(option.element).hasClass('d-none')) {
				return null;
			} else {
				return option.text;
		    }
		}
	});
}

function unhideAllProceduresOptions(curElCountNumber) {
	$('#<portlet:namespace/>procedure-' + curElCountNumber + ' option').each(function() {
		$(this).removeClass("d-none");
	});
	$("#<portlet:namespace/>procedure-"+curElCountNumber).select2();
};

function unhideAllCptCodesOptions(curElCountNumber) {
	$('#<portlet:namespace/>cptCode-' + curElCountNumber + ' option').each(function() {
		$(this).removeClass("d-none");
	});
	$("#<portlet:namespace/>cptCode-"+curElCountNumber).select2();
};

</script>