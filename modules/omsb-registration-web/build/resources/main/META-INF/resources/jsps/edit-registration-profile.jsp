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

<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card ">
					<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_REGISTRATION_DETAILS%>" var="saveRDURL">
					<%-- <portlet:param name="personId" value="${ personId}"/> --%>
					</liferay-portlet:actionURL>
					<form action="${saveRDURL}" method="post" 
						name="<portlet:namespace/>rdFM" id="rdFM" autocomplete="off" enctype="multipart/form-data">
						<input type="hidden" value="${personId }" name="<portlet:namespace/>personId_"/>
						<div class="reg_step1" id="reg_step1">
							<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<div class="pagetitle"><liferay-ui:message key="edit-profile" /></div>
									<div class="profile_photo">
                                                <div class="upload-container">
                                                     <c:if test="${not empty photoURL }">                                             
                                                     <img id="imagePreview" src="${photoURL}" alt="Preview">
                                                     </c:if>
                                                     <c:if test="${empty photoURL }">
                                                     <img id="imagePreview" src="<%=themeDisplay.getPathThemeImages() %>/png/profile_img.png" alt="Preview">
                                                     </c:if>
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
										<label class="control-label ${empty person.civilId && not empty person.passportNumber?'required':''}"><liferay-ui:message key="country-of-issue" /></label>
										<select name="<portlet:namespace/>countryOfIssue" id="countryOfIssue" class="form-control" onchange="validateField(this.id,'errorContainer-countryOfIssue','<liferay-ui:message key="please-select-country-of-issue" />')"  >
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="country" items="${countries}">
												<option value="${country.countryId}" <c:if test="${country.countryId == personalDetails.passportIssuingCountryId}">selected="selected"</c:if> >
													<liferay-ui:message key="${country.name}" />
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
							<%-- 	<div class="col-lg-6 col-md-6">
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
								</div> --%>
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
													<liferay-ui:message key="${country.name}" />
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
										<label class="control-label required"><liferay-ui:message key="Photo" /></label>
										<div class="custom-file">
											<input type="file" name="<portlet:namespace/>photo" id="photo" class="form-control custom-file-input" value="${photo}" onchange="validateFile(this.id,'errorContainer-photo','photo','<liferay-ui:message key="please-select-image" />')">
											<label class="custom-file-label" for="photo" id="photo-label">
												${photo}
											</label>
										</div>
										<p id="errorContainer-photo" class="error-container"></p>
									</div>
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
										<select name="<portlet:namespace/>profession" id="profession" class="form-control" onchange="validateField(this.id,'errorContainer-profession','<liferay-ui:message key="please-select-profession" />');setPrimarySpecialty()">
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
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="primary-speciality" /></label>
										<select name="<portlet:namespace/>primarySpeciality" id="primarySpeciality" class="form-control" onchange="validateField(this.id,'errorContainer-primarySpeciality','<liferay-ui:message key="please-select-primary-speciality" />');setSecondarySpeciality()">
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
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="secondary-speciality" /></label>
										<select name="<portlet:namespace/>secondarySpeciality" id="secondarySpeciality" class="form-control" onchange="validateField(this.id,'errorContainer-secondarySpeciality','<liferay-ui:message key="please-select-secondary-speciality" />')">
											<option value=""><liferay-ui:message key="select" /></option>
											<%-- <c:forEach var="secSpec" items="${specialityList}">
													<option value="${secSpec.getKey()}" <c:if test="${secSpec.getKey() == personalDetails.secondarySpeciality}">selected="selected"</c:if> >
														${secSpec.getName(themeDisplay.getLocale())}
													</option>
											</c:forEach> --%>
										</select>
									</div>
									<p id="errorContainer-secondarySpeciality" class="error-container"></p>
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
						    <%-- <h3 class="reg-form-title"><liferay-ui:message key="registration-work-details" /></h3> --%>
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
																				<option value=""><liferay-ui:message key="select" /></option>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
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
																<label class="control-label "><liferay-ui:message key="primary-first-sub-sector-name" /></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sub-sector-name-other" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="Other">
															</div>
														</div>
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
															
														<!-- Changes Abhi ends -->
														
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
														
														
														<c:choose>
														<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
															<div class="col-lg-4 col-md-6" id="div-o2-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="Other">
																</div>
															</div>
														</c:when>
														<c:when test="${primaryworkDetail.workSectorId==0 &&  empty primaryworkDetail.workSectorOther}">
															<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="Other">
																</div>
															</div>
														</c:when>
														<c:otherwise>
															<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
																	<div class="form-group">
																		<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																		 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																		 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="Other">
																	</div>
																</div>
														</c:otherwise>
														</c:choose>
														
														
													<c:choose>
														<c:when test="${primaryworkDetail.workSectorId>0 &&  primaryworkDetail.workSectorId2>0}">
															<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="primary-first-sub-sector-name" /></label>
																	<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																				<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																					${workSubSector.getWorkSector()}
																				</option>
																	</c:forEach>
																	</select>
																</div>
															</div>
															</c:when>
															<c:when test="${primaryworkDetail.workSectorId2==0 && not empty primaryworkDetail.workSectorOther2}">
																		<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
																	<div class="form-group">
																		<label class="control-label "><liferay-ui:message key="primary-first-sub-sector-name" /></label>
																		<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																			<option value=""><liferay-ui:message key="select" /></option>
																			<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																		</select>
																	</div>
																</div>
																	</c:when>
															<c:otherwise>
																<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
																	<div class="form-group">
																		<label class="control-label "><liferay-ui:message key="primary-first-sub-sector-name" /></label>
																		<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																			<option value=""><liferay-ui:message key="select" /></option>
																			<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																		</select>
																	</div>
																</div>
															</c:otherwise>
															
													</c:choose>
														
													
													
													<c:choose>
														<c:when test="${ not empty primaryworkDetail.workSectorOther2}">
														<div class="col-lg-4 col-md-6 " id="div-o3-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sub-sector-name-other" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther2}">
															</div>
														</div>
														</c:when>
														<c:otherwise>
														<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sub-sector-name-other" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="Other">
															</div>
														</div>
														
														</c:otherwise>
													</c:choose>
														
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
															<label class="control-label  "><liferay-ui:message key="secondary-workplace-sector-type" /></label> 
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
													<div class="col-lg-4 col-md-6"  id="work-sector-div_2">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="secondary-sector-name" /></label>
															  
															  <select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
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
																<label class="control-label "><liferay-ui:message key="secondary-first-sub-sector-name" /></label>
																<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="secondary-sub-sector-name-other" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="Other">
															</div>
														</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="region-location-secondary-institution" /></label> 
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
															<label class="control-label "><liferay-ui:message key="designation" /></label>
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
																	<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type" /></label>
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
																<div class="col-lg-4 col-md-6" id="worksectorTypediv_2">
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
															
														<!-- Changes Abhi ends -->
																<c:choose>
																<c:when test="${secondaryWorkDetail.workSectorId>0}">
																	<div class="col-lg-4 col-md-6" id="work-sector-div_2">
																		<div class="form-group" >
																			<label class="control-label "><liferay-ui:message key="secondary-sector-name" /></label> 
																					<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																						<option value=""><liferay-ui:message key="select" /></option>
																						<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
																							<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																								${workSector.getWorkSector()}
																							</option>
																						</c:forEach>
																					</select>
																			<p class="error-container" id="work-sector-error_2"></p>
																		</div>
																	</div>
																</c:when>
																<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
																	<div class="col-lg-4 col-md-6 " id="work-sector-div_2">
																		<div class="form-group" >
																			<label class="control-label "><liferay-ui:message key="secondary-sector-name" /></label> 
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
																		<div class="form-group" >
																			<label class="control-label "><liferay-ui:message key="secondary-sector-name" /></label> 
																					<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																						<option value=""><liferay-ui:message key="select" /></option>
																						<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																					</select>
																			<p class="error-container" id="work-sector-error_2"></p>
																		</div>
																	</div>
																</c:otherwise>
																</c:choose>
														
														
																<c:choose>
																<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
																	<div class="col-lg-4 col-md-6" id="div-o2-work-other_2">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
																			 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																			 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="Other">
																		</div>
																	</div>
																</c:when>
																<c:when test="${secondaryWorkDetail.workSectorId==0 &&  empty secondaryWorkDetail.workSectorOther}">
																	<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
																			 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																			 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="Other">
																		</div>
																	</div>
																</c:when>
																<c:otherwise>
																	<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
																			<div class="form-group">
																				<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
																				 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																				 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="Other">
																			</div>
																		</div>
																</c:otherwise>
																</c:choose>
														
															<c:choose>
																<c:when test="${secondaryWorkDetail.workSectorId>0 &&  secondaryWorkDetail.workSectorId2>0}">
																	<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="secondary-first-sub-sector-name" /></label>
																			<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																			<option value=""><liferay-ui:message key="select" /></option>
																			<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
																						<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																							${workSubSector.getWorkSector()}
																						</option>
																			</c:forEach>
																			</select>
																		</div>
																	</div>
																	</c:when>
																	<c:when test="${secondaryWorkDetail.workSectorId2==0 && not empty secondaryWorkDetail.workSectorOther2}">
																		<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
																				<div class="form-group">
																					<label class="control-label "><liferay-ui:message key="secondary-first-sub-sector-name" /></label>
																					<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																						<option value=""><liferay-ui:message key="select" /></option>
																						<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																					</select>
																				</div>
																			</div>
																	
																	</c:when>
																	<c:otherwise>
																		<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
																			<div class="form-group">
																				<label class="control-label "><liferay-ui:message key="secondary-first-sub-sector-name" /></label>
																				<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																					<option value=""><liferay-ui:message key="select" /></option>
																					<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																				</select>
																			</div>
																		</div>
																	</c:otherwise>
														</c:choose>
													
														<c:choose>
															<c:when test="${ not empty secondaryWorkDetail.workSectorOther2}">
															<div class="col-lg-4 col-md-6 " id="div-o3-work-other_2">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="secondary-sub-sector-name-other" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther2}">
																</div>
															</div>
															</c:when>
															<c:otherwise>
															<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="secondary-sub-sector-name-other" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="Other">
																</div>
															</div>
															
															</c:otherwise>
														</c:choose>
														
														
														
														
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="region-location-secondary-institution" /></label>
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
																<label class="control-label "><liferay-ui:message key="designation" /></label>
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
								</div>
							
							
							
							
							
							
							
							
							
							
							
							
							
					
					
				</div>
						<!-- =============================== Work Details Ends ==================================================== -->
						
						
				<div class="reg_step4 mt-4"  id="reg_step4">
							<div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title"><liferay-ui:message key="role-service" /></h3>
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
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="userMetadata" items="${userMetadataItem.items}"> 
															<tr>
																<td>${userMetadata.roleName}</td>
																<td>${userMetadata.departmentId}</td>
																<td>${userMetadata.sectionId}</td>
																<%-- <td>${userMetadata.committeeId}</td> 
																 <td>${userMetadata.functionId}</td> --%> 
																<td>${userMetadata.programTypeName}</td>
																<td>${userMetadata.programName}</td>
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
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="country-of-institution" /></label>
														<select  name="<portlet:namespace/>country" id="country" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="country" items="${customCountries}">
																<option value="${country.id}">
																	<liferay-ui:message key="${country.nationality}" />
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
<portlet:resourceURL id="<%=MVCCommands.FETCH_SPECIALITY_BY_PROFESSION%>" var="professionListURL" />	
<portlet:resourceURL id="<%=MVCCommands.SPECIALITY_AND_SUBSPECIALITY_MVC_RESOURCE%>" var="specialityListURL" />	

	
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

