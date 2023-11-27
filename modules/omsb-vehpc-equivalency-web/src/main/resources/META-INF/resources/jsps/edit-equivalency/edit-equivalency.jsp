<%@ include file="../init.jsp"%>

<portlet:renderURL var="equivalencyURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.EQUIVALENCY%>" />
</portlet:renderURL>

<portlet:resourceURL id="personSearch" var="personSearch">
	<portlet:param name="cmd" value="Doc" />
</portlet:resourceURL>

<portlet:resourceURL id="personPoppulateToFarm"
	var="personPoppulateToFarmURL">
</portlet:resourceURL>

<portlet:actionURL name="equivalencyEditRequest"
	var="editEquivalencyRequestURL"></portlet:actionURL>
	
	<portlet:resourceURL id="deleteEvaluatedCertificates" var="deleteEvaluatedCertificates">
<portlet:param name="cmd" value="Cert" />
</portlet:resourceURL>

<portlet:resourceURL id="deleteOtherDocumentsRow" var="deleteOtherDocumentsRow">
<portlet:param name="cmd" value="OtherDoc" />
</portlet:resourceURL>

<c:set var="pd" value="${personalDetail}"></c:set>
<c:set var="n" value="${personNatinality}"></c:set>
<c:set var="comments" value="${eqReqStatusComments}"></c:set>
<c:set var="caseRequestFileUrl" value="${caseRequestFileUrl}" />
<c:set var="vehpcD" value="${vehpcDesion}" />
<c:set var="aD" value="${adminDesion}" />
<c:set var="aD" value="${adminDesion}" />
<c:set var="certificates" value="${certificatesToBeEval}"/>
<c:set var="otherDoc" value="${otherDocument}"/>
<c:set var="officialltr" value="${officialletters}" />

