<%@ include file="../../init.jsp" %>


<portlet:renderURL var="viewDutyLogViolationForTraineeURL">
     <portlet:param name="mvcRenderCommandName"	value="<%=MVCCommandNames.TRAINEE_VIEW_DUTY_LOG_VIOLATION%>" />
</portlet:renderURL>

<portlet:resourceURL id="/search/dutyLogViolationData" var="searchDutyLogHoursURL"/>
<section class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="view-duty-log-violation-page-title" />
					</div>		
						<%-- <a href="<%=viewDutyLogViolationForTraineeURL%>" class="btn omsb-bc-red-button" type="button">Trainee violation</a> 
							--%>				
				</div>
				
				<aui:form action="#" id="search_Log_Duty_Hours" name="search_Log_Duty_Hours" method="post" class="search-log-duty-hours-form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<aui:select name="programMasterId" id="programMasterId" class="form-control" label="duty-log-violation-program-name">
									<aui:option value="0"><liferay-ui:message key="common-select" /></aui:option>
									<c:forEach items="${programMastersList}" var="programMaster">
										<aui:option value="${programMaster.id}" >${programMaster.name}</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<aui:select name="traineeCohortDetailsId" id="traineeCohortDetailsId" class="form-control" label="duty-log-violation-cohort">
										 <aui:option value="0"><liferay-ui:message key="common-select" /></aui:option>
								</aui:select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<aui:select class="form-control" name="traineeId" id="traineeId" label="duty-log-violation-trainee-name">
									 <aui:option value="0"><liferay-ui:message key="common-select" /></aui:option>
								</aui:select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<aui:select class="form-control" name="traineeLevelId" id="traineeLevelId" label="duty-log-violation-residency-level">
								    <aui:option value="0"><liferay-ui:message key="common-select" /></aui:option>
								</aui:select>
							</div>
						</div>
					</div>
					<div class="bottom-backbtn-wrap mt-2 mb-4">
						<button class="btn omsb-bc-red-button" type="button"  onclick="searchDutyLogHours()" >
							<liferay-ui:message key="duty-log-violation-search"/>
						</button>
					</div>
				</aui:form>

				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="requestData">
						<thead>
							<tr>
								<th><liferay-ui:message key="duty-log-violation-program"/></th>
								<th><liferay-ui:message key="duty-log-violation-residency-level"/></th>
								<th><liferay-ui:message key="duty-log-violation-rotation-training-site"/></th>
								<th><liferay-ui:message key="duty-log-violation-block"/></th>
								<th><liferay-ui:message key="duty-log-violation-date"/></th>
								<th><liferay-ui:message key="duty-log-violation-80-hr-rule"/></th>
								<th><liferay-ui:message key="duty-log-violation-24-hr-rule"/></th>
								<th><liferay-ui:message key="duty-log-violation-call-rule-option1"/></th>
								<th><liferay-ui:message key="duty-log-violation-call-rule-option2"/></th>
								<th><liferay-ui:message key="duty-log-violation-short-break-rule"/></th>
								<th><liferay-ui:message key="duty-log-violation-day-off-rule"/></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<% String languageCode=themeDisplay.getLocale().toString(); %>
</section>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datepicker/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/js/select-with-search/select2.min.js"></script>
	
<aui:script>
	
	$(document).ready(function () {
	$('#<portlet:namespace/>traineeId').select2();
		$('#requestData').DataTable({
			"bLengthChange": false,
			"bFilter": false,
			"paging": true,
			"pageLength": 10
		});

	});
	
	
	function searchDutyLogHours() {
		var url = '<%=searchDutyLogHoursURL.toString()%>';
		
		$.ajax({
			type: "get",
			url: url,
			data:{
				<portlet:namespace/>programMasterId:$('#<portlet:namespace/>programMasterId').val(),
				<portlet:namespace/>traineeId:$('#<portlet:namespace/>traineeId').val(),
				<portlet:namespace/>traineeCohortDetailsId:$('#<portlet:namespace/>traineeCohortDetailsId').val(),
				<portlet:namespace/>traineeLevelId:$('#<portlet:namespace/>traineeLevelId').val()
			},
		}).done(function(response) {
			// Initialize DataTables
			var dataTable = $('#requestData').DataTable();
			
			// Clear existing rows from the table
			dataTable.clear().draw();
			
			// Populate the DataTable with retrieved data
			$.each(response, function(index, rowData) {
				console.log("rowData  "+rowData);
				dataTable.row.add([
					rowData.program,
					rowData.residencyLevel,
					rowData.rotaionTrainingName,
					rowData.blockNo,
					rowData.date,
					rowData.acgme80HoursRule,
					rowData.acgme24HoursRule,
					rowData.acgmeCallRuleOption1,
					rowData.acgmeCallRuleOption2,
					rowData.acgmeShortBreakRule,
					rowData.acgmeDayOffRule,
					generateActionsDropdown(rowData.dutyLogViolationId) 
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
				"<li><a href='javascript:void(0)' onClick='renderPopupView("+id+")' id='<portlet:namespace />popupButton' class='dropdown-item'><i class='fa fa-check-square'></i> View</a>"+
				"</li>"+						
				"</ul>"+
			"</div>";
	}


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
