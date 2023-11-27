
<%@ include file="../init.jsp"%>

<c:set var="level" value="${equivalencylevelkey}" />
<c:set var="comments" value="${comments}" />
<c:set var="certificateName" value="${certificateName}" />
<c:set var="certificatefileurl" value="${certificatefileurl}" />

<c:set var="fileUrl" value="${fileUrl}" />


<liferay-portlet:renderURL var="backURL">
<liferay-portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<portlet:resourceURL id="deleteEvaluatedCertificates"
	var="deleteEvaluatedCertificates">
</portlet:resourceURL>
<liferay-portlet:actionURL name="saveFormAppeal" var="saveFormAppealURL" />
<!-- <style>
/* Modal Content */
.modal-content {
	background-color: #fefefe;
	z-index: 3;
	top: 6%;
	right: auto;
	left: 9%;
	position: fixed !important;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80% !important;
	box-shadow: 10;
	height: 80% !important;
}
</style> -->
<aui:form action="<%=saveFormAppealURL%>" method="post" name="save_Appeal" enctype="multipart/form-data">
	<aui:input type="hidden" name="equivalencyRequestId" value="${equivalencyRequestId}"></aui:input>
	<aui:input type="hidden" name="equivalencyAppealId" value="${equivalencyAppealId}"></aui:input>
	<aui:input type="hidden" name="supportingDocsAndType" id="supporting_docs_rowcount" value="" />
	<aui:input type="hidden" name="decisionLevelCount" value="${decisionLevelList.size() }" />
	<div class="container" id="wrapper">
		<div class="omsb-card">
			<c:if test="${!isVEHPCEmployer}">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="focal-point" />
				</h4>
				<div class="row">
						<div class="col-lg-4 col-md-3 col-sm-12 label-box">
							<div class="label-name"><liferay-ui:message
									key="full-name" /></div> <div class="label-content">${focalPoint.name}</div>
						</div>

						<div class="col-lg-4 col-md-3 col-sm-12 label-box">
							<div class="label-name"><liferay-ui:message key="email" /></div>
							<div class="label-content">${focalPoint.email}</div>
						</div>

						<div class="col-lg-4 col-md-3 col-sm-12 label-box">
							<div class="label-name"><liferay-ui:message
									key="mobile" /></div> <div class="label-content">${focalPoint.mobileNumber}</div>
						</div>
					</div>
			</c:if>

			<h4 class="omsb-card-title">
				<liferay-ui:message key="request-details" />
			</h4>
			<div class="row">
				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="full-name" /></div> <div class="label-content">${personalDetail.givenNameAsPassport}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="nationality" /></div> <div class="label-content">${personNatinality}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="passport-number" /></div> <div class="label-content">${passportNumber}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="date-of-birth" /></div> <div class="label-content">${dateOfBirth}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message key="email" /></div>
					<div class="label-content">${personalDetail.email}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="mobile" /></div> <div class="label-content">${personalDetail.mobileNumber}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="profession" /></div> <div class="label-content">${personalDetail.profession}</div>
				</div>
				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="primary-specialty" /></div> <div class="label-content">${primarySpecialty}</div>
				</div>
				
				
				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="equivalency-request-id" /></div> <div class="label-content">EQ-${equivalencyRequestId}</div>
				</div>
			</div>
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-tableview" width="100%" id="evaluatedCertificateDataTable">
					<thead>
						<tr>
							<th></th>
							<th><liferay-ui:message key="name-of-certificate-to-be-evaluated" /></th>
							<th><liferay-ui:message key="equivalency-level" /></th>
							<th><liferay-ui:message key="comments" /></th>
							<th class="d-none"><liferay-ui:message key="decision-level-id" /></th>
						</tr>
					</thead>
					<tbody>	
						<c:forEach items="${decisionLevelList}" var="decisionLevel" varStatus="count">
							<c:set var="count" value="${count.index }"></c:set>
							<tr class="odd">
								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox" name="<portlet:namespace/>certCheckBox${count}" 
										id="certCheckBox${count}" class="custom-control-input" 
										<c:if test="${decisionLevel.isEquatedDoc()}">checked="checked"</c:if>
										/>
										<label class="custom-control-label m-0" for="certCheckBox${count}"></label>
									</div>
								</td>
								<td>
									<a href="${decisionLevel.fileUrl}" target="_blank"  >
									<c:out value="${decisionLevel.fileName}" /></a>
								</td>
								<td><c:out value="${decisionLevel.equivalencyLevelId.name}" /></td>
								<td>${decisionLevel.comments}</td>
								<td class="d-none">
									<input type="hidden" name="<portlet:namespace/>decisionLevelId${count}" value="${decisionLevel.id }">
									<input type="hidden" name="<portlet:namespace/>decisionLevelKey${count}" value="${decisionLevel.equivalencyLevelId.key }">
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p id="evaluated-document-error" class="error-message text-danger d-none">
					<liferay-ui:message key="evaluated-document-is-required"></liferay-ui:message>
				</p>
			</div>

		<!--  POPUP Modal for new appeal -->
			<div class="modal fade omsb-modal" id="appeal-popup"
				tabindex="-1" role="dialog"
				aria-labelledby="markInsufficientModalTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">
								<liferay-ui:message key="supporting-documents" />
							</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div id="addmore-supporting-documents">
							<div class="modal-body">
								<div class="row">
									<div class="col-md-12">
										<aui:select name="type" id="type" label="type" cssClass="form-control" > 
											<aui:option><liferay-ui:message key="select" /></aui:option>
											<c:forEach var="type" items="${documentTypelist}">
												<aui:option value="${type.getKey()}" data-name="${type.getName(themeDisplay.getLocale())}">
													<liferay-ui:message
														key="${type.getName(themeDisplay.getLocale())}" />
												</aui:option>
											</c:forEach>
										</aui:select>
									 <p class="d-none value"  style="color:red;">
										<liferay-ui:message key="please-select-a-value" />
									</p>
									</div>
									 <div class="col-md-12  d-none" id="otherDoctypeWrapper">
										<div class="form-group">
										<!--Enter file type while selecting others -->
											<%-- <label hidden id="docTypeLabel"><liferay-ui:message key="enter-file-type" /></label> --%>
											<aui:input id="otherDoctype" name="otherDoctype" type="text" cssClass="form-control" />
										</div>
									</div>
									 <div class="col-md-12">
											<div class="form-group">
												<label> <liferay-ui:message key="attachment"></liferay-ui:message></label>
												<div class="custom-file">
													<aui:input id="file" name="attachment" type="file" label=""
														cssClass="attachment form-control" required="" /> 
														<label class="custom-file-label" for='<portlet:namespace/>file'></label>
															<p class="d-none file" style="color:red;">
																	<liferay-ui:message key="please-select-a-file" />
															</p>
												</div>
											</div>
										</div>	
								</div>
							</div>
							<div class="modal-footer">
								<aui:button type="button" onClick="setValues()" cssClass="btn omsb-bg-red-button yes" value="save"></aui:button>
								<aui:button type="button" onClick="cancelpopUp()"
								cssClass="btn omsb-bc-red-button No" value="cancel"  data-dismiss="modal"
								aria-label="Close"></aui:button>
							</div>
						</div>
					</div>
				</div>
			</div>
		<!--  POPUP Modal for new appeal Ends-->
			<div class="row">
				<div class="col-md-12">
					<div class="omsb-card">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="supporting-documents" />
							<button class="btn omsb-bg-red-button" type="button"
								onClick="popUp()" data-toggle="modal"
								data-target="#appeal-popup">
								<img src="../images/svg/plus_img.svg" alt="">
								<liferay-ui:message key="add" />
							</button>
						</h4>

						<div class="row">
							<input type="hidden" name="documentInfoIdToDelete" value="" id="documentInfoIdToDelete">
							<input type="hidden" name="fileEntryIdToDelete" value="" id="fileEntryIdToDelete">
							<div class="table-responsive" id="supporting-document-data-table">
								<table class="omsb-datatables no-file-selector w-100" border="0" id="supportingDocDataTable">
									<thead>
										<tr>
											<th><liferay-ui:message key="type" /></th>
											<th><liferay-ui:message key="attachment" /></th>
											<th><liferay-ui:message key="action" /></th>
										</tr>
									</thead>
									<tbody id="dataTable1">
									
										<c:forEach var="supportingDocument" items="${supportingDocumentList}" varStatus="counter">
											<c:set var="count" value="${counter.index + 1}" scope="page" />
											<tr id="${supportingDocument.id}">
												<td><input type="text" class="form-control"
													name="supportingDocumentTypeName${count}"
													value="${supportingDocument.evaluateDocTypeName}" readonly="readonly"></td>
												<td><input type="text" class="form-control"
													name="supportingDocumentFileName${count}"
													value="${supportingDocument.dFFileName}" readonly="readonly"></td>
												
												<td><button class="btn delete_btn" type="button"
													title="Delete"
													data-toggle="modal"
													data-target="#equivalency-delete"
													onclick="processDeleteDocument(${supportingDocument.id},${supportingDocument.fileEntryID})">
														<img
														src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
												</button></td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<p id="supporting-error" class="error-message text-danger d-none">
									<liferay-ui:message key="supporting-document-is-required"></liferay-ui:message>
								</p>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<label class="my-4"><liferay-ui:message
											key="appeal-comments"></liferay-ui:message> 
										<span
										class="counter">
										<!-- <span class="countered_points">0</span>
											<liferay-ui:message key="/500-remaining"></liferay-ui:message>
										</span> -->
									</label>
									<textarea class="appeal-comment"
										required="required" name="<portlet:namespace />comments"
										rows="5" id="comment">${appealComment}</textarea>
									<p id="comment-error" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<aui:input type="hidden" name="cmd" id="cmd" value="saveAsDraft" />
			<div class="omsb-card bottom-backbtn-wrap">
				<button class="btn omsb-bc-red-button" type="button"
					onclick="saveSupportingDocument('submit')" id="save">
					<liferay-ui:message key="submit-appeal"></liferay-ui:message>
				</button>
				<button class="btn omsb-bc-red-button" type="button"
					onclick="saveSupportingDocument('saveAsDraft')" id="save">
					<liferay-ui:message key="save-as-draft"></liferay-ui:message>
				</button>
				<a class="btn omsb-btn omsb-bg-red-button" href="<%=backURL%>"><i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back"></liferay-ui:message>
				</a>
			</div>

	<!--delete popup Starts -->
			<div class="modal fade omsb-modal" id="equivalency-delete" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered w-50" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
							<button type="button" class="close" data-dismiss="modal" onclick="handleCloseDeleteDocumentPopup()" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
							<div class="omsb-card omsb-card-graybg row">
								<div>
									<liferay-ui:message key="confirmation-text" />
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn omsb-bc-red-button" type="button" onclick="deleteRow()" title="ok" ><liferay-ui:message key="yes" /></button>
							<button type="button" class="btn omsb-btn omsb-bg-red-button" onclick="handleCloseDeleteDocumentPopup()"
								data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<!--delete popup Ends -->
