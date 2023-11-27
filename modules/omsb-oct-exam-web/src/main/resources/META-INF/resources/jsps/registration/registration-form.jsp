	<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backurl">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommandNames.SAVE_EXAM_PAYMENT_RESOURCE%>"
		var="saveExamPayment" />
		
<portlet:resourceURL id="<%=MVCCommandNames.SAVE_REGISTRATION%>"
		var="saveRegistrationURL" />
		
<portlet:actionURL name="<%=MVCCommandNames.REGISTRATION_CONFIRM_ACTION%>" var="registrationConfirmationURL" />

<portlet:resourceURL id="<%=MVCCommandNames.CANCEL_REGISTRATION%>"
		var="cancelRegistrationURL" />		
		
<portlet:resourceURL id="/confirm" var="confirm" />
<div class="d-none" id="map"></div>		
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
							<div class="pagetitle">${registration.oCExamTitle}</div>
						</div>
			<%-- <portlet:actionURL name="/oc/exam/registartion" var="saveRegistrationURL" /> --%>
			<form  method="post" name="saveRegistrationFm" id="saveRegistrationFm" enctype="multipart/form-data">
				

		<div class="row m-0">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<h4 class="form-title">
					<liferay-ui:message key="candidate-details" />
				</h4>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<label><liferay-ui:message key="no-of-attempts" /></label>
				<label>${registration.noOfAttempts}</label>
				
			</div>
		</div>	
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
							<label><liferay-ui:message key="middle-name" /></label>
							<input type="text" name="fnameinenglish" id="fnameinenglish" readonly
								value="${registration.middleName}" class="form-control">
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
						<input type="hidden" name="<portlet:namespace/>oCExamScheduleId" value="${registration.oCExamScheduleId}" id="oCExamScheduleId">
						<input type="hidden" name="<portlet:namespace/>lrUserId" value="${registration.lrUserId}">
						<input type="hidden" name="<portlet:namespace/>emergancyContanctId" value="${emergencyContact.id}">
						<input type="hidden" name="<portlet:namespace/>id" value="${registration.id}">
						<input type="hidden" name="<portlet:namespace/>feeType" value="${registration.feeType}">
					</div>
					<div class="col-lg-4 col-md-6">
						<input type="hidden"  name="<portlet:namespace/>examType"
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
							<input type="text" required pattern="[0-9]+" title="Please enter only numbers"name="<portlet:namespace/>telephone" id="telephone" value="${emergencyContact.telephone}" class="form-control required " placeholder="<liferay-ui:message key="enter-telephone" />"
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
							<input type="text" required pattern="[0-9]+" title="Please enter only numbers" name="<portlet:namespace/>mobile" id="mobile" value="${emergencyContact.mobileNumber}"
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
							<input type="text" required pattern="^[A-Za-z]+$" title="Alphabetic characters only" name="<portlet:namespace/>relationshipToApplicant"
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
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="university-of-education" /></label>
							<input readonly type="text" name="universityofeducation" value="${registration.issuingAuthorityName}"
								id="universityofeducation" value="" class="form-control"
								
								>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="upload-certificate" /></label>
							<%-- <div class="custom-file">
                                 <input readonly type="file" class="custom-file-input" id="customFile" name="filename">
                            	 <label class="custom-file-label" for="customFile">${registration.educationCertificate}</label>
                           </div>  --%>
                           
							 <a href="${registration.documentUrl}" target="_blank" class="omsb-view-file" download="">
							 <label>${registration.educationCertificate}<span class="view-download"><liferay-ui:message key="download" /></span></label>
							 </a>
				  		 </div>
                           
						</div>
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
					<liferay-ui:message key="internship-training" />
				</h4>
				<div class="row m-0">
					
					<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>internshipStatus" class="custom-control-input internshipStatus" id="Completed" value="completed"  <c:if test="${registration.internshipStatus eq 'completed'}">checked</c:if>>
										<label class="custom-control-label m-0" for="Completed"><liferay-ui:message key="completed" /></label>
									  </div>
								</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>internshipStatus" class="custom-control-input internshipStatus" id="Ongoing" value="ongoing" <c:if test="${registration.internshipStatus eq 'ongoing'}">checked</c:if>>
										<label class="custom-control-label m-0" for="Ongoing"><liferay-ui:message key="ongoing" /></label>
									  </div>
								</div>
					</div>
					
					<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>internshipStatus" class="custom-control-input internshipStatus" id="Not Applicable" value="notApplicable" <c:if test="${registration.internshipStatus eq 'notApplicable'}">checked</c:if>>
										<label class="custom-control-label m-0" for="Not Applicable"><liferay-ui:message key="not-applicable" /></label>
									  </div>
								</div>
					</div>
					
					
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="upload" /></label>
							<div class="custom-file mb-3">
							<div>
								<input type="file" class="custom-file-input"
									value="No files chosen" id="internshipFile" name="<portlet:namespace/>internshipFileEntry" placeholder="<liferay-ui:message key="choose-file" />" >
							</div>
								<label class="custom-file-label" for="internshipFile" id="fileTitle"></label>
							</div>
						</div>
					</div>
				</div>
				<h4 class="form-title">
					<liferay-ui:message key="internship-date" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="from-date" /></label> <input
								type="text" name="<portlet:namespace/>internshipFromDate" id="FromDate" 
								class="form-control datePicker" placeholder="<liferay-ui:message key="dd-mm-yyyy" />" value="${registration.internshipFromDate}" >
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="to-date" /></label> <input
								type="text" name="<portlet:namespace/>internshipToDate" id="Todate" value="${registration.internshipToDate}"
								class="form-control datePicker" placeholder="<liferay-ui:message key="dd-mm-yyyy" />">
						</div>

					</div>
				</div>
				<h4 class="form-title">
					<liferay-ui:message key="consent" />
				</h4>
				<div class="row m-0">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
							<input type="checkbox" required class="custom-control-input" id="authorize" name="<portlet:namespace/>consentAuthorize">
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
					<button onClick="validateAndSaveFormData('save')" type="button" class="btn omsb-bc-red-button submit" title="Save" >
						<liferay-ui:message key="pay" />
					</button>
					<button type="button" class="btn omsb-bc-red-button" data-toggle="modal" data-target="#discard-modal" title="Discard">
						<liferay-ui:message key="discard" />
					</button>
					 <a class="btn omsb-btn btn-back" href="${backurl}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="Back" /></a>
				</div>
			</form>
		</div>
	</div>
