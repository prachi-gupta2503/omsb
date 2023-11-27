<%@ include file="../init.jsp"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="gov.omsb.tms.ecm.web.constants.MVCCommandNames"%>
<%@ page import="gov.omsb.tms.custom.dto.ECMembershipRequestListDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants"%>
<%-- <%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%> --%>
<%@ page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>

<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/responsive.bootstrap4.min.css">
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datepicker/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/responsive.bootstrap4.min.js"></script>


<portlet:renderURL var="addEcMemberRequestURL">
	<portlet:param name="mvcRenderCommandName"
		value="/add/new-ec-member-request" />
</portlet:renderURL>
<portlet:renderURL var="addMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.ADD_MEMBERSHIP_DETAILS_VIEW%>" />
</portlet:renderURL>

<portlet:renderURL var="viewMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="/view/ec-member-details" />
</portlet:renderURL>

<portlet:renderURL var="editMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="/edit/ec-member-details" />
</portlet:renderURL>


<portlet:actionURL name="submitNOC" var="submitNOCActionURL" />
<portlet:actionURL name="<%=MVCCommandNames.CREATE_QARAR_ACTION%>" var="createQararActionURL" />
<portlet:actionURL name="<%=MVCCommandNames.CREATE_MEMBER_REQUEST_ACTION%>" var="createMemberRequestActionURL" />
<portlet:actionURL name="reviewMemberDetailRequest"
	var="reviewMemberDetailRequestActionURL" />
<portlet:actionURL name="submitReviewMemberDetailRequest"
	var="submitReviewMemberDetailRequestActionURL" />
<portlet:renderURL var="searchBarListActionURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<liferay-ui:success key="ec-request-added-successfully" message="New EC Member Request Added Successfully!"/>
<liferay-ui:success key="ec-request-updated-successfully" message="EC Member Request Updated Successfully!"/>

