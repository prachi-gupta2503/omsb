<%@ include file="../../init.jsp"%>
<%@page import="gov.omsb.common.constants.DataflowConstants"%>

<portlet:resourceURL
	id="<%=MVCCommands.GET_CONFIRM_REGISTRATION_DETAILS%>" var="confirm" />
<portlet:resourceURL
	id="<%=MVCCommands.SAVE_EXAM_REGISTRATION_PAYMENT_RESOURCE%>"
	var="saveExamRegistrationPayment" />
<portlet:actionURL name="<%=MVCCommands.REGISTRATION_CONFIRM_ACTION%>"
	var="registrationConfirmationURL" />

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<portlet:renderURL var="viewExamResultListURL">
					<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_RESULTS_LIST%>" />
				</portlet:renderURL>
				<c:if test="${not empty examSchedules}">
					<div class="bottom-backbtn-wrap">
						<a href="${viewExamResultListURL}"><button class="btn omsb-bc-red-button"><liferay-ui:message key="view-results"/></button></a>
					</div>
				</c:if>
			</div>
		</div>
		<div id="exam-list">
		<div class="omsb-card">
		<div class="omsb-list-view table-responsive" id="exam-trainee-list">
			<table class="display omsb-datatables" id="exam-trainee-list-table">
				<thead>
						<tr>
							
							<th><liferay-ui:message key="exam-type" /></th>
							<th><liferay-ui:message key="program-name" /></th>
							
							<th><liferay-ui:message key="Fees" /></th>
							<th><liferay-ui:message key="exam-date" /></th>
							<th><liferay-ui:message key="exam-start-time" /></th>
							<th><liferay-ui:message key="exam-end-time" /></th>
							<th><liferay-ui:message key="no-of-attempts" /></th>
							
							<th><liferay-ui:message key="status" /></th>
							<th><liferay-ui:message key="action" /></th>
					
						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty examSchedules}">
						<c:forEach var="scheduleExams" items="${examSchedules}">
						<tr>
						
							
							<td>${scheduleExams.examTypeName}</td>
							<td>${scheduleExams.programName}</td>
							
							<td>${scheduleExams.examFees}</td>
						
							<c:choose>
									<c:when
										test="${!scheduleExams.isMultiDates()}" >
										<td>${scheduleExams.examDate}</td>
									</c:when>
									<c:otherwise>
										<td>${scheduleExams.examDate}</td>
									</c:otherwise>
							</c:choose>
							<%-- <td>${scheduleExams.examDate}</td> --%>
							<td>${scheduleExams.startTime}</td>
							<td>${scheduleExams.endTime}</td>
							<td>${scheduleExams.noOfAttempts}</td>
							
							<c:choose>
							     <c:when
										test="${fn:containsIgnoreCase(scheduleExams.examStatus,  'Completed')}">
										<td>${scheduleExams.examStatus}</td>
									</c:when>
									<c:when
										test="${fn:containsIgnoreCase(scheduleExams.registrationStatus,  'Registered')
									or fn:containsIgnoreCase(scheduleExams.registrationStatus,  'Pending')}">
									
										<td>${scheduleExams.registrationStatus}</td>
									</c:when>
									<c:when test="${fn:containsIgnoreCase(scheduleExams.registrationStatus, 'Withdrawn') and fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'Rejected')}">
										<td><liferay-ui:message key="withdraw-rejected" /></td>
									</c:when>
									<c:when test="${fn:containsIgnoreCase(scheduleExams.registrationStatus, 'Withdrawn') and fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'accepted')}">
										<td><liferay-ui:message key="withdraw-accepted" /></td>
									</c:when>
									<c:when test="${fn:containsIgnoreCase(scheduleExams.registrationStatus, 'Withdrawn') and fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'Pending')}">
										<td><liferay-ui:message key="withdraw-pending" /></td>
									</c:when>
									<c:when test="${fn:containsIgnoreCase(scheduleExams.registrationStatus, 'Withdrawn') and fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'Returned')}">
										<td><liferay-ui:message key="withdraw-returned" /></td>
									</c:when>
									<c:otherwise>
										<td>${scheduleExams.examStatus}</td>
									</c:otherwise>
							</c:choose>
							<portlet:renderURL var="SaveRegistrationURL">
										<portlet:param name="mvcRenderCommandName"
											value="<%=MVCCommands.SAVE_REGISTRATION%>" />
										<portlet:param name="examTypeId"
											value="${scheduleExams.examType}" />
										<portlet:param name="programId"
											value="${scheduleExams.programId}" />
										<portlet:param name="examScheduleId"
											value="${scheduleExams.id}" />
										<portlet:param name="role" value="trainee" />
										<c:if
											test="${scheduleExams.registrationStatus eq OMSBExamWebPortletKeys.REGISTERED}">
											<portlet:param name="<%=Constants.CMD%>"
												value="<%=OMSBExamWebPortletKeys.TRAINEE_REGISTRATION_CMD%>" />
										</c:if>
										<c:if
											test="${scheduleExams.registrationStatus ne OMSBExamWebPortletKeys.REGISTERED && scheduleExams.registrationStatus ne OMSBExamWebPortletKeys.WITHDRAWN }">
											<portlet:param name="<%=Constants.CMD%>"
												value="<%=OMSBExamWebPortletKeys.TRAINEE_WITHDRAWAL_CMD%>" />
										</c:if>
							</portlet:renderURL>
							
							
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
										data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
									<portlet:renderURL var="withdrawViewURL">
											<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAM_ADMIN_WITHDRAWAL_VIEW%>" />
											<portlet:param name="withdrawalId" value="${scheduleExams.examWithdrawal.id}" />
									</portlet:renderURL>
									
										<c:if test="${scheduleExams.examStatus == 'Announced'}">
										
											
											<c:choose>
												<c:when
													test="${empty scheduleExams.registrationStatus and scheduleExams.seatsFilled == true}">
													<li><a  class="dropdown-item"> <liferay-ui:message key="register"/></a></li>
												</c:when>

												<c:when test="${empty scheduleExams.registrationStatus }">
													<li><a class="dropdown-item"
														href="${SaveRegistrationURL}"> <liferay-ui:message
															key="register" /></a></li>
												</c:when>
												<c:when
													test="${fn:containsIgnoreCase(scheduleExams.registrationStatus , 'Pending')}">
													<li><a class="dropdown-item"
														onclick="paymentConfirmation(${scheduleExams.id},0)">
														<liferay-ui:message key="pay-now" />
													</a></li>
													
												</c:when>
													<c:when
														test="${fn:containsIgnoreCase(scheduleExams.registrationStatus , 'Registered')}">

														<li><a class="dropdown-item"
															onclick="withdrawalConfirmation(${scheduleExams.examDefinitionId},${scheduleExams.id},'${scheduleExams.programName}','${scheduleExams.examTypeName}')">
															<liferay-ui:message key="withdraw" />
														</a></li>
													</c:when>
													<c:when
														test="${fn:containsIgnoreCase(scheduleExams.registrationStatus, 'Withdrawn') and fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'Returned')}">
														<li><a class="dropdown-item"
															onclick="withdrawalConfirmation(${scheduleExams.examDefinitionId},${scheduleExams.id},'${scheduleExams.programName}','${scheduleExams.examTypeName}')">
															<liferay-ui:message key="resubmit" />
														</a></li>
													</c:when>
													<c:when
														test="${fn:containsIgnoreCase(scheduleExams.registrationStatus, 'Withdrawn') and (fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'Rejected') or fn:containsIgnoreCase(scheduleExams.withdrawStatus, 'Accepted'))}">
														<li><a href="${withdrawViewURL}" class="dropdown-item"><liferay-ui:message key="view-withdraw" /></a></li>
													</c:when>
													
											</c:choose>
											<c:if test="${not empty scheduleExams.paymentReceiptUrl}">
												<li><a class="dropdown-item" href="${scheduleExams.paymentReceiptUrl}" target="_blank"><liferay-ui:message key="payment-receipt" /></a></li>
											</c:if>
											<portlet:renderURL var="viewScheduleExamURL">
												<portlet:param name="mvcRenderCommandName"
													value="<%=MVCCommands.EXAM_SCHEDULE_ACTIONS%>" />
												<portlet:param name="examScheduleId"
													value="${scheduleExams.id}" />
												<portlet:param name="cmd"
													value="<%=DataflowConstants.ACTION_VIEW%>" />
												<portlet:param name="programName"
													value="${scheduleExams.programName}" />
												<portlet:param name="examType"
													value="${scheduleExams.examTypeName}" />
												<portlet:param name="examTypeId"
													value="${scheduleExams.examType}" />
												<portlet:param name="result" value="result" />
												<portlet:param name="examId"
												value="${scheduleExams.examId}" />
											</portlet:renderURL>
											<li>
												<a class="dropdown-item" href="${viewScheduleExamURL}">
													<liferay-ui:message key="view-schedule" />
												</a>
											</li>
										</c:if>
										
											<portlet:renderURL var="viewExamResultURL">
											<portlet:param name="mvcRenderCommandName"
												value="<%=MVCCommands.VIEW_PARTICULAR_EXAM_RESULT%>" />
											<portlet:param name="viewResult"
												value="<%=OMSBExamWebPortletKeys.VIEW_RESULT%>" />
											<portlet:param name="scheduleExamId"
												value="${scheduleExams.id}" />
											<portlet:param name="examDefinitionId"
												value="${scheduleExams.examDefinitionId}" />
											<portlet:param name="programName"
												value="${scheduleExams.programName}" />
											<portlet:param name="examType"
												value="${scheduleExams.examTypeName}" />
											
										</portlet:renderURL>
											
											
											<c:if
											test="${scheduleExams.isResult() and scheduleExams.examStatus == 'Completed'}">
											<li>
											<a class="dropdown-item" href=${viewExamResultURL}>
												<liferay-ui:message key="view-result" />
											</a></li>
										</c:if>
										<c:if
											test="${!scheduleExams.isResult() and scheduleExams.examStatus == 'Completed'}">
											<li disabled class="btn omsb-bc-red-button">
												<liferay-ui:message key="result-yet-to-announce" />
											</button>
										</c:if>
											
											
										
									
								</ul>
								</div>
							</td>
						</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
				</div>
			</div>
			</div>
			</div>
		</div>