<!--- Start Main Content Section Here --->
<section class="omsb-main-wrapper" id="omsb-main-wrapper">
	
	<!-- Inner Wrapper Contents -->
	<div id="wrapper">
		<div class="container">
		<%-- 	<div class="omsb-card">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="search-for-the-employee" />
				</h4>
				<div class="omsb-list-filter">
					<div class="row">

						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="dfrn" id="employeeDfrn" name="employeeDfrn"
									type="text" class="form-control" />
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="civil-id" id="employeeCivilId"
									name="employeeCivilId" type="text" class="form-control" />
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="passport-number" id="employeePassportNumber"
									name="employeePassportNumber" type="text" class="form-control" />

							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="date-of-birth" id="employeeDateOfBirth"
									name="employeeDateOfBirth" type="text"
									class="form-control datePicker">
									<aui:validator name="required"></aui:validator>
								</aui:input>
							</div>
						</div>
					</div>
					<div class="filter-button-wrap">
						<button type="button" class="btn omsb-bc-red-button" name="submit"
						onClick="searchEmployeeButton()">
						<liferay-ui:message key="search" />
					</button>
					</div>
					
				</div>

				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="employee-tabel-edit">
						<thead>
							<tr>
								<th><liferay-ui:message key="name" /></th>
								<th><liferay-ui:message key="date-of-birth" /></th>
								<th><liferay-ui:message key="email" /></th>
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
			</div> --%>

			<aui:form class="flex-container" method="PUT"
				name="editEquivalencyReq" action="${editEquivalencyRequestURL}"
				enctype="multipart/form-data">
				<aui:input id="personId" name="personId" type="hidden" value="${personID}"
					class="form-control" />

				<div class="omsb-card">
					<div class="omsb-page-top-info">
						<div class="pagetitle">
							<liferay-ui:message key="edit-equivalency-request" />
						</div>
					</div>

					<h4 class="omsb-card-title">
						<liferay-ui:message key="request-details" />
					</h4>
					<div class="row">
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="full-name" id="fullName" name="fullName"
									type="text" value="${personalDetail.givenNameAsPassport}"
									disabled="true" required="true" class="form-control">
									<aui:validator name="required"></aui:validator>
								</aui:input>

							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:select name="nationality" id="nationality"
									label="nationality" value="${personNatinality}"
									disabled="true" required="true"
									class="custom-select form-control">
									<aui:option value=""><liferay-ui:message key="select"/></aui:option>
									<c:forEach var="country" items="${allNationalities}">
										<aui:option value="${country.getCountryId()}">${country.getName(themeDisplay.getLocale())}</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="passport-number" id="passportNumber"
									name="passportNumber" disabled="true"
									value="${passportNumber}" type="text" required="true"
									class="form-control">
									<aui:validator name="required"></aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="date-of-birth" id="dateOfBirth"
									name="dateOfBirth" value="${dateOfBirth}" type="text" placeholder="DD/MM/YYYY" 
									disabled="true" required="true" class="form-control datePicker">
									<aui:validator name="required"></aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="email" id="email" name="email" type="email"
									value="${personalDetail.email}" disabled="true" required="true"
									class="form-control">
									<aui:validator name="required"></aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:input label="mobile" id="cellphoneNumber"
									name="cellphoneNumber" disabled="true" required="true"
									type="number" value="${personalDetail.mobileNumber }"
									class="form-control">
									<aui:validator name="required"></aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="form-group">
								<aui:select name="profession" id="profession" label="profession"
									value="" disabled="true" required="true">
									<aui:option value=""><liferay-ui:message key="select"/></aui:option>
									<c:forEach var="professionValues" items="${professionList}">
										<aui:option value="${professionValues.getKey()}">
											<liferay-ui:message
												key="${professionValues.getName(themeDisplay.getLocale())}" />
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
					</div>

					<div
						class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="certificates-to-be-evaluated" />
							<button class="btn omsb-bg-red-button" type="button"
								data-toggle="modal" data-target="#markInsufficientModal"
								href="javascript:void(0)">
								<img src="../images/svg/plus_img.svg" alt="" />
								<liferay-ui:message key="add-certificate" />
							</button>
							<!-- <a data-toggle="modal" data-target="#markInsufficientModal" href="javascript:void(0)" >
									<img src="images/svg/mark_Insufficient_icon.svg">Add-Certificate</a> -->

						</h4>
						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables"
								id="existing-certificates-table">
								<thead>
									<tr>
										<th><liferay-ui:message key="dfrn" /></th>
										<th><liferay-ui:message key="document-type" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${certificatesToBeEval.caseNumber}</td>
										<td>${certificatesToBeEval.documentTypeId}</td>
										<td>
											<div class="buttons_wrap">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input"
														id="customCheck001" name="example1"> <label
														class="custom-control-label" for="customCheck001"></label>
												</div>
												<button class="btn delete_btn" title="Delete" onclick="deleteCertificate(${certificatesToBeEval.ID},${certificatesToBeEval.fileEntryId})">
													  <img src="<%= themeDisplay.getPathThemeImages() %>/svg/delete_icon.svg" /></button>
											</div>

										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<div
						class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="other-document" />
							<button class="btn omsb-bg-red-button" type="button"
								data-toggle="modal" data-target="#otherDocumentModal"
								href="javascript:void(0)">
								<img src="../images/svg/plus_img.svg" alt="" />
								<liferay-ui:message key="add-certificate" />
							</button>
							<!-- <a data-toggle="modal" data-target="#otherDocumentModal" href="javascript:void(0)" >
									<img src="images/svg/mark_Insufficient_icon.svg">Add-document</a> -->
						</h4>
						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables"
								id="other-documentss-table">
								<thead>
									<tr>
										<th><liferay-ui:message key="document-type" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${otherDocument.documentTypeId}</td>
										<td>
											<div class="buttons_wrap">

												<button class="btn delete_btn" title="Delete" onclick="deleteOtherDocuments(${otherDocument.ID},${otherDocument.fileEntryId})" >
													  <img src="<%= themeDisplay.getPathThemeImages() %>/svg/delete_icon.svg" />
												</button>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /><!-- <span
									class="counter"><span class="countered_points"><liferay-ui:message key="500"/> </span><liferay-ui:message key="500"/><liferay-ui:message key="500-remaining"/></span>--></label>
								<textarea onkeyup="countChar(this)" class="form-control" disabled="disabled"
									rows="5" id="comment"><c:forEach items="${statusResponseList}" var="statusResponse">
									${statusResponse.getRole() } : ${statusResponse.getComments()}
									</c:forEach>
									<%--  <c:out value="${statusResponseList.get(0).getRole()}" />  : <c:out value="${statusResponseList.get(0).getComments()}" />  --%>
									</textarea>
							</div>
						</div>
					</div>
				</div>

				<div class="omsb-card">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="official-request-letter" />
					</h4>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<aui:select name="docType" label="type" required="true"
									class="custom-select form-control" value="${officialletters.documentTypeId}">
									<aui:option value=""><liferay-ui:message key="select"/></aui:option>
									<c:forEach var="documentTypes" items="${documentTypeList }">
										<aui:option value="${documentTypes.getKey()}">
											<liferay-ui:message
												key="${documentTypes.getName(themeDisplay.getLocale())}" />
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
						
						<div class="omsb-card">
						<div class="omsb-card-caserport">
							<div class="leftbar">
								<div class="casereport-img">
									<img src="<%= themeDisplay.getPathThemeImages() %>/png/caseReportImg.png" alt="">
								</div>
								<h4 class="casereport-title"><liferay-ui:message key="uploded-file"/></h4>
							</div>
							<div class="righbar">
							<a href="${officiallettersLetter}" target="_blank"  class="btn view_btn" title="View" >
								
									<img src="<%= themeDisplay.getPathThemeImages() %>/svg/view_icon.svg" alt="">
									 <liferay-ui:message key="view"/>
							</a>
							</div>
						</div>
						</div>
						
						
						<div class="col-md-12">
							<%-- <div class="form-group">
								<label><liferay-ui:message key="attachment" /></label>
								<div class="custom-file mb-3">
									<aui:input type="file" class="custom-file-input" id="customFile" name="filename">
									<aui:input name="attachment" type="file" value="${officiallettersLetter}"
										class="custom-file-input">
										<aui:validator name="required"></aui:validator>
									</aui:input>
									<label class="custom-file-label" for="customFile"></label>
								</div>
							</div> --%>
							<div class="form-group">
								<div class="custom-file mb-3">
									<input type="file" class="custom-file-input" id="customFile"
										name="attachment" readonly> <label class="custom-file-label" for="customFile"></label>
								</div>
							</div>
						</div>
					</div>
				</div>

					<!--  To show Admin and VEHPC committee -->
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
							<h4 class="omsb-card-title"><liferay-ui:message key="attachments"/>  </h4>
							<div class="omsb-list-view table-responsive">
								<table class="display omsb-datatables" id="existing-certificates-table">
									<thead>
										<tr>
											<th><liferay-ui:message key="dfrn"/></th>
											<th><liferay-ui:message key="document-type"/></th>
										</tr>
									</thead>
									<tbody>
								<c:forEach var="documentInfo" items="${documentInfoList}">
									<tr>
										<td>${documentInfo.caseNumber}</td>
										<td>${documentInfo.documentTypeId}</td>
									</tr>
								</c:forEach>

							</tbody>
								</table>
							</div>
						</div>
					<!-- End >> to show Admin and VEHPC committee -->
	
	
						<!-- To show only VEHPC committee -->
					
					<%-- <div class="omsb-card">
						<h4 class="omsb-card-title"><liferay-ui:message key="case-report"/></h4>
						<div class="omsb-card-caserport">
							<div class="leftbar">
								<div class="casereport-img">
									<img src="<%= themeDisplay.getPathThemeImages() %>/png/caseReportImg.png" alt="">
								</div>
								<h4 class="casereport-title"><liferay-ui:message key="case-report-of"/> ${personalDetail.givenNameAsPassport }</h4>
							</div>
							<div class="righbar">
							<a href="${caseRequestFileUrl}" target="_blank"  class="btn view_btn" title="View" >
								
									<img src="<%= themeDisplay.getPathThemeImages() %>/svg/view_icon.svg" alt="">
									 <liferay-ui:message key="view"/>
							</a>
							</div>
						</div>
					</div> --%>
					<c:if test="${not empty caseRequestFileUrl}">
						<h4 class="omsb-card-title"><liferay-ui:message key="case-report"/></h4>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group omsb-view-file">
									<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
									<%-- <c:set var="filename" value="${info.dFFileName}" />
									<c:set var="fileEntryID" value="${info.fileEntryID}" />
									<c:set var="docsfileurl" value="${info.docsfileurl}" /> --%>
									<label>
										<span class=""> 
											<button class="btn btn-label view-download" data-toggle="modal" data-edd="${caseRequestFileUrl}" data-State="${caseRequestFileUrl}" data-target="#supporting-document"> <liferay-ui:message key="view-file" /></button>
											<a href="${caseRequestFileUrl}" class="btn btn-label view-download" download><liferay-ui:message key="download-file" /></a>
										</span>
									</label>
								</div>
							</div>
						</div>
					</c:if>
					
					<div class="omsb-card">
						<h4 class="omsb-card-title"><liferay-ui:message key="equivalency-details"/></h4>
						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables" id="equivalency-details-table">
								<thead>
									<tr>
										<th><liferay-ui:message key="certificates"/></th>
										<th><liferay-ui:message key="equivalency-level"/></th>
										<th><liferay-ui:message key="comments"/></th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td>

											<div class="certificates-dtls">
												<%-- <div class="certificates-img">
												<img src="<%= themeDisplay.getPathThemeImages() %>/png/caseReportImg.png" alt="">
												</div> --%>
												<h4 class="certificates-title">${certificateAdmin}</h4>
											</div>

										</td>
										<td>
										<div class="form-group">
											<aui:select name="equivalencyLevel" required="true" value="${adminDesion.equivalencyLevelId.getName()}"
												class="custom-select form-control">
												<aui:option value=""><liferay-ui:message key="select"/></aui:option>
												<c:forEach var="equivalencyLevels" items="${equivalencyLevelList }">
													<aui:option value="${equivalencyLevels.getKey()}">
														<liferay-ui:message
															key="${equivalencyLevels.getName(themeDisplay.getLocale())}" />
													</aui:option>
												</c:forEach>
											</aui:select>
										</div>
									</td>
										<td>${adminDesion.comments }</td>

									</tr>
								</tbody>
							</table>
						</div>

					<div class="omsb-card bottom-backbtn-wrap">
						<button class="btn omsb-bc-red-button" type="submit"
							name="editEquivalencyReq" title="Send Request ">
							<liferay-ui:message key="send-request" />
						</button>
						<a class="btn omsb-btn omsb-bg-red-button"
							href="${equivalencyURL}"><liferay-ui:message key="cancel" /></a>
					</div>

				</div>
				<!-- End >> to show only VEHPC committee -->
				
				<!-- 	TO show only admin -->
				
				
						<%-- <div class="omsb-card">
						<h4 class="omsb-card-title">Equivalency details</h4>
						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables" id="equivalency-details-table">
								<thead>
									<tr>
										<th><liferay-ui:message key="certificates"/></th>
										<th><liferay-ui:message key="commttee-equivalency-level"/></th>
										<th><liferay-ui:message key="committee-comments"/></th>
										<th><liferay-ui:message key="final-equivalency-level"/></th>
										<th><liferay-ui:message key="comments-by-admin"/></th>
									
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>

											<div class="certificates-dtls">
												<div class="certificates-img">
												<img src="<%= themeDisplay.getPathThemeImages() %>/png/caseReportImg.png" alt="">
												</div>
												<h4 class="certificates-title">${certificateAdmin}</h4>
											</div>

										</td>
										<td>${adminDesion.equivalencyLevelId.getName()} </td>
										<td>${vehpcDesion.comments }</td>
										<td>
											<div class="form-group">
											<aui:select name="equivalencyLevel" required="true" value="${adminDesion.equivalencyLevelId.getName()}" class="custom-select form-control">
												<aui:option value="">Select</aui:option>
												<c:forEach var="equivalencyLevels"
													items="${equivalencyLevelList }">
													<aui:option value="${equivalencyLevels.getKey()}">
														<liferay-ui:message
															key="${equivalencyLevels.getName(themeDisplay.getLocale())}" />
													</aui:option>
												</c:forEach>
											</aui:select>
										</div>
										</td>
										<td>${adminDesion.comments }</td>
										
									</tr>
								</tbody>
							</table>
						</div>
					</div> --%>
					
					
				<!-- End >> to show only Admin -->
			<%-- <div class="omsb-card bottom-backbtn-wrap">
					<button class="btn omsb-bc-red-button" type="submit"
						name="editEquivalencyReq" title="Send Request ">
						<liferay-ui:message key="send-request" />
					</button>
					<a class="btn omsb-btn omsb-bg-red-button"
						href="${equivalencyURL }"><liferay-ui:message key="cancel" /></a>
				</div> --%>
				
			</aui:form>
		</div>
	</div>
	
	
	<!--// Inner Wrapper Contents -->

