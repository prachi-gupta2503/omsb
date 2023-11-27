<%@ include file="../../init.jsp"%>


<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_DEPARTMENT_SECTION_MAPPING_MVC_ACTION_COMMAND%>"
	var="saveDepartmentSectionMappingActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.DEPARMENT_SECTION_RESOURCE_COMMAND%>" var="departmentSectionListURL" />

<portlet:resourceURL id="<%=MVCCommandNames.SECTION_DEPARTMENT_DELETE_RESOURCE_COMMAND%>" var="departmentSectionListDeleteURL" />


<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			 <div class="omsb-card">
				 <aui:form action="${saveDepartmentSectionMappingActionURL}" name="fm"
					method="post"> 
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="department" /></label>
								<select name='<portlet:namespace/>department' id="department" onchange="setDepartmentSection()" class="custom-select form-control">
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
					 	<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="section" /></label> <select
									class="custom-select form-control" label="section"
									name="<portlet:namespace/>section" id="section"
									class="form-control">
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input cssClass="form-control" label="value" type="text"
									name="sectionValue" localized="true">
									<aui:validator name="required" />
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
							<table class="display omsb-datatables sectionDepartments-table-list"
								 width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="section" /></th>
										<th><liferay-ui:message key="deparment" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="sectionDepartments" items="${sectionDepartments}">
										<tr id="${sectionDepartments.id }"> 
											<td>${sectionDepartments.departmentId}</td>
											<td>${sectionDepartments.sectionId}</td>
											 <td><button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete-rowDepartment"
													onclick="delelteDepartmentId('${sectionDepartments.id}')"
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
 

		
		<div class="modal fade omsb-modal" id="delete-rowDepartment" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>primarySectionDepartmentId' id="primarySectionDepartmentId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteDepartmentSectionID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
 
<script>

 $('.sectionDepartments-table-list').DataTable({
	"bLengthChange": false,
	"bFilter": false,
	"ordering": false
}); 
function setDepartmentSection(){

	var department=$('#department').val();
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
            $('#section').empty();
            $('#section').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(section, function (i, item) {
            	 
            	   $('#section').append("<option value='" + item.sectionId + "'>" + item.sectionId + "</option> ");

            })
            },
	})
}

 function delelteDepartmentId(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("primarySectionDepartmentId"); // Set the value of the input 
	$('#primarySectionDepartmentId').val(id);
}

function setDeleteDepartmentSectionID(){
	var primarySectionDepartmentId = $('#primarySectionDepartmentId').val();
	$.ajax({
		url: '${departmentSectionListDeleteURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />primarySectionDepartmentId : primarySectionDepartmentId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
} 


</script>