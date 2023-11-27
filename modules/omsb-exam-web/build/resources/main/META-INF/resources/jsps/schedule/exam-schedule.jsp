<%@ include file="../../init.jsp"%>

<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_EXAM_SCHEDULE%>" var="announceScheduleExamURL" >
</liferay-portlet:actionURL>
<portlet:resourceURL id="<%=MVCCommands.SAVE_EXAM_MD_SCHEDULE%>" var="saveExamSceduleDetailURL" />

<div class="main-content">
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info m-0">
						<div class="pagetitle">
							<liferay-ui:message key="exam-schedule" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
						<input type="hidden" id="examScheduleAdminID" name="<portlet:namespace/>examScheduleAdminID" value="">
							<ul class="nav nav-pills omsb-nav-pills justify-content-center"
								id="myTab" role="tablist">
								<c:choose>
								<c:when test="${action eq 'edit'}">
									<c:choose>
										<c:when test="${examSchedule.multiDates}">
											<li class="nav-item"><a class="nav-link active"
												id="multipledatemultipleinstance-tab" data-toggle="tab"
												href="#multipledatemultipleinstance" role="tab"
												aria-controls="multipledatemultipleinstance"
												aria-selected="false">
												<liferay-ui:message key="multiple-date-multiple-instance" /></a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="nav-item"><a class="nav-link active"
												id="singledatesingleinstance-tab" data-toggle="tab"
												href="#singledatesingleinstance" role="tab"
												aria-controls="singledatesingleinstance" aria-selected="true">
												<liferay-ui:message key="single-date-single-instance" /></a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${action eq 'add'}">
									<%-- <li class="nav-item"><a class="nav-link active"
										id="singledatesingleinstance-tab" data-toggle="tab"
										href="#singledatesingleinstance" role="tab"
										aria-controls="singledatesingleinstance" aria-selected="true"><liferay-ui:message
												key="single-date-single-instance" /></a></li> --%>
									<li class="nav-item"><a class="nav-link active"
										id="multipledatemultipleinstance-tab" data-toggle="tab"
										href="#multipledatemultipleinstance" role="tab"
										aria-controls="multipledatemultipleinstance"
										aria-selected="true"><liferay-ui:message
												key="multiple-date-multiple-instance" /></a></li>
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
											<c:when test="${examSchedule.multiDates}">
												<div class="tab-pane fade show active" id="multipledatemultipleinstance"
													role="tabpanel"
													aria-labelledby="multipledatemultipleinstance-tab">
													<%@ include file="./multiple-dates-exam-schedule.jsp"%>
												</div>
											</c:when>
											<c:otherwise>
												<div class="tab-pane fade show active"
													id="singledatesingleinstance" role="tabpanel"
													aria-labelledby="singledatesingleinstance-tab">
													<%@ include file="./single-instance-exam-schedule.jsp"%>
												</div>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:when test="${action eq 'add'}">
										<%-- <div class="tab-pane fade show active"
											id="singledatesingleinstance" role="tabpanel"
											aria-labelledby="singledatesingleinstance-tab">
											<%@ include file="./single-instance-exam-schedule.jsp"%>
										</div> --%>
										<div class="tab-pane fade show active" id="multipledatemultipleinstance"
											role="tabpanel"
											aria-labelledby="multipledatemultipleinstance-tab">
											<%@ include file="./multiple-dates-exam-schedule.jsp"%>
										</div>
										<div class="tab-pane fade" id="repeatedinstance"
											role="tabpanel" aria-labelledby="repeatedinstance-tab">
											<%@ include file="./repeated-instance-exam-schedule.jsp"%>
										</div>
								    </c:when>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<!--delete MD popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-md-delete" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
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
				<button class="btn omsb-bc-red-button" onclick="deletemdelement()" type="button" title="ok">
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
<!--delete MD popup  -->


<!--delete RI popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-ri-delete" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
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
				<button class="btn omsb-bc-red-button" onclick="deleterielement()" type="button" title="ok">
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



<!--discard SI popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-si-discard" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
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
				<button class="btn omsb-bc-red-button" onclick="discardSIForm()" type="button" title="ok">
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



<!--discard MI popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-md-discard" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
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
				<button class="btn omsb-bc-red-button" onclick="discardMDForm()" type="button" title="ok">
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
<!--discard MI popup  -->



<!--discard RI popup  -->
<div class="modal fade omsb-modal" id="exam-schedule-ri-discard" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
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
				<button class="btn omsb-bc-red-button" onclick="discardRIForm()" type="button" title="ok">
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






<script>

