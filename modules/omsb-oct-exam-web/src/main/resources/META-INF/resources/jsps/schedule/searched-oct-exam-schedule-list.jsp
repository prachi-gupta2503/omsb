<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty octExamScheduleList}">
		<table class="display omsb-datatables" id="octExamScheduleList">
			<thead>
				<tr>
					<th><liferay-ui:message key="exam-title" /></th>
					<th><liferay-ui:message key="exam-date" /></th>
					<th><liferay-ui:message key="registration-start-date" /></th>
					<th><liferay-ui:message key="registration-end-date" /></th>
					<th><liferay-ui:message key="status" /></th>
					<th><liferay-ui:message key="actions" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${octExamScheduleList}" var="octExamSchedule">
							<portlet:renderURL var="editOCTExamSchedule">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.EDIT_OCT_EXAM_SCHEDULE_RENDER%>" />
								<portlet:param name="octExamScheduleId"
									value="${octExamSchedule.getId()}" />
							</portlet:renderURL>

							<portlet:renderURL var="viewOCTExamSchedule">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_RENDER%>" />
								<portlet:param name="octExamScheduleId"
									value="${octExamSchedule.getId()}" />
								<portlet:param name="role" value="admin" />	
							</portlet:renderURL>

							<portlet:renderURL var="viewUploadResultScreen">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.VIEW_UPLOAD_RESULT_SCREEN_RENDER%>" />
							</portlet:renderURL>

							<portlet:renderURL var="viewEligibleTraineesList">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.VIEW_ELIGIBLE_TRAINEES_LIST_RENDER%>" />
								<portlet:param name="departmentId"
									value="${octExamSchedule.getDepartmentId()}" />
									<portlet:param name="sectionId"
									value="${octExamSchedule.getSectionId()}" />
									<portlet:param name="examDefinitionId"
									value="${octExamSchedule.getOctExamDefinitionId()}" />
									<portlet:param name="examScheduleId"
									value="${octExamSchedule.getId()}" />
									
							</portlet:renderURL>
							<portlet:renderURL var="examResultListURL">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.OCT_EXAM_RESULT_LIST%>" />
								<portlet:param name="examScheduleId"
									value="${octExamSchedule.getId()}" />
								<portlet:param name="examTitle"
									value="${octExamSchedule.getOctExamTitleName()}" />
								<portlet:param name="startDate"
									value="${octExamSchedule.getRegistrationStartDate()}" />
									
								<portlet:param name="examTitle"
									value="${octExamSchedule.getOctExamTitleName()}" />	
							</portlet:renderURL>
							
							<portlet:renderURL var="viewOCTExamDetails">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.ADMIN_VIEW_EXAM_SETUP%>" />
								<portlet:param name="definitionId"
									value="${octExamSchedule.getOctExamDefinitionId()}" />
								<portlet:param name="viewDefinition"
									value="viewDefinition" />
							</portlet:renderURL>
							
							
							
							<liferay-portlet:actionURL name="<%=MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_ACTION%>"
							var="examScheduleActions" />
	
							
							<tr>
								<c:choose>
									<c:when
										test="${octExamSchedule.getExamStatusName() eq 'Completed'}">
										<td><a href="${examResultListURL}">${octExamSchedule.getOctExamTitleName()}</a></td>
									</c:when>
									<c:when
										test="${octExamSchedule.getExamStatusName() eq 'Announced' || octExamSchedule.getExamStatusName() eq 'Rescheduled'}">
									<td><a href="${viewEligibleTraineesList}">${octExamSchedule.getOctExamTitleName()}</a></td>
									</c:when>	
									<c:otherwise>
										<td>${octExamSchedule.getOctExamTitleName()}</td>
									</c:otherwise>
								</c:choose>

						<td>${octExamSchedule.getExamDate()}</td>
						<td>${octExamSchedule.getRegistrationStartDate()}</td>
						<td>${octExamSchedule.getRegistrationEndDate()}</td>
						<td><span class="${octExamSchedule.getExamStatusColor()}">${octExamSchedule.getExamStatusName()}</span></td>
						<td><%@ include file="./oct-exam-list-schedule-actions.jsp"%>
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
	$('#octExamScheduleList').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"order" : []
	});
</script>