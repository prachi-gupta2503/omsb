<%@ include file="init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="rotationTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="rotation-short-name" /></th>
					<th><liferay-ui:message key="rotation-name" /></th>
					<th><liferay-ui:message key="rotation-code" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="actions" /></th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="rotation" items="${otherRotationList}">
				<tr>
					<td>${rotation.getRotationShortName(locale)}</td>
					<td>${rotation.getRotationName(locale)}</td>
					<td>${rotation.getRotationCode(locale)}</td>
					<td><fmt:formatDate pattern= "<%= OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY %>" value= "${rotation.createDate}" /></td>
					<td><fmt:formatDate pattern= "<%= OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY %>" value= "${rotation.modifiedDate}" /></td>
					<td class="text-center" style="width: 100px">
						
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_ROTATION) || permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_ROTATION)}">
							<div class="dropdown ">
							<button class="btn fa fa-ellipsis-v dropdown-toggle"
								type="button" data-toggle="dropdown" aria-expanded="false">
								<i class=""></i>
							</button>
								<portlet:renderURL var="editRotation">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbRotationsWebPortletKeys.ROTATION_EDIT_MVC_RENDER_COMMAND%>" />
								    <portlet:param name="progDurationId" value="${progDurationId}" />
								    <portlet:param name="rotationMasterId" value="${rotation.rotationMasterId}" />
								</portlet:renderURL>
								<portlet:actionURL name="<%=OmsbRotationsWebPortletKeys.ROTATION_DELETE_MVC_ACTION_COMMAND%>" var="deleteRotation">
									<portlet:param name="rotationMasterId" value="${rotation.rotationMasterId}" />
									<portlet:param name="progDurationId" value="${progDurationId}" />
									<portlet:param name="redirect" value="${currentURL}"/>
								</portlet:actionURL>
							<ul class="dropdown-menu">
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_ROTATION)}">
								<li><a href="${editRotation}"
									class="dropdown-item"><i class="fa fa-pencil"></i><liferay-ui:message key="edit" /></a></li>
									</c:if>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_ROTATION)}">
								<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${rotation.rotationMasterId}" data-id="${rotation.rotationMasterId}" data-target="#myModal" data-toggle="modal"><i
									class="fa fa-trash-o"></i> <liferay-ui:message key="delete" /> </a></li>
							</c:if>
							</ul>
							</div>
							</c:if>
					</td>
				</tr>
			   </c:forEach>
			</tbody>
		</table>
	</div>
	<div class="bottom-backbtn-wrap">
		<a class="btn omsb-btn btn-back" href="${programListRenderUrl}" title="Back"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
	</div>
</div>
<jsp:include page="/modal-popup.jsp" />
<script>
$(document).on("click",".openDeleteModal", function(){
	$('#<portlet:namespace/>rotationMasterId').val($(this).data('id'));
	$('#<portlet:namespace/>progDurationId').val(${progDurationId});
});
$(document).ready(function(){
    $('#rotationTable').DataTable({
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
		"order": [[4,"desc"]]
	 });
    $(".modal-backdrop").remove();
});
</script>