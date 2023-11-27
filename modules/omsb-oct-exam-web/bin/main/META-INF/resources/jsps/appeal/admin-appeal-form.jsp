<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file = "../../init.jsp" %>
<portlet:actionURL var="WorkflowAssignURL" name="<%=MVCCommandNames.OCT_EXAM_WORKFLOW%>">
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${instanceId}" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=CommonConstants.CMD_ASSIGN_TO_ME %>" />
	<portlet:param name="appealId" value="${appealId}" />
</portlet:actionURL>
<portlet:renderURL var="viewApplicantRequests">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_APPLICANT_REQUESTS%>" />
	<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
</portlet:renderURL>
<portlet:actionURL var="traineeAppealURL" name="<%=MVCCommandNames.OCT_EXAM_APPEAL_FORM%>"></portlet:actionURL>
<form action="${traineeAppealURL }" method="post" name="admin_appeal_fm">
	<input type="hidden" value="${appealId}" name="<portlet:namespace/>appealId">
	<input type="hidden" value="${assignedToMe}" name="<portlet:namespace/>assignedToMe">
	<input type="hidden" value="${instanceId}" name="<portlet:namespace/>instanceId">
	<input type="hidden" value="${workflowTaskId}" name="<portlet:namespace/>workflowTaskId">
	<input type="hidden" value="${examResult.id}" name="<portlet:namespace/>examResultId">
	<input type="hidden" value="" name="<portlet:namespace/>trName" id="<portlet:namespace/>trName">
	<input type="hidden" name="<portlet:namespace/>supportingDocJson" id="<portlet:namespace/>supportingDocJson" class="d-none">
	<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							<div class="pagetitle"><liferay-ui:message key="admin-appeal-form"/></div>							
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-dtls">
									<label><liferay-ui:message key="exam-title" /></label> <span
										class="value">Oman Examination For Nurses</span>
								</div>
							</div>
						</div>
					  <script>
								var tt_cnt= 0;
								</script>
					 <c:forEach var="appealStatus" items="${appealStatusList}" varStatus="counter">
							<c:set value="textEditors${counter.index}" var="editorClass"></c:set>
							<div class="d-none classHolderId" >${editorClass}</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label><liferay-ui:message key="reason-for-appeal"/> (${appealStatus.name})<span></span></label>
										<textarea class="form-control textEditors ${editorClass}" data-rich-class="${editorClass}" name="example" readonly="">${appealStatus.reason}</textarea>
									</div>
								</div>
							</div>
						 <script>
								console.log('tt_cnt ??', tt_cnt);
								$('.textEditors'+tt_cnt).richText({preview: true, height: 200});
								tt_cnt++;
							</script> 
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="document-uploaded-by"/> (${appealStatus.name}) </h4>
								<div class="omsb-list-view table-responsive">
									<table class="display omsb-datatables" id="other-documentss-table">
										<thead>
											<tr>
												<th><liferay-ui:message key="document-title"/></th>
												<th><liferay-ui:message key="supporting-document"/></th>
											</tr>
										</thead>
										<tbody>
											 <c:forEach var="document" items="${appealStatus.examDocuments}"> 
												<tr>
													<td>${document.docTitle }</td>
													<td><a class="btn upload_btn" title="download" href="${document.fileURL }">
													 <img src="<%=themeDisplay.getPathThemeImages()%>/svg/download_icon.svg" alt=""/>${document.fileName }</a>
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
										<textarea class="textEditor2" name="<portlet:namespace/>appealComments"></textarea>
									</div>
								</div>
							 </c:if> 
							<div class="col-lg-6 col-md-6 col-sm-12 mb-4">
								<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
									<h4 class="omsb-card-title"><liferay-ui:message key="old-results"/></h4>
									<div class="row">
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group-dtls">
												<label><liferay-ui:message key="result"/></label> <span
													class="value">${examResult.result }</span>
											</div>
										</div>
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group-dtls">
												<label><liferay-ui:message key="percentage"/></label> <span
													class="value">${examResult.percentage }</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12 mb-4">
								<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
									<h4 class="omsb-card-title"><liferay-ui:message key="new-results"/></h4>
									<div class="row">
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group">
												<label><liferay-ui:message key="result"/></label>
												<select name="<portlet:namespace/>result" id="result" class="custom-select form-control">
													<option value=""><liferay-ui:message key="select"/></option>
													<option value="Pass" ${examResult.result eq 'Pass' ? 'selected' : ''}><liferay-ui:message key="pass"/></option>
													<option value="Fail" ${examResult.result eq 'Fail' ? 'selected' : ''}><liferay-ui:message key="fail"/></option>
												</select>
											</div>
										</div>
										<div class="col-lg-6 col-md-12 col-sm-12">
											<div class="form-group">
												<label><liferay-ui:message key="percentage"/></label>
												<input type="text" pattern="[0-9]?\d+(\.\d+)?" value="${examResult.percentage}" name="<portlet:namespace/>percentage" class="form-control">
											</div>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						 <c:if test="${!assignedToMe && not empty trNames}"> 
							<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 other-documents-wrap">
								<h4 class="omsb-card-title"><liferay-ui:message key="add-supporting-document"/>
									<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button">
										<img src="../images/svg/plus_img.svg" alt="">
										<liferay-ui:message key="add-document"/>
									</button>
								</h4>
								<div class="omsb-list-view table-responsive">
									<table class="omsb-datatables dataTable" id="supporting-documents-table">
									<thead>
										<tr>
											<th data-name="docTitle"><liferay-ui:message key="document-title"/></th>
											<th data-name="fileName"><liferay-ui:message key="supporting-document"/></th>
											<th data-name="file" class="d-none"><liferay-ui:message key="document-file"/></th>
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
							 <c:if test="${not empty trNames}"> 
								<button class="btn omsb-bc-red-button" title="Accept" onclick="saveSupportingDocs(this);"  data-tr="Accept"><liferay-ui:message key="accept"/></button>
								<button class="btn omsb-bg-red-button" title="Reject" onclick="saveSupportingDocs(this);"  data-tr="Reject"><liferay-ui:message key="reject"/></button>
							 </c:if>
							<a class="btn omsb-btn btn-back" href="${viewApplicantRequests}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</div>

					</div>
				</div>
			</div>

	 <%@ include file="../supporting-docs-popup.jsp"%>

</form>	


