<%@ include file="/init.jsp"%>
<table class="display omsb-datatables" id="exam-list-table">
					<thead>
						<tr>
							<th><liferay-ui:message key="program-name" /></th>
							<th><liferay-ui:message key="exam-type" /></th>
							<th><liferay-ui:message key="result-source" /></th>
							<th><liferay-ui:message key="action" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var = "exam" items="${exams}" >
						<tr>
							<td><c:forEach var="program" items="${exam.program}" varStatus="status">
					            ${program.programName}
					             <c:if test="${not status.last}">, </c:if>
					        </c:forEach></td>
							<td>${exam.examType }</td>
							<td>${exam.resultSource }</td>
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
										data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<portlet:renderURL var="editExamSetupURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.NEW_EXAM_SETUP%>" />
										<portlet:param name="examId" value="${exam.id}" />
										<portlet:param name="cmd" value="editExam" />
										<portlet:param name="searchProgramId" value="${programId}" />
										<portlet:param name="searchExamTypeId" value="${examTypeId}" />
									</portlet:renderURL>
									<portlet:renderURL var="viewExamSetupURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_EXAM_SETUP%>" />
										<portlet:param name="examId" value="${exam.id}" />
										<portlet:param name="cmd" value="viewExam" />
										<portlet:param name="searchProgramId" value="${programId}" />
										<portlet:param name="searchExamTypeId" value="${examTypeId}" />
									</portlet:renderURL>
									
									
									<portlet:renderURL var="addExamScheduleURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
										<portlet:param name="cmd" value="<%=DataflowConstants.ACTION_ADD%>" />
										<portlet:param name="examType" value="${exam.examType}" />
										<portlet:param name="examTypeId" value="${exam.examTypeId}" />
										<portlet:param name="searchProgramId" value="${programId}" />
										<portlet:param name="searchExamTypeId" value="${examTypeId}" />
									</portlet:renderURL> 
									
									
									
									<ul class="dropdown-menu">
										<li><a href="${editExamSetupURL}" class="dropdown-item"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"> <liferay-ui:message key="edit"/></a></li>
										<li><a href="${viewExamSetupURL}" class="dropdown-item"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg"> <liferay-ui:message key="view"/></a></li>
										<li><a href="${addExamScheduleURL}" class="dropdown-item"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-calendar.svg"><liferay-ui:message key="schedule" /></a></li>
									</ul>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>