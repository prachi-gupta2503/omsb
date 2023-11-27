<%@ include file="init.jsp"%>

<portlet:resourceURL id="/validateConfigureProcedure" var="validateConfigureProcedure" />

<portlet:renderURL var="addSetupProcedureURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="<%= OmsbSetupProceduresWebPortletKeys.MASTER_VALUE %>" value="<%= OmsbSetupProceduresWebPortletKeys.PROCEDURES %>" />
</portlet:renderURL>

<portlet:actionURL
	name="<%=OmsbSetupProceduresWebPortletKeys.SAVE_SETUP_PROCEDURE_MVC_COMMAND_NAME%>"
	var="editSetupProcedure">
	<portlet:param name="redirect" value="${addSetupProcedureURL}" />
</portlet:actionURL>

<portlet:resourceURL id="/getTraineeLevelURL" var="getTraineeLevelURL" />
<portlet:resourceURL id="/getRotationURL" var="getRotationURL" />
<portlet:resourceURL
	id="<%=OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_GROUP_MVC_RESOURCE_COMMAND_NAME%>"
	var="saveProcedureGroupURL" />
<portlet:resourceURL
	id="<%=OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_MVC_RESOURCE_COMMAND_NAME%>"
	var="saveProcedureURL" />
<portlet:resourceURL id="/getProcedureGroupMaster"
	var="getProcedureGroupMasterResourceURL" />
<portlet:resourceURL id="/getProcedureMaster"
	var="getProcedureMasterResourceURL" />

