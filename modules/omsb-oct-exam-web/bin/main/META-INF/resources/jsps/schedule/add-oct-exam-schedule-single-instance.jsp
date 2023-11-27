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
	
<c:set var="selectedExamCenterId"
	value="${examSchedule.getExamCenter()}"></c:set>
	
<c:set var="selectedExamSlotId"
	value="${examSchedule.getExamSlot()}"></c:set>
	
	
	
		

<form action="${examScheduleActions}" method="post"
	name="<portlet:namespace/>examScheduleActions" id="siForm">
	<input type="hidden" name="<portlet:namespace />octExamId"
		id="<portlet:namespace />octExamId" value="${octExamId}">
		<input type="hidden" name="<portlet:namespace />octScheduleAdminId"
		id="octScheduleAdminIdAttr" value="${examSchedule.getoCExamScheduleAdminId()}">
		<input type="hidden" name="<portlet:namespace />octScheduleId"
		id="octScheduleId" value="${examSchedule.getId()}">
		
		<input type="hidden" name="<portlet:namespace />selectedExamSlotId"
		id="selectedExamSlotId" value="${examSchedule.getExamSlot()}">
		
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="registration-start-date" /></label> <input type="text"
					onchange="validateInputFieldForSchdlForm('siRegistrationStartDate','errorContainer-siRegistrationStartDate','<liferay-ui:message key='enter-registration-start-date' />');"
					name="<portlet:namespace />siRegistrationStartDate" value="${examSchedule.getRegistrationStartDate()}"
					id="siRegistrationStartDate" placeholder="DD/MM/YYYY"
					class="form-control datePicker" autocomplete="off">
			</div>
			<p id="errorContainer-siRegistrationStartDate"
				class="error-container"></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="registration-end-date" /></label> <input type="text"
					name="<portlet:namespace />siRegistrationEndDate" value="${examSchedule.getRegistrationEndDate()}"
					id="siRegistrationEndDate" placeholder="DD/MM/YYYY"
					onchange="validateInputFieldForSchdlForm('siRegistrationEndDate','errorContainer-siRegistrationEndDate','<liferay-ui:message key='enter-registration-end-date' />');"
					class="form-control datePicker" autocomplete="off">
			</div>
			<p id="errorContainer-siRegistrationEndDate" class="error-container"></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="no-of-seats-or-station" /></label> <input type="text"
					placeholder="<liferay-ui:message key="enter-no-of-seats" />" value="${examSchedule.getNoOfSeats()}"
					onkeyup="validateInputFieldForSchdlForm('siNoOfSeats','errorContainer-siNoOfSeats','<liferay-ui:message key='enter-no-of-seats' />');"
					name="<portlet:namespace />siNoOfSeats" id="siNoOfSeats"
					class="form-control">
			</div>
			<p id="errorContainer-siNoOfSeats" class="error-container"></p>
		</div>

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-date" /></label>
				<input type="text" name="<portlet:namespace/>siExamDate" value="${examSchedule.getExamDate()}"
					onchange="validateInputFieldForSchdlForm('siExamDate','errorContainer-siExamDate','<liferay-ui:message key='enter-exam-date' />');"
					id="siExamDate" placeholder="DD/MM/YYYY"
					class="form-control datePicker" autocomplete="off">
			</div>
			<p id="errorContainer-siExamDate" class="error-container"></p>
		</div>

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="exam-center" /></label> <select id="siTrainingSiteId"
					name="<portlet:namespace/>siTrainingSite" class="form-control">
					<option value=""><liferay-ui:message key="select" /></option>
					
					<c:forEach var="octTrainingSite" items="${octTrainingSiteList}">
					
					<c:choose>
							<c:when
								test="${octTrainingSite.listTypeEntryId eq selectedExamCenterId}">
								<option value="${octTrainingSite.listTypeEntryId}" selected>
									${octTrainingSite.getName(themeDisplay.getLocale())}</option>
							</c:when>
							<c:otherwise>
								<option value="${octTrainingSite.listTypeEntryId}">
									<liferay-ui:message
										key="${octTrainingSite.getName(themeDisplay.getLocale())}" />
								</option>
							</c:otherwise>
						</c:choose>
					
					
					<%-- 
						 <option value="${octTrainingSite.listTypeEntryId}" <c:if test="${octTrainingSite.listTypeEntryId eq examSchedule.getExamCenter()}"> selected="selected"</c:if>>
							<liferay-ui:message key="${octTrainingSite.getName(themeDisplay.getLocale())}" />
						</option> --%>
					</c:forEach>
				</select>
			</div>
			<p id="errorContainer-siTrainingSite" class="error-container"></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="exam-slots" /></label>
				<select id="siExamSlotsId" name="<portlet:namespace/>siExamSlotList"
					class="form-control" multiple size="5">
					
					<c:forEach var="octExamDepartment" items="${octExamDepartmentList}">

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
			</div>
			<p id="errorContainer-siExamSlots" class="error-container"></p>
		</div>

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label><liferay-ui:message key="department-name" /></label> <select
					id="siDepartmentId" name="<portlet:namespace/>siDepartmentId"
					class="form-control">
					<option value=""><liferay-ui:message key="select" /></option>
					<c:forEach var="octExamDepartment" items="${octExamDepartmentList}">

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
				<!-- <p id="errorContainer-siDepartmentId" class="error-container"></p> -->
			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label><liferay-ui:message key="section" /></label> <select
					name="<portlet:namespace/>siSectionId" id="siSectionId"
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
				<p id="errorContainer-siSectionId" class="error-container"></p>
			</div>
		</div>

		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message
						key="locate-on-google-map" /></label><input type="text" value="${examSchedule.getLocationOnGoogleMap()}"
					onkeyup="validateGoogleMapField('siLocateOnGoogleMap','errorContainer-siLocationOnGoogleMap','<liferay-ui:message key='enter-location' />');"
					name="<portlet:namespace/>siLocateOnGoogleMap"  data-place="${examSchedule.getLocationOnGoogleMap()}" 
					id="siLocateOnGoogleMap" data-attr="1" data-instance="si"
					class="form-control autocompleteMap"> 
					<input type="hidden"
					name="<portlet:namespace/>siLocationOnGoogleMap" class="placeIdMap" value="${examSchedule.getLocationOnGoogleMap()}"
					id="siLocationOnGoogleMap" data-attr="1">
			</div>
			<p id="errorContainer-siLocationOnGoogleMap" class="error-container"></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12">
			<div class="form-group">
				<label class="required"><liferay-ui:message key="venue" /></label>
				<input type="text"
					placeholder="<liferay-ui:message key="enter-a-venue" />"
					nkeyup="validateInputFieldForSchdlForm('siVenue','errorContainer-siVenue','<liferay-ui:message key='enter-venue' />');"
					name="<portlet:namespace/>siVenue" id="siVenue" value="${examSchedule.getVenue()}"
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
		<button class="btn omsb-bc-red-button" type="button" title="Announce"
			onclick="validateAndSubmitScheduleForm('si', 'announce', event)">
			<liferay-ui:message key="announce" />
		</button>
		<button class="btn omsb-bc-red-button" type="button"
			onclick="validateAndSubmitScheduleForm('si','saveAsDraft', event )"
			title="save as draft">
			<liferay-ui:message key="save-as-draft" />
		</button>
		<button class="btn omsb-bc-red-button" data-toggle="modal"
			data-target="#exam-schedule-si-discard" type="button">
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
</form>







