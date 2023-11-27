<%@ include file="../../init.jsp"%>

<style>
  .omsb-datatables thead tr th:nth-child(5){
    display: none;
}

.omsb-datatables tbody tr td:nth-child(5){
    display: none;
} 
#reg-search-div tr th:nth-child(2), #reg-search-div tr th:nth-child(5),#reg-search-div tr th:nth-child(9), #reg-search-div tr th:nth-child(10){
    display: none;
}
#registration-list_filter{
display: none;
} 
div#registration-list_wrapper table {
    width: 100% !important;
}
</style>

<portlet:resourceURL id="<%=MVCCommands.ADMIN_SEARCH_REGISTRATION%>"
	var="getRegistrationData">
	<portlet:param name="cmd" value="getRegistrationData" />
</portlet:resourceURL>
<portlet:renderURL var="addPersonalDetailsURL">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS%>" />
</portlet:renderURL>
<!--- Start Main Content Section Here --->
<section class="omsb-main-wrapper" id="omsb-main-wrapper">

	<!-- Inner Wrapper Contents -->
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
	        	<div class="omsb-page-top-info">
					<div class="pagetitle"><liferay-ui:message key="registration-lists" /></div>
					<div class="information">
						<a href="<%=addPersonalDetailsURL%>" class="bOmani Civil Idtn omsb-bc-red-button">
							<liferay-ui:message key="create-new-registration" />
						</a>
					</div>
				</div>
				<div>
					<div class="omsb-list-view table-responsive"
						id="registrationHomeTable">
						<table class="display omsb-datatables" id="registration-list">
							<div id="reg-search-div"></div> 
							<thead>
								<tr>
									<th><liferay-ui:message key="name" /></th>
									<th><liferay-ui:message key="created-on" /></th>
									<th><liferay-ui:message key="passport-no" /></th>
									<th><liferay-ui:message key="omani-civil-id-or-omani-resident-id" /></th>
									<th><liferay-ui:message key="date-of-birth" /></th>
									<th><liferay-ui:message key="verified-status" /></th>
									<th><liferay-ui:message key="verified-date" /></th>
									<th><liferay-ui:message key="last-verified" /></th>
									<c:if test="${isRoleApprover}">
										<th><liferay-ui:message key="omsb-associated"/></th>
									</c:if>
									<th><liferay-ui:message key="action" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${registrationList}" var="registration">
									<tr>
										<td>${registration.getPersonName()}</td>
										<td>${registration.getDateCreated()}</td>
										<td>${registration.getPassportNo()}</td>
										<td>${registration.getCivilId()}</td>
										<td>${registration.getDateOfBirth()}</td>
										<td><span class="${registration.getRegistrationStatusColor()}">${registration.getRegistrationStatus()}</span></td>
										<td>${registration.getDateModified()}</td> 
										<td><span class="${registration.getLastVerifiedStatusColor()}">${registration.getLastVerified()}</span></td>
										<c:if test="${isRoleApprover}">
										<td>${registration.getOmsbAssociated()}</td>
										</c:if> 
										<td width="120">
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">
													<c:if test="${registration.workflowStatus eq 'Pending' && registration.assignedToMe && (isProfileApprover || isServiceApprover || isRoleApprover)}">
														<portlet:renderURL var="adminEditRegistrationURL">
															<portlet:param name="mvcRenderCommandName"
																value="<%=MVCCommands.EDIT_REGISTRATION_DETAILS%>" />
															<portlet:param name="personId"
																value="${registration.getPersonId()}" />
														</portlet:renderURL>
													<%-- 	<li><a href="${adminEditRegistrationURL}" class="dropdown-item">
																<img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
																<liferay-ui:message key="edit" />
															</a>
														</li> --%>
													</c:if>
													
													<portlet:renderURL var="adminViewRegistrationURL">
														<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_DETAILS%>" />
														<portlet:param name="personId" value="${registration.getPersonId()}" />
													</portlet:renderURL>
													<li>
														<a href="${adminViewRegistrationURL}" class="dropdown-item">
															<img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
															<liferay-ui:message key="view" />
														</a>
													</li>													
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							 <tfoot>
								<tr>
									<th><liferay-ui:message key="name" /></th>
									<th><liferay-ui:message key="created-on" /></th>
									<th><liferay-ui:message key="passport-no" /></th>
									<th><liferay-ui:message key="omani-civil-id-or-omani-resident-id" /></th>
									<th><liferay-ui:message key="date-of-birth" /></th>
									<th><liferay-ui:message key="verified-status" /></th>
									<th><liferay-ui:message key="verified-date" /></th>
									<th><liferay-ui:message key="last-verified" /></th>
									<c:if test="${isRoleApprover}">
										<th><liferay-ui:message key="omsb-assosiated" /></th>
									</c:if>
									<th><liferay-ui:message key="action" /></th>
									
								</tr>
								</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
	$('#dateOfBirth').datepicker({
		format : "dd-mm-yyyy",
		orientation : "bottom auto",
		autoclose : true
	}).on('change', function() {
		$('.datepicker').hide();
	});
	
	new DataTable('#registration-list', {
		"bLengthChange" : false,
		"order": [],
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
					extend: 'csv',
					exportOptions: {
					columns: ':visible',
					columns: ":not(':last')"
					}
				},
				{
					extend: 'pdf',
					exportOptions: {
					columns: ':visible',
					columns: ":not(':last')"
					}
				},
				{
					extend: 'excel',
					exportOptions: {
					columns: ':visible',
					columns: ":not(':last')"
					}
				},
				{
					extend: 'print',
					exportOptions: {
					columns: ':visible',
					columns: ":not(':last')"
					}
				}
			]
			}
			],
		 initComplete: function () {
		        this.api()
		            .columns()
		            .every(function () {
		                let column = this;
		                let title = column.footer().textContent;
		 
		                // Create input element
		                let input = document.createElement('input');		                
		                input.placeholder = title;
		                column.footer().replaceChildren(input);
		               if(input.placeholder=="Date of Birth"){
		            	   input.addEventListener('focusout', () => {
			                	console.log("this.value date:::",this.value);
			                	if (column.search() !== this.value) {
			                        column.search(input.value).draw();
			                    }
			                });
		               }else{
		            	   input.addEventListener('keyup', () => {
			                	if (column.search() !== this.value) {
			                        column.search(input.value).draw();
			                    }
			                });   
		               }
		                
		                 var r = $('#registration-list tfoot tr');
		                r.find('th').each(function(){
		                  $(this).css('padding', 8);
		                  $(this).css('width',300);
		                });
		                $('#reg-search-div').append(r);
		                $('#search_0').css('text-align', 'center');
		                
		            });
		    }
	});  
	
	
	$('#reg-search-div').find('th:nth-child(5)').find("input").before('<label>Date of Birth</label>');
	$('#reg-search-div').find('th:nth-child(5)').find("input").attr("id", "search-date-of-birth");
	$('#reg-search-div').find('th:nth-child(5)').find("input").attr("placeholder", "DD-MM-YYYY");
	$('#reg-search-div').find('th:nth-child(5)').find("input").addClass("form-control datePicker");
	$('#reg-search-div').find('th:nth-child(1)').find("input").before('<label>Name</label>');
	$('#reg-search-div').find('th:nth-child(1)').find("input").attr("id", "search-name");
	$('#reg-search-div').find('th:nth-child(1)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(1)').find("input").attr("type","text");
	
	$('#reg-search-div').find('th:nth-child(8)').find("input").before('<label>Last Verified</label>');
	$('#reg-search-div').find('th:nth-child(8)').find("input").attr("id", "search-last-verified");
	$('#reg-search-div').find('th:nth-child(8)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(8)').find("input").attr("type","text");
	$('#reg-search-div').find('th:nth-child(8)').find("input").attr("placeholder", "Last Verified");
	
	$('#reg-search-div').find('th:nth-child(6)').find("input").before('<label>Verified Status</label>');
	$('#reg-search-div').find('th:nth-child(6)').find("input").attr("id", "search-status");
	$('#reg-search-div').find('th:nth-child(6)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(6)').find("input").attr("type","text");
		
	$('#reg-search-div').find('th:nth-child(3)').find("input").before('<label>Passport No</label>');
	$('#reg-search-div').find('th:nth-child(3)').find("input").attr("id", "search-passport");
	$('#reg-search-div').find('th:nth-child(3)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(3)').find("input").attr("type","text");
		
	$('#reg-search-div').find('th:nth-child(4)').find("input").before('<label>Omani Civil Id</label>');
	$('#reg-search-div').find('th:nth-child(4)').find("input").attr("id", "search-omani-civil-id");
	$('#reg-search-div').find('th:nth-child(4)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(4)').find("input").attr("type","text");
		
	$('#reg-search-div').find('th:nth-child(7)').find("input").before('<label>Verified Date</label>');
	$('#reg-search-div').find('th:nth-child(7)').find("input").attr("id", "search-verified-date");
	$('#reg-search-div').find('th:nth-child(7)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(7)').find("input").attr("type","text");
	
	$('#search-date-of-birth').datepicker({
		format : "dd-mm-yyyy",
		orientation : "bottom auto",
		autoclose : true
	}).on('change', function() {
		$('.datepicker').hide();
	});
	
	function getRegistrationData() {
		var name = $("#name").val();
		var civilId = $("#civilId").val();
		var passportNumber = $("#passportNumber").val();
		var dateOfBirth = $("#dateOfBirth").val();
		$.ajax({
			url : '${getRegistrationData}',
			async : false,
			data : {
				<portlet:namespace />name : name,
				<portlet:namespace />civilId : civilId,
				<portlet:namespace />passportNumber : passportNumber,
				<portlet:namespace />status : status,
				<portlet:namespace />dateOfBirth : dateOfBirth
			},
			type : 'POST',
			success : function(data) {
				$("#registrationHomeTable").html(data);
			},
		})
	}
	
	function validateAndSaveFormData(decision, modal) {
		
		var errorMessages = [];
		var paComments = document.getElementById(modal+"Comments").value;
		if (!paComments) {
			errorMessages.push("<liferay-ui:message key='please-enter-comments' />");
			document.getElementById("errorContainer-"+modal+"-comments").textContent = "<liferay-ui:message key='please-enter-comments' />";
		} else {
			document.getElementById("errorContainer-"+modal+"-comments").textContent = "";
		}
		
		if (errorMessages.length > 0) {
			event.preventDefault();
		} else {
			document.getElementById(modal+"Decision").value = decision;
			document.getElementById(modal+"FM").submit();
		}
	}
</script>