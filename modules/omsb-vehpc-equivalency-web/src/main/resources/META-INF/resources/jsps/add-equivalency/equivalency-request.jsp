<%@page import="java.util.Calendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="yearCurrent" class="java.util.Date" />
<fmt:formatDate var="year" value="${yearCurrent}" pattern="yyyy" />
<%@ include file="../init.jsp"%>

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<portlet:renderURL var="equivalencyURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:resourceURL id="<%=MVCCommandNames.EQUIVALENCY_PERSON_SEARCH%>" var="personSearch">
	<portlet:param name="cmd" value="Doc" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommandNames.EQUIVALENCY_PERSON_POPPULATE_TO_FORM %>"
	var="personPoppulateToFormURL">
</portlet:resourceURL>

<portlet:actionURL name="<%=MVCCommandNames.EQUIVALENCY_ADD_REQUEST %>" var="saveEquivalencyRequestURL" />

<portlet:resourceURL
	id="<%=MVCCommandNames.GET_UNIVERSITY_LIST_RESOURCE%>"
	var="getUniversityList" />
<portlet:resourceURL
	id="<%=MVCCommandNames.GET_SPECIALTY_LIST_RESOURCE%>"
	var="getSpecialtyList" />

<div class="container" id="savenewequivalenc-wrap">

	<div class="omsb-card">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<liferay-ui:message key="new-equivalency-request" />
				</div>
			</div>
			<h4 class="omsb-card-title">
				<liferay-ui:message key="search-for-the-employee" />
			</h4>
			<div class="omsb-list-filter">
				<div class="row">
	
					<div class="col-lg-4 col-md-6">
						<aui:input label="dfrn" id="employeeDfrn" name="employeeDfrn"
							type="text" class="form-control" />
					</div>
					<%-- <div class="col-lg-3 col-md-6">
						<aui:input label="civil-id" id="employeeCivilId"
							name="employeeCivilId" type="text" class="form-control" />
					</div> --%>
					<div class="col-lg-4 col-md-6">
						<aui:input label="passport-number" id="employeePassportNumber"
							name="employeePassportNumber" type="text" cssClass="form-control" />
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:input label="date-of-birth" id="employeeDateOfBirth"
							name="employeeDateOfBirth" type="text" placeholder="DD/MM/YYYY"
							cssClass="form-control datePicker">
						</aui:input>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button type="button" class="btn omsb-bc-red-button" name="submit"
						onClick="handleSearchEmployee()">
						<liferay-ui:message key="search" />
					</button>
				</div>
			</div>
			<div class="omsb-list-view table-responsive" id="equivalency-request">
			</div>
		</div>
		<aui:form class="flex-container" method="POST"
			name="equivalencyRequest" action="${saveEquivalencyRequestURL}"
			enctype="multipart/form-data">

			<div class="omsb-card">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="applicant-details" />
				</h4>
				<aui:input id="personId" name="personId" type="hidden"
					class="form-control" />

				<div class="row">
					<div class="col-lg-4 col-md-6">
						<aui:input label="full-name" id="fullName" name="fullName" placeholder="full-name"
							type="text" class="form-control">
							 <aui:validator name="required" errorMessage="name-is-required"></aui:validator> 
						</aui:input>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:select name="nationality" id="nationality" label="nationality"
							value="" required="true" class="custom-select form-control" >
							<aui:option value=""><liferay-ui:message key="select-nationality"/> </aui:option>
							<c:forEach var="country" items="${allNationalities}">
								<aui:option value="${country.getCountryId()}">${country.getName(themeDisplay.getLocale())}</aui:option>
							</c:forEach>
							<aui:validator name="required" errorMessage="nationality-is-required"></aui:validator>
						</aui:select>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:input label="passport-number" id="passportNumber" placeholder="passport-number"
							name="passportNumber" type="text" value="" class="form-control">
							<aui:validator name="required" errorMessage="passport-is-required"></aui:validator>
						</aui:input>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:input label="date-of-birth" id="dateOfBirth"
							name="dateOfBirth" type="text" value="" placeholder="DD/MM/YYYY"
							cssClass="form-control datePicker">
							<aui:validator name="required" errorMessage="date-of-birth-is-required"></aui:validator>
						</aui:input>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:input label="email" id="email" name="email" type="text" placeholder="email"
							value="" class="form-control">
							<aui:validator name="required" errorMessage="email-is-required"></aui:validator>
						</aui:input>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:input label="mobile" id="cellphoneNumber" placeholder="mobile"
							name="cellphoneNumber" type="text" value="" class="form-control">
							<aui:validator name="required" errorMessage="cell-phone-number-required"></aui:validator>
							<aui:validator name="number" />
							<aui:validator errorMessage = "enter-valid-mobile-number" name="maxLength">15</aui:validator> 
						</aui:input>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:select name="profession" id="profession" label="profession" onchange="setprofessionPriSpeciality(this.value)">
							<aui:option value=""><liferay-ui:message key="select-profession"/></aui:option>
							<c:forEach var="professionValues" items="${professionList}">
								<aui:option value="${professionValues.getKey()}">
									<liferay-ui:message
										key="${professionValues.getName(themeDisplay.getLocale())}" />
								</aui:option>
							</c:forEach>
						</aui:select>
					</div>
					<div class="col-lg-4 col-md-6 d-none other-profession">
						<aui:input label="other-profession" name="otherProfession" type="text" placeholder="other-profession"
							value="" class="form-control">
						</aui:input>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="primary-specialty" /></label> <select
								class="custom-select form-control"
								name="<portlet:namespace/>primarySpecialty" id="primarySpecialty"
								class="form-control">
								<option value=""><liferay-ui:message key="select" /></option>
								<c:forEach var="specialtyValues" items="${specialtyList}">
								<aui:option value="${specialtyValues.getListTypeEntryId()}">
									<liferay-ui:message
										key="${specialtyValues.getName(themeDisplay.getLocale())}" />
								</aui:option>
							</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<aui:input label="dfrn" id="dfrn" name="dfrn" type="text" placeholder="dfrn"></aui:input>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6" id="verification-case-report">
						<aui:select name="verificationReportPaymentReceipt" id="verificationReportPaymentReceipt" label="verification-report-payment-receipt">
							<aui:option value=""><liferay-ui:message key="select"/></aui:option>
								<aui:option value="Verification Report">
									<liferay-ui:message key="verification-report" />
								</aui:option>
								<aui:option value="Payment Receipt">
									<liferay-ui:message key="payment-receipt" />
								</aui:option>
						</aui:select>
					</div>
					<div class="col-lg-6 col-md-6" id="document-case-report">
						<div class="form-group">
							<label ><liferay-ui:message key="document"/></label>
							<div class="custom-file mb-3">
								<div>
									<input type="file" cssClass="custom-file-input" id="paymentReceipt"
									name="<portlet:namespace />paymentReceipt">
								</div>
								<label class="custom-file-label" id="popup_sd_file_label" for="paymentReceipt"></label>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 d-none" id="case-report-verification" >
						<div class="form-group">
							<label><liferay-ui:message key="verification-report-payment-receipt" /></label>
							<div id="searched-verification-case-report">
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 d-none" id="case-report-document">
						<div class="form-group">
							<label><liferay-ui:message key="document" /></label>
							<div id="searched-document-case-report">
							</div>
						</div>
					</div>
					<div class="col-lg-2 col-md-6 d-none" id="case-report-document-button">
						<label></label>
						<div class="form-group mt-2 ml-3" id="searched-document-case-report-button">
						</div>
					</div>
				</div>

				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="certificate-to-be-evaluated" />
						<button class="btn omsb-bg-red-button" data-toggle="modal" onclick="addCertificateRow()"
							data-target="#markInsufficientModal" 
							type="button">
							<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="" />
							<liferay-ui:message key="add-certificate" />
						</button>

						<!-- <a data-toggle="modal" data-target="#markInsufficientModal" href="javascript:void(0)" >
										<img src="images/svg/mark_Insufficient_icon.svg">Add-Certificate</a> -->
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="dataTable1">
							<thead>
								<tr>
									<th><liferay-ui:message key="" /></th>
									<th><liferay-ui:message key="issued-country" /></th>
									<th><liferay-ui:message key="qualification" /></th>
									<th><liferay-ui:message key="action" /></th>
									<th class="d-none"></th>
									<th class="d-none"></th>
									<th class="d-none"></th>
									<th class="d-none"></th>
									<th class="d-none"></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<p id="errorContainer-evaluateCertificate" class="error-container"></p>
				</div>

				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="other-document" />
						<button class="btn omsb-bg-red-button"
							onclick="otherDocumentAddRow()" data-toggle="modal"
							data-target="#otherDocumentModal" href="javascript:void(0)"
							type="button">
							<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="" />
							<liferay-ui:message key="add-certificate" />
						</button>
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="otherDocumentDataTable">
							<thead>
								<tr>

									<th width="60%"><liferay-ui:message key="document-type" /></th>
									<th><liferay-ui:message key="action" /></th>
								</tr>
							</thead>
							<tbody id="otherDocumentDataTable">
							</tbody>
						</table>
					</div>
				</div>
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="official-request-letter" />
					</h4>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<div class="custom-file">
								<label class="control-label required"><liferay-ui:message key="attachments"/> </label>
									<label class="custom-file-label" for="<portlet:namespace />customFile"></label>
										<aui:input label="" name="officialRequestLetter" id="customFile" type="file" class="custom-file-input">
										<aui:validator name="required" errorMessage="official-request-letter-is-required"></aui:validator>
									</aui:input>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<aui:input type="hidden" name="otherDocumentCount"
							id="other_document_rowcount" value="1" />
						<aui:input type="hidden" name="certificateToBeEvaluatedCount"
							id="certificateToBeEvaluated" value="1" />
						<aui:input type="hidden" name="isDraft" id="isDraft" value="false" />	
						<div class="bottom-backbtn-wrap">
							<button class="btn omsb-bc-red-button" name="equivalencySendRequest"
								value="<liferay-ui:message key="send-request"/>" onClick="sendEqRequest()" type="button" title="<liferay-ui:message key="send-request" />">
								<liferay-ui:message key="send-request" />
							</button>
							<button class="btn omsb-bc-red-button" name="equivalencySADRequest"
								value="<liferay-ui:message key="save-as-draft" />" onClick="setIsDraft()" type="submit" title="<liferay-ui:message key="save-as-draft" />">
								<liferay-ui:message key="save-as-draft" />
							</button>
							<a class="btn omsb-btn btn-back" 
								href="${equivalencyURL }"><i class="fi fi-sr-arrow-left"></i>
								<liferay-ui:message key="back" /></a>
						</div>
						<div class="d-none">
							<button class="btn omsb-bc-red-button" name="equivalencyRequest" id="saveEquivalencyRequest"
								value="<liferay-ui:message key="send-request"/>" type="submit" title="<liferay-ui:message key="send-request" />">
								<liferay-ui:message key="send-request" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<!--// Inner Wrapper Contents -->

