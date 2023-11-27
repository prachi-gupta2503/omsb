 	<%@ include file="../../init.jsp"%>	
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="<%= MVCCommandNames.UPDATE_EXAM_TRAINING_SITE_MVC_ACTION_COMMAND %>" var="updateExamTrainignSiteActionURL">
	<portlet:param name="redirect" value="<%=MVCCommandNames.OCT_NEW_TRAINING_SITE_RENDER%>" />
	<portlet:param name="siteId" value="${siteId}"/>
	<portlet:param name="seatsObjectId" value="${id}"/>
</portlet:actionURL>

	<portlet:resourceURL id="<%=MVCCommandNames.EDIT_NEW_TRAINING_SITE%>" var="editTrainingSiteDetailsURL" />
		<div class="omsb-main-wrapper" id="omsb-main-wrapper">
			<div id="wrapper">
				<div class="container">
					<div class="omsb-card ">
									<aui:form action="${updateExamTrainignSiteActionURL}" name="examTraining" method="post">
										<div id="edu_detail_area">
										<!-- <div class="omsb-card omsb-card-graybg omsb-noBorderRadius edu_detail element bottom-backbtn-wrap" id="edu_detail" > -->
										<div class="omsb-card edu_detail element " id="edu_detail" >
											<div class="omsb-list-filter">
											<div class="row ">
												<div class="col-lg-4 col-md-4">
													
													<c:choose>
														<c:when test="${not empty siteNameMap}">
															<aui:input cssClass="form-control" label="exam-center" type="text" name="siteValue" localized="true" value="${siteNameMap}">
															<aui:validator name="required" />
															</aui:input>
														</c:when>
														<c:otherwise>
															<aui:input cssClass="form-control" label="exam-center" type="text" name="siteValue" localized="true" value="" id="examCenter">
															<aui:validator name="required" />
															</aui:input>
														</c:otherwise>
													</c:choose>
													
												</div>
												
												<div class="col-lg-4 col-md-4 col-sm-4">
													<div class="form-group">
													<aui:input cssClass="form-control" id="seats" label="seats" type="number" min="0" name="seats" value="${seats}">
																<aui:validator name="required" />
																<aui:validator name="number" />
															</aui:input>
													</div>
												</div>
												<div class="col-lg-4 col-md-4">
													<div class="form-group">
														<aui:select name="statusId" label="status" id="status"> <aui:validator name="required" />
															<aui:option value=""><liferay-ui:message key="select" /> </aui:option>
															<aui:option value="Active" selected="${status eq 'active'}" ><liferay-ui:message key="active" /></aui:option>
															<aui:option value="Retired" selected="${status eq 'retired'}"><liferay-ui:message key="Retired" /></aui:option>
														</aui:select>
														</div>
												</div>
													<div class="col-md-12">
													 <div class="bottom-backbtn-wrap">
														<%-- <button class="btn omsb-bc-red-button" onClick="clearForm()" type="button" title="<liferay-ui:message key='clear'/>"><liferay-ui:message key="clear"/></button> --%>
														<button class="btn omsb-bg-red-button mx-2" type="submit" title="Save" id="add_edu_detail"><liferay-ui:message key="save"/></button>
														<button class="btn omsb-bg-red-button d-none" onclick="UpdateTrainingSite()" type="button" id="update-btn-traingSite"><liferay-ui:message key="update"/></button>
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
										<h5 id="errorContainer-educational-detail" class="error-container"></h5> 
										</div>
										<div id="listOctExamTitle">
											
													<table class="display omsb-datatables training-site" id="exam-title-list"
														width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="exam-center-english" /></th>
																<%-- <th><liferay-ui:message key="exam-center-arabic" /></th> --%>
																<th><liferay-ui:message key="seats" /></th>
																<th><liferay-ui:message key="status" /></th>
																<th hidden=""><liferay-ui:message key="OctNewTrainingSiteId" /></th>
																<th><liferay-ui:message key="actions" /></th>
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="entry" items="${listOctTrainingSite}">
															<tr id="entry_${entry.id}">
																<td>${entry.nameEnglish}</td>
																<%-- <td>${entry.nameArabic}</td> --%>
																<td>${entry.seats}</td>
																<td>${entry.statusId}</td>
																<td hidden="">${entry.octNewTrainingSiteId}</td>
																 <td>
																 <portlet:renderURL var="newTrainingSiteTitle">
																		<portlet:param name="mvcRenderCommandName"
																			value="<%=MVCCommandNames.OCT_NEW_TRAINING_SITE_RENDER%>" />
																		<portlet:param name="siteId" value="${entry.id}" />
																	</portlet:renderURL>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-site-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setSiteDeleteID('${entry.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<a onclick="editExamTrainingSite('${entry.id}', '${entry.nameEnglish}', '${entry.seats}', '${entry.statusId}', '${entry.octNewTrainingSiteId}')"  class="btn mx-2" href="#" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></a>
																</td> 
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									<input type="hidden" value="" name="siteDeleteID" id="siteDeleteID"/>
									<input type="hidden" value="" name="examTrainingSitePrimaryID" id="examTrainingSitePrimaryID"/>
									<input type="hidden" value="" name="examPicklistID" id="examPicklistID"/>
										
									</aui:form>
								</div>
							</div>
						</div>
					</div>
					
		<!--delete popup for Exam title -->
		<div class="modal fade omsb-modal" id="delete-site-education-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="siteExampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteTrainingSiteRow()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->
		
		<portlet:resourceURL id="<%=MVCCommandNames.SAVE_OCT_TRAINING_SITE_DETAILS%>" var="saveTrainingSiteDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommandNames.DELETE_OCT_TRAINING_SITE_DETAILS%>" var="deleteTrainingSiteDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommandNames.GET_OCT_EXAM_TITLE_DETAILS%>" var="getExamTitleDetailsURL" />
		
								
	<script>	
	
	function setSiteDeleteID(id){
		document.getElementById("siteDeleteID").value = id;
	}
	
	function clearForm(){
		document.getElementById("<portlet:namespace />siteValue").value = '';
		isEdit=false;
	}
	
	function setEditID(id,enName,arName){
		console.log("id " + id);
		console.log("enName " + enName);
		console.log("arName "  + arName);
		console.log("edit is called");
		if(id){
			console.log("inside if of edit");
			
			if(document.getElementById("<portlet:namespace />siteValue_en_US")) {
				document.getElementById("<portlet:namespace />siteValue").value = enName;
				document.getElementById("<portlet:namespace />siteValue_en_US").value = enName;
			}
			if(document.getElementById("<portlet:namespace />siteValue_ar_SA")) {
				document.getElementById("<portlet:namespace />siteValue").value = arName;
				document.getElementById("<portlet:namespace />siteValue_ar_SA").value = arName;
			}
			document.getElementById("siteDeleteID").value = id;
			
			var editDocTitle = $("."+editedClass).find("td:nth-child(1)").html(docTitle);
			var editFileTitle = $("."+editedClass).find("td:nth-child(2)").html(docFile.name);
		}
	}
	
	function deleteTrainingSiteRow(){
		var deleteId = document.getElementById("siteDeleteID").value;
		
		if(deleteId){
			$.ajax({
				url: '${deleteTrainingSiteDetailsURL}',
				async : false,
				data : {
					"<portlet:namespace />id" : deleteId,
				},
				type : 'POST',
				success : function(data) {
					$('#delete-site-education-confirm-modal').modal('hide');
					document.getElementById("<portlet:namespace />siteValue").value = "";
					$("#entry_"+deleteId).remove();
				},
			})
		}
	}
	
	
	
	$('.training-site').DataTable({
		"bLengthChange": false,
		"bFilter": false,
		"ordering": false
	});
	
	function editExamTrainingSite(id, name, seats, statusId, OctNewTrainingSiteId) {
	    // Do something with the values passed as arguments
	    console.log("Edit Exam Training Site with the following data:");
	    console.log("ID: " + id);
	    console.log("Name: " + name);
	    console.log("Seats: " + seats);
	    console.log("Status ID: " + statusId);
	    console.log("Oct New Training Site ID: " + OctNewTrainingSiteId);

	    $('#<portlet:namespace />examCenter').val(name);
	    $('#<portlet:namespace />seats').val(seats);
	    $('#<portlet:namespace />status').val(statusId);
		 $('#examPicklistID').val(id);
		 $('#examTrainingSitePrimaryID').val(OctNewTrainingSiteId); 
		 $('#update-btn-traingSite').removeClass('d-none');
	}
	
	function UpdateTrainingSite(){
		var examCenter =  $('#<portlet:namespace />examCenter').val();
		var seats =  $('#<portlet:namespace />seats').val();
		var status =  $('#<portlet:namespace />status').val();
		var examPicklistID = $('#examPicklistID').val();
		var examTrainingSitePrimaryID = $('#examTrainingSitePrimaryID').val(); 
		
		console.log("examCenter: " + examCenter);
	    console.log("seats: " + seats);
	    console.log("status: " + status);
	    console.log("examPicklistID: " + examPicklistID);
	    console.log("examTrainingSitePrimaryID: " + examTrainingSitePrimaryID);
	    $.ajax({
			url: '${editTrainingSiteDetailsURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />examPicklistID : examPicklistID,
				<portlet:namespace />examTrainingSitePrimaryID : examTrainingSitePrimaryID,
				<portlet:namespace />examCenter : examCenter,
				<portlet:namespace />seats : seats,
				<portlet:namespace />status : status,
			},
			type : 'POST',
			success : function(data) {
				location.reload(true);
	            },
		})
		console.log("ajax ended")
	}

	
	
	</script>