<%@ include file="init.jsp" %>
<jsp:include page="/modal-popup.jsp" />

<liferay-ui:error key="rotationTypeNameError" message="rotation-type-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="rotationTypeTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="rotation-type" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="create-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rotationTypeMasterList}" var="rotationType"> 
						<%
	    					RotationTypeMaster rotationTypeMaster = (RotationTypeMaster)pageContext.getAttribute(OmsbRotationTypeWebPortletKeys.ROTATION_TYPE);
						%>
			            <tr>
			                <td>${rotationType.getRotationTypeName(locale)}</td>
			            	<td><%= UserLocalServiceUtil.getUser(rotationTypeMaster.getModifiedBy()).getFullName() %></td>
			                <td>${sdf.format(rotationType.getCreateDate())}</td>
			                <td>${sdf.format(rotationType.getModifiedDate())}</td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editRotationType">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbRotationTypeWebPortletKeys.EDIT_ROTATION_TYPE_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="rotationTypeMasterId" value="${rotationType.rotationTypeMasterId}" />
								</portlet:renderURL>
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editRotationType}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${rotationType.rotationTypeMasterId}" data-id="${rotationType.rotationTypeMasterId}" data-target="#confirmationModel" data-toggle="modal">
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
<script>
$(document).ready(function(){
	$('#rotationTypeTable').DataTable({
		"sDom": 'Rfrtlip',
		"order": [[3,"desc"]]
	});
});
$(document).on("click",".openDeleteModal", function(){
	$('#<portlet:namespace/>rotationTypeMasterId').val($(this).data('id'));
});
$(".modal-backdrop").remove();
</script>