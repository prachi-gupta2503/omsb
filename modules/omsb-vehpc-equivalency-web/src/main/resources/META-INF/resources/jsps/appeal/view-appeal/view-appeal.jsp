<%@ include file="../../init.jsp"%>
<c:set var="certificateName" value="${certificateName}" />
<c:set var="appealComments" value="${appealComments}" />
<c:set var="certificatefileurl" value="${certificatefileurl}" />
<c:set var="docFileurl" value="${docFileurl}" />
<c:set var="equivalencylevelkey" value="${equivalencylevelkey}" />

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<portlet:resourceURL id="<%=MVCCommandNames.ADD_MULTIPLE_FILES_TABLE_DATA_RESOURCE%>" var="addMultipleFilesURL">
</portlet:resourceURL>

<portlet:actionURL var="WorkflowAssignURL"
	name="/appeal/workflow_action">
	<portlet:param name="equivalencyDecisionLevelId"
		value="${decisionLevelId}" />
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${workflowInstanceId}" />
	<portlet:param name="<%=Constants.CMD%>"
		value="<%=AppealConstants.CMD_ASSIGN_TO_ME%>" />
	<portlet:param name="eqAppealId" value="${appealId}" />
</portlet:actionURL>

<div class="container" id="wrapper">
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle">
				<liferay-ui:message key="view-equivalency-appeal" />
			</div>
			<div class="information">
				<span class="${appealStatusColor}">${appealStatus}</span>
			</div>
		</div>

		<div class="omsb-card">
			<div class="omsb-card">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="request-details" />
				</h4>
				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="full-name" /></label> <label class="label-content">${personalDetail.givenNameAsPassport}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="nationality" /></label> <label class="label-content">${personNatinality}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="passport-number" /></label> <label class="label-content">${passportNumber}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="date-of-birth" /></label> <label class="label-content">${dateOfBirth}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message key="email" /></label>
						<label class="label-content">${personalDetail.email}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message key="mobile" /></label>
						<label class="label-content">${personalDetail.mobileNumber}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="profession" /></label> <label class="label-content">${personalDetail.profession}</label>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="equivalency-request-id" /></label> <label class="label-content">EQ-${equivalencyRequestId}</label>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="label-dfrn" /></label> <label class="label-content"></label>
					</div>
				</div>
			</div>
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
									<th><liferay-ui:message
											key="name-of-certificate-to-be-evaluated" /></th>
								</c:otherwise>
							</c:choose>
							<th><liferay-ui:message key="equivalency-level" /></th>
							<th><liferay-ui:message key="comments" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${certificatesList}" var="certificate">
							<tr class="odd">
								<td><c:if
										test="${not empty certificate.certificatefileurl }">
										<a href="${certificate.certificatefileurl}" target="_blank"><c:out
												value="${certificate.certificateName}" /></a>
									</c:if></td>
								<td><c:out
										value="${certificate.getEquivalencyLevel().getName()}" /></td>
								<td>${certificate.comments}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="omsb-card">
			<%-- <c:if test="${appeal}"> --%>
			<div class="omsb-card omsb-card-graybg">
				<div class="row">
					<div class="col-md-12 label-box">
						<label class="label-name"><span>${appeallantUserRole}</span>
							<liferay-ui:message key="comments" /></label> <label
							class="label-content">${appealComments}</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="supporting-documents"></liferay-ui:message></label>
					</div>
					<div class="col-md-12">
						<div class="form-group omsb-view-file">
							<c:forEach items="${docsList}" var="info">
								<c:set var="filename" value="${info.dFFileName}" />
								<c:set var="fileEntryID" value="${info.fileEntryID}" />
								<c:set var="docsfileurl" value="${info.docsfileurl}" />
								<label> <c:out value="${info.evaluateDocTypeName}" /> <span
									class=""> <a href="${docsfileurl }" target="_blank"
										class="btn btn-label view-download"> <liferay-ui:message
												key="view-file" />
									</a> <a href="${docsfileurl}" class="btn btn-label view-download"
										download> <liferay-ui:message key="download-file" />
									</a>
								</span>
								</label>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>

			<%-- <c:if test="${appeallantStatus eq 'Evaluated' or appeallantStatus eq 'Completed'}"> --%>
			<c:if test="${appeallantStatus eq 'Completed'}">
				<div class="omsb-card">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="appeal-details" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-tableview" width="100%">
							<thead>
								<tr>
									<th><liferay-ui:message key="certificate" /></th>
									<th><liferay-ui:message key="final-equivalency-level" /></th>
									<th><liferay-ui:message key="comments-by-admin" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${certificatesList}" var="appealDetails">
									<tr class="odd">
										<td>
											<c:if
												test="${not empty appealDetails.certificatefileurl }">
												<a href="${appealDetails.certificatefileurl}" target="_blank" view><c:out
														value="${appealDetails.certificateName}" /></a>
											</c:if>
										</td>
										<td><c:out value="${appealDetails.getAppealLevel().getName()}" /></td>
										<td>${appealDetails.appealComments}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			
		
			</c:if>

			<c:if test="${statusList.size() gt 0 && not hasVehpcEmployerRole}">
				<h4 class="omsb-card-title">
					<liferay-ui:message key="comments" />
					<c:if
						test="${hasVehpcCommitteeRole && appeallantStatus eq 'Initiated'}">
						<button class="btn omsb-bg-red-button" type="button"
							data-toggle="modal" data-target="#committeeCommentsModal"
							data-rowcount="saveComments">
							<img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg"
								style="cursor: default;">
							<liferay-ui:message key="add-comment" />
						</button>
					</c:if>
				</h4>

				<%@ include file="./committee-comments-model.jsp"%>

				<!-- Comment Section Starts -->
				<ul class="omsb-comments-list">
					<li>
						<!-- Recent Comment -->
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
									<c:if
										test="${not empty statusList.get(0).equivalencyCertificate}">
										<div class="col-md-6">
											<b><liferay-ui:message key="equivalency-certificate" />
											</b>&nbsp;: ${statusList.get(0).equivalencyCertificate}
										</div>
									</c:if>
									<c:if
										test="${not empty statusList.get(0).equivalencyLevelName}">
										<div class="col-md-6">
											<b><liferay-ui:message key="equivalency-level" /> </b>&nbsp;:
											${statusList.get(0).equivalencyLevelName}
										</div>
									</c:if>
									<c:if
										test="${not empty statusList.get(0).equivalencyLevelReasonName}">
										<div class="col-md-6">
											<b><liferay-ui:message key="equivalency-level-reason" />
											</b>&nbsp;: ${statusList.get(0).equivalencyLevelReasonName}
										</div>
									</c:if>
									<div class="col-md-6">
										<b><liferay-ui:message key="comments" /> </b>&nbsp;:
										${statusList.get(0).message}
									</div>
								</div>

								<c:if test="${not empty statusList.get(0).documentList  }">
									<div class="row">
										<div class="col-md-12">
											<b><liferay-ui:message key="attachments" /> </b>&nbsp;:
											<c:forEach items="${statusList.get(0).documentList }"
												var="docs">
												<div>
													<a href="${docs.documentUrl}" target="_blank">${docs.dFFileName }</a>
												</div>

											</c:forEach>
										</div>
									</div>
								</c:if>
							</div>
						</div> <!-- End Recent Comment --> <br></br> <!-- Add Additional Comment Button -->
						<c:if
							test="${hasVehpcCAdminRole && appeallantStatus eq 'Initiated' }">
							<h4 class="omsb-card-title">
								<liferay-ui:message key="additional-comments" />
								<button class="btn omsb-bg-red-button" type="button"
									data-toggle="modal" data-target="#additionalCommentsModal"
									data-rowcount="saveComments">
									<liferay-ui:message key="add-additional-comment" />
								</button>
							</h4>
							<%@ include file="./additional-comments.jsp"%>
						</c:if> <!-- Comment Section --> <c:if test="${statusList.size() gt 1}">
							<div class="colspan-child">
								<liferay-ui:message key="expand" />
							</div>
							<ul>
								<c:forEach var="status" items="${statusList}" varStatus="loop">
									<c:if test="${loop.index != 0}">
										<li>
											<div class="omsb-comment-box">
												<div class="omsb-comment-box-header">
													<h3 class="comment-title">
														<span class="comment-author-name">${status.fullName}
														</span> ${status.roleType}
													</h3>
													<span class="posted-date">${status.dateCreated}</span>
												</div>
												<div class="omsb-comment-body">
													<div class="row">
														<c:if test="${not empty status.equivalencyCertificate}">
															<div class="col-md-6">
																<b><liferay-ui:message key="equivalency-certificate" />
																</b>&nbsp;: ${status.equivalencyCertificate}
															</div>
														</c:if>
														<c:if test="${not empty status.equivalencyLevelName}">
															<div class="col-md-6">
																<b><liferay-ui:message key="equivalency-level" /> </b>&nbsp;:
																${status.equivalencyLevelName}
															</div>
														</c:if>
														<c:if
															test="${not empty status.equivalencyLevelReasonName}">
															<div class="col-md-6">
																<b><liferay-ui:message
																		key="equivalency-level-reason" /> </b>&nbsp;:
																${status.equivalencyLevelReasonName}
															</div>
														</c:if>

														<div class="col-md-6">
															<b><liferay-ui:message key="comments" /> </b>&nbsp;:
															${status.message}
														</div>
													</div>
													<c:if test="${not empty status.documentList  }">
														<div class="row">
															<div class="col-md-12">
																<b><liferay-ui:message key="attachments" /> </b>&nbsp;:
																<c:forEach items="${status.documentList }" var="docs">

																	<div>
																		<a href="${docs.docsfileurl}" target="_blank">${docs.dFFileName }</a>
																	</div>

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
						</c:if>
					</li>
				</ul>
			</c:if>
			<div class="omsb-card p-0">
				<div class="row">
					<div class="col-md-12">
						<div class="bottom-backbtn-wrap">
							<c:forEach var="tName" items="${transitionNames }">
								<c:if test="${tName ne 'complete'}">
									<portlet:actionURL var="completeWorkflowURL"
										name="/appeal/workflow_action">
										<portlet:param name="equivalencyDecisionId"
											value="${decisionLevelId}" />
										<portlet:param name="assignedToMe" value="${assignedToMe}" />
										<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
										<portlet:param name="workflowInstanceId"
											value="${workflowInstanceId}" />
										<portlet:param name="<%=Constants.CMD%>"
											value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW%>" />
										<portlet:param name="eqAppealId" value="${appealId}" />
										<portlet:param name="transitionName" value="${tName}" />
										<portlet:param name="equivalencyRequestId" value="${equivalencyRequestId}" />
										<portlet:param name="personId" value="${personId}" />
									</portlet:actionURL>
									<c:if
										test="${ hasVehpcCAdminRole && (tName eq 'initiate' || tName eq 'insufficient') }">
										<a href="#" class="btn omsb-bc-red-button custom-model"
											data-toggle="modal" data-target="#popup-comments"
											data-tr-name="${tName}"><liferay-ui:message
												key="${tName}" /></a>
									</c:if>
									<c:if
										test="${hasRapporteur && 
														(tName eq 'equate')}">
										<portlet:renderURL var="addAppealDecisionsRender">
											<portlet:param name="mvcRenderCommandName"
												value="<%=AppealConstants.ADD_APPEAL_DECISIONS_RENDER%>" />
											<portlet:param name="equivalencyDecisionLevelId"
												value="${decisionLevelId}" />
											<portlet:param name="assignedToMe" value="${assignedToMe}" />
											<portlet:param name="workflowTaskId"
												value="${workflowTaskId}" />
											<portlet:param name="workflowInstanceId"
												value="${workflowInstanceId}" />
											<portlet:param name="<%=Constants.CMD%>"
												value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW%>" />
											<portlet:param name="action" value="adminJSP" />
											<portlet:param name="transitionName" value="${tName}" />
											<portlet:param name="eqAppealId" value="${appealId}" />
											<portlet:param name="equivalencyRequestId" value="${equivalencyRequestId}" />
										</portlet:renderURL>
										<a href="${addAppealDecisionsRender }"
											class="btn omsb-bc-red-button custom-model"> ${tName}</a>
									</c:if>
								</c:if>

								<c:if test="${tName eq 'complete' && hasVehpcCAdminRole}">
									<portlet:renderURL var="addAppealDecisionsRender">
										<portlet:param name="mvcRenderCommandName"
											value="<%=AppealConstants.ADD_APPEAL_DECISIONS_RENDER%>" />
										<portlet:param name="equivalencyDecisionLevelId"
											value="${decisionLevelId}" />
										<portlet:param name="assignedToMe" value="${assignedToMe}" />
										<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
										<portlet:param name="workflowInstanceId"
											value="${workflowInstanceId}" />
										<portlet:param name="<%=Constants.CMD%>"
											value="<%=AppealConstants.CMD_COMPLETE_WORKFLOW%>" />
										<portlet:param name="action" value="adminJSP" />
										<portlet:param name="transitionName" value="${tName}" />
										<portlet:param name="eqAppealId" value="${appealId}" />
										<portlet:param name="equivalencyRequestId" value="${equivalencyRequestId}" />	
									</portlet:renderURL>
									<a href="${addAppealDecisionsRender }"
										class="btn omsb-bc-red-button custom-model"> ${tName}</a>
								</c:if>

							</c:forEach>

							<a class="btn omsb-btn btn-back" href="<%=backURL%>"><i
								class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<style>
