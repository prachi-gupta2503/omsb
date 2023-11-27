<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<portlet:resourceURL
	id="<%=MVCCommandNames.SEARCH_OCT_EXAMS_SCHEDULE_DETAILS_RENDER%>"
	var="getScheduleExamSearchData">
	<portlet:param name="cmd" value="getScheduleExamSearchData" />
</portlet:resourceURL>
<c:set var="completed" value="<%=DataflowConstants.COMPLETED%>"></c:set>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<%-- <div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="view-all-oc-scheduled-exams" />
					</div>
				</div>
			</div> --%>
			<div class="omsb-list-filter">
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="exam-title" /></label><select
								id="examTitleId" name="examTitleId" class="form-control">
								<option value=""><liferay-ui:message key="select" /></option>
								<c:forEach var="examTitle" items="${examTitleList}">
									<aui:option value="${examTitle.getName(themeDisplay.getLocale())}">
										${examTitle.getName(themeDisplay.getLocale())}
									</aui:option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="exam-date" /></label> <input
								type="text" name="examStartDate" id="examStartDate"
								placeholder="<liferay-ui:message key="DD/MM/YYYY" />" class="form-control datePicker">
						</div>
					</div>
					
					
					<!-- <div class="col-lg-3 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="exam-end-date" /></label> <input
								type="text" name="examend_date" id="examEndDate"
								placeholder="DD/MM/YYYY" class="form-control datePicker">
						</div>
					</div> -->
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="status" /></label> <select
								id="status" name="status" class="form-control">
								<option value=""><liferay-ui:message key="select" /></option>
								<c:forEach var="status" items="${statusListTypeEntryList}">
									<aui:option value="${status.getName(themeDisplay.getLocale())}">
										${status.getName(themeDisplay.getLocale())}
									</aui:option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button class="btn btn omsb-bc-red-button"
						onclick="getOCTExamScheduleData()">
						<liferay-ui:message key="search" />
					</button>
				</div>
			</div>

			<div class="omsb-list-view table-responsive"
				id="octExamScheduleTable">
				<table class="display omsb-datatables" id="octExamScheduleList">
					<thead>
						<tr>
							<th><liferay-ui:message key="exam-title" /></th>
							<th><liferay-ui:message key="exam-date" /></th>
							<th><liferay-ui:message key="exam-slot" /></th>
							<th><liferay-ui:message key="status" /></th>
							<th><liferay-ui:message key="actions" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${octExamScheduleList}" var="octExamSchedule">
							<portlet:renderURL var="editOCTExamSchedule">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_RENDER%>" />
								<portlet:param name="octExamScheduleId"
									value="${octExamSchedule.getId()}" />
									<portlet:param name="octExamId" value="${octExamSchedule.getExamId()}" />
									<portlet:param name="action" value="edit" />
							</portlet:renderURL>

							<portlet:renderURL var="viewOCTExamSchedule">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_RENDER%>" />
								<portlet:param name="octExamScheduleId"
									value="${octExamSchedule.getId()}" />
								<portlet:param name="role" value="admin" />	
							</portlet:renderURL>

							<portlet:renderURL var="viewUploadResultScreen">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.VIEW_UPLOAD_RESULT_SCREEN_RENDER%>" />
							</portlet:renderURL>

							<portlet:renderURL var="viewEligibleTraineesList">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.VIEW_ELIGIBLE_TRAINEES_LIST_RENDER%>" />
								<portlet:param name="departmentId"
									value="${octExamSchedule.getDepartmentId()}" />
									<portlet:param name="sectionId"
									value="${octExamSchedule.getSectionId()}" />
									<portlet:param name="examDefinitionId"
									value="${octExamSchedule.getOctExamDefinitionId()}" />
									<portlet:param name="examScheduleId"
									value="${octExamSchedule.getId()}" />
									<portlet:param name="examTitle"
									value="${octExamSchedule.getOctExamTitleName()}" />
									
							</portlet:renderURL>
							<portlet:renderURL var="examResultListURL">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.OCT_EXAM_RESULT_LIST%>" />
								<portlet:param name="examScheduleId"
									value="${octExamSchedule.getId()}" />
								<portlet:param name="examTitle"
									value="${octExamSchedule.getOctExamTitleName()}" />
								<portlet:param name="startDate"
									value="${octExamSchedule.getRegistrationStartDate()}" />
									
								<portlet:param name="examTitle"
									value="${octExamSchedule.getOctExamTitleName()}" />	
							</portlet:renderURL>
							
							<portlet:renderURL var="viewOCTExamDetails">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.ADMIN_VIEW_EXAM_SETUP%>" />
								<portlet:param name="definitionId"
									value="${octExamSchedule.getOctExamDefinitionId()}" />
								<portlet:param name="viewDefinition"
									value="viewDefinition" />
							</portlet:renderURL>
							
							<liferay-portlet:actionURL name="<%=MVCCommandNames.EXAM_SCHEDULE_ACTIONS%>"
							var="scheduleExamAction" />
	
							<tr>
								<c:choose>
									<c:when
										test="${octExamSchedule.getExamStatusName() eq completed }">
										<td><a href="${examResultListURL}">${octExamSchedule.getOctExamTitleName()}</a></td>
									</c:when>
									<c:when
										test="${octExamSchedule.getExamStatusName() eq 'Announced' || octExamSchedule.getExamStatusName() eq 'Rescheduled'}">
									<td><a href="${viewEligibleTraineesList}">${octExamSchedule.getOctExamTitleName()}</a></td>
									</c:when>	
									<c:otherwise>
										<td>${octExamSchedule.getOctExamTitleName()}</td>
									</c:otherwise>
								</c:choose>
								<td>${octExamSchedule.getExamDate()}</td>
								<td>${octExamSchedule.getExamSlot()}</td>
								<%-- <td>${octExamSchedule.getExamEndTime()}</td> --%>
								
								<c:if test="${octExamSchedule.getExamStatusName() eq 'Rescheduled'}">
								<td><span class="${octExamSchedule.getExamStatusColor()}">Announced</span></td>
								</c:if>
								
								<c:if test="${octExamSchedule.getExamStatusName() ne 'Rescheduled'}">
								<td><span class="${octExamSchedule.getExamStatusColor()}">${octExamSchedule.getExamStatusName()}</span></td>
								</c:if>
								
								<td><%@ include file="./oct-exam-list-schedule-actions.jsp"%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			

			<div class="bottom-backbtn-wrap">
				<a class="btn omsb-btn btn-back" href="${backURL}"><i
					class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
			</div>
		</div>


	</div>
