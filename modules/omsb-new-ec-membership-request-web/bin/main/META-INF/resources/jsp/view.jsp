<%@ include file="../init.jsp"%>
<%@ page import="gov.omsb.tms.custom.dto.ECMembershipRequestListDTO"%>
<%@ page import="java.util.List"%>
<%-- <%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%> --%>
<%@ page import="com.liferay.portal.kernel.model.Role"%>

<portlet:renderURL var="addEcMemberRequestURL">
	<portlet:param name="mvcRenderCommandName"
		value="/add/new-ec-member-request" />
</portlet:renderURL>

<portlet:resourceURL id="approveStatus"
	var="approveECMembershipRequestUrl"></portlet:resourceURL>
<portlet:resourceURL id="rejectStatus"
	var="rejectECMembershipRequestUrl"></portlet:resourceURL>

<div class="main-content">

	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">

		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				${ecMembershipRequestDataList}
				<div class="omsb-card">
					<div class="omsb-page-top-info">
						<div class="pagetitle">EC Membership Requests</div>
						<div class="information">
							<button class="btn omsb-bc-red-button" id="createNewRequestBtn">create
								new request</button>
						</div>
					</div>

					<div class="omsb-list-filter ">
						<div class="row">
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									<label>Program</label> <select name="program"
										class="form-control">
										<option>select</option>
										<option value="1">Rotation 1</option>
										<option value="2">Rotation 2</option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									<label>Role</label> <select name="role" class="form-control">
										<option>select</option>
										<option value="1">Rotation 1</option>
										<option value="2">Rotation 2</option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 col-sm-12">
								<div class="form-group">
									<label>Status</label> <select name="status"
										class="form-control">
										<option>select</option>
										<option value="1">Rotation 1</option>
										<option value="2">Rotation 2</option>
									</select>
								</div>
							</div>
						</div>

						<div class="filter-button-wrap">
							<button class="btn omsb-bc-red-button m-0">Search</button>
						</div>
					</div>

					<div class="omsb-card omsb-card-graybg pb-0 omsb-BorderRadius-4">
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
											<span class="status-number" style="color: #1C1C1C;">${ecMembershipRequestDataList.size()}</span>
											<span class="status-text">Total</span>
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
											<span class="status-number" style="color: #e82c2a;">8</span>
											<span class="status-text">Completed</span>
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
											<span class="status-number" style="color: #fa981c;">2</span>
											<span class="status-text">In Process</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables">
							<thead>
								<tr>
									<th>Program</th>
									<th>Site</th>
									<th>Rotations</th>
									<th>Potential EC MEMBER</th>
									<th>RoLE</th>
									<th>Status</th>
									<th width="200">Action</th>
								</tr>
							</thead>
							<tbody>
								<tr>
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
								</tr>
								<c:forEach var="ecMemberData"
									items="${ecMembershipRequestDataList}">
									<tr>
										<td>${ecMemberData.program}</td>
										<td>${ecMemberData.site}</td>
										<td>${ecMemberData.rotations}</td>
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
												<ul class="dropdown-menu">
													<c:forEach var="role"
														items="${themeDisplay.getUser().getRoles()}">
														<c:if test="${role.getName() eq 'Requestor'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Edit</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View QARAR</a></li>
														</c:if>
														<c:if test="${role.getName() eq 'EC Section Staff'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">View
																	Distribution Report</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">View
																	Incentive Report</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Adjudicate
																	Request</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Upload
																	NOC</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Generate
																	QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">View
																	Member Details</a></li>
															<li><a href="#" class="dropdown-item"
																data-toggle="modal" data-target="#adj_ec_mem_detail"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Review
																	Member Details</a></li>
															 <input type="hidden" id="ecMemberRequestId" value="${ecMemberData.ecMemberReqeustId}"/> 
														</c:if>
														<c:if
															test="${role.getName() eq 'EC Section Head' || role.getName() eq 'GME Director' || role.getName() eq 'VPAA'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Adjudicate
																	Request</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Generate
																	QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">View
																	QARAR</a></li>
														</c:if>
														<%-- <c:if test="${role.getName() eq 'EC Section Head'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Adjudicate
																	Request</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Generate
																	QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View QARAR</a></li>
														</c:if>
														<c:if test="${role.getName() eq 'GME Director'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Adjudicate
																	Request</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Generate
																	QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View QARAR</a></li>
														</c:if>
														<c:if test="${role.getName() eq 'VPAA'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Adjudicate
																	Request</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Generate
																	QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View QARAR</a></li>
														</c:if> --%>
														<c:if test="${role.getName() eq 'Executive President'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Adjudicate
																	Request</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">Generate
																	QARAR</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View QARAR</a></li>
														</c:if>
														<c:if test="${role.getName() eq 'Authorized Individual'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Upload
																	NOC</a></li>
														</c:if>
														<c:if test="${role.getName() eq 'Potential EC Member'}">
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
																	View</a></li>
															<li><a href="#" class="dropdown-item"><img
																	src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Enter
																	Member Details</a></li>
														</c:if>
														<!-- Add other role conditions here -->
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
					<div class="bottom-backbtn-wrap mt-4">
						<a class="btn omsb-btn btn-back" href="#"><i
							class="fi fi-sr-arrow-left"></i>Back</a>
					</div>
					<!-- ignore code -->
				</div>

			</div>
		</div>
		<!--// Inner Wrapper Contents -->

	</section>
	<!---// End Main Content Section Here --->

