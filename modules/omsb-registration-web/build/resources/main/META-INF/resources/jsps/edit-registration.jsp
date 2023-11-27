<%@ include file="../init.jsp"%>
<style>
    .bottom-backbtn-wrap{
        display: flex;
        margin-top: 15px;
        justify-content: flex-end;
    }

    .omsb-list-filter{
        padding-bottom:0;
    }
</style>
<portlet:renderURL var="viewRegistrationList">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommands.ADMIN_REGISTRATION_LIST%>" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommands.SPECIALITY_AND_SUBSPECIALITY_MVC_RESOURCE%>" var="specialityListURL" />	
<portlet:resourceURL var="fileUploadURL" id="<%=MVCCommands.UPLOAD_USER_PHOTO%>"></portlet:resourceURL>

<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card ">
					<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_REGISTRATION_DETAILS%>" var="saveRDURL">
					</liferay-portlet:actionURL>
					<form action="${saveRDURL}" method="post" 
						name="<portlet:namespace/>rdFM" id="rdFM" autocomplete="off" enctype="multipart/form-data">
						<input type="hidden" value="${personId }" name="<portlet:namespace/>personId_"/>
						<div class="reg_step1" id="reg_step1">
							<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<div class="pagetitle">
									<liferay-ui:message key="edit-profile" /></div>
									<div class="profile_photo">
                                                <div class="upload-container">
                                                 <input type="file" id="imageUpload" name="<portlet:namespace/>imageUpload" accept="image/*">
                                                    <label for="imageUpload" class="upload-label">Edit</label>
                                                     <c:if test="${not empty photoURL }">                                             
                                                     <img id="imagePreview" src="${photoURL}" alt="Preview">
                                                     </c:if>
                                                     <c:if test="${empty photoURL }">
                                                     <img id="imagePreview" src="<%=themeDisplay.getPathThemeImages() %>/png/profile_img.png" alt="Preview">
                                                     </c:if>
                                                     <p class="error-container" id="profile-error-container"></p>
                                                </div>
                                                                      
                                            </div>
								</div>
							</div>
												
						<c:if test="${isRoleApprover || isProfileApprover || isServiceApprover}">
						<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<a href="<%=viewRegistrationList%>"><button
											class="btn omsb-bc-red-button">
											<liferay-ui:message key="view-registration-list" />
									</button></a>
								</div>
							</div>
						</c:if>
							
							<h3 class="reg-form-title"><liferay-ui:message key="personal-details" /></h3>
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="username" /></label>
										<input type="text" name="<portlet:namespace/>userName" id="userName" value="${user_.screenName}" class="form-control" readonly>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
								  <c:if test="${not empty person.civilId}" >
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="civil-id" /></label>
										<input type="text" name="<portlet:namespace/>civilId" id="civilId" value="${person.civilId}" class="form-control" readonly>
									</div>
								  </c:if>	
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="date-of-birth" /></label>
										<input type="text" name="<portlet:namespace/>dateOfBirth" id="dateOfBirth" value="${person.dateOfBirth}" placeholder="DD-MM-YYYY" class="form-control " readonly>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 ">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="passport-no" /></label>
										<input type="text" name="<portlet:namespace/>passportNumber" id="passportNumber" value="${person.passportNumber}" class="form-control" ${not empty person.passportNumber && empty person.civilId?'readonly':''} >
									</div>
								</div>
								<div class="col-lg-4 col-md-6 ">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="country-of-issue" /></label>
										<select name="<portlet:namespace/>countryOfIssue" id="countryOfIssue" class="form-control" onchange="validateField(this.id,'errorContainer-countryOfIssue','<liferay-ui:message key="please-select-country-of-issue" />')"  >
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
										<label class="control-label"><liferay-ui:message key="date-of-passport-exipry" /></label>
										<input type="text" name="<portlet:namespace/>passportExpiryDate" id="passportExpiryDate" onkeyup="validateField(this.id,'errorContainer-passportExpiryDate','<liferay-ui:message key="please-enter-passport-expiry-date" />')"value="${personalDetails.passportExpiryDate}" placeholder="<liferay-ui:message key="DD-MM-YYYY" />" class="form-control " >
									</div>
									<p id="errorContainer-passportExpiryDate" class="error-container"></p>
								</div>
								<c:choose>
								<c:when test="${not empty person.civilId}">
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name" /></label>
												<input type="text" name="<portlet:namespace/>fullName" id="fullName" class="form-control" value="${user_.fullName}" readonly>
											</div>
											<p id="errorContainer-fullName" class="error-container"></p>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label class="control-label required"><liferay-ui:message key="full-name-ar" /></label>
												<input type="text" name="<portlet:namespace/>fullNameAr" id="fullNameAr" class="form-control" value="${personalDetails.fullNameAr}" readonly>
											</div>
											<p id="errorContainer-fullName-ar" class="error-container"></p>
										</div>
									</c:when>	
								    <c:otherwise>
								     <div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="first-name" /></label>
										<input type="text" onkeyup="validateField(this.id,'errorContainer-firstName','<liferay-ui:message key="please-enter-firstname" />')"name="<portlet:namespace/>firstName" id="firstName" value="${user_.firstName}" class="form-control">
									</div>
									<p id="errorContainer-firstName" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="family-name" /></label>
										<input type="text" name="<portlet:namespace/>lastName" id="lastName" value="${user_.lastName}" class="form-control">
									</div>
									<p id="errorContainer-lastName" class="error-container"></p>
								</div>
								    </c:otherwise>
								</c:choose>
								
								
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="email" /></label>
										<div class="omsb-ilo-area">
											<input type="text" name="<portlet:namespace/>emailAddress" id="emailAddress" value="${personalDetails.email}" class="form-control" ${user_.emailAddressVerified?'readOnly':''}>
											<c:if test="${!user_.emailAddressVerified}">	
												<span class="" ><button type="button" class="btn label-btn input-over-button" name="sendEmailOTP" onclick="sendVerificationOTP('emailAddress')" title="<liferay-ui:message key="send-otp" />" id="sendEmailOTP" ><liferay-ui:message key="send-otp" /></button></span>
											</c:if>
										</div>
									</div>
									<p id="errorContainer-emailAddress" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="row">
										<div class="col-lg-8 col-md-8">
											<div class="form-group ${user_.emailAddressVerified?'hide':''}">
												<label class="control-label"><liferay-ui:message key="email-otp" /></label>
												<input type="text" name="emailAddressOTP" id="emailAddressOTP" placeholder="<liferay-ui:message key="_ _ _ _ _ _" />" class="form-control" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==6) return false;" ${user_.emailAddressVerified?'readOnly':''} >
											</div>
											<p id="errorContainer-emailAddressOTP" class="error-container"></p>
										</div>
										<div class="col-lg-4 col-md-4">
											<c:if test="${!user_.emailAddressVerified}">
												<div class="form-group">
													<label></label>
													<button type="button" class="btn omsb-bc-red-button" name="verifyEmailAddressOTP" title="<liferay-ui:message key="verify-email" />" id="verifyEmailAddressOTP" name="verifyEmailOTP" onclick="verifyOTP('emailAddress')" title="<liferay-ui:message key="verify-email" />" id="verifyEmailOTP" ${user_.emailAddressVerified?'disabled':''}><liferay-ui:message key="verify-email" /></button>
												</div>
											</c:if>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="mobile" /></label>
										<div class="omsb-ilo-area">
											<input type="text" name="<portlet:namespace/>mobileNumber" id="mobileNumber" value="${personalDetails.mobileNumber}"
												class="form-control" ${personalDetails.mobileNumberVerified?'readOnly':''} pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==8) return false;">
											<c:if test="${!personalDetails.mobileNumberVerified}">
												<span class=""><button type="button" class="btn label-btn input-over-button" ><liferay-ui:message key="send-otp" /></button></span>
											</c:if>
										</div>
									</div>
									<p id="errorContainer-mobileNumber" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6 ">
									<div class="row">
										<div class="col-lg-8 col-md-8">
											<div class="form-group ${personalDetails.mobileNumberVerified?'hide':''}">
												<label class="control-label"><liferay-ui:message key="mobile-otp" /></label>
												<input type="text" name="mobileNumberOTP" id="mobileNumberOTP" placeholder="<liferay-ui:message key="_ _ _ _ _ _" />"
													class="form-control" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==6) return false;" ${personalDetails.mobileNumberVerified?'readOnly':''} >
											</div>
											<p id="errorContainer-mobileNumberOTP" class="error-container"></p>
										</div>
										<div class="col-lg-4 col-md-3">
											<c:if test="${!personalDetails.mobileNumberVerified}">
												<div class="form-group">
													<label></label>
													<button type="button" class="btn omsb-bc-red-button" name="verifyMobileNumberOTP" title="<liferay-ui:message key="verify-mobile" />" id="verifyMobileNumberOTP" ${personalDetails.mobileNumberVerified?'disabled':''}><liferay-ui:message key="verify-mobile" /></button>
												</div>
											</c:if>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="gender" /></label>
										<select name="<portlet:namespace/>gender" id="gender" class="form-control" onchange="validateField(this.id,'errorContainer-gender','<liferay-ui:message key="please-select-gender" />')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="gender" items="${genderList}">
												<option value="${gender.genderMasterId}" <c:if test="${gender.genderMasterId == personalDetails.genderId}">selected="selected"</c:if> >
													${gender.genderName}
												</option>
											</c:forEach>
										</select>
									</div>
									<p id="errorContainer-gender" class="error-container"></p>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="country-of-nationality" /></label>
										<select name="<portlet:namespace/>nationality" id="nationality" class="form-control" onchange="validateField(this.id,'errorContainer-nationality','<liferay-ui:message key="please-select-nationality" />')">
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
								<!-- <div class="col-lg-12 col-md-12">
								</div> -->
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="profession" /></label>
										<select name="<portlet:namespace/>profession" id="profession" class="form-control" onchange="showOtherField(this.id,'errorContainer-profession','<liferay-ui:message key="please-select-profession" />');setPrimarySpecialty()">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="profession" items="${professionList}">
												<option value="${profession.listTypeEntryId}" <c:if test="${profession.listTypeEntryId == personalDetails.profession}">selected="selected"</c:if> >
													${profession.getName(themeDisplay.getLocale())}
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

										<select name="<portlet:namespace/>primarySpeciality" id="primarySpeciality" class="form-control" onchange="showOtherField(this.id,'errorContainer-primarySpeciality','<liferay-ui:message key="please-select-primary-speciality" />');setSecondarySpeciality()">

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
							</div>
							<input type="hidden" name="<portlet:namespace/>emailAddressOTPVerified" id="emailAddressOTPVerified" value="${user_.emailAddressVerified}">
							<input type="hidden" name="<portlet:namespace/>mobileNumberOTPVerified" id="mobileNumberOTPVerified" value="${personalDetails.mobileNumberVerified}">
							<input type="hidden" name="<portlet:namespace/>personId" id="personId" value="${person.id}">
							<input type="hidden" name="<portlet:namespace/>userId" id="userId" value="${user_.userId}">
							 <input type="hidden" name="<portlet:namespace />countryCode" id="hiddenCountryCode" value="${personalDetails.countryCode}" />
							<input type="hidden" name="<portlet:namespace />countryIsoCode" id="hiddenCountryIsoCode" value="${personalDetails.countryIsoCode}" />  
						</div>
						<div class="reg_step2 "  id="reg_step2">
							<div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title"><liferay-ui:message key="education-details" /></h3>
								<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_education_detail" onClick="openEduOpenAddModel(this)"  data-target="#add-education-confirm-modal" data-toggle="modal"><img src="../images/svg/plus_img.svg" alt=""> Add More</button></div>
							</div>
							<div id="edu_detail_area">
								<input type="hidden" value="1"  name="<portlet:namespace/>counter"  id="counter"/>
								<!-- ==============================Education Data table =============================-->
								<div id="educationDetailsList">
											<c:choose>
												<c:when test="${!empty educationalDetailItemList}">
													<table class="display omsb-datatables" id="work-detail-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="qualification" /></th>
																<th><liferay-ui:message key="institution" /></th>
																<th><liferay-ui:message key="country-of-institution" /></th>
																<%-- <th><liferay-ui:message key="gpa" /></th> --%>
																<th><liferay-ui:message key="year-of-graduation" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}">
															<tr>
																<td>${educationalDetailItem.qualificationAttained}</td>
																<td>${educationalDetailItem.issuingAuthorityName}</td>
																<td>${educationalDetailItem.issuingAuthorityCountry}</td>
																<%-- <td>${educationalDetailItem.gpa}</td> --%>
																<td>${educationalDetailItem.yearOfGraduation}</td>
																<td>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-education-confirm-modal" onclick="setEditID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
												</c:when>
												<c:otherwise>
													<liferay-ui:message key="no-records-found" />
												</c:otherwise>
											</c:choose>
										</div>
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
								<!-- ==============================Education Data table =============================-->
							</div>
						</div>
						
						<!-- =============================== Work Details starts ==================================================== -->
						<div class="reg_step3 mt-4"  id="reg_step3">
						    <h3 class="reg-form-title"><liferay-ui:message key="registration-work-details" /></h3>
							<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId" /> 
							<input type="hidden" value="${personId }" name="<portlet:namespace/>personId" id="personId">
							<%-- <div class="d-flex">
								<div class="w-50">
									<label class="control-label"><liferay-ui:message key="are-you-currently-or-have-been-employed" /></label>
								</div>
								<div class="form-group yesorno">
									<div class="custom-control custom-radio ">
										  <input type="radio" name="<portlet:namespace/>employed" value="1" class="custom-control-input" id="employed_yes" checked <c:if test="${workDetailItems.getItems().size() >= 1}" >checked</c:if>/>
										 <input type="radio" name="<portlet:namespace/>employed" value="1" class="custom-control-input" id="employed_yes" />
										<label class="custom-control-label m-0" for="employed_yes"><liferay-ui:message key="yes" /></label>
									</div>
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>employed" value="0" class="custom-control-input" id="employed_no" <c:if test="${workDetailItems.getItems().size() < 1}" >checked</c:if>/>
										<label class="custom-control-label m-0" for="employed_no"><liferay-ui:message key="no" /></label>
									</div>
								</div>
							</div> --%>							
							
							<div class="omsb-main-div" id="work-detail-main">
									<!--  primary work detail -->
							
							<c:choose>
								<c:when test="${empty primaryworkDetail}">
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1">
										<input type="hidden" name="<portlet:namespace/>id_1" id="<portlet:namespace/>id_1"> 
										<input type="hidden" name="<portlet:namespace/>isPrimary_1" id="<portlet:namespace/>isPrimary_1" value="true">
											<div class="">
												<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
												<div class="row ">
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label  required"><liferay-ui:message key="primary-workplace-sector-type" /></label> 
															<select name="<portlet:namespace/>workSectorType_1" id="workSectorType_1" class="form-control" onchange="getWorkSector(this.id)">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSectorType" items="${workSectorTypeList}">
																	<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
																</c:forEach>
															</select>
															<p class="error-container" id="work-sector-type-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																	 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																</div>
													</div>
													<div class="col-lg-4 col-md-6" id="work-sector-div_1">
														<div class="form-group" >
															<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label>
															  
															  <select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value="" selected="selected"><liferay-ui:message key="select" /></option>
															</select>
															 <%--  <input type="text" class="form-control worksector_1" id="worksector_1" name="<portlet:namespace/>worksector_1" placeholder="" autocomplete="off"/> --%>
															<p class="error-container" id="work-sector-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
															 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control"> 
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="primary-first-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="primary-sub-sector-name-other" /> --%></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="">
															</div>
													</div>
													<!-- Third level -->
														<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_1">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name-other" /> --%></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="">
																</div>
														</div>
													<!-- Third level -->
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="region-location-primary-institution" /></label> 
															<select name="<portlet:namespace/>wilayats_1" id="wilayats_1" class="form-control" onchange="validateField(this.id,'location-error_1','<liferay-ui:message key="please-enter-work-sector-location" />')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="wilayats" items="${wilayats}">
																	<option value="${wilayats.getKey()}">
																		<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="location-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="designation" /></label>
															 <select name="<portlet:namespace/>designations_1" id="designations_1" onchange="showDesignationOther(this.id,'designation-error_1','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="designations" items="${designations}">
																	<option value="${designations.getKey()}">
																		<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="designation-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="designation-other" /></label>
															 <input type="text" name="<portlet:namespace/>designationother_1" id="designationother_1" value="" class="form-control">
														</div>
													</div>
													<div class="col-lg-12 col-md-12">
														<div class="form-group">
															<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
															<div class="omsb-custom-html-file custom-file">
																<input id="staffIdCard_1" name="<portlet:namespace/>staffIdCard_1" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_1','<liferay-ui:message key="please-select-pdf-file" />')">
																<label class="custom-file-label" for="staffIdCard_1" id="customStaffIdCard_"> </label>
															</div>
															<p class="error-container" id="file-size-error_1"></p>
															<p class="error-container" id="errorContainer-work-detail-file_1"></p>
														</div>
													</div>
												</div>
												<div class="bottom-backbtn-wrap"></div>
											</div>
										</div>
									</c:when>
									<c:otherwise>
											<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1">
												<input type="hidden" name="<portlet:namespace/>id_1" id="<portlet:namespace/>id_1" value="${primaryworkDetail.getId()}">	
												<div class="">
														<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
														<input type="hidden" name="<portlet:namespace/>isPrimary_1" id="<portlet:namespace/>isPrimary_1" value="true">
													<div class="row ">
															<div class="col-lg-4 col-md-6">
																<div class="form-group">
																	<label class="control-label required"><liferay-ui:message key="primary-workplace-sector-type" /></label>
																		<!-- Changes Abhi  starts -->
																			 <%-- <select name="<portlet:namespace/>workSectorType_${loop.count }" id="workSectorType_${loop.count }" class="form-control" onchange="validateField(this.id,'work-sector-type-error_${loop.count }','<liferay-ui:message key="please-enter-work-sector-type" />')"> --%>
																		 <select name="<portlet:namespace/>workSectorType_1" id="workSectorType_1" class="form-control 3" onchange="getWorkSector(this.id)">
																				<option value=""><liferay-ui:message key="select" /></option>
																		<c:forEach var="workSectorType" items="${workSectorTypeList}">
																			<option value="${workSectorType.getListTypeEntryId()}" ${workSectorType.getListTypeEntryId() == primaryworkDetail.getWorkSectorType() ? 'selected="selected"' : ''}>
																				<liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" />
																			</option>
																		</c:forEach>
																	</select>
																	<p class="error-container" id="work-sector-type-error_1"></p>
																</div>
															</div>
															
															<c:choose>
																<c:when test="${not empty primaryworkDetail.getWorkSectorTypeOther()}">
																	<div class="col-lg-4 col-md-6 " id="worksectorTypediv_1">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																			 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																		</div>
																	</div>
																</c:when>
																<c:otherwise>
																	<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_1">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																			 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																		</div>
																	</div>
																</c:otherwise>
															</c:choose>
															
															<!-- For Work Sector div start-->
												<c:choose>
													
														<c:when test="${primaryworkDetail.workSectorId>0}">
															<div class="col-lg-4 col-md-6" id="work-sector-div_1">
																<div class="form-group" >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<c:forEach var="workSector" items="${primaryworkDetail.workSectorItems.items}">
																					<option value="${workSector.getId()}" ${workSector.getId() == primaryworkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																						${workSector.getWorkSector()}
																					</option>
																				</c:forEach>
																				<option value="other"><liferay-ui:message key="other" /></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:when>
														
													<c:when test="${not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6" id="work-sector-div_1">
																<div class="form-group " >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<c:forEach var="workSector" items="${primaryworkDetail.workSectorItems.items}">
																					<option value="${workSector.getId()}" ${workSector.getId() == primaryworkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																						${workSector.getWorkSector()}
																					</option>
																				</c:forEach>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
														
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6 " id="work-sector-div_1">
																<div class="form-group " >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:when>
													<c:otherwise>
															<div class="col-lg-4 col-md-6 d-none" id="work-sector-div_1">
																<div class="form-group " >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:otherwise>
												</c:choose>
														<!-- For Work Sector div start End-->
														
														<!-- For Work Sector other div start-->
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther}">
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId==0 &&  empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther}">
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="">
																</div>
															</div>
													</c:otherwise>
												</c:choose>
														<!-- For Work Sector Other div end-->
														
														<!-- For Level 2 Work Sector div Start-->		
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId>0 &&  primaryworkDetail.workSectorId2>0}">
														<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="primary-first-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																			<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																				${workSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId2==0 && not empty primaryworkDetail.workSectorOther2}">
														<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="primary-first-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																			<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																				${workSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:otherwise>
															<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="primary-first-sub-sector-name" /> --%></label>
																	<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																		<option value=""><liferay-ui:message key="select" /></option>
																		<option value="other"><liferay-ui:message key="other" /></option>
																	</select>
																</div>
															</div>
													</c:otherwise>
												</c:choose>
														<!-- For Level 2 Work Sector div end-->
														
														<!-- For Level 2 Work Sector Other div Start-->
												<c:choose>
													<c:when test="${ not empty primaryworkDetail.workSectorOther2}">
													<div class="col-lg-4 col-md-6 " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "><%-- <liferay-ui:message key="primary-sub-sector-name-other" /> --%></label>
															 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther2}">
														</div>
													</div>
													</c:when>
													<c:otherwise>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "><%-- <liferay-ui:message key="primary-sub-sector-name-other" /> --%></label>
															 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="">
														</div>
													</div>
													</c:otherwise>
												</c:choose>
													<!-- For Level 2 Work Sector Other div End-->
													
													<!-- Third Level Work Sector Start-->
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId2>0 &&  primaryworkDetail.workSectorId3>0}">
														<div class="col-lg-4 col-md-6 1" id="div-second-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSecondSubSector" items="${primaryworkDetail.workSecondSubSectorItems.items}">
																			<option value="${workSecondSubSector.getId()}" ${workSecondSubSector.getId() == primaryworkDetail.getWorkSectorId3() ? 'selected="selected"' : ''}>
																				${workSecondSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId3==0 && not empty primaryworkDetail.workSectorOther3}">
															<div class="col-lg-4 col-md-6 2" id="div-second-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name" /> --%></label>
																	<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSecondSubSector" items="${primaryworkDetail.workSecondSubSectorItems.items}">
																			<option value="${workSecondSubSector.getId()}">
																				${workSecondSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
																</div>
															</div>
													</c:when>
													<c:otherwise>
															<div class="col-lg-4 col-md-6 3 d-none" id="div-second-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name" /> --%></label>
																	<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																		<option value=""><liferay-ui:message key="select" /></option>
																		<option value="other"><liferay-ui:message key="other" /></option>
																	</select>
																</div>
															</div>
													</c:otherwise>
															
												</c:choose>
													<!-- Third Level Work Sector End-->
													
													<!-- Third Level Work Sector Other Start-->
													<c:choose>
														<c:when test="${primaryworkDetail.workSectorId3==0 &&  not empty primaryworkDetail.workSectorOther3}">
														<div class="col-lg-4 col-md-6" id="div-o3-secons-work-other_1">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name-other" /> --%></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther3}">
																</div>
														</div>
														</c:when>
														<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none " id="div-o3-secons-work-other_1">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="primary-second-sub-sector-name-other" /> --%></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="">
																</div>
														</div>
														</c:otherwise>
													</c:choose>
													<!-- Third Level Work Sector Other Ends-->
													
													
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label required"><liferay-ui:message key="region-location-primary-institution" /></label>
																		<select name="<portlet:namespace/>wilayats_1" id="wilayats_1" class="form-control" onchange="validateField(this.id,'location-error_1','<liferay-ui:message key="please-enter-work-sector-location" />')">
																	
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="wilayats" items="${wilayats}">
																		<option value="${wilayats.getKey()}" ${wilayats.getKey() == primaryworkDetail.getWorkSectorLocation() ? 'selected' : ''}>
																			<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																		</option>
																	</c:forEach>
																</select>
																<p class="error-container" id="location-error_1"></p>
															</div>
														</div>
														
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label required"><liferay-ui:message key="designation" /></label>
																	<select name="<portlet:namespace/>designations_1" id="designations_1" onchange="showDesignationOther(this.id,'designation-error_1','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="designations" items="${designations}">
																		<option value="${designations.getKey()}" ${designations.getKey() == primaryworkDetail.getDesignationId() ? 'selected="selected"' : ''}>
																			<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																		</option>
																	</c:forEach>
																</select>
																<p class="error-container" id="designation-error_1"></p>
															</div>
														</div>
														
														<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="designation-other" /></label> 
																<input type="text" name="<portlet:namespace/>designationother_1" id="designationother_1" value="${primaryworkDetail.getDesignationOther() }" class="form-control">
															</div>
														</div>
														
														<div class="col-lg-12 col-md-12">
															<div class="row">
														      <div class="col-lg-10 col-md-10">
																	<div class="form-group">
																		<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
																		<div class="omsb-custom-html-file custom-file">
																			<input id="staffIdCard_1" name="<portlet:namespace/>staffIdCard_1"   type="file" label="" class="form-control custom-file-input" onchange="validateFile(this.id,'file-size-error_1','<liferay-ui:message key="please-select-pdf-file" />')">
																			<label class="custom-file-label" for="staffIdCard_1" id="customStaffIdCard_1">
																			 <c:if test="${not empty primaryworkDetail.getStaffIdCard()}">
																			      ${primaryworkDetail.getUploadFileName()}
																			 </c:if>
																			</label>
																			<c:choose>
																				<c:when test="${not empty primaryworkDetail.getStaffIdCard()}">
																					<input type="hidden" id="uploadFile_1" value="${primaryworkDetail.getStaffIdCard()}" name="<portlet:namespace/>uploadFile_1" />
																				</c:when>
																				<c:otherwise>
																					<input type="hidden" id="uploadFile_1" value="" name="<portlet:namespace/>uploadFile_1" />
																				</c:otherwise>
																			</c:choose>
																		</div>	
																		   <p class="error-container" id="file-size-error_1"></p>
																			<p class="error-container"id="errorContainer-work-detail-file_1"></p>
																	</div>
																</div>
																<div class="col-lg-2 col-md-2">
																	   <div class="form-group">
																			<label class="control-label"></label>
																				<a class="btn view_btn text-danger"  title="<liferay-ui:message key="view" />" target="_blank" href="${primaryworkDetail.getDocumentUrl() }">
																					<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
																				</a>
																		</div>
														 		</div>
													 		</div>
														 </div>	
														
														</div>
													</div>
												</div>
										</c:otherwise>
									</c:choose>
					<!--==============================================  primary work detail =====================================================================-->
										
					<!--==========================  secondary work detail =========================================-->
										
					<c:choose>
		<c:when test="${empty secondaryWorkDetail}">
			<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_2">
				<input type="hidden" name="<portlet:namespace/>id_2" id="<portlet:namespace/>id_2"> 
				<input type="hidden" name="<portlet:namespace/>isPrimary_2" id="<portlet:namespace/>isPrimary_2" value="false">
					<div class="">
						<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
						<div class="row ">
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label  required"><liferay-ui:message key="secondary-workplace-sector-type" /></label> 
									<select name="<portlet:namespace/>workSectorType_2" id="workSectorType_2" class="form-control" onchange="getWorkSector(this.id)">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="workSectorType" items="${workSectorTypeList}">
											<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
										</c:forEach>
									</select>
									<p class="error-container" id="work-sector-type-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
											 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
										</div>
							</div>
							<div class="col-lg-4 col-md-6" id="work-sector-div_2">
								<div class="form-group" >
									<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label>
									  
									  <select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value="" selected="selected"><liferay-ui:message key="select" /></option>
									</select>
									 <%--  <input type="text" class="form-control worksector_2" id="worksector_2" name="<portlet:namespace/>worksector_2" placeholder="" autocomplete="off"/> --%>
									<p class="error-container" id="work-sector-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
									 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control"> 
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-first-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
							</div>
							<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-sub-sector-name-other" /> --%></label>
										 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
										 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="">
									</div>
							</div>
							<!-- Third level -->
								<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_2">
										<div class="form-group">
											<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name-other" /> --%></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="">
										</div>
								</div>
							<!-- Third level -->
							
							
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label required"><liferay-ui:message key="region-location-secondary-institution" /></label> 
									<select name="<portlet:namespace/>wilayats_2" id="wilayats_2" class="form-control" onchange="validateField(this.id,'location-error_2','<liferay-ui:message key="please-enter-work-sector-location" />')">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="wilayats" items="${wilayats}">
											<option value="${wilayats.getKey()}">
												<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p class="error-container" id="location-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label required"><liferay-ui:message key="designation" /></label>
									 <select name="<portlet:namespace/>designations_2" id="designations_2" onchange="showDesignationOther(this.id,'designation-error_2','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="designations" items="${designations}">
											<option value="${designations.getKey()}">
												<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p class="error-container" id="designation-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="designation-other" /></label>
									 <input type="text" name="<portlet:namespace/>designationother_2" id="designationother_2" value="" class="form-control">
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
									<div class="omsb-custom-html-file custom-file">
										<input id="staffIdCard_2" name="<portlet:namespace/>staffIdCard_2" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_2','<liferay-ui:message key="please-select-pdf-file" />')">
										<label class="custom-file-label" for="staffIdCard_2" id="customStaffIdCard_"> </label>
									</div>
									<p class="error-container" id="file-size-error_2"></p>
									<p class="error-container" id="errorContainer-work-detail-file_2"></p>
								</div>
							</div>
						</div>
						<div class="bottom-backbtn-wrap"></div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
					<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_2">
						<input type="hidden" name="<portlet:namespace/>id_2" id="<portlet:namespace/>id_2" value="${secondaryWorkDetail.getId()}">	
						<div class="">
								<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
								<input type="hidden" name="<portlet:namespace/>isPrimary_2" id="<portlet:namespace/>isPrimary_2" value="false">
							<div class="row ">
									<div class="col-lg-4 col-md-6">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="secondary-workplace-sector-type" /></label>
												<!-- Changes Abhi  starts -->
													 <%-- <select name="<portlet:namespace/>workSectorType_${loop.count }" id="workSectorType_${loop.count }" class="form-control" onchange="validateField(this.id,'work-sector-type-error_${loop.count }','<liferay-ui:message key="please-enter-work-sector-type" />')"> --%>
												 <select name="<portlet:namespace/>workSectorType_2" id="workSectorType_2" class="form-control 3" onchange="getWorkSector(this.id)">
														<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="workSectorType" items="${workSectorTypeList}">
													<option value="${workSectorType.getListTypeEntryId()}" ${workSectorType.getListTypeEntryId() == secondaryWorkDetail.getWorkSectorType() ? 'selected="selected"' : ''}>
														<liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" />
													</option>
												</c:forEach>
											</select>
											<p class="error-container" id="work-sector-type-error_2"></p>
										</div>
									</div>
									
									<c:choose>
										<c:when test="${not empty secondaryWorkDetail.getWorkSectorTypeOther()}">
											<div class="col-lg-4 col-md-6 " id="worksectorTypediv_2">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
													 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_2">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
													 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
												</div>
											</div>
										</c:otherwise>
									</c:choose>
									
									<!-- For Work Sector div start-->
						<c:choose>
							
								<c:when test="${secondaryWorkDetail.workSectorId>0}">
									<div class="col-lg-4 col-md-6" id="work-sector-div_2">
										<div class="form-group" >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
															<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																${workSector.getWorkSector()}
															</option>
														</c:forEach>
														<option value="other"><liferay-ui:message key="other" /></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:when>
								
							<c:when test="${not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6" id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
															<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																${workSector.getWorkSector()}
															</option>
														</c:forEach>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
								
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6 " id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 d-none" id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:otherwise>
						</c:choose>
								<!-- For Work Sector div start End-->
								
								<!-- For Work Sector other div start-->
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6" id="div-o2-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
										 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
										 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther}">
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId==0 &&  empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
										 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
										 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther}">
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="">
										</div>
									</div>
							</c:otherwise>
						</c:choose>
								<!-- For Work Sector Other div end-->
								
								<!-- For Level 2 Work Sector div Start-->		
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId>0 &&  secondaryWorkDetail.workSectorId2>0}">
								<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-first-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
													<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
														${workSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId2==0 && not empty secondaryWorkDetail.workSectorOther2}">
								<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-first-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
													<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
														${workSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
										<div class="form-group">
											<label class="control-label "><%-- <liferay-ui:message key="secondary-first-sub-sector-name" /> --%></label>
											<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other"><liferay-ui:message key="other" /></option>
											</select>
										</div>
									</div>
							</c:otherwise>
						</c:choose>
								<!-- For Level 2 Work Sector div end-->
								
								<!-- For Level 2 Work Sector Other div Start-->
						<c:choose>
							<c:when test="${ not empty secondaryWorkDetail.workSectorOther2}">
							<div class="col-lg-4 col-md-6 " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "><%-- <liferay-ui:message key="secondary-sub-sector-name-other" /> --%></label>
									 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther2}">
								</div>
							</div>
							</c:when>
							<c:otherwise>
							<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "><%-- <liferay-ui:message key="secondary-sub-sector-name-other" /> --%></label>
									 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="">
								</div>
							</div>
							</c:otherwise>
						</c:choose>
							<!-- For Level 2 Work Sector Other div End-->
							
							<!-- Third Level Work Sector Start-->
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId2>0 &&  secondaryWorkDetail.workSectorId3>0}">
								<div class="col-lg-4 col-md-6 1" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSecondSubSector" items="${secondaryWorkDetail.workSecondSubSectorItems.items}">
													<option value="${workSecondSubSector.getId()}" ${workSecondSubSector.getId() == secondaryWorkDetail.getWorkSectorId3() ? 'selected="selected"' : ''}>
														${workSecondSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId3==0 && not empty secondaryWorkDetail.workSectorOther3}">
									<div class="col-lg-4 col-md-6 2" id="div-second-sub-sector_2">
										<div class="form-group">
											<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name" /> --%></label>
											<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSecondSubSector" items="${secondaryWorkDetail.workSecondSubSectorItems.items}">
													<option value="${workSecondSubSector.getId()}">
														${workSecondSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
										</div>
									</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 3 d-none" id="div-second-sub-sector_2">
										<div class="form-group">
											<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name" /> --%></label>
											<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other"><liferay-ui:message key="other" /></option>
											</select>
										</div>
									</div>
							</c:otherwise>
									
						</c:choose>
							<!-- Third Level Work Sector End-->
							
							<!-- Third Level Work Sector Other Start-->
							<c:choose>
								<c:when test="${secondaryWorkDetail.workSectorId3==0 &&  not empty secondaryWorkDetail.workSectorOther3}">
								<div class="col-lg-4 col-md-6" id="div-o3-secons-work-other_2">
										<div class="form-group">
											<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name-other" /> --%></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther3}">
										</div>
								</div>
								</c:when>
								<c:otherwise>
								<div class="col-lg-4 col-md-6 d-none " id="div-o3-secons-work-other_2">
										<div class="form-group">
											<label class="control-label "><%-- <liferay-ui:message key="secondary-second-sub-sector-name-other" /> --%></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="">
										</div>
								</div>
								</c:otherwise>
							</c:choose>
							<!-- Third Level Work Sector Other Ends-->
							
							
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="region-location-secondary-institution" /></label>
												<select name="<portlet:namespace/>wilayats_2" id="wilayats_2" class="form-control" onchange="validateField(this.id,'location-error_2','<liferay-ui:message key="please-enter-work-sector-location" />')">
											
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="wilayats" items="${wilayats}">
												<option value="${wilayats.getKey()}" ${wilayats.getKey() == secondaryWorkDetail.getWorkSectorLocation() ? 'selected' : ''}>
													<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
										<p class="error-container" id="location-error_2"></p>
									</div>
								</div>
								
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="designation" /></label>
											<select name="<portlet:namespace/>designations_2" id="designations_2" onchange="showDesignationOther(this.id,'designation-error_2','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="designations" items="${designations}">
												<option value="${designations.getKey()}" ${designations.getKey() == secondaryWorkDetail.getDesignationId() ? 'selected="selected"' : ''}>
													<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
										<p class="error-container" id="designation-error_2"></p>
									</div>
								</div>
								
								<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="designation-other" /></label> 
										<input type="text" name="<portlet:namespace/>designationother_2" id="designationother_2" value="${secondaryWorkDetail.getDesignationOther() }" class="form-control">
									</div>
								</div>
								
								<div class="col-lg-12 col-md-12">
									<div class="row">
									  <div class="col-lg-10 col-md-10">
											<div class="form-group">
												<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
												<div class="omsb-custom-html-file custom-file">
													<input id="staffIdCard_2" name="<portlet:namespace/>staffIdCard_2"   type="file" label="" class="form-control custom-file-input" onchange="validateFile(this.id,'file-size-error_2','<liferay-ui:message key="please-select-pdf-file" />')">
													<label class="custom-file-label" for="staffIdCard_2" id="customStaffIdCard_2">
													 <c:if test="${not empty secondaryWorkDetail.getStaffIdCard()}">
														  ${secondaryWorkDetail.getUploadFileName()}
													 </c:if>
													</label>
													<c:choose>
														<c:when test="${not empty secondaryWorkDetail.getStaffIdCard()}">
															<input type="hidden" id="uploadFile_2" value="${secondaryWorkDetail.getStaffIdCard()}" name="<portlet:namespace/>uploadFile_2" />
														</c:when>
														<c:otherwise>
															<input type="hidden" id="uploadFile_2" value="" name="<portlet:namespace/>uploadFile_2" />
														</c:otherwise>
													</c:choose>
												</div>	
												   <p class="error-container" id="file-size-error_2"></p>
													<p class="error-container"id="errorContainer-work-detail-file_2"></p>
											</div>
										</div>
										<div class="col-lg-2 col-md-2">
											   <div class="form-group">
													<label class="control-label"></label>
														<a class="btn view_btn text-danger"  title="<liferay-ui:message key="view" />" target="_blank" href="${secondaryWorkDetail.getDocumentUrl() }">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
														</a>
												</div>
										</div>
									</div>
								 </div>	
								
								</div>
							</div>
						</div>
				</c:otherwise>
</c:choose>			
					
					<!--==========================  secondary work detail =========================================-->
					 <div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title"></h3>
								<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_work_detail" onClick="openWorkDetailOpenAddModel(this)"  data-target="#add-work-detail-confirm-modal" data-toggle="modal"><img src="../images/svg/plus_img.svg" alt=""> Add More</button></div>
					</div> 
								</div>
							
							 <div id="workDetailList">
								<c:choose>
												<c:when test="${!empty pastWorkDetails}">
													<table class="display omsb-datatables" id="work-detail-list1" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="workplace-sector-type" /></th>
																<%-- <th><liferay-ui:message key="workplace-sector-other" /></th> --%>
																<th><liferay-ui:message key="sector-name" /></th>
																<%-- <th><liferay-ui:message key="sector-name-other" /></th>
																<th><liferay-ui:message key="sector-name-2" /></th>
																<th><liferay-ui:message key="sector-name-2-other" /></th>
																<th><liferay-ui:message key="sector-name-3" /></th>
																<th><liferay-ui:message key="sector-name-3-other" /></th> --%>
																<th><liferay-ui:message key="region-locationS-institution" /></th>
																<th><liferay-ui:message key="designation" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="pastWorkDetail" items="${pastWorkDetails}"> 
															<tr>
																<td>${pastWorkDetail.getWorkSectorType()}</td>
																<%-- <td>${pastWorkDetail.getWorkSectorTypeOther()}</td> --%>
																<td>${pastWorkDetail.getWorkSector()}</td>
																<%-- <td>${pastWorkDetail.getWorkSectorOther()}</td>
																<td>${pastWorkDetail.getWorkSector2()}</td>
																<td>${pastWorkDetail.getWorkSectorOther2()}</td>
																<td>${pastWorkDetail.getWorkSector3()}</td>
																<td>${pastWorkDetail.getWorkSectorOther3()}</td> --%>
																<td>${pastWorkDetail.getWorkSectorLocation()}</td>
																<td>${pastWorkDetail.getDesignationId()}</td>
																<td>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-work-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${pastWorkDetail.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-work-detail-confirm-modal" onclick="setWorkDetailEditID('${pastWorkDetail.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																</td>
															</tr>
														 </c:forEach>
													</tbody>
												</table>
												</c:when>
												<c:otherwise>
													<liferay-ui:message key="no-records-found" />
												</c:otherwise>
											</c:choose>
							</div> 
				</div>
						<!-- =============================== Work Details Ends ==================================================== -->
						
						
						
						
						
						
						
						<div class="reg_step4 mt-4"  id="reg_step4">
							<div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title"><liferay-ui:message key="role-service" /></h3>
								<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_role-service" onClick="openRoleServiceOpenAddModel(this)"  data-target="#add-role-service-confirm-modal" data-toggle="modal"><img src="../images/svg/plus_img.svg" alt=""> Add More</button></div>
							</div>
							
							<div class="d-none">
							 	<div class="w-50">
									<label class="control-label"><liferay-ui:message key="are-you-associated-with-omsb" /></label>
								</div>
								<div class="form-group yesorno">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_yes" value="1" checked>
										<label class="custom-control-label m-0" for="associated_yes"><liferay-ui:message key="yes" /></label>
									</div>
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_no" value="0">
										<label class="custom-control-label m-0" for="associated_no"><liferay-ui:message key="no" /></label>
									</div>
								</div>
							</div>
								<div id="roleServiceList">
								<div class="table-responsive">
								<c:choose>
												<c:when test="${!empty userMetadataItem}">
													<table class="display omsb-datatables" id="role-service-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="role" /></th>
																<th><liferay-ui:message key="department" /></th>
																<th><liferay-ui:message key="section" /></th>
																<%-- <th><liferay-ui:message key="committee" /></th> 
																<th><liferay-ui:message key="function" /></th> --%>
																<th><liferay-ui:message key="program-type" /></th>
																<th><liferay-ui:message key="program" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="userMetadata" items="${userMetadataItem.items}"> 
															<tr>
																<td>${userMetadata.roleName}</td>
																<td>${userMetadata.departmentId}</td>
																<td>${userMetadata.sectionId}</td>
																<%-- <td>${userMetadata.committeeId}</td> 
																 <td>${userMetadata.functionId}</td>  --%>
																<td>${userMetadata.programTypeName}</td>
																<td>${userMetadata.programName}</td>
																
																<td>
																	<c:if test="${not userMetadata.roleRequestedByAdmin}">
																		<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-role-service-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${userMetadata.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																		<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-role-service-confirm-modal" onclick="setRoleServiceID('${userMetadata.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																	</c:if>
																		
																</td>
															</tr>
														 </c:forEach>
													</tbody>
												</table>
												</c:when>
												<c:otherwise>
													<liferay-ui:message key="no-records-found" />
												</c:otherwise>
									</c:choose>
						
						</div>
						</div>
						 <div class="bottom-backbtn-wrap">
							<button class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('save')" type="button" title="<liferay-ui:message key='save-at-this-stage' />"><liferay-ui:message key="Save" /></button>
							<button class="btn omsb-bg-red-button" id="registration-cancel" type="button" title="<liferay-ui:message key='cancel' />"><liferay-ui:message key="cancel" /></button>
						</div> 
					</form>
				</div>
			</div>
		</div>
		<!--// Inner Wrapper Contents -->
	</section>
	<!---// End Main Content Section Here --->
</div>
		
		<!--delete popup for Education  Detail -->
		<div class="modal fade omsb-modal" id="delete-education-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteEduSection()" title="<liferay-ui:message key='ok'/>" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->		
		<!-- Add Education Model Popup -->
		<div class="modal fade omsb-modal" id="add-education-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-education-details" /></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<portlet:actionURL name="<%=MVCCommands.EDUCATION_DETAILS_MVCACTION%>" var="educationalDetailMVCActionURL"/>
						<form  class="" name="<portlet:namespace/>edFM"  id="edFM" action="${educationalDetailMVCActionURL}" method="post" enctype="multipart/form-data">
								<div class="reg_step2"  id="reg_step2">
									<div class="omsb-page-top-info mb-4">
										<h3 class="reg-form-title"><liferay-ui:message key="education-details" /> </h3>
									</div>
									<div id="edu_detail_area">
										<div class="omsb-card omsb-card-graybg omsb-noBorderRadius edu_detail element bottom-backbtn-wrap" id="edu_detail" >
											<div class="omsb-list-filter">
											<div class="row ">
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-title" />  </label>
														<select  name="<portlet:namespace/>qualification" id="qualification" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="qualification" items="${qualificationList}">
																<option value="${qualification.getKey()}">
																	<liferay-ui:message key="${qualification.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-qualification" class="error-container"></p>
													</div>
												</div>
												
												<div class="col-lg-6 col-md-6 d-none" id="qualificationOtherDiv">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-other" /></label>
														<input  type="text" name="<portlet:namespace/>qualificationOther" id="qualificationOther" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-qualification" class="error-container"></p>
												</div>
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="institution" /></label>
														<select  name="<portlet:namespace/>institution" id="institution" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="institution" items="${institutionList}">
																<option value="${institution.getKey() }">
																	<liferay-ui:message key="${institution.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-institution" class="error-container"></p>
													</div>
												</div>
												
												<div class="col-lg-6 col-md-6 d-none" id="institutionOtherDiv">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="institution-other" /></label>
														<input  type="text" name="<portlet:namespace/>institutionOther" id="institutionOther" class="form-control" value="${institutionOther}" >
													</div>
													<p id="errorContainer-institution" class="error-container"></p>
												</div>
												
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="country-of-institution" /></label>
														<select  name="<portlet:namespace/>country" id="country" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="country" items="${countries}">
																<option value="${country.countryId}">
																	<liferay-ui:message key="${country.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-country" class="error-container"></p>
													</div>
												</div>											
												
												<%-- <div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="gpa" /></label>
														<input type="text" name="<portlet:namespace/>gpa" id="gpa" value=" "
														class="form-control">
														<p id="errorContainer-gpa" class="error-container"></p>
													</div>
												</div> --%>
												<input type="hidden" name="id" id="id">
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="year-of-graduation" /></label>
														<select  name="<portlet:namespace/>year" id="year" class="form-control">
															<option value=""><liferay-ui:message key="select"/></option>
															<% int currentYear = Calendar.getInstance().get(Calendar.YEAR); %>
															<c:forEach  begin="1970"  end="${year}" step="1" var="age">
															    <c:set var="decr" value="${(year-age)+1970}"/>
															    <option value="${decr}"}>${decr}</option>
															</c:forEach>
														</select>
														<p id="errorContainer-year-of-graducation" class="error-container"></p>
													</div>
												</div>

												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="qualification-document" /></label>
														<div class="custom-file">
															<div>
																<input type="file" name="qualificationdoc" id="qualificationdoc" value=""
																class="form-control custom-file-input">
															</div>
															<label class="custom-file-label" for="qualificationdoc" id="qualificationdoclbl"></label>
														</div>
														 <p id="errorContainer-qualification-document" class="error-container"></p> 
													</div>
												</div>
												<div class="col-lg-12 col-md-12 d-none" id="view-div" >
												<div class="row">
												<div class="col-lg-8 col-md-8"></div>
												<div class="col-lg-4 col-md-4">
												  <div class="form-group">
														<label class="control-label"></label>
														<a class="btn view_btn text-danger"  id="view-file" title="<liferay-ui:message key="view" />" target="_blank" href="#">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
														</a>
													</div>
												</div>
												</div>
												</div>
											</div>
										</div>
										</div>
									</div>
									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" onClick="saveEducationDetails()" type="button" title="<liferay-ui:message key='save-at-this-stage'/>"><liferay-ui:message key="save-at-this-stage"/></button>
										<button class="btn omsb-bc-red-button" onClick="clearForm()" type="button" title="<liferay-ui:message key='clear'/>"><liferay-ui:message key="clear"/></button>
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
								<input type="hidden" value="" name="deleteID" id="deleteID"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Add Education Model Popup -->
	
		<!--Add  Work Detail  Model popup -->
		<div class="modal fade omsb-modal" id="add-work-detail-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-work-details" /></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form  class="" name="<portlet:namespace/>workDetailFM"  id="workDetailFM" action="${educationalDetailMVCActionURL}" method="post" enctype="multipart/form-data">
								<div class="reg_step2"  id="reg_step2">
									<div class="omsb-page-top-info mb-4">
										<h3 class="reg-form-title"><liferay-ui:message key="work-details" /> </h3>
									</div>
									
									
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_3">
										<input type="hidden" name="<portlet:namespace/>id_3" id="<portlet:namespace/>id_3"> 
										<input type="hidden" name="<portlet:namespace/>isPrimary_3" id="<portlet:namespace/>isPrimary_3" value="true">
											<div class="">
												<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
												<div class="row ">
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label  required"><liferay-ui:message key="workplace-sector-type" /></label> 
															<select name="<portlet:namespace/>workSectorType_3" id="workSectorType_3" class="form-control" onchange="getWorkSector(this.id)">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSectorType" items="${workSectorTypeList}">
																	<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
																</c:forEach>
															</select>
															<p class="error-container" id="work-sector-type-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_3">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="workplace-sector-type-other" /></label>
																	 <input type="text" name="<portlet:namespace/>worksectortypeother_3" id="worksectortypeother_3" value="Other" class="form-control">
																</div>
													</div>
													<div class="col-lg-4 col-md-6" id="work-sector-div_3">
														<div class="form-group" >
															<label class="control-label required"><liferay-ui:message key="sector-name" /></label>
															  
															  <select name="<portlet:namespace/>worksector_3" id="worksector_3" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value="" selected="selected"><liferay-ui:message key="select" /></option>
															</select>
															 <%--  <input type="text" class="form-control worksector_3" id="worksector_3" name="<portlet:namespace/>worksector_3" placeholder="" autocomplete="off"/> --%>
															<p class="error-container" id="work-sector-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_3">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="sector-name-other" /></label>
															 <input type="text" name="<portlet:namespace/>worksectorother_3" id="worksectorother_3" class="form-control"> 
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_3">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="first-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>first-sub-worksector_3" id="first-sub-worksector_3" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_3">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="sub-sector-name-other" /> --%></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_3" id="work_sub_sectorother_3" class="form-control" value="">
															</div>
													</div>
													<!-- Third level -->
														<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_3">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="second-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>second-sub-worksector_3" id="second-sub-worksector_3" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_3">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="second-sub-sector-name-other" /> --%></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_3" id="worksecondsectorother_3" class="form-control" value="">
																</div>
														</div>
													<!-- Third level -->
													
													
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="region-location-institution" /></label> 
															<select name="<portlet:namespace/>wilayats_3" id="wilayats_3" class="form-control" onchange="validateField(this.id,'location-error_3','<liferay-ui:message key="please-enter-work-sector-location" />')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="wilayats" items="${wilayats}">
																	<option value="${wilayats.getKey()}">
																		<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="location-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="designation" /></label>
															 <select name="<portlet:namespace/>designations_3" id="designations_3" onchange="showDesignationOther(this.id,'designation-error_3','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="designations" items="${designations}">
																	<option value="${designations.getKey()}">
																		<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="designation-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_3">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="designation-other" /></label>
															 <input type="text" name="<portlet:namespace/>designationother_3" id="designationother_3" value="" class="form-control">
														</div>
													</div>
													<div class="col-lg-12 col-md-12">
														<div class="form-group">
															<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
															<div class="omsb-custom-html-file custom-file">
																<input id="staffIdCard_3" name="<portlet:namespace/>staffIdCard_3" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_3','<liferay-ui:message key="please-select-pdf-file" />')">
																<label class="custom-file-label" for="staffIdCard_3" id="customStaffIdCard_3"> </label>
															</div>
															<p class="error-container" id="file-size-error_3"></p>
															<p class="error-container" id="errorContainer-work-detail-file_3"></p>
														</div>
													</div>
												</div>
												<div class="bottom-backbtn-wrap"></div>
											</div>
										</div>

									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" onClick="saveWorkDetailsDetails()" type="button" title="<liferay-ui:message key='save-at-this-stage'/>"><liferay-ui:message key="save-update"/></button>
										<button class="btn omsb-bc-red-button" onClick="clearForm()" type="button" title="<liferay-ui:message key='clear'/>"><liferay-ui:message key="clear"/></button>
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
								<input type="hidden" value="" name="deleteID" id="deleteID"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<!--Add  Work Detail  Model popup -->		
		<!--delete popup for work  Detail -->
		<div class="modal fade omsb-modal" id="delete-work-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteWorkSection()" title="<liferay-ui:message key='ok'/>" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup work detail -->
		
		<!-- Add Role Service Model Popup -->
		<div class="modal fade omsb-modal" id="add-role-service-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-role-details" /></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						
				<portlet:actionURL name="<%=MVCCommands.ROLE_SERVICE_MVCACTION%>" var="roleServiceMVCActionURL"/>
					<form name="<portlet:namespace/>rnsFM" class="" id="rnsFM" action="${roleServiceMVCActionURL}" method="post">
						<div class="reg_step4 "  id="reg_step4">
									<div class="omsb-card m-0 p-0">
										<div class="omsb-page-top-info mb-4">
											<div class="pagetitle"><liferay-ui:message key="registration-role-service"/></div>
											<div class="information"><label class="reg-form-title"><%-- <liferay-ui:message key="step-four-of-four"/> --%></label></div>
										</div>
										
									</div>
									
									<div class="d-flex">
										<div class="w-50 role-section-1 d-none">
											<label class="control-label"><liferay-ui:message key="are-you-associated-with-omsb" /></label>
										</div>
										<div class="form-group  yesorno role-section-1 d-none">
											<div class="custom-control custom-radio ">
												<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_yes" value="1" checked>
												<label class="custom-control-label m-0" for="associated_yes"><liferay-ui:message key="yes" /></label>
											</div>
											
											<div class="custom-control custom-radio ">
												<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_no" value="0">
												<label class="custom-control-label m-0" for="associated_no"><liferay-ui:message key="no" /></label>
											</div>
										</div>
									</div>
									
							 <div class="omsb-card omsb-card-graybg omsb-noBorderRadius " id="associated_detail_area" >
										<div class="row ">
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="role"/></label>
													<select  name="<portlet:namespace/>role_1" id="role_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="omsbRoles" items="${omsbRoleList}">
																<%-- <option value="${omsbRoles.roleId}" <c:if test="${userMetadata.roleId == omsbRoles.roleId}">selected="selected"</c:if>> --%>
																<option value="${omsbRoles.roleId}">
																	${omsbRoles.name}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-role_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="department"/></label>
													<select  name="<portlet:namespace/>department_1" id="department_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
																<%-- <option value="${department.getKey()}"  <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>> --%>
																<option value="${department.getKey()}">
																	<liferay-ui:message key="${department.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-department_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="section"/></label>
													<select  name="<portlet:namespace/>section_1" id="section_1" class="form-control">
														<option value=""><liferay-ui:message key="select"/></option>
														<c:forEach var="section" items="${sectionList}">
																<%-- <option value="${section.getKey()}"  <c:if test="${userMetadata.sectionId == section.getKey()}">selected="selected"</c:if>> --%>
																<option value="${section.getKey()}" >
																	<liferay-ui:message key="${section.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-section_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="function"/></label>
													<select  name="<portlet:namespace/>function_1" id="function_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
																<%-- <option value="${function.getKey()}" <c:if test="${userMetadata.functionId == function.getKey()}">selected="selected"</c:if>> --%>
																<option value="${function.getKey()}">
																	<liferay-ui:message key="${function.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														
													</select>
													<p id="errorContainer-function_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_1" id="programtype_1" class="form-control" >
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
																	<%-- <option value="${programTypeMaster.programTypeMasterId}" <c:if test="${userMetadata.programTypeId == programTypeMaster.programTypeMasterId}">selected="selected"</c:if>> --%>
																	<option value="${programTypeMaster.programTypeMasterId}" >
																		<liferay-ui:message key="${programTypeMaster.programTypeName}" />
																	</option>
																</c:forEach>
														</select>
													<p id="errorContainer-programtype_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_1" id="program_1" class="form-control" >
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="program" items="${programList}">
																	<%-- <option value="${program.programMasterId}" <c:if test="${userMetadata.programId == program.programMasterId}">selected="selected"</c:if>> --%>
																	<%-- <option value="${program.programMasterId}"> --%>
																	<option value="${program.programMasterId}">
																		<liferay-ui:message key="${program.programName}" />
																	</option>
																</c:forEach>
														</select>
													<p id="errorContainer-program_1" class="error-container"></p>
												</div>
											</div>
										</div>
									</div> 
									
							 <div class="d-none" id="registrant_detail_area" >
										<div class="d-flex">
											<div class="w-50 role-section-2 d-none">
												<label class="control-label"><liferay-ui:message key="are-you-registering-for-role-or-service" /></label>
											</div>
											<div class="form-group yesorno role-section-2 d-none">
												<div class="custom-control custom-radio ">
													<input type="radio" name="<portlet:namespace/>registering" class="custom-control-input" id="registering_yes" value="1" checked>
													<label class="custom-control-label m-0" for="registering_yes"><liferay-ui:message key="role" /></label>
												</div>
												
												<%-- <div class="custom-control custom-radio ">
													<input type="radio" name="<portlet:namespace/>registering" class="custom-control-input" id="registering_no" value="0">
													<label class="custom-control-label m-0" for="registering_no"><liferay-ui:message key="service" /></label>
												</div> --%>
											</div>
										</div>

									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius " id="role_detail_area">
										<div class="row ">
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="role" /></label>
													
													<select  name="<portlet:namespace/>role_2" id="role" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="omsbRoles" items="${omsbRoleList}">
																<%-- <option value="${omsbRoles.roleId}" <c:if test="${userMetadata.roleId == omsbRoles.roleId}">selected="selected"</c:if>> --%>
																<option value="${omsbRoles.roleId}">
																	${omsbRoles.name}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-role_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="department" /></label>
													<select  name="<portlet:namespace/>department_2" id="department_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
																<%-- <option value="${department.getKey()}" <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>> --%>
																<option value="${department.getKey()}">
																	<liferay-ui:message key="${department.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-department_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="section" /></label>
													<select  name="<portlet:namespace/>section_2" id="section_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="section" items="${sectionList}">
																<%-- <option value="${section.getKey()}" <c:if test="${userMetadata.sectionId == section.getKey()}">selected="selected"</c:if>> --%>
																<option value="${section.getKey()}">
																	<liferay-ui:message key="${section.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-section_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="Committee" /></label>
													<select  name="<portlet:namespace/>committe_2" id="committe" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="committe" items="${committeList}">
																<%-- <option value="${committe.getKey()}"  <c:if test="${userMetadata.committeeId == committe.getKey()}">selected="selected"</c:if>> --%>
																<option value="${committe.getKey()}"  >
																	<liferay-ui:message key="${committe.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-committe_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label">Function</label>
													<select  name="<portlet:namespace/>function_2" id="function_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
																<%-- <option value="${function.getKey()}" <c:if test="${userMetadata.functionId == function.getKey()}">selected="selected"</c:if>> --%>
																<option value="${function.getKey()}">
																	<liferay-ui:message key="${function.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-function_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_2" id="programtype_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
																<%-- <option value="${programTypeMaster.programTypeMasterId}" <c:if test="${userMetadata.programTypeId == programTypeMaster.programTypeMasterId}">selected="selected"</c:if>> --%>
																<option value="${programTypeMaster.programTypeMasterId}">
																	<liferay-ui:message key="${programTypeMaster.programTypeName}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-programtype_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_2" id="program_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="program" items="${programList}">
																<%-- <option value="${program.programMasterId}" <c:if test="${userMetadata.programId == program.programMasterId}">selected="selected"</c:if>> --%>
																<option value="${program.programMasterId}" >
																	${program.programName}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-program_2" class="error-container"></p>
												</div>
											</div>
																					
										</div>
									</div>
									 
								</div> 
									 <div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button"  onClick="saveRoleService()"  type="button" title="<liferay-ui:message key='save-update' />"><liferay-ui:message key="save-update" /></button> 
										<%-- <button class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('next')" type="button" title="<liferay-ui:message key='next' />"><liferay-ui:message key='next' /></button> --%>
										<button id="role-service-back-button" class="go-pervious btn omsb-btn omsb-bg-red-button " type="button" title="<liferay-ui:message key='back' />" data-pervious="reg_step3"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key='back' /></button>
									</div> 
								</div>
									<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
									<input id="lrUserId" type="hidden" name="<portlet:namespace/>lrUserId" value="${lrUserId}"/>
									<input id="txtIndex" type="hidden" name="<portlet:namespace/>index" value="1"/>
									<input id="isAssosiated" type="hidden" name="<portlet:namespace/>assosiated" value="true"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Add Role Service Model Popup -->
		
		<!--delete popup for role  service -->
		<div class="modal fade omsb-modal" id="delete-role-service-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteRoleServiceSection()" title="<liferay-ui:message key='ok'/>" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup role  service -->
<portlet:resourceURL id="<%=MVCCommands.VERIFY_USERNAME%>" var="verifyUsernameURL" />
<portlet:resourceURL id="<%=MVCCommands.SEND_OTP%>" var="sendOTPURL" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_OTP%>" var="verifyOTPURL" />

<portlet:resourceURL id="<%=MVCCommands.SECTION_DEPARTMENT_MVC_RESOURCE%>" var="sectionDepartmentURL" />		
<portlet:resourceURL id="<%=MVCCommands.FUNCTION_SECTION_COMMITTEE_MVC_RESOURCE%>" var="functionSectioncommitteURL" />		
<portlet:resourceURL id="<%=MVCCommands.PROGRAM_TYPE_MVC_RESOURCE%>" var="programTypeURL" />

<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="saveEducationDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_EDUCATION_DETAILS_SR%>" var="getEducationDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="deleteEducationDetailsURL" />

<input id="userMetadataId" type="hidden" name="<portlet:namespace/>userMetadataId" value="${userMetadata.id}"/>
<input id="isAssociated" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.associated}"/>
<input id="isregisteringForRole" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.registeringForRole}"/>

<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_WORKSECTOR_TYPE%>" var="getWorkSectorByWorkSectorType" />
<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_PARENT_WORK_SECTOR%>" var="getWorkSectorByParentWorkSector" />

<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_WORK_DETAILS_SR%>" var="getWorkDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_WORK_DETAILS_SR%>" var="saveWorkDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_WORK_DETAILS_SR%>" var="deleteWorkDetailsURL" />

<!-- Role Service URL'S -->
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_ROLE_SERVICE_SR%>" var="saveRoleServiceURL" />	
<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_ROLE_SERVICE_SR%>" var="deleteRoleServiceURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_ROLE_SERVICE_SR%>" var="getRoleServiceURL" />
<!-- Role Service URL'S -->
<portlet:resourceURL id="<%=MVCCommands.FETCH_SPECIALITY_BY_PROFESSION%>" var="professionListURL" />	

<script type="text/javascript">
 var phone1 = document.querySelector("#mobileNumber");
var hiddenCountryInput = document.querySelector("#hiddenCountryCode");
var hiddenCountryIsoCode = document.querySelector("#hiddenCountryIsoCode");
var itl = '';

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
	
}, 200);

