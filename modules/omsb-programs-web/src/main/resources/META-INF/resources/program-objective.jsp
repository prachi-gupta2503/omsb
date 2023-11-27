<%@ include file="init.jsp"%>
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>

<%
    Locale arLocale = new Locale("ar", "SA");
	Locale usLocale = new Locale("en", "US");
%>

<portlet:actionURL name="<%= OmsbProgramConstants.SAVE_OBJECTIVES_MVC_ACTION_COMMAND %>" var="updateObjectiveDetailActionURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbProgramConstants.PROGRAM_DETAILS_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<aui:form action="${updateObjectiveDetailActionURL}" id="objectiveForm" name="fm">

<input type="hidden" id="hiddenCohortId" name="<portlet:namespace/>progDurationId" value="" />
	<c:set var="USLocale" value="<%= usLocale %>" />
	<c:set var="ARLocale" value="<%= arLocale %>" />

	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_PROGRAM_OBJECTIVE)}">
	<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
		<div class="omsb-card omsb-BorderRadius-4">
		<div class="row">
				<div class="col-lg-12 mb-4 pb-2">
					<div class="row">
						<div class="col-lg-12">
							<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
								<li class="nav-item">
									<a class="nav-link active" id="programobjectives-tab" data-toggle="tab"
										href="#programObjectives" role="tab"
										aria-controls="programObjectives" aria-selected="true"><liferay-ui:message key="program-objectives" /></a>
								</li>
								<li class="nav-item">
									<a class="nav-link" id="specificobjectives-tab" data-toggle="tab"
										href="#specificobjectives" role="tab" aria-controls="specificobjectives"
										aria-selected="false"><liferay-ui:message key="specific-objectives" /></a>
								</li>
							</ul>
						</div>
						<div class="col-lg-12 mt-4">
							<div class="tab-content" id="v-pills-tabContent">
								<div class="tab-pane fade show active" id="programObjectives" role="tabpanel" aria-labelledby="programObjectives-tab">
								</div>
								<div class="tab-pane fade" id="specificobjectives" role="tabpanel" aria-labelledby="specificobjectives-tab">
									<div class="pill-tab-nav">
											<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
												<c:forEach items="${competencies}" var="competenciesObj" varStatus="loop">
													<li class="nav-item" role="${competenciesObj.competenciesMasterId}">
														<button class="nav-link ${loop.index == 0 ? 'active' : ''}" id="pills-${competenciesObj.competenciesMasterId}-tab" data-toggle="pill" data-target="#pills-${competenciesObj.competenciesMasterId}" type="button" role="tab" aria-controls="pills-${competenciesObj.competenciesMasterId}" aria-selected="true">${competenciesObj.getCompetencyName(themeDisplay.getLocale())}</button>
													</li>
												</c:forEach>
											</ul>
									</div>
									<div id="specificobjectivesData"></div>
								</div>
							</div>
							</div>
						</div>
					</div>	
				</div>
			<div class="bottom-backbtn-wrap">
				<button class="btn omsb-bc-red-button validate-form-button m-0" type="button" title="Save" ><liferay-ui:message key="save" /></button>
				<button id="formSubmitButton" class="d-none" type="submit"/>
			</div>
			</div>
		</div>
	</c:if>
	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_PROGRAM_OBJECTIVE) && !permissionChecker.isOmniadmin()}">
		<div class="omsb-card border omsb-BorderRadius-4">
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab"
						role="tablist">
						<li class="nav-item">
							<a class="nav-link active" id="programobjectives-tab" data-toggle="tab"
								href="#programobjectives" role="tab"
								aria-controls="programobjectives" aria-selected="true"><liferay-ui:message key="program-objectives" /></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" id="specificobjectives-tab" data-toggle="tab"
								href="#specificobjectives" role="tab" aria-controls="specificobjectives"
								aria-selected="false"><liferay-ui:message key="specific-objectives" /></a>
						</li>

					</ul>
				</div>

				<div class="col-lg-12 mt-4">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade show active" id="programobjectives" role="tabpanel" aria-labelledby="programobjectives-tab">
							<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4">
								
								<div class="row objective-data">
									<c:choose>       
										<c:when test = "${not empty progdurationObjectivesRels}">
											<c:forEach items="${progdurationObjectivesRels}" var="progdurationObjectivesRel">
												<div class="col-lg-12 col-md-12 col-sm-12 objective-content">
													<div class="form-group-view white-bg">
														<img src="${themeDisplay.getPathThemeImages()}/svg/program-objective.svg" alt="">
														<div class="label-name pt-3"><liferay-ui:message key="program-objectives" /></div>
														<div class="label-content">
															${progdurationObjectivesRel}
														</div>
													</div>
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
												<div class="omsb-no-data-found"><liferay-ui:message key="project-objective-not-defined" /></div>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>

						<div class="tab-pane fade" id="specificobjectives" role="tabpanel" aria-labelledby="specificobjectives-tab">
							<div class="pill-tab-nav">
								<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
									<c:forEach items="${competencies}" var="competenciesObj" varStatus="loop">
										<li class="nav-item" role="${competenciesObj.competenciesMasterId}">
											<button class="nav-link ${loop.index == 0 ? 'active' : ''}" id="pills-objective-${competenciesObj.competenciesMasterId}-tab" data-toggle="pill" data-target="#pills-objective-${competenciesObj.competenciesMasterId}" type="button" role="tab" aria-controls="pills-objective-${competenciesObj.competenciesMasterId}" aria-selected="true">${competenciesObj.getCompetencyName(themeDisplay.getLocale())}</button>
										</li>
									</c:forEach>								
								</ul>
							</div>
							<div class="tab-content" id="pills-tabContent">
								<c:forEach items="${competencies}" var="competenciesObj" varStatus="loop">
									<div class="tab-pane fade ${loop.index == 0 ? 'show active' : ''}" id="pills-objective-${competenciesObj.competenciesMasterId}" role="tabpanel" aria-labelledby="pills-objective-${competenciesObj.competenciesMasterId}-tab">
										<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4">
											<div class="row competency-data" id="competency-data-${competenciesObj.competenciesMasterId}">
												<c:choose>
													<c:when test="${competenciesRequirementsRels.containsKey(competenciesObj.competenciesMasterId)}">
													    <c:forEach var="value" items="${competenciesRequirementsRels[competenciesObj.competenciesMasterId]}">
													        <div class="col-lg-4 col-md-4 col-sm-12 mb-4 objective-content">
																<div class="form-group-view white-bg">
																	<img src="${themeDisplay.getPathThemeImages()}/svg/program-objective.svg" alt="">
																	<div class="label-name pt-3"><liferay-ui:message key="requirements" /></div>
																	<div class="label-content">
																		${value}
																	</div>
																</div>
															</div>
													    </c:forEach>
													</c:when>
													<c:otherwise>
														<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
															<div class="omsb-no-data-found"><liferay-ui:message key="requirments-not-defined" /></div>
														</div>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
								</c:forEach>													
							</div>
						</div>			
					</div>
				</div>
			</div>
		</div>
	</c:if>