</section>
<!---// End Main Content Section Here --->




<!--  POPUP Modal for Certificate  -->
,
<aui:input type="hidden" name="examScheduleRowcount"
	id="exam_schedule_rowcount" value="1" />
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
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<aui:form name="examForm">

								<select id="qualification" name="qualification"
									label="qualification" class="custom-select form-control">
									<option value=""><liferay-ui:message key="select"/></option>
									<c:forEach var="qualification" items="${qualificationList}">
										<option value="${qualification.getKey() }"><liferay-ui:message
												key="${qualification.getName(themeDisplay.getLocale())}" />
										</option>
									</c:forEach>
									<option value="">Other</option>
								</select>

								<aui:input label="certificate" id="certificate"
									name="certificate" type="file"></aui:input>

								<aui:input label="dfrn" id="dfrnPopup" name="dfrn" type="text"></aui:input>

								<aui:input id="verificationReportPaymentReceipt"
									label="verification-report-payment-receipt"
									name="verificationReportPaymentReceipt" type="file" />

							</aui:form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button"
					onClick="setValues()" data-dismiss="modal" title="Save"><liferay-ui:message key="save"/></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal"><liferay-ui:message key="cancel"/></button>
			</div>
		</div>
	</div>
</div>


<!--  POPUP Modal for Other Document -->

