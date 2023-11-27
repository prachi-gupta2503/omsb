<%@ include file="init.jsp"%>

<div class="tab-pane fade show active" id="pills-all"
	aria-labelledby="pills-all-tab">
	<aui:form action="${filterLogProcedures}" name="pills-all-tab_form">
		<div class="row m-0">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:input name="startDate" label="from-date" type="text"
						cssClass="filter-start-date" ignoreRequestValue="true">
					</aui:input>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:input name="endDate" label="to-date" type="text"
						cssClass="filter-end-date" ignoreRequestValue="true">
					</aui:input>
				</div>
			</div>
		</div>
	</aui:form>
	<div class="omsb-list-view table-responsive">
		<table id="logProcedureTable" class="display omsb-datatables">
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
				<c:forEach items="${loggedProcedures}" var="loggedProcedure">
					<portlet:renderURL var="editProcedureURL">
						<portlet:param name="mvcRenderCommandName"
							value="<%=OmsbLogProceduresConstants.EDIT_LOG_PROCEDURES_JSP%>" />
						<portlet:param name="loggedProcedureId"
							value="${loggedProcedure.getTraineeLoggedProcedureDetailsId()}" />
						<portlet:param name="patientId"
							value="${loggedProcedure.getPatientId()}" />
					</portlet:renderURL>
					<tr>
						<%
							TraineeLoggedProcedureDetails traineeLoggedProcedure = (TraineeLoggedProcedureDetails) pageContext
										.getAttribute("loggedProcedure");
								long procedureId = traineeLoggedProcedure.getProcedureId();
								long roleTypeId = traineeLoggedProcedure.getRoleTypeId();
								long supervisorId = traineeLoggedProcedure.getFacultyId();
								String procedureGroupName = StringPool.BLANK;
								String cptCode = StringPool.BLANK;
								ProcedureMaster procedureMaster = ProcedureMasterLocalServiceUtil.getProcedureMaster(procedureId);
								if (Validator.isNotNull(procedureMaster.getCptCode())) {
									cptCode = procedureMaster.getCptCode(locale);
								}
								if (Validator.isNotNull(procedureMaster.getProcedureGroupMasterId())) {
									ProcedureGroupMaster procedureGroupMaster = ProcedureGroupMasterLocalServiceUtil
											.fetchProcedureGroupMaster(procedureMaster.getProcedureGroupMasterId());
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
						<td><%=RoleTypeMasterLocalServiceUtil.getRoleTypeMaster(roleTypeId).getRoleTypeName(locale)%></td>

						<td><%=UserLocalServiceUtil.getUser(supervisorId).getFullName()%></td>
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
						<td class="text-center" style="width: 100px">
							<c:if test="${loggedProcedure.procedureStatus != 'PASS'}">
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">									
										<c:if
											test="${(permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_LOG_PROCEDURE)) && (loggedProcedure.procedureStatus == 'REFUSE' || loggedProcedure.procedureStatus == 'UNCONFIRMED')}">
											<li><a href="${editProcedureURL}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
											</a></li>
										</c:if>
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_LOG_PROCEDURE)}">
											<li><a href="javascript:void(0)"
												class="dropdown-item openDeleteModal"
												id="${loggedProcedure.getTraineeLoggedProcedureDetailsId()}"
												data-target="#deleteModal" data-toggle="modal"><i
													class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
											</a></li>
										</c:if>
									</ul>
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>