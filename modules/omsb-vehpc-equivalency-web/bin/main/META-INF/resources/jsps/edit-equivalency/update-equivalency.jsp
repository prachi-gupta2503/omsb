<%@ include file="../init.jsp"%>
<%@page import="java.util.Calendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="yearCurrent" class="java.util.Date" />
<fmt:formatDate var="year" value="${yearCurrent}" pattern="yyyy" />
<portlet:renderURL var="equivalencyURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL id="deleteEvaluatedCertificates"
	var="deleteEvaluatedCertificates">
</portlet:resourceURL>
<portlet:resourceURL id="<%=MVCCommandNames.GET_UNIVERSITY_LIST_RESOURCE%>"
	var="getUniversityList" />
<portlet:resourceURL id="<%=MVCCommandNames.GET_SPECIALTY_LIST_RESOURCE%>"
	var="getSpecialtyList" />

<portlet:actionURL name="<%=MVCCommandNames.EQUIVALENCY_ADD_REQUEST%>"
	var="saveEquivalencyRequestURL" />

<aui:form method="POST" name="equivalencyRequest"
	action="${saveEquivalencyRequestURL}" enctype="multipart/form-data">
	<aui:input type="hidden" name="equivalencyRequestId"
		value="${equivalencyRequestId}" />
	<input type="hidden" name="documentInfoIdToDelete" value="" id="documentInfoIdToDelete">
	<input type="hidden" name="fileEntryIdToDelete" value="" id="fileEntryIdToDelete">
	<input type="hidden" name="tableIdToDeleteRow" value="" id="tableIdToDeleteRow">
	
	<div class="omsb-card">
		<h4 class="omsb-card-title">
			<liferay-ui:message key="request-details" />
		</h4>
		<aui:input id="personId" name="personId" type="hidden" value="${personalDetail.personId}"
			class="form-control" />
			<aui:input id="personalDetailId" name="personalDetailId" type="hidden" value="${personalDetail.id}"
			class="form-control" />

		<div class="row">
			<div class="col-lg-4 col-md-6">
				<aui:input label="full-name" id="fullName" name="fullName"
					placeholder="full-name" type="text"
					value="${personalDetail.givenNameAsPassport}" class="form-control">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:select name="nationality" id="nationality" label="nationality"
					value="${personalDetail.nationalityCountryId}" required="true"
					class="custom-select form-control">
					<aui:option value="">
						<liferay-ui:message key="select-nationality" />
					</aui:option>
					<c:forEach var="country" items="${allNationalities}">
						<aui:option value="${country.getCountryId()}">${country.getName(themeDisplay.getLocale())}</aui:option>
					</c:forEach>
				</aui:select>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:input label="passport-number" id="passportNumber"
					placeholder="passport-number" name="passportNumber" type="text"
					value="${personalDetail.passportNumber}" class="form-control">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:input label="date-of-birth" id="dateOfBirth" name="dateOfBirth"
					type="text" value="${personalDetail.dateOfBirth}" placeholder="DD/MM/YYYY"
					cssClass="form-control datePicker">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:input label="email" id="email" name="email" type="text"
					placeholder="email" value="${personalDetail.email}"
					class="form-control">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:input label="mobile" id="cellphoneNumber" placeholder="mobile"
					name="cellphoneNumber" type="text"
					value="${personalDetail.mobileNumber}" class="form-control">
					<aui:validator name="required" errorMessage="cell-phone-number-required"></aui:validator>
					<aui:validator name="number" />
					<aui:validator errorMessage = "enter-valid-mobile-number" name="maxLength">15</aui:validator> 
					
				</aui:input>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:select name="profession" id="profession" label="profession" onchange="setprofessionPriSpeciality(this.value)"
					value="${personalDetail.professionKey}">
					<aui:option value="">
						<liferay-ui:message key="select-profession" />
					</aui:option>
					<c:forEach var="professionValues" items="${professionList}">
						<aui:option value="${professionValues.getKey()}">
							<liferay-ui:message
								key="${professionValues.getName(themeDisplay.getLocale())}" />
						</aui:option>
					</c:forEach>
				</aui:select>
			</div>
			<c:set var="hiddenClass" value="d-none"/>			
			<c:if test="${personalDetail.professionKey eq 'other' }" >
				<c:set var="hiddenClass" value="" />
			</c:if>
			<div class="col-lg-4 col-md-6 ${hiddenClass} other-profession">
				<aui:input label="other-profession" name="otherProfession" type="text" placeholder="other-profession"
					value="${personalDetail.professionOther}" class="form-control">
				</aui:input>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group">
					<label><liferay-ui:message key="primary-specialty" /></label>
					 <select
						class="custom-select form-control"
						name="<portlet:namespace/>primarySpecialty" id="primarySpecialty"
						class="form-control">
						<option value=""><liferay-ui:message key="select" /></option>
						<c:forEach var="specialtyValues" items="${specialtyList}">
							<c:choose>
	 							 <c:when test="${specialtyValues.getListTypeEntryId() eq personalDetail.primarySpeciality}">
	 							 	<option value="${specialtyValues.getListTypeEntryId()}" selected>
										<liferay-ui:message
											key="${specialtyValues.getName(themeDisplay.getLocale())}" />
									</option>
	 							 </c:when>
	 							 <c:otherwise>
	 							 	<option value="${specialtyValues.getListTypeEntryId()}">
										<liferay-ui:message
											key="${specialtyValues.getName(themeDisplay.getLocale())}" />
									</option>
	 							 </c:otherwise>
	 						</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<aui:input label="dfrn" id="dfrn" name="dfrn" type="text"
					placeholder="dfrn"></aui:input>
			</div>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${not empty caseReportDocument}">
					<div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="verification-report-payment-receipt" /></label>
							<input type="text" name="<portlet:namespace/>verificationReportPaymentReceipt"
								 id="<portlet:namespace/>verificationReportPaymentReceipt" 
								 class="form-control success-field" 
								 value="${caseReportDocument.documentType}" readOnly = "true" />
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="document" /></label>
							<input type="text" name="<portlet:namespace/>verificationReportPaymentReceipt" 
							id="<portlet:namespace/>verificationReportPaymentReceipt" class="form-control success-field" 
							value="${caseReportDocument.dFFileName}" readOnly = "true" />
						</div>
					</div>
					<div class="col-lg-2 col-md-6">
						<div class="form-group mt-2 ml-3">
						<label></label> <!-- Added Label to add alignment -->
							<a target="_blank" class="download-link" href="${caseReportDocument.documentUrl}">
								<liferay-ui:message key="view" />
							</a>
						</div>
					</div>
				</c:when>
				<c:when test="${not empty paymentDocument}">
					<div class="col-lg-6 col-md-6">
						<aui:select name="verificationReportPaymentReceipt"
							id="verificationReportPaymentReceipt"
							label="verification-report-payment-receipt" value="${paymentDocument.documentType}">
								<aui:option value="">
									<liferay-ui:message key="select" />
								</aui:option>
								<aui:option value="Verification Report">
									<liferay-ui:message key="verification-report" />
								</aui:option>
								<aui:option value="Payment Receipt">
									<liferay-ui:message key="payment-receipt" />
								</aui:option>
						</aui:select>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="document" /></label>
							<div class="custom-file mb-3">
								<div>
									<input type="file" value="${paymentDocument.fileName}" cssClass="custom-file-input"
										id="paymentReceipt" name="<portlet:namespace/>paymentReceipt"/>
								</div>
								<label class="custom-file-label" id="popup_sd_file_label"
									for="paymentReceipt"></label>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-lg-6 col-md-6">
						<aui:select name="verificationReportPaymentReceipt"
						id="verificationReportPaymentReceipt"
						label="verification-report-payment-receipt">
							<aui:option value="">
								<liferay-ui:message key="select" />
							</aui:option>
							<aui:option value="Verification Report">
								<liferay-ui:message key="verification-report" />
							</aui:option>
							<aui:option value="Payment Receipt">
								<liferay-ui:message key="payment-receipt" />
							</aui:option>
						</aui:select>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label><liferay-ui:message key="document" /></label>
							<div class="custom-file mb-3">
								<div>
									<input type="file" cssClass="custom-file-input"
										id="paymentReceipt" name="<portlet:namespace/>paymentReceipt"/>
								</div>
								<label class="custom-file-label" id="popup_sd_file_label"
									for="paymentReceipt"></label>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<div
			class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="documents-to-be-evaluated" />
				<button class="btn omsb-bg-red-button" data-toggle="modal"
					data-target="#editEvalCertificate" href="javascript:void(0)"
					type="button">
					<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg"
						alt="" />
					<liferay-ui:message key="add-certificate" />
				</button>
				<aui:input type="hidden" name="certificateToBeEvaluatedCount"
					value="4" />

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
						<c:forEach var="evaluated" items="${evaluatedDocumentList}"
							varStatus="counter">
							<c:set var="count" value="${counter.index + 1}" scope="page" />
							<tr id="${evaluated.id}">
								<td>
									<div class="custom-control custom-checkbox">
										<input type="checkbox" name="docCheckbox${count}"
											checked="checked" id="docCheckbox${count}"
											class="custom-control-input"> <label
											class="custom-control-label m-0" for="docCheckbox${count}"></label>
									</div>
								</td>
								<td><input type="text" class="form-control"
									name="issuedFromText${count}"
									value="${evaluated.issuingAuthorityCountryName}" readonly="readonly"></td>
								<td><input type="text" class="form-control"
									name="qualificationText${count}"
									value="${evaluated.documentType}" readonly="readonly"></td>
								<td class="d-none"><input type="text" class="form-control"
									name="qualification${count}"
									value="${evaluated.documentTypeId}" readonly="readonly"></td>
								<td><a target="_blank" class="download-link"
									href="${evaluated.documentUrl}"><liferay-ui:message
											key="view" /></a> <a class="btn delete_btn" type="button"
									title="Delete"
									data-toggle="modal"
									data-target="#equivalency-delete"
									onclick="processDeleteDocument(${evaluated.id},${evaluated.fileEntryID}, 'dataTable1')">
										<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
								</a></td>
								<td class="d-none"><input type="hidden"
									value="${evaluated.id }" readonly="readonly"
									name="documentInfoId${count}" id="documentInfoId${count}"
									class="form-control" style="display: none;"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<p id="errorContainer-evaluateCertificate" class="error-container"></p>
		</div>

		<div
			class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="other-documents" />
				<button class="btn omsb-bg-red-button"
					onclick="otherDocumentAddRow()" data-toggle="modal"
					data-target="#editOtherDocumentModal" href="javascript:void(0)"
					type="button">
					<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg"
						alt="" />
					<liferay-ui:message key="add-certificate" />
				</button>
				<aui:input type="hidden" name="otherDocumentCount"
					id="other_document_rowcount" value="1" />
			</h4>
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables" id="otherDocumentDataTable">
					<thead>
						<tr>
							<th><liferay-ui:message key="document-type" /></th>
							<th><liferay-ui:message key="action" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="otherDocs" items="${otherDocumentList}">
							<tr id="${otherDocs.id}">
								<td><input type="text" readonly class="form-control"  value="${otherDocs.documentType}"></td>
								<td><a target="_blank" class="download-link"
									href="${otherDocs.documentUrl}"><liferay-ui:message
											key="view" /></a> <a class="btn delete_btn" type="button"
									title="Delete"
									data-toggle="modal"
									data-target="#equivalency-delete"
									onclick="processDeleteDocument(${otherDocs.id},${otherDocs.fileEntryID}, 'otherDocumentDataTable')">
										<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="official-request-letter" />
				<c:if test="${empty officialReqeustDocument}">
					<button class="btn omsb-bg-red-button"
						onclick="openFileSelector()"
						type="button"
						id="officialReqeustDocumentAddButton">
						<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg"
							alt="" />
						<liferay-ui:message key="add-certificate" />
					</button>
				</c:if>
			</h4>
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables"
					id="official-request-certificates-table">
					<thead>
						<tr>
							<th><liferay-ui:message key="document-type" /></th>
							<th><liferay-ui:message key="view" /></th>
						</tr>
					</thead>
					<tbody>
						<div class="d-none">
							<input type="file" class="custom-file-input"
								id="officialRequestLetter"
								name="<portlet:namespace />officialRequestLetter">
						</div>
						<c:if test="${not empty officialReqeustDocument}">
							<tr id="${officialReqeustDocument.id}">
								<td><input type="text" readonly class="form-control"  value="<liferay-ui:message key='official-request-letter' />"></td>
								<td><a target="_blank" class="download-link"
									href="${officialReqeustDocument.documentUrl}"><liferay-ui:message
											key="view" /></a> <a class="btn delete_btn" type="button"
									title="Delete"
									data-toggle="modal"
									data-target="#equivalency-delete"
									onclick="processDeleteDocument(${officialReqeustDocument.id},${officialReqeustDocument.fileEntryID},'official-request-certificates-table')">
										<img
										src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
								</a></td>
							</tr>
						</c:if>
							<tr class="d-none" id="newOfficialReqeustDocument">
								<td><liferay-ui:message key="official-request-letter" /></td>
								<td>
									<a target="_blank" class="download-link"
									id="newOfficialReqeustDocumentView"
										href="#"><liferay-ui:message
										key="view" />
									</a> 
									<a class="btn delete_btn" type="button"
										title="Delete"
										onclick="deleteNewOfficialReqeustDocument()"
									>
										<img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
									</a>
								</td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div
			class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="payment-related-documents" />
			</h4>
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables"
					id="verification-request-certificates-table">
					<thead>
						<tr>
							<th><liferay-ui:message key="document-type" /></th>
							<th><liferay-ui:message key="view" /></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty caseReportDocumentList}">
								<%-- <c:forEach var="caseReportDocs" items="${caseReportDocumentList}"> --%>
									<tr id="${caseReportDocumentList.get(0).id}">
										<td><input type="text" readonly class="form-control"  value="${caseReportDocumentList.get(0).documentType }"></td>
										<td><a target="_blank" class="download-link"
											href="${caseReportDocumentList.get(0).documentUrl}"><liferay-ui:message
													key="view" /></a>		
											<%-- <a class="btn delete_btn" type="button"
												title="Delete"
												data-toggle="modal"
												data-target="#equivalency-delete"
												onclick="processDeleteDocument(${paymentDocs.id},${paymentDocs.fileEntryID},'verification-request-certificates-table')">
													<img
													src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
											</a> --%>
										</td>
									</tr>
								<%-- </c:forEach> --%>
							</c:when>
							<c:otherwise>
								<c:forEach var="paymentDocs" items="${paymentDocumentList}">
									<tr id="${paymentDocs.id}">
										<td><input type="text" readonly class="form-control"  value="${paymentDocs.documentType }"></td>
										<td><a target="_blank" class="download-link"
											href="${paymentDocs.documentUrl}"><liferay-ui:message
													key="view" /></a>		
											<a class="btn delete_btn" type="button"
												title="Delete"
												data-toggle="modal"
												data-target="#equivalency-delete"
												onclick="processDeleteDocument(${paymentDocs.id},${paymentDocs.fileEntryID},'verification-request-certificates-table')">
													<img
													src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" />
											</a>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${ not empty certificateURL}">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="equivalency-certificate" />
			</h4>
			<div class="col-md-12">
				<div class="form-group omsb-view-file">
					<a href="${certificateURL}" class="btn btn-label view-download"
						target="_blank"> ${certificateName}</a>
				</div>
			</div>
		</c:when>
	</c:choose>

	<div class="omsb-card">
		<div class="row">
			<div class="col-md-12">
				<aui:input type="hidden" name="otherDocumentCount"
					id="other_document_rowcount" value="1" />
				<aui:input type="hidden" name="certificateToBeEvaluatedCount"
					id="certificateToBeEvaluated" value="1" />
				<aui:input type="hidden" name="isDraft" id="isDraft" value="false" />
				<div class="omsb-card bottom-backbtn-wrap">
					<button class="btn omsb-bc-red-button" name="equivalencySendRequest"
						value="<liferay-ui:message key="send-request"/>" onClick="sendEqRequest()" type="button" 
						title="<liferay-ui:message key="send-request" />">
						<liferay-ui:message key="send-request" />
					</button>
					<button class="btn omsb-bc-red-button" name="equivalencySADRequest"
						value="<liferay-ui:message key="save-as-draft" />"
						onClick="setIsDraft()" type="submit"
						title="<liferay-ui:message key="save-as-draft" />">
						<liferay-ui:message key="save-as-draft" />
					</button>
					<a class="btn omsb-btn btn-back" value="Cancel" name="cancel"
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

