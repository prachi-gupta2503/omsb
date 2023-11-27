<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.RoleTypeMaster"%>
<%@ include file="/init.jsp" %>

<liferay-ui:error key="roleTypeNameerror" message="role-type-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="roleTypeTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="role-type" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roleTypeMasterList}" var="roleType"> 
						<%
	    					RoleTypeMaster roleTypeMaster = (RoleTypeMaster)pageContext.getAttribute("roleType");
						%>
			            <tr>
			                <td>${roleType.getRoleTypeName(locale)}</td>
			            	<td><%= UserLocalServiceUtil.getUser(roleTypeMaster.getModifiedBy()).getFullName() %></td>
			                <td>${sdf.format(roleType.getCreateDate())}</td>
			                <td>${sdf.format(roleType.getModifiedDate())}</td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editRoleType">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbRoleTypesWebPortletKeys.EDIT_ROLE_TYPE_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="roleTypeMasterId" value="${roleType.roleTypeMasterId}" />
								</portlet:renderURL>
								
			                	<portlet:actionURL name="<%= OmsbRoleTypesWebPortletKeys.DELETE_ROLE_TYPE_MVC_ACTION_COMMAND %>" var="deleteRoleType">
									<portlet:param name="roleTypeMasterId" value="${roleType.roleTypeMasterId}" />
								</portlet:actionURL>
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editRoleType}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${roleType.getRoleTypeMasterId()}" data-id="${roleType.getRoleTypeMasterId()}" data-target="#myModal" data-toggle="modal"><i
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
	$('#<portlet:namespace/>roleTypeMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#roleTypeTable').DataTable({
	    "sDom": 'Rfrtlip',
	    "order": [[3,"desc"]]
	 });
	$(".modal-backdrop").remove();
});
</script>