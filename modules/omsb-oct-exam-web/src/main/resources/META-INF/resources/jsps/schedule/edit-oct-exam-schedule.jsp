<%@ include file="../../init.jsp"%>
<liferay-portlet:actionURL
	name="<%=MVCCommandNames.UPDATE_OCT_EXAMS_SCHEDULE_ACTION%>"
	var="editExamScheduleActions" />
<!--  Temporary backl button render URL -->
<portlet:renderURL var="viewOCTScheduledExams">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:resourceURL
	id="<%=MVCCommandNames.SECTION_DEPARTMENT_MVC_RESOURCE%>"
	var="sectionDepartmentURL" />
<c:set var="selectedDepartmentKey"
	value="${octExamSchedule.getDepartmentKey()}"></c:set>
<c:set var="selectedSectionKey"
	value="${octExamSchedule.getSectionKey()}"></c:set>
<div class="main-content">
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info m-0">
						<div class="omsb-page-top-info">
							<div class="pagetitle">
								<liferay-ui:message key="edit-oct-exam-schedule" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<ul class="nav nav-pills omsb-nav-pills justify-content-center"
								id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="singledatesingleinstance-tab" data-toggle="tab"
									href="#singledatesingleinstance" role="tab"
									aria-controls="singledatesingleinstance" aria-selected="true"><liferay-ui:message
											key="single-date-single-instance" /></a></li>

							</ul>
						</div>
						<div class="col-lg-12 mt-4">
							<div class="tab-content" id="v-pills-tabContent">
								<div class="tab-pane fade show active"
									id="singledatesingleinstance" role="tabpanel"
									aria-labelledby="singledatesingleinstance-tab">
									<form action="${editExamScheduleActions}" method="post"
										name="<portlet:namespace/>examScheduleActions" id="siForm">
										<input type="hidden"
											name="<portlet:namespace/>siOCTExamScheduleId"
											id="siOCTExamScheduleId" value="${octExamSchedule.getId()}">
										<input type="hidden"
											name="<portlet:namespace/>siOCTExamDefinitionId"
											id="siOCTExamDefinitionId"
											value="${octExamSchedule.getOctExamDefinitionId()}">
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="registration-start-date" /></label> <input type="text"
														name="<portlet:namespace />siRegistrationStartDate"
														id="siRegistrationStartDate" placeholder="DD/MM/YYYY"
														class="form-control datePicker" autocomplete="off"
														value="${octExamSchedule.getRegistrationStartDate()}">
												</div>
												<p id="errorContainer-siRegistrationStartDate"
													class="error-container"></p>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required" l><liferay-ui:message
															key="registration-end-date" /></label> <input type="text"
														name="<portlet:namespace />siRegistrationEndDate"
														id="siRegistrationEndDate" placeholder="DD/MM/YYYY"
														class="form-control datePicker" autocomplete="off"
														value="${octExamSchedule.getRegistrationEndDate()}">
												</div>
												<p id="errorContainer-siRegistrationEndDate"
													class="error-container"></p>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="no-of-seats" /></label> <input type="text"
														name="<portlet:namespace />siNoOfSeats" id="siNoOfSeats"
														class="form-control"
														value="${octExamSchedule.getNoOfSeats()}">
												</div>
												<p id="errorContainer-siNoOfSeats" class="error-container"></p>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="exam-date" /></label> <input type="text"
														name="<portlet:namespace/>siExamDate" id="siExamDate"
														placeholder="DD/MM/YYYY" class="form-control datePicker"
														autocomplete="off"
														value="${octExamSchedule.getExamDate()}">
												</div>
												<p id="errorContainer-siExamDate" class="error-container"></p>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="exam-start-time" /></label> <input type="time"
														name="<portlet:namespace/>siExamStartTime"
														id="siExamStartTime" placeholder="HH:MM"
														class="form-control timePicker"
														value="">
												</div>
												<p id="errorContainer-siExamStartTime"
													class="error-container"></p>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="exam-end-time" /></label> <input type="time"
														name="<portlet:namespace />siExamEndTime"
														id="siExamEndTime" placeholder="HH:MM"
														class="form-control timePicker"
														value="">
												</div>
												<p id="errorContainer-siExamEndTime" class="error-container"></p>
											</div>
											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label><liferay-ui:message key="department-name" />${selectedDepartmentKey }</label>
													<select id="siDepartmentId"
														name="<portlet:namespace/>siDepartmentId"
														class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="octExamDepartment"
															items="${octExamDepartmentList}">
															<c:choose>
																 <c:when
																	test="${octExamDepartment.getKey() eq selectedDepartmentKey}">
																	<option value="${octExamDepartment.getKey()}" selected>
																		${octExamDepartment.getName(themeDisplay.getLocale())}
																	</option>
																</c:when> 
																<c:otherwise>
																	<option value="${octExamDepartment.getKey()}">
																		${octExamDepartment.getName(themeDisplay.getLocale())}
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label><liferay-ui:message key="section" /></label> <select
														name="<portlet:namespace/>siSectionId" id="siSectionId"
														class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="section" items="${sectionList}">
															<option value="${section.getKey()}">
																<liferay-ui:message
																	key="${section.getName(themeDisplay.getLocale())}" />
															</option>
														</c:forEach>
													</select>
												</div>
											</div>


											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="locate-on-google-map" /></label> <input type="text"
														name="<portlet:namespace/>siLocateOnGoogleMap"
														id="siLocateOnGoogleMap" data-attr="1" data-instance="si"
														data-place="${octExamSchedule.getLocationOnGoogleMap()}"
														class="form-control autocompleteMap"> <input
														type="hidden"
														name="<portlet:namespace/>siLocationOnGoogleMap"
														class="placeIdMap" id="siLocationOnGoogleMap"
														data-attr="1"
														value="${octExamSchedule.getLocationOnGoogleMap()}">
												</div>
												<p id="errorContainer-siLocationOnGoogleMap"
													class="error-container"></p>
											</div>

											<div class="col-lg-6 col-md-6 col-sm-12">
												<div class="form-group">
													<label class="required"><liferay-ui:message
															key="venue" /></label> <input type="text"
														value="${octExamSchedule.getVenue()}"
														name="<portlet:namespace/>siVenue" id="siVenue"
														class="form-control">
												</div>
												<p id="errorContainer-siVenue" class="error-container"></p>
											</div>
											<input type="hidden" name="<portlet:namespace />siCMD"
												id="<portlet:namespace />siCMD"
												value="<%=DataflowConstants.ANNOUNCED%>">
											<div class="col-lg-12 col-md-12 col-sm-12">
												<div id="simap1" class="omsb-map-h250"></div>
												<div id="siInfoWindowContent1">
													<span id="place-name" class="label-name"></span><br /> <span
														id="place-address"></span>
												</div>
											</div>
										</div>
										<div class="bottom-backbtn-wrap">
											<button class="btn omsb-bc-red-button" type="button"
												onclick="validateAndSubmitScheduleForm('si', 'announce', event)"
												title="Announce">
												<liferay-ui:message key="announce" />
											</button>
											<button class="btn omsb-bc-red-button" type="button"
												onclick="validateAndSubmitScheduleForm('si', 'saveAsDraft', event)"
												title="save as draft">
												<liferay-ui:message key="save-as-draft" />
											</button>
											<button class="btn omsb-bc-red-button" data-toggle="modal"
												data-target="#exam-schedule-si-discard" type="button">
												<liferay-ui:message key="discard" />

											</button>
											<a class="btn omsb-btn btn-back"
												href="${viewOCTScheduledExams}"><i
												class="fi fi-sr-arrow-left"></i> <liferay-ui:message
													key="back" /></a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

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

	  setSection("#siDepartmentId","#siSectionId", 'documentReady');
	
});