</aui:form>
<script>
$('.appeal-comment').richText();

var addPopUpRow = 0;

function popUp(){
	$("#<portlet:namespace />type").val('');
	$("#<portlet:namespace />file").val('');
	document.getElementById('appeal-popup').style.display='block';
}

$(document).on('change','#<portlet:namespace />type',function(){
	var selectedDocType = $("#<portlet:namespace />type option:selected").val();
	var otherDoctypeWrapper = $("#otherDoctypeWrapper");
	if(selectedDocType == "others"){
		otherDoctypeWrapper.removeClass("d-none");
	}else{
		otherDoctypeWrapper.addClass("d-none");
	}
});

function setValues(){
	var table1 = document.getElementById('dataTable1');
  	addPopUpRow++;
  	var rowCount1 = table1.rows.length;
	
  	var A = AUI();
	var selectedValue = $( "#<portlet:namespace />type option:selected" ).val();
	var file = document.getElementById("<portlet:namespace/>file").files[0];
	var docTypeName = $( "#<portlet:namespace />type option:selected" ).text().trim();
	var otherDocType = null;

	if(selectedValue == "others"){
		otherDocType =  $("#<portlet:namespace />otherDoctype").val();
		docTypeName = otherDocType;
	}
	console.log('docTypeName ', docTypeName);
	console.log('selectedValue ', selectedValue);
	var isValid = validateFields(); // Call the validateFields() function

	  if (!isValid) {
	    return; // Exit the function if fields are not valid
	  }
  
	
  	var row1 = table1.insertRow(rowCount1);
  	document.getElementById('appeal-popup').style.display='none';
  	
  	var cell1 = row1.insertCell(0);
	var documentTypeElement = document.createElement("input");
	documentTypeElement.type = "text";
	documentTypeElement.value = docTypeName;
	documentTypeElement.readOnly = true;
	documentTypeElement.name = "docTypeName" + addPopUpRow;
	documentTypeElement.id = "docTypeName" + addPopUpRow;
	documentTypeElement.className="form-control";
	cell1.appendChild(documentTypeElement);
	
	var cell2 = row1.insertCell(1);
	var element2 = document.createElement("input");
	element2.type = "file";
	element2.name = "file" + addPopUpRow;
	element2.id = "file" + addPopUpRow;
	element2.readOnly = true;
	element2.className="form-control";
	var container = new DataTransfer();
	container.items.add(file);
	element2.files = container.files; 
	cell2.appendChild(element2);
	document.getElementById("<portlet:namespace />supporting_docs_rowcount").value = addPopUpRow;
	
	var actionCell = row1.insertCell(2);
    var actionElement = document.createElement("button");
    actionElement.className = "btn delete_btn ";
    actionElement.value = "Delete";
    actionElement.type="button"
    var imageElement = document.createElement("img");
    imageElement.src = '<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg';
   
    actionElement.setAttribute('data-toggle', 'modal');
    actionElement.setAttribute('data-target', '#equivalency-delete');
    actionElement.setAttribute('onClick', 'setData(this)');
    
    actionElement.appendChild(imageElement);
    actionCell.appendChild(actionElement);
    
    var cell3 = row1.insertCell(3);
	var documentTypeNameElement = document.createElement("input");
	documentTypeNameElement.type = "hidden";
	documentTypeNameElement.value = selectedValue;
	documentTypeNameElement.readOnly = true;
	documentTypeNameElement.name = "option" + addPopUpRow;
	documentTypeNameElement.id = "option" + addPopUpRow;
	documentTypeNameElement.className="form-control";
	cell3.appendChild(documentTypeNameElement);

	var cell4 = row1.insertCell(4);
	var otherDocTypeNameElement = document.createElement("input");
	otherDocTypeNameElement.type = "hidden";
	otherDocTypeNameElement.value = otherDocType;
	otherDocTypeNameElement.readOnly = true;
	otherDocTypeNameElement.name = "otherDocType" + addPopUpRow;
	otherDocTypeNameElement.id = "otherDocType" + addPopUpRow;
	otherDocTypeNameElement.className="form-control";
	cell4.appendChild(otherDocTypeNameElement);
    

    $("#addmore-supporting-documents .custom-file-label.selected").html("");
    $('#appeal-popup').modal('hide');t
	$("#<portlet:namespace />otherDoctype").val("");
	$("#otherDoctypeWrapper").addClass("d-none");
   
}


