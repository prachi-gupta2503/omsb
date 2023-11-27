<%@ include file="../../init.jsp"%>
<portlet:resourceURL id="<%=MVCCommands.VIEW_EXAM_RESULT%>" var="viewExamResultExcelURL">
	<portlet:param name="cmd" value="viewExamResultExcel" />
	<portlet:param name="examTypeName" value="${registrationItems[0].examTypeName }" />
</portlet:resourceURL>
<portlet:resourceURL id="<%=MVCCommands.UPLOAD_EXAM_RESULT%>" var="checkExamResultURL">
	<portlet:param name="cmd" value="checkResult" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommands.UPLOAD_EXAM_RESULT%>" var="uploadExamResultURL">
	<portlet:param name="cmd" value="uploadExamResult" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommands.ANNOUNCE_EXAM_RESULT%>" var="announceExamResultURL">
	<portlet:param name="cmd" value="announceExamResult" />
</portlet:resourceURL>

<!--// Uploaded Results pop up -->
		
		<div class="modal fade omsb-modal" id="upload_result" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="uploaded-result" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div class="col-md-12">
								<div class="form-group">
									<div class="label-name"><liferay-ui:message key="success-count" />: <label class="label-name" id="success_count">0</label></div>
								</div>
							</div>
							<div class="col-md-12 mt-5"><hr></div>
							
							<div class="col-md-12">
								<div class="form-group">
									<div class="label-name"><liferay-ui:message key="failure-count" />: <label class="label-name" id="failure_count">0</label></div>
								</div>
							</div>
							<div>
								<liferay-ui:message key="confirmation-text" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="uploadExamResult()" title="ok" ><liferay-ui:message key="ok" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="cancel" /></button>
					</div>
				</div>
			</div>
		</div>
		
	
					
		<!--// Uploaded Results pop up -->