<%@include file="../certificate-popup-file.jsp"%>

<script>
$(document).on('change','#<portlet:namespace />documentType',function(){
	var selectedDocType = $("#<portlet:namespace />documentType option:selected").val();
	var otherDoctypeWrapper = $("#otherDoctypeWrapper");
	if(selectedDocType == "others"){
		otherDoctypeWrapper.removeClass("d-none");
	}else{
		otherDoctypeWrapper.addClass("d-none");
	}
});


/* ----------------------Add Certificates all JS method code----------------------- */



function setValues(){
	var dataTable1 = document.getElementById('dataTable1').querySelector('tbody');
	var addPopUpRow = dataTable1.rows.length;
	
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
	 
	console.log("addPopUpRowVal::::", addPopUpRowVal + " qualification ?? "+ qualification+" , certificate : "+certificate+" , dfrn "+dfrn+" , issuedFrom : "+issuedFrom+" ,issueDate ;"+issueDate);
	var table1 = document.getElementById('dataTable1').querySelector('tbody');
	

	var rowCount1 = table1.rows.length;
	var row1 = issuedFromCell = documentTypeCell = actionCell1 = issuedFromOtherCell = issueDateCell = certificateCell = vReportPaymentReceiptCell = cell7 ="";
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
	A.one("#<portlet:namespace />dfrnPopup").val('');
	console.log('rowCount1 above ?? ', rowCount1);
	$("#<portlet:namespace />certificateToBeEvaluatedCount").val(rowCount1 + 1);
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
	
	$('#editEvalCertificate').modal('show');
	
	  $("#<portlet:namespace/>qualification").val(qualification);
	  $("#<portlet:namespace/>dfrnPopup").val(dfrn);
	  $("#<portlet:namespace/>issuedFrom").val(issuedFrom);
	  $("#<portlet:namespace/>issueDate").val(issueDate);
	  $("#<portlet:namespace/>addPopUpRow").val(addPopUpRow);
	  //$("#<portlet:namespace/>verificationReportPaymentReceipt")
	  $("#institution").val(institution);
	  $("#<portlet:namespace/>igraduationDuration").val(graduationDuration);
	  
	  
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
		
	if (error) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addCertificateForm').formValidator;
		formValidator.validateField(A.one("#<portlet:namespace />qualification"));
		formValidator.validateField(A.one("#<portlet:namespace />certificateFile"));
		formValidator.validateField(A.one("#<portlet:namespace />issuedFrom"));
		formValidator.validateField(A.one("#<portlet:namespace />issueDate"));			 
	}else{
		$('#editEvalCertificate').modal('hide');
		setValues();
	}
}

