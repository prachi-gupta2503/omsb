<%@ include file="../../init.jsp"%>
<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info m-0">
							<div class="pagetitle"><liferay-ui:message key="view-setup-exam"/></div>
						</div>
						<div class="omsb-list-filter omsb-more-btn">
							<div class="row">
								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="program-type"/></label>
									<label class="label-content">${exam.programTypeName}</label>
								</div>
								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="program-name"/></label>
									<label class="label-content"><c:forEach var="program" items="${exam.program}" varStatus="status">
							            ${program.programName}
							             <c:if test="${not status.last}">, </c:if>
							        </c:forEach></label>
								</div>
								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="exam-type"/></label>
									<label class="label-content">${exam.examType}</label>
								</div>

								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="exam-eligibility"/></label>
									<label class="label-content">${exam.examEligibilityName}</label>
								</div>
								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="results-source"/></label>
									<label class="label-content">${exam.resultSource}</label>
								</div>
								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="allowed-no-of-attempt"/></label>
									<label class="label-content">${exam.allowedNoOfAttempt}</label>
								</div>
								<div class="col-md-4 label-box">
									<label class="label-name"><liferay-ui:message key="rule-name"/></label>
									<label class="label-content">${exam.ruleName}</label>
								</div>
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg ">
							<h4 class="omsb-card-title"><liferay-ui:message key="early-bird-fees"/></h4>
							<div class="row">
								<div class="col-md-6 label-box">
									<label class="label-name"><liferay-ui:message key="applicable-days"/></label>
									<label class="label-content">${exam.earlyBirdFeesDate}</label>
								</div>
								<div class="col-md-6 label-box">
									<label class="label-name"><liferay-ui:message key="fee-amount-in-omr"/></label>
									<label class="label-content">${exam.earlyBirdFees}</label>
								</div>
								
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg ">
							<h4 class="omsb-card-title"><liferay-ui:message key="regular-exam"/></h4>
							<div class="omsb-list-view table-responsive">
								<table class="display omsb-datatables datatables1" >
									<thead>
										<tr>
											<th><liferay-ui:message key="attempt-number"/></th>
											<th><liferay-ui:message key="regular-fees-amount-in-omr"/></th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="regularFee"items="${exam.regularFees}" >
									<tr>
										<td data-value="${regularFee.noOfAttempts}">${regularFee.noOfAttempts}</td>
										<td data-value="${examEligibility2.examEligibility}">${regularFee.regularFee}</td>									      
									 </tr>
									 </c:forEach>
									</tbody>
								</table>
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg ">
							<h4 class="omsb-card-title"><liferay-ui:message key="cancellation-fees"/></h4>
							<div class="omsb-list-view table-responsive">
								<table class="display omsb-datatables datatables1" >
									<thead>
										<tr>
											<th><liferay-ui:message key="days-before-exam"/></th>
											<th><liferay-ui:message key="refund-percentage"/></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="withdrawalFee"items="${exam.withdrawalFees}"  >
										<tr>
											<td data-value="${withdrawalFee.noOfDaysText}">${withdrawalFee.noOfDaysText}</td>
											<td data-value="${withdrawalFee.withdrawalFeesPercentage}">${withdrawalFee.withdrawalFeesPercentage}</td>									      
										 </tr>
										 </c:forEach>
										</tbody>
								</table>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6 label-box">
								<label class="label-name"><liferay-ui:message key="appeal-window"/><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days After Results Are Announced"></label>
								<label class="label-content">${exam.appealWindow}</label>
							</div>
							<div class="col-md-6 label-box">
								<label class="label-name"><liferay-ui:message key="appeal-fees"/></label>
								<label class="label-content">${exam.appealFees}</label>
							</div>

							<div class="col-md-6 label-box">
								<label class="label-name"><liferay-ui:message key="re-appeal-window"/><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days After Results Are Announced"></label>
								<label class="label-content">${exam.reAppealWindow}</label>
							</div>
							<div class="col-md-6 label-box">
								<label class="label-name"><liferay-ui:message key="re-appeal-fees"/></label>
								<label class="label-content">${exam.reAppealFees}</label>
							</div>

						</div>
						
						
						
						
						<portlet:renderURL var="examHomeURL">
							<portlet:param name="mvcRenderCommandName" value="/" />
							<portlet:param name="searchProgramId" value="${searchProgramId}" />
							<portlet:param name="searchExamTypeId" value="${searchExamTypeId}" />
						</portlet:renderURL>
						
						<portlet:renderURL var="examScheduleURL">
							<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAMS_SCHEDULE_LIST%>" />
						</portlet:renderURL>
						
						
					<c:if test="${viewExamSchedule eq 'viewExamSchedule'}">	
						<div class="bottom-backbtn-wrap">
							<a class="btn omsb-btn btn-back" href="${examScheduleURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</div>
					</c:if>
						
					
					<c:if test="${viewExamSchedule ne 'viewExamSchedule'}">	
						<div class="bottom-backbtn-wrap">
							<a class="btn omsb-btn btn-back" href="${examHomeURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</div>
					</c:if>
						
					</div>
				</div>
			</div>
			
			
<script>

$('.datatables1').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "bFilter": false,
    "pageLength": 2
}); 
</script>			