<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info m-0">
					<div class="pagetitle"><liferay-ui:message key="admin-upload-result"/></div>
				</div>
				
				<c:choose>
				 <c:when test="${not empty examSchedule.examStartDate && not empty examSchedule.examEndDate}">
				 <c:set var = "es_class_name" value = "col-md-3"></c:set>
				</c:when>
				<c:when test="${not empty examSchedule.examDate}">
					<c:set var = "es_class_name" value = "col-md-4"></c:set>
				</c:when>
				<c:otherwise>
				<c:set var = "es_class_name" value = "col-md-6"></c:set>
				</c:otherwise>
				 </c:choose>
				
				
				
				<div class="row">
						 <div class="${es_class_name} label-box">
							<label class="label-name"><liferay-ui:message key="program-name"/></label>
							<label class="label-content">${registrationItems[0].programName }</label>
						</div> 
						
						<div class="${es_class_name} label-box">
							<label class="label-name"><liferay-ui:message key="exam-type"/></label>
							<label class="label-content">${registrationItems[0].examTypeName }</label>
						</div>
						<c:if test="${not empty examSchedule.examDate}">
						<div class="${es_class_name} label-box">
							<label class="label-name"><liferay-ui:message key="exam-date"/></label>
							<label class="label-content">${examSchedule.examDate}</label>
						</div>
						</c:if>
						<c:if test="${not empty examSchedule.examStartDate && not empty examSchedule.examEndDate}">
						<div class="${es_class_name} label-box">
							<label class="label-name"><liferay-ui:message key="exam-start-date"/></label>
							<label class="label-content">${examSchedule.examStartDate}</label>
						</div>
						<div class="${es_class_name} label-box">
							<label class="label-name"><liferay-ui:message key="exam-end-date"/></label>
							<label class="label-content">${examSchedule.examEndDate }</label>
						</div> 
						</c:if>
					</div>
				<div class="omsb-list-filter "><!-- omsb-more-btn -->
					<div class="row">
						<div class="col-lg-4 col-md-4">
							<a href="<%=viewExamResultExcelURL%>" class="btn omsb-bc-red-button" ><liferay-ui:message key="download-result-template"/></a>
						</div>
						<div class="col-lg-8 col-md-4">	
							<div class="form-group">
								<label></label>
								<div class="custom-file mb-3">
									<aui:input type="file" cssClass="custom-file-input2" id="uploadExamResult" name="uploadExamResult" label="" accept=".xls"/>
									<label class="custom-file-label" for="<portlet:namespace/>uploadExamResult">
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="filter-button-wrap">
						<button class="btn omsb-bc-red-button" onclick="resultCountCheck()" data-toggle="modal" data-target="#upload_result"><liferay-ui:message key="upload-result"/></button>
					</div>	
					</div>
					
				
            
				<portlet:actionURL name="<%=MVCCommands.SAVE_EXAM_RESULT%>" var="saveExamResultURL" />
					<form action="${saveExamResultURL}" method="post" name="saveExamResult" id="saveExamResult">
					  <c:if test="${not empty registrationItems}">
				<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables" id="result_table">
					<thead>
						<tr>
							<th><liferay-ui:message key="program-name"/></th>
							<th><liferay-ui:message key="name"/></th>
							<th><liferay-ui:message key="final-result"/></th>
							<th><liferay-ui:message key="percentage"/></th>
							<th><liferay-ui:message key="appeared"/></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="registrationItem" items="${registrationItems}">
						<tr>
							<input type="hidden" name="<portlet:namespace/>examScheduleId" value ="${registrationItem.examScheduleId }">
							<input type="hidden" name="<portlet:namespace/>examDefinitionId" value ="${registrationItem.examDefinitionId }">
							<input type="hidden" name="<portlet:namespace/>trainee" class="form-control">
							<input type="hidden" name="<portlet:namespace/>lrUserId" value ="${registrationItem.lrUserId }">
							<td>${registrationItem.programName }</td>
							<td>${registrationItem.name}</td>
							<td><div class="form-group">
								<select name="<portlet:namespace/>result" id="result" class="custom-select form-control">
									<option value=""><liferay-ui:message key="select"/></option>
									<option value="pass" ${registrationItem.result eq 'pass' ? 'selected' : ''}><liferay-ui:message key="pass"/></option>
									<option value="fail" ${registrationItem.result eq 'fail' ? 'selected' : ''}><liferay-ui:message key="fail"/></option>
								</select>
							</div></td>
							<td>
								<div class="form-group">												
									<input type="text" onkeyup="validateSelectAndInputField('percentage','percentage_range_error_c')" maxlength="3" id="percentage" value="<c:if test="${registrationItem.percentage!=0.0}">${registrationItem.percentage}</c:if>" title="Please enter a number with decimal precision" name="<portlet:namespace/>percentage" class="form-control">
									<span class="text-danger d-none" id="percentage_range_error_c" ><liferay-ui:message key="percentage-should-be-between-0-and-100"/></span>
								</div>
							</td>
							<td><div class="form-group">
								<select name="<portlet:namespace/>appeard" id="appeard" class="custom-select form-control">
									<option value="true" ${registrationItem.appeared eq true ? 'selected' : ''}><liferay-ui:message key="yes"/></option>
									<option value="false" ${registrationItem.appeared eq 'false' ? 'selected' : ''}><liferay-ui:message key="no"/></option>
								</select>
							</div></td>										
						</tr>
						</c:forEach>
					</tbody>
				</table>
							
				</div>
				</c:if>
				<c:if test="${empty registrationItems}">
					<div class="pagetitle"><liferay-ui:message key="no-user-is-registered-for-this-exam" /></div>
				</c:if>
					<portlet:renderURL var="viewExamScheduleURL">
						<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.EXAMS_SCHEDULE_LIST %>" />
					</portlet:renderURL>
				<div class="bottom-backbtn-wrap">
				<button class="btn omsb-bc-red-button" id="annpunceResult" title="annpunceResult" onclick="announceExamResult();"><liferay-ui:message key="announce-result"/></button>
					<button class="btn omsb-bc-red-button" id="result_save" title="Save" type="button"><liferay-ui:message key="save"/></button>
					<a class="btn omsb-btn btn-back" href="${viewExamScheduleURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
				</div>
				</form>
			</div>
		</div>
</div>		
	<div class="modal fade omsb-modal" id="announceResultPopup" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						Exam Announcement.
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
						<h4 id="announce_succes">Exam Result is Announced Successfully</h4>
						<h4 id="announce_failure">We are unable to announce your exam. Please try again.</h4>
						</div>
					</div>
					<div class="modal-footer">
						
					</div>
				</div>
			</div>
		</div>	
