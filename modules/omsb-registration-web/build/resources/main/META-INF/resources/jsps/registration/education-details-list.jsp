<%@ include file="../../init.jsp"%>
<c:choose>
	<c:when test="${!empty educationalDetailItemList}">
		<table class="display omsb-datatables" id="work-detail-list"
			width="100%">
			<thead>
				<tr>
					<th><liferay-ui:message key="qualification" /></th>
					<th><liferay-ui:message key="institution" /></th>
					<th><liferay-ui:message key="country-of-institution" /></th>
					<%-- <th><liferay-ui:message key="gpa" /></th> --%>
					<th><liferay-ui:message key="year-of-graduation" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}">
				<tr>
					
					<td>${educationalDetailItem.qualificationAttained}</td>
					<td>${educationalDetailItem.issuingAuthorityName}</td>
					<td>${educationalDetailItem.issuingAuthorityCountry}</td>
					<%-- <td>${educationalDetailItem.gpa}</td> --%>
					<td>${educationalDetailItem.yearOfGraduation}</td>
					<td>
						<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
						<button class="btn mx-2" value="view" data-toggle="modal" data-target="#add-education-confirm-modal" type="button" onclick="setEditID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-records-found" />
	</c:otherwise>
</c:choose>
					    