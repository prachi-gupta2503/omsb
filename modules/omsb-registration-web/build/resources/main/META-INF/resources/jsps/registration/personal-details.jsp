<%@ include file="../../init.jsp"%>
<style>
.tooltipp {
  position: relative;
  display: inline-block;
  margin-bottom: 4px;
}

.tooltipp .tooltiptext {
     visibility: hidden;
    width: 300px;
    background-color: black;
    color: #fff;
    border-radius: 6px;
    padding: 5px 0;
    position: absolute;
    z-index: 1;
}

.tooltipp:hover .tooltiptext {
  visibility: visible;
}
.cst_ul{
margin: 0px;
float:left;
width:100%; 
}
.cst_ul li{
padding : 0px;
float:left;
width:100%; 
}
</style>
<portlet:renderURL var="backRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:renderURL var="viewPersonalDetailRenderURL">
<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS %>" />
</portlet:renderURL>
<div class="main-content id-box" style="margin-top: 0px;">
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
					<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_REGISTRATION_PERSONAL_DETAILS%>" var="savePDURL" />
					<form action="${savePDURL}" method="post" name="<portlet:namespace/>pdFM" id="pdFM" autocomplete="off" enctype="multipart/form-data">
						<div class="reg_step1" id="reg_step1">
							<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<div class="pagetitle"><liferay-ui:message key="registration-personal-details" /></div>
									<div class="information"><label class="reg-form-title"><liferay-ui:message key="step-1-of-4" /></label></div>
								</div>
							</div>
							<h3 class="reg-form-title"><liferay-ui:message key="personal-details" /></h3>
							<p id="errorContainer-user-exist" class="error-container"></p>
							<div class="row">
								<c:if test="${not empty person.civilId  || (themeDisplay.isSignedIn() && empty person.getId())}" >
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="omani-civil-id" /></label>
											<input type="text" name="<portlet:namespace/>civilId" id="civilId" value="${person.civilId}" class="form-control" <c:if test="${not empty person.civilId}" >readonly="readonly"</c:if> ${themeDisplay.isSignedIn()?"onkeyup='validate();'":"" } >
										</div>
										<p id="errorContainer-civilId" class="error-container"></p>
									</div>
								</c:if>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="date-of-birth" /></label>
										<input type="text" name="<portlet:namespace/>dateOfBirth" id="dateOfBirth" value="${person.dateOfBirth}" placeholder="<liferay-ui:message key="DD-MM-YYYY" />" class="form-control datePicker" <c:if test="${not empty person.dateOfBirth}" >readonly="readonly"</c:if> ${themeDisplay.isSignedIn()?"onchange='validate();'":"" }>
									</div>
									<p id="errorContainer-dateOfBirth" class="error-container"></p>
								</div>	
								<c:if test="${empty person.civilId && !themeDisplay.isSignedIn()}" >
									<div class="col-lg-6 col-md-6">
									</div>
								</c:if>
								<c:if test="${themeDisplay.isSignedIn() && not empty person.getId() && empty person.civilId}" >
									<div class="col-lg-6 col-md-6">
									</div>
								</c:if>
								
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label ${empty person.civilId && !themeDisplay.isSignedIn()?'required':''}"><liferay-ui:message key="passport-no" /></label>
										<input type="text" name="<portlet:namespace/>passportNumber" id="passportNumber" value="${person.passportNumber}" class="form-control" <c:if test="${not empty person.passportNumber && empty person.civilId}" >readonly="readonly"</c:if>  ${themeDisplay.isSignedIn() && empty person.getId()?"onkeyup='validate();'":"" } <%-- onkeyup="validateField(this.id,'errorContainer-passportNumber','<liferay-ui:message key="please-enter-passport-number" />')" --%>>
									</div>
									<p id="errorContainer-passportNumber" class="error-container"></p>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label ${not empty person.passportNumber && empty person.civilId?'required':''}"><liferay-ui:message key="country-of-issue" /></label>
										<select name="<portlet:namespace/>countryOfIssue" id="countryOfIssue" class="form-control" <c:if test="${not empty person.passportNumber && empty person.civilId }">onchange="validateField(this.id,'errorContainer-countryOfIssue','<liferay-ui:message key="please-select-country-of-issue" />')"</c:if><%-- onchange="validateField(this.id,'errorContainer-countryOfIssue','<liferay-ui:message key="please-select-country-of-issue" />')" --%>>
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="country" items="${countries}">
												<option value="${country.countryId}" <c:if test="${country.countryId == personalDetails.passportIssuingCountryId}">selected="selected"</c:if> >
													<liferay-ui:message key="${country.getName(themeDisplay.getLocale())}" />
												</option>	
											</c:forEach>
										</select>
									</div>
									<p id="errorContainer-countryOfIssue" class="error-container"></p>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label ${not empty person.passportNumber && empty person.civilId ?'required':''}"><liferay-ui:message key="date-of-exipry" /></label>
										<input type="text" name="<portlet:namespace/>passportExpiryDate" id="passportExpiryDate" value="${personalDetails.passportExpiryDate}" placeholder="<liferay-ui:message key="DD-MM-YYYY" />" class="form-control datePicker"  <c:if test="${not empty person.passportNumber && empty person.civilId }">onkeyup="validateField(this.id,'errorContainer-passportExpiryDate','<liferay-ui:message key="please-enter-passport-expiry-date" />')"</c:if>>
									</div>
									<p id="errorContainer-passportExpiryDate" class="error-container"></p>
								</div>
								
								<div class="col-lg-6 col-md-6">
									<c:if test="${(empty person.civilId && not empty person.passportNumber)}">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="first-name" /></label>
											<input type="text" name="<portlet:namespace/>firstName" id="firstName" value="${lrUser.firstName}"
											class="form-control"  onkeyup="validateField(this.id,'errorContainer-firstName','<liferay-ui:message key="please-enter-firstname" />')">
										</div>
										<p id="errorContainer-firstName" class="error-container"></p>
									</c:if>
									
								</div>
								<div class="col-lg-6 col-md-6">
									<c:if test="${(empty person.civilId && not empty person.passportNumber)}">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="family-name" /></label>
											<input type="text" name="<portlet:namespace/>lastName" id="lastName" value="${lrUser.lastName}" class="form-control"  onkeyup="validateField(this.id,'errorContainer-lastName','<liferay-ui:message key="please-enter-familyname" />')">
										</div>
											<p id="errorContainer-lastName" class="error-container"></p>
									</c:if>
								
								</div>
								
								<c:choose>
									<c:when test="${not empty person.civilId && not empty fullName}">
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name" /></label>
												<input type="text" name="<portlet:namespace/>fullName" id="fullName" value="${fullName}" class="form-control" readonly>
											</div>
											<p id="errorContainer-fullName" class="error-container"></p>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name-ar" /></label>
												<input type="text" name="<portlet:namespace/>fullNameAr" id="fullNameAr" value="${fullNameAr}" class="form-control" ${isPkiIdentified?"":"readonly" } >
											</div>
											<p id="errorContainer-fullName-ar" class="error-container"></p>
										</div>
									</c:when>
									<c:when test="${not empty lrUser.userId && not empty personalDetails.fullNameAr}">
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name" /></label>
												<input type="text" name="<portlet:namespace/>fullName" id="fullName" value="${lrUser.fullName}" class="form-control" readonly>
											</div>
											<p id="errorContainer-fullName" class="error-container"></p>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name-ar" /></label>
												<input type="text" name="<portlet:namespace/>fullNameAr" id="fullNameAr" value="${personalDetails.fullNameAr}" class="form-control" readonly>
											</div>
											<p id="errorContainer-fullName-ar" class="error-container"></p>
										</div>
									</c:when>
									<c:when test="${empty lrUser.userId && not empty personalDetails.id}">
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name" /></label>
												<input type="text" name="<portlet:namespace/>fullName" id="fullName" value="${personalDetails.givenNameAsPassport} ${personalDetails.applicantSurname}" class="form-control" >
											</div>
											<p id="errorContainer-fullName" class="error-container"></p>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name-ar" /></label>
												<input type="text" name="<portlet:namespace/>fullNameAr" id="fullNameAr" value="${personalDetails.fullNameAr}" class="form-control">
											</div>
											<p id="errorContainer-fullName-ar" class="error-container"></p>
										</div>
									</c:when>
									<c:when test="${not empty person.civilId}">
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name" /></label>
												<input type="text" name="<portlet:namespace/>fullName" id="fullName" class="form-control">
											</div>
											<p id="errorContainer-fullName" class="error-container"></p>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name-ar" /></label>
												<input type="text" name="<portlet:namespace/>fullNameAr" id="fullNameAr" class="form-control">
											</div>
											<p id="errorContainer-fullName-ar" class="error-container"></p>
										</div>
									</c:when>	
									<c:when test="${empty person.civilId && empty person.passportNumber && themeDisplay.isSignedIn() }">
									 	<div class="col-lg-6 col-md-6" id="civilid-full-name">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name" /></label>
												<input type="text" name="<portlet:namespace/>fullName" id="fullName" class="form-control">
											</div>
											<p id="errorContainer-fullName" class="error-container"></p>
										</div>
										<div class="col-lg-6 col-md-6 name-div" id="civilid-full-name-ar">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name-ar" /></label>
												<input type="text" name="<portlet:namespace/>fullNameAr" id="fullNameAr" class="form-control">
											</div>
											<p id="errorContainer-fullName-ar" class="error-container"></p>
										</div>
									</c:when>							
								</c:choose>
								
								 <div class="col-lg-6 col-md-6 d-none" id="civilid-first-div">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="first-name" /></label>
											<input type="text" name="<portlet:namespace/>firstName" id="firstName" value=""
											class="form-control"  onkeyup="validateField(this.id,'errorContainer-firstName','<liferay-ui:message key="please-enter-firstname" />')">
										</div>
									<p id="errorContainer-firstName" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6 d-none" id="civilid-family-div">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="family-name" /></label>
											<input type="text" name="<portlet:namespace/>lastName" id="lastName" value="" class="form-control"  onkeyup="validateField(this.id,'errorContainer-lastName','<liferay-ui:message key="please-enter-familyname" />')">
										</div>
									<p id="errorContainer-lastName" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="email" /></label>
										<div class="omsb-ilo-area">
											<input type="text" name="<portlet:namespace/>emailAddress" id="emailAddress" value="${personalDetails.email}" class="form-control" ${lrUser.emailAddressVerified?'readOnly':''} ${themeDisplay.isSignedIn()?"onkeyup='checkExistibility(this.id);'":"" }>
											<%-- <span class=""><button type="button" class="btn label-btn input-over-button" name="sendEmailOTP" onclick="sendVerificationOTP('emailAddress')" title="<liferay-ui:message key="send-otp" />" id="sendEmailOTP" ${lrUser.emailAddressVerified?'disabled':''} ><liferay-ui:message key="send-otp" /></button></span> --%>
											<c:if test="${!lrUser.emailAddressVerified && !themeDisplay.isSignedIn()}">
											<span class=""><button type="button" class="btn label-btn input-over-button" name="sendEmailOTP" onclick="sendVerificationOTP('emailAddress')" title="<liferay-ui:message key="send-otp" />" id="sendEmailOTP" ${lrUser.emailAddressVerified?'disabled':''} ><liferay-ui:message key="send-otp" /></button></span>
										    </c:if>
										</div>
									</div>
									<p id="errorContainer-emailAddress" class="error-container"></p>
								</div>
								<c:if test="${!lrUser.emailAddressVerified && !themeDisplay.isSignedIn()}">
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-8 col-md-8">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="email-otp" /></label>
												<input type="text" name="emailAddressOTP" id="emailAddressOTP" placeholder="_ _ _ _ _ _"
													class="form-control" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==6) return false;" ${lrUser.emailAddressVerified?'readOnly':''} >
											</div>
											<p id="errorContainer-emailAddressOTP" class="error-container"></p>
											
										</div>
										<div class="col-lg-4 col-md-4" >
											<div class="form-group">
												<label></label>
												<button type="button" class="btn omsb-bc-red-button" name="verifyEmailOTP" onclick="verifyOTP('emailAddress')" title="<liferay-ui:message key="verify-email" />" id="verifyEmailOTP" ${lrUser.emailAddressVerified?'disabled':''} ><liferay-ui:message key="verify-email" /></button>													
											    <div class="d-none success-tag" id="email-otp-success-div">
												  <img alt="" src="<%=themeDisplay.getPathThemeImages() %>/svg/success.svg">
											    </div>
											</div>
										</div>
									</div>
								</div>
								</c:if>
								<c:choose>
								<c:when test="${!isPkiIdentified}">
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="mobile" /></label>
										<div class="omsb-ilo-area">
											<input type="text" name="<portlet:namespace/>mobileNumber" id="mobileNumber" value="${personalDetails.mobileNumber}"
												class="form-control" ${personalDetails.mobileNumberVerified?'readOnly':''} pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==8) return false;" ${themeDisplay.isSignedIn()?"onkeyup='checkExistibility(this.id);'":"" }>
											<%-- <span class=""><button type="button" class="btn label-btn input-over-button" name="sendMobileOTP" onclick="sendVerificationOTP('mobileNumber')" title="<liferay-ui:message key="send-otp" />" id="sendMobileOTP" ${personalDetails.mobileNumberVerified?'disabled':''} ><liferay-ui:message key="send-otp" /></button></span> --%>
											<c:if test="${!personalDetails.mobileNumberVerified && !themeDisplay.isSignedIn()}">
												<span class=""><button type="button" class="btn label-btn input-over-button" name="sendMobileOTP" onclick="sendVerificationOTP('mobileNumber')" title="<liferay-ui:message key="send-otp" />" id="sendMobileOTP" ${personalDetails.mobileNumberVerified?'disabled':''} ><liferay-ui:message key="send-otp" /></button></span>
										    </c:if>
										</div>
										<p id="errorContainer-mobileNumber" class="error-container"></p>
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>mobileNumberOTPVerified" id="mobileNumberOTPVerified" value="${personalDetails.mobileNumberVerified}">
								<c:if test="${!personalDetails.mobileNumberVerified && !themeDisplay.isSignedIn()}">
								<div class="col-lg-6 col-md-6 ">
									<div class="row">
										<div class="col-lg-8 col-md-8">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="mobile-otp" /></label>
												<input type="text" name="mobileNumberOTP" id="mobileNumberOTP" placeholder="_ _ _ _ _ _"
													class="form-control" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==6) return false;" ${personalDetails.mobileNumberVerified?'readOnly':''} >
											</div>
											<p id="errorContainer-mobileNumberOTP" class="error-container"></p>
										</div>
										
										<div class="col-lg-4 col-md-3">
											<div class="form-group">
												<label></label>
												<button type="button" class="btn omsb-bc-red-button" name="verifyMobileOTP" onclick="verifyOTP('mobileNumber')" title="<liferay-ui:message key="verify-mobile" />" id="verifyMobileOTP" ${personalDetails.mobileNumberVerified?'disabled':''} ><liferay-ui:message key="verify-mobile" /></button>
											   <div class="d-none success-tag" id="mobile-otp-success-div">
												<img alt="" src="<%=themeDisplay.getPathThemeImages() %>/svg/success.svg">
										       </div>
											</div>
										</div>
									</div>
								</div>	
								</c:if>	
								</c:when>
								<c:otherwise>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="mobile" /></label>
										<div class="omsb-ilo-area">
											<input type="text" name="<portlet:namespace/>mobileNumber" id="mobileNumber" value="${mobileNo}"
												class="form-control" readonly >
										</div>
										<p id="errorContainer-mobileNumber" class="error-container"></p>
									</div>
									<div class="col-lg-6 col-md-6">
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>mobileNumberOTPVerified" id="mobileNumberOTPVerified" value="true">
								</c:otherwise>
								</c:choose>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="gender" /></label>
										<select name="<portlet:namespace/>gender" id="gender" class="form-control"  onchange="validateField(this.id,'errorContainer-gender','<liferay-ui:message key="please-select-gender" />')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="gender" items="${genderList}">
												<option value="${gender.genderMasterId}" <c:if test="${gender.genderMasterId == personalDetails.genderId || gender.genderMasterId == genderId}">selected="selected"</c:if> >
													<liferay-ui:message key="${gender.getGenderName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
									</div>
									<p id="errorContainer-gender" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="country-of-nationality" /></label>
										<select name="<portlet:namespace/>nationality" id="nationality" class="form-control"  onchange="validateField(this.id,'errorContainer-nationality','<liferay-ui:message key="please-select-nationality" />')">
											<option value=""><liferay-ui:message key="select" /></option>
											 <c:forEach var="country" items="${countries}">
												<option value="${country.countryId}" <c:if test="${country.countryId == personalDetails.nationalityCountryId || country.countryId == countryId}">selected="selected"</c:if> >
													<liferay-ui:message key="${country.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>	
									</div>
									<p id="errorContainer-nationality" class="error-container"></p>
								</div>								
								<div class="col-lg-12 col-md-12">
								<div class="row">
								 <div class="col-lg-10 col-md-10">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="personal-photo" /></label>
										<div class="custom-file">
											<input type="file" name="<portlet:namespace/>photo" id="photo" class="form-control custom-file-input" value="${photo}" onchange="validateFile(this.id,'errorContainer-photo','<liferay-ui:message key="please-select-image" />')">
											<label class="custom-file-label" for="photo">
												${photo}
											</label>
										</div>
									</div>
									<p id="errorContainer-photo" class="error-container"></p>
								</div>
									<div class="col-lg-2 col-md-2">
														<div class="form-group">
														<label class="control-label"></label>
													    <c:if test="${ not empty photoURL}">
														<a href="${photoURL}" class="btn view_btn text-danger" target="_blank"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="view" />
									                    </a>
													</c:if>
									</div>				
								 </div>
								</div>
								</div>	
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="profession" /></label>
										<select name="<portlet:namespace/>profession" id="profession" class="form-control"  onchange="showOtherField(this.id,'errorContainer-profession','<liferay-ui:message key="please-select-profession" />');setPrimarySpecialty()">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="profession" items="${professionList}">
												<option value="${profession.listTypeEntryId}" <c:if test="${profession.listTypeEntryId == personalDetails.profession}">selected="selected"</c:if> >
													<liferay-ui:message key="${profession.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
									</div>
									<p id="errorContainer-profession" class="error-container"></p>
								</div>
								<div class="col-lg-4 col-md-6 d-none" id="professionOtherDiv">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="profession-other" /></label>
										<input  type="text" name="<portlet:namespace/>professionOther" id="professionOther" class="form-control" value="${professionOther}" >
									</div>
									<p id="errorContainer-profession" class="error-container"></p>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="primary-speciality" /></label>
										<select name="<portlet:namespace/>primarySpeciality" id="primarySpeciality" class="form-control" onchange="showOtherField(this.id,'errorContainer-primarySpeciality','<liferay-ui:message key="please-select-primary-speciality" />');setSecondarySpeciality()" >
											<option value=""><liferay-ui:message key="select" /></option>
											<%-- <c:forEach var="primSpec" items="${specialityList}">
												<option value="${primSpec.listTypeEntryId}" <c:if test="${primSpec.listTypeEntryId == personalDetails.primarySpeciality}">selected="selected"</c:if> >
													<liferay-ui:message key="${primSpec.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach> --%>
										</select>
									</div>
									<p id="errorContainer-primarySpeciality" class="error-container"></p>
								</div>
								
								<div class="col-lg-4 col-md-6 d-none" id="primarySpecialityOtherDiv">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="primarySpeciality-other" /></label>
										<input type="text" name="<portlet:namespace/>primarySpecialityOther" id="primarySpecialityOther" class="form-control" value="${primarySpecialityOther}" <%-- onchange="validateFile(this.id,'errorContainer-photo','<liferay-ui:message key="please-select-image" />')" --%>>
									</div>
									<p id="errorContainer-profession" class="error-container"></p>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="secondary-speciality" /></label>
										<select name="<portlet:namespace/>secondarySpeciality" id="secondarySpeciality" class="form-control" onchange="showOtherField(this.id,'errorContainer-secondarySpeciality','<liferay-ui:message key="please-select-secondary-speciality" />')">
											<option value=""><liferay-ui:message key="select" /></option>
										</select>
									</div>
									<p id="errorContainer-secondarySpeciality" class="error-container"></p>
								</div>
								<div class="col-lg-4 col-md-6 d-none" id="secondarySpecialityOtherDiv">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="secondarySpeciality-other" /></label>
										<input class="d-none" type="hidden" name="<portlet:namespace/>secondarySpecialityOther" id="secondarySpecialityOther" class="form-control " value="${secondarySpecialityOther}" <%-- onchange="validateFile(this.id,'errorContainer-photo','<liferay-ui:message key="please-select-image" />')" --%>>
									</div>
									<p id="errorContainer-profession" class="error-container"></p>
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input type="hidden" name="<portlet:namespace/>userNameValid" id="userNameValid" value="false">
								<input type="hidden" name="<portlet:namespace/>emailAddressOTPVerified" id="emailAddressOTPVerified" value="${lrUser.emailAddressVerified}">
								<input type="hidden" name="<portlet:namespace/>personId" id="personId" value="${person.id}">
								<input type="hidden" name="<portlet:namespace/>userId" id="userId" value="${lrUser.userId}">
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="username" /></label>
										<c:choose>
											<c:when test="${not empty lrUser.screenName}">
												<input type="text" name="<portlet:namespace/>userName" id="userName" class="form-control" value="${lrUser.screenName}" readonly="readonly">
											</c:when>
											<c:when test="${not empty person.civilId}">
												<input type="text" name="<portlet:namespace/>userName" id="userName" class="form-control" value="${person.civilId}" readonly="readonly" >
											</c:when>
											<c:otherwise>
												<input type="text" name="<portlet:namespace/>userName" id="userName" class="form-control" onblur="verifyScreenname()" >
											</c:otherwise>
										</c:choose>
									</div>
									<p id="errorContainer-userName" class="error-container"></p>
								</div>
								<c:if test="${empty lrUser && !themeDisplay.isSignedIn()}">
									<div class="col-lg-4 col-md-6">
										<div class="form-group">
											 <div class="d-flex align-items-center"><label class="control-label required" style="width: auto;"><liferay-ui:message key="create-password" /></label><div class="tooltipp"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" class="tooltipp" ><div class="tooltiptext"><ul class="cst_ul"><li><liferay-ui:message key="password-length-message" /></li><li><liferay-ui:message key="upper-case-message" /> </li><li><liferay-ui:message key="lower-case-message" /> </li><li><liferay-ui:message key="special-character-message" /> </li><li><liferay-ui:message key="digit-message" /></li></ul></div></div></div>
											<input type="password" name="<portlet:namespace/>password" id="password" value="" class="form-control" onkeyup="validatePassword(this.id);">
										</div>
										<p id="errorContainer-password" class="error-container"></p>
									</div>
									<div class="col-lg-4 col-md-6">
										<div class="form-group">
											 <label class="control-label required"><liferay-ui:message key="re-type-password" /></label>									
											<input type="password" name="<portlet:namespace/>reTypePassword" id="reTypePassword" class="form-control" onkeyup="validateRePassword(this.id);" >
										</div>
										<p id="errorContainer-reTypePassword" class="error-container"></p>
									</div>
								</c:if>
							</div>
							<div class="bottom-backbtn-wrap">
								<button onClick="validateAndSaveFormData('save')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="save-at-this-stage" />"><liferay-ui:message key="save-at-this-stage" /></button>
								<button onClick="validateAndSaveFormData('next')" class="go-next btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="next" />" ><liferay-ui:message key="next" /></button>
								<%-- <a class="btn omsb-btn btn-back" href="${backRenderURL }"><liferay-ui:message key="cancel" /></a> --%>
								
								<button type="button" class="btn omsb-btn btn-back" data-toggle="modal" data-target="#conformationPopUp"><liferay-ui:message key="cancel" /></button>
								
							</div>
						</div>
	 		 	 	<input type="hidden" name="<portlet:namespace />countryCode" id="hiddenCountryCode" value="${personalDetails.countryCode}" />
						<input type="hidden" name="<portlet:namespace />countryIsoCode" id="hiddenCountryIsoCode" value="${personalDetails.countryIsoCode}" />  
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="confirmationPopUp.jsp"%>
<liferay-ui:success key="success-personal-detail" message="personal-detail-successfully-added" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_USERNAME%>" var="verifyUsernameURL" />
<portlet:resourceURL id="<%=MVCCommands.SEND_OTP%>" var="sendOTPURL" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_OTP%>" var="verifyOTPURL" />
<portlet:resourceURL id="<%=MVCCommands.SPECIALITY_AND_SUBSPECIALITY_MVC_RESOURCE%>" var="specialityListURL" />	
<portlet:resourceURL id="<%=MVCCommands.FETCH_SPECIALITY_BY_PROFESSION%>" var="professionListURL" />	
<portlet:resourceURL id="<%=MVCCommands.VERIFY_CIVILID_PASSPORT%>" var="verifyCivilPassportURL" />
<script type="text/javascript">


   var phone1 = document.querySelector("#mobileNumber");
