<%@ include file="init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="assignProcedureTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="author" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="id" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="procedure-group" /></th>
					<th><liferay-ui:message key="procedure" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pgProceduresCPTCodeRels}" var="pgProcedureCPTCodeRel">
					<portlet:renderURL var="editAssignProcedureURL">
			            <portlet:param name="jspPage" value="<%= OmsbAssignProcedureConstants.EDIT_ASSIGN_PROCEDURES_JSP_NAME %>"/>
			            <portlet:param name="pgProceduresCPTCodeRelId" value="${pgProcedureCPTCodeRel.getPgProcedureCptCodeRelId()}" />
			        </portlet:renderURL>
					<portlet:actionURL name="<%= OmsbAssignProcedureConstants.DELETE_ASSIGN_PROCEDURE_MVC_COMMAND_NAME %>" var="deleteAssignProcedureURL">
						<portlet:param name="pgProceduresCPTCodeRelId" value="${pgProcedureCPTCodeRel.getPgProcedureCptCodeRelId()}" />
					</portlet:actionURL>
		            <tr>
		            <%
		            ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel = (ProcedureGroupProceduresCPTCodeRel)pageContext.getAttribute("pgProcedureCPTCodeRel");
		            ProcedureGroupMaster procedureGroupMaster = ProcedureGroupMasterLocalServiceUtil.getProcedureGroupMaster(procedureGroupProceduresCPTCodeRel.getProcedureGroupId());
		            ProcedureMaster procedureMaster = ProcedureMasterLocalServiceUtil.getProcedureMaster(procedureGroupProceduresCPTCodeRel.getProcedureId());
		            %>
		                <td><%= UserLocalServiceUtil.getUser(procedureGroupProceduresCPTCodeRel.getCreatedBy()).getFullName() %></td>
		                <td>${sdf.format(pgProcedureCPTCodeRel.getCreateDate())}</td>
		                <td>${pgProcedureCPTCodeRel.getPgProcedureCptCodeRelId()}</td>
		                <td>${sdf.format(pgProcedureCPTCodeRel.getCreateDate())}</td>
		                <td><%= procedureGroupMaster.getProcedureGroupName(themeDisplay.getLanguageId()) %></td>
     		            <td><%= procedureMaster.getProcedureName(themeDisplay.getLanguageId()) %></td>
		                <td class="text-center" style="width:50px">
			            	<div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a href="${editAssignProcedureURL}" class="dropdown-item"><i
											class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
										</a>
									</li>
									<li>
										<a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${pgProcedureCPTCodeRel.getPgProcedureCptCodeRelId()}" data-id="${pgProcedureCPTCodeRel.getPgProcedureCptCodeRelId()}" data-target="#myModal" data-toggle="modal"><i
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
	$('#<portlet:namespace/>pgProcedureCptCodeRelId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#assignProcedureTable').DataTable({
		"order": [[3,"asc"]]
	});
	$(".modal-backdrop").remove();
});
</script>