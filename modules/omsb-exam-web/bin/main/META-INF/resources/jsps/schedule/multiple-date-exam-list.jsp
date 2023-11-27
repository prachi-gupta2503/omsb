<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty examMultiDates}">
		<table class="display omsb-datatables" id="Multiple_dates_Table"
			width="100%">
			<thead>
				<tr>
					<%-- <th><liferay-ui:message key="id" /></th> --%>
					<th><liferay-ui:message key="exam-date" /></th>
					<th><liferay-ui:message key="exam-start-time" /></th>
					<th><liferay-ui:message key="exam-end-time" /></th>
					<th><liferay-ui:message key="locate-on-google-map" /></th>
					<th><liferay-ui:message key="venue" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="examMultiDatesItem" items="${examMultiDates}">
				<tr>
					<%-- <td>${examMultiDatesItem.id}</td> --%>
					<td>${examMultiDatesItem.examDate}</td>
					<td>${examMultiDatesItem.startTime}</td>
					<td>${examMultiDatesItem.endTime}</td>
					<td>${examMultiDatesItem.locationOnGoogleMap}</td>
					<td class="d-none">${examMultiDatesItem.locationPinOnGoogleMap}</td>
					<td>${examMultiDatesItem.venue}</td>
					<td class="d-none">${examMultiDatesItem.id}</td>
					<td>
					<input type="hidden" id="updatedExamScheduleAdmnId" name="<portlet:namespace/>updatedExamScheduleAdmnId" value="${examMultiDatesItem.examScheduleAdminId}">
						<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteMDId('${examMultiDatesItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
						<button class="btn mx-2" value="view"  type="button" onclick="editMultExamDateObject('${examMultiDatesItem.id}','edit')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
					  