<!-- list view -->


	<!-- withdraw model -->

		<portlet:actionURL name="<%=MVCCommands.EXAM_WITHDRAWAL_ACTION%>"
			var="registrationWithdrawalURL" />
		<portlet:resourceURL id="<%=MVCCommands.EXAM_CONFIRM_WITHDRAWAL%>"
			var="withdrawalConfirmation" />
		<portlet:renderURL var="withdrawURl">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommands.EXAM_WITHDRAWAL_RENDER%>" />
		</portlet:renderURL>

		<button hidden class="btn omsb-btn btn-red" data-toggle="modal"
			data-target="#withdrawConformation" id="openWithdrawlConformationBox"></button>
		<form action="${withdrawURl}" method="post" name=""
			id="withdrawRegistration">
			<div class="modal fade omsb-modal" id="withdrawConformation"
				tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">
								<liferay-ui:message key="withdrawal-registration" />
							</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="hidden" id="<portlet:namespace/>examDefinitionId"
								name="<portlet:namespace/>examDefinitionId"> <input
								type="hidden" id="<portlet:namespace/>examScheduleId"
								name="<portlet:namespace/>examScheduleId"> <input
								type="hidden" id="<portlet:namespace/>programName"
								name="<portlet:namespace/>programName"> <input
								type="hidden" id="<portlet:namespace/>examType"
								name="<portlet:namespace/>examType">

							<%-- <p id="confirmation-text"><liferay-ui:message key="reschedule-cancel-confirmation-msg" /></p> 
				 --%>



							<div id="cancel-box">
								<p id="cancel-msg"></p>
							</div>
						</div>
						<div class="modal-footer">
							<%--  <a class="btn omsb-bc-red-button" href="${viewFutureScheduleExam}"> <liferay-ui:message key="view-results" />  --%>

							<button type="button" class="btn omsb-btn omsb-bg-red-button"
								id="cancellation-confirm" onclick="comfirmWithdrawal()">
								<liferay-ui:message key="confirm" />
							</button>

							<button type="button" class="btn omsb-btn omsb-bg-red-button"
								data-dismiss="modal">
								<liferay-ui:message key="cancel" />
							</button>
						</div>

					</div>
				</div>
			</div>

		</form>


