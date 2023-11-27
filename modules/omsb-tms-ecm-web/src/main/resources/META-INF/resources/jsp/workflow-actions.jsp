<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="gov.omsb.tms.ecm.web.constants.MVCCommandNames"%>
<portlet:renderURL var="actionAddMembershipDetailsURL">
		<portlet:param name="mvcRenderCommandName" value="<%=  MVCCommandNames.ADD_MEMBERSHIP_DETAILS_VIEW %>"/>
</portlet:renderURL>

<portlet:renderURL var="actionViewMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName" value="/view/ec-member-details" />
</portlet:renderURL>

<portlet:renderURL var="actionEditMembershipDetailsURL">
	<portlet:param name="mvcRenderCommandName"
		value="/edit/ec-member-details" />
</portlet:renderURL>

<portlet:actionURL name="submitNOC" var="actionSubmitNOCActionURL" />
<portlet:actionURL name="reviewMemberDetailRequest"
	var="actionReviewMemberDetailRequestActionURL" />
	
<portlet:actionURL name="submitReviewMemberDetailRequest"
	var="actionSubmitactionReviewMemberDetailRequestActionURL" />
	
<portlet:actionURL name="<%=MVCCommandNames.CREATE_QARAR_ACTION%>" var="createQararActionURL" />
<portlet:actionURL name="<%=MVCCommandNames.CREATE_MEMBER_REQUEST_ACTION%>" var="createMemberRequestActionURL" />

<c:forEach var="wAction"	items="${workflowTaskDetail.actionList}">
	<button class="btn omsb-bc-red-button"
		onClick="${wAction.handler}(`${workflowTaskDetail.requestId}`,`${workflowTaskDetail.taskId }`,`${workflowTaskDetail.transitionList}`,`${workflowTaskDetail.transitionLevelsList}`,`${workflowTaskDetail.workflowInstanceId }`)"><liferay-ui:message key="${wAction.name}" />
	</button>
</c:forEach>
<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_detail_view" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=actionSubmitactionReviewMemberDetailRequestActionURL%>" class="popup-form"
			method="post">
			<div class="modal-content">
				<div class="modal-header">
					<input name="<portlet:namespace />workflow-details"
						id="<portlet:namespace />workflow-details" type="hidden" />

					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-adjudicate" /></h5>
					<button type="button" class="close popup-reset" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label><liferay-ui:message key="ec-member-request-comments"/></label>
								<textarea name="<portlet:namespace />popup_adjudicate_comment" oninput="handleInput(this)"
									class="form-control comment" id="<portlet:namespace />popup_adjudicate_comment"></textarea>
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


<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_gme_detail_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=actionReviewMemberDetailRequestActionURL%>" class="popup-gme-form" method="post">
			<input name="<portlet:namespace />gme-request-details"
				id="<portlet:namespace />gme-request-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-gme-director"/></h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label><liferay-ui:message key="ec-member-request-comments"/></label>
								<textarea name="<portlet:namespace />popup_adjudicate_comment" oninput="handleInput(this)"
									class="form-control gmeComment"
									id="comment"></textarea>
									<span class="errorCommentMsg" style="color: red;"></span>
								<%-- <textarea name="<portlet:namespace />popup_adjudicate_comment" class="form-control" id="comment"></textarea> --%>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_gme_detail_view_action"></div>
			</div>
		</form>
	</div>
</div>
<!-- Modal popup -->

<!-- Modal popup -->
<div class="modal fade omsb-modal" id="ec_mem_noc_popup_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=actionSubmitNOCActionURL%>" class="popup-form" method="post">
			<input name="<portlet:namespace />noc-task-details"
				id="<portlet:namespace />noc-task-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-add-no-objection-letter"/></h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label><liferay-ui:message key="ec-member-request-no-objection-letter"/> <span style="color: red;">*</label> <input type="file"
									name="<portlet:namespace />nocDocument" oninput="handleInput(this)"
									id="<portlet:namespace />nocDocument" accept="image/*,.pdf"></input>
									<span class="nocFileErrorMsg" style="color:red;"></span>
							</div>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label><liferay-ui:message key="ec-member-request-comments"/></label>
								<textarea name="<portlet:namespace />noc_comment"
									class="form-control comment" id="<portlet:namespace />noc_comment"></textarea>
									<!-- <span class="errorCommentMsg" style="color: red;"></span> -->
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_noc_popup_action"></div>
			</div>
		</form>
	</div>
</div>

<div class="modal fade omsb-modal" id="ec_mem_qarar_popup_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=createQararActionURL%>" class="popup-form" method="post">
			<input name="<portlet:namespace />qarar-task-details"
				id="<portlet:namespace />qarar-task-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-submit-qarar-request"/></h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label><liferay-ui:message key="ec-member-request-comments"/></label>
								<textarea name="<portlet:namespace />qarar_comment"
									class="form-control comment" id="<portlet:namespace />qarar_comment"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_qarar_popup_action"></div>
			</div>
		</form>
	</div>
</div>

<!-- Modal popup -->

<div class="modal fade omsb-modal" id="ec_mem_member_request_popup_view"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<form action="<%=createMemberRequestActionURL%>" class="popup-form" method="post">
			<input name="<portlet:namespace />member-request-task-details"
				id="<portlet:namespace />member-request-task-details" type="hidden" />
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="ec-member-request-member-request-detail"/></h5>
					<button type="button" class="close" data-dismiss="modal" onClick="closePopup()"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="form-group">
								<label><liferay-ui:message key="ec-member-request-comments"/></label>
								<textarea name="<portlet:namespace />member_request_comment"
									class="form-control comments" id="<portlet:namespace />member_request_comment"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer ec_mem_member_request_popup_action"></div>
			</div>
		</form>
	</div>
