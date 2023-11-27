<%@include file="../../init.jsp"%>

<portlet:renderURL var="newFacultyRequestURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FacultyRequestConstants.NEW_FACULTY_REQUEST_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:renderURL var="addMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FacultyMembershipConstants.ADD_EDIT_FACULTY_REQUEST_DETAILS_RENDER_COMMAND%>" />
</portlet:renderURL>

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && SessionMessages.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span> <liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>

<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">

		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info">
						<div class="pagetitle">
							<liferay-ui:message key="faculty-request-my-faculty-requests" />
						</div>
						<div class="information">
							<a href="${newFacultyRequestURL}" class="btn omsb-bc-red-button"><liferay-ui:message
									key="faculty-request-create-new-request" /> </a>
						</div>
					</div>

					<div class="omsb-list-view table-responsive hide_dt_filter">
						<table class="display omsb-datatables" id="exam_list">
							<thead>
								<tr>
									<th><liferay-ui:message key="program" /></th>
									<th><liferay-ui:message key="site" /></th>
									<th><liferay-ui:message key="role" /></th>
									<th><liferay-ui:message key="faculty-request-status" /></th>
									<th><liferay-ui:message key="action" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${facultyRequestList}" var="facultyRequest">
									<portlet:renderURL var="viewFacultyRequestDetailsURL">
										<portlet:param name="mvcRenderCommandName"
											value="<%=FacultyMembershipConstants.VIEW_FACULTY_REQUEST_DETAILS_RENDER_COMMAND%>" />
										<portlet:param name="facultyRequestId"
											value="${facultyRequest.facultyRequestId}" />
									</portlet:renderURL>
									<tr>
										<td>${facultyRequest.programName}</td>
										<td>${facultyRequest.trainingSiteName}</td>
										<td>${facultyRequest.facultyTypeEn}</td>
										<td>${facultyRequest.faultyRequestStatusEn}</td>
										<td>

											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle"
													type="button" data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">
													<li><a href="${viewFacultyRequestDetailsURL}"
														class="dropdown-item"> <img
															src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
															<liferay-ui:message key="view" />
													</a> <c:forEach var="actionLists"
															items="${facultyRequest.actionList}">
															<li><a href="#" data-toggle="modal" id="actions"
																onClick="${actionLists.handler}(`${facultyRequest.facultyRequestId}`,`${facultyRequest.workflowTaskId }`,`${facultyRequest.transitionList}`,`${facultyRequest.transitionLevelsList}`,`${facultyRequest.workflowInstanceId }`)"><liferay-ui:message
																		key="${actionLists.name}" /></a></li>
														</c:forEach></li>
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<script>
	$("[data-bs-toggle='dropdown']").click(function() {
		$(this).siblings("ul.dropdown-menu").toggleClass("show");
	})

	$(document)
			.ready(
					function() {
						var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

						trigger.click(function() {
							hamburger_cross();
						});

						function hamburger_cross() {

							if (isClosed == true) {
								overlay.hide();
								trigger.removeClass('is-open');
								trigger.addClass('is-closed');
								isClosed = false;
							} else {
								overlay.show();
								trigger.removeClass('is-closed');
								trigger.addClass('is-open');
								isClosed = true;
							}
						}

						$('[data-toggle="offcanvas"]').click(function() {
							$('#omsb-main-wrapper').toggleClass('toggled');
						});

						$('.omsb-datatables').DataTable({
							"bLengthChange" : false,
							"bFilter" : false,
						});
					});
	
	 function addMembershipDetailsView(requestId,workflowTaskId,transitionNames,workflowInstanceId){
         let actionUrl = '<%=addMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
         window.open(actionUrl, "_self" );
       }
</script>