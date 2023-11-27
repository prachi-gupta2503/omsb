<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommands.SAVE_EXAM_REGISTRATION%>"
		var="saveRegistrationURL" />
<div class="d-none" id="map"></div>	
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="pagetitle"><liferay-ui:message key="register-exam" /></div>
			</div>
			<%-- <portlet:actionURL name="/exam/registartion" var="saveRegistrationURL" /> --%>
			<form  method="post" name="saveRegistrationFm" id="saveRegistrationFm">
				<div class="row">
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="program-name" /></label> <span
								class="value">${registration.programName}</span>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="exam-type" /></label> <span
								class="value">${registration.examTypeName}</span>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="no-of-attempt" /></label> <span
								class="value">${registration.noOfAttempt}</span>
						</div>
					</div>
					
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group-dtls register_profile">
					<c:choose>
							<c:when test="${registration.profileUrl ne null && registration.profileUrl ne ''}">
								<img src="${registration.profileUrl}" alt="" />
							</c:when> 
							<c:otherwise>
								<img src="<%= themeDisplay.getPathThemeImages() %>/svg/no_img.svg" />
							</c:otherwise>
					</c:choose>
						</div>
					</div>
				</div>

				<h4 class="form-title">
					<liferay-ui:message key="trainee-details" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="first-name" /></label>
							<input type="text" name="fnameinenglish" id="fnameinenglish" readonly
								value="${registration.firstName}" class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="family-name" /></label>
							<input type="text" name="familynameinenglish"
								id="familynameinenglish" value="${registration.familyName}" readonly class="form-control">
						</div>
					</div>
					
					
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="nationality" /></label> <input readonly
								type="text" name="nationality" id="nationality" value="${registration.nationality}"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="birth-date" /></label> <input readonly
								type="text" name="birthdate" id="birthdate" value="${registration.dateOfBirth}"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="gender" /></label> <input readonly
								type="text" name="gender" id="gender" value="${registration.gender}"
								class="form-control">
						</div>
					</div>
				</div>
				<h4 class="form-title">
					<liferay-ui:message key="passport-details" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="passport-number" /></label> <input readonly
								type="text" name="passportnumber" id="passportnumber" value="${registration.passportNumber}"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="passport-expiry-date" /></label>
							<input type="text" name="passportexpirydate" 
								id="passportexpirydate"  readonly value="${registration.passportExpiryDate}" class="form-control">
						</div>
					</div>
				</div>

				<h4 class="form-title">
					<liferay-ui:message key="civil-id-info" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message
									key="civil-id" /></label> <input type="text" readonly="readonly"
								name="NationalIDNumber" id="NationalIDNumber" value="${registration.civilId}"
								class="form-control">
						</div>
					</div>
					
				</div>

				<h4 class="form-title">
					<liferay-ui:message key="contact-details" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="mobile" /></label> <input 
								type="text" name="Mobile" readonly id="Mobile" value="${registration.mobileNumber}"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="email" /></label> <input readonly
								type="text" name="Email" readonly  id="Email"  value="${registration.emailAddress}"
								class="form-control">
						</div>
					</div>
				</div>

	<!-- ******emegency-contact-details****** -->

				<h4 class="form-title">
					<liferay-ui:message key="emegency-contact-details" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-4 col-md-6">
						<input type="hidden" name="<portlet:namespace/>programId" value="${registration.programId}">
						<input type="hidden" name="<portlet:namespace/>examScheduleId" value="${registration.examScheduleId}" id="examScheduleId" >
						<input type="hidden" name="<portlet:namespace/>lrUserId" value="${registration.lrUserId}"  id="lrUserId">
						<input type="hidden" name="<portlet:namespace/>role" value="${role}">
						<input type="hidden" name="<portlet:namespace/>feeType" value="${registration.feeType}" id="feeType">
					</div>
					<div class="col-lg-4 col-md-6">
						<input type="hidden"  name="<portlet:namespace/>examTypeId"
							value="${registration.examTypeId}">
					</div>
							
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
						<label class="required"><liferay-ui:message key="name" /></label>
							<input type="text"  name="<portlet:namespace/>name" id="name" value="${emergencyContact.name}"
								class="form-control required " placeholder="<liferay-ui:message key="enter-name" />"  
								onkeypress="return isValidInput(event)"
								onkeyup="validateSelectAndInputField('name','errorContainer-name')"
								maxlength="30"  />
						</div>
						<p id="errorContainer-name" class="error-container"></p>
						
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
						<label class="required"><liferay-ui:message key="telephone" /></label>
							<input type="text" name="<portlet:namespace/>telephone" id="telephone" value="${emergencyContact.telephone}" class="form-control required " placeholder="<liferay-ui:message key="enter-telephone" />"
							onkeypress="return event.charCode >= 48 && event.charCode <= 57"
							
							onkeyup="validateSelectAndInputField('telephone','errorContainer-telephone')"
								maxlength="20" 
							 />
						</div>
						<p id="errorContainer-telephone" class="error-container"></p>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="mobile" /></label>
							<input type="text" name="<portlet:namespace/>mobile" id="mobile" value="${emergencyContact.mobileNumber}"
								class="form-control required " placeholder="<liferay-ui:message key="enter-mobile" />" 
								onkeypress="return event.charCode >= 48 && event.charCode <= 57"
								onkeyup="validateSelectAndInputField('mobile','errorContainer-mobile')"
								maxlength="20" 
								/>
						</div>
						<p id="errorContainer-mobile" class="error-container"></p>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
						<label class="required"><liferay-ui:message key="relationship-to-applicant" /></label>
							<input type="text"  name="<portlet:namespace/>relationshipToApplicant"
								id="relationshiptoapplicant"  class="form-control required " placeholder="<liferay-ui:message key="please-enter-relationship-to-applicant" />"  
								onkeyup="validateSelectAndInputField('relationshiptoapplicant','errorContainer-relationshiptoapplicant')"
								maxlength="30" minlength="2" onkeypress="return isValidInput(event)" value="${emergencyContact.relationshipToApplicant}"
								/>
						</div>
						<p id="errorContainer-relationshiptoapplicant" class="error-container"></p>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
						<label class="required"><liferay-ui:message key="email-address" /></label>
							<input type="text"  name="<portlet:namespace/>emailAddress" id="emailaddress"
								value="${emergencyContact.emailAddress}" class="form-control required " placeholder="<liferay-ui:message key="enter-email-address" />" 
								
									onkeyup="emailValidation(this.value,'emailaddress','errorContainer-emailaddress')" 
								/>
						</div>
						
						<p id="errorContainer-emailaddress" class="error-container"></p>
					</div>
				</div>
				<h4 class="form-title">
					<liferay-ui:message key="education-details" />
				</h4>
				<div class="row m-0">
				 <c:forEach var="educationDetail" items="${educationDetails}">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="university-of-education" /></label>
							<input readonly type="text" name="universityofeducation" value="${educationDetail.issuingAuthorityName}"
								id="universityofeducation" value="" class="form-control">
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="upload-certificate" /></label>
							<%-- <div class="custom-file">
                                 <input readonly type="file" class="custom-file-input" id="customFile" name="filename">
                            	 <label class="custom-file-label" for="customFile">${registration.educationCertificate}</label>
                           </div>  --%>
                           
							 <a href="${educationDetail.documentUrl}" target="_blank" class="omsb-view-file" download="">
							 <label>${educationDetail.educationCertificate}<span class="view-download"><liferay-ui:message key="download" /></span></label>
							 </a>
				  		 </div>
                           
						</div>
						</c:forEach>
					</div>
			
				<h4 class="form-title">
					<liferay-ui:message key="languages-used-in-college" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-radio ">
								<input type="radio" class="custom-control-input langUsedCollege" id="English" name="<portlet:namespace/>langUsedCollege" value="english"  <c:if test="${registration.langUsedCollege eq 'english'}">checked</c:if> >
								<label class="custom-control-label m-0" for="English"><liferay-ui:message key="english"  /></label>
							</div>
						</div>
					</div>
					
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-radio ">
								<div class="custom-control custom-radio ">
										<input type="radio" class="custom-control-input langUsedCollege" id="Arabic" name="<portlet:namespace/>langUsedCollege" value="arabic" <c:if test="${registration.langUsedCollege eq 'arabic'}">checked</c:if>>
										<label class="custom-control-label m-0" for="Arabic"><liferay-ui:message key="arabic" /></label>
								 </div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-radio ">
								<div class="custom-control custom-radio ">
										<input type="radio" class="custom-control-input langUsedCollege" id="Other" name="<portlet:namespace/>langUsedCollege" value="other" <c:if test="${registration.langUsedOther}">checked</c:if>>
										<label class="custom-control-label m-0" for="Other"><liferay-ui:message key="other" /></label>
								</div>
							</div>
						</div>
					</div>
					<c:choose>
						<c:when test="${registration.langUsedOther}">
					
					<div class="col-lg-4 col-md-6 col-sm-12" id="lang_other_text">
						<div class="form-group">
							<label><liferay-ui:message key="other-language" /></label>
							<input type="text" name="<portlet:namespace/>langUsedOther" id="Otherlanguage" value="${registration.langUsedCollege}"
												class="form-control Otherlanguage" placeholder="<liferay-ui:message key="enter-other-language"/> ">
						</div>
					</div>
					</c:when>
    				<c:otherwise>
                         <div class="col-lg-4 col-md-6 col-sm-12 d-none" id="lang_other_text">
						<div class="form-group">
							<label><liferay-ui:message key="other-language" /></label>
							<input type="text" name="<portlet:namespace/>langUsedOther" id="Otherlanguage" value=""
							class="form-control Otherlanguage" placeholder="<liferay-ui:message key="enter-other-language"/> ">
						</div>
					</div>
   				 	</c:otherwise>
				</c:choose>
				</div>
				
				<h4 class="form-title">
					<liferay-ui:message key="consent" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
							<input type="checkbox"  class="custom-control-input" id="authorize" name="<portlet:namespace/>consentAuthorize">
							<label class="custom-control-label m-0 " for="authorize"><liferay-ui:message key="consent-authorize-oct-registration" /></label> 
							</div>
						</div>

					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
							<input  type="checkbox" required class="custom-control-input" id="authoriz2" name="<portlet:namespace/>declaration">
							<label class="custom-control-label m-0 " for="authoriz2"><liferay-ui:message key="declaration-oct-registration" /></label>
									  
							</div>
							<p id="errorContainer-authoriz2" class="error-container"></p>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap">
					<button type="submit" class="btn omsb-bc-red-button submit" title="Save" onclick="validateAndSaveFormData('save')">
						<liferay-ui:message key="save" />
					</button>
					<button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#registration_form_discard" type="button" title="Discard"><liferay-ui:message key="discard" /></button>
					<portlet:renderURL var="viewTraineeExamListURL">
					<c:choose>
					<c:when test="${regCMD eq 'regCmd' }">
						<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.ADMIN_TRAINEE_LIST%>" />
						<portlet:param name="programId" value="${registration.programId}" />
						<portlet:param name="examTypeId" value="${registration.examTypeId}" /> 
						<portlet:param name="examScheduleId" value="${registration.examScheduleId}" />
				    </c:when>
				    <c:otherwise>
				    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_TRAINEE_EXAM_LIST%>" />
				    </c:otherwise>
				    </c:choose>
					</portlet:renderURL>
					<portlet:renderURL var="backURL">
					 <portlet:param name="mvcRenderCommandName" value="/" />
					</portlet:renderURL>
					<c:if test="${role == 'trainee'}">
						<a class="btn omsb-btn btn-back" href="${backURL}">
							<i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" />
						</a>
					</c:if>
		
		
					<portlet:renderURL var="adminTraineeListURL">
						<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.ADMIN_TRAINEE_LIST%>" />
						<portlet:param name="programId" value="${registration.programId}" />
						<portlet:param name="examTypeId" value="${registration.examTypeId}" />
						<portlet:param name="examScheduleId" value="${registration.examScheduleId}" />
						<portlet:param name="examDefinitionId" value="${registration.examDefinitionId}" />
					</portlet:renderURL>
					
					<c:if test="${role == 'admin'}">
						<a class="btn omsb-btn btn-back" href="${adminTraineeListURL}">
							<i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" />
						</a>
					</c:if>			
				</div>
			</form>
		</div>
	</div>
