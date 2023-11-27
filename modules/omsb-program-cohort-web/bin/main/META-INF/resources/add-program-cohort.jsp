<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbProgramCohortWebPortletKeys.SAVE_PROGRAM_COHORT_MVC_ACTION_COMMAND %>" var="saveProgramCohort" >
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="isCreate" value="true" />
</portlet:actionURL>

<liferay-ui:error key="duplicate-trainee-level" message="duplicate-trainee-level" />
<liferay-ui:error key="invalid-blocks-numbers" message="invalid-blocks-numbers" />

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && SessionMessages.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span> <liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>


<div class="loader-container loaded d-none" id="block-creation-loader" >
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
     <p><liferay-ui:message key="block-creation-message" /></p>
 </div>

<div class="row">
		<div class="col-md-12">
			<div class="omsb-card">
				<aui:form action="${saveProgramCohort}" name="createFm">
				<div class="omsb-page-top-info mb-4">
					<div class="pagetitle"> <liferay-ui:message key="add-program-cohort" /> </div>									
				</div>
				<div class="omsb-list-filter omsb-more-btn">
					<aui:input type="hidden" name="programId" value="${programId}" />
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label for="<portlet:namespace/>program">
									<liferay-ui:message key="select-a-program" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control js-basic-single required-field" id="<portlet:namespace/>program"
									name="<portlet:namespace/>program" onchange="validateField($(this))">
									<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program" /></aui:option>
										<c:forEach items="${programMasterList}" var="program">
											<aui:option value="${program.programMasterId}" selected="${program.programMasterId eq programId ? true : false}">
												${program.getProgramName(locale)}
											</aui:option>
										</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label for="<portlet:namespace/>cohort">
									<liferay-ui:message key="cohort" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control js-basic-single required-field" id="<portlet:namespace/>cohort"
									name="<portlet:namespace/>cohort" onchange="validateField($(this))">
									<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-cohort" /></aui:option>
									<c:forEach items="${yearRange}" var="year">
										<aui:option value="${year}">${year}</aui:option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Cohort Board Start -->
				<div id="mainDiv" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
					<div class="omsb-list-filter pb-0">
						<div class="row">
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label for="<portlet:namespace/>traineeLevel${0}">
										<liferay-ui:message key="trainee-level" />
										<span class="reference-mark text-warning">
											<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
												<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
											</svg>
										</span>
									</label>
									<select class="custom-select form-control required-field" id="<portlet:namespace/>traineeLevel${0}"
										name="<portlet:namespace/>traineeLevel${0}" onchange="validateField($(this))">
										<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-trainee-level" /></aui:option>
										<c:forEach items="${traineeLevelMasters}" var="traineeLevel">
											<aui:option value="${traineeLevel.traineeLevelMasterId}">${traineeLevel.getTraineeLevelName(locale)}</aui:option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label for="<portlet:namespace/>noOfBlocks${0}">
										<liferay-ui:message key="no-of-blocks" />
										<span class="reference-mark text-warning">
											<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
												<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
											</svg>
										</span>
									</label>
									<input class="custom-select form-control required-field" type="number" id="<portlet:namespace/>noOfBlocks${0}" name="<portlet:namespace/>noOfBlocks${0}" 
										placeholder='<liferay-ui:message key="no-of-blocks" />' max="13" min="0" step="1" onchange="validateField($(this))"/>
								</div>
							</div>
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label for="<portlet:namespace/>levelType${0}">
										<liferay-ui:message key="level-type" />
										<span class="reference-mark text-warning">
											<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
												<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
											</svg>
										</span>
									</label>
									<select class="custom-select form-control required-field" id="<portlet:namespace/>level-type${0}" 
										name="<portlet:namespace/>levelType${0}" onchange="validateField($(this))">
										<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-level-type" /></aui:option>
										<c:forEach items="${levelTypeMasters}" var="levelType">
											<aui:option value="${levelType.levelTypeMasterId}">${levelType.getLevelTypeName(locale)}</aui:option>
										</c:forEach>
									</select>
								</div>
							</div>
						
						</div>
						<div class="filter-button-wrap flex">
							<button class="btn omsb-bc-red-button" type="button" onClick="addBlock()"><liferay-ui:message key="add" /></button>
							<!-- <button class="btn omsb-bg-red-button" onClick="removeBlock()"><liferay-ui:message key="discard" /></button> -->
						</div>
						
					</div>
				</div>		
				<!-- Cohort Board End -->
				
				<div class="bottom-backbtn-wrap mt-0 mb-5">
					<aui:input label="count" type="hidden" name="count"  value="0" />
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_COHORT)}">
						<button class="btn omsb-bc-red-button" type="button" onClick="validateForm()" title="Save"><liferay-ui:message key="save" /></button>
					</c:if>
					<a class="btn omsb-btn omsb-bg-red-button" href="${currentURL}" title="Reset"><liferay-ui:message key="reset" /></a>
				</div>
				</aui:form>
				<!--  Program Cohort Table -->
				<jsp:include page="/program-cohort-list.jsp" />
			</div>
		</div>
	</div>
	
