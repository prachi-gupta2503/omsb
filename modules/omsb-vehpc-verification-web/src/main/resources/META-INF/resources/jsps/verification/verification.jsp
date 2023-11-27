<%@ include file="../../init.jsp"%>
<portlet:renderURL var="searchVerificationURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.SEARCH_VERIFICATION%>" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommands.VIEW_VERIFICATION%>" var="getVerificationData">
	<portlet:param name="cmd" value="getVerificationData" />
</portlet:resourceURL>

<portlet:renderURL var="filterPersonDetailsURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PERSONAL_DETAILS%>" />
</portlet:renderURL>

<div class="container">
	<c:if test="${vehpcAdmin}">
		<div class="omsb-status-boxes">
			<div class="row">
		
			<div class="col-5-equal col-md-4 ">
				<div class="status-box">
					<div class="status-img">
						<img src="<%=themeDisplay.getPathThemeImages()%>/svg/wip.svg" alt="" />
					</div>
					<div class="status-dtls">
						<span class="status-number">${statusCount["wip"]}</span> <span class="status-text"><liferay-ui:message key="wip" /></span>
					</div>
				</div>
			</div>
			
			<div class="col-5-equal col-md-4 ">
				<div class="status-box">
					<div class="status-img">
						<img src="<%=themeDisplay.getPathThemeImages()%>/svg/vehpc_thums_up.svg" alt="" />
					</div>
					<div class="status-dtls">
						<span class="status-number">${statusCount["positive"]}</span> <span class="status-text"><liferay-ui:message key="positive" /></span>
					</div>
				</div>
			</div>

			<div class="col-5-equal col-md-4 ">
				<div class="status-box">
					<div class="status-img">
						<img src="<%=themeDisplay.getPathThemeImages()%>/svg/vehpc_thums_down.svg" alt="" />
					</div>
					<div class="status-dtls">
						<span class="status-number">${statusCount["utv"]}</span> <span class="status-text"><liferay-ui:message key="utv" /></span>
					</div>
				</div>
			</div>
			
			<div class="col-5-equal col-md-4 ">
				<div class="status-box">
					<div class="status-img">
						<img src="<%=themeDisplay.getPathThemeImages()%>/svg/vehpc_unverified.svg" alt="" />
					</div>
					<div class="status-dtls">
						<span class="status-number">${statusCount["stop"]}</span> <span class="status-text"><liferay-ui:message key="stop" /></span>
					</div>
				</div>
			</div>

			<div class="col-5-equal col-md-4 ">
				<div class="status-box">
					<div class="status-img">
						<img src="<%=themeDisplay.getPathThemeImages()%>/svg/discrepancy.svg" alt="" />
					</div>
					<div class="status-dtls">
						<span class="status-number">${statusCount["discrepancy"]}</span> <span class="status-text"><liferay-ui:message key="discrepancy" /></span>
					</div>
				</div>
			</div>
			
			</div>
		</div>
		
	</c:if>
	
	<div class="omsb-card">
	
	<c:if test="${vehpcAdmin}">
		<div class="omsb-page-top-info">
			<div class="pagetitle"><liferay-ui:message key="list-verification-screen" /></div>
		</div>
		<%-- <div class="row">
			<div class="col-md-4">
				<div class="form-group autocomplete" style="width: 300px;">
						<label class=" control-label" for="personSelect"><liferay-ui:message key="select-a-person" /></label>
						<input class="field form-control mb-3" id="personSelect" type="text" name="personSelect" class
							placeholder="<liferay-ui:message key="select-a-person" />">
				</div>
			</div>
		</div> --%>
	</c:if>
	
	<c:if test="${!vehpcAdmin}">
		<div class="omsb-page-top-info">
				
			<div class="pagetitle">
					<liferay-ui:message key="dataflow-verification-for" /> <%=themeDisplay.getUser().getFullName() %>
			</div>				
			<div class="information">
				<a href="https://www.dataflowgroup.com/" type="button" class="btn omsb-bc-red-button"> <liferay-ui:message key="verify-your-data-in-dataflow" /></a>
				<a href="${searchVerificationURL}"  type="button" class="btn omsb-bc-red-button"> <liferay-ui:message key="don't-see-your-verification?" /></a>
			</div>
		</div>
	</c:if>
	
		<c:choose>
			<c:when test="${vehpcAdmin}">
				<c:set var="cssClassName" value="col-lg-3"/>
			</c:when>
			<c:otherwise>
				<c:set var="cssClassName" value="col-lg-4"/>
			</c:otherwise>
		</c:choose>

		<div class="omsb-list-filter ">
			<div class="row">
				<c:if test="${vehpcAdmin}">
					<div class="col-lg-3 col-md-6">
						<div class="form-group autocomplete" >
								<label class=" control-label" for="personSelect"><liferay-ui:message key="select-a-person" /></label>
								<input class="field form-control mb-3" id="personSelect" type="text" name="personSelect" class
									placeholder="<liferay-ui:message key="select-a-person" />">
						</div>
					</div>
				</c:if>
				<div class="${cssClassName} col-md-6"><aui:input name="dfrn" label="dfrn" type="text" placeholder="dfrn"></aui:input>
				</div>
				<div class="${cssClassName} col-md-6">
				<aui:input cssClass="form-control omsb-input-date datePicker"  placeholder="DD-MM-YYYY" name="verificationDate" id="verificationDate" label="verification-date" type="text-muted"></aui:input>
				
				</div>
				<div class="${cssClassName} col-md-6">
					<aui:select name="status" id="status" label="status">
							<option value="">Select</option>
							<c:forEach var="caseStatus" items="${caseStatusList}">
								<option value="${caseStatus.getKey() }"><liferay-ui:message
										key="${caseStatus.getName(themeDisplay.getLocale())}" />
								</option>
							</c:forEach>
					</aui:select>
				</div>
			</div>
			<div class="filter-button-wrap">
			<button class="btn omsb-bc-red-button search-filter">
				<liferay-ui:message key="search" />
			</button>
			</div>
		</div>
		
		<div class="omsb-list-view table-responsive" id="verification-data">
			<table class="display omsb-datatables" id="data_Verification"
			width="100%">
			<thead>
				<tr>
					<th id="name"><liferay-ui:message key="name" /></th>
					<th id="dfrn"><liferay-ui:message key="dfrn" /></th>
					<th id="verificationDate"><liferay-ui:message key="verification-date" /></th>
					<th id="status"><liferay-ui:message key="status" /></th>
					<th ><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="person" items="${persons}">
					<tr>
						<portlet:renderURL var="viewPersonDetailsURL">
							<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PERSONAL_DETAILS%>" />
							<portlet:param name="caseRequestId" value="${person.caseRequestId}" />
						</portlet:renderURL>
						<td>${person.personName}</td>
						<td>${person.caseNumber}</td>
						<td>${person.verificationDate}</td>
						<td><span class="omsb-${person.getCaseStatus().toLowerCase()}-bg">${person.caseStatus}</span></td>
						<td><a href="${viewPersonDetailsURL}" class="btn omsb-dd-button"> <img src="<%=themeDisplay.getPathThemeImages()%>/svg/red_eye.svg" alt=""> 
								<liferay-ui:message key="view" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>