var hiddenCountryInput = document.querySelector("#hiddenCountryCode");
var hiddenCountryIsoCode = document.querySelector("#hiddenCountryIsoCode");
var itl = '';

console.log("hiddenCountryIsoCode ::::",hiddenCountryIsoCode.value);

 var initialCountryVal="om";
if(hiddenCountryIsoCode.value!=''){
	console.log("inside in ::::;");
	initialCountryVal=hiddenCountryIsoCode.value;
}


setTimeout(function() {
	itl = window.intlTelInput(phone1,({initialCountry:initialCountryVal, separateDialCode: "true", showFlags:"false"}));
	var selectedCountry = itl.getSelectedCountryData();
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
	
}, 100);




phone1.addEventListener("countrychange",function() {
	var selectedCountry = itl.getSelectedCountryData();
	console.log("selectedCountry :::",selectedCountry);
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
});

var isLogin="${themeDisplay.isSignedIn()}";
$(document).ready(function() {
	
	 $("#countryOfIssue").select2();
	 $("#nationality").select2();
	 $("#profession").select2();
	 $("#primarySpeciality").select2();
	 $("#secondarySpeciality").select2();
	 
	
	 
	console.log('${isPkiIdentified}');
	if(${not empty person.civilId && empty lrUser.screenName}){
		verifyScreenname();
		var userNameValid=$("#userNameValid").val();
		console.log("userNameValid "+userNameValid);
		if(userNameValid=='true'){
			$(".omsb-bc-red-button").removeAttr('disabled');
		} else {
			$(".omsb-bc-red-button").attr("disabled", true);	
		}
	}
	var dateOfBirthVal = '${empty person.dateOfBirth}';
	if(dateOfBirthVal=='true'){
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
		    	$(this).val('');
		    }
		}
		$('.datepicker').hide();
	});
	
	$("#mobileNumber").keypress(function (e) {    
        var charCode = (e.which) ? e.which : event.keyCode    
        if (String.fromCharCode(charCode).match(/[^0-9]/g)){
        	return false;
        }    

    });
	//setSecondarySpeciality();
	setPrimarySpecialty();
	setSecondarySpeciality();
});

