console.log('testing this');

$(document).ready(function() {
	$('.textEditor1').richText();
	$('.textEditor2').richText();
	$('.textEditor3').richText();
});
$("#supporting-doc-discard").modal("hide");
$('.omsb-datatables').find(".dataTables_empty").parents('tbody').empty();
$('.supporting-docs-add-row').DataTable({
    "bLengthChange": false,
    "bFilter": false,
    "pageLength": 5
});

var searchTable =$('.oc-exam-wf-datatable').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "pageLength": 15
});

var searchRescheduleTable =$('.oc-exam-wf-res-datatable').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "pageLength": 15
});

$(".cancel-search").on('click', function(){
	console.log('calling this click fns::');
	var title = $('#cancel-examTitle').val();
	var traineeName = $('#cancel-traineename').val();
	if (title && !traineeName){
		console.log('title not empty:');
		searchTable.column(0).search('').draw();
		searchTable.column(1).search('').draw();
		searchTable.column(0).search(title).draw();
	} else if (!title && traineeName ){
		console.log('traineeName not empty:');
		searchTable.column(0).search('').draw();
		searchTable.column(1).search('').draw();
		searchTable.column(1).search(traineeName).draw();
	}
	else if (title && traineeName) {
		console.log('both are not empty:');
		searchTable.column(0).search('').draw();
		searchTable.column(1).search('').draw();
		searchTable.column(0).search(title).draw();
		searchTable.column(1).search(traineeName).draw();
	} else {
		searchTable.column(0).search('').draw();
		searchTable.column(1).search('').draw();
	}
});

$(".reschedule-search").on('click', function(){
	var title = $('#reschedule-examTitle').val();
	var traineeName = $('#reschedule-traineename').val();
	if (title && !traineeName){
		console.log('title not empty:');
		searchRescheduleTable.column(0).search('').draw();
		searchRescheduleTable.column(1).search('').draw();
		searchRescheduleTable.column(0).search(title).draw();
	} else if (!title && traineeName ){
		console.log('traineeName not empty:');
		searchRescheduleTable.column(0).search('').draw();
		searchRescheduleTable.column(1).search('').draw();
		searchRescheduleTable.column(1).search(traineeName).draw();
	}
	else if (title && traineeName) {
		console.log('both are not empty:');
		searchRescheduleTable.column(0).search('').draw();
		searchRescheduleTable.column(1).search('').draw();
		searchRescheduleTable.column(0).search(title).draw();
		searchRescheduleTable.column(1).search(traineeName).draw();
	} else {
		searchRescheduleTable.column(0).search('').draw();
		searchRescheduleTable.column(1).search('').draw();
	}
});


