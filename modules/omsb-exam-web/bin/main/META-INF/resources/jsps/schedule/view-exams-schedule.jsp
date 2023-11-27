<%@ include file="../../init.jsp"%>

<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info m-0">
						<div class="pagetitle">
							<liferay-ui:message key="view-all-schedule-exams" />
						</div>
					</div>
					<div class="omsb-list-filter omsb-more-btn">
						<div class="row">
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="program-name" /></label> 
									<%-- <select
										name="program" id="program" class="custom-select form-control">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="program" items="${programs}">
											<option value="${program.programMasterId}">${program.programName}</option>
										</c:forEach>
									</select> --%>
									<input type="text" name="program" id="program" class="form-control">
								</div>
							</div>

							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="exam-type" /></label> 
										<%-- <select name="examType" id="exam_type" class="custom-select form-control">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="examType" items="${examTypes}">
												<option value="${examType.id}">${examType.examType}</option>
											</c:forEach>
										</select> --%>
										<input type="text" name="examType" id="exam_type" class="form-control">
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="status" /></label> 
									<%-- <select
										name="status" id="status" value=""
										class="custom-select form-control">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="examStatus" items="${examStatus}">
											<aui:option
												value="${examStatus.getName(themeDisplay.getLocale())}">
												<liferay-ui:message
													key="${examStatus.getName(themeDisplay.getLocale())}" />
											</aui:option>
										</c:forEach>
									</select> --%>
									<input type="text" name="status" id="status" class="form-control">
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="exam-date" /></label>
									<input type="text" id="examStartDate" name="examStartDate"
										placeholder="<liferay-ui:message key="DD/MM/YYYY" />"
										class="form-control datePicker">
								</div>
							</div>
							<%-- <div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="exam-ends-on" /></label>
									<input type="text" id="examEndDate" name="examEndDate"
										placeholder="<liferay-ui:message key="DD/MM/YYYY" />"
										class="form-control datePicker">
								</div>
							</div> --%>
						</div>
						<div class="filter-button-wrap">
							<button id="search" type="button" onclick="ScheduleSearch()" class="btn omsb-bc-red-button m-0">
								<liferay-ui:message key="search" />
							</button>
						</div>
					</div>
					<div class="omsb-list-view table-responsive" id="scheduledExamDiv"></div>
					<portlet:renderURL var="backURL">
						<portlet:param name="mvcRenderCommandName" value="/" />
					</portlet:renderURL>


					<div class="omsb-list-view table-responsive" id="scheduleExams">
						<table class="display omsb-datatables" id="scheduledExamTable">
							<thead>
								<tr>
									<th><liferay-ui:message key="program-name" /></th>
									<th><liferay-ui:message key="exam-type" /></th>
									
									<th><liferay-ui:message key="exam-date" /></th>
									<th><liferay-ui:message key="status" /></th>
									<th><liferay-ui:message key="action" /></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="examSchedule" items="${examSchedule}">
									<portlet:renderURL var="examResultListURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_RESULT_LIST%>" />
										<portlet:param name="examTypeId" value="${examSchedule.examType}" />
										<portlet:param name="programId" value="${examSchedule.programId}" />
										<portlet:param name="examScheduleId" value="${examSchedule.id}" />
										<portlet:param name="examDefinitionId" value="${examSchedule.examDefinitionId}" />
										<portlet:param name="examStartDate" value="${examSchedule.examStartDate}" />
										<portlet:param name="examEndDate" value="${examSchedule.examEndDate}" />
										<portlet:param name="examDate" value="${examSchedule.examDate}" />
									</portlet:renderURL>
									<portlet:renderURL var="adminTraineeListURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.ADMIN_TRAINEE_LIST%>" />
										<portlet:param name="programId" value="${examSchedule.programId}" />
										<portlet:param name="examTypeId" value="${examSchedule.examType}" />
										<portlet:param name="examScheduleId" value="${examSchedule.id}" />
										<portlet:param name="examDefinitionId" value="${examSchedule.examDefinitionId}" />
										<portlet:param name="examType" value="${examSchedule.examTypeName}" />
										<portlet:param name="programName" value="${examSchedule.programName}" />
									</portlet:renderURL>
									<tr>
										<td>${examSchedule.programName}</td>
										<c:set var="status-class" value=""></c:set>
										<td><c:if
                                                test="${examSchedule.examStatus eq 'Completed'}">
											<a href="${examResultListURL}">${examSchedule.examTypeName}</a>
											<c:set var="status_class" value="omsb-completed-bg"></c:set>
											</c:if> 
											<c:if test="${examSchedule.examStatus eq 'Announced'}">
											<a href="${adminTraineeListURL }">${examSchedule.examTypeName}</a>
											<c:set var="status_class" value="omsb-announced-bg"></c:set>
											</c:if> 
											<c:if test="${examSchedule.examStatus ne 'Announced' and examSchedule.examStatus ne 'Completed'}">
											 <a style="color:black;">${examSchedule.examTypeName}</a> 
											
											<c:set var="status_class" value="omsb-notannounced-bg"></c:set>
											</c:if></td>
										<%-- <td>${examSchedule.applicationStartDate}</td>
										<td>${examSchedule.applicationEndDate}</td> --%>
										<td>${examSchedule.examDate}</td>
										<td><span class="${status_class}">${examSchedule.examStatus}</span></td>
										<td>
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle"
													type="button" data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>

												<portlet:renderURL var="viewExamScheduleURL">
													<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
													<portlet:param name="cmd" value="<%=DataflowConstants.ACTION_VIEW%>" />
													<portlet:param name="examScheduleId" value="${examSchedule.id}" />
													<portlet:param name="programName" value="${examSchedule.programName}" />
													<!--<portlet:param name="examId" value="${examSchedule.examId}" />
													-->
													<portlet:param name="examId" value="${examSchedule.id}" />
													<portlet:param name="examType" value="${examSchedule.examTypeName}" />
												</portlet:renderURL>

												<portlet:renderURL var="viewExamSetupURL">
													<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_EXAM_SETUP%>" />
													<portlet:param name="examId" value="${examSchedule.examId}" />
													<portlet:param name="cmd" value="viewExam" />
													<portlet:param name="viewExamSchedule" value="viewExamSchedule" />
												</portlet:renderURL>

												<portlet:renderURL var="editExamScheduleURL">
													<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
													<portlet:param name="cmd" value="<%=DataflowConstants.ACTION_EDIT%>" />
													<portlet:param name="examScheduleId" value="${examSchedule.id}" />
													<portlet:param name="programName" value="${examSchedule.programName}" />
													<portlet:param name="examType" value="${examSchedule.examTypeName}" />
													<portlet:param name="examTypeId" value="${examSchedule.examType}" />
													<portlet:param name="editExamSchedule" value="editExamSchedule" />
													<portlet:param name="examId" value="${examSchedule.examId}" />
												</portlet:renderURL>

												<ul class="dropdown-menu">
													<li>
														<a href="${viewExamScheduleURL}" class="dropdown-item">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg" />
																<liferay-ui:message key="view-exam-schedule" />
														</a>
													</li>
													<li>
														<a href="${viewExamSetupURL}" class="dropdown-item">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg" />
																<liferay-ui:message key="view-exam-definition" />
														</a>
													</li>
													<c:if test="${examSchedule.examStatus ne 'Completed'}">
														<li>
															<a href="${editExamScheduleURL}" class="dropdown-item">
																<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg" />
																	<liferay-ui:message key="edit-exam-schedule" />
															</a>
														</li>
													</c:if>
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="bottom-backbtn-wrap">
						<portlet:renderURL var="ExamHomeURL">
							<portlet:param name="mvcRenderCommandName" value="/" />
						</portlet:renderURL>
						<a class="btn omsb-btn btn-back" href="${ExamHomeURL}"><i
							class="fi fi-sr-arrow-left"></i>
						<liferay-ui:message key="back" /></a>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<portlet:resourceURL id="<%=MVCCommands.GET_EXAMS_SCHEDULE%>"
	var="getScheduledExamDataURL" />

