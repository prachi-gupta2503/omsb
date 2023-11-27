<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty pastWorkDetails}">
	<table class="display omsb-datatables" id="work-detail-list1" width="100%">
			<thead>
				<tr>
					<th><liferay-ui:message key="workplace-sector-type" /></th>
					<%-- <th><liferay-ui:message key="workplace-sector-other" /></th> --%>
					<th><liferay-ui:message key="sector-name" /></th>
					<%-- <th><liferay-ui:message key="sector-name-other" /></th>
					<th><liferay-ui:message key="sector-name-2" /></th>
					<th><liferay-ui:message key="sector-name-2-other" /></th>
					<th><liferay-ui:message key="sector-name-3" /></th>
					<th><liferay-ui:message key="sector-name-3-other" /></th> --%>
					<th><liferay-ui:message key="region-locationS-institution" /></th>
					<th><liferay-ui:message key="designation" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
			 <c:forEach var="pastWorkDetail" items="${pastWorkDetails}"> 
				<tr>
					<td>${pastWorkDetail.getWorkSectorType()}</td>
					<%-- <td>${pastWorkDetail.getWorkSectorTypeOther()}</td> --%>
					<td>${pastWorkDetail.getWorkSector()}</td>
					<%-- <td>${pastWorkDetail.getWorkSectorOther()}</td>
					<td>${pastWorkDetail.getWorkSector2()}</td>
					<td>${pastWorkDetail.getWorkSectorOther2()}</td>
					<td>${pastWorkDetail.getWorkSector3()}</td>
					<td>${pastWorkDetail.getWorkSectorOther3()}</td> --%>
					<td>${pastWorkDetail.getWorkSectorLocation()}</td>
					<td>${pastWorkDetail.getDesignationId()}</td>
					<td>
						<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-work-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${pastWorkDetail.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
						<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-work-detail-confirm-modal" onclick="setWorkDetailEditID('${pastWorkDetail.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
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

