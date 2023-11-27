<%@page import="gov.omsb.duty.logging.web.constants.MVCCommandNames"%>
<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommandNames.ADD_DUTY_TYPES%>"
	var="addDutyTypeResourceURL" />
<portlet:resourceURL id="<%=MVCCommandNames.VIEW_DUTY_TYPES%>"
	var="viewDutyTypes" />
<portlet:resourceURL id="<%=MVCCommandNames.GET_DUTY_TYPES_DATA%>"
	var="getDutyTypesData" />
<portlet:resourceURL id="<%=MVCCommandNames.DELETE_DUTY_TYPES%>"
	var="deleteDutyTypesURL" />

<div class="tab-content" id="v-pills-tabContent">
	<div class="tab-pane fade show active" id="singledatesingleinstance"
		role="tabpanel" aria-labelledby="singledatesingleinstance-tab">
		<div class="omsb-page-top-info m-0">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<%-- <liferay-ui:message key="duty-logging-configuration-view-duty-types"></liferay-ui:message> --%>
				</div>
				<button class="btn omsb-bg-red-button" data-toggle="modal"
					data-target="#adddutytype" type="button">
					<liferay-ui:message key="duty-logging-configuration-add-duty-types"></liferay-ui:message>
				</button>
			</div>
		</div>

		<div class="omsb-list-view table-responsive">
			<table class="display omsb-datatables" id="dutyTypesTable">
				<thead>
					<tr>
						<th><liferay-ui:message
								key="duty-logging-configuration-duty-type" /></th>
						<th><liferay-ui:message
								key="duty-logging-configuration-added-by" /></th>
						<th><liferay-ui:message
								key="duty-logging-configuration-actions" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dutyTypesDtoList}" var="dutyTypes">
						<tr>
							<td>${dutyTypes.dutyType}</td>
							<td>${dutyTypes.createdBy}</td>
							<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#" value="${dutyTypes.dutyTypeId}"
											class="dropdown-item edit-button">Edit</a></li>
										<li><a href="#" data-toggle="modal"
											data-target="#deleteDutyType" value="${dutyTypes.dutyTypeId}"
											onclick="isDutyTypeAbleToDelete()" class="dropdown-item">Delete</a>
										</li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="bottom-backbtn-wrap">
			<a class="btn omsb-btn btn-back" href="#"><i
				class="fi fi-sr-arrow-left"></i>
			<liferay-ui:message key="duty-logging-configuration-back-button" /></a>
		</div>
	</div>
</div>

<!--  Model for delete  -->
<div class="modal fade" id="deleteDutyType" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title"><liferay-ui:message key="duty-logging-configuration-delete-duty-type-header"/></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="defaultMessage"><liferay-ui:message key="duty-logging-configuration-delete-duty-type-popup"/></p>
				<div id="mappedErrorMessage" style="display: none; color: #dc3545;">
					<small> 
						<liferay-ui:message key="duty-logging-configuration-existing-dependencies-msg" />
					</small>
				</div>
				<input id="currentDutyType" type="hidden" value="">
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

<!-- Modal -->
<div class="modal fade omsb-modal" id="adddutytype" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="duty-logging-configuration-add-duty-types" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="resetDutyType()">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="#" name="dutyTypesForm" method="post">
				<aui:input cssClass="form-control" type="hidden" name="dutyTypeId"
					id="dutyTypeId" value="">
				</aui:input>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="text" name="dutyType" id="dutyType" value=""
									class="form-control" oninput="handleInput(this)"
									label="duty-logging-configuration-dutyType">
									<aui:validator name="required"
										errorMessage="The Duty Type field is required*"></aui:validator>
								</aui:input>
								<div id="dutyTypeErrorMsgwqwqw">
									<small id="dutyTypeErrorMsg"
										style="display: none; color: #dc3545;"> <liferay-ui:message
											key="duty-logging-configuration-duty-type-already-exist-error-msg" />
									</small>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button" title="Add"
						onclick="saveDutyType()">
						<liferay-ui:message key="duty-logging-configuration-add-button" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						onclick="resetDutyType()" data-dismiss="modal">
						<liferay-ui:message key="duty-logging-configuration-cancel-button" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>
<script>
// function for save dutyType 
	function saveDutyType(){
		isDutyTypeExists();
	}