<script>
var jsonArrayData = null;
function resultCountCheck(){
	
	var uploadFile = document.getElementById("<portlet:namespace />uploadExamResult").files[0];
	console.log("Selected file: " + uploadFile.name);
	var formData = new FormData();
	formData.append('resultFile', uploadFile);
	
  	$.ajax({
      type:'POST',
      url:'${checkExamResultURL}',
      processData: false,
      contentType: false,
      async: false,
      cache: false,
      data : formData,
      success: function(response){
	      var parsedResponse = JSON.parse(response);
	      var stringyfyResponse = JSON.stringify(response);
		  console.log("response"+ stringyfyResponse);
		  jsonArrayData = stringyfyResponse;
		  var successCount = parsedResponse[0].successCount;
		  var failureCount = parsedResponse[0].failureCount;
		  console.log("success count "+successCount);
		  $("#success_count").text(successCount);
		  $("#failure_count").text(failureCount);
      }
  });
}

function uploadExamResult(){
	var examScheduleId = '${registrationItems[0].examScheduleId}';
	var examDefinitionId = '${registrationItems[0].examDefinitionId}';
	var lrUserId = '${registrationItems[0].lrUserId}';
	console.log(examScheduleId);
  $.ajax({
		url:'${uploadExamResultURL}',
		examScheduleId:examScheduleId,
		examDefinitionId:examDefinitionId,
		lrUserId:lrUserId,
		async : false,
		data : {
			<portlet:namespace />resultRecords : jsonArrayData,
			<portlet:namespace />examScheduleId : examScheduleId,
			<portlet:namespace />examDefinitionId : examDefinitionId,
			<portlet:namespace />lrUserId : lrUserId
		},
		type : 'POST',
		success : function(data) {
			console.log("data"+data);
			$('#upload_result').modal("hide");
			
		},
	})
	console.log(examScheduleId);
}

$("#uploadcancel").on('click',function(e){
    e.preventDefault();
    $('#<portlet:namespace />uploadExamResult').val("");
   });
   
$("#annpunceResult").on('click', (function(e) {
	var examScheduleId = '${registrationItems[0].examScheduleId}';
	var examDefinitionId = '${registrationItems[0].examDefinitionId}';
	var lrUserId = '${registrationItems[0].lrUserId}';
	console.log(examScheduleId);
  $.ajax({
		url:'${announceExamResultURL}',
		examScheduleId:examScheduleId,
		examDefinitionId:examDefinitionId,
		async : false,
		data : {
			<portlet:namespace />examScheduleId : examScheduleId,
			<portlet:namespace />examDefinitionId : examDefinitionId,
			<portlet:namespace />lrUserId : lrUserId
		},
		type : 'POST',
		 processData: false,
	      contentType: false,
	      cache: false,
		success : function(data) {
			
		var dataJson=JSON.parse(data);
			if(dataJson != undefined && dataJson.success){debugger;
				$('#announce_succes').show();
				$('#announce_failure').hide();
				$('#announceResultPopup').modal("show");
				$('#annpunceResult').hide();
			}else{
				$('#announce_succes').hide();
				$('#announce_failure').show();
				$('#announceResultPopup').modal("show");
				
			}
			
		},
	})
	 e.preventDefault();
}));

$('#result_table').DataTable({
    "bLengthChange": false,
    dom: 'Bfrtip',
	buttons: [
		{
          extend: 'colvis',
          text: '<liferay-ui:message key="column-visibility" />',
          columns: ":not(':last')"
        },
	    {
	        extend: 'collection',
	        text: '<liferay-ui:message key="export-as" />',
	        buttons: [
	            {
	                extend: 'csv',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'pdf',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'excel',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            },
	            {
	                extend: 'print',
	                exportOptions: {
	                    columns: ":visible:not(':last')"
	                }
	            }
	        ]
	    }
	],
});

   
   function percentageValidation(e) {
	    let invalidPercentage = false; 

	    $("#result_table tbody tr").each(function () {
	        const keyVal = parseFloat($(this).find('#percentage').val()); 
	        
	        if (keyVal < 0 || keyVal > 100) {
	            invalidPercentage = true;
	            $("#percentage_range_error_c").removeClass('d-none');
	        } else {
	            $("#percentage_range_error_c").addClass('d-none');
	        }
	    });

	    if (invalidPercentage) {
	        e.preventDefault(); 
	        return true;
	    } else {
	        return false;
	    }
	}

	$("#result_save").on('click', function (e) {
	    if (percentageValidation(e)) {
	        e.preventDefault();
	    } else {
	        $('#saveExamResult').submit();
	    }
	});

</script>
<style>
#result_table_wrapper .dataTables_filter {display: none;}
</style>