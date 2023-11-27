<%@ include file="../../init.jsp"%>

<portlet:renderURL var="viewVerificationURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PERSONAL_DETAILS%>" />
</portlet:renderURL>

<portlet:renderURL var="viewPersonDetailsURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PERSONAL_DETAILS%>" />
</portlet:renderURL>

<portlet:renderURL var="backURL">
	<%-- <portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_VERIFICATION%>"/> --%>
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<liferay-portlet:actionURL name="addUserToPersonURL" var="addUserToPersonURL" />

<div class="container" id="wrapper">
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle">Search for Dataflow Verification</div>
			<div class="information">
				
			</div>
		</div>

		<div class="omsb-list-view table-responsive" id="search_data_Verification">
			<c:choose>
				<c:when test="${!empty persons}">
			
					<table class="display omsb-datatables"  id="search_ver">
						<thead>
							<tr>
								<th><liferay-ui:message key="name" /></th>
								<th><liferay-ui:message key="verification-date" /></th>
								<th><liferay-ui:message key="dfrn" /></th>
								<th><liferay-ui:message key="status" /></th>
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="person" items="${persons}">
								<tr>
									<portlet:renderURL var="viewPersonDetailsURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PERSONAL_DETAILS%>" />
										<portlet:param name="caseRequestId" value="${person.caseRequestId}" />
									</portlet:renderURL>
									<liferay-portlet:actionURL name="addUserToPersonURL" var="addUserToPersonURL" >
										<portlet:param name="personId" value="${person.personId}" />
									</liferay-portlet:actionURL>
									<td>${person.personName}</td>
									<td>${person.verificationDate}</td>
									<td>${person.caseNumber}</td>
									<td>${person.caseStatus}</td>
									<td>
										<div class="dropdown ">
											<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"><i class=""></i></button>
											<ul class="dropdown-menu">
												<li><a href="${viewPersonDetailsURL}" id="viewSearch" class="dropdown-item"><img src="o/oms-portal-theme/images/svg/red_eye.svg" alt=""> <liferay-ui:message key="view" /></a></li>
												<li><a href="${addUserToPersonURL}" id="addPersonToProfile" class="dropdown-item"><img src="o/oms-portal-theme/images/svg/fi-rr-plus.svg" alt=""><liferay-ui:message key="add-to-profile" /> </a></li>
											</ul>
										</div>
									</td> 		
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div class="omsb-no-records">
						<liferay-ui:message key="no-records-found" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="omsb-top-buttons omsb-card">
		<a class="btn omsb-btn btn-back" href="<%=backURL%>"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
	</div>
</div>

<script>
$('#search_ver').DataTable({
	"bLengthChange": false,
	"bFilter": false
	});
$('#<portlet:namespace />dob').datepicker({
    format: "dd/mm/yyyy",
    orientation: "bottom auto"
});
</script>