<!--  POPUP Modal for view Certificate Starts -->
<div class="modal fade omsb-modal" id="viewEquivalencyModal"
	tabindex="-1" role="dialog"
	aria-labelledby="viewEquivalencyModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="view-certificate" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6 label-box">
							<div class="label-name"><liferay-ui:message key="qualification"/></div>
							<div class="label-content qualificationView"></div>
						</div>
						<div class="col-md-6 label-box">
							<div class="label-name"><liferay-ui:message key="certificate"/></div>
							 <a target="_blank" class="download-link certificateView" href="${caseReportsFileURL}"><liferay-ui:message key="certificate" /></a>
						</div>
						<div class="col-md-6 label-box">
							<div class="label-name"><liferay-ui:message key="issued-from"/></div>
							<div class="label-content issuedFromView"></div>
						</div>
						<div class="col-md-6 label-box">
							<div class="label-name"><liferay-ui:message key="issue-date"/></div>
							<div class="label-content issueDateView"></div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<aui:button type="button" cssClass="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal" value="cancel" />
				</div>
		</div>
	</div>
</div>
<!--  POPUP Modal for view Certificate END -->

<!--  POPUP Modal for Certificate  -->

<div class="modal fade omsb-modal" id="markInsufficientModal"
	tabindex="-1" role="dialog"
	aria-labelledby="markInsufficientModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="add-certificate" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form name="addCertificateForm" onSubmit="event.preventDefault();">
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<aui:input name="addPopUpRow" id="addPopUpRow" type="hidden"></aui:input>
							<aui:select id="qualification" name="qualification"
								label="qualification" required="true">
								<aui:option value=""><liferay-ui:message key="select-qualification"/></aui:option>
								<c:forEach var="qualification" items="${qualificationList}">
									<aui:option value="${qualification.getKey()}">
										<liferay-ui:message
											key="${qualification.getName(themeDisplay.getLocale())}" />
									</aui:option>
								</c:forEach>
							</aui:select>
						 <p id="errorMessageQualification" style="color: red;"></p>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12" id="otherQualificationDiv" style="display: none;">
							<aui:input label="other-qualification" name="otherQualification" type="text" placeholder="other-qualification"/>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<div class="custom-file">
								<label class="control-label required"><liferay-ui:message key="certificate"/> </label>
										
									<label class="custom-file-label" id="certificateFileLabel"
										for="<portlet:namespace />certificateFile"></label>
										<aui:input label="" id="certificateFile" required="true"
										name="certificateFile" type="file"></aui:input>
								</div>
							</div>
							<p id="errorMessageIssueDate" style="color: red;"></p><!-- Error message  -->
						</div>
						<%-- <div class="col-md-6">
  						<aui:select id="issuedFrom" label="issued-country" name="issuedFrom"  required="true" >
							<aui:option value=""><liferay-ui:message key="select-issued-from"/></aui:option>
								<c:forEach var="country" items="${allNationalities}">
								<aui:option value="${country.getCountryId()}">${country.getName(themeDisplay.getLocale())}</aui:option>
							</c:forEach>
								<aui:option value="1"><liferay-ui:message key="other" /></aui:option>
							</aui:select>
					  <p id="errorMessageIssuedFrom" style="color: red;"></p>
						</div> --%>
						
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control"
									id="issuedFrom" label="issued-country" name="issuedFrom"
									onchange="getInstitutionList(this.value);">
									<aui:option value=""><liferay-ui:message key="select-issued-from"/></aui:option>
									<c:forEach items="${allNationalities}" var="country">
 										 <aui:option value="${country.getCountryId()}">${country.getName(themeDisplay.getLocale())}</aui:option> 
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<%-- <div class="col-lg-6 col-md-6 col-sm-12" id="issuedFromOtherDiv" style="display: none;">
							<aui:input label="issued-from-other" name="issuedFromOther" type="text" placeholder="issued-from-other"/>
						</div> --%>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="institution" /></label> <select
									cssClass="custom-select form-control"
									name="<portlet:namespace/>institution" id="institution"
									class="form-control">
									<option value=""><liferay-ui:message key="select" /></option>
									<c:forEach var="institute" items="${instituteList}">
										<option value="${institute.getListTypeEntryId()}">
											<liferay-ui:message
												key="${institute.getName(themeDisplay.getLocale())}" />
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<aui:input label="graduate-year" cssClass="form-control datePicker" placeholder="DD/MM/YYYY" id="issueDate" name="issueDate" type="text" required="true" />
					 		 <p id="errorMessageIssueDate" style="color: red;"></p> <!-- Error message  -->
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<aui:input label="duration-in-years" id="graduationDuration" name="graduationDuration" type="number" placeholder="duration-in-years" required="true"/>
						</div>
						<div class="col-md-12 d-none">
							<aui:input label="dfrn" id="dfrnPopup" name="dfrn" type="text" placeholder="dfrn"></aui:input>
						</div>
						<div class="col-md-12 d-none">
							<div class="form-group d-none">
								<div class="custom-file d-none">
									<aui:input id="verificationReportPaymentReceipt" label="verification-report-payment-receipt"
										name="verificationReportPaymentReceipt" type="file" cssClass="form-control"/>
									<label class="custom-file-label" id="verificationReportPaymentReceiptLabel"
										for="<portlet:namespace />verificationReportPaymentReceipt">
									</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<aui:button onClick="validateAndSave()" cssClass="btn omsb-bc-red-button" type="button" name="addCertificateBtn"
						 value="save" />
					<aui:button type="button" cssClass="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal" value="cancel" />
				</div>
			</aui:form>
		</div>
	</div>
</div>

<!--  POPUP Modal for Other Document -->


