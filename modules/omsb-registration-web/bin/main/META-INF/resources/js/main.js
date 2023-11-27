console.log('testing this');

var index=1;
$(document).ready(function() {
    $("#countryOfIssue").select2();
    $("#gender").select2();
    $("#nationality").select2();
    $("#profession").select2();
    $("#primarySpeciality").select2();
    $("#secondarySpeciality").select2();
    $("#workSectorType_1").select2();
    $("#worksector_1").select2();
    $("#first-sub-worksector_1").select2();
    $("#wilayats_1").select2();
    $("#designations_1").select2();
    $("#workSectorType_2").select2();
    $("#worksector_2").select2();
    $("#first-sub-worksector_2").select2();
    $("#wilayats_2").select2();
    $("#designations_2").select2();
    
    $("#role_1").select2();
    $("#department_1").select2();
    $("#section_1").select2();
    $("#committe_1").select2();
    $("#function_1").select2();
    $("#programtype_1").select2();
    $("#program_1").select2();
    $("#programPosition_1").select2();
    $("#purpose_1").select2();
    
    $("#role").select2();
    $("#department_2").select2();
    $("#section_2").select2();
    $("#committe_2").select2();
    $("#function_2").select2();
    $("#programtype_2").select2();
    $("#program_2").select2();
    $("#programPosition_2").select2();
    $("#purpose_2").select2();
    
    $("#service").select2();
    $("#qualification").select2();
    $("#institution").select2();
    $("#country").select2();
    $("#year").select2();
    $("#workSectorType_3").select2();
    $("#worksector_3").select2();
    $("#first-sub-worksector_3").select2();
    $("#second-sub-worksector_3").select2();
    $("#wilayats_3").select2();
    $("#designations_3").select2();
    
    hideRole_1Fields();
    hideRoleFields();
	function showOtherField(id,errorId,errorMessage){
   		var substring=substring=id;   	
   	 	let selectedValue= $("#"+id).find('option:selected').val();
   
   	 	if(selectedValue.trim() === 'other'){
   			console.log('#'+id+"otherDiv");
   		 	$('#'+id+"OtherDiv").removeClass('d-none');
   	 	} else{
   			$('#'+id+"OtherDiv").addClass('d-none');
   		}
    	validateField(id,errorId,errorMessage);   	 
   	}
	
	const minDate = new Date();
	minDate.setDate(minDate.getDate() + 1);
});

var isEditable = false;
$( document ).ready(function() {
    
	var designation_1=$("#designations_1").val();
	var designation_2=$("#designations_2").val();
	if(designation_1=="other"){
		 $('#designationotherdiv_1').removeClass('d-none');
	} else{
		$("#designationother_1").val('');
		$('#designationotherdiv_1').addClass('d-none');
	}
	if(designation_2=="other"){
		$('#designationotherdiv_2').removeClass('d-none');
	} else{
		$("#designationother_2").val('');
		$('#designationotherdiv_2').addClass('d-none');
	}
});

//Educational Detail 
function elementCount(){
	$('.element').each(function() {
    	var id = $(this).attr('id');
    	var split_id = id.split("_");
      	var index = Number(split_id[2]);
		rowIndexer.push(index);
    });
	$('#counter').val(rowIndexer.join(","));
}



// Education Detail
$(document).ready(function() {
			$(function() {
			    $('input:radio[name="<portlet:namespace/>employed"]').change(function() {
			    	 if ($(this).val() == '1') {
				            $("#work-detail-main").removeClass("d-none");
				        } else {
				            $("#work-detail-main").addClass('d-none');
				        }
			    });
			});
			
			  $(document).on('change','#worksector_1',function(){
					var workSectorValue=$(this).val();
					if(workSectorValue == 'Other'){
					      $("#div-work-other_1").removeClass("d-none");
					}else{
						$("#worksectorother_1").val('');
						$("#div-work-other_1").addClass("d-none");
					}
					
				});
			
			   $(document).on('change','#worksector_2',function(){
					var workSectorValue=$(this).val();
					if(workSectorValue == 'Other'){
					      $("#div-work-other_2").removeClass("d-none");
					}else{
						$("#").val('');
						$("#div-work-other_2").addClass("d-none");
					}
					
				});
			
			//on Chnage function for work sector to display other
			$(document).on('change','.worksector_',function(){
				var workSectorValue=$(this).val();
				var id = $(this).attr('id');
				 var split_id = id.split("_");
				var index = Number(split_id[1]);
				if(workSectorValue == 'Other'){
				      $("#div-work-other_"+index).removeClass("d-none");
				}else{
					$("#worksectorother_"+index).val('');
					$("#div-work-other_"+index).addClass("d-none");
				}
				
			});
		});