</div>
<!-- Modal popup -->
<div class="modal fade omsb-modal" id="adj_ec_mem_detail" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Adjudicate
					EC Membership Request</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="form-group">
							<label>Comments</label>
							<textarea name="popup_adjudicate_comment" class="form-control"
								id="comment"></textarea>
							<span id="errorSpan" style="color: red;"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" id="approveRequest"
					onClick="approveECRequestResource()" type="button" title="Approve">Approve</button>
				<button class="btn omsb-bc-red-button" id="reject_btn" onClick="rejectECRequestResource()" type="button" title="Reject">Reject</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Modal popup -->


<!-- Modal popup -->
<div class="modal fade omsb-modal" id="adj_ec_mem_gme_detail"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Adjudicate
					EC Membership Request: GME Director</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="form-group">
							<label>Comments</label>
							<textarea name="popup_adjudicate_comment" class="form-control"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Approve">Approve
					to VPAA</button>
				<button class="btn omsb-bc-red-button" type="button" title="Approve">Approve
					to Executive President</button>
				<button class="btn omsb-bc-red-button" type="button" title="Reject">Reject</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Modal popup -->

<script type="text/javascript">
$(document).ready(function () {
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
	
});

//Make monochrome colors
const colors = Highcharts.getOptions().colors.map((c, i) =>
	// Start out with a darkened base color (negative brighten), and end
	// up with a much brighter color
	Highcharts.color(Highcharts.getOptions().colors[0])
		.brighten((i - 3) / 7)
		.get()
);


//Build the chart
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

function approveECRequestResource(){
 	AUI().use('aui-io-request','aui-base','io', function(A){
	   	var comment =  $("#comment").val();
	   	var ecMemberRequestId =  $("#ecMemberRequestId").val();
	   	    A.io.request('<%=approveECMembershipRequestUrl.toString()%>', {
				method : 'post',
				dataType : 'json',
				data: {
                   '<portlet:namespace />comment': comment,
                   '<portlet:namespace />ecMemberRequestId':ecMemberRequestId,
                  },
				on : {
					success : function() {
						$("#comment").val('');
						$("#errorSpan").text("");
					    $("#adj_ec_mem_detail").modal('hide');
					}
				}
			});
		});
	}

function rejectECRequestResource(){
	    var commentValue = $("#comment").val().trim();
	    if (commentValue === "") {
	      $("#errorSpan").text("Comment cannot be empty!");
	    } else {
	      $("#comment").val('');
	      $("#errorSpan").text("");
	      $("#adj_ec_mem_detail").modal('hide');
	    }
}

</script>
