<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.PatientTypeMaster"%>
<%@ include file="/init.jsp" %>

<liferay-ui:error key="patientTypeNameError" message="patient-type-name-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="patientTypeTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="patient-type" /></th>
					<th><liferay-ui:message key="created-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${patientTypeMasterList}" var="patientType"> 
						<%
	    					PatientTypeMaster patientTypeMaster = (PatientTypeMaster)pageContext.getAttribute("patientType");
						%>
			            <tr>
			                <td>${patientType.getPatientTypeName(locale)}</td>
			                <td>${sdf.format(patientType.getCreateDate())}</td>
			                <td>${sdf.format(patientType.getModifiedDate())}</td>
			                <td><%= UserLocalServiceUtil.getUser(patientTypeMaster.getModifiedBy()).getFullName() %></td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editPatientType">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbPatientTypesWebPortletKeys.EDIT_PATIENT_TYPE_MVC_RENDER_COMMAND%>" />
								     <portlet:param name="patientTypeMasterId" value="${patientType.patientTypeMasterId}" />
								</portlet:renderURL>
								
			                	<portlet:actionURL name="<%= OmsbPatientTypesWebPortletKeys.DELETE_PATIENT_TYPE_MVC_ACTION_COMMAND %>" var="deletePatientType">
									<portlet:param name="patientTypeMasterId" value="${patientType.patientTypeMasterId}" />
								</portlet:actionURL>
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editPatientType}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${patientType.patientTypeMasterId}" data-id="${patientType.patientTypeMasterId}" data-target="#myModal" data-toggle="modal" >
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
	$('#<portlet:namespace/>patientTypeMasterId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#patientTypeTable').DataTable({
	    "sDom": 'Rfrtlip',
		"order":[[2,"desc"]]
	 });
	$(".modal-backdrop").remove();
});
</script>