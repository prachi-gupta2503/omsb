<%@page import="gov.omsb.common.constants.DataflowConstants"%>
<%@ include file="../../init.jsp"%>

<div class="row">

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message
				key="program-name" /> </div>
		<div class="label-content">${programName}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="exam-type" />
		</div> 
		<div class="label-content">${examType}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message
				key="application-start-date" /></div> 
		<div class="label-content">${examSchedule.applicationStartDate}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message
				key="application-end-date" /></div> 
		<div class="label-content">${examSchedule.applicationEndDate}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message
				key="exam-start-time" /></div> 
		<div class="label-content">${examSchedule.startTime}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message
				key="exam-end-time" /></div> 
		<div class="label-content">${examSchedule.endTime}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="exam-date" /></div>
		<div class="label-content">${examSchedule.examDate}</div>
	</div>

	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message
				key="no-of-seats" /></div> 
		<div class="label-content">${examSchedule.noOfSeats}</div>
	</div>
	
	<div class="col-lg-6 col-md-6 col-sm-12 label-box">
		<div class="label-name"><liferay-ui:message key="venue" /></div>
		<div class="label-content">${examSchedule.venue}</div>
	</div>

 	<input type="hidden" name="<portlet:namespace/>siLocateOnGoogleMap"
		id="siLocateOnGoogleMap1" data-attr="1" data-instance="si" data-place="${examSchedule.locationPinOnGoogleMap}" class="form-control autocompleteMap">
	<div class="col-lg-12 col-md-12 col-sm-12 mt-4">
		<div id="simap1" class="omsb-map-h250"></div>
		<div id="siInfoWindowContent1">
    		<span id="place-name" class="label-name"></span><br />
			<span id="place-address"></span>
    	</div>
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
</div>


<script type="text/javascript" >
function setMap(autocInput){debugger
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

function initMap() {debugger
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