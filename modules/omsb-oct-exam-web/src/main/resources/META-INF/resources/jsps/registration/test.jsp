<%@ include file="../../init.jsp"%>
<portlet:resourceURL id="<%= MVCCommandNames.OCT_CONFIRM_RESCHEDULE%>" var="confirmCancleAndReschedule"  />	
	<button class="btn omsb-bc-red-button" onclick="rescheduleAndCancel(61198,61238)"> <liferay-ui:message key="Reshcedule/Cancel Registration" /></button>
							
<portlet:renderURL var="viewFutureScheduleExam">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_FUTURE_SCHEDULE_EXAM%>" />
</portlet:renderURL>

<portlet:actionURL name="<%=MVCCommandNames.REGISTRATION_CANCEL_ACTION%>" var="registrationCancellationURL" />

<button  hidden class="btn omsb-btn btn-red" data-toggle="modal" data-target="#rescheduleConformation" id="openRescheduleConformationBox" ></button>
<form action="${registrationCancellationURL}" method="post" name="" id="cancelRegistration">
<div class="modal fade omsb-modal" id="rescheduleConformation" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<%-- <h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="appointment-verification" /></h5> --%>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<input type="hidden" id="<portlet:namespace/>octExamDefinitionId" name="<portlet:namespace/>octExamDefinitionId">
				<input type="hidden" id="<portlet:namespace/>octExamDefinitionId" name="<portlet:namespace/>octExamScheduleId">
				
				<p id="confirmation-text"><liferay-ui:message key="reschedule-cancel-confirmation-msg" /></p> 
				
				<div class= "bottom-backbtn-wrap" >
				<button  type="button" class="btn omsb-bc-red-button"  id="reshedule-registration" onclick="rescheduleRegistration()"><liferay-ui:message key="reshedule-registration"  /></button>
				<button type="button" class="btn omsb-bc-red-button"  id="cancel-registration" onclick="cancelRegistration()"
					><liferay-ui:message key="cancel-registration" /></button>
				</div>
				<div id="reshcedule-box" class="d-none">
				
					<p id="reshcedule-msg"></p> 
				</div>
				<div id="cancel-box"  class="d-none">
					<p id="cancel-msg"> </p> 
				</div>
			</div>
			<div class="modal-footer">
				<%--  <a class="btn omsb-bc-red-button" href="${viewFutureScheduleExam}"> <liferay-ui:message key="view-results" />  --%>
				
				
							
			<button type="button" class="btn omsb-btn omsb-bg-red-button d-none" id="cancellation-confirm" onclick="comfirmCancellation()"
					><liferay-ui:message key="confirm"  /></button>	
					<a href="${viewFutureScheduleExam}" class="btn omsb-btn omsb-bg-red-button d-none" id="reschedule-confirm" 
					><liferay-ui:message key="confirm"  /></a>	
			<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal"><liferay-ui:message key="cancle" /></button>		
			</div>
			
			</div>
		</div>
	</div>

</form>

<script>

function comfirmCancellation(){
	alert("comfirmCancellation");
	$('#rescheduleConformation').modal('hide');
	var id=$("#<portlet:namespace/>octExamDefinitionId").val();
	console.log(id);
	document.getElementById("cancelRegistration").submit();
	
}


function rescheduleRegistration(){
	
	 $('#cancel-box').addClass('d-none');
	 $('#reshcedule-box').removeClass('d-none');
	 $('#cancellation-confirm').addClass('d-none');
	 $('#reschedule-confirm').removeClass('d-none');
	 $('#reshedule-registration').addClass('disabled');
	 $('#cancel-registration').removeClass('disabled');
	 
}
function cancelRegistration(){
	
	 $('#cancel-box').removeClass('d-none');
	 $('#reshcedule-box').addClass('d-none');
	 $('#cancellation-confirm').removeClass('d-none');
	 $('#reschedule-confirm').addClass('d-none');
	 $('#reshedule-registration').removeClass('disabled');
	 $('#cancel-registration').addClass('disabled');
}

function rescheduleAndCancel(octExamDefinitionId,octExamScheduleId){
	
	alert("rescheduleAndCancel");
	console.log(octExamDefinitionId+"  ::"+ octExamScheduleId);
	jQuery.ajax({
		 type: 'GET',
		 url:  '<%=confirmCancleAndReschedule %>',
		 data:{
			 "<portlet:namespace />octExamDefinitionId": octExamDefinitionId,
			 "<portlet:namespace />octExamScheduleId": octExamScheduleId,
		 },
		 success: function(response) {
		alert(response)	 
		console.log(response)
		var data=JSON.parse(response);
		console.log(data.reschedulingFees);
		console.log(data.cancellationFees);
		
		
		var reshceduleMsg= "<liferay-ui:message key='reshcedule-addtional-charge-msg'/>";
		var cancelMsg= "<liferay-ui:message key='cancel-refund-msg'/>";
		if(reshceduleMsg!=''){
			
		reshceduleMsg=reshceduleMsg.replace("?", data.reschedulingFeesPercentage);
		}
		if(cancelMsg!=''){
			
		cancelMsg=cancelMsg.replace("?", data.cancellationFeesPercentage);
		}
		$("#reshcedule-msg").html(reshceduleMsg);
		$("#cancel-msg").html(cancelMsg);
		
		$("#<portlet:namespace/>octExamDefinitionId").val(octExamDefinitionId);
		$("#<portlet:namespace/>octExamScheduleId").val(octExamDefinitionId);
		$("#openRescheduleConformationBox").click();
		 },
		 error: function(){
					 alert('error');
			    }
	});
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAM97fJa4kw2f6dSHQ3mFTmTdKyZ8FrbLw&callback=initMap&libraries=places&v=weekly" defer ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js" integrity="sha512-CryKbMe7sjSCDPl18jtJI5DR5jtkUWxPXWaLCst6QjH8wxDexfRJic2WRmRXmstr2Y8SxDDWuBO6CQC6IE4KTA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>