
<%@ include file="../../init.jsp"%>

<c:set var="level" value="${equivalencylevelkey}" />
<c:set var="comments" value="${comments}" />
<c:set var="certificateName" value="${certificateName}" />
<c:set var="certificatefileurl" value="${certificatefileurl}" />

<c:set var="fileUrl" value="${fileUrl}" />


<liferay-portlet:renderURL var="backURL">
<liferay-portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<style>
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
</style>

<div class="container" id="wrapper">
	<div class="omsb-card">


		<div class="omsb-list-view table-responsive">
			<table class="display omsb-tableview" width="100%">
				<thead>
					<tr>
						<th><liferay-ui:message key="name-of-certificate-to-be-evaluated" /></th>
						<th><liferay-ui:message key="equivalency-level" /></th>
						<th><liferay-ui:message key="comments" /></th>
					</tr>
				</thead>
				<tbody>
					<tr class="odd">
						<td><c:if test="${not empty certificatefileurl }">
								<a href="${certificatefileurl}" view ><c:out value="${certificateName}" /></a>
							</c:if></td>
						<td><c:out value="${level}" /></td>
						<td>${comments}</td>
					</tr>
				</tbody>
			</table>
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
			<form id="addmore-supporting-documents">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<aui:select name="type" id="type" label="type" cssClass="form-control" > 
								<aui:option><liferay-ui:message key="select" /></aui:option>
								<c:forEach var="type" items="${documentTypelist}">
									<aui:option value="${type.getKey()}">
										<liferay-ui:message
											key="${type.getName(themeDisplay.getLocale())}" />
									</aui:option>
								</c:forEach>
							</aui:select>
						 <p class="d-none value"  style="color:red;">
							<liferay-ui:message key="please-select-a-value" />
						</p>
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
			</form>
		</div>
	</div>
</div>
<!--  POPUP Modal for new appeal -->


	

	<liferay-portlet:actionURL name="saveFormAppeal"
		var="saveFormAppealURL" />
	<aui:form action="<%=saveFormAppealURL%>" method="post"
		name="save_Appeal" enctype="multipart/form-data">
		<aui:input name="decisionLevelId" type="hidden" value="${decisionLevelId}"></aui:input>
		<aui:input type="hidden" name="supportingDocsAndType"
			id="supporting_docs_rowcount" value="" />
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
							<div class="table-responsive">
								<table class="omsb-datatables no-file-selector w-100" border="0">
									<thead>
										<tr>
											<th><liferay-ui:message key="type" /></th>
											<th><liferay-ui:message key="attachment" /></th>
											<th><liferay-ui:message key="action" /></th>
										</tr>
									</thead>
									<tbody id="dataTable1"></tbody>
								</table>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<label class="my-4"><liferay-ui:message
											key="appeal-comments"></liferay-ui:message> <span
										class="counter"><span class="countered_points">0</span>
											<liferay-ui:message key="/500-remaining"></liferay-ui:message>
									</span></label>
									<textarea onkeyup="countChar(this)" class="appeal-comment"
										required="required" name="<portlet:namespace />comments"
										rows="5" id="comment"></textarea>
									<p id="comment-error" class="error-message text-danger d-none">
										<liferay-ui:message key="this-field-is-required"></liferay-ui:message>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="omsb-card bottom-backbtn-wrap">
			<button class="btn omsb-bc-red-button" type="button"
				onclick="saveSupportingDocument()" id="save">
				<liferay-ui:message key="submit-appeal"></liferay-ui:message>
			</button>
	</aui:form>
	<a class="btn omsb-btn omsb-bg-red-button" href="<%=backURL%>"><i
		class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back"></liferay-ui:message>
	</a>
</div>
</div>

<!--delete popup  -->
		<div class="modal fade omsb-modal" id="equivalency-delete" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->
<script>
$('.appeal-comment').richText();

var addPopUpRow = 0;

function popUp(){
	$("#<portlet:namespace />type").val('');
	$("#<portlet:namespace />file").val('');
	document.getElementById('appeal-popup').style.display='block';
}

function setValues(){
	var A = AUI();
	var selectedValue = A.one("#<portlet:namespace />type").val();
	var file = document.getElementById("<portlet:namespace/>file").files[0];
	
	var isValid = validateFields(); // Call the validateFields() function

	  if (!isValid) {
	    return; // Exit the function if fields are not valid
	  }
  
	var table1 = document.getElementById('dataTable1');
  	addPopUpRow++;
  	var rowCount1 = table1.rows.length;
  	var row1 = table1.insertRow(rowCount1);
  	document.getElementById('appeal-popup').style.display='none';
  	
/*   	var cell1 = row1.insertCell(0);
  	var element2 = document.createElement("select");
  	element2.name = "option" + addPopUpRow;
  	element2.className = "form-control";
  	element2.id = "option" + addPopUpRow;
  	var newOption = document.createElement("option");
  	newOption.value = selectedValue;
  	newOption.text = selectedValue;
  	element2.appendChild(newOption);
  	cell1.appendChild(element2); */
  	
  	var cell1 = row1.insertCell(0);
	var documentTypeElement = document.createElement("input");
	documentTypeElement.type = "text";
	documentTypeElement.value = selectedValue;
	documentTypeElement.readOnly = true;
	documentTypeElement.name = "option" + addPopUpRow;
	documentTypeElement.id = "option" + addPopUpRow;
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
    
    
    

    $("#addmore-supporting-documents .custom-file-label.selected").html("");
    $('#appeal-popup').modal('hide');
   
}


function cancelpopUp(){
	$("#<portlet:namespace />type").val('');
	$("#<portlet:namespace />file").val('');
	$("#addmore-supporting-documents .custom-file-label.selected").html("");
	document.getElementById('appeal-popup').style.display='none';
//	console.log("cnl");
}

function saveSupportingDocument(){
 	var appealData = {};
 	var Appealformvalid=0;
	var appealSupportingDocuments = [];
	var app_textarea = $('#comment').siblings('.richText-editor').text().length;
	console.log('saveSupportingDocument'+app_textarea+' Appealformvalid '+Appealformvalid);
	if(app_textarea != '' && app_textarea != undefined){
		
		Appealformvalid =1;
		$('#comment-error').addClass('d-none');
		console.log('app_textarea if'+app_textarea+' Appealformvalid '+Appealformvalid);
	}
	else{
		$('#comment-error').removeClass('d-none');
	}
	appealData.appealSupportingDocuments = appealSupportingDocuments;
	 for(i =1; i<= addPopUpRow;i++){
	 var optionDataIdx = "option"+i;
	 var supportingDocumentDataIdx = "file"+i;
	 var optionData = document.getElementById(optionDataIdx).value;
	 
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
	 console.log('Appealformvalid '+Appealformvalid);
	 if(Appealformvalid){
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
	var row = $("#equivalency-delete").data("row");
	  row.remove();
	  addPopUpRow--;
	  var deleteModal = $("#equivalency-delete");
		deleteModal.modal('hide');
}







</script>





<style>
.omsb-tableview {
    text-align: left;!important
}

</style>