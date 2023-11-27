<%@page import="gov.omsb.duty.logging.web.constants.MVCCommandNames"%>
<%@ include file="../../init.jsp"%>
<portlet:resourceURL id="<%=MVCCommandNames.ADD_DUTY_ASSIGNMENT%>"
	var="addDutyAssignmentResourceURL" />
<portlet:resourceURL id="<%=MVCCommandNames.EDIT_DUTY_ASSIGNMENT%>"
	var="editDutyAssignmentResourceURL" />
<portlet:resourceURL id="<%=MVCCommandNames.DELETE_DUTY_ASSIGNMENT%>"
	var="deleteDutyAssignmentResourceURL" />

<style>
td {
	position: relative;
	text-align: center;
	vertical-align: middle;
}

td div {
	position: absolute;
}

.narrow-td {
	width: 10%;
}

.color-div-center {
	width: 30%;
	height: 50%;
	margin: -8% 25%;
}
</style>

<div class="tab-content" id="v-pills-tabContent">
	<div class="tab-pane fade show active" id="singledatesingleinstance"
		role="tabpanel" aria-labelledby="singledatesingleinstance-tab">
		<div class="omsb-page-top-info m-0">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<!-- View Duty Type and assignment -->
				</div>
				<button class="btn omsb-bg-red-button" data-toggle="modal"
					data-target="#addassignment" type="button">
					<liferay-ui:message
						key="duty-logging-configuration-assignment-add-assignment" />
				</button>
			</div>
		</div>
		<div class="omsb-list-view table-responsive">
			<table class="display omsb-datatables" id="requestData">
				<thead>
					<tr>
						<th><liferay-ui:message
								key="duty-logging-configuration-assignment-duty-type" /></th>
						<th><liferay-ui:message
								key="duty-logging-configuration-assignment" /></th>
						<th><liferay-ui:message
								key="duty-logging-configuration-color-code" /></th>
						<th><liferay-ui:message
								key="duty-logging-configuration-assignment-action" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dutyAssignmementDTOList}"
						var="dutyAssignmementDTO">
						<tr>
							<td>${dutyAssignmementDTO.dutyType}</td>
							<td>${dutyAssignmementDTO.assignment}</td>
							<td class="narrow-td">
								<div class="color-div-center"
									style="background-color: ${dutyAssignmementDTO.colorCode};"></div>
							</td>
							<td>

								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#"
											value="${dutyAssignmementDTO.dutyAssignmentId}"
											onclick="editAssignment()" class="dropdown-item edit-button"><liferay-ui:message
													key="duty-logging-configuration-assignment-edit" /></a></li>
										<li><a href="#" data-toggle="modal"
											data-target="#deleteDutyTypeAssignment"
											value="${dutyAssignmementDTO.dutyAssignmentId}"
											onclick="isDutyTypeAssignmentAbleToDelete()"
											class="dropdown-item delete-button"><liferay-ui:message
													key="duty-logging-configuration-assignment-delete" /></a></li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade omsb-modal" id="addassignment" tabindex="-1"
	role="dialog" aria-labelledby="addassignmentTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title mb-5" id="exampleModalLongTitle">
				<liferay-ui:message key="duty-logging-configuration-add-duty-type-assignment" /></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onClick="closePopup()">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="#" name="add_Duty_Assignment" method="post"
				class="assignment-form">
				<aui:input cssClass="form-control" type="hidden"
					name="dutyAssignmentId" id="dutyAssignmentId" value="" />
				<div class="col-md-12">
					<div class="form-group">
						<aui:select name="dutyTypeId" id="dutyTypeId" class="form-control"
							label="DutyType">
							<aui:validator name="required"></aui:validator>
							<aui:option value="">Select</aui:option>
							<c:forEach items="${dutyTypes}" var="dutyType">
								<aui:option value="${dutyType.dutyTypeId}">${dutyType.dutyType}</aui:option>
							</c:forEach>
						</aui:select>
						<span class="errordutyTypeMsg" style="color: red;"></span>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<aui:input type="text" name="assignment" id="assignment"
							oninput="handleInput(this)" value="" class="form-control"
							label="Assignment">
							<aui:validator name="required"></aui:validator>
						</aui:input>
						<div id="dutyAssignmentErrorMsg"
							style="display: none; color: #dc3545;">
							<small> <liferay-ui:message
									key="duty-logging-configuration-already-exist-error-msg" />
							</small>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<aui:input type="color" name="colorCode" id="colorCode" value=""
							class="form-control"
							label="duty-logging-configuration-color-code">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button"
						onclick="saveDutyTypeAssignment()" title="Add">
						<liferay-ui:message
							key="duty-logging-configuration-assignment-add" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						onClick="closePopup()" data-dismiss="modal">
						<liferay-ui:message
							key="duty-logging-configuration-assignment-cencel" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>
