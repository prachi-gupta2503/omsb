<%@ include file="init.jsp"%>

<portlet:resourceURL id="/get/all-assigned-training-sites" var="getAllAssignedTrainingSites" />
<portlet:resourceURL id="/get/all-training-sites" var="getAllTrainingSites" /> 
<portlet:resourceURL id="/get/all-assigned-rotations-by-training-site" var="getAllAssignedRotationsByTrainingSite" />
<portlet:resourceURL id="/get/trainee-level-names-by-program-duration" var="getTraineeLevelNamesByProgramDuration" />
<portlet:resourceURL id="/get/trainee-level-names-by-program-duration-and-rotation" var="getTraineeLevelNamesByProgramDurationAndRotation" />
<portlet:resourceURL id="/get/rotations-and-blocks-by-program-duration" var="getRotationsAndBlocksByProgramDuration" />
<portlet:resourceURL id="/get/all-rotations" var="getAllRotations" />
<portlet:resourceURL id="/get/all-programs" var="getAllPrograms" />
<portlet:resourceURL id="/get/all-program-durations" var="getAllProgramDurations" />
<portlet:resourceURL id="/save/assigned-rotation-and-traineeblocks-to-program-cohort" var="assignedRotationAndTraineeBlocksToProgramCohort" />
<portlet:resourceURL  id="/delete/rotation-from-program-cohort" var="deleteRotationFromProgramCohort" />
<portlet:resourceURL id="/save/slots-to-rotation-and-training-site" var="saveSlotsToRotationAndTrainingSite" />
<portlet:resourceURL id="/save/training-site" var="saveTrainingSite" />
<portlet:resourceURL id="/get/all-assigned-training-sites" var="getAllAssignedTrainingSites" />
<portlet:resourceURL id="/save/rotations-and-slots-to-training-site" var="saveRotationsAndSlotsToTrainingSite" />
<portlet:resourceURL id="<%=OmsbProgramConstants.GET_ELECTIVE_ROTATIONS_MVC_RESOURCE_COMMAND %>" var="fetchElectiveRotations"/>
<portlet:resourceURL id="/get/objectiveDetails" var="getObjectiveDetails" />
<portlet:resourceURL id="/get/all-rotations-for-configure-rotations-training-site" var="getAllRotationsForConfigureRotationsTrainingSite" />

<%
    Locale arLocale = new Locale("ar", "SA");
	Locale usLocale = new Locale("en", "US");
%>

<input type="hidden" id="USLocale" name="USLocale" value="<%= usLocale %>" />
<input type="hidden" id="ARLocale" name="USLocale" value="<%= arLocale %>" />
<div class="loader-container loaded d-none" id="pageLoaderContainerId" >
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
		<c:choose>
			<c:when test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_SELECT_COHORT_FOR_OBJECTIVE)}"> 
				<h4 class="select-cohort omsb-card-title"><liferay-ui:message key="select-cohort" />
	                 <div class="form-group select_cohort">
	                     <select class="custom-select form-control" id="cohort">
		                     <c:forEach items="${programDurationDetailList}" var="programDuration">
		                         <option value="${programDuration.progDurationId}">${programDuration.ayApplicableForm}</option>
		                     </c:forEach>
	                     </select>
	                 </div>
	             </h4>
	         </c:when>
             <c:otherwise>
                <h4 class="select-cohort omsb-card-title d-none"><liferay-ui:message key="select-cohort" />
                     <div class="form-group select_cohort">
                         <select class="custom-select form-control" id="cohort">
                             <c:forEach items="${programDurationDetailList}" var="programDuration">
                                 <option value="${programDuration.progDurationId}">${programDuration.ayApplicableForm}</option>
                             </c:forEach>
                         </select>
                     </div>
                 </h4>
            </c:otherwise> 
          </c:choose>  
			<jsp:include page="/program-objective.jsp" />
              <div class="omsb-cards-wrap pediatrics-training-sites mt-4">
                  <div class="omsb-card-graybg omsb-card omsb-BorderRadius-4">
                     <h4 class="omsb-card-title"> ${program.getProgramName(locale)} - <liferay-ui:message key="training-sites" />
	                  	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_MANAGE_TRAINEE_SITE)}"> 
	                          <button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#manage-training-sites" type="button" id="manage-training-sites-btn"> <liferay-ui:message key="manage-training-sites" /> </button>
	                    </c:if>
                      </h4>
                      <div class="row" id="trainingSitesCardsRow">
                      </div>
                  </div>
              </div>

              <div class="omsb-cards-wrap pediatrics-training-sites mt-4 d-none" id="siteCapacityRotationDiv">
                  <div class="omsb-card-graybg omsb-card omsb-BorderRadius-4">
	                   <c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_CONFIGURE_ROTATION)}">
	                      <h4 class="omsb-card-title"> <div id="siteCapacityRotationDivTitle"> </div>
	                          <button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#configure-rotation" onclick="showConfigureRotationModal('rotation0')" id="configure-rotation-btn" type="button">
	                          <img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="configure-rotation" /> </button>
	                      </h4>
	                    </c:if>
                      <div class="omsb-list-view table-responsive">
                      	   <div id="siteCapacityInformation"> </div>
                      	   <div class="omsb-card omsb-BorderRadius-4 text-center" id="training-sites-rotations-table-no-data-found">
								<div class="omsb-no-data-found"><liferay-ui:message key="no-rotations-found" /></div>
							</div>
                      	   
                          <table class="display omsb-datatables" id="siteCapacityRotationTable">
                              <thead>
                                  <tr>
                                  	  <c:choose>
                                  	  	<c:when test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_CONFIGURE_SITE_CAPACITY)}">
                                      		<th> <liferay-ui:message key="rotation" /> </th>
                                      		<th> <liferay-ui:message key="slots" /> </th>
                                      		<th> <liferay-ui:message key="action" /> </th>
                                      	</c:when>
                                      	<c:otherwise>
                                      		<th width="50%"> <liferay-ui:message key="rotation" /> </th>
                                      		<th width= "50%"> <liferay-ui:message key="slots" /> </th>
                                      	</c:otherwise>
                                      </c:choose>
                                  </tr>
                              </thead>
                              <tbody id="siteCapacityRotationTableTBody">
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>

              <div class="omsb-cards-wrap pediatric-rotations mt-4">
                  <div class="omsb-card-graybg omsb-card omsb-BorderRadius-4">
                      <h4 class="omsb-card-title"> ${program.getProgramName(locale)} <liferay-ui:message key="rotations" />
                        <div class="bottom-backbtn-wrap">
                        	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_ROTATION)}">
                              <a class="btn omsb-bg-red-button" href="#" id="add-rotation">
                                  <img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="add-rotation" />
                              </a> &nbsp;
                             </c:if> 
                             <c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ASSIGN_ROTATION)}">
                              <button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#assign_rotation" onclick="prepareAssignRotationDetailsModal()" type="button">
                                  <liferay-ui:message key="asign-rotation" />
                              </button>
                        	</c:if>    
                         </div>                                       
                      </h4>
                      <p><span class="elective_rotation_indentity">E</span> - <liferay-ui:message key="elective-rotation" /> &nbsp; <span class="shared_rotation_indentity">S</span> - <liferay-ui:message key="shared-rotation" /></p>
                      <div class="omsb-list-view table-responsive">
                          <table class="display omsb-datatables" id="program-rotations-table">
                          </table>
                            <div class="omsb-card omsb-BorderRadius-4 text-center" id="program-rotations-table-no-data-found">
								<div class="omsb-no-data-found"><liferay-ui:message key="no-rotations-found" /></div>
							</div>
                      </div>
                  </div>
              </div>
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ELECTIVE_ROTATION) && !permissionChecker.isOmniadmin()}">
				<div class="omsb-cards-wrap pediatrics-training-sites mt-4">
					<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="my-elective-rotation" />
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_CONFIGURE_ELECTIVE_ROTATION)}">
							<button class="btn omsb-bg-red-button" data-toggle="modal"
								data-target="#configure-elective-rotation" id="elective-rotation-btn"
								type="button">
								<img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg"
									alt="">
								<liferay-ui:message key="configure-elective-rotations" />
							</button>
							</c:if>
						</h4>
						<c:choose>
							<c:when test="${traineeElectiveRotationsList.size() == 0}">
								<div class="omsb-list-view table-responsive">
									<div class="omsb-card omsb-BorderRadius-4 text-center"
										id="elective-rotations-table-no-data-found">
										<div class="omsb-no-data-found">
											<liferay-ui:message key="no-elective-rotations-found" />
										</div>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="omsb-list-view table-responsive">
									<table class="display omsb-datatables"
										id="electiveRotationTable">
										<thead>
											<tr>
												<th><liferay-ui:message key="rotation" /></th>
												<th><liferay-ui:message key="trainee-level" /></th>
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ELECTIVE_ROTATION_DELETE)}">
													<th><liferay-ui:message key="action" /></th>
												</c:if>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${traineeElectiveRotationsList}"
												var="traineeElectiveRotation">
												<tr>
													<c:choose>
														<c:when test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ELECTIVE_ROTATION_EDIT)}">
														<td data-toggle="modal"
															data-target="#configure-elective-rotation"
															data-traineelevelid="${traineeElectiveRotation.traineeLevelId}"
															data-traineePdTlErDetailsId="${traineeElectiveRotation.traineePdTlErDetailsId}"
															class="edit-elective-rotation clickable clickable_underline"
															onclick='editTraineeElectiveRotation($(this))'>${traineeElectiveRotation.electiveRotation}</td>
														</c:when>
														<c:otherwise>
														<td>${traineeElectiveRotation.electiveRotation}</td>
														</c:otherwise>
													</c:choose>
													<td>${traineeElectiveRotation.traineeLevel}</td>
													<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_ELECTIVE_ROTATION_DELETE)}">
														<td>
															<button type="button"
																class="btn omsb-dd-button openElectiveRotationDeleteModal"
																id="${traineeElectiveRotation.electiverotationPriorityDetailsId}"
																data-target="#deleteElectiveRotationModal"
																data-toggle="modal">
																<i class="fa fa-trash-o"></i>
																<liferay-ui:message key="delete" />
															</button>
														</td>
													</c:if>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<jsp:include page="/trainee-elective-rotation-modal-popup.jsp" />
			</c:if>
		</div>
	</div>