<div class="modal fade omsb-modal" id="otherDocumentModal" tabindex="-1"
	role="dialog" aria-labelledby="markInsufficientModalTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="otherDocumentLongTitle">
					<liferay-ui:message key="add-certificate" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<aui:form name="addOtherDocumentForm" onSubmit="event.preventDefault();">
					<div class="row">
						<div class="col-md-12">

							<aui:select id="documentType" name="documentType" label="type" required="true" cssClass="form-control">
								<aui:option value=""><liferay-ui:message key="select-type"/></aui:option>
								<c:forEach var="documentTypes" items="${documentTypeList }">
									<aui:option value="${documentTypes.getKey()}">
										<liferay-ui:message
											key="${documentTypes.getName(themeDisplay.getLocale())}" />
									</aui:option>
								</c:forEach>
							</aui:select>
							 <p id="errorMessageIssueDate" style="color: red;"></p><!-- Error message  -->
						</div>
						<div>
							<p class="d-none value" style="color: red;">
								<liferay-ui:message key="please-select-a-value" />
							</p>
						</div>
						<div class="col-md-12  d-none" id="otherDoctypeWrapper">
							<div class="form-group">
								<aui:input id="otherDoctype" name="otherDoctype" type="text"
									cssClass="form-control" />
							</div>
						</div>
						<div class="col-md-12">

							<div class="form-group">
								<div class="custom-file">
								<label class="control-label required"><liferay-ui:message key="attachment"/> </label>
									<label class="custom-file-label" id="attachmentFileLabel"
										for="<portlet:namespace />attachmentFile"></label>
										<aui:input label="" id="attachmentFile" required="true"
										name="attachmentFile" type="file"/>
								</div>
							</div>
								 <p id="errorMessageIssueDate" style="color: red;"></p><!-- Error message  -->
						</div>


					</div>
				</aui:form>
			</div>


			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button"
					onClick="validateAndSaveOtherDocument()" 
					title="Save"><liferay-ui:message key="save"/></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal"><liferay-ui:message key="cancel"/></button>
			</div>
		</div>
	</div>
</div>

<!--delete popup  -->
		<div class="modal fade omsb-modal" id="equivalency-delete" tabindex="-1" role="dialog"
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
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteRow()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->


<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("personSearchTbl").dataTable();
		$('#employer-comment').richText();
		
	});
	$(document).on('change','#<portlet:namespace />documentType',function(){
		var selectedDocType = $("#<portlet:namespace />documentType option:selected").val();
		var otherDoctypeWrapper = $("#otherDoctypeWrapper");
		if(selectedDocType == "others"){
			otherDoctypeWrapper.removeClass("d-none");
		}else{
			otherDoctypeWrapper.addClass("d-none");
		}
	});

	
function addCertificateRow() {
	document.getElementById('markInsufficientModal').style.display = 'block';
	document.getElementById("<portlet:namespace />addCertificateForm").reset();
	$('#certificateFileLabel').html('');
	$('#verificationReportPaymentReceiptLabel').html('');
	$('#<portlet:namespace />addPopUpRow').val('');
}
</script>

<script>
	
	/* ----------------------Add Certificates all JS method code----------------------- */
var addPopUpRow = 0;

