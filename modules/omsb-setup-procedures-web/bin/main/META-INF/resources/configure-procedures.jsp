<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@ include file="init.jsp"%>
<portlet:resourceURL id="/validateConfigureProcedure" var="validateConfigureProcedure" />
<portlet:actionURL
	name="<%=OmsbSetupProceduresWebPortletKeys.SAVE_SETUP_PROCEDURE_MVC_COMMAND_NAME%>"
	var="saveSetupProcedureURL">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<portlet:resourceURL id="/getTraineeLevelURL" var="getTraineeLevelURL" />
<portlet:resourceURL id="/getRotationURL" var="getRotationURL" />
<portlet:resourceURL id="/getProcedureMaster" var="getProcedureMasterResourceURL" />
<portlet:resourceURL id="<%=OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_GROUP_MVC_RESOURCE_COMMAND_NAME %>" var="saveProcedureGroupURL" />
<portlet:resourceURL id="<%=OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_MVC_RESOURCE_COMMAND_NAME %>" var="saveProcedureURL" />
<portlet:resourceURL id="/getProcedureGroupMaster"
	var="getProcedureGroupMasterResourceURL" />
<portlet:resourceURL id="/getProcedureMaster"
	var="getProcedureMasterResourceURL" />

<div class="tab-pane fade show" id="configureprocedures" role="tabpanel"
	aria-labelledby="configureprocedures-tab">

	<aui:form action="${saveSetupProcedureURL}" name="saveConfigureProcedureForm">
		<aui:input id="configureProcedureRotationJson"
			name="configureProcedureRotationJson" value="" type="hidden" />
		<div id="configureProcedureMainDiv">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label for="<portlet:namespace/>selectProgramForConfig">
							<liferay-ui:message key="select-program" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<select class="custom-select form-control js-basic-single"
							id="<portlet:namespace/>selectProgramForConfig"
							name="<portlet:namespace/>selectProgramForConfig"
							onChange="getProgramDuration('selectProgramForConfig')"
							data-label="program"
							ignoreRequestValue="true">
							<aui:option selected="true" disabled="true"
								class="placeholder">
								<liferay-ui:message key="please-select-program" />
							</aui:option>
							<c:forEach items="${allProgramList}" var="selectProgramList">
								<aui:option value="${selectProgramList.programMasterId}">${selectProgramList.getProgramName(locale)}</aui:option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label for="<portlet:namespace/>programDurationForConfig">
							<liferay-ui:message key="program-duration" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label>
						<select class="custom-select form-control js-basic-single"
							id="<portlet:namespace/>programDurationForConfig"
							name="<portlet:namespace/>programDurationForConfig" ignoreRequestValue="true" 
							onchange="addProcedureGroupAndProcedureButtonEnable();">
							<aui:option selected="true" disabled="true"
								class="placeholder">
								<liferay-ui:message key="please-select-program-duration" />
							</aui:option>
						</select>
					</div>
				</div>
			</div>
			<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms" >
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="d-flex align-items-end">
							<div class="form-group">
								<label for="<portlet:namespace/>procedureGroup">
									<liferay-ui:message key="procedure-group" />
								</label>
								<select class="custom-select form-control col-11 procedure-group-select js-basic-single"
									id="<portlet:namespace/>procedureGroup" 
									name="<portlet:namespace/>procedureGroup"
									onChange="getProcedureMasterList($(this))">
									<aui:option selected="true" value="0">
										<liferay-ui:message key="please-select-procedure-group" />
									</aui:option>
									<c:forEach items="${allProcedureGroups}" var="procedureGroup">
										<aui:option value="${procedureGroup.procedureGroupMasterId}">${procedureGroup.getProcedureGroupName(locale)}</aui:option>
									</c:forEach>
								</select>
							</div>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_PROCEDURE_GROUP)}">
								<button class="btn omsb-bc-red-button omsb-add-btn add-procedure-group-btn mb-3 ml-3"
									type="button" title="Add" data-target="#addProcedureGroupMasterModal"
									data-toggle="modal" disabled="true">
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
										alt="<liferay-ui:message key="add-btn" />" />
								</button>
							</c:if>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="d-flex align-items-end">
							<div class="form-group">
								<label for="<portlet:namespace/>procedures">
									<liferay-ui:message key="procedures" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control col-11 procedure-select js-basic-single"
									id="<portlet:namespace/>procedures" name="<portlet:namespace/>procedures" onchange="removeError($(this))">
									<aui:option selected="true" disabled="true"
										class="placeholder">
										<liferay-ui:message key="please-select-procedure" />
									</aui:option>
									<c:forEach items="${allProcedures}" var="procedure">
										<aui:option value="${procedure.procedureMasterId}">${procedure.getProcedureName(locale)}</aui:option>
									</c:forEach>
								</select>
							</div>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_PROCEDURE)}">
								<button class="btn omsb-bc-red-button omsb-add-btn add-procedure-btn mb-3 ml-3"
									type="button" title="Add" data-target="#addProcedureMasterModal"
									data-toggle="modal" disabled="true">
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
										alt="<liferay-ui:message key="add-btn" />" />
								</button>
							</c:if>
						</div>
					</div>
				</div>
	
				<div class="omsb-card omsb-BorderRadius-4 sub-card-tms">
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
									name="<portlet:namespace/>rotation" onchange="removeError($(this))">
									<aui:option  selected="true" disabled="true"
										class="placeholder">
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
									id="<portlet:namespace/>traineeLevel" name="<portlet:namespace/>traineeLevel" onchange="removeError($(this))">
									<aui:option value="0" class="placeholder" >
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
									min="0" onchange="removeError($(this))">
								</input>
							</div>
						</div>
					</div>

					<div id="add-clone-rotation-btn-div" class="bottom-backbtn-wrap mt-0">
						<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_CONFIGURED_PROCEDURE)}">
							<button id="cloneRotationGroupBtn" class="btn omsb-bc-red-button m-0 addMoreSubCard" type="button"
								onClick="addSubCard()" title="Save">
								<liferay-ui:message key="add" />
							</button>
						</c:if>
						<button style="display:none" class="btn omsb-bg-red-button discardSubCard" onclick="discardSubCard()" type="button" title="Discard"><liferay-ui:message key="discard" /></button>
					</div>
				</div>
				<div class="bottom-backbtn-wrap mt-0">
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_CONFIGURED_PROCEDURE)}">
						<button id="cloneProcedureGroupBtn" class="btn omsb-bc-red-button m-0 addProcedure" type="button" 
							onclick="addProcedure()" title="Add Procedure">
							<liferay-ui:message key="add-procedure" />
						</button>
					</c:if>
					<button style="display: none;" class="btn omsb-bg-red-button discardProcedure" onclick="discardProcedure()" type="button"
						title="Discard Procedure"><liferay-ui:message key="discard-procedure" /></button>
				</div>
			</div>
			<div id="save-reset-btn-group" class="bottom-backbtn-wrap m-0">
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_CONFIGURED_PROCEDURE)}">
					<button class="btn omsb-bc-red-button" id="saveConfigureProcedureBtn" type="button" title="Save">
						<liferay-ui:message key="save" />
					</button>
				</c:if>
				<a href="${resetConfigureProcedureForm}" id="resetBtnSaveConfiguration" class="btn omsb-bc-red-button" title="Cancel">
					<liferay-ui:message key="cancel" />
				</a>
			</div>
		</div>
	</aui:form>
	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_CONFIGURED_PROCEDURE)}">
		<div class="row">
			<jsp:include page="/setup-procedure-table-listing.jsp" />
		</div>
	</c:if>
