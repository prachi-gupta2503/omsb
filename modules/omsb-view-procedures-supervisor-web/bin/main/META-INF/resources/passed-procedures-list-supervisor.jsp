<%@ include file="init.jsp"%>

<div class="tab-pane fade" id="pills-passed"
	aria-labelledby="pills-passed-tab">
	<div class="omsb-list-view table-responsive">
		<table id="passedProceduresTable" class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="procedure-name" /></th>
					<th><liferay-ui:message key="procedure-group-name" /></th>
					<th><liferay-ui:message key="program-name" /></th>
					<th><liferay-ui:message key="cpt-code" /></th>
					<th><liferay-ui:message key="trainee-name" /></th>
					<th><liferay-ui:message key="patient-id" /></th>
					<th><liferay-ui:message key="training-site" /></th>
					<th><liferay-ui:message key="role" /></th>
					<th><liferay-ui:message key="procedure-status" /></th>
					<th><liferay-ui:message key="procedure-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="isUnconfirmStatusPresent" value="${false}" />
				<c:forEach items="${passTraineeLoggedProcedureDetailsDTOs}"
					var="traineeLoggedProcedureDetails">
					<liferay-portlet:renderURL var="viewProcedure">
						<liferay-portlet:param name="mvcRenderCommandName"
							value="<%=OmsbViewProceduresSupervisorWebPortletKeys.VIEW_PROCEDURE_DETAIL%>" />
						<liferay-portlet:param name="traineeLoggedProcedureDetailsId"
							value="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}" />
						<liferay-portlet:param name="tab" value="pills-passed-tab" />
					</liferay-portlet:renderURL>
					<tr>
						<%
							TraineeLoggedProcedureDetailsDTO traineeLoggedProcedureDetails = (TraineeLoggedProcedureDetailsDTO) pageContext
										.getAttribute("traineeLoggedProcedureDetails");
								String traineeName = StringPool.BLANK;
								User traineeUser = UserLocalServiceUtil.fetchUser(traineeLoggedProcedureDetails.getTraineeId());
								if (Validator.isNotNull(traineeUser)) {
									traineeName = traineeUser.getFullName();
								}
						%>
						<td><a href="${viewProcedure}" class="clickable clickable_underline">${traineeLoggedProcedureDetails.procedureName}</a></td>
						<td>${traineeLoggedProcedureDetails.procedureGroupName}</td>
						<td>${traineeLoggedProcedureDetails.programName}</td>
						<td>${traineeLoggedProcedureDetails.cptCode}</td>
						<td><%=traineeName%></td>
						<td>${traineeLoggedProcedureDetails.patientId}</td>
						<td>${traineeLoggedProcedureDetails.trainingSiteName}</td>
						<td>${traineeLoggedProcedureDetails.roleTypeName}</td>
						<c:choose>
							<c:when
								test="${traineeLoggedProcedureDetails.procedureStatus == 'PASS'}">
								<td><span class="omsb-pass-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>
							</c:when>
							<c:when
								test="${traineeLoggedProcedureDetails.procedureStatus == 'REFUSE'}">
								<td><span class="omsb-refuse-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>

							</c:when>
							<c:when
								test="${traineeLoggedProcedureDetails.procedureStatus == 'NOT PASS'}">
								<td><span class="omsb-notpass-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="omsb-uncofirm-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>
							</c:otherwise>
						</c:choose>

						<td><fmt:formatDate
								pattern="<%= OmsbViewProceduresSupervisorWebPortletKeys.STORE_DATE_FORMAT %>"
								value="${traineeLoggedProcedureDetails.procedurePerformedDate}" /></td>

						<td class="text-center" style="width: 100px">
							<div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<li><a href="${viewProcedure}" class="dropdown-item">
											<img
											src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg"
											alt="view"> <liferay-ui:message key="view" />
									</a></li>
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
	$('#passedProceduresTable').DataTable({
	    "sDom": 'Rfrtlip',
		"order": [],
	    "columnDefs": [ {
	      "targets"  : 'no-sort',
	      "orderable": false,
	    }],
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