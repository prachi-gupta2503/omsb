<div class="dropdown ">
	<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
		data-toggle="dropdown" aria-expanded="false">
		<i class=""></i>
	</button>
	<ul class="dropdown-menu">
		<li><a href="${editOCTExamSchedule}" class="dropdown-item"><i
				class="fa fa-pencil"></i> <liferay-ui:message key="edit-exam-schedule" /></a></li>
		<li><a href="${viewOCTExamDetails}" class="dropdown-item"><i
				class="fa fa-eye"></i> <liferay-ui:message key="view-exam-definition" /></a></li>			
		<li><a href="${viewOCTExamSchedule}" class="dropdown-item"><i
				class="fa fa-eye"></i> <liferay-ui:message key="view-exam-schedule" /></a></li>
	
	
	<c:if test="${octExamSchedule.getExamStatusName() eq 'Announced'}">
		
	 <li><a onclick="blockExam('${octExamSchedule.getId()}')" href="#" class="dropdown-item"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-block.svg"><liferay-ui:message key="block" /></a></li>
     <li><a onclick="cancelExam('${octExamSchedule.getId()}')" href="#" class="dropdown-item"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-cancel.svg"> <liferay-ui:message key="cancel" /></a></li>
     <li><a onclick="rescheduleExam('${octExamSchedule.getId()}')" href="#" class="dropdown-item"><img src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-reschedule.svg"> <liferay-ui:message key="reschedule" /></a></li>
	 
	</c:if>
	
	
		<form action="${scheduleExamAction}" method="post"
		name="<portlet:namespace/>scheduleExamAction" id="blockForm">	
		<input type="hidden" name="<portlet:namespace />examScheduleId" id="<portlet:namespace />examScheduleId" value="">
		<input type="hidden" name="<portlet:namespace />status" id="<portlet:namespace />status" value="block">
		</form>	
		
		<form action="${scheduleExamAction}" method="post"
		name="<portlet:namespace/>scheduleExamAction" id="cancelForm">	
		<input type="hidden" name="<portlet:namespace />examScheduleId" id="<portlet:namespace />scheduleId" value="">
		<input type="hidden" name="<portlet:namespace />status" id="<portlet:namespace />status" value="cancel">
		</form>
		
		<form action="${scheduleExamAction}" method="post"
		name="<portlet:namespace/>scheduleExamAction" id="rescheduleForm">	
		<input type="hidden" name="<portlet:namespace />examScheduleId" id="<portlet:namespace />ocExamScheduleId" value="">
		<input type="hidden" name="<portlet:namespace />status" id="<portlet:namespace />status" value="reschedule">
		</form>	
		
			
	</ul>
</div>

<div class="modal fade omsb-modal " id="exist-exam-cancel" tabindex="-1"
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

<script>

function blockExam(scheduleId){
	console.log("Block Exam Function .....");
    document.getElementById("<portlet:namespace />examScheduleId").value = scheduleId;
    document.getElementById("<portlet:namespace />status").value = "block";
    console.log("Submit @@@@@@@@@@@@@@@@@@@222 .....");
    document.getElementById("blockForm").submit();
}

function cancelExam(cancelId){
    document.getElementById("<portlet:namespace />scheduleId").value = cancelId;
    document.getElementById("<portlet:namespace />status").value = "cancel";
    
    document.getElementById("cancelForm").submit();
    
    /* var existExamConfirm = $("#exist-exam-cancel");
	  existExamConfirm.find(".modal-content .modal-header p");
		existExamConfirm.modal('show');
		$("#yes_btn").on("click", function() {
		    document.getElementById("cancelForm").submit();
		}) 
		$("#no_btn").on("click", function() {
			event.preventDefault();
		})  */

}

function rescheduleExam(rescheduleId){
    document.getElementById("<portlet:namespace />ocExamScheduleId").value = rescheduleId;
    document.getElementById("<portlet:namespace />status").value = "reschedule";
    document.getElementById("rescheduleForm").submit();
}

</script>






