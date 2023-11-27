<%@page import="gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys"%>
<%@ include file="init.jsp"%>

<portlet:resourceURL id="<%=OmsbViewProgramCohortWebPortletKeys.PROGRAM_COHORT_LIST_MVC_RESOURCE_COMMAND %>" var="programCohortList" />
<portlet:resourceURL id="<%=OmsbViewProgramCohortWebPortletKeys.GET_DISTINCT_COHORT_MVC_RESOURCE_COMMAND %>" var="getDistinctCohort" />
<portlet:resourceURL id="<%=OmsbViewProgramCohortWebPortletKeys.PROGRAM_AND_COHORT_LIST_MVC_RESOURCE_COMMAND %>" var="programAndCohortList" />
<portlet:resourceURL id="<%=OmsbViewProgramCohortWebPortletKeys.PROGRAM_COHORT_TRAINEE_LEVEL_LIST_MVC_RESOURCE_COMMAND %>" var="programCohortTraineeLevelList" />

<%-- <div class="loader-container loaded">
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
     <p><liferay-ui:message key="please-wait" /></p>
 </div> --%>
 
<div class="loader-container loaded d-none" id="block-creation-loader" >
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
     <p><liferay-ui:message key="clonning cohort" /></p>
 </div>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle">
					<liferay-ui:message key="view-program-cohort" />
				</div>
			</div>
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12">
						<aui:select id="programId" name="programId" label="select-a-program"
							localized="true" cssClass="custom-select form-control" value="${programMasterId}">
							<aui:option value="0" selected="true" cssClass="placeholder">
								<liferay-ui:message key="please-select-program" />
							</aui:option>
							<c:forEach items="${programMasterList}" var="program">
								<aui:option value="${program.programMasterId}">${program.getProgramName(locale)}</aui:option>
							</c:forEach>
							<aui:validator name="required" />
						</aui:select>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="year-from" /></label>
							<input type="number" id="yearFrom" name="yearFrom" class="form-control datePicker" required>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="year-to" /></label>
							<input type="number" id="yearTo" name="yearTo" class="form-control datePicker" required>
						</div>
					</div>
				</div>
				<div class="row"> 
					<div class="filter-button-wrap flex">
						<button class="btn omsb-bc-red-button" id="searchbtn" ><liferay-ui:message key="search" /></button>
					</div>
				</div>
			</div>
		
			
			<div class="omsb-list-view">
				<table id="programCohortTable" class="display omsb-datatables">
					<caption></caption>
					<thead>
						<tr>
							<th><liferay-ui:message key="cohort" /></th>
							<th><liferay-ui:message key="total-number-of-blocks" /></th>
							<th><liferay-ui:message key="application-from" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			
			<div class="omsb-list-view" style="display: none" id="programCohortTraineeLevelContainer">
				<table id="programCohortTraineeLevelTable" class="display omsb-datatables">
					<caption></caption>
					<thead>
						<tr>
							<th><liferay-ui:message key="cohort" /></th>
							<th><liferay-ui:message key="trainee-level" /></th>
							<th><liferay-ui:message key="no-of-blocks" /></th>
							<th><liferay-ui:message key="level-type" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<div class="bottom-backbtn-wrap">	
				<a class="btn omsb-btn btn-back" href="javascript.void(0)" onclick="history.back()" title="Back"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>	
			</div>
		</div>
	</div>
	<jsp:include page="/modal-popup.jsp" />
</div>

<script>
$(document).ready(function(){
	$('#yearFrom').datepicker({
		format: 'yyyy',
		changeYear: true,
		viewMode: "years",
	    minViewMode: "years",
		autoclose: true
	});
	
	$('#yearTo').datepicker({
		format: 'yyyy',
		changeYear: true,
		viewMode: "years",
	    minViewMode: "years",
		autoclose: true
	});
	$('#programCohortTable').DataTable().destroy();
	$('#programCohortTable').DataTable({
	    "sDom": 'Rfrtlip',
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
    	],
	    "searching" : false,
	    "info" : false,
	    "paging" : false

	 });
	$('#programCohortTraineeLevelTable').DataTable().destroy();
	$('#programCohortTraineeLevelTable').DataTable({
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
    	],
	    "searching" : false,
	    "info" : false,
	    "paging" : false

	 });
	
	$("#searchbtn").click();
	
});

