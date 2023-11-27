<%@ include file="../../init.jsp"%>
<portlet:resourceURL
	id="<%=MVCCommands.GET_CONFIRM_REGISTRATION_DETAILS%>" var="confirm" />								

<portlet:actionURL name="<%=MVCCommands.REGISTRATION_CONFIRM_ACTION%>"
	var="registrationConfirmationURL" />

<portlet:resourceURL
	id="<%=MVCCommands.SAVE_EXAM_REGISTRATION_PAYMENT_RESOURCE%>"
	var="saveExamRegistrationPayment" />	
	
	
<a hidden class="btn omsb-btn btn-red" data-toggle="modal" data-target="#exam-confirm-payment" id="exam-openBox"></a>

	
	
   
    <div class="modal fade omsb-modal" id="exam-confirm-payment" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">
                        <liferay-ui:message key="appointment-verification" />
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button> 
                </div>



                <div class="info mt-2 mx-4 px-4">
                    <liferay-ui:message key="payment-verify-msg" />
                </div>
                <div class="modal-body">
 					<form action="${registrationConfirmationURL}" method="post" id="confirmRegistrationFm">
               
					 <input type="hidden" name="<portlet:namespace/>examScheduleId" id="examScheduleId-popup">
					 <input type="hidden" name="<portlet:namespace/>examFees" id="examFees">
					 <input type="hidden" name="<portlet:namespace/>feeType" id="feeType">
					  <input type="hidden" name="<portlet:namespace/>lrUserId" id="regUserId">

                    <div class="omsb-card omsb-card-graybg">
                        <div class="omsb-card-title">
                            <liferay-ui:message key="personal-details" />
                        </div>
                        <div class="row">
                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                <div class="label-name">
                                    <liferay-ui:message key="name" />
                                </div>
                                <div class="label-content" id="userName"></div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                <div class="label-name">
                                    <liferay-ui:message key="phone" />
                                </div>
                                <div class="label-content" id=userphone></div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                    <div class="label-name">
                                        <liferay-ui:message key="email" />
                                    </div>
                                    <div class="label-content" id="useremail"></div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="omsb-card omsb-card-graybg" style="margin: 5px 0 !important;">
                        <div class="omsb-card-title">
                            <liferay-ui:message key="appointment-details" />
                        </div>
                        <div class="row">
                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                <div class="label-name">
                                    <liferay-ui:message key="exam-date-time" />
                                </div>
                                <div class="label-content" id="examDateTime"></div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                <div class="label-name">
                                    <liferay-ui:message key="exam-type" />
                                </div>
                                <div class="label-content" id="userExamTitle"></div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                <div class="label-name">
                                    <liferay-ui:message key="location" />
                                </div>
                                <div class="label-content" id="location"></div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="omsb-card omsb-card-graybg">
                        <div class="omsb-card-title">
                            <liferay-ui:message key="payment-details" />
                        </div>
                        <div class="row">

                            <div class="col-lg-4 col-md-4">
                                <div class="form-group-view">
                                <div class="label-name">
                                    <liferay-ui:message key="exam-fee" />
                                </div>
                                <div class="label-content" id="examFee"></div>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12">
                                <p class="note-label mb-0"><b><liferay-ui:message key="note :" /><liferay-ui:message
                                    key="payment-accept-all-card" /></b></p>
                            </div>
                        </div>
                        
                    </div>


    			</form>  
                </div>
                
                <div class="modal-footer">
                    <button class="btn omsb-bg-red-button" onclick="saveExamRegistrationPayment()" type="button"
                        title="confirm">
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
   <!-- paymenet popup end -->
   
 <div class="d-none" id="paymentFormWrapper"></div>
	
<script>

/*payment popup function  */
function paymentConfirmation(examScheduleId, lruserId) { 
	console.log("payment confirmation popup")
	var examScheduleId12=examScheduleId;
	var lruserId12=lruserId;
				jQuery.ajax({
					type: 'GET',
					url: '<%=confirm%>',
					data: {
						"<portlet:namespace />examScheduleId": examScheduleId12,
						"<portlet:namespace />lrUserId": lruserId12,
						
						
					},
					
					success: function (response) {
						console.log("payment; confirmation")
						console.log(examScheduleId)
						console.log(lruserId12)
						console.log(response)
						 if (response.length > 0) {
							var data = JSON.parse(response);
							$("#userName").text(data.firstName);
							$("#userphone").text(data.mobileNumber);
							$("#useremail").text(data.emailAddress);
							
							$("#examDateTime").text(data.examDate);
							
							$("#examScheduleId-popup").val(examScheduleId);
							console.log("examScheduleId"+$("#examScheduleId").val());
							
							$("#examDateTime").append("( " + data.examstartTime + " to " + data.examEndTime + ")");
							$("#location").text(data.locationOnGoogleMap)
							 $("#userExamTitle").text(data.examType); 
							
							$("#examFee").text(data.feesPaid);
							$("#examFees").val(data.feesPaid);
							$("#feeType").val(data.feeType);
							$("#regUserId").val(lruserId);
							
							
								
							$("#exam-openBox").click();
							event.preventDefault();
							
						 }
						
					},
					error: function () {
						console.log("error")
					}
				});
			}






function makeExamFeePayment(response) {
	
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
	
	
function saveExamRegistrationPayment() {
	var examScheduleId = $("#examScheduleId-popup").val();
	var examFees = $("#examFees").val();
	var lrUserId = $("#regUserId").val();
	
	if (examFees > 0) {
		jQuery.ajax({
			type: 'GET',
			url: '<%=saveExamRegistrationPayment%>',
			data: {
				"<portlet:namespace/>examScheduleId": examScheduleId,
				"<portlet:namespace/>examFees": examFees,
				"<portlet:namespace/>lrUserId": lrUserId,

			},
			success: function (response) {
				console.log(response)
			 	if (response.length > 0) {
					var data = JSON.parse(response);
					if(data.makePayement){
						makeExamFeePayment(response);
					}else{
						$("#confirmRegistrationFm").submit();
					}
				}else{
					$("#confirmRegistrationFm").submit();
				}
			}
		});

	} else {
		$("#confirmRegistrationFm").submit();
	}
}

</script>   