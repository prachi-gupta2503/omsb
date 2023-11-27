<%@page import="gov.omsb.visit.types.web.constants.OmsbVisitTypesWebPortletKeys"%>
<%@ include file="/init.jsp" %>

<liferay-ui:error key="visitTypeNameError" message="visit-type-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
				<table id="visitTypeTable" class="display omsb-datatables">
				<caption></caption>
					<thead>
						<tr>
							<th><liferay-ui:message key="visit-type" /></th>
							<th><liferay-ui:message key="last-modified-by" /></th>
							<th><liferay-ui:message key="created-date" /></th>
							<th><liferay-ui:message key="modified-date" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
							<c:forEach items="${visitTypeMasterList}" var="visitType"> 
								<%
			    					VisitTypeMaster visitTypeMaster = (VisitTypeMaster)pageContext.getAttribute("visitType");
								%>
					            <tr>
					                <td>${visitType.getVisitTypeName(locale)}</td>
					            	<td><%= UserLocalServiceUtil.getUser(visitTypeMaster.getModifiedBy()).getFullName() %></td>
					                <td>${sdf.format(visitType.getCreateDate())}</td>
					                <td>${sdf.format(visitType.getModifiedDate())}</td>
					                <td class="text-center" style="width:100px">
					                	<portlet:renderURL var="editVisitType">
										    <portlet:param name="mvcRenderCommandName" value="<%=OmsbVisitTypesWebPortletKeys.EDIT_VISIT_TYPE_MVC_RENDER_COMMAND%>" />
										     <portlet:param name="visitTypeMasterId" value="${visitType.visitTypeMasterId}" />
										</portlet:renderURL>
										
					                	<portlet:actionURL name="<%= OmsbVisitTypesWebPortletKeys.DELETE_VISIT_TYPE_MVC_ACTION_COMMAND %>" var="deleteVisitType">
											<portlet:param name="visitTypeMasterId" value="${visitType.visitTypeMasterId}" />
										</portlet:actionURL>
						            	<div class="dropdown ">
						            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
													type="button" data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">
													<li><a href="${editVisitType}" class="dropdown-item"><i
															class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
														</a>
													</li>
													<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${visitType.visitTypeMasterId}" data-id="${visitType.visitTypeMasterId}" data-target="#myModal" data-toggle="modal" >
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
$(document).on("click",".openDeleteModal", function(){
	$('#<portlet:namespace/>visitTypeMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#visitTypeTable').DataTable({
	    "sDom": 'Rfrtlip',
		"order":[[3,"desc"]]
	 });
	$(".modal-backdrop").remove();
});
</script>