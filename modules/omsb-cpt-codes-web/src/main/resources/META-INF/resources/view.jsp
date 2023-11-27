<%@page import="gov.omsb.tms.model.CptCodeMaster"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="cptCodeNameError" message="cpt-code-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="userTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="cpt-code" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cptCodeMasterList}" var="cptCode"> 
					<portlet:renderURL var="editCptCodeActionURL">
			            <portlet:param name="mvcPath" value="<%=OmsbCptCodesConstants.EDIT_JSP_PAGE%>" />
			            <portlet:param name="cptCodeName" value="${cptCode.getCptCodeName()}"/>
			            <portlet:param name="cptCodeMasterId" value="${cptCode.getCptCodeMasterId()}"/>
			        </portlet:renderURL>
					<portlet:actionURL name="<%= OmsbCptCodesConstants.DELETE_CPT_CODES_MVC_COMMAND_NAME %>" var="deleteCptCodeActionURL">
						<portlet:param name="cptCodeMasterId" value="${cptCode.getCptCodeMasterId()}" />
					</portlet:actionURL>
					<%
					    CptCodeMaster cptCodeMaster = (CptCodeMaster)pageContext.getAttribute("cptCode");
					%>
			            <tr>	
			                <td>${cptCode.getCptCodeName(locale)}</td>
			                <td>${sdf.format(cptCode.getCreateDate())}</td>
			                <td>${sdf.format(cptCode.getModifiedDate())}</td>
			                <td><%=UserLocalServiceUtil.getUser(cptCodeMaster.getModifiedBy()).getFullName() %></td>
			                <td class="text-center" style="width:50px">
				            	<div class="dropdown ">
										<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editCptCodeActionURL}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${cptCode.getCptCodeMasterId()}" data-id="${cptCode.getCptCodeMasterId()}" data-target="#myModal" data-toggle="modal"><i
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
	$('#<portlet:namespace/>cptCodeMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#userTable').DataTable({
	    "sDom": 'Rfrtlip',
	    "order": [[2,"desc"]]
	 });
	$(".modal-backdrop").remove();
});
</script>
 