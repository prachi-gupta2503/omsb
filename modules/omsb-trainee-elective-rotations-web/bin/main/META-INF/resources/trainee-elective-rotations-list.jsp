<%@ include file="/init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="traineeElectiveRotationsTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="id" /></th>
					<th><liferay-ui:message key="program-structure" /></th>
					<th><liferay-ui:message key="trainee-level" /></th>
					<th><liferay-ui:message key="elective-rotation" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${traineeElectiveRotationsList}" var="traineeElectiveRotation"> 
			            <tr>
			            	<td>${traineeElectiveRotation.traineePdTlErDetailsId}</td>
			                <td>${traineeElectiveRotation.programStructure}</td>
			                <td>${traineeElectiveRotation.traineeLevel}</td>
			                <td>${traineeElectiveRotation.electiveRotation}</td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editTraineeElectiveRotations">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbTraineeElectiveRotationsWebPortletKeys.EDIT_TRAINEE_ELECTIVE_ROTATIONS_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="traineePdTlErDetailsId" value="${traineeElectiveRotation.traineePdTlErDetailsId}" />
								</portlet:renderURL>
								
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editTraineeElectiveRotations}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${traineeElectiveRotation.traineePdTlErDetailsId}" 
													data-id="${traineeElectiveRotation.traineePdTlErDetailsId}" data-target="#deleteModal" data-toggle="modal" ><i
													class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
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
	$('#<portlet:namespace/>traineePdTlErDetailsId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#traineeElectiveRotationsTable').DataTable({
		"sDom": 'Rfrtlip'
	});
});
$(".modal-backdrop").remove();
</script>