<aui:input type="hidden" name="otherDocumentRowcount"
	id="other_document_rowcount" value="1" />
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
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<aui:form name="examForm">

								<aui:select id="documentType" name="documentType" label="type">
									<aui:option value=""><liferay-ui:message key="select"/></aui:option>
									<c:forEach var="documentTypes" items="${documentTypeList }">
										<aui:option value="${documentTypes.getKey()}">
											<liferay-ui:message
												key="${documentTypes.getName(themeDisplay.getLocale())}" />
										</aui:option>
									</c:forEach>
								</aui:select>

								<aui:input label="attachment" id="attachmentFile"
									name="attachmentFile" type="file" />
							</aui:form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button"
					onClick="otherDocumentSetValues()" data-dismiss="modal"
					title="Save"><liferay-ui:message key="save"/></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal"><liferay-ui:message key="cancel"/></button>
			</div>
		</div>
	</div>
</div>

<script>

/* Ajax call to delete certificates */

  function deleteCertificate(certificateDocInfoId, fileEntryId) {
    console.log("deleteCertificate........");
    console.log("certificateDocInfoId......" + certificateDocInfoId);
    console.log("fileEntryId......" + fileEntryId);

    $.ajax({
      type: 'POST',
      url: '<%=deleteEvaluatedCertificates.toString()%>',
      data: {
        '<portlet:namespace />certificateDocInfoId': certificateDocInfoId,
        '<portlet:namespace />fileEntryId': fileEntryId
      },
      traditional: true,
      success: function(response) {
        // Handle the response if needed
      },
      error: function(xhr, status, error) {
        // Handle the error if needed
      }
    });
  }
 
