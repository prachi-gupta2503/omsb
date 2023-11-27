<%@ include file="init.jsp"%>

<c:set var = "DELETE_REQUEST" value = "DELETE_REQUEST"/>
<c:set var = "RAISE_REQUEST" value = "RAISE_REQUEST"/>
<c:set var = "EDIT_REQUEST" value = "EDIT_REQUEST"/>
<c:set var = "RAISE_REQUEST_AGAIN" value = "RAISE_REQUEST_AGAIN"/>
<div>
	<jsp:include page="/notification-sliderbar.jsp" />
</div>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="requestedShareRotationTable"
			class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="cohort" /></th>
					<th><liferay-ui:message key="rotation" /></th>
					<th><liferay-ui:message key="no-of-trainees" /></th>
					<th><liferay-ui:message key="approved" /></th>
					<th><liferay-ui:message key="rejected" /></th>
					<th><liferay-ui:message key="request-raised-to" /></th>
					<th><liferay-ui:message key="status" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestedShareRotationList}"
					var="requestedShareRotation">
					<tr>
						<td>${cohortMap.get(requestedShareRotation.programDurationId)}</td>
						<td>${rotationMap.get(requestedShareRotation.rotationId)}</td>
						<td>${requestedShareRotation.noOfTraineesRequested}</td>
						<td>${requestedShareRotation.approvedCount}</td>
						<td>${requestedShareRotation.rejectedCount}</td>
						<td>${raisedRequestToUserMap.get(requestedShareRotation.sharedRotationRequestDetailsId)}</td>
						<td>
							<c:if test="${requestedShareRotation.status == 'Approved'}">
								<span class="omsb-complete-bg">${requestedShareRotation.status}</span>
							</c:if>
							<c:if
								test="${requestedShareRotation.status == 'Approved & Partially Alloted'}">
								<span class="omsb-appeal-bg">${requestedShareRotation.status}</span>
							</c:if>
							<c:if test="${requestedShareRotation.status == 'Rejected'}">
								<span class="omsb-insufficient-bg">${requestedShareRotation.status}</span>
							</c:if>
							<c:if test="${requestedShareRotation.status == 'Pending'}">
								<span class="omsb-reappeal-bg">${requestedShareRotation.status}</span>
							</c:if>
						</td>
						<td class="text-center" style="width: 100px"><portlet:renderURL
								var="editShareRotationRequestURL">
								<portlet:param name="mvcRenderCommandName"
									value="<%=OmsbRaiseShareRotationRequestWebPortletKeys.EDIT_RAISE_SHARE_ROTATION_REQUEST_MVC_RENDER_COMMAND%>" />
								<portlet:param name="sharedRotationRequestId"
									value="${requestedShareRotation.sharedRotationRequestDetailsId}" />
							</portlet:renderURL> <portlet:resourceURL
								id="<%=OmsbRaiseShareRotationRequestWebPortletKeys.GET_SHARE_ROTATION_PROGRAM_USER_DETAIL_MVC_RESOURCE_COMMAND%>"
								var="requestAgainShareRotationRequestURL" />
							<div class="dropdown">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<c:if
										test="${((requestedShareRotation.status == 'Approved & Partially Alloted') || (requestedShareRotation.status == 'Rejected')) && (permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, RAISE_REQUEST_AGAIN))}">
										<li><a href="${requestAgainShareRotationRequestURL}"
											class="dropdown-item request-again"
											data-target="#notifyagainauthorizeduser" data-toggle="modal"
											data-value="${requestedShareRotation.sharedRotationRequestDetailsId}"
											data-programdurationid="${requestedShareRotation.programDurationId}"
											data-estimatenooftraineesrequested="${requestedShareRotation.rejectedCount}">
												<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-docs.svg" alt="<liferay-ui:message key='request-again'/>" /> <liferay-ui:message
													key="request-again" />
										</a></li>
									</c:if>
									<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_REQUEST) && (requestedShareRotation.status == 'Pending')}">
										<li><a href="${editShareRotationRequestURL}"
										class="dropdown-item"> <i class="fa fa-pencil"></i> <liferay-ui:message
												key="edit" />
										</a></li>
									</c:if>
									<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_REQUEST)}">
										<li><a href="javascript:void(0)"
											class="dropdown-item openDeleteModal"
											id="${requestedShareRotation.sharedRotationRequestDetailsId}"
											data-id="${requestedShareRotation.sharedRotationRequestDetailsId}"
											data-target="#deleteModal" data-toggle="modal"> <i
												class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
										</a></li>
									</c:if>
								</ul>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/notify-again-user-modal-popup.jsp" />
<jsp:include page="/delete-modal-popup.jsp" />

<script type="text/javascript">
$('#requestedShareRotationTable').DataTable({
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
	"order": []
});
</script>