var index=1;
$(document).ready(function() {
	/* if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    } */
    
    $("#registration-cancel").click(function(){
    	console.log('${themeDisplay.getPortalURL()}'+'/group/guest/dashboard');
		window.location.href='${themeDisplay.getPortalURL()}'+'/group/guest/dashboard';
	});
	
	const minDate = new Date();
	minDate.setDate(minDate.getDate() + 1);
	/* $('#passportExpiryDate').datepicker({
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
	}); */
	setPrimarySpecialty();
	setSecondarySpeciality();
});

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
 //var data=${workSectors};
  console.log( "ready!" );
  //console.log(data);
  //var value1=  $("#worksector_1").val();
  //var worksectorother1=  $("#worksectorother_1").val();
  
	/* if(worksectorother1.length>0){
	  console.log("inside other value is greater");
	  value1="Other";
	  $("#div-work-other_1").removeClass("d-none");
  	} */
	 /* else{
		 $("#worksectorother_1").val('');
			$("#div-work-other_1").addClass("d-none");
	  } */
  
  //var value2=  $("#worksector_2").val();
  //var worksectorother2=  $("#worksectorother_2").val();
  
  /* if(worksectorother2.length>0){
	  console.log("inside other value is greater");
	  value2="Other";
	  $("#div-work-other_2").removeClass("d-none");
  }
  else{
	  $("#worksectorother_2").val('');
		$("#div-work-other_2").addClass("d-none");
  } */
  
  /* console.log("worksectorother2 :::::",worksectorother2);
	    $("#worksector_1").comboTree({
		source : data,
		isMultiple: false,
		collapse:true,
		selected: [value1]
	}); 
    $("#worksector_2").comboTree({
		source : data,
		isMultiple: false,
		collapse:true,
		selected : [value2]
	}); */
    
    
    
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
	console.log("oooo");
	var isErrorOccured=false;
	var errorMessages = [];	
	var countryOfIssue = document.getElementById("countryOfIssue").value;
	var passportExpiryDate = document.getElementById("passportExpiryDate").value;
	var passNo="${person.passportNumber}";
	if(passNo!=""){
		console.log("oooo");
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
	if('${not empty person.civilId}'){
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
				$("#emailAddress").removeAttr("readonly");
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
	
		var photo = document.getElementById("photo").files[0];
		if (!photo ) {
			if(portraitId=='true'){
			errorMessages.push("<liferay-ui:message key='please-upload-photo' />");
			document.getElementById("errorContainer-photo").textContent = "<liferay-ui:message key='please-upload-photo' />";
			if(!isErrorOccured){
				$("#photo").focus();
				isErrorOccured=true;
			}
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
				if(!isErrorOccured){
					$("#photo").focus();
					isErrorOccured=true;
				}
            } else {
            	document.getElementById("errorContainer-photo").textContent = "";
            }
		}
		  else{
		    	 console.log("inside else conditon");
		    	 document.getElementById("errorContainer-photo").textContent = "";
		    	 document.getElementById("errorContainer-photo").textContent ="<liferay-ui:message key='please-select-image' />";
		    	 errorMessages.push("<liferay-ui:message key='please-select-image' />");
		    	 if(!isErrorOccured){
		 			$("#photo").focus();
		 			isErrorOccured=true;
		 		}
		     }
	}
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
	
	var isEmployed= $("input[name = '<portlet:namespace/>employed']:checked").val();
	if(isEmployed ==1){
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
	}
	
	
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
$('#add_edu_detail').click(function() {
		var counterValue=$('#counter').val();
		$('#counter').val(parseInt($('#counter').val())+1);
		
		// Finding total number of elements added
        var total_element = $(".element").length;
		console.log("total_element :::",total_element);
        // last <div> with element class id
        var lastid = $(".element:last").attr("id");
        console.log("lastid :::",lastid);
        var split_id = lastid.split("_");
        console.log("split_id :::",split_id);
        var nextindex = Number(split_id[2])+1;
        console.log("nextindex :::",nextindex);
        
        var today = new Date();
        var todayYear=today.getFullYear();
        var yearHtml='';
        for(var i=todayYear ;i>=1970 ;i--){
        	yearHtml=yearHtml+"<option value='"+i+"'>"+i+"</option>";
        }
        
        $.each(list, function( index, value ) {
            qualificationHtml=qualificationHtml+"<option value='"+value.key+"'>"+value.name+"</option>";
        });
    	
    	$.each(institutionList, function( index, value ) {
            institutionHtml=institutionHtml+"<option value='"+value.key+"'>"+value.name+"</option>";
        });
    	
    	$.each(customCountries, function( index, value ) {
    		countryHtml=countryHtml+"<option value='"+value.id+"'><liferay-ui:message key='"+value.nationality+"'/></option>";
        });
        
        $(".element:last").after("<div class='omsb-card omsb-card-graybg omsb-noBorderRadius edu_detail element' id='edu_detail_"+ nextindex +"'></div>");
        $("#edu_detail_" + nextindex).append("<div class='omsb-list-filter'>"+
        		"<div class='row'>"+
	        		"<div class='col-lg-6 col-md-6'>"+
	        		"<div class='form-group'>"+
	        		"<label class='control-label required'><liferay-ui:message key='title'/></label>"+
	        		"<select  name='<portlet:namespace/>qualification_"+nextindex+"' id='qualification_"+ nextindex +"' class='form-control'>"+
	        		"<option value=''><liferay-ui:message key='select' /></option>"+
	        			qualificationHtml+
	        		"</select>"+
	        		"<p id='errorContainer-qualification_"+nextindex+"'. class='error-container'></p>"+
	        		"</div>"+
	        		"</div>"+
	        		"<div class='col-lg-6 col-md-6'>"+
	        		"<div class='form-group'>"+
	        		"<label class='control-label'><liferay-ui:message key='institution' /></label>"+
	        		"<select  name='<portlet:namespace/>institution_"+ nextindex +"' id='institution_"+ nextindex +"' class='form-control'>"+
	        		"<option value=''><liferay-ui:message key='select' /></option>"+
	        		institutionHtml+
	        		"</select>"+
	        		"<p id='errorContainer-institution_"+nextindex+"' class='error-container'></p>"+
	        		"</div>"+
	        		"</div>"+
	        		"<div class='col-lg-6 col-md-6'>"+
	        		"<div class='form-group'>"+
	        		"<label class='control-label'><liferay-ui:message key='country-of-institution' /></label>"+
	        		"<select name='<portlet:namespace/>country_"+nextindex+"' id='country_"+nextindex+"' class='form-control'>"+
	        		"<option value=''><liferay-ui:message key='select' /></option>"+
	        		countryHtml+
	        		"</select>"+
	        		"<p id='errorContainer-country-of-institution_"+nextindex+"' class='error-container'></p>"+
	        		"</div>"+
	        		"</div>"+
	        		"<div class='col-lg-6 col-md-6'>"+
	        		"<div class='form-group'>"+
	        		"<label class='control-label'><liferay-ui:message key='gpa'/></label>"+
	        		"<input type='text' name='<portlet:namespace/>gpa_"+nextindex+"' id='gpa_"+nextindex+"' value='' class='form-control'/>"+
	        		"<p id='errorContainer-gpa_"+nextindex+"' class='error-container'></p>"+
	        		"</div>"+
	        		"</div>"+
	        		"<div class='col-lg-6 col-md-6'>"+
	        		"<div class='form-group'>"+
	        		"<label class='control-label'><liferay-ui:message key='year-of-graduation'/></label>"+
	        		"<select  name='<portlet:namespace/>year_"+nextindex+"' id='year_"+nextindex+"' class='form-control'>"+
	        		"<option value=''><liferay-ui:message key='select'/></option>"+
	        		yearHtml+
	        		"</select>"+
	        		"<p id='errorContainer-year-of-graducation_"+nextindex+"' class='error-container'></p>"+
	        		"</div>"+
	        		"</div>"+
	        		"<div class='col-lg-6 col-md-6'>"+
	        		"<div class='form-group'>"+
	        		"<label class='control-label'><liferay-ui:message key='qualification-document' /></label>"+
	        		"<div class='custom-file'>"+
	        		"<input type='file' name='<portlet:namespace/>qualificationdoc_"+nextindex+"' id='qualificationdoc_"+nextindex+"' value='' class='form-control custom-file-input'>"+	
	        		"<label class='custom-file-label' for='qualificationdoc_"+nextindex+"'>"+
	        		"</label>"+
	        		"</div>"+
	        		"<p id='errorContainer-qualification-document_"+nextindex+"' class='error-container'></p>"+
	        		"</div>"+
	        		"</div>"+
        			"</div>"+
        			"<div class='filter-button-wrap flex'>"+
	        		"<button class='btn edu_delete' title='Delete' onclick='openEduOpenDeleteModal(this)' data-target='#delete-education-confirm-modal' data-toggle='modal'>"+
	        		"<img src='"+imagePath+"/svg/delete_icon.svg'>"+
	        		"</button>"+
	        		"</div>"
        		
        ); 
		//edu_delete();
	});
	
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


$('input[name="<portlet:namespace/>associated"]').change(function() {
	var passoc = $("input[name='<portlet:namespace/>associated']:checked").val();
	console.log("passoc"+passoc);
	if(passoc == 0 || passoc == "0" ) {
		$("#txtIndex").val("2");
		console.log("card");
		$('#registrant_detail_area').removeClass("d-none");
		$('#associated_detail_area').addClass("d-none");
	}
	else{
		console.log("mobile");
		$("#txtIndex").val("1");
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
						console.log("workSectorValue",workSectorValue);
						$("#worksectorother_1").val('');
						$("#div-work-other_1").addClass("d-none");
					}
					
				});
			
			   $(document).on('change','#worksector_2',function(){
					var workSectorValue=$(this).val();
					if(workSectorValue == 'Other'){
					      $("#div-work-other_2").removeClass("d-none");
					}else{
						console.log("workSectorValue",workSectorValue);
						$("#worksectorother_2").val('');
						$("#div-work-other_2").addClass("d-none");
					}
					
				});
			
			//on Chnage function for work sector to display other
			$(document).on('change','.worksector_',function(){
				console.log("Change called::::::");
				var workSectorValue=$(this).val();
				var id = $(this).attr('id');
				 var split_id = id.split("_");
				console.log("split_id ::::",split_id);
				var index = Number(split_id[1]);
			      console.log("index :::",index);
				if(workSectorValue == 'Other'){
				      $("#div-work-other_"+index).removeClass("d-none");
				}else{
					console.log("workSectorValue",workSectorValue);
					$("#worksectorother_"+index).val('');
					$("#div-work-other_"+index).addClass("d-none");
				}
				
			});
		});


