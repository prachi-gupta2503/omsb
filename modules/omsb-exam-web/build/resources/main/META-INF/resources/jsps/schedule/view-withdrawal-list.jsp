<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="pagetitle">
					<liferay-ui:message key="view-withdraw-list" />
				</div>
			</div>
			<div class="omsb-list-filter">
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="trainee-name" /></label> <input
								type="text" name="traineename" placeholder="Trainee name" id="<portlet:namespace/>traineename"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="program-name" /></label> <input
								type="text" name="programname" placeholder="Program name" id="<portlet:namespace/>programname"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="exam-type" /></label> <select
								name="examtype" class="form-control" id="<portlet:namespace/>examtype">
								<option value=""><liferay-ui:message key="select" /></option>
								<c:forEach var="examType" items="${examTypes}">
									<aui:option value="${examType.getName(themeDisplay.getLocale())}">
										<liferay-ui:message
											key="${examType.getName(themeDisplay.getLocale())}" />
									</aui:option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button"  onclick="withdrawFilterSearch()">
						<liferay-ui:message key="search" />
					</button>
				</div>
			</div>

			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables" id="withdrawal-program-list">
					<thead>
						<tr>
							<th><liferay-ui:message key="trainee-name" /></th>
							<th><liferay-ui:message key="program-name" /></th>
							<th><liferay-ui:message key="exam-type" /></th>
							<th><liferay-ui:message key="withdrawal-status" /></th>
							<th><liferay-ui:message key="actions" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="examWithdrawal" items="${examWithdrawal}">
							<tr>
								<td>${examWithdrawal.traineeName}</td>
								<td>${examWithdrawal.programName}</td>
								<td>${examWithdrawal.examType}</td>
								<%-- <td>${examWithdrawal.withdrawalStatusValue}</td> --%>
								<c:set var="status-class" value=""></c:set>
										<td><c:if
                                                test="${examWithdrawal.withdrawalStatusValue eq 'accepted'}">
											${examWithdrawal.withdrawalStatusValue}
											<c:set var="status_class" value="omsb-completed-bg"></c:set>
											</c:if> 
											<c:if test="${examWithdrawal.withdrawalStatusValue eq 'rejected'}">
											${examWithdrawal.withdrawalStatusValue}
											<c:set var="status_class" value="omsb-announced-bg"></c:set>
											</c:if> 
											<c:if test="${examWithdrawal.withdrawalStatusValue ne 'accepted' and examWithdrawal.withdrawalStatusValue ne 'rejected'}">
											${examWithdrawal.withdrawalStatusValue}
											<c:set var="status_class" value="omsb-notannounced-bg"></c:set>
											</c:if></td>
								
								<td>
									<div class="dropdown ">
										<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
										<portlet:renderURL var="viewURL">
											<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_ADMIN_WITHDRAWAL_VIEW%>" />
											<portlet:param name="withdrawalId" value="${examWithdrawal.id}" />
											<portlet:param name="assignedToMe" value="${examWithdrawal.assignedToMe}" />
											<portlet:param name="workflowTaskId" value="${examWithdrawal.workflowTaskId}" />
											<portlet:param name="workflowInstanceId" value="${examWithdrawal.workflowInstanceId}" />
										</portlet:renderURL>
										<a href="${viewURL }"><button class="btn upload_btn" title="view"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg"/><liferay-ui:message key="view" /></button></a>
										<portlet:actionURL var="WorkflowAssignURL" name="/exam/workflow_action">
											<portlet:param name="assignedToMe" value="${examWithdrawal.assignedToMe}" />
											<portlet:param name="workflowTaskId" value="${examWithdrawal.workflowTaskId}" />
											<portlet:param name="workflowInstanceId" value="${examWithdrawal.workflowInstanceId}" />
											<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
											<portlet:param name="withdrawalId" value="${examWithdrawal.id}" />
										</portlet:actionURL>
										<%-- <c:if test ="${examWithdrawal.assignedToMe}" >
											<li><a href="${WorkflowAssignURL}" class="dropdown-item">
											<i class="fa fa-eye"></i><liferay-ui:message key="assign-to-me" /></a></li>
										</c:if>
										<c:if test ="${!examWithdrawal.assignedToMe}" >
				 							 <c:forEach var="tName" items="${examWithdrawal.transitionNames }">  
							 					<li><a href="${viewURL}"  class="dropdown-item">
									  			<i class="fa fa-plus-square-o"></i> <liferay-ui:message key="${tName }" /> </a></li>
							 				 </c:forEach>
										</c:if> --%>
										</ul>
									</div>
								</td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="bottom-backbtn-wrap">
				<a class="btn omsb-btn btn-back" href="${backURL}"><i
					class="fi fi-sr-arrow-left"></i>
				<liferay-ui:message key="back" /></a>
			</div>
		</div>
	</div>
</div>


<script>

var table = $('#withdrawal-program-list').DataTable({
    "bLengthChange": false,
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


function withdrawFilterSearch() {
	
    var examType = $("#<portlet:namespace/>examtype");
    var traineename = $("#<portlet:namespace/>traineename");
    var programname = $("#<portlet:namespace/>programname");
  
  
    table.columns().search('').draw(); // Clear previous search
    table.column(2).search(examType.val()).column(0).search(traineename.val()).column(1).search(programname.val()).draw();
}
</script>
	<style>
		#withdrawal-program-list_wrapper .dataTables_filter {display: none;}
	</style>