function showOtherField(id,errorId,errorMessage){
	 console.log(id);
	 var substring=substring=id;
	
	 let selectedValue= $("#"+id).find('option:selected').val();
	 
	 console.log(selectedValue);
	 
	 if(selectedValue.trim() === 'other'){
		 console.log('#'+id+"otherDiv");
		 $('#'+id+"OtherDiv").removeClass('d-none');
	 }
	 else{
		 $('#'+id+"OtherDiv").addClass('d-none');
		}
	 validateField(id,errorId,errorMessage);
	
	 
}

function isValidVerificationField(verificationTypeField){
   if(isLogin=="false"){
	document.getElementById("errorContainer-emailAddress").textContent = "";
	document.getElementById("errorContainer-mobileNumber").textContent = "";
   }
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
			document.getElementById("errorContainer-mobileNumber").textContent = "";
			if (mobileNumber.length>8) {
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

function sendVerificationOTP(verificationTypeField){
	
	if(isValidVerificationField(verificationTypeField)){
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
				console.log(response);
				console.log("-----");
				var message="";
				if(response.isValid){
					document.getElementById(verificationTypeField).setAttribute('readonly','readonly');
					
					if(verificationTypeField=="emailAddress"){
					message="<liferay-ui:message key='enter-otp-sent-email' />";
					  }
					else{
						message="<liferay-ui:message key='enter-otp-sent-mobile' />";
					}
				} else {
					if(verificationTypeField=="emailAddress"){
						message= '<liferay-ui:message key="emailAddress-already-exist" />';
					      }
					else{
						message='<liferay-ui:message key="mobileNumber-already-exist" />';
					}
					}	
				document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = message;
			}
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
				//	document.getElementById("errorContainer-"+verificationType+"OTP").textContent = "<liferay-ui:message key='otp-verified-successfully' />";
					document.getElementById(verificationType).setAttribute('readonly','readonly');
					document.getElementById(verificationType+"OTP").setAttribute('readonly','readonly');
					if(verificationType=="mobileNumber"){
						$("#verifyMobileOTP").addClass("d-none");	
						$("#sendMobileOTP").addClass("d-none");	
						$("#mobile-otp-success-div").removeClass("d-none");
					}
					else{
						$("#verifyEmailOTP").addClass("d-none");	
						$("#sendEmailOTP").addClass("d-none");	
						$("#email-otp-success-div").removeClass("d-none");
					}
					
					
				} else {
					document.getElementById(verificationType+"OTPVerified").value = "false";
					document.getElementById("errorContainer-"+verificationType+"OTP").textContent = "<liferay-ui:message key='invalid-otp' />";
					document.getElementById(verificationType).removeAttribute('readonly');
					document.getElementById(verificationType+"OTP").removeAttribute('readonly');
					if(verificationType=="mobileNumber"){
						$("#verifyMobileOTP").removeClass("d-none");
						$("#sendMobileOTP").removeClass("d-none");	
						$("#mobile-otp-success-div").addClass("d-none");
					}
					else{
						$("#verifyEmailOTP").removeClass("d-none");	
						$("#sendEmailOTP").removeClass("d-none");
						$("#email-otp-success-div").addClass("d-none");
					}
				}
			},
		})
	}
}

