<div class="omsb-list-filter">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<label><liferay-ui:message key="exam-title" /></label>
					<input type="text" name="Exam Title" id="reschedule-examTitle"  class="form-control">
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<label><liferay-ui:message key="trainee-name" /></label>
					<input type="text" name="Trainee name" id="reschedule-traineename"  class="form-control">
				</div>
			</div>
		</div>
		<div class="filter-button-wrap">
			<button class="btn omsb-bc-red-button reschedule-search">Search</button>
		</div>
	</div>
	<div class="omsb-list-view table-responsive">
		<table class="display omsb-datatables oc-exam-wf-res-datatable">
			<thead>
				<tr>
					<th><liferay-ui:message key="exam-title" /></th>
					<th><liferay-ui:message key="trainee-name" /></th>
					<th><liferay-ui:message key="exam-date" /></th>
					<th><liferay-ui:message key="registration-start-date" /></th>
					<th><liferay-ui:message key="registration-end-date" /></th>
					<th><liferay-ui:message key="reschedule-status" /></th>
					<th><liferay-ui:message key="actions" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="resVar" items="${rescheduleDetailList}">
					<tr>
						<td>${resVar.examTitle }</td>
							<td>${resVar.userName }</td>
							<td>${resVar.examDate }</td>
							<td>${resVar.registrationStartDate }</td>
							<td>${resVar.registrationEndDate }</td>
							<td > <span class="${resVar.statusColor}" >${resVar.cancellationStatusValue }</span></td>
							<td>
							<div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<portlet:renderURL var="viewURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.ADMIN_RESCHEDULE_RENDER%>" />
										<portlet:param name="rescheduleId" value="${resVar.id}" />
										<portlet:param name="assignedToMe" value="${resVar.assignedToMe}" />
										<portlet:param name="workflowTaskId" value="${resVar.workflowTaskId}" />
										<portlet:param name="workflowInstanceId" value="${resVar.workflowInstanceId}" />
									</portlet:renderURL>
									<a href="${viewURL }"><button class="btn upload_btn" title="view"><img src="<%=themeDisplay.getPathThemeImages() %>/images/svg/red_eye.svg"/ alt=""><liferay-ui:message key="view"/></button></a>
									<portlet:actionURL var="WorkflowAssignURL" name="oct/exam/workflow_action">
										<portlet:param name="assignedToMe" value="${resVar.assignedToMe}" />
										<portlet:param name="workflowTaskId" value="${resVar.workflowTaskId}" />
										<portlet:param name="workflowInstanceId" value="${resVar.workflowInstanceId}" />
										<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
										<portlet:param name="rescheduleId" value="${resVar.id}" />
									</portlet:actionURL>
									<c:if test ="${resVar.assignedToMe}" >
										<li><a href="${WorkflowAssignURL}" class="dropdown-item">
										<i class="fa fa-eye"></i><liferay-ui:message key="assign-to-me" /></a></li>
									</c:if>
									<c:if test ="${!resVar.assignedToMe}" >
			 							 <c:forEach var="tName" items="${resVar.transitionNames }">  
						 					<li><a href="${viewURL}"  class="dropdown-item">
								  			<i class="fa fa-plus-square-o"></i> <liferay-ui:message key="${tName }" /> </a></li>
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
		<a class="btn omsb-btn btn-back" href="#"><i class="fi fi-sr-arrow-left"></i>Back</a>
	</div>