</script>

<script type="text/javascript">

/* Ajax call to delete other documents */

function deleteOtherDocuments(otherDocInfoId, fileEntryId) {
	    console.log("deleteCertificate.........");
	    console.log("otherDocInfoId......" + otherDocInfoId);
	    console.log("fileEntryId......" + fileEntryId);

	    $.ajax({
	      type: 'POST',
	      url: '<%=deleteOtherDocumentsRow.toString()%>',
	      data: {
	        '<portlet:namespace />otherDocInfoId': otherDocInfoId,
	        '<portlet:namespace />fileEntryId': fileEntryId
	      },
	      traditional: true,
	      success: function(response) {
	        // Handle the response if needed
	      },
	      error: function(xhr, status, error) {
	        // Handle the error if needed
	      }
	    });
	  } 
	  
</script>


<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("personSearchTbl").dataTable();
		
	});
	
	function addCertificateRow() {
		  console.log("addCertificateRow..........");
		  document.getElementById('addCertificatePopUpId').style.display = 'block';
		  
		}
	</script>

<script>
	
	/* ----------------------Add Certificates all JS method code----------------------- */
	var addPopUpRow = 1;
	
	function addRow(){
	document.getElementById('popup').style.display='block';
	}
	
	$('#<portlet:namespace/>dateOfBirth').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true
	  }).on('change', function(){
	      $('.datepicker').hide();
	  });
	
	function setValues(){
	var A = AUI();
	var qualification = A.one("#<portlet:namespace />qualification").val();
	var certificate = document.getElementById("<portlet:namespace />certificate").files[0];
	var dfrn = A.one("#<portlet:namespace />dfrnPopup").val();
	var verificationReportPaymentReceipt = document.getElementById("<portlet:namespace />verificationReportPaymentReceipt").files[0];
	console.log("qualification "+qualification+" certificate: "+certificate+" dfrn"+dfrn);
	var table1 = document.getElementById('existing-certificates-table');
	� addPopUpRow++;
	
	� var rowCount1 = table1.rows.length;
	� var row1 = table1.insertRow(rowCount1);
	
	 
	 var dfrnCell = row1.insertCell(0);
		��� var dfrnElement = document.createElement("input");
		��� dfrnElement.type = "text";
		��� dfrnElement.value = dfrn;
		    dfrnElement.readOnly = true;
		��� dfrnElement.name = "dfrn" + addPopUpRow;
		��� dfrnElement.id = "dfrn" + addPopUpRow;
		��� dfrnElement.className="form-control";
		��� dfrnCell.appendChild(dfrnElement);
		
				var documentTypeCell = row1.insertCell(1);
			  	var documentTypeElement = document.createElement("input");
				documentTypeElement.type = "text";
				documentTypeElement.value = qualification;
				documentTypeElement.readOnly = true;
			��� documentTypeElement.name = "qualification" + addPopUpRow;
			��� documentTypeElement.id = "qualification" + addPopUpRow;
			��� documentTypeElement.className="form-control";
			��� documentTypeCell.appendChild(documentTypeElement);
		
				
			var actionCell = row1.insertCell(2);
			var actionElement = document.createElement("button");
			actionElement.className = "btn btn-navigate btn-secondary btn-minus";
			actionElement.value="Delete";
			actionElement.textContent="Delete";
			actionElement.setAttribute('onClick', 'deleteCertRow(this)');
			actionCell.append(actionElement);
			
			
	A.one("#<portlet:namespace />qualification").val('');
	A.one("#<portlet:namespace />certificate").val('');
	A.one("#<portlet:namespace />dfrnPopup").val('');
	A.one("#<portlet:namespace />verificationReportPaymentReceipt").val('');
	document.getElementById("<portlet:namespace />exam_schedule_rowcount").value = addPopUpRow;
	}
	
	�
	
	
	function cancelpopUp(){
	��� document.getElementById('popup').style.display='none';
	}
	
	function deleteCertRow(delid) {
		  console.log("Delete function  deleteCertRow........");
		  var table = document.getElementById("dataTable1");
		  var row = $(delid).closest("tr");
		  var rowIndex = row[0].rowIndex;
		  table.deleteRow(rowIndex);
		  addPopUpRow--;
	
		}
		
	/* ----------------------Other Document all JS method code----------------------- */
		
	
	function otherDocumentSetValues(){
		console.log("otherDocumentSetValues()");
	var A = AUI();
	var documentType = A.one("#<portlet:namespace />documentType").val();
	var attachmentFile = document.getElementById("<portlet:namespace />attachmentFile").files[0];
	var table1 = document.getElementById('other-documentss-table');
	� addDocumentPopUpRow++;
	
	� var rowCount1 = table1.rows.length;
	� var row1 = table1.insertRow(rowCount1);
	
	
		var documentTypeCell = row1.insertCell(0);
	  	var documentTypeElement = document.createElement("input");
		documentTypeElement.type = "text";
		documentTypeElement.value = documentType;
		documentTypeElement.readOnly = true;
	��� documentTypeElement.name = "documentType" + addDocumentPopUpRow;
	��� documentTypeElement.id = "documentType" + addDocumentPopUpRow;
	��� documentTypeElement.className="form-control";
	��� documentTypeCell.appendChild(documentTypeElement);

		console.log("documentTypeCell >>"+documentTypeCell);
	
	
	var actionCell = row1.insertCell(1);
	var actionElement = document.createElement("button");
	actionElement.className = "btn btn-navigate btn-secondary btn-minus";
	actionElement.value="Delete";
	actionElement.textContent="Delete";
	actionElement.setAttribute('onClick', 'otherDocumentDeleteRow(this)');
	actionCell.append(actionElement);
	
	A.one("#<portlet:namespace />documentType").val('');
	A.one("#<portlet:namespace />attachmentFile").val('');
	document.getElementById("<portlet:namespace />other_document_rowcount").value = addDocumentPopUpRow;
	}
	function otherDocumentCancelpopUp(){
	��� document.getElementById('otherDocumentPopup').style.display='none';
	}
	
	function otherDocumentDeleteRow(delid) {
		  console.log("Delete function  otherDocumentDeleteRow........");
		  var table = document.getElementById("otherDocumentDataTable");
		  var row = $(delid).closest("tr");
		  // remove the row from the table
		  var rowIndex = row[0].rowIndex;
		  table.deleteRow(rowIndex);
		  addDocumentPopUpRow--;
		}

