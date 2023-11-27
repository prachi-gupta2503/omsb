<%@ include file="../../init.jsp"%>
<table id="search_decision_data" class="display omsb-datatables"  >
				<thead>
					<tr>
						<th><liferay-ui:message key="certificate" /></th>
						<c:if test="${hasEmployeeRole}">
							<th><liferay-ui:message key="employer" /></th>
						</c:if>
						<c:if test="${hasEmployerRole}">
							<th><liferay-ui:message key="employee" /></th>
						</c:if>
						<th><liferay-ui:message key="decision-date" /></th>
						<th><liferay-ui:message key="equivalency-level" /></th>
						<th><liferay-ui:message key="appeal-status" /></th>
						<th><liferay-ui:message key="equivalency-certificate" /></th>
						<th><liferay-ui:message key="action" /></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="searchDto" items="${searchDtos}">
						
						<portlet:renderURL var="appealEmployeeRenderURL">
							<portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.NEW_APPEAL_SAVE %>" />
								<portlet:param name="equivalencyDecisionLevelId" value="${searchDto.equivalencyDecisionId}" />
						</portlet:renderURL>

						<portlet:renderURL var="viewEmployeeRenderURL">
							<portlet:param name="mvcRenderCommandName"  value="<%=AppealConstants.VIEW_APPEAL_ALL%>" />
							<portlet:param name="equivalencyDecisionLevelId" value="${searchDto.equivalencyDecisionId}" />
						</portlet:renderURL>

						<tr>
							<td>${searchDto.fileName}</td>
							<c:if test="${hasEmployeeRole}">
								<td>${searchDto.employer}</td>
							</c:if>
							<c:if test="${hasEmployerRole}">
								<td>${searchDto.employee}</td>
							</c:if>
							<td>${searchDto.dob}</td>
							<td>${searchDto.equivalencyLevel}</td>
							<td > 
								<c:choose>
									<c:when test="${not empty searchDto.status}">
										<c:choose>
											<c:when test="${(hasEmployerRole || hasEmployeeRole) && !(searchDto.status eq 'Completed' || searchDto.status eq 'Rejected' || searchDto.status eq 'Insufficient')}">
												<span class="${appealStatusColur.get('In Progress')}"><liferay-ui:message key="in-progress" /></span>
											</c:when>
											<c:otherwise>
												<span class="${appealStatusColur.get(searchDto.status)}">${searchDto.status}</span>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<span class="${appealStatusColur.get('NA')}"><liferay-ui:message key="na" /></span>
									</c:otherwise>
								</c:choose>
							</td>
							
							<td>
								<c:choose>
									<c:when test="${ not empty searchDto.certificateURL}" >
										<a href="${searchDto.certificateURL}" class="btn btn-label view-download" download>
											<liferay-ui:message key="equivalency-certificate" /></a>
									</c:when>
									<c:otherwise>
										<liferay-ui:message key="na" />
									</c:otherwise>
								</c:choose>		
							</td>
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<c:if test="${!searchDto.appealExist}">
											<li><a href="${appealEmployeeRenderURL}" class="dropdown-item">	
												<i class="fa fa-plus-square-o"></i><liferay-ui:message key="appeal" /></a></li>
											</c:if>
										<li><a href="${viewEmployeeRenderURL}" class="dropdown-item"><i class="fa fa-eye"></i>
											<liferay-ui:message key="view" /></a></li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>