<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=AppealConstants.VIEW_APPEAL_PERSON_LIST%>" var="appealSearchURL" >
</portlet:resourceURL>

<div class="container" id="wrapper">
	<div class="omsb-card">
		<div class="omsb-list-filter row">

			<div class="col-md-11 row">
				<c:if test="${hasEmployeeRole}">
				<div class="col-md-4">
					<div class="form-group">
						<label><liferay-ui:message key="employer" /></label> <input
							type="text" name="<portlet:namespace/>employer" id="employer" class="form-control" placeholder="<liferay-ui:message key="enter-employer-name" />">
					</div>
				</div>
				</c:if>
				<c:if test="${hasEmployerRole}">
					<div class="col-md-4">
						<div class="form-group">
							<label><liferay-ui:message key="employee" /></label> <input
								type="text" name="<portlet:namespace/>employee" id="employee" class="form-control" placeholder="<liferay-ui:message key="enter-employee-name" />">
						</div>
					</div>
				</c:if>
				<div class="col-md-4">
					<div class="form-group">
					<label><liferay-ui:message key="level" /></label>
						<select name="<portlet:namespace/>level" id="level" label="level" class="omsb-input-select form-control">
							<option value=""><liferay-ui:message key="select" /></option>
							<c:forEach var="equivalencyLevelvalues"
								items="${equivalencyLevelList}">
								<option value="${equivalencyLevelvalues.getKey()}">
									<liferay-ui:message
										key="${equivalencyLevelvalues.getName(themeDisplay.getLocale())}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="${hasEmployeeRole || hasEmployeeRole ? 'col-md-4' : 'col-md-1'} filter-button-div">
					<div class="form-group">
					<%-- <c:if test="${hasEmployeeRole}"> --%>
						<button class="btn omsb-filter-button" onclick="searchData()"><liferay-ui:message key="search" /></button>
						<%--</c:if>
						 <c:if test="${hasEmployerRole}">
						<button class="btn omsb-filter-button" onclick="searchData()"><liferay-ui:message key="search" /></button>
						</c:if> --%>
						
					</div>
				</div>
			</div>
		</div>
		<div class="omsb-list-view" id="decision-list-data">
			<%@ include file="./search-employer-data.jsp"%>
		</div>
	</div>
</div>

<style>
tbody .dropdown.show {
	width: 200px !important;
    z-index: 1 !important;
}	
</style>

<script>
$('#dob').datepicker({
    format: "dd/mm/yyyy",
    orientation: "bottom auto",
	autoclose: true
    }).on('change', function(){
        $('.datepicker').hide();
});

function searchData(){
	console.log("invoking search data function");
	var certificate = $("#certificate").val();
  	var employer = $("#employer").val();
   	var level = $("#level").val();
   	var employee = $("#employee").val();
   	console.log("employee IS ::::   ", employee);
   	if (employee == undefined) {
   		employee = '';
   	}
   	if (employer == undefined) {
   		employer = '';
   	}
	$.ajax({
		url: '<%=appealSearchURL.toString()%>',
			async : false,
			data : {
					<portlet:namespace />certificate : certificate,
					<portlet:namespace />employer : employer,
					<portlet:namespace />level : level,
					<portlet:namespace />employee : employee,
					},
				type : 'POST',
				success : function(data) {
					$("#decision-list-data").html(data);
					 $('#search_decision_data').DataTable({
				    	"bLengthChange": false,
				    	"bFilter": false
				    });
				}
	});
};

$('#search_decision_data').DataTable({
	"bLengthChange": false,
	"bFilter": false,
	"ordering": false
});
</script>
