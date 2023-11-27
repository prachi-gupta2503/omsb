<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommands.GET_ADMIN_TRAINEE_LIST%>"
	var="getAdminTraineeListURL">
</portlet:resourceURL>

<portlet:actionURL var="downloadTraineeListURL"
	name="<%=MVCCommands.DOWNLOAD_TRAINEE_LIST%>">
	<portlet:param name="cmd" value="downloadTraineeList" />
</portlet:actionURL>

<portlet:actionURL name="<%=MVCCommands.SEND_EMAIL_NOTIFICATION%>"
	var="sendNotificationURL">
</portlet:actionURL>


<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="pagetitle">
					<liferay-ui:message key="list-of-eligible-trainees" />
				</div>
			</div>
			<div class="omsb-list-filter ">
				<div class="row">
					<%-- <div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="program-name" />
						</label> <label class="label-content">${programName}</label>
					</div> --%>

					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="exam-type" />
						</label> <label class="label-content">${examType}</label>
					</div>
					<c:if test="${not empty trainees[0].examSchedule.examDate}">
						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message
									key="exam-date" /></label> <label class="label-content">${trainees[0].examSchedule.examDate}</label>
						</div>
					</c:if>
					<c:if
						test="${not empty trainees[0].examSchedule.examStartDate && not empty trainees[0].examSchedule.examEndDate}">
						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message
									key="exam-start-date" /></label> <label class="label-content">${trainees[0].examSchedule.examStartDate}</label>
						</div>

						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message key="exam-end-date" />
							</label> <label class="label-content">${trainees[0].examSchedule.examEndDate }</label>
						</div>
					</c:if>
				</div>
			</div>
			<div>
				<div class="row">
					<button class="btn omsb-bc-red-button m-0" id="search_ineligible">
						<liferay-ui:message key="search-for-in-eligible-candidate" />
					</button>
				</div>
				<div class="row d-none search-cand">
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="name" /></label> 
								<input type="text" name="name" id="name" class="form-control">
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="email" /></label> 
								<input type="text" name="email" id="email" class="form-control">
						</div>
					</div>
					
					<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button m-0"
						onclick="getTraineeList()">
						<liferay-ui:message key="search" />
					</button>
				</div>
				</div>
			</div>
			<div class="omsb-list-filter ">
				<div class="row">
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="trainee-name" /></label> 
								<input type="text" name="traineename" id="trainee_name" class="form-control">
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="omsb-id" /></label> 
								<input type="text" name="OMSBID" id="omsb_id" class="form-control">
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="program-name" /></label> 
								<input type="text" name="programname" id="program_name" class="form-control">
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="status" /></label> <select
								name="status" id="status" class="custom-select form-control">
								<option value="">
									<liferay-ui:message key="select" />
								</option>
								<option value="Registered">
									<liferay-ui:message key="registered" /></option>
								<option value="register">
									<liferay-ui:message key="register" /></option>
								<option value="registration-pending">
									<liferay-ui:message key="registration-pending" /></option>
							</select>
						</div>
					</div>
					
				</div>

				<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button m-0"
						onclick="traineeFilterSearch()">
						<liferay-ui:message key="search" />
					</button>
				</div>
			</div>

			<div class="omsb-list-view table-responsive" id="eligible-trainee-list">
				<table class="display omsb-datatables" id="traineeTable">
					<thead>
						<tr>
							<th class="no_sorting">
								<div class="custom-control custom-checkbox ">
									<input type="checkbox" class="custom-control-input"
										id="selectAll" name="authorize"> <label
										class="custom-control-label m-0" for="authorize"></label>
								</div>
							</th>
							<th><liferay-ui:message key="program-name" /></th>
							<th><liferay-ui:message key="trainee-name" /></th>
							<th><liferay-ui:message key="omsb-id" /></th>
							<th><liferay-ui:message key="payment-receipt" /></th>
							<th><liferay-ui:message key="action" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="trainee" items="${trainees}">
						
							<tr>
							<c:set var="commaSeparatedString" value="" />
							<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.lrUserId};" />
							<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.name};" />
			<%-- 				<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.dateOfBirth};" /> --%>
							<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.nationality};" />
							<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.gender};" />
							<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.passportNumber};" />
							<c:set var="commaSeparatedString" value="${commaSeparatedString}${trainee.emailAddress};" />
								<td><div class="custom-control custom-checkbox ">
										<input type="checkbox" class="custom-control-input"
											id="authorize" name="authorize"> <label
											class="custom-control-label m-0" for="authorize"></label>
									</div></td>
								<td>${trainee.programName}</td>	
								<td data-toggle="modal" data-edd="${commaSeparatedString}"  data-target="#edupop1"><a>${trainee.name}</a></td>
								<td>${trainee.lrUserId}</td>
								
								<c:choose>
									<c:when test="${not empty trainee.paymentReceiptUrl}">
										<td><a href="${trainee.paymentReceiptUrl}" target="_blank"><liferay-ui:message key="payment-receipt" /></a></td>
									</c:when>
									<c:otherwise>
										  <td>--</td>
									</c:otherwise>
								</c:choose>	
								
								<td><portlet:renderURL var="registrationFormURl">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.SAVE_REGISTRATION%>" />
										<portlet:param name="programId" value="${trainee.programId}" />
										<portlet:param name="examTypeId" value="${trainee.examTypeId}" />
										<portlet:param name="examScheduleId" value="${trainee.examSchedule.id}" />
										<portlet:param name="lrUserId" value="${trainee.lrUserId}" />
										<portlet:param name="regCmd" value="regCmd" />
										<portlet:param name="cmd" value="registration" />
										<portlet:param name="role" value="admin" />
									</portlet:renderURL>
									<div class="buttons_wrap">
									<c:choose>
										<c:when test="${(trainee.registrationStatus eq 'Registered') or (trainee.registrationStatus eq 'Withdrawn')}">
											<button disabled class="btn register_btn" title="Register">
												<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
													<liferay-ui:message key="registered" />
											</button>
										</c:when>
										<c:when test="${(trainee.registrationStatus eq'Pending')}">
											<a class="btn register_btn" onclick="paymentConfirmation(${trainee.examSchedule.id},${trainee.lrUserId})">
														<liferay-ui:message key="pay-now" />
										</c:when>
										<c:otherwise>
											  <a href="${registrationFormURl}">
													<button class="btn register_btn" title="Register">
														<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
															<liferay-ui:message key="register" />
													</button>
											  </a>
										</c:otherwise>
									</c:choose>	
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="bottom-backbtn-wrap">
				<portlet:renderURL var="viewExamScheduleURL">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommands.EXAMS_SCHEDULE_LIST%>" />
				</portlet:renderURL>

				<button onclick="downloadSelectedTrainees()"
					class="btn omsb-bc-red-button">
					<liferay-ui:message key="download" />
				</button>

				<button class="btn omsb-bg-red-button" type="button"
					onclick="setNotificationValues()" data-toggle="modal"
					data-target="#notification_pop_up">
					<liferay-ui:message key="send-notification" />
				</button>
				<a class="btn omsb-btn btn-back" href="${viewExamScheduleURL}"><i
					class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</div>
		</div>
	</div>
