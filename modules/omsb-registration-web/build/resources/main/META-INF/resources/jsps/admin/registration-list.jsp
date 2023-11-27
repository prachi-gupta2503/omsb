<%@ include file="../../init.jsp"%>

<style>
  .omsb-datatables thead tr th:nth-child(5){
    display: none;
}

.omsb-datatables tbody tr td:nth-child(5){
    display: none;
} 
#reg-search-div tr th:nth-child(2), #reg-search-div tr th:nth-child(5), #reg-search-div tr th:nth-child(8){
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
					<a href="<%=addPersonalDetailsURL%>" class="btn omsb-bc-red-button">
											<liferay-ui:message key="create-new-registration" />
										</a>
					</div>
			</div>
              
              
				<%-- <div>
					<div class="omsb-list-filter">
						<div class="row">
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="name" /></label> <input
										type="text" id="name" name="name" class="form-control">
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="civil-id" /></label> <input
										type="text" id="civilId" name="civilId" class="form-control">
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="passport-no" /></label> <input
										type="text" id="passportNumber" name="passportNumber"
										class="form-control">
								</div>
							</div>
							<div class="col-lg-3 col-md-6">
								<div class="form-group">
									<label><liferay-ui:message key="date-of-birth" /></label> <input
										type="text" name="dateOfBirth" id="dateOfBirth"
										placeholder="DD-MM-YYYY" class="form-control datePicker">
								</div>
							</div>
						</div>
						<div class="filter-button-wrap">
							<button class="btn omsb-bc-red-button"
								onclick="getRegistrationData()">
								<liferay-ui:message key="search" />
							</button>
						</div>
					</div>
				</div> --%>
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
									<th><liferay-ui:message key="civil-id" /></th>
									<th><liferay-ui:message key="date-of-birth" /></th>
									<th><liferay-ui:message key="status" /></th>
									<th><liferay-ui:message key="omsb-associated"/></th>
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
										<td>${registration.getOmsbAssociated()}</td> 
										<td width="229">
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
														<li><a href="${adminEditRegistrationURL}" class="dropdown-item">
																<img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg">
																<liferay-ui:message key="edit" />
															</a>
														</li>
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
									<th><liferay-ui:message key="civil-id" /></th>
									<th><liferay-ui:message key="date-of-birth" /></th>
									<th><liferay-ui:message key="status" /></th>
									<th><liferay-ui:message key="omsb-assosiated" /></th>
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

	 /*  $('#registration-list').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"order": []
	});  */
    
	  new DataTable('#registration-list', {
			"bLengthChange" : false,
			"order": [],
		 initComplete: function () {
		        this.api()
		            .columns()
		            .every(function () {
		                let column = this;
		                console.log("column>>>>",column);
		                let title = column.footer().textContent;
		 
		                // Create input element
		                let input = document.createElement('input');
		                
		                input.placeholder = title;
		                column.footer().replaceChildren(input);
		 				
		                console.log("input placeholder::::",input.placeholder);
		              	//console.log("input ::::",input.attr('id'));
		                
		                
		                // Event listener for user input
		               if(input.placeholder=="Date of Birth"){
		            	   console.log("its date of birth");
		            	   input.addEventListener('focusout', () => {
			                	console.log("this.value date:::",this.value);
			                	if (column.search() !== this.value) {
			                        column.search(input.value).draw();
			                    }
			                });
		               }else{
		            	   input.addEventListener('keyup', () => {
		            		   console.log("this.value other:::",this.value);
			                	if (column.search() !== this.value) {
			                        column.search(input.value).draw();
			                    }
			                });   
		               }
		                
		               /*  input.addEventListener('keyup', () => {
		                	
		                	if (column.search() !== this.value) {
		                        column.search(input.value).draw();
		                    }
		                }); */
		                
		                
		                /* input.addEventListener('keyup', () => {
		                    if (column.search() !== this.value) {
		                        column.search(input.value).draw();
		                    }
		                }); */
		                
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
	//$('#reg-search-div').find('th:nth-child(5)').find("input").attr("type", "date");
	$('#reg-search-div').find('th:nth-child(5)').find("input").addClass("form-control datePicker");
	
	
	$('#reg-search-div').find('th:nth-child(1)').find("input").before('<label>Name</label>');
	$('#reg-search-div').find('th:nth-child(1)').find("input").attr("id", "search-name");
	$('#reg-search-div').find('th:nth-child(1)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(1)').find("input").attr("type","text");
	
	
	$('#reg-search-div').find('th:nth-child(7)').find("input").before('<label>OMSB Assosiated</label>');
	$('#reg-search-div').find('th:nth-child(7)').find("input").attr("id", "search-assosiated");
	$('#reg-search-div').find('th:nth-child(7)').find("input").addClass("form-control");
	$('#reg-search-div').find('th:nth-child(7)').find("input").attr("type","text");
	$('#reg-search-div').find('th:nth-child(7)').find("input").attr("placeholder", "OMSB Assosiated");
	
	$('#reg-search-div').find('th:nth-child(6)').find("input").before('<label>Status</label>');
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
	 /* $(".dropdown-toggle").click(function () {
		console.log("toggle clicked ::::");
	    $(this).siblings().toggleClass("show");
	});*/
</script>