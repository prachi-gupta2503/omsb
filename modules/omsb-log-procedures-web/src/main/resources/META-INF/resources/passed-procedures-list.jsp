<%@ include file="init.jsp"%>

<div class="tab-pane fade" id="pills-passed"
	aria-labelledby="pills-passed-tab">
	<aui:form action="${filterLogProcedures}" name="pills-passed-tab_form">
		<aui:input name="tab" type="hidden" value="pills-passed-tab" />
		<aui:input name="status" type="hidden" value="<%=OmsbViewProceduresSupervisorWebPortletKeys.STATUS_PASS %>" />
		<div class="row m-0">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:input name="startDate" id="startDate" label="from-date"
						type="text" cssClass="filter-start-date" ignoreRequestValue="true">
					</aui:input>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:input name="endDate" id="endDate" label="to-date"
						type="text" cssClass="filter-end-date" ignoreRequestValue="true">
					</aui:input>
				</div>
			</div>
		</div>
	</aui:form>
	<div class="omsb-list-view table-responsive">
		<table id="passedProceduresTable" class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="procedure-name" /></th>
					<th><liferay-ui:message key="procedure-group" /></th>
					<th><liferay-ui:message key="cpt-code" /></th>
					<th><liferay-ui:message key="patient-id" /></th>
					<th><liferay-ui:message key="patient-dob" /></th>
					<th><liferay-ui:message key="procedure-performed-date" /></th>
					<th><liferay-ui:message key="role-type" /></th>
					<th><liferay-ui:message key="supervisor" /></th>
					<th><liferay-ui:message key="status" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${passLoggedProcedures}" var="loggedProcedure">
					<portlet:renderURL var="editProcedureURL">
						<portlet:param name="mvcRenderCommandName"
							value="<%= OmsbLogProceduresConstants.EDIT_LOG_PROCEDURES_JSP %>" />
						<portlet:param name="loggedProcedureId"
							value="${loggedProcedure.getTraineeLoggedProcedureDetailsId()}" />
						<portlet:param name="patientId"
							value="${loggedProcedure.getPatientId()}" />
						<portlet:param name="tab" value="pills-passed-tab" />
					</portlet:renderURL>
					<portlet:actionURL
						name="<%= OmsbLogProceduresConstants.DELETE_LOG_PROCEDURE_ACTION_COMMAND %>"
						var="deleteProcedureLogURL">
						<portlet:param name="id"
							value="${loggedProcedure.getTraineeLoggedProcedureDetailsId()}" />
						<portlet:param name="tab" value="pills-passed-tab" />
					</portlet:actionURL>
					<tr>
						<%
		            TraineeLoggedProcedureDetails traineeLoggedProcedure = (TraineeLoggedProcedureDetails)pageContext.getAttribute("loggedProcedure");
		            long procedureId = traineeLoggedProcedure.getProcedureId();
		            long roleTypeId = traineeLoggedProcedure.getRoleTypeId();
		            long supervisorId = traineeLoggedProcedure.getFacultyId();
		            String procedureGroupName = StringPool.BLANK;
		            String cptCode = StringPool.BLANK;
		            ProcedureMaster procedureMaster = ProcedureMasterLocalServiceUtil.getProcedureMaster(procedureId);
		            if(Validator.isNotNull(procedureMaster.getCptCode())) {
		            	cptCode = procedureMaster.getCptCode(locale);
		            }
		            if(Validator.isNotNull(procedureMaster.getProcedureGroupMasterId())) {
		            	ProcedureGroupMaster procedureGroupMaster = ProcedureGroupMasterLocalServiceUtil.fetchProcedureGroupMaster(procedureMaster.getProcedureGroupMasterId());
		            	procedureGroupName = procedureGroupMaster.getProcedureGroupName(locale);
		            }

		            %>
						<td>
							<c:if test="${(permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_LOG_PROCEDURE)) || (permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_LOG_PROCEDURE))}">
								<a class="clickable clickable_underline" href="${editProcedureURL}">
							</c:if>
								<%=procedureMaster.getProcedureName(locale)%>
							<c:if test="${(permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_LOG_PROCEDURE)) || (permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_LOG_PROCEDURE))}">
								</a>
							</c:if>
						</td>
						<td><%=procedureGroupName%></td>
						<td><%=cptCode%></td>
						<td>${loggedProcedure.patientId}</td>
						<td>${sdf.format(loggedProcedure.getPatientDOB())}</td>
						<td>${sdf.format(loggedProcedure.getProcedurePerformedDate())}</td>
						<td><%= RoleTypeMasterLocalServiceUtil.getRoleTypeMaster(roleTypeId).getRoleTypeName(locale) %></td>
						<td><%= UserLocalServiceUtil.getUser(supervisorId).getFullName() %></td>
						<td><c:choose>
								<c:when test="${loggedProcedure.procedureStatus == 'PASS'}">
									<span class="omsb-pass-bg">${loggedProcedure.procedureStatus}</span>
								</c:when>
								<c:when test="${loggedProcedure.procedureStatus == 'REFUSE'}">
									<span class="omsb-refuse-bg">${loggedProcedure.procedureStatus}</span>
								</c:when>
								<c:when test="${loggedProcedure.procedureStatus == 'NOT PASS'}">
									<span class="omsb-notpass-bg">${loggedProcedure.procedureStatus}</span>
								</c:when>
								<c:otherwise>
									<span class="omsb-uncofirm-bg">${loggedProcedure.procedureStatus}</span>
								</c:otherwise>
							</c:choose></td>
						<td class="text-center" style="width: 100px"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script>
$(document).ready(function(){
	$('#passedProceduresTable').DataTable({
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