function setValues(){
	var A = AUI();
	var addPopUpRowVal = A.one("#<portlet:namespace />addPopUpRow").val();
	console.log("addPopUpRowVal::::"+addPopUpRowVal);
	var qualification = A.one("#<portlet:namespace />qualification").val();
	var qualificationText = $("#<portlet:namespace />qualification option:selected").text();
	
	if(qualification=='other'){
		qualificationText = qualification = A.one("#<portlet:namespace />otherQualification").val();
	}
	var certificate = document.getElementById("<portlet:namespace />certificateFile").files[0];
	var dfrn = A.one("#<portlet:namespace />dfrnPopup").val();
	
	var issuedFrom = A.one("#<portlet:namespace />issuedFrom").val();
	var issuedFromText = $("#<portlet:namespace />issuedFrom option:selected").text();
	console.log("qualificationText : "+qualificationText+" issuedFromText : "+issuedFromText);	
	/* if(issuedFrom==1){
		issuedFromText = issuedFrom = A.one("#<portlet:namespace />issuedFromOther").val();
	} */
	var issueDate = A.one("#<portlet:namespace />issueDate").val();
	var institution = A.one("#institution").val();
	var graduationDuration= A.one("#<portlet:namespace />graduationDuration").val();

/* 	var verificationReportPaymentReceipt = document.getElementById("<portlet:namespace />verificationReportPaymentReceipt").files[0]; */
	 
	console.log("addPopUpRowVal::::"+qualification+" , certificate : "+certificate+" , dfrn "+dfrn+" , issuedFrom : "+issuedFrom+" ,issueDate ;"+issueDate);
	var table1 = document.getElementById('dataTable1').querySelector('tbody');
	

	var rowCount1 = table1.rows.length;
	var row1 = issuedFromCell = documentTypeCell = actionCell1 = issuedFromOtherCell = issueDateCell = certificateCell = vReportPaymentReceiptCell = cell7 = institutionCell = graduationDurationCell ="";
	if(addPopUpRowVal != undefined && addPopUpRowVal != null && addPopUpRowVal >0){
		var editrowcnt = addPopUpRowVal - 1;
		console.log("addPopUpRow::inside::"+addPopUpRowVal);
		row1 = $('#dataTable1 tr').eq(editrowcnt);
		docCheckboxCell = row1.find('td:nth-child(1)');
		issuedFromTextCell = row1.find('td:nth-child(2)');
		qualificationTextCell = row1.find('td:nth-child(3)');
		actionCell1 = row1.find('td:nth-child(4)');
		issuedFromOtherCell = row1.find('td:nth-child(5)');
		issueDateCell = row1.find('td:nth-child(6)');
		certificateCell = row1.find('td:nth-child(7)');
		vReportPaymentReceiptCell = row1.find('td:nth-child(8)');
		issuedFromCell = row1.find('td:nth-child(9)');
		documentTypeCell = row1.find('td:nth-child(10)');
		cell7 = row1.find('td:nth-child(11)');
		fileEntryIdCell = row1.find('td:nth-child(12)');
		documentInfoIdCell = row1.find('td:nth-child(13)');
		institutionCell = row1.find('td:nth-child(14)');
		graduationDurationCell = row1.find('td:nth-child(15)');
		
		
		
	}else{
		addPopUpRow++;
		row1 = table1.insertRow(rowCount1);	
		docCheckboxCell = row1.insertCell(0);
		issuedFromTextCell = row1.insertCell(1);
		qualificationTextCell = row1.insertCell(2);
		actionCell1 = row1.insertCell(3);
		issuedFromOtherCell = row1.insertCell(4);
		issueDateCell = row1.insertCell(5);
		certificateCell = row1.insertCell(6);
		vReportPaymentReceiptCell = row1.insertCell(7);
		issuedFromCell = row1.insertCell(8);
		documentTypeCell = row1.insertCell(9);
		cell7 = row1.insertCell(10);
		fileEntryIdCell = row1.insertCell(11);
		documentInfoIdCell = row1.insertCell(12);
		institutionCell = row1.insertCell(13);
		graduationDurationCell = row1.insertCell(14);
	}
	var docCheckboxElement = document.createElement("input");
	docCheckboxElement.type = "checkbox";
	docCheckboxElement.name = "docCheckbox" + addPopUpRow;
	docCheckboxElement.id = "docCheckbox" + addPopUpRow;
	docCheckboxElement.className = "custom-control-input";
	var customCheckboxDiv = document.createElement("div");
	customCheckboxDiv.className = "custom-control custom-checkbox";
	var labelElement = document.createElement("label");
	labelElement.className = "custom-control-label m-0";
	labelElement.htmlFor = docCheckboxElement.id;
	
	var issuedFromTextElement = document.createElement("input");
	issuedFromTextElement.type = "text";
	issuedFromTextElement.value = $.trim(issuedFromText);
	issuedFromTextElement.readOnly = true;
	issuedFromTextElement.name = "issuedFromText" + addPopUpRow;
	issuedFromTextElement.id = "issuedFromText" + addPopUpRow;
	issuedFromTextElement.className = "form-control";
	console.log("update"+qualification);
	
	
  	var qualificationTextElement = document.createElement("input");
  	qualificationTextElement.type = "text";
  	qualificationTextElement.value = $.trim(qualificationText);
  	qualificationTextElement.readOnly = true;
  	qualificationTextElement.name = "qualificationText" + addPopUpRow;
  	qualificationTextElement.id = "qualificationText" + addPopUpRow;
  	qualificationTextElement.className="form-control";
	
	var actionElement1 = document.createElement("button");
	actionElement1.className = "btn delete_btn";
	actionElement1.value = "Delete";
	actionElement1.type = "button";
	var imageElement1 = document.createElement("img");
	imageElement1.src = '<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg';
	
	actionElement1.setAttribute('data-toggle', 'modal');
	actionElement1.setAttribute('data-target', '#equivalency-delete');
	actionElement1.setAttribute('data-rowcount', 'addPopUpRow');
	actionElement1.setAttribute('onClick', 'setData(this)');
	
	var element4 = document.createElement("button");
	element4.className = "btn mx-2";
	element4.value="edit";
	element4.type="button";
	var imageElement2 = document.createElement("img");
	imageElement2.src = '<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg';
	element4.setAttribute("data-editid", addPopUpRow);
	element4.setAttribute('onClick', 'editRow(this)');
	
	
	var dfrnElement = document.createElement("input");
	if(dfrn != undefined && dfrn != null){
		dfrnElement.type = "text";
		dfrnElement.value = dfrn;
		dfrnElement.readOnly = true;
		dfrnElement.name = "dfrn" + addPopUpRow;
		dfrnElement.id = "dfrn" + addPopUpRow;
		dfrnElement.style="display:none;"
		dfrnElement.className="form-control";
	}
	var issueDateElement = document.createElement("input");
	issueDateElement.type = "text";
	issueDateElement.value = issueDate;
	issueDateElement.name = "issueDate" + addPopUpRow;
	issueDateElement.id = "issueDate" + addPopUpRow;
	issueDateElement.style="display:none;"
	issueDateElement.className = "form-control";

	var certificateElement = document.createElement("input");
	certificateElement.type = "file";
	certificateElement.name = "certificatetbl" + addPopUpRow;
	certificateElement.id = "certificate" + addPopUpRow;
	certificateElement.style="display:none;"
	var container = new DataTransfer();
	container.items.add(certificate);
	certificateElement.className = "form-control";
	certificateElement.files = container.files;
	
	var vReportPaymentReceiptElement = document.createElement("input");
	/* if(verificationReportPaymentReceipt != undefined && verificationReportPaymentReceipt != null){
		
		vReportPaymentReceiptElement.type = "file";
		vReportPaymentReceiptElement.name = "verificationReportPaymentReceipt" + addPopUpRow;
		vReportPaymentReceiptElement.id = "verificationReportPaymentReceipt" + addPopUpRow;
		vReportPaymentReceiptElement.style="display:none;"
		var container = new DataTransfer();
		container.items.add(verificationReportPaymentReceipt);
		vReportPaymentReceiptElement.className = "form-control";
		vReportPaymentReceiptElement.files = container.files;
		vReportPaymentReceiptElement.data = container;
	} */
	
	var issuedFromElement = document.createElement("input");
	issuedFromElement.type = "hidden";
	issuedFromElement.value = issuedFrom;
	issuedFromElement.readOnly = true;
	issuedFromElement.name = "issuedFrom" + addPopUpRow;
	issuedFromElement.id = "issuedFrom" + addPopUpRow;
	issuedFromElement.className = "form-control";
	issuedFromElement.style="display:none;"
	console.log("update"+qualification);
	
	
  	var documentTypeElement = document.createElement("input");
	documentTypeElement.type = "hidden";
	documentTypeElement.value = qualification;
	documentTypeElement.readOnly = true;
	documentTypeElement.name = "qualification" + addPopUpRow;
	documentTypeElement.id = "qualification" + addPopUpRow;
	documentTypeElement.className="form-control";
	documentTypeElement.style="display:none;"
	
    var element7 = document.createElement("input");
    element7.type="hidden"
    element7.value=addPopUpRow;
    
    var documentInfoIdElement = document.createElement("input");
    documentInfoIdElement.type = "hidden";
    documentInfoIdElement.readOnly = true;
    documentInfoIdElement.name = "documentInfoId" + addPopUpRow;
    documentInfoIdElement.id = "documentInfoId" + addPopUpRow;
    documentInfoIdElement.className = "form-control";
    documentInfoIdElement.style="display:none;"
    
    var institutionElement = document.createElement("input");
    institutionElement.type = "hidden";
    institutionElement.value = institution;
    institutionElement.readOnly = true;
    institutionElement.name = "institution" + addPopUpRow;
    institutionElement.id = "institution" + addPopUpRow;
    institutionElement.className = "form-control";
    institutionElement.style="display:none;"
    
    
    var graduationDurationElement = document.createElement("input");
    graduationDurationElement.type = "hidden";
    graduationDurationElement.value = graduationDuration;
    graduationDurationElement.readOnly = true;
    graduationDurationElement.name = "graduationDuration" + addPopUpRow;
    graduationDurationElement.id = "graduationDuration" + addPopUpRow;
    graduationDurationElement.className = "form-control";
    graduationDurationElement.style="display:none;"
    
   	var fileEntryIdElement = document.createElement("input");
    fileEntryIdElement.type = "hidden";
    fileEntryIdElement.readOnly = true;
    fileEntryIdElement.name = "fileEntryId" + addPopUpRow;
    fileEntryIdElement.id = "fileEntryId" + addPopUpRow;
    fileEntryIdElement.className = "form-control";
    fileEntryIdElement.style="display:none;"
	
	if(addPopUpRowVal != undefined && addPopUpRowVal != null && addPopUpRowVal >0){
		issuedFromTextCell.empty();
		issuedFromTextCell.append(issuedFromTextElement);
		qualificationTextCell.empty();
		qualificationTextCell.append(qualificationTextElement);
		issuedFromCell.empty();
		issuedFromCell.append(issuedFromElement);
		documentTypeCell.empty();
		documentTypeCell.append(documentTypeElement);
		actionCell1.empty();
		actionCell1.append(element4);
		actionCell1.append(actionElement1);
		
		actionElement1.appendChild(imageElement1);
		element4.appendChild(imageElement2);
		issuedFromOtherCell.empty();
		issuedFromOtherCell.append(dfrnElement);
		issuedFromOtherCell.setAttribute("class", "d-none");
		issueDateCell.empty();
		issueDateCell.append(issueDateElement);
		issueDateCell.setAttribute("class", "d-none");
		certificateCell.empty();
		certificateCell.append(certificateElement);
		vReportPaymentReceiptCell.empty();
		vReportPaymentReceiptCell.append(vReportPaymentReceiptElement);
		customCheckboxDiv.appendChild(docCheckboxElement);
		customCheckboxDiv.appendChild(labelElement);
		docCheckboxCell.appendChild(customCheckboxDiv);
		cell7.empty();
		cell7.append(element7);
		fileEntryIdCell.empty();
		fileEntryIdCell.append(fileEntryIdElement);
		documentInfoIdCell.empty();
		documentInfoIdCell.append(documentInfoIdElement);
		institutionCell.empty();
		institutionCell.append(institutionElement);
		graduationDurationCell.empty();
		graduationDurationCell.append(graduationDurationElement);
		
	}else{
		issuedFromTextCell.appendChild(issuedFromTextElement);
		qualificationTextCell.appendChild(qualificationTextElement);
		actionCell1.appendChild(element4);
		actionCell1.appendChild(actionElement1);
		issuedFromOtherCell.appendChild(dfrnElement);
		issuedFromOtherCell.setAttribute("class", "d-none");
		issueDateCell.appendChild(issueDateElement);
		issueDateCell.setAttribute("class", "d-none");
		certificateCell.appendChild(certificateElement);
		certificateCell.setAttribute("class", "d-none");
		vReportPaymentReceiptCell.appendChild(vReportPaymentReceiptElement);
		vReportPaymentReceiptCell.setAttribute("class", "d-none");
		issuedFromCell.appendChild(issuedFromElement);
		issuedFromCell.setAttribute("class", "d-none");
		documentTypeCell.appendChild(documentTypeElement);
		documentTypeCell.setAttribute("class", "d-none");
		customCheckboxDiv.appendChild(docCheckboxElement);
		customCheckboxDiv.appendChild(labelElement);
		docCheckboxCell.appendChild(customCheckboxDiv);
		cell7.appendChild(element7);
		cell7.setAttribute("class", "d-none");
		actionElement1.appendChild(imageElement1);
		element4.appendChild(imageElement2);
		fileEntryIdCell.appendChild(fileEntryIdElement);
		fileEntryIdCell.setAttribute("class", "d-none");
		documentInfoIdCell.appendChild(documentInfoIdElement);
		documentInfoIdCell.setAttribute("class", "d-none");
		
		institutionCell.appendChild(institutionElement);
		institutionCell.setAttribute("class", "d-none");
		graduationDurationCell.appendChild(graduationDurationElement);
		graduationDurationCell.setAttribute("class", "d-none");
		
	}
	
	A.one("#<portlet:namespace />qualification").val('');
	//A.one("#<portlet:namespace />certificate").val('');
	A.one("#<portlet:namespace />dfrnPopup").val('');
	//A.one("#<portlet:namespace />verificationReportPaymentReceipt").val('');
	//document.getElementById("verificationReportPaymentReceiptLabelEdit").value = addPopUpRow;
	document.getElementById("<portlet:namespace />certificateToBeEvaluated").value = addPopUpRow;
}

