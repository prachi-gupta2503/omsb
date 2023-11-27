<%@include file = "../../init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

			<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info m-0">
								<div class="pagetitle"><liferay-ui:message key="view-appeal-list" /></div>
						</div>
						<div class="omsb-list-filter">
							<div class="row">
								<div class="col-lg-3 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="trainee-name" /></label></label>
										<input type="text" name="traineename" placeholder="Trainee name" class="form-control" id="<portlet:namespace/>traineename">
									</div>
								</div>
								<div class="col-lg-3 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="program-name" /></label></label>
										<input type="text" name="programname" placeholder="Program name" class="form-control" id="<portlet:namespace/>programname">
									</div>
								</div>
								<div class="col-lg-3 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="exam-type" /></label></label>
										<select name="examtype" class="form-control" id="<portlet:namespace/>examtype">
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
								<div class="col-lg-3 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="result" /></label></label>
										<%-- <select name="result" class="form-control" id="<portlet:namespace/>result">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="resultStatus" items="${resultStatusList}">
												<aui:option value="${resultStatus.getListTypeEntryId() }">
													<liferay-ui:message
														key="${resultStatus.getName(themeDisplay.getLocale())}" />
												</aui:option>
										</c:forEach>
										</select> --%>
										<input type="text" name="status" placeholder="status" class="form-control" id="status">
									</div>
								</div>
								
							</div>
							<div class="filter-button-wrap">
								<button class="btn omsb-bc-red-button" onclick="appealFilterSearch()"><liferay-ui:message key="search" /></label></button>
							</div>
							
						</div>

						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables" id="appeal-list-table">
								<thead>
									<tr>
										<th><liferay-ui:message key="trainee-name" /></label></th>
										<th><liferay-ui:message key="program-name" /></label></th>
										<th><liferay-ui:message key="exam-type" /></label></th>
										<th><liferay-ui:message key="result" /></label></th>
										<th><liferay-ui:message key="percentage" /></label></th>
										<th><liferay-ui:message key="status" /></label></th>
										<th><liferay-ui:message key="actions" /></label></th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${appealList}" var = "appeal">
										<tr>
											<td>${appeal.traineeName }</td>
											<td>${appeal.programName }</td>
											<td>${appeal.examType}</td>
											<td><span class="omsb-complete-bg">${appeal.result}</span></td>
											<td>${appeal.percentage}</td>
											<td><span class="omsb-complete-bg">${appeal.appealStatusValue }</span></td>
											<td>
												<div class="dropdown ">
													<button class="btn fa fa-ellipsis-v dropdown-toggle"
														type="button" data-toggle="dropdown" aria-expanded="false">
														<i class=""></i>
													</button>
													<ul class="dropdown-menu">
														<portlet:renderURL var="viewURL">
															<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_ADMIN_APPEAL_VIEW%>" />
															<portlet:param name="appealId" value="${appeal.id}" />
															<portlet:param name="assignedToMe" value="${appeal.assignedToMe}" />
															<portlet:param name="workflowTaskId" value="${appeal.workflowTaskId}" />
															<portlet:param name="workflowInstanceId" value="${appeal.workflowInstanceId}" />
														</portlet:renderURL>
														<portlet:actionURL var="WorkflowAssignURL" name="/exam/workflow_action">
															<portlet:param name="assignedToMe" value="${appeal.assignedToMe}" />
															<portlet:param name="workflowTaskId" value="${appeal.workflowTaskId}" />
															<portlet:param name="workflowInstanceId" value="${appeal.workflowInstanceId}" />
															<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
															<portlet:param name="appealId" value="${appeal.id}" />
														</portlet:actionURL>
														<li><a href="${viewURL}" class="dropdown-item"><i class="fa fa-eye"></i>
															<liferay-ui:message key="view" /></a></li>
															<%-- <c:if test ="${appeal.assignedToMe}" >
																<li><a href="${WorkflowAssignURL}" class="dropdown-item">
																<i class="fa fa-eye"></i><liferay-ui:message key="assign-to-me" /></a></li>
															</c:if>
															<c:if test ="${!appeal.assignedToMe}" >
									 							 <c:forEach var="tName" items="${appeal.transitionNames }">  
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
						<a class="btn omsb-btn btn-back" href="${backURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></label></a>
					</div>
					</div>
				</div>
			</div>

<script>
	/* $('#appeal-list-table').DataTable({
   		"bLengthChange": false,
   		"bFilter": false,
   		"ordering": false
	}); */
	
	
	$('#appeal-list-table').DataTable({
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
	$('#examstartdate').datepicker({
		dateFormat: 'dd-mm-yyyy'
	});

	$('#examenddate').datepicker({
		dateFormat: 'dd-mm-yyyy'
	});

	

	$(document).ready(function () {
		var trigger = $('.hamburger'),
			overlay = $('.overlay'),
			isClosed = false;

		trigger.click(function () {
			hamburger_cross();
		});

		function hamburger_cross() {

			if (isClosed == true) {
				overlay.hide();
				trigger.removeClass('is-open');
				trigger.addClass('is-closed');
				isClosed = false;
			} else {
				overlay.show();
				trigger.removeClass('is-closed');
				trigger.addClass('is-open');
				isClosed = true;
			}
		}

		$('[data-toggle="offcanvas"]').click(function () {
			$('#omsb-main-wrapper').toggleClass('toggled');
		});
	});
	
	
	
	function appealFilterSearch() {
		
	    var table = $('#appeal-list-table').DataTable();
		
	    var examType = $("#<portlet:namespace/>examtype");
	    var traineename = $("#<portlet:namespace/>traineename");
	    var programname = $("#<portlet:namespace/>programname");
	    var result = $("#<portlet:namespace/>result");
	    var selectedLabel = $('#<portlet:namespace/>examtype option:selected').text();
	   
	  
	  
	    table.columns().search('').draw(); // Clear previous search
	    table.column(2).search(examType.val()).column(0).search(traineename.val()).column(1).search(programname.val()).column(3).search(result.val()).draw();
	}		
	</script>
<style>
#appeal-list-table_wrapper .dataTables_filter {display: none;}
</style>