<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<portlet:renderURL var="viewOCTScheduledExams">
<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER%>" />
</portlet:renderURL>

			

<portlet:resourceURL
	id="<%=MVCCommandNames.SECTION_DEPARTMENT_MVC_RESOURCE%>"
	var="sectionDepartmentURL" />
	

<c:set var="selectedDepartmentKey"
	value="${examSchedule.getDepartmentKey()}"></c:set>
<c:set var="selectedSectionKey"
	value="${examSchedule.getSectionKey()}"></c:set>
		
	

<portlet:resourceURL
	id="<%=MVCCommandNames.SAVE_UPDATE_OCT_REPEATED_INSTANCE%>"
	var="saveExamSceduleDetailURL" />

<form action="${examScheduleActions}" method="post"
	name="<portlet:namespace/>announceExamSchedule" id="riForm">
	<div class="row">


		<input type="hidden" name="<portlet:namespace />octExamId"
			id="<portlet:namespace />octExamId" value="${octExamId}">
 	
 	<input type="hidden" id="selectedSectionKey" value="${selectedSectionKey }">
 	<input type="hidden" id="editRIExmDetId" value="">
	<input type="hidden" id="isRIEdit" value="">
	<input type="hidden" value="${examSchedule.getoCExamScheduleAdminId()}" name="<portlet:namespace/>riExamScheduleAdmnId" id="riExamScheduleAdmnId" class="form-control">
 	
	
		
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="registration-start-date" /></label> <input type="text"
					onchange="validateInputField('riRegistrationStartDate','errorContainer-riRegistrationStartDate');"
					name="<portlet:namespace />riRegistrationStartDate" value="${examSchedule.getRegistrationStartDate()}"
					id="riRegistrationStartDate" placeholder="DD/MM/YYYY"
					class="form-control datePicker" autocomplete="off">
			</div>
			<p id="errorContainer-riRegistrationStartDate" class="error-container riErrorClass d-none"><liferay-ui:message key='enter-registration-start-date' /></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="registration-end-date" /></label> <input type="text"
					name="<portlet:namespace />riRegistrationEndDate" value="${examSchedule.getRegistrationEndDate()}"
					id="riRegistrationEndDate" placeholder="DD/MM/YYYY"
					onchange="validateInputField('riRegistrationEndDate','errorContainer-riRegistrationEndDate');"
					class="form-control datePicker" autocomplete="off">
			</div>
			<p id="errorContainer-riRegistrationEndDate" class="error-container riErrorClass d-none"><liferay-ui:message key='enter-registration-end-date' /></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<label class="required"><liferay-ui:message
							key="exam-start-date" /></label> <input type="text" value="${examSchedule.getExamStartDate()}"
						name="<portlet:namespace/>riExamStartDate" id="riExamStartDate" onchange="validateInputField('riExamStartDate','errorContainer-riExamStartDate')"
						onchange="validateInputFieldForSchdlForm('riExamStartDate','errorContainer-riExamStartDate','<liferay-ui:message key='enter-exam-start-date' />');"
						placeholder="DD/MM/YYYY" class="form-control datePicker"
						autocomplete="off">
				</div>
				<p id="errorContainer-riExamStartDate" class="error-container d-none"><liferay-ui:message key="enter-exam-start-date" /></p>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<label class="required"><liferay-ui:message
							key="exam-end-date" /></label> <input type="text" value="${examSchedule.getExamEndDate()}"
						name="<portlet:namespace/>riExamEndDate" id="riExamEndDate" onchange="validateInputField('riExamEndDate','errorContainer-riExamEndDate')"
						onchange="validateInputFieldForSchdlForm('riExamEndDate','errorContainer-riExamEndDate','<liferay-ui:message key='enter-exam-end-date' />');"
						placeholder="DD/MM/YYYY" class="form-control datePicker"
						autocomplete="off">
				</div>
				<p id="errorContainer-riExamEndDate" class="error-container d-none"><liferay-ui:message key="enter-exam-end-date" /></p>
			</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label><liferay-ui:message key="department-name" /></label> <select
					id="riDepartmentId" name="<portlet:namespace/>riDepartmentId" onchange="validateInputField('riDepartmentId','errorContainer-riDepartmentId')"
					class="form-control">
					<option value=""><liferay-ui:message key="select" /></option>
					<c:forEach var="octExamDepartment" items="${octExamDepartmentList}">

						<%-- <option value="${octExamDepartment.getKey()}">
							<liferay-ui:message
								key="${octExamDepartment.getName(themeDisplay.getLocale())}" />
						</option> --%>
						
						<c:choose>
							<c:when
								test="${octExamDepartment.getKey() eq selectedDepartmentKey}">
								<option value="${octExamDepartment.getKey()}" selected>
									${octExamDepartment.getName(themeDisplay.getLocale())}</option>
							</c:when>
							<c:otherwise>
								<option value="${octExamDepartment.getKey()}">
									<liferay-ui:message
										key="${octExamDepartment.getName(themeDisplay.getLocale())}" />
								</option>
							</c:otherwise>
						</c:choose>
						

					</c:forEach>
				</select>
				<p id="errorContainer-riDepartmentId" class="error-container d-none riErrorClass"><liferay-ui:message key="enter-department" /></p>
			</div>
		</div>

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label><liferay-ui:message key="section" /></label> <select
					name="<portlet:namespace/>riSectionId" id="riSectionId" onchange="validateInputField('riSectionId','errorContainer-riSectionId')"
					class="form-control">
					<option value=""><liferay-ui:message key="select" /></option>

					<c:forEach var="section" items="${octExamSectionList}">
					
					<c:choose>
							<c:when
								test="${section.getKey() eq selectedSectionKey}">
								<option value="${section.getKey()}" selected>
									${section.getName(themeDisplay.getLocale())}</option>
							</c:when>
							<c:otherwise>
								<option value="${section.getKey()}">
									<liferay-ui:message
										key="${section.getName(themeDisplay.getLocale())}" />
								</option>
							</c:otherwise>
						</c:choose>
					
					
						
					</c:forEach>
				</select>
				<p id="errorContainer-riSectionId" class="error-container d-none riErrorClass"><liferay-ui:message key="enter-section" /></p>
			</div>
		</div>

		<!-- -------------------------------------------------------------------------------- -->

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="locate-on-google-map" /></label> <input type="text" onkeyup="validateInputField('riLocateOnGoogleMap1','errorContainer-riLocateOnGoogleMap1')"
					name="<portlet:namespace/>riLocateOnGoogleMap" value="${examSchedule.getLocationOnGoogleMap()}"
					id="riLocateOnGoogleMap1" data-attr="1" data-instance="ri" data-place="${examSchedule.getLocationOnGoogleMap()}" 
					class="form-control autocompleteMap"> <input type="hidden" value="${examSchedule.getLocationOnGoogleMap()}"
					name="<portlet:namespace />riLocationOnGoogleMap1"
					id="riLocationOnGoogleMap1" data-attr="1">
			</div>
			<p id="errorContainer-riLocateOnGoogleMap1" class="error-container d-none riErrorClass"> <liferay-ui:message key="enter-location" /></p>
		</div>

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="venue" /></label>
				<input type="text" name="<portlet:namespace/>riVenue" id="riVenue" value="${examSchedule.getVenue()}"
				 onkeyup="validateInputField('riVenue','errorContainer-riVenue')"
					placeholder="<liferay-ui:message key="enter-a-venue" />"
					class="form-control">
			</div>
			<p id="errorContainer-riVenue" class="error-container d-none riErrorClass"> <liferay-ui:message key="enter-venue" /></p>
		</div>

		<div class="col-lg-12 col-md-12 col-sm-12">
			<div id="rimap1" class="omsb-map-h250"></div>
			<div id="riInfoWindowContent1">
				<span id="place-name" class="label-name"></span><br /> <span
					id="place-address"></span>
			</div>
		</div>



		<!-- ------------------------------------------------------------------------------------------------------------------------- -->


	</div>
	<h4 class="omsb-card-title">
		<liferay-ui:message key="repeated-instance" />
	</h4>
	

	<div class="repeated-instance">
		<div class="omsb-card omsb-card-graybg">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message
								key="days-of-week" /></label> <select
							name="<portlet:namespace/>riDaysOfWeek" class="form-control" multiple onchange="validateInputField('riDaysOfWeek1','errorContainer-riDaysOfWeek')"
							id="riDaysOfWeek1"> 
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
					<p id="errorContainer-riDaysOfWeek" class="error-container error-container-daysOfWeek d-none riErrorClass"> <liferay-ui:message key="enter-days-of-week" /></p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message
								key="exam-center" /></label> <select id="riTrainingSiteId-1" onchange="validateInputField('riTrainingSiteId-1','errorContainer-riTrainingSite')"
							data-attr="1" name="<portlet:namespace/>riTrainingSite"
							class="form-control">
							<option value=""><liferay-ui:message key="select" /></option>
							<c:forEach var="octTrainingSite" items="${octTrainingSiteList}">
								<option value="${octTrainingSite.listTypeEntryId}">
									<liferay-ui:message key="${octTrainingSite.getName(themeDisplay.getLocale())}" />
								</option>
							</c:forEach>
						</select>
					</div>
					<p id="errorContainer-riTrainingSite" class="error-container error-container-trainingSite d-none riErrorClass"> <liferay-ui:message key="select-training-site" /></p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message
								key="exam-slots" /></label> <select id="riExamSlotsId-1" data-attr="1" onchange="validateInputField('riExamSlotsId-1','errorContainer-riExamSlots')"
							name="<portlet:namespace/>riExamSlotList" class="form-control"
							multiple size="5">
							
						</select>
					</div>
					<p id="errorContainer-riExamSlots" class="error-container error-container-examSlotList d-none riErrorClass"><liferay-ui:message key="select-exam-slot-list" /></p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-12">
					<div class="form-group">
						<label class="required"><liferay-ui:message
								key="no-of-seats" /></label> <input type="number" min="1" onkeyup="validateInputField('riNoOfSeats','errorContainer-riNoOfSeats')"
							placeholder="<liferay-ui:message key="enter-no-of-seats" />"
							name="<portlet:namespace/>riNoOfSeats" id="riNoOfSeats"
							class="form-control">
					</div>
					<p id="errorContainer-riNoOfSeats" class="error-container error-container-seats d-none riErrorClass"><liferay-ui:message key="enter-no-of-seats" /></p>
				</div>
			</div>
			<!-- Data table for repeated Instance-->
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
									<th><liferay-ui:message key="action" /></th>
									
								</tr>
							</thead>
							<tbody>
							<c:forEach var="examScheduleItem" items="${ocExamMultiDates}">
								<tr>
									
									<td>${examScheduleItem.daysOfWeek}</td>
									<td>${examScheduleItem.examCenterName}</td>
									<td>${examScheduleItem.examSlot}</td>
									<td>${examScheduleItem.noOfSeats}</td>
									
									<td class="d-none">${examScheduleItem.id}</td>
									<td class="d-none">${examScheduleItem.examCenter}</td>
									<td class="d-none">${examScheduleItem.daysOfWeekList}</td>
									<td class="d-none">${examScheduleItem.examSlotList}</td>
									
									<td>
									<input type="hidden" id="updatedRIExamScheduleAdmnId" name="<portlet:namespace/>updatedRIExamScheduleAdmnId" value="${examScheduleItem.oCExamScheduleAdminId}">
										<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-RI-Data-table" data-rowcount="addPopUpRow" onclick="setDeleteRIId('${examScheduleItem.id}',this)" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
										<button class="btn mx-2" value="view"  type="button" onclick="editRepeatedInstanceExamObject('${examScheduleItem.id}','edit')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
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
			
			<div class="bottom-backbtn-wrap m-0">
				<button class="btn omsb-bc-red-button" onclick="saveUpdateRepeatedInstance()"
					type="button" title="Add">
					<liferay-ui:message key="add" />
				</button>
			</div>
		</div>
		<div id="repeatedInstance"></div>
	</div>
	<p id="formError" class="error-container d-none riFormErrorClass"> <liferay-ui:message key="please-click-add-or-update-for-all-mandatory-details-to-update-your-data" /></p>
	
	<input type="hidden"
		id="repeatedInstanceDuplicateRowValues" name="<portlet:namespace />repeatedValuesArray" value="">
	<input type="hidden" name="<portlet:namespace />riCMD"
		id="<portlet:namespace />riCMD"
		value="<%=DataflowConstants.ANNOUNCED%>">
	<div class="bottom-backbtn-wrap mt-2">
		<button class="btn omsb-bc-red-button"
			onclick="validateAndSubmitScheduleForm('ri', 'announce', event)"
			type="button" title="Announce">
			<liferay-ui:message key="announce" />
		</button>
		<button class="btn omsb-bc-red-button"
			onclick="validateAndSubmitScheduleForm('ri','saveAsDraft', event)"
			type="button" title="save as draft">
			<liferay-ui:message key="save-as-draft" />
		</button>

		<button class="btn omsb-bc-red-button" data-toggle="modal"
			data-target="#exam-schedule-ri-discard" type="button">
			<liferay-ui:message key="discard" />

		</button>
		<%-- <a class="btn omsb-btn btn-back" href="${backURL}"><i
			class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a> --%>
			
			<c:if test="${action eq 'edit'}">
					<a class="btn omsb-btn btn-back" href="${viewOCTScheduledExams}"><i
						class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</c:if>
			
			<c:if test="${action ne 'edit'}">
						<a class="btn omsb-btn btn-back" href="${backURL}"><i
						class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</c:if>
	</div>