<portlet:resourceURL var="personDetailURL"
	id="<%=MVCCommands.GET_PERSONAL_DETAILS%>" />

<portlet:resourceURL var="getCaseRequestDetails"
	id="<%=MVCCommands.GET_VERIFICATION_DATA%>" />	

<script>
$('#<portlet:namespace />verificationDate').datepicker({
	  format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    endDate: new Date()
   /*  endDate: new Date(new Date().setDate(new Date().getDate() + 5)) *//* 5 days from today */
	}).on('change', function(){
	    $('.datepicker').hide();
	});
	
var verificationDT = new DataTable('#data_Verification', {
    "bLengthChange": false,	
    "order": [],
    "search": {
		"caseInsensitive": false
	},
    dom: 'Bfrtip',
	buttons: [
		{
		extend: 'colvis',
		columns: ":not(':last')"
		},
		{
		extend: 'collection',
		text: '<liferay-ui:message key="export-as" />',
		buttons: [
			{
				title: '<liferay-ui:message key="verification-records" />',
				extend: 'csv',
				exportOptions: {
				columns: ':visible',
				columns: ":not(':last')"
				}
			},
			{
				title: '<liferay-ui:message key="verification-records" />',
				extend: 'pdf',
				exportOptions: {
				columns: ':visible',
				columns: ":not(':last')"
				}
			},
			{	
				title: '<liferay-ui:message key="verification-records" />',
				extend: 'excel',
				exportOptions: {
				columns: ':visible',
				columns: ":not(':last')"
				}
			},
			{	
				title: '<liferay-ui:message key="verification-records" />',
				extend: 'print',
				exportOptions: {
				columns: ':visible',
				columns: ":not(':last')"
				}
			}
		]
		}
	]
});


$(".search-filter").on('click',function() {
	console.log('calling this click fns::');
	var person = $('#personSelect').val();
	var status = $('#<portlet:namespace />status').val();
	var verificationDate = $('#<portlet:namespace />verificationDate').val();
	var dfrn = $('#<portlet:namespace />dfrn').val();
	
	verificationDT.columns().every(function(index) {
		
		let headerId = verificationDT.column( index ).header().id;
		
		verificationDT.column(index).search('').draw();
		if (headerId == 'name') {
			if (person) {
				console.log('name not empty:');
				verificationDT.column(index).search(person).draw();
			}
		}
		if (headerId == 'dfrn') {
			if (dfrn) {
				console.log('dfrn not empty:');
				verificationDT.column(index).search(dfrn).draw();
			}
		}
		if (headerId == 'status') {
			if (status) {
				console.log('status not empty:');
				verificationDT.column(index).search(status).draw();
			}
		}
		if (headerId == 'verificationDate') {
			if (verificationDate) {
				console.log('verificationDate not empty:');
				verificationDT.column(index).search(verificationDate).draw();
			}
		} 
	});
});
</script>
<style>
#data_Verification_filter {
    display: none;
}
</style>