$(document).on("click","#searchbtn", function(){
	$('html, body').scrollTop($("#programCohortTable").offset().top);
	$('#programCohortTraineeLevelContainer').css('display', 'none');
	$('#programCohortTraineeLevelTable').DataTable().rows().remove().draw();
	$.ajax({
		url : "${programCohortList}",
		type : 'POST',
		data : {
			<portlet:namespace/>programId : $('#<portlet:namespace/>programId').val(),
			<portlet:namespace/>yearTo :  $('#yearTo').val(),
			<portlet:namespace/>yearFrom :  $('#yearFrom').val()
		},
		success : function(payload) {
			$('#programCohortTable').DataTable().destroy();
			$('#programCohortTable').DataTable({
				"data": payload,
				"sDom": 'Rfrtlip',
				"paging" : false,
				"info" : false,
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
		    	],
			    columns: [
			        { data: 'programName' },
			        { data: 'noOfBlocks' },
			        { data: 'ayApplicableForm' },
			        { data: 'programDurationId',
			        	render: function(data, type, row) {
			        		var adminViewCohort = ${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_VIEW_COHORT_TRAINEE_LEVEL)};
			        		var adminCloneProgram = ${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_CLONE_PROGRAM)};

			        		var actionsHtml = ``;
			        		if(adminViewCohort || adminCloneProgram){
			        		actionsHtml =  	`<div class="dropdown ">
														<button class="btn fa fa-ellipsis-v dropdown-toggle"
														type="button" data-toggle="dropdown" aria-expanded="false">
														<i class=""></i>
													</button>
													<ul class="dropdown-menu">`;
										var menuOption = ``;
										if(adminViewCohort){
											 menuOption +=  `<li><a href="#" class="dropdown-item btn view_btn" onclick="showCohorsTraineeLevel('\${data}')"> <img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg" alt="view"> <liferay-ui:message key="view" /> </a></li>`;
										}if(adminCloneProgram){
											 menuOption += `<li><a href="#" class="dropdown-item" data-target="#cloneProgramCohort" data-toggle="modal" onclick="getCohortDetailsForClone()"> <img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg" alt="clone"> <liferay-ui:message key="clone-program-cohort" /> </a></li>`;
										}
										actionsHtml = actionsHtml + menuOption + `</ul> </div>` ;
			        		}
			            return actionsHtml;
			        } }
			    ]
			});
		},
		 error: function(xhr){
	        console.log('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
	    }
	});
});


function showCohorsTraineeLevel(data){
	$('html, body').scrollTop($("#programCohortTraineeLevelTable").offset().top);
	  $('#programCohortTraineeLevelContainer').css('display', 'block');
	  
	$.ajax({
		url : "${programCohortTraineeLevelList}",
		type : 'POST',
		data : {
			<portlet:namespace/>programDurationId : data
		},
		success : function(payload) {
			$('#programCohortTraineeLevelTable').DataTable().destroy();
			$('#programCohortTraineeLevelTable').DataTable({
				"data": payload,
				"searching" : false,
				"paging" : false,
				"info" : false,
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
		    	],
			    columns: [
			        { data: 'programName' },
			        { data: 'traineeLevelName' },
			        { data: 'noOfBlocks' },
			        { data: 'levelTypeName' },
			        { data: 'actions',
			        	render: function(data, type, row) {
			        		var adminScheduleMasterRotation = ${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_SCHEDULE_MASTER_ROTATION)};
			        		var obj = jQuery.parseJSON(data);
			        		var actionsHtml = ``;
						if(adminScheduleMasterRotation){	    
							if(obj.isCurrentYearTraineeLevel) {
								actionsHtml =  	`<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle"
												type="button" data-toggle="dropdown" aria-expanded="false">
												<i class=""></i>
											</button>
											<ul class="dropdown-menu">
												<li>`;
								var menuOption =  `<a href="`+ obj.scheduleMasterRotationRenderUrl  + `" class="dropdown-item"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg" alt="edit"> <liferay-ui:message key="schedule-master-rotations" /> </a> 
												</li> </ul> </div>`;
												
								if(obj.isAllTraineeTakenLeaveForCurrentYear == false) {
									menuOption =  `<a href="#" class="dropdown-item" data-target="#allTraineeTakenLeaveForCurrentYearInformationModel" data-toggle="modal"> <img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg" alt="edit"> <liferay-ui:message key="schedule-master-rotations" /> </a> 
									</li> </ul> </div>`;
								}
								actionsHtml = actionsHtml + menuOption;
							}
						}
			            return actionsHtml;
			        } }
			    ]
			});
		},
		 error: function(xhr){
	        console.log('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
	    }
	});
}

function setOldProgramDurationId(oldProgramDurationId){
	$("#<portlet:namespace/>oldProgramDurationId").val(oldProgramDurationId);
}


function getCohortDetailsForClone(){
	$.ajax({
		url : '${programAndCohortList}',
		type : 'POST',
		success : function(payload) {
			if(payload.success){
				$("#<portlet:namespace/>clone-program-id").empty();
				$("#<portlet:namespace/>clone-cohort").empty();
				$("#<portlet:namespace/>clone-program-id").append(`<option value="0" selected="true" disabled= "true"><liferay-ui:message key="please-select-program"  /> </option>`);
				for (var i = 0; i < payload.result.length; i++) {
					$("#<portlet:namespace/>clone-program-id").append(`<option value="\${payload.result[i].programMasterId}"> \${payload.result[i].ProgramName} </option>`);
                }
				for (var j = 0; j < payload.yearRange.length; j++) {
					$("#<portlet:namespace/>clone-cohort").append(`<option value="\${payload.yearRange[j].year}"> \${payload.yearRange[j].year}</option>`);
	            }
				 
					
				
			} 
		}
	});
}

function getDistinctCohort(){
	var programId = $("#<portlet:namespace/>clone-program-id option:selected").val();
	console.log("programId ",programId);
	$.ajax({
		url : '${getDistinctCohort}',
		type : 'POST',
		data : {
			<portlet:namespace/>programMasterId : programId		
		},
		success : function(payload) {
			$("#<portlet:namespace/>clone-cohort").empty();
			console.log("payload.success",payload);
			if(payload.success){
				console.log("getDistinctCohort >>> success!!")
				for (var i = 0; i < payload.result.length; i++) {
					$("#<portlet:namespace/>clone-cohort").append(`<option value="\${payload.result[i].year}"> \${payload.result[i].year}</option>`);
	            } 
			} 
			else{
				console.log("getDistinctCohort >>> failed!!")
			}
		}
	});
}

</script>