<div class="modal fade omsb-modal " id="si-exist-exam-setup" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="row">
					
	                <div class="col-md-12">
	                	<p class='m-0'></p>
	                </div>
	               
                </div>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg">
					<div class="row">
						<div class="col-md-12">
							<liferay-ui:message key="exam-title-confirmation-text" />
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button"  type="button" id="yes_btn" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" id="no_btn" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade omsb-modal " id="exist-exam-setup" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="row">
					
	                <div class="col-md-12">
	                	<p class='m-0'></p>
	                </div>
	               
                </div>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg">
					<div class="row">
						<div class="col-md-12">
							<liferay-ui:message key="exam-title-confirmation-text" />
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button"  type="button" id="yes_btn" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" id="no_btn" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
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

<script>

 $('.riDaysOfWeek').multiselect();
 $('#riDaysOfWeek1').multiselect();
 



var existExamConfirm = $("#exist-exam-setup");

$(document).on('change','#riDepartmentId',function(){
    var departmentId=$('#riDepartmentId').val();
    setSection("riDepartmentId","riSectionId");
});

function setSection(departmentId, sectionId){
    var inputDepartmentId=$("#"+departmentId).val();

    $.ajax({
        url: '${sectionDepartmentURL}',
        async: false,
        dataType: "json",
        data: {
            "<portlet:namespace />departmentId": inputDepartmentId
        },
        type: 'POST',
        success: function(data) {
            
            var response = data;
            var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
            
            for (var i = 0; i < response.length; i++) {
                sectionData += "<option value='" + response[i].key + "'>" + response[i].name + "</option>";
            }
            
            $("#" + sectionId).html(sectionData); 
        }
    });
}