function editRow(editid) {
	var row = $(editid).closest("tr");
	console.log("row>>>>"+JSON.stringify(row));
	
	console.log("issuedFrom>>>>"+issuedFrom+" , qualification : "+qualification);
	var dfrn = row.find("td:eq(3) input").val();
	var issueDate = row.find("td:eq(4) input").val();
	console.log("dfrn>>>>"+dfrn+" , issueDate : "+issueDate);
	var certificateName = row.find("td:eq(5) input").val();
	console.log("certificateName>>>>"+certificateName);
	
	var issuedFrom = row.find("td:eq(7) input").val();
	var qualification = row.find("td:eq(8) input").val();
	
	var addPopUpRow = row.find("td:eq(9) input").val();
	var institution = row.find("td:eq(12) input").val();
	var graduationDuration = row.find("td:eq(13) input").val();
	$('#markInsufficientModal').modal('show');

	/*$("#<portlet:namespace/>verificationReportPaymentReceiptEdit").text(vReportPaymentReceipt);
	  $("#<portlet:namespace/>certificateFileEdit").val(certificate);  
	  
	  document.getElementById('verificationReportPaymentReceiptLabel').innerHTML = vReportPaymentReceipt;
	  document.getElementById('certificateFileLabel').innerHTML = certificate;
	  */
	
	  $("#<portlet:namespace/>qualification").val(qualification);
	  $("#<portlet:namespace/>dfrnPopup").val(dfrn);
	  $("#<portlet:namespace/>issuedFrom").val(issuedFrom);
	  $("#<portlet:namespace/>issueDate").val(issueDate);
	  $("#institution").val(institution);
	  $("#<portlet:namespace/>igraduationDuration").val(graduationDuration);
	  
	  $("#<portlet:namespace/>addPopUpRow").val(addPopUpRow);
	  //$("#<portlet:namespace/>verificationReportPaymentReceipt")
	  
	  if(row.find("td:eq(5) input")[0].files.length >0){
	  	var certificate = row.find("td:eq(5) input")[0].files[0];
	  	var container1 = new DataTransfer();
		container1.items.add(certificate);
		var certificateFile1 = document.getElementById("<portlet:namespace />certificateFile");
		certificateFile1.files = container1.files;
	  }
	  if(row.find("td:eq(6) input")[0].files.length >0){
		var vReportPaymentReceipt = row.find("td:eq(6) input")[0].files[0];
		var container2 = new DataTransfer();
		container2.items.add(vReportPaymentReceipt);
		//var verificationRPReceipt = document.getElementById("<portlet:namespace />verificationReportPaymentReceipt");
		verificationRPReceipt.files = container2.files;
	  }
	}
	
	

function validateAndSave() {
	document.getElementById('errorContainer-evaluateCertificate').textContent = "";
	var A = AUI();
	var qualification = A.one("#<portlet:namespace />qualification").val();
	var certificate = document.getElementById("<portlet:namespace />certificateFile").files[0];
	var issuedFrom = A.one("#<portlet:namespace />issuedFrom").val();
	var issueDate = A.one("#<portlet:namespace />issueDate").val();
	var graduationDuration = A.one("#<portlet:namespace />graduationDuration").val();
	var error = false;

	if (!qualification) {
		error = true;
	}

	if (!certificate) {
		error = true;
	}

	if (!issuedFrom) {
		error = true;
	}

	if (!issueDate) {
		error = true;
	}
	if(!graduationDuration){
		error = true;
	}
		
	if (error) {
		console.log("error");
		var formValidator = Liferay.Form.get('<portlet:namespace />addCertificateForm').formValidator;
		formValidator.validateField(A.one("#<portlet:namespace />qualification"));
		formValidator.validateField(A.one("#<portlet:namespace />certificateFile"));
		formValidator.validateField(A.one("#<portlet:namespace />issuedFrom"));
		formValidator.validateField(A.one("#<portlet:namespace />issueDate"));
		formValidator.validateField(A.one("#<portlet:namespace />graduationDuration"));
	}else{
		$('#markInsufficientModal').modal('hide');
		setValues();
	}
	var table1 = document.getElementById('dataTable1').querySelector('tbody');
	var tableRowValue = table1.rows.length;
	console.log('tableRowValue ??', tableRowValue);
	$("#<portlet:namespace />certificateToBeEvaluated").val(tableRowValue + 1);
}

function deleteCertRow(delid) {
	var result = confirm('<liferay-ui:message key="want-to-delete-the-entry" />');
	if (result) {
		var table = document.getElementById("dataTable1");
		var row = $(delid).closest("tr");
		var rowIndex = row[0].rowIndex;
		table.deleteRow(rowIndex);
		addPopUpRow--;
	
		var qualificationInput = row.find("input[name^='qualification']");
		var certificateInput = row.find("input[name^='certificate']");
		var dfrnInput = row.find("input[name^='dfrnPopup']");
		var otherQualificationInput = row.find("input[name^='otherQualification']");
		var issuedFromInput = row.find("input[name^='issuedFrom']");
		var issuedFromOtherInput = row.find("input[name^='issuedFromOther']");
		var issueDateInput = row.find("input[name^='issueDate']");
		//var verificationReportPaymentReceiptInput = row.find("input[name^='verificationReportPaymentReceipt']");
		if (qualificationInput.length > 0) {
			qualificationInput.val('');
		}
		if (certificateInput.length > 0) {
		    certificateInput.val('');
		}
		if (dfrnInput.length > 0) {
			dfrnInput.val('');
		}
		if (otherQualificationInput.length > 0) {
	    	otherQualificationInput.val('');
	  	}
	  	if (issuedFromInput.length > 0) {
	    	issuedFromInput.val('');
	  	}
	  	if (issuedFromOtherInput.length > 0) {
	    	issuedFromOtherInput.val('');
	  	}
	  	if (issueDateInput.length > 0) {
	    	issueDateInput.val('');
	  	}
	  	/* if (verificationReportPaymentReceiptInput.length > 0) {
	    	verificationReportPaymentReceiptInput.val('');
	  	} */
	}
}	

/* ----------------------Other Document all JS method code----------------------- */
var addDocumentPopUpRow = $("#<portlet:namespace />other_document_rowcount").val();
function otherDocumentAddRow(){
	document.getElementById('otherDocumentModal').style.display = 'block';
	document.getElementById("<portlet:namespace />addOtherDocumentForm").reset();
}
		
