<%@ include file="../../init.jsp"%>

<div class="row">	
	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="program-name" /></div>
		<div class="label-content">${programName}</div>
	</div>
	
	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="exam-type" /></div>
		<div class="label-content">${examType}</div>
	</div>
		
	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="application-start-date" /></div>
		<div class="label-content">${examSchedule.applicationStartDate}</div>
	</div>
					
	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="application-end-date" /></div>
		<div class="label-content">${examSchedule.applicationEndDate}</div>
	</div>
		
	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="no-of-seats" /></div>
		<div class="label-content">${examSchedule.noOfSeats}</div>
	</div>
</div>
	
<h4 class="omsb-card-title mt-4">
	<liferay-ui:message key="multiple-dates" />
</h4>
<div class="omsb">
	<%-- <div class="omsb-card omsb-card-graybg">
		<c:forEach items="${examMultiDates}" var="examScheduleDate" varStatus="loop">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message key="exam-date" /></div>
					<div class="label-content">${examScheduleDate.examDate}</div>
				</div>
				
				<div class="col-lg-6 col-md-6 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message key="exam-start-time" /></div>
					<div class="label-content">${examScheduleDate.startTime}</div>
				</div>
					
				<div class="col-lg-6 col-md-6 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message key="exam-end-time" /></div>
					<div class="label-content">${examScheduleDate.endTime}</div>
				</div>
					
				<div class="col-lg-6 col-md-6 col-sm-12 label-box">
					<div class="label-name"><liferay-ui:message key="venue" /></div>
					<div class="label-content">${examScheduleDate.venue}</div>
				</div>
					
				<input type="hidden" name="<portlet:namespace/>mdLocateOnGoogleMap" 
					id="mdLocateOnGoogleMap${loop.index}" data-attr="${loop.index}" data-id="mdLocateOnGoogleMap" data-instance="md" data-place="${examScheduleDate.locationOnGoogleMap}" class="form-control autocompleteMap">
								
				<div class="col-lg-12 col-md-12 col-sm-12 mt-4">
					<div id="mdmap${loop.index}" class="omsb-map-h250"></div>
					<div id="mdInfoWindowContent${loop.index}">
				    	<span id="place-name" class="label-name"></span><br />
						<span id="place-address"></span>
				    </div>
				</div>
			</div>
		</c:forEach>
	</div> --%>	
	<div id="educationDetailsList">
				<c:choose>
				<c:when test="${!empty examMultiDates}">
					<table class="display omsb-datatables" id="Multiple_dates_Table"
						width="100%">
						<thead>
							<tr>
								<th><liferay-ui:message key="exam-date" /></th>
								<th><liferay-ui:message key="exam-start-time" /></th>
								<th><liferay-ui:message key="exam-end-time" /></th>
								<th><liferay-ui:message key="locate-on-google-map" /></th>
								<th><liferay-ui:message key="venue" /></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="examMultiDatesItem" items="${examMultiDates}">
							<tr>
								<td>${examMultiDatesItem.examDate}</td>
								<td>${examMultiDatesItem.startTime}</td>
								<td>${examMultiDatesItem.endTime}</td>
								<td>${examMultiDatesItem.locationOnGoogleMap}</td>
								<td>${examMultiDatesItem.venue}</td>
								<td class="d-none">${examMultiDatesItem.id}</td>
								<td>
									<input type="hidden" id="updatedSchdId" name="<portlet:namespace/>updatedSchdId" value="${examMultiDatesItem.examScheduleId}">
									<%-- <button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteId('${examMultiDatesItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
									<button class="btn mx-2" value="view" data-toggle="modal" data-target="#add-education-confirm-modal" type="button" onclick="editMultExamDateObject('${examMultiDatesItem.id}','edit')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button> --%>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
				 
		</div>
</div>	
	<div class="bottom-backbtn-wrap">
		<portlet:renderURL var="viewExamScheduleURL">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAMS_SCHEDULE_LIST %>" />
		</portlet:renderURL>
		
		<portlet:renderURL var="viewExamResultsURL">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_SCHEDULE_EXAMS %>" />
		</portlet:renderURL>
			<c:if test="${result == 'result'}">
				<a class="btn omsb-btn btn-back" href="${viewExamResultsURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
			</c:if>
			<c:if test="${result != 'result'}">
				<a class="btn omsb-btn btn-back" href="${viewExamScheduleURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
			</c:if>
	</div>		
<script type="text/javascript" >
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
			center: { lat: 21.1458, lng: 79.0882 },
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
		var placeId = document.getElementById(acInputId).getAttribute("data-place");
        if(placeId){
            var request = {
                placeId: placeId,
                fields: ["name", "formatted_address", "place_id", "geometry"],
            };
            const service = new google.maps.places.PlacesService(map);
            service.getDetails(request, (place, status) => {
                if ( status === google.maps.places.PlacesServiceStatus.OK && place && place.geometry && place.geometry.location ) {

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
    var examScheduleId = '${examSchedule.id}';
    var locationOnGoogleMap = '${examSchedule.locationOnGoogleMap}';
    
    var acInputs = document.getElementsByClassName("autocompleteMap");    
    if(acInputs.length > 0){
        for (var i = 0; i < acInputs.length; i++) {
            setMap(acInputs[i]);            
        }
    }
}

window.initMap = initMap;

</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly" defer>
</script>