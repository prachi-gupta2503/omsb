<%@ include file="../../init.jsp"%>
<c:set var="certificateName" value="${certificateName}" />
<c:set var="appealComments" value="${appealComments}" />
<c:set var="certificatefileurl" value="${certificatefileurl}" />
<c:set var="docFileurl" value="${docFileurl}" />
<c:set var="equivalencylevelkey" value="${equivalencylevelkey}" />

<!-- Since both are Written in Appeal Default RenderCommand one url Is Working fro both conditiom -->
<portlet:renderURL var="backURL">
	<c:if test="${(hasEmployeeRole) || (hasEmployerRole)}">
		<portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.EMPLOYEE_EMPLOYER_LIST%>"/>
	</c:if>	
</portlet:renderURL>

<portlet:actionURL var="WorkflowAssignURL" name="/appeal/workflow_action">
		<portlet:param name="equivalencyDecisionLevelId" value="${decisionLevelId}" />
		<portlet:param name="assignedToMe" value="${assignedToMe}" />
		<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
		<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
		<portlet:param name="<%=Constants.CMD %>" value="<%=AppealConstants.CMD_ASSIGN_TO_ME %>" />
		<portlet:param name="eqAppealId" value="${appealId}" />
</portlet:actionURL>



<div class="container" id="wrapper"> 
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle"><liferay-ui:message key="view-equivalency-appeal" /></div>
			<div class="information"><span class="${appealStatusColur.get(appeallantStatus)}">${appeallantStatus}</span></div>
		</div>
		
		<div class="omsb-card">
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
					<tr class="odd">
						<td>
							<c:if test="${not empty certificatefileurl }">
								<a href="${certificatefileurl}"  view ><c:out value="${certificateName}" /></a>
							</c:if>
						</td>
						<td><c:out value="${equivalencylevelkey}" /></td>
						<td>${comments}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="omsb-card">
		<c:if test="${appeal}">
			<div class="omsb-card omsb-card-graybg">
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
						<%-- <button class="btn btn-label view-download" data-toggle="modal" data-edd="${supportingDoc}" 
						data-State="${docsfileurl}" data-target="#supporting-document"> <liferay-ui:message key="view-file" /></button> --%>
					<a href="${docsfileurl}" class="btn btn-label view-download" download><liferay-ui:message key="download-file" /></a></span></label></a>
					</c:forEach>
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
					<c:if test="${status.iscommitte }">
						<c:set var="committeLevel" value="${status.eqLevel}" />	
						<c:set var="committeLevelId" value="${status.eqLevelId}" />	
					</c:if>
				</c:forEach>
				<label class="label-content"><c:out	value="${committeLevel}" /></label>
			</div>
		</div>
	</div>