function otherDocumentSetValues(){
	
	var A = AUI();
	var documentType = A.one("#<portlet:namespace />documentType").val();
	var attachmentFile = document.getElementById("<portlet:namespace />attachmentFile").files[0];
	var table1 = document.getElementById('otherDocumentDataTable').querySelector('tbody');
	var docTypeName = $( "#<portlet:namespace />documentType option:selected" ).text().trim();
	var otherDocType = null;
	if(documentType == "others"){
		otherDocType =  $("#<portlet:namespace />otherDoctype").val();
		docTypeName = otherDocType;
	}
	var rowCount1 = table1.rows.length;
	var row1 = table1.insertRow(rowCount1);
	
 	var documentTypeNameCell = row1.insertCell(0);
	var documentTypeNameElement = document.createElement("input");
	documentTypeNameElement.type = "text";
	documentTypeNameElement.value = docTypeName;
	documentTypeNameElement.readOnly = true;
	documentTypeNameElement.name = "docTypeName" + addDocumentPopUpRow;
	documentTypeNameElement.id = "docTypeName" + addDocumentPopUpRow;
	documentTypeNameElement.className="form-control";
	documentTypeNameCell.appendChild(documentTypeNameElement);
	 
	var attachementCell = document.createElement("input");
	attachementCell.type = "file";
	attachementCell.name = "attachmentFile" + addDocumentPopUpRow;
	attachementCell.id = "attachmentFile" + addDocumentPopUpRow;
	attachementCell.style="display:none;"
	var container = new DataTransfer();
	container.items.add(attachmentFile);
	attachementCell.className="form-control";
	documentTypeNameCell.appendChild(attachementCell);
	attachementCell.files = container.files; 
	 
	var actionCell = row1.insertCell(1);
	var actionElement = document.createElement("button");
	actionElement.className = "btn delete_btn";
	actionElement.value = "Delete";
	actionElement.type = "button";
	actionElement.setAttribute('type', 'button');
	var imageElement = document.createElement("img");
	imageElement.src = '<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg';
	actionElement.appendChild(imageElement);
	actionElement.setAttribute('data-toggle', 'modal');
	actionElement.setAttribute('data-target', '#equivalency-delete');
	actionElement.setAttribute('data-rowcount', 'addDocumentPopUpRow');
	actionElement.setAttribute('onClick', 'setData(this)');
	actionCell.appendChild(actionElement);
	
	var documentTypeElement = document.createElement("input");
	documentTypeElement.type = "hidden";
	documentTypeElement.value = documentType;
	documentTypeElement.readOnly = true;
	documentTypeElement.name = "documentType" + addDocumentPopUpRow;
	documentTypeElement.id = "documentType" + addDocumentPopUpRow;
	documentTypeElement.className="form-control";
	documentTypeNameCell.appendChild(documentTypeElement);
		
	var otherDocTypeNameElement = document.createElement("input");
	otherDocTypeNameElement.type = "hidden";
	otherDocTypeNameElement.value = otherDocType;
	otherDocTypeNameElement.readOnly = true;
	otherDocTypeNameElement.name = "otherDocType" + addDocumentPopUpRow;
	otherDocTypeNameElement.id = "otherDocType" + addDocumentPopUpRow;
	otherDocTypeNameElement.className="form-control";
	documentTypeNameCell.appendChild(otherDocTypeNameElement);

	A.one("#<portlet:namespace />documentType").val('');
	A.one("#<portlet:namespace />attachmentFile").val('');
	A.one("#<portlet:namespace />otherDoctype").val('');

	document.getElementById("attachmentFileLabel").innerHTML = '';
	document.getElementById("<portlet:namespace />other_document_rowcount").value = addDocumentPopUpRow;
	addDocumentPopUpRow++;
}
	
function validateAndSaveOtherDocument() {
	var A = AUI();
	var documentType = A.one("#<portlet:namespace />documentType");
	var attachmentFile = document.getElementById("<portlet:namespace />attachmentFile").files[0];
	var error = false;
		
	if (!documentType) {
		error = true;
	}

	if (!attachmentFile) {
		error = true;
	}

	if (error) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addOtherDocumentForm').formValidator;
		formValidator.validateField(A.one("#<portlet:namespace />documentType"));
		formValidator.validateField(A.one("#<portlet:namespace />attachmentFile"));
	}else{
		$('#otherDocumentModal').modal('hide');
		otherDocumentSetValues();
	}
}

function otherDocumentDeleteRow(delid) {
	
	var result = confirm('<liferay-ui:message key="want-to-delete-the-entry" />');
	if (result) {
		var table = document.getElementById("otherDocumentDataTable");
		var row = $(delid).closest("tr");
		var rowIndex = row[0].rowIndex;
		table.deleteRow(rowIndex);
		// addDocumentPopUpRow--;
	
		var documentTypeInput = row.find("input[name^='documentType']");
		var attachmentFileInput = row.find("input[name^='attachmentFile']");
		if (documentTypeInput.length > 0) {
			documentTypeInput.val('');
		}
		if (attachmentFileInput.length > 0) {
			attachmentFileInput.val('');
		}
		// document.getElementById("<portlet:namespace />other_document_rowcount").value = addDocumentPopUpRow;
	}
}
	
/* ---------------------Employee Search method ---------- */
 
/*  function searchEmployeeButton(){
	console.log("searchEmployeeButton.............");
	alert("searchEmployeeButton........");
	var A = AUI();
	var employeeCivilId = A.one("#<portlet:namespace />employeeCivilId").val();
	var employeePassportNumber = A.one("#<portlet:namespace />employeePassportNumber").val();
	var employeeDateOfBirth = A.one("#<portlet:namespace />employeeDateOfBirth").val();
	console.log("employeeCivilId : " +employeeCivilId +" employeePassportNumber : "+employeePassportNumber+" employeeDateOfBirth : " +employeeDateOfBirth);
	
} */

/* Ajax call for person search button--------------------*/

function handleSearchEmployee(){
	
	var employeeDfrn = $("#<portlet:namespace />employeeDfrn").val();
	var employeeCivilId = $("#<portlet:namespace />employeeCivilId").val();
	var employeePassportNumber = $("#<portlet:namespace />employeePassportNumber").val();
	var employeeDateOfBirth = $("#<portlet:namespace />employeeDateOfBirth").val();
	
	 /* Clear old data from the */ 
	/* $("#personSearchTbl > tbody").html(""); */
	
    $.ajax({
        url: '<%=personSearch.toString()%>',
        async : false,
        data : {
			<portlet:namespace />employeeDfrn : employeeDfrn,
			<portlet:namespace />employeeCivilId : employeeCivilId,
			<portlet:namespace />employeePassportNumber : employeePassportNumber,
			<portlet:namespace />employeeDateOfBirth : employeeDateOfBirth
        },
        type : 'POST',
        success : function(data) {
      		$("#equivalency-request").html(data);
        },
    });
};

function handleSelectEmployee(checkbox) {
	if(checkbox.checked){
    	var row = checkbox.closest('tr');
    	var dfrn = $(row).find("td:nth-child(1)").html();
        var empName = $(row).find("td:nth-child(2)").html();
        var dateOfBirth = $(row).find("td:nth-child(3)").html();
        var personId = checkbox.value;
        populatePersonData(empName, dateOfBirth, personId, dfrn);
    } else{
        console.log(checkbox.value+"False");
    }
}

