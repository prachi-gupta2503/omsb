<%@ include file="../../init.jsp"%>
<c:set var="certificateName" value="${certificateName}" />
<c:set var="appealComments" value="${appealComments}" />
<c:set var="certificatefileurl" value="${certificatefileurl}" />
<c:set var="docFileurl" value="${docFileurl}" />
<c:set var="equivalencylevelkey" value="${equivalencylevelkey}" />

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<portlet:actionURL var="WorkflowAssignURL" name="/appeal/workflow_action">
		<portlet:param name="equivalencyDecisionLevelId" value="${decisionLevelId}" />
		<portlet:param name="assignedToMe" value="${assignedToMe}" />
		<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
		<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
		<portlet:param name="<%=Constants.CMD %>" value="<%=AppealConstants.CMD_ASSIGN_TO_ME %>" />
		<portlet:param name="eqAppealId" value="${appealId}" />
</portlet:actionURL>

<portlet:actionURL var="completeWorkflowURL" name="/edit-appeal/workflow_action">
	<portlet:param name="equivalencyDecisionId" value="${decisionLevelId}" />
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
	<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
	<portlet:param name="eqAppealId" value="${appealId}" />
</portlet:actionURL>
<aui:form action="${completeWorkflowURL}" method="post" name="edit_Appeal" enctype="multipart/form-data">		
<div class="container" id="wrapper"> 
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle"><liferay-ui:message key="view-equivalency-appeal" /></div>
			<div class="information"><span class="${appealStatusColur.get(appeallantStatus)}">${appeallantStatus}</span></div>
		</div>
		
		<div class="omsb-card">
			<c:if test="${!hasVehpcEmployerRole}">
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
			
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-tableview" width="100%">
					<thead>
						<tr>
							<c:choose>
								<c:when test="${(hasEmployeeRole) || (hasEmployerRole)}">
									<th><liferay-ui:message key="certificate" /></th>
								</c:when>
								<c:otherwise>
									<th><liferay-ui:message key="name-of-certificate-to-be-evaluated" /></th>
								</c:otherwise>
							</c:choose>
							<th><liferay-ui:message key="equivalency-level" /></th>
							<th><liferay-ui:message key="comments" /></th>
						</tr>
					</thead>
				<tbody>
				<c:forEach items="${certificatesList}" var="certificatesList">
					<tr class="odd">
						<td>
							<c:if test="${not empty certificatesList.certificatefileurl }">
								<a href="${certificatesList.certificatefileurl}" target="_blank" view ><c:out value="${certificatesList.certificateName}" /></a>
							</c:if>
						</td>
						<td><c:out value="${certificatesList.getEquivalencyLevel().getName()}" /></td>
						<td>${certificatesList.comments}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="omsb-card">
		<%-- <c:if test="${appeal}"> --%>
			<%-- <div class="omsb-card omsb-card-graybg">
				<h4 class="omsb-card-title"><liferay-ui:message key="request-details" /></h4>
				<div class="row">
					<div class="col-md-12 label-box">
						<label class="label-name"><span>${appeallantUserRole}</span> <liferay-ui:message key="comments" /></label>
						<label class="label-content">${appealComments}</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 label-box">
						<label class="label-name"><liferay-ui:message key="supporting-documents"></liferay-ui:message></label>
					</div>
					<div class="col-md-12">
						<div class="form-group omsb-view-file">
							<c:forEach items="${docsList}" var="info">
						<!-- Access filename, fileEntryID, and docsfileurl for each DocumentInfo object -->
						<c:set var="filename" value="${info.dFFileName}" />
						<c:set var="fileEntryID" value="${info.fileEntryID}" />
						<c:set var="docsfileurl" value="${info.docsfileurl}" />
						<label><c:out value="${info.dFFileName}" />
					<span class=""> 
						<a href="${docsfileurl }"  target="_blank" class="btn btn-label view-download" ><liferay-ui:message key="view-file" /></a> 
						<button class="btn btn-label view-download" data-toggle="modal" data-edd="${supportingDoc}" 
						data-State="${docsfileurl}" data-target="#supporting-document"> <liferay-ui:message key="view-file" /></button>
					<a href="${docsfileurl}" class="btn btn-label view-download" download><liferay-ui:message key="download-file" /></a></span></label></a>
					</c:forEach>
				</div>
			</div>

		</div>
	</div> --%>
	
	<!--  POPUP Modal for new appeal -->
			<div class="modal fade omsb-modal" id="appeal-popup"
				tabindex="-1" role="dialog"
				aria-labelledby="markInsufficientModalTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">
								<liferay-ui:message key="supporting-documents" />
							</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div id="addmore-supporting-documents">
							<div class="modal-body">
								<div class="row">
									<div class="col-md-12">
										<aui:select name="type" id="type" label="type" cssClass="form-control" > 
											<aui:option><liferay-ui:message key="select" /></aui:option>
											<c:forEach var="type" items="${documentTypelist}">
												<aui:option value="${type.getKey()}" data-name="${type.getName(themeDisplay.getLocale())}">
													<liferay-ui:message
														key="${type.getName(themeDisplay.getLocale())}" />
												</aui:option>
											</c:forEach>
										</aui:select>
									 <p class="d-none value"  style="color:red;">
										<liferay-ui:message key="please-select-a-value" />
									</p>
									</div>
									 <div class="col-md-12">
											<div class="form-group">
												<label> <liferay-ui:message key="attachment"></liferay-ui:message></label>
												<div class="custom-file">
													<aui:input id="file" name="attachment" type="file" label=""
														cssClass="attachment form-control" required="" /> 
														<label class="custom-file-label" for='<portlet:namespace/>file'></label>
															<p class="d-none file" style="color:red;">
																	<liferay-ui:message key="please-select-a-file" />
															</p>
												</div>
											</div>
										</div> 	
											
			
									
										
								</div>
							</div>
							<div class="modal-footer">
								<aui:button type="button" onClick="setValues()" cssClass="btn omsb-bg-red-button yes" value="save"></aui:button>
								<aui:button type="button" onClick="cancelpopUp()"
								cssClass="btn omsb-bc-red-button No" value="cancel"  data-dismiss="modal"
								aria-label="Close"></aui:button>
							</div>
						</div>
					</div>
				</div>
			</div>
		<!--  POPUP Modal for new appeal Ends-->
			<div class="row">
				<div class="col-md-12">
					<div class="omsb-card">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="supporting-documents" />
							<button class="btn omsb-bg-red-button" type="button"
								onClick="popUp()" data-toggle="modal"
								data-target="#appeal-popup">
								<img src="../images/svg/plus_img.svg" alt="">
								<liferay-ui:message key="add" />
							</button>
						</h4>

						<div class="row">
							<div class="omsb-list-view table-responsive">
								<table class="omsb-datatables no-file-selector w-100" border="0" id="dataTable1">
									<thead>
										<tr>
											<th><liferay-ui:message key="type" /></th>
											<th><liferay-ui:message key="attachment" /></th>
											<th><liferay-ui:message key="action" /></th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${docsList}" var="info">
									<tr>
										<td>${info.documentTypeName}</td>
										<td>${info.dFFileName}</td>
										<td>
											<a href="${info.docsfileurl }"  target="_blank" class="download-link" ><liferay-ui:message key="view" /></a>
										</td>
									</tr>
									</c:forEach>
								</tbody>
								
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

