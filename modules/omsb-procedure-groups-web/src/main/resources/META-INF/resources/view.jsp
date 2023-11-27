<%@ include file="init.jsp" %>

<liferay-ui:error key="procedureGroupNameError" message="procedure-group-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="userTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="procedure-group-name" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${procedureGroupMasterList}" var="procedureGroup"> 
					<portlet:renderURL var="editProcedureGroupActionURL">
			            <portlet:param name="mvcRenderCommandName" value="<%=OmsbProcedureGroupsConstants.EDIT_PROCEDURE_GROUPS_MVC_COMMAND_NAME%>" />
			            <portlet:param name="procedureGroupMasterId" value="${procedureGroup.getProcedureGroupMasterId()}"/>
			        </portlet:renderURL>
					<portlet:actionURL name="<%= OmsbProcedureGroupsConstants.DELETE_PROCEDURE_GROUPS_MVC_COMMAND_NAME %>" var="deleteProcedureGroupActionURL">
						<portlet:param name="procedureGroupMasterId" value="${procedureGroup.getProcedureGroupMasterId()}" />
					</portlet:actionURL>
					<%
					    ProcedureGroupMaster procedureGroupMaster = (ProcedureGroupMaster)pageContext.getAttribute("procedureGroup");
					%>
			            <tr>
			                <td>${procedureGroup.getProcedureGroupName(locale)}</td>
			            	<td><%=UserLocalServiceUtil.getUser(procedureGroupMaster.getModifiedBy()).getFullName() %></td>
			                <td>${sdf.format(procedureGroup.getCreateDate())}</td>
			                <td>${sdf.format(procedureGroup.getModifiedDate())}</td>
			                <td class="text-center" style="width:50px">
				            	<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="${editProcedureGroupActionURL}" class="dropdown-item"><i
												class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
											</a>
										</li>
										<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${procedureGroup.getProcedureGroupMasterId()}" data-id="${procedureGroup.getProcedureGroupMasterId()}" data-target="#myModal" data-toggle="modal"><i
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
		$('#<portlet:namespace/>procedureGroupMasterId').val($(this).data('id'));
	});
	
	$(document).ready(function(){
		$('#userTable').DataTable({
	        "sDom": 'Rfrtlip',
	        "order": [[3,"desc"]]
		});
		$(".modal-backdrop").remove();
	});
</script>
 