</div>





<%@ include file="payment-confirmation-popup.jsp"%>

<div class="modal fade omsb-modal" id="registration_form_discard" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="discard-confirmation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div>
						<liferay-ui:message key="confirmation-text" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" onclick="discardChanges()" type="button" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>




<script>
 function discardChanges(){
	 /* $("#name").val("");
	 $("#telephone").val("");
	 $("#mobile").val("");
	 $("#relationshiptoapplicant").val("");
	 $("emailaddress").val(""); */
	 location.reload(true);
	 $("#uploadcancel").click();
	
}
 
	$(document).ready(function() {
		$('.textEditor').richText();
	});
	$('input[name="<portlet:namespace/>langUsedCollege"]').click(function(){
		
	if($(this).val() == 'other'){
		$('#lang_other_text').removeClass("d-none");
	}
	else{
		$('#lang_other_text').addClass("d-none");
	}
	});


	 var today = new Date();
	 $('#FromDate').datepicker({
	  format: "dd/mm/yyyy",
	  orientation: "bottom auto",
	  autoclose: true,
	  //startDate: today
	}).on('changeDate', function (selected) {
	  var startDate = new Date(selected.date.valueOf());
	  $('#Todate').datepicker('setStartDate', startDate);
	});
	
	$('#Todate').datepicker({
	  format: "dd/mm/yyyy",
	  orientation: "bottom auto",
	  autoclose: true
	});
 
 
 
 function validateAndSaveFormData(button) {
	
		var errorMessages = [];
		var name = document.getElementById("name").value;
		if (!name) {
			errorMessages.push("<liferay-ui:message key='please-enter-name' />");
			document.getElementById("errorContainer-name").textContent = "<liferay-ui:message key='please-enter-name' />";
			$("#name").focus();
		}else {
			document.getElementById("errorContainer-name").textContent = "";
		}
		var telephone = document.getElementById("telephone").value;
		if (!telephone) {
			errorMessages.push("<liferay-ui:message key='please-enter-telephone' />");
			document.getElementById("errorContainer-telephone").textContent = "<liferay-ui:message key='please-enter-telephone' />";
			$("#telephone").focus();
		}  else {
				document.getElementById("errorContainer-telephone").textContent = "";
				
			
		}
		var mobile = document.getElementById("mobile").value;
		if (!mobile) {
			errorMessages.push("<liferay-ui:message key='please-enter-mobile' />");
			document.getElementById("errorContainer-mobile").textContent = "<liferay-ui:message key='please-enter-mobile' />";
			$("#mobile").focus();
		}  else {
				document.getElementById("errorContainer-mobile").textContent = "";
		}
		var relationshiptoapplicant = document.getElementById("relationshiptoapplicant").value;
		if (!relationshiptoapplicant) {
			errorMessages.push("<liferay-ui:message key='please-enter-relationshiptoapplicant' />");
			document.getElementById("errorContainer-relationshiptoapplicant").textContent = "<liferay-ui:message key='please-enter-relationshiptoapplicant' />";
			$("#relationshiptoapplicant").focus();
		} else {
			document.getElementById("errorContainer-relationshiptoapplicant").textContent = "";
		}
		
		
		var emailAddress = document.getElementById("emailaddress").value;
		
		if (!emailAddress) {
		errorMessages.push("<liferay-ui:message key='please-enter-emailaddress' />");
		document.getElementById("errorContainer-emailaddress").textContent = "<liferay-ui:message key='please-enter-emailaddress' />";
		$("#emailaddress").focus();
		} else {
		document.getElementById("errorContainer-emailaddress").textContent = "";
		let regex = /^[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]{2,3}$/;
        if (!regex.test(emailAddress)) {
        
        	errorMessages.push("<liferay-ui:message key='please-enter-valid-emailaddress' />");
			document.getElementById("errorContainer-emailaddress").textContent = "<liferay-ui:message key='please-enter-valid-emailaddress' />";
			 $('#errorContainer-emailaddress').removeClass('d-none');
			 $("#emailaddress").focus();
        } else {
			document.getElementById("errorContainer-emailaddress").textContent = "";
			
		}
	}
		var authoriz2 = document.getElementById("authoriz2").value;
		
		
		if (!$('#authoriz2').is(":checked")) {
			errorMessages.push("<liferay-ui:message key='error-authoriz2' />");
			document.getElementById("errorContainer-authoriz2").textContent = "<liferay-ui:message key='error-authoriz2' />";
			$("#authoriz2").focus();
		}else {
			document.getElementById("errorContainer-authoriz2").textContent = "";
		}
		
		if (errorMessages.length > 0) {
		event.preventDefault();
	} else{
		submitRegistration();
		event.preventDefault();
	}
		
		
 }
 
 $('#authoriz2').click(function() {
	    if ($(this).is(':checked')) {
	         $('#errorContainer-authoriz2').addClass('d-none');
	    }else{
	         $('#errorContainer-authoriz2').removeClass('d-none');
	    }
	});	

 
 function emailValidation(email,emailaddress,emailaddresserror){
	
	var valid=validateSelectAndInputField(emailaddress,emailaddresserror)
	
	 let regex = /^[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]{2,3}$/;
	
	 //let regex =/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
	 if(valid){
		 if (!regex.test(email)) {
	    	 document.getElementById("errorContainer-emailaddress").textContent = "<liferay-ui:message key='please-enter-valid-emailaddress' />";
			 $('#errorContainer-emailaddress').removeClass('d-none');
			 return false;
	     }else{
	    	 document.getElementById("errorContainer-emailaddress").textContent = "";
				
	    	 $('#errorContainer-emailaddress').addClass('d-none');
	    	 return true;
	     } 
		 
	 }else{
		 document.getElementById("errorContainer-emailaddress").textContent = "<liferay-ui:message key='please-enter-emailaddress' />";
		 $('#errorContainer-emailaddress').removeClass('d-none');

	 }
     return true;
 }

 
 function isValidInput(event) {
	 
     const charCode = event.charCode || event.keyCode; // Handle different event properties for different browsers
     const char = String.fromCharCode(charCode);
     const allowedChars = /^[A-Za-z ]*$/;

     if (!allowedChars.test(char)) {
       event.preventDefault();
       return false;
     }
     return true;
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
 
 
 function submitRegistration(){

	    
		let form =$("#saveRegistrationFm")[0];
		var examScheduleId=$("#examScheduleId").val();
		var lrUserId=$("#lrUserId").val();
		   
		 console.log(form);
		 console.log(examScheduleId);
		
		 var formData = new FormData(form);
		 console.log(formData);
		 $.ajax({
		        type: "POST",
		        url: '<%=saveRegistrationURL%>' ,
		        data:  formData, 
		        enctype: 'multipart/form-data',
		        contentType : false,
				cache : false,
				processData : false,
		        
		        success: function(response)
		        { 
		        	event.preventDefault();
		        	console.log("registration Success")
		        	if (response.length > 0) {
						var data = JSON.parse(response);
		        		paymentConfirmation(examScheduleId,lrUserId);
		        	 }		
		        }
		       
		    });
		     
		}
 
 

 

 function initMap(placeId) {
 	var options = {
 		fields: ["place_id", "formatted_address", "geometry", "name"],
 		strictBounds: false,
 		types: ["establishment"],
 	};

 	const infowindow = new google.maps.InfoWindow();
 	const map = new google.maps.Map(document.getElementById("map"), {

 	});


 	var placeId = placeId
 	if (placeId) {
 		var request = {
 			placeId: placeId,
 			fields: ["name", "formatted_address", "place_id", "geometry"],
 		};
 		const service = new google.maps.places.PlacesService(map);
 		service.getDetails(request, (place, status) => {
 			if (status === google.maps.places.PlacesServiceStatus.OK && place && place.geometry && place.geometry.location) {

 				$("#location").html(place.name);
 			}
 		});
 	}
 }

 window.initMap = initMap;
  
    
  </script>
