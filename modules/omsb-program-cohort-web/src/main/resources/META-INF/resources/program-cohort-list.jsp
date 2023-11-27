<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@page import="gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys"%>
<%@ include file="init.jsp" %>

<portlet:resourceURL id="<%=OmsbProgramCohortWebPortletKeys.PROGRAM_COHORT_LIST_MVC_RESOURCE_COMMAND %>" var="programCohortList" />
<div class="omsb-list-filter">
	<div class="row">
		<div class="col-md-5 col-sm-5 col-xs-12">
			<div class="form-group">
				<label><liferay-ui:message key="year-from" /></label>
				<input type="number" id="yearFrom" name="yearFrom" class="form-control datePicker" required>
			</div>
		</div>
		<div class="col-md-5 col-sm-5 col-xs-12">
			<div class="form-group">
				<label><liferay-ui:message key="year-to" /></label>
				<input type="number" id="yearTo" name="yearTo" class="form-control datePicker" required>
			</div>
		</div>
		<div class="filter-button-wrap">
			<button class="btn omsb-bc-red-button" onClick="getProgramCohortsList()"  title="Search"><liferay-ui:message key="search" /></button>
		</div>
	</div>
</div>

<div class="omsb-list-view">
	<table id="programCohortTable" class="display omsb-datatables">
		<caption></caption>
		<thead>
			<tr>
				<th><liferay-ui:message key="program" /></th>
				<th><liferay-ui:message key="cohort" /></th>
				<th><liferay-ui:message key="trainee-level" /></th>
				<th><liferay-ui:message key="blocks" /></th>
				<th><liferay-ui:message key="level" /></th>
				<th><liferay-ui:message key="last-modified-date" /></th>
				<th><liferay-ui:message key="action" /></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="bottom-backbtn-wrap">	
		<a class="btn omsb-btn btn-back" href="${redirectCommand}" title="Back"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>	
	</div>
</div>
<jsp:include page="/modal-popup.jsp" />
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
	$(".modal-backdrop").remove();
	getProgramCohortsList();
});
$(document).on("click",".openDeleteModal", function(){
	$('#<portlet:namespace/>progdurationTlBlocksLtId').val($(this).data('id'));
	$('#<portlet:namespace/>programId').val(${programId});
});

function getProgramCohortsList(){
	$.ajax({
		url : "${programCohortList}",
		type : 'POST',
		data : {
			<portlet:namespace/>yearTo :  $('#yearTo').val(),
			<portlet:namespace/>yearFrom :  $('#yearFrom').val(),	
			<portlet:namespace/>programId : ${programId}
		},
		success : function(payload) {
			$('#programCohortTable').DataTable().destroy();
			$('#programCohortTable').DataTable({
				"data": payload,
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
				"order": [],
			    columns: [
			        { data: 'programName' },
			        { data: 'ayApplicableForm' },
			        { data: 'traineeLevelName' },
			        { data: 'noOfBlocks' },
			        { data: 'levelTypeName' },
			        { data: 'actions',
			        	render: function(data, type, row) {
			        		var obj = jQuery.parseJSON(data);
			            return obj.lastModifiedDate;
			        } },
			        { data: 'actions',
			        	render: function(data, type, row) {
			        		var adminEditCohort = ${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_EDIT_COHORT)};
			        		var adminDeleteCohort = ${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_COHORT)};
			        		var adminScheduleMasterRotation = ${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_SCHEDULE_MASTER_ROTATION)};

			        		var obj = jQuery.parseJSON(data);
			        		var actionsHtml = "";
			        		if(adminEditCohort || adminDeleteCohort){
				        		actionsHtml += `<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">`;
								if(adminEditCohort){
									actionsHtml +=	`<li><a href="`+ obj.editRenderUrl  + `" class="dropdown-item"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg" alt="edit"> <liferay-ui:message key="edit" /> </a></li>`;
	
								}if(adminDeleteCohort){
									actionsHtml +=	 `<li>
									    <a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="`+ obj.progdurationTlBlocksLtId  + `" data-id="`+ obj.progdurationTlBlocksLtId + `" data-target="#deleteModal" data-toggle="modal" >
									    <img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-delete.svg" alt="delete"> <liferay-ui:message key="delete" />
									    </a>
								    </li>`;
								}
			        		}
						var scheduleMasterRotationOption =  `</ul> </div>`;
						if(adminScheduleMasterRotation){
							if(obj.isCurrentYearTraineeLevel) {
								if(obj.isAllTraineeTakenLeaveForCurrentYear == false) {
									scheduleMasterRotationOption = `<li><a href="#" class="dropdown-item" data-target="#allTraineeTakenLeaveForCurrentYearInformationModel" data-toggle="modal"> <img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg" alt="edit"> <liferay-ui:message key="schedule-master-rotations" /> </a> 
									</li> </ul> </div>`
								} else {
									scheduleMasterRotationOption =  `<li> <a href="`+ obj.scheduleMasterRotationRenderUrl  + `" class="dropdown-item"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg" alt="edit"> <liferay-ui:message key="schedule-master-rotations" /> </a> </li> </ul> </div>`;
								}
							}
						}
						
						actionsHtml = actionsHtml + scheduleMasterRotationOption;
						
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
</script>
