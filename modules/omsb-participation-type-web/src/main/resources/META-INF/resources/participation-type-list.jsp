<%@ include file="init.jsp" %>

<liferay-ui:error key="participationTypeNameError" message="participation-type-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="participationTypeTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="participation-type" /></th>
					<th><liferay-ui:message key="create-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${participationTypeMasterList}" var="participationType"> 
						<%
	    					ParticipationTypeMaster participationTypeMaster = (ParticipationTypeMaster)pageContext.getAttribute(OmsbParticipationTypeWebPortletKeys.PARTICIPATION_TYPE);
						%>
			            <tr>
			                <td>${participationType.getParticipationTypeName(locale)}</td>
			                <td>${sdf.format(participationType.getCreateDate())}</td>
			                <td>${sdf.format(participationType.getModifiedDate())}</td>
			                <td><%= UserLocalServiceUtil.getUser(participationTypeMaster.getModifiedBy()).getFullName() %></td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editParticipationType">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbParticipationTypeWebPortletKeys.EDIT_PARTICIPATION_TYPE_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="participationTypeMasterId" value="${participationType.participationTypeMasterId}" />
								</portlet:renderURL>
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editParticipationType}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${participationType.participationTypeMasterId}" data-id="${participationType.participationTypeMasterId}" data-target="#myModal" data-toggle="modal" >
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
$(document).ready(function(){
	$('#participationTypeTable').DataTable({
		"order":[[2,"desc"]]
	});
});
$(document).on("click",".openDeleteModal", function(){
    $('#<portlet:namespace/>participationTypeMasterId').val($(this).data('id'));
})
$(".modal-backdrop").remove();
</script>