phone1.addEventListener("countrychange",function() {
	var selectedCountry = itl.getSelectedCountryData();
	console.log("selectedCountry :::",selectedCountry);
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
});  

var index=1;
$(document).ready(function() {
	/* if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    } */
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
    $("#function_1").select2();
    $("#programtype_1").select2();
    $("#program_1").select2();
    $("#role").select2();
    $("#department_2").select2();
    $("#section_2").select2();
    $("#committe").select2();
    $("#function_2").select2();
    $("#programtype_2").select2();
    $("#program_2").select2();
    $("#service").select2();
    $("#qualification").select2();
    $("#institution").select2();
    $("#country").select2();
    $("#year").select2();
    
    $("#registration-cancel").click(function(){
    	console.log('${themeDisplay.getPortalURL()}'+'/group/guest/dashboard');
		window.location.href='${themeDisplay.getPortalURL()}'+'/group/guest/dashboard';
	});
    

/* 	 function showOtherField(id,errorId,errorMessage){
		 var substring=substring=id;
		
		 let selectedValue= $("#"+id).find('option:selected').val();
		 if(selectedValue.trim() === 'other'){
			 $('#'+id+other).removeClass('d-none');
		 }
		 else{
			 $('#'+id+other).addClass('d-none');
			}
		 validateField(id,errorId,errorMessage);
	} */

    function showOtherField(id,errorId,errorMessage){
   	 var substring=substring=id;   	
   	 let selectedValue= $("#"+id).find('option:selected').val();
   
   	 if(selectedValue.trim() === 'other'){
   		 console.log('#'+id+"otherDiv");
   		 $('#'+id+"OtherDiv").removeClass('d-none');
   	 }
   	 else{
   		 $('#'+id+"OtherDiv").addClass('d-none');
   		}
    validateField(id,errorId,errorMessage);   	 
   }
	
	const minDate = new Date();
	minDate.setDate(minDate.getDate() + 1);
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
				if(response.isValid){
					document.getElementById(verificationTypeField).setAttribute('readonly','readonly');
					document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = "<liferay-ui:message key='otp-sent-successfully' />";
				} else {
					//document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = '<liferay-ui:message key="'+verificationTypeField+'-already-exist" />';
					if(verificationTypeField=="emailAddress"){
						document.getElementById("errorContainer-"+verificationTypeField+"OTP").textContent = '<liferay-ui:message key="emailAddress-already-exist" />';
						      }
						else{
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

var isEditable = false;
$( document ).ready(function() {
    
var designation_1=$("#designations_1").val();
var designation_2=$("#designations_2").val();
if(designation_1=="other"){
	 $('#designationotherdiv_1').removeClass('d-none');
}
else{
	  $("#designationother_1").val('');
	 $('#designationotherdiv_1').addClass('d-none');
}
if(designation_2=="other"){
	 $('#designationotherdiv_2').removeClass('d-none');
}
else{
	$("#designationother_2").val('');
	 $('#designationotherdiv_2').addClass('d-none');
}
});

function validateAndSaveFormData(button) {
	var isErrorOccured=false;
	var errorMessages = [];	
	if(${empty person.civilId && not empty person.passportNumber}){
	var countryOfIssue = document.getElementById("countryOfIssue").value;
	if (!countryOfIssue) {
		errorMessages.push("<liferay-ui:message key='please-select-country-of-issue' />");
		document.getElementById("errorContainer-countryOfIssue").textContent = "<liferay-ui:message key='please-select-country-of-issue' />";
		if(!isErrorOccured){
			$("#countryOfIssue").focus();
			isErrorOccured=true;
		}
	} else {
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
	} else {
		document.getElementById("errorContainer-passportExpiryDate").textContent = "";
	}
	}
	  if(${not empty person.civilId}){
		  console.log()
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
	  else{
		  console.log("inside else condition ");
	var firstName = document.getElementById("firstName").value;
	if (!firstName) {
		errorMessages.push("<liferay-ui:message key='please-enter-firstname' />");
		document.getElementById("errorContainer-firstName").textContent = "<liferay-ui:message key='please-enter-firstname' />";
		if(!isErrorOccured){
			$("#firstName").focus();
			isErrorOccured=true;
		}
	} else {
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
	} else {
		document.getElementById("errorContainer-lastName").textContent = "";
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
	
	/* 	var photo = document.getElementById("photo").files[0];
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
		}
		  else{
		    	 console.log("inside else conditon");
		    	 document.getElementById("errorContainer-photo").textContent = "";
		    	 document.getElementById("errorContainer-photo").textContent ="<liferay-ui:message key='please-select-image' />";
		    	 errorMessages.push("<liferay-ui:message key='please-select-image' />");
		     }
	} */
	/* } */
	
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
	
	
	
/* -----------------------------Employment Detail  start validation--------------------------------- */	
	
//	var isEmployed= $("input[name = '<portlet:namespace/>employed']:checked").val();
//	if(isEmployed ==1){
		   console.log("inside validVerification field function");
			var workSectorTypeId=$("#workSectorType_1").val();
			if(!workSectorTypeId || workSectorTypeId===""){
				errorMessages.push("<liferay-ui:message key='please-enter-work-sector-type' />");
				$("#work-sector-type-error_1").html("<liferay-ui:message key='please-enter-work-sector-type' />");
				if(!isErrorOccured){
					$("#workSectorType_1").focus();
					isErrorOccured=true;
				}
			}
			else{
				$("#work-sector-type-error_1").html("");
			}
			
			 var workSector=$("#worksector_1").val();
			 console.log(workSector);
			 var workSectorparentClass=$('#worksector_1').parent().attr('class');
				//var workSectorparentClass=$('#worksector_1').parent().find('d-none');
				console.log("workSectorparentClass ::::",workSectorparentClass.includes('d-none'));
				
				if(!workSectorparentClass.includes('d-none')){
					console.log("False value");
					if(!workSector || workSector===""){
						console.log("inside if conditon worksector :  location-error_");
						errorMessages.push("<liferay-ui:message key='please-enter-work-sector' />");
						$("#work-sector-error_1").html("<liferay-ui:message key='please-enter-work-sector' />");
						if(!isErrorOccured){
							$("#worksector_1").focus();
							isErrorOccured=true;
						}
					}
					else{
						$("#work-sector-error_1").html("");
					}
				}
			
			var wilayats=$("#wilayats_1").val();
			if(!wilayats || wilayats===""){
				console.log("inside if conditon worksector :  work-sector-error_");
				errorMessages.push("<liferay-ui:message key='please-enter-work-sector-location' />");
				$("#location-error_1").html("<liferay-ui:message key='please-enter-work-sector-location' />");
				if(!isErrorOccured){
					$("#wilayats_1").focus();
					isErrorOccured=true;
				}
			}
			else{
				$("#location-error_1").html("");
			}
			var designations=$("#designations_1").val();
			if(!designations || designations ===""){
				console.log("inside if conditon worksector :  designations_");
				errorMessages.push("<liferay-ui:message key='please-enter-designation' />");
				$("#designation-error_1").html("<liferay-ui:message key='please-enter-designation' />");
				if(!isErrorOccured){
					$("#designations_1").focus();
					isErrorOccured=true;
				}
			}
			else{
				$("#designation-error_1").html("");
			}
			var staffCardId = document.getElementById("staffIdCard_1");
			console.log("staffCardId :: "+staffCardId);
			if(staffCardId.files[0]){
				if(!isEditable){
			console.log('size : '+staffCardId.files[0].size);	
			 var filename = staffCardId.files[0].name;
		     var extension = filename.substr(filename.lastIndexOf("."));
			//  var allowedExtensionsRegex=new RegExp("(.*?)\.(pdf)$");
			 allowedExtensionsRegex = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
			  var isAllowed = allowedExtensionsRegex.test(extension);
			     if(isAllowed){
			    	 console.log("insid is allowed if");
			    	 document.getElementById("file-size-error_1").textContent ="";
			    		const size = (staffCardId.files[0].size / 1024 / 1024).toFixed(2);
						console.log(size);
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
			    	 console.log("inside else conditon");
			    	 document.getElementById("file-size-error_1").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
			    	 errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
			    	 if(!isErrorOccured){
							$("#staffIdCard_1").focus();
							isErrorOccured=true;
						}
			     }
			
		}
				else{
					isEditable=false;
					document.getElementById("file-size-error_1").textContent = "";
				}
		}
			else{
				isEditable=false;
				document.getElementById("file-size-error_1").textContent = "";
			}
//	}
	
	
	var staffCardId_2 = document.getElementById("staffIdCard_2");
	console.log("staffCardId :: "+staffCardId_2);
	if(staffCardId_2.files[0]){
		if(!isEditable){
	console.log('size : '+staffCardId_2.files[0].size);	
	 var filename_2 = staffCardId_2.files[0].name;
     var extension_2 = filename_2.substr(filename_2.lastIndexOf("."));
	//  var allowedExtensionsRegex_2=new RegExp("(.*?)\.(pdf)$");
	  allowedExtensionsRegex_2 = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
	  var isAllow = allowedExtensionsRegex_2.test(extension_2);
	     if(isAllow){
	    	 console.log("insid is allowed if");
	    	 document.getElementById("file-size-error_2").textContent ="";
	    		const size = (staffCardId_2.files[0].size / 1024 / 1024).toFixed(2);
				console.log(size);
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
	    	 console.log("inside else conditon");
	    	 document.getElementById("file-size-error_2").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
	    	 errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
	    	 if(!isErrorOccured){
					$("#staffIdCard_2").focus();
					isErrorOccured=true;
				}
	     }
	
}
		else{
			isEditable=false;
			document.getElementById("file-size-error_2").textContent = "";
		}
}
	else{
		isEditable=false;
		document.getElementById("file-size-error_2").textContent = "";
	}
	
/* ----------------------employment detail field validation end------------------------- */	
	
//For role service 
	
	/*var isOMSBAssociated=false;
	 var roleRegistration=false;
	 if(document.getElementById('associated_yes').checked) {
		 isOMSBAssociated=true;
		}else if(document.getElementById('associated_no').checked) {
			isOMSBAssociated=false;
		}
	 
	 	console.log("isOMSBAssociated ::::",isOMSBAssociated);
	 	if(isOMSBAssociated){
	 		var role_1 = document.getElementById("role_1").value;
			if (!role_1) {
				errorMessages.push("<liferay-ui:message key='please-select-role' />");
				document.getElementById("errorContainer-role_1").textContent = "<liferay-ui:message key='please-select-role' />";
			} else {
				document.getElementById("errorContainer-role_1").textContent = "";
			}
	 		
			var department_1 = document.getElementById("department_1").value;
			if (!department_1) {
				errorMessages.push("<liferay-ui:message key='please-select-department' />");
				document.getElementById("errorContainer-department_1").textContent = "<liferay-ui:message key='please-select-department' />";
			} else {
				document.getElementById("errorContainer-department_1").textContent = "";
			}
			
			
			var section_1 = document.getElementById("section_1").value;
			if (!section_1) {
				errorMessages.push("<liferay-ui:message key='please-select-section' />");
				document.getElementById("errorContainer-section_1").textContent = "<liferay-ui:message key='please-select-section' />";
			} else {
				document.getElementById("errorContainer-section_1").textContent = "";
			}
			
			
			var function_1 = document.getElementById("function_1").value;
			if (!function_1) {
				errorMessages.push("<liferay-ui:message key='please-select-function' />");
				document.getElementById("errorContainer-function_1").textContent = "<liferay-ui:message key='please-select-function' />";
			} else {
				document.getElementById("errorContainer-function_1").textContent = "";
			}
			
			
			var programtype_1 = document.getElementById("programtype_1").value;
			if (!programtype_1) {
				errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
				document.getElementById("errorContainer-programtype_1").textContent = "<liferay-ui:message key='please-select-program-type' />";
			} else {
				document.getElementById("errorContainer-programtype_1").textContent = "";
			}
			
			var program_1 = document.getElementById("program_1").value;
			if (!program_1) {
				errorMessages.push("<liferay-ui:message key='please-select-program' />");
				document.getElementById("errorContainer-program_1").textContent = "<liferay-ui:message key='please-select-program' />";
			} else {
				document.getElementById("errorContainer-program_1").textContent = "";
			}
	 		
	 	}else{
	 		var roleRegistration=false;
	 		
		 	if(document.getElementById('registering_yes').checked) {
			roleRegistration=true;
			}else if(document.getElementById('registering_no').checked) {
				roleRegistration=false;
			}
	 		
		 	
		 	if(roleRegistration){
		 		var role = document.getElementById("role").value;
				if (!role) {
					errorMessages.push("<liferay-ui:message key='please-select-role' />");
					document.getElementById("errorContainer-role_2").textContent = "<liferay-ui:message key='please-select-role' />";
				} else {
					document.getElementById("errorContainer-role_2").textContent = "";
				}
		 		
				var department_2 = document.getElementById("department_2").value;
				if (!department_2) {
					errorMessages.push("<liferay-ui:message key='please-select-department' />");
					document.getElementById("errorContainer-department_2").textContent = "<liferay-ui:message key='please-select-department' />";
				} else {
					document.getElementById("errorContainer-department_2").textContent = "";
				}
				
				
				var section_2 = document.getElementById("section_2").value;
				if (!section_2) {
					errorMessages.push("<liferay-ui:message key='please-select-section' />");
					document.getElementById("errorContainer-section_2").textContent = "<liferay-ui:message key='please-select-section' />";
				} else {
					document.getElementById("errorContainer-section_2").textContent = "";
				}
				
				
				var committe = document.getElementById("committe").value;
				if (!committe) {
					errorMessages.push("<liferay-ui:message key='please-select-committe' />");
					document.getElementById("errorContainer-committe_2").textContent = "<liferay-ui:message key='please-select-committe' />";
				} else {
					document.getElementById("errorContainer-committe_2").textContent = "";
				}
				
				
				var function_2 = document.getElementById("function_2").value;
				if (!function_2) {
					errorMessages.push("<liferay-ui:message key='please-select-function' />");
					document.getElementById("errorContainer-function_2").textContent = "<liferay-ui:message key='please-select-function' />";
				} else {
					document.getElementById("errorContainer-function_2").textContent = "";
				}
				
				
				var programtype_2 = document.getElementById("programtype_2").value;
				if (!programtype_2) {
					errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
					document.getElementById("errorContainer-programtype_2").textContent = "<liferay-ui:message key='please-select-program-type' />";
				} else {
					document.getElementById("errorContainer-programtype_2").textContent = "";
				}
				
				var program_2 = document.getElementById("program_2").value;
				if (!program_2) {
					errorMessages.push("<liferay-ui:message key='please-select-program' />");
					document.getElementById("errorContainer-program_2").textContent = "<liferay-ui:message key='please-select-program' />";
				} else {
					document.getElementById("errorContainer-program_2").textContent = "";
				}
				
		 		
		 	}else{
		 		var service = document.getElementById("service").value;
				if (!service) {
					errorMessages.push("<liferay-ui:message key='please-select-service' />");
					document.getElementById("errorContainer-service").textContent = "<liferay-ui:message key='please-select-service' />";
				} else {
					document.getElementById("errorContainer-service").textContent = "";
				}
		 	}
	 		
	 	}*/

	console.log(errorMessages);
	console.log("------------------tt ----");
	
	if (errorMessages.length > 0) {
		event.preventDefault();
	} else {
		console.log("*inside else :::");
		//For Educational Details element counter
		elementCount();
		document.getElementById("rdFM").submit();
	}
}


//Educational Detail 
function elementCount(){
	$('.element').each(function() {
    	 var id = $(this).attr('id');
    	 console.log("id ::::::::",id);
    	var split_id = id.split("_");
      console.log("split_id :::",split_id);
      var index = Number(split_id[2]);
      console.log("index :::",index);
      rowIndexer.push(index);
    });
	console.log("rowIndexer :::::",rowIndexer);
	$('#counter').val(rowIndexer.join(","));
	
	console.log("rowIndexer :::::",$('#counter').val());
}


var list = ${qualificationArray};
var institutionList=${institutionList};
var customCountries=${countryArray};
var rowIndexer=[];
var imagePath=$('#imagePath').val();
var qualificationHtml='';
var institutionHtml='';
var countryHtml='';
	
/* function edu_delete(){
	$('.edu_delete').click(function() {
		$(this).parent().parent().parent().remove();
	});
} */

$(document).on('change','.custom-file-input', function () {
	var fileName = $(this).val().split("\\").pop();
	
	console.log("fileName ::::",fileName);
	$(this).siblings(".custom-file-label").html(fileName);
});
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
			
			/* function showDesignationOther(id,errorId,errorMessage){
				console.log(id);
				 var substring=id.substr ( id.indexOf ( '_' ) + 1 );
				
				 let selectedDesignation= $("#"+id).find('option:selected').val();
				 console.log("after substring :"+selectedDesignation);
				 if(selectedDesignation.trim() === 'other'){
					 console.log("inside if condition +++++ ");
					 $('#designationotherdiv_'+substring).removeClass('d-none');
				 }
				 else{
					 console.log("inside else condtion ++++ ");
					 $('#designationotherdiv_'+substring).addClass('d-none');
					}
			if(id=="designations_1"){
				console.log("inside if condition");
				 validateField(id,errorId,errorMessage);
			}
				 
			} */
			
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

function showDesignationOther(id,errorId,errorMessage){
	 var substring=substring=id.substr ( id.indexOf ( '_' ) + 1 );
	
	 let selectedDesignation= $("#"+id).find('option:selected').val();
	 console.log("after substring :"+selectedDesignation);
	 if(selectedDesignation.trim() === 'other'){
		 console.log("inside if condition +++++ ");
		 $('#designationotherdiv_'+substring).removeClass('d-none');
	 }
	 else{
		 console.log("inside else condtion ++++ ");
		 $('#designationotherdiv_'+substring).addClass('d-none');
		}
	// }
	 validateField(id,errorId,errorMessage);
	 
}
	
function validateField(elementId,errorId,error){
	var fieldValue=$("#"+elementId).val();
	console.log(elementId+" ---  "+errorId+ " --- "+error);
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

function openDeleteModal(id){
	console.log("id :: "+id);
	$("#delete-confirm-modal").data("id",id);
}
function openEduOpenDeleteModal(id){
	console.log("id :: "+id);
	$("#delete-education-confirm-modal").data("id",id);
}
function openEduOpenAddModel(id){
	console.log("id :: "+id);
	document.getElementById("qualification").value = "";
	document.getElementById("institution").value = "";
	document.getElementById("country").value = "";
	//document.getElementById("gpa").value = "";
	document.getElementById("year").value = "";
	document.getElementById("id").value = '';
	document.getElementById("qualificationdoclbl").innerHTML = '';
	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
	//document.getElementById("errorContainer-gpa").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	document.getElementById("view-file").setAttribute("href","");
	$("#view-div").addClass("d-none");
	$("#add-education-confirm-modal").data("id",id);
}

function openWorkDetailOpenAddModel(id){
	console.log("work detail id :: "+id);
	document.getElementById("workSectorType_3").value = '';
	document.getElementById("worksectortypeother_3").value = '';
	document.getElementById("worksector_3").value = '';
	document.getElementById("worksector_3").innerHTML = "<option value=''><liferay-ui:message key='select'/></option>";
	
	document.getElementById("worksectorother_3").value = '';
	document.getElementById("first-sub-worksector_3").value = '';
	document.getElementById("worksectorother_3").value = '';
	document.getElementById("wilayats_3").value = '';
	document.getElementById("designations_3").value = '';
	document.getElementById("customStaffIdCard_3").innerHTML = '';
	//document.getElementById("qualification").value = "";
	//document.getElementById("institution").value = "";
	//document.getElementById("country").value = "";
	//document.getElementById("gpa").value = "";
	//document.getElementById("year").value = "";
	//document.getElementById("id").value = '';
	//document.getElementById("qualificationdoclbl").innerHTML = '';
	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
	//document.getElementById("errorContainer-gpa").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	document.getElementById("view-file").setAttribute("href","");
	
	$("#div-o3-work-other_3").addClass("d-none");
	$("#div-first-sub-sector_3").addClass("d-none");
	
	$("#view-div").addClass("d-none");
	$("#add-work-detail-confirm-modal").data("id",id);
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

function saveEducationDetails(){
	if(isValidVerificationField()){
		var qualification = $("#qualification").val().trim();
		var institution = $("#institution").val().trim();
		var country = $("#country").val().trim();
		//var gpa = $("#gpa").val().trim();
		var year = $("#year").val().trim();
		var id = $("#id").val().trim();
		var personId = $("#personId").val().trim();
		var lrUserId = $("#lrUserId").val().trim();
		
		var uploadFile = document.getElementById("qualificationdoc").files[0];
		var formData = new FormData();
		formData.append('<portlet:namespace />qualificationDoc', uploadFile);
		formData.append('<portlet:namespace />qualification', qualification);
		formData.append('<portlet:namespace />institution', institution);
		formData.append('<portlet:namespace />country', country);
		//formData.append('<portlet:namespace />gpa', gpa);
		formData.append('<portlet:namespace />year', year);
		formData.append('<portlet:namespace />id', id);
		formData.append('<portlet:namespace />personId', personId);
		formData.append('<portlet:namespace />lrUserId', lrUserId);
		console.log("saveEducationDetails called :::");
		
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
				//document.getElementById("gpa").value = "";
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

//Save/edit work details
function saveWorkDetailsDetails(){
//	if(isValidVerificationField()){
		
		console.log("inside verified called::");
		
		var workSectorType_3 = $("#workSectorType_3").val().trim();
		var worksectortypeother_3 = $("#worksectortypeother_3").val().trim();
		var worksector_3 = $("#worksector_3").val().trim();
		var worksectorother_3 = $("#worksectorother_3").val().trim();
		
		var first_sub_worksector_3 = $("#first-sub-worksector_3").val().trim();
		var work_sub_sectorother_3 = $("#work_sub_sectorother_3").val().trim();
		
		
		var second_sub_worksector_3 = $("#second-sub-worksector_3").val().trim();
		var worksecondsectorother_3 = $("#worksecondsectorother_3").val().trim();
		
		
		
		
		var wilayats_3 = $("#wilayats_3").val().trim();
		var designations_3 = $("#designations_3").val().trim();
		var designationother_3 = $("#designationother_3").val().trim();
		var id = $("#id").val().trim();
		var personId = $("#personId").val().trim();
		var lrUserId = $("#lrUserId").val().trim();
		
		console.log("id :::",id);
		console.log("first_sub_worksector_3 :::",first_sub_worksector_3);
		console.log("designationother_3 :::",designationother_3);
		console.log("lrUserId :::",lrUserId);
		console.log("second-sub-worksector_3 :::",second_sub_worksector_3);
		console.log("worksecondsectorother_3 :::",worksecondsectorother_3);
		
		var uploadFile = document.getElementById("staffIdCard_3").files[0];
		var formData = new FormData();
		formData.append('<portlet:namespace />staffIdCard_3', uploadFile);
		formData.append('<portlet:namespace />workSectorType_3', workSectorType_3);
		formData.append('<portlet:namespace />worksectortypeother_3', worksectortypeother_3);
		formData.append('<portlet:namespace />worksector_3', worksector_3);
		formData.append('<portlet:namespace />worksectorother_3', worksectorother_3);
		formData.append('<portlet:namespace />first_sub_worksector_3', first_sub_worksector_3);
		formData.append('<portlet:namespace />work_sub_sectorother_3', work_sub_sectorother_3);
		formData.append('<portlet:namespace />second_sub_worksector_3', second_sub_worksector_3);
		formData.append('<portlet:namespace />worksecondsectorother_3', worksecondsectorother_3);
		formData.append('<portlet:namespace />wilayats_3', wilayats_3);
		formData.append('<portlet:namespace />designations_3', designations_3);
		formData.append('<portlet:namespace />designationother_3', designationother_3);
		formData.append('<portlet:namespace />id', id);
		formData.append('<portlet:namespace />personId', personId);
		formData.append('<portlet:namespace />lrUserId', lrUserId);
		
		console.log("saveWork details  called :::");
		
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
				//document.getElementById("qualification").value = "";
				//document.getElementById("institution").value = "";
				//document.getElementById("country").value = "";
				//document.getElementById("gpa").value = "";
				//document.getElementById("year").value = "";
				//document.getElementById("id").value = '';
				//document.getElementById("qualificationdoclbl").innerHTML = '';
				$("#workDetailList").html(data);
				$('#work-detail-list1').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
				$("#add-work-detail-confirm-modal").modal('hide');
			},
		})
	//}else{
	//	console.log("not called:::::");
	//}
}

function deleteEduSection(){
	var deleteId = document.getElementById("deleteID").value;
	var personId = document.getElementById("personId").value;
	if(deleteId){
		$.ajax({
			url: '${deleteEducationDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : deleteId,
				<portlet:namespace />personId : personId 
			},
			type : 'POST',
			success : function(data) {
				isEdit=false;
				$('#delete-education-confirm-modal').modal('hide');
				document.getElementById("qualification").value = "";
				document.getElementById("institution").value = "";
				document.getElementById("country").value = "";
				//document.getElementById("gpa").value = "";
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
				//document.getElementById("gpa").value = "";
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

function setDeleteID(id){
	document.getElementById("deleteID").value = id;
}

function setEditID(id){
	if(id){
		document.getElementById("qualification").value = '';
		document.getElementById("institution").value = '';
		document.getElementById("country").value = '';
		//document.getElementById("gpa").value = '';
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
					console.log(educationDetails.documentInfo.documentURL);
					document.getElementById("qualification").value = educationDetails.qualificationAttained;
					document.getElementById("institution").value = educationDetails.issuingAuthorityName;
					document.getElementById("country").value = educationDetails.issuingAuthorityCountryId;
					//document.getElementById("gpa").value = educationDetails.gpa;
					document.getElementById("year").value = educationDetails.yearOfGraduation;
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
	console.log("setWorkDetailEditID :::" ,id);
	
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
		//$("#view-div").removeClass("d-none");
		$.ajax({
			url: '${getWorkDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : id,
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				
				console.log("response ::,",response);
				if(response.isValid){
					const workDetails = JSON.parse(response.workDetail);
					const workSectorData = JSON.parse(response.workSectorData);
					const workSectorData2 = JSON.parse(response.workSectorData2);
					const workSectorData3 = JSON.parse(response.workSectorData3);
					document.getElementById("workSectorType_3").value = workDetails.workSectorType;
					document.getElementById("wilayats_3").value = workDetails.workSectorLocation;
					document.getElementById("designations_3").value = workDetails.designationId;
					document.getElementById("year").value = workDetails.yearOfGraduation;
					document.getElementById("id").value = workDetails.id;
					document.getElementById("view-file").setAttribute("href",workDetails.documentUrl);
					
					
					console.log("workDetails ::,",workDetails);
					//third level 
					/* if(workDetails.workSectorId3 != null && workDetails.workSectorId3 != ''){
						$("#div-second-sub-sector_3").removeClass("d-none");
						document.getElementById("second-sub-worksector_3").value = workDetails.workSectorId3;
					}
					
					
					if(workDetails.workSectorOther3 != null  && workDetails.workSectorOther3 != ''){
						$("#div-o3-secons-work-other_3").removeClass("d-none");
						document.getElementById("worksecondsectorother_3").value = workDetails.workSectorOther3;
						
						$("#div-second-sub-sector_3").removeClass("d-none");
						document.getElementById("second-sub-worksector_3").value = 'other';
					}
					 */
					
					
					//For Sub sector Other 
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
					//For Sub sector
					if(workDetails.workSectorId2 !=null && workDetails.workSectorId2!= ''){
						updateOtherDropdown(workSectorData2,"first-sub-worksector_3");
						document.getElementById("first-sub-worksector_3").value = workDetails.workSectorId2;
						$("#div-first-sub-sector_3").removeClass("d-none");
						$("#worksectorTypediv_3").addClass("d-none");						
						document.getElementById("work_sub_sectorother_3").value ='';						
						$("#div-o3-work-other_3").addClass("d-none");
						$("#div-o2-work-other_3").addClass("d-none");
						$("#work-sector-div_3").removeClass("d-none");
						
						
						//For second sub sector
						if(workDetails.workSectorId3 != null && workDetails.workSectorId3 != ''){
							$("#div-second-sub-sector_3").removeClass("d-none");
							console.log("Inside third level other ");
							updateOtherDropdown(workSectorData3,"second-sub-worksector_3");
							document.getElementById("second-sub-worksector_3").value = workDetails.workSectorId3;
						}
						
						if(workDetails.workSectorOther3 != null  && workDetails.workSectorOther3 != ''){
							
							console.log("Inside third level");
							$("#div-o3-secons-work-other_3").removeClass("d-none");
							document.getElementById("worksecondsectorother_3").value = workDetails.workSectorOther3;
							
							$("#div-second-sub-sector_3").removeClass("d-none");
							document.getElementById("second-sub-worksector_3").value = 'other';
						}
						
					}
					
					//For sector Other 
					if(workDetails.workSectorOther !=null && workDetails.workSectorOther !=''){
						console.log("3");
						document.getElementById("worksector_3").value ='other';
						$("#div-o2-work-other_3").removeClass("d-none");
						$("#work-sector-div_3").removeClass("d-none");
						$("#worksectorTypediv_3").addClass("d-none");
						document.getElementById("worksectorother_3").value =workDetails.workSectorOther;
						
						$("#div-first-sub-sector_3").addClass("d-none");
						$("#div-o3-work-other_3").addClass("d-none");
						document.getElementById("work_sub_sectorother_3").value = '';
					}
					
					//For sector 
					if(workDetails.workSectorId != null && workDetails.workSectorId != ''){
						console.log("4");
						updateOtherDropdown(workSectorData,"worksector_3");
						document.getElementById("worksector_3").value = workDetails.workSectorId;
						$("#worksectorTypediv_3").addClass("d-none");
						
						if(workDetails.workSectorOther2 ==null && workDetails.workSectorOther2==''){
							$("#div-o3-work-other_3").addClass("d-none");
							document.getElementById("work_sub_sectorother_3").value = '';
						}else if((workDetails.workSectorId2 ==null || workDetails.workSectorId2== '')  && (workDetails.workSectorOther2 ==null && workDetails.workSectorOther2=='')){
							$("#div-first-sub-sector_3").addClass("d-none");
						}
					}
					
					//For Work Sector Type other 
					if(workDetails.workSectorTypeOther != null && workDetails.workSectorTypeOther !=''){
						
						//Sector Div hide 
						$("#work-sector-div_3").addClass("d-none");
						$("#div-o2-work-other_3").addClass("d-none");
						
						//Sector sub div hide 
						$("#div-first-sub-sector_3").addClass("d-none");
						$("#div-o3-work-other_3").addClass("d-none");
						
						//Work Sector type
						$("#worksectorTypediv_3").removeClass("d-none");
						document.getElementById("worksectortypeother_3").value = workDetails.workSectorTypeOther;
						
						$("#div-second-sub-sector_3").addClass("d-none");
						$("#div-o3-secons-work-other_3").addClass("d-none");
						
					}
					
					if(workDetails!=null){
						console.log("Not null 1");
						if(workDetails.documentUrl!=null){
							console.log("Not null 2");
							if(workDetails.uploadFileName!=null){
								console.log("Not null 3");
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
	
	/* var gpa = document.getElementById("gpa").value.trim();
	if (!gpa) {
		errorMessages.push("<liferay-ui:message key='please-enter-gpa' />");
		document.getElementById("errorContainer-gpa").textContent = "<liferay-ui:message key='please-enter-gpa' />";
	} else {
		document.getElementById("errorContainer-gpa").textContent = "";
	} */
	
	var year = document.getElementById("year").value;
	if (!year) {
		errorMessages.push("<liferay-ui:message key='please-select-year-of-graduation' />");
		document.getElementById("errorContainer-year-of-graducation").textContent = "<liferay-ui:message key='please-select-year-of-graduation' />";
	} else {
		document.getElementById("errorContainer-year-of-graducation").textContent = "";
	}
	
	var qualificationDoc = document.getElementById("qualificationdoc").files[0];
	console.log(!qualificationDoc);
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
					console.log(size);
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
    else{
   	 //allowedExtensionsReg=new RegExp("(.*?)\.(pdf)$");
    	allowedExtensionsReg = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
    }
    var isAllowed = allowedExtensionsReg.test(extension);

    if(isAllowed){
   	 $("#"+errorId).html("");
    }else{
   	 $("#"+errorId).text(errorMessage);
    }
}
//Work detail functions
function getWorkSector(id){
	        	var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 console.log("selectedvlaue ");
				 console.log(selectedValue);
				 
				 
				 $('#div-o3-work-other_'+substring).addClass('d-none');
				 $('#div-o2-work-other_'+substring).addClass('d-none');
				 
				 if(selectedValue){
					 console.log("selectedValue :: "+selectedValue);
					 //else{
						 $('#worksectorTypediv_'+substring).addClass('d-none'); 
						 
					 $.ajax({
							url: '${getWorkSectorByWorkSectorType}',
							async : false,
							data : {
								<portlet:namespace />workSectorType : selectedValue
							},
							type : 'POST',
							success : function(data) {
								console.log(data);
								var options = JSON.parse(data);
								console.log("options ::::::",options[0].id);
								
								 
								if(options[0].id=="other"){
									 console.log(substring+" --------------");
									 $('#worksectorTypediv_'+substring).removeClass('d-none');
									 $('#work-sector-div_'+substring).addClass('d-none');
									 $('#div-first-sub-sector_'+substring).addClass('d-none');
									 $('#div-o3-work-other_'+substring).addClass('d-none');
									 $('#div-o2-work-other_'+substring).addClass('d-none');
									 
									 //Third level
									  $('#div-second-sub-sector_'+substring).addClass('d-none');
									  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
									  $('#div-first-sub-sector_'+substring).addClass('d-none');
									 
								 }else{
									 updateOtherDropdown(options,"worksector_"+substring);
									 $('#work-sector-div_'+substring).removeClass('d-none'); 
									 
									 //Third level
									  $('#div-second-sub-sector_'+substring).addClass('d-none');
									  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
									  $('#div-first-sub-sector_'+substring).addClass('d-none');
								 }
								
							}
					 });
					 //}
				 }else{
						console.log("inside else ::::"); 
						
						
						
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
				 console.log("selectedvlaue ");
				 console.log(selectedValue);
				 console.log("field :::::",field);
				 console.log("selectedValue :: "+selectedValue);
				 console.log("substring :: "+substring);
				 
				
				 if(selectedValue){
					 
					 
					 $("#div-second-sub-sector_"+substring).addClass('d-none');	
					 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
					 
					 
					 if(selectedValue =='other'){
						 console.log("inside other ::::::::");
						 //$('#div-work-other_'+substring).removeClass('d-none'); 
						 //div-work-other_1
						 
						 
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
									$("#div-first-sub-sector_"+substring).removeClass("d-none");
									$("#div-o3-work-other_"+substring).addClass('d-none');
									
									console.log(data);
									var options = JSON.parse(data);
									console.log(options);
									if(field=="first"){
										console.log("if");
									updateOtherDropdown(options,"first-sub-worksector_"+substring);
									}
									else if(field=="second"){
										console.log("else");
									updateOtherDropdown(options,"second-sub-worksector_"+substring);	
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
		
		//For second child 
        
        function getChildWorkSector2(id,field){
	        	//Third level
				  $('#div-second-sub-sector_'+substring).addClass('d-none');
				  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
	        	
		    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
					 var selectedValue= $("#"+id).find('option:selected').val();
					 console.log("selectedvlaue ");
					 console.log(selectedValue);
					 console.log("field :::::",field);
					 console.log("selectedValue :: "+selectedValue);
					 console.log("substring :: "+substring);
					 
					 
					 if(selectedValue){
					 
					 
					 	if(selectedValue =='other'){
							 console.log("inside other ::::::::");
							 //$('#div-work-other_'+substring).removeClass('d-none'); 
							 //div-work-other_1
							 $("#div-o3-work-other_"+substring).removeClass("d-none");
							
							 //$("#div-first-sub-sector_"+substring).addClass("d-none");
							 
							 
							 $("#div-second-sub-sector_"+substring).addClass("d-none");
							 $("#div-o3-secons-work-other_"+substring).addClass("d-none");
							 
							 
							
					 	}else{
						 //$("#div-o3-work-other_"+substring).addClass('d-none');
						  
					 		$.ajax({
								url: '${ getWorkSectorByParentWorkSector}',
								async : false,
								data : {
									<portlet:namespace />parentWorkSectorId : selectedValue
								},
								type : 'POST',
								success : function(data) {
									//$("#div-second-sub-sector_"+substring).addClass('d-none');
									$("#div-second-sub-sector_"+substring).removeClass("d-none");
									$("#div-o3-work-other_"+substring).addClass('d-none');
									
									console.log(data);
									var options = JSON.parse(data);
									console.log(options);
									if(field=="first"){
										console.log("if");
									updateOtherDropdown(options,"first-sub-worksector_"+substring);
									}
									else if(field=="second"){
										console.log("else");
									updateOtherDropdown(options,"second-sub-worksector_"+substring);	
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
		 
   //Third child 
     function getChildWorkSector3(id,field){
		    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
					 var selectedValue= $("#"+id).find('option:selected').val();
					 console.log("selectedvlaue ");
					 console.log(selectedValue);
					 console.log("field :::::",field);
					 if(selectedValue){
					 console.log("selectedValue :: "+selectedValue);
					 console.log("substring :: "+substring);
					 	if(selectedValue =='other'){
							 console.log("inside other ::::::::");
							 $("#div-o3-secons-work-other_"+substring).removeClass("d-none");
					 	}else{
					 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
					 	}
				 	}else{
				 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
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
        console.log("user : "+${user_.userId});
        // Add an event listener for file input changes
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

                     // Set up the reader to display the image preview
                     reader.onload = function (e) {
                         imagePreview.src = e.target.result;
                         imagePreview.style.display = 'block';
                     };

                     // Read the uploaded file as a Data URL
                     reader.readAsDataURL(file);
                     uploadUserPhoto(${user_.userId},file);
            	    }else{
            	   	 $("#profile-error-container").text("<liferay-ui:message key='please-select-image' />");
            	    }
               
            } else {
               // imagePreview.style.display = 'none';
            }
        });  
        function uploadUserPhoto(userId,file){
        	console.log(userId);
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
                success: function (data, status)
                {
                      console.log("file successfully updated");
                 },
                error: function (data, status, e) {

                  console.log("file upload failed");
                }
            }) 
           return false;
        }
       // }

//==========================================================ROLE SERVICE SECTION START
  $('input[name="<portlet:namespace/>associated"]').change(function() {
	var passoc = $("input[name='<portlet:namespace/>associated']:checked").val();
	console.log("passoc"+passoc);
	if(passoc == 0 || passoc == "0" ) {
		$("#txtIndex").val("2");
		$("#isAssosiated").val("false");
		console.log("card");
		$('#registrant_detail_area').removeClass("d-none");
		$('#associated_detail_area').addClass("d-none");
	}
	else{
		console.log("mobile");
		$("#txtIndex").val("1");
		$("#isAssosiated").val("true");
		$('#associated_detail_area').removeClass("d-none");
		$('#registrant_detail_area').addClass("d-none");
	}
});

$('input[name="<portlet:namespace/>registering"]').change(function() {
	var preg = $("input[name='<portlet:namespace/>registering']:checked").val();
	console.log("preg"+preg);
	if(preg == 0 || preg == "0" ) {
		$('#service_detail_area').removeClass("d-none");
		$('#role_detail_area').addClass("d-none");
	}
	else{
		$("#txtIndex").val("2");
		$('#role_detail_area').removeClass("d-none");
		$('#service_detail_area').addClass("d-none");
	}
});
  
 $('#role-service-list').DataTable({	
    "bLengthChange": false,	
    "bFilter": false,
    "ordering": false
});

 function openRoleServiceOpenAddModel(id){
		document.getElementById('select2-role_1-container').innerHTML="select";
		document.getElementById('select2-department_1-container').innerHTML="select";
		document.getElementById('select2-section_1-container').innerHTML="select";
		document.getElementById('select2-function_1-container').innerHTML="select";
		document.getElementById('select2-programtype_1-container').innerHTML="select";
		document.getElementById('select2-program_1-container').innerHTML="select";		
		document.getElementById('select2-role-container').innerHTML="select";
		document.getElementById('select2-department_2-container').innerHTML="select";
		document.getElementById('select2-section_2-container').innerHTML="select";
		document.getElementById('select2-committe-container').innerHTML="select";
		document.getElementById('select2-function_2-container').innerHTML="select";
		document.getElementById('select2-programtype_2-container').innerHTML="select";
		document.getElementById('select2-program_2-container').innerHTML="select";
		
		$("#registrant_detail_area").addClass("d-none");
		$("#associated_detail_area").removeClass("d-none");
		$("#txtIndex").val("1");
		$("#add-role-service-confirm-modal").data("id",id);
	}

//Get Role Service By ID
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
					console.log("inside 1");
					$("#registrant_detail_area").addClass("d-none");
					$("#associated_detail_area").removeClass("d-none");
					$("#txtIndex").val("1");
					
					document.getElementById("role_1").value = userMetadata.roleId;
					var selectionRole_1 = $('option:selected', $('#role_1'));
					document.getElementById('select2-role_1-container').innerHTML=selectionRole_1.text().trim();
					
					//document.getElementById("role_1").value = userMetadata.roleId;
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
					
				}else{
					$("#txtIndex").val("2");
					console.log("inside 2");
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
					
					document.getElementById("program_2").value = userMetadata.programId;
					var selectionprogram_2 = $('option:selected', $('#program_2'));
					document.getElementById('select2-program_2-container').innerHTML=selectionprogram_2.text().trim();
					
					document.getElementById("committe").value = userMetadata.committeeId;
					var selectionCommitte = $('option:selected', $('#committe'));
					document.getElementById('select2-committe-container').innerHTML=selectionCommitte.text().trim();
				}
				
			}
		})
	}
}

//Delete Role Service By Id
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

//Save Role Service 
function saveRoleService(){
//	if(isValidVerificationField()){
		var isAssosiated = $("#isAssosiated").val().trim();
		var role_1 = $("#role_1").val().trim();
		var department_1 = $("#department_1").val().trim();
		var section_1 = $("#section_1").val().trim();
		var function_1 = $("#function_1").val().trim();
		var programtype_1 = $("#programtype_1").val().trim();
		var program_1 = $("#program_1").val().trim();		
		var role_2 = $("#role").val().trim();
		var department_2 = $("#department_2").val().trim();
		var section_2 = $("#section_2").val().trim();
		var committe = $("#committe").val().trim();
		var function_2 = $("#function_2").val().trim();
		var programtype_2 = $("#programtype_2").val().trim();
		var program_2 = $("#program_2").val().trim();
		var id = $("#id").val().trim();
		var personId = $("#personId").val().trim();
		var lrUserId = $("#lrUserId").val().trim();
		var txtIndex = $("#txtIndex").val().trim();
		var txtIndex = $("#txtIndex").val().trim();
		
		var formData = new FormData();
		formData.append('<portlet:namespace />associated',isAssosiated);
		formData.append('<portlet:namespace />role_1', role_1);
		formData.append('<portlet:namespace />department_1', department_1);
		formData.append('<portlet:namespace />section_1', section_1);
		formData.append('<portlet:namespace />function_1', function_1);
		formData.append('<portlet:namespace />programtype_1', programtype_1);
		formData.append('<portlet:namespace />program_1', program_1);		
		formData.append('<portlet:namespace />role_2', role_2);
		formData.append('<portlet:namespace />department_2', department_2);
		formData.append('<portlet:namespace />section_2', section_2);
		formData.append('<portlet:namespace />committe_2', committe);
		formData.append('<portlet:namespace />function_2', function_2);
		formData.append('<portlet:namespace />programtype_2', programtype_2);
		formData.append('<portlet:namespace />program_2', program_2);
		formData.append('<portlet:namespace />index',txtIndex);		
		formData.append('<portlet:namespace />id', id);
		formData.append('<portlet:namespace />personId', personId);
		formData.append('<portlet:namespace />lrUserId', lrUserId);

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
				document.getElementById('select2-role_1-container').innerHTML="select";
				document.getElementById('select2-department_1-container').innerHTML="select";
				document.getElementById('select2-section_1-container').innerHTML="select";
				document.getElementById('select2-function_1-container').innerHTML="select";
				document.getElementById('select2-programtype_1-container').innerHTML="select";
				document.getElementById('select2-program_1-container').innerHTML="select";				
				document.getElementById('select2-role-container').innerHTML="select";
				document.getElementById('select2-department_2-container').innerHTML="select";
				document.getElementById('select2-section_2-container').innerHTML="select";
				document.getElementById('select2-committe-container').innerHTML="select";
				document.getElementById('select2-function_2-container').innerHTML="select";
				document.getElementById('select2-programtype_2-container').innerHTML="select";
				document.getElementById('select2-program_2-container').innerHTML="select";
				
				$("#roleServiceList").html(data);
				$('#role-service-list').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
				$("#add-role-service-confirm-modal").modal('hide');
			},
		})
}

//Role Service 
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
		
	$(document).on('change','#department_1',function(){
		var departmentId=$('#department_1').val();
			setSection("department_1","section_1");		
	});
	
	$(document).on('change','#department_2',function(){
		var departmentId=$('#department_2').val();
			setSection("department_2","section_2");
	});
	
	$(document).on('change','#section_1',function(){
		var sectionId=$('#section_1').val();
		setFunctionCommitee("section_1","function_1","");
	});
	
	$(document).on('change','#section_2',function(){
		var sectionId=$('#section_2').val();
		setFunctionCommitee("section_2","function_2","committe");
	});
			
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
			
	$(document).on('change','#programtype_1',function(){
		var programTypeId=$('#programtype_1').val();
		setProgram("programtype_1","program_1");
	});
	
	$(document).on('change','#programtype_2',function(){
		var programTypeId=$('#programtype_2').val();
		setProgram("programtype_2","program_2");
	});
			
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
</script>