<%-- <c:if test="${appeallantStatus eq 'Initiated' or appeallantStatus eq 'Evaluated' or appeallantStatus eq 'Completed'}">
	<div class="omsb-card omsb-card-graybg">
		<h4 class="omsb-card-title"><liferay-ui:message key="president-response" /></h4>
		<div class="row">
			<div class="col-md-12 label-box">
				<label class="label-name"><liferay-ui:message key="comments"></liferay-ui:message></label>
				<c:forEach var="status" items="${statusList}">
					<c:if test="${status.isPresident}">
						<label class="label-content">${status.message}</label>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</c:if> --%>

<c:if test="${appeallantStatus eq 'Evaluated' or appeallantStatus eq 'Completed'}">
	<div class="omsb-card omsb-card-graybg">
		<h4 class="omsb-card-title"><liferay-ui:message key="committee-response" /></h4>
		<div class="row">
			<div class="col-md-6 label-box">
				<label class="label-name"><liferay-ui:message key="old-level"></liferay-ui:message></label>
				<label class="label-content"><c:out	value="${level}" /></label>
			</div>
			<div class="col-md-6 label-box">
				<label class="label-name"><liferay-ui:message key="new-level"></liferay-ui:message></label>
				<c:forEach var="status" items="${statusList}">
					<c:if test="${!status.isAdmin }">
						<c:set var="committeLevel" value="${status.eqLevel}" />	
						<c:set var="committeLevelId" value="${status.eqLevelId}" />
						<label class="label-content"><c:out	value="${committeLevel}" /></label>
					</c:if> 
				</c:forEach>
				
			</div>
		</div>
	</div>
