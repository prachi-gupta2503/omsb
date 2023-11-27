
<%@ include file="../../init.jsp"%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="searchProgramId" value="${programId}" />
	<portlet:param name="searchExamTypeId" value="${examTypeId}" />
</portlet:renderURL>

<form action="${announceScheduleExamURL}" method="post"
	name="<portlet:namespace/>announceExamSchedule" id="riForm">
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="label-name">
					<liferay-ui:message key="program-name" />
				</div>
				<div class="label-content">
					<select name="<portlet:namespace/>program" class="form-control" multiple id="programRi"
					onchange="validateProgramNameSelection('programRi','programRiError')" >
					<c:forEach var="program" items="${exam.program}" varStatus="status">
					
					<c:set var="selected" value="${exam != null && programId == program.programId}" />
					 <option value="${program.programId}" <c:if test="${selected}">selected="selected"</c:if> >${program.programName}</option>
									        
					
					</c:forEach>
			        </select>
		    	</div>
			</div>
			<p id="programRiError" class="error-container d-none riErrorClass">Please select program name.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="label-name"><liferay-ui:message key="exam-type" /></div>
				<div class="label-content">${examType}</div>
			</div>
		</div>

		<input type="hidden" readonly="readonly" value="${examId}" name="<portlet:namespace/>examId" id="examId" class="form-control">
		<input type="hidden" readonly="readonly" value="${examTypeId}" name="<portlet:namespace/>examTypeId" id="examTypeId" class="form-control"> 
		<input type="hidden" readonly="readonly" value="${programId}" name="<portlet:namespace/>programId" id="programId" class="form-control">
		<input type="hidden" readonly="readonly" value="${examScheduleId}" name="<portlet:namespace/>examScheduleId" id="examScheduleId" class="form-control" >

		<input type="hidden" name="<portlet:namespace/>selectedValues" id="selectedValues" value="">
		<input type="hidden" name="<portlet:namespace/>riSelectedValues" id="riSelectedValuesId" value="">
		<input type="hidden" name="<portlet:namespace/>riMultiDatesValuesArray" id="riMultiDatesDuplicateRowValues" value="">

		<input type="hidden" value="${examScheduleAdminId}" name="<portlet:namespace/>riExamScheduleAdmnId" id="riExamScheduleAdmnId" class="form-control">
		<input type="hidden" id="editRiExmDetId" value="" class="form-control">
		<input type="hidden" id="riCMDStatusId" name="<portlet:namespace/>riCMDStatus" value="Announced" class="form-control">

		
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="application-start-from-no-of-days-before-exam" /></label> <input
					type="text" name="<portlet:namespace/>riApplicationStartDaysBefore"  onkeypress="return /[1-9]+$/i.test(event.key)" maxlength="2"
					onkeyup="validateSelectAndInputField('riApplicationStartDaysBefore','riApplicationStartDaysBeforeError')"
					id="riApplicationStartDaysBefore" class="form-control">
			</div>
			<p id="riApplicationStartDaysBeforeError" class="error-container d-none riErrorClass">Please enter application start days before.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="application-ends-at-no-of-days-before-exam" /></label> <input
					type="text" name="<portlet:namespace/>riApplicationEndsDaysBefore" onkeypress="return /[1-9]+$/i.test(event.key)" maxlength="2"
					onkeyup="validateSelectAndInputField('riApplicationEndsDaysBefore','riApplicationEndsDaysBeforeError')"
					id="riApplicationEndsDaysBefore" class="form-control">
			</div>
			<p id="riApplicationEndsDaysBeforeError" class="error-container d-none riErrorClass">Please enter application end days before.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-starts-from" /></label> <input
					type="text" name="<portlet:namespace/>riExamStartFrom" onchange="validateSelectAndInputField('riExamStartsFrom','riExamStartsFromError')"
					id="riExamStartsFrom" placeholder="DD/MM/YYYY"
					class="form-control datePicker riExamStartsFrom">
			</div>
			<p id="riExamStartsFromError" class="error-container d-none riErrorClass">Please select exam start date.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-ends-on" /></label> <input
					type="text" name="<portlet:namespace/>riExamEndOn" onchange="validateSelectAndInputField('riExamEndsOn','riExamEndsOnError')"
					id="riExamEndsOn" placeholder="DD/MM/YYYY"
					class="form-control datePicker riExamEndsOn">
			</div>
			<p id="riExamEndsOnError" class="error-container d-none riErrorClass">Please select exam end date.</p>
		</div>
	</div>
	<h4 class="omsb-card-title">
		<liferay-ui:message key="repeated-instance" />
	</h4>
	
	<div class="repeated-instance">
		<div class="omsb-card omsb-card-graybg">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-12">
				<input type="hidden" id="editRIExmDetId" value="">
				<input type="hidden" id="isRIEdit" value="">
				
					<div class="form-group">
						<label class="required"><liferay-ui:message key="days-of-week" /></label> <select onchange="validateSelectAndInputField('riDaysOfWeek','riDaysOfWeekError')"
							name="<portlet:namespace/>riDaysOfWeek" class="form-control riDaysOfWeek" multiple id="riDaysOfWeek">
							<%-- <option value=""><liferay-ui:message key="select" /></option> --%>
							<option value="Monday"><liferay-ui:message key="monday" /></option>
							<option value="Tuesday"><liferay-ui:message
									key="tuesday" /></option>
							<option value="Wednesday"><liferay-ui:message
									key="wednesday" /></option>
							<option value="Thursday"><liferay-ui:message
									key="thursday" /></option>
							<option value="Friday"><liferay-ui:message key="friday" /></option>
							<option value="Saturday"><liferay-ui:message
									key="saturday" /></option>
							<option value="Sunday"><liferay-ui:message key="sunday" /></option>
						</select>
					</div>
					<p id="riDaysOfWeekError" class="error-container d-none riErrorClass">Please select week days.</p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="exam-start-time" /></label> <input
							type="time" name="<portlet:namespace/>riExamStartTime"
							id="riExamStartTime" placeholder="HH:MM "
							class="form-control timePicker riExamStartTime">
					</div>
					<input type="hidden" id="riExamStartTimeHidden" value="">
					<p id="riExamStartTimeError" class="error-container d-none riErrorClass">Please select exam start time.</p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="exam-end-time" /></label> <input
							type="time" name="<portlet:namespace/>riExamEndTime"
							id="riExamEndTime" placeholder="HH:MM"
							class="form-control timePicker riExamEndTime">
					</div>
					<input type="hidden" id="riExamEndTimeHidden" value="">
					<p id="riExamEndTimeError" class="error-container d-none riErrorClass">Please select exam end time.</p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="no-of-seats" /></label> <input
							type="number" min="1" name="<portlet:namespace/>riNoOfSeats" onkeyup="validateSelectAndInputField('riNoOfSeats','riNoOfSeatsError')"
							id="riNoOfSeats" class="form-control riNoOfSeats">
					</div>
					<p id="riNoOfSeatsError" class="error-container d-none riErrorClass">Please enter no of seats.</p>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="locate-on-google-map" /></label>
						<input type="text" name="<portlet:namespace/>riLocateOnGoogleMap"  onkeyup="validateSelectAndInputField('riLocateOnGoogleMap1','riLocateOnGoogleMap1Error')"
							id="riLocateOnGoogleMap1" data-attr="1" data-instance="ri"
							class="form-control autocompleteMap riLocationOnGoogleMap"> <input
							type="hidden" name="<portlet:namespace />riLocationOnGoogleMap"
							id="riLocationOnGoogleMap" data-attr="1">
					</div>
					<p id="riLocateOnGoogleMap1Error" class="error-container d-none riErrorClass">Please enter location.</p>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="venue" /></label> <input
							type="text" name="<portlet:namespace/>riVenue" id="riVenue"  onkeyup="validateSelectAndInputField('riVenue','riVenueError')"
							class="form-control riVenue">
					</div>
					<p id="riVenueError" class="error-container d-none riErrorClass">Please enter the venue.</p>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div id="rimap1" class="omsb-map-h250"></div>
					<div id="riInfoWindowContent1">
						<span id="place-name" class="label-name"></span><br /> <span
							id="place-address"></span>
					</div>
				</div>
			</div>
			<div class="bottom-backbtn-wrap m-0">
				<button class="btn omsb-bc-red-button" onclick="saveUpdateRepeatedInstance()"
					type="button" title="Add">
					<liferay-ui:message key="add-update" />
				</button>
			</div>
		</div>
		<div id="repeatedInstance"></div>
	<div id="educationDetailsRIList">	
		<c:choose>
	<c:when test="${!empty examMultiDates}">
		<table class="display omsb-datatables" id="Repeated_dates_Table"
			width="100%">
			<thead>
				<tr>
					<%-- <th><liferay-ui:message key="id" /></th> --%>
					
					<th><liferay-ui:message key="days-of-week" /></th>
					<th><liferay-ui:message key="exam-start-time" /></th>
					<th><liferay-ui:message key="exam-end-time" /></th>
					<th><liferay-ui:message key="no-of-seats" /></th>
					<th><liferay-ui:message key="locate-on-google-map" /></th>
					<th><liferay-ui:message key="venue" /></th>
					<th><liferay-ui:message key="action" /></th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach var="examScheduleItem" items="${examMultiDates}">
				<tr>
					<%-- <td>${examMultiDatesItem.id}</td> --%>
					<td>${examScheduleItem.daysOfWeek}</td>
					<td>${examScheduleItem.startTime}</td>
					<td>${examScheduleItem.endTime}</td>
					<td>${examScheduleItem.noOfSeats}</td>
					<td>${examScheduleItem.locationOnGoogleMap}</td>
					<td class="d-none" >${examScheduleItem.locationPinOnGoogleMap}</td>
					<td>${examScheduleItem.venue}</td>
					<td class="d-none">${examScheduleItem.id}</td>
					<td>
					<input type="hidden" id="updatedRIExamScheduleAdmnId" name="<portlet:namespace/>updatedRIExamScheduleAdmnId" value="${examScheduleItem.examScheduleAdminId}">
						<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-RI-Data-table" data-rowcount="addPopUpRow" onclick="setDeleteRIId('${examScheduleItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
						<button class="btn mx-2" value="view"  type="button" onclick='editRepeatedInstanceExamObject(`${examScheduleItem.id}`,`${examScheduleItem.daysOfWeek}`, `${examScheduleItem.startTime}`, `${examScheduleItem.endTime}`, `${examScheduleItem.noOfSeats}`, `${examScheduleItem.locationOnGoogleMap}`, `${examScheduleItem.locationPinOnGoogleMap}`,`${examScheduleItem.venue}`,`edit`)' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-records-found" />
	</c:otherwise>
</c:choose>
</div>

	</div>
	<p id="riFormError" class="error-container d-none riErrorClass">Please click Add/Update for all mendatory Details to update your Data.</p>
	<input type="hidden" id="<portlet:namespace />repeatedInstanceDuplicateRowValues" name="<portlet:namespace />repeatedInstanceDuplicateRowValues">
	<input type="hidden" name="<portlet:namespace />riCMD" id="<portlet:namespace />riCMD" value="<%=DataflowConstants.ANNOUNCED%>">
		<div class="bottom-backbtn-wrap mt-2">
			<button class="btn omsb-bc-red-button" onclick="repeatedInstanceFormValidation(event)" type="button" title="Announce">
				<liferay-ui:message key="announce" />
			</button>
			<button class="btn omsb-bc-red-button" onclick="setNotAnnouncedExamStatus('ri')" type="button" title="save as draft">
				<liferay-ui:message key="save-as-draft" />
			</button>
		
			<button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#exam-schedule-ri-discard" type="button">
				<liferay-ui:message key="discard" />
			</button>
			<a class="btn omsb-btn btn-back" href="${backURL}">
				<i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" />
			</a>
		</div>
</form>
<!--delete popup for Education  Detail -->
		<div class="modal fade omsb-modal" id="delete-RI-Data-table" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteRIRowData()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="riCancelPopUpBttn"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->