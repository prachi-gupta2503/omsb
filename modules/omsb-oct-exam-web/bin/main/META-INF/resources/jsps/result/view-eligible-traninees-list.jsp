<%@ include file="../../init.jsp"%>


<portlet:renderURL var="backToOCExamScheduleList">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
</portlet:renderURL>

<portlet:actionURL var="downloadTraineeListURL"
	name="<%=MVCCommandNames.DOWNLOAD_TRAINEE_LIST%>">
</portlet:actionURL>

<portlet:actionURL name="<%=MVCCommandNames.SEND_NOTIFICATION_ACTION%>"
	var="sendNotificationURL">
</portlet:actionURL>

<!-- Inner Wrapper Contents -->
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<liferay-ui:message key="admin-view-trainee-screen" />
				</div>
			</div>
			<div class="omsb-list-filter">
				<div class="row">
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="trainee-name" /></label> <input
								type="text" name="traineeName" id="traineeName"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="omsb-id" /></label> <input
								type="text" name="omsbId" id="omsbId" class="form-control">
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="status" /></label> <select 
								name="omsbStatus" id="omsbStatus" 
								class="custom-select form-control">
								<option value="">
									<liferay-ui:message key="select" />
								</option>
								<option value="Registered">
									<liferay-ui:message key="registered" /></option>
								<option value="Not Registered">
									<liferay-ui:message key="not-registered" /></option>
								<option value="Withdrawn">
									<liferay-ui:message key="withdrawn" /></option>
							</select>
						</div>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button search-trainees" onclick="searchEligibleTraineeList()">
						<liferay-ui:message key="search" />
					</button>
				</div>

			</div>
			
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables eligibileTraineeTable" id="traineeTable">
					<thead>
						<tr>
							<th class="no_sorting">
								<div class="custom-control custom-checkbox d-inline-block">
									<input type="checkbox" class="custom-control-input"
										id="selectAll" name="authorize"> <label
										class="custom-control-label m-0" for="authorize"></label>
								</div>
							</th>
							<th><liferay-ui:message key="trainee-name" /></th>
							<th><liferay-ui:message key="omsb-id" /></th>
							<%-- <th><liferay-ui:message key="omsb-status-id" /></th> --%>
							<th><liferay-ui:message key="action" /></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${traineeList}" var="trainee">
							<tr>
								<td><div class="custom-control custom-checkbox ">
										<input type="checkbox" class="custom-control-input"
											id="authorize" name="authorize"> <label
											class="custom-control-label m-0" for="authorize"></label>
									</div></td>

								<portlet:renderURL var="registrationFormRender">
									<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.REGISTRATION_FORM%>" />
									<portlet:param name="oCExamScheduleId" value="${trainee.scheduleId}" />
									<portlet:param name="lrUserId" value="${trainee.getLrUserId()}" />
									<portlet:param name="role" value="admin" />
								</portlet:renderURL>


								<td>${trainee.getName()}</td>
								<td>${trainee.getLrUserId()}</td>
								<%-- <td>${trainee.getSectionId()}</td> --%>
								<td>
									<c:choose>
										<c:when test="${trainee.getRegistrationStatus() eq 'registered'}">
											<button class="btn register_btn" title="Registered" disabled="disabled">
												<liferay-ui:message key="registered" />
											</button>									
										</c:when>
										<c:when test="${trainee.getRegistrationStatus() eq 'pending'}">
											<portlet:actionURL name="<%=MVCCommandNames.UPDATE_EXAM_REGISTRATION_STATUS%>"
												var="updateExamRegistrationStatusURL">
												<portlet:param name="id" value="${trainee.getRegistrationId()}"/>										
											</portlet:actionURL>
											<a href= "${updateExamRegistrationStatusURL}" >
												<button class="btn register_btn" title="<liferay-ui:message key="pending" />" >
													<liferay-ui:message key="pending" />
												</button>    
											</a>                                
										</c:when>
										<c:when test="${trainee.getRegistrationStatus() ne 'registered'}">
											<a href="${registrationFormRender}">
												<button class="btn register_btn" title="Register">
													<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
													<liferay-ui:message key="register" />
												</button>
											</a>
										</c:when>
									</c:choose>
									</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<form action="<%=downloadTraineeListURL%>" name="traineeListForm"
				id="traineeListForm" method="post">
				<input type="hidden" name="<portlet:namespace />selectedRows" id="<portlet:namespace />selectedRows"></input>
				 <input type="hidden" name="<portlet:namespace />examTitle" value= "${examTitle}">
			</form>
			<aui:input type="hidden" name="selectedTrainees" id="selectedTrainees"></aui:input>
			
			<div class="bottom-backbtn-wrap">
					<div class="row">
							<a onclick="downloadSelectedTrainees()" class="btn omsb-bc-red-button">
								<liferay-ui:message key="download" /></a>
							<a class="btn omsb-bc-red-button" type="button" onclick="setNotificationValues()" data-toggle="modal" data-target="#notification_pop_up">
								<liferay-ui:message key="send-notification" /></a>
							<a class="btn omsb-btn btn-back" href="${backToOCExamScheduleList}"><i
								class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
					</div>
			</div>
		</div>
	</div>