function validateAndSubmitScheduleForm(formType, action, event){
	console.log("Repeated Instance ... ");
	if(action ==="saveAsDraft"){
		document.getElementById('<portlet:namespace />'+formType+'CMD').value = '<%=DataflowConstants.NOT_ANNOUNCED%>';
	}
	
	if(formType.toLowerCase() === 'si'){
		validateAndSubmitSIScheduleForm(event);
	}
}

function validateAndSubmitSIScheduleForm(event) {
	
	var siRegistrationStartDate = document
			.getElementById("siRegistrationStartDate").value;
	var siRegistrationEndDate = document
			.getElementById("siRegistrationEndDate").value;
	var siExamStartTime = document.getElementById("siExamStartTime").value;
	var siExamEndTime = document.getElementById("siExamEndTime").value;
	var siExamDate = document.getElementById("siExamDate").value;
	var siNoOfSeats = document.getElementById("siNoOfSeats").value;
	var siVenue = document.getElementById("siVenue").value;
	var siLocationOnGoogleMap = document.getElementById("siLocationOnGoogleMap").value;
	
	var isValidationFailed=false;
		
	document.getElementById("errorContainer-siRegistrationStartDate").textContent = "";
	document.getElementById("errorContainer-siRegistrationEndDate").textContent = "";
	document.getElementById("errorContainer-siExamStartTime").textContent = "";
	document.getElementById("errorContainer-siExamEndTime").textContent = "";
	document.getElementById("errorContainer-siExamDate").textContent = "";
	document.getElementById("errorContainer-siNoOfSeats").textContent = "";
	document.getElementById("errorContainer-siVenue").textContent = "";
	document.getElementById("errorContainer-siLocationOnGoogleMap").textContent = "";
	
	if (!siRegistrationStartDate) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siRegistrationStartDate").textContent = "<liferay-ui:message key='enter-registration-start-date' />";
	}
	
	if (!siRegistrationEndDate) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siRegistrationEndDate").textContent = "<liferay-ui:message key='enter-registration-end-date' />";
	}
	
	if (!siExamStartTime) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siExamStartTime").textContent = "<liferay-ui:message key='enter-exam-start-time' />";
	}
	
	if (!siExamEndTime) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siExamEndTime").textContent = "<liferay-ui:message key='enter-exam-end-time' />";
	}
	
	if (!siExamDate) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siExamDate").textContent = "<liferay-ui:message key='enter-exam-date' />";
	}
	
	if (!siNoOfSeats) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siNoOfSeats").textContent = "<liferay-ui:message key='enter-no-of-seats' />";
	}
	
	if (!siVenue) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siVenue").textContent = "<liferay-ui:message key='enter-venue' />";
	}
	
	if (!siLocationOnGoogleMap) {
		isValidationFailed = true;
		document.getElementById("errorContainer-siLocationOnGoogleMap").textContent = "<liferay-ui:message key='enter-location' />";
	}

	if (isValidationFailed) {
		return;
	} else {
		document.getElementById("siForm").submit();
	}
}

