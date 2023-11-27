 <%@include file= "../../init.jsp" %>
 <div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="pagetitle"><liferay-ui:message key="reschedule-exams" /></div>

				<portlet:renderURL var="viewExamResultListURL">
					<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_RESULTS_LIST%>" />
				</portlet:renderURL>
				<%-- <div class="bottom-backbtn-wrap">
					<a class="btn omsb-bc-red-button" href="${viewExamResultListURL}">
							<liferay-ui:message key="view-results" />
						</a>
				</div> --%>
			</div>
		</div>
	<input type="hidden" id="<portlet:namespace/>reschedulingFeesPercentage" name="<portlet:namespace/>reschedulingFeesPercentage" value="${reschedulingFeesPercentage}">	
	<div class="omsb-view-result-list">
		<div class="row">
			<c:forEach var="scheduleExams" items="${examSchedules}">
				<div class="col-lg-3 col-md-6 col-sm-6 mb-cst">
					<div class="omsb-view-result-box">
						<h6><liferay-ui:message key="omani-examination-for-nurses" /></h6>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="exam-registration-start-date" /></label> <span class="value">${scheduleExams.registrationStartDate}</span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="exam-registration-end-date" /></label> <span class="value">${scheduleExams.registrationEndDate}</span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="exam-date" /></label> <span class="value">${scheduleExams.examDate}</span>
								</div>
							</div>
							<c:if test = "${scheduleExams.regStatus eq 'pending' or scheduleExams.regStatus eq 'registered'}">
							<div class="col-lg-6 col-md-6">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="payment-date" /></label> <span class="value"></span>
								</div>
							</div>
							<div class="col-lg-6 col-md-6">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="payment-status" /></label> <span class="value">${scheduleExams.regStatus}</span>
								</div>
							</div>
							</c:if>
						</div>
						<div class="buttons-wrap">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6">
								<portlet:renderURL var="viewOCTExamScheduleURL">
									<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_RENDER%>" />
									<portlet:param name="octExamScheduleId" value="${scheduleExams.id}" />
									<portlet:param name="role" value="applicant" />
								</portlet:renderURL>
								
									<a href="${viewOCTExamScheduleURL}">
										<button class="btn omsb-bc-red-button"> <liferay-ui:message key="view-schedule" /></button>
									</a>
									
									
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
								
									
									<portlet:renderURL var="registerExamURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.REGISTRATION_FORM%>" />
										<portlet:param name="oCExamScheduleId" value="${scheduleExams.oCExamScheduleId}" />
										<portlet:param name="reschedulingFeesPercentage" value="${reschedulingFeesPercentage}" />
								</portlet:renderURL>
								<c:if test = "${empty scheduleExams.regStatus}">
									<a href="${registerExamURL}">
										<button class="btn omsb-btn btn-red"> <liferay-ui:message key="register-now" /></button>
									</a>
								</c:if>
							
								
								
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>