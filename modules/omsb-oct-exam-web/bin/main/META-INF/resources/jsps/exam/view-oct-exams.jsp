<%@ include file="../../init.jsp"%>

<portlet:resourceURL
	id="<%=MVCCommandNames.ADMIN_SEARCH_OCT_EXAMS_DETAILS%>"
	var="getExamSearchData">
	<portlet:param name="cmd" value="getExamSearchData" />
</portlet:resourceURL>

<portlet:renderURL var="octExamSetup">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OCT_NEW_EXAM_SETUP%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="viewOCTScheduledExams">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
</portlet:renderURL>

<portlet:renderURL var="viewApplicantRequests">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_APPLICANT_REQUESTS%>" />
	<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
</portlet:renderURL>
<portlet:renderURL var="examResultListURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OCT_EXAM_RESULT_LIST%>" />
	<portlet:param name="examScheduleId" value="0" /> 
	<%-- <portlet:param name="examDefinitionId" value="${examSchedule.examDefinitionId}" />
	<portlet:param name="examStartDate" value="${examSchedule.examStartDate}" />
	<portlet:param name="examEndDate" value="${examSchedule.examEndDate}" />
	<portlet:param name="examDate" value="${examSchedule.examDate}" /> --%>
</portlet:renderURL>

 <%-- <a href="${examResultListURL}"><liferay-ui:message key="view-result" /></a> --%>

<!-- Inner Wrapper Contents -->
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<liferay-ui:message key="view-oc-exams" />
				</div>
				<div class="information">
					<a href="${octExamSetup}" class="btn omsb-bc-red-button"> <liferay-ui:message
							key="new-exam-setup" />
					</a> 
					<a href="${viewOCTScheduledExams}" class="btn omsb-bc-red-button">
						<liferay-ui:message key="view-all-oc-scheduled-exams" />
					</a> 
					<a href="${viewApplicantRequests}" class="btn omsb-bc-red-button">
						<liferay-ui:message key="view-all-applicant-request" />
					</a>
				</div>
			</div>
			<div class="omsb-list-filter">
				<div class="row">
					<div class="col-lg-12 col-md-12">
						<div class="form-group">
							<label><liferay-ui:message key="exam-title" /></label> <select
								id="examTitleId" name="examTitleId" class="form-control">
								<option value=""><liferay-ui:message key="select" /></option>
								<c:forEach var="examTitle" items="${examTitleList}">
									<option value="${examTitle.getListTypeEntryId() }">
										<liferay-ui:message
											key="${examTitle.getName(themeDisplay.getLocale())}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button" onclick="searchByExamTitle()">
						<liferay-ui:message key="search" />
					</button>
				</div>
			</div>

			<div class="omsb-list-view table-responsive" id="octExamsTable">
				<table class="display omsb-datatables" id="octExamList">
					<thead>
						<tr>
							<th><liferay-ui:message key="exam-title" /></th>
							<th><liferay-ui:message key="duration-of-exam-in-hrs" /></th>
							<th><liferay-ui:message key="result-source" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${octExamDetailsList}" var="octExamDetails">

							<portlet:renderURL var="editOCTExam">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.OCT_NEW_EXAM_SETUP%>" />
								<portlet:param name="octExamId" value="${octExamDetails.getId()}" />
								<portlet:param name="cmd" value="editExam" />
								<portlet:param name="octExamId" value="${octExamDetails.getId()}" />
							</portlet:renderURL>

							<portlet:renderURL var="viewOCTExamDetails">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.ADMIN_VIEW_EXAM_SETUP%>" />
								<portlet:param name="octExamId"
									value="${octExamDetails.getId()}" />
							</portlet:renderURL>

							<portlet:renderURL var="scheduleOCTExam">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_RENDER%>" />
								<portlet:param name="octExamId" value="${octExamDetails.getId()}" />
								<portlet:param name="action" value="add" />
							</portlet:renderURL>

							<tr>
								<td>${octExamDetails.getOCTExamTitle()}</td>
								<td>${octExamDetails.getExamJson().getExamDuration()}</td>
								<td>${octExamDetails.getExamJson().getResultSourceName()}</td>
								<td><%@ include file="./oct-exam-list-actions.jsp"%>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Inner Wrapper Contents -->

<script>
	function getOCTExamData() {
		var examTitleId = $("#examTitleId").val();

		var getExamSearchDataURL = "${getExamSearchData}";
		$.ajax({
			url : getExamSearchDataURL,
			async : false,
			data : {
				<portlet:namespace />examTitleId : examTitleId
			},
			type : 'POST',
			success : function(data) {
				$("#octExamsTable").html(data);
			},
		})
	}

	/*  $('#octExamList').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"order" : []
	});  */
	 
	
	 var examListTable = $('#octExamList').DataTable({
	       "bLengthChange": false,
	       dom: 'Bfrtip',
	       buttons: [
	    	   {
	               extend: 'colvis',
	               hide: [1]
	           },
	           {
	               extend: 'collection',
	               text: 'Export As',
	               buttons: ['copy', 'excel', 'csv', 'pdf', 'print']
	           }
	           
	       ]
	   }); 
	

		// Remove the modal backdrop if needed
		$(".modal-backdrop").remove();

	 $(window).on('load', function() {debugger;
		 var id= "${id}";
		 if(id !=undefined && id !="" ){
			 var hrf = $('.schedule_'+id).attr('href');
			if(hrf != undefined && hrf != ""){
				window.location = hrf;
			}
		 }
		
	 });
	 
	 function searchByExamTitle(){
		 
		 
			var selectElement = document.getElementById("examTitleId");
		    var selectedOption = selectElement.options[selectElement.selectedIndex];
		    var innerHTMLValue = selectedOption.innerHTML.trim();
		    console.log("Inner HTML Value: " + innerHTMLValue);
			
		  	console.log("examTitle :" +innerHTMLValue)
		  
		    examListTable.columns().search('').draw(); // Clear previous search
		    examListTable.column(0).search(innerHTMLValue).draw();
		}
	 
</script>

<style>
#octExamList_wrapper .dataTables_filter {display: none;}

</style>
