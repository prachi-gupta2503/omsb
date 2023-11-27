<%@include file="../init.jsp"%>

<portlet:renderURL var="viewMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FacultyMembershipConstants.VIEW_FACULTY_REQUEST_DETAILS_RENDER_COMMAND %>" />
</portlet:renderURL>

<portlet:renderURL var="addMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=FacultyMembershipConstants.ADD_EDIT_FACULTY_REQUEST_DETAILS_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:renderURL var="editMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName" value="/editFacultyRequest" />
</portlet:renderURL>

<portlet:actionURL name="submitReviewMemberDetailRequest"
	var="submitReviewMemberDetailRequestActionURL" />

<c:forEach var="wAction"	items="${workflowTaskDetail.actionList}">
	<button class="btn omsb-bc-red-button"
		onClick="${wAction.handler}(`${workflowTaskDetail.requestId}`,`${workflowTaskDetail.taskId }`,`${workflowTaskDetail.transitionList}`,`${workflowTaskDetail.transitionLevelsList}`,`${workflowTaskDetail.workflowInstanceId }`)"><liferay-ui:message key="${wAction.name}" />
	</button>
</c:forEach>

<!-- Modal popup -->
	<div class="modal fade omsb-modal" id="ec_mem_detail_view"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<form action="<%=submitReviewMemberDetailRequestActionURL%>"
				class="popup-form" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<input name="<portlet:namespace />workflow-details"
							id="<portlet:namespace />workflow-details" type="hidden" />

						<h5 class="modal-title" id="exampleModalLongTitle">
							<liferay-ui:message key="ec-member-request-adjudicate" />
						</h5>
						<button type="button" class="close popup-reset"
							data-dismiss="modal" onClick="closePopup()" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label><liferay-ui:message
											key="ec-member-request-comments" /></label>
									<textarea name="<portlet:namespace />popup_adjudicate_comment"
										oninput="handleInput(this)" class="form-control comment"
										id="<portlet:namespace />popup_adjudicate_comment"></textarea>
									<span class="errorCommentMsg" style="color: red;"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer ec-mem-detail-view-action"></div>
				</div>
			</form>
		</div>
	</div>
	<!-- Modal popup -->


<% 
	Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
    String siteFriendlyURL = group.getFriendlyURL(); %>
<!-- Modal popup -->

<script type="text/javascript">
$('#requestData').DataTable({
    "bLengthChange": false,
    "bFilter": false
});






function reviewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	 const transitionList = transitionNames.split(","); 
	 const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec-mem-detail-view-action").empty();
	 
	 $.each( transitionList, function( index, tName ){
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
		 	var tNameSplit = tName.split("_").pop();
			$(".ec-mem-detail-view-action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitReviewDetails(\'' + details + '\', \'<portlet:namespace/>workflow-details\', \'' +tNameSplit+ '\');" >'+transitionLevelsList[index]+'</button>');
		
	   });
	 $(".ec-mem-detail-view-action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button popup-reset" onClick="closePopup()" data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_detail_view");
	$("#ec_mem_detail_view").modal("show");

}



function requestMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){	
	const transitionList = transitionNames.split(","); 
	const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_member_request_popup_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
		 	$(".ec_mem_member_request_popup_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitMemberRequest(\'' + details + '\', \'<portlet:namespace/>member-request-task-details\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_member_request_popup_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()"	data-dismiss="modal">Close</button>');
	
	$("#actions").attr("data-target","#ec_mem_member_request_popup_view");
	$("#ec_mem_member_request_popup_view").modal("show");
}

ffunction viewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	let actionUrl = '<%=viewMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
	window.open(actionUrl, "_self" );
}

function addMembershipDetailsView(requestId,workflowTaskId,transitionNames,workflowInstanceId){
    let actionUrl = '<%=addMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
	window.open(actionUrl, "_self" );
}

function viewEditDetails (requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	let actionUrl = '<%=editMembershipDetailsURL%>'+'&<portlet:namespace />facultyRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}
function viewDistributionReport(){
	alert("Distribution Report- in development");	
}

function viewIncentiveReport(){
	alert("Incentive Report in development");	
}




function submitReviewDetails(details, fieldId,tNameSplit) {
	$("#"+fieldId).val(details);
	if(tNameSplit.toUpperCase() === 'REJECT')
	{
		return rejectECRequestResource();
	}
	 else{	
		$("#ec_mem_detail_view").modal("hide");	
	}
	return true;
}



function closePopup(){
	console.log("close popup");
	$(".popup-form")[0].reset();
	$(".popup-gme-form")[0].reset();
	$(".errorCommentMsg").text(" ");
	$(".nocFileErrorMsg").text(" ");
	$("#<portlet:namespace />nocDocument").val("");
	$("#<portlet:namespace />noc_comment").val(" ");
	
}

function handleInput(input) {
    console.log("input",input.value);
    if(input.value.trim() !=="")
    {
    	$(".errorCommentMsg").text("");
    	$(".nocFileErrorMsg").text("");
    }
    
  }
  


function submitMemberRequest(details, fieldId){
	$("#"+fieldId).val(details);
	$("#ec_mem_member_request_popup_view").modal("hide");
	return true;
}

</script>