</div>

<script>

$(document).ready(function() {
	getObjectiveDetails($('#cohort').val(), '${getObjectiveDetails}');
	getAssignedTrainingSites($('#cohort').val(), '${getAllAssignedTrainingSites}');
	getRoationsAndBlocksByProgramDuration();
	
	$('#electiveRotationTable').DataTable({
		dom: 'Bfrtip',
		buttons: [
    		{
              extend: 'colvis',
              text: '<liferay-ui:message key="column-visibility" />',
              columns: ":not(':last')"
            },
    	    {
    	        extend: 'collection',
    	        text: '<liferay-ui:message key="export-as" />',
    	        buttons: [
    	            {
    	                extend: 'csv',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            },
    	            {
    	                extend: 'pdf',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            },
    	            {
    	                extend: 'excel',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            },
    	            {
    	                extend: 'print',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            }
    	        ]
    	    }
    	]
	});	

	$(".modal-backdrop").remove();
});

$(document).on("click",".openElectiveRotationDeleteModal", function(){
	$('.deleteElectiveRotationDetails #<portlet:namespace/>electiverotationPriorityDetailsId').val($(this).attr('id'));
});

function editTraineeElectiveRotation(e) {
	resetElectiveRotationForm();
	loadElectiveRotations($(e).data('traineelevelid'), $(e).data('traineepdtlerdetailsid'), '${fetchElectiveRotations}');	
}

$('#cohort').change(function() {
	$('#pageLoaderContainerId').removeClass('d-none').addClass('d-flex');
	$("#siteCapacityRotationDiv").addClass("d-none");
	getObjectiveDetails($('#cohort').val(), '${getObjectiveDetails}');
	getAssignedTrainingSites($('#cohort').val(), '${getAllAssignedTrainingSites}');
	getRoationsAndBlocksByProgramDuration();
	if(${isFaculty}) {
		getProgramObjectiveAndSpecificObjectives();
	}
});

function isNumber (e) {
    e.value = e.value.replace(/[^0-9]/g,'');
};

function hideTrainingSiteForm(){
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteName').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteName_en_US').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteName_ar_SA').val(``);
	
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteAddress').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteAddress_en_US').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteAddress_ar_SA').val(``);
	
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteCode').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteCode_en_US').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteCode_ar_SA').val(``);
	
	document.getElementById("_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteStatus").selectedIndex = 0;
	
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteDescription').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteDescription_en_US').val(``);
	$('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteDescription_ar_SA').val(``);
	CKEDITOR.instances['_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteDescriptionEditor'].setData('');
	
	$('#addTrainingSiteForm').addClass("d-none");
}

function isValidNumber(value){
	if (value.match(/[^0-9]/g)) {
		return true;
	} else {
		return false;
	}
}

function isBlank(value){
	 if (value != null && value != '') {  
		return false;
	 } else {  
        return true; 
     } 
}

function clearPopups() {
	$("#traineeLevelBlocksDiv").html("");
	$("#traineeLevelBlocksDivForEdit").html("");
}

$("#manage-training-sites-btn").click(function(){
	let resourceUrl = "${getAllTrainingSites}";
	getAllTrainingSites($('#cohort').val(), resourceUrl);
});

function removeChildConfigureRotationDiv(){
	$(".childConfigureRotationDiv").remove();
	$("#rotationsloterror0").html("");
	$("#slots0").val('');
}

function removeConfigureRotationBlock(id){
	//$("#childDiv" + id ).remove();
}

function hideAndResetTrainingSiteForm(){
	$('#addTrainingSiteForm').addClass("d-none");
}

function prepareAssignRotationDetailsModal(){
	getAllPrograms();
	getTraineeLevelNamesByProgramDuration();
	getAllRotationsForAssignRotations();
}

function prepareEditAssignRotationDetailsModal(e, rotationId){
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${getTraineeLevelNamesByProgramDurationAndRotation}',
		type : 'POST',
		data : {
			<portlet:namespace/>programDurationId : $('#cohort').val(),
			<portlet:namespace/>rotationMasterId : rotationId,
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			if(payload.result.length > 0) {
				var traineeLevelIds = [];
				var traineeLevelBlocksDiv = ``;
				var traineeLevelBlocks = payload.result[0].traineeLevelDTOs;
				var rotationName = payload.result[0].rotationName;
				for(let i=0; i < traineeLevelBlocks.length; i++) {
					var traineeLevelBlock = traineeLevelBlocks[i];
					traineeLevelIds.push(traineeLevelBlock.traineeLevelMasterId);
					traineeLevelBlocksDiv += `<div class="row">
											<div class="col-md-6">
											<div class="form-group">
												<label>\${traineeLevelBlock.traineeLevelName}
													<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
												</label>  
												<input type="number" class="form-control" placeholder='<liferay-ui:message key="no-of-blocks" />' step="1" min="0" id="traineeLevelBlocks\${traineeLevelBlock.traineeLevelMasterId}" value="\${traineeLevelBlock.noOfBlocks}" />
												<div class="form-feedback-item text-danger d-none" id="traineeLevelBlocks\${traineeLevelBlock.traineeLevelMasterId}Error"></div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label><liferay-ui:message key="rotation-type" />
													<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
												</label> 
												<select class="form-control custom-select" id="assignRotationType\${traineeLevelBlock.traineeLevelMasterId}" value="\${traineeLevelBlock.rotationType}">
													<c:forEach items="${rotationTypeMasterList}" var="rotationType">
														<option value="${rotationType.rotationTypeMasterId}">${rotationType.getRotationTypeName(locale)}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>`;
				}
			}
			$("#editAssignRotationName").html(rotationName + ` <liferay-ui:message key="rotations" />`);
			$("#traineeLevelBlocksDivForEdit").html(traineeLevelBlocksDiv);
			for(let i=0; i < traineeLevelBlocks.length; i++) {
				var traineeLevelBlock = traineeLevelBlocks[i];
				$("#assignRotationType"+traineeLevelBlock.traineeLevelMasterId+ " option[value='"+traineeLevelBlock.rotationType+"']").attr("selected", "selected");
			}
			$("#updateAssingedRotationAndBlocksToProgramCohort").data("traineeLevelIds", traineeLevelIds);
			$("#updateAssingedRotationAndBlocksToProgramCohort").data("rotationId", rotationId);
		}
	});
}

/* Add Selected Training Site for the Current Program Duration */
function addSelectedTrainingSite(data, valueData){
	$("#trainingSitesSortlist").empty();
	$.each(data, function( index, item ) {
		$("#trainingSitesSortlist").append("<li value='"+valueData[index].value+"' class = 'selected-elective-rotation-list'>"+ item.name +"</li>")
	});
	slist(document.getElementById("trainingSitesSortlist"));
}

$(document).on("click",".openDeleteModalForRotationTrainingSite", function(){
	$('#deleteRotationFromTrainingSiteModelSubmitButton').data("progDurationRotationTsRelId",$(this).data('id'));
});

$(document).on("click",".openDeleteModalForRotationProgram", function(){
	$('#deleteRotationFromProgramModalSubmitButton').data("rotationMasterId",$(this).data('id'));
});

/* Select or Deselect Training Site for the Current Program Duration */
function updateSelectedTrainingSite() {
	$("#trainingSitesSortlist").empty();
	var data = [];
	var valueData = [];
	$('.rotation-checkbox:checkbox:checked').each(function () {
        data.push({name: $(this).val()});
 		valueData.push({value: $(this).attr("data-id") });
 		addSelectedTrainingSite(data, valueData);
     });
}

function destroyProgramRotationTable(){
	try {
		if ( $.fn.DataTable.isDataTable('#program-rotations-table') ) {
			$('#program-rotations-table').DataTable().destroy();
			$('#program-rotations-table').empty();
		}
	}
    catch (exc) {
      console.log(exc);
    }
}

