<%@ include file="../../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-ui:error key="setSpecialityMappingFormError" message="speciality-mapping-error" />

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_SPECIALITY_MAPPING_MVC_ACTION_COMMAND%>"
	var="saveSpecialityMappingActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.SPECIALITY_DELETE_RESOURCE_COMMAND%>" var="specialityMappingDeleteURL" />

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				<div class="omsb-page-top-info mb-0">
					<div class="omsb-page-top-info">
						<h3 class="reg-form-title">
							<liferay-ui:message key="speciality-mapping" />
						</h3>
					</div>
				</div>
				<aui:form action="${saveSpecialityMappingActionURL}" name="fm"
					method="post">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control"
									label="speciality" id="speciality" name="speciality"
									onchange="getSubSpecialityDetails(this.value);">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-speciality" />
									</aui:option>
									<c:forEach items="${listOmsbSpeciality}"
										var="listOmsbSpeciality">
										<c:choose>
											<c:when test="${themeDisplay.getLocale() =='en_US'}">
												<aui:option value="${listOmsbSpeciality.id}">${listOmsbSpeciality.nameEnglish}</aui:option>
											</c:when>
											<c:otherwise>
												<aui:option value="${listOmsbSpeciality.id}">${listOmsbSpeciality.nameArabic}</aui:option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="sub-speciality" /></label> <select
									cssClass="custom-select form-control" label="sub-speciality"
									name="<portlet:namespace/>siSectionId" id="specialityMappingId"
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
									name="specialityMappingValue" localized="true">
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
							<table class="display omsb-datatables speciality-table-list"
								 width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="speciality" /></th>
										<th><liferay-ui:message key="sub-speciality" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="omsbSpecialityMappings" items="${omsbSpecialityMappings}">
										<tr id="${omsbSpecialityMappings.id}">
											<td>${omsbSpecialityMappings.specialityName}</td>
											<td>${omsbSpecialityMappings.subSpecialityName}</td>
											<td><button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete_row"
													onclick="delelte('${omsbSpecialityMappings.id}')"
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
		<div class="modal fade omsb-modal" id="delete_row" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>specialityprimaryId' id="specialityprimaryId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeletespecialityprimaryIdID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>

<portlet:resourceURL
	id="<%=MVCCommandNames.GET_SUB_SPECIALITY_DETAILS%>"
	var="getSubSpecialityDetailsURL" />

<script>
function getSubSpecialityDetails(speciality){
	$.ajax({
		url: '<%=getSubSpecialityDetailsURL%>',
		type : 'GET',
		data : {
			"<portlet:namespace />speciality" : speciality,
		},
		success : function(response) {
			var data = JSON.parse(response);
			var subSpecialityArray = JSON.parse(data.subSpeciality);
			var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
			// Iterating through the array using a for loop
			if(subSpecialityArray != null) {
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
				$("#specialityMappingId").html(sectionData);
			}else {
				$("#specialityMappingId").empty().html(sectionData); 
			}
		},
	});
}

function delelte(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("specialityprimaryId"); // Set the value of the input 
	$('#specialityprimaryId').val(id);
}

 function setDeletespecialityprimaryIdID(){
	var specialityprimaryId = $('#specialityprimaryId').val();
	console.log("specialityprimaryId "+specialityprimaryId)
	$.ajax({
		url: '${specialityMappingDeleteURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />specialityprimaryId : specialityprimaryId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
}  
</script>

