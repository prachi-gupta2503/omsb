<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.EligibilityDegreeMaster"%>
<%@ include file="/init.jsp" %>

<liferay-ui:error key="EligibilityDegreeError" message="eligibility-degree-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="eligibilityDegreeTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="degree" /></th>
					<th><liferay-ui:message key="create-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eligibilityDegreeMasterList}" var="eligiblilityDegree"> 
						<%
						EligibilityDegreeMaster eligibilityDegreeMaster = (EligibilityDegreeMaster)pageContext.getAttribute("eligiblilityDegree");
						%>
			            <tr>
			                <td>${eligiblilityDegree.getEligibilityDegree(locale)}</td>
			                <td>${sdf.format(eligiblilityDegree.getCreateDate())}</td>
			                <td>${sdf.format(eligiblilityDegree.getModifiedDate())}</td>
			                <td><%= UserLocalServiceUtil.getUser(eligibilityDegreeMaster.getModifiedBy()).getFullName() %></td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editEligiblilityDegree">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbEligibilityDegreeWebPortletKeys.EDIT_ELIGIBILITY_DEGREE_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="eligibilityDegreeMasterId" value="${eligiblilityDegree.eligibilityDegreeMasterId}" />
								</portlet:renderURL>
								
			                	<portlet:actionURL name="<%= OmsbEligibilityDegreeWebPortletKeys.DELETE_ELIGIBILITY_DEGREE_MVC_ACTION_COMMAND %>" var="deleteEligiblilityDegree">
									<portlet:param name="eligibilityDegreeMasterId" value="${eligiblilityDegree.eligibilityDegreeMasterId}" />
								</portlet:actionURL>
				            	<div class="dropdown">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editEligiblilityDegree}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${eligiblilityDegree.eligibilityDegreeMasterId}" data-id="${eligiblilityDegree.eligibilityDegreeMasterId}" data-target="#myModal" data-toggle="modal" >
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
	$('#<portlet:namespace/>eligibilityDegreeMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	 $('#eligibilityDegreeTable').DataTable({
	    "order": [[2, "desc"]]
	});
	$(".modal-backdrop").remove();
});
</script>