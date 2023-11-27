<%@ include file="../../init.jsp"%>
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					
					<div class="pagetitle"><liferay-ui:message key="${role ne 'octApplicant'?'set-up-exam':'exams-details'}"/></div>
					
					
				</div>
			</div>
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="form-group-view">
							<div class="label-name"><liferay-ui:message key="exam-title"/></div>
							<div class="label-content">${examJson.examTitleName }</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group-view">
							<div class="label-name"><liferay-ui:message key="duration-of-exam-in-hours"/></div>
							<div class="label-content">${examJson.examDuration }</div>
						</div>
					</div>
					<c:if test="${role ne 'octApplicant'}">
					<div class="col-lg-4 col-md-6">
						<div class="form-group-view">
							<div class="label-name"><liferay-ui:message key="cut-score"/></div>
							<div class="label-content">${examJson.cutScore }</div>
						</div>
					</div>
					</c:if>
					<c:if test="${role ne 'octApplicant'}">
					<div class="col-lg-4 col-md-6">
						<div class="form-group-view">
							<div class="label-name"><liferay-ui:message key="score-validity"/></div>
							<div class="label-content">${examJson.scoreValidity }</div>
						</div>
					</div>
					</c:if>
					
					<c:if test="${role ne 'octApplicant'}">
					<div class="col-lg-4 col-md-6">
						<div class="form-group-view">
							<div class="label-name"><liferay-ui:message key="registration-cut-off-window-in-hours"/></div>
							<div class="label-content">${examJson.cutOffWindow }</div>
						</div>
					</div>
					</c:if>

					<c:if test="${role ne 'octApplicant'}">
						<div class="col-lg-4 col-md-6">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="result-source" />
								</div>
								<div class="label-content">${examJson.resultSourceName }</div>
							</div>
						</div>
					</c:if>

					<c:if test="${role ne 'octApplicant'}">
						<div class="col-lg-4 col-md-6">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="auto-rescheduling-period" />
								</div>
								<div class="label-content">${examJson.autoSchedulingPeriod }</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			
			<c:if test="${role ne 'octApplicant'}">
			<div class="omsb-card omsb-card-graybg">
					<h4 class="omsb-card-title"><liferay-ui:message key="exam-blueprint"/></h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables">
							<thead>
								<tr>
									<th><liferay-ui:message key="exam-blue-print-title"/></th>
									<th><liferay-ui:message key="attachment"/></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="octExamBlueprint"items="${examJson.octExamBlueprints}" >
								<tr>
									<td >${octExamBlueprint.blueprintTitle}</td>	
									<td><a href="${octExamBlueprint.url }" target="_blank" class="omsb-view-file" view>${octExamBlueprint.name}</a></td>
						 		</tr>
							 </c:forEach>
							</tbody>
						</table>
					</div>
			</div>
			</c:if>

			<c:if test="${role ne 'octApplicant'}">
				<div class="omsb-list-filter pb-2">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="flex-wrapper">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="exam-form-nos" />
									</div>
									<div class="label-content">${examJson.examFormNo }</div>
								</div>
								<button class="btn omsb-bg-red-button" data-toggle="modal"
									data-target="#viewforms" type="button">
									<liferay-ui:message key="view-forms" />
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<div class="omsb-card omsb-card-graybg">
				<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="locate-in-google"/></div> 
					<input readonly type="text" style="border: 0px" placeholder="<liferay-ui:message key="locate-google"/>" name="<portlet:namespace/>k"
					id="locateOnGoogleMap" data-place="${examJson.locationOnGoogleMap}" class="form-control autocompleteMap">
					</div>		
				</div>	
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group-view">
						<div class="label-name"><liferay-ui:message key="venue"/></div>
						<div class="label-content">${examJson.venue}</div>
					</div>		
				</div>	
					<div class="col-lg-12 col-md-12 col-sm-12">
					
					<input type="hidden" placeholder="<liferay-ui:message key="locate-google"/>" name="<portlet:namespace/>k"
									id="locateOnGoogleMap" data-place="${examJson.locationOnGoogleMap}" class="form-control autocompleteMap">
					<div id="map" class="omsb-map-h250"></div>
						<div id="infoWindowContent">
				    		<span id="place-name" class="label-name"></span><br />
							<span id="place-address"></span>
				    	</div>
					</div>
				</div>
				</div>

			<c:if test="${role ne 'octApplicant'}">
				<div class="omsb-card omsb-card-graybg">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="early-bird-fees" />
					</h4>
					<div class="row">
						<div class="col-lg-4 col-md-6">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="applicable-days" />
								</div>
								<div class="label-content">${examJson.earlyBirdFeesDate }</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="fee-amount-in-omr" />
								</div>
								<div class="label-content">${examJson.earlyBirdFees }</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>

			<c:if test="${role ne 'octApplicant'}">
				<div class="omsb-card omsb-card-graybg">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="regular-fees" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables">
							<thead>
								<tr>
									<th><liferay-ui:message key="attempt-number" /></th>
									<th><liferay-ui:message key="regular-fees-amount-in-omr" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="octRegularFee"
									items="${examJson.octRegularFees}">
									<tr>
										<td>${octRegularFee.noOfAttempt}</td>
										<td>${octRegularFee.regularFees}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
			<c:if test="${role ne 'octApplicant'}">
				<div class="omsb-card omsb-card-graybg">
					<h4 class="omsb-card-title">
						<liferay-ui:message key="rescheduling-fees" />
					</h4>
					<div class="omsb-list-view table-responsive">
						<table class="display omsb-datatables">
							<thead>
								<tr>
									<th><liferay-ui:message key="days-before-exam" /></th>
									<th><liferay-ui:message key="refund-percentage" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="octRescheduleFee"
									items="${examJson.octRescheduleFees}">
									<tr>
										<td>${octRescheduleFee.noOfDays}</td>
										<td>${octRescheduleFee.reschedulingFeesPercentage}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			
			</c:if>
			<c:if test="${role ne 'octApplicant'}">
			<div class="omsb-card omsb-card-graybg">
						<h4 class="omsb-card-title">
							<liferay-ui:message key="cancellation-fees" />
						</h4>
						<div class="omsb-list-view table-responsive">
							<table class="display omsb-datatables">
								<thead>
									<tr>
										<th><liferay-ui:message key="days-before-exam" /></th>
										<th><liferay-ui:message key="refund-percentage" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="octExamCancellationFee"
										items="${examJson.octExamCancellationFees}">
										<tr>
											<td>${octExamCancellationFee.noOfDays}</td>
											<td>${octExamCancellationFee.cancellationFeesPercentage}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</c:if>
					<div class="row">
						<c:if test="${role ne 'octApplicant'}">
							<div class="col-lg-4 col-md-6">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="appeal-window" />
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg"
											alt="info" data-toggle="tooltip" data-placement="top"
											title="Number of Days After Results Are Announced">
									</div>
									<div class="label-content">${examJson.appealWindow }</div>
								</div>
							</div>
						</c:if>
						<div class="col-lg-4 col-md-6">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="appeal-fees-in-omr" />
								</div>
								<div class="label-content">${examJson.appealFees }</div>
							</div>
						</div>

						<c:if test="${role ne 'octApplicant'}">
							<div class="col-lg-4 col-md-6">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="re-appeal-window" />
										<img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg"
											alt="info" data-toggle="tooltip" data-placement="top"
											title="Number of Days After Results Are Announced">
									</div>
									<div class="label-content">${examJson.reAppealWindow }</div>
								</div>
							</div>
						</c:if>
						
						<div class="col-lg-4 col-md-6">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="re-appeal-fees-in-omr" />
								</div>
								<div class="label-content">${examJson.reAppealFees }</div>
							</div>
						</div>

						<c:if test="${role ne 'octApplicant'}">
							<div class="col-lg-4 col-md-6">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="eligibility-check" />
									</div>
									<div class="label-content">${examJson.eligibilityCheck ? "Yes" : "No" }</div>
								</div>
							</div>

							<div class="col-lg-4 col-md-6">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="does-eportal-apply-eligibility" />
									</div>
									<div class="label-content">${examJson.applyEligibility ? "Yes" : "No" }</div>
								</div>
							</div>
						</c:if>
					</div>

					<c:if test="${role ne 'octApplicant' and examJson.eligibilityCheck }">
						<div class="omsb-card omsb-card-graybg">
							<h4 class="omsb-card-title">
								<liferay-ui:message
									key="number-of-attempts-and-the-time-period-for-the-attempts" />
							</h4>
							<div class="omsb-list-view table-responsive">
								<table class="display omsb-datatables">
									<thead>
										<tr>
											<th><liferay-ui:message key="nationality" /></th>
											<th><liferay-ui:message key="max-no-of-attempts" /></th>
											<th><liferay-ui:message
													key="max-time-period-to-complete-all-attempts" /></th>
											<th><liferay-ui:message
													key="time-period-between-attempts" /></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><liferay-ui:message key="omani" /></td>
											<td>${examJson.omaniMaxAttempts }</td>
											<td>${examJson.omaniMaxTimePeriod }</td>
											<td>${examJson.omaniTimePeriod }</td>
										</tr>
										<tr>
											<td><liferay-ui:message key="non-omani" /></td>
											<td>${examJson.nonOmaniMaxAttempts }</td>
											<td>${examJson.nonOmaniMaxTimePeriod }</td>
											<td>${examJson.nonOmaniTimePeriod }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</c:if>

					<c:if test="${viewDefinitionCMD eq 'viewDefinition' }">
						<portlet:renderURL var="OCTHomeURL">
							<portlet:param name="mvcRenderCommandName"
								value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
						</portlet:renderURL>
					</c:if>
					<c:if test="${viewDefinitionCMD eq '' }">
						<portlet:renderURL var="OCTHomeURL">
							<portlet:param name="mvcRenderCommandName" value="/" />
						</portlet:renderURL>
					</c:if>
					<div class="bottom-backbtn-wrap">
						<a class="btn omsb-btn btn-back" href="${OCTHomeURL }"><i
							class="fi fi-sr-arrow-left"></i>
						<liferay-ui:message key="back" /></a>
					</div>
		</div>
	</div>