function validateAndSaveFormData(button) {
	
	var errorMessages = [];
	var civilId = '${empty person.civilId}';
	/* if(civilId=='true'){
		var passportNumber = document.getElementById("passportNumber").value;
		if (!passportNumber) {
			errorMessages.push("<liferay-ui:message key='please-enter-passport-number' />");
			document.getElementById("errorContainer-passportNumber").textContent = "<liferay-ui:message key='please-enter-passport-number' />";
		} else {
			document.getElementById("errorContainer-passportNumber").textContent = "";
		}
	} */
	
	/*------validation on enter passport no--------  */
	if(civilId=='false' || isLogin=="true"){
		var passportNumber = document.getElementById("passportNumber").value;
		if (passportNumber) {
			var countryOfIssue = document.getElementById("countryOfIssue").value;
			if (!countryOfIssue) {
				errorMessages.push("<liferay-ui:message key='please-select-country-of-issue' />");
				document.getElementById("errorContainer-countryOfIssue").textContent = "<liferay-ui:message key='please-select-country-of-issue' />";
			} else {
				document.getElementById("errorContainer-countryOfIssue").textContent = "";
			}
			var passportExpiryDate = document.getElementById("passportExpiryDate").value;
			if (!passportExpiryDate) {
				errorMessages.push("<liferay-ui:message key='please-enter-passport-expiry-date' />");
				document.getElementById("errorContainer-passportExpiryDate").textContent = "<liferay-ui:message key='please-enter-passport-expiry-date' />";
			} else {
				document.getElementById("errorContainer-passportExpiryDate").textContent = "";
			}
			
		} else {
			document.getElementById("errorContainer-passportExpiryDate").textContent = "";
			document.getElementById("errorContainer-countryOfIssue").textContent = "";
		}
	}
	 if(isLogin=="true" && civilId=="true" && ${empty person.passportNumber}){
		 var civilIdValue = document.getElementById("civilId").value;
		 var passportNumber = document.getElementById("passportNumber").value;
		 var dateOfBirth = document.getElementById("dateOfBirth").value;
		 if(!civilIdValue && !passportNumber){
			 errorMessages.push("<liferay-ui:message key='please-select-civilId-or-passportNo' />");
			 document.getElementById("errorContainer-civilId").textContent = "<liferay-ui:message key='please-select-civilId-or-passportNo' />";			 
		 }
		 else{
			 document.getElementById("errorContainer-civilId").textContent = "";			 
		 }		 
		 if(!dateOfBirth){
			 errorMessages.push("<liferay-ui:message key='please-select-dateOfBirth' />");
			 document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='please-select-dateOfBirth' />";	 
		 }
		 else{
			 var dobVal=$('#dateOfBirth').val();
				console.log("dobVal ::::",dobVal);
				var chunks = dobVal.split('-');
				var formattedDate = chunks[1]+'-'+chunks[0]+'-'+chunks[2];
				var today = new Date();
				var birthDate = new Date(formattedDate);
				var age = today.getFullYear() - birthDate.getFullYear();
				if (age > 18+1) {
					document.getElementById("errorContainer-dateOfBirth").textContent = "";
				//	return true; 
				}else{
					errorMessages.push("<liferay-ui:message key='age-error' />");
					document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='age-error' />";
					//return false;
				} 
			// document.getElementById("errorContainer-dateOfBirth").textContent = "";	 
		 }
		 if(civilIdValue){
		 var fullName = document.getElementById("fullName").value;
		 if(!fullName){
			 errorMessages.push("<liferay-ui:message key='please-enter-fullName' />");
			 document.getElementById("errorContainer-fullName").textContent = "<liferay-ui:message key='please-enter-fullName' />";
		 }
		 else{
			 document.getElementById("errorContainer-fullName").textContent = ""; 
		 }
		 var fullNameAr = document.getElementById("fullNameAr").value;
		 if(!fullNameAr){
			 errorMessages.push("<liferay-ui:message key='please-enter-fullName-ar' />");
			 document.getElementById("errorContainer-fullName-ar").textContent = "<liferay-ui:message key='please-enter-fullName-ar' />";
		 }
		 else{
			 document.getElementById("errorContainer-fullName-ar").textContent = ""; 
		 }
		 }
		 else if(passportNumber){
			 var firstName = document.getElementById("firstName").value;
			 if(!firstName){
				 errorMessages.push("<liferay-ui:message key='please-enter-firstName' />");
				 document.getElementById("errorContainer-firstName").textContent = "<liferay-ui:message key='please-enter-firstName' />";
			 }
			 else{
				 document.getElementById("errorContainer-firstName").textContent = "";
			 }
			 
			 var familyName = document.getElementById("lastName").value;	
			 if(!familyName){
				 errorMessages.push("<liferay-ui:message key='please-enter-familyName' />");
				 document.getElementById("errorContainer-lastName").textContent = "<liferay-ui:message key='please-enter-familyName' />";
			 }
			 else{
				 document.getElementById("errorContainer-lastName").textContent = "";
			 }
		 }
	 }
	 	
	/*-----------------  */
	var isPassportId = '${empty person.civilId && not empty person.passportNumber}';	
	if(isPassportId=='true'){
		var countryOfIssue = document.getElementById("countryOfIssue").value;
		if (!countryOfIssue) {
			errorMessages.push("<liferay-ui:message key='please-select-country-of-issue' />");
			document.getElementById("errorContainer-countryOfIssue").textContent = "<liferay-ui:message key='please-select-country-of-issue' />";
		} else {
			document.getElementById("errorContainer-countryOfIssue").textContent = "";
		}
	}
	
	if(isPassportId=='true'){
		var passportExpiryDate = document.getElementById("passportExpiryDate").value;
		if (!passportExpiryDate) {
			errorMessages.push("<liferay-ui:message key='please-enter-passport-expiry-date' />");
			document.getElementById("errorContainer-passportExpiryDate").textContent = "<liferay-ui:message key='please-enter-passport-expiry-date' />";
		} else {
			document.getElementById("errorContainer-passportExpiryDate").textContent = "";
		}
	}

	var isCivilId = '${not empty person.civilId}';	
/* 	var isCivilId = '${not empty person.civilId && empty person.passportNumber}';	 */
	if(isCivilId=='true' && isLogin=="false"){	
		var fullName = document.getElementById("fullName").value;	
		if (!fullName) {	
			errorMessages.push("<liferay-ui:message key='please-enter-fullName' />");	
			document.getElementById("errorContainer-fullName").textContent = "<liferay-ui:message key='please-enter-fullName' />";	
		} else {	
			document.getElementById("errorContainer-fullName").textContent = "";	
		}	
		
		var fullNameAr = document.getElementById("fullNameAr").value;
		if (!fullName) {	
			errorMessages.push("<liferay-ui:message key='please-enter-fullName-ar' />");	
			document.getElementById("errorContainer-fullName-ar").textContent = "<liferay-ui:message key='please-enter-fullName-ar' />";	
		} else {	
			document.getElementById("errorContainer-fullName-ar").textContent = "";	
		}	
	}
	if(isPassportId=='true'){	
		var firstName = document.getElementById("firstName").value;	
		if (!firstName) {	
			errorMessages.push("<liferay-ui:message key='please-enter-firstname' />");	
			document.getElementById("errorContainer-firstName").textContent = "<liferay-ui:message key='please-enter-firstname' />";	
		} else {	
			document.getElementById("errorContainer-firstName").textContent = "";	
		}	
		
		var lastName = document.getElementById("lastName").value;	
		if (!lastName) {
			errorMessages.push("<liferay-ui:message key='please-enter-lastname' />");	
			document.getElementById("errorContainer-lastName").textContent = "<liferay-ui:message key='please-enter-lastname' />";	
		} else {	
			document.getElementById("errorContainer-lastName").textContent = "";	
		}
	}
	if(${!lrUser.emailAddressVerified}){
	var emailAddress = document.getElementById("emailAddress").value;
	if (!emailAddress) {
		errorMessages.push("<liferay-ui:message key='please-enter-email-address' />");
		document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-email-address' />";
	} else {
		document.getElementById("errorContainer-emailAddress").textContent = "";
		let regex = /^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
        if (!regex.test(emailAddress)) {
			errorMessages.push("<liferay-ui:message key='please-enter-valid-email-address' />");
			document.getElementById("errorContainer-emailAddress").textContent = "<liferay-ui:message key='please-enter-valid-email-address' />";
		} else {
			document.getElementById("errorContainer-emailAddress").textContent = "";
			if(isLogin=="false"){
			var emailAddressOTPVerified = document.getElementById("emailAddressOTPVerified").value;
			if (emailAddressOTPVerified=='false' || emailAddressOTPVerified==''){
				errorMessages.push("<liferay-ui:message key='please-verify-email-address' />");
				document.getElementById("errorContainer-emailAddressOTP").textContent = "<liferay-ui:message key='please-verify-email-address' />";
			} else {
				document.getElementById("errorContainer-emailAddressOTP").textContent = "";
			}
			}
		}
	}
	}
	if(${!personalDetails.mobileNumberVerified}){
	var mobileNumber = document.getElementById("mobileNumber").value;
	if (!mobileNumber) {
		errorMessages.push("<liferay-ui:message key='please-enter-mobile-number' />");
		document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-mobile-number' />";
	} else {
		document.getElementById("errorContainer-mobileNumber").textContent = "";
		if (mobileNumber.length>8) {
			errorMessages.push("<liferay-ui:message key='please-enter-valid-mobile-number' />");
			document.getElementById("errorContainer-mobileNumber").textContent = "<liferay-ui:message key='please-enter-valid-mobile-number' />";
		} else {
			document.getElementById("errorContainer-mobileNumber").textContent = "";
			if(isLogin=="false" && ${!isPkiIdentified}){
			var mobileNumberOTPVerified = document.getElementById("mobileNumberOTPVerified").value;
			if (mobileNumberOTPVerified=='false' || mobileNumberOTPVerified==''){
				errorMessages.push("<liferay-ui:message key='please-verify-mobile-number' />");
				document.getElementById("errorContainer-mobileNumberOTP").textContent = "<liferay-ui:message key='please-verify-mobile-number' />";
			} else {
				document.getElementById("errorContainer-mobileNumberOTP").textContent = "";
			}
			}
		}
	}
	}
	var gender = document.getElementById("gender").value;
	if (!gender) {
		errorMessages.push("<liferay-ui:message key='please-select-gender' />");
		document.getElementById("errorContainer-gender").textContent = "<liferay-ui:message key='please-select-gender' />";
	} else {
		document.getElementById("errorContainer-gender").textContent = "";
	}
	
	var nationality = document.getElementById("nationality").value;
	if (!nationality) {
		errorMessages.push("<liferay-ui:message key='please-select-nationality' />");
		document.getElementById("errorContainer-nationality").textContent = "<liferay-ui:message key='please-select-nationality' />";
	} else {
		document.getElementById("errorContainer-nationality").textContent = "";
	}
	var portraitId = '${empty lrUser.portraitId}';
	var photo = document.getElementById("photo").files[0];	
		if (!photo ) {
			if(portraitId=='true'){
			errorMessages.push("<liferay-ui:message key='please-upload-photo' />");
			document.getElementById("errorContainer-photo").textContent = "<liferay-ui:message key='please-upload-photo' />";
			}
		} else {
			var photoName=photo.name;
			var ext = photoName.substr(photoName.lastIndexOf("."));
			console.log(photoName);
		  var allowedExtReg = /(\.jpg|\.jpeg|\.png)$/i;
		  var allowed=allowedExtReg.test(ext);
		  if(allowed){
			document.getElementById("errorContainer-photo").textContent = "";			
			const size = (photo.size / 1024 / 1024).toFixed(2);
			if (size > 1) {
				errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
				document.getElementById("errorContainer-photo").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
            } else {
            	document.getElementById("errorContainer-photo").textContent = "";
            }
		} else{
	    	 document.getElementById("errorContainer-photo").textContent = "";
	    	 document.getElementById("errorContainer-photo").textContent ="<liferay-ui:message key='please-select-image' />";
	    	 errorMessages.push("<liferay-ui:message key='please-select-image' />");
	     }
	}
	var profession = document.getElementById("profession").value;
	if (!profession) {
		errorMessages.push("<liferay-ui:message key='please-select-profession' />");
		document.getElementById("errorContainer-profession").textContent = "<liferay-ui:message key='please-select-profession' />";
	} else {
		document.getElementById("errorContainer-profession").textContent = "";
	}
	
	var primarySpeciality = document.getElementById("primarySpeciality").value;
	if (!primarySpeciality) {
		errorMessages.push("<liferay-ui:message key='please-select-primary-speciality' />");
		document.getElementById("errorContainer-primarySpeciality").textContent = "<liferay-ui:message key='please-select-primary-speciality' />";
	} else {
		document.getElementById("errorContainer-primarySpeciality").textContent = "";
	}
	var secondarySpeciality = document.getElementById("secondarySpeciality").value;
	if (!secondarySpeciality) {
		errorMessages.push("<liferay-ui:message key='please-select-secondary-speciality' />");
		document.getElementById("errorContainer-secondarySpeciality").textContent = "<liferay-ui:message key='please-select-secondary-speciality' />";
	} else {
		document.getElementById("errorContainer-secondarySpeciality").textContent = "";
	}

	var screenName = '${empty lrUser.screenName}';
	
	//if(screenName=='true'){
		var userName = document.getElementById("userName").value;
		if (!userName) {
			errorMessages.push("<liferay-ui:message key='please-enter-username' />");
			document.getElementById("errorContainer-userName").textContent = "<liferay-ui:message key='please-enter-username' />";
		} else {
			
			document.getElementById("errorContainer-userName").textContent = "";
			/* if(civilId == 'true'){
				var userNameValid = document.getElementById("userNameValid").value;
				if (userNameValid=='false') {
					errorMessages.push("<liferay-ui:message key='please-enter-valid-username' />");
					document.getElementById("errorContainer-userName").textContent = "<liferay-ui:message key='please-enter-valid-username' />";
				} else {
					document.getElementById("errorContainer-userName").textContent = "";
				}
			} */
			
		}
	//}
	
		if(${not empty person.civilId && empty lrUser.screenName}){
			var userNameValid=$("#userNameValid").val();
			console.log("userNameValid "+userNameValid);
			if(userNameValid=='false'){
				errorMessages.push("<liferay-ui:message key='username-already-taken' />");
				document.getElementById("errorContainer-userName").textContent = '<liferay-ui:message key="username-already-taken" />';
				
			}
			else{
				document.getElementById("errorContainer-userName").textContent = '';
			}
		}
	
	var userId = '${empty lrUser.userId}';
	if(userId=='true' && !$(themeDisplay.isSignedIn())){	
		var password = document.getElementById("password").value;
		var passw= /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{7,19}$/;
		if (!password) {
			errorMessages.push("<liferay-ui:message key='please-enter-password' />");
			document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='please-enter-password' />";
		}else if(password.length<8){
			errorMessages.push("<liferay-ui:message key='password-length-error' />");
			document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='password-length-error' />";
		}else if(!password.match(passw)){
			errorMessages.push("<liferay-ui:message key='password-regular-expression-error' />");
			document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='password-regular-expression-error' />";
		} else {
			document.getElementById("errorContainer-password").textContent = "";
		}
		
		var reTypePassword = document.getElementById("reTypePassword").value;
		if (!reTypePassword) {
			errorMessages.push("<liferay-ui:message key='please-enter-retype-password' />");
			document.getElementById("errorContainer-reTypePassword").textContent = "<liferay-ui:message key='please-enter-retype-password' />";
		} else {
			document.getElementById("errorContainer-reTypePassword").textContent = "";
			if (password === reTypePassword) {
				document.getElementById("errorContainer-reTypePassword").textContent = "";
			} else {
				errorMessages.push("<liferay-ui:message key='retype-password-does-not-match-with-password' />");
				document.getElementById("errorContainer-reTypePassword").textContent = "<liferay-ui:message key='retype-password-does-not-match-with-password' />";
			}
		}
	}

	if (errorMessages.length > 0) {
		event.preventDefault();
	} else {
		if(button=='next'){
			document.getElementById("isNext").value = "true";
		}
		document.getElementById("pdFM").submit();
	}
}