$(document).on('change','#siDepartmentId',function(){
	setSection("#siDepartmentId","#siSectionId", 'change');
});

function setSection(idOfDepartment, idOfSection, event){
	var departmentId = $(idOfDepartment).val();

	$.ajax({
		url: '${sectionDepartmentURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />departmentId : departmentId,
		},
		type : 'POST',
		success : function(data) {
			console.log("success :::::",data);
			console.log("success :::::",data.length);
			
			var response = data;
            var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
            
            for (var i = 0; i < response.length; i++) {
            	if(event === 'documentReady'){
            		var selectedSectionKey =  '${selectedSectionKey}';
                	if(response[i].key === selectedSectionKey){
                		sectionData += "<option value='" + response[i].key + "' selected>" + response[i].name + "</option>";
                	}else{
                		sectionData += "<option value='" + response[i].key + "'>" + response[i].name + "</option>";
                	}
            	}else{
            		sectionData += "<option value='" + response[i].key + "'>" + response[i].name + "</option>";
            	}
            }
            $(idOfSection).html(sectionData); 
		},
	});
}
	
function discardSIForm() {
	
	window.location.reload();
	
	/* console.log("discardSIForm");
	document.getElementById('siRegistrationStartDate').value = '';
	document.getElementById('siRegistrationEndDate').value = '';
	document.getElementById('siExamStartTime').value = '';
	document.getElementById('siExamEndTime').value = '';
	document.getElementById('siExamDate').value = '';
	document.getElementById('siNoOfSeats').value = '';
	document.getElementById('siVenue').value = '';
	document.getElementById('siLocationOnGoogleMap').value = '';
	
	$("#exam-schedule-si-discard").modal("hide"); */
	
}
</script>

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

</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly"
	defer></script>

<!-- <script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAM97fJa4kw2f6dSHQ3mFTmTdKyZ8FrbLw&callback=initMap&libraries=places&v=weekly"
	defer></script> -->
<!--// End JS files Here --->
