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

<!-- Add Certification Popup -->
<div class="modal fade omsb-modal" id="editEvalCertificate"
	tabindex="-1" role="dialog"
	aria-labelledby="editEvalCertificateTitle" aria-hidden="true">
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
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6">
							<aui:input name="addPopUpRow" id="addPopUpRow" type="hidden"></aui:input>
							<aui:select id="qualification" name="qualification"
								label="qualification" required="true">
								<aui:option value=""><liferay-ui:message key="select-qualification"/></aui:option>
								<c:forEach var="qualification" items="${qualificationList}">
									<aui:option value="${qualification.getKey() }">
										<liferay-ui:message
											key="${qualification.getName(themeDisplay.getLocale())}" />
									</aui:option>
								</c:forEach>
							</aui:select>
						 <p id="errorMessageQualification" style="color: red;"></p>
						</div>
						<div class="col-md-6" id="otherQualificationDiv" style="display: none;">
							<aui:input label="other-qualification" name="otherQualification" type="text" placeholder="other-qualification"/>
						</div>
						<div class="col-md-6">
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
						 <div class="col-md-6">
	  						<aui:select name="issuedFrom" id="issuedFrom" label="issued-country" required="true" 
	  						onchange="getInstitutionList(this.value);">
								<aui:option value=""><liferay-ui:message key="select-issued-from"/></aui:option>
									  <c:forEach var="country" items="${allNationalities}">
										<aui:option value="${country.getCountryId()}">${country.getName(themeDisplay.getLocale())}</aui:option>
									</c:forEach>
									<!-- <aui:option value="1"><liferay-ui:message key="other" /></aui:option>	 -->
							</aui:select>
								
						  <p id="errorMessageIssuedFrom" style="color: red;"></p>
						</div>
						<!-- <div class="col-md-6" id="issuedFromOtherDiv" style="display: none;">
							<aui:input label="issued-from-other" name="issuedFromOther" type="text" placeholder="issued-from-other"/>
						
						</div> -->
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
 						
						<div class="col-md-6">
							<aui:input label="graduate-year" cssClass="form-control datePicker" placeholder="DD/MM/YYYY" id="issueDate" name="issueDate" type="text" required="true" />
					 		 <p id="errorMessageIssueDate" style="color: red;" autocomplete="off"></p>
							<!-- <aui:input label="graduate-year" cssClass="form-control datePicker" placeholder="DD/MM/YYYY" id="issueDate" name="issueDate" type="text" required="true" />
					 		 <p id="errorMessageIssueDate" style="color: red;"></p> --><!-- Error message  -->
					 		 <%--  <label class="control-label"><liferay-ui:message key="graduate-year" /></label>
					 		 	<select name="<portlet:namespace/>issueDate" id="<portlet:namespace/>issueDate" class="form-control" >
								<option value=""><liferay-ui:message key="select"/></option>
								<% int currentYear = Calendar.getInstance().get(Calendar.YEAR); %>
								<c:forEach  begin="1970"  end="${year}" step="1" var="age">
								    <c:set var="decr" value="${(year-age)+1970}"/>
								    <option value="${decr}">${decr}</option>
								</c:forEach>
							</select> --%>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<aui:input label="duration-in-years" id="graduationDuration" name="graduationDuration" type="number" placeholder="duration-in-years" required="true"/>
						</div>
						<div class="col-md-6 d-none">
							<aui:input label="dfrn" id="dfrnPopup" name="dfrn" type="text" placeholder="dfrn"></aui:input>
						</div>
						<div class="col-md-6 d-none">
							<div class="form-group">
								<div class="custom-file">
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
		</div>
	</div>
</div>
<!-- Add Certification Popup Ends -->

<!--  Other Documents -->
	
<div class="modal fade omsb-modal" id="editOtherDocumentModal" tabindex="-1"
	role="dialog" aria-labelledby="editOtherDocumentModalTitle"
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

					<div class="row">
						<div class="col-md-12">

							<aui:select id="documentType" name="documentType" label="type" required="true" >
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

<!--  Other Documents Ends -->


<!--delete popup  -->
<div class="modal fade omsb-modal" id="equivalency-delete" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
				<button type="button" class="close" onclick="handleCloseDeleteDocumentPopup()" data-dismiss="modal" aria-label="Close">
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
					data-dismiss="modal" id="uploadcancel" onclick="handleCloseDeleteDocumentPopup()"><liferay-ui:message key="no" /></button>
			</div>
		</div>
	</div>
</div>
<!--delete popup Ends -->

<!-- Official Request Popup -->

<div class="modal fade omsb-modal" id="addOfficialLetterModal"
	tabindex="-1" role="dialog"
	aria-labelledby="addOfficialLetterModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="add-letter" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="form-group">
							<label ><liferay-ui:message key="official-request-letter"/></label>
							<div class="custom-file mb-3">
								<div>
									<input type="file" class="custom-file-input" id="officialRequestLetter"
									name="<portlet:namespace />officialRequestLetter">
								</div>
								<label class="custom-file-label" id="officialRequestLetter" for="officialRequestLetter"></label>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button" onclick="addOfficialLetter()" ><liferay-ui:message key="save" /></button>
					<aui:button type="button" cssClass="btn omsb-btn omsb-bg-red-button" data-dismiss="modal" value="cancel" />
				</div>
		</div>
	</div>
</div>
<!-- Official Request Popup ends -->
