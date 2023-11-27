 <%@ include file="../../init.jsp"%>	

<portlet:actionURL name="<%= MVCCommandNames.SAVE_PROGRAM_TYPE_MASTER_MVC_ACTION_COMMAND %>" var="saveExamTypeProgramMasterActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.PROGRAM_EXAM_TYPE_RESOURCES_COMMAND%>" var="examProgramTypeListURL" />	
<portlet:resourceURL id="<%=MVCCommandNames.DELETE_EXAM_TYPE_MVC_RESOURCE_COMMAND%>" var="examProgramTypeDeleteURL" />

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				<aui:form action="${saveExamTypeProgramMasterActionURL }" name="fm"
					method="post">
					<div id="edu_detail_area">
						<div class="omsb-card edu_detail element " id="edu_detail">
							<div class="omsb-list-filter">
								<div class="row ">
									<div class="col-lg-6 col-md-6">
										<aui:select label="program-type" name="programType"
											onChange="setExamProgramName()">
											<aui:validator name="required" />
											<aui:option value="">
												<liferay-ui:message key="select"></liferay-ui:message>
											</aui:option>
											<c:forEach var="programTypeList" items="${ProgramTypeList}">
												<option value="${programTypeList.programTypeMasterId}">
													<liferay-ui:message
														key="${programTypeList.programTypeName}" />
												</option>
											</c:forEach>
										</aui:select>
									</div>



									<div class="col-lg-6 col-md-6">
										<aui:select name="examTypeProgramValue" label="exam-type"
											id="examTypeProgramValue">
											<aui:option value="">
												<liferay-ui:message key="select" />
											</aui:option>
										</aui:select>
									</div>


									<div class="col-lg-6 col-md-6 col-sm-12">
										<div class="form-group">
											<label><liferay-ui:message key="exam-type-pl" /></label> <select
												name='<portlet:namespace/>examTypePL' id="examType"
												class="custom-select form-control">
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="examTypeEntries" items="${examTypeEntries}">
													<option value="${examTypeEntries.getKey()}">
														<liferay-ui:message
															key="${examTypeEntries.getName(themeDisplay.getLocale())}" />
													</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="col-lg-6 col-md-6">
										<div class="bottom-backbtn-wrap">
											<button class="btn omsb-bc-red-button" onClick="clearForm()"
												type="button" title="<liferay-ui:message key='clear'/>">
												<liferay-ui:message key="clear" />
											</button>
											<button class="btn omsb-bg-red-button" type="submit"
												id="add_edu_detail">
												<liferay-ui:message key="add" />
											</button>
											<portlet:renderURL var="OCTHomeURL">
												<portlet:param name="mvcRenderCommandName" value="/" />
											</portlet:renderURL>
											<a class="btn omsb-btn btn-back" href="${OCTHomeURL }"><i
												class="fi fi-sr-arrow-left"></i> <liferay-ui:message
													key="back" /></a>
										</div>
									</div>

									<c:if test="${not empty programExamTypes}">
										<div class="omsb-list-view table-responsive"
											id="examtypeEligibility-list">
											<table
												class="display omsb-datatables programexamtype-list-table">
												<thead>
													<tr>
														<th><liferay-ui:message key="program-type" /></th>
														<th><liferay-ui:message key="exam-type" /></th>
														<th><liferay-ui:message key="action" /></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="programExamType"
														items="${programExamTypes}">
														<tr id="${programExamType.id }">
															<td>${programExamType.programTypeName }</td>
															<td>${programExamType.examTypeName}</td>
															<td><button class="btn delete_btn" value="Delete"
																	type="button" data-toggle="modal"
																	data-target="#delete-row_examType"
																	onclick="delelteExamTypeId('${programExamType.id}')">
																	<img
																		src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg"
																		style="cursor: default;">
																</button></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>



<div class="modal fade omsb-modal" id="delete-row_examType" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>primaryExamTypeId' id="primaryExamTypeId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setExamTypeID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
					
		
		<script>
	function setExamProgramName(){
		var programType=$('#<portlet:namespace />programType').val();
		console.log("programType"+programType)
		$.ajax({
			url: '${examProgramTypeListURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />programType : programType,
			},
			type : 'POST',
			success : function(data) {
	            var examType = data;
	            console.log("examType::"+examType)
	            $('#<portlet:namespace />examTypeProgramValue').empty();
	            $('#<portlet:namespace />examTypeProgramValue').append("<option value=''><liferay-ui:message key="select"/></option> ");
	            $.each(examType, function (i, item) {
	            	   $('#<portlet:namespace />examTypeProgramValue').append("<option value='" + item.examType + "'>" + item.examTypeName + "</option> ");

	            })
	            },
		})
	}
	
	$('.programexamtype-list-table').DataTable({
	    "bLengthChange": false,
	    "bFilter": false
	    });
	
	
	 function delelteExamTypeId(id){
			console.log("this is  Id"+id)
			var inputElement = document.getElementById("primaryExamTypeId"); // Set the value of the input 
			$('#primaryExamTypeId').val(id);
		}

		function setExamTypeID(){
			var primaryExamTypeId = $('#primaryExamTypeId').val();
			$.ajax({
				url: '${examProgramTypeDeleteURL}',
				async : false,
				dataType:"json",
				data : {
					<portlet:namespace />primaryExamTypeId : primaryExamTypeId,
				},
				type : 'POST',
				success : function(data) {
					location.reload(true);
		            },
			})
			
		} 
	
	</script> 