<%@ include file="payment-confirmation-popup.jsp"%>

	<div id="successMessage"
			class="alert-notifications-fixed success-message-div d-none">
		<clay:alert displayType="success" title="Success"
				message="Payment Completed successfuly." />
	</div>
	<div id="errorMessage"
			class="alert-notifications-fixed error-message-div d-none">
		<clay:alert displayType="danger" title="error"
			message="Payment is Failed, Please try again later." />
	</div>

<style>
	#errorMessage .alert.alert-danger {
		width: auto;
		font-weight: bold;
	}
	
	#successMessage .alert.alert-success {
		width: auto;
		font-weight: bold;
	}
</style>
<script>

$(document).ready(function () {
	console.log("loading...");
	var paymentResponseStatus = localStorage.getItem("paymentResponseStatus");
	console.log("successMessage"+ paymentResponseStatus);
	if (paymentResponseStatus == 'success') {
		/* $("#successMessage").fadeTo(2000, 500).slideUp(500, function () {
			$("#successMessage").slideUp(500);
		}); */
		
		$("#successMessage").removeClass("d-none");
		setTimeout(function () {
			$("#successMessage").addClass("d-none");
		}, 4000);

	} else if (paymentResponseStatus == 'failed') {
		/* $("#errorMessage").fadeTo(2000, 500).slideUp(500, function () {
			$("#errorMessage").slideUp(500);
		}); */
		$("#errorMessage").removeClass("d-none");
		setTimeout(function () {
			$("#errorMessage").addClass("d-none");
		}, 4000);
	}
	localStorage.removeItem("paymentResponseStatus");
});





