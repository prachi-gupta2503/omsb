
<%@ include file="/init.jsp"%>
<portlet:renderURL var="sendNotificationURL">
<portlet:param name="mvcRenderCommandName"
        value="<%=MVCCommands.EMAIL_NOTIFICATION%>" />
</portlet:renderURL>
<a href="${sendNotificationURL}"><button><liferay-ui:message key="send-notification"/></button></a>


<!--// Uploaded Results pop up -->
		
		<div class="modal fade omsb-modal" id="upload_result" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Uploaded Results</h5>
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
		
<!-- this is for trainee list -->
<portlet:renderURL var="viewTraineeExamListURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommands.VIEW_TRAINEE_EXAM_LIST%>" />
</portlet:renderURL>
<a href=${viewTraineeExamListURL}><button><liferay-ui:message key="view-trainee-exam-list"/></button></a>

<%-- <%@ include file="/jsps/registration/trainee-exam-list.jsp"%> --%>
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
  $.ajax({
		url:'${uploadExamResultURL}',
		async : false,
		data : {
			<portlet:namespace />resultRecords : jsonArrayData			
		},
		type : 'POST',
		success : function(data) {
			console.log("data"+data);
			$('#upload_result').modal("hide");
			
		},
	})
}

$("#uploadcancel").on('click',function(e){
    e.preventDefault();
    $('#<portlet:namespace />uploadExamResult').val("");
   });
</script>