.omsb-tableview {
	text-align: left !important;
}

.custom-iframe {
	height: 400px; /* Adjust the height value as desired */
}
</style>
	<!-- pop up for document view -->
	<div class="modal fade" id="supporting-document" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog information-box" role="document">
			<div class="modal-content">
				<div class="modal-header d-none">
					<h5 class="modal-title" id="exampleModalLabel">
						<liferay-ui:message key="supporting-document" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="omsb-label-view ">
						<div class="label-group-header row">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="row">
							<div class="col-md-12 label-box">
								<iframe class="custom-iframe" id="documentFrame"
									src="${docsfileurl}"></iframe>
								<label class="label-name"><liferay-ui:message
										key="supporting-document" /></label> <label class="label-content"><a
									download href="${docsfileurl}"><liferay-ui:message
											key="download-supporting-document" /></a></label>

							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">
						<liferay-ui:message key="close" />
					</button>
				</div>
			</div>
		</div>
	</div>

	<!-- End of pop up for document view -->


	<!-- work flow Popup -->

	<div class="modal fade omsb-modal" id="popup-comments" tabindex="-1"
		role="dialog" aria-labelledby="markInsufficientModalTitle"
		aria-hidden="true">
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
				<aui:form action="${completeWorkflowURL}"
					name="wf_form">
					<aui:input name="transitionName1" type="hidden" value="${tName}"></aui:input>

					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
								<textarea class="pop-up-comments"
									required="required" name="<portlet:namespace />comments" id="appealComments"
									rows="5" id="comments">
								</textarea>
							</div>
							<p id="errorContainer-appealText" class="error-container"></p>
							<div class="col-md-10">
								<div class="form-group">
									<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
									<div class="custom-file">
										<aui:input id="additionalAttachment" name="additionalAttachment" type="file" label=""
												cssClass="attachment form-control"  /> 
											<div class="d-none">
												<aui:input id="multiFile" name="adminAdditionalAttachment" type="file" label=""
												cssClass="attachment form-control"  />
											</div>	
											<label class="custom-file-label" for='<portlet:namespace />additionalAttachment'></label>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label></label>
									<!-- Adding empty for managing space -->
									<button type="button" class="omsb-bc-red-button add-files">
										<liferay-ui:message key="add" />
									</button>
								</div>
							</div>
							<div class="col-md-12 file-table d-none">
								<table class="display omsb-datatables"
									id="add-multiple-files-table">
									<thead>
										<tr>
											<th><liferay-ui:message key="file" /></th>
											<th><liferay-ui:message key="action" /></th>
										</tr>
									</thead>
									<tbody class="add-files-body">
									</tbody>
								</table>
							</div>

						</div>
					</div>
					<div class="modal-footer">
						<button type="button" onclick="ValidateAppeal()"
							class="btn btn-default omsb-bc-red-button btn-sm tr-name-btn "
							value=""></button>
						<button type="button" class="btn btn-default omsb-bg-red-button"
							data-dismiss="modal">
							<liferay-ui:message key="close"></liferay-ui:message>
						</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>

	<!-- End of Workflow popup -->

	<script>
	
		$('.add-files').on('click', function(){
			const additionalAttachmentId = '<portlet:namespace />additionalAttachment';
			const multiFileId = '<portlet:namespace />multiFile';
			const input = document.getElementById(multiFileId);
			const tableId = 'add-multiple-files-table';
			addMultiFiles(additionalAttachmentId,tableId ,input, multiFileId);
		});
		function ValidateAppeal(){
			var A = AUI();
			var appealText = A.one("#appealComments").val();
			
			var error = false;
			appealText=String(appealText).replaceAll('\t','');
			if (!appealText) {
				document.getElementById('errorContainer-appealText').textContent = "<liferay-ui:message key='please-enter-text-in-text-field' />";
				error = true;
			}else{
				document.getElementById('errorContainer-appealText').textContent = "";
			}
			if (!error) {
				 $('#<portlet:namespace />wf_form').submit();
				 closeModal();
			}
		}
		function closeModal() {
			$("#popup-comments").modal("hide");
		}

		$('.pop-up-comments').richText();
		$('.modal-backdrop').removeClass('modal-backdrop');
		$(".custom-model").on('click', function() {
			$('#<portlet:namespace/>comments').val('');
			console.log('clicking the model');
			var trName = $(this).attr('data-tr-name');
			console.log('trName :::' + trName);
			$('#<portlet:namespace/>transitionName1').val(trName);
			console.log('data-tr-name', trName);
			if (trName == 'Decline') {
				$('.tr-name-btn').html('Reject');
			} else if ((trName == 'Insufficient')) {
				$('.tr-name-btn').html('<liferay-ui:message key="reject"/>');
			} else {
				$('.tr-name-btn').html(trName);
			}
		});
	</script>

	<portlet:resourceURL id="<%=AppealConstants.SAVE_COMMITTEE_COMMENTS%>"
		var="saveCommitteeCommentsURL" />
	<!--Modal -->
	<div class="modal fade omsb-modal" id="committeeCommentsModal"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered w-50" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message key="add-comments" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<aui:form name="asccFM" onSubmit="event.preventDefault();">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group  mb-0">
									<aui:input type="hidden" name="appealId" id="appealId"
										value="${appealId}" />
									<aui:input type="hidden" name="statusId" id="statusId"
										value="${appealStatusId}" />
									<textarea onkeyup="countChar(this)"
										class="comments appeal-committee-comments" required="required"
										name="<portlet:namespace />committeeComments" rows="5"
										id="committeeComments">
								</textarea>
								</div>
								<p id="errorContainer-committeeComments" class="error-container"></p>
							</div>
							<div class="modal-footer">
								<button class="btn omsb-bc-red-button" title="save-comments"
									onclick="validateAndSaveCommitteeComments()">
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
	
	<%@include file ="../../add-multiple-files-delete-popup.jsp" %>
	<!--Modal -->
	<script>
		$(document).ready(function() {
			$('.appeal-committee-comments').richText();
		});
		
		function addMultiFiles(selectedFileId, tableId, finalFile, finalFileId){
			$('.file-table').removeClass('d-none');
			console.log('clicking this');
			var selectedFile = $('#'+ selectedFileId).prop('files')[0];
			var rowCount = $('#'+tableId+' tbody tr').length;
			$.ajax({
		        url: '<%=addMultipleFilesURL.toString()%>',
		        async : false,
		        data : {
					<portlet:namespace />fileName : selectedFile.name,
					<portlet:namespace />index : rowCount,
					<portlet:namespace />tableId : tableId,
					<portlet:namespace />finalFileId : finalFileId
		        },
		        type : 'POST',
		        success : function(data) {
		        	$('#' + tableId + ' tbody').append(data);
		        	$('#'+selectedFileId).val(''); 
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

		function validateAndSaveCommitteeComments() {

			var error = false;
			var committeeComments = document
					.getElementById("committeeComments").value.trim();
			if (!committeeComments) {
				error = true;
			}

			if (error) {
				document.getElementById("errorContainer-committeeComments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
			} else {
				var classPK = document
						.getElementById("<portlet:namespace />appealId").value
						.trim();
				var statusId = document
						.getElementById("<portlet:namespace />statusId").value
						.trim();

				$.ajax({
					url : '${saveCommitteeCommentsURL}',
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