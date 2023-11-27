<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty persons}">
		<table class="display omsb-datatables" id="data_Verification"
			width="100%">
			<thead>
				<tr>
					<th><liferay-ui:message key="name" /></th>
					<th><liferay-ui:message key="dfrn" /></th>
					<th><liferay-ui:message key="verification-date" /></th>
					<th><liferay-ui:message key="status" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="person" items="${persons}">
					<tr>
						<portlet:renderURL var="viewPersonDetailsURL">
							<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PERSONAL_DETAILS%>" />
							<portlet:param name="caseRequestId" value="${person.caseRequestId}" />
						</portlet:renderURL>
						<td>${person.personName}</td>
						<td>${person.caseNumber}</td>
						<td>${person.verificationDate}</td>
						<td><span class="omsb-${person.getCaseStatus().toLowerCase()}-bg">${person.caseStatus}</span></td>
						<td><a href="${viewPersonDetailsURL}" class="btn omsb-dd-button"> <img src="<%=themeDisplay.getPathThemeImages()%>/svg/red_eye.svg" alt=""> 
								<liferay-ui:message key="view" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-records-found" />
	</c:otherwise>
</c:choose>