<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info">
						<div class="pagetitle"><liferay-ui:message key="ec-member-request-page-title" /></div>
						<div class="information">
							<c:if test="${requester}">
								<a class="btn omsb-bc-red-button" id="createNewRequestBtn" href="${addEcMemberRequestURL}">
								<liferay-ui:message key="ec-member-request-new-request" /></a>
							</c:if>
						</div>
					</div>

					<form action="<%=searchBarListActionURL%>" method="post">
						<div class="omsb-list-filter ">
							<div class="row">
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<label><liferay-ui:message key="ec-member-request-program" /></label> <select
											name="<portlet:namespace />programId" class="form-control"
											id="dropdown">
											<option>select</option>
											<c:forEach items="${programMasterList}" var="program">
												<option value="${program.programMasterId }"
													${program.programMasterId eq programId ? 'selected' : ''}>${program.programName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<label><liferay-ui:message key="ec-member-request-role" /></label> <select name="<portlet:namespace />roleId"
											class="form-control">
											<option>select</option>
											<c:forEach items="${roleList}" var="role">
												<option value="${role.roleId }"
													${role.roleId eq roleId ? 'selected' : ''}>${role.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<label><liferay-ui:message key="ec-member-request-status" /></label> <select
											name="<portlet:namespace />statusId" class="form-control">
											<option>select</option>
											<c:forEach items="${ecMemberRequestStatusList}" var="status">
												<option value="${status.ecMemberRequestStatusId}"
													${status.ecMemberRequestStatusId eq statusId ? 'selected' : ''}>${status.nameEn }</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="filter-button-wrap">
								<button class="btn omsb-bc-red-button m-0"><liferay-ui:message key="ec-member-request-search" /></button>
							</div>
						</div>
					</form>
					<div class="omsb-card omsb-card-graybg pb-0 omsb-BorderRadius-4">
						<div class="omsb-status-boxes">
							<div class="row align-items-center">
								<div class="col-lg-3 col-md-12 col-sm-12">
									<div class="status-box">
										<figure class="highcharts-figure box-piechart">
											<div id="chart-container"></div>
										</figure>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-12">
									<div class="status-box">
										<div class="status-img">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/all.svg">
										</div>
										<div class="status-dtls">
											<span class="status-number" style="color: #1C1C1C;">${ecMembershipRequestDataList.size() == null ? 0 : ecMembershipRequestDataList.size()}</span>
											<span class="status-text"><liferay-ui:message key="ec-member-request-total-count" /></span>
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
											<c:forEach var="ecMemberData"
												items="${ecMembershipRequestDataList}">
												<c:if test="${ecMemberData.status == 'COMPLETE'}">
													<c:set var="completedCount" value="${completedCount + 1}" />
												</c:if>
											</c:forEach>
											<span class="status-number" id="completedCount"
												style="color: #e82c2a;">${completedCount == null ? 0 : completedCount}</span>
											<span class="status-text"><liferay-ui:message key="ec-member-request-completed-count" /></span>
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
											<c:forEach var="ecMemberData"
												items="${ecMembershipRequestDataList}">
												<c:if test="${ecMemberData.status != 'COMPLETE'}">
													<c:set var="completedCountForInProcess"
														value="${completedCountForInProcess + 1}" />
												</c:if>
											</c:forEach>
											<span class="status-number" id="inProcessCount"
												style="color: #fa981c;">${completedCountForInProcess == null ? 0 : completedCountForInProcess}</span>
											<span class="status-text"><liferay-ui:message key="ec-member-request-inprocess-count" /></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="requestData">
							<thead>
								<tr>
									<th><liferay-ui:message key="ec-member-request-program-name" /></th>
									
									<th><liferay-ui:message key="ec-member-request-potential-ec-member" /></th>
									<th><liferay-ui:message key="ec-member-request-role-name" /></th>
									<th><liferay-ui:message key="ec-member-request-pending-with-status" /></th>
									<th width="200"><liferay-ui:message key="ec-member-request-action" /></th>
								</tr>
							</thead>
							<tbody>
								<%-- 	<tr>
									<td>prg1</td>
									<td>site1</td>
									<td>rotation1</td>
									<td>potential ec member 1</td>
									<td>role1</td>
									<td>status1</td>
									<td>
										<portlet:renderURL var="viewEcMemberDetailsURL">
										    <portlet:param name="mvcRenderCommandName" value="/view/ec-member-details" />
										    <portlet:param name="ecMembershipRequestId" value="1" />
										</portlet:renderURL>
										<div class="dropdown">
											<button class="btn fa fa-ellipsis-v dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class=""></i>
											</button>
											<ul class="dropdown-menu">
												<li><a href="${viewEcMemberDetailsURL}" class="dropdown-item">View</a></li>
											</ul>
										</div>

									</td>
								</tr> --%>
								<c:forEach var="ecMemberData"
									items="${ecMembershipRequestDataList}">
									<portlet:renderURL var="addMemberDetailsRenderURL">
										<portlet:param name="mvcRenderCommandName"
											value="<%=MVCCommandNames.ADD_MEMBERSHIP_DETAILS_VIEW%>" />
										<portlet:param name="ecMemberRequestId"
											value="${ecMemberData.ecMemberRequestId }" />
										<portlet:param name="bankDetailsId"
											value="${ecMemberData.bankDetailsId }" />
										<portlet:param name="passportCopyId"
											value="${ecMemberData.passportCopyId }" />
										<portlet:param name="nationalIdCopyId"
											value="${ecMemberData.nationalIdCopyId }" />
									</portlet:renderURL>
									<portlet:renderURL var="viewEcMemberDetailsURL">
										<portlet:param name="mvcRenderCommandName"
											value="/view/ec-member-details" />
										<portlet:param name="ecMembershipRequestId"
											value="${ecMemberData.ecMemberRequestId }" />
									</portlet:renderURL>
									<portlet:renderURL var="viewMemberDetailsURL">
										<portlet:param name="mvcRenderCommandName"
											value="/view/member-details" />
										<portlet:param name="ecMembershipRequestId"
											value="${ecMemberData.ecMemberRequestId}" />
									</portlet:renderURL>
    								<tr>
										<td>${ecMemberData.program}</td>
										
										<td>${ecMemberData.potentialECMember}</td>
										<td>${ecMemberData.role}</td>
										<td>${ecMemberData.status}</td>
										<td>
											<div class="dropdown">
												<button class="btn fa fa-ellipsis-v dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu" id="actionListDropdown">
													<li><a href="${viewEcMemberDetailsURL}"
														class="dropdown-item"><img
															src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
															<liferay-ui:message key="ec-member-request-view" /></a></li>
													<c:forEach var="actionLists"
														items="${ecMemberData.actionList}">
														<li><a href="#" data-toggle="modal" id="actions"
															onClick="${actionLists.handler}(`${ecMemberData.ecMemberRequestId}`,`${ecMemberData.workflowTaskId }`,`${ecMemberData.transitionList}`,`${ecMemberData.transitionLevelsList}`,`${ecMemberData.workflowInstanceId }`)"><liferay-ui:message key="${actionLists.name}" /></a></li>
													</c:forEach>
													
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- ignore code -->
					<!-- <div class="bottom-backbtn-wrap mt-4">
						<a class="btn omsb-btn btn-back" href="#"><i
							class="fi fi-sr-arrow-left"></i>Back</a>
					</div> -->
					<!-- ignore code -->
				</div>

			</div>
		</div>
		<!--// Inner Wrapper Contents -->

	</section>
	<!---// End Main Content Section Here --->

</div>
<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_detail_view" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=submitReviewMemberDetailRequestActionURL%>" class="popup-form"
			method="post">
			<div class="modal-content">
				<div class="modal-header">
					<input name="<portlet:namespace />workflow-details"
						id="<portlet:namespace />workflow-details" type="hidden" />

					<h5 class="modal-title" id="exampleModalLongTitle">Adjudicate
						EC Membership Request</h5>
					<button type="button" class="close popup-reset" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label>Comments</label>
								<textarea name="<portlet:namespace />popup_adjudicate_comment" oninput="handleInput(this)"
									class="form-control comment" id="<portlet:namespace />popup_adjudicate_comment"></textarea>
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


<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_gme_detail_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=reviewMemberDetailRequestActionURL%>" class="popup-gme-form" method="post">
			<input name="<portlet:namespace />gme-request-details"
				id="<portlet:namespace />gme-request-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Adjudicate
						EC Membership Request: GME Director</h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label>Comments</label>
								<textarea name="<portlet:namespace />popup_adjudicate_comment" oninput="handleInput(this)"
									class="form-control gmeComment"
									id="comment"></textarea>
									<span class="errorCommentMsg" style="color: red;"></span>
								<%-- <textarea name="<portlet:namespace />popup_adjudicate_comment" class="form-control" id="comment"></textarea> --%>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_gme_detail_view_action"></div>
			</div>
		</form>
	</div>
</div>
<!-- Modal popup -->

<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_noc_popup_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=submitNOCActionURL%>" class="popup-form" method="post">
			<input name="<portlet:namespace />noc-task-details"
				id="<portlet:namespace />noc-task-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Add No
						Objection Letter</h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label>No Objection Letter <span style="color: red;">*</label> <input type="file"
									name="<portlet:namespace />nocDocument" oninput="handleInput(this)"
									id="<portlet:namespace />nocDocument" accept="image/*,.pdf" required></input>
									<span class="nocFileErrorMsg" style="color:red;"></span>
							</div>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label>Comments</label>
								<textarea name="<portlet:namespace />noc_comment"
									class="form-control comment" id="<portlet:namespace />noc_comment"></textarea>
									<!-- <span class="errorCommentMsg" style="color: red;"></span> -->
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_noc_popup_action"></div>
			</div>
		</form>
	</div>
</div>
<!-- Modal popup -->

<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_qarar_popup_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=createQararActionURL%>" class="popup-form" method="post">
			<input name="<portlet:namespace />qarar-task-details"
				id="<portlet:namespace />qarar-task-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Submit Qarar Request</h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label>Comments</label>
								<textarea name="<portlet:namespace />qarar_comment"
									class="form-control comment" id="<portlet:namespace />qarar_comment"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_qarar_popup_action"></div>
			</div>
		</form>
	</div>
</div>
<!-- Modal popup -->

<!-- Modal popup -->

<div class="modal fade omsb-modal" id="ec_mem_member_request_popup_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=createMemberRequestActionURL%>" class="popup-form" method="post">
			<input name="<portlet:namespace />member-request-task-details"
				id="<portlet:namespace />member-request-task-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Member Request Detail</h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label>Comments</label>
								<textarea name="<portlet:namespace />member_request_comment"
									class="form-control comments" id="<portlet:namespace />member_request_comment"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_member_request_popup_action"></div>
			</div>
		</form>
	</div>
</div>
<% 
	Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
    String siteFriendlyURL = group.getFriendlyURL(); %>
<!-- Modal popup -->

<script type="text/javascript">

$(document).ready(function () {
	$('#requestData').DataTable({
	    "bLengthChange": false,
	    "bFilter": false,
	    "paging": true,
	    "pageLength": 10,
	    columnDefs :[
	    	{orderable:false, target: 4}	
	    ],
	});

 var config = new Object({}),
	namespace = '<portlet:namespace />',
	civilIdJEL = '#' + namespace + 'civilId',
	passportNoJEL = '#' + namespace + 'passportNo',
	dateofbirthJEL = '#' + namespace + 'dateofbirth',
	personIdJEL = '#' + namespace + 'personId',
	personsDatatableJEL = '#personsDatatable',
	searchPersonsBtnJEL = '#' + namespace + 'searchPersonsBtn',
	programNameJEL = '#' + namespace + 'programName',
	trainingSiteJEL = '#' + namespace + 'trainingSite',
	rotationJEL = '#' + namespace + 'rotation',
	membershipRoleJEL = '#' + namespace + 'membershipRole',
	coveringLetterJEL = '#' + namespace + 'coveringLetter',
	curriculamVitaeJEL = '#' + namespace + 'curriculamVitae',
	civilIdPassportErrorJEL = '#' + namespace + 'civilIdPassportError',
	dobErrorJEL = '#' + namespace + 'dobError';
	addNewEcMemberRequestJEL = '#' + namespace + 'addNewEcMemberRequest',
	getPersonsDataResourceURLJEL = '${getPersonsDataResourceURL}',
	submitBtnJEL = '#' + 'submitBtn';
	addEcMemberRequestURL = '${addEcMemberRequestURL}'
	createNewRequestBtnJEL = '#' + 'createNewRequestBtn';
	getDependentDataResourceURLJEL = '${getDependentDataResourceURLJEL}';
	approveRequest = '#' + namespace + 'approveRequest',
	
	config.namespace = namespace;
	config.civilIdJEL = civilIdJEL;
	config.passportNoJEL = passportNoJEL;
	config.dateofbirthJEL = dateofbirthJEL;
	config.personIdJEL = personIdJEL;
	config.personsDatatableJEL = personsDatatableJEL;
	config.searchPersonsBtnJEL = searchPersonsBtnJEL;
	config.programNameJEL = programNameJEL;
	config.trainingSiteJEL = trainingSiteJEL;
	config.rotationJEL = rotationJEL;
	config.membershipRoleJEL = membershipRoleJEL;
	config.coveringLetterJEL = coveringLetterJEL;
	config.curriculamVitaeJEL = curriculamVitaeJEL;
	config.civilIdPassportErrorJEL = civilIdPassportErrorJEL;
	config.dobErrorJEL = dobErrorJEL;
	config.getPersonsDataResourceURLJEL = getPersonsDataResourceURLJEL;
	config.addNewEcMemberRequestJEL = addNewEcMemberRequestJEL;
	config.getDependentDataResourceURLJEL = getDependentDataResourceURLJEL;
	config.submitBtnJEL = submitBtnJEL;
	config.createNewRequestBtnJEL = createNewRequestBtnJEL;
	config.addEcMemberRequestURL = addEcMemberRequestURL;
	
	ecmrPortlet.renderECMR(config);
	
	//Make monochrome colors
	const colors = Highcharts.getOptions().colors.map((c, i) =>
		// Start out with a darkened base color (negative brighten), and end
		// up with a much brighter color
		Highcharts.color(Highcharts.getOptions().colors[0])
			.brighten((i - 3) / 7)
			.get()
	);


	//Build the chart
	Highcharts.chart('chart-container', {
		chart: {
			plotBackgroundColor: null,
			plotBorderWidth: null,
			plotShadow: false,
			type: 'pie',
			margin: [0, 0, 0, 0],
			backgroundColor: null,
			width : 100,
			height: 100,

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
				{ name: 'Completed', y: completedCountValue, color: '#E82C2A' },
				{ name: 'In Process', y: inProcessCountValue, color: '#FA981C' },

			]
		}]
	});
});