<script>
$('.datePicker').datepicker({
	format: "dd/mm/yyyy",
	orientation: "bottom auto",
	autoclose: true
	}).on('change', function(){
	  $('.datepicker').hide();
	});
	

/* $(document).ready(function(){
	var table = $('#scheduledExamTable').DataTable({	
    "bLengthChange": false,	
    "bFilter": false
}); 
	 
}); */
 var scheduledExamTable = $('#scheduledExamTable').DataTable({
    "bLengthChange": false,
    dom: 'Bfrtip',
	"order" : [],
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
});

function getExamFilterData(){
	
	var programName = $("#program").val();
	var examType = $("#exam_type").val();
	var examStartDate = $("#examStartDate").val();
	var examEndDate = $("#examEndDate").val();
	var status = $('#status').val();
	console.log("programName "+programName+ " examType "+ examType +" examStartDate "+examStartDate+ " examEndDate "+examEndDate+" status "+status);
	getScheduledExamData(programName, examType, examStartDate, examEndDate, status);
}

function getScheduledExamData(programName, examType, examStartDate, examEndDate, status){
	$.ajax({
		url: '${getScheduledExamDataURL}',
		async : false,
		data : {
			<portlet:namespace />programId : programName,
			<portlet:namespace />examTypeId : examType,
			<portlet:namespace />examStartDate : examStartDate,
			<portlet:namespace />examEndDate : examEndDate,
			<portlet:namespace />status : status,
		},
		type : 'POST',
		success : function(data) {
			$("#scheduleExams").html(data);
			$('#scheduledExamTable').DataTable({	
			    "bLengthChange": false,	
			    "bFilter": false
			}); 
		},
	})
}


function ScheduleSearch(){
	
    var programName = $("#program");
    var examType = $("#exam_type");
    var examStartDate = $("#examStartDate");
    /* var examEndDate = $("#examEndDate"); */
    var status = $("#status");
  	console.log("programName:" +programName.val())
  	console.log("status:" +status.val())
  
    scheduledExamTable.columns().search('').draw(); // Clear previous search
    scheduledExamTable.column(2).search(examStartDate.val()).column(3).search(status.val()).column(1).search(examType.val()).column(0).search(programName.val()).draw();
}
</script>
<style>
#scheduledExamTable_wrapper .dataTables_filter {display: none;}
</style>