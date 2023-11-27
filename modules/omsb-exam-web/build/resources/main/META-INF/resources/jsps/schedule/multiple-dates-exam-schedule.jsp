<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="searchProgramId" value="${programId}" />
	<portlet:param name="searchExamTypeId" value="${examTypeId}" />
</portlet:renderURL> 

<form action="${announceScheduleExamURL}" method="post"
	name="<portlet:namespace/>announceExamSchedule" id="miForm">
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="label-name required">
					<liferay-ui:message key="program-name" />
				</div>
				<div class="label-content">
					<select name="<portlet:namespace/>program" class="form-control" multiple id="programMi"
					onchange="validateProgramNameSelection('programMi','programMiError')" >
					<c:forEach var="program" items="${exam.program}" varStatus="status">
					
					<c:set var="selected" value="${exam != null && programId == program.programId}" />
					 <option value="${program.programId}" <c:if test="${selected}">selected="selected"</c:if> >${program.programName}</option>
									        
					
					
						<!--	<option value="${program.programId}">${program.programName}</option> -->
					</c:forEach>
			        </select>
		    	</div>
			</div>
			<p id="programMiError" class="error-container d-none mdErrorClass">Please select program name.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="label-name">
					<liferay-ui:message key="exam-type" />
				</div>
				<div class="label-content">${examType}</div>
			</div>
		</div>
		
		<input type="hidden" readonly="readonly" value="${examId}" name="<portlet:namespace/>examId" id="examId" class="form-control">
		<input type="hidden" readonly="readonly" value="${examTypeId}"
			name="<portlet:namespace/>examTypeId" id="examTypeId"
			class="form-control"> <input type="hidden"
			readonly="readonly" value="${programId}"
			name="<portlet:namespace/>programId" id="programId"
			class="form-control">
			<input type="hidden" name="<portlet:namespace/>mdCMDValue" id="mdCMDValId" value="Announced">
			<input type="hidden" name="<portlet:namespace/>multiDatesValuesArray" id="multiDatesDuplicateRowValues" value="">
			<input type="hidden" name="<portlet:namespace/>selectedValues" id="selectedValues" value=""> 
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="application-start-date" /></label> <input type="text"
					name="<portlet:namespace/>mdApplicationStartDate" onchange="validateSelectAndInputField('mdApplicationStartDate','mdApplicationStartDateError');"
					value="${examSchedule.applicationStartDate}"
					id="mdApplicationStartDate" placeholder="DD/MM/YYYY"
					class="form-control datePicker"> <input type="hidden"
					readonly="readonly" value="${examSchedule.id}"
					name="<portlet:namespace/>examScheduleId" id="examScheduleId"
					class="form-control"> <input type="hidden"
					readonly="readonly" value="${examScheduleId}"
					name="<portlet:namespace/>examScheduleId" id="examScheduleId"
					class="form-control">
					
					<input type="hidden" value="${examSchedule.examScheduleAdminId}"
					name="<portlet:namespace/>examScheduleAdmnId" id="examScheduleAdmnId" class="form-control">
					<input type="hidden" value="" id="isEdit" class="form-control">
			</div>
			<p id="mdApplicationStartDateError" class="error-container d-none mdErrorClass">Please enter the application start date.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="application-end-date" /></label> <input type="text" onchange="validateSelectAndInputField('mdApplicationEndDate','mdApplicationEndDateError');"
					name="<portlet:namespace/>mdApplicationEndDate"
					value="${examSchedule.applicationEndDate}"
					id="mdApplicationEndDate" placeholder="DD/MM/YYYY"
					class="form-control datePicker">
			</div>
			<p id="mdApplicationEndDateError" class="error-container d-none mdErrorClass">Please enter the application End date.</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="no-of-seats" /></label> <input type="number" min="1" onchange="validateSelectAndInputField('mdNoOfSeats','mdNoOfSeatsError');"
					name="<portlet:namespace/>mdNoOfSeats"
					value="${examSchedule.noOfSeats}" id="mdNoOfSeats"
					class="form-control">
			</div>
			<p id="mdNoOfSeatsError" class="error-container d-none mdErrorClass">Please enter the no of seats/station.</p>
		</div>
	</div>
	<h4 class="omsb-card-title">
		<liferay-ui:message key="multiple-dates" />
	</h4>
	
			<div class="omsb">
				<div class="omsb-card omsb-card-graybg">
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-12">
						<input type="hidden" id="editMdExmDetId" value="">
						
							<div class="form-group">
								<label class="required"><liferay-ui:message
										key="exam-date" /></label> <input type="text"  onchange="validateSelectAndInputField('mdExamStartDate','mdExamStartDateError')"
									name="<portlet:namespace/>mdExamStartDate" id="mdExamStartDate"
									placeholder="DD/MM/YYYY"
									class="form-control datePicker examdate mdExamDate">
							</div>
							<p id="mdExamStartDateError" class="error-container d-none mdErrorClass">Please enter the exam date.</p>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-12">
							<div class="form-group">
								<label class="required"><liferay-ui:message
										key="exam-start-time" /></label> <input type="time"
									name="<portlet:namespace/>mdExamStartTime" id="mdExamStartTime"  onchange="validateSelectAndInputField('mdExamStartTime','mdExamStartTimeError')"
									placeholder="HH:MM" class="form-control timePicker mdExamStartTime">
							</div>
							<p id="mdExamStartTimeError" class="error-container d-none mdErrorClass">Please enter the exam start time.</p>
							<input type="hidden" id="examStartTimeHidden" value="">
						</div>
						<div class="col-lg-4 col-md-6 col-sm-12">
							<div class="form-group">
								<label class="required"><liferay-ui:message
										key="exam-end-time" /></label> <input type="time" onchange="validateSelectAndInputField('mdExamEndTime','mdExamEndTimeError')"
									name="<portlet:namespace/>mdExamEndTime" id="mdExamEndTime"
									placeholder="HH:MM" class="form-control timePicker mdExamEndTime">
							</div>
							<p id="mdExamEndTimeError" class="error-container d-none mdErrorClass">Please enter the exam start time.</p>
							<input type="hidden" id="examEndTimeHidden" value="">
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label class="required"><liferay-ui:message
										key="locate-on-google-map" /></label> <input type="text"  onkeyup="validateSelectAndInputField('mdLocateOnGoogleMap1','mdLocateOnGoogleMap1Error')"
									name="<portlet:namespace/>mdLocateOnGoogleMap"
									id="mdLocateOnGoogleMap1" data-attr="1"
									data-id="mdLocateOnGoogleMap" data-instance="md" data-place=""
									class="form-control autocompleteMap locationOnGoogleMap"> <input
									type="hidden" name="<portlet:namespace/>mdLocationOnGoogleMap"
									id="mdLocationOnGoogleMap1" data-attr="1"
									data-id="mdLocationOnGoogleMap">
							</div>
							<p id="errorContainer-mdLocateOnGoogleMap1"
								class="error-container"></p>
								<p id="mdLocateOnGoogleMap1Error" class="error-container d-none mdErrorClass">Please enter the location.</p>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label class="required"><liferay-ui:message key="venue" /></label>
								<input type="text" name="<portlet:namespace/>mdVenue" onkeyup="validateSelectAndInputField('mdVenue','mdVenueError')"
									id="mdVenue" class="form-control mdVenue">
							</div>
							<p id="mdVenueError" class="error-container d-none mdErrorClass">Please enter the venue.</p>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div id="mdmap1" class="omsb-map-h250"></div>
							<div id="mdInfoWindowContent1">
								<span id="place-name" class="label-name"></span><br /> <span
									id="place-address"></span>
							</div>
						</div>
					</div>
					<div class="bottom-backbtn-wrap">
						<button class="btn omsb-bc-red-button" onclick="saveMultipleExamDates()"
							type="button" title="Add">Add/Update</button>
					</div>
				</div>
				<div id="md_container"></div>
				<!-- Data table for Multiple date -->
		
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
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="examMultiDatesItem" items="${examMultiDates}">
							<tr>
								<td>${examMultiDatesItem.examDate}</td>
								<td>${examMultiDatesItem.startTime}</td>
								<td>${examMultiDatesItem.endTime}</td>
								<td>${examMultiDatesItem.locationOnGoogleMap}</td>
								<td class="d-none">${examMultiDatesItem.locationPinOnGoogleMap}</td>
								<td>${examMultiDatesItem.venue}</td>
								<td class="d-none">${examMultiDatesItem.id}</td>
								<td>
									<input type="hidden" id="updatedSchdAdminId" name="<portlet:namespace/>updatedSchdAdminId" value="${examMultiDatesItem.examScheduleAdminId}">
									<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteMDId('${examMultiDatesItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
									<button class="btn mx-2" value="view" data-toggle="modal" data-target="#add-education-confirm-modal" type="button" onclick="editMultExamDateObject('${examMultiDatesItem.id}','edit')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
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
			<!-- Data Table For multiple date Ends here -->	
			
		
			</div>
			<p id="formError" class="error-container d-none mdErrorClass">Please click Add/Update for all mendatory Details to update your Data.</p>
	
	
	
	<input type="hidden" name="<portlet:namespace />mDCMD" id="<portlet:namespace />mdCMD" value="<%=DataflowConstants.ANNOUNCED%>">
	<div class="bottom-backbtn-wrap mt-2">
		<button class="btn omsb-bc-red-button" onclick="multipleInstanceFormValidation(event)" type="button">
			<liferay-ui:message key="announce"></liferay-ui:message>
		</button>
		<button class="btn omsb-bc-red-button" onclick="setNotAnnouncedExamStatus('md','${examSchedule.examStatus}')" type="button" title="save as draft">
			<liferay-ui:message key="save-as-draft" />
		</button>
		<button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#exam-schedule-md-discard" type="button">
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
			<i class="fi fi-sr-arrow-left"></i> 
			<liferay-ui:message key="back" />
		</a>
	</c:if>	
	</div>
</form>
	<!--delete popup for Education  Detail -->
		<div class="modal fade omsb-modal" id="delete-education-confirm-modal" tabindex="-1" role="dialog"
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
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteMDRowData()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="cancelBttn"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->