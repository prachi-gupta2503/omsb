<%@ include file="init.jsp" %>

<liferay-ui:error key="procedureNameError" message="procedure-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="procedureTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="procedure-name" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${procedures}" var="procedure"> 
					<portlet:renderURL var="editProcedureURL">
			            <portlet:param name="mvcPath" value="<%= OmsbProceduresConstants.EDIT_PROCEDURE_MASTER_JSP_NAME %>"/>
			            <portlet:param name="procedureMasterId" value="${procedure.getProcedureMasterId()}" />
			        </portlet:renderURL>
			        <portlet:actionURL name="<%= OmsbProceduresConstants.DELETE_PROCEDURE_MASTER_MVC_COMMAND_NAME %>" var="deleteProcedureURL">
						<portlet:param name="procedureMasterId" value="${procedure.getProcedureMasterId()}" />
					</portlet:actionURL>
		            <tr>
		            <%
		            ProcedureMaster procedureMaster = (ProcedureMaster)pageContext.getAttribute("procedure");
		            %>
		                <td>${procedure.getProcedureName(languageId)}</td>
		                <td><%= UserLocalServiceUtil.getUser(procedureMaster.getCreatedBy()).getFullName() %></td>
		                <td>${sdf.format(procedure.getCreateDate())}</td>
		                <td>${sdf.format(procedure.getCreateDate())}</td>
		                <td class="text-center" style="width:50px">
			            	<div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<li><a href="${editProcedureURL}" class="dropdown-item"><i
											class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
										</a>
									</li>
									<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${procedure.getProcedureMasterId()}" data-id="${procedure.getProcedureMasterId()}" data-target="#myModal" data-toggle="modal"><i
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
	$('#<portlet:namespace/>procedureMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#procedureTable').DataTable({
        "sDom": 'Rfrtlip',
        "order": [[2,"desc"]]
	});
	$(".modal-backdrop").remove();
});
</script>