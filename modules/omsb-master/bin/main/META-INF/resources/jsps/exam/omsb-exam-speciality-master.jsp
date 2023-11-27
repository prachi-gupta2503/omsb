<%@ include file="../../init.jsp"%>	

<portlet:actionURL name="<%= MVCCommandNames.UPDATE_EXAM_SPECIALITY_MASTER_MVC_ACTION_COMMAND %>" var="saveExamSpecialityMasterActionURL">
	<portlet:param name="redirect" value="<%=MVCCommandNames.OMSB_EXAM_SPECIALITY_MASTER_RENDER%>" />
	<portlet:param name="titleId" value="${titleId}"/>
</portlet:actionURL>
 <portlet:resourceURL id="<%=MVCCommandNames.DELETE_OMSB_EXAM_SPECIALITY_MASTER_DETAILS%>" var="deleteExamSpecialityMasterDetailsURL" />					
 <portlet:resourceURL id="<%=MVCCommandNames.EDIT_OMSB_EXAM_SPECIALITY_MASTER_DETAILS%>" var="EditExamSpecialityMasterDetailsURL" />					

				<div class="omsb-main-wrapper" id="omsb-main-wrapper">
					<div id="wrapper">
						<div class="container">
							<div class="omsb-card ">
								<div class="omsb-page-top-info mb-0">
									<div class="omsb-page-top-info">
										<h3 class="reg-form-title"><liferay-ui:message key="exam-speciality-master" /> </h3>
									</div>
								</div>
									<aui:form action="${saveExamSpecialityMasterActionURL}" name="fm" method="post">
										<div id="edu_detail_area">
										<div class="omsb-card edu_detail element " id="edu_detail" >
											<div class="omsb-list-filter">
											<div class="row ">
												<div class="col-lg-6 col-md-6">
													<c:choose>
														<c:when test="${not empty titleNameMap}">
															<aui:input cssClass="form-control" label="value" type="text" name="specialityValue" localized="true" value="${titleNameMap}">
															<aui:validator name="required" />
															</aui:input>
														</c:when>
														<c:otherwise>
															<aui:input id="specialityNameId" cssClass="form-control" label="value" type="text" name="specialityValue" localized="true" value=" " >
															<aui:validator name="required" />
															</aui:input>
														</c:otherwise>
													</c:choose>
												</div>
													<div class="col-lg-6 col-md-6">
													 <div class="bottom-backbtn-wrap">
														<button class="btn omsb-bc-red-button" onClick="clearForm()" type="button" title="<liferay-ui:message key='clear'/>"><liferay-ui:message key="clear"/></button>
														<button class="btn omsb-bg-red-button" type="submit" id="add_edu_detail"><liferay-ui:message key="add"/></button>
														<button class="btn omsb-bg-red-button d-none" onclick="UpdateSpeciality()" type="button" id="update-btn"><liferay-ui:message key="update"/></button>
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
											
													<table class="display omsb-datatables speciality-master" id="exam-title-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="exam-speciality-master-english" /></th>
																<th><liferay-ui:message key="exam-speciality-master-arabic" /></th> 
																<th><liferay-ui:message key="actions" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="entry" items="${listSpecialityMaster}">
															<tr id="entry_${entry.id}">
																<td>${entry.nameEnglish}</td>
																 <td>${entry.nameArabic}</td> 
																 <td>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${entry.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<a class="btn mx-2" href="#" onclick="editSpeciality('${entry.nameEnglish}', '${entry.id}', '${entry.nameArabic}')">
   																	 <img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></a>
																</td> 
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									<input type="hidden" value="" name="deleteID" id="deleteID"/>
									<input type="hidden" value="" name="specialityPrimaryID" id="specialityPrimaryID"/>
									</aui:form>
								</div>
							</div>
						</div>
					</div>
					
		<!--delete popup for Exam title -->
		<div class="modal fade omsb-modal" id="delete-education-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
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
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteExamSpecialityMaster()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->

	<script>	
	
	function deleteExamSpecialityMaster(){
		var deleteId = document.getElementById("deleteID").value;
		console.log("deleteId"+deleteId)
		if(deleteId){
			$.ajax({
				url: '${deleteExamSpecialityMasterDetailsURL}',
				async : false,
				data : {
					"<portlet:namespace />id" : deleteId,
				},
				type : 'POST',
				success : function(data) {
					$('#delete-education-confirm-modal').modal('hide');
					document.getElementById("<portlet:namespace />specialityValue").value = "";
					$("#entry_"+deleteId).remove();
				},
			})
		}
	}
	
	function setDeleteID(id){
		document.getElementById("deleteID").value = id;
	}
	
	function clearForm(){
		document.getElementById("<portlet:namespace />specialityValue").value = '';
		isEdit=false;
	}
	
	$('.speciality-master').DataTable({
		"bLengthChange": false,
		"bFilter": false,
		"ordering": false
	});
	
	function editSpeciality(specialityName, listTypeEntryId, arabicValue){
		 var listTypeEntryId = listTypeEntryId;
		    var specialityName = specialityName;
		    console.log("Edit Speciality Name: " + specialityName);
		    console.log("List Type Entry ID: " + listTypeEntryId);
		    var oldValue = $('#<portlet:namespace />specialityNameId').val(specialityName);
		     $('#specialityPrimaryID').val(listTypeEntryId);
		     $('#update-btn').removeClass('d-none');
	}
	
	function UpdateSpeciality(){
		var specialityPrimaryID = $('#specialityPrimaryID').val();
		var newValue = $('#<portlet:namespace />specialityNameId').val();
		 console.log("examTypePrimaryID: " + specialityPrimaryID);
		    console.log("newValue: " + newValue);
		    $.ajax({
				url: '${EditExamSpecialityMasterDetailsURL}',
				async : false,
				dataType:"json",
				data : {
					<portlet:namespace />specialityPrimaryID : specialityPrimaryID,
					<portlet:namespace />newValue : newValue,
				},
				type : 'POST',
				success : function(data) {
					location.reload(true);
		            },
			})
		    
		    
		
		
	}

	
	</script>