function showDesignationOther(id,errorId,errorMessage){
	console.log(id);
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


//Role Service 

function setSection(departmentId,sectionId){
		var inputDepartmentId=$("#"+departmentId).val();
		console.log("inputDepartmentId ::::",inputDepartmentId);
		
		
		$.ajax({
			url: '${sectionDepartmentURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />departmentId : inputDepartmentId,
			},
			type : 'POST',
			success : function(data) {
				console.log("success :::::",data);
				console.log("success :::::",data.length);
				 var response=data;
				 console.log("response :::::",response.length);
				var sectionData="<option value=''><liferay-ui:message key='select'/></option>";
				
				$.each(response, function( index, value ) {
					sectionData=sectionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+sectionId).html("").append(sectionData);
			},
		})
	}
		
		
	$(document).on('change','#department_1',function(){
		console.log("change");	
		var departmentId=$('#department_1').val();
		console.log("departmentId :::::::::::",departmentId);
			setSection("department_1","section_1");
		
	});
	
	
	$(document).on('change','#department_2',function(){
		console.log("change");	
		var departmentId=$('#department_2').val();
		console.log("departmentId :::::::::::",departmentId);
			setSection("department_2","section_2");
	});
	

	$(document).on('change','#section_1',function(){
		var sectionId=$('#section_1').val();
		console.log("sectionId :::::::::::",sectionId);
		setFunctionCommitee("section_1","function_1","");
	});
	
	$(document).on('change','#section_2',function(){
		var sectionId=$('#section_2').val();
		console.log("sectionId :::::::::::",sectionId);
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
				console.log("success :::::");
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
					$("#"+committeId).html("").append(functionData);
				}
			},
		})
	}
			
			
	$(document).on('change','#programtype_1',function(){
		var programTypeId=$('#programtype_1').val();
		console.log("programTypeId ::::::::",programTypeId);
		setProgram("programtype_1","program_1");
	});
	
	
	$(document).on('change','#programtype_2',function(){
		var programTypeId=$('#programtype_2').val();
		console.log("programTypeId ::::::::",programTypeId);
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
				console.log("success :::::",data);
				 console.log("success :::::",data.length);
				 var response=data;
				 console.log("response :::::",response.length);
				var programData="<option value=''><liferay-ui:message key='select'/></option>";
				
				$.each(response, function( index, value ) {
					programData=programData+"<option value='"+value.id+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+programId).html("").append(programData);
			},
		})
	}