function hideRole_1Fields(){
	$('#departmentDiv_1').addClass("d-none");
	$('#sectionDiv_1').addClass("d-none");
	$('#committeDiv_1').addClass("d-none");
	$('#functionDiv_1').addClass("d-none");
	$('#programtypeDiv_1').addClass("d-none");
	$('#programDiv_1').addClass("d-none");
	$('#programPositionDiv_1').addClass("d-none");
	$('#purposeDiv_1').addClass("d-none");
}

function hideRoleFields(){
	$('#departmentDiv_2').addClass("d-none");
	$('#sectionDiv_2').addClass("d-none");
	$('#committeDiv_2').addClass("d-none");
	$('#functionDiv_2').addClass("d-none");
	$('#programtypeDiv_2').addClass("d-none");
	$('#programDiv_2').addClass("d-none");
	$('#programPositionDiv_2').addClass("d-none");
	$('#purposeDiv_2').addClass("d-none");
}

$(document).on('change','#programtype_1',function(){
	var programTypeId=$('#programtype_1').val();
	setProgram("programtype_1","program_1");
});

$(document).on('change','#programtype_2',function(){
	var programTypeId=$('#programtype_2').val();
	setProgram("programtype_2","program_2");
});

$(document).on('change','#department_2',function(){
	$('#departmentOtherDiv_2').addClass("d-none");
	$('#departmentOther_2').val("");
	var departmentId=$('#department_2').val();
	if(departmentId !== "other"){
		$('#sectionDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		
		show_sectionDiv_2 = true;
		show_functionDiv_2 = true;
		
		setSection("department_2","section_2");
	} else {
		$('#sectionDiv_2').addClass("d-none");
		$('#functionDiv_2').addClass("d-none");
		
		show_sectionDiv_2 = false;
		show_functionDiv_2 = false;
		
		showOtherField("department_2");
	}
});

$(document).on('change','#section_1',function(){
	var sectionId=$('#section_1').val();
	setFunctionCommitee("section_1","function_1","committe_1");
});

$(document).on('change','#section_2',function(){
	var sectionId=$('#section_2').val();
	setFunctionCommitee("section_2","function_2","committe_2");
});


function setRole(selectedRole){
	hideRoleFields();
	if(selectedRole.toLowerCase() === 'Staff'.toLowerCase()){
		$('#departmentDiv_2').removeClass("d-none");
		$('#sectionDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		$('#programtypeDiv_2').removeClass("d-none");
		$('#programDiv_2').removeClass("d-none");
		
		show_departmentDiv_2 = true;
		show_sectionDiv_2 = true;
		show_functionDiv_2 = true;
		show_programtypeDiv_2 = true;
		show_programDiv_2 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_function_1_required = true;
	} else if(selectedRole.toLowerCase() === 'GFP Trainee'.toLowerCase()){
		$('#programDiv_2').removeClass("d-none");
		
		show_programDiv_2 = true;
		
		is_program_2_required = true;
		
		$("#programtype_2 option:contains(Fellowship)").attr('selected', 'selected');
		setProgram("programtype_2","program_2");
	} else if(selectedRole.toLowerCase() === 'Fellowship Trainee'.toLowerCase()){
		$('#programDiv_2').removeClass("d-none");
		
		show_programDiv_2 = true;
		
		is_program_2_required = true;
		
		$("#programtype_2 option:contains(Genral Foundation program)").attr('selected', 'selected');
		setProgram("programtype_2","program_2");
	} else if(selectedRole.toLowerCase() === 'Residency Trainee'.toLowerCase()){
		$('#programDiv_2').removeClass("d-none");
		
		show_programDiv_2 = true;
		
		is_program_2_required = true;
		
		$("#programtype_2 option:contains(Speciality)").attr('selected', 'selected');
		setProgram("programtype_2","program_2");
	} else if(selectedRole.toLowerCase() === 'Subject Matter Expert'.toLowerCase()){
		$('#departmentDiv_2').removeClass("d-none");
		$('#sectionDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		
		show_departmentDiv_2 = true;
		show_sectionDiv_2 = true;
		show_functionDiv_2 = true;
		
		is_department_2_required = true;
		is_section_2_required = true;
		is_function_2_required = true;
	} else if(selectedRole.toLowerCase() === 'Authorized User from Medical Institutions'.toLowerCase()){
		$('#departmentDiv_2').removeClass("d-none");
		$('#sectionDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		
		show_departmentDiv_2 = true;
		show_sectionDiv_2 = true;
		show_functionDiv_2 = true;
		
		is_department_2_required = true;
		is_section_2_required = true;
		is_function_2_required = true;
	} else if(selectedRole.toLowerCase() === 'Education Committee member'.toLowerCase() || selectedRole.toLowerCase() === 'Faculty'.toLowerCase()){
		$('#programtypeDiv_2').removeClass("d-none");
		$('#programDiv_2').removeClass("d-none");
		$('#programPositionDiv_2').removeClass("d-none");
		
		show_programtypeDiv_2 = true;
		show_programDiv_2 = true;
		show_programPositionDiv_2 = true;
		
		is_programtype_2_required = true;
		is_program_2_required = true;
		is_programPosition_2_required = true;
	} else if(selectedRole.toLowerCase() === 'Counsellor'.toLowerCase()){
		$('#departmentDiv_2').removeClass("d-none");
		$('#sectionDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		
		show_departmentDiv_2 = true;
		show_sectionDiv_2 = true;
		show_functionDiv_2 = true;
		
		is_department_2_required = true;
		is_section_2_required = true;
		is_function_2_required = true;
	} else if(selectedRole.toLowerCase() === 'Taskforce member'.toLowerCase() || selectedRole.toLowerCase() === 'Team member'.toLowerCase() || selectedRole.toLowerCase() === 'Committee member'.toLowerCase()){
		$('#departmentDiv_2').removeClass("d-none");
		$('#sectionDiv_2').removeClass("d-none");
		$('#committeDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		
		show_departmentDiv_2 = true;
		show_sectionDiv_2 = true;
		show_committeDiv_2 = true;
		show_functionDiv_2 = true;
		
		is_department_2_required = true;
		is_section_2_required = true;
		is_committe_2_required = true;
		is_function_2_required = true;
	} else if(selectedRole.toLowerCase() === 'Interview or judging panel'.toLowerCase()){
		$('#departmentDiv_2').removeClass("d-none");
		$('#sectionDiv_2').removeClass("d-none");
		$('#functionDiv_2').removeClass("d-none");
		$('#purposeDiv_2').removeClass("d-none");
		
		show_departmentDiv_2 = true;
		show_sectionDiv_2 = true;
		show_functionDiv_2 = true;
		show_purposeDiv_2 = true;
		
		is_department_2_required = true;
		is_section_2_required = true;
		is_function_2_required = true;
		is_purpose_2_required = true;
	}
}
	
$(document).on('change','#department_1',function(){
	$('#departmentOtherDiv_1').addClass("d-none");
	$('#departmentOther_1').val("");
	var departmentId=$('#department_1').val();
	if(departmentId !== "other"){
		$('#sectionDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		
		show_sectionDiv_1 = true;
		show_functionDiv_1 = true;
		
		setSection("department_1","section_1");
	} else {
		$('#sectionDiv_1').addClass("d-none");
		$('#functionDiv_1').addClass("d-none");
		
		show_sectionDiv_1 = false;
		show_functionDiv_1 = false;
		
		showOtherField("department_1");
	}
});

$(document).on('change','#role_1',function(){
	show_departmentDiv_1 = false;
	show_sectionDiv_1 = false;
	show_committeDiv_1 = false;
	show_functionDiv_1 = false;
	show_programtypeDiv_1 = false;
	show_programDiv_1 = false;
	show_programPositionDiv_1 = false;
	show_purposeDiv_1 = false;
	
	hideRole_1Fields();
	
	is_department_1_required = false;
	is_section_1_required = false;
	is_committe_1_required = false;
	is_function_1_required = false;
	is_programtype_1_required = false;
	is_program_1_required = false;
	is_programPosition_1_required = false;
	is_purpose_1_required = false;
	
	var selectedRole = $('option:selected', $('#role_1')).text().trim();
	setRole_1(selectedRole);
});

$(document).on('change','#role',function(){
	show_departmentDiv_2 = false;
	show_sectionDiv_2 = false;
	show_committeDiv_2 = false;
	show_functionDiv_2 = false;
	show_programtypeDiv_2 = false;
	show_programDiv_2 = false;
	show_programPositionDiv_2 = false;
	show_purposeDiv_2 = false;
	
	hideRoleFields();
	
	is_department_2_required = false;
	is_section_2_required = false;
	is_committe_2_required = false;
	is_function_2_required = false;
	is_programtype_2_required = false;
	is_program_2_required = false;
	is_programPosition_2_required = false;
	is_purpose_2_required = false;
	
	var selectedRole = $('option:selected', $('#role')).text().trim();
	setRole(selectedRole);
});

function setRole_1(selectedRole){
	hideRole_1Fields();
	if(selectedRole.toLowerCase() === 'Staff'.toLowerCase()){
		$('#departmentDiv_1').removeClass("d-none");
		$('#sectionDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		$('#programtypeDiv_1').removeClass("d-none");
		$('#programDiv_1').removeClass("d-none");
		
		show_departmentDiv_1 = true;
		show_sectionDiv_1 = true;
		show_functionDiv_1 = true;
		show_programtypeDiv_1 = true;
		show_programDiv_1 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_function_1_required = true;
	
	} else if(selectedRole.toLowerCase() === 'GFP Trainee'.toLowerCase()){
		$('#programDiv_1').removeClass("d-none");
		
		show_programDiv_1 = true;
		
		is_program_1_required = true;
		
		$("#programtype_1 option:contains(Fellowship)").attr('selected', 'selected');
		setProgram("programtype_1","program_1");
	} else if(selectedRole.toLowerCase() === 'Fellowship Trainee'.toLowerCase()){
		$('#programDiv_1').removeClass("d-none");
		
		show_programDiv_1 = true;
		
		is_program_1_required = true;
		
		$("#programtype_1 option:contains(Genral Foundation program)").attr('selected', 'selected');
		setProgram("programtype_1","program_1");
	} else if(selectedRole.toLowerCase() === 'Residency Trainee'.toLowerCase()){
		$('#programDiv_1').removeClass("d-none");
		
		show_programDiv_1 = true;
		
		is_program_1_required = true;
		
		$("#programtype_1 option:contains(Speciality)").attr('selected', 'selected');
		setProgram("programtype_1","program_1");
	} else if(selectedRole.toLowerCase() === 'Subject Matter Expert'.toLowerCase()){
		$('#departmentDiv_1').removeClass("d-none");
		$('#sectionDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		
		show_departmentDiv_1 = true;
		show_sectionDiv_1 = true;
		show_functionDiv_1 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_function_1_required = true;
	} else if(selectedRole.toLowerCase() === 'Authorized User from Medical Institutions'.toLowerCase()){
		$('#departmentDiv_1').removeClass("d-none");
		$('#sectionDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		
		show_departmentDiv_1 = true;
		show_sectionDiv_1 = true;
		show_functionDiv_1 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_function_1_required = true;
	} else if(selectedRole.toLowerCase() === 'Education Committee member'.toLowerCase() || selectedRole.toLowerCase() === 'Faculty'.toLowerCase()){
		$('#programtypeDiv_1').removeClass("d-none");
		$('#programDiv_1').removeClass("d-none");
		$('#programPositionDiv_1').removeClass("d-none");
		
		show_programtypeDiv_1 = true;
		show_programDiv_1 = true;
		show_programPositionDiv_1 = true;
		
		is_programtype_1_required = true;
		is_program_1_required = true;
		is_programPosition_1_required = true;
	} else if(selectedRole.toLowerCase() === 'Counsellor'.toLowerCase()){
		$('#departmentDiv_1').removeClass("d-none");
		$('#sectionDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		
		show_departmentDiv_1 = true;
		show_sectionDiv_1 = true;
		show_functionDiv_1 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_function_1_required = true;
	} else if(selectedRole.toLowerCase() === 'Taskforce member'.toLowerCase() || selectedRole.toLowerCase() === 'Team member'.toLowerCase() || selectedRole.toLowerCase() === 'Committee member'.toLowerCase()){
		$('#departmentDiv_1').removeClass("d-none");
		$('#sectionDiv_1').removeClass("d-none");
		$('#committeDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		
		show_departmentDiv_1 = true;
		show_sectionDiv_1 = true;
		show_committeDiv_1 = true;
		show_functionDiv_1 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_committe_1_required = true;
		is_function_1_required = true;
	} else if(selectedRole.toLowerCase() === 'Interview or judging panel'.toLowerCase()){
		$('#departmentDiv_1').removeClass("d-none");
		$('#sectionDiv_1').removeClass("d-none");
		$('#functionDiv_1').removeClass("d-none");
		$('#purposeDiv_1').removeClass("d-none");
		
		show_departmentDiv_1 = true;
		show_sectionDiv_1 = true;
		show_functionDiv_1 = true;
		show_purposeDiv_1 = true;
		
		is_department_1_required = true;
		is_section_1_required = true;
		is_function_1_required = true;
		is_purpose_1_required = true;
	}
}
function onlyNumberKey(evt) {
	var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
        return false;
    return true;
}
function showPassportPhoto(id){
	var passportNo=$("#"+id).val();
	if(passportNo.length>0){
		$("#passportPhotoDiv").removeClass("d-none");
	}
	else{
	  $("#passportPhotoDiv").addClass("d-none");
	}
}
function openRoleServiceOpenAddModel(id){
	console.log("calling main js openRoleServiceOpenAddModel");
	$("#requestForService").val(false);
	resetRoleForm();
	resetRole_1Form();
	$("#registrant_detail_area").addClass("d-none");
	$("#associated_detail_area").removeClass("d-none");
	$("#txtIndex").val("1");
	$("#add-role-service-confirm-modal").data("id",id);
}
function validateFile(id,errorId,field,errorMessage){
	   var allowedExtensionsReg;
	   if(id.indexOf("_") !== -1){
			var divId=id.substring(id.indexOf("_") + 1);
			errorId=errorId.substring(0,errorId.indexOf("_")+1)+divId;
		}
		 var filename = document.getElementById(id).files[0].name;
	   var extension = filename.substr(filename.lastIndexOf("."));
	   if(field=='photo'){
	   allowedExtensionsReg = /(\.jpg|\.jpeg|\.png)$/i;
	   }
	   else if(field=='cvDocument'){
		   allowedExtensionsReg = /(\.pdf|\.docx|\.doc)$/i;
	   }
	   else{
			allowedExtensionsReg = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
	   }
	   var isAllowed = allowedExtensionsReg.test(extension);

	   if(isAllowed){
	  	 $("#"+errorId).html("");
	   }else{
	  	 $("#"+errorId).text(errorMessage);
	   }
	}
function clearForm(){
	document.getElementById("qualification").value = '';
	document.getElementById("institution").value = '';
	document.getElementById("country").value = '';
	//document.getElementById("gpa").value = '';
	document.getElementById("year").value = '';
	document.getElementById("id").value = '';
	document.getElementById("qualificationdoc").value='';	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
	//document.getElementById("errorContainer-gpa").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	isEdit=false;
}

function clearEmploymentFormFields(){
	document.getElementById("workSectorType_1").value = '';
	document.getElementById("workSectorType_2").value = '';
	document.getElementById("worksector_1").value = '';
	document.getElementById("worksector_2").value = '';
	document.getElementById("worksectorother_1").value = '';
	document.getElementById("worksectorother_2").value = '';
	document.getElementById("wilayats_1").value = '';
	document.getElementById("wilayats_2").value = '';
	document.getElementById("designations_1").value = '';
	document.getElementById("designations_2").value = '';
	document.getElementById("uploadFile_1").value = '';
	document.getElementById("uploadFile_2").value='';	
	document.getElementById("work-sector-type-error_1").textContent = "";
	document.getElementById("work-sector-type-error_2").textContent = "";
	document.getElementById("work-sector-error_1").textContent = "";
	document.getElementById("work-sector-error_2").textContent = "";
	document.getElementById("location-error_1").textContent = "";
	document.getElementById("location-error_2").textContent = "";
	document.getElementById("designation-error_1").textContent = "";
	document.getElementById("designation-error_2").textContent = "";
	document.getElementById("file-size-error_1").textContent = "";
	document.getElementById("file-size-error_2").textContent = "";
	document.getElementById("errorContainer-work-detail-file_1").textContent = "";
	document.getElementById("errorContainer-work-detail-file_2").textContent = "";
	isEditable=false;
}

function showDesignationOther(id,errorId,errorMessage){
	 var substring=substring=id.substr ( id.indexOf ( '_' ) + 1 );	
	 let selectedDesignation= $("#"+id).find('option:selected').val();
	 if(selectedDesignation.trim() === 'other'){
		 $('#designationotherdiv_'+substring).removeClass('d-none');
	 } else{
	 	$('#designationotherdiv_'+substring).addClass('d-none');
	}
	validateField(id,errorId,errorMessage); 
}
	
function validateField(elementId,errorId,error){
	var fieldValue=$("#"+elementId).val();
	if(elementId.indexOf("_") !== -1){
		var divId=elementId.substring(elementId.indexOf("_") + 1);
		errorId=errorId.substring(0,errorId.indexOf("_")+1)+divId;
	}
	if(fieldValue==''){
		$("#"+errorId).text(error);
	}
	else{
		$("#"+errorId).html("");
	}
}
//Third child 
function getChildWorkSector3(id,field){
	    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 if(selectedValue){
				 	if(selectedValue =='other'){
						 $("#div-o3-secons-work-other_"+substring).removeClass("d-none");
				 	}else{
				 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
				 	}
			 	}else{
			 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
			 	}
}
function resetRole_1Form(){
	$("#role_1").val("");
	document.getElementById('select2-role_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#department_1").val("");
	document.getElementById('select2-department_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#section_1").val("");
	document.getElementById('select2-section_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#committe_1").val("");
	document.getElementById('select2-committe_1-container').innerHTML="<liferay-ui:message key='select' />";	
	$("#function_1").val("");
	document.getElementById('select2-function_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#programtype_1").val("");
	document.getElementById('select2-programtype_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#program_1").val("");
	document.getElementById('select2-program_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#programPosition_1").val("");
	document.getElementById('select2-programPosition_1-container').innerHTML="<liferay-ui:message key='select' />";
	$("#purpose_1").val("");
	document.getElementById('select2-purpose_1-container').innerHTML="<liferay-ui:message key='select' />";
	hideRole_1Fields();
}
function resetRoleForm(){
	$("#role").val("");
	document.getElementById('select2-role-container').innerHTML="<liferay-ui:message key='select' />";
	$("#department_2").val("");
	document.getElementById('select2-department_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#section_2").val("");
	document.getElementById('select2-section_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#committe_2").val("");
	document.getElementById('select2-committe_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#function_2").val("");
	document.getElementById('select2-function_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#programtype_2").val("");
	document.getElementById('select2-programtype_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#program_2").val("");
	document.getElementById('select2-program_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#programPosition_2").val("");
	document.getElementById('select2-programPosition_2-container').innerHTML="<liferay-ui:message key='select' />";
	$("#purpose_2").val("");
	document.getElementById('select2-purpose_2-container').innerHTML="<liferay-ui:message key='select' />";
	hideRoleFields();
}