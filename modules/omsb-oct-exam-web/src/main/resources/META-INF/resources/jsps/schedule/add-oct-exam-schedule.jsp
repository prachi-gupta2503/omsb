<%@ include file="../../init.jsp"%>

<portlet:renderURL var="viewOCTScheduledExams">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
</portlet:renderURL>

<liferay-portlet:actionURL
	name="<%=MVCCommandNames.ADD_OCT_EXAM_SCHEDULE_ACTION%>"
	var="examScheduleActions" />

<portlet:resourceURL
	id="<%=MVCCommandNames.GET_DROPDOWN_LIST_MVC_RESOURCE%>"
	var="getDropdownListURL" />

<!-- Inner Wrapper Contents -->
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					<div class="pagetitle">${octExamTitle}</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center"
						id="myTab" role="tablist">
						
						<c:choose>
								<c:when test="${action eq 'edit'}">
									<c:choose>
										<c:when test="${examSchedule.isRepeatedInstance()}">
											<li class="nav-item"><a class="nav-link active"
												id="repeatedinstance-tab" data-toggle="tab"
												href="#repeatedinstance" role="tab"
												aria-controls="repeatedinstance" aria-selected="false"><liferay-ui:message
														key="repeated-instance" /></a></li>
										
										</c:when>
									<c:otherwise>
										<li class="nav-item"><a class="nav-link active"
											id="singledatesingleinstance-tab" data-toggle="tab"
											href="#singledatesingleinstance" role="tab"
											aria-controls="singledatesingleinstance" aria-selected="true"><liferay-ui:message
													key="single-date-single-instance" /></a></li>
						
									</c:otherwise>
								</c:choose>
							</c:when>
						<c:when test="${action eq 'add'}">
						
						<li class="nav-item"><a class="nav-link active"
							id="singledatesingleinstance-tab" data-toggle="tab"
							href="#singledatesingleinstance" role="tab"
							aria-controls="singledatesingleinstance" aria-selected="true"><liferay-ui:message
									key="single-date-single-instance" /></a></li>
						<li class="nav-item"><a class="nav-link"
							id="repeatedinstance-tab" data-toggle="tab"
							href="#repeatedinstance" role="tab"
							aria-controls="repeatedinstance" aria-selected="false"><liferay-ui:message
									key="repeated-instance" /></a></li>
						</c:when>
						</c:choose>
					</ul>
				</div>

				<div class="col-lg-12 mt-4">
					<div class="tab-content" id="v-pills-tabContent">
					<c:choose>
									<c:when test="${action eq 'edit'}">
										<c:choose>
											<c:when test="${examSchedule.isRepeatedInstance()}">
												<div class="tab-pane fade show active" id="repeatedinstance" role="tabpanel"
													aria-labelledby="repeatedinstance-tab">
													<%@ include file="./add-oct-exam-schedule-repeated-instance.jsp"%>
												</div>
											</c:when>
										<c:otherwise>			
											
												<div class="tab-pane fade show active"
													id="singledatesingleinstance" role="tabpanel"
													aria-labelledby="singledatesingleinstance-tab">
													<%@ include file="./add-oct-exam-schedule-single-instance.jsp"%>
												</div>
											
										</c:otherwise>
									</c:choose>
								</c:when>
									<c:when test="${action eq 'add'}">
							<div class="tab-pane fade show active"
								id="singledatesingleinstance" role="tabpanel"
								aria-labelledby="singledatesingleinstance-tab">
								<%@ include file="./add-oct-exam-schedule-single-instance.jsp"%>
							</div>
							<div class="tab-pane fade" id="repeatedinstance" role="tabpanel"
								aria-labelledby="repeatedinstance-tab">
								<%@ include file="./add-oct-exam-schedule-repeated-instance.jsp"%>
							</div>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--// Inner Wrapper Contents -->

<!--discard SI popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-si-discard"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="discard-confirmation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div>
						<liferay-ui:message key="confirmation-text" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" onclick="discardSIForm()"
					type="button" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>
<!--discard SI popup  -->

<!-- delete RI popup -->
<div class="modal fade omsb-modal" id="exam-schedule-ri-delete"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="delete-confirmation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div>
						<liferay-ui:message key="confirmation-text" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" onclick="deleteRIElement()"
					type="button" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>