function createProgramRotationTableColumns(dataResult){
	var isEditRotation = '${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_EDIT_ASSIGN_ROTATION)}';
	var isDeleteRotation = '${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_ASSIGN_ROTATION)}';

	var columns = [];
	if(dataResult.length > 0) {
	    var rotationDTO = dataResult[0];
	    columns.push({
	        title : `<liferay-ui:message key="rotations" />`,
	        data :  'rotationName'
	    });
	    for(let j = 0; j < rotationDTO.traineeLevelDTOs.length; j++) {
	        var traineeLevelDTO = rotationDTO.traineeLevelDTOs[j];
	        columns.push({
	            title : traineeLevelDTO.traineeLevelName,
	            data :  'noOfBlocks'+traineeLevelDTO.traineeLevelMasterId
	        });        
	    };
	    if(isEditRotation === "true" || isDeleteRotation === "true"){
	      columns.push({
	        title : `<liferay-ui:message key="action" />`,
	        data :  'action'
	    });
	    }
	}
	return columns;
}

function prepareDataForProgramRotationTables(dataResult) {
	var isEditRotation = '${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_EDIT_ASSIGN_ROTATION)}';
	var isDeleteRotation = '${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_ASSIGN_ROTATION)}';

	var showResults = [];
	for(let i = 0; i < dataResult.length; i++) {
	    var rotationDTO = dataResult[i];
	   	var jsonObj = {};
	   	
	   	// Validate isShared rotation or not
	   	if(rotationDTO.sharedRotation) {
	   		jsonObj['rotationName'] = `<div class="electiveRotation_wrap"> <a href="\${rotationDTO.rotationRenderUrl}" class="clickable clickable_underline" />  \${rotationDTO.rotationName} <span class="electiveRotation" >S</span> </a></div>`;	
	   	} else {
	   		jsonObj['rotationName'] = `<a href="\${rotationDTO.rotationRenderUrl}" class="clickable clickable_underline" />  \${rotationDTO.rotationName} </a>`;
	   	}
	    
	    for(let j = 0; j < rotationDTO.traineeLevelDTOs.length; j++) {
	        var traineeLevelDTO = rotationDTO.traineeLevelDTOs[j];
	       	jsonObj['traineeLevelName'] = traineeLevelDTO.traineeLevelName;
	       	
	    	var noOfBlocks = traineeLevelDTO.noOfBlocks;
	    	
	       	if(traineeLevelDTO.noOfBlocks == 0 || traineeLevelDTO.noOfBlocks == '0') {
	       		noOfBlocks = `-`;
	       	} 
	       	
	       	if(traineeLevelDTO.elective){
	       		noOfBlocks = `<div class="elective_wrap">\${noOfBlocks} <span class="elective">E</span></div>`;
	       		
	       		
	       	}
	       
	        jsonObj['noOfBlocks'+traineeLevelDTO.traineeLevelMasterId] = noOfBlocks;
	        
	    }
	    if(isEditRotation === "true" || isDeleteRotation === "true"){
	    	actionData  = `<div class="dropdown ">
										<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">`;
									 if(isEditRotation === "true"){
										 actionData  +=	`<li><a href="javascript:void(0)" class="dropdown-item" data-target="#edit_assign_rotation" data-toggle="modal" id="rotationDTO\${rotationDTO.rotationId}" onclick="prepareEditAssignRotationDetailsModal(this, \${rotationDTO.rotationId})"><i class="fa fa-pencil"></i> <liferay-ui:message key="edit" /></a>
										</li>`;
									 } if(isDeleteRotation === "true"){
										 actionData  += `<li><a href="javascript:void(0)" class="dropdown-item openDeleteModalForRotationProgram" id="\${rotationDTO.rotationId}" data-id="\${rotationDTO.rotationId}" data-target="#openDeleteModalForRotationProgram" data-toggle="modal"><i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" /> </a>
										</li>`;
									 }
									 actionData  +=	`</ul></div>`;
							
		   jsonObj['action'] = actionData;
	    }
		showResults.push(jsonObj);
	}
	
	return showResults;
}

/* AJAX CALLS  */

function showConfigureRotationModal(configureRotaitonListId){
	var trainingSiteId = $("#configure-rotation").data("trainingSiteId");
	console.log("showConfigureRotationModal programCohort ::: " + $('#cohort').val());
	console.log("showConfigureRotationModal trainingSiteId ::: " + trainingSiteId);
	console.log("showConfigureRotationModal configureRotaitonListId ::: " + configureRotaitonListId);
	 $.ajax({
			url : '${getAllRotationsForConfigureRotationsTrainingSite}',
			type : 'POST',
			data : {
				<portlet:namespace/>programDurationId : $('#cohort').val(),
				<portlet:namespace/>trainingSiteMasterId : trainingSiteId
			},
			success : function(payload) {				
				$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
				$('#configure-rotation-title').html(payload.trainingSiteName + ` <liferay-ui:message key="rotations" />`);
				$('#'+configureRotaitonListId).empty();
				if(payload.result.length > 0) {
					$('#'+configureRotaitonListId).append(`<option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></option>`);
					for (let i = 0; i < payload.result.length; i++) {
						$('#'+configureRotaitonListId).append(`<option value="\${payload.result[i].rotationMasterId}"> \${payload.result[i].rotationName} </option>`);
					}
				}		
			}
		});
	
}

function getAssignedTrainingSites(programCohortId, resourceCommandUrl){
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	 $.ajax({
		url : resourceCommandUrl,
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : programCohortId
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			let card = '';
			if(payload.result.length > 0) {
				for (let i = 0; i < payload.result.length; i++) {
					card = card + `<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 mt-4">
                    <div class="card-info ">
                    <h5>\${payload.result[i].trainingSiteName}</h5>
                    <div class="buttons-wrap_pediatrics">
                        <a href="\${payload.result[i].viewTrainingSiteDetailsUrl}" class="view_program_details_button"><img src="${themeDisplay.getPathThemeImages()}/svg/view.svg" alt="view"> <liferay-ui:message key="view-training-site-details" /> </a>
		                  	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_CONFIGURE_SITE_CAPACITY)}"> 
	                        	<button type="button" class="view_cohort_button" onclick="getAssignedRotationsToSelectedTrainingSite( \${payload.result[i].trainingSiteMasterId}, \${programCohortId}, '${getAllAssignedRotationsByTrainingSite}', '\${payload.result[i].trainingSiteName}')"><img src="${themeDisplay.getPathThemeImages()}/svg/raise.svg" alt=""> <liferay-ui:message key="configure-site-capacity" /> </button>
	                        </c:if>
		                  	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_VIEW_SITE_CAPACITY) && !permissionChecker.isOmniadmin()}"> 
	                        	<button type="button" class="view_cohort_button" onclick="getAssignedRotationsToSelectedTrainingSite( \${payload.result[i].trainingSiteMasterId}, \${programCohortId}, '${getAllAssignedRotationsByTrainingSite}', '\${payload.result[i].trainingSiteName}')"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg" alt="view"> <liferay-ui:message key="view-site-capacity" /> </button>
                        </c:if>
                    </div>
                </div>
            </div>`;
				}
			} else {
				card = `<div class="col-md-12"> <div class="omsb-card omsb-BorderRadius-4 text-center">
					<div class="omsb-no-data-found"><liferay-ui:message key="no-such-training-sites-found" /></div>
					</div></div>`;
			}
			$('#trainingSitesCardsRow').html(card);
		}
	});
}

function setConfigureSingleRotationModalDetails(rotationName, noOfSlots, progDurationRotationTsRelId, trainingSiteName){
	$("#configure-single-rotation-name").html(rotationName);
	$("#configure-single-rotation-slots-error").html(``);
	$("#configure-single-rotation-slots-error").addClass("d-none");
	$("#configure-single-rotation-slots").val(noOfSlots);
	$("#configure-single-rotation-progDurationRotationTsRelId").val(progDurationRotationTsRelId);
	$("#configure-single-rotation-dialog-title").html(trainingSiteName);
}