<div>
	<div class="display-msg"></div>
	
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle">
				<liferay-ui:message key="edit-configure-procedure" />
			</div>
		</div>
		<div class="row">
			<div class="col">
				<portlet:resourceURL id="/getPatientTypeURL" var="getPatientTypeURL" />
				<aui:form action="${editSetupProcedure}" method="POST"
					name="editConfigureProcedureForm">
					<div id="editConfigureProcedureMainDiv">
						<aui:input label="set-up-procedure-id"
							name="progdurationRotationTlPgProcedurePtRelId" type="hidden"
							value="${editSetupProcedureDetails.progdurationRotationTlPgProcedurePtRelId}" />
		
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group">
									<aui:select cssClass="custom-select form-control js-basic-single"
										label="select-program" id="selectProgramForConfig"
										name="selectProgramForConfig"
										value="${editProgramList.programMasterId}"
										onChange="getProgramDuration('selectProgramForConfig')"
										ignoreRequestValue="true">
										<c:forEach items="${allProgramList}" var="selectProgramList">
											<c:if test="${editProgramList.programMasterId == selectProgramList.programMasterId}">
												<aui:option selected="true" value="${selectProgramList.programMasterId}">${selectProgramList.getProgramName(locale)}</aui:option>
											</c:if>
										</c:forEach>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group">
									<aui:select cssClass="custom-select form-control js-basic-single"
										label="program-cohort"
										name="programDurationForConfig" value="${editSetupProcedureDetails.programDurationId}" 
										ignoreRequestValue="true"
										onchange="addProcedureGroupAndProcedureButtonEnable();">
										<c:forEach items="${programDurationDetailList}" var="programDurationDetailListValue">
											<c:if test="${programDurationDetailListValue.progDurationId == editSetupProcedureDetails.programDurationId}">
												<aui:option selected="true" value="${programDurationDetailListValue.progDurationId}">${programDurationDetailListValue.ayApplicableForm}</aui:option>
											</c:if>
										</c:forEach>
										<aui:validator name="required" />
									</aui:select>
								</div>
							</div>
						</div>
						<div
							class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="d-flex align-items-end">
										<div class="form-group">
											<aui:select
												cssClass="custom-select form-control col-12 procedure-group-select js-basic-single"
												label="procedure-group" name="procedureGroup"
												value="${editSetupProcedureDetails.procedureGroupId}"
												onChange="getProcedureMasterList()">
												<c:forEach items="${allProcedureGroups}" var="procedureGroup">
													<c:if test="${procedureGroup.procedureGroupMasterId == editSetupProcedureDetails.procedureGroupId}">
														<aui:option selected="true" value="${procedureGroup.procedureGroupMasterId}">
															<c:if test="${procedureGroup.procedureGroupMasterId == 0}">
																<liferay-ui:message key="please-select-procedure-group" />
															</c:if>
															<c:if test="${procedureGroup.procedureGroupMasterId != 0}">
																${procedureGroup.getProcedureGroupName(locale)}
															</c:if>
														</aui:option>
													</c:if>
												</c:forEach>
											</aui:select>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12">
									<div class="d-flex align-items-end">
										<div class="form-group">
											<aui:select
												cssClass="custom-select form-control col-12 procedure-select js-basic-single"
												label="procedures" id="procedures" name="procedures"
												value="${editSetupProcedureDetails.procedureId}" >
												<c:forEach items="${allProcedures}" var="procedure">
													<c:if test="${procedure.procedureMasterId == editSetupProcedureDetails.procedureId}">
														<aui:option selected="true" value="${procedure.procedureMasterId}">${procedure.getProcedureName(locale)}</aui:option>
													</c:if>
												</c:forEach>
												<aui:validator name="required" />
											</aui:select>
										</div>
									</div>
								</div>
							</div>
							<div class="omsb-card omsb-BorderRadius-4 sub-card-tms" >
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12">
										<div class="form-group d-flex">
											<div class="custom-control custom-radio ">
												<input type="radio" onclick="showHideOftrainneLevel()"
													name="bychoiceoftypeSetupProcedure"
													class="custom-control-input rotation-radio" id="byrotation"
													value="rotation" checked="">
												<label class="custom-control-label m-0"
													for="byrotation"><liferay-ui:message key="by-rotation" /></label>
											</div>
					
											<div class="custom-control custom-radio ">
												<input type="radio" onclick="showHideOftrainneLevel()"
													name="bychoiceoftypeSetupProcedure"
													class="custom-control-input" id="bytraineelevel"
													value="trainee">
												<label class="custom-control-label m-0"
													for="bytraineelevel"><liferay-ui:message key="by-trainee-level" /></label>
											</div>
										</div>
					
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group">
											<label for="<portlet:namespace/>rotation">
												<liferay-ui:message key="rotation" />
												<span class="reference-mark text-warning">
													<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
														<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
													</svg>
												</span>
											</label>
											<select class="custom-select form-control js-basic-single" id="<portlet:namespace/>rotation"
												name="<portlet:namespace/>rotation" onchange="removeError($(this)),defaultRotationChange($(this).val())">
												<aui:option value="0" class="placeholder">
													<liferay-ui:message key="please-select-rotation" />
												</aui:option>
												<c:forEach items="${allRotations}" var="rotation">
													<aui:option value="${rotation.rotationMasterId}" 
														selected="${rotation.rotationMasterId == editSetupProcedureDetails.rotationId ? true : false}">
															${rotation.getRotationName(locale)}</aui:option>
												</c:forEach>
											</select>
										</div>
									</div>
					
									<div class="col-lg-6 col-md-6 col-sm-12 traineeLevel"
										style="display: none;">
										<div class="form-group">
											<label for="<portlet:namespace/>traineeLevel">
												<liferay-ui:message key="trainee-level" />
												<span class="reference-mark text-warning">
													<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
														<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
													</svg>
												</span>
											</label>
											<select class="custom-select form-control"
												id="<portlet:namespace/>traineeLevel" name="<portlet:namespace/>traineeLevel" 
												onchange="removeError($(this))">
												<aui:option value="0" class="placeholder">
													<liferay-ui:message key="please-select-trainee-level" />
												</aui:option>
												<c:forEach items="${allTraineeLevels}" var="traineeLevel">
													<aui:option value="${traineeLevel.traineeLevelMasterId}"
														selected="${traineeLevel.traineeLevelMasterId == editSetupProcedureDetails.traineeLevelId ? true : false}"	>
														${traineeLevel.getTraineeLevelName(locale)}</aui:option>
												</c:forEach>
											</select>
										</div>
									</div>
					
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="<portlet:namespace/>minimumProcedures">
												<liferay-ui:message key="minimum-no-of-procedures" />
												<span class="reference-mark text-warning">
													<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
														<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
													</svg>
												</span>
											</label>
											<input class="form-control" type="number"
												id="<portlet:namespace/>minimumProcedures"
												name="<portlet:namespace/>minimumProcedures"
												value="${editSetupProcedureDetails.minimumProcedures !=0 ? editSetupProcedureDetails.minimumProcedures : editSetupProcedureDetails.traineelevelMinimumProcedures}"
												placeholder='<liferay-ui:message key="enter-min-number-of-procedures" />'
												min="0" onkeyup="removeError($(this))">
											</input>
										</div>
									</div>
								</div>
								<div id="add-clone-rotation-btn-div"
									class="bottom-backbtn-wrap mt-0">
									<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_CONFIGURED_PROCEDURE)}">
										<button id="cloneRotationGroupBtn"
											class="btn omsb-bc-red-button m-0 addMoreSubCard" type="button"
											onClick="addSubCard()" title="Save">
											<liferay-ui:message key="add" />
										</button>
									</c:if>
									<button style="display: none"
										class="btn omsb-bg-red-button discardSubCard"
										onclick="discardSubCard()" type="button" title="Discard">
										<liferay-ui:message key="discard" />
									</button>
								</div>
							</div>
							<div class="bottom-backbtn-wrap mt-0 d-none">
								<button id="cloneProcedureGroupBtn"
									class="btn omsb-bc-red-button m-0 addProcedure" type="button"
									onclick="addProcedure()" title="Add Procedure">
									<liferay-ui:message key="add-procedure" />
								</button>
								<button style="display: none;"
									class="btn omsb-bg-red-button discardProcedure"
									onclick="discardProcedure()" type="button"
									title="Discard Procedure">
									<liferay-ui:message key="discard-procedure" />
								</button>
							</div>
						</div>
						<div class="bottom-backbtn-wrap">
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_CONFIGURED_PROCEDURE)}">
								<button class="btn omsb-bc-red-button" type="button" onclick="editConfigureProcedure()" title="Save"><liferay-ui:message key="save" /></button>
							</c:if>
							<a href="${addSetupProcedureURL}" class="btn omsb-bg-red-button"><liferay-ui:message key="back" /></a>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_CONFIGURED_PROCEDURE)}">
	<div class="row">
		<jsp:include page="/setup-procedure-table-listing.jsp" />
	</div>