function cancelpopUp(){
	$("#<portlet:namespace />type").val('');
	$("#<portlet:namespace />file").val('');
	$("#addmore-supporting-documents .custom-file-label.selected").html("");
	document.getElementById('appeal-popup').style.display='none';
//	console.log("cnl");
}

function saveSupportingDocument(cmd){
	var isSaveasDraft =false;
	if(cmd =='saveAsDraft'){
		isSaveasDraft =true;
	}
 	var appealData = {};
 	var AppealformError=0;
	var appealSupportingDocuments = [];
	if(!isSaveasDraft){
		var app_textarea = $('#comment').siblings('.richText-editor').text().length;
		if(app_textarea != '' && app_textarea != undefined){
			
			
			$('#comment-error').addClass('d-none');
		}
		else{
			AppealformError =1;
			$('#comment-error').removeClass('d-none');
		}
		
		if($("#supportingDocDataTable tr").length > 1){
			$('#supporting-error').addClass('d-none');
		}else{
			AppealformError =1;
			$('#supporting-error').removeClass('d-none');
		}
		var evaluateCertCheckedCount=0;
		$('#evaluatedCertificateDataTable tr').each(function(i) {
		    var chkbox = $(this).find('input[type="checkbox"]');
		    if(chkbox.length) {
		    	if(chkbox.prop('checked')){
		    		evaluateCertCheckedCount++;
		    	}
		    }
		});
		if(evaluateCertCheckedCount>0){
			$('#evaluated-document-error').addClass('d-none');
		}else{
			AppealformError =1;
			$('#evaluated-document-error').removeClass('d-none');
		}
	}
	
	appealData.appealSupportingDocuments = appealSupportingDocuments;
	 for(i =1; i<= addPopUpRow;i++){
	 var optionDataIdx = "option"+i;
	 var supportingDocumentDataIdx = "file"+i;
	 var otherDocTypeId = "otherDocType"+i;
	 var optionData = document.getElementById(optionDataIdx).value;
	 var otherDocType = document.getElementById(otherDocTypeId).value;
	 var supportingDocument = 	document.getElementById(supportingDocumentDataIdx).files[0];
	 var formData = new FormData();
	 formData.append('file',supportingDocument, supportingDocument.name);
	 var fileData = {};
	 fileData.name = supportingDocument.name;
	 fileData.type = supportingDocument.type;
	 var supportingDocuments = {};
	 for (var pair of formData.entries()) {
		 supportingDocuments[pair[0]] = pair[1];
	    }
	 var supportingDocumentWithTittle = {  
	  "optionvalue":optionData,
	  "otherDocType":otherDocType,
	  "documentInputValue":supportingDocumentDataIdx,
	  "File": {
		  "data": supportingDocuments,
		  "name": fileData.name,
		  "type": fileData.type
		  
	  }
	}
	 appealData.appealSupportingDocuments.push(supportingDocumentWithTittle);
		 }
	 $("#<portlet:namespace />supporting_docs_rowcount").val(JSON.stringify(appealData));
	
	 var rowcount=$('#dataTable1 tr').length;
	 if(!AppealformError){
		document.getElementById("<portlet:namespace />cmd").value = cmd;
		submitForm(document.<portlet:namespace />save_Appeal);
	 }
	 else{
		 return false;
	 }
	 
	 

}