</div>

<script>


	$(document).ready(function() {
		$('#examStartDate').datepicker({
			format : "dd/mm/yyyy",
			orientation : "bottom auto",
			"ordering": false,
			autoclose : true
		});
	});


	/* function getOCTExamScheduleData() {
		var examTitleId = $("#examTitleId").val();
		var examStartDate = $("#examStartDate").val();
		var examStatusId = $("#status").val();
		var getScheduleExamSearchDataURL = "${getScheduleExamSearchData}";
		$.ajax({
			url : getScheduleExamSearchDataURL,
			async : false,
			data : {
				<portlet:namespace />examTitleId : examTitleId,
				<portlet:namespace />examStartDate : examStartDate,
				<portlet:namespace />examStatusId : examStatusId
			},
			type : 'POST',
			success : function(data) {
				$("#octExamScheduleTable").html(data);
			},
		})
	} */
	
	
	
	
	var scheduleList = $('#octExamScheduleList').DataTable({
	       "bLengthChange": false,
	       "ordering": false,
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
	
	function getOCTExamScheduleData(){
		var examTitleId = $("#examTitleId").val();
	    var examStartDate = $("#examStartDate").val();
	    var examStatusId = $("#status").val();
		
	    console.log("Inner HTML Value: " + examTitleId);
	    console.log("examStartDate "+examStartDate)
	    console.log("examStatusId "+examStatusId)
	  
	    scheduleList.columns().search('').draw(); // Clear previous search
	    scheduleList.column(0).search(examTitleId).column(1).search(examStartDate).column(3).search(examStatusId).draw();
	}
</script>

<style>
#octExamScheduleList_wrapper .dataTables_filter {display: none;}
</style>