</c:if>	
	<%-- </c:if> --%>
		
<c:if test="${statusList.size() gt 0}">	
	<h4 class="omsb-card-title">
		<liferay-ui:message key="comments" />
		<c:if test="${hasVehpcCommitteeRole && !hasCommentAdded && appeallantStatus eq 'Initiated'}">
			<button class="btn omsb-bg-red-button" type="button" data-toggle="modal" data-target="#committeeCommentsModal" data-rowcount="saveComments">
				<img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" style="cursor: default;">    
				<liferay-ui:message key="add-comment" />
			</button>
		</c:if>
	</h4>
	<%-- <%@ include file="./committee-model-view.jsp"%> --%>
	
	<ul class="omsb-comments-list">
		<li>
			<div class="omsb-comment-box">
				<div class="omsb-comment-box-header">
					<h3 class="comment-title">
						<span class="comment-author-name">${statusList.get(0).fullName} 
						</span>${statusList.get(0).roleType}
					</h3>
					<span class="posted-date">${statusList.get(0).dateCreated}</span>
				</div>
				<div class="omsb-comment-body">
				<div class="row">
						<div class="col-md-12"><b><liferay-ui:message key="comments" /> </b>&nbsp;: ${statusList.get(0).message}</div>
				</div>
				<c:if test="${not empty statusList.get(0).documentList  }">
				<div class="row">
						<div class="col-md-12"><b><liferay-ui:message key="attachments" /> </b>&nbsp;: 
						<c:forEach items="${statusList.get(0).documentList }" var="docs">
								 <span><a href="${docs.documentUrl}" target="_blank">${docs.dFFileName }</a></span>
							
						</c:forEach>	
					</div>
				</div>
				</c:if>
				</div>
				
			</div>
			
			<br></br>
			<c:if test="${hasVehpcCAdminRole && appeallantStatus eq 'Initiated' }" >
					<h4 class="omsb-card-title">
						<liferay-ui:message key="additional-comments" />
							<button class="btn omsb-bg-red-button" type="button" data-toggle="modal"
							 data-target="#appealAdditionalCommentsModal" data-rowcount="saveComments">
								<liferay-ui:message key="add-additional-comment" />
							</button>
					</h4>
				</c:if>
				
			<c:if test="${statusList.size() gt 1}">
				<div class="colspan-child"><liferay-ui:message key="expand" /></div>
					<ul>
						<c:forEach var="status" items="${statusList}" varStatus="loop">
							<c:if test="${loop.index != 0}">
								<li>
									<div class="omsb-comment-box">
										<div class="omsb-comment-box-header">
											<h3 class="comment-title">
												<span class="comment-author-name">${status.fullName} </span> ${status.roleType}
											</h3>
											<span class="posted-date">${status.dateCreated}</span>
										</div>
										<div class="omsb-comment-body">
										<div class="row">
											<div class="col-md-12"><b><liferay-ui:message key="comments" /> </b>&nbsp;: ${status.message}</div>
										</div>
										<c:if test="${not empty status.documentList  }">
										<div class="row">
												<div class="col-md-12"><b><liferay-ui:message key="attachments" /> </b>&nbsp;: 
												<c:forEach items="${status.documentList }" var="docs">
														
														<span><a href="${docs.docsfileurl}" target="_blank">${docs.dFFileName }</a></span>
													
												</c:forEach>
											</div>
										</div>
										</c:if>	
										</div>
													
									</div>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</li>
	</ul>