/* Ajax call for person search button--------------------*/

function searchEmployeeButton(){
	var employeeDfrn = $("#<portlet:namespace />employeeDfrn").val();
	var employeeCivilId = $("#<portlet:namespace />employeeCivilId").val();
	var employeePassportNumber = $("#<portlet:namespace />employeePassportNumber").val();
	var employeeDateOfBirth = $("#<portlet:namespace />employeeDateOfBirth").val();
	$("#personSearchTbl > tbody").html("");
    $.ajax({
        url: '<%=personSearch.toString()%>',
        async : false,
        data : {
			<portlet:namespace />employeeDfrn : employeeDfrn,
			<portlet:namespace />employeeCivilId : employeeCivilId,
			<portlet:namespace />employeePassportNumber : employeePassportNumber,
			<portlet:namespace />employeeDateOfBirth : employeeDateOfBirth,

        },
        dataType : 'json',
        type : 'POST',
        cache : false,
        success : function(data) {
      		console.log("data "+data);
      		 jQuery.each(data, function(index, item) {
      			console.log("item "+item.dateofBirth);
      			var input = $("<input type='checkbox' value='"+item.personId+"' onClick='handleClick(this)'/>");
      			$("#personSearchTbl").find('tbody').append($('<tr>')
      					.append($('<td>').text(item.name))
      					.append($('<td>').text(item.dateOfBirth))
      					.append($('<td>').text(item.email))
      					.append($('<td>').append(input)));
             });
        },
    })
};