function verifyScreenname(){
	console.log("verifyScreenname called:::");
	var inputVal = $("#userName").val().trim();
	if(inputVal ){
		document.getElementById("errorContainer-userName").textContent = "";
		$.ajax({
			url: '${verifyUsernameURL}',
			async : false,
			data : {
				<portlet:namespace />inputVal : inputVal
			},
			type : 'POST',
			success : function(data) {
				console.log("data :::",data);
				const response = JSON.parse(data);
				if(response.isValid){
					document.getElementById("userName").value = inputVal;
					document.getElementById("userNameValid").value = "true";
				} else if(response.message=="username-already-taken") {
					document.getElementById("errorContainer-userName").textContent = '<liferay-ui:message key="username-already-taken" />';
					document.getElementById("userNameValid").value = "false";
					document.getElementById("userName").removeAttribute("readonly");
				} else if(response.message=="invalid-username") {
					document.getElementById("errorContainer-userName").textContent = '<liferay-ui:message key="invalid-username" />';
					document.getElementById("userNameValid").value = "false";
					document.getElementById("userName").removeAttribute("readonly");
				}
			},
		})
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

$(document).on('change','.custom-file-input', function () {
	var fileName = $(this).val().split("\\").pop();
	
	console.log("fileName ::::",fileName);
	$(this).siblings(".custom-file-label").html(fileName);
});

function validateField(elementId,errorId,error){
	var fieldValue=$("#"+elementId).val();
	console.log(elementId+" ---  "+errorId+ " --- "+error);
	if(fieldValue==''){
		$("#"+errorId).text(error);
	}
	else{
		$("#"+errorId).html("");
	}
}
function validateFile(id,errorId,errorMessage){
   
	var filename = document.getElementById(id).files[0].name;
    var extension = filename.substr(filename.lastIndexOf("."));
    var allowedExtensionsReg = /(\.jpg|\.jpeg|\.png)$/i;
    var isAllowed = allowedExtensionsReg.test(extension);

	if(isAllowed){
		$("#"+errorId).html("");
    }else{
   		$("#"+errorId).text(errorMessage);
    }
}
function validate() {
	let isValid = false;
	console.log("inside validate function");
	  if(isLogin){	
		  var civilId = document.getElementById('civilId').value;
		  var dateOfBirth = document.getElementById('dateOfBirth').value;
		  var passportNumber = document.getElementById('passportNumber').value;
		 if(civilId && dateOfBirth || passportNumber && dateOfBirth){
				 isValid = true;
				 var status=checkPersonExist(civilId,dateOfBirth,passportNumber);
				 
		}
		if(passportNumber){
			 $("#civilid-full-name").addClass("d-none");
			 $("#civilid-full-name-ar").addClass("d-none");
			 $("#civilid-first-div").removeClass("d-none");
			 $("#civilid-family-div").removeClass("d-none");
		 }
		if(civilId){
			 $("#civilid-full-name").removeClass("d-none");
			 $("#civilid-full-name-ar").removeClass("d-none");
			 $("#civilid-first-div").addClass("d-none");
			 $("#civilid-family-div").addClass("d-none");
		}
		if(dateOfBirth){
			validateDateOfBirth();
		 }
		else{
				 document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='please-select-dateOfBirth' />";	 
			 }
		}

		 
	//  }
}
function checkPersonExist(civilId,dateOfBirth,passportNumber){
	var isExist=false;
		$.ajax({
			url: '${verifyCivilPassportURL}',
			async : false,
			data : {
				<portlet:namespace />civilId : civilId,
				<portlet:namespace />dateOfBirth : dateOfBirth,
				<portlet:namespace />passportNumber : passportNumber
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				var isPersonIdExist=response.hasOwnProperty("personId");
				if(response.isExist){
					document.getElementById("errorContainer-user-exist").textContent = '<liferay-ui:message key="user-already-exist" />';
					 $('.omsb-bc-red-button').attr("disabled", true);
					isExist=true;
				} else if(!response.isExist && !isPersonIdExist){
					document.getElementById("errorContainer-user-exist").textContent = '';
					$('.omsb-bc-red-button').attr("disabled", false);
			
				}
				else if(!response.isExist && isPersonIdExist){
					var personId=response.personId;
				   $('.omsb-bc-red-button').attr("disabled", false);
				   location.href="<%=viewPersonalDetailRenderURL%>&<portlet:namespace/>personId="+personId;
				}
			},
		})
		return isExist;

}
function validatePassword(id){
	var password = document.getElementById(id).value;
	//var passw= /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{7,19}$/;
	var passw=/^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,}$/;
	if (!password) {
		document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='please-enter-password' />";
	}else if(password.length<8){
		document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='password-length-error' />";
	}else if(!password.match(passw)){
		document.getElementById("errorContainer-password").textContent = "<liferay-ui:message key='password-regular-expression-error' />";
	} else {
		document.getElementById("errorContainer-password").textContent = "";
	}
}

function validateRePassword(id){
	var reTypePassword = document.getElementById("reTypePassword").value;
	if (!reTypePassword) {
		document.getElementById("errorContainer-reTypePassword").textContent = "<liferay-ui:message key='please-enter-retype-password' />";
	} else {
		document.getElementById("errorContainer-reTypePassword").textContent = "";
		var password = document.getElementById("password").value;
		if (password === reTypePassword) {
			document.getElementById("errorContainer-reTypePassword").textContent = "";
		} else {
			document.getElementById("errorContainer-reTypePassword").textContent = "<liferay-ui:message key='retype-password-does-not-match-with-password' />";
		}
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
				<portlet:namespace />inputVal : inputVal
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				console.log(response);
				console.log("-----");
			 	console.log(!response.isValid);
				//if(!response.isValid){
					if(verificationTypeField=="emailAddress"){
						if(!response.isValid){
						document.getElementById("errorContainer-"+verificationTypeField).textContent = '<liferay-ui:message key="emailAddress-already-exist" />';
						$('.omsb-bc-red-button').attr("disabled", true);  
						}
						else{
							document.getElementById("errorContainer-"+verificationTypeField).textContent = '';
							$('.omsb-bc-red-button').attr("disabled", false);
						}	
					}
						else if(verificationTypeField=="mobileNumber"){
							if(!response.isValid){
								document.getElementById("errorContainer-"+verificationTypeField).textContent = '<liferay-ui:message key="mobileNumber-already-exist" />';
								$('.omsb-bc-red-button').attr("disabled", true);
							}
							else{
								document.getElementById("errorContainer-"+verificationTypeField).textContent = '';
								$('.omsb-bc-red-button').attr("disabled", false);
							}
						} 			
			}
		});
	}
}
function validateDateOfBirth() {
	var dobVal=$('#dateOfBirth').val();
	var chunks = dobVal.split('-');
	var formattedDate = chunks[1]+'-'+chunks[0]+'-'+chunks[2];
	console.log("formattedDate ::::",formattedDate);
	var today = new Date();
	var birthDate = new Date(formattedDate);
	var age = today.getFullYear() - birthDate.getFullYear();
	if (age > 18+1) {
		document.getElementById("errorContainer-dateOfBirth").textContent = "";
	}else{
		document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='age-error' />";
	} 
}

function previousPage(){
	 window.location.href='${backRenderURL}';
}

</script>