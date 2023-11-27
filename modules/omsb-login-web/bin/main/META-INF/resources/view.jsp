<%@ include file="/init.jsp" %>
<style>
  .omsb-buttons a.trans{
  color: #DC3545;
  }
</style>
<portlet:actionURL name="/login-user" var="validateUserURL">
</portlet:actionURL>

<portlet:renderURL var="forgotPasswordURL">
    <portlet:param name="action" value="forgotPassword" />
</portlet:renderURL>

<%-- <c:if test="<%= !SessionErrors.isEmpty(renderRequest) && 
	(!SessionMessages.keySet(renderRequest).iterator().next().equals(PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE))%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/reject.svg" alt="reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading"><span><liferay-ui:message key="<%= SessionErrors.keySet(renderRequest).iterator().next() %>" /></span></h4>
			</div>
		</div>
	</div>
</c:if> --%>

<c:if test="${isError}">
        <div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/reject.svg" alt="reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading"><span><liferay-ui:message key="${errorMessage}" /></span></h4>
			</div>
		</div>
	</div>
</c:if>

<c:choose>
	<c:when test="${isSignedIn}">
        <div class="alert alert-light alert-success-text" role="alert">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<div class="alert-box">
				<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/Right.svg" alt="Right"></span>
				<div class="alert-text">
					<h4 class="alert-heading"><span><liferay-ui:message arguments="<%= themeDisplay.getUser().getScreenName() %>" key="you-are-signed-in-as-x" /></span></h4>
				</div>
			</div>
		</div>
	</c:when>
<c:otherwise>
    		