function deleteCertRow(delid) {
	var result = confirm('<liferay-ui:message key="want-to-delete-the-entry" />');
	if (result) {
		var table = document.getElementById("dataTable1");
		var row = $(delid).closest("tr");
		var rowIndex = row[0].rowIndex;
		table.deleteRow(rowIndex);
	
		var qualificationInput = row.find("input[name^='qualification']");
		var certificateInput = row.find("input[name^='certificate']");
		var dfrnInput = row.find("input[name^='dfrnPopup']");
		var otherQualificationInput = row.find("input[name^='otherQualification']");
		var issuedFromInput = row.find("input[name^='issuedFrom']");
		var issuedFromOtherInput = row.find("input[name^='issuedFromOther']");
		var issueDateInput = row.find("input[name^='issueDate']");
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
	}
}	

/* ----------------------Other Document all JS method code----------------------- */
var addDocumentPopUpRow = 1;
function otherDocumentAddRow(){
	document.getElementById('otherDocumentModal').style.display = 'block';
	document.getElementById("<portlet:namespace />addOtherDocumentForm").reset();
}
		
function otherDocumentSetValues(){
	
	var A = AUI();
	var documentType = A.one("#<portlet:namespace />documentType").val();
	var documentTypeName =$("#<portlet:namespace />documentType option:selected").text().trim();
	
	var attachmentFile = document.getElementById("<portlet:namespace />attachmentFile").files[0];
	var table1 = document.getElementById('otherDocumentDataTable').querySelector('tbody');
	addDocumentPopUpRow++;
	
	var rowCount1 = table1.rows.length;
	var row1 = table1.insertRow(rowCount1);
	
 	var documentTypeCell = row1.insertCell(0);
	var documentTypeElement = document.createElement("input");
	documentTypeElement.type = "hidden";
	documentTypeElement.value = documentType;
	documentTypeElement.readOnly = true;
	documentTypeElement.name = "documentType" + addDocumentPopUpRow;
	documentTypeElement.id = "documentType" + addDocumentPopUpRow;
	documentTypeElement.className="form-control";
	documentTypeCell.appendChild(documentTypeElement);
	
	var documentTypeNameElement = document.createElement("input");
	documentTypeNameElement.type = "text";
	/* documentTypeNameElement.value = documentTypeName; */
	documentTypeNameElement.setAttribute('value', documentTypeName);
	documentTypeNameElement.readOnly = true;
	documentTypeNameElement.name = "documentTypeName" + addDocumentPopUpRow;
	documentTypeNameElement.id = "documentTypeName" + addDocumentPopUpRow;
	documentTypeNameElement.className="form-control";
	documentTypeCell.appendChild(documentTypeNameElement);
	 
	var element2 = document.createElement("input");
	element2.type = "file";
	element2.name = "attachmentFile" + addDocumentPopUpRow;
	element2.id = "attachmentFile" + addDocumentPopUpRow;
	element2.style="display:none;"
	var container = new DataTransfer();
	container.items.add(attachmentFile);
	element2.className="form-control";
	documentTypeCell.appendChild(element2);
	element2.files = container.files; 
	console.log("documentTypeCell >>"+documentTypeCell);
	 
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

	A.one("#<portlet:namespace />documentType").val('');
	A.one("#<portlet:namespace />attachmentFile").val('');
	document.getElementById("attachmentFileLabel").innerHTML = '';
	document.getElementById("<portlet:namespace />other_document_rowcount").value = addDocumentPopUpRow;
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
		$('#editOtherDocumentModal').modal('hide');
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
		addDocumentPopUpRow--;
	
		var documentTypeInput = row.find("input[name^='documentType']");
		var attachmentFileInput = row.find("input[name^='attachmentFile']");
		if (documentTypeInput.length > 0) {
			documentTypeInput.val('');
		}
		if (attachmentFileInput.length > 0) {
			attachmentFileInput.val('');
		}
		document.getElementById("<portlet:namespace />other_document_rowcount").value = addDocumentPopUpRow;
	}
}



