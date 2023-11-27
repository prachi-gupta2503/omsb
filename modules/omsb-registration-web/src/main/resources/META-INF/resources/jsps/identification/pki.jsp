<%@ include file="../../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
 <liferay-portlet:actionURL name="<%=MVCCommands.PKI_MOBILE_IDENTIFICATION %>" var="mobilePkiConfirmationActionCommand">
 </liferay-portlet:actionURL>
 
<portlet:renderURL var="viewDefault">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommands.VIEW_CAPTCHA%>" var="captchaResourceURL" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_CIVIL_ID%>" var="validateCivilIdURL" />
<div class="main-content id-box">
	<div class="omsb-main-wrapper" id="omsb-main-wrapper">
		<div class=" row bg-white">
			<div class="col-12 login-right">
				<div class="omsb-card ">
					<div class="omsb-pre-login header">
						<div>
							<img alt="" src="<%=themeDisplay.getPathThemeImages() %>/svg/logo.svg">
						</div>
						<div>
							<p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/></p>
							<p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
						</div>
					</div>
					<div class="Id-forms">
						<div class="omsb-page-top-info">
							<div class="pagetitle"><liferay-ui:message key="identification-pki"/></div>
						</div>
							<div class="d-flex">
								<div class="w-25">
									<label class="control-label"><liferay-ui:message key="pki-using-card-or-mobile"/></label>
								</div>
								<div class="form-group yesorno">
									<div class="custom-control custom-radio ">
										<input type="radio" name="pkitype"
											class="custom-control-input" id="card" value="card">
										<label class="custom-control-label m-0" for="card"><liferay-ui:message key="card"/></label>
									</div>

									<div class="custom-control custom-radio ">
										<input type="radio" name="pkitype"
											class="custom-control-input" id="mobile" value="mobile"
											checked="checked"> <label
											class="custom-control-label m-0" for="mobile"><liferay-ui:message key="mobile"/></label>
									</div>
								</div>
							</div>
                            <form name="login-user-password" action="${mobilePkiConfirmationActionCommand}" class="login-wup" method="post" name="<portlet:namespace/>pki-form" id="pki-form"> 
							<div id="mobile-area">
								<div class="omsb-card omsb-card-graybg">
                        			<div class="row"> 
                        				<div class="col-md-12">	
                        				<div class="d-flex align-items-center">
                        <c:if test="${pkiAvaibility}">  
						 	<div class="form-group">
								<label class="control-label"><liferay-ui:message key="enter-mobile-number-for-pki-identification"/></label> 
								<input class="form-control" placeholder="<liferay-ui:message key="mobile"/>" type="text" id="mobileno" name="<portlet:namespace/>mobileno" onKeyPress="if(this.value.length==8) return false;return onlyNumberKey(event);" onpaste="return false;" ondrop="return false;" >
						 	</div>
						 	<button type="button" onclick="getCivilId()" class="get-civil-id btn omsb-bc-red-button" title="<liferay-ui:message key="get-civilId"/>" id="get-civilId"><liferay-ui:message key="get-civilId"/></button>
						 </c:if>
						 	</div>
						 	<p id="errorContainer-mobileNumber" class="error-container"></p>
						 </div>
						 
						 <div class="row col-lg-12">
						 <div class="form-group col-md-6 col-sm-6">
						 	<label class="control-label"><liferay-ui:message key="omani-civil-id-or-omani-resident-id"/></label> <input
								class="form-control" placeholder="<liferay-ui:message key="omani-civil-id-or-omani-resident-id"/>" type="text"
								name="<portlet:namespace/>civil_id" id="civil_id" >
							<span id="civilId_error" style="color: red;"><liferay-ui:message key="please-enter-omani-civil-id"/></span>								
							<span id="civilId_Exist_error" class="d-none" style="color: red;"><liferay-ui:message key="Civil-already-exist"/></span>								
						</div>
									<div class="form-group col-md-6 col-sm-6">
										<label class="control-label"><liferay-ui:message key="date-of-birth"/></label> <input
											class="form-control datePicker" placeholder="<liferay-ui:message key="date-of-birth"/>"
											type="text" name="<portlet:namespace/>dob" id="dob">
											<span id="dobcheck" style="color: red; display:none"><liferay-ui:message key="please-select-date-of-birth"/></span>
											<span id="ageError" style="color: red; display:none"><liferay-ui:message key="age-error"/></span>
									</div>

								</div>
								<%-- <div>
							   	<liferay-captcha:captcha url="<%= captchaResourceURL %>"/>							
								</div>
								<liferay-ui:error key="captchaError"  message="captcha-verification-failed" /> --%>
						</div>
					
						<div class="bottom-backbtn-wrap">
							<button class="btn omsb-bc-red-button" title="<liferay-ui:message key="next"/>" type="submit" id="mobileSubmit"><liferay-ui:message key="next"/></button>
							<a class="btn omsb-btn btn-back" href="${viewDefault}"><i
								class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
						</div>
					</div>
							<input type="hidden" name="<portlet:namespace/>fullName" id="fullName">
							<input type="hidden" name="<portlet:namespace/>fullNameAr" id="fullNameAr">
							<input type="hidden" name="<portlet:namespace/>isPkiIdentified" id="isPkiIdentified">
							</div>
							</form>
							<form name="login-user-password-card" class="login-wup"> 
							<div id="card-area" class="d-none">
								<div class="omsb-card omsb-card-graybg text-center">
									<h3 class="reg-form-title"><liferay-ui:message key="scan-Id"/></h3>
									<div class="form-group">
										<img alt="" src="<%=themeDisplay.getPathThemeImages() %>/svg/pki-reader.svg">
									</div>
									<a class="btn omsb-bg-red-button d-inline-block" rel="external" onclick="setLS()">
											<liferay-ui:message key="scan-your-id" /></a>
								</div>
								<div class="bottom-backbtn-wrap ">
									<button class="btn omsb-bc-red-button" id="next" title="<liferay-ui:message key="next"/>"><liferay-ui:message key="next" /></button>
									<a class="btn omsb-btn btn-back" href="${viewDefault}"><i
										class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
								</div>
							</div>							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="loader-container d-none">
	<div class="loaded">
		<img src="<%=themeDisplay.getPathThemeImages()%>/svg/loader.svg"
			alt="loader">
	</div>
