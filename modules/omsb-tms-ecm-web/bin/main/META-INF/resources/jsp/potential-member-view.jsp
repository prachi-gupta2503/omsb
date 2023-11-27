<%@ include file="../init.jsp"%>
<%@page import="gov.omsb.tms.ecm.web.constants.MVCCommandNames"%>
<%@ page import="gov.omsb.tms.custom.dto.ECMembershipRequestListDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants"%>
<%-- <%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%> --%>
<%@ page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>

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
<portlet:actionURL name="reviewMemberDetailRequest"
	var="reviewMemberDetailRequestActionURL" />
<portlet:actionURL name="submitReviewMemberDetailRequest"
	var="submitReviewMemberDetailRequestActionURL" />
<portlet:renderURL var="searchBarListActionURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div class="main-content">

	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info">
						<div class="pagetitle">EC Membership Requests</div>
					</div>

					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables" id="requestData">
							<thead>
								<tr>
									<th>Program</th>
									<th>Potential EC MEMBER</th>
									<th>RoLE</th>
									<th>PENDING WITH /STATUS</th>
									<th width="200">Action</th>
								</tr>
							</thead>
							<tbody>
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
													<c:forEach var="actionLists"
														items="${ecMemberData.actionList}">
														<li><a href="#" data-toggle="modal" id="actions"
															onClick="${actionLists.handler}(`${ecMemberData.ecMemberRequestId}`,`${ecMemberData.workflowTaskId }`,`${ecMemberData.transitionList}`,`${ecMemberData.transitionLevelsList}`,`${ecMemberData.workflowInstanceId }`)"><liferay-ui:message key="${actionLists.name}" /></a></li>
													</c:forEach>
													<li><a href="${viewEcMemberDetailsURL}"
														class="dropdown-item"><img
															src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg">
															<liferay-ui:message key="ec-member-request-view" /></a></li></a></li>
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
		<!--// Inner Wrapper Contents -->

	</section>
	<!---// End Main Content Section Here --->

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
	    "paging": false,
	    "pageLength": 10,
	    columnDefs :[
	    	{orderable:false, target: 4}	
	    ],
	});

	
});



function viewEditDetails (requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	let actionUrl = '<%=editMembershipDetailsURL%>'+'&<portlet:namespace />ecMembershipRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}

function viewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	let actionUrl = '<%=viewMembershipDetailsURL%>'+'&<portlet:namespace />ecMembershipRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}


function addMembershipDetailsView(requestId,workflowTaskId,transitionNames,workflowInstanceId){
	let actionUrl = '<%=addMembershipDetailsURL%>'+'&<portlet:namespace />ecMemberRequestId='+requestId;
	window.open(actionUrl, "_self" );
}


function submitDetails(details, fieldId) {
	$("#"+fieldId).val(details);
	$("#ec_mem_detail_view").modal("hide");
}


</script>