function getAssignedRotationsToSelectedTrainingSite(trainingSiteMasterId, programCohortId, resourceCommandUrl, trainingSiteName){
	$("#siteCapacityRotationDiv").removeClass("d-none");
	$("#siteCapacityRotationDivTitle").html(trainingSiteName + ` <liferay-ui:message key="rotations" />`);
	
	let siteCapacityInformation = `<input type="hidden" id="siteCapacityInformationInput" data-trainingSiteMasterId="\${trainingSiteMasterId}" data-trainingSiteName="\${trainingSiteName}" />`;
	$("#siteCapacityInformation").html(siteCapacityInformation);
	
	// set trainnig site id to configure-rotaiton button as data : data-trainingSiteId 
	$("#configure-rotation").data("trainingSiteId",trainingSiteMasterId);
	
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	 $.ajax({
		url : resourceCommandUrl,
		type : 'POST',
		data : {
			<portlet:namespace/>trainingSiteMasterId : trainingSiteMasterId,
			<portlet:namespace/>programDurationId : programCohortId
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			let card = '';
 			if(payload.result.length > 0) {
 				$("#training-sites-rotations-table-no-data-found").addClass("d-none");
 				$("#siteCapacityRotationTable").removeClass("d-none");
				var trainingSiteName = payload.trainingSiteName;
				for (let i = 0; i < payload.result.length; i++) {
					card = card + `<tr>
		                    <td>
		                    	<c:choose>
			                    	<c:when test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_CONFIGURE_SITE_CAPACITY)}">
			                    		<a href="javascript:void(0)" class="configureRotationNameColumn clickable clickable_underline"data-toggle="modal" data-target="#configure-single-rotation" onclick="setConfigureSingleRotationModalDetails( '\${payload.result[i].rotationName}', \${payload.result[i].noOfslots}, \${payload.result[i].progDurationRotationTsRelId}, '\${trainingSiteName}')" > \${payload.result[i].rotationName} </a>
			                   		</c:when>
			                   		<c:otherwise>
			                   			<a href="javascript:void(0)" class="configureRotationNameColumn clickable" > \${payload.result[i].rotationName} </a>
			                 		</c:otherwise>
		                   		</c:choose>
	                   		</td>
		                    <td>\${payload.result[i].noOfslots}</td>
		                    <c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_CONFIGURE_SITE_CAPACITY)}">
		                    	<td><a href="javascript:void(0)" class="btn omsb-dd-button openDeleteModalForRotationTrainingSite" id="\${payload.result[i].progDurationRotationTsRelId}" data-id="\${payload.result[i].progDurationRotationTsRelId}" data-target="#openDeleteModalForRotationTrainingSite" data-toggle="modal"><img src="${themeDisplay.getPathThemeImages()}/svg/delete.svg"> <liferay-ui:message key="delete" /></button></td>
		                	</c:if>
		                    </tr>`;
				}
			} else {
				$("#training-sites-rotations-table-no-data-found").removeClass("d-none");
				$("#siteCapacityRotationTable").addClass("d-none");
				// card = `<div class="col-md-12"> <div class="card-info "><div class="omsb-no-data-found"><p><liferay-ui:message key="no-such-programs-found" /></p></div></div></div>`;
			}
			$('#siteCapacityRotationTableTBody').html(card);
		}
	});
}

/* Delete Rotation From Training Site  */
function deleteRotationFromTrainingSite(e, resourceCommandUrl){
	let progDurationRotationTsRelId = $("#" + e.id).data("progDurationRotationTsRelId");
	var trainingSiteId = $("#configure-rotation").data("trainingSiteId");
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	 $.ajax({
		url : resourceCommandUrl,
		type : 'POST',
		data : {
			<portlet:namespace/>progDurationRotationTsRelId : progDurationRotationTsRelId,
			<portlet:namespace/>trainingSiteId : trainingSiteId
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			$("#deleteRotationFromTrainingSiteModelCancelButton").click();
			if(payload.success) {
				$("#successMessage").html(`<liferay-ui:message key="rotation-deleted-successfully" />`);
				$("#successModal").modal("show");
				var trainingSiteName = payload.result.trainingSiteName;
				getAssignedRotationsToSelectedTrainingSite(trainingSiteId,$('#cohort').val(), '${getAllAssignedRotationsByTrainingSite}',trainingSiteName); 
				
			} else {
				console.log("ERROR DELETE POPUP");
			}
		},
		error: function(xhr){
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
	        console.log('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
	    }

	});
}

/* Delete Rotation and TraineeLevel From Program  */
function deleteRotationFromProgram(e){
	let rotationMasterId = $("#" + e.id).data("rotationMasterId");
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	 $.ajax({
		url : '${deleteRotationFromProgramCohort}',
		type : 'POST',
		data : {
			<portlet:namespace/>progDurationId : $('#cohort').val(),
			<portlet:namespace/>rotationMasterId : rotationMasterId
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			$("#deleteRotationFromProgramModalCancelButton").click();
			if(payload.success) {
				getRoationsAndBlocksByProgramDuration();
				$("#successMessage").html(`<liferay-ui:message key="rotation-deleted-successfully" />`);
				$("#successModal").modal("show");
			} else {
				console.log("ERROR DELETE POPUP");
			}
		},
		error: function(xhr){
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
	        console.log('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
	    }

	});
} 

/* Get All Training Site From Master And Mark Selected Whichever assgined to Current Program Cohort(Duration) */
function getAllTrainingSites(programCohortId, resourceCommandUrl) {
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : resourceCommandUrl,
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : programCohortId
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			$('#allTrainingSites').html("");
			$("#trainingSitesSortlist").empty();
			var index = 1;
			var electiveRotationDiv = "";
			if(payload.result.length > 0) {
				for (let i = 0; i < payload.result.length; i++) {
					let ckd = "";
					if(payload.result[i].isSelected){
						ckd = "checked";
						$("#trainingSitesSortlist").append("<li value='"+ payload.result[i].trainingSiteMasterId +"' class = 'selected-elective-rotation-list'>"+ payload.result[i].trainingSiteName +"</li>");
					}
					electiveRotationDiv += "<div class='elective_rotation_list'><div class='custom-control custom-checkbox '><input type='checkbox' onchange='updateSelectedTrainingSite()' "+ ckd +" class='custom-control-input rotation-checkbox' data-id='"+ payload.result[i].trainingSiteMasterId +"' value='"+ payload.result[i].trainingSiteName +"' id='rotation"+ payload.result[i].trainingSiteMasterId +"' name='elective_srotation'><label class='custom-control-label' for='rotation"+ payload.result[i].trainingSiteMasterId +"'>"+ payload.result[i].trainingSiteName +"</label></div></div>";
				}
			} 
			$('#allTrainingSites').html(electiveRotationDiv);
			slist(document.getElementById("trainingSitesSortlist"));
		}
	});
}

function assignedTrainingSiteToProgramCohort(resourceCommandUrl) {
	var trainingSiteIds = [];
	$('.rotation-checkbox:checkbox:checked').each(function () {
        trainingSiteIds.push($(this).attr("data-id"));
     });
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : resourceCommandUrl,
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : $('#cohort').val(),
			<portlet:namespace/>trainingSiteIds : trainingSiteIds
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			if(payload.success){
				/* Show Success Popup */
				$("#cancel-manage-training-sites").click();
				hideAndResetTrainingSiteForm();
				getAssignedTrainingSites($('#cohort').val(), '${getAllAssignedTrainingSites}');
				$("#successMessage").html(`<liferay-ui:message key="assigned-training-site-successfully" />`);
				$("#successModal").modal("show");
			} else {
				/* Show Error Popup */
			}
		}
	});
}

function assignRotationsToSelectedTrainingSite(){
    var rotationJsons = [];
    var roationIds = [];
    var isValidData = true;
    $('[name="configureRotations"]').each(function () {
    	if(roationIds.includes(this.value)) {
    		$("#rotationerror" + (this.id.replace("rotation",""))).removeClass("d-none");
    		isValidData = false;
    	} else {
    		$("#rotationerror" + (this.id.replace("rotation",""))).addClass("d-none");
    		roationIds.push(this.value);	
    	}
	  });
    
    var rotationSlots = [];
    $('[name="configureRotations"]').each(function () {
    	if(isBlank(this.value) || this.value=='0') {
    		$("#rotationerror" + (this.id.replace("rotation",""))).removeClass("d-none");
    		$("#rotationerror" + (this.id.replace("rotation",""))).html(`<liferay-ui:message key="rotation-field-required" />`);
    		isValidData = false;
    	} else {
    		$("#rotationerror" + (this.id.replace("rotation",""))).addClass("d-none");
    		$("#rotationerror" + (this.id.replace("rotation",""))).html(``);
    	}
	});
    $('[name="configureRotationsSlots"]').each(function () {
    	if(isBlank(this.value)) {
    		$("#rotationsloterror" + (this.id.replace("slots",""))).removeClass("d-none");
    		$("#rotationsloterror" + (this.id.replace("slots",""))).html(`<liferay-ui:message key="number-of-blocks-field-required" />`);
    		isValidData = false;
    	} 
    	else if(this.value < 1 ){
    		$("#rotationsloterror" + (this.id.replace("slots",""))).removeClass("d-none");
    		$("#rotationsloterror" + (this.id.replace("slots",""))).html(`<liferay-ui:message key="number-should-be-greater-than-zero" />`);
    		isValidData = false;
    	}
    	else {
    		$("#rotationsloterror" + (this.id.replace("slots",""))).addClass("d-none");
    		$("#rotationsloterror" + (this.id.replace("slots",""))).html(``);
    	}
	});
   	if(isValidData) {
   		rotationSlots.push(this.value);	
   	}
    // Prepare the Json
    $.each(roationIds, function( index, value ) {
         var json = {};
         json["rotation"] = value;
         json["noOfSlots"] = rotationSlots[index];
         rotationJsons.push(json);
    });
    
    if(isValidData) {
    	saveRotationsToSelectedTrainingSite(rotationJsons);
    }
}