</div>

<% 
	Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
    String siteFriendlyURL = group.getFriendlyURL(); %>
<!-- Modal popup -->

<script type="text/javascript">
$('#requestData').DataTable({
    "bLengthChange": false,
    "bFilter": false
});

function uploadNOCView(requestId,workflowTaskId,transitionNames, transitionLevels, workflowInstanceId){
	
	const transitionList = transitionNames.split(","); 
	const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_noc_popup_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
			$(".ec_mem_noc_popup_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitNocDetails(\'' + details + '\', \'<portlet:namespace/>noc-task-details\',\''+tName+'\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_noc_popup_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()"	data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_noc_popup_view");
	$("#ec_mem_noc_popup_view").modal("show");
	
}

function gmeDirectorsReview(requestId,workflowTaskId,transitionNames, transitionLevels, workflowInstanceId){
	
	 const transitionList = transitionNames.split(","); 
	 const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_gme_detail_view_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}";  
		 	var tNameSplit = tName.split("_").pop();
			$(".ec_mem_gme_detail_view_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitGMEDirectorDetails(\'' + details + '\', \'<portlet:namespace/>gme-request-details\',\'' +tNameSplit+ '\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_gme_detail_view_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()" data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_gme_detail_view");
	$("#ec_mem_gme_detail_view").modal("show");
}


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


function generateQararView(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	const transitionList = transitionNames.split(","); 
	const transitionLevelsList = transitionLevels.split(","); 
	 
	 $(".ec_mem_qarar_popup_action").empty();
	 
	 $.each( transitionList, function( index, tName ){
			
		 	let details ="{requestId:"+requestId+", workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+tName+"}"; 
			$(".ec_mem_qarar_popup_action").append('<button class="btn omsb-bc-red-button" id="transitionbutton" type="submit" onClick="return submitQararRequest(\'' + details + '\', \'<portlet:namespace/>qarar-task-details\');" >'+transitionLevelsList[index]+'</button>');
			
	   });
	 
	 $(".ec_mem_qarar_popup_action").append('<button type="button" class="btn omsb-btn omsb-bg-red-button" onClick="closePopup()"	data-dismiss="modal">Close</button>');
	
	
	$("#actions").attr("data-target","#ec_mem_qarar_popup_view");
	$("#ec_mem_qarar_popup_view").modal("show");
	
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

function viewMemberDetails(requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	let actionUrl = '<%=actionViewMembershipDetailsURL%>'+'&<portlet:namespace />ecMembershipRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}


function viewEditDetails (requestId,workflowTaskId,transitionNames,transitionLevels, workflowInstanceId){
	
	let actionUrl = '<%=actionEditMembershipDetailsURL%>'+'&<portlet:namespace />ecMembershipRequestId='+requestId;
	
	window.open(actionUrl, "_self" );

}



function addMembershipDetailsView(requestId,workflowTaskId,transitionNames,workflowInstanceId){
	let actionUrl = '<%=actionAddMembershipDetailsURL%>'+'&<portlet:namespace />ecMemberRequestId='+requestId;
	window.open(actionUrl, "_self" );
}

function viewDistributionReport(){
	alert("Distribution Report- in development");	
}

function viewIncentiveReport(){
	alert("Incentive Report in development");	
}

function rejectECRequestResource(){
    var commentValue = $(".comment").val().trim();
    if (commentValue === "") {	    
      $(".errorCommentMsg").text("Comment can not be empty !");
      return false;
    }  else {
      $(".comment").val(commentValue);
      $(".errorCommentMsg").text("");
      $("#ec_mem_detail_view").modal("hide");
      $(".popup-reset").trigger('reset');
      return true;
    } 
}

function rejectGMEDirector(){
    var commentValue = $(".gmeComment").val().trim();
    if (commentValue === "") {
      $(".errorCommentMsg").text("Comment can not be empty !");
      return false;
    }  else {
      $(".gmeComment").val(commentValue);
      $(".errorCommentMsg").text("");
      $("#ec_mem_gme_detail_view").modal("hide");
      $(".popup-reset").trigger('reset');
      return true;
    } 
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

function submitNocDetails(details, fieldId, tName)
{
	$("#"+fieldId).val(details);
	if(tName.toUpperCase() === "SEND_TO_AU_FOR_NOC"){
		return true;
	}
	
	var fileName = $("#<portlet:namespace />nocDocument").val();
	if(fileName === "")
	{
		$(".nocFileErrorMsg").text("Please select file !");
		return false;
	}
	else
	{
		$("#ec_mem_noc_popup_view").modal("hide");
		$(".nocFileErrorMsg").text("");
		return true;
	}
}

function submitGMEDirectorDetails(details, fieldId,tNameSplit){
	$("#"+fieldId).val(details);
	if(tNameSplit.toUpperCase() === 'REJECT')
	{
		return rejectGMEDirector();
	}
	 else{
		$("#ec_mem_gme_detail_view").modal("hide");	
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
  
function submitQararRequest(details, fieldId){
	$("#"+fieldId).val(details);
	$("#ec_mem_qarar_popup_view").modal("hide");
	return true;
}

function submitMemberRequest(details, fieldId){
	$("#"+fieldId).val(details);
	$("#ec_mem_member_request_popup_view").modal("hide");
	return true;
}

</script>