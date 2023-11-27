<%@ include file="../init.jsp"%>
<portlet:actionURL name="<%=MVCCommandNames.WORKFLOW_UPDATE%>"
	var="quivalencyWorkflowURL" />
<portlet:renderURL var="equivalencyURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<c:set var="pd" value="${personalDetail}"></c:set>
<c:set var="comments" value="${eqReqStatusComments}"></c:set>
<c:set var="caseRequestFileUrl" value="${caseRequestFileUrl}" />
<c:set var="vehpcD" value="${vehpcDesion}" />
<c:set var="aD" value="${adminDesion}" />
<c:set var="n" value="${personNatinality}"></c:set>
<script>
function start_richtext(id){
	$('#' + id).richText();
}
</script>
<!--- Start Main Content Section Here --->
<section class="omsb-main-wrapper" id="omsb-main-wrapper">

	<!-- Inner Wrapper Contents -->
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="view-equivalency-request" />
					</div>
				</div>
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
							key="equivalency-request-id" /></div> <div class="label-content">EQ-${equivalencyRequestId}</div>
				</div>
			</div>

				<div
					class="omsb-card omsb-card-graybg omsb-noBorderRadius existing-certificates-wrap">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="documents-to-be-evaluated" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables"
							id="existing-certificates-table">
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
									<c:choose>
										<c:when test="${evaluated.documentType eq 'Case Report'}">
										</c:when>
										<c:otherwise>
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
													href="${evaluated.documentUrl}"><liferay-ui:message
															key="view" /></a></td>
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
						<liferay-ui:message key="other-documents" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables"
							id="existing-certificates-table">
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
													href="${otherDocs.documentUrl}"><liferay-ui:message
															key="view" /></a></td>
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
						<table class="display omsb-datatables"
							id="official-request-certificates-table">
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
										href="${officialReqeustDocument.documentUrl}"><liferay-ui:message
												key="view" /></a></td>
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
							id="official-request-certificates-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="document-type" /></th>
									<th><liferay-ui:message key="view" /></th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${paymentDocumentList.size() gt 0}" >
								<%-- <c:forEach var="paymentDocs" items="${paymentDocumentList}"> --%>
									<tr>
										<td>${paymentDocumentList.get(0).documentType }</td>
										<td><a target="_blank" class="download-link"
											href="${paymentDocumentList.get(0).documentUrl}"><liferay-ui:message
													key="view" /></a></td>
									</tr>
								<%-- </c:forEach> --%>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			
			<!-- To show only VEHPC Admin & Committee -->
			<c:if test="${not empty certificateURL && !employerRole}">
				<div class="row">
					<h4 class="casereport-title omsb-card-title">
						<liferay-ui:message key="equivalency-certificate" />
					</h4>
					<div class="col-md-12">
						<div class="form-group omsb-view-file">
							<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
							<label> <span class=""> ${certificateName}</span> <span
								class=""> <a href="${certificateURL}"
									class="btn btn-label view-download" target="_blank"><liferay-ui:message
											key="view-file" /></a> <a href="${certificateURL}"
									class="btn btn-label view-download" download><liferay-ui:message
											key="download-file" /></a>
							</span>
							</label>
						</div>
					</div>
				</div>
			</c:if>
			
			<aui:form action="${quivalencyWorkflowURL}"
				name="equateEquivalencyUpdate" enctype="multipart/form-data">
				<aui:input type="hidden" name="equatTransitionName"
					id="equatTransitionName" value="" />
				<aui:input type="hidden" name="equateEquivalencyId"
					value="${equivalencyRequestId}" />
				<aui:input type="hidden" name="totalCountOfCertificates"
					value="${noOfEvaluateDocumentInfos}" />
				<c:forEach items="${transitionNames}" var="transition">
					<c:choose>
						<c:when test="${transition eq 'assignToMe'}">
							<input type="button" name="btn" class="btn btn-primary mx-2"
								onClick="setTransition('assignToMe')"
								value='<liferay-ui:message key="assign-to-me"/>' />
						</c:when>
						<c:when test="${transition eq 'complete'}">
							<!-- VEHPC	Admin block -->
							<div class="omsb-card">
								<h4 class="omsb-card-title">
									<liferay-ui:message key="equivalency-details" />
								</h4>
								<div class="omsb-list-view table-responsive">
									<table class="display omsb-datatables"
										id="equivalency-details-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="certificates" /></th>
												<th><liferay-ui:message
														key="rapporteur-equivalency-level" /></th>
												<th><liferay-ui:message key="rapporteur-comments" /></th>
												<th><liferay-ui:message key="final-equivalency-level" /></th>
												<th><liferay-ui:message key="comments-by-admin" /></th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${evaluateDocumentInfos}"
												var="evaluateDocumentInfo" varStatus="loop">
												<tr>
													<td>

														<div class="certificates-dtls">

															<h4 class="certificates-title">${evaluateDocumentInfo.qualification}</h4>
															<aui:input name="documentInfoId${loop.index}"
																type="hidden"
																value="${evaluateDocumentInfo.documentInfoId}" />
															<aui:input name="isAdmin" type="hidden" value="true" />
														</div>

													</td>
													<td>
														<c:if test="${equivelencyDecisionByEqIdResItemPojoList.size() gt 0 }" >
															<div class="form-group">
																<label class="label-content">
																<%-- ${not empty equivelencyDecisionByEqIdResItemPojoList.get(loop.index).getEquivalencyLevelId().getKey() ? --%>
																 ${equivelencyDecisionByEqIdResItemPojoList.size() gt 0 ? 
																equivelencyDecisionByEqIdResItemPojoList.get(loop.index).getEquivalencyLevelId().getName():'none'}</label>
															</div>
														</c:if>	
													</td>
													<td>
														<c:if test="${equivelencyDecisionByEqIdResItemPojoList.size() gt 0 }" >
															<c:set var="reamMoreVar"
																value="${equivelencyDecisionByEqIdResItemPojoList.size() gt 0 ? 
															equivelencyDecisionByEqIdResItemPojoList.get(loop.index).getComments():'none'}"></c:set>
															<label class="label-content">
																<div class="read-more-pp${loop.index}">${reamMoreVar}
																</div>
															</label> <%@ include file="./read-more-popup.jspf"%>
														</c:if>
													</td>
													<td style="max-width: 400px;">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<select name="equivalencyLevelAdmin${loop.index}"
																		id="equivalencyLevelAdmin"
																		class="custom-select form-control equivalencyLevelAdmin${loop.index}">
																		<aui:option value="">
																			<liferay-ui:message key="select" />
																		</aui:option>
																		<c:forEach items="${equivalencyLevelList}"
																			var="equivalencyLevel1">
																			<option value="${equivalencyLevel1.getKey()}"><liferay-ui:message
																					key="${equivalencyLevel1.getName(themeDisplay.getLocale())}" /></option>
																		</c:forEach>

																	</select>
																</div>
															</div>
															<div
																class="col-md-12 d-none eq-level-reason${loop.index}">
																<div class="form-group">
																	<label><liferay-ui:message
																			key="equivalency-level-reason" /></label> <select
																		name="equivalencyLevelReason${loop.index}"
																		id="equivalencyLevelReason${loop.index}"
																		class="custom-select form-control">
																		<option value=""><liferay-ui:message
																				key="select" /></option>
																		<c:forEach items="${eqLevelReasonList}"
																			var="eqLevelReason">
																			<option value="${eqLevelReason.getKey()}">
																				<liferay-ui:message
																					key="${eqLevelReason.getName(themeDisplay.getLocale())}" />
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-md-12 otherReason${loop.index} d-none">
																<div class="form-group">
																	<input type="text"
																		placeholder='<liferay-ui:message key="type-other-reason-here"/>'
																		name="equivalencyLevelOtherReason${loop.index}"
																		class="form-control">
																</div>
															</div>
															<div class="col-md-12">
																<div class="form-group">
																	<div class="custom-file">
																		<aui:input id="additionalAttachment${loop.index}"
																			name="additionalAttachment${loop.index}" type="file" label=""
																			cssClass="custom-file-input"
																			 />
																			<label
																			class="custom-file-label"
																			for='<portlet:namespace/>additionalAttachment${loop.index}'></label>
																	</div>
																</div>
															</div>
														</div>
													</td>
													<td>
														<%@ include file="./add-comments-popup.jspf"%>
														<div class="c-m-text${loop.index} c-m-text-css d-none"></div>
														<div class="c-m-show-add${loop.index}">
															<a class="" data-toggle="modal"
																data-target="#addCommentsModal${loop.index}"> <liferay-ui:message
																	key="add-comments" />
															</a>
														</div>
														<div class="c-m-show-edit${loop.index} d-none">
															<a class="" data-toggle="modal"
																data-target="#addCommentsModal${loop.index}"> <liferay-ui:message
																	key="edit-comments" />
															</a>
														</div> <%-- <textarea onkeyup="countChar(this)" class="comments"
                                   					 name="<portlet:namespace />equivalencyLevelAdminComments${loop.index}" rows="5" id="admin-comment${loop.index}"></textarea> --%>
													</td>
												</tr>
												<script> 
												var rid ='';
												var index = ${loop.index};
												$('#admin-comment'+${loop.index}).richText(); 
												var readMoreString = '${reamMoreVar}';
												console.log('readMoreString ?' , readMoreString);
												var result = readMoreString.slice(0, 10)+'...';
												console.log('result length is  ?' ,result.length);
												if (result.length > 30){
													$('.read-more-pp'+${loop.index}).html(result + "<a data-toggle='modal' data-target='#readMoreModal${loop.index}'><liferay-ui:message key='read-more' /></a>");
												} else {
													$('.read-more-pp'+${loop.index}).html(readMoreString);
												}
												$('.doTask'+${loop.index}).on('click', function(){
													$('.c-m-text'+${loop.index}).html('');
													console.log('rid ?' , rid);
													$('.c-m-text'+${loop.index}).html($('#admin-comment'+${loop.index}).val());
													console.log('textValue at index ?', ${loop.index}, '  and value is ?' , $('#admin-comment'+${loop.index}).val());
													$('.c-m-show-edit'+ ${loop.index}).removeClass('d-none');
													$('.c-m-show-add'+ ${loop.index}).addClass('d-none');
													$('.c-m-text' + ${loop.index}).removeClass('d-none');
												});
												$('.equivalencyLevelAdmin'+${loop.index}).on('change', function() {
													console.log('showReason() is invoking..');
													console.log('selected val is.', $(this).val());
													
													document.getElementById('certificateDecision'+${loop.index}).innerHTML = $(this).find(":selected").text();
													document.getElementById('certificateDecisionArabic'+${loop.index}).innerHTML = $(this).find(":selected").text();
													document.getElementById('saveCertificateDecision'+${loop.index}).innerHTML = $(this).find(":selected").text();
													document.getElementById('saveCertificateDecisionArabic'+${loop.index}).innerHTML = $(this).find(":selected").text();
													
													if ($(this).val() == 'none') {
													console.log(' inside selected val is.', $(this).val());
														$('.eq-level-reason'+ ${loop.index}).removeClass('d-none');
													} else {
													    $('.eq-level-reason'+ ${loop.index}).addClass('d-none');
													}
												});
												
												$('#equivalencyLevelReason'+${loop.index}).on('change', function() {
													console.log('showReason() is invoking..');
													console.log('selected val is.', $(this).val());
													if ($(this).val() == 'others') {
													console.log(' inside selected val is.', $(this).val());
														$('.otherReason'+ ${loop.index}).removeClass('d-none');
													} else {
													    $('.otherReason'+ ${loop.index}).addClass('d-none');
													}
												});
											</script>

											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
							<%@include file ="../certificate/edit-certificate.jsp" %>
							<div class="omsb-card bottom-backbtn-wrap">
								<input type="button" name="btn" id="completeTransition"
									disabled="disabled" class="btn omsb-btn btn-back"
									onClick="setTransition('${transition}')"
									value='<liferay-ui:message key="${transition}"/>'></input> <a
									class="btn omsb-btn btn-back" href="${equivalencyURL}"><i
									class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
							</div>

						</c:when>
						<c:otherwise>
							<!-- VEHPC	Committee block -->

							<div class="omsb-card">
								<h4 class="omsb-card-title">
									<liferay-ui:message key="equivalency-details" />
								</h4>
								<div class="omsb-list-view table-responsive">
									<table class="display omsb-datatables"
										id="equivalency-details-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="certificates" /></th>
												<th><liferay-ui:message key="equivalency-level" /></th>
												<th><liferay-ui:message key="comments" /></th>

											</tr>
										</thead>
										<tbody>

											<c:forEach items="${evaluateDocumentInfos}"
												var="evaluateDocumentInfo" varStatus="loop">
												<tr>
													<td>
														<div class="certificates-dtls">

															<h4 class="certificates-title">${evaluateDocumentInfo.qualification}</h4>
															<aui:input name="documentInfoId${loop.index}"
																type="hidden"
																value="${evaluateDocumentInfo.documentInfoId}" />
														</div>
													</td>
													<td>
														<div class="form-group">
															<select name="equivalencyLevel${loop.index}"
																id="equivalencyLevel" class="custom-select form-control">
																<option><liferay-ui:message key="select" />
																</option>
																<c:forEach items="${equivalencyLevelList}"
																	var="equivalencyLevel">
																	<option value="${equivalencyLevel.getKey()}"><liferay-ui:message
																			key="${equivalencyLevel.getName(themeDisplay.getLocale())}" /></option>
																</c:forEach>

															</select>
														</div>
													</td>
													<td>
														<%-- <aui:input id="equivalencyLevelComments"
														name="equivalencyLevelComments${loop.index}" label=""
														class="form-control" value="" type="textarea" /> --%> <textarea
															onkeyup="countChar(this)" class="comments "
															name="<portlet:namespace />equivalencyLevelComments${loop.index}"
															rows="5" id="comm-comment${loop.index}"></textarea>
													</td>
												</tr>
												<script> 
												var rid ='';
												rid = 'comm-comment'+${loop.index};
												start_richtext(rid); 
											</script>

											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
							
							<c:if test="${!employerRole && statusResponseList.size() gt 0}">
								<div class="omsb-card">
								<h4 class="omsb-card-title">
									<liferay-ui:message key="comments" />
								</h4>
								<ul class="omsb-comments-list">
									<li>
										<div class="omsb-comment-box">
											<div class="omsb-comment-box-header">
												<h3 class="comment-title">
													<span class="comment-author-name">${statusResponseList.get(0).getName()}</span>${statusResponseList.get(0).getRole()}</h3>
												<span class="posted-date">${statusResponseList.get(0).getDateCreated()}</span>
											</div>
											<div class="omsb-comment-body">
												<div class="row">
													<c:if
														test="${not empty statusResponseList.get(0).equivalencyCertificate }">
														<div class="col-md-6">
															<b>Equivalency Certificate </b>: <span>${statusResponseList.get(0).equivalencyCertificate}</span>
														</div>
													</c:if>
													<c:if
														test="${ not empty statusResponseList.get(0).equivalencyLevel }">
														<div class="col-md-6">
															<b>Equivalency Level </b>: <span>${statusResponseList.get(0).equivalencyLevel}</span>
														</div>
													</c:if>
													<c:if
														test="${not empty statusResponseList.get(0).equivalencyLevelReason  }">
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
													<div class="col-md-12">
														<b><liferay-ui:message key="attachments" /> </b>&nbsp;:
													</div>
													<c:if
														test="${not empty statusResponseList.get(0).documentList  }">
														<c:forEach
															items="${statusResponseList.get(0).documentList }"
															var="docs">
															<div class="col-md-12">
																<span><a href="${docs.documentUrl}"
																	target="_blank">${docs.dFFileName }</a></span>
															</div>
														</c:forEach>
													</c:if>
												</div>

											</div>
										</div> <c:if
											test="${!employerRole && statusResponseList.size() gt 1}">
											<div class="colspan-child">
												<liferay-ui:message key="expand" />
											</div>
											<ul>
												<c:forEach items="${statusResponseList}"
													var="statusResponse" varStatus="loop">
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
																		<c:if
																			test="${not empty statusResponse.equivalencyCertificate }">
																			<div class="col-md-6">
																				<b>Equivalency Certificate </b>: <span>${statusResponse.equivalencyCertificate}</span>
																			</div>
																		</c:if>
																		<c:if
																			test="${ not empty statusResponse.equivalencyLevel }">
																			<div class="col-md-6">
																				<b>Equivalency Level </b>: <span>${statusResponse.equivalencyLevel}</span>
																			</div>
																		</c:if>
																		<c:if
																			test="${not empty statusResponse.equivalencyLevelReason  }">
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
																		<div class="col-md-12">
																			<b><liferay-ui:message key="attachments" /> </b>&nbsp;:
																		</div>
																		<c:if
																			test="${not empty statusResponse.documentList  }">
																			<c:forEach items="${statusResponse.documentList }"
																				var="docs">
																				<div class="col-md-12">
																					<span><a href="${docs.documentUrl}"
																						target="_blank">${docs.dFFileName }</a></span>
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
								</div>
							</c:if>
							<div class="omsb-card bottom-backbtn-wrap">
								<input type="button" name="btn" disabled="disabled"
									id="equateTransition" class="btn omsb-btn btn-back"
									onClick="setTransition('${transition}')"
									value='<liferay-ui:message key="${transition}"/>'></input>
								<!-- <button class="btn omsb-bc-red-button" type="button" title="View">View</button> -->
								<a class="btn omsb-btn btn-back" href="${equivalencyURL}"><i
									class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
							</div>

						</c:otherwise>
					</c:choose>
				</c:forEach>
			</aui:form>

			<%-- <!-- To show only VEHPC Committee -->
		
			

				<div class="omsb-card">
					<h4 class="omsb-card-title"><liferay-ui:message key="equivalency-details"/></h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="equivalency-details-table">
							<thead>
								<tr>
									<th><liferay-ui:message key="certificates"/></th>
									<th><liferay-ui:message key="equivalency-level"/></th>
									<th><liferay-ui:message key="comments-by-committee"/></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${evaluateDocumentInfos}" var="evaluateDocumentInfo">
								<tr>
									<td><c:out value="${evaluateDocumentInfo.getFileEntryId()}" /></td>
									<td><aui:select  name="equelencyLevel"
											id="equelencyLevel" value="${personNatinality}" class="custom-select form-control">
											<aui:option value=""><liferay-ui:message key="select"/></aui:option>
											<c:forEach var="equivalencyLevels" items="${equivalencyLevelList }">
												<aui:option value="${equivalencyLevels.getKey()}">
													<liferay-ui:message
														key="${equivalencyLevels.getName(themeDisplay.getLocale())}" />
												</aui:option>
											</c:forEach>
										</aui:select>
									</td>
								<td>${vehpcDesion.comments }</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> --%>
			<!-- End >>  To show only VEHPC Committee -->

		</div>
	</div>

	<!--// Inner Wrapper Contents -->