function saveRotationsToSelectedTrainingSite(rotationJsons) {
	var trainingSiteId = $("#configure-rotation").data("trainingSiteId");
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${saveRotationsAndSlotsToTrainingSite}',
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : $('#cohort').val(),
			<portlet:namespace/>rotationJsons : JSON.stringify(rotationJsons),
			<portlet:namespace/>trainingSiteId : trainingSiteId
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			$("#assignRotationsToSelectedTrainingSiteCancelButton").click();
			if(payload.success){
				$("#successMessage").html(`<liferay-ui:message key="rotation-and-slots-assigned-to-training-site-successfully" />`);
				$("#successModal").modal("show");
				var trainingSiteName = payload.result.trainingSiteName;
				getAssignedRotationsToSelectedTrainingSite(trainingSiteId,$('#cohort').val(), '${getAllAssignedRotationsByTrainingSite}',trainingSiteName); 
				getRoationsAndBlocksByProgramDuration();
			} else {
				console.log("Show Error Popup");
			}
		}
	});
}

function getTraineeLevelNamesByProgramDuration() {
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${getTraineeLevelNamesByProgramDuration}',
		type : 'POST',
		data : {
			<portlet:namespace/>programDurationId : $('#cohort').val()
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			var traineeLevelIds = [];
			var traineeLevelBlocks = ``;
			for(let i=0; i < payload.result.length; i++) {
				traineeLevelIds.push(payload.result[i].traineeLevelMasterId);
				traineeLevelBlocks += `<div class="row">
										<div class="col-md-6">
										<div class="form-group">
											<label>\${payload.result[i].traineeLevelName}
												<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
											</label>
											<input type="number" class="form-control" placeholder='<liferay-ui:message key="no-of-blocks" />' value="" step="1" min="0" onkeyup="isNumber(this)" id="traineeLevelBlocks\${payload.result[i].traineeLevelMasterId}" />
											<div class="form-feedback-item text-danger d-none" id="traineeLevelBlocks\${payload.result[i].traineeLevelMasterId}Error"></div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label><liferay-ui:message key="rotation-type" />
												<span class="reference-mark text-warning" id="jbfs__column__2d__1__0"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false"><use href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#asterisk"></use></svg></span>
											</label> 
											<select class="form-control custom-select" id="assignRotationType\${payload.result[i].traineeLevelMasterId}">
												<option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-type" /></option>
												<c:forEach items="${rotationTypeMasterList}" var="rotationType">
													<option value="${rotationType.rotationTypeMasterId}">${rotationType.getRotationTypeName(locale)}</option>
												</c:forEach>
											</select>
											<div class="form-feedback-item text-danger d-none" id="rotationType\${payload.result[i].traineeLevelMasterId}Error"></div>
										</div>
									</div>
								</div>`;
			}
			$("#traineeLevelBlocksDiv").html(traineeLevelBlocks);
			$("#saveAssingedRotationAndBlocksToProgramCohort").data("traineeLevelIds", traineeLevelIds);
			$("#saveAssingedRotationAndBlocksToProgramCohort").data("rotationId", $('#all-rotations').val());
		}
	});
}

function getRoationsAndBlocksByProgramDuration() {
	let isEditRotation = '${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_EDIT_ASSIGN_ROTATION)}';
	let isDeleteRotation = '${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_ASSIGN_ROTATION)}';
	let displayColumn;
	let displayColumnVisibility;
	if(JSON.parse(isEditRotation) || JSON.parse(isDeleteRotation)) {
		displayColumn = ":visible:not(':last')";
		displayColumnVisibility = ":not(':last')";
	} else {
		displayColumn = ":visible";
	}
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${getRotationsAndBlocksByProgramDuration}',
		type : 'POST',
		data : {
			<portlet:namespace/>programDurationId : $('#cohort').val()
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			if(payload.success){
				destroyProgramRotationTable();
				var dataResult = payload.result;
				var addRotationUrl = payload.addRotation;
				$("#add-rotation").attr("href", addRotationUrl);
				
				// Prepare Dynamic Columns
				var columns = createProgramRotationTableColumns(dataResult);
				
				// Prepare Data
				var showResults = prepareDataForProgramRotationTables(dataResult);
				
				try {
					destroyProgramRotationTable();
					if(showResults.length > 0) {
						$("#program-rotations-table-no-data-found").addClass("d-none");
						$('#program-rotations-table').DataTable({
						    "data": showResults,
						    "columns": columns,
						    dom: 'Bfrtip',
						    buttons: [
					    		{
					              extend: 'colvis',
					              text: '<liferay-ui:message key="column-visibility" />',
					              columns: displayColumnVisibility
					            },
					    	    {
					    	        extend: 'collection',
					    	        text: '<liferay-ui:message key="export-as" />',
					    	        buttons: [
					    	            {
					    	                extend: 'csv',
					    	                exportOptions: {
					    	                    columns: displayColumn
					    	                }
					    	            },
					    	            {
					    	                extend: 'pdf',
					    	                exportOptions: {
					    	                    columns: displayColumn
					    	                }
					    	            },
					    	            {
					    	                extend: 'excel',
					    	                exportOptions: {
					    	                    columns: displayColumn
					    	                }
					    	            },
					    	            {
					    	                extend: 'print',
					    	                exportOptions: {
					    	                    columns: displayColumn
					    	                }
					    	            }
					    	        ]
					    	    }
					    	]
						});	
					} else {
						$("#program-rotations-table-no-data-found").removeClass("d-none");
						
					}
				}
			    catch (exc) {
			      console.log(exc);
			    }
			} else {
				/* Show Error Popup */
				destroyProgramRotationTable();
			}
		}
	});
}

function getAllRotationsForAssignRotations(){
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${getAllRotations}',
		type : 'POST',
		data : {
			<portlet:namespace/>programDurationId : $('#cohort').val()
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			if(payload.success){
				$("#all-rotations").empty().append(`<option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></option>`);
				for(let i = 0; i < payload.result.length; i++) {
					$("#all-rotations").append(`<option value="\${payload.result[i].rotationMasterId}"> \${payload.result[i].rotationName} </option>`);
				}
			} 
		}
	});
}


function getAllPrograms(){
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${getAllPrograms}',
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : $('#cohort').val()			
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			if(payload.success){
				$("#sharedProgramMasterId").empty().append(`<option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program" /></option>`);
				for(let i = 0; i < payload.result.length; i++) {
					$("#sharedProgramMasterId").append(`<option value="\${payload.result[i].programMasterId}"> \${payload.result[i].programName} </option>`);
				}
			} 
		}
	});
}

function getProgramDurations(programMasterId){
	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	$.ajax({
		url : '${getAllProgramDurations}',
		type : 'POST',
		data : {
			<portlet:namespace/>programMasterId : programMasterId,			
		},
		success : function(payload) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			if(payload.success){
				$("#sharedProgramDurationId").empty().append(`<option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-duration" /></option>`);
				for(let i = 0; i < payload.result.length; i++) {
					$("#sharedProgramDurationId").append(`<option value="\${payload.result[i].programCohortId}"> \${payload.result[i].programDurationName} </option>`);
				}
			} 
		}
	});
}


