<%@ include file="../init.jsp"%>
<%@page import="java.util.Calendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="yearCurrent" class="java.util.Date" /> 
<fmt:formatDate var="year" value="${yearCurrent}" pattern="yyyy" /> 
<portlet:actionURL name="<%=MVCCommandNames.WORKFLOW_UPDATE%>"
	var="quivalencyWorkflowURL" />
	<portlet:renderURL var="equivalencyURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommandNames.GET_UNIVERSITY_LIST_RESOURCE%>"
	var="getUniversityList" />
<form action="${quivalencyWorkflowURL}"  method="post" name="assignEqWf_fm" enctype="multipart/form-data">
	<aui:input type="hidden" name="assignWfTransitionName" id="assignWfTransitionName" value="resubmit" />
	<aui:input type="hidden" name="assignEqId"	value="${equivalencyRequestId}" />
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<liferay-ui:message key="view-equivalency-request" />
				</div>
			</div>
			
		</div>
		<div class="omsb-card">
			<div class="omsb-card">
				<c:if test="${isVEHPCAdmin || isVEHPCCommittee}">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="focal-point" />
					</h4>
					<div class="row">
						<div class="col-lg-4 col-md-3 col-sm-12 label-box">
							<div class="label-name"><liferay-ui:message
									key="full-name" /></div> <div class="label-content">${focalPoint.name}</div>
						</div>

						<div class="col-lg-4 col-md-3 col-sm-12 label-box">
							<div class="label-name"><liferay-ui:message key="email" /></div>
							<div class="label-content">${focalPoint.email}</div>
						</div>

						<div class="col-lg-4 col-md-3 col-sm-12 label-box">
							<div class="label-name"><liferay-ui:message
									key="mobile" /></div> <div class="label-content">${focalPoint.mobileNumber}</div>
						</div>

						<%-- <div class="col-lg-3 col-md-3 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message
									key="institution" /></label> <label class="label-content">${focalPoint.institutionName}</label>
						</div> --%>
					</div>
	
						<%-- <div class="col-lg-3 col-md-3 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message
									key="institution" /></label> <label class="label-content">${focalPoint.institutionName}</label>
						</div> --%>
					</div>
				</c:if>

				<h4 class="omsb-card-title">
					<liferay-ui:message key="applicant-details" />
				</h4>
							<div class="row">
				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="full-name" /></div> <div class="label-content">${personalDetail.givenNameAsPassport}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="nationality" /></div> <div class="label-content">${personNatinality}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="passport-number" /></div> <div class="label-content">${passportNumber}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="date-of-birth" /></div> <div class="label-content">${dateOfBirth}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message key="email" /></div>
					<div class="label-content">${personalDetail.email}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="mobile" /></div> <div class="label-content">${personalDetail.mobileNumber}</div>
				</div>

				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="profession" /></div> <div class="label-content">${personalDetail.profession}</div>
				</div>
				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="primary-specialty" /></div> <div class="label-content">${primarySpecialty}</div>
				</div>
				
				
				<div class="col-lg-4 col-md-3 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message
							key="equivalency-request-id" /></div> <div class="label-content">EQ-${equivalencyRequest.getEquivalencyRequestId()}</div>
				</div>
			</div>
				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="documents-to-be-evaluated" />
						<c:forEach items="${equivalencyRequest.getTransitions()}"
									var="transition">
							<c:if test="${transition eq 'resubmit'}">		
								<button class="btn omsb-bg-red-button" data-toggle="modal" 
									data-target="#editEvalCertificate" href="javascript:void(0)"
									type="button">
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="" />
									<liferay-ui:message key="add-certificate" />
								</button>
								<aui:input type="hidden" name="certificateToBeEvaluatedCount"
									 value="4" />
							</c:if>
						</c:forEach>		 
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
								<c:forEach var="evaluated" items="${evaluatedDocumentList}" varStatus="counter">
									<c:set var="count" value="${counter.index + 1}" scope="page"/>
									    <tr>
									    	<td>
										    	<div class="custom-control custom-checkbox">
										    		<input type="checkbox" name ="docCheckbox${count}" checked="checked" id="docCheckbox${count}" class="custom-control-input">
										    		<label class="custom-control-label m-0" for="docCheckbox${count}"></label>
										    	</div>
									    	</td>
											<td><input type="text" class="form-control" name="issuedFromText${count}" value="${evaluated.issuingAuthorityCountryName}" readonly="readonly"></td>
											<td><input type="text" class="form-control" name="qualificationText${count}" value="${evaluated.documentType}" readonly="readonly"></td>
											<td class="d-none"><input type="text" class="form-control" name="qualification${count}" value="${evaluated.documentTypeId}" readonly="readonly"></td>
											<td><a target="_blank" class="download-link"
												href="${evaluated.documentUrl}"><liferay-ui:message key="view" /></a></td>
											<td class="d-none">
												<input type="hidden" value="${evaluated.id }" readonly="readonly" name="documentInfoId${count}" id="documentInfoId${count}" class="form-control" style="display: none;">	
											</td>
										</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="other-documents" />
						<c:forEach items="${equivalencyRequest.getTransitions()}"
									var="transition">
							<c:if test="${transition eq 'resubmit'}">
								 <button class="btn omsb-bg-red-button"
									onclick="otherDocumentAddRow()" data-toggle="modal"
									data-target="#editOtherDocumentModal" href="javascript:void(0)"
									type="button">
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="" />
									<liferay-ui:message key="add-certificate" />
								</button> 
								<aui:input type="hidden" name="otherDocumentCount" 	id="other_document_rowcount" value="1" />
							</c:if>
						</c:forEach>		
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="otherDocumentDataTable">
							<thead>
								<tr>
									<th><liferay-ui:message key="document-type" /></th>
									<%-- <th><liferay-ui:message key="qualification" /></th> --%>
									<th><liferay-ui:message key="view" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="otherDocs" items="${otherDocumentList}">
									<c:choose>
	  									<c:when test="${otherDocs.documentType eq 'Case Report'}">
	  									</c:when>
									  <c:otherwise>
									    <tr>
											<td>${otherDocs.documentType}</td>
											<%-- <td>${otherDocs.documentType}</td> --%>
											<td><a target="_blank" class="download-link"
												href="${otherDocs.documentUrl}"><liferay-ui:message key="view" /></a></td>
										</tr>
									  </c:otherwise>
									</c:choose>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="official-request-letter" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="official-request-certificates-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="document-type" /></th>
									<th><liferay-ui:message key="view" /></th>
									<th class="d-none"><liferay-ui:message key="infoId" /></th>
								</tr>
							</thead>
							<tbody>
							    <tr>
									<td><liferay-ui:message key="official-request-letter" /></td>
									<td><a target="_blank" class="download-link"
										href="${officialReqeustDocument.documentUrl}"><liferay-ui:message key="view" /></a></td>
									<td class="d-none">
										<input type="text" class="form-control" name="officialInfoId" value="${officialInfoId}" readonly="readonly">
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
						<table class="display omsb-datatables" id="official-request-certificates-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="document-type" /></th>
									<th><liferay-ui:message key="view" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="paymentDocs" items="${paymentDocumentList}">
								    <tr>
										<td>${paymentDocs.documentType }</td>
										<td><a target="_blank" class="download-link"
											href="${paymentDocs.documentUrl}"><liferay-ui:message key="view" /></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<%@include file = "../certificate-popup-file.jsp" %>
			</div>
		
			<c:if test="${equivelencyDecisionByEqIdResItemPojoList.size() gt 0 && !employerRole}">
				<div class="omsb-card">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="equivalency-details" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="equivalency-details-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="certificates"/></th>
									<th><liferay-ui:message key="committee-equivalency-level" /></th>
									<th><liferay-ui:message key="committee-comments" /></th>
									<c:if test="${isAdminFromDecision}">
										<th><liferay-ui:message key="final-equivalency-level" /></th>
										<th><liferay-ui:message key="comments-by-admin" /></th>
									</c:if>

								</tr>
							</thead>
							<tbody>
							
		
							<c:if test="${commiteeDecisions.size() gt 0}" >
								<c:forEach items="${commiteeDecisions}" var="commiteeDecision">
									<tr>
										<td><div class="form-group"><label class="label-content">${commiteeDecision.value.qualification}</label></div></td>
										<td><div class="form-group"><label class="label-content">${commiteeDecision.value.equivalencyLevelId.key}</label></div></td>
										<td><label class="label-content">${commiteeDecision.value.comments}</label></td>
									
										<c:if test="${isAdminFromDecision}">
											<c:if test="${adminDecisions.size() gt 0}">
												<td><div class="form-group"><label class="label-content">${adminDecisions.get(commiteeDecision.key).equivalencyLevelId.key}</label></div></td>
												<td><label class="label-content">${adminDecisions.get(commiteeDecision.key).comments}</label></td>
											</c:if>
										</c:if>
									</tr>
								</c:forEach>
							</c:if> 
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
			<!-- To show only VEHPC Committee -->

			<c:if test="${not empty caseRequestFileUrl && !employerRole}">
				<h4 class="casereport-title omsb-card-title"> <liferay-ui:message key="case-report-of" /> ${personalDetail.givenNameAsPassport} </h4>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group omsb-view-file">
							<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
							<label> <span class=""> ${caseRequestFileName} 
								<a href="${caseRequestFileUrl}" class="btn btn-label view-download" target="_blank"><liferay-ui:message key="view-file" /></a> 
								<a href="${caseRequestFileUrl}" class="btn btn-label view-download" download><liferay-ui:message key="download-file" /></a>
							</span>
							</label>
						</div>
					</div>
				</div>
			</c:if>

			<!-- End >>  To show only VEHPC Committee -->


			<portlet:renderURL var="editEquivalencyURL">
				<portlet:param name="mvcRenderCommandName"
					value="<%=MVCCommandNames.EQUIVALENCY_EDIT%>" />
				<portlet:param name="equivalencyRequestId"
					value="${equivalencyRequest.getEquivalencyRequestId()}" />
				<portlet:param name="transitionNames"
					value="${equivalencyRequest.getTransitions()}" />
			</portlet:renderURL>
			<portlet:renderURL var="equivalencyEquateURL">
				<portlet:param name="mvcRenderCommandName"
					value="<%=MVCCommandNames.EQUIVALENCY_EDIT_LEVEL%>" />
				<portlet:param name="equivalencyRequestId"
					value="${equivalencyRequest.getEquivalencyRequestId()}" />
				<portlet:param name="transitionNames"
					value="${equivalencyRequest.getTransitions()}" />
			</portlet:renderURL>


			
			<c:choose>
				<c:when test="${ not empty certificateURL}" >
				<h4 class="omsb-card-title">
					<liferay-ui:message key="equivalency-certificate" />
				</h4>
					<div class="col-md-12">
						<div class="form-group omsb-view-file">
							<a href="${certificateURL}" class="btn btn-label view-download" target="_blank">
								${certificateName}</a>
						</div>
					</div>
				</c:when>
			</c:choose>	
			
			
			<!--  this block is for showing insufficient comments to employer -->
			<c:forEach items="${equivalencyRequest.getTransitions()}"
									var="transition">
				<c:if test="${transition eq 'resubmit' && employerRole}">	
					<div class="omsb-comment-box">
						<div class="omsb-comment-box-header">
							<h3 class="comment-title">
								<span class="comment-author-name"><liferay-ui:message key="comments" /> </span>${insufficientUser}</h3>
							<span class="posted-date">${insufficientDate}</span>
						</div>
						<div class="omsb-comment-body">
							<div class="row">
								<div class="col-md-12">
									<b><liferay-ui:message key="comments" /> </b> : <span>${insufficientComments}</span>
								</div>
							</div>		
							<div class="row">
								<c:if test="${not empty insufficientDocumentList}">
									<div class="col-md-12"><b><liferay-ui:message key="attachments" /> </b>&nbsp;:</div>
									<c:forEach items="${insufficientDocumentList}" var="docs">
										<div class="col-md-12">
											 <span><a href="${docs.documentUrl}" target="_blank">${docs.dFFileName }</a></span>
										</div>
									</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>

					<c:if test="${!employerRole && statusResponseList.size() gt 0}">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="comments" />
							<c:if test="${isVEHPCCommittee}">
								<c:forEach items="${equivalencyRequest.getTransitions()}"
									var="transition">
									<c:if test="${!hasCommentAdded && transition eq 'assignToMe'}">
										<button class="btn omsb-bg-red-button" type="button"
											data-toggle="modal" data-target="#committeeCommentsModal"
											data-rowcount="saveComments">
											<img
												src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg"
												style="cursor: default;" alt="">
											<liferay-ui:message key="add-comment" />
										</button>
									</c:if>
								</c:forEach>
							</c:if>
						</h4>
						<%@ include file="./committee-model-view.jsp"%>
						<ul class="omsb-comments-list">
							<li>
								<div class="omsb-comment-box">
									<div class="omsb-comment-box-header">
										<h3 class="comment-title">
											<span class="comment-author-name">${statusResponseList.get(0).getName()}</span>${statusResponseList.get(0).getRole()}</h3>
										<span class="posted-date">${statusResponseList.get(0).getDateCreated()}</span>
									</div>
									<div class="omsb-comment-body">
										<p>${statusResponseList.get(0).getComments()}</p>
									</div>
								</div> <c:if test="${!employerRole && statusResponseList.size() gt 1}">
									<div class="colspan-child">
										<liferay-ui:message key="expand" />
									</div>
									<ul>
										<c:forEach items="${statusResponseList}" var="statusResponse"
											varStatus="loop">
											<c:if test="${loop.index != 0}">
												<li>
													<div class="omsb-comment-box">
														<div class="omsb-comment-box-header">
															<h3 class="comment-title">
																<span class="comment-author-name">${statusResponse.getName()}</span>${statusResponse.getRole() }</h3>
															<span class="posted-date">${statusResponse.getDateCreated()}</span>
														</div>
														<div class="omsb-comment-body">
															<p>${statusResponse.getComments()}</p>
														</div>
													</div>
												</li>
											</c:if>
										</c:forEach>
									</ul>
								</c:if>
							</li>
						</ul>
					</c:if>


				
			<div class="omsb-card bottom-backbtn-wrap">
				<button name="submit" type="submit" class="btn omsb-btn omsb-bc-red-button">
					<img alt=""	src="${themeDisplay.getPathThemeImages()}/svg/Initiate_icon.svg">
					<liferay-ui:message key="resubmit" />
				</button>
				<a class="btn omsb-btn btn-back" href="${equivalencyURL }"><i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</div>
		</div>
	</div>