$(document).ready(function () {
	var examInstances = document.getElementsByClassName('omsb-card-graybg');
	for (var i = 1; i < examInstances.length; i++) {
			$('#riExamSlotsId-'+i).multiselect();
	  }


	$(document).on('change','select',function(){
		var id = $(this).attr('id');
		if(id.includes('riTrainingSiteId')){
			var rowNumber = id.split('-')[1];
			 var selectedTrainingSiteId = $('#riTrainingSiteId-'+rowNumber).val();
			
			 console.log("selectedTrainingSiteId ... "+selectedTrainingSiteId);
			 
			    $('#riExamSlotsId-'+rowNumber+' option').remove(); // Clear existing results
			    
			    $.ajax({
					url: '${getDropdownListURL}',
					async : false,
					dataType:"json",
					data : {
						<portlet:namespace />trainingSiteId : selectedTrainingSiteId,
						<portlet:namespace />resourceName : 'examSlotList'
					},
					type : 'POST',
					success : function(data) {
						var response = data;
			            for (var i = 0; i < response.length; i++) {
			            	 $("#riExamSlotsId-"+rowNumber).append("<option value='" + response[i].value + "'>" + response[i].name + "</option>");
			            }
			            
			            $('#riExamSlotsId-'+rowNumber).multiselect('rebuild');
					},
				})
		}
	   
	});
});