function comfirmWithdrawal(){
	
	$('#withdrawConformation').modal('hide');
	var id=$("#<portlet:namespace/>examDefinitionId").val();
	console.log(id);
	document.getElementById("withdrawRegistration").submit();
	
}

function withdrawalConfirmation(examDefinitionId,examScheduleId,programName,examType){
	jQuery.ajax({
		type: 'GET',
		url:  '<%=withdrawalConfirmation %>',
		data:{
			"<portlet:namespace />examDefinitionId": examDefinitionId,
			"<portlet:namespace />examScheduleId": examScheduleId,
			"<portlet:namespace />programName": programName,
			"<portlet:namespace />examType": examType,
		},
		success: function(response) {
			console.log(response)
			if(response != ''){
				var data=JSON.parse(response);
				
				console.log(data.withdrawalFeesPercentage);
				console.log(data.withdrawalFees);
					
				var cancelMsg= "<liferay-ui:message key='cancel-refund-msg'/>";
				
				if(cancelMsg!=''){
					
				cancelMsg=cancelMsg.replace("?", data.withdrawalFeesPercentage);
				}
				
				$("#cancel-msg").html(cancelMsg);
				
				$("#<portlet:namespace/>examDefinitionId").val(examDefinitionId);
				$("#<portlet:namespace/>examScheduleId").val(examScheduleId);
				$("#<portlet:namespace/>programName").val(programName);
				$("#<portlet:namespace/>examType").val(examType);
				$("#openWithdrawlConformationBox").click(); 
			}
		},
		error: function(){
			console.log('error');
		}
	});
}
$('#exam-trainee-list-table').DataTable({
    "bLengthChange": false,
    dom: 'Bfrtip',
	buttons: [
		{
          extend: 'colvis',
          text: '<liferay-ui:message key="column-visibility" />',
          columns: ":not(':last')"
        },
	    {
	        extend: 'collection',
	        text: '<liferay-ui:message key="export-as" />',
	        buttons: [
	            {
	                extend: 'csv',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'pdf',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'excel',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'print',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            }
	        ]
	    }
	],
});
</script>
<style>
#exam-trainee-list-table_wrapper .dataTables_filter {display: none;}
</style>

