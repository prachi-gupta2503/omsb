<%@ include file="./init.jsp"%>
<c:choose>
	<c:when test="${!empty equivalencyRequest}">
		<div class="omsb-list-view table-responsive" id="equivalencyHomeTable">
			<table class="display omsb-datatables" id="equivalency-list">
				<thead>
					<tr>
						<c:if test="${not isEmployer}">
							<th><liferay-ui:message key="employer" /></th>
						</c:if>
						<th><liferay-ui:message key="employee" /></th>
						<th><liferay-ui:message key="status" /></th>
						<th><liferay-ui:message key="created-on" /></th>
						<th><liferay-ui:message key="action" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${equivalencyRequest}" var="equivalencyRequest">
						<portlet:renderURL var="viewEquivalencyURL">
							<portlet:param name="mvcRenderCommandName"
								value="<%=MVCCommandNames.EQUIVALENCY_VIEW%>" />
							<portlet:param name="equivalencyRequestId"
								value="${equivalencyRequest.getEquivalencyRequestId()}" />
						</portlet:renderURL>
						<portlet:renderURL var="viewAppealURL">
							<portlet:param name="mvcRenderCommandName"
								value="<%=AppealConstants.VIEW_APPEAL_ALL%>" />
							<portlet:param name="equivalencyRequestId"
								value="${equivalencyRequest.getEquivalencyRequestId()}" />
								
								<%-- <portlet:param name="assignedToMe" value="${adminSearchDtos[status.index].assignedToMe}" />
								<portlet:param name="workflowTaskId" value="${adminSearchDtos[status.index].workflowTaskId}" />
								<portlet:param name="workflowInstanceId" value="${adminSearchDtos[status.index].workflowInstanceId}" />
								<portlet:param name="<%=Constants.CMD %>" value="<%=AppealConstants.CMD_ASSIGN_TO_ME %>" />
								<portlet:param name="eqAppealId" value="${adminSearchDtos[status.index].id}" /> --%>
			
						</portlet:renderURL>
						<c:choose>
							<c:when test="${isEmployer}">
								<portlet:renderURL var="editEquivalencyURL">
									<portlet:param name="mvcRenderCommandName"
										value="<%=MVCCommandNames.EQUIVALENCY_EDIT%>" />
									<portlet:param name="equivalencyRequestId"
										value="${equivalencyRequest.getEquivalencyRequestId()}" />
									<portlet:param name="transitionNames"
										value="${equivalencyRequest.getTransitions()}" />
								</portlet:renderURL>
							</c:when>
							<c:otherwise>
								<portlet:renderURL var="equivalencyEquateURL">
									<portlet:param name="mvcRenderCommandName"
										value="<%=MVCCommandNames.EQUIVALENCY_EDIT_LEVEL%>" />
									<portlet:param name="equivalencyRequestId"
										value="${equivalencyRequest.getEquivalencyRequestId()}" />
									<portlet:param name="transitionNames"
										value="${equivalencyRequest.getTransitions()}" />
								</portlet:renderURL>
							</c:otherwise>
						</c:choose>

						<tr>
							<c:if test="${not isEmployer}">
								<td>${equivalencyRequest.employer}</td>
							</c:if>
							<td>${equivalencyRequest.employee}</td>
							<td><span
								class="${equivalencyRequest.getStatusColorClass()}">${equivalencyRequest.getStatus()}</span></td>
							<td>${equivalencyRequest.createdOn}</td>
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="${viewEquivalencyURL}" class="dropdown-item"><img
												src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
												<liferay-ui:message key="view" /></a></li>
										<c:if test="${equivalencyRequest.appealId > 0 }">
											<li><a href="${viewAppealURL}"
												class="dropdown-item"><img
													src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg"
													alt=""> <liferay-ui:message key="view-appeal" /></a></li>
											</c:if>
										<%@ include file="./equivalency-button-dropdown.jspf"%>
									</ul>

								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-records-found" />
	</c:otherwise>
</c:choose>
