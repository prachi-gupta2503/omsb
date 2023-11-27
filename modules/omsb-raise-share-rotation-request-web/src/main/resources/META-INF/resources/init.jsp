<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="mvcRenderCommandName" value="/" />
</liferay-portlet:renderURL>

<portlet:resourceURL var="getProgramIdMVCResourceURL" id="<%= OmsbRaiseShareRotationRequestWebPortletKeys.GET_RAISE_SHARE_ROTATION_REQUEST_PROGRAM_MVC_RESOURCE_COMMAND %>" />
<portlet:resourceURL var="getProgramDurationIdMVCResourceURL" id="<%= OmsbRaiseShareRotationRequestWebPortletKeys.GET_RAISE_SHARE_ROTATION_REQUEST_PROGRAM_DURATION_MVC_RESOURCE_COMMAND %>" />
<portlet:resourceURL var="getProgramUserDetailMVCResourceURL" id="<%= OmsbRaiseShareRotationRequestWebPortletKeys.GET_SHARE_ROTATION_PROGRAM_USER_DETAIL_MVC_RESOURCE_COMMAND %>" />

<portlet:actionURL name="<%= OmsbRaiseShareRotationRequestWebPortletKeys.SAVE_RAISE_SHARE_ROTATION_REQUEST_MVC_ACTION_COMMAND %>" var="saveShareRotationRequestActionURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbRaiseShareRotationRequestWebPortletKeys.ADD_RAISE_SHARE_ROTATION_REQUEST_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<script type="text/javascript">


$(document).ready(function(){
	
	$(".js-basic-single").each(function() {
	    var elementId = $(this).attr("id");
	    $("#"+elementId).select2();
	});
	$(".form-group .input-text-wrapper label").attr("style","display:none");
	$("#notifyauthorizeduser .form-group .input-text-wrapper label").attr("style","display:block");
	$("#notifyagainauthorizeduser .form-group .input-text-wrapper label").attr("style","display:block");
	$("#currentCapacity").html($("#<portlet:namespace/>noOfTraineesRequested").val());
	
	if(${showModal}){
        $('#omsb-notification-sidebar').addClass('open')
    }
});

$(document).on("click",".sidebar-close-btn",function(){
    $('#omsb-notification-sidebar').removeClass('open')
})

$(document).on("click",".openDeleteModal", function(){
    $('#deleteModal #<portlet:namespace/>sharedRotationRequestId').val($(this).data('id'));
})

$(document).on("click",".request-again", function(){
	$('#<portlet:namespace/>reSharedRotationRequestId').val($(this).data('value'));
	$('#<portlet:namespace/>isRaisedAgain').val('true');
    $("#reCurrentCapacity").html($(this).data('estimatenooftraineesrequested'));
	$('#<portlet:namespace/>reNoOfTraineesRequested').attr('max', $(this).data('estimatenooftraineesrequested'));
	
    getProgramUserDetail($(this).data('programdurationid'),true);
})

$(".modal-backdrop").remove();

function setCurrentCapacity(noOfTraineesRequested){
	$("#currentCapacity").html(noOfTraineesRequested);
    $("#<portlet:namespace/>noOfTraineesRequested").val(noOfTraineesRequested);
}

$(document).on("click",".edit-notify-model", function(){
	getProgramUserDetail($(this).data('value'),false);
});

function getProgramMasterId(rotationId){
    $.ajax({
        url: '<%=getProgramIdMVCResourceURL%>',
			type : 'POST',
			data : {
				<portlet:namespace/>rotationId : rotationId
			},
			success : function(programMasterData) {
				if (programMasterData.success) {
					$("#<portlet:namespace/>programId").empty();
					$("#<portlet:namespace/>programDurationId").empty();
					$("#<portlet:namespace/>programId").append("<option value=''><liferay-ui:message key='please-select-program' /></option>");
					$("#<portlet:namespace/>programDurationId").append("<option value=''><liferay-ui:message key='please-select-program-duration' /></option>");
					let programMasterDataArray = programMasterData.result;
					for(let i=0; i<programMasterDataArray.length; i++){
						$("#<portlet:namespace/>programId").append("<option value='"+programMasterDataArray[i].programMasterId+"'>" + programMasterDataArray[i].programName + "</option>");
					}
				}
			}
		});
	}
	
function getProgramDurationId(programId){
    $.ajax({
        url: '<%=getProgramDurationIdMVCResourceURL%>',
			type : 'POST',
			data : {
				<portlet:namespace/>programId : programId
			},
			success : function(programDuraionData) {
				if (programDuraionData.success) {
					//$("#<portlet:namespace/>programId").empty();
					$("#<portlet:namespace/>programDurationId").empty();
					$("#<portlet:namespace/>programDurationId").append("<option value=''><liferay-ui:message key='please-select-program-duration' /></option>");
					let programDurationMasterDataArray = programDuraionData.result;
					for(let i=0; i<programDurationMasterDataArray.length; i++){
						$("#<portlet:namespace/>programDurationId").append("<option value='"+programDurationMasterDataArray[i].programDurationId+"'>" + programDurationMasterDataArray[i].ayApplicableForm + "</option>");
					}
				}
			}
		});
	}
	
