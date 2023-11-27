<%@page import="omsb.vehpc.equivalency.web.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>

<c:set var="created_key" value="<%=EquivalencyStatusConstants.CREATED_KEY%>"></c:set>
<c:set var="initiated_key" value="<%=EquivalencyStatusConstants.INITIATED_KEY%>"></c:set>
<c:set var="equated_key" value="<%=EquivalencyStatusConstants.EQUATED_KEY%>"></c:set>

<portlet:renderURL var="equivalencyURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:actionURL name="<%=MVCCommandNames.WORKFLOW_UPDATE%>"
	var="quivalencyWorkflowURL" />
<portlet:actionURL name="<%=MVCCommandNames.ADMIN_INPROGRESS_ACTION%>"
	var="adminInProgressURL" />
<c:set var="pd" value="${personalDetail}"></c:set>
<c:set var="comments" value="${eqReqStatusComments}"></c:set>
<c:set var="caseRequestFileUrl" value="${caseRequestFileUrl}" />
<c:set var="vehpcD" value="${vehpcDesion}" />
<c:set var="aD" value="${adminDesion}" />

<!--- Start Main Content Section Here --->
<section class="omsb-main-wrapper" id="omsb-main-wrapper">

<!-- Inner Wrapper Contents -->
<div id="wrapper">
	<div class="container">
		<!-- <div class="omsb-card">
			
			
		</div> -->
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<liferay-ui:message key="view-equivalency-request" />
				</div>
				<div class="information">
					<span class="${equivalencyRequest.statusColorClass}">
						<c:if test = "${equivalencyRequest.getStatus() eq 'In Progress' && isVEHPCEmployer}">
							<liferay-ui:message key="submitted" />
						</c:if>
						<c:if test = "${((equivalencyRequest.getStatus() ne 'In Progress') && isVEHPCEmployer) || not isVEHPCEmployer}">
							${equivalencyRequest.getStatus()}
						</c:if>
					</span>
				</div>
			</div>
			<c:if test="${!isVEHPCEmployer}">
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
			</c:if>

			<h4 class="omsb-card-title">
				<liferay-ui:message key="request-details" />
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

			<%-- <div
				class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="attachments" />
				</h4>
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="existing-certificates-table">
						<thead>
							<tr>
								<th><liferay-ui:message key="category" /></th>
								<th><liferay-ui:message key="document-type" /></th>
								<th><liferay-ui:message key="view" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="documentInfo" items="${documentInfoList}">
								<c:choose>
  									<c:when test="${documentInfo.documentType eq 'Case Report'}">
  									</c:when>
								  <c:otherwise>
								    <tr>
										<td>${documentInfo.documentTypeCategory}</td>
										<td>${documentInfo.documentType}</td>
										<td><a target="_blank" class="download-link"
											href="${documentInfo.documentUrl}"><liferay-ui:message key="view" /></a></td>
									</tr>
								  </c:otherwise>
								</c:choose>
								
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div> --%>
			
			<div
				class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="documents-to-be-evaluated" />
				</h4>
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="existing-certificates-table">
						<thead>
							<tr>
								<th><liferay-ui:message key="issued-country" /></th>
								<th><liferay-ui:message key="qualification" /></th>
								<c:if test="${isVEHPCAdmin || isVEHPCRapporteur}">
									<th><liferay-ui:message key="suggested-level" /></th>
								</c:if>
								<th><liferay-ui:message key="view" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="evaluated" items="${evaluatedDocumentList}">
							    <tr>
									<td>${evaluated.issuingAuthorityCountryName}</td>
									<td>${evaluated.documentType}</td>
									<c:if test="${isVEHPCAdmin || isVEHPCRapporteur}">
										<c:choose>
		  									<c:when test="${not empty evaluated.suggestedEquivalencyLevel}">
		  										<td>${evaluated.suggestedEquivalencyLevel}</td>
		  									</c:when>
										  	<c:otherwise>
										    	<td><liferay-ui:message key="no-level-suggested" /></td>
										  	</c:otherwise>
										</c:choose>
									</c:if>
									<td><a target="_blank" class="download-link"
										href="${evaluated.documentUrl}"><liferay-ui:message key="view" /></a></td>
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
				</h4>
				<div class="omsb-list-view table-responsive">
					<table class="display omsb-datatables" id="existing-certificates-table">
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
							</tr>
						</thead>
						<tbody>
						    <tr>
								<td><liferay-ui:message key="official-request-letter" /></td>
								<td><a target="_blank" class="download-link"
									href="${officialReqeustDocument.documentUrl}"><liferay-ui:message key="view" /></a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<c:if test="${caseReportList.size() gt 0 && !isVEHPCEmployer }"> 
				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="case-report-documents" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="case-report-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="document-type" /></th>
									<th><liferay-ui:message key="view" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="caseReport" items="${caseReportList}">
								    <tr>
										<td>${caseReport.documentType }</td>
										<td><a target="_blank" class="download-link"
											href="${caseReport.documentUrl}"><liferay-ui:message key="view" /></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>	
					</div>
				</div>
			</c:if>  
			<c:if test="${isVEHPCAdmin && equivalencyRequest.statusKey eq initiated_key }" >
				<h4 class="omsb-card-title">
					<liferay-ui:message key="additional-comments" />
						<button class="btn omsb-bg-red-button" type="button" data-toggle="modal"
						 data-target="#additionalCommentsModal" data-rowcount="saveComments">
							<liferay-ui:message key="add-additional-comment" />
						</button>
				</h4>
				<%@ include file="./additional-comments.jsp"%>
			</c:if>
			<%-- <c:if test="${additionalDocumentList.size() gt 0 && !employerRole}">
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="attachments" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="additional-doc-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="document-name" /></th>
									<th><liferay-ui:message key="view" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="additionalDocs" items="${additionalDocumentList}">
								    <tr>
										<td>${additionalDocs.getdFFileName() }</td>
										<td><a target="_blank" class="download-link"
											href="${additionalDocs.documentUrl}"><liferay-ui:message key="view" /></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>	
					</div>
				</div>
			</c:if> --%>
			<c:choose>
				<c:when test="${paymentDocumentList.size() gt 0}">
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
				</c:when>
				<c:when test="${caseReportDocumentList.size() gt 0}">
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
									<%-- <c:forEach var="caseReportDocs" items="${caseReportDocumentList}"> --%>
									    <tr>
											<td>${caseReportDocumentList.get(0).documentType }</td>
											<td><a target="_blank" class="download-link"
												href="${caseReportDocumentList.get(0).documentUrl}"><liferay-ui:message key="view" /></a></td>
										</tr>
									<%-- </c:forEach> --%>
								</tbody>
							</table>
						</div>
					</div>
				</c:when>
			</c:choose>	
		
			<c:if test="${equivelencyDecisionByEqIdResItemPojoList.size() gt 0 && isShowEquivalencyLevel}">
				<div class="omsb-card">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="equivalency-details" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="equivalency-details-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="certificates"/></th>
									<th><liferay-ui:message key="rapporteur-equivalency-level" /></th>
									<th><liferay-ui:message key="rapporteur-comments" /></th>
									<c:if test="${adminDecisions.size() gt 0}">
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
									
										<c:if test="${adminDecisions.size() gt 0}">
											<td><div class="form-group"><label class="label-content">${adminDecisions.get(commiteeDecision.key).equivalencyLevelId.key}</label></div></td>
											<td><label class="label-content">${adminDecisions.get(commiteeDecision.key).comments}</label></td>
										</c:if>
									</tr>
								</c:forEach>
							</c:if> 
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
			
			<!-- To show only VEHPC Admin & Committee -->
			<c:if test="${not empty certificateURL && isShowEquivalencyCertificate}">
				<div class="row">
					<h4 class="casereport-title omsb-card-title"><liferay-ui:message key="equivalency-certificate" /></h4>
					<div class="col-md-12">
						<div class="form-group omsb-view-file">
							<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
							<label> 
								<span class=""> ${certificateName}</span> 
								<span class="">	
									<a href="${certificateURL}" class="btn btn-label view-download" target="_blank"><liferay-ui:message key="view-file" /></a> 
									<a href="${certificateURL}" class="btn btn-label view-download" download><liferay-ui:message key="download-file" /></a>
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

			<c:if test="${isVEHPCCommittee && statusResponseList.size() gt 0}">			
				<h4 class="omsb-card-title">
					<c:if test="${isVEHPCCommittee or isVEHPCRapporteur}">
						<liferay-ui:message key="comments" />
						<button class="btn omsb-bg-red-button" type="button"
							data-toggle="modal" data-target="#committeeCommentsModal"
							data-rowcount="saveComments">
							<liferay-ui:message key="add-committee-comment" />
						</button>
					</c:if>
					
				</h4>
				
				
				<%@ include file="./committee-model-view.jsp"%>
				
				<ul class="omsb-comments-list">
					<li>	<div class="omsb-comment-box">
								<div class="omsb-comment-box-header">
									<h3 class="comment-title">
										<span class="comment-author-name">${statusResponseList.get(0).getName()}</span>${statusResponseList.get(0).getRole()}</h3>
									<span class="posted-date">${statusResponseList.get(0).getDateCreated()}</span>
								</div>
								<div class="omsb-comment-body">
									<div class="row">
										<c:if test="${not empty statusResponseList.get(0).equivalencyCertificate }">
											<div class="col-md-6">
												<b>Equivalency Certificate </b>: <span>${statusResponseList.get(0).equivalencyCertificate}</span>
											</div>
										</c:if>
										<c:if test="${ not empty statusResponseList.get(0).equivalencyLevel }">
											<div class="col-md-6">
												<b>Equivalency Level </b>: <span>${statusResponseList.get(0).equivalencyLevel}</span>
											</div>
										</c:if>
										<c:if test="${not empty statusResponseList.get(0).equivalencyLevelReason  }">
											<div class="col-md-6">
												<b>Equivalency Reason </b>: <span>${statusResponseList.get(0).equivalencyLevelReason}</span>
											</div>	
										</c:if>
									</div>
									<div class="row">
										<div class="col-md-12">
											<b><liferay-ui:message key="comments" /> </b> : <span>${statusResponseList.get(0).getComments()}</span>
										</div>
									</div>		
									<div class="row">
										<c:if test="${not empty statusResponseList.get(0).documentList  }">
											<div class="col-md-12"><b><liferay-ui:message key="attachments" /> </b>&nbsp;:</div>
											<c:forEach items="${statusResponseList.get(0).documentList }" var="docs">
												<div class="col-md-12">
													 <span><a href="${docs.documentUrl}" target="_blank">${docs.dFFileName }</a></span>
												</div>
											</c:forEach>
										</c:if>
									</div>
									
								</div>
							</div>
							<c:if test="${!isVEHPCEmployer && statusResponseList.size() gt 1}">
								<div class="colspan-child">
									<liferay-ui:message key="expand" />
								</div>
								<ul>
									<c:forEach items="${statusResponseList}" var="statusResponse" varStatus="loop">
										<c:if test="${loop.index != 0}">
											<li>
												<div class="omsb-comment-box">
													<div class="omsb-comment-box-header">
														<h3 class="comment-title">
															<span class="comment-author-name">${statusResponse.getName()}</span>${statusResponse.getRole() }</h3>
														<span class="posted-date">${statusResponse.getDateCreated()}</span>
													</div>
													<div class="omsb-comment-body">
														<div class="row">
															<c:if test="${not empty statusResponse.equivalencyCertificate }">
																<div class="col-md-6">
																	<b>Equivalency Certificate </b>: <span>${statusResponse.equivalencyCertificate}</span>
																</div>
															</c:if>
															<c:if test="${ not empty statusResponse.equivalencyLevel }">
																<div class="col-md-6">
																	<b>Equivalency Level </b>: <span>${statusResponse.equivalencyLevel}</span>
																</div>
															</c:if>
															<c:if test="${not empty statusResponse.equivalencyLevelReason  }">
																<div class="col-md-6">
																	<b>Equivalency Reason </b>: <span>${statusResponse.equivalencyLevelReason}</span>
																</div>	
															</c:if>		
														</div>
														<div class="row">
															<div class="col-md-12">
																<b><liferay-ui:message key="comments" /> </b> : <span>${statusResponse.getComments()}</span>
															</div>
														</div>
														<div class="row">
															<c:if test="${not empty statusResponse.documentList  }">
																<div class="col-md-12"><b><liferay-ui:message key="attachments" /> </b>&nbsp;:</div>
																<c:forEach items="${statusResponse.documentList }" var="docs">
																	<div class="col-md-12">	
																		<span><a href="${docs.documentUrl}" target="_blank">${docs.dFFileName }</a></span>
																	</div>
																</c:forEach>
															</c:if>
														</div>
														
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
				<c:if test="${!isVEHPCEmployer }">
					 <c:if test="${isVEHPCAdmin && (equivalencyRequest.statusKey eq created_key or equivalencyRequest.statusKey eq 'adminDraft')}"> 
						<div class="col-md-4" >
								<aui:select name="actionType" label=""
									value="" required="true" cssClass="custom-select form-control" style="margin-top: 20px;" >
									<aui:option value=""><liferay-ui:message key="select-request-status"/> </aui:option>
									<aui:option value="ipAdmin"><liferay-ui:message key="inprogress-admin"/> </aui:option>
									<aui:option value="ipCommittee"><liferay-ui:message key="inprogress-committee"/> </aui:option>
									<aui:option value="insufficient"><liferay-ui:message key="insufficient"/> </aui:option>
								</aui:select>
						</div>
					</c:if>	
					<c:forEach items="${equivalencyRequest.getTransitions()}" var="transition">
						<c:choose>
							<c:when
								test="${transition eq 'equate' and equivalencyRequest.getStatusKey() eq initiated_key and isVEHPCRapporteur}">
								<a href="${equivalencyEquateURL}"
									class="btn omsb-btn omsb-bc-red-button"><img alt=""
									src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-equate.svg">
									<liferay-ui:message key="equate" /></a>
							</c:when>
							<c:when
								test="${(transition eq'assignToMe' or transition eq'complete') and equivalencyRequest.getStatusKey() eq equated_key}">
								<c:choose>
									<c:when test="${transition eq 'assignToMe'}">

										<aui:form action="${quivalencyWorkflowURL}"
											name="assignEqWf" enctype="multipart/form-data">
											<aui:input type="hidden" name="assignWfTransitionName"
												id="assignWfTransitionName" value="${transition}" />
											<aui:input type="hidden" name="assignEqId"
												value="${equivalencyRequest.getEquivalencyRequestId()}" />
											<a href="javascript:void(0)" class="btn omsb-btn omsb-bc-red-button" onClick="submitAssignEqWf()"><img alt=""
												src="${themeDisplay.getPathThemeImages()}/svg/Initiate_icon.svg">
												<liferay-ui:message key="assign-to-me" /></a>
										</aui:form>

									</c:when>
									<c:otherwise>
										<a href="${equivalencyEquateURL}"
											class="btn omsb-btn omsb-bc-red-button"><img alt=""
											src="${themeDisplay.getPathThemeImages()}/svg/completed.svg">
											<liferay-ui:message key="complete" /></a>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
					</c:forEach> 
				</c:if>
				<a class="btn omsb-btn btn-back" href="${equivalencyURL}"><i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</div>
		</div>
	</div>