</div>




 <!-- send notification popup-code -->
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
								<textarea name="comment" class="form-control textEditor3" rows="5"
									id="comment">
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
<!-- send notification popup-code -->








<!--// Inner Wrapper Contents -->

<!--- Start JS files Here --->
<script type="text/javascript" src=".././js/popper.min.js"></script>
<script type="text/javascript"
	src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src=".././js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">



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









	$("[data-bs-toggle='dropdown']").click(function() {
		$(this).siblings("ul.dropdown-menu").toggleClass("show");
	})

	$(document)
			.ready(
					function() {
						var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

						trigger.click(function() {
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

						$('[data-toggle="offcanvas"]').click(function() {
							$('#omsb-main-wrapper').toggleClass('toggled');
						});
					});

	//search table data
	/* var searchTable = $('.eligibileTraineeTable').DataTable();
	$(".search-trainees").on(
			'click',
			function() {
				console.log('calling this click fns::');

				var traineeName = $('#traineeName').val();
				var omsbId = $('#omsbId').val();
				var status = $('#omsbStatus').val();

				searchTable.columns().every(
						function(index) {
							searchTable.column(index).search('').draw();
							if (index == 1) {
								if (traineeName) {
									console.log('traineeName not empty:');
									searchTable.column(index).search(
											traineeName).draw();
								}
							}
							if (index == 2) {
								if (omsbId) {
									console.log('omsbId not empty:');
									searchTable.column(index).search(omsbId)
											.draw();
								}
							}
							if (index == 3) {
								if (status) {
									var regex = '^' + status + '$';
									console.log('status not empty:');
									searchTable.column(index).search(regex,
											true, false).draw();
								}
							}
						});
		});

	
	 */
	
	
	function setNotificationValues() {
		  var editorField = $('#comment').val();
		  var table = document.getElementById("traineeTable");
		  var tableBody = table.getElementsByTagName("tbody")[0];
		  var checkboxes = tableBody.getElementsByTagName("input");
		  var checkboxValues = [];

		  for (var i = 0; i < checkboxes.length; i++) {
		    if (checkboxes[i].checked) {
		      var row = checkboxes[i].closest("tr");
		      var traineeName = row.cells[1].innerText;
		      var omsbId = row.cells[2].innerText;
		      var omsbStatusId = row.cells[3].innerText;

		      var selectedRow = {
		    	traineeName: traineeName,
		    	omsbId: omsbId,
		    	omsbStatusId: omsbStatusId,
		      };
		      checkboxValues.push(selectedRow);
		    }
		  }
		  $("#<portlet:namespace />editor").val(editorField);
		  $("#<portlet:namespace />traineeData").val(JSON.stringify(checkboxValues));
		  
		  $("#cancelpopUpId").click();
	}
	
	function downloadSelectedTrainees() {
		var table = document.getElementById("traineeTable");
		var tableBody = table.getElementsByTagName("tbody")[0];
		var checkboxes = tableBody.getElementsByTagName("input");
		var checkboxValues = [];

		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				var row = checkboxes[i].closest("tr");
				var firstName = row.cells[1].innerText;
				var omsbId = row.cells[2].innerText;

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
	
	 var traineeTable = $('#traineeTable').DataTable({
	       "bLengthChange": false,
	       dom: 'Bfrtip',
	       buttons: [
	    	   {
	               extend: 'colvis',
	               hide: [1]
	           },
	           {
	               extend: 'collection',
	               text: 'Export As',
	               buttons: ['copy', 'excel', 'csv', 'pdf', 'print']
	           }

	       ]
	   }); 
	function searchEligibleTraineeList(){
		var traineeName = $("#traineeName").val();
		var omsbId = $("#omsbId").val();
		var omsbStatus = $("#omsbStatus").val();
		traineeTable.columns().search('').draw(); // Clear previous search
		traineeTable.column(1).search(traineeName).column(2).search(omsbId).column(3).search(omsbStatus).draw();
	}
	
</script>
<style>
#traineeTable_wrapper .dataTables_filter {display: none;}
</style>