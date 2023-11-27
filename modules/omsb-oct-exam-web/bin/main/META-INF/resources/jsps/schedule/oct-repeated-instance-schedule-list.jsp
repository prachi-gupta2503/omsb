<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty ocExamMultiDates}">
		<table class="display omsb-datatables" id="Repeated_dates_Table"
			width="100%">
			<thead>
				<tr>
					<%-- <th><liferay-ui:message key="id" /></th> --%>
					
					<th><liferay-ui:message key="days-of-week" /></th>
					<th><liferay-ui:message key="training-site" /></th>
					<th><liferay-ui:message key="exam-slots" /></th>
					<th><liferay-ui:message key="no-of-seats" /></th>
					<th><liferay-ui:message key="action" /></th>
					
					
				</tr>
			</thead>
			<tbody>
			<c:forEach var="examScheduleItem" items="${ocExamMultiDates}">
				<tr>
					
					<td>${examScheduleItem.daysOfWeek}</td>
					<td>${examScheduleItem.examCenterName}</td>
					<td>${examScheduleItem.examSlot}</td>
					<td>${examScheduleItem.noOfSeats}</td>
					
					<td class="d-none">${examScheduleItem.id}</td>
					<td class="d-none">${examScheduleItem.examCenter}</td>
					<td class="d-none">${examScheduleItem.daysOfWeekList}</td>
					<td class="d-none">${examScheduleItem.examSlotList}</td>
					<td>
					<input type="hidden" id="updatedRIExamScheduleAdmnId" name="<portlet:namespace/>updatedRIExamScheduleAdmnId" value="${examScheduleItem.oCExamScheduleAdminId}"/>
						<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-RI-Data-table" data-rowcount="addPopUpRow" onclick="setDeleteRIId('${examScheduleItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
						<button class="btn mx-2" value="view"  type="button" onclick="editRepeatedInstanceExamObject('${examScheduleItem.id}','edit')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>