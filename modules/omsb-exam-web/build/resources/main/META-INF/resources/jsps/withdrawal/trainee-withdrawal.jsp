<%@include file="../../init.jsp"%>
<portlet:actionURL var="traineeWithdrawalURL"
	name="/exam/withdrawal_form"></portlet:actionURL>
	
	

<portlet:renderURL var="trianeeview">
	<portlet:param name="mvcRenderCommandName"
		value="/" />
</portlet:renderURL>	
<form action="${traineeWithdrawalURL }" method="post" name="appeal_fm">
	<input type="hidden" value="${examDefinitionId }"
		name="<portlet:namespace/>examDefinitionId"> <input
		type="hidden" name="<portlet:namespace/>supportingDocJson"
		id="<portlet:namespace/>supportingDocJson" class="d-none">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
					<div class="pagetitle">
						<liferay-ui:message key="withdrawal-request" />
					</div>
				</div>
				<input type="hidden" id="<portlet:namespace/>examScheduleId" name="<portlet:namespace/>examScheduleId" value="${examScheduleId}">
				<input type="hidden" id="<portlet:namespace/>programName" name="<portlet:namespace/>programName" value="${programName}">
				<input type="hidden" id="<portlet:namespace/>examType" name="<portlet:namespace/>examType" value="${examType}">
			<%--  <c:if test="${not empty examWithdrawal}">
				<input type="hidden" value="${examWithdrawal.withdrawalId}" name="<portlet:namespace/>withdrawalId">
				<input type="hidden" value="${examWithdrawal.assignedToMe}" name="<portlet:namespace/>assignedToMe">
				<input type="hidden" value="${examWithdrawal.instanceId}" name="<portlet:namespace/>instanceId">
				<input type="hidden" value="${examWithdrawal.workflowTaskId}" name="<portlet:namespace/>workflowTaskId">
			</c:if> --%>
			<!-- show all comments and doc -->
			
							<script>
							var tt_cnt= 0;
						</script>
						<c:forEach var="withdrawalStatus" items="${withdrawalStatusList}" varStatus="counter">
							<c:set value="textEditors${counter.index}" var="editorClass"></c:set>
							<div class="d-none" id="classHolderId">${editorClass}</div>
						
						<c:if test="${!withdrawalStatus.isAdmin}">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="reason-for-withdrawal"/> (${withdrawalStatus.name})</label>
										<textarea class="form-control ${editorClass} richtext"  readonly>${withdrawalStatus.reason}</textarea>
									</div>
								</div>
							</div>
						
							  <script>
								console.log('tt_cnt ??', tt_cnt);
								$('.textEditors'+tt_cnt).richText({preview: true, height: 200});
								tt_cnt++;
							</script> 
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="document-uploaded-by"/> (${withdrawalStatus.name})</h4>
								<div class="omsb-list-view ">
									<table class="display omsb-datatables" id="other-documentss-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="document-title"/></th>
												<th><liferay-ui:message key="attachment"/></th>
												<th><liferay-ui:message key="action"/></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="document" items="${withdrawalStatus.examDocuments}">
												<tr>
													<td>${document.documentTitle }</td>
													<td><a class="btn upload_btn" title="download" href="${document.fileURL }">
													 <img src="../images/svg/download_icon.svg" alt=""/>${document.fileName }</a></td>
													<td><a class="btn upload_btn" target="_blank" title="download" href="${document.fileURL }"> &nbsp;<span><liferay-ui:message key="download"/></span></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					<c:if test="${withdrawalStatus.isAdmin}">	
						<div class="row">
							
								<div class="col-md-12">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="reason"/> (<liferay-ui:message key="admin"/>)</label>
										<textarea class="form-control ${editorClass} richtext"  readonly>${withdrawalStatus.reason}</textarea>
								</div>
								</div>
							
						</div>
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="document-uploaded-by"/> (${withdrawalStatus.name})</h4>
								<div class="omsb-list-view ">
									<table class="display omsb-datatables" id="other-documentss-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="document-title"/></th>
												<th><liferay-ui:message key="attachment"/></th>
												<th><liferay-ui:message key="action"/></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="document" items="${withdrawalStatus.examDocuments}">
												<tr>
													<td>${document.documentTitle }</td>
													<td><a class="btn upload_btn" title="download" href="${document.fileURL }">
													 <img src="../images/svg/download_icon.svg" alt=""/>${document.fileName }</a></td>
													<td><a class="btn upload_btn" target="_blank" title="download" href="${document.fileURL }"> &nbsp;<span><liferay-ui:message key="download"/></span></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>	
							
							
				</c:forEach>
			
			<!-- end -->
				<input type="hidden" value="" name="<portlet:namespace/>trName" id="<portlet:namespace/>trName">
				
			
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="reason" /></label>
							<textarea class="textEditor1" name="<portlet:namespace/>comments" id="comment"></textarea>
						</div>
					</div>
					<p id="errorContainer-comment" class="error-container"></p>
				</div>
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius other-documents-wrap">
					
					
				   <h4 class="omsb-card-title">
						<liferay-ui:message key="add-supporting-document" />
						<button class="btn omsb-bg-red-button" data-toggle="modal"
							data-target="#addsupportingdocument" type="button">
							<img src="../images/svg/plus_img.svg" alt="">
							<liferay-ui:message key="upload-document" />
						</button>
					</h4> 
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables"
							id="supporting-documents-table">
							<thead>
								<tr>
									<th data-name="docTitle"><liferay-ui:message
											key="document-title" /></th>
									<th data-name="fileName"><liferay-ui:message
											key="attachment" /></th>
									<th data-name="file" class="d-none"><liferay-ui:message
											key="document-file" /></th>
											<th data-name="rowNumber" class="d-none"><liferay-ui:message key="row-number"/></th>
									<th data-name="actions"><liferay-ui:message key="action" /></th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
				</div>
				
				<div class="bottom-backbtn-wrap">
				
				<c:choose>
				<c:when test="${fn:containsIgnoreCase(transitionName, OMSBExamWebPortletKeys.TRANSITION_NAME_RESUBMIT) }">
					<button class="btn omsb-bc-red-button" title="Save" onclick="saveSupportingDocs('Resubmit');">
						<liferay-ui:message key="save" />
					</button>
				</c:when>	
				<c:otherwise>
					<button class="btn omsb-bc-red-button" title="Save" onclick="saveSupportingDocs('');">
							<liferay-ui:message key="save" />
					</button>
				</c:otherwise>
				</c:choose>
				
					<button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#trainee-withdrawal-discard" type="button" title="Discard"><liferay-ui:message key="discard" /></button>
					<a class="omsb-btn btn-back" href="${trianeeview}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
				
				</div>

			</div>
		</div>
	</div>
	 <%@include file ="/jsps/supporting-docs-popup.jsp" %> 
</form>


<div class="modal fade omsb-modal" id="trainee-withdrawal-discard" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="discard-confirmation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div>
						<liferay-ui:message key="confirmation-text" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" onclick="discardChanges()" type="button" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>




<script>
function discardChanges(){
	
	 location.reload(true);
}

</script>
