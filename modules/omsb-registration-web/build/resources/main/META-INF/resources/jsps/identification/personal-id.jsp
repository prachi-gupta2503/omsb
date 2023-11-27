<%@ include file="../../init.jsp"%>

<portlet:renderURL var="viewIdentificatinoPKI">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_IDENTIFICATION_PKI%>" />
</portlet:renderURL>
<portlet:actionURL name="<%=MVCCommands.IDENTIFICATION_PERSONAL_ID_MVCACTION%>" var="identificationPersonalIdMVCActionURL"/>

 <liferay-ui:error key="dfrn-message-error" message="dfrn.message.error"/>
	
		<div class="main-content id-box" >
			<div class="omsb-main-wrapper" id="omsb-main-wrapper">
				
				<div class=" row bg-white">
					
					<div class="col-12 login-right">
						<div class="omsb-card ">
							<div class="omsb-pre-login header">
								<div>
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/logo.svg">
								</div>
								<div>
									<p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/></p>
									<p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
								</div>
							</div>
							<div class="Id-forms">
								<div class="omsb-page-top-info">
									<div class="pagetitle"><liferay-ui:message key="identification-personal-id" /></div>
								</div>
								<form name="login-user-password" class="login-wup" action="${identificationPersonalIdMVCActionURL}"  method="post">
									<div class="d-flex">
										<div class="w-25">
											<label class="control-label"><liferay-ui:message key="do-you-have-a-civil-id"/></label>
										</div>
										<div class="form-group yesorno">
											<div class="custom-control custom-radio ">
												<input type="radio" name="CivilId-radio" class="custom-control-input" id="CivilId_yes">
												<label class="custom-control-label m-0" for="CivilId_yes"><liferay-ui:message key="yes"/></label>
											</div>
										
											<div class="custom-control custom-radio ">
												<input type="radio" name="CivilId-radio" checked="checked" class="custom-control-input" id="CivilId_no">
												<label class="custom-control-label m-0" for="CivilId_no"><liferay-ui:message key="no"/></label>
											</div>
										</div>
									</div>





                            	<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
									<h3 class="reg-form-title mb-3"> <liferay-ui:message key="enter-following-to-help-us-identify-you"/>::</h3>
									<div class="row identify-row">
										<div class="col-md-6 col-sm-6 col-xs-12 leftbar">
											<div class="form-group">
												<label class="control-label"><liferay-ui:message key="passport-number"/></label>
											<input class="form-control" id="passportno" placeholder="<liferay-ui:message key="passport-number"/>" type="text" name="<portlet:namespace/>passportno" >
											<h6 id="passError" style="color: red;"><liferay-ui:message key="passport-numbr-error"/></h6>
											<h6 id="passPortcheck1" style="color: red;"><liferay-ui:message key="please-enter-passport-number"/></h6>
											</div>
										</div>
										<div class="col-md-2 col-sm-2 col-xs-12 centerbar ">
											<h5 class="reg-form-section-title text-center"><liferay-ui:message key="or"/></h5>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-12 rightbar">
											<div class="form-group">
												<label class="control-label"><liferay-ui:message key="dfrn"/></label>
												<input class="form-control" id="dfrn" placeholder="DFRN" type="text" name="<portlet:namespace/>dfrn" >
											    <h6 id="passPortcheck2" style="color: red;"><liferay-ui:message key="please-enter-dfrn"/></h6>
											</div>
										</div>

										<div class="col-md-6 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="control-label"><liferay-ui:message key="date-of-birth"/></label>
												<input class="form-control datePicker" placeholder="DD-MM-YYYY" type="text" name="<portlet:namespace/>dob" id="dob">
												<h6 id="dobcheck" style="color: red;"><liferay-ui:message key="please-select-date-of-birth"/></h6>
												<h6 id="ageError" style="color: red;"><liferay-ui:message key="age-error"/></h6>
											</div>
										</div>
									</div>

								</div>

                               <div class="bottom-backbtn-wrap m-0">
									<button type="submit" id="btnpersonalIdSaveAndContinue" class="btn omsb-bc-red-button" title="<liferay-ui:message key="next"/>"><liferay-ui:message key="next"/></button>
								</div>





									<%-- <div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
										<h3 class="reg-form-title mb-3"><liferay-ui:message key="enter-following-to-help-us-identify-you"/>:</h3>
										<h3 class="reg-form-sub-title "><liferay-ui:message key="your-passport-number"/></h3>
										
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="passport-number"/></label>
											<input class="form-control" id="passportno" placeholder="<liferay-ui:message key="passport-number"/>" type="text" name="<portlet:namespace/>passportno" >
											<h6 id="passError" style="color: red;"><liferay-ui:message key="passport-numbr-error"/></h6>
											<h6 id="passPortcheck1" style="color: red;"><liferay-ui:message key="please-enter-passport-number"/></h6>
										</div>
										<h5 class="reg-form-section-title"><liferay-ui:message key="or"/></h5>
										<h3 class="reg-form-sub-title "><liferay-ui:message key="if-you-have-done-dataflow-verification-in-that-case-number-and-date-of-birth"/></h3>

										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="dfrn"/></label>
											<input class="form-control" id="dfrn" placeholder="DFRN" type="text" name="<portlet:namespace/>dfrn" >
											<h6 id="passPortcheck2" style="color: red;"><liferay-ui:message key="please-enter-dfrn"/></h6>
										</div>
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="date-of-birth"/></label>
											<input class="form-control datePicker" placeholder="DD-MM-YYYY" type="text" name="<portlet:namespace/>dob" id="dob">
											<h6 id="dobcheck" style="color: red;"><liferay-ui:message key="please-select-date-of-birth"/></h6>
											<h6 id="ageError" style="color: red;"><liferay-ui:message key="age-error"/></h6>
										</div>
									</div>
									<div class="bottom-backbtn-wrap">
									
							<input type="hidden" value="${identificationConfirmationURL}" id="identificationConfirmationTxt"/>											
							<button type="submit" id="btnpersonalIdSaveAndContinue" class="btn omsb-bc-red-button" title="<liferay-ui:message key="next"/>"><liferay-ui:message key="next"/></button>
							<a class="btn omsb-btn btn-back" href="#"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</div> --%>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