//Role service pre populate data
var userMetadataId=$('#userMetadataId').val();
var isAssociated=$('#isAssociated').val();
var isregisteringForRole=$('#isregisteringForRole').val();
console.log("isAssociated ::::",isAssociated);
console.log("isregisteringForRole ::::",isregisteringForRole);
console.log("userMetadataId ::::",userMetadataId);

if(isAssociated == 'true'){
	console.log("mobile");
	$("#txtIndex").val("1");
	$('#associated_detail_area').removeClass("d-none");
	$('#registrant_detail_area').addClass("d-none");
}else if(isAssociated== 'false' && isregisteringForRole == 'true'){
	$('#associated_yes').prop('checked', false);
	$('#associated_no').prop('checked', true);
	$('#registering_yes').prop('checked', true);
	$('#registering_no').prop('checked', false);
	$("#txtIndex").val("2");
	console.log("card");
	$('#registrant_detail_area').removeClass("d-none");
	$('#associated_detail_area').addClass("d-none");
}else if(isAssociated =='false' && isregisteringForRole== 'false' && userMetadataId>0){
	$('#associated_yes').prop('checked', false);
	$('#associated_no').prop('checked', true);
	$('#registering_yes').prop('checked', false);
	$('#registering_no').prop('checked', true);
	$('#service_detail_area').removeClass("d-none");
	$('#associated_detail_area').addClass("d-none");
	$('#registrant_detail_area').removeClass("d-none");
	$('#role_detail_area').addClass("d-none");
}
	
