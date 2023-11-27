<%-- <%@include file = "../../init.jsp" %> --%>
<div class="omsb-list-filter">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<label><liferay-ui:message key="exam-title" /></label>
					<input type="text" name="Exam Title" id="cancel-examTitle"  class="form-control">
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<label><liferay-ui:message key="trainee-name" /></label>
					<input type="text" name="Trainee name" id="cancel-traineename"  class="form-control">
				</div>
			</div>
		</div>
		<div class="filter-button-wrap">
			<button class="btn omsb-bc-red-button cancel-search"><liferay-ui:message key="search" /></button>
		</div>
	</div>
	<div class="omsb-list-view table-responsive">
		<table class="display omsb-datatables oc-exam-wf-datatable">
			<thead>
				<tr>
					<th><liferay-ui:message key="exam-title" /></th>
					<th><liferay-ui:message key="trainee-name" /></th>
					<th><liferay-ui:message key="exam-date" /></th>
					<th><liferay-ui:message key="registration-start-date" /></th>
					<th><liferay-ui:message key="registration-end-date" /></th>
					<th><liferay-ui:message key="cancellation-status" /></th>
					<th><liferay-ui:message key="actions" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="canVar" items="${cancellationList}">
					<tr>
						<td>${canVar.examTitle }</td>
						<td>${canVar.userName }</td>
						<td>${canVar.examDate }</td>
						<td>${canVar.registrationStartDate }</td>
						<td>${canVar.registrationEndDate }</td>
						<td > <span class="${canVar.statusColor}" >${canVar.cancellationStatusValue }</span></td>
						<td>
							<div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<portlet:renderURL var="viewURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.ADMIN_CANCELLATION_RENDER%>" />
										<portlet:param name="cancellationId" value="${canVar.id}" />
										<portlet:param name="assignedToMe" value="${canVar.assignedToMe}" />
										<portlet:param name="workflowTaskId" value="${canVar.workflowTaskId}" />
										<portlet:param name="workflowInstanceId" value="${canVar.workflowInstanceId}" />
									</portlet:renderURL>
									<a href="${viewURL }"><button class="btn upload_btn" title="view"><img src="<%=themeDisplay.getPathThemeImages() %>/images/svg/red_eye.svg"/ alt=""><liferay-ui:message key="view"/></button></a>
									<portlet:actionURL var="WorkflowAssignURL" name="oct/exam/workflow_action">
										<portlet:param name="assignedToMe" value="${canVar.assignedToMe}" />
										<portlet:param name="workflowTaskId" value="${canVar.workflowTaskId}" />
										<portlet:param name="workflowInstanceId" value="${canVar.workflowInstanceId}" />
										<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
										<portlet:param name="cancellationId" value="${canVar.id}" />
									</portlet:actionURL>
									<c:if test ="${canVar.assignedToMe}" >
										<li><a href="${WorkflowAssignURL}" class="dropdown-item">
										<i class="fa fa-eye"></i><liferay-ui:message key="assign-to-me" /></a></li>
									</c:if>
									<c:if test ="${!canVar.assignedToMe}" >
			 							 <c:forEach var="tName" items="${canVar.transitionNames }">  
						 					<%-- <li><a href="${viewURL}"  class="dropdown-item">
								  			<i class="fa fa-plus-square-o"></i> <liferay-ui:message key="${tName }" /> </a></li> --%>
						 				 </c:forEach>
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
		<a class="btn omsb-btn btn-back" href="#"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
	</div>
