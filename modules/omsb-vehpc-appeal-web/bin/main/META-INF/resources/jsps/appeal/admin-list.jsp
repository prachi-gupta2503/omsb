<%@ include file="../../init.jsp"%>

<table id="admin-list" class="display omsb-datatables appeal-list" >
				<thead>
					<tr>
						<th><liferay-ui:message key="certificate" /></th>
						<th><liferay-ui:message key="employer" /></th>
						<th><liferay-ui:message key="employee" /></th>
						<th><liferay-ui:message key="equivalency-level" /></th>
						<th><liferay-ui:message key="created-on" /></th>
						<th><liferay-ui:message key="appeal-status" /></th>
						<th><liferay-ui:message key="equivalency-certificate" /></th>
						<th><liferay-ui:message key="action" /></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${adminSearchDtos}" var="adminSearchDtos">
						<liferay-portlet:renderURL var="viewEmployeeURL">
							<liferay-portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.VIEW_APPEAL_ALL%>" />
							<portlet:param name="equivalencyDecisionLevelId" value="${adminSearchDtos.equivalencyDecisionId}" />
							<portlet:param name="assignedToMe" value="${adminSearchDtos.assignedToMe}" />
							<portlet:param name="workflowTaskId" value="${adminSearchDtos.workflowTaskId}" />
							<portlet:param name="workflowInstanceId" value="${adminSearchDtos.workflowInstanceId}" />
							<portlet:param name="<%=Constants.CMD %>" value="<%=AppealConstants.CMD_ASSIGN_TO_ME %>" />
							<portlet:param name="eqAppealId" value="${adminSearchDtos.id}" />		
						</liferay-portlet:renderURL>
						<portlet:actionURL var="WorkflowAssignURL" name="/appeal/workflow_action">
							<portlet:param name="equivalencyDecisionLevelId" value="${adminSearchDtos.equivalencyDecisionId}" />
							<portlet:param name="assignedToMe" value="${adminSearchDtos.assignedToMe}" />
							<portlet:param name="workflowTaskId" value="${adminSearchDtos.workflowTaskId}" />
							<portlet:param name="workflowInstanceId" value="${adminSearchDtos.workflowInstanceId}" />
							<portlet:param name="<%=Constants.CMD %>" value="<%=AppealConstants.CMD_ASSIGN_TO_ME %>" />
							<portlet:param name="eqAppealId" value="${adminSearchDtos.id}" />
						</portlet:actionURL>
						<tr>
							<td>${adminSearchDtos.fileName}</td>
							<td>${adminSearchDtos.employer}</td>
							<td>${adminSearchDtos.employee}</td>
							<td>${adminSearchDtos.equivalencyLevel}</td>
							<td>${adminSearchDtos.createdDate}</td>
							<c:choose>
									<c:when test="${ not empty adminSearchDtos.status}">
									<td >
									<c:choose>
										<c:when test="${hasVehpcCAdminRole && (adminSearchDtos.status eq 'Created' || adminSearchDtos.status eq 'Evaluated')}">
											<span class="${appealStatusColur.get('Received')}"><liferay-ui:message key="received" /></span>
										</c:when>
										<c:when test="${hasVehpcCAdminRole && !(adminSearchDtos.status eq 'Completed' || adminSearchDtos.status eq 'Rejected' || searchDto.status eq 'Insufficient')}">
											<span class="${appealStatusColur.get('In Progress')}"><liferay-ui:message key="in-progress" /></span>
										</c:when>
										<c:when test="${hasExecutePresidentRole && adminSearchDtos.status eq 'Raised'}">
											<span class="${appealStatusColur.get('Received')}"><liferay-ui:message key="received" /></span>
										</c:when>
										<c:when test="${hasExecutePresidentRole && !(adminSearchDtos.status eq 'Completed' || adminSearchDtos.status eq 'Rejected' || searchDto.status eq 'Insufficient')}">
											<span class="${appealStatusColur.get('In Progress')}"><liferay-ui:message key="in-progress" /></span>
										</c:when>
										<c:when test="${hasVehpcCommitteeRole && adminSearchDtos.status eq 'Initiated'}">
											<span class="${appealStatusColur.get('Received')}"><liferay-ui:message key="received" /></span>
										</c:when>
										<c:when test="${hasVehpcCommitteeRole && !(adminSearchDtos.status eq 'Completed' || adminSearchDtos.status eq 'Rejected' || searchDto.status eq 'Insufficient')}">
											<span class="${appealStatusColur.get('In Progress')}"><liferay-ui:message key="in-progress" /></span>
										</c:when>
										<c:when test="${(hasVehpcEmployerRole || hasVehpcEmployeeRole) && !(adminSearchDtos.status eq 'Completed' || adminSearchDtos.status eq 'Rejected' || searchDto.status eq 'Insufficient')}">
											<span class="${appealStatusColur.get('In Progress')}"><liferay-ui:message key="in-progress" /></span>
										</c:when>
										<c:otherwise>
											<span class="${appealStatusColur.get(adminSearchDtos.status)}">${adminSearchDtos.status}</span>
										</c:otherwise>
									</c:choose>
									</td>
									</c:when>
								<c:otherwise>
									<td >
										<span class="${appealStatusColur.get('NA')}"><liferay-ui:message key="na" /></span>
									</td>
								</c:otherwise>
							</c:choose>
							
							<td>	
								<c:choose>
									<c:when test="${ not empty adminSearchDtos.certificateURL}" >
										<a href="${adminSearchDtos.certificateURL}" class="btn btn-label view-download" download>
										<liferay-ui:message key="equivalency-certificate" /></a>
									</c:when>
									<c:otherwise>
										<liferay-ui:message key="na" />
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li>
											<a href="${viewEmployeeURL}" class="dropdown-item"><i class="fa fa-eye"></i> <liferay-ui:message key="view" /></a>
										</li>
										<%-- <c:if test ="${adminSearchDtos.assignedToMe}" >
											<li><a href="${WorkflowAssignURL}" class="dropdown-item" >
												<img
								src="${themeDisplay.getPathThemeImages()}/svg/Initiate_icon.svg"><liferay-ui:message key="assign-to-me" /></a></li>
										</c:if> --%>
										
										<%-- <c:if test ="${!adminSearchDtos.assignedToMe}" > 
											<c:forEach var="tName" items="${adminSearchDtos.transitionNames }">
												<c:if test="${tName ne 'complete'}"> --%>
													<portlet:actionURL var="completeWorkflowURL" name="/appeal/workflow_action">
													<%--	<portlet:param name="equivalencyDecisionId" value="${adminSearchDtos.equivalencyDecisionId}" />
														 
														 <portlet:param name="assignedToMe" value="${adminSearchDtos.assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${adminSearchDtos.workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${adminSearchDtos.workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="eqAppealId" value="${adminSearchDtos.id}" />  --%>
													</portlet:actionURL>
													
													
													<%-- <c:if test="${hasVehpcCAdminRole && (tName eq 'Raise' || tName eq 'Insufficient') and adminSearchDtos.status ne 'Rejected' and adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status ne 'Raised' and adminSearchDtos.status eq 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated'}">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName } 
														data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}" 
														data-decisionId-id="${adminSearchDtos.equivalencyDecisionId}" ><i
															class="fa fa-eye"></i> ${tName}</a></li>
													</c:if>
													<c:if test="${hasExecutePresidentRole && (tName eq 'Initiate' || tName eq 'Reject') and adminSearchDtos.status ne 'Rejected' and  adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status eq 'Raised' and adminSearchDtos.status ne 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated' }">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName }
														data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}" 
														data-decisionId-id="${adminSearchDtos.equivalencyDecisionId}"
														><i
															class="fa fa-eye"></i> ${tName}</a></li>
													</c:if> --%>
													
													<%-- <c:if test="${hasVehpcCAdminRole && tName eq 'Raise'  and adminSearchDtos.status ne 'Rejected' and adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status ne 'Raised' and adminSearchDtos.status eq 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated'}">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName } 
														data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}" 
														data-decisionId-id="${adminSearchDtos.equivalencyDecisionId}" ><img
														src="${themeDisplay.getPathThemeImages()}/svg/raise.svg"> ${tName}</a></li>
													</c:if>
													
													
													<c:if test="${hasVehpcCAdminRole &&  tName eq 'Insufficient' and adminSearchDtos.status ne 'Rejected' and adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status ne 'Raised' and adminSearchDtos.status eq 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated'}">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName } 
														data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}" 
														data-decisionId-id="${adminSearchDtos.equivalencyDecisionId}" ><img
														src="${themeDisplay.getPathThemeImages()}/svg/mark_Insufficient_icon.svg"> ${tName}</a></li>
													</c:if>
													<c:if test="${hasExecutePresidentRole && tName eq 'Initiate' and adminSearchDtos.status ne 'Rejected' and  adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status eq 'Raised' and adminSearchDtos.status ne 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated' }">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName }
														data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}" 
														data-decisionId-id="${adminSearchDtos.equivalencyDecisionId}"
														><img
															src="${themeDisplay.getPathThemeImages()}/svg/Initiate_icon.svg"> ${tName}</a></li>
													</c:if>
													
													<c:if test="${hasExecutePresidentRole &&  tName eq 'Reject' and adminSearchDtos.status ne 'Rejected' and  adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status eq 'Raised' and adminSearchDtos.status ne 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated' }">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName }
														data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}" 
														data-decisionId-id="${adminSearchDtos.equivalencyDecisionId}"
														><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-reject.svg"> ${tName}</a></li>
													</c:if>
												</c:if>
													<c:if test="${hasVehpcCommitteeRole && (tName eq 'Decline' && tName ne 'complete')and adminSearchDtos.status ne 'Rejected' and  adminSearchDtos.status eq 'Initiated' and adminSearchDtos.status ne 'Raised' and adminSearchDtos.status ne 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated'}">
														<li><a href="#" class="dropdown-item custom-model" data-toggle="modal" data-target="#popup-comments" 
														data-tr-name=${tName } data-appeal-id="${adminSearchDtos.id}" data-task-id="${adminSearchDtos.workflowTaskId}" 
														data-instance-id="${adminSearchDtos.workflowInstanceId}"  data-assign-to-me="${adminSearchDtos.assignedToMe}">
														<img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-reject.svg"> <liferay-ui:message key="reject" /></a></li>
												</c:if> 
												<c:if test="${ hasVehpcCommitteeRole && (tName ne 'complete' && tName ne 'Decline')and adminSearchDtos.status ne 'Rejected' and  adminSearchDtos.status eq 'Initiated' and adminSearchDtos.status ne 'Raised' and adminSearchDtos.status ne 'Created' and adminSearchDtos.status ne 'Completed' and adminSearchDtos.status ne 'Evaluated'}">
													<portlet:renderURL var="editAdminResponseURL" >
														<portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.EDIT_APPEAL %>" />
														<portlet:param name="equivalencyDecisionLevelId" value="${adminSearchDtos.equivalencyDecisionId}" />
														<portlet:param name="assignedToMe" value="${adminSearchDtos.assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${adminSearchDtos.workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${adminSearchDtos.workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="action" value="adminJSP" />
														<portlet:param name="transitionName" value="${tName}" />
														<portlet:param name="eqAppealId" value="${adminSearchDtos.id}" />
													</portlet:renderURL>
													<li><a href="${editAdminResponseURL }" class="dropdown-item" ><img
															src="${themeDisplay.getPathThemeImages()}/svg/evaluate.svg"> ${tName}</a></li>
												</c:if>
												<c:if test="${tName eq 'complete' && hasVehpcCAdminRole and adminSearchDtos.status eq 'Evaluated' and adminSearchDtos.status ne 'Rejected' and  adminSearchDtos.status ne 'Initiated' and adminSearchDtos.status ne 'Raised' and adminSearchDtos.status ne 'Created' and adminSearchDtos.status ne 'Completed'}">
													<portlet:renderURL var="editAdminResponseURL" >
														<portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.EDIT_APPEAL %>" />
														<portlet:param name="equivalencyDecisionLevelId" value="${adminSearchDtos.equivalencyDecisionId}" />
														<portlet:param name="assignedToMe" value="${adminSearchDtos.assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${adminSearchDtos.workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${adminSearchDtos.workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="action" value="adminJSP" />
														<portlet:param name="transitionName" value="${tName}" />
														<portlet:param name="eqAppealId" value="${adminSearchDtos.id}" />
													</portlet:renderURL>
													<li><a href="${editAdminResponseURL }" class="dropdown-item" ><img
															src="${themeDisplay.getPathThemeImages()}/svg/completed.svg"> ${tName}</a></li>
												</c:if>
											 </c:forEach>		
										</c:if> --%>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

