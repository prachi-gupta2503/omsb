<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty examMultiDates}">
		<table class="display omsb-datatables" id="Repeated_dates_Table"
			width="100%">
			<thead>
				<tr>
					<%-- <th><liferay-ui:message key="id" /></th> --%>
					
					<th><liferay-ui:message key="days-of-week" /></th>
					<th><liferay-ui:message key="exam-start-time" /></th>
					<th><liferay-ui:message key="exam-end-time" /></th>
					<th><liferay-ui:message key="no-of-seats" /></th>
					<th><liferay-ui:message key="locate-on-google-map" /></th>
					<th><liferay-ui:message key="venue" /></th>
					<th><liferay-ui:message key="action" /></th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach var="examScheduleItem" items="${examMultiDates}">
				<tr>
					<%-- <td>${examMultiDatesItem.id}</td> --%>
					<td>${examScheduleItem.daysOfWeek}</td>
					<td>${examScheduleItem.startTime}</td>
					<td>${examScheduleItem.endTime}</td>
					<td>${examScheduleItem.noOfSeats}</td>
					<td>${examScheduleItem.locationOnGoogleMap}</td>
					<td class="d-none">${examScheduleItem.locationPinOnGoogleMap}</td>
					<td>${examScheduleItem.venue}</td>
					<td class="d-none">${examScheduleItem.id}</td>
					<td>
					<input type="hidden" id="updatedRIExamScheduleAdmnId" name="<portlet:namespace/>updatedRIExamScheduleAdmnId" value="${examScheduleItem.examScheduleAdminId}">
						<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-RI-Data-table" data-rowcount="addPopUpRow" onclick="setDeleteRIId('${examScheduleItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
						<button class="btn mx-2" value="view"  type="button" onclick='editRepeatedInstanceExamObject(`${examScheduleItem.id}`,`${examScheduleItem.daysOfWeek}`, `${examScheduleItem.startTime}`, `${examScheduleItem.endTime}`, `${examScheduleItem.noOfSeats}`, `${examScheduleItem.locationOnGoogleMap}`, `${examScheduleItem.locationPinOnGoogleMap}`,`${examScheduleItem.venue}`,`edit`)' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>