<div class="main-content" >
<div class="omsb-main-wrapper" id="omsb-main-wrapper">
<div class=" row bg-white">
	<div class="col-lg-6 col-md-6 login-left"><img class="w-100" src="<%= themeDisplay.getPathThemeImages() %>/svg/login_left.svg"></div>
	<div class="col-lg-6 col-md-6 login-right">
	<div class="login-box-wrap" >
		<div class="login-box">
			<div class="logo-img">
				<img src="<%= themeDisplay.getPathThemeImages() %>/svg/logo.svg">
			</div>
			<div class="site-title">
				<div class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board-arabic" /></div>
				<div class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></div>
			</div>
			<div class="login-forms">
				<div class="row">
					<div class="col-lg-12">
						<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
							<li class="nav-item">
							  <a class="nav-link ${loginType == 'pkiUsername' ? 'active' : ''} ${loginType == '' ? 'active' : ''}" id="username-tab" data-toggle="tab" href="#usernamearea" role="tab" aria-controls="usernamearea" aria-selected="true"><liferay-ui:message key="username" /></a>
							</li>
							<li class="nav-item">
							  <a class="nav-link ${loginType == 'pkiCard' ? 'active' : ''}" id="pki-tab" data-toggle="tab" href="#pkiarea" role="tab" aria-controls="pkiarea" aria-selected="false"><liferay-ui:message key="pki-card" /></a>
							</li>
							<li class="nav-item">
							  <a class="nav-link ${loginType == 'pkiMobile' ? 'active' : ''}" id="mobile-tab" data-toggle="tab" href="#mobilearea" role="tab" aria-controls="mobilearea" aria-selected="false"><liferay-ui:message key="mobile-number" /></a>
							</li>
						  </ul>
					</div>
				</div>
				<div class="col-lg-12 mt-4">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade ${loginType == 'pkiUsername' ? 'show active' : ''} ${loginType == '' ? 'show active' : ''}" id="usernamearea" role="tabpanel" aria-labelledby="username-tab">
							<form name="<portlet:namespace />login-user-password" class="login-wup" id="loginFormUsername" action="${validateUserURL}" method="post">
								<input type="hidden" id="<portlet:namespace />loginType" name="<portlet:namespace />loginType" value="pkiUsername">
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											 <label for="<portlet:namespace />userName" class="control-label required"><liferay-ui:message key="username" /></label>
				                            <input type="text" class="form-control"
				                            id="username" name="<portlet:namespace />username">
				                            <c:if test="<%= SessionErrors.contains(renderRequest, "username-required")%>">
										        <div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key=" username-required" /></div>
										    </c:if>
				                            <c:if test="<%= SessionErrors.contains(renderRequest, "user-not-exist")%>">
										        <div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="user-not-exist" /></div>
										    </c:if>
										    <c:if test="<%= SessionErrors.contains(renderRequest, "user-not-exist-with-x")%>">
										        <div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="user-not-exist-with-x" arguments="${username}"/></div>
										    </c:if>
										</div>
									</div>
									<div class="col-lg-12">
										<div class="form-group">
											<label for="<portlet:namespace />password" class="control-label required"><liferay-ui:message key="password" /></label>
				                            <input type="password" class="form-control"
				                            id="password" name="<portlet:namespace />password">
				                            <c:if test="<%= SessionErrors.contains(renderRequest, "password-required") %>">
									 				<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="password-required" /></div>
											</c:if>
				                            <c:if test="<%= SessionErrors.contains(renderRequest, "incorrect-credentials") %>">
									 			<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="incorrect-credentials" /></div>
											</c:if>
											<c:if test="<%= SessionErrors.contains(renderRequest, "something-went-wrong") %>">
										 		<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="something-went-wrong" /></div>
											</c:if>
										</div>
									</div>
								<%-- <div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<div class="custom-control custom-checkbox ">
											<input type="checkbox" class="custom-control-input" id="<portlet:namespace />rememberMe" name="<portlet:namespace />rememberMe">
											<label class="custom-control-label m-0" for="rememberMe"><liferay-ui:message key="remember-me" /></label>
										</div>
									</div>
								</div> --%>
								<div class="col-lg-12">
									<div class="omsb-buttons d-flex flex-row my-2">
										<button name="<portlet:namespace />loginButton" id="<portlet:namespace />loginButton"
				                         type="submit" class="btn omsb-bg-red-button" ><span>
				                         <liferay-ui:message key="login" /></span></button>
										 <a href="/forget-password" class="trans red-underline-link" ><liferay-ui:message key="forgot-password" />?</a> 
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 mb-4 mt-4">
									<div class="info-text">
										<span><liferay-ui:message key="dont-have-account" />? </span><a href="${registrationUrl}" class="red-underline-link"><liferay-ui:message key="sign-up" /></a>
									</div>
								</div>
							</div>
							</form>
						</div>

						<div class="tab-pane fade ${loginType == 'pkiCard' ? 'show active' : ''}" id="pkiarea" role="tabpanel" aria-labelledby="pki-tab">
							<form name="<portlet:namespace />login-user-password" class="login-wup" id="loginFormPkiCard" action="${validateUserURL}" method="post">
								<input type="hidden" id="<portlet:namespace />loginType" name="<portlet:namespace />loginType" value="pkiCard">
								<div class="omsb-card text-center" >
									<div class="row">
										<div class="col-lg-12 text-center">
										<div class="form-group pki-card-box">
											<img src="<%= themeDisplay.getPathThemeImages() %>/svg/pki-reader.svg" class="img-responsive center-block">
										</div>
										</div>
										<div class="col-lg-12">
											<c:if test="<%= SessionErrors.contains(renderRequest, "something-went-wrong") %>">
										 		<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="something-went-wrong" /></div>
											</c:if>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 my-4">
											<button name="<portlet:namespace />loginButton" id="loginButtonPkiCard" 
											type="submit" class="btn omsb-bg-red-button  w-100"><liferay-ui:message key="scan-your-id" /></button>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 mb-0">
											<div class="info-text">
												<span><liferay-ui:message key="dont-have-account" />? </span><a href="${registrationUrl}" class="red-underline-link"><liferay-ui:message key="sign-up" /></a>
											</div>
										</div>	
									</div>
								</div>
							</form>
						</div>

						<div class="tab-pane fade ${loginType == 'pkiMobile' ? 'show active' : ''}" id="mobilearea" role="tabpanel" aria-labelledby="mobile-tab">							
							<form name="<portlet:namespace />login-user-password" class="login-wup" id="loginFormPkiMobile" action="${validateUserURL}" method="post">
								<input type="hidden" id="<portlet:namespace />loginType" name="<portlet:namespace />loginType" value="pkiMobile">
								<input type="hidden" name="<portlet:namespace />countryCode" id="hiddenCountryCode" value="" />
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="mobile-number" /></label>
											<input type="text" class="form-control" name="<portlet:namespace />mobileNumber" id="mobileNumber" >
											<c:if test="<%= SessionErrors.contains(renderRequest, "mobile-required") %>">
									 			<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="mobile-required" /></div>
											</c:if>
											<c:if test="<%= SessionErrors.contains(renderRequest, "failed-to-authenticate") %>">
									 			<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="failed-to-authenticate" /></div>
											</c:if>
											<c:if test="<%= SessionErrors.contains(renderRequest, "enter-valid-mobile") %>">
									 			<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="enter-valid-mobile" /></div>
											</c:if>
											<c:if test="<%= SessionErrors.contains(renderRequest, "something-went-wrong") %>">
										 		<div role="alert" class="text-danger form-feedback-item help-block"><liferay-ui:message key="something-went-wrong" /></div>
											</c:if>
										</div>
									</div>
									<div class="col-lg-12 omsb-buttons">
										<button name="<portlet:namespace />loginButton" id="<portlet:namespace />loginButton"
				                         type="submit" class="btn omsb-bg-red-button  w-100"><span>
				                         <liferay-ui:message key="login" /></span></button>
									</div>
									<div class="col-lg-12 col-md-12 col-sm-12 mb-4 mt-4">
										<div class="info-text">
											<span><liferay-ui:message key="dont-have-account" />? </span><a href="${registrationUrl}" class="red-underline-link"><liferay-ui:message key="sign-up" /></a>
										</div>
									</div>	
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div></div>
	</div>