</c:if>

<%@ include file="/procedure-delete-modal-popup.jsp"%>

<script>

var isrotationRadioChecked = true;
var rotationVal = 0;
$(document).ready(function(){
	$("#editConfigureProcedureMainDiv").find(".js-basic-single").each(function() {
    	$(this).select2();
    });
	$("#<portlet:namespace/>selectProgramForConfig").attr("disabled",true);
	$("#<portlet:namespace/>programDurationForConfig").attr("disabled",true);
	$("#<portlet:namespace/>procedureGroup").attr("disabled",true);
	$("#<portlet:namespace/>procedures").attr("disabled",true);
	$('#<portlet:namespace/>rotation').attr("disabled",true);
	if($("#<portlet:namespace/>traineeLevel").val() != 0){
		$('#<portlet:namespace/>minimumProceduresRotation').val(${editSetupProcedureDetails.traineelevelMinimumProcedures});
		$('#bytraineelevel').prop('checked', true);
		isrotationRadioChecked = false;
		$('.traineeLevel').attr('style', '');
	}
});

function getReqiuredErrorMessage(element){
	let elementName = $(element).attr("name");
	let elementNameWithoutPortletNamespace = elementName.split("_")[elementName.split("_").length - 1];
	if(elementNameWithoutPortletNamespace == "selectProgramForConfig"){
		elementNameWithoutPortletNamespace = "program";
	}
	if(elementNameWithoutPortletNamespace == "programDurationForConfig"){
		elementNameWithoutPortletNamespace = "program duration";
	}
	if(elementNameWithoutPortletNamespace == "minimumProcedures"){
		elementNameWithoutPortletNamespace = "minimum no of procedures";
	}
	if(elementNameWithoutPortletNamespace == "traineeLevel"){
		elementNameWithoutPortletNamespace = "trainee level";
	}
	let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id="\${elementName}Helper">
		<div role="alert" class="text-danger" id="<portlet:namespace/>${element}Error"><liferay-ui:message key="The \${elementNameWithoutPortletNamespace} field is required." /></div>
	</div>`
	$(element).closest('.form-group').append(errorMsg);
}

function editConfigureProcedure() {
	var isError = false;

	$("#editConfigureProcedureMainDiv").find(".sub-card-tms").each(function() {
		var isChecked = true;
		var checkboxElement = $(this).find(".rotation-radio");
		if(!$(checkboxElement).prop('checked')){
			isChecked = false;
		}
		$(this).find(".form-control").each(function() {
			var originalName = $(this).attr("name");
			var originalValue = $(this).val();
			if(!isChecked){
				if((!originalValue || originalValue === 0 || originalValue === '0')){
					if($(this).closest('.form-group').find('#'+originalName+'Helper').length == 0){
						getReqiuredErrorMessage($(this));
						isError = true;
					}else{
						isError = true;
					}
				}else{
					//isError = false;
					$(this).closest('.form-group').find('#'+originalName+'Helper').remove()
				}
			}else{
				if((originalName == "<portlet:namespace/>traineeLevel")){
					$(this).closest('.form-group').find('#'+originalName+'Helper').remove()
				}else{
					if((!originalValue || originalValue === 0 || originalValue === '0')){
						if($(this).closest('.form-group').find('#'+originalName+'Helper').length == 0){
							getReqiuredErrorMessage($(this));
							isError = true;
						}else{
							isError = true;
						}
					}else{
						//isError = false;
						$(this).closest('.form-group').find('#'+originalName+'Helper').remove()
					}
				}
			}
		});
    }); 
	
	if(isError){
		event.preventDefault();
		return false;
	}
	
	let jsonArray = [];
	$("#editConfigureProcedureMainDiv").find(".sub-card-tms").each(function() {
		var jsonObject = {};
		jsonObject["programDurationForConfig"] = $("#<portlet:namespace/>programDurationForConfig").val();
		jsonObject["procedureGroupId"] = $("#<portlet:namespace/>procedureGroup").val();
		jsonObject["procedureId"] = $("#<portlet:namespace/>procedures").val();
		
		var isChecked = true;
		var checkboxElement = $(this).find(".rotation-radio");
		if(!$(checkboxElement).prop('checked')){
			isChecked = false;
		}
		$(this).find(".form-control").each(function() {
			var originalName = $(this).attr("name");
			var originalValue = $(this).val();
			jsonObject[originalName.split("_")[originalName.split("_").length - 1]] = originalValue;
			if(isChecked){
				if((originalName == "<portlet:namespace/>traineeLevel")){
					$(this).val(0)
				}
			}
		});
		jsonArray.push(jsonObject);
    }); 
	
	$(".loader-container").addClass("d-flex").removeClass("d-none");
	
	validateData(JSON.stringify(jsonArray));
}

function getProcedureMasterList(){
	let procedureGroupId = $("#<portlet:namespace/>procedureGroup").val();
	$.ajax({
		url: '<%=getProcedureMasterResourceURL%>',
		type: 'POST',
		data:{
			<portlet:namespace/>procedureGroup: procedureGroupId
		},
		success: function(data){
			let programMasterDropdownList = data.programMasterDropdownList;
			$("#<portlet:namespace/>procedures").empty();
			$("#<portlet:namespace/>procedures").append(`<aui:option ><liferay-ui:message key="please-select-procedure" /></aui:option>`);
			for(let i=0; i<programMasterDropdownList.length; i++){
				$("#<portlet:namespace/>procedures").append("<option value='"+programMasterDropdownList[i].procedureId+"'>" + programMasterDropdownList[i].procedureName + "</option>");
			}
		}
	});
}

function showHideOftrainneLevel(){
	if(isrotationRadioChecked){
		if($(event.target.closest(".sub-card-tms")).find("#byrotation").prop('checked')){
			$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").val(${editSetupProcedureDetails.rotationId});
			$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").attr("disabled","disabled").select2();
		}else{
			if($(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").attr("disabled")){
				if(rotationVal!=0){
					$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").val(rotationVal);
				}
				$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").removeAttr("disabled").select2();
			}
		}
	}else{
		if($(event.target.closest(".sub-card-tms")).find("#bytraineelevel").prop('checked')){
			$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").val(${editSetupProcedureDetails.rotationId});
			$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").attr("disabled","disabled").select2();
		}else{
			if($(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").attr("disabled")){
				if(rotationVal!=0){
					$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").val(rotationVal);
				}
				$(event.target.closest(".sub-card-tms")).find("#<portlet:namespace/>rotation").removeAttr("disabled").select2();
			}
		}
	}
	
	if (event.target.value == "trainee") {
		event.target.closest(`.sub-card-tms`).querySelector('.traineeLevel').style.display = "block";
	} else {
		event.target.closest(`.sub-card-tms`).querySelector('.traineeLevel').style.display = "none";
	}
}

var counter = 0;
function addSubCard(){
	counter++;
	const defaultHtmlOfSubCard = 
		`<div class="omsb-card omsb-BorderRadius-4 sub-card-tms" >
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="form-group d-flex">
						<div class="custom-control custom-radio ">
							<input type="radio" onclick="showHideOftrainneLevel()"
								name="bychoiceoftypeSetupProcedure_\${counter}"
								class="custom-control-input rotation-radio" id="byrotation_\${counter}"
								value="rotation" checked="">
							<label class="custom-control-label m-0"
								for="byrotation_\${counter}"><liferay-ui:message key="by-rotation" /></label>
						</div>

						<div class="custom-control custom-radio ">
							<input type="radio" onclick="showHideOftrainneLevel()"
								name="bychoiceoftypeSetupProcedure_\${counter}"
								class="custom-control-input" id="bytraineelevel_\${counter}"
								value="trainee">
							<label class="custom-control-label m-0"
								for="bytraineelevel_\${counter}"><liferay-ui:message key="by-trainee-level" /></label>
						</div>
					</div>

				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label for="<portlet:namespace/>rotation">
							<liferay-ui:message key="rotation" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<select class="custom-select form-control js-basic-single" id="<portlet:namespace/>rotation_\${counter}"
							name="<portlet:namespace/>rotation" onchange="removeError($(this))">
							<aui:option value="0" class="placeholder">
								<liferay-ui:message key="please-select-rotation" />
							</aui:option>
							<c:forEach items="${allRotations}" var="rotation">
								<aui:option value="${rotation.rotationMasterId}">${rotation.getRotationName(locale)}</aui:option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="col-lg-6 col-md-6 col-sm-12 traineeLevel"
					style="display: none;">
					<div class="form-group">
						<label for="<portlet:namespace/>traineeLevel">
							<liferay-ui:message key="trainee-level" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<select class="custom-select form-control"
							id="<portlet:namespace/>traineeLevel" name="<portlet:namespace/>traineeLevel" 
								onchange="removeError($(this))">
							<aui:option value="0" class="placeholder">
								<liferay-ui:message key="please-select-trainee-level" />
							</aui:option>
							<c:forEach items="${allTraineeLevels}" var="traineeLevel">
								<aui:option value="${traineeLevel.traineeLevelMasterId}">${traineeLevel.getTraineeLevelName(locale)}</aui:option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="col-lg-6 col-md-6">
					<div class="form-group">
						<label for="<portlet:namespace/>minimumProcedures">
							<liferay-ui:message key="minimum-no-of-procedures" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<input class="form-control" type="number"
							id="<portlet:namespace/>minimumProcedures"
							name="<portlet:namespace/>minimumProcedures"
							placeholder='<liferay-ui:message key="enter-min-number-of-procedures" />'
							min="0"
							onkeyup="removeError($(this))"
							ignoreRequestValue="true">
						</input>
					</div>
				</div>
			</div>
			
			<div class="bottom-backbtn-wrap mt-0">
				<button class="btn omsb-bc-red-button m-0 addMoreSubCard" onclick="addSubCard()" type="button" title="Add">Add</button>
				<button style="display:none" class="btn omsb-bg-red-button discardSubCard" onclick="discardSubCard()" type="button" title="Discard">Discard</button>
			</div>
		</div>`;

	const node = event.target.closest(`.main-card-tms`).querySelector('.sub-card-tms');
	$(node).before(defaultHtmlOfSubCard);
	event.target.closest(`.sub-card-tms`).querySelector('.addMoreSubCard').style.display = "none";
	event.target.closest(`.sub-card-tms`).querySelector('.discardSubCard').style.display = "block";

	$(".js-basic-single").each(function() {
	    var elementId = $(this).attr("id");
	    $("#"+elementId).select2();
	});
}

function discardSubCard(){			
	event.target.closest(`.sub-card-tms`).remove();
}

function removeError(e){
	if($(e).val() && $(e).val()!=0){
		$(e).closest('.form-group').find('#'+$(e).attr('name')+'Helper').remove();
	}
}

function defaultRotationChange(value){
	rotationVal = value;
}

function validateData(jsonArray){
	let progdurationRotationTlPgProcedurePtRelId = $("#<portlet:namespace/>progdurationRotationTlPgProcedurePtRelId").val();
	$.ajax({
		url: '<%=validateConfigureProcedure%>',
		type: 'POST',
		data: {
			<portlet:namespace/>jsonData : jsonArray,
			<portlet:namespace/>progdurationRotationTlPgProcedurePtRelId : progdurationRotationTlPgProcedurePtRelId
		},
		success: function(data)	{
			if(data.success) {
				$('[disabled]').removeAttr("disabled");
				
				$("#<portlet:namespace/>editConfigureProcedureForm").submit();
			} else {
				let errMsg;
				if(data.hasDuplicateDataError){
					errMsg = `<liferay-ui:message key="configure-procedure-error" />`;
				}else{
					errMsg = data.error;
				}
				let errPopUp = `<div class="alert alert-light alert-danger-text" role="alert">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<div class="alert-box">
						<span><img
							src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
							alt="Reject"></span>
						<div class="alert-text">
							<h4 class="alert-heading">
								<span id="showError">\${errMsg}</span>
							</h4>
						</div>
					</div>
				</div>`;
				$(".display-msg").append(errPopUp);
				window.scrollTo({
		            top: 0,
		            behavior: "smooth" // Use smooth scrolling for a smoother effect (optional)
		        });
			}
		}
	});
}
</script>