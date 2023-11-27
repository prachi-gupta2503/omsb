<%@ include file="../../init.jsp"%>

<div class="main-content">
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info m-0">
						<div class="omsb-page-top-info">
							<div class="pagetitle">
								<liferay-ui:message key="view-oct-exam-schedule" />
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
									aria-controls="singledatesingleinstance" aria-selected="true">
									<c:if test = "${octExamSchedule.isRepeatedInstance() eq true}">
									<liferay-ui:message
											key="repeated-instance" />
									
									</c:if>
									<c:if test = "${octExamSchedule.isRepeatedInstance() eq false}">
									<liferay-ui:message
											key="single-date-single-instance" />
									
									</c:if>
									</a></li>

							</ul>
						</div>
						<div class="col-lg-12 mt-4">
							<div class="tab-content" id="v-pills-tabContent">
								<div class="tab-pane fade show active"
									id="singledatesingleinstance" role="tabpanel"
									aria-labelledby="singledatesingleinstance-tab">
									<div class="row">
									
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="registration-start-date" /> </label> <label
												class="label-content">${octExamSchedule.getRegistrationStartDate()}</label>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="registration-end-date" /> </label> <label
												class="label-content">${octExamSchedule.getRegistrationEndDate()}</label>
										</div>
									
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="no-of-seats" /></label> <label class="label-content">${octExamSchedule.getNoOfSeats()}</label>
										</div>
									
									<c:if test = "${role == 'admin' and octExamSchedule.isRepeatedInstance() eq true}">
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="exam-start-date" /> </label> <label
												class="label-content">${octExamSchedule.getExamStartDate()}</label>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="exam-end-date" /> </label> <label
												class="label-content">${octExamSchedule.getExamEndDate()}</label>
										</div>
									
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="no-of-seats" /></label> <label class="label-content">${octExamSchedule.getNoOfSeats()}</label>
										</div>
									</c:if>
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="exam-date" /></label> <label class="label-content">${octExamSchedule.getExamDate()}</label>
										</div>
										
										<%-- <c:if test = "${role == 'admin' and octExamSchedule.isRepeatedInstance() eq false}">
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="exam-center" /></label> <label class="label-content">${octExamSchedule.getExamCenterName()}</label>
										</div>
										</c:if> --%>

										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="exam-slot" /></label> <label class="label-content">${octExamSchedule.getExamSlot()}</label>
										</div>

										<%-- <div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="exam-end-time" /></label> <label class="label-content">${octExamSchedule.getExamEndTime()}</label>
										</div> --%>
									<c:if test = "${role == 'admin'}">
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="department-name" /></label> <label class="label-content">${octExamSchedule.getDepartmentName()}</label>
										</div>
									
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="section" /></label> <label class="label-content">${octExamSchedule.getSectionName()}</label>
										</div>
									</c:if>
										<div class="col-lg-6 col-md-6 col-sm-12 label-box">
											<label class="label-name"><liferay-ui:message
													key="venue" /></label> <label class="label-content">${octExamSchedule.getVenue()}</label>
										</div>
										
			<input type="hidden" name="<portlet:namespace/>siLocateOnGoogleMap"
		id="siLocateOnGoogleMap1" data-attr="1" data-instance="si" 
		data-place="${octExamSchedule.getLocationOnGoogleMap()}" class="form-control autocompleteMap">
											
										<div class="col-lg-12 col-md-12 col-sm-12 mt-4">
		<div id="simap1" class="omsb-map-h250"></div>
		<div id="siInfoWindowContent1">
    		<span id="place-name" class="label-name"></span><br />
			<span id="place-address"></span>
    	</div>
	</div>
									</div>
									
									<div id="octRepeatedInstanceDiv">
			
				<c:choose>
					<c:when test="${!empty ocExamMultiDates}">
						<table class="display omsb-datatables" id="Repeated_dates_Table"
							width="100%">
							<thead>
								<tr>
									<%-- <th><liferay-ui:message key="id" /></th> --%>
									
									<th><liferay-ui:message key="days-of-week" /></th>
									<th><liferay-ui:message key="exam-center" /></th>
									<th><liferay-ui:message key="exam-slots" /></th>
									<th><liferay-ui:message key="no-of-seats" /></th>
									<%-- <th><liferay-ui:message key="action" /></th> --%>
									
								</tr>
							</thead>
							<tbody>
							<c:forEach var="examScheduleItem" items="${ocExamMultiDates}">
								<tr>
									<%-- <td>${examMultiDatesItem.id}</td> --%>
									<td>${examScheduleItem.daysOfWeek}</td>
									<td>${examScheduleItem.examCenterName}</td>
									<td>${examScheduleItem.examSlot}</td>
									<td>${examScheduleItem.noOfSeats}</td>
									
									<td class="d-none">${examScheduleItem.id}</td>
									
									<%-- <td>
									<input type="hidden" id="updatedRIExamScheduleAdmnId" name="<portlet:namespace/>updatedRIExamScheduleAdmnId" value="${examScheduleItem.oCExamScheduleAdminId}">
										<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-RI-Data-table" data-rowcount="addPopUpRow" onclick="setDeleteRIId('${examScheduleItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
										<button class="btn mx-2" value="view"  type="button" onclick="editRepeatedInstanceExamObject('${examScheduleItem.id}','edit')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
									</td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</div>
									<portlet:renderURL var="viewOCTScheduledExamsAdmin">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
									</portlet:renderURL>
									
									
									<portlet:renderURL var="viewOCTScheduledExamsApplicant">
										<portlet:param name="mvcRenderCommandName" value="/" />
									</portlet:renderURL>
									
									<div class="bottom-backbtn-wrap">
									<c:if test = "${role == 'applicant'}">
										<a class="btn omsb-btn btn-back"
											href="${viewOCTScheduledExamsApplicant}"><i
											class="fi fi-sr-arrow-left"></i> <liferay-ui:message
												key="back" /></a>
									</c:if>
									
									
									<c:if test = "${role == 'admin'}">
										<a class="btn omsb-btn btn-back"
											href="${viewOCTScheduledExamsAdmin}"><i
											class="fi fi-sr-arrow-left"></i> <liferay-ui:message
												key="back" /></a>
									</c:if>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
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
    var examScheduleId = '${examSchedule.getId()}';
    var locationOnGoogleMap = '${examSchedule.getLocationOnGoogleMap()}';
    
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
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly" defer></script>