<!--  POPUP Modal for comments -->
							<div class="modal fade omsb-modal" id="popup-comments"
								tabindex="-1" role="dialog"
								aria-labelledby="markInsufficientModalTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLongTitle">
												<liferay-ui:message key="comments" />
											</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<aui:form action="${completeWorkflowURL}" method="post" name="wf_form">
											<aui:input name="transitionName" type="hidden"></aui:input>
											<aui:input name="workflowInstanceId" type="hidden"></aui:input>
											<aui:input name="eqAppealId" type="hidden"></aui:input>
											<aui:input name="workflowTaskId" type="hidden"></aui:input>
											<aui:input name="assignedToMe" type="hidden"></aui:input>
											<aui:input name="cmd" type= "hidden" value="<%= AppealConstants.CMD_COMPLETE_WORKFLOW%>"></aui:input>
											<div class="modal-body">
												<div class="row">
													<div class="col-md-12">
													
													<textarea onkeyup="countChar(this)" class="comments" required="required"
																name="<portlet:namespace />comments" rows="5" id="comments">
														</textarea>
														<p id="comment-error" class="error-message text-danger d-none">
															<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
														</p>
													</div>						
													
												</div>
											</div>
											<div class="modal-footer">
												<button type="submit" class="btn btn-default omsb-bc-red-button btn-sm tr-name-btn "  value=""></button>
										      	<button type="button" class="btn btn-default omsb-bg-red-button" data-dismiss="modal" ><liferay-ui:message key="close"></liferay-ui:message> </button>
											</div>
										</aui:form>
									</div>
								</div>
							</div>

<!--  POPUP Modal for comments -->