<!--delete RI popup  -->


<!--discard RI popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-ri-discard"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="discard-confirmation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div>
						<liferay-ui:message key="confirmation-text" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" onclick="discardRIForm()"
					type="button" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>
<!--discard RI popup  -->


<script type="text/javascript">

$("[data-bs-toggle='dropdown']").click(function() {
	$(this).siblings("ul.dropdown-menu").toggleClass("show");
});

$(document).ready(function() {
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
</script>
<script>
$(document).ready(function () {
	  var today = new Date();
	
	  $('#siRegistrationStartDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true,
	    startDate: today
	  }).on('changeDate', function (selected) {
	    var startDate = new Date(selected.date.valueOf());
	    $('#siRegistrationEndDate').datepicker('setStartDate', startDate);
	  });
	
	  $('#siRegistrationEndDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true
	  }).on('changeDate', function (selected) {
	    var endDate = new Date(selected.date.valueOf());
	    $('#siExamDate').datepicker('setStartDate', endDate);
	  });
	
	  $('#siExamDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true
	  });
});


$(document).ready(function () {
  var today = new Date();
  $('#riRegistrationStartDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true,
	    startDate: today,
	  }).on('changeDate', function (selected) {
	    var registrationStartDate = new Date(selected.date.valueOf());
	    $('#riRegistrationEndDate').datepicker('setStartDate', registrationStartDate);
	  });

	  $('#riRegistrationEndDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true,
	  }).on('changeDate', function (selected) {
	    var registrationEndDate = new Date(selected.date.valueOf());
	    $('#riExamStartDate').datepicker('setStartDate', registrationEndDate);
	  });

  $('#riExamStartDate').datepicker({
    format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    startDate: today,
  }).on('changeDate', function (selected) {
    var examStartDate = new Date(selected.date.valueOf());
    $('#riExamEndDate').datepicker('setStartDate', examStartDate);
  });

  $('#riExamEndDate').datepicker({
    format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
  }).on('changeDate', function (selected) {
    var examEndDate = new Date(selected.date.valueOf());
    $('#riExamStartDate').datepicker('setEndDate', examEndDate);
  });
});


var delcnt= 0;
function setDeleteRIData(delElmt){
	delcnt++;
	$(delElmt).attr('data-id', 'delitem_'+delcnt)
	$('#exam-schedule-ri-delete').attr('data-element', 'delitem_'+delcnt);
}

function deleteRIElement(){
	var mdid = $('#exam-schedule-ri-delete').attr('data-element');
	$('[data-id="'+mdid+'"]').closest(".ridataset").remove();
	 $("#exam-schedule-ri-delete").modal("hide");
}

function validateAndSubmitScheduleForm(formType, action, event){
	if(action ==="saveAsDraft"){
		document.getElementById('<portlet:namespace />'+formType+'CMD').value = '<%=DataflowConstants.NOT_ANNOUNCED%>';
	}
	
	if(formType.toLowerCase() === 'si'){
		validateAndSubmitSIScheduleForm(event);
	}else if(formType.toLowerCase() === 'ri'){
		validateAndSubmitRIScheduleForm(event);	
	}
}

