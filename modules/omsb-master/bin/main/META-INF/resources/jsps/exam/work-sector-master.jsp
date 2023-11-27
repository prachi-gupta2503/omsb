<%@ include file="../../init.jsp"%>

 <portlet:actionURL
	name="<%=MVCCommandNames.SAVE_WORK_SECTOR_MASTER_MVC_ACTION_COMMAND%>"
	var="saveWorkSectorMasterActionURL">
</portlet:actionURL> 

<portlet:resourceURL id="<%=MVCCommandNames.WORK_SECTOR_TYPE_RESOURCE_COMMAND%>" var="workSectorListURL" />	

<portlet:resourceURL id="<%=MVCCommandNames.WORK_SECTOR_TYPE_PARENT_RESOURCE_COMMAND%>" var="workSectorParentListURL" />

<%-- <portlet:resourceURL id="<%=MVCCommandNames.WORK_SECTOR_DELETE_RESOURCE_COMMAND%>" var="workSectorDeleteURL" />	 --%>

<portlet:resourceURL id="<%=MVCCommandNames.WORK_SECTOR_TYPE_PARENT_ID_1_RESOURCE_COMMAND%>" var="workSectorParentList1URL" />	

<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				
				<aui:form action="${saveWorkSectorMasterActionURL }" name="fm"
					method="post">
					<div class="row">

						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label>workSectorType</label> <select
									name="<portlet:namespace/>workSectorType" id="workSectorType"
									class="form-control" label="workSectorType"
									onchange="setWorkSectorName()">
									<option value=""><liferay-ui:message key="select" /></option>
									<c:forEach var="workSectorType" items="${workSectorTypeList}">
										<option value="${workSectorType.getListTypeEntryId()}">
											<liferay-ui:message
												key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label>workSectorTypeName</label> <select
									name="<portlet:namespace/>workSectorTypeNameId"
									id="workSectorTypeName" class="form-control" onchange="setWorkparentId()">
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label></label> 
								<select
									name="<portlet:namespace/>workSectorTypeParentId"
									id="workSectorTypeParentId" class="form-control" onchange="setWorkSectorParentId_1()">
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label></label> 
								<select
									name="<portlet:namespace/>workSectorTypeParentId_1"
									id="workSectorTypeParentId_1" class="form-control" >
									<option value=""><liferay-ui:message key="select" /></option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="form-group">
								<label><liferay-ui:message key="value" /></label> 
								<input class="form-control" name="<portlet:namespace/>workSectorValue" value="" id="value">
							</div>
						</div>
					</div>

					<div class="row">
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
					<input type="hidden" name='<portlet:namespace/>primaryId' id="primaryId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>

<script>
	
function setWorkSectorName(){

	var workSectorType=$('#workSectorType').val();
	console.log("workSectorType"+workSectorType)
	$.ajax({
		url: '${workSectorListURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />workSectorType : workSectorType,
		},
		type : 'POST',
		success : function(data) {
            var workSector = data;
            console.log("workSector::"+workSector)
            $('#workSectorTypeName').empty();
            $('#workSectorTypeName').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(workSector, function (i, item) {
            	 
            	   $('#workSectorTypeName').append("<option value='" + item.workSectorId + "'>" + item.workSector + "</option> ");

            })
            },
	})
}

function setWorkparentId(){

	var workSectorTypeParentId=$('#workSectorTypeParentId').val();
	var workSectorTypeName=$('#workSectorTypeName').val();
	$.ajax({
		url: '${workSectorParentListURL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />workSectorTypeName : workSectorTypeName,
		},
		type : 'POST',
		success : function(data) {
            var workSectorParent = data;
            console.log("workSectorParent::",workSectorParent)
            $('#workSectorTypeParentId').empty();
            $('#workSectorTypeParentId').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(workSectorParent, function (i, item) {
            	   $('#workSectorTypeParentId').append("<option value='" + item.workSectorId + "'>" + item.workSectorParent + "</option> ");

            })
            },
	})
}

function setWorkSectorParentId_1(){

	var workSectorTypeParentId=$('#workSectorTypeParentId').val();
	console.log("workSectorTypeParentId   :::"+workSectorTypeParentId)
	$.ajax({
		url: '${workSectorParentList1URL}',
		async : false,
		dataType:"json",
		data : {
			<portlet:namespace />workSectorTypeParentId : workSectorTypeParentId,
		},
		type : 'POST',
		success : function(data) {
            var workSectorParent = data;
            console.log("workSectorParent::",workSectorParent)
            $('#workSectorTypeParentId_1').empty();
            $('#workSectorTypeParentId_1').append("<option value=''><liferay-ui:message key="select"/></option> ");
            $.each(workSectorParent, function (i, item) {
            	   $('#workSectorTypeParentId_1').append("<option value='" + item.workSectorId + "'>" + item.workSectorParent + "</option> ");

            })
            },
	})
}

/* function delelte(id){
	var inputElement = document.getElementById("primaryId"); // Set the value of the input 
	$('#primaryId').val(id);
}
function setDeleteID(){
	var primId = $('#primaryId').val();
	$.ajax({
		url: '${workSectorDeleteURL}',
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
	
} */




</script>