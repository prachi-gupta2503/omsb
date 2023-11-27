<%@ include file="init.jsp" %>

<portlet:resourceURL id="/getCohortURL" var="getCohortURL" />
<portlet:resourceURL id="/getTrainingSiteURL" var="getTrainingSiteURL" />
<portlet:resourceURL id="/getRotationsURL" var="getRotations" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="siteCapacityTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="program-cohort" /></th>
					<th><liferay-ui:message key="training-site" /></th>
					<th><liferay-ui:message key="rotation" /></th>
					<th><liferay-ui:message key="slots" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allSiteCapacities}" var="siteCapacity"> 
			            <tr>
			            	<td>${programNameCohotMapping.get(siteCapacity.getCohortId())}</td>
			            	<td>${siteCapacity.getTrainingSite()}</td>
			                <td>${siteCapacity.getRotation()}</td>
			                <td>${siteCapacity.getNoOfSlots()}</td>
			                <td class="text-center" style="width:100px">
			                	<portlet:renderURL var="editSiteCapacity">
								    <portlet:param name="mvcRenderCommandName" value="<%=OmsbConfigureSiteCapacityWebPortletKeys.RENDER_EDIT_SITE_CAPACITY_MVC_COMMAND_NAME%>" />
								     <portlet:param name="progdurationRotationTsRelId" value="${siteCapacity.progdurationRotationTsRelId}" />
								</portlet:renderURL>
								
			                	<portlet:actionURL name="<%= OmsbConfigureSiteCapacityWebPortletKeys.DELETE_SITE_CAPACITY_MVC_COMMAND_NAME %>" var="deleteSiteCapacity">
									<portlet:param name="progdurationRotationTsRelId" value="${siteCapacity.progdurationRotationTsRelId}" />
								</portlet:actionURL> 
				            	<div class="dropdown ">
				            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
											type="button" data-toggle="dropdown" aria-expanded="false">
											<i class=""></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="${editSiteCapacity}" class="dropdown-item"><i
													class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
												</a>
											</li>
											<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${siteCapacity.progdurationRotationTsRelId}" data-id="${siteCapacity.progdurationRotationTsRelId}" data-target="#myModal" data-toggle="modal" >
													<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
												</a>
											</li>
										</ul>
								</div>
			            	</td>                  
			            </tr>
	        	</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/modal-popup.jsp" />
<script>
function getCohort(){
	let program = $("#<portlet:namespace/>selectProgram").val();
	$.ajax({
		url: '<%=getCohortURL%>',
		type: 'POST',
		data:{
				<portlet:namespace/>program: program
			},
		success: function(jsondata)	{
			$("#<portlet:namespace/>cohort").empty();
			$("#<portlet:namespace/>trainingSite").empty();
			$("#<portlet:namespace/>rotation").empty();
			$("#<portlet:namespace/>trainingSite").append("<option class='placeholder' disabled='true' selected='true' value='0'><liferay-ui:message key='please-select-training-site' /></option>");
			$("#<portlet:namespace/>rotation").append("<option class='placeholder' disabled='true' selected='true' value='0'><liferay-ui:message key='please-select-rotation' /></option>");
			$("#<portlet:namespace/>cohort").append("<option class='placeholder' disabled='true' selected='true' value='0'><liferay-ui:message key='please-select-cohort' /></option>");
			for(let i=0; i<jsondata.length; i++){
				$("#<portlet:namespace/>cohort").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
			}
		}
	});
}
function getTrainingSite(){
	let cohort = $("#<portlet:namespace/>cohort").val();
	$.ajax({
		url: '<%=getTrainingSiteURL%>',
		type: 'POST',
		data:{
				<portlet:namespace/>cohort: cohort
			},
		success: function(jsondata)	{
			$("#<portlet:namespace/>trainingSite").empty();
			$("#<portlet:namespace/>rotation").empty();
			$("#<portlet:namespace/>rotation").append("<option class='placeholder' disabled='true' selected='true' value='0'><liferay-ui:message key='please-select-rotation' /></option>");
			$("#<portlet:namespace/>trainingSite").append("<option class='placeholder' disabled='true' selected='true' value='0'><liferay-ui:message key='please-select-training-site' /></option>");
			for(let i=0; i<jsondata.length; i++){
				$("#<portlet:namespace/>trainingSite").append("<option value='"+jsondata[i].trainingSiteId+"'>" + jsondata[i].trainingSiteName + "</option>");
			}
		}
	});
}
function getRotation(){
	let trainingSite = $("#<portlet:namespace/>trainingSite").val();
	$.ajax({
		url: '<%=getRotations%>',
		type: 'POST',
		data:{
				<portlet:namespace/>trainingSite: trainingSite
			},
		success: function(rotationJson){
			$("#<portlet:namespace/>rotation").empty();
			$("#<portlet:namespace/>rotation").append("<option class='placeholder' disabled='true' selected='true' value='0'><liferay-ui:message key='please-select-rotation' /></option>");
			for(let i=0; i<rotationJson.length; i++){
				$("#<portlet:namespace/>rotation").append("<option value='"+rotationJson[i].rotationMasterId+"'>" + rotationJson[i].rotationName + "</option>");
			}
		}
	});
}

$(document).on("click",".openDeleteModal", function(){
	$('#<portlet:namespace/>progdurationRotationTsRelId').val($(this).data('id'));
});
$(document).ready(function(){
	$('#siteCapacityTable').DataTable({
	    "sDom": 'Rfrtlip',
	 });
	$(".modal-backdrop").remove();
});
</script>