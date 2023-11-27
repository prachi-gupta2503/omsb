<%@ include file="../../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-ui:error key="setTrainingSiteFormError" message="training-site-error" />

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_TRAINING_SITE_MVC_ACTION_COMMAND%>"
	var="saveTrainingSiteActionURL">
</portlet:actionURL>

<portlet:resourceURL
	id="<%=MVCCommandNames.DELETE_TRAINING_SLOT%>"
	var="deleteTrainingSiteURL" />

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
				<aui:form action="${saveTrainingSiteActionURL}" name="siteSlot"
					method="post">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="training-site" id="trainingSiteId" name="trainingSiteId" onChange="loadExamSlots()">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-training-site" />
									</aui:option>
									<c:forEach items="${listOctTrainingSite}"
										var="listOctTrainingSite">
										<c:choose>
											<c:when test="${themeDisplay.getLocale() =='en_US'}">
												<aui:option value="${listOctTrainingSite.id}">${listOctTrainingSite.nameEnglish}</aui:option>
											</c:when>
											<c:otherwise>
												<aui:option value="${listOctTrainingSite.id}">${listOctTrainingSite.nameArabic}</aui:option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>


						<div class="col-lg-6 col-md-6 col-sm-12">

						<div class="form-group">
							<label class="required"><liferay-ui:message
									key="exam-slots" /></label> 
							<select id="timeSlotId"
								name="<portlet:namespace/>timeSlot" class="form-control">
							</select>
						</div>

					</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<div id="<portlet:namespace />start-container">
									<aui:input name="start" type="time" cssClass="form-control timePicker" placeholder="HH:MM"><aui:validator name="required" /></aui:input>
								</div>

							</div>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<div id="<portlet:namespace />end-container">
									<aui:input name="end" type="time" cssClass="form-control timePicker" placeholder="HH:MM"> <aui:validator name="required" /> </aui:input>
								</div>
							</div>
						</div>

						<div class="col-lg-12 col-md-6 col-sm-12">
							<div class="form-group">
								<div class="bottom-backbtn-wrap m-0">
									<button class="btn omsb-bg-red-button mx-2" type="submit"
										title="Save">
										<liferay-ui:message key="save" />
									</button>
									
									<portlet:renderURL var="OCTHomeURL">
															<portlet:param name="mvcRenderCommandName" value="/" />
														</portlet:renderURL>
														<a class="btn omsb-btn btn-back" href="${OCTHomeURL }"><i
															class="fi fi-sr-arrow-left"></i>
														<liferay-ui:message key="back" /></a>
								</div>
							</div>
						</div>
					</div>
					
									 <div id="listOctExamTitle">
													<table class="display omsb-datatables training-slot" 
														width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="training-site" /></th>
																<th><liferay-ui:message key="exam-slot" /></th>
																<th><liferay-ui:message key="actions" /></th>
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="entry" items="${octTrainingSlotMasters}">
															<tr id="${entry.id}">
																<td>${entry.trainingSiteIdName}</td>
																<td>${entry.timeSlot}</td>
																 <td><button class="btn delete_btn" value="Delete"
												     	type="button" data-toggle="modal" data-target="#delete-rowTrainingSite"
												      	onclick="deleltetrainingId('${entry.id}')" >
													<img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;">
												</button></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div> 
				</aui:form>
			</div>
		</div>
	</div>
	
	<div class="modal fade omsb-modal" id="delete-rowTrainingSite" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message key="delete-confirmation" />
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="are-you-want-to-delete" />
							</div>
						</div>
					</div>
					<input type="hidden" name='<portlet:namespace/>primaryTrainingSlotId' id="primaryTrainingSlotId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setTrainingSiteID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>




<portlet:resourceURL
	id="<%=MVCCommandNames.GET_EXAM_SLOTS_FOR_TRAINING_SITES%>"
	var="getDropdownListURL" />


<script>

$(document).ready(function () {
	loadExamSlots();
	$(document).on('change','#<portlet:namespace />trainingSiteId',function(){ 
		console.log("onchange");
		loadExamSlots();
	});
});

function loadExamSlots(){
	 var selectedTrainingSiteId = $('#<portlet:namespace />trainingSiteId').val();
		console.log("selectedTrainingSiteId "+selectedTrainingSiteId);
	  /*   $('#timeSlotId option').remove(); */ 
	    $('#timeSlotId').empty();   // Clear existing results
	    $.ajax({
			url: '${getDropdownListURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />trainingSiteId : selectedTrainingSiteId,
				<portlet:namespace />resourceName : 'examSlotList'
			},
			type : 'POST',
			success : function(data) {
				var response = data;
	            for (var i = 0; i < response.length; i++) {
	            	 $("#timeSlotId").append("<option value='" + response[i].value + "'>" + response[i].name + "</option>");
	            }
	            
			},
		})
}

$('.training-slot').DataTable({
	"bLengthChange": false,
	"bFilter": false,
	"ordering": false
});



function deleltetrainingId(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("primaryTrainingSlotId"); // Set the value of the input 
	$('#primaryTrainingSlotId').val(id);
}

 function setTrainingSiteID(){
	var primaryTrainingSlotId = $('#primaryTrainingSlotId').val();
	$.ajax({
		url: '${deleteTrainingSiteURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />primaryTrainingSlotId : primaryTrainingSlotId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
}  
</script>













