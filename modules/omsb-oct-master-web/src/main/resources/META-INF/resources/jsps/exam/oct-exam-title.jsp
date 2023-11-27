<%@ include file="../../init.jsp"%>	
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:actionURL name="<%= MVCCommandNames.UPDATE_EXAM_TITLE_MVC_ACTION_COMMAND %>" var="updateExamTitleActionURL">
	<portlet:param name="redirect" value="<%=MVCCommandNames.OCT_NEW_EXAM_TITLE_RENDER%>" />
	<portlet:param name="titleId" value="${titleId}"/>
	<portlet:param name="objectId" value="${id}"/>
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.EDIT_NEW_EXAM_TITLE%>" var="editExamTitleDetailsURL" />

		<div class="omsb-main-wrapper" id="omsb-main-wrapper">
			<div id="wrapper">
				<div class="container">
					<div class="omsb-card ">
									<aui:form action="${updateExamTitleActionURL}" name="examTitle" method="post">
										<div id="edu_detail_area">
										<div class="omsb-card edu_detail element " id="edu_detail" >
											<div class="omsb-list-filter">
											<div class="row ">
												<div class="col-lg-6 col-md-6 col-sm-12">
													<div class="form-group">
													
													<aui:input cssClass="form-control" label="exam-title-details" id="titleValue" type="text" name="titleValue" localized="true" value="">
															<aui:validator name="required" />
															</aui:input>
													</div>
												</div>
												
												<div class="col-lg-6 col-md-6 col-sm-12">
													<div class="form-group">
													<aui:input id="examCode" cssClass="form-control" label="exam-code" type="text" name="examCode" value="${code}">
																<aui:validator name="required" />
															</aui:input>
													</div>
												</div>
												
												
															
													<div class="col-12">
													 <div class="bottom-backbtn-wrap">
														<%-- <button class="btn omsb-bc-red-button" onClick="clearForm()" type="button" title="<liferay-ui:message key='clear'/>"><liferay-ui:message key="clear"/></button> --%>
														<button class="btn omsb-bg-red-button mx-2" title="Save" type="submit" id="add_edu_detail"><liferay-ui:message key="save"/></button>
														<button onclick="updateExamTittle()" class="btn omsb-bg-red-button d-none" type="button" id="update-btn"><liferay-ui:message key="update"/></button>
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
											
													<table class="display omsb-datatables" id="exam-title-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="exam-title-english" /></th>
																<%-- <th><liferay-ui:message key="exam-title-arabic" /></th> --%>
																<th><liferay-ui:message key="exam-code" /></th>
																<th hidden=""><liferay-ui:message key="exam-code-id" /></th>
																<th><liferay-ui:message key="actions" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="entry" items="${listOctExamTitle}">
															<tr id="entry_${entry.id}">
																<td>${entry.nameEnglish}</td>
																<%-- <td>${entry.nameArabic}</td> --%>
																<td>${entry.examCode}</td>
																<td hidden="">${entry.octNewExamTitleId}</td>
																 <td>
																 	<portlet:renderURL var="newExamTitle">
																		<portlet:param name="mvcRenderCommandName"
																			value="<%=MVCCommandNames.OCT_NEW_EXAM_TITLE_RENDER%>" />
																		<portlet:param name="titleId" value="${entry.id}" />
																	</portlet:renderURL>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${entry.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<a onclick="editExamTitle('${entry.id}', '${entry.octNewExamTitleId}', '${entry.nameEnglish}', '${entry.examCode}')" class="btn mx-2" href="#" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></a>
																</td> 
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									<input type="hidden" value="" name="deleteID" id="deleteID"/>
									<input type="hidden" value="" name="picklistID" id="picklistID"/>
									<input type="hidden" value="" name="examCode" id="examTitlePrimaryID"/>
										
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
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteExamTitle()" title="<liferay-ui:message key='ok' />" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->
		
		<portlet:resourceURL id="<%=MVCCommandNames.SAVE_OCT_EXAM_TITLE_DETAILS_SR%>" var="saveExamTitleDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommandNames.DELETE_OCT_EXAM_TITLE_DETAILS%>" var="deleteExamTitleDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommandNames.GET_OCT_EXAM_TITLE_DETAILS%>" var="getExamTitleDetailsURL" />
		
								
	<script>	
	
	
	function deleteExamTitle(){
		var deleteId = document.getElementById("deleteID").value;
		console.log("deleteId"+deleteId)
		if(deleteId){
			$.ajax({
				url: '${deleteExamTitleDetailsURL}',
				async : false,
				data : {
					"<portlet:namespace />id" : deleteId,
				},
				type : 'POST',
				success : function(data) {
					$('#delete-education-confirm-modal').modal('hide');
					document.getElementById("<portlet:namespace />titleValue").value = "";
					$("#entry_"+deleteId).remove();
				},
			})
		}
	}
	
	function setDeleteID(id){
		document.getElementById("deleteID").value = id;
	}
	
	function clearForm(){
		document.getElementById("<portlet:namespace />titleValue").value = '';
		isEdit=false;
	}
	$('#exam-title-list').DataTable({
		"bLengthChange": false,
		"bFilter": false,
		"ordering": false
	});
	
	function editExamTitle(listtypeEntryId, OctTittleId,pickListValue, examCode){
		console.log("listtypeEntryId"+listtypeEntryId)
		console.log("OctTittleId"+OctTittleId)
		console.log("pickListValue"+pickListValue)
		console.log("examCode"+examCode)
		$('#<portlet:namespace />titleValue').val(pickListValue);
		var oldValueExamCode = $('#<portlet:namespace />examCode').val(examCode);
		 $('#picklistID').val(listtypeEntryId);
		 $('#examTitlePrimaryID').val(OctTittleId);
		 $('#update-btn').removeClass('d-none');
	
	}
	
	function updateExamTittle(){
		var picklistID = $('#picklistID').val();
		var examTitlePrimaryID = $('#examTitlePrimaryID').val();
		var newValueTitleValue = $('#<portlet:namespace />titleValue').val();
		var newValueExamCode = $('#<portlet:namespace />examCode').val();
		 console.log("picklistID: " + picklistID);
		 console.log("examTitlePrimaryID: " + examTitlePrimaryID);
		 console.log("newValueTitleValue: " + newValueTitleValue);
		 console.log("newValueExamCode: " + newValueExamCode);
	
			 $.ajax({
					url: '${editExamTitleDetailsURL}',
					async : false,
					dataType:"json",
					data : {
						<portlet:namespace />picklistID : picklistID,
						<portlet:namespace />examTitlePrimaryID : examTitlePrimaryID,
						<portlet:namespace />newValueTitleValue : newValueTitleValue,
						<portlet:namespace />newValueExamCode : newValueExamCode,
					},
					type : 'POST',
					success : function(data) {
						location.reload(true);
			            },
				})
				console.log("ajax ended")
	}
	
	</script>