<input type="hidden" value="${viewIdentificatinoPKI}" name="viewIdentificatinoPKITxt" id="viewIdentificatinoPKITxt"/>
<script type="text/javascript">
var validPassport=true;
var validDfrn=true;
var validDob=true;
var validPersonId=false;

$(document).ready(function(){
	console.log('ready called :::');
	$("#passPortcheck1").hide();
	$("#passPortcheck2").hide();
	$("#dobcheck").hide();
	$("#passError").hide();
	$("#ageError").hide();
	
	
	$('#CivilId_yes').click(function(){
		console.log("Yes clicked ");
		var url=$('#viewIdentificatinoPKITxt').val();
		window.location.href=url;
	});
	
	
	/* $('#passportno').keyup(function(){
		var passportNo=$('#passportno').val();
		var regex = /^[A-PR-WY][1-9]\d\s?\d{4}[1-9]$/;
		 if(regex.test(passportNo)){
			 $("#passError").hide();
        	validPassport = true;
            return true;
        }else{
        	$("#passError").show();
        	validPassport = false;
            return false;
        }
	}); */
	
	function validatePassport() {
	 	var passportNo=$('#passportno').val();
			console.log("passportNo ::",passportNo);
			 if (passportNo.length == " ") {
				validPassport = false;
	            return false;
	        }else{
	        	validPassport = true;
	            return true;
	        }
	}
		
	function validateDFRM() {
	 	var dfrnVal=$('#dfrn').val();
			console.log("dfrnVal ::",dfrnVal);
			 if (dfrnVal.length == " ") {
				validDfrn = false;
	            return false;
	        }else{
	        	validDfrn = true;
	            return true;
	        }
	}
		
	//18 plus age validaation
	 $('#dob').change(function(){
		 validateDateOfBirth();
	});
	
	function validateDateOfBirth() {
		var dobVal=$('#dob').val();
		console.log("dobVal ::::",dobVal);
		var chunks = dobVal.split('-');
		var formattedDate = chunks[1]+'-'+chunks[0]+'-'+chunks[2];
		console.log("formattedDate ::::",formattedDate);
		var today = new Date();
		var birthDate = new Date(formattedDate);
		var age = today.getFullYear() - birthDate.getFullYear();
	
		console.log("birthDate.getFullYear() ::",birthDate.getFullYear());
		console.log("today getFullYear ::",today.getFullYear());
		console.log("today ::",today);
		console.log("birthDate ::",birthDate);
		console.log("age ::",age);
		if (age > 18+1) {
			$("#ageError").hide();
			$("#dobcheck").hide();
			validDob = true;
			return true; 
		}else{
			$("#ageError").show();
			$("#dobcheck").hide();
			validDob = false;
			return false;
		} 
	}
		
	$('#btnpersonalIdSaveAndContinue').click(function(){

		console.log("Button clicked :::");	
		validatePassport();
		validateDFRM();
		validateDateOfBirth();
		console.log("validDob ::",validDob);
		
		if (validPassport == true || validDfrn ==true) {
			validPersonId=true;
			$("#passPortcheck1").hide();
			$("#passPortcheck2").hide();
		}else{
			$("#passPortcheck1").show();
			$("#passPortcheck2").show();
			validPersonId=false;
		}
		
		if (validPersonId == true && validDob == true) {
            return true;
       	} else {
            return false;
	   }
	});
});
		
$('#dob').datepicker({
format: "dd-mm-yyyy",
maxDate: '-18Y',
orientation: "bottom auto",

autoclose: true
}).on('change', function(){
	$('.datepicker').hide();
});


</script>
