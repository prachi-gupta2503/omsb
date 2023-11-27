<%@ include file="../../init.jsp" %>

<portlet:renderURL var="traineeLogDutyHoursURL"></portlet:renderURL>

<section class="omsb-main-wrapper" id="omsb-main-wrapper">	
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="view-duty-log-violation-page-title" />
					</div>							
					<c:if test="${isTraineeCalendarView}">
						<div>
							<a href="<%=traineeLogDutyHoursURL%>" class="btn omsb-bc-red-button" type="button">
								<liferay-ui:message key="duty.logs.back.to.calendar" />
							</a>
						</div>
					</c:if>	
				</div>
				
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="requestData">
						<thead>
							<tr>
								<th><liferay-ui:message key="duty-log-violation-program"/></th>
								<th><liferay-ui:message key="duty-log-violation-residency-level"/></th>
								<th><liferay-ui:message key="duty-log-violation-rotation-training-site"/></th>
								<th><liferay-ui:message key="duty-log-violation-block"/></th>
								<th><liferay-ui:message key="duty-log-violation-date"/></th>
								<th><liferay-ui:message key="duty-log-violation-80-hr-rule"/></th>
								<th><liferay-ui:message key="duty-log-violation-24-hr-rule"/></th>
								<th><liferay-ui:message key="duty-log-violation-call-rule-option1"/></th>
								<th><liferay-ui:message key="duty-log-violation-call-rule-option2"/></th>
								<th><liferay-ui:message key="duty-log-violation-short-break-rule"/></th>
								<th><liferay-ui:message key="duty-log-violation-day-off-rule"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dutyLogViolationDTOList}" var="dutyLogViolationDTO">
								<tr>
									<td>${dutyLogViolationDTO.program}</td>
									<td>${dutyLogViolationDTO.residencyLevel}</td>
									<td>${dutyLogViolationDTO.rotaionTrainingName}</td>
									<td>${dutyLogViolationDTO.blockNo}</td>
									<td>${dutyLogViolationDTO.date}</td>
									<td>${dutyLogViolationDTO.acgme80HoursRule}</td>
									<td>${dutyLogViolationDTO.acgme24HoursRule}</td>
									<td>${dutyLogViolationDTO.acgmeCallRuleOption1}</td>
									<td>${dutyLogViolationDTO.acgmeCallRuleOption2}</td>
									<td>${dutyLogViolationDTO.acgmeShortBreakRule}</td>
									<td>${dutyLogViolationDTO.acgmeDayOffRule}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datepicker/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/responsive.bootstrap4.min.js"></script>
	
<aui:script>
	
	$(document).ready(function () {
	
		$('#requestData').DataTable({
			"bLengthChange": false,
			"bFilter": false,
			"paging": true,
			"pageLength": 10
		});

	});

</aui:script>