</div>


<!-- Modal - confirm payment pop up -->
<button hidden class="btn omsb-btn btn-red" data-toggle="modal" data-target="#confirm-payment" id="openBox">Pay now</button>

	
	<form action="${registrationConfirmationURL}" method="post" id="confirmRegistrationFm">
		<input type="hidden" name="<portlet:namespace/>oCExamScheduleId" id="oCExamScheduleId-popup">
		<input type="hidden" name="<portlet:namespace/>octExamFees" id="octExamFees">
		<input type="hidden" name="<portlet:namespace/>feeType" id="feeType">
		<div class="modal fade omsb-modal" id="confirm-payment" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">
							<liferay-ui:message key="appointment-verification" />
						</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="info mt-2 mx-4 px-4">
						<liferay-ui:message key="payment-verify-msg" />
					</div>
					<div class="modal-body">

						<div class="omsb-card omsb-card-graybg">
							<div class="omsb-card-title">
								<liferay-ui:message key="personal-details" />
							</div>
							<div class="row">
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="name" />
									</div>
									<div class="label-content" id="username"></div>
								</div>
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="phone" />
									</div>
									<div class="label-content" id=phone></div>
								</div>
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="email" />
									</div>
									<div class="label-content" id="email"></div>
								</div>
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg" style="margin: 5px 0 !important;">
							<div class="omsb-card-title">
								<liferay-ui:message key="appointment-details" />
							</div>
							<div class="row">
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="exam-date-time" />
									</div>
									<div class="label-content" id="examDateTime"></div>
								</div>
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="exam-title" />
									</div>
									<div class="label-content" id="examTitle"></div>
								</div>
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="location" />
									</div>
									<div class="label-content" id="location"></div>
								</div>
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg">
							<div class="omsb-card-title">
								<liferay-ui:message key="payment-details" />
							</div>
							<div class="row">
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="payment-date" />
									</div>
									<div class="label-content" id="paymentDate">--</div>
								</div>
								<div class="col-lg-4 col-md-4 label-box">
									<div class="label-name">
										<liferay-ui:message key="exam-fee" />
									</div>
									<div class="label-content" name="<portlet:namespace/>examFees" id="examFee"></div>
								</div>

							</div>
							<h4 class="note-label"><liferay-ui:message key="note :" /><liferay-ui:message key="payment-accept-all-card" /></h4>
						</div>

					</div>
					<div class="modal-footer">
						<button class="btn omsb-bg-red-button" onclick="saveExamRegistrationPayment()" type="button"
							title="confirm">
							<liferay-ui:message key="confirm" />
						</button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button" onclick="cancelRegistration()" data-dismiss="modal">
							<liferay-ui:message key="cancel" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