function handleClick(checkbox) {
	if(checkbox.checked){
    	var row = checkbox.closest('tr');
    	var dfrn = $(row).find("td:nth-child(0)").html();
    	console.log("dfrn::"+dfrn);
        var empName = $(row).find("td:first").html(); 
        var dateOfBirth = $(row).find("td:nth-child(2)").html();
        var personId = checkbox.value;
       	personDataPoppulate(empName,dateOfBirth,personId, dfrn);
    } else{
        console.log(checkbox.value+"False");
    }
}

function personDataPoppulate(empName,dateOfBirth,personId, dfrn){
	console.log("In person Data Poppulate>>>");
	
	 $.ajax({
	        url: '<%=personPoppulateToFarmURL.toString()%>',
			async : false,
			data : {
				<portlet:namespace />empName : empName,
				<portlet:namespace />dateOfBirth : dateOfBirth,
				<portlet:namespace />personId : personId,
				<portlet:namespace />dfrn : dfrn,
			},
			dataType : 'json',
			type : 'POST',
			cache : false,
			success : function(data) {
				$("#<portlet:namespace/>fullName").val(data.name);
				$("#<portlet:namespace/>nationality").val();
				$("#<portlet:namespace/>passportNumber").val();
				$("#<portlet:namespace/>dateOfBirth").val(data.dateOfBirth);
				$("#<portlet:namespace/>email").val(data.email);
				$("#<portlet:namespace/>cellphoneNumber")
						.val(data.mobileNumber);
				$("#<portlet:namespace/>profession").val();
			},
		})
	}
</script>