//Add Data on dataTable
function saveUpdateRepeatedInstance(){
	
	var isValid=validateRepeatedInstanceform('partialForm');
	
	if(true){
		
		var octExamId=$('#<portlet:namespace />octExamId').val();
		var riExamStartDate=$('#riExamStartDate').val();
		var riExamEndDate=$('#riExamEndDate').val();
		var riDepartmentId=$('#riDepartmentId').val();
		var riSectionId=$('#riSectionId').val();
		var riLocationOnGoogleMap1= $('#riLocationOnGoogleMap1').val();
		var riVenue= $('#riVenue').val();
		
		var repeatedInstanceDuplicateRowValues= $('#<portlet:namespace />repeatedInstanceDuplicateRowValues').val();
		var riCMD= $('#<portlet:namespace />riCMD').val();
		var riDaysOfWeek1= $('#riDaysOfWeek1').val();
		var riTrainingSiteId= $('#riTrainingSiteId-1').val();
		var riNoOfSeats= $('#riNoOfSeats').val();
		var riExamSlotsId= $('#riExamSlotsId').val();
		var riRegistrationStartDate = $('#riRegistrationStartDate').val();
		var riRegistrationEndDate = $('#riRegistrationEndDate').val();
		
		var examScheduleAdmnId= $('#riExamScheduleAdmnId').val();
		var values = [];
		var addedValues = {
			 	//id : $('#examId').val(),
			 	dayOfWeek :$('#riDaysOfWeek1').val(),
				trainingSite : $('#riTrainingSiteId-1').val(),
				examSlotList : $('#riExamSlotsId-1').val(),
				noOfSeats : $('#riNoOfSeats').val(),
				id : $('#editRIExmDetId').val()
			};
	 	values.push(addedValues);
	 	console.log("values:"+values);
	 	console.log("values stringify:"+JSON.stringify(values));
	 	
		$.ajax({
			url: '${saveExamSceduleDetailURL}',
			dataType : 'json',
			async : false,
			data : {
				<portlet:namespace />command : "saveDetails",
				<portlet:namespace />octExamId : octExamId,
				<portlet:namespace />riExamStartDate : riExamStartDate,
				<portlet:namespace />riExamEndDate : riExamEndDate,
				<portlet:namespace />riDepartmentId : riDepartmentId,
				<portlet:namespace />riSectionId : riSectionId,
				<portlet:namespace />riLocationOnGoogleMap1 : riLocationOnGoogleMap1,
				<portlet:namespace />riVenue : riVenue,
				<portlet:namespace />repeatedInstanceDuplicateRowValues : JSON.stringify(values),
				<portlet:namespace />status : "Pending",
				<portlet:namespace />riTrainingSiteId : riTrainingSiteId,
				<portlet:namespace />riNoOfSeats : riNoOfSeats,
				<portlet:namespace />riExamSlotsId : riExamSlotsId,
				<portlet:namespace />riRegistrationStartDate : riRegistrationStartDate,
				<portlet:namespace />riRegistrationEndDate : riRegistrationEndDate,
				<portlet:namespace />riExamScheduleAdmnId : examScheduleAdmnId
				
				
			},
			type : 'POST',
			success : function(data) {
				
				
			},
			complete: function(data) {debugger
				console.log(data);
				//octRepeatedInstanceDiv
				$("#octRepeatedInstanceDiv").html(data.responseText.trim());
				$('#riExamScheduleAdmnId').val($('#updatedRIExamScheduleAdmnId').val());
				$('#isRIEdit').val('');
				$('#editRIExmDetId').val('');
				$('#examScheduleAdminID').val($('#updatedRIExamScheduleAdmnId').val());
				
	        },
		})
	}
	$('#riNoOfSeats').val('');
	$('#riTrainingSiteId-1').val('');
	$('#riExamSlotsId-1').multiselect('clearSelection');
	$('#riDaysOfWeek1').multiselect('clearSelection');
} 
	