function assignedRotationAndTraineeBlocksToProgramCohort(e, type){
	var isSuccess = true;

	var programCohort = $('#cohort').val();
	var traineeLevelIds = $('#'+ e.id).data("traineeLevelIds");
	var rotationId = $("#" + e.id).data("rotationId");
	
	var isSharedRotation = $('#isSharedRotation').val();
	var sharedProgramMasterId =  $('#sharedProgramMasterId').val();
	var sharedProgramDurationId =  $('#sharedProgramDurationId').val();
	
	if(rotationId == null) {
		rotationId = $("#all-rotations").val();
	}
	
	if(type == 'Add') {
		rotationId = $("#all-rotations").val();
	}
	
	var assignedRotation = {};
	assignedRotation["rotationMasterId"] = rotationId;
	assignedRotation["isSharedRotation"] = isSharedRotation;
	assignedRotation["sharedProgramMasterId"] = sharedProgramMasterId;
	assignedRotation["sharedProgramDurationId"] = sharedProgramDurationId;
	var traineeLevelAndBlocks = [];
	
	/* Validations  */
	if(type == 'Add') {
		if(isSharedRotation == 'true') {
			/* Validate Shared Program  */
			if(sharedProgramMasterId == null  || sharedProgramMasterId == 0) {
				$("#sharedProgramMasterError").html(`<language-ui:message key="please-select-shared-program" />`);
				$("#sharedProgramMasterError").removeClass("d-none");
				isSuccess = false;
			} else {
				$("#sharedProgramMasterError").html(``);
				$("#sharedProgramMasterError").addClass("d-none");
			}
			
			if(sharedProgramDurationId == null  || sharedProgramDurationId == 0) {
				$("#sharedProgramDurationError").html(`<liferay-ui:message key="please-select-shared-program-duration" />`);
				$("#sharedProgramDurationError").removeClass("d-none");
				isSuccess = false;
			} else {
				$("#sharedProgramDurationError").html(``);
				$("#sharedProgramDurationError").addClass("d-none");
			}
		}
		
		/* Validate Rotation */
		if(rotationId == null || rotationId == 0) {
			$("#allRotationsError").html(`<liferay-ui:message key="rotation-field-required" />`);
			$("#allRotationsError").removeClass("d-none");
			isSuccess = false;
		} else {
			$("#allRotationsError").html(``);
			$("#allRotationsError").addClass("d-none");
		}
	}
	
	
    // Prepare the Json
     if(traineeLevelIds.length > 0) {
    	 $.each( traineeLevelIds, function( key, value ) {
    		
    		 /* Validate Number of blocks */
    		var noOfBlocks = Number($("#traineeLevelBlocks"+value).val());
    		var rotationType = Number($("#assignRotationType"+value).val());

    		if(isBlank($("#traineeLevelBlocks"+value).val())) {
    			$("#traineeLevelBlocks" + value + "Error").html(`<liferay-ui:message key="number-of-blocks-field-required"/> `);
    			$("#traineeLevelBlocks" + value + "Error").removeClass("d-none");
    			isSuccess = false;
    		} else if(noOfBlocks < 0){
    			$("#traineeLevelBlocks" + value + "Error").html(`<liferay-ui:message key ="number-should-be-greater-than-or-equal-to-zero" />`);
    			$("#traineeLevelBlocks" + value + "Error").removeClass("d-none");
    			isSuccess = false;
    		} else {
    			$("#traineeLevelBlocks" + value + "Error").html("");
    			$("#traineeLevelBlocks" + value + "Error").addClass("d-none");
    		}

    		if(!rotationType) {
    			$("#rotationType" + value + "Error").html(`<liferay-ui:message key="rotation-type-field-required"/> `);
    			$("#rotationType" + value + "Error").removeClass("d-none");
    			isSuccess = false;
    		} else {
    			$("#rotationType" + value + "Error").html("");
    			$("#rotationType" + value + "Error").addClass("d-none");
    		}

    		var json = {};
     		json["traineeLevelMasterId"] = value;
            json["rotationType"] = $("#assignRotationType"+value).val();
            json["noOfBlocks"] = $("#traineeLevelBlocks"+value).val();
            traineeLevelAndBlocks.push(json);
	   	});
    }
    assignedRotation["traineeLevelAndBlocks"] = traineeLevelAndBlocks; 
   
    if(isSuccess) {
    	$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
	   	 $.ajax({
	   			url : '${assignedRotationAndTraineeBlocksToProgramCohort}',
	   			type : 'POST',
	   			data : {
	   				<portlet:namespace/>progDurationId : $('#cohort').val(),
	   				<portlet:namespace/>assignedRotation : JSON.stringify(assignedRotation)
	   			},
	   			success : function(payload) {
	   				$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
	   				if(payload.success) {
	   					/* Success Popup */
	   					$('#'+ e.id + "Cancel").click();
	   					$("#traineeLevelBlocksDiv").html("");
	   					$("#traineeLevelBlocksDivForEdit").html("");
	   					getRoationsAndBlocksByProgramDuration();
	   					$("#successMessage").html(`<liferay-ui:message key="assigned-rotation-and-blocks-to-program-cohort-successfully" />`);
	   					$("#successModal").modal("show");
	   				} else {
	   					/* Error Popup */
	   				}
	   			}
	   		});
    }
}

function updateSlotsToRotationAndTrainingSite() {
	var isSuccess = true;
	var noOfSlots = Number($("#configure-single-rotation-slots").val());
	var progDurationRotationTsRelId = $('#configure-single-rotation-progDurationRotationTsRelId').val();
	
	if(isBlank($("#configure-single-rotation-slots").val())){
		$("#configure-single-rotation-slots-error").html(`<liferay-ui:message key="number-of-blocks-field-required"/>`);
		$("#configure-single-rotation-slots-error").removeClass("d-none");
		isSuccess = false;
	} else if(noOfSlots <= 0){
		$("#configure-single-rotation-slots-error").html(`<liferay-ui:message key="number-should-be-greater-than-zero"/>`);
		$("#configure-single-rotation-slots-error").removeClass("d-none");
		isSuccess = false;
	} else {
		$("#configure-single-rotation-slots-error").html("");
		$("#configure-single-rotation-slots-error").addClass("d-none");
	}
	if(isSuccess) {
		$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
		$.ajax({
			url : '${saveSlotsToRotationAndTrainingSite}',
			type : 'POST',
			data : {
				<portlet:namespace/>progDurationRotationTsRelId : progDurationRotationTsRelId,
				<portlet:namespace/>noOfSlots : noOfSlots
			},
			success : function(payload) {
				$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
				if(payload.success) {
					/* Success Popup */
					getAssignedRotationsToSelectedTrainingSite( $("#siteCapacityInformationInput").attr("data-trainingSiteMasterId"), $('#cohort').val(), '${getAllAssignedRotationsByTrainingSite}', $("#siteCapacityInformationInput").attr("data-trainingSiteName"));
					$("#cancelSlotsToRotationAndTrainingSite").click();
					$("#successMessage").html(`<liferay-ui:message key="slots-updated-successfully" />`);
					$("#successModal").modal("show");
				} else {
					/* Error Popup */
				}
			}
		});
	}
}

function addTrainingSite(){
	var isSuccess = true;

	var trainingSiteNameEn = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteName_en_US').val();
	var trainingSiteNameAr = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteName_ar_SA').val();
	
	var trainingSiteAddressEn = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteAddress_en_US').val();
	var trainingSiteAddressAr = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteAddress_ar_SA').val();
	
	var trainingSiteCodeEn = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteCode_en_US').val();
	var trainingSiteCodeAr = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteCode_ar_SA').val();
	
	var trainingSiteStatus = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteStatus').val();
	
	var trainingSiteDescriptionEn = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteDescription_en_US').val();
	var trainingSiteDescriptionAr = $('#_gov_omsb_programs_web_OmsbProgramsWebPortlet_trainingSiteDescription_ar_SA').val();
	
	/* Validate Traininig Site Fields  */
	
	if(isBlank(trainingSiteNameEn) && isBlank(trainingSiteNameAr)) {
		$("#training-site-name-error").html('<liferay-ui:message key="this-field-is-required" />');
		$("#training-site-name-error").removeClass("d-none");
		isSuccess = false;
	} else {
		$("#training-site-name-error").html(``);
		$("#training-site-name-error").addClass("d-none");
	}
	
	
	if(isBlank(trainingSiteAddressEn) && isBlank(trainingSiteAddressAr)) {
		$("#training-site-address-error").html('<liferay-ui:message key="this-field-is-required" />');
		$("#training-site-address-error").removeClass("d-none");
		isSuccess = false;
	} else {
		$("#training-site-address-error").html(``);
		$("#training-site-address-error").addClass("d-none");
	}
	
	if(isBlank(trainingSiteCodeEn) && isBlank(trainingSiteCodeAr)) {
		$("#training-site-code-error").html('<liferay-ui:message key="this-field-is-required" />');
		$("#training-site-code-error").removeClass("d-none");
		isSuccess = false;
	} else {
		$("#training-site-code-error").html(``);
		$("#training-site-code-error").addClass("d-none");
	}
	
	if(isBlank(trainingSiteDescriptionEn) && isBlank(trainingSiteDescriptionAr)) {
		$("#training-site-description-error").html('<liferay-ui:message key="this-field-is-required" />');
		$("#training-site-description-error").removeClass("d-none");
		isSuccess = false;
	} else {
		$("#training-site-description-error").html(``);
		$("#training-site-description-error").addClass("d-none");
	}
	
	if(isBlank(trainingSiteStatus)) {
		$("#training-site-status-error").html('<liferay-ui:message key="this-field-is-required" />');
		$("#training-site-status-error").removeClass("d-none");
		isSuccess = false;
	} else {
		$("#training-site-status-error").html(``);
		$("#training-site-status-error").addClass("d-none");
	}
	
	if(isSuccess) {
		$('#pageLoaderContainerId').addClass('d-flex').removeClass('d-none');
		$.ajax({
			url : '${saveTrainingSite}',
			type : 'POST',
			data : {
				<portlet:namespace/>trainingSiteNameEn : trainingSiteNameEn,
				<portlet:namespace/>trainingSiteNameAr : trainingSiteNameAr,
				<portlet:namespace/>trainingSiteAddressEn : trainingSiteAddressEn,
				<portlet:namespace/>trainingSiteAddressAr : trainingSiteAddressAr,
				<portlet:namespace/>trainingSiteCodeEn : trainingSiteCodeEn,
				<portlet:namespace/>trainingSiteCodeAr : trainingSiteCodeAr,
				<portlet:namespace/>trainingSiteDescriptionEn : trainingSiteDescriptionEn,
				<portlet:namespace/>trainingSiteDescriptionAr : trainingSiteDescriptionAr,
				<portlet:namespace/>trainingSiteStatus : trainingSiteStatus
			},
			success : function(payload) {
				if(payload.success) {
					$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
					hideTrainingSiteForm();
					let resourceUrl = "${getAllTrainingSites}";
					getAllTrainingSites($('#cohort').val(), resourceUrl);
					/* $("#cancel-manage-training-sites").click();
					$("#manage-training-sites-btn").click(); */
				/* 	$("#successMessage").html(`<liferay-ui:message key="training-site-added-successfully" />`);
					$("#successModal").modal("show"); */
				} else {
					/* Error Popup */
				}
			}
		});
	}
}