function validateAndSubmitSIScheduleForm(event) {
	
	var siRegistrationStartDate = document
			.getElementById("siRegistrationStartDate").value;
	var siRegistrationEndDate = document
			.getElementById("siRegistrationEndDate").value;
	var siExamDate = document.getElementById("siExamDate").value;
	var siNoOfSeats = document.getElementById("siNoOfSeats").value;
	var siVenue = document.getElementById("siVenue").value;
	var siTrainingSiteId = document.getElementById("siTrainingSiteId").value;
	var siExamSlotsId = document.getElementById("siExamSlotsId").value;
	var siLocationOnGoogleMap = $('#siLocateOnGoogleMap').val();
	
	var isValidationFailed=false;
		
	document.getElementById("errorContainer-siRegistrationStartDate").textContent = "";
	document.getElementById("errorContainer-siRegistrationEndDate").textContent = "";
	document.getElementById("errorContainer-siExamDate").textContent = "";
	document.getElementById("errorContainer-siNoOfSeats").textContent = "";
	document.getElementById("errorContainer-siVenue").textContent = "";
	document.getElementById("errorContainer-siTrainingSite").textContent = "";
	document.getElementById("errorContainer-siExamSlots").textContent = "";
	document.getElementById("errorContainer-siLocationOnGoogleMap").textContent = "";
	
	if (!siRegistrationStartDate) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siRegistrationStartDate").textContent = "<liferay-ui:message key='enter-registration-start-date' />";
	}
	
	if (!siRegistrationEndDate) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siRegistrationEndDate").textContent = "<liferay-ui:message key='enter-registration-end-date' />";
	}
	
	if (!siExamDate) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siExamDate").textContent = "<liferay-ui:message key='enter-exam-date' />";
	}
	
	if (!siNoOfSeats) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siNoOfSeats").textContent = "<liferay-ui:message key='enter-no-of-seats' />";
	}
	
	if (!siTrainingSiteId) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siTrainingSite").textContent = "<liferay-ui:message key='select-training-site' />";
	}
	
	if (!siExamSlotsId) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siExamSlots").textContent = "<liferay-ui:message key='select-exam-slots' />";
	}
	
	
	if (!siVenue) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siVenue").textContent = "<liferay-ui:message key='enter-venue' />";
	}
	
	if (siLocationOnGoogleMap =="" || siLocationOnGoogleMap == undefined) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siLocationOnGoogleMap").textContent = "<liferay-ui:message key='enter-location' />";
	}

	if (isValidationFailed) {
		return;
	} else {
		
		document.getElementById("siForm").submit();
	}
}

function validateAndSubmitRIScheduleForm(event) {debugger
	if(validateRepeatedInstanceform("completeForm")){
		submitRIForm();
	};
}

function validateRICommonField(fieldName, errorMessage, event) {
	  var field = document.getElementById(fieldName);
	  var errorContainer = document.getElementById('errorContainer-' + fieldName);
	  if (field && field.value === '') {
	    event.preventDefault();
	    errorContainer.innerHTML = errorMessage;
	    errorContainer.classList.add('error-message');
	  } else {
	    errorContainer.classList.remove('error-message');
	  }
	}

	function validateRIRepeatedField(examInstance, instanceNumber, event) {
		
		var daysOfWeek = examInstance.querySelector('[name$="riDaysOfWeek"]');
		var daysOfWeekError = examInstance
				.querySelector('.error-container-daysOfWeek');
		if (daysOfWeek && daysOfWeek.value === '') {
			event.preventDefault();
			if (!daysOfWeekError) {
				daysOfWeekError = document.createElement('p');
				daysOfWeekError.id = 'errorContainer-riDaysOfWeek-' + instanceNumber;
				daysOfWeekError.classList.add('error-container');
				daysOfWeekError.classList.add('error-container-daysOfWeek');
				daysOfWeek.parentNode.appendChild(daysOfWeekError);
			}
			daysOfWeekError.innerHTML = '<liferay-ui:message key="enter-days-of-week" />';
			daysOfWeekError.classList.add('error-message');
		} else {
			if (daysOfWeekError) {
				daysOfWeekError.innerHTML = '';
				daysOfWeekError.classList.remove('error-message');
			}
		}
		
		var trainingSite = examInstance.querySelector('[name$="riTrainingSite"]');
		var trainingSiteError = examInstance
				.querySelector('.error-container-trainingSite');
		if (trainingSite && trainingSite.value === '') {
			event.preventDefault();
			if (!trainingSiteError) {
				trainingSiteError = document.createElement('p');
				trainingSiteError.id = 'errorContainer-riTrainingSite-' + instanceNumber;
				trainingSiteError.classList.add('error-container');
				trainingSiteError.classList.add('error-container-trainingSite');
				trainingSite.parentNode.appendChild(trainingSiteError);
			}
			trainingSiteError.innerHTML = '<liferay-ui:message key="select-training-site" />';
			trainingSiteError.classList.add('error-message');
		} else {
			if (trainingSiteError) {
				trainingSiteError.innerHTML = '';
				trainingSiteError.classList.remove('error-message');
			}
		}
		
		var examSlotList = examInstance.querySelector('[name$="riExamSlotList"]');
		var examSlotListError = examInstance
				.querySelector('.error-container-examSlotList');
		if (examSlotList && examSlotList.value === '') {
			event.preventDefault();
			if (!examSlotListError) {
				examSlotListError = document.createElement('p');
				examSlotListError.id = 'errorContainer-riExamSlotList-' + instanceNumber;
				examSlotListError.classList.add('error-container');
				examSlotListError.classList.add('error-container-examSlotList');
				examSlotList.parentNode.appendChild(examSlotListError);
			}
			examSlotListError.innerHTML = '<liferay-ui:message key="select-exam-slot-list" />';
			examSlotListError.classList.add('error-message');
		} else {
			if (examSlotListError) {
				examSlotListError.innerHTML = '';
				examSlotListError.classList.remove('error-message');
			}
		}
	  
	  var noOfSeats = examInstance.querySelector('[name$="riNoOfSeats"]');
	  var noOfSeatsError = examInstance.querySelector('.error-container-seats');
	  if (noOfSeats && noOfSeats.value === '') {
	    event.preventDefault();
	    if (!noOfSeatsError) {
	    	noOfSeatsError = document.createElement('p');
	    	noOfSeatsError.id = 'errorContainer-riNoOfSeats-' + instanceNumber;
	    	noOfSeatsError.classList.add('error-container');
	    	noOfSeatsError.classList.add('error-container-seats');
	    	noOfSeats.parentNode.appendChild(noOfSeatsError);
	    }
	    noOfSeatsError.innerHTML =  '<liferay-ui:message key="enter-no-of-seats" />';
	    noOfSeatsError.classList.add('error-message');
	  } else {
	    if (noOfSeatsError) {
	    	noOfSeatsError.innerHTML = '';
	    	noOfSeatsError.classList.remove('error-message');
	    }
	  }  
	
	}