</div>
</form>

<script>
	
	/* ----------------------Add Certificates all JS method code----------------------- */
// var addPopUpRow = 1;
var dataTable1 = document.getElementById('dataTable1').querySelector('tbody');
var addPopUpRow = dataTable1.rows.length;
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
		actionCell1.append(actionElement1);
		actionCell1.append(element4);
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
		actionCell1.appendChild(actionElement1);
		actionCell1.appendChild(element4);
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

	/*$("#<portlet:namespace/>verificationReportPaymentReceiptEdit").text(vReportPaymentReceipt);
	  $("#<portlet:namespace/>certificateFileEdit").val(certificate);  
	  
	  document.getElementById('verificationReportPaymentReceiptLabel').innerHTML = vReportPaymentReceipt;
	  document.getElementById('certificateFileLabel').innerHTML = certificate;
	  */
	
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
		//$("#<portlet:namespace />addPopUpRow").val(addPopUpRow);
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
var addDocumentPopUpRow = 1;
function otherDocumentAddRow(){
	document.getElementById('otherDocumentModal').style.display = 'block';
	document.getElementById("<portlet:namespace />addOtherDocumentForm").reset();
}
		
function otherDocumentSetValues(){
	
	var A = AUI();
	var documentType = A.one("#<portlet:namespace />documentType").val();
	var attachmentFile = document.getElementById("<portlet:namespace />attachmentFile").files[0];
	var table1 = document.getElementById('otherDocumentDataTable').querySelector('tbody');
	addDocumentPopUpRow++;
	
	var rowCount1 = table1.rows.length;
	var row1 = table1.insertRow(rowCount1);
	
 	var documentTypeCell = row1.insertCell(0);
	var documentTypeElement = document.createElement("input");
	documentTypeElement.type = "text";
	documentTypeElement.value = documentType;
	documentTypeElement.readOnly = true;
	documentTypeElement.name = "documentType" + addDocumentPopUpRow;
	documentTypeElement.id = "documentType" + addDocumentPopUpRow;
	documentTypeElement.className="form-control";
	documentTypeCell.appendChild(documentTypeElement);
	 
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

function handleClick(checkbox) {
	console.log("checkbox:::"+checkbox);
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
	console.log(empName+" dateOfBirth : "+dateOfBirth+" personIdpersonId "+personId , "dfrn ::"+dfrn)
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
		success : function(dataJson) {
			console.log(":::::::data:::::::ddd:::",dataJson.length);
			var data = dataJson[0];
			console.log("2222");
			$("#<portlet:namespace/>fullName").val(empName);
			$("#<portlet:namespace/>nationality").val(data.nationality);
			$("#<portlet:namespace/>passportNumber").val(data.passportNumber);
			$("#<portlet:namespace/>dateOfBirth").val(data.dateOfBirth);
			$("#<portlet:namespace/>email").val(data.email);
			$("#<portlet:namespace/>cellphoneNumber").val(data.mobileNumber);
			$("#<portlet:namespace/>profession").val(data.profession);
			$("#<portlet:namespace/>personId").val(data.personId);
			$("#<portlet:namespace/>dfrn").val(data.dfrn);
			var table1 = document.getElementById('dataTable1').querySelector('tbody');
	 		var rowCount1 = table1.rows.length;
	 		row1 = table1.insertRow(rowCount1);	
			for (i = 1; i < dataJson.length; i++) {	
		 		var jsonObj = dataJson[i];
		 		i++;
		 		console.log(":::::::data::::::Iterate::::",jsonObj);
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
				fileEntryIdCell = row1.insertCell(7);
				
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
				issuedFromElement.value = jsonObj.issuingFrom;
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
			
		},
	});
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
/* $('#<portlet:namespace/>employeeDateOfBirth').datepicker({
	format: "dd/mm/yyyy",
	orientation: "bottom auto",
	autoclose: true,
	endDate: new Date()
}).on('change', function(){
	$('.datepicker').hide();
});

$('#<portlet:namespace/>dateOfBirth').datepicker({
	format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    endDate: new Date()
}).on('change', function(){
	$('.datepicker').hide();
}); */

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

// Add Official REquest letter
function addOfficialLetter(){
	<%-- var officialTable = document.getElementById('official-request-certificates-table').querySelector('tbody');
	$("#official-request-certificates-table").find('tbody tr'). 
	var row1 = officialTable.insertRow(0);
 	var officialcell2 = row1.insertCell(0);
 	var officialcell3 = row1.insertCell(1);
 	var officialcell4 = row1.insertCell(2);
 	
	/* var officialLetterElemant = document.createElement("input");
	officialLetterElemant.type = "text";
	officialLetterElemant.value = 'official-request-letter';
	officialLetterElemant.readOnly = true;
	officialLetterElemant.name = "documentType";
	officialLetterElemant.id = "documentType";
	officialLetterElemant.className="form-control";
	officialcell2.appendChild('<liferay-ui:message key="official-request-letter" />'); */
	
	 var element4 = document.createElement("button");
	element4.className = "btn mx-2";
	element4.value="edit";
	element4.type="button";
	var imageElement2 = document.createElement("img");
	imageElement2.src = '<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg';
	element4.setAttribute("data-editid");
	element4.setAttribute('onClick', 'viewRow(this)');
	element4.appendChild(imageElement2);
	officialcell3.appendChild(element4);
	
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
	officialcell3.appendChild(actionElement1);
	
	var officialRequestLetter = document.getElementById("officialRequestLetter").files[0];
	
	var certificateElement = document.createElement("input");
	certificateElement.type = "file";
	certificateElement.name = "certificatetbl";
	certificateElement.id = "certificate";
	certificateElement.style="display:none;"
	var container = new DataTransfer();
	container.items.add(officialRequestLetter);
	certificateElement.className = "form-control";
	certificateElement.files = container.files;
	officialcell4.appendChild(certificateElement);
	
	$('#addOfficialLetterModal').modal('hide'); --%>
	
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
</script>