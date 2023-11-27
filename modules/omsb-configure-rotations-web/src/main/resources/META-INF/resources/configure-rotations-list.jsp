<%@ include file="/init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="progduration_rotation_tl_blocks_rel_id" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program-structure" /></th>
					<th><liferay-ui:message key="trainee-level" /></th>
					<th><liferay-ui:message key="rotation" /></th>
					<th><liferay-ui:message key="rotation-type" /></th>
					<th><liferay-ui:message key="blocks" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${configureRotationList}" var="configureRotation"> 
				
			                <td> ${configureRotation.getProgramName()} (${configureRotation.getProgramDuration()})</td>
			                <td>${configureRotation.getTraineeLevelName()}</td>
			                <td>${configureRotation.getRotationName()}</td>
			                 <td>${configureRotation.getRotationTypeName()}</td>
			                 <td>${configureRotation.getNoOfBlocks()}</td>
			
			                <td class="text-center" style="width:100px">
			                
			                	<portlet:renderURL var="editConfigureRoration">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbConfigureRotationsWebPortletKeys.EDIT_CONFIGURE_ROTATIONS_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="configureRotationsMasterId" value="${configureRotation.progdurationRotationTlBlocksRelId}" />
								</portlet:renderURL>
								
			                	<portlet:actionURL name="<%= OmsbConfigureRotationsWebPortletKeys.DELETE_CONFIGURE_ROTATIONS_MVC_ACTION_COMMAND %>" var="deleteConfigurerotation">
									<portlet:param name="configureRotationsMasterId" value="${configureRotation.progdurationRotationTlBlocksRelId}" />
								</portlet:actionURL>
								
				            	<div class="dropdown">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
											<ul class="dropdown-menu">
											<li><a href="${editConfigureRoration}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${configureRotation.getProgdurationRotationTlBlocksRelId()}" data-id="${configureRotation.getProgdurationRotationTlBlocksRelId()}" data-target="#myModal" data-toggle="modal" >
													<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
												</a>
											</li>
										</ul>
								</div>
			            	</td>                  
			            </tr>
	        	</c:forEach>
			</tbody>
		</table>
	</div>
</div> 


<jsp:include page="/modal-popup.jsp" />
<script>
$(document).on("click",".openDeleteModal", function(){
	$('#<portlet:namespace/>configureRotationsMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	 $('#progduration_rotation_tl_blocks_rel_id').DataTable();
	$(".modal-backdrop").remove();
});
</script>


