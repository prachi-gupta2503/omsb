<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommands.GET_EXAM_LIST%>" var="getExamListURL">
</portlet:resourceURL>

 <portlet:renderURL var="viewScheduledExamsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommands.EXAMS_SCHEDULE_LIST%>" />
</portlet:renderURL>


<portlet:renderURL var="newExamSetupURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommands.NEW_EXAM_SETUP%>" />
		<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>


<portlet:renderURL var="viewWithdrawListURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_WITHDRAW_LIST%>" />
</portlet:renderURL>


<portlet:renderURL var="viewAppealListURL">
	<portlet:param name="mvcRenderCommandName" value="<%=OMSBExamWebPortletKeys.EXAM_APPEAL_LIST%>" />
</portlet:renderURL>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="pagetitle"><liferay-ui:message key="list-of-exams"/></div>
				<div class="information">
					<a href="${newExamSetupURL}" class="btn omsb-bc-red-button"><liferay-ui:message key="new-exam-setup"/></a>
					<a href="${viewScheduledExamsURL}" class="btn omsb-bc-red-button"><liferay-ui:message key="view-scheduled-exams"/></a>
					<a href="${viewWithdrawListURL}" class="btn omsb-bc-red-button"><liferay-ui:message key="view-withdrawal-list"/></a>
					<a href="${viewAppealListURL}" class="btn omsb-bc-red-button"><liferay-ui:message key="view-appeal-list"/></a>
				</div>
			</div>
			<div class="omsb-list-filter ">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="program-name"/></label>
							<%-- <select name="program"  id="program"  class="custom-select form-control">
								<option><liferay-ui:message key="select-program-name"/></option>
								<c:forEach var="program"items="${programs}" >
								  <option value="${program.programMasterId}">${program.programName}</option>
							    </c:forEach>
							</select> --%>
							<input type="text" name="program" id="program" class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="exam-type"/></label>
							<%-- <select name="examType" id="exam_type"  class="custom-select form-control">
								<option><liferay-ui:message key="select-exam-type"/></option>
								<c:forEach var="examType"items="${examTypes}" >
								  <option value="${examType.id}">${examType.examTypeName}</option>
							    </c:forEach>
							</select> --%>
							<input type="text" name="examType" id="exam_type" class="form-control">
						</div>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button m-0" onclick="programExamTypeSearch()"><liferay-ui:message key="search"/></button>
				</div>
			</div>

			<div class="omsb-list-view table-responsive" id="exam-list">
				<table class="display omsb-datatables" id="exam-list-table">
					<thead>
						<tr>
							<th><liferay-ui:message key="program-name" /></th>
							<th><liferay-ui:message key="exam-type" /></th>
							<th><liferay-ui:message key="result-source" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="exam" items="${exams}">
						<tr>
							<td><c:forEach var="program" items="${exam.program}" varStatus="status">
					            ${program.programName}
					             <c:if test="${not status.last}">, </c:if>
					        </c:forEach></td>
							<td>${exam.examType }</td>
							<td>${exam.resultSource }</td>
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
										data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<portlet:renderURL var="editExamSetupURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.NEW_EXAM_SETUP%>" />
										<portlet:param name="examId" value="${exam.id}" />   
										<portlet:param name="cmd" value="editExam" />
									</portlet:renderURL>
									<portlet:renderURL var="viewExamSetupURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_EXAM_SETUP%>" />
										<portlet:param name="examId" value="${exam.id}" />
										<portlet:param name="cmd" value="viewExam" />
									</portlet:renderURL>
									<portlet:renderURL var="addExamScheduleURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
										<portlet:param name="cmd" value="<%=DataflowConstants.ACTION_ADD%>" />
										<%-- <portlet:param name="programName" value="${exam.programName}" /> --%>
										<portlet:param name="examType" value="${exam.examType}" />
										<portlet:param name="examId" value="${exam.id}" />
										<portlet:param name="examTypeId" value="${exam.examTypeId}" />
									</portlet:renderURL> 
									<ul class="dropdown-menu">
										<li><a href="${editExamSetupURL}" class="dropdown-item"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"> <liferay-ui:message key="edit"/></a></li>
										<li><a href="${viewExamSetupURL}" class="dropdown-item"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg"> <liferay-ui:message key="view"/></a></li>
										<li><a href="${addExamScheduleURL}" class="dropdown-item"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-calendar.svg"><liferay-ui:message key="schedule" /></a></li>
									</ul>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>

	/* $('#exam-list-table').DataTable({
    "bLengthChange": false,
    "bFilter": false
    }); */
	

function getExamList(){
	var program = $("#program").val();
	var examType = $("#exam_type").val();
	console.log("program::::::"+program +" , examType : " + examType);
	$("#searchProgramId").val(program);
	$("#searchExamTypeId").val(examType);
	var getExamListURL = "${getExamListURL}";
	$.ajax({
		url: getExamListURL,
		async : false,
		data : {
			<portlet:namespace />program : program,
			<portlet:namespace />examType : examType,
		},
		type : 'POST',
		success : function(data) {
			console.log("data"+data);
			$("#exam-list").html(data);
			$('#exam-list-table').DataTable({
			       "bLengthChange": false,
			       "bFilter": false,
			       dom: 'Bfrtip',
			       buttons: [
			           {
			               extend: 'collection',
			               text: 'Export As',
			               buttons: ['copy', 'excel', 'csv', 'pdf', 'print']
			           },
			           {
			               extend: 'colvis',
			               hide: [1]
			           }
			       ]
			   });
		},
	})
}

   
   
  var examListTable = $('#exam-list-table').DataTable({
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
   }); 
   
  /*  var examListTable = $('#exam-list-table').DataTable({
       "bLengthChange": false,
       dom: 'Bfrtip',
   }); */
   /* search functionality */
	function programExamTypeSearch(){
		
	    var programName = $("#program");
	    var examType = $("#exam_type");
	  	console.log("programName:" +programName.val())
	  
	    examListTable.columns().search('').draw(); // Clear previous search
	    examListTable.column(1).search(examType.val()).column(0).search(programName.val()).draw();
	}
	
	
</script>
<style>
#exam-list-table_wrapper .dataTables_filter {display: none;}
</style>