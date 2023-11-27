<%@ include file="/init.jsp"%>
<%@page import="omsb.forget.password.web.constants.OmsbMVCCommandsKeys"%>
<portlet:resourceURL id="<%=OmsbMVCCommandsKeys.SEND_OTP%>" var="sendOTPURL" />
<portlet:resourceURL id="<%=OmsbMVCCommandsKeys.VERIFY_OTP%>" var="verifyOTPURL" />
<portlet:resourceURL id="<%=OmsbMVCCommandsKeys.UPDATE_PASSWORD%>" var="updatePasswordURL" />


<body class="forgrt_password_screen">
	<div class="main-content" >

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
<div class=" row bg-white">
	<div class="col-lg-6 col-md-6 login-left"><img class="w-100" src="<%=themeDisplay.getPathThemeImages() %>/svg/login_left.svg"></div>
	<div class="col-lg-6 col-md-6 login-right">
		<div class="login-box-wrap">
			<div class="login-box">
				<div class="logo-img">
					<img src="<%=themeDisplay.getPathThemeImages() %>/svg/logo.svg">
				</div>
				<div class="site-title">
					
					<div class="logo-text-english">Oman Medical Specialty Board</div>
				</div>
				<h2 class="forgot_password_heading pt-4">Forgot Password?</h2>
				<input type="hidden" value="" id="verificationType"/>
				<input type="hidden" value="" id="personId"/>
				<input type="hidden" value="" id="lRUserId"/>
				<input type="hidden" value="" id="mobileNumberOTP"/>
				<input type="hidden" value="" id="emailAddressOTP"/>
				<div class="login-forms" id="userDetailScreen">
					<div class="row">
						<div class="col-lg-12">
							<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
								<li class="nav-item">
								  <a class="nav-link active" id="changebyemail-tab" data-toggle="tab" href="#changebyemail" role="tab" aria-controls="changebyemail" aria-selected="true">Change by Email</a>
								</li>
								<li class="nav-item">
								  <a class="nav-link" id="changebymobile-tab" data-toggle="tab" href="#changebymobilearea" role="tab" aria-controls="changebymobilearea" aria-selected="false">Change by Mobile</a>
								</li>
							  </ul>
						</div>
					</div>
					<div class="col-lg-12 mt-4">
						<div class="tab-content" id="v-pills-tabContent">
	
							<div class="tab-pane fade show active" id="changebyemail" role="tabpanel" aria-labelledby="changebyemail-tab">
								<form name="login-user-password" class="login-wup">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<label class="control-label required">Email</label>
												<input type="text" name="<portlet:namespace/>emailAddress" id="emailAddress" value="" class="form-control" onchange="checkExistibility(this.id)">
							
											</div>
											
										</div>
										<p id="errorContainer-emailAddress" class="error-container"></p>
										<div class="col-lg-12 omsb-buttons my-3">
											<input type="button" onclick="sendVerificationOTP('emailAddress')" name="submit" class="btn omsb-bg-red-button  w-100" value="Send OTP">
										</div>
									</div>
								</form>
							</div>
	
							<div class="tab-pane fade " id="changebymobilearea" role="tabpanel" aria-labelledby="changebymobile-tab">
								<form name="login-user-password" class="login-wup">
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<label class="control-label required">Mobile Number</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text" id="basic-addon1">+968</span>
													  </div>
													<input type="text" name="<portlet:namespace/>mobileNumber" id="mobileNumber" value=""
													class="form-control"  pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==8) return false;">
												</div>
											</div>
												<p id="errorContainer-mobileNumber" class="error-container"></p>
										</div>
										<div class="col-lg-12 omsb-buttons my-3">
											<input type="button" name="submit" onclick="sendVerificationOTP('mobileNumber')" class="btn omsb-bg-red-button  w-100" value="Send OTP">
										</div>
									</div>
								</form>
							</div>
	
							<div class="tab-pane fade" id="mobilearea" role="tabpanel" aria-labelledby="mobile-tab">
								
								<form name="login-user-password" class="login-wup">
									<div class="row">
										<div class="col-lg-12 mt-4">
											<div class="form-group">
												<label class="control-label">Mobile Number </label>
												<input class="form-control" type="text" name="mobile" id="phone1" >
											</div>
										</div>
										<div class="col-lg-12 omsb-buttons my-4">
											<input type="submit" name="submit" class="btn omsb-bg-red-button  w-100" value="login">
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 my-4">
											<div class="info-text"><span> Don't have an account? </span><a href="" class="red-underline-link">Register Now</a></div>
										</div>
									</div>
									
									
								</form>
							</div>
	
						</div>
					</div>
				</div>
				
				<div class="login-forms d-none" id="verifyOTPScreen">
					<div class="col-lg-12 mt-4">
						<h2 class="forgot_password_heading">Verify OTP</h2>
                        <p>Enter the code here</p>
                        <form name="login-user-password" class="login-wup">
                            <div class="row">
                                <div class="col-lg-12 mt-3">
                                    <div class="form-group verifiotp">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                    </div>
                                  <!--   <p id="errorContainer-emailAddressOTP" class="error-container"></p> -->
                                     <p id="errorContainer-mobileNumberOTP" class="error-container"></p>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 mb-3 mt-3 forgot_password_heading"><liferay-ui:message key="time-left"/> : <span id="mobile-timer"></span></div>
                                <div class="col-lg-12 col-md-12 col-sm-12 mb-4 mt-4">
									<div class="info-text">
										<span>Didn't receive code? </span><a href="javascript:sendVerificationOTP('mobileNumber')" class="red-underline-link"  onlclick="">send again</a>
									</div>
								</div>
                                <div class="col-lg-12 omsb-buttons my-3">
                                    <input type="button" name="submit" class="btn omsb-bg-red-button  w-100 verifyOTPBtn" value="Verify OTP" onclick="verifyOTP('mobileNumber')">
                                </div>
                            </div>
                        </form>
					</div>
				</div>
				
				<div class="login-forms d-none" id="verifyEmailOTPScreen">
					<div class="col-lg-12 mt-4">
						<h2 class="forgot_password_heading">Verify OTP</h2>
                        <p>Enter the code here</p>
                        <form name="login-user-password" class="login-wup">
                            <div class="row">
                                <div class="col-lg-12 mt-3">
                                    <div class="form-group verifiotp">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                        <input class="form-control verifiotpField" type="text" name="" value="" maxlength="1" onclick="nextInput();">
                                    </div>
                                    <p id="errorContainer-emailAddressOTP" class="error-container"></p>
                                    <!--  <p id="errorContainer-mobileNumberOTP" class="error-container"></p> -->
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 mb-3 mt-3 forgot_password_heading"><liferay-ui:message key="time-left"/>:<span id="email-timer"></span></div>
                                <div class="col-lg-12 col-md-12 col-sm-12 mb-4 mt-4">
									<div class="info-text ">
										<span>Didn't receive code? </span><a href="javascript:sendVerificationOTP('emailAddress')" class="red-underline-link"  onlclick="">send again</a>
									</div>
								</div>
                                <div class="col-lg-12 omsb-buttons my-3">
                                    <input type="button" name="submit" class="btn omsb-bg-red-button  w-100 verifyOTPBtn" value="Verify OTP" onclick="verifyOTP('mobileNumber')">
                                </div>
                            </div>
                        </form>
					</div>
				</div>
				
	<div class="login-forms d-none" id="passwordScreen">
					<div class="col-lg-12 mt-4">
						<!-- <h2 class="forgot_password_heading">Change Password</h2> -->
                      <!--   <p>Enter new password</p> -->
                        <form name="login-user-password" class="login-wup">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label>New Password</label>
                                        <input class="form-control" type="password" name="" id="newPassword">
                                    </div>
                                </div>
                                <p id="errorContainer-password" class="error-container"></p>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label>Re-enter new password</label>
                                        <input class="form-control" type="password" name="" id="newPassword2">
                                    </div>
                                </div>
                                 <p id="errorContainer-reTypePassword" class="error-container"></p>
                                <div class="col-lg-12 omsb-buttons my-2">
                                    <input type="button" name="submit" class="btn omsb-bg-red-button  w-100" value="Change Password" onclick="updatePassword()">
                                </div>
                            </div>
                        </form>
					</div>
	</div>			
	
		<div class="login-forms d-none" id="successScreen">
					<div class="col-lg-12 mt-4">
						<h2 class="forgot_password_heading">Password Reset Successful</h2>
                        <p>Your password has been changed successfully<br>Click below login.</p>
                        <form name="login-user-password" class="login-wup">
                            <div class="row">
                                <div class="col-lg-12 omsb-buttons my-2">
                                    <input type="button" name="submit" class="btn omsb-bg-red-button  w-100" value="Login" onclick="redirectToLogin()">
                                </div>
                            </div>
                        </form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	