</aui:form>



<script>

function setCommentCKEditor(name, value) {
	console.log('setCommentCKEditor called');
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
    	if (value) {
            CKEDITOR.instances[name].setData(value);
        }
    }, 100);
}

function selectChanged(name, tabIndex, index, langValue) { 
	if(name == 'programObjectives'){
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
	}else{
		var editorData = CKEDITOR.instances['<portlet:namespace/>'+name+'-'+tabIndex+'-'+index].getData();
		if(langValue == 'US') {
			$('#<portlet:namespace/>'+name+'SA-'+tabIndex+'-'+index).val(editorData);
			CKEDITOR.instances['<portlet:namespace/>'+name+'-'+tabIndex+'-'+index].config.contentsLangDirection = 'ltr';
			CKEDITOR.instances['<portlet:namespace/>'+name+'-'+tabIndex+'-'+index].setData($('#<portlet:namespace/>'+name+langValue+'-'+tabIndex+'-'+index).val());
		} else if (langValue == 'SA') {
			$('#<portlet:namespace/>'+name+'US-'+tabIndex+'-'+index).val(editorData);
			CKEDITOR.instances['<portlet:namespace/>'+name+'-'+tabIndex+'-'+index].config.contentsLangDirection = 'rtl';
			CKEDITOR.instances['<portlet:namespace/>'+name+'-'+tabIndex+'-'+index].setData($('#<portlet:namespace/>'+name+langValue+'-'+tabIndex+'-'+index).val());
		}
	}
}

