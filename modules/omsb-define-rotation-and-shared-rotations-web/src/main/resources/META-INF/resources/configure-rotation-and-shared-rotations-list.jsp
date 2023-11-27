<%@page import="gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys"%>
<%@ include file="/init.jsp"%>

<div class="omsb-list-view table-responsive">
	<table class="display omsb-datatables" id="cohortListTable">
	<caption></caption>
		<thead>
			<tr>
				<th><liferay-ui:message key="cohort" /></th>
				<th><liferay-ui:message key="training-site" /></th>
				<th><liferay-ui:message key="rotation" /></th>
				<th><liferay-ui:message key="is-shared-rotation" /></th>
				<th><liferay-ui:message key="slots" /></th>
				<th><liferay-ui:message key="shared-rotation-owning-program" /></th>
				<th><liferay-ui:message key="action" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${defineRotationAndSharedRotationsList}"
				var="defineRotationAndSharedRotations">
				<tr>
					<td>${defineRotationAndSharedRotations.cohort}</td>
					<td>${defineRotationAndSharedRotations.trainingSite}</td>
					<td>${defineRotationAndSharedRotations.rotation}</td>
					<td>${defineRotationAndSharedRotations.isSharedRotation}</td>
					<td>${defineRotationAndSharedRotations.slotes}</td>
					<td>${defineRotationAndSharedRotations.sharedRotationOwningProgram}</td>
					<td><portlet:renderURL
							var="editDefineRotationAndSharedRotations">
							<portlet:param name="mvcRenderCommandName" value="<%=OmsbDefineRotationAndSharedRotationsWebPortletKeys.EDIT_DRASR_MVC_RENDER_COMMAND%>" />
							<portlet:param name="progdurationRotationTrainingsitesRelId"
								value="${defineRotationAndSharedRotations.progdurationRotationTsRelId}" />
						</portlet:renderURL>

						<div class="dropdown ">
							<button class="btn fa fa-ellipsis-v dropdown-toggle"
								type="button" data-bs-toggle="dropdown" aria-expanded="false">
								<i class=""></i>
							</button>
							<ul class="dropdown-menu">
								<li><a href="${editDefineRotationAndSharedRotations}"
									class="dropdown-item"><i class="fa fa-pencil"></i> <liferay-ui:message
											key="edit" /> </a></li>
								<li><a href="javascript:void(0)"
									class="dropdown-item openDeleteModal"
									id="${defineRotationAndSharedRotations.progdurationRotationTsRelId}"
									data-id="${defineRotationAndSharedRotations.progdurationRotationTsRelId}"
									data-target="#deleteModal" data-toggle="modal"><i
										class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
								</a></li>
							</ul>
						</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="/modal-popup.jsp" />
<script>
	$(document).ready(function() {
		 $('#cohortListTable').DataTable({
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
		    	]
		 });
	});
	$(document).on("click",".openDeleteModal", function(){
		$('#<portlet:namespace/>progdurationRotationTrainingsitesRelId').val($(this).data('id'));
	});
	$(".modal-backdrop").remove();
</script>
