<%@ include file="init.jsp"%>

<%
	long groupId = themeDisplay.getScopeGroupId();	
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	
	String ACCEPT_REQUEST = "ACCEPT_REQUEST";
	String REJECT_REQUEST = "REJECT_REQUEST";
%>

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && !SessionMessages.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span>
					<liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>

<div class="omsb-card">
	<div class="omsb-page-top-info mb-4">
		<div class="pagetitle">
			<liferay-ui:message key="approve-request-shared-rotation" />
		</div>
	</div>

	<div class="omsb-list-view table-responsive">

		<table id="sharedRotationTable" class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program-structure" /></th>
					<th><liferay-ui:message key="rotation" /></th>
					<th><liferay-ui:message key="no-of-trainees-requested" /></th>
					<th><liferay-ui:message key="request-raised-by" /></th>
					<th><liferay-ui:message key="approved-trainees" /></th>
					<th><liferay-ui:message key="rejected-trainees" /></th>
					<th><liferay-ui:message key="status" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sharedRotationsList}" var="sharedRotations">
					<tr>
						<td>${sharedRotations.programStructure}</td>
						<td>${sharedRotations.rotation}</td>
						<td>${sharedRotations.noOfTraineesRequested}</td>
						<td>${sharedRotations.requestRaisedBy}</td>
						<td>${sharedRotations.approvedTrainee}</td>
						<td>${sharedRotations.rejectedTrainee}</td>
						<td><c:if test="${sharedRotations.status == 'Approved'}">
								<span class="omsb-complete-bg">${sharedRotations.status}</span>
							</c:if> <c:if
								test="${sharedRotations.status == 'Approved & Partially Alloted'}">
								<span class="omsb-appeal-bg">${sharedRotations.status}</span>
							</c:if> <c:if test="${sharedRotations.status == 'Rejected'}">
								<span class="omsb-insufficient-bg">${sharedRotations.status}</span>
							</c:if> <c:if test="${sharedRotations.status == 'Pending'}">
								<span class="omsb-reappeal-bg">${sharedRotations.status}</span>
							</c:if></td>
						<td class="text-center" style="width: 100px"><c:if
								test="${sharedRotations.status == 'Pending'}">
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, ACCEPT_REQUEST)%>">
											<li><a href="javascript:void(0)"
												class="dropdown-item openAcceptModel"
												id="${sharedRotations.sharedRotationRequestId}"
												data-id="${sharedRotations.sharedRotationRequestId}"
												data-value="${sharedRotations.noOfTraineesRequested}"
												data-target="#acceptConfirmationModel" data-toggle="modal">
													<i class="fa fa-check-square-o"></i> <liferay-ui:message
														key="accept" />
											</a></li>
										</c:if>
										<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, REJECT_REQUEST)%>">
											<li><a href="javascript:void(0)"
												class="dropdown-item openRejectModel"
												id="${sharedRotations.sharedRotationRequestId}"
												data-id="${sharedRotations.sharedRotationRequestId}"
												data-target="#rejectConfirmationModel" data-toggle="modal">
													<i class="fa fa-trash-o"></i> <liferay-ui:message
														key="reject" />
											</a></li>
										</c:if>
									</ul>
								</div>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/modal-popup-accept.jsp" />
<jsp:include page="/modal-popup-reject.jsp" />
<jsp:include page="/approve-shared-rotations-sidebar.jsp" />

<script>
	$(document).ready(function() {
		$('#sharedRotationTable').DataTable({
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
	});
	
	if(${showModal})
		{
			$('#omsb-notification-sidebar').addClass('open')
		}
	
	$(document).on("click",".openAcceptModel", function(){
		$('.accept-model-data #<portlet:namespace/>sharedRotationRequestId').val($(this).data('id'));
		$('.accept-model-data #<portlet:namespace/>requestedTrainees').val($(this).data('value'));
		$('.accept-model-data #<portlet:namespace/>status').val("Approved");
		$('.accept-model-data #<portlet:namespace/>allowedTrainees').attr('max', $(this).data('value'));
	});
	$(document).on("click",".openRejectModel", function(){
		$('.reject-model-data #<portlet:namespace/>sharedRotationRequestId').val($(this).data('id'));
		$('.reject-model-data #<portlet:namespace/>status').val("Rejected");
	});
	$(".modal-backdrop").remove();
	
	$(document).on("click","#sidebar-close-btn",function(){
		$('#omsb-notification-sidebar').removeClass('open')
	}) 
	
	$(document).on("click","#rejected",function(){
		$('#<portlet:namespace/>allowedTraineesCount').attr('readonly', true);
		$('#<portlet:namespace/>allowedTraineesCount').val(0);
		$('#<portlet:namespace/>allowedTraineesCount').attr('min', 0);
	}) 
	
	$(document).on("click","#approve",function(){
		$('#<portlet:namespace/>allowedTraineesCount').attr('readonly', false);
		$('#<portlet:namespace/>allowedTraineesCount').attr('min', 1);
		$('#<portlet:namespace/>allowedTraineesCount').val(1);
	}) 
	
	
</script>