$('#programMi').multiselect();
$('#programRi').multiselect();
$('#riDaysOfWeek').multiselect();
$('#riDaysOfWeek1').multiselect();

$(document).ready(function () {
	  var today = new Date();

	  $('#siApplicationStartDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true,
	    startDate: today
	  }).on('changeDate', function (selected) {
	    var startDate = new Date(selected.date.valueOf());
	    $('#siApplicationEndDate').datepicker('setStartDate', startDate);
	  });

	  $('#siApplicationEndDate').datepicker({
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
var jsmdAppEndDate = new Date();

$(document).ready(function () {
	  var today = new Date();

	  $('#mdApplicationStartDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true,
	    startDate: today
	  }).on('changeDate', function (selected) {
	    var startDate = new Date(selected.date.valueOf());
	    $('#mdApplicationEndDate').datepicker('setStartDate', startDate);
	  });

	  $('#mdApplicationEndDate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true
	  }).on('changeDate', function (selected) {
	    var endDate = new Date(selected.date.valueOf());
	    jsmdAppEndDate = endDate;
	    $('.examdate').datepicker('setStartDate', endDate);
	    $('.examdate').val('');
	  });
	  call_multidatepicker();
	 
	});
function call_multidatepicker(){
	$('.examdate').datepicker({
	    format: "dd/mm/yyyy",
	    orientation: "bottom auto",
	    autoclose: true,
	    startDate: jsmdAppEndDate
	  });
}


$(document).ready(function () {
  var today = new Date();

  $('#riExamStartsFrom').datepicker({
    format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
    startDate: today,
  }).on('changeDate', function (selected) {
    var examStartDate = new Date(selected.date.valueOf());
    $('#riExamEndsOn').datepicker('setStartDate', examStartDate);
  });

  $('#riExamEndsOn').datepicker({
    format: "dd/mm/yyyy",
    orientation: "bottom auto",
    autoclose: true,
  }).on('changeDate', function (selected) {
    var examEndDate = new Date(selected.date.valueOf());
    $('#riExamStartsFrom').datepicker('setEndDate', examEndDate);
  });
});


var delcnt= 0;

function setdeletembdata(delElmt){
	delcnt++;
	$(delElmt).attr('data-id', 'delitem_'+delcnt)
	$('#exam-schedule-md-delete').attr('data-element', 'delitem_'+delcnt);
}

function deletemdelement(){
	var mdid = $('#exam-schedule-md-delete').attr('data-element');
	console.log("deleelmt"+mdid);
	$('[data-id="'+mdid+'"]').closest(".mddateset").remove();
	 $("#exam-schedule-md-delete").modal("hide");
}

function setdeleteridata(delElmt){
	delcnt++;
	$(delElmt).attr('data-id', 'delitem_'+delcnt)
	$('#exam-schedule-ri-delete').attr('data-element', 'delitem_'+delcnt);
}

function deleterielement(){
	var mdid = $('#exam-schedule-ri-delete').attr('data-element');
	console.log("deleelmt"+mdid);
	$('[data-id="'+mdid+'"]').closest(".ridateset").remove();
	 $("#exam-schedule-ri-delete").modal("hide");
}




function multipleInstanceFormValidation(event) {
	
	var isFormValid = validateExamScheduleForm("completeForm");
	
	  if (isFormValid) {
		  setMDValues();
	  }
}

function repeatedInstanceFormValidation(event) {
	var isFormValid = validateExamRepeatedInstance("completeForm");
	
	  if (isFormValid) {
		  setRIValues();
	}
	 
}


function setNotAnnouncedExamStatus(requestFrom, status){
	console.log("exam Status:::"+status);
	$('#mdCMDValId').val("Not Announced");
	$('#riCMDStatusId').val("Not Announced");
	if(requestFrom.toUpperCase() === 'si'.toUpperCase()){
	} else if(requestFrom.toUpperCase() === 'md'.toUpperCase()){
	setMDValues();
	} else if(requestFrom.toUpperCase() === 'ri'.toUpperCase()){
	setRIValues();
	}
	}

function discardSIForm() {
	
	location.reload(true);
	$("#exam-schedule-si-discard").modal("hide");
}

function setMDValues() {
	var values = [];
	$("#Multiple_dates_Table tbody tr").each(function() {
        var rowData = {};
		var tableData = $(this).children("td").map(function () {
	    	return $(this).text();
    	}).get();
		var addedValues = {
					examDate : $.trim(tableData[0]),
					startTime : $.trim(tableData[1]),
					endTime : $.trim(tableData[2]),
					locationOnGoogleMap : $.trim(tableData[3]),
					locationPinOnGoogleMap : $.trim(tableData[4]),
					venue : $.trim(tableData[5]),
					id : $.trim(tableData[6])
		};
		values.push(addedValues);
    }); 
	
	
	var selectedElements = document.getElementById("programMi");
	
	var selectedValues = [];
	for (var i = 0; i < selectedElements.options.length; i++) {
	    if (selectedElements.options[i].selected) {
	        selectedValues.push(selectedElements.options[i].value);
	    }
	}
	
	$("#multiDatesDuplicateRowValues").val(JSON.stringify(values));
	
	$("#selectedValues").val(JSON.stringify(selectedValues));
	
	document.getElementById("miForm").submit();
}

function run_mddelete(){
	$('.md_delete').click(function(){
	    var md_numItems = $('#md_container .mddateset').length;
		$(this).closest(".mddateset").remove();		
	});
}

function discardMDForm() {
	location.reload(true);
	$("#exam-schedule-md-discard").modal("hide");
}

function discardRIForm() {
	location.reload(true);
	$("#exam-schedule-ri-discard").modal("hide");
}

function setRIValues() {
	console.log("Set Repeated Instance Function Gets Called :::");
	var additionalFields = document.querySelectorAll('.repeated-instance .omsb-card');
	var repeatedInstanceValues = [];
	
	$("#Repeated_dates_Table tbody tr").each(function() {
        var rowData = {};
		var tableData = $(this).children("td").map(function () {
	    	return $(this).text();
    	}).get();
		var addedValues = {
				riDaysOfWeek : $.trim(tableData[0]),
				riExamStartTime : $.trim(tableData[1]),
				riExamEndTime : $.trim(tableData[2]),
				riNoOfSeats : $.trim(tableData[3]),
				riLocationOnGoogleMap : $.trim(tableData[4]),
				riLocationPinOnGoogleMap : $.trim(tableData[5]),
				mdVenue : $.trim(tableData[6]),
					id : $.trim(tableData[7])
		};
		repeatedInstanceValues.push(addedValues);
    }); 
	
	var selectedElements = document.getElementById("programRi");
	
	var selectedValues = [];
	for (var i = 0; i < selectedElements.options.length; i++) {
	    if (selectedElements.options[i].selected) {
	        selectedValues.push(selectedElements.options[i].value);
	    }
	}
	//var jObject = {"JObject" : repeatedInstanceValues};
	
	$("#riSelectedValuesId").val(JSON.stringify(selectedValues));
	
	$("#riMultiDatesDuplicateRowValues").val(JSON.stringify(repeatedInstanceValues));
	console.log($("#riMultiDatesDuplicateRowValues").val());
	document.getElementById("riForm").submit();	
}



function run_ridelete(){
	$('.ri_delete').click(function(){
	    var ri_numItems = $('#repeatedInstance .ridateset').length;
		$(this).closest(".ridateset").remove();
	});
}
</script>

<script type="text/javascript" >

function validateProgramNameSelection(id,errorId){
	var selectedElements = document.getElementById(id);

	var selectedValues = [];
	for (var i = 0; i < selectedElements.options.length; i++) {
	    if (selectedElements.options[i].selected) {
	        selectedValues.push(selectedElements.options[i].value);
	    }
	}
	if(selectedValues.length >0){
		 $('#'+errorId).addClass('d-none');
		 return true;
	}else{
		  $('#'+errorId).removeClass('d-none');
		  return false;
	}
	
}


function validateSelectAndInputField(id,errorId){
	var keyVal = $('#'+id).val();
    if (keyVal != undefined && keyVal != '') {
        $('#'+errorId).addClass('d-none');
        return true;
    } else {
        $('#'+errorId).removeClass('d-none');
        return false;
    }
    
}

$('.mdExamStartTime').on('change', function() {
	$('#mdExamStartTimeError').addClass('d-none');
	    var date = $('.mdExamStartTime').val().split(':');

	    var hours = date[0];
	    var minutes = date[1];

	    $('#examStartTimeHidden').val(ampm(hours, minutes));
	});
	
$('.mdExamEndTime').on('change', function() {
	$('#mdExamEndTimeError').addClass('d-none');
	    var date = $('.mdExamEndTime').val().split(':');

	    var hours = date[0];
	    var minutes = date[1];

	    $('#examEndTimeHidden').val(ampm(hours, minutes));
	});
	
$('.riExamStartTime').on('change', function() {
	  
    var date = $('.riExamStartTime').val().split(':');

    var hours = date[0];
    var minutes = date[1];

    $('#riExamStartTimeHidden').val(ampm(hours, minutes));
});
$('.riExamEndTime').on('change', function() {
  
    var date = $('.riExamEndTime').val().split(':');

    var hours = date[0];
    var minutes = date[1];

    $('#riExamEndTimeHidden').val(ampm(hours, minutes));
});

	function ampm(hours, minutes) {
	    var ampm = hours >= 12 ? 'pm' : 'am';
	    hours = hours % 12 || 12;
	    minutes = minutes || 0;
	    minutes = minutes < 10 ? '0'+minutes : minutes;
	    return hours + ':' + minutes + ' ' + ampm;
	}

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
				window.alert("No details available for input: '" + place.name + "'");
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

window.initMap = initMap;

function validateExamScheduleForm(key){debugger;
	
	$('.mdErrorClass').addClass('d-none');
	$('#formError').addClass('d-none');
	
	if(key == "partialForm"){
		var programMi= validateProgramNameSelection('programMi','programMiError');
		var mdApplicationStartDate= validateSelectAndInputField('mdApplicationStartDate','mdApplicationStartDateError');
		var mdApplicationEndDate= validateSelectAndInputField('mdApplicationEndDate','mdApplicationEndDateError');
		var mdNoOfSeats= validateSelectAndInputField('mdNoOfSeats','mdNoOfSeatsError');
		var mdExamStartDate= validateSelectAndInputField('mdExamStartDate','mdExamStartDateError');
		var mdExamStartTime= validateSelectAndInputField('mdExamStartTime','mdExamStartTimeError');
		var mdExamEndTime= validateSelectAndInputField('mdExamEndTime','mdExamEndTimeError');
		var mdLocateOnGoogleMap1= validateSelectAndInputField('mdLocateOnGoogleMap1','mdLocateOnGoogleMap1Error');
		var mdVenue= validateSelectAndInputField('mdVenue','mdVenueError');
		
		if( programMi && mdApplicationStartDate && mdApplicationEndDate  && mdNoOfSeats  && mdExamStartDate  && 
				mdExamStartTime  && mdExamEndTime  && mdLocateOnGoogleMap1 && mdVenue){
			return true;
		}else{
			return false;
		}
	}if(key == "completeForm"){
		
		if($("#Multiple_dates_Table tbody tr").length == 0){
			$('#formError').removeClass('d-none');
			return false;
		}else{
			var programMi= validateProgramNameSelection('programMi','programMiError');
			var mdApplicationStartDate= validateSelectAndInputField('mdApplicationStartDate','mdApplicationStartDateError');
			var mdApplicationEndDate= validateSelectAndInputField('mdApplicationEndDate','mdApplicationEndDateError');
			var mdNoOfSeats= validateSelectAndInputField('mdNoOfSeats','mdNoOfSeatsError');
			
			if( programMi && mdApplicationStartDate && mdApplicationEndDate  && mdNoOfSeats){
				$('#formError').addClass('d-none');
				return true;
			}else{
				$('#formError').removeClass('d-none');
				return false;
			}
		}
		
		
	}
	
}
function validateExamRepeatedInstance(key){
	$('.riErrorClass').addClass('d-none');
	$('#riFormError').addClass('d-none');
	
	if(key == "partialForm"){
		var riVenue = validateSelectAndInputField('riVenue','riVenueError');
		var riLocateOnGoogleMap1 = validateSelectAndInputField('riLocateOnGoogleMap1','riLocateOnGoogleMap1Error');
		var riNoOfSeats = validateSelectAndInputField('riNoOfSeats','riNoOfSeatsError');
		var riDaysOfWeek = validateSelectAndInputField('riDaysOfWeek','riDaysOfWeekError');
		var riExamEndsOn = validateSelectAndInputField('riExamEndsOn','riExamEndsOnError');
		var riExamStartsFrom = validateSelectAndInputField('riExamStartsFrom','riExamStartsFromError');
		var riApplicationEndsDaysBefore = validateSelectAndInputField('riApplicationEndsDaysBefore','riApplicationEndsDaysBeforeError');
		var riApplicationStartDaysBefore = validateSelectAndInputField('riApplicationStartDaysBefore','riApplicationStartDaysBeforeError');
		var programRi = validateProgramNameSelection('programRi','programRiError');
		
		if( programRi && riApplicationStartDaysBefore && riApplicationEndsDaysBefore  && riExamStartsFrom  && riExamEndsOn  && 
				riDaysOfWeek  && riNoOfSeats  && riLocateOnGoogleMap1 && riVenue){
			return true;
		}else{
			return false;
		}
	}if(key == "completeForm"){
		
		if($("#Repeated_dates_Table tbody tr").length == 0){
			$('#riFormError').removeClass('d-none');
			return false;
		}else{
			var riExamEndsOn = validateSelectAndInputField('riExamEndsOn','riExamEndsOnError');
			var riExamStartsFrom = validateSelectAndInputField('riExamStartsFrom','riExamStartsFromError');
			var riApplicationEndsDaysBefore = validateSelectAndInputField('riApplicationEndsDaysBefore','riApplicationEndsDaysBeforeError');
			var riApplicationStartDaysBefore = validateSelectAndInputField('riApplicationStartDaysBefore','riApplicationStartDaysBeforeError');
			var programRi = validateProgramNameSelection('programRi','programRiError');
			
			if( programMi && mdApplicationStartDate && mdApplicationEndDate  && riExamStartsFrom && riExamEndsOn){
				$('#riFormError').addClass('d-none');
				return true;
			}else{
				$('#riFormError').removeClass('d-none');
				return false;
			}
		}
		
	}
	
}
function setDeleteMDId(id,link){
	var row = $(link).closest("tr");
	$(link).closest("tr").addClass("select_delete_row");
	
	$("#delete-education-confirm-modal").attr("exmMltDateId",id);
 	$("#delete-education-confirm-modal").data("row", row);
}
function deleteMDRowData() {
	var exmMltDateId = $("#delete-education-confirm-modal").attr("exmMltDateId");
	deleteAndEditMultiDates(exmMltDateId, "deleteDetails");
}

//Add Data on dataTable
function saveMultipleExamDates(){debugger;
	var values = []
	
	var isFormValid = validateExamScheduleForm("partialForm");	

	if(isFormValid){
		$('#formError').addClass('d-none');
		var addedValues = {
			 	//id : $('#examId').val(),
				examDate : $('.mdExamDate').val(),
				startTime : $('#examStartTimeHidden').val(),
				endTime :  $('#examEndTimeHidden').val(),
				locationOnGoogleMap : $('#mdLocateOnGoogleMap1').val(),
				locationPinOnGoogleMap : $('#mdLocationOnGoogleMap1').val(),
				venue : $('.mdVenue').val(),
				id :$('#editMdExmDetId').val()
			};
	 	values.push(addedValues);
	if($('#isEdit').val() == ""){
		$("#Multiple_dates_Table tbody tr").each(function() {
	        var rowData = {};
			var tableData = $(this).children("td").map(function () {
		    	return $(this).text();
	    	}).get();
			var addedValues = {
						examDate : $.trim(tableData[0]),
						startTime : $.trim(tableData[1]),
						endTime : $.trim(tableData[2]),
						locationOnGoogleMap : $.trim(tableData[3]),
						locationPinOnGoogleMap : $.trim(tableData[4]),
						venue : $.trim(tableData[5]),
						id : $.trim(tableData[6])
			};
			values.push(addedValues);
	    }); 
	}
		
		var examId=$('#examId').val();
		var examTypeId=$('#examTypeId').val();
		var programId=$('#programId').val();
		var mdApplicationStartDate=$('#mdApplicationStartDate').val();
		var mdApplicationEndDate=$('#mdApplicationEndDate').val();
		var mdNoOfSeats=$('#mdNoOfSeats').val();
		var examScheduleAdmnId= $('#examScheduleAdmnId').val();
		
		var cmd="saveDetails";
		var status="Pending"; //If user click on Add button
		
		
		var selectedElements = document.getElementById("programMi");

		var selectedValues = [];
		for (var i = 0; i < selectedElements.options.length; i++) {
		    if (selectedElements.options[i].selected) {
		        selectedValues.push(selectedElements.options[i].value);
		    }
		}
		
		
		$.ajax({
			url: '${saveExamSceduleDetailURL}',
			dataType : 'json',
			async : false,
			data : {
				<portlet:namespace />command : "saveDetails",
				<portlet:namespace />flowType : "multipleInstance",
				<portlet:namespace />examId : examId,
				<portlet:namespace />examTypeId : examTypeId,
				<portlet:namespace />mdApplicationStartDate : mdApplicationStartDate,
				<portlet:namespace />mdApplicationEndDate : mdApplicationEndDate,
				<portlet:namespace />mdNoOfSeats : mdNoOfSeats,
				<portlet:namespace />examScheduleAdminId : examScheduleAdmnId,
				<portlet:namespace />status : status,
				<portlet:namespace />values : JSON.stringify(values),
				<portlet:namespace />selectedValues : JSON.stringify(selectedValues)
				
				
			},
			type : 'POST',
			success : function(data) {
				
				
			},
			complete: function(data) {
				console.log(data);
				
				document.querySelector('input[name="<portlet:namespace/>mdExamEndTime"]').value='';
				document.querySelector('input[name="<portlet:namespace/>mdExamStartTime"]').value='';
				$('#examStartTimeHidden').val('');
				$('.locationOnGoogleMap').val('');
				$('#examEndTimeHidden').val('');
				$('#editMdExmDetId').val('')
				$('.mdExamDate').val('');
				$('.mdVenue').val(''); 
				$("#educationDetailsList").html(data.responseText.trim());
				$('#examScheduleAdmnId').val($('#updatedExamScheduleAdmnId').val());
				$('#examScheduleAdminID').val($('#updatedExamScheduleAdmnId').val());
				$('#isEdit').val('');
				
	        },
		})
		
	} else {
		$('#formError').removeClass('d-none');
	}
}

 function deleteAndEditMultiDates(examMultiDateId, command){

	var examId=$('#examId').val();
	var examTypeId=$('#examTypeId').val();
	var programId=$('#programId').val();
	var examScheduleAdminId= $('#updatedExamScheduleAdmnId').val();
		$.ajax({
			url: '${saveExamSceduleDetailURL}',
			async : false,
			data : {
				
				<portlet:namespace />command : "deleteDetails",
				<portlet:namespace />flowType : "multipleInstance",
				<portlet:namespace />examId : examId,
				<portlet:namespace />examTypeId : examTypeId,
				<portlet:namespace />examScheduleAdminId : examScheduleAdminId,
				<portlet:namespace />examMultiDateId : examMultiDateId
			},
			type : 'POST',
			success : function(data) {
				console.log('Success Function');
				$("#educationDetailsList").html(data.trim());
				$('#cancelBttn').click();
					
			},
			complete: function(data) {
				console.log(data);
			
	        },
		})
}

function editMultExamDateObject(examMultiDateId, command){

	var examId=$('#examId').val();
	var examTypeId=$('#examTypeId').val();
	var programId=$('#programId').val();
	var examScheduleAdminId= $('#updatedExamScheduleAdmnId').val();
	$('#isEdit').val('true');
		$.ajax({
			url: '${saveExamSceduleDetailURL}',
			async : false,
			data : {
				
				<portlet:namespace />command : "editDetails",
				<portlet:namespace />flowType : "multipleInstance",
				<portlet:namespace />examId : examId,
				<portlet:namespace />examTypeId : examTypeId,
				<portlet:namespace />examScheduleAdminId : examScheduleAdminId,
				<portlet:namespace />examMultiDateId : examMultiDateId
							
			},
			type : 'POST',
			success : function(data) {
				
				console.log('Success Function');
				const response = JSON.parse(data);
				if(response != undefined){
					$('.mdExamDate').val(response.examDate);
					$('#examStartTimeHidden').val(response.startTime);
					$('#examEndTimeHidden').val(response.endTime);
					var startTm=response.startTime.substring(0,response.startTime.indexOf(' '));
					var endTm=response.endTime.substring(0,response.endTime.indexOf(' '));
					var newstTm;
					var newEndTm;
					if(startTm.indexOf(":") == 1){
						newstTm= 0 + startTm; 
					}else{
						newstTm =startTm;
					}if(endTm.indexOf(":") == 1){
						newEndTm= 0 + endTm; 
					}else{
						newEndTm=endTm;
					}
					console.log('newstTm >> ' +newstTm + ' newEndTm >>'+newEndTm);
					document.querySelector('input[name="<portlet:namespace/>mdExamEndTime"]').value=newEndTm;
					document.querySelector('input[name="<portlet:namespace/>mdExamStartTime"]').value=newstTm;
					$('.locationOnGoogleMap').val(response.locationOnGoogleMap);
					$('#mdLocationOnGoogleMap1').val(response.locationPinOnGoogleMap);
					$('.mdVenue').val(response.venue);
					$('#editMdExmDetId').val(examMultiDateId);
					
				}
				
			},
			complete: function(data) {
				console.log(data);
			
	        },
		})
	
} 

<!-- Script for Repeated Instance-->
function saveUpdateRepeatedInstance(){debugger
var values = []
	
	var isFormValid = validateExamRepeatedInstance("partialForm");	

	if(isFormValid){
		$('#riFormError').addClass('d-none');
		var addedValues = {
			 	//id : $('#examId').val(),
				riDaysOfWeek : $('.riDaysOfWeek').val(),
				riExamStartTime :$('#riExamStartTimeHidden').val(),
				riExamEndTime :  $('#riExamEndTimeHidden').val(),
				riNoOfSeats :  $('#riNoOfSeats').val(),
				riLocationOnGoogleMap : $('#riLocateOnGoogleMap1').val(),
				riLocationPinOnGoogleMap : $('#riLocationOnGoogleMap').val(),
				mdVenue : $('#riVenue').val(),
				id :$('#editRiExmDetId').val()
			};
	 	values.push(addedValues);
	if($('#isRIEdit').val() == ""){
		$("#Repeated_dates_Table tbody tr").each(function() {
	        var rowData = {};
			var tableData = $(this).children("td").map(function () {
		    	return $(this).text();
	    	}).get();
			var addedValues = {
					riDaysOfWeek : $.trim(tableData[0]),
					riExamStartTime : $.trim(tableData[1]),
					riExamEndTime : $.trim(tableData[2]),
					riNoOfSeats : $.trim(tableData[3]),
					riLocationOnGoogleMap : $.trim(tableData[4]),
					riLocationPinOnGoogleMap :$.trim(tableData[5]),
					mdVenue : $.trim(tableData[6]),
						id : $.trim(tableData[7])
			};
			values.push(addedValues);
	    }); 
	}
		var examId=$('#examId').val();
		var examTypeId=$('#examTypeId').val();
		var programId=$('#programId').val();
		var riApplicationStartDaysBefore=$('#riApplicationStartDaysBefore').val();
		var riApplicationEndsDaysBefore=$('#riApplicationEndsDaysBefore').val();
		var riExamStartsFrom=$('#riExamStartsFrom').val();
		var riExamEndsOn=$('#riExamEndsOn').val();
		var examScheduleAdmnId= $('#riExamScheduleAdmnId').val();
		var cmd="saveDetails";
		var status="Pending"; //If user click on Add button
		var selectedElements = document.getElementById("programRi");

		var selectedValues = [];
		for (var i = 0; i < selectedElements.options.length; i++) {
		    if (selectedElements.options[i].selected) {
		        selectedValues.push(selectedElements.options[i].value);
		    }
		}
		
		
		$.ajax({
			url: '${saveExamSceduleDetailURL}',
			dataType : 'json',
			async : false,
			data : {
				<portlet:namespace />command : "saveDetails",
				<portlet:namespace />flowType : "repeatedInstance",
				<portlet:namespace />examId : examId,
				<portlet:namespace />examTypeId : examTypeId,
				<portlet:namespace />riApplicationStartDaysBefore : riApplicationStartDaysBefore,
				<portlet:namespace />riApplicationEndsDaysBefore : riApplicationEndsDaysBefore,
				<portlet:namespace />riExamStartsFrom : riExamStartsFrom,
				<portlet:namespace />riExamEndsOn : riExamEndsOn,
				<portlet:namespace />examScheduleAdminId : examScheduleAdmnId,
				<portlet:namespace />status : status,
				<portlet:namespace />values : JSON.stringify(values),
				<portlet:namespace />selectedValues : JSON.stringify(selectedValues)
				
			},
			type : 'POST',
			success : function(data) {
				
				
			},
			complete: function(data) {
				console.log(data);
				
				document.querySelector('input[name="<portlet:namespace/>riExamStartTime"]').value='';
				document.querySelector('input[name="<portlet:namespace/>riExamEndTime"]').value='';
				$('#riExamStartTimeHidden').val('');
				$('#riExamEndTimeHidden').val('');
				$('#riNoOfSeats').val('');
				$('#riLocateOnGoogleMap1').val('');
				$('#locationPinOnGoogleMap').val('');
				$('#riVenue').val('');
				$('#riDaysOfWeek').multiselect("clearSelection");
				
				$("#educationDetailsRIList").html(data.responseText.trim());
				$('#riExamScheduleAdmnId').val($('#updatedRIExamScheduleAdmnId').val());
				$('#isRIEdit').val('');
				$('#editRiExmDetId').val('');
				$('#examScheduleAdminID').val($('#updatedRIExamScheduleAdmnId').val());
				
				
	        },
		})
		
	} else {
		$('#riFormError').removeClass('d-none');
	}
}

function editRepeatedInstanceExamObject(examMultiDateId, daysOfWeek, startTime, endTime, noOfSeats, locationOnGoogleMap,locationPinOnGoogleMap, venue,  command){
	
	var examId=$('#examId').val();
	var examTypeId=$('#examTypeId').val();
	var programId=$('#programId').val();
	var examScheduleAdminId= $('#updatedRIExamScheduleAdmnId').val();
	
	$('#riExamStartTimeHidden').val(startTime);
	$('#riExamEndTimeHidden').val(endTime);
	var startTm=startTime.substring(0,startTime.indexOf(' '));
	var endTm=endTime.substring(0,endTime.indexOf(' '));
	var newstTm;
	var newEndTm;
	if(startTm.indexOf(":") == 1){
		newstTm= 0 + startTm; 
	}else{
		newstTm =startTm;
	}if(endTm.indexOf(":") == 1){
		newEndTm= 0 + endTm; 
	}else{
		newEndTm=endTm;
	}
	document.querySelector('input[name="<portlet:namespace/>riExamEndTime"]').value=newEndTm;
	document.querySelector('input[name="<portlet:namespace/>riExamStartTime"]').value=newstTm;
	
	$('#riDaysOfWeek').multiselect('select', JSON.parse(daysOfWeek));
	$('#riNoOfSeats').val(noOfSeats);
	$('#riLocateOnGoogleMap1').val(locationOnGoogleMap);
	$('#riLocationOnGoogleMap').val(locationPinOnGoogleMap);
	$('#riVenue').val(venue);
	$('#editRiExmDetId').val(examMultiDateId);
	$('#isRIEdit').val('edit');

	
} 
function deleteRepeatedInstanceObject(examMultiDateId, command){debugger;

	var examId=$('#examId').val();
	var examTypeId=$('#examTypeId').val();
	var programId=$('#programId').val();
	var examScheduleAdminId= $('#updatedRIExamScheduleAdmnId').val();
		$.ajax({
			url: '${saveExamSceduleDetailURL}',
			async : false,
			data : {
				
				<portlet:namespace />command : "deleteDetails",
				<portlet:namespace />flowType : "repeatedInstance",
				<portlet:namespace />examId : examId,
				<portlet:namespace />examTypeId : examTypeId,
				<portlet:namespace />examScheduleAdminId : examScheduleAdminId,
				<portlet:namespace />examMultiDateId : examMultiDateId
			},
			type : 'POST',
			success : function(data) {
				console.log('Success Function');
				$("#educationDetailsRIList").html(data.trim());
				$('#riCancelPopUpBttn').click();
					
			},
			complete: function(data) {
				console.log(data);
			
	        },
		})
}

function setDeleteRIId(id,link){
	var row = $(link).closest("tr");
	$(link).closest("tr").addClass("select_delete_row");
	
	$("#delete-education-confirm-modal").attr("exmMltDateId",id);
 	$("#delete-education-confirm-modal").data("row", row);
}
function deleteRIRowData() {
	var exmMltDateId = $("#delete-education-confirm-modal").attr("exmMltDateId");
	deleteRepeatedInstanceObject(exmMltDateId, "deleteDetails");
}

// Single Instance form Validation
function singleInstanceFormSubmition(event){debugger
	$('.siError').addClass('d-none');
	var siApplicationEndDate= validateSelectAndInputField('siApplicationEndDate','siApplicationEndDateError');
	var siApplicationStartDate= validateSelectAndInputField('siApplicationStartDate','siApplicationStartDateError');
	var siExamStartTime= validateSelectAndInputField('siExamStartTime','siExamStartTimeError')
	var siExamEndTime= validateSelectAndInputField('siExamEndTime','siExamEndTimeError');
	var siExamDate= validateSelectAndInputField('siExamDate','siExamDateError');
	var siNoOfSeats= validateSelectAndInputField('siNoOfSeats','siNoOfSeatsError');
	var siLocationOnGoogleMap= validateSelectAndInputField('siLocateOnGoogleMap1','siLocateOnGoogleMap1Error');
	var siLocationPinOnGoogleMap= validateSelectAndInputField('siLocationOnGoogleMap','siLocateOnGoogleMap1Error');
	var siVenue= validateSelectAndInputField('siVenue','siVenueError');
	if(siVenue && siLocationOnGoogleMap && siNoOfSeats && siExamDate && siExamEndTime && 
			siExamStartTime && siApplicationStartDate && siApplicationEndDate && siLocationPinOnGoogleMap){
		
		$('#siCMDId').val(event);
		$('#siForm').submit();
	}else{
		
	    return false;
	}
	
	
}
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly" defer>
</script>

<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAM97fJa4kw2f6dSHQ3mFTmTdKyZ8FrbLw&callback=initMap&libraries=places&v=weekly" defer ></script> -->