</div>

</div>

	</div>
</body>

<!-- <script type="text/javascript" src="../js/intlTelInput.js"></script> -->

<script type="text/javascript">
let timerOn = true;
var phone1 = document.querySelector("#phone1");
setTimeout(function() {
	window.intlTelInput(phone1,({initialCountry:"om", separateDialCode: "true", showFlags:"false"}));
}, 100);

$(document).ready(function () {
	  var trigger = $('.hamburger'),
	      overlay = $('.overlay'),
	     isClosed = false;
	
	    trigger.click(function () {
	      hamburger_cross();      
	    });
	
	function hamburger_cross() {
	
	    if (isClosed == true) {          
	      overlay.hide();
	      trigger.removeClass('is-open');
	      trigger.addClass('is-closed');
	      isClosed = false;
	    } else {   
	      overlay.show();
	      trigger.removeClass('is-closed');
	      trigger.addClass('is-open');
	      isClosed = true;
	    }
	}
	  
		$('[data-toggle="offcanvas"]').click(function () {
	        $('#omsb-main-wrapper').toggleClass('toggled');
	    });  
});


function isValidVerificationField(verificationTypeField){

let isValid = false; 
if(verificationTypeField == "emailAddress"){
	var emailAddress = document.getElementById("emailAddress").value;
	if (!emailAddress) {
		document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-email-address' />";
	} else {
		document.getElementById("errorContainer-emailAddress").textContent = "";
		let regex = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
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
		/* document.getElementById("errorContainer-mobileNumber").textContent = "";
		if (mobileNumber.length>8) {
			document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-valid-mobile-number' />";
		} else {
			document.getElementById("errorContainer-mobileNumber").textContent = "";
			isValid = true;
		} */
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
		let regex = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
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



function timer(remaining,id) {
  var m = Math.floor(remaining / 60);
  var s = remaining % 60;
  
  m = m < 10 ? '0' + m : m;
  s = s < 10 ? '0' + s : s;
  document.getElementById(id).innerHTML = m + ':' + s;
  remaining -= 1;
  
  if(remaining >= 0 && timerOn) {
    setTimeout(function() {
        timer(remaining,id);
    }, 1000);
    return;
  }else{
	  timerOn=false;
  }

  if(!timerOn) {
	  console.log("timerOn:::",timerOn);
	  $('.verifiotpField').prop('disabled', true);
	  $('.verifyOTPBtn').prop('disabled', true);
	  $('.info-text').css('pointer-events','');
	  $('.info-text').css('opacity', '');
    // Do validate stuff here
    return;
  }
  
  // Do timeout stuff here
  alert('Timeout for otp');
}



function sendVerificationOTP(verificationTypeField){
	$('.verifiotpField').prop('disabled', false);
	$('.verifyOTPBtn').prop('disabled', false);
	$('.info-text').css('pointer-events','none');
	$('.info-text').css('opacity', '0.6');
	timerOn=true;
if(isValidVerificationField(verificationTypeField)){
	var inputVal = $("#"+verificationTypeField).val();
	var personId = $("#personId").val();
		$.ajax({
			url: '${sendOTPURL}',
			async : false,
			data : {
				<portlet:namespace />verificationType : verificationTypeField,
				<portlet:namespace />inputVal : inputVal,
				<portlet:namespace />sendOtp:true,
				<portlet:namespace />personID : personId
			},
			type : 'POST',
			success : function(data) {
				console.log("verificationTypeField ,"+verificationTypeField);
				if(verificationTypeField == "mobileNumber"){
					timer(60,'mobile-timer');
				}else if(verificationTypeField == "emailAddress"){
					timer(60,'email-timer');
				}
				const response = JSON.parse(data);
				if(response.isValid){
					$("#verificationType").val(verificationTypeField);
					$('#personId').val(response.personId);
					$('#lRUserId').val(response.lRUserId);
					if(verificationTypeField=="emailAddress"){
					  $("#verifyEmailOTPScreen").removeClass('d-none');
					  $("#verifyOTPScreen").addClass('d-none');
					}
					else{
					$("#verifyOTPScreen").removeClass('d-none');
					 $("#verifyEmailOTPScreen").addClass('d-none');
					}
					$("#userDetailScreen").addClass('d-none');
				} else {
					if(verificationTypeField=="emailAddress"){
						document.getElementById("errorContainer-"+verificationTypeField).textContent = '<liferay-ui:message key="emailAddress-does-not-exist" />';
					} else{
						document.getElementById("errorContainer-"+verificationTypeField).textContent = '<liferay-ui:message key="mobileNumber-does-not-exist" />';
					}
				}				
			}
	});
}
}

function verifyOTP(){debugger;
	console.log("Verify OTP called ::::");
	var inputVal="";
	var verificationType= $("#verificationType").val();
	var key=verificationType+"OTP";
	
	$(".verifiotpField" ).each(function() {
		inputVal=inputVal+$(this).val();
	});
	console.log(inputVal);
	if(verificationType == "mobileNumber"){
		$('#mobileNumberOTP').val(inputVal);
	}else{
		$('#emailAddressOTP').val(inputVal);
	}
	
	var isValid = isValidVerificationOTPField(key);
if(isValid)	{
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
		success : function(data) {debugger;
			const response = JSON.parse(data);
			console.log("response :::",response);
			console.log("verificationType :::",verificationType);
			if(response.isValid){
				console.log("inside if response.isValid ",response.isValid);
				if(verificationType=="emailAddress"){
					$("#verifyEmailOTPScreen").addClass('d-none');	
				}else if(verificationType=="mobileNumber"){
					$("#verifyOTPScreen").addClass('d-none');	
				}
				$('#passwordScreen').removeClass('d-none');
			} else {
				document.getElementById("errorContainer-"+verificationType+"OTP").textContent = "<liferay-ui:message key='invalid-otp' />";
				
			}
		},
	})
}
}

function checkExistibility(verificationTypeField){
if(isValidVerificationField(verificationTypeField)){
	var inputVal = $("#"+verificationTypeField).val();
	$.ajax({
		url: '${sendOTPURL}',
		async : false,
		data : {
			<portlet:namespace />verificationType : verificationTypeField,
			<portlet:namespace />sendOtp:false,
			<portlet:namespace />inputVal : inputVal
		},
		type : 'POST',
		success : function(data) {
			const response = JSON.parse(data);
			console.log(response);
			console.log("-----");
		 	console.log(!response.isValid);
			//if(!response.isValid){
				if(verificationTypeField=="emailAddress"){debugger
					if(!response.isValid){
					document.getElementById("errorContainer-"+verificationTypeField).textContent = '<liferay-ui:message key="Email Id Does not Exist" />';
					
					}
					else{
						document.getElementById("errorContainer-"+verificationTypeField).textContent = '';
						
					}	
				}
					else if(verificationTypeField=="mobileNumber"){
						if(!response.isValid){
							document.getElementById("errorContainer-"+verificationTypeField).textContent = '<liferay-ui:message key="Mobile Number Does not Exist" />';
							
						}
						else{
							document.getElementById("errorContainer-"+verificationTypeField).textContent = '';
							
						}
					} 			
		}
	});
}
}


function updatePassword() {
			var newPassword = $("#newPassword").val();
			var newPassword2 = $("#newPassword2").val();
			var lrUserId= $('#lRUserId').val();
			
			
			 var password = document.getElementById("newPassword").value;
			 console.log("password :::",password);
		        var passw= /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{7,19}$/;
		        if (!password) {
		            /* errorMessages.push("<liferay-ui:message key='please-enter-password' />"); */
		            document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='please-enter-password' />";
		        }else if(password.length<8){
					 console.log("password length is less than 8:::",password.length);
		            /* errorMessages.push("<liferay-ui:message key='password-length-error' />"); */
		            document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='password-length-error' />";
		        }else if(!password.match(passw)){
		            /* errorMessages.push("<liferay-ui:message key='password-regular-expression-error' />"); */
		            document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='password-regular-expression-error' />";
		        } else {
		            document.getElementById("errorContainer-password").textContent = "";
		        }
		        var reTypePassword = document.getElementById("newPassword2").value;
		        
		        
			    var errorMessageText= $("#errorContainer-password").text();
			    console.log("errorMessageText :::",errorMessageText);
		        if(errorMessageText==""){
		        	if (!reTypePassword) {
			            /* errorMessages.push("<liferay-ui:message key='please-enter-retype-password' />"); */
			            document.getElementById("errorContainer-reTypePassword").textContent = "<liferay-ui:message key='please-enter-retype-password' />";
			        } else {
			            document.getElementById("errorContainer-reTypePassword").textContent = "";
			            if (password === reTypePassword) {
			            	$.ajax({
								url : '${updatePasswordURL}',
								async : false,
								data : {
									
									<portlet:namespace />newPassword : newPassword,
									<portlet:namespace />lrUserId : lrUserId
								},
								type : 'POST',
								success : function(data) {
									const response = JSON.parse(data);
									console.log(!response.isValid);
									if(response.isValid){
										$('#successScreen').removeClass('d-none');
										$("#passwordScreen").addClass('d-none');
									}else{
										console.log("Error Message Added :::");
									}
				
								}
							});
			            	document.getElementById("errorContainer-reTypePassword").textContent = "";
			            } else {
			                /* errorMessages.push("<liferay-ui:message key='retype-password-does-not-match-with-password' />"); */
			                document.getElementById("errorContainer-reTypePassword").textContent = "<liferay-ui:message key='retype-password-does-not-match-with-password' />";
			            }
			        }
		        }else{
		        	$("#passwordScreen").removeClass("d-none");
		        	$('#successScreen').addClass('d-none');
		        }
		        
		        
		        
		       
	}

function redirectToLogin(){
	window.location.replace("/login");
}

/* $('.num:first').keyUp(function (event) {
        event.preventDefault();
        $(this).next('.num').focus();
}); */



function nextInput() {
    var inputs = document.querySelectorAll(".verifiotpField");
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener("keyup", function (event) {
        	  var currentIndex = Array.from(inputs).indexOf(event.target);
             if (event.key === "Backspace" || event.key === "ArrowLeft") {
                  var nextIndex = (currentIndex - 1) % inputs.length;
                  inputs[nextIndex].focus();
                  event.preventDefault();           	
             }
             else{
                 var nextIndex = (currentIndex + 1) % inputs.length;
                 inputs[nextIndex].focus();
                 event.preventDefault();
             }
        });
    }
}
	</script>