var trCounter = 0;
var trClass = "support-doc-tr-"
function addSupportingDocs(){
	console.log('adding supporting docs starts::::');
	var suppDocAction =  $("#supp_doc_action").val();
	var docTitle = $("#documentTitle").val();
	var docFile = document.getElementById("supportingFile").files[0];
	var docFileName = docFile.name;
	var editedClass = $("#supp_doc_row_class").val();
	/*var values = [];
	values.push(values);
	values.push(docFile);
	values.push(docFileName);*/
	/* if (!docTitle && docFileName) {
		$('#title-error').removeClass('d-none')
		$('#file-error').addClass('d-none')
		return;
	} else if(docTitle && !docFileName){
		$('#title-error').addClass('d-none')
		$('#file-error').removeClass('d-none')
		return;
	} else if(!docTitle && !docFileName){
		$('#title-error').removeClass('d-none')
		$('#file-error').removeClass('d-none')
		return;
	}else if (docTitle && docFileName){
		$('#title-error').addClass('d-none')
		$('#file-error').addClass('d-none')
		return;
	} */
	
	if (suppDocAction == 'add') {
		console.log('adding row');
		console.log('title ', docTitle, 'fileName ', docFile, '  docFileName  ', docFileName);
		addTableRow("#addsupportingdocument", "supporting-documents-table", docTitle, docFileName, docFile, trCounter);
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
}

function saveSupportingDocs(event) {
	 console.log('namespace ??' , namespace);
	 var trName = $(event).attr('data-tr');
	 console.log('data attr tr ?? ', trName);
	 $("#"+namespace + "trName").val(trName);
	const columnNames = $("#supporting-documents-table thead th").map(function() {
		  return $(this).attr('data-name');
		}).get();

	 console.log('columnNames ??' , columnNames);

	 const tableData = $("#supporting-documents-table tbody tr").map(function() {
		  const rowData = {};
		  $(this).find("td").each(function(index) {
		    rowData[columnNames[index]] = $(this).text();
		    console.log('index ??', index, '  columnName ', columnNames[index], ' rowData[columnNames[index]] ?', rowData[columnNames[index]]);
		  });
		  return rowData;
		}).get();
	  
	  const results = tableData.filter(element => Object.keys(element).length !== 0);

	  var json = JSON.stringify({items:results});
	  console.log("jsonData  "+json);
	  $('#' + namespace + 'supportingDocJson').val(json);
	  
	  saveAppealPayment();
 }

/*function saveSupportingDocsTrainee(event) {
	var docsAdded = addSupportedDocumentArray();
	if(validateAppealTraineeResult() && docsAdded){
		//$('#trnAppealForm').submit();
		saveAppealPayment();
	}else{
		event.preventDefault();
	}
}*/

function addTableRow(modalId, tableId, title, fileName, docFile, trCounter){
	var className = trClass + trCounter;
	console.log('addTableRow >>>>>> title ', title, 'modalId ', modalId, 'fileName ', fileName, '  docFile   ', docFile, ' trCounter ', trCounter);
	var element = document.createElement("input");
	element.type = 'file';
	element.name = 'docInput_'+trCounter;
	element.id = className;
	var container = new DataTransfer();
	container.items.add(docFile);
	element.className = "form-control supp-docs";
	element.files = container.files;
	
	var newRow = $('<tr class="'+className+'">');
	var title = $("<td>").text(title);
	var fileName = $("<td>").text(fileName);
	var file = $("<td class='d-none'>").append(element);
	var rowNumber = $("<td class='d-none'>").text(trCounter);
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
	editLink = editLink.attr("onclick", "editSupportDocRow(this); return false;");
	editLink = editLink.attr("href", "#");
	editLink = editLink.append($("<img>").attr("src", imagePath + '/svg/fi-rr-eye.svg'));
	editLink = editLink.append("Edit");

	var deleteLink = $("<a>").addClass("dropdown-item").attr("onclick", "deleteSupportDocRow(this)").attr("href", "#");
	deleteLink = deleteLink.attr("data-toggle", "modal");
	deleteLink = deleteLink.attr("data-target", "#delete_row");
	deleteLink = deleteLink.append($("<img>").attr("src", imagePath + "/svg/fi-rr-equate.svg")).append("Delete");
	dropdownMenu.append($("<li>").append(editLink), $("<li>").append(deleteLink));
	dropdownDiv.append(dropdownBtn, dropdownMenu);
	actionCell.append(dropdownDiv);
	newRow.append(title, fileName, file, rowNumber, actionCell);
	console.log('tableId is ?? ', "#"+tableId);
	  $("#"+tableId).append(newRow);
}

function editSupportDocRow(id){
	console.log('calling is ?? ');
	//var rowFile = $(id).closest('tr').find("td:nth-child(3) input[type='file']").files[0];
	var editDocTitle = $(id).closest('tr').find("td:nth-child(1)").html();
	var editFileTitle = $(id).closest('tr').find("td:nth-child(2)").html();
	var rowClass= $(id).closest('tr').attr('class');
	var editFile = document.getElementById(rowClass).files[0];
	console.log('ss is ?? '+rowClass);
	console.log('editFile is ?? '+editFile.name);
	console.log('editDocTitle is ?? '+editDocTitle);
	$("#documentTitle").val(editDocTitle);
	$("#supp_doc_action").val('edit');
	$("#popup_sd_file_label").html(editFileTitle);
	$("#supp_doc_row_class").val(rowClass);
	var container1 = new DataTransfer();
	container1.items.add(editFile);
	document.getElementById("supportingFile").files = null;
	document.getElementById("supportingFile").files = container1.files;
}

function updateTableRow(docTitle, docFile, editedClass){
	
	console.log('calling updateTableRows ?? ', editedClass);
	var editDocTitle = $("."+editedClass).find("td:nth-child(1)").html(docTitle);
	var editFileTitle = $("."+editedClass).find("td:nth-child(2)").html(docFile.name);
}

function deleteSupportDocRow(id){
	
	var rowClass= $(id).closest('tr').attr('class');
	$(id).closest("tr").addClass("select_delete_row");
	var tableId = $(id).closest("tr").closest("table").attr("id");
	$("#delete_row").attr("delete_table_id",tableId);
	$("#supp_doc_row_class").val(rowClass);
	
}

function validateSelectAndInputField(id,errorId){
	var keyVal = $('#'+id).val();
    if (keyVal != undefined && keyVal != '') {
        $('#'+errorId).addClass('d-none');
        return true;
    } else {
        $('#'+errorId).removeClass('d-none');
        return false;
    }
    
}
function validateFile() {
    var inputElement = document.getElementById('supportingFile');
    var files = inputElement.files;
    if(files.length==0){
    	$('#file-error').removeClass('d-none');
        return false;
    }
  
    var fileSize = files[0].size;
  
    /* 1024 = 1MB */
    var size = Math.round((fileSize / 1024));
    $('#file-error').addClass('d-none');
    return true;
   /*  checking for less than or equals to 2MB file size 
    if (size <= 2*1024) {
        alert("Valid file size");
         file uploading code goes here... 
    } else {
        alert(
          "Invalid file size, please select a file less than or equal to 2mb size");
    }*/
}
function validSupportDocs(){
	var fileValid=validateFile();
	var title=validateSelectAndInputField('documentTitle','title-error');
	if(fileValid && title){
		return true;
	}else{
		return false;
	}
}

function closePopUp(){
	 $('#file-error').addClass('d-none');
	 $('#title-error').addClass('d-none');
	 $('#regular_fee_error').addClass('d-none');
	 $('#attempt_number_error').addClass('d-none');
	 $('#refund_percentage_c_error').addClass('d-none');
	 $('#days_before_c_error').addClass('d-none');
	 $('#days_before_error').addClass('d-none');
	 $('#refund_percentage_error').addClass('d-none');
	 $("#regular_fee_modal").data("editRow", "");
	 $('#refund_percentage').val('');
	 $('#documentTitle').val('');
	 $('#regular_fee').val('');
	 $('#attempt_number').val('');
	 $('#refund_percentage').val('');
	 $('#days_before_c').val('');
	 $('#days_before').val('');
	 $('#refund_percentage_c').val('');
	 $(".reschedulingInputs" ).each(function() {
		 $(this).val('');
	});
	 $(".cancellationfeesInputs" ).each(function() {
		 $(this).val('');
	});
}

$('#addsupportingdocument , #regular_fee_modal , #cancellationfees , #reschedulingfees').on('hidden.bs.modal', function (e) {
	 closePopUp();
})

$("#fee_amount , #regular_fee").on("keyup", function(){
	var id=this.id;
	var valid = /^\d{0,9}(\.\d{0,2})?$/.test(this.value),
    val = this.value;
	validateSelectAndInputField(id,id+'_error');
	 if (val != undefined && val != '') {
	        if(!valid){
			    console.log("Invalid input!");
			    this.value = val.substring(0, val.length - 1);
			}
	 }	
});

$("#refund_percentage_c, #refund_percentage").on("keyup", function(){
	var id=this.id;
	var valid = /^((0|[1-9]\d?)(\.\d{1,2})?|100(\.00?)?)$/.test(this.value),
    val = this.value;
	validateSelectAndInputField(id,id+'_error');
	 if (val != undefined && val != '') {
	        if(!valid){
			    console.log("Invalid input!");
			    this.value = val.substring(0, val.length - 1);
			}
	 }	
	
});

$('.apply_Eligibility').click(function() {
	if ($(this).is(':checked')) {
		 $('#apply_Eligibility_error').addClass('d-none');
	}else{
		$('#apply_Eligibility_error').removeClass('d-none');
	}
});

/*$('.eligibility_check').click(function() {
	if ($(this).is(':checked')) {
		 $('#eligibility_Check_error').addClass('d-none');
	}else{
		 $('#eligibility_Check_error').removeClass('d-none');
	}
});*/


function validateTableDataPresent(id,errorId){
	if( $('#'+id+' tbody tr').length > 0 ) {
		 $('#'+errorId).addClass('d-none');
		 return true;
	}else{
		 $('#'+errorId).removeClass('d-none');
		 return false;
	}
}
function validateNumberOfAttempts(errorId){debugger
	var isTrue=true;
	$(".omaniMaxAttempt" ).each(function() {
		if(($(this).val() == undefined || $(this).val() =='') && (!$('#eligiblity-check-confirmation').hasClass('d-none'))){
			console.log('inside mandatory');
			isTrue=false;
		}
	});
	if(isTrue){
		 $('#'+errorId).addClass('d-none');
	}else{
		 $('#'+errorId).removeClass('d-none');
	}
	return isTrue;
}

$(".omaniMaxAttempt").on("keyup", function(){
	validateNumberOfAttempts('attempt_details_error');
});

function validateDaysPopupScreen(id,errorId,className){
	var isValid=true;
	var inputVal="";
	$("."+className ).each(function() {
		if($(this).is("select")){
			let selectedRange = document.getElementById(this.id);
			inputVal=inputVal+' '+selectedRange.options[selectedRange.selectedIndex].text+'';
		} else {			
			inputVal=inputVal + ' ' +$(this).val();
		}
		if($(this).val() == undefined || $(this).val() ==''){
			isValid=false;
		}
	});
	if(isValid){
		 $('#'+id).val(inputVal);
		 $('#'+errorId).addClass('d-none');
	}else{
		 $('#'+id).val('');
		 $('#'+errorId).removeClass('d-none');
	}
	return isValid;
}

function validateOCTExamForm(){
	//var reg_cut_off=validateSelectAndInputField('reg_cut_off','reg_cut_off_error')
	var exam_title= validateSelectAndInputField('exam_title','exam_title_error');
	var result_source= validateSelectAndInputField('result_source','result_source_error');
	var appeal_window= validateSelectAndInputField('appeal_window','appeal_window_error');
	var appeal_fees= validateSelectAndInputField('appeal_fees','appeal_fee_error');
	var reappeal_window= validateSelectAndInputField('reappeal_window','reappeal_window_error');
	var re_appeal_fees= validateSelectAndInputField('re_appeal_fees','re_appeal_fees_error');
	var duration_of_exam=validateSelectAndInputField('duration_of_exam','duration_of_exam_error');
	var cut_score=validateSelectAndInputField('cut_score','cut_score_error');
	//var score_validity=validateSelectAndInputField('score_validity','score_validity_error');
	var result_source=validateSelectAndInputField('result_source','result_source_error');
	//var reschedule_period=validateSelectAndInputField('reschedule_period','reschedule_period_error');
	var applicabledate=validateSelectAndInputField('applicabledate','applicabledate_error');
	var fee_amount=validateSelectAndInputField('fee_amount','fee_amount_error');
	var exam_form_no=validateSelectAndInputField('exam_form_no','exam_form_no_error');
	var venue=validateSelectAndInputField('venue','venue_error');
	var locateOnGoogleMap=validateSelectAndInputField('locateOnGoogleMap','locateOnGoogleMap_error');
	var validateExamTable= validateTableDataPresent('supporting-documents-tb','examBluePrintTable_error');
	var regularExam_table=validateTableDataPresent('regularExam_table','regularTable_error');
	var rescheduling_table=validateTableDataPresent('rescheduling_table','rescheduleTable_error');
	var validateTable=validateTableDataPresent('cancellationFee_table','cancellationFee_table_error');
	var attempt_details=validateNumberOfAttempts('attempt_details_error');
	var radioCheck=validRadioCheck();
	
	/*score_validity && reg_cut_off && reschedule_period*/
	if(exam_title && result_source && appeal_window && appeal_fees && 
			reappeal_window && re_appeal_fees && duration_of_exam && 
			cut_score && result_source && radioCheck && 
			applicabledate && fee_amount && validateExamTable && regularExam_table 
			&& rescheduling_table && validateTable && exam_form_no && venue && locateOnGoogleMap && attempt_details){
		return true;
	}else{
		return false;
	}
}

$("#save_exam").submit(function (event) {
    if (!validateOCTExamForm()) {
        event.preventDefault();
    }else{
    	event.preventDefault();
    	 getExistExam(event);
    }
});