</div>



<%-- <liferay-ui:error exception="<%= CaptchaTextException.class %>"  message="captcha-verification-failed" /> --%>
<portlet:resourceURL id="<%=MVCCommands.GET_CIVILID_BY_MOBILENUMBER%>" var="getCivilIdURL" />
<script type="text/javascript">
	$('input[name="pkitype"]').change(function() {
		var pkityp = $("input[name='pkitype']:checked").val();
		console.log("pkityp"+pkityp);
		if(pkityp == "card") {
			console.log("card");
			$('#card-area').removeClass("d-none");
			$('#mobile-area').addClass("d-none");
		} else {
			console.log("mobile");
			$('#mobile-area').removeClass("d-none");
			$('#card-area').addClass("d-none");
		}
	});
		
	$('#dob').datepicker({
		format: "dd-mm-yyyy",
		orientation: "bottom auto",
		autoclose: true
	}).on('change', function(){
		$('.datepicker').hide();
	});
			 
	$( document ).ready(function() {
		$('#civilId_error').hide();
		$('#mobileSubmit').click(function(){
			var errors=[];
			var dateOfBirth=$("#dob").val();
			var civilId= $("#civil_id").val();
			if(civilId==""){
				errors.push("civil Id error");
			 	$('#civilId_error').show();
		 	} else{
				$('#civilId_error').hide();
		 	}
	     	if(dateOfBirth.length == 0 ){
				$("#dobcheck").css("display","block");
				$("#ageError").css("display","none");
				errors.push("dob error");
	      	} else {
	    		$("#dobcheck").css("display","none");
		      	$("#ageError").css("display","none");
	      	}				
			var chunks = dateOfBirth.split('-');
			var formattedDate = chunks[1]+'-'+chunks[0]+'-'+chunks[2];	
			var today = new Date();
			var birthDate = new Date(formattedDate);
			var age = today.getFullYear() - birthDate.getFullYear();
		
			if (age > 18+1) {
				$("#dobcheck").css("display","none");
				$("#ageError").css("display","none");	
			}else{
				$("#dobcheck").css("display","none");
	 			$("#ageError").css("display","block");
	 			errors.push("age error");	
			} 
			
			if(errors.length>0){
				event.preventDefault();
			} else{
				document.getElementById("pki-form").submit();
			}
		});  
		
		/* //Civil Id check 
		$('#civil_id').focusout(function(){
			var civilIdVal=$('#civil_id').val();
			console.log("civilIdVal :::",civilIdVal);
			$.ajax({
				url: '${validateCivilIdURL}',
				async : false,
				data : {
					<portlet:namespace />civilIdVal : civilIdVal
				},
				type : 'POST',
				success : function(data) {
					console.log('Response :'+data);
					const response = JSON.parse(data);
					if(response.isValid){
						console.log("inside if ::::");
						//document.getElementById("civil_id").value = response.civilId;
						//document.getElementById("fullName").value = response.fullName;
						//document.getElementById("fullNameAr").value = response.fullNameAr;
						//document.getElementById("isPkiIdentified").value = "true";
						$("#civilId_Exist_error").addClass("d-none");
					} else {
						console.log("inside else ::::;");
						$("#civilId_Exist_error").removeClass("d-none");
					}
				},
			})
		}); */
		
		
	}); 

	$('#dob').change(function(){
		var dobVal=$('#dob').val();
		var chunks = dobVal.split('-');
		var formattedDate = chunks[1]+'-'+chunks[0]+'-'+chunks[2];	
		var today = new Date();
		var birthDate = new Date(formattedDate);
		var age = today.getFullYear() - birthDate.getFullYear();
	
		if (age > 18+1) {
			$("#dobcheck").css("display","none");
			$("#ageError").css("display","none");	
			$('#next').removeAttr('disabled');
			return true; 
		}else{
			$("#dobcheck").css("display","none");
 			$("#ageError").css("display","block");
 			$('#next').attr("disabled", true);
			return false;
		} 
	});
	function getCivilId(){
		addLoader();
		var inputVal = $("#mobileno").val().trim();
		document.getElementById("errorContainer-mobileNumber").textContent = "";
		if(inputVal.length == 8 && (inputVal.startsWith("7") || inputVal.startsWith("9"))){
			$.ajax({
				url: '${getCivilIdURL}',
				async : false,
				data : {
					<portlet:namespace />mobileNumber : inputVal
				},
				type : 'POST',
				success : function(data) {
					console.log('PKI Response :'+data);
					const response = JSON.parse(data);
					if(response.isValid){
						document.getElementById("civil_id").value = response.civilId;
						document.getElementById("fullName").value = response.fullName;
						document.getElementById("fullNameAr").value = response.fullNameAr;
						document.getElementById("isPkiIdentified").value = "true";
					} else {
						if(response.error==501){
							document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='failed-to-authenticate' />";
						} else {
							document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='something-went-wrong' />";
						}
						document.getElementById("civil_id").value = '';
					}
					setTimeout(function() {
						removeLoader();
					}, 200);

					
				},
			})
		} else {
			document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-valid-mobile-number' />";
			setTimeout(function() {
				removeLoader();
			}, 200);
		}
	}
	
	function setLS(){
	    localStorage.setItem("redirectionType", "signup");
	    $(location).attr('href', '${cardReaderIDPURL}');
	}
	
	function onlyNumberKey(evt) {
		var ASCIICode = (evt.which) ? evt.which : evt.keyCode
	    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
	        return false;
	    return true;
	}
	
	function addLoader(){
		console.log("add loader called");
	    const loaderContainer = document.querySelector('.loader-container');
	    loaderContainer.classList.remove('d-none');
	    const loader = document.querySelector('.loaded');
	    loader.classList.add('loader');
	}
	
	function removeLoader(){
		console.log("remove called");
		const loaderContainer = document.querySelector('.loader-container');
		loaderContainer.classList.add('d-none');
		const loader = document.querySelector('.loaded');
		loader.classList.remove('loader');
		console.log("remove complete");
	}
</script>