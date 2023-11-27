<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file = "../../init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="<%=OMSBExamWebPortletKeys.EXAM_APPEAL_LIST%>" />
</portlet:renderURL>

<portlet:actionURL var="WorkflowAssignURL" name="/exam/workflow_action">
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${instanceId}" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
	<portlet:param name="appealId" value="${appealId}" />
</portlet:actionURL>
<portlet:actionURL var="traineeAppealURL" name="/exam/appeal_form"></portlet:actionURL>
<form action="${traineeAppealURL }" method="post" name="admin_appeal_fm" enctype="multipart/form-data" id="admin_appeal_frm">
	<input type="hidden" value="${appealId}" name="<portlet:namespace/>appealId">
	<input type="hidden" value="${assignedToMe}" name="<portlet:namespace/>assignedToMe">
	<input type="hidden" value="${instanceId}" name="<portlet:namespace/>instanceId">
	<input type="hidden" value="${workflowTaskId}" name="<portlet:namespace/>workflowTaskId">
	<input type="hidden" value="${examResult.id}" name="<portlet:namespace/>examResultId">
	<input type="hidden" value="" name="<portlet:namespace/>trName" id="trNameId">
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="supportingDocJsonId" class="d-none">
	<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							<div class="pagetitle"><liferay-ui:message key="admin-appeal-form"/></div>							
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="program-name" /></label> <span
										class="value">${programName }</span>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="exam-type" /></label> <span
										class="value">${examType }</span>
								</div>
							</div>
						</div>
						 <script>
								var tt_cnt= 0;
								</script>
						<c:forEach var="appealStatus" items="${appealStatusList}" varStatus="counter">
							<c:set value="textEditors${counter.index}" var="editorClass"></c:set>
							<div class="d-none classHolderId" >${editorClass}</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label><liferay-ui:message key="reason-for-appeal"/> (${appealStatus.name})<span></span></label>
										<textarea class="form-control textEditors ${editorClass}" data-rich-class="${editorClass}" name="example" readonly="">${appealStatus.reason}</textarea>
									</div>
								</div>
							</div>
							 <script>
								console.log('tt_cnt ??', tt_cnt);
								$('.textEditors'+tt_cnt).richText({preview: true, height: 200});
								tt_cnt++;
							</script> 
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="document-uploaded-by"/> (${appealStatus.name}) </h4>
								<div class="omsb-list-view table-responsive">
									<table class="display omsb-datatables" id="other-documentss-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="document-title"/></th>
												<th><liferay-ui:message key="supporting-document"/></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="document" items="${appealStatus.examDocuments}">
												<tr>
													<td>${document.documentTitle }</td>
													<td><a class="btn upload_btn" title="download" href="${document.fileURL }">
													 <img src="../images/svg/download_icon.svg" alt=""/>${document.fileName }</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:forEach>
						<div class="row">
							<c:if test="${!assignedToMe && not empty trNames}">
								<div class="col-md-12">
									<div class="form-group">
										<label><liferay-ui:message key="reason"/> (<liferay-ui:message key="admin"/>)<span>*</span></label>
										<textarea class="adminReasonEditor" name="<portlet:namespace/>appealComments"></textarea>
									</div>
								</div>
							</c:if>
							<div class="col-lg-6 col-md-6 col-sm-12 mb-4">
								<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
									<h4 class="omsb-card-title"><liferay-ui:message key="old-results"/></h4>
									<div class="row">
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group-dtls">
												<label><liferay-ui:message key="result"/></label> <span
													class="value">${examResult.result }</span>
											</div>
										</div>
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group-dtls">
												<label><liferay-ui:message key="percentage"/></label> <span
													class="value">${examResult.percentage }</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-12 mb-4">
								<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
									<h4 class="omsb-card-title"><liferay-ui:message key="new-results"/></h4>
									<div class="row">
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group">
												<label><liferay-ui:message key="result"/></label>
												
												<select name="<portlet:namespace/>result" id="result" class="custom-select form-control"  ${examAppealStatusValue ne 'Pending' ? 'disabled' : ''} >
													<option value=""><liferay-ui:message key="select"/></option>
													<option value="Pass" ${examResult.result eq 'Pass' ? 'selected' : ''}  ><liferay-ui:message key="pass"/></option>
													<option value="Fail" ${examResult.result eq 'Fail' ? 'selected' : ''}><liferay-ui:message key="fail"/></option>
												</select>
											</div>
										</div>
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group" >
												<label><liferay-ui:message key="percentage"/></label>
												<input type="text" id="percentage" onkeyup="validatePercentage()" value="${examResult.percentage}" 
												name="<portlet:namespace/>percentage" class="form-control" maxlength="5" minlength="1" ${examAppealStatusValue ne 'Pending' ? 'disabled' : ''} >
											</div>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<c:if test="${!assignedToMe && not empty trNames}">
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="add-supporting-document"/>
									<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
										<img src="../images/svg/plus_img.svg" alt="">
										<liferay-ui:message key="add-document"/>
									</button>
								</h4>
								<div class="omsb-list-view table-responsive">
									<table class="omsb-datatables dataTable" id="admin-appeal-supporting-document">
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
						</c:if>	
						
					<span class="text-danger d-none" id="form_error" ><liferay-ui:message key="enter-all-details"/></span>
						<div class="bottom-backbtn-wrap">
							<c:if test="${assignedToMe}">
								<a href="${WorkflowAssignURL} " ><button class="btn omsb-bc-red-button" ><liferay-ui:message key="assign-to-me" /></button></a>
							</c:if>
							<c:if test="${!assignedToMe && not empty trNames}">
								<button class="btn omsb-bc-red-button" type= "button" title="Accept" onclick="saveSupportingDocsForAdmin('Accept',event);"  data-tr="Accept"><liferay-ui:message key="accept"/></button>
								<button class="btn omsb-bg-red-button" type= "button" title="Reject" onclick="saveSupportingDocsForAdmin('Reject',event);"  data-tr="Reject"><liferay-ui:message key="reject"/></button>
							</c:if>
							
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
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Add"  onclick="addAppealSupportingDocument();"><liferay-ui:message key="add"/></button>
				<button class="btn omsb-bc-red-button" type="button" title="Discrad"><liferay-ui:message key="discard"/></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal"><liferay-ui:message key="close"/></button>
			</div>
		</div>
	</div>
