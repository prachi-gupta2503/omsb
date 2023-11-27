console.log('testing this');

$(document).ready(function() {
	$('.textEditor1').richText();
	$('.textEditor2').richText();
});
$('.omsb-datatables').find(".dataTables_empty").parents('tbody').empty();
$('#supporting-documents-table').DataTable({
    "bLengthChange": false,
    "bFilter": false,
    "pageLength": 5
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
	}
	$(".dataTables_empty").remove();
	console.log('adding supporting docs ends');
	$("#addsupportingdocument").modal('hide');
	$("#documentTitle").val('');
	document.getElementById("supportingFile").value = null;
	$("#popup_sd_file_label").html('');
}

function saveSupportingDocs(trName) {
	 
	 console.log('namespace ??' , namespace);
     console.log('data attr tr ?? ', trName);
     $("#"+namespace + "trName").val(trName);
	 
//	event.preventDefault();
//	$(".appl-reason").removeClass("d-none");
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
 }

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
	editLink = editLink.append($("<img>").attr("src", imagePath + '/svg/fi-rr-edit.svg'));
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
	$("#supp_doc_row_class").val(rowClass);
	
}

function deleteRow(){
	var row = $("#supp_doc_row_class").val();
	$("."+ row).remove();
	$("#delete_row").modal('hide');
	
}

function validateDaysPopupScreen(daysBeforeExam, daysBeforeExamValue,errorId,noOfDaysFrom,noOfDaysRange,noOfDaysTo,noOfDays){
	var isValid=true;
	var inputValue="";
	var inputText="";
	var selectedRangeValue =$('#'+noOfDaysRange +' option:selected').val();
	var selectedRange =$('#'+noOfDaysRange +' option:selected').text();
	if(selectedRangeValue == '>' || selectedRangeValue == '<') {
		
		// Validating No. of Days
		var noOfDaysValue =$('#'+noOfDays).val();
		if(noOfDaysValue ==undefined || noOfDaysValue == '') {
			$('#noOfDays-error').removeClass('d-none');
			isValid = false;
		}
		else{
			$('#noOfDays-error').addClass('d-none');
		}
	}
	else {
		// Validating Range 
		if(selectedRangeValue == undefined || selectedRangeValue == ''){
			$('#cancellationFeeSelectedText-error').removeClass('d-none');
			isValid = false;
		}
		else{
			$('#cancellationFeeSelectedText-error').addClass('d-none');
		}
		
		// Validating No. of Days From 
		var noOfDaysFromValue =$('#'+noOfDaysFrom).val();
		
		if(noOfDaysFromValue ==undefined || noOfDaysFromValue == ''){
			$('#noOfDaysFrom-error').removeClass('d-none');
			isValid = false;
		}
		else{
			$('#noOfDaysFrom-error').addClass('d-none');
		}
		
		// Validating No. of Days To
		var noOfDaysToValue =$('#'+ noOfDaysTo).val();
		if(noOfDaysToValue ==undefined || noOfDaysToValue == ''){
			$('#noOfDaysTo-error').removeClass('d-none');
			isValid = false;
		}
		else{
			$('#noOfDaysTo-error').addClass('d-none');
		}
	}
	if(!isValid){
		return isValid;
	}
	
	if(selectedRangeValue == '>' || selectedRangeValue == '<'){
		inputText = selectedRange + ' ' + $('#'+noOfDays).val();
		inputValue = selectedRangeValue + ' ' + $('#'+noOfDays).val();
	} else {
		inputText = selectedRange + ' ' + $('#'+noOfDaysFrom).val()+ ' & ' + $('#'+noOfDaysTo).val();
		inputValue =  $('#'+noOfDaysFrom).val()+ ' - ' + $('#'+noOfDaysTo).val();
	}
	
	if(inputValue ==''){
		isValid=false;
	}
	if(isValid){
		 $('#'+daysBeforeExam).val(inputText);
		 $('#'+daysBeforeExamValue).val(inputValue);
		 $('#'+errorId).addClass('d-none');
	}else{
		 $('#'+daysBeforeExam).val('');
		 $('#'+daysBeforeExamValue).val('');
		 $('#'+errorId).removeClass('d-none');
	}
	return isValid;
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

function validSupportDocs(){
	var fileValid=validateFile();
	var title=validateSelectAndInputField('documentTitle','title-error');
	if(fileValid && title){
		return true;
	}else{
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