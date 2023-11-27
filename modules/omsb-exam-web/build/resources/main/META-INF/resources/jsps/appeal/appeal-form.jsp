<%@include file = "../../init.jsp" %>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="${ MVCCommands.VIEW_RESULTS_LIST}" />
</portlet:renderURL>
<portlet:actionURL var="traineeAppealURL" name="/exam/appeal_form"></portlet:actionURL>
<form action="${traineeAppealURL}" method="post" name="appeal_fm" id="trnAppealForm" enctype="multipart/form-data">
	<input type="hidden" value="${examResultId}" name="<portlet:namespace/>examResultId" id="<portlet:namespace/>examResultId"> 
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson">
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
							<textarea class="appealText" name="<portlet:namespace/>appealComments" id="<portlet:namespace/>appealComments"></textarea>
						</div>
					</div>					
				</div>
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					<h4 class="omsb-card-title"><liferay-ui:message key="add-supporting-document"/>
						<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
							<img src="src="<%=themeDisplay.getPathThemeImages()%>/images/svg/plus_img.svg" alt="">
							<liferay-ui:message key="add-row"/>
						</button>
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="appeal-supporting-documents-table">
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
					 <span class="text-danger d-none" id="appealTable_error" ><liferay-ui:message key="the-blueprint-document-field-is-required"/></span>
				</div>
				<div class="bottom-backbtn-wrap">
					<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="save"/>" onclick="saveSupportingDocs();"><liferay-ui:message key="save"/></button>
					<button class="btn omsb-bc-red-button" title="<liferay-ui:message key="discard"/>"><liferay-ui:message key="discard"/></button>
					<a class="btn omsb-btn btn-back" href="${backURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
				</div>	
			</div>
		</div>
	</div>
</form>

	<div class="modal fade omsb-modal" id="addsupportingdocument" tabindex="-1" role="dialog"
			aria-labelledby="addsupportingdocumentTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-supporting-document"/></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							
							
							<div class="col-md-12">
								<div class="form-group">
									<label class="required" ><liferay-ui:message key="document-title"/></label>
									<input type="text" onkeyup="validateSelectAndInputField('documentTitle','title-error')" maxlength="15"
									placeholder="<liferay-ui:message key="document-title"/>" name="Document Title" id="documentTitle" class="form-control">

									<input type="hidden" name="SuppDocAction" id="supp_doc_action" value="add" class="form-control">
									<input type="hidden" name="SuppRowClass" id="supp_doc_row_class" value="" class="form-control">
									<span class="text-danger d-none" id="title-error" ><liferay-ui:message key="the-document-title-field-is-required"/></span>
								</div>
							</div>
							
							<div class="col-md-12">
								
								<div class="form-group">
									<label class="required"><liferay-ui:message key="supporting-document"/></label>
									<div class="custom-file mb-3">
										<div>
											<input placeholder="<liferay-ui:message key="supporting-document"/>"  type="file" class="custom-file-input" id="supportingFile" name="supportingFile">
										</div>
										<label class="custom-file-label" id="popup_sd_file_label" for="supportingFile">
											<%-- <span class="uploader-value"></span>
											<span class="uploader-title"><liferay-ui:message key="select-file"/></span> --%>
										</label>
										<span class="text-danger d-none" id="file-error" ><liferay-ui:message key="this-field-is-required"/></span>
									</div>
								</div>
								
							</div>
						</div>
					</div>
					<span class="text-danger d-none" id="form_error" ><liferay-ui:message key="enter-all-details"/></span>
									
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="add"/>" onclick="addAppealSupportingDocument();"><liferay-ui:message key="add"/></button>
						<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="discard"/>"><liferay-ui:message key="discard"/></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal"><liferay-ui:message key="close"/></button>
					</div>
				</div>
			</div>
		</div>
		
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
		<portlet:resourceURL id="<%=MVCCommands.EXAM_APPEAL_RESOURCE_COMMAND%>" var="saveExamAppealPayment" />