function discardSIForm() {
	/* document.getElementById('siRegistrationStartDate').value = '';
	document.getElementById('siRegistrationEndDate').value = '';
	document.getElementById('siTrainingSiteId').value = '';
	document.getElementById('siExamSlotsId').value = '';
	document.getElementById('siExamDate').value = '';
	document.getElementById('siNoOfSeats').value = '';
	document.getElementById('siVenue').value = '';
	document.getElementById('siLocationOnGoogleMap').value = ''; */
	
	location.reload(true);
	
	$("#exam-schedule-si-discard").modal("hide");
}

function discardRIForm() {
	/* document.getElementById('riRegistrationStartDate').value = '';
	document.getElementById('riRegistrationEndDate').value = '';
	document.getElementById('riExamStartsFrom').value = '';
	document.getElementById('riExamEndsOn').value = '';
	var repeatedInstances = document.querySelectorAll('#repeatedInstance .omsb-card');

	var daysOfWeek = document.getElementsByName('<portlet:namespace/>riDaysOfWeek');
	var trainingSite = document.getElementsByName('<portlet:namespace/>riTrainingSite');
	var examSlots = document.getElementsByName('<portlet:namespace/>riExamSlotList');
	var venues = document.getElementsByName('<portlet:namespace/>riVenue');
	var locationOnGoogleMaps = document.getElementsByName('<portlet:namespace/>riLocationOnGoogleMap');
	var locateOnGoogleMaps = document.getElementsByName('<portlet:namespace/>riLocateOnGoogleMap');
	var noOfSeats = document.getElementsByName('<portlet:namespace/>riNoOfSeats');

	for (var i = 0; i < daysOfWeek.length; i++) {
		daysOfWeek[i].value = '';
		trainingSite[i].value = '';
		examSlots[i].value = '';
		/* venues[i].value = '';
		locationOnGoogleMaps[i].value = '';
		locateOnGoogleMaps[i].value = ''; 
		noOfSeats[i].value = '';
	} */

/* 	repeatedInstances.forEach(function(instance) {
		instance.querySelector('select[name="<portlet:namespace/>riDaysOfWeek"]').value = '';
		instance.querySelector('input[name="<portlet:namespace/>riTrainingSite"]').value = '';
		instance.querySelector('input[name="<portlet:namespace/>riExamSlotList"]').value = '';
		/* instance.querySelector('input[name="<portlet:namespace/>riVenue"]').value = '';
		instance.querySelector('input[name="<portlet:namespace/>riLocationOnGoogleMap"]').value = '';
		instance.querySelector('input[name="<portlet:namespace/>riLocateOnGoogleMap"]').value = '';
		instance.querySelector('input[name="<portlet:namespace/>riNoOfSeats"]').value = '';
	}); */
	
	location.reload(true);
	$("#exam-schedule-ri-discard").modal("hide");
}