<script>


/* $(document).on('change','#siDepartmentId',function(){
	console.log("Function For Department .... And Section");
	setSection("#siDepartmentId","#siSectionId", 'change');
});


function setSection(idOfDepartment, idOfSection, event){
	cosole.log("Set Section Function...");
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
} */







$(document).ready(function () {
	$('#siExamSlotsId').multiselect();
	var selectedExamSlotId = '${selectedExamSlotId}';
	var selectedExamCenterId = '${selectedExamCenterId}';
	loadExamSlotsByExamCenterId(selectedExamCenterId, selectedExamSlotId);
});


$(document).on('change','#siDepartmentId',function(){
	console.log("change");	
	var departmentId=$('#siDepartmentId').val();
	console.log("departmentId :::::::::::",departmentId);
		setSection("siDepartmentId","siSectionId");
	
});

$(document).on('change','#siTrainingSiteId',function(){
            var selectedTrainingSiteId = $('#siTrainingSiteId').val();

            console.log("selectedTrainingSiteId ... "+selectedTrainingSiteId);
            loadExamSlotsByExamCenterId(selectedTrainingSiteId);
          /*   $('#siExamSlotsId option').remove(); // Clear existing results
            
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
                    	 $("#siExamSlotsId").append("<option value='" + response[i].value + "'>" + response[i].name + "</option>");
                    }
                    
                    $('#siExamSlotsId').multiselect('rebuild');
        		},
        	}) */
        });
    
 function loadExamSlotsByExamCenterId(selectedTrainingSiteId,selectedExamSlotId){
	 $('#siExamSlotsId option').remove(); // Clear existing results
     
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
            		 $("#siExamSlotsId").append("<option value='" + response[i].value + "'>" + response[i].name + "</option>");
            	 	}
             		$('#siExamSlotsId').multiselect('rebuild');
             		$('#siExamSlotsId').val([selectedExamSlotId]);
             		$('#siExamSlotsId').multiselect('refresh');
 		},
 	})
 }   

 function setSection(departmentId,sectionId){
	var inputDepartmentId=$("#"+departmentId).val();
	console.log("inputDepartmentId ::::",inputDepartmentId);
	
	
	$.ajax({
		url: '${sectionDepartmentURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />departmentId : inputDepartmentId,
		},
		type : 'POST',
		success : function(data) {
			console.log("success :::::",data);
			console.log("success :::::",data.length);
			
			var response = data;
            var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
            
            for (var i = 0; i < response.length; i++) {
                sectionData += "<option value='" + response[i].key + "'>" + response[i].name + "</option>";
            }
            
            $("#" + sectionId).html(sectionData); 
		},
	})
} 
 

</script>







