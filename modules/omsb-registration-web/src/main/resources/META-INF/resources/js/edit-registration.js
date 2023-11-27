var isAssociated=$('#isAssociated').val();
var isregisteringForRole=$('#isregisteringForRole').val();
setPrimarySpecialty();
setSecondarySpeciality();
let show_roleDiv_1 = false;
let show_departmentDiv_1 = false;
let show_sectionDiv_1 = false;
let show_committeDiv_1 = false;
let show_functionDiv_1 = false;
let show_programtypeDiv_1 = false;
let show_programDiv_1 = false;
let show_programPositionDiv_1 = false;
let show_purposeDiv_1 = false;
let show_roleDiv = false;
let show_departmentDiv_2 = false;
let show_sectionDiv_2 = false;
let show_committeDiv_2 = false;
let show_functionDiv_2 = false;
let show_programtypeDiv_2 = false;
let show_programDiv_2 = false;
let show_programPositionDiv_2 = false;
let show_purposeDiv_2 = false;
let is_role_1_required = false;
let is_department_1_required = false;
let is_section_1_required = false;
let is_committe_1_required = false;
let is_function_1_required = false;
let is_programtype_1_required = false;
let is_program_1_required = false;
let is_programPosition_1_required = false;
let is_purpose_1_required = false;
let is_role_required = false;
let is_department_2_required = false;
let is_section_2_required = false;
let is_committe_2_required = false;
let is_function_2_required = false;
let is_programtype_2_required = false;
let is_program_2_required = false;
let is_programPosition_2_required = false;
let is_purpose_2_required = false;
var phone1 = document.querySelector("#mobileNumber");
var hiddenCountryInput = document.querySelector("#hiddenCountryCode");
var hiddenCountryIsoCode = document.querySelector("#hiddenCountryIsoCode");
var itl = '';
var initialCountryVal="om";
if(hiddenCountryIsoCode.value!=''){
	initialCountryVal=hiddenCountryIsoCode.value;
}
setTimeout(function() {
	itl = window.intlTelInput(phone1,({initialCountry:initialCountryVal, separateDialCode: "true", showFlags:"false"}));
	var selectedCountry = itl.getSelectedCountryData();
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
}, 200);

phone1.addEventListener("countrychange",function() {
	var selectedCountry = itl.getSelectedCountryData();
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
	document.getElementById("mobileNumber").value="";
	allowedMobileOTP(selectedCountry.dialCode);
});
function showOtherField(id,errorId,errorMessage){
	var substring=substring=id;	
	let selectedValue= $("#"+id).find('option:selected').val();
	if(selectedValue.trim() === 'other'){
		$('#'+id+"OtherDiv").removeClass('d-none');
	} else{
		$('#'+id+"OtherDiv").addClass('d-none');
	}
	validateField(id,errorId,errorMessage);
}



function isAllowedMobileDigits(value){
    if(hiddenCountryInput.value=="968"){
            if(value.length==8){
            return false;
            }
                    }
}
function allowedMobileOTP(dialCode){
if(dialCode=='968'){
        $("#mobile-otp-div").removeClass('d-none');
        $("#sendMobileOTP").removeClass('d-none');
}
else{
        $("#mobile-otp-div").addClass('d-none');
        $("#sendMobileOTP").addClass('d-none');
        document.getElementById("mobileNumberOTPVerified").value="true";
}
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
$('#role-service-list').DataTable({	
	   "bLengthChange": false,	
	   "bFilter": false,
	   "ordering": false
	});

function setDeleteID(id){
	document.getElementById("deleteID").value = id;
}
$('#work-detail-list').DataTable({	
	   "bLengthChange": false,	
	   "bFilter": false,
	   "ordering": false
	});
$('#work-detail-list1').DataTable({	
	   "bLengthChange": false,	
	   "bFilter": false,
	   "ordering": false
});
function applyDobDatepicker(){
		$('#dateOfBirth').datepicker({
			format: "dd-mm-yyyy",
			orientation: "bottom auto",
			autoclose: true
		}).on('change', function(){
			$('.datepicker').hide();
		});
	}
const minDate = new Date();
minDate.setDate(minDate.getDate() + 1);
$('#passportExpiryDate').datepicker({
	format: "dd-mm-yyyy",
	orientation: "bottom auto",
	autoclose: true,
	startDate: minDate
}).on('change', function(){
	let ds = $(this).val();
	if(ds.length){
		let [day, month, year] = ds.split('-')
		const dateObj = new Date(+year, +month - 1, +day)
		if (dateObj < new Date()) {
	    	//$(this).val('');
	    }
	}
	$('.datepicker').hide();
});

function openEduOpenAddModel(id){
	document.getElementById("qualification").value = "";
	document.getElementById('select2-qualification-container').innerHTML="<liferay-ui:message key='select' />";
	document.getElementById("institution").value = "";
	document.getElementById('select2-institution-container').innerHTML="<liferay-ui:message key='select' />";
	document.getElementById("country").value = "";
	document.getElementById('select2-country-container').innerHTML="<liferay-ui:message key='select' />";
	document.getElementById("year").value = "";
	document.getElementById('select2-year-container').innerHTML="<liferay-ui:message key='select' />";
	document.getElementById("id").value = '';
	document.getElementById("qualificationdoclbl").innerHTML = '';	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	document.getElementById("view-file").setAttribute("href","");
	$("#view-div").addClass("d-none");
	$("#add-education-confirm-modal").data("id",id);
}

function openWorkDetailOpenAddModel(id){
	document.getElementById("workSectorType_3").value = '';
	document.getElementById('select2-workSectorType_3-container').innerHTML="<liferay-ui:message key='select' />";
	document.getElementById("worksectortypeother_3").value = '';
	document.getElementById("worksector_3").value = '';
	document.getElementById("select2-worksector_3-container").innerHTML = "<option value=''><liferay-ui:message key='select'/></option>";	
	document.getElementById("worksectorother_3").value = '';
	document.getElementById("first-sub-worksector_3").value = '';
	document.getElementById("select2-first-sub-worksector_3-container").innerHTML = "<option value=''><liferay-ui:message key='select'/></option>";
	document.getElementById("worksectorother_3").value = '';
	document.getElementById("second-sub-worksector_3").value = '';
	document.getElementById("select2-second-sub-worksector_3-container").innerHTML = "<option value=''><liferay-ui:message key='select'/></option>";
	document.getElementById("wilayats_3").value = '';
	document.getElementById("select2-wilayats_3-container").innerHTML = "<option value=''><liferay-ui:message key='select'/></option>";
	document.getElementById("designations_3").value = '';
	document.getElementById("select2-designations_3-container").innerHTML = "<option value=''><liferay-ui:message key='select'/></option>";
	document.getElementById("customStaffIdCard_3").innerHTML = '';	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	document.getElementById("view-file").setAttribute("href","");	
	$("#div-o3-work-other_3").addClass("d-none");
	$("#div-first-sub-sector_3").addClass("d-none");	
	$("#view-div").addClass("d-none");
	$("#add-work-detail-confirm-modal").data("id",id);
}
function openDeleteModal(id){
	$("#delete-confirm-modal").data("id",id);
}
function openEduOpenDeleteModal(id){
	$("#delete-education-confirm-modal").data("id",id);
}