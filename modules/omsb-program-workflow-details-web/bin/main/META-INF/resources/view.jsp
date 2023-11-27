<%@ include file="/init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="programWorkflowDetailsTable" class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program-name" /></th>
					<th><liferay-ui:message key="approval-order" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${programWorkflowDetails}" var="programWorkflowDetail"> 
					<portlet:renderURL var="editProgramWorkflowRenderURL">
			            <portlet:param name="mvcPath" value="<%= OmsbProgramWorkflowDetailsConstant.UPDATE_PROGRAM_WORKFLOW_DETAILS_JSP_PAGE %>" />
			            <portlet:param name="programId" value="${programWorkflowDetail.getProgramId()}"/>
			            <portlet:param name="approvalOrder" value="${programWorkflowDetail.getWorkflowApprovalOrder()}"/>
			            <portlet:param name="programWorkflowDetailsRelId" value="${programWorkflowDetail.getProgramWorkflowDetailsRelId()}"/>
			        </portlet:renderURL>
			        <%
					    ProgramWorkflowDetailsRel programWorkflowDetail = (ProgramWorkflowDetailsRel)pageContext.getAttribute("programWorkflowDetail");
					%>
		            <tr>
		                <td><%=ProgramMasterLocalServiceUtil.getProgramMaster(programWorkflowDetail.getProgramId()).getProgramName(locale) %></td>
		                <td>${programWorkflowDetail.workflowApprovalOrder}</td>
		                <td class="text-center" style="width:100px">
			            	<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="${editProgramWorkflowRenderURL}" class="dropdown-item"><i
												class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
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
	
	$(".js-basic-single").select2();
	
	$('#programWorkflowDetailsTable').DataTable({
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
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'pdf',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'excel',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'print',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    }
                ]
            }
        ]
	});
});
</script>