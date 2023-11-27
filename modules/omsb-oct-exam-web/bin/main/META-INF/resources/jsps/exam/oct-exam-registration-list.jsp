<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="gov.omsb.common.constants.DataflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file = "../../init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
										<div class="omsb-list-filter">
											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12">
													<div class="form-group">
													<label><liferay-ui:message key="exam-title" /></label> <select
														id="examTitleId" name="examTitleId" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="examTitle" items="${examTitleList}">
																<option value="${examTitle.getName(themeDisplay.getLocale()) }">
																	<liferay-ui:message
																		key="${examTitle.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<%-- <label><liferay-ui:message key="exam-title"/></label>
														<input type="text" name="Exam Title" id="examtitle" placeholder="<liferay-ui:message key="exam-title"/>" class="form-control"> --%>
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12">
													<div class="form-group">
														<label><liferay-ui:message key="trainee-name"/></label>
														<input type="text" name="Trainee name" id="traineeName" placeholder="<liferay-ui:message key="trainee-name"/>"  class="form-control">
													</div>
												</div>
											</div>
											<div class="filter-button-wrap">
												<button class="btn omsb-bc-red-button" onclick="searchRegistratonList()"><liferay-ui:message key="search"/></button>
											</div>
										</div>
										<div class="omsb-list-view table-responsive">
											<table class="display omsb-datatables" id="registration-list">
												<thead>
													<tr>
											
														<th><liferay-ui:message key="exam-title"/></th>
														<th><liferay-ui:message key="applicant-name"/></th>
														<th><liferay-ui:message key="exam-date"/></th>
														<th><liferay-ui:message key="exam-start-time"/></th>
														<th><liferay-ui:message key="status"/></th>
														<th><liferay-ui:message key="actions"/></th>
													</tr>
												</thead>
												<tbody>
												<c:forEach items="${registrationList}" var = "registration">
												
													<tr>
														<td>${registration.examTitle}</td>
														<td>${registration.firstName}</td>
														<td>${registration.examStartDate}</td>
														<td>${registration.examTime}</td>
														<td><span class="${registration.statusColor}">${registration.registrationStatus}</span></td>
														<td>
															<div class="dropdown ">
																
															<button class="btn fa fa-ellipsis-v dropdown-toggle"
																data-toggle="dropdown" aria-haspopup="true"
																aria-expanded="false">
																<i class=""></i>
															</button>

													<ul class="dropdown-menu">
														<portlet:renderURL var="viewURL">
 															<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_EXAM_REGISTRATION %>" /> 															
															<portlet:param name="registrationId" value="${registration.id}" />
															<portlet:param name="assignedToMe" value="${registration.assignedToMe}" />
															<portlet:param name="workflowTaskId" value="${registration.workflowTaskId}" />
															<portlet:param name="workflowInstanceId" value="${registration.workflowInstanceId}" />
														</portlet:renderURL>
																	<portlet:actionURL var="WorkflowAssignURL" name="<%=MVCCommandNames.OCT_EXAM_WORKFLOW%>">
																		<portlet:param name="assignedToMe" value="${registration.assignedToMe}" />
																		<portlet:param name="workflowTaskId" value="${registration.workflowTaskId}" />
																		<portlet:param name="workflowInstanceId" value="${registration.workflowInstanceId}" />
																		<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
																		<portlet:param name="registrationId" value="${registration.id}" />
																	</portlet:actionURL>
																	<li><a href="${viewURL}" class="dropdown-item"><i class="fa fa-eye"></i> <liferay-ui:message key="view" /></a></li>
																	  
																</ul>    
															</div>
														</td>
													</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										
										<div class="bottom-backbtn-wrap">
											<a class="btn omsb-btn btn-back" href="${backURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
										</div>
										
										<script>
										var registrationList = $('#registration-list').DataTable({
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
										
										function searchRegistratonList(){
											var registrationExamTittle = $("#examTitleId").val();
											var applicantName = $("#traineeName").val();
											
											registrationList.columns().search('').draw(); // Clear previous search
											registrationList.column(0).search(registrationExamTittle).column(1).search(applicantName).draw();

										}
										
										
										
										</script>
										
										<style>
										#registration-list_wrapper .dataTables_filter {display: none;}
										</style>