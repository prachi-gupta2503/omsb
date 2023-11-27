<portlet:resourceURL id="<%=MVCCommands.VERIFY_USERNAME%>" var="verifyUsernameURL" />
<portlet:resourceURL id="<%=MVCCommands.SEND_OTP%>" var="sendOTPURL" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_OTP%>" var="verifyOTPURL" />
<portlet:resourceURL id="<%=MVCCommands.SECTION_DEPARTMENT_MVC_RESOURCE%>" var="sectionDepartmentURL" />		
<portlet:resourceURL id="<%=MVCCommands.FUNCTION_SECTION_COMMITTEE_MVC_RESOURCE%>" var="functionSectioncommitteURL" />		
<portlet:resourceURL id="<%=MVCCommands	.PROGRAM_TYPE_MVC_RESOURCE%>" var="programTypeURL" />
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="saveEducationDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_EDUCATION_DETAILS_SR%>" var="getEducationDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="deleteEducationDetailsURL" />
<input id="userMetadataId" type="hidden" name="<portlet:namespace/>userMetadataId" value="${userMetadata.id}"/>
<input id="isAssociated" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.associated}"/>
<input id="isregisteringForRole" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.registeringForRole}"/>
<input id="requestForService" type="hidden" name="<portlet:namespace/>requestForService" value="false"/>
<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_WORKSECTOR_TYPE%>" var="getWorkSectorByWorkSectorType" />
<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_PARENT_WORK_SECTOR%>" var="getWorkSectorByParentWorkSector" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_WORK_DETAILS_SR%>" var="getWorkDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_WORK_DETAILS_SR%>" var="saveWorkDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_WORK_DETAILS_SR%>" var="deleteWorkDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_ROLE_SERVICE_SR%>" var="saveRoleServiceURL" />	
<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_ROLE_SERVICE_SR%>" var="deleteRoleServiceURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_ROLE_SERVICE_SR%>" var="getRoleServiceURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_UNIVERSITY_DETAILS%>" var="getUniversityDetailsURL" />
<script type="text/javascript">
function isValidVerificationFields(verificationTypeField){
	document.getElementById("errorContainer-emailAddress").textContent = "";
	document.getElementById("errorContainer-mobileNumber").textContent = "";
	let isValid = false; 
	if(verificationTypeField == "emailAddress"){
		var emailAddress = document.getElementById("emailAddress").value;
		if (!emailAddress) {
			document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-email-address' />";
		} else {
			document.getElementById("errorContainer-emailAddress").textContent = "";
			let regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
	        if (!regex.test(emailAddress)) {
				document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-valid-email-address' />";
			} else {
				document.getElementById("errorContainer-emailAddress").textContent = "";
				isValid = true;
			}			
		}
	} else if(verificationTypeField == "mobileNumber"){
		var mobileNumber = document.getElementById("mobileNumber").value;
		if (!mobileNumber) {
			document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-mobile-number' />";
		} else {
			document.getElementById("errorContainer-mobileNumber").textContent = "";
			if (mobileNumber.length != 8 || (!mobileNumber.startsWith("7") && !mobileNumber.startsWith("9"))) {
				document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-valid-mobile-number' />";
			} else {
				document.getElementById("errorContainer-mobileNumber").textContent = "";
				isValid = true;
			}
		}
	}
	return isValid;
}
function isValidVerificationOTPField(verificationTypeField){	
	let isValid = false;
	if(verificationTypeField == "emailAddressOTP"){
		var emailAddress = document.getElementById("emailAddress").value;
		if (!emailAddress) {
			document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-email-address' />";
		} else {
			document.getElementById("errorContainer-emailAddress").textContent = "";
			let regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
	        if (!regex.test(emailAddress)) {
				document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-valid-email-address' />";
			} else {
				document.getElementById("errorContainer-emailAddress").textContent = "";
				var emailAddressOTP = document.getElementById("emailAddressOTP").value;
				if(emailAddressOTP.length==6){
					if (!emailAddressOTP) {
						document.getElementById("errorContainer-emailAddressOTP").textContent = "<liferay-ui:message key='please-enter-otp' />";
					} else {
						document.getElementById("errorContainer-emailAddressOTP").textContent = "";
						isValid = true;
					}
				} else {
					document.getElementById("errorContainer-emailAddressOTP").textContent = "<liferay-ui:message key='please-enter-valid-six-digit-otp' />";
				}
			}
		}
	} else if(verificationTypeField == "mobileNumberOTP"){
		var mobileNumber = document.getElementById("mobileNumber").value;
		if (!mobileNumber) {
			document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-mobile-number' />";
		} else {
			document.getElementById("errorContainer-mobileNumber").textContent = "";
			var mobileNumberOTP = document.getElementById("mobileNumberOTP").value;
			if(mobileNumberOTP.length==6){
				if (!mobileNumberOTP) {
					document.getElementById("errorContainer-mobileNumberOTP").textContent = "<liferay-ui:message key='please-enter-otp' />";
				} else {
					document.getElementById("errorContainer-mobileNumberOTP").textContent = "";
					isValid = true;
				}
			} else {
				document.getElementById("errorContainer-mobileNumberOTP").textContent = "<liferay-ui:message key='please-enter-valid-six-digit-otp' />";
			}
		}
	}
	return isValid;
}
function sendVerificationOTP(verificationTypeField){
	if(isValidVerificationFields(verificationTypeField)){
		document.getElementById(verificationTypeField+"OTPVerified").value = "false";
		document.getElementById(verificationTypeField+"OTP").value = "";
		document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = "";
		document.getElementById(verificationTypeField).removeAttribute('readonly');
		document.getElementById(verificationTypeField+"OTP").removeAttribute('readonly');
		var inputVal = $("#"+verificationTypeField).val();
		var personId = $("#personId").val();
		$.ajax({
			url: '${sendOTPURL}',
			async : false,
			data : {
				<portlet:namespace />verificationType : verificationTypeField,
				<portlet:namespace />inputVal : inputVal,
				<portlet:namespace />personID : personId
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				if(response.isValid){
					document.getElementById(verificationTypeField).setAttribute('readonly','readonly');
					document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = "<liferay-ui:message key='otp-sent-successfully' />";
				} else {
					if(verificationTypeField=="emailAddress"){
						document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = '<liferay-ui:message key="emailAddress-already-exist" />';
					} else{
						document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = '<liferay-ui:message key="mobileNumber-already-exist" />';
					}
				}				
			},
		});
	}
}
function verifyOTP(verificationType){	
	if(isValidVerificationOTPField(verificationType+"OTP")){
		document.getElementById("errorContainer-"+verificationType+"OTP").textContent = "";
		var inputVal = $("#"+verificationType+"OTP").val();
		var personId = $("#personId").val();
		$.ajax({
			url: '${verifyOTPURL}',
			async : false,
			data : {
				<portlet:namespace />verificationType : verificationType+"OTP",
				<portlet:namespace />inputVal : inputVal,
				<portlet:namespace />personID : personId
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				if(response.isValid){
					document.getElementById(verificationType+"OTPVerified").value = "true";
					document.getElementById(verificationType+"OTP").value = "";
					document.getElementById("errorContainer-"+verificationType+"OTP").textContent = "<liferay-ui:message key='otp-verified-successfully' />";
					document.getElementById(verificationType).setAttribute('readonly','readonly');
					document.getElementById(verificationType+"OTP").setAttribute('readonly','readonly');
				} else {
					document.getElementById(verificationType+"OTPVerified").value = "false";
					document.getElementById("errorContainer-"+verificationType+"OTP").textContent = "<liferay-ui:message key='invalid-otp' />";
					document.getElementById(verificationType).removeAttribute('readonly');
					document.getElementById(verificationType+"OTP").removeAttribute('readonly');
				}
			},
		})
	}
}
function validateAndSaveFormData(button) {
	var isErrorOccured=false;
	var errorMessages = [];
	var civilIDElement=document.getElementById("civilId");
	var civilId;
	if(civilIDElement){
	  civilId=document.getElementById("civilId").value;
	}
	var passportNumber = document.getElementById("passportNumber").value;
	var dateOfBirth = document.getElementById("dateOfBirth").value;	
	if(!civilId && !passportNumber && ${empty person.getId()}){
		errorMessages.push("<liferay-ui:message key='please-select-civilId-or-passportNo' />");
		document.getElementById("errorContainer-civilId").textContent = "<liferay-ui:message key='please-select-civilId-or-passportNo' />";
		if(isErrorOccured==false){
			$("#civilId").focus();
			isErrorOccured=true;
		}
	} else{
		document.getElementById("errorContainer-civilId").textContent = "";			 
	}
	if(!dateOfBirth){
		errorMessages.push("<liferay-ui:message key='please-select-dateOfBirth' />");
		document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='please-select-dateOfBirth' />";	 
		if(isErrorOccured==false){
			$("#dateOfBirth").focus();
			isErrorOccured=true;
		}
	} else{
		if(!validateDateOfBirth()){
			errorMessages.push("<liferay-ui:message key='age-error' />");
			if(isErrorOccured==false){
				$("#dateOfBirth").focus();
				isErrorOccured=true;
			}
		}
	}
	if(civilId){
		var civilCardFrontPhoto = document.getElementById("civilCardFrontPhoto").files[0];
		if (!civilCardFrontPhoto) {
			if(${empty personalDetails.civilCardFrontPhotoId || personalDetails.civilCardFrontPhotoId eq 0}){
				errorMessages.push("<liferay-ui:message key='please-upload-civilCardFrontPhoto' />");
				document.getElementById("errorContainer-civilCardFrontPhoto").textContent = "<liferay-ui:message key='please-upload-civilCardFrontPhoto' />";			   
				if(!isErrorOccured){
					document.getElementById("civilCardFrontPhoto").focus();
					isErrorOccured=true;
				}
			}
		} else {
			var photoName=civilCardFrontPhoto.name;
			var ext = photoName.substr(photoName.lastIndexOf("."));
			var allowedExtReg = /(\.jpg|\.jpeg|\.png)$/i;
		 	var allowed=allowedExtReg.test(ext);
		  	if(allowed){
				document.getElementById("errorContainer-civilCardFrontPhoto").textContent = "";			
				const size = (civilCardFrontPhoto.size / 1024 / 1024).toFixed(2);
				if (size > 1) {
					errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
					document.getElementById("errorContainer-civilCardFrontPhoto").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
					if(!isErrorOccured){
						$("#civilCardFrontPhoto").focus();
						isErrorOccured=true;
					}
				} else {
	           		document.getElementById("errorContainer-civilCardFrontPhoto").textContent = "";
	           	}
			} else{
				document.getElementById("errorContainer-civilCardFrontPhoto").textContent = "";
	    	 	document.getElementById("errorContainer-civilCardFrontPhoto").textContent ="<liferay-ui:message key='please-select-image' />";
	    	 	errorMessages.push("<liferay-ui:message key='please-select-image' />");
	    	 	if(!isErrorOccured){
					$("#civilCardFrontPhoto").focus();
					isErrorOccured=true;
				}
	     	}
		}		
		var civilCardBackPhoto = document.getElementById("civilCardBackPhoto").files[0];	
		if (!civilCardBackPhoto) {
			if(${empty personalDetails.civilCardBackPhotoId || personalDetails.civilCardBackPhotoId eq 0}){
				errorMessages.push("<liferay-ui:message key='please-upload-civilCardBackPhoto' />");
				document.getElementById("errorContainer-civilCardBackPhoto").textContent = "<liferay-ui:message key='please-upload-civilCardBackPhoto' />";
				if(!isErrorOccured){
					$("#civilCardBackPhoto").focus();
					isErrorOccured=true;
				}
	     	}
			}
		 else {
			var photoName=civilCardBackPhoto.name;
			var ext = photoName.substr(photoName.lastIndexOf("."));
			var allowedExtReg = /(\.jpg|\.jpeg|\.png)$/i;
		 	var allowed=allowedExtReg.test(ext);
		  	if(allowed){
				document.getElementById("errorContainer-civilCardBackPhoto").textContent = "";
				const size = (civilCardBackPhoto.size / 1024 / 1024).toFixed(2);
				if (size > 1) {
					errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
					document.getElementById("errorContainer-civilCardBackPhoto").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
					if(!isErrorOccured){
						$("#civilCardBackPhoto").focus();
						isErrorOccured=true;
					}
		     	}else {
	           		document.getElementById("errorContainer-civilCardBackPhoto").textContent = "";
	           	}
			}else{
				document.getElementById("errorContainer-civilCardBackPhoto").textContent = "";
	    	 	document.getElementById("errorContainer-civilCardBackPhoto").textContent ="<liferay-ui:message key='please-select-image' />";
	    	 	errorMessages.push("<liferay-ui:message key='please-select-image' />");
	    	 	if(!isErrorOccured){
					$("#civilCardBackPhoto").focus();
					isErrorOccured=true;
				}
	     	}
	     	}
		var fullName = document.getElementById("fullName").value;
	 	if(!fullName){
			errorMessages.push("<liferay-ui:message key='please-enter-fullName' />");
		 	document.getElementById("errorContainer-fullName").textContent = "<liferay-ui:message key='please-enter-fullName' />";
		}else{
			document.getElementById("errorContainer-fullName").textContent = ""; 
	 	}
		var fullNameAr = document.getElementById("fullNameAr").value;
	 	if(!fullNameAr){
			errorMessages.push("<liferay-ui:message key='please-enter-fullName-ar' />");
		 	document.getElementById("errorContainer-fullName-ar").textContent = "<liferay-ui:message key='please-enter-fullName-ar' />";
	 	}else{
			document.getElementById("errorContainer-fullName-ar").textContent = ""; 
	 	}
	}
	else if(passportNumber){
		var countryOfIssue = document.getElementById("countryOfIssue").value;
		if (!countryOfIssue) {
			errorMessages.push("<liferay-ui:message key='please-select-country-of-issue' />");
			document.getElementById("errorContainer-countryOfIssue").textContent = "<liferay-ui:message key='please-select-country-of-issue' />";
			if(!isErrorOccured){
				$("#countryOfIssue").focus();
				isErrorOccured=true;
			}
		}else {
			document.getElementById("errorContainer-countryOfIssue").textContent = "";
		}		
		var passportExpiryDate = document.getElementById("passportExpiryDate").value;
		if (!passportExpiryDate) {
			errorMessages.push("<liferay-ui:message key='please-enter-passport-expiry-date' />");
			document.getElementById("errorContainer-passportExpiryDate").textContent = "<liferay-ui:message key='please-enter-passport-expiry-date' />";
			if(!isErrorOccured){
				$("#passportExpiryDate").focus();
				isErrorOccured=true;
			}
		}else {
			document.getElementById("errorContainer-passportExpiryDate").textContent = "";
		}
		if(passportNumber.length>0){
			var passportPhoto = document.getElementById("passportPhoto").files[0];
			if (!passportPhoto) {
				if(${empty personalDetails.passportPhotoId || personalDetails.passportPhotoId eq 0}){
					errorMessages.push("<liferay-ui:message key='please-upload-passportPhoto' />");
					document.getElementById("errorContainer-passportPhoto").textContent = "<liferay-ui:message key='please-upload-passportPhoto' />";
				}
			}else {
				var photoName=passportPhoto.name;
				var ext = photoName.substr(photoName.lastIndexOf("."));
				var allowedExtReg = /(\.jpg|\.jpeg|\.png)$/i;
			 	var allowed=allowedExtReg.test(ext);
			  	if(allowed){
					document.getElementById("errorContainer-passportPhoto").textContent = "";
					const size = (passportPhoto.size / 1024 / 1024).toFixed(2);
					if (size > 1) {
						errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
						document.getElementById("errorContainer-passportPhoto").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
		           	} else {
		           		document.getElementById("errorContainer-passportPhoto").textContent = "";
		           	}
				} else{
					document.getElementById("errorContainer-passportPhoto").textContent = "";
		    	 	document.getElementById("errorContainer-passportPhoto").textContent ="<liferay-ui:message key='please-select-image' />";
		    	 	errorMessages.push("<liferay-ui:message key='please-select-image' />");
		     	}
			}
		}
		if(!civilId && passportNumber){
			var firstName = document.getElementById("firstName").value;
			if (!firstName) {
				errorMessages.push("<liferay-ui:message key='please-enter-firstname' />");
				document.getElementById("errorContainer-firstName").textContent = "<liferay-ui:message key='please-enter-firstname' />";
				if(!isErrorOccured){
					$("#firstName").focus();
					isErrorOccured=true;
				}
			}else {
				document.getElementById("errorContainer-firstName").textContent = "";
			}	
			var lastName = document.getElementById("lastName").value;
			if (!lastName) {
				errorMessages.push("<liferay-ui:message key='please-enter-lastname' />");
				document.getElementById("errorContainer-lastName").textContent = "<liferay-ui:message key='please-enter-lastname' />";
				if(!isErrorOccured){
					$("#lastName").focus();
					isErrorOccured=true;
				}
			}else {
				document.getElementById("errorContainer-lastName").textContent = "";
			}
		}
	}
	var cvDocument = document.getElementById("cvDocument").files[0];
	if(cvDocument){
	 var allowedExtensionsReg= /(\.pdf|\.docx|\.doc)$/i;
	 var cvDocumentName=cvDocument.name;
	 var ext=cvDocumentName.substr(cvDocumentName.lastIndexOf("."));
	 var isAllowed = allowedExtensionsReg.test(ext);
	 if(${empty personalDetails.cvDocumentId || personalDetails.cvDocumentId eq 0}){
	 if(isAllowed){
			document.getElementById("errorContainer-cvDocument").textContent = "";
			const size = (cvDocument.size / 1024 / 1024).toFixed(2);
			if (size > 1) {
				errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
				document.getElementById("errorContainer-cvDocument").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
           	} else {
           		document.getElementById("errorContainer-cvDocument").textContent = "";
           	}
		} else{
			document.getElementById("errorContainer-cvDocument").textContent = "";
    	 	document.getElementById("errorContainer-cvDocument").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
    	 	errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
    	 	}
	 }
	 }		
	var emailAddress = document.getElementById("emailAddress").value;
	if (!emailAddress) {
		errorMessages.push("<liferay-ui:message key='please-enter-email-address' />");
		document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-email-address' />";
		if(!isErrorOccured){
			$("#emailAddress").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-emailAddress").textContent = "";
		let regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
        if (!regex.test(emailAddress)) {
			document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-valid-email-address' />";
			if(!isErrorOccured){
				$("#emailAddress").focus();
				isErrorOccured=true;
			}
		} else {
			document.getElementById("errorContainer-emailAddress").textContent = "";
			var emailAddressOTPVerified = document.getElementById("emailAddressOTPVerified").value;
			if (emailAddressOTPVerified=='false') {
				errorMessages.push("<liferay-ui:message key='please-verify-email-address' />");
				document.getElementById("errorContainer-emailAddressOTP").textContent = "<liferay-ui:message key='please-verify-email-address' />";
				if(!isErrorOccured){
					$("#emailAddress").focus();
					isErrorOccured=true;
				}
			} else {
				document.getElementById("errorContainer-emailAddressOTP").textContent = "";
			}
		}
	}
	var mobileNumber = document.getElementById("mobileNumber").value;
	if (!mobileNumber) {
		errorMessages.push("<liferay-ui:message key='please-enter-mobile-number' />");
		document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-mobile-number' />";
		if(!isErrorOccured){
			$("#mobileNumber").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-mobileNumber").textContent = "";
		if(hiddenCountryInput.value=="968"){
		var emailAddressOTPVerified = document.getElementById("emailAddressOTPVerified").value;
		if (emailAddressOTPVerified=='false') {
			errorMessages.push("<liferay-ui:message key='please-verify-mobile-number' />");
			document.getElementById("errorContainer-mobileNumberOTP").textContent = "<liferay-ui:message key='please-verify-mobile-number' />";
			if(!isErrorOccured){
				$("#mobileNumber").focus();
				isErrorOccured=true;
			}
		} else {
			document.getElementById("errorContainer-mobileNumberOTP").textContent = "";
		}
	}
	}
	var gender = document.getElementById("gender").value;
	if (!gender) {
		errorMessages.push("<liferay-ui:message key='please-select-gender' />");
		document.getElementById("errorContainer-gender").textContent = "<liferay-ui:message key='please-select-gender' />";
		if(!isErrorOccured){
			$("#gender").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-gender").textContent = "";
	}	
	var nationality = document.getElementById("nationality").value;
	if (!nationality) {
		errorMessages.push("<liferay-ui:message key='please-select-nationality' />");
		document.getElementById("errorContainer-nationality").textContent = "<liferay-ui:message key='please-select-nationality' />";
		if(!isErrorOccured){
			$("#nationality").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-nationality").textContent = "";
	}	
	var portraitId = '${empty user.portraitId}';	
	var profession = document.getElementById("profession").value;
	if (!profession) {
		errorMessages.push("<liferay-ui:message key='please-select-profession' />");
		document.getElementById("errorContainer-profession").textContent = "<liferay-ui:message key='please-select-profession' />";
		if(!isErrorOccured){
			$("#profession").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-profession").textContent = "";
	}	
	var primarySpeciality = document.getElementById("primarySpeciality").value;
	if (!primarySpeciality) {
		errorMessages.push("<liferay-ui:message key='please-select-primary-speciality' />");
		document.getElementById("errorContainer-primarySpeciality").textContent = "<liferay-ui:message key='please-select-primary-speciality' />";
		if(!isErrorOccured){
			$("#primarySpeciality").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-primarySpeciality").textContent = "";
	}	
	var secondarySpeciality = document.getElementById("secondarySpeciality").value;
	if (!secondarySpeciality) {
		errorMessages.push("<liferay-ui:message key='please-select-secondary-speciality' />");
		document.getElementById("errorContainer-secondarySpeciality").textContent = "<liferay-ui:message key='please-select-secondary-speciality' />";
		if(!isErrorOccured){
			$("#secondarySpeciality").focus();
			isErrorOccured=true;
		}
	} else {
		document.getElementById("errorContainer-secondarySpeciality").textContent = "";
	}
		   var workSectorTypeId=$("#workSectorType_1").val();
			if(!workSectorTypeId || workSectorTypeId===""){
				errorMessages.push("<liferay-ui:message key='please-enter-work-sector-type' />");
				$("#work-sector-type-error_1").html("<liferay-ui:message key='please-enter-work-sector-type' />");
				if(!isErrorOccured){
					$("#workSectorType_1").focus();
					isErrorOccured=true;
				}
			} else{
				$("#work-sector-type-error_1").html("");
			}
			var workSector=$("#worksector_1").val();
			var workSectorparentClass=$('#worksector_1').parent().attr('class');
				if(!workSectorparentClass.includes('d-none')){
					if(!workSector || workSector===""){
						errorMessages.push("<liferay-ui:message key='please-enter-work-sector' />");
						$("#work-sector-error_1").html("<liferay-ui:message key='please-enter-work-sector' />");
						if(!isErrorOccured){
							$("#worksector_1").focus();
							isErrorOccured=true;
						}
					} else{
						$("#work-sector-error_1").html("");
					}
				}
			var wilayats=$("#wilayats_1").val();
			if(!wilayats || wilayats===""){
				errorMessages.push("<liferay-ui:message key='please-enter-work-sector-location' />");
				$("#location-error_1").html("<liferay-ui:message key='please-enter-work-sector-location' />");
				if(!isErrorOccured){
					$("#wilayats_1").focus();
					isErrorOccured=true;
				}
			} else{
				$("#location-error_1").html("");
			}
			var designations=$("#designations_1").val();
			if(!designations || designations ===""){
				errorMessages.push("<liferay-ui:message key='please-enter-designation' />");
				$("#designation-error_1").html("<liferay-ui:message key='please-enter-designation' />");
				if(!isErrorOccured){
					$("#designations_1").focus();
					isErrorOccured=true;
				}
			} else{
				$("#designation-error_1").html("");
			}
			var staffCardId = document.getElementById("staffIdCard_1");
			if(staffCardId.files[0]){
				if(!isEditable){
			var filename = staffCardId.files[0].name;
		    var extension = filename.substr(filename.lastIndexOf("."));
			allowedExtensionsRegex = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
			var isAllowed = allowedExtensionsRegex.test(extension);
			     if(isAllowed){
			    	 document.getElementById("file-size-error_1").textContent ="";
			    		const size = (staffCardId.files[0].size / 1024 / 1024).toFixed(2);
						if (size > 1) {
							errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
							document.getElementById("file-size-error_1").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
							if(!isErrorOccured){
								$("#staffIdCard_1").focus();
								isErrorOccured=true;
							}
			            } else {
			            	document.getElementById("file-size-error_1").textContent = "";
			            }
			     }else{
			    	 document.getElementById("file-size-error_1").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
			    	 errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
			    	 if(!isErrorOccured){
							$("#staffIdCard_1").focus();
							isErrorOccured=true;
						}
			     }
		} else{
			isEditable=false;
			document.getElementById("file-size-error_1").textContent = "";
		}
	} else{
		isEditable=false;
		document.getElementById("file-size-error_1").textContent = "";
	}
	var workSectorTypeId2=$("#workSectorType_2").val();		
	if(workSectorTypeId2>0 || workSectorTypeId2 !=""){
		console.log("workSectorTypeId2 2:::",workSectorTypeId2);	
		var workSector=$("#worksector_2").val();
		var workSectorparentClass=$('#worksector_2').parent().attr('class');
			if(!workSectorparentClass.includes('d-none')){
				if(!workSector || workSector===""){
					errorMessages.push("<liferay-ui:message key='please-enter-secondary-work-sector' />");
					$("#work-sector-error_2").html("<liferay-ui:message key='please-enter-secondary-work-sector' />");
					if(!isErrorOccured){
						$("#worksector_2").focus();
						isErrorOccured=true;
					}
				} else{
					$("#work-sector-error_2").html("");
				}
			}
			var wilayats=$("#wilayats_2").val();
				if(!wilayats || wilayats===""){
					errorMessages.push("<liferay-ui:message key='please-enter-secondary-work-sector-location' />");
					$("#location-error_2").html("<liferay-ui:message key='please-enter-secondary-work-sector-location' />");
					if(!isErrorOccured){
						$("#wilayats_2").focus();
						isErrorOccured=true;
					}
				} else{
					$("#location-error_2").html("");
				}
				var designations=$("#designations_2").val();
				if(!designations || designations ===""){
					errorMessages.push("<liferay-ui:message key='please-enter-designation' />");
					$("#designation-error_2").html("<liferay-ui:message key='please-enter-designation' />");
					if(!isErrorOccured){
						$("#designations_2").focus();
						isErrorOccured=true;
					}
				} else{
					$("#designation-error_2").html("");
				}
	}		
	var staffCardId_2 = document.getElementById("staffIdCard_2");
	if(staffCardId_2.files[0]){
		if(!isEditable){	
	var filename_2 = staffCardId_2.files[0].name;
    var extension_2 = filename_2.substr(filename_2.lastIndexOf("."));
	allowedExtensionsRegex_2 = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
	var isAllow = allowedExtensionsRegex_2.test(extension_2);
	     if(isAllow){
	    	 document.getElementById("file-size-error_2").textContent ="";
	    		const size = (staffCardId_2.files[0].size / 1024 / 1024).toFixed(2);
				if (size > 1) {
					errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
					document.getElementById("file-size-error_2").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
					 if(!isErrorOccured){
							$("#staffIdCard_2").focus();
							isErrorOccured=true;
						}
	            } else {
	            	document.getElementById("file-size-error_2").textContent = "";
	            }
	     }else{
	    	 document.getElementById("file-size-error_2").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
	    	 errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
	    	 if(!isErrorOccured){
					$("#staffIdCard_2").focus();
					isErrorOccured=true;
				}
	     }	
	} else{
			isEditable=false;
			document.getElementById("file-size-error_2").textContent = "";
	}
} else{
	isEditable=false;
	document.getElementById("file-size-error_2").textContent = "";
}	
	if (errorMessages.length > 0) {
		event.preventDefault();
	} else {
		elementCount();
		document.getElementById("rdFM").submit();
	}
}
var list = ${qualificationArray};
var institutionList=${institutionList};
var rowIndexer=[];
var imagePath=$('#imagePath').val();
var qualificationHtml='';
var institutionHtml='';
var countryHtml='';
$(document).on('change','.custom-file-input', function () {
	var fileName = $(this).val().split("\\").pop();	
	$(this).siblings(".custom-file-label").html(`<span>\${fileName}</span>`);
});
function saveEducationDetails(){
	if(isValidVerificationField()){	
		var uploadFile = document.getElementById("qualificationdoc").files[0];
		var formData = new FormData();
		formData.append('<portlet:namespace />qualificationDoc', uploadFile);
		formData.append('<portlet:namespace />qualification', $("#qualification").val().trim());
		formData.append('<portlet:namespace />institution', $("#institution").val().trim());
		formData.append('<portlet:namespace />country', $("#country").val().trim());
		formData.append('<portlet:namespace />year', $("#year").val().trim());
		formData.append('<portlet:namespace />id', $("#id").val().trim());
		formData.append('<portlet:namespace />personId', $("#personId").val().trim());
		formData.append('<portlet:namespace />lrUserId', $("#lrUserId").val().trim());		
		$.ajax({
			url: '${saveEducationDetailsURL}',
			type:'POST',
	      	processData: false,
	      	contentType: false,
	      	async: false,
	      	cache: false,
	      	data : formData,
			success : function(data) {
				isEdit=false;
				document.getElementById("qualification").value = "";
				document.getElementById("institution").value = "";
				document.getElementById("country").value = "";
				document.getElementById("year").value = "";
				document.getElementById("id").value = '';
				document.getElementById("qualificationdoclbl").innerHTML = '';
				$("#educationDetailsList").html(data);
				$('#work-detail-list').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
				$("#add-education-confirm-modal").modal('hide');
			},
		})
	}
}
function saveWorkDetailsDetails(){						
		var uploadFile = document.getElementById("staffIdCard_3").files[0];
		var formData = new FormData();
		formData.append('<portlet:namespace />staffIdCard_3', uploadFile);
		formData.append('<portlet:namespace />workSectorType_3', $("#workSectorType_3").val().trim());
		formData.append('<portlet:namespace />worksectortypeother_3', $("#worksectortypeother_3").val().trim());
		formData.append('<portlet:namespace />worksector_3', $("#worksector_3").val().trim());
		formData.append('<portlet:namespace />worksectorother_3', $("#worksectorother_3").val().trim());
		formData.append('<portlet:namespace />first_sub_worksector_3', $("#first-sub-worksector_3").val().trim());
		formData.append('<portlet:namespace />work_sub_sectorother_3', $("#work_sub_sectorother_3").val().trim());
		formData.append('<portlet:namespace />second_sub_worksector_3', $("#second-sub-worksector_3").val().trim());
		formData.append('<portlet:namespace />worksecondsectorother_3', $("#worksecondsectorother_3").val().trim());
		formData.append('<portlet:namespace />wilayats_3', $("#wilayats_3").val().trim());
		formData.append('<portlet:namespace />designations_3', $("#designations_3").val().trim());
		formData.append('<portlet:namespace />designationother_3', $("#designationother_3").val().trim());
		formData.append('<portlet:namespace />id',  $("#id").val().trim());
		formData.append('<portlet:namespace />personId', $("#personId").val().trim());
		formData.append('<portlet:namespace />lrUserId', $("#lrUserId").val().trim());		
		$.ajax({
			url: '${saveWorkDetailsURL}',
			type:'POST',
	      	processData: false,
	      	contentType: false,
	      	async: false,
	      	cache: false,
	      	data : formData,
			success : function(data) {
				isEdit=false;
				$("#workDetailList").html(data);
				$('#work-detail-list1').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
				$("#add-work-detail-confirm-modal").modal('hide');
			},
		})
}
function deleteEduSection(){
	var deleteId = document.getElementById("deleteID").value;
	var personId = document.getElementById("personId").value;
	var lrUserId = document.getElementById("lrUserId").value;
	if(deleteId){
		$.ajax({
			url: '${deleteEducationDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : deleteId,
				<portlet:namespace />personId : personId, 
				<portlet:namespace />lrUserId : lrUserId, 
			},
			type : 'POST',
			success : function(data) {
				isEdit=false;
				$('#delete-education-confirm-modal').modal('hide');
				document.getElementById("qualification").value = "";
				document.getElementById("institution").value = "";
				document.getElementById("country").value = "";
				document.getElementById("year").value = "";
				document.getElementById("id").value = '';
				document.getElementById("qualificationdoclbl").innerHTML = '';
				$("#educationDetailsList").html(data);
				$('#work-detail-list').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
			},
		})
	}
}
function deleteWorkSection(){
	var deleteId = document.getElementById("deleteID").value;
	var personId = document.getElementById("personId").value;
	if(deleteId){
		$.ajax({
			url: '${deleteWorkDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : deleteId,
				<portlet:namespace />personId : personId 
			},
			type : 'POST',
			success : function(data) {
				isEdit=false;
				$('#delete-work-confirm-modal').modal('hide');
				document.getElementById("qualification").value = "";
				document.getElementById("institution").value = "";
				document.getElementById("country").value = "";
				document.getElementById("year").value = "";
				document.getElementById("id").value = '';
				document.getElementById("qualificationdoclbl").innerHTML = '';
				$("#workDetailList").html(data);
				$('#work-detail-list1').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
			},
		})
	}
}
function setEditID(id){
	if(id){
		document.getElementById("qualification").value = '';
		document.getElementById("institution").value = '';
		document.getElementById("country").value = '';
		document.getElementById("year").value = '';
		document.getElementById("id").value = '';
		document.getElementById("qualificationdoclbl").innerHTML = '';
		$("#view-div").removeClass("d-none");
		$.ajax({
			url: '${getEducationDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : id,
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				if(response.isValid){
					const educationDetails = JSON.parse(response.educationDetail);
					const obj = JSON.parse(response.instituteArray);
					var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
					for (var i = 0; i < obj.length; i++) {
						var item = obj[i];
						var id = item.id;
						if (themeDisplay.getLanguageId() == 'en_US') {
							sectionData += "<option value='" + id + "'>"+ item.englishName + "</option>";
						} else {
							sectionData += "<option value='" + id + "'>"+ item.arabicName + "</option>";
						}
					}
					$("#institution").html(sectionData);
					document.getElementById("qualification").value = educationDetails.qualificationAttained;
					var selectionQqualification = $('option:selected', $('#qualification'));
					document.getElementById('select2-qualification-container').innerHTML=selectionQqualification.text().trim();
					document.getElementById("institution").value = educationDetails.issuingAuthorityName;
					var selectionInstitution = $('option:selected', $('#institution'));
					document.getElementById('select2-institution-container').innerHTML=selectionInstitution.text().trim();
					document.getElementById("country").value = educationDetails.issuingAuthorityCountryId;
					var selectionCountry = $('option:selected', $('#country'));
					document.getElementById('select2-country-container').innerHTML=selectionCountry.text().trim();
					document.getElementById("year").value = educationDetails.yearOfGraduation;
					var selectionYear = $('option:selected', $('#year'));
					document.getElementById('select2-year-container').innerHTML=selectionYear.text().trim();
					document.getElementById("id").value = educationDetails.id;
					document.getElementById("view-file").setAttribute("href",educationDetails.documentInfo.documentURL);
					if(educationDetails!=null){
						if(educationDetails.documentInfo!=null){
							if(educationDetails.documentInfo.dFFileName!=null){
								document.getElementById("qualificationdoclbl").innerHTML = educationDetails.documentInfo.dFFileName;
								isEdit=true;
							}
						}
					}
				}
			}
		})
	}
}
function setWorkDetailEditID(id){
	if(id){
		document.getElementById("workSectorType_3").value = '';
		document.getElementById("worksectortypeother_3").value = '';
		document.getElementById("worksector_3").value = '';
		document.getElementById("worksectorother_3").value = '';
		document.getElementById("first-sub-worksector_3").value = '';
		document.getElementById("worksectorother_3").value = '';
		document.getElementById("wilayats_3").value = '';
		document.getElementById("designations_3").value = '';
		document.getElementById("customStaffIdCard_3").value = '';
		$.ajax({
			url: '${getWorkDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : id,
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);				
				if(response.isValid){
					const workDetails = JSON.parse(response.workDetail);
					const workSectorData = JSON.parse(response.workSectorData);
					const workSectorData2 = JSON.parse(response.workSectorData2);
					const workSectorData3 = JSON.parse(response.workSectorData3);
					document.getElementById("workSectorType_3").value = workDetails.workSectorType;
					var selectionworkSectorType_3 = $('option:selected', $('#workSectorType_3'));
					document.getElementById('select2-workSectorType_3-container').innerHTML=selectionworkSectorType_3.text().trim();
					document.getElementById("wilayats_3").value = workDetails.workSectorLocation;
					var selectionwilayats_3 = $('option:selected', $('#wilayats_3'));
					document.getElementById('select2-wilayats_3-container').innerHTML=selectionwilayats_3.text().trim();
					document.getElementById("designations_3").value = workDetails.designationId;
					var selectionDesignations_3 = $('option:selected', $('#designations_3'));
					document.getElementById('select2-designations_3-container').innerHTML=selectionDesignations_3.text().trim();
					document.getElementById("year").value = workDetails.yearOfGraduation;
					document.getElementById("id").value = workDetails.id;
					document.getElementById("view-file").setAttribute("href",workDetails.documentUrl);
					if(workDetails.workSectorOther2 !=null && workDetails.workSectorOther2!=''){
						$("#div-first-sub-sector_3").removeClass("d-none");
						document.getElementById("first-sub-worksector_3").value = 'other';						
						document.getElementById("work_sub_sectorother_3").value = workDetails.workSectorOther2;
						$("#div-o3-work-other_3").removeClass("d-none");
						$("#div-o2-work-other_3").addClass("d-none");
						$("#div-first-sub-sector_3").removeClass("d-none");
						$("#div-o3-work-other_3").removeClass("d-none");
						$("#worksectorTypediv_3").addClass("d-none");
						$("#work-sector-div_3").removeClass("d-none");
						$("#div-second-sub-sector_3").addClass("d-none");
						$("#div-o3-secons-work-other_3").addClass("d-none");
					}					
					if(workDetails.workSectorId2 !=null && workDetails.workSectorId2!= ''){
						updateOtherDropdown(workSectorData2,"first-sub-worksector_3");
						document.getElementById("first-sub-worksector_3").value = workDetails.workSectorId2;
						var selectionfirstSubWorksector3 = $('option:selected', $('#first-sub-worksector_3'));
						document.getElementById('select2-first-sub-worksector_3-container').innerHTML=selectionfirstSubWorksector3.text().trim();
						$("#div-first-sub-sector_3").removeClass("d-none");
						$("#worksectorTypediv_3").addClass("d-none");						
						document.getElementById("work_sub_sectorother_3").value ='';						
						$("#div-o3-work-other_3").addClass("d-none");
						$("#div-o2-work-other_3").addClass("d-none");
						$("#work-sector-div_3").removeClass("d-none");					
						if(workDetails.workSectorId3 != null && workDetails.workSectorId3 != ''){
							$("#div-second-sub-sector_3").removeClass("d-none");
							updateOtherDropdown(workSectorData3,"second-sub-worksector_3");
							document.getElementById("second-sub-worksector_3").value = workDetails.workSectorId3;
							var selectionSecondSubWorksector3 = $('option:selected', $('#second-sub-worksector_3'));
							document.getElementById('select2-second-sub-worksector_3-container').innerHTML=selectionSecondSubWorksector3.text().trim();
						}
						if(workDetails.workSectorOther3 != null  && workDetails.workSectorOther3 != ''){
							$("#div-o3-secons-work-other_3").removeClass("d-none");
							document.getElementById("worksecondsectorother_3").value = workDetails.workSectorOther3;							
							$("#div-second-sub-sector_3").removeClass("d-none");
							document.getElementById("second-sub-worksector_3").value = 'other';
						}						
					}
					if(workDetails.workSectorOther !=null && workDetails.workSectorOther !=''){
						document.getElementById("worksector_3").value ='other';
						$("#div-o2-work-other_3").removeClass("d-none");
						$("#work-sector-div_3").removeClass("d-none");
						$("#worksectorTypediv_3").addClass("d-none");
						document.getElementById("worksectorother_3").value =workDetails.workSectorOther;						
						$("#div-first-sub-sector_3").addClass("d-none");
						$("#div-o3-work-other_3").addClass("d-none");
						document.getElementById("work_sub_sectorother_3").value = '';
					}
					if(workDetails.workSectorId != null && workDetails.workSectorId != ''){
						updateOtherDropdown(workSectorData,"worksector_3");
						document.getElementById("worksector_3").value = workDetails.workSectorId;
						var selectionworksector3 = $('option:selected', $('#worksector_3'));
						document.getElementById('select2-worksector_3-container').innerHTML=selectionworksector3.text().trim();
						$("#worksectorTypediv_3").addClass("d-none");						
						if(workDetails.workSectorOther2 ==null && workDetails.workSectorOther2==''){
							$("#div-o3-work-other_3").addClass("d-none");
							document.getElementById("work_sub_sectorother_3").value = '';
						}else if((workDetails.workSectorId2 ==null || workDetails.workSectorId2== '')  && (workDetails.workSectorOther2 ==null && workDetails.workSectorOther2=='')){
							$("#div-first-sub-sector_3").addClass("d-none");
						}
					}
					if(workDetails.workSectorTypeOther != null && workDetails.workSectorTypeOther !=''){
						$("#work-sector-div_3").addClass("d-none");
						$("#div-o2-work-other_3").addClass("d-none");
						$("#div-first-sub-sector_3").addClass("d-none");
						$("#div-o3-work-other_3").addClass("d-none");
						$("#worksectorTypediv_3").removeClass("d-none");
						document.getElementById("worksectortypeother_3").value = workDetails.workSectorTypeOther;						
						$("#div-second-sub-sector_3").addClass("d-none");
						$("#div-o3-secons-work-other_3").addClass("d-none");						
					}
					if(workDetails!=null){
						if(workDetails.documentUrl!=null){
							if(workDetails.uploadFileName!=null){
								document.getElementById("customStaffIdCard_3").innerHTML = workDetails.uploadFileName;
								isEdit=true;
							}
						}
					}
				}
			}
		})
	}
}
let isEdit = false;
function isValidVerificationField(){
	var errorMessages = [];
	var qualification = document.getElementById("qualification").value;
	if (!qualification) {
		errorMessages.push("<liferay-ui:message key='please-select-qualification' />");
		document.getElementById("errorContainer-qualification").textContent = "<liferay-ui:message key='please-select-qualification' />";
	} else {
		document.getElementById("errorContainer-qualification").textContent = "";
	}	
	var institution = document.getElementById("institution").value;
	if (!institution) {
		errorMessages.push("<liferay-ui:message key='please-select-institute' />");
		document.getElementById("errorContainer-institution").textContent = "<liferay-ui:message key='please-select-institute' />";
	} else {
		document.getElementById("errorContainer-institution").textContent = "";
	}	
	var country = document.getElementById("country").value;
	if (!country) {
		errorMessages.push("<liferay-ui:message key='please-select-country' />");
		document.getElementById("errorContainer-country").textContent = "<liferay-ui:message key='please-select-country' />";
	} else {
		document.getElementById("errorContainer-country").textContent = "";
	}	
	var year = document.getElementById("year").value;
	if (!year) {
		errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
		document.getElementById("errorContainer-year-of-graducation").textContent = "<liferay-ui:message key='please-select-year-of-graduation' />";
	} else {
		document.getElementById("errorContainer-year-of-graducation").textContent = "";
	}	
	var qualificationDoc = document.getElementById("qualificationdoc").files[0];
	if (!qualificationDoc) {
		if(!isEdit){
			errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
			document.getElementById("errorContainer-qualification-document").textContent = "<liferay-ui:message key='please-upload-qualification-document' />";
		} else {
			isEdit=false;
			document.getElementById("errorContainer-qualification-document").textContent = "";
		}
	} else {
		isEdit=false;
		document.getElementById("errorContainer-qualification-document").textContent = "";
		 var filename = qualificationDoc.name;
	     var extension = filename.substr(filename.lastIndexOf("."));
		  allowedExtensionsRegex = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
		  var isAllowed = allowedExtensionsRegex.test(extension);
		  if(isAllowed){
		    		const size = (qualificationDoc.size / 1024 / 1024).toFixed(2);
					if (size > 1) {
						errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
						document.getElementById("errorContainer-qualification-document").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
		            } else {
		            	document.getElementById("errorContainer-qualification-document").textContent = "";
		            }
		     }else{
		    	 document.getElementById("errorContainer-qualification-document").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
		    	 errorMessages.push("<liferay-ui:message key='lease-select-pdf-file' />");
		     }
	}   
	let isValid = false;
	if (errorMessages.length == 0) {
		isValid = true;
	}
	return isValid;
}
 function getWorkSector(id){
	        	var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 $('#div-o3-work-other_'+substring).addClass('d-none');
				 $('#div-o2-work-other_'+substring).addClass('d-none');
				 if(selectedValue){
						 $('#worksectorTypediv_'+substring).addClass('d-none'); 
					 $.ajax({
							url: '${getWorkSectorByWorkSectorType}',
							async : false,
							data : {
								<portlet:namespace />workSectorType : selectedValue
							},
							type : 'POST',
							success : function(data) {
								var options = JSON.parse(data);
								if(options[0].id=="other"){
									 $('#worksectorTypediv_'+substring).removeClass('d-none');
									 $('#work-sector-div_'+substring).addClass('d-none');
									 $('#div-first-sub-sector_'+substring).addClass('d-none');
									 $('#div-o3-work-other_'+substring).addClass('d-none');
									 $('#div-o2-work-other_'+substring).addClass('d-none');
									  $('#div-second-sub-sector_'+substring).addClass('d-none');
									  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
									  $('#div-first-sub-sector_'+substring).addClass('d-none');
								 }else{
									 updateOtherDropdown(options,"worksector_"+substring);
									 $('#work-sector-div_'+substring).removeClass('d-none'); 
									  $('#div-second-sub-sector_'+substring).addClass('d-none');
									  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
									  $('#div-first-sub-sector_'+substring).addClass('d-none');
								 }
							}
					 });
				 }else{
					 var otherDropdown = document.getElementById("worksector_"+substring); 
					  otherDropdown.innerHTML = '';
			            var optElement = document.createElement('option');
			            optElement.value="";
			            optElement.textContent = '<liferay-ui:message key="select" />';
			            otherDropdown.appendChild(optElement);
			            $('#worksectorTypediv_'+substring).addClass('d-none');   
			            $('#work-sector-div_'+substring).removeClass('d-none');   
			            $('#div-first-sub-sector_'+substring).addClass('d-none'); 
			            $('#div-second-sub-sector_'+substring).addClass('d-none'); 
			            $('#div-o3-secons-work-other_'+substring).addClass('d-none'); 
				 }
	        }
		function updateOtherDropdown(options,field) {
		    var otherDropdown = document.getElementById(field);
		    otherDropdown.innerHTML = '';
		    var optElement = document.createElement('option');
		    optElement.value="";
		    optElement.textContent = '<liferay-ui:message key="select" />';
		    otherDropdown.appendChild(optElement);
		    options.forEach(function(option) {
		        var optionElement = document.createElement('option');
		        optionElement.value = option.id;
		        optionElement.textContent = option.value;
		        otherDropdown.appendChild(optionElement);
		    });
		}
 function getChildWorkSector(id,field){
	    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 if(selectedValue){
					 $("#div-second-sub-sector_"+substring).addClass('d-none');	
					 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
					 if(selectedValue =='other'){
						 $("#div-o2-work-other_"+substring).removeClass("d-none");
						 $("#div-first-sub-sector_"+substring).addClass("d-none");
						 $("#div-o3-work-other_"+substring).addClass('d-none');	
					 }else{
						 $.ajax({
								url: '${ getWorkSectorByParentWorkSector}',
								async : false,
								data : {
									<portlet:namespace />parentWorkSectorId : selectedValue
								},
								type : 'POST',
								success : function(data) {
									$("#div-o2-work-other_"+substring).addClass('d-none');
									$("#div-o3-work-other_"+substring).addClass('d-none');
									var options = JSON.parse(data);
									if(field=="first"){
										if(options.length>0){
											$("#div-first-sub-sector_"+substring).removeClass("d-none");
											updateOtherDropdown(options,"first-sub-worksector_"+substring);		
										}else{
											$("#div-first-sub-sector_"+substring).addClass("d-none");
										}
									}
									else if(field=="second"){
										if(options.length>0){
											$("#div-first-sub-sector_"+substring).removeClass("d-none");
											updateOtherDropdown(options,"second-sub-worksector_"+substring);
										}else{
											$("#div-first-sub-sector_"+substring).addClass("d-none");
										}
									}
								}
						 });
					 }
				 }else{
					 $("#div-o3-work-other_"+substring).addClass('d-none');
					 $("#div-o2-work-other_"+substring).addClass('d-none');
					 $("#div-first-sub-sector_"+substring).addClass('d-none');
					 $("#div-second-sub-sector_"+substring).addClass('d-none');
					 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
				 }
}
 function getChildWorkSector2(id,field){
		  $('#div-second-sub-sector_'+substring).addClass('d-none');
		  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
 	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
			 var selectedValue= $("#"+id).find('option:selected').val();
			 if(selectedValue){
			 	if(selectedValue =='other'){
					 $("#div-o3-work-other_"+substring).removeClass("d-none");
					 $("#div-second-sub-sector_"+substring).addClass("d-none");
					 $("#div-o3-secons-work-other_"+substring).addClass("d-none");
			 	}else{
			 		$.ajax({
						url: '${ getWorkSectorByParentWorkSector}',
						async : false,
						data : {
							<portlet:namespace />parentWorkSectorId : selectedValue
						},
						type : 'POST',
						success : function(data) {
							$("#div-o3-work-other_"+substring).addClass('d-none');
							var options = JSON.parse(data);
							if(field=="first"){
								if(options.length>0){
									$("#div-second-sub-sector_"+substring).removeClass("d-none");
									updateOtherDropdown(options,"first-sub-worksector_"+substring);		
								}else{
									$("#div-second-sub-sector_"+substring).addClass("d-none");
								}
							}
							else if(field=="second"){
								if(options.length>0){
									$("#div-second-sub-sector_"+substring).removeClass("d-none");
									updateOtherDropdown(options,"second-sub-worksector_"+substring);
								}else{
									$("#div-second-sub-sector_"+substring).addClass("d-none");
								}
							}
						}
				 });
			 	}
		 	}else{
		 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
		 		 $("#div-second-sub-sector_"+substring).addClass('d-none');
		 		 $("#div-o3-work-other_"+substring).addClass('d-none');
		 	}
    }
       function setSecondarySpeciality(){
       	var secondarySpeciality ='${personalDetails.secondarySpeciality}';
       	var primarySpeciality=$('#primarySpeciality').val();
       	$.ajax({
       		url: '${specialityListURL}',
       		async : false,
       		dataType:"json",
       		data : {
       			<portlet:namespace />primarySpeciality : primarySpeciality,
       		},
       		type : 'POST',
       		success : function(data) {
                   var subSpecialityList = data;
                   $('#secondarySpeciality').empty();
                   $('#secondarySpeciality').append("<option value=''><liferay-ui:message key="select"/></option> ");
                   $.each(subSpecialityList, function (i, item) {
                   	var selectedSecondaySpeciality = "";
                   	if (item.subSpecilaity === secondarySpeciality) {
       		            selectedSecondaySpeciality = "selected";
       	              }
                       $('#secondarySpeciality').append("<option value='" + item.subSpecilaity + "'" + selectedSecondaySpeciality + ">" + item.subSpecilaityName + "</option> ");
                   })
                   },
       	})
       }
        const imageUpload = document.getElementById('imageUpload');
       const imagePreview = document.getElementById('imagePreview');
       imageUpload.addEventListener('change', function () {
           const file = this.files[0];
           if (file) {
           	 var filename = file.name;
           	    var extension = filename.substr(filename.lastIndexOf("."));
           	    var allowedExtensionsReg = /(\.jpg|\.jpeg|\.png)$/i;
           	    var isAllowed = allowedExtensionsReg.test(extension);
           	    if(isAllowed){
           	   	 $("#profile-error-container").html("");
           	   	 const reader = new FileReader();
                    reader.onload = function (e) {
                        imagePreview.src = e.target.result;
                        imagePreview.style.display = 'block';
                    };
                    reader.readAsDataURL(file);
                    uploadUserPhoto(${user_.userId},file);
           	    }else{
           	   	 $("#profile-error-container").text("<liferay-ui:message key='please-select-image' />");
           	    }
           }
       });  
       function uploadUserPhoto(userId,file){
       	var formData = new FormData();
			formData.append('<portlet:namespace />uploadFile', file);
			formData.append('<portlet:namespace />userId', userId);
       	$.ajax
           ({
           	type:'POST',
		      	processData: false,
		      	contentType: false,
		      	async: false,
		      	cache: false,
               data: formData,
               url: '<%=fileUploadURL%>',
               success: function (data, status){
                },
               error: function (data, status, e) {
					console.log("file upload failed");
               }
           }) 
          return false;
       }
 $('input[name="<portlet:namespace/>associated"]').change(function() {
	var passoc = $("input[name='<portlet:namespace/>associated']:checked").val();
	if(passoc == 0 || passoc == "0" ) {
		$("#txtIndex").val("2");
		$("#isAssosiated").val("false");
		$('#registrant_detail_area').removeClass("d-none");
		$('#associated_detail_area').addClass("d-none");
		$('#requestForService').val(false);
	}
	else{
		$('#requestForService').val(false);
		$("#txtIndex").val("1");
		$("#isAssosiated").val("true");
		$('#associated_detail_area').removeClass("d-none");
		$('#registrant_detail_area').addClass("d-none");
	}
});
$('input[name="<portlet:namespace/>registering"]').change(function() {
	var preg = $("input[name='<portlet:namespace/>registering']:checked").val();
	if(preg == 0 || preg == "0" ) {
		$('#service_detail_area').removeClass("d-none");
		$('#role_detail_area').addClass("d-none");
		$('#requestForService').val(true);
	}
	else{
		$("#txtIndex").val("2");
		$('#role_detail_area').removeClass("d-none");
		$('#service_detail_area').addClass("d-none");
		$('#requestForService').val(false);
	}
}); 
function setRoleServiceID(id){
	if(id){
		document.getElementById("role_1").value = '';
		document.getElementById("department_1").value = '';
		$.ajax({
			url: '${getRoleServiceURL}',
			async : false,
			data : {
				<portlet:namespace />id : id,
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				const userMetadata = JSON.parse(response.userMetadata);
				if(userMetadata.associated){
					$("#registrant_detail_area").addClass("d-none");
					$("#associated_detail_area").removeClass("d-none");
					$("#txtIndex").val("1");
					document.getElementById("role_1").value = userMetadata.roleId;
					var selectionRole_1 = $('option:selected', $('#role_1'));
					document.getElementById('select2-role_1-container').innerHTML=selectionRole_1.text().trim();				
					document.getElementById("department_1").value = userMetadata.departmentId;
					var selectiondepartment_1 = $('option:selected', $('#department_1'));
					document.getElementById('select2-department_1-container').innerHTML=selectiondepartment_1.text().trim();					
					document.getElementById("id").value = userMetadata.id;					
					document.getElementById("section_1").value = userMetadata.sectionId;
					var selectionsection_1 = $('option:selected', $('#section_1'));
					document.getElementById('select2-section_1-container').innerHTML=selectionsection_1.text().trim();					
					document.getElementById("function_1").value = userMetadata.functionId;
					var selectionfunction_1 = $('option:selected', $('#function_1'));
					document.getElementById('select2-function_1-container').innerHTML=selectionfunction_1.text().trim();					
					document.getElementById("programtype_1").value = userMetadata.programTypeId;
					var selectionprogramtype_1 = $('option:selected', $('#programtype_1'));
					document.getElementById('select2-programtype_1-container').innerHTML=selectionprogramtype_1.text().trim();					
					document.getElementById("program_1").value = userMetadata.programId;
					var selectionprogram_1 = $('option:selected', $('#program_1'));
					document.getElementById('select2-program_1-container').innerHTML=selectionprogram_1.text().trim();					
					document.getElementById("programPosition_1").value = userMetadata.programPositionId;
					var selectionProgramPosition_1 = $('option:selected', $('#programPosition_1'));
					document.getElementById('select2-programPosition_1-container').innerHTML=selectionProgramPosition_1.text().trim();					
					document.getElementById("purpose_1").value = userMetadata.purposeId;
					var selectionPurpose_1 = $('option:selected', $('#purpose_1'));
					document.getElementById('select2-purpose_1-container').innerHTML=selectionPurpose_1.text().trim();					
					setRole_1($('option:selected', $('#role_1')).text().trim());
					resetRoleForm();
				}else{
					$("#txtIndex").val("2");
					$("#registrant_detail_area").removeClass("d-none");
					$("#associated_detail_area").addClass("d-none");					
					document.getElementById("role").value = userMetadata.roleId;
					var selectionRole = $('option:selected', $('#role'));
					document.getElementById('select2-role-container').innerHTML=selectionRole.text().trim();					
					document.getElementById("department_2").value = userMetadata.departmentId ;
					var selectionDepartment_2 = $('option:selected', $('#department_2'));
					document.getElementById('select2-department_2-container').innerHTML=selectionDepartment_2.text().trim();					
					document.getElementById("section_2").value = userMetadata.sectionId;
					var selectionSection_2 = $('option:selected', $('#section_2'));
					document.getElementById('select2-section_2-container').innerHTML=selectionSection_2.text().trim();					
					document.getElementById("function_2").value = userMetadata.functionId;
					var selectionFunction_2 = $('option:selected', $('#function_2'));
					document.getElementById('select2-function_2-container').innerHTML=selectionFunction_2.text().trim();					
					document.getElementById("programtype_2").value = userMetadata.programTypeId;
					var selectionprogramtype_2 = $('option:selected', $('#programtype_2'));
					document.getElementById('select2-programtype_2-container').innerHTML=selectionprogramtype_2.text().trim();					
					document.getElementById("programPosition_2").value = userMetadata.programPositionId;
					var selectionProgramPosition_2 = $('option:selected', $('#programPosition_2'));
					document.getElementById('select2-programPosition_2-container').innerHTML=selectionProgramPosition_2.text().trim();					
					document.getElementById("purpose_2").value = userMetadata.purposeId;
					var selectionPurpose_2 = $('option:selected', $('#purpose_2'));
					document.getElementById('select2-purpose_2-container').innerHTML=selectionPurpose_2.text().trim();					
					document.getElementById("program_2").value = userMetadata.programId;
					var selectionprogram_2 = $('option:selected', $('#program_2'));
					document.getElementById('select2-program_2-container').innerHTML=selectionprogram_2.text().trim();					
					document.getElementById("committe_2").value = userMetadata.committeeId;
					var selectionCommitte_2 = $('option:selected', $('#committe_2'));
					document.getElementById('select2-committe_2-container').innerHTML=selectionCommitte_2.text().trim();
					setRole($('option:selected', $('#role')).text().trim());
					resetRole_1Form();
				}		
			}
		})
	}
}
function deleteRoleServiceSection(){
	var deleteId = document.getElementById("deleteID").value;
	var lrUserId = document.getElementById("lrUserId").value;	
	if(deleteId){
		$.ajax({
			url: '${deleteRoleServiceURL}',
			async : false,
			data : {
				<portlet:namespace />id : deleteId,
				<portlet:namespace />lrUserId : lrUserId 
			},
			type : 'POST',
			success : function(data) {
				isEdit=false;
				$('#delete-role-service-modal').modal('hide');
				$("#roleServiceList").html(data);
				$('#role-service-list').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
			},
		})
	}
}
function saveRoleService(){	
	if(validateRoleService()){		
		var txtIndex = $("#txtIndex").val().trim();
		var requestForService=$("#requestForService").val();
		console.log("requestForService ::::::",requestForService);
		var formData = new FormData();
		formData.append('<portlet:namespace />requestForService',$("#requestForService").val().trim());
		formData.append('<portlet:namespace />associated',$("#isAssosiated").val().trim());
		formData.append('<portlet:namespace />role_1', $("#role_1").val().trim());
		formData.append('<portlet:namespace />department_1', $("#department_1").val().trim());
		formData.append('<portlet:namespace />section_1', $("#section_1").val().trim());
		formData.append('<portlet:namespace />committe_1', $("#committe_1").val().trim());
		formData.append('<portlet:namespace />function_1', $("#function_1").val().trim());
		formData.append('<portlet:namespace />programtype_1', $("#programtype_1").val().trim());
		formData.append('<portlet:namespace />program_1', $("#program_1").val().trim());
		formData.append('<portlet:namespace />programPosition_1', $("#programPosition_1").val().trim());
		formData.append('<portlet:namespace />purpose_1', $("#purpose_1").val().trim());
		formData.append('<portlet:namespace />role_2', $("#role").val().trim());
		formData.append('<portlet:namespace />department_2', $("#department_2").val().trim());
		formData.append('<portlet:namespace />section_2', $("#section_2").val().trim());
		formData.append('<portlet:namespace />committe_2', $("#committe_2").val().trim());
		formData.append('<portlet:namespace />function_2', $("#function_2").val().trim());
		formData.append('<portlet:namespace />programtype_2', $("#programtype_2").val().trim());
		formData.append('<portlet:namespace />program_2', $("#program_2").val().trim());
		formData.append('<portlet:namespace />programPosition_2', $("#programPosition_2").val().trim());
		formData.append('<portlet:namespace />purpose_2', $("#purpose_2").val().trim());
		formData.append('<portlet:namespace />index',txtIndex);		
		formData.append('<portlet:namespace />id', $("#id").val().trim());
		formData.append('<portlet:namespace />personId', $("#personId").val().trim());
		formData.append('<portlet:namespace />lrUserId', $("#lrUserId").val().trim());	
		$.ajax({
			url: '${saveRoleServiceURL}',
			type:'POST',
	     	processData: false,
	     	contentType: false,
	     	async: false,
	     	cache: false,
	     	data : formData,
			success : function(data) {
				isEdit=false;
				resetRoleForm();
				resetRole_1Form();				
				$("#roleServiceList").html(data);
				$('#role-service-list').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
				if(requestForService){
					console.log("inside requesting for service::");
					$("#").removeClass("d-none");
				}else{
					console.log("inside requesting for role::");
					$("#add_role-service").addClass("d-none");
				}
				$("#add-role-service-confirm-modal").modal('hide');
				//$("#add_role-service").addClass("d-none");
			},
		});
	}
}
function setSection(departmentId,sectionId){
		var inputDepartmentId=$("#"+departmentId).val();
		$.ajax({
			url: '${sectionDepartmentURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />departmentId : inputDepartmentId,
			},
			type : 'POST',
			success : function(data) {
				 var response=data;
				var sectionData="<option value=''><liferay-ui:message key='select'/></option>";				
				$.each(response, function( index, value ) {
					sectionData=sectionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+sectionId).html("").append(sectionData);
			},
		})
	}	
	function validateRoleService() {
		var isOMSBAssociated=false;
		var roleRegistration=false;
		if(document.getElementById('associated_yes').checked) {
			 isOMSBAssociated=true;
		}else if(document.getElementById('associated_no').checked) {
			isOMSBAssociated=false;
		}
		errorMessages = [];
		if(isOMSBAssociated){
		 	var role_1 = document.getElementById("role_1").value;
			if (!role_1) {
				errorMessages.push("<liferay-ui:message key='please-select-role' />");
				document.getElementById("errorContainer-role_1").textContent = "<liferay-ui:message key='please-select-role' />";
			} else {
				document.getElementById("errorContainer-role_1").textContent = "";
			}		 		
			var department_1 = document.getElementById("department_1").value;
			if (!department_1 && show_departmentDiv_1 && is_department_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-department' />");
				document.getElementById("errorContainer-department_1").textContent = "<liferay-ui:message key='please-select-department' />";
			} else {
				document.getElementById("errorContainer-department_1").textContent = "";
				var departmentOther_1 = document.getElementById("departmentOther_1").value;
				if(department_1 == "other" && !departmentOther_1 && show_departmentDiv_1 && is_department_1_required){
					errorMessages.push("<liferay-ui:message key='please-add-other-department' />");
					document.getElementById("errorContainer-departmentOther_1").textContent = "<liferay-ui:message key='please-add-other-department' />";
				} else {
					document.getElementById("errorContainer-departmentOther_1").textContent = "";
				}
			}			
			var section_1 = document.getElementById("section_1").value;
			if (!section_1 && show_sectionDiv_1 && is_section_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-section' />");
				document.getElementById("errorContainer-section_1").textContent = "<liferay-ui:message key='please-select-section' />";
			} else {
				document.getElementById("errorContainer-section_1").textContent = "";
			}			
			var committe_1 = document.getElementById("committe_1").value;
			if (!committe_1 && show_committeDiv_1 && is_committe_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-committe' />");
				document.getElementById("errorContainer-committe_1").textContent = "<liferay-ui:message key='please-select-committe' />";
			} else {
				document.getElementById("errorContainer-committe_1").textContent = "";
				var committeOther_1 = document.getElementById("committeOther_1").value;
				if(committe_1 == "other" && !committeOther_1 && show_committeDiv_1 && is_committe_1_required){
					errorMessages.push("<liferay-ui:message key='please-add-other-committe' />");
					document.getElementById("errorContainer-committeOther_1").textContent = "<liferay-ui:message key='please-add-other-committe' />";
				} else {
					document.getElementById("errorContainer-committeOther_1").textContent = "";
				}
			}				
			var function_1 = document.getElementById("function_1").value;
			if (!function_1 && show_functionDiv_1 && is_function_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-function' />");
				document.getElementById("errorContainer-function_1").textContent = "<liferay-ui:message key='please-select-function' />";
			} else {
				document.getElementById("errorContainer-function_1").textContent = "";
			}				
			var programtype_1 = document.getElementById("programtype_1").value;
			if (!programtype_1 && show_programtypeDiv_1 && is_programtype_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
				document.getElementById("errorContainer-programtype_1").textContent = "<liferay-ui:message key='please-select-program-type' />";
			} else {
				document.getElementById("errorContainer-programtype_1").textContent = "";
			}			
			var program_1 = document.getElementById("program_1").value;
			if (!program_1 && show_programDiv_1 && is_program_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-program' />");
				document.getElementById("errorContainer-program_1").textContent = "<liferay-ui:message key='please-select-program' />";
			} else {
				document.getElementById("errorContainer-program_1").textContent = "";
			}			
			var programPosition_1 = document.getElementById("programPosition_1").value;
			if (!programPosition_1 && show_programPositionDiv_1 && is_programPosition_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-program-position' />");
				document.getElementById("errorContainer-program-position_1").textContent = "<liferay-ui:message key='please-select-program-position' />";
			} else {
				document.getElementById("errorContainer-program-position_1").textContent = "";
			}
			
			var purpose_1 = document.getElementById("purpose_1").value;
			if (!purpose_1 && show_purposeDiv_1 && is_purpose_1_required) {
				errorMessages.push("<liferay-ui:message key='please-select-purpose' />");
				document.getElementById("errorContainer-purpose_1").textContent = "<liferay-ui:message key='please-select-purpose' />";
			} else {
				document.getElementById("errorContainer-purpose_1").textContent = "";
			}
		 }else{
		 	var roleRegistration=false;
	 		
			if(document.getElementById('registering_yes').checked) {
				roleRegistration=true;
			}else if(document.getElementById('registering_no').checked) {
				roleRegistration=false;
			}		 		
			if(roleRegistration){
	 			errorMessages = [];
	 		 	var role = document.getElementById("role").value;
	 			if (!role) {
	 				errorMessages.push("<liferay-ui:message key='please-select-role' />");
	 				document.getElementById("errorContainer-role_2").textContent = "<liferay-ui:message key='please-select-role' />";
	 			} else {
	 				document.getElementById("errorContainer-role_2").textContent = "";
	 			}	 		 		
	 			var department_2 = document.getElementById("department_2").value;
	 			if (!department_2 && show_departmentDiv_2 && is_department_2_required) {
	 				errorMessages.push("<liferay-ui:message key='please-select-department' />");
	 				document.getElementById("errorContainer-department_2").textContent = "<liferay-ui:message key='please-select-department' />";
	 			} else {
	 				document.getElementById("errorContainer-department_2").textContent = "";
	 				var departmentOther_2 = document.getElementById("departmentOther_2").value;
	 				if(department_2 == "other" && !departmentOther_2 && show_departmentDiv_2 && is_department_2_required){
	 					errorMessages.push("<liferay-ui:message key='please-add-other-department' />");
	 					document.getElementById("errorContainer-departmentOther_2").textContent = "<liferay-ui:message key='please-add-other-department' />";
	 				} else {
	 					document.getElementById("errorContainer-departmentOther_2").textContent = "";
	 				}
	 			}	 			
	 			var section_2 = document.getElementById("section_2").value;
	 			if (!section_2 && show_sectionDiv_2 && is_section_2_required) {
	 				if(department_2 !== "other" && show_departmentDiv_2){
	 					errorMessages.push("<liferay-ui:message key='please-select-section' />");
	 					document.getElementById("errorContainer-section_2").textContent = "<liferay-ui:message key='please-select-section' />";
	 				} else {
	 					document.getElementById("errorContainer-section_2").textContent = "";
	 				}
	 	 		}	 			
	 			var committe_2 = document.getElementById("committe_2").value;
				if (!committe_2 && show_committeDiv_2 && is_committe_2_required) {
					errorMessages.push("<liferay-ui:message key='please-select-committe' />");
					document.getElementById("errorContainer-committe_2").textContent = "<liferay-ui:message key='please-select-committe' />";
				} else {
					document.getElementById("errorContainer-committe_2").textContent = "";
					var committeOther_2 = document.getElementById("committeOther_2").value;
					if(committe_2 == "other" && !committeOther_2 && show_committeDiv_2 && is_committe_2_required){
						errorMessages.push("<liferay-ui:message key='please-add-other-committe' />");
						document.getElementById("errorContainer-committeOther_2").textContent = "<liferay-ui:message key='please-add-other-committe' />";
					} else {
						document.getElementById("errorContainer-committeOther_2").textContent = "";
					}
				}	 			 				
				var function_2 = document.getElementById("function_2").value;
				if (!function_2 && show_functionDiv_2 && is_function_2_required) {
					errorMessages.push("<liferay-ui:message key='please-select-function' />");
					document.getElementById("errorContainer-function_2").textContent = "<liferay-ui:message key='please-select-function' />";
				} else {
					document.getElementById("errorContainer-function_2").textContent = "";
				}	 			
				var programtype_2 = document.getElementById("programtype_2").value;
				if (!programtype_2 && show_programtypeDiv_2 && is_programtype_2_required) {
					errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
					document.getElementById("errorContainer-programtype_2").textContent = "<liferay-ui:message key='please-select-program-type' />";
				} else {
					document.getElementById("errorContainer-programtype_2").textContent = "";
				}	 			
				var program_2 = document.getElementById("program_2").value;
				if (!program_2 && show_programDiv_2 && is_program_2_required) {
	 				errorMessages.push("<liferay-ui:message key='please-select-program' />");
	 				document.getElementById("errorContainer-program_2").textContent = "<liferay-ui:message key='please-select-program' />";
	 			} else {
	 				document.getElementById("errorContainer-program_2").textContent = "";
	 			}				
				var programPosition_2 = document.getElementById("programPosition_2").value;
				if (!programPosition_2 && show_programPositionDiv_2 && is_programPosition_2_required) {
					errorMessages.push("<liferay-ui:message key='please-select-program-position' />");
					document.getElementById("errorContainer-program-position_2").textContent = "<liferay-ui:message key='please-select-program-position' />";
				} else {
					document.getElementById("errorContainer-program-position_2").textContent = "";
				}			
				var purpose_2 = document.getElementById("purpose_2").value;
				if (!purpose_2 && show_purposeDiv_2 && is_purpose_2_required) {
					errorMessages.push("<liferay-ui:message key='please-select-purpose' />");
					document.getElementById("errorContainer-purpose_2").textContent = "<liferay-ui:message key='please-select-purpose' />";
				} else {
					document.getElementById("errorContainer-purpose_2").textContent = "";
				}
	 		 } 		
		} 
		if (errorMessages.length > 0) {
			event.preventDefault();
			return false;
		} else {
			return true;
		}
	}			
	function setFunctionCommitee(sectionId,functionId,committeId){
		var inputsectionId=$("#"+sectionId).val();
		$.ajax({
			url: '${functionSectioncommitteURL}',
			dataType:"json",
			async : false,
			data : {
				<portlet:namespace />sectionId : inputsectionId,
			},
			type : 'POST',
			success : function(data) {
				var response=data;
				var functionData="<option value=''><liferay-ui:message key='select'/></option>";
				$.each(response.functionObj, function( index, value ) {
					functionData=functionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+functionId).html("").append(functionData);				
				if(committeId !== null && committeId !== ''){
					var committeData="<option value=''><liferay-ui:message key='select'/></option>";
					$.each(response.committeObj, function( index, value ) {
						committeData=committeData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
				    });
					$("#"+committeId).html("").append(committeData);
				}
			},
		})
	}			
	function setProgram(programTypeId,programId){
		var inputprogramTypeId=$("#"+programTypeId).val();
		$.ajax({
			url: '${programTypeURL}',
			dataType:"json",
			async : false,
			data : {
				<portlet:namespace />programTypeId : inputprogramTypeId,
			},
			type : 'POST',
			success : function(data) {
				var response=data;
				var programData="<option value=''><liferay-ui:message key='select'/></option>";				
				$.each(response, function( index, value ) {
					programData=programData+"<option value='"+value.id+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+programId).html("").append(programData);
			},
		})
	}
	function setPrimarySpecialty(){
		var primaryspecialty ='${personalDetails.primarySpeciality}';
		var profession=$('#profession').val();
		$.ajax({
			url: '${professionListURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />profession : profession,
			},
			type : 'POST',
			success : function(data) {
	            var specialityList = data;
	            $('#primarySpeciality').empty();
	            $('#primarySpeciality').append("<option value=''><liferay-ui:message key="select"/></option> ");
	            $.each(specialityList, function (i, item) {
	            	var selectedPrimarySpeciality = "";
	            	if (item.specialty === primaryspecialty) {
	            		selectedPrimarySpeciality = "selected";
		              }
	                $('#primarySpeciality').append("<option value='" + item.specialty + "'" + selectedPrimarySpeciality + ">" + item.specialtyName + "</option> ");
	            })
	            },
		})
	}
function getInstitutionDetails(country){
		$.ajax({
			url: '<%=getUniversityDetailsURL%>',
			type : 'GET',
			data : {
				"<portlet:namespace />country" : country,
			},
			success : function(response) {
				var data = response;
				var subSpecialityArray = response.university;
				var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
				var obj = JSON.parse(response);
				if(obj != null){
					for (var i = 0; i < obj.length; i++) {
						var item = obj[i];
						var id = item.id;
						if (themeDisplay.getLanguageId() == 'en_US') {
							sectionData += "<option value='" + id + "'>"+ item.englishName + "</option>";
						} else {
							sectionData += "<option value='" + id + "'>"+ item.arabicName + "</option>";
						}
					}
				}
				$("#institution").html(sectionData);
			},
		})
}
$("#registration-cancel").click(function(){
	window.location.href='${themeDisplay.getPortalURL()}'+'/group/guest/dashboard';
});
function setRoleServiceCommentID(comments){
	$('#role-comments-span').html(comments);
}
function validateDateOfBirth() {
	var dobVal=$('#dateOfBirth').val();
	var chunks = dobVal.split('-');
	var formattedDate = chunks[1]+'-'+chunks[0]+'-'+chunks[2];
	var today = new Date();
	var birthDate = new Date(formattedDate);
	var age = today.getFullYear() - birthDate.getFullYear();
	if (age > 18+1) {
		document.getElementById("errorContainer-dateOfBirth").textContent = "";
		return true;
	}else{
		document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='age-error' />";
	    return false;
	} 
}
</script>