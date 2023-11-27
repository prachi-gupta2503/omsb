<%@ include file="../../init.jsp" %>

<!-- <link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/responsive.bootstrap4.min.css"> -->

	<!--- Start JS files Here --->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!---// End JS files Here --->

<portlet:resourceURL id="/search/logDutyHoursData" var="searchDutyLogHoursURL"/>

<portlet:renderURL var="viewDutyLogHoursURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcRenderCommandName"	value="<%=MVCCommandNames.VIEW_DUTY_LOG_HOURS%>" />
</portlet:renderURL>

<portlet:renderURL var="viewDutyLogViolationURL">
	<portlet:param name="mvcRenderCommandName"	value="<%=MVCCommandNames.VIEW_DUTY_LOG_VIOLATION%>" />
</portlet:renderURL>

<section class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="view.duty.log.hours.admin.page.title" />
					</div>
					<div class="information">
						<a href="<%=viewDutyLogViolationURL %>" class="btn omsb-bc-red-button" type="button">
							<liferay-ui:message key="duty-log-hour-show-violation"/>
						</a>                                 
					</div>							
				</div>
			
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<aui:select name="programMasterId" id="programMasterId" class="form-control" label="duty-log-hour-program-name">
								<aui:option value=""><liferay-ui:message key="common-select" /></aui:option>
								<c:forEach items="${programMastersList}" var="programMaster">
									<aui:option value="${programMaster.id}" >${programMaster.name}</aui:option>
								</c:forEach>
							</aui:select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<aui:select name="traineeCohortDetailsId" id="traineeCohortDetailsId" class="form-control" label="duty-log-hour-cohort">
								<aui:option value=""><liferay-ui:message key="common-select" /></aui:option>
							</aui:select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<aui:select class="form-control" name="traineeId" id="traineeId" label="duty-log-hour-trainee-name">
								<aui:option value=""><liferay-ui:message key="common-select" /></aui:option>
							</aui:select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<aui:select class="form-control" name="traineeLevelId" id="traineeLevelId" label="duty-log-hour-residency-level">
								<aui:option value=""><liferay-ui:message key="common-select" /></aui:option>
							</aui:select>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<aui:input type="date" name="startDate" id="startDate" class="form-control datepicker" label="duty-log-hour-start-date"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<aui:input type="date" name="endDate" id="endDate"  class="form-control datepicker" label="duty-log-hour-end-date"/>
						</div>
					</div>

				</div>
					
				<div class="bottom-backbtn-wrap mt-2 mb-4">
					<button class="btn omsb-bc-red-button" type="button"  onclick="searchDutyLogHours()" >
						<liferay-ui:message key="duty-log-hour-search"/>
					</button>
				</div>

			</div>
				
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables" id="requestData">
					<thead>
						<tr>
							<th><liferay-ui:message key="duty-log-hour-program"/></th>
							<th><liferay-ui:message key="duty-log-hour-duty-type"/></th>
							<th><liferay-ui:message key="duty-log-hour-assignment"/></th>
							<th><liferay-ui:message key="duty-log-hour-start-date"/></th>
							<th><liferay-ui:message key="duty-log-hour-end-date"/></th>
							<th><liferay-ui:message key="duty-log-hour-duration"/></th>
							<th><liferay-ui:message key="duty-log-hour-action"/></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</section>
<% String languageCode=themeDisplay.getLocale().toString(); %>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datepicker/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/js/select-with-search/select2.min.js"></script>
		
<aui:script>
	
	function searchDutyLogHours() {
	
		var url = '<%=searchDutyLogHoursURL.toString()%>';
		var viewUrl = '<%=viewDutyLogHoursURL.toString()%>';

		$.ajax({
			type: "get",
			url: url,
			data:{
				<portlet:namespace/>programMasterId:$('#<portlet:namespace/>programMasterId').val(),
				<portlet:namespace/>traineeId:$('#<portlet:namespace/>traineeId').val(),
				<portlet:namespace/>traineeCohortDetailsId:$('#<portlet:namespace/>traineeCohortDetailsId').val(),
				<portlet:namespace/>traineeLevelId:$('#<portlet:namespace/>traineeLevelId').val(),
				<portlet:namespace/>startDate:$('#<portlet:namespace/>startDate').val(),
				<portlet:namespace/>endDate:$('#<portlet:namespace/>endDate').val()
			},
		}).done(function(response) {
			// Initialize DataTables
			var dataTable = $('#requestData').DataTable();

			// Clear existing rows from the table
			dataTable.clear().draw();
			
			// Populate the DataTable with retrieved data
			$.each(response, function(index, rowData) {
				
				dataTable.row.add([
					rowData.program,
					rowData.dutyType,
					rowData.assignment,
					rowData.startDate,
					rowData.endDate,
					rowData.duration,
					generateActionsDropdown(rowData.dutyLogId) 
				]).draw();
			});
		}).fail(function(error) {
			// Handle the error
		});
		
	}

	function generateActionsDropdown(rowId) {
			
		const id=rowId;
		return "<div class='dropdown'>"+
				"<!-- Dropdown button -->"+
				"<button class='btn fa fa-ellipsis-v dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>"+
				"<i class=''></i>"+
				"</button>"+
				"<!-- Dropdown menu -->"+
				"<ul class='dropdown-menu'>"+
				"<li><a href='javascript:void(0)' onClick='renderPopupView("+id+")' id='<portlet:namespace />popupButton' class='dropdown-item'><i class='fa fa-check-square'></i> <liferay-ui:message key='duty-log-hour-view'/></a>"+
				"</li>"+						
				"</ul>"+
			"</div>";
	}
	
	
	
	$(document).ready(function () {
	$('#<portlet:namespace/>traineeId').select2();
		$('#requestData').DataTable({
			"bLengthChange": false,
			"bFilter": false,
			"paging": true,
			"pageLength": 10
		});

	});
	
	const renderPopupView = (id) => {

		var url = '<%= viewDutyLogHoursURL %>&<portlet:namespace/>dutyLogId='+id;

		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				constrain2view: true,
				cssClass: 'my-popup-dialog',
				destroyOnHide: true,
				resizable: false,
				width: 600,
				height: 400
			},
			title: 'View Duty Hours',
			uri: url
		});
	}