$(document).ready(function() {
	var newobjprocedureCount = $("#<portlet:namespace/>program-objectives-count").val();
	var newreqprocedureCount = $("#<portlet:namespace/>specific-objectives-count").val();
	$('.cstFlag').flagStrap({
		countries: {
		"US": "en-US",
		"SA": "ar-SA"
		},
	    onSelect: function (value, element) {
	    	if(element.dataset.pre != value) {
	    		if(element.parentNode.dataset.name == 'programObjectives'){
	    			selectChanged(element.parentNode.dataset.name, '', element.parentNode.dataset.index, value);
	    		}else{
	    			selectChanged(element.parentNode.dataset.name, element.parentNode.dataset.tab, element.parentNode.dataset.index, value);
	    		}
	    		element.setAttribute('data-pre', element.value);
	    	}
	    }
	});
	
	$('.validate-form-button').on('click', function() {
		
		var selectElement = document.getElementById("cohort");
	    var selectedValue = selectElement.options[selectElement.selectedIndex].value;
	    var hiddenInput = document.getElementById("hiddenCohortId");
	    hiddenInput.value = selectedValue;
	    
		$(".help-block").remove();
		var isValidate = true;
		$("[name='country']").each(function() {
	 		let name = $(this).parent().data("name");
	 		let index = $(this).parent().data("index");
	 		let tabIndex = $(this).parent().data("tab");
	 		let langValue = $(this).val();
	 		if(name == 'programObjectives'){
	 			$('#<portlet:namespace/>'+name+langValue+'-'+index).val(CKEDITOR.instances['<portlet:namespace/>'+name+'-'+index].getData());
	 		}else{
	 			$('#<portlet:namespace/>'+name+langValue+'-'+tabIndex+'-'+index).val(CKEDITOR.instances['<portlet:namespace/>'+name+'-'+tabIndex+'-'+index].getData());
	 		}
		});
	 	
		/* $('.required-field').each(function() {
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
	 	}); */

		if(isValidate) {
			$('#formSubmitButton').click();
		}
	});

	
	
	document.querySelectorAll('[name="country"]').forEach(element => {
	  	element.setAttribute('data-pre', element.value);
	});

	for(var i = 1; i <= newobjprocedureCount; i++) {
		let programObjectivesName = '<portlet:namespace/>programObjectives-'+(i);

		let programObjectivesValueName = '<portlet:namespace/>programObjectivesUS-'+(i);

		setCommentCKEditor(programObjectivesName, $('#'+programObjectivesValueName).val());
	}
	
	for(var i = 1; i <= newreqprocedureCount; i++) {
		var reqprocedureTabCount = $("#<portlet:namespace/>specific-objectives-count-"+i).val();
		for(var j = 1; j <= reqprocedureTabCount; j++){
			let requirementsName = '<portlet:namespace/>requirements-'+(i)+'-'+(j);
			let requirementsValueName = '<portlet:namespace/>requirementsUS-'+(i)+'-'+(j);

			setCommentCKEditor(requirementsName, $('#'+requirementsValueName).val());
		}
	}
	
});
	function addNewObjectives(){
		var programObjectivesUS = $("#programObjectivesUS-1").val();
		var programObjectivesSA = $("#programObjectivesSA-1").val();
		
		var procedureCount = $("#<portlet:namespace/>program-objectives-count").val();
		if(!procedureCount){
			procedureCount = 1;
		}
		var updatedProcedureCount = parseInt(procedureCount)+1;
		
		   
		var html = '<input type="hidden" name="<portlet:namespace/>programObjectivesMasterId-' + updatedProcedureCount + '" value="0" />'+
				   '<div class="omsb-card omsb-BorderRadius-4 omsb-card-graybg" id="mainobjective-' + updatedProcedureCount + '"> ' +
				   '    <div class="row"> ' +
				   '		<div class="col-lg-12"> '+    
				   '			<div class="form-group">'+ 
				   '				<label for="<portlet:namespace/>programObjectives-' + updatedProcedureCount + '"><liferay-ui:message key="program-objectives" /></label>'+	
			       '				<div class="countryFlagWrap">'+
				   '					<input class="required-optional" type="hidden" id="<portlet:namespace/>programObjectivesUS-' + updatedProcedureCount + '" name="<portlet:namespace/>programObjectivesUS-' + updatedProcedureCount + '" value="" data-name="programObjectives" data-index="' + updatedProcedureCount + '"></input>'+
			       '					<input type="hidden" id="<portlet:namespace/>programObjectivesSA-' + updatedProcedureCount + '" name="<portlet:namespace/>programObjectivesSA-' + updatedProcedureCount + '" value=""></input>'+
				   '					<textarea id="<portlet:namespace/>programObjectives-' + updatedProcedureCount + '" name="<portlet:namespace/>programObjectives-' + updatedProcedureCount + '" class="form-control"></textarea>'+
				   '					<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
				   '						data-selected-country="US" data-button-size="btn-lg"'+
				   '						data-scrollable="true" data-scrollable-height="250px" data-name="programObjectives" data-index="' + updatedProcedureCount + '">'+
				   '					</div>'+
				   '				</div>'+
				   '			</div>'+
				   ' 		</div>'+
				   '	</div>'+
				   '	 <div class="omsb-card-title">'+
				   '		<span></span>'+
				   '		<button class="btn omsb-bg-red-button" id="remove-program-objectives-btn" data-index="' + updatedProcedureCount + '" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeProgramObjectives(this)">'+
				   '			<liferay-ui:message key="discard" />'+
				   '		</button>'+
				   '	</div>'+
		    	   '</div>';
	    
		    	console.log('   procedureCount',procedureCount);
	    $("#mainobjective-"+procedureCount).after(html);
	    
	    $('.cstFlag').flagStrap({
			countries: {
			"US": "en-US",
			"SA": "ar-SA"
			},
			onSelect: function (value, element) {
				if(element.dataset.pre != value) {
		    		if(element.parentNode.dataset.name == 'programObjectives'){
		    			selectChanged(element.parentNode.dataset.name, '', element.parentNode.dataset.index, value);
		    		}else{
		    			selectChanged(element.parentNode.dataset.name, element.parentNode.dataset.tab, element.parentNode.dataset.index, value);
		    		}
		    		element.setAttribute('data-pre', element.value);
		    	}
		    }
		});
	    
	    document.querySelectorAll('[name="country"]').forEach(element => {
		  	element.setAttribute('data-pre', element.value);
		});
	    console.log('updatedProcedureCount :::',updatedProcedureCount);
	    setCommentCKEditor('<portlet:namespace/>programObjectives-'+updatedProcedureCount, null);
	    $("#<portlet:namespace/>program-objectives-count").val(updatedProcedureCount);
	};
	
	function addSpecificObjectives(tabIndex){		
		var requirementsUS = $("#requirementsUS-1").val();
		var requirementsSA = $("#requirementsSA-1").val();
		
		var procedureCount = $("#<portlet:namespace/>specific-objectives-count-"+tabIndex).val();
		if(!procedureCount){
			procedureCount = 1;
		}
		var updatedProcedureCountspe = parseInt(procedureCount)+1;
		
		var selectedValue = $('#<portlet:namespace/>competencyMasterId-1').val();
		var selectedValueInt = parseInt(selectedValue);
		console.log('selectedValueInt :: ',selectedValueInt);
		
		var htmlreq = '<input type="hidden" name="<portlet:namespace/>objectivesMasterId-'+tabIndex+'-' + updatedProcedureCountspe + '" value="${competenciesRequirementsRel.getProgdurationCompetenciesRelId()}" />'+
				   '<div class="omsb-card omsb-BorderRadius-4 mt-4 omsb-card-graybg" id="mainspecificobjective-'+tabIndex+'-' + updatedProcedureCountspe + '">'+
				   '	<div class="row">'+
				   '		<div class="col-lg-12 col-md-12 col-sm-12">'+
				   '			<div class="form-group">'+
				   '				<label for="<portlet:namespace/>requirements-'+tabIndex+'-'+ updatedProcedureCountspe +'"><liferay-ui:message key="requirements" /></label>'+
				   '				<div class="countryFlagWrap">'+
				   '					<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-'+tabIndex+'-'+ updatedProcedureCountspe +'" name="<portlet:namespace/>requirementsUS-'+tabIndex+'-'+ updatedProcedureCountspe +'" value="" data-name="requirements" data-index="' + updatedProcedureCountspe + '"></input>'+
	    		   '					<input type="hidden" id="<portlet:namespace/>requirementsSA-'+tabIndex+'-'+ updatedProcedureCountspe +'" name="<portlet:namespace/>requirementsSA-'+tabIndex+'-'+ updatedProcedureCountspe +'" value=""></input>'+
				   '					<textarea id="<portlet:namespace/>requirements-'+tabIndex+'-'+ updatedProcedureCountspe +'" name="<portlet:namespace/>requirements-'+tabIndex+'-'+ updatedProcedureCountspe +'" class="form-control"></textarea>'+
				   '					<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
				   '						data-selected-country="US" data-button-size="btn-lg"'+
			       '						data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="'+tabIndex+'" data-index="'+ updatedProcedureCountspe +'">'+
				   '					</div>'+
				   '				</div>'+
				   '			</div>'+
				   '		</div>'+	
				   '	</div>'+
				   '	<div class="omsb-card-title">'+
				   '		<span></span>'+
				   '		<button class="btn omsb-bg-red-button" id="remove-specific-objectives-btn" data-index="' +updatedProcedureCountspe + '" data-toggle="modal"	data-target="#addsupportingdocument" type="button" onclick="removeSpecificObjectives(this,'+tabIndex+')">'+
				   '			<liferay-ui:message key="discard" />'+
				   '		</button>'+
				   '	</div>'+
			 	   '</div>';
	    
	  	$("#mainspecificobjective-"+tabIndex+"-"+procedureCount).after(htmlreq);

	    $('#<portlet:namespace/>competencyMasterId-'+updatedProcedureCountspe).html($('#<portlet:namespace/>defaultCompetencyMaster').html());
	   /*  const targetDiv = document.getElementById('mainspecificobjective-'+tabIndex+'-'+updatedProcedureCountspe);
		targetDiv.scrollIntoView({ behavior: 'smooth' }); */
	    
	    $('.cstFlag').flagStrap({
			countries: {
			"US": "en-US",
			"SA": "ar-SA"
			},
			onSelect: function (value, element) {
		    	if(element.dataset.pre != value) {
		    		if(element.parentNode.dataset.name == 'programObjectives'){
		    			selectChanged(element.parentNode.dataset.name, '', element.parentNode.dataset.index, value);
		    		}else{
		    			selectChanged(element.parentNode.dataset.name, element.parentNode.dataset.tab, element.parentNode.dataset.index, value);
		    		}
		    		element.setAttribute('data-pre', element.value);
		    	}
		    }
		});
	    
	    document.querySelectorAll('[name="country"]').forEach(element => {
		  	element.setAttribute('data-pre', element.value);
		});
	    
		$("#<portlet:namespace/>specific-objectives-count-"+tabIndex).val(updatedProcedureCountspe);
		
		setCommentCKEditor('<portlet:namespace/>requirements-'+tabIndex+'-'+updatedProcedureCountspe, null);
	    
	};