</section>
<!---// End Main Content Section Here --->

<script>
	$('#existing-certificates-table').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"ordering": false
	});
</script>

<script type="text/javascript">

	function setTransition(transitionName) {
		$("#<portlet:namespace />equatTransitionName").val(transitionName);
		if(transitionName == 'complete'){
			if (document.getElementById('certificateInEnglish').checked) {
				document.getElementById('htmlDivData').value = $('.saveCertificateInEnglish').html();
			}
			else if (document.getElementById('certificateInArabic').checked) {
				document.getElementById('htmlDivData').value = $('.saveCertificateInArabic').html();	
			}
		}
		
		$("#<portlet:namespace />equateEquivalencyUpdate").submit();
	}

	/* $('#<portlet:namespace/>dateOfBirth').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true
	  }).on('change', function(){
	      $('.datepicker').hide();
	  }); */

	$("#equivalencyLevel").change(
			function() {
				var selectedEquivalencyLevel = this.value;
				if (selectedEquivalencyLevel != null) {
					console.log("selectedEquivalencyLevel inside: ",
							selectedEquivalencyLevel);
					$('#equateTransition').prop('disabled', false);
				}else{
					$('#equateTransition').prop('disabled', true);
				}
				console.log("selectedEquivalencyLevel : ",
						selectedEquivalencyLevel)
			});

	$("#equivalencyLevelAdmin").change(
			function() {
				var selectedequivalencyLevelAdmin = this.value;
				if (selectedequivalencyLevelAdmin != null) {
					console.log("selectedequivalencyLevelAdmin inside: ",
							selectedequivalencyLevelAdmin);
					$('#completeTransition').prop('disabled', false);
				}
				console.log("selectedEquivalencyLevel : ",
						selectedequivalencyLevelAdmin)
			});
	$('#equivalencyLevelAdmin').on('change', function() {
		console.log('showReason() is invoking..');
		console.log('selected val is.', $(this).val());
		if ($(this).val() == 'none') {
		console.log(' inside selected val is.', $(this).val());
			$('.eq-level-reason').removeClass('d-none');
		} else {
		    $('.eq-level-reason').addClass('d-none');
		}
	});
	
	
</script>

<style>
.c-m-text-css {
	overflow: auto;
	text-overflow: ellipsis;
	/* white-space: nowrap; */
	border: 1px solid #DC3545;
	border-radius: 8px;
	/*  height: 100px; */
	margin: 20px auto;
	padding: 15px 25px;
	width: 300px;
	max-height: 200px;
}
table.omsb-datatables > tbody td .form-group {
	padding: 10px !important;
}
</style>