<!-- paymenet popup end -->
<div class="d-none" id="paymentFormWrapper"></div>
		<div id="successMessage" class="alert-notifications-fixed success-message-div d-none">
			<clay:alert displayType="success" title="Success" message="Payment Completed successfuly." />
		</div>
		<div id="errorMessage" class="alert-notifications-fixed error-message-div d-none">
			<clay:alert displayType="danger" title="error" message="Payment is Failed, Please try again later." />
		</div>

<!-- pop up discard button -->
		<div class="modal fade omsb-modal" id="discard-modal" tabindex="-1" role="dialog"
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
								<liferay-ui:message key="discard-examsetup-confirmation"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="discardChanges()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!-- end discard button -->

		<style>
			#errorMessage .alert.alert-danger {
				width: auto;
				font-weight: bold;
			}

			#successMessage .alert.alert-success {
				width: auto;
				font-weight: bold;
			}
		</style>

 <script>
 
 
	$(document).ready(function() {
		$('.textEditor').richText();
		console.log("loading...");
		var paymentResponseStatus = localStorage.getItem("paymentResponseStatus");
		if (paymentResponseStatus == 'success') {
			/* $("#successMessage").fadeTo(2000, 500).slideUp(500, function () {
				$("#successMessage").slideUp(500);
			}); */
			$("#successMessage").removeClass("d-none");
			setTimeout(function () {
				$("#successMessage").addClass("d-none");
			}, 4000);

		} else if (paymentResponseStatus == 'failed') {
			/* $("#errorMessage").fadeTo(2000, 500).slideUp(500, function () {
				$("#errorMessage").slideUp(500);
			}); */
			$("#errorMessage").removeClass("d-none");
			setTimeout(function () {
				$("#errorMessage").addClass("d-none");
			}, 4000);
		}
		localStorage.removeItem("paymentResponseStatus");
	});
	$('input[name="<portlet:namespace/>langUsedCollege"]').click(function(){
		
	if($(this).val() == 'other'){
		$('#lang_other_text').removeClass("d-none");
	}
	else{
		$('#lang_other_text').addClass("d-none");
	}
	});


	

 function discardChanges(){
	 $("#name").val("");
	 $("#telephone").val("");
	 $("#mobile").val("");
	 $("#relationshiptoapplicant").val("");
	 $("#emailaddress").val(""); 
	 
	 $("#relationshiptoapplicant").val("");
	 
	 
	 $("#FromDate").val("");
	 $("#Todate").val("");
	 $("#Otherlanguage").val("");
	 $(".internshipStatus").prop('checked', false);
	 $(".langUsedCollege").prop('checked', false);
	 $("#fileTitle").html("");
	 
	 $("#discard-modal").modal("hide");
	 
 }

 
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
		}else {
			document.getElementById("errorContainer-name").textContent = "";
		}
		var telephone = document.getElementById("telephone").value;
		if (!telephone) {
			errorMessages.push("<liferay-ui:message key='please-enter-telephone' />");
			document.getElementById("errorContainer-telephone").textContent = "<liferay-ui:message key='please-enter-telephone' />";
		}  else {
				document.getElementById("errorContainer-telephone").textContent = "";
				
			
		}
		var mobile = document.getElementById("mobile").value;
		if (!mobile) {
			errorMessages.push("<liferay-ui:message key='please-enter-mobile' />");
			document.getElementById("errorContainer-mobile").textContent = "<liferay-ui:message key='please-enter-mobile' />";
		}  else {
				document.getElementById("errorContainer-mobile").textContent = "";
		}
		var relationshiptoapplicant = document.getElementById("relationshiptoapplicant").value;
		if (!relationshiptoapplicant) {
			errorMessages.push("<liferay-ui:message key='please-enter-relationshiptoapplicant' />");
			document.getElementById("errorContainer-relationshiptoapplicant").textContent = "<liferay-ui:message key='please-enter-relationshiptoapplicant' />";
		} else {
			document.getElementById("errorContainer-relationshiptoapplicant").textContent = "";
		}
		
		
		var emailAddress = document.getElementById("emailaddress").value;
		
		if (!emailAddress) {
		errorMessages.push("<liferay-ui:message key='please-enter-emailaddress' />");
		document.getElementById("errorContainer-emailaddress").textContent = "<liferay-ui:message key='please-enter-emailaddress' />";
	} else {
		document.getElementById("errorContainer-emailaddress").textContent = "";
		let regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
        if (!regex.test(emailAddress)) {
        
        	errorMessages.push("<liferay-ui:message key='please-enter-valid-emailaddress' />");
			document.getElementById("errorContainer-emailaddress").textContent = "<liferay-ui:message key='please-enter-valid-emailaddress' />";
			 $('#errorContainer-emailaddress').removeClass('d-none');
        } else {
			document.getElementById("errorContainer-emailaddress").textContent = "";
			
		}
	}
		var authoriz2 = document.getElementById("authoriz2").value;
		
		
		if (!$('#authoriz2').is(":checked")) {
			errorMessages.push("<liferay-ui:message key='error-authoriz2' />");
			document.getElementById("errorContainer-authoriz2").textContent = "<liferay-ui:message key='error-authoriz2' />";
		}else {
			document.getElementById("errorContainer-authoriz2").textContent = "";
		}
		
		if (errorMessages.length > 0) {
		event.preventDefault();
	} else{
		submitRegistration();
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
	
	 let regex = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
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
   }
 
 
 /*payment popup function  */
 function paymentConfirmation(oCExamScheduleId,feeType) {

				jQuery.ajax({
					type: 'GET',
					url: '<%=confirm%>',
					data: {
						"<portlet:namespace />oCExamScheduleId": oCExamScheduleId,
					},
					success: function (response) {
						console.log(response)
						 if (response.length > 0) {
							var data = JSON.parse(response);
							$("#username").html(data.firstName);
							$("#phone").html(data.mobileNumber);
							$("#email").html(data.emailAddress);
							var examDate = new Date(data.examDate);
							examDate = moment(examDate).format('DD/MM/YYYY');
							$("#examDateTime").html(examDate);
							console.log(oCExamScheduleId)
							$("#oCExamScheduleId-popup").val(oCExamScheduleId);
							console.log("oCExamScheduleId"+$("#oCExamScheduleId").val());
							
							var examEndtime = "";
							var examTime = data.examTime;
							if (examTime.includes("PM") || examTime.includes("AM")) {
								examEndtime = addTimeWithAMPM(examTime, data.examDuration, 00)
							} else {
								examEndtime = addMinutesToTime(examTime, data.examDuration);
							}
							$("#examDateTime").append("( " + data.examTime + " to " + examEndtime + ")");
							$("#location").append("( " + data.venue + " )");
							$("#examTitle").html(data.oCExamTitle);
							$("#paymentDate").html(data.paymentDate);
							$("#examFee").html(data.feesPaid);
							$("#octExamFees").val(data.feesPaid);
							$("#feeType").val(feeType);
						 }
						$("#openBox").click();
					},
					error: function () {
						console.log(error)
					}
				});
			}


 
 function saveExamRegistrationPayment() {
		var examScheduleId = $("#oCExamScheduleId-popup").val();
		var examFees = $("#octExamFees").val();
		var feeType = $("#feeType").val();
		if (examFees > 0) {
			jQuery.ajax({
				type: 'GET',
				url: '<%=saveExamPayment%>',
				data: {
					"<portlet:namespace/>examScheduleId": examScheduleId,
					"<portlet:namespace/>fees": examFees,
					"<portlet:namespace/>feeType": feeType,
					
				},
				success: function (response) {
				 	if (response.length > 0) {
						var data = JSON.parse(response);
						if(data.makePayement){
							makeExamFeePayment(response);
						}else{
							$("#confirmRegistrationFm").submit();
						}
					}
				}
			});
		} else {
			$("#confirmRegistrationFm").submit();
		}
	}
 
 function makeExamFeePayment(response) {
		var data = JSON.parse(response); 
		var paymentUrl = data.url; 
		var tid = data.transactionId;
		var currency = data.currency; 
		var amount = data.fees; 
		var order_id = data.orderId;

		$("#paymentFormWrapper").append('<form id = "paymentForm" action = "' + paymentUrl + '" method = "POST" > ');
		$("#paymentFormWrapper form").append('<input type="text" name="tid" id="tid" value="' + tid + '"/></td>');
		$("#paymentFormWrapper form").append('<input type="text" name="order_id" value="' + order_id + '" />');
		$("#paymentFormWrapper form").append('<input type="text" name="currency" value="' + currency + '" />');
		$("#paymentFormWrapper form").append('<input type="text" name="amount" value="' + amount + '" />');
		$("#paymentFormWrapper form").append('<br><input type="submit" id="submitPaymentForm" value="Submit" />');

		$("#paymentFormWrapper form").submit();

	}
 /*end payment popup function  */