function removeProgramObjectives(curBtn) {
	var deletedObjectiveValue = $("#<portlet:namespace/>deletedObjective").val();
	if(!deletedObjectiveValue){
		$("#<portlet:namespace/>deletedObjective").val($(curBtn).data('id'));
	}else{
		deletedObjectiveValue = deletedObjectiveValue + "," + $(curBtn).data('id');
		$("#<portlet:namespace/>deletedObjective").val(deletedObjectiveValue);
	}
	
	var curBtnCountNumber = $(curBtn).attr("data-index");
	
	var procedureCount = $("#<portlet:namespace/>program-objectives-count").val();
	$(curBtn).parent().parent().remove();
	
	for(var i = parseInt(curBtnCountNumber)+1 ; i<=procedureCount; i++) {
		console.log("changing the div ID");
		
		$("#programObjectives-"+i).attr({
			"id" : "programObjectives-"+(i-1),
			"name" : "<portlet:namespace/>programObjectives-"+(i-1)
		});
		
		$("#programObjectivesUS-"+i).attr({
			"id" : "programObjectivesUS-"+(i-1),
			"name" : "<portlet:namespace/>programObjectivesUS-"+(i-1)
		});
		
		$("#programObjectivesSA-"+i).attr({
			"id" : "programObjectivesSA-"+(i-1),
			"name" : "<portlet:namespace/>programObjectivesSA-"+(i-1)
		});
		
		/* CKEDITOR.instances["<portlet:namespace/>programObjectives-"+i].destroy();

        setCommentCKEditor("<portlet:namespace/>programObjectives-"+(i-1), null); */
 	}

	var updatedProcedureCount = parseInt(procedureCount)-1;
	$("#<portlet:namespace/>program-objectives-count").val(updatedProcedureCount);
};


function removeSpecificObjectives(curBtn, tabIndex) {
	var deletedSpecificObjectiveValue = $("#<portlet:namespace/>deletedSpecificObjective").val();
	if(!deletedSpecificObjectiveValue){
		$("#<portlet:namespace/>deletedSpecificObjective").val($(curBtn).data('id'));
	}else{
		deletedSpecificObjectiveValue = deletedSpecificObjectiveValue + "," + $(curBtn).data('id');
		$("#<portlet:namespace/>deletedSpecificObjective").val(deletedSpecificObjectiveValue);
	}
	
	var curBtnCountNumber = $(curBtn).attr("data-index");
	var procedureCount = $("#<portlet:namespace/>specific-objectives-count-"+tabIndex).val();
	
	$(curBtn).parent().parent().remove();
	
	for(var i = parseInt(curBtnCountNumber)+1 ; i<=procedureCount; i++) {
		
		$("#requirements-"+tabIndex+"-"+i).attr({
			"id" : "requirements-"+tabIndex+"-"+(i-1),
			"name" : "<portlet:namespace/>requirements-"+tabIndex+"-"+(i-1)
		});
		
		$("#requirementsUS-"+tabIndex+"-"+i).attr({
			"id" : "requirementsUS-"+tabIndex+"-"+(i-1),
			"name" : "<portlet:namespace/>requirementsUS-"+tabIndex+"-"+(i-1)
		});
		
		$("#requirementsSA-"+tabIndex+"-"+i).attr({
			"id" : "requirementsSA-"+tabIndex+"-"+(i-1),
			"name" : "<portlet:namespace/>requirementsSA-"+tabIndex+"-"+(i-1)
		});
 	}

	var updatedProcedureCount = parseInt(procedureCount)-1;
	$("#<portlet:namespace/>specific-objectives-count-"+tabIndex).val(updatedProcedureCount);
};

</script>