// function for checking already exist dutyType in db.	
function isDutyTypeExists(){
  var dutyTypeValue = $('#<portlet:namespace/>dutyType').val();
	Liferay.Service(
		'/omsbtms.dutytypes/get-duty-types-by-duty-type',
		{
		    dutyType: dutyTypeValue
		},
		function(object) {
		    const response = JSON.parse(object);
		    if(response.status === '409'){
		    	$("#dutyTypeErrorMsg").css("display","block");
		    }else if(response.status === '200') {
	        	submitDutyType();
		    }
		    
		});
   	}

// function for submit dutyType
	function submitDutyType(){
	if(validateForm('<portlet:namespace/>dutyTypesForm')){
        var form= $('#<portlet:namespace/>dutyTypesForm')[0];
		var formdata = new FormData(form);
        var url = '<%=addDutyTypeResourceURL.toString()%>';
		$.ajax({
			type : "post",
			url : url,
			data : formdata,
			contentType : false,
			cache : false,
			processData : false,
		}).done(function(response) {
			$("#<portlet:namespace/>dutyTypesForm").trigger("reset");
			$('#adddutytype').modal('hide');
			 location.reload();
		}).fail(function(error) {
			console.log(error);
		})
		}
		else {
			return false;	
		}	
	}
// function for reset dutyType fields 	
	function resetDutyType(){
		$("#<portlet:namespace/>dutyTypesForm").trigger("reset");
	}

	
//function for validate form 
function validateForm(dutyTypesForm){
	var liferayForm = Liferay.Form.get(dutyTypesForm);
		if(liferayForm){
			var validator = liferayForm.formValidator;
			validator.validate();
			var hasErrors = validator.hasErrors();
			if(hasErrors){
				validator.focusInvalidField();
				return false;
			}
		}
			return true;
	}
			
$(document).ready(function() {
// Initialize the DataTable
	let table = $('#dutyTypesTable').DataTable({
			"bLengthChange": false,
		    "bFilter": false,
		    "paging": true,
		    "pageLength": 10
	  // You can add other DataTable options here as needed
	});
});

//function for get dutyType data on field 
$("#dutyTypesTable").on('click', '.edit-button', function() {
   let dutyTypeId = event.target.getAttribute("value");
 $.ajax({
     type: "GET",
     url: "<%=getDutyTypesData.toString()%>",
     data:{id: dutyTypeId},
     contentType: "application/json; charset=utf-8",
     success: function(response) {
		       if (response) {
		           $("#<portlet:namespace/>dutyType").val(response.dutyType);
		           $("#<portlet:namespace/>dutyTypeId").val(response.dutyTypeId);
		         }
		       },
     error: function() {
   	  console.log("If fetching fails, resolve with an empty string");
     }
	});
	 $('#adddutytype').modal('show');   
});

// function for checking is DutyType able to delete or not  
function isDutyTypeAbleToDelete(){
	var dutyTypeId =event.target.getAttribute("value");
	$('#currentDutyType').val(dutyTypeId);
	 Liferay.Service(
	 '/omsbtms.dutyassignment/find-duty-type-status',
	 {
	     dutyTypeId: dutyTypeId
	 },
	 function(object) {
	     const response = JSON.parse(object);
	     let defaultMessage = $('#defaultMessage');
	     let deleteDuty = $('#deleteDuty');
	     if(response.status === '409'){                
	    	$("#mappedErrorMessage").css("display","block");
	    	defaultMessage.hide(); 			 
	    	deleteDuty.hide(); 				 
		  }else if(response.status === '202') {
	    	defaultMessage.show(); 			
	    	deleteDuty.show();
		   }
	    }
	 );
}
// function for confirm delete 
 function confirmDelete(){
 let dutyTypeId =	$('#currentDutyType').val();
 deleteDutyTypes(dutyTypeId);
} 	
 	
//  function for delete the selected dutyType
function deleteDutyTypes(dutyTypeId){
    $.ajax({
        type: "GET",
        url: "<%=deleteDutyTypesURL.toString()%>",
		data : {
				id : dutyTypeId
			},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				location.reload();
			},
			error : function() {
				console.log("If fetching fails, resolve with an empty string"); // If fetching fails, resolve with an empty string
			}
		});

	}
	// for remove errormessage when input change 
	function handleInput(input) {
		if (input.value.trim() !== "" || input.value.trim() == "") {
			$("#dutyTypeErrorMsg").hide();
		}
	}
</script>





