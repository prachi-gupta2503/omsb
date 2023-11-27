<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="gov.omsb.common.constants.DataflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file = "../../init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

			
						<div class="omsb-list-filter">
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="exam-title" /></label></label>
										<input type="text" id="examtitle" name="examtitle" placeholder="<liferay-ui:message key="exam-title" />" class="form-control">
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="trainee-name" /></label></label>
										<input type="text" id="traineename" name="traineename" placeholder="<liferay-ui:message key="trainee-name" />" class="form-control">
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="status" /></label></label>
										<select name="status" class="form-control" id="appealStatus">
											<option>select</option>
											<option value="1"><liferay-ui:message key="appeal" /> </option>
											<option value="2"><liferay-ui:message key="re-appeal" /></option>
										</select>
									</div>
								</div>
								
							</div>
							<div class="filter-button-wrap">
								<button class="btn omsb-bc-red-button" onclick="searchAppealList()"><liferay-ui:message key="search" /></label></button>
							</div>
							
						</div>

						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables" id="appeal-list-table">
								<thead>
									<tr>
										<th><liferay-ui:message key="exam-title" /></label></th>
										<th><liferay-ui:message key="trainee-name" /></label></th>
										<th><liferay-ui:message key="result" /></label></th>
										<th><liferay-ui:message key="score" /></label></th>
										<th><liferay-ui:message key="oct-appeal-status" /></label></th>
										<th><liferay-ui:message key="actions" /></label></th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${appealList}" var = "appeal">
										<tr>
											<td>Oman Examination For Nurses ${appeal.programName }</td>
											<td>${appeal.traineeName }</td>
											<td><span class="omsb-complete-bg">${appeal.result}</span></td>
											<td>${appeal.percentage}</td>
											<td><span class="${appeal.statusColor}">${appeal.appealStatusValue }</span></td>
											<td>
												<div class="dropdown ">
													<button class="btn fa fa-ellipsis-v dropdown-toggle"
														type="button" data-toggle="dropdown" aria-expanded="false">
														<i class=""></i>
													</button>
													<ul class="dropdown-menu">
														<portlet:renderURL var="viewURL">
 															<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OCT_EXAM_ADMIN_APPEAL_VIEW%>" /> 															
															<portlet:param name="appealId" value="${appeal.id}" />
															<portlet:param name="assignedToMe" value="${appeal.assignedToMe}" />
															<portlet:param name="workflowTaskId" value="${appeal.workflowTaskId}" />
															<portlet:param name="workflowInstanceId" value="${appeal.workflowInstanceId}" />
														</portlet:renderURL>
														<portlet:actionURL var="WorkflowAssignURL" name="<%=MVCCommandNames.OCT_EXAM_WORKFLOW%>">
															<portlet:param name="assignedToMe" value="${appeal.assignedToMe}" />
															<portlet:param name="workflowTaskId" value="${appeal.workflowTaskId}" />
															<portlet:param name="workflowInstanceId" value="${appeal.workflowInstanceId}" />
															<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
															<portlet:param name="appealId" value="${appeal.id}" />
														</portlet:actionURL>
														<li><a href="${viewURL}" class="dropdown-item"><i class="fa fa-eye"></i>
															<liferay-ui:message key="view" /></a></li>
															
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
					
<script>

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
		
		var appealList = $('#appeal-list-table').DataTable({
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
		function searchAppealList(){
			var appealExamTittle = $("#examtitle").val();
			var traineename = $("#traineename").val();
			var appealStatus = $("#appealStatus").val();
			appealList.columns().search('').draw(); // Clear previous search
			appealList.column(0).search(appealExamTittle).column(1).search(traineename).column(4).search(appealStatus).draw();
			
		}
	</script>