function getProgramObjectiveAndSpecificObjectives(){
	$('.objective-content').remove();
	$.ajax({
		url : '${getObjectiveDetails}',
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : $('#cohort').val()
		},
		success : function(data) {
			let jsondata = JSON.parse(data);
			var jsonResult = jsondata.objectiveDetailsArray;
			if(jsonResult[0].progdurationObjectivesRels.length != 0 ){
				$.each(jsonResult[0].progdurationObjectivesRels, function(index, objective) {
					$('.objective-data').append(`
						<div class="col-lg-12 col-md-12 col-sm-12 objective-content">
								<div class="form-group-view white-bg">
								<img src="${themeDisplay.getPathThemeImages()}/svg/program-objective.svg" alt="">
								<div class="label-name pt-3"><liferay-ui:message key="program-objectives" /></div>
								<div class="label-content">\${objective}</div>
							</div>
						</div>
					`);
				});
			} else {
				$('.objective-data').append(`
					<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
						<div class="omsb-no-data-found"><liferay-ui:message key="project-objective-not-defined" /></div>
					</div>
				`);
			}
			if(jsonResult[0].competenciesRequirementsRels.length != 0 ) {
				$.each(jsonResult[0].competenciesRequirementsRels, function(key, value) {
					$.each(value, function(index, element) {
						$('#competency-data-'+key).append(`
							<div class="col-lg-4 col-md-4 col-sm-6 objective-content">
								<div class="form-group-view white-bg">
									<img src="${themeDisplay.getPathThemeImages()}/svg/program-objective.svg" alt="">
									<div class="label-name pt-3"><liferay-ui:message key="requirements" /></div>
									<div class="label-content">\${element}</div>
								</div>
							</div>
						`);
					});
				});
			}
			$('.competency-data').each(function() {
				if(! $(this).text().trim()) {
					$(this).append(`
						<div class="omsb-card omsb-BorderRadius-4 text-center objective-content">
							<div class="omsb-no-data-found"><liferay-ui:message key="requirments-not-defined" /></div>
						</div>
					`);
				}
			});
		}
	});
}