function submitRIForm() {
	
	var additionalFields = document.querySelectorAll('.repeated-instance .omsb-card');
	var repeatedInstanceValues = [];
	
	
	 	$("#Repeated_dates_Table tbody tr").each(function() {
			        var rowData = {};
					var tableData = $(this).children("td").map(function () {
				    	return $(this).text();
						}).get();
				var addedValues = {
							dayOfWeek : $.trim(tableData[6].trim()),
							trainingSite : $.trim(tableData[5].trim()),
							examSlotList : $.trim(tableData[7].trim()),
							noOfSeats : $.trim(tableData[3].trim()),
							id : $.trim(tableData[4].trim())
							
					};
				repeatedInstanceValues.push(addedValues);debugger
				console.log("repeatedInstanceValues::", repeatedInstanceValues);
		});
	
	$("#repeatedInstanceDuplicateRowValues").val(JSON.stringify(repeatedInstanceValues));
	console.log("repeatedInstanceValues::", $("#repeatedInstanceDuplicateRowValues").val());
	document.getElementById("riForm").submit();	
}

function getSelectValues(select) {
	  var result = [];
	  var options = select && select.options;
	  var opt;

	  for (var i=0, iLen=options.length; i<iLen; i++) {
	    opt = options[i];

	    if (opt.selected) {
	      result.push(opt.value || opt.text);
	    }
	  }
	  return result;
	}

let riRowCount = 2; 
function addRIRow() {
	
	/* document.getElementById("errorContainer-riDaysOfWeek-"+3).textContent = "";
	document.getElementById("errorContainer-riExamStartTime-"+3).textContent = "";
	document.getElementById("errorContainer-riExamEndTime-"+3).textContent = "";
	document.getElementById("errorContainer-riNoOfSeats-"+3).textContent = "";
	document.getElementById("errorContainer-riLocateOnGoogleMap-"+3).textContent = "";
	document.getElementById("errorContainer-riVenue-"+3).textContent = "";  */
	
	var newRIRow = document.querySelector('#rid_template .omsb-card').cloneNode(true);
	var clonedSelectors = newRIRow.querySelectorAll('select');
	/* let newRowRIExamSlotListId = null; */
	clonedSelectors.forEach(function(select) {
		if(select.name == '<portlet:namespace/>riExamSlotList'){
			select.setAttribute("id", "riExamSlotsId-"+riRowCount);
			select.setAttribute("data-attr", riRowCount);
			/* newRowRIExamSlotListId =  "riExamSlotList-"+riRowCount; */
		}
		if(select.name == '<portlet:namespace/>riDaysOfWeek'){
			select.setAttribute("id", "riDaysOfWeek-"+riRowCount);
			select.setAttribute("data-attr", riRowCount);
			/* newRowRIExamSlotListId =  "riExamSlotList-"+riRowCount; */
		}
		if(select.name == '<portlet:namespace/>riTrainingSite'){
			select.setAttribute("id", "riTrainingSiteId-"+riRowCount);
			select.setAttribute("data-attr", riRowCount);
		}
	});
	document.getElementById('repeatedInstance').appendChild(newRIRow);
	/* let curRILocateOnGoogleMapElem = document.getElementById(newRowRILocateOnGoogleMapId);
	curRILocateOnGoogleMapElem.parentElement.parentElement.nextSibling.nextElementSibling.nextElementSibling.childNodes[1].setAttribute("id", "rimap"+riRowCount);
	curRILocateOnGoogleMapElem.parentElement.parentElement.nextSibling.nextElementSibling.nextElementSibling.childNodes[3].setAttribute("id", "riInfoWindowContent"+riRowCount);
	setMap(curRILocateOnGoogleMapElem); */
	refreshForm(riRowCount);
	runRIDelete();
	riRowCount++
}

function refreshForm(riRowCount){
	$('#riExamSlotsId-'+riRowCount).multiselect();
}

function runRIDelete(){
	$('.ri_delete').click(function(){
	    var ri_numItems = $('#repeatedInstance .ridataset').length;
		$(this).closest(".ridataset").remove();
	});
}
</script>