/*AUI().ready('liferay-util-window', function(A) {
A.one('#<portlet:namespace/>popupButton').on('click', function(event) {
	event.preventDefault();

	var url = this.getAttribute('href');
	var popup = Liferay.Util.Window.getWindow({
		dialog: {
			centered: true,
			constrain2view: true,
			cssClass: 'my-popup-dialog',
			destroyOnHide: true,
			resizable: false,
			width: 600,
			height: 400
		},
		title: 'View Duty Hours',
		uri: url
	});

	popup.show();
});

A.one('.close-popup-button').on('click', function(event) {
	event.preventDefault();
	if (popup) {
		popup.destroy();
	}
});
});*/


<!--  get cohort data by programId -->
		 $("#<portlet:namespace />programMasterId").change(function(){
		 
		    $("#<portlet:namespace/>traineeId").empty();
			$("#<portlet:namespace />traineeId").append(new Option("<liferay-ui:message key="common-select" />",0)); 
			$("#<portlet:namespace/>traineeLevelId").empty();
			$("#<portlet:namespace />traineeLevelId").append(new Option("<liferay-ui:message key="common-select" />",0)); 
		 
			var programMasterId = $("#<portlet:namespace />programMasterId").val();
			$("#<portlet:namespace/>traineeCohortDetailsId").empty();
			$("#<portlet:namespace />traineeCohortDetailsId").append(new Option("<liferay-ui:message key="common-select" />",0)); 
	    
	        AUI().use('aui-base', function(A){
	  		       Liferay.Service(
					'/omsbtms.programdutyassignment/get-by-program-id',
					{
					    programId: programMasterId
					},
				   function(obj) {
				     $.each(obj,function(key,value){
			           var cohortText = value.cohortYear;
			           var cohortId = value.traineeCohortDetailsId; 
			           $("#<portlet:namespace/>traineeCohortDetailsId").append(new Option(cohortText,cohortId));
                    
					});
	            })
		    });
	     });
	            
		
		<!-- get Trainee Name by programId and cohort id -->

		 $("#<portlet:namespace />traineeCohortDetailsId").change(function(){
		
		    $("#<portlet:namespace/>traineeLevelId").empty();
			$("#<portlet:namespace />traineeLevelId").append(new Option("<liferay-ui:message key="common-select" />",0)); 
		 
		
			var programMasterId = $("#<portlet:namespace />programMasterId").val();
			var traineeCohortDetailsId = $("#<portlet:namespace />traineeCohortDetailsId").val();
			
			$("#<portlet:namespace/>traineeId").empty();
			$("#<portlet:namespace />traineeId").append(new Option("<liferay-ui:message key="common-select" />",0)); 
	    
	        AUI().use('aui-base', function(A){
		  	   Liferay.Service(
				'/omsbtms.programdutyassignment/get-by-program-id-and-cohort-id',
				{
				    programId: programMasterId,
				    cohortId:traineeCohortDetailsId 
				},
				function(obj) {
					 $.each(obj,function(key,value){
		             traineeName = value.userFullName;
		             traineeId = value.userId; 
		             $("#<portlet:namespace/>traineeId").append(new Option( traineeName, traineeId));
					});
				}
				);
	
	        });
	    });



<!-- get Trainee Name by programId and cohort id and traineeId -->

		 $("#<portlet:namespace />traineeId").change(function(){
		
			var programMasterId = $("#<portlet:namespace />programMasterId").val();
			var traineeCohortDetailsId = $("#<portlet:namespace />traineeCohortDetailsId").val();
			var traineeId = $("#<portlet:namespace />traineeId").val();
			var language="<%=languageCode %>";
			
			$("#<portlet:namespace/>traineeLevelId").empty();
			$("#<portlet:namespace />traineeLevelId").append(new Option("<liferay-ui:message key="common-select" />",0)); 
	    
		    AUI().use('aui-base', function(A){
				  	Liferay.Service(
					'/omsbtms.dutylog/get-by-traniee-id-and-program-duty-assignment-id',
					{
					    traineeId:traineeId ,
					    programId: programMasterId,
					    cohortId: traineeCohortDetailsId,
					    languageCode: language
					},
					function(obj) {
						 $.each(obj,function(key,value){
			             residencyName = value.traineeLevelName;
			             residencyId = value.traineeLevelId; 
			             $("#<portlet:namespace/>traineeLevelId").append(new Option( residencyName, residencyId));
							
						}
						);
			
			    });
	       });
       });
	


</aui:script>