</div>

<form action="<%=downloadTraineeListURL%>" name="traineeListForm"
	id="traineeListForm" method="post">
	<input type="hidden" name="<portlet:namespace />selectedRows" id="<portlet:namespace />selectedRows"></input>
	<input type="hidden" name="<portlet:namespace />examType" id="<portlet:namespace />examType" value="${examType}"></input>
</form>

<%@ include file="../registration/payment-confirmation-popup.jsp"%>

<!-- Modal -->
<div class="modal fade omsb-modal" id=notification_pop_up tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="notification" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="${sendNotificationURL}" method="post"
				name="announce_exam">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<aui:input id="subject" label="subject" name="subject"
									type="text"></aui:input>
							</div>
						</div>

						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="hidden" name="traineeData" id="traineeData"></aui:input>
							</div>
						</div>

						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="body" /></label>
								<aui:input type="hidden" name="editor" id="editor"></aui:input>
								<textarea name="comment" class="form-control textEditor3" rows="5" id="comment">
									</textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button onClick="setNotificationValues()"
						class="btn omsb-bg-red-button">
						<liferay-ui:message key="send" />
					</button>
					<button type="button" id="cancelpopUpId" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal">
						<liferay-ui:message key="cancel" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<!-- popup 1 -->
<div class="modal fade" id="edupop1" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog information-box" role="document">
		<div class="modal-content">
			<div class="modal-header d-none">
				<h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="personal-details" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> 
					<span aria-hidden="true">&times;</span> 
				</button>
			</div>
			<div class="modal-body">
				<div class="omsb-label-view ">
					<div class="label-group-header row">
						<span><liferay-ui:message key="personal-details" /></span>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="row">

						<div class="col-md-3 label-box">
							<label class="label-name "><liferay-ui:message key="omsb-id" /></label> 
							<label class="label-content lruserid" id="lruserid">${trainee.lrUserId}</label>
						</div>
						<div class="col-md-3 label-box">
							<label class="label-name "><liferay-ui:message key="full-name" /></label> 
							<label class="label-content full-name" id="fullname">${trainee.name}</label>
						</div>
					 	<%-- <div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message key="date-of-birth" /></label> 
							<label class="label-content date-of-birth">${trainee.dateOfBirth}</label>
						</div> --%>
						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message key="nationality" /></label> 
							<label class="label-content nationality">${trainee.nationality}</label>
						</div>
						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message key="gender" /></label> 
							<label class="label-content gender">${trainee.gender}</label>
						</div>
						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message key="passport-number" /></label> 
							<label class="label-content passport-number">${trainee.passportNumber}</label>
						</div> 
						<div class="col-md-3 label-box">
							<label class="label-name"><liferay-ui:message key="email-address" /></label> 
							<label class="label-content email-address">${trainee.emailAddress}</label>
						</div> 
					</div>
				</div>
			</div>
			<div class="modal-footer d-none">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="close" /></button>
				<button type="button" class="btn btn-primary"><liferay-ui:message key="save-changes" /></button>
			</div>
		</div>
	</div>
