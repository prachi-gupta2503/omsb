<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@page import="gov.omsb.programs.web.constants.OmsbProgramConstants"%>
<%@ include file="/init.jsp" %>

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="userTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program-name" /></th>
					<th><liferay-ui:message key="program-code" /></th>
					<th><liferay-ui:message key="program-type" /></th>
					<th><liferay-ui:message key="establishment-date" /></th>
					<!--  The code commented as this details not required  as received feedback from the client on 16-08-2023-->
					<!-- <th><liferay-ui:message key="eligibility-degree" /></th> -->
					<th><liferay-ui:message key="program-status" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allProgramList}" var="pt"> 
				
					<portlet:renderURL var="editProgramActionURL">
					     <portlet:param name="mvcRenderCommandName" value="<%=OmsbProgramConstants.EDIT_PROGRAM_MVC_RENDER_COMMAND%>" />
					     <portlet:param name="programMasterId" value="${pt.getProgramMasterId()}" />
					</portlet:renderURL>
					
					<portlet:actionURL name="<%= OmsbProgramConstants.DELETE_PROGRAM_MVC_COMMAND_NAME %>" var="deleteProgramActionURL">
						<portlet:param name="programMasterId" value="${pt.getProgramMasterId()}" />
					</portlet:actionURL>
			            <tr>
			                <td>${pt.getProgramName()}</td>
			                <td>${pt.getProgramCode()}</td>
			                <td>${pt.getProgramType()}</td>
			                <td><fmt:formatDate pattern= "<%= OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY %>" value= "${pt.getEstablishmentDate()}" /></td>
			                <%-- <td>${pt.getEligibilityDegree()}</td> --%>
			                <td>
			                	<c:choose>
								    <c:when test="${pt.programStatus}">
								        <liferay-ui:message key="active" />
								    </c:when>
								    <c:otherwise>
								        <liferay-ui:message key="inactive" />
								    </c:otherwise>
								</c:choose>
			                </td>
			                <td class="text-center" style="width:50px">
				            	<div class="dropdown ">
										<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editProgramActionURL}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${pt.getProgramMasterId()}" data-id="${pt.getProgramMasterId()}" data-target="#myModal" data-toggle="modal"><i
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
	<div class="bottom-backbtn-wrap">	
		<a class="btn omsb-btn btn-back" href="${allPrograms}" title="Back"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>	
	</div>
</div>
<jsp:include page="/modal-popup.jsp" />
<script>
	$(document).on("click",".openDeleteModal", function(){
		$('#<portlet:namespace/>programMasterId').val($(this).data('id'));
	});

	$(document).ready(function(){
		$('#userTable').DataTable({
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
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            },
	    	            {
	    	                extend: 'pdf',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            },
	    	            {
	    	                extend: 'excel',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            },
	    	            {
	    	                extend: 'print',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            }
	    	        ]
	    	    }
	    	]
		 });
	});
</script>