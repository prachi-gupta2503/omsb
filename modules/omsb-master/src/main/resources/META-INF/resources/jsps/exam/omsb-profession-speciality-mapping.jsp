<%@ include file="../../init.jsp"%>

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_PROFESSION_SPECIALITY_MAPPING_MVC_ACTION_COMMAND%>"
	var="saveProfessionSpecialityMappingActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.PROFESSION_PRI_SPECILAITY_RESOURCE_COMMAND%>" var="professionSpecialituListURL" />


<portlet:resourceURL id="<%=MVCCommandNames.PROFESSION_SPECIALITY_DELETE_RESOURCE_COMMAND%>" var="professionSpecialityDeleteURL" />

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			 <div class="omsb-card">
				 <aui:form action="${saveProfessionSpecialityMappingActionURL}" name="fm"
					method="post"> 
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="profession" /></label>
								<select name='<portlet:namespace/>profession' id="profession" onchange="setprofessionPriSpeciality()" class="custom-select form-control">
									<option value=""><liferay-ui:message key="select" /></option>
									<c:forEach var="professionEntries" items="${professionEntries}">
										<option value="${professionEntries.getListTypeEntryId()}">
											<liferay-ui:message
												key="${professionEntries.getName(themeDisplay.getLocale())}" />
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					 	<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="primary-speciality" /></label> <select
									class="custom-select form-control" label="primary-speciality"
									name="<portlet:namespace/>primarySpeciality" id="primarySpeciality"
									class="form-control">
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input cssClass="form-control" label="value" type="text"
									name="priSpecialityValue" localized="true">
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
							<table class="display omsb-datatables profession-table-list"
								 width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="profession" /></th>
										<th><liferay-ui:message key="speciality" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="omsbProfessionSpecialities" items="${omsbProfessionSpecialities}">
										<tr id="${omsbProfessionSpecialities.id }">
											<td>${omsbProfessionSpecialities.professionName}</td>
											<td>${omsbProfessionSpecialities.specialityName}</td>
											<td><button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete_row_Proffesion"
													onclick="delelteSpecialityProfessionId('${omsbProfessionSpecialities.id}')"
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

		<div class="modal fade omsb-modal" id="delete_row_Proffesion" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>primaryProfessionSpecialityId' id="primaryProfessionSpecialityId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteProfessionSpecialityID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>



<script type="text/javascript">
function setprofessionPriSpeciality(){

	var profession=$('#profession').val();
	console.log("profession"+profession)
	$.ajax({
		url: '${professionSpecialituListURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />profession : profession,
		},
		type : 'POST',
		success : function(data) {
            var speciality = data;
            console.log("speciality::"+speciality)
            $('#primarySpeciality').empty();
            $('#primarySpeciality').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(speciality, function (i, item) {
            	 
            	   $('#primarySpeciality').append("<option value='" + item.speciality + "'>" + item.speciality + "</option> ");

            })
            },
	})
}

$('.profession-table-list').DataTable({
	"bLengthChange": false,
	"bFilter": false,
	"ordering": false
});

function delelteSpecialityProfessionId(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("primaryProfessionSpecialityId"); // Set the value of the input 
	$('#primaryProfessionSpecialityId').val(id);
}

function setDeleteProfessionSpecialityID(){
	var primaryProfessionSpecialityId = $('#primaryProfessionSpecialityId').val();
	$.ajax({
		url: '${professionSpecialityDeleteURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />primaryProfessionSpecialityId : primaryProfessionSpecialityId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
} 



</script>
