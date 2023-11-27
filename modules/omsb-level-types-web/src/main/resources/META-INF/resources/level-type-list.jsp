<%@ include file="init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="levelTypeTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="level-type" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="create-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${levelTypeMasterList}" var="levelType"> 
						<%
	    					LevelTypeMaster levelTypeMaster = (LevelTypeMaster)pageContext.getAttribute("levelType");
						%>
			            <tr>
			                <td>${levelType.getLevelTypeName(locale)}</td>
			            	<td><%= UserLocalServiceUtil.getUser(levelTypeMaster.getModifiedBy()).getFullName() %></td>
			                <td>${sdf.format(levelType.getCreateDate())}</td>
			                <td>${sdf.format(levelType.getModifiedDate())}</td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editLevelType">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbLevelTypesWebPortletKeys.EDIT_LEVEL_TYPE_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="levelTypeMasterId" value="${levelType.levelTypeMasterId}" />
								</portlet:renderURL>
								
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editLevelType}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${levelType.levelTypeMasterId}" 
													data-id="${levelType.levelTypeMasterId}" data-target="#deleteModal" data-toggle="modal" ><i
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
	$('#<portlet:namespace/>levelTypeMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#levelTypeTable').DataTable({
		"sDom": 'Rfrtlip',
		"order":[[3,"desc"]]
	});
});
$(".modal-backdrop").remove();
</script>