<%@include file="../../init.jsp" %>

<style>
.bottom-backbtn-wrap{
	display: flex;
   justify-content: end;
   margin-bottom: 20px;
}

.omsb-view-result-box.btns-bottom .buttons-wrap.button-flex {
    display: flex;
    gap: 5px;
    justify-content: center;
}

.omsb-view-result-box .button-flex .btn {
    padding: 10px !important;
}
</style>

	<portlet:resourceURL id="/confirm" var="confirm" />
	<portlet:resourceURL id="<%=MVCCommandNames.SAVE_EXAM_PAYMENT_RESOURCE%>"
		var="saveExamPayment" />
	<portlet:resourceURL id="<%=MVCCommandNames.OCT_CONFIRM_RESCHEDULE%>" var="confirmReschedule" />
	<portlet:actionURL name="<%=MVCCommandNames.REGISTRATION_CONFIRM_ACTION%>" var="registrationConfirmationURL" />

	<div id="wrapper">
		<div class="container">
		<c:if test="${octApplicant}">
			<%-- <div class="omsb-card">
				<div class="omsb-page-top-info m-0">
					<div class="pagetitle">
						<liferay-ui:message key="announce-exams" />
					</div>

					<portlet:renderURL var="viewExamResultListURL">
						<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_RESULTS_LIST%>" />
					</portlet:renderURL>

					<portlet:renderURL var="calenderViewUrl">
						<portlet:param name="mvcPath" value="<%=MVCCommandNames.OCT_EXAM_CALENDER_VIEW_JSP%>" />
					</portlet:renderURL>
					
				</div>
			</div> --%>
			
			<portlet:renderURL var="viewExamResultListURL">
				<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_RESULTS_LIST%>" />
			</portlet:renderURL>
			<div class="bottom-backbtn-wrap">
				<%-- <a class="btn omsb-bc-red-button" href="${calenderViewUrl}"> <liferay-ui:message
						key="calender-view" /> --%>
				 <a class="btn omsb-bc-red-button" href="${viewExamResultListURL}">
					<liferay-ui:message key="view-results" />
				</a>
			</div>		
			
			
			<div class="omsb-card">
			<div class="omsb-list-view table-responsive" id="octExamTitlesTable">
				<table class="display omsb-datatables" id="octExamTitlesList">
					<thead>
						<tr>
							<th><liferay-ui:message key="exam-title" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${octExamDetailsList}" var="octExamDetails">

						 <portlet:renderURL var="registerOCTExam">
								<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_CALENDAR_RENDER%>" />
								 <portlet:param name="examTitle" value="${octExamDetails.getOCTExamTitle()}" /> 
								 <portlet:param name="examTitleId" value="${octExamDetails.getoCExamTitleId()}" /> 
							</portlet:renderURL> 
							<portlet:renderURL var="viewOCTExamDetails">
								<portlet:param name="mvcRenderCommandName"
									value="<%=MVCCommandNames.ADMIN_VIEW_EXAM_SETUP%>" />
								<portlet:param name="octExamId"
									value="${octExamDetails.getId()}" />
									<portlet:param name="role" value="octApplicant" />
							</portlet:renderURL>
							<tr>
								<td><a href="${viewOCTExamDetails}">${octExamDetails.getOCTExamTitle()}</a></td>
								
								<td>
									<a href="${registerOCTExam}">
										<button class="btn register_btn" title="Register">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
											<liferay-ui:message key="register" />
										</button>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
			</c:if>
			<div class="omsb-view-result-list">
				<div class="row">
					<c:forEach var="scheduleExams" items="${examSchedules}">
						<div class="col-lg-4 col-md-6 col-sm-6 mb-cst">
							<div class="omsb-view-result-box btns-bottom">
								<h6>${scheduleExams.octExamTitleName}</h6>
								<div class="row">
									<div class="col-lg-6 col-md-6">
										<div class="form-group-dtls">
											<label><liferay-ui:message key="exam-date" /></label> <span
												class="value">${scheduleExams.examDate}</span>
										</div>
									</div>
									<div class="col-lg-6 col-md-12">
									<div class="form-group-dtls">
										<label><liferay-ui:message key="cost" /></label> <span
											class="value">${scheduleExams.examFees}</span>
									</div>
								</div>
									

									<%-- <div class="col-lg-6 col-md-6">
										<div class="form-group-dtls">
											<label><liferay-ui:message key="exam-start-time" /></label> <span
												class="value">${scheduleExams.examTime}</span>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group-dtls">
											<label><liferay-ui:message key="exam-end-time" /></label> <span
												class="value">${scheduleExams.examEndTime}</span>
										</div>
									</div> --%>
									
									<c:if
										test="${fn:containsIgnoreCase(scheduleExams.regStatus, 'pending') or fn:containsIgnoreCase(scheduleExams.regStatus , 'registered') or fn:containsIgnoreCase(scheduleExams.regStatus , 'cancelled')}">

									<div class="col-lg-6 col-md-6">
										<div class="form-group-dtls">
											<label><liferay-ui:message key="payment-date" /></label> <span
												class="value">${scheduleExams.dateOfPayment}</span>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group-dtls">
											<label><liferay-ui:message key="payment-status" /></label> <span
												class="value">${empty scheduleExams.dateOfPayment ? '' : 'Completed' }</span>
										</div>
									</div>
								
								</c:if>
									<div class="col-lg-6 col-md-6">
										<div class="form-group-dtls">
											<c:if test="${not empty scheduleExams.paymentReceiptUrl}">
												<a class="dropdown-item" href="${scheduleExams.paymentReceiptUrl}" target="_blank"><liferay-ui:message key="payment-receipt" /></a>
											</c:if>
										</div>
										
									</div>
								</div>
								<div class="buttons-wrap button-flex">
											
											<portlet:renderURL var="viewOCTExamScheduleURL">
												<portlet:param name="mvcRenderCommandName"
													value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_RENDER%>" />
												<portlet:param name="octExamScheduleId" value="${scheduleExams.id}" />
												<portlet:param name="role" value="applicant" />
											</portlet:renderURL>
											<c:if
												test="${fn:containsIgnoreCase(scheduleExams.regStatus, 'pending') or fn:containsIgnoreCase(scheduleExams.regStatus , 'registered')}">

												<a href="${viewOCTExamScheduleURL}" class="btn omsb-bc-red-button">
													<liferay-ui:message key="view-schedule" />
												</a>
											</c:if>

											<c:if
												test="${fn:containsIgnoreCase(scheduleExams.regStatus, 'registered')}">
												<a  class="btn omsb-bc-red-button"
													onclick="rescheduleConfirmation(${scheduleExams.octExamDefinitionId},${scheduleExams.id},'${scheduleExams.oCExamTitleKey}', '${scheduleExams.examDate}' ,'${scheduleExams.examTime}','${scheduleExams.examEndTime}' )">
													<liferay-ui:message key="reschedule" />
												</a>
											</c:if>

											<%-- <button class="btn omsb-bc-red-button"
												onclick="confirmReschedule(${scheduleExams.octExamDefinitionId})">
												<liferay-ui:message key="reschedule" /> --%>

										
											<portlet:renderURL var="registerExamURL">
												<portlet:param name="mvcRenderCommandName"
													value="<%=MVCCommandNames.REGISTRATION_FORM%>" />
												<portlet:param name="oCExamScheduleId" value="${scheduleExams.id}" />
											</portlet:renderURL>
											<c:if
												test="${empty scheduleExams.regStatus && scheduleExams.isRegistrationAllowed()}">
												<a href="${registerExamURL}">
													<button class="btn omsb-bc-red-button">
														<liferay-ui:message key="register-now" />
													</button>
												</a>
											</c:if>

											<c:if test="${fn:containsIgnoreCase(scheduleExams.regStatus, 'pending')}">
												<a class="btn omsb-bc-red-button"
													onclick="paymentConfirmation(${scheduleExams.id})">
													<liferay-ui:message key="pay-now" />
												</a>
											</c:if>
											<c:if
												test="${fn:containsIgnoreCase(scheduleExams.regStatus, 'registered')}">


												<%-- <portlet:renderURL var="cancellationExamURL">
													<portlet:param name="mvcRenderCommandName"
														value="<%=MVCCommandNames.APPLICANT_CANCELLATION_RENDER%>" />
													<portlet:param name="examScheduleId" value="${scheduleExams.id}" />
													<portlet:param name="examTitleId"
														value="${scheduleExams.octExamTitleId}" />
													</portlet:renderURL> --%>


													<%-- <a href="${cancellationExamURL}"> --%>
														<a class="btn omsb-bc-red-button"
															onclick="cancelConfirmation(${scheduleExams.octExamDefinitionId},${scheduleExams.id})">
															<liferay-ui:message key="cancel" />
														</a>
														<!-- </a> -->
											</c:if>
										
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>




	
	<!-- Modal payment success message pop up -->
	<div class="modal fade omsb-modal omsb-modal-success" id="successMessage" tabindex="-1" role="dialog" aria-labelledby="successTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-sm modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-success-icon">
						<img src="<%= themeDisplay.getPathThemeImages() %>/images/svg/success.svg" alt="" width="50">
					</div>
					<div class="modal-header justify-content-center">
						<h5 class="modal-title text-center"><liferay-ui:message key="success" /></h5>
					</div>
					<div class="modal-body text-center">
						<p><strong><liferay-ui:message key="thankyou-message" /><br><liferay-ui:message key="payment-success-message" /></strong></p>
						<p><liferay-ui:message key="payment-success-message-subheading" /></p>
					</div>
					<div class="modal-footer justify-content-center">
						<button class="btn omsb-bc-success-button" data-dismiss="modal">Continue</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal payment error message pop up -->
		<div class="modal fade omsb-modal omsb-modal-error" id="errorMessage" tabindex="-1" role="dialog" aria-labelledby="errorTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-sm modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-success-icon">
						<img src="<%= themeDisplay.getPathThemeImages() %>/images/svg/error.svg" alt="" width="50">
					</div>
					<div class="modal-header justify-content-center">
						<h5 class="modal-title text-center"><liferay-ui:message key="error" />!</h5>
					</div>
					<div class="modal-body text-center">
						<p><strong><liferay-ui:message key="thankyou-message" /><br><liferay-ui:message key="payment-error-message" /></strong></p>
						<p><liferay-ui:message key="payment-error-message-subheading" /></p>
					</div>
					<div class="modal-footer justify-content-center">
						<button class="btn omsb-bg-red-button" data-dismiss="modal">Try Again</button>
					</div>
				</div>
			</div>
		</div>

		<portlet:actionURL name="<%=MVCCommandNames.REGISTRATION_CANCEL_ACTION%>" var="registrationCancellationURL" />
		<portlet:resourceURL id="<%=MVCCommandNames.OCT_CONFIRM_RESCHEDULE%>" var="rescheduleConfirmation" />
		<portlet:resourceURL id="<%=MVCCommandNames.OCT_EXAM_CONFIRM_CANCEL%>" var="cancelConfirmation" />

		<button hidden class="btn omsb-btn btn-red" data-toggle="modal" data-target="#cancelConformation"
			id="openCancelConformationBox">Pay
			now</button>
		<form action="${registrationCancellationURL}" method="post" name="" id="cancelRegistration">
				<input type="hidden" id="cancellationFees" name="<portlet:namespace/>cancellationFees">
                <input type="hidden" id="refundRefNo" name="<portlet:namespace/>refundRefNo">
                <input type="hidden" id="trackingId" name="<portlet:namespace/>trackingId">
                <input type="hidden" id="cancellationFeesPercentage"  name="<portlet:namespace/>cancellationFeesPercentage">
		
		
			<div class="modal fade omsb-modal" id="cancelConformation" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">
								<liferay-ui:message key="cancel-registration" />
							</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="hidden" id="<portlet:namespace/>octExamDefinitionId"
								name="<portlet:namespace/>octExamDefinitionId"> <input type="hidden"
								id="<portlet:namespace/>octExamScheduleId" name="<portlet:namespace/>octExamScheduleId">

							<%-- <p id="confirmation-text"><liferay-ui:message
									key="reschedule-cancel-confirmation-msg" />
								</p>
								--%>

								<div id="cancel-box">
									<p id="cancel-msg"></p>
								</div>
						</div>
						<div class="modal-footer">
							<%-- <a class="btn omsb-bc-red-button" href="${viewFutureScheduleExam}"> <liferay-ui:message
									key="view-results" /> --%>

								<button type="button" class="btn omsb-btn omsb-bg-red-button" id="cancellation-confirm"
									onclick="comfirmCancellation()">
									<liferay-ui:message key="confirm" />
								</button>

								<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal">
									<liferay-ui:message key="cancel" />
								</button>
						</div>

					</div>
				</div>
			</div>
		</form>


		<portlet:renderURL var="viewFutureScheduleExam">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EXAM_RESCHEDULE%>" />
		</portlet:renderURL>

		<button hidden class="btn omsb-btn btn-red" data-toggle="modal" data-target="#rescheduleConformation"
			id="openRescheduleConformationBox"></button>
		<form action="${viewFutureScheduleExam}" method="post" name="" id="viewFutureScheduleExam">
			<div class="modal fade omsb-modal" id="rescheduleConformation" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">
								<liferay-ui:message key="reschedule-registration" />
							</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="hidden" id="octExamDefinitionId-reschedule"
								name="<portlet:namespace/>octExamDefinitionId"> <input type="hidden"
								id="octExamScheduleId-reschedule"
								name="<portlet:namespace/>octExamScheduleId">
							<div id="reschedule-box">
								<p id="reschedule-msg"></p>
							</div>
							<input type="hidden" id="reschedulingFeesPercentage"
								name="<portlet:namespace/>reschedulingFeesPercentage">
								
								<input type="hidden" id="<portlet:namespace/>octExamTitleKey"
								name="<portlet:namespace/>octExamTitleKey"> 
								
								<input type="hidden" id="<portlet:namespace/>examDate"
								name="<portlet:namespace/>examDate"> 
								
								<input type="hidden" id="<portlet:namespace/>examStartTime"
								name="<portlet:namespace/>examStartTime"> 
								
								<input type="hidden" id="<portlet:namespace/>examEndTime"
								name="<portlet:namespace/>examEndTime"> 
								
							<input type="hidden" id="octExamRescheduleFees"
								name="<portlet:namespace/>octExamRescheduleFees">
							<input type="hidden" name="<portlet:namespace/>feeType" 
								id="feeType">
						</div>
						<div class="modal-footer">
							<%-- <a class="btn omsb-bc-red-button" href="${viewFutureScheduleExam}"> <liferay-ui:message
									key="view-results" /> --%>
								<button   class="btn omsb-bg-red-button" onclick="saveExamReschedulePayment()"
									title="Confirm">
									<liferay-ui:message key="confirm" />
								</button>
								<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal">
									<liferay-ui:message key="cancel" />
								</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<!-- Payment Form Div -->
		<div class="d-none" id="paymentFormWrapper"></div>
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
		 $('#octExamTitlesList').DataTable({
				"bLengthChange" : false,
				"bFilter" : false,
				"order" : []
			}); 
			$(document).ready(function () {
				console.log("loading...");
				var paymentResponseStatus = localStorage.getItem("paymentResponseStatus");
				if (paymentResponseStatus == 'success') {
					$("#successMessage").modal('show');
					setTimeout(function () {
						$("#successMessage").modal('hide');
					}, 4000);

				} else if (paymentResponseStatus == 'failed') {
					$("#errorMessage").modal('show');
					setTimeout(function () {
						$("#errorMessage").modal('hide');
					}, 4000);
				}
				localStorage.removeItem("paymentResponseStatus");
			});

			function resetPageUrl() {
				window.location.href = window.location.origin
					+ window.location.pathname;
			}

			function getUrlParameter(searchParam) {
				var pageURL = window.location.search.substring(1); 
				var urlVariables = pageURL.split('&');
				var parameterName;
				var i;

				for (i = 0; i < urlVariables.length; i++) {
					parameterName = urlVariables[i].split('=');
					if (parameterName[0] === searchParam) {
							return parameterName[1] === undefined ? null : decodeURIComponent(parameterName[1]);
						}
				}
			}
			
			// To Save Reschedule Payment
			function saveExamReschedulePayment() {
					$('#rescheduleConformation').modal('hide');
					var examScheduleId = $("#octExamScheduleId-reschedule").val();
					var examFees = $("#octExamRescheduleFees").val();
					var feeType = $("#feeType").val();
					if (examFees > 0) {
						jQuery.ajax({
							type: 'GET',
							url: '<%=saveExamPayment%>',
							data: {
								"<portlet:namespace/>examScheduleId": examScheduleId,
								"<portlet:namespace/>fees": examFees,
								"<portlet:namespace/>feeType": feeType,
								
							},
							success: function (response) {
							 	if (response.length > 0) {
									var data = JSON.parse(response);
									if(data.makePayement){
										makeExamResheduleFeePayment(response);
									}else{
										/* $("#viewFutureScheduleExam").submit(); */
									}
								}
							}
						});
					} else {
						$("#viewFutureScheduleExam").submit();
					}
			}
			
			 function makeExamResheduleFeePayment(response) {
					var data = JSON.parse(response); 
					var paymentUrl = data.url; 
					var tid = data.transactionId;
					var currency = data.currency; 
					var amount = data.fees; 
					var order_id = data.orderId;

					$("#paymentFormWrapper").append('<form id = "paymentForm" action = "' + paymentUrl + '" method = "POST" > ');
					$("#paymentFormWrapper form").append('<input type="text" name="tid" id="tid" value="' + tid + '"/></td>');
					$("#paymentFormWrapper form").append('<input type="text" name="order_id" value="' + order_id + '" />');
					$("#paymentFormWrapper form").append('<input type="text" name="currency" value="' + currency + '" />');
					$("#paymentFormWrapper form").append('<input type="text" name="amount" value="' + amount + '" />');
					$("#paymentFormWrapper form").append('<br><input type="submit" id="submitPaymentForm" value="Submit" />');

					$("#paymentFormWrapper form").submit();

				}


			function comfirmSubmitReschedule() {
				$('#rescheduleConformation').modal('hide');
				var id = $("#<portlet:namespace/>popUpOCTExamDefinitionId").val();
				console.log(id);
				document.getElementById("viewFutureScheduleExam").submit();

			}

			function comfirmCancellation() {
                $('#cancelConformation').modal('hide');
                var refund_ref_no = new Date().getTime();                
                $("#refundRefNo").val(refund_ref_no);
                document.getElementById("cancelRegistration").submit();
               
            }

			function rescheduleConfirmation(octExamDefinitionId, octExamScheduleId,octExamTitleKey,examDate,examStartTime,examEndTime) {
				console.log(octExamDefinitionId + "  ::" + octExamScheduleId);
				jQuery.ajax({
					type: 'GET',
					url: '<%=rescheduleConfirmation%>',
					data: {
						"<portlet:namespace />octExamDefinitionId": octExamDefinitionId,
						"<portlet:namespace />octExamScheduleId": octExamScheduleId,
					},
					success: function (response) {

						console.log("response" + response)
						var data = JSON.parse(response);
						console.log(data.reschedulingFees);


						if(data.reschedulingFeesPercentage > 0){
							
						var reshceduleMsg = "<liferay-ui:message key='reschedule-addtional-charge-msg'/>";
						}else{
							var reshceduleMsg = "<liferay-ui:message key='reschedule-addtional-charge-msg-for-zero'/>";
						}


						if (reshceduleMsg != '') {

							reshceduleMsg = reshceduleMsg.replace("?", data.reschedulingFeesPercentage);
						}

						$("#reschedule-msg").html(reshceduleMsg);
						$("#octExamDefinitionId-reschedule").val(octExamDefinitionId);
						$("#octExamScheduleId-reschedule").val(octExamScheduleId);
						$("#reschedulingFeesPercentage").val(data.reschedulingFeesPercentage);
						$("#<portlet:namespace/>octExamTitleKey").val(octExamTitleKey);
						$("#<portlet:namespace/>examStartTime").val(examStartTime);
						$("#<portlet:namespace/>examEndTime").val(examEndTime);
						$("#<portlet:namespace/>examDate").val(examDate);
						$("#octExamRescheduleFees").val(data.reschedulingFees);
						$("#feeType").val(data.feeType);
						$("#openRescheduleConformationBox").click();
					},
					error: function () {
						alert('error');
					}
				});
			}

			function cancelConfirmation(octExamDefinitionId, octExamScheduleId) {

				console.log(octExamDefinitionId + "  ::" + octExamScheduleId);
				jQuery.ajax({
					type: 'GET',
					url: '<%=cancelConfirmation%>',
					data: {
						"<portlet:namespace />octExamDefinitionId": octExamDefinitionId,
						"<portlet:namespace />octExamScheduleId": octExamScheduleId,
					},
					success: function (response) {

						console.log(response)
						var data = JSON.parse(response);
						console.log(data.reschedulingFees);
						console.log(data.cancellationFees);

						var cancelMsg = "<liferay-ui:message key='cancel-refund-msg'/>";

						if (cancelMsg != '') {

							cancelMsg = cancelMsg.replace("?", data.cancellationFeesPercentage);
						}

						$("#cancel-msg").html(cancelMsg);

						$("#<portlet:namespace/>octExamDefinitionId").val(octExamDefinitionId);
						$("#<portlet:namespace/>octExamScheduleId").val(octExamScheduleId);
						$("#trackingId").val(data.trackingId);
						$("#cancellationFees").val(data.cancellationFees);
						$("#cancellationFeesPercentage").val(data.cancellationFeesPercentage);
						$("#openCancelConformationBox").click();
					},
					error: function () {
						alert('error');
					}
				});
			}

			

		</script>