function populatePersonData(empName, dateOfBirth, personId, dfrn){
	console.log("empName:" + empName+", dateOfBirth : "+dateOfBirth+", personId "+personId , ", dfrn ::"+dfrn)

	$.ajax({
		url: '${personPoppulateToFormURL}',
		async : false,
		data : {
			<portlet:namespace />dateOfBirth : dateOfBirth,
			<portlet:namespace />personId : personId,
			<portlet:namespace />dfrn : dfrn,
		},
		dataType : 'json',
		type : 'POST',
		cache : false,
		success : function(res) {

			var dataJson = res.personAllDetails;
			var caseReportData = res.caseReport;
			var specialtyArray = res.specialtyListJsonArray;
           
			console.log(":::::::data:::::::ddd:::",dataJson.length);
			
			var data = dataJson[0];
			console.log(":::::::data is ? ? :::::::::",data);
			$("#<portlet:namespace/>fullName").val(empName);
			$("#<portlet:namespace/>nationality").val(data.nationality);
			$("#<portlet:namespace/>passportNumber").val(data.passportNumber);
			$("#<portlet:namespace/>dateOfBirth").val(data.dateOfBirth);
			$("#<portlet:namespace/>email").val(data.email);
			$("#<portlet:namespace/>cellphoneNumber").val(data.mobileNumber);
			$("#<portlet:namespace/>profession").val(data.profession);
			if (data.profession == 'other') {
				$(".other-profession").removeClass("d-none");
			}
			$("#<portlet:namespace/>otherProfession").val(data.professionOther);
			$("#<portlet:namespace/>personId").val(data.personId);
			$("#<portlet:namespace/>dfrn").val(data.dfrn);
			$("#dataTable1").find('tbody').empty();
			
			var table1 = document.getElementById('dataTable1').querySelector('tbody');
			
			var specialty = "<option value=''><liferay-ui:message key='select'/></option>";
			if(specialtyArray != undefined){
			 for (var i = 0; i < specialtyArray.length; i++) {
            	if(specialtyArray[i].id == data.primarySpeciality){
            		specialty += "<option value='" + specialtyArray[i].id + "' selected>" + specialtyArray[i].name + "</option>";
            	}
            	else{
            		specialty += "<option value='" + specialtyArray[i].id + "'>" + specialtyArray[i].name + "</option>";
            	}
	          }
			}
           
            $("#primarySpecialty").html(specialty); 
	 		
			if(Object.keys(caseReportData).length != 0){
				$('#document-case-report').addClass("d-none");
				$('#verification-case-report').addClass("d-none");
				$('#case-report-document').removeClass("d-none")
				$('#case-report-document-button').removeClass("d-none")
				$('#case-report-verification').removeClass("d-none")
				var verificationCaseReportDiv = document.getElementById('searched-verification-case-report');
				var verificationCaseReportElement = document.createElement("input");
				verificationCaseReportElement.type = "text";
				verificationCaseReportElement.value = caseReportData.verificationReport;
				verificationCaseReportElement.readOnly = true;
				verificationCaseReportElement.name = "<portlet:namespace/>verificationReportPaymentReceipt";
				verificationCaseReportElement.id = "<portlet:namespace/>verificationReportPaymentReceipt";
				verificationCaseReportElement.className = "form-control success-field";
				verificationCaseReportDiv.innerHTML='';
				verificationCaseReportDiv.appendChild(verificationCaseReportElement);
				
				var documentCaseReportDiv = document.getElementById('searched-document-case-report');
				var documentCaseReportElement = document.createElement("input");
				documentCaseReportElement.type = "text";
				documentCaseReportElement.value = caseReportData.fileName;
				documentCaseReportElement.readOnly = true;
				documentCaseReportElement.name = "<portlet:namespace/>verificationReportPaymentReceipt";
				documentCaseReportElement.id = "<portlet:namespace/>verificationReportPaymentReceipt";
				documentCaseReportElement.className = "form-control success-field";
				documentCaseReportDiv.innerHTML='';
				documentCaseReportDiv.appendChild(documentCaseReportElement);
				
				var documentCaseReportButtonDiv = document.getElementById('searched-document-case-report-button');
				documentCaseReportButtonDiv.innerHTML='';
				var documentCaseReportButtonElement = document.createElement("a");
				documentCaseReportButtonElement.innerHTML = "View";
				documentCaseReportButtonElement.className = "download-link";
				documentCaseReportButtonElement.href = caseReportData.fileEntryUrl;
				documentCaseReportButtonElement.target="_blank"
				documentCaseReportButtonDiv.appendChild(documentCaseReportButtonElement);
				
			}else{
				$('#document-case-report').removeClass("d-none");
				$('#verification-case-report').removeClass("d-none");
				$('#case-report-document').addClass("d-none")
				$('#case-report-document-button').addClass("d-none")
				$('#case-report-verification').addClass("d-none")
				
				document.getElementById('searched-verification-case-report').innerHTML='';
				document.getElementById('searched-document-case-report').innerHTML='';
				document.getElementById('searched-document-case-report-button').innerHTML=''
				
			}
			
			
			// Set Certificates Start
			
			for (i = 1; i < dataJson.length; i++) {	
				var rowCount1 = table1.rows.length;
		 		row1 = table1.insertRow(rowCount1);
		 		var jsonObj = dataJson[i];
		 		//i++;
		 		console.log(":::::::data::::::Iterate::::",jsonObj);
		 		console.log(":::::::rowCount1:::::::",rowCount1);
		 		/* $("#issuedFromDT").val(jsonObj.issuingFrom);
		 		$('#issuedFromDT').attr("name", "issuedFrom"+i);
		 		
		 		$("#qualificationDT").val(jsonObj.qualification);
		 		$('#qualificationDT').attr("name", "qualification"+i);
		 		
		 		$("#fileEntryId").val(jsonObj.educationCertificateFileEntryId);
		 		$("#fileEntryId").attr("name", "fileEntryId"+i);
		 		
		 		$("#documentInfoId").val(jsonObj.educationCertificateDocumentInfoId);
		 		$("#documentInfoId").attr("name", "documentInfoId"+i);
		 		
		 		$("#certificateDT").val(jsonObj.educationCertificateUrl);
		 		$("#certificateDT").attr("name", "certificatetbl"+i);
		 		
		 		$("#issueDateDT").val(jsonObj.issueDate);
		 		$("#issueDateDT").attr("name", "issueDate"+i);
		 		
		 		$("#rowCnt").val(i);
		 		$("#rowCnt").attr("name", "rowCnt"+i); */
		 		
		 		
		 		docCheckboxCell = row1.insertCell(0);
		 		issuedFromCell = row1.insertCell(1);
				documentTypeCell = row1.insertCell(2);
				actionCell1 = row1.insertCell(3);
				certificateCell = row1.insertCell(4);
				issueDateCell = row1.insertCell(5);
				documentInfoIdCell = row1.insertCell(6);
				institutionCell  = row1.insertCell(7);
				graduationDurationCell  = row1.insertCell(8);
				fileEntryIdCell = row1.insertCell(9);
				
				var docCheckboxElement = document.createElement("input");
				docCheckboxElement.type = "checkbox";
				docCheckboxElement.name = "docCheckbox" + i;
				docCheckboxElement.id = "docCheckbox" + i;
				docCheckboxElement.className = "custom-control-input";
				var customCheckboxDiv = document.createElement("div");
				customCheckboxDiv.className = "custom-control custom-checkbox";
				var labelElement = document.createElement("label");
				labelElement.className = "custom-control-label m-0";
				labelElement.htmlFor = docCheckboxElement.id;
				
				customCheckboxDiv.appendChild(docCheckboxElement);
				customCheckboxDiv.appendChild(labelElement);
				docCheckboxCell.appendChild(customCheckboxDiv);
				
		 		var issuedFromElement = document.createElement("input");
				issuedFromElement.type = "text";
				issuedFromElement.value = jsonObj.issuedFrom;
				issuedFromElement.readOnly = true;
				issuedFromElement.name = "issuedFrom" + i;
				issuedFromElement.id = "issuedFrom" + i;
				issuedFromElement.className = "form-control";
				issuedFromCell.appendChild(issuedFromElement);
				
			  	var documentTypeElement = document.createElement("input");
				documentTypeElement.type = "text";
				documentTypeElement.value = jsonObj.qualification;
				documentTypeElement.readOnly = true;
				documentTypeElement.name = "qualification" + i;
				documentTypeElement.id = "qualification" + i;
				documentTypeElement.className="form-control";
				documentTypeCell.appendChild(documentTypeElement);
				
				var element4 = document.createElement("button");
				element4.className = "btn mx-2";
				element4.value="edit";
				element4.type="button";
				var imageElement2 = document.createElement("img");
				imageElement2.src = '<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg';
				element4.setAttribute("data-editid", i);
				element4.setAttribute('onClick', 'viewRow(this)');
				element4.appendChild(imageElement2);
				actionCell1.appendChild(element4);
				
				var actionElement1 = document.createElement("button");
				actionElement1.className = "btn delete_btn";
				actionElement1.value = "Delete";
				actionElement1.type = "button";
				var imageElement1 = document.createElement("img");
				imageElement1.src = '<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg';
				actionElement1.setAttribute('data-toggle', 'modal');
				actionElement1.setAttribute('data-target', '#equivalency-delete');
				actionElement1.setAttribute('data-rowcount', 'addPopUpRow');
				actionElement1.setAttribute('onClick', 'setData(this)');
				actionElement1.appendChild(imageElement1);
				actionCell1.appendChild(actionElement1);
				
				
				
				
				
				var certificateElement = document.createElement("input");
				certificateElement.type = "text";
				certificateElement.value = jsonObj.educationCertificateUrl;
				certificateElement.name = "certificatetbl" + i;
				certificateElement.id = "certificate" + i;
				certificateElement.style="display:none;"
				certificateElement.className = "form-control";
				certificateCell.appendChild(certificateElement);
				certificateCell.setAttribute("class", "d-none");
				
				var issueDateElement = document.createElement("input");
				issueDateElement.type = "text";
				issueDateElement.value = jsonObj.issueDate;
				issueDateElement.name = "issueDate" + i;
				issueDateElement.id = "issueDate" + i;
				issueDateElement.style="display:none;"
				issueDateElement.className = "form-control";
				issueDateCell.appendChild(issueDateElement);
				issueDateCell.setAttribute("class", "d-none");
				
				var documentInfoIdElement = document.createElement("input");
			    documentInfoIdElement.type = "hidden";
			    documentInfoIdElement.readOnly = true;
			    documentInfoIdElement.value=jsonObj.educationCertificateDocumentInfoId;
			    documentInfoIdElement.name = "documentInfoId" + i;
			    documentInfoIdElement.id = "documentInfoId" + i;
			    documentInfoIdElement.className = "form-control";
			    documentInfoIdElement.style="display:none;"
				documentInfoIdCell.appendChild(documentInfoIdElement);
			    documentInfoIdCell.setAttribute("class", "d-none");
			    
			    var institutionElement = document.createElement("input");
			    institutionElement.type = "hidden";
			    institutionElement.value = jsonObj.institution;
			    institutionElement.readOnly = true;
			    institutionElement.name = "institution" + i;
			    institutionElement.id = "institution" + i;
			    institutionElement.className = "form-control";
			    institutionElement.style="display:none;"
			    institutionCell.appendChild(institutionElement);
				institutionCell.setAttribute("class", "d-none");
				
			    
			    
			    var graduationDurationElement = document.createElement("input");
			    graduationDurationElement.type = "hidden";
			    graduationDurationElement.value = jsonObj.graduationDuration;
			    graduationDurationElement.readOnly = true;
			    graduationDurationElement.name = "graduationDuration" + i;
			    graduationDurationElement.id = "graduationDuration" + i;
			    graduationDurationElement.className = "form-control";
			    graduationDurationElement.style="display:none;"
			    graduationDurationCell.appendChild(graduationDurationElement);
				graduationDurationCell.setAttribute("class", "d-none");

			   	var fileEntryIdElement = document.createElement("input");
			    fileEntryIdElement.type = "hidden";
			    fileEntryIdElement.readOnly = true;
			    fileEntryIdElement.value = jsonObj.educationCertificateFileEntryId;
			    fileEntryIdElement.name = "fileEntryId" + i;
			    fileEntryIdElement.id = "fileEntryId" + i;
			    fileEntryIdElement.className = "form-control";
			    fileEntryIdElement.style="display:none;"
			    fileEntryIdCell.appendChild(fileEntryIdElement);
			    fileEntryIdCell.setAttribute("class", "d-none");
			}
			addPopUpRow=dataJson.length;
			$("#<portlet:namespace />certificateToBeEvaluated").val(dataJson.length);
		},
	});
}

