<%@page import="gov.omsb.master.web.constants.MVCCommandNames"%>
<%@ include file="../../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-ui:error key="setInstitutionMasterFormError"
	message="institution-master-error" />

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_INSTITUTION_MASTER_MVC_ACTION_COMMAND%>"
	var="saveInstitutionMasterActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.INSTITUTION_DELETE_RESOURCE_COMMAND%>" var="institutionMappingDeleteURL" />

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				<div class="omsb-page-top-info mb-0">
					<div class="omsb-page-top-info">
						<h3 class="reg-form-title">
							<liferay-ui:message key="institution-master" />
						</h3>
					</div>
				</div>
				<aui:form action="${saveInstitutionMasterActionURL}" name="fm"
					method="post">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control"
									label="country" id="country" name="country"
									onchange="getInstitutionDetails(this.value);">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-country" />
									</aui:option>
									<c:forEach items="${countries}" var="country">
 										 <aui:option value="${country.countryId}">${country.getName(themeDisplay.getLocale())}</aui:option> 
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="institution" /></label> <select
									cssClass="custom-select form-control" label="sub-speciality"
									name="<portlet:namespace/>siSectionId" id="institutionId"
									class="form-control">
									<option value=""><liferay-ui:message key="select" /></option>
									<c:forEach var="section" items="${sectionList}">
										<option value="${section.getKey()}">
											<liferay-ui:message
												key="${section.getName(themeDisplay.getLocale())}" />
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input cssClass="form-control" label="value" type="text"
									name="institutionValue" localized="true">
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
						
						 <div id="listOfSpeciality" class="col-12">
							<table class="display omsb-datatables institution-table-list"
								 width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="country" /></th>
										<th><liferay-ui:message key="institution" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="institutionMappings" items="${institutionMappings}">
										<tr id="${institutionMappings.id }">
											<td>${institutionMappings.countryName}</td>
											<td>${institutionMappings.universityName}</td>
											<td><button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete_row_1"
													onclick="delelteId('${institutionMappings.id}')"
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

<!--delete popup  -->
		<div class="modal fade omsb-modal" id="delete_row_1" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>primaryinstitutionMappingsId' id="primaryinstitutionMappingsId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>

<portlet:resourceURL
	id="<%=MVCCommandNames.GET_UNIVERSITY_DETAILS%>"
	var="getUniversityDetailsURL" />

<script>

$('.institution-table-list').DataTable({
	"bLengthChange": false,
	"bFilter": false,
	"ordering": false
});

function getInstitutionDetails(country){
	$.ajax({
		url: '<%=getUniversityDetailsURL%>',
		type : 'GET',
		data : {
			"<portlet:namespace />country" : country,
		},
		success : function(response) {
			var data = JSON.parse(response);
			var subSpecialityArray = JSON.parse(data.university);
			var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
			// Iterating through the array using a for loop
			if(subSpecialityArray != null) {
				console.log("in if ==> ");
			for (var i = 0; i < subSpecialityArray.length; i++) {
				var item = subSpecialityArray[i];
				var id = item.id;

				if (themeDisplay.getLanguageId() == 'en_US') {
					sectionData += "<option value='" + id + "'>"
							+ item.nameEnglish + "</option>";
				} else {
					sectionData += "<option value='" + id + "'>"
							+ item.nameArabic + "</option>";
				}
				
			}
			$("#institutionId").html(sectionData);
			} else {
				$("#institutionId").empty().html(sectionData); 
			}
		},
	});
}

function delelteId(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("primaryinstitutionMappingsId"); // Set the value of the input 
	$('#primaryinstitutionMappingsId').val(id);
}

function setDeleteID(){
	var primId = $('#primaryinstitutionMappingsId').val();
	$.ajax({
		url: '${institutionMappingDeleteURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />primId : primId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
} 
</script>