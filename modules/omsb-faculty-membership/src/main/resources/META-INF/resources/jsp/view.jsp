<%@include file="../init.jsp"%>

<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/responsive.bootstrap4.min.css">
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datepicker/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/responsive.bootstrap4.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/js/select-with-search/select2.min.js"></script>

<portlet:renderURL var="FacultysearchBarListActionURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<portlet:renderURL var="editMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName" value="/editFacultyRequest" />
</portlet:renderURL>

<portlet:actionURL name="submitReviewMemberDetailRequest"
	var="submitReviewMemberDetailRequestActionURL" />

<portlet:renderURL var="addMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FacultyMembershipConstants.ADD_EDIT_FACULTY_REQUEST_DETAILS_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:renderURL var="viewMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FacultyMembershipConstants.VIEW_FACULTY_REQUEST_DETAILS_RENDER_COMMAND %>" />
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
							<liferay-ui:message key="faculty-request-faculty-request" />
						</div>
					</div>

					<form action="<%=FacultysearchBarListActionURL%>" method="post">
						<div class="omsb-list-filter">
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="program" /></label> <select
											name="<portlet:namespace />programMasterId"
											class="form-control searchableProgram" id="dropdown">
											<option value="0"><liferay-ui:message
													key="common-select" /></option>
											<c:forEach items="${programMasterList}" var="program">
												<option value="${program.programMasterId}"
													${program.programMasterId eq programId ? 'selected' : ''}>${program.programName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="role" /></label> <select
											name="<portlet:namespace />facultyTypeId"
											class="form-control">
											<option value="0"><liferay-ui:message
													key="common-select" /></option>
											<c:forEach items="${facultyTypeList}" var="facultyType">
												<option value="${facultyType.facultyTypeId}"
													${facultyType.facultyTypeId  eq facultyTypeId ? 'selected' : ''}>${facultyType.nameEn}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message
												key="faculty-request-status" /></label> <select id="statustheshold"
											class="form-control js-basic-single"
											name="<portlet:namespace />facultyRequestStatusId">
											<option value="0"><liferay-ui:message
													key="common-select" /></option>
											<c:forEach items="${facultyRequestStatusList}"
												var="facultyRequestStatus">
												<option
													value="${facultyRequestStatus.facultyRequestStatusId}"
													${facultyRequestStatus.facultyRequestStatusId eq facultyRequestStatusId ? 'selected' : ''}>${facultyRequestStatus.nameEn}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="filter-button-wrap">
								<button class="btn omsb-bc-red-button">
									<liferay-ui:message key="search" />
								</button>
							</div>
						</div>
					</form>
					<div class="omsb-card border faculty-requests">
						<div class="omsb-status-boxes">
							<div class="row align-items-center">
								<div class="col-lg-3 col-md-12 col-sm-12">
									<figure class="highcharts-figure box-piechart">
										<div id="container"></div>
									</figure>
								</div>

								<div class="col-lg-3 col-md-4 col-sm-12">
									<div class="status-box">
										<div class="status-img">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/all.svg">
										</div>
										<div class="status-dtls">
											<span class="status-number" style="color: #1C1C1C;">10</span>
											<span class="status-text"><liferay-ui:message
													key="total" /></span>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-12">
									<div class="status-box">
										<div class="status-img">
											<img
												src="<%=themeDisplay.getPathThemeImages()%>/svg/completed_tms.svg">
										</div>
										<div class="status-dtls">
											<span class="status-number" style="color: #e82c2a;">7</span>
											<span class="status-text"><liferay-ui:message
													key="completed" /></span>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-12">
									<div class="status-box">
										<div class="status-img">
											<img
												src="<%=themeDisplay.getPathThemeImages()%>/svg/workprocess.svg">
										</div>
										<div class="status-dtls">
											<span class="status-number" style="color: #fa981c;">3</span>
											<span class="status-text"><liferay-ui:message
													key="in-proces" /></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="omsb-list-view table-responsive hide_dt_filter">
						<table class="display omsb-datatables" id="exam_list">
							<thead>
								<tr>
									<th><liferay-ui:message key="program" /></th>
									<th><liferay-ui:message key="site" /></th>
									<th><liferay-ui:message
											key="faculty-request-potential-faculty" /></th>
									<th><liferay-ui:message key="role" /></th>
									<th><liferay-ui:message
											key="faculty-request-status-pending-with" /></th>
									<th><liferay-ui:message key="action" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${facultyRequestList}" var="facultyRequest">
									<portlet:renderURL var="viewFacultyRequestDetailsURl">
										<portlet:param name="mvcRenderCommandName"
											value="<%=FacultyMembershipConstants.VIEW_FACULTY_REQUEST_DETAILS_RENDER_COMMAND%>" />
										<portlet:param name="facultyRequestId"
											value="${facultyRequest.facultyRequestId}" />
									</portlet:renderURL>
									<portlet:renderURL var="editFacultyRequestURL">
										<portlet:param name="mvcRenderCommandName"
											value="<%=FacultyRequestConstants.EDIT_FACULTY_REQUEST_RENDER_COMMAND%>" />
										<portlet:param name="facultyRequestId"
											value="${facultyRequest.facultyRequestId}" />
									</portlet:renderURL>
									<tr>
										<td>${facultyRequest.programName}</td>
										<td>${facultyRequest.trainingSiteName}</td>
										<td>${facultyRequest.potentialFacultyName}</td>
										<td>${facultyRequest.facultyTypeEn}</td>
										<td>${facultyRequest.faultyRequestStatusEn}</td>
										<td>
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle"
													type="button" data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">
													<li><a href="${viewFacultyRequestDetailsURl}"
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
					<div class="bottom-backbtn-wrap">
						<a class="btn omsb-btn btn-back" href="#"><i
							class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
					</div>
				</div>



			</div>
		</div>
		<!--// Inner Wrapper Contents -->

	</section>
	<!---// End Main Content Section Here --->

	<!-- Modal -->
	<div class="modal fade omsb-modal" id="adjudicatefacultyrequest"
		tabindex="-1" role="dialog"
		aria-labelledby="adjudicatefacultyrequestTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message
							key="faculty-request-adjudicate-faculty-request" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /></label>
								<textarea class="form-control"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button"
						title="Approve">
						<liferay-ui:message key="approve" />
					</button>
					<button class="btn omsb-bc-red-button" type="button" title="Reject">
						<liferay-ui:message key="reject" />
					</button>
					<button class="btn omsb-btn btn-back" type="button"
						data-dismiss="modal" aria-label="Close">
						<liferay-ui:message key="close" />
					</button>
				</div>
			</div>
		</div>
	</div>

	<!--// Comments pop up -->

	<!-- Modal -->
	<div class="modal fade omsb-modal" id="gemdirector" tabindex="-1"
		role="dialog" aria-labelledby="gemdirectorTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message
							key="faculty-request-adjudicate-faculty-request-gme-director" />
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /></label>
								<textarea class="form-control"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button"
						title="Approve">
						<liferay-ui:message key="faculty-request-approve-to-vpaa" />
					</button>
					<button class="btn omsb-bc-red-button" type="button" title="Reject">
						<liferay-ui:message
							key="faculty-request-approve-to-executive-president" />
					</button>
					<button class="btn omsb-bc-red-button" type="button" title="Reject">
						<liferay-ui:message key="reject" />
					</button>
					<button class="btn omsb-btn btn-back" type="button"
						data-dismiss="modal" aria-label="Close">
						<liferay-ui:message key="close" />
					</button>
				</div>
			</div>
		</div>
	</div>

	<!--// Attach case report -->

	<!-- Modal popup -->
	<div class="modal fade omsb-modal" id="ec_mem_detail_view"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<form action="<%=submitReviewMemberDetailRequestActionURL%>"
				class="popup-form" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<input name="<portlet:namespace />workflow-details"
							id="<portlet:namespace />workflow-details" type="hidden" />

						<h5 class="modal-title" id="exampleModalLongTitle">
							<liferay-ui:message key="ec-member-request-adjudicate" />
						</h5>
						<button type="button" class="close popup-reset"
							data-dismiss="modal" onClick="closePopup()" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label><liferay-ui:message
											key="ec-member-request-comments" /></label>
									<textarea name="<portlet:namespace />popup_adjudicate_comment"
										oninput="handleInput(this)" class="form-control comment"
										id="<portlet:namespace />popup_adjudicate_comment"></textarea>
									<span class="errorCommentMsg" style="color: red;"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer ec-mem-detail-view-action"></div>
				</div>
			</form>
		</div>
	</div>
	<!-- Modal popup -->

</div>
<script type="text/javascript">

        // Data retrieved from https://netmarketshare.com/
		// Make monochrome colors
		const colors = Highcharts.getOptions().colors.map((c, i) =>
			// Start out with a darkened base color (negative brighten), and end
			// up with a much brighter color
			Highcharts.color(Highcharts.getOptions().colors[0])
				.brighten((i - 3) / 7)
				.get()
		);

		// Build the chart
		Highcharts.chart('container', {
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				type: 'pie',
				margin: [0, 0, 0, 0],
				backgroundColor: null,

			},

			exporting: false,
			title: {
				text: '',
			},
			tooltip: {
				pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			accessibility: {
				point: {
					valueSuffix: '%'
				}
			},
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					colors,
					borderRadius: 5,
					dataLabels: {
						enabled: true,
						format: '<b>{point.name}</b><br>{point.percentage:.1f} %',
						distance: -50,
						filter: {
							property: 'percentage',
							operator: '>',
							value: 4
						}
					}
				}
			},
			series: [{
				name: 'Membership Requests',
				groupPadding: 0,
				pointPadding: 0,
				data: [
					{ name: 'Completed', y: 70, color: '#E82C2A' },
					{ name: 'In Process', y: 30, color: '#FA981C' },

				]
			}]
		});


		 $('#examstartdate').datepicker({
			dateFormat: 'dd-mm-yyyy'
		});
		
		$(document).ready(function () {
			$('.js-basic-single').select2();
		}); 

		$("[data-bs-toggle='dropdown']").click(function () {
			$(this).siblings("ul.dropdown-menu").toggleClass("show");
		})

		$(document).ready(function () {
			var trigger = $('.hamburger'),
				overlay = $('.overlay'),
				isClosed = false;

			trigger.click(function () {
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

			$('[data-toggle="offcanvas"]').click(function () {
				$('#omsb-main-wrapper').toggleClass('toggled');
			});

			$('.omsb-datatables').DataTable({
				"bLengthChange": false,
				"bFilter": false,
			});
		});
		
		
		function reviewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
						const transitionList = transitionNames.split(","); 
						const transitionLevelsList = transitionLevels.split(","); 
						 
						 $(".ec-mem-detail-view-action").empty();
						 
						 $.each( transitionList, function(index, tName ){
							 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
							 	var tNameSplit = tName.split("_").pop();
								$(".ec-mem-detail-view-action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitReviewDetails(\'' + details + '\', \'<portlet:namespace/>workflow-details\', \'' +tNameSplit+ '\');" >'+transitionLevelsList[index]+'</button>');
							
						   });
						 $(".ec-mem-detail-view-action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button popup-reset" onClick="closePopup()" data-dismiss="modal">Close</button>');
						
						
						$("#actions").attr("data-target","#ec_mem_detail_view");
						$("#ec_mem_detail_view").modal("show");
			
					}
					
					function submitReviewDetails(details, fieldId,tNameSplit) {
						$("#"+fieldId).val(details);
						if(tNameSplit.toUpperCase() === 'REJECT')
						{
							return rejectECRequestResource();
						}
						 else{	
							$("#ec_mem_detail_view").modal("hide");	
						}
						return true;
					}
			
				  
					function viewEditDetails (requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
						
						let actionUrl = '<%=editMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
						
						window.open(actionUrl, "_self" );
			
					}
					
					function viewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
						let actionUrl = '<%=viewMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
						window.open(actionUrl, "_self" );
					}
					
					function addMembershipDetailsView(requestId,workflowTaskId,transitionNames,workflowInstanceId){
						let actionUrl = '<%=addMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
						window.open(actionUrl, "_self" );
					}
					
					function viewDistributionReport(){
						alert("Distribution Report- in development");	
					}

					function viewIncentiveReport(){
						alert("Incentive Report in development");	
					}

			
	</script>
