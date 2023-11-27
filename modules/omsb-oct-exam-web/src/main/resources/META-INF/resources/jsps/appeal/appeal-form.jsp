<%@include file = "../../init.jsp" %>
<portlet:actionURL var="traineeAppealURL" name="<%=MVCCommandNames.OCT_EXAM_APPEAL_FORM%>"></portlet:actionURL>
<portlet:renderURL var="viewExamResultListURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_OCT_RESULTS_LIST%>" />
</portlet:renderURL>

<form action="${traineeAppealURL}" method="post" name="appeal_fm">
	<input type="hidden" value="${examResultId}" name="<portlet:namespace/>examResultId" id="<portlet:namespace/>examResultId" > 
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson">
	<input type="hidden" value="${appealFees}" name="<portlet:namespace/>appealFees" id="<portlet:namespace/>appealFees">
	<input type="hidden" value="${isReappeal}" name="<portlet:namespace/>isReappeal" id="<portlet:namespace/>isReappeal">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle"><liferay-ui:message key="appeal-request"/></div>							
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="reason"/></label>
							<textarea class="textEditor1" name="<portlet:namespace/>appealComments" id="<portlet:namespace/>appealComments"></textarea>
						</div>
					</div>					
				</div>
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					<h4 class="omsb-card-title"><liferay-ui:message key="add-supporting-document"/>
						<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
							<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="">
							<liferay-ui:message key="add-row"/>
						</button>
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="supporting-documents-table">
							<thead>
								<tr>
									<th data-name="docTitle"><liferay-ui:message key="document-title"/></th>
									<th data-name="fileName"><liferay-ui:message key="supporting-document"/></th>
									<th data-name="file" class="d-none"><liferay-ui:message key="document-file"/></th>
									<th data-name="actions"><liferay-ui:message key="action"/></th>
								</tr>
							</thead>
							<tbody>	
							</tbody>
						</table>
					</div>
				</div>
				<div class="bottom-backbtn-wrap">
					<button type="button" class="btn omsb-bc-red-button" title="<liferay-ui:message key="save"/>" onclick="saveSupportingDocs();"><liferay-ui:message key="save"/></button>
					<button class="btn omsb-bc-red-button" title="<liferay-ui:message key="discard"/>"><liferay-ui:message key="discard"/></button>
					<a class="btn omsb-btn btn-back" href="${viewExamResultListURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
				</div>
			</div>
		</div>
	</div>
	 <%@ include file="../supporting-docs-popup.jsp"%>
	 </form>
	 
		<div class="d-none" id="paymentFormWrapper"></div>
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
		<portlet:resourceURL id="<%=MVCCommandNames.OCT_EXAM_APPEAL_RESOURCE_COMMAND%>" var="saveExamAppealPayment" />
		
		
	<script>
		$(document).ready(function() {
			var elements = document.getElementsByClassName("modal-backdrop fade");
			if(elements.length >0){
				for (var i=0; i<elements.length; i++) {
				    elements[i].remove();
				}
			}
		});	
		
		function validateAppealTraineeResultAndFormSubmit(){
			if($('#appealText').val() != "" &&  $('#appeal-supporting-documents-table').length >0 ){
				$('#form_error').addClass('d-none');
				return true;
			}else{
				$('#form_error').removeClass('d-none');
				return false;
			}
		}
		
		function saveAppealPayment() {
			var resultId = $("#<portlet:namespace/>examResultId").val();
			var comments = $("#<portlet:namespace/>appealComments").val();
			var jsonData = $("#<portlet:namespace/>supportingDocJson").val();
			var appealFee = $("#<portlet:namespace/>appealFees").val();
			debugger;
			jQuery.ajax({
				type: 'GET',
				url: '${saveExamAppealPayment}',
				data: {
					"<portlet:namespace/>examResultId": resultId,
					"<portlet:namespace/>appealComments": comments,
					"<portlet:namespace/>supportingDocJson": jsonData,
					"<portlet:namespace/>appealFees": appealFee,
				},
				success: function (response) {
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
		}
		
		function makeExamFeePayment(response) {
			
			debugger
			var data = JSON.parse(response); 
			var paymentUrl = data.url; 
			var tid = data.transactionId;
			var currency = data.currency; 
			var amount = data.fees;
			var order_id = data.orderId;
			
			$("#paymentFormWrapper").append('<form id="paymentForm" action="' + paymentUrl + '" method = "POST" > ');
			$("#paymentFormWrapper form").append('<input type="text" name="tid" id="tid" value="' + tid + '"/></td>');
			$("#paymentFormWrapper form").append('<input type="text" name="order_id" value="' + order_id + '" />');
			$("#paymentFormWrapper form").append('<input type="text" name="currency" value="' + currency + '" />');
			$("#paymentFormWrapper form").append('<input type="text" name="amount" value="' + amount + '" />');
			$("#paymentFormWrapper form").append('<br><input type="submit" id="submitPaymentForm" value="Submit" />');
			$("#paymentFormWrapper form").submit();
		}
	</script>