function editRepeatedInstanceExamObject(examMultiDateId, command){

var octExamId=$('#<portlet:namespace />octExamId').val();

var examScheduleAdminId= $('#updatedRIExamScheduleAdmnId').val();

	$.ajax({
		url: '${saveExamSceduleDetailURL}',
		async : false,
		data : {
			
			<portlet:namespace />command : "editDetails",
			<portlet:namespace />flowType : "repeatedInstance",
			<portlet:namespace />octExamId : octExamId,
			<portlet:namespace />riExamScheduleAdmnId : examScheduleAdminId,
			<portlet:namespace />examMultiDateId : examMultiDateId
						
		},
		type : 'POST',
		success : function(data) {debugger
			
			console.log('data::',data);
		console.log('Success Function');
		const response = JSON.parse(data);
		if(response != undefined){
			
			console.log("exam slot:"+response.examSlot)
			$('#riNoOfSeats').val(response.noOfSeats);
			
			  $('#riTrainingSiteId-1').val(response.examCenter).attr("selected", "selected");
		
			console.log("day of week:", response.daysOfWeek);
			const selectedDaysArray = JSON.parse(response.daysOfWeek);
			selectedDaysArray.forEach(function(day) {
				  $('#riDaysOfWeek1 option[value="' + day + '"]').prop('selected', true);
				});

			 $('#riDaysOfWeek1').multiselect('rebuild');
			 
			 const examSlotString = response.examSlot;
			 const selectedExamSlotArray = JSON.parse(examSlotString);

			 selectedExamSlotArray.forEach(function(timeSlot) {
			     $('#riExamSlotsId-1 option[value="' + timeSlot.trim() + '"]').prop('selected', true);
			 });
			 $('#riExamSlotsId-1').multiselect('rebuild');
			 
			$('#editRIExmDetId').val(examMultiDateId);
			$('#isRIEdit').val('edit')
			}
			
		},
		complete: function(data) {
			console.log(data);
		
        },
	})

} 
function deleteRepeatedInstanceObject(examMultiDateId, command){

var octExamId=$('#<portlet:namespace />octExamId').val();

var examScheduleAdminId= $('#updatedRIExamScheduleAdmnId').val();
	$.ajax({
		url: '${saveExamSceduleDetailURL}',
		async : false,
		data : {
			
			<portlet:namespace />command : "deleteDetails",
			<portlet:namespace />flowType : "repeatedInstance",
			<portlet:namespace />octExamId : octExamId,
			<portlet:namespace />riExamScheduleAdmnId : examScheduleAdminId,
			<portlet:namespace />examMultiDateId : examMultiDateId
		},
		type : 'POST',
		success : function(data) {
			console.log('Success Function');
			$("#octRepeatedInstanceDiv").html(data.trim());
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
	
	$("#delete-RI-Data-table").attr("exmMltDateId",id);
		$("#delete-RI-Data-table").data("row", row);
	}
function deleteRIRowData() {
	var exmMltDateId = $("#delete-RI-Data-table").attr("exmMltDateId");
	deleteRepeatedInstanceObject(exmMltDateId, "deleteDetails");
}
//validate form
function validateInputField(id,errorId){
	var keyVal = $('#'+id).val();
    if (keyVal != undefined && keyVal != '') {
        $('#'+errorId).addClass('d-none');
        return true;
    } else {
        $('#'+errorId).removeClass('d-none');
        return false;
    }
    
}
function validateRepeatedInstanceform(key){
	$('#riFormErrorClass').addClass('d-none');
	$('.riErrorClass').addClass('d-none');
	if(key == "partialForm"){
		var riExamStartDate = validateInputField('riExamStartDate','errorContainer-riExamStartDate');
		var riExamEndDate = validateInputField('riExamEndDate','errorContainer-riExamEndDate');
		var riRegistrationStartDate = validateInputField('riRegistrationStartDate','errorContainer-riRegistrationStartDate');
		var riRegistrationEndDate = validateInputField('riRegistrationEndDate','errorContainer-riRegistrationEndDate');
		var riLocationOnGoogleMap1 = validateInputField('riLocateOnGoogleMap1','errorContainer-riLocateOnGoogleMap1');
		var riVenue = validateInputField('riVenue','errorContainer-riVenue');
		var riDaysOfWeek1 = validateInputField('riDaysOfWeek1','errorContainer-riDaysOfWeek');
		var riTrainingSiteId = validateInputField('riTrainingSiteId-1','errorContainer-riTrainingSite');
		var riExamSlotsId = validateInputField('riExamSlotsId-1','errorContainer-riExamSlots');
		var riNoOfSeats = validateInputField('riNoOfSeats','errorContainer-riNoOfSeats');
		if(riExamStartDate && riExamEndDate && riRegistrationStartDate && riRegistrationEndDate && riLocationOnGoogleMap1 && riVenue
				&& riDaysOfWeek1 && riTrainingSiteId && riExamSlotsId && riNoOfSeats){
			return true;
		}else{
			return false;
		}
	}else{
		if($("#Repeated_dates_Table tbody tr").length == 0){
			$('#riFormErrorClass').removeClass('d-none');
			return false;
		}else{
			var riExamStartDate = validateInputField('riExamStartDate','errorContainer-riExamStartDate');
			var riExamEndDate = validateInputField('riExamEndDate','errorContainer-riExamEndDate');
			var riRegistrationStartDate = validateInputField('riRegistrationStartDate','errorContainer-riRegistrationStartDate');
			var riRegistrationEndDate = validateInputField('riRegistrationEndDate','errorContainer-riRegistrationEndDate');
			var riLocationOnGoogleMap1 = validateInputField('riLocateOnGoogleMap1','errorContainer-riLocateOnGoogleMap1');
			var riVenue = validateInputField('riVenue','errorContainer-riVenue');
			
			if(riExamStartDate && riExamEndDate && riRegistrationStartDate && riRegistrationEndDate && riLocationOnGoogleMap1 && riVenue){
				$('#riFormErrorClass').addClass('d-none');
				return true; 
			}else{
				$('#riFormErrorClass').removeClass('d-none');
				
				return false;
			}
		}
		
	}
	
}
</script>