<!-- Google Map Integration -->
<script type="text/javascript">
function setMap(autocInput){
	
	if(autocInput != null){
		var options = {
			fields: ["place_id", "formatted_address", "geometry", "name"],
		    strictBounds: false,
		    types: ["establishment"],
		};
		const acInputId = autocInput.id;
		const acInput = document.getElementById(acInputId);
		const esType = acInput.getAttribute("data-instance");
		const rowNo = acInput.getAttribute("data-attr");
		
		const infowindow = new google.maps.InfoWindow();
		const infowindowContent = document.getElementById(esType+"InfoWindowContent"+rowNo);
		infowindow.setContent(infowindowContent);
		const map = new google.maps.Map(document.getElementById(esType+"map"+rowNo), {
			center: { lat: 23.59100, lng:  58.38259 },
			zoom: 8
		});
		const marker = new google.maps.Marker({
	    	map,
	    	anchorPoint: new google.maps.Point(0, -29)
		});
		marker.addListener("click", () => {
		    infowindow.open({
		      anchor: marker,
		      map
			});
		});
		const autocomplete = new google.maps.places.Autocomplete(acInput, options);
		autocomplete.inputId = acInputId;
		autocomplete.addListener("place_changed", () => {
			infowindow.close();
			marker.setVisible(false);
			const place = autocomplete.getPlace();
			if (!place.geometry || !place.geometry.location) {

				return;
			} else {
				document.getElementById($('#'+autocomplete.inputId).parent('div').find('input')[1].id).value = place.place_id;
			}
			if (place.geometry.viewport) {
				map.fitBounds(place.geometry.viewport);
			} else {
				map.setCenter(place.geometry.location);
				map.setZoom(8);
			}
			marker.setPosition(place.geometry.location);
			marker.setVisible(true);
			infowindowContent.children["place-name"].textContent = place.name;
			infowindowContent.children["place-address"].textContent = place.formatted_address;
			infowindow.open(map, marker);
		});
		var placeId = document.getElementById(acInputId).getAttribute("data-place");
		
        if(placeId){
            var request = {
                placeId: placeId,
                fields: ["name", "formatted_address", "place_id", "geometry"],
            };
            const service = new google.maps.places.PlacesService(map);
            service.getDetails(request, (place, status) => {
                if ( status === google.maps.places.PlacesServiceStatus.OK && place && place.geometry && place.geometry.location ) {
					
                	document.getElementById(acInputId).value = place.name+', '+place.formatted_address;
                	
                    map.setCenter(place.geometry.location);
                    map.setZoom(8);

                    marker.setPosition(place.geometry.location);
                    marker.setVisible(true);
                    infowindowContent.children["place-name"].textContent = place.name;
                    infowindowContent.children["place-address"].textContent = place.formatted_address;
                    infowindow.open(map, marker);
                }
            });
        }
	}
}

function initMap() {
    var acInputs = null;
    var examScheduleId = '${examSchedule.id}';
    var locationOnGoogleMap = '${examSchedule.locationOnGoogleMap}';
    acInputs = document.getElementsByClassName("autocompleteMap");    
    
    if(acInputs.length > 0){
        for (var i = 0; i < acInputs.length; i++) {
            setMap(acInputs[i]);            
        }
    }
}
function validateInputFieldForSchdlForm(id,errorId,errorText){
	var keyVal = $('#'+id).val();
	if (keyVal != undefined && keyVal != '') {
		document.getElementById(errorId).textContent = "";
	    return true;
	} else {
		document.getElementById(errorId).textContent = errorText;
		
	    return false;
	}
}

function validateGoogleMapField(id,errorId,errorText){
	var keyVal = $('#'+id).val();
	if (keyVal != undefined && keyVal != '') {
		 $('#'+errorId).addClass('d-none');
	    return true;
	} else {
		$('#'+errorId).removeClass('d-none');
		
	    return false;
	}
}

window.initMap = initMap;



</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly"
	defer></script>
<!-- <script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAM97fJa4kw2f6dSHQ3mFTmTdKyZ8FrbLw&callback=initMap&libraries=places&v=weekly"
	defer></script> -->	
<!-- End Google Map Integration -->
<!--// End JS files Here --->