<!--  Model for delete  -->
<div class="modal fade" id="deleteDutyTypeAssignment" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">
				<liferay-ui:message key="duty-logging-configuration-delete-duty-type-assignment"/>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="defaultMessage">
				<liferay-ui:message key="duty-logging-configuration-delete-popup-message"/></p>
				<div id="mappedErrorMessage" style="display: none; color: #dc3545;">
					<small> <liferay-ui:message
							key="duty-logging-configuration-existing-dependencies-msg" />
					</small>
				</div>
				<input id="currentDutyTypeAssignmentId" type="hidden" value="">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">
					<liferay-ui:message key="duty-logging-configuration-cancel-button" />
				</button>
				<a href="#" type="button" id="deleteDuty" onclick="confirmDelete()"
					class="btn btn-danger"><liferay-ui:message
						key="duty-logging-configuration-yes-button" /></a>
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$('#requestData').DataTable({
	    "bLengthChange": false,
	    "bFilter": false,
	    "paging": true,
	    "pageLength": 10,
	   
	});
});
function saveDutyTypeAssignment(){
	isDutyTypeAssignmentExists();
}
function isDutyTypeAssignmentExists(){
	if(validateForm('<portlet:namespace/>add_Duty_Assignment')){
	var dutyTypeId = $('#<portlet:namespace/>dutyTypeId').val();
	var assignment = $('#<portlet:namespace/>assignment').val();
	var dutyAssignmentId = $('#<portlet:namespace/>dutyAssignmentId').val();
	if(dutyAssignmentId.length<=0){
		dutyAssignmentId=0;
	}
	Liferay.Service(
		'/omsbtms.dutyassignment/fetch-duty-type-assignment-status',
		{
		    dutyTypeId: dutyTypeId,
		    assignment: assignment,
		    dutyAssignmentId: dutyAssignmentId
		},
		function(object){
		    const response = JSON.parse(object);
		    if(response.status === '409'){
		    $("#dutyAssignmentErrorMsg").css("display", "block");
		    }else if(response.status === '200') {
		    	addAssignment();
		    }
		});
	}else{
	return false;
	}
}
 //For Add DutyTypeAssignment
function addAssignment(){
	if(validateForm('<portlet:namespace/>add_Duty_Assignment')){	
		var form= $('#<portlet:namespace/>add_Duty_Assignment')[0];
		var formdata = new FormData(form);
		var url = '<%=addDutyAssignmentResourceURL.toString()%>';
		$.ajax({
			type : "post",
			url : url,
			data : formdata,
			contentType : false,
			cache : false,
			processData : false,
		}).done(function(response){
			$('#addassignment').modal('hide');
			location.reload();
			}).fail(function(error) {
				console.log("Error in adding assignment");
			})
	 }else{
		 return false;
		 }
}
 //For Edit DutyTypeAssignment
function editAssignment(){
	var dutyAssignmentId = event.target.getAttribute("value");
	$.ajax({
        type: "GET",
        url: "<%=editDutyAssignmentResourceURL.toString()%>",
	    data: {id: dutyAssignmentId},
	    contentType: "application/json; charset=utf-8",
	    success: function(response) {
	          if (response) {
	        	  $("#<portlet:namespace/>dutyAssignmentId").val(response.dutyAssignmentId);
	        	  $("#<portlet:namespace/>dutyTypeId").val(response.dutyTypeId);
	              $("#<portlet:namespace/>assignment").val(response.assignment);
	              $("#<portlet:namespace/>colorCode").val(response.colorCode);
	          }
	        },
	        error: function() {
	      	  console.log("If fetching fails, resolve with an empty string"); // If fetching fails, resolve with an empty string
	        }
		});
		    $('#addassignment').modal('show');   
	}
	// function for checking is DutyType able to delete or not  
function isDutyTypeAssignmentAbleToDelete(){
	var dutyTypeAssignmentId =event.target.getAttribute("value");
	console.log("dutyTypeAssignmentId"+dutyTypeAssignmentId);
	$('#currentDutyTypeAssignmentId').val(dutyTypeAssignmentId);
	Liferay.Service(
		'/omsbtms.programdutyassignment/find-duty-type-assignment-status',
		{
		    dutyAssignmentId: dutyTypeAssignmentId
		},
		function(object) {
		     const response = JSON.parse(object);
		     let defaultMessage = $('#defaultMessage');
		     console.log("defaultMessage"+defaultMessage);
		     let deleteDuty = $('#deleteDuty');
		     if(response.status === '409'){	
			    $("#mappedErrorMessage").css("display", "block");
			    	defaultMessage.hide(); 			  
			    	deleteDuty.hide(); 				  
			    }else if(response.status === '200') {
			    	$("#mappedErrorMessage").css("display", "none");
			    	defaultMessage.show(); 			
			    	deleteDuty.show();   		
			    }
		});
}
	
function confirmDelete(){
	 let dutyTypeAssignmentId =	$('#currentDutyTypeAssignmentId').val();
	 deleteDutyTypesAssignment(dutyTypeAssignmentId); // delete the selected dutyType.
	} 	
	
	//For Delete DutyTypeAssignment
function deleteDutyTypesAssignment(dutyTypeAssignmentId){
   $.ajax({
       type: "GET",
       url: "<%=deleteDutyAssignmentResourceURL.toString()%>",
        data:{id: dutyTypeAssignmentId},
        contentType: "application/json; charset=utf-8",
        success: function(response) {
        	location.reload();
        },
        error: function() {
      	  console.log("If fetching fails, resolve with an empty string"); // If fetching fails, resolve with an empty string
        }
	});
}
		
 function closePopup(){
 	$("#<portlet:namespace/>add_Duty_Assignment").trigger("reset");
 }

 // For validate form 
function validateForm(add_Duty_Assignment){
	var assignmentForm = Liferay.Form.get(add_Duty_Assignment);
		if(assignmentForm){
			var validator = assignmentForm.formValidator;
			validator.validate();
			var hasErrors = validator.hasErrors();
			if(hasErrors){
				validator.focusInvalidField();
				 return false;
			}
		}return true;
	}  
    	
   	// for remove errormessage when input change 
function handleInput(input){
	    if(input.value.trim() !== "" || input.value.trim() == "")
	    {
	    	$("#dutyAssignmentErrorMsg").hide();
	    }
	  }
</script>