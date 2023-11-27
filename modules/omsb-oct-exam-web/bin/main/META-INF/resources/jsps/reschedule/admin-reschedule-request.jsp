<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file = "../../init.jsp" %>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_APPLICANT_REQUESTS%>"/>
</portlet:renderURL>

<portlet:actionURL var="WorkflowAssignURL" name="oct/exam/workflow_action">
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${instanceId}" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
	<portlet:param name="rescheduleId" value="${id}" />
</portlet:actionURL>
<portlet:actionURL var="applicantRescheduleURL" name="<%=MVCCommandNames.SAVE_RESCHEDULE_REQUEST_ACTION%>"></portlet:actionURL>
<form action="${applicantRescheduleURL}" method="post" name="admin_reschedule_fm">
	<input type="hidden" value="${id}" name="<portlet:namespace/>rescheduleId">
	<input type="hidden" value="${assignedToMe}" name="<portlet:namespace/>assignedToMe">
	<input type="hidden" value="${instanceId}" name="<portlet:namespace/>instanceId">
	<input type="hidden" value="${workflowTaskId}" name="<portlet:namespace/>workflowTaskId">
	<input type="hidden" value="" name="<portlet:namespace/>trName" id="<portlet:namespace/>trName">
	<input type="hidden" value="${examDefinitionId }" name="<portlet:namespace/>examDefinitionId">
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson" class="d-none">
	<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							<div class="pagetitle"><liferay-ui:message key="admin-rescheduling-form"/></div>							
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<h3><label>${examTitle }</label></h3> 
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6">
									<div class="form-group-view">
										<div class="label-name"><liferay-ui:message key="old-exam-date"/></div>
										<div class="label-content">01-01-2023</div>
									</div>
							</div>
							<div class="col-lg-6 col-md-6">
									<div class="form-group-view">
										<div class="label-name"><liferay-ui:message key="new-exam-date"/></div>
										<div class="label-content">01-01-2023</div>
									</div>
							</div>
						</div>
							 <script>
								var tt_cnt= 0;
								</script>
						<c:forEach var="status" items="${statusList}" varStatus="counter">
							<c:set value="textEditors${counter.index}" var="editorClass"></c:set>
							<div class="d-none classHolderId" >${editorClass}</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label><liferay-ui:message key="reason-for-reschedule"/> (${status.name})<span></span></label>
										<textarea class="form-control textEditors ${editorClass}" data-rich-class="${editorClass}" name="example" readonly="">${status.reason}</textarea>
									</div>
								</div>
							</div>
							 <script>
								console.log('tt_cnt ??', tt_cnt);
								$('.textEditors'+tt_cnt).richText({preview: true, height: 200});
								tt_cnt++;
							</script> 
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="document-uploaded-by"/> (${status.name})</h4>
								<div class="omsb-list-view table-responsive">
									<table class="display omsb-datatables" id="other-documentss-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="document-title"/></th>
												<th><liferay-ui:message key="supporting-document"/></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="document" items="${status.examDocuments}">
												<tr>
													<td>${document.docTitle }</td>
													<td><a class="btn upload_btn" title="download" href="${document.fileURL }">
													 <img src="../images/svg/download_icon.svg" alt=""/>${document.fileName }</a>
													<a class="btn upload_btn" target="_blank" title="download" href="${document.fileURL }"> &nbsp;<span><liferay-ui:message key="view"/></span></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:forEach>
						<div class="row">
							<c:if test="${!assignedToMe && not empty trNames}">
								<div class="col-md-12">
									<div class="form-group">
										<label><liferay-ui:message key="reason"/> (<liferay-ui:message key="admin"/>)<span>*</span></label>
										<textarea class="textEditor2" name="<portlet:namespace/>comments"></textarea>
									</div>
								</div>
							</c:if>
						</div>
						<c:if test="${!assignedToMe && not empty trNames}">
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="supporting-document"/>
									<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
										<img src="../images/svg/plus_img.svg" alt="">
										<liferay-ui:message key="add-document"/>
									</button>
								</h4>
								<div class="omsb-list-view table-responsive">
									<table class="omsb-datatables dataTable supporting-docs-add-row" id="supporting-documents-table">
									<thead>
										<tr>
											<th data-name="docTitle"><liferay-ui:message key="document-title"/></th>
											<th data-name="fileName"><liferay-ui:message key="supporting-document"/></th>
											<th data-name="file" class="d-none"><liferay-ui:message key="document-file"/></th>
											<th data-name="rowNumber" class="d-none"><liferay-ui:message key="row-number"/></th>
											<th data-name="actions"><liferay-ui:message key="action"/></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
									</table>
								</div>
							</div>
						</c:if>	
						<div class="bottom-backbtn-wrap">
							<c:if test="${assignedToMe}">
								<a href="${WorkflowAssignURL} " ><button class="btn omsb-bc-red-button" ><liferay-ui:message key="assign-to-me" /></button></a>
							</c:if>
							<c:if test="${!assignedToMe && not empty trNames}">
								<button class="btn omsb-bc-red-button" title="Accept" onclick="saveSupportingDocs(this);"  data-tr="Accept"><liferay-ui:message key="accept"/></button>
								<button class="btn omsb-bg-red-button" title="Reject" onclick="saveSupportingDocs(this);updateTrName(this);"  data-tr="Reject"><liferay-ui:message key="reject"/></button>
							</c:if>
							
							<a class="btn omsb-btn btn-back" href="${backURL }"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</div>

					</div>
				</div>
			</div>
<%@include file ="/jsps/supporting-docs-popup.jsp" %>
</form>	
<script>
function updateTrName(event) {
	 console.log('updateTrName namespace ??' , namespace);
	 console.log('updateTrName data attr tr above ?? ', $(event).attr('data-tr'));
	 var trName = $(event).attr('data-tr');
	 console.log('updateTrName data attr tr ?? ', trName);
	 $("#<portlet:namespace/>trName").val(trName);
}
</script>