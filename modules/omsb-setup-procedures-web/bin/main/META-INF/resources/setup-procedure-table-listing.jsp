<%@ include file="init.jsp"%>
<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="setup" class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program" /></th>
					<th><liferay-ui:message key="procedure-group" /></th>
					<th><liferay-ui:message key="procedures" /></th>
					<th><liferay-ui:message key="cpt-code" /></th>
					<th><liferay-ui:message key="rotation" /></th>
					<th><liferay-ui:message key="minimum-number-of-procedures" /></th>
					<th><liferay-ui:message key="trainee-level" /></th>
					<th><liferay-ui:message key="trainee-level-minimum-number-of-procedures" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${setUpProceduresList}" var="setUpProcedureList"> 
			            <tr>
			            	<td>${programNameCohotMapping.get(setUpProcedureList.getProgramDurationId())}</td>
			                <td>${not empty setUpProcedureList.getProcedureGroup() ? setUpProcedureList.getProcedureGroup() : '-'}</td> 
			                <td>${setUpProcedureList.getProcedures()}</td>
			                <td>${not empty setUpProcedureList.getCptCode() ? setUpProcedureList.getCptCode() : '-'}</td>
			                <td>${setUpProcedureList.getRotation()}</td>
			                <td>
				                ${setUpProcedureList.getMinimumProcedure() != 0 ? setUpProcedureList.getMinimumProcedure() : '-'}
			                </td>
			                <td>${not empty setUpProcedureList.getTraineeLevel() ? setUpProcedureList.getTraineeLevel() : '-'}</td>
			                <td>
			                	${setUpProcedureList.getTraineeLevelMinimumProcedure() != 0 ? setUpProcedureList.getTraineeLevelMinimumProcedure() : '-'}
			                </td>
			                <td class="text-center" style="width:100px">
				            	<div class="dropdown ">
			            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<portlet:renderURL var="editProcedure">
									    <portlet:param name="mvcRenderCommandName" value="<%=OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_SETUP_PROCEDURE_MVC_COMMAND_NAME%>" />
									    <portlet:param name="progdurationRotationTlPgProcedurePtRelId" value="${setUpProcedureList.progdurationRotationTlPgProcedurePtRelId}" />
									</portlet:renderURL>
									<portlet:actionURL name="<%=OmsbSetupProceduresWebPortletKeys.DELETE_SETUP_PROCEDURE_MVC_COMMAND_NAME%>" var="deleteProcedure">
										<portlet:param name="progdurationRotationTlPgProcedurePtRelId" value="${setUpProcedureList.progdurationRotationTlPgProcedurePtRelId}" />
									</portlet:actionURL>
									<ul class="dropdown-menu">
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_CONFIGURED_PROCEDURE)}">
											<li><a href="${editProcedure}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
										</c:if>
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_CONFIGURED_PROCEDURE)}">
											<li>
												<a href="javascript:void(0)"
													class="dropdown-item openSetupProcedureDeleteModal"
													data-parameter="<%=OmsbSetupProceduresWebPortletKeys.PROCEDURES%>"
													data-id="${setUpProcedureList.progdurationRotationTlPgProcedurePtRelId}"
													data-target="#deleteSetupProcedureModal" data-toggle="modal">
														<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
												</a>
											</li>
										</c:if>
									</ul>
								</div>
			            	</td>                  
			            </tr>
	        	</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script>
$(document).on("click",".openSetupProcedureDeleteModal", function(){
	$('.setup-modal-body #<portlet:namespace/>progdurationRotationTlPgProcedurePtRelId').val($(this).data('id'));
	$('.setup-modal-body #<portlet:namespace/>masterValue').val($(this).data('parameter'));
});
$(document).ready(function(){
	$('#setup').DataTable({
	    "sDom": 'Rfrtlip',
	    "order":[],
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