<script>
	$(document).ready(function(){
		$(".js-basic-single").each(function() {
		    var elementId = $(this).attr("id");
		    $("#"+elementId).select2();
		});
	})

	function isNullOrUndefined(value) {
	  return value === undefined || value === null || value === "" || value == 0;
	}
	
	function loader(show) {
		console.log("sfasdffsdfasdfasdfsdaf");
		var programId = $("#<portlet:namespace/>program").val();
		var cohort = $("#<portlet:namespace/>cohort").val();
		var traineeLevel = $("#<portlet:namespace/>traineeLevel0").val();
		var noOfBlocks = $("#<portlet:namespace/>noOfBlocks0").val();
		var levelType = $("#<portlet:namespace/>level-type0").val();
		
		console.log("ProgramId :" + programId);
		console.log("cohort :" + cohort);
		console.log("traineeLevel :" + traineeLevel);
		console.log("noOfBlocks :" + noOfBlocks);
		console.log("levelType :" + levelType);
		
		var isValueNullOrUndefined = (isNullOrUndefined(programId) || isNullOrUndefined(cohort) || isNullOrUndefined(traineeLevel) || isNullOrUndefined(noOfBlocks) || isNullOrUndefined(levelType));
		console.log("isValueNullOrUndefined " + isValueNullOrUndefined);
		if(show == true && isValueNullOrUndefined != true) {
			$('#block-creation-loader').addClass('d-flex').removeClass('d-none');
		} else {
			$('#block-creation-loader').addClass('d-none').removeClass('d-flex');
		}
	}

	function addBlock() {
		var procedureCount = $("#<portlet:namespace/>count").val();
		var count = parseInt(procedureCount)+1;
		$("#<portlet:namespace/>count").val(count);
		var pohortCardDiv = `<div id="childDiv\${count}" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
			<div class="omsb-list-filter pb-0">
			<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="form-group">
					<label for="<portlet:namespace/>traineeLevel\${count}">
						<liferay-ui:message key="trainee-level" />
						<span class="reference-mark text-warning">
							<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
								<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
							</svg>
						</span>
					</label>
					<select class="custom-select form-control required-field" id="<portlet:namespace/>traineeLevel\${count}"
						name="<portlet:namespace/>traineeLevel\${count}" onchange="validateField($(this))">
						<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-trainee-level" /></aui:option>
						<c:forEach items="${traineeLevelMasters}" var="traineeLevel">
							<aui:option value="${traineeLevel.traineeLevelMasterId}">${traineeLevel.getTraineeLevelName(locale)}</aui:option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group">
					<label for="<portlet:namespace/>noOfBlocks\${count}">
						<liferay-ui:message key="no-of-blocks" />
						<span class="reference-mark text-warning">
							<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
								<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
							</svg>
						</span>
					</label>
					<input class="custom-select form-control required-field" type="number" id="<portlet:namespace/>noOfBlocks\${count}" name="<portlet:namespace/>noOfBlocks\${count}" 
						placeholder='<liferay-ui:message key="no-of-blocks" />' max="13" min="0" step="1" onchange="validateField($(this))"/>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group">
					<label for="<portlet:namespace/>levelType\${count}">
						<liferay-ui:message key="level-type" />
						<span class="reference-mark text-warning">
							<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
								<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
							</svg>
						</span>
					</label>
					<select class="custom-select form-control required-field" id="<portlet:namespace/>level-type\${count}" 
						name="<portlet:namespace/>levelType\${count}" onchange="validateField($(this))">
						<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-level-type" /></aui:option>
						<c:forEach items="${levelTypeMasters}" var="levelType">
							<aui:option value="${levelType.levelTypeMasterId}">${levelType.getLevelTypeName(locale)}</aui:option>
						</c:forEach>
					</select>
				</div>
			</div>
		
		</div>
			<div class="filter-button-wrap flex">											
				<button class="btn omsb-bg-red-button" id="\${count}" onClick="removeBlock(this.id)"><liferay-ui:message key="discard" /></button>
			</div>
			
		</div>
	</div>`;

	$("#mainDiv").after(pohortCardDiv);
	}
	
	function removeBlock(id){
		$("#childDiv" + id ).remove();
	}
	
	function validateForm() {
		$(".help-block").remove();
		var isValidate = true;
	 	$('.required-field').each(function() {
	 		if(!$(this).val()) {
	 			let fieldName = $("label[for='"+$(this).attr('name')+"']").text().trim();
	 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
	 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${fieldName} field is required." /></div>
	 			</div>`
	 			$(this).closest('.form-group').append(errorMsg);
	 			isValidate = false;
	 		} else {
	 			if($(this).attr('type') == 'number' && ($(this).val() > 13 || $(this).val() < 1)) {
		 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
		 				<div role="alert" class="text-danger"><liferay-ui:message key="enter-value-between-1-13" /></div>
		 			</div>`
		 			$(this).closest('.form-group').append(errorMsg);
		 			isValidate = false;
	 			}
	 		}
	 	});
	 	
	 	if(isValidate) {
	 		loader(true);
	 		$('#<portlet:namespace/>createFm').submit();
	 	}
	}

	function validateField(field) {
		if(field.val().trim()) {
			$('#'+field.attr('name')+'Helper').remove();
		}
	}
</script>