</div>

</div>
</div>
</c:otherwise>
</c:choose>

<div class="loader-container loaded d-none">
	<div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
	<liferay-ui:message key="please-wait-while-processing-request" />
</div>

<script type="text/javascript">
window.addEventListener("load", function() {
	var loginUrl = '${loginUrl}';
	if(loginUrl != ''){
		window.location.href = loginUrl;
	}
});

initLoader = function(){
	$('.loader-container').removeClass('d-none');
}; 

var phone1 = document.querySelector("#mobileNumber");
var hiddenCountryInput = document.querySelector("#hiddenCountryCode");
var itl = '';
if(phone1 && hiddenCountryInput){
	setTimeout(function() {
		itl = window.intlTelInput(phone1,({initialCountry:"om", separateDialCode: "flase", onlyCountries: ["om"], showFlags:"false", dropdownContainer:"false"}));
		var selectedCountry = itl.getSelectedCountryData();
		hiddenCountryInput.value = selectedCountry.dialCode;
		
		var dropDownIcon = document.getElementsByClassName("iti__arrow");
		if (dropDownIcon.length > 0) {
			dropDownIcon[0].remove();
		}
	}, 100);		
}


if(phone1){
	phone1.addEventListener("countrychange",function() {
		var selectedCountry = itl.getSelectedCountryData();
		hiddenCountryInput.value = selectedCountry.dialCode;
	});
}


$("input[name='<portlet:namespace />mobileNumber']").on("input", function(){
    this.value = destroyMask(this.value);
})

function destroyMask(value){
  var number = value.replace(/\D/g,'').substring(0, 8);
  if(/^[79][0-9]*$/.test(number)){
  	return number;
  }else{
  	return '';
  }
}

document.addEventListener("DOMContentLoaded", function () {
	var usernameForm = document.getElementById("loginFormUsername");
	if(usernameForm){
		usernameForm.addEventListener("submit", function (event) {
			$(".help-block").remove();
	        event.preventDefault();
	        var isValid = true;
	        
	        const username = $('#username').val();
	        const password = $('#password').val();
	        var emailPattern = /^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/;
	        
	        if(!username || /^\s*$/.test(username)) {
	        	isValid = false;
	            var errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='mobileHelper'>
	 				<div role="alert" class="text-danger"><liferay-ui:message key="username-required" /></div>
	 			</div>`;
	 			$('#username').closest('.form-group').append(errorMsg);
	        }
	        
	        if(!password || /^\s*$/.test(password)){
	        	isValid = false;
	            var errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='mobileHelper'>
	 				<div role="alert" class="text-danger"><liferay-ui:message key="password-required" /></div>
	 			</div>`;
	 			$('#password').closest('.form-group').append(errorMsg);
	        }
	        
	        if(emailPattern.test(username)) {
	        	isValid = false;
	            var errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='mobileHelper'>
	 				<div role="alert" class="text-danger"><liferay-ui:message key="enter-valid-username" /></div>
	 			</div>`;
	 			$('#username').closest('.form-group').append(errorMsg);
	        } 
	        
	        if(isValid){
	        	 usernameForm.submit();
	        	 initLoader();
	        }
	    });
	}
	
    var pkiCardForm = document.getElementById("loginFormPkiCard");
    if(pkiCardForm){
	   	pkiCardForm.addEventListener("submit", function (event) {
           event.preventDefault();
           localStorage.setItem("redirectionType", "login");
           pkiCardForm.submit();
      	});
    }
    
    var pkiMobileForm = document.getElementById("loginFormPkiMobile");
    if(pkiMobileForm){
        pkiMobileForm.addEventListener("submit", function (event) {
        	$(".help-block").remove();
            event.preventDefault();
            var isValid = true;
            
            const mobileNumber = $('#mobileNumber').val();
            var messageKey = '';
            
            if (!mobileNumber) {
                messageKey = '<liferay-ui:message key="mobile-required" />'
            	isValid = false;
            }else if (mobileNumber.length !== 8) {
                messageKey = '<liferay-ui:message key="enter-valid-mobile" />'
            	isValid = false;
            }
            
            if(!isValid){
            	var errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='mobileHelper'>
     				<div role="alert" class="text-danger">\${messageKey}</div>
     			</div>`;
     			$('#mobileNumber').closest('.form-group').append(errorMsg);
            }
            
            if(isValid){
            	pkiMobileForm.submit();
            	initLoader();
            }
        });
    }
});
</script>