</c:if>	
	<div class="omsb-card p-0">	
		<div class="row">
			<div class="col-md-12">
			<div class="bottom-backbtn-wrap">
				<%-- <c:if test ="${assignedToMe}" >
								<a href="${WorkflowAssignURL}" class="btn omsb-bc-red-button "><liferay-ui:message key="assign-to-me" /></a>
				</c:if> --%>
				<%-- <c:if test ="${!assignedToMe}" >  --%>
				
				
				<aui:input name="transitionName" type="hidden" value="resubmit"></aui:input>
				<aui:input type="hidden" name="supportingDocsAndType" id="supporting_docs_rowcount" value="" />
				<aui:input type="hidden" name="equivalencyRequestId" id="equivalencyRequestId" value="${equivalencyRequestId }" />
				<aui:input type="hidden" name="appealId" id="appealId" value="${appealId}" />
					<button type="button" onclick="saveSupportingDocument()" class="btn btn-default omsb-bc-red-button btn-sm tr-name-btn "  value=""><liferay-ui:message key="resubmit"></liferay-ui:message></button>
			
													
						<%-- <c:forEach var="tName" items="${transitionNames }">
						
										<c:if test="${tName ne 'complete'}">
													<portlet:actionURL var="completeWorkflowURL" name="/edit-appeal/workflow_action">
														<portlet:param name="equivalencyDecisionId" value="${decisionLevelId}" />
														<portlet:param name="assignedToMe" value="${assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="eqAppealId" value="${appealId}" />
													</portlet:actionURL>
													<c:if test="${ hasVehpcEmployerRole && (tName eq 'resubmit') }">
													 		
													 				<a href="#" class="btn omsb-bc-red-button custom-model" data-toggle="modal"
													 				 data-target="#popup-comments" data-tr-name=${tName }><liferay-ui:message key="${tName}" /></a>
													 			
													</c:if>
												</c:if>
												<a href="#" onclick="saveSupportingDocument()" class="btn omsb-bc-red-button custom-model" data-toggle="modal"
													 				 data-target="#popup-comments" data-tr-name=${tName }><liferay-ui:message key="${tName}" /></a>
												
												
			</c:forEach> --%>
		<%-- </c:if> --%>
				
		<a class="btn omsb-btn btn-back" href="<%=backURL%>"><i
			class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /> </a>
	</div>
	</div>
	</div>
	</div>
	</div>
</div>
</aui:form>
<style>
.omsb-tableview {
    text-align: left;!important
}
.custom-iframe {
  height: 400px; /* Adjust the height value as desired */
}

</style>
<!-- pop up for document view -->
<div class="modal fade" id="supporting-document" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog information-box" role="document">
		<div class="modal-content">
			<div class="modal-header d-none">
				<h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="supporting-document" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> 
					<span aria-hidden="true">&times;</span> 
				</button>
			</div>
			<div class="modal-body">
				<div class="omsb-label-view ">
					<div class="label-group-header row">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
						<div class="row">
							<div class="col-md-12 label-box">
								<iframe class="custom-iframe" id="documentFrame" src="${docsfileurl}" ></iframe>
								<label class="label-name"><liferay-ui:message key="supporting-document" /></label> 
								<label class="label-content"><a download href="${docsfileurl}" ><liferay-ui:message key="download-supporting-document" /></a></label>

							</div>
						</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="close" /></button>
			</div>
		</div>
	</div>
</div>

<!-- End of pop up for document view -->


<!-- work flow Popup -->

<div class="modal fade omsb-modal" id="popup-comments"
	tabindex="-1" role="dialog"
	aria-labelledby="markInsufficientModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="comments" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%-- <aui:form action="${completeWorkflowURL}" method="post" name="edit_Appeal" enctype="multipart/form-data">
				<aui:input name="transitionName" type="hidden" ></aui:input>
				<aui:input type="hidden" name="supportingDocsAndType" id="supporting_docs_rowcount" value="" />
				<aui:input type="hidden" name="equivalencyRequestId" id="equivalencyRequestId" value="${equivalencyRequestId }" />
				<aui:input type="hidden" name="appealId" id="appealId" value="${appealId}" />
				<p>${appealId}</p>			
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
						
						<textarea onkeyup="countChar(this)" class="pop-up-comments" required="required"
									name="<portlet:namespace />comments" rows="5" id="comments">
							</textarea>
						</div>						
						
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default omsb-bc-red-button btn-sm tr-name-btn "  value=""></button>
			      	<button type="button" class="btn btn-default omsb-bg-red-button" data-dismiss="modal" ><liferay-ui:message key="close"></liferay-ui:message> </button>
				</div>
			</aui:form> --%>
		</div>
	</div>
