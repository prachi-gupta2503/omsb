<%@ include file="../../init.jsp"%>	

<portlet:actionURL name="<%= MVCCommandNames.SAVE_EXAM_TYPE_MASTER_MVC_ACTION_COMMAND %>" var="saveExamTypeEligibilityMasterActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.EXAM_ELIGIBILITY_RESOURCES_COMMAND%>" var="examEligibilityListURL" />	
<portlet:resourceURL id="<%=MVCCommandNames.DELETE_PL_EXAM_TYPE_MVC_RESOURCE_COMMAND%>" var="examTypePLListDeleteURL" />
<portlet:resourceURL id="<%=MVCCommandNames.EDIT_PL_EXAM_TYPE_MVC_RESOURCE_COMMAND%>" var="editExamTypePLListURL" />	

				<div class="omsb-main-wrapper" id="omsb-main-wrapper">
					<div id="wrapper">
						<div class="container">
							<div class="omsb-card ">
									<aui:form action="${saveExamTypeEligibilityMasterActionURL }" name="fm" method="post">
										<div id="edu_detail_area">
											<div class="omsb-card edu_detail element " id="edu_detail" >
												<div class="omsb-list-filter">
													<div class="row ">
														<div class="col-lg-6 col-md-6">
															<aui:input cssClass="form-control" label="exam-type" localized="true" type="text" name="ExamTypeEligibilityValue" id="examTypeEntry" value="">
																<aui:validator name="required" />
															</aui:input>
					
														</div>
		
														<div class="col-lg-6 col-md-6">
															<div class="bottom-backbtn-wrap">
																<button class="btn omsb-bc-red-button" onClick="clearForm()"
																	type="button" title="<liferay-ui:message key='clear'/>">
																	<liferay-ui:message key="clear" />
																</button>
																<button class="btn omsb-bg-red-button " type="submit"
																						id="save-btn">
																	<liferay-ui:message key="add" />
																</button>
																<button class="btn omsb-bg-red-button mx-1 d-none" type="button"
																						id="update-btn" onclick="UpdateExamType()">
																	<liferay-ui:message key="update" />
																</button>
																<portlet:renderURL var="OCTHomeURL">
																	<portlet:param name="mvcRenderCommandName" value="/" />
																</portlet:renderURL>
																<a class="btn omsb-btn btn-back" href="${OCTHomeURL }"><i
																	class="fi fi-sr-arrow-left"></i> <liferay-ui:message
																		key="back" /></a>
															</div>
														</div>
													</div>
												</div>
												<h5 id="errorContainer-educational-detail" class="error-container"></h5> 
											</div>
										</div>
											
										 <div id="listOctExamTitle">
											
													<table class="display omsb-datatables exam-type-pl" id="exam-title-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="exam-type" /></th>
																<th><liferay-ui:message key="actions" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="examTypeListEntries" items="${examTypeListEntries}">
															<tr id="${examTypeListEntries.listTypeEntryId }">
																<td>${examTypeListEntries.getName(themeDisplay.getLocale())}</td>
																 <td><button class="btn delete_btn" value="Delete"
																		type="button" data-toggle="modal" data-target="#delete-exam-typePL"
																		onclick="delelteExamTypeEntryId('${examTypeListEntries.listTypeEntryId}')">
																		<img
																			src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg"
																			style="cursor: default;">
																	</button>
																	<%-- <a  onclick="editExamType('${examTypeListEntries.listTypeEntryId}')" class="btn mx-2" href="#" >
																	<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></a> --%>
																	<a class="btn mx-2" href="#" onclick="editExamType('${examTypeListEntries.getName(themeDisplay.getLocale())}', '${examTypeListEntries.listTypeEntryId}')">
   													 <img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></a>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div> 
									<input type="hidden" value="" name="deleteID" id="deleteID"/>
									<input type="hidden" value="" name="examTypePrimaryID" id="examTypePrimaryID"/>
							</aui:form>
						</div>
					</div>
				</div>
					
		<!--delete popup for Exam title -->
		<div class="modal fade omsb-modal" id="delete-exam-typePL" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>examTypeEntryId' id="examTypeEntryId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setExamTypeEntryID()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->

		<portlet:resourceURL id="<%=MVCCommandNames.DELETE_OMSB_EXAM_SPECIALITY_MASTER_DETAILS%>" var="deleteExamSpecialityMasterDetailsURL" />					
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
	
	function setExamEligibilityName(){
		var examTypeValue=$('#<portlet:namespace />examTypeValue').val();
		console.log("examTypeValue"+examTypeValue)
		$.ajax({
			url: '${examEligibilityListURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />examTypeValue : examTypeValue,
			},
			type : 'POST',
			success : function(data) {
	            var examEligibility = data;
	            console.log("examEligibility::"+examEligibility)
	            $('#<portlet:namespace />ExamEligibilityValue').empty();
	            $('#<portlet:namespace />ExamEligibilityValue').append("<option value=''><liferay-ui:message key="select"/></option> ");
	            $.each(examEligibility, function (i, item) {
	            	   $('#<portlet:namespace />ExamEligibilityValue').append("<option value='" + item.examEligibility + "'>" + item.examEligibilityName + "</option> ");

	            })
	            },
		})
	}
	
	$('.exam-type-pl').DataTable({
	    "bLengthChange": false,
	    "bFilter": false
	    });
	
	
	 function delelteExamTypeEntryId(id){
			console.log("this is  examTypeEntryId"+id)
			var inputElement = document.getElementById("examTypeEntryId"); // Set the value of the input 
			$('#examTypeEntryId').val(id);
		}

		function setExamTypeEntryID(){
			var examTypeEntryId = $('#examTypeEntryId').val();
			$.ajax({
				url: '${examTypePLListDeleteURL}',
				async : false,
				dataType:"json",
				data : {
					<portlet:namespace />examTypeEntryId : examTypeEntryId,
				},
				type : 'POST',
				success : function(data) {
					location.reload(true);
		            },
			})
			
		} 
		
		
		
		function editExamType(examType, listTypeEntryId) {
		   
		    var listTypeEntryId = listTypeEntryId;
		    var examType = examType;
		    console.log("Edit exam type: " + examType);
		    console.log("List Type Entry ID: " + listTypeEntryId);
		    var oldValue = $('#<portlet:namespace />examTypeEntry').val(examType);
		     $('#examTypePrimaryID').val(listTypeEntryId);
//			 $('#save-btn').addClass('d-none');
			 $('#update-btn').removeClass('d-none');
		     
		    
		}
		function UpdateExamType(){
			var examTypePrimaryID = $('#examTypePrimaryID').val();
			var newValue = $('#<portlet:namespace />examTypeEntry').val();
			 console.log("examTypePrimaryID: " + examTypePrimaryID);
			    console.log("newValue: " + newValue);
			    $.ajax({
					url: '${editExamTypePLListURL}',
					async : false,
					dataType:"json",
					data : {
						<portlet:namespace />examTypePrimaryID : examTypePrimaryID,
						<portlet:namespace />newValue : newValue,
					},
					type : 'POST',
					success : function(data) {
						location.reload(true);
			            },
				})
			    
			    
			
			
		}
		
		
	
	</script>