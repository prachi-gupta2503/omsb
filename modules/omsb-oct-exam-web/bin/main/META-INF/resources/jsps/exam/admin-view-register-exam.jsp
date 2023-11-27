<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file="../../init.jsp"%>

<portlet:actionURL var="WorkflowAssignURL"
	name="<%=MVCCommandNames.OCT_EXAM_WORKFLOW%>">
	<portlet:param name="assignedToMe" value="${assignedToMe}" />
	<portlet:param name="workflowTaskId" value="${workflowTaskId}" />
	<portlet:param name="workflowInstanceId" value="${instanceId}" />
	<portlet:param name="<%=Constants.CMD%>"
		value="<%=CommonConstants.CMD_ASSIGN_TO_ME%>" />
	<portlet:param name="registrationId" value="${registrationId}" />
</portlet:actionURL>
<portlet:renderURL var="viewApplicantRequests">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_APPLICANT_REQUESTS%>" />
	<portlet:param name="octExamId" value="${octExamDetail.getId()}" />
</portlet:renderURL>
<portlet:actionURL var="adminExamRegWFURL"
	name="<%=MVCCommandNames.OCT_EXAM_REGISTRATION_WORKFLOW%>"></portlet:actionURL>
<form action="${adminExamRegWFURL}" method="post"
	name="admin_exam_registration_fm">

	<input type="hidden" value="${registrationId}"
		name="<portlet:namespace/>registrationId"> <input
		type="hidden" value="${assignedToMe}"
		name="<portlet:namespace/>assignedToMe"> <input type="hidden"
		value="${instanceId}" name="<portlet:namespace/>instanceId"> <input
		type="hidden" value="${workflowTaskId}"
		name="<portlet:namespace/>workflowTaskId"> <input
		type="hidden" value="" name="<portlet:namespace/>trName"
		id="<portlet:namespace/>trName">


	<div class="container">

		<div class="container">
			<div class="omsb-card">
				<!-- <div class="omsb-page-top-info m-0">
					<div class="pagetitle">Register Exam</div>
				</div> -->

				<h4 class="form-title"><liferay-ui:message key="trainee-details" /></h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="first-name" /></label> <span class="value">${registration.firstName}</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="family-name" /></label> <span class="value">${registration.familyName}</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="nationality" /></label> <span class="value">${registration.nationality}</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="birth-date" /></label> <span class="value">${registration.dateOfBirth}</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label><liferay-ui:message key="gender" /></label> <span class="value">Male</span>
						</div>
					</div>
				</div>
				<h4 class="form-title"><liferay-ui:message key="contact-details" /></h4>
                    <div class="row m-0">
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <div class="form-group">
                                <label><liferay-ui:message key="mobile" /></label> <span class="value">${registration.mobileNumber}</span>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <div class="form-group">
                                <label><liferay-ui:message key="email" /></label> <span class="value">${registration.emailAddress}</span>
                            </div>
                        </div>
                    </div>
                <h4 class="form-title"><liferay-ui:message  key="exam-details" /></h4>
                    <div class="row m-0">
                        <div class="col-lg-6 col-md-6 col-sm-12 label-box">
                            <label class="label-name"><liferay-ui:message
                                    key="exam-title" /></label> <label class="label-content">${registration.getoCExamTitleName()}</label>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 label-box">
                            <label class="label-name"><liferay-ui:message
                                    key="exam-date" /></label> <label class="label-content">${registration.getExamStartDate()}</label>
                        </div>
    
                        <div class="col-lg-6 col-md-6 col-sm-12 label-box">
                            <label class="label-name"><liferay-ui:message
                                    key="exam-start-time" /></label> <label class="label-content">${registration.getExamTime()}</label>
                        </div>
    
                        <div class="col-lg-6 col-md-6 col-sm-12 label-box">
                            <label class="label-name"><liferay-ui:message key="venue" /></label>
                            <label class="label-content">${registration.getVenue()}</label>
                        </div>
                        <input type="hidden" name="<portlet:namespace/>locateOnGoogleMap"
                            id="locateOnGoogleMap" data-attr="1" data-instance="si"
                            data-place="${registration.getLocationOnGoogleMap()}"
                            class="form-control autocompleteMap">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <div id="map" class="omsb-map-h250"></div>
                            <div id="infoWindowContent">
                                <span id="place-name" class="label-name"></span><br /> <span
                                    id="place-address"></span>
                            </div>
                        </div>
                    </div>
			<%--	<h4 class="form-title">Passport Details</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label>Passport Number</label> <span class="value">${registration.passportNumber}</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group-dtls">
							<label>Passport Expiry Date</label> <span class="value">22-08-2029</span>
						</div>
					</div>
				</div>

				<h4 class="form-title">Civil ID Info</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Civil ID</label> <span class="value">${registration.civilId}</span>
						</div>
					</div>
				</div>

				<h4 class="form-title">Contact Details</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Mobile</label> <span class="value">${registration.mobileNumber}</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Email</label> <span class="value">${registration.emailAddress}</span>
						</div>
					</div>
				</div>

				<h4 class="form-title">Emegency Contact Details</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Name</label> <span class="value">Ali</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Telephone</label> <span class="value">1234567890</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Mobile</label> <span class="value">1234567890</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Relationship to Applicant</label> <span class="value">Ali</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>Email Address</label> <span class="value">Male</span>
						</div>
					</div>
				</div>

				<h4 class="form-title">Education Details</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>University of Education</label> <span class="value">${registration.issuingAuthorityName}</span>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label>Uploaded Document</label>
							<div class="omsb-card-caserport ">
								<div class="leftbar">
									<h4 class="casereport-title">${document.fileURL}Docu_Upload_10293944.Pdf</h4>
								</div>
								<div class="righbar">
									<button class="btn view_btn" title="View">
										<img src="../images/svg/view_icon.svg" alt=""
											${document.fileName }> View
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h4 class="form-title">Language Used In College</h4>
				<div class="row m-0">
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
								<input type="checkbox" class="custom-control-input" id="English"
									name="example1" checked> <label
									class="custom-control-label m-0" for="English">English</label>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
								<input type="checkbox" class="custom-control-input" id="Arabic"
									name="example1" disabled> <label
									class="custom-control-label m-0" for="Arabic">Arabic</label>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
								<input type="checkbox" class="custom-control-input" id="Other"
									name="example1" disabled> <label
									class="custom-control-label m-0" for="Other">Other</label>
							</div>
						</div>
					</div>
				</div>
				<h4 class="form-title">Internship/Training</h4>
				<div class="row m-0">
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-radio ">
								<input type="radio" name="Internship-radio"
									class="custom-control-input" id="Completed" checked> <label
									class="custom-control-label m-0" for="Completed">Completed</label>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-radio ">
								<input type="radio" name="Internship-radio"
									class="custom-control-input" id="Ongoing" disabled> <label
									class="custom-control-label m-0" for="Ongoing">Ongoing</label>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-radio ">
								<input type="radio" name="Internship-radio"
									class="custom-control-input" id="Not Applicable" disabled>
								<label class="custom-control-label m-0" for="Not Applicable">Not
									Applicable</label>
							</div>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label>Uploaded Document</label>
							<div class="omsb-card-caserport ">
								<div class="leftbar">
									<h4 class="casereport-title">Docu_Upload_10293944.Pdf</h4>
								</div>
								<div class="righbar">
									<button class="btn view_btn" title="View">
										<img src="../images/svg/view_icon.svg" alt=""> View
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h4 class="form-title">Internship Date</h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>From Date</label> <span class="value">10-12-2023</span>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label>To date</label> <span class="value">10-12-2023</span>
						</div>
					</div>
				</div>
				<h4 class="form-title"><liferay-ui:message
								key="exam-details" /></h4>
				<div class="row m-0">
					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="exam-title" /></label> <label class="label-content">${registration.getoCExamTitleName()}</label>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="exam-date" /></label> <label class="label-content">${registration.getExamStartDate()}</label>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message
								key="exam-start-time" /></label> <label class="label-content">${registration.getExamTime()}</label>
					</div>

					<div class="col-lg-6 col-md-6 col-sm-12 label-box">
						<label class="label-name"><liferay-ui:message key="venue" /></label>
						<label class="label-content">${registration.getVenue()}</label>
					</div>
					<input type="hidden" name="<portlet:namespace/>locateOnGoogleMap"
						id="locateOnGoogleMap" data-attr="1" data-instance="si"
						data-place="${registration.getLocationOnGoogleMap()}"
						class="form-control autocompleteMap">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div id="map" class="omsb-map-h250"></div>
						<div id="infoWindowContent">
							<span id="place-name" class="label-name"></span><br /> <span
								id="place-address"></span>
						</div>
					</div>
				</div>
				<h4 class="form-title">Consent</h4>
				<div class="row m-0">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
								<input type="checkbox" class="custom-control-input"
									id="authorize" name="authorize" checked> <label
									class="custom-control-label m-0" for="authorize">I
									authorize OMSB to conduct source verification of my educational
									credentials from the instituion above.</label>
							</div>
						</div>

					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<div class="custom-control custom-checkbox ">
								<input type="checkbox" class="custom-control-input"
									id="authoriz2" name="authoriz2" checked> <label
									class="custom-control-label m-0" for="authoriz2">I
									declare that all of the information provided by me in this form
									is true and collect to the best of my knowledge.*</label>
							</div>
						</div>
					</div>
				</div>--%>

				<div class="bottom-backbtn-wrap">
					<c:if test="${assignedToMe}">
						<a href="${WorkflowAssignURL} "><button
								class="btn omsb-bc-red-button">
								<liferay-ui:message key="assign-to-me" />
							</button></a>
					</c:if>
					<c:if test="${!assignedToMe && not empty trNames}">
						<button class="btn omsb-bc-red-button" title="Accept"
							onclick="saveExamRegistrationTransition(this);" data-tr="Accept">
							<liferay-ui:message key="accept" />
						</button>
						<button class="btn omsb-bg-red-button" title="Reject"
							onclick="saveExamRegistrationTransition(this);" data-tr="Reject">
							<liferay-ui:message key="reject" />
						</button>
					</c:if>
					<a class="btn omsb-btn btn-back" href="${viewApplicantRequests}"><i
						class="fi fi-sr-arrow-left"></i>
					<liferay-ui:message key="back" /></a>
				</div>
			</div>
		</div>

	</div>

</form>

<script type="text/javascript">
function saveExamRegistrationTransition(event) {
	var trName = $(event).attr('data-tr');
	console.log('data attr tr ?? ', trName);
	$("#" + namespace + "trName").val(trName);
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
		
		const infowindow = new google.maps.InfoWindow();
		const infowindowContent = document.getElementById("infoWindowContent");
		infowindow.setContent(infowindowContent);
		const map = new google.maps.Map(document.getElementById("map"), {
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
    var examScheduleId = '${registration.oCExamScheduleId}';
    var locationOnGoogleMap = '${registration.locationOnGoogleMap}';
    
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
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly"
	defer></script>