<script>
		$(document).ready(function() {
			$('.appealText').richText();
			var elements = document.getElementsByClassName("modal-backdrop fade");
			if(elements.length >0){
				for (var i=0; i<elements.length; i++) {
				    elements[i].remove();
				}
			}
		});
		$('.omsb-datatables').find(".dataTables_empty").parents('tbody').empty();
		/* $('#supporting-documents-table').DataTable({
		    "bLengthChange": false,
		    "bFilter": false,
		    "pageLength": 5
		}); */
		
		 $('#appeal-supporting-documents-table').DataTable({
		       /* "bLengthChange": false,
		       "bFilter": false,
		       dom: 'Bfrtip', */
		   });
		
		var trCounter = 0;
		var trClass = "support-doc-tr-"
		function addAppealSupportingDocument(){
			console.log('adding supporting docs starts::::');
			var validDocField=validSupportDocs();
			
			if(validDocField){
				var suppDocAction =  $("#supp_doc_action").val();
				var docTitle = $("#documentTitle").val();
				var docFile = document.getElementById("supportingFile").files[0];
				var docFileName = docFile.name;
				var editedClass = $("#supp_doc_row_class").val();
				
				if (suppDocAction == 'add') {
					console.log('adding row');
					console.log('title ', docTitle, 'fileName ', docFile, '  docFileName  ', docFileName);
					addTableRow("#addsupportingdocument", "appeal-supporting-documents-table", docTitle, docFileName, docFile, trCounter);
					trCounter++;
				} else {
					console.log('editing row');
					updateTableRow(docTitle, docFile, editedClass);
					$("#supp_doc_action").val('add');
					$("#supp_doc_row_class").val('');
				}
				$(".dataTables_empty").remove();
				console.log('adding supporting docs ends');
				$("#addsupportingdocument").modal('hide');
				$("#documentTitle").val('');
				document.getElementById("supportingFile").value = null;
				$("#popup_sd_file_label").html('');
				  $('#appealTable_error').addClass('d-none');
			
			}
		}
	
		function saveSupportingDocsTrainee(event) {
			var docsAdded = addSupportedDocumentArray();
			
			  if(validateAppealTraineeResult() && docsAdded){
				//$('#trnAppealForm').submit();
				  saveAppealPayment();
			 }else{
				 event.preventDefault();
			 }
		}
		
		function saveAppealPayment() {
			var resultId = $("#<portlet:namespace/>examResultId").val();
			var comments = $("#<portlet:namespace/>appealComments").val();
			var jsonData = $("#<portlet:namespace/>supportingDocJson").val();
			var appealFee = $("#<portlet:namespace/>appealFees").val();
			
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
		
		function addSupportedDocumentArray(){
			var columnNames = [];
			$("#appeal-supporting-documents-table thead th").each(function(index) {
				var columnName = $(this).attr('data-name');
				columnNames.push(columnName);
			});
			console.log('columnNames ??' , columnNames);
			var tableData = [];
			$("#appeal-supporting-documents-table tbody tr").each(function() {
				var rowData = {};
			    $(this).find("td").each(function(index) {
			    	
				    var columnName = columnNames[index];
				    rowData[columnName] = $(this).text();
				    console.log('index ??' , index, '  columnName ', columnName, ' rowData[columnName] ?' , rowData[columnName]);
				});
				tableData.push(rowData);
			}); 
			const results = tableData.filter(element => {
				if (Object.keys(element).length !== 0) {
					return true;
				}
				return false;
			});
			var json = JSON.stringify({items:results});
			console.log("jsonData  "+json);
		  	$("#<portlet:namespace/>supportingDocJson").val(json);
			return true;			
		}
		
		function validateAppealTraineeResult(){
			if($('#appealText').val() != "" &&  $('#appeal-supporting-documents-table').length >0 ){
				$('#form_error').addClass('d-none');
				return true;
			}else{
				$('#form_error').removeClass('d-none');
				return false;
			}
		}
		
		function addTableRow(modalId, tableId, title, fileName, docFile){
			console.log('addTableRow >>>>>> title ', title, 'modalId ', modalId, 'fileName ', fileName, '  docFile   ', docFile);
			var element = document.createElement("input");
			element.type = 'file';
			element.name = fileName;
			element.id = fileName;
			var container = new DataTransfer();
			container.items.add(docFile);
			element.className = "form-control supp-docs";
			element.files = container.files;
			
			var newRow = $("<tr>");
			var title = $("<td>").text(title);
			var fileName = $("<td>").text(fileName);
			var row_index = $("#"+tableId+ 'tr:last').index();
			console.log('row_index ', row_index);
			var file = $("<td class='d-none'>").append(element);
			//file = file.text(docFile); 
			var actionCell = $("<td>");
			var dropdownDiv = $("<div>").addClass("dropdown");
			var dropdownBtn = $("<button>").addClass("btn fa fa-ellipsis-v dropdown-toggle").attr({
				"type": "button",
				"data-toggle": "dropdown",
				"aria-expanded": "false"
			});
			var dropdownMenu = $("<ul>").addClass("dropdown-menu");
			var editLink = $("<a>").addClass("dropdown-item");
			editLink = editLink.attr("data-toggle", "modal");
			editLink = editLink.attr("data-target", modalId);
			editLink = editLink.attr("onclick", "editregfee(this); return false;");
			editLink = editLink.attr("href", "#");
			editLink = editLink.append($("<img>").attr("src", "<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg"));
	 		editLink = editLink.append("Edit");
		
			var deleteLink = $("<a>").addClass("dropdown-item").attr("onclick", "deleteRow(this)").attr("href", "#").append($("<img>").attr("src", "<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-equate.svg")).append("Delete");
			dropdownMenu.append($("<li>").append(editLink), $("<li>").append(deleteLink));
			dropdownDiv.append(dropdownBtn, dropdownMenu);
			actionCell.append(dropdownDiv);
			newRow.append(title, fileName, file, actionCell);
			console.log('tableId is ?? ', "#"+tableId);
			  $("#"+tableId).append(newRow);
		}
	</script>