function viewRow(viewid) {

	var row = $(viewid).closest("tr");
	console.log("row>>>>"+JSON.stringify(row));
	
	var issuedFromDT = row.find("td:eq(0) input").val();
	var qualificationDT = row.find("td:eq(1) input").val();
	console.log("issuedFromDT>>>>"+issuedFromDT+" , qualificationDT : "+qualificationDT);
	var certificateName = row.find("td:eq(3) input").val();
	var issueDateDT = row.find("td:eq(4) input").val();
	console.log("certificateName>>>>"+certificateName+" , issueDateDT "+issueDateDT);
	
	
	
	$('#viewEquivalencyModal').modal('show');
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

function setData(link,rcnt){
	var row = $(link).closest("tr");
		$("#equivalency-delete").data("row", row);
		$("#equivalency-delete").data("rcnt", rcnt);
}

function deleteRow() {
	var documentInfoIdToDelete = $("#documentInfoIdToDelete").val();
	var fileEntryIdToDelete = $("#fileEntryIdToDelete").val();
	var tableIdToDeleteRow = $('#tableIdToDeleteRow').val();
	
	if(documentInfoIdToDelete != '' && documentInfoIdToDelete != '' && tableIdToDeleteRow != ''){
		confirmDeleteDocument(documentInfoIdToDelete, fileEntryIdToDelete,tableIdToDeleteRow);
		handleCloseDeleteDocumentPopup();
	} else{
		var row = $("#equivalency-delete").data("row");
		row.remove();
		var crt_rowcnt = $("#equivalency-delete").data("rcnt");
		crt_rowcnt--;
		 
	}
	var deleteModal = $("#equivalency-delete");
	deleteModal.modal('hide');
	
}

function setIsDraft() {
	document.getElementById("<portlet:namespace />isDraft").value = "true";
}

/* Ajax call to delete certificates */

function confirmDeleteDocument(certificateDocInfoId, fileEntryId, tableId) {
  $.ajax({
    type: 'POST',
    url: '<%=deleteEvaluatedCertificates.toString()%>',
    data: {
      '<portlet:namespace />certificateDocInfoId': certificateDocInfoId,
      '<portlet:namespace />fileEntryId': fileEntryId
    },
    traditional: true,
    success: function(response) {
  	// Delete row from the datatable
   	$("#" + tableId + " tr#" + certificateDocInfoId).remove();
    },
    error: function(xhr, status, error) {
      // Handle the error if needed
    }
  });
}
  
function openFileSelector() {
  $("#officialRequestLetter").click();
}
 
$(document).on("change","#officialRequestLetter",function(){
	$("#newOfficialReqeustDocument").removeClass("d-none");
	$("#officialReqeustDocumentAddButton").addClass("d-none");
});

function deleteNewOfficialReqeustDocument(){
	$("#officialRequestLetter").val('');
	$("#newOfficialReqeustDocument").addClass("d-none");
	$("#officialReqeustDocumentAddButton").removeClass("d-none");
}

function processDeleteDocument(certificateDocInfoId, fileEntryId,tableId) {
	$("#documentInfoIdToDelete").val(certificateDocInfoId);
	$("#fileEntryIdToDelete").val(fileEntryId);
	$("#tableIdToDeleteRow").val(tableId);
}

function handleCloseDeleteDocumentPopup() {
	$("#documentInfoIdToDelete").val('');
	$("#fileEntryIdToDelete").val('');
	$("#tableIdToDeleteRow").val('');
}
$('#<portlet:namespace/>issueDate').datepicker({
	format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    endDate: new Date()
}).on('change', function(){
	$('.datepicker').hide();
}); 				

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
		document.getElementById("saveEquivalencyRequest").click();
	}else{
		document.getElementById('errorContainer-evaluateCertificate').textContent = "<liferay-ui:message key='please-choose-a-certificate' />";
	}
}

</script>