function viewRow(viewid) {

	var row = $(viewid).closest("tr");
	console.log("row>>>>"+JSON.stringify(row));
	
	var issuedFromDT = row.find("td:eq(1) input").val();
	var qualificationDT = row.find("td:eq(2) input").val();
	console.log("issuedFromDT>>>>"+issuedFromDT+" , qualificationDT : "+qualificationDT);
	var certificateName = row.find("td:eq(4) input").val();
	var issueDateDT = row.find("td:eq(5) input").val();
	console.log("certificateName>>>>"+certificateName+" , issueDateDT "+issueDateDT);
	
	
	
	$('#viewEquivalencyModal').modal('show');

	/*$("#<portlet:namespace/>verificationReportPaymentReceiptEdit").text(vReportPaymentReceipt);
	  $("#<portlet:namespace/>certificateFileEdit").val(certificate);  
	  
	  document.getElementById('verificationReportPaymentReceiptLabel').innerHTML = vReportPaymentReceipt;
	  document.getElementById('certificateFileLabel').innerHTML = certificate;
	  
	  */
	  $(".qualificationView").text(qualificationDT);
	  $(".certificateView").attr("href", certificateName);
	  $(".issuedFromView").text(issuedFromDT);
	  $(".issueDateView").text(issueDateDT);
	  
	
	}
	
document.getElementById('<portlet:namespace/>qualification').addEventListener('change', function () {
	var style = this.value == 'other' ? 'block' : 'none';
	document.getElementById('otherQualificationDiv').style.display = style;
});

/* document.getElementById('<portlet:namespace/>issuedFrom').addEventListener('change', function () {
	var style = this.value == 1 ? 'block' : 'none';
	document.getElementById('issuedFromOtherDiv').style.display = style;
}); */

/* Date picker */
$('#<portlet:namespace/>employeeDateOfBirth').datepicker({
	format: "dd/mm/yyyy",
	orientation: "bottom auto",
	autoclose: true,
	endDate: new Date()
}).on('change', function(){
	$('.datepicker').hide();
});
const minDate = new Date();
minDate.setFullYear(minDate.getFullYear() - 18);  // Date should be selected 18 years earlier.
$('#<portlet:namespace/>dateOfBirth').datepicker({
	format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    endDate: minDate
}).on('change', function(){
	let ds = $(this).val();
	console.log('ds???', ds);
	console.log('minDate???', minDate);
	if (processDate(ds) > minDate) {
		console.log('selected invalid date');
		$(this).val('');
	}
	$('.datepicker').hide();
});
function processDate(date){
   var parts = date.split("/");
   console.log('process Date ?? ', new Date(parts[2], parts[1] - 1, parts[0]));
   return new Date(parts[2], parts[1] - 1, parts[0]);
}
$('#<portlet:namespace/>issueDate').datepicker({
	format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    endDate: new Date()
}).on('change', function(){
	$('.datepicker').hide();
}); 

function setData(link,rcnt){
	var row = $(link).closest("tr");
		$("#equivalency-delete").data("row", row);
		$("#equivalency-delete").data("rcnt", rcnt);
}
function deleteRow() {
	var row = $("#equivalency-delete").data("row");
	  row.remove();
	  var crt_rowcnt = $("#equivalency-delete").data("rcnt");
	  crt_rowcnt--;
	  var deleteModal = $("#equivalency-delete");
		deleteModal.modal('hide');
}

function setIsDraft() {
	document.getElementById("<portlet:namespace />isDraft").value = "true";
}

function getInstitutionList(issuedFrom){
	$.ajax({
		url: '<%=getUniversityList%>',
		type : 'GET',
		data : {
			"<portlet:namespace />issuedFrom" : issuedFrom,
		},
		success : function(response) {
			var instituteDataArray = JSON.parse(response);
            var instituteData = "<option value=''><liferay-ui:message key='select'/></option>";
            
            for (var i = 0; i < instituteDataArray.length; i++) {
            	instituteData += "<option value='" + instituteDataArray[i].id + "'>" + instituteDataArray[i].name + "</option>";
            }
            $("#institution").html(instituteData); 
		},
	});
}

function setprofessionPriSpeciality(profession){
	if (profession == 'other') {
		$('.other-profession').removeClass('d-none');
	} else {
		$('.other-profession').addClass('d-none');
	}
	$.ajax({
		url: '<%=getSpecialtyList%>',
		type : 'GET',
		data : {
			<portlet:namespace />profession : profession,
		},
		success : function(response) {
			var specialtyArray = JSON.parse(response);
            var specialty = "<option value=''><liferay-ui:message key='select'/></option>";
            
            for (var i = 0; i < specialtyArray.length; i++) {
            	specialty += "<option value='" + specialtyArray[i].id + "'>" + specialtyArray[i].name + "</option>";
            }
            $("#primarySpecialty").html(specialty); 
		},
	});
}

function sendEqRequest(){
	var A = AUI();
	var fullName = A.one("#<portlet:namespace />fullName").val();
	var nationality = A.one("#<portlet:namespace />nationality").val();
	var passportNumber = A.one("#<portlet:namespace />passportNumber").val();
	var dateOfBirth = A.one("#<portlet:namespace />dateOfBirth").val();
	var email = A.one("#<portlet:namespace />email").val();
	var mobile = A.one("#<portlet:namespace />cellphoneNumber").val();
	var error = false;
	var isSubmit = false;
	if (!fullName) {
		error = true;
	}
	if (!nationality) {
		error = true;
	}

	if (!passportNumber) {
		error = true;
	}

	if (!dateOfBirth) {
		error = true;
	}
	if(!email){
		error = true;
	}
	if(!mobile){
		error = true;
	}
		
	
	var evaluateCertCheckedCount=0;
	$('#dataTable1 tr').each(function(i) {
	    var chkbox = $(this).find('input[type="checkbox"]');
	    if(chkbox.length) {
	    	if(chkbox.prop('checked')){
	    		evaluateCertCheckedCount++;
	    	}
	    }
	});
	if(evaluateCertCheckedCount>0){
		isSubmit = true; 
	}else{
		document.getElementById('errorContainer-evaluateCertificate').textContent = "<liferay-ui:message key='please-choose-a-certificate' />";
	}
	
	if (error) {
		console.log("error");
		var formValidator = Liferay.Form.get('<portlet:namespace />equivalencyRequest').formValidator;
		formValidator.validateField(A.one("#<portlet:namespace />fullName"));
		formValidator.validateField(A.one("#<portlet:namespace />nationality"));
		formValidator.validateField(A.one("#<portlet:namespace />passportNumber"));
		formValidator.validateField(A.one("#<portlet:namespace />dateOfBirth"));
		formValidator.validateField(A.one("#<portlet:namespace />email"));
		formValidator.validateField(A.one("#<portlet:namespace />cellphoneNumber"));
	} else {
		isSubmit = true;
	}
	if (isSubmit) {
		console.log('submit to true');
		document.getElementById("saveEquivalencyRequest").click();
	}
}
</script>