</div>

<%@ include file="/add-procedure-group-modal-popup.jsp"%>
<%@ include file="/add-procedure-modal-popup.jsp"%>
<%@ include file="/procedure-delete-modal-popup.jsp"%>

<script type="text/javascript">

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
		<div role="alert" class="text-danger" id="<portlet:namespace/>${element}Error"> The <liferay-ui:message key="\${elementNameWithoutPortletNamespace}" /> field is required.</div>
	</div>`
	$(element).closest('.form-group').append(errorMsg);
}

var configureProcedureJsonArray = [];

	$("#saveConfigureProcedureBtn").on('click',function(){
		var procedureCount = 0;
		var isError = false;
	
		$("#configureProcedureMainDiv").find(".form-control").each(function() {
			var originalName = $(this).attr("name").split("-")[0];
			var originalValue = $(this).val();
			if(originalName !== "<portlet:namespace/>procedureGroup" && originalName !== "<portlet:namespace/>traineeLevel" 
					&& (!originalValue || originalValue === 0 || originalValue === '0')){
				if($(this).closest('.form-group').find('#'+originalName+'Helper').length == 0){
					$(this).closest('.form-group').parent(".d-flex").addClass("cst-error");
					getReqiuredErrorMessage($(this));
					isError = true;
				}else{
					$(this).closest('.form-group').parent(".d-flex").addClass("cst-error");
					isError = true;
				}
			}else{
				//isError = false;
				$(this).closest('.form-group').find('#'+originalName+'Helper').remove()
				$(this).closest('.form-group').parent(".d-flex").removeClass("cst-error");
			}
		});
		$("#configureProcedureMainDiv").find(".sub-card-tms").each(function() {
			let isChecked = true;
			var checkboxElement = $(this).find(".rotation-radio");
			if(!$(checkboxElement).prop('checked')){
				isChecked = false;
			}
			$(this).find(".form-control").each(function() {
				var originalName = $(this).attr("name").split("-")[0];
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
		
		$(".loader-container").addClass("d-flex").removeClass("d-none");
		
		$("#configureProcedureMainDiv").find(".main-card-tms").each(function() {
			let procedureRotationJsonArray = [];
			$(this).find(".form-control").each(function() {
				var originalId = $(this).attr("id").split("-")[0];
		        $(this).attr("id", originalId + "-" + procedureCount);
		        $(this).attr("disabled",false);
		        
		        var originalName = $(this).attr("name").split("-")[0];
		        $(this).attr("name", originalName + "-" + procedureCount); 
		    });
			
			let procedureRotationJsonObj = {};
			procedureRotationJsonObj["procedure"] = procedureCount;
			let rotationCount = 0;
			let rotationJsonArray = [];
			$(this).find(".sub-card-tms").each(function() {
				$(this).find(".form-control").each(function() {
			        var originalId = $(this).attr("id");
			        $(this).attr("id", originalId + "-" +  rotationCount);
			        
			        var originalName = $(this).attr("name");
			        $(this).attr("name", originalName + "-" + rotationCount); 
			    });
				
				rotationJsonArray.push(rotationCount);
				rotationCount++;
		    });
			procedureRotationJsonObj["rotations"] = rotationJsonArray;
			procedureCount++;
			configureProcedureJsonArray.push(procedureRotationJsonObj);
		});
		$("#<portlet:namespace/>configureProcedureRotationJson").val(JSON.stringify(configureProcedureJsonArray));
		//call Ajax Function 
		validateData($('#<portlet:namespace/>programDurationForConfig').val(), JSON.stringify(configureProcedureJsonArray));
	});

	function showHideOftrainneLevel(){
		if (event.target.value == "trainee") {
			event.target.closest(`.sub-card-tms`).querySelector('.traineeLevel').style.display = "block";
		} else {
			event.target.closest(`.sub-card-tms`).querySelector('.traineeLevel').style.display = "none";
			event.target.closest(`.sub-card-tms`).querySelector('#<portlet:namespace/>traineeLevel').value = 0;
			event.target.closest(`.sub-card-tms`).querySelector('#<portlet:namespace/>traineeLevelHelper').remove();
		}
	}

	function getProcedureMasterList(e) {
		var parentDiv = e.closest('.main-card-tms');
		var secondSelect = parentDiv.find('.procedure-select');
		secondSelect.empty().select2();
		let procedureGroupId = e.val();
		$.ajax({
			url: '<%=getProcedureMasterResourceURL%>',
			type: 'POST',
			data:{
				<portlet:namespace/>procedureGroup: procedureGroupId
			},
			success: function(data){
				let programMasterDropdownList = data.programMasterDropdownList;
				secondSelect.append(`<aui:option ><liferay-ui:message key="please-select-procedure" /></aui:option>`);
				for(let i=0; i<programMasterDropdownList.length; i++){
					secondSelect.append("<option value='"+programMasterDropdownList[i].procedureId+"'>" + programMasterDropdownList[i].procedureName + "</option>");
				}
				secondSelect.select2();
			}
		});
		$(".modal-body #<portlet:namespace/>procedureGroupModal").val(procedureGroupId).trigger('change');
		$(".modal-body #<portlet:namespace/>procedureGroupModal").val(procedureGroupId);
	}

	function addProcedureGroupAndProcedureButtonEnable() {
		$(".form-group-procedure-group .form-group-view-program .label-content").empty();
		$(".form-group-procedure-group .form-group-view-cohort .label-content").empty();
		$(".form-group-procedure-group .form-group-view-program .label-content").text($("#<portlet:namespace/>selectProgramForConfig  option:selected").text().trim());
		$(".form-group-procedure-group .form-group-view-cohort .label-content").text($("#<portlet:namespace/>programDurationForConfig  option:selected").text().trim());

		$(".form-group-procedure .form-group-view-program .label-content").empty();
		$(".form-group-procedure .form-group-view-cohort .label-content").empty();
		$(".form-group-procedure .form-group-view-program .label-content").text($("#<portlet:namespace/>selectProgramForConfig  option:selected").text().trim());
		$(".form-group-procedure .form-group-view-cohort .label-content").text($("#<portlet:namespace/>programDurationForConfig  option:selected").text().trim());

		$('.add-procedure-group-btn').prop('disabled', $("#<portlet:namespace/>programDurationForConfig").val() > 0 ? false : true);
		$('.add-procedure-btn').prop('disabled', $("#<portlet:namespace/>programDurationForConfig").val() > 0 ? false : true);
		removeError($('#<portlet:namespace/>programDurationForConfig'));
	}

	function saveProcedureGroupMaster() {
		$("#procedureGroupCloseBtn").click();
		let procedureGroupNameJsonData = {
				"<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>" : $('#<portlet:namespace/>procedureGroupName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>').val(),
				"<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>" : $('#<portlet:namespace/>procedureGroupName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>').val()
		}
		$.ajax({
			url: '<%=saveProcedureGroupURL%>',
			type: 'POST',
			data: {
					<portlet:namespace/>programDurationId: $("#<portlet:namespace/>programDurationForConfig").val(),
					<portlet:namespace/>procedureGroupName: JSON.stringify(procedureGroupNameJsonData)
				},
			success: function(result) {
				$('#<portlet:namespace/>procedureGroupName').val('');
				$('#<portlet:namespace/>procedureGroupName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>').val('');
				$('#<portlet:namespace/>procedureGroupName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>').val('');
				if(result.success) {
					$("#<portlet:namespace/>procedureGroupModal").append("<option value='"+result.procedureGroupId+"'>" + result.procedureGroupName + "</option>");
					$(".procedure-group-select").each(function() {
						$(this).append("<option value='"+result.procedureGroupId+"'>" + result.procedureGroupName + "</option>");
					});
					succMsg = `<liferay-ui:message key="procedure-group-saved" />`;
					let succPopUp = `<div class="alert alert-light alert-success-text" role="alert">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<div class="alert-box">
							<span><img
								src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
								alt="Right"></span>
							<div class="alert-text">
								<h4 class="alert-heading">
									<span>\${succMsg}</span>
								</h4>
							</div>
						</div>
					</div>`;
					$(".display-msg").append(succPopUp);
				} else {
					let errMsg;
					if(result.hasNameError){
						errMsg = `<liferay-ui:message key="procedure-group-name-error" />`;
					} else {
						errMsg = `<liferay-ui:message key="something-went-wrong" />`;
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
				}
			}
		});
	}

	function saveProcedureMaster() {
		var procedureGroupMasterValue = $("#<portlet:namespace/>procedureGroupModal").val();
		let procedureNameJsonData = {
				"<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>" : $('#<portlet:namespace/>procedureName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>').val(),
				"<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>" : $('#<portlet:namespace/>procedureName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>').val()
		}
		let cptCodeNameJsonData;
		enCptCode = $('#<portlet:namespace/>cptCodeName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>').val();
		arCptCode = $('#<portlet:namespace/>cptCodeName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>').val();
		if(!(enCptCode?.length === 0 || arCptCode?.length === 0)) {
			cptCodeNameJsonData = {"<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>": enCptCode === undefined ? "" : enCptCode,"<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>" : arCptCode === undefined ? "" : arCptCode};
		}
		$.ajax({
			url: '<%=saveProcedureURL%>',
			type: 'POST',
			data: {
					<portlet:namespace/>programDurationId: $("#<portlet:namespace/>programDurationForConfig").val(),
					<portlet:namespace/>procedureGroupId: procedureGroupMasterValue,
					<portlet:namespace/>procedureName: JSON.stringify(procedureNameJsonData),
					<portlet:namespace/>cptCodes: JSON.stringify(cptCodeNameJsonData)
				},
			success: function(result)	{
				$("#<portlet:namespace/>procedureGroupModal").val("0");
				$('#<portlet:namespace/>procedureName').val('');
				$('#<portlet:namespace/>procedureName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>').val('');
				$('#<portlet:namespace/>procedureName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>').val('');
				$('#<portlet:namespace/>cptCodeName').val('');
				$('#<portlet:namespace/>cptCodeName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH%>').val('');
				$('#<portlet:namespace/>cptCodeName_<%=OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC%>').val('');
				if(result.success) {
					let procedureGroupId = result.procedureGroupId;
					$("#configureProcedureMainDiv").find(".main-card-tms").each(function() {
					    let procedureGroupSelect = $(this).find('#<portlet:namespace/>procedureGroup');
					    let procedureSelect = $(this).find('#<portlet:namespace/>procedures');
					    if (procedureGroupSelect.val() === procedureGroupId) {
					    	procedureSelect.append("<option value='"+result.procedureId+"'>" + result.procedureName + "</option>");
					    }
					})
					succMsg = `<liferay-ui:message key="procedure-saved" />`;
					let succPopUp = `<div class="alert alert-light alert-success-text" role="alert">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<div class="alert-box">
							<span><img
								src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
								alt="Right"></span>
							<div class="alert-text">
								<h4 class="alert-heading">
									<span>\${succMsg}</span>
								</h4>
							</div>
						</div>
					</div>`;
					$(".display-msg").append(succPopUp);
				} else {
					let errMsg;
					if(result.hasNameError){
						errMsg = `<liferay-ui:message key="procedure-name-error" />`;
					} else {
						errMsg = `<liferay-ui:message key="something-went-wrong" />`;
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
				}
			}
		});
		$("#procedureCloseBtn").click();
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
								<aui:option  selected="true" disabled="true"
									class="placeholder">
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
								id="<portlet:namespace/>traineeLevel" name="<portlet:namespace/>traineeLevel" onchange="removeError($(this))">
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
								ignoreRequestValue="true" onchange="removeError($(this))">
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

	//Remove Sub Card 
	function discardSubCard(){			
		event.target.closest(`.sub-card-tms`).remove();
	}

	// Clone Add Procedure by clicking on add button.
	function addProcedure(){
		counter++;
		const defaultProcedureHtml = 
			`<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="d-flex align-items-end">
							<div class="form-group">
								<label for="<portlet:namespace/>procedureGroup">
									<liferay-ui:message key="procedure-group" />
								</label>
								<select class="custom-select form-control col-11 procedure-group-select js-basic-single"
									label="procedure-group" id="<portlet:namespace/>procedureGroup_\${counter}"
									name="<portlet:namespace/>procedureGroup"
									onChange="getProcedureMasterList($(this))">
									<aui:option selected="true" value="0">
										<liferay-ui:message key="please-select-procedure-group" />
									</aui:option>
									<c:forEach items="${allProcedureGroups}" var="procedureGroup">
										<aui:option value="${procedureGroup.procedureGroupMasterId}">${procedureGroup.getProcedureGroupName(locale)}</aui:option>
									</c:forEach>
								</select>
							</div>
							<button class="btn omsb-bc-red-button omsb-add-btn add-procedure-group-btn mb-3 ml-3"
								type="button" title="Add" data-target="#addProcedureGroupMasterModal"
								data-toggle="modal" disabled="true">
								<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
									alt="<liferay-ui:message key="add-btn" />" />
							</button>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="d-flex align-items-end">
							<div class="form-group">
								<label for="<portlet:namespace/>procedures">
									<liferay-ui:message key="procedures" />
									<span class="reference-mark text-warning">
										<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
											<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
									</span>
								</label>
								<select class="custom-select form-control col-11 procedure-select js-basic-single"
									id="<portlet:namespace/>procedures_\${counter}" name="<portlet:namespace/>procedures" onchange="removeError($(this))">
									<aui:option selected="true" disabled="true"
										class="placeholder">
										<liferay-ui:message key="please-select-procedure" />
									</aui:option>
									<c:forEach items="${allProcedures}" var="procedure">
										<aui:option value="${procedure.procedureMasterId}">${procedure.getProcedureName(locale)}</aui:option>
									</c:forEach>
								</select>
							</div>
							<button class="btn omsb-bc-red-button omsb-add-btn add-procedure-btn mb-3 ml-3"
								type="button" title="Add" data-target="#addProcedureMasterModal"
								data-toggle="modal" disabled="true">
								<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
									alt="<liferay-ui:message key="add-btn" />" />
							</button>
						</div>
					</div>
				</div>

				<div class="omsb-card omsb-BorderRadius-4 sub-card-tms" >
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
									<aui:option  selected="true" disabled="true"
										class="placeholder">
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
									id="<portlet:namespace/>traineeLevel" name="<portlet:namespace/>traineeLevel" onchange="removeError($(this))">
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
									ignoreRequestValue="true" onchange="removeError($(this))">
								</input>
							</div>
						</div>
					</div>

					<div class="bottom-backbtn-wrap mt-0">
						<button class="btn omsb-bc-red-button m-0 addMoreSubCard" onclick="addSubCard()" type="button" title="Add">Add</button>
						<button style="display:none" class="btn omsb-bg-red-button discardSubCard" onclick="discardSubCard()" type="button" title="Discard">Discard</button>
					</div>
				</div>

				<div class="bottom-backbtn-wrap mt-0">
					<button class="btn omsb-bc-red-button m-0 addProcedure" onclick="addProcedure()" type="button" title="Add Procedure">Add Procedure</button>
					<button style="display: none;" class="btn omsb-bg-red-button discardProcedure" onclick="discardProcedure()" type="button" title="Discard Procedure">Discard Procedure</button>
				</div>
			</div>`;
			
		const node = event.target.closest(`#configureprocedures`).querySelector('.main-card-tms');
		$(node).before(defaultProcedureHtml);
		event.target.closest(`.main-card-tms`).querySelector('.addProcedure').style.display = "none";
		event.target.closest(`.main-card-tms`).querySelector('.discardProcedure').style.display = "block";
		addProcedureGroupAndProcedureButtonEnable();
		$(".js-basic-single").each(function() {
		    var elementId = $(this).attr("id");
		    $("#"+elementId).select2();
		});
	}

	//Remove Procedure
	function discardProcedure(){			
		event.target.closest(`.main-card-tms`).remove();
	}
	
	function removeError(e){
		if($(e).val() && $(e).val()!=0){
			$(e).closest('.form-group').find('#'+$(e).attr('name')+'Helper').remove();
		}
	}
	
	function validateData(progDurationId, configureProcedureRotationJson){
        let myform = document.getElementById('<portlet:namespace/>saveConfigureProcedureForm');
        let fd = new FormData(myform);
		$.ajax({
			url: '<%=validateConfigureProcedure%>',
			type: 'POST',
			data: $('#<portlet:namespace/>saveConfigureProcedureForm').serialize(),
			dataType: 'json',  
			success: function(data)	{
				if(data.success) {
					$("#<portlet:namespace />saveConfigureProcedureForm").submit();			
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
					configureProcedureJsonArray = [];
					$("#<portlet:namespace/>configureProcedureRotationJson").val(JSON.stringify(configureProcedureJsonArray));
					window.scrollTo({
			            top: 0,
			            behavior: "smooth" // Use smooth scrolling for a smoother effect (optional)
			        });
				}
			}
		});
	}
	
</script>