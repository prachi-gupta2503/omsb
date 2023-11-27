<%@ include file="init.jsp" %>
<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="trainingSitesTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="training-site-code" /></th>
					<th><liferay-ui:message key="training-site-name" /></th>
					<th><liferay-ui:message key="training-site-status" /></th>
					<th><liferay-ui:message key="training-site-address" /></th>
					<th><liferay-ui:message key="action" /></th>
					
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="otherTrainingSite" items="${otherTrainingSitesList}">
				<tr>
					<td>${otherTrainingSite.getTrainingSiteCode(locale)}</td>
					<td>${otherTrainingSite.getTrainingSiteName(locale)}</td>
					<td>
						<c:choose>
						    <c:when test="${otherTrainingSite.trainingSiteStatus}">
						        <liferay-ui:message key="active" />
						    </c:when>
						    <c:otherwise>
						        <liferay-ui:message key="inactive" />
						    </c:otherwise>
						</c:choose>
					</td>
					<td>${otherTrainingSite.getTrainingSiteAddress(locale)}</td>
					<td class="text-center" style="width: 100px">
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_TRAINING_SITE) || permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_TRAINING_SITE)}">
							<div class="dropdown ">
							<button class="btn fa fa-ellipsis-v dropdown-toggle"
								type="button" data-toggle="dropdown" aria-expanded="false">
								<i class=""></i>
							</button>
								<portlet:renderURL var="editTrainingSite">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_EDIT_MVC_RENDER_COMMAND%>" />
								    <portlet:param name="progDurationId" value="${progDurationId}" /> 
								    <portlet:param name="trainingSiteMasterId" value="${otherTrainingSite.trainingSiteMasterId}" />
								</portlet:renderURL>
								<portlet:actionURL name="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DELETE_MVC_ACTION_COMMAND%>" var="deleteProgramTypeActionURL">
									<portlet:param name="trainingSiteMasterId" value="${otherTrainingSite.trainingSiteMasterId}" />
									<portlet:param name="progDurationId" value="${progDurationId}" />
									<portlet:param name="redirect" value="${currentURL}"/>
								</portlet:actionURL>
							<ul class="dropdown-menu">
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_UPDATE_TRAINING_SITE)}">
								<li><a href="${editTrainingSite}"
									class="dropdown-item"><i class="fa fa-pencil"></i><liferay-ui:message key="edit" /></a></li>
							</c:if>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_DELETE_TRAINING_SITE)}">
								<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${otherTrainingSite.trainingSiteMasterId}" data-id="${otherTrainingSite.trainingSiteMasterId}" data-target="#myModal" data-toggle="modal"><i 
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
	$('#<portlet:namespace/>trainingSiteMasterId').val($(this).data('id'));
	$('#<portlet:namespace/>progDurationId').val(${progDurationId});
});
$(document).ready(function(){
    $('#trainingSitesTable').DataTable({
	    "sDom": 'Rfrtlip',
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
    $(".modal-backdrop").remove();
});
</script>