function getObjectiveDetails(programCohortId, resourceCommandUrl){
	 $.ajax({
		url : resourceCommandUrl,
		type : 'POST',
		data : {
			<portlet:namespace/>programCohortId : programCohortId
		},
		success : function(data) {
			$('#pageLoaderContainerId').removeClass('d-flex').addClass('d-none');
			var USLocale = $("#USLocale").val();
			var ARLocale = $("#ARLocale").val();
			console.log('USLocale',USLocale);
			let jsondata = JSON.parse(data);
			console.log('jsondata',jsondata);
			let ProgdurationObjectivesRel = [];
			let CompetenciesMaster = [];
			let ProgdurationCompetenciesRequirementsRel = [];
			$('#programObjectives div').remove();
			$('#programObjectives input').remove();
			$('#specificobjectivesData div').remove();
			$('#specificobjectivesData input').remove();
			
			var jsonResult = jsondata.objectiveDetailsArray;
			if(jsonResult[0].isTrainee == false && jsonResult[0].isFaculty == false){
				$('.pill-tab-nav .nav-item .active').removeClass('active') 
			}
			console.log('jsonResult',jsonResult);
			if(jsonResult.length > 0){
				ProgdurationObjectivesRel= jsonResult[0].ProgdurationObjectivesRel;
				CompetenciesMaster = jsonResult[0].CompetenciesMaster;
				ProgdurationCompetenciesRequirementsRel = jsonResult[0].ProgdurationCompetenciesRequirementsRel;
				console.log('CompetenciesMaster',ProgdurationObjectivesRel);
			}
			if(CompetenciesMaster.length > 0){
				var competenciesMasterString = '<input type="hidden" id="<portlet:namespace/>specific-objectives-count" name="<portlet:namespace/>specificObjectivesCount" value="' + CompetenciesMaster.length + '" />'+
											   '<input type="hidden" id="<portlet:namespace/>deletedSpecificObjective" name="<portlet:namespace/>deletedSpecificObjective" value="" />'+
											   '<div class="tab-content" id="pills-tabContent">';
				for(let i=0; i<CompetenciesMaster.length; i++){
					if(ProgdurationCompetenciesRequirementsRel.length > 0){
						competenciesMasterString +='<div class="tab-pane fade" id="pills-' + CompetenciesMaster[i].competenciesMasterId + '" role="tabpanel" aria-labelledby="pills-' + CompetenciesMaster[i].competenciesMasterId + '-tab">'+
													'<input type="hidden" id="<portlet:namespace/>competencyMasterId-'+(i+1)+'" name="<portlet:namespace/>competencyMasterId-'+(i+1)+'" value="' + CompetenciesMaster[i].competenciesMasterId + '" />';
						var isValueAvailable = false;
						var totalcount = 1;
						for(let j=0; j<ProgdurationCompetenciesRequirementsRel.length; j++){
							var saReqValue = '';
							if(ProgdurationCompetenciesRequirementsRel[j].requirementsMap.ar_SA != undefined){
								saReqValue = ProgdurationCompetenciesRequirementsRel[j].requirementsMap.ar_SA;
							}
							if(ProgdurationCompetenciesRequirementsRel[j].competenciesMasterId == CompetenciesMaster[i].competenciesMasterId){
								isValueAvailable = true;
								competenciesMasterString +='<input type="hidden" name="<portlet:namespace/>objectivesMasterId-'+(i+1)+'-' +totalcount+ '" value="'+ProgdurationCompetenciesRequirementsRel[j].progdurationCompetenciesRelId+'" />'+
															'<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-'+(i+1)+'-'+totalcount+'">'+
															'<div class="row">'+
															'<div class="col-lg-12 col-md-12 col-sm-12">'+
															'<div class="form-group">'+
															'<label for="<portlet:namespace/>requirements-'+(i+1)+'-'+totalcount+'"><liferay-ui:message key="requirements" /></label>'+
															'<div class="countryFlagWrap">'+
															'<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-'+(i+1)+'-'+totalcount+'" name="<portlet:namespace/>requirementsUS-'+(i+1)+'-'+totalcount+'" value="'+ProgdurationCompetenciesRequirementsRel[j].requirementsMap.en_US+'" data-name="requirements" data-index="'+totalcount+'"></input>'+
														    '<input type="hidden" id="<portlet:namespace/>requirementsSA-'+(i+1)+'-'+totalcount+'" name="<portlet:namespace/>requirementsSA-'+(i+1)+'-'+totalcount+'" value="'+saReqValue+'"></input>'+
															'<textarea id="<portlet:namespace/>requirements-'+(i+1)+'-'+totalcount+'" name="<portlet:namespace/>requirements-'+(i+1)+'-'+totalcount+'" class="form-control"></textarea>'+
															'<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
															'data-selected-country="US" data-button-size="btn-lg"'+
															'data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="'+(i+1)+'" data-index="'+totalcount+'">'+
															'</div>'+
															'</div>'+
															'</div>'+
															'</div>'+
															'</div>';
									if(totalcount==1){
										competenciesMasterString +='<div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">'+
																	'<button class="btn omsb-bc-red-button m-0"  id="add-new-specific-objectives-btn" onclick="addSpecificObjectives('+(i+1)+')" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>'+
																	'</div>';
									}else{
										competenciesMasterString +='<div class="omsb-card-title">'+
																	'<span></span>'+
																	'<button class="btn omsb-bg-red-button" data-id="'+ProgdurationCompetenciesRequirementsRel[j].progdurationCompetenciesRelId+'" id="remove-specific-objectives-btn" data-index="'+(i+1)+'" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeSpecificObjectives(this)">'+
														   			'<liferay-ui:message key="discard" />'+
														   			'</button></div>';
									}
									competenciesMasterString += '</div>';
									totalcount++;
							}
						}
						if(!isValueAvailable){
							competenciesMasterString += '<input type="hidden" id="<portlet:namespace/>specific-objectives-count-'+(i+1)+'" name="<portlet:namespace/>specificObjectivesCount-'+(i+1)+'" value="' + totalcount + '" />'+
														'<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-'+(i+1)+'-1">'+
														'<div class="row">'+
														'<div class="col-lg-12 col-md-12 col-sm-12">'+
														'<div class="form-group">'+
														'<label for="<portlet:namespace/>requirements-'+(i+1)+'-1"><liferay-ui:message key="requirements" /></label>'+
														'<div class="countryFlagWrap">'+
														'<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-'+(i+1)+'-1" name="<portlet:namespace/>requirementsUS-'+(i+1)+'-1" value="" data-name="requirements" data-index="1"></input>'+
													    '<input type="hidden" id="<portlet:namespace/>requirementsSA-'+(i+1)+'-1" name="<portlet:namespace/>requirementsSA-'+(i+1)+'-1" value=""></input>'+
														'<textarea id="<portlet:namespace/>requirements-'+(i+1)+'-1" name="<portlet:namespace/>requirements-'+(i+1)+'-1" class="form-control"></textarea>'+
														'<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
														'data-selected-country="US" data-button-size="btn-lg"'+
														'data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="'+(i+1)+'" data-index="1">'+
														'</div>'+
														'</div>'+
														'</div>'+
														'</div>'+
														'</div>'+
														'<div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">'+
														'<button class="btn omsb-bc-red-button m-0"  id="add-new-specific-objectives-btn" onclick="addSpecificObjectives('+(i+1)+')" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>'+
														'</div>'+
														'</div>';
						}else{
							competenciesMasterString += '<input type="hidden" id="<portlet:namespace/>specific-objectives-count-'+(i+1)+'" name="<portlet:namespace/>specificObjectivesCount-'+(i+1)+'" value="' + (totalcount-1) + '" />';
						}
					}else{
						competenciesMasterString += '<div class="tab-pane fade" id="pills-' + CompetenciesMaster[i].competenciesMasterId + '" role="tabpanel" aria-labelledby="pills-' + CompetenciesMaster[i].competenciesMasterId + '-tab">'+
													'<input type="hidden" id="<portlet:namespace/>specific-objectives-count-'+(i+1)+'" name="<portlet:namespace/>specificObjectivesCount-'+(i+1)+'" value="1" />'+
													'<input type="hidden" id="<portlet:namespace/>competencyMasterId-'+(i+1)+'" name="<portlet:namespace/>competencyMasterId-'+(i+1)+'" value="' + CompetenciesMaster[i].competenciesMasterId + '" />'+
													'<div class="omsb-card-graybg omsb-BorderRadius-4 omsb-card main-card-tms mb-4" id="mainspecificobjective-'+(i+1)+'-1">'+
													'<div class="row">'+
													'<div class="col-lg-12 col-md-12 col-sm-12">'+
													'<div class="form-group">'+
													'<label for="<portlet:namespace/>requirements-'+(i+1)+'-1"><liferay-ui:message key="requirements" /></label>'+
													'<div class="countryFlagWrap">'+
													'<input class="required-optional" type="hidden" id="<portlet:namespace/>requirementsUS-'+(i+1)+'-1" name="<portlet:namespace/>requirementsUS-'+(i+1)+'-1" value="" data-name="requirements" data-index="1"></input>'+
													'<input type="hidden" id="<portlet:namespace/>requirementsSA-'+(i+1)+'-1" name="<portlet:namespace/>requirementsSA-'+(i+1)+'-1" value=""></input>'+
													'<textarea id="<portlet:namespace/>requirements-'+(i+1)+'-1" name="<portlet:namespace/>requirements-'+(i+1)+'-1" class="form-control"></textarea>'+
													'<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
													'data-selected-country="US" data-button-size="btn-lg"'+
													'data-scrollable="true" data-scrollable-height="250px" data-name="requirements" data-tab="'+(i+1)+'" data-index="1">'+
													'</div>'+
													'</div>'+
													'</div>'+
													'</div>'+
													'</div>'+
													'<div class="bottom-backbtn-wrap mt-0 add-button-requirements-1">'+
													'<button class="btn omsb-bc-red-button m-0"  id="add-new-specific-objectives-btn" onclick="addSpecificObjectives('+(i+1)+')" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>'+
													'</div>'+
													'</div>';
					}
					competenciesMasterString += '</div>';
				}
				$("#specificobjectivesData").append(competenciesMasterString);
				$("#pills-"+CompetenciesMaster[0].competenciesMasterId).addClass("show active");
				$("#pills-"+CompetenciesMaster[0].competenciesMasterId+"-tab").addClass("active");

			}
			console.log('ProgdurationObjectivesRel.length ::::',ProgdurationObjectivesRel.length);
			if(ProgdurationObjectivesRel.length > 0){
				var newInputString = '		<input type="hidden" id="<portlet:namespace/>program-objectives-count" name="<portlet:namespace/>programObjectivesCount" value="' + ProgdurationObjectivesRel.length + '" />'+
									 '  	<input type="hidden" id="<portlet:namespace/>deletedObjective" name="<portlet:namespace/>deletedObjective" value="" />';
			for(let i=0; i<ProgdurationObjectivesRel.length; i++){
				var saValue = '';
				if(ProgdurationObjectivesRel[i].objectivesMap.ar_SA != undefined){
					saValue = ProgdurationObjectivesRel[i].objectivesMap.ar_SA;
				}
											newInputString += '<input type="hidden" name="<portlet:namespace/>programObjectivesMasterId-'+(i+1)+'" value="' + ProgdurationObjectivesRel[i].PDObjectivesId + '" />'+
															  '<div class="omsb-card omsb-BorderRadius-4 omsb-card-graybg" id="mainobjective-'+(i+1)+'">'+
															  '	<div class="form-group">'+
															  '		<label for="<portlet:namespace/>programObjectives-'+(i+1)+'"><liferay-ui:message key="program-objectives" /></label>'+
															  '		<div class="countryFlagWrap">'+
															  '			<input class="required-optional" type="hidden" id="<portlet:namespace/>programObjectivesUS-'+(i+1)+'" name="<portlet:namespace/>programObjectivesUS-'+(i+1)+'" value="'+ProgdurationObjectivesRel[i].objectivesMap.en_US+'" data-name="programObjectives" data-index="'+(i+1)+'"></input>'+
							    							  '			<input type="hidden" id="<portlet:namespace/>programObjectivesSA-'+(i+1)+'" name="<portlet:namespace/>programObjectivesSA-'+(i+1)+'" value="'+saValue+'"></input>'+
															  '			<textarea id="<portlet:namespace/>programObjectives-'+(i+1)+'" name="<portlet:namespace/>programObjectives-'+(i+1)+'" class="form-control"></textarea>'+
															  '			<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
															  '			data-selected-country="US" data-button-size="btn-lg"'+
															  '			data-scrollable="true" data-scrollable-height="250px" data-name="programObjectives" data-index="'+(i+1)+'">'+
															  '			</div></div>'+
															  '	</div>';
															  console.log('i before',i);
							if(i==0){
								newInputString += '<div class="row add-button-objectives-'+ (ProgdurationObjectivesRel.length + 1) +'">'+
								  '			<div class="col-md-12">'+
								  '				<div class="bottom-backbtn-wrap">'+
								  '					<button class="btn omsb-bc-red-button m-0"  id="add-new-program-objectives-btn" onclick="addNewObjectives()" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>'+
								  '				</div>'+
								  '			</div>'+
								  '		</div>';
							}else{
								 console.log('i after',i);
								newInputString += '<div class="omsb-card-title">'+
								  '			<span></span>'+
								  '			<button class="btn omsb-bg-red-button" data-id="' + ProgdurationObjectivesRel[i].PDObjectivesId + 
								  '			" id="remove-program-objectives-btn" data-index="'+(i+1)+
								  '			" data-toggle="modal" data-target="#addsupportingdocument" type="button" onclick="removeProgramObjectives(this)"><liferay-ui:message key="discard" /> </button></div>';
							}
							newInputString += '</div>';
						}
				newInputString += '</div>';
				
				$("#programObjectives").append(newInputString);
			}else{
				var inputString =  '		<input type="hidden" id="<portlet:namespace/>program-objectives-count" name="<portlet:namespace/>programObjectivesCount" value="1" />'+
								  '		<div class="omsb-card omsb-BorderRadius-4 omsb-card-graybg" id="mainobjective-1">'+
								  '			<div class="form-group">'+
								  '				<label for="<portlet:namespace/>programObjectives-1"><liferay-ui:message key="program-objectives" /></label>'+
								  '				<div class="countryFlagWrap">'+
								  '					<input class="required-optional" type="hidden" id="<portlet:namespace/>programObjectivesUS-1" name="<portlet:namespace/>programObjectivesUS-1" value="" data-name="programObjectives" data-index="1"></input>'+
						    	  '					<input type="hidden" id="<portlet:namespace/>programObjectivesSA-1" name="<portlet:namespace/>programObjectivesSA-1" value=""></input>'+
								  '					<textarea id="<portlet:namespace/>programObjectives-1" name="<portlet:namespace/>programObjectives-1" class="form-control"></textarea>'+
								  '					<div id="languageTagDiagnosis" class="cstFlag" data-input-name="country"'+
								  '					data-selected-country="US" data-button-size="btn-lg"'+
								  '					data-scrollable="true" data-scrollable-height="250px" data-name="programObjectives" data-index="1">'+
								  '					</div>'+
								  '				</div>'+
								  '			</div>'+
								  '			<div class="row add-button-objectives-1">'+
								  '				<div class="col-md-12">'+
								  '					<div class="bottom-backbtn-wrap">'+
								  '						<button class="btn omsb-bc-red-button m-0"  id="add-new-program-objectives-btn" onclick="addNewObjectives()" data-toggle="modal" data-target="#addsupportingdocument" type="button"><liferay-ui:message key="add" /></button>'+
								  '					</div>'+
								  '				</div>'+
								  '			</div>'+
								  '		</div>';
									
								  
				$("#programObjectives").append(inputString);
			}
			
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
		}
	});
}
</script>