</div>


<!-- View Forms Modal -->
	<div class="modal fade omsb-modal" id="viewforms" tabindex="-1" role="dialog" aria-labelledby="viewformsTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">View Forms</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="viewforms_table">
						<table class="table">
							<thead>
								<tr>
									<th scope="col"><liferay-ui:message key="exam-form-nos"/></th>
									<th scope="col"><liferay-ui:message key="status"/></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="octExamFormNumber" items="${examJson.octExamFormNumbers}">
								<tr>
									<td>${octExamFormNumber.examForm }</td>
									<td>${octExamFormNumber.examFormStatusName }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="cancel"/></button>
				</div>
			</div>
		</div>
	</div>
<script>
$('.omsb-datatables').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "pageLength": 2
});
</script>
<script>
function initMap() {
	var options = {
		fields: ["place_id", "formatted_address", "geometry", "name"],
	   	strictBounds: false,
	   	types: ["establishment"],
	};
	const acInput = document.getElementById("locateOnGoogleMap");
	const infowindow = new google.maps.InfoWindow();
	const infowindowContent = document.getElementById("infoWindowContent");
	infowindow.setContent(infowindowContent);
	const map = new google.maps.Map(document.getElementById("map"), {
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
	autocomplete.inputId = "locateOnGoogleMap";
   	autocomplete.addListener("place_changed", () => {
	   	infowindow.close();
	   	marker.setVisible(false);
	   	const place = autocomplete.getPlace();
	   	if (!place.geometry || !place.geometry.location) {
	   		window.alert("No details available for input: '" + place.name + "'");
	   		return;
	   	} else {
	   		document.getElementById($("#locateOnGoogleMap").parent('div').find('input')[1].id).value = place.place_id;
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
	 var placeId = document.getElementById("locateOnGoogleMap").getAttribute("data-place");
	if(placeId){
		var request = {
	  		placeId: placeId,
	   	    fields: ["name", "formatted_address", "place_id", "geometry"],
		};
	   	const service = new google.maps.places.PlacesService(map);
	   	service.getDetails(request, (place, status) => {
	   		if ( status === google.maps.places.PlacesServiceStatus.OK && place && place.geometry && place.geometry.location ) {
	   			document.getElementById("locateOnGoogleMap").value = place.name+', '+place.formatted_address;
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

window.initMap = initMap;
</script>	

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly"
	defer></script>

<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAM97fJa4kw2f6dSHQ3mFTmTdKyZ8FrbLw&callback=initMap&libraries=places&v=weekly" defer ></script> -->		