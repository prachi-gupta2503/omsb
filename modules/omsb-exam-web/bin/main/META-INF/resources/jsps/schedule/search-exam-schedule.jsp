<%@ include file="../../init.jsp"%>

<c:choose>
	<c:when test="${!empty examScheduleItem}">
		<table class="display omsb-datatables" id="scheduledExamTable">
							<thead>
								<tr>
									<th><liferay-ui:message key="program-name" /></th>
									<th><liferay-ui:message key="exam-type" /></th>
									<%-- <th><liferay-ui:message key="exam-start-date" /></th>
									<th><liferay-ui:message key="exam-end-date" /></th> --%>
									<th><liferay-ui:message key="exam-date" /></th>
									<th><liferay-ui:message key="status" /></th>
									<th><liferay-ui:message key="action" /></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="examSchedule" items="${examScheduleItem}">
									<portlet:renderURL var="examResultListURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_RESULT_LIST%>" />
										<portlet:param name="examTypeId" value="${examSchedule.examType}" />
										<portlet:param name="programId" value="${examSchedule.program}" />
										<portlet:param name="examScheduleId" value="${examSchedule.id}" />
										<portlet:param name="examDefinitionId" value="${examSchedule.examDefinitionId}" />
										<portlet:param name="examStartDate" value="${examSchedule.examStartDate}" />
										<portlet:param name="examEndDate" value="${examSchedule.examEndDate}" />
										<portlet:param name="examDate" value="${examSchedule.examDate}" />
									</portlet:renderURL>
									<portlet:renderURL var="adminTraineeListURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.ADMIN_TRAINEE_LIST%>" />
										<portlet:param name="programId" value="${examSchedule.program}" />
										<portlet:param name="examTypeId" value="${examSchedule.examType}" />
										<portlet:param name="examScheduleId" value="${examSchedule.id}" />
										<portlet:param name="examDefinitionId" value="${examSchedule.examDefinitionId}" />
									</portlet:renderURL>
									<tr>
										<td>${examSchedule.programName}</td>
										<c:set var="status-class" value=""></c:set>
										<td><c:if
                                                test="${examSchedule.examStatus eq 'Completed'}">
											<a href="${examResultListURL}">${examSchedule.examTypeName}</a>
											<c:set var="status_class" value="omsb-completed-bg"></c:set>
											</c:if> 
											<c:if test="${examSchedule.examStatus eq 'Announced'}">
											<a href="${adminTraineeListURL }">${examSchedule.examTypeName}</a>
											<c:set var="status_class" value="omsb-announced-bg"></c:set>
											</c:if> 
											<c:if test="${examSchedule.examStatus ne 'Announced' and examSchedule.examStatus ne 'Completed'}">
											<a href="#" style="color:black;">${examSchedule.examTypeName}</a>
											<c:set var="status_class" value="omsb-notannounced-bg"></c:set>
											</c:if></td>
										<%-- <td>${examSchedule.applicationStartDate}</td>
										<td>${examSchedule.applicationEndDate}</td> --%>
										<td>${examSchedule.examDate}</td>
										<td><span class="${status_class}">${examSchedule.examStatus}</span></td>
										<td>
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle"
													type="button" data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>

												<portlet:renderURL var="viewExamScheduleURL">
													<portlet:param name="mvcRenderCommandName"
														value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
													<portlet:param name="cmd"
														value="<%=DataflowConstants.ACTION_VIEW%>" />
													<portlet:param name="examScheduleId"
														value="${examSchedule.id}" />
													<portlet:param name="programName"
														value="${examSchedule.programName}" />
													<portlet:param name="examType"
														value="${examSchedule.examTypeName}" />
													<portlet:param name="examId" 
														value="${examSchedule.examId}" />
												</portlet:renderURL>

												<portlet:renderURL var="viewExamSetupURL">
													<portlet:param name="mvcRenderCommandName"
														value="<%=MVCCommands.VIEW_EXAM_SETUP%>" />
													<portlet:param name="examId" value="${examSchedule.examId}" />
													<portlet:param name="cmd" value="viewExam" />
												</portlet:renderURL>

												<portlet:renderURL var="editExamScheduleURL">
													<portlet:param name="mvcRenderCommandName"
														value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
													<portlet:param name="cmd"
														value="<%=DataflowConstants.ACTION_EDIT%>" />
													<portlet:param name="examScheduleId"
														value="${examSchedule.id}" />
													<portlet:param name="programName"
														value="${examSchedule.programName}" />
													<portlet:param name="examType"
														value="${examSchedule.examTypeName}" />
													<portlet:param name="examId" 
														value="${examSchedule.examId}" />
												</portlet:renderURL>

												<ul class="dropdown-menu">
													<li>
														<a href="${viewExamScheduleURL}" class="dropdown-item">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg" />
																<liferay-ui:message key="view-exam-schedule" />
														</a>
													</li>
													<li>
														<a href="${viewExamSetupURL}" class="dropdown-item">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg" />
																<liferay-ui:message key="view-exam-definition" />
														</a>
													</li>
													<li>
														<a href="${editExamScheduleURL}" class="dropdown-item">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg" />
																<liferay-ui:message key="edit-exam-schedule" />
														</a>
													</li>
												</ul>
											</div>
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