</div>
<!--// Inner Wrapper Contents -->
<%@ include file="../common-modals.jspf"%>
</section>
<!---// End Main Content Section Here --->



<script type="text/javascript">

	function resetStatusType(){
		$("#<portlet:namespace />actionType").val(''); 
	}
	
	function submitAssignEqWf() {
		$("#<portlet:namespace />assignEqWf").submit();
	}

	$('#existing-certificates-table').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"pageLength" : 5
	});

	$('#equivalency-details-table').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"pageLength" : 2
	});
	
	$("#<portlet:namespace />actionType").on('change', function () {
		var value = $(this).val();
		if (value == 'ipAdmin') {
			 $('#adminInProgress').modal('show');
		} else if (value == 'ipCommittee') {
			 $('#initiateModal').modal('show');
		} else if (value == 'insufficient') {
			$('#markInsufficientModal').modal('show');
		}
		value = '';
	    
	});
	function closeModal(){
		$("#adminInProgress").modal('hide');
		$("#initiateModal").modal('hide');
		$('#markInsufficientModal').modal('hide');
	}
	
	$(document).ready(function(){
		$('.admin-initiate-comment').richText();
		$('.admin-in-progress-comment').richText();
		$("#additional-doc-table").DataTable({
			"bLengthChange" : false,
			"bFilter" : false,
			"pageLength" : 5
		});
	});
	
	function addMultiFiles(selectedFileName, tableId, finalFile, finalFileName){
		$('.file-table').removeClass('d-none');
		console.log('clicking this');
		var selectedFile = $('#'+ selectedFileName).prop('files')[0];
		console.log('file name ', selectedFile.name);
		var rowCount = $('#'+tableId+' tbody tr').length;
		console.log('rowCount is in addMultiFiles', rowCount);
		console.log('finalFile is in addMultiFiles', finalFileName);
		$.ajax({
	        url: '<%=addMultipleFilesURL.toString()%>',
	        async : false,
	        data : {
				<portlet:namespace />fileName : selectedFile.name,
				<portlet:namespace />index : rowCount,
				<portlet:namespace />tableId : tableId,
				<portlet:namespace />finalFileId : finalFileName
	        },
	        type : 'POST',
	        success : function(data) {
	        	console.log('data??', data);
	        	//$('.add-files-body').append(data);
	        	$('#' + tableId + ' tbody').append(data);
	        	$('#'+selectedFileName).val(''); 
	        	$('.custom-file-label').html('');
	        	
	        	var container = new DataTransfer();
	        	if (finalFile.files.length > 0 ){
		        	const fileListArr = Array.from(finalFile.files);
		        	for (let i = 0; i < fileListArr.length; i++) {
		        	    const oldFile = fileListArr[i]
		        	    container.items.add(oldFile); 
		        	}
	        	}
	        	container.items.add(selectedFile);
	        	finalFile.files = container.files;
	        },
	    });
	}
	
	
	function deleteMultiFile(finalFile, tableId, row){
		//var row = $(this).attr('row-data');
		console.log('row-data  attr is ?', row);
		$('#row-' + row).remove();
		var rowCount = $('#'+tableId+ ' tbody tr').length;
		if (rowCount == 0){
			$('.file-table').addClass('d-none');	
		}
		const fileListArr = Array.from(finalFile.files);
		fileListArr.splice(row,1);
		var container = new DataTransfer();
		for (let i = 0; i < fileListArr.length; i++) {
    	    const oldFile = fileListArr[i]
    	    container.items.add(oldFile); 
    	}
		finalFile.files = container.files;
		$('#delete-confirm').modal('hide');
	}
</script>