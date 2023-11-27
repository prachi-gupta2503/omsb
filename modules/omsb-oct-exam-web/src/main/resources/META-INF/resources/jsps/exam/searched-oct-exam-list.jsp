<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty octExamsList}">

		<table class="display omsb-datatables" id="octExamList">
			<thead>
				<tr>
					<th><liferay-ui:message key="program" /></th>
					<th><liferay-ui:message key="duration-of-exam-in-hrs" /></th>
					<th><liferay-ui:message key="result-resource" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${octExamsList}" var="octExamDetail">

					<portlet:renderURL var="editOCTExam">
						<portlet:param name="mvcRenderCommandName"
							value="<%=MVCCommandNames.EDIT_OCT_EXAM%>" />
						<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
					</portlet:renderURL>

					<portlet:renderURL var="viewOCTExamDetails">
						<portlet:param name="mvcRenderCommandName"
							value="<%=MVCCommandNames.ADMIN_VIEW_OCT_EXAMS_DETAILS%>" />
						<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
					</portlet:renderURL>

					<portlet:renderURL var="scheduleOCTExam">
						<portlet:param name="mvcRenderCommandName"
							value="<%=MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_RENDER%>" />
						<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
						<portlet:param name="octExamLocateOnGoogleMaps" value="${octExamDetails.getExamJson().getLocationOnGoogleMap()}" />
								<portlet:param name="octExamVenue" value="${octExamDetails.getExamJson().getVenue()}" />
					</portlet:renderURL>

					<tr>
						<td>${octExamDetail.getOCTExamTitle()}</td>
						<td>${octExamDetail.getExamJson().getExamDuration()}</td>
						<td>${octExamDetail.getExamJson().getResultSource()}</td>
						<td><%@ include file="./oct-exam-list-actions.jsp"%>
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
<script>
	$('#octExamList').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"order" : []
	});
</script>