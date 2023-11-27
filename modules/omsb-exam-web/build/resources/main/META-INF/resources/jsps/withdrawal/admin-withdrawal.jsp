<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file = "../../init.jsp" %>

<portlet:renderURL var="viewWithdrawListURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommands.VIEW_WITHDRAW_LIST%>" />
</portlet:renderURL>

<portlet:renderURL var="trianeeview">
	<portlet:param name="mvcRenderCommandName"
		value="/" />
</portlet:renderURL>

<portlet:actionURL var="WorkflowAssignURL" name="/exam/workflow_action">
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${instanceId}" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
	<portlet:param name="withdrawalId" value="${withdrawalId}" />
</portlet:actionURL>
<portlet:actionURL var="traineeWithdrawalURL" name="/exam/withdrawal_form"></portlet:actionURL>
<form action="${traineeWithdrawalURL }" method="post" name="admin_withdrawal_fm">
	<input type="hidden" value="${withdrawalId}" name="<portlet:namespace/>withdrawalId">
	<input type="hidden" value="${assignedToMe}" name="<portlet:namespace/>assignedToMe">
	<input type="hidden" value="${instanceId}" name="<portlet:namespace/>instanceId">
	<input type="hidden" value="${workflowTaskId}" name="<portlet:namespace/>workflowTaskId">
	<input type="hidden" value="" name="<portlet:namespace/>trName" id="<portlet:namespace/>trName">
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson" class="d-none">
	<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							<div class="pagetitle">
							<c:choose>
								<c:when test="${!isAdmin}"> 
									<liferay-ui:message key="withdrawal-request" />
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="admin-withdrawal-form"/>
								</c:otherwise>
							</c:choose>	
							</div>							
						</div>
						<div class="row">
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="user-name" /></label> <span
										class="value">${withdrawalStatusList[0].name}</span>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="program-name" /></label> <span
										class="value">${programName }</span>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="exam-type" /></label> <span
										class="value">${examType }</span>
								</div>
							</div>
						</div>
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
										<label class="required"><liferay-ui:message key="reason-for-withdrawal"/> (${withdrawalStatus.name})<span></span></label>
										<textarea class="form-control ${editorClass} richtext" name="example" readonly>${withdrawalStatus.reason}</textarea>
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
										<label class="required"><liferay-ui:message key="reason"/> (<liferay-ui:message key="admin"/>)<span></span></label>
										<textarea class="form-control ${editorClass} richtext" name="example" readonly>${withdrawalStatus.reason}</textarea>
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
													<td>
													<a class="btn upload_btn" target="_blank" title="download" href="${document.fileURL }"> &nbsp;<span><liferay-ui:message key="download"/></span></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>	
							
							
				</c:forEach>
						<div class="row">
							<c:if test="${isAdmin && not empty trNames}">
								<div class="col-md-12">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="reason"/> (<liferay-ui:message key="admin"/>)</label>
										<textarea class="textEditor2" name="<portlet:namespace/>comments" id="comment"></textarea>
									</div>
									<p id="errorContainer-comment" class="error-container"></p>
								</div>
							</c:if>
						</div>
						<c:if test="${isAdmin && not empty trNames}">
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="supporting-document"/>
									<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
										<img src="../images/svg/plus_img.svg" alt="">
										<liferay-ui:message key="upload-document"/>
									</button>
								</h4>
								<div class="omsb-list-view ">
									<table class="omsb-datatables dataTable" id="supporting-documents-table">
									<thead>
										<tr>
											<th data-name="docTitle"><liferay-ui:message key="document-title"/></th>
											<th data-name="fileName"><liferay-ui:message key="attachment"/></th>
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
							<%-- <c:if test="${not empty trNames}">
								<a href="${WorkflowAssignURL} " ><button class="btn omsb-bc-red-button" ><liferay-ui:message key="assign-to-me" /></button></a>
							</c:if> --%>
							
							<c:if test="${isAdmin && not empty trNames}">
								<button class="omsb-bc-red-button" title="Accept" onclick="saveSupportingDocs('Accept');"  data-tr="Accept"><liferay-ui:message key="accept"/></button>
								<button class="omsb-bg-red-button" title="Reject" onclick="saveSupportingDocs('Reject');"  data-tr="Reject"><liferay-ui:message key="reject"/></button>
                           		<button class="omsb-bg-red-button" title="Return" onclick="saveSupportingDocs('Return');"  data-tr="Return"><liferay-ui:message key="return"/></button>
                       
                            </c:if>
					      
					    
					      <c:if test="${isAdmin}"> 
							<a class="omsb-btn btn-back" href="${viewWithdrawListURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</c:if>
						 <c:if test="${!isAdmin}"> 
							<a class="omsb-btn btn-back" href="${trianeeview}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</c:if> 
						 
						</div>

					</div>
				</div>
			</div>

	 <%@include file ="/jsps/supporting-docs-popup.jsp" %> 
</form>	

<script>

</script>	