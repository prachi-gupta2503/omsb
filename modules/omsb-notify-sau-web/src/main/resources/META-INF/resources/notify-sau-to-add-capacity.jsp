<%@ include file="init.jsp" %>

<style>
.omsb-notification-img img{
	width: 100%;
}
</style>
<portlet:resourceURL id="/getRotationByTsURL" var="getRotations" />
<portlet:resourceURL id="/getNoOfSlotsURL" var="getNoOfSlotsURL" />

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="notify-sau-for-increase-in-capacity" /></h4>
			<aui:form action="${notifySauUserAction}" method="post" name="fm">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input id="currentUser" name="currentUser" value="<%=themeDisplay.getUserId() %>" type="hidden" />  
							<aui:select cssClass="custom-select form-control" label="training-site" id="trainingSite" name="trainingSiteId" onChange="getRotationAndSauUser()">
								<aui:option value="0"><liferay-ui:message key="please-select-training-site" /></aui:option>
								<c:forEach items="${addTrainingSiteList}" var="addTrainingSiteList">
									<aui:option value="${addTrainingSiteList.trainingSiteMasterId}">${addTrainingSiteList.trainingSiteName}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="rotation" id="rotation" name="rotation" onChange="getNoOfSlots()">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" multiple="true" label="site-authorized-user" id="siteAuthorizedUser" name="notifySauDraft">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-sau" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="current-slots" disabled="true" id="currentSlots" name="currentCapacity"/>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="requested-slots" id="requestedSlotsDraft" name="requestedCapacityDraft" type="number" min="1" step="1" max="">
								<aui:validator name="required"/>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button notify-sau-add-to-capacity" id="notifySauAddToCapacity" type="button" title="Notify Site Authorized User" type="button" data-target="#addCapacityNotifyAuthorizedUser" data-toggle="modal" disabled="true"><liferay-ui:message key="notify-site-authorized-user" /></button>
				</div>
				<jsp:include page="/add-capacity-notify-sau-modal.jsp" />
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/currently-available-slots.jsp" />
</div>

<script>
var isVisibleAddToCapacityNotifyButton = false;

$(document).ready(function () {
    $('#<portlet:namespace/>siteAuthorizedUser').multiselect();
})

function showAddToCapacityNotifyButton(isVisible) {
	if(isVisible) {
		$(".notify-sau-add-to-capacity").removeAttr("disabled");
	} else {
		$(".notify-sau-add-to-capacity").attr("disabled", "true");
	}	
}

$(document).on("click",".notify-sau-add-to-capacity", function(){
	$("#"+$(this).data('id')).click();
	$("#<portlet:namespace/>currentCapacityModal").val($("#<portlet:namespace/>currentSlots").val());
	$("#<portlet:namespace/>requestedCapacity").val($("#<portlet:namespace/>requestedSlotsDraft").val());
	var userLists = "";
	$("#<portlet:namespace/>siteAuthorizedUser option:selected").each(function() {
		userLists +=
			"<li class=\"omsb-comment-box mb-1\">\r\n" + 
			"	<div class=\"omsb-notification-box\">\r\n" + 
			"		<div class=\"custom-control custom-checkbox\">\r\n" + 
			"			<input type=\"checkbox\" checked class=\"custom-control-input checkbox-notify-sau-create\" onclick=\"updateSubmitButton(true)\" id=\"<portlet:namespace/>notifySau\" name=\"<portlet:namespace/>notifySau\" value=\""+$(this).val()+"\">\r\n" + 
			"				<label class=\"custom-control-label\" for=\"<portlet:namespace/>notifySau\"></label>\r\n" + 
			"		</div>\r\n" + 
			"		<div class=\"omsb-notification-img\" >\r\n" + 
			"			<img src=\""+$(this).data('src')+"\" alt=\"\">\r\n" + 
			"		</div>\r\n" + 
			"		<div class=\"omsb-notification-dtls\" >\r\n" + 
			"			<h6> "+$(this).text()+" </h6>\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"</li>";
    });
	$("#userListAddToCapacity").html(userLists);
});

function getRotationAndSauUser(){	
	
	console.log('called');
	let trainingSite = $("#<portlet:namespace/>trainingSite").val();
	console.log(trainingSite);
	$.ajax({
		url: '<%=getRotations%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>trainingSite: trainingSite
			},
		success: function(data)	
		{
			let rotationJson = JSON.parse(data);
			var userFirstOption = $('#<portlet:namespace/>siteAuthorizedUser option:first').clone();
			$("#<portlet:namespace/>siteAuthorizedUser").empty();
			$("#<portlet:namespace/>siteAuthorizedUser").selectedIndex = 0;
			$("#<portlet:namespace/>siteAuthorizedUser").append(rotationFirstOption);
			$('#<portlet:namespace/>siteAuthorizedUser').multiselect('destroy');
			$('#<portlet:namespace/>siteAuthorizedUser').multiselect();
			
			var rotationFirstOption = $('#<portlet:namespace/>rotation option:first').clone();
			$("#<portlet:namespace/>rotation").empty();
			$("#<portlet:namespace/>rotation").selectedIndex = 0;
			$("#<portlet:namespace/>rotation").append(rotationFirstOption);
			
			
			$("#<portlet:namespace/>currentSlots").val(' ');
			
			for(let i=0; i<rotationJson.sauUserJson.length; i++){
				var newOption = new Option(rotationJson.sauUserJson[i].sauUserName, rotationJson.sauUserJson[i].sauUserId);
				newOption.setAttribute("data-src", rotationJson.sauUserJson[i].sauUserImage);
				$("#<portlet:namespace/>siteAuthorizedUser").append(newOption).multiselect('rebuild');
			}
			
			for(let i=0; i<rotationJson.rotationListJson.length; i++){
				$("#<portlet:namespace/>rotation").append("<option value='"+rotationJson.rotationListJson[i].rotationMasterId+"'>" + rotationJson.rotationListJson[i].rotationName + "</option>");
			}
			if(rotationJson.sauUserJson.length > 0) {
				$(".notify-sau-add-to-capacity").prop('disabled', false);
			} else {
				$(".notify-sau-add-to-capacity").prop('disabled', true);
			}
			
		},
		error: function(data)
		{
			console.log('error');
		}
	});
}

 function getNoOfSlots(){
	let trainingSite = $("#<portlet:namespace/>trainingSite").val();
	console.log(trainingSite);
	let rotation = $("#<portlet:namespace/>rotation").val();
	console.log(rotation);
	$.ajax({
		url: '<%=getNoOfSlotsURL%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>rotation: rotation,
				<portlet:namespace/>trainingSite: trainingSite
			},
		success: function(data)	
		{
			let slotsJson = JSON.parse(data);
			$("#<portlet:namespace/>currentSlots").empty();
			$("#<portlet:namespace/>currentSlots").val(slotsJson.noOfSlots);
		}
	});
}
</script>