</div>
<!-- popup1 -->
<script>
var traineeTable =	$('#traineeTable').DataTable({
    "bLengthChange": false,
    dom: 'Bfrtip',
	buttons: [
		{
          extend: 'colvis',
          text: '<liferay-ui:message key="column-visibility" />',
          columns: ":not(':last')"
        },
	    {
	        extend: 'collection',
	        text: '<liferay-ui:message key="export-as" />',
	        buttons: [
	            {
	                extend: 'csv',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'pdf',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'excel',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'print',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            }
	        ]
	    }
	],
});
	

	const selectAllCheckbox = document.getElementById('selectAll');
	const checkboxes = document.querySelectorAll('.custom-control-input');
	
	selectAllCheckbox.addEventListener('change', function () {
	    checkboxes.forEach(checkbox => {
	        checkbox.checked = selectAllCheckbox.checked;
	    });
	});

	checkboxes.forEach(checkbox => {
	    checkbox.addEventListener('change', function () {
	        // Uncheck "Select All" if any individual checkbox is unchecked
	        if (!this.checked) {
	            selectAllCheckbox.checked = false;
	        }
	        // Check if all individual checkboxes are checked and update "Select All" accordingly
	        else if (document.querySelectorAll('.custom-control-input:checked').length === checkboxes.length) {
	            selectAllCheckbox.checked = true;
	        }
	    });
	});
	
	
	
	function getTraineeList() {
		var name = $("#name").val();
		var email = $("#email").val();
		var examTypeId = "${trainee.examTypeId}";
		var examDefinitionId = "${trainee.examDefinitionId}";
		/* var programId = "${trainee.programId}"; */
		var examScheduleId = "${trainees[0].examSchedule.id}";
		var getAdminTraineeListURL = "${getAdminTraineeListURL}";
		$.ajax({
			url : getAdminTraineeListURL,
			async : false,
			data : {
				<portlet:namespace />name : name,
				<portlet:namespace />email : email,
				/* <portlet:namespace />programId : programId, */
				<portlet:namespace />examTypeId : examTypeId,
				<portlet:namespace />examDefinitionId : examDefinitionId,
				<portlet:namespace />examScheduleId : examScheduleId,
			},
			type : 'POST',
			success : function(data) {
				console.log("data" + data);
				$("#eligible-trainee-list").html(data);
			},
		})
	}
	$('.datePicker').datepicker({
		format : "dd/mm/yyyy",
		orientation : "bottom auto",
		autoclose : true
	}).on('change', function() {
		$('.datepicker').hide();
	});

	function downloadSelectedTrainees() {
		var table = document.getElementById("traineeTable");
		var tableBody = table.getElementsByTagName("tbody")[0];
		var checkboxes = tableBody.getElementsByTagName("input");
		var checkboxValues = [];

		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				var row = checkboxes[i].closest("tr");
				var firstName = row.cells[2].innerText;
				var omsbId = row.cells[3].innerText;

				var selectedRow = {
					firstName : firstName,
					omsbId : omsbId,
				};
				checkboxValues.push(selectedRow);
			}
		}
		$("#<portlet:namespace />selectedRows").val(JSON.stringify(checkboxValues));
		document.getElementById("traineeListForm").submit();
	}
	
	function setNotificationValues() {
		  var editorField = $('#comment').val();
		  var table = document.getElementById("traineeTable");
		  var tableBody = table.getElementsByTagName("tbody")[0];
		  var checkboxes = tableBody.getElementsByTagName("input");
		  var checkboxValues = [];

		  for (var i = 0; i < checkboxes.length; i++) {
		    if (checkboxes[i].checked) {
		      var row = checkboxes[i].closest("tr");
		      var firstName = row.cells[2].innerText;
		      var omsbId = row.cells[3].innerText;

		      var selectedRow = {
		        firstName: firstName,
		        omsbId: omsbId,
		      };
		      checkboxValues.push(selectedRow);
		    }
		  }
		  $("#<portlet:namespace />editor").val(editorField);
		  $("#<portlet:namespace />traineeData").val(JSON.stringify(checkboxValues));
		  
		  $("#cancelpopUpId").click();
	}
	
	$("#search_ineligible").on("click", function(){
		$(".search-cand").removeClass('d-none');
	});
	/* search functionality */
	function traineeFilterSearch(){
		
	    var programName = $("#program_name");
	    var traineeName = $("#trainee_name");
	    var omsbId = $("#omsb_id");
	    var status = $("#status");
	  	console.log("omsbId:" +omsbId)
	  
	    traineeTable.columns().search('').draw(); // Clear previous search
	    traineeTable.column(3).search(omsbId.val()).column(1).search(programName.val()).column(2).search(traineeName.val()).column(5).search(status.val()).draw();
	}
	
	
	
	$('#edupop1').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var rowContent = button.data('edd');
		  var recipientState = button.data('state');
		  var array = rowContent.split(";");
		  console.log("",array);
		  var modal = $(this)
		  modal.find('.lruserid').text(array[0]);
		  modal.find('.full-name').text(array[1]);
	/* 	  modal.find('.date-of-birth').text(array[2]); */
		  modal.find('.nationality').text(array[2]);
		  modal.find('.gender').text(array[3]);
		  modal.find('.passport-number').text(array[4]); 
		  modal.find('.email-address').text(array[5]); 
		 
		})
		
		
		
</script>
<style>
#traineeTable_wrapper .dataTables_filter {display: none;}
</style>