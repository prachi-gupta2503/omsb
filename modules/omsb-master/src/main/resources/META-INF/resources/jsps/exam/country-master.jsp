<%@ include file="../../init.jsp"%>

<portlet:actionURL
	name="<%=MVCCommandNames.SAVE_COUNTRY_MAPPING_MVC_ACTION_COMMAND%>"
	var="saveCountryMappingActionURL">
</portlet:actionURL>

<portlet:resourceURL id="<%=MVCCommandNames.COUNTRY_DELETE_RESOURCE_COMMAND%>" var="countryDeleteURL" />


<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				<aui:form action="${saveCountryMappingActionURL}" name="fm"
					method="post">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input cssClass="form-control" label="country-value" type="text"
									name="countryValue">
									<aui:validator name="required" />
								</aui:input>

							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control"
									label="country" id="country" name="country" >
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-country" />
									</aui:option>
									<c:forEach items="${countries}" var="country">
 										 <aui:option value="${country.name}">${country.getName(themeDisplay.getLocale())}</aui:option> 
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
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
							<table class="display omsb-datatables country-table-list"
								 width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="country" /></th>
										<th><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="countriesList" items="${countriesList}">
										<tr id="${countriesList.countryId }"> 
											<td>${countriesList.getName(themeDisplay.getLocale())}</td>
											 <td><button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete_row_Country"
													onclick="delelteCountryId('${countriesList.countryId}')"
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

<div class="modal fade omsb-modal" id="delete_row_Country" tabindex="-1" role="dialog"
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
					<input type="hidden" name='<portlet:namespace/>primaryCountryId' id="primaryCountryId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteCountryID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>

<script>
$('.country-table-list').DataTable({
	"bLengthChange": false,
	"bFilter": false,
	"ordering": false
});

function delelteCountryId(id){
	console.log("this is primary Id"+id)
	var inputElement = document.getElementById("primaryCountryId"); // Set the value of the input 
	$('#primaryCountryId').val(id);
}

function setDeleteCountryID(){
	var primaryCountryId = $('#primaryCountryId').val();
	$.ajax({
		url: '${countryDeleteURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />primaryCountryId : primaryCountryId,
		},
		type : 'POST',
		success : function(data) {
			location.reload(true);
            },
	})
	
}


</script>