</div>	
<script>


$('#other-documentss-table').DataTable({
   /*  "bLengthChange": false,
    "bFilter": false,
    dom: 'Bfrtip', */
    
});


$('#admin-appeal-supporting-document').DataTable({
   /*  "bLengthChange": false,
    "bFilter": false,
    dom: 'Bfrtip', */
});

$(document).ready(function() {
	$('.textEditor1').richText({preview: true, height: 200});
	$('.adminReasonEditor').richText();
});
$('.omsb-datatables').find(".dataTables_empty").parents('tbody').empty();

/* function initDataTable(){
	$('#supporting-documents-table').DataTable({
	    "bLengthChange": false,
	    "bFilter": false,
	    "pageLength": 5,
	    "ordering": false
	});
} */
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
			addTableRow("#addsupportingdocument", "admin-appeal-supporting-document", docTitle, docFileName, docFile, trCounter);
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
		
function validatePercentage(){ 
	var x= $('#percentage').val();
    var val= $('#percentage').val();
    var strLenth= x.length;
    var decIndex=x.indexOf('.');
  	var decLastIndex = x.lastIndexOf('.');
    var isValid=true;
    if(strLenth-1 == decIndex){
        isValid=false;
    }
    var parts = x.split(".");
    if((decIndex != decLastIndex))
    	$('#percentage').val(val.substring(0, val.length - 1));
    
    if (typeof parts[1] == "string" && (parts[1].length == 0 || parts[1].length > 2) && isValid)
    	$('#percentage').val(val.substring(0, val.length - 1));
    var n = parseFloat(x);
    if (isNaN(n))
    	$('#percentage').val(val.substring(0, val.length - 1));
    if (n < 0 || n > 100)
    	$('#percentage').val(val.substring(0, val.length - 1));

	
}
		
function validateAppealAdminForm(){
	if($('.adminReasonEditor').val() != "" &&  $('#admin-appeal-supporting-document_paginate').length >0 ){
		$('#form_error').addClass('d-none');
		return true;
	}else{
		$('#form_error').removeClass('d-none');
		return false;
	}
	
}
function addSupportedDocumentArray(){
	
	var trName = $(event.currentTarget).data('tr');
	console.log('data attr tr ?? ', trName);
	$("#<portlet:namespace/>trName").val(trName);
	 var columnNames = [];
	 $("#admin-appeal-supporting-document thead th").each(function(index) {
		    var columnName = $(this).attr('data-name');
		    columnNames.push(columnName);
		  });
	 console.log('columnNames ??' , columnNames);
	  var tableData = [];
	  $("#admin-appeal-supporting-document tbody tr").each(function() {
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
	  $("#supportingDocJsonId").val(json);
	  return true;
}
		
function saveSupportingDocsForAdmin(key,event) {
	$('#trNameId').val(key);
	var adminDocAdded=addSupportedDocumentArray();

	if(validateAppealAdminForm() && adminDocAdded){
		$('#admin_appeal_frm').submit(); 
	}else{
		 event.preventDefault();
	}
	
 }
		
	</script>