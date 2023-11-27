<%@page import="gov.omsb.program.type.web.constants.OmsbProgramTypeConstants"%>
<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@ include file="/init.jsp" %>

<liferay-ui:error key="programTypeNameError" message="program-type-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="userTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program-type" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${programTypeList}" var="pt"> 
					<portlet:renderURL var="editProgramTypeActionURL">
			            <portlet:param name="mvcPath" value="<%= OmsbProgramTypeConstants.UPDATE_PROGRAM_TYPE_JSP_NAME %>" />
			            <portlet:param name="programTypeName" value="${pt.getProgramTypeName()}"/>
			            <portlet:param name="programTypeId" value="${pt.getProgramTypeMasterId()}"/>
			        </portlet:renderURL>
					<portlet:actionURL name="<%= OmsbProgramTypeConstants.DELETE_PROGRAM_TYPE_MVC_COMMAND_NAME %>" var="deleteProgramTypeActionURL">
						<portlet:param name="programTypeId" value="${pt.getProgramTypeMasterId()}" />
					</portlet:actionURL>
			            <tr>
			                <td>${pt.getProgramTypeName(locale)}</td>
			                <td>${sdf.format(pt.getCreateDate())}</td>
			                <td>${sdf.format(pt.getModifiedDate())}</td>
			                <td class="text-center" style="width:100px">
				            	<div class="dropdown ">
										<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editProgramTypeActionURL}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${pt.getProgramTypeMasterId()}" data-id="${pt.getProgramTypeMasterId()}" data-target="#myModal" data-toggle="modal"><i
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
	$('#<portlet:namespace/>programTypeId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#userTable').DataTable({
		"sDom": 'Rfrtlip',
		"order": [[2,"desc"]]
	 });
	$(".modal-backdrop").remove();
});
</script>
 