function submitRegistration(){

	    
	let form =$("#saveRegistrationFm")[0];
	var oCExamScheduleId=$("#oCExamScheduleId").val();
	
	   
	 console.log(form);
	 console.log(oCExamScheduleId);
	
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
	        	console.log(response);
	        	 if (response.length > 0) {
					var data = JSON.parse(response);
	        		paymentConfirmation(oCExamScheduleId,data.feeType);
	        	 }		
	        }
	       
	    });
	     
	}
 
 function cancelRegistration(){
	 var oCExamScheduleId = $("#oCExamScheduleId").val();
		
		
			jQuery.ajax({
				type: 'GET',
				url: '<%=cancelRegistrationURL%>',
				data: {
					"<portlet:namespace/>oCExamScheduleId": oCExamScheduleId,
				},
				success: function (response) {
					console.log("cancellation success");
				}
			});
		
	 
 }
 
function addMinutesToTime(time, minsAdd) {
	minsAdd = 2 * 60;
	function z(n) { return (n < 10 ? '0' : '') + n; };
	var bits = time.split(':');
	var mins = bits[0] * 60 + +bits[1] + +minsAdd;
	return z(mins % (24 * 60) / 60 | 0) + ':' + z(mins % 60);
}

function addTimeWithAMPM(inputTime, hoursToAdd, minutesToAdd) {
	const [timePart, amPm] = inputTime.split(' ');
	const [hoursStr, minutesStr] = timePart.split(':');

	let hours = parseInt(hoursStr);
	const minutes = parseInt(minutesStr);

	if (amPm === 'PM' && hours !== 12) {
		hours += 12;
	}

	hours += hoursToAdd;
	const totalMinutes = hours * 60 + minutes + minutesToAdd;

	const resultHours = Math.floor(totalMinutes / 60) % 12 || 12;
	const resultMinutes = totalMinutes % 60;

	const resultAmPm = totalMinutes < 720 ? 'AM' : 'PM';

	return '' + resultHours.toString().padStart(2, '0') + ":" + resultMinutes.toString().padStart(2, '0') + ' ' + resultAmPm + '';
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
 
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly"
			defer></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"
			integrity="sha512-CryKbMe7sjSCDPl18jtJI5DR5jtkUWxPXWaLCst6QjH8wxDexfRJic2WRmRXmstr2Y8SxDDWuBO6CQC6IE4KTA=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>		