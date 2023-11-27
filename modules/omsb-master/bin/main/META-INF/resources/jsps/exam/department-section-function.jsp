<%@ include file="../../init.jsp"%>

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_SECTION_MAPPING_MVC_ACTION_COMMAND%>"
	var="saveSectionMappingActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.DEPARMENT_SECTION_RESOURCE_COMMAND%>" var="departmentSectionListURL" />
<portlet:resourceURL id="<%=MVCCommandNames.SECTION_RESOURCE_COMMAND%>" var="SectionFunctionListURL" />
<portlet:resourceURL id="<%=MVCCommandNames.COMMITTE_FUNCTION_RESOURCE_COMMAND%>" var="FunctionCommitteeListURL" />
<portlet:resourceURL id="<%=MVCCommandNames.FUNCTION_SECTION_DEPARTMENT_DELETE_RESOURCE_COMMAND%>" var="FunctionCommitteeDeleteListURL" />


<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			 <div class="omsb-card">
				 <aui:form action="${saveSectionMappingActionURL}" name="fm"
					method="post"> 
					<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="form-group">
								<label><liferay-ui:message key="department" /></label>
								<select name='<portlet:namespace/>department' id="departmentId" onchange="setDepartmentSectionMapping()" class="custom-select form-control">
									<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="departmentEntries" items="${departmentEntries}">
											<option value="${departmentEntries.getKey()}">
												<liferay-ui:message
													key="${departmentEntries.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label><liferay-ui:message key="section" /></label> 
									<select class="custom-select form-control" label="section" name="<portlet:namespace/>section" id="sectionId"
										 onchange="setSectionFunction()">
										<option value=""><liferay-ui:message key="select" /></option>
									</select>
							</div>
						</div>
					 	<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label><liferay-ui:message key="function" /></label> <select
									class="custom-select form-control" label="function"
									name="<portlet:namespace/>function" id="functionId"
									class="form-control" onchange="setFunctionCommittee()" >
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label><liferay-ui:message key="committee" /></label> <select
									class="custom-select form-control" label="committee"
									name="<portlet:namespace/>committee" id="committeeId"
									class="form-control">
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<aui:input cssClass="form-control" label="function-value" type="text"
									name="functionValue" localized="true">
								</aui:input>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<aui:input cssClass="form-control" label="committe-value" type="text"
									name="committeValue" localized="true">
								</aui:input>

							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<div class="bottom-backbtn-wrap m-0">
									<button class="btn omsb-bc-red-button" type="submit"
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
						
						<div id="listOfCountry" class="col-12">
							<table class="display omsb-datatables function-table-list"
								 width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="section" /></th>
										<th><liferay-ui:message key="function" /></th>
										<th><liferay-ui:message key="committee" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="sectionFunctions" items="${sectionFunctions}">
										<tr id="${sectionFunctions.id }"> 
											<td>${sectionFunctions.sectionId}</td>
											<td>${sectionFunctions.functionId}</td>
											<td>${sectionFunctions.committeeId}</td>
											 <td><button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete-rowFunction"
													onclick="delelteFunctionId('${sectionFunctions.id}')"
													data-rowcount="addPopUpRow">
													<img
														src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg"
														style="cursor: default;">
												</button></td>	
										</tr>
									</c:forEach>
								</tbody>
							</table> 
						</div>
					</div>
			</aui:form>
			</div>
		</div>
	</div>
 </div>
 
 
 <div class="modal fade omsb-modal" id="delete-rowFunction" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>primarySectionFunctionId' id="primarySectionFunctionId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteSectionID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
 
 
 <script>
 
 
 $('.function-table-list').DataTable({
		"bLengthChange": false,
		"bFilter": false,
		"ordering": false
	}); 
 function setDepartmentSectionMapping(){
		console.log("department-Section-Function-page");
		var department=$('#departmentId').val();
		console.log("department"+department)
		$.ajax({
			url: '${departmentSectionListURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />department : department,
			},
			type : 'POST',
			success : function(data) {
	            var section = data;
	            console.log("section::"+section)
	            $('#sectionId').empty();
	            $('#sectionId').append("<option value=''><liferay-ui:message key="select"/></option> ");
	            $.each(section, function (i, item) {
	              $('#sectionId').append("<option value='" + item.sectionKey + "'>" + item.sectionId + "</option> ");
	            })
	            },
		})
	}
 
 
 
 
function setSectionFunction(){

	var section=$('#sectionId').val();
	console.log("section"+section)
	$.ajax({
		url: '${SectionFunctionListURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />section : section,
		},
		type : 'POST',
		success : function(data) {
            var functionId = data;
            console.log("functionId::"+functionId)
            $('#functionId').empty();
            $('#functionId').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(functionId, function (i, item) {
              $('#functionId').append("<option value='" + item.functionkey + "'>" + item.functionId + "</option> ");
            })
            },
	})
}

function setFunctionCommittee(){

	var functionId=$('#functionId').val();
	console.log("functionId"+functionId)
	$.ajax({
		url: '${FunctionCommitteeListURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />functionId : functionId,
		},
		type : 'POST',
		success : function(data) {
            var committee = data;
            console.log("functionId::"+functionId)
            $('#committeeId').empty();
            $('#committeeId').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(committee, function (i, item) {
             $('#committeeId').append("<option value='" + item.committeeKey + "'>" + item.committeeId + "</option> ");
            })
            },
	})
}

function delelteFunctionId(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("primarySectionFunctionId"); // Set the value of the input 
	$('#primarySectionFunctionId').val(id);
}

function setDeleteSectionID(){
	var primarySectionFunctionId = $('#primarySectionFunctionId').val();
	$.ajax({
		url: '${FunctionCommitteeDeleteListURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />primarySectionFunctionId : primarySectionFunctionId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
} 


</script>