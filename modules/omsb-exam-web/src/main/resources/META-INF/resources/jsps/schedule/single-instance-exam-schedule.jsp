<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<form action="${announceScheduleExamURL}" method="post"
	name="<portlet:namespace/>examScheduleActions" id="siForm">
	<div class="row">

		<div class="col-lg-6 col-md-6 col-sm-12 ">
			<div class="form-group">
				<div class="label-name"><liferay-ui:message key="program-name" /></div> 
				<div class="label-content">${programName}</div>
			</div>
		</div>
		
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="label-name"><liferay-ui:message key="exam-type" /></div> 
				<div class="label-content">${examType}</div>
			</div>
		</div>

		<input type="hidden" readonly="readonly" value="${examTypeId}" name="<portlet:namespace/>examTypeId" id="examTypeId" class="form-control"> 
		<input type="hidden" readonly="readonly" value="${examId}" name="<portlet:namespace/>examId" id="examId" class="form-control">
		<input type="hidden" readonly="readonly" value="${programId}" name="<portlet:namespace/>pId" id="pId" class="form-control"> 
		<input type="hidden" readonly="readonly" value="${examScheduleAdminId}" name="<portlet:namespace/>examScheduleAdminId" id="exmSchAdmId" class="form-control"> 
		
		
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="application-start-date" /></label> <input type="text"
					name="<portlet:namespace/>siApplicationStartDate"
					onchange="validateSelectAndInputField('siApplicationStartDate','siApplicationStartDateError');"
					id="siApplicationStartDate"  value="${examSchedule.applicationStartDate}" placeholder="DD/MM/YYYY"
					class="form-control datePicker" >
					<input type="hidden" readonly="readonly" value="${examSchedule.id}"
						name="<portlet:namespace/>examScheduleId" id="examScheduleId" class="form-control" >
						
			</div>
			<p id="siApplicationStartDateError" class="error-container d-none siError">Please enter application start date.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="application-end-date" /></label> <input type="text"
					name="<portlet:namespace/>siApplicationEndDate"
					onchange="validateSelectAndInputField('siApplicationEndDate','siApplicationEndDateError');"
					id="siApplicationEndDate" value="${examSchedule.applicationEndDate}" placeholder="DD/MM/YYYY"
					class="form-control datePicker" >
			</div>
			<p id="siApplicationEndDateError" class="error-container d-none siError">Please enter application end date.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-start-time" /></label>
				<input type="time"
					name="<portlet:namespace/>siExamStartTime"
					onchange="validateSelectAndInputField('siExamStartTime','siExamStartTimeError');"
					id="siExamStartTime" value="${examSchedule.startTime}" placeholder="HH:MM"
					class="form-control timePicker" >
			</div>
			<p id="siExamStartTimeError" class="error-container d-none siError">Please enter start time.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-end-time" /></label>
				<input type="time" name="<portlet:namespace/>siExamEndTime"
				onchange="validateSelectAndInputField('siExamEndTime','siExamEndTimeError');"
					id="siExamEndTime" value="${examSchedule.endTime}" placeholder="HH:MM"
					class="form-control timePicker" >
			</div>
			<p id="siExamEndTimeError" class="error-container d-none siError">Please enter end time.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-date" /></label> <input
					type="text" name="<portlet:namespace/>siExamDate"
					onchange="validateSelectAndInputField('siExamDate','siExamDateError');"
					id="siExamDate" value="${examSchedule.examDate}" placeholder="DD/MM/YYYY"
					class="form-control datePicker" >
			</div>
			<p id="siExamDateError" class="error-container d-none siError">Please enter exam date.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="no-of-seats" /></label> <input
					type="number" min="1" name="<portlet:namespace/>siNoOfSeats"
					onkeyup="validateSelectAndInputField('siNoOfSeats','siNoOfSeatsError');"
					id="siNoOfSeats" value="${examSchedule.noOfSeats}" class="form-control" >
			</div>
			<p id="siNoOfSeatsError" class="error-container d-none siError">Please enter no of seats.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="locate-on-google-map" /></label> 
				<input type="text" name="<portlet:namespace/>siLocateOnGoogleMap"
				onkeyup="validateSelectAndInputField('siLocateOnGoogleMap1','siLocateOnGoogleMap1Error');"
					id="siLocateOnGoogleMap1" data-attr="1" data-instance="si" data-place="${examSchedule.locationOnGoogleMap}"  value="${examSchedule.locationOnGoogleMap}"
					class="form-control autocompleteMap">
				<input type="hidden" name="<portlet:namespace />siLocationOnGoogleMap" class="placeIdMap"
					id="siLocationOnGoogleMap" data-attr="1" value="${examSchedule.locationPinOnGoogleMap}">
			</div>
			<p id="siLocateOnGoogleMap1Error" class="error-container d-none siError">Please enter location.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="venue" /></label> <input
					type="text" value="${examSchedule.venue}" name="<portlet:namespace/>siVenue"
					onkeyup="validateSelectAndInputField('siVenue','siVenueError');"
					id="siVenue" class="form-control" >
			</div>
			<p id="siVenueError" class="error-container d-none siError">Please enter venue.</p>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div id="simap1" class="omsb-map-h250"></div>
			<div id="siInfoWindowContent1">
	    		<span id="place-name" class="label-name"></span><br />
				<span id="place-address"></span>
	    	</div>
		</div>
	</div>
	
	<input type="hidden" name="<portlet:namespace />siCMD" id="siCMDId" value="<%=DataflowConstants.ANNOUNCED%>">
	<div class="bottom-backbtn-wrap">
		<button class="btn omsb-bc-red-button" onclick="singleInstanceFormSubmition('Announced')" type="button">
			<liferay-ui:message key="announce"></liferay-ui:message>
		</button>
		<button class="btn omsb-bc-red-button" type="submit" onclick="singleInstanceFormSubmition('Not Announced')" title="save as draft">
			<liferay-ui:message key="save-as-draft" />
		</button>
		<button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#exam-schedule-si-discard" type="button" title="Discard">
			<liferay-ui:message key="discard" />
		</button>
		
		
		<portlet:renderURL var="viewExamSchedulesURL">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAMS_SCHEDULE_LIST%>" />
		</portlet:renderURL>
		
		
		<c:if test="${editExamSchedule eq 'editExamSchedule'}">
		<a class="btn omsb-btn btn-back" href="${viewExamSchedulesURL}">
			<i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" />
		</a>
		</c:if>
		
	<c:if test="${editExamSchedule ne 'editExamSchedule'}">
		<a class="btn omsb-btn btn-back" href="${backURL}">
			<i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" />
		</a>
	</c:if>
	</div>
</form>