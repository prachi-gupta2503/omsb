<%@ include file="init.jsp" %>
<liferay-ui:error key="duplicateError" message="already-exists" />
<liferay-ui:error key="duplicateRotation" message="same-rotation" />

<portlet:actionURL name="<%= OmsbConfigureRotationsWebPortletKeys.SAVE_CONFIGURE_ROTATIONS_MVC_ACTION_COMMAND %>" var="saveConfigureRotationURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>
<portlet:resourceURL id="<%= OmsbConfigureRotationsWebPortletKeys.GET_PROGRAM_DURATION_MVC_RESOURCE_COMMAND %>" var="programDurationList" />
<portlet:resourceURL id="<%= OmsbConfigureRotationsWebPortletKeys.GET_TRAINEE_LEVEL_MVC_RESOURCE_COMMAND %>" var="getTraineeLevelURL" />
<portlet:resourceURL id="<%= OmsbConfigureRotationsWebPortletKeys.GET_ROTATION_MVC_RESOURCE_COMMAND %>" var="getRotationURL" />

<aui:form action="${saveConfigureRotationURL}" name="fm">
<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle"><liferay-ui:message key="configure-elective-and-core-rotation" /></div>
			</div>
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
						<aui:select cssClass="custom-select form-control" label="select-program" id="programMasterId" name="programMasterId" onchange="getDuratrion(this.value);">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program" /></aui:option>
								<c:forEach items="${programLists}" var="program">
									<aui:option value="${program.programMasterId}">${program.getProgramName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="program-cohort" id="programDuration" name="programDuration" onChange="getTraineeLevel(this.value);">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-cohort" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="trainee-level" id="traineeLevel" name="traineeLevel">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-trainee-level" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
				</div>
			</div>
			<div id="rotation-data">
			<div id="mainDiv" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
				<div class="omsb-list-filter pb-0">
					<div class="row">
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="rotation" id="rotation${0}" name="rotation${0}" >
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>
								<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="rotation-type" id="rotationType${0}" name="rotationType${0}" >
								<c:forEach items="${rotationTypes}" var="rotationType">
									<aui:option value="${rotationType.rotationTypeMasterId}">${rotationType.getRotationTypeName(locale)}</aui:option>
								</c:forEach>
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-type" /></aui:option>
								<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
									<aui:input label="blocks" class="custom-select form-control" type="number" name="blocks${0}" min="0" step="1">
										<aui:validator name="required" />
									</aui:input>
							</div>
						</div>
					</div>
					<div class="filter-button-wrap flex">
						<button class="btn omsb-bc-red-button" onClick="addBlock()">Add</button>
						<button class="btn omsb-bg-red-button" onClick="removeBlock()">Discard</button>
					</div>

				</div>
			</div>
			
			</div>
			
			<div class="bottom-backbtn-wrap mt-0 mb-5">
					<aui:input label="count" type="hidden" name="configureRotationCount"  value="0" />
				<aui:button cssClass="btn omsb-bc-red-button" name="save" type="submit" value="save" ></aui:button>
				<a class="btn omsb-btn omsb-bg-red-button" onClick="reset()" title="Reset"><liferay-ui:message key="reset" /></a>
			</div>
		</div>
	</div>
</div>
</aui:form>

<div class="row">
	<jsp:include page="/configure-rotations-list.jsp" />
</div>

<script type="text/javascript">
function reset(){
	var rotationCount = $("#<portlet:namespace/>configureRotationCount").val();
	$('#rotation-data').hide();
	var count = parseInt(rotationCount);
	for(let i=1; i<=count; i++){
		$("#childDiv" + i ).remove();
	}
	$("#<portlet:namespace/>programDuration").empty();
	$("#<portlet:namespace/>traineeLevel").empty();
	$("#<portlet:namespace/>programDuration").append("<option value='0' selected='true' disabled='true' Class='placeholder' > <liferay-ui:message key='please-select-program-cohort' /> </option>");
	$("#<portlet:namespace/>traineeLevel").append("<option value='0' selected='true' disabled='true' Class='placeholder'><liferay-ui:message key='please-select-trainee-level' /> </option>");
	$("#<portlet:namespace/>configureRotationCount").val(0);
}

function addBlock() {
	var rotationCount = $("#<portlet:namespace/>configureRotationCount").val();
	var count = parseInt(rotationCount)+1;
	$("#<portlet:namespace/>configureRotationCount").val(count);
	var pohortCardDiv = `<div id="childDiv\${count}" class="omsb-card omsb-card-graybg omsb-BorderRadius-4 padding-cohort">
		<div class="omsb-list-filter pb-0">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control" label="rotation" id="rotation\${count}" name="rotation\${count}" >
						<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>
						<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select cssClass="custom-select form-control" label="rotation-type" id="rotationType\${count}" name="rotationType\${count}" >
						<c:forEach items="${rotationTypes}" var="rotationType">
							<aui:option value="${rotationType.rotationTypeMasterId}">${rotationType.getRotationTypeName(locale)}</aui:option>
						</c:forEach>
						<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation-type" /></aui:option>
						<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<label><liferay-ui:message key="blocks" /></label>
					<input class="custom-select form-control" type="number" id="blocks\${count}" name="<portlet:namespace/>blocks\${count}" min="0" step="1" required />
					</div>
				</div>

			</div>
			<div class="filter-button-wrap flex">
			<button class="btn omsb-bg-red-button" id="\${count}" onClick="removeBlock(this.id)"><liferay-ui:message key="discard" /></button>
			</div>

		</div>
	</div>`;
$("#mainDiv").after(pohortCardDiv);
$('#<portlet:namespace/>rotation0 option').clone().appendTo('#<portlet:namespace/>rotation'+count);

}

function removeBlock(id){
	$("#childDiv" + id ).remove();
}


function getDuratrion(programMasterId) {
	$.ajax({
		url : '<%=programDurationList%>',
		type : 'POST',
		data : {
			<portlet:namespace/>programMasterId : programMasterId
		},
		success : function(data) {
			let jsondata = JSON.parse(data);
			$("#<portlet:namespace/>programDuration").empty();
			$("#<portlet:namespace/>traineeLevel").empty();
			$("#<portlet:namespace/>programDuration").append("<option value='0' selected='true' disabled='true' Class='placeholder' > <liferay-ui:message key='please-select-program-cohort' /> </option>");
			$("#<portlet:namespace/>traineeLevel").append("<option value='0' selected='true' disabled='true' Class='placeholder'><liferay-ui:message key='please-select-trainee-level' /> </option>");
			for(let i=0; i<jsondata.length; i++){
				$("#<portlet:namespace/>programDuration").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
			}
			$('#rotation-data').hide();
		}
	});
}

function getTraineeLevel(programDuration){
	$.ajax({
		url: '<%=getTraineeLevelURL%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>programDuration: programDuration
			},
		success: function(data)	
		{
			let traineeLevelJson = JSON.parse(data);
			$("#<portlet:namespace/>traineeLevel").empty();
			$("#<portlet:namespace/>traineeLevel").append("<option value='0' selected='true' disabled='true' Class='placeholder'><liferay-ui:message key='please-select-trainee-level' /> </option>");
			for(let i=0; i<traineeLevelJson.length; i++){
				$("#<portlet:namespace/>traineeLevel").append("<option value='"+traineeLevelJson[i].traineeLevelId+"'>" + traineeLevelJson[i].traineeLevelName + "</option>");
			}
			
		}
	});
	getRotation(programDuration);
}

function getRotation(programDuration){
	$.ajax({
		url: '<%=getRotationURL%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>programDuration: programDuration
			},
		success: function(data)	
		{
			let rotationJson = JSON.parse(data);	
			var rotationCount = $("#<portlet:namespace/>configureRotationCount").val();
			for(let rotation=0; rotation<=rotationCount; rotation++){
				$("#<portlet:namespace/>rotation"+rotation).empty();
				$("#<portlet:namespace/>rotation"+rotation).append("<option value='0' selected='true' disabled='true' Class='placeholder'><liferay-ui:message key='please-select-rotation'/> </option>");
				for(let i=0; i<rotationJson.length; i++){
					$("#<portlet:namespace/>rotation"+rotation).append("<option value='"+rotationJson[i].rotationMasterId+"'>" + rotationJson[i].rotationName + "</option>");
				}			
			}
			$('#rotation-data').show();
		}
	});
}
</script>