function getProgramUserDetail(programDurationId, isRequestAgain){
    $.ajax({
        url: '<%=getProgramUserDetailMVCResourceURL%>',
			type : 'POST',
			data : {
				<portlet:namespace/>programDurationId : programDurationId
			},
			success : function(programUserDetails) {
				if (programUserDetails.success) {
					if(isRequestAgain) {
						$("#reUserList").html("");
					} else {						
						$("#userList").html("");
					}
					let programUserDetailsArray = programUserDetails.result;
					var userLists = "";
					if(isRequestAgain) {
						for(let i=0; i<programUserDetailsArray.length; i++){
							userLists +=
								"<li class=\"omsb-comment-box mb-1\">\r\n" + 
								"	<div class=\"omsb-notification-box\">\r\n" + 
								"		<div class=\"custom-control custom-checkbox\">\r\n" + 
								"			<input type=\"checkbox\" class=\"custom-control-input user-re-checkbox-control\" id=\"<portlet:namespace/>requestRaisedTo\" name=\"<portlet:namespace/>requestRaisedTo\" onclick='validateRaiseRequestBtn(this, true)' value=\""+programUserDetailsArray[i].requestRaisedTo+"\">\r\n" + 
								"				<label class=\"custom-control-label\" for=\"<portlet:namespace/>requestRaisedTo\"></label>\r\n" + 
								"		</div>\r\n" + 
								"		<div class=\"omsb-notification-img\" >\r\n" + 
								"			<img src=\""+ programUserDetailsArray[i].requestRaisedToUserImage +"\" alt=\"\">\r\n" + 
								"		</div>\r\n" + 
								"		<div class=\"omsb-notification-dtls\" >\r\n" + 
								"			<h6> "+ programUserDetailsArray[i].requestRaisedToUserDetail +" </h6>\r\n" + 
								"		</div>\r\n" + 
								"	</div>\r\n" + 
								"</li>";
						}
					} else {						
						for(let i=0; i<programUserDetailsArray.length; i++){
							userLists +=
								"<li class=\"omsb-comment-box mb-1\">\r\n" + 
								"	<div class=\"omsb-notification-box\">\r\n" + 
								"		<div class=\"custom-control custom-checkbox\">\r\n" + 
								"			<input type=\"checkbox\" class=\"custom-control-input user-checkbox-control\" id=\"<portlet:namespace/>requestRaisedTo\" name=\"<portlet:namespace/>requestRaisedTo\" onclick='validateRaiseRequestBtn(this, false)' value=\""+programUserDetailsArray[i].requestRaisedTo+"\">\r\n" + 
								"				<label class=\"custom-control-label\" for=\"<portlet:namespace/>requestRaisedTo\"></label>\r\n" + 
								"		</div>\r\n" + 
								"		<div class=\"omsb-notification-img\" >\r\n" + 
								"			<img src=\""+ programUserDetailsArray[i].requestRaisedToUserImage +"\" alt=\"\">\r\n" + 
								"		</div>\r\n" + 
								"		<div class=\"omsb-notification-dtls\" >\r\n" + 
								"			<h6> "+ programUserDetailsArray[i].requestRaisedToUserDetail +" </h6>\r\n" + 
								"		</div>\r\n" + 
								"	</div>\r\n" + 
								"</li>";
						}
					}
					if(isRequestAgain) {
						$("#reUserList").html(userLists);
					} else {						
						$("#userList").html(userLists);
					}
				}
			}
		});
	}
	
$("#validate-form-button").on('click', function() {
	$(".help-block").remove();
	var isValidate = true;

 	$('.required-field').each(function() {
 		if(!$(this).val()) {
 			let fieldName = $("label[for='"+$(this).attr('name')+"']").text().trim();
 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='\${$(this).attr("name")}Helper'>
 				<div role="alert" class="text-danger"><liferay-ui:message key="The \${fieldName} field is required." /></div>
 			</div>`
 			$(this).closest('.form-group').append(errorMsg);
 			isValidate = false;
 		}
 	});

	if(!isValidate) {
		$(".modal-backdrop").remove();
		$("#notifyauthorizeduser").hide();
		return false;
	}
	$("#notifyauthorizeduser").show();
});

function validateField(field) {
	if(field.val()) {
		$('#'+field.attr('id')+'Helper').remove();
	}
}

$('#<portlet:namespace/>comment').on('change', function(){
	if($(this).val()) {
		$('#'+$(this).attr('id')+'Helper').remove();
	}
});

</script>