</c:if>	
	</c:if>
		
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
					<p>${statusList.get(0).message}</p>
				</div>
			</div>
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
											<p>${status.message}</p>
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
				<c:if test ="${assignedToMe}" >
								<a href="${WorkflowAssignURL}" class="btn omsb-bc-red-button "><liferay-ui:message key="assign-to-me" /></a>
				</c:if>
				<c:if test ="${!assignedToMe}" > 
						<c:forEach var="tName" items="${transitionNames }">
										<c:if test="${tName ne 'complete'}">
													<portlet:actionURL var="completeWorkflowURL" name="/appeal/workflow_action">
														<portlet:param name="equivalencyDecisionId" value="${decisionLevelId}" />
														<portlet:param name="assignedToMe" value="${assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="eqAppealId" value="${appealId}" />
													</portlet:actionURL>
													<c:if test="${ hasVehpcCAdminRole && (tName eq 'Raise' || tName eq 'Insufficient')
													 and appealStatusKey ne 'rejected' and appealStatusKey ne 'initiated' and appealStatusKey ne 'raised' 
													 and appealStatusKey eq 'created' and appealStatusKey ne 'completed' and appealStatusKey ne 'evaluated' }">
													 		<c:choose>
													 			<c:when test="${tName eq 'Insufficient' }">
													 				<%-- <a href="#" class="btn omsb-bc-red-button custom-model" data-toggle="modal"
													 				 data-target="#popup-comments" data-tr-name=${tName }><liferay-ui:message key="reject" /></a> --%>
													 			</c:when>
													 			<c:otherwise>
													 				<a href="#" class="btn omsb-bc-red-button custom-model" data-toggle="modal"
													 				 data-target="#popup-comments" data-tr-name=${tName }><liferay-ui:message key="${tName}" /></a>
													 			</c:otherwise>
													 		</c:choose>
													</c:if>
													<c:if  test="${hasExecutePresidentRole && 
														(tName eq 'Initiate' || tName eq 'Reject')and appealStatusKey ne 'rejected'
														 and  appealStatusKey ne 'initiated' and appealStatusKey eq 'raised' and appealStatusKey ne 'created'
														  and appealStatusKey ne 'completed' and appealStatusKey ne 'evaluated'}">
															<a href="#" class="btn omsb-bc-red-button custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName }>${tName}</a>
													</c:if>
												</c:if>
												<c:if  test="${hasVehpcCommitteeRole && (tName eq 'Decline' && tName ne 'complete') 
														and appealStatusKey ne 'rejected' and  appealStatusKey eq 'initiated' and appealStatusKey ne 'raised' 
														and appealStatusKey ne 'created' and appealStatusKey ne 'completed' and appealStatusKey ne 'evaluated' }">
															<a href="#" class="btn omsb-bc-red-button custom-model" data-toggle="modal" data-target="#popup-comments" data-tr-name=${tName }><liferay-ui:message key="reject" /></a>
													</c:if>
												
												<c:if test="${ hasVehpcCommitteeRole && (tName ne 'complete' && tName ne 'Decline') and appealStatusKey ne 'rejected' 
														and  appealStatusKey eq 'initiated' and appealStatusKey ne 'raised' and appealStatusKey ne 'created' 
														and appealStatusKey ne 'completed' and appealStatusKey ne 'evaluated'}">
													<portlet:renderURL var="editAdminResponseURL" >
														<portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.EDIT_APPEAL %>" />
										 				<portlet:param name="equivalencyDecisionLevelId" value="${decisionLevelId}" />
														<portlet:param name="assignedToMe" value="${assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="action" value="adminJSP" />
														<portlet:param name="transitionName" value="${tName}" />
														<portlet:param name="eqAppealId" value="${appealId}" />
													</portlet:renderURL>
														<a href="${editAdminResponseURL }" class="btn omsb-bc-red-button custom-model" > ${tName}</a>
												</c:if>
												<c:if test="${tName eq 'complete' && hasVehpcCAdminRole and appealStatusKey eq 'evaluated' and appealStatusKey ne 'rejected'
													 and  appealStatusKey ne 'initiated' and appealStatusKey ne 'raised' and appealStatusKey ne 'created' 
													 and appealStatusKey ne 'completed'}">
													<portlet:renderURL var="editAdminResponseURL" >
														<portlet:param name="mvcRenderCommandName" value="<%=AppealConstants.EDIT_APPEAL %>" />
														<portlet:param name="equivalencyDecisionLevelId" value="${decisionLevelId}" />
														<portlet:param name="assignedToMe" value="${assignedToMe}" />
														<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
														<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
														<portlet:param name="<%= Constants.CMD %>" value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW %>" />
														<portlet:param name="action" value="adminJSP" />
														<portlet:param name="transitionName" value="${tName}" />
														<portlet:param name="eqAppealId" value="${appealId}" />
													</portlet:renderURL>
														<a href="${editAdminResponseURL }" class="btn omsb-bc-red-button custom-model" > ${tName}</a>
												</c:if>
			</c:forEach>
		</c:if>
		<a class="btn omsb-btn btn-back" href="<%=backURL%>"><i
			class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /> </a>
	</div>
	</div>
	</div>
	</div>
	</div>
</div>

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
			<aui:form action="${completeWorkflowURL}" method="post" name="wf_form">
				<aui:input name="transitionName" type="hidden" ></aui:input>
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
			</aui:form>
		</div>
	</div>
</div>

<!-- End of Workflow popup -->

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
<div class="modal fade omsb-modal" id="committeeCommentsModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-comments" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<aui:form name="asccFM" onSubmit="event.preventDefault();">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group  mb-0">
								<aui:input type="hidden" name="appealId" id="appealId" value="${appealId}" />
								<aui:input type="hidden" name="statusId" id="statusId" value="${appealStatusId}" />
								<textarea onkeyup="countChar(this)" class="comments appeal-committee-comments" required="required"
                                  		name="<portlet:namespace />committeeComments" rows="5" id="committeeComments">
								</textarea>
							</div>
							<p id="errorContainer-committeeComments" class="error-container"></p>
						</div>
						<div class="modal-footer">
							<button class="btn omsb-bc-red-button"  title="save-comments" onclick="validateAndSaveCommitteeComments()">
								<liferay-ui:message key="save" />
							</button>
							<button type="button" class="btn omsb-btn omsb-bg-red-button"
								data-dismiss="modal">
								<liferay-ui:message key="cancel" />
							</button>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
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
</script>