<!-- get completed count -->

  var completedCountElement = document.querySelector('#completedCount');
  var completedCountValue = parseInt(completedCountElement.textContent);

<!-- get in Process count -->

  var inProcessCountElement = document.querySelector('#inProcessCount');
  var inProcessCountValue = parseInt(inProcessCountElement.textContent);



function rejectECRequestResource(){
	    var commentValue = $(".comment").val().trim();
	    if (commentValue === "") {	    
	      $(".errorCommentMsg").text("Comment can not be empty !");
	      return false;
	    }  else {
	      $(".comment").val(commentValue);
	      $(".errorCommentMsg").text("");
	      $("#ec_mem_detail_view").modal("hide");
	      $(".popup-reset").trigger('reset');
	      return true;
	    } 
}

 function rejectGMEDirector(){
    var commentValue = $(".gmeComment").val().trim();
    if (commentValue === "") {
      $(".errorCommentMsg").text("Comment can not be empty !");
      return false;
    }  else {
      $(".gmeComment").val(commentValue);
      $(".errorCommentMsg").text("");
      $("#ec_mem_gme_detail_view").modal("hide");
      $(".popup-reset").trigger('reset');
      return true;
    } 
} 


function uploadNOCView(requestId,workflowTaskId,transitionNames, transitionLevels, workflowInstanceId){
	
	const transitionList = transitionNames.split(","); 
	const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_noc_popup_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
			$(".ec_mem_noc_popup_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitNocDetails(\'' + details + '\', \'<portlet:namespace/>noc-task-details\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_noc_popup_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()"	data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_noc_popup_view");
	$("#ec_mem_noc_popup_view").modal("show");
	
}

function gmeDirectorsReview(requestId,workflowTaskId,transitionNames, transitionLevels, workflowInstanceId){
	
	 const transitionList = transitionNames.split(","); 
	 const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_gme_detail_view_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}";  
		 	var tNameSplit = tName.split("_").pop();
			$(".ec_mem_gme_detail_view_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitGMEDirectorDetails(\'' + details + '\', \'<portlet:namespace/>gme-request-details\',\'' +tNameSplit+ '\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_gme_detail_view_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()" data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_gme_detail_view");
	$("#ec_mem_gme_detail_view").modal("show");
}


function reviewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
		
	 const transitionList = transitionNames.split(","); 
	 const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec-mem-detail-view-action").empty();
	 
	 $.each( transitionList, function( index, tName ){
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
		 	var tNameSplit = tName.split("_").pop();
			$(".ec-mem-detail-view-action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitReviewDetails(\'' + details + '\', \'<portlet:namespace/>workflow-details\', \'' +tNameSplit+ '\');" >'+transitionLevelsList[index]+'</button>');
		
	   });
	 $(".ec-mem-detail-view-action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button popup-reset" onClick="closePopup()" data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_detail_view");
	$("#ec_mem_detail_view").modal("show");

}

function viewEditDetails (requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	let actionUrl = '<%=editMembershipDetailsURL%>'+'&<portlet:namespace />ecMembershipRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}

function viewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	let actionUrl = '<%=viewMembershipDetailsURL%>'+'&<portlet:namespace />ecMembershipRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}

function generateQararView(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	const transitionList = transitionNames.split(","); 
	const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_qarar_popup_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
			$(".ec_mem_qarar_popup_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitQararRequest(\'' + details + '\', \'<portlet:namespace/>qarar-task-details\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_qarar_popup_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()"	data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_qarar_popup_view");
	$("#ec_mem_qarar_popup_view").modal("show");
	
}

function requestMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){	
	const transitionList = transitionNames.split(","); 
	const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_member_request_popup_view").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
		 	$(".ec_mem_member_request_popup_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitMemberRequest(\'' + details + '\', \'<portlet:namespace/>member-request-task-details\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_member_request_popup_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()"	data-dismiss="modal">Close</button>');
	
	$("#actions").attr("data-target","#ec_mem_member_request_popup_view");
	$("#ec_mem_member_request_popup_view").modal("show");
}

function addMembershipDetailsView(requestId,workflowTaskId,transitionNames,workflowInstanceId){
	let actionUrl = '<%=addMembershipDetailsURL%>'+'&<portlet:namespace />ecMemberRequestId='+requestId;
	window.open(actionUrl, "_self" );
}


function viewDistributionReport(){

	let facultyURL='${themeDisplay.getPortalURL()}/group<%=siteFriendlyURL%><%=OmsbEcMembershipConstants.FACULTY_SITE_COMPENSATION_REPORT_URL%>';
	window.open(facultyURL,'_self');
}

function viewIncentiveReport(){
	alert("Report is not available currently");	
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

function submitNocDetails(details, fieldId)
{
	$("#"+fieldId).val(details);
	var fileName = $("#<portlet:namespace />nocDocument").val();
	if(fileName === "")
	{
		$(".nocFileErrorMsg").text("Please select file !");
		return false;
	}
	else
	{
		$("#ec_mem_noc_popup_view").modal("hide");
		$(".nocFileErrorMsg").text("");
		//$("#ec_mem_noc_popup_view").empty();
		return true;
	}
}

function submitQararRequest(details, fieldId){
	$("#"+fieldId).val(details);
	$("#ec_mem_qarar_popup_view").modal("hide");
	return true;
}

function submitMemberRequest(details, fieldId){
	$("#"+fieldId).val(details);
	$("#ec_mem_member_request_popup_view").modal("hide");
	return true;
}

function submitGMEDirectorDetails(details, fieldId,tNameSplit){
	$("#"+fieldId).val(details);
	if(tNameSplit.toUpperCase() === 'REJECT')
	{
		return rejectGMEDirector();
	}
	 else{
		$("#ec_mem_gme_detail_view").modal("hide");	
	}	
	return true;
}

function closePopup(){
	$(".popup-form")[0].reset();
	$(".popup-gme-form")[0].reset();
	$(".errorCommentMsg").text(" ");
	$(".nocFileErrorMsg").text(" ");
	$("#<portlet:namespace />nocDocument").val("");
	$("#<portlet:namespace />noc_comment").val("");
}

function handleInput(input) {
    if(input.value.trim() !=="")
    {
    	$(".errorCommentMsg").text("");
    	$(".nocFileErrorMsg").text("");
    }
    
  }

</script>