function validateField(elementId,errorId,error){
	var fieldValue=$("#"+elementId).val();
	console.log(elementId+" ---  "+errorId+ " --- "+error);
	if(elementId.indexOf("_") !== -1){
		var divId=elementId.substring(elementId.indexOf("_") + 1);
		errorId=errorId.substring(0,errorId.indexOf("_")+1)+divId;
		console.log(errorId);
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
//	document.getElementById("gpa").value = "";
	document.getElementById("year").value = "";
	document.getElementById("id").value = '';
	document.getElementById("qualificationdoclbl").innerHTML = '';
	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
//	document.getElementById("errorContainer-gpa").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	document.getElementById("view-file").setAttribute("href","");
	$("#view-div").addClass("d-none");
	$("#add-education-confirm-modal").data("id",id);
}


$('#work-detail-list').DataTable({	
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
			//	document.getElementById("gpa").value = "";
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
					console.log(educationDetails);
					console.log("line 2442");
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
	
/* 	var gpa = document.getElementById("gpa").value.trim();
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
		//  var allowedExtensionsRegex=new RegExp("(.*?)\.(pdf)$");
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
		console.log(errorId);
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
									 
								 }else{
									 updateOtherDropdown(options,"worksector_"+substring);
									 $('#work-sector-div_'+substring).removeClass('d-none');   
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
				 }
	        }
	        
	        
	        
		function updateOtherDropdown(options,field) {
			console.log("field : "+field);
		    var otherDropdown = document.getElementById(field);
		    
		    console.log("otherDropdown :::",otherDropdown);
		    
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
				 if(selectedValue){
				 console.log("selectedValue :: "+selectedValue);
				 console.log("substring :: "+substring);
				 
				 
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
			 	}
	       }
		
		
		 //For second child 
        
        function getChildWorkSector2(id,field){
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
						 //$('#div-work-other_'+substring).removeClass('d-none'); 
						 //div-work-other_1
						 $("#div-o3-work-other_"+substring).removeClass("d-none");
						
						 //$("#div-first-sub-sector_"+substring).addClass("d-none");
						 
				 	}else{
					 $("#div-o3-work-other_"+substring).addClass('d-none');
				 	}
			 	}else{
			 		 $("#div-o3-work-other_"+substring).addClass('d-none');
			 	}
	       }
		 
		 
        $('#role-service-list').DataTable({	
		    "bLengthChange": false,	
		    "bFilter": false,
		    "ordering": false
		});
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