function validateFields() {
	  var typeValue = $('#<portlet:namespace />type').val();
	  var attachmentValue = $('#<portlet:namespace />file').val();
	  var isValid = true;

	  // Validate type field
	  if (typeValue === '') {
	    $('#type').addClass('is-invalid');
	    $('.value').removeClass('d-none');
	    isValid = false;
	  } else {
	    $('#type').removeClass('is-invalid');
	    $('.value').addClass('d-none');
	  }

	  // Validate attachment field
	  if (attachmentValue === '') {
	    $('#file').addClass('is-invalid');
	    $('.file').removeClass('d-none');
	    isValid = false;
	  } else {
	    $('#file').removeClass('is-invalid');
	    $('.file').addClass('d-none');
	  }

	  return isValid;
	}
	
function setData(link){
	var row = $(link).closest("tr");
	console.log("row value ",row);
	$("#equivalency-delete").data("row", row);
}
function deleteRow() {
	var documentInfoIdToDelete = $("#documentInfoIdToDelete").val();
	var fileEntryIdToDelete = $("#fileEntryIdToDelete").val();
	
	if(documentInfoIdToDelete != '' && documentInfoIdToDelete != ''){
		confirmDeleteDocument(documentInfoIdToDelete, fileEntryIdToDelete );
		handleCloseDeleteDocumentPopup();
	} else{
		var row = $("#equivalency-delete").data("row");
	  	row.remove();
	  	addPopUpRow--;
	}
	var deleteModal = $("#equivalency-delete");
	deleteModal.modal('hide');
}


	function processDeleteDocument(certificateDocInfoId, fileEntryId) {
		$("#documentInfoIdToDelete").val(certificateDocInfoId);
		$("#fileEntryIdToDelete").val(fileEntryId);
	}
	
	function handleCloseDeleteDocumentPopup() {
		$("#documentInfoIdToDelete").val('');
		$("#fileEntryIdToDelete").val('');
	}

	function confirmDeleteDocument(certificateDocInfoId, fileEntryId) {
		$.ajax({
	      type: 'POST',
	      url: '<%=deleteEvaluatedCertificates.toString()%>',
	      data: {
	        '<portlet:namespace />certificateDocInfoId': certificateDocInfoId,
	        '<portlet:namespace />fileEntryId': fileEntryId
	      },
	      traditional: true,
	      success: function(response) {
	    	  $("#supporting-document-data-table tr#" + certificateDocInfoId).remove();
	      },
	      error: function(xhr, status, error) {
	        // Handle the error if needed
	      }
	    });
	  }

</script>

<style>
.omsb-tableview {
    text-align: left;!important
}

</style>