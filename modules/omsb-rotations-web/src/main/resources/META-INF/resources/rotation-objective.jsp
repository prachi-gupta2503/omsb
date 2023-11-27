<%@ include file="init.jsp"%>
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>

<%
    Locale arLocale = new Locale("ar", "SA");
	Locale usLocale = new Locale("en", "US");
	
%>

<portlet:actionURL name="<%= OmsbRotationsWebPortletKeys.SAVE_OBJECTIVES_MVC_ACTION_COMMAND %>" var="updateObjectiveDetailActionURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbRotationsWebPortletKeys.ROTATION_DETAILS_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<c:set var="USLocale" value="<%= usLocale %>" />
<c:set var="ARLocale" value="<%= arLocale %>" />

<div class="omsb-card border omsb-BorderRadius-4">
	<div class="row">
		<div class="col-lg-12 mb-4 pb-2">
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
						<li class="nav-item">
							<a class="nav-link active" id="rotationobjectives-tab" data-toggle="tab"
								href="#rotationobjectives" role="tab"
								aria-controls="rotationobjectives" aria-selected="true"><liferay-ui:message key="rotation-objectives" /></a>
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
					<div class="tab-pane fade show active" id="rotationobjectives" role="tabpanel" aria-labelledby="rotationobjectives-tab">
					<c:choose>
						<c:when test="${rotationObjectivesRels.size() == 0}">
						<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ROTATION_OBJECTIVE)}">
								<input type="hidden" id="<portlet:namespace/>program-objectives-count" name="<portlet:namespace/>programObjectivesCount" value="1" />
								<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainobjective-1">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
												<label for="<portlet:namespace/>programObjectives-1"><liferay-ui:message key="rotation-objectives" /></label>
												<div class="countryFlagWrap">
													<input class="required-optional" type="hidden" id="<portlet:namespace/>programObjectivesUS-1" name="<portlet:namespace/>programObjectivesUS-1" value="" data-name="programObjectives" data-index="1"></input>
									    			<input type="hidden" id="<portlet:namespace/>programObjectivesSA-1" name="<portlet:namespace/>programObjectivesSA-1" value=""></input>
													<textarea id="<portlet:namespace/>programObjectives-1" name="<portlet:namespace/>programObjectives-1" class="form-control"></textarea>
													<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
														data-selected-country="US" data-button-size="btn-lg"
														data-scrollable="true" data-scrollable-height="250px" data-name="programObjectives" data-index="1">
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="bottom-backbtn-wrap mt-0 add-button-objectives-1">
										<button class="btn omsb-bc-red-button m-0"  id="add-new-program-objectives-btn" onclick="addNewObjectives()" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>
									</div>
								</div>
							</c:if>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_OBJECTIVE) && !permissionChecker.isOmniadmin()}">
								<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainobjective-1">
									<div class="row">
										<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
											<div class="omsb-no-data-found"><liferay-ui:message key="rotation-objective-not-defined" /></div>
										</div>
									</div>
								</div>
							</c:if>
						</c:when>
						<c:otherwise>
							<input type="hidden" id="<portlet:namespace/>program-objectives-count" name="<portlet:namespace/>programObjectivesCount" value="${rotationObjectivesRels.size()}" />
							<input type="hidden" id="<portlet:namespace/>deletedObjective" name="<portlet:namespace/>deletedObjective" value="" />
							<c:forEach items="${rotationObjectivesRels}" var="progdurationObjectivesRel" varStatus="loop">
							<input type="hidden" name="<portlet:namespace/>programObjectivesMasterId-${loop.index + 1}" value="${progdurationObjectivesRel.getRotationObjectivesRelId()}" />
								<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainobjective-${loop.index + 1}">
									<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ROTATION_OBJECTIVE)}">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="form-group">
												<label for="<portlet:namespace/>programObjectives-${loop.index + 1}"><liferay-ui:message key="rotation-objectives" /></label>
												<div class="countryFlagWrap">
													<input class="required-optional" type="hidden" id="<portlet:namespace/>programObjectivesUS-${loop.index + 1}" name="<portlet:namespace/>programObjectivesUS-${loop.index + 1}" value="${fn:contains(progdurationObjectivesRel.getObjectives(), USLocale) ? progdurationObjectivesRel.getObjectives(USLocale) : ''}" data-name="programObjectives" data-index="1"></input>
									    			<input type="hidden" id="<portlet:namespace/>programObjectivesSA-${loop.index + 1}" name="<portlet:namespace/>programObjectivesSA-${loop.index + 1}" value="${fn:contains(progdurationObjectivesRel.getObjectives(), ARLocale) ? progdurationObjectivesRel.getObjectives(ARLocale) : ''}"></input>
													<textarea id="<portlet:namespace/>programObjectives-${loop.index + 1}" name="<portlet:namespace/>programObjectives-${loop.index + 1}" class="form-control"></textarea>
													<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
														data-selected-country="US" data-button-size="btn-lg"
														data-scrollable="true" data-scrollable-height="250px" data-name="programObjectives" data-index="${loop.index + 1}">
													</div>
												</div>
											</div>
										</div>
									</div>
									<c:if test="${loop.first}">
										<div class="bottom-backbtn-wrap mt-0 add-button-objectives-1">
											<button class="btn omsb-bc-red-button m-0"  id="add-new-program-objectives-btn" onclick="addNewObjectives()" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>
										</div>							
									</c:if>
								    <c:if test="${!loop.first}">
										<div class="omsb-card-title">
											<span></span>
											<button class="btn omsb-bg-red-button" data-id="${progdurationObjectivesRel.getRotationObjectivesRelId()}" id="remove-program-objectives-btn" data-index="${loop.index + 1}" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeProgramObjectives(this)">
									   			<liferay-ui:message key="discard" />
									   		</button>
									   	</div>									
								   	</c:if>
								   	</c:if>
								   	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_OBJECTIVE) && !permissionChecker.isOmniadmin()}">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12">
												<div class="form-group-view white-bg">
													<img src="${themeDisplay.getPathThemeImages()}/svg/program-objective.svg" alt="">
													<div class="label-name pt-3"><liferay-ui:message key="rotation-objectives" /></div>
													<div class="label-content">${progdurationObjectivesRel.getObjectives(locale)}</div>
												</div>
											</div>
										</div>
									</c:if>
								</div>
							</c:forEach>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_OBJECTIVE) && rotationObjectivesRels.size() == 0 && !permissionChecker.isOmniadmin()}">
								<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
									<div class="omsb-no-data-found"><liferay-ui:message key="rotation-objective-not-defined" /></div>
								</div>
							</c:if>
						</c:otherwise>
					</c:choose>
					</div>
					
					<div class="tab-pane fade" id="specificobjectives" role="tabpanel" aria-labelledby="specificobjectives-tab">
						<input type="hidden" id="<portlet:namespace/>specific-objectives-count" name="<portlet:namespace/>specificObjectivesCount" value="6" />
						<input type="hidden" id="<portlet:namespace/>deletedSpecificObjective" name="<portlet:namespace/>deletedSpecificObjective" value="" />
						<div class="pill-tab-nav">
							<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
								<c:forEach items="${competencies}" var="competenciesObj" varStatus="loop">
									<li class="nav-item" role="${competenciesObj.competenciesMasterId}">
										<button class="nav-link ${loop.index == 0 ? 'active' : ''}" id="pills-${competenciesObj.competenciesMasterId}-tab" data-toggle="pill" data-target="#pills-${competenciesObj.competenciesMasterId}" type="button" role="tab" aria-controls="pills-${competenciesObj.competenciesMasterId}" aria-selected="true">${competenciesObj.getCompetencyName(themeDisplay.getLocale())}</button>
									</li>
								</c:forEach>
							</ul>
						</div>
						<div class="tab-content" id="pills-tabContent">
							<c:forEach items="${competencies}" var="competenciesObj" varStatus="loop">
								<c:choose>
								<c:when test="${competenciesRequirementsRels.size() == 0}">	
									<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ROTATION_OBJECTIVE)}">
									<div class="tab-pane fade ${loop.index == 0 ? 'show active' : ''}" id="pills-${competenciesObj.competenciesMasterId}" role="tabpanel" aria-labelledby="pills-${competenciesObj.competenciesMasterId}-tab">
										<input type="hidden" id="<portlet:namespace/>specific-objectives-count-${loop.index + 1}" name="<portlet:namespace/>specificObjectivesCount-${loop.index + 1}" value="1" />
										<input type="hidden" id="<portlet:namespace/>competencyMasterId-${loop.index + 1}" name="<portlet:namespace/>competencyMasterId-${loop.index + 1}" value="${competenciesObj.competenciesMasterId}" />
										<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-${loop.index + 1}-1">
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12">
													<div class="form-group">
														<label for="<portlet:namespace/>requirements-${loop.index + 1}-1"><liferay-ui:message key="requirements" /></label>
														<div class="countryFlagWrap">
															<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-${loop.index + 1}-1" name="<portlet:namespace/>requirementsUS-${loop.index + 1}-1" value="" data-name="requirements" data-index="1"></input>
											    			<input type="hidden" id="<portlet:namespace/>requirementsSA-${loop.index + 1}-1" name="<portlet:namespace/>requirementsSA-${loop.index + 1}-1" value=""></input>
															<textarea id="<portlet:namespace/>requirements-${loop.index + 1}-1" name="<portlet:namespace/>requirements-${loop.index + 1}-1" class="form-control"></textarea>
															<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
																data-selected-country="US" data-button-size="btn-lg"
																data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="${loop.index + 1}" data-index="1">
															</div>
														</div>
													</div>
												</div>
											</div>
		
											<div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">
												<button class="btn omsb-bc-red-button m-0"  id="add-new-specific-objectives-btn" onclick="addSpecificObjectives(${loop.index + 1})" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>
											</div>
											</div>
										</div>	
										</c:if>
									</c:when>
									<c:otherwise>
										<div class="tab-pane fade ${loop.index == 0 ? 'show active' : ''}" id="pills-${competenciesObj.competenciesMasterId}" role="tabpanel" aria-labelledby="pills-${competenciesObj.competenciesMasterId}-tab">
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ROTATION_OBJECTIVE)}">	
											<input type="hidden" id="<portlet:namespace/>competencyMasterId-${loop.index + 1}" name="<portlet:namespace/>competencyMasterId-${loop.index + 1}" value="${competenciesObj.competenciesMasterId}" />
											<c:set var="isValueAvailable" value="false" />
											<c:set var="totalCount" value="1" />
											<c:forEach items="${competenciesRequirementsRels}" var="competenciesRequirementsRel" varStatus="innerLoop">
	     											<c:if test="${competenciesObj.getCompetenciesMasterId() == competenciesRequirementsRel.getCompetenciesMasterId()}">
	     											<c:set var="isValueAvailable" value="true" />
	     												<input type="hidden" name="<portlet:namespace/>objectivesMasterId-${loop.index + 1}-${totalCount}" value="${competenciesRequirementsRel.getRotationCompetenciesRelId()}" />
													<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-${loop.index + 1}-${totalCount}">
														<div class="row">
															<div class="col-lg-12 col-md-12 col-sm-12">
																<div class="form-group">
																	<label for="<portlet:namespace/>requirements-${loop.index + 1}-${totalCount}"><liferay-ui:message key="requirements" /></label>
																	<div class="countryFlagWrap">
																		<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-${loop.index + 1}-${totalCount}" name="<portlet:namespace/>requirementsUS-${loop.index + 1}-${totalCount}" value="${fn:contains(competenciesRequirementsRel.getRequirements(), USLocale) ? competenciesRequirementsRel.getRequirements(USLocale) : ''}" data-name="requirements" data-index="${totalCount}"></input>
														    			<input type="hidden" id="<portlet:namespace/>requirementsSA-${loop.index + 1}-${totalCount}" name="<portlet:namespace/>requirementsSA-${loop.index + 1}-${totalCount}" value="${fn:contains(competenciesRequirementsRel.getRequirements(), ARLocale) ? competenciesRequirementsRel.getRequirements(ARLocale) : ''}"></input>
																		<textarea id="<portlet:namespace/>requirements-${loop.index + 1}-${totalCount}" name="<portlet:namespace/>requirements-${loop.index + 1}-${totalCount}" class="form-control"></textarea>
																		<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
																			data-selected-country="US" data-button-size="btn-lg"
																			data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="${loop.index + 1}" data-index="${totalCount}">
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<c:if test="${totalCount == 1}">
															<div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">
																<button class="btn omsb-bc-red-button m-0"  id="add-new-specific-objectives-btn" onclick="addSpecificObjectives(${loop.index + 1})" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>
															</div>						
														</c:if>
													    <c:if test="${totalCount > 1}">
															<div class="omsb-card-title">
																<span></span>
																<button class="btn omsb-bg-red-button" data-id="${competenciesRequirementsRel.getRotationCompetenciesRelId()}" id="remove-specific-objectives-btn" data-index="${loop.index + 1}" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeSpecificObjectives(this)">
													   				<liferay-ui:message key="discard" />
													   			</button>
													   		</div>								
													   	</c:if>
													</div>
													<c:set var="totalCount" value="${totalCount + 1}" />
												</c:if>
											</c:forEach>
											</c:if>
											<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_OBJECTIVE) && !permissionChecker.isOmniadmin()}">
											<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4">
											<div class="row">
												<c:set var="isValueAvailableForTrainee" value="false" />
												<c:forEach items="${competenciesRequirementsRels}" var="competenciesRequirementsRel" varStatus="innerLoop">
			     									<c:if test="${competenciesObj.getCompetenciesMasterId() == competenciesRequirementsRel.getCompetenciesMasterId()}">
			     									<c:set var="isValueAvailableForTrainee" value="true" />
														<div class="col-lg-4 col-md-4 col-sm-12 mb-4">
															<div class="form-group-view white-bg">
																<img src="${themeDisplay.getPathThemeImages()}/svg/program-objective.svg" alt="">
																<div class="label-name pt-3"><liferay-ui:message key="requirements" /></div>
																<div class="label-content">${competenciesRequirementsRel.getRequirements(locale)}</div>
															</div>
														</div>
													</c:if>
												</c:forEach>
												<c:if test="${!isValueAvailableForTrainee && permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_OBJECTIVE) && !permissionChecker.isOmniadmin()}">
													<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
														<div class="omsb-no-data-found"><liferay-ui:message key="requirments-not-defined" /></div>
													</div>
												</c:if>
											</div>
											</div>
										</c:if>
										<input type="hidden" id="<portlet:namespace/>specific-objectives-count-${loop.index + 1}" name="<portlet:namespace/>specificObjectivesCount-${loop.index + 1}" value="${isValueAvailable ? (totalCount-1) : totalCount}" />
										<c:if test="${!isValueAvailable && permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ROTATION_OBJECTIVE)}">
											<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-${loop.index + 1}-1">
												<div class="row">
													<div class="col-lg-12 col-md-12 col-sm-12">
														<div class="form-group">
															<label for="<portlet:namespace/>requirements-${loop.index + 1}-1"><liferay-ui:message key="requirements" /></label>
															<div class="countryFlagWrap">
																<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-${loop.index + 1}-1" name="<portlet:namespace/>requirementsUS-${loop.index + 1}-1" value="" data-name="requirements" data-index="1"></input>
												    			<input type="hidden" id="<portlet:namespace/>requirementsSA-${loop.index + 1}-1" name="<portlet:namespace/>requirementsSA-${loop.index + 1}-1" value=""></input>
																<textarea id="<portlet:namespace/>requirements-${loop.index + 1}-1" name="<portlet:namespace/>requirements-${loop.index + 1}-1" class="form-control"></textarea>
																<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
																	data-selected-country="US" data-button-size="btn-lg"
																	data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="${loop.index + 1}" data-index="1">
																</div>
															</div>
														</div>
													</div>
												</div>
			
												<div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">
													<button class="btn omsb-bc-red-button m-0"  id="add-new-specific-objectives-btn" onclick="addSpecificObjectives(${loop.index + 1})" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>
												</div>
											</div>
										</c:if>   
										</div>
									</c:otherwise>
								</c:choose>
								</c:forEach>
								<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ROTATION_OBJECTIVE) && competenciesRequirementsRels.size() == 0 && !permissionChecker.isOmniadmin()}">
									<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4">
										<div class="row">
											<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
												<div class="omsb-no-data-found"><liferay-ui:message key="requirments-not-defined" /></div>
											</div>
										</div>
									</div>
								</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
</div>
	
	
<script>

function setCommentCKEditor(name, value) {
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
    	if(value) {
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
	 	
	 	/* $('.required-optional').each(function() {
	 	    var name = $(this).data('name');
	 	    var index = $(this).data('index');
			if((!$('#<portlet:namespace/>'+name+'US-'+index).val()) && (!$('#<portlet:namespace/>'+name+'SA-'+index).val())) {
				let errorMsg = '';
				if(name == 'programObjectives'){
					errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
		 				<div role="alert" class="text-danger"><liferay-ui:message key="The Rotation Objectives field is required." /></div>
		 			</div>`;
				}else{
					errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
		 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${name} field is required." /></div>
		 			</div>`;
				}
				
	 			$(this).closest('.form-group').append(errorMsg);
	 			isValidate = false;
			}
	 	}); */
		
	 	var formValidator = Liferay.Form.get('<portlet:namespace />addRotationForm').formValidator;
	    formValidator.validate();
	    if (formValidator.hasErrors()) return;
	 	
		if(isValidate) {
			$('#<portlet:namespace/>addRotationForm').submit();
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
	
	var procedureCount = $("#<portlet:namespace/>program-objectives-count").val();
	if(!procedureCount){
		procedureCount = 1;
	}
	var updatedProcedureCount = parseInt(procedureCount)+1;
	
	var html = `<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainobjective-\${updatedProcedureCount}">
		<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div class="form-group">
				<label for="<portlet:namespace/>programObjectives-\${updatedProcedureCount}"><liferay-ui:message key="rotation-objectives" /></label>
				<div class="countryFlagWrap">
					<input class="required-optional" type="hidden" id="<portlet:namespace/>programObjectivesUS-\${updatedProcedureCount}" name="<portlet:namespace/>programObjectivesUS-\${updatedProcedureCount}" value="" data-name="programObjectives" data-index="1"></input>
	    			<input type="hidden" id="<portlet:namespace/>programObjectivesSA-\${updatedProcedureCount}" name="<portlet:namespace/>programObjectivesSA-\${updatedProcedureCount}" value=""></input>
					<textarea id="<portlet:namespace/>programObjectives-\${updatedProcedureCount}" name="<portlet:namespace/>programObjectives-\${updatedProcedureCount}" class="form-control"></textarea>
					<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
						data-selected-country="US" data-button-size="btn-lg"
						data-scrollable="true" data-scrollable-height="250px" data-name="programObjectives" data-index="\${updatedProcedureCount}">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom-backbtn-wrap mt-0 add-button-objectives-1">
		<button class="btn omsb-bg-red-button" id="remove-program-objectives-btn" data-index="\${updatedProcedureCount}" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeProgramObjectives(this)">
			<liferay-ui:message key="discard" />
		</button>
	</div>
	</div>`;

	$("#mainobjective-"+procedureCount).after(html);
	
	const targetDiv = document.getElementById('mainobjective-' + updatedProcedureCount);
	targetDiv.scrollIntoView({ behavior: 'smooth' });
	   
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
    
	$("#<portlet:namespace/>program-objectives-count").val(updatedProcedureCount);
    
    setCommentCKEditor('<portlet:namespace/>programObjectives-'+updatedProcedureCount, null);
    
};
	
function addSpecificObjectives(tabIndex){		
	var procedureCount = $("#<portlet:namespace/>specific-objectives-count-"+tabIndex).val();
	if(!procedureCount){
		procedureCount = 1;
	}
	
	var updatedProcedureCountspe = parseInt(procedureCount)+1;
	
	var htmlreq = `<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-\${tabIndex}-\${updatedProcedureCountspe}">
	    <div class="row">
	        <div class="col-lg-12 col-md-12 col-sm-12">
	            <div class="form-group">
	                <label for="<portlet:namespace/>requirements-\${tabIndex}-\${updatedProcedureCountspe}"><liferay-ui:message key='requirements' /></label>
	                <div class="countryFlagWrap">
	                    <input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-\${tabIndex}-\${updatedProcedureCountspe}" name="<portlet:namespace/>requirementsUS-\${tabIndex}-\${updatedProcedureCountspe}" value="" data-name="requirements" data-index="\${updatedProcedureCountspe}"></input>
	                    <input type="hidden" id="<portlet:namespace/>requirementsSA-\${tabIndex}-\${updatedProcedureCountspe}" name="<portlet:namespace/>requirementsSA-\${tabIndex}-\${updatedProcedureCountspe}" value=""></input>
	                    <textarea id="<portlet:namespace/>requirements-\${tabIndex}-\${updatedProcedureCountspe}" name="<portlet:namespace/>requirements-\${tabIndex}-\${updatedProcedureCountspe}" class="form-control"></textarea>
	                    <div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"
	                        data-selected-country="US" data-button-size="btn-lg"
	                        data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="\${tabIndex}" data-index="\${updatedProcedureCountspe}">
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>

	    <div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">
		    <button class="btn omsb-bg-red-button" id="remove-specific-objectives-btn" data-index="\${updatedProcedureCountspe}" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeSpecificObjectives(this, \${tabIndex})">
			   <liferay-ui:message key="discard" />
			</button>
	    </div>
	</div>`;
    
  	$("#mainspecificobjective-"+tabIndex+"-"+procedureCount).after(htmlreq);
  	
  	const targetDiv = document.getElementById('mainspecificobjective-'+tabIndex+'-'+updatedProcedureCountspe);
	targetDiv.scrollIntoView({ behavior: 'smooth' });
    
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
	var updatedProcedureCount = parseInt(procedureCount)-1;
	$("#<portlet:namespace/>program-objectives-count").val(updatedProcedureCount);
	
	$(curBtn).parent().parent().remove();
	
	for(var i = parseInt(curBtnCountNumber)+1 ; i<=procedureCount; i++) {
		
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
 	}
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