</div>
<!-- End of Workflow popup -->

<!--delete popup Starts -->
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
									<liferay-ui:message key="confirmation-text" />
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

<script>



$('.pop-up-comments').richText();
$('.modal-backdrop').removeClass('modal-backdrop'); 
$(".custom-model").on('click', function(){
	$('#<portlet:namespace/>comments').val('');
	console.log('clicking the model');
	var trName = $(this).attr('data-tr-name');
	console.log('trName :::'+trName);
	$('#<portlet:namespace/>transitionName').val(trName);
	console.log('data-tr-name', trName);
	if (trName == 'Decline') {
	    $('.tr-name-btn').html('Reject'); 
	} else if ((trName == 'Insufficient')) {
		$('.tr-name-btn').html('<liferay-ui:message key="reject"/>');
	}
	else{
		$('.tr-name-btn').html(trName);	
	}		
})	;
</script>

<portlet:resourceURL id="<%=AppealConstants.SAVE_COMMITTEE_COMMENTS%>" var="saveCommitteeCommentsURL" />	
<!--Modal -->
<script>
	$(document).ready(function(){
		$('.appeal-committee-comments').richText();
	});
	
	function validateAndSaveCommitteeComments() {
		  
		var error = false;
		var committeeComments = document.getElementById("committeeComments").value.trim();
		if (!committeeComments) {
			error = true;
		}
			
		if (error) {
			document.getElementById("errorContainer-committeeComments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
		}else{
			var classPK = document.getElementById("<portlet:namespace />appealId").value.trim();
			var statusId = document.getElementById("<portlet:namespace />statusId").value.trim();
			
			$.ajax({
				url: '${saveCommitteeCommentsURL}',
				async : false,
				data : {
					<portlet:namespace />comments : committeeComments,
					<portlet:namespace />classPK : classPK,
					<portlet:namespace />statusId : statusId
				},
				type : 'POST',
				success : function(data) {
					location.reload()
				}
			})
		}
	}
	
	var addPopUpRow = 0;

	function popUp(){
		$("#<portlet:namespace />type").val('');
		$("#<portlet:namespace />file").val('');
		document.getElementById('appeal-popup').style.display='block';
	}

	
	function setValues(){
		var A = AUI();
		var selectedValue = $( "#<portlet:namespace />type option:selected" ).val();
		var file = document.getElementById("<portlet:namespace/>file").files[0];
		var docTypeName = $( "#<portlet:namespace />type option:selected" ).text().trim();
		console.log('docTypeName ', docTypeName);
		console.log('selectedValue ', selectedValue);
		var isValid = validateFields(); // Call the validateFields() function

		  if (!isValid) {
		    return; // Exit the function if fields are not valid
		  }
	  
		var table1 = document.getElementById('dataTable1');
	  	addPopUpRow++;
	  	var rowCount1 = table1.rows.length;
	  	var row1 = table1.insertRow(rowCount1);
	  	document.getElementById('appeal-popup').style.display='none';
	  	
	  	var cell1 = row1.insertCell(0);
		var documentTypeElement = document.createElement("input");
		documentTypeElement.type = "text";
		documentTypeElement.value = docTypeName;
		documentTypeElement.readOnly = true;
		documentTypeElement.name = "docTypeName" + addPopUpRow;
		documentTypeElement.id = "docTypeName" + addPopUpRow;
		documentTypeElement.className="form-control";
		cell1.appendChild(documentTypeElement);
		
		var cell2 = row1.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "file";
		element2.name = "file" + addPopUpRow;
		element2.id = "file" + addPopUpRow;
		element2.readOnly = true;
		element2.className="form-control";
		var container = new DataTransfer();
		container.items.add(file);
		element2.files = container.files; 
		cell2.appendChild(element2);
		document.getElementById("<portlet:namespace />supporting_docs_rowcount").value = addPopUpRow;
		
		var actionCell = row1.insertCell(2);
	    var actionElement = document.createElement("button");
	    actionElement.className = "btn delete_btn ";
	    actionElement.value = "Delete";
	    actionElement.type="button"
	    var imageElement = document.createElement("img");
	    imageElement.src = '<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg';
	   
	    actionElement.setAttribute('data-toggle', 'modal');
	    actionElement.setAttribute('data-target', '#equivalency-delete');
	    actionElement.setAttribute('onClick', 'setData(this)');
	    
	    actionElement.appendChild(imageElement);
	    actionCell.appendChild(actionElement);
	    
	    var cell3 = row1.insertCell(3);
		var documentTypeNameElement = document.createElement("input");
		documentTypeNameElement.type = "hidden";
		documentTypeNameElement.value = selectedValue;
		documentTypeNameElement.readOnly = true;
		documentTypeNameElement.name = "option" + addPopUpRow;
		documentTypeNameElement.id = "option" + addPopUpRow;
		documentTypeNameElement.className="form-control";
		cell3.appendChild(documentTypeNameElement);
	    

	    $("#addmore-supporting-documents .custom-file-label.selected").html("");
	    $('#appeal-popup').modal('hide');
	   
	}
	
	function cancelpopUp(){
		$("#<portlet:namespace />type").val('');
		$("#<portlet:namespace />file").val('');
		$("#addmore-supporting-documents .custom-file-label.selected").html("");
		document.getElementById('appeal-popup').style.display='none';
//		console.log("cnl");
	}

	function saveSupportingDocument(){
	 	var appealData = {};
	 	var Appealformvalid=0;
		var appealSupportingDocuments = [];
		appealData.appealSupportingDocuments = appealSupportingDocuments;
		 for(i =1; i<= addPopUpRow;i++){
		 var optionDataIdx = "option"+i;
		 var supportingDocumentDataIdx = "file"+i;
		 var optionData = document.getElementById(optionDataIdx).value;
		 
		 var supportingDocument = 	document.getElementById(supportingDocumentDataIdx).files[0];
		 console.log("supportingDocument -------- " + supportingDocument);
		 var formData = new FormData();
		 formData.append('file',supportingDocument, supportingDocument.name);
		 console.log("formData -------- " + formData);
		 var fileData = {};
		 fileData.name = supportingDocument.name;
		 fileData.type = supportingDocument.type;
		 var supportingDocuments = {};
		 for (var pair of formData.entries()) {
			 supportingDocuments[pair[0]] = pair[1];
		    }
		 console.log("supportingDocuments -------- " + supportingDocuments);
		 console.log("supportingDocumentDataIdx -------- " + supportingDocumentDataIdx);
		 var supportingDocumentWithTittle = {  
		  "optionvalue":optionData,	 
		  "documentInputValue":supportingDocumentDataIdx,
		  "File": {
			  "data": supportingDocuments,
			  "name": fileData.name,
			  "type": fileData.type
			  
		  }
		}
		 console.log("supportingDocumentWithTittle -------- " + supportingDocumentWithTittle);
		 appealData.appealSupportingDocuments.push(supportingDocumentWithTittle);
			 }
		 $("#<portlet:namespace />supporting_docs_rowcount").val(JSON.stringify(appealData));
		
		 var rowcount=$('#dataTable1 tr').length;
		 console.log('Appealformvalid '+Appealformvalid);
		submitForm(document.<portlet:namespace />edit_Appeal);
	}
	
	function validateFields() {
		  var typeValue = $('#<portlet:namespace />type').val();
		  var attachmentValue = $('#<portlet:namespace />file').val();
		  var isValid = true;

		  // Validate type field
		  if (typeValue === '') {
		    $('#type').addClass('is-invalid');
		    $('.value').removeClass('d-none');
		    isValid = false;
		  } else {
		    $('#type').removeClass('is-invalid');
		    $('.value').addClass('d-none');
		  }

		  // Validate attachment field
		  if (attachmentValue === '') {
		    $('#file').addClass('is-invalid');
		    $('.file').removeClass('d-none');
		    isValid = false;
		  } else {
		    $('#file').removeClass('is-invalid');
		    $('.file').addClass('d-none');
		  }

		  return isValid;
		}
		
	function setData(link){
		var row = $(link).closest("tr");
		console.log("row value ",row);
		$("#equivalency-delete").data("row", row);
	}
	function deleteRow() {
		var row = $("#equivalency-delete").data("row");
		  row.remove();
		  addPopUpRow--;
		  var